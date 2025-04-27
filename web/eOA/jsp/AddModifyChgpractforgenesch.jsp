<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,eCommon.XSSRequestWrapper"%>
    <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
  <head>
   <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
   <script language='javascript' src='../../eCommon/js/common.js'></script>
   <script language='javascript' src='../../eOA/js/ChangePractitionerforGenSch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

     <%
	 request.setCharacterEncoding("UTF-8");	
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
       String url="../../eCommon/jsp/commonToolbar.jsp?";
       String param = request.getQueryString();
       String source = url+param;
     %>
  </head>

  <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%= source%>' scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
     <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/ChangePractitionerforGenSchMain.jsp' style='height:83vh;width:100vw' scrolling='no' frameborder='0'></iframe>
     <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' noresize  style='height:9vh;width:100vw'></iframe>
  

</html>

