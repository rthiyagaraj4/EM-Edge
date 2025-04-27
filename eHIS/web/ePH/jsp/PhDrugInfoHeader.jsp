<!DOCTYPE html>
 
<!-- Developed by    :Karabi Sarma
Module/Function : Drug Information Enquiry ( Transctions) 
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	 <script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	 <script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<title><fmt:message key="ePH.DrugInformationEnquiry.label" bundle="${ph_labels}"/></title>
	
</head>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="PhDrugInfoHeaderForm" id="PhDrugInfoHeaderForm"><br>
<table cellpadding="0" cellspacing="0" width="98%" align="center" border="1" id="tab">

<tr><!-- <td class='white' width='1%'>&nbsp;</td> -->
	<td id="encq" width="15%" class="CASECONDSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="//changeButtonColorDrugInfo(this,'PH_BUTTONS');" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" name="print_report" href="javascript:change_tab_buttons(this,'Enc_dtl')">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.EnquiryDetails.label" bundle="${ph_labels}"/></a></td>

	<td id="requ" width="15%" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="//changeButtonColorDrugInfo(this,'PH_BUTTONS');" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white"  href="javascript:change_tab_buttons(this,'Req_dtl')"  >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.RequestDetails.label" bundle="${common_labels}"/></a></td> 

	<td id="pat" width="15%" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="//changeButtonColorDrugInfo(this,'PH_BUTTONS');" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons(this,'Pat_dtl')">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></a></td>

	<td id="resp" width="15%" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="//changeButtonColorDrugInfo(this,'PH_BUTTONS');" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons(this,'Res_dtl')">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.ResponseDetails.label" bundle="${ph_labels}"/></a></td>
   <td class="white" width='40%' id="dummy"></td>
</tr>
</table>
</form>
</body>
</html>

