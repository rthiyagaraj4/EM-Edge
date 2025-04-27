<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"  %>

<html>
<head>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eOA/js/PractDutyRoster.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String oper_stn_id=request.getParameter("oper_stn_id");%>

<iframe name='query' id='query'  MARGINWIDTH=0 MARGINHEIGHT=0  FRAMEBORDER=NO scrolling="no" src='../../eOA/jsp/PractDutyRosterQueryCriteria.jsp?oper_stn_id=<%=oper_stn_id%>'  style='height:80vh;width:100vw'></iframe>
	<iframe name ='blank' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO   src='../../eCommon/html/blank.html'   style='height:0vh;width:100vw'></iframe>

</html>

