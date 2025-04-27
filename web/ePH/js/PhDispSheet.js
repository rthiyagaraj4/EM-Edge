  //saved on 02.11.2005
function run() {
	var frmObject = f_query_add_mod.f_query_criteria.document.formPhDispSheetCriteria;
	var stage	=	frmObject.stage.value;	
	var p_disp_no = frmObject.p_disp_no.value;
	//var locale = frmObject.locale.value;
	//frmObject.p_disp_date.value=convertDate(frmObject.p_dispense_date.value,'DMY',locale,"en");

	if(p_disp_no != ""){ //"All" removed for [IN:035576]
		frmObject.p_disp_fm_no.value=p_disp_no;
		frmObject.p_disp_to_no.value=p_disp_no;
		frmObject.P2MULDISP.value = p_disp_no;//SKR-SCF-1278.1

	} 
	else{   
		var len =frmObject.p_disp_no.options.length;
		if(len!="1"){  
			if((frmObject.p_disp_no.options[1].value==null)||(frmObject.p_disp_no.options[1].value=="null")){
				frmObject.p_disp_fm_no.value=frmObject.p_disp_no.options[1].value;
			}
			if(frmObject.p_disp_no.options[len-1].value!=null){
				frmObject.p_disp_to_no.value=frmObject.p_disp_no.options[len-1].value;
			}
			frmObject.P2MULDISP.value = frmObject.disp_nos.value; //SKR-SCF-1278.1
	   }
	}
	//var values ='p_module_id='+frmObject.p_module_id.value+' p_report_id='+frmObject.p_report_id.value+' p_facility_id='+frmObject.p_facility_id.value+' p_user_name='+frmObject.p_user_name.value+' p_disp_fm_no='+frmObject.p_disp_fm_no.value+' p_disp_to_no='+frmObject.p_disp_to_no.value+' p_patient_class='+frmObject.p_patient_class.value+' order_type='+frmObject.order_type.value+' p_language_id='+frmObject.p_language_id.value+' p_disp_date='+frmObject.p_disp_date.value+'locale='+frmObject.locale.value+" p_disp_no="+frmObject.p_disp_no.value;
	var display_doc_no = frmObject.display_doc_no.value //Added for AMS-CRF-0079 [IN:050762] -satrt
	var blankObject = true;
	if(display_doc_no=='Y' ){
		if(frmObject.p_patient_id.value=="" && frmObject.p_doc_no.value=="" ){
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_PATIENT_ID_DOC_NO_CANNOT_BLANK","PH") ;
			blankObject = false;
		}
		if(blankObject){
			var fields=new Array();
			var names=new Array();
			var i=0;
			fields[i]=frmObject.p_dispense_date;
			names[i++]=getLabel("ePH.DispensedDate.label","PH");
			var errorPage	= "../../eCommon/jsp/error.jsp" ;
			blankObject= checkFields( fields, names, messageFrame, errorPage) ;
		}
	}//Added for AMS-CRF-0079 [IN:050762] -end
	else if(frmObject.p_patient_id.value=="" || frmObject.p_dispense_date.value=="" ) {
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("DISP_DT_OR_PATIENT_ID_NOT_BLANK","PH") ;
		blankObject = false;
	} 
	if(blankObject){
		if((frmObject.p_disp_fm_no.value!="" && frmObject.p_disp_to_no.value!="") || frmObject.p_doc_no.value){
			if(frmObject.p_disp_no.options.length<=1) //if block and else condition added for AMS-CRF-0079 [IN:050762] 
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			else{
				//Added for GHL-CRF-0627 - Start
				var p_disp_sheet = frmObject.p_disp_sheet.value;
				var p_pat_class = frmObject.p_pat_class.value
		
				if((p_pat_class=="IP" || p_pat_class=="DC")  && p_disp_sheet=="Y"){
					if(stage == "F" || stage == "A"){
						frmObject.p_report_id.value="PHPRDISSHFILL_IP";
					}
					else if(stage == "D"){
						frmObject.p_report_id.value="PHPRDISSH_IP";
					}
				}else if(p_pat_class=="EM" && p_disp_sheet=="Y"){
					if(stage == "F" || stage == "A"){
						frmObject.p_report_id.value="PHPRDISSHFILL_EM";
					}
					else if(stage == "D"){
						frmObject.p_report_id.value="PHPRDISSH_EM";
					}
				} else { //Added for GHL-CRF-0627 - End
					if(stage == "F" || stage == "A"){
						frmObject.p_report_id.value="PHPRDISSHFILL";
					}
					else if(stage == "D"){
						frmObject.p_report_id.value="PHPRDISSH";
					}
			  } //Modified for GHL-CRF-0627 
			    frmObject.action="../../eCommon/jsp/report_options.jsp";
				frmObject.target="messageFrame";
				frmObject.submit();
				
			}
		}
		else {
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		}
	}
}

function reset() {
	f_query_add_mod.f_query_criteria.document.formPhDispSheetCriteria.reset();
	clearDispNos(f_query_add_mod.f_query_criteria.document.formPhDispSheetCriteria);
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

//for patient lookup
async function callPatientSearch(target){
	var patient_id = await PatientSearch();
	if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;		
	}
}

function searchPractitionerName(target, mode) {
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

	retArray = CommonLookup(getLabel("ePH.PractitionerSearch.label","PH"), argumentArray );
	
	if(retArray != null && retArray != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhMednStatByPractCriteria.pract_id.value = retArray[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_id.value = retArray[0];

		target.value = retArray[1];
	}
}

function callDrugSearch(obj) {
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}

function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
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

function showResults(){
	var formObj			= document.formPhDispSheetCriteria;
	var disp_date		= formObj.p_dispense_date.value ;
	var patient_id		= formObj.p_patient_id.value;
	var p_disp_fm_no	= formObj.p_disp_fm_no.value;
	var p_disp_to_no	= formObj.p_disp_to_no.value;
	
	
	if(patient_id !="" && disp_date != ""){
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		populateDispNo();
	} 
	else {
		if(disp_date == "" || patient_id == "" ){
			parent.f_query_result.location.href="../../eCommon/html/blank.html";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("DISP_DT_OR_PATIENT_ID_NOT_BLANK","PH") ; 
		}		
	}
}

function SubmitLink(from,to,patient_id,disp_no){
	var obj				=	document.frmPrintDispSheetResult;
	obj.from.value		=	from;
	obj.to.value		=	to;
	obj.patient_id.value=	patient_id;
	obj.disp_no.value	=	disp_no;
	obj.submit();
}

function showReportDispenseSheet(disp_no) {
	//parent.f_query_criteria.formPhDispSheetCriteria.p_disp_no.value=disp_no;
	parent.f_query_criteria.formPhDispSheetCriteria.p_disp_fm_no.value=disp_no;
	parent.f_query_criteria.formPhDispSheetCriteria.p_disp_to_no.value=disp_no;
	//checkPatientClass(disp_no);
	run();
}

function checkPatientClass(p_disp_no)	{
	/*var frmObject = parent.f_query_criteria.document.formPhDispSheetCriteria;
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
		//alert(xmlStr);
		xmlHttp.send(xmlDoc);
		//alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
		*/
}

function populateDispNo() {	
	var frmObject		= parent.f_query_criteria.document.formPhDispSheetCriteria;
	var p_disp_date="";
	var p_patient_id	=	frmObject.p_patient_id.value;
	var p_doc_no		=	frmObject.p_doc_no.value;//added for AMS-CRF-0079 [IN:050762] 
	var display_doc_no		=	frmObject.display_doc_no.value;//added for AMS-CRF-0079 [IN:050762] 
	if(p_patient_id=="" && p_doc_no=="") // && p_doc_no=="" added for AMS-CRF-0079 [IN:050762]
		return false;
	var locale	=	frmObject.locale.value;
	p_disp_date		=	frmObject.p_dispense_date.value;
	p_disp_date=convertDate(p_disp_date,"DMY",locale); 
	frmObject.p_disp_date.value=p_disp_date;
	
	var p_pat_class		=	frmObject.p_pat_class.value;
	var order_type		=	frmObject.order_type.value;
	var stage			=	frmObject.stage.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_patient_id=\""+p_patient_id+"\"";
	xmlStr += " p_disp_date=\""+p_disp_date+"\"";
	xmlStr += " p_pat_class=\""+p_pat_class+"\"";
	xmlStr += " order_type=\""+order_type+"\"";
	xmlStr += " p_doc_no=\""+p_doc_no+"\"";//added for AMS-CRF-0079 [IN:050762]
	xmlStr += " display_doc_no=\""+display_doc_no+"\"";//added for AMS-CRF-0079 [IN:050762]
	xmlStr += " stage=\""+stage+"\"";
	xmlStr += " bean_id=\"PHRepDispStatisByDispBean\"";
	xmlStr += " bean_name=\"ePH.PHRepDispStatisByDispBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ReportsValidate.jsp?called_from=populateDispNo",false);
	//alert(xmlStr);
	xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
    if(document.formPhDispSheetCriteria.display_doc_no.value=="Y") //commented for AMS-CRF-0079 [IN:050762]//comment removed for  GHL-SCF-1069 [IN:060605]
		populateDocNo();

}

 function setDispNos(fm_disp_no,to_disp_no,disp_nos) { //disp_nos addedf or SKR-SCF-1278

	document.formPhDispSheetCriteria.p_disp_fm_no.value=fm_disp_no;
	document.formPhDispSheetCriteria.p_disp_to_no.value=to_disp_no;
	document.formPhDispSheetCriteria.disp_nos.value=disp_nos; //addedf or SKR-SCF-1278
}

function assignPatientClass(pat_class) {
	var frmObject	= parent.f_query_criteria.document.formPhDispSheetCriteria;
	var result		= pat_class.split("::");
	frmObject.p_patient_id.value=result[1];
}

function loadDispNos(disp_no){	
	var element			= document.createElement('OPTION') ;
	element.value		=  disp_no ;
	element.text		=  disp_no ;
	document.formPhDispSheetCriteria.p_disp_no.add(element);	
}

function clearDispNos(formObj){
	if(formObj==undefined)
		formObj =document.formPhDispSheetCriteria;
	var len = formObj .p_disp_no.options.length;
	for(var i=0;i<len;i++) {
		formObj.p_disp_no.remove("p_disp_no") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ; //"All" removed for [IN:035576]
	formObj.p_disp_no.add(opt);
	if(formObj.display_doc_no.value=="Y"){//code added for GHL-CRF-0323 [IN:040527] --Start commented for AMS-CRF-0079 [IN:050762] //uncommented for GHL-CRF-0627.2
		len =formObj.p_doc_no.options.length;
		for(var i=0;i<len;i++) {
			formObj.p_doc_no.remove("doc_no") ;
		}	
		opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "" ; 
		formObj.p_doc_no.add(opt); 
	}///code added for GHL-CRF-0323 [IN:040527] --End	//uncommented for GHL-CRF-0627.2
}

function setStage(obj){
	var len =document.formPhDispSheetCriteria.stage.options.length;
	for(var i=0;i<len;i++) {
		document.formPhDispSheetCriteria.stage.remove("stage") ;
	}
	if(obj.value == "IP" || obj.value == "DC"){ //Modified for GHL-CRF-0627.2
		if(obj.value =="IP"){
			document.formPhDispSheetCriteria.p_patient_class.value = "IP";
		}else
		{
			document.formPhDispSheetCriteria.p_patient_class.value = "DC";
		}
		var opt = document.createElement("OPTION") ;
		opt.text = "Filling";
		opt.value = "F" ;
		document.formPhDispSheetCriteria.stage.add(opt);
		var opt = document.createElement("OPTION") ;
		opt.text = "Delivery";
		opt.value = "D" ;
		document.formPhDispSheetCriteria.stage.add(opt);
	}
	else if(obj.value == "OP" || obj.value == "EM" ){ //Modified for GHL-CRF-0627.2
		if(obj.value =="OP"){
			document.formPhDispSheetCriteria.p_patient_class.value = "OP";
		}else
		{
			document.formPhDispSheetCriteria.p_patient_class.value = "EM";
		}
		var opt = document.createElement("OPTION") ;
		opt.text = "Allocation";
		opt.value = "A" ;
		document.formPhDispSheetCriteria.stage.add(opt);
		var opt = document.createElement("OPTION") ;
		opt.text = "Delivery";
		opt.value = "D" ;
		document.formPhDispSheetCriteria.stage.add(opt);
	}
	else if( obj.value=="XT"){
		document.formPhDispSheetCriteria.p_patient_class.value = "XT";
		var opt = document.createElement("OPTION") ;
		opt.text = "Allocation";
		opt.value = "A" ;
		document.formPhDispSheetCriteria.stage.add(opt);
		var opt = document.createElement("OPTION") ;
		opt.text = "Delivery";
		opt.value = "D" ;
		document.formPhDispSheetCriteria.stage.add(opt);
	}
}


// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhDispSheetCriteria.p_language_id.value;
	var sys_date=document.formPhDispSheetCriteria.sys_date; // sys_date added for AMRI-SCF-0453
//	if(obj.value!=""){    // commented for AMRI-SCF-0453   - Start
//		if(!validDate(obj.value, 'DMY',locale)){
//			alert(getMessage("INVALID_DATE_FMT", "SM"));
//			obj.select();
//			obj.focus();
//			return false;
//		}
//	}
//	else{
//		obj.value=convertDate(obj,'DMY',locale,'en');
//	}
//	return true;   // commented for AMRI-SCF-0453   - End
	
	if(sys_date.value=="" || obj.value=="")  // Added for AMRI-SCF-0453 - Start
	{ 
		
		return false;
	}
	else{
		     
		if(!isBefore(obj.value,sys_date.value,"DMY",locale)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		obj.select();
		return false;
	}
    }
    return true;    // Added for AMRI-SCF-0453  - End
}

function Duplicatecheck(){/* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
	var patientId = document.formPhDispSheetCriteria.p_patient_id.value; 
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
 
function mergedPatientAlert( main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.formPhDispSheetCriteria.p_patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */ 

//code added for GHL-CRF-0323[IN:040527] --Start
function populateDocNo() {	
	var frmObject		= parent.f_query_criteria.document.formPhDispSheetCriteria;
	var p_disp_date="";
	var p_patient_id	=	frmObject.p_patient_id.value;
	if(p_patient_id=="")
		return false;
	var locale	=	frmObject.locale.value;
	p_disp_date		=	frmObject.p_dispense_date.value;
	p_disp_date=convertDate(p_disp_date,"DMY",locale); 
	frmObject.p_disp_date.value=p_disp_date;
	
	var p_pat_class		=	frmObject.p_pat_class.value;	
	var stage			=	frmObject.stage.value;
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
	xmlHttp.open("POST","ReportsValidate.jsp?called_from=populateDocNo",false);	
	xmlHttp.send(xmlDoc);	
	eval(xmlHttp.responseText);
}

function loadDocNos(doc_no){	
	doc_element			= document.createElement('OPTION') ;
	doc_element.value		=  doc_no ;
	doc_element.text		=  doc_no ;
	document.formPhDispSheetCriteria.p_doc_no.add(doc_element);	
}

function clearDocNos(){	
		len =document.formPhDispSheetCriteria.p_doc_no.options.length;
		for(var i=0;i<len;i++) {
			document.formPhDispSheetCriteria.p_doc_no.remove("doc_no") ;
		}
		var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
		var opt = document.createElement("OPTION") ;		
		opt.text = tp ;
		opt.value = "" ; 
		document.formPhDispSheetCriteria.p_doc_no.add(opt); 	
}//code added for GHL-CRF-0323[IN:040527]--End

function validateDocNo(docNoObj){ //added for AMS-CRF-0079 [IN:050762]
	if(docNoObj.value!=''){
		if(isNaN(docNoObj.value)){
			alert(getMessage('ENTER_VALID_NUMBER','PH'));
			docNoObj.value="";
			docNoObj.focus();
			return false;
		}
		else
			populateDispNo();
	}
}

function populatePatientID(patient_id){ //added for AMS-CRF-0079 [IN:050762]
	document.formPhDispSheetCriteria.p_patient_id.value = patient_id;
}
