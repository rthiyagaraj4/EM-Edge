<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	P.Anuradha
*	Created On		:	19 Jan 2005
-->

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
<title><fmt:message key="Common.AccessRights.label" bundle="${common_labels}"/> </title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<!-- <script language="javascript" src="../../eRS/js/RSMessages.js"></script> -->
<script language="javascript" src="../js/AccessRights.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='frameAccessHdr' id='frameAccessHdr' src="../../eRS/jsp/AccessRightsHdr.jsp?<%=request.getQueryString()%>" frameborder=0	scrolling='no' noresize style='height:27vh;width:100vw'></iframe>
<iframe name='frameAccessDtl' id='frameAccessDtl' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:73vh;width:100vw'></iframe>
<iframe name='Dummy' id='Dummy' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

</html>

