<!DOCTYPE html>
<%@page import="blPolicy.EncounterSpecificDefinitionBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String beanId = "bl_EncounterSpecificDefinitionBean" ;
String beanName = "blPolicy.EncounterSpecificDefinitionBean";


response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

EncounterSpecificDefinitionBean policyBean = (EncounterSpecificDefinitionBean) getBeanObject(beanId, beanName, request);
cleanBeanObject(beanId, beanName, request);
policyBean.clearAll();

EncounterSpecificDefinitionBean deletedPolicyBean = (EncounterSpecificDefinitionBean) getBeanObject("DeletedEncounterBean", beanName, request);
cleanBeanObject("DeletedEncounterBean", beanName, request);
deletedPolicyBean.clearAll();
%>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<title><fmt:message key="eBL.POLICY_DTL.label" bundle="${bl_labels}"/></title>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString();
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<!--<script language="javascript" src='../../eBL/js/.js'></script>-->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		
		<iframe name='PolicyCoverageMain' id='PolicyCoverageMain'	src='../../eBL/jsp/RcrdApprovalPolicyCoverageMain.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:45vh;width:100vw'></iframe>
		<iframe name='PolicyDetailsTab' id='PolicyDetailsTab'	src='../../eBL/jsp/RcrdApprovalPolicyDetailsTab.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:6vh;width:100vw'></iframe>
		<iframe name='PolicyDetailsPage' id='PolicyDetailsPage'	src='../../eBL/jsp/RcrdApprovalPolicyDetailsInclExcl.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:30vh;width:100vw'></iframe>
		<iframe name='PolicyDetailsAdd' id='PolicyDetailsAdd'	src='../../eBL/jsp/RcrdApprovalPolicyDetailsAdd.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:7vh;width:100vw'></iframe>
		

</HTML>

