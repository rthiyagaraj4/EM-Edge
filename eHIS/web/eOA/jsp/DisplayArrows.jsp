<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
   <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String Date=(String)request.getParameter("Date");
String end_date=(String)request.getParameter("end_date");

%>
	<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eOA/js/Validate1.js" language="JavaScript"></Script>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--@UAT-3-->
	</head>
	
	<body onLoad="setTimeout('Disable_opco()',500);" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name ='displayimage'>
	<table width='98%' border='0'>
	<tr>
	<td width='20%'>&nbsp;</td>
	<td width='20%'>&nbsp;</td>
	<td width='15%' align='left'><input type='button' name='back' id='back' value='<--'   onClick="moveBack()" class='BUTTON'></td>
	<td id='date_period' class='label'></td>
	<td width='15%' align='right'><input type='button' name='forward' id='forward' value='-->' onClick='moveForward()' class='BUTTON'></td>
	</tr>
	</table>

	<input type=hidden name='Date' id='Date' value=<%=Date%> >
	<input type=hidden name='end_date' id='end_date' value=<%=end_date%> >

</form>
</body>
</html>

