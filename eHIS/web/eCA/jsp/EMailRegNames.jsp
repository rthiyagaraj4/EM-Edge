<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<title><%=request.getParameter("title")%></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/EMail.js"></script>
<iframe name='emailRegCriteriaFrame' id='emailRegCriteriaFrame' src='../../eCA/jsp/EMailRegCriteria.jsp?<%=request.getQueryString()%>' scrolling='no' style='height:31%;width:100vw'></iframe>
	<iframe name='emailRegDetailFrame' id='emailRegDetailFrame' src='../../eCommon/html/blank.html' scrolling='no' style='height:100vh;width:100vw'></iframe>


