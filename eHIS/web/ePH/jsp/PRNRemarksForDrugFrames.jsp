<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
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
	String locale		=		(String) session.getAttribute("LOCALE");
	String sStyle		=		(session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
   String mode = request.getParameter("mode");
	

	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
<script language="JavaScript" src="../../ePH/js/PRNRemarksForDrug.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name="f_prn_remarks_drug_criteria" id="f_prn_remarks_drug_criteria" frameborder="0" scrolling="no"noresize src="../../ePH/jsp/PRNRemarksForDrugCriteria.jsp?mode=<%=mode%>" style="height:20vh;width:100vw"></iframe><iframe name="f_prn_remarks_drug_result" id="f_prn_remarks_drug_result" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:40vh;width:100vw"></iframe>
</html>

