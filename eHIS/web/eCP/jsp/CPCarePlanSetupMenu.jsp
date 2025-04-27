<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	//This file is saved on 18/10/2005.

	String sStyle		 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<style>
		A:active {
			COLOR: white;
		}

	</style>

	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){

				//parent.location.href='../../eCommon/jsp/CommonClearObjects.jsp';
				parent.location.href='../../eCommon/jsp/dmenu.jsp';

		}

		function chcol(ro)
		{
				if (document.getElementById("t").rows(prev).cells(0).className != 'ECMENUHIGHERLEVELCOLOR') {
					document.getElementById("t").rows(prev).cells(0).className=prevcol;
				}
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*Access is in the order - insert,update,query,delete,print*/

			if(val == 'CaseType'){
				parent.frames[1].location.href = '../../eCP/jsp/CaseType.jsp?module_id=CP&function_id=CodeSet&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.CaseType.label","CP"));
			}
			if(val == 'AssessmentCategory'){
				parent.frames[1].location.href = '../../eCP/jsp/AssessmentCategory.jsp?module_id=CP&function_id=CodeSet&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.AssessmentCategory.label","CP"));
			}
			if(val == 'Outcome'){
				parent.frames[1].location.href = '../../eCP/jsp/Outcome.jsp?module_id=CP&function_id=Outcome&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("Common.outcome.label","common"));
			}
			if(val == 'Dependency'){
				parent.frames[1].location.href = '../../eCP/jsp/Dependency.jsp?module_id=CP&function_id=Dependency&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("Common.Dependency.label","Common"));
			}
			if(val == 'Stage'){
				parent.frames[1].location.href = '../../eCP/jsp/Stage.jsp?module_id=CP&function_id=Stage&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("Common.Stage.label","Common"));
			}
			if(val == 'PatientClassForStage'){
				parent.frames[1].location.href = '../../eCP/jsp/PatientClassForStage.jsp?module_id=CP&function_id=PatClassForStage&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.PatientClassforStage.label","CP"));
			}
			if(val == 'PositionForMDCP')
			{
				parent.frames[1].location.href = '../../eCP/jsp/PositionForMDCP.jsp?module_id=CP&function_id=PositionForMDCP&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.PositionForMulti-DisciplinaryCarePlan.label","CP"));
			}
/*			if(val == 'LOCForDependency'){
				parent.frames[1].location.href = ''../../eCP/jsp/LevelOfCareForDependency.jsp?module_id=CP&function_id=CodeSet&function_name=LOC for Dependency&function_type=F&access=YYYNN';
			}*/
			if(val == 'Library'){
				parent.frames[1].location.href = '../../eCP/jsp/LibrarySetUp.jsp?module_id=CP&function_id=CodeSet&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.Library.label","CP"));
			}
			if(val == 'BuildLibrary'){
				parent.frames[1].location.href = '../../eCP/jsp/BuildLibrary.jsp?module_id=CP&function_id=BuildLibrary&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.BuildLibrary.label","CP"));
			}
			if(val == 'LibraryForCaseType'){
				parent.frames[1].location.href = '../../eCP/jsp/LibraryForCaseType.jsp?module_id=CP&function_id=LibraryForCaseType&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.LibraryforCaseType.label","CP"));
			}
			if(val == 'Assessment Note'){
				parent.frames[1].location.href = '../../eCP/jsp/AssessmentNote.jsp?module_id=CP&function_id=AssessmentNote&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.AssessmentNote.label","CP"));
			}
			if(val == 'SpecialtyForAssessmentNote'){
				parent.frames[1].location.href = '../../eCP/jsp/SpecialtyForAssessmentNote.jsp?module_id=CP&function_id=CodeSet&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.SpecialtyForAssessmentNote.label","CP"));
			}
			if(val == 'AssessmentCategoryForAssessmentNote'){
				parent.frames[1].location.href = '../../eCP/jsp/AssessmentCategoryForAssessmentNote.jsp?module_id=CP&function_id=CodeSet&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.AssessmentCategoryforAssessmentNote.label","CP"));
			}
			if(val == 'PractTypeForAssessmentNote'){
				parent.frames[1].location.href = '../../eCP/jsp/PractTypeForAssessmentNote.jsp?module_id=CP&function_id=CodeSet&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.PractTypeforAssessmentNote.label","CP"));
			}
			if(val == 'AgeGroupForAssessmentNote'){
				parent.frames[1].location.href = '../../eCP/jsp/AgeGroupForAssessNote.jsp?module_id=CP&function_id=CodeSet&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.AgeGroupforAssessmentNote.label","CP"));
			}
			if(val == 'AssessmentDependencyClassification'){
				parent.frames[1].location.href = '../../eCP/jsp/AssessBasedDepClassfication.jsp?module_id=CP&function_id=CodeSet&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.AssessmentBasedDependencyClassification.label","CP"));
			}
			if(val == 'AssessmentTriggeredTermCode'){
				parent.frames[1].location.href = '../../eCP/jsp/AssessmentBasedTerminologyCode.jsp?module_id=CP&function_id=AssessmentTriggeredTermCode&function_type=F&access=YNNNN&function_name='+encodeURIComponent(getLabel("eCP.AssessmentBasedTerminologyCode.label","CP"));
			}
			if(val == 'CPParam'){
				parent.frames[1].location.href = '../../eCP/jsp/CareplanParameter.jsp?module_id=CP&function_id=CPParam&function_type=F&access=NYNNN&function_name='+encodeURIComponent(getLabel("Common.Parameters.label","Common"));
			}
		/*	if(val == 'StaffRequirement'){
				parent.frames[1].location.href = ''../../eCP/jsp/StaffRequirement.jsp?module_id=CP&function_id=StaffRequirement&function_name=Staff Requirement &function_type=F&access=YYYNN';
			}*/
			if(val == 'TermCodeForCaseType'){
				parent.frames[1].location.href = '../../eCP/jsp/TerminologyCodeForCaseType.jsp?module_id=CP&function_id=TermCodeForCaseType&function_type=F&access=NYNNN&function_name='+encodeURIComponent(getLabel("eCP.TerminologyCodeforCaseType.label","CP"));
			}
			if(val == 'CPReason'){
				parent.frames[1].location.href = '../../eCP/jsp/Reason.jsp?module_id=CP&function_id=CPReason&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("Common.reason.label","Common"));
			}
			/*if(val == 'CPAccessRights'){
				parent.frames[1].location.href = '../../eCP/jsp/new1.jsp?module_id=CP&function_id=Testing&function_name=Testing&function_type=F&access=YYYNN';
			}*/
			if(val == 'CriteriaForAssessmentCategory'){
				parent.frames[1].location.href = '../../eCP/jsp/CriteriaForAssessmentCategory.jsp?module_id=CP&function_id=CriteriaForAssessmentCategory&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.CriteriaforAssessmentCategory.label","CP"));
			}
			if(val == 'AssessmentCriteriaScore')
			{
				parent.frames[1].location.href = '../../eCP/jsp/AssessmentCriteriaScores.jsp?module_id=CP&function_id=AssessmentCriteriaScores&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.AssessmentCriteriaScore.label","CP"));
			}
			if(val == 'VarianceCause')
			{
				parent.frames[1].location.href = '../../eCP/jsp/VarianceCause.jsp?module_id=CP&function_id=VarianceCause&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.VarianceCause.label","CP"));
			}
			if(val == 'VarianceReason')
			{
				parent.frames[1].location.href = '../../eCP/jsp/VarianceReason.jsp?module_id=CP&function_id=VarianceReason&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("eCP.VarianceReason.label","CP"));
			}
			if(val == 'TermCodeEvalMeasures')
			{
				parent.frames[1].location.href = '../../eCP/jsp/TermCodeEvalMeasure.jsp?module_id=CP&function_id=TermCodeEvalMeasures&function_type=F&access=YYNNN&function_name='+encodeURIComponent(getLabel("eCP.TerminologyCodeEvaluationMeasures.label","CP"));
			}
			
		}

	function showFunctionality(){
		var retVal = new Array();

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';
		var arguments	= '' ;

		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;

		arguments = vals

		retVal	= window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}

	</script>

	</head>

	<body style="background-color:dimgray;"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>

	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		<tr>
			<td  class='ECMENUHIGHERLEVELCOLOR' onClick=""><fmt:message key="eCP.CarePlanSetup.label" bundle="${cp_labels}"/></td>
		</tr>
<!-- 		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CPReason')"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		</tr> -->
<!--
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PositionForMDCP')">Position for MDCP</td>
		</tr>
-->
<!-- 		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Outcome')"><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
		</tr> -->

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CPReason')"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Outcome')"><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
		</tr>


		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CaseType')"><fmt:message key="eCP.CaseType.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TermCodeForCaseType')"><fmt:message key="eCP.TerminologyCodeforCaseType.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TermCodeEvalMeasures')"><fmt:message key="eCP.TerminologyCodeEvaluationMeasures.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Stage')"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatientClassForStage')"><fmt:message key="eCP.PatientClassforStage.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Library')"><fmt:message key="eCP.Library.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BuildLibrary')"><fmt:message key="eCP.BuildLibrary.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('LibraryForCaseType')"><fmt:message key="eCP.LibraryforCaseType.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Dependency')"><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/></td>
		</tr>
<!--		<tr onclick='chcol(this)'
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('LOCForDependency')">LOC for Dependency</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('StaffRequirement')">Staff Requirement</td>
		</tr>-->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AssessmentCategory')"><fmt:message key="eCP.AssessmentCategory.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Assessment Note')"><fmt:message key="eCP.AssessmentNote.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpecialtyForAssessmentNote')"><fmt:message key="eCP.SpecialtyForAssessmentNote.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PractTypeForAssessmentNote')"><fmt:message key="eCP.PractTypeforAssessmentNote.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AgeGroupForAssessmentNote')"><fmt:message key="eCP.AgeGroupforAssessmentNote.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AssessmentCategoryForAssessmentNote')"><fmt:message key="eCP.AssessmentCategoryforAssessmentNote.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CriteriaForAssessmentCategory')"><fmt:message key="eCP.CriteriaforAssessmentCategory.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AssessmentCriteriaScore')"><fmt:message key="eCP.AssessmentCriteriaScore.label" bundle="${cp_labels}"/></td>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AssessmentTriggeredTermCode')"><fmt:message key="eCP.AssessmentBasedTerminologyCode.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AssessmentDependencyClassification')"><fmt:message key="eCP.AssessmentBasedDependencyClassification.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('VarianceCause')"><fmt:message key="eCP.VarianceCause.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('VarianceReason')"><fmt:message key="eCP.VarianceReason.label" bundle="${cp_labels}"/></td>
		</tr>
		<!-- Admin Functions Section -->
		<tr>
			<td  class='ECMENUHIGHERLEVELCOLOR' onClick=""><fmt:message key="eCP.CarePlanAdminSetup.label" bundle="${cp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CPParam')"><fmt:message key="Common.Parameters.label" bundle="${common_labels}"/></td>
		</tr>
<!-- 		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CPAccessRights')">Testin</td>
		</tr> -->

		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href="javascript:goHomePage()" style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>
	</table>
    </form>
	</body>

</html>

