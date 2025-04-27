<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V200928            72977         NMC-JD-CRF-0059       Mohana Priya K
-->
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script language='javascript' src='../../eBL/js/BLPolicyTypes.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
	String params = request.getQueryString();
	String source = url + params;
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_modify' id='f_query_add_modify' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:80vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

