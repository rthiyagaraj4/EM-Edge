<!DOCTYPE html>
<!-- /**
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	21 October 2004.
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
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>	
<script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/WorkplaceRequirement.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String mode = request.getParameter("mode");
%>
	<form name='form_WrkPlaceStaffHdr' id='form_WrkPlaceStaffHdr' method='' target="">
	<table cellpadding=0 cellspacing=0 border=1	 width="98%" align=center id='titleTab'>
	<tr>
<% 
	if (!(mode.equals("edit"))){
%>
			<th width='35%'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/>/ <fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
			<th width='9%'>&nbsp;</th>
			<th  colspan='3'><fmt:message key="eRS.Fixed.label" bundle="${rs_labels}"/></th>
			<th  colspan='2'><fmt:message key="eRS.ByRatio.label" bundle="${rs_labels}"/></th>
			<th colspan='2'><fmt:message key="eRS.ByFTE.label" bundle="${rs_labels}"/></th>
			<th width='6%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
</tr>
<tr>
			<th colspan=2>&nbsp;</th>
			<th width='6%'><fmt:message key="Common.MIN.label" bundle="${common_labels}"/></th>
			<th width='6%'><fmt:message key="eRS.Opt.label" bundle="${rs_labels}"/></th>
			<th width='6%'><fmt:message key="Common.Max.label" bundle="${common_labels}"/></th>
			<th width='10%'>S:B</th>
			<th width='10%'>S:P</th>
			<th width='6%'><fmt:message key="eRS.FTE.label" bundle="${rs_labels}"/></th>
			<th width='6%'><fmt:message key="Common.hours.label" bundle="${common_labels}"/></th>
			<th><input type=checkbox name='chk_all' id='chk_all' value='' onClick='click_select()'></th>
<%
	}
	else{
%>
	<th width='35%'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/>/ 
	<fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
	<th width='9%'>&nbsp;</th>
	<th  colspan='3'><fmt:message key="eRS.Fixed.label" bundle="${rs_labels}"/></th>
	<th  colspan='2'><fmt:message key="eRS.ByRatio.label" bundle="${rs_labels}"/></th>
	<th colspan='2'><fmt:message key="eRS.ByFTE.label" bundle="${rs_labels}"/></th>
</tr>
<tr>
	<th colspan=2>&nbsp;</th>
	<th width='6%'><fmt:message key="Common.MIN.label" bundle="${common_labels}"/></th>
	<th width='6%'><fmt:message key="eRS.Opt.label" bundle="${rs_labels}"/></th>
	<th width='6%'><fmt:message key="Common.Max.label" bundle="${common_labels}"/></th>
	<th width='13%'>S:B</th>
	<th width='13%'>S:P</th>
	<th width='6%'><fmt:message key="eRS.FTE.label" bundle="${rs_labels}"/></th>
	<th width='6%'><fmt:message key="Common.hours.label" bundle="${common_labels}"/></th>
<%
		}
%>
</tr>
</table>
</form>
</body>
</html>

