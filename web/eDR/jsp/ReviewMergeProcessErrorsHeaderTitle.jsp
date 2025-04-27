<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/ReviewMergeProcessErrors.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	try
	{
		%>
		<form name='group_header_title' id='group_header_title'>
			<table border='0' width='100%' cellspacing='0' id='tb1'>
				<tr>
					<td class=label width='80%'></td>
					<td class=label width='15%'></td>
				</tr>
				<tr><th class='columnheader' colspan='2'>&nbsp;<fmt:message key="eDR.DuplicateGroups.label" bundle="${dr_labels}"/></th></tr>
				<tr><td colspan='2' class='label'><b>&nbsp;</td></tr>
				<tr>
					<th class='columnheader'><fmt:message key="eDR.MainPatientID.label" bundle="${dr_labels}"/></th>
					<th class='columnheader'><fmt:message key="Common.count.label" bundle="${common_labels}"/></th>
				</tr>
			</table>
		 <input type='hidden' name="CheckBoxes" id="CheckBoxes" value=''>
		  <input type='hidden' name="selAll" id="selAll" value=''>
		  <input type='hidden' name="dup_group_id" id="dup_group_id" value=''>
		  <input type='hidden' name='chkedVls' id='chkedVls' value=''>
		</form>
		<%
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	%>
</body>
</html>

