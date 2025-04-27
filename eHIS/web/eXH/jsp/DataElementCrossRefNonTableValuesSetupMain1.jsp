<!DOCTYPE html>
<html> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<% String params = request.getQueryString() ; 
//System.out.println("params55555555"+params);
%>
	<head>
	<script language='javascript' >
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



 </head>
	<iframe name='applnontablesearch' id='applnontablesearch' src='../../eXH/jsp/DataElementCrossRefNonTableValuesSetup.jsp?<%=params%>' frameborder=0 noresize scrolling='no' style='height:48vh;width:100vw'></iframe>
	<iframe name='applnontablecodesearch' id='applnontablecodesearch' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:52vh;width:100vw'></iframe>
</html>

