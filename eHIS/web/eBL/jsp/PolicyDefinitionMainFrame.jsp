<!DOCTYPE html>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
String beanId = "bl_PolicyInsuranceMasterBean" ;
String beanName = "eBL.PolicyInsuranceMasterBean";

response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

PolicyInsuranceMasterBean policyBean = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
cleanBeanObject(beanId, beanName, request);
policyBean.clearAll();

PolicyInsuranceMasterBean deletedPolicyBean = (PolicyInsuranceMasterBean) getBeanObject("DeletedPolicyBean", beanName, request);
cleanBeanObject("DeletedPolicyBean", beanName, request);
deletedPolicyBean.clearAll();

String calledForm = request.getParameter("calledForm") == null ? "" : request.getParameter("calledForm");//Added V191016-Aravindh/NMC-JD-CRF-0010.2
%>
<HTML>
<HEAD>
<title><%=request.getParameter("title")%></title>
<script language="javascript" src="../../eCommon/js/common.js"></script>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString();
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<!--<script language="javascript" src='../../eBL/js/.js'></script>-->
		
		<% if("policyApproval".equals(calledForm)) { %>
			
	<IFRAME name='PolicyInfoFrame' id='PolicyInfoFrame'	src='PolicyInfoFrame.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style='height:33vh;width:100vw'></IFRAME>
		<!-- <FRAME name='PolicyCoverageTab'	src='PolicyCoverageTab.jsp?<%=params%>' frameborder=0 noresize scrolling='auto' noresize>  -->
		<IFRAME name='PolicyCoverageMain' id='PolicyCoverageMain'	src='../../eBL/jsp/PolicyCoverageMain.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:39vh;width:100vw'></IFRAME>
		<IFRAME name='PolicyDetailsTab' id='PolicyDetailsTab'	src='../../eBL/jsp/PolicyDetailsTab.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:8vh;width:100vw'></IFRAME>
		<IFRAME name='PolicyDetailsPage'id='PolicyDetailsPage'	src='../../eBL/jsp/PolicyDetailsInclExcl.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:19vh;width:100vw'></IFRAME>
		<IFRAME name='PolicyDetailsAdd' id='PolicyDetailsAdd'	src='../../eBL/jsp/PolicyDetailsAdd.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:4vh;width:100vw'></IFRAME>
			
		<% } else {%>
			
			<IFRAME name='PolicyInfoFrame' id='PolicyInfoFrame'	src='PolicyInfoFrame.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style='height:31vh;width:100vw'></IFRAME>
		<!-- <FRAME name='PolicyCoverageTab'	src='PolicyCoverageTab.jsp?<%=params%>' frameborder=0 noresize scrolling='auto' noresize>  -->
		<IFRAME name='PolicyCoverageMain' id='PolicyCoverageMain'	src='../../eBL/jsp/PolicyCoverageMain.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:39vh;width:100vw'></IFRAME>
		<IFRAME name='PolicyDetailsTab' id='PolicyDetailsTab'	src='../../eBL/jsp/PolicyDetailsTab.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:8vh;width:100vw'></IFRAME>
		<IFRAME name='PolicyDetailsPage' id='PolicyDetailsPage'	src='../../eBL/jsp/PolicyDetailsInclExcl.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:19vh;width:100vw'></IFRAME>
		<IFRAME name='PolicyDetailsAdd' id='PolicyDetailsAdd'	src='../../eBL/jsp/PolicyDetailsAdd.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:10vh;width:100vw'></IFRAME>
	
		<% } %>
		
		<% if("policyApproval".equals(calledForm)) { %>
			<IFRAME name='messageFrame'	 id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:9vh;width:100vw'></IFRAME>
		<% } %>
	

</HTML>
