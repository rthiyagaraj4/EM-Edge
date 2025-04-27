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

/*************Handle to the Frame 's and the form Object ****************/
var headerDoc			=null;
var detailDoc			=null;
var formObjHeader		=null;
var formObjDetail		=null;
var detailDocUpdate		=null;
var formObjDetailUpdate	=null;
var invalidCode			=null;
/*******************************************************************/
function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/WaitTimePendingOrdersAddModify.jsp?mode=1&function_id="+function_id;
}
/******************************************************************************/
function query() {
f_query_add_mod.location.href="../../eOR/jsp/WaitTimePendingOrdersQueryCriteria.jsp?function_id="+function_id;
}
/******************************************************************************/
function allowPositiveNumber() { //alert()
   var key = window.event.keyCode;// allows only numbers to be entered
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
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
/******************************************************************************/
function apply() {
	var message;
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObj = f_query_add_mod.document.form_wait_time_pending;
	var mode = formObj.mode;

	if(mode.value == "2") //in Update mode
	{
		applyModify();
		return ;
	}
				
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();
	
	arrFieldName[0]			=	"order_category";
	arrFieldName[1]			=	"order_type";
	arrFieldName[2]			=	"order_catalog_val";
	//arrFieldName[3]			=	"wait_time_green";
	//arrFieldName[4]			=	"wait_time_yellow";
	//arrFieldName[5]			=	"wait_time_red";
		
	arrLegends[0]			=	getLabel("Common.OrderCategory.label","Common");
	arrLegends[1]			=	getLabel("Common.OrderType.label","Common");
	arrLegends[2]			=	getLabel("Common.ordercatalog.label","Common");
	//arrLegends[3]			=	"Green Indicators";
	//arrLegends[4]			=	"Yellow Indicators";
	//arrLegends[5]			=	"Red Indicators";
	
	arrPKFieldNames[0]		=	"order_category";
	arrPKFieldNames[1]		=	"order_type";
	arrPKFieldNames[2]		=	"order_catalog_val";

	resetDuplicateClass( formObj, arrPKFieldNames );
	
	for(var i=0;i<10;i++){
		if(eval("formObj.order_category"+i).value !="" && eval("formObj.order_category"+i).value !=null){
		if(eval("formObj.active_stat"+i).checked){
			var fields = new Array ( eval("formObj.wait_time_green"+i),eval("formObj.wait_time_yellow"+i),eval("formObj.wait_time_red"+i));
			var names = new Array ( "Green Indicators","Yellow Indicators","Red Indicators");
			if(!checkFieldsofMst( fields, names, messageFrame)) {
			  return false;
			}

		}
	}

		if((eval("formObj.order_category"+i).value=="") && (eval("formObj.order_type"+i).value=="") && (eval("formObj.order_catalog_val"+i).value=="All"))
			eval("formObj.order_catalog_val"+i).value= "";

	}
//	var	result1	=	true;
	var	result1	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
	for(var i=0;i<10;i++){
		if((eval("formObj.order_category"+i).value=="") && (eval("formObj.order_type"+i).value=="") && (eval("formObj.order_catalog_val"+i).value==""))
			eval("formObj.order_catalog_val"+i).value= "All";
	}
	if(result1)
	{
		eval(formApply(formObj,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		
		if(resultGlobal) {
			onSuccess();
		}else if(invalidCode != "" && invalidCode != "null"){
			//alert("here===="+invalidCode);
			if(invalidCode.indexOf(",")== -1){
				var tmp_int = invalidCode.lastIndexOf(":");
				var tmp_code = invalidCode.substring(0, tmp_int);
				var tmp_code1 = invalidCode.substring(tmp_int,invalidCode.length);
				tmp_code1 = tmp_code1.replace("*ALL","All");
				//alert(tmp_code+"========="+tmp_code1);
				invalidCode = tmp_code+tmp_code1;
				//alert(invalidCode);
				//invalidCode = invalidCode.replace("*ALL","All");

			}else{
				var tmp_array = invalidCode.split(",");
				var invalid_code ="";
				for(var i=0;i<tmp_array.length;i++){
					var tmp_code_arr = 	tmp_array[i];
					var tmp_str_arr	 = tmp_code_arr.split(":")
					tmp_str_arr[2] = tmp_str_arr[2].replace("*ALL","All");
					invalid_code += tmp_str_arr[0]+":"+tmp_str_arr[1]+":"+tmp_str_arr[2]+",";
				}
				invalidCode = invalid_code.substring(0,(invalid_code.length -1));
			}
			//alert(invalidCode);
			showDuplicates(formObj,arrPKFieldNames,invalidCode,"0",messageFrame );
		}
	}


}
/*****************************************************************************/
function resetColorCode(obj)
{	
	var arrPKFieldNames	=	new Array();
	var formObj			=	f_query_add_mod.document.form_wait_time_pending;
	arrPKFieldNames[0]		=	"order_category";
	arrPKFieldNames[1]		=	"order_type";
	arrPKFieldNames[2]		=	"order_catalog_val";
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}


/******************************************************************************/
function onSuccess() {
	/*if(f_query_add_mod.document.forms[0].name == "form_wait_time_pending"){//insert mode
	
	}else{//Update Mode
		f_query_add_mod.document.location.href="../../eOR/jsp/ChartHorizontalAddModifyframe.jsp?"+detailDocUpdate.all.qry_str.value ;
	}*/
	f_query_add_mod.location.reload();
}
/******************************************************************************/
function reset() {
	var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if ( (url.indexOf("queryresult.jsp")!=-1) ||  (url.indexOf("blank")!=-1) )
		 return ;
	
	//f_query_add_mod.document.forms[0].reset(); 
	f_query_add_mod.location.reload(); 
	

	messageFrame.document.href ='../../eCommon/jsp/MstCodeError.jsp' ;
}

/******************************************************************************/
function assignResult(res,msg,mod,invCode){
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal		= mod;
	invalidCode		= invCode ;
}
/***************************************************************************/
function applyModify(){
	
	var flag = true;
	var formObj=f_query_add_mod.document.form_wait_time_pending ;
	/*if(formObj.active_stat.checked == true){
		
		var fields = new Array ( formObj.wait_time_green,formObj.wait_time_yellow,formObj.wait_time_red);
		var names = new Array ( "Wait Time for Green ","Wait Time for Yellow","Wait Time for Red");
		if(!checkFieldsofMst( fields, names, messageFrame)) {
			//flag = false;
			return false;
		}
	
	}
	if(flag){*/
	var fields = new Array ( formObj.wait_time_green,formObj.wait_time_yellow,formObj.wait_time_red);
	var names = new Array ( getLabel("eOR.WaitTimeforGreen.label","OR"),getLabel("eOR.WaitTimeforYellow.label","OR"),getLabel("eOR.WaitTimeforRed.label","OR"));
	if(formObj.active_stat.checked){
	if(checkFieldsofMst( fields, names, messageFrame)) {
		eval(formApply(formObj,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		if(resultGlobal) {
			onSuccess();
		}
	}

}else
{
	eval(formApply(formObj,OR_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
	if(resultGlobal) {
			onSuccess();
		}
}
}

function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
function populateOrderTypes(obj,index){
	//alert(index);

	var formObj = document.form_wait_time_pending
	var bean_id = document.form_wait_time_pending.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += "order_category"+index+"=\""+ obj.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "WaitTimePendingOrdersValidate.jsp?bean_id=" + bean_id +"&index="+index+"&default_val=''&validate=ord_cat", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
    
	if(eval("formObj.order_type"+index).value == "*ALL"){
		eval("formObj.order_catalog"+index).value = "*ALL";
		eval("formObj.order_catalog_val"+index).value = "All";
		eval("document.form_wait_time_pending.order_catalog_butn"+index).style.visibility ="hidden";
	
	}
	

}

function clearList( docObj,index ) {
	var tmp_var=".form_wait_time_pending.order_type"+index;
	//var len = eval(docObj+".form_wait_time_pending.order_type0.options.length") ;
	var len = eval(docObj+tmp_var+".options.length") ;
	for(var i=0;i<len;i++)
	{
		//eval(docObj+".form_wait_time_pending.order_type0.remove(\"atc_class_l2_code\")") ;
		eval(docObj+tmp_var+".remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	//eval(docObj+".form_wait_time_pending.order_type0.add(opt)") ;
	eval(docObj+tmp_var+".add(opt)") ;
}

function addOrderTypeList(code,value,index) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	eval("document.form_wait_time_pending.order_type"+index).add(element);
}
function showCatalogButtn(obj,index){
	
	
	if(obj.value == "*ALL"){
		eval("document.form_wait_time_pending.order_catalog_butn"+index).style.visibility ="hidden";
		eval("document.form_wait_time_pending.order_catalog"+index).value= "*ALL";
		eval("document.form_wait_time_pending.order_catalog_val"+index).value= "All";
		eval("document.form_wait_time_pending.order_catalog_val"+index).readOnly = true;
	}else{
		eval("document.form_wait_time_pending.order_catalog_butn"+index).style.visibility ="visible";
		//eval("document.form_wait_time_pending.order_catalog_val"+index).value= "All";
		eval("document.form_wait_time_pending.order_catalog_val"+index).value= "";
		//eval("document.form_wait_time_pending.order_catalog"+index).value= "*ALL";
		eval("document.form_wait_time_pending.order_catalog"+index).value= "";
		eval("document.form_wait_time_pending.order_catalog_val"+index).readOnly = false;
	}
	eval("document.form_wait_time_pending.order_catalog_val"+index).focus();
}
function chkValue(obj,index){
	
	
	if(obj.checked == true){
		
		eval("document.form_wait_time_pending.active_stat"+index).value= "Y";
		eval("document.form_wait_time_pending.wait_time_green"+index).readOnly= false;
		eval("document.form_wait_time_pending.wait_time_yellow"+index).readOnly= false;
		eval("document.form_wait_time_pending.wait_time_red"+index).readOnly= false;
		eval("document.form_wait_time_pending.wait_time_green"+index).disabled= false;
		eval("document.form_wait_time_pending.wait_time_yellow"+index).disabled= false;
		eval("document.form_wait_time_pending.wait_time_red"+index).disabled= false;		
		eval("document.form_wait_time_pending.wait_time_green"+index).focus();
		if(document.form_wait_time_pending.mode.value==2){
			document.form_wait_time_pending.img_green.style.visibility= "visible";
			document.form_wait_time_pending.img_yellow.style.visibility= "visible";
			document.form_wait_time_pending.img_red.style.visibility= "visible";
		}else
		if(index==0)
		{
			eval("document.form_wait_time_pending.img_red_mode1"+index).style.visibility= "visible";
		}

	}else{

		eval("document.form_wait_time_pending.active_stat"+index).value= "N";
		eval("document.form_wait_time_pending.wait_time_green"+index).readOnly= true;
		eval("document.form_wait_time_pending.wait_time_yellow"+index).readOnly= true;
		eval("document.form_wait_time_pending.wait_time_red"+index).readOnly= true;
		eval("document.form_wait_time_pending.wait_time_green"+index).value= "";
		eval("document.form_wait_time_pending.wait_time_yellow"+index).value= "";
		eval("document.form_wait_time_pending.wait_time_red"+index).value= "";
		if(document.form_wait_time_pending.mode.value==2){
			document.form_wait_time_pending.img_green.style.visibility= "hidden";
			document.form_wait_time_pending.img_yellow.style.visibility= "hidden";
			document.form_wait_time_pending.img_red.style.visibility= "hidden";
		}else

		if(index==0)
		   {
			eval("document.form_wait_time_pending.img_red_mode1"+index).style.visibility= "hidden";
		   }
	}
	//showMandFields(obj,index);
}

function chkWaitTime(obj,index){

	//alert(obj.name+"===");
	var tmp_name="";
	tmp_name = obj.name;
		
	var tmp_green_time = "",tmp_yellow_time = "",tmp_red_time = "";
	/*if ( (tmp_name.indexOf("wait_time_green")==-1 ))
		tmp_green_time = eval("wait_time_green"+index).value;
	if ( (tmp_name.indexOf("wait_time_yellow")==-1 ))
		tmp_yellow_time = eval("wait_time_yellow"+index).value;
	if ( (tmp_name.indexOf("wait_time_red")==-1 ))
		tmp_red_time = eval("wait_time_red"+index).value;*/
	if(index >= 0){
		tmp_green_time	 = eval("document.form_wait_time_pending.wait_time_green"+index).value;
		tmp_yellow_time	 = eval("document.form_wait_time_pending.wait_time_yellow"+index).value;
		tmp_red_time	 = eval("document.form_wait_time_pending.wait_time_red"+index).value;
	}else{
		tmp_green_time	 = eval("document.form_wait_time_pending.wait_time_green").value;
		tmp_yellow_time	 = eval("document.form_wait_time_pending.wait_time_yellow").value;
		tmp_red_time	 = eval("document.form_wait_time_pending.wait_time_red").value;
	}
	
	if((checkIntegerRange(tmp_green_time,tmp_yellow_time,tmp_red_time,index)) == false){
			
		//alert(getOrMessage('INVALID_INTEGER_RANGE'))  ;
		//obj.focus();
		//obj.select();
		return false;
	}
	
	return true;
}
function checkIntegerRange(green_time,yellow_time,red_time,index){
	
//	alert(trimString(val).length);
//alert("=green_time="+green_time+"=yellow_time="+yellow_time+"==red_time="+red_time+"=======");
	if(green_time != "" ){
		green_time	 = eval(green_time);
		green_time	 = parseInt(green_time);
	}		
		if(yellow_time != ""){
			yellow_time	 = eval(yellow_time);
			yellow_time	 = parseInt(yellow_time);
		}
		if(red_time != ""){
			red_time = parseInt(red_time);
			red_time = eval(red_time);
		}
		if(green_time != "" && yellow_time != ""){
			if((green_time >= yellow_time)){
				//alert("APP-OR0244 Always green time indicators should be lesser than the yellow time Indicators");
				alert(getMessage("GREEN_TIME_IND_LESS","OR"));
				eval("document.form_wait_time_pending.wait_time_green"+index).value="";
				eval("document.form_wait_time_pending.wait_time_green"+index).focus();
				//eval("document.form_wait_time_pending.wait_time_green"+index).select();
				return false
			}else if(!(green_time <= yellow_time)){
				alert(getMessage("YELLOW_TIME_IND_GREATER","OR"));
				//alert("APP-OR0245 Always Yellow Indicators Should be Greater Than the Green Indicators");
				eval("document.form_wait_time_pending.wait_time_yellow"+index).value="";
				eval("document.form_wait_time_pending.wait_time_yellow"+index).focus();
				//eval("document.form_wait_time_pending.wait_time_yellow"+index).select();
				return false
			}
		}
		if(red_time != "" && yellow_time != ""){
			if((yellow_time >= red_time)){
				alert(getMessage("YELLOW_TIME_IND_LESS","OR"));
				//alert("APP-OR0246 Always Yellow Indicators Should be Less than the Red Indicators");
				eval("document.form_wait_time_pending.wait_time_yellow"+index).value="";
				eval("document.form_wait_time_pending.wait_time_yellow"+index).focus();
				//eval("document.form_wait_time_pending.wait_time_yellow"+index).select();
				return false
			}else if(!(yellow_time <= red_time)){
				alert(getMessage("RED_TIME_IND_SHUD_GREATER","OR"));
				//alert("APP-OR0247 Always Red Indicators Should be Greater Than the Yellow and Green Indicators");
				eval("document.form_wait_time_pending.red_time"+index).value="";
				eval("document.form_wait_time_pending.red_time"+index).focus();
				//eval("document.form_wait_time_pending.red_time"+index).select();
				return false
			}
		}
		if(red_time != "" && green_time != "" && yellow_time == ""){
			if((green_time >= red_time)){
				alert(getMessage("YELLOW_TIME_IND_LESS","OR"));
				//alert("APP-OR0246 Always Yellow Indicators Should be Less than the Red Indicators");
				eval("document.form_wait_time_pending.wait_time_green"+index).value="";
				eval("document.form_wait_time_pending.wait_time_green"+index).focus();
				//eval("document.form_wait_time_pending.wait_time_green"+index).select();
				return false
			}else if(!(green_time <= red_time)){
				alert(getMessage("RED_TIME_IND_SHUD_GREATER","OR"));
				//alert("APP-OR0247 Always Red Indicators Should be Greater Than the Yellow and Green Indicators");
				eval("document.form_wait_time_pending.red_time"+index).value="";
				eval("document.form_wait_time_pending.red_time"+index).focus();
				//eval("document.form_wait_time_pending.red_time"+index).select();
				return false
			}
		}
		
	return true
}
//function searchForOrderCatalog(order_categroy,order_type,target,index,obj )
async function searchForOrderCatalog(order_categroy,order_type,target,index)
{
		
	if( order_type.value == "*ALL" || order_type.value == "" ){	
			target.value = getLabel("Common.all.label","Common") ;		
			eval("document.form_wait_time_pending.order_catalog"+index).value ="*ALL";
	}else{
	
	var frmObj=document.form_wait_time_pending;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var sql = document.form_wait_time_pending.sql_or_waiting_list_catalog.value;
	var sql1 = "";
	var sql2 = "";
 	if(sql.indexOf("?")!=-1) {
		sql1 =  sql.substring(0,sql.indexOf("?"));
		sql2 =  sql.substring(sql.indexOf("?")+1);
		sql  =  sql1+"'"+order_categroy.value+"'"+sql2;
	}
 	if(sql.indexOf("?")!=-1) {
		sql1 =  sql.substring(0,sql.indexOf("?"));
		sql2 =  sql.substring(sql.indexOf("?")+1);
		sql  =  sql1+"'"+order_type.value+"'"+sql2;
	}	
 	//var sql= "select order_catalog_code code, short_desc description from OR_ORDER_CATALOG where order_category = '"+order_categroy.value+"' and order_catalog_code like ? and short_desc like ?";
 	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = await CommonLookup(getLabel("Common.ordercatalog.label","Common"), argumentArray );

	var ret1=unescape(retVal);
//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" ){
		eval("frmObj.order_catalog"+index).value = arr[0];
		target.value = arr[1];
		target.readOnly = true;

	}else{
		/*if((order_type.value) == "*ALL"){
			target.value = "All";
			eval("frmObj.order_catalog"+index).value ="*ALL";
		}else{*/
			/*target.value = "All";
			eval("frmObj.order_catalog"+index).value ="*ALL";*/
			target.value = "";
			eval("frmObj.order_catalog"+index).value ="";
		//}
	}
	}
		
}
function showMandFields(obj,index){

/*	if(index ==""){
		if(obj.checked == true){
			document.getElementById("img_green").style.visibility	 = "visible";
			document.getElementById("img_yellow").style.visibility = "visible";
			document.getElementById("img_red").style.visibility	 = "visible";
		}else{
			document.getElementById("img_green").style.visibility	 = "hidden";
			document.getElementById("img_yellow").style.visibility = "hidden";
			document.getElementById("img_red").style.visibility	 = "hidden";
		}
	}else*/
	if(index >= 0){
		if(obj.checked == true){
			//eval("document.getElementById("img_red")"+index).style.visibility	 = "visible";
			document.getElementById('img_red'+0).style.visibility	 = "visible";
		}else{
			//eval("document.getElementById("img_red")"+index).style.visibility	 = "hidden";
			document.getElementById('img_red'+0).style.visibility	 = "hidden";
		}
	}


}
