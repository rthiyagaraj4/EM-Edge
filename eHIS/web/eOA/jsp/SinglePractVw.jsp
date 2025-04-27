<!DOCTYPE html>

<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>

<%	    // Modified for CRF - SRR -0425 -- Order Catalog.

 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
		String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
		String inv_visit_mpq_from_ca_yn=request.getParameter("inv_visit_mpq_from_ca_yn");
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id== null) oper_stn_id="";
		String alcn_criteria=request.getParameter("alcn_criteria");
		if(alcn_criteria == null) alcn_criteria="";
		String visit_limit_rule=request.getParameter("visit_limit_rule");
		if(visit_limit_rule == null) visit_limit_rule="";
		String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
		if(slot_appt_ctrl== null) slot_appt_ctrl="";
		String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn");
		if(override_no_of_slots_yn ==null) override_no_of_slots_yn="";

		String mode_find=request.getParameter("mode_find");
		String clinic_code=(String)request.getParameter("clinic_code");
		String practitioner_id=(String)request.getParameter("practitioner_id");
		String value12=(String)request.getParameter("value12");
		if(value12 ==null) value12="";
		String value13=(String)request.getParameter("value13");

		String Date=(String)request.getParameter("Date");
		
		String old_date=(String)request.getParameter("old_date");
		if(old_date  == null || old_date.equals("null")) old_date="";
        
		String decide=(String)request.getParameter("decide");
		String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
		if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";

		String old_from_time = request.getParameter("old_from_time");
		if( old_from_time == null) old_from_time="";

		String old_to_time = request.getParameter("old_to_time");
		if( old_to_time == null) old_to_time="";

		String valid_date = request.getParameter("valid_date");
		if(( valid_date == null) || valid_date.equals(""))  valid_date=Date;
		

		String ca_mode = request.getParameter("ca_mode");
		if(( ca_mode == null) || ca_mode.equals(""))  ca_mode="";

		String ca_patient_id=request.getParameter("ca_patient_id");
		if(ca_patient_id==null) ca_patient_id="";

		String FromApptForPractQry = request.getParameter("FromApptForPractQry");
		if(FromApptForPractQry == null || FromApptForPractQry.equals(""))
		FromApptForPractQry = "NO";
		String callingMode = request.getParameter("callingMode");
		String order_id=request.getParameter("order_id");
		if(order_id ==null) order_id="";
		String order_line_num=request.getParameter("order_line_num");
		if(order_line_num ==null) order_line_num="";
			String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";
		String clinic_type=request.getParameter("clinic_type");
		String res_type=request.getParameter("res_type");

		if (clinic_type==null) clinic_type = "C";
		if (res_type==null) res_type = "P";
		if (order_catalog_code ==null) order_catalog_code="";
		if (callingMode==null) callingMode = "";
		String install_yn_val=request.getParameter("install_yn_val");
			if(install_yn_val ==null) install_yn_val="N";
		String visit_flag_OP=request.getParameter("visit_flag_OP");
			if(visit_flag_OP==null) visit_flag_OP="N";

		String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn");
 String from_page=request.getParameter("from_page");
if(from_page ==null) from_page="";
		
String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day");
if(min_ela_per_resc_noshow_in_day ==null) min_ela_per_resc_noshow_in_day="";

String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic");
if(noshow_ctrl_by_splty_or_clinic ==null ) noshow_ctrl_by_splty_or_clinic="";

String contact_num_reqd_yn= request.getParameter("contact_num_reqd_yn");
		if(contact_num_reqd_yn ==null) contact_num_reqd_yn="";

//Added by suman for getting the value from OP Checkout
		
	String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";
	
 String no_of_noshow_appts_for_alert =  request.getParameter("no_of_noshow_appts_for_alert");
  if(no_of_noshow_appts_for_alert ==null) no_of_noshow_appts_for_alert="";

String per_chk_for_no_show_alert    =   request.getParameter("per_chk_for_no_show_alert");
 if(per_chk_for_no_show_alert ==null) per_chk_for_no_show_alert="";

 	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
	String wtListControl=request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");
	String waitListNo=request.getParameter("waitListNo")==null?"":request.getParameter("waitListNo");
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");

if(ca_mode.equals("ca_mode")){%>
<html>
<head>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

	<iframe name='image34' id='image34' src="../../eOA/jsp/DisplayDate.jsp?clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&Date=<%=Date%>&value12=<%=value12%>&callingMode=<%=callingMode%>&value13=<%=value13%>&valid_date=<%=valid_date%>&old_date=<%=old_date%>&decide=<%=decide%>&old_from_time=<%=old_from_time%>&old_to_time=<%=old_to_time%>&pre_pat_alcn_catg_code=<%=pre_pat_alcn_catg_code%>&mode_find=<%=mode_find%>&ca_mode=<%=ca_mode%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&oper_stn_id=	<%=oper_stn_id%>&alcn_criteria=<%=alcn_criteria%>&visit_limit_rule=<%=visit_limit_rule%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&slot_appt_ctrl=<%=slot_appt_ctrl%>	&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&inv_visit_mpq_from_ca_yn=<%=inv_visit_mpq_from_ca_yn%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&order_catalog_code=<%=order_catalog_code%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&position=<%=position%>&addtl_splty=<%=addtl_splty%>&wtListControl=<%=wtListControl%>&rd_appt_yn=<%=rd_appt_yn%>" frameborder=no scrolling=no noresize style='height:11vh;width:100vw'></iframe>
	<!-- <frame name='query' id='query' src='../../eOA/jsp/DisplayLabels.jsp?clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&Date=<%=Date%>&decide=<%=decide%>&&value12=<%=value12%>&callingMode=<%=callingMode%>&value13=<%=value13%>&decide=<%=decide%>&mode_find=<%=mode_find%>&ca_mode=<%=ca_mode%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&or_catalogue_code=<%=or_catalogue_code%>&oper_stn_id=<%=oper_stn_id%>&alcn_criteria=<%=alcn_criteria%>&visit_limit_rule=<%=visit_limit_rule%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>' frameborder=auto scrolling=no noresize> -->
	<iframe name='result' id='result' src="../../eOA/jsp/DisplayResults.jsp?order_catalog_code=<%=order_catalog_code%>&clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&Date=<%=Date%>&value12=<%=value12%>&callingMode=<%=callingMode%>&value13=<%=value13%>&old_date=<%=old_date%>&decide=<%=decide%>&old_from_time=<%=old_from_time%>&pre_pat_alcn_catg_code=<%=pre_pat_alcn_catg_code%>&old_to_time=<%=old_to_time%>&mode_find=<%=mode_find%>&ca_mode=<%=ca_mode%>&ca_patient_id=<%=ca_patient_id%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&oper_stn_id=<%=oper_stn_id%>&alcn_criteria=<%=alcn_criteria%>&visit_limit_rule=<%=visit_limit_rule%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&inv_visit_mpq_from_ca_yn=<%=inv_visit_mpq_from_ca_yn%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&position=<%=position%>&addtl_splty=<%=addtl_splty%>&wtListControl=<%=wtListControl%>&waitListNo=<%=waitListNo%>&rd_appt_yn=<%=rd_appt_yn%>" frameborder='no' noresize scrolling='auto' style='height:85vh;width:100vw'></iframe>
	<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html'  frameborder=0 scrolling='no' style='height:4vh;width:100vw'></iframe>


<%
}else{ 
%>
<html>
<head>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<%

	if(FromApptForPractQry.equals("YES")) {%>
		
	<%}else{%>
			<iframe name='image34' id='image34' src='../../eOA/jsp/DisplayDate.jsp?clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&Date=<%=Date%>&value12=<%=value12%>&value13=<%=value13%>&valid_date=<%=valid_date%>&old_date=<%=old_date%>&decide=<%=decide%>&old_from_time=<%=old_from_time%>&callingMode=<%=callingMode%>&old_to_time=<%=old_to_time%>&pre_pat_alcn_catg_code=<%=pre_pat_alcn_catg_code%>&mode_find=<%=mode_find%>&ca_mode=<%=ca_mode%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&oper_stn_id=<%=oper_stn_id%>&alcn_criteria=<%=alcn_criteria%>&visit_limit_rule=<%=visit_limit_rule%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&inv_visit_mpq_from_ca_yn=<%=inv_visit_mpq_from_ca_yn%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&or_catalogue_code=<%=or_catalogue_code%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&position=<%=position%>&addtl_splty=<%=addtl_splty%>&rd_appt_yn=<%=rd_appt_yn%>' frameborder=no scrolling=no noresize style='height:5vh;width:100vw' ></iframe>
	<%}
	
	if(FromApptForPractQry.equals("NO")) {%>
		<iframe name='result' id='result' src='../../eOA/jsp/DisplayResults.jsp?order_catalog_code=<%=order_catalog_code%>&clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&Date=<%=valid_date%>&value12=<%=value12%>&value13=<%=value13%>&old_date=<%=old_date%>&decide=<%=decide%>&old_from_time=<%=old_from_time%>&pre_pat_alcn_catg_code=<%=pre_pat_alcn_catg_code%>&old_to_time=<%=old_to_time%>&mode_find=<%=mode_find%>&callingMode=<%=callingMode%>&ca_patient_id=<%=ca_patient_id%>&ca_mode=<%=ca_mode%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&oper_stn_id=<%=oper_stn_id%>&alcn_criteria=<%=alcn_criteria%>&visit_limit_rule=<%=visit_limit_rule%>		&slot_appt_ctrl=<%=slot_appt_ctrl%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&inv_visit_mpq_from_ca_yn=<%=inv_visit_mpq_from_ca_yn%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&position=<%=position%>&addtl_splty=<%=addtl_splty%>&rd_appt_yn=<%=rd_appt_yn%>' frameborder='no' noresize scrolling='auto' style='height:85vh;width:100vw'></iframe>
		<iframe name='checkbox' id='checkbox' src='../../eOA/jsp/BrownCheckBoxDisplay.jsp'  frameborder=0 scrolling='no' style='height:10vh;width:100vw'></iframe>
	
	<%}else{
		if((!clinic_code.equals("")) && (!clinic_code.equals(null))&&(!practitioner_id.equals("")) &&(! practitioner_id.equals("null"))){%>
			<iframe name='result' id='result' src='../../eOA/jsp/DisplayResults.jsp?order_catalog_code=<%=order_catalog_code%>&clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&Date=<%=valid_date%>&value12=<%=value12%>&value13=<%=value13%>&old_date=<%=old_date%>&decide=<%=decide%>&old_from_time=<%=old_from_time%>&pre_pat_alcn_catg_code=<%=pre_pat_alcn_catg_code%>&old_to_time=<%=old_to_time%>&mode_find=<%=mode_find%>&callingMode=<%=callingMode%>&ca_patient_id=<%=ca_patient_id%>&ca_mode=<%=ca_mode%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&oper_stn_id=<%=oper_stn_id%>&alcn_criteria=<%=alcn_criteria%>&visit_limit_rule=<%=visit_limit_rule%>		&slot_appt_ctrl=<%=slot_appt_ctrl%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&inv_visit_mpq_from_ca_yn=<%=inv_visit_mpq_from_ca_yn%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&position=<%=position%>&addtl_splty=<%=addtl_splty%>&rd_appt_yn=<%=rd_appt_yn%>' frameborder='no' noresize scrolling='auto' style='height:85vh;width:100vw'></iframe>
			<iframe name='checkbox' id='checkbox' src='../../eOA/jsp/BrownCheckBoxDisplay.jsp'  frameborder=0 scrolling='no' style='height:10vh;width:100vw'></iframe>
		<%}else{%>
			<iframe name='result' id='result' src="../../eOA/jsp/displayApptResults.jsp?&clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&Date=<%=Date%>&decide=<%=decide%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&oper_stn_id=<%=oper_stn_id%>&from_page=<%=from_page%>" frameborder='no' noresize style='height:85vh;width:97vw'></iframe>
		
		<%}
	}%>
		
	<%
	}
	%>
	
</html>

