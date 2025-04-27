function reset() {
	f_query_add_mod.document.formDiscontinueOrdersReportCriteria.reset();	
}

function run(){
 var frm_obj		=	 f_query_add_mod.document.formDiscontinueOrdersReportCriteria;
 var fields= new Array (frm_obj.p_period_fm,frm_obj.p_period_t);
 var names= new Array (getLabel("ePH.OrderFromDate.label","PH"),getLabel("ePH.OrderToDate.label","PH"));
	
	if(checkFields(fields,names,messageFrame)) {
 if(!isBefore(frm_obj.p_period_fm.value,frm_obj.p_period_t.value,"DMY",frm_obj.p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
	}
    frm_obj.p_period_from.value = convertDate(frm_obj.p_period_fm.value,'DMY',frm_obj.p_language_id.value,'en');
    frm_obj.p_period_to.value = convertDate(frm_obj.p_period_t.value,'DMY',frm_obj.p_language_id.value,'en');
    frm_obj.submit();
 } 
}

function CheckDateT(obj){
	var locale=document.formDiscontinueOrdersReportCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else if(obj.value=="")
		return false;
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}

function locationLookup(target){
	var formObj = document.frames.formDiscontinueOrdersReportCriteria;
	if(formObj==undefined)
		var formObj = searchFrame.document.frames.formDiscontinueOrdersReportCriteria;
	var locn_type=formObj.p_locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT2.value)+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.p_locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT1.value)+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.clinic.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.p_locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
		}
	}else{
		formObj.p_locn_code.focus();
	}
} 

function callPatientSearch(){
	var formObj = document.frames.formDiscontinueOrdersReportCriteria;
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
	}
}

function Duplicatecheck(){   
	var patientId = document.formDiscontinueOrdersReportCriteria.patient_id.value;
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

function clearLocation(obj){
	if(obj.val!==''||obj.val != null)
		document.formDiscontinueOrdersReportCriteria.p_locn_name.value="";
	    document.formDiscontinueOrdersReportCriteria.p_locn_code.value="";
}
