<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
23-Oct-2012      100           	Karthikeyan.K       created
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%-- <%@ page    import="eBL.ExcelWriterBean"	%> --%>

<%@ page    import="org.apache.poi.hssf.usermodel.*,org.apache.poi.hssf.util.*"	%>
<%@ page    import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.io.*,eBL.Common.*"%>

<%!

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
%>

<%
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
 
%>
