<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");

%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<table border=0 cellspacing=0 cellpadding=3  width='100%'  valign=top>
<tr>
<td class='CAGROUPHEADING'>
	<fmt:message key="eOT.ChecklistItem.Label" bundle="${ot_labels}"/>
</td>
</tr>
</table>
</body>
</html>


