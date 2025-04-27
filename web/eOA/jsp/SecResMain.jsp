<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*, java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<html>
<head>
<title><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/>
</title>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String s=request.getQueryString();


%>

<iframe name='f_query_add_mod2' id='f_query_add_mod2' src='../../eOA/jsp/SecondaryResources.jsp?<%=s+"&from=SecResFunc"%>'  frameborder=0 scrolling='auto'  style='height:95vh;width:100vw'></iframe>
<iframe name='f_query_add_mod3' id='f_query_add_mod3' src='../../eOA/jsp/SecResButtons.jsp?<%=s%>'  frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
		

</html>

