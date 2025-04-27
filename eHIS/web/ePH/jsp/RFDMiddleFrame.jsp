<!DOCTYPE html>
 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/RFD.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");

	String url = "../../ePH/jsp/RFDAddModify.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='f_formOfDrug' id='f_formOfDrug'  frameborder="0" scrolling='no' noresize src="<%= source %>" style='height:12vh;width:98vw'></iframe>
<iframe name="f_RFDDetails" id="f_RFDDetails" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:70vh;width:98vw"></iframe>
</html>

