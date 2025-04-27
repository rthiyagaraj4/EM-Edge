<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Suresh.S
*	Created On		:	23 Sept 2004
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<title><fmt:message key="eRS.GenerateWorkSchedule.label"  bundle="${rs_labels}"/></title>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/RSCommon.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../js/GenerateWorkSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='frameGenWrkSchCriteria' id='frameGenWrkSchCriteria' src="../../eRS/jsp/GenerateWorkScheduleCriteria.jsp?<%=request.getQueryString()%>" frameborder=0	scrolling='no' noresize style='height:100vh;width:100vw'></iframe>
<iframe name='frameGenWrkSchHdr' id='frameGenWrkSchHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe> 
<iframe name='frameGenWrkSchResult' id='frameGenWrkSchResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:0vh;width:100vw'></iframe>

</html>

