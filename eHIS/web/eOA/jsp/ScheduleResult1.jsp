<!DOCTYPE html>
			<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" language="java"%>


<%			
		request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			String order_catalog_code=request.getParameter("order_catalog_code");
			if(order_catalog_code==null) order_catalog_code="";
			String Date=(String)request.getParameter("Date");
			String end_date=(String)request.getParameter("end_date");
			String pref_start_date=(String)request.getParameter("pref_start_date");
			String pref_end_date=(String)request.getParameter("pref_end_date");
			String call_date_yn=(String)request.getParameter("call_date_yn");
			String clinic=(String)request.getParameter("clinic");
			String practitioner=(String)request.getParameter("practitioner");
			String practitioner_type=(String)request.getParameter("practitioner_type");
			String speciality=(String)request.getParameter("speciality");
			String disp_ear_sch=(String)request.getParameter("disp_ear_sch");			
			String visittype=(String)request.getParameter("visittype");
			String oper_stn_id=(String)request.getParameter("oper_stn_id");
			String ca_mode=(String)request.getParameter("ca_mode");
			String ca_patient_id=(String)request.getParameter("ca_patient_id");	
			String hddSpeclty=(String)request.getParameter("hddSpeclty");
			String care_locn_ind=request.getParameter("care_locn_ind");
			String res_class=request.getParameter("res_class");
			String visit_flag_OP=request.getParameter("visit_flag_OP");
			if(visit_flag_OP==null) visit_flag_OP="N";	
//Added by suman for getting the value from OP Checkout
		
	String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";

			//Added by suman for getting the value for Calling Mode and OR related values
		
			String callingMode=(String)request.getParameter("callingMode");		
			if (callingMode==null) callingMode = "";

			String calledFrom=(String)request.getParameter("calledFrom");	//Added by Sathish.S for IN020026 onMonday, March 22, 2010 
			if (calledFrom==null) calledFrom = "";
			

			String order_line_num=request.getParameter("order_line_num");
			if(order_line_num==null) order_line_num="";

			String order_id=request.getParameter("order_id");
			if(order_id ==null) order_id="";

			String or_catalogue_code=request.getParameter("or_catalogue_code");
			if(or_catalogue_code==null) or_catalogue_code="";

			String specialty_codema1=request.getParameter("specialty_codema1");
			if(specialty_codema1 ==null) specialty_codema1="";
			//ends hre
		//MR
			String req_id=request.getParameter("req_id");
			if(req_id ==null) req_id="";
			String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="N";

	String from_OR=request.getParameter("from_OR");
	if(from_OR==null) from_OR="N";
	String create_wait_list_yn=request.getParameter("create_wait_list_yn");
	if(create_wait_list_yn ==null) create_wait_list_yn="";
	String no_dwm=request.getParameter("no_dwm");
	if(no_dwm ==null) no_dwm="";
String dwm_desc=request.getParameter("dwm_desc");
if(dwm_desc ==null) dwm_desc="";
 String from_page=request.getParameter("from_page");
if(from_page ==null) from_page="";
 String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic");
 if(noshow_ctrl_by_splty_or_clinic ==null) noshow_ctrl_by_splty_or_clinic="";
 String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day");
 if(min_ela_per_resc_noshow_in_day ==null) min_ela_per_resc_noshow_in_day="";
 String position=request.getParameter("position")==null?"":request.getParameter("position");
 String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
 
 	String patient_id_temp			= checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix				= checkForNull(request.getParameter("name_prefix")); 
	String first_name				= checkForNull(request.getParameter("first_name")); 
	String second_name				= checkForNull(request.getParameter("second_name"));
	String third_name				= checkForNull(request.getParameter("third_name")); 
	String family_name				= checkForNull(request.getParameter("family_name"));
	String name_suffix				= checkForNull(request.getParameter("name_suffix")); 
	
	String name_prefix_oth_lang				= checkForNull(request.getParameter("name_prefix_oth_lang")); 
	String first_name_oth_lang				= checkForNull(request.getParameter("first_name_oth_lang")); 
	String second_name_oth_lang				= checkForNull(request.getParameter("second_name_oth_lang"));
	String third_name_oth_lang				= checkForNull(request.getParameter("third_name_oth_lang")); 
	String family_name_oth_lang				= checkForNull(request.getParameter("family_name_oth_lang"));
	String name_suffix_oth_lang				= checkForNull(request.getParameter("name_suffix_oth_lang")); 
	String gender					= checkForNull(request.getParameter("gender")); 
	String contact_no				= checkForNull(request.getParameter("contact_no"));
	String language_code_temp		= checkForNull(request.getParameter("language_code_temp")); 
	String nationality_code_temp	= checkForNull(request.getParameter("nationality_code_temp"));
	String term_set_id				= checkForNull(request.getParameter("term_set_id"));
	String linking_code				= checkForNull(request.getParameter("linking_code")); 
	String rd_appt_yn				= checkForNull(request.getParameter("rd_appt_yn")); 
	String schedule_gender				= checkForNull(request.getParameter("schedule_gender")); //Added for this CRF [Bru-HIMS-CRF-167]
%>

<!-- Below frame modified for this incident  [IN:048861]-->
<html>
	<iframe name='arrows' id='arrows' src="../../eOA/jsp/DisplayArrows.jsp?Date=<%=Date%>&end_date=<%=end_date%>" frameborder=no scrolling=no noresize style='height:9vh;width:98vw'></iframe>
	<iframe name='result1' id='result1' src="../../eOA/jsp/ScheduleResult.jsp?order_catalog_code=<%=order_catalog_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&week=no&month=yes&days=no&Date=<%=Date%>&end_date=<%=end_date%>&oper_stn_id=<%=oper_stn_id%>&clinic=<%=clinic%>&practitioner=<%=practitioner%>&practitioner_type=<%=practitioner_type%>&visittype=<%=visittype%>&speciality=<%=speciality%>&ca_patient_id=<%=ca_patient_id%>&pref_start_date=<%=pref_start_date%>&pref_end_date=<%=pref_end_date%>&call_date_yn=<%=call_date_yn%>&disp_ear_sch=<%=disp_ear_sch%>&ca_mode=<%=ca_mode%>&callingMode=<%=callingMode%>&hddSpeclty=<%=hddSpeclty%>&Difference=0&care_locn_ind=<%=care_locn_ind%>&res_class=<%=res_class%>&or_catalogue_code=<%=or_catalogue_code%>&specialty_codema1=<%=specialty_codema1%>&req_id=<%=req_id%>&install_yn_val=<%=install_yn_val%>&from_OR=<%=from_OR%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&no_dwm=<%=no_dwm%>&dwm_desc=<%=dwm_desc%>&from_page=<%=from_page%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&calledFrom=<%=calledFrom%>&position=<%=position%>&addtl_splty=<%=addtl_splty%>&patient_id_temp=<%=patient_id_temp%>&name_prefix=<%=name_prefix%>&first_name=<%=first_name%>&second_name=<%=second_name%>&third_name=<%=third_name%>&family_name=<%=family_name%>&name_suffix=<%=name_suffix%>&name_prefix_oth_lang=<%=name_prefix_oth_lang%>&first_name_oth_lang=<%=first_name_oth_lang%>&second_name_oth_lang=<%=second_name_oth_lang%>&third_name_oth_lang=<%=third_name_oth_lang%>&family_name_oth_lang=<%=family_name_oth_lang%>&name_suffix_oth_lang=<%=name_suffix_oth_lang%>&gender=<%=gender%>&contact_no=<%=contact_no%>&language_code_temp=<%=language_code_temp%>&nationality_code_temp=<%=nationality_code_temp%>&term_set_id=<%=term_set_id%>&linking_code=<%=linking_code%>&rd_appt_yn=<%=rd_appt_yn%>&schedule_gender=<%=schedule_gender%>" frameborder=no scrolling='auto' noresize style='height:67vh;width:98vw'></iframe>
	<iframe name='checkbox' id='checkbox' src='../../eOA/jsp/CheckBoxDisplay.jsp?disp_ear_sch=<%=disp_ear_sch%>'  frameborder=0 scrolling='no' style='height:14vh;width:98vw'></iframe>

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

