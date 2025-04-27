<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,eCommon.Common.*" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head><title>MultiPatientOrdersResultingHdr</title>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/ORMultiPatientOrdersResultingReport.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name="multiPatientOrdersResultingHdrButtons" id="multiPatientOrdersResultingHdrButtons">
<table cellpadding=0 cellspacing=0 border='0' width='100%' align='center' >
	<tr>
		<TD align="right">
			<input type="button" class="button" name="search" id="search" value="Result" onClick="setCBValues();resultValues();">
			<input type="button" class="button" name="cancel" id="cancel" value="Cancel" onClick="clearFrames()">
		</TD>
	</tr>
</table>

</form>
</body>
</html>

