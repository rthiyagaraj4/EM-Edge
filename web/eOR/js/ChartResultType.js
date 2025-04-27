/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var	qry_string =  "";
/*var chart_result_type="";
var chart_result_type_desc="";
var chart_horzi_desc="";
var chart_no_columns="";
var chart_vert_desc="";
var mode="";
*/						  
/***************************************************************************************/
function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/ChartResultTypeAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
}


function query() {
	f_query_add_mod.location.href='../../eOR/jsp/ChartResultTypeQueryCriteria.jsp';
}


function reset(){
	if(f_query_add_mod.document.forms[0] != null){
		if(f_query_add_mod.document.forms[0].name == "formChartResultAdd"){
			f_query_add_mod.document.formChartResultAdd.reset();
		}else{
			f_query_add_mod.document.forms[0].reset();
		  //f_query_add_mod.location.href='../../eOR/jsp/ChartResultTypeQueryCriteria.jsp';
		}
	}
	}


/****************************************************************************************/

/*used to chk for spec chars but does not convert to uppercase*/
function CheckSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

/*****************************************************************************************/
function CheckSpecCharsCols(event){
    var strCheck = '123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function vali()
{
	if(event.keyCode==68 || event.keyCode==80 ||event.keyCode==100 ||event.keyCode==112 )
		return false
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
			obj.value= ""
			obj.focus();
			var message  = getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','OR');
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false;
		}
	}else{
		return true;
	}
}

/******************************************************************************************/


/*used to chk for special chars n chng it to upper case and does not allow p and d*/
function CheckTypeChars(event){
    var strCheck = '0123456789abcefghijklmnoqrstuvwxyzABCEFGHIJKLMNOQRSTUVWXYZ_*';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


/****************************************************************************************/


function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}


/*****************************************************************************************/

function apply(){
	

	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	//var mode = f_query_add_mod.document.formChartResultAdd.mode.value
	var bean_id = f_query_add_mod.document.formChartResultAdd.bean_id.value
	var bean_name = f_query_add_mod.document.formChartResultAdd.bean_name.value
	var formObj = f_query_add_mod.document.formChartResultAdd;
	var service_code=f_query_add_mod.document.formChartResultAdd.service_code.value;
	var fields ="";
	var names="";
	 fields = new Array ( formObj.chart_result
						,formObj.chart_result_desc
						,formObj.chart_horizontal_desc
						,formObj.chart_no_cols
						,formObj.chart_vetical_desc
						,formObj.service_code
						);

	 names = new Array ( getLabel("Common.type.label","Common")
				,getLabel("Common.description.label","Common")
				,getLabel("eOR.MatrixRowDescription.label","OR")
				,getLabel("eOR.Columns.label","OR")
				,getLabel("eOR.MatrixColumnDescription.label","OR")
				,getLabel("Common.service.label","Common"));


	if(formObj.enable.checked== true){
		formObj.enable.value = "E";
	}else{
		formObj.enable.value = "D";
	}


	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		//var flds=new Array(formObj.chart_result);
		var flds=new Array();
		var name=new Array();
		//var name=new Array("Type");
		flds[0] = eval("formObj.chart_result");
		//flds[1] = eval("formObj.chart_result_desc");
		//flds[2] = eval("formObj.chart_horizontal_desc");
		//flds[3] = eval("formObj.chart_vetical_desc");

		name[0] = "Type";
		//name[1] = "Description";
		//name[2] = "Matrix Row Description";
		//name[3] = "Matrix Column Description";
if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
	qry_string ="mode=2&function_id="+formObj.function_id.value+"&chart_result_type="+formObj.chart_result.value+"&chart_result_type_desc="+escape(formObj.chart_result_desc.value)+"&chart_horzi_desc="+escape(formObj.chart_horizontal_desc.value)+"&chart_no_columns	="+formObj.chart_no_cols.value+"&chart_vert_desc="+escape(formObj.chart_vetical_desc.value)+"&service_code="+service_code+"&eff_status="+formObj.enable.value;
		
		if(formObj.chart_result.value == "D" || formObj.chart_result.value == "P"){
			formObj.chart_result.focus();
			formObj.chart_result.select();
			message  = getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false;
		}


		//if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
		//	return false
		//}
		eval(formApply( f_query_add_mod.document.formChartResultAdd,OR_CONTROLLER )) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) {
				onSuccess();
			}
}
	}
		
}

/***************************************************************************************/

function onSuccess() {
	var mode = f_query_add_mod.document.formChartResultAdd.mode.value;
		if( mode == "1" ) {
			formReset();
			
		}
		if(mode == "2"){
			
			f_query_add_mod.location.href= "../../eOR/jsp/ChartResultTypeAddModify.jsp?"+qry_string ;
		}
}


/***************************************************************************************/

function formReset () {
	var formObj = f_query_add_mod.document.formChartResultAdd;


	formObj.chart_result.value = "";
	formObj.chart_result_desc.value = "";
	formObj.chart_horizontal_desc.value = "";
	formObj.chart_vetical_desc.value = "";

	f_query_add_mod.location.href = "../../eOR/jsp/ChartResultTypeAddModify.jsp?mode="+MODE_INSERT
}

/*************************************************************************************/

function assignResult(_result, _message, _flag){
	//alert(_result +"  -  "+_message"  -  "+_flag);
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

/**************************************************************************************/
function toCheck(){
	var formObj=document.formChartResultAdd;
	
	if(formObj.enable.checked== false){
		formObj.enable.value = "D";
		formObj.chart_result_desc.disabled=true;
		formObj.chart_horizontal_desc.disabled=true;
		formObj.chart_no_cols.disabled=true;
		formObj.chart_vetical_desc.disabled=true;
		formObj.chart_result.disabled=true;
	}else if (formObj.enable.checked== true){
		formObj.enable.value = "E";
		formObj.chart_result_desc.disabled=false;
		formObj.chart_horizontal_desc.disabled=false;
		formObj.chart_no_cols.disabled=false;
		formObj.chart_vetical_desc.disabled=false;
	}
}
/**************************service window*****************************/
function before_show_service_window(target,code)
{	
	if(formChartResultAdd!=null){
		
		if(formChartResultAdd.service_desc_temp.value != formChartResultAdd.service_desc.value)
		{
			if(formChartResultAdd.service_desc.value != "")
			 show_service_window(target,code);
		}
	}
}
async function show_service_window(target,code){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//argumentArray[0]   = formChartResultAdd.service_sql.value;
	argumentArray[0]   = document.getElementById('service_sql').value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup( getLabel("Common.service.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){
       code.value=arr[0];
	   target.value=arr[1];
    }

}
