<!DOCTYPE html>
<%--
	FileName	: DiscreteMeasure.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>

<%@ page import ="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String params = request.getQueryString() ;
		
	%>
</head>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<iframe src="DiscrMeasureSetup.jsp?query_string=<%=params%>" name="master_menu" id="master_menu" scrolling='no' noresize></iframe>
		<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages"></iframe>
</html>


