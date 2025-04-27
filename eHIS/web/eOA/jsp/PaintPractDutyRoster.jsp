<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"  %>
  
<html>
<head>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eOA/js/PractDutyRoster.js'>


function onSuccess() 
{
	f_query_add_mod.location.href = "../../eOA/jsp/PaintPractDutyRoster.jsp" ;
}

<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String oper_stn_id=request.getParameter("oper_stn_id");
%>


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='summary' id='summary'  MARGINWIDTH=0 MARGINHEIGHT=0  FRAMEBORDER=NO  scrolling='no' src='../../eOA/jsp/addmodifyPractDutyRoster.jsp?oper_stn_id=<%=oper_stn_id%>' noresize style='height:30vh;width:98vw'></iframe>
	<iframe name ='detail' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO    src='../../eCommon/html/blank.html'   style='height:70vh;width:98vw'></iframe>

</html>

