<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<table width="100%">
		<tr>
		   <td align=right>				
				<input type='button' name='Close' id='Close' onclick="javascript:window.close();" class='button'>
			</td>
		</tr>
		</table>
	</body>
</html>

