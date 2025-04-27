<!DOCTYPE html>
 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
 
<%    // Modified for CRF - SRR -0425 -- Order Catalog.


		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		//Added for getting value for Calling Mode 
		String callingMode = request.getParameter("callingMode");
		if (callingMode==null) callingMode = "";
		// End of the addition	
		String mode_find=request.getParameter("mode_find");	
		String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
		if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";			
		String clinic_code1=(String)request.getParameter("clinic_code1");
		String practitioner_id1=(String)request.getParameter("practitioner_id1");
		String clinic_code2=(String)request.getParameter("clinic_code2");
		String practitioner_id2=(String)request.getParameter("practitioner_id2");
		String clinic_code3=(String)request.getParameter("clinic_code3");
		String practitioner_id3=(String)request.getParameter("practitioner_id3");
		String clinic_type1=request.getParameter("clinic_type1");
		String res_type1=request.getParameter("res_type1");
		String clinic_type2=request.getParameter("clinic_type2");
		String res_type2=request.getParameter("res_type2");
		String clinic_type3=request.getParameter("clinic_type3");
		String res_type3=request.getParameter("res_type3");
String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";
 String from_page=request.getParameter("from_page");
if(from_page ==null) from_page="";
		if (clinic_type1==null) clinic_type1 = "C";
		if (res_type1==null) res_type1 = "P";

		if (clinic_type2==null) clinic_type2 = "C";
		if (res_type2==null) res_type2 = "P";


		if (clinic_type3==null) clinic_type3 = "C";
		if (res_type3==null) res_type3 = "P";

		String or_catalogue_code=request.getParameter("or_catalogue_code");
		if(or_catalogue_code == null) or_catalogue_code="";

		


		String Date=(String)request.getParameter("Date");
		String Date1=(String)request.getParameter("Date1");
		String Date2=(String)request.getParameter("Date2");
		

		String value12=(String)request.getParameter("value12");
		String value13=(String)request.getParameter("value13");

		//Added by Suman regd Sql tuning
		String order_id=request.getParameter("order_id");
		if(order_id ==null) order_id="";

		String order_line_num=request.getParameter("order_line_num");
		if(order_line_num ==null) order_line_num="";

		String order_catalog_code=request.getParameter("order_catalog_code");
		if(order_catalog_code ==null) order_catalog_code="";

		String slot_appt_ctrl=request.getParameter("slot_appt_ctrl")==null?"":request.getParameter("slot_appt_ctrl");
		String visit_limit_rule=request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule");
		String alcn_criteria=request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
		String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn")==null?"":request.getParameter("override_no_of_slots_yn");
		String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn")==null?"N":request.getParameter("capture_fin_dtls_yn");
		String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day")==null?"":request.getParameter("min_ela_per_resc_noshow_in_day");
		String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic")==null?"":request.getParameter("noshow_ctrl_by_splty_or_clinic");
		String contact_num_reqd_yn=request.getParameter("contact_num_reqd_yn")==null?"N":request.getParameter("contact_num_reqd_yn");
		String no_of_noshow_appts_for_alert=request.getParameter("no_of_noshow_appts_for_alert")==null?"":request.getParameter("no_of_noshow_appts_for_alert");
		String per_chk_for_no_show_alert=request.getParameter("per_chk_for_no_show_alert")==null?"":request.getParameter("per_chk_for_no_show_alert");







		String oper_stn_id = request.getParameter("oper_stn_id");
		if(oper_stn_id == null) oper_stn_id="";



		//ends hre

		String old_clinic=(String)request.getParameter("old_clinic");
		if(old_clinic == null || old_clinic.equals("null")) old_clinic="";

		String old_practitioner=(String)request.getParameter("old_practitioner");
		if(old_practitioner== null || old_practitioner.equals("null"))old_practitioner="";

		String old_date=(String)request.getParameter("old_date");
		if(old_date  == null || old_date.equals("null")) old_date="";

		String old_from_time = request.getParameter("old_from_time");
		if( old_from_time == null) old_from_time="";

		String old_to_time = request.getParameter("old_to_time");
		if( old_to_time == null) old_to_time="";
		String ca_mode = request.getParameter("ca_mode");
		if(( ca_mode == null) || ca_mode.equals(""))  ca_mode="";
		String ca_patient_id=(String)request.getParameter("ca_patient_id");
	//MR by suman 
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
		String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="N";
		String visit_flag_OP=request.getParameter("visit_flag_OP");
					if(visit_flag_OP==null) visit_flag_OP="N";	





//OPCheckout
		String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";
		String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");//added for the incident 40965
%>
<html>
	<frameset cols='33%,*,33%'>
		<frameset rows='*,1%'>
		
			<frame name='result' src='../../eOA/jsp/MP3DisplayResults.jsp?value_chk=display1&clinic_code1=<%=clinic_code1%>&practitioner_id1=<%=practitioner_id1%>&clinic_code2=<%=clinic_code2%>&callingMode=<%=callingMode%>&practitioner_id2=<%=practitioner_id2%>&clinic_code3=<%=clinic_code3%>&practitioner_id3=<%=practitioner_id3%>&Date=<%=Date%>&Date1=<%=Date1%>&Date2=<%=Date2%>&value12=<%=value12%>&value13=<%=value13%>&old_clinic=<%=old_clinic%>&old_practitioner=<%=old_practitioner%>&old_date=<%=old_date%>&old_from_time=<%=old_from_time%>&old_to_time=<%=old_to_time%>&pre_pat_alcn_catg_code=<%=pre_pat_alcn_catg_code%>&ca_patient_id=<%=ca_patient_id%>&ca_mode=<%=ca_mode%>&mode_find=<%=mode_find%>&clinic_type1=<%=clinic_type1%>&res_type1=<%=res_type1%>&clinic_type2=<%=clinic_type2%>&res_type2=<%=res_type2%>&clinic_type3=<%=clinic_type3%>&res_type3=<%=res_type3%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&order_catalog_code=<%=order_catalog_code%>&oper_stn_id=<%=oper_stn_id%>&alcn_criteria=<%=alcn_criteria%>&visit_limit_rule=<%=visit_limit_rule%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&rd_appt_yn=<%=rd_appt_yn%>' frameborder=no noresize scrolling=auto> <!--rd_appt_yn included for the incident 40965-->
		</frameset>
			<frameset rows='*,1%'>
		
			<frame name='result1' src='../../eOA/jsp/MP3DisplayResults.jsp?value_chk=display2&clinic_code1=<%=clinic_code1%>&practitioner_id1=<%=practitioner_id1%>&clinic_code2=<%=clinic_code2%>&practitioner_id2=<%=practitioner_id2%>&clinic_code3=<%=clinic_code3%>&callingMode=<%=callingMode%>&practitioner_id3=<%=practitioner_id3%>&Date=<%=Date%>&Date1=<%=Date1%>&Date2=<%=Date2%>&value12=<%=value12%>&value13=<%=value13%>&old_clinic=<%=old_clinic%>&old_practitioner=<%=old_practitioner%>&old_date=<%=old_date%>&old_from_time=<%=old_from_time%>&old_to_time=<%=old_to_time%>&pre_pat_alcn_catg_code=<%=pre_pat_alcn_catg_code%>&ca_patient_id=<%=ca_patient_id%>&ca_mode=<%=ca_mode%>&mode_find=<%=mode_find%>&clinic_type1=<%=clinic_type1%>&res_type1=<%=res_type1%>&clinic_type2=<%=clinic_type2%>&res_type2=<%=res_type2%>&clinic_type3=<%=clinic_type3%>&res_type3=<%=res_type3%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&order_catalog_code=<%=order_catalog_code%>&oper_stn_id=<%=oper_stn_id%>&alcn_criteria=<%=alcn_criteria%>&visit_limit_rule=<%=visit_limit_rule%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&rd_appt_yn=<%=rd_appt_yn%>' frameborder=no noresize scrolling=auto> <!--rd_appt_yn included for the incident 40965-->
		</frameset>
			<frameset rows='*,1%'>
			
				<frame name='result2' 					src='../../eOA/jsp/MP3DisplayResults.jsp?value_chk=display3&clinic_code1=<%=clinic_code1%>&practitioner_id1=<%=practitioner_id1%>&callingMode=<%=callingMode%>&clinic_code2=<%=clinic_code2%>&practitioner_id2=<%=practitioner_id2%>&clinic_code3=<%=clinic_code3%>&practitioner_id3=<%=practitioner_id3%>&Date=<%=Date%>&Date1=<%=Date1%>&Date2=<%=Date2%>&value12=<%=value12%>&value13=<%=value13%>&old_clinic=<%=old_clinic%>&old_practitioner=<%=old_practitioner%>&old_date=<%=old_date%>&old_from_time=<%=old_from_time%>&old_to_time=<%=old_to_time%>&pre_pat_alcn_catg_code=<%=pre_pat_alcn_catg_code%>&ca_patient_id=<%=ca_patient_id%>&ca_mode=<%=ca_mode%>&mode_find=<%=mode_find%>&clinic_type1=<%=clinic_type1%>&res_type1=<%=res_type1%>&clinic_type2=<%=clinic_type2%>&res_type2=<%=res_type2%>&clinic_type3=<%=clinic_type3%>&res_type3=<%=res_type3%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&order_catalog_code=<%=order_catalog_code%>&oper_stn_id=<%=oper_stn_id%>&alcn_criteria=<%=alcn_criteria%>&visit_limit_rule=<%=visit_limit_rule%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&rd_appt_yn=<%=rd_appt_yn%>' frameborder=no noresize scrolling=auto> <!--rd_appt_yn included for the incident 40965-->
			</frameset>			
</frameset>	
</html>
