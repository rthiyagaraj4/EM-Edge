<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>

<%
	//String param1=request.getParameter("room_code");
	String param1=request.getParameter("paramArray_no");	
	String param2=request.getParameter("paramArray_date");
	System.err.println("======param1==== "+param1+"======param2==== "+param2);
	String strPatientId=request.getParameter("patient_id");
	String strtheatre_type=request.getParameter("theatre_type");
	String strtheatre=request.getParameter("theatre");
	String facility_id = (String)session.getValue("facility_id");
	java.util.Properties p=(java.util.Properties) session.getValue("jdbc");
	String user_name=""+p.getProperty("login_user");;
	if(facility_id == null) facility_id="";
	if(user_name == null||user_name.equals("null")) user_name="";	
	String strSourceType=request.getParameter("source_type");
	String strSourceCode=request.getParameter("source_code");
	String strSourceDesc=request.getParameter("source_desc");
	%>
<html>
<head><title></title>
<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<input type="hidden" name="PARAM1" id="PARAM1" value="<%=param1%>">
	<input type="hidden" name="PARAM2" id="PARAM2" value="<%=param2%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"	value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id"	value="OTRGENPK">	
	<input type="hidden" name="p_user_name" id="p_user_name" 	value="<%=user_name%>">	
</form>
</body>
</html>
<script>
	CaseSlipRun();
</script>

