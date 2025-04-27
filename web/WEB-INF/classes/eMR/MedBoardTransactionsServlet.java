/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
* @Author		: SRIDHAR R 
* @Created on	: 28 MARCH 2005
* @Transaction	: MEDICAL BOARD
			Function name				|		Function ID			| REQUEST_STATUS inserted...

	Request For Medical Board			| MEDICAL_BOARD_REQUEST		|		1
	Status of Medical Board Request		| MEDICAL_BOARD_STATUS		|		2
	Formation of Medical Board			| MEDICAL_BOARD_FORMATION	|		3
	Forward Medical Board Request		| FORWARD_MEDICAL_BOARD		|		4
	Appointment for Med Board request	| MEDICAL_BOARD_APPT		|		5
	Intimate Appointment of Med Board	| MEDICAL_BOARD_INT_APPT	|		6
	Prepare Medical Report by Board		| PREPARE_MEDICAL_BOARD		|		7
	Receive Medical Report				| RECEIVE_MEDICAL_BOARD		|		8
	Deliver/Dispatch Medical Report		| DELIVER_MEDICAL_BOARD		|		9
 */

package eMR;

import java.sql.*;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import java.util.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.SingleTabHandler.*;

public class MedBoardTransactionsServlet extends javax.servlet.http.HttpServlet 
{
    PrintWriter out;
    Properties p;
    String client_ip_address ;
	String facilityId;
	Statement OA_Stmt	= null;
	ResultSet OA_Rs		= null;
	Statement stmt = null;
	ResultSet rs = null;
	String appt_ref_no	= "";
	String apptslabfmtime	= "";
	String apptslabtotime	= "";
	String cliniccode	= "";
	String patientid	= "";
	String sStyle="";
	String locale="";

//	MedBoardReqFormBean record;

    HttpSession session;
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
       	session = req.getSession(false);
       	sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		 this.p = (Properties) session.getValue( "jdbc" ) ;
	        this.facilityId = (String) session.getValue( "facility_id" ) ;
	        client_ip_address = p.getProperty("client_ip_address");
			locale = p.getProperty("LOCALE");	
			this.out = res.getWriter();
			//code changed for EDGE by kaviyarasan
        out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
 		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
 		out.println("async function callMedBoardTransactionsServletHTML() { ");
		updateBoardValues(req);
		out.println("} callMedBoardTransactionsServletHTML();</script></body></html>");
    }

private void updateBoardValues(HttpServletRequest req)
{
	Connection con =null;
	String request_status ="";
	String prepare_date = "";
	String cons_letter = "";
	String appl_status   = "";
	try
	{
		con = ConnectionManager.getConnection(req);
		String call_function =  req.getParameter("call_function");
			if(call_function == null) call_function = "";

		if(call_function.equals("MEDICAL_BOARD_REQUEST"))
			request_status = "1";
		else if(call_function.equals("MEDICAL_BOARD_STATUS"))
			request_status = "2";
		else if(call_function.equals("FORWARD_MEDICAL_BOARD"))
			request_status = "4";
		else if(call_function.equals("MEDICAL_BOARD_FORMATION"))
			request_status = "3";
		else if(call_function.equals("MEDICAL_BOARD_APPT"))
			request_status = "5";
		else if(call_function.equals("MEDICAL_BOARD_INT_APPT"))
			request_status = "6";
		else if(call_function.equals("PREPARE_MEDICAL_BOARD"))
			request_status = "7";
		else if(call_function.equals("RECEIVE_MEDICAL_BOARD"))
			request_status = "8";
		else if(call_function.equals("DELIVER_MEDICAL_BOARD"))
			request_status = "9";

		String called_from = "";	
		String request_id   =  checkForNull(req.getParameter("request_id"));

		String remarks	= req.getParameter("remarks");
			if(remarks == null) remarks = "";

		String patient_id = checkForNull(req.getParameter("patient_id"));

		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String addedFacilityId=facilityId;
		String modifiedFacilityId = addedFacilityId ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

		HashMap tabdata=new HashMap();

		if(call_function.equals("MEDICAL_BOARD_STATUS"))
		{
			appl_status    =  req.getParameter("appl_status");
				if(appl_status == null) appl_status = "";
			
			cons_letter	= checkForNull(req.getParameter("cons_letter"));

			if(appl_status.equals("2")) // Complete
				request_status = "2";
			else if(appl_status.equals("1")) // InComplete
				request_status = "1";

			if(appl_status.equals("2")) // Complete
			{
				String requestStatus = "";
				String selectSql = " select REQUEST_STATUS from MR_REPORT_REQUEST_HDR where facility_id='"+facilityId+"' and REQUEST_ID = '"+request_id+"' ";

				stmt = con.createStatement();
				rs	=	stmt.executeQuery(selectSql);
				if (rs.next() && rs != null)
				{
					requestStatus = rs.getString("REQUEST_STATUS");
				}
				if(requestStatus.equals("3"))
					request_status = "3";
			}

			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			String reqd_docs    =  req.getParameter("reqd_docs");
				if(reqd_docs == null) reqd_docs = "";

			String board_type    =  req.getParameter("board_type");
				if(board_type == null) board_type = "";

			String appl_comp_date    =  req.getParameter("sysdate");
				if(appl_comp_date == null) appl_comp_date = "";

			
			if(appl_status.equals("2") && !appl_comp_date.equals(""))
			{
				StringTokenizer appl_comp_date_toks = new StringTokenizer (appl_comp_date," ") ;
				StringTokenizer appl_comp_date_toks1 = new StringTokenizer (appl_comp_date_toks.nextToken(), "/" ) ;

				String appl_comp_Arr[] =new String[3] ;
				for( int q=0;q<3;q++ )
						appl_comp_Arr[q] = appl_comp_date_toks1.nextToken() ;
				StringBuffer sb_appl_comp_date = new StringBuffer();
				sb_appl_comp_date.append(appl_comp_Arr[2]+"-");
				sb_appl_comp_date.append(appl_comp_Arr[1]+"-");
				sb_appl_comp_date.append(appl_comp_Arr[0]+" ");
				sb_appl_comp_date.append(appl_comp_date_toks.nextToken()+":00");
				appl_comp_date = sb_appl_comp_date.toString();

				//appl_comp_date = appl_comp_Arr[2] +"-"+appl_comp_Arr[1]+"-"+ appl_comp_Arr[0]+" "+appl_comp_date_toks.nextToken()+":00"   ;
				Timestamp appCompDate= Timestamp.valueOf(appl_comp_date);

				tabdata.put("APPL_COMPLETION_DATE",appCompDate);
			}		

			String collect_date    =  req.getParameter("collect_date");

		
				if(collect_date == null) 
					collect_date = "";	
				else
					collect_date = DateUtils.convertDate(collect_date,"DMYHM",locale,"en");
			
				
			if(!collect_date.equals(""))
			{
				StringTokenizer collecttoks = new StringTokenizer (collect_date," ") ;
				StringTokenizer collecttok1 = new StringTokenizer (collecttoks.nextToken(), "/" ) ;
				String collectArr[] =new String[3] ;
				for( int q=0;q<3;q++ )
						collectArr[q] = collecttok1.nextToken() ;
				StringBuffer sb_collect_date = new StringBuffer();
				sb_collect_date.append(collectArr[2]+"-");
				sb_collect_date.append(collectArr[1]+"-");
				sb_collect_date.append(collectArr[0]+" ");
				sb_collect_date.append(collecttoks.nextToken()+":00");
				collect_date = sb_collect_date.toString();

				//collect_date = collectArr[2] +"-"+collectArr[1]+"-"+ collectArr[0]+" "+collecttoks.nextToken()+":00"   ;
				Timestamp collectTimestamp= Timestamp.valueOf(collect_date);

				tabdata.put("COLLECT_DATE",collectTimestamp);
			}		

			String charges_appllicable_yn = req.getParameter("charges_appllicable");
			if(charges_appllicable_yn.equals("") || charges_appllicable_yn == null )
				charges_appllicable_yn  = "N";
			tabdata.put("CHARGES_APPL_YN",charges_appllicable_yn);

			String additional_charges_yn = req.getParameter("additional_charges");
			if(additional_charges_yn.equals("") || additional_charges_yn == null )
				additional_charges_yn  = "N";
			tabdata.put("ADDL_CHARGES_YN",additional_charges_yn);

			tabdata.put("AMOUNT",checkForNull(req.getParameter("amount")));
			tabdata.put("ADDL_AMOUNT",checkForNull(req.getParameter("add_amount")));

			tabdata.put("RECEIPT_NO",checkForNull(req.getParameter("recp_no")));
			tabdata.put("ADDL_RECEIPT_NO",checkForNull(req.getParameter("add_recp_no")));


			String recp_dat		=  checkForNull(req.getParameter("recp_dat"));
		

			if(!recp_dat.equals(""))
			{
				recp_dat = DateUtils.convertDate(recp_dat,"DMYHM",locale,"en");
			
				StringTokenizer recp_dattoks = new StringTokenizer (recp_dat," ") ;
				StringTokenizer recp_dattok1 = new StringTokenizer (recp_dattoks.nextToken(), "/" ) ;
				String recp_datArr[] =new String[3] ;
				for( int r=0;r<3;r++ )
					recp_datArr[r] = recp_dattok1.nextToken() ;
				StringBuffer sb_recp_dat = new StringBuffer();
				sb_recp_dat.append(recp_datArr[2]+"-");
				sb_recp_dat.append(recp_datArr[1]+"-");
				sb_recp_dat.append(recp_datArr[0]+" ");
				sb_recp_dat.append(recp_dattoks.nextToken()+":00");
				recp_dat = sb_recp_dat.toString();
				//recp_dat = recp_datArr[2] +"-"+recp_datArr[1]+"-"+ recp_datArr[0]+" "+recp_dattoks.nextToken()+":00"   ;
				Timestamp recp_datTimestamp= Timestamp.valueOf(recp_dat);
				tabdata.put("RECEIPT_DATE",recp_datTimestamp);
			}

			String add_recp_dat		=  checkForNull(req.getParameter("add_recp_dat"));
			if (add_recp_dat != null && !add_recp_dat.equals(""))
			{
				add_recp_dat = DateUtils.convertDate(add_recp_dat,"DMYHM",locale,"en");
			
				StringTokenizer add_recp_dat_toks = new StringTokenizer (add_recp_dat," ") ;
				StringTokenizer add_recp_dat_tok1 = new StringTokenizer (add_recp_dat_toks.nextToken(), "/" ) ;
				String add_recp_dat_Arr[] =new String[3] ;
				for( int r=0;r<3;r++ )
				add_recp_dat_Arr[r] = add_recp_dat_tok1.nextToken() ;
				StringBuffer sb_add_recp_dat = new StringBuffer();
				sb_add_recp_dat.append(add_recp_dat_Arr[2]+"-");
				sb_add_recp_dat.append(add_recp_dat_Arr[1]+"-");
				sb_add_recp_dat.append(add_recp_dat_Arr[0]+" ");
				sb_add_recp_dat.append(add_recp_dat_toks.nextToken()+":00");
				add_recp_dat = sb_add_recp_dat.toString();
				//add_recp_dat = add_recp_dat_Arr[2] +"-"+add_recp_dat_Arr[1]+"-"+ add_recp_dat_Arr[0]+" "+add_recp_dat_toks.nextToken()+":00"   ;

				Timestamp add_recp_dat_Timestamp= Timestamp.valueOf(add_recp_dat);
				tabdata.put("ADDL_RECEIPT_DATE",add_recp_dat_Timestamp);
			}

				tabdata.put("APPL_STATUS",appl_status);
				tabdata.put("CONSENT_LETTER_APPL",cons_letter);
				tabdata.put("REQUIRED_DOCS",reqd_docs);
				tabdata.put("MED_BOARD_TYPE_CODE",board_type);
				tabdata.put("REQUEST_STATUS",request_status);
		}
		else if(call_function.equals("FORWARD_MEDICAL_BOARD"))
		{
			String forwarded_pract_id = checkForNull(req.getParameter("fwd_pract_desc"));
			tabdata.put("FORWARDED_PRACT_ID",forwarded_pract_id);

			String rep_type = checkForNull(req.getParameter("rep_type"));
			tabdata.put("REPORT_TYPE_CODE",rep_type);

			String Splcode = checkForNull(req.getParameter("Splcode"));
			tabdata.put("SPECIALTY_CODE",Splcode);

			String appl_sub_dt    =  checkForNull(req.getParameter("appl_sub_dt"));

	
			if(!appl_sub_dt.equals(""))
			{
				StringTokenizer appl_sub_dt_toks = new StringTokenizer (appl_sub_dt," ") ;
				StringTokenizer appl_sub_dt_toks1 = new StringTokenizer (appl_sub_dt_toks.nextToken(), "/" ) ;

				String appl_sub_Arr[] =new String[3] ;
				for( int q=0;q<3;q++ )
						appl_sub_Arr[q] = appl_sub_dt_toks1.nextToken() ;
				StringBuffer sb_appl_sub_dt = new StringBuffer();
				sb_appl_sub_dt.append(appl_sub_Arr[2]+"-");
				sb_appl_sub_dt.append(appl_sub_Arr[1]+"-");
				sb_appl_sub_dt.append(appl_sub_Arr[0]+" ");
				sb_appl_sub_dt.append(appl_sub_dt_toks.nextToken()+":00");
				appl_sub_dt = sb_appl_sub_dt.toString();

				//appl_sub_dt = appl_sub_Arr[2] +"-"+appl_sub_Arr[1]+"-"+ appl_sub_Arr[0]+" "+appl_sub_dt_toks.nextToken()+":00"   ;
				Timestamp appFwdDate = Timestamp.valueOf(appl_sub_dt);
				tabdata.put("APPL_SUBMITTED_DATE",appFwdDate);
			}		

			tabdata.put("REQUEST_STATUS",request_status);
		}
		else if(call_function.equals("PREPARE_MEDICAL_BOARD"))
		{
			called_from = req.getParameter("called_from")==null?"":req.getParameter("called_from");
			String accession_num = req.getParameter("accession_num")==null?"":req.getParameter("accession_num");

			prepare_date =  req.getParameter("prepare_date");
			
				if(prepare_date == null) 
					prepare_date = "";
				else
					prepare_date = DateUtils.convertDate(prepare_date,"DMYHM",locale,"en");

			

			if(called_from.equals("CA") && prepare_date.equals(""))
			{
				tabdata.put("ACCESSION_NUM",accession_num);
			}
			else
			{
				String prepare_pract_id = req.getParameter("prep_practitioner_id");
					if(prepare_pract_id == null) prepare_pract_id = "";
				tabdata.put("PREPARE_PRACT_ID",prepare_pract_id);

				//To Convert Prepare date into TimeStamp Format
				
				StringTokenizer preparetoks = new StringTokenizer (prepare_date," ") ;
				StringTokenizer preparetok1 = new StringTokenizer (preparetoks.nextToken(), "/" ) ;
				String prepareArr[] =new String[3] ;
				for( int p=0;p<3;p++ )
						prepareArr[p] = preparetok1.nextToken();
				StringBuffer sb_prepare_date = new StringBuffer();
				sb_prepare_date.append(prepareArr[2]+"-");
				sb_prepare_date.append(prepareArr[1]+"-");
				sb_prepare_date.append(prepareArr[0]+" ");
				sb_prepare_date.append(preparetoks.nextToken()+":00");
				prepare_date = sb_prepare_date.toString();

				//prepare_date = prepareArr[2] +"-"+prepareArr[1]+"-"+ prepareArr[0]+" "+preparetoks.nextToken()+":00"   ;
				Timestamp prepareTimestamp= Timestamp.valueOf(prepare_date);
				
				tabdata.put("PREPARED_DATE",prepareTimestamp);
				tabdata.put("REQUEST_STATUS",request_status);		
				tabdata.put("ACCESSION_NUM",accession_num);
			}
		}
		else if(call_function.equals("RECEIVE_MEDICAL_BOARD"))
		{
			//To Convert Receive date into TimeStamp Format
			String receive_date =  req.getParameter("receive_date");

			
				if(receive_date == null) 
					receive_date = "";
				else
					receive_date = DateUtils.convertDate(receive_date,"DMYHM",locale,"en");

			

			StringTokenizer receivetoks = new StringTokenizer (receive_date," ") ;
			StringTokenizer receivetok1 = new StringTokenizer (receivetoks.nextToken(), "/" ) ;
			String receiveArr[] =new String[3] ;
			for( int q=0;q<3;q++ )
				receiveArr[q] = receivetok1.nextToken();
			StringBuffer sb_receive_date = new StringBuffer();
			sb_receive_date.append(receiveArr[2]+"-");
			sb_receive_date.append(receiveArr[1]+"-");
			sb_receive_date.append(receiveArr[0]+" ");
			sb_receive_date.append(receivetoks.nextToken()+":00");
			receive_date = sb_receive_date.toString();

			//receive_date = receiveArr[2] +"-"+receiveArr[1]+"-"+ receiveArr[0]+" "+receivetoks.nextToken()+":00"   ;
			Timestamp receiveTimestamp= Timestamp.valueOf(receive_date);
			tabdata.put("RECEIVED_DATE",receiveTimestamp);
			tabdata.put("REQUEST_STATUS",request_status);
		}
		else if(call_function.equals("DELIVER_MEDICAL_BOARD"))
		{
			String del_addr_line1		= "";
			String del_addr_line2		= "";
			String del_addr_line3		= "";
			String del_addr_line4		= "";
			String del_res_town_code	= "";
			String del_res_area_code	= "";
			String del_region_code		= "";
			String del_postal_code		= "";
			String del_country_code		= "";

			// To Convert Delivered date into TimeStamp Format
			String delivered_date =  req.getParameter("delivered_date");

			
			if(delivered_date == null) 
				delivered_date = "";
			else
				delivered_date = DateUtils.convertDate(delivered_date,"DMYHM",locale,"en");


			StringTokenizer delivertoks = new StringTokenizer (delivered_date," ") ;
			StringTokenizer delivertok1 = new StringTokenizer (delivertoks.nextToken(), "/" ) ;
			String deliverArr[] =new String[3] ;
			for( int r=0;r<3;r++ )
			deliverArr[r] = delivertok1.nextToken() ;
			StringBuffer sb_delivered_date = new StringBuffer();
			sb_delivered_date.append(deliverArr[2]+"-");
			sb_delivered_date.append(deliverArr[1]+"-");
			sb_delivered_date.append(deliverArr[0]+" ");
			sb_delivered_date.append(delivertoks.nextToken()+":00");
			delivered_date = sb_delivered_date.toString();

			//delivered_date = deliverArr[2] +"-"+deliverArr[1]+"-"+ deliverArr[0]+" "+delivertoks.nextToken()+":00"   ;
			Timestamp deliverTimestamp= Timestamp.valueOf(delivered_date);

			tabdata.put("DELIVERED_DATE",deliverTimestamp);
			tabdata.put("REQUEST_STATUS",request_status);


			String Despatch_mode = checkForNull(req.getParameter("Despatch_mode"));
			if(Despatch_mode.equals("O"))
			{
				del_addr_line1		= checkForNull(req.getParameter("other_del_addr_line1"));
				del_addr_line2		= checkForNull(req.getParameter("other_del_addr_line2"));	
				del_addr_line3		= checkForNull(req.getParameter("other_del_addr_line3"));	
				del_addr_line4		= checkForNull(req.getParameter("other_del_addr_line4"));	
				del_res_town_code	= checkForNull(req.getParameter("other_del_res_town_code"));	
				del_res_area_code	= checkForNull(req.getParameter("other_del_res_area_code"));	
				del_region_code		= checkForNull(req.getParameter("other_del_region_code"));	
				del_postal_code		= checkForNull(req.getParameter("other_del_postal_code"));
				del_country_code	= checkForNull(req.getParameter("other_del_country_code"));
			}
			else if(Despatch_mode.equals("P"))
			{

				del_addr_line1		= checkForNull(req.getParameter("personal_del_addr_line1"));
				del_addr_line2		= checkForNull(req.getParameter("personal_del_addr_line2"));	
				del_addr_line3		= checkForNull(req.getParameter("personal_del_addr_line3"));	
				del_addr_line4		= checkForNull(req.getParameter("personal_del_addr_line4"));	
				del_res_town_code	= checkForNull(req.getParameter("personal_del_res_town_code"));	
				del_res_area_code	= checkForNull(req.getParameter("personal_del_res_area_code"));	
				del_region_code		= checkForNull(req.getParameter("personal_del_region_code"));	
				del_postal_code		= checkForNull(req.getParameter("personal_del_postal_code"));
				del_country_code	= checkForNull(req.getParameter("personal_del_country_code"));
			}

		//for delivery address...
		/*
			String del_addr_line1			= checkForNull(req.getParameter("del_addr_line1"));
			String del_addr_line2			= checkForNull(req.getParameter("del_addr_line2"));	
			String del_addr_line3			= checkForNull(req.getParameter("del_addr_line3"));	
			String del_addr_line4			= checkForNull(req.getParameter("del_addr_line4"));	
			String del_res_town_code	= checkForNull(req.getParameter("del_res_town_code"));	
			String del_res_area_code	= checkForNull(req.getParameter("del_res_area_code"));	
			String del_region_code		= checkForNull(req.getParameter("del_region_code"));	
			String del_postal_code		= checkForNull(req.getParameter("del_postal_code"));
			String del_country_code	= checkForNull(req.getParameter("del_country_code"));
*/
//			String Despatch_mode		= checkForNull(req.getParameter("Despatch_mode"));
			String file_no						= checkForNull(req.getParameter("file_no"));
			String report_taken			= checkForNull(req.getParameter("report_taken"));
			String del_nric_no				= checkForNull(req.getParameter("del_nric_no"));
			String del_oth_alt_type		= checkForNull(req.getParameter("del_oth_alt_type"));
			String del_oth_alt_id			= checkForNull(req.getParameter("del_oth_alt_id"));

			// To Convert posted date into TimeStamp Format
			String posted_date= checkForNull(req.getParameter("posted_date"));
			
			if(!posted_date.equals(""))
			{
				posted_date = DateUtils.convertDate(posted_date,"DMYHM",locale,"en");
				StringTokenizer postedtoks = new StringTokenizer (posted_date," ") ;
				StringTokenizer postedtok1 = new StringTokenizer (postedtoks.nextToken(), "/" ) ;
				String postedArr[] =new String[3] ;
				for( int r=0;r<3;r++ )
				postedArr[r] = postedtok1.nextToken() ;

				StringBuffer sb_posted_date = new StringBuffer();
				sb_posted_date.append(postedArr[2]+"-");
				sb_posted_date.append(postedArr[1]+"-");
				sb_posted_date.append(postedArr[0]+" ");
				sb_posted_date.append(postedtoks.nextToken()+":00");
				posted_date = sb_posted_date.toString();

				//posted_date = postedArr[2] +"-"+postedArr[1]+"-"+ postedArr[0]+" "+postedtoks.nextToken()+":00"   ;
				Timestamp postedTimestamp= Timestamp.valueOf(posted_date);
				tabdata.put("POSTED_DATE",postedTimestamp);
			}

			tabdata.put("POSTED_ADDR_LINE1",del_addr_line1);
			tabdata.put("POSTED_ADDR_LINE2",del_addr_line2);	
			tabdata.put("POSTED_ADDR_LINE3",del_addr_line3);	
			tabdata.put("POSTED_ADDR_LINE4",del_addr_line4);	
			tabdata.put("POSTED_TOWN_CODE",del_res_town_code);	
			tabdata.put("POSTED_AREA_CODE",del_res_area_code);	
			tabdata.put("POSTED_REGION_CODE",del_region_code);	
			tabdata.put("POSTED_POSTAL_CODE",del_postal_code);
			tabdata.put("POSTED_COUNTRY_CODE",del_country_code);
			tabdata.put("DISPATCH_MODE",Despatch_mode);
			tabdata.put("SEC_FILE_NO",file_no);
			tabdata.put("REPORT_TAKEN_BY",report_taken);
			tabdata.put("RTB_NATIONAL_ID_NO",del_nric_no);
			tabdata.put("RTB_ALT_ID_TYPE",del_oth_alt_type);
			tabdata.put("RTB_ALT_ID__NO",del_oth_alt_id);
		}
		else if(call_function.equals("MEDICAL_BOARD_INT_APPT"))
		{
			tabdata.put("REQUEST_STATUS",request_status);

			//for delivery address...
			String del_addr_line1			= checkForNull(req.getParameter("del_addr_line1"));
			String del_addr_line2			= checkForNull(req.getParameter("del_addr_line2"));	
			String del_addr_line3			= checkForNull(req.getParameter("del_addr_line3"));	
			String del_addr_line4			= checkForNull(req.getParameter("del_addr_line4"));	
			String del_res_town_code	= checkForNull(req.getParameter("del_res_town_code"));	
			String del_res_area_code	= checkForNull(req.getParameter("del_res_area_code"));	
			String del_region_code		= checkForNull(req.getParameter("del_region_code"));	
			String del_postal_code		= checkForNull(req.getParameter("del_postal_code"));
			String del_country_code	= checkForNull(req.getParameter("del_country_code"));

			String Despatch_mode		= checkForNull(req.getParameter("Despatch_mode"));
			//String file_no						= checkForNull(req.getParameter("file_no"));
			String report_taken			= checkForNull(req.getParameter("report_taken"));
			String del_nric_no				= checkForNull(req.getParameter("del_nric_no"));
			String del_oth_alt_type		= checkForNull(req.getParameter("del_oth_alt_type"));
			String del_oth_alt_id			= checkForNull(req.getParameter("del_oth_alt_id"));

			// To Convert posted date into TimeStamp Format
			String posted_date= checkForNull(req.getParameter("posted_date"));
				
			if(!posted_date.equals(""))
			{
				posted_date = DateUtils.convertDate(posted_date,"DMYHM",locale,"en");
			
				StringTokenizer postedtoks = new StringTokenizer (posted_date," ") ;
				StringTokenizer postedtok1 = new StringTokenizer (postedtoks.nextToken(), "/" ) ;
				String postedArr[] =new String[3] ;
				for( int r=0;r<3;r++ )
				postedArr[r] = postedtok1.nextToken() ;
				
				StringBuffer sb_posted_date = new StringBuffer();
				sb_posted_date.append(postedArr[2]+"-");
				sb_posted_date.append(postedArr[1]+"-");
				sb_posted_date.append(postedArr[0]+" ");
				sb_posted_date.append(postedtoks.nextToken()+":00");
				posted_date = sb_posted_date.toString();

				//posted_date = postedArr[2] +"-"+postedArr[1]+"-"+ postedArr[0]+" "+postedtoks.nextToken()+":00"   ;
				Timestamp postedTimestamp= Timestamp.valueOf(posted_date);
				tabdata.put("INT_POSTED_DATE",postedTimestamp);
			}

			tabdata.put("INT_POSTED_ADDR_LINE1",del_addr_line1);
			tabdata.put("INT_POSTED_ADDR_LINE2",del_addr_line2);	
			tabdata.put("INT_POSTED_ADDR_LINE3",del_addr_line3);	
			tabdata.put("INT_POSTED_ADDR_LINE4",del_addr_line4);	
			tabdata.put("INT_POSTED_TOWN_CODE",del_res_town_code);	
			tabdata.put("INT_POSTED_AREA_CODE",del_res_area_code);	
			tabdata.put("INT_POSTED_REGION_CODE",del_region_code);	
			tabdata.put("INT_POSTED_POSTAL_CODE",del_postal_code);
			tabdata.put("INT_POSTED_COUNTRY_CODE",del_country_code);
			tabdata.put("INTIMATION_MODE",Despatch_mode);
			tabdata.put("INTIMATED_TO",report_taken);
			tabdata.put("SEC_FILE_NO",checkForNull(req.getParameter("file_no")));
			tabdata.put("INT_NATIONAL_ID_NO",del_nric_no);
			tabdata.put("INT_ALT_ID_TYPE",del_oth_alt_type);
			tabdata.put("INT_ALT_ID__NO",del_oth_alt_id);
		}
		
			tabdata.put("REMARKS",remarks);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("FACILITY_ID",facilityId);
			condflds.put("REQUEST_ID",request_id);

			String tableName = "MR_REPORT_REQUEST_HDR";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = "";
			if(inserted)
			{
				Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED" ,"SM") ;
				error = (String) message.get("message") ;
				if ( message != null ) message.clear();
			}
			else
			{
				error = (String) results.get("error") ;
				error = "Errors Encountered..";
			}
			//error= error.substring(0,error.indexOf("<br>")) ;
			out.println("alert(\""+error+"\");");


			if(call_function.equals("MEDICAL_BOARD_STATUS"))
			{
				// Application is Complete || if Consent letter is Available
				if((appl_status.equals("2") || appl_status.equals("1") || cons_letter.equals("0")) && (!request_id.equals(""))) 
				{
					OnlineConsentReport(request_id, cons_letter, appl_status, patient_id);
				}
			}

			if(call_function.equals("MEDICAL_BOARD_INT_APPT"))
			{
				try
				{
					String OA_Sql=" select appt_ref_no, to_char(appt_slab_from_time,'dd/mm/yyyy hh24:mi')appt_slab_from_time, to_char(appt_slab_to_time,'dd/mm/yyyy hh24:mi')appt_slab_to_time, clinic_code,  patient_id from OA_APPT where mr_request_id='"+request_id+"' and facility_id='"+facilityId+"' ";

					OA_Stmt = con.createStatement() ;
					OA_Rs	= OA_Stmt.executeQuery(OA_Sql) ;
					if( OA_Rs !=null )
					{
						while(OA_Rs.next())
						{
							appt_ref_no	= OA_Rs.getString("appt_ref_no");
							apptslabfmtime	= OA_Rs.getString("appt_slab_from_time");
							apptslabtotime	= OA_Rs.getString("appt_slab_to_time");
							cliniccode	= OA_Rs.getString("clinic_code");
							patientid	= OA_Rs.getString("patient_id");
						}
					}
					if(OA_Rs != null) OA_Rs.close();
					if(OA_Stmt!=null)OA_Stmt.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}

				doOnlineReports(req, appt_ref_no, cliniccode, patientid, facilityId,apptslabfmtime,apptslabtotime);
			}
			out.println("parent.window.close()");
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,req);
	}
}


/// Added by Sridhar R on Apr 5th 2005 for printing APPT SLIP...
	private void doOnlineReports(HttpServletRequest httpservletrequest, String s, String s1, String s2, String s3, String ftm, String ttm) throws ServletException, IOException, SQLException
	{
        String s4 = " select report_id, report_desc, 1 no_of_copies, module_id from SM_REPORT where module_id = 'OA' AND REPORT_ID = 'OARAPSL'";
        String s5 = s;
        String s6 = s1;
		String calling_mode1=httpservletrequest.getParameter("CallingMode");
		session.putValue("CallMode1",calling_mode1);
        String s9 = "";
        if(s2 == null || s2.equals(""))
            s9 = "";
        else
            s9 = s2;
        String s10 = "p_appt_ref_no,p_facility_id";
        String s11 = s5+","+s3;
        String s12 = "var message = 'APP-OA0098 Appointment Booked Successfully with Ref. No.'; ";
        s12 = s12 + "  var dialogHeight    = '75vh' ;";
        s12 = s12 + " var dialogWidth = '75vw' ;";
        s12 = s12 + "var dialogTop = 10;";
        s12 = s12 + "  var arguments =   ''; ";
		// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
        s12 = s12 + "  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MEDICAL_BOARD_INT_APPT&step=1&sqlString="+URLEncoder.encode(s4)+"&reportParamNames="+s10+"&reportParamValues="+s11+"&Patient_ID="+s9+"&dest_locn_type=C&dest_locn_code="+s6+"';";
        s12 = s12 + " var features = 'dialogHeight:' +dialogHeight+ '; dialogWidth:'+dialogWidth+'; status=no;';";
        s12 = s12 + "  retVal	=await window.showModalDialog(getUrl,arguments,features); ";
        s12 = s12 + "alert(message+"+s5+");";
		s12 = s12 + " parent.parent.document.getElementById('dialog-body').contentWindow.returnValue= \""+s5+"*"+ftm+"*"+ttm+"\" ;";
        s12 = s12 + "parent.parent.document.getElementById('dialog_tag').close();";
        out.println(s12);
    }


	///Added by Sridhar R on FEB 1 2005 for online reports from MEDICAL_REPORT_STATUS Function...
	private void OnlineConsentReport(String request_ID, String consent_letter, String application_status , String patient_id) throws ServletException, IOException, SQLException
	{
		facilityId	= (String) session.getValue( "facility_id" ) ;
		String sqlString		= "";		
		String reportParamNames	= "";
		String reportParamValues= "";

		try
		{
			if((application_status.equals("2") || application_status.equals("1")) && consent_letter.equals("0"))
			{
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id = 'MRBMRAPP' union SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id = 'MRBMRCFR' ";
			}
			else if(application_status.equals("2") || application_status.equals("1")) // Application is Complete or Incomplete
			{
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE module_id = 'MR' AND report_id = 'MRBMRAPP' ";
			}
			else if(consent_letter.equals("0")) // if Consent letter is Available
			{
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE module_id = 'MR' AND report_id = 'MRBMRCFR'";
			}

			reportParamNames = "p_request_id,p_facility_id,p_patient_id";
			reportParamValues = ""+request_ID+","+facilityId+","+patient_id+"";

			StringBuffer htmlFor = new StringBuffer();
			htmlFor.append("var dialogHeight	= '50vh';");
			htmlFor.append("  var dialogWidth	= '75vw';");
			htmlFor.append("  var dialogTop		= '10';");
			htmlFor.append("  var arguments		=	'';");
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			htmlFor.append("  var getUrl		=	'../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MEDICAL_BOARD_STATUS&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patient_id+"';");
			htmlFor.append("var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status=no;' ;");

			htmlFor.append("retVal =await top.window.showModalDialog(getUrl,arguments,features); parent.parent.document.getElementById('dialog_tag').close();");
			out.println(htmlFor.toString());
		}catch ( Exception e )
		{
			out.println("Encountered error while Processing Online Reports "+e.toString());
		}
	}

	
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
}
