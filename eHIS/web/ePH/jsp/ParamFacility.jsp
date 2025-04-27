<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="JavaScript" src="../js/ParamFacility.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
		<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:6vh;width:100vw"></iframe>
		<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" noresize src="../../ePH/jsp/ParamFacilityAddModify.jsp" style="height:84vh;width:100vw;  overflow-x: hidden;"></iframe>
		<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:10vh;width:100vw"></iframe>
</html>

