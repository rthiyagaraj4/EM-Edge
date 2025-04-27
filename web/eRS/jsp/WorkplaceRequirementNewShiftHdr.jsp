<!DOCTYPE html>
<!-- /**
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	16 October 2004.
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
<body>
<form name='form_WrkPlaceShiftHdr' id='form_WrkPlaceShiftHdr' method='' target="">
<table cellpadding=0 cellspacing=0 border=1	 width="98%" align=center id='titleTab'>
<tr>
<td colspan='8' Align='left' class ='CAGROUPHEADING'><font size=2><fmt:message key="eRS.ShiftsforLocation.label" bundle="${rs_labels}"/></td>
</tr>
<tr>
	<th width='40%'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></th>
	<th width='9%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></th>
	<th width='8%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></th>
	<th width='20%'><fmt:message key="eRS.ShiftIndicator.label" bundle="${rs_labels}"/></th>
	<th width='7%'><fmt:message key="eRS.Productivity.label" bundle="${rs_labels}"/></th>
	<th colspan=3 align='center'><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></th>
</tr>
<tr>
	<th colspan='5'>&nbsp;</th>
	<th><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></th>
	<th><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></th>
	<th><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></th>
</tr>
</table>
</form>
</body>
</html>

