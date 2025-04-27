<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<html>
	<head>
	<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../js/MRMaster.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function openMenu(obj)	{
parent.parent.parent.parent.frames[1].expand(obj)		}

function dummy(){}
</script>
	</head>

<% 
	request.setCharacterEncoding("UTF-8");
	String expand=request.getParameter("expand");
	if( expand == null) expand="CCCCCCC";

%>
	<body style="background-color:dimgray;"  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="MRCodeSetup_form" id="MRCodeSetup_form">
	<table cellspacing=1 cellpadding=2 width='111%' border=0 id='t'>

	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('BLOOD_GROUP')" ><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('RHESUS_FACTOR')" ><fmt:message key="eMR.RhesusFactor.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('MEDICAL_EVENT_TYPE')" ><fmt:message key="Common.MedicalEventType.label" bundle="${common_labels}"/></td>
		</tr>
        <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('MDS_FOR_PAT_CLASS')" ><fmt:message key="eMR.MDSforPatClass.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr>
			<td  class='IPCAHIGHERLEVELCOLOR'><fmt:message key="eMR.ICDSetup.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('TABULATION_LIST')"><fmt:message key="eMR.TabulationList.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('ICD_CODE')" ><fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></td>
		</tr>
		
		<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPsfortab()" ><fmt:message key="eMR.ICDCodeForTabulationList.label" bundle="${mr_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('MR_DIAG_GROUP')" ><fmt:message key="eMR.DiagnosisProcedureGroup.label" bundle="${mr_labels}"/></td>
		</tr>-->
		
		<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('ICD_CODE_FOR_DIAG_GROUP')" ><fmt:message key="eMR.CodeForDiagnosisProcedureGroup.label" bundle="${mr_labels}"/></td>
		</tr>-->
		<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callLoadingJSP()" ><fmt:message key="eMR.AsteriskCodeforDaggerCode.label" bundle="${mr_labels}"/> </td>
		</tr>-->
		<tr>
			<td  class='IPCAHIGHERLEVELCOLOR'><fmt:message key="eMR.MedicalReportBoardSetup.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('Requestor_MR')" ><fmt:message key="Common.Requestor.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('Application_Type')" ><fmt:message key="eMR.ApplicationType.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('Medical_Board_Type')" ><fmt:message key="eMR.MedicalBoardType.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('Medical_Board')" ><fmt:message key="eMR.MedicalBoard.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr>
			<td  class='IPCAHIGHERLEVELCOLOR'><fmt:message key="eMR.AdverseSetup.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('ALLERGY_TYPE')" ><fmt:message key="Common.AllergyType.label" bundle="${common_labels}"/></td>
		</tr> 
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('HIGH_RISK')" ><fmt:message key="Common.HighRisk.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('Adverse_Event_Type')" ><fmt:message key="eMR.AdverseEventType.label" bundle="${mr_labels}"/></td>
		</tr> 
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('Agent_for_Adv_Event_Type')" ><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('Adverse_Reaction')" ><fmt:message key="Common.AdverseReaction.label" bundle="${common_labels}"/></td>
		</tr> 
 	<!-- 	<tr>
			<td  class='IPCAHIGHERLEVELCOLOR'>PL/PD/SS Report Setup</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callReportGrpJSP('Report_Group')" >PD/PL/SS Report Group </td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callListReportJSP()" >PD/PL/SS Report Link for Master </td>
		</tr> -->
		 <tr onclick='chcol(this)'>
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr> 
	</table>
	</form>
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

