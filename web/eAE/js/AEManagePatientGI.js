// Added/Modified by Nanda - 11/8/2002
var treatmentGender			=	new Array();
var clinicType				=	new Array();
var openToAllPractionerYN	=	new Array();
var openToAllPractForClnYN	=	new Array();
var specialtyForClinc	=	new Array();


treatmentGender[0]			=	'';
clinicType[0]				=	'';
openToAllPractionerYN[0]	=	'';
openToAllPractForClnYN[0]	=	'';

function checkBedNo()  
{  
	var	clinic_code			=	document.forms[0].clinic_code.value;
	var treatment_area_code	=	document.forms[0].treatment_area_code.value;
	var bed_bay_no	        =	document.forms[0].bed_bay_no.value;
	
	if (bed_bay_no != "") 
	{
		var bedNoFlag           = "Y"; 
		var HTMLVal="<html> <head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='AEMPDynamicForm' id='AEMPDynamicForm' method='post' action='../../eAE/jsp/AEMPDynamicValues.jsp'>"+
			"<input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'>"+
			"<input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+treatment_area_code+"'>"+
			"<input type='hidden' name='bed_bay_no' id='bed_bay_no' value='"+bed_bay_no+"'>"+
			"<input type='hidden' name='BedNoFlag' id='BedNoFlag' value='"+bedNoFlag+"'>"+
			"</form></body></html>";
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.parent.messageFrame.document.AEMPDynamicForm.submit();
	}
}

function populateDynamicValues(forField)
{

	
	if (document.forms[0].treatment_area_code && document.forms[0].assign_tmt_area_time)
	{
		if (document.forms[0].treatment_area_code.value.length>0)
		{
			document.forms[0].assign_tmt_area_time.disabled=false;
			document.forms[0].ok.disabled=false;
		}
		else
		{
			document.forms[0].assign_tmt_area_time.disabled=true;
			document.forms[0].ok.disabled=true;
		}
	}
	var frame_name = parent.frames[0].name;
	if(frame_name=="AEMPSearchCriteriaFrame")
		parent.AEMPSearchResultFrame.location.href = "../../eCommon/html/blank.html";
	var	clinic_code			=	document.forms[0].clinic_code;

	var practitioner_id		=	document.forms[0].practitioner_id;
	var treatment_area_code	=	document.forms[0].treatment_area_code;
	var open_to_all_pract_yn=	openToAllPractionerYN[clinic_code.selectedIndex];

	
	var	frame_name			=	"parent.f_query_add_mod.AEMPSearchCriteriaFrame";

	if(forField=="TreatmentArea")
	{
			document.forms[0].gender.disabled	=	false;
		document.forms[0].gender.value		=	'';

		var optlength = treatment_area_code.options.length;
		for (var i=0; i<optlength; i++)
		{
			treatment_area_code.options.remove("treatment_area_code");
		}

		var opt		=	document.createElement('OPTION'); 
		opt.text	=	'----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
		opt.value	=	'';
		treatment_area_code.add(opt); 

		var HTMLVal="<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='AEMPDynamicForm' id='AEMPDynamicForm' method='post' action='../../eAE/jsp/AEMPDynamicValues.jsp'>"+
		"<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='"+open_to_all_pract_yn+"'>"+
		"<input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code.value+"'>"+
		"<input type='hidden' name='frame_name' id='frame_name' value='"+frame_name+"'>"+
		"<input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+treatment_area_code+"'>"+
		"<input type='hidden' name='pop_mode' id='pop_mode' value='"+forField+"'>"+
		"</form></body></html>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.parent.messageFrame.document.AEMPDynamicForm.submit();
	}
	else if( (forField=="Practitioner") || (forField=="AssignTreatmentArea") )
	{

		var open_to_all_prac_for_clinic_yn	=	"";
		if(forField=="Practitioner")
		{
			open_to_all_prac_for_clinic_yn	=	openToAllPractForClnYN[treatment_area_code.selectedIndex];
		}
		else if (forField=="AssignTreatmentArea")
		{
			document.forms[0].practitioner_desc.value='';
			document.forms[0].practitioner_id.value='';

			frame_name	=	"parent.AEMPAssignTreatmentAreaFrame";
			forField	=	getLabel("Common.practitioner.label","Common");
			open_to_all_pract_yn			=	document.forms[0].open_to_all_pract_yn.value;
			open_to_all_prac_for_clinic_yn	=	openToAllPractForClnYN[treatment_area_code.selectedIndex];
		}		

		var HTMLVal="<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='AEMPDynamicForm' id='AEMPDynamicForm' method='post' action='../../eAE/jsp/AEMPDynamicValues.jsp'>"+
		"<input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code.value+"'>"+
		"<input type='hidden' name='frame_name' id='frame_name' value='"+frame_name+"'>"+
		"<input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+treatment_area_code.value+"'>"+
		"<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='"+open_to_all_pract_yn+"'>"+
		"<input type='hidden' name='open_to_all_prac_for_clinic_yn' id='open_to_all_prac_for_clinic_yn' value='"+open_to_all_prac_for_clinic_yn+"'>"+
		"<input type='hidden' name='pop_mode' id='pop_mode' value='"+forField+"'>"+
		"</form></body></html>";

		if (forField=="AssignTreatmentArea")
		{
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.messageFrame.document.AEMPDynamicForm.submit();
			
		}
		else
		{
			if(parent.parent.messageFrame==null)
			{	
				top.messageframe.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				top.messageframe.document.AEMPDynamicForm.submit();
			}
			else
			{				
				var HTML = escape(HTMLVal);
				setTimeout("SubmitHTML('"+HTML+"');", 500);
			}
			
		}
	}
}

function SubmitHTML(val)
{
	var HTMLVal = unescape(val);
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.parent.messageFrame.document.AEMPDynamicForm.submit();
}
function checkTreatmentGender()
{
	var treatment_area_code =	document.getElementById('treatment_area_code');
	var gender				=	document.getElementById('gender');

	var treatment_gender	=	treatmentGender[treatment_area_code.selectedIndex];
	if(treatment_gender!="")
	{
		gender.value	=	treatment_gender;
		gender.disabled	=	true;
	}
	else
	{
		gender.value	=	treatment_gender;
		gender.disabled	=	false;
	}
		document.forms[0].practitioner_desc.value='';
		document.forms[0].practitioner_id.value='';

}

/***************************************************/
function showQueryResult(from,treat_area_code)
{
var frameRef="";
if(from=='waitlist')
	frameRef=parent.parent;
else if(from=='reset')
	frameRef=top.content.frames[1];
else
	frameRef=parent;

		var clinic_code		=	frameRef.AEMPSearchCriteriaFrame.document.forms[0].clinic_code;
		var clinic_type		=	frameRef.AEMPSearchCriteriaFrame.document.forms[0].clinic_type;
		frameRef.AEMPSearchCriteriaFrame.document.forms[0].clinic_type.value			=	frameRef.AEMPSearchCriteriaFrame.clinicType[clinic_code.selectedIndex];

		var fields = new Array (frameRef.AEMPSearchCriteriaFrame.document.forms[0].patient_id);
		var names = new Array (getLabel("Common.patientId.label","Common"));	
		var error_jsp="../../eCommon/jsp/error.jsp";
		var messageFrame="";
		
		frameRef.AEMPSearchCriteriaFrame.document.forms[0].target	=	"AEMPSearchResultFrame";
		
		var oper_stn_id=frameRef.AEMPSearchCriteriaFrame.document.forms[0].oper_stn_id.value;
		var checkout_yn=frameRef.AEMPSearchCriteriaFrame.document.forms[0].checkout_yn.value;
			
		var clinic_code=frameRef.AEMPSearchCriteriaFrame.document.forms[0].clinic_code.value;
		var isAppearAsTabEnable=frameRef.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.isAppearAsTabEnable.value;
		var treatment_area_code=(isAppearAsTabEnable=='true' && (treat_area_code!=null && treat_area_code!=""))?treat_area_code:frameRef.AEMPSearchCriteriaFrame.document.forms[0].treatment_area_code.value;
		var practitioner_id=frameRef.AEMPSearchCriteriaFrame.document.forms[0].practitioner_id.value;
		var patient_id=frameRef.AEMPSearchCriteriaFrame.document.forms[0].patient_id.value;
		var priority=frameRef.AEMPSearchCriteriaFrame.document.forms[0].priority.value;
		var priority_zone=frameRef.AEMPSearchCriteriaFrame.document.forms[0].priority_zone.value;
		var tabIndicator = frameRef.AEMPSearchCriteriaFrame.document.forms[0].tabIndicator.value;
		var p_cutoff_hours_prv_day_visit= frameRef.AEMPSearchCriteriaFrame.document.forms[0].p_cutoff_hours_prv_day_visit.value;
		 //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
		 //Start
		 //alert("priority_zone= "+priority_zone);
		if(from=='reset' && (isAppearAsTabEnable==true || isAppearAsTabEnable =="true")) {		//alert("reset called");
			window.location.href=window.location.href;  	
		}else if(isAppearAsTabEnable=='true' && clinic_code!='') {
			frameRef.AEMPSearchCriteriaFrame.document.forms[0].treatment_area_code1.value=treatment_area_code;
		if((from!=null || from!="") && from=="refresh"){
				frameRef.AEMPSearchCriteriaFrame.document.forms[0].target	=	"tabs_frame";
				frameRef.AEMPSearchCriteriaFrame.document.forms[0].action	=	"../../eAE/jsp/AEManagePatGITabs.jsp?five_level_triage_appl_yn=N&oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&priority_zone="+priority_zone+"&tabIndicator="+tabIndicator+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit;
				frameRef.AEMPSearchCriteriaFrame.document.forms[0].method	=	"GET";
				frameRef.AEMPSearchCriteriaFrame.document.forms[0].submit();
			}
			
		}
			frameRef.AEMPSearchCriteriaFrame.document.forms[0].target	=	"AEMPSearchResultFrame";

		frameRef.AEMPSearchCriteriaFrame.document.forms[0].method	=	"GET";
		frameRef.AEMPSearchCriteriaFrame.document.forms[0].action	=	"../../eAE/jsp/AEManagePatGIPatientMang.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&priority_zone="+priority_zone+"&tabIndicator="+tabIndicator+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit;
		frameRef.AEMPSearchCriteriaFrame.document.forms[0].submit();
				
if(from=='waitlist'){
	

			if(SpecialCharCheck(fields,names,parent.parent.messageFrame,"M",error_jsp))
						frameRef.AEMPSearchCriteriaFrame.document.forms[0].submit();
	
}
else if(from=='reset'){
	
		if(SpecialCharCheck(fields,names,frames[2],"M",error_jsp))
						frameRef.AEMPSearchCriteriaFrame.document.forms[0].submit();
		
}
else{
		if(SpecialCharCheck(fields,names,parent.parent.parent.messageFrame,"M",error_jsp)) {
				//		frameRef.AEMPSearchCriteriaFrame.document.forms[0].submit();
		}
}

}

/************************************************/
async function showAllowedOperations( clinic_code,clinic_desc,clinic_type,patient_id, queue_status, encounter_id, triage_area, trauma_yn, treatment_area_code,practitioner_id, practitioner_name,treatment_area_desc, open_to_all_prac_for_clinic_yn, check_in_date_time, sys_date_time, queue_date, patient_gender,brought_dead,assign_tmt_area_time,open_to_all_pract_yn,patient_class, bed_no)
{
	var eid						=  	parent.AEMPSearchCriteriaFrame.document.forms[0].encounter_id;
	var retVal			=	"";
	var selection_mode	=	"";
	var query_string	=	"";
	query_string		= "patient_id="+patient_id+"&encounter_id="+encounter_id+"&queue_status="+queue_status+"&triage_area="+triage_area+"&trauma_yn="+trauma_yn+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&clinic_code="+clinic_code+"&clinic_type="+clinic_type+"&queue_date="+queue_date+"&encounter_id="+encounter_id+"&assign_tmt_area_time="+assign_tmt_area_time+"&brought_dead="+brought_dead+"&orig_tmt_area_code="+treatment_area_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&clinic_desc="+encodeURIComponent(clinic_desc)+"&treatment_area_desc="+encodeURIComponent(treatment_area_desc)+"&open_to_all_prac_for_clinic_yn="+open_to_all_prac_for_clinic_yn+"&check_in_date_time="+check_in_date_time+"&sys_date_time="+sys_date_time+"&patient_gender="+patient_gender+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&practitioner_name="+encodeURIComponent(practitioner_name)+"&bed_no="+bed_no;

	var dialogHeight	=	"";
	if(brought_dead=="N") 
	{
		if(triage_area=="A")	dialogHeight	=	"10" ;
		else if(triage_area=="B")	dialogHeight	=	"10" ;
		else if(triage_area=="C" && trauma_yn=="Y" )	dialogHeight	=	"13" ;
		else dialogHeight	=	"13" ;

	}
	else dialogHeight	=	"70vh" ;

	var dialogWidth		=	"70vw";
	var dialogTop		=	"0vh";
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal+"&"+query_string;

	if(queue_status=="01") dialogHeight	=	"7" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status + ";";
	retVal				=	await window.showModalDialog(action_url,arguments,features);
	

	if (retVal != null)
	{
		var retarr=retVal.split("|");
	var retVal1=retarr[0];
	
	var retVal2 = retarr[1];
		if( retVal1=="AssignTreatmentArea" || retVal1=="AssignReassignPractitioner" || retVal1=="ReassignTreatmentArea")
		{
			
			
			selection_mode		=	"AssignTreatmentArea";
			var dialogHeight	=	"70vh" ;

			var dialogWidth		=	"70vw";
			var dialogTop		=	"0vh";
			var status			=	"no";
			var arguments		=	"" ;
			var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal1+"&"+query_string;

		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";

			retVal	=	await window.showModalDialog(action_url,arguments,features);
			var retarr1=retVal.split("|");
	var retVal11=retarr[0];
	var retVal21 = retarr[1];
			if(retVal11!=null)
			{
				if(retVal11=="Success")
				{
					parent.AEMPSearchResultFrame.location.reload();
				}
			}
		}
		else if(retVal1=="StartConsultation")
		{

			
			var dialogHeight	=	"70vh" ;

			var dialogWidth		=	"70vw";
			var dialogTop		=	"0vh";
			var status			=	"no";
			var arguments		=	"" ;
			var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal+"&"+query_string;
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
		
			retVal	=	await window.showModalDialog(action_url,arguments,features);
			var retarr1=retVal.split("|");
	var retVal11=retarr[0];
	var retVal21 = retarr[1];
			if(retVal11!=null)
				if(retVal11=="Success")
					parent.AEMPSearchResultFrame.location.reload();
		}
		/*else if(retVal1=="PrimaryAssessment")
		{
			if(retVal2 == "N")
			{
			
			
			var retVal = "";
			var dialogHeight= "37" ;
			var dialogWidth	= "64" ;
			var dialogTop ="85";
			var status = "no";
			var arguments	= "" ;
			var action_url		=	"../../eAE/jsp/PrimaryAssessmentFrameset.jsp?"+query_string;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			retVal = window.showModalDialog(action_url,arguments,features);
			}
			else
			{
				var param = "../../eCA/jsp/InvokePatientHistoryAE.jsp?patient_id="+patient_id;
			param += "&child_window=Y&from_service_yn=Y&episode_id=";
			param += "&reln_req_yn=N&CA=Y&relationship_id=O&episode_type=&mode=V";
			param += "&location_code="+clinic_code+"&location_type="+clinic_type;
			window.open(param,'','height=570,width=790,top=0,left=0,resizable=yes,toolbar=no,menubar=no');
			}
			
		}
		else if(retVal1=="TraumaAssessment")
		{
			if(retVal2 == "N")
			{

			var retVal = "";
			var dialogHeight= "34" ;
			var dialogWidth	= "50" ;
			var dialogTop ="54";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			var action_url		=	"../../eAE/jsp/SecondaryAssessmentFrameset.jsp?"+query_string;
			retVal = window.showModalDialog(action_url,arguments,features);
			}
			else
			{
				var param = "../../eCA/jsp/InvokePatientHistoryAE.jsp?patient_id="+patient_id;
			param += "&child_window=Y&from_service_yn=Y&episode_id=";
			param += "&reln_req_yn=N&CA=Y&relationship_id=O&episode_type=&mode=V";
			param += "&location_code="+clinic_code+"&location_type="+clinic_type;
			window.open(param,'','height=570,width=790,top=0,left=0,resizable=yes,toolbar=no,menubar=no');
			}

		}
		else if(retVal1=="TraumaScore")
		{
			if(retVal2 == "N")
			{

				
			var retVal = "";
			var dialogHeight= "34" ;
			var dialogWidth	= "50" ;
			var dialogTop ="54";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			var action_url		=	"../../eAE/jsp/TraumaScoreFrameset.jsp?modify_flag=N&"+query_string;
			retVal = window.showModalDialog(action_url,arguments,features);
			}
			else
			{
				var param = "../../eCA/jsp/InvokePatientHistoryAE.jsp?patient_id="+patient_id;
			param += "&child_window=Y&from_service_yn=Y&episode_id=";
			param += "&reln_req_yn=N&CA=Y&relationship_id=O&episode_type=&mode=V";
			param += "&location_code="+clinic_code+"&location_type="+clinic_type;
			window.open(param,'','height=570,width=790,top=0,left=0,resizable=yes,toolbar=no,menubar=no');
			}
		}*///ViewPatHistoryDetails
		else if(retVal1=="Triage")
		{
				
			var retVal = "";
			var dialogHeight= "55vh" ;
			var dialogWidth	= "65vw" ;
			var dialogTop ="85";
			var status = "no";
			var arguments	= " ";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eAE/jsp/AETriageFrameset.jsp?selection_mode="+retVal+"&"+query_string,arguments,features);
		}
		else if(retVal1=="CheckOut")
		{
          
          await LoadChkOut(encounter_id,brought_dead,treatment_area_code,open_to_all_prac_for_clinic_yn,clinic_code,open_to_all_pract_yn,patient_id,clinic_type);
		}
		else if(retVal1=="ViewPatient")
		{
			
			var url			= "../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID="+patient_id+"&EncounterId="+encounter_id;
			var dialogTop		= "70";
			var dialogHeight	= "55vh";
			var dialogWidth		= "65vw";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
			var returnval = await window.showModalDialog( url, arguments, features ) ;
		}
		else if(retVal1=="MovementHistory")
		{// Added/Modified by Nanda - 11/14/2002
			
				
			var retVal = "";
			var dialogHeight= "55vh";
			var dialogWidth	= "65vw";
			var dialogTop ="150";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			var action_url		=	"../../eAE/jsp/AEMovementHistoryMain.jsp?modify_flag=N&"+query_string;
			retVal = await window.showModalDialog(action_url,arguments,features);
		}
		else if(retVal1=="ChartHistory")
		{
			var param = "../../eCA/jsp/InvokePatientHistoryAE.jsp?patient_id="+patient_id;
			param += "&child_window=Y&from_service_yn=Y&episode_id=";
			param += "&reln_req_yn=N&CA=Y&relationship_id=O&episode_type=&mode=V";
			param += "&location_code="+clinic_code+"&location_type="+clinic_type;
			window.open(param,'','height=570,width=790,top=0,left=0,resizable=yes,toolbar=no,menubar=no');
		}
	}
	window.location.reload();
}

async function showAllowedOperationsGraphic( clinic_code,clinic_desc,clinic_type,patient_id, queue_status, encounter_id, triage_area, trauma_yn, treatment_area_code,practitioner_id, practitioner_name,treatment_area_desc, open_to_all_prac_for_clinic_yn, check_in_date_time, sys_date_time, queue_date, patient_gender,brought_dead,assign_tmt_area_time,open_to_all_pract_yn,patient_class,priority_zone,brought_dead_yn,visit_type_code,pract_type,visit_num,episode_id)
{
	var called_from_ca = parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.called_from_ca.value;

	var CA_installed=parent.parent.AEMPSearchResultFrame.pat_result.document.forms[0].CAInstalled.value;
	//var CA_installed=parent.parent.AEMPSearchResultFrame.result.document.forms[0].CAInstalled.value; Thursday, June 10, 2010
	
	var action_on_pending_bill	= parent.parent.AEMPSearchResultFrame.pat_result.document.forms[0].action_on_pending_bill.value;
	var facility_id				= parent.parent.AEMPSearchResultFrame.pat_result.document.forms[0].facility_id.value;

	
	if(CA_installed=="N" || CA_installed=="")
	 {
	
	var retVal			=	"";
	var selection_mode	=	"";
	var query_string	=	"";

	query_string		= "patient_id="+patient_id+"&encounter_id="+encounter_id+"&queue_status="+queue_status+"&triage_area="+triage_area+"&trauma_yn="+trauma_yn+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&clinic_code="+clinic_code+"&clinic_type="+clinic_type+"&queue_date="+queue_date+"&encounter_id="+encounter_id+"&assign_tmt_area_time="+assign_tmt_area_time+"&brought_dead="+brought_dead+"&orig_tmt_area_code="+treatment_area_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&clinic_desc="+encodeURIComponent(clinic_desc)+"&treatment_area_desc="+encodeURIComponent(treatment_area_desc)+"&open_to_all_prac_for_clinic_yn="+open_to_all_prac_for_clinic_yn+"&check_in_date_time="+check_in_date_time+"&sys_date_time="+sys_date_time+"&patient_gender="+patient_gender+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&practitioner_name="+encodeURIComponent(practitioner_name)+"&priority_zone="+escape(priority_zone)+"&brought_dead_yn="+escape(brought_dead_yn)+"&visit_type_code="+escape(visit_type_code)+"&pract_type="+escape(pract_type);

	var dialogHeight	=	"";
	if(brought_dead=="N") 
	{
		if(triage_area=="A")	dialogHeight	=	"10" ;
		else if(triage_area=="B")	dialogHeight	=	"10" ;
		else if(triage_area=="C" && trauma_yn=="Y" )	dialogHeight	=	"13" ;
		else dialogHeight	=	"13" ;

	}
	else dialogHeight	=	"15vh" ;

	var dialogWidth		=	"25vw" ;
	var dialogTop		=	"250";
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal+"&"+query_string+"&detail_fn=Y&fn=lower";

	if(queue_status=="01") dialogHeight	=	"7" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status + ";";
	retVal				=	await window.showModalDialog(action_url,arguments,features);
	if (retVal != null){
		var retarr=retVal.split("|");
	var retVal1=retarr[0];	
	var retVal2 = retarr[1];

	if( retVal1=="AssignTreatmentArea" || retVal1=="AssignReassignPractitioner" || retVal1=="ReassignTreatmentArea") 
		{
			selection_mode		=	"AssignTreatmentArea";
			var dialogHeight	=	"70vh" ;

			var dialogWidth		=	"70vw";
			var dialogTop		=	"0vh";
			var status			=	"no";
			var arguments		=	"" ;
			var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal1+"&"+query_string;

		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
		    /*Modified for MMS-QH-CRF-0126.2 by Dharma Start*/
			/*retVal	=	window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
			{
				var retarr1=retVal.split("|");
	var retVal11=retarr[0];
	var retVal21 = retarr[1];
				if(retVal11=="Success")
				{
					parent.AEMPSearchResultFrame.location.reload();
				}
			}*/
		    
		   if(action_on_pending_bill=="N"){
		    	await FnProceedCAInstalledNo(action_url,arguments,features);
			}else{
				await FnCheckOPQBLValidation(visit_num,facility_id,action_on_pending_bill,patient_id,episode_id,'N','',action_url,arguments,features);
			}
		   /*Modified for MMS-QH-CRF-0126.2 by Dharma End*/
		}
		else if(retVal1=="StartConsultation")
		{

			
			var dialogHeight	=	"70vh" ;

			var dialogWidth		=	"70vw";
			var dialogTop		=	"0vh";
			var status			=	"no";
			var arguments		=	"" ;
			var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal1+"&"+query_string;
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
		    /*Modified for MMS-QH-CRF-0126.2 by Dharma Start*/
			/*retVal	=	window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
			{
				var retarr1=retVal.split("|");
				var retVal11=retarr[0];
				var retVal21 = retarr[1];
				if(retVal11=="Success")
					parent.AEMPSearchResultFrame.location.reload();
			}*/
		    
		    if(action_on_pending_bill=="N"){
		    	await FnProceedCAInstalledNo(action_url,arguments,features);
			}else{
				await FnCheckOPQBLValidation(visit_num,facility_id,action_on_pending_bill,patient_id,episode_id,'N','',action_url,arguments,features);
			}
		    /*Modified for MMS-QH-CRF-0126.2 by Dharma End*/
		}
		/*else if(retVal1=="PrimaryAssessment")
		{
			if(retVal2 == "N")
			{
			
			
			var retVal = "";
			var dialogHeight= "37" ;
			var dialogWidth	= "50" ;
			var dialogTop ="54";
			var status = "no";
			var arguments	= "" ;
			var action_url		=	"../../eAE/jsp/PrimaryAssessmentFrameset.jsp?"+query_string;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			retVal = window.showModalDialog(action_url,arguments,features);
			}
			else
			{
				var param = "../../eCA/jsp/InvokePatientHistoryAE.jsp?patient_id="+patient_id;
			param += "&child_window=Y&from_service_yn=Y&episode_id=";
			param += "&reln_req_yn=N&CA=Y&relationship_id=O&episode_type=&mode=V";
			param += "&location_code="+clinic_code+"&location_type="+clinic_type;
			window.open(param,'','height=570,width=790,top=0,left=0,resizable=yes,toolbar=no,menubar=no');
			}
			
		}
		else if(retVal1=="TraumaAssessment")
		{
			if(retVal2 == "N")
			{

			var retVal = "";
			var dialogHeight= "34" ;
			var dialogWidth	= "50" ;
			var dialogTop ="54";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			var action_url		=	"../../eAE/jsp/SecondaryAssessmentFrameset.jsp?"+query_string;
			retVal = window.showModalDialog(action_url,arguments,features);
			}
			else
			{
				var param = "../../eCA/jsp/InvokePatientHistoryAE.jsp?patient_id="+patient_id;
			param += "&child_window=Y&from_service_yn=Y&episode_id=";
			param += "&reln_req_yn=N&CA=Y&relationship_id=O&episode_type=&mode=V";
			param += "&location_code="+clinic_code+"&location_type="+clinic_type;
			window.open(param,'','height=570,width=790,top=0,left=0,resizable=yes,toolbar=no,menubar=no');
			}
		}
		else if(retVal1=="TraumaScore")
		{
			if(retVal2 == "N")
			{
			var retVal = "";
			var dialogHeight= "34" ;
			var dialogWidth	= "50" ;
			var dialogTop ="54";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			var action_url		=	"../../eAE/jsp/TraumaScoreFrameset.jsp?modify_flag=N&"+query_string;
			retVal = window.showModalDialog(action_url,arguments,features);
			}
			else
			{
				var param = "../../eCA/jsp/InvokePatientHistoryAE.jsp?patient_id="+patient_id;
			param += "&child_window=Y&from_service_yn=Y&episode_id=";
			param += "&reln_req_yn=N&CA=Y&relationship_id=O&episode_type=&mode=V";
			param += "&location_code="+clinic_code+"&location_type="+clinic_type;
			window.open(param,'','height=570,width=790,top=0,left=0,resizable=yes,toolbar=no,menubar=no');
			}
		}*///ViewPatHistoryDetails
		else if(retVal1=="Triage")
		{
			var retVal = "";
			var dialogHeight= "55vh";
			var dialogWidth	= "65vw";
			var dialogTop ="85";
			var status = "no";
			var arguments	= " ";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eAE/jsp/AETriageFrameset.jsp?selection_mode="+retVal+"&"+query_string,arguments,features);
		}
		else if(retVal1=="CheckOut")
		{	
			await LoadChkOut(encounter_id,brought_dead,treatment_area_code,open_to_all_prac_for_clinic_yn,clinic_code,open_to_all_pract_yn,patient_id,clinic_type);
		}
		else if(retVal1=="ViewPatient")
		{
			
			var url			= "../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID="+patient_id+"&EncounterId="+encounter_id;
			var dialogTop		= "70";
			var dialogHeight	= "55vh";
			var dialogWidth		= "65vw";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
			var returnval = await window.showModalDialog( url, arguments, features ) ;
		}
		else if(retVal1=="MovementHistory")
		{// Added/Modified by Nanda - 11/14/2002
			
				
			var retVal = "";
			var dialogHeight= "55vh";
			var dialogWidth	= "65vw";
			var dialogTop ="150";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			var action_url		=	"../../eAE/jsp/AEMovementHistoryMain.jsp?modify_flag=N&"+query_string;
			retVal = await window.showModalDialog(action_url,arguments,features);
		}
	 }
		if(retVal1!="AssignTreatmentArea" && retVal1!="AssignReassignPractitioner" && retVal1!="ReassignTreatmentArea" &&  retVal1!='StartConsultation')
			window.location.reload();
	
	 }//if CAInstalled loop
    else{
        
		var HTMLVal  = "<html>";
		HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp'>";
		HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + encounter_id + "'>";
		HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='AE'>";
		if(called_from_ca=="Y" )
	     {
			HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='N'>";
	     }
		 else
		 {
		    HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
		 }
		HTMLVal  += "</form>";
		HTMLVal  += "</html>";
	//	top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
		//[IN030566] Starts
		var xmlDoc 		= "";		
		var xmlHttp 	= new XMLHttpRequest();
		var	xmlStr			= "<root><SEARCH " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "../../eOR/jsp/EnterOrderValidate.jsp?patient_id="+patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		if(trimString(xmlHttp.responseText)=="true")
		{
			/*Modified for MMS-QH-CRF-0126.2 by Dharma Start*/
			//if(action_on_pending_bill=="N"){
				FnProceedCAInstalled(HTMLVal);
			//top.content.messageFrame.document.OpenChartWrapperForm.submit();
			//}else{ 
			//	FnCheckOPQBLValidation(visit_num,facility_id,action_on_pending_bill,patient_id,episode_id,'Y',HTMLVal);
			//}
			/*Modified for MMS-QH-CRF-0126.2 by Dharma End*/
			
		}			
		//top.content.messageFrame.document.OpenChartWrapperForm.submit();	
		//[IN030566] Ends
		}
		
}
function FnProceedCAInstalled(HTMLVal){ 
	top.content.dummyFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	top.content.dummyFrame.document.OpenChartWrapperForm.submit();
}

async function FnProceedCAInstalledNo(action_url,arguments,features){

	var retVal	=	await window.showModalDialog(action_url,arguments,features);
	if(retVal!=null)
	{
		var retarr1=retVal.split("|");
		var retVal11=retarr1[0];
		var retVal21 = retarr1[1];
		if(retVal11=="Success")
		{
			parent.AEMPSearchResultFrame.location.reload();
		}
	}
	window.location.reload();
}

function callOperation(operation,val)
{
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = operation+"|"+val;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
	//parent.window.close();
}

function cancelOperation()
{
	//parent.window.returnValue = "";
	//parent.window.close();
	parent.parent.document.getElementById("dialog_tag").close();
}

function assignTreatmentArea()
{
	var treatment_area_code	=	document.forms[0].treatment_area_code;
	var practitioner_id		=	document.forms[0].practitioner_id;
	document.forms[0].bed_bay_no.disabled = false;
	var bed_bay_no              =   document.forms[0].bed_bay_no;  
	var	selection_mode		=	document.forms[0].selection_mode;
	
	document.forms[0].assign_tmt_area_time.disabled=false;
	var triage_area_yn = document.forms[0].triage_area_yn.value;

	if(selection_mode.value!="AssignReassignPractitioner")
	{
		if(trimCheck(treatment_area_code.value)==false)
		{
			alert(getMessage("AE_TMT_AREA_BLANK","AE"));
			treatment_area_code.focus();
			return false;
		}
	  else if((triage_area_yn!="Y")&&(trimCheck(bed_bay_no.value)==false || bed_bay_no.value=='*ALL'))
		{

			//alert('APP-10000 Bed / Bay No Cannot be blank.');
			 var bedbayno=getMessage('SHOULD_NOT_BE_BLANK','Common')
			  bedbayno=bedbayno.replace("{1}",getLabel("Common.BedBayNo.label","Common"))
			bed_bay_no.focus();
			return false;
		}
	}
	else
	{
		if(trimCheck(practitioner_id.value)==false || practitioner_id.value=='*ALL')
		{
			alert(getMessage("AE_PRACTITIONER_BLANK","AE"));

			return false;
		}
	}
	treatment_area_code.disabled = false;
	
	if(top.messageframe==null)
	document.forms[0].target = "messageFrame";
	else
	document.forms[0].target = "messageframe";
   if(funQry())
	{
		document.forms[0].method = "POST";
		document.forms[0].ok.disabled = true;
		document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";
		document.forms[0].submit();
		document.forms[0].assign_tmt_area_time.disabled=true;
	}
	else
	{
		return false;
	}

}

async function funQry()
{
	if(document.forms[0].bl_install_yn.value=="Y")
	 {
            var retVal;
            var dialogHeight          = "55vh";
			var dialogWidth		      = "65vw";
            var dialogTop             = "210";
            var center                = "1" ; 
			var status                = "no";

            var features              = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
            var arguments             = "" ;
            var clinic_code           = document.forms[0].clinic_code.value
            var visit_type_code       = document.forms[0].visit_type_code.value;
            var patient_id            = document.forms[0].patient_id.value
            var episode_type          = "E"
            var episode_id            = document.forms[0].episode_id.value
            var visit_id              = document.forms[0].episode_visit_num.value
            var encounter_id          = document.forms[0].encounter_id.value
            var facility_id           = document.forms[0].facility_id.value
            var calling_module_id     = "AE"
            var calling_function_id   = "ASSIGN_PRACTITIONER";
            var logged_user_id        = document.forms[0].userid.value
            var practitioner_id       = document.forms[0].practitioner_id.value
            var practitioner_type_ind = "P"
            var url = "../../eBL/jsp/BLVisitChargeDetCloseConsultFrame.jsp?call_after_reg=Y&start_valid=Y&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id+"&logged_user_id="+logged_user_id+"&practitioner_id="+practitioner_id+"&practitioner_type_ind="+practitioner_type_ind;     

            retVal = await window.showModalDialog(url,arguments,features);

            if(retVal=="1")
            {        
				return true;   
            }
            else
            {
                return false;
            }
	 }
	 else
	 {
		return true;
	 }
}

function startConsultation()
{
	document.forms[0].target = parent.frames[2].name;
	document.forms[0].method = "POST";
	document.forms[0].ok.disabled=true;
	document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";
	document.forms[0].submit();
}

async function callPatientSearch()
{
	var patient_id	=	document.forms[0].patient_id;
	var retun_value =	"";

	return_value	=await PatientSearch(); 
	if(return_value!=null)
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}
async function LoadChkOut(eid,brought_dead,treatment_area_code,open_to_all_prac_for_clinic_yn,clinic_code,open_to_all_pract_yn,patient_id,clinic_type)
        {
          
			
			var retVal =    new String();
			
            var dialogTop	= "";
            var dialogHeight= "55vh";
			var dialogWidth	= "65vw";
            var status = "no";
            var scroll = "no";
            var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
            var arguments   = "" ;
			var h="p3="+eid+"&module_id=AE&ae_treatment_area_code="+treatment_area_code+"&ae_brought_dead_yn="+brought_dead+"&open_to_all_pract_clinic="+open_to_all_prac_for_clinic_yn+"&p5="+clinic_code+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&p2="+patient_id;
            retVal = await window.showModalDialog("../../eOP/jsp/PatCheckoutCall.jsp?"+h,arguments,features);
			window.location.reload();
        }
        

function reset (){

reset1();
}

function reset1()
{
	/*f_query_add_mod.tabs_frame.document.getElementById("critical").style.background='RED';		
	f_query_add_mod.tabs_frame.document.getElementById("semicritical").style.background='YELLOW';
	f_query_add_mod.tabs_frame.document.getElementById("noncritical").style.background='GREEN';
	f_query_add_mod.tabs_frame.document.getElementById("others").style.background='NAVY';*/
	
	var priority_zone_all_codes 	= $("#priority_zone_all_codes",f_query_add_mod.tabs_frame.document).val();
	priority_zone_all_codes			= priority_zone_all_codes.slice(0,-1);
	var arr_priority_zone_all_codes	= priority_zone_all_codes.split(","); 

	$.each(arr_priority_zone_all_codes,function(index,value){
		$("#priority_zone_tab_"+value,f_query_add_mod.tabs_frame.document).css('background-color', $("#priority_zone_color_"+value,f_query_add_mod.tabs_frame.document).val());
	});
	
	//f_query_add_mod.tabs_frame.document.forms[0].char_tab.src = '../images/PatientManagement.gif';
	//f_query_add_mod.tabs_frame.document.forms[0].others_tab.src = '../images/WaitingList_click.gif';
	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].reset();
		while(f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].treatment_area_code.options.length > 1)
					f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].treatment_area_code.remove(1);

	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].refresh.disabled = false;

    showQueryResult('reset');
}

function query()
{
	var	queue_refresh_interval	=	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].queue_refresh_interval.value;
	var	checkout_yn	=	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].checkout_yn.value;
	f_query_add_mod.location.href = "../../eAE/jsp/AEManagePatientMain.jsp?queue_refresh_interval="+queue_refresh_interval+"&checkout_yn="+checkout_yn;
}

/**********************************/

function beforeGetPractitioner2(obj,target_name)
{
	
	target_name.value = trimString(target_name.value);
	
		 if(target_name.value == "")
			{
			 document.forms[0].practitioner_desc.value="";
			 document.forms[0].practitioner_id.value="";
			 
			
			 return;
			}

			getPractitioner2(obj,target_name);
}

function getPractitioner2(obj,target, aFacilityID)
{
	var spec_code="";
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	var practitioner_type="";
	
	practName_FName=target.name;
	practName_FValue=target.value;
	var locale=document.forms[0].locale.value;
	var FirstSql="";
	var SecondSql="";
	var facility_id=document.forms[0].facility_id.value;
    var	clinic_code			=	document.forms[0].clinic_code.value;
	var practitioner_id		=	document.forms[0].practitioner_id.value;
	var treatment_area_code	=	document.forms[0].treatment_area_code.value;
	var p_desc	=	document.forms[0].practitioner_desc.value;

	if (p_desc==null) p_desc = "";
	var open_to_all_pract_yn= "";
	var open_to_all_prac_for_clinic_yn="";
	
	
	
		if (document.forms[0].clinic_code.value.length>0)
		{
			open_to_all_pract_yn=	openToAllPractionerYN[document.forms[0].clinic_code.selectedIndex];
			spec_code=specialtyForClinc[document.forms[0].clinic_code.selectedIndex]	;	

		}
		else
		{
			open_to_all_pract_yn=	"Y";
		}

		
		if (document.forms[0].treatment_area_code.value.length>0)
		{
			open_to_all_prac_for_clinic_yn=	openToAllPractForClnYN[document.forms[0].treatment_area_code.selectedIndex];
		}
		else
		{
			open_to_all_prac_for_clinic_yn=	"Y";
		}
 /* if(clinic_code!="") {
   if(treatment_area_code!="") {
		if(open_to_all_prac_for_clinic_yn=='N') { 
		  
		   
		  FirstSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,ae_pract_for_tmt_area_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and b.treatment_area_code = '"+treatment_area_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";

		 SecondSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,ae_pract_for_tmt_area_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and b.treatment_area_code = '"+treatment_area_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";		
		
		
		} else  if(open_to_all_pract_yn=='Y') {
		
		FirstSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";

		SecondSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";
		}
		else {
			
			
			FirstSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";
			
			SecondSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";
			
			}
   }else {  if(open_to_all_pract_yn=='Y') {
   
            FirstSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";

			SecondSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";
   
   }
			else{
			FirstSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";

			SecondSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";
		
			}
		  }
} else 
        {

        FirstSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";

		SecondSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2";
		 
		 }*/
		 
	/*var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	= "<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue)+ "\"";
	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + spec_code+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\""; 

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);*/
	getPractitioner(obj,target,facility_id,spec_code,practitioner_type,"Q1",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn)
}


/***********************************/

function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (objName=="practitioner_desc")
	{
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].practitioner_id.value	=	arr[0];
			document.forms[0].practitioner_desc.value		=	arr[1];			
		}
		else
		{
			document.forms[0].practitioner_id.value	=	"";
			document.forms[0].practitioner_desc.value		=	"";			
		}
	}
	
}


/***********************************/
async function populatePractitioners(getVal)
{	
	var	clinic_code			=	document.forms[0].clinic_code.value;
	var practitioner_id		=	document.forms[0].practitioner_id.value;
	var treatment_area_code	=	document.forms[0].treatment_area_code.value;
	var open_to_all_pract_yn= getVal;

	if (open_to_all_pract_yn.length==0)
	{
		if (document.forms[0].clinic_code.value.length>0)
		{
			open_to_all_pract_yn=	openToAllPractionerYN[document.forms[0].clinic_code.selectedIndex];
		}
		else
		{
			open_to_all_pract_yn=	"Y";
		}
	}

	if (open_to_all_pract_yn=='Y')
	{
		open_to_all_prac_for_clinic_yn = 'Y';
	}
	else
	{
		open_to_all_prac_for_clinic_yn	=	openToAllPractForClnYN[document.forms[0].treatment_area_code.selectedIndex];
	}

	
	var facility_id			=	document.forms[0].facility_id.value;

	var sql="";

		if(open_to_all_pract_yn=="Y")
			{
				if(open_to_all_prac_for_clinic_yn=="Y")
				{
					sql	=	" Select practitioner_id, practitioner_name from am_pract_for_facility_vw where operating_facility_id = `"+facility_id+"` and eff_status = `E` ";

				}
				else if(treatment_area_code.length==0)
				{
					sql	=	" select distinct practitioner_id, practitioner_name from ae_pract_for_tmt_area_vw where facility_id = `"+facility_id+"` and clinic_code = `"+clinic_code+"` and eff_status = `E` ";
				}
				else
				{
					sql	=	" select practitioner_id, practitioner_name from ae_pract_for_tmt_area_vw where facility_id = `"+facility_id+"` and clinic_code = `"+clinic_code+"` and treatment_area_code = `"+treatment_area_code+"` and eff_status = `E` ";
				}
			}

			else
			{
				if(open_to_all_prac_for_clinic_yn=="Y")
				{

					sql = "select  distinct op_pfc.practitioner_id practitioner_id, am_practitioner.practitioner_name from op_clinic oc ,sm_facility_param fcl_param, op_pract_for_clinic op_pfc, am_practitioner am_practitioner  where op_pfc.facility_id=fcl_param.facility_id and op_pfc.clinic_code=oc.clinic_code and op_pfc.facility_id=oc.facility_id and op_pfc.practitioner_id=am_practitioner.practitioner_id and op_pfc.facility_id = `"+facility_id+"` and op_pfc.clinic_code= `"+clinic_code+"` and op_pfc.em_visit_type_appl_yn =`Y` and op_pfc.eff_status = `E` ";
				}
				else if(treatment_area_code.length==0)
				{
					sql	=	" select distinct practitioner_id, practitioner_name from ae_pract_for_tmt_area_vw where facility_id = `"+facility_id+"` and clinic_code = `"+clinic_code+"` and eff_status = `E` ";
				}
				else
				{
					sql	=	" select practitioner_id, practitioner_name from ae_pract_for_tmt_area_vw where facility_id = `"+facility_id+"` and clinic_code = `"+clinic_code+"` and treatment_area_code = `"+treatment_area_code+"` and eff_status = `E`  ";

				}
			}
/* In am_pract_for_facility_vw  & op_pract_for_clinic_vw , the Practitioner Name selected is Practitioner Short Name. So the same is displayed here */

	var target				= document.forms[0].practitioner_desc;
	var retVal				=    new String();
	var dialogTop			= "40";
	var dialogHeight		= "55vh";
	var dialogWidth		    = "65vw";
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc="";
	var tit="";

	search_code="practitioner_id";
	search_desc="practitioner_name";
	tit=encodeURIComponent(getLabel("Common.practitioner.label","Common"));
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
		
	var arr=new Array();

	if(retVal == null) retVal='';
	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("::");
			document.forms[0].practitioner_desc.value=arr[0];
			document.forms[0].practitioner_id.value=arr[1];
			if (document.forms[0].assign_tmt_area_time)
			{
				document.forms[0].assign_tmt_area_time.disabled=false;
				document.forms[0].ok.disabled=false;
			}
		}
		else
		{
			document.forms[0].practitioner_desc.value="";
			document.forms[0].practitioner_id.value="";
			if (document.forms[0].assign_tmt_area_time)
			{
				document.forms[0].assign_tmt_area_time.disabled=true;
				document.forms[0].ok.disabled=true;
			}
		}
	}
	else
	{
		//target.focus();
	}

}

/****this function is called from 2 pages
1.Criteria page
2. Waiting List Result page ( on click of check box)
*****************************************/
function popTreatmentCode(objVal,from,trmt_code,gender)
   {

	var treatment_area_code="";
	var called_from_ca="";
	
	if(from=='waitlist'){								
	   treatment_area_code=parent.parent.AEMPSearchCriteriaFrame.document.forms[0].treatment_area_code;
	   called_from_ca=parent.parent.AEMPSearchCriteriaFrame.document.forms[0].called_from_ca.value;
	}
	else{
         treatment_area_code=parent.AEMPSearchCriteriaFrame.document.getElementById('treatment_area_code');
		 called_from_ca=parent.AEMPSearchCriteriaFrame.document.getElementById('called_from_ca').value;
	}
	 if(objVal.value!='')
	   {
		   	
			while(treatment_area_code.options.length > 1)
					treatment_area_code.remove(1);
    		
			var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/AEManagePatGIWaitingList.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='" +objVal.value + "'><input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+trmt_code+"'><input type='hidden' name='called_from_ca' id='called_from_ca' value='"+called_from_ca+"'><input type='hidden' name='asstrntbays' id='asstrntbays' value='bays'></form></BODY></HTML>";
			
			if(from=='waitlist'){

			parent.parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.parent.messageFrame.document.form1.submit();
			}else{
			if(called_from_ca=='Y'){	
			parent.parent.parent.dummy_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.parent.dummy_frame.document.form1.submit();
			}else{
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.document.form1.submit();
			}
			
			}
	   }
   else
	   {
			while(treatment_area_code.options.length > 1)
			treatment_area_code.remove(1);
	   }
    
   
   }

//AEMPSearchCriteria
function disableHome() {
var called_from_ca=document.forms[0].called_from_ca.value;
	if(called_from_ca=='Y') parent.parent.frames[0].document.getElementById("home").disabled= true;
}

function displayAlerts(){
				var htmlValue = "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='frmAlerts' id='frmAlerts' action='../../eMP/jsp/CAMainHomePageAlertEvents.jsp'></form></body></html>";
				parent.parent.frames[2].document.body.insertAdjacentHTML("afterBegin",htmlValue);
				parent.parent.frames[2].document.frmAlerts.submit();
}

function callShowQueryResult(refresh){

parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value='queueDate';
parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.asc_desc.value=' asc';
showQueryResult(refresh);
}

	function enableVal(obj)
	{
		if (obj.checked==true)
			obj.value='Y';
		else
			obj.value='N';
	}

	function ChangeToUpper(obj)
	{
		obj.value = obj.value.toUpperCase();
	}

	function clear_chk_select1()
		{
document.forms[0].chk_Select1.value="";
        }
/*function to store value for Bed Status , on clicking patientName tab, the values will be taken from this hidden variable and not the select box (bed_status1), this is done coz the list box is disabled in waitlist case.
*/
function storeBedStatus(obj)
	{
document.forms[0].bed_status.value=obj.value;
}

//AEManagePatGITabs.jsp

//This variable is let to show that by default on load Arrived tab is enabled.
var currentTab = new String();
currentTab = "char_tab";

// This function is used for calling the function for changing the tab img displays and also the function for corresponding page displays for that particular tab.
function tab_click(objName)
{	
	document.forms[0].toggle_wait_patman.value=objName;
	
	if (objName == "char_tab")
	{		
		 moveToTab(1);
	}
	else if(objName == "others_tab")
	{		
		moveToTab(2);
	}
	
}

function moveToTab(TabIndex) {
	var bookmarkToMove;
	if ( TabIndex == 1 )
	{
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014 Start*/
		/*document.getElementById("critical").style.background='RED';		
		document.getElementById("semicritical").style.background='YELLOW';
		document.getElementById("noncritical").style.background='GREEN';
		document.getElementById("others").style.background='LIGHTGREY';
		document.getElementById("Unassigned").style.background='ORANGE';*/
		FnChangeColorForShowAll();
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014 End*/

 	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.bed_status1.disabled=false;
	
	var chk=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.chk_Select1.value;
	if(chk!=""){
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.bed_status.value='A';
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.bed_status1.value='A';
	}
	else{
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.bed_status.value='O';
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.bed_status1.value='O';
	}
 	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.tabIndicator.value="char_tab";

	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value="";

parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value='queueDate';
parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.asc_desc.value=' asc';
//parent.AEMPSearchResultFrame.frameSetId.rows='0%,0%,0%,*,6%,0%'; Monday, May 24, 2010 venkat s PE_EXE
//parent.AEMPSearchResultFrame.frameSetId.rows='0%,0%,*,0%,6%,0%';

showQueryResult();	
//parent.AEMPSearchResultFrame.frameSetId.rows='0%,0%,0%,*,6%,0%';
	
	}
	else if ( TabIndex == 2 )
	{
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014 Start*/
		/*document.getElementById("critical").style.background='RED';		
		document.getElementById("semicritical").style.background='YELLOW';
		document.getElementById("noncritical").style.background='GREEN';
		document.getElementById("others").style.background='LIGHTGREY';
		document.getElementById("Unassigned").style.background='ORANGE';*/
		FnChangeColorForShowAll();
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014 End*/

	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.bed_status1.value="";
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.bed_status.value="";
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.bed_status1.disabled=true;
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.tabIndicator.value="others_tab";	
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value="";
	//parent.AEMPSearchResultFrame.frameSetId.rows='0%,0%,*,0%,6%,0%';
	showQueryResult();	
	}

}
/*Commented For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014 Start*/
/*
function showCritical()
	{
		document.getElementById("semicritical").style.background='YELLOW';
		document.getElementById("noncritical").style.background='GREEN';
		document.getElementById("others").style.background='NAVY';
		document.getElementById("critical").style.background='LIGHTGREY';	
		document.getElementById("Unassigned").style.background='ORANGE';
		parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value="R";

		parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value;

		
		showQueryResult();
	
	
	}
	function showSemiCritical()
	{		
		document.getElementById("critical").style.background='RED';
		document.getElementById("noncritical").style.background='GREEN';
		document.getElementById("others").style.background='NAVY';
		document.getElementById("semicritical").style.background='LIGHTGREY';
		document.getElementById("Unassigned").style.background='ORANGE';
		parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value="Y";
        parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value;

		
		showQueryResult();
 	    parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value;

	}
	function showNonCritical()
	{		
		
		document.getElementById("critical").style.background='RED';
		document.getElementById("semicritical").style.background='YELLOW';
		document.getElementById("others").style.background='NAVY';
		document.getElementById("noncritical").style.background='LIGHTGREY';		
		document.getElementById("Unassigned").style.background='ORANGE';
		parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value="G";
        parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value;

		showQueryResult();
	}
	function showUnassigned()
	{		
		document.getElementById("critical").style.background='RED';		
		document.getElementById("semicritical").style.background='YELLOW';
		document.getElementById("noncritical").style.background='GREEN';
		document.getElementById("others").style.background='NAVY';
		document.getElementById("Unassigned").style.background='LIGHTGREY';
		parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value="U";
        parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value;

		showQueryResult();
	}
	*/
/*Commented For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014 End*/

	function showAll()
	{	
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014 Start*/
		/*document.getElementById("critical").style.background='RED';		
		document.getElementById("semicritical").style.background='YELLOW';
		document.getElementById("noncritical").style.background='GREEN';
		document.getElementById("others").style.background='LIGHTGREY';
		document.getElementById("Unassigned").style.background='ORANGE';*/
		FnChangeColorForShowAll();
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014 End*/
		parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value="";
        parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value;
		showQueryResult();
	}

	//AEManagePatientFrameLayer

	var bodwidth=0
			var bodheight=0
			function buildTable(val)
			{
				var rowval = val.split ("<br>");
				var nowrapval = "";
				var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>"

				for( var i=0; i<rowval.length; i++ )
				{
					if(rowval.length > 6)
					{
						var tempValue = i/2;

						if(tempValue == 0 || tempValue == 1 || tempValue == 2 || tempValue == 3 || tempValue == 4 || tempValue == 5 || tempValue == 6)
							tab_dat += "<tr>"

						var colval = rowval[i].split("^^")
						if (colval[0] != "Blocked Remarks")
								nowrapval = "nowrap";
						else	nowrapval = "";
						if (colval[0] != "")
						{
							tab_dat += "<td class = 'label' nowrap align= 'right'> "+ colval[0] +": </td>"
							tab_dat += "<td class = 'QUERYDATA' "+nowrapval+"> "+ colval[1] +" </td>"
						}
						if(tempValue == 0.5 || tempValue == 1.5 || tempValue == 2.5 || tempValue == 3.5 || tempValue == 4.5 || tempValue == 5.5 || tempValue == 6.5)
							tab_dat += "</tr> "
					}
					else
					{
						var colval = rowval[i].split("^^")
						if (colval[0] != "Blocked Remarks")
								nowrapval = "nowrap";
						else	nowrapval = "";
						if (colval[0] != "")
						{
						tab_dat += "<tr>"
						tab_dat += "<td class = 'label' nowrap align= 'right'> "+ colval[0] +": </td>"
						tab_dat += "<td class = 'QUERYDATA' "+nowrapval+" > "+ colval[1] +" </td>"
						tab_dat += "</tr> "
						}
					}
				}
				tab_dat += "</table> "
				if (document.getElementById("t") != null)
					document.getElementById("t").innerHTML = tab_dat
			}

			function displayToolTip(val,obj)
			{
				val = unescape(val)
				buildTable (val)
				bodwidth = parent.frames[1].document.body.offsetWidth
				bodheight = parent.frames[1].document.body.offsetHeight

				var x =event.x
				var y =event.y;
				
					var x1=x;
					var y1=y;

				x = x + (document.getElementById("tooltiplayer").offsetWidth)
				y = y + (document.getElementById("tooltiplayer").offsetHeight)

				if(x<bodwidth)
					x =event.x 
				else
					x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

				if(y<bodheight )
					y =event.y
				else if(event.y>bodheight)
					y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
				else
					y = y - (document.getElementById("tooltiplayer").offsetHeight);

					y+=document.body.scrollTop
					x+=document.body.scrollLeft 

					document.getElementById("tooltiplayer").style.posLeft= x

					if(document.getElementById("tooltiplayer").offsetWidth > 250)
						document.getElementById("tooltiplayer").style.posLeft = 111	
					else
						document.getElementById("tooltiplayer").style.posLeft = 275 
					document.getElementById("tooltiplayer").style.posTop = y 
					document.getElementById("tooltiplayer").style.visibility='visible' 
			}

			function hideToolTip()
			{
					document.getElementById("tooltiplayer").style.visibility='hidden'
			}
			
			var val2;

async function closeWin(val,val2,clinic_code,clinic_desc,clinic_type,patient_id,priority_zone, queue_status, encounter_id, triage_area, trauma_yn, treatment_area_code,practitioner_id, practitioner_name,treatment_area_desc, open_to_all_prac_for_clinic_yn, check_in_date_time, sys_date_time, queue_date, patient_gender,brought_dead,assign_tmt_area_time,open_to_all_pract_yn,patient_class,current_status,date_of_birth,fs_locn_code,patient_name,info,pseudo_bed_yn)
{	
				if(false)	
				{
					var retVal			=	"";
					var selection_mode	=	"";
					var query_string	=	"";
					var dialogHeight	=	"70vh" ;

					var dialogWidth		=	"70vw";
					var dialogTop		=	"0vh";
					var status				=	"no";
					var arguments		=	"" ;


					var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?detail_fn=Y&fn=un_reserve_bed";
				
					var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status + ";";
					retVal				=	await window.showModalDialog(action_url,arguments,features);

					if(retVal!=null)
					{
						HTMLVal = "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../servlet/eAE.assignBedGIServlet'><input name='mode' id='mode' type='hidden' value='UnreserveBed'><input name='clinic_code' id='clinic_code' type='hidden' value='"+clinic_code+"'><input name='treatment_area_code' id='treatment_area_code' type='hidden' value='"+treatment_area_code+"'><input name='bed_no' id='bed_no' type='hidden' value='"+val+"'><input name='priority_zone' id='priority_zone' type='hidden' value='"+priority_zone+"'></form></BODY></HTML>";
							
						parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
						parent.parent.frames[2].document.form1.submit();

					}
				}else if(current_status=='A')
				{
						var query_string1	= "";
                      	var str='';
						str=parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.chk_Select1.value;
						if(str != ''){
							str=str.split("*");
							var pat_id=str[0];
							var enc_id=str[1];
							var service_id=str[2];
							var pract_id=str[3];
							var msg=getMessage("ASSIGN_BED_YN","AE");
							msg=msg.replace('$',val);
							
							if(window.confirm(msg+' '+pat_id+'?')){

						parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.chk_Select1.value="";

								
								if(pract_id=='')
									pract_id="*All";
								

							HTMLVal = "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../servlet/eAE.assignBedGIServlet'><input name='mode' id='mode' type='hidden' value='BookBed'><input name='clinic_code' id='clinic_code' type='hidden' value='"+clinic_code+"'><input name='practitioner_id' id='practitioner_id' type='hidden' value='"+pract_id+"'><input name='encounter_id' id='encounter_id' type='hidden' value='"+enc_id+"'><input name='treatment_area_code' id='treatment_area_code' type='hidden' value='"+treatment_area_code+"'><input name='bed_no' id='bed_no' type='hidden' value='"+val+"'><input name='patient_id' id='patient_id' type='hidden' value='"+pat_id+"'><input name='service_code' id='service_code' type='hidden' value='"+service_id+"'><input name='pseudo_bed_yn' id='pseudo_bed_yn' type='hidden' value='"+pseudo_bed_yn+"'><input name='priority_zone' id='priority_zone' type='hidden' value='"+priority_zone+"'></form></BODY></HTML>";
    						parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
							parent.parent.frames[2].document.form1.submit();

								

							}
						}
					}

			var CAInst=document.forms[0].CAInstalled.value;
			if(CAInst=="N" || CAInst=="")
			{
				if(current_status=='O')
				{
					var patient_gender1 =   "";
					var retVal			=	"";
					var selection_mode	=	"";
					var query_string	=	"";
					if (brought_dead=='Y')
					{
						var dialogHeight	=	"6";
					}
					else{

					if(triage_area=="A")	dialogHeight	=	"10" ;
		            else if(triage_area=="B")	dialogHeight	=	"10" ;
		            else if(triage_area=="C" && trauma_yn=="Y" )	dialogHeight	=	"13" ;
		            else dialogHeight	=	"25vh" ;
					}

					var dialogWidth		=	"25vw" ;
					var dialogTop		=	"250";
					var status			=	"no";
					var arguments		=	"" ;
					
					var highrisk="";
					var allergy="";
				
					var conditions=info.split("/");
					
					var highrisk=conditions[0];
					var allergy=conditions[1];
					var result=conditions[2];

					if(highrisk){
						highrisk='Y';
					}else{
						highrisk='N';
					}
					if(allergy){
						allergy='Y';
					}else{
						allergy='N';
					}					
					
                    if(patient_gender=="Male") {patient_gender1="M";}
					if(patient_gender=="Female") {patient_gender1="F";}
					if(patient_gender=="Unknown") {patient_gender1="U";}

					query_string		= "patient_id="+patient_id+"&encounter_id="+encounter_id+"&queue_status="+queue_status+"&priority_zone="+priority_zone+"&triage_area="+triage_area+"&trauma_yn="+trauma_yn+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&clinic_code="+clinic_code+"&clinic_type="+clinic_type+"&queue_date="+queue_date+"&encounter_id="+encounter_id+"&assign_tmt_area_time="+assign_tmt_area_time+"&brought_dead="+brought_dead+"&orig_tmt_area_code="+treatment_area_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&clinic_desc="+encodeURIComponent(clinic_desc)+"&treatment_area_desc="+encodeURIComponent(treatment_area_desc)+"&open_to_all_prac_for_clinic_yn="+open_to_all_prac_for_clinic_yn+"&check_in_date_time="+check_in_date_time+"&sys_date_time="+sys_date_time+"&patient_gender="+patient_gender1+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&bed_no="+val+"&practitioner_name="+encodeURIComponent(practitioner_name)+"&patient_name="+patient_name;
		
					var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?detail_fn=Y&selection_mode="+retVal+"&"+query_string+"&info="+info+"&allergy="+allergy+"&highrisk="+highrisk;
					
					//queue_status='04';

					//if(queue_status=="01") dialogHeight	=	"10" ;
					var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status + ";";
					
					retVal				=	await window.showModalDialog(action_url,arguments,features);
                    if (retVal != null)
					{
					var retarr		= retVal.split("|");
					var retValOne	= retarr[0];
					var retValTwo	= retarr[1];
					retVal = retValOne;
                    }
					if (retVal != null)
					{
						if( retVal=="AssignTreatmentArea" || retVal=="AssignReassignPractitioner" || retVal=="ReassignTreatmentArea")
						{
							selection_mode		=	"AssignTreatmentArea";
							var dialogHeight	=	"70vh" ;

							var dialogWidth		=	"70vw";
							var dialogTop		=	"0vh";
							var status			=	"no";
							var arguments		=	"" ;
							var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal+"&"+query_string+"&bed_no="+val+"&practitioner_name="+escape(practitioner_name)+"&tmt_area_code="+treatment_area_code;
							var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
							retVal	=	await window.showModalDialog(action_url,arguments,features);
							if(retVal!=null)
							{
								if(retVal=="Success")
								{
									parent.parent.frames[0].document.forms[0].refresh.click();
								}
							}
						}
						else if(retVal=="StartConsultation")
						{
							var dialogHeight	=	"70vh" ;

							var dialogWidth		=	"70vw";
							var dialogTop		=	"0vh";
							var status			=	"no";
							var arguments		=	"" ;
							var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal+"&"+query_string;
							var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
						
							retVal	=	await window.showModalDialog(action_url,arguments,features);
							if(retVal!=null)
								if(retVal=="Success")
									parent.parent.frames[0].document.forms[0].refresh.click();
						}
						/*else if(retVal=="PrimaryAssessment")
					    {
						    var retVal = "";
						    var dialogHeight= "37" ;
						    var dialogWidth	= "64" ;
						    var dialogTop ="85";
							var status = "no";
							var arguments	= "" ;
							var action_url		=	"../../eAE/jsp/PrimaryAssessmentFrameset.jsp?"+query_string;
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
							retVal = window.showModalDialog(action_url,arguments,features);
							
						}
						else if(retVal=="TraumaAssessment")
						{

							var retVal = "";
							var dialogHeight= "39.5" ;
							var dialogWidth	= "64" ;
							var dialogTop ="85";
							var status = "no";
							var arguments	= "" ;
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
							var action_url		=	"../../eAE/jsp/SecondaryAssessmentFrameset.jsp?"+query_string;
							retVal = window.showModalDialog(action_url,arguments,features);
						}
						else if(retVal=="TraumaScore")
						{							
							var retVal = "";
							var dialogHeight= "35.5" ;
							var dialogWidth	= "63.5" ;
							var dialogTop ="85";
							var status = "no";
							var arguments	= "" ;
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
							var action_url		=	"../../eAE/jsp/TraumaScoreFrameset.jsp?modify_flag=N&"+query_string;
							retVal = window.showModalDialog(action_url,arguments,features);
						}*///ViewPatHistoryDetails
						else if(retVal=="Triage")
						{
							var retVal = "";
							var dialogHeight= "55vh";
			                var dialogWidth = "65vw";
							var dialogTop ="85";
							var status = "no"; 
							var arguments	= " ";
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
							retVal = await window.showModalDialog("../../eAE/jsp/AETriageFrameset.jsp?selection_mode="+retVal+"&"+query_string,arguments,features);
						}else if(retVal=="ViewAEDetails"){
							var url	= "../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID="+patient_id+"&EncounterId="+encounter_id;
							var dialogTop		= "70";
							var dialogHeight	= "55vh";
			                var dialogWidth		= "65vw";
							var arguments	= "" ;
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
							var returnval = await window.showModalDialog( url, arguments, features ) ;

						}else if(retVal=="CheckOut")
						{
                         await LoadChkOut(encounter_id,brought_dead,treatment_area_code,open_to_all_prac_for_clinic_yn,clinic_code,open_to_all_pract_yn,patient_id,clinic_type);
									
						}
						else if(retVal=="ViewPatient")
						{
							
							var url			= "../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID="+patient_id+"&EncounterId="+encounter_id;
							var dialogTop		= "70";
							var dialogHeight	= "55vh";
			                var dialogWidth		= "65vw";
							var arguments	= "" ;
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
							var returnval = await window.showModalDialog( url, arguments, features ) ;
						}
						else if(retVal=="MovementHistory")
						{// Added/Modified by Nanda - 11/14/2002
							
								
							var retVal = "";
							var dialogHeight	= "55vh";
			                var dialogWidth		= "65vw";
							var dialogTop ="230";
							var status = "no";
							var arguments	= "" ;
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
							var action_url		=	"../../eAE/jsp/AEMovementHistoryMain.jsp?modify_flag=N&"+query_string;
							retVal = await window.showModalDialog(action_url,arguments,features);
						}
					}
						 
				}// E,o current_status = 'O'
		window.location.reload();
		}
		else
		{
			if(current_status=='O')
			{
				var HTMLVal  = "<html>";
				HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp'>";
				HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + encounter_id + "'>";
				HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='AE'>";
				HTMLVal  += "</form>";
				HTMLVal  += "</html>";
                top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);			
				top.content.messageFrame.document.OpenChartWrapperForm.submit();			
				
			 }
		}	
}

async function pat_click(patient_id,encntr_id){
	var retVal			=	"";
	var selection_mode	=	"";
	var query_string	=	"";
	var dialogHeight	=	"36";
	var dialogWidth		=	"50" ;
	var dialogTop		=	"10";
	var status			=	"no";
	var arguments		=	"" ;

var url			= "../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID="+patient_id+"&EncounterId="+encntr_id;
		var dialogTop		= "10px";
		var dialogHeight	= "90vh";
		var dialogWidth		= "90vw";
		
		//Added for ML-MMOH-CRF-0860.2
		if(document.forms[0].increasedaddressLength && document.forms[0].increasedaddressLength.value=="true"){
		    dialogHeight="75vh";
        }
        //End ML-MMOH-CRF-0860.2 
              
		
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
			var returnval = await top.window.showModalDialog( url, arguments, features ) ;
}
function resetValues()
			{
				//parent.processBar.document.location.href = "../../eCommon/html/blank.html";

			/*
				parent.criteria0.document.forms[0].nursing_unit.disabled = false;
				parent.criteria0.document.forms[0].Splcode.disabled = false;
				parent.criteria0.document.forms[0].pract_id_search.disabled = false;
				parent.criteria0.document.forms[0].Bedcode.disabled = false;
				parent.criteria0.document.forms[0].bed_type_code.disabled = false;
				parent.criteria0.document.forms[0].bed_classification.disabled = false;
				parent.criteria0.document.forms[0].gender.disabled = false;
				parent.criteria0.document.forms[0].age_value.disabled = false;
				parent.criteria0.document.forms[0].age.disabled = false;
				parent.criteria0.document.forms[0].release_hrs.disabled = false;
				parent.criteria0.document.forms[0].search_by_beds.disabled = false;
				parent.criteria0.document.forms[0].search_butt.disabled = false;
				parent.criteria0.document.forms[0].clear_butt.disabled = false;
				parent.criteria0.document.forms[0].cancel_butt.disabled = false;

				parent.criteria0.document.forms[0].available_nursing_unit.disabled = false;
				parent.criteria0.document.forms[0].BedListinOrder1.disabled = false;
				if(parent.criteria0.document.forms[0].BedListinOrder2.value != "")
				parent.criteria0.document.forms[0].BedListinOrder2.disabled = false;
				if(parent.criteria0.document.forms[0].BedListinOrder3.value != "")
				parent.criteria0.document.forms[0].BedListinOrder3.disabled = false;
				parent.criteria0.document.forms[0].privacy_level.disabled = false;
				parent.criteria0.document.forms[0].smoking.disabled = false;
				parent.criteria0.document.forms[0].infectious_disease.disabled = false;
				parent.criteria0.document.forms[0].sel_nurs_unit_butt.disabled = false;
				parent.criteria0.document.forms[0].show_beds_butt.disabled = false;
			
			*/
			}

//AEManagePatWaitingListResult

async function CallViewPatDetails1(patient_id,encounter_id)
	{
			var url			= "../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID="+patient_id+"&EncounterId="+encounter_id;
			var dialogTop		= "85";
			var dialogHeight	= "55vh";
			var dialogWidth		= "65vw";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
			var returnval = await window.showModalDialog( url, arguments, features ) ;
			//parent.window.close();
			parent.parent.document.getElementById("dialog_tag").close(); 
	}


function sort(sortVal)
{

	var prev=parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value;

	if(prev==sortVal)
	{
			var toggle=parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.asc_desc;
			if(toggle.value==' asc')
				{	
				toggle.value=' desc';
				}
				else
				{
				toggle.value=' asc';
				}
	}
	else{
	parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.asc_desc.value=' asc';
	
	}
	parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value=sortVal;
	parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value=sortVal;

	
	showQueryResult('waitlist');	
	

	parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value='';

}

/********************************************************/

function hideAllGifs(sortVal){

document.forms[0].selectGif.style.visibility='hidden';
document.forms[0].dateGif.style.visibility='hidden';
document.forms[0].patNameGif.style.visibility='hidden';
document.forms[0].patIdGif.style.visibility='hidden';
document.forms[0].waitTimeGif.style.visibility='hidden';
//document.forms[0].complaintGif.style.visibility='hidden';
document.forms[0].locTypeGif.style.visibility='hidden';


}
/**************************************************/
function toggleGifs(sortVal, order){


if(sortVal=="practitioner")
		{
			document.forms[0].practitionerGif.style.visibility='visible';
			if(order==' asc')
					document.forms[0].practitionerGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].practitionerGif.src = '../../eAE/images/Descending.gif';
		}

else if(sortVal=="queueDate")
		{
			document.forms[0].dateGif.style.visibility='visible';
			if(order==' asc')
					document.forms[0].dateGif.src = '../images/Ascending.gif';
			else
					document.forms[0].dateGif.src = '../images/Descending.gif';
		}

else if(sortVal=="patientName")
		{
			
			document.forms[0].patNameGif.style.visibility='visible';
			if(order==' asc')
					document.forms[0].patNameGif.src = '../images/Ascending.gif';
			else
					document.forms[0].patNameGif.src = '../images/Descending.gif';
		
		}

else if(sortVal=="patientId")
		{
				document.forms[0].patIdGif.style.visibility='visible';
			if(order==' asc')
					document.forms[0].patIdGif.src = '../images/Ascending.gif';
			else
					document.forms[0].patIdGif.src = '../images/Descending.gif';
		}
/*else if(sortVal=="complaint")
		{
				document.forms[0].all.complaintGif.style.visibility='visible';
			if(order==' asc')
					document.forms[0].complaintGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].complaintGif.src = '../../eAE/images/Descending.gif';
		}*/

else if(sortVal=="priorityZone")
		{
				document.forms[0].patNameGif.style.visibility='visible';
			if(order==' asc')
					document.forms[0].patNameGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].patNameGif.src = '../../eAE/images/Descending.gif';
		}

else if(sortVal=="waitingTime")
		{
			document.forms[0].waitTimeGif.style.visibility='visible';
			if(order==' asc')
					document.forms[0].waitTimeGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].waitTimeGif.src = '../../eAE/images/Descending.gif';
		}

}

/**************************************************/
function onMMove(obj,e,brought_dead,brought_dead_yn)
	{
		if(brought_dead_yn=="Y"){
		var brought_dead;
		obj.style.left=e.x+20;
		obj.style.top=e.y;
		obj.style.borderColor='pink'; 
		obj.style.borderWidth='thin';
		obj.style.borderStyle='groove';
		obj.style.width=150;

		obj.innerHTML="<table cellspacing='0' cellpadding='0' border='0' height=100% width='100%'><tr><td class='ordata' valign='top'>"+brought_dead+"</td></tr></table>";
		}
		else
			return false;
	}

function onMOut(obj,brought_dead_yn)
	{
		if(brought_dead_yn=="Y"){
		obj.innerHTML='';
		obj.style.width=0;
		obj.style.borderColor='';
		obj.style.borderWidth='';
		obj.style.borderStyle='';
		}
		else
			return false;
	}
	function DummyRef(){
	}

async function CallReviewList(){

	var dialogHeight	= "55vh";
	var dialogWidth		= "65vw";
	var dialogTop		=	"120";
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	"../../eOR/jsp/ReviewResults.jsp?patient_class=EM";

	var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";

	retVal	=	await window.showModalDialog(action_url,arguments,features);
}

async function CallCollectionList(){
		
	var dialogHeight	= "55vh";
    var dialogWidth		= "65vw";
	var dialogTop		=	"120";
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	"../../eOR/jsp/PatientPendingOrders.jsp?patient_class=EM";

	var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";

	retVal	=	await window.showModalDialog(action_url,arguments,features);}

function check_checked(obj, val, clini_code,trmt_code,gender){
	
var prev_name=parent.parent.AEMPSearchCriteriaFrame.document.getElementById("chk_Select1").value;

		if(obj.checked){
					if(parent.parent.AEMPSearchCriteriaFrame.document.getElementById('chk_Select1').value !=''){
						    alert(getMessage("SELECT_ONE_PATIENT_ID","AE"));
							obj.checked=false;
								
					}
					else{
						
								parent.parent.AEMPSearchCriteriaFrame.document.getElementById('chk_Select1').value=val;
								parent.parent.AEMPSearchCriteriaFrame.document.getElementById('clinic_code').value=clini_code;

								parent.parent.AEMPSearchCriteriaFrame.document.getElementById('gender').value=gender;
								popTreatmentCode(parent.parent.AEMPSearchCriteriaFrame.document.getElementById('clinic_code'),'waitlist',trmt_code,gender);
					}
			}
			else{
					parent.parent.AEMPSearchCriteriaFrame.document.getElementById('chk_Select1').value='';
					parent.parent.AEMPSearchCriteriaFrame.document.getElementById('clinic_code').value='';
					parent.parent.AEMPSearchCriteriaFrame.document.getElementById('patient_gender').value='';
					parent.parent.AEMPSearchCriteriaFrame.document.getElementById('treatment_area_code').value='';
			}

}

/*******************************************/
function alignHeading1()
{

	if(document.getElementById("th_table") != null) {
				
		for (j=0; j < document.getElementById("tb1").rows[1].cells.length; j++) {
			
			var wid=eval(document.getElementById("tb1").rows[1].cells[j].offsetWidth);
			
			if(document.getElementById("th_table").rows[0].cells[j] != null){
								
					var  wid1 = eval(document.getElementById("th_table").rows[0].cells[j].offsetWidth);
					if(wid1<wid)
					{
				
						document.getElementById("th_table").rows[0].cells[j].width=wid;
					}
					else
					{
						document.getElementById("tb1").rows[1].cells[j].width=eval(document.getElementById("th_table").rows[0].cells[j].offsetWidth);
					}
				
				}
			
		}
		document.getElementById("th_table").width =	eval(document.getElementById("tb1").offsetWidth);
		document.getElementById("TitleTab").width =	eval(document.getElementById("tb1").offsetWidth);
	}
}


//alignHeading1();


function scrollTitle(){

  var x = document.body.scrollTop;
  if(x == 0){
   document.getElementById("divTitleTable").style.position = 'static';
   document.getElementById("divTitleTable").style.posTop  = 0;
  }else{
	document.getElementById("divTitleTable").style.position = 'relative';
	document.getElementById("divTitleTable").style.posTop  = x-2;
  
  }

}

//FnCheckOPQBLValidation Added by Dharma for MMS-QH-CRF-0126.2 [IN:042931] 
 function FnCheckOPQBLValidation(visit_num,facility_id,action_on_pending_bill,patient_id,episode_id,CAInstalled,HTMLVal,action_url,arguments,features){
	var IsProceed	= 0;  
	$.ajax({  
          url:'../../eOP/jsp/OPQBLValidation.jsp',  
          type:'post',  
          data:{'facility_id':facility_id,'p_patient_id':patient_id,'p_episode_type':'E','p_episode_id':episode_id,'p_visit_id':visit_num},
          dataType: 'json',
          success: function(data) {
          	if(data.IsResult==1){
          		var p_unbilled_amt	= parseInt(data.p_unbilled_amt);
          		var p_unsettled_amt	= parseInt(data.p_unsettled_amt);
          		if(p_unbilled_amt==0 && p_unsettled_amt==0){
          			IsProceed	= 1;
          	 	}else{
          	 		if(action_on_pending_bill=='W'){
          	 			if(confirm(getMessage("UNSETTLED_UNBILLED_AMT_WARNING","OP"))){
          	 				IsProceed	= 1;
          	 			}
          	 		}else{
          	 			alert(getMessage("UNSETTLED_UNBILLED_AMT_STOP","OP"));
          	 			return false;
          	 		}
          	 	}
          		if(IsProceed==1){
          			if(CAInstalled=='Y'){
          				FnProceedCAInstalled(HTMLVal);
          			}else{
          				FnProceedCAInstalledNo(action_url,arguments,features);
          			}
          		}
          	}
          } ,
          error: function(jqXHR, textStatus, errorThrown) {
              alert("Error : " + jqXHR.responseText);
          }
      });  

}

/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014 Start*/
function FnShowPriorityWise(priority_code,treat_area_code,appear_as_tab_yn,treatmentAreaTab){
	var priority_zone_all_codes 	= $("#priority_zone_all_codes",parent.AEManagePatTabsForm).val();
	var selected_tab_color			= "LIGHTGREY";
	priority_zone_all_codes			= priority_zone_all_codes.slice(0,-1);
	var arr_priority_zone_all_codes	= priority_zone_all_codes.split(","); 
	//Added by Sangeetha for ML-MMOH-CRF-0642 on 28/apr/17
	var boldPriorityZoneTab			= document.forms[0].boldPriorityZoneTab.value;
	
	//Modified by Sangeetha for ML-MMOH-CRF-0642 on 28/apr/17
	$.each(arr_priority_zone_all_codes,function(index,value){
		if(value==priority_code){
			if(boldPriorityZoneTab == "true")
				$("#priority_zone_tab_"+priority_code,parent.AEManagePatTabsForm).css('fontWeight', 'bold');
			else
			$("#priority_zone_tab_"+priority_code,parent.AEManagePatTabsForm).css('background-color', selected_tab_color);
		}else{
			if(boldPriorityZoneTab == "true")
				$("#priority_zone_tab_"+value,parent.AEManagePatTabsForm).css('fontWeight', 'normal');
			else
			$("#priority_zone_tab_"+value,parent.AEManagePatTabsForm).css('background-color', $("#priority_zone_color_"+value,parent.AEManagePatTabsForm).val());
		}
	});
	//Added by Sangeetha for ML-MMOH-CRF-0642 on 28/apr/17
	if(boldPriorityZoneTab == "true")
		$("#others",parent.AEManagePatTabsForm).css('fontWeight', 'normal');
	else
	$("#others",parent.AEManagePatTabsForm).css('background-color',"NAVY");
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value=priority_code;
    parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value;
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 05-07-2023
	var isAppearAsTabEnable=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.isAppearAsTabEnable.value;
	if(isAppearAsTabEnable=='true' || isAppearAsTabEnable==true) {
		
  	var treatment_area_all_codes 	= $("#treatment_area_all_codes").val();
  	treatment_area_all_codes			= treatment_area_all_codes.slice(0,-1);
  	var arr_treatment_area_all_codes	= treatment_area_all_codes.split(",");
  	$.each(arr_treatment_area_all_codes,function(index,value){
  			if(value==treat_area_code){
  					$("#treatment_area_tab_"+value).css('background-color', selected_tab_color);	
  			}
  			else {
  				 $("#treatment_area_tab_"+value).css('background-color', $("#treatment_tab_color_"+value).val());
  			}
  	});
	
		
		//parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.treatment_area_code1.value = (treat_area_code != null && treat_area_code !="")?treat_area_code:"";
		//parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.appear_as_tab_yn.value = appear_as_tab_yn; 
	//	alert('parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.appear_as_tab_yn.value : '+parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.appear_as_tab_yn.value);	
		if(treat_area_code!=null && (treatmentAreaTab!=null && treatmentAreaTab!="")){
			//parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.treatment_area_code.value=treat_area_code;
			showQueryResult('',treat_area_code);				
		} else {
			showQueryResult();	
		}
	} else {
	showQueryResult();
	}
}

function FnChangeColorForShowAll(){
	var priority_zone_all_codes 	= $("#priority_zone_all_codes",parent.AEManagePatTabsForm).val();

	priority_zone_all_codes			= priority_zone_all_codes.slice(0,-1);
	var arr_priority_zone_all_codes	= priority_zone_all_codes.split(","); 
	//Added by Sangeetha for ML-MMOH-CRF-0642 on 28/apr/17
	var boldPriorityZoneTab			= document.forms[0].boldPriorityZoneTab.value;

	//Modified by Sangeetha for ML-MMOH-CRF-0642 on 28/apr/17
	$.each(arr_priority_zone_all_codes,function(index,value){
		if(boldPriorityZoneTab == "true")
			$("#priority_zone_tab_"+value,parent.AEManagePatTabsForm).css('fontWeight', 'normal');
		else
		$("#priority_zone_tab_"+value,parent.AEManagePatTabsForm).css('background-color', $("#priority_zone_color_"+value,parent.AEManagePatTabsForm).val());
	});
	//Added by Sangeetha for ML-MMOH-CRF-0642 on 28/apr/17
	if(boldPriorityZoneTab == "true")
		$("#others",parent.AEManagePatTabsForm).css('fontWeight', 'bold');
	else
		$("#others",parent.AEManagePatTabsForm).css('background-color',"LIGHTGREY");

	if(document.forms[0].isAppearAsTabEnable.value==true || document.forms[0].isAppearAsTabEnable.value=="true"){
	var treatment_area_all_codes 	= $("#treatment_area_all_codes").val();
	treatment_area_all_codes			= treatment_area_all_codes.slice(0,-1);
	var arr_treatment_area_all_codes	= treatment_area_all_codes.split(",");
	$.each(arr_treatment_area_all_codes,function(index,value){
				 $("#treatment_area_tab_"+value).css('background-color', $("#treatment_tab_color_"+value).val());
	});
	}
}

/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014 End*/


