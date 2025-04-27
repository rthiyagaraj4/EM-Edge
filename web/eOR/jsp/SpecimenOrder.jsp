<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<title><fmt:message key="eOR.SpecimenOrder.label" bundle="${or_labels}"/> </title>
 	<script language="JavaScript" src="../js/SpecimenOrder.js"></script>
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
	//String bean_id = "Or_SpecimenOrder" ;
	//String bean_name = "eOR.SpecimenOrder";

//	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	//String resp_id = (String)session.getValue("responsibility_id"); 
//	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String mod_qry_str   = request.getQueryString();
	//if(resp_id== null)resp_id = "";
//	if(practitioner_id== null)practitioner_id = "";


	//SpecimenOrder bean = (SpecimenOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	

//	String  isValid = "hf";
//	isValid = bean.isAuthorised(practitioner_id,resp_id) ;
	//out.println(isValid);
	//if(isValid != null){

%>
<frameset rows='45%,*,6%'>
	<frame name='SpecimenOrderSearch' id='SpecimenOrderSearch' src='../jsp/SpecimenCollectionListAndLabelSearch.jsp?<%=mod_qry_str%>' frameborder=0 scrolling=no noresize>
	<!-- 	<frame name='SpecimenOrderHeader' id='SpecimenOrderHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize> -->
	<frame name='SpecimenOrderResult' id='SpecimenOrderResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize>
	<frame name='SpecimenOrderBtn' id='SpecimenOrderBtn' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize>
	<frame name=messageFrame src='../../eCommon/html/blank.html' frameborder=0 noresize>
</frameset>
	<%//}else{		
	//out.println("<script>alert('Not Authorised ...'); ");
		//}
		%>
</html>

