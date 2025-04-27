<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ShiftPatternForWorkplace.jsp
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	16-11-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.ShiftPatternForWorkplace.label" bundle="${rs_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/ShiftPatternForWorkplace.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='frameSearch' id='frameSearch' src='../../eRS/jsp/ShiftPatternForWorkplaceAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="no" noresize style='height:5vh;width:100vw'></iframe>
<iframe name= "frameSelect" id="frameSelect"  src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:26vh;width:100vw'></iframe>
<iframe name="frameList" id="frameList" src='../../eCommon/html/blank.html'frameborder=0 scrolling="auto" noresize style='height:69vh;width:100vw'></iframe>

</html>

