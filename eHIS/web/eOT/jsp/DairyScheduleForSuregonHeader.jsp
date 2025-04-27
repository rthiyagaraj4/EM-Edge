<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String function_id=request.getParameter("function_id");
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<table border=0 cellspacing=0 cellpadding=3 width='100%'  valign=top>
<tr>
<%if("OT_MST_CODE_DIARY_SCH_SURGEON".equals(function_id)) {%>
<td class='CAGROUPHEADING' colspan='6' align='left'><fmt:message key="eOT.DiaryScheduleforSurgeon.Label" bundle="${ot_labels}"/></td>
<% } else if ("OT_MST_CODE_DIARY_SCH_THEATRE".equals(function_id)) { %>
<td class='CAGROUPHEADING' colspan='6' align='left'><fmt:message key="eOT.DiaryScheduleforTheatre.Label" bundle="${ot_labels}"/></td>
<%} %>
</tr>
</table>
</body>
</html>


