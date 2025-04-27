<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Suresh.S
*	Created On		:	16 Oct 2004
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<title><fmt:message key="eRS.WorkPlaceRequirement.label" bundle="${rs_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> --> 
<script language="javascript" src="../js/WorkplaceRequirement.js"></script>
</head>
<iframe name='frameWorkPlaceSearch' id='frameWorkPlaceSearch' src="../../eRS/jsp/WorkPlaceRequirementAddModify.jsp?<%=request.getQueryString()%>" frameborder=0	scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
<iframe name='frameWorkPlaceHdr' id='frameWorkPlaceHdr' src='../../eCommon/html/blank.html'
frameborder=0 scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>
<iframe name='frameWorkPlaceResult' id='frameWorkPlaceResult' src='../../eCommon/html/blank.html'
frameborder=0 scrolling='auto' noresize style='height:6vh;width:100vw'></iframe>

</html>

