<!DOCTYPE html>
<!-- 
Developed by    :Karabi Sarma
Module/Function : Drug Information Enquiry ( Transctions)
-->
<html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%
	String url			= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params		= request.getQueryString() ;
	String source		= url + params ;	
%>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String homepage=request.getParameter("homepage")==null?"":request.getParameter( "homepage" ) ;
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script> 
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:7vh;width:100vw"></iframe>
	<iframe name="f_drug_quick_info" id="f_drug_quick_info" scrolling="no" frameborder="0" src="../../ePH/jsp/PhQuickLink.jsp?homepage=<%=homepage%>" style="height:3vh;width:100vw"><!-- Added new frame for Bru-HIMS-CRF-078 [IN:029944]  -- style="height:3vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod"  frameborder="0" scrolling="no" noresize border='2'  style='height:82vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:8vh;width:100vw"></iframe>

</html>

