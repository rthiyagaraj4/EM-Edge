/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var flagChk          = false; //Only to DiBug
/*************Handle to the Frame 's and the form Object ****************/
var doc			=null;
var formObj		=null;
/****************************************************************/ 
function intialiseGlobal(){
function_id = "" ;
resultGlobal = false;
messageGlobal = "" ;
flagGlobal = true;
flagChk          = false
}
/*******************************************************************/
function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/SpecimenLblGenerationAddModify.jsp?mode=1&function_id="+function_id ;
}
/******************************************************************************/
function query() {
	f_query_add_mod.location.href="../../eOR/jsp/SpecimenLblGenerationQueryCriteria.jsp?function_id="+function_id ;
}
/**************function to fill combo Box Dynamically********************/

/*function fillComboOptions(obj) {
	getHandle();

	var source_type = formObj.source_type.value;
	var facility_id = formObj.ordering_facility_id.value;
	var  xmlAppend = ""; 
	var bean_id	   = formObj.bean_id.value ;

	if(source_type == ""){
		removeComboObject();
		return ;
	}
	
	xmlAppend += "source_type"+"=\""+ source_type+"\" " ;
	xmlAppend += "facility_id"+"=\""+ facility_id+"\" " ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SpecimenLblGenerationComboFill.jsp?bean_id="+bean_id,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert( responseText ) ;
	eval( responseText ) ;
}*/
/********************Dynamically add Option function************************/
/*function addComboObject(comboObjectString){
		 getHandle();
		doc.all.source_td.innerHTML = comboObjectString ;
}*/
/********************Dynamically remove Option function************************/
/*function removeComboObject(){
		 getHandle();
		doc.all.source_td.innerHTML ='&nbsp;<select name="source_code" id="source_code"><option value="">&nbsp;&nbsp;&nbsp;---Select---&nbsp;&nbsp;&nbsp;</option></select><img  src="../../eCommon/images/mandatory.gif"></img>' ;
}*/
/******************************************************************************/
function resetSourceType() {
		getHandle();
		formObj.source_type.selectedIndex = 0	;
		formObj.source_code.value=getLabel("Common.all.label","Common") ;
		formObj.source_desc.value=getLabel("Common.all.label","Common") ;
		formObj.source_desc_temp.value=getLabel("Common.all.label","Common") ;	
}

/***************************delete record********************************/
function deleterecord(){
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	getHandle();
	var mode = formObj.mode.value ;

	if(mode == '1'){//no action
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	
//	formObj.mode.value = "0"; //set mode to delete

//	alert(formApply(formObj));
	var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
	if(confirm_val){
		formObj.mode.value = "0"; //set mode to delete
		eval(formApply(formObj,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;	
		if(resultGlobal){
		create();
		intialiseGlobal();
		}
	}else
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
/******************************************************************************/
function apply() {
	//alert(checkIsValidForProceed());
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	getHandle();
	
//	if(!chkGeneration())  change made by kaushal under the instruction of Sunil on 4/5/2003
//	return false;

	var	fields = new Array (formObj.ordering_facility_id,
							formObj.source_type,
							formObj.source_code,
							formObj.urgency_indicator);
	var	names =	new	Array (getLabel("Common.facility.label","Common"),getLabel("eOR.SourceType.label","OR"),getLabel("Common.source.label","Common"),getLabel("eOR.Urgency.label","OR"));	
	if(!f_query_add_mod.checkFieldsofMst(fields,	names, messageFrame))
	return ;
	
	//alert(formApply(formObj,OR_CONTROLLER));
	//alert("source"+	formObj.source_type.value);
	//alert("fac"+	formObj.ordering_facility_id.value);
	//alert("sourcecode"+	formObj.source_code.value);
	//alert("urg"+	formObj.urgency_indicator.value);
	//alert("specimen type"+	formObj.specimen_type.value);

	//formObj.source_code.value="ALL";//encodeURIComponent(formobj.source_code.value);
	//alert("sourcecode"+encodeURIComponent(formObj.source_code.value));
	//formObj.source_code.value=encodeURIComponent(formObj.source_code.value);
	eval(formApply(formObj,OR_CONTROLLER));	
	//alert("messageGlobal="+messageGlobal);
	//alert("resultGlobal="+resultGlobal);
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
	if(resultGlobal) {
		
	onSuccess();
	}
}
/******************************************************************************/
function onSuccess() {
	getHandle();
	if( doc.mode.value == MODE_INSERT ) {
	
		reset();
	}else if( doc.mode.value == MODE_MODIFY ) {
f_query_add_mod.document.location.href="../../eOR/jsp/SpecimenLblGenerationAddModify.jsp?"+formObj.qry_str.value ;
	}
	
}
/******************************************************************************/
function reset() {
	var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if ( (url.indexOf("queryresult.jsp")!=-1) ||  (url.indexOf("blank")!=-1) )
		 return ;
		if(f_query_add_mod.document.forms[0].name == "specimenLblGeneration_add_mod"){//add Modify mode
		getHandle();
		formObj.reset();
		/*if(formObj.mode.value == '1')//insert mode
		removeComboObject();*/
		}else{
		f_query_add_mod.document.forms[0].reset();//Query Mode
		}
}
/******************************************************************************/
function assignResult(res,msg,mod){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;
}
/**********************Enable Disable the Generation text input**************/
function enableGeneration(){
	getHandle();
	if(formObj.label_gen_on_order_yn.checked == true){
		formObj.look_ahead_min.readOnly = false ;
	}else{
		formObj.look_ahead_min.readOnly = true ;
		formObj.look_ahead_min.value    = "" ;
	}

}
/**********************chk Generation **************/
function chkGeneration(){
	getHandle();
	if(formObj.label_gen_on_order_yn.checked == true){
		if(formObj.look_ahead_min.value  == "" ){
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("CHK_SPEC_GEN","OR");
		return false;
		}
	}

	return true;
}
/**********************Detail Handle**********************************/
function getHandle(){
 doc		 =f_query_add_mod.document ;	
 formObj	 =doc.specimenLblGeneration_add_mod ;
 
}
/**********************Check for Valid Operation***********************************/
function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/**********************on change of source type,reset the Source ***********************************/
function resetSource(obj){
	var formObject = f_query_add_mod.document.specimenLblGeneration_add_mod;
	formObject.source_code.value="ALL"
	formObject.source_desc.value=getLabel("Common.all.label","Common") ;
	formObject.source_desc_temp.value=getLabel("Common.all.label","Common") ;

}
/**********************Source Look up***********************************/
function before_showSourceWindow(target,code){

if(parent.f_query_add_mod.document.specimenLblGeneration_add_mod.source_desc_temp.value != target.value)
	if(target.value != "")
		Lookupwindow(target,code);

}

function showSourceWindow(target,code){

if(target.value == "")
	Lookupwindow(target,code);
}

 async function Lookupwindow(target,code){

	var formObject = parent.f_query_add_mod.document.specimenLblGeneration_add_mod;
	var facility_id = formObject.ordering_facility_id.value;
	var source_type = formObject.source_type.value;


	if(source_type == ''){
		target.value = getLabel("Common.all.label","Common") ;
   		code.value = getLabel("Common.all.label","Common") ;
		formObject.source_desc_temp.value =getLabel("Common.all.label","Common") ;
		return;
	}

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;		
 
	if (source_type == 'D')
	{
		argumentArray[0]	= formObject.departmentSql.value;
		dataNameArray[0] 	= "operating_facility_id" ;		 
 		dataValueArray[0] 	= facility_id;	 
 		dataTypeArray[0] 	= STRING ;
		argumentArray[4]   = "2,3";
	}else if (source_type == 'C'){
		argumentArray[0]	= formObject.clinicSql.value;
		dataNameArray[0] 	= "facility_id" ;		 
 		dataValueArray[0] 	= facility_id;	 
 		dataTypeArray[0] 	= STRING ;
		argumentArray[4]   = "2,3";
	}else if (source_type == 'N'){
		argumentArray[0]	= formObject.nursingUnitSql.value;
		dataNameArray[0] 	= "facility_id" ;		 
 		dataValueArray[0] 	= facility_id;	 
 		dataTypeArray[0] 	= STRING ;
		argumentArray[4]   = "2,3";
	}else if (source_type == 'R'){
		argumentArray[0]	= formObject.referralSql.value;
		argumentArray[4]   = "1,2";
	}

	argumentArray[1]   = dataNameArray ;
 	argumentArray[2]   = dataValueArray ;
 	argumentArray[3]   = dataTypeArray ;
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
  	retVal =await CommonLookup( getLabel("Common.source.label","Common"), argumentArray );
  	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != "")
	{
	  code.value=arr[0];
	  target.value=arr[1];
	  formObject.source_desc_temp.value=arr[1];
    }else{
	  code.value=getLabel("Common.all.label","Common") ;
	  target.value=getLabel("Common.all.label","Common") ;
	  formObject.source_desc_temp.value=getLabel("Common.all.label","Common") ;
    }
	
}

/******************************************************************************/

/**Reference Pattern for Frame's and form Object For Specimen Collection

Menu
	|
	SpecimenLblGeneration.jsp---->SpecimenLblGeneration.js
		|
		|------MstToolBar
		|
		|------SpecimenLblGenerationAddModify.jsp
		|		|		Document ---Doc
		|		|		FormObect---formObj
		|		
		|
		|------MessageFrame
		|
**/

