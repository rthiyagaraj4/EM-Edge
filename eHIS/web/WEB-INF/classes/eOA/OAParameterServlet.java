/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;

import eCommon.SingleTabHandler.*;
public class OAParameterServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String client_ip_address="",alcn_basis="",slot_appt_ctrl="",visit_limit_rule="",override_no_of_slots_yn="" ,alcn_criteria="",appt_slip_remarks1="",appt_slip_remarks2="",appt_slip_remarks3="",appt_slip_remarks4="",appt_slip_remarks5="",facilityId="",max_recurr_days="",grace_per_con_elap_wtlt="",cutoff_elps_wtlt="",high_not_invalid_wtlt="",wait_lst_appl="",wait_lst_reqd="",invite_appl="",restrict_wtlst_cat_spec="",billing_allow="",min_ela_per_resc_noshow_in_day="",noshow_ctrl_by_splty_or_clinic="",res_contact_mand="",email_applicable="",email_applicable1="";

    String DATE_LABEL="";
	String SALUTATION_LABEL="";
	String REF_NO_LABEL="";
	String MEDICAL_OFFICER_LABEL="";
	String NAME_LABEL="";
	String CLINIC_LABEL="";
	String ADDRESS_LABEL="";
	String NAT_ID_LABEL="";
	String TKS_LABEL="";
	String sendremin_appoint="";


	String NO_SHOW_TITLE="";

	String NO_SHOW_TEXT1="";
	String NO_SHOW_TEXT2="";
	String NO_SHOW_TEXT3="";
	String NO_SHOW_TEXT4="";
	String NO_SHOW_TEXT5="";



	String TFR_SCH_TITLE="";

	String TFR_SCH_TEXT1="";
	String TFR_SCH_TEXT2="";
	String TFR_SCH_TEXT3="";
	String TFR_SCH_TEXT4="";
	String TFR_SCH_TEXT5="";



	String BLK_CANC_TITLE="";

	String BLK_CANC_TEXT1="";
	String BLK_CANC_TEXT2="";
	String BLK_CANC_TEXT3="";
	String BLK_CANC_TEXT4="";
	String BLK_CANC_TEXT5="";

	String nbr_show_appts="";
	String period_chk_lst="";
    String upt_contact_dtls_mp_yn="";//added changes for HSA-CRF-0226 [IN:050599] 
	//Bru-HIMS-CRF 169 changes start
	String reason_pat_cancel_appt="";
	String max_cancelled_appt="";
	//Bru-HIMS-CRF 169 changes end

	String schedule_extend_yn = "N";//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112

	String blk_schdl_with_appt_yn="N";//JD-CRF-0168 changes
	String action_on_holiday_schedule="";//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 


	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("operation");

			if ( operation.equals("insert") ) insertAlcnBasis(req);
			if ( operation.equals("modify"))  modifyAlcnBasis(req);


		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}




	private synchronized void  modifyAlcnBasis(HttpServletRequest req)
	{
		try
		{

			alcn_basis=req.getParameter("alcn_basis");
			alcn_criteria=req.getParameter("alcn_criteria")==null?"":req.getParameter("alcn_criteria");
			slot_appt_ctrl=req.getParameter("slot_appt_ctrl")==null?"":req.getParameter("slot_appt_ctrl");
			visit_limit_rule=req.getParameter("visit_limit_rule")==null?"":req.getParameter("visit_limit_rule");
			override_no_of_slots_yn=req.getParameter("override_no_of_slots_yn");
			appt_slip_remarks1=req.getParameter("appt_slip_remarks1")==null?"":req.getParameter("appt_slip_remarks1");
			appt_slip_remarks2=req.getParameter("appt_slip_remarks2")==null?"":req.getParameter("appt_slip_remarks2");
			appt_slip_remarks3=req.getParameter("appt_slip_remarks3")==null?"":req.getParameter("appt_slip_remarks3");
			appt_slip_remarks4=req.getParameter("appt_slip_remarks4")==null?"":req.getParameter("appt_slip_remarks4");
			appt_slip_remarks5=req.getParameter("appt_slip_remarks5")==null?"":req.getParameter("appt_slip_remarks5");
			max_recurr_days=req.getParameter("max_recurr_days");
			nbr_show_appts=req.getParameter("number_appoinment")==null?"":req.getParameter("number_appoinment");
			period_chk_lst=req.getParameter("period_chkList")==null?"":req.getParameter("period_chkList");		

			if(max_recurr_days==null || max_recurr_days.equals(""))
				max_recurr_days="0";
			wait_lst_appl=req.getParameter("wait_lst_appl")==null?"N":req.getParameter("wait_lst_appl");
            wait_lst_reqd=req.getParameter("wait_lst_reqd")==null?"N":req.getParameter("wait_lst_reqd");
			invite_appl=req.getParameter("invite_appl")==null?"N":req.getParameter("invite_appl");
			restrict_wtlst_cat_spec=req.getParameter("restrict_wtlst_cat_spec")==null?"N":req.getParameter("restrict_wtlst_cat_spec");


			if (override_no_of_slots_yn==null) override_no_of_slots_yn="N";
			high_not_invalid_wtlt=req.getParameter("high_not_invalid_wtlt");
			if(high_not_invalid_wtlt ==null) high_not_invalid_wtlt="0";
			grace_per_con_elap_wtlt=req.getParameter("grace_per_con_elap_wtlt");
			if(grace_per_con_elap_wtlt ==null) grace_per_con_elap_wtlt="0";
			cutoff_elps_wtlt=req.getParameter("cutoff_elps_wtlt");
			if(cutoff_elps_wtlt ==null) cutoff_elps_wtlt="0";
            
			DATE_LABEL=req.getParameter("DATE_LABEL")==null?"":req.getParameter("DATE_LABEL").trim();
		
		   	REF_NO_LABEL=req.getParameter("REF_NO_LABEL")==null?"":req.getParameter("REF_NO_LABEL").trim();
    
			NAME_LABEL =req.getParameter("NAME_LABEL")==null?"":req.getParameter("NAME_LABEL").trim();
	
			 ADDRESS_LABEL=req.getParameter("ADDRESS_LABEL")==null?"":req.getParameter("ADDRESS_LABEL").trim();
		 
			  NAT_ID_LABEL  =req.getParameter("NAT_ID_LABEL")==null?"":req.getParameter("NAT_ID_LABEL").trim();
		
		      SALUTATION_LABEL =req.getParameter("SALUTATION_LABEL")==null?"":req.getParameter("SALUTATION_LABEL").trim();
		
		   MEDICAL_OFFICER_LABEL =req.getParameter("MEDICAL_OFFICER_LABEL")==null?"":req.getParameter("MEDICAL_OFFICER_LABEL").trim();
			 
		   CLINIC_LABEL =req.getParameter("CLINIC_LABEL")==null?"":req.getParameter("CLINIC_LABEL").trim();
    		

			TKS_LABEL  =req.getParameter("TKS_LABEL")==null?"":req.getParameter("TKS_LABEL").trim();

			
			NO_SHOW_TITLE =req.getParameter("NO_SHOW_TITLE")==null?"":req.getParameter("NO_SHOW_TITLE").trim();	
	

			NO_SHOW_TEXT1 =req.getParameter("NO_SHOW_TEXT1")==null?"":req.getParameter("NO_SHOW_TEXT1").trim();
			NO_SHOW_TEXT2 =req.getParameter("NO_SHOW_TEXT2")==null?"":req.getParameter("NO_SHOW_TEXT2").trim();
			NO_SHOW_TEXT3 =req.getParameter("NO_SHOW_TEXT3")==null?"":req.getParameter("NO_SHOW_TEXT3").trim();
			NO_SHOW_TEXT4 =req.getParameter("NO_SHOW_TEXT4")==null?"":req.getParameter("NO_SHOW_TEXT4").trim();
			NO_SHOW_TEXT5 =req.getParameter("NO_SHOW_TEXT5")==null?"":req.getParameter("NO_SHOW_TEXT5").trim();
		
			

			TFR_SCH_TITLE =req.getParameter("TFR_SCH_TITLE")==null?"":req.getParameter("TFR_SCH_TITLE").trim();
		
		
			TFR_SCH_TEXT1 =req.getParameter("TFR_SCH_TEXT1")==null?"":req.getParameter("TFR_SCH_TEXT1").trim();
			TFR_SCH_TEXT2 =req.getParameter("TFR_SCH_TEXT2")==null?"":req.getParameter("TFR_SCH_TEXT2").trim();
			TFR_SCH_TEXT3 =req.getParameter("TFR_SCH_TEXT3")==null?"":req.getParameter("TFR_SCH_TEXT3").trim();
			TFR_SCH_TEXT4 =req.getParameter("TFR_SCH_TEXT4")==null?"":req.getParameter("TFR_SCH_TEXT4").trim();
			TFR_SCH_TEXT5 =req.getParameter("TFR_SCH_TEXT5")==null?"":req.getParameter("TFR_SCH_TEXT5").trim();
		

			BLK_CANC_TITLE=req.getParameter("BLK_CANC_TITLE")==null?"":req.getParameter("BLK_CANC_TITLE").trim();
		
			BLK_CANC_TEXT1  =req.getParameter("BLK_CANC_TEXT1")==null?"":req.getParameter("BLK_CANC_TEXT1").trim();
			BLK_CANC_TEXT2  =req.getParameter("BLK_CANC_TEXT2")==null?"":req.getParameter("BLK_CANC_TEXT2").trim();
			BLK_CANC_TEXT3  =req.getParameter("BLK_CANC_TEXT3")==null?"":req.getParameter("BLK_CANC_TEXT3").trim();
			BLK_CANC_TEXT4 =req.getParameter("BLK_CANC_TEXT4")==null?"":req.getParameter("BLK_CANC_TEXT4").trim();
			BLK_CANC_TEXT5 =req.getParameter("BLK_CANC_TEXT5")==null?"":req.getParameter("BLK_CANC_TEXT5").trim();
			billing_allow  =req.getParameter("billing_allow")==null?"N":req.getParameter("billing_allow").trim();
			min_ela_per_resc_noshow_in_day=req.getParameter("limit_no_show_days")==null?"":req.getParameter("limit_no_show_days");
			noshow_ctrl_by_splty_or_clinic=req.getParameter("spec_locn")==null?"":req.getParameter("spec_locn");
			res_contact_mand=req.getParameter("res_contact_mand")==null?"N":req.getParameter("res_contact_mand");
			upt_contact_dtls_mp_yn=req.getParameter("upt_contact_dtls_mp_yn")==null?"N":req.getParameter("upt_contact_dtls_mp_yn");//added changes for HSA-CRF-0226 [IN:050599] 

			//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
			schedule_extend_yn = req.getParameter("schedule_extend_yn")==null?"N":req.getParameter("schedule_extend_yn");

			//recall_applicable=req.getParameter("recall_applicable")==null?"N":req.getParameter("recall_applicable");
			email_applicable=req.getParameter("email_applicable")==null?"N":req.getParameter("email_applicable");
			email_applicable1=req.getParameter("email_applicable1")==null?"N":req.getParameter("email_applicable1");
			sendremin_appoint=req.getParameter("sendremin_appoint")==null?"":req.getParameter("sendremin_appoint").trim();
			//By Sudhakar RUT-CRF-0005 Starts
			String rule_appl_yn					=req.getParameter("rule_appl_yn")==null?"N":req.getParameter("rule_appl_yn").trim();
			String rd_oa_integration_yn					=req.getParameter("rd_oa_integration_yn")==null?"N":req.getParameter("rd_oa_integration_yn").trim();
			String no_of_resch_appts_for_alert	=req.getParameter("no_of_resch_appts_for_alert")==null?"":req.getParameter("no_of_resch_appts_for_alert").trim();
			String per_chk_past_resch_appts		=req.getParameter("per_chk_past_resch_appts")==null?"":req.getParameter("per_chk_past_resch_appts").trim();
			String per_chk_fut_resch_appts		=req.getParameter("per_chk_fut_resch_appts")==null?"":req.getParameter("per_chk_fut_resch_appts").trim();
			String no_of_cancld_appts_for_alert	=req.getParameter("no_of_cancld_appts_for_alert")==null?"":req.getParameter("no_of_cancld_appts_for_alert").trim();
			String per_chk_cancld_past_appts	=req.getParameter("per_chk_cancld_past_appts")==null?"":req.getParameter("per_chk_cancld_past_appts").trim();
			String per_chk_cancld_fut_appts		=req.getParameter("per_chk_cancld_fut_appts")==null?"":req.getParameter("per_chk_cancld_fut_appts").trim();
			String mob_num_req_yn				=req.getParameter("mob_num_req_yn")==null?"N":req.getParameter("mob_num_req_yn").trim();
			String lang_req_yn					=req.getParameter("lang_req_yn")==null?"N":req.getParameter("lang_req_yn").trim();
			String no_of_fut_appts_for_alert	=req.getParameter("no_of_fut_appts_for_alert")==null?"":req.getParameter("no_of_fut_appts_for_alert").trim();
			String per_chk_for_fut_appts_alert		=req.getParameter("per_chk_for_fut_appts_alert")==null?"":req.getParameter("per_chk_for_fut_appts_alert").trim();
			//By Sudhakar RUT-CRF-0005 Ends
			String group_appt_yn			=req.getParameter("group_appt_yn")==null?"N":req.getParameter("group_appt_yn").trim();

			//Bru-HIMS-CRF 169 changes start 
			reason_pat_cancel_appt=req.getParameter("pat_cancel_reason")==null?"":req.getParameter("pat_cancel_reason").trim();
			max_cancelled_appt=req.getParameter("max_Cancelled_Appt")==null?"":req.getParameter("max_Cancelled_Appt").trim();
			//Bru-HIMS-CRF 169 Ends
			blk_schdl_with_appt_yn=req.getParameter("blk_schdl_with_appt_yn")==null?"N":req.getParameter("blk_schdl_with_appt_yn").trim();//JD-CRF-0168 changes
			
			if(no_of_resch_appts_for_alert==null || no_of_resch_appts_for_alert.equals(""))
				no_of_resch_appts_for_alert="0";

			if(per_chk_past_resch_appts==null || per_chk_past_resch_appts.equals(""))
				per_chk_past_resch_appts="0";

			if(per_chk_fut_resch_appts==null || per_chk_fut_resch_appts.equals(""))
				per_chk_fut_resch_appts="0";

			if(no_of_cancld_appts_for_alert==null || no_of_cancld_appts_for_alert.equals(""))
				no_of_cancld_appts_for_alert="0";

			if(per_chk_cancld_past_appts==null || per_chk_cancld_past_appts.equals(""))
				per_chk_cancld_past_appts="0";

			if(per_chk_cancld_fut_appts==null || per_chk_cancld_fut_appts.equals(""))
				per_chk_cancld_fut_appts="0";
			

			action_on_holiday_schedule=req.getParameter("action_on_holiday_schedule")==null?"W":req.getParameter("action_on_holiday_schedule");//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 
	
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			

			HashMap tabdata=new HashMap();
			tabdata.put("alcn_basis",alcn_basis);
			tabdata.put("alcn_criteria",alcn_criteria);
			tabdata.put("slot_appt_ctrl",slot_appt_ctrl);
			tabdata.put("visit_limit_rule",visit_limit_rule);
			tabdata.put("override_no_of_slots_yn",override_no_of_slots_yn);
			tabdata.put("appt_slip_remarks1",appt_slip_remarks1);
			tabdata.put("appt_slip_remarks2",appt_slip_remarks2);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("max_recurr_days",max_recurr_days );
			tabdata.put("ELAPSED_GRACE_PERIOD",grace_per_con_elap_wtlt);
			tabdata.put("FORCECLOSE_PERIOD",cutoff_elps_wtlt);
			tabdata.put("UNINVITED_PERIOD",high_not_invalid_wtlt);
			tabdata.put("WAITLIST_CATEGORY_APPL_YN",wait_lst_appl);
			tabdata.put("WAITLIST_CATEGORY_REQD_YN",wait_lst_reqd);
			tabdata.put("INVITATION_LIST_APPL_YN",invite_appl);
			tabdata.put("RESTRICT_WL_CAT_AGST_SPLTY_YN",restrict_wtlst_cat_spec);
			tabdata.put("DATE_LABEL",DATE_LABEL);
			tabdata.put("REF_NO_LABEL",REF_NO_LABEL);
			tabdata.put("NAME_LABEL ",NAME_LABEL);
			tabdata.put("ADDRESS_LABEL",ADDRESS_LABEL);
			tabdata.put("NAT_ID_LABEL",NAT_ID_LABEL );
			tabdata.put("SALUTATION_LABEL ",SALUTATION_LABEL );
			tabdata.put("MEDICAL_OFFICER_LABEL",MEDICAL_OFFICER_LABEL);
			tabdata.put("CLINIC_LABEL ",CLINIC_LABEL );
			tabdata.put("TKS_LABEL",TKS_LABEL);
			tabdata.put("NO_SHOW_TITLE  ",NO_SHOW_TITLE);
			tabdata.put("NO_SHOW_TEXT1",NO_SHOW_TEXT1);
			tabdata.put("NO_SHOW_TEXT2",NO_SHOW_TEXT2);
			tabdata.put("NO_SHOW_TEXT3",NO_SHOW_TEXT3);
			tabdata.put("NO_SHOW_TEXT4",NO_SHOW_TEXT4);
			tabdata.put("NO_SHOW_TEXT5",NO_SHOW_TEXT5);
			tabdata.put("TFR_SCH_TITLE",TFR_SCH_TITLE);
			tabdata.put("TFR_SCH_TEXT1",TFR_SCH_TEXT1);
			tabdata.put("TFR_SCH_TEXT2",TFR_SCH_TEXT2);
			tabdata.put("TFR_SCH_TEXT3",TFR_SCH_TEXT3);
			tabdata.put("TFR_SCH_TEXT4",TFR_SCH_TEXT4);
			tabdata.put("TFR_SCH_TEXT5",TFR_SCH_TEXT5);
			tabdata.put("BLK_CANC_TITLE",BLK_CANC_TITLE);
			tabdata.put("BLK_CANC_TEXT1 ",BLK_CANC_TEXT1);
			tabdata.put("BLK_CANC_TEXT2 ",BLK_CANC_TEXT2);
			tabdata.put("BLK_CANC_TEXT3 ",BLK_CANC_TEXT3);
			tabdata.put("BLK_CANC_TEXT4 ",BLK_CANC_TEXT4);
			tabdata.put("BLK_CANC_TEXT5 ",BLK_CANC_TEXT5);
			tabdata.put("CAPTURE_FIN_DTLS_YN ",billing_allow);
			tabdata.put("APPT_SLIP_REMARKS3 ",appt_slip_remarks3);
			tabdata.put("APPT_SLIP_REMARKS4 ",appt_slip_remarks4);
			tabdata.put("APPT_SLIP_REMARKS5 ",appt_slip_remarks5);
			tabdata.put("MIN_ELA_PER_RESC_NOSHOW_IN_DAY ",min_ela_per_resc_noshow_in_day);
			tabdata.put("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC ",noshow_ctrl_by_splty_or_clinic);
			tabdata.put("CONTACT_NUM_REQD_YN ",res_contact_mand);			
			tabdata.put("NO_OF_NOSHOW_APPTS_FOR_ALERT ",nbr_show_appts);
			tabdata.put("PER_CHK_FOR_NO_SHOW_ALERT ",period_chk_lst);

		
           //tabdata.put("RECALL_REMINDER_APPL_YN",recall_applicable);
           tabdata.put("EMAIL_APPL_YN",email_applicable);
           tabdata.put("EMAIL_APPL_FOR_APPT_WO_PID_YN",email_applicable1);
		   tabdata.put("SEND_REMINDER_FOR_APPT_BEFORE ",sendremin_appoint);
		   //By Sudhakar RUT-CRF-0005 Starts
		   tabdata.put("RULE_APPL_YN ",rule_appl_yn);
		   tabdata.put("rd_oa_integration_yn ",rd_oa_integration_yn);
		   tabdata.put("group_appt_yn ",group_appt_yn);
   		   
	   
		   tabdata.put("NO_OF_RESCH_APPTS_FOR_ALERT ",no_of_resch_appts_for_alert);
		   tabdata.put("PER_CHK_PAST_RESCH_APPTS ",per_chk_past_resch_appts);
		   tabdata.put("PER_CHK_FUT_RESCH_APPTS ",per_chk_fut_resch_appts);
		   tabdata.put("NO_OF_CANCLD_APPTS_FOR_ALERT ",no_of_cancld_appts_for_alert);
		   tabdata.put("PER_CHK_CANCLD_PAST_APPTS ",per_chk_cancld_past_appts);
		   tabdata.put("PER_CHK_CANCLD_FUT_APPTS ",per_chk_cancld_fut_appts);
		   tabdata.put("MOB_NUM_REQ_YN ",mob_num_req_yn);
		   tabdata.put("LANGUAGE_REQ_YN ",lang_req_yn);
		   tabdata.put("NO_OF_FUT_APPTS_FOR_ALERT ",no_of_fut_appts_for_alert);
		   tabdata.put("PER_CHK_FOR_FUT_APPTS_ALERT ",per_chk_for_fut_appts_alert);
			//By Sudhakar RUT-CRF-0005 Ends
			
			//Bru-HIMS-CRF-169 starts
			tabdata.put("PAT_CANCEL_REASON ",reason_pat_cancel_appt);
			tabdata.put("MAX_CANCEL_APPT ",max_cancelled_appt);
			//Bru-HIMS-CRF-169 Ends
			tabdata.put("BLK_SCHDL_WITH_APPT_YN",blk_schdl_with_appt_yn);//JD-CRF-0168 changes
			tabdata.put("UPT_CONTACT_DTLS_MP_YN",upt_contact_dtls_mp_yn);//added changes for HSA-CRF-0226 [IN:050599] 

			tabdata.put("ACTION_ON_HOLIDAY_SCHEDULE",action_on_holiday_schedule);//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 

			tabdata.put("SCHEDULE_EXTEND_YN",schedule_extend_yn);//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112

			
			HashMap condflds=new HashMap();
			String hard_val="oa_param";
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = hard_val;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = hard_val.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				error_value = "1" ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");

			}else{
				error = (String) results.get("error") ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");

			}
			condflds.clear();
			results.clear();
			tabdata.clear();
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}

	private synchronized void insertAlcnBasis(HttpServletRequest req)
	{
		try
		{

			alcn_basis=req.getParameter("alcn_basis");
			alcn_criteria=req.getParameter("alcn_criteria")==null?"":req.getParameter("alcn_criteria");
			slot_appt_ctrl=req.getParameter("slot_appt_ctrl");
			visit_limit_rule=req.getParameter("visit_limit_rule");
			override_no_of_slots_yn=req.getParameter("override_no_of_slots_yn");
			appt_slip_remarks1=req.getParameter("appt_slip_remarks1");
			appt_slip_remarks2=req.getParameter("appt_slip_remarks2");
			appt_slip_remarks3=req.getParameter("appt_slip_remarks3");
			appt_slip_remarks4=req.getParameter("appt_slip_remarks4");
			appt_slip_remarks5=req.getParameter("appt_slip_remarks5");
			high_not_invalid_wtlt=req.getParameter("high_not_invalid_wtlt");
			max_recurr_days=req.getParameter("max_recurr_days");
			nbr_show_appts=req.getParameter("number_appoinment")==null?"":req.getParameter("number_appoinment");
			period_chk_lst=req.getParameter("period_chkList")==null?"":req.getParameter("period_chkList");			

			if(max_recurr_days==null || max_recurr_days.equals(""))
				max_recurr_days="0";
            if (slot_appt_ctrl==null) slot_appt_ctrl="";
            if (visit_limit_rule==null) visit_limit_rule="N";
            if (override_no_of_slots_yn==null) override_no_of_slots_yn="N";
            if (appt_slip_remarks1==null) appt_slip_remarks1="";
            if (appt_slip_remarks2==null) appt_slip_remarks2="";
            if(high_not_invalid_wtlt ==null) high_not_invalid_wtlt="0";
			
			grace_per_con_elap_wtlt=req.getParameter("grace_per_con_elap_wtlt");
			if(grace_per_con_elap_wtlt ==null) grace_per_con_elap_wtlt="0";

			cutoff_elps_wtlt=req.getParameter("cutoff_elps_wtlt");
			if(cutoff_elps_wtlt ==null) cutoff_elps_wtlt="0";
			wait_lst_appl=req.getParameter("wait_lst_appl")==null?"N":req.getParameter("wait_lst_appl");
            wait_lst_reqd=req.getParameter("wait_lst_reqd")==null?"N":req.getParameter("wait_lst_reqd");
			invite_appl=req.getParameter("invite_appl")==null?"N":req.getParameter("invite_appl");

			restrict_wtlst_cat_spec=req.getParameter("restrict_wtlst_cat_spec")==null?"N":req.getParameter("restrict_wtlst_cat_spec");


			DATE_LABEL=req.getParameter("DATE_LABEL")==null?"":req.getParameter("DATE_LABEL");
		   	REF_NO_LABEL=req.getParameter("REF_NO_LABEL")==null?"":req.getParameter("REF_NO_LABEL");
			NAME_LABEL =req.getParameter("NAME_LABEL")==null?"":req.getParameter("NAME_LABEL");
		    ADDRESS_LABEL=req.getParameter("ADDRESS_LABEL")==null?"":req.getParameter("ADDRESS_LABEL");
		    NAT_ID_LABEL=req.getParameter("NAT_ID_LABEL")==null?"":req.getParameter("NAT_ID_LABEL");
		    SALUTATION_LABEL =req.getParameter("SALUTATION_LABEL ")==null?"":req.getParameter("SALUTATION_LABEL");
		    MEDICAL_OFFICER_LABEL =req.getParameter("MEDICAL_OFFICER_LABEL")==null?"":req.getParameter("MEDICAL_OFFICER_LABEL");
		 
			   CLINIC_LABEL =req.getParameter("CLINIC_LABEL")==null?"":req.getParameter("CLINIC_LABEL");
    		

				TKS_LABEL  =req.getParameter("TKS_LABEL")==null?"":req.getParameter("TKS_LABEL");

			
			NO_SHOW_TITLE =req.getParameter("NO_SHOW_TITLE")==null?"":req.getParameter("NO_SHOW_TITLE");


			NO_SHOW_TEXT1 =req.getParameter("NO_SHOW_TEXT1")==null?"":req.getParameter("NO_SHOW_TEXT1");
			NO_SHOW_TEXT2 =req.getParameter("NO_SHOW_TEXT2")==null?"":req.getParameter("NO_SHOW_TEXT2");
			NO_SHOW_TEXT3 =req.getParameter("NO_SHOW_TEXT3")==null?"":req.getParameter("NO_SHOW_TEXT3");
			NO_SHOW_TEXT4 =req.getParameter("NO_SHOW_TEXT4")==null?"":req.getParameter("NO_SHOW_TEXT4");
			NO_SHOW_TEXT5 =req.getParameter("NO_SHOW_TEXT5")==null?"":req.getParameter("NO_SHOW_TEXT5");
			
			

			TFR_SCH_TITLE =req.getParameter("TFR_SCH_TITLE")==null?"":req.getParameter("TFR_SCH_TITLE");
		
		
			TFR_SCH_TEXT1 =req.getParameter("TFR_SCH_TEXT1")==null?"":req.getParameter("TFR_SCH_TEXT1");
			TFR_SCH_TEXT2 =req.getParameter("TFR_SCH_TEXT2")==null?"":req.getParameter("TFR_SCH_TEXT2");
			TFR_SCH_TEXT3 =req.getParameter("TFR_SCH_TEXT3")==null?"":req.getParameter("TFR_SCH_TEXT3");
			TFR_SCH_TEXT4 =req.getParameter("TFR_SCH_TEXT4")==null?"":req.getParameter("TFR_SCH_TEXT4");
			TFR_SCH_TEXT5 =req.getParameter("TFR_SCH_TEXT5")==null?"":req.getParameter("TFR_SCH_TEXT5");
		

			BLK_CANC_TITLE=req.getParameter("BLK_CANC_TITLE")==null?"":req.getParameter("BLK_CANC_TITLE");
		  
			BLK_CANC_TEXT1  =req.getParameter("BLK_CANC_TEXT1")==null?"":req.getParameter("BLK_CANC_TEXT1");
			BLK_CANC_TEXT2  =req.getParameter("BLK_CANC_TEXT2")==null?"":req.getParameter("BLK_CANC_TEXT2");
			BLK_CANC_TEXT3  =req.getParameter("BLK_CANC_TEXT3")==null?"":req.getParameter("BLK_CANC_TEXT3");
			BLK_CANC_TEXT4 =req.getParameter("BLK_CANC_TEXT4")==null?"":req.getParameter("BLK_CANC_TEXT4");
			BLK_CANC_TEXT5 =req.getParameter("BLK_CANC_TEXT5")==null?"":req.getParameter("BLK_CANC_TEXT5");
			billing_allow  =req.getParameter("billing_allow")==null?"N":req.getParameter("billing_allow").trim();
			min_ela_per_resc_noshow_in_day=req.getParameter("limit_no_show_days")==null?"":req.getParameter("limit_no_show_days");
			noshow_ctrl_by_splty_or_clinic=req.getParameter("spec_locn")==null?"":req.getParameter("spec_locn");
			res_contact_mand=req.getParameter("res_contact_mand")==null?"N":req.getParameter("res_contact_mand");
            upt_contact_dtls_mp_yn=req.getParameter("upt_contact_dtls_mp_yn")==null?"N":req.getParameter("upt_contact_dtls_mp_yn");//added changes for HSA-CRF-0226 [IN:050599] 
			
			//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
			schedule_extend_yn = req.getParameter("schedule_extend_yn")==null?"N":req.getParameter("schedule_extend_yn");

          //recall_applicable=req.getParameter("recall_applicable")==null?"N":req.getParameter("recall_applicable");
          email_applicable=req.getParameter("email_applicable")==null?"N":req.getParameter("email_applicable");
          email_applicable1=req.getParameter("email_applicable1")==null?"N":req.getParameter("email_applicable1");
		  sendremin_appoint=req.getParameter("sendremin_appoint")==null?"":req.getParameter("sendremin_appoint").trim();
		  //By Sudhakar RUT-CRF-0005 Starts
			String rule_appl_yn					=req.getParameter("rule_appl_yn")==null?"N":req.getParameter("rule_appl_yn").trim();
			String rd_oa_integration_yn					=req.getParameter("rd_oa_integration_yn")==null?"N":req.getParameter("rd_oa_integration_yn").trim();
			String no_of_resch_appts_for_alert	=req.getParameter("no_of_resch_appts_for_alert")==null?"":req.getParameter("no_of_resch_appts_for_alert").trim();
			String per_chk_past_resch_appts		=req.getParameter("per_chk_past_resch_appts")==null?"":req.getParameter("per_chk_past_resch_appts").trim();
			String per_chk_fut_resch_appts		=req.getParameter("per_chk_fut_resch_appts")==null?"":req.getParameter("per_chk_fut_resch_appts").trim();
			String no_of_cancld_appts_for_alert	=req.getParameter("no_of_cancld_appts_for_alert")==null?"":req.getParameter("no_of_cancld_appts_for_alert").trim();
			String per_chk_cancld_past_appts	=req.getParameter("per_chk_cancld_past_appts")==null?"":req.getParameter("per_chk_cancld_past_appts").trim();
			String per_chk_cancld_fut_appts		=req.getParameter("per_chk_cancld_fut_appts")==null?"":req.getParameter("per_chk_cancld_fut_appts").trim();
			String mob_num_req_yn				=req.getParameter("mob_num_req_yn")==null?"N":req.getParameter("mob_num_req_yn").trim();
			String lang_req_yn					=req.getParameter("lang_req_yn")==null?"N":req.getParameter("lang_req_yn").trim();
			String no_of_fut_appts_for_alert	=req.getParameter("no_of_fut_appts_for_alert")==null?"":req.getParameter("no_of_fut_appts_for_alert").trim();
			String per_chk_for_fut_appts_alert		=req.getParameter("per_chk_for_fut_appts_alert")==null?"":req.getParameter("per_chk_for_fut_appts_alert").trim();
			//By Sudhakar RUT-CRF-0005 Ends
			String group_appt_yn			=req.getParameter("group_appt_yn")==null?"N":req.getParameter("group_appt_yn").trim();
			//Bru-HIMS-CRF 169 changes start 
			reason_pat_cancel_appt=req.getParameter("pat_cancel_reason")==null?"":req.getParameter("pat_cancel_reason").trim();
			max_cancelled_appt=req.getParameter("max_Cancelled_Appt")==null?"":req.getParameter("max_Cancelled_Appt").trim();
			//Bru-HIMS-CRF 169 Ends

			blk_schdl_with_appt_yn=req.getParameter("blk_schdl_with_appt_yn")==null?"N":req.getParameter("blk_schdl_with_appt_yn").trim();//JD-CRF-0168 changes

			action_on_holiday_schedule=req.getParameter("action_on_holiday_schedule")==null?"W":req.getParameter("action_on_holiday_schedule");//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 


			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
			

			HashMap tabdata=new HashMap();
			tabdata.put("alcn_basis",alcn_basis);
			tabdata.put("alcn_criteria",alcn_criteria);
			tabdata.put("slot_appt_ctrl",slot_appt_ctrl);
			tabdata.put("visit_limit_rule",visit_limit_rule);
			tabdata.put("override_no_of_slots_yn",override_no_of_slots_yn);
			tabdata.put("appt_slip_remarks1",appt_slip_remarks1);
			tabdata.put("appt_slip_remarks2",appt_slip_remarks2);
			
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("max_recurr_days",max_recurr_days );
			tabdata.put("ELAPSED_GRACE_PERIOD",grace_per_con_elap_wtlt);
			tabdata.put("FORCECLOSE_PERIOD",cutoff_elps_wtlt);
			tabdata.put("UNINVITED_PERIOD",high_not_invalid_wtlt);
			tabdata.put("WAITLIST_CATEGORY_APPL_YN",wait_lst_appl);
			tabdata.put("WAITLIST_CATEGORY_REQD_YN",wait_lst_reqd);
			tabdata.put("INVITATION_LIST_APPL_YN",invite_appl);

			tabdata.put("RESTRICT_WL_CAT_AGST_SPLTY_YN",restrict_wtlst_cat_spec);


             tabdata.put("DATE_LABEL",DATE_LABEL);
		
			tabdata.put("REF_NO_LABEL",REF_NO_LABEL);
			tabdata.put("NAME_LABEL ",NAME_LABEL);
			tabdata.put("ADDRESS_LABEL",ADDRESS_LABEL);
			tabdata.put("NAT_ID_LABEL",NAT_ID_LABEL);
			tabdata.put("SALUTATION_LABEL ",SALUTATION_LABEL );
			tabdata.put("MEDICAL_OFFICER_LABEL",MEDICAL_OFFICER_LABEL);
			tabdata.put("CLINIC_LABEL ",CLINIC_LABEL );
			tabdata.put("TKS_LABEL",TKS_LABEL);
			tabdata.put("NO_SHOW_TITLE  ",NO_SHOW_TITLE   );
			tabdata.put("NO_SHOW_TEXT1",NO_SHOW_TEXT1);
			tabdata.put("NO_SHOW_TEXT2",NO_SHOW_TEXT2);
			tabdata.put("NO_SHOW_TEXT3",NO_SHOW_TEXT3);
			tabdata.put("NO_SHOW_TEXT4",NO_SHOW_TEXT4);
			tabdata.put("NO_SHOW_TEXT5",NO_SHOW_TEXT5);
			tabdata.put("TFR_SCH_TITLE",TFR_SCH_TITLE );
			tabdata.put("TFR_SCH_TEXT1",TFR_SCH_TEXT1 );
			tabdata.put("TFR_SCH_TEXT2",TFR_SCH_TEXT2 );
			tabdata.put("TFR_SCH_TEXT3",TFR_SCH_TEXT3 );
			tabdata.put("TFR_SCH_TEXT4",TFR_SCH_TEXT4 );
			tabdata.put("TFR_SCH_TEXT5",TFR_SCH_TEXT5 );
			tabdata.put("BLK_CANC_TITLE",BLK_CANC_TITLE );
			tabdata.put("BLK_CANC_TEXT1 ",BLK_CANC_TEXT1 );
			tabdata.put("BLK_CANC_TEXT2 ",BLK_CANC_TEXT2 );
			tabdata.put("BLK_CANC_TEXT3 ",BLK_CANC_TEXT3 );
			tabdata.put("BLK_CANC_TEXT4 ",BLK_CANC_TEXT4 );
			tabdata.put("BLK_CANC_TEXT5 ",BLK_CANC_TEXT5 );
			tabdata.put("CAPTURE_FIN_DTLS_YN ",billing_allow);
			tabdata.put("APPT_SLIP_REMARKS3 ",appt_slip_remarks3);
			tabdata.put("APPT_SLIP_REMARKS4 ",appt_slip_remarks4);
			tabdata.put("APPT_SLIP_REMARKS5 ",appt_slip_remarks5);
			tabdata.put("MIN_ELA_PER_RESC_NOSHOW_IN_DAY ",min_ela_per_resc_noshow_in_day);
			tabdata.put("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC ",noshow_ctrl_by_splty_or_clinic);
            tabdata.put("CONTACT_NUM_REQD_YN ",res_contact_mand);
			tabdata.put("NO_OF_NOSHOW_APPTS_FOR_ALERT ",nbr_show_appts);
			tabdata.put("PER_CHK_FOR_NO_SHOW_ALERT ",period_chk_lst);

			//tabdata.put("RECALL_REMINDER_APPL_YN",recall_applicable);
            tabdata.put("EMAIL_APPL_YN",email_applicable);
            tabdata.put("EMAIL_APPL_FOR_APPT_WO_PID_YN",email_applicable1);
			tabdata.put("SEND_REMINDER_FOR_APPT_BEFORE ",sendremin_appoint);
			//By Sudhakar RUT-CRF-0005 Starts
			tabdata.put("RULE_APPL_YN ",rule_appl_yn);
			tabdata.put("rd_oa_integration_yn ",rd_oa_integration_yn);
			tabdata.put("NO_OF_RESCH_APPTS_FOR_ALERT ",no_of_resch_appts_for_alert);
			tabdata.put("PER_CHK_PAST_RESCH_APPTS ",per_chk_past_resch_appts);
			tabdata.put("PER_CHK_FUT_RESCH_APPTS ",per_chk_fut_resch_appts);
			tabdata.put("NO_OF_CANCLD_APPTS_FOR_ALERT ",no_of_cancld_appts_for_alert);
			tabdata.put("PER_CHK_CANCLD_PAST_APPTS ",per_chk_cancld_past_appts);
			tabdata.put("PER_CHK_CANCLD_FUT_APPTS ",per_chk_cancld_fut_appts);
		   tabdata.put("MOB_NUM_REQ_YN ",mob_num_req_yn);
		   tabdata.put("LANGUAGE_REQ_YN ",lang_req_yn);
			tabdata.put("NO_OF_FUT_APPTS_FOR_ALERT ",no_of_fut_appts_for_alert);
			tabdata.put("PER_CHK_FOR_FUT_APPTS_ALERT ",per_chk_for_fut_appts_alert);
			
			tabdata.put("group_appt_yn ",group_appt_yn);
			
			//Bru-HIMS-CRF-169 starts
			tabdata.put("PAT_CANCEL_REASON ",reason_pat_cancel_appt);
			tabdata.put("MAX_CANCEL_APPT ",max_cancelled_appt);
			//Bru-HIMS-CRF-169 Ends
			
			tabdata.put("BLK_SCHDL_WITH_APPT_YN",blk_schdl_with_appt_yn);//JD-CRF-0168 changes
		//By Sudhakar RUT-CRF-0005 Ends
		tabdata.put("upt_contact_dtls_mp_yn",upt_contact_dtls_mp_yn);

		tabdata.put("ACTION_ON_HOLIDAY_SCHEDULE",action_on_holiday_schedule);//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 

			tabdata.put("SCHEDULE_EXTEND_YN",schedule_extend_yn);//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112


			String dupflds[]={"alcn_basis"};
			String hard_val="oa_param";

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = hard_val;


			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = hard_val.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
			{
			 error_value = "1" ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");


			}
			else
			{
			 error = (String) results.get("error") ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");

			}

			results.clear();
			tabdata.clear();
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();

		}

	}


} 
