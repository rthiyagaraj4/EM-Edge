/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
------------------------------------------------------------------------------------------------------------------------------------
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759	
						
------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;

public class CAMenstrualHistTranscationDtlServlet extends javax.servlet.http.HttpServlet	
{

private static final long serialVersionUID = 1L;

/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
{ 
		PrintWriter out = null;
		Connection con = null;
		request.setCharacterEncoding("UTF-8");			
		response.setContentType("text/html; charset=UTF-8");
		con = ConnectionManager.getConnection(request);
		
		String mode1=request.getParameter("mode1")==null?"":request.getParameter("mode1");

		if("modify".equals(mode1))
		{
			updateMenstrualHistory(request,response,con);
		}
		else if("modifyEventStatus".equals(mode1))
		{
			updateMenstrualEventStatusHistory(request,response,con);
		}
		else if("modifyEventStatus1".equals(mode1))
		{
			updateMenstrualEventStatusHistory1(request,response,con);
		}
		else
		{
			insertMenstrualHistory(request,response,con);
		}
	}

	public void insertMenstrualHistory(HttpServletRequest request,HttpServletResponse response,Connection con)
	{
		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facility_id = "";

		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		loginuserid		=(String) session.getValue("login_user");
		facility_id		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");
		String      delivery_miscarrage_type ="";
		String     delivery_miscarrage_date ="";
		String insert_query ="";
		String sStyle =	 "";
		int nInsStat =0;
	    String outPut1 = "";
	    String outPut2 = ""; 
	    String remarks="";
	    String event_status="";
	    String mode1="";

	sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	     outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+"<BODY CLASS='MESSAGE'>";
	     
     String lmp_Date = request.getParameter("lmpDate") == null ? "" : request.getParameter("lmpDate");
	     String edd_Date = request.getParameter("eddDate") == null ? "" : request.getParameter("eddDate");
	  // Converting the integer parameters to String, with default as empty string ("")
	     String gestation_poa_week = request.getParameter("gestationPoaWeek") == null ? "" : request.getParameter("gestationPoaWeek");
	     String gestation_poa_days = request.getParameter("gestationPoaDays") == null ? "" : request.getParameter("gestationPoaDays");
	     String scan_gestation_weeks = request.getParameter("scanGestationWeeks") == null ? "" : request.getParameter("scanGestationWeeks");
	     String scan_gestation_days = request.getParameter("scanGestationDays") == null ? "" : request.getParameter("scanGestationDays");
	     String gestation_pog_weeks = request.getParameter("gestationPogWeeks") == null ? "" : request.getParameter("gestationPogWeeks");
	     String gestation_pog_days = request.getParameter("gestationPogDays") == null ? "" : request.getParameter("gestationPogDays");
		    String called_form = request.getParameter("called_form") == null ? "" : request.getParameter("called_form");

	     String  lmp_delivery_miscarrage_type = request.getParameter("lmpDeliveryMiscarrageType") == null ? "" : request.getParameter("lmpDeliveryMiscarrageType");
	     String   unsure_delivery_miscarrage_date = request.getParameter("unsureDeliveryMiscarrageDate") == null ? "" : request.getParameter("unsureDeliveryMiscarrageDate");
	     String lmp_delivery_miscarrage_date = request.getParameter("lmpDeliveryMiscarrageDate") == null ? "" : request.getParameter("lmpDeliveryMiscarrageDate");
	     String unsure_delivery_miscarrage_type = request.getParameter("unsureDeliveryMiscarrageType") == null ? "" : request.getParameter("unsureDeliveryMiscarrageType");
	     String remark_lmp = request.getParameter("remarkLmp") == null ? "" : request.getParameter("remarkLmp");
	     String remark_unsure = request.getParameter("remarkUnsure") == null ? "" : request.getParameter("remarkUnsure");
	     String redd_date = request.getParameter("redd") == null ? "" : request.getParameter("redd");
	     String unsure_date = request.getParameter("unsureDate") == null ? "" : request.getParameter("unsureDate");
	     String event = request.getParameter("selectedValue") == null ? "" : request.getParameter("selectedValue");
	     String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	 	String option_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
		String error_remarks = request.getParameter("error_remarks") == null ? "" : request.getParameter("error_remarks");
	     String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	     String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	 	String modifyRemark = request.getParameter("modifyRemark") == null ? "" : request.getParameter("modifyRemark");
	    String delivery_status=" ";

	 	if(event.equals("L"))
	 	{
	 		delivery_miscarrage_type= lmp_delivery_miscarrage_type;
	 	}
	 	else
	 	{
	 		delivery_miscarrage_type= unsure_delivery_miscarrage_type;
	 	}
	 	
		if(event.equals("L"))
	 	{
			remarks= remark_lmp;
	 	}
	 	else
	 	{
	 		remarks= remark_unsure;
	 	}
	 	
	 	
		if(event.equals("L"))
	 	{
			delivery_miscarrage_date= lmp_delivery_miscarrage_date;
	 	}
	 	else
	 	{
	 		delivery_miscarrage_date= unsure_delivery_miscarrage_date;
	 	}
	 	
		if(delivery_miscarrage_date.equals("") && delivery_miscarrage_date.equals(""))
		{
			event_status="A";
			delivery_status="O";

		}
		else{
			event_status="C";
			delivery_status="O";

		}
		
		try
		{
			 insert_query = "INSERT INTO CA_MENS_HIS_TRANS_DTL ( PATIENT_ID, EVENT, SRL_NO,LAST_MENSTRUAL_PERIOD, EDD, GESTATION_POA_WEEKS, GESTATION_POA_DAYS, SCAN_GESTATION_WEEKS, SCAN_GESTATION_DAYS, UNSURE_OF_DATE, REDD, GESTATION_POG_WEEKS, GESTATION_POG_DAYS, DELIVERY_MISCARRAGE_TYPE, DELIVERY_MISCARRAGE_DATE, REMARKS, MODIFIED_REMARKS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,EVENT_STATUS,ERROR_REMARKS,FACILITY_ID,ENCOUNTER_ID,EPISODE_ID, DELIVERY_STATUS) VALUES (?, ?, CA_MENSTRUAL_NO_AUDIT_SEQ.NEXTVAL,TO_DATE(?, 'DD/MM/YYYY'), TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,?,?,?,?,?)";

				 pstmt = con.prepareStatement(insert_query);
				pstmt.setString(1, patient_id); // PATIENT_ID
				pstmt.setString(2, event); // EVENT
				pstmt.setString(3, lmp_Date); // LAST_MENSTRUAL_PERIOD
				pstmt.setString(4, edd_Date); // EDD
				pstmt.setString(5, gestation_poa_week); // GESTATION_POA_WEEKS
				pstmt.setString(6, gestation_poa_days); // GESTATION_POA_DAYS
				pstmt.setString(7, scan_gestation_weeks); // SCAN_GESTATION_WEEKS
				pstmt.setString(8, scan_gestation_days); // SCAN_GESTATION_DAYS
				pstmt.setString(9, unsure_date); // UNSURE_OF_DATE
				pstmt.setString(10, redd_date); // REDD
				pstmt.setString(11, gestation_pog_weeks); // GESTATION_POG_WEEKS
				pstmt.setString(12, gestation_pog_days); // GESTATION_POG_DAYS
				pstmt.setString(13, delivery_miscarrage_type); // DELIVERY_MISCARRAGE_TYPE
				pstmt.setString(14, delivery_miscarrage_date); // DELIVERY_MISCARRAGE_DATE
				pstmt.setString(15, remarks); // REMARKS
				pstmt.setString(16, modifyRemark); // REMARKS
				pstmt.setString(17, loginuserid); // ADDED_BY_ID
				pstmt.setString(18, client_ip_address); // ADDED_AT_WS_NO
				pstmt.setString(19, facility_id); // ADDED_FACILITY_ID
				pstmt.setString(20, loginuserid); // MODIFIED_BY_ID
				pstmt.setString(21, client_ip_address); // MODIFIED_AT_WS_NO
				pstmt.setString(22, facility_id); // MODIFIED_FACILITY_ID
				pstmt.setString(23, event_status); // event_status
				pstmt.setString(24, error_remarks); // event_status
				pstmt.setString(25, facility_id); // event_status
				pstmt.setString(26, encounter_id); 
				pstmt.setString(27, episode_id); // event_status
				pstmt.setString(28, delivery_status); // event_status

				 nInsStat = pstmt.executeUpdate();
				if (pstmt != null) pstmt.close();

			  if(nInsStat>0)
			  { 		
				con.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				error_value = "1";
				}
			else
			{
				con.rollback();
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;
			}
				if(pstmt != null) pstmt.close();
				
				
			    if(called_form.equals("PAS_TRANSCATION_INVOKING"))
		        {
					out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
		       // response.sendRedirect("../eCA/jsp/CAMenstrualHistDtlMessage.jsp?errorMsg=" +errorMsg  + "&called_form="+ called_form);	   
		        }
		        else{
		    	if("MENST_HIST_DTL".equals(option_id) || "MENST_HIST_DTL1".equals(option_id))   {
					 outPut2 = "<script>parent.frames(3).onSuccess();</script>"+"</BODY></html>";  
				}	else{
					outPut2 = "<script>parent.frames(3).location.reload();</script>"+"</BODY></html>";  
				}
					out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
			}
		  
		}
		catch(Exception e )
		{			
			e.printStackTrace();
			
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
		}
		finally
		{			
			if(con != null) ConnectionManager.returnConnection(con);	
		}
	}
	
	
	public void updateMenstrualHistory(HttpServletRequest request, HttpServletResponse response, Connection con) {
	    HttpSession session = request.getSession(false);
	    PrintWriter out = null;
	    try {
	        out = response.getWriter();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    ResultSet resultSet = null;
	    PreparedStatement pstmt = null;
	    Properties p;
	    String errorMsg = "";
	    String error_value = "";
	    String loginuserid = "";
	    String client_ip_address = "";
	    String facility_id = "";
	    String delivery_miscarrage_type = "";
	    String delivery_miscarrage_date = "";
	    String remarks = "";
	    String event_status="";
	    
	    p = (java.util.Properties) session.getValue("jdbc");
	    loginuserid = (String) session.getValue("login_user");
	    facility_id = (String) session.getValue("facility_id");
	    client_ip_address = p.getProperty("client_ip_address");
	    String locale = (String) p.getProperty("LOCALE");
	    String sStyle = "";
	    String outPut1 = "";
	    String outPut2 = ""; 
	    String mode1 = "";
	    String oldRemarks="";
	    String modify_query = "";
	    int updsStat = 0;

	    sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	    outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/" + sStyle + "'></link>" + "<BODY CLASS='MESSAGE'>";
	    
	    String lmp_Date = request.getParameter("lmpDate") == null ? "" : request.getParameter("lmpDate");
	    String edd_Date = request.getParameter("eddDate") == null ? "" : request.getParameter("eddDate");
	    // Converting the integer parameters to String, with default as empty string ("")
	    String gestation_poa_week = request.getParameter("gestationPoaWeek") == null ? "" : request.getParameter("gestationPoaWeek");
	    String gestation_poa_days = request.getParameter("gestationPoaDays") == null ? "" : request.getParameter("gestationPoaDays");
	    String scan_gestation_weeks = request.getParameter("scanGestationWeeks") == null ? "" : request.getParameter("scanGestationWeeks");
	    String scan_gestation_days = request.getParameter("scanGestationDays") == null ? "" : request.getParameter("scanGestationDays");
	    String gestation_pog_weeks = request.getParameter("gestationPogWeeks") == null ? "" : request.getParameter("gestationPogWeeks");
	    String gestation_pog_days = request.getParameter("gestationPogDays") == null ? "" : request.getParameter("gestationPogDays");
	    
	    String lmp_delivery_miscarrage_type = request.getParameter("lmpDeliveryMiscarrageType") == null ? "" : request.getParameter("lmpDeliveryMiscarrageType");
	    String unsure_delivery_miscarrage_date = request.getParameter("unsureDeliveryMiscarrageDate") == null ? "" : request.getParameter("unsureDeliveryMiscarrageDate");
	    String lmp_delivery_miscarrage_date = request.getParameter("lmpDeliveryMiscarrageDate") == null ? "" : request.getParameter("lmpDeliveryMiscarrageDate");
	    String unsure_delivery_miscarrage_type = request.getParameter("unsureDeliveryMiscarrageType") == null ? "" : request.getParameter("unsureDeliveryMiscarrageType");
	    String remark_lmp = request.getParameter("remarkLmp") == null ? "" : request.getParameter("remarkLmp");
	    String remark_unsure = request.getParameter("remarkUnsure") == null ? "" : request.getParameter("remarkUnsure");
	    String redd_date = request.getParameter("redd") == null ? "" : request.getParameter("redd");
	    String unsure_date = request.getParameter("unsureDate") == null ? "" : request.getParameter("unsureDate");
	    String event = request.getParameter("selectedValue") == null ? "" : request.getParameter("selectedValue");
	    String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	    String option_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
		String error_remarks = request.getParameter("error_remarks") == null ? "" : request.getParameter("error_remarks");
	     String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	     String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	    String modifyRemark = request.getParameter("modifyRemark") == null ? "" : request.getParameter("modifyRemark");
	    String srl_no = request.getParameter("srl_no") == null ? "" : request.getParameter("srl_no");
	    String oldLmpDate = request.getParameter("pervious_lmp_date") == null ? "" : request.getParameter("pervious_lmp_date");
	    String pervious_remark_lmp = request.getParameter("pervious_remark_lmp") == null ? "" : request.getParameter("pervious_remark_lmp");
	    String pervious_remark_unsure = request.getParameter("pervious_remark_unsure") == null ? "" : request.getParameter("pervious_remark_unsure");
	    String pervious_scan_gestation_days = request.getParameter("pervious_scan_gestation_days") == null ? "" : request.getParameter("pervious_scan_gestation_days");
	    String pervious_scan_gestation_weeks = request.getParameter("pervious_scan_gestation_weeks") == null ? "" : request.getParameter("pervious_scan_gestation_weeks");
	    String called_form = request.getParameter("called_form") == null ? "" : request.getParameter("called_form");
	    
	    String delivery_status=" ";
	    
	    if (event.equals("L")) {
	        delivery_miscarrage_type = lmp_delivery_miscarrage_type;
	    } else {
	        delivery_miscarrage_type = unsure_delivery_miscarrage_type;
	    }

	    if (event.equals("L")) {
	        remarks = remark_lmp;
	        oldRemarks=pervious_remark_lmp;
	    } else {
	        remarks = remark_unsure;
	        oldRemarks=pervious_remark_unsure;
	    }

	    if (event.equals("L")) {
	        delivery_miscarrage_date = lmp_delivery_miscarrage_date;
	    } else {
	        delivery_miscarrage_date = unsure_delivery_miscarrage_date;
	    }

	    if(delivery_miscarrage_date.equals("") && delivery_miscarrage_date.equals(""))
		{
			event_status="A";
			delivery_status="O";
		}
		else
		{
			event_status="C";
			delivery_status="O";
		}
	 // Assuming srl_no and event_type are defined and available


	    try {
	        modify_query = "UPDATE CA_MENS_HIS_TRANS_DTL SET LAST_MENSTRUAL_PERIOD = TO_DATE(?, 'dd/MM/yyyy'), EDD = TO_DATE(?, 'dd/MM/yyyy'),GESTATION_POA_WEEKS = ?, GESTATION_POA_DAYS = ?, SCAN_GESTATION_WEEKS = ?, SCAN_GESTATION_DAYS = ?, UNSURE_OF_DATE = TO_DATE(?, 'dd/MM/yyyy'), REDD = TO_DATE(?, 'dd/MM/yyyy'), GESTATION_POG_WEEKS = ?, GESTATION_POG_DAYS = ?, DELIVERY_MISCARRAGE_TYPE = ?, DELIVERY_MISCARRAGE_DATE = TO_DATE(?, 'dd/MM/yyyy'), REMARKS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, MODIFIED_REMARKS = ? , EVENT_STATUS = ? ,ERROR_REMARKS =? , FACILITY_ID = ? , ENCOUNTER_ID = ?,EPISODE_ID=?, EVENT=? , DELIVERY_STATUS=? WHERE  PATIENT_ID = ? AND SRL_NO=?  ";

	        pstmt = con.prepareStatement(modify_query);

	        // Setting the parameters
	      pstmt.setString(1, lmp_Date);
	        pstmt.setString(2, edd_Date);
	        pstmt.setString(3, gestation_poa_week); 
	        pstmt.setString(4, gestation_poa_days); 
	        pstmt.setString(5, scan_gestation_weeks); 
	        pstmt.setString(6, scan_gestation_days); 
	        pstmt.setString(7, unsure_date);
	        pstmt.setString(8, redd_date);
	        pstmt.setString(9, gestation_pog_weeks); 
	        pstmt.setString(10, gestation_pog_days);
	        pstmt.setString(11, delivery_miscarrage_type); 
	        pstmt.setString(12, delivery_miscarrage_date); 
	        pstmt.setString(13, remarks); 
	        pstmt.setString(14, loginuserid);
	        pstmt.setString(15, client_ip_address); 
	        pstmt.setString(16, facility_id);
	        pstmt.setString(17, modifyRemark);
			pstmt.setString(18, event_status); 
			pstmt.setString(19, error_remarks);
			pstmt.setString(20, facility_id); 
			pstmt.setString(21, encounter_id); 
			pstmt.setString(22, episode_id); 
			pstmt.setString(23, event); 
			pstmt.setString(24, delivery_status); 
			pstmt.setString(25, patient_id);
			pstmt.setString(26, srl_no); 
	        
	    

	        // Execute the update
	        updsStat = pstmt.executeUpdate();	
	        if (updsStat > 0) {

	            errorMsg = getMessage(locale, "RECORD_INSERTED", "CA");
	            error_value = "1";
	            // Audit Log for modified fields
	         // Audit Log for modified fields
	            Map<String, String> oldValues = new HashMap<String, String>();
	            if (oldLmpDate != null && !oldLmpDate.equals("")) {
	                oldValues.put("LMP", oldLmpDate);
	            }
	            
	            if (pervious_scan_gestation_weeks != null && pervious_scan_gestation_days != null) {
	                oldValues.put("Scan Gestation", pervious_scan_gestation_weeks + " weeks " + pervious_scan_gestation_days + " days");
	            }
	    	    
	          
	                oldValues.put("Remarks", oldRemarks);
	       


	            Map<String, String> newValues = new HashMap<String, String>();
	            if (lmp_Date != null && !lmp_Date.equals("")) {
	                newValues.put("LMP", lmp_Date);
	            }
	            if (scan_gestation_weeks != null && scan_gestation_days != null) {
	                newValues.put("Scan Gestation", scan_gestation_weeks + " weeks " + scan_gestation_days + " days");
	            }
	          
	           
	                newValues.put("Remarks", remarks);
	             


	            // Collect old and new values
	            // ... existing code to populate oldValues and newValues ...

	            String insertAuditQuery = "INSERT INTO CA_MENS_HIS_TRANS_DTL_AUDIT (srl_no, field_name, previous_value, amend_by, amend_date, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, modified_remarks, patient_id, event,facility_id,episode_id,encounter_id) VALUES (?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?)";

	            try {
	            	if (modifyRemark != null && !modifyRemark.equals("")) { 
	                pstmt = con.prepareStatement(insertAuditQuery);
	                
	                // Prepare a list to hold the audit records
	                // Prepare a list to hold the audit records
	                List<Object[]> auditRecords = new ArrayList<Object[]>();
	                Set<String> processedFields = new HashSet<String>(); // To track processed fields
	                boolean fieldsChanged = false;

	                for (String field : oldValues.keySet()) {
	                    String oldValue = oldValues.get(field);
	                    String newValue = newValues.get(field);

	                    // Check if the old value is not equal to the new value and not empty
	                    if (oldValue != null && !oldValue.equals(newValue) && (newValue != null && !newValue.equals(""))) {
	                        // Only process if this field hasn't been processed yet
	                        if (!processedFields.contains(field)) {
	                            // Collect the audit record details
	                            auditRecords.add(new Object[]{
	                                srl_no, field, oldValue, loginuserid, client_ip_address, facility_id, modifyRemark, patient_id, event, facility_id, episode_id, encounter_id
	                            });
	                            processedFields.add(field); // Mark this field as processed
	                            fieldsChanged = true;
	                        }
	                    } else if (field.equals("Remarks") && oldValue != null && !oldValue.equals("") && (newValue == null || newValue.equals(""))) {
	                        // Special case for remarks where old value is not empty but new value is empty
	                        auditRecords.add(new Object[]{
	                            srl_no, field, oldValue, loginuserid, client_ip_address, facility_id, modifyRemark, patient_id, event, facility_id, episode_id, encounter_id
	                        });
	                        fieldsChanged = true; // Mark that fields have changed
	                    }
	                }
	                
	         

	                // Now, insert all audit records in a batch
	                for (Object[] record : auditRecords) {
	                  pstmt.setString(1, (String) record[0]); // srl_no
	                    pstmt.setString(2, (String) record[1]); // field_name
	                    pstmt.setString(3, (String) record[2]); // previous_value
	                    pstmt.setString(4, (String) record[3]); // amend_by
	                    pstmt.setString(5, (String) record[3]); // added_by_id
	                    pstmt.setString(6, (String) record[4]); // added_at_ws_no
	                    pstmt.setString(7, (String) record[5]); // modified_facility_id
	                    pstmt.setString(8, (String) record[3]); // modified_by_id
	                    pstmt.setString(9, (String) record[4]); // modified_at_ws_no
	                    pstmt.setString(10, (String) record[5]); // modified_facility_id
	                    pstmt.setString(11, (String) record[6]); // modified_remarks
	                    pstmt.setString(12, (String) record[7]); // patient_id
	                    pstmt.setString(13, (String) record[8]); // event
	                    pstmt.setString(14, (String) record[9]); // event
	                    pstmt.setString(15, (String) record[10]); // event
	                    pstmt.setString(16, (String) record[11]); // event
	             
	             
	                	pstmt.addBatch(); // Add to batch
	                }

	                // Execute batch insert for audit records
	                if (!auditRecords.equals("")) {
	                    pstmt.executeBatch();
	                }
	            }
	                con.commit();

	            }
	            catch (SQLException e) {
	            	e.printStackTrace();
	            }
	        }
	        else
			{
				con.rollback();
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;
			}
				
	        if(called_form.equals("PAS_TRANSCATION_INVOKING"))
	        {
				out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);


	        }
	        else{
	    	if("MENST_HIST_DTL".equals(option_id) || "MENST_HIST_DTL1".equals(option_id))   {
				 outPut2 = "<script>parent.frames(3).onSuccess();</script>"+"</BODY></html>";  
			}	else{
				outPut2 = "<script>parent.frames(3).location.reload();</script>"+"</BODY></html>";  
			}
				out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
		}
	  }
		catch(Exception e )
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
		}
		finally
		{			
			if(con != null) ConnectionManager.returnConnection(con);	
		}
	}
	
	public void updateMenstrualEventStatusHistory(HttpServletRequest request, HttpServletResponse response, Connection con) {
	    HttpSession session = request.getSession(false);
	    
	    PrintWriter out = null;
	    try {
	        out = response.getWriter();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    ResultSet resultSet = null;
	    PreparedStatement pstmt = null;
	    Properties p;
	    String errorMsg = "";
	    String error_value = "";
	    String loginuserid = "";
	    String client_ip_address = "";
	    String facility_id = "";
	    String remarks = "";
	    
	    p = (java.util.Properties) session.getValue("jdbc");
	    loginuserid = (String) session.getValue("login_user");
	    facility_id = (String) session.getValue("facility_id");
	    client_ip_address = p.getProperty("client_ip_address");
	    String locale = (String) p.getProperty("LOCALE");
	    String sStyle = "";
	    String outPut1 = "";
	    String outPut2 = ""; 
	    String mode1 = "";
	    String modify_query = "";
	    int updsStat = 0;

	    sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	    outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/" + sStyle + "'></link>" + "<BODY CLASS='MESSAGE'>";
	    

	    String event = request.getParameter("selectedValue") == null ? "" : request.getParameter("selectedValue");
	    String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	    String option_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
		String error_remarks = request.getParameter("error_remarks") == null ? "" : request.getParameter("error_remarks");
	     String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	     String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	     String srl_no = request.getParameter("srl_no") == null ? "" : request.getParameter("srl_no");
		    String called_form = request.getParameter("called_form") == null ? "" : request.getParameter("called_form");

	     String event_status="E"; 

	    try {
	        modify_query = "UPDATE CA_MENS_HIS_TRANS_DTL SET EVENT_STATUS = ? ,ERROR_REMARKS =?,  MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,FACILITY_ID = ?, ENCOUNTER_ID = ?, EPISODE_ID =? WHERE   PATIENT_ID = ? AND SRL_NO=?";

	        pstmt = con.prepareStatement(modify_query);

	        // Setting the parameters
	
			pstmt.setString(1, event_status); // EVENT
			pstmt.setString(2, error_remarks); // EVENT
			 pstmt.setString(3, loginuserid); // MODIFIED_BY_ID
		     pstmt.setString(4, client_ip_address); // MODIFIED_AT_WS_NO
		     pstmt.setString(5, facility_id); // MODIFIED_FACILITY_ID
		     pstmt.setString(6, facility_id); // MODIFIED_FACILITY_ID
		     pstmt.setString(7, encounter_id); // WHERE PATIENT_ID
			pstmt.setString(8, episode_id); // EVENT
		     pstmt.setString(9, patient_id); // WHERE PATIENT_ID
			pstmt.setString(10, srl_no); // EVENT
	        // Execute the update
	        updsStat = pstmt.executeUpdate();	

	        if (updsStat > 0) {
	            errorMsg = getMessage(locale, "RECORD_INSERTED", "CA");
	            error_value = "1";
	            // Audit Log for modified fields
	                con.commit();
	        }
	        else
			{
				con.rollback();
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;
			}
				
	        if(called_form.equals("PAS_TRANSCATION_INVOKING"))
	        {
				out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
	       // response.sendRedirect("../eCA/jsp/CAMenstrualHistDtlMessage.jsp?errorMsg=" +errorMsg  + "&called_form="+ called_form);	   
	        }
	        else{
	    	if("MENST_HIST_DTL".equals(option_id) || "MENST_HIST_DTL1".equals(option_id))   {
				 outPut2 = "<script>parent.frames(3).onSuccess();</script>"+"</BODY></html>";  
			}	else{
				outPut2 = "<script>parent.frames(3).location.reload();</script>"+"</BODY></html>";  
			}
				out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
		}
		}
		catch(Exception e )
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
		}
		finally
		{			
			if(con != null) ConnectionManager.returnConnection(con);	
		}
	}
	
	public void updateMenstrualEventStatusHistory1(HttpServletRequest request, HttpServletResponse response, Connection con) {
	    HttpSession session = request.getSession(false);
	    
	    PrintWriter out = null;
	    try {
	        out = response.getWriter();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    ResultSet resultSet = null;
	    PreparedStatement pstmt = null;
	    Properties p;
	    String errorMsg = "";
	    String error_value = "";
	    String loginuserid = "";
	    String client_ip_address = "";
	    String facility_id = "";
	    String remarks = "";
		String      delivery_miscarrage_type ="";
		String     delivery_miscarrage_date ="";
	    
	    p = (java.util.Properties) session.getValue("jdbc");
	    loginuserid = (String) session.getValue("login_user");
	    facility_id = (String) session.getValue("facility_id");
	    client_ip_address = p.getProperty("client_ip_address");
	    String locale = (String) p.getProperty("LOCALE");
	    String sStyle = "";
	    String outPut1 = "";
	    String outPut2 = ""; 
	    String mode1 = "";
	    String modify_query = "";
	    int updsStat = 0;

	    sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	    outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/" + sStyle + "'></link>" + "<BODY CLASS='MESSAGE'>";
	    

	    String event = request.getParameter("selectedValue") == null ? "" : request.getParameter("selectedValue");
	    String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	    String option_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
		String error_remarks = request.getParameter("error_remarks") == null ? "" : request.getParameter("error_remarks");
	     String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	     String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	     String srl_no = request.getParameter("srl_no") == null ? "" : request.getParameter("srl_no");
		  String called_form = request.getParameter("called_form") == null ? "" : request.getParameter("called_form");
		  String lmp_delivery_miscarrage_type = request.getParameter("lmpDeliveryMiscarrageType") == null ? "" : request.getParameter("lmpDeliveryMiscarrageType");
		  String unsure_delivery_miscarrage_date = request.getParameter("unsureDeliveryMiscarrageDate") == null ? "" : request.getParameter("unsureDeliveryMiscarrageDate");
		  String lmp_delivery_miscarrage_date = request.getParameter("lmpDeliveryMiscarrageDate") == null ? "" : request.getParameter("lmpDeliveryMiscarrageDate");
		  String unsure_delivery_miscarrage_type = request.getParameter("unsureDeliveryMiscarrageType") == null ? "" : request.getParameter("unsureDeliveryMiscarrageType");
		  String remark_lmp = request.getParameter("remarkLmp") == null ? "" : request.getParameter("remarkLmp");
		  String remark_unsure = request.getParameter("remarkUnsure") == null ? "" : request.getParameter("remarkUnsure");
		  
		 	if(event.equals("L"))
		 	{
		 		delivery_miscarrage_type= lmp_delivery_miscarrage_type;
		 	}
		 	else
		 	{
		 		delivery_miscarrage_type= unsure_delivery_miscarrage_type;
		 	}
		 	
			if(event.equals("L"))
		 	{
				remarks= remark_lmp;
		 	}
		 	else
		 	{
		 		remarks= remark_unsure;
		 	}
		 	
		 	
			if(event.equals("L"))
		 	{
				delivery_miscarrage_date= lmp_delivery_miscarrage_date;
		 	}
		 	else
		 	{
		 		delivery_miscarrage_date= unsure_delivery_miscarrage_date;
		 	}
		     
	     String event_status="E"; 

	    try {
	        modify_query = "UPDATE CA_MENS_HIS_TRANS_DTL SET EVENT_STATUS = ? , DELIVERY_MISCARRAGE_TYPE = ?, DELIVERY_MISCARRAGE_DATE = TO_DATE(?, 'dd/MM/yyyy'), REMARKS = ?,ERROR_REMARKS =?,  MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,FACILITY_ID = ?, ENCOUNTER_ID = ?, EPISODE_ID =? WHERE   PATIENT_ID = ? AND SRL_NO=?";

	        pstmt = con.prepareStatement(modify_query);

	        // Setting the parameters
	
			pstmt.setString(1, event_status); // EVENT
			pstmt.setString(2, delivery_miscarrage_type); 
			pstmt.setString(3, delivery_miscarrage_date);
			pstmt.setString(4, remarks); 
			pstmt.setString(5, error_remarks); // EVENT
			 pstmt.setString(6, loginuserid); // MODIFIED_BY_ID
		     pstmt.setString(7, client_ip_address); // MODIFIED_AT_WS_NO
		     pstmt.setString(8, facility_id); // MODIFIED_FACILITY_ID
		     pstmt.setString(9, facility_id); // MODIFIED_FACILITY_ID
		     pstmt.setString(10, encounter_id); // WHERE PATIENT_ID
			pstmt.setString(11, episode_id); // EVENT
		     pstmt.setString(12, patient_id); // WHERE PATIENT_ID
			pstmt.setString(13, srl_no); // EVENT
	        // Execute the update
	        updsStat = pstmt.executeUpdate();	

	        if (updsStat > 0) {
	            errorMsg = getMessage(locale, "RECORD_INSERTED", "CA");
	            error_value = "1";
	            // Audit Log for modified fields
	                con.commit();
	        }
	        else
			{
				con.rollback();
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;
			}
				
	        if(called_form.equals("PAS_TRANSCATION_INVOKING"))
	        {
				out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
	       // response.sendRedirect("../eCA/jsp/CAMenstrualHistDtlMessage.jsp?errorMsg=" +errorMsg  + "&called_form="+ called_form);	   
	        }
	        else{
	    	if("MENST_HIST_DTL".equals(option_id) || "MENST_HIST_DTL1".equals(option_id))   {
				 outPut2 = "<script>parent.frames(3).onSuccess();</script>"+"</BODY></html>";  
			}	else{
				outPut2 = "<script>parent.frames(3).location.reload();</script>"+"</BODY></html>";  
			}
				out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
		}
		}
		catch(Exception e )
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
		}
		finally
		{			
			if(con != null) ConnectionManager.returnConnection(con);	
		}
	}
	
	
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }

}
