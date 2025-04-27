<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupSkills.jsp
*	Purpose 		:
*	Created By		:	Suresh.S
*	Created On		:	22 Nov 2004
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String staff_id= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
%>
<title><fmt:message key="eRS.StaffProfile.label" bundle="${rs_labels}"/> - <fmt:message key="eRS.Skills.label" bundle="${rs_labels}"/> - <%=staff_id%></title>
</head>
<iframe name='frameSkillsHdr' id='frameSkillsHdr' src="../../eRS/jsp/StaffProfileSetupSkillsHdr.jsp" frameborder=0	scrolling='auto' noresize style='height:4%;width:100vw'></iframe>
<iframe name='frameSkillsResult' id='frameSkillsResult' src="../../eRS/jsp/StaffProfileSetupSkillsResult.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
<iframe name='frameSkillsRecord' id='frameSkillsRecord' src="../../eRS/jsp/StaffProfileSetupSkillsRecord.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:20%;width:100vw'></iframe>
<iframe name='frameError' id='frameError' src="../../eRS/jsp/StaffProfileSetupError.jsp" frameborder=0 scrolling='no' noresize  style='height:0.1%;width:100vw'></iframe>
</html>

