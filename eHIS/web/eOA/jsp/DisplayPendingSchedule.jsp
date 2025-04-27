<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
   <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%	
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

		String clinic_code=(String)request.getParameter("clinic_code");
		String practitioner_id=(String)request.getParameter("practitioner_id");
		String Date=(String)request.getParameter("Date");

		String ca_mode=(String)request.getParameter("ca_mode");
		String ca_patient_id=(String)request.getParameter("ca_patient_id");
		//Added for getting value for Calling Mode 
		String callingMode = request.getParameter("callingMode");
		String title=request.getParameter("title");

		String clinic_type=request.getParameter("clinic_type");
		String res_type=request.getParameter("res_type");
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
		String install_yn_val=request.getParameter("install_yn_val")==null?"":request.getParameter("install_yn_val");
		String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String book_appt_yn=request.getParameter("book_appt_yn")==null?"":request.getParameter("book_appt_yn");
		String create_wait_list_yn=request.getParameter("create_wait_list_yn")==null?"":request.getParameter("create_wait_list_yn");
%>
<html>
<title><%=title%></title>
<iframe name='images12' id='images12' src='../../eOA/jsp/DisplayPendingOrders.jsp?clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&ca_mode=<%=ca_mode%>&ca_patient_id=<%=ca_patient_id%>&callingMode=<%=callingMode%>&Date=<%=Date%>&install_yn_val=<%=install_yn_val%>&oper_stn_id=<%=oper_stn_id%>&book_appt_yn=<%=book_appt_yn%>&create_wait_list_yn=<%=create_wait_list_yn%>' frameborder='0' scrolling=no noresize style='height:4vh;width:100vw'></iframe>
	<iframe name='queries' id='queries'src='../../eOR/jsp/PendingOrdersSchedule.jsp?' frameborder='0' scrolling=no noresize style='height:96vh;width:100vw'></iframe>


	
</html>

