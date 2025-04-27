<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form name='groupCloseForm' id='groupCloseForm'>
			<table width='100%' border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<td align='right'>
						<input class='button' type='button' name='grpButtonClose' id='grpButtonClose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='window.close()' >			
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

