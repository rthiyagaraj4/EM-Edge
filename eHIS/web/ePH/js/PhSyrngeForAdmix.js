  //saved on 02.11.2005

function run() 
{
	var frmObject = f_query_criteria.document.formPhSyrngForAdmixCriteria;
	var fields = new Array (frmObject.p_patient_id,frmObject.p_date,frmObject.p_patient_class,frmObject.p_disp_no);


	var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("ePH.DispensedDate.label","PH"),getLabel("Common.patientclass.label","Common"),getLabel("ePH.DispenseNo.label","PH"));
   frmObject.p_date.value=convertDate(frmObject.p_date1.value,"DMY",frmObject.locale.value,"en"); 
	if(checkFields(fields,names,messageFrame)) 
	{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_criteria.document.formPhSyrngForAdmixCriteria.submit();
	}
}

function reset() 
{
	var formObj = f_query_criteria.document.formPhSyrngForAdmixCriteria;
	f_query_criteria.location.reload();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

//for patient lookup
async function callPatientSearch(target){
	var patient_id =await PatientSearch();
	 if(patient_id != null && patient_id != "" )  
		{			
		 target.value = patient_id;
		 }
		}

async function searchPractitionerName(target, mode) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= f_query_add_mod.document.formPhMednStatByPractCriteria.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_add_mod.document.formPhMednStatByPractCriteria.p_facility_code.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= f_query_add_mod.document.formPhMednStatByPractCriteria.p_facility_code.value;
	dataTypeArray[2]	= STRING ;

	argumentArray[0] = f_query_add_mod.document.formPhMednStatByPractCriteria.sql_ph_medn_stat_pract_select1.value+"'"+f_query_add_mod.document.formPhMednStatByPractCriteria.language_id.value+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	var retArray =await CommonLookup(getLabel("ePH.PractitionerSearch.label","PH"), argumentArray );
	var str =unescape(retArray);
	var arr = str.split(",");

	//var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
	
	ePH.PractitionerSearch.label
	
	if(retArray != null && retArray != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhMednStatByPractCriteria.pract_id.value = arr[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_id.value = arr[0];

		target.value = arr[1];
	}
}

function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	history.go(-1);
}

function checkPatientClass(p_disp_no)	{
	var frmObject = parent.f_query_criteria.document.formPhSyrngForAdmixCriteria;
		var disp_no		=	frmObject.p_disp_no.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " disp_no=\""+p_disp_no+"\"";
		xmlStr += " bean_id=\"DispMedicationAllStages\"";
		xmlStr += " bean_name=\"ePH.DispMedicationAllStages\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidation.jsp?func_mode=get_pat_class",false);
//		alert(xmlStr);
		xmlHttp.send(xmlDoc);
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
}

function assignPatientClass(pat_class) {
	var frmObject	= parent.f_query_criteria.document.formPhSyrngForAdmixCriteria;
	var result		= pat_class.split("::");
	frmObject.p_patient_id.value=result[1];
}

function populateSyrngDispNo() {	
	var frmObject		=   parent.f_query_criteria.document.formPhSyrngForAdmixCriteria;
	var p_date="";
	var p_patient_id	=	frmObject.p_patient_id.value;
	var locale			=	frmObject.locale.value;
	var p_date			=	frmObject.p_date1.value;
    p_date=convertDate(p_date,"DMY",locale); 
	var p_patient_class		=	frmObject.p_patient_class.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_patient_id=\""+p_patient_id+"\"";
	xmlStr += " p_disp_date=\""+p_date+"\"";
	xmlStr += " p_patient_class=\""+p_patient_class+"\"";
	xmlStr += " bean_id=\"PHRepDispStatisByDispBean\"";
	xmlStr += " bean_name=\"ePH.PHRepDispStatisByDispBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ReportsValidate.jsp?called_from=populateSyrngDispNo",false);
	//alert(xmlStr);
	xmlHttp.send(xmlDoc);
//	alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);

}

function loadDispNos(disp_no) {
	
		var element			= document.createElement('OPTION') ;
		element.value		=  disp_no ;
		element.text		=  disp_no ;
		document.formPhSyrngForAdmixCriteria.p_disp_no.add(element);	
	
}

function clearDispNos(){
	var len =document.formPhSyrngForAdmixCriteria.p_disp_no.options.length;
	for(var i=0;i<len;i++) {
		document.formPhSyrngForAdmixCriteria.p_disp_no.remove("p_disp_no") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---"; 
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formPhSyrngForAdmixCriteria.p_disp_no.add(opt);
}

// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhSyrngForAdmixCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
		document.formPhSyrngForAdmixCriteria.p_date.value = obj.value;
	}
}
 
function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.formPhSyrngForAdmixCriteria.p_patient_id.value; 
	if( (patientId != null) && (patientId !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;	
		xmlStr+= "chkPatientID=\"false\" " ;
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

function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.formPhSyrngForAdmixCriteria.p_patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
