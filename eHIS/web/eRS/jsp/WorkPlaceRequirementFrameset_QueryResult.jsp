<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Suresh.S
*	Created On		:	9 Dec 2004
-->
<html>
<head>
<title><fmt:message key="eRS.WorkPlaceRequirementQryResult.label" bundle="${rs_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="javascript" src="../js/WorkplaceRequirement.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String workplace_code = request.getParameter("workplace_code")==null?"": request.getParameter("workplace_code");
String locn_type	  = request.getParameter("locn_type")==null?"": request.getParameter("locn_type");
String workplace_desc       = request.getParameter("workplace_desc")==null?"":request.getParameter("workplace_desc");
String requirement = request.getParameter("requirement")==null?"":request.getParameter("requirement");
String qryString = "workplace_code="+workplace_code+"&locn_type="+locn_type+"&workplace_desc="+workplace_desc+"&requirement="+requirement;
%>
<iframe name='frame_qryResulttop' id='frame_qryResulttop' src='../../eRS/jsp/WorkplaceRequirementQueryResult.jsp?<%=qryString%>' frameborder=0 scrolling='auto' noresize style='height:45vh;width:100vw'></iframe>
<iframe name='frame_qryResulutHdr' id='frame_qryResulutHdr' src='../../eCommon/html/blank.html'
frameborder=0 scrolling='auto' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='frame_qryResultbottom' id='frame_qryResultbottom' src='../../eCommon/html/blank.html'
frameborder=0 scrolling='auto' noresize style='height:47vh;width:100vw'></iframe>

</html>

