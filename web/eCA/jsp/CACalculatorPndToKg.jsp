<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
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

</HEAD>

<BODY class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name ='CerebralPnd'>
<table width ='95%' height='40%' border=0 cellpadding=0 cellspacing=0 align=center RULES=NONE>
		<tr><td class='COLUMNHEADER'>&nbsp;<fmt:message key="eCA.PoundstoKilogram.label" bundle="${ca_labels}"/></td><td colspan=2 class='COLUMNHEADER'></td>
		<tr>
		<td class="label" colspan ='2' align ='right' width=50%><fmt:message key="eCA.Pounds.label" bundle="${ca_labels}"/>&nbsp;</td>
		<td><input type='text' name ='pound' size ='5' class="DATA" style="text-align: Right" maxLength ='5'> </td>
		</tr>
		<tr>
		<td align=center colspan=3><input type='button' value='<fmt:message key="eCA.Calculate.label" bundle="${ca_labels}"/>' onClick='javaScript:CalculatePndToKg()' class="BUTTON" ></td>
		</tr>

		<tr>
		<td colspan ='2'class="data" align=right><fmt:message key="eCA.Kilogram.label" bundle="${ca_labels}"/>&nbsp;</td><td><input type='text' name='kilo' id='kilo' size='5' class="DATA" style="text-align: Left"></td>
		</tr>

</table>

</form>
</BODY>
</HTML>

