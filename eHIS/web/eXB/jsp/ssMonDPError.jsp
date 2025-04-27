<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eXH.XHUtil,eXH.XHDBAdapter" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<head>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eXB/js/ssMonDPReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<html>
<TITLE><fmt:message key="eXH.SSMonDPErr.Label" bundle="${xh_labels}"/></TITLE>

<%
	String locale = (String)session.getAttribute("LOCALE");
	String errMsg = XHDBAdapter.checkNull(request.getParameter("errMsg"));
%>

</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<form name="ssMonDPError" id="ssMonDPError" method='post'>
<table width='100%'>
<tr>
	<td class='COLUMNHEADER'><fmt:message key="Common.Error.label" bundle="${common_labels}"/></td>
</tr>
<tr> 
	<td class='LABEL'><TEXTAREA NAME="errMsg" ROWS="5" COLS="107"><%= errMsg %></TEXTAREA></td>	
</tr>
<tr align='right'>
	<td class='button' align='right'><INPUT TYPE='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='window.close();'></td>	
</tr>
</table>

</form>

</BODY>
</HTML>

