<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%--
	FileName	: addOperatorStationRstrnFrames.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<html>
<head>
	<script language='javascript' src='../../eCommon/js/common.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");%>
<%
		String queryString = request.getQueryString();
		
		
%>
<frameset rows="21%,60,*,0%" >
	<frame src="../../eAM/jsp/addOperatorStationRstrn.jsp?<%=queryString%>" name="addOperatorStationRstrnFrame" frameborder=0 scrolling='no' noresize>

	<%if(queryString == null || queryString.equals("")){%>
	<frame src="../../eCommon/html/blank.html" name="addOperatorStationRstrnTabsFrame" id="addOperatorStationRstrnTabsFrame" frameborder=0 scrolling='no' noresize>
	<%} else { %>
	<frame src="../../eAM/jsp/OperatorStationRstrntabs.jsp?<%=queryString%>" name="addOperatorStationRstrnTabsFrame" frameborder=0 scrolling='no' noresize>
	<%}%>
  
	<%if(queryString == null || queryString.equals("")){%>
	<frame src="../../eCommon/html/blank.html" name="addOperatorStationRstrnDetailsFrame" id="addOperatorStationRstrnDetailsFrame" frameborder=0 scrolling='no' noresize>
	<%} else { %>
	<frame src="../../eAM/jsp/addOperatorStationRstrnDetails.jsp?<%=queryString%>" name="addOperatorStationRstrnDetailsFrame" frameborder=0 scrolling='no' noresize>
	<%}%>
		 <frame src="" name="ForselectBox" id="ForselectBox" frameborder=0 scrolling='no' noresize>
</frameset>
</html>

