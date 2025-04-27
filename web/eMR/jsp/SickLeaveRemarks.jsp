<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function populateRemarks()
{
	var text=parent.window.dialogArguments;
	if(text == null || text =='null') text='';
	document.forms[0].Remarks.value=text;
}
function close_me()
{
    window.close();

}
</script>
</head>
<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<body onLoad='populateRemarks()' onKeyDown='lockKey()'>
<form  method=post action="">

<table cellpadding=0 cellspacing=0 width='100%' align=center>
<tr>
    <td width='2%'>&nbsp;</td>
    <td>&nbsp;</td>
    <td width='2%'>&nbsp;</td>
</tr>
<tr>
    <td>&nbsp;</td>
    <td><textarea name="Remarks"  rows="6" cols="95" Readonly></textarea></td>
    <td>&nbsp;</td>
</tr>
<tr>
    <td>&nbsp;</td>
    <td class='button'><input type=button class=button name=Close value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='close_me()'></td>
    <td>&nbsp;</td>
</tr>

</form>
</body>
</html>

