<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%> 
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="JavaScript">
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array(); 

		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		} 
		
		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
			
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
			

			if(val == 'TreatmentAreaforClinic'){
     var funtitle=encodeURIComponent(getLabel("eAE.TreatmentAreaforLocation.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/TreatmentAreaforClinic.jsp?module_id=AE&function_id=AE_TMT_AREA_FOR_CLINIC&function_name='+funtitle+'&function_type=F&access=YYYNN';
			}
			if(val == 'BayType'){
				 var funtitle=encodeURIComponent(getLabel("eAE.BedBayType.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/AEBayType.jsp?module_id=AE&function_id=AE_BAY_TYPE&function_name='+funtitle+'&function_type=F&access=YYYNN';
			}
			
			if(val == 'SpareBays'){
               var funtitle=encodeURIComponent(getLabel("eAE.BedBay.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/SpareBays.jsp?module_id=AE&function_id=AE_BED_FOR_TRMT_AREA&function_name='+funtitle+'&function_type=F&access=YYYNN';
			}
			 
				//------------------	
			
	/*		 if(val == 'BedforTreatmentArea'){
				parent.frames[1].location.href = '../../eAE/jsp/BedforTreatmentArea.jsp?module_id=AE&function_id=AE_BED_FOR_TRMT_AREA&function_name=Bays For Treatment Area&function_type=F&access=YYYNN';
			}
 
*/
			if(val == 'AssignSpareBaysforTreatmentArea'){
                var funtitle=encodeURIComponent(getLabel("eAE.AssignBedBaysForTreatmentArea.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/AssignSpareBaysToTreatmentArea.jsp?module_id=AE&function_id=AE_BED_FOR_TRMT_AREA&function_name='+funtitle+'&function_type=F&access=YYYNN';
			}



		//------------------
			
			
			if(val == 'PractitionerforTreatmentArea'){
				var funtitle=encodeURIComponent(getLabel("eAE.Practitionerfor.label",'AE'));
                  funtitle=funtitle+' '+encodeURIComponent(getLabel("Common.treatmentarea.label",'Common'));
				parent.frames[1].location.href = '../../eAE/jsp/PractforTreatmentArea.jsp?module_id=AE&function_id=AE_PRACT_FOR_TMT_AREA&function_name='+funtitle+'&function_type=F&access=YYYYN';
			}


/*			if(val == 'AccidentType'){
				parent.frames[1].location.href = '../../eAE/jsp/AccidentType.jsp?module_id=AE&function_id=AE_ACCIDENT_TYPE&function_name=Accident Type&function_type=F&access=YYYNN';
			}
			if(val == 'RTA'){
				parent.frames[1].location.href = '../../eAE/jsp/RTA.jsp?module_id=AE&function_id=AE_RTA_CODE&function_name=Road Traffic Accident&function_type=F&access=YYYNN';
			}
			if(val == 'AccidentCause'){
				parent.frames[1].location.href = '../../eAE/jsp/AccidentCause.jsp?module_id=AE&function_id=AE_ACCIDENT_CAUSE&function_name=Accident Cause&function_type=F&access=YYYNN';
			}
*/
			if(val == 'PatientPosition'){
				var funtitle=encodeURIComponent(getLabel("Common.PatientPosition.label",'Common'));
				parent.frames[1].location.href = '../../eAE/jsp/PatientPosition.jsp?module_id=AE&function_id=AE_PAT_POSITION&function_name='+funtitle+'&function_type=F&access=YYYNN';
			}
			if(val == 'ProtectiveDevice'){
				var funtitle=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/ProtectiveDevice.jsp?module_id=AE&function_id=AE_PROTECTIVE_DEVICE&function_name='+funtitle+'&function_type=F&access=YYYNN';
			}
			/*if(val == 'PatientSymptom'){
				parent.frames[1].location.href = '../../eAE/jsp/PatientSymptom.jsp?module_id=AE&function_id=AE_PATIENT_SYMPTOM&function_name=Patient Symptom&function_type=F&access=YYYNN';
			} */
	/*		if(val == 'SuddenOnset'){
				parent.frames[1].location.href = '../../eAE/jsp/SuddenOnset.jsp?module_id=AE&function_id=AE_SUDDEN_ONSET&function_name=Sudden Onset&function_type=F&access=YYYNN';
			}
			*/

	
			if(val == 'Question'){
				var funtitle=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/Responsibility.jsp?module_id=AE&function_id=AE_RESP&function_name=Responsibility&function_type=F&access=YYYNN';
			}
			if(val == 'Questionnaire'){ 
				var funtitle=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/FacilityforResponsibility.jsp?module_id=AE&function_id=AE_RESP_FCY&function_name=Responsibility for Facility&function_type=F&access=YYYNN';
			}
			if(val == 'QuestionforQuestionnaire'){
				var funtitle=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/AddModifyMenuRstrnForResp.jsp?module_id=AE&function_id=MENU_RSTRN_FOR_RESP&function_name=Menu Restriction for Responsibility&function_type=F&access=YYNNY';
			} 
			if(val == 'PatientCondition'){
				var funtitle=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/User.jsp?module_id=AE&function_id=AE_USER&function_name=User&function_type=F&access=YYYNN';
			}


			if(val == 'InjuryCategory'){
				var funtitle=encodeURIComponent(getLabel("eAE.InjuryCategory.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/InjuryCategory.jsp?module_id=AE&function_id=AE_INJ_CATEGORY&function_name='+funtitle+' &function_type=F&access=YYYNN';
			}
			if(val == 'InjurySubCategory'){
				var funtitle=encodeURIComponent(getLabel("eAE.InjurySubcategory.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/InjurySubCategory.jsp?module_id=AE&function_id=AE_INJURY_SUBCATEGORY&function_name='+funtitle+' &function_type=F&access=YYYNN';
			}





			/* 
				if(val == 'ComplaintDuration'){
				parent.frames[1].location.href = '../../eAE/jsp/ComplaintDuration.jsp?module_id=AE&function_id=AE_COMPLAINT_DURATION&function_name=Complaint Duration&function_type=F&access=YYYNN';
			}
			*/
			if(val == 'PatientPriority'){
				var funtitle=encodeURIComponent(getLabel("eAE.PatientPriority.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/PatientPriority.jsp?module_id=AE&function_id=AE_PATIENT_PRIORITY&function_name='+funtitle+'&function_type=F&access=YYYNN';
			}


	/*		if(val == 'AnotomicalSite'){
				parent.frames[1].location.href = '../../eAE/jsp/AnatomicalSite.jsp?module_id=AE&function_id=AE_ANATOMICAL_SITE&function_name=Anatomical Site&function_type=F&access=YYYNN';
			}
			if(val == 'Responsiveness'){
				parent.frames[1].location.href = '../../eAE/jsp/Responsiveness.jsp?module_id=AE&function_id=AE_RESPONSIVENESS&function_name=Responsiveness&function_type=F&access=YYYNN';
			}
*/
			
			if(val == 'InjuryType'){
				var funtitle=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label",'AE'));
				parent.frames[1].location.href = '../../servlet/eAE.PrinterServlet?module_id=AE&function_id=SM_PRINTER&function_name=Printer&function_type=F&access=YYYNN';
			}
			if(val == 'InjurySeverityScore'){
				var funtitle=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label",'AE'));
				parent.frames[1].location.href = '../../servlet/eAE.ReportServiceServlet?module_id=AE&function_id=SM_REPORT_SERVICE&function_name=Report Service&function_type=F&access=YYYNN';
			}


			if(val == 'GCSResponse'){
				var funtitle=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/GCSResponse.jsp?module_id=AE&function_id=AE_GCS_RESPONSE&function_name=GCS Category&function_type=F&access=NNNNN';
			}
			if(val == 'GCSforResponse'){
				var funtitle=encodeURIComponent(getLabel("eAE.GCSforResponse.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/GCSforResponse.jsp?module_id=AE&function_id=AE_GCS_FOR_RESPONSE&function_name='+funtitle+'&function_type=F&access=NYYNN';
			}
			if(val == 'GCSScore'){
				var funtitle=encodeURIComponent(getLabel("eAE.GCSScore.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/GCSScore.jsp?module_id=AE&function_id=AE_GCS_SCORE&function_name='+funtitle+'&function_type=F&access=NYNNN';
			}

 
			if(val == 'RevisedTraumaScore'){
				var funtitle=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/PrintRoutingMain.jsp?module_id=AE&function_id=SM_PRINT_ROUTING&function_name=Print Routing&function_type=F&access=YYYYN';
			}

			
			if(val == 'TraumaInjurySeverityScore'){
				var funtitle=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/FreqAccessFunc.jsp?module_id=AE&function_id=FREQ_ACCESS_FUNC&function_name=Frequently Accessed Functions&function_type=F&access=NNNNN';
			}
			if(val == 'Immobilization'){
				var funtitle=encodeURIComponent(getLabel("eAE.Immobilization.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/Immobilization.jsp?module_id=AE&function_id=AE_IMMOBILIZATION&function_name='+funtitle+'&function_type=F&access=YYYNN';
			}
// ********* Disaster Type ***********
			if(val == 'DisasterType'){
				var funtitle=encodeURIComponent(getLabel("eAE.DisasterType.label",'AE'));
				parent.frames[1].location.href = '../../eAE/jsp/AEDisasterType.jsp?module_id=AE&function_id=AE_DISASTER_TYPE&function_name='+funtitle+'&function_type=F&access=YYYNN';
			}
		}
		 
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body style="background-color:dimgray;" onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name="SMMasterMenu_form" id="SMMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TreatmentAreaforClinic')" ><fmt:message key="eAE.TreatmentAreaforLocation.label" bundle="${ae_labels}"/></a></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BayType')" ><fmt:message key="eAE.BedBayType.label" bundle="${ae_labels}"/></a></td>
		</tr>
		<!-- -------------------- -->
	<!-- 	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BedforTreatmentArea')" >Bays For Treatment Area</a></td>
		</tr>  -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpareBays')" ><fmt:message key="eAE.BedBay.label" bundle="${ae_labels}"/></a></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AssignSpareBaysforTreatmentArea')" ><fmt:message key="eAE.AssignBedBaysForTreatmentArea.label" bundle="${ae_labels}"/></a></td>
		</tr>

<!-- -------------------- -->
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PractitionerforTreatmentArea')" ><fmt:message key="eAE.Practitionerfor.label" bundle="${ae_labels}"/><br><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></a></td>
		</tr>

		<tr><td class="BLANK_ROW">&nbsp;</td></tr>
		
		<!-- <tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AccidentType')" >Accident Type</a></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("AccidentCause")' >Accident Cause</a></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("RTA")' >Road Traffic Accident</a></td>
		</tr>	 -->
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("PatientPosition")' ><fmt:message key="Common.PatientPosition.label" bundle="${common_labels}"/></a></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("ProtectiveDevice")' ><fmt:message key="eAE.ProtectiveDevice.label" bundle="${ae_labels}"/></a></td>
		</tr>			
		<!-- <tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("PatientSymptom")' >Patient Symptom</a></td>
		</tr>	 -->
<!-- 		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("SuddenOnset")' >Sudden Onset</a></td>
		</tr> -->	
	
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

<!-- 		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("Question")' >Question</a></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("Questionnaire")' >Questionnaire</a></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("QuestionforQuestionnaire")' >Question for Questionnaire</a></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("PatientCondition")' >Patient Condition</a></td>
		</tr>
 -->	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("InjuryCategory")' ><fmt:message key="eAE.InjuryCategory.label" bundle="${ae_labels}"/></a></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("InjurySubCategory")' ><fmt:message key="eAE.InjurySubcategory.label" bundle="${ae_labels}"/></a></td>
		</tr>
		
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>
		
	<!-- 	<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("ComplaintDuration")' >Complaint Duration</a></td>
		</tr> -->
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("PatientPriority")' ><fmt:message key="eAE.PatientPriority.label" bundle="${ae_labels}"/></a></td>
		</tr>

		<tr><td class="BLANK_ROW">&nbsp;</td></tr>
		
	<!-- 	<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("AnotomicalSite")' >Anatomical Site</a></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("Responsiveness")'>Responsiveness</a></td>
		</tr> -->		
		
<!-- 		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("InjuryType")' >Injury Type </a></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("InjurySeverityScore")' >Injury Severity Score</a></td>
		</tr>

 -->		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

<!-- 		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("GCSResponse")' >GCS Category</a></td>
		</tr> -->
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("GCSforResponse")' ><fmt:message key="eAE.GCSforResponse.label" bundle="${ae_labels}"/></a></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("GCSScore")' ><fmt:message key="eAE.GCSScore.label" bundle="${ae_labels}"/></a></td>
		</tr>
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("Immobilization")' ><fmt:message key="eAE.Immobilization.label" bundle="${ae_labels}"/></a></td>
		</tr>
		<!-- **************** Disaster Type ******************** -->
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("DisasterType")' ><fmt:message key="eAE.DisasterType.label" bundle="${ae_labels}"/></a></td>
		</tr>
	<!-- 	<tr><td class="BLANK_ROW">&nbsp;</td></tr>

		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("RevisedTraumaScore")' >Revised Trauma Score</a></td>
		</tr>
		
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("TraumaInjurySeverityScore")' >Trauma Injury Severity<br>Score</a></td>
		</tr>
		 -->
		<tr>
			<td class='MENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td> 
<!-- 			<td class='MENUHIGHERLEVELCOLOR' onClick=javascript:goHomePage() class='MENUHIGHERLEVELLINK'><b>HOME</b></td>
 -->		</tr>
		</table>

	</body>
	
	</form>
</html>

