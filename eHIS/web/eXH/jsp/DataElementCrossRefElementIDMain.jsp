<!DOCTYPE html>
<html> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); 
String rule=request.getParameter("Rule");

//System.out.println("Rule6"+rule);
session.setAttribute("Rule",rule);
String source=request.getParameter("source");

%>
<head>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eXH/js/DataElementCrossReference.js'></script>
<script language='javascript' src='../../eXH/js/DataElementCrossReferencebasicelement.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



 </head>
	<iframe name='applmenubartrans' id='applmenubartrans' src='../../eXH/jsp/DataElementCrossRefElementIDTab.jsp?source=<%=source%>' frameborder=0 noresize scrolling='no' style='height:60vh;width:100vw'></iframe>
	<iframe name='elementIDframetrans' id='elementIDframetrans' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'  style='height:40vh;width:100vw'></iframe>
</html>

