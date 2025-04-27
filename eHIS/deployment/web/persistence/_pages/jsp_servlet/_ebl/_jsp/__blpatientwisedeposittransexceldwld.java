package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.op.CurrencyFormat;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eBL.*;
import com.ehis.util.*;
import eBL.Common.*;
import java.io.BufferedOutputStream;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;

public final class __blpatientwisedeposittransexceldwld extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/ebl/jsp/BLPatientWiseDepositTransExcelDwld.jsp", 1709114109584L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n02-FEB-2018      100           Gayathri R         Created\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<body>\n\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

	PreparedStatement pst = null;
	ResultSet rs = null;
	HSSFWorkbook workbook = null;
	Statement stmt = null;

	/**
	 * This method generates Excel Sheet for any Query/Queries provided by User.
	 * This also provides support for multiple sheet Generation in Same Excel sheet.
	 * The Input(sqlList) is provided as (QUERY_KEY, QUERY) pairs.The output will be Query Result/Results in Excel file.
	 * For multiple queries, QUERY_KEY will be used as Sheet name and its corresponding result will be generated in
	 * that sheet.So the Result is one Excel file with multiple Sheets.
	 * 
	 * @param  con  Connection needs to be provided
	 * @param  sqlList In this HashMap (SQL_NAME,SQL_QUERY) combination needs to be provided. 
	 * The SQL_QUERY will be executed and its results are displayed in Excel sheet.
	 * The SQL_NAME will be the Sheet Name in the Generated Excel file.
	 * For Example if HashMap contains 10 pairs of (SQL_NAME,SQL_QUERY), 
	 * then the generated Excel file will have 10 Sheets with provided SQL_NAMES.
	 *   
	 */

	public void createExcelFile(Connection con, String facilityId,
			String locale, String loggedUser, String fromPatId, String toPatId) {

		try {

			String sysDateQry = "select to_char(sysdate,'dd-Mon-yyyy') dates, to_char(sysdate,'hh24:mi:ss') times from dual";

			int rowId = 0, colId = 0, noofdecimal = 0;
			String currDate = "", currTime = "";
			double totalCr = 0, totalDr = 0;
			
			BLPatientWiseDepositTrans splTrans = new BLPatientWiseDepositTrans();
			
			splTrans = splTrans.getDetailsFromDB(con, facilityId, locale, loggedUser, fromPatId, toPatId);

			HashMap<String, String> legendMap = splTrans.getLegendMap();
			LinkedHashMap<String, List<BLPatientWiseTransModel>> transMap = splTrans.getTransMap();

			Set<String> patIdList = transMap.keySet();
			
			CurrencyFormat cf = new CurrencyFormat();

			HSSFRow row = null;
			HSSFCell cell = null;

			stmt = con.createStatement();

			rs = stmt.executeQuery(sysDateQry);

			while (rs.next()) {
				currDate = rs.getString("dates");
				currTime = rs.getString("times");
			}

			rs.close();

			pst = con.prepareStatement("select blcommon.get_decimal_place('"
					+ facilityId + "') from dual");

			rs = pst.executeQuery();
			if (rs.next() && rs != null) {
				noofdecimal = rs.getInt(1);
			}

			rs.close();

			//new workbook created
			workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Sheet1");

			sheet.autoSizeColumn((short) 3);

			//creating new cellstyle
			HSSFCellStyle styleBold = workbook.createCellStyle();
			HSSFFont fontBold = workbook.createFont();
			fontBold.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			styleBold.setFont(fontBold);
			
			HSSFCellStyle styleRight = workbook.createCellStyle();
			styleRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			
			HSSFCellStyle styleBoldRight = workbook.createCellStyle();
			styleBoldRight.setFont(fontBold);
			styleBoldRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);

			//creating new cellstyle
			HSSFCellStyle styleAllBorder = workbook.createCellStyle();
			styleAllBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleAllBorder.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleAllBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleAllBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);
			
			HSSFCellStyle styleBoldRightAllBorder = workbook.createCellStyle();
			styleBoldRightAllBorder.setFont(fontBold);
			styleBoldRightAllBorder.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleBoldRightAllBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleBoldRightAllBorder.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleBoldRightAllBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleBoldRightAllBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);
			
			HSSFCellStyle styleRightAllBorder = workbook.createCellStyle();
			styleRightAllBorder.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleRightAllBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleRightAllBorder.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleRightAllBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleRightAllBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);
			
			HSSFCellStyle styleBoldAllBorder = workbook.createCellStyle();
			styleBoldAllBorder.setFont(fontBold);
			styleBoldAllBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleBoldAllBorder.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleBoldAllBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleBoldAllBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);
			
			HSSFCellStyle styleBoldCenter = workbook.createCellStyle();
			styleBoldCenter.setFont(fontBold);
			styleBoldCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
System.out.println("xxx "+legendMap.get("BLRPPAD.LEGEND_010"));
			//creating new row
			row = sheet.createRow(rowId);

			cell = row.createCell(colId);
			cell.setCellValue(nulltoStr(legendMap.get("BLRPPAD.LEGEND_010")));
			cell.setCellStyle(styleBold);
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(":");
			cell.setCellStyle(styleBold);
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue("BL");
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(nulltoStr(splTrans.getFacilityName()));
			cell.setCellStyle(styleBold);
			sheet.addMergedRegion(new CellRangeAddress(rowId, rowId, colId,
					++colId));
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(nulltoStr(legendMap.get("BLRPPAD.LEGEND_050")));
			cell.setCellStyle(styleBold);
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(":");
			cell.setCellStyle(styleBold);
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(currDate);
			colId++;

			//creating new row
			colId = 0;//resetting colId to 0
			rowId++;
			row = sheet.createRow(rowId);

			cell = row.createCell(colId);
			cell.setCellValue(nulltoStr(legendMap.get("BLRPPAD.LEGEND_020")));
			cell.setCellStyle(styleBold);
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(":");
			cell.setCellStyle(styleBold);
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(nulltoStr(loggedUser));
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(nulltoStr(splTrans.getHospitalAddress()));
			cell.setCellStyle(styleBold);
			sheet.addMergedRegion(new CellRangeAddress(rowId, rowId, colId,
					++colId));
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(nulltoStr(legendMap.get("BLRPPAD.LEGEND_060")));
			cell.setCellStyle(styleBold);
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(":");
			cell.setCellStyle(styleBold);
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(currTime);
			colId++;

			//creating new row
			colId = 0;//resetting colId to 0
			rowId++;
			row = sheet.createRow(rowId);

			cell = row.createCell(colId);
			cell.setCellValue(nulltoStr(legendMap.get("BLRPPAD.LEGEND_040")));
			cell.setCellStyle(styleBold);
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(":");
			cell.setCellStyle(styleBold);
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue("BLRPPAD");
			colId++;

			cell = row.createCell(colId);
			cell.setCellValue(nulltoStr(legendMap.get("BLRPPAD.LEGEND_210"))+
					nulltoStr(splTrans.getGstNo()));
			cell.setCellStyle(styleBold);
			sheet.addMergedRegion(new CellRangeAddress(rowId, rowId, colId,
					++colId));
			colId++;

			//creating new row
			colId = 0;//resetting colId to 0
			rowId++;
			row = sheet.createRow(rowId);

			cell = row.createCell(colId);
			cell.setCellValue(nulltoStr(legendMap.get("BLRPPAD.LEGEND_080")));
			cell.setCellStyle(styleBoldCenter);
			sheet.addMergedRegion(new CellRangeAddress(rowId, rowId, 0, 8));
			colId++;
			
			//creating new row
			colId = 0;//resetting colId to 0
			rowId++;
			row = sheet.createRow(rowId);
			
			for (String itr : patIdList) {
				
				List<BLPatientWiseTransModel> recordList = transMap.get(itr);
				
				totalDr = 0;
				totalCr = 0;
				
				//creating new row
				colId = 0;//resetting colId to 0
				rowId++;
				row = sheet.createRow(rowId);

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_180")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(":");
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(itr));
				cell.setCellStyle(styleAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_190")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(":");
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(recordList.get(0).getPatientName()));
				cell.setCellStyle(styleAllBorder);
				colId++;
				
				cell = row.createCell(colId);
				cell.setCellValue("");
				cell.setCellStyle(styleBoldAllBorder);
				colId++;
				
				cell = row.createCell(colId);
				cell.setCellValue("");
				cell.setCellStyle(styleBoldAllBorder);
				colId++;
				
				cell = row.createCell(colId);
				cell.setCellValue("");
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				//creating new row
				colId = 0;//resetting colId to 0
				rowId++;
				row = sheet.createRow(rowId);

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_090")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_100")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_110")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_120")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_130")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;
				
				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_220")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_140")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_150")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_160")));
				cell.setCellStyle(styleBoldAllBorder);
				colId++;

				for (int j = 0; j < recordList.size(); j++) {
					
					BLPatientWiseTransModel model = recordList.get(j);
					
					//creating new row
					colId = 0;//resetting colId to 0
					rowId++;
					row = sheet.createRow(rowId);

					cell = row.createCell(colId);
					cell.setCellValue(nulltoStr(model.getEncounterId()));
					cell.setCellStyle(styleAllBorder);
					colId++;

					cell = row.createCell(colId);
					cell.setCellValue(nulltoStr(model.getEpisodeType()));
					cell.setCellStyle(styleAllBorder);
					colId++;

					cell = row.createCell(colId);
					cell.setCellValue(nulltoStr(model.getDocumentDate()));
					cell.setCellStyle(styleAllBorder);
					colId++;

					cell = row.createCell(colId);
					cell.setCellValue(nulltoStr(model.getDocumentNumber()));
					cell.setCellStyle(styleAllBorder);
					colId++;

					cell = row.createCell(colId);
					cell.setCellValue(nulltoStr(model.getDocumentType()));
					cell.setCellStyle(styleAllBorder);
					colId++;
					
					cell = row.createCell(colId);
					cell.setCellValue(nulltoStr(model.getPackagedtl()));
					cell.setCellStyle(styleAllBorder);
					colId++;

					cell = row.createCell(colId);
					cell.setCellValue(cf.formatCurrency(model.getAmountDr().trim(), noofdecimal));
					cell.setCellStyle(styleRightAllBorder);
					colId++;

					cell = row.createCell(colId);
					cell.setCellValue(cf.formatCurrency(model.getAmountCr().trim(), noofdecimal));
					cell.setCellStyle(styleRightAllBorder);
					colId++;

					cell = row.createCell(colId);
					cell.setCellValue(cf.formatCurrency(model.getAmountBal().trim(), noofdecimal));
					cell.setCellStyle(styleRightAllBorder);
					colId++;
					
					totalDr += Double.parseDouble(model.getAmountDr());
					totalCr += Double.parseDouble(model.getAmountCr());
				}
				
				//creating new row
				colId = 5;//resetting colId to 4
				rowId++;
				row = sheet.createRow(rowId);

				cell = row.createCell(colId);
				cell.setCellValue(nulltoStr(legendMap
						.get("BLRPPAD.LEGEND_170"))+":");
				cell.setCellStyle(styleBoldRightAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(cf.formatCurrency(String.valueOf(totalDr), noofdecimal));
				cell.setCellStyle(styleBoldRightAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(cf.formatCurrency(String.valueOf(totalCr), noofdecimal));
				cell.setCellStyle(styleBoldRightAllBorder);
				colId++;

				cell = row.createCell(colId);
				cell.setCellValue(cf.formatCurrency(String.valueOf(totalCr - totalDr), noofdecimal));
				cell.setCellStyle(styleBoldRightAllBorder);
				colId++;
				
				//creating new row
				colId = 0;//resetting colId to 0
				rowId++;
				row = sheet.createRow(rowId);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * This method returns Empty String("") for null value, otherwise the
	 * original string will be returned
	 */
	private String nulltoStr(String inputString) {
		if (inputString == null) {
			return "";
		} else {
			return inputString;
		}
	}

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

		Connection con = ConnectionManager.getConnection();

		String fromPatId = request.getParameter("fromPatId");
		if (fromPatId == null) {
			fromPatId = "";
		}
		String toPatId = request.getParameter("toPatId");
		if (toPatId == null) {
			toPatId = "";
		}

		String locale = (String) session.getAttribute("LOCALE");
		String facilityId = (String) session.getAttribute("facility_id");
		if (facilityId == null) {
			facilityId = "";
		}
		String strLoggedUser = (String) session.getValue("login_user");
		if (strLoggedUser == null) {
			strLoggedUser = "";
		}

		String outputFileName = fromPatId + "-" + toPatId + ".xls";
		createExcelFile(con, facilityId, locale, strLoggedUser, fromPatId,
				toPatId);

		response.reset();
		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ outputFileName);

		// Prepare streams.
		BufferedOutputStream output = null;
		try {
			// Open streams.
			output = new BufferedOutputStream(response.getOutputStream());
			workbook.write(output);

		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("Exception in BLPatientWiseSplAgencyDepositTransExcelDwld: "
							+ e);
		} finally {
			output.flush();
			output.close();
			ConnectionManager.returnConnection(con, request);
		}
	
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
