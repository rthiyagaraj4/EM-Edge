<!DOCTYPE html>
    <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>


 
	<html>
	<head><title><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></title></head>

	<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String apptrefno=request.getParameter("i_appt_ref_no");
	
	String transfer=request.getParameter("transfer");
	if(transfer == null)transfer="";
	String i_from_time=request.getParameter("i_from_time");
	if(i_from_time == null) i_from_time="";
	String i_to_time=request.getParameter("i_to_time");
	if(i_to_time == null) i_to_time="";
	String value13=request.getParameter("value13");
	if(value13 == null) value13="";
	String i_clinic_code=request.getParameter("i_clinic_code");
	
	String i_practitioner_id=request.getParameter("i_practitioner_id");


	
	String i_appt_date=request.getParameter("i_appt_date");
	if(i_appt_date ==null) i_appt_date="";
	String over_booked=request.getParameter("over_booked");
	if(over_booked == null) over_booked="";
	String i_time_table_type=request.getParameter("i_time_table_type");
	if(i_time_table_type == null) i_time_table_type="";
	
	String old_date=(String)request.getParameter("old_date");
	if(old_date  == null || old_date.equals("null")) old_date="";
	
	String flag=(String)request.getParameter("flag");
	if(flag == null || flag.equals("null")) flag="";
	String pre_pat_alcn_catg_code= request.getParameter("pre_pat_alcn_catg_code");
	if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";


	String old_from_time = request.getParameter("old_from_time");
	if( old_from_time == null) old_from_time="";
	
	String old_to_time = request.getParameter("old_to_time");
	if( old_to_time == null) old_to_time="";
	String book_appt_wo_pid_yn = request.getParameter("book_appt_wo_pid_yn");
	String obook_appt_yn = request.getParameter("obook_appt_yn");
	String tfr_appt_yn = request.getParameter("tfr_appt_yn");
	String tfr_appt_across_catg_yn = request.getParameter("tfr_appt_across_catg_yn");
	String canc_appt_yn = request.getParameter("canc_appt_yn");
	String alcn_criteria = request.getParameter("alcn_criteria");
	String call_function_ip = request.getParameter("call_function");
	if(call_function_ip==null) call_function_ip="";
	String Forced=request.getParameter("Forced");
	String calling_mode=request.getParameter("calling_mode");
	if(calling_mode== null) calling_mode="";
	String clinic_type=request.getParameter("clinic_type");
	String res_type=request.getParameter("res_type");
	String performing_facility_id=request.getParameter("performing_facility_id");
	String from_page=request.getParameter("from_page");
	String wtListControl			= request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");
	
	//added forBru-HIMS-CRF-380 Start
	String facility_id	= request.getParameter("FacilityId") ;
	if(facility_id==null)
		facility_id = (String) session.getValue("facility_id");
	//added forBru-HIMS-CRF-380 End
	
	
	
	if (clinic_type==null) clinic_type = "C";
	if (res_type==null) res_type = "P";
	if (performing_facility_id==null) performing_facility_id = "";
	out.println("<iframe name='f_apptdetails' id='f_apptdetails' src='../../eOA/jsp/AddModifyAppointmentDetails.jsp?i_appt_ref_no="+apptrefno+"&transfer="+transfer+"&i_from_time="+i_from_time+"&i_to_time="+i_to_time+"&value13="+value13+"&i_clinic_code="+i_clinic_code+"&i_practitioner_id="+i_practitioner_id+"&i_appt_date="+i_appt_date+"&over_booked="+over_booked+"&i_time_table_type="+i_time_table_type+"&old_date="+old_date+"&flag="+flag+"&old_from_time="+old_from_time+"&old_to_time="+old_to_time+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&pre_pat_alcn_catg_code="+pre_pat_alcn_catg_code+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&Forced="+Forced+"&clinic_type="+clinic_type+"&res_type="+res_type+"&calling_mode="+calling_mode+"&from_page="+from_page+"&call_function_ip="+call_function_ip+"&performing_facility_id="+performing_facility_id+"&wtListControl="+wtListControl+"&facility_id="+facility_id+"'  frameborder='0'  scrolling='no' marginheight='0' marginwidth='0' style='height:100vh;width:97vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' marginheight='0' marginwidth='0' style='height:0vh;width:97vw'></iframe>");
	out.println("</html>");
%>


