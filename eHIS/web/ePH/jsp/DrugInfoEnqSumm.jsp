<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<!--
Developed by    : Karabi Sarma
Module/Function : Drug Infomation Summary  ( Reports)
-->

<html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
String url			= "../../eCommon/jsp/commonToolbar.jsp?" ;
String params		= request.getQueryString() ;
String source		= url + params ;	
String function_id	= request.getParameter("function_id");
%>
<head>
<title></title>
   <%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../ePH/js/DrugInfoEnqDtlRep.js"></script> 
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>

	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize border='2' src="../../ePH/jsp/DrugInfoEnqDtlRepCriteria.jsp?function_id=<%=function_id%>" style='height:86vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:6vh;width:100vw"></iframe>

</html>

