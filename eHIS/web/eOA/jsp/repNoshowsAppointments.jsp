<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,eCommon.XSSRequestWrapper" %>

<head>
  <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> </link>
   -->
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eOA/js/repNoshowsAppointments.js'></script>
  <script src="../../eCommon/js/common.js" language="javascript"></script>

</head>
<%
  request.setCharacterEncoding("UTF-8");
  request= new XSSRequestWrapper(request);
  response.addHeader("X-XSS-Protection", "1; mode=block");
  response.addHeader("X-Content-Type-Options", "nosniff");
  String URL = "../../eCommon/jsp/commonToolbar.jsp?";
  String params = request.getQueryString();
  String source = URL + params;
%>


<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
  <iframe name='f_search_criteria' id='f_search_criteria' src='../../eOA/jsp/repNoshowsAppointmentsForm.jsp' scrolling='no' noresize frameborder='0' style='height:80vh;width:100vw'></iframe>
  <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' noresize' frameborder='0' style='height:12vh;width:100vw'></iframe>



