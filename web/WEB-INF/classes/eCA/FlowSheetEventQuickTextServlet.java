/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.text.*;
import webbeans.eCommon.*; 

public class FlowSheetEventQuickTextServlet extends HttpServlet{
	
	/*public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}*/	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		try{
			HttpSession session = request.getSession(false);		
			insertQuickText(request,response,session);
		}
		catch(Exception e)
		{
			out.println("Exception in Post: "+e);
			e.printStackTrace();
		}
	 
	}

	public void insertQuickText(HttpServletRequest req,HttpServletResponse res, HttpSession session){
		PrintWriter out = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement quickTest_pstmt = null;
		ResultSet quickTest_rs = null;

		Properties p = (java.util.Properties) session.getValue("jdbc") ;

		String facility_id = (String)session.getValue("facility_id");
		String practitioner_id = (String)session.getValue("ca_practitioner_id");
		String client_ip_address = client_ip_address = p.getProperty("client_ip_address");

		String strSql="INSERT INTO CA_PRACTITIONER_QUICK_TEXT( HIST_REC_TYPE,CONTR_SYS_ID,ACCESSION_NUM,CONTR_SYS_EVENT_CODE,QUICK_TEXT_REF,QUICK_TEXT,PRACTITIONER_ID,RECORDED_DATETIME,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES( ?,?,?,?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		
		String quickText = req.getParameter("txtRemarks")==null?"":req.getParameter("txtRemarks");
		String histRecTypes = req.getParameter("txtHistRecTypes")==null?"":req.getParameter("txtHistRecTypes");
		String contrSysIds = req.getParameter("txtContrSysIds")==null?"":req.getParameter("txtContrSysIds");
		String accessionNos = req.getParameter("txtAccessionNos")==null?"":req.getParameter("txtAccessionNos");
		String eventCodes = req.getParameter("txtEventCodes")==null?"":req.getParameter("txtEventCodes");
		
		String hist_rec_type = "";
		String contr_sys_id = "";
		String accession_num = "";
		String contr_sys_event_code = "";

		String quick_text_sql = "SELECT MAX(QUICK_TEXT_REF) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND ACCESSION_NUM=? AND CONTR_SYS_EVENT_CODE=?";
		int quick_text_ref = 1;
		
		StringTokenizer strtHistRecTypes = new StringTokenizer(histRecTypes,",");
		StringTokenizer strtContrSysIds = new StringTokenizer(contrSysIds,",");
		StringTokenizer strtAccessionNos = new StringTokenizer(accessionNos,",");
		StringTokenizer strtEventCodes = new StringTokenizer(eventCodes,",");
		
		int counter = strtHistRecTypes.countTokens();
		int noOfRecords = 0;
		try{
			out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement(strSql);
			while(strtHistRecTypes.hasMoreTokens()){
				pstmt.clearParameters();
				hist_rec_type = strtHistRecTypes.nextToken();
				contr_sys_id = strtContrSysIds.nextToken();
				accession_num = strtAccessionNos.nextToken();
				contr_sys_event_code = strtEventCodes.nextToken();

				pstmt.setString(1,hist_rec_type);
				pstmt.setString(2,contr_sys_id);
				pstmt.setString(3,accession_num);
				pstmt.setString(4,contr_sys_event_code);
				
				quickTest_pstmt = con.prepareStatement(quick_text_sql);
				quickTest_pstmt.setString(1,hist_rec_type);
				quickTest_pstmt.setString(2,contr_sys_id);
				quickTest_pstmt.setString(3,accession_num);
				quickTest_pstmt.setString(4,contr_sys_event_code);
				quickTest_rs = quickTest_pstmt.executeQuery();

				while(quickTest_rs.next())
				{
					quick_text_ref = quickTest_rs.getInt(1);
				}
				if(quickTest_rs!=null) quickTest_rs.close();
				if(quickTest_pstmt!=null) quickTest_pstmt.close();


				if(quick_text_ref == 0)
					quick_text_ref = 1;
				else
					quick_text_ref++;

				pstmt.setInt(5,quick_text_ref);
				pstmt.setString(6,quickText);
				pstmt.setString(7,practitioner_id);
				pstmt.setString(8,practitioner_id);
				pstmt.setString(9,client_ip_address);
				pstmt.setString(10,facility_id);
				pstmt.setString(11,practitioner_id);
				pstmt.setString(12,client_ip_address);
				pstmt.setString(13,facility_id);
				noOfRecords+= pstmt.executeUpdate();			
			}

			if(noOfRecords == counter){


				con.commit();
				out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
				out.println("<script>alert('APP-SM0001 Operation Completed Successfully....');");
				out.println("window.close();window.returnValue=1;");
				out.println("</script>");
			}else{
				out.println("Operation Failed...");
				con.rollback();
			}
			
		if(pstmt != null) pstmt.close();
		if(quickTest_rs!=null) quickTest_rs.close();
		if(quickTest_pstmt!=null) quickTest_pstmt.close();

		}catch(Exception e){
			//out.println("Exception in Quick Text: "+e);//common-icn-0181
			
			e.printStackTrace();
		}
		
		finally{
					if(con != null) ConnectionManager.returnConnection(con,req);
				}
	}

}//class
