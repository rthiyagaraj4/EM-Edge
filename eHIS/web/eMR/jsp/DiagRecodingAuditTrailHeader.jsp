<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../../eMR/js/QueryDiagRecodingAuditTrail.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:100%; visibility:hidden;' >
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='1'  width='100%' height='100%' align='center'>
	<tr >
		<td  width='100%' id='t'></td>
		</td>
	</tr>
	</table>
	</div>

 <table border='1' cellpadding='0' cellspacing='0' width="100%">
		<!-- <tr>
		<th  colspan=1 align=center>&nbsp;</th>
		<th  colspan=1  align=center>Old</th>
		<th  colspan=2 align=center>New</th>
		<th  colspan=1 align=center>&nbsp;</th>
		</tr> --> 
		<tr>
		<th width='14%' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th width='16%' nowrap><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></th>
		<th width='9%' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
		<th width='10%' ><fmt:message key="eMR.OriginalDiagnosisCode.label" bundle="${mr_labels}"/><br>&nbsp;</th>
		<!--<th width='10%'><fmt:message key="eMR.OldDiagnosisCode.label" bundle="${mr_labels}"/><br>&nbsp;</th>-->
		<!-- <th width='11%' nowrap> Diagnosis Desc</th>
		<th width='14.5%'>Remarks</th> -->
		<th width='10%'><fmt:message key="eMR.NewDiagnosisCode.label" bundle="${mr_labels}"/><br>&nbsp;</th>
		<!-- <th width='17%'>Diagnosis Desc</th>
		<th width='13%'>Remarks</th> -->
		<th width='15%'' ><fmt:message key="eMR.RecodedBy.label" bundle="${mr_labels}"/></th>
		<!--Modified By Dharma on Mar 12th 2015 against against HSA-SCF-0205 [IN:053238]-->
		<!--<th width='16%' nowrap >Re-coded Date</th>-->
		<th width='16%' nowrap ><fmt:message key="eMR.RecodedDate.label" bundle="${mr_labels}"/> <fmt:message key="Common.time.label" bundle="${common_labels}"/></th> 
		<!-- <th width='20%'  nowrap>Work-<br>Station</th> -->
		</tr>
</table>

</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

