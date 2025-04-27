<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>


<html>
<head>
	<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../js/DayoftheWeek.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<%
    request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/MstCodeToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;		
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>				
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eSM/jsp/DayoftheWeek.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/MstCodeError.jsp'frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

