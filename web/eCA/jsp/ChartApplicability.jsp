<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/ChartApplicability.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
		String param = request.getQueryString();
		String src = url + param;
	%>	
		<iframe src="<%=src%>" name='commontoolbarFrame' scrolling = "no" noresize style='height:8vh;width:100vw;border:none'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='f_query_add_mod' id='f_query_add_mod' scrolling = "auto" noresize style='height:83vh;width:100vw;border:none'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='blankFrame' id='blankFrame' style='height:0vh;width:100vw;border:none'></iframe>
		<iframe src="../../eCommon/jsp/MstCodeError.jsp" name='messageFrame' id='messageFrame' scrolling = "auto" noresize style='height:9vh;width:100vw;border:none'></iframe>
	
</html>

