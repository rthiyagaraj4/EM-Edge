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


</head>

<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name ='CerebralPP'>
		<table width ='95%' height='50%' border=0 cellpadding=3 cellspacing=0 align=center RULES=NONE>
		
			<tr><td class='COLUMNHEADER'>&nbsp;<fmt:message key="eCA.Cerebralperfusionpressure.label" bundle="${ca_labels}"/></td><td class='COLUMNHEADERCENTER'></td></tr>

			<tr><td class=label  width='50%'><fmt:message key="eCA.Meanarterialbloodpressure.label" bundle="${ca_labels}"/>&nbsp;</td><td class=fields><input type='text' name ='meanABP' size ='3' class="DATA" style="text-align: Right" maxLength ='3'>&nbsp;mmHg</td></tr>

			<tr><td class=label ><fmt:message key="eCA.Intracranialpressure.label" bundle="${ca_labels}"/>&nbsp;</td><td class=fields><input type='text' name ='intracranialP' size ='3'class="DATA" style="text-align: Right" maxLength ='3'> mmHg</td>	</tr>

			<tr><td colspan=2 align=center><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' onClick='javaScript:CalculateCerebralPP()' class="BUTTON" ></td> </tr>

			<tr><td class=label ><b><fmt:message key="eCA.Cerebralperfusionpressure.label" bundle="${ca_labels}"/>&nbsp;</b></td><td class=fields><input type='text' name='cerebralPP' id='cerebralPP' size='3' class="DATA" style="text-align:Left">&nbsp;mmHg</td></tr>

			<tr><td colspan=2></td></tr>
			<tr><td colspan='2' class="QUERYDATA">&nbsp;<fmt:message key="eCA.ReferenceRange.label" bundle="${ca_labels}"/> :</td>	</tr>

			<tr><td class =label colspan ='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="eCA.NormalCPP.label" bundle="${ca_labels}"/>  60-80 mmHg </td>
		</tr>

</table>
</form>
</body>
</html>

