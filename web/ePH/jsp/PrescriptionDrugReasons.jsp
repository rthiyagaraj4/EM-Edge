<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale = (String) session.getAttribute("LOCALE"); 
		

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
	<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title>Override Reason</title>
</head>
<%
		String allergy		=	request.getParameter("allergy");
		String dosage		=	request.getParameter("dosage");
		String duplicate	=	request.getParameter("duplicate");
	/*	if (allergy!= null){
			allergy	= java.net.URLDecoder.decode(allergy,"UTF-8");
		}

		if (dosage != null){
			dosage	= java.net.URLDecoder.decode(dosage,"UTF-8");
		}
		if (duplicate != null){
			duplicate =java.net.URLDecoder.decode(duplicate,"UTF-8");
		}*/
%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="PrescriptionDrugReasons" id="PrescriptionDrugReasons" >
<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0">
<% if(allergy!=null && !allergy.equals("")) { %>
<tr>
	<td   class="label">&nbsp;<fmt:message key="ePH.AllergicOverrideReason.label" bundle="${ph_labels}"/></td>
</tr>
<tr>
	<td   colspan="2">&nbsp;<textarea rows="3" cols="80" readonly><%=allergy%></textarea>&nbsp;</td>
</tr>
<% } %>
<tr><td colspan="2"></td></tr>
<tr><td colspan="2"></td></tr>
<% if(dosage!=null && !dosage.equals("")) { %>
<tr>
	<td   class="label">&nbsp;<fmt:message key="ePH.DosageOverrideReason.label" bundle="${ph_labels}"/></td>
</tr>
<tr>
	<td  colspan="2">&nbsp;<textarea rows="3" cols="80" readonly><%=dosage%></textarea>&nbsp;</td>
</tr>
<% } %>
<tr><td colspan="2"></td></tr>
<tr><td colspan="2"></td></tr>
<% if(duplicate!=null && !duplicate.equals("")) { %>
<tr>
	<td   class="label">&nbsp;<fmt:message key="ePH.DuplicateDrugOverrideReason.label" bundle="${ph_labels}"/> </td>
</tr>
<tr>
	<td   colspan="2">&nbsp;<textarea rows="3" cols="80" readonly><%=duplicate%></textarea>&nbsp;</td>
</tr>
<% } %>
<tr><td  >&nbsp;&nbsp;<input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  onClick="window.close()"></td></tr>
</form>
</body>
</html>

