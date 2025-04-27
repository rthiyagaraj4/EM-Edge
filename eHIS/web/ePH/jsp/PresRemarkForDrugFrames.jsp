<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String mode = "";
		mode = request.getParameter("mode");
		String params = request.getQueryString() ;
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/PresRemarkForDrug.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>

	<%
		if (mode.equals("1")) {
	%>
		<iframe name="f_query_add_Header" id="f_query_add_Header" frameborder="0" scrolling="no"	noresize src="../../ePH/jsp/PresRemarkForDrugHeader.jsp?mode=<%=mode%>" style="height:20vh;width:100vw"></iframe>
	<%
		} 
	else if (mode.equals("2")) {
	%>
		<iframe name="f_query_add_Header" id="f_query_add_Header" frameborder="0" scrolling="no"	noresize src="../../ePH/jsp/PresRemarkForDrugHeader.jsp?<%=params%>" style="height:20vh;width:100vw"></iframe>
	<%
		}
	%>
	<iframe name="f_query_add_details" id="f_query_add_details" frameborder="0" scrolling="auto"	noresize src="../../eCommon/html/blank.html" style="height:75vh;width:100vw"></iframe>


</html>

