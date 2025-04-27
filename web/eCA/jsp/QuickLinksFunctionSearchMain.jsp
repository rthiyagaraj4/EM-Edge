<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString=request.getQueryString();
%>
<title><%=request.getParameter("title")%></title>
<!-- Modified by kishore kumar N on 08/12/2008 for the CRF 0387
	altered frameset row size. (group_head1 and group_head) 
-->
<iframe name='group_head' id='group_head' src='../../eCA/jsp/QuickLinksFunctionSearchCriteria.jsp?<%=queryString%>' noresize  frameborder='0' marginheight=0 marginwidth=0 scrolling='no' style='height:25vh;width: 98vw;'></iframe>
<iframe name='code_desc' id='code_desc'    src='../../eCommon/html/blank.html'  noresize  scrolling=no frameborder=no marginheight=0 marginwidth=0 style='height:100vh;width:98vw;'></iframe>
<iframe name='group_head1' id='group_head1' src='../../eCommon/jsp/GeneralCancel.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10vh;width:98vw;'></iframe>
</html>

