<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>

<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()"> 
<form name="formPrescriptionInstructions" id="formPrescriptionInstructions">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<tr>
			<td align="right">
				<input type="button" name="btnClose" id="btnClose" value="Close" class="button" onClick="window.close()">			
			</td>
		</tr>
	</table>
</form>
</body>
</html>

