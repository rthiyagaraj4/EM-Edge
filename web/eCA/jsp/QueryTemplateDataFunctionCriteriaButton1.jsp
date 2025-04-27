<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
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
			<td align='right'><input type='button' value='<fmt:message key="Common.criteria.label" bundle="${common_labels}"/>' onclick='showCriteria("<%=qryRef%>","<%=qryDesc%>")'></td>
		</tr>
	</table>
</body>
</html>

