<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String document_id_value = request.getParameter("document_id_value") == null ? "" : request.getParameter("document_id_value");
	int value = 40;
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="javascript" src="../js/DocRefFmt.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=DocRefFmtConstruction>
<table width='100%' align='center'cellpadding='2'>
<tr>
<td bordercolor='blue' width='35%' align='left'>
		<b><fmt:message key="eCA.Constant.label" bundle="${ca_labels}"/></b><br>
		<input type=text  size=30 value='' id=intVal name=finVal onkeypress='return chkTildeAndGA()'>&nbsp;&nbsp;
		<input type=button class=button value='Insert' name=insVal size=10 onClick="newTextInt(document.forms[0].finVal);clearVal();">
	</td>	
	<td bordercolor='blue' class='label' width='40%' height='100%' >  
		<b><fmt:message key="eCA.PlacingOption.label" bundle="${ca_labels}"/></b> <br><br><br>
		<input type=radio class=radio value='R' name=replace id=replaceOpt > <a onclick="radioCheck(document.getElementById("replaceOpt"));"> <fmt:message key="Common.Replace.label" bundle="${common_labels}"/> </a> &nbsp;&nbsp;
		<input type=radio class=radio value='IL' name=replace id=replaceLefOpt > <a onclick="radioCheck(document.getElementById("replaceLefOpt"));"> <fmt:message key="eCA.InsertLeft.label" bundle="${ca_labels}"/> </a>&nbsp;&nbsp;
		<input type=radio class=radio value='IR' name=replace id=replaceRigOpt  checked> <a onclick="radioCheck(document.getElementById("replaceRigOpt"));"> <fmt:message key="eCA.InsertRight.label" bundle="${ca_labels}"/> </a>&nbsp;&nbsp;
		<br><br>
		<hr color=thickblue height=1>
		<br><br>
		<input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>' id=remov name=remove onClick="removeValue();"  disabled>
		<input type=button class=button align=right id=rese value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>' name=resetBtn onClick="onReset();" disabled>
	</td>
</tr>
<tr id=t  width='100%'> 
    <td colspan=3 wrap> <div id=f></div> </td> 
</tr>
<tr></tr>
<tr>
  <td class = 'label' width='25%' align='left'><fmt:message key="eCA.CurrentLength.label" bundle="${ca_labels}"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <b><label name = 'curr_size' id='curr_size'></label></b></td> 
</tr>
<tr>
   <td  class = 'label' width='15%' align='left'><fmt:message key="eCA.MaxLengthAllowed.label" bundle="${ca_labels}"/> : <b><%=value%></b></td> 
</tr>
</table>
 <input type='hidden' name='hiddenRefFormat' id='hiddenRefFormat' value = '<%=document_id_value%>'>
 <input type='hidden' name='document_type' id='document_type' value = ''>
</form>
<script>
	setTimeout("displayValues()",200);
</script> 
</body>
</html>

