<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>

		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script Language='JavaScript' src='../../eCA/js/MultiTransRequest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  class='CONTENT' >
		<center>
			<form name='MultiTransRequestToolbarForm' id='MultiTransRequestToolbarForm'  method='post'>
				<table border='0' cellpadding='3' cellspacing='0' width='100%' height='100%' align='center'>
					<tr>
						<td align='right'>
							<input type='BUTTON' class='BUTTON' name='apply' id='apply' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels")%>' onClick='record();' disabled >
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>

