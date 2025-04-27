<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");	%><%
	String facility_id = (String)session.getValue("facility_id");
	String slate_user_id	= request.getParameter("slate_user_id");
	String booking_num		= request.getParameter("booking_num");	
	if(facility_id == null) facility_id="";
	if(slate_user_id == null) slate_user_id="";
	if(booking_num == null) booking_num="";

    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
%>
<html>
<head><title></title>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
<script src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eOT/js/OtReports.js" ></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='JavaScript' src='../../eCommon/js/messages.js'></script>
<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<input type="hidden" name="facility_id" id="facility_id"		value="<%=facility_id%>" >
	<input type="hidden" name="p_user_id" id="p_user_id"		value="<%=slate_user_id%>" >
	<input type="hidden" name="p_booking_num" id="p_booking_num"	value="<%=booking_num%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="OT" >
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="OTRCSLIP" >
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
<!-- <input type="hidden" name="self_submit" id="self_submit"     value="yes">     
     <input type="hidden" name="report_option" id="report_option"   value="P">	   
     <input type="hidden" name="destype" id="destype"   value="P">	   	-->
</form>
</body>
</html>
<script>
	CaseSlipRun();
</script>

