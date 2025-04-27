<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCA/js/CACalculator.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name ='redCell'>
	<table width ='95%' height='50%' border=0 cellpadding=3 cellspacing=0 align=center RULES=NONE>
	<tr><td class='COLUMNHEADER' colspan=2>&nbsp;<fmt:message key="eCA.RedCellVolumeinAdultsbasedonBodySurfaceArea.label" bundle="${ca_labels}"/></td></tr>
	<tr><td class ='LABEL'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</td><td class=label >&nbsp;&nbsp;<fmt:message key="Common.male.label" bundle="${common_labels}"/>&nbsp;<input type='radio' name='sex' id='sex' value ='M' checked>&nbsp;<fmt:message key="Common.female.label" bundle="${common_labels}"/>&nbsp;<input name='sex' id='sex' type='radio' value ='F'></td></tr>
	<tr><td class=label ><fmt:message key="Common.weight.label" bundle="${common_labels}"/>&nbsp;</td><td class=fields><input type='text' name ='weight' size =4 maxLength = 4 class="DATA" style="text-align: Right">&nbsp;Kgs</td></tr>
	<tr><td class=label ><fmt:message key="Common.height.label" bundle="${common_labels}"/>&nbsp;</td><td class=fields ><input type='text' name ='height' size =4 maxLength = 4 class="DATA" style="text-align: Right">&nbsp;Cms</td></tr>
	<tr><td class=label colspan=2 align=center><input type='button' value='<fmt:message key="eCA.Calculate.label" bundle="${ca_labels}"/>' onClick='javaScript:CalculateRedCellVolume()' class="BUTTON" ></tr>
	<tr><td class=label nowrap ><b><fmt:message key="eCA.RedCellVolume.label" bundle="${ca_labels}"/>&nbsp;<b></td><td ><input type='text' name='redCellVolumeValue' id='redCellVolumeValue' size='4' class="DATA" style="text-align:Left"></td>
	<!-- <tr><td colspan=3>&nbsp;</td></tr> -->
	
	


</table>

</form>
</BODY>
</HTML>

