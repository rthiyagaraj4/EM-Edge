<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%--<script>alert('<%=request.getQueryString()%>')</script>--%>
<title><fmt:message key="eOR.OrderSetComponents.label" bundle="${or_labels}"/></title>
</head>
<%  
	//String mode	   = (String)request.getParameter( "mode" ) ;
	//String function_id = (String)request.getParameter( "function_id" ) ;
	String patient_id =		(String)request.getParameter("patient_id");
	String encounter_id =	(String)request.getParameter("episode_id");
	//String pract_reln_id = (String)request.getParameter("relationship_id");
	//String visit_adm_date = (String)request.getParameter("visit_adm_date");

	//String location_type			= (String)request.getParameter("location_type");
	//String location_code			= (String)request.getParameter("location_code");
	String patient_class			= (String)request.getParameter("patient_class");
	//String p_called_from_ca			= (String)request.getParameter("p_called_from_ca ");
	//String sex						= (String)request.getParameter("Sex");
	//String age						= (String)request.getParameter("Age");
	//String dob						= (String)request.getParameter("Dob");


	if(patient_id!=null)
		patient_id = patient_id.trim();
	if(encounter_id!=null)
	encounter_id = encounter_id.trim();
	if(patient_class!=null)
	patient_class = patient_class.trim();

%>

<iframe name='ExistingOrderSearch' id='ExistingOrderSearch' src='../../eCommon/html/blank.html' frameborder=0  scrolling=no noresize style='height:0vh;width:100vw'></iframe>
	<iframe name='ExistingOrderHeader' id='ExistingOrderHeader' src="ExistingOrderHeader.jsp?<%=request.getQueryString()%>&called_from=ORDER_SET" frameborder=0  noresize scrolling=no style='height:60vh;width:100vw'></iframe>
	<iframe name='ExistingOrderResult' id='ExistingOrderResult' src="OrderSetResultsFrameset.jsp?<%=request.getQueryString()%>&called_from=ORDER_SET" frameborder=0 scrolling=auto noresize style='height:40vh;width:100vw'></iframe>

</html>

