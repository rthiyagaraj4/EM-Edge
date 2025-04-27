<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//java.util.Properties property = (java.util.Properties) session.getAttribute( "jdbc" ) ;
	String qryDesc = request.getParameter("qryRef")==null?"":request.getParameter("qryDesc");
	//String qryRef = request.getParameter("qryRef")==null?"":request.getParameter("qryRef");
	String excelMsg = request.getParameter("excelMsg")==null?"":request.getParameter("excelMsg");
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
			<td class='' colspan='8' align='right'>
				<input type='button' value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' onclick="printDoc('<%=qryDesc%>','<%=excelMsg%>');">
				<input type='button' value='<fmt:message key="eCA.Export.label" bundle="${ca_labels}"/>' onclick='getExcelSheet("<%=excelMsg%>");'>
			</td>
		</tr>
	</table>
</body>
</html>

