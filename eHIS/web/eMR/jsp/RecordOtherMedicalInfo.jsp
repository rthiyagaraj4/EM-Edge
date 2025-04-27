<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script>
	function OnSuccess()
	{
		
		frames[1].frames[1].document.location.reload();
	}
</script>
<script language='javascript' src='../../eMR/js/OtherMedicalEvents.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String patID=request.getParameter("Patient_Id");
%>
	<iframe name='patLine' id='patLine' src='../../eCommon/jsp/pline.jsp?Patient_Id=<%=patID%>' frameborder='no' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='query' id='query' src='../../eMR/jsp/OtherMedicalInfoQueryResult.jsp?Patient_Id=<%=patID%>' frameborder='no' scrolling='auto' noresize style='height:52vh;width:100vw'></iframe>
	<iframe name='addmodify' id='addmodify' src='../../eMR/jsp/OtherMedicalInfoAddModify.jsp?Patient_Id=<%=patID%>' frameborder='no' scrolling='no' noresize style='height:35vh;width:100vw'></iframe>
	<!-- <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
	 -->
</html>

