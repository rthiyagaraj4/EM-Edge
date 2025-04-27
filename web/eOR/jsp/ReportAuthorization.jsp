<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReportAuthorization" ;
	String bean_name = "eOR.ReportAuthorizationBean";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//db- String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String practitioner_type = (String)session.getValue("practitioner_type");
	//String patient_id = request.getParameter("patient_id");
	//String encounter_id =	request.getParameter("episode_id");
	String CanelFlag = request.getParameter("CanelFlag");
	if (CanelFlag == null) CanelFlag = "";
	String option_id = request.getParameter("option_id");
	if (option_id == null) option_id = "";

	if(resp_id== null)resp_id = "";
	if(practitioner_id== null)practitioner_id = "";
	if(practitioner_type== null)practitioner_type = "";
	String  isValid = "";
	//if(!practitioner_type.equals("NS"))
	{
		ReportAuthorizationBean bean = (ReportAuthorizationBean)getBeanObject( bean_id, bean_name , request) ;
		bean.setLanguageId(localeName);
		isValid = bean.isAuthorised(practitioner_id,resp_id) ;
	
		putObjectInBean(bean_id,bean,request);
	}

	if(isValid != null)
	{
%>
<frameset rows='30%,*, 4%'>
	<frame name='ReportAuthorizationSearch' id='ReportAuthorizationSearch' src='ReportAuthorizationSearch.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no noresize>
	<!-- <frame name='ReportAuthorizationHeader' id='ReportAuthorizationHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize> -->
	<frame name='ReportAuthorizationResult' id='ReportAuthorizationResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto>
	<frame name='ReportAuthorizationBtn' id='ReportAuthorizationBtn'  src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize>
</frameset>
	<%}else{
	out.println("<script>alert(getMessage(\"PRACT_RESP_AUTH_NO_ACCESS\",\"OR\")); </script>");
		}%>
</html>

