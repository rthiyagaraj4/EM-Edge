<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
-->
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" import="eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/IdentifyValidDuplicates.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<%
	try
	{
		%>
		<form name='group_details_title' id='group_details_title'>
		<table border='1' width='100%' cellspacing='0' align='center'>
	 		<tr><th class='columnheader' colspan='8' style="text-align:left;" ><fmt:message key="Common.GroupDetails.label" bundle="${common_labels}"/></th></tr>
			<tr>
				<td class='fields' colspan='8' ><input type='button' name='search_criteria' id='search_criteria' value='<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>' class='button' onClick="callSearchCriteria()"><input type='button' name='duplicatesdetails' id='duplicatesdetails' value='<fmt:message key="eDR.DuplicateDetails.label" bundle="${dr_labels}"/>' class='button' disabled onClick="callDuplicatesDetails()" >
			</tr>
			<tr>
				<th class='columnheader' width='7%' style="text-align:left;"><fmt:message key="Common.view.label" bundle="${common_labels}"/></th>
				<th class='columnheader' width='15%' style="text-align:left;"><fmt:message key="Common.patient.label" bundle="${common_labels}"/> <fmt:message key="Common.Series.label" bundle="${common_labels}"/></th>
				
				<th class='columnheader' width='4%' style="text-align:left;">+</th>
				<th class='columnheader' width='40%' style="text-align:left;"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
				<th class='columnheader' width='10%' style="text-align:left;"><fmt:message key="Common.main.label" bundle="${common_labels}"/></th>
				<th class='columnheader' width='10%' style="text-align:left;"><fmt:message key="eDR.Duplicate.label" bundle="${dr_labels}"/></th>
				<th class='columnheader' width='15%' style="text-align:left;"><fmt:message key="eDR.DoNotConsider.label" bundle="${dr_labels}"/></th>
				<th class='columnheader' width='10%' style="text-align:left;"><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></th>
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

