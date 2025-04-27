<%/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
5/11/2024	    70709     Gunasekar R   6/11/2024   Ashwini Ragupathi         ML-MMOH-CRF-1759
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@ page import="java.sql.*, java.util.*,java.lang.Math.*, java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,com.ehis.util.*" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
 request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script language='javascript' src='../../eCommon/js/common.js'></script>
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=color_form id=color_form >
<table align='left' cellspacing='0' cellpadding='3' border='3' width='100%' >
<tr>
<td>
	<table border=1 align='left' cellspacing='0' cellpadding='3' border='0' width='25%'>
		<tr>
				<td  align='left' class='DISCHARGED' width='8%' align=center>&nbsp;</td>
				<td   class='QRYEVEN' ><font size=1><fmt:message key="eCA.CheckedOut.label" bundle="${ca_labels}"/>/<font size=1><fmt:message key="Common.discharged.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td   class='CADECEASED' width='8%'>&nbsp;</td>
				<td   class='QRYODD'><font size=1>&nbsp;<fmt:message key="Common.deceased.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		</tr>
	</table>
</td>
<td  align='center' bordercolor='blue' width='' id='next'></td>
</tr>
</table>
</form>
</body>
</html>

