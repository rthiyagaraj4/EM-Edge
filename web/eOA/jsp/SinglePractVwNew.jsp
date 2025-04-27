<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%	
    // Modified for CRF - SRR -0425 -- Order Catalog.
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		String clinic_code=(String)request.getParameter("clinic_code");
		String practitioner_id=(String)request.getParameter("practitioner_id");
		String Date=(String)request.getParameter("Date");
		String decide=(String)request.getParameter("decide");
		String ca_mode=(String)request.getParameter("ca_mode");
		String ca_patient_id=(String)request.getParameter("ca_patient_id");
		//Added for getting value for Calling Mode 
		String callingMode = request.getParameter("callingMode");
		//String title=request.getParameter("title");
		String create_wait_list_yn=request.getParameter("create_wait_list_yn");
		if(create_wait_list_yn ==null) create_wait_list_yn="";
		String clinic_type=request.getParameter("clinic_type");
		String res_type=request.getParameter("res_type");
		String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
		String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
		String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id== null) oper_stn_id="";
		//String clinic_alcn="";
		//String clinic_alcn_sql="select alcn_criteria from oa_clinic_schedule where CLINIC_CODE='"+clinic_code+"' AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', NVL (practitioner_id, 'X')) and clinic_date=to_date('"+Date+"','dd/mm/yyyy')";

		if (clinic_type==null) clinic_type = "C";
		if (res_type==null) res_type = "P";

		if (callingMode==null) callingMode = "";
		//Added by Suman regd Sql tuning	
		String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
		if(slot_appt_ctrl == null) slot_appt_ctrl="";
		String visit_limit_rule=request.getParameter("visit_limit_rule");
		if(visit_limit_rule== null) visit_limit_rule="";
		String alcn_criteria=request.getParameter("alcn_criteria");
		if(alcn_criteria ==null) alcn_criteria="";
		String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn");
		if(override_no_of_slots_yn==null)override_no_of_slots_yn="";
		// End of the addition	

		//MR by suman 
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
		String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="N";
		String from_OR=request.getParameter("from_OR");
		if(from_OR ==null)from_OR="N";
		String visit_flag_OP=request.getParameter("visit_flag_OP");
		if(visit_flag_OP==null) visit_flag_OP="N";	

		String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn");
		if(capture_fin_dtls_yn ==null) capture_fin_dtls_yn="";
		String speciality=request.getParameter("speciality");
		if(speciality ==null) speciality="";
		String clinic_old=request.getParameter("clinic_old");
		if(clinic_old ==null) clinic_old="";
		String practitioner_old=request.getParameter("practitioner_old");
		if(practitioner_old ==null) practitioner_old="";
		String practitioner_type=request.getParameter("practitioner_type");
		if(practitioner_type ==null) practitioner_type="";
	//	String or_catalogue_code=request.getParameter("or_catalogue_code");
	//	if(or_catalogue_code ==null) or_catalogue_code="";
		String pref_start_date=request.getParameter("pref_start_date");
		if(pref_start_date ==null) pref_start_date="";
		String pref_end_date=request.getParameter("pref_end_date");
		if(pref_end_date ==null) pref_end_date="";
		String no_dwm=request.getParameter("no_dwm");
		if(no_dwm ==null) no_dwm="";
		String visittype=(String)request.getParameter("visittype");
		if(visittype == null || visittype.equals("null")) visittype ="";
		String dwm_desc=request.getParameter("dwm_desc");
if(dwm_desc ==null) dwm_desc="";
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

 String calledFrom    =   request.getParameter("calledFrom"); //Added by Sathish.S for IN020026 on Monday, March 22, 2010
 if(calledFrom ==null) calledFrom="";

 	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
	String rule_appl_yn			= checkForNull(request.getParameter("rule_appl_yn"));
	String patient_id_temp		= checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix_temp		= checkForNull(request.getParameter("name_prefix_temp"));
	String first_name_temp		= checkForNull(request.getParameter("first_name_temp"));
	String second_name_temp		= checkForNull(request.getParameter("second_name_temp"));
	String third_name_temp		= checkForNull(request.getParameter("third_name_temp"));
	String family_name_temp		= checkForNull(request.getParameter("family_name_temp"));
	String name_suffix_temp	=checkForNull(request.getParameter("name_suffix_temp"));	
	String name_prefix_oth_lang_temp	=checkForNull(request.getParameter("name_prefix_oth_lang_temp"));
	String first_name_oth_lang_temp	=checkForNull(request.getParameter("first_name_oth_lang_temp"));
	String second_name_oth_lang_temp	=checkForNull(request.getParameter("second_name_oth_lang_temp"));
	String third_name_oth_lang_temp	=checkForNull(request.getParameter("third_name_oth_lang_temp"));
	String family_name_oth_lang_temp	=checkForNull(request.getParameter("family_name_oth_lang_temp"));
	String name_suffix_oth_lang_temp	=checkForNull(request.getParameter("name_suffix_oth_lang_temp"));
	String gender_temp			= checkForNull(request.getParameter("gender_temp"));
	String contact_no_temp		= checkForNull(request.getParameter("contact_no_temp"));
	String nationality_code_temp= checkForNull(request.getParameter("nationality_code_temp"));
	String language_code_temp	= checkForNull(request.getParameter("language_code_temp"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String linking_code			= checkForNull(request.getParameter("linking_code")); 	
	String apptrefno			= checkForNull(request.getParameter("apptrefno")); 	
	
	

try{ %>
<html>
<title><fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/></title>
<iframe name='images12' id='images12' src='../../eOA/jsp/DisplayTabs.jsp?clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&ca_mode=<%=ca_mode%>&ca_patient_id=<%=ca_patient_id%>&callingMode=<%=callingMode%>&Date=<%=Date%>&install_yn_val=<%=install_yn_val%>&from_OR=<%=from_OR%>&speciality=<%=speciality%>&clinic_old=<%=clinic_old%>&practitioner_old=<%=practitioner_old%>&practitioner_type=<%=practitioner_type%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&order_catalog_code=<%=order_catalog_code%>&pref_start_date=<%=pref_start_date%>&pref_end_date=<%=pref_end_date%>&clinic_type=<%=clinic_type%>&no_dwm=<%=no_dwm%>&visittype=<%=visittype%>&dwm_desc=<%=dwm_desc%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&calledFrom=<%=calledFrom%>&position=<%=position%>&addtl_splty=<%=addtl_splty%>&rd_appt_yn=<%=rd_appt_yn%>' frameborder=no scrolling=no noresize style='height:3vh;width:100vw'></iframe>
	<iframe name='queries' id='queries'src='../../eOA/jsp/SinglePractVw.jsp?clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&ca_mode=<%=ca_mode%>&ca_patient_id=<%=ca_patient_id%>&callingMode=<%=callingMode%>&Date=<%=Date%>&decide=<%=decide%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&order_catalog_code=<%=order_catalog_code%>&oper_stn_id=<%=oper_stn_id%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&visit_limit_rule=<%=visit_limit_rule%>&alcn_criteria=<%=alcn_criteria%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&calledFrom=<%=calledFrom%>&position=<%=position%>&addtl_splty=<%=addtl_splty%>&rd_appt_yn=<%=rd_appt_yn%>' frameborder=no scrolling=no noresize style='height:97vh;width:100vw'></iframe>
	<iframe name='tempStorageFrame' id='tempStorageFrame'src="../../eOA/jsp/OATempStorage.jsp?clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&ca_mode=<%=ca_mode%>&ca_patient_id=<%=ca_patient_id%>&callingMode=<%=callingMode%>&Date=<%=Date%>&decide=<%=decide%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&order_catalog_code=<%=order_catalog_code%>&oper_stn_id=<%=oper_stn_id%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&visit_limit_rule=<%=visit_limit_rule%>&alcn_criteria=<%=alcn_criteria%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&calledFrom=<%=calledFrom%>&position=<%=position%>&addtl_splty=<%=addtl_splty%>&patient_id_temp=<%=patient_id_temp%>&name_prefix_temp=<%=name_prefix_temp%>&first_name_temp=<%=first_name_temp%>&second_name_temp=<%=second_name_temp%>&third_name_temp=<%=third_name_temp%>&family_name_temp=<%=family_name_temp%>&name_suffix_temp=<%=name_suffix_temp%>&name_prefix_oth_lang_temp=<%=name_prefix_oth_lang_temp%>&first_name_oth_lang_temp=<%=first_name_oth_lang_temp%>&second_name_oth_lang_temp=<%=second_name_oth_lang_temp%>&third_name_oth_lang_temp=<%=third_name_oth_lang_temp%>&family_name_oth_lang_temp=<%=family_name_oth_lang_temp%>&name_suffix_oth_lang_temp=<%=name_suffix_oth_lang_temp%>&gender_temp=<%=gender_temp%>&contact_no_temp=<%=contact_no_temp%>&rule_appl_yn=<%=rule_appl_yn%>&nationality_code_temp=<%=nationality_code_temp%>&language_code_temp=<%=language_code_temp%>&term_set_id=<%=term_set_id%>&linking_code=<%=linking_code%>&apptrefno=<%=apptrefno%>&rd_appt_yn=<%=rd_appt_yn%>" frameborder=no scrolling=no noresize style='height:0vh;width:100vw'></iframe>


<%
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
}catch(Exception ex){
	ex.printStackTrace();
 }finally{
	 ConnectionManager.returnConnection(con,request);
 }%>
	
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

