function reset() {
    f_query_criteria.formMedicalItemLabelCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	//parent.content.commontoolbarFrame.document.CommonToolbar_form.run.disabled = true;
	setTimeout("disableRun('R');",150);
}

async function callPatientSearch(target){
	var patient_id =await PatientSearch();
	if(patient_id != null && patient_id != "" )  {		
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

	retArray =await CommonLookup(getLabel("ePH.PractitionerSearch.label","PH"), argumentArray );
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhMednStatByPractCriteria.pract_id.value = arr[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_id.value = arr[0];

		target.value = arr[1];
	}
}

async function callDrugSearch(obj) {
	var arrCodeDesc =await DrugSearch("D",obj);
	var str =unescape(arrCodeDesc);
	var arr = str.split(",");
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arr[0];
		obj.value =	arr[1];
	}
}

function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}

function ValidateFrom(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
		alert(getMessage("SHOULD_BE_GREATER_THAN_CURRENT_TIME","PH"));
		to.select();
		result	=	false;
	}
	else{
		if(!ValidateDateTime(to,en)) {
			alert(getmessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
        	to.select();
			result	=	false;
		}
	}
	return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
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
	return result;
}

function checkPatientClass(p_disp_no)	{
	var frmObject = parent.f_query_criteria.document.formMedicalItemLabelCriteria;
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
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function assignPatientClass(pat_class) {
	var frmObject	= parent.f_query_criteria.document.formMedicalItemLabelCriteria;
	var loc_lang	= frmObject.label_language.value;
	var result		= pat_class.split("::");
	frmObject.p_patient_id.value=result[1];
}

function defaultLocalLanguage(formObj){
	var xmlStr ="<root><SEARCH ";
	xmlStr += " patient_class=\""+formObj.value+"\"";
	xmlStr += " bean_id=\"DispMedicationAllStages\"";
	xmlStr += " bean_name=\"ePH.DispMedicationAllStages\"";
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=getLocalLanguage";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);	
}

function populateDispNo() {	
	var frmObject		=   parent.f_query_criteria.document.formMedicalItemLabelCriteria;
	var p_disp_date	="";
	var p_patient_id	=	frmObject.p_patient_id.value;
	if(p_patient_id=="")
		return false;
	var locale	=	frmObject.locale.value;
	var stage	=	frmObject.stage.value;
	p_disp_date		=	frmObject.p_dispense_date.value;
	p_disp_date=convertDate(p_disp_date,"DMY",locale); 
	frmObject.p_disp_date.value=p_disp_date;
	var p_pat_class		=	frmObject.p_pat_class.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_patient_id=\""+p_patient_id+"\"";
	xmlStr += " p_disp_date=\""+p_disp_date+"\"";
	xmlStr += " p_pat_class=\""+p_pat_class+"\"";
	xmlStr += " stage=\""+stage+"\"";
	xmlStr += " bean_id=\"PHRepDispStatisByDispBean\"";
	xmlStr += " bean_name=\"ePH.PHRepDispStatisByDispBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ReportsValidate.jsp?called_from=populateMedicalItemDispNo",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function setDispNos(fm_disp_no,to_disp_no,disp_nos) {
	document.formMedicalItemLabelCriteria.p_disp_fm_no.value=fm_disp_no;
	document.formMedicalItemLabelCriteria.p_disp_to_no.value=to_disp_no;
}

function loadDispNos(disp_no) {
	var element			= document.createElement('OPTION') ;
	element.value		=  disp_no ;
	element.text		=  disp_no ;
	document.formMedicalItemLabelCriteria.p_disp_no.add(element);	
}

function SetLabelLang(label_lang){
	if(label_lang=='L'){
        document.formMedicalItemLabelCriteria.label_language.selectedIndex=2;
	}
	else {
        document.formMedicalItemLabelCriteria.label_language.selectedIndex=1;
	}
}

function clearDispNos(){
	var len =document.formMedicalItemLabelCriteria.p_disp_no.options.length;
	for(var i=0;i<len;i++) {
		document.formMedicalItemLabelCriteria.p_disp_no.remove("p_disp_no") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formMedicalItemLabelCriteria.p_disp_no.add(opt);
}

function setStage(obj){
	var len =document.formMedicalItemLabelCriteria.stage.options.length;
	for(var i=0;i<len;i++) {
		document.formMedicalItemLabelCriteria.stage.remove("stage") ;
	}
	if(obj.value == "IP"){
		document.formMedicalItemLabelCriteria.p_patient_class.value = "IP";
		var opt = document.createElement("OPTION") ;
		opt.text = "---"+getLabel("ePH.Filling.label","PH")+"---";
		opt.value = "F" ;
		document.formMedicalItemLabelCriteria.stage.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text =  "---"+getLabel("ePH.Delivery.label","PH")+"---";
		opt.value = "D" ;
		document.formMedicalItemLabelCriteria.stage.add(opt);
	}
	else if(obj.value == "OP" ||obj.value == "XT"){
		document.formMedicalItemLabelCriteria.p_patient_class.value = "OP";
		var opt = document.createElement("OPTION") ;
		opt.text = "---"+getLabel("ePH.Allocation.label","PH")+"---";
		opt.value = "A" ;
		document.formMedicalItemLabelCriteria.stage.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text =  "---"+getLabel("ePH.Delivery.label","PH")+"---";
		opt.value = "D" ;
		document.formMedicalItemLabelCriteria.stage.add(opt);
	}
	else if(obj.value == "XT"){
		document.formMedicalItemLabelCriteria.p_patient_class.value = "XT";
		var opt = document.createElement("OPTION") ;
		opt.text = "---"+getLabel("ePH.Allocation.label","PH")+"---";
		opt.value = "A" ;
		document.formMedicalItemLabelCriteria.stage.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text =  "---"+getLabel("ePH.Delivery.label","PH")+"---";
		opt.value = "D" ;
		document.formMedicalItemLabelCriteria.stage.add(opt);
	}
}

function printReports() {
	var frmObject = document.formMedicalItemLabelCriteria;
	var label_language1	= 	frmObject.label_language1.value;
	if(frmObject.p_patient_id.value=="" || frmObject.p_dispense_date.value=="") {
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("DISP_DT_OR_PATIENT_ID_NOT_BLANK","PH") ;
	} 
	else if(frmObject.p_disp_fm_no.value!="" && frmObject.p_disp_to_no.value!=""){
		var loc_lang	=	frmObject.label_language.value;
		if(loc_lang=="") 
			loc_lang="E";
		var stage		=	frmObject.stage.value;
		var p_disp_no =	frmObject.p_disp_no.value;
		
		if(p_disp_no==""){//added for CRF-394/02[47518] start
			var len =frmObject.p_disp_no.options.length;
			for(var i=1; i < len;i++) {
				if(i == parseInt(len-1))
					p_disp_no += document.formMedicalItemLabelCriteria.p_disp_no.options[i].value ;
				else
					p_disp_no += document.formMedicalItemLabelCriteria.p_disp_no.options[i].value+'~';
			}
		}//added for CRF-394/02[47518] end	
		if(stage == "F" || stage == "A"){
			frmObject.p_report_id.value="PHPRDISLBFILL";
		}
		else if(stage == "D"){
			if(frmObject.p_pat_class.value=="IP" )
				frmObject.p_report_id.value="PHPRDISLB_AL_IP";				
			else if((frmObject.p_pat_class.value=="OP")||(frmObject.p_pat_class.value=="XT")) 
				frmObject.p_report_id.value="PHPRDISLB_AL_OP";
		}
		var p_report_id		= frmObject.p_report_id.value;
		var p_user_name		= frmObject.p_user_name.value;
		var p_facility_id	= frmObject.p_facility_id.value;
		var p_patient_id	= frmObject.p_patient_id.value;
		var p_patient_class = frmObject.p_patient_class.value;
		var p_language_id   = frmObject.p_language_id.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " p_report_id=\""+p_report_id+"\"";
		xmlStr += " p_disp_no=\""+p_disp_no+"\"";
		xmlStr += " p_user_name=\""+p_user_name+"\"";
		xmlStr += " p_facility_id=\""+p_facility_id+"\"";
		xmlStr += " p_patient_id=\""+p_patient_id+"\"";
		xmlStr += " p_patient_class=\""+p_patient_class+"\"";
		xmlStr += " p_language_id=\""+p_language_id+"\"";
		xmlStr += " stage=\""+stage+"\"";
		xmlStr += " bean_id=\"PHRepDispStatisByDispBean\"";
		xmlStr += " bean_name=\"ePH.PHRepDispStatisByDispBean\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ReportsValidate.jsp?called_from=print_disp_lables",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		if(result == 'Y'){
			alert(getMessage("REPORT_SUBMITTED","PH"));
		}
	}
	else {
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	}
	setTimeout("disableRun();",150);
}

function viewLabels() {
	var frmObject = document.formMedicalItemLabelCriteria;
	var label_language1	= 	frmObject.label_language1.value;
	if(frmObject.p_patient_id.value=="" || frmObject.p_dispense_date.value=="") {
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("DISP_DT_OR_PATIENT_ID_NOT_BLANK","PH");
	} 
	else if(frmObject.p_disp_fm_no.value!="" && frmObject.p_disp_to_no.value!=""){
		var loc_lang	=	frmObject.label_language.value;
		if(loc_lang=="") 
			loc_lang="E";
		var stage	=	frmObject.stage.value;	
		if(stage == "F" || stage == "A"){
			frmObject.p_report_id.value="PHPRDISLBFILL";
		}
		else if(stage == "D"){
			if(frmObject.p_pat_class.value=="IP" )
				frmObject.p_report_id.value="PHPRDISLB_AL_IP";				
			else if((frmObject.p_pat_class.value=="OP")||(frmObject.p_pat_class.value=="XT")) 
				frmObject.p_report_id.value="PHPRDISLB_AL_OP";
		}
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		frmObject.submit();
	}
	else {
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	}
	setTimeout("disableRun();",150);
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function CheckDateT(obj){
	var locale=document.formMedicalItemLabelCriteria.p_language_id.value;
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
	}
	return true;
}

function changeLanguage(locLang){ 
	var frmObject = document.formMedicalItemLabelCriteria;
	var langVal = locLang.value;
	if(langVal=="E")
		frmObject.p_language_id.value='en';	   
	else	
		frmObject.p_language_id.value=frmObject.alter_label_language.value;					
}

function Duplicatecheck(){ 
	var patientId = document.formMedicalItemLabelCriteria.p_patient_id.value; 
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
	document.formMedicalItemLabelCriteria.p_patient_id.value=main_patientid;    
}

function disableRun(called_from){
	if(called_from=='R')
		parent.content.commontoolbarFrame.document.CommonToolbar_form.run.disabled = true;
	else
		parent.commontoolbarFrame.document.CommonToolbar_form.run.disabled = true;
}
