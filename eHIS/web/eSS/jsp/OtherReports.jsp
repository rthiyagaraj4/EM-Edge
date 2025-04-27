<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<head>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.*, eSS.Common.* , eCommon.Common.*" %>

<%
request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
</link>
	<script language='javascript' src='../../eSS/js/OtherReports.js'></script>
	<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
	<script language='javascript' src='../../eSS/js/SsTransaction.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%=request.getParameter( "function_id" ) %>"
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

 <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
 <iframe name='frameReportHeader' id='frameReportHeader' src="../../eSS/jsp/OtherReportsList.jsp?function_id=<%=request.getParameter( "function_id" ) %>" frameborder=0 scrolling='no' style='/*height:80vh;*/width:100vw'></iframe>
 <iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' noresize style='height:59vh;width:100vw'></iframe>
 <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

