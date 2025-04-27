<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		
String url			= "../../eCommon/jsp/commonToolbar.jsp?" ;
String params		= request.getQueryString() ;
String source		= url + params ;	
String function_id	= request.getParameter("function_id");

%>
<html>
<head>
<title></title>

	<script language="JavaScript" src="../../ePH/js/DrugInfoEnqPf.js"></script> 
	  <script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>
	

	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize border='2' src="../../ePH/jsp/DrugInfoEnqPfCriteria.jsp?function_id=<%=function_id%>" style='height:86vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:6vh;width:100vw"></iframe>

</html>

