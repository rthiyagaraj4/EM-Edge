/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
   File:	DRGCalculationServlet.java
   Date      Author			Changes
   Nov 18	Ravindranath	Created 
*/  
 
package eMR;

//import bl_generate_invoice.*;
import java.sql.*;
import java.io.*;
import java.util.Properties;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import javax.naming.*;
import javax.rmi.*;

import eCommon.XSSRequestWrapper;

/**
*	Class used to insert a request for calculating the drg values for in values passed.
*	And send back the response to the user with the calculated dgr results
**/

public class DRGCalculationServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	String requestBuilderProc = "{call XBDRG.DRGBUILDER(?,?,?,?,?,?,?,?,?,?,?)}";
	String calculateDRGProc = "{call XHINTERACTIVE.INTERACTIVE_INTERFAC_AUDIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	String requestDateFormat = "dd-MMM-yyyy HH:mm:ss";
	String locale = null;
	
	HashMap recodeDetails = new HashMap();
	StringBuffer sb = new StringBuffer("");
	HttpSession session = null;
	PrintWriter out;	
	Properties p;				
	Connection con = null;
	CallableStatement cs = null;

	String mr_requestText = "";
	String mr_requestSyntax = "";
	String mr_responseSyntax = "";
	String drg_flag = "";
	String bl_val = "";
	String err_lev = "";
	String sys_msg_id = "";
	String err_txt = "";
	String p_language_id = "";
	String  sStyle = "";
	String drgErrCode="";
	String  stage_no = "";
	String hdr_modified_dt_qr	= "";
	String L1_hdr_status		= "";
	String L2_hdr_status		= "";
	String L3_hdr_status		= "";
	String curr_level			= "";
	String procedure_yn		= "";
	String authorize_item	= "";
	ArrayList hdr_status_list =null;
	boolean recode_result = false;




	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			
			doPost(request,response);
		}
		catch(Exception e)	{	
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException 
	{

		String eventType = "";						
		String facility_id = "";
		String patient_id = "";
		String encounter_id = "";
		String profile_id = "";	
		String applicationID = "";
		String bl_install_yn = "";
		String p_episode_type = "";
		String recal_yn = "";
		String Patient_Class = "";
		String  sequenced_yn = "";
		



		//parent.frames(6).location.href = "../eCommon/jsp/MstCodeError.jsp?err_num=Processing DRG. Please wait";
		//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode("Processing DRG. Please wait","UTF-8"));



		HashMap requestDetails = new HashMap();
		HashMap results = null;

		try 
		{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			
			this.out = response.getWriter();
			session = request.getSession(false);
			
			sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			p = (Properties) session.getValue("jdbc");
			locale = p.getProperty("LOCALE");

			String userID = p.getProperty("login_user");
			String sessionID = session.getId();			

			String strClientHostName = p.getProperty("client_ip_address");
			String addedFacility = (String) session.getValue( "facility_id" ) ;
			String moduleID = "XB";
			String msgID = "";
			
			String mode = checkForNull(request.getParameter("req_mode"));

			//Recode start

			mr_requestText = (String)session.getAttribute("mr_requestText");
			mr_requestSyntax = (String)session.getAttribute("mr_requestSyntax");
			mr_responseSyntax = (String)session.getAttribute("mr_responseSyntax");
			drg_flag = checkForNull((String)session.getAttribute("drg_flag"));
			procedure_yn = checkNull(request.getParameter("procedure_yn"));
			authorize_item = checkForNull(request.getParameter("authorize_item"));
			bl_install_yn = checkForNull(request.getParameter("bl_install_yn"));
			p_episode_type = checkForNull(request.getParameter("p_episode_type"));
			recal_yn = checkForNull(request.getParameter("recal_yn"));
			Patient_Class = checkForNull(request.getParameter("Patient_Class"));
			sequenced_yn = checkForNull(request.getParameter("sequenced_yn"));
			p_language_id = checkForNull(request.getParameter("p_language_id"));
			stage_no = checkForNull(request.getParameter("stage_no"));
			/*Added On 4/27/2010 for PE*/
			if(Patient_Class.equals("IP"))
				p_episode_type="I";
			else if(Patient_Class.equals("EM"))
				p_episode_type="E";
			else if(Patient_Class.equals("DC"))
				p_episode_type="D";
			else if(Patient_Class.equals("OP"))
				p_episode_type="O";

			if(mode.equals("report"))
			{
				facility_id = request.getParameter("facility_id");
				patient_id = request.getParameter("Pat_id");
				encounter_id = request.getParameter("EncounterId");
				p_language_id = request.getParameter("p_language_id");
				doOnlineReports(request);

			}
			else if(mode != null && mode.equalsIgnoreCase("refresh")){
				msgID = request.getParameter("msg_id");
				results = getMsgData(msgID);

				//out.println("<html><script>parent.frames(6).location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( "Processing DRG. Please wait", "UTF-8" )+"&err_value=0"+"\";</script><body class='message'></html>");
			}else{

				facility_id = request.getParameter("facility_id");
				patient_id = request.getParameter("Pat_id");
				encounter_id = request.getParameter("EncounterId");
				profile_id = request.getParameter("profileID");
				eventType = request.getParameter("eventType");
				applicationID = request.getParameter("applicationID");
				
				//out.println("<html><script>parent.frames(6).location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( "Processing DRG. Please wait", "UTF-8" )+"&err_value=0"+"\";</script><body class='message'></html>");
			
				if(profile_id == null || profile_id.equals(""))
				{
					profile_id = "SRRDRG1"; // default profile id to be used as of now.
				}
				
				requestDetails.put("applicationID",applicationID);
				requestDetails.put("facility_id",facility_id);
				requestDetails.put("patient_id",patient_id);
				requestDetails.put("encounter_id",encounter_id);
				requestDetails.put("profile_id",profile_id);
				requestDetails.put("eventType",eventType);
				
				requestDetails.put("userid",userID);
				requestDetails.put("clientMachine",strClientHostName);
				requestDetails.put("pgmid","XBDRG");
				requestDetails.put("moduleID",moduleID);
				requestDetails.put("sessionID",sessionID);
				requestDetails.put("facilityID",facility_id);
				requestDetails.put("patientID",patient_id);
				requestDetails.put("mergedPatientID","");
				requestDetails.put("encounterID",encounter_id);
				requestDetails.put("profileID",profile_id);			
				requestDetails.put("addedBy",userID);
				requestDetails.put("modifiedBy",userID);
				requestDetails.put("addedWS",strClientHostName);
				requestDetails.put("addedFacility",addedFacility);
				requestDetails.put("modifiedWS",strClientHostName);
				requestDetails.put("modifiedFacility",addedFacility);

				
				//*****
				if(recal_yn.equals("Y")){ // done while DRG recalculation

					if(bl_install_yn.equalsIgnoreCase("Y"))
					{
								con = ConnectionManager.getConnection();		

							//if(inserted)
							//{
								String sqlbl = "{? = call BL_GENERATE_INVOICE.RECALCULATE_DRG(?,?,?,?,?,?,?)}";
								cs = con.prepareCall(sqlbl);
								cs.registerOutParameter(1,java.sql.Types.VARCHAR);

								cs.setString(2, facility_id);
								cs.setString(3, patient_id);
								cs.setString(4, p_episode_type);
								cs.setInt(5, Integer.parseInt(encounter_id));
								cs.registerOutParameter(6,java.sql.Types.VARCHAR);
								cs.registerOutParameter(7,java.sql.Types.VARCHAR);
								cs.registerOutParameter(8,java.sql.Types.VARCHAR);
								cs.executeUpdate();

								 bl_val = cs.getString(1);
								 err_lev = cs.getString(6);
								 sys_msg_id = cs.getString(7);
							 err_txt = cs.getString(8);
								if(err_lev == null)
									err_lev = "";

								if(sys_msg_id == null)
									sys_msg_id = "";

								if(err_txt == null)
									err_txt = "";

								

								if(bl_val.equals("Y"))
								{
									results = processDRGRequest(requestDetails);

									

									

									String seqNo1 = (String)results.get("seqNo");
									recodeDetails.put("seqNo",seqNo1);
									recodeDetails.put("procedure_yn",procedure_yn);
									recodeDetails.put("authorize_item",authorize_item);
									recodeDetails.put("patientID",patient_id);
									recodeDetails.put("encounterID",encounter_id);
									recodeDetails.put("facilityID",facility_id);
									recodeDetails.put("userid",userID);
									recodeDetails.put("clientMachine",strClientHostName);
									recodeDetails.put("sequenced_yn",sequenced_yn);
									recodeDetails.put("recal_yn",recal_yn);

									recode_result = recodeUpdate(recodeDetails);
									



									//out.println("<script> parent.frames(5).location.href=\"../eMR/jsp/DiagProcRecodingDRGFrames.jsp?results="+results+"\"</script>");
							
						}else{
									if (sys_msg_id != null)
									{
										java.util.Locale loc = new java.util.Locale(locale);
										java.util.ResourceBundle messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
										String blmessage = (String) messages.getString(sys_msg_id);
										sb.append(blmessage);

									}
									//if(err_lev == '10' && err_txt.equalsIgnoreCase(""))

									if (err_txt.equalsIgnoreCase("") && !err_lev.equals("10"))
									{
										sb.append(err_txt);
									}

						}

						
						
								if(bl_val.equals("Y")){
									String error = "";
									if(recode_result == true)
									{
										request.setAttribute("results",results);
										out.println("<script> parent.frames[5].location.href=\"../eMR/jsp/DPRecodingDRGFrames.jsp?DRGcal=Nresults="+results+"\"</script>");
										//String err_value="1";
										//dbConn.commit();
										 hdr_status_list=getAllhdrstatus(encounter_id,facility_id,request);
										L1_hdr_status	 = (String)hdr_status_list.get(0);
										L2_hdr_status	 = (String)hdr_status_list.get(1);
										L3_hdr_status	 = (String)hdr_status_list.get(2);
										curr_level			 = (String)hdr_status_list.get(3);
										hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
										Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
										error = (String)hashtable1.get("message");
										out.print("<script>alert('"+error+"')</script>");
										out.println("<script> parent.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\"</script>");
										out.println("<script> parent.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\"</script>");
										out.println("<script> parent.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=N&execute_hdr_qry=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\"</script>");
										//out.println("<script> parent.parent.frames(1).onSuccess_DRG();</script>");
										//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));
										if ( hashtable1 != null ) hashtable1.clear();
										//doOnlineReports(request);

									}
									else
									{
										//String err_value="0";
										//dbConn.rollback();
										response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
									}

								}else{

									out.println("<script> parent.frames[5].location.href=\"../eMR/jsp/DPRecodingDRGFrames.jsp?DRGcal=N&results="+results+"\"</script>");
									response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +sb.toString());
								}
							

						}
					}else{
							// called during authorise
							results = processDRGRequest(requestDetails);

							

									String seqNo1 = (String)results.get("seqNo");
									recodeDetails.put("seqNo",seqNo1);
									recodeDetails.put("procedure_yn",procedure_yn);
									recodeDetails.put("authorize_item",authorize_item);
									recodeDetails.put("patientID",patient_id);
									recodeDetails.put("encounterID",encounter_id);
									recodeDetails.put("facilityID",facility_id);
									recodeDetails.put("userid",userID);
									recodeDetails.put("clientMachine",strClientHostName);
									recodeDetails.put("recal_yn",recal_yn);

									recode_result = recodeUpdate(recodeDetails);

									String error = "";
									if(recode_result == true)
									{
										request.setAttribute("results",results);
										session.setAttribute("DRG_VAL",results);
										//out.println("<script> parent.frames(5).location.href=\"../eMR/jsp/DPRecodingDRGFrames.jsp?DRGcal=N&results="+results+"\"</script>");
										


										//String err_value="1";
										//dbConn.commit();
										 hdr_status_list=getAllhdrstatus(encounter_id,facility_id,request);
										L1_hdr_status	 = (String)hdr_status_list.get(0);
										L2_hdr_status	 = (String)hdr_status_list.get(1);
										L3_hdr_status	 = (String)hdr_status_list.get(2);
										curr_level			 = (String)hdr_status_list.get(3);
										hdr_modified_dt_qr	= (String)hdr_status_list.get(4);


										Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
										error = (String)hashtable1.get("message");

										//out.print("<script>alert('"+error+"')</script>");
										//out.print("<script>alert('popopopoo')</script>");
										
										out.println("<script> parent.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\"</script>");
										out.println("<script> parent.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\"</script>");
										out.println("<script> parent.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\"</script>");

										out.println("<script>parent.frames[5].location.href=\"../eMR/jsp/DPRecodingDRGFrames.jsp?DRGcal=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&p_language_id="+p_language_id+"\"</script>");//Modified @3/8/2010 For Adding stage_no for Query String.

										//out.println("<script> parent.frames(4).location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"\"</script>");
										
										//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));

										//out.println("<script> parent.parent.frames(1).onSuccess_DRG();</script>");
										doOnlineReports(request);
										if ( hashtable1 != null ) hashtable1.clear();

									}
									else
									{
										//String err_value="0";
										//dbConn.rollback();
										response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
									}
									//out.println("alert('before doOnlineReports');");
									

									//out.println("<script>window.close();</script>");
							




					}

				//recode start
			//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(sb.toString(),"UTF-8")));

			//}
			//if(drg_flag.equals("Recal"))
			//{
				//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( results, "UTF-8" ));

				//RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("/eMR/jsp/DiagProcRecodingDRGFrames.jsp");
				//reqDis.forward(request,response);						
			//}
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.err);
			//out.println("Exception in try of doPost() of DRGCalculationServlet.java"+ e.toString());
		}
		finally
		{
			if (session.getAttribute("mr_requestText") != null )
				session.removeAttribute("mr_requestText"); 

			if (session.getAttribute("mr_requestSyntax") != null )
				session.removeAttribute("mr_requestSyntax"); 


			if (session.getAttribute("mr_responseSyntax") != null )
				session.removeAttribute("mr_responseSyntax"); 

			if (session.getAttribute("drg_flag") != null )
				session.removeAttribute("drg_flag"); 


		}
	}	

	/**
	*	Method gets the request text by passing the required details and 
	*	inserts a request for calculating the drg values. 
	*	Response values will be populated back to the user once the request is processed.
	*	System will be continuesly checking for the response till it is available.	
	**/
	public HashMap processDRGRequest(HashMap requestDetails)
	{	
		Connection dbConn = null;
		CallableStatement requestStmt = null;
		CallableStatement responseStmt = null;	
		CallableStatement drgCalStmt = null; 
		CallableStatement respFetchStmt = null; 
	//	PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet responseRS = null;
		ResultSet rs = null;
	
		String requestSyntax = "";
		String responseSyntax = "";
		String requestText = "";		
		String responseText = null;
		String strDate = "";
		String errorCode = null;
		String errorMsg = null;
		String seqNo = "";
		String standardCode = "";
		String profileID = "";
	//	String resultQuery = "SELECT response_text,profile_id FROM xh_interactive_integration WHERE trx_no=?";		
		String resultQuery = "{call XHINTERACTIVE.INTERACTIVE_RESPONSE_FETCH(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		String p_err_code="";
		String p_err_TEXT="";

		int sleepParam = 2;
		int idleTime = 1;
		boolean idleTimeReached = false;

//		ArrayList elements = new ArrayList(); Commented For Open Connection Issues 10/22/2009
		HashMap results = new HashMap();		
		//HashMap recodeDetails = new HashMap();		

		try
		{	
			dbConn = ConnectionManager.getConnection();		
			
			if(drg_flag.equals("Recal")){
				
				requestText = mr_requestText;	
				requestSyntax = mr_requestSyntax;	
				responseSyntax = mr_responseSyntax;
				
			}else{
				requestStmt = dbConn.prepareCall(requestBuilderProc);

				requestStmt.setString(1,(String)requestDetails.get("applicationID"));
				requestStmt.setString(2,(String)requestDetails.get("facility_id"));
				requestStmt.setString(3,(String)requestDetails.get("patient_id"));
				requestStmt.setString(4,(String)requestDetails.get("encounter_id"));			
				requestStmt.setString(5,(String)requestDetails.get("eventType"));
				requestStmt.setString(6,(String)requestDetails.get("profile_id"));
				requestStmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				requestStmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				requestStmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				requestStmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				requestStmt.registerOutParameter(11,java.sql.Types.VARCHAR);

				requestStmt.execute();			

				requestText = requestStmt.getString(7);	
				requestSyntax = requestStmt.getString(8);	
				responseSyntax = requestStmt.getString(9);
				p_err_code = requestStmt.getString(10);
				p_err_TEXT = requestStmt.getString(11);
			}
			if(requestText != null){
				seqNo = String.valueOf(getSequenceNo());
				results.put("seqNo",seqNo);
				responseStmt = dbConn.prepareCall(calculateDRGProc);				
				strDate = getFormattedStringDate(requestDateFormat,null);
				responseStmt.setString(1,"I");
				responseStmt.registerOutParameter(2,java.sql.Types.VARCHAR);
				responseStmt.registerOutParameter(3,java.sql.Types.VARCHAR);
				responseStmt.setString(4,(String)requestDetails.get("userid"));
				responseStmt.setString(5,(String)requestDetails.get("clientMachine"));
				responseStmt.setString(6,(String)requestDetails.get("clientMachine"));
				responseStmt.setString(7,(String)requestDetails.get("pgmid"));
				responseStmt.setString(8,(String)requestDetails.get("moduleID"));
				responseStmt.setString(9,(String)requestDetails.get("sessionID"));
				responseStmt.setString(10,strDate);
				responseStmt.setString(11,requestText);
				responseStmt.setString(12,"TGRP");
				responseStmt.setString(13,seqNo);
				responseStmt.setString(14,(String)requestDetails.get("facility_id"));
				responseStmt.setString(15,strDate);
				responseStmt.setString(16,"D01");
				responseStmt.setString(17,(String)requestDetails.get("patient_id"));
				responseStmt.setString(18,"");
				responseStmt.setString(19,"");
				responseStmt.setString(20,(String)requestDetails.get("encounter_id"));
				responseStmt.setString(21,"");
				responseStmt.setString(22,"0");
				responseStmt.setString(23,requestSyntax);
				responseStmt.setString(24,"");
				responseStmt.setString(25,"");				
				responseStmt.setString(26,(String)requestDetails.get("addedBy"));
				responseStmt.setString(27,strDate);
				responseStmt.setString(28,(String)requestDetails.get("modifiedBy"));
				responseStmt.setString(29,strDate);
				responseStmt.setString(30,(String)requestDetails.get("addedWS"));
				responseStmt.setString(31,(String)requestDetails.get("addedFacility"));
				responseStmt.setString(32,(String)requestDetails.get("modifiedWS"));
				responseStmt.setString(33,(String)requestDetails.get("addedFacility"));
				responseStmt.setString(34,seqNo);
				responseStmt.setString(35,"");
				responseStmt.setString(36,responseSyntax);
				responseStmt.setString(37,(String)requestDetails.get("profile_id"));
				responseStmt.setString(38,"");
				responseStmt.setString(39,"");
				responseStmt.setString(40,"");
				responseStmt.execute();
				errorCode = responseStmt.getString(2);
				errorMsg = responseStmt.getString(3);
			//	errorCode = "E";
			//	errorMsg = "Error";
			}

			if(errorCode != null && errorCode.equalsIgnoreCase("S")){
				respFetchStmt = dbConn.prepareCall(resultQuery);

				respFetchStmt.setString(1,seqNo);						
				respFetchStmt.registerOutParameter(2,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(3,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(4,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(5,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(6,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(11,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(12,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(13,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(14,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(15,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(16,java.sql.Types.VARCHAR);
				respFetchStmt.registerOutParameter(17,java.sql.Types.VARCHAR);

			//	sleepParam = getThreadSleepTime();
				int param[] = getThreadSleepTime();
				sleepParam	= param[0];
				idleTime = param[1] * 1000;				

				
				long startTime = System.currentTimeMillis();
				long currentTimeDiff = System.currentTimeMillis() - startTime;

				while(true)
				{
					if(currentTimeDiff < idleTime)
					{
						Thread.sleep(sleepParam*1000); // Converting the sleep in seconds to milliseconds & make the thread sleep.
					/*	responseRS = respFetchStmt.executeQuery();
						if(responseRS.next())
						{
							responseText = responseRS.getString("response_text");
							profileID = responseRS.getString("profile_id");
							if(responseText != null) break;
						}
						if(responseRS != null) responseRS.close();
					*/	
						respFetchStmt.execute();
						errorCode = respFetchStmt.getString(16);
						if("S".equals(errorCode))	
						{
							results.put("drg",respFetchStmt.getString(4));
							results.put("desc",respFetchStmt.getString(5));
							results.put("rw",respFetchStmt.getString(6));
							results.put("ot",respFetchStmt.getString(7));
							results.put("wtlos",respFetchStmt.getString(8));
							results.put("mdc",respFetchStmt.getString(9));
							results.put("err",respFetchStmt.getString(10));
							results.put("warn",respFetchStmt.getString(11));
							results.put("result",respFetchStmt.getString(12));
							results.put("Callos",respFetchStmt.getString(13));
							results.put("adjrw",respFetchStmt.getString(14));							
							results.put("drgErrCode",errorCode);
							results.put("drgErrMsg",respFetchStmt.getString(17));
							profileID = respFetchStmt.getString(15);
							results.put("errTxt",respFetchStmt.getString(3)); // Error from XH_INTERACTIVE_INTEGRATION

							break;
						}
						else if("E".equals(errorCode))
						{
							results.put("drgErrCode",errorCode);
							results.put("drgErrMsg",respFetchStmt.getString(17));
						}						

						currentTimeDiff = System.currentTimeMillis() - startTime;
					}
					else
					{
						idleTimeReached = true;
						break;
					}
				}

			}else if(errorCode != null && !errorCode.equalsIgnoreCase("S"))	{
				results.put("drgErrCode",errorCode);
				results.put("drgErrMsg",errorMsg);
				return results;
			}
			
			if(idleTimeReached)
			{
				results.put("idletime","1");
			}
			else
			{
				responseText = responseText;
				stmt = dbConn.createStatement();
				rs = stmt.executeQuery("SELECT standard_code FROM xh_standard_profile WHERE profile_id='"+profileID+"'");
				if(rs.next())
				{
					standardCode = rs.getString("standard_code");
				}
				else
				{
					standardCode = "TGRP1";
				}

				if(rs != null) rs.close();
				if(stmt != null) stmt.close();

			/*** 
			Old logic - 
			New Logic will fetch the DRG values from the INTERACTIVE_RESPONSE_FETCH procedure directly (above while loop functionality)...
			
				elements.add(":DRG[38]");
				elements.add(":DRG[39]");
				elements.add(":DRG[40]");
				elements.add(":DRG[41]");
				elements.add(":DRG[42]");
				elements.add(":DRG[43]");
				elements.add(":DRG[44]");
				elements.add(":DRG[45]");
				elements.add(":DRG[48]");
				elements.add(":DRG[50]");		

				drgCalStmt = dbConn.prepareCall("begin ?:= XHGENERIC.GET_ELEMENT_VALUE(?,?,?); end;");
				drgCalStmt.registerOutParameter(1,java.sql.Types.VARCHAR);
				drgCalStmt.setString(2,responseText);
				drgCalStmt.setString(4,standardCode);

				String temp = "";
				for(int i=0;i<elements.size();i++)
				{
					drgCalStmt.setString(3,(String)elements.get(i));
					drgCalStmt.execute();

					temp = checkNull(drgCalStmt.getString(1));
					if(i == 0)results.put("drg",temp);
					else if(i == 1)results.put("rw",temp);
					else if(i == 2)results.put("ot",temp);
					else if(i == 3)results.put("wtlos",temp);
					else if(i == 4)results.put("mdc",temp);
					else if(i == 5)results.put("err",temp);
					else if(i == 6)results.put("warn",temp);
					else if(i == 7)results.put("result",temp);
					else if(i == 8)results.put("Callos",temp);
					else if(i == 9)results.put("adjrw",temp);
					results.put("drgErrCode",errorCode);
					results.put("drgErrMsg","");

				}
			*/
			}
		

		/*	while(true)
			{
				Thread.sleep(1000);
				responseStmt.execute();
				responseText = responseStmt.getString(2);
				if(responseText != null)
				{
					results.put("mdc",responseStmt.getString(5));
					results.put("drg",responseStmt.getString(4));
					results.put("rw",responseStmt.getString(9));
					results.put("wtlos",responseStmt.getString(10));
					results.put("ot",responseStmt.getString(11));
					results.put("adjrw",responseStmt.getString(12));
					results.put("error",responseStmt.getString(6));
					results.put("warn",responseStmt.getString(7));
					results.put("exceptions",responseStmt.getString(14));
					results.put("status",responseStmt.getString(13));	
					break;
				}					
			}
		*/
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);			
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
			String exceptionStr = ((String) mesg.get("message"));
			results.put("drgErrCode","E");
			results.put("drgErrMsg",exceptionStr);
		}
		finally
		{
			try
			{				
				if(rs != null) rs.close();
				if(responseRS != null) responseRS.close();
				if(responseStmt != null) responseStmt.close();
				if(requestStmt != null) requestStmt.close();
				if(drgCalStmt != null) drgCalStmt.close();				
				if(respFetchStmt != null) respFetchStmt.close();
				if(stmt != null) stmt.close();
				if(dbConn != null) ConnectionManager.returnConnection(dbConn);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}
		return results;
	}

	// Gets the next sequence no.
	private int getSequenceNo()
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		int seqNo = 0;
		String query = "SELECT xh_interactive_integration_seq.nextval FROM dual";

		try
		{
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			if(rs.next())
			{
				seqNo = rs.getInt(1);
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return seqNo;
	}

	/**
  * Method checks the Null String
  */
 public static String checkNull(String s)
 {
        return (((s == null)||(s.equals(""))||(s.equals("null"))||(s.equals(" "))) ? "" : s);
 }

/**
*  Method formats the "date" argument as per the "format" argument passed.
*  If the "date" argument is null, by default today's date will be considered.
*  Formatted date will returned as string
**/
public static String getFormattedStringDate(String format,java.util.Date date)
{	
	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	if (date == null)
	{
		date = new java.util.Date();
	}
	String dateFormatted = dateFormat.format(date);
	return dateFormatted;
}

public HashMap getMsgData(String msgID)
{
	ArrayList elements = new ArrayList();
	HashMap results = new HashMap();

	String responseText = "";
	String profileID = "";
	String standardCode = "";

	Connection con = null;
	Statement stmt = null;
	Statement stmt1 = null;
	CallableStatement drgCalStmt = null;
	ResultSet rs1 = null;
	ResultSet rs = null;

	try
	{
		con = ConnectionManager.getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT response_text,profile_id FROM xh_interactive_integration WHERE message_id='"+msgID+"'");
		if(rs.next())
		{
			responseText = rs.getString("response_text");
			profileID = rs.getString("profile_id");
		}
		
		if(stmt != null) stmt.close();

		responseText = responseText;
		stmt1 = con.createStatement();
		rs1 = stmt1.executeQuery("SELECT standard_code FROM xh_standard_profile WHERE profile_id='"+profileID+"'");
		if(rs1.next())
		{
			standardCode = rs1.getString("standard_code");
		}
		else
		{
			standardCode = "TGRP1";
		}

		elements.add(":DRG[38]");
		elements.add(":DRG[39]");
		elements.add(":DRG[40]");
		elements.add(":DRG[41]");
		elements.add(":DRG[42]");
		elements.add(":DRG[43]");
		elements.add(":DRG[44]");
		elements.add(":DRG[45]");
		elements.add(":DRG[48]");
		elements.add(":DRG[50]");		

		drgCalStmt = con.prepareCall("begin ?:= XHGENERIC.GET_ELEMENT_VALUE(?,?,?); end;");
		drgCalStmt.registerOutParameter(1,java.sql.Types.VARCHAR);
		drgCalStmt.setString(2,responseText);
		drgCalStmt.setString(4,standardCode);

		String temp = "";
		for(int i=0;i<elements.size();i++)
		{
			drgCalStmt.setString(3,(String)elements.get(i));
			drgCalStmt.execute();

			temp = checkNull(drgCalStmt.getString(1));
			if(i == 0)results.put("drg",temp);
			else if(i == 1)results.put("rw",temp);
			else if(i == 2)results.put("ot",temp);
			else if(i == 3)results.put("wtlos",temp);
			else if(i == 4)results.put("mdc",temp);
			else if(i == 5)results.put("err",temp);
			else if(i == 6)results.put("warn",temp);
			else if(i == 7)results.put("result",temp);
			else if(i == 8)results.put("Callos",temp);
			else if(i == 9)results.put("adjrw",temp);
			results.put("drgErrCode","S");
		}

	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
			if(drgCalStmt != null) drgCalStmt.close();
			if(rs1 != null) rs1.close();
			if(rs != null) rs.close();
			if(con != null) ConnectionManager.returnConnection(con);			
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
	}
	return results;
}

public int[] getThreadSleepTime()
{
//	int sleepParam = 2;Commented For Open Connection Issues 10/22/2009
//	int idleTime = 1;Commented For Open Connection Issues 10/22/2009
	int param[] = new int[2];
	String queryInteractiveConnectParam = "SELECT sleepinterval,comm_process_idle_time FROM xh_interactive_connect_param WHERE plugin_type='DRG'";

	Connection dbConn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try
	{
		dbConn = ConnectionManager.getConnection();
		stmt = dbConn.createStatement();
		rs = stmt.executeQuery(queryInteractiveConnectParam);
		if(rs.next())
		{
			param[0] = rs.getInt("sleepinterval");
			param[1] = rs.getInt("comm_process_idle_time");
		}
		if(stmt != null) stmt.close();

	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(dbConn != null) ConnectionManager.returnConnection(dbConn);
		}
		catch(Exception fexp)
		{
			fexp.printStackTrace(System.err);
		}
	}
	return param;
}

public boolean saveDRG(HashMap recodeDetails)
{
		Connection dbConn1 = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sql1 = new StringBuffer();
		boolean recode_result = false;
		//String orig_termset = "";
		//String orig_termcode = "";
		int res1 = 0;
		//int temp = 0;
		int trx_no = 0;


		String seqNo = (String)recodeDetails.get("seqNo");
		//String proc_yn = (String)recodeDetails.get("procedure_yn");
		//String authorize_item = (String)recodeDetails.get("authorize_item");
		String patientID = (String)recodeDetails.get("patientID");
		String encounterID = (String)recodeDetails.get("encounterID");
		String facilityID = (String)recodeDetails.get("facilityID");
		String userID = (String)recodeDetails.get("userid");
		String strClientHostName = (String)recodeDetails.get("clientMachine");
		String sequenced_yn = (String)recodeDetails.get("sequenced_yn");
		//String recal_yn = (String)recodeDetails.get("recal_yn");
		trx_no = Integer.parseInt(seqNo);

		if(sequenced_yn == null)
			sequenced_yn="";
		try
		{
			dbConn1 = ConnectionManager.getConnection();
				if(sql1.length() > 0 ) 
					sql1.delete(0,sql1.length());

				// status update
				sql1.append("UPDATE MR_DIAG_PROC_RECODING_HDR SET ");
				
				if(sequenced_yn.equals("Y"))
				{
					sql1.append("  SEQUENCED_YN ='"+sequenced_yn+"' ,");
				}

				sql1.append(" TRX_NO='"+trx_no+"', MODIFIED_BY_ID='"+userID+"' , MODIFIED_DATE=sysdate , MODIFIED_AT_WS_NO='"+strClientHostName+"' , MODIFIED_FACILITY_ID='"+facilityID+"' WHERE PATIENT_ID='"+patientID+"' AND ENCOUNTER_ID='"+encounterID+"' AND FACILITY_ID='"+facilityID+"'"); 
				stmt = dbConn1.createStatement();
				res1 = stmt.executeUpdate(sql1.toString()); 
				if(res1 != 0)
				{
					recode_result = true;
					dbConn1.commit();
				}
				else
				{
					recode_result = false;
					dbConn1.rollback();
				}
				if(stmt != null) stmt.close();
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(dbConn1 != null) ConnectionManager.returnConnection(dbConn1);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}


	return recode_result;

}


public boolean recodeUpdate(HashMap recodeDetails)
{
		Connection dbConn1 = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sql1 = new StringBuffer();
		boolean recode_result = false;
		//String orig_termset = "";
		//String orig_termcode = "";
		int res1 = 0;
		//int temp = 0;
		int trx_no = 0;


		String seqNo = (String)recodeDetails.get("seqNo");
		//String proc_yn = (String)recodeDetails.get("procedure_yn");
		//String authorize_item = (String)recodeDetails.get("authorize_item");
		String patientID = (String)recodeDetails.get("patientID");
		String encounterID = (String)recodeDetails.get("encounterID");
		String facilityID = (String)recodeDetails.get("facilityID");
		String userID = (String)recodeDetails.get("userid");
		String strClientHostName = (String)recodeDetails.get("clientMachine");
		String sequenced_yn = (String)recodeDetails.get("sequenced_yn");
		//String recal_yn = (String)recodeDetails.get("recal_yn");
		trx_no = Integer.parseInt(seqNo);

		if(sequenced_yn == null)
			sequenced_yn="";
		


		try
		{
			dbConn1 = ConnectionManager.getConnection();

					
										
				if(sql1.length() > 0 ) 
					sql1.delete(0,sql1.length());

				// status update
				sql1.append("UPDATE MR_DIAG_PROC_RECODING_HDR SET ");
				
				//if(sequenced_yn.equals("Y")){
					sql1.append("  SEQUENCED_YN ='Y' ,");
				//}

				sql1.append(" TRX_NO='"+trx_no+"', MODIFIED_BY_ID='"+userID+"' , MODIFIED_DATE=sysdate , MODIFIED_AT_WS_NO='"+strClientHostName+"' , MODIFIED_FACILITY_ID='"+facilityID+"' WHERE PATIENT_ID='"+patientID+"' AND ENCOUNTER_ID='"+encounterID+"' AND FACILITY_ID='"+facilityID+"'"); 
				stmt = dbConn1.createStatement();
				res1 = stmt.executeUpdate(sql1.toString()); 
				if(res1 != 0)
				{
					recode_result = true;
					dbConn1.commit();
				}
				else
				{
					recode_result = false;
					dbConn1.rollback();
				}
				if(stmt != null) stmt.close();
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(dbConn1 != null) ConnectionManager.returnConnection(dbConn1);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}


	return recode_result;

}





private void doOnlineReports(HttpServletRequest request) throws ServletException, IOException, SQLException
{
		StringBuffer htmlFor =new StringBuffer();
		htmlFor.setLength(0);
		String reportParamNames = "";
		String reportParamValues = "";
		String encounter_id = "";
		String facility_id = "";
		String patient_id = "";
		String p_language_id = "";		
		String mode = "";		
		//String p_locn_code="";
		//String p_locn_type="";

		//PrintWriter out = response.getWriter();
		try
		{
			
		
		facility_id = (String) session.getValue( "facility_id" ) ;
		patient_id = request.getParameter("Pat_id");
		encounter_id = request.getParameter("EncounterId");
		p_language_id = request.getParameter("p_language_id");
		mode = checkForNull(request.getParameter("req_mode"));

		//p_language_id=locale;


		
		String sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MR' AND REPORT_ID = 'MRDGRCSM'";	
		
		reportParamNames = "p_encounter_id,p_facility_id,p_patient_id";
		reportParamValues = ""+encounter_id+","+facility_id+","+patient_id+"";
		if(mode.equals("report")){
			htmlFor.append(" <html><head> <script src='../eCommon/js/showModalDialog.js' language='javascript'></script> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			htmlFor.append("</head><body class	='message'>");
			htmlFor.append( "<script language	= 'JavaScript'>");
			htmlFor.append("  var dialogHeight	= '450px';");
			htmlFor.append("  var dialogWidth	= '700px';");
			htmlFor.append("  var dialogTop		= '58';");
			htmlFor.append("  var arguments		=	'';");
			htmlFor.append("  var getUrl		=	'../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&EncounterId="+encounter_id+"&Patient_ID="+patient_id+"';");
			htmlFor.append("var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status=no;' ;");
			htmlFor.append("retVal = window.showModalDialog(getUrl,arguments,features);");
			htmlFor.append(" </script>");
			out.println(htmlFor.toString());
			out.println("</body></html>");
		}else if(!mode.equals("report")){
			out.println("<script> parent.parent.frames[1].onSuccess_DRG();</script>");
		}

		}
		catch (Exception e)
		{
			//out.println("Online report:"+e.toString());
			e.printStackTrace();
		}
	
}
public ArrayList getAllhdrstatus(String encounter_id,String facility_id,HttpServletRequest req){
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	ArrayList hdr_status_list = new ArrayList();
	try{
				con = ConnectionManager.getConnection(req);
				String L1_hdr_status	 ="";
				String L2_hdr_status	 ="";
				String L3_hdr_status	 ="";
				String curr_level		 ="";
				String hdr_modified_dt		 ="";
				String sql_hdr_sts="SELECT CURR_LEVEL, nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS,to_char(modified_date,'dd/mm/yyyy hh24:mi:sssss') MODIFIED_DATE FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"'";
				pstmt = con.prepareStatement(sql_hdr_sts);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					L1_hdr_status	= rs.getString("LEVEL1_STATUS");
					L2_hdr_status	= rs.getString("LEVEL2_STATUS");
					L3_hdr_status	= rs.getString("LEVEL3_STATUS");
					curr_level			= rs.getString("CURR_LEVEL");
					hdr_modified_dt	= rs.getString("MODIFIED_DATE");
					hdr_status_list.add(L1_hdr_status);
					hdr_status_list.add(L2_hdr_status);
					hdr_status_list.add(L3_hdr_status);
					hdr_status_list.add(curr_level);
					hdr_status_list.add(hdr_modified_dt);
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			}catch(Exception ex){
				ex.printStackTrace();
	}finally{
			if(con != null){
				ConnectionManager.returnConnection(con,p);
		}
	}
	return hdr_status_list;
}
	public static String checkForNull(String s){
        return s != null && !s.equals("null") ? s : "";
    }
	
	public static String checkForNull(String inputString, String defaultValue) {
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? defaultValue : inputString );
	}		
	
}//end of class - DRGCalculationServlet
