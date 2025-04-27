<!DOCTYPE html>
<html> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<% String params = request.getQueryString() ;
//System.out.println("paramsddss"+params);

%>
	<head>
	<script language='javascript' >
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



 </head>
	<iframe name='applnontable' id='applnontable' src='../../eXH/jsp/DataElementCrossRefNonTableSelection.jsp?<%=params%>' frameborder=0 noresize scrolling='no' style='height:50vh;width:100vw'></iframe>
	<iframe name='applnontablecode' id='applnontablecode' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:50vh;width:100vw'></iframe>
</html>

