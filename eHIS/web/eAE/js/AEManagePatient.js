// Added/Modified by Nanda - 11/8/2002
var treatmentGender			=	new Array();
var clinicType				=	new Array();
var openToAllPractionerYN	=	new Array(); 
var openToAllPractForClnYN	=	new Array();
var specialtyForClinc	=	new Array();
var query_string	=	"";

treatmentGender[0]	 		=	'';
clinicType[0]				=	'';
openToAllPractionerYN[0]	=	'';
openToAllPractForClnYN[0]	=	''; 
/* Below variables added by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
var prevObjID;
var prevImgObj;
var prevlink;
/* End Bru-HIMS-CRF-362[39365]  */
function enableOK(){    
    
	if (document.forms[0].treatment_area_code.value.length>0 && document.forms[0].priority_value.value !="")
		{
		  if ((document.forms[0].bed_count.value=='Y') && (document.forms[0].bed_bay_no.value !="") )
		   {
              document.forms[0].ok.disabled=false; 
		   }
		   else if (document.forms[0].bed_count.value=='N')
		   {
		      document.forms[0].ok.disabled=false;
		   }
		   else{
			   document.forms[0].ok.disabled=true;
		   } 
		}else if (document.forms[0].bed_count.value=='N'){ 
		document.forms[0].ok.disabled=false;
		}
		if(document.forms[0].bed_count.value=='Y'){
			document.forms[0].ok.disabled=false;}

		if(document.forms[0].treatment_area_code.value.length==0)
			document.forms[0].ok.disabled=true;
}
 
function populateDynamicValues(forField)
{
	if (document.forms[0].treatment_area_code && document.forms[0].assign_tmt_area_time)
	{
		if (document.forms[0].treatment_area_code.value.length>0 && document.forms[0].priority_value.value !="" && (document.forms[0].bed_count.value=='Y'))
		{
			document.forms[0].ok.disabled=false;
		}
		else
		{
			//document.forms[0].assign_tmt_area_time.disabled=true;
			//document.forms[0].ok.disabled=true;
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
		opt.text	=	'          ----- Select -----       ';
		opt.value	=	'';
		treatment_area_code.add(opt); 
        var priority =document.forms[0].priority_value.value;
		var HTMLVal="<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='AEMPDynamicForm' id='AEMPDynamicForm' method='post' action='../../eAE/jsp/AEMPDynamicValues.jsp'>"+
		"<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='"+open_to_all_pract_yn+"'>"+
		"<input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code.value+"'>"+
		"<input type='hidden' name='frame_name' id='frame_name' value='"+frame_name+"'>"+
		"<input type='hidden' name='pop_mode' id='pop_mode' value='"+forField+"'>"+
        "<input type='hidden' name='priority' id='priority' value='"+priority+"'>"+
		"</form></body></html>";
		parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.parent.frames[2].document.AEMPDynamicForm.submit();
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
			forField	=	"Practitioner";
			open_to_all_pract_yn			=	document.forms[0].open_to_all_pract_yn.value;
			open_to_all_prac_for_clinic_yn	=	openToAllPractForClnYN[treatment_area_code.selectedIndex];
		}	
        var  gender = document.forms[0].gender.value;
		var  ca_called_from =document.forms[0].strCA.value;
		if (ca_called_from=='Y')
		{
			if (top.workAreaFrame!=null)
			{
				frame_name= "top.workAreaFrame";
			}
			else if(parent.AEMPAssignTreatmentAreaFrame!=null)
			{
				frame_name ="parent.AEMPAssignTreatmentAreaFrame";
			}
			else{
				frame_name ="top.content.workAreaFrame";
			}
		}
		var HTMLVal="<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='AEMPDynamicForm' id='AEMPDynamicForm' method='post' action='../../eAE/jsp/AEMPDynamicValues.jsp'>"+
		"<input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code.value+"'>"+
		"<input type='hidden' name='frame_name' id='frame_name' value='"+frame_name+"'>"+
		"<input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+treatment_area_code.value+"'>"+
        "<input type='hidden' name='gender' id='gender' value='"+gender+"'>"+
		"<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='"+open_to_all_pract_yn+"'>"+
		"<input type='hidden' name='open_to_all_prac_for_clinic_yn' id='open_to_all_prac_for_clinic_yn' value='"+open_to_all_prac_for_clinic_yn+"'>"+
		"<input type='hidden' name='pop_mode' id='pop_mode' value='"+forField+"'>"+
        "<input type='hidden' name='ca' id='ca' value='"+ca_called_from+"'>"+
		"</form></body></html>";

		if (forField=="AssignTreatmentArea") 
		{
			 if (ca_called_from=='Y'){
			   if( parent.messageFrame!=null)
			    {
				  parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				  parent.messageFrame.document.AEMPDynamicForm.submit();
		        }
			   else{
				    parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				  parent.messageFrame.document.AEMPDynamicForm.submit();
			   }
			 }
			 else{
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				  parent.messageFrame.document.AEMPDynamicForm.submit();
			 }
			
		}
		else
		{
          if (ca_called_from=='Y'){
			   if( parent.messageFrame!=null)
			    {
				  parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				  parent.messageFrame.document.AEMPDynamicForm.submit();
		        }
			   else if(parent.messageFrame==null){
				 parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				  parent.messageFrame.document.AEMPDynamicForm.submit();
			     }
				else{
				    parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				  parent.messageFrame.document.AEMPDynamicForm.submit();
				 }
			   }
		 else{
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				  parent.messageFrame.document.AEMPDynamicForm.submit();
			 }	
		 }
		}
	}

function checkTreatmentGender()
{
	var treatment_area_code =	document.forms[0].treatment_area_code;
	var gender				=	document.forms[0].gender;

	var treatment_gender	=	treatmentGender[treatment_area_code.selectedIndex];

	document.forms[0].practitioner_desc.value='';
	document.forms[0].practitioner_id.value='';
}
/***************************************************/
function showQueryResult(from)

{
	var isAppearAsTabEnable =document.forms[0].isAppearAsTabEnable.value;//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
	var isForAdmission =document.forms[0].isForAdmission.value;//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
	var enableSubTabForIPAdm="N";
	enableSubTabForIPAdm=document.getElementById('enableSubTabForIPAdm').value; //Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
	var treatmentTabValue="N";
	treatmentTabValue=document.getElementById('treatmentTabValue').value;
	var validateResultPage=false; //Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
	var validateResultPage1=false; //Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
	var toggleValue = "N";
	if(from=='waitlist'){
		
       document.forms[0].from.value="";
		document.forms[0].to.value="";
	   document.forms[0].ch_id.value="";

		var clinic_code		=	parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_code;
		var clinic_type		=	parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_type;
		var gender			=	document.forms[0].gender;
		var patient_gender	=	document.forms[0].patient_gender;

		parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_type.value			=	parent.AEMPSearchCriteriaFrame.clinicType[clinic_code.selectedIndex];

		var fields = new Array (parent.AEMPSearchCriteriaFrame.document.forms[0].patient_id);
		var names = new Array (getLabel("Common.patientId.label","Common"));	
		var error_jsp="../../eCommon/jsp/error.jsp";
		var messageFrame="";
		document.forms[0].target	=	"AEMPSearchResultFrame";
		var oper_stn_id=parent.AEMPSearchCriteriaFrame.document.forms[0].oper_stn_id.value;
		var checkout_yn=parent.AEMPSearchCriteriaFrame.document.forms[0].checkout_yn.value;
		var sys_date=parent.AEMPSearchCriteriaFrame.document.forms[0].sys_date.value;
		var p_cutoff_hours_prv_day_visit=parent.AEMPSearchCriteriaFrame.document.forms[0].p_cutoff_hours_prv_day_visit.value;	
		var clinic_code=parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_code.value;
		var treatment_area_code=parent.AEMPSearchCriteriaFrame.document.forms[0].treatment_area_code.value;
		var practitioner_id=parent.AEMPSearchCriteriaFrame.document.forms[0].practitioner_id.value; 
		var patient_id=parent.AEMPSearchCriteriaFrame.document.forms[0].patient_id.value;
        var priority="";
        var priority_zone=parent.AEMPSearchCriteriaFrame.document.forms[0].priority_zone.value;
		var bed_bay_type=parent.AEMPSearchCriteriaFrame.document.forms[0].bed_bay_type.value; 
		var function_id=parent.AEMPSearchCriteriaFrame.document.forms[0].function_id.value;
	//	parent.AEMPSearchCriteriaFrame.document.forms[0].action	=	"../../eAE/jsp/AEMPSearchResult.jsp?from="+from+"&to="+to+"&ch_x="+ch_x+"&ch_id="+ch_id+"&oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&bed_bay_type="+bed_bay_type+"&function_id="+function_id;
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		//Start
		var bed_bay_type=document.forms[0].bed_bay_type.value;
		var include_checkedout=document.forms[0].include_checkedout.value;
		var prev_visit=document.forms[0].prev_visit.value; 		 
		var gender=document.forms[0].gender.value;
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		//Start
		var priority_zone=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value;
		//Maheshwaran K added for ML-MMOH-CRF-1972 as on 07-07-2023
		if(isForAdmission == "true" || isForAdmission == true) {	
			if(document.getElementById('ForIPAdmissionTab').style.visibility){
				document.getElementById('ForIPAdmissionTab').style.visibility='hidden';	
			}		
		}
		//Ends
		
	/*if(isAppearAsTabEnable==true || isAppearAsTabEnable =="true") {
		  if(((clinic_code!='' && document.forms[0].clinic_code2.value=="") || (clinic_code!=document.forms[0].clinic_code2.value))
			|| ((practitioner_id!='' && document.forms[0].practitioner_id1.value=="") || (practitioner_id!=document.forms[0].practitioner_id1.value))
			|| ((patient_id!='' && document.forms[0].patient_id1.value=="") || (patient_id!=document.forms[0].patient_id1.value))
			|| ((gender!='' && document.forms[0].gender1.value=="") || (gender!=document.forms[0].gender1.value))
			)
			{		
			//alert("../../eAE/jsp/AEMPSearchCriteria.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&gender="+gender+"&include_checkedout="+include_checkedout+"&prev_visit="+prev_visit+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code)
			document.forms[0].target	=	"AEMPSearchCriteriaFrame";
			document.forms[0].action	=	"../../eAE/jsp/AEMPSearchCriteria.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&gender="+gender+"&include_checkedout="+include_checkedout+"&prev_visit="+prev_visit+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code;
			document.forms[0].method	=	"GET";
			document.forms[0].submit();
			document.forms[0].target	=	"AEMPSearchResultFrame";
			validateResultPage =true;
			}
	} */
		//Ends
		if(validateResultPage==false || validateResultPage =="false"){
		parent.AEMPSearchCriteriaFrame.document.forms[0].action	=	"../../eAE/jsp/AEMPSearchResult.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&bed_bay_type="+bed_bay_type+"&function_id="+function_id+"&enableSubTabForIPAdm="+enableSubTabForIPAdm+"&treatmentTabValue="+treatmentTabValue;
		parent.AEMPSearchCriteriaFrame.document.forms[0].method	=	"GET";				
		if(SpecialCharCheck(fields,names,parent.parent.messageFrame,"M",error_jsp)){
		parent.AEMPSearchCriteriaFrame.document.forms[0].submit();
		}
		}
	} 
	else if (from=='nursing')
	{
		document.forms[0].from.value="";
		document.forms[0].to.value="";
		document.forms[0].ch_id.value="";
		    var gender			=	document.forms[0].gender.value;
			var observe_id		= parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.observe_id.value;
			var patient_id=parent.AEMPSearchCriteriaFrame.document.forms[0].patient_id.value;
			var nursing_unit_code		=	document.forms[0].nursing_unit_code.value;
		    var oper_stn_id=document.forms[0].oper_stn_id.value;
			var error_jsp="../../eCommon/jsp/error.jsp";
		    var messageFrame="";
			//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
			//Start
			var priority_zone=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value;
			//Maheshwaran K added for ML-MMOH-CRF-1972 as on 07-07-2023
			if(isForAdmission == "true" || isForAdmission == true) {	
				if(document.getElementById('ForIPAdmissionTab').style.visibility){
				document.getElementById('ForIPAdmissionTab').style.visibility='hidden';	
			}		
			}
			//Ends
			if(validateResultPage==false || validateResultPage =="false"){
			document.forms[0].action	=	"../../eAE/jsp/AEIPSearchResult.jsp?oper_stn_id="+oper_stn_id+"&gender="+gender+"&patient_id="+patient_id+"&observe_id="+observe_id+"&nursing_unit_code="+nursing_unit_code+"&enableSubTabForIPAdm="+enableSubTabForIPAdm+"&treatmentTabValue="+treatmentTabValue;
		   document.forms[0].target	=	"AEMPSearchResultFrame";
		   document.forms[0].method	=	"GET";
		   document.forms[0].submit();
			}

	}
	else if (from=='clinic')
	{
		document.forms[0].from.value="";
		document.forms[0].to.value="";
		document.forms[0].ch_id.value="";
		var observe_id		= parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.observe_id.value;
		var clinic_code		=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.clinic_code;
		var clinic_type		=	'';        
		clinic_type=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.clinic_type.value			=	parent.AEMPSearchCriteriaFrame.clinicType[clinic_code.selectedIndex];
		var fields = new Array (parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.patient_id);
		var names = new Array ("Patient ID");	
		var error_jsp="../../eCommon/jsp/error.jsp";
		var messageFrame="";
		document.forms[0].target	=	"AEMPSearchResultFrame";
		var nursing_unit_code		=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.nursing_unit_code.value;
		var oper_stn_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.oper_stn_id.value;
		var checkout_yn=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.checkout_yn.value;
		var sys_date=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.sys_date.value;
		var p_cutoff_hours_prv_day_visit=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.p_cutoff_hours_prv_day_visit.value;
		var rslt_clinic_code=parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_code.value;
		var treatment_area_code=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.treatment_area_code.value;
		var practitioner_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.practitioner_id.value;
		var patient_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.patient_id.value;
        var priority_zone=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value;
        var priority="";
        var oberv_clinc_code=nursing_unit_code;
		var orderCriteria	=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value
		var asc_desc	=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.asc_desc.value
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		//Start
		var bed_bay_type=document.forms[0].bed_bay_type.value;
		var include_checkedout=document.forms[0].include_checkedout.value;
		var prev_visit=document.forms[0].prev_visit.value; 		 
		var gender=document.forms[0].gender.value;
		//Maheshwaran K added for ML-MMOH-CRF-1972 as on 07-07-2023
		if(isForAdmission == "true" || isForAdmission == true) {	
		if(document.getElementById('ForIPAdmissionTab').style.visibility){
				document.getElementById('ForIPAdmissionTab').style.visibility='hidden';	
				}
		/*	if(document.getElementById("enableSubTabForIPAdm").value=='Y')
			{
			document.getElementById("ForIPAdmissionTab").style.visibility='visible';	
			}
			else {
				document.getElementById("ForIPAdmissionTab").style.visibility='hidden';	
			}	*/	
		}
	/*if(isAppearAsTabEnable==true || isAppearAsTabEnable =="true") {
		
		  if(((clinic_code!='' && document.forms[0].clinic_code2.value=="") || (clinic_code!=document.forms[0].clinic_code2.value))
			|| ((practitioner_id!='' && document.forms[0].practitioner_id1.value=="") || (practitioner_id!=document.forms[0].practitioner_id1.value))
			|| ((patient_id!='' && document.forms[0].patient_id1.value=="") || (patient_id!=document.forms[0].patient_id1.value))
			|| ((gender!='' && document.forms[0].gender1.value=="") || (gender!=document.forms[0].gender1.value))
			{		
			//alert("../../eAE/jsp/AEMPSearchCriteria.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&gender="+gender+"&include_checkedout="+include_checkedout+"&prev_visit="+prev_visit+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code)
			document.forms[0].target	=	"AEMPSearchCriteriaFrame";
			document.forms[0].action	=	"../../eAE/jsp/AEMPSearchCriteria.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&gender="+gender+"&include_checkedout="+include_checkedout+"&prev_visit="+prev_visit+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code;
			document.forms[0].method	=	"GET";
			document.forms[0].submit();
			document.forms[0].target	=	"AEMPSearchResultFrame";
			validateResultPage =true;
			}
	} */
		//Ends
		if(validateResultPage==false || validateResultPage =="false"){
		
		document.forms[0].action	= "../../eAE/jsp/AEMPSearchResult.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+rslt_clinic_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code+"&observ_id="+observe_id+"&oberv_clinc_code="+oberv_clinc_code+"&orderCriteria="+orderCriteria+"&asc_desc="+asc_desc+"&clinic_type="+clinic_type+"&enableSubTabForIPAdm="+enableSubTabForIPAdm+"&treatmentTabValue="+treatmentTabValue;
		document.forms[0].method	=	"POST";				
		if(SpecialCharCheck(fields,names,parent.messageFrame,"M",error_jsp))
			{
			document.forms[0].submit();
			}
	}
	}
		else if (from=='TreatmentArea')
	{
       
		document.forms[0].from.value="";
		document.forms[0].to.value="";
		document.forms[0].ch_id.value="";
		var observe_id		=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.observe_id.value;
		var clinic_code		=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.clinic_code;

		var clinic_type		=	'';        
		clinic_type=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.clinic_type.value			=	parent.AEMPSearchCriteriaFrame.clinicType[clinic_code.selectedIndex];
		var fields = new Array (parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.patient_id);
		var names = new Array ("Patient ID");	
		var error_jsp="../../eCommon/jsp/error.jsp";
		var messageFrame="";
		document.forms[0].target	=	"AEMPSearchResultFrame";
		var nursing_unit_code		=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.nursing_unit_code.value;
		var oper_stn_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.oper_stn_id.value;
		var checkout_yn=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.checkout_yn.value;
		var sys_date=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.sys_date.value;
		var p_cutoff_hours_prv_day_visit=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.p_cutoff_hours_prv_day_visit.value;
		var rslt_clinic_code=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.clinic_code.value;
		var treatment_area_code=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.treatment_area_code.value;
		parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.treatment_area_code1.value="";
		var practitioner_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.practitioner_id.value;
		var patient_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.patient_id.value;
        var priority_zone=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value;
        var priority="";
		var oberv_TMT_code=nursing_unit_code;
		var orderCriteria	=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value
		var asc_desc	=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.asc_desc.value
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		//Start
		var bed_bay_type=document.forms[0].bed_bay_type.value;
		var include_checkedout=document.forms[0].include_checkedout.value;
		var prev_visit=document.forms[0].prev_visit.value; 		 
		var gender=document.forms[0].gender.value;
		//Maheshwaran K added for ML-MMOH-CRF-1972 as on 07-07-2023
		if(isForAdmission == "true" || isForAdmission == true) {	
			if(document.getElementById('ForIPAdmissionTab').style.visibility){
				document.getElementById('ForIPAdmissionTab').style.visibility='hidden';	
			}		
		}
	/*	if(isAppearAsTabEnable==true || isAppearAsTabEnable =="true") {
		
		  if(((clinic_code!='' && document.forms[0].clinic_code2.value=="") || (clinic_code!=document.forms[0].clinic_code2.value))
			|| ((practitioner_id!='' && document.forms[0].practitioner_id1.value=="") || (practitioner_id!=document.forms[0].practitioner_id1.value))
			|| ((patient_id!='' && document.forms[0].patient_id1.value=="") || (patient_id!=document.forms[0].patient_id1.value))
			|| ((gender!='' && document.forms[0].gender1.value=="") || (gender!=document.forms[0].gender1.value))
			)
			{			
		//	alert("../../eAE/jsp/AEMPSearchCriteria.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&gender="+gender+"&include_checkedout="+include_checkedout+"&prev_visit="+prev_visit+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code)
			document.forms[0].target	=	"AEMPSearchCriteriaFrame";
			document.forms[0].action	=	"../../eAE/jsp/AEMPSearchCriteria.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&gender="+gender+"&include_checkedout="+include_checkedout+"&prev_visit="+prev_visit+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code;
			document.forms[0].method	=	"GET";
			document.forms[0].submit();
			document.forms[0].target	=	"AEMPSearchResultFrame";
			validateResultPage =true;
			}
		} */
		//Ends	
		if(validateResultPage==false || validateResultPage =="false"){
		document.forms[0].action	="../../eAE/jsp/AEMPSearchResult.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+rslt_clinic_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code+"&observ_id="+observe_id+"&oberv_TMT_code="+oberv_TMT_code+"&orderCriteria="+orderCriteria+"&asc_desc="+asc_desc+"&clinic_type="+clinic_type+"&enableSubTabForIPAdm="+enableSubTabForIPAdm+"&treatmentTabValue="+treatmentTabValue;
		document.forms[0].method	=	"POST";				
		if(SpecialCharCheck(fields,names,parent.messageFrame,"M",error_jsp))
			{
			document.forms[0].submit();
			}
		}
	}


	else{
	document.forms[0].from.value="";
	document.forms[0].to.value="";
	document.forms[0].ch_id.value="";
		var clinic_code		=	document.forms[0].clinic_code;
		var clinic_type		=	document.forms[0].clinic_type;
		document.forms[0].clinic_type.value			=	clinicType[clinic_code.selectedIndex];
		var fields = new Array (document.forms[0].patient_id);
		var names = new Array (getLabel("Common.patientId.label","Common"));	
		var error_jsp="../../eCommon/jsp/error.jsp";
		var messageFrame="";
		document.forms[0].target	=	"AEMPSearchResultFrame";
		var nursing_unit_code		=	document.forms[0].nursing_unit_code.value;
		var oper_stn_id=document.forms[0].oper_stn_id.value;
		var checkout_yn=document.forms[0].checkout_yn.value;
		var sys_date=document.forms[0].sys_date.value;
		var p_cutoff_hours_prv_day_visit=document.forms[0].p_cutoff_hours_prv_day_visit.value;
		var clinic_code=document.forms[0].clinic_code.value;
		var treatment_area_code=document.forms[0].treatment_area_code.value;
		var bed_bay_type=document.forms[0].bed_bay_type.value;
		var bed_bay_type1=document.forms[0].bed_bay_type1.value;
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		if(isAppearAsTabEnable==true || isAppearAsTabEnable =="true") {
	/*	if(treatment_area_code=='' && document.forms[0].treatment_area_code1.value!='')
			{
				treatment_area_code=document.forms[0].treatment_area_code1.value;
			} */
		/*if((bed_bay_type=='' || bed_bay_type=="null" || bed_bay_type==null) && (document.forms[0].bed_bay_type1.value!='' || document.forms[0].bed_bay_type1.value!=null ||document.forms[0].bed_bay_type1.value!="null") )
			{
			alert("inside");
				bed_bay_type=document.forms[0].bed_bay_type1.value;
				alert(bed_bay_type);
			}*/
		
		/*	if(treatment_area_code=='' && document.forms[0].treatment_area_code2.value!='')
			{
				treatment_area_code=document.forms[0].treatment_area_code2.value;
			} */
		//	if(treatment_area_code==''!)
		//	alert('document.forms[0].treatment_area_code.value : '+document.forms[0].treatment_area_code.value);
		//alert('document.forms[0].treatment_area_code1.value : '+document.forms[0].treatment_area_code1.value);
	//		alert('document.forms[0].treatment_area_code2.value : '+document.forms[0].treatment_area_code2.value);
	//	document.forms[0].treatment_area_code.value=document.forms[0].treatment_area_code2.value;	
		}
		var practitioner_id=document.forms[0].practitioner_id.value;
		var patient_id=document.forms[0].patient_id.value;
        var priority_zone=document.forms[0].priority_zone.value;
        var priority="";
		//Maheshwaran K added for ML-MMOH-CRF-1972 as on 07-07-2023
		if(isForAdmission == "true" || isForAdmission == true) {
			if(document.getElementById('enableSubTabForIPAdm').value=='Y')
			{
			document.getElementById('ForIPAdmissionTab').style.visibility="visible";	
			}
			else {
				document.getElementById('ForIPAdmissionTab').style.visibility="hidden";	
			}		
		}
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		//Start
		
		var include_checkedout=document.forms[0].include_checkedout.value;
		var prev_visit=document.forms[0].prev_visit.value; 		 
		var gender=document.forms[0].gender.value;
		var appear_as_tab_yn=document.forms[0].appear_as_tab_yn.value;
		//End
		var isForAdmission = document.forms[0].isForAdmission.value;
		//Start - Used to reload the frame to get the tabs displayed based on the treatment area against the tab.
			if(isAppearAsTabEnable==true || isAppearAsTabEnable =="true") {
					if(document.forms[0].bed_bay_type2.value=="true")
					{
					document.forms[0].bed_bay_type1.value="";	
					}
		  if(((clinic_code!='' && document.forms[0].clinic_code2.value=="") || (clinic_code!=document.forms[0].clinic_code2.value))
					||  ((treatment_area_code!='' && document.forms[0].treatment_area_code2.value=="") || (treatment_area_code!=document.forms[0].treatment_area_code2.value))
			||  ((bed_bay_type!='' && document.forms[0].bed_bay_type1.value=="") || ( bed_bay_type!='' && bed_bay_type!=document.forms[0].bed_bay_type1.value) || ( document.forms[0].bed_bay_type2.value=="true"))
			|| ((practitioner_id!='' && document.forms[0].practitioner_id1.value=="") || (practitioner_id!=document.forms[0].practitioner_id1.value))
			|| ((patient_id!='' && document.forms[0].patient_id1.value=="") || (patient_id!=document.forms[0].patient_id1.value))
			|| ((gender!='' && document.forms[0].gender1.value=="") || (gender!=document.forms[0].gender1.value))
			|| ((prev_visit!='' && document.forms[0].prev_visit1.value=="") || (prev_visit!=document.forms[0].prev_visit1.value))
			|| ((include_checkedout!='' && document.forms[0].include_checkedout1.value=="") || (include_checkedout!=document.forms[0].include_checkedout1.value))
			)
			{			
			  if( ((practitioner_id!='' && document.forms[0].practitioner_id1.value=="") || (practitioner_id!=document.forms[0].practitioner_id1.value))
			|| ((patient_id!='' && document.forms[0].patient_id1.value=="") || (patient_id!=document.forms[0].patient_id1.value))
			|| ((gender!='' && document.forms[0].gender1.value=="") || (gender!=document.forms[0].gender1.value))
			|| ((prev_visit!='' && document.forms[0].prev_visit1.value=="") || (prev_visit!=document.forms[0].prev_visit1.value))
			|| ((include_checkedout!='' && document.forms[0].include_checkedout1.value=="") || (include_checkedout!=document.forms[0].include_checkedout1.value))
			  )
				{
			  toggleValue = "Y";
				}
			 document.forms[0].toggleId1.value = toggleValue;
		//	alert("../../eAE/jsp/AEMPSearchCriteria.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&gender="+gender+"&include_checkedout="+include_checkedout+"&prev_visit="+prev_visit+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code)
			document.forms[0].target	=	"AEMPSearchCriteriaFrame";
			document.forms[0].action	=	"../../eAE/jsp/AEMPSearchCriteria.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&gender="+gender+"&include_checkedout="+include_checkedout+"&prev_visit="+prev_visit+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code;
			document.forms[0].method	=	"GET";
			document.forms[0].submit();
			document.forms[0].target	=	"AEMPSearchResultFrame";
			validateResultPage =true;
			} 
			}
		//Ends
		if(validateResultPage==false || validateResultPage =="false"){
		document.forms[0].action	=	"../../eAE/jsp/AEMPSearchResult.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type1+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code+"&enableSubTabForIPAdm="+enableSubTabForIPAdm+"&appear_as_tab_yn="+appear_as_tab_yn+"&treatmentTabValue="+treatmentTabValue;
		document.forms[0].method	=	"GET";
		if(SpecialCharCheck(fields,names,parent.messageFrame,"M",error_jsp)){
			document.forms[0].submit();
			}
			}
  }
}

/***************************************************/
/* Below method modified by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
//reg_new_born_yn,inv_reg_new_born_yn Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148]
async function showAllowedOperations( clinic_code,clinic_desc,clinic_type,patient_id, queue_status, encounter_id, triage_area, trauma_yn, treatment_area_code, practitioner_id, practitioner_name,treatment_area_desc, open_to_all_prac_for_clinic_yn, check_in_date_time, sys_date_time, queue_date, patient_gender, brought_dead, assign_tmt_area_time, open_to_all_pract_yn, patient_class, priority_zone,bed_no,visit_type_code,pract_type,record_vital_signs_yn,pract_type1,enable_rights_yn,sel_triage_yn,sel_cons_yn,end_date,start_date,enable_rights_yn,min_age_for_lmp,year_value,allow_chkout_with_bill_stmt_yn,episode_id,visit_num,orderctlHDR,image_id,row,link,reg_new_born_yn,inv_reg_new_born_yn,pendngAdmDateTime,sel_admission_yn,sel_cancel_yn,sel_referral_yn,enable_admission_tab,referral_id,assign_bed_cnt)//Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 //sel_admission_yn , sel_cancel_yn , sel_referral_yn , enable_admission_tab Added by Kamatchi S for ML-MMOH-CRF-1972
{
	

	var CA_installed = document.forms[0].CAInstalled.value;
	//Added for MMS-QH-CRF-0126.2 Start
	var facility_id	= document.forms[0].facility_id.value;
	var action_on_pending_bill	= document.forms[0].action_on_pending_bill.value;
	var five_level_triage_appl_yn	= document.forms[0].five_level_triage_appl_yn.value;
	//Added for MMS-QH-CRF-0126.2 End

	
	query_string		= "patient_id="+patient_id+"&encounter_id="+encounter_id+"&queue_status="+ queue_status+"&triage_area="+triage_area+"&trauma_yn="+trauma_yn+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&clinic_code="+clinic_code+"&clinic_type="+clinic_type+"&queue_date="+queue_date+"&encounter_id="+encounter_id+"&assign_tmt_area_time="+assign_tmt_area_time+"&brought_dead="+brought_dead+"&orig_tmt_area_code="+treatment_area_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&clinic_desc="+encodeURIComponent(clinic_desc)+"&treatment_area_desc="+encodeURIComponent(treatment_area_desc)+"&open_to_all_prac_for_clinic_yn="+open_to_all_prac_for_clinic_yn+"&check_in_date_time="+check_in_date_time+"&sys_date_time="+sys_date_time+"&patient_gender="+patient_gender+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&practitioner_name="+encodeURIComponent(practitioner_name)+"&priority_zone="+priority_zone+"&bed_no="+bed_no+"&visit_date_time="+check_in_date_time+"&visit_type_code="+visit_type_code+"&min_age_for_lmp="+min_age_for_lmp+"&year_value="+year_value+"&pract_type="+pract_type+"&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn+"&episode_id="+episode_id+"&visit_id="+visit_num+"&CA_installed="+CA_installed+"&enable_rights_yn="+enable_rights_yn+"&start_date="+start_date+"&end_date="+end_date+"&sel_triage_yn="+sel_triage_yn+"&sel_cons_yn="+sel_cons_yn+"&pract_type1="+pract_type1+"&five_level_triage_appl_yn="+five_level_triage_appl_yn+"&regnew_born_yn="+reg_new_born_yn+"&inv_reg_new_born_yn="+inv_reg_new_born_yn+"&pendngAdmDateTime="+pendngAdmDateTime+"&sel_admission_yn="+sel_admission_yn+"&sel_cancel_yn="+sel_cancel_yn+"&sel_referral_yn="+sel_referral_yn+"&enable_admission_tab="+enable_admission_tab+"&referral_id="+referral_id;//Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 

		
	
		if(CA_installed=="N" || CA_installed=="")	{
 
     /* Below method added by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
		callMouseOverOnTD(orderctlHDR,image_id,row,link);
	
		var eid						=  	parent.AEMPSearchCriteriaFrame.document.forms[0].encounter_id;
		var retVal			=	"";
		var selection_mode	=	"";
		
	

		
		var dialogHeight	=	"";

		if(brought_dead=="N")  	{
			dialogHeight	=	"6px" ;
			if(triage_area=="A")	dialogHeight	=	"10px" ;
			else if(triage_area=="B")	dialogHeight	=	"10px" ;
			else if(triage_area=="C" && trauma_yn=="Y" )	dialogHeight	=	"13px" ;
			else dialogHeight	=	"13px" ;
        
		}  else dialogHeight	=	"80vh" ;
		var dialogWidth		=	"80vw" ;
		var dialogTop		=	"0vh";
		var status			=	"no";
		var arguments		=	"" ;
		var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal+"&"+query_string;
		if(queue_status=="01") dialogHeight	=	"9px" ;
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status + ";";
		retVal				= await	window.showModalDialog(action_url,arguments,features);

		if (retVal != null) 	{
			var retarr=retVal.split("|");
			var retVal1=retarr[0];
			var retVal2 = retarr[1];
		
			if( retVal1=="AssignTreatmentArea" || retVal1=="AssignReassignPractitioner" || retVal1=="ReassignTreatmentArea")  {
				
				selection_mode		=	"AssignTreatmentArea";
				var dialogHeight	=	"80vh";
				var dialogWidth		=	"80vw";
				var dialogTop		=	"0vh";
				var status			=	"no";
				var arguments		=	"" ; 
				var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal1+"&"+query_string;
				var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";

				/*retVal	=	window.showModalDialog(action_url,arguments,features);

				if(retVal11!=null) {
					var retarr1=retVal.split("|");
					var retVal11=retarr[0];
					var retVal21 = retarr[1];
					if(retVal11=="Success") 	{
					parent.AEMPSearchResultFrame.location.href = parent.AEMPSearchResultFrame.location.href;
						//parent.AEMPSearchResultFrame.location.reload(); Modified by Munisekhar for IN43904
					}
				}*/
				if(action_on_pending_bill=="N"){
					FnProceedAssignTreatmentArea1(action_url,arguments,features);
				}else{
					FnCheckOPQBLValidation1(encounter_id,visit_num,facility_id,action_on_pending_bill,patient_id,episode_id,action_url,arguments,features);
				}
				// Added for MMS-QH-CRF-0126.2

			} else if(retVal1=="StartConsultation") {
	
					var dialogHeight	=	"80vh";
					var dialogWidth		=	"80vw";
					var dialogTop		=	"0vh";
					var status			=	"no";
					var arguments		=	"" ;
					var action_url		=	"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode="+retVal1+"&"+query_string;
					var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
		
					/*retVal	=	window.showModalDialog(action_url,arguments,features);
			
					if(retVal11!=null) 	{
						var retarr1=retVal.split("|");
						var retVal11=retarr[0];
						var retVal21 = retarr[1];
						if(retVal11=="Success")
						parent.AEMPSearchResultFrame.location.href = parent.AEMPSearchResultFrame.location.href;
							//parent.AEMPSearchResultFrame.location.reload(); Modified by Munisekhar for IN43904
					}*/
					if(action_on_pending_bill=="N"){
						FnProceedAssignTreatmentArea1(action_url,arguments,features);
					}else{
						FnCheckOPQBLValidation1(encounter_id,visit_num,facility_id,action_on_pending_bill,patient_id,episode_id,action_url,arguments,features);
					}
					// Added for MMS-QH-CRF-0126.2
			}else if(retVal1=="Triage") {
				
					var retVal = "";
					var dialogHeight= "95vh" ;
					var dialogWidth	= "95vw" ;
					var dialogTop ="20";
					var status = "no";
					var arguments	= " ";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
					retVal = await top.window.showModalDialog("../../eAE/jsp/AETriageFrameset.jsp?selection_mode="+retVal+"&"+query_string,arguments,features);
				} else if(retVal1=="CheckOut") {
					 LoadChkOut(encounter_id,brought_dead,treatment_area_code,open_to_all_prac_for_clinic_yn,clinic_code,open_to_all_pract_yn,patient_id,clinic_type,allow_chkout_with_bill_stmt_yn,episode_id,visit_num);
				} else if(retVal1=="ViewPatient") {
					var url			= "../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID="+patient_id+"&EncounterId="+encounter_id;
					var dialogTop		= "70";
					var dialogHeight	= "55vh";
					var dialogWidth		= "65vw";
					var arguments	= "" ;
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
					var returnval = await window.showModalDialog( url, arguments, features ) ;
				} else if(retVal1=="MovementHistory") {
					var retVal = "";
					var dialogHeight= "35vh" ;
					var dialogWidth	= "45vw" ;
					var dialogTop ="150";
					var status = "no";
					var arguments	= "" ;
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
					var action_url		=	"../../eAE/jsp/AEMovementHistoryMain.jsp?modify_flag=N&"+query_string;
					retVal = await window.showModalDialog(action_url,arguments,features);
				} else if(retVal1=="RegisterNewBornForAE"){
					fnCallRegNewBornForAE(patient_id);
				} 
				/*Added by Thamizh selvi on 2nd May 2018 against ML-MMOH-CRF-0658 Start*/
				/*//Kamatchi added -isPendingForAdmissionAppl for ML-MMOH-CRF-1973 as on 07-07-2023*/
				else if(retVal1=="for_admission" && document.forms[0].isPendingForAdmissionAppl.value == "true"){
					pendingForAdmission(patient_id,encounter_id);
				}/*End*/
				else if(retVal1=="for_admission" && document.forms[0].isForAdmission.value == "true"){
					checkForAdmissionReferral(patient_id,encounter_id);
				}
			}
			 window.location.href = window.location.href;
			//window.location.reload(); Modified by Munisekhar for IN43904
		} else  {  
		
			if (record_vital_signs_yn=='Y')
			{          /* Below method modified by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
				//Kamatchi added for ML-MMOH-CRF-1973 as on 07-07-2023 -sel_admission_yn,sel_cancel_yn,sel_referral_yn,enable_admission_tab,referral_id
			            displayToolTip(patient_id,queue_status,queue_date,encounter_id,brought_dead,patient_class,patient_gender,priority_zone,bed_no,practitioner_id,record_vital_signs_yn,pract_type1,enable_rights_yn,sel_triage_yn,sel_cons_yn,min_age_for_lmp,year_value,allow_chkout_with_bill_stmt_yn,episode_id,treatment_area_code,visit_num,facility_id,action_on_pending_bill,orderctlHDR,image_id,row,link,reg_new_born_yn,inv_reg_new_born_yn,pendngAdmDateTime,sel_admission_yn,sel_cancel_yn,sel_referral_yn,enable_admission_tab,referral_id,assign_bed_cnt);//Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658
				/*Corrected by Rameswar on 08-Feb-16 for GDOH-CRF-081*/	
			}
			else
			{
				/*var HTMLVal  = "<html>";
				HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp'>";
				HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + encounter_id + "'>";
				HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='AE'>";
				HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
				HTMLVal  += "</form>";
				HTMLVal  += "</html>";
				top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);		
				top.content.messageFrame.document.OpenChartWrapperForm.submit();*/
				
				/* Below method modified by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
				//Kamatchi added for ML-MMOH-CRF-1973 as on 07-07-2023 -sel_admission_yn,sel_cancel_yn,sel_referral_yn,enable_admission_tab,referral_id
					displayToolTip(patient_id,queue_status,queue_date,encounter_id,brought_dead,patient_class,patient_gender,priority_zone,bed_no,practitioner_id,record_vital_signs_yn,pract_type1,enable_rights_yn,sel_triage_yn,sel_cons_yn,min_age_for_lmp,year_value,allow_chkout_with_bill_stmt_yn,episode_id,treatment_area_code,visit_num,facility_id,action_on_pending_bill,orderctlHDR,image_id,row,link,reg_new_born_yn,inv_reg_new_born_yn,pendngAdmDateTime,sel_admission_yn,sel_cancel_yn,sel_referral_yn,enable_admission_tab,referral_id,assign_bed_cnt);//Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658
			}

		}
	}

function callOperation(operation,val)
{
	parent.window.returnValue = operation+"|"+val;
	parent.window.close();
}
function cancelOperation() 
{
	parent.window.returnValue = "";
	parent.window.close();
}
function cancelOperation1(val)
{
	if (val=="AEMODAL")
	{
		parent.window.returnValue = "";
	    parent.window.close();
	}else{
		if(top.content.workAreaFrame!=null)
		top.content.workAreaFrame.location.href = "../../eCommon/html/blank.html";
	}
}
async function assignTreatmentArea()
{
	var ca_install = document.forms[0].strCA.value;
	var treatment_area_code	=	document.forms[0].treatment_area_code;
	var practitioner_id		=	document.forms[0].practitioner_id.value;
	var priority_value		=   document.forms[0].priority_value;
	var bed_bay_no			=   document.forms[0].bed_bay_no;
	var selection_mode		=	document.forms[0].selection_mode.value;
	var bed_count           =   document.forms[0].bed_count.value; 
	var practitioner_desc   =   document.forms[0].practitioner_desc; 
	var year_value   =   document.forms[0].year_value; 
	var min_age_for_lmp   =   document.forms[0].min_age_for_lmp; 

	//Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133
	var isEnableDateTimeAppl   =   document.forms[0].isEnableDateTimeAppl.value; 
	var assign_tmt_area_time   =   document.forms[0].assign_tmt_area_time.value; 
	//Added by Ajay Hatwate for KDAH-SCF-893-TF on 10/08/2023
	document.forms[0].ok.disabled=true;	

    if (document.forms[0].bed_bay_no.value !="")
    {
		/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
		if(isEnableDateTimeAppl=="true" && assign_tmt_area_time=="")
		{
			var msg = getMessage('CAN_NOT_BE_BLANK','Common')
			msg = msg.replace("$",getLabel("Common.datetime.label","Common"))
			alert(msg);
			document.forms[0].assign_tmt_area_time.focus();
			return false;  
		}else
		{
			BedValidation(document.forms[0].bed_bay_no.value,selection_mode);
		}
    }else{
	treatment_area_code.disabled = false;
	document.forms[0].priority_value.disabled=false;

	if(top.messageframe==null){

	document.forms[0].target = "messageFrame";}
	else {

	document.forms[0].target = "messageframe";
	}
	document.forms[0].method = "POST";

	if(ca_install =='Y' && bed_count=='N'){
    }
	if(ca_install =='Y' && bed_count=='Y'){

      if(trimCheck(treatment_area_code.value)==false)
		{
			alert(getMessage('AE_TMT_AREA_BLANK','AE'))
			treatment_area_code.focus();
			document.forms[0].ok.disabled=true;
			return false;  
		}
	  if(trimCheck(bed_bay_no.value)==false)
		{
				var bedno=getMessage('CAN_NOT_BE_BLANK','Common')
				bedno=bedno.replace("$",getLabel("Common.bedno.label","Common"))
				alert(bedno);
				bed_bay_no.focus();
				document.forms[0].ok.disabled=true;
				return false;  
		}
	  /*if(practitioner_id=='' || practitioner_id=='*ALL')
		{
			alert(getAEMessage("AE_PRACTITIONER_BLANK"));
			practitioner_desc.focus();
			document.forms[0].ok.disabled=true;
			return false;
		}*/
    }

	if(selection_mode =='AssignReassignPractitioner')
	{
		if (bed_count=='Y')
		{
			 if(trimCheck(bed_bay_no.value)==false)
				{
					 var bedno=getMessage('CAN_NOT_BE_BLANK','Common')
			  bedno=bedno.replace("$",getLabel("Common.bedno.label","Common"))
					bed_bay_no.focus();
					document.forms[0].ok.disabled=true;
					return false;  
				}
			 if(practitioner_id=='' || practitioner_id=='*ALL')
				{
					alert(getMessage("AE_PRACTITIONER_BLANK",'AE'));
					practitioner_desc.focus();
					document.forms[0].ok.disabled=true;
					return false;
				}
		}
		else if (bed_count=='N'){
		if(practitioner_id=='' || practitioner_id=='*ALL')
		{
			alert(getMessage("AE_PRACTITIONER_BLANK",'AE'));
			practitioner_desc.focus();
			document.forms[0].ok.disabled=true;
			return false;
		}
	  }
	}
	if (bed_count=='Y')
	{
		if(trimCheck(bed_bay_no.value)==false)
		{
			var bedno=getMessage('SHOULD_NOT_BE_BLANK','Common')
			bedno=bedno.replace("{1}",getLabel("Common.bedno.label","Common"))
			alert(bedno)
			bed_bay_no.focus();
			document.forms[0].ok.disabled=true;
			return false;  
		}
	}
	
	/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
	if(isEnableDateTimeAppl=="true" && assign_tmt_area_time=="")
	{
		var msg = getMessage('CAN_NOT_BE_BLANK','Common')
		msg = msg.replace("$",getLabel("Common.datetime.label","Common"))
		alert(msg);
		document.forms[0].assign_tmt_area_time.focus();
		return false;  
	}
	/*End ML-MMOH-CRF-1133*/

    document.forms[0].assign_tmt_area_time.disabled=false;
   if(await funQry())
	{
		document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";
		document.forms[0].submit();
	}
	else
	{
		document.forms[0].ok.disabled=false;//Added by Ajay Hatwate for KDAH-SCF-893-TF on 10/08/2023
		return false;
	}
   }
}

async function funQry1()
{
	
	var frame_name = '';
//	console.log(parent.frames[1]);
	
	var dialogFrame = parent.document.getElementById('dialog-body').contentWindow
	if(dialogFrame.frames[1].document.forms[0].name =='AEMPAssgnTmtAreaForm')
         frame_name = "dialogFrame.frames[1]";
	
	else
         frame_name = "parent.frames[3]";
    if(eval(frame_name+'.document.forms[0].bl_install_yn.value=="Y"'))
	 {
            var retVal;
            var dialogHeight          = "40vh";
            var dialogWidth           = "60vw";
            var dialogTop             = "10";
            var center                = "1" ; 
			var status                = "no";

            var features              = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
            var arguments             = "" ;
            var clinic_code           = eval(frame_name+'.document.forms[0].clinic_code.value');
            var visit_type_code       = eval(frame_name+'.document.forms[0].visit_type_code.value');
            var patient_id            = eval(frame_name+'.document.forms[0].patient_id.value');
            var episode_type          = "E"
            var episode_id            = eval(frame_name+'.document.forms[0].episode_id.value');
            var visit_id              = eval(frame_name+'.document.forms[0].episode_visit_num.value');
            var encounter_id          = eval(frame_name+'.document.forms[0].encounter_id.value');
            var facility_id           = eval(frame_name+'.document.forms[0].facility_id.value');
            var calling_module_id     = "AE"
            var calling_function_id   = "ASSIGN_PRACTITIONER";
            var logged_user_id        = eval(frame_name+'.document.forms[0].userid.value');
            var practitioner_id       = eval(frame_name+'.document.forms[0].practitioner_id.value');
            var practitioner_type_ind = "P"
            var url = "../../eBL/jsp/BLVisitChargeDetCloseConsultFrame.jsp?ae_bed_calYN=N&call_after_reg=Y&start_valid=Y&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id+"&logged_user_id="+logged_user_id+"&practitioner_id="+practitioner_id+"&practitioner_type_ind="+practitioner_type_ind;     
            
            if(top.window.document.getElementById('dialog-body')){
            var frameST = top.window.document.getElementById('dialog-body').contentWindow;
            retVal = await frameST.window[1].showModalDialog(url,arguments,features);
            }else{
            retVal = await top.window.showModalDialog(url,arguments,features);          
            }
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


async function funQry()
{
	
	if(document.forms[0].bl_install_yn.value=="Y")
	 {
            var retVal;
            var dialogHeight          = "35vh";
            var dialogWidth           = "45vw";
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
            var practitioner_type_ind = "P";
			var ae_bed_calYN = "N";
			
			
            var url = "../../eBL/jsp/BLVisitChargeDetCloseConsultFrame.jsp?ae_bed_calYN=N&call_after_reg=Y&start_valid=Y&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id+"&logged_user_id="+logged_user_id+"&practitioner_id="+practitioner_id+"&practitioner_type_ind="+practitioner_type_ind; 
			
			

            retVal = await top.window.showModalDialog(url,arguments,features);

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


function BedValidation(bed,mode)
	{
if (document.forms[0].bed_bay_no.value == "")
    {
	return;
    
	}else{

		var facility_id			= document.forms[0].facility_id.value;
		var treatment_area = document.forms[0].treatment_area_code.value;
        var clinic = document.forms[0].clinic_code.value;
		var patient_id = document.forms[0].patient_id.value;
		var caInstalled = document.forms[0].strCA.value;
		if (bed != "" && clinic != "" && treatment_area != "")
		{
			var HTMLValue	= "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEBedValidGI.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='ManagePatGITreatArea'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='ValidBed'><input type='Hidden' name='field1' id='field1' value='"+treatment_area+"'><input type='Hidden' name='field2' id='field2' value='"+bed+"'><input type='Hidden' name='field3' id='field3' value='"+facility_id+"'><input type='Hidden' name='field4' id='field4' value='"+clinic+"'><input type='Hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='Hidden' name='caInstalled' id='caInstalled' value='"+caInstalled+"'><input type='Hidden' name='selection_mode' id='selection_mode' value='"+mode+"'><input type='Hidden' name='calledFrom' id='calledFrom' value='bedValidY'></form></body></html>"
			if( caInstalled=='Y')
            {	
                if( top.messageFrame==null)
			       {
					    top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLValue);
						top.content.messageFrame.document.dummy_form.submit();
			       }
				   else
                   {
			            top.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLValue);
         	            top.messageFrame.document.dummy_form.submit();
			       } 
			 }
            else
            {
            parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLValue);
            parent.messageFrame.document.dummy_form.submit();
            }
		}
	
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

	return_value	=	await PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	=return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}

async function LoadChkOut(eid,brought_dead,treatment_area_code,open_to_all_prac_for_clinic_yn,clinic_code,open_to_all_pract_yn,patient_id,clinic_type,allow_chkout_with_bill_stmt_yn,episode_id,visit_num,pend_ord_stats)
        {			
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
			var isProceed	= "N";
			var pen_orders_chk=document.forms[0].chk_for_pen_orders_bfr_chkout.value;
			var allow_yn=document.forms[0].checkout_allow_yn.value;	
			if(pen_orders_chk=='Y'){    
				var p_facility_id=document.forms[0].facility_id.value;
				var p_patient_id= patient_id;
				var p_enc_id=eid;
				var dialogHeight= "80vh" ;
				var dialogTop = "25" ;
				var dialogWidth	= "80vw" ;
				var status = "no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var url="../../eOR/jsp/ViewPendingOrders.jsp?patient_id="+p_patient_id+"&encounter_id="+p_enc_id+"&facility_id="+p_facility_id+"&discharge_ind=C";
				 if(pend_ord_stats =="Y"){
					if(allow_yn=="Y"){ 
							var retVal = new String();
							retVal = await top.window.showModalDialog(url,arguments,features);
							if(window.confirm(getMessage("PROCEED_CHECKOUT","AE"))) {
								isProceed="Y";
							}
					}else{
						if(window.confirm(getMessage("ORDER_PENDING_CNT_PROCEED_VIEW","IP"))) {
							var retVal = new String();
							retVal = await window.showModalDialog(url,arguments,features);
						}
					}
				}else{
					isProceed="Y";
				}
			}else{
				isProceed="Y";
			}
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
			if(isProceed=="Y"){
		    var retVal =    new String();
            var dialogTop	= "";
            var dialogHeight= "80vh" ;                     
            var dialogWidth = "80vw" ;
            var status = "no";
            var scroll = "no";
            var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
			var function_id=AEMPSearchResultForm.function_id.value;
			var checkout_yn=document.forms[0].checkout_yn.value;
			var five_level_triage_appl_yn	= AEMPSearchResultForm.five_level_triage_appl_yn.value;	

            var arguments   = "" ;
            var h="p3="+eid+"&module_id=AE&ae_treatment_area_code="+treatment_area_code+"&ae_brought_dead_yn="+brought_dead+"&open_to_all_pract_clinic="+open_to_all_prac_for_clinic_yn+"&p5="+clinic_code+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&p2="+patient_id+"&p4="+clinic_type+"&function_id="+function_id+"&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn+"&episode_id="+episode_id+"&visit_id="+visit_num+"&checkout_yn="+checkout_yn+"&five_level_triage_appl_yn="+five_level_triage_appl_yn;
			
			
            retVal = await top.window.showModalDialog("../../eOP/jsp/PatCheckoutCall.jsp?"+h,arguments,features);
			 window.location.href = window.location.href;
			//window.location.reload(); Modified by Munisekhar for IN43904
			var isForAdmission	=	document.forms[0].isForAdmission.value;
	if(isForAdmission==true || isForAdmission =="true") {
			reloadCriteria();
	}
				}
        }
        
function reset()
{
	f_query_add_mod.AEMPSearchCriteriaFrame.document.getElementById('others').style.background='NAVY';
	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].reset();
	frames[0].location.href = "../../eCommon/jsp/commonToolbar.jsp?menu_id=AE&module_id=AE&function_id=AE_MANAGE_PATIENT&function_name=Current%20Emergency%20Patients&function_type=F&access=NNNNN&desktopFlag=N";
	f_query_add_mod.AEMPSearchResultFrame.location.href='../../eCommon/html/blank.html';
	var isAppearAsTabEnable =f_query_add_mod.AEMPSearchCriteriaFrame.document.getElementById("isAppearAsTabEnable").value;//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
	if(isAppearAsTabEnable==true || isAppearAsTabEnable =="true")
		{
		 window.location.href=window.location.href;  	
		}
}

function query()
{
	var	queue_refresh_interval	=	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].queue_refresh_interval.value;
	var	oper_stn_id	=	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].oper_stn_id.value;
	var	sys_date	=	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].sys_date.value;
	var	p_cutoff_hours_prv_day_visit	=	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].p_cutoff_hours_prv_day_visit.value;
	var	checkout_yn	=	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].checkout_yn.value;
	f_query_add_mod.location.href = "../../eAE/jsp/AEManagePatientMain.jsp?queue_refresh_interval="+queue_refresh_interval+"&checkout_yn="+checkout_yn+"&oper_stn_id="+oper_stn_id+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit;
}
function beforeGetPractitioner(obj,target_name)
{
	target_name.value = trimString(target_name.value);
		 if(target_name.value=='')
			{
			 document.forms[0].practitioner_desc.value="";
			 document.forms[0].practitioner_id.value="";
			 return;
			}
			var prev_pract=document.forms[0].prev_pract_name.value;
			var present_pract=document.forms[0].practitioner_desc.value;
			if(present_pract!="" && prev_pract ==present_pract)
	        {	
		     return;
	        }
			aegetPractitioner(obj,target_name);
}
function aegetPractitioner(obj,target)
{
	var	clinic_code		=	document.forms[0].clinic_code.value;
	var treatment_area_code=document.forms[0].treatment_area_code.value;
	var open_to_all_pract_yn = document.forms[0].open_to_all_pract_yn.value;
	var speciality_code = document.forms[0].speciality_code.value;
	var locale=document.forms[0].locale.value;
	var open_to_all_practioners_of_clinic= "";
	var open_to_all_pract_of_treatment_area="";
	var practitioner_type = "";
	
    //open_to_all_pract_of_treatment_area=document.forms[0].open_to_all_prac_for_clinic_yn.value;
    open_to_all_prac_for_clinic_yn=document.forms[0].open_to_all_prac_for_clinic_yn.value;
	open_to_all_practioners_of_clinic = document.forms[0].open_to_all_pract_yn.value;  

	var facility_id			=	document.forms[0].facility_id.value;
	var FirstSql="";
	var SecondSql="";
	var tit="";
	var practitionerName="";
	var practitionerValue="";
		
	target.value=trimString(target.value);
	practitionerName=target.name;
	practitionerValue=target.value;

    //document.forms[0].prev_pract_name.value=document.forms[0].practitioner_desc.value;
	if (document.forms[0].treatment_area_code.value.length>0 && document.forms[0].priority_value.value !="")
		{
		 document.forms[0].ok.disabled=false;
		}

	if(document.forms[0].practitioner_id.value == '*ALL')
	{
		document.forms[0].practitioner_id.value = "";
		//document.forms[0].practitioner_desc.value = "";	 Thursday, February 04, 2010
	}

	if(clinic_code!="") {
       if(treatment_area_code!="") {
		if(open_to_all_pract_of_treatment_area=='N'){ 
			if(open_to_all_pract_yn=='N'){
                  document.forms[0].pract_for_workDay_check.value ="Y";
			}
		 }
       }
	}
		   
  /*if(clinic_code!="") {
   if(treatment_area_code!="") {
		if(open_to_all_pract_of_treatment_area=='N') { 
		   
		   FirstSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,ae_pract_for_tmt_area_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and b.treatment_area_code = '"+treatment_area_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ORDER BY 2";

  		   SecondSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,ae_pract_for_tmt_area_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and b.treatment_area_code = '"+treatment_area_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ORDER BY 2";		
		} else  if(open_to_all_pract_yn=='Y') {

		    FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
 
			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
		}
			else {

			document.forms[0].pract_for_workDay_check.value ="Y";
			
			FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
			
			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";

			
			}
   }else {  if(open_to_all_pract_yn=='Y') {

	      
   FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
   
   }
			else{
			FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
		
			}
		  }
} else 
        {

        FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123')))";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
		 
		 }
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + escape(practitionerName) + "\""	;
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practitionerValue) + "\"";
	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +escape(speciality_code)+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);	
	responseText=xmlHttp.responseText;   
	responseText = trimString(responseText);
	eval(responseText);	*/

	getPractitioner(obj, target, facility_id, speciality_code,practitioner_type,"Q1",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn);
	//return; 
	
}
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practitioner_id.value=arr[0];
		document.forms[0].practitioner_desc.value=unescape(arr[1]);	
		document.forms[0].prev_pract_name.value=unescape(arr[1]);	
		
	}
	else
	{
		document.forms[0].practitioner_id.value="";
		document.forms[0].practitioner_desc.value="";	
		document.forms[0].prev_pract_name.value="";
		
	}

}

async function populatePractitioners(getVal)
{	
	var	clinic_code			=	document.forms[0].clinic_code.value;
	var practitioner_id		=	document.forms[0].practitioner_id.value;
	var treatment_area_code	=	document.forms[0].treatment_area_code.value;
	var p_desc	=	document.forms[0].practitioner_desc.value;

	if (p_desc==null) p_desc = "";
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
					sql	=	" select practitioner_id , practitioner_name from ae_pract_for_tmt_area_vw where  clinic_code = `"+clinic_code+"` and treatment_area_code = `"+treatment_area_code+"` and eff_status = `E` ";
				}
			}



	var target				= document.forms[0].practitioner_desc;
	var retVal				=    new String();
	var dialogTop			= "40";
	var dialogHeight		= "35vh" ;
	var dialogWidth			= "55vw" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc="";
	var tit="";

	search_code="practitioner_id";
	search_desc="practitioner_name";
	if(p_desc != " ")
	{
		
		p_desc = "practitioner_name";
		search_desc="practitioner_name";
	}

	tit=getLabel("Common.practitioner.label","Common");
	retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
		
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
	practName_FName=target.name;
	practName_FValue=target.value;
	var FirstSql="";
	var SecondSql="";
	var locale=document.forms[0].locale.value;
	var facility_id=document.forms[0].facility_id.value;
    var	clinic_code			=	document.forms[0].clinic_code.value;
	var practitioner_id		=	document.forms[0].practitioner_id.value;
	var treatment_area_code	=	document.forms[0].treatment_area_code.value;
	var p_desc	=	document.forms[0].practitioner_desc.value;
	var practitioner_type   = "";

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
		

       getPractitioner(obj, target, facility_id, spec_code,practitioner_type,"Q1",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn);
/*  if(clinic_code!="") {
   if(treatment_area_code!="") {
		if(open_to_all_prac_for_clinic_yn=='N') { 

		   FirstSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,ae_pract_for_tmt_area_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and b.treatment_area_code = '"+treatment_area_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ORDER BY 2";

  		   SecondSql="select distinct a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,ae_pract_for_tmt_area_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and b.treatment_area_code = '"+treatment_area_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ORDER BY 2";		
		
		
		} else  if(open_to_all_pract_yn=='Y') {

		FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
 
			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
		}
			else {
			document.forms[0].pract_for_workDay_check.value ="Y";
			
			FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
			
			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";

			
			}
   }else {  if(open_to_all_pract_yn=='Y') {
	      
   FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
   
   }
			else{
			FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
		
			}
		  }
} else 
        {
        FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123')))";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ";
		 
		 }
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	= "<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
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
	eval(responseText);	*/
}

/***********************************/
function popTreatmentCode(objVal,from,trmt_code,onChange)
   {
	var isAppearAsTabEnable =document.forms[0].isAppearAsTabEnable.value;//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
	var treatment_area_code="";
	var bed_bay_type="";
	if(from=='waitlist'){								
      treatment_area_code=parent.parent.AEMPSearchCriteriaFrame.document.forms[0].treatment_area_code;
	}
	else{
         treatment_area_code=parent.AEMPSearchCriteriaFrame.document.forms[0].treatment_area_code;
	}
	if(from=='waitlist'){								
	   bed_bay_type=parent.parent.AEMPSearchCriteriaFrame.document.forms[0].bed_bay_type;
	}
	else{
         bed_bay_type=parent.AEMPSearchCriteriaFrame.document.forms[0].bed_bay_type;
	}  
	 if(objVal.value!='')
	   {
		   //Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		//if(isAppearAsTabEnable)
		if(isAppearAsTabEnable==true || isAppearAsTabEnable =="true")
			{
			trmt_code =document.forms[0].treatment_area_code.value;
			var clinic_code=document.forms[0].clinic_code.value;
			var clinic_code2=(onChange=='onChange')?"":document.forms[0].clinic_code2.value;
			//var clinic_code2=document.forms[0].clinic_code2.value;
			//if((clinic_code!=clinic_code2 && clinic_code2!="" && trmt_code!="" ) || (clinic_code!="" && clinic_code2=="") || (clinic_code==clinic_code2 && trmt_code=="" ) )
				if((objVal.value!='' && clinic_code2=="") || (objVal.value!='' && clinic_code2!="" && trmt_code==""))
				//if((objVal.value!='' && clinic_code2=="" && trmt_code=="" ) || (objVal.value!='' && clinic_code2!="" && trmt_code !="") || (objVal.value!='' && clinic_code2!="" && trmt_code==""))
				{
				while(treatment_area_code.options.length > 1)
				treatment_area_code.remove(1);
				while(bed_bay_type.options.length > 1)
				bed_bay_type.remove(1);
				}
					var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form2' id='form2' method='post' action='../../eAE/jsp/AEManagePatGIWaitingList.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='" +objVal.value + "'><input type='hidden' name='isAppearAsTabEnable' id='isAppearAsTabEnable' value='" +isAppearAsTabEnable+ "'><input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+trmt_code+"'><input type='hidden' name='asstrntbays' id='asstrntbays' value='bays'></form></BODY></HTML>";
			if(from=='waitlist'){
			parent.parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.parent.messageFrame.document.form2.submit();
			}else{
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.document.form2.submit();
			}	
			} //Ends
		else {	
			while(treatment_area_code.options.length > 1)
					treatment_area_code.remove(1);
			while(bed_bay_type.options.length > 1)
					bed_bay_type.remove(1);
         
				
		      	var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/AEManagePatGIWaitingList.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='" +objVal.value + "'><input type='hidden' name='isAppearAsTabEnable' id='isAppearAsTabEnable' value='" +isAppearAsTabEnable+ "'><input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+trmt_code+"'><input type='hidden' name='asstrntbays' id='asstrntbays' value='bays'></form></BODY></HTML>";

			if(from=='waitlist'){
			parent.parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.parent.messageFrame.document.form1.submit();
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
			while(bed_bay_type.options.length > 1)
			bed_bay_type.remove(1);
	   }
    
   
   }
   function changeBedBayType(obj)
   {
	var isAppearAsTabEnable =document.forms[0].isAppearAsTabEnable.value;
	if((isAppearAsTabEnable==true || isAppearAsTabEnable =="true") &&(obj.value=="")  )
	{
	document.forms[0].bed_bay_type2.value="true";	
	}
   }
 function popBayType(obj,bed_bay_type2) //Maheshwaran K added -bed_bay_type2 for ML-MMOH-CRF-1973 as on 07-07-2023
   {
	 var bed_bay_type =document.forms[0].bed_bay_type ;
	//Maheshwaran K added  for ML-MMOH-CRF-1973 as on 07-07-2023
	var isAppearAsTabEnable =document.forms[0].isAppearAsTabEnable.value;
	//alert('isAppearAsTabEnable : '+isAppearAsTabEnable);
	//if(isAppearAsTabEnable)
	if(isAppearAsTabEnable==true || isAppearAsTabEnable =="true")
		{
		 if(obj.value==undefined)
			{
			obj=document.forms[0].treatment_area_code;
			}
		}
	//Ends	
	 if(obj.value!='')
	   {
			while(bed_bay_type.options.length > 1)
					bed_bay_type.remove(1);
			var clinic_code = document.forms[0].clinic_code.value;
			var	treatment_area_code = obj.value;
			var bayType ="Y";
			var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/AEManagePatGIWaitingList.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+treatment_area_code+"'><input type='hidden' name='isAppearAsTabEnable' id='isAppearAsTabEnable' value='" +isAppearAsTabEnable+ "'><input type='hidden' name='bayType' id='bayType' value='"+bayType+"'><input type='hidden' name='bed_bay_type' id='bed_bay_type' value='"+bed_bay_type2+"'></form></BODY></HTML>";
    	   	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.document.form1.submit();
	   }
   else
	   {
			while(bed_bay_type.options.length > 1)
			bed_bay_type.remove(1);
	   }
  }
/*function PractLookupRetVal(retVal,objName)
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
	
}*/

/******************************************************/
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
	function showCritical()
	{
    	document.forms[0].current_state.value='Critical';
		document.getElementById('semicritical').style.background='YELLOW';
		document.getElementById('noncritical').style.background='GREEN';
		document.getElementById('unassigned').style.background='ORANGE';
		document.getElementById('others').style.background='NAVY';
    if(document.forms[0].nursing_unit_code.value!="")
		{
		document.getElementById('nurse').style.background='#FFCCCC'
		}		
		document.getElementById('critical').style.background='LIGHTGREY';		
		document.forms[0].priority_zone.value="R";
		showQueryResult();
		document.forms[0].priority_zone.value="";
	}
	function showSemiCritical()
	{		
		document.forms[0].current_state.value='Semi-Critical';
		document.getElementById('critical').style.background='RED';
		document.getElementById('noncritical').style.background='GREEN';
		document.getElementById('unassigned').style.background='ORANGE';
		document.getElementById('others').style.background='NAVY';
    if(document.forms[0].nursing_unit_code.value!="")
		{
		document.getElementById('nurse').style.background='#FFCCCC'
		}		document.getElementById('semicritical').style.background='LIGHTGREY';
		document.forms[0].priority_zone.value="Y";
		showQueryResult();
		document.forms[0].priority_zone.value="";
	}
	function showNonCritical()
	{		
		document.forms[0].current_state.value='Non-Critical';
		document.getElementById('critical').style.background='RED';
		document.getElementById('semicritical').style.background='YELLOW';
		document.getElementById('others').style.background='NAVY';
		document.getElementById('unassigned').style.background='ORANGE';
    if(document.forms[0].nursing_unit_code.value!="")
		{
		document.getElementById('nurse').style.background='#FFCCCC'
		}		document.getElementById('noncritical').style.background='LIGHTGREY';		
		document.forms[0].priority_zone.value="G";
		showQueryResult();
		document.forms[0].priority_zone.value="";
	}
	function showUnassigned()
	{	
		document.forms[0].current_state.value='Unassigned';
		document.getElementById('critical').style.background='RED';		
		document.getElementById('semicritical').style.background='YELLOW';
		document.getElementById('noncritical').style.background='GREEN';
		document.getElementById('others').style.background='NAVY';
    if(document.forms[0].nursing_unit_code.value!="")
		{
		document.getElementById('nurse').style.background='#FFCCCC'
		}		document.getElementById('unassigned').style.background='LIGHTGREY';
		document.forms[0].priority_zone.value="U";
		showQueryResult();
		document.forms[0].priority_zone.value="";
	}
	function showAll(obj)
	{	
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
		/*document.getElementById("critical").style.background='RED';		
		document.getElementById("semicritical").style.background='YELLOW';
		document.getElementById("noncritical").style.background='GREEN';
		document.getElementById("unassigned").style.background='ORANGE';
		*/
		   
		var isPendingForAdmissionAppl	= document.forms[0].isPendingForAdmissionAppl.value;//Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658
		var isForAdmissionAppl	= document.forms[0].isForAdmission.value; //Kamatchi added for ML-MMOH-CRF-1973 as on 07-07-2023
		var priority_zone_all_codes 	= $("#priority_zone_all_codes").val();
		priority_zone_all_codes			= priority_zone_all_codes.slice(0,-1);
		var arr_priority_zone_all_codes	= priority_zone_all_codes.split(","); 
		//Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
		var boldPriorityZoneTab			= document.forms[0].boldPriorityZoneTab.value;
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
		//Starts
		var priority_code=document.forms[0].priority_zone.value;
			if(isForAdmissionAppl == "true" || isForAdmissionAppl == true ) {
		if(obj=='IP_ADM')
			{		
			document.getElementById('enableSubTabForIPAdm').value='Y'	
			}
			else {
			document.getElementById('enableSubTabForIPAdm').value='N'	
			}

		}
		//Ends
		//Modified by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
		$.each(arr_priority_zone_all_codes,function(index,value){
			if(boldPriorityZoneTab == "true"){
				$("#priority_zone_tab_"+value).css('fontWeight', 'normal');}
			else{
			$("#priority_zone_tab_"+value).css('background-color', $("#priority_zone_color_"+value).val());
			}
		});
		if(isForAdmissionAppl == "true" || isForAdmissionAppl == true ) {
		if(obj=='IP_ADM')
			{
		$.each(arr_priority_zone_all_codes,function(index,value){
			if(boldPriorityZoneTab == "true"){
				$("for_priority_zone_tab_"+value).css('fontWeight', 'normal');}
			else{
			$("#for_priority_zone_tab_"+value).css('background-color', $("#priority_zone_color_"+value).val());
		//	$("for_priority_zone_tab_"+value).css('background-color', '#FFFF00');
			}
		});
			}
		}

		////Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	if(document.forms[0].isAppearAsTabEnable.value==true || document.forms[0].isAppearAsTabEnable.value=="true"){
	var treatment_area_all_codes 	= $("#treatment_area_all_codes").val();
	treatment_area_all_codes			= treatment_area_all_codes.slice(0,-1);
	var arr_treatment_area_all_codes	= treatment_area_all_codes.split(",");
	$.each(arr_treatment_area_all_codes,function(index,value){
				 $("#treatment_area_tab_"+value).css('background-color', $("#treatment_tab_color_"+value).val());
	});
	}
		
		//Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
		if(boldPriorityZoneTab == "true") {
			document.getElementById('others').style.fontWeight = "bold";
		}
		else {
				if(isForAdmissionAppl == "true" || isForAdmissionAppl == true ) {
				if(document.getElementById('enableSubTabForIPAdm').value=='N') {
				document.getElementById('others').style.background='LIGHTGREY'; }
				if(document.getElementById('enableSubTabForIPAdm').value=='Y')  {
				document.getElementById('for_others').style.background='LIGHTGREY'; 
				}
				}	
		}
		document.forms[0].current_state.value='All';
      if(document.forms[0].nursing_unit_code.value!="")
	    {
		  if(boldPriorityZoneTab == "true"){    //Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
			document.getElementById('nurse').style.fontWeight = 'normal';
			document.getElementById('nurse').style.background='#FFCCCC'
		  }else{
		document.getElementById('nurse').style.background='#FFCCCC'
		  }
		}
		/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
		if(isPendingForAdmissionAppl == "true")
			document.getElementById('pendingForAdmTab').style.fontWeight = 'normal';
		/*End*/
		 //Kamatchi added for ML-MMOH-CRF-1973 as on 07-07-2023
		if(isForAdmissionAppl == "true" && document.forms[0].enable_admission_tab.value == "Y" && document.forms[0].sel_admission_yn.value == "Y"){
			document.getElementById('pendingForAdmTab').style.fontWeight = 'normal';
	}
	//if(document.forms[0].isAppearAsTabEnable.value==true){
	if(document.forms[0].isAppearAsTabEnable.value==true || document.forms[0].isAppearAsTabEnable.value=="true"){
	if(obj=='TREAT_TAB')
		{		
		document.getElementById('treatmentTabValue').value='Y'	  
		}
		else {
				document.getElementById('treatmentTabValue').value='N'	
		}
		}
		showQueryResult();
		document.forms[0].priority_zone.value="";

 	}

function showAll_observID(){ 
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 05-07-2023
	//if(document.forms[0].isAppearAsTabEnable.value==true)
	if(document.forms[0].isAppearAsTabEnable.value==true || document.forms[0].isAppearAsTabEnable.value=="true")
		{
		document.forms[0].treatment_area_code1.value="";
		document.forms[0].appear_as_tab_yn.value = "";
			}
	var observe_id=document.AEMPSearchCriteriaForm.observe_id.value;	
	  if (document.forms[0].current_state.value=='ALL'){	
			document.getElementById('others').style.background='LIGHTGREY';
		}
     if(document.getElementById('nursing') != null){
		if (document.forms[0].current_state.value=='Nursing_Unit'){
			document.getElementById('nursing').style.background='#FFCCCC';
		}
	}
if(parent.AEMPSearchResultFrame.document.forms[0]){	
	
 /*  if (parent.AEMPSearchResultFrame.document.forms[0].observe_id.value!='' && parent.AEMPSearchResultFrame.document.forms[0].priority_zone.value=="observe" ){
		if (observe_id=='C'){
			showQueryResult('clinic');
		}else if (observe_id=='T'){
			showQueryResult('TreatmentArea');
		}else if (observe_id=='N'){
			showQueryResult('nursing');
		}
	 }else{ 
		showAll();	
	  } */
	  showAll();	
	}else{ 
		showAll();
	  }
	}

/*** Added from AEMPAssignTreatment Area ****/

function enableDateTime(obj)
{
	///if (obj.value.length > 0)
	//{
	//	document.forms[0].assign_tmt_area_time.disabled=false;
	//}	
	//else
	//{
	//	document.forms[0].assign_tmt_area_time.disabled=true;
	//}
}

/*function ChkTime(obj,visit_date_time,assign_tmt_area_time,sys_date_time)
{
	var to_proceed = true;

	if (obj.value.length==14 && (obj.value.substring(13,14)==':'))
	{
		obj.value=obj.value + '00';
	}
	
if (obj.value.length > 0 )
{
if (doDateTimeChk(obj) == true)
{
	if (CheckTime(obj,visit_date_time,assign_tmt_area_time,"TA") )
	{ 
		to_proceed = true;
	}
	else
	{
		to_proceed = false;
	}
	if (to_proceed==true)
	{
		if 	(CheckTime(obj,assign_tmt_area_time,sys_date_time ,"TS")){}
	}
}
else
{
		alert(getMessage("INVALID_DATE_TIME",'SM'));
		obj.select();
		obj.focus();
}
}

}*/
async function callBedAvailChart()
	{
		var retVal	= 	new String();
		var Val		= 	new String();
		var dialogHeight= "70vh" ;
		var dialogWidth	= "90vw" ;
		var dialogTop	= "0vh" ;
		var status		= "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var treatment_area_code = document.forms[0].treatment_area_code.value;
        var treatment_gender	=	treatmentGender[treatment_area_code.selectedIndex];
		var clinic_code = document.forms[0].clinic_code.value;
		var bed_no = trimString(document.forms[0].bed_bay_no.value);
		var patient_id = document.forms[0].patient_id.value;
		var priority_zone = document.forms[0].priority_value.value;
		var url   = "../../eAE/jsp/AEBedAvailabilityChart.jsp?clinic_code="+clinic_code+"&treatment_area="+treatment_area_code+"&bed_no="+bed_no+"&priority_zone="+priority_zone+"&call_function=AssignTrmtArea&bed_status=V&treatment_gender="+treatment_gender;
		retVal = await window.showModalDialog(url,arguments,features);

		if(retVal!=null)
		{
			Val = retVal.split("^");
			document.forms[0].bed_bay_no.value			= Val[0];
			document.forms[0].bed_bay_no.focus();
			if (document.forms[0].treatment_area_code.value.length>0 && document.forms[0].priority_value.value !="" )
		    {
			     document.forms[0].ok.disabled=false;
		    }else
		    	document.forms[0].ok.disabled=true;
			return;
		}
		else 
		{
			document.forms[0].bed_bay_no.value			=	"";
			return;
		}
	}


function BeforeBedAvailChart()
{
	if (document.forms[0].bed_bay_no.value == "")
    {			return;
    }
    else
	{
		callBedAvailChart();
	}
}
function checkForValidBed(bed)
	{
if (document.forms[0].bed_bay_no.value == "")
    {			return;
    
	}else{
		var facility_id			= document.forms[0].facility_id.value;
		var treatment_area = document.forms[0].treatment_area_code.value;
        var clinic = document.forms[0].clinic_code.value;
		var patient_id = document.forms[0].patient_id.value;
		var caInstalled = document.forms[0].strCA.value;
		if (bed != "" && clinic != "" && treatment_area != "")
		{
			
			var HTMLValue	= "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEBedValidGI.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='ManagePatGITreatArea'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='ValidBed'><input type='Hidden' name='field1' id='field1' value='"+treatment_area+"'><input type='Hidden' name='field2' id='field2' value='"+bed+"'><input type='Hidden' name='field3' id='field3' value='"+facility_id+"'><input type='Hidden' name='field4' id='field4' value='"+clinic+"'><input type='Hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='Hidden' name='caInstalled' id='caInstalled' value='"+caInstalled+"'></form></body></html>"
			if( caInstalled=='Y')
            {	
                if( top.messageFrame==null)
			       {
					    top.content.messageFrame.document.insertAdjacentHTML('afterbegin', HTMLValue);
						top.content.messageFrame.document.dummy_form.submit();
			       }
				   else
                   {
			            top.messageFrame.document.insertAdjacentHTML('afterbegin', HTMLValue);
         	            top.messageFrame.document.dummy_form.submit();
			       } 
			 }
            else
            {
            parent.messageFrame.document.insertAdjacentHTML('afterbegin', HTMLValue);
            parent.messageFrame.document.dummy_form.submit();
            }
		}
	}
}

function getValues(obj,fid,cid,gen,ca)
{
	var assvalue=obj.value;
   if(obj.name=='priority_value')
	{
	  var length=document.forms[0].treatment_area_code.length;
	  for(i=1;i<length;i++)
		  document.forms[0].treatment_area_code.remove(1);
	}
    var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'>";
  HTMLVal +="<form name='form1' id='form1' method='post' action='../../eAE/jsp/AEgetValues.jsp'>";
  HTMLVal+="<input name='facility_id' id='facility_id' type='hidden' value='"+fid+"'>";
  HTMLVal+= "<input name='clinic_code' id='clinic_code' type='hidden' value='"+cid+"'>";
  HTMLVal+= "<input name='priority' id='priority' type='hidden' value='"+assvalue+"'>";
  HTMLVal+= "<input name='gender' id='gender' type='hidden' value='"+gen+"'>";
  HTMLVal+= "<input name='ca' id='ca' type='hidden' value='"+ca+"'>";
  HTMLVal +="</form></BODY></HTML>";
  if( ca=="Y")
  {	
	 if( parent.messageFrame!=null)
	   {
		    parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.form1.submit();
	   }
     else
       {
		 var HTML = escape(HTMLVal);
		 setTimeout("SubmitHTML('"+HTML+"');", 500);
       } 
  }
  else
  {
	  if( top.messageFrame==null)
	   {
		 parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		 parent.messageFrame.document.form1.submit();
       }
       else
       {
		 var HTML = escape(HTMLVal);
		 setTimeout("SubmitHTML('"+HTML+"');", 500);
       } 
   }
   }

function SubmitHTML(val)
{
	var HTMLVal = unescape(val);

	top.frames[2].document.insertAdjacentHTML('afterbegin', HTMLVal);
	top.frames[2].document.form1.submit();
}

function disboth()
{
		if (document.forms[0].treatment_area_code.value.length > 0 && document.forms[0].priority_value.value !="")
		{
			document.forms[0].ok.disabled=false;
		}else{
			document.forms[0].ok.disabled=true;
			}
	    document.forms[0].bed_bay_no.disabled = true;
		document.forms[0].bed_button.disabled = true;
		//document.forms[0].practitioner_desc.disabled = true;
		//document.forms[0].pract_button.disabled = true;
}
function clearBed()
{
	document.forms[0].bed_bay_no.value="";
}
function chkboth()
{

	if(document.forms[0].priority_value.value!="")
	{
	if(document.forms[0].treatment_area_code.value!="")
	{
		   document.forms[0].bed_bay_no.disabled = false;
		   document.forms[0].bed_button.disabled = false;
		   document.forms[0].practitioner_desc.disabled = false;
		   document.forms[0].pract_button.disabled = false;
	}
	else
		{
		//document.forms[0].practitioner_desc.value="";
		document.forms[0].bed_bay_no.value="";	
		document.forms[0].bed_bay_no.disabled = true;
		document.forms[0].bed_button.disabled = true;
		document.forms[0].practitioner_desc.disabled = true;
		document.forms[0].pract_button.disabled = true;
		document.forms[0].ok.disabled = true;
		
		}
	}
	else
	{
		document.forms[0].practitioner_desc.value="";
		document.forms[0].bed_bay_no.value="";
		document.forms[0].bed_bay_no.disabled = true;
		document.forms[0].bed_button.disabled = true;
		document.forms[0].practitioner_desc.disabled = true;
		document.forms[0].pract_button.disabled = true;
	}
}

  function setFocusToFirstItem()
	{
		var selection_mode	=	document.forms[0].selection_mode.value;
		if(selection_mode=="AssignReassignPractitioner"){
		   document.forms[0].bed_bay_no.disabled = true;
		   document.forms[0].bed_button.disabled = true;
		}
		if( (selection_mode=="AssignTreatmentArea") || (selection_mode=="ReassignTreatmentArea" ) )
		{
			if(document.forms[0].priority_value){
			}
		}
		else
		{
			//document.forms[0].practitioner_id.focus();
		}
	}

	function callSamepage()
        {              	
			var queue_refresh_interval	= document.forms[0].queue_refresh_interval.value;
			//var queue_refresh_interval	= interval1;
			var include_checkedout=document.forms[0].include_checkedout.value;
			//alert("queue_refresh_interval"+queue_refresh_interval);
			var checkout_yn=document.forms[0].checkout_yn.value;
			self.document.location.href="../../eAE/jsp/AEMPSearchResult.jsp?include_checkedout="+include_checkedout+"&queue_refresh_interval="+queue_refresh_interval+"&checkout_yn="+checkout_yn;
			//self.document.location.href="../../eAE/jsp/AEMPSearchResult.jsp?checkout_yn="+checkout_yn;
			

         }

/*function LoadMenus(patient_id,queue_status,encounter_id,patient_class,practitioner_id)
{
	var query_string    ='';
	query_string		= "patient_id="+patient_id+"&encounter_id="+encounter_id+"&queue_status="+ queue_status+"&patient_class="+patient_class+"&practitioner_id="+practitioner_id;
    
	var xl=event.clientX;
    var yl=100

    var screenH=screen.availHeight
    var screenW=screen.availWidth

    var center=screenW-screenW/2
    xl=center-60
    yl=(screenH/2)-40

    var retVal =    new String();
    var dialogHeight= "10" ;
    var dialogWidth = "11" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;dialogTop="+yl+";dialogLeft:" +xl;
    var arguments   = "" ;
	var action_url		=	"../../eAE/jsp/AEMenuframe.jsp?val=Y&"+query_string;
	retVal				=	window.showModalDialog(action_url,arguments,features);
    if(retVal=="yes")
    {
            setTimeout('callSamepage()',1000);
    }
}
var NumOfFlds   =0 ;
var ref;

function showmenu(lay)
{
    lay.style.visibility='visible'
    	
	if(NumOfFlds==1)
        parent.window.dialogHeight='1'
    if(NumOfFlds==2)
        parent.window.dialogHeight='3'
    if(NumOfFlds==3)
        parent.window.dialogHeight='4'
}

function createMenu(arr,lay)
{
		var inde=lay.all(0).rows.length
        var delval=0
    while(delval!=inde)
    {
        lay.all(0).deleteRow(delval)
        inde=lay.all(0).rows.length
    }

    for (var rowlen=0;rowlen<arr.length;rowlen++)
    {
            lay.all(0).insertRow(rowlen);
            lay.all(0).insertRow(rowlen).style.fontSize=1;
            lay.all(0).rows[rowlen].insertCell(0);
            lay.all(0).rows[rowlen].insertCell(0).innerHTML=arr[rowlen].link("javascript:callMeth('"+arr[rowlen]+"')" )
            NumOfFlds++;
    }
}
function callFunction(s)
{
	  if(s=="Record Vital Signs")
        {
			var param = parameters.split("&p");
			var patient_id = param[1];
			var encounter_id = param[2];
			var patient_class = param[3];
			patient_id = patient_id.substr(2,patient_id.length);
			encounter_id = encounter_id.substr(2,encounter_id.length);
			patient_class= patient_class.substr(2,patient_class.length);
			var retVal =    new String();
			var dialogHeight= "24" ;
			var dialogWidth = "50" ;
			var status = "no";
			var scroll = "no";
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
			var arguments   = "" ;         
			
			var visit_id = "1";
			var eidval ="episode_id="+encounter_id+"&called_from=AE&episode_type=O&visit_id="+visit_id+"&patient_id="+patient_id+"&patient_class="+patient_class+"&module_id=OP";
			retVal = window.showModalDialog("../../eCA/jsp/DisDataCharting.jsp?"+eidval,arguments,features);
        }
		if(s=="Assign Treatment Area" || s=="Patient Chart")
        {
			var param = parameters.split("&p");
			var patient_id = param[1];
			var encounter_id = param[2];
			patient_id = patient_id.substr(2,patient_id.length);
			encounter_id = encounter_id.substr(2,encounter_id.length);
			var HTMLVal  = "<html>";
			HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp' method='post' target='msg' >";
			HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + encounter_id + "'>";
			HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='AE'>";
			HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
			HTMLVal  += "</form>";
			HTMLVal  += "</html>";
		 	parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
			parent.frames[1].document.OpenChartWrapperForm.submit();

		}
}
function callMeth(s)
{
	if(s=="Assign Treatment Area" || s=="Patient Chart")
	{
          callFunction(s)
			
    }else
	{
	      callFunction(s)
		  if(s!="RecordVitalSigns")
           parent.window.returnValue="yes"
           parent.window.close()
	}
}*/
function CAChart(encounter_id,min_age_for_lmp,year_value,patient_id){
			//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
      var loginUser =  document.forms[0].loginUser.value;
			xmlStr = "<root><SEARCH patient_id=\""+patient_id+"\" logged_user=\""+loginUser+"\" action='isPractRestricted' /></root>"
			 var temp_jsp="../../eMP/jsp/MPIntermediate.jsp";
			 var xmlDoc = "" ;
			 var xmlHttp = new XMLHttpRequest() ;
			 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			 xmlHttp.open("POST",temp_jsp,false);
			 xmlHttp.send(xmlDoc);
			 var responseText = xmlHttp.responseText;
			 var response = trimString(xmlHttp.responseText);
			 if(response == "N"){
	       		var HTMLVal  = "<html>";
				HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp'>";
				HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + encounter_id + "'>";
				HTMLVal  += "<input type='hidden' name='min_age_for_lmp' id='min_age_for_lmp' value='" + min_age_for_lmp + "'>";
				HTMLVal  += "<input type='hidden' name='year_value' id='year_value' value='" + year_value + "'>";
				HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='AE'>";
				HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
				HTMLVal  += "</form>";
				HTMLVal  += "</html>";
				//top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	    
				/*top.content.messageFrame.document.write(HTMLVal);
				top.content.messageFrame.document.OpenChartWrapperForm.submit();*/
				top.content.dummyFrame.document.write(HTMLVal);
				top.content.dummyFrame.document.OpenChartWrapperForm.submit();
			 }else{
				 alert(getMessage('ACCESS_RESTRICTED_AUTH_PERSONAL','COMMON'));
			 }
}
async function recordVitalSign(patient_id,queue_status,encounter_id,patient_class,practitioner_id){
            var retVal =    new String();
			var dialogHeight= "90vh" ;
			var dialogWidth = "90vw" ;
			var status = "no";
			var scroll = "no";
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
			var arguments   = "" ;         
			
			var visit_id = "1";
			var eidval ="episode_id="+encounter_id+"&called_from=AE&episode_type=O&visit_id="+visit_id+"&patient_id="+patient_id+"&patient_class="+patient_class+"&module_id=OP";
			retVal = await top.window.showModalDialog("../../eCA/jsp/DisDataCharting.jsp?"+eidval,arguments,features);
			/*Below line was added by Venkatesh.S on 19-Nov-2013 against 45088 */
			window.location.href = window.location.href;

			}

function displayToolTip(patient_id,queue_status,queue_date,encounter_id,brought_dead,patient_class,patient_gender,priority_zone,bed_no,practitioner_id,record_vital_signs_yn,pract_type1,enable_rights_yn,sel_triage_yn,sel_cons_yn,min_age_for_lmp,year_value,allow_chkout_with_bill_stmt_yn,episode_id,treatment_area_code,visit_num,facility_id,action_on_pending_bill,orderctlHDR,image_id,row,link,reg_new_born_yn,inv_reg_new_born_yn,pendngAdmDateTime,sel_admission_yn,sel_cancel_yn,sel_referral_yn,enable_admission_tab,referral_id,assign_bed_cnt)//Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658//sel_admission_yn , sel_cancel_yn , sel_referral_yn , enable_admission_tab Added by Kamatchi S for ML-MMOH-CRF-1972
{    

/* Below  line by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
   callMouseOverOnTD(orderctlHDR,image_id,row,link);
	
	//buildTable(patient_id,queue_status,queue_date,encounter_id,brought_dead,patient_class,patient_gender,priority_zone,bed_no,practitioner_id,record_vital_signs_yn,pract_type1,enable_rights_yn,sel_triage_yn,sel_cons_yn,min_age_for_lmp,year_value,bed_no,allow_chkout_with_bill_stmt_yn,episode_id,treatment_area_code) 
	// Added for MMS-QH-CRF-0126.2
	buildTable(patient_id,queue_status,queue_date,encounter_id,brought_dead,patient_class,patient_gender,priority_zone,bed_no,practitioner_id,record_vital_signs_yn,pract_type1,enable_rights_yn,sel_triage_yn,sel_cons_yn,min_age_for_lmp,year_value,bed_no,allow_chkout_with_bill_stmt_yn,episode_id,treatment_area_code,visit_num,facility_id,action_on_pending_bill,reg_new_born_yn,inv_reg_new_born_yn,pendngAdmDateTime,sel_admission_yn,sel_cancel_yn,sel_referral_yn,enable_admission_tab,referral_id,assign_bed_cnt)//Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658
		
		/* Below  line by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
		 resizeWindow(orderctlHDR,priority_zone);
		
}

function buildTable(patient_id,queue_status,queue_date,encounter_id,brought_dead,patient_class,patient_gender,priority_zone,bed_no,practitioner_id,record_vital_signs_yn,pract_type1,enable_rights_yn,sel_triage_yn,sel_cons_yn,min_age_for_lmp,year_value,bed_no,allow_chkout_with_bill_stmt_yn,episode_id,treatment_area_code,visit_num,facility_id,action_on_pending_bill,reg_new_born_yn,inv_reg_new_born_yn,pendngAdmDateTime,sel_admission_yn,sel_cancel_yn,sel_referral_yn,enable_admission_tab,referral_id,assign_bed_cnt)//Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658
{ 
  /* Below  lines by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
		/*var assignVal = "N";
		if(document.forms[0].isForAdmission.value == true || document.forms[0].isForAdmission.value == "true"){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patient_id=\""+patient_id+"\" action=\"IPEncPatChk\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eAE/jsp/AEIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		var responseText=xmlHttp.responseText
		var adt_status = "";
		var ipEncVal = 0;
		if(responseText!=""){
					var retVal_arr = responseText.split("@#");
					for(var i=0;i<retVal_arr.length-1;i++){
						var code_desc_arr = retVal_arr[i].split("|~|");
						 adt_status 	= trimString(code_desc_arr[0]);
						 ipEncVal 	= trimString(code_desc_arr[1]) ;
						 assign_bed_num = trimString(code_desc_arr[2]) ;
						if(assign_bed_num == null || assign_bed_num == "null") assign_bed_num = "";
					}
				}
		//var ipEncData = trimString(responseText)
		//var arr = new Array(ipEncData);
		
		}*/
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"

		if(enable_rights_yn=="N"){
			/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
			if(document.forms[0].isPracApplicable.value=="true"){
			if(queue_status==("04")){
			
		if(record_vital_signs_yn=='Y' || ((treatment_area_code!='' && reg_new_born_yn =="Y" && patient_gender=="F" && inv_reg_new_born_yn =="Y"))){
		 tab_dat     += "<tr>";
		  //tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
	     tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"', '"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
		 tab_dat     += "</tr>";
		}else{

		CAChart(encounter_id,min_age_for_lmp,year_value,patient_id);
		}
		}else{
		if(record_vital_signs_yn=='Y'){
			if(treatment_area_code!=''){
				tab_dat     += "<tr>";
				//tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";	
				// Added for MMS-QH-CRF-0126.2
				tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";
				
				tab_dat     += "</tr>";
			}else{

				tab_dat     += "<tr>";
				
				//tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";
				// Added for MMS-QH-CRF-0126.2
				tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";
				tab_dat     += "</tr>";
			}
		}else{
			//NEWCAChart(encounter_id);
			// Added for MMS-QH-CRF-0126.2
		NEWCAChart(encounter_id,visit_num,facility_id,action_on_pending_bill,patient_id,episode_id);
		}
		}
			
			}/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/ else {
		if(practitioner_id!=("*ALL")){
			/*Added by Thamizh selvi on 12th Oct 2017 for ML-MMOH-CRF-0623 Start*/
 			if(document.forms[0].isStartConsultationAppl.value=="true"){
				if(record_vital_signs_yn=='Y' || ((treatment_area_code!='' && reg_new_born_yn =="Y" && patient_gender=="F" && inv_reg_new_born_yn =="Y"))){
					if(queue_status!=("04")){
						tab_dat     += "<tr>";
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:openStartConsultation('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.StartConsult.label","Common")+"</a></td>";	
						tab_dat     += "</tr>";
					}
					tab_dat     += "<tr>";
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
					tab_dat     += "</tr>";
					/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
					if(document.forms[0].isPendingForAdmissionAppl.value == "true"){
						if(queue_status == "04" && pendngAdmDateTime == ""){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:pendingForAdmission('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.for.label","Common")+" "+getLabel("Common.admission.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
						}
					}/*End*/
					if(document.forms[0].isForAdmission.value == "true"){
						
						if(queue_status == "04" && pendngAdmDateTime == "" && assign_bed_cnt == 0 && document.forms[0].enable_admission_tab.value == "Y" && document.forms[0].sel_admission_yn.value == "Y" ){
							//if(ipEncVal == 0){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:checkForAdmissionReferral('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.for.label","Common")+" "+getLabel("Common.admission.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
						//}
						}
					}/*End*/
					var enableSubTabForIPAdm=document.forms[0].enableSubTabForIPAdm.value;
					if(document.forms[0].isForAdmission.value == "true" && enableSubTabForIPAdm == 'Y'){
						if(queue_status == "04" && pendngAdmDateTime != "" && document.forms[0].sel_referral_yn.value == "Y" && referral_id != 0){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:ModifyForAdmissionReferral('"+patient_id+"','"+encounter_id+"')>"+getLabel("eAE.ModifyReferral.label","AE")+"</a></td>";	
							tab_dat     += "</tr>";
						}
					}
					if(document.forms[0].isForAdmission.value == "true" && enableSubTabForIPAdm == 'Y'){
						if(queue_status == "04" && pendngAdmDateTime  != "" && document.forms[0].sel_cancel_yn.value == "Y"  && (referral_id != 0 || referral_id == 0 )){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CancelForAdmission('"+patient_id+"','"+encounter_id+"')>"+getLabel("eIP.CancelForAdmission.label","IP")+"</a></td>";	
							tab_dat     += "</tr>";
						}
					}
				}else{
					if(queue_status!=("04")){
						tab_dat     += "<tr>";
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:openStartConsultation('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.StartConsult.label","Common")+"</a></td>";	
						tab_dat     += "</tr>";
						tab_dat     += "<tr>";
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
						tab_dat     += "</tr>";
					}else{
						/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
						if(document.forms[0].isPendingForAdmissionAppl.value == "true"){
						if(document.forms[0].isPendingForAdmissionAppl.value == "true"  && pendngAdmDateTime == ""){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:pendingForAdmission('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.for.label","Common")+" "+getLabel("Common.admission.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
						}
						else{/*End*/
							CAChart(encounter_id,min_age_for_lmp,year_value,patient_id);
						}
						}

					if(document.forms[0].isForAdmission.value == "true"){
						if(queue_status == "04" && pendngAdmDateTime == "" && assign_bed_cnt == 0 && document.forms[0].enable_admission_tab.value == "Y" && document.forms[0].sel_admission_yn.value == "Y" ){
							//if(ipEncVal == 0){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:checkForAdmissionReferral('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.for.label","Common")+" "+getLabel("Common.admission.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
						//}
						}
						else{/*End*/
						var enableSubTabForIPAdm=document.forms[0].enableSubTabForIPAdm.value;
						if(enableSubTabForIPAdm == 'N')
							CAChart(encounter_id,min_age_for_lmp,year_value,patient_id);
						}
						var enableSubTabForIPAdm=document.forms[0].enableSubTabForIPAdm.value;
						if(queue_status == "04" && pendngAdmDateTime != "" && document.forms[0].sel_referral_yn.value == "Y" && referral_id != 0 && enableSubTabForIPAdm == 'Y'){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:ModifyForAdmissionReferral('"+patient_id+"','"+encounter_id+"')>"+getLabel("eAE.ModifyReferral.label","AE")+"</a></td>";	
							tab_dat     += "</tr>";
						}
						if(queue_status == "04" && pendngAdmDateTime  != "" && document.forms[0].sel_cancel_yn.value == "Y"  && (referral_id != 0 || referral_id == 0 ) && enableSubTabForIPAdm == 'Y'){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CancelForAdmission('"+patient_id+"','"+encounter_id+"')>"+getLabel("eIP.CancelForAdmission.label","IP")+"</a></td>";	
							tab_dat     += "</tr>";
						}
					}
					
					}
				}
			}else{/*End*/
				if(record_vital_signs_yn=='Y' || ((treatment_area_code!='' && reg_new_born_yn =="Y" && patient_gender=="F" && inv_reg_new_born_yn =="Y"))){
				 tab_dat     += "<tr>";
				  //tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
				 tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
				 tab_dat     += "</tr>";
				}else{
				CAChart(encounter_id,min_age_for_lmp,year_value,patient_id);
				}
			}
		}else{
		if(record_vital_signs_yn=='Y'){
			if(treatment_area_code!=''){
				tab_dat     += "<tr>";
				//tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";	
				// Added for MMS-QH-CRF-0126.2
				tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";
				
				tab_dat     += "</tr>";
			}else{

				tab_dat     += "<tr>";
				
				//tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";
				// Added for MMS-QH-CRF-0126.2
				tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";
				tab_dat     += "</tr>";
			}
		}else{
			//NEWCAChart(encounter_id);
			// Added for MMS-QH-CRF-0126.2
		NEWCAChart(encounter_id,visit_num,facility_id,action_on_pending_bill,patient_id,episode_id);
		}
		} }
	}else{
		if(sel_triage_yn=='N' && sel_cons_yn=='N'){

		if(record_vital_signs_yn=='Y'){
          if(treatment_area_code!=''){
			tab_dat     += "<tr>";
			//tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";	
			// Added for MMS-QH-CRF-0126.2
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";	
			tab_dat     += "</tr>";

		}else{
		   	tab_dat     += "<tr>";
			//tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";	
			// Added for MMS-QH-CRF-0126.2
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";	
			tab_dat     += "</tr>";

		}
				}else{
					//NEWCAChart(encounter_id);
					// Added for MMS-QH-CRF-0126.2
					NEWCAChart(encounter_id,visit_num,facility_id,action_on_pending_bill,patient_id,episode_id);
		}
		}
		
		else if(sel_triage_yn=='Y' && sel_cons_yn=='N'){
		
         if(treatment_area_code!=''){
			assignVal = "Y";
			tab_dat     += "<tr>";
			//tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";	
			// Added for MMS-QH-CRF-0126.2
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";	
			tab_dat     += "</tr>";
			tab_dat     += "<tr>";
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:call_sec_triage('"+patient_id+"','"+encounter_id+"','"+queue_date+"','"+brought_dead+"','"+patient_gender+"','"+priority_zone+"','"+min_age_for_lmp+"','"+year_value+"','"+assignVal+"')>"+getLabel("eAE.SecondaryTriage.label","AE")+"</a></td>";
			tab_dat     += "</tr>";
		 }else{
			assignVal = "Y";
		 	tab_dat     += "<tr>";
			//tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";	
			// Added for MMS-QH-CRF-0126.2
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";	
			tab_dat     += "</tr>";
			tab_dat     += "<tr>";
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:call_sec_triage('"+patient_id+"','"+encounter_id+"','"+queue_date+"','"+brought_dead+"','"+patient_gender+"','"+priority_zone+"','"+min_age_for_lmp+"','"+year_value+"','"+assignVal+"')>"+getLabel("eAE.SecondaryTriage.label","AE")+"</a></td>";
			tab_dat     += "</tr>";
		 
		 }	
		}
		
		else if(sel_triage_yn=='Y' && sel_cons_yn=='Y'){
					
			if(document.forms[0].isPracApplicable.value=="true"){ /*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
			if(queue_status==("04")){
						
			if(record_vital_signs_yn=='Y' || ((treatment_area_code!='' && reg_new_born_yn =="Y" && patient_gender=="F" && inv_reg_new_born_yn =="Y"))){
			 tab_dat     += "<tr>";
			 tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
			 tab_dat     += "</tr>";
		}else{
		CAChart(encounter_id,min_age_for_lmp,year_value,patient_id);
		}
		}else{
		    if(treatment_area_code!=''){    
				assignVal = "Y";
				 tab_dat     += "<tr>";
				// tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";	
				// Added for MMS-QH-CRF-0126.2
				 tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";	
				 tab_dat     += "</tr>";
				 tab_dat     += "<tr>";
				 tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:call_sec_triage('"+patient_id+"','"+encounter_id+"','"+queue_date+"','"+brought_dead+"','"+patient_gender+"','"+priority_zone+"','"+min_age_for_lmp+"','"+year_value+"','"+assignVal+"')>"+getLabel("eAE.SecondaryTriage.label","AE")+"</a></td>";
				 tab_dat     += "</tr>";
				 tab_dat     += "<tr>";
			 
		    }else{
				assignVal = "Y";
				 tab_dat     += "<tr>";
				 //tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";	
				// Added for MMS-QH-CRF-0126.2
				 tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";	
				 tab_dat     += "</tr>";
				 tab_dat     += "<tr>";
				 tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:call_sec_triage('"+patient_id+"','"+encounter_id+"','"+queue_date+"','"+brought_dead+"','"+patient_gender+"','"+priority_zone+"','"+min_age_for_lmp+"','"+year_value+"','"+assignVal+"')>"+getLabel("eAE.SecondaryTriage.label","AE")+"</a></td>";
				 tab_dat     += "</tr>";
		     }
			}
			/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
			}else{
		if(practitioner_id!=("*ALL"))
		{	
			/*Added by Thamizh selvi on 12th Oct 2017 for ML-MMOH-CRF-0623 Start*/
 			if(document.forms[0].isStartConsultationAppl.value=="true"){
				if(record_vital_signs_yn=='Y' || ((treatment_area_code!='' && reg_new_born_yn =="Y" && patient_gender=="F" && inv_reg_new_born_yn =="Y"))){
					if(queue_status!=("04")){
						tab_dat     += "<tr>";
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:openStartConsultation('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.StartConsult.label","Common")+"</a></td>";	
						tab_dat     += "</tr>";
					}
					tab_dat     += "<tr>";
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
					tab_dat     += "</tr>";
					/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
					if(document.forms[0].isPendingForAdmissionAppl.value == "true"){
						if(queue_status == "04"  && pendngAdmDateTime == ""){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:pendingForAdmission('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.for.label","Common")+" "+getLabel("Common.admission.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
						}
					}/*End*/
					//Kamatchi added for ML-MMOH-CRF-1973 as on 07-07-2023
					if(document.forms[0].isForAdmission.value == "true"){
						
						if(queue_status == "04" && pendngAdmDateTime == "" && assign_bed_cnt == 0 && document.forms[0].enable_admission_tab.value=="Y" && document.forms[0].sel_admission_yn.value=="Y" ){
							//if(ipEncVal == 0){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:checkForAdmissionReferral('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.for.label","Common")+" "+getLabel("Common.admission.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
						//}
						}
					}
					var enableSubTabForIPAdm=document.forms[0].enableSubTabForIPAdm.value;
					if(document.forms[0].isForAdmission.value == "true" && enableSubTabForIPAdm == 'Y'){
						if(queue_status == "04" && pendngAdmDateTime != "" && document.forms[0].sel_referral_yn.value == "Y" && referral_id != 0){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:ModifyForAdmissionReferral('"+patient_id+"','"+encounter_id+"')>"+getLabel("eAE.ModifyReferral.label","AE")+"</a></td>";	
							tab_dat     += "</tr>";
						}
					}
					if(document.forms[0].isForAdmission.value == "true" && enableSubTabForIPAdm == 'Y'){
						if(queue_status == "04" && pendngAdmDateTime  != "" && document.forms[0].sel_cancel_yn.value == "Y"  && (referral_id != 0 || referral_id == 0 )){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CancelForAdmission('"+patient_id+"','"+encounter_id+"')>"+getLabel("eIP.CancelForAdmission.label","IP")+"</a></td>";	
							tab_dat     += "</tr>";
						}
					}/*End*/
				}else{
					if(queue_status!=("04")){
						tab_dat     += "<tr>";
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:openStartConsultation('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.StartConsult.label","Common")+"</a></td>";	
						tab_dat     += "</tr>";
						tab_dat     += "<tr>";
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
						tab_dat     += "</tr>";
					}else{
						/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
						if(document.forms[0].isPendingForAdmissionAppl.value == "true"){
						if(document.forms[0].isPendingForAdmissionAppl.value == "true" && pendngAdmDateTime == ""){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:pendingForAdmission('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.for.label","Common")+" "+getLabel("Common.admission.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
						}//Added by Kamatchi S for ML-MMOH-CRF-1972
						else{/*End*/
							CAChart(encounter_id,min_age_for_lmp,year_value,patient_id);
						}
						}
						if(document.forms[0].isForAdmission.value == "true"){
						if(queue_status == "04"  && pendngAdmDateTime == "" && assign_bed_cnt == 0 && document.forms[0].enable_admission_tab.value == "Y" && document.forms[0].sel_admission_yn.value == "Y" ){
						
							//if(ipEncVal == 0){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:checkForAdmissionReferral('"+patient_id+"','"+encounter_id+"')>"+getLabel("Common.for.label","Common")+" "+getLabel("Common.admission.label","Common")+"</a></td>";	
							tab_dat     += "</tr>";
						//}
						}
						else{/*End*/
						
						var enableSubTabForIPAdm=document.forms[0].enableSubTabForIPAdm.value;
						if(enableSubTabForIPAdm == 'N')
							CAChart(encounter_id,min_age_for_lmp,year_value,patient_id);
						}
						
						var enableSubTabForIPAdm=document.forms[0].enableSubTabForIPAdm.value;
						if(queue_status == "04" && pendngAdmDateTime != "" && document.forms[0].sel_referral_yn.value == "Y" && referral_id != 0 && enableSubTabForIPAdm == 'Y'){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:ModifyForAdmissionReferral('"+patient_id+"','"+encounter_id+"')>"+getLabel("eAE.ModifyReferral.label","AE")+"</a></td>";	
							tab_dat     += "</tr>";
						}
						if(queue_status == "04" && pendngAdmDateTime  != "" && document.forms[0].sel_cancel_yn.value == "Y" && (referral_id != 0 || referral_id == 0 ) && enableSubTabForIPAdm == 'Y'){
							tab_dat     += "<tr>";
							tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CancelForAdmission('"+patient_id+"','"+encounter_id+"')>"+getLabel("eIP.CancelForAdmission.label","IP")+"</a></td>";	
							tab_dat     += "</tr>";
						}
						}
					}
				}
			}else{/*End*/
				if(record_vital_signs_yn=='Y' || ((treatment_area_code!='' && reg_new_born_yn =="Y" && patient_gender=="F" && inv_reg_new_born_yn =="Y"))){
					tab_dat     += "<tr>";
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CAChart('"+encounter_id+"','"+min_age_for_lmp+"','"+year_value+"','"+patient_id+"')>"+getLabel("Common.patientchart.label","Common")+"</a></td>";	
					tab_dat     += "</tr>";
				}else{
					CAChart(encounter_id,min_age_for_lmp,year_value,patient_id);
				}
			}
		}else{
		    if(treatment_area_code!=''){    
				assignVal = "Y";
				 tab_dat     += "<tr>";
				// tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";	
				// Added for MMS-QH-CRF-0126.2
				 tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.ReassignTreatArea.label","AE")+"</a></td>";	
				 tab_dat     += "</tr>";
				 tab_dat     += "<tr>";
				 tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:call_sec_triage('"+patient_id+"','"+encounter_id+"','"+queue_date+"','"+brought_dead+"','"+patient_gender+"','"+priority_zone+"','"+min_age_for_lmp+"','"+year_value+"','"+assignVal+"')>"+getLabel("eAE.SecondaryTriage.label","AE")+"</a></td>";
				 tab_dat     += "</tr>";
				 tab_dat     += "<tr>";
			 
		    }else{
				assignVal = "Y";
				 tab_dat     += "<tr>";
				 //tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";	
				// Added for MMS-QH-CRF-0126.2
				 tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:NEWCAChart('"+encounter_id+"','"+visit_num+"','"+facility_id+"','"+action_on_pending_bill+"','"+patient_id+"','"+episode_id+"')>"+getLabel("eAE.AssignTreatArea.label","AE")+"</a></td>";	
				 tab_dat     += "</tr>";
				 tab_dat     += "<tr>";
				 tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:call_sec_triage('"+patient_id+"','"+encounter_id+"','"+queue_date+"','"+brought_dead+"','"+patient_gender+"','"+priority_zone+"','"+min_age_for_lmp+"','"+year_value+"','"+assignVal+"')>"+getLabel("eAE.SecondaryTriage.label","AE")+"</a></td>";
				 tab_dat     += "</tr>";
		     }
			} } /*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
		 }
	}
	if(record_vital_signs_yn=='Y'){
	tab_dat     += "<tr>";
	tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:recordVitalSign('"+patient_id+"','"+queue_status+"','"+encounter_id+"','"+patient_class+"','"+practitioner_id+"')>"+getLabel("eOP.recordvitalsigns.label","OP")+"</a></td>";		
	tab_dat     += "</tr>";
	}
	/*Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
	if(treatment_area_code!='' && reg_new_born_yn =="Y" && patient_gender=="F" && inv_reg_new_born_yn =="Y"){
		tab_dat     += "<tr>";
		tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:fnCallRegNewBornForAE('"+patient_id+"')>"+getLabel("eAE.RegisterNewBornForAE.label","AE")+"</a></td>";		
		tab_dat     += "</tr>";
	}
	/*Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/


	tab_dat     += "</table>";
	document.getElementById('t').innerHTML = tab_dat;
	
}

function callMouseOver(obj)
{  
	currClass = obj.className ;
	/* Below line modified by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
	obj.className = 'selectedcontextMenuItem';
}

function callOnMouseOut(obj)
{
	obj.className = 'contextMenuItem';
}


function checkStatus(queue_status,strCA)
{
	if (strCA=='Y')
	{
		if (parseInt(queue_status)>='07')
		{
			alert(getMessage("AE_CHECKED_OUT",'AE'));
			top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';
		}
	}

}

async function call_sec_triage(patient_id,encounter_id,queue_date,brought_dead,patient_gender,priority_zone,min_age_for_lmp,year_value,assignVal){

	var queryString="patient_id="+patient_id+"&encounter_id="+encounter_id+"&queue_date="+queue_date+"&brought_dead="+brought_dead+"&patient_gender="+patient_gender+"&priority_zone="+priority_zone+"&min_age_for_lmp="+min_age_for_lmp+"&year_value="+year_value+"&function_id=SEC_TRIAGE";

	var retVal = "";

	var dialogHeight= "95vh" ;
	var dialogWidth	= "95vw" ;
	var dialogTop   = "20" ;
	var status      = "no" ;
	var arguments	= " "  ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
	
	retVal = await top.window.showModalDialog("../../eAE/jsp/AETriageFrameset.jsp?selection_mode="+retVal+"&page_name=CurrentEmergencyPatients&"+queryString,arguments,features);

	if(retVal!=null){
	var rvalues=retVal.split('&');
	var encounter_id=rvalues[0];
	var practitioner_id=rvalues[1];
	var enable_rights_yn=rvalues[2];
	var sel_triage_yn=rvalues[3];
	var sel_cons_yn=rvalues[4];

	//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081
	var allowfurther = "Y";
	var method_name ="Queue_Status"
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH" ;
	xmlStr += " method_name=\"" + method_name + "\""	;
	xmlStr += " encounter_id=\"" +encounter_id+ "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eIP/jsp/IPintermediate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	var queue_status  = trimString(responseText);
	if((document.forms[0].isPracApplicable.value =='true')&&(queue_status!="04" )){
		allowfurther ="N"
	}//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081
	 
		if(sel_cons_yn=="Y" &&(practitioner_id=='' || practitioner_id!="*ALL")&&(allowfurther=="Y")) { 
			CAChart(encounter_id,min_age_for_lmp,year_value,patient_id)
		} else {
		 window.location.href = window.location.href;
			//window.location.reload(true);Modified by Munisekhar for IN43904
		}
	} else {
	
	 window.location.href = window.location.href;
		//window.location.reload(true); Modified by Munisekhar for IN43904
	}
	var isForAdmission	=	document.forms[0].isForAdmission.value;
	if((isForAdmission==true || isForAdmission =="true") && assignVal == "Y") {
	reloadCriteria();
	}
}
/*
function NEWCAChart(encounter_id)
	{
var features   = 'dialogHeight:21; dialogWidth:200; dialogTop:150; status=no';
var arguments  = '';
var retVal = window.showModalDialog('../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode=AssignTreatmentArea&' + query_string ,arguments,features);


if(retVal!=null){
var rvalues=retVal.split('&')
var patient_id=rvalues[0];
var encounter_id=rvalues[1];
var queue_date=rvalues[2];
var brought_dead=rvalues[3];
var patient_gender=rvalues[4];
var priority_zone=rvalues[5];
var min_age_for_lmp=rvalues[6];
var year_value=rvalues[7];
var enable_rights_yn=rvalues[8];
var sel_triage_yn=rvalues[9];
var sel_cons_yn=rvalues[10];
if(sel_triage_yn=="Y"){
call_sec_triage(patient_id,encounter_id,queue_date,brought_dead,patient_gender,priority_zone,min_age_for_lmp,year_value)
}
}else{
 window.location.href = window.location.href;
 //window.location.reload(); Modified by Munisekhar for IN43904
}

}*/

async function ShowRemarks(name,remarkstype,encounter_id) 
	 {
		var comments;
		var inputArr = document.getElementsByTagName("input");
		for (u=0;u<inputArr.length;u++)
		{
			if (inputArr[u].name == name)
			{
				comments = inputArr[u].value;
			}
		}
	var retVal;	
	var isDisplayAllRemarks = document.forms[0].isDisplayAllRemarks.value;
	//Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641
	if (isDisplayAllRemarks=="true")
	{
	var dialogHeight ='40vh' ;
	var dialogWidth = '40vw' ;
	}
	else{
	var dialogHeight ='40vh' ;
	var dialogWidth = '40vw' ;
	}
	//var dialogHeight ='12' ;
	//var dialogWidth = '25' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments;
 	arguments = comments;
	retVal = await window.showModalDialog('../../eAE/jsp/AEDisaterRemarks.jsp?RemarksValue='+comments+'&RemarksType='+remarkstype+'&isDisplayAllRemarks='+isDisplayAllRemarks+'&encounter_id='+encounter_id,arguments,features);
	if(retVal == null) retVal="";
}

function showNursingUnit()
	{
		document.forms[0].current_state.value='Nursing_Unit';
		var from;
		var observe_id;
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
		/*document.getElementById("critical").style.background='RED';		
		document.getElementById("semicritical").style.background='YELLOW';
		document.getElementById("noncritical").style.background='GREEN';
		document.getElementById("unassigned").style.background='ORANGE';
		*/
		var priority_zone_all_codes 	= $("#priority_zone_all_codes").val();
		priority_zone_all_codes			= priority_zone_all_codes.slice(0,-1);
		var arr_priority_zone_all_codes	= priority_zone_all_codes.split(","); 
		//Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
		var boldPriorityZoneTab			= document.forms[0].boldPriorityZoneTab.value;
		
		var isPendingForAdmissionAppl	= document.forms[0].isPendingForAdmissionAppl.value;//Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658
		var isForAdmissionAppl	= document.forms[0].isForAdmission.value;//Kamatchi added for ML-MMOH-CRF-1973 as on 07-07-2023
		if(isForAdmissionAppl == "true" || isForAdmissionAppl == true) {
		document.getElementById('enableSubTabForIPAdm').value="N";		
		}
		//Modified by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
		$.each(arr_priority_zone_all_codes,function(index,value){
			if(boldPriorityZoneTab == "true")
				$("#priority_zone_tab_"+value).css('fontWeight', 'normal');
			else {
			$("#priority_zone_tab_"+value).css('background-color', $("#priority_zone_color_"+value).val());
		if(isForAdmissionAppl == "true" || isForAdmissionAppl == true) {
			document.getElementById('for_others').style.background='NAVY';
			document.getElementById('ForIPAdmissionTab').style.visibility='hidden';
		}
			}
		});
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
		//Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
		if(boldPriorityZoneTab == "true")
			document.getElementById('others').style.fontWeight = "normal";
		else
		document.getElementById('others').style.background='NAVY';
		//Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
		if(boldPriorityZoneTab == "true")
			document.getElementById('nurse').style.fontWeight = "bold";
		else
			document.getElementById('nurse').style.background='LIGHTGREY';
		
		/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
		if(isPendingForAdmissionAppl == "true")
			document.getElementById('pendingForAdmTab').style.fontWeight = 'normal';
		/*End*/
		//Kamatchi added for ML-MMOH-CRF-1973 as on 07-07-2023
		if(isForAdmissionAppl == "true" && document.forms[0].enable_admission_tab.value == "Y" && document.forms[0].sel_admission_yn.value == "Y"){
			document.getElementById('pendingForAdmTab').style.fontWeight = 'normal';
		}

		observe_id=document.forms[0].observe_id.value;

	  if (observe_id=='N')
       {
		   from="nursing";
       }
	   if (observe_id=='C')
       {
		   from="clinic";
       }
	   else if (observe_id=='T')
	   {
		   from="TreatmentArea";
	   }
		if(document.getElementById('nursing') != null)
		document.getElementById('nurse').style.background='LIGHTGREY';
		showQueryResult(from);
		
		
		if(document.AEMPSearchCriteriaForm.isLengthOfStayAppl.value=="true") // added by mujafar for ML-MMOH-CRF-1194
	{		document.forms[0].priority_zone.value="observe";
			showQueryResult(from);
			document.forms[0].priority_zone.value="";
	}
	else
	{
		showQueryResult(from);}
		
	}


	function showCAChart(encounter_id)
	{
					var HTMLVal  = "<html>";
					HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp'>";
					HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + encounter_id + "'>";
					HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='AE'>";
					HTMLVal  += "<input type='hidden' name='patient_class' id='patient_class' value='EM'>";
					HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
					HTMLVal  += "</form>";
					HTMLVal  += "</html>";
					
										
					top.content.dummyFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);		
					top.content.dummyFrame.document.OpenChartWrapperForm.submit();
					/*top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);		
					top.content.messageFrame.document.OpenChartWrapperForm.submit();*/
	}


function showQueryResult2(from)

{
	if(from=='waitlist'){
       //document.forms[0].from.value="";
		//document.forms[0].to.value="";
		var ch_x='';
		var final_String='';
		var rows_id	=	document.forms[0].finalString.value;

		var from1	=	document.forms[0].from.value;
		var to1	=	    document.forms[0].to.value;
		var max	=	    document.forms[0].maxRecord.value;	
		var rows= rows_id.split(",");
		for(i=0;i<rows.length;i++)
		{ 
		final_String+=trimString(rows[i])+"','"; 
		}
		parent.AEMPSearchCriteriaFrame.document.forms[0].from.value=from1;
		parent.AEMPSearchCriteriaFrame.document.forms[0].to.value=to1;
		parent.AEMPSearchCriteriaFrame.document.forms[0].maxRcd.value=max;
		var maxRcd = parent.AEMPSearchCriteriaFrame.document.forms[0].maxRcd.value;
		var from = 	parent.AEMPSearchCriteriaFrame.document.forms[0].from.value
		var to   =  parent.AEMPSearchCriteriaFrame.document.forms[0].to.value

		parent.AEMPSearchCriteriaFrame.document.forms[0].ch_x.value=final_String;
		ch_x =parent.AEMPSearchCriteriaFrame.document.forms[0].ch_x.value;
		//Below line commented by senthil
		//parent.AEMPSearchCriteriaFrame.document.forms[0].ch_id.value='Y';
		var	ch_id=parent.AEMPSearchCriteriaFrame.document.forms[0].ch_id.value;

		var clinic_code		=	parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_code;
		var clinic_type		=	parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_type;
		var gender			=	document.forms[0].gender;
		var patient_gender	=	document.forms[0].patient_gender;

		parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_type.value			=	parent.AEMPSearchCriteriaFrame.clinicType[clinic_code.selectedIndex];

		var fields = new Array (parent.AEMPSearchCriteriaFrame.document.forms[0].patient_id);
		var names = new Array (getLabel("Common.patientId.label","Common"));	
		var error_jsp="../../eCommon/jsp/error.jsp";
		var messageFrame="";
		document.forms[0].target	=	"AEMPSearchResultFrame";
		var oper_stn_id=parent.AEMPSearchCriteriaFrame.document.forms[0].oper_stn_id.value;
		var checkout_yn=parent.AEMPSearchCriteriaFrame.document.forms[0].checkout_yn.value;
		var sys_date=parent.AEMPSearchCriteriaFrame.document.forms[0].sys_date.value;
		var p_cutoff_hours_prv_day_visit=parent.AEMPSearchCriteriaFrame.document.forms[0].p_cutoff_hours_prv_day_visit.value;	
		var clinic_code=parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_code.value;
		var treatment_area_code=parent.AEMPSearchCriteriaFrame.document.forms[0].treatment_area_code.value;
		var practitioner_id=parent.AEMPSearchCriteriaFrame.document.forms[0].practitioner_id.value; 
		var patient_id=parent.AEMPSearchCriteriaFrame.document.forms[0].patient_id.value;
        var priority="";
        var priority_zone=parent.AEMPSearchCriteriaFrame.document.forms[0].priority_zone.value;
		var bed_bay_type=parent.AEMPSearchCriteriaFrame.document.forms[0].bed_bay_type.value; 
		var function_id=parent.AEMPSearchCriteriaFrame.document.forms[0].function_id.value;
		var max=AEMPSearchResultForm.maxRecord.value;		
		parent.AEMPSearchCriteriaFrame.document.forms[0].action	=	"../../eAE/jsp/AEMPSearchResult.jsp?from="+from+"&maxRcd="+maxRcd+"&to="+to+"&ch_x="+ch_x+"&ch_id="+ch_id+"&oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&bed_bay_type="+bed_bay_type+"&function_id="+function_id;
		
		parent.AEMPSearchCriteriaFrame.document.forms[0].method	=	"GET";				
				if(SpecialCharCheck(fields,names,parent.parent.messageFrame,"M",error_jsp)){
						parent.AEMPSearchCriteriaFrame.document.forms[0].submit();
					}
	}
	else if (from=='nursing')
	{
	
		    var gender			=	document.forms[0].gender.value;
			var observe_id		= parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.observe_id.value;
			var patient_id=parent.AEMPSearchCriteriaFrame.document.forms[0].patient_id.value;
			var nursing_unit_code		=	document.forms[0].nursing_unit_code.value;
		    var oper_stn_id=document.forms[0].oper_stn_id.value;
			var error_jsp="../../eCommon/jsp/error.jsp";
		    var messageFrame="";

			document.forms[0].action	=	"../../eAE/jsp/AEIPSearchResult.jsp?oper_stn_id="+oper_stn_id+"&gender="+gender+"&patient_id="+patient_id+"&observe_id="+observe_id+"&nursing_unit_code="+nursing_unit_code;
		   document.forms[0].target	=	"AEMPSearchResultFrame";
		   document.forms[0].method	=	"GET";
		   document.forms[0].submit();

	}
	else if (from=='clinic')
	{

		var ch_x='';
		var final_String='';
		var rows_id	=	document.forms[0].finalString.value;
		var rows= rows_id.split(",");
		for(i=0;i<rows.length;i++)
		{ 
		final_String+=trimString(rows[i])+"','"; 
		}
		parent.AEMPSearchCriteriaFrame.document.forms[0].ch_x.value=final_String;
		ch_x =parent.AEMPSearchCriteriaFrame.document.forms[0].ch_x.value;
		/*Below line commented by senthil*/
		//parent.AEMPSearchCriteriaFrame.document.forms[0].ch_id.value='Y';
		var	ch_id=parent.AEMPSearchCriteriaFrame.document.forms[0].ch_id.value;


		var observe_id		= parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.observe_id.value;
		var clinic_code		=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.clinic_code;
		var clinic_type		=	'';        
		clinic_type=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.clinic_type.value			=	parent.AEMPSearchCriteriaFrame.clinicType[clinic_code.selectedIndex];
		var fields = new Array (parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.patient_id);
		var names = new Array ("Patient ID");	
		var error_jsp="../../eCommon/jsp/error.jsp";
		var messageFrame="";
		document.forms[0].target	=	"AEMPSearchResultFrame";
		var nursing_unit_code		=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.nursing_unit_code.value;
		var oper_stn_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.oper_stn_id.value;
		var checkout_yn=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.checkout_yn.value;
		var sys_date=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.sys_date.value;
		var p_cutoff_hours_prv_day_visit=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.p_cutoff_hours_prv_day_visit.value;
		var rslt_clinic_code=parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_code.value;
		var treatment_area_code=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.treatment_area_code.value;
		var practitioner_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.practitioner_id.value;
		var patient_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.patient_id.value;
        var priority_zone=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value;
        var priority="";
        var oberv_clinc_code=nursing_unit_code;
		var orderCriteria	=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value
		var asc_desc	=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.asc_desc.value

		document.forms[0].action	="../../eAE/jsp/AEMPSearchResult.jsp?ch_x="+final_String+"&ch_id="+ch_id+"&oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+rslt_clinic_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code+"&observ_id="+observe_id+"&oberv_clinc_code="+oberv_clinc_code+"&orderCriteria="+orderCriteria+"&asc_desc="+asc_desc+"&clinic_type="+clinic_type;

		document.forms[0].method	=	"POST";
				
				if(SpecialCharCheck(fields,names,parent.messageFrame,"M",error_jsp)){
						document.forms[0].submit();
					}
	}

		else if (from=='TreatmentArea')
	{
			  var ch_x='';
		    var final_String='';
			var rows_id	=	parent.AEMPSearchResultFrame.document.forms[0].finalString.value;
			var rows= rows_id.split(",");
		for(i=0;i<rows.length;i++)
        { 
		   final_String+=trimString(rows[i])+"','"; 
        }

	 parent.AEMPSearchCriteriaFrame.document.forms[0].ch_x.value=final_String;
     ch_x =parent.AEMPSearchCriteriaFrame.document.forms[0].ch_x.value;
	 /*Below line commented by senthil*/
    // parent.AEMPSearchCriteriaFrame.document.forms[0].ch_id.value='Y';
	 
	var	ch_id=parent.AEMPSearchCriteriaFrame.document.forms[0].ch_id.value;

		var observe_id		=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.observe_id.value;
		var clinic_code		=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.clinic_code;

		var clinic_type		=	'';        
		clinic_type=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.clinic_type.value			=	parent.AEMPSearchCriteriaFrame.clinicType[clinic_code.selectedIndex];
		var fields = new Array (parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.patient_id);
		var names = new Array ("Patient ID");	
		var error_jsp="../../eCommon/jsp/error.jsp";
		var messageFrame="";
		document.forms[0].target	=	"AEMPSearchResultFrame";
		var nursing_unit_code		=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.nursing_unit_code.value;
		var oper_stn_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.oper_stn_id.value;
		var checkout_yn=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.checkout_yn.value;
		var sys_date=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.sys_date.value;
		var p_cutoff_hours_prv_day_visit=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.p_cutoff_hours_prv_day_visit.value;
		var rslt_clinic_code=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.clinic_code.value;
		var treatment_area_code=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.treatment_area_code.value;
		var practitioner_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.practitioner_id.value;
		var patient_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.patient_id.value;
        var priority_zone=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value;
        var priority="";
		var oberv_TMT_code=nursing_unit_code;
		var orderCriteria	=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value
		var asc_desc	=	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.asc_desc.value

	
		document.forms[0].action	="../../eAE/jsp/AEMPSearchResult.jsp?ch_x="+final_String+"&ch_id="+ch_id+"&oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+rslt_clinic_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code+"&observ_id="+observe_id+"&oberv_TMT_code="+oberv_TMT_code+"&orderCriteria="+orderCriteria+"&asc_desc="+asc_desc+"&clinic_type="+clinic_type;
		document.forms[0].method	=	"POST";
				
				if(SpecialCharCheck(fields,names,parent.messageFrame,"M",error_jsp)){
						document.forms[0].submit();
					}
	}


	else{
		var clinic_code		=	document.forms[0].clinic_code;
		var clinic_type		=	document.forms[0].clinic_type;
		document.forms[0].clinic_type.value			=	clinicType[clinic_code.selectedIndex];
		var fields = new Array (document.forms[0].patient_id);
		var names = new Array (getLabel("Common.patientId.label","Common"));	
		var error_jsp="../../eCommon/jsp/error.jsp";
		var messageFrame="";
		document.forms[0].target	=	"AEMPSearchResultFrame";
		var nursing_unit_code		=	document.forms[0].nursing_unit_code.value;
		var oper_stn_id=document.forms[0].oper_stn_id.value;
		var checkout_yn=document.forms[0].checkout_yn.value;
		var sys_date=document.forms[0].sys_date.value;
		var p_cutoff_hours_prv_day_visit=document.forms[0].p_cutoff_hours_prv_day_visit.value;
		var clinic_code=document.forms[0].clinic_code.value;
		var treatment_area_code=document.forms[0].treatment_area_code.value;
		var practitioner_id=document.forms[0].practitioner_id.value;
		var patient_id=document.forms[0].patient_id.value;
        var priority_zone=document.forms[0].priority_zone.value;
        var priority="";
		document.forms[0].action	=	"../../eAE/jsp/AEMPSearchResult.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code;
		document.forms[0].method	=	"POST";

				if(SpecialCharCheck(fields,names,parent.messageFrame,"M",error_jsp)){
						document.forms[0].submit();
					}
  }
}

async function GetChiefComplaint(encounter_id,patient_id){
	var retVal;
	var dialogHeight    = "70vh" ;
	var dialogWidth = "70vw" ;    
	var arguments   = "" ;
	var center = "1" ;
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; scrolling :" + "NO" ;
	var arguments   = "" ;
	var url = "../../eAE/jsp/AEPatChiefComplaint.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&open_in_modal=Y&displayFrames=NO";
	retVal = await window.showModalDialog(url,arguments,features);

}
async function showdiagnosis(complaint_id,complaint_desc,encounter_id)
{	
	var dialogWidth = "100vw";
	var dialogHeight = "50vh";
	var features		="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;

	retVal = await window.showModalDialog("../../eCA/jsp/RecPatChiefComplaintDiagViewMain.jsp?encounter_id="+encounter_id+"&complaint_id="+complaint_id+"&complaint_desc="+encodeURIComponent(complaint_desc),arguments,features);
}
async function showRemarks(complaint_text,complaint_desc,remarks,complaint_id,facility_id,encounter_id)
{
	
	var dialogWidth = "45vw";
	var dialogHeight = "45vh";
	var features		="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;

	retVal =await window.showModalDialog("../../eCA/jsp/RecPatChiefComplaintDetailsMain.jsp?complaint_text="+complaint_text+"&complaint_desc="+complaint_desc+"&remarks="+remarks+"&complaint_id="+complaint_id+"&facility_id="+facility_id+"&encounter_id="+encounter_id,arguments,features);
}
async function ViewAllDiag(encounter_id)
{
	var dialogWidth = "55vw";
	var dialogHeight = "35vh";
	var features		="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;

	retVal =await window.showModalDialog("../../eCA/jsp/RecPatChiefComplaintViewAllDiagMain.jsp?Encounter_Id="+encounter_id,arguments,features);
}
//Modified for MMS-QH-CRF-0126.2 By Dharma..
async function NEWCAChart(encounter_id,visit_num,facility_id,action_on_pending_bill,patient_id,episode_id)	{

	if(action_on_pending_bill=="N"){
		await FnProceedAssignTreatmentArea(encounter_id);
	}else{
		await FnCheckOPQBLValidation(encounter_id,visit_num,facility_id,action_on_pending_bill,patient_id,episode_id);
	}
	var isForAdmission	=	document.forms[0].isForAdmission.value;
	if(isForAdmission==true || isForAdmission =="true") {
	reloadCriteria();
	}
}
async function FnProceedAssignTreatmentArea(){
	var dialogHeight	=	"80vh";
	var dialogWidth		=	"80vw";
	var dialogTop		=	"0vh";
	var status			=	"no";
	var arguments		=	"" ; 
	var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
	//var features   = 'dialogHeight:"80vh"; dialogWidth:"80vw"; dialogTop:50; status=no';
	var arguments  = '';
	var retVal =await top.window.showModalDialog('../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode=AssignTreatmentArea&' + query_string ,arguments,features);
	if(retVal!=null){
	var rvalues=retVal.split('&')
	var patient_id=rvalues[0];
	var encounter_id=rvalues[1];
	var queue_date=rvalues[2];
	var brought_dead=rvalues[3];
	var patient_gender=rvalues[4];
	var priority_zone=rvalues[5];
	var min_age_for_lmp=rvalues[6];
	var year_value=rvalues[7];
	var enable_rights_yn=rvalues[8];
	var sel_triage_yn=rvalues[9];
	var sel_cons_yn=rvalues[10];
	if(sel_triage_yn=="Y"){
	var assignVal = "N";
		call_sec_triage(patient_id,encounter_id,queue_date,brought_dead,patient_gender,priority_zone,min_age_for_lmp,year_value,assignVal)
		}
	  }else{
	     window.location.href = window.location.href;
		 //window.location.reload(); Modified by Munisekhar for IN43904
	  }
	
}


async function FnProceedAssignTreatmentArea1(action_url,arguments,features){
	var retVal	= await	window.showModalDialog(action_url,arguments,features);
	if(retVal11!=null) 	{
		var retarr1=retVal.split("|");
		var retVal11=retarr[0];
		var retVal21 = retarr[1];
		if(retVal11=="Success")
		parent.AEMPSearchResultFrame.location.href = parent.AEMPSearchResultFrame.location.href;
			//parent.AEMPSearchResultFrame.location.reload(); Modified by Munisekhar for IN43904
	}
}



//FnCheckOPQBLValidation Added by dharma for MMS-QH-CRF-0126.2 [IN:042931] 
function FnCheckOPQBLValidation(encounter_id,visit_num,facility_id,action_on_pending_bill,patient_id,episode_id){
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
          			FnProceedAssignTreatmentArea(encounter_id);
          		}
          	}
          } ,
          error: function(jqXHR, textStatus, errorThrown) {
              alert("Error : " + jqXHR.responseText);
          }
      });  

}

function FnCheckOPQBLValidation1(encounter_id,visit_num,facility_id,action_on_pending_bill,patient_id,episode_id,action_url,arguments,features){
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
          			FnProceedAssignTreatmentArea1(action_url,arguments,features);
          		}
          	}
          } ,
          error: function(jqXHR, textStatus, errorThrown) {
              alert("Error : " + jqXHR.responseText);
          }
      });  
}

/* Below method added by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
function callMouseOverOnTD(obj,imgObj,row,link)
{
 
	if (prevObjID != null && prevObjID != obj.id)
		 {		 
		  
		   document.getElementById(prevlink).style.color="blue";
           document.getElementById(prevObjID).className =prevClassName;
		   document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";		 
		 }
		
		 if((row%2)==1){ 
          prevClassName='QRYODD';}
           if(row%2==0){ 
          prevClassName='QRYEVEN';}
		  prevlink=link;
		   
		  obj.className = 'selectedTDData';
		  document.getElementById(link).style.color="blue";
		  document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
		
		prevObjID = obj.id;
		prevImgObj = imgObj;
		
}
/* Below method added by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
function resizeWindow(obj,priority_zone)
{

 var orderctlHDR1 = obj.id;
		var wdth = document.getElementById(orderctlHDR1).offsetWidth;
		var hght1 = document.getElementById(orderctlHDR1).offsetHeight;		
		
		var wdth1 = getPos(obj).x +wdth;
		var hght = getPos(obj).y ;	

		bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight
	
		var z = bodwidth- (event.x + wdth);	
		
		var x 	  = event.x;
		var y 	  = event.y;	
	
		x 	  = x + (document.getElementById('tooltiplayer').offsetWidth);
		y 	  = hght + (document.getElementById('tooltiplayer').offsetHeight);	

		if(x<bodwidth){
			x= wdth1;			
		}else{			
			x = getPos(obj).x;
		}
		
		y = hght;
		
		 if(priority_zone=="Y" || priority_zone=="R"){ 
			document.getElementById('tooltiplayer').style.left=x-7+"px";
			}
	    else if (priority_zone=="G"){ 
			 document.getElementById('tooltiplayer').style.left=x-1+"px"; }
		else { 
		 	 document.getElementById('tooltiplayer').style.left=x-4+"px" }
		  
	
	    document.getElementById('tooltiplayer').style.top =y+"px";
	    document.getElementById('tooltiplayer').style.backgroundColor = '#FFFFE0';
	    document.getElementById('tooltiplayer').style.width = '15%';
		document.getElementById('tooltiplayer').style.visibility='visible'
}
/* Below method added by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
function getPos(inputElement) {
	
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
	
		if(targetElement.x && targetElement.y) {
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else { 
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
             
            }
        }
        return coords;
    } catch(error) {
       
        return coords;
    }
}

/* Below method added by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
function hideToolTip(obj,imgObj,row)
{ 
 
dynamicChange( obj,window.event,row)
}
/* Below method added by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
function dynamicChange(m,e,row)
   {     
   
  
      if (!this.isContained(m, e))
		{   
		this.delayhidemenu(row)
		}
   }

/* Below method added by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
function isContained(m, e)
	{ 
            
		var e=window.event || e
		var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
		while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
		if (c==m)
			return true
		else
			return false
	}
	
/* Below method added by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
function delayhidemenu(row)
	{
         
		   
		this.delayhide=setTimeout("hidemenu()", this.disappeardelay) 
		 if(document.getElementById('desc'+row))
			if(document.getElementById('desc'+row).className=='selectedTDData')
			{ 
			 document.getElementById('imgArrow'+row).src = "../../eCommon/images/activeArrow.gif";
			}
		 if(document.getElementById('imgArrow'+row) && document.getElementById("desc"+row).className !='selectedTDData' ) 
			document.getElementById('imgArrow'+row).src = "../../eCommon/images/inactiveArrow.gif";
			
			
	}
	
/* Below method added by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] */
function hidemenu()
	{ 
	parent.AEMPSearchResultFrame.document.getElementById('tooltiplayer').style.visibility = 'hidden';
	}
/* Below method added by Venkatesh.S on 10-Oct-2013 against 44988 */


function menuHide()
{  
	 if(f_query_add_mod.AEMPSearchResultFrame.document.getElementById('tooltiplayer')){
	 f_query_add_mod.AEMPSearchResultFrame.document.getElementById('tooltiplayer').style.visibility="hidden";}
	if(f_query_add_mod.AEMPSearchResultFrame.document.getElementById('tb1'))f_query_add_mod.AEMPSearchResultFrame.document.getElementById('tb1').width=2688;
	if(f_query_add_mod.AEMPSearchResultFrame.document.getElementById('th_table'))f_query_add_mod.AEMPSearchResultFrame.document.getElementById('th_table').width=2688;
	

}
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
function FnShowPriorityWise(priority_code,tab_obj,treat_area_code,appear_as_tab_yn){

	var isForAdmissionAppl	= document.forms[0].isForAdmission.value;//Kamatchi added for ML-MMOH-CRF-1973 as on 07-07-2023
	var priority_zone_all_codes 	= $("#priority_zone_all_codes").val();
	var selected_tab_color			= "LIGHTGREY";
	priority_zone_all_codes			= priority_zone_all_codes.slice(0,-1);
	var arr_priority_zone_all_codes	= priority_zone_all_codes.split(","); 
	var boldPriorityZoneTab			= document.forms[0].boldPriorityZoneTab.value;
	var isPendingForAdmissionAppl	= document.forms[0].isPendingForAdmissionAppl.value;//Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658
	//Maheshwaran K added for ML-MMOH-CRF-1972 as on 21-07-2023
	if(isForAdmissionAppl == "true" || isForAdmissionAppl == true){
	if(tab_obj==undefined && priority_code=='for_admission') 	
		{
			document.getElementById('enableSubTabForIPAdm').value='Y'		
			document.getElementById('for_others').style.background='LIGHTGREY';   
			$.each(arr_priority_zone_all_codes,function(index,value){
			if(value!=priority_code){
			$("#for_priority_zone_tab_"+value).css('background-color', $("#priority_zone_color_"+value).val());
			}
			})
		}
	else if(tab_obj=='IP_ADM' || priority_code=='for_admission')
		{		
		document.getElementById('enableSubTabForIPAdm').value='Y'	
		}
		else {
				document.getElementById('enableSubTabForIPAdm').value='N'	
		}	 
	}
	//Ends
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	if(document.forms[0].isAppearAsTabEnable.value==true || document.forms[0].isAppearAsTabEnable.value=="true"){
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
	}
	//End
	//Modified by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
	$.each(arr_priority_zone_all_codes,function(index,value){
		if(value==priority_code){
			if(boldPriorityZoneTab == "true") {
			$("#priority_zone_tab_"+priority_code).css('fontWeight', 'bold'); }
			else {
				 if(tab_obj=='IP_ADM' && (isForAdmissionAppl == "true" || isForAdmissionAppl == true)) { //Maheshwaran K added for ML-MMOH-CRF-1972 as on 21-07-2023
					$("#for_priority_zone_tab_"+priority_code).css('background-color', selected_tab_color); 
						document.getElementById('for_others').style.background='NAVY';
				 }
				 else {            
			$("#priority_zone_tab_"+priority_code).css('background-color', selected_tab_color);
				 }
			}
		}else{
			if(boldPriorityZoneTab == "true") {
			$("#priority_zone_tab_"+value).css('fontWeight', 'normal'); }
			else {
				 if(tab_obj=='IP_ADM' && (isForAdmissionAppl == "true" || isForAdmissionAppl == true)) { //Maheshwaran K added for ML-MMOH-CRF-1972 as on 21-07-2023
					 $("#for_priority_zone_tab_"+value).css('background-color', $("#priority_zone_color_"+value).val());
					 document.getElementById('for_others').style.background='NAVY';
				 }
				 else {
			$("#priority_zone_tab_"+value).css('background-color', $("#priority_zone_color_"+value).val());
				 }
			}
		}
	});
	if(boldPriorityZoneTab == "true")    //Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
		document.getElementById('others').style.fontWeight = 'normal';
	else
	document.getElementById('others').style.background='NAVY';
    if(document.forms[0].nursing_unit_code.value!="")
		{
		if(boldPriorityZoneTab == "true")    //Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17
			document.getElementById('nurse').style.fontWeight = 'normal';
		else
		   document.getElementById('nurse').style.background='#FFCCCC'
	}
	/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
	if(isPendingForAdmissionAppl == "true"){
		if(priority_code == "for_admission"){
			document.getElementById('pendingForAdmTab').style.fontWeight = 'bold';
			/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/
			if(parent.AEMPSearchCriteriaFrame.document.forms[0].orderCriteria)
				parent.AEMPSearchCriteriaFrame.document.forms[0].orderCriteria.value = "";
			/*End*/
		}else{
			document.getElementById('pendingForAdmTab').style.fontWeight = 'normal';
		}
	}
	/*End*/
		//Kamatchi added -isForAdmissionAppl for ML-MMOH-CRF-1973 as on 07-07-2023
	if(isForAdmissionAppl == "true" && document.forms[0].enable_admission_tab.value == "Y" && document.forms[0].sel_admission_yn.value == "Y"){
		if(priority_code == "for_admission"){
			document.getElementById('ForIPAdmissionTab').style.visibility=''; //Kamatchi added for ML-MMOH-CRF-1973 as on 07-07-2023 to enable SubTab for IP Admission
			document.getElementById('pendingForAdmTab').style.fontWeight = 'bold';
			if(parent.AEMPSearchCriteriaFrame.document.forms[0].orderCriteria)
				parent.AEMPSearchCriteriaFrame.document.forms[0].orderCriteria.value = "";
		}else{
			document.getElementById('pendingForAdmTab').style.fontWeight = 'normal';
		}
	}//Ends
	document.forms[0].priority_zone.value=priority_code;
 // if(document.forms[0].isAppearAsTabEnable.value==true){
  if(document.forms[0].isAppearAsTabEnable.value==true || document.forms[0].isAppearAsTabEnable.value=="true"){
	 // alert("3620 treat_area_code =="+treat_area_code);
	document.forms[0].treatment_area_code1.value = (treat_area_code != null && treat_area_code !="")?treat_area_code:"";
	document.forms[0].appear_as_tab_yn.value = appear_as_tab_yn; 
	if((treat_area_code == null || treat_area_code == "null" || treat_area_code == "") && tab_obj=='TREAT_TAB'){//previous
	document.forms[0].treatment_area_code.value="";	
	}
	}
	//if(document.forms[0].isAppearAsTabEnable.value==true){
	if(document.forms[0].isAppearAsTabEnable.value==true || document.forms[0].isAppearAsTabEnable.value=="true"){
	if(tab_obj=='TREAT_TAB')
		{		
		document.getElementById('treatmentTabValue').value='Y'	  
		}
		else {
				document.getElementById('treatmentTabValue').value='N'	
	}
	}
	showQueryResult();
	document.forms[0].priority_zone.value="";
}
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/

/*Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/

function fnCallRegNewBornForAE(patient_id){
var url='../../eMP/jsp/NewbornRegistration.jsp?module_invoked=AE&module_id=AE&function_id=REG_NEWBORN_FOR_AE&accessRights=NNNNN&Patient_ID='+patient_id;
checkExpiry(patient_id,'','retback', 'NEWBORN_REG','',url);

}
/*Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/

function checkExpiry(pat_id,jsp_name,flag,func_id, sflag, target)
{
	 var sStyle = document.forms[0].sStyle.value; 
	 var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'>";
	 HTMLVal = HTMLVal +"<form name='validate_form' id='validate_form' method='post' action='../../eMP/jsp/PatSearchCheckAltIDExpiryDate.jsp' target='messageFrame'>";
	 HTMLVal = HTMLVal +"<input name='pat_id' id='pat_id' type='hidden' value= \""+escape(pat_id) + "\">";
	 HTMLVal = HTMLVal +"<input name='jsp_name' id='jsp_name' type='hidden' value= '"+jsp_name+"'>";
	 HTMLVal = HTMLVal +"<input name='flag' id='flag' type='hidden' value= '"+flag+"'>";
	 HTMLVal = HTMLVal +"<input name='func_id' id='func_id' type='hidden' value= '"+func_id+"'>";
	 HTMLVal = HTMLVal +"<input name='sflag' id='sflag' type='hidden' value= '"+sflag+"'>";
	 HTMLVal = HTMLVal +"<input name='IPValue' id='IPValue' type='hidden' value= '"+target+"'>";
	 HTMLVal = HTMLVal +"<input name='win_width' id='win_width' type='hidden' value= '61'>";
	 HTMLVal = HTMLVal +"<input name='win_top' id='win_top' type='hidden' value= '34'>";
	 HTMLVal = HTMLVal +"<input name='win_height' id='win_height' type='hidden' value= '50'>";
	 HTMLVal = HTMLVal +"<input name='calling_module_id' id='calling_module_id' type='hidden' value= 'AE'>";
	 HTMLVal = HTMLVal +"</form></BODY></HTML>";
	
	 parent.parent.frames[2].document.write(HTMLVal);
	 parent.parent.frames[2].document.validate_form.submit(); 
}
/*Added by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623 Start*/
async function openStartConsultation(patient_id, encounter_id){
	
	var retVal		= new String();
    var dialogTop	= "";
    var dialogHeight= "50vh";                     
    var dialogWidth = "70vw";
    var status		= "no";
    var scroll		= "no";
    var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
    var arguments   = "";
          
	var parameters	= "p3="+encounter_id+"&module_id=AE&p2="+patient_id;
	
	var action_url	="../../eOP/jsp/CallConsStart.jsp?"+parameters;  
	
	retVal = await window.showModalDialog(action_url,arguments,features);
	if(retVal == "Y")
		window.location.href = window.location.href;
}
/*End*/

/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
function pendingForAdmission(patient_id, encounter_id){
	if(confirm(getMessage('CONFIRM_PENDING_ADMISSION','AE'))){
		$.ajax({  
			url:'../../servlet/eAE.AEManagePatientServlet',  
			type:'post',  
			data:{'operation_mode':'for_admission','patient_id':patient_id,'encounter_id':encounter_id},
			async: false, 
			success: function(data) {
				window.location.href = window.location.href;
			}
		});
	}
	else
		window.location.href = window.location.href;
}
/*End*/
function checkForAdmissionReferral(patient_id, encounter_id){
	if(confirm(getMessage('FOR_ADMISSION','AE'))){
		$.ajax({  
			url:'../../servlet/eAE.AEManagePatientServlet',  
			type:'post',  
			data:{'operation_mode':'for_admission','patient_id':patient_id,'encounter_id':encounter_id},
			async: false, 
			success: function(data) {
				CallRefDetails(patient_id, encounter_id );
			}
		});
		reloadCriteria();
	}
/*	else
		{ 
	alert('3934 CancelForAdmission');
		window.location.href = window.location.href;
		} */
//reloadCriteria();
}
async function CallRefDetails(patient_id, encounter_id ){
	var dialogHeight	= '90vh';
	var dialogWidth	= '90vw';
	var dialogTop		= '10';
	var arguments		= ''  ;
	var getUrl = "../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounter_id+"&patient_id="+patient_id+"&Transaction_type=CO&patient_id="+patient_id+"&Module=OP&recFun=for_admission"; 
	var features = "dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+"; status=no;";
	retVal =await top.window.showModalDialog(getUrl,arguments,features);
	window.location.href = window.location.href;
}
function ModifyForAdmissionReferral(patient_id, encounter_id){
		$.ajax({  
			url:'../../servlet/eAE.AEManagePatientServlet',  
			type:'post',  
			data:{'operation_mode':'ModifyReferral','patient_id':patient_id,'encounter_id':encounter_id},
			async: false, 
			success:function(data) {
				var dialogHeight	= '50vh';
				var dialogWidth	= '75vw';
				var dialogTop		= '60';
				var arguments		= ''  ;
				var getUrl = "../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounter_id+"&Transaction_type=CO&patient_id="+patient_id+"&Module=OP&recFun=ModifyReferral"; 
				var features = "dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+"; status=no;";
				retVal =window.showModalDialog(getUrl,arguments,features);
					if(retVal == "Y") {
						window.location.href = window.location.href;	
					}
			}
		});
}

/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
function chkWithSysDt(obj)
{
	if(obj.value!='')
	{
		if(isBeforeNow(obj.value,"DMYHM",localeName))
		{
			var visit_adm_date_time = document.forms[0].visit_adm_date_time.value;

			if(!isAfter(obj.value, visit_adm_date_time, "DMYHM", localeName))
			{	
				alert(getMessage("DT_TM_NOT_LESS_THN_REG_ATTN","AE"));
				parent.frames[1].document.forms[0].assign_tmt_area_time.select();
				parent.frames[1].document.forms[0].assign_tmt_area_time.focus();					
				return false;	
			}
		}
		else
		{
			var msg = getMessage("DATE_NOT_GREATER_SYSDATE","COMMON")
			msg = msg.replace(/Date/g,getLabel("Common.datetime.label","Common"))
			alert(msg);
			obj.select();
			obj.focus();				
			return false ;
		}
	}		
}
/*End ML-MMOH-CRF-1133*/

/*Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022*/
function changePriority(obj)
{
	var priority_zone = obj.value;

	deleteValues(document.forms[0].priority11);

	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH priority_zone=\""+priority_zone+"\" action='getPriorityValue' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eAE/jsp/AEIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	var PriorityValue = trimString(responseText);

	var arr = new Array();
	arr = PriorityValue.split("##");

	if(PriorityValue != '')
	{
		for(i=0; i<arr.length; i++) 
		{
			var PriorityArr = new Array();
			PriorityArr = trimString(arr[i]).split("~~");

			var priority_code = PriorityArr[0];
			var short_desc = PriorityArr[1];

			var opt = document.createElement('OPTION');
			opt.text = short_desc; 
			opt.value = priority_code;
			document.forms[0].priority11.add(opt);
		}
	}
}

function deleteValues(obj)
{
	while(obj.options.length>1) obj.options.remove(1);
}
/*End ML-MMOH-CRF-1975*/
//<!--Added by Himanshu Saxena on 11-Jul-2023 for ML-MMOH-CRF-1972 US5 Starts-->
async function showReferralDetails(patient_id,encounter_id,facility_id) 
{	
var dialogHeight ='55vh' ;
var dialogWidth = '75vw' ;
var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
var Transaction_type="VW";
retVal = await window.showModalDialog('../../eMP/jsp/ReferralDetailsResult.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&Transaction_type='+Transaction_type,arguments,features);
}
 
//Kamatchi added for ML-MMOH-CRF-1972 as on 07-07-2023
//Starts
function reloadCriteria()
{
var isForAdmission	=	document.forms[0].isForAdmission.value;
var clinic_code		=	parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_code.value;
var clinic_type		=	parent.AEMPSearchCriteriaFrame.document.forms[0].clinic_type;
var gender			=	parent.AEMPSearchCriteriaFrame.document.forms[0].gender.value;
var practitioner_id	=	parent.AEMPSearchCriteriaFrame.document.forms[0].practitioner_id.value;
var patient_id		=	parent.AEMPSearchCriteriaFrame.document.forms[0].patient_id.value;
var oper_stn_id		=	parent.AEMPSearchCriteriaFrame.document.forms[0].oper_stn_id.value;
var checkout_yn		=	parent.AEMPSearchCriteriaFrame.document.forms[0].checkout_yn.value;
var isAppearAsTabEnable =	parent.AEMPSearchCriteriaFrame.document.forms[0].isAppearAsTabEnable.value;
		var priority_zone = parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value;
var bed_bay_type	=	parent.AEMPSearchCriteriaFrame.document.forms[0].bed_bay_type.value;
var include_checkedout	=	parent.AEMPSearchCriteriaFrame.document.forms[0].include_checkedout.value;
var prev_visit		=	parent.AEMPSearchCriteriaFrame.document.forms[0].prev_visit.value;
var priority="";
var treatment_area_code	=	parent.AEMPSearchCriteriaFrame.document.forms[0].treatment_area_code.value;
var sys_date		=	parent.AEMPSearchCriteriaFrame.document.forms[0].sys_date.value;
var p_cutoff_hours_prv_day_visit	=	parent.AEMPSearchCriteriaFrame.document.forms[0].p_cutoff_hours_prv_day_visit.value;
var nursing_unit_code		=	parent.AEMPSearchCriteriaFrame.document.forms[0].nursing_unit_code.value;


if(isForAdmission==true || isForAdmission =="true") {
		

			parent.AEMPSearchCriteriaFrame.document.forms[0].target	=	"AEMPSearchCriteriaFrame";
			parent.AEMPSearchCriteriaFrame.document.forms[0].action	=	"../../eAE/jsp/AEMPSearchCriteria.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&gender="+gender+"&include_checkedout="+include_checkedout+"&prev_visit="+prev_visit+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code;
			parent.AEMPSearchCriteriaFrame.document.forms[0].method	=	"GET";
					parent.AEMPSearchCriteriaFrame.document.forms[0].submit();
		/*document.forms[0].target	=	"AEMPSearchCriteriaFrame";
			document.forms[0].action	=	"../../eAE/jsp/AEMPSearchCriteria.jsp?oper_stn_id="+oper_stn_id+"&checkout_yn="+checkout_yn+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bed_bay_type="+bed_bay_type+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&gender="+gender+"&include_checkedout="+include_checkedout+"&prev_visit="+prev_visit+"&priority="+priority+"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&priority_zone="+priority_zone+"&nursing_unit_code="+nursing_unit_code;
			document.forms[0].method	=	"GET";
			document.forms[0].submit(); */
		}
}
//Ends
/*Added by lakshmanan for ML-MMOH-CRF-1972 US007 on 06/07/2023 start */
async function CancelForAdmission(patient_id,encounter_id) {
	var retVal		= new String();
    var dialogTop	= "";
    var dialogHeight= "55vh";                     
    var dialogWidth = "75vw";
    var status		= "no";
    var scroll		= "no";
    var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
    var arguments   = "";
          
	var parameters	= "patient_id="+patient_id+"&encounter_id="+encounter_id;
	
	var action_url	="../../eAE/jsp/CancelForAdmissionFrame.jsp?"+parameters;  
	
	retVal = await window.showModalDialog(action_url,arguments,features);
	if(retVal == "Y") {
		//window.location.href = window.location.href;	
		reloadCriteria();
	}
//	reloadCriteria();
}  
/*Added by lakshmanan for ML-MMOH-CRF-1972 US007 on 06/07/2023 end */

/*Added by Gunasekar for GHL-CRF-0517.4 on 15/08/2024 Start*/
function unbilledChargesTransfer(eid,brought_dead,treatment_area_code,open_to_all_prac_for_clinic_yn,clinic_code,open_to_all_pract_yn,patient_id,clinic_type,allow_chkout_with_bill_stmt_yn,episode_id,visit_num,pend_ord_stats){
	
	var isSiteUnbilledorNot = document.forms[0].isSiteUnbilledorNot.value;
	var unbilledCheckBox_yn = document.forms[0].unbilled_yn.value;
	var session_id = document.forms[0].session_id.value;
	var facility_id = document.forms[0].facility_id.value;
	var loginUser = document.forms[0].loginUser.value;
	var p_ws_no = document.forms[0].p_ws_no.value;
	var locale = document.forms[0].locale.value;
	
    if(isSiteUnbilledorNot=="true"  && unbilledCheckBox_yn == "Y"){
  	        var xmlDoc="" 
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH fac_id=\""+facility_id+"\" pat_id=\""+patient_id+"\" enco_id=\""+eid+"\" epi_id=\""+episode_id+"\" visit_id=\""+visit_num+"\" action='CheckUnbilledCharges' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eAE/jsp/AEIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText = xmlHttp.responseText
			var p_unbilled_yn = trimString(responseText);

	    	if(p_unbilled_yn=="Y"){
	    		var xmlDoc="" 
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH enco_id=\""+eid+"\" pat_id=\""+patient_id+"\" action='getOpenIPEncounter' /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","../../eAE/jsp/AEIntermediate.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText = xmlHttp.responseText
				var ipOpenEnCount = trimString(responseText);
		    	if(ipOpenEnCount!=0){
		    	 	var transfer = vbConfirm(getMessage("TRANSFER_UNBILLED_CHARGES","IP"), getLabel("eAE.TransferUnbilledCharges.label","AE"));

			    if(transfer==6){
			        var xmlDoc="" 
				    var xmlHttp = new XMLHttpRequest()
			        xmlStr ="<root><SEARCH fac_id=\""+facility_id+"\" pat_id=\""+patient_id+"\" enco_id=\""+eid+"\" epi_id=\""+episode_id+"\" visit_id=\""+visit_num+"\" session_id=\""+session_id+"\" loginUser=\""+loginUser+"\" p_ws_no=\""+p_ws_no+"\" locale=\""+locale+"\" action='unbilledTransferAeToIp' /></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","../../eAE/jsp/AEIntermediate.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText = xmlHttp.responseText
					var unbilledTransfer = trimString(responseText);
			    	if(unbilledTransfer == "SQLERRM"){
			    		  alert(getMessage("TRANSFER_UNBILLED_CHARGES_FAILED","IP"));
			    	}
				}
			}
		}
	}
    LoadChkOut(eid,brought_dead,treatment_area_code,open_to_all_prac_for_clinic_yn,clinic_code,open_to_all_pract_yn,patient_id,clinic_type,allow_chkout_with_bill_stmt_yn,episode_id,visit_num,pend_ord_stats)
}/*Added by Gunasekar for GHL-CRF-0517.4 on 15/08/2024 End*/


async function getMenstrualHistoryDtl(patient_id,facility_id){  
	var dialogHeight= "65vh";
	var dialogWidth = "85vw";
	var dialogTop	= "10";
	var status = "no";
	var arguments	= "" ;			
	var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	var jsp_name;
      await top.window.showModalDialog("../../eCA/jsp/CAMenstrualHistDtlResultView.jsp?patient_id="+patient_id+"&facility_id="+facility_id,arguments,features);
}

