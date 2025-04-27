<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	  request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="DispMedicationOverRideReasons" id="DispMedicationOverRideReasons" >
<%
	String allergy			=	request.getParameter("allergy");
	String exceed_dose		=	request.getParameter("exceed_dose");
	String duplicate		=	request.getParameter("duplicate");
	allergy					=	java.net.URLDecoder.decode(allergy,"UTF-8");
	exceed_dose				=	java.net.URLDecoder.decode(exceed_dose,"UTF-8");
	duplicate				=	java.net.URLDecoder.decode(duplicate,"UTF-8");
%>

<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0">
<% if(!allergy.equals("")) { %>
<tr>
	<td class="COLUMNHEADER" align="left"><fmt:message key="ePH.AllergicOverrideReason.label" bundle="${ph_labels}"/></td>
</tr>
<tr>
	<td  class="data">&nbsp;<textarea rows="3" cols="64" readonly><%=allergy%></textarea></td>
</tr>
<% } if(!exceed_dose.equals("")) { %>
<tr>
	<td class="COLUMNHEADER" align="left"><fmt:message key="ePH.DosageOverrideReason.label" bundle="${ph_labels}"/></td>
</tr>
<tr>
	<td  class="data">&nbsp;<textarea rows="3" cols="64" readonly><%=exceed_dose%></textarea></td>
</tr>
<% } if(!duplicate.equals("")) { %>
<tr>
	<td class="COLUMNHEADER" align="left"><fmt:message key="ePH.DuplicateDrugOverrideReason.label" bundle="${ph_labels}"/></td>
</tr>
<tr>
	<td  class="data">&nbsp;<textarea rows="3" cols="64" readonly><%=duplicate%></textarea></td>
</tr>
<%	}	%>
<tr>
	<td  class="white"><input type="button" class="button" value="Close" onClick="parent.window.close()">&nbsp;&nbsp;
	</td>
</tr>
</table>
</form>
</body>
</html>

