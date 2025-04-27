<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------------------------------
Date		Edit History	 Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------
29/02/2016	IN057106_changed Vijayakumar K	29/02/2016		Ramesh Goli			ML-MMOH-CRF-0328 files created newly
---------------------------------------------------------------------------------------------------------------
-->

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
        
		
		<title><fmt:message key="eCA.antibodydetails.label" bundle="${ca_labels}"/></title>
	</head>
		<iframe name="AntibodyResultsFrame" id="AntibodyResultsFrame"   noresize src="../../eCA/jsp/CAAnitbodyResults.jsp?<%=request.getQueryString()%>" style="height:100vh;width:100vw"></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp'   frameborder=0 scrolling='no'  noresize style='height:8%;width:100vw'></iframe>	
		 

</html>

