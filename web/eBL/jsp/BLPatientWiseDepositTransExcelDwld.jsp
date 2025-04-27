<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
02-FEB-2018      100           Gayathri R         Created
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="webbeans.op.CurrencyFormat"%>
<%@page
	import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*,eBL.*,com.ehis.util.*,eBL.Common.*,java.io.BufferedOutputStream"%>
<%@ page
	import="org.apache.poi.hssf.usermodel.*,org.apache.poi.hssf.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<%!
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
	}%>
	<%
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
	%>
</body>
</html>
