//Added for MMS-DM-CRF-0029 [IN055150]
function reset() {
	f_query_add_mod.document.formPhSaleOrReturnReportCriteria.reset();	
}

function run(){
	
	 var frm_obj		=	 f_query_add_mod.document.formPhSaleOrReturnReportCriteria;
	 
	 var fields= new Array (frm_obj.p_period_fm,frm_obj.p_period_t);
	 var names= new Array (getLabel("ePH.BillFromDate.label","PH"),getLabel("ePH.BillToDate.label","PH"));
	 	if(checkFields(fields,names,messageFrame)) {
	 	
	 	if(!isBefore(frm_obj.p_period_t.value,frm_obj.sys_date.value,"DMY",frm_obj.p_language_id.value)) {				
				var	errors=getMessage("TO_DATE_LESS_THAN_SYSDATE","PH") ;
				alert(errors);
				return false;
			}
	 if(!isBefore(frm_obj.p_period_fm.value,frm_obj.p_period_t.value,"DMY",frm_obj.p_language_id.value)) {
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
				alert(errors);
				return false;			
		}
	 var max_days=daysBetween(frm_obj.p_period_fm.value,frm_obj.p_period_t.value,"DMY",frm_obj.p_language_id.value);
					
			if(max_days>31){
				var errors=getMessage('PH_BILLDATE_DIFFERENCE','PH');
				alert(errors);
				return false;
			}
				
	
	 
		
	 var rep_type = frm_obj.p_report_type.value;
		if(rep_type == 'SAL'){
			frm_obj.p_report_id.value='PHBLSALS';
		}
		else if(rep_type == 'RET'){
			//frm_obj.p_report_id.value='PHBLRETS';
			frm_obj.p_report_id.value='PHBLSALOUT';
			
		}
		
		else{
			frm_obj.p_report_id.value='PHBLSALRET';
		}
			var p_where ="", form_codes="";
		
		if(frm_obj.p_op_yn.value == 'Y'){
			form_codes = form_codes+"'O'";
		}
		if(frm_obj.p_op_yn.value == 'Y' && frm_obj.p_ip_yn.value == 'Y'){
			form_codes = form_codes+",'I'";
		}
		else{
			if(frm_obj.p_ip_yn.value == 'Y')form_codes = form_codes+"'I'";
		}
		if((frm_obj.p_op_yn.value == 'Y' || frm_obj.p_ip_yn.value == 'Y') && frm_obj.p_em_yn.value == 'Y'){
			form_codes = form_codes+",'E'";
		}
		else{
			if(frm_obj.p_em_yn.value == 'Y')form_codes = form_codes+"'E'";
		}
		if( (frm_obj.p_op_yn.value == 'Y' || frm_obj.p_ip_yn.value == 'Y' || frm_obj.p_em_yn.value == 'Y')&& frm_obj.p_dc_yn.value == 'Y'){
			form_codes = form_codes+",'D'";
		}
		else{
			if(frm_obj.p_dc_yn.value == 'Y')form_codes = form_codes+"'D'";
		}
		if(form_codes == ""){
		var errors=getMessage('PH_EPISODE_TYPE_SELECT','PH');
			alert(errors);
			return false;	
		}
		else{
		p_where=form_codes;
		}
		
		//alert("hello"+p_where);
		frm_obj.p_episode_type.value= p_where;
	    frm_obj.p_from_date.value = convertDate(frm_obj.p_period_fm.value,'DMY',frm_obj.p_language_id.value,'en');
	    frm_obj.p_to_date.value = convertDate(frm_obj.p_period_t.value,'DMY',frm_obj.p_language_id.value,'en');
	    frm_obj.submit();
	 } 
	}
function validationChecking(obj){
	
	var frm_obj		=	 f_query_add_mod.document.formPhSaleOrReturnReportCriteria;
	 
}


function callPatientSearch(){
	var formObj = document.frames.formPhSaleOrReturnReportCriteria;
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
	}
}

function Duplicatecheck(){   
	var patientId = document.formPhSaleOrReturnReportCriteria.patient_id.value;
	if((patientId.value != null) && (patientId.value !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId.value + "\" " ;	
		xmlStr+= "chkPatientID=\"true\" " ;	
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}	
}

function assignValues(obj){
	
	if(obj.checked){
		
		obj.value='Y';
	}
	else{
		
		obj.value='N';
	}
	
	
}

