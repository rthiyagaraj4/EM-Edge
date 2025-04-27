<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<%@ page  contentType="text/html;"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.*,eCommon.XSSRequestWrapper "  %>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString=request.getQueryString();
//out.println("<script> alert(\" in search queryString:---"+queryString+"\"); </script>");
  
%>

<title>Practitioner</title>
<iframe name='criteria_frame' id='criteria_frame' src='../../eOR/jsp/NewPractLookupQueryCriteria.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:23.5vh;width:100vw'></iframe>
<iframe name='result_frame' id='result_frame'    src='../../eCommon/html/blank.html'  noresize  scrolling=no frameborder=no marginheight=0 marginwidth=0 style='height:72vh;width:100vw'></iframe>
<iframe name='close_frame' id='close_frame' src='../../eOR/jsp/NewPractLookupBtn.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:4.5vh;width:100vw'></iframe>
</html>

