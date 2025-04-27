<!DOCTYPE html>
<html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block"); 
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%
	String queryString=request.getQueryString();
	String title = request.getParameter("title");
	title = java.net.URLDecoder.decode(title,"UTF-8");
	//out.println("queryString:" +queryString);
%>
<title><%=title%></title>
<iframe name='group_head' id='group_head' src='../../eOT/jsp/OTGeneralSearchCriteria.jsp?<%=queryString%>' noresize  marginheight=0 marginwidth=0 frameborder='0' scrolling='no' style='height:18vh;width:99vw'></iframe>
<iframe name='code_desc' id='code_desc'    src='../../eCommon/html/blank.html'  noresize  scrolling=auto marginheight=0 marginwidth=0 frameborder='0' style='height:72vh;width:99vw'></iframe>
<iframe name='group_tail' id='group_tail' src='../../eCommon/jsp/GeneralCancel.jsp' noresize  marginheight=0 marginwidth=0 frameborder='0' style='height:6vh;width:99vw'></iframe>
</html>

