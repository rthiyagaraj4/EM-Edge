<!DOCTYPE html>
<%
/*
Sr No        Version              TFS              SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735       PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
*/
%>

<%@ page import="java.sql.*, java.util.*,java.lang.Math.*, java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,com.ehis.util.*" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
  request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name=color_form >


<table align='left' cellspacing='0' cellpadding='3' border='3' width='100%' >
<tr>
	
<td>
<table border=1 align='left' cellspacing='0' cellpadding='3' border='0' width='100%'>
		<tr>
			 <td   class='QRYEVEN'><font size=1><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/>(P)</b></td> 
			<td bgcolor='Red'></td> <td   class='QRYEVEN'><font size=1><b><fmt:message key="Common.Start.label" bundle="${common_labels}"/></b></td>
			<td bgcolor='orange'></td><td   class='QRYEVEN'><font size=1><b><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></b></td>
			<td bgcolor='33FFC9'></td><td   class='QRYEVEN'><font size=1><b><fmt:message key="Common.routine.label" bundle="${common_labels}"/></b></td>
		</tr>
</table>
</td>
<td  align='left' bordercolor='blue' width='50%' ></td>

</tr>
</table>
</form>
</body>
</html>

