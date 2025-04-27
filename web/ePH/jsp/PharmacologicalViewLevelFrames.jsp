<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<html>
<head>
<%
	String url = "../../ePH/jsp/PharmacologicalCloseLevel.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
	<iframe name='f_level_descs' id='f_level_descs' src="../../ePH/jsp/PharmacologicalViewLevel.jsp?" frameborder=0 scrolling='yes' noresize bgcolor="navy" style='height:90vh;width:100vw'></iframe><iframe name='f_close_levels' id='f_close_levels' src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
	
</head>
</html>

