<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="patInstructionsMap" class="java.util.HashMap" scope="session"/>
<jsp:useBean id="prcInstructionMap" class="java.util.HashMap" scope="session"/>
<% 
	Connection conn = null;
	Statement stmt=null;
	ResultSet  rs=null;
	PreparedStatement pstmt=null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	try{
		conn = ConnectionManager.getConnection(request);
		String apptdate= request.getParameter("i_appt_date");
		String day_show="";
		String locale = (String)session.getAttribute("LOCALE");
%>
<html>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	stmt = conn.createStatement();


	if (apptdate!=""){
		//String sql ="select to_char(to_date('"+apptdate+"','dd/mm/yyyy'),'Day')appt_date from dual";
		String sql ="select to_char(to_date(?,'dd/mm/yyyy'),'Day')appt_date from dual";
	   // rs=stmt.executeQuery(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,apptdate);
		rs = pstmt.executeQuery();
		rs.next();
		String day_val= rs.getString("appt_date");
		day_val=day_val.trim();
		if(day_val.equals("Sunday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(day_val.equals("Monday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(day_val.equals("Tuesday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(day_val.equals("Wednesday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(day_val.equals("Thursday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(day_val.equals("Friday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(day_val.equals("Saturday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}
		String apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
%>
	<head><title><fmt:message key="eOA.BookAppointmentfor.label" bundle="${oa_labels}"/> <%=apptdate_display%> <%=day_show%></title></head><%
	}else{	
%><head><title><fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/></title></head><%
	}
	String patientid=request.getParameter("i_patient_id");
	String clinicname=request.getParameter("i_clinic_name");
	if (clinicname==null) clinicname ="";
	//clinicname = java.net.URLEncoder.encode(clinicname);
	String cliniccode=request.getParameter("i_clinic_code");
	if (cliniccode==null) cliniccode ="";
	String practid=request.getParameter("i_practitioner_id");
	String practname=request.getParameter("i_practitioner_name");
	if (practname==null) practname="";
	//practname = java.net.URLEncoder.encode(practname);
	String fromtime=request.getParameter("i_from_time");
	String totime=request.getParameter("i_to_time");
	String overbookedyn=request.getParameter("i_over_booked");
	String timetableyn=request.getParameter("i_time_table_type");
	String book_appt_yn = request.getParameter("book_appt_yn");
	String book_appt_wo_pid_yn = request.getParameter("book_appt_wo_pid_yn");
	String obook_appt_yn = request.getParameter("obook_appt_yn");
	String book_appt_across_catg_yn = request.getParameter("book_appt_across_catg_yn");
	String tfr_appt_yn = request.getParameter("tfr_appt_yn");
	String tfr_appt_across_catg_yn = request.getParameter("tfr_appt_across_catg_yn");
	String canc_appt_yn = request.getParameter("canc_appt_yn");
	String ca_patient_id=request.getParameter("ca_patient_id");
	if(ca_patient_id==null) ca_patient_id="";
	String Forced=request.getParameter("Forced");
	String Global=request.getParameter("Global");
	String block_break_appt=request.getParameter("block_break_appt");
	String clinic_type=request.getParameter("clinic_type");
	String res_type=request.getParameter("res_type");
	String or_catalogue_code=request.getParameter("or_catalogue_code");
	String order_id=request.getParameter("order_id");
	String order_line_num=request.getParameter("order_line_num");
	String order_catalog_code=request.getParameter("order_catalog_code");
	if(order_catalog_code==null) order_catalog_code="";
	if (clinic_type==null) clinic_type = "C";
	if (res_type==null) res_type = "P";
	String create_wait_list_yn=request.getParameter("create_wait_list_yn");
	if(create_wait_list_yn ==null) create_wait_list_yn="";
	String obvisit_flag=request.getParameter("obvisit_flag");
	if(obvisit_flag==null) obvisit_flag="";
	//Added by Suman for sql tuning
	String alcn_criteria=request.getParameter("alcn_criteria");
	if(alcn_criteria ==null) alcn_criteria="";

	String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
	if(slot_appt_ctrl ==null) slot_appt_ctrl="";

	String visit_limit_rule =request.getParameter("visit_limit_rule");
	if(visit_limit_rule ==null) visit_limit_rule="";

	String oper_stn_id=request.getParameter("oper_stn_id");
	if(oper_stn_id ==null) oper_stn_id="";

	String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn");
	if(override_no_of_slots_yn ==null) override_no_of_slots_yn="";	
	//MR by suman 
	String req_id=request.getParameter("req_id");
	if(req_id ==null) req_id="";
	//ends hre
	String visit_flag_OP=request.getParameter("visit_flag_OP");
	if(visit_flag_OP==null) visit_flag_OP="N";
	String from_page=request.getParameter("from_page");
	if(from_page ==null) from_page="";

	String from_page1=request.getParameter("from_page1");
	if(from_page1 ==null) from_page1="";
	String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn");

	String apptrefno=request.getParameter("apptrefno");
	if(apptrefno ==null) apptrefno="";

	String visit_type_ind=request.getParameter("visit_type_ind");
	if(visit_type_ind ==null) visit_type_ind="";
	String referral_id=request.getParameter("referral_id");
	if(referral_id ==null) referral_id="";
	String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic");
	if(noshow_ctrl_by_splty_or_clinic ==null) noshow_ctrl_by_splty_or_clinic="";
	String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day");
	if(min_ela_per_resc_noshow_in_day ==null) min_ela_per_resc_noshow_in_day="";

	String contact_num_reqd_yn= request.getParameter("contact_num_reqd_yn");
	if(contact_num_reqd_yn ==null) contact_num_reqd_yn="N";
	//OPCheckout
	String from_facility_id= request.getParameter("from_facility_id");
	if(from_facility_id ==null) from_facility_id="";
	String from_encounter_id= request.getParameter("from_encounter_id");
	if(from_encounter_id ==null) from_encounter_id="";

	String no_of_noshow_appts_for_alert =  request.getParameter("no_of_noshow_appts_for_alert");
	if(no_of_noshow_appts_for_alert ==null) no_of_noshow_appts_for_alert="";

	String per_chk_for_no_show_alert    =   request.getParameter("per_chk_for_no_show_alert");
	if(per_chk_for_no_show_alert ==null) per_chk_for_no_show_alert="";
	//Changes for Rutnin CRF Starts
	String rule_based_tr	= checkForNull(request.getParameter("rule_based_tr"),"N");
	String rule_appl_yn		= checkForNull(request.getParameter("rule_appl_yn"),"N");
	String patient_id_temp	= checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix_temp	= checkForNull(request.getParameter("name_prefix_temp"));
	String first_name_temp	= checkForNull(request.getParameter("first_name_temp"));
	String second_name_temp	= checkForNull(request.getParameter("second_name_temp"));
	String third_name_temp	= checkForNull(request.getParameter("third_name_temp"));
	String family_name_temp	= checkForNull(request.getParameter("family_name_temp"));
	String name_suffix_temp	= checkForNull(request.getParameter("name_suffix_temp"));

	String name_prefix_oth_lang_temp	= checkForNull(request.getParameter("name_prefix_oth_lang_temp"));
	String first_name_oth_lang_temp		= checkForNull(request.getParameter("first_name_oth_lang_temp"));
	String second_name_oth_lang_temp	= checkForNull(request.getParameter("second_name_oth_lang_temp"));
	String third_name_oth_lang_temp		= checkForNull(request.getParameter("third_name_oth_lang_temp"));
	String family_name_oth_lang_temp	= checkForNull(request.getParameter("family_name_oth_lang_temp"));
	String name_suffix_oth_lang_temp	= checkForNull(request.getParameter("name_suffix_oth_lang_temp"));
	String gender_temp		= checkForNull(request.getParameter("gender_temp"));
	String contact_no_temp	= checkForNull(request.getParameter("contact_no_temp"));
	String prefPractYN		= checkForNull(request.getParameter("prefPractYN"));
	String nationality_code_temp	= checkForNull(request.getParameter("nationality_code_temp"));
	String language_code_temp	= checkForNull(request.getParameter("language_code_temp"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String linking_code			= checkForNull(request.getParameter("linking_code")); 
	String wtListControl			= checkForNull(request.getParameter("wtListControl"));
	String waitListNo			= checkForNull(request.getParameter("waitListNo"));	
	String canldapptrefno			= checkForNull(request.getParameter("canldapptrefno"));	
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
	
	//System.out.println("name_suffix_temp BookAppointment.jsp:"+name_suffix_temp);
	%>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eOA/jsp/AddModifyBookAppointment.jsp?clinic_code=<%=cliniccode%>&i_practitioner_id=<%=practid%>&i_appt_date=<%=apptdate%>&i_from_time=<%=fromtime%>&i_to_time=<%=totime%>&i_over_booked=<%=overbookedyn%>&i_time_table_type=<%=timetableyn%>&book_appt_wo_pid_yn=<%=book_appt_wo_pid_yn%>&book_appt_yn=<%=book_appt_yn%>&book_appt_across_catg_yn=<%=book_appt_across_catg_yn%>&obook_appt_yn=<%=obook_appt_yn%>&tfr_appt_yn=<%=tfr_appt_yn%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&canc_appt_yn=<%=canc_appt_yn%>&ca_patient_id=<%=ca_patient_id%>&alcn_criteria=<%=alcn_criteria%>&obvisit_flag=<%=obvisit_flag%>&Forced=<%=Forced%>&Global=<%=Global%>&block_break_appt=<%=block_break_appt%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&or_catalogue_code=<%=or_catalogue_code%>&order_line_num=<%=order_line_num%>&order_id=<%=order_id%>&order_catalog_code=<%=order_catalog_code%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&visit_limit_rule=<%=visit_limit_rule%>&oper_stn_id=<%=oper_stn_id%>&override_no_of_slots_yn=<%=override_no_of_slots_yn%>&req_id=<%=req_id%>&create_wait_list_yn=<%=create_wait_list_yn%>&visit_flag_OP=<%=visit_flag_OP%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&from_page=<%=from_page%>&apptrefno=<%=apptrefno%>&visit_type_ind=<%=visit_type_ind%>&referral_id=<%=referral_id%>&from_page1=<%=from_page1%>&noshow_ctrl_by_splty_or_clinic=<%=noshow_ctrl_by_splty_or_clinic%>&min_ela_per_resc_noshow_in_day=<%=min_ela_per_resc_noshow_in_day%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&rule_appl_yn=<%=rule_appl_yn%>&rule_based_tr=<%=rule_based_tr%>&patient_id_temp=<%=patient_id_temp%>&name_prefix_temp=<%=name_prefix_temp%>&first_name_temp=<%=first_name_temp%>&second_name_temp=<%=second_name_temp%>&third_name_temp=<%=third_name_temp%>&family_name_temp=<%=family_name_temp%>&name_suffix_temp=<%=name_suffix_temp%>&name_prefix_oth_lang_temp=<%=name_prefix_oth_lang_temp%>&first_name_oth_lang_temp=<%=first_name_oth_lang_temp%>&second_name_oth_lang_temp=<%=second_name_oth_lang_temp%>&third_name_oth_lang_temp=<%=third_name_oth_lang_temp%>&family_name_oth_lang_temp=<%=family_name_oth_lang_temp%>&name_suffix_oth_lang_temp=<%=name_suffix_oth_lang_temp%>&gender_temp=<%=gender_temp%>&contact_no_temp=<%=contact_no_temp%>&prefPractYN=<%=prefPractYN%>&nationality_code_temp=<%=nationality_code_temp%>&language_code_temp=<%=language_code_temp%>&term_set_id=<%=term_set_id%>&linking_code=<%=linking_code%>&wtListControl=<%=wtListControl%>&waitListNo=<%=waitListNo%>&canldapptrefno=<%=canldapptrefno%>&rd_appt_yn=<%=rd_appt_yn%>"  scrolling='auto' marginheight='0' marginwidth='0' frameborder='0' style='height:85vh;width:100vw'></iframe>
	<iframe name='SecondaryFrame' id='SecondaryFrame'  src='../../eCommon/html/blank.html' noresize scrolling='auto' marginheight='0' marginwidth='0' style='height:0vh;width:100vw' frameborder='0' ></iframe>
	<iframe name='ButtonFrame' id='ButtonFrame'  src='../../eOA/jsp/BookApptButtons.jsp?fromPage=BookAppointment&patientid=<%=patientid%>&from_page=<%=from_page%>&contact_num_reqd_yn=<%=contact_num_reqd_yn%>' noresize scrolling='no' marginheight='0' marginwidth='0' style='height:0vh;width:100vw' frameborder='0' ></iframe>
	<iframe name='messageFrame' id='messageFrame'  src='../../eCommon/jsp/error.jsp' noresize scrolling='auto' marginheight='0' marginwidth='0' style='height:0vh;width:100vw' frameborder='0' ></iframe>
	<iframe name='SubmitFrame' id='SubmitFrame'  src='../../eCommon/jsp/error.jsp'  noresize scrolling='auto' marginheight='0' marginwidth='0' style='height:0vh;width:100vw' frameborder='0' ></iframe></html>
<%
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}catch(Exception e){
	e.printStackTrace();
	//out.println(e);
}finally{
	ConnectionManager.returnConnection(conn,request);
}
%>
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


