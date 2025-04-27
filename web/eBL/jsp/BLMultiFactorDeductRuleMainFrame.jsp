<!DOCTYPE html>
<% /*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230210								MMS-DM-CRF-0209.5			Namrata Charate
*/ %>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
		String params = request.getQueryString();		
		System.out.println("Params in MainFrame: "+params);
		
		String beanId = "bl_MultiFactorDeductRuleBean";
		String beanName = "eBL.MultiFactorDeductRuleBean";

		String beanID1 = "bl_MFDRDiagCatBean";
		String beanName1 = "eBL.MFDRDiagCatBean";
		
		String beanID2 = "bl_MFDRServicesAndItemsBean"; //V230210
		String beanName2 = "eBL.MFDRServicesAndItemsBean"; //V230210
		
		MultiFactorDeductRuleBean policyBean = (MultiFactorDeductRuleBean) getBeanObject(beanId, beanName, request);
		MFDRDiagCatBean policyBean1 = (MFDRDiagCatBean) getBeanObject(beanID1, beanName1, request);
		MFDRServicesAndItemsBean policyBean2 = (MFDRServicesAndItemsBean) getBeanObject(beanID2, beanName2, request); //V230210
		policyBean.clearAll();
		policyBean1.clearAll();
		policyBean2.clearAll(); //V230210
		
%>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js"></script>
</HEAD>
<%
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src='../../eBL/js/BLMultiFactorDeductRule.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



				
		<iframe name='MultiFactorDeductRuleTab' id='MultiFactorDeductRuleTab'	src='../../eBL/jsp/BLMultiFactorDeductRuleTab.jsp?<%=params%>' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
		<iframe name='DrugDiagnosisCategoryDetailsPage' id='DrugDiagnosisCategoryDetailsPage'	src='../../eBL/jsp/BLMultiFactorDeductRuleFrame.jsp?<%=params%>' frameborder=0   noresize scrolling='no' style='height:80vh;width:100vw'></iframe> <!-- V221128 -->
		
		
		
</HTML> 
<%
putObjectInBean("bl_MultiFactorDeductRuleBean",policyBean,request);   
putObjectInBean("bl_MFDRDiagCatBean",policyBean1,request);   
putObjectInBean("bl_MFDRServicesAndItemsBean",policyBean2,request);   //V230210

%>

