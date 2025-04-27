<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	20 nov 2004	
-->

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<!-- <script language="JavaScript" src="../js/RSMessages.js"></script>
<script language="javascript" src="../../eCommon/js/messages.js"> </script> -->
<script language="javascript" src="../js/SearchStaff.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<title><fmt:message key="eRS.OtherStaffDetails.label" bundle="${rs_labels}"/></title>
</head>
<%
String p_staff_id=request.getParameter("staff_id");
String p_role_type=request.getParameter("role_type");
%>
<iframe name='f_other_staff_details' id='f_other_staff_details' src='../../eAM/jsp/OtherStaffDtlsView.jsp?other_staff_id=<%=p_staff_id%>' frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='f_tab_details' id='f_tab_details' src='../../eRS/jsp/SearchStaffResultStatus.jsp?other_staff_id=<%=p_staff_id%>&role_type=<%=p_role_type%>' frameborder=0 style='height:20vh;width:100vw'></iframe>
</html>


