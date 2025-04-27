<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,eCommon.XSSRequestWrapper" %>
    <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

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

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eOA/js/AddModifyApptsrlnum.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> scrolling='no' frameborder='0' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/AddModifyApptsrlInsert.jsp'  frameborder='0' scrolling='auto' style='height:83vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize scrolling='no' frameborder='0' style='height:9vh;width:100vw'></iframe>
</html>

