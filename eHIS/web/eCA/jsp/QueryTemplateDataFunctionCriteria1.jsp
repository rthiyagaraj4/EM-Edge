<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="javascript" src="../../eCA/js/QueryTemplateDataFunction.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
		<title></title>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table width='100%' cellpadding='3' cellspacing='0' border='0'>
			<tr>
				<td class='label'><fmt:message key="Common.query.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/> &nbsp;&nbsp;<input type='text' name='qryTxt' id='qryTxt' value='' onblur='getQryDescBytxt(this)' /><input type='button' value='?' name='btnQry' id='btnQry' onclick='getQryDesc()'/>
				</td>
			</tr>
		</table>
</body>
</html>

