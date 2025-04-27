<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<iframe name ='PhysicainNoteQuery' marginwidth=0 marginheight=0 frameborder=no scrolling='no'  src="../../eCA/jsp/PhysicianNotesQuery.jsp?<%=request.getQueryString()%>" noresize style='height:25%;width:100vw'></iframe>
	<iframe name ='PhysicainNoteResult' marginwidth=0 marginheight=0 frameborder=no scrolling='auto'  src="../../eCA/jsp/PhysicianNotesResult.jsp?<%=request.getQueryString()%>" noresize style='height:35%;width:100vw'></iframe>
	
	<iframe name ='PhysicainNoteResultDetails' marginwidth=0 marginheight=0 frameborder=no scrolling='auto' src="../../eCommon/html/blank.html" noresize style='height:46%;width:100vw'></iframe>	
 
</html>

