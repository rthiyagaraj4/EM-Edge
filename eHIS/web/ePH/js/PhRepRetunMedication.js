function run() {
	var frmObject = f_query_add_mod.document.formRepReturnMednCriteria;
	if (f_query_add_mod.document.formRepReturnMednCriteria) {
		locale = frmObject.p_language_id.value;
		var fields=new Array();
		var names=new Array();
		fields[0]=frmObject.frm_date;
		fields[1]=frmObject.to_date;
		names[0]=getLabel("ePH.ReturnDateFrom.label","PH");
		names[1]=getLabel("ePH.ReturnDateTo.label","PH");
		var rep_type = frmObject.p_rep_type.value;
		if(rep_type == 'S'){
			fields[2]=frmObject.p_return_Reason_code;
			names[2]=getLabel("Common.Return.label","Common")+" "+getLabel("Common.reason.label","Common");
			frmObject.p_report_id.value='PHRRETSUM'
		}
		else{
			fields[2]=frmObject.p_patient_id;
			names[2]=getLabel("Common.patientId.label","Common");
			frmObject.p_report_id.value='PHRRETDTL'
		}
		if (checkFields(fields, names, messageFrame)) {
			var len =frmObject.p_form_code.options.length;
			var p_form_code = frmObject.p_form_code.options;
			var p_where ="", form_codes="";
			var selCount=0;
			for (var i=0; i<len; i++) {
				opt = p_form_code[i];
				if (opt.selected) {
					if(selCount==0)
						form_codes = form_codes+"'"+opt.value+"'";
					else
						form_codes = form_codes+", "+"'"+opt.value+"'";
					selCount++;
				}
			}
			if(selCount>40){
				messageFrame.document.location.href = '../../eCommon/jsp/error.jsp?err_num='+getMessage("PH_MAX_FORM_SELECT_ALLOWED", "PH");
				return false;
			}
			if(selCount>0)
				p_where = p_where.concat('and c.form_code in('+form_codes+' ');
			frmObject.p_where.value=p_where;
			frmObject.p_frm_date.value=convertDate(frmObject.frm_date.value,'DMY',locale,"en");
			frmObject.p_to_date.value=convertDate(frmObject.to_date.value,'DMY',locale,"en");
			if(dateCheckWithCurrDate('F') && dateCheckWithCurrDate('T') && validateProcessDt())
				var p_return_Reason_desc = frmObject.p_return_Reason_desc.value;
				frmObject.p_return_Reason_desc.value="";
				frmObject.action = "../../eCommon/jsp/report_options.jsp";
				frmObject.target = "messageFrame";
				frmObject.submit();
				frmObject.p_return_Reason_desc.value=p_return_Reason_desc;
		}
	}
}

function CheckDateT(obj){
	var locale=document.formRepReturnMednCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			return false;
		}
	}
	else {
		obj.value = convertDate(obj, 'DMY', locale, 'en');
	}
	return true;
}

function reset() {
	f_query_add_mod.formRepReturnMednCriteria.reset();
	f_query_add_mod.formRepReturnMednCriteria.img_mand_retReason.style.display='inline'
	f_query_add_mod.formRepReturnMednCriteria.img_mand_pat_id.style.display='none'
	messageFrame.document.location.href = '../../eCommon/jsp/error.jsp';
}

function dispMandImg(objRepType){
	var rep_type = objRepType.value;
	if(rep_type == 'S'){
		document.formRepReturnMednCriteria.img_mand_retReason.style.display='inline'
		document.formRepReturnMednCriteria.img_mand_pat_id.style.display='none'
		document.formRepReturnMednCriteria.p_report_id.value='PHRRETSUM'
	}
	else{
		document.formRepReturnMednCriteria.img_mand_retReason.style.display='none'
		document.formRepReturnMednCriteria.img_mand_pat_id.style.display='inline'
		document.formRepReturnMednCriteria.p_report_id.value='PHRRETDTL'
	}
}


function Duplicatecheck(){
	var formObj = document.formRepReturnMednCriteria;
	var patientId = formObj.p_patient_id.value; 
	if((patientId != null) && (patientId !="")){
		var	bean_id			= formObj.bean_id.value;
		var	bean_name		= formObj.bean_name.value;
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;
		xmlStr+= "chkPatientID=\"false\" " ;		
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReportsValidate.jsp?called_from=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}		
} 

function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.formRepReturnMednCriteria.p_patient_id.value=main_patientid;    
}

function validateProcessDt(){
	var frmObject = document.formRepReturnMednCriteria;
	if(frmObject == null || frmObject == undefined)
		frmObject = f_query_add_mod.document.formRepReturnMednCriteria;
	var from =frmObject.frm_date ;
	var to= frmObject.to_date ;
	var sysdt= frmObject.sysdate;
	var fromarray;
	var toarray;
	var fromdate1 = from.value ;
	var todate1 = sysdt.value ;
	var todt= to.value;
	if(fromdate1.length > 0 && todt.length > 0 ){
		fromarray = fromdate1.split("/");
		toarray = todt.split("/");
		var fromdat = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todat = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(fromdat) > Date.parse(todat)){
			var msg=alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
			frmObject.to_date.value="";
			frmObject.to_date.focus();
			return false;								
		}
		else if(Date.parse(todat) <= Date.parse(fromdat));
			return true;
	}
}

function dateCheckWithCurrDate(callFrom){
	var frmObject = document.formRepReturnMednCriteria;
	var msgFrame = parent.messageFrame;
	if(frmObject == null || frmObject == undefined)
		frmObject = f_query_add_mod.document.formRepReturnMednCriteria;
	if(msgFrame == null || msgFrame == undefined)
		msgFrame = messageFrame;

	var chkDate ="";
	var currDate= frmObject.sysdate.value;
	var locale= frmObject.p_language_id.value;
	var errors ="";
	if(callFrom=='F')
		chkDate = frmObject.frm_date.value ;
	else
		chkDate = frmObject.to_date.value ;
	if(chkDate.length > 0 && currDate.length > 0 ){   
		if(!isBefore(chkDate,currDate,"DMY",locale)) {				
			if(callFrom=='F'){
				frmObject.frm_date.value="";
				errors=getMessage("FROM_DATE_LESS_THAN_SYSDATE","PH") ;
			}
			else{
				frmObject.to_date.value="";
				errors=getMessage("TO_DATE_LESS_THAN_SYSDATE","PH") ;
			}
			msgFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
		}
		else{
			msgFrame.location.href = "../../eCommon/jsp/error.jsp?";
			return true;
		}
	}		
	return false;
}	

async function searchReasonCode(callFrom) {
	var frmObject = document.formRepReturnMednCriteria;
	if(callFrom == 'DESC' && trimString(frmObject.p_return_Reason_desc.value)==''){
		frmObject.p_return_Reason_code.value="";
		frmObject.p_return_Reason_desc.value="" ;
		return false;
	}
	var locale= frmObject.p_language_id.value;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	dataNameArray[0]	= "appl_trn_type" ;
	dataValueArray[0]	= 'T';
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "language_id" ;
	dataValueArray[1]	= locale;
	dataTypeArray[1]	= STRING ;
	
	argumentArray[0] =frmObject.SQL_PH_MEDN_RETUN_REASON_SELECT.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "3,4";
	argumentArray[5] = frmObject.p_return_Reason_desc.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	
	retArray =await CommonLookup( getLabel("ePH.ReasonCodes.label","PH"), argumentArray );
	frmObject.p_return_Reason_code.value="";
	frmObject.p_return_Reason_desc.value="" ;
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray != "" )  {
 		frmObject.p_return_Reason_code.value=arr[0] ;
		frmObject.p_return_Reason_desc.value=arr[1] ;
	}
}

async function callPatientSearch(){
	var formObj = document.formRepReturnMednCriteria;
	var patient_id =await PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
	}
}
