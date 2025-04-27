<!DOCTYPE html>
<html>			 
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<SCRIPT LANGUAGE="JAVASCRIPT" SRC="../../eCommon/js/common.js" ></SCRIPT>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="../../eXH/js/ManageQueue.js" ></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
</head>
<c:set var="url" value="../../eCommon/jsp/commonToolbar.jsp?"/>
<c:set var="params" value="<%= request.getQueryString() %>" />
<c:set var="moduleID" value="${param.module_id}" />
<c:set var="source" value="${url} + ${params}" />

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='${source}' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='queueQueryFrame' id='queueQueryFrame' src="../../eXH/jsp/QueueQueryCriteria.jsp?${params}" frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
	<iframe name='queueResultFrame' id='queueResultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:75vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>

</html>

																	   		    

