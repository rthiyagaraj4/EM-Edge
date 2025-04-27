<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");%>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById('t').rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
			if(val == 'AmbulatoryStatus')
				parent.frames[1].location.href = '../../eAM/jsp/AmbulatoryStatus.jsp?module_id=AM&function_id=AMBULATORY_STATUS&function_name='+encodeURIComponent(getLabel("Common.ambulatorystatus.label","Common"))+'&function_type=F&access=YYYNN';
			if(val == 'CircumstanceofInjury')
				parent.frames[1].location.href = '../../eAM/jsp/CircumstanceofInjury.jsp?module_id=AM&function_id=CIRCUMSTANCE_OF_INJURY&function_name='+encodeURIComponent(getLabel("Common.CircumstanceofInjury.label","Common"))+'&function_type=F&access=YYYNN';
			if(val == 'Complaint')
				parent.frames[1].location.href = '../../eAM/jsp/Complaints.jsp?module_id=AM&function_id=COMPLAINTS&function_name='+encodeURIComponent(getLabel("Common.ReasonforAdmission.label","Common"))+'&function_type=F&access=YYYNN';
			if(val == 'DispositionofType')
				parent.frames[1].location.href = '../../eAM/jsp/DispositionType.jsp?module_id=AM&function_id=DISPOSITION_TYPE&function_name='+encodeURIComponent(getLabel("Common.DispType.label","Common"))+'&function_type=F&access=YYYNN';
            if(val == 'EscortType')
				parent.frames[1].location.href = '../../eAM/jsp/EscortType.jsp?module_id=AM&function_id=ESCORT_TYPE&function_name='+encodeURIComponent(getLabel("eAM.EscortType.label","am"))+'&function_type=F&access=YYYNN'; 
			if(val == 'TransportMode')
				parent.frames[1].location.href = '../../eAM/jsp/TransportMode.jsp?module_id=AM&function_id=TransportMode&function_name='+encodeURIComponent(getLabel("Common.TransportMode.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'ModeofArrival')
				parent.frames[1].location.href = '../../eAM/jsp/Arrival.jsp?module_id=AM&function_id=ARRIVAL&function_name='+encodeURIComponent(getLabel("Common.ModeofArrival.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'PatientInstruction')
				parent.frames[1].location.href = '../../eAM/jsp/PatientInstruction.jsp?module_id=AM&function_id=PATIENT_INSTRUCTIONS&function_name='+encodeURIComponent(getLabel("Common.patientinstruction.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'PatientType')
				parent.frames[1].location.href = '../../eAM/jsp/PatientType.jsp?module_id=AM&function_id=PATIENT_TYPE&function_name='+getLabel("Common.patienttype.label","common")+'&function_type=F&access=YYYNN';
			if(val == 'PatientTypeClass')
				parent.frames[1].location.href = '../../eAM/jsp/PatTypeClass.jsp?module_id=AM&function_id=PATIENT_TYPE_CLASS&function_name='+encodeURIComponent(getLabel("eAM.PatientTypeClass.label","am"))+'&function_type=F&access=YYYNN';
			if(val == 'Reason')
				parent.frames[1].location.href = '../../eAM/jsp/ContactReason.jsp?module_id=AM&function_id=CONTACT_REASON&function_name='+encodeURIComponent(getLabel("Common.reason.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'SummarizationRange')
				parent.frames[1].location.href = '../../servlet/eAM.AgeRangeServlet?module_id=AM&function_id=SUMM_RANGES&function_name='+encodeURIComponent(getLabel("eAM.SummarizationRange.label","am"))+'&function_type=F&access=YYYNN';
			if(val == 'VisitAnalysisCode')
				parent.frames[1].location.href = '../../eAM/jsp/Visitanalysiscode.jsp?module_id=AM&function_id=VISIT_ANALYSIS_CODE&function_name='+encodeURIComponent(getLabel("eAM.VisitAnalysisCode.label","am"))+'&function_type=F&access=YYYNN';			
			if(val == 'AgeGroup')
				parent.frames[1].location.href = '../../eAM/jsp/GenderGroup.jsp?module_id=AM&function_id=AGE_GROUP&function_name='+encodeURIComponent(getLabel("Common.agegroup.label","Common"))+'&function_type=F&access=YYYNN';
			if(val == 'Specimen')
				parent.frames[1].location.href = '../../eAM/jsp/Specimen.jsp?module_id=AM&function_id=SPECIMEN&function_name='+encodeURIComponent(getLabel("Common.Specimen.label","Common"))+'&function_type=F&access=YYYNN';
			if(val == 'DocumentType')
				parent.frames[1].location.href = '../../eAM/jsp/Documenttype.jsp?module_id=AM&function_id=DOCUMENT_TYPE&function_name='+encodeURIComponent(getLabel("Common.documenttype.label","Common"))+'&function_type=F&access=YYYNN';
			if(val == 'DocumentTypeDetails')
				parent.frames[1].location.href = '../../eAM/jsp/Doctypedtls.jsp?module_id=AM&function_id=DOCUMENT_TYPE_DTLS&function_name='+encodeURIComponent(getLabel("eAM.DocumentTypeDetails.label","am"))+'&function_type=F&access=YYYYN';
			if(val == 'Reaction')
				parent.frames[1].location.href = '../../eAM/jsp/Reaction.jsp?module_id=AM&function_id=REACTION&function_name='+encodeURIComponent(getLabel("Common.Reaction.label","Common"))+' &function_type=F&access=YYYNN';	
			if(val == 'AnatomicalSite')
				parent.frames[1].location.href = '../../eAM/jsp/AnatomicalSite.jsp?module_id=AM&function_id=AM_ANATOMICAL_SITE&function_name='+encodeURIComponent(getLabel("Common.AnatomicalSite.label","Common"))+'&function_type=F&access=YYYNN';		
			if(val == 'Anaesthesia')
				parent.frames[1].location.href = '../../eAM/jsp/Anaesthesia.jsp?module_id=AM&function_id=AM_ANAESTHESIA&function_name='+encodeURIComponent(getLabel("Common.Anaesthesia.label","Common"))+'&function_type=F&access=YYYNN';			
			if(val == 'EncounterNumbering')
				parent.frames[1].location.href = '../../eAM/jsp/OPEncounter.jsp?module_id=AM&function_id=ENCOUNTER_SERIES&function_name='+encodeURIComponent(getLabel("eAM.EncounterNumberingControl.label","am"))+'&function_type=F&access=NYNNY';
			if(val == 'SpltyForCatalog')
				parent.frames[1].location.href = '../../eAM/jsp/CatalogForSpecialty.jsp?module_id=AM&function_id=SPLTYFORCATALOG&function_name='+encodeURIComponent(getLabel("eAM.SpecialtyforCatalog.label","am"))+'&function_type=F&access=YYYNY';
			if(val == 'ModSpltyLink')
				parent.frames[1].location.href = '../../eAM/jsp/MSpecialityLink.jsp?module_id=AM&function_id=SPLTYLINK&function_name='+encodeURIComponent(getLabel("eAM.SpecialtyForModule.label","am"))+'&function_type=F&mode=insert&access=YYYNN';
		}

	</script>
	</head>

	<body OnMouseDown='CodeArrest()' style="background-color:dimgray;" onKeyDown = 'lockKey()'>
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AmbulatoryStatus');"><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CircumstanceofInjury');"><fmt:message key="Common.CircumstanceofInjury.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Complaint');"><fmt:message key="Common.ReasonforAdmission.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DispositionofType');"><fmt:message key="Common.DispType.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EscortType');"><fmt:message key="eAM.EscortType.label" bundle="${am_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TransportMode');"><fmt:message key="Common.TransportMode.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ModeofArrival');"><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
		</tr>
		 <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatientType');"><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td>
		</tr> 
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Reason');"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AgeGroup');"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
		</tr>
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Reaction');"><fmt:message key="Common.Reaction.label" bundle="${common_labels}"/></td>
		</tr> 
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AnatomicalSite');"><fmt:message key="Common.AnatomicalSite.label" bundle="${common_labels}"/></td>
		</tr>		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Anaesthesia');"><fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/></td>
		</tr>

		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EncounterNumbering');"><fmt:message key="eAM.EncounterNumberingControl.label" bundle="${am_labels}"/></td>
		</tr> 
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpltyForCatalog');"><fmt:message key="eAM.SpecialtyforCatalog.label" bundle="${am_labels}"/></td>
		</tr>
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ModSpltyLink');"><fmt:message key="eAM.SpecialtyForModule.label" bundle="${am_labels}"/></td>
		</tr>

		 <tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style="color:white"><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
		</tr> 
		
	</table>

	</body>
	</form>
</html>

