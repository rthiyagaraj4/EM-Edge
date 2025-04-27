<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleFrameset.jsp
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	24-11-2004
*/
%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.MasterSchedule.label" bundle="${rs_labels}"/> </title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/MasterSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<iframe name='frameCriteriaTabs' id='frameCriteriaTabs' src='../../eCommon/html/blank.html' frameborder=0 scrolling="no" noresize style='height:3vh;width:100vw'></iframe>
<iframe name= "frameCriteria" id="frameCriteria" src='../../eRS/jsp/MasterScheduleCriteriaByWorkplace.jsp' frameborder=0 scrolling='no' noresize style='height:22vh;width:100vw'></iframe>
<iframe name= "frameButtons" id="frameButtons" src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:3vh;width:100vw'></iframe>
<iframe name="frameResult" id="frameResult" src='../../eCommon/html/blank.html'frameborder=0 scrolling="auto" noresize style='height:72vh;width:100vw'></iframe>

</html>

