<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>

<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<table border=0 cellspacing=0 cellpadding=3 width='100%'  valign=top>
<tr>
<th class='columnHeaderCenter' align='left' colspan='6'><fmt:message key="eSM.Users.label" bundle="${sm_labels}"/></th>
</tr>
</table>
</body>
</html>


