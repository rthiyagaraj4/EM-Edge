/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
-------------------------------------------------------------------------------------------------------------------------------
14/12/2013	  IN042552		 Karthi L	 To maintain Patient's event confidentiality at Practitioner, Speciality and Responsibility level (Bru-HIMS-CRF-391)
22/12/2013	  IN045870		 Karthi L	  Unable to uncheck the selected records. There is no option to Uncheck the records selected wrongly.
-------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import java.net.URLEncoder;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.RecordSet;

public class CAConfidentialitySetUpServlet extends HttpServlet
{
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		PrintWriter out;
	    Properties p;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
     	Connection con				= null;
		PreparedStatement headerInsertStmt	 = null;
		PreparedStatement deleteHeaderStmt	 = null;
		PreparedStatement deleteChildStmt	 = null;
		PreparedStatement childInsertStmt	 = null;
		PreparedStatement selectHeaderStmt	 = null;
		//PreparedStatement updateHeaderStmt	 = null;//Checkstyle
		ResultSet headerResultset			 = null;
		PreparedStatement selectChildStmt	 = null; //IN045870 
		ResultSet childResultset			 = null; //IN045870
		
		HttpSession httpsession		= request.getSession(false);
        p							= (Properties)httpsession.getValue("jdbc");
		//String locale				= (String) p.getProperty("LOCALE");//checkstyle
		String login_by_id			= p.getProperty("login_user") != null ? p.getProperty("login_user") : "";					
		String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");
		String login_facility_id	= (String)httpsession.getValue("facility_id") ==  null?"": (String)httpsession.getValue("facility_id");
		
		String message1 	= "";
		String message2 	= "0";
		String hist_rec_type		= request.getParameter("hist_rec_type")== null?"":request.getParameter("hist_rec_type");
		String event_type_code			= request.getParameter("eventType")== null?"":request.getParameter("eventType");
		String filter_based_on_ind   = request.getParameter("filter_based_on")== null?"":request.getParameter("filter_based_on");
		String event_code			= request.getParameter("event_codes")== null?"":request.getParameter("event_codes");
		String priv_resp_code		= request.getParameter("priv_resp_code")== null?"":request.getParameter("priv_resp_code");
		String view_list_code		= request.getParameter("view_list_code")== null?"":request.getParameter("view_list_code");
		String based_on_code		= request.getParameter("based_on_code")== null?"":request.getParameter("based_on_code");
		String view_by_code			= request.getParameter("view_by_code")== null?"":request.getParameter("view_by_code");
		String filter_when_click 	= request.getParameter("filter_when_click")== null?"":request.getParameter("filter_when_click");	
		String filter_based_on_unchanged = filter_based_on_ind;
		String l_bean_id		= "Ca_confidentialitySetUpBean";
		String l_bean_name		= "eCA.CAConfidentialitySetUpBean";
		CAConfidentialitySetUpBean beanObj = (CAConfidentialitySetUpBean) com.ehis.persist.PersistenceHelper.getBeanObject(l_bean_id, l_bean_name, request);
		HashMap confdntHashMap = beanObj.getConfidentialityMapData();
		ArrayList confdnKeyList = beanObj.getKeyConfidentDataArrayList();
		int insertedCount = 0;
		int [] rowsInserted ;
		boolean insertSuccess = false;
		if(event_code == null || event_code.equals("")){
			event_code = priv_resp_code;
		}
		
		try{
			con = ConnectionManager.getConnection(p);
			//int insertedRec = 0; //Checkstyle
			String key_confdnt_id 		= null;
			ArrayList privilegeList 	= new ArrayList();
			//boolean isExistRecord		= false;//Checkstyle
			// Complete changes for IN045870
			
			
			//String key_confdnt_id 		= null;
			String CONFDNT_OPT_IND 		= null;
			String CONFDNT_VW_BY_IND 	= null;
			String childDeleteSQL 		= null;
			//String childDeleteSQL 		= "DELETE FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE =?";
			
			//Iterator itr = confdntHashMap.keySet().iterator();
			Iterator listIterator = confdnKeyList.iterator();
			while(listIterator.hasNext())
			{
				key_confdnt_id = listIterator.next().toString();
				if(!filter_based_on_unchanged.equals("E")) 
				{
					if(filter_based_on_ind.equals("P") || filter_based_on_ind.equals("R")) 
					{
						//childDeleteSQL 		= "DELETE FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE =? AND CONFDNT_OPT_IND = ? AND CONFDNT_TYPE = ? AND CONFDNT_ID =?";
						childDeleteSQL 		= "DELETE FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND  CONFDNT_TYPE = ? AND EVENT_CODE =? AND CONFDNT_ID =?";
					}
					else if(filter_based_on_ind.equals("S")) 
					{
						//childDeleteSQL 		= "DELETE FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE =? AND CONFDNT_OPT_IND = ? AND CONFDNT_VW_BY_IND = ? AND CONFDNT_TYPE = ? AND CONFDNT_ID =?";
						childDeleteSQL 		= "DELETE FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND CONFDNT_TYPE = ? AND EVENT_CODE =? AND CONFDNT_ID =?";
					}
				}	
				else
				{
					childDeleteSQL 		= "DELETE FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE =? AND CONFDNT_TYPE = ? AND CONFDNT_ID =?";
				}
	
			
				deleteChildStmt 			= con.prepareStatement(childDeleteSQL);
				deleteChildStmt.setString(1, hist_rec_type);
				deleteChildStmt.setString(2, event_type_code);
	
				if(filter_based_on_unchanged.equals("E")) 
				{
					deleteChildStmt.setString(3, event_code);
					deleteChildStmt.setString(4, filter_when_click);
					deleteChildStmt.setString(5, key_confdnt_id);
				}
				else 
				{
					//deleteChildStmt.setString(3, key_confdnt_id);	
					if(filter_based_on_unchanged.equals("P") || filter_based_on_unchanged.equals("R")) 
					{
						deleteChildStmt.setString(3, filter_based_on_unchanged);
						deleteChildStmt.setString(4, key_confdnt_id);
						deleteChildStmt.setString(5, priv_resp_code);
					}
					else if(filter_based_on_unchanged.equals("S")) 
					{
						deleteChildStmt.setString(3, filter_based_on_unchanged);
						deleteChildStmt.setString(4, key_confdnt_id);
						deleteChildStmt.setString(5, priv_resp_code);
					}
				}
	
				
				if(filter_based_on_ind.equals("E"))
				{
					filter_based_on_ind = filter_when_click;
				}
	
				int deletedRecords 			= deleteChildStmt.executeUpdate();
				if(deleteChildStmt!=null) deleteChildStmt.close();
			}
			//ArrayList privilegeList 	= new ArrayList();
			if(confdntHashMap != null) {
				boolean batchRecords = false;
				Iterator itr = confdntHashMap.keySet().iterator();
				String childInsertSQL 		= "INSERT INTO CA_EVENT_CONFDNT_DTL (HIST_REC_TYPE, EVENT_CODE_TYPE, EVENT_CODE, CONFDNT_TYPE, CONFDNT_ID, CONFDNT_OPT_IND, CONFDNT_VW_BY_IND, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				childInsertStmt				= con.prepareStatement(childInsertSQL);
				while(itr.hasNext())
				{
					key_confdnt_id = itr.next().toString();
					
					
										
					Object objectList 		= (Object)confdntHashMap.get(key_confdnt_id);
					privilegeList		 	= (ArrayList)objectList;
					
					if(filter_based_on_ind.equals("P") || filter_based_on_ind.equals("R"))
					{
						int l=0;
						
						if(filter_based_on_unchanged.equals("E"))
						{
							CONFDNT_OPT_IND		= privilegeList.get(l).toString();	 
							CONFDNT_VW_BY_IND	= "";
						}
						else 
						{
							CONFDNT_OPT_IND =  view_list_code;
							CONFDNT_VW_BY_IND	= "";
						}
					}
					else if(filter_based_on_ind.equals("S")) 
					{
						int l= 0;
						
						if(filter_based_on_unchanged.equals("E"))
						{
							CONFDNT_VW_BY_IND 	= privilegeList.get(l).toString();
							CONFDNT_OPT_IND		= privilegeList.get(l+1).toString();
						}
						else 
						{
							CONFDNT_VW_BY_IND 	= view_by_code;
							CONFDNT_OPT_IND		= based_on_code;
						}
					}

					if(CONFDNT_VW_BY_IND.equals("LB") || CONFDNT_VW_BY_IND.equals("BB")) 
					{
						CONFDNT_VW_BY_IND = "B";
					}

					if(CONFDNT_OPT_IND.equals("LB") || CONFDNT_OPT_IND.equals("BB")) 
					{
						CONFDNT_OPT_IND = "B";
					}
					/*if(privilegeList.isEmpty()){
						if(filter_based_on_ind.equals("P") || filter_based_on_ind.equals("R")){
							CONFDNT_OPT_IND =  view_list_code;
							CONFDNT_VW_BY_IND	= "";
						}
						else if(filter_based_on_ind.equals("S")) {
							CONFDNT_VW_BY_IND 	= view_by_code;
							CONFDNT_OPT_IND		= based_on_code;
						}
						if(CONFDNT_VW_BY_IND.equals("LB") || CONFDNT_VW_BY_IND.equals("BB")) {
							CONFDNT_VW_BY_IND = "B";
						}
					}
					*/
					childInsertStmt.setString(1, hist_rec_type);
					childInsertStmt.setString(2, event_type_code);
					if(filter_based_on_unchanged.equals("E"))
					{
						childInsertStmt.setString(3, event_code);
					}
					else
					{
						childInsertStmt.setString(3, key_confdnt_id);
					}
					
					childInsertStmt.setString(4, filter_based_on_ind);

					if(filter_based_on_unchanged.equals("E"))
					{
						childInsertStmt.setString(5, key_confdnt_id);
					}
					else 
					{
						childInsertStmt.setString(5, priv_resp_code);
					}
					
					childInsertStmt.setString(6, CONFDNT_OPT_IND);
					childInsertStmt.setString(7, CONFDNT_VW_BY_IND);
					childInsertStmt.setString(8, login_by_id);
					childInsertStmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
					childInsertStmt.setString(10, login_facility_id);
					childInsertStmt.setString(11, login_at_ws_no);
					childInsertStmt.setString(12, login_by_id);
					childInsertStmt.setTimestamp(13, new Timestamp(System.currentTimeMillis()));
					childInsertStmt.setString(14, login_facility_id);
					childInsertStmt.setString(15, login_at_ws_no);
					childInsertStmt.addBatch();
					batchRecords = true;
				}	
				
				if(batchRecords == true) {
					try 
					{
						rowsInserted = childInsertStmt.executeBatch();
						insertedCount = rowsInserted.length;
						insertSuccess = true;
					}
					catch(BatchUpdateException e) 
					{
						insertSuccess = false;
						System.err.println(" 306. CAConfidentialitySetUpServlet.java => " + e.getMessage());
						e.printStackTrace();
					}
				}	
			}
			
			if(filter_based_on_unchanged.equals("E")) {
				insertedCount = insertEventHeaderRecords(hist_rec_type, event_type_code, event_code, login_by_id, login_at_ws_no, login_facility_id,  con);
				if(insertedCount > 0){
					insertSuccess = true;
				}	
			}
			else {
				String insertBaseSQL = "INSERT INTO CA_EVENT_CONFDNT_HDR (HIST_REC_TYPE, EVENT_CODE_TYPE, EVENT_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				headerInsertStmt = con.prepareStatement(insertBaseSQL);
				Iterator headerListIterator = confdnKeyList.iterator();
				while(headerListIterator.hasNext())
				{
					key_confdnt_id = headerListIterator.next().toString();
					

					String selectSQL = " SELECT * FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE =?";
		
					selectChildStmt = con.prepareStatement(selectSQL);
					selectChildStmt.setString(1, hist_rec_type);
					selectChildStmt.setString(2, event_type_code);
					selectChildStmt.setString(3, key_confdnt_id);
					childResultset = selectChildStmt.executeQuery();
					
					if(childResultset.next()){ 
													
						String selectHeaderSQL = "SELECT * FROM CA_EVENT_CONFDNT_HDR WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE =?";
						selectHeaderStmt = con.prepareStatement(selectHeaderSQL);
						selectHeaderStmt.setString(1, hist_rec_type);
						selectHeaderStmt.setString(2, event_type_code);
						selectHeaderStmt.setString(3, key_confdnt_id);
						headerResultset = selectHeaderStmt.executeQuery();
						
						if(headerResultset.next()) {
							insertSuccess = true;
						}
						else 
						{
							
							
							headerInsertStmt.setString(1, hist_rec_type);
							headerInsertStmt.setString(2, event_type_code);
							headerInsertStmt.setString(3, key_confdnt_id);
							headerInsertStmt.setString(4, login_by_id);
							headerInsertStmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
							headerInsertStmt.setString(6, login_facility_id);
							headerInsertStmt.setString(7, login_at_ws_no);
							headerInsertStmt.setString(8, login_by_id);
							headerInsertStmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
							headerInsertStmt.setString(10, login_facility_id);
							headerInsertStmt.setString(11, login_at_ws_no);	
							headerInsertStmt.addBatch();
						}
						if(headerResultset!=null) headerResultset.close();
						if(selectHeaderStmt!=null) selectHeaderStmt.close();	
					}
					else {
						String deleteHeaderSQL = "DELETE FROM 	CA_EVENT_CONFDNT_HDR WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE =?";
						deleteHeaderStmt = con.prepareStatement(deleteHeaderSQL);
						deleteHeaderStmt.setString(1, hist_rec_type);
						deleteHeaderStmt.setString(2, event_type_code);
						deleteHeaderStmt.setString(3, event_code);
						deleteHeaderStmt.executeUpdate();
						insertSuccess = true;
						if(deleteHeaderStmt!=null)deleteHeaderStmt.close();
					}
					if(childResultset!=null)childResultset.close();
					if(selectChildStmt!=null) selectChildStmt.close();
				}
				try 
				{
					rowsInserted = headerInsertStmt.executeBatch();
					insertedCount = rowsInserted.length;
					insertSuccess = true;
				}
				catch(BatchUpdateException e) 
				{	
					insertSuccess = false;
					System.err.println(" 306. CAConfidentialitySetUpServlet.java => " + e.getMessage());
					e.printStackTrace();
				}	
			}
			
			
			
			
			try {
				if(insertSuccess == true){
					con.commit();
					java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");                
					message1 = (java.lang.String)hashtable.get("message");
					message2 = "1";
				}else{
					try{
						con.rollback();
					}catch(Exception ee){
						ee.printStackTrace();
					}
					message1 = "Exception raise by Servlet..........So Record Not inserted.";							
				}
			} catch(Exception e) {
				e.printStackTrace();
			}	
		
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
		}
		catch(Exception e)
		{
			out.println("Exception in main try :" +e);
			e.printStackTrace();
			try{
				con.rollback();
				message1="Exception raise by Servlet ...So Record Not inserted  Foll: Error Received : "+ e.toString();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
		finally
		{
			try {
				if(headerResultset != null) headerResultset.close();
				if(headerInsertStmt != null) headerInsertStmt.close();
				if(selectHeaderStmt != null) selectHeaderStmt.close();
				if(selectChildStmt	!= null) selectChildStmt.close();
				if(childResultset	!= null) childResultset.close();
				if(deleteChildStmt != null) deleteChildStmt.close();
				if(childInsertStmt != null) childInsertStmt.close();
				if(con!=null)ConnectionManager.returnConnection(con, p);
			}
			catch(Exception e){
				e.printStackTrace();
			}
								
		}
	}
	public int insertEventHeaderRecords(String hist_rec_type, String event_type_code, String event_code, String login_by_id, String login_at_ws_no, String login_facility_id,  Connection con) throws Exception {
		int insertedRecord = 0;
		PreparedStatement headerInsertStmt	 = null;
		PreparedStatement deleteHeaderStmt	 = null;
		PreparedStatement selectHeaderStmt	 = null;
		ResultSet headerResultset			 = null;
		PreparedStatement selectChildStmt	 = null;
		ResultSet childResultset			 = null;
		
		try {
			//int insertedRec = 0; //Checkstyle
			//String key_confdnt_id 		= null;//Checkstyle
			//ArrayList privilegeList 	= new ArrayList();//checkstyle
			//boolean isRecordExist		= false;//Checkstyle
			
			String selectSQL = " SELECT * FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE =?";
		
			selectChildStmt = con.prepareStatement(selectSQL);
			selectChildStmt.setString(1, hist_rec_type);
			selectChildStmt.setString(2, event_type_code);
			selectChildStmt.setString(3, event_code);
			childResultset = selectChildStmt.executeQuery();
			
			if(childResultset.next()){ 
											
				String selectHeaderSQL = "SELECT * FROM CA_EVENT_CONFDNT_HDR WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE =?";
				selectHeaderStmt = con.prepareStatement(selectHeaderSQL);
				selectHeaderStmt.setString(1, hist_rec_type);
				selectHeaderStmt.setString(2, event_type_code);
				selectHeaderStmt.setString(3, event_code);
				headerResultset = selectHeaderStmt.executeQuery();
				
				if(headerResultset.next()) {
					insertedRecord = 1;
				}
				else 
				{
					String insertBaseSQL = "INSERT INTO CA_EVENT_CONFDNT_HDR (HIST_REC_TYPE, EVENT_CODE_TYPE, EVENT_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
					headerInsertStmt = con.prepareStatement(insertBaseSQL);
					headerInsertStmt.setString(1, hist_rec_type);
					headerInsertStmt.setString(2, event_type_code);
					headerInsertStmt.setString(3, event_code);
					headerInsertStmt.setString(4, login_by_id);
					headerInsertStmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
					headerInsertStmt.setString(6, login_facility_id);
					headerInsertStmt.setString(7, login_at_ws_no);
					headerInsertStmt.setString(8, login_by_id);
					headerInsertStmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
					headerInsertStmt.setString(10, login_facility_id);
					headerInsertStmt.setString(11, login_at_ws_no);	
					insertedRecord = headerInsertStmt.executeUpdate();	
				}
					
			}
			else {
				String deleteHeaderSQL = "DELETE FROM 	CA_EVENT_CONFDNT_HDR WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE =?";
				deleteHeaderStmt = con.prepareStatement(deleteHeaderSQL);
				deleteHeaderStmt.setString(1, hist_rec_type);
				deleteHeaderStmt.setString(2, event_type_code);
				deleteHeaderStmt.setString(3, event_code);
				deleteHeaderStmt.executeUpdate();
				insertedRecord  = 1;
			}	
				
			
		}
		catch(Exception ex ){
			insertedRecord = 0;
			ex.printStackTrace();
			System.err.println(ex.getMessage());
		}
		finally {
			if(deleteHeaderStmt != null) deleteHeaderStmt.close();
			if(headerInsertStmt != null) headerInsertStmt.close();
			
			if(selectHeaderStmt	!= null) selectHeaderStmt.close();
			if(headerResultset != null)  headerResultset.close();
			if(selectChildStmt	!= null) selectChildStmt.close();
			if(childResultset	!= null) childResultset.close();
			
		
		}
		return insertedRecord;
	}
}
