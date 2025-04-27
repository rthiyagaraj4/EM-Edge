<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form>
<table border='0' cellpadding=3  cellspacing='0' width='100%' align="center">
<tr>
  <td class="CAGROUPHEADING" ><fmt:message key="Common.notes.label" bundle="${common_labels}"/></td>
 </tr>
 </form>
 </body>
 </table>

