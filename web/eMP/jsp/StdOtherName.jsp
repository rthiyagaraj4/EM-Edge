<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,eCommon.XSSRequestWrapper" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
    <script language='javascript' src='../js/StdOtherName.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
        String params = request.getQueryString() ;
        String source = url + params ;
%>
    <iframe name='commontoolbarFrame' id='commontoolbarFrame'    src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
                <iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html' frameborder=0 scrolling='NO' style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'      src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

