<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,eDR.*" %>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/PossibleDuplicates.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ="lockKey()">

<%
	try
	{
	
%>
 <form name='group_details_title' id='group_details_title'>
	<table border=1 width=100% cellspacing=0 align='center'>
 		<tr>
			<th class='columnheader' colspan='6' style="text-align:left;" ><fmt:message key="Common.GroupDetails.label" bundle="${common_labels}"/></th>
		</tr>
		
		<tr>
			<td class='button' colspan='6' align='right'>
				<input type='button' name='search_criteria' id='search_criteria' value='<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>' class='button' onClick="callSearchCriteria()">
			    <input type='button' name='duplicatesdetails' id='duplicatesdetails' value='<fmt:message key="eDR.DuplicateDetails.label" bundle="${dr_labels}"/>' class='button' disabled onClick="callDuplicatesDetails()" >
		</tr>
		<tr>
			<th class='columnheader' width=8% style="text-align:left;"><fmt:message key="Common.view.label" bundle="${common_labels}"/></th>
			<th class='columnheader' width=4% style="text-align:left;">+</th>
			<th class='columnheader' width=48% style="text-align:left;"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th class='columnheader' width=10% style="text-align:left;"><fmt:message key="Common.main.label" bundle="${common_labels}"/></th>
			<th class='columnheader' width=10% style="text-align:left;"><fmt:message key="eDR.Duplicate.label" bundle="${dr_labels}"/></th>
			<th class='columnheader' width=20% style="text-align:left;"><fmt:message key="eDR.DoNotConsider.label" bundle="${dr_labels}"/></th>
		</tr>
</table>

	</form>
<%
	}
	catch(Exception e)
	{
		out.println("Error From File PossibleDuplicateDetailsTitle.jsp"+e.toString());
	}
	
%>
</body>
</html>

