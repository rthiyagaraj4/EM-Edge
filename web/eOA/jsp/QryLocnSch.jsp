<!DOCTYPE html>


<%@ page contentType="text/html;charset=UTF-8"  import = "java.sql.*,eCommon.XSSRequestWrapper" %>
<head>
   <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

   <script language='javascript' src='../../eCommon/js/common.js'></script>
      <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
   <script language='javascript' src='../../eOA/js/QueryLocnSchedule.js'></script>
</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
   String URL = "../../eCommon/jsp/commonToolbar.jsp?";
   String params = request.getQueryString();
   String source = URL+params;
 %>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameBorder=0; scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
   <iframe name='f_query_search' id='f_query_search' src='../../eOA/jsp/QueryLocnSchedule.jsp' frameBorder=0; noresize scrolling='no' style='height:20vh;width:100vw'></iframe>
   <iframe name='f_query_search_result' id='f_query_search_result' src='../../eCommon/html/blank.html' frameBorder=0; noresize scrolling='auto' style='height:55vh;width:100vw'></iframe>
   <iframe name='f_query_search_footer' id='f_query_search_footer' src='../../eCommon/html/blank.html' frameBorder=0; scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
   <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameBorder=0; scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>


