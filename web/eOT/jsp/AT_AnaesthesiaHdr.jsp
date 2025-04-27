<!DOCTYPE html>
<%@ page import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>

<html>
<head>
<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script> -->
<!-- <script language="javascript" src="../../eOT/js/OTMessages.js"></script> -->
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="AnaesthesiaHdrForm" id="AnaesthesiaHdrForm" >
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
<tr>
	<td class="COMMONTOOLBARFUNCTION"><%=request.getParameter("function_name")%></td>
</tr>
 </table>
</form>
</body>
</html>

