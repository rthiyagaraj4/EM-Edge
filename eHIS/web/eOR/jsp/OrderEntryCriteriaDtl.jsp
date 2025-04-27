<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head><title><fmt:message key="eOR.OrderEntryCriteriaDetail.label" bundle="${or_labels}"/> </title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="formCriteriaDtl" id="formCriteriaDtl">
		<table border="0" cellspacing="0" cellpadding="3" align="center" width="10%">
		<tr>
			<td><input type="button" class="button" name="search" id="search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="searchResult(this);"></td>
			<td><input type="button" class="button" name="clear" id="clear" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%> "></td>
			<!-- <td><input type="button" class="button" name="am_search" id="am_search" value="Additional Module Search"></td> -->
		</tr>
		</table>
	</form>
</body>
</html>

