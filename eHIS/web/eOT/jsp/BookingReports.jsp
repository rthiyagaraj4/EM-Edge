<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%
	String facility_id = (String)session.getValue("facility_id");
	String booking_num		= request.getParameter("booking_num");
	String sex=request.getParameter("sex");
	if(facility_id == null) facility_id="";
	if(booking_num == null) booking_num="";

	/*System.err.println("10--->");

	System.out.println("facility_id--->"+facility_id);
	System.err.println("booking_num--->"+booking_num);
	System.err.println("sex--->"+sex);*/
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
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<!-- <Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script> -->
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="nd_facility_id" id="nd_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="nd_booking_num" id="nd_booking_num"	value="<%=booking_num%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="OTRNOTIF">
	<input type="hidden" name="p_sex" id="p_sex" 	value="<%=sex%>">
   

</form>
</body>
 <script>CaseSlipRun();</script> 
</html>

