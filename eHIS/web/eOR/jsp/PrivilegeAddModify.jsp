<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%@ page session="false" import="eCommon.XSSRequestWrapper" %>
</head>
<%
	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode= request.getParameter("mode");
	String function_id= request.getParameter("function_id");
	String privilege_ctx_id= request.getParameter("privilege_ctx_id");
	//out.println("<script>alert("Function_id"+function_id+request);</script>");
%>
<iframe name='f_query_add_mod_header' id='f_query_add_mod_header' src='../../eOR/jsp/PrivilegeAddModifyHeader.jsp?mode=<%=mode%>&function_id=<%=function_id%>&privilege_ctx_id=<%=privilege_ctx_id%>'  noresize scrolling=auto frameborder=0 style='height:15vh;width:100vw'></iframe>
<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='../../eOR/jsp/PrivilegeAddModifyDetail.jsp?mode=<%=mode%>&function_id=<%=function_id%>&action=create&privilege_ctx_id=<%=privilege_ctx_id%>' frameborder=0 scrolling=auto noresize style='height:80vh;width:100vw'></iframe>

	<iframe name='f_query_add_mod_detail_display_value' id='f_query_add_mod_detail_display_value' 	src="../../eOR/jsp/PrivilegeAddModifyDetailDisplayValue.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling=auto style='height:5vh;width:100vw'></iframe>


