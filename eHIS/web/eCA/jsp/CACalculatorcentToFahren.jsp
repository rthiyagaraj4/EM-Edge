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
	<form name ='CerebralPP'>
<table width ='95%' height='40%' border=0 cellpadding=0 cellspacing=0 align=center RULES=NONE>
		<tr><th colspan='3' align='left'>&nbsp;<fmt:message key="eCA.CentigradetoFahrenheit.label" bundle="${ca_labels}"/></th>
		<tr>
		<td class="label" align ='right' width='50%'><fmt:message key="eCA.Centigrade.label" bundle="${ca_labels}"/>&nbsp;</td>
		<td><input type='text' name ='cent' size ='5' class="DATA" style="text-align: Right" maxLength ='5'></td>
		</tr>
		<tr>
		<td colspan=2 align=center><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' onClick='javaScript:CalculateCenttoFahren()' class="BUTTON" ></td>
		</tr>

		<tr>
		
		<td  class="data"  align=right width='50%'><fmt:message key="eCA.Fahrenheit.label" bundle="${ca_labels}"/>&nbsp;</td><td><input type='text' name='fahren' id='fahren' size='5' class="DATA" style="text-align: Left"></td>
		</tr>

</table>

</form>
</BODY>
</HTML>

