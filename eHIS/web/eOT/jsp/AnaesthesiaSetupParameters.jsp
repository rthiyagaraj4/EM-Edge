<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 	<script language='javascript' src='../../eOT/js/AnaesthesiaSetUpParameters.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%>  scrolling='no' noresize frameborder='0' style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOT/jsp/AnaesthSetUpParamAddModify.jsp'  noresize frameborder='0' style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp'  noresize scrolling='auto' frameborder='0' style='height:9vh;width:100vw'></iframe>
</html>

