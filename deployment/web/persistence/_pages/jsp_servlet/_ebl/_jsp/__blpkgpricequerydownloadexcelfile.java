package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eBL.Common.*;

public final class __blpkgpricequerydownloadexcelfile extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPkgPriceQueryDownloadExcelFile.jsp", 1709114110427L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n23-Oct-2012      100           \tKarthikeyan.K       created\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );


PreparedStatement pst =null;
ResultSet rs =null;
HSSFWorkbook workbook = null;	

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
 
public void createExcelFile(Connection con,HashMap<String,String> sqlList){

	try {
		workbook = new HSSFWorkbook();
		
		TreeSet<String> ts= new TreeSet<String>( sqlList.keySet() );
		Iterator<String> it=ts.iterator();
		
		while(it.hasNext()){
			String key=it.next().toString();
			System.out.println(key);
				
			pst = con.prepareStatement(sqlList.get(key));
			rs = pst.executeQuery();
			HSSFSheet sheet = workbook.createSheet(key); 
			int rownum = 0; 
			int cellnum = 0; 
			HSSFRow row = null;
			HSSFCell cell =null;
			
			//Color Parameters are provided here
			HSSFCellStyle hssfstyle = (HSSFCellStyle) workbook.createCellStyle();
			hssfstyle.setFillForegroundColor(HSSFColor.CORNFLOWER_BLUE.index);
			hssfstyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	

			
			//This Prints first column name	by Reading from MetaData	
			ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumnCount = rsmd.getColumnCount();
			
			row=sheet.createRow(rownum++); 
			cellnum = 0;
			for(int columnNo=1;columnNo<=totalColumnCount;columnNo++){
				cell = row.createCell(cellnum++); 
				cell.setCellValue(rsmd.getColumnName(columnNo));
				cell.setCellStyle(hssfstyle);	
				sheet.autoSizeColumn((short)(columnNo-1)); // auto-expands column number in index 
			}

			
			//This Prints Data Retrieved from the Database
			while (rs.next()) {
				row = sheet.createRow(rownum++); 			
				cellnum = 0; 
				for(int columnNo=1;columnNo<=totalColumnCount;columnNo++){
				cell = row.createCell(cellnum++); 
				cell.setCellValue(nulltoStr(rs.getString(columnNo)));
				}
			}
								
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			con.close();
			pst.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}

/*
 * This method returns Empty String("") for null value, otherwise the
 * original string will be returned
 */
private String nulltoStr(String inputString){
	if(inputString==null){
		return "";
	}
	else{
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

Connection con = ConnectionManager.getConnection();

HashMap<String,String> sqlList=new HashMap<String,String>();

String jobId=request.getParameter("jobId");
if(jobId==null) jobId="";
String queryAppend="";
String queryAppendReq = "";
if(!"".equals(jobId)){
	queryAppend = " AND (req.operating_facility_id,req.session_id,req.pgm_date,req.user_id) in (select  operating_facility_id,session_id,pgm_date,user_id from bl_package_price_updtn_req  where job_no = "+jobId+" )";
	queryAppendReq = " and req.job_no  = "+jobId+" ";
}
else{
	queryAppend = " AND job_no = '' ";
	queryAppendReq = " and req.job_no  = '' ";
}

String sql = "";

sql= BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_PRICE") + queryAppend + " union "+ BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_PRICE_REQ") + queryAppendReq+ " union "+ BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_PRICE_REQ_FOR_STAR") + queryAppendReq;
sqlList.put("PROCESSED_WITH_ERROR_PRICE", sql);
sql= BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITHOUT_ERROR_PRICE") + queryAppend;
sqlList.put("PROCESSED_WITHOUT_ERROR_PRICE", sql);
sql= BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_DISC") + queryAppend + " union "+ BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_DISC_REQ") + queryAppendReq+ " union "+ BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_DISC_REQ_FOR_STAR") + queryAppendReq;
sqlList.put("PROCESSED_WITH_ERROR_DISC", sql);
sql= BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITHOUT_ERROR_DISC") + queryAppend;
sqlList.put("PROCESSED_WITHOUT_ERROR_DISC", sql);

System.out.println(sqlList);

String outputFileName="JOBS_PROCESSED_JOBID_"+jobId+".xls";
createExcelFile(con, sqlList);

 // Init servlet response.
 response.reset();
 response.setContentType("application/vnd.ms-excel");
 response.setHeader("Content-Disposition", "attachment; filename=\"" +outputFileName + "\"");

 // Prepare streams.
 BufferedOutputStream output = null;
 try {
     // Open streams.
     output = new BufferedOutputStream(response.getOutputStream());
	 workbook.write(output); 
	 
 } finally {
     // Gently close streams.
     output.flush();
     output.close();
	 ConnectionManager.returnConnection(con,request);
 }
 /* The Below code is used to download Excel File to Desktop - Ends*/
 

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
