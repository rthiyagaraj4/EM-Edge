<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eXH/js/DataElementCrossReference.js'></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<!----<script language="javascript" src="../../eXH/js/RearrangementLayer.js" ></script>---->
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
//	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	session.setAttribute("params",params);
%>
	<head>
	<script language='javascript' > 
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
	<frameset rows='48,30,*,30'>
	    <frame name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' >
		<frame name='hr_menu_bar' id='hr_menu_bar' src='../../eXH/jsp/DataElementCrossRefMainTab.jsp' frameborder=0 noresize scrolling='no'>
		<frame name='bodyframe' id='bodyframe' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'>
		<!---<frame name='bodyframe1' id='bodyframe1' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'>------->
		<frame name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp'  frameborder=0 noresize scrolling='no'>
	</frameset>
</html>

