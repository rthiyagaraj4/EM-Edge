<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupCriteria.jsp
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	26 Nov 2004.
* --%>
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
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="javascript" src="../js/RSCommonFunction.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='formStaffProfileTrainingHdr' id='formStaffProfileTrainingHdr' target='' >
<table cellpadding=0 cellspacing=0 border=1  id='titleTab' width="100%">
<tr>
<th width='12%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></th>
<th width='12%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></th>
<th width='25%'><fmt:message key="eRS.Training.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="eRS.Program.label" bundle="${rs_labels}"/></th>
<th width='16%'><fmt:message key="eRS.Training.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
<th width='25%'><fmt:message key="eRS.Organisation.label" bundle="${rs_labels}"/></th>
<th width='6%'><fmt:message key="eRS.Certified.label" bundle="${rs_labels}"/></th>
<th width='4%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th> 
</tr>
</table>
</body>
</html>

