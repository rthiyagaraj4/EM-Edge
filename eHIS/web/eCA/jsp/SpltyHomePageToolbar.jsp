<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			String modevalue = request.getParameter("modeValue") == null ? "" : request.getParameter("modeValue");
		%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<title><fmt:message key="eCA.SectionTemplateToolbar.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCA/js/SpltyHomePage.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
		<center>
			<form name='RecMaternityConsToolbarForm' id='RecMaternityConsToolbarForm' action='../servlet/eCA.RecMatConsServlet'>
				<table border='0' cellpadding='3' cellspacing='0' width='100%' align='right'>
					<tr>
					<td align='right' width='100%'>
					<% if (modevalue.equals("V")){ %>
					<input type="button" class="BUTTON" name="close" id="close" onclick='return closep()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'>
					<%}else {%>
					<input type="button" class="BUTTON" name="Record" id="Record" onclick='record()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>'>
					<%}%>
					</td></tr>
				</table>
			</form>
		</center>
	</body>
</html>

