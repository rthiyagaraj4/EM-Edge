<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
   	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 	<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 	%>
</head>
<%
	String bean_id = "Or_ResultReporting" ;
	String bean_name = "eOR.ResultReportingBean";
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id== null)practitioner_id = "";
	String  isValid = "";
	ResultReportingBean bean = (ResultReportingBean)getBeanObject( bean_id, bean_name , request) ;
		bean.setLanguageId(localeName);
		isValid = bean.isAuthorised(practitioner_id,resp_id) ;
	
	if(isValid != null)
	{
%>
<%-- <frameset rows='4%,38%,*' id='framesize'>
	<frame name='ResultFrame' id='ResultFrame' src='../../eOR/jsp/ResultReportingFrame.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no noresize>
	<frame name='ResultReportingSearch' id='ResultReportingSearch' src='ResultReportingSearch.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no noresize>
	<!-- <frame name='ResultReportingHeader' id='ResultReportingHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize> -->
	<frame name='ResultReportingResult' id='ResultReportingResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize>
</frameset> --%>
	<iframe name="ResultFrame" id="ResultFrame" src="../../eOR/jsp/ResultReportingFrame.jsp?<%=request.getQueryString()%>" style="width: 100vw; height: 4vh; border: none; overflow: hidden;"></iframe>

	<iframe name="ResultReportingSearch" id="ResultReportingSearch" src="ResultReportingSearch.jsp?<%=request.getQueryString()%>" style="width: 100vw; height: 37vh; border: none; overflow: hidden;"></iframe>
	
	<iframe name="ResultReportingResult" id="ResultReportingResult" src="../../eCommon/html/blank.html" style="width: 100vw; height:56vh; border: none; overflow: auto;"></iframe>
		

	<%}else{
	out.println("<script>alert(getMessage(\"PRACT_RESP_NO_ACCESS\",\"OR\")); </script>");
	}%>
</html>

