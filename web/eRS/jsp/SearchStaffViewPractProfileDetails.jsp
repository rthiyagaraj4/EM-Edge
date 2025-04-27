<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	20 nov 2004
-->
<html>
<%@ page language="java" import ="java.util.*, java.sql.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script>
<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="javascript" src="../js/SearchStaff.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<title><fmt:message key="eRS.PractitionerDetails.label" bundle="${rs_labels}"/></title>
</head>
<%
String p_staff_id=request.getParameter("staff_id");
String p_role_type=request.getParameter("role_type");
%>
<iframe name='f_practitioner_details' id='f_practitioner_details' src='../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id=<%=p_staff_id%>' frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='f_tab_details' id='f_tab_details' src='../../eRS/jsp/SearchStaffResultStatus.jsp?staff_id=<%=p_staff_id%>&role_type=<%=p_role_type%>' frameborder=0 style='height:20vh;width:100vw'></iframe>
</html>


