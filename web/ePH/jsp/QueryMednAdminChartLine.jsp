<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<!-- 
Developed by	: Pushkala.B
Module/Function : QueryMednAdminChart
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

	String qstring=request.getQueryString();
	
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0">
<form name="FormSearchLine" id="FormSearchLine" >
<table cellpadding="0" cellspacing="0" width="100%" align="left" border="0">
	<tr>
	<td class='white' align='left'>
	<input type='text' name='bed_no' id='bed_no'  style="color:red;" size='14' maxlength='8' class='number' value='Enter Bed No' onfocus="parent.f_summaryframe.clearField(this);"></input>&nbsp;<input type='button' class='button' value='Locate' name='locate' id='locate' 
	onclick='parent.f_summaryframe.locateBedNo(FormSearchLine.bed_no,"<%=qstring%>")'>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type='text' name='Patient_Id' id='Patient_Id'  style="color:red;" size='14' maxlength='20' class='number' value='Enter Patient Id' onfocus="parent.f_summaryframe.clearField(this);"></input>&nbsp;<input type='button' class='button' value='Locate' name='locate' id='locate' onclick='parent.f_summaryframe.locatePatientId(FormSearchLine.Patient_Id,"<%=qstring%>")'>
	</td>
	<td align="right" class="white">
		<input type="button" class="button" value="Next Patient" onClick='parent.f_summaryframe.skipPatient("<%=qstring%>")' >&nbsp;&nbsp;&nbsp;
	</td>
	</tr>
</table>
</body>
</html>

