<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
25/04/2016	IN067051     Devindra							                Enhance TPN Ordering Functionality
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PHmessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNRegimen.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNStdRegimen.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.StandardRegimenLookup.label" bundle="${ph_labels}"/></title>
</HEAD>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String url						="../../ePH/jsp/TPNRegStdRegCriteria.jsp?" ;
	String params				= request.getQueryString() ;
	String source					= url + params ;
	String patient_id				= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String bean_id				= "@TPNRegimenBean"+patient_id+encounter_id;
	String bean_name			= "ePH.TPNRegimenBean";
	TPNRegimenBean bean	= (TPNRegimenBean)getBeanObject(bean_id,bean_name,request) ;
	String bean_id1				= "TPNStandardRegimenBean";
	String bean_name1		= "ePH.TPNStandardRegimenBean";

	TPNStandardRegimenBean bean1 = (TPNStandardRegimenBean)getBeanObject(bean_id1,bean_name1,request);

	String cho						=bean.getCabohydrateOrderQuantity();
	String protein					=bean.getProteinOrderQuantity();
	String lipid						=bean.getLipidOrderQuantity();
	String cunit					=bean.getCabohydrateOrderQuantityUnit();
	String punit					=bean.getProteinOrderQuantityUnit();
	String lunit						=bean.getLipidOrderQuantityUnit();
	String unit						=bean1.getUnit();
	String assesMentReqYn           = "Y"; // Added for ML-MMOH-CRF-1126 - Start
	if(!bean.chkAssesmentApplicableYn().equals("Y") && bean.isSiteSpecific("PH", "ASSESMENT_REQ_YN")){ 
	   assesMentReqYn = "N";
	} // Added for ML-MMOH-SCF-1126 -End
	
	//out.println("<script>alert('"+unit+"')</script>");
	if (cunit==""||cunit.equals(""))
	{
		//get units from the databse
		cunit=unit;
	
	}
	if (punit==""||punit.equals(""))
	{
		//get units from the databse
		punit=unit;
	
	}
	if (lunit==""||lunit.equals(""))
	{
		//get units from the databse
		lunit=unit;
	
	}

	source	=source+"&cho="+cho+"&protein="+protein+"&lipid="+lipid+"&cunit="+cunit+"&punit="+punit+"&lunit="+lunit+"&assesMentReqYn="+assesMentReqYn; // assesMentReqYn Added for ML-MMOH-CRF-1126
	
%>
<iframe name="f_queryCriteria" id="f_queryCriteria" frameborder="0" scrolling="no" noresize src="<%=source%>" style="height:46vh;width:100vw"></iframe>
<iframe name="f_addqueryCriteria" id="f_addqueryCriteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/TPNRegStdRegAddCriteria.jsp" style="height:21vh;width:100vw"></iframe>
<iframe name="f_resultframe" id="f_resultframe" src="../../eCommon/html/blank.html" frameborder="0" scrolling="auto" style="height:0vh;width:100vw"></iframe>
</html>	
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean1,request);
%>

