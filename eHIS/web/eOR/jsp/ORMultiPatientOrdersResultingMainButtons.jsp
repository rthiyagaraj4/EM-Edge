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

<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name="multiPatientOrdersResultingMainButtons" id="multiPatientOrdersResultingMainButtons" method="post">
<table cellpadding=0 cellspacing=0 border='0' width='99%' align=center >
	<tr>
		<TD width="5%">
			&nbsp;
		</TD>
		<TD width="3%" class="DUPLICATE">
		</TD>
		<TD width="30%" class="label">
			&nbsp;<fmt:message key="eOR.ValueDifferedFromDefaultResult.label" bundle="${or_labels}"/>
		</TD>
		<TD class="button" style="text-align : right">
			<input type="button" class="button" name="record" id="record" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick="recordValues()">
			<input type="button" class="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="cancelFrames()">
		</TD>
	</tr>
</table>

</form>
</body>
</html>

