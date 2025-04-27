<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCA/js/repResetRunList.js" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	StringBuffer source = new StringBuffer();
	source.append(params) ;
%>
    <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= url+source.toString() %> frameborder='0' scrolling='no'  style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='menuFrame' id='menuFrame' src='../../eCA/jsp/repMasterCodeList.jsp'    frameborder=0 style='height:10vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  frameborder=0 style='height:70vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0  scrolling='auto' style='height:20vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_intermediate' id='f_query_intermediate' src='../../eCommon/html/blank.html'  frameborder=0 style='height:0%;width:100vw'></iframe>
</html>

