<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
	<head>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	</head>

	<body onKeyDown='lockKey();'>
		<table align='right'>
			<tr>
				<td class='BODYCOLORFILLED' >
					<input type='button' class='button' onclick="parent.window.returnValue='Y';window.close();" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'>
					<input type='button' class='button' onclick="parent.window.close();" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'>
				</td>
			</tr>
		</table>
	</body>
</html>

