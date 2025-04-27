<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<html> 
<head>
<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eMR/js/MarkEncounter.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;	
	String source = url + params ;
	String call_function	= request.getParameter("function_id");	
%>
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eMR/jsp/MedRecRequestCriteria.jsp?call_function=<%=call_function%>&function_id=<%=call_function%>' frameborder=0 scrolling='no' noresize style='height:36vh;width:100vw'></iframe>
	<iframe scrolling="auto" name='resultframe' id='resultframe' src='../../eCommon/html/blank.html'  frameborder=0 style='height:47vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' noresize style='height:9vh;width:100vw'></iframe>				


</html>     

