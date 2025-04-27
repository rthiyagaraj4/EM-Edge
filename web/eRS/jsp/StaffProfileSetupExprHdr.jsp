<!DOCTYPE html>
 <%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupCriteria.jsp
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	2 dec 2004.
* --%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="javascript" src="../js/RSCommonFunction.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='formStaffProfileLicenseHdr' id='formStaffProfileLicenseHdr' target='' >
<table cellpadding=0 cellspacing=0 border=1  id='titleTab' width="100%">
<tr>
<th width='11%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></th>
<th width='11%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
<th width='12%'><fmt:message key="eRS.FacilityType.label" bundle="${rs_labels}"/></th>
<th width='13%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
<th width='11%'><fmt:message key="eRS.WorkplaceType.label" bundle="${rs_labels}"/></th>
<th width='11%'><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></th>
<th width='8%'><fmt:message key="eRS.Grade.label" bundle="${rs_labels}"/></th>
<th width='5%'><fmt:message key="eRS.FTE.label" bundle="${rs_labels}"/></th>
<th width='5%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
</tr>
</table>
</body>
</html>

