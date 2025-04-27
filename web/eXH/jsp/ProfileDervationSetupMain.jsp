<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='JavaScript' src='../../eXH/js/ProfiledervationRefrence.js'></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<!--<script language="javascript" src="../../eXH/js/" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
//	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params;
	session.setAttribute("params",params);
	//out.println(source);
%>
<!--
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
-->
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eXH/jsp/ProfileDervationSelectMaster.jsp' frameborder=0 noresize scrolling='no' style='height:12.5vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail'  src='../../eCommon/html/blank.html' 	frameborder=0 noresize scrolling='auto'style='height:62.5vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>

</html>

