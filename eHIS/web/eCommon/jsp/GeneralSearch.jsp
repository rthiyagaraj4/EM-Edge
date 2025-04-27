<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	request.setCharacterEncoding("UTF-8");	
String queryString=request.getQueryString();
%>
<title><%=request.getParameter("title")%></title>
<iframe name='group_head' id='group_head' src='../../eCommon/jsp/GeneralSearchCriteria.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:15vh;width:98vw'></iframe>
<iframe name='code_desc' id='code_desc'    src='../../eCommon/html/blank.html'  noresize  scrolling=no frameborder=no marginheight=0 marginwidth=0 style='height:65vh;width:98vw'></iframe>
<iframe name='group_head1' id='group_head1' src='../../eCommon/jsp/GeneralCancel.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:8vh;width:98vw'></iframe>
</html>

