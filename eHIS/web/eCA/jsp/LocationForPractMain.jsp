<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/LocationforPract.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");	
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	
%>
<iframe name='Result' id='Result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'><!-- QueryResultLocationforPract.jsp -- style='height:57%;width:100vw'></iframe><iframe name='AddModify' id='AddModify' src='../../eCA/jsp/AddModifyLocationforPract.jsp' frameborder=0 noresize style='height:43%;width:100vw'></iframe>

</html>

