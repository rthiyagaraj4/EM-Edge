<!DOCTYPE html>

<%@page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=ISO-8859-1"%>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_id = (String)session.getValue("facility_id");
	String slate_user_id	= request.getParameter("slate_user_id");
	String oper_num		= request.getParameter("oper_num");	
	String patient_id		= request.getParameter("patient_id");	
	String pReportId = request.getParameter("p_report_id");
	String pNoOfSwabCount = request.getParameter("P_NO_OF_SWAB_COUNT");
	System.out.println("===pReportId==="+pReportId);
	System.out.println("===pNoOfSwabCount==="+pNoOfSwabCount);
	if(facility_id == null) facility_id="";
	if(slate_user_id == null) slate_user_id="";
	if(oper_num == null) oper_num="";
%>
<html>
<head><title></title>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
<script src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eOT/js/OtReports.js" ></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=slate_user_id%>">
	<input type="hidden" name="p_oper_num" id="p_oper_num"	value="<%=oper_num%>">
	<input type="hidden" name="p_patient_id" id="p_patient_id"	value="<%=patient_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id"	value="<%=pReportId%>">
	<input type="hidden" name="P_NO_OF_SWAB_COUNT" id="P_NO_OF_SWAB_COUNT"	value="<%=pNoOfSwabCount%>">
</form>
</body>
</html>
<script>
	CaseSlipRun();
</script>

