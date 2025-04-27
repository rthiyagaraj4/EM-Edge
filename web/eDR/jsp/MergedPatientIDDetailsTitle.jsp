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
	<script language='javascript' src='../../eDR/js/MergedPatientIds.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
	  <form name='group_details_title' id='group_details_title'>
		<table border='1' width='100%' cellspacing='0' align='center'>
			<tr><th class='columnheader' colspan='7' ><fmt:message key="Common.GroupDetails.label" bundle="${common_labels}"/></th></tr>
			 <tr>
				<th class='columnheader' width='18%'><fmt:message key="Common.patient.label" bundle="${common_labels}"/> <fmt:message key="Common.Series.label" bundle="${common_labels}"/></th>
				<th class='columnheader' width='8%'>+</td>
				<th class='columnheader' width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
				<th class='columnheader' width='10%'><fmt:message key="Common.main.label" bundle="${common_labels}"/></th>
				<th class='columnheader' width='10%'><fmt:message key="eDR.Duplicate.label" bundle="${dr_labels}"/></th>
				<th class='columnheader' width='22%'nowrap><fmt:message key="eDR.MergedBy.label" bundle="${dr_labels}"/> </th>
				<th class='columnheader' width='20%' nowrap><fmt:message key="eDR.MergedDate.label" bundle="${dr_labels}"/></th>
			</tr>
		</table>
	</form>
	
</body>
</html>

