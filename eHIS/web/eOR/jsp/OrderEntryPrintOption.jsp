<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/* 
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
22/04/2014    IN042962	  Chowminya      					    	CRF:Print Order Sheet From Existing Orders		
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import="java.util.*, java.io.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>

 
<head><title><fmt:message key="eOR.PrintOption.label" bundle="${or_labels}"/></title></head>
<%
request.setCharacterEncoding("UTF-8");
%>		  
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="OrderTypeForm" id="OrderTypeForm" >
	<table height = 100% width="100%" border="0" cellspacing="0" cellpadding="3" align="center">
	<tr><td class="Label" ></td></tr>
	<tr>
	<td nowrap id="typeDesc" align="center"><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PrintOrderSheet.label","or_labels")%> 
		<input type="checkbox" name="chk" id="chk" id="chk" checked value="Y" onclick="selallOrdertype(this)">
	</td>
	</tr>
	<tr>
	<td class="button" align="center"><input type="button" class="button" name="ok" id="ok" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onclick="closeOrderType(this);">
	<input type="button" class="button" name="cancel" id="cancel" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onclick="closeOrderType(this);"></td>
	</tr>
	</table>
	</form>
</body>
 

