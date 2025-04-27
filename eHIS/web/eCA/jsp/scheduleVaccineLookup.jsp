<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
 request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script language='javascript' src='../../eCommon/js/common.js'></script>
	<SCRIPT LANGUAGE="JavaScript">
	<!--
		function retVaccine(obj)
		{			
			window.returnValue = obj.value;
			window.close();
		}
	//-->
	</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=color_form >
<table class='grid' width='100%'>
		<tr>				
			<td class='gridData' width='13%'>Hepatitis B</td><td><input type='checkbox' onclick='retVaccine(this)' value='HE2'></td>
		</tr>
		<tr>
			<td class='gridData' width='13%'>Vitamin K </td><td><input type='checkbox' onclick='retVaccine(this)' value='VITAMINK'></td>
		</tr>
</table>
</form>
</body>
</html>

