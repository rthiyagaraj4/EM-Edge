<!DOCTYPE html>
<!-- /**
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	14 December 2004.
*/ -->
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>	
	<script language="javascript" src="../js/RSMessages.js"></script> -->
	<script language="javascript" src="../js/RSCommon.js"></script>
	<script language="javascript" src="../js/GenerateWorkSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='form_WrkPlaceStaffHdr' id='form_WrkPlaceStaffHdr' method='' target="">
<table cellpadding=0 cellspacing=0 border=1	 width="98%" align='left' id='titleTab'>
<tr>
<th width='21%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
<th width='20%'><fmt:message key="eRS.StaffId.label" bundle="${rs_labels}"/></th>
<th width='30%'><fmt:message key="eRS.StaffName.label" bundle="${rs_labels}"/></th>
<th width='11%'><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></th>
<th width='11%'><fmt:message key="eRS.DateTo.label" bundle="${rs_labels}"/></th>
<th width='7%'><input type=checkbox name='chk_all' id='chk_all' value='' 
onClick='click_select()'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
</tr>
</table>
</form>
</body>
</html>

