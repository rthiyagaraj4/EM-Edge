/*
Added By Niveditha for GHL-CRF-602.1
*/


function callvalidlabdept()
{


}

function resetCriteria()
{
	parent.pathologistWorkListCriteriaFrame.location.reload();
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	
}


function closeWindow()
{
	parent.window.close();
}


function callSearch()
{
   	if(window.event.keyCode==13)
	{	
   		SearchChart('jsp');
	}
}


function SearchChart(flag){
	

	if(flag=='jsp')	{

		var lab_dept_name_search=document.pathologistWorkListCriteriaForm.lab_dept_name.value;
		var order_facility_name_search=document.pathologistWorkListCriteriaForm.ordering_facility_name.value;
		var fromDate_search=document.pathologistWorkListCriteriaForm.date_from.value;
		var toDate_search=document.pathologistWorkListCriteriaForm.date_to.value;
		var ordering_pract_code_search=document.pathologistWorkListCriteriaForm.ordering_pract_code.value;
		var performing_facility_id_search=document.pathologistWorkListCriteriaForm.performing_facility_id.value;
		var Patient_Id=document.pathologistWorkListCriteriaForm.Patient_Id.value;
		var reporting_facility_id_search=document.pathologistWorkListCriteriaForm.reporting_facility_id.value;
		var assigned_red_code_search=document.pathologistWorkListCriteriaForm.assigned_red_code.value;
		var specimen_number=document.pathologistWorkListCriteriaForm.specimen_number.value;
		var lab_order_status=document.pathologistWorkListCriteriaForm.lab_order_status.value;

        if (lab_dept_name_search == "") {
			var errors = getMessage('LAB_DEPT_BLANK','BT');
            alert(errors);
            return false;
        }
		
		if (specimen_number == "" & fromDate_search =="" & toDate_search =="") {
			var errors = getMessage('SPNO_DATE_BLANK','BT');
            alert(errors);
            return false;
        }
        
		if (specimen_number) {
			var regex = /^\d+$/;
			var test1 = regex.test(specimen_number);
			if(test1==false){var errors=getMessage('SP_NO_INVALID_TYPE','BT');
			alert(errors);
            return false;
			}
        }
		

		var locale = document.pathologistWorkListCriteriaForm.locale.value;
		var max_days=daysBetween(fromDate_search,toDate_search,"DMY",document.pathologistWorkListCriteriaForm.locale.value);
		if(max_days>30){
		var errors=getMessage('DATE_MORE_THAN_30_DAYS','BT');
			alert(errors);
			document.pathologistWorkListCriteriaForm.fromDate_search.focus();
			return false;
		}

		parent.pathologistWorkListResultFrame.location.href="../jsp/PathologistWorkListResult.jsp?lab_dept_name_search="+lab_dept_name_search+"&order_facility_name_search="+order_facility_name_search+"&ordering_pract_code_search="+ordering_pract_code_search+"&performing_facility_id_search="+performing_facility_id_search+"&patient_id="+Patient_Id+"&reporting_facility_id_search="+reporting_facility_id_search+"&assigned_red_code_search="+assigned_red_code_search+"&specimen_number="+specimen_number+"&fromDate_search="+fromDate_search+"&toDate_search="+toDate_search+"&lab_order_status="+lab_order_status;	


	}
}


function callPatientSearch(target){
	var patient_id = PatientSearch();
		
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
	}
}

function getPerformingFacility1(obj){
	if(obj.value!="")
		getPerformingFacility();
	else{
		document.pathologistWorkListCriteriaFrame.performing_facility_id_name.value ="";
		document.pathologistWorkListCriteriaFrame.performing_facility_id.value = "";	
	}
}
function getPerformingFacility(){
	var performingFacility = document.pathologistWorkListCriteriaForm.performing_facility_id_name.value;
	var retVal=  new String();
	var dialogTop	= "40";
	var dialogHeight= "10" ;
	var dialogWidth= "40" ;
	var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var title= getLabel("Common.PerformingFacility.label","Common");
	var sql="select facility_id code,facility_name description from sm_facility_param where  status='E'  and upper(facility_id) like upper(?) and upper(facility_name) like upper(?)  ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = performingFacility; 
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	retArray = CommonLookup(title,argArray);
	if(retArray != null && retArray !=""){	 
		document.pathologistWorkListCriteriaForm.performing_facility_id_name.value = retArray[1];
		document.pathologistWorkListCriteriaForm.performing_facility_id.value = retArray[0];	
	}
}
function getReportingFactility1(obj){
	if(obj.value!="")
		getReportingFactility();
	else{
		document.pathologistWorkListCriteriaForm.reporting_facility_id_name.value ="";
		 document.pathologistWorkListCriteriaForm.reporting_facility_id.value = "";	
	}
}
function getReportingFactility(){
	var reportingFacility = document.pathologistWorkListCriteriaForm.reporting_facility_id_name.value;
	
	var retVal=  new String();
	var dialogTop	= "40";
	var dialogHeight= "10" ;
	var dialogWidth= "40" ;
	var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var title= getLabel("Common.RepFacility.label","Common");
	var sql="select facility_id code,facility_name description from sm_facility_param where  status='E'  and upper(facility_id) like upper(?) and upper(facility_name) like upper(?)  ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = reportingFacility; 
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	retArray = CommonLookup(title,argArray);
	if(retArray != null && retArray !=""){
		 document.pathologistWorkListCriteriaForm.reporting_facility_id_name.value = retArray[1];
		 document.pathologistWorkListCriteriaForm.reporting_facility_id.value = retArray[0];	
	}
}

function getPractitioner1(obj){
	if(obj.value!="")
		getPractitioner();
	else{
		document.pathologistWorkListCriteriaForm.ordering_pract_desc.value = ""; 
		document.pathologistWorkListCriteriaForm.ordering_pract_code.value = "";
	}
}
function getPractitioner()
{
		var target			= document.pathologistWorkListCriteriaForm.ordering_pract_desc;
		var locale			= document.pathologistWorkListCriteriaForm.locale.value;
		var val				= document.pathologistWorkListCriteriaForm.ordering_facility_name.value;

		var spec_code		= '';
		var sql;
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.OrderingPractitioner.label","Common");
		
		if(val == ""){
			sql ="select a.PRACTITIONER_ID code, a.SHORT_NAME description from am_practitioner_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"' and upper(a.PRACTITIONER_ID) like upper(?) and upper(a.SHORT_NAME) like upper(?)  order by 2";
			}
			else{
			sql="SELECT  a.practitioner_id code, a.short_name description FROM am_practitioner_lang_vw a,am_pract_for_facility b WHERE b.eff_status = 'E' AND language_id ='"+locale+"' AND UPPER (a.practitioner_id) LIKE UPPER (?) AND UPPER (a.short_name) LIKE UPPER (?) AND a.practitioner_id = b.practitioner_id and b.facility_id='"+val+"' ORDER BY 2";
			}
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retArray = CommonLookup( title, argArray )

		if(retArray != null && retArray !=""){
			 document.pathologistWorkListCriteriaForm.ordering_pract_desc.value = retArray[1];
			 document.pathologistWorkListCriteriaForm.ordering_pract_code.value = retArray[0];	
		} 
}

function getAssignedPathologist1(obj){
	if(obj.value!="")
		getAssignedPathologist();
	else{
		document.pathologistWorkListCriteriaForm.assigned_red_desc.value = ""; 
		document.pathologistWorkListCriteriaForm.assigned_red_code.value = "";
	}
}

function getAssignedPathologist()
{
		var target			= document.pathologistWorkListCriteriaForm.assigned_red_desc.value;
		var locale			= document.pathologistWorkListCriteriaForm.locale.value;
		var scode_userselect  = document.pathologistWorkListCriteriaForm.lab_dept_name.value;
		var rpf_userselect = document.pathologistWorkListCriteriaForm.reporting_facility_id.value;

		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var title			= getLabel("Common.Assigned.label","COMMON");
		var sql;
 
		if(rpf_userselect){
			sql= "select sm_appl_user.appl_user_id code, sm_appl_user.appl_user_name description from sm_appl_user, rl_user_dept where sm_appl_user.eff_status = 'E' and sm_appl_user.language_id='"+locale+"' and upper(sm_appl_user.appl_user_id) like upper(?) and upper(sm_appl_user.appl_user_name) like upper(?) and rl_user_dept.SECTION_CODE = '"+scode_userselect+"' and rl_user_dept.OPERATING_FACILITY_ID = '"+rpf_userselect+"' and sm_appl_user.appl_user_id=rl_user_dept.user_id order by 2"; 
		}else if(scode_userselect){
			sql= "select sm_appl_user.appl_user_id code, sm_appl_user.appl_user_name description from sm_appl_user, rl_user_dept where sm_appl_user.eff_status = 'E' and sm_appl_user.language_id='"+locale+"' and upper(sm_appl_user.appl_user_id) like upper(?) and upper(sm_appl_user.appl_user_name) like upper(?) and rl_user_dept.SECTION_CODE = '"+scode_userselect+"' and sm_appl_user.appl_user_id=rl_user_dept.user_id order by 2"; 
		}else{
			sql= "select sm_appl_user.appl_user_id code, sm_appl_user.appl_user_name description from sm_appl_user, rl_user_dept where sm_appl_user.eff_status = 'E' and sm_appl_user.language_id='"+locale+"' and upper(sm_appl_user.appl_user_id) like upper(?) and upper(sm_appl_user.appl_user_name) like upper(?) and sm_appl_user.appl_user_id=rl_user_dept.user_id order by 2"; 
		}

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retArray = CommonLookup(title,argArray);
		if(retArray != null && retArray !=""){
			 document.pathologistWorkListCriteriaForm.assigned_red_desc.value = retArray[1];
			 document.pathologistWorkListCriteriaForm.assigned_red_code.value = retArray[0];	
		}	
}

function chkDateTime(toDate,format,locale)
{
	
	if(toDate.value != '') 
	{		
		var from_date = document.getElementById("date_from");
		var to_date = document.getElementById("date_to");
		
			if(validDateObj(toDate,format,locale))
		{			
			
			if(from_date.value != "" || to_date.value != "" )
			{
				chkToDate(from_date,to_date,format,locale);
			}
			
		}
	}
	
	
}
function chkToDate(fromDate,toDate,format,locale)
{	
	var max_days=daysBetween(fromDate.value,toDate.value,"DMY",locale.value);
      
	  	if( max_days>30)
			{
			errors=getMessage('DATE_MORE_THAN_30_DAYS','BT');
			alert(errors);
			toDate.select();
			toDate.focus();
			return false;
			}
	if(fromDate.value != "")
	{		
		if(!isBeforeNow(fromDate.value,format,locale))
		{
			alert(getMessage("GREATER_THAN_SYS_DATE","BT")); 
			fromDate.select();
			fromDate.focus();
			fromDate.value="";
			return false;
				
		}else{ 
		  if( toDate.value != ""){
				if(isBeforeNow(toDate.value,format,locale))
				{
					if(isAfter(toDate.value,fromDate.value, format, locale))
						return true;
					else
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","BT")); 
						toDate.select();
						toDate.focus();
						return false;
					}
					
					
				}else{
					alert(getMessage("GREATER_THAN_SYS_DATE","BT")); 
					toDate.select();
					toDate.focus();
					return false;
				}
			}
		
		}
	}else{	
	
		document.pathologistWorkListCriteriaForm.date_from.value= document.pathologistWorkListCriteriaForm.current_date.value;
		if((toDate.value!=""))
		{
			if(!isBeforeNow(toDate.value, format, locale)){
				alert(getMessage("GREATER_THAN_SYS_DATE","BT"));
				toDate.select();
				toDate.focus();
				return false;
			}
		}
		
		
	}

}



