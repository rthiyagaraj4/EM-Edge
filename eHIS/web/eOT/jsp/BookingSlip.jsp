<!DOCTYPE html>
<%@ page import ="eCommon.Common.*,eOT.*,eOT.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript'>
function closeWindow()
{
	parent.window.close();
}
function returnWindow()
{
	var frmObj=document.forms[0];
	
parent.window.returnValue='1';	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<TITLE> <fmt:message key="Common.internalreport.label" bundle="${common_labels}"/></TITLE>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="HdrCommonForm" id="HdrCommonForm" method="POST" >
<BR><BR><BR><BR><BR>
<table  border='1' width='100%' cellpadding=3 cellspacing=0>
<tr>
<td class='columnHeaderCenter'  width='70%' ><fmt:message key="Common.reportname.label" bundle="${common_labels}"/></td>
<td class='columnHeaderCenter'  width='15%'><fmt:message key="eOT.Reqd.Label" bundle="${common_labels}"/></td>
<td class='columnHeaderCenter'  width='15%' ><fmt:message key="Common.copies.label" bundle="${common_labels}"/></td>
</tr><tr>
<td  width='70%'  class='label'><fmt:message key="eOT.BookingScreenSlip.Label" bundle="${common_labels}"/></td>
<td  width='15%'  align='center'>
<input type='checkbox' name='chkBook' id='chkBook' checked></td>
<td  width='15%' >
<input type='text' name='txtBook' id='txtBook' size=3 maxlength=3 value='1'></td>
</td>
</tr>
<tr >
<td  colspan='3'>
<input type='button'  class='button' name='but1' id='but1'  value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='returnWindow()'>
<input type='button' class='button' name='but12' id='but12' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='closeWindow()'>
</td></tr>
</table>
</form>
</body>
</html>

