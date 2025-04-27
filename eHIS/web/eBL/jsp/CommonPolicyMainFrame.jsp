<!DOCTYPE html>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
String beanId = "PayerPolicyInsuranceMasterBean" ;
String beanName = "eBL.PolicyInsuranceMasterBean";

response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

PolicyInsuranceMasterBean policyBean = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
cleanBeanObject(beanId, beanName, request);
policyBean.clearAll();
%>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js"></script>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString();
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<!-- <script language="javascript" src='../../eBL/js/.js'></script>-->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		
		<iframe name='PolicyInfoFrame' id='PolicyInfoFrame'	src='../../eBL/jsp/PolicyInfoFrame.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:28vh;width:100vw'></iframe>
		<!-- <iframe name='PolicyCoverageTab' id='PolicyCoverageTab'	src='PolicyCoverageTab.jsp?<%=params%>' frameborder=0 noresize scrolling='auto' noresize></iframe>  -->
		<iframe name='PolicyCoverageMain' id='PolicyCoverageMain'	src='../../eBL/jsp/PolicyCoverageMain.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:42vh;width:100vw'></iframe>
		<iframe name='PolicyDetailsTab' id='PolicyDetailsTab'	src='../../eBL/jsp/PolicyDetailsTab.jsp?<%=params%>' frameborder=0 noresize   style='height:5vh;width:100vw'noresize></iframe>
		<iframe name='PolicyDetailsPage' id='PolicyDetailsPage'	src='../../eBL/jsp/PolicyDetailsInclExcl.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:19vh;width:100vw'></iframe>
		<iframe name='PolicyDetailsAdd' id='PolicyDetailsAdd'	src='../../eBL/jsp/PolicyDetailsAdd.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:6vh;width:100vw'></iframe>
		

</HTML>

