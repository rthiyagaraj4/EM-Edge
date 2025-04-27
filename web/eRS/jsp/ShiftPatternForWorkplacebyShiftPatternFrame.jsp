<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ShiftPatternForWorkplace.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	22-11-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.ShiftPatternForWorkplace.label" bundle="${rs_labels}"/></title>
<script Language="javascript" Src="../../ecommon/js/common.js"></script>
<script Language="javascript" Src="../js/rscommon.js"></script>
<script Language="javascript" Src="../js/shiftpatternforworkplace.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='frameshiftpatterndtl' id='frameshiftpatterndtl' Src='../../eRS/jsp/ShiftPatternForWorkplaceShiftPatternDetails.jsp?<%=request.getQueryString()%>' Frameborder=0 Scrolling="no" Noresize style='height:50vh;width:100vw'></iframe>
<iframe name="frameWorkplaceList" id="frameWorkplaceList" Src='../../eCommon/html/blank.html'frameborder=0 Scrolling="auto" Noresize style='height:50vh;width:100vw'></iframe>

</html>

