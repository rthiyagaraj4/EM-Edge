/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------
08/05/2019		IN69021			Ramesh G			?				?				MMS-DM-CRF-0150
24/12/2021		6868			Ramesh G			24/12/2021		Ramesh G 		AAKH-CRF-0125
--------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;

public class MDSForDiagnosisMandatoryServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = null;
		try{			
			out = response.getWriter();			
			insert(request, response);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	/************************************Insert***********************************/
	private void insert(HttpServletRequest request, HttpServletResponse response){
		
		java.util.Properties p;
		HttpSession session;
			
		String added_by_id 			= "";
		String added_at_ws_no 		= "";
		String added_facility_id 	= "";
		
		String client_ip_address	= "";
		String error_value 			= "0";
		String error_message		= "";
		int totalRec 				= 0;
		String minimumData  		= "";
		String termsetId			= "";
		String primaryDiagnosisYN	= ""; //6868
		int selectedRec				= 0;
		int [] insertedRec			= null;
		Connection con 				= null;
		PreparedStatement pstmt 	= null;
		
		//HashMap tableChart = new HashMap(); //COMMON-ICN-0122
		session   = request.getSession(false);
		p         = (java.util.Properties)session.getValue("jdbc");
		String locale       = (String) p.getProperty("LOCALE");
		//java.util.Locale loc = new java.util.Locale(locale); //COMMON-ICN-0122
		client_ip_address   = p.getProperty("client_ip_address");
		
		added_by_id 		= (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		added_facility_id   = (String)session.getValue("facility_id");
		added_at_ws_no 		= (client_ip_address == null)?"":client_ip_address; 
		
		try{
			con = ConnectionManager.getConnection(request);
			totalRec 	= Integer.parseInt((String)request.getParameter("totalRec"));
			selectedRec	= Integer.parseInt((String)request.getParameter("selectedRec"));
			minimumData = (String)request.getParameter("minimumData");
			termsetId	 = (String)request.getParameter("termsetId");
			
			// 6868 Start.
			primaryDiagnosisYN= (String)request.getParameter("primaryDiagnosisYN");  
			
			String deleteHdrQuery ="DELETE  FROM OR_MDS_DIAGNOSIS_MAND_HDR WHERE TERM_SET_ID=? AND MINUMUM_DATA_TYPE=?";
			
			pstmt = con.prepareStatement(deleteHdrQuery);
			pstmt.setString(1,termsetId);
			pstmt.setString(2,minimumData);
			pstmt.executeUpdate();
			
			if(pstmt != null) pstmt.close();
			String insertHdrQuery = "INSERT INTO OR_MDS_DIAGNOSIS_MAND_HDR (TERM_SET_ID,MINUMUM_DATA_TYPE,PRIMARY_DIAGNOSIS_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			pstmt = con.prepareStatement(insertHdrQuery);
			
			pstmt.setString(1,termsetId);
			pstmt.setString(2,minimumData);
			pstmt.setString(3,primaryDiagnosisYN);
			pstmt.setString(4,added_by_id);
			pstmt.setString(5,added_at_ws_no);
			pstmt.setString(6,added_facility_id);
			pstmt.setString(7,added_by_id);
			pstmt.setString(8,added_at_ws_no);
			pstmt.setString(9,added_facility_id);
			pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();
			// 6868 End.
			
			String deleteQuery ="DELETE  FROM OR_MDS_DIAGNOSIS_MAND WHERE TERM_SET_ID=? AND MINUMUM_DATA_TYPE=?";
			
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1,termsetId);
			pstmt.setString(2,minimumData);
			pstmt.executeUpdate();
			
			if(pstmt != null) pstmt.close();
			
			String insertStuAllQuery = "INSERT INTO OR_MDS_DIAGNOSIS_MAND (TERM_SET_ID,MINUMUM_DATA_TYPE,APPLIED_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			pstmt = con.prepareStatement(insertStuAllQuery);
			for(int j=0;j<totalRec;j++){
				String selectedId =request.getParameter("CI_"+j);
				String selectedVal =request.getParameter("CV_"+j);
				if("Y".equals(selectedVal)){
					pstmt.setString(1,termsetId);
					pstmt.setString(2,minimumData);
					pstmt.setString(3,selectedId);
					pstmt.setString(4,added_by_id);
					pstmt.setString(5,added_at_ws_no);
					pstmt.setString(6,added_facility_id);
					pstmt.setString(7,added_by_id);
					pstmt.setString(8,added_at_ws_no);
					pstmt.setString(9,added_facility_id);
					pstmt.addBatch();
				}
			}
			insertedRec =  pstmt.executeBatch();;
			if((insertedRec.length)==selectedRec){
				con.commit();
				java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");                
				error_message = (java.lang.String)hashtable.get("message");
				//error_value = "1";
			}else{
				try{
					con.rollback();
				}catch(Exception ee){
					ee.printStackTrace();
				}
				error_message = "Exception raise by Servlet..........So Record Not inserted.";							
			}
			
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error_message,"UTF-8") + "&err_value=" + error_value);
		}
		catch(Exception e){
			System.err.println("Exception in main try :" +e);
			e.printStackTrace();
			try{
				con.rollback();
				error_message="Exception raise by Servlet ...So Record Not inserted  Foll: Error Received : "+ e.toString();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error_message,"UTF-8") + "&err_value=" + error_value);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}finally
		{
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
								
		}
	}
}

