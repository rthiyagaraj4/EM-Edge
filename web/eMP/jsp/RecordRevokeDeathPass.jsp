<!DOCTYPE html>
<%@ page import ="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<script language='javascript' src='../../eCommon/js/common.js'></script> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eMP/js/RecordRevokeDeath.js'></script>
<!--<script language='javascript' src='../../eMP/js/dchk.js'></script>-->
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='plineFrame' id='plineFrame'    src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMP/jsp/blank.jsp?step_1=2' frameborder=0 scrolling='auto' style='height:75vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

