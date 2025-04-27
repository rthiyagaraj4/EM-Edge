<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
<!-- 	<script language="javascript" src="../js/PhMessages.js"></script> -->
	<script language="javascript" src="../js/TPNRegimenMast.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
request.setCharacterEncoding("UTF-8");
//Added for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String params = request.getQueryString();
%>

<iframe name="f_tpn_regimen_add_modify" id="f_tpn_regimen_add_modify" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/TPNRegimenMastAddModify.jsp?<%=params%>" style="height:22vh;width:100vw"></iframe>
<iframe name="f_tpn_regimen_details" id="f_tpn_regimen_details" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:72vh;width:99vw"></iframe>
</html>

