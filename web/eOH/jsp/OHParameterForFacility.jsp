<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head >
 	<script src="../../eOH/js/OHParameterForFacility.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>
	<!-- <frameset rows='10%,42%,42%,*'> -->
	<frameset rows='10%,44%,42%,*'>
		<frame name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no'>
		<frame name='f_query_add_mod' id='f_query_add_mod' src='../../eOH/jsp/OHParameterForFacilityAddModify.jsp' frameborder=0>
		<!-- <frame name='f_query_add_mod_gs' id='f_query_add_mod_gs'  src="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp" frameborder=0> -->
		<frame name='f_query_add_mod_gs' id='f_query_add_mod_gs'  src="../../eCommon/html/blank.html" frameborder=0>
		<frame name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'> 
	</frameset>

</html>

