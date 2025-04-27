<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
		request.setCharacterEncoding("UTF-8");
		String url = "../../eCA/jsp/EpisodeCycle.jsp?" ;
		String url1 = "../../eCA/jsp/SpltyEpisode.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		String source1 = url1 + params ;
%>


<iframe name='cycleHeading' id='cycleHeading' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8%;width:100vw'></iframe>
	<iframe name='cycleDetail' id='cycleDetail' src=<%=source1%> frameborder=0 scrolling='yes' noresize style='height:100vh;width:100vw'></iframe>

</html>

