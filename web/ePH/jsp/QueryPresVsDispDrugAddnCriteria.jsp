<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/QueryPresVsDispDrug.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<!-- <body topmargin="0" > -->
<form name="FormQueryPresVsDispDrugAdditionalCriteria" id="FormQueryPresVsDispDrugAdditionalCriteria" >

<table cellpadding="0" cellspacing="0"  width="102%" align="left" border="0" >
<tr >
		<td align="right" class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td  align="left">&nbsp;&nbsp;<input type=text  name="Encounter Id" id="Encounter Id" size=15 >	</td>
		<td align="right" class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;	<input type=text  maxlength="15" size="15" name="Patient_Id" id="Patient_Id"  ><INPUT TYPE="button" name="Patient_Id_Button" id="Patient_Id_Button" VALUE="?" CLASS="button" onClick="callPatientSearch(document.FormQueryPresVsDispDrugAdditionalCriteria.Patient_Id)" >
		</td>
		<td align="right" class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td  align="left">&nbsp;&nbsp;<select name="Patient_Gender" id="Patient_Gender"><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option><option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></select></td>

</tr>
<tr>
		<td class="label" align="right"><fmt:message key="Common.FirstName.label" bundle="${common_labels}"/></td>
		<td  align="left">&nbsp;&nbsp;<input type=text  name="Patient_First_Name" id="Patient_First_Name" size=15 >	</td>
		<td class="label" align="right"><fmt:message key="Common.SecondName.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;	<input type=text  name="Patient_Second_Name" id="Patient_Second_Name" size=15 >	</td>
		<td class="label" align="right"><fmt:message key="Common.FamilyName.label" bundle="${common_labels}"/></td>
		<td align="left"  >&nbsp;&nbsp;<input type=text  name="Patient_Family_Name" id="Patient_Family_Name" size=15 >	</td>


</tr>
<tr>
	<td align="right" colspan="6" ><input type="button" class="button" name="Ok" id="Ok" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="closeAdditionalCriteria()">&nbsp;<input type="button" class="button" name="search" id="search" value="Cancel" onClick="closeAdditionalCriteria()"></td>
	
</tr>
</table>


</form>
</body>
</html>

