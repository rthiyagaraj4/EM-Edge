<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../js/OrCommon.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
</head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
    <%	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    %>
	<%
	String patient_id=(request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id"));
	String encounter_id=(request.getParameter("p_encounter_id")==null?"":request.getParameter("p_encounter_id"));
	//String facilityId 	= (String) session.getValue( "facility_id" ) ;
	//patient_id="SD00000866";
  //  encounter_id="10002544";

	%>

<title><fmt:message key="eOR.FutureOrder.label" bundle="${or_labels}"/></title>
<iframe name="future_patient_info" id="future_patient_info" src='../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>&EncounterId=<%=encounter_id%>' frameborder=0 scrolling="no" noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='future_order_hdr' id='future_order_hdr' src='../../eOR/jsp/FutureOrderBottomRightHdr.jsp' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='future_order_dtl' id='future_order_dtl'	src='../../eOR/jsp/FutureOrderBottomRightDtl.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='auto' style='height:70vh;width:100vw'></iframe>
	<iframe name='future_order_btn' id='future_order_btn'	src='../../eOR/jsp/FutureOrderBottomButton.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no' style='height:12vh;width:100vw'></iframe>
</html>

