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
	<form name ='result'>
		<table width ='100%' height='40%' border=0 cellpadding=3 cellspacing=0 align=center RULES=NONE>	
			<tr><td class='COLUMNHEADER' >&nbsp;<fmt:message key="eCA.BMICalculator.label" bundle="${ca_labels}"/></td><td class='COLUMNHEADERCENTER'></td>
			</tr>
			<tr><td class=label ><fmt:message key="Common.weight.label" bundle="${common_labels}"/>&nbsp;</td><td class=fields ><input type='text' style="text-align:Right" name ='weight' size =4 maxlength='4'>&nbsp;<fmt:message key="Common.Kgs.label" bundle="${common_labels}"/></td></tr>
			<tr><td class=label ><fmt:message key="Common.height.label" bundle="${common_labels}"/>&nbsp;</td><td class=fields ><input type='text' style="text-align:Right" name ='height' size =4 maxlength='4'>&nbsp;<fmt:message key="Common.Cms.label" bundle="${common_labels}"/></td></tr>
			<tr><td colspan=2 align=center><input type ='button' value ='<fmt:message key="eCA.BMICalculator.label" bundle="${ca_labels}"/>' onClick='CalculateBMI()'  class="button"></td></tr>
			<tr><td class=label id=resultDisplay ><B><fmt:message key="eCA.BMIValue.label" bundle="${ca_labels}"/></B>&nbsp;</td><td><input type="text" style="text-align:Right" name="resultDisplay" id="resultDisplay" readonly  size=6 class=data></td></tr>
		<tr>
			
			<td   class="QUERYDATA">&nbsp;<fmt:message key="eCA.ReferenceRange.label" bundle="${ca_labels}"/> :</td>
			<td colspan=1></td>
		</tr>

		<tr>
			
			<td   class="LABEL"><fmt:message key="eCA.Normal185to24.label" bundle="${ca_labels}"/>  </b></td>
			<td colspan=1></td>

		</tr>
		<tr>
			<td class="LABEL"><fmt:message key="eCA.Overweight25to29.label" bundle="${ca_labels}"/></td>
			<td colspan=1></td>
		</tr>
		<tr>
			<td  class="LABEL"><fmt:message key="eCA.Obesity.label" bundle="${ca_labels}"/>&nbsp;30 to 39 </td>
			<td colspan=1></td>
		</tr>
		<tr>
			<td class="LABEL"><fmt:message key="eCA.ExtremeObesity.label" bundle="${ca_labels}"/></td>
			<td colspan=1></td>
		</tr>


	</table>

	</form>
</body>
</html>

