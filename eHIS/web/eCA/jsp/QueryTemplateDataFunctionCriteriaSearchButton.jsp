<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//	java.util.Properties property = (java.util.Properties) session.getAttribute( "jdbc" ) ;
	String qryRef = request.getParameter("qryRef")==null?"":request.getParameter("qryRef");
	String qryDesc = request.getParameter("qryDesc")==null?"":request.getParameter("qryDesc");
%>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCA/js/QueryTemplateDataFunction.js"></script>
		<title></title>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table width='100%' cellpadding='3' cellspacing='0' border='0'>
			<tr>
				<td colspan='2' align='right' width='35%'>
					<input type='button' value='Search' onclick="search('<%=qryDesc%>')">
					<input type='button' value='Clear' onclick='reload("<%=qryRef%>")'>
				</td>
			</tr>
	</table>
</body>
</html>

