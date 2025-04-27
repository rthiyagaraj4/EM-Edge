  //saved on 02.11.2005
/*function run() {

	 	var frmObject = f_query_criteria.document.formPhDispLabelCriteria;

		if(frmObject.p_patient_id.value=="" || frmObject.p_disp_date.value=="") {
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("DISP_DT_OR_PATIENT_ID_NOT_BLANK","PH") ;
		} else	if(frmObject.p_disp_fm_no.value!="" && frmObject.p_disp_to_no.value!=""){
			
			var loc_lang	=	frmObject.label_language.value;
				if(loc_lang=="") loc_lang="E";
			var stage	=	frmObject.stage.value;	
		 
		if(stage == "F" || stage == "A"){
			if(	loc_lang=="L")
			frmObject.p_report_id.value="PHPRDISLBFILL_ARA";
			else if(loc_lang=="E")
			frmObject.p_report_id.value="PHPRDISLBFILL";

		}else if(stage == "D"){
			if(frmObject.p_pat_class.value=="IP" && loc_lang=="E")
				frmObject.p_report_id.value="PHPRDISLB_AL_IP";
			else if(frmObject.p_pat_class.value=="OP" && loc_lang=="E")
				frmObject.p_report_id.value="PHPRDISLB_AL_OP";
			else if (frmObject.p_pat_class.value=="IP" && loc_lang=="L")
				frmObject.p_report_id.value="PHPRDISLB_AL_IP_ARA";
			else if (frmObject.p_pat_class.value=="OP" && loc_lang=="L")
				frmObject.p_report_id.value="PHPRDISLB_AL_OP_ARA";
			else if (frmObject.p_pat_class.value=="OP" && loc_lang=="B")
				frmObject.p_report_id.value="PHPRDISLBOPEA";
		}

			frmObject.submit();
		} else {
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		}
	
}*/




function reset() {
    f_query_criteria.formPhDispLabelCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

//for patient lookup
async function callPatientSearch(target){

	var patient_id = await PatientSearch();
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

	retArray = await CommonLookup(getLabel("ePH.PractitionerSearch.label","PH"), argumentArray );

	
	if(retArray != null && retArray != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhMednStatByPractCriteria.pract_id.value = retArray[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_id.value = retArray[0];

		target.value = retArray[1];
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

function checkPatientClass(p_disp_no)	{
	var frmObject = parent.f_query_criteria.document.formPhDispLabelCriteria;
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
	var frmObject	= parent.f_query_criteria.document.formPhDispLabelCriteria;
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
	var frmObject		=   parent.f_query_criteria.document.formPhDispLabelCriteria;
	var p_disp_date	="";
	var p_patient_id	=	frmObject.p_patient_id.value;
	if(p_patient_id=="")
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
	xmlStr += " stage=\""+stage+"\"";
	xmlStr += " bean_id=\"PHRepDispStatisByDispBean\"";
	xmlStr += " bean_name=\"ePH.PHRepDispStatisByDispBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ReportsValidate.jsp?called_from=populateDispNo",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function setDispNos(fm_disp_no,to_disp_no,disp_nos) {
	document.formPhDispLabelCriteria.p_disp_fm_no.value=fm_disp_no;
	document.formPhDispLabelCriteria.p_disp_to_no.value=to_disp_no;
}

function showLabelDetail(obj) {
	if(obj.value=="OP") {
		document.getElementById("lbl_dtls").style.visibility="visible";
	}
	else{
		document.getElementById("lbl_disp_no").style.visibility="visible";
		document.getElementById("lst_disp_no").style.visibility="visible";
		document.getElementById("lbl_fm_no").style.visibility="hidden";
		document.getElementById("lbl_to_no").style.visibility="hidden";
		document.getElementById("p_lbl_fm_no").style.visibility="hidden";
		document.getElementById("p_lbl_to_no").style.visibility="hidden";
	}
}

function loadDispNos(disp_no) {
	//if(document.formPhDispLabelCriteria.p_pat_class.value=="OP") {
		var element			= document.createElement('OPTION') ;
		element.value		=  disp_no ;
		element.text		=  disp_no ;
		document.formPhDispLabelCriteria.p_disp_no.add(element);	
	//}
}

function SetLabelLang(label_lang){
	
	if(label_lang=='L'){
		
        document.formPhDispLabelCriteria.label_language.selectedIndex=2;
	}else {
		
        document.formPhDispLabelCriteria.label_language.selectedIndex=1;
	}
}
function clearDispNos(){
	var len =document.formPhDispLabelCriteria.p_disp_no.options.length;
	for(var i=0;i<len;i++) {
		document.formPhDispLabelCriteria.p_disp_no.remove("p_disp_no") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formPhDispLabelCriteria.p_disp_no.add(opt);
}

function loadLabelNos(label_no) {
	if(document.formPhDispLabelCriteria.p_pat_class.value=="OP") {
		var element			= document.createElement('OPTION') ;
		element.value		=  label_no ;
		element.text		=  label_no ;
		document.formPhDispLabelCriteria.p_lbl_fm_no.add(element);	

		var element			= document.createElement('OPTION') ;
		element.value		=  label_no ;
		element.text		=  label_no ;
		document.formPhDispLabelCriteria.p_lbl_to_no.add(element);	
	}
}

function clearLabelNos(){
	var len =document.formPhDispLabelCriteria.p_lbl_fm_no.options.length;
	for(var i=0;i<len;i++) {
		document.formPhDispLabelCriteria.p_lbl_fm_no.remove("label_from") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formPhDispLabelCriteria.p_lbl_fm_no.add(opt);

	var len =document.formPhDispLabelCriteria.p_lbl_to_no.options.length;
	for(var i=0;i<len;i++) {
		document.formPhDispLabelCriteria.p_lbl_to_no.remove("label_from") ;
	}
	var tp ="---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formPhDispLabelCriteria.p_lbl_to_no.add(opt);
}

function populateLabelNo() {	
	var frmObject		=   parent.f_query_criteria.document.formPhDispLabelCriteria;
    alert("frmObject_315 "+frmObject);
	var disp_no			=	frmObject.p_disp_no.value;
	var p_pat_class		=	frmObject.p_pat_class.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " disp_no=\""+disp_no+"\"";
	xmlStr += " p_pat_class=\""+p_pat_class+"\"";
	xmlStr += " bean_id=\"PHRepDispStatisByDispBean\"";
	xmlStr += " bean_name=\"ePH.PHRepDispStatisByDispBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ReportsValidate.jsp?called_from=populateLabelNos",false);
	alert(xmlStr);
	xmlHttp.send(xmlDoc);
	alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
}
function setStage(obj){

	var len =document.formPhDispLabelCriteria.stage.options.length;

	for(var i=0;i<len;i++) {
		document.formPhDispLabelCriteria.stage.remove("stage") ;
	}

	if(obj.value == "IP"){
		document.formPhDispLabelCriteria.p_patient_class.value = "IP";
		var opt = document.createElement("OPTION") ;
		opt.text = "---"+getLabel("ePH.Filling.label","PH")+"---";
		opt.value = "F" ;
		document.formPhDispLabelCriteria.stage.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text =  "---"+getLabel("ePH.Delivery.label","PH")+"---";
		opt.value = "D" ;
		document.formPhDispLabelCriteria.stage.add(opt);
	}
	else if(obj.value == "OP" ||obj.value == "XT"){
		document.formPhDispLabelCriteria.p_patient_class.value = "OP";
		var opt = document.createElement("OPTION") ;
		opt.text = "---"+getLabel("ePH.Allocation.label","PH")+"---";
		opt.value = "A" ;
		document.formPhDispLabelCriteria.stage.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text =  "---"+getLabel("ePH.Delivery.label","PH")+"---";
		opt.value = "D" ;
		document.formPhDispLabelCriteria.stage.add(opt);
	}
	else if(obj.value == "XT"){
		//alert("XT");
		document.formPhDispLabelCriteria.p_patient_class.value = "XT";
		var opt = document.createElement("OPTION") ;
		opt.text = "---"+getLabel("ePH.Allocation.label","PH")+"---";
		opt.value = "A" ;
		document.formPhDispLabelCriteria.stage.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text =  "---"+getLabel("ePH.Delivery.label","PH")+"---";
		opt.value = "D" ;
		document.formPhDispLabelCriteria.stage.add(opt);
	}
}

function printReports() {
	var frmObject = document.formPhDispLabelCriteria;
	var label_language1	= 	frmObject.label_language1.value;
	var disp_nos="";
 
	if(frmObject.p_patient_id.value=="" || frmObject.p_dispense_date.value=="") {
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("DISP_DT_OR_PATIENT_ID_NOT_BLANK","PH") ;
	} 
	else if(frmObject.p_disp_fm_no.value!="" && frmObject.p_disp_to_no.value!=""){
		
		var loc_lang	=	frmObject.label_language.value;
		if(loc_lang=="") 
			loc_lang="E";
		var stage		=	frmObject.stage.value;
		var p_disp_no =	frmObject.p_disp_no.value;
		if(p_disp_no==undefined || p_disp_no==""){//added for CRF-394/02[47518] start
			var len =frmObject.p_disp_no.options.length;
			for(var i=1;i<len;i++) {
				if(i == parseInt(len-1))
					p_disp_no += document.formPhDispLabelCriteria.p_disp_no.options[i].value ;
				else
					p_disp_no += document.formPhDispLabelCriteria.p_disp_no.options[i].value+'~';
			}
		}//added for CRF-394/02[47518] end
		if(stage == "F" || stage == "A"){
			frmObject.p_report_id.value="PHPRDISLBFILL";//Code added and below code comment for IN031262					
			/*if(loc_lang=="L")     // commented for IN031262-start
			{
			frmObject.p_report_id.value="PHPRDISLBFILL";
			 frmObject.p_language_id.value=frmObject.locale.value; //Code Modified For FD-Bru-HIMS-CRF-074
			}
			else if(loc_lang=="E")
			{
				frmObject.p_report_id.value="PHPRDISLBFILL";
				frmObject.p_language_id.value=frmObject.locale.value;
			}*/  // commented for IN031262-end
		}
		else if(stage == "D"){
			//added for IN031262-start
			if(frmObject.p_pat_class.value=="IP" )
				frmObject.p_report_id.value="PHPRDISLB_AL_IP";				
			else if((frmObject.p_pat_class.value=="OP")||(frmObject.p_pat_class.value=="XT")) 
				frmObject.p_report_id.value="PHPRDISLB_AL_OP";
		// added for IN031262-end
		/*if(frmObject.p_pat_class.value=="IP" && loc_lang=="E"){		// commented for IN031262-end
			frmObject.p_report_id.value="PHPRDISLB_AL_IP";
			frmObject.p_language_id.value=frmObject.locale.value;
		}
		else if(((frmObject.p_pat_class.value=="OP")||(frmObject.p_pat_class.value=="XT")) && loc_lang=="E"){
			frmObject.p_report_id.value="PHPRDISLB_AL_OP";
			frmObject.p_language_id.value=frmObject.locale.value;
		}
		else if (frmObject.p_pat_class.value=="IP" && loc_lang=="L"){
			frmObject.p_report_id.value="PHPRDISLB_AL_IP";
			frmObject.p_language_id.value=frmObject.label_language1.value;
		}
		else if(((frmObject.p_pat_class.value=="OP")||(frmObject.p_pat_class.value=="XT")) && loc_lang=="L"){
			frmObject.p_report_id.value="PHPRDISLB_AL_OP";
			frmObject.p_language_id.value=frmObject.label_language1.value;
		}*/		// commented for IN031262-end
		//else if(((frmObject.p_pat_class.value=="OP")||(frmObject.p_pat_class.value=="XT")) && loc_lang=="B")
			//frmObject.p_report_id.value="PHPRDISLBOPEA";
	}

	var p_report_id		= frmObject.p_report_id.value;
	var p_user_name		= frmObject.p_user_name.value;
	var p_facility_id	= frmObject.p_facility_id.value;
//	var p_report_id		= frmObject.p_report_id.value;
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
	//xmlStr += " p_language_id=\""+label_language1+"\"";
	xmlStr += " stage=\""+stage+"\"";
	xmlStr += " bean_id=\"PHRepDispStatisByDispBean\"";
	xmlStr += " bean_name=\"ePH.PHRepDispStatisByDispBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ReportsValidate.jsp?called_from=print_disp_lables",true);//changed false to true for AAKH-SCF-0414
	xmlHttp.send(xmlDoc);
 
	//eval(xmlHttp.responseText); //commented for AAKH-SCF-0414
	//	if(result == 'Y'){ commented for AAKH-SCF-0414
			alert(getMessage("REPORT_SUBMITTED","PH"));
		//}
	} 
	else {
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	}
	setTimeout("disableRun();",150);
}

function viewLabels() {
	var frmObject = document.formPhDispLabelCriteria;
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
			frmObject.p_report_id.value="PHPRDISLBFILL";//added for IN031262
			/*if(loc_lang=="L")	// commented for IN031262-start
			{
				frmObject.p_report_id.value="PHPRDISLBFILL";
				frmObject.p_language_id.value=frmObject.alter_label_language.value; //Code Modified For FD-Bru-HIMS-CRF-074
			}
			else if(loc_lang=="E")
			{
				frmObject.p_report_id.value="PHPRDISLBFILL";
				frmObject.p_language_id.value=frmObject.locale.value;
			} */		// commented for IN031262-end

		}
		else if(stage == "D"){
			// added for IN031262-start
			if(frmObject.p_pat_class.value=="IP" )
				frmObject.p_report_id.value="PHPRDISLB_AL_IP";				
			else if((frmObject.p_pat_class.value=="OP")||(frmObject.p_pat_class.value=="XT")) 
				frmObject.p_report_id.value="PHPRDISLB_AL_OP";
			// added for IN031262-end
			/*if(frmObject.p_pat_class.value=="IP" && loc_lang=="E"){	// commented for IN031262-start
				frmObject.p_report_id.value="PHPRDISLB_AL_IP";
				frmObject.p_language_id.value=frmObject.locale.value;
			}
			
			else if(((frmObject.p_pat_class.value=="OP")||(frmObject.p_pat_class.value=="XT")) && loc_lang=="E")
			{  
				frmObject.p_report_id.value="PHPRDISLB_AL_OP";
				frmObject.p_language_id.value=frmObject.locale.value;
			}
			else if (frmObject.p_pat_class.value=="IP" && loc_lang=="L"){
				frmObject.p_report_id.value="PHPRDISLB_AL_IP";
				frmObject.p_language_id.value=frmObject.alter_label_language.value;//Code Modified For FD-Bru-HIMS-CRF-074
			}
			else if(((frmObject.p_pat_class.value=="OP")||(frmObject.p_pat_class.value=="XT")) && loc_lang=="L")
			{	
				frmObject.p_report_id.value="PHPRDISLB_AL_OP";
				frmObject.p_language_id.value=frmObject.alter_label_language.value;//Code Modified For FD-Bru-HIMS-CRF-074
			}
			*/	// commented for IN031262-end
			/*else if(((frmObject.p_pat_class.value=="OP")||(frmObject.p_pat_class.value=="XT")) && loc_lang=="B")
				frmObject.p_report_id.value="PHPRDISLBOPEA";*/
		}
		frmObject.action="../../eCommon/jsp/report_options.jsp"; 
		frmObject.target="messageFrame";
		frmObject.submit();
	}
	else {
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	}
	setTimeout("disableRun();",150);
}

function assignResult( _result, _message, _flag ) {
	//alert("_result-->" +_result);
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhDispLabelCriteria.p_language_id.value;
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

function changeLanguage(locLang){  //This function added for IN031262
	var frmObject = document.formPhDispLabelCriteria;
	var langVal = locLang.value;
	if(langVal=="E")
		frmObject.p_language_id.value='en';	   
	else	
		frmObject.p_language_id.value=frmObject.alter_label_language.value;					
}

function Duplicatecheck(){  /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */  
	var patientId = document.formPhDispLabelCriteria.p_patient_id.value; 
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
	document.formPhDispLabelCriteria.p_patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */ 

function disableRun(){
	parent.commontoolbarFrame.document.CommonToolbar_form.run.disabled = true;
}
