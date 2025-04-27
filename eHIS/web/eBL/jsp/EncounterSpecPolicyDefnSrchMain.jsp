<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
 1           V230228						MMS-DM-CRF-0209.5		Namrata Charate
*/ %>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import="blPolicy.EncounterSpecificDefinitionBean"%>
<%@page import="eBL.EncSpecMFDRBean"%>
<%
String beanId = "bl_EncounterSpecificDefinitionBean" ;
String beanName = "blPolicy.EncounterSpecificDefinitionBean";

String beanId1 = "bl_EncSpecMFDRBean" ; //V230228
String beanName1 = "eBL.EncSpecMFDRBean"; //V230228


response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

EncounterSpecificDefinitionBean policyBean = (EncounterSpecificDefinitionBean) getBeanObject(beanId, beanName, request);
cleanBeanObject(beanId, beanName, request);
policyBean.clearAll();

EncounterSpecificDefinitionBean deletedPolicyBean = (EncounterSpecificDefinitionBean) getBeanObject("DeletedEncounterBean", beanName, request);
cleanBeanObject("DeletedEncounterBean", beanName, request);
deletedPolicyBean.clearAll();

EncSpecMFDRBean policyBean1 = (EncSpecMFDRBean) getBeanObject(beanId1, beanName1, request);  //V230228
cleanBeanObject(beanId1, beanName1, request); //V230228
policyBean1.clearAll(); //V230228
%>
<%
		String params = request.getQueryString();
%>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<iframe name='encounterSpecPolicyDefnSrchCreteria' id='encounterSpecPolicyDefnSrchCreteria'	src='EncounterSpecPolicyDefnSrchCreteria.jsp'  frameborder=0  scrolling="no" noresize style='height:20vh;width:100vw'></iframe>
		<iframe name='encounterSpecPolicyDefnDataDetails' id='encounterSpecPolicyDefnDataDetails' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:20vh;width:100vw'>	</iframe>	
		<iframe name='PolicyCoverageMain' id='PolicyCoverageMain'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="no"  style='height:38vh;width:100vw'></iframe>
		<iframe name='PolicyDetailsTab' id='PolicyDetailsTab'	src='../../eCommon/html/blank.html' frameborder=0  scrolling="no" noresize  style='height:7vh;width:100vw'></iframe>
		<iframe name='PolicyDetailsPage' id='PolicyDetailsPage'	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:10vh;width:100vw'></iframe>	
		<iframe name='PolicyDetailsAdd' id='PolicyDetailsAdd'	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:7vh;width:100vw'></iframe>
		
</HTML>


