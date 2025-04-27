<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupFrameSet.jsp
*	Purpose 		:
*	Created By		:	Suresh.S
*	Created On		:	20 Nov 2004
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eRS.* ,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<title><fmt:message key="eRS.StaffProfileSetup.label" bundle="${rs_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<frameset rows="" frameborder='1'>
<frame name='frameStaffProfileCriteria' id='frameStaffProfileCriteria' src="../../eRS/jsp/StaffProfileSetupCriteria.jsp?<%=request.getQueryString()%>" frameborder=0	scrolling='no' noresize>
</frameset>
</html>

