<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
	<%@ page session="false" %>
 	<script language='javascript' src='../../eOH/js/MTasksLink.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
		String params = request.getQueryString();
		String source = url + params;
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' style='height:8vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' fra</iframe>meborder=0>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'>
		<iframe name='hidden_frame' id='hidden_frame'	frameborder="0" src='../../eOH/jsp/CommonMasterObjectCollect.jsp'  noresize style='height:50%;width:100vw'></iframe>
	
</html>

