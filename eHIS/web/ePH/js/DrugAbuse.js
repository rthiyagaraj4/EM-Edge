 
var function_id		= "PH_DRUG_ABUSE" ;
var result			= false ;
var message			= "" ;
var flag			= "" ;

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugAbuseAddModify.jsp?mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugAbuseQueryCriteria.jsp?mode="+MODE_MODIFY;
}

function deleterecord() {
	formObj = f_query_add_mod.document.formDrugAbuse; 
	f_query_add_mod.document.formDrugAbuse.mode.value=MODE_DELETE;  
	if(formObj.p_restriction_type.value!=null && formObj.p_restriction_type.value=='DC') {
		if(formObj.p_drug_class_drug_code== undefined){
			var fields	= new Array ( formObj.p_patient_id ,formObj.p_drug_class);
		}
		else{
			var fields	= new Array ( formObj.p_patient_id ,formObj.p_drug_class_drug_code);	
		}
		
		var names	= new Array (getLabel("Common.patientId.label","Common"), getLabel("ePH.DrugClass.label","PH"));
	} else  { //drug name 
		var fields	= new Array ( formObj.p_patient_id ,formObj.p_drug_code);
		var names	= new Array (getLabel("Common.patientId.label","Common"), getLabel("Common.DrugName.label","Common"));
	}
	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
	apply();
	}
}

function apply() {
		
		formObj = f_query_add_mod.document.formDrugAbuse;  
		var mode	= formObj.mode.value;
		var names  = "";
		var fields = "";
		if(mode == MODE_INSERT) {
			if(formObj.p_restriction_type.value!=null && formObj.p_restriction_type.value=='DC') {
				var fields	= new Array ( formObj.p_patient_id ,formObj.p_drug_class);
				var names	= new Array (getLabel("Common.patientId.label","Common"), getLabel("ePH.DrugClass.label","PH"));
			} else  { //drug name 
				var fields	= new Array ( formObj.p_patient_id ,formObj.p_drug_code);
				var names	= new Array (getLabel("Common.patientId.label","Common"), getLabel("Common.DrugName.label","Common"));
			}
			if(formObj.p_action_type.value=='U')
			{
				//alert("This is not a valid operation");
				messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num="+ getMessage("NOT_VALID_OPRATION","PH");
				return false;
			}
 			if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
			{
				eval(formApply(  formObj,PH_CONTROLLER) ) ;
				messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num="+ message;
     			if( result ) {
					onSuccess();
				}		 			
			}
		} else if(mode == MODE_DELETE) {
			if(confirm(getMessage("ABUSE_DRUG_REMOVE_CONFIRM","PH"))){
			  eval(formApply(  formObj,PH_CONTROLLER) ) ;
				messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num="+ message;
 				if( result ) {
					onSuccess();
				}
			}
			else{
				messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
			}
			}
			else{	eval(formApply(  formObj,PH_CONTROLLER) ) ;
					messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num="+ message;
     				if( result ) {
						onSuccess();
					}
			}
	}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function reset() {
		formObj = f_query_add_mod.document.formDrugAbuse; //(Insert mode)
		if(!formObj ||  formObj== undefined) // Modify mode 
			formObj = f_query_add_mod.document.formDrugAbuseCriteria; //(Modify mode)

		var mode = formObj.mode.value;
	
		if( mode == MODE_INSERT ) {
    		f_query_add_mod.location.href="../../ePH/jsp/DrugAbuseAddModify.jsp?mode="+MODE_INSERT;
		} else {
			//formObj.reset();
			f_query_add_mod.location.href="../../ePH/jsp/DrugAbuseQueryCriteria.jsp?mode="+MODE_MODIFY;
		}
}

function onSuccess() {

 		f_query_add_mod.location.href="../../ePH/jsp/DrugAbuseAddModify.jsp?mode="+MODE_INSERT;
}   


// This will call common patient search
function callPatientSearch(patientIdObj){

	var formObj=patientIdObj;
	//document.formDrugAbuse;
	var patient_id = PatientSearch();
	if (patient_id!= "" && patient_id != undefined){

		formObj.p_patient_id.value = patient_id;

		if(formObj.mode.value == MODE_INSERT) { 
			formObj.p_patient_id.disabled = true;
			formObj.btnPatientID.disabled = true;
			getPatientDetails(formObj);
		}

	}
}

function getPatientDetails(formObj) {
	
		var patientIdObj = formObj.p_patient_id
		patient_id = patientIdObj.value;
		document.getElementById("patient_detail").innerText="";
		if(patient_id=="" || trimString(patient_id)==""){
			patientIdObj.value = "";
			return false;
		}
		else if(patient_id.length < patientIdObj.maxLength){
			alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
			patientIdObj.value = "";
			patientIdObj.disabled = false;
			document.formDrugAbuse.btnPatientID.disabled = false;
			return false;
		}

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr ="<root><SEARCH " ;
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DrugAbuseValidate.jsp?validate=getPatientDetails"+"&patient_id=" + patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText) ;

}


function dispPatientDtails(p_name,p_age,p_sex){
	//document.getElementById("patient_detail").innerText=  decodeURIComponent(p_name,"UTF-8")+" / "+p_age+" / " +p_sex;
	document.getElementById("patient_detail").innerText=  decodeURIComponent(p_name,"UTF-8");
}

function alertInvalidPat(){
	alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
	document.formDrugAbuse.p_patient_id.value = "";
	return false;
}
 
//AAKH-CRF-0140 - STARTS
function restrictionType(obj){

	if(obj!=null && obj.value=='DC') {
		document.getElementById("drug_class").style.visibility		= "visible";
		document.getElementById("drug_class_dtl").style.visibility	= "visible";
		document.getElementById("drug_name").value					= "";
		document.getElementById("p_drug_code").value					= "";
		document.getElementById("drug_name_id").style.visibility		= "hidden";
		document.getElementById("drug_search_id").style.visibility	= "hidden";
	//	document.getElementById("drug_class_id").style.visibility		= "visible";
		if( document.getElementById("drug_image_id") != undefined){
		document.getElementById("drug_image_id").style.visibility		= "hidden";
		}

		
	} else {
		document.getElementById("p_drug_class").value					= "";
		document.getElementById("drug_class").style.visibility		= "hidden";
		document.getElementById("drug_class_dtl").style.visibility	= "hidden";
		document.getElementById("drug_name_id").style.visibility		= "visible";
		document.getElementById("drug_search_id").style.visibility	= "visible";
//		document.getElementById("drug_class_id").style.visibility		= "hidden";
		if( document.getElementById("drug_image_id") != undefined){
		document.getElementById("drug_image_id").style.visibility		= "visible";
		}
	}
}  

function callDrugSearch(obj) {
		formObj = document.formDrugAbuse; //(Insert mode)
		if(!formObj) // Modify mode 
			formObj = document.formDrugAbuseCriteria; //(Insert mode)
		var arrCodeDesc = DrugSearch("D",obj);
		if(arrCodeDesc != null && arrCodeDesc != "" ) {
			formObj.p_drug_code.value	=	arrCodeDesc[0];
			obj.value =	arrCodeDesc[1];
			//formObj.drug_search.disabled=true;
		}
	}

function AllowFormat()
{
	   var key = window.event.keyCode;
		if(key == 34 ) //do not allow double quotes
			{  
				return false;
			}
}

function checkMaxLength(obj)
{
	var val = "";
	val = obj.value;	
	if(obj.value.length > 100) {
			var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
			msg = msg.replace("$",getLabel("Common.remarks.label","Common"));
			msg = msg.replace("#",100);
			alert(msg);
			obj.value = val.substring(0,100);
		
	}
}

function enableAutoRequest(obj){
	if(obj.checked == true){
		obj.value = "Y";
	}else{
		obj.value = "N";
	}
}


//function Modify(obj) {

function Modify(patient_id,restriction_type,drug_class_or_drug_code) {
	//var patient_id		 = obj.cells[1].innerText;

parent.f_query_add_mod.location.href="../../ePH/jsp/DrugAbuseAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&p_patient_id="+patient_id+"&p_restriction_type="+restriction_type+"&p_drug_class_or_drug_code="+escape(drug_class_or_drug_code);
}

function addOrderByCol(){  
	var i=0;
	var from = document.getElementById("item")('orderbycols'); 
	if ( from.options.length > 0 ) {
		var to = document.getElementById("item")('orderbycolumns'); 
		var element = document.createElement('OPTION');
		var seltdIndex = from.selectedIndex;
		if(seltdIndex > -1){
			element.text = from.options[from.selectedIndex].text;
			element.value= from.options[from.selectedIndex].value; 
			to.add(element);      
			from.remove(from.selectedIndex);
			if(from.options[i])
				from.options[i].selected=true ;
			i++;
		}
	} 
} 

function removeOrderByCol(){
	var j=0;
	var from = document.getElementById("item")('orderbycolumns');
	if ( from.options.length > 0 ){ 
		var to = document.getElementById("item")('orderbycols');
		var element = document.createElement('OPTION');
		var seltdIndex = from.selectedIndex;
		if(seltdIndex > -1){
			element.text = from.options[from.selectedIndex].text;
			element.value = from.options[from.selectedIndex].value;
			to.add(element);    from.remove(from.selectedIndex);
			if(from.options[j]) 
				from.options[j].selected=true; 
			j++;
		}
	}
}  



function SelectAll(){
	var i = 0;
	document.getElementById("orderbycolumns").selectedIndex=0; 
	while ( i < document.getElementById("orderbycolumns").length) {
		document.getElementById("orderbycolumns").options[i].selected=true;
		i++; 
	}
}  

function execQuery(){
	if(document.getElementById("orderbycolumns").options.length >0 ){
		SelectAll(); 
		document.formDrugAbuseCriteria.submit();
	}
	else{
		alert(getMessage('ORDERBY_NOT_BLANK',"Common"))
	}
}


function charsCapsSpaceDotCamasOnly(){
	if(event.keyCode >=65 && event.keyCode<=90)
		event.keyCode = event.keyCode;
	else if(event.keyCode >=97 && event.keyCode<=122)
		event.keyCode = event.keyCode;
	else if(event.keyCode >=48 && event.keyCode<=57)
		event.keyCode = event.keyCode;
	else 
		event.keyCode=0;
 }
function searchDrug(obj){
	var locale=document.formDrugAbuseCriteria.locale.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql_order_type ="SELECT DRUG_CODE CODE, DRUG_DESC DESCRIPTION FROM PH_DRUG_LANG_VW PH_DRUG WHERE DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID = #"; 
      sql_order_type=sql_order_type.replace("#","'"+locale+"'");
	argumentArray[0]   = sql_order_type;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2,3";
	argumentArray[5]   = document.formDrugAbuseCriteria.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.DrugSearch.label","PH"), argumentArray );
	if(retVal != '' && retVal != undefined){
		document.formDrugAbuseCriteria.drug_name.value = retVal[1] ;
		document.formDrugAbuseCriteria.p_drug_code.value = retVal[0];
		}
}
function searchDrug1(obj){
	var locale=document.formDrugAbuse.locale.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql_order_type ="SELECT DRUG_CODE CODE, DRUG_DESC DESCRIPTION FROM PH_DRUG_LANG_VW PH_DRUG WHERE DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID = #"; 
      sql_order_type=sql_order_type.replace("#","'"+locale+"'");
	argumentArray[0]   = sql_order_type;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2,3";
	argumentArray[5]   = document.formDrugAbuse.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.DrugSearch.label","PH"), argumentArray );
	if(retVal != '' && retVal != undefined){
		document.formDrugAbuse.drug_name.value = retVal[1] ;
		document.formDrugAbuse.p_drug_code.value = retVal[0];
		}
}
function changeActionType(){
	var formObj=document.formDrugAbuse;
	var actionType=formObj.p_action_type.value;
	if(actionType=='U'){
		formObj.p_restrict_transaction_yn.value="N";
		formObj.p_restrict_transaction_yn.disabled=true;
		formObj.p_restrict_transaction_yn.checked=false;
		
	}
	else{
		formObj.p_restrict_transaction_yn.disabled=false;
		//formObj.p_restrict_transaction_yn.checked=false;
		
	}
}
function restrictionTypeValidate(){
	restrictionType(document.formDrugAbuseCriteria.p_restriction_type);
}
