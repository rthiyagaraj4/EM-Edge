<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>	 -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
		
		String called_from = request.getParameter("called_from");
%>
<iframe name='Search' id='Search'	src='../../eFM/jsp/FMFileTypeforFSLocnSearch.jsp?called_from=<%=called_from%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
	<iframe name='Result' id='Result' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:70vh;width:100vw'></iframe>
	<iframe name='Dummy' id='Dummy' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

</html>

