<!DOCTYPE html>
<!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
04/13/2017      KDAH-CRF-0338     Devindra/Mukesh    Inclusion of Bed No in the Fill and Deliver screen in Dispense Medication.
---------------------------------------------------------------------------------------------------------------
*/ -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedication.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	String issue_token_on_regn = request.getParameter("issue_token_on_regn");
	String disp_locn_catg      = request.getParameter("disp_locn_catg");
	String function_id		   = CommonBean.checkForNull(request.getParameter("function_id"));
	String homepage		   = CommonBean.checkForNull(request.getParameter("homepage"));//Added for Bru-HIMS-CRF-073.1 [IN:047222]
	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;

   //bean.getAllowShortexpiary_yn();

	if(issue_token_on_regn.equals("Y") && disp_locn_catg.equals("O")){
%>
<iframe name="f_query_criteria_token_info" id="f_query_criteria_token_info" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaTokInfo.jsp?homepage=<%=homepage%>"  style="height:6vh;width:100vw"></iframe>
<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationQueryCriteria.jsp?function_id=<%=function_id%>&homepage=<%=homepage%>" style="height:0vh;width:100vw"></iframe>
<iframe name="f_query_criteria_buttons" id="f_query_criteria_buttons" src="../../ePH/jsp/DispMedicationQueryCriteriaButtons.jsp?function_id=<%=function_id%>&homepage=<%=homepage%>" frameborder="0" noresize scrolling="no" style="height:7vh;width:100vw"></iframe>
<iframe name="f_query_criteria_additional" id="f_query_criteria_additional" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaAddn.jsp?homepage=<%=homepage%>" style="height:0vh;width:100vw"></iframe>
<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationDetailFrameSet.jsp?homepage=<%=homepage%>" style="height:70vh;width:100vw"></iframe>	
<%
	}else if (issue_token_on_regn.equals("N") && disp_locn_catg.equals("O")){
%>
<iframe name="f_query_criteria_token_info" id="f_query_criteria_token_info" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaTokInfo.jsp?homepage=<%=homepage%>"  style="height:0vh;width:100vw;display: none;"></iframe>
<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationQueryCriteria.jsp?function_id=<%=function_id%>&homepage=<%=homepage%>" style="height:33vh;width:100vw"></iframe>
<iframe name="f_query_criteria_buttons" id="f_query_criteria_buttons" src="../../ePH/jsp/DispMedicationQueryCriteriaButtons.jsp?function_id=<%=function_id%>&homepage=<%=homepage%>" frameborder="0" noresize scrolling="no" style="height:7vh;width:100vw"></iframe>
<iframe name="f_query_criteria_additional" id="f_query_criteria_additional" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaAddn.jsp?homepage=<%=homepage%>" style="height:0vh;width:100vw"></iframe>
<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationDetailFrameSet.jsp?homepage=<%=homepage%>" style="height:70vh;width:100vw"></iframe>	
<%
	}else if ( disp_locn_catg.equals("IAE"))//this condition is added by Himanshu 
	{
		String stage=bean.getDispStage();
		String fill_list = bean.getFillList();
		String strRows = "0,150,*,0,0";
		%>
		
				<iframe name="f_query_criteria_token_info" id="f_query_criteria_token_info" frameborder="0" scrolling="no" noresize src="" style="height:0vh;width:100vw;display: none;" ></iframe>
				<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaForIP.jsp?stage=<%=stage%>&fill_list=<%=fill_list%>&function_id=<%=function_id%>&homepage=<%=homepage%>" style="height:33vh;width:100vw"></iframe>
				<iframe name="f_query_criteria_buttons" id="f_query_criteria_buttons" src="../../ePH/jsp/DispMedicationQueryCriteriaButtons.jsp?function_id=<%=function_id%>&homepage=<%=homepage%>" frameborder="0" noresize scrolling="no" style="height:7vh;width:100vw"></iframe>
				<iframe name="f_query_criteria_additional" id="f_query_criteria_additional" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaAddn.jsp?homepage=<%=homepage%>" style="height:0vh;width:100vw"></iframe>
				<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationDetailFrameSet.jsp?homepage=<%=homepage%>" style="height:70vh;width:100vw">	</iframe>
			
		<%
			}
else if(disp_locn_catg.equals("I")){
		String stage=bean.getDispStage();
		String fill_list = bean.getFillList();
		String strRows = "0,85,*,0,0";
		if(stage.equals("D") && fill_list.equals("DWF")){
			strRows = "0,63,*,0,0";
		} 
		else {
			strRows = "0,150,*,0,0"; // 135 changed to 150 for KDAH-CRF-0338
		}
		if(stage.equals("D") && fill_list.equals("DWF")) {
%>
			
				<iframe name="f_query_criteria_token_info" id="f_query_criteria_token_info" frameborder="0" scrolling="auto" noresize src="" style="height:0vh;width:100vw;display: none;"></iframe>
				<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaForIP.jsp?stage=<%=stage%>&fill_list=<%=fill_list%>&function_id=<%=function_id%>&homepage=<%=homepage%>" style="height:63vh;width:100vw"></iframe>
				<iframe name="f_query_criteria_buttons" id="f_query_criteria_buttons" src="../../ePH/jsp/DispMedicationQueryCriteriaButtons.jsp?function_id=<%=function_id%>&homepage=<%=homepage%>" frameborder="0" noresize scrolling="auto" style="height:7vh;width:100vw"></iframe>
				<iframe name="f_query_criteria_additional" id="f_query_criteria_additional" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaAddn.jsp?homepage=<%=homepage%>" style="height:0vh;width:100vw"></iframe>
				<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationDeliveryFrames.jsp?homepage=<%=homepage%>" style="height:70vh;width:100vw"></iframe>	
			
<%
		} else { 
		
%>
				<iframe name="f_query_criteria_token_info" id="f_query_criteria_token_info" frameborder="0" scrolling="auto" noresize src="" style="height:0vh;width:100vw;display: none;"></iframe>
				<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaForIP.jsp?stage=<%=stage%>&fill_list=<%=fill_list%>&function_id=<%=function_id%>&homepage=<%=homepage%>" style="height:33vh;width:100vw"></iframe>
				<iframe name="f_query_criteria_buttons" id="f_query_criteria_buttons" src="../../ePH/jsp/DispMedicationQueryCriteriaButtons.jsp?function_id=<%=function_id%>&homepage=<%=homepage%>" frameborder="0" noresize scrolling="auto" style="height:7vh;width:100vw"></iframe>
				<iframe name="f_query_criteria_additional" id="f_query_criteria_additional" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaAddn.jsp?homepage=<%=homepage%>" style="height:0vh;width:100vw"></iframe>
				<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationDetailFrameSet.jsp?homepage=<%=homepage%>" style="height:70vh;width:100vw"></iframe>	
		
<%
		}
	}
%>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>

