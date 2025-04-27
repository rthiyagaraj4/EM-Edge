<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<html>
<head>
	<script language='javascript' src='../js/ChangePatientPhoneNo.js'></script>
	<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function query(){ 
			plineFrame.location.href ="../../eCommon/html/blank.html";
			f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=12";
		}
	</script>
</head>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='plineFrame' id='plineFrame'    src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/blank.jsp?step_1=12' frameborder=0 noresize scrolling='auto' style='height:75vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>


	

