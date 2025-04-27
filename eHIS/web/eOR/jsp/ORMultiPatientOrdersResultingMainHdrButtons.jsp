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
<%-- JSP Page specific attributes end --%>
<%@page contentType="text/html;charset=UTF-8"%>
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
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eOR/js/ORMultiPatientOrdersResultingReport.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"><!-- used for date validation--></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="multiPatientOrdersResultingHdrButtons" id="multiPatientOrdersResultingHdrButtons">
<table cellpadding=0 cellspacing=0 border='0' width='99%' align='center'>
	<tr>
		<TD class="button" style="text-align : right">
			<input type="button" class="button" name="populate" id="populate" value='<fmt:message key="eOR.FillDetails.label" bundle="${or_labels}"/>' onClick="loadMainResultFrameValues()">
			<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearHeaderValues()">
		</TD>
	</tr>
</table>
</form>
</body>
</html>

