<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper"  %>
<html>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
 String oper_stn_id=request.getParameter("oper_stn_id");%>
 <head>
 <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 </head>
<iframe name='top' id='top' src='../../eOA/jsp/BlockapptslotQueryCriteria.jsp?oper_stn_id=<%=oper_stn_id%>' scrolling='no' noresize style='height:21vh;width:100vw' frameborder="0"></iframe>
	<iframe name='bottom' id='bottom' src='../../eCommon/html/blank.html' scrolling='no' noresize style='height:77vh;width:100vw' frameborder="0"></iframe>

</html>

