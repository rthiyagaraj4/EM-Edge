<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*, eCA.CAOpenChartServlet,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<html>
<head>
<%
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String alertMsg = request.getParameter("alertMsg")==null?"":request.getParameter("alertMsg");
%>
<TITLE>Confirmation Page</TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function confirmVal(val){
	returnValue=val;
	window.close();
	return(returnValue);
	
}
</script>
</head>		
<form name='confirmForm' id='confirmForm'>
<table width='100%'>

	<tr id='startConsRow'>
		<td colspan='3' align='center'>
		<%=alertMsg%>
		</td>
	</tr>
	<tr>
		<td colspan='3'>&nbsp;</td>
	</tr>
	<tr id='startConsBtnRow'>
		<td colspan ='3' align='center'>
		<input class='button' align='right' type='button' name = 'confirmYes' value='Yes' onclick="confirmVal('Y')"/>&nbsp;&nbsp;
		<input class='button' align='right' type='button' name = 'confirmNo' value='No' onclick="confirmVal('N')"/>
		</td>
		<td>&nbsp;</td>
	</tr>
</table>
</form>
</html>

