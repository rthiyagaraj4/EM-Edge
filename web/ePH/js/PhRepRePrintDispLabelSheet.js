var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

function reset() {
	f_query_add_mod.frmRePrintDispLabelSheetCriteria.reset();
	f_query_add_mod.frmRePrintDispLabelSheetCriteria.patient_id.disabled=false;
	f_query_add_mod.frmRePrintDispLabelSheetCriteria.btnPatientID.disabled=false;
	f_query_add_mod.frmRePrintDispLabelSheetCriteria.btnPrint.disabled = true;
	f_query_add_mod.frmRePrintDispLabelSheetCriteria.viewReport.disabled = true;
	f_query_results.location.href="../../eCommon/html/blank.html";
	formObj = f_query_add_mod.frmRePrintDispLabelSheetCriteria;
	formObj.p_pat_class.onchange(); //commented for ML-BRU-SCF-0538 [IN:036179]
	//formObj.locn_type.onchange(); //commented for ML-BRU-SCF-0538 [IN:036179]
	
	if(formObj.p_pat_class.value!="IP"){
		alert(formObj.p_pat_class.value);
		var len =formObj.p_disp_no.options.length; //uncommented for GHL-CRF-0627.2
		for(var i=0;i<len;i++) {
			formObj.p_disp_no.remove("disp_no") ;
		}
		var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "" ; //"All" removed for [IN:035576]
		formObj.p_disp_no.add(opt);  //uncommented for GHL-CRF-0627.2
	}
	//ADDED FOR GHL-CRF-0627.2
	var len =formObj.p_pat_class.options.length;
	for(var i=0;i<len;i++) {
		formObj.p_pat_class.remove("p_pat_class") ;
	}
	var opt = document.createElement("OPTION") ;
	opt.text = getLabel("Common.inpatient.label","COMMON")
	opt.value = "IP" ;
	formObj.p_pat_class.add(opt);

	var opt = document.createElement("OPTION") ;
	opt.text =  getLabel("Common.Outpatient.label","COMMON");
	opt.value = "OP" ;
	formObj.p_pat_class.add(opt);
	
	var opt = document.createElement("OPTION") ;
	opt.text =  getLabel("Common.external.label","COMMON");
	opt.value = "XT" ;
	formObj.p_pat_class.add(opt); //added for GHL-CRF-0627.2
}
// This will call common patient search
async function callPatientSearch(){
	var patient_id =await PatientSearch();
	if (patient_id!= "" && patient_id != undefined){
		chkPatientID(patient_id);
	} 
}

function clearResult(){
	parent.f_query_results.location.href="../../eCommon/html/blank.html";
	parent.f_query_add_mod.frmRePrintDispLabelSheetCriteria.btnPrint.disabled = true;
	parent.f_query_add_mod.frmRePrintDispLabelSheetCriteria.viewReport.disabled = true;
}

function chkPatientID(patient_id){
	var formObj=document.frmRePrintDispLabelSheetCriteria;
	if(patient_id == undefined)
		patient_id = formObj.patient_id.value;
	if (patient_id!= "" ){
		formObj.patient_id.value = patient_id;
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="";
		xmlStr ="<root><SEARCH " ;
		xmlStr			+= " bean_id=\""+ bean_id + "\" ";
		xmlStr			+= " bean_name=\""+ bean_name + "\" ";
		xmlStr		    += " patient_id=\""+ patient_id + "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PhRepRePrintDispLabelSheetValidate.jsp?validate=patientsearch", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	} 
}

function showResults(pat_id){
	var frmObj = document.frmRePrintDispLabelSheetCriteria;
	var locale=frmObj.locale.value;//added for SKR-SCF-1005[IN048684]
	var pat_id = frmObj.patient_id.value;
	var disp_no = frmObj.p_disp_no.value;
	var disp_date = frmObj.dispense_date.value;
	disp_date=convertDate(disp_date,'DMY',locale,'en');//added for SKR-SCF-1005[IN048684]
	var patient_class = frmObj.p_pat_class.value;
	//var locn_type = frmObj.locn_type.value; //commented for ML-BRU-SCF-0538 [IN:036179]
	//var locn_code = frmObj.locn_code.value; //commented for ML-BRU-SCF-0538 [IN:036179]
	var disp_stage = frmObj.stage.value;
	var report_type			=	'L';//Added for Bru-HIMS-CRF-417 [IN045565] Liked INC 50453
	if(frmObj.report_type[0].checked == true)
		report_type = frmObj.report_type[0].value;
	else if(frmObj.report_type[1].checked == true)
		report_type = frmObj.report_type[1].value;
	if(frmObj.patient_id.value=="" && frmObj.dispense_date.value=="") {
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("DISP_DT_OR_PATIENT_ID_NOT_BLANK","PH");
		return false;
	} 
	parent.f_query_results.location.href="../../ePH/jsp/PhRepRePrintDispLabelSheetResult.jsp?patient_id="+pat_id+"&disp_no="+disp_no+"&disp_date="+disp_date+"&patient_class="+patient_class+"&disp_stage="+disp_stage+"&report_type="+report_type;
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}
/* //commented for ML-BRU-SCF-0538 [IN:036179] --start
function locationLookup(target){
	var formObj = document.frames.frmRePrintDispLabelSheetCriteria;
	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title ='';
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value+"'"+formObj.locale.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;
			title = getLabel("Common.nursingUnit.label","common");
		}
		else if (locn_type=="C"){
			argumentArray[0]   =  document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value+"'"+formObj.locale.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;
			title = getLabel("Common.clinic.label","common");
		}
		var retVal = await CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "" )  {
			formObj.locn_code.value=retVal[0];
			target.value = retVal[1] ;
			populateDispNo();
		}
		else{
			formObj.locn_code.value="";
			target.value ="" ;
		}
	}
	else{
		formObj.locn_type.focus()
	}
}

function resetLocation(){
	var formObj = document.frames.frmRePrintDispLabelSheetCriteria;
	formObj.locn_code.value="";
	formObj.locn_name.value="";
}
function clearLocnCode(){
	var formObj = document.frames.frmRePrintDispLabelSheetCriteria;
	if(formObj.locn_name.value=="")
		formObj.locn_code.value="";
	else
		locationLookup(formObj.locn_name);
}
*/ //commented for ML-BRU-SCF-0538 [IN:036179] - end
function loadStages(obj){
	var len =document.frmRePrintDispLabelSheetCriteria.stage.options.length;
	for(var i=0;i<len;i++) {
		document.frmRePrintDispLabelSheetCriteria.stage.remove("stage") ;
	}
	if(obj.value == "IP" || obj.value == "DC"){
		var opt = document.createElement("OPTION") ;
		opt.text = getLabel("ePH.Filling.label","PH")
		opt.value = "F" ;
		document.frmRePrintDispLabelSheetCriteria.stage.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text =  getLabel("ePH.Delivery.label","PH");
		opt.value = "D" ;
		document.frmRePrintDispLabelSheetCriteria.stage.add(opt);
	}
	else{ // if(obj.value == "C"){
		var opt = document.createElement("OPTION") ;
		opt.text = getLabel("ePH.Allocation.label","PH");
		opt.value = "A" ;
		document.frmRePrintDispLabelSheetCriteria.stage.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text =  getLabel("ePH.Delivery.label","PH");
		opt.value = "D" ;
		document.frmRePrintDispLabelSheetCriteria.stage.add(opt);
	}
}

function DateCheck(from,to) {

//    var fromarray;    // commented for AMRI-SCF-0453   - Start
//    var toarray;
//    var fromdate = from.value ;
//    var todate = to.value ;
//	
//    if(fromdate.length > 0 && todate.length > 0 ) {
//		fromarray = fromdate.split("/");
//		toarray = todate.split("/");
//		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
//		var todt = new Date(toarray[2],toarray[1],toarray[0]);
//        
//		if(Date.parse(todt) > Date.parse(fromdt)){
//			var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
//			alert(invaldt);
//			to.select();
//			to.focus();
//			return false;
//		}
//		else if(Date.parse(todt) <= Date.parse(fromdt)) 
//			return true;
//    }
//    return true;   // commented for AMRI-SCF-0453   - End
	if(from.value=="" || to.value=="")  // Added for AMRI-SCF-0453 - Start
	{ 
		
		return false;
	}
	else{
		     
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		to.select();
		return false;
	}
    }
    return true;   // Added for AMRI-SCF-0453  - End
}

function CheckDateT(obj){
	var locale=document.frmRePrintDispLabelSheetCriteria.locale.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		clearDispNos();
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}

function populateDispNo() {	
	var frmObject		= document.frmRePrintDispLabelSheetCriteria;
	var p_disp_date="";
	var locale	=	frmObject.locale.value;
	var patient_id	=	frmObject.patient_id.value;
	var patient_class	=	frmObject.p_pat_class.value;
	p_disp_date		=	frmObject.dispense_date.value;
	 //added for GHL-CRF-0627
	var report_type			=	'L';
	if(frmObject.report_type[0].checked == true)
		report_type = frmObject.report_type[0].value;
	else if(frmObject.report_type[1].checked == true)
		report_type = frmObject.report_type[1].value;
	
	 //added for GHL-CRF-0627
	if(patient_id == '' && p_disp_date =='')
		return false;
	var stage			=	frmObject.stage.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_patient_id=\""+patient_id+"\"";
	xmlStr += " p_disp_date=\""+p_disp_date+"\"";
	//xmlStr += " p_source_type=\""+frmObject.locn_type.value+"\""; //commented for ML-BRU-SCF-0538 [IN:036179]
	//xmlStr += " p_source_code=\""+frmObject.locn_code.value+"\""; //commented for ML-BRU-SCF-0538 [IN:036179]
	xmlStr += " patient_class=\""+patient_class+"\""; //added for ML-BRU-SCF-0538 [IN:036179]
	xmlStr += " stage=\""+stage+"\"";
	xmlStr += " report_type=\""+report_type+"\"";
	xmlStr += " bean_id=\"RePrintDispLabelSheetBean\"";
	xmlStr += " bean_name=\"ePH.RePrintDispLabelSheetBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhRepRePrintDispLabelSheetValidate.jsp?validate=populateDispNo",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function clearDispNos(){
	var len =document.frmRePrintDispLabelSheetCriteria.p_disp_no.options.length;
	for(var i=0;i<len;i++) {
		document.frmRePrintDispLabelSheetCriteria.p_disp_no.remove("disp_no") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ; //"All" removed for [IN:035576]
	document.frmRePrintDispLabelSheetCriteria.p_disp_no.add(opt);
}

function loadDispNos(disp_no){
	var element			= document.createElement('OPTION') ;
	element.value		=  disp_no ;
	element.text		=  disp_no ;
	document.frmRePrintDispLabelSheetCriteria.p_disp_no.add(element);	
}

function chkpatID(yes_no){
	var frmObj = "";
	formObj=document.frmRePrintDispLabelSheetCriteria;
	if(yes_no == "N"){
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		formObj.patient_id.focus();
	}
	else if(yes_no == "Y"){
		formObj.patient_id.disabled = true;
		formObj.btnPatientID.disabled = true;
		populateDispNo();
	}
}

function updateSelection(disp_no, dicp_srl_no, checkBxObj, recCount){
	var resfrmObject		= document.frmRePrintDispLabelSheetResult;
	var frmObject		= parent.f_query_add_mod.document.frmRePrintDispLabelSheetCriteria;
	var noOfCopiesObj = eval("resfrmObject.no_of_copies_"+recCount);
	if(checkBxObj.checked == true){
		checkBxObj.value='Y';
		noOfCopiesObj.disabled=false;
	}
	else{
		checkBxObj.value='N';
		noOfCopiesObj.value='1';
		noOfCopiesObj.disabled=true;
	}
	var stage			=	frmObject.stage.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " disp_no=\""+disp_no+"\"";
	xmlStr += " dicp_srl_no=\""+dicp_srl_no+"\"";
	xmlStr += " select_yn=\""+checkBxObj.value+"\"";
	xmlStr += " bean_id=\"RePrintDispLabelSheetBean\"";
	xmlStr += " bean_name=\"ePH.RePrintDispLabelSheetBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhRepRePrintDispLabelSheetValidate.jsp?validate=UPDATESELECTION",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function showReport(disp_no, called_from){
	var frmObject		= parent.f_query_add_mod.document.frmRePrintDispLabelSheetCriteria;
	var stage			=	frmObject.stage.value;
	//var locn_type			=	frmObject.locn_type.value; //commented for ML-BRU-SCF-0538 [IN:036179]
	var patient_class			=	frmObject.p_pat_class.value; //added for  for ML-BRU-SCF-0538 [IN:036179]
	var report_type			=	frmObject.report_type;
	//var patient_id			=	frmObject.patient_id.value;	//code added for HSA-SCF-0038[IN050015]
	//var disp_no				=	frmObject.p_disp_no.value;//code added for HSA-SCF-0038[IN050015]
	var frmObjectResult		= parent.f_query_results.document.frmRePrintDispLabelSheetResult;
	//added for SKR-SCF-1483 - start
	var disp_date = frmObject.dispense_date.value;
	var locale=frmObject.locale.value;
	disp_date=convertDate(disp_date,'DMY',locale,'en');
	 frmObject.p_disp_date.value = disp_date;
	//added for SKR-SCF-1483 - end
	var recCount			= parseInt(frmObjectResult.recCount.value);
	var p_disp_sheet = frmObject.p_disp_sheet.value; //Added for GHL-CRF-0627
	for(var i=0;i<recCount;i++){
		var check_yn    =eval('frmObjectResult.select_'+i).checked;
		var nofCopies = eval('frmObjectResult.no_of_copies_'+i).value;
		if(check_yn==true && (nofCopies=='' || nofCopies=="0")){
			alert(getMessage("PH_NO_OF_PRINT_CANNOT_BALNK", "PH"));
			eval('frmObjectResult.no_of_copies_'+i).select();
			eval('frmObjectResult.no_of_copies_'+i).focus();
			return false;
		}
	}
	if(report_type[0].checked == true)
		report_type ='L';
	else
		report_type = 'S';
	if(report_type == 'S'){
		if((patient_class=="IP" || patient_class=="DC") && p_disp_sheet=="Y"){ //MODIFIED for GHL-CRF-0627 - START
		if(stage =='D')
			frmObject.p_report_id.value='PHPRDISSH_IP';
		else
			frmObject.p_report_id.value='PHPRDISSHFILL_IP';
		 }
		else if(patient_class=="EM" && p_disp_sheet=="Y"){
		if(stage =='D')
			frmObject.p_report_id.value='PHPRDISSH_EM';
		else
			frmObject.p_report_id.value='PHPRDISSHFILL_EM';
		}
		else{
		if(stage =='D')
			frmObject.p_report_id.value='PHPRDISSH';
		else
			frmObject.p_report_id.value='PHPRDISSHFILL';
      }  													 //MODIFIED for GHL-CRF-0627 - END
	}
	else if(report_type =='L'){
		if(stage =='D'){
			if(patient_class =='IP')
				frmObject.p_report_id.value='PHPRDISLB_AL_IP';
			else
				frmObject.p_report_id.value='PHPRDISLB_AL_OP';
		}
		else
			frmObject.p_report_id.value='PHPRDISLBFILL';
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " stage=\""+stage+"\"";
	xmlStr += " called_from=\""+called_from+"\"";
	xmlStr += " bean_id=\"RePrintDispLabelSheetBean\"";
	xmlStr += " bean_name=\"ePH.RePrintDispLabelSheetBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhRepRePrintDispLabelSheetValidate.jsp?validate=UPDATEPRINTSEQ",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	if(called_from=='P' && result == 'Y'){// Added for SKR-SCF-1041[IN051887]
		xmlStr ="<root><SEARCH ";
		xmlStr += " stage=\""+stage+"\"";
		xmlStr += " called_from=\""+called_from+"\"";
		xmlStr += " p_report_id=\""+frmObject.p_report_id.value+"\"";
		xmlStr += " p_user_name=\""+frmObject.p_user_name.value+"\"";
		xmlStr += " p_facility_id=\""+frmObject.p_facility_id.value+"\"";
		xmlStr += " p_language_id=\""+frmObject.p_language_id.value+"\"";
		xmlStr += " p_patient_id=\""+frmObject.patient_id.value+"\""; //Added for ML-BRU-SCF-1414 [IN:050645] 
		xmlStr += " p_disp_no=\""+frmObject.p_disp_no.value+"\""; //Added for ML-BRU-SCF-1414 [IN:050645] 
		xmlStr += " report_type=\""+report_type+"\""; //Added for ML-BRU-SCF-1414 [IN:050645] 
		xmlStr += " p_disp_date=\""+disp_date+"\"";  //added for SKR-SCF-1483
		xmlStr += " p_pat_class=\""+patient_class+"\""; //SKR-SCF-1734
		xmlStr += " bean_id=\"RePrintDispLabelSheetBean\"";
		xmlStr += " bean_name=\"ePH.RePrintDispLabelSheetBean\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PhRepRePrintDispLabelSheetValidate.jsp?validate=PRINTREP",true);
		xmlHttp.send(xmlDoc);
		//eval(xmlHttp.responseText);
		alert(getMessage("REPORT_SUBMITTED","PH"));
		result='N';
	}
}

function setprntSeqNo(prntSeqNo, called_from){
	if(called_from=='V'){
		if(prntSeqNo != undefined && prntSeqNo!=''){
			document.frmRePrintDispLabelSheetCriteria.p_offline_print_seq_no.value=prntSeqNo;
			document.frmRePrintDispLabelSheetCriteria.p_patient_id.value = document.frmRePrintDispLabelSheetCriteria.patient_id.value;
			document.frmRePrintDispLabelSheetCriteria.p_disp_no.value = document.frmRePrintDispLabelSheetCriteria.p_disp_no.value;	

			if(document.frmRePrintDispLabelSheetCriteria.p_disp_no.value!=""){ //added for SKR-SCF-1278.1
				document.frmRePrintDispLabelSheetCriteria.P2MULDISP.value  = document.frmRePrintDispLabelSheetCriteria.p_disp_no.value 
			}else{
				document.frmRePrintDispLabelSheetCriteria.P2MULDISP.value  = document.frmRePrintDispLabelSheetCriteria.disp_nos.value
			}
			document.frmRePrintDispLabelSheetCriteria.action="../../eCommon/jsp/report_options.jsp"; 
			document.frmRePrintDispLabelSheetCriteria.target="messageFrame";
			document.frmRePrintDispLabelSheetCriteria.submit();
		}	
		else
			alert(getMessage("EXCEPTION_OCCURED_WHILE_INSERTION","PH"));
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function selectAll(selAllObj){
	var formObj = document.frmRePrintDispLabelSheetResult;
	var recCount = parseInt(formObj.recCount.value);
	var noOfCopiesObj ;
	for(i=0; i<recCount; i++){
		noOfCopiesObj = eval("formObj.no_of_copies_"+i);
		if(selAllObj.checked == true){
			eval('formObj.select_'+i).checked = true;
			eval('formObj.select_'+i).value = 'Y';
			noOfCopiesObj.disabled=false;
		}
		else{
			eval('formObj.select_'+i).checked = false;
			eval('formObj.select_'+i).value = 'N';
			noOfCopiesObj.value='1';
			noOfCopiesObj.disabled=true;
		}
	}
	var frmObject		= parent.f_query_add_mod.document.frmRePrintDispLabelSheetCriteria;
	if(selAllObj.checked == true)
		selAllObj.value='Y';
	else
		selAllObj.value='N';
	var stage			=	frmObject.stage.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " selectAll_yn=\""+selAllObj.value+"\"";
	xmlStr += " bean_id=\"RePrintDispLabelSheetBean\"";
	xmlStr += " bean_name=\"ePH.RePrintDispLabelSheetBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhRepRePrintDispLabelSheetValidate.jsp?validate=UPDATESELECTIONALL",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}
function changeLanguage(locLang){  //This function added for IN031262
	var frmObject = document.frmRePrintDispLabelSheetCriteria;
	frmObject.p_language_id.value=locLang.value;
}

function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
	var patientId = document.frmRePrintDispLabelSheetCriteria.patient_id.value; 
	if( (patientId != null) && (patientId !="")){
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
	document.frmRePrintDispLabelSheetCriteria.patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */

function updatenofCopies( recCount){//Added for Bru-HIMS-CRF-417 [IN045565]
	var formObj = document.frmRePrintDispLabelSheetResult;
	var pat_id = formObj.patient_id.value;
	var nofCopies = eval('formObj.no_of_copies_'+recCount).value;
	var curr_disp_no = eval('formObj.curr_disp_no_'+recCount).value;
	var disp_srl_no = eval('formObj.disp_srl_no_'+recCount).value;
	var obj = eval('formObj.select_'+recCount);
	if((obj.checked==true) && (nofCopies=='' || parseInt(nofCopies)<=0)){
		alert(getMessage("PH_NO_OF_PRINT_CANNOT_BALNK", "PH"));
		eval('formObj.no_of_copies_'+recCount).value=1;
		return false;
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " curr_disp_no=\""+curr_disp_no+"\"";
	xmlStr += " disp_srl_no=\""+disp_srl_no+"\"";
	xmlStr += " nofCopies=\""+nofCopies+"\"";
	xmlStr += " p_patient_id=\""+pat_id+"\"";
	xmlStr += " bean_id=\"RePrintDispLabelSheetBean\"";
	xmlStr += " bean_name=\"ePH.RePrintDispLabelSheetBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhRepRePrintDispLabelSheetValidate.jsp?validate=UPDATEPRINTCOPIES",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function allowPositiveNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<=58 ) ) ) {
       return false;
   }
}

 function setDispNos(disp_nos) { //disp_nos added for SKR-SCF-1278
	document.frmRePrintDispLabelSheetCriteria.P2MULDISP.value=disp_nos;
	document.frmRePrintDispLabelSheetCriteria.disp_nos.value=disp_nos; 
}
 
 //Added for GHL-CRF-0627
 
 function checkDispCriteria(obj){
	
	 if(obj.value == "S"){
		// alert(document.frmRePrintDispLabelSheetCriteria.p_pat_class.value);
			var opt = document.createElement("OPTION") ;
			opt.text = getLabel("Common.daycare.label","COMMON");
			opt.value = "DC" ;
			document.frmRePrintDispLabelSheetCriteria.p_pat_class.add(opt);

			var opt = document.createElement("OPTION") ;
			opt.text =  getLabel("Common.emergency.label","COMMON");
			opt.value = "EM" ;
			document.frmRePrintDispLabelSheetCriteria.p_pat_class.add(opt);
			populateDispNo();
			
		}else{
			var len =document.frmRePrintDispLabelSheetCriteria.p_pat_class.options.length;
			for(var i=0;i<len;i++) {
				document.frmRePrintDispLabelSheetCriteria.p_pat_class.remove("p_pat_class") ;
			}
			var opt = document.createElement("OPTION") ;
			opt.text = getLabel("Common.inpatient.label","COMMON");
			opt.value = "IP" ;
			document.frmRePrintDispLabelSheetCriteria.p_pat_class.add(opt);

			var opt = document.createElement("OPTION") ;
			opt.text =  getLabel("Common.Outpatient.label","COMMON");
			opt.value = "OP" ;
			document.frmRePrintDispLabelSheetCriteria.p_pat_class.add(opt);
			
			var opt = document.createElement("OPTION") ;
			opt.text =  getLabel("Common.external.label","COMMON");
			opt.value = "XT" ;
			document.frmRePrintDispLabelSheetCriteria.p_pat_class.add(opt);
						
			loadStages(document.frmRePrintDispLabelSheetCriteria.p_pat_class);
			populateDispNo();
		} 
 }
 
//Added for GHL-CRF-0627
