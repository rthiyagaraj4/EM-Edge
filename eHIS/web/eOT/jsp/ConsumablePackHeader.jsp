<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<table border=0 cellspacing=0 cellpadding=3 width='100%'  valign=top>
		<tr>
			<td class='CAGROUPHEADING' align='left' colspan='6'>
				<fmt:message key="Common.Items.label" bundle="${common_labels}"/>
			</td>
		</tr>
	</table>
</body>
</html>


