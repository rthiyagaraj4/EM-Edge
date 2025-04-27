<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	WorkPlaceAllocationFrameset.jsp
*	Purpose 			:
*	Created By		:	Sreenivasulu.Y
*	Created On		:	10 Dec 2004
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eRS.* ,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<title><fmt:message key="eRS.WorkPlaceAllocation.label" bundle="${rs_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="javascript" src="../js/WorkplaceAllocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='frameWorkPlaceAllocCriteria' id='frameWorkPlaceAllocCriteria' src="../../eRS/jsp/WorkplaceAllocationCriteria.jsp?<%=request.getQueryString()%>" frameborder=0	scrolling='no' noresize style='height:35vh;width:100vw'></iframe>
<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>
<iframe name='frameWorkPlaceAllocHdr' id='frameWorkPlaceAllocHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:60vh;width:100vw'></iframe>
 
</html>

 

