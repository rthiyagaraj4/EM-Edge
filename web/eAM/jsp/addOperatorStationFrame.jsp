<!DOCTYPE html>
<%--
	FileName	: addOperatorStationFrame.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAM/js/OperatorStation.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
<%
	String queryString = request.getQueryString();
	

%>

	<iframe src="../../eAM/jsp/addOperatorStation.jsp?<%=queryString%>" name="addOperatorStationFrame" id="addOperatorStationFrame" frameborder=0 scrolling='no' noresize style='height:15vh;width:98vw'></iframe>
	<%if(queryString == null || queryString.equals("")){%>
	<iframe src="../../eCommon/html/blank.html" name="addOperatorStationDetailsFrame" id="addOperatorStationDetailsFrame" frameborder=0 scrolling='no' noresize style='height:10vh;width:98vw'></iframe>
	<%} else { %>
	<iframe src="../../eAM/jsp/OperatorStationtabs.jsp?<%=queryString%>" name="addOperatorStationtabs" frameborder=0 scrolling='no' noresize style='height:13vh;width:98vw'></iframe>
	<%}%>
	<%if(queryString == null || queryString.equals("")){%>
	<iframe src="../../eCommon/html/blank.html" name="addOperatorStationDetailsFrame" id="addOperatorStationDetailsFrame" frameborder=0 scrolling='no' noresize style='height:73vh;width:98vw'></iframe>
	<%} else { %>
	<iframe src="../../eAM/jsp/addOperatorStationDetails.jsp?<%=queryString%>" name="addOperatorStationDetailsFrame" frameborder=0 scrolling='no' noresize style='height:73vh;width:98vw'></iframe>
	<%}%>

</html>

