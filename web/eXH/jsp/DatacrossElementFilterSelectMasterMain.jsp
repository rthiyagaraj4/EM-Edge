<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<!--<script language="javascript" src="../../eXH/js/" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params;
	//out.println(source);
%>
 

	
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:3vh;width:100vw'></iframe>

	    <iframe name='bodyframe_combo' id='bodyframe_combo' src='../../eXH/jsp/FilterLayerSelectMaster.jsp' frameborder=0 noresize scrolling='no' style='height:1vh;width:100vw'></iframe>
		<iframe name='bodyframe_visible' id='bodyframe_visible' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
		<iframe name='bodyframe_visible2' id='bodyframe_visible2' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:30vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
</html> 

