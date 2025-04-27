<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
			request.setCharacterEncoding("UTF-8");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/SsCommon.js"></script>
	<script language="JavaScript" src="../js/GroupForStore.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookUp.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="groupforstore_tab" id="groupforstore_tab" frameborder="0" scrolling="no" noresize src="../../eSS/jsp/GroupForStoreTab.jsp" style="height:0vh;width:100vw"></iframe>
<iframe name="groupforstore_header" id="groupforstore_header" frameborder="0" scrolling="no" noresize src="../../eSS/jsp/GroupForStoreHeader.jsp?from_source=bygroup" style="height:7vh;width:100vw"></iframe>
<iframe name="groupforstore_button" id="groupforstore_button" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:6vh;width:100vw"></iframe>
<iframe name="groupforstore_label" id="groupforstore_label" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:10vh;width:100vw"></iframe>
<iframe name="groupforstore_dtls" id="groupforstore_dtls" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:68vh;width:100vw"></iframe>

</html>


