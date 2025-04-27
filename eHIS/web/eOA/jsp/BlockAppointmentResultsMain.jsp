<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String date=(String)request.getParameter("Date");

	String clinic_code=(String)request.getParameter("clinic_code");
	String practitioner_id=(String)request.getParameter("practitioner_id");
	String value12=(String)request.getParameter("value12");
	if( value12 == null || value12.equals("null")) value12="";
	String value13=(String)request.getParameter("value13");
	if( value13 == null || value13.equals("null"))  value12="";
	String anchor=(String)request.getParameter("anchor");
	if( anchor == null || anchor.equals("null"))  anchor="";

	String to_anchor=(String)request.getParameter("to_anchor");
	if( to_anchor == null || to_anchor.equals("null"))  to_anchor="";

String clinic_type=request.getParameter("clinic_type");
String res_type=request.getParameter("res_type");

if (clinic_type==null) clinic_type = "C";
if (res_type==null) res_type = "P";
String slot_appt_ctrl  =request.getParameter("slot_appt_ctrl");
String visit_limit_rule=request.getParameter("visit_limit_rule");
String sys_date  =request.getParameter("sys_date");
String sys_time=request.getParameter("sys_time");
%>
<html>
<head>




<script language='javascript' src='../../eOA/js/Blockapptslots.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='results' id='results' src='../../eOA/jsp/BlockAppointmentResults.jsp?clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&Date=<%=date%>&anchor=set&to_anchor=no&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&visit_limit_rule=<%=visit_limit_rule%>&sys_date=<%=sys_date%>&sys_time=<%=sys_time%>'  scrolling='auto' style='height:87vh;width:98vw' frameborder='0'></iframe>
<iframe name='reset' id='reset' src='../../eOA/jsp/BlockAppointmentReset.jsp?clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&Date=<%=date%>&anchor=set&to_anchor=no&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>'   scrolling='auto' style='height:6vh;width:98vw' frameborder='0'></iframe>
</html>




