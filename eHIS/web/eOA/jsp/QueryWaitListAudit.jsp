<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
%>


<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eOA/js/QueryWaitListAudit.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/QueryWaitListAuditCriteria.jsp'  frameborder=0 scrolling='no' style='height:12vh;width:100vw'></iframe>
	<iframe name='pat_details' id='pat_details' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:3vh;width:100vw'></iframe>
	<iframe name='f_query_add_result' id='f_query_add_result' src='../../eCommon/html/blank.html'  frameborder=0 scrolling='auto' style='height:68vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
</html>

