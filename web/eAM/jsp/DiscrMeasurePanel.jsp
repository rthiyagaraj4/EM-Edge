<!DOCTYPE html>
<%--
	FileName	: DiscrMeasurePanel.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<script language='javascript' src='../js/DiscreteMeasurePanel.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_dtl' id='f_query_add_mod_dtl' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:43vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:47vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
	<iframe name='dummy' id='dummy' frameborder="0" noresize scrolling="no"  style='height:0vh;width:100vw'></iframe>
</html>

