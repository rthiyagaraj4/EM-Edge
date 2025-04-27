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
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	try
	{
		%>
		<form name='group_details_title' id='group_details_title'>
			<table border='0' width='100%' cellspacing='0' align='center'>
 		<tr><th class='columnheader' colspan='6' ><fmt:message key="Common.GroupDetails.label" bundle="${common_labels}"/></th></tr>
		<tr>
			<td class='label' colspan='6' >
			<input type='button' name='reset_group_status' id='reset_group_status' value='<fmt:message key="eDR.ResettoMergeProcess.label" bundle="${dr_labels}"/>' class='button' onClick="resetGroupStatus()" disabled></td>
		</tr>
		<tr>
			<th width='8%'>&nbsp;</th>
			<th class='columnheader' width='4%'>+</th>
			<th class='columnheader' width='48%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th class='columnheader' width='10%'><fmt:message key="Common.main.label" bundle="${common_labels}"/></th>
			<th class='columnheader' width='10%'><fmt:message key="eDR.Duplicate.label" bundle="${dr_labels}"/></th>
			<th class='columnheader' width='20%'><fmt:message key="eDR.DoNotConsider.label" bundle="${dr_labels}"/></th>
		</tr>
	</table>
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

