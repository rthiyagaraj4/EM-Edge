<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>

<html>
<head>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="Common.ModifyWaitList.label" bundle="${common_labels}"/></title>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String s=request.getQueryString();
%>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/WaitListModify.jsp?<%=s%>'  frameborder=0 scrolling='auto' style='height:98vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:2vh;width:100vw'></iframe>
</html>

