<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>


<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	%>
	<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_RegisterOrder" ;
	String bean_name = "eOR.RegisterOrder";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id"); 
	if(resp_id== null)resp_id = "";
	if(practitioner_id== null)practitioner_id = "";

//out.println(">"+practitioner_id+"<");
//out.println(">"+resp_id+"<");

	RegisterOrder bean = (RegisterOrder)getBeanObject( bean_id, bean_name,request) ; 
	bean.setLanguageId(localeName);

	String  isValid = "";
	isValid = bean.isAuthorised(practitioner_id,resp_id) ;
	//out.println("isValid :>"+isValid+"<<BR>");
	if( !((isValid.trim()).equals(""))){

%>
<!-- <frameset rows='34%,*%,6%'> -->
	<iframe name='RegisterOrderSearch' id='RegisterOrderSearch' src='RegisterOrderSearch.jsp' frameborder=0 scrolling=no noresize style='height:31vh;width:100vw'></iframe>
	<!-- 	<frame name='RegisterOrderHeader' id='RegisterOrderHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize> -->
	<iframe name='RegisterOrderResult' id='RegisterOrderResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize style='height:64vh;width:100vw'></iframe>
	<iframe name='RegisterOrderBtn' id='RegisterOrderBtn'	  src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='height:5vh;width:100vw'></iframe>
<!-- </frameset> -->
	<%}else{		
	out.println("<script>alert(getMessage('PRACT_RESP_CANNOT_REGISTER','OR'));</script> ");
		}%>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

