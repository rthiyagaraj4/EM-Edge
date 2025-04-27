<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String params = request.getQueryString();
String module_id	=	request.getParameter("MODULE_ID") ;
if(module_id == null )
	module_id="";
if(module_id.equals("PH")){
	module_id="Yes";
}else{
	module_id="No";
}

%>
<html>
<head>
<title><fmt:message key="eMP.ViewPatientDetails.label" bundle="${mp_labels}"/></title>
</head>
<iframe src="../../eOA/jsp/QueryApptForPatientResult.jsp?<%=params%>" name="f_query_add_mod" name="f_query_add_mod" NORESIZE   scrolling="<%=module_id%>" style="height:100vh;width:100vw"></iframe>
<iframe src="../../eCommon/jsp/error.jsp?" name="messageFrame" id="messageFrame" NORESIZE scrolling="no" style="height:0vh;width:100vw"></iframe>
</html>

