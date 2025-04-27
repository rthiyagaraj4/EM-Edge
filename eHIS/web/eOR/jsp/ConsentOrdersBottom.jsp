<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function
19/08/2013	  IN038797	   Karthi L		To include the field (Filter) of "Speciality" in the function of "Pending Consent" in Practitioner's homepage
21/10/2015    IN057196	    Ramesh G	Recording Of Consent Form
---------------------------------------------------------------------------------------------------------------
--> 

<%@page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.ConsentOrders"/>
<%-- Mandatory declarations end --%>


<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
 	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	//String bean_id = "Or_ConsentOrders" ;
	//String bean_name = "eOR.ConsentOrders";

	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;

	String practitioner_id	= (String)session.getValue("ca_practitioner_id");
	String facility_id		= (String)session.getValue("facility_id");
	String resp_id			= (String)session.getValue("responsibility_id");


	if(resp_id== null)	resp_id = "";
	
	String source_type		= request.getParameter("location_type");
	String source_code		= request.getParameter("locn");
	String patientId		= request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String function_id		= request.getParameter("function_id");
	String consentRec_order_id		= request.getParameter("consentRec_order_id")== null?"":request.getParameter("consentRec_order_id"); //IN057196
	String speciality_code  = request.getParameter( "speciality_code" )== null?"":request.getParameter( "speciality_code" ); //added for BRU-HIMS-CRF-359 [IN038797]
	if(function_id == null) function_id =""; else function_id = function_id.trim();
	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	//out.println("<script>alert('source_type="+source_type+"')</script>");
	//out.println("<script>alert('source_code="+source_code+"')</script>");
	//out.println("<script>alert('patientId="+patientId+"')</script>");

	if(patientId == null || patientId.equals("null")) {
		// Will be pased from the Menu
		patientId		= request.getParameter("patient_id");
 	}
	if(patientId == null || patientId.equals("null")) 
		patientId =" "; 
	else patientId = patientId.trim();
	//out.println("<script>alert('patient_id="+patientId+"')</script>");

	if(period_from == null || period_from.equals("null")) period_from =" "; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =" "; else period_to = period_to.trim();

	Properties properties			= (Properties) session.getValue( "jdbc" );
	// 	ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id, bean_name, request) ;
	bean.setLanguageId(localeName);
	//ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,patientId, period_from, period_to) ; //commented for BRU-HIMS-CRF-359 [IN038797]
	//IN057196 Start.
		//ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,patientId, period_from, period_to,speciality_code) ; //modified for BRU-HIMS-CRF-359 [IN038797]
		ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,patientId, period_from, period_to,speciality_code,consentRec_order_id) ; //modified for BRU-HIMS-CRF-359 [IN038797]
	//IN057196 End.
	if(PriorityData.size() == 0){
		out.println("<script>parent.ConsentOrderTop.document.consent_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html'</script>");
	}
	//IN29559,starts
	String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
	String orderCategory = request.getParameter("orderCategory")==null?"":request.getParameter("orderCategory");
	if(calledFrom.equals("TASK_LIST"))
	{
	%>
	<frameset cols='0%,*'>
	<!-- 	<frame name='ConsentOrdersBottomLeft' id='ConsentOrdersBottomLeft'	src='ConsentOrdersBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>'  frameborder=0 scrolling='no' noresize>  --> <!--  commented for BRU-HIMS-CRF-359 [IN038797] -->
		<!--  <frame name='ConsentOrdersBottomRight' id='ConsentOrdersBottomRight' src='ConsentOrdersBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&order_by=O&function_id=<%=function_id%>&calledFrom=<%=calledFrom%>&orderCategory=<%=orderCategory%>'  frameborder=0 scrolling='no' noresize> --> <!--  commented for BRU-HIMS-CRF-359 [IN038797] -->
		<!-- IN057196 Start.-->
		 <!-- <frame name='ConsentOrdersBottomLeft' id='ConsentOrdersBottomLeft'	src='ConsentOrdersBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>'  frameborder=0 scrolling='no' noresize>  --> <!--  added for for BRU-HIMS-CRF-359 [IN038797]-->
		 <!-- <frame name='ConsentOrdersBottomRight' id='ConsentOrdersBottomRight' src='ConsentOrdersBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>&order_by=O&function_id=<%=function_id%>&calledFrom=<%=calledFrom%>&orderCategory=<%=orderCategory%>'  frameborder=0 scrolling='no' noresize>  --> <!--  added for BRU-HIMS-CRF-359 [IN038797] -->
		 
		 <frame name='ConsentOrdersBottomLeft' id='ConsentOrdersBottomLeft'	src='ConsentOrdersBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>&consentRec_order_id=<%=consentRec_order_id %>'  frameborder=0 scrolling='no' noresize> <!--  added for for BRU-HIMS-CRF-359 [IN038797]-->
		 <frame name='ConsentOrdersBottomRight' id='ConsentOrdersBottomRight' src='ConsentOrdersBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>&order_by=O&function_id=<%=function_id%>&calledFrom=<%=calledFrom%>&orderCategory=<%=orderCategory%>&consentRec_order_id=<%=consentRec_order_id %>'  frameborder=0 scrolling='no' noresize> 
		<!-- IN057196 End.-->
	</frameset>
	<%
	}
	else
	{
	//IN29559,ends
	%>
	<frameset cols='20%,*'>
	<!--	<frame name='ConsentOrdersBottomLeft' id='ConsentOrdersBottomLeft'	src='ConsentOrdersBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>'  frameborder=0 scrolling='no' noresize> --> <!--  commented for BRU-HIMS-CRF-359 [IN038797] -->
	<!--	<frame name='ConsentOrdersBottomRight' id='ConsentOrdersBottomRight' src='ConsentOrdersBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&order_by=O&function_id=<%=function_id%>'  frameborder=0 scrolling='no' noresize> --> <!--  commented for BRU-HIMS-CRF-359 [IN038797] -->
		<!-- IN057196 Start.-->
		<!--<frame name='ConsentOrdersBottomLeft' id='ConsentOrdersBottomLeft'	src='ConsentOrdersBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>'  frameborder=0 scrolling='no' noresize> --> <!--  added for BRU-HIMS-CRF-359 [IN038797] -->
		<!--<frame name='ConsentOrdersBottomRight' id='ConsentOrdersBottomRight' src='ConsentOrdersBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>&order_by=O&function_id=<%=function_id%>'  frameborder=0 scrolling='no' noresize> --> <!--  added for BRU-HIMS-CRF-359 [IN038797] -->
	
		<frame name='ConsentOrdersBottomLeft' id='ConsentOrdersBottomLeft'	src='ConsentOrdersBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>&consentRec_order_id=<%=consentRec_order_id %>'  frameborder=0 scrolling='no' noresize> <!--  added for BRU-HIMS-CRF-359 [IN038797] -->
		<frame name='ConsentOrdersBottomRight' id='ConsentOrdersBottomRight' src='ConsentOrdersBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>&order_by=O&function_id=<%=function_id%>&consentRec_order_id=<%=consentRec_order_id %>'  frameborder=0 scrolling='no' noresize> <!--  added for BRU-HIMS-CRF-359 [IN038797] -->
		<!-- IN057196 End.-->
	</frameset>
	<!--IN29559,starts-->
	<%
	}
%>
	<!--IN29559,ends-->
</html>
<%
	//putObjectInBean(bean_id,bean,request);
%>

