/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
-------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created
21/02/2014    IN000000     Chowminya      Akbar			21/02/2014			Clinical event item link with order format not working for LB n RD(results)	
---------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var format_flag = "" ;
var	qry_string =  "";


function create() 
{
	f_query_add_mod.location.href = "../../eOR/jsp/OrderEntryFormatItemAddModify.jsp?mode=1&function_id="+function_id ;
}

function query() 
{
	f_query_add_mod.location.href='../../eOR/jsp/OrderEntryForamtItemQueryCriteria.jsp?function_id='+function_id ;
}
function checkSpecialChar(event) 
{
	alert(event.keyCode)
	/*if(event.keyCode == '')
		return (event.keyCode = 32);
	if(event.keyCode == 126 || event.keyCode == 96 || event.keyCode == 64 || event.keyCode == 60 || event.keyCode == 38 || event.keyCode == 37 || event.keyCode == 35 || event.keyCode == 34 || event.keyCode == 39 || event.keyCode == 164 || event.keyCode == 181 || event.keyCode == 185 || event.keyCode == 179 || event.keyCode == 168) // || event.keyCode == 35 || event.keyCode == 37 || event.keyCode == 38 || event.keyCode == 92 || event.keyCode == 34 || event.keyCode == 39 || event.keyCode == 43  // || event.keyCode == 35 || event.keyCode == 37 || event.keyCode == 92 || event.keyCode == 43
		return (event.keyCode = '');*/
}

async function listDetail() 
{
		var dialogHeight ='55vh' ;
		var dialogWidth = '55vw' ;
		var dialogTop	= '10';
		var dialogLeft = '30' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";

		if(parent.f_query_add_mod.document.Order_Entry_Format_Item.finalString)
		{
			var formObj = parent.f_query_add_mod.document.Order_Entry_Format_Item;
			var field_mnemonic = formObj.field_mnemonic.value;
			var	finalString = parent.f_query_add_mod.document.Order_Entry_Format_Item.finalString.value;
			
			//alert("finalString===="+finalString);
			if(finalString != null ||finalString != ''  ){
				var from="";
				if(formObj.field_type.value=='L')
					 from="L";
				else if(formObj.field_type.value=='R')
					 from="R";
				//alert("from111="+from);
				//var retVals = window.showModalDialog("../../eOR/jsp/OrderEntryFormatItemFrame.jsp?from="+from+"&mode=updt&finalString="+encodeURIComponent(finalString),arguments,features);
				var retVals = await window.showModalDialog("../../eOR/jsp/OrderEntryFormatItemFrame.jsp?from="+from+"&mode=updt&field_mnemonic="+field_mnemonic,arguments,features);
				
				//alert("retVals"+retVals);

				if(retVals != "")
				{
					formObj.listValues.value = retVals;
					formObj.finalString.value = retVals;
				}
				else
				{
					//parent.f_query_add_mod.document.Order_Entry_Format_Item.listValues.value = finalString;
					formObj.listValues.value = retVals;
				}
			}
		}else{
			var finalString = parent.f_query_add_mod.document.Order_Entry_Format_Item.listValues.value;
			if(finalString != null ||finalString != ''  ){
				var from="";
				if(parent.f_query_add_mod.document.Order_Entry_Format_Item.field_type.value=='L')
					 from="L";
				else if(parent.f_query_add_mod.document.Order_Entry_Format_Item.field_type.value=='R')
					 from="R";
				//alert("from222="+from);
				//var retVals = window.showModalDialog("../../eOR/jsp/OrderEntryFormatItemFrame.jsp?from="+from+"&finalString="+encodeURIComponent(finalString),arguments,features);
				var retVals = await window.showModalDialog("../../eOR/jsp/OrderEntryFormatItemFrame.jsp?from="+from,arguments,features);
				parent.f_query_add_mod.document.Order_Entry_Format_Item.listValues.value = retVals;

			}
		}
}

function set_field_mnemonic_desc(obj)
{
	document.forms[0].field_mnemonic_desc.value=obj.value;
}
function apply(){
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		return false ;
	}
	var formObj = f_query_add_mod.document.Order_Entry_Format_Item;
	var fields = new Array ( formObj.field_mnemonic,formObj.field_mnemonic_desc,formObj.field_type					,formObj.order_category
						);

	var names = new Array ( getLabel("eOR.FieldMnemonic.label","OR"),
		getLabel("eOR.FieldMnemonicDesc.label","OR"),getLabel("eOR.FieldType.label","OR")
				,getLabel("Common.OrderCategory.label","Common")
					);

	if(formObj.eff_status.checked == true){
		formObj.eff_status.value = "E";
	}else{
		formObj.eff_status.value = "D";
	}

    if(formObj.field_type.value == 'M'){
		if(formObj.discrete_value.value == ''){
			var msg = getMessage('DISCRETE_MSR_NOT_NULL',"OR")
			formObj.discrete_value_disp.focus();
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			return false
		}
	}

    if(formObj.field_type.value == 'V'){
		if(formObj.discrete_value.value == ''){
			var msg = getMessage('CLINICAL_EVENT_BLANK','OR')
			formObj.discrete_value_disp.focus();
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			return false
		}
	}

	//alert("in js"+formObj.mode.value);
	if(formObj.listValues.value == "" && (formObj.field_type.value == "L" || formObj.field_type.value == "R") && formObj.mode.value == "1"){
		
		var msg = getMessage('FIELD_CANNOT_BE_EMPTY','OR')
			//"List values can not be empty...Click on \"Fields\" button...";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return false
		var listVal = formObj.listValues.value;
		listVal = 	listVal.substring(0,(listVal.length-1));
		formObj.listValues.value = listVal;
	}

    //alert(formObj.listValues.value);

	if(formObj.listValues.value == "" && (formObj.field_type.value == "L" || formObj.field_type.value == "R") && formObj.mode.value == "2"){
		var msg = getMessage('FIELD_CANNOT_BE_EMPTY','OR')
			//"List values can not be empty...Click on \"Fields\" button...";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return false
		var listVal = formObj.listValues.value;
		
		listVal = 	listVal.substring(0,(listVal.length-1));
		formObj.listValues.value = listVal;
	}
	if(formObj.field_type.value=="I" || formObj.field_type.value=="M" ||formObj.field_type.value=="N" ){

		if(chkValuesOnApply(formObj.field_type, formObj.min_value, formObj.max_value) == false){
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false
		}
	}

	if((formObj.field_type.value == 'N' || formObj.field_type.value == 'I') && (formObj.min_value.value != '')){
		if(!checkPositiveNumber(formObj.min_value)) {
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
	}

	if(formObj.mode.value == "2"){
		qry_string =  "mode=2&field_mnemonic="+formObj.field_mnemonic.value+"&field_mnemonic_desc="+formObj.field_mnemonic_desc.value+"&field_type="+formObj.field_type.value+"&order_category="+formObj.order_category_display.value+"&order_category_id="+formObj.order_category.value+"&eff_status="+formObj.eff_status.value+"&meaning="+formObj.meaning_value.value+"&hint="+formObj.hint.value+"&single_or_multi="+formObj.single_multi.value

	}


	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		//alert(messageFrame);
		var flds=new Array(formObj.field_mnemonic);
		var name=new Array(getLabel("eOR.FieldMnemonic.label","OR"));
		if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){

			
				//alert(eval(formApply( f_query_add_mod.document.Order_Entry_Format_Item,OR_CONTROLLER))) ;
			 eval(formApply( f_query_add_mod.document.Order_Entry_Format_Item,OR_CONTROLLER)) ;
			  //alert(formApply( 	f_query_add_mod.document.Order_Entry_Format_Item,OR_CONTROLLER));

			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
			if( result ) {
				onSuccess();
			}
			else{
				reset();
			}
		}
	}

}



function onSuccess() {
	var mode = f_query_add_mod.document.Order_Entry_Format_Item.mode.value;
	if( mode == "1" ) {
		formReset();
	}
	if(mode == "2"){
		//alert("modify String ::"+qry_string);
		f_query_add_mod.location.href='../../eOR/jsp/OrderEntryFormatItemAddModify.jsp?'+qry_string ;
		
	}
}


function formReset () {
	var formObj = f_query_add_mod.document.Order_Entry_Format_Item;

//alert("insert");
	formObj.field_mnemonic.value = "";
	formObj.field_mnemonic_desc.value = "";
	formObj.field_type.value = "";
	formObj.order_category.value = "";
	formObj.meaning.value = "";
	formObj.single_multi.value = "";
	formObj.hint.value = "";
//f_query_add_mod.location.reload();
f_query_add_mod.location.href = "../../eOR/jsp/OrderEntryFormatItemAddModify.jsp?mode="+MODE_INSERT
}

function reset(){
	if(f_query_add_mod.document.forms[0] != null){

		if(f_query_add_mod.document.forms[0].name == "Order_Entry_Format_Item"){
			f_query_add_mod.document.Order_Entry_Format_Item.reset();
			if(f_query_add_mod.document.Order_Entry_Format_Item.mode.value ==1){
				f_query_add_mod.document.getElementById("dynamicLables").innerHTML = "&nbsp;"
				f_query_add_mod.document.getElementById("dynamicValues").innerHTML = "&nbsp;"
			}

		}else{
			f_query_add_mod.document.forms[0].reset();
		}
	}

}


function assignResult(_result, _message, _flag){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;

}


async function show_discrete_window()	{
	//alert("in show_discrete_window,parent.frames[1].document.Order_Entry_Format_Item.field_type.value="+parent.frames[1].document.Order_Entry_Format_Item.field_type.value);
	// IMPORTANT -----!!!!!!!!!!!
	// if there are only  2 parameters(code, desc), the not set those to the dataNameArray, dataValueArray, dataTypeArray
	var discr_msr_id = "";
	var short_desc  = "";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
		//dataNameArray[0] = "discr_msr_id" ;
		//dataNameArray[1] = "short_desc" ;

		//discr_msr_id= "%"
		//short_desc= "%"

	var dataValueArray = new Array() ;
		//dataValueArray[0] = discr_msr_id ;
		//dataValueArray[1] = short_desc ;

	var dataTypeArray  = new Array() ;
		//dataTypeArray[0] = STRING ;
		//dataTypeArray[1] = STRING ;

	var discr_msr_disp = "";

	/*Modified by Uma on 3/18/2010 for IN020067*/
    if (parent.frames[1].document.Order_Entry_Format_Item.field_type.value == 'M') {
	   //argumentArray[0]   = "select discr_msr_id code,short_desc description from am_discr_msr where eff_Status ='E' and result_type not in('V','Z','H','P','A','R','S','X','G') and upper(discr_msr_id) like upper(?) and upper(short_desc) like upper(?) order by 2"
	   argumentArray[0]   = "select discr_msr_id code,short_desc description from am_discr_msr where eff_Status ='E' and result_type not in('Z') and upper(discr_msr_id) like upper(?) and upper(short_desc) like upper(?) order by 2";//IN000000
	} else if (parent.frames[1].document.Order_Entry_Format_Item.field_type.value == 'V') {
	   //argumentArray[0]   = "select distinct a.event_code code,a.short_Desc  description from cr_clin_event_mast a,am_discr_msr b where a.event_code=b.discr_msr_id and b.eff_status='E' and b.result_type not in('V','Z','H','P','A','R','S','X','G') and upper(a.event_code) like upper(?) and upper(a.short_desc) like upper(?)";
	   argumentArray[0]   = "select distinct event_code code,short_Desc  description from cr_clin_event_mast where upper(event_code) like upper(?) and upper(short_desc) like upper(?)";//IN000000
	}
	/*Ends Here by Uma on 3/18/2010 for IN020067*/
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = discr_msr_disp ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	//alert("before lookup,dataNameArray="+dataNameArray+" ,dataValueArray="+dataValueArray+" ,dataTypeArray="+dataTypeArray+" ,discr_msr_disp="+discr_msr_disp+" ,argumentArray[0]="+argumentArray[0]);
	retVal = await CommonLookup( getLabel("Common.DiscreteMeasure.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != "" )  {
		parent.frames[1].document.Order_Entry_Format_Item.discrete_value_disp.value = arr[1] ;
		parent.frames[1].document.Order_Entry_Format_Item.discrete_value.value = arr[0];
	}

}


function chkType(){
	//alert("in chkType");
	var formObj = document.Order_Entry_Format_Item

	if(formObj.field_type.value == 'L' || formObj.field_type.value == 'R'){		
			if(formObj.field_type.value == 'L'){
				formObj.presentation_type.disabled=false;
				//formObj.presentation_type.value="S";
				formObj.presentation_type.value="";

			}
		document.getElementById("dynamicLables").innerHTML = ""
		document.getElementById("dynamicValues").innerHTML = "<input type='button' name='list_button' id='list_button' class='button'  id='NumericField'  value='"+getLabel('eOR.Fields.label','OR')+"' onClick='listDetail()'>"
	}else if(formObj.field_type.value == 'M'){
		document.getElementById("dynamicLables").innerHTML = ""
		document.getElementById("dynamicValues").innerHTML = "<input type='hidden' name='discrete_value' id='discrete_value' value=''><input type='text' name='discrete_value_disp' id='discrete_value_disp' value='' size=15 maxlength=40 onFocus='javascript:blur();'><input type='button' name='descrete_button' id='descrete_button' class='button'  id='descFields'  value='?' onClick='show_discrete_window()'><img src='../../eCommon/images/mandatory.gif'>"
	}else if(formObj.field_type.value == 'V'){
		document.getElementById("dynamicLables").innerHTML = ""
		document.getElementById("dynamicValues").innerHTML = "<input type='hidden' name='discrete_value' id='discrete_value' value=''><input type='text' name='discrete_value_disp' id='discrete_value_disp' value='' size=15 maxlength=40 onFocus='javascript:blur();'><input type='button' name='descrete_button' id='descrete_button' class='button'  id='descFields'  value='?' onClick='show_discrete_window()'><img src='../../eCommon/images/mandatory.gif'>"
	}else if(formObj.field_type.value == 'I'){
		document.getElementById("dynamicLables").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getLabel('Common.MIN.label','Common') +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getLabel('Common.Max.label','Common');
		document.getElementById("dynamicValues").innerHTML = "<input type=text name=min_value id='min_val' size=6 maxlength=6  onKeyPress='return(ChkNumberInput(this,event,0))' onKeyDown='return check(this)'>&nbsp;&nbsp;&nbsp;<input type=text name=max_value id='max_val' size=6 maxlength=6  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chkValues()'>"
	}else if(formObj.field_type.value == 'N'){
		document.getElementById("dynamicLables").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getLabel('Common.MIN.label','Common')+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getLabel('Common.Max.label','Common');
		document.getElementById("dynamicValues").innerHTML = "<input type=text name=min_value id='min_val' size=6 maxlength=6  onKeyPress='return(OrAllowDecimalNumber())' onKeyDown='return check(this)'>&nbsp;&nbsp;&nbsp;<input type=text name=max_value id='max_val' size=6 maxlength=6  onKeyPress='return(OrAllowDecimalNumber())'    onBlur='chkValues()' >"
	}else{
		document.getElementById("dynamicLables").innerHTML = ""
		document.getElementById("dynamicValues").innerHTML = ""
	}
	if(formObj.field_type.value != 'L'){
		//	formObj.presentation_type.value="S";
		//	formObj.presentation_type.disabled=true;
		formObj.presentation_type.value="";
		formObj.presentation_type.disabled=true;
	}
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		xmlStr ="<root><SEARCH " ;
		validate = "SET_REF_CONTENT";
		xmlStr +=" /></root>" ;
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		flag='true';
		xmlHttp.open( "POST", "OrderEntryFormatItemValidate.jsp?validate="+validate+'&flag='+flag, false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
			eval(responseText);
}




function allowPositiveNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   };
}

function checkPositiveNumber(obj) {  
   var obj_value = obj.value;    // checks for positive number greater than zero
   var obj_length = obj_value.length;
	if(obj.value == ""){
		return true;
	}
	if(obj != null ){
		if(obj_value > 0){
			return true;
		}else{
			alert(getMessage("ONLY_POSITIVE_NUM","OR"));
			obj.value= ""
			obj.focus();
			return false;
		}
	}else{
		return true;
	}
}

function check(obj) {
	var key = window.event.keyCode;
	//alert(key);
	//return false;
	if (key == 9) {
		//alert(checkPositiveNumber(obj));
		if(!checkPositiveNumber(obj)) {
			return false;
		}
	}
}


function chkValues(){
	var formObj = document.Order_Entry_Format_Item

	if(formObj.max_value){
		if(!(checkPositiveNumber(formObj.max_value))) // this will chk [sitive number for max value field
			return false

		var field_type = formObj.field_type.value;

		if(field_type== "")
			return true ;

		if(field_type == 'N' || field_type== 'I') {
			var min_val = formObj.min_value.value;
			var max_val = formObj.max_value.value;
			chkValuesOnApply(formObj.field_type, formObj.min_value, formObj.max_value )
		}
	}
}

function chkValuesOnApply(field_type , min_val, max_val ){

	if(field_type.value == "")
		return true ;

	if(field_type.value == 'N')
		if(chkDecimalValuesOnApply( min_val, max_val))
			return true
		else
			return false
	if(field_type.value== 'I')
		if(chkNumericValuesOnApply( min_val, max_val))
			return true
		else
			return false

}

function chkDecimalValuesOnApply( min_val, max_val){
	if((max_val.value != "" && min_val.value == "") || (max_val.value == "" && min_val.value != "")) {
		if((max_val.value == "" && min_val.value != "")) {
			alert(getMessage('MAX_VAL_NOT_BLANK',"OR"));
			max_val.focus();
			return false;
		}
		if((max_val.value != "" && min_val.value == "")) {
			alert(getMessage('MIN_VAL_NOT_BLANK','OR'));
			min_val.focus();
			return false;
		}
	}else if(parseFloat(min_val.value) > parseFloat(max_val.value)){
		alert(getMessage('MIN_LESS_THAN_MAX','OR'));
		max_val.focus();
		return false;
	}else if(parseFloat((max_val.value)) == 0){
		alert(getMessage('MAX_VAL_NOT_ZERO','OR'));
		max_val.focus();
		return false;
	}else if(!(max_val.value > 0) && max_val.value != ''){
		alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','SM'));
		max_val.focus();
		return false;
	}else if(!(min_val.value > 0 ) && max_val.value != ''){
		alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','SM'));
		min_val.focus();
		return false;
	}else {
		return true;
	}
}

function chkNumericValuesOnApply( min_val, max_val){


  /* if(((max_val.value.charAt(0) == "0") && (max_val.value == "1")) || ((max_val.value.charAt(0) == "0") && (max_val.value.charAt(1) == "0") &&  (max_val.value == "2"))){
	   alert(getOrMessage('MAX_VAL_NOT_ZERO'))
	   return false
   }*/

		if(parseInt(eval(max_val.value)) == 0){
			alert(getMessage('MAX_VAL_NOT_ZERO','OR'))
			return false;
		} else if((max_val.value != "" && min_val.value == "") || (max_val.value == "" && min_val.value != "")) {
			if((max_val.value == "" && min_val.value != "")) {
				alert(getMessage('MAX_VAL_NOT_BLANK','OR'))
				max_val.focus();
				return false;
			}
			if((max_val.value != "" && min_val.value == "")) {
				alert(getMessage('MIN_VAL_NOT_BLANK','OR'))
				min_val.focus();
				return false;
			}
		} else if(parseInt(eval(min_val.value)) > parseInt(eval(max_val.value))){
			alert(getMessage('MIN_LESS_THAN_MAX','OR'));
			max_val.focus();
			return false;
		} else{
			return true;
		}
}
//Added for Restricting First Character from Numerics and '_'
function ChangeUpperCaseSpecific(obj) {
	//alert(obj.value)
	var strCheck = '0123456789_';
	if ((obj.value).length != 0) {
			if (strCheck.indexOf((obj.value).charAt(0)) != -1) {
				alert(getMessage("FIELD_MNEMONIC_START_WITH","OR"))
				obj.focus()
				return false;
			}
		}
	ChangeUpperCase(obj);
}//End of Addition

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/*function beforePost(str) {
	alert(str);
}
*/
function buildXml(frmObj){
    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
    var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
	frmObj = frmObjs[frmCount]
	var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
			}
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

			}
			else {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		}
	}

    xmlStr +=" /></root>";

	return xmlStr;

}
function syncStatus(flag) 
{
	return flag ;
}
function syncFormatStatus(format_flag) 
{
	parent.list_bottom.list_dtl.format_flag.value=format_flag;
	return format_flag ;
}
function displayFormatdesc(value)
{
	
}
function getFormatdesc(key)
{
	
	var descarray=new Array();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	var functional_mode="getFormatdesc";
	xmlStr ="<root><SEARCH " ;
	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "OrderEntryFormatItemValidate.jsp?validate="+functional_mode+"&key="+key,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	if(responseText!=null)
	{
		descarray=responseText.split('"');
		return descarray[1];
	}
	else
	{
		return;
	}
}

var i=0;
var dontChk=0;
function closeWindow(){
	count=0;
	var finalString = "";
	getTotalFormatValues("total_rows");
	format_flag=document.list_dtl.format_flag.value;
	document.list_dtl.finalString.value = finalString;
	
	if(format_flag=="true")
	{
		
		window.returnValue = "insert";
		document.list_dtl.value="insert";
	}
	else
	{
	
		window.returnValue="";
		document.list_dtl.value="";
	}
	//window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}



function takeValues(){
	var finalString = "";
	count=0;
	document.getElementById("list_dtl").finalString.value = finalString;
	
	getTotalFormatValues("total_rows");
	format_flag=document.list_dtl.format_flag.value;
	
	if(format_flag=="true")
	{
		
		window.returnValue = "insert";
		document.list_dtl.value="insert";
	}
	else
	{
		
		window.returnValue="";
		document.list_dtl.value="";
	}
	//window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}


function removeValues(){
var tmp_seq_arr = new Array();
var tmp_desc_arr = new Array();
var tmp_key_arr = new Array();
var del_arr = new Array();
var del_arr1 = new Array();
var count = 0;
var count1 = 0;

	if(document.list_dtl.desc.value == "" || document.list_dtl.seq_no.value == ""){
		alert(getMessage('SELECT_TO_CLEAR','OR'))
		return false;
	}

	dontChk = document.list_dtl.dontChk.value ;
	/*The below block was Added by Channaveer B on 2010-03-25 */
	if(dontChk == "")
	{
		document.list_dtl.desc.value = "" ; 
		document.list_dtl.seq_no.value = "";
		return false;
	}
	
	for(i=0; i<parent.list_top.seq_arr.length; i++){

		if(i != dontChk){
			tmp_seq_arr[count] =  parent.list_top.seq_arr[i];	
			tmp_desc_arr[count]=getFormatdesc("desc_array"+i);
			tmp_key_arr[count] =  parent.list_top.key_arr[i];
          
			count++;
		}
	}
	parent.list_top.seq_arr = tmp_seq_arr;
	parent.list_top.desc_arr = tmp_desc_arr;
	parent.list_top.key_arr = tmp_key_arr;
	


	var finalString = "";
	if(parent.list_top.seq_arr.length>0){
	
		for(count=0; count<parent.list_top.seq_arr.length; count++){
						
			setFormatValues("desc_array"+count,parent.list_top.desc_arr[count]);
			setFormatValues("seq_array"+count,parent.list_top.seq_arr[count]);				
			setFormatValues("key_array"+count,parent.list_top.key_arr[count]);
			
		}
	}
	setFormatValues("total_rows",count);
	getTotalFormatValues("total_rows");
	format_flag=document.list_dtl.format_flag.value;
	document.list_dtl.finalString.value = finalString;
	
	if(format_flag=="true")
	{
	
		document.list_dtl.seq_no.value = "";
		document.list_dtl.desc.value = "";
		document.list_dtl.dontChk.value = "";
		document.list_dtl.finalString.value="insert";
		document.list_dtl.mode.value = "insert";
		document.list_dtl.action  = "OrderEntryFormatItemListTop.jsp";
		document.list_dtl.target = "list_top";
		document.list_dtl.submit();
	
		dontChk = 0;
	}
	/*The below block was Added by Channaveer B on 2010-03-25 */
	else
	{
		parent.list_top.location.href = parent.list_top.location.href;
        window.document.list_dtl.reset();
	}  

		

}

async function chkMandatory(){
	var count=0;
	var finalString = "";
	var seq_num= document.list_dtl.seq_no.value;
	var desc_val = document.list_dtl.desc.value;

	var descarray=new Array();
	var seqarray=new Array();
	var keyarray=new Array();

	var isSpace = 0;
	for(i=0; i<desc_val.length; i++){
		if(desc_val.charAt(i) != " "){
			isSpace = 1
			break;
		}
	}
	if(document.list_dtl.desc.value == "")
	{
		alert(getMessage('DESC_NOT_BLANK','OR'))
		document.list_dtl.desc.focus();
		return false;
	}
	if(isSpace == "0")
	{
		alert(getMessage('DESC_NOT_SPACES','OR'))
		document.list_dtl.desc.value= "";
		document.list_dtl.desc.focus();
		return false;
	}

	if(document.list_dtl.seq_no.value == "")
	{
		alert(getMessage('SEQ_NO_NOT_BLANK','OR'))
		document.list_dtl.seq_no.focus();
		return false;
	}
	else if(isNaN(document.list_dtl.seq_no.value) == true)
	{
		alert(getMessage('ONLY_NUMBERS','OR'))
		document.list_dtl.seq_no.value="";
		document.list_dtl.seq_no.focus();
		return false;
	}
	else if(document.list_dtl.seq_num == 0)
	{
		alert(getMessage('SEQ_NO_NOT_ZERO','OR'))
		document.list_dtl.seq_no.focus();
		return false;
	}
	else if(((seq_num.charAt(0) == "0") && (seq_num.length == "1")) || ((seq_num.charAt(0) == "0") && (seq_num.charAt(1) == "0") &&  (seq_num.length == "2")))
	{
		alert(getMessage('SEQ_NO_NOT_ZERO','OR'))
		return false
	}
	else if(seq_num.substring(0,1) == '0')
	{
		document.list_dtl.seq_no.value = seq_num.substring(1,seq_num.length);
	}
	await makeValidString(document.list_dtl.desc);
	var tmp_desc = document.list_dtl.desc.value;
	var tmp_seq_no = document.list_dtl.seq_no.value;

	dontChk = document.list_dtl.dontChk.value ;


	if(parent.list_top.seq_arr.length>0)
	{
		for(count=0; count<parent.list_top.seq_arr.length; count++)
		{

			count = parseInt(count);
			dontChk = parseInt(dontChk)
		
			if(count != dontChk)
			{
				if(getFormatdesc("desc_array"+count)== tmp_desc )
				{
						alert(getMessage('DUP_DESC','OR'))
						document.list_dtl.desc.value= "";
						document.list_dtl.desc.focus();
						return false;
				}
				if(parent.list_top.seq_arr[count] == tmp_seq_no)
				{
					alert(getMessage('DUP_SEQ_NUM','OR'))
					document.list_dtl.seq_no.value= "";
					document.list_dtl.seq_no.focus();
					return false;
				}
			}
		}
	}


	if(document.list_dtl.mode.value == 'update')
	{

		for(count=0; count<parent.list_top.seq_arr.length; count++)
		{
		
			if(parent.list_top.desc_arr[count] == document.list_dtl.old_desc.value)
			{
				parent.list_top.desc_arr[count] = tmp_desc;
			}
			
			if(parent.list_top.seq_arr[count] == document.list_dtl.old_seq_no.value)
			{
				parent.list_top.seq_arr[count] = tmp_seq_no;
			}
		}
	}
	else 
	{
		if(parent.list_top.seq_arr.length !=0)
		{
			i = parent.list_top.seq_arr.length;
		}
		else
		{
			i = 0;
		}

		parent.list_top.seq_arr[i] = tmp_seq_no;
		parent.list_top.desc_arr[i] = tmp_desc;


	}

	if(parent.list_top.seq_arr.length>0){
		for(count=0; count<parent.list_top.seq_arr.length; count++){
			
			setFormatValues("seq_array"+count,parent.list_top.seq_arr[count]);
			if(isNaN(dontChk))
			{
			
				setFormatValues("desc_array"+((parent.list_top.seq_arr.length)-1),document.list_dtl.desc.value);
			
			}
			if(count==dontChk)
			{
		
				setFormatValues("desc_array"+count,document.list_dtl.desc.value);
			}
			
			
				setFormatValues("key_array"+count,parent.list_top.key_arr[count]);
			
		}

	}
	await setFormatValues("total_rows",count);
	await getTotalFormatValues("total_rows");

	document.list_dtl.finalString.value = finalString;
	

	format_flag=document.list_dtl.format_flag.value;
	if(format_flag=="true")
	{	
		document.list_dtl.seq_no.value = "";
		document.list_dtl.desc.value = "";
		document.list_dtl.dontChk.value = "";
		document.list_dtl.finalString.value="insert";
		document.list_dtl.mode.value = "insert";
		document.list_dtl.action  = "OrderEntryFormatItemListTop.jsp";
		document.list_dtl.target = "list_top";
		document.list_dtl.submit();
		
		dontChk = 0;
	}
}

function setFormatValues(key,value)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	var functional_mode="Formatvalues";
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open( "POST", "OrderEntryFormatItemValidate.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value),false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

function getTotalFormatValues(key)
{
	
	var functional_mode="TotalFormatvalues";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = "<root><SEARCH key=\""+key+"\" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "OrderEntryFormatItemValidate.jsp?validate=TotalFormatvalues", false);
	//xmlHttp.setRequestHeader("Content-Type", "text/xml"); 
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText; 
	eval(responseText); 

}

/*function getTotalFormatValues(key, callback) {
    var xmlHttp = new XMLHttpRequest();
    var xmlStr = "<root><SEARCH key=\"" + encodeURIComponent(key) + "\" /></root>";
    var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    xmlHttp.open("POST", "OrderEntryFormatItemValidate.jsp?validate=TotalFormatvalues", true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");

    xmlHttp.onload = function() {
       
        if (callback && typeof callback === 'function') {
            callback(xmlHttp.responseText);
        }
    };

    xmlHttp.onerror = function() {
        console.error("Network error or failed to reach the server.");
    };

    xmlHttp.send(xmlDoc);
}


getTotalFormatValues('someKey', function(responseText) {
   
    //console.log(responseText);
});*/
