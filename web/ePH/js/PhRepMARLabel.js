var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

function reset() {
	f_query_add_mod.frmphREPMARLabelCriteria.reset();
	f_query_add_mod.frmphREPMARLabelCriteria.p_patient_id.disabled=false;
	f_query_add_mod.frmphREPMARLabelCriteria.Patient_Id_Button.disabled=false;
	f_query_add_mod.frmphREPMARLabelCriteria.btnPrint.disabled = true;
	f_query_results.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.document.getElementById("lbl_locn_from").innerText= getLabel("Common.Location.label","Common")+" "+getLabel("Common.from.label","Common");
}

async function callPatientSearch(){
	var patient_id = await PatientSearch();
	if (patient_id!= "" && patient_id != undefined){
		chkPatientID(patient_id);
	} 
}

function chkPatientID(patient_id){
	var formObj=document.frmphREPMARLabelCriteria;
	if(patient_id == undefined)
		patient_id = formObj.p_patient_id.value;
	if (patient_id!= "" ){
		formObj.p_patient_id.value = patient_id;
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
		xmlHttp.open( "POST", "PhRepMARLabelValidate.jsp?validate=patientsearch", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	} 
}

function showResults(){
	var frmObj = document.frmphREPMARLabelCriteria;
	var pat_id = frmObj.p_patient_id.value;
	var order_date = frmObj.order_date.value;
	var locn_type = frmObj.locn_type.value; 
	var p_fm_locn_code = frmObj.p_fm_locn_code.value;
	var p_to_locn_code = frmObj.p_to_locn_code.value;
	var order_type = frmObj.order_type.value;
		
	if(frmObj.mar_label_print_yn.value == "false" ) {
		msg = getMessage("PH_MAR_LABEL_NOT_APPL", "PH");
		alert(msg);
		frmObj.btnPrint.disabled = true;
		return false;
	}
	if(frmObj.p_patient_id.value=="" && (frmObj.p_fm_locn_code.value=="" || frmObj.p_to_locn_code.value=="") ) {
		parent.f_query_results.location.href="../../eCommon/html/blank.html";
		frmObj.btnPrint.disabled = true;
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', getLabel("Common.patientId.label","Common") +" / "+  getLabel("Common.LocationFrom.label","Common") + " & "+  getLabel("Common.to.label","Common")+ " ");
		alert(msg);
		return false;
	} 
	parent.f_query_results.location.href="../../ePH/jsp/PhRepMARLabelResult.jsp?patient_id="+pat_id+"&order_date="+order_date+"&locn_type="+locn_type+"&p_fm_locn_code="+p_fm_locn_code+"&p_to_locn_code="+p_to_locn_code+"&order_type="+order_type+"&called_from=search";
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function DateCheck(from,to) {

    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);

		if(Date.parse(todt) > Date.parse(fromdt)){
			var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(invaldt);
			//to.select();
			//to.focus();
			to.value="";
			return false;
		}
		else if(Date.parse(todt) <= Date.parse(fromdt)) 
			return true;
    }
    return true;
}

function CheckDateT(obj){
	var locale=document.frames.frmphREPMARLabelCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			//obj.select();
			//obj.focus();
			obj.value="";
			return false;
		}
	}
	else{
		
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}


function chkpatID(yes_no){
	var frmObj = "";
	formObj=document.frmphREPMARLabelCriteria;
	if(yes_no == "N"){
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		formObj.p_patient_id.focus();
	}
	else if(yes_no == "Y"){
		formObj.p_patient_id.disabled = true;
		formObj.Patient_Id_Button.disabled = true;
		
	}
}

function updateSelection(order_id,order_line_num, iv_prep_yn, checkBxObj){
	var frmObject		= document.frmphREPMARLabelResult;
	var frmObject		= parent.f_query_add_mod.document.frmphREPMARLabelCriteria;
	var report_id = ""
		
	if(checkBxObj.checked == true)
		checkBxObj.value='Y';
	else
		checkBxObj.value='N';
	document.frmphREPMARLabelResult.chkSelectAll.checked=false;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " iv_prep_yn=\""+iv_prep_yn+"\"";
	xmlStr += " order_id=\""+order_id+"\"";
	xmlStr += " order_line_num=\""+order_line_num+"\"";
	xmlStr += " select_yn=\""+checkBxObj.value+"\"";
	xmlStr += " bean_id=\"PhRepMARLabelBean\"";
	xmlStr += " bean_name=\"ePH.PhRepMARLabelBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhRepMARLabelValidate.jsp?validate=UPDATESELECTION",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function selectAll(selAllObj){
	var formObj = document.frmphREPMARLabelResult;
	
	for(i=0; i<formObj.recCount.value; i++){
		if(selAllObj.checked == true){
			if(eval('formObj.select_'+i) != undefined) {
				eval('formObj.select_'+i).checked = true;
				eval('formObj.select_'+i).value = 'Y';
			}
		}
		else{
			if(eval('formObj.select_'+i) != undefined) {
				eval('formObj.select_'+i).checked = false;
				eval('formObj.select_'+i).value = 'N';
			}
		}
	}
	if(selAllObj.checked == true)
		selAllObj.value='Y';
	else
		selAllObj.value='N';
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " selectAll_yn=\""+selAllObj.value+"\"";
	xmlStr += " bean_id=\"PhRepMARLabelBean\"";
	xmlStr += " bean_name=\"ePH.PhRepMARLabelBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhRepMARLabelValidate.jsp?validate=UPDATESELECTIONALL",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function resetLocation(){
	var formObj = document.frmphREPMARLabelCriteria;
	formObj.p_fm_locn_code.value="";
	formObj.p_to_locn_code.value="";
	formObj.location_from.value="";
	formObj.location_to.value="";
	var label = "";
	if(formObj.locn_type.value=='C') 
		label = getLabel("Common.clinic.label","Common");
	else if(formObj.locn_type.value=='N')
		label = getLabel("Common.nursingUnit.label","Common");
	else
		label = getLabel("Common.Location.label","Common");
	document.getElementById('lbl_locn_from').innerText=label+" "+getLabel("Common.from.label","Common");
}

async function locationLookup(target){
	var formObj = document.frmphREPMARLabelCriteria;
	if(formObj==undefined)
		var formObj = searchFrame.document.frames.formPHRepPatFillCriteria;
	var locn_type=formObj.locn_type.value;
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
			
			var retVal = await CommonLookup( "Nursing Unit", argumentArray );
			if(retVal != null && retVal != "" )  {
				var ret1=unescape(retVal);
			 	var arr=ret1.split(",");
				if(target.name=="location_from")
					formObj.p_fm_locn_code.value=arr[0];
				else
					formObj.p_to_locn_code.value=arr[0];
				target.value = arr[1] ;
			} 
		}
		else if (locn_type=="C"){
			argumentArray[0]   =  escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT1.value)+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( "Clinic", argumentArray );
			if(retVal != null && retVal != "" )  {
				var ret1=unescape(retVal);
			 	var arr=ret1.split(",");
				if(target.name=="location_from")
					formObj.p_fm_locn_code.value=arr[0];
				else
					formObj.p_to_locn_code.value=arr[0];
				target.value = arr[1] ;
			}
		}
	}
	else{
		alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));
		formObj.locn_type.focus()
	}
}

function SubmitLink(from,to){
	var obj							=	document.frmphREPMARLabelResult;
	obj.from.value					=	from;
	obj.to.value					=	to;
	obj.submit();
} 

function showReport(){	
	var frmObject		= parent.f_query_add_mod.document.frmphREPMARLabelCriteria;
	var Objectform = parent.f_query_results.document.frmphREPMARLabelResult;	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_user_name=\""+frmObject.p_user_name.value+"\"";
	xmlStr += " p_facility_id=\""+frmObject.p_facility_id.value+"\"";
	xmlStr += " p_language_id=\""+frmObject.p_language_id.value+"\"";
	xmlStr += " bean_id=\"PhRepMARLabelBean\"";
	xmlStr += " bean_name=\"ePH.PhRepMARLabelBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhRepMARLabelValidate.jsp?validate=PRINTMARLABELCHEK",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	if( result == 'Y'){
		xmlHttp.open("POST","PhRepMARLabelValidate.jsp?validate=PRINTMARLABEL",true); //changed from false(synchronous) to true(asynchronous) - on click of print the screen is freezing. 
		xmlHttp.send(xmlDoc);
		alert(getMessage("REPORT_SUBMITTED","PH"));
		result='N';
		parent.f_query_add_mod.frmphREPMARLabelCriteria.reset();
		parent.f_query_add_mod.frmphREPMARLabelCriteria.p_patient_id.disabled=false;
		parent.f_query_add_mod.frmphREPMARLabelCriteria.Patient_Id_Button.disabled=false;
		parent.f_query_add_mod.frmphREPMARLabelCriteria.btnPrint.disabled = true;
		parent.f_query_results.location.href="../../eCommon/html/blank.html";
	}
}

function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
	var patientId = document.frmphREPMARLabelCriteria.p_patient_id.value; 
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
	document.frmphREPMARLabelCriteria.p_patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */

