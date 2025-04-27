<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper" %>
<html>
<title><fmt:message key="eOA.PrintConfirm.label" bundle="${oa_labels}"/></title>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String appt_ref_no = request.getParameter("appt_ref_no");
String cliniccode=request.getParameter("cliniccode");
%>
</head>
<body class=message onKeyDown = 'lockKey()'>
<form name='print_confirm' id='print_confirm' action='../../servlet/eOA.BookAppointmentServlet' method='post' target='dummy_frame'>
<input type=hidden value='<%=appt_ref_no%>' name='appt_ref_no'>
<input type=hidden value='<%=cliniccode%>' name='cliniccode'>
<input type=hidden value='printing' name='function_name' id='function_name'>
<script>
document.forms[0].submit();
alert(getMessage("REPORT_SUBMIT_SERVER","Common"));
parent.window.returnValue='closed';parent.window.close();
</script>
</form>
</body>
</html>

