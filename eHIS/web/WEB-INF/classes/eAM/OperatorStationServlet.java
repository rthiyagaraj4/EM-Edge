/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
/**
 *		FileName :OperatorStationServlet.java
 *		Version	 : 3
 *		Date	 : 15-2-05	
**/
import eAM.OPOperatorStation.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;	

import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;


public class OperatorStationServlet extends javax.servlet.http.HttpServlet{

PrintWriter out;
java.util.Properties p;
//java.util.Hashtable env;

String oper_stn_id="";
//String facilityId="";
String client_ip_address="";

//String book_appt_wo_pid_yn="";
//String obook_appt_yn="";
//String book_appt_across_catg_yn="";
//String tfr_appt_yn="";
//String tfr_appt_across_catg_yn="";
//String CONFIRM_BOOKING_YN = "";
//String CREATE_BOOKING_WITH_CONF_YN = "";
//String canc_appt_yn="";
//String register_visit_yn="";
//String register_pat_yn="";
/*String cancel_visit_yn="";
String revise_visit_yn="";
String manage_queue_yn="";
String checkout_pat_yn="";

String create_booking_yn="";
String revise_booking_yn="";
String canc_booking_yn="";
String reject_admission_yn="N";
String admit_pat_yn="";
String register_pat_in_admn_yn="";
String assign_bed_yn="";
String assign_treat_pract_yn="";
String canc_admission_yn="";
String emergency_tfr_yn="";
String routine_tfr_yn="";
String discharge_pat_yn="";
String CANCEL_DISCHARGE_YN="";
String revise_leave_yn="";
String check_lodger_yn="";*/
//String block_bed_yn="";
//String release_bed_yn="";
String facility_id="";
String oper_stn_type="";
String SWAP_BED_YN="";
String BACKDATED_ADMISSION_YN="";
String BED_CLASS_CHANGE_YN="";
String canc_req_yn="";
String can_tfr_out_yn="";
String cfrm_req_yn="";
String pract_tfr_yn="";
String dchrg_adv_yn="";
String TRANSFER_OUT_PATIENT_YN = "";
String TRANSFER_IN_PATIENT_YN	 = "";
String CHG_NURS_UNIT_IN_ASSIGN_BED_YN	 = "";
String ADMIT_PATIENT_WITH_BED_YN		 = "";
String FORCED_BOOK_APPT_YN				 = "";
String GLOBAL_BOOK_APPT_YN				 = "";
String cancel_checkout                   = "";
String CANCEL_CHECKOUT_YN                ="";
//9/16/2008 for oparation restriction of cancel reserve bed start
String cancel_reBeds_yn                ="";
//9/16/2008 for oparation restriction of cancel reserve bed end
//String register_visit_walkin_yn="";
//String register_visit_referral_yn="";
String operation ="";



public void init(ServletConfig config) throws ServletException	
	{
	super.init(config);
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
{
		HttpSession session = req.getSession(false);		
		//this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		

	try		
	{
		this.out = res.getWriter();
		operation = req.getParameter("function_name");
		if ( operation.equals("insert") )
			insertOPOperatorStation(req, res);
		if ( operation.equals("modify"))
				modifyOPOperatorStation(req, res);
		if ( operation.equals("delete"))
				deleteOPOperatorStation(req, res);		
	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
}

/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
{
	try	
	{
		this.out = res.getWriter();
		res.setContentType("text/html");
		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='Javascript' src='../eAM/js/OperatorStation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Shift' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
	}
	catch(Exception e)
	{}
}*/


private void modifyOPOperatorStation(HttpServletRequest req, HttpServletResponse res)
{
	try
	{
	/*InitialContext context = new InitialContext();
	Object homeObject = context.lookup("java:comp/env/OperatorStationManager");
	final OperatorStationHome operatorStationHome = (OperatorStationHome) PortableRemoteObject.narrow(homeObject ,OperatorStationHome.class);
	final OperatorStationRemote operatorStationRemote = operatorStationHome.create();
	final java.util.Hashtable results = operatorStationRemote.updateOPOperatorStation(p,facility_id,effectiveDateFrom,effectiveDateTo,effectiveStatus,client_ip_address,oper_stn_id,long_desc,short_desc,nurs_unit_code,shift_operated_yn,shift_group,ws_no,book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,CONFIRM_BOOKING_YN,CREATE_BOOKING_WITH_CONF_YN,canc_appt_yn,register_visit_yn,register_pat_yn,cancel_visit_yn,revise_visit_yn,manage_queue_yn,checkout_pat_yn,oper_stn_type,create_booking_yn,revise_booking_yn,canc_booking_yn,reject_admission_yn,admit_pat_yn,register_pat_in_admn_yn,assign_bed_yn,assign_treat_pract_yn,canc_admission_yn,emergency_tfr_yn,routine_tfr_yn,discharge_pat_yn,revise_leave_yn,check_lodger_yn,block_bed_yn,release_bed_yn,register_visit_walkin_yn,register_visit_referral_yn,SWAP_BED_YN,TRANSFER_OUT_PATIENT_YN,TRANSFER_IN_PATIENT_YN,CHG_NURS_UNIT_IN_ASSIGN_BED_YN,ADMIT_PATIENT_WITH_BED_YN,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,canc_req_yn,cfrm_req_yn,can_tfr_out_yn,pract_tfr_yn,dchrg_adv_yn,BED_CLASS_CHANGE_YN,BACKDATED_ADMISSION_YN,CANCEL_DISCHARGE_YN) ;
	*/

			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/OperatorStationManager",OperatorStationHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[1];

	
			HashMap hashmap=new HashMap();
			//hashmap.put("p",(req.getParameter("p")!=null)?req.getParameter("p"):"");
			hashmap.put("p",p);
			hashmap.put("facility_id",(req.getParameter("facility_id")!=null)?req.getParameter("facility_id"):"");
			hashmap.put("effectiveDateFrom",(req.getParameter("effectiveDateFrom")!=null)?req.getParameter("effectiveDateFrom"):"");
			hashmap.put("effectiveDateTo",(req.getParameter("effectiveDateTo")!=null)?req.getParameter("effectiveDateTo"):"");
			hashmap.put("effectiveStatus",(req.getParameter("eff_status")!=null)?req.getParameter("eff_status"):"");
			
			//hashmap.put("client_ip_address",(req.getParameter("client_ip_address")!=null)?req.getParameter("client_ip_address"):"");

			hashmap.put("client_ip_address",client_ip_address);

			hashmap.put("oper_stn_id",(req.getParameter("oper_stn_id")!=null)?req.getParameter("oper_stn_id"):"");
			hashmap.put("long_desc",(req.getParameter("long_desc")!=null)?req.getParameter("long_desc"):"");
			hashmap.put("short_desc",(req.getParameter("short_desc")!=null)?req.getParameter("short_desc"):"");
			hashmap.put("nurs_unit_code",(req.getParameter("nurs_unit_code")!=null)?req.getParameter("nurs_unit_code"):"");
			hashmap.put("shift_operated_yn",(req.getParameter("shift_operated_yn")!=null)?req.getParameter("shift_operated_yn"):"N");
			hashmap.put("shift_group",(req.getParameter("shift_group")!=null)?req.getParameter("shift_group"):"");
			hashmap.put("ws_no",(req.getParameter("ws_no")!=null)?req.getParameter("ws_no"):"");
			hashmap.put("book_appt_yn",(req.getParameter("book_appt_yn")!=null)?req.getParameter("book_appt_yn"):"N");
			hashmap.put("book_appt_wo_pid_yn",(req.getParameter("book_appt_wo_pid_yn")!=null)?req.getParameter("book_appt_wo_pid_yn"):"N");
			hashmap.put("obook_appt_yn",(req.getParameter("obook_appt_yn")!=null)?req.getParameter("obook_appt_yn"):"N");
			hashmap.put("book_appt_across_catg_yn",(req.getParameter("BOOK_APPT_ACROSS_CATG_YN")!=null)?req.getParameter("BOOK_APPT_ACROSS_CATG_YN"):"N");
			hashmap.put("tfr_appt_yn",(req.getParameter("tfr_appt_yn")!=null)?req.getParameter("tfr_appt_yn"):"N");
			hashmap.put("tfr_appt_across_catg_yn",(req.getParameter("tfr_appt_across_catg_yn")!=null)?req.getParameter("tfr_appt_across_catg_yn"):"N");
			hashmap.put("CONFIRM_BOOKING_YN",(req.getParameter("CONFIRM_BOOKING_YN")!=null)?req.getParameter("CONFIRM_BOOKING_YN"):"N");
			hashmap.put("CREATE_BOOKING_WITH_CONF_YN",(req.getParameter("CREATE_BOOKING_WITH_CONF_YN")!=null)?req.getParameter("CREATE_BOOKING_WITH_CONF_YN"):"N");
			hashmap.put("canc_appt_yn",(req.getParameter("canc_appt_yn")!=null)?req.getParameter("canc_appt_yn"):"N");
			hashmap.put("register_visit_yn",(req.getParameter("register_visit_yn")!=null)?req.getParameter("register_visit_yn"):"N");
			hashmap.put("register_pat_yn",(req.getParameter("register_pat_yn")!=null)?req.getParameter("register_pat_yn"):"N");
			hashmap.put("cancel_visit_yn",(req.getParameter("cancel_visit_yn")!=null)?req.getParameter("cancel_visit_yn"):"N");
			hashmap.put("revise_visit_yn",(req.getParameter("revise_visit_yn")!=null)?req.getParameter("revise_visit_yn"):"N");
			hashmap.put("manage_queue_yn",(req.getParameter("manage_queue_yn")!=null)?req.getParameter("manage_queue_yn"):"N");
			hashmap.put("checkout_pat_yn",(req.getParameter("checkout_pat_yn")!=null)?req.getParameter("checkout_pat_yn"):"N");
			hashmap.put("oper_stn_type",(req.getParameter("operstntype")!=null)?req.getParameter("operstntype"):"");
			hashmap.put("create_booking_yn",(req.getParameter("create_booking_yn")!=null)?req.getParameter("create_booking_yn"):"N");
			hashmap.put("revise_booking_yn",(req.getParameter("revise_booking_yn")!=null)?req.getParameter("revise_booking_yn"):"N");
			hashmap.put("canc_booking_yn",(req.getParameter("canc_booking_yn")!=null)?req.getParameter("canc_booking_yn"):"N");
			hashmap.put("reject_admission_yn",(req.getParameter("reject_admission_yn")!=null)?req.getParameter("reject_admission_yn"):"N");
			hashmap.put("admit_pat_yn",(req.getParameter("admit_pat_yn")!=null)?req.getParameter("admit_pat_yn"):"N");
			
			/*Below line Added for this CRF Bru-HIMS-CRF-261*/
			hashmap.put("quick_admission_yn",(req.getParameter("quick_admission_yn")!=null)?req.getParameter("quick_admission_yn"):"N");
			
			hashmap.put("register_pat_in_admn_yn",(req.getParameter("register_pat_in_admn_yn")!=null)?req.getParameter("register_pat_in_admn_yn"):"N");
			hashmap.put("assign_bed_yn",(req.getParameter("assign_bed_yn")!=null)?req.getParameter("assign_bed_yn"):"N");
			hashmap.put("assign_treat_pract_yn",(req.getParameter("assign_treat_pract_yn")!=null)?req.getParameter("assign_treat_pract_yn"):"N");
            hashmap.put("revise_admission_yn",(req.getParameter("revise_admission_yn")!=null)?req.getParameter("revise_admission_yn"):"N");
			hashmap.put("canc_admission_yn",(req.getParameter("canc_admission_yn")!=null)?req.getParameter("canc_admission_yn"):"N");
			hashmap.put("emergency_tfr_yn",(req.getParameter("emergency_tfr_yn")!=null)?req.getParameter("emergency_tfr_yn"):"N");
			
				hashmap.put("MAINTAIN_DEATH_REGISTER_YN",(req.getParameter("MAINTAIN_DEATH_REGISTER_YN")!=null)?req.getParameter("MAINTAIN_DEATH_REGISTER_YN"):"N");
			hashmap.put("routine_tfr_yn",(req.getParameter("routine_tfr_yn")!=null)?req.getParameter("routine_tfr_yn"):"N");
			hashmap.put("discharge_pat_yn",(req.getParameter("discharge_pat_yn")!=null)?req.getParameter("discharge_pat_yn"):"N");
			hashmap.put("revise_leave_yn",(req.getParameter("revise_leave_yn")!=null)?req.getParameter("revise_leave_yn"):"N");
			hashmap.put("check_lodger_yn",(req.getParameter("check_lodger_yn")!=null)?req.getParameter("check_lodger_yn"):"N");
			hashmap.put("block_bed_yn",(req.getParameter("block_bed_yn")!=null)?req.getParameter("block_bed_yn"):"N");
			hashmap.put("release_bed_yn",(req.getParameter("release_bed_yn")!=null)?req.getParameter("release_bed_yn"):"N");
			hashmap.put("register_visit_walkin_yn",(req.getParameter("register_visit_walkin_yn")!=null)?req.getParameter("register_visit_walkin_yn"):"N");
			hashmap.put("register_visit_referral_yn",(req.getParameter("register_visit_referral_yn")!=null)?req.getParameter("register_visit_referral_yn"):"N");
			hashmap.put("SWAP_BED_YN",(req.getParameter("SWAP_BED_YN")!=null)?req.getParameter("SWAP_BED_YN"):"N");
			hashmap.put("TRANSFER_OUT_PATIENT_YN",(req.getParameter("TRANSFER_OUT_PATIENT_YN")!=null)?req.getParameter("TRANSFER_OUT_PATIENT_YN"):"N");
			hashmap.put("TRANSFER_IN_PATIENT_YN",(req.getParameter("TRANSFER_IN_PATIENT_YN")!=null)?req.getParameter("TRANSFER_IN_PATIENT_YN"):"N");
			hashmap.put("CHG_NURS_UNIT_IN_ASSIGN_BED_YN",(req.getParameter("CHG_NURS_UNIT_IN_ASSIGN_BED_YN")!=null)?req.getParameter("CHG_NURS_UNIT_IN_ASSIGN_BED_YN"):"N");
			hashmap.put("ADMIT_PATIENT_WITH_BED_YN",(req.getParameter("ADMIT_PATIENT_WITH_BED_YN")!=null)?req.getParameter("ADMIT_PATIENT_WITH_BED_YN"):"N");
			hashmap.put("FORCED_BOOK_APPT_YN",(req.getParameter("FORCED_BOOK_APPT_YN")!=null)?req.getParameter("FORCED_BOOK_APPT_YN"):"N");
			hashmap.put("GLOBAL_BOOK_APPT_YN",(req.getParameter("GLOBAL_BOOK_APPT_YN")!=null)?req.getParameter("GLOBAL_BOOK_APPT_YN"):"N");
			hashmap.put("canc_req_yn",(req.getParameter("canc_req_yn")!=null)?req.getParameter("canc_req_yn"):"N");
			hashmap.put("cfrm_req_yn",(req.getParameter("cfrm_req_yn")!=null)?req.getParameter("cfrm_req_yn"):"N");
			hashmap.put("can_tfr_out_yn",(req.getParameter("can_tfr_out_yn")!=null)?req.getParameter("can_tfr_out_yn"):"N");
			hashmap.put("pract_tfr_yn",(req.getParameter("pract_tfr_yn")!=null)?req.getParameter("pract_tfr_yn"):"N");
			hashmap.put("dchrg_adv_yn",(req.getParameter("dchrg_adv_yn")!=null)?req.getParameter("dchrg_adv_yn"):"N");
			hashmap.put("BED_CLASS_CHANGE_YN",(req.getParameter("BED_CLASS_CHANGE_YN")!=null)?req.getParameter("BED_CLASS_CHANGE_YN"):"N");
			hashmap.put("BACKDATED_ADMISSION_YN",(req.getParameter("BACKDATED_ADMISSION_YN")!=null)?req.getParameter("BACKDATED_ADMISSION_YN"):"N");
			//Newly added on 09/01/2006
		
			hashmap.put("create_wait_list_yn",(req.getParameter("create_wait_list_yn")!=null)?req.getParameter("create_wait_list_yn"):"N");
			hashmap.put("modify_wait_list_yn",(req.getParameter("modify_wait_list_yn")!=null)?req.getParameter("modify_wait_list_yn"):"N");

			hashmap.put("cancel_wait_list_yn",(req.getParameter("cancel_wait_list_yn")!=null)?req.getParameter("cancel_wait_list_yn"):"N");

			
	
			hashmap.put("LINK_BABY_TO_MOTHER_YN",(req.getParameter("LINK_BABY_TO_MOTHER_YN")!=null)?req.getParameter("LINK_BABY_TO_MOTHER_YN"):"N");
			hashmap.put("REG_NEWBORN_FOR_IP_YN",(req.getParameter("REG_NEWBORN_FOR_IP_YN")!=null)?req.getParameter("REG_NEWBORN_FOR_IP_YN"):"N");
			hashmap.put("DISCHARGE_CHECKLIST_YN",(req.getParameter("DISCHARGE_CHECKLIST_YN")!=null)?req.getParameter("DISCHARGE_CHECKLIST_YN"):"N");
			hashmap.put("CANCEL_DISCHARGE_YN",(req.getParameter("CANCEL_DISCHARGE_YN")!=null)?req.getParameter("CANCEL_DISCHARGE_YN"):"N");
			hashmap.put("RESERVE_BED_BAY_YN",(req.getParameter("RESERVE_BED_BAY_YN")!=null)?req.getParameter("RESERVE_BED_BAY_YN"):"N");
			hashmap.put("RELEASE_BED_BAY_YN",(req.getParameter("RELEASE_BED_BAY_YN")!=null)?req.getParameter("RELEASE_BED_BAY_YN"):"N");

			hashmap.put("REG_IP_REFERRAL_YN",(req.getParameter("REG_IP_REFERRAL_YN")!=null)?req.getParameter("REG_IP_REFERRAL_YN"):"N");
			hashmap.put("CONFIRM_BEDSIDE_REFERRAL_YN",(req.getParameter("CONFIRM_BEDSIDE_REFERRAL_YN")!=null)?req.getParameter("CONFIRM_BEDSIDE_REFERRAL_YN"):"N");	
			
			
			
			hashmap.put("DIAG_PROC_RECODE_FOR_IP_YN",(req.getParameter("DIAG_PROC_RECODE_FOR_IP_YN")!=null)?req.getParameter("DIAG_PROC_RECODE_FOR_IP_YN"):"N");	
			hashmap.put("DIAG_PROC_RECODE_FOR_OP_YN",(req.getParameter("DIAG_PROC_RECODE_FOR_OP_YN")!=null)?req.getParameter("DIAG_PROC_RECODE_FOR_OP_YN"):"N");

             
			
			hashmap.put("OVERRIDE_WALKIN_YN",(req.getParameter("OVERRIDE_WALKIN_YN")!=null)?req.getParameter("OVERRIDE_WALKIN_YN"):"N");
           
			hashmap.put("CANCEL_CHECKOUT_YN",(req.getParameter("CANCEL_CHECKOUT_YN")!=null)?req.getParameter("CANCEL_CHECKOUT_YN"):"N");

			//9/16/2008 putting the CANCEL_RESERVE_BED_YN in hash map
hashmap.put("CANCEL_RESERVE_BED_YN",(req.getParameter("cancel_reBeds_yn")!=null)?req.getParameter("cancel_reBeds_yn"):"N");

			//9/16/2008 putting the CANCEL_RESERVE_BED_YN in hash map
			
			 cancel_reBeds_yn  = req.getParameter("cancel_reBeds_yn");
		if(cancel_reBeds_yn==null) cancel_reBeds_yn="N";

			hashmap.put("emergency_transfer_yn",(req.getParameter("emergency_transfer_yn")!=null)?req.getParameter("emergency_transfer_yn"):"N");

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateOPOperatorStation",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		    boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			
			
            String error = (String) results.get("error") ;
            String error_value = "0" ;
            if ( inserted )
            {
		     error_value = "1" ;
		   res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
            }
            else
            {
                 error = (String) results.get("error") ;

                res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8"  ) );
            }
			hashmap.clear();
			results.clear();

	} catch ( Exception e ) {
			
			
			//out.println("1  :"+p+"   2  :"+facility_id+"  3 :"+effectiveDateFrom+"  4:  "+effectiveDateTo+"  5  :"+effectiveStatus+"  6  :"+client_ip_address+"  7:  "+oper_stn_id+"  8  :  "+long_desc+"  9  :"+short_desc+"  10  :"+shift_operated_yn+"  11 :"+shift_group+"  12 :"+ws_no+"  13  :"+book_appt_yn+"  14  :"+book_appt_wo_pid_yn+"  15  :"+obook_appt_yn+"  16  :"+book_appt_across_catg_yn+"  17  :"+tfr_appt_yn+"  18  :"+tfr_appt_across_catg_yn+"    19  :"+canc_appt_yn+"  20  :"+register_visit_yn+"  21  :"+register_pat_yn+"  22  :"+cancel_visit_yn+"  23  :  "+revise_visit_yn+"  24  :"+manage_queue_yn+"  25  :"+checkout_pat_yn+"  26  :"+oper_stn_type+"  27  :"+create_booking_yn+"  28  :"+revise_booking_yn+"  29  :"+canc_booking_yn+"  30  :"+reject_admission_yn+"  31  :"+admit_pat_yn+"  32  :"+register_pat_in_admn_yn+"  33  :"+assign_bed_yn+"  34  :"+assign_treat_pract_yn+"  35  :"+canc_admission_yn+"  36  :"+emergency_tfr_yn+"  37  :"+routine_tfr_yn+"  38  :"+discharge_pat_yn+"  39  :"+revise_leave_yn+"  40  :"+check_lodger_yn+" 41 :"CANCEL_DISCHARGE_YN);
			e.printStackTrace();
			}
	}

private void insertOPOperatorStation(HttpServletRequest req, HttpServletResponse res)	{
	try
	{
		/*oper_stn_type	=req.getParameter("operstntype");
			if(oper_stn_type == null) oper_stn_type="";
		facility_id = req.getParameter("facility_id");
			if(facility_id == null) facility_id="";
		long_desc		=req.getParameter("long_desc");
			if(long_desc == null) long_desc="";

		short_desc		=req.getParameter("short_desc");
			if(short_desc == null) short_desc="";

		shift_operated_yn= req.getParameter("shift_operated_yn1");
			if (shift_operated_yn == null)
		shift_operated_yn="N";
		shift_group = req.getParameter("shift_group2");
			if(shift_group == null) shift_group = "N";
		ws_no=req.getParameter("ws_no");
			if(ws_no == null) ws_no = "";
		effectiveDateFrom = req.getParameter("eff_date_from");
			if(effectiveDateFrom == null) effectiveDateFrom = "";
		effectiveDateTo = req.getParameter("eff_date_to");
			if(effectiveDateTo == null) effectiveDateTo = "";
		effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
		effectiveStatus="D";
		oper_stn_id 		= req.getParameter("oper_stn_id");
			if(oper_stn_id == null) oper_stn_id = "";
		book_appt_yn 		= req.getParameter("book_appt_yn");
			if(book_appt_yn == null) book_appt_yn = "N";
		book_appt_wo_pid_yn 		= req.getParameter("book_appt_wo_pid_yn");
			if(book_appt_wo_pid_yn == null) book_appt_wo_pid_yn = "N";
		obook_appt_yn 		= req.getParameter("obook_appt_yn");
			if(obook_appt_yn == null) obook_appt_yn = "N";
		book_appt_across_catg_yn 		= req.getParameter("book_appt_across_catg_yn");
			if(book_appt_across_catg_yn == null) book_appt_across_catg_yn = "N";
		tfr_appt_yn 		= req.getParameter("tfr_appt_yn");
			if(tfr_appt_yn == null) tfr_appt_yn = "N";
		tfr_appt_across_catg_yn 		= req.getParameter("tfr_appt_across_catg_yn");
			if(tfr_appt_across_catg_yn == null) tfr_appt_across_catg_yn = "N";
		CONFIRM_BOOKING_YN 		= req.getParameter("CONFIRM_BOOKING_YN");
			if(CONFIRM_BOOKING_YN == null) CONFIRM_BOOKING_YN = "N";
		CREATE_BOOKING_WITH_CONF_YN 		= req.getParameter("CREATE_BOOKING_WITH_CONF_YN");
			if(CREATE_BOOKING_WITH_CONF_YN == null) CREATE_BOOKING_WITH_CONF_YN = "N";
		canc_appt_yn 		= req.getParameter("canc_appt_yn");
			if(canc_appt_yn == null) canc_appt_yn = "N";
		register_visit_yn 		= req.getParameter("register_visit_yn");
			if(register_visit_yn == null) register_visit_yn = "N";
		register_pat_yn 		= req.getParameter("register_pat_yn");
			if(register_pat_yn == null) register_pat_yn = "N";
		cancel_visit_yn 		= req.getParameter("cancel_visit_yn");
			if(cancel_visit_yn == null) cancel_visit_yn = "N";
		revise_visit_yn 		= req.getParameter("revise_visit_yn");
			if(revise_visit_yn == null) revise_visit_yn = "N";
		manage_queue_yn 		= req.getParameter("manage_queue_yn");
			if(manage_queue_yn == null) manage_queue_yn = "N";
		checkout_pat_yn 		= req.getParameter("checkout_pat_yn");
			if(checkout_pat_yn == null) checkout_pat_yn = "N";
		oper_stn_type 		= req.getParameter("operstntype");
		create_booking_yn 		= req.getParameter("create_booking_yn");
			if(create_booking_yn == null) create_booking_yn = "N";
		revise_booking_yn 		= req.getParameter("revise_booking_yn");
			if(revise_booking_yn == null) revise_booking_yn = "N";
		canc_booking_yn 		= req.getParameter("canc_booking_yn");
			if(canc_booking_yn == null) canc_booking_yn = "N";
		admit_pat_yn 		= req.getParameter("admit_pat_yn");
			if(admit_pat_yn == null) admit_pat_yn = "N";
		register_pat_in_admn_yn 		= req.getParameter("register_pat_in_admn_yn");
			if(register_pat_in_admn_yn == null) register_pat_in_admn_yn = "N";
		assign_bed_yn 		= req.getParameter("assign_bed_yn");
			if(assign_bed_yn == null) assign_bed_yn = "N";
		assign_treat_pract_yn 		= req.getParameter("assign_treat_pract_yn");
			if(assign_treat_pract_yn == null) assign_treat_pract_yn = "N";
		canc_admission_yn 		= req.getParameter("canc_admission_yn");
			if(canc_admission_yn == null) canc_admission_yn = "N";
		emergency_tfr_yn 		= req.getParameter("emergency_tfr_yn");
			if(emergency_tfr_yn == null) emergency_tfr_yn = "N";
		routine_tfr_yn 		= req.getParameter("routine_tfr_yn");
			if(routine_tfr_yn == null) routine_tfr_yn = "N";
		discharge_pat_yn 		= req.getParameter("discharge_pat_yn");
			if(discharge_pat_yn == null) discharge_pat_yn = "N";
         CANCEL_DISCHARGE_YN    = req.getParameter("CANCEL_DISCHARGE_YN");
		 if(CANCEL_DISCHARGE_YN ==null) CANCEL_DISCHARGE_YN="N";
		revise_leave_yn 		= req.getParameter("revise_leave_yn");
			if(revise_leave_yn == null) revise_leave_yn = "N";
		check_lodger_yn 		= req.getParameter("check_lodger_yn");
			if(check_lodger_yn == null) check_lodger_yn = "N";
		block_bed_yn 		= req.getParameter("block_bed_yn");
			if(block_bed_yn == null) block_bed_yn = "N";
		release_bed_yn 		= req.getParameter("release_bed_yn");
			if(release_bed_yn == null) release_bed_yn = "N";
		register_visit_walkin_yn =req.getParameter("register_visit_walkin_yn");
			if(register_visit_walkin_yn == null) register_visit_walkin_yn="N";
		register_visit_referral_yn =req.getParameter("register_visit_referral_yn");
			if(register_visit_referral_yn == null) register_visit_referral_yn="N";
		SWAP_BED_YN  = req.getParameter("SWAP_BED_YN");
		BACKDATED_ADMISSION_YN  = req.getParameter("BACKDATED_ADMISSION_YN");*/
		BED_CLASS_CHANGE_YN  = req.getParameter("BED_CLASS_CHANGE_YN");
			if(SWAP_BED_YN == null) SWAP_BED_YN="N";
			if(BACKDATED_ADMISSION_YN == null) BACKDATED_ADMISSION_YN="N";
			if(BED_CLASS_CHANGE_YN == null) BED_CLASS_CHANGE_YN="N";
		canc_req_yn  = req.getParameter("canc_req_yn");
		cfrm_req_yn  = req.getParameter("cfrm_req_yn");
		can_tfr_out_yn  = req.getParameter("can_tfr_out_yn");
		pract_tfr_yn  = req.getParameter("pract_tfr_yn");
		dchrg_adv_yn  = req.getParameter("dchrg_adv_yn");
			if (canc_req_yn ==null) canc_req_yn ="N";
			if (cfrm_req_yn ==null) cfrm_req_yn ="N";
			if (can_tfr_out_yn ==null) can_tfr_out_yn ="N";
			if (pract_tfr_yn ==null) pract_tfr_yn ="N";
			if (dchrg_adv_yn ==null) dchrg_adv_yn ="N";
		TRANSFER_OUT_PATIENT_YN  = req.getParameter("TRANSFER_OUT_PATIENT_YN");
		TRANSFER_IN_PATIENT_YN  = req.getParameter("TRANSFER_IN_PATIENT_YN");
		CHG_NURS_UNIT_IN_ASSIGN_BED_YN  = req.getParameter("CHG_NURS_UNIT_IN_ASSIGN_BED_YN");
		ADMIT_PATIENT_WITH_BED_YN  = req.getParameter("ADMIT_PATIENT_WITH_BED_YN");
		FORCED_BOOK_APPT_YN  = req.getParameter("FORCED_BOOK_APPT_YN");
		GLOBAL_BOOK_APPT_YN  = req.getParameter("GLOBAL_BOOK_APPT_YN");
		CANCEL_CHECKOUT_YN  = req.getParameter("CANCEL_CHECKOUT_YN");
		//9/16/2008 for operation station restriction on cancelreserve bed
		cancel_reBeds_yn  = req.getParameter("cancel_reBeds_yn");
		if(cancel_reBeds_yn==null) cancel_reBeds_yn="N";

		//9/16/2008 for operation station restriction on cancelreserve bed

			if (TRANSFER_OUT_PATIENT_YN ==null) TRANSFER_OUT_PATIENT_YN ="N";
			if (TRANSFER_IN_PATIENT_YN ==null) TRANSFER_IN_PATIENT_YN ="N";
			if (CHG_NURS_UNIT_IN_ASSIGN_BED_YN ==null) CHG_NURS_UNIT_IN_ASSIGN_BED_YN ="N";
			if (ADMIT_PATIENT_WITH_BED_YN ==null) ADMIT_PATIENT_WITH_BED_YN ="N";
			if (FORCED_BOOK_APPT_YN ==null) FORCED_BOOK_APPT_YN ="N";
			if (GLOBAL_BOOK_APPT_YN ==null) GLOBAL_BOOK_APPT_YN ="N";
			if(CANCEL_CHECKOUT_YN==null) CANCEL_CHECKOUT_YN="N";

			

		/*InitialContext context = new InitialContext();
		Object homeObject = context.lookup("java:comp/env/OperatorStationManager");
		final OperatorStationHome operatorStationHome = (OperatorStationHome) PortableRemoteObject.narrow(homeObject ,OperatorStationHome.class);
		final OperatorStationRemote operatorStationRemote = operatorStationHome.create();
		final java.util.Hashtable results = operatorStationRemote.insertOPOperatorStation(p,facility_id,effectiveDateFrom,effectiveDateTo,effectiveStatus,client_ip_address,oper_stn_id,long_desc,short_desc,nurs_unit_code,shift_operated_yn,shift_group,ws_no,
		book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,
	canc_appt_yn,register_visit_yn,register_pat_yn,cancel_visit_yn,revise_visit_yn,manage_queue_yn,checkout_pat_yn,oper_stn_type,create_booking_yn,revise_booking_yn,canc_booking_yn,reject_admission_yn,admit_pat_yn,register_pat_in_admn_yn,assign_bed_yn,assign_treat_pract_yn,canc_admission_yn,emergency_tfr_yn,routine_tfr_yn,discharge_pat_yn,revise_leave_yn,check_lodger_yn,block_bed_yn,release_bed_yn,register_visit_walkin_yn,register_visit_referral_yn,SWAP_BED_YN,TRANSFER_OUT_PATIENT_YN,TRANSFER_IN_PATIENT_YN,CHG_NURS_UNIT_IN_ASSIGN_BED_YN,ADMIT_PATIENT_WITH_BED_YN,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,canc_req_yn,cfrm_req_yn,can_tfr_out_yn,pract_tfr_yn,dchrg_adv_yn,BED_CLASS_CHANGE_YN,BACKDATED_ADMISSION_YN,CANCEL_DISCHARGE_YN);*/

		
			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/OperatorStationManager",OperatorStationHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[1];
			
			HashMap hashmap=new HashMap();
			//out.println("p ios"+p);
			hashmap.put("p",p);
			hashmap.put("facility_id",(req.getParameter("facility_id")!=null)?req.getParameter("facility_id"):"");
			hashmap.put("effectiveDateFrom",(req.getParameter("effectiveDateFrom")!=null)?req.getParameter("effectiveDateFrom"):"");
			hashmap.put("effectiveDateTo",(req.getParameter("effectiveDateTo")!=null)?req.getParameter("effectiveDateTo"):"");
			hashmap.put("effectiveStatus",(req.getParameter("eff_status")!=null)?req.getParameter("eff_status"):"");
			
			//hashmap.put("client_ip_address",(req.getParameter("client_ip_address")!=null)?req.getParameter("client_ip_address"):"");

			hashmap.put("client_ip_address",client_ip_address);

			hashmap.put("oper_stn_id",(req.getParameter("oper_stn_id")!=null)?req.getParameter("oper_stn_id"):"");
			hashmap.put("long_desc",(req.getParameter("long_desc")!=null)?req.getParameter("long_desc"):"");
			hashmap.put("short_desc",(req.getParameter("short_desc")!=null)?req.getParameter("short_desc"):"");
			hashmap.put("nurs_unit_code",(req.getParameter("nurs_unit_code")!=null)?req.getParameter("nurs_unit_code"):"");
			hashmap.put("shift_operated_yn",(req.getParameter("shift_operated_yn")!=null)?req.getParameter("shift_operated_yn"):"N");
			hashmap.put("shift_group",(req.getParameter("shift_group")!=null)?req.getParameter("shift_group"):"");
			hashmap.put("ws_no",(req.getParameter("ws_no")!=null)?req.getParameter("ws_no"):"");
			hashmap.put("book_appt_yn",(req.getParameter("book_appt_yn")!=null)?req.getParameter("book_appt_yn"):"N");
			hashmap.put("book_appt_wo_pid_yn",(req.getParameter("book_appt_wo_pid_yn")!=null)?req.getParameter("book_appt_wo_pid_yn"):"N");
			hashmap.put("obook_appt_yn",(req.getParameter("obook_appt_yn")!=null)?req.getParameter("obook_appt_yn"):"N");
			hashmap.put("book_appt_across_catg_yn",(req.getParameter("BOOK_APPT_ACROSS_CATG_YN")!=null)?req.getParameter("BOOK_APPT_ACROSS_CATG_YN"):"N");
			hashmap.put("tfr_appt_yn",(req.getParameter("tfr_appt_yn")!=null)?req.getParameter("tfr_appt_yn"):"N");
			hashmap.put("tfr_appt_across_catg_yn",(req.getParameter("tfr_appt_across_catg_yn")!=null)?req.getParameter("tfr_appt_across_catg_yn"):"N");
			hashmap.put("CONFIRM_BOOKING_YN",(req.getParameter("CONFIRM_BOOKING_YN")!=null)?req.getParameter("CONFIRM_BOOKING_YN"):"N");
			hashmap.put("CREATE_BOOKING_WITH_CONF_YN",(req.getParameter("CREATE_BOOKING_WITH_CONF_YN")!=null)?req.getParameter("CREATE_BOOKING_WITH_CONF_YN"):"N");
			hashmap.put("canc_appt_yn",(req.getParameter("canc_appt_yn")!=null)?req.getParameter("canc_appt_yn"):"N");
			hashmap.put("register_visit_yn",(req.getParameter("register_visit_yn")!=null)?req.getParameter("register_visit_yn"):"N");
			hashmap.put("register_pat_yn",(req.getParameter("register_pat_yn")!=null)?req.getParameter("register_pat_yn"):"N");
			hashmap.put("cancel_visit_yn",(req.getParameter("cancel_visit_yn")!=null)?req.getParameter("cancel_visit_yn"):"N");
			hashmap.put("revise_visit_yn",(req.getParameter("revise_visit_yn")!=null)?req.getParameter("revise_visit_yn"):"N");
			hashmap.put("manage_queue_yn",(req.getParameter("manage_queue_yn")!=null)?req.getParameter("manage_queue_yn"):"N");
			hashmap.put("checkout_pat_yn",(req.getParameter("checkout_pat_yn")!=null)?req.getParameter("checkout_pat_yn"):"N");
			hashmap.put("oper_stn_type",(req.getParameter("operstntype")!=null)?req.getParameter("operstntype"):"");
			hashmap.put("create_booking_yn",(req.getParameter("create_booking_yn")!=null)?req.getParameter("create_booking_yn"):"N");
			hashmap.put("revise_booking_yn",(req.getParameter("revise_booking_yn")!=null)?req.getParameter("revise_booking_yn"):"N");
			hashmap.put("canc_booking_yn",(req.getParameter("canc_booking_yn")!=null)?req.getParameter("canc_booking_yn"):"N");
			hashmap.put("reject_admission_yn",(req.getParameter("reject_admission_yn")!=null)?req.getParameter("reject_admission_yn"):"N");
			hashmap.put("admit_pat_yn",(req.getParameter("admit_pat_yn")!=null)?req.getParameter("admit_pat_yn"):"N");
			hashmap.put("register_pat_in_admn_yn",(req.getParameter("register_pat_in_admn_yn")!=null)?req.getParameter("register_pat_in_admn_yn"):"N");
			hashmap.put("assign_bed_yn",(req.getParameter("assign_bed_yn")!=null)?req.getParameter("assign_bed_yn"):"N");
			hashmap.put("assign_treat_pract_yn",(req.getParameter("assign_treat_pract_yn")!=null)?req.getParameter("assign_treat_pract_yn"):"N");
			hashmap.put("revise_admission_yn",(req.getParameter("revise_admission_yn")!=null)?req.getParameter("revise_admission_yn"):"N");
			
			/*Below line Added for this CRF Bru-HIMS-CRF-261*/
			hashmap.put("quick_admission_yn",(req.getParameter("quick_admission_yn")!=null)?req.getParameter("quick_admission_yn"):"N");

			hashmap.put("canc_admission_yn",(req.getParameter("canc_admission_yn")!=null)?req.getParameter("canc_admission_yn"):"N");
			hashmap.put("emergency_tfr_yn",(req.getParameter("emergency_tfr_yn")!=null)?req.getParameter("emergency_tfr_yn"):"N");
			
			hashmap.put("MAINTAIN_DEATH_REGISTER_YN",(req.getParameter("MAINTAIN_DEATH_REGISTER_YN")!=null)?req.getParameter("MAINTAIN_DEATH_REGISTER_YN"):"N");
			hashmap.put("routine_tfr_yn",(req.getParameter("routine_tfr_yn")!=null)?req.getParameter("routine_tfr_yn"):"N");
			hashmap.put("discharge_pat_yn",(req.getParameter("discharge_pat_yn")!=null)?req.getParameter("discharge_pat_yn"):"N");
			hashmap.put("revise_leave_yn",(req.getParameter("revise_leave_yn")!=null)?req.getParameter("revise_leave_yn"):"N");
			hashmap.put("check_lodger_yn",(req.getParameter("check_lodger_yn")!=null)?req.getParameter("check_lodger_yn"):"N");
			hashmap.put("block_bed_yn",(req.getParameter("block_bed_yn")!=null)?req.getParameter("block_bed_yn"):"N");
			hashmap.put("release_bed_yn",(req.getParameter("release_bed_yn")!=null)?req.getParameter("release_bed_yn"):"N");
			hashmap.put("register_visit_walkin_yn",(req.getParameter("register_visit_walkin_yn")!=null)?req.getParameter("register_visit_walkin_yn"):"N");
			hashmap.put("register_visit_referral_yn",(req.getParameter("register_visit_referral_yn")!=null)?req.getParameter("register_visit_referral_yn"):"N");
			hashmap.put("SWAP_BED_YN",(req.getParameter("SWAP_BED_YN")!=null)?req.getParameter("SWAP_BED_YN"):"N");
			hashmap.put("TRANSFER_OUT_PATIENT_YN",(req.getParameter("TRANSFER_OUT_PATIENT_YN")!=null)?req.getParameter("TRANSFER_OUT_PATIENT_YN"):"N");
			hashmap.put("TRANSFER_IN_PATIENT_YN",(req.getParameter("TRANSFER_IN_PATIENT_YN")!=null)?req.getParameter("TRANSFER_IN_PATIENT_YN"):"N");
			hashmap.put("CHG_NURS_UNIT_IN_ASSIGN_BED_YN",(req.getParameter("CHG_NURS_UNIT_IN_ASSIGN_BED_YN")!=null)?req.getParameter("CHG_NURS_UNIT_IN_ASSIGN_BED_YN"):"N");
			hashmap.put("ADMIT_PATIENT_WITH_BED_YN",(req.getParameter("ADMIT_PATIENT_WITH_BED_YN")!=null)?req.getParameter("ADMIT_PATIENT_WITH_BED_YN"):"N");
			hashmap.put("FORCED_BOOK_APPT_YN",(req.getParameter("FORCED_BOOK_APPT_YN")!=null)?req.getParameter("FORCED_BOOK_APPT_YN"):"N");
			hashmap.put("GLOBAL_BOOK_APPT_YN",(req.getParameter("GLOBAL_BOOK_APPT_YN")!=null)?req.getParameter("GLOBAL_BOOK_APPT_YN"):"N");
			hashmap.put("canc_req_yn",(req.getParameter("canc_req_yn")!=null)?req.getParameter("canc_req_yn"):"N");
			hashmap.put("cfrm_req_yn",(req.getParameter("cfrm_req_yn")!=null)?req.getParameter("cfrm_req_yn"):"N");
			hashmap.put("can_tfr_out_yn",(req.getParameter("can_tfr_out_yn")!=null)?req.getParameter("can_tfr_out_yn"):"N");
			hashmap.put("pract_tfr_yn",(req.getParameter("pract_tfr_yn")!=null)?req.getParameter("pract_tfr_yn"):"N");
			//9/16/2008 putting the CANCEL_RESERVE_BED_YN in hash map
			hashmap.put("CANCEL_RESERVE_BED_YN",(req.getParameter("cancel_reBeds_yn")!=null)?req.getParameter("cancel_reBeds_yn"):"N");

			//9/16/2008 putting the CANCEL_RESERVE_BED_YN in hash map
			hashmap.put("dchrg_adv_yn",(req.getParameter("dchrg_adv_yn")!=null)?req.getParameter("dchrg_adv_yn"):"N");
			hashmap.put("BED_CLASS_CHANGE_YN",(req.getParameter("BED_CLASS_CHANGE_YN")!=null)?req.getParameter("BED_CLASS_CHANGE_YN"):"N");
			hashmap.put("BACKDATED_ADMISSION_YN",(req.getParameter("BACKDATED_ADMISSION_YN")!=null)?req.getParameter("BACKDATED_ADMISSION_YN"):"N");
			//Newly added on 09/01/2006
			hashmap.put("create_wait_list_yn",(req.getParameter("create_wait_list_yn")!=null)?req.getParameter("create_wait_list_yn"):"N");
			hashmap.put("modify_wait_list_yn",(req.getParameter("modify_wait_list_yn")!=null)?req.getParameter("modify_wait_list_yn"):"N");
			hashmap.put("cancel_wait_list_yn",(req.getParameter("cancel_wait_list_yn")!=null)?req.getParameter("cancel_wait_list_yn"):"N");

			hashmap.put("LINK_BABY_TO_MOTHER_YN",(req.getParameter("LINK_BABY_TO_MOTHER_YN")!=null)?req.getParameter("LINK_BABY_TO_MOTHER_YN"):"N");
			hashmap.put("REG_NEWBORN_FOR_IP_YN",(req.getParameter("REG_NEWBORN_FOR_IP_YN")!=null)?req.getParameter("REG_NEWBORN_FOR_IP_YN"):"N");
			hashmap.put("DISCHARGE_CHECKLIST_YN",(req.getParameter("DISCHARGE_CHECKLIST_YN")!=null)?req.getParameter("DISCHARGE_CHECKLIST_YN"):"N");
			hashmap.put("CANCEL_DISCHARGE_YN",(req.getParameter("CANCEL_DISCHARGE_YN")!=null)?req.getParameter("CANCEL_DISCHARGE_YN"):"N");
			hashmap.put("RESERVE_BED_BAY_YN",(req.getParameter("RESERVE_BED_BAY_YN")!=null)?req.getParameter("RESERVE_BED_BAY_YN"):"N");

			hashmap.put("RELEASE_BED_BAY_YN",(req.getParameter("RELEASE_BED_BAY_YN")!=null)?req.getParameter("RELEASE_BED_BAY_YN"):"N");

			hashmap.put("REG_IP_REFERRAL_YN",(req.getParameter("REG_IP_REFERRAL_YN")!=null)?req.getParameter("REG_IP_REFERRAL_YN"):"N");
			hashmap.put("CONFIRM_BEDSIDE_REFERRAL_YN",(req.getParameter("CONFIRM_BEDSIDE_REFERRAL_YN")!=null)?req.getParameter("CONFIRM_BEDSIDE_REFERRAL_YN"):"N");			
			
			hashmap.put("DIAG_PROC_RECODE_FOR_IP_YN",(req.getParameter("DIAG_PROC_RECODE_FOR_IP_YN")!=null)?req.getParameter("DIAG_PROC_RECODE_FOR_IP_YN"):"N");			
			hashmap.put("DIAG_PROC_RECODE_FOR_OP_YN",(req.getParameter("DIAG_PROC_RECODE_FOR_OP_YN")!=null)?req.getParameter("DIAG_PROC_RECODE_FOR_OP_YN"):"N");			

            hashmap.put("OVERRIDE_WALKIN_YN",(req.getParameter("OVERRIDE_WALKIN_YN")!=null)?req.getParameter("OVERRIDE_WALKIN_YN"):"N");

			hashmap.put("CANCEL_CHECKOUT_YN",(req.getParameter("CANCEL_CHECKOUT_YN")!=null)?req.getParameter("CANCEL_CHECKOUT_YN"):"N");
			
			
			hashmap.put("emergency_transfer_yn",(req.getParameter("emergency_transfer_yn")!=null)?req.getParameter("emergency_transfer_yn"):"N");

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();
			
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertOPOperatorStation",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8" ) );
			}

			hashmap.clear();
			results.clear();
		} catch ( Exception e )
			{
				//out.println("1  :"+p+"   2  :"+facilityId+"  3 :"+effectiveDateFrom+"  4:  "+effectiveDateTo+"  5  :"+effectiveStatus+"  6  :"+client_ip_address+"  7:  "+oper_stn_id+"  *  "+long_desc+"  9  :"+short_desc+"  10  :"+shift_operated_yn+"  11 :"+shift_group+"  12 :"+ws_no+"  13  :"+book_appt_yn+"  14  :"+book_appt_wo_pid_yn+"  15  :"+obook_appt_yn+"  16  :"+book_appt_across_catg_yn+"  17  :"+tfr_appt_yn+"  18  :"+tfr_appt_across_catg_yn+"    19  :"+canc_appt_yn+"  20  :"+register_visit_yn+"  21  :"+register_pat_yn+"  22  :"+cancel_visit_yn+"  23  :  "+revise_visit_yn+"  24  :"+manage_queue_yn+"  25  :"+checkout_pat_yn+"  26  :"+oper_stn_type+"  27  :"+create_booking_yn+"  28  :"+revise_booking_yn+"  29  :"+canc_booking_yn+"  30  :"+reject_admission_yn+"  31  :"+admit_pat_yn+"  32  :"+register_pat_in_admn_yn+"  33  :"+assign_bed_yn+"  34  :"+assign_treat_pract_yn+"  35  :"+canc_admission_yn+"  36  :"+emergency_tfr_yn+"  37  :"+routine_tfr_yn+"  38  :"+discharge_pat_yn+"  39  :"+revise_leave_yn+"  40  :"+check_lodger_yn+"  41  :"+CONFIRM_BOOKING_YN+"  42  :"+CREATE_BOOKING_WITH_CONF_YN" 43 :"+CANCEL_DISCHARGE_YN);
				e.printStackTrace();
			}
		}

private void deleteOPOperatorStation(HttpServletRequest req, HttpServletResponse res)	{
		try
			{
			res.setContentType("text/html");
			facility_id = req.getParameter("facility");
			if(facility_id == null) facility_id="";
			else
			facility_id = facility_id.trim();

			oper_stn_type =req.getParameter("operstntype");
			oper_stn_id =req.getParameter("oper_stn_id");
			out.println("facility_id "+ facility_id +" oper_stn_id "+ oper_stn_id +" oper_stn_type "+ oper_stn_type );

			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/OperatorStationManager");
			final OperatorStationHome operatorStationHome = (OperatorStationHome) PortableRemoteObject.narrow(homeObject ,OperatorStationHome.class);
			final OperatorStationRemote operatorStationRemote = operatorStationHome.create();

			final java.util.Hashtable results = operatorStationRemote.deleteOperatorStation(p,oper_stn_id,oper_stn_type,facility_id) ;*/

			
			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/OperatorStationManager",OperatorStationHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[1];

			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("oper_stn_id",oper_stn_id);
			hashmap.put("oper_stn_type",oper_stn_type);
			hashmap.put("facility_id",facility_id);
			
			argArray[0] = hashmap;
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass(); 
			

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteOperatorStation",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			//String error_value = "0" ;

			if ( inserted )
			{
			//	 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) );//+ "&err_value=" + error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error ,"UTF-8" ) );
			}
			hashmap.clear();
			results.clear();

			} catch ( Exception e ) {
				
				e.printStackTrace();
			//	out.println(" prob here:deleteOPOperatorStation");
			}
	}
}
