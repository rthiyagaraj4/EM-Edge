package eBL;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class BLFutOrdInsApprTrackExportExcel extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request,	HttpServletResponse response) 
		throws javax.servlet.ServletException,IOException {
		System.out.println("In BLFutOrdInsApprTrackExportExcel -----");
	
		java.util.Properties p = null;
		HttpSession session = null;
		String actionId = (String)request.getParameter(("actionId"));
		System.out.println("Action to be performed : "+actionId);
		Connection conn=null;
		String facilityId		= "";
		String locale			= "";
		CallableStatement callStmt = null;
		//ResultSet rset = null;   //audit log 19-09-2022
		//Statement stmt =  null;   //audit log 19-09-2022
		String reportId 		= "BLRFORD";
		String moduleId 		= "BL";
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;
		
		
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue("jdbc");
		facilityId = (String) session.getValue("facility_id");
		conn = ConnectionManager.getConnection(request);
		locale = p.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        
		 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.addHeader("Content-Disposition", "inline");
		response.setHeader("Content-Disposition","attachment;filename="+reportId+"-"+timestamp+".csv");
			
		
		try {
				
			java.util.Date dNow = new java.util.Date();
			java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm"); 
			String repGenDateTime		= ft.format(dNow);
			
						
			String repHdr		= "";
			String repRes		= "";
			String repCellWidth	= "";
			String repQuery		= "";
			String repQuery1		= "";
			String argumentList	= "";
			
			pstmt = conn.prepareStatement("select REP_COL_HDR,REP_COL_RES,REP_COL_WIDTH,REP_QUERY,REP_QUERY1,REP_ARGS from SM_REP_EXL_EXPORT where REPORT_ID = '"+reportId+"' ");
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				repHdr	= checkForNull(rs.getString("REP_COL_HDR"));//Header 
				repRes	= checkForNull(rs.getString("REP_COL_RES"));//Result Columns
				repCellWidth	= checkForNull(rs.getString("REP_COL_WIDTH"));//Cell Width
				repQuery	= checkForNull(rs.getString("REP_QUERY"));//Query
				repQuery1	= checkForNull(rs.getString("REP_QUERY1"));//Query
				argumentList	= checkForNull(rs.getString("REP_ARGS"));//Arguments
			}

			repQuery	= repQuery + " "+ repQuery1;

			if(pstmt != null)    pstmt.close();
			if(rs != null)    rs.close();
			
			ArrayList<String> resColumnsArr = new ArrayList<String>();
			ArrayList<String> resColumnsWidthArr = new ArrayList<String>();
			StringTokenizer resultTokens=new StringTokenizer(repRes,",");
			StringTokenizer repCellWidthTokens=new StringTokenizer(repCellWidth,",");
			
			while(resultTokens.hasMoreTokens() && repCellWidthTokens.hasMoreTokens()){
				String resCol	= resultTokens.nextToken();
				String resColWidth	= repCellWidthTokens.nextToken();
				resColumnsArr.add(resCol);
				resColumnsWidthArr.add(resColWidth);
			}
			
			
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(reportId);

			String hdrSql =  "{call get_header_dtls(?,?,?,?,?,?,?,?)}";
			callStmt = conn.prepareCall(hdrSql);
			callStmt.setString(1, moduleId);
			callStmt.setString(2, reportId);
			callStmt.setString(3, facilityId);
			callStmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			callStmt.setString(8, locale);
			String reportName 		= "";
			String reportExecName 	= "";
			String facilityName 	= "";
			String siteName 		= "";

			try{
				callStmt.execute();
				reportName 		= callStmt.getString(4);
				reportExecName 	= callStmt.getString(5);
				facilityName 	= callStmt.getString(6);
				siteName 		= callStmt.getString(7);
			} catch(Exception e1) {
				e1.printStackTrace();
			} finally{
				callStmt.close();
			}
			int i=1;
			int rowCount =1;
			HSSFRow row = null;
			
			
			HSSFFont font = workbook.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short)12);
			HSSFCellStyle style = workbook.createCellStyle();
			style.setFont(font);

			HSSFCellStyle style1=workbook.createCellStyle();
			style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style1.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);


			Region cellRegion1 = new Region(1, (short)3, 1, (short)4); 
			Region cellRegion2 = new Region(2, (short)3, 2, (short)4); 
			Region cellRegion3 = new Region(3, (short)3, 3, (short)4); 
			sheet.addMergedRegion(cellRegion1);
			sheet.addMergedRegion(cellRegion2);
			sheet.addMergedRegion(cellRegion3);
			
			row				= sheet.createRow(rowCount++);
			HSSFCell hc1	= row.createCell(3);	
			hc1.setCellValue(siteName);
			hc1.setCellStyle(style);
			
			HSSFCell hc4	= row.createCell(5);	
			hc4.setCellValue(repGenDateTime);
			hc4.setCellStyle(style1);

			row				= sheet.createRow(rowCount++);
			HSSFCell hc2	= row.createCell(3);	
			hc2.setCellValue(facilityName);
			hc2.setCellStyle(style);

			row = sheet.createRow(rowCount++);
			HSSFCell hc3 = row.createCell(3);	
			hc3.setCellValue(reportName);
			hc3.setCellStyle(style);

			rowCount	= rowCount+2;

			i=0;
			row = sheet.createRow(rowCount);
		
			
	
		HSSFCellStyle style2=workbook.createCellStyle();

		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			/*Generating Header*/
			StringTokenizer hdrTokens=new StringTokenizer(repHdr,"~");
			repCellWidthTokens=new StringTokenizer(repCellWidth,",");
			while(hdrTokens.hasMoreTokens() && repCellWidthTokens.hasMoreTokens()){
				String hdr 			= hdrTokens.nextToken(); 
				int width 			= Integer.valueOf(repCellWidthTokens.nextToken()); 
				HSSFCell c1 		= row.createCell(i);	
				c1.setCellValue(hdr);
				sheet.setColumnWidth(i, width);
				c1.setCellStyle(style2);
				i++;
			}
			


			/*Replacing Arguments List with Query*/
			StringTokenizer argumentListTokens=new StringTokenizer(argumentList,",");
			while(argumentListTokens.hasMoreTokens()){
				String arg	= argumentListTokens.nextToken();
				String reqArg	= arg.substring(1);
				String argVal	= "'"+checkForNull(request.getParameter(reqArg))+"'";
				if(!arg.equals(":"))
					repQuery		= repQuery.replaceAll(arg, argVal);
			}
			
			rowCount++;
			i=0;
			
			HSSFCellStyle styleRes=workbook.createCellStyle();

			styleRes.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleRes.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleRes.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleRes.setBorderLeft(HSSFCellStyle.BORDER_THIN);

			
			
			if(!repQuery.equals("")){
				System.err.println("repQuery:"+repQuery);
				pstmt = conn.prepareStatement(repQuery);
				rs = pstmt.executeQuery();
				
				JSONArray arrJSON		= new JSONArray();
				while(rs!=null && rs.next()){
					JSONObject json			= new JSONObject();
					for(int c=0;c<resColumnsArr.size();c++){
						int width 			= Integer.valueOf(resColumnsWidthArr.get(c));
						json.put(resColumnsArr.get(c), checkForNull(rs.getString(resColumnsArr.get(c))));
						json.put(resColumnsArr.get(c)+"_width", width);
						
					}
					arrJSON.add(json);
				}
				
				if(pstmt != null)    pstmt.close();
				if(rs != null)    rs.close();
				for(int count=0;count<arrJSON.size();count++){
					i=0;
					row = sheet.createRow(rowCount);
					JSONObject objects = (JSONObject)arrJSON.get(count);
					for(int k=0;k<resColumnsArr.size();k++){
						String resCol  		= (String) objects.get(resColumnsArr.get(k));;
						Integer resColWidth  = (Integer) objects.get(resColumnsArr.get(k)+"_width");
						int width 			= Integer.valueOf(resColWidth);

						HSSFCell cc 		= row.createCell(i);	
						cc.setCellValue(resCol);
						sheet.setColumnWidth(i,width );
						cc.setCellStyle(styleRes);
						i++;
					}
					rowCount++;			
				}
			}
			workbook.write(response.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectionManager.returnConnection(conn, request);
			
		}
	}


	public static String checkForNull(String inputString) {
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}
}
