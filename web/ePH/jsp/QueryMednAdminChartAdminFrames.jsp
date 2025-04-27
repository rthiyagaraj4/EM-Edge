<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="javascript" src="../js/PhCommon.js"></script>
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title>Administration Detail</title>
</head>                               


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String params = request.getQueryString() ;

%>

<iframe name="f_medn_queryCriteria_admin" id="f_medn_queryCriteria_admin" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/QueryMednAdminChartAdminDetails.jsp?<%=params%>" style="height:84vh;width:100vw"></iframe><iframe name="f_admin_close" id="f_admin_close" src="../../ePH/jsp/PrescriptionClose.jsp?called_from=normal" frameborder="0" noresize scrolling="no" style="height:16vh;width:100vw"></iframe>
</html>	

