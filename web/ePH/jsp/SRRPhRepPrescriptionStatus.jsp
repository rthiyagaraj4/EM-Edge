<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String bean_id = "SRROnlineReportSet1Bean" ;
	String bean_name = "ePH.SRROnlineReportSet1Bean";

	SRROnlineReportSet1Bean bean = (SRROnlineReportSet1Bean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);
	
	Hashtable result = bean.getStatusDesc();
%>
<form name="frmPrintPrescriptionReportStatus" id="frmPrintPrescriptionReportStatus">
	<table cellpadding="0" cellspacing="0" align="center" border="1" bordercolor="black" id="frmPrintPrescriptionReportStatustable" >
	<tr>
		<td class="white" width="1%" style='background-color:#FF0000;border:none'>&nbsp;&nbsp;</td>
		<td class="white" style="border:none"><label class="label" style="font-size:9"><b>&nbsp;<%=result.get("OS")%>/<%=result.get("RG")%></b></label></td>
		<td class="white" width="1%" style='background-color:#CC9933;border:none'>&nbsp;&nbsp;</td>
		<td class="white" style="border:none"><label class="label" style="font-size:9"><b>&nbsp;<%=result.get("DP")%></b></label></td>
		<td class="white" width="1%" style='background-color:#990000;border:none' >&nbsp;&nbsp;</td>
		<td class="white" style="border:none"><label class="label" style="font-size:9"><b>&nbsp;<%=result.get("DF")%></b></label></td>
	</tr>
</table>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

