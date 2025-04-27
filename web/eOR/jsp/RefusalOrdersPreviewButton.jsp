<!--<!DOCTYPE html>-->
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>


<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<title><fmt:message key="eOR.EditorPreview.label" bundle="${or_labels}"/></title>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name="editor_preview_button" id="editor_preview_button" method="post" target="messageFrame">
	<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>		
		<td class='button'>
			<input type="button" class="BUTTON" name="close" id="close" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='closePreview()'>
 			<input type="button" class="BUTTON" name="print" id="print" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>" onClick="printPreview()">
		</td>
	</tr>
	
 	</table>
<input type="hidden" name="p_language_id" id="p_language_id" value="<%= localeName %>">
	</form>
	</body>
</html>

