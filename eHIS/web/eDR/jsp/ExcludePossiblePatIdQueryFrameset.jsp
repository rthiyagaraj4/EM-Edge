<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<iframe name='pat_search' id='pat_search' src='../../eDR/jsp/ExcludePossiblePatIdQuery.jsp' scrolling='no' noresize style='height:19vh;width:100vw;border:none'></iframe>
		<iframe name='dup_display' id='dup_display' src='../../eCommon/html/blank.html'  scrolling='yes' noresize style='height:81vh;width:100vw;border:none'></iframe>
	
</html>

