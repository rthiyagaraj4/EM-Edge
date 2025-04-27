 //saved on 02.11.2005
function run() {	
	var frmObject = f_query_add_mod.document.formPhLateAdminDtlCriteria;
	var locale = frmObject.locale.value;
	if(f_query_add_mod.document.formPhLateAdminDtlCriteria) {
		var fields= new Array (frmObject.dt_from_disp,frmObject.dt_to_disp, frmObject.locn_type,frmObject.locn_name); // ML-BRU-SCF-0498 [IN035593]
		var names= new Array (getLabel("Common.DateFrom.label","Common"),getLabel("Common.DateTo.label","Common"),getLabel("Common.locationtype.label","Common"),getLabel("Common.Location.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.ValidateDateTime( f_query_add_mod.document.formPhLateAdminDtlCriteria.dt_from_disp, f_query_add_mod.document.formPhLateAdminDtlCriteria.dt_to_disp, messageFrame ) ) {
				if(locale !='en'){
					frmObject.dt_from.value=convertDate(frmObject.dt_from_disp.value,'DMYHM',locale,'en');
					frmObject.dt_to.value=convertDate(frmObject.dt_to_disp.value,'DMYHM',locale,'en');
				}
				else{
					frmObject.dt_from.value=frmObject.dt_from_disp.value;
					frmObject.dt_to.value=frmObject.dt_to_disp.value;
				}
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.formPhLateAdminDtlCriteria.submit();
			}
		}
	}
}

function reset() {
/*	searchFrame.formPhRepDrugsByGenName.reset();*/
    f_query_add_mod.formPhLateAdminDtlCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage()	{
	var result	=	false;
	frm_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_from_disp;
	to_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_to_disp;
	msg_frame		=	messageFrame;

	if(doDateCheck(frm_obj,to_obj,msg_frame) ){
      result	=	true;
	}
	else{
		result  = false;
	}
	return result;
}


async function searchCode( target ) {
    var language_id=document.formPhLateAdminDtlCriteria.locale.value;

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	argumentArray[0] = f_query_add_mod.document.formPhLateAdminDtlCriteria.SQL_PH_MED_ADMIN_SELECT2.value+"'"+language_id+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value; 
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retArray = await CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );

	if(retArray != null && retArray != "" ) {
		var ret1=unescape(retArray);
				arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				}
		target.value = arr[0];	/* if code need to be returned */
		target.focus();
	}
}

async function callDrugSearch(obj) {
	var arrCodeDesc = await DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}

function GoBack() {
	alert(getMessage("PH_MEDN_ADM_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}

/*function ValidateFrom(from,to) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than Current Time");
	to.select();
	result	=	false;
	}

return result;
}*/

function ValidateFrom(from,to,en) {
	var result	=	true;
	if(to.value!="") {
		if(!doDateTimeChk(to))
			{
			alert(getMessage("INVALID_DATE_TIME","PH"));
			to.focus;
			}
		else
		if(!ValidateDateTime(from,to)) {
			alert(getMessage("SHOULD_BE_GREATER_THAN_CURRENT_TIME","PH"));
			to.select();
			result	=	false;
		}
		else{
			if(!ValidateDateTime(to,en)) {
				alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
				to.select();
				result	=	false;
			}
		}
	}
	return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
	if(to.value!=""){
		if(!doDateTimeChk(to)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			to.focus;
		}
		else
			if(!ValidateDateTime(from,to)) {
			alert(getMessage("SHOULD_BE_GREATER_THAN_FROM_TIME","PH"));
			to.select();
			to.focus();
			result	=	false; 
		}
		else{
			if(!ValidateDateTime(to,en)) {
				alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
				to.select();
				result	=	false;
				to.focus();
			}
		}
	}
	return result;
}

async function searchCode(target,objIdentify){
	var p_admin_by = document.formPhLateAdminDtlCriteria.p_admin_by;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0] = "LANGUAGE_ID";
	dataValueArray[0]= document.getElementById("locale").value;
	dataTypeArray[0] = STRING;	
	argumentArray[0]   = document.formPhLateAdminDtlCriteria.SQL_PH_MED_ADMIN_APPL_USERS.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	var retVal = await CommonLookup(getLabel("Common.AdministeredBy.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		var ret1=unescape(retVal);
				arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				}
		target.value = arr[1] ;
		p_admin_by.value = arr[0] ;
	}	
}

//for patient lookup
async function callPatientSearch(target){
	var patient_id = await PatientSearch();
	if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
	}
	chkPatientID(patient_id);
}
//  added below functions for ML-BRU-SCF-0498 [IN035593]
function chkPatientID(patient_id){
	var formObj=document.formPhLateAdminDtlCriteria;
	if(patient_id == undefined)
		patient_id = formObj.p_patient_id.value;
	if (patient_id!= "" ){
		formObj.p_patient_id.value = patient_id;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="";
		xmlStr ="<root><SEARCH " ;
		xmlStr+= "bean_id  ='PHReportsBean' " ;
		xmlStr+= "bean_name = 'ePH.PHReportsBean' " ;
		xmlStr		    += " patient_id=\""+ patient_id + "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReportsValidate.jsp?called_from=patientsearch", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	} 
}

function chkpatID(yes_no){
	var frmObj = "";
	formObj=document.formPhLateAdminDtlCriteria;
	if(yes_no == "N"){
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		formObj.p_patient_id.value="";
		formObj.p_patient_id.focus();
	}
	
}//  adding ML-BRU-SCF-0498 [IN035593]-end

function doDateChk(obj){
	if(obj.value != ""){
		if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1){
			retval= false
			alert(getMessage("INVALID_DATE_TIME","PH"))
			 obj.focus()
		}
		else{
			var comp=obj
			obj=obj.value
			var dttime = obj.split(" ");
			var dt
			var time
			var retval=true
			if(dttime.length>1){
				dt=dttime[0]
				time=dttime[1]

				if(!checkDt(dt) ){
					retval= false							
					alert(getMessage("INVALID_DATE_TIME","PH"))
					comp.focus()
				}
				else{
					if(time==null || time==""){
						alert(getMessage("INVALID_DATE_TIME","PH"))
						retval= false;
						comp.focus()
					}
					else{
						if(!chkTime(time)){
							retval= false										
							alert(getMessage("INVALID_DATE_TIME","PH"))
							comp.focus()
						}
					}
				}
			}
			else{ 
				retval= false
				alert(getMessage("INVALID_DATE_TIME","PH"))
				comp.focus()
			 }  
			if(retval){
				//callDateFunction(comp)
			}
		}
		return retval
	}	
} 

// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhLateAdminDtlCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMYHM',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMYHM',locale,'en');
	}
	ValidateFromDt();
}

function ValidateFromDt(){
	var from_date=document.formPhLateAdminDtlCriteria.dt_from_disp.value;
	var to_date=document.formPhLateAdminDtlCriteria.dt_to_disp.value;
	var locale=document.formPhLateAdminDtlCriteria.locale.value;
	if(from_date!='' && to_date !='' ){
		if(!isBefore(from_date,to_date, "DMYHM",locale)){
			alert(getMessage("FROM_DATE_LESS_EQ_TO_DT", "PH"));
			document.formPhLateAdminDtlCriteria.dt_to_disp.value=from_date;
			document.formPhLateAdminDtlCriteria.dt_to_disp.focus();
		}
	}
}
//Added for scf ML-BRU-SCF-0498 [IN:035593] -- begin
function resetLocation(){
	var formObj = document.formPhLateAdminDtlCriteria;
	formObj.locn_code.value="";
	formObj.locn_name.value="";
}

async function locationLookup(target){
	var formObj = document.formPhLateAdminDtlCriteria;
	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT2.value)+"'"+formObj.locale.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				var ret1=unescape(retVal)
                var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				}
				formObj.locn_code.value=arr[0];
				target.value = arr[1] ;
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
				var ret1=unescape(retVal)
                var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				}
				formObj.locn_code.value=arr[0];
				target.value = arr[1] ;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
}
//Added for scf ML-BRU-SCF-0498 [IN:035593] -- end
 
function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.formPhLateAdminDtlCriteria.p_patient_id.value; 
	if(patientId != null && patientId !=""){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;
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

function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.formPhLateAdminDtlCriteria.p_patient_id.value=main_patientid;  
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
// code added for ML-BRU-SCF- 1536 start
async function locationLookupForChart(target){
	var formObj = document.formPhLateAdminDtlCriteria;
	var locn_type=formObj.locn_type.value;
	var facility_id=formObj.p_facility_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT2.value)+"'"+formObj.locale.value+"'"+" AND FACILITY_ID = '"+facility_id+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				var ret1=unescape(retVal)
                var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				}
				formObj.locn_code.value=arr[0];
				target.value = arr[1] ;
			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT1.value)+"'"+formObj.p_language_id.value+"'"+" AND FACILITY_ID = '"+facility_id+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.clinic.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				var ret1=unescape(retVal)
                var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				}
				formObj.locn_code.value=arr[0];
				target.value = arr[1] ;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
}
// code added for ML-BRU-SCF- 1536 end 
