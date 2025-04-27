<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script language=JavaScript src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


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

			if(val == 'TermSet'){
				parent.frames[1].location.href = 'TermSet.jsp?module_id=CP&function_id=TermSet&function_name='+encodeURIComponent(getLabel("Common.TerminologySet.label","Common"))+'&function_type=F&access=NYYNN';
			}
			if(val == 'TermSetForPractType'){
				parent.frames[1].location.href = 'TerminologySetForPractitionerType.jsp?module_id=CP&function_id=TermSetForPractType&function_name='+encodeURIComponent(getLabel("eMR.TerminologySetforPractType.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'TermSetForSpecialty'){
				parent.frames[1].location.href = 'TerminologySetForSpecialty.jsp?module_id=CP&function_id=TermSetForSpecialty&function_name='+encodeURIComponent(getLabel("eMR.TerminologySetforSpecialty.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'TermSetForPractitioner'){
				parent.frames[1].location.href = 'TerminologySetForPractitioner.jsp?module_id=CP&function_id=TermSetForSpecialty&function_name='+encodeURIComponent(getLabel("eMR.TerminologySetforPractitioner.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'TermSetForFacility')
			{
				parent.frames[1].location.href = 'TerminologySetForFacility.jsp?module_id=CP&function_id=TermSetForFacility&function_name='+encodeURIComponent(getLabel("eMR.TerminologySetforFacility.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'TermCode')
			{
				parent.frames[1].location.href = 'TerminologyCode.jsp?module_id=CP&function_id=TerminologyCode&function_name='+encodeURIComponent(getLabel("Common.TerminologyCode.label","Common"))+'&function_type=F&access=NYNNN';
			}
			if(val == 'AgeGroupForTermCode')
			{
				parent.frames[1].location.href = 'AgeGroupForTermCode.jsp?module_id=CP&function_id=AgeGroupForTermCode&function_name='+encodeURIComponent(getLabel("eMR.AgeGroupforTerminologyCode.label","MR"))+'&function_type=F&access=NYNNN';
			}
			if(val == 'DiagnosisClassification')
			{
				parent.frames[1].location.href = 'DiagnosisClassification.jsp?module_id=CP&function_id=DiagnosisClassification&function_name='+encodeURIComponent(getLabel("eMR.DiagnosisClassification.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'Factor')
			{
				parent.frames[1].location.href = 'Factor.jsp?module_id=CP&function_id=Factor&function_name='+encodeURIComponent(getLabel("eMR.Factors.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'FactorForTermCode')
			{
				parent.frames[1].location.href = 'FactorsForTermCode.jsp?module_id=CP&function_id=FactorForTermCode&function_name='+encodeURIComponent(getLabel("eMR.FactorsforTerminologyCode.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'Accuracy')
			{
				parent.frames[1].location.href = 'Accuracy.jsp?module_id=CP&function_id=Accuracy&function_name='+encodeURIComponent(getLabel("Common.Accuracy.label","Common"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'AccuracyforPatientClass')
			{
				parent.frames[1].location.href = 'AccuracyForPatientClass.jsp?module_id=CP&function_id=AccuracyforPatientClass&function_name='+encodeURIComponent(getLabel("eMR.AccuracyForPatientClass.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'MDSforTerminologySet')
			{
				parent.frames[1].location.href = 'MDSForTerminologySet.jsp?module_id=CP&function_id=MDSforTerminologySet&function_name=MDS for Facility&function_type=F&access=YYYYN';
			}
			if(val == 'EOC')
			{
				parent.frames[1].location.href = 'EpisodeOfCare.jsp?module_id=CP&function_id=EpisodeOfCare&function_name='+encodeURIComponent(getLabel("eMR.EpisodeOfCare.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'TerminologyGroup')
			{
				parent.frames[1].location.href = 'TerminologyGroup.jsp?module_id=CP&function_id=TerminologyGroup&function_name='+encodeURIComponent(getLabel("eMR.TerminologyGroup.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'CUSTOM_LIST_TERMINOLOGY_GRP')
			{
				parent.frames[1].location.href = 'CustomListTerminologyGrp.jsp?module_id=CP&function_id=CUSTOM_LIST_TERMINOLOGY_GRP&function_name='+encodeURIComponent(getLabel("eMR.TerminologyGroupforCustomList.label","MR"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'NoteTerminologyCode')
			{
				parent.frames[1].location.href = 'NoteTerminologyCode.jsp?module_id=CP&function_id=NoteTerminologyCode&function_name='+encodeURIComponent(getLabel("eMR.NoteforTerminologyCode.label","MR"))+'&function_type=F&access=YYYNN';
			}
			/*if(val == 'EquivalentTermSetCode')
			{
				parent.frames[1].location.href = 'EquivalentTermCode.jsp?module_id=CP&function_id=EquivalentTermCode&function_name='+encodeURIComponent(getLabel("eMR.EquivalentTermSetCode.label","MR"))+'&function_type=F&access=YYYNN';
			}*/
			if(val == 'CrossReferenceRule')
			{
				parent.frames[1].location.href = 'EquivalentTermCode.jsp?module_id=CP&function_id=EquivalentTermCode&function_name='+encodeURIComponent(getLabel("eMR.CrossReferenceRule.label","MR"))+'&function_type=F&access=YYYNN';
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
			<td  class='ECMENUHIGHERLEVELCOLOR' onClick=""><fmt:message key="eMR.TerminologySetup.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TermSet')"><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TermSetForPractType')"> <fmt:message key="eMR.TerminologySetforPractType.label" bundle="${mr_labels}"/> </td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TermSetForSpecialty')"><fmt:message key="eMR.TerminologySetforSpecialty.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TermSetForPractitioner')"><fmt:message key="eMR.TerminologySetforPractitioner.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TermSetForFacility')"><fmt:message key="eMR.TerminologySetforFacility.label" bundle="${mr_labels}"/></td>
		</tr>
<!-- 		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MDSforTerminologySet')">MDS for Facility</td>
		</tr> -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TermCode')"><fmt:message key="Common.TerminologyCode.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AgeGroupForTermCode')"><fmt:message key="eMR.AgeGroupforTerminologyCode.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DiagnosisClassification')"><fmt:message key="eMR.DiagnosisClassification.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Factor')"><fmt:message key="eMR.Factors.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FactorForTermCode')"><fmt:message key="eMR.FactorsforTerminologyCode.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Accuracy')"><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AccuracyforPatientClass')"><fmt:message key="eMR.AccuracyForPatientClass.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TerminologyGroup')"><fmt:message key="eMR.TerminologyGroup.label" bundle="${mr_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CUSTOM_LIST_TERMINOLOGY_GRP')"><fmt:message key="eMR.TerminologyGroupforCustomList.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NoteTerminologyCode')"><fmt:message key="eMR.NoteforTerminologyCode.label" bundle="${mr_labels}"/></td>
		</tr>
	<!-- 	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EOC')">Episode Of Care</td>
		</tr> -->
		<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EquivalentTermSetCode')"><fmt:message key="eMR.EquivalentTermSetCode.label" bundle="${mr_labels}"/></td>
		</tr>--> 
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CrossReferenceRule')"><fmt:message key="eMR.CrossReferenceRule.label" bundle="${mr_labels}"/></td>
		</tr> 
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href="javascript:goHomePage()" style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
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

