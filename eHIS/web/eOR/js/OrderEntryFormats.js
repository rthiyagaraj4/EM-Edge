/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created
02/07/2014	IN049133		Chowminya									CRF:Disallow user to enter the future date in the LMP date field
20/08/2014  IN050609			Nijitha S									CRF-OR-Bru-HIMS-CRF-434/01-Operator value not defaulted to current date at Date depnedency
--------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;    
var dependlist="";
var dependfinal="";
var templistVal="";
var result = false;
var message = "" ;
var flag = "" ;
var	qry_string =  "";
var recExists = 0;

var occurance = "0" //used to check for the modal window..to check whether clicked first time or not
var depend_flag = true;


function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/OrderEntryFormatsAddModify.jsp?mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href='../../eOR/jsp/OrderEntryForamtsQueryCriteria.jsp';
}

async function listDetail() {	
	if(depend_flag == true){
	var dialogHeight ='80vh' ;
	var dialogWidth = '60vw' ;
	var dialogTop	= '10';
	var dialogLeft = '30' ;
	}else{
	var dialogHeight ='34' ;
	var dialogWidth = '60' ;
	var dialogTop	= '198';
	var dialogLeft = '157' ;
	}

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

	var arguments = "";
    var format_id = parent.f_query_add_mod.document.Order_Entry_Formats.format_id.value;

	var formObj = document.Order_Entry_Formats;

	var fields = new Array ( formObj.level
						,formObj.order_category
						,formObj.order_type
						,formObj.order_catalog
						);

	var names = new Array ( getLabel("Common.Level.label","COMMON")
				,getLabel("Common.OrderCategory.label","Common")
				,getLabel("Common.OrderType.label","Common")
				,getLabel("Common.ordercatalog.label","Common")
					);


	if(!checkFieldsofMst( fields, names,parent.messageFrame)) {
		return false;
	}else{
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}

	//if(parent.f_query_add_mod.document.Order_Entry_Formats.finalString){

		//finalString = parent.f_query_add_mod.document.Order_Entry_Formats.finalString.value;	
		//finalString = parent.f_query_add_mod.document.Order_Entry_Formats.finalString.value;	
		ord_cat = parent.f_query_add_mod.document.Order_Entry_Formats.order_category.value;
		level = parent.f_query_add_mod.document.Order_Entry_Formats.level.value;
		order_type = parent.f_query_add_mod.document.Order_Entry_Formats.order_type.value;
		ord_catalog = parent.f_query_add_mod.document.Order_Entry_Formats.order_catalog.value;
		

		checkDuplicateValues(level,ord_cat,order_type,ord_catalog)
					
		if(parseInt(recExists) == 1){			
			recExists = 0;
			parent.f_query_add_mod.document.Order_Entry_Formats.order_category.value = "";
			parent.f_query_add_mod.document.Order_Entry_Formats.order_catalog.value="";
			parent.f_query_add_mod.document.Order_Entry_Formats.level.value = "";
			clearList("document")
			var mmsg = parent.getMessage('RECORD_EXISTS1','OR')		
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ mmsg;
			return false

		}else{

			/*if(finalString != null ||finalString != ''  ){
				if(parent.f_query_add_mod.document.Order_Entry_Formats.mode.value==2)
				{
					finalString = parent.f_query_add_mod.document.Order_Entry_Formats.listValues.value;
				}*/

				//var retVals = window.showModalDialog("../../eOR/jsp/OrderEntryFormatsFrame.jsp?level="+level+"&ord_cat="+ord_cat+"&order_type="+order_type+"&ord_catalog="+ord_catalog+"&mode=updt&finalString="+finalString,arguments,features);
				var retVals =await top.window.showModalDialog("../../eOR/jsp/OrderEntryFormatsFrame.jsp?level="+level+"&ord_cat="+ord_cat+"&order_type="+order_type+"&format_id="+format_id+"&ord_catalog="+ord_catalog+"&mode=updt",arguments,features);
				/*if(retVals != ""){
					parent.f_query_add_mod.document.Order_Entry_Formats.listValues.value = retVals;
					parent.f_query_add_mod.document.Order_Entry_Formats.finalString.value = retVals;
				}else{					
					parent.f_query_add_mod.document.Order_Entry_Formats.listValues.value = finalString;
				}*/
			/*}else
			{
				finalString="";
			}*/
		}
	
}


function deleterecord(){
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var formObj1 = f_query_add_mod.document.Order_Entry_Formats ;	
	
	if(formObj1.mode.value == MODE_INSERT){
		if(formObj1.listValues.value == "" ||formObj1.listValues.value != "" ||formObj1.level.value == "" || formObj1.order_category.value == "" || formObj1.order_type.value == "" || formObj1.order_catalog.value== "" ){
			var msg = getMessage('NOT_VALID_DELETE','OR')
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			return false
			}
	}
	
	if(formObj1.mode.value != MODE_INSERT){
		if(formObj1.meaning_value.value=='S'){
			var msg1 =  getMessage('SYSTEM_DEFINED_CANNOT_DELETE','OR')
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg1;
			return false
		}
		var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
		if(confirm_val){
		formObj1.mode.value = MODE_DELETE;
			eval(formApply( f_query_add_mod.document.Order_Entry_Formats,OR_CONTROLLER) );
			f_query_add_mod.location.href = "../../eOR/jsp/OrderEntryFormatsAddModify.jsp?mode="+MODE_INSERT;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			
			if( result ) {
				onSuccess();
			}
		}else
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	}else{
		
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	}
}

function apply(){
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObj = f_query_add_mod.document.Order_Entry_Formats;

	var fields = new Array ( formObj.level
						,formObj.order_category
						,formObj.order_type
						,formObj.order_catalog
						);

	var names = new Array ( getLabel("Common.Level.label","COMMON")
				,getLabel("Common.OrderCategory.label","Common")
				,getLabel("Common.OrderType.label","Common")
				,getLabel("Common.ordercatalog.label","Common")
					);

	if(formObj.mode.value == "2"){
		qry_string =  "mode=2&format_id="+formObj.format_id.value
	}
                
			
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
/*		if(formObj.meaning_value.value=='S'){
			var msg1 =  getOrMessage('SYSTEM_USER_DEFINED')
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg1;
			return false
		}*/
		var currentSize=getMapDetail();
		//if(formObj.listValues.value == "" ){
		if(currentSize <=0 ||currentSize == ""){
			var msg = getMessage('FORMAT_ITEM_CANNOT_BE_EMPTY','OR')
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			return false
				
		/*	var listVal = formObj.listValues.value;
			listVal = 	listVal.substring(0,(listVal.length-1));
			formObj.listValues.value = listVal;*/
			
		}
	
		eval(formApply( formObj,OR_CONTROLLER));
        
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result ) {
			onSuccess();
		}
	}
}


function onSuccess() {
	var mode = f_query_add_mod.document.Order_Entry_Formats.mode.value;
	if( mode == "1" ) {
		formReset();
	}
	if(mode == "2"){
		f_query_add_mod.location.href='../../eOR/jsp/OrderEntryFormatsAddModify.jsp?'+qry_string ;
	}
}


function formReset () {
	var formObj = f_query_add_mod.document.Order_Entry_Formats;

	formObj.order_category.value = "";
	formObj.level.value = "";
	formObj.order_type.value = "";
	formObj.order_catalog.value = "";
	formObj.meaning.value = "";
	formObj.listValues.value = "";

	f_query_add_mod.location.href = "../../eOR/jsp/OrderEntryFormatsAddModify.jsp?mode="+MODE_INSERT
}

function reset(){
	var url = f_query_add_mod.location.href;

	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")!= -1) &&(url.indexOf("blank")!= -1) ){
		return true;
	}
	if(url.indexOf("query") != -1){
		f_query_add_mod.document.forms[0].reset();
		return true;
	}
	if(url.indexOf(".jsp") != -1){
		f_query_add_mod.document.forms[0].reset();
		
	}
	/*if(f_query_add_mod.document.forms[0] != null){

		if(f_query_add_mod.document.forms[0].name == "Order_Entry_Formats"){
			f_query_add_mod.document.Order_Entry_Formats.reset();
			
		}
	}*/

}

function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;

}


function checkLevel(){
	var formObj = document.Order_Entry_Formats
	formObj.order_category.value = "";
	formObj.listValues.value = "";
	formObj.order_catalog.value = "";
	formObj.order_catalog_disp.value = "";

	clearL2List("document");

	if(formObj.level.value == "H"){
		//formObj.order_type.options[0].selected = true
		//formObj.order_type.disabled = true

		formObj.order_catalog.value = "*ALL";
		formObj.order_catalog_disp.value = getLabel("Common.all.label","Common") ;
		formObj.order_catalog.disabled = true

	//	document.getElementById("dynamicButton").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"

	}else{
		formObj.order_catalog.value = "*ALL";
		formObj.order_catalog_disp.value = getLabel("Common.all.label","Common") ;
		if(formObj.order_type){
			if(formObj.order_type.value != "*ALL"){
			//	document.getElementById("dynamicButton").innerHTML = "<input type='button' name='catalog_button' id='catalog_button' class='button'  id='catalogButton'  value='?' onClick='show_catalog_window()'> <img src='../../eCommon/images/mandatory.gif'>"
			}
			if(formObj.order_type.value == "*ALL"){
				formObj.order_catalog.value = "*ALL";
				formObj.order_catalog.disabled = true
			//	document.getElementById("dynamicButton").innerHTML = " <img src='../../eCommon/images/mandatory.gif'>"
			}
		}
		formObj.order_type.disabled = false
		formObj.order_catalog.disabled = false
	}
		var mode="";
		if(formObj.mode)
			mode=formObj.mode.value;
		if(mode==1)
		{
			clearMapDetail();
		}

}


function populateOrderTyoes(ord_cat){

	var formObj = document.Order_Entry_Formats			
	if(formObj.order_category.value==""){		
			document.getElementById("dynamicButton").innerHTML = ""
		}

	parent.f_query_add_mod.document.Order_Entry_Formats.finalString.value ="";
  	if( ord_cat.value == "" ) {
		clearList("document")
	}
	//Added by Siva Kumar to enhance Enable/Disable functionality of Order Type - 15/9/2003
	else if (ord_cat.value != 'PH') {
		clearList1("document")
		formObj.order_type.disabled = false
	}
	else if (ord_cat.value == 'PH' && formObj.level.value == 'H') {
		clearL2List("document");
		formObj.order_type.disabled = true
	}
	else {
		clearL2List("document");
		formObj.order_type.disabled = false
	}
	//End of Addition - 15/9/2003
	var bean_id = document.Order_Entry_Formats.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_cat.name+"=\""+ ord_cat.value +"\" " ;
	xmlStr += "level=\""+formObj.level.value + "\" ";
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryFormatsValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=ord_cat", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );

	if(formObj.order_type.value == "*ALL" || formObj.order_category.value == "*ALL"){
		formObj.order_catalog.value = getLabel("Common.all.label","Common") ;
		formObj.order_catalog.disabled = true
	//	document.getElementById("dynamicButton").innerHTML = " <img src='../../eCommon/images/mandatory.gif'>"
	}
	else {
		formObj.order_type.focus();
	}
	formObj.order_catalog_disp.value	= getLabel("Common.all.label","Common") ;
	formObj.order_catalog.value			= "*ALL";
	var mode="";
	if(formObj.mode)
		mode=formObj.mode.value;
	if(mode==1)
	{
		clearMapDetail();
	}


}

function addOrderTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.Order_Entry_Formats.order_type.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".Order_Entry_Formats.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".Order_Entry_Formats.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval(docObj+".Order_Entry_Formats.order_type.add(opt)") ;
}
//Added by Siva Kumar for clearing the Order Type (along with ALL option) - 15/9/2003
function clearList1( docObj ) {
	var len = eval(docObj+".Order_Entry_Formats.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".Order_Entry_Formats.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".Order_Entry_Formats.order_type.add(opt)") ;
}
//End of Addition 15/9/2003


function clearL2List( docObj ) {
	var len = eval(docObj+".Order_Entry_Formats.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".Order_Entry_Formats.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval(docObj+".Order_Entry_Formats.order_type.add(opt)") ;

}
function checkValue(){
	var formObj = document.Order_Entry_Formats
		 	
}

function checkOrderType(){
	var formObj = document.Order_Entry_Formats
	if(formObj.order_type.value != null) {
		formObj.order_catalog.value="*ALL";
		formObj.order_catalog_disp.value=getLabel("Common.all.label","Common");
		formObj.order_catalog.disabled = true
	  
		
		if(formObj.order_type.value != "*ALL" && formObj.level.value != 'H'){
			document.getElementById("dynamicButton").innerHTML = "<input type='button' name='catalog_button' id='catalog_button' class='button'  id='catalogButton'  value='?' onClick='show_catalog_window()'><img src='../../eCommon/images/mandatory.gif' align='center'>"
		}else{
			document.getElementById("dynamicButton").innerHTML = "<img src='../../eCommon/images/mandatory.gif' align='center'>"
		}

		if(formObj.order_type.value == "*ALL"){
			formObj.order_catalog.value = "*ALL";
			formObj.order_catalog_disp.value = getLabel("Common.all.label","Common") ;
			formObj.order_catalog.disabled = true
		}
		if(formObj.level.value =='H'){
			formObj.order_catalog.value = "*ALL";
			formObj.order_catalog_disp.value = getLabel("Common.all.label","Common") ;
			formObj.order_catalog.disabled = true
		}

		var mode=formObj.mode.value;
		if(mode==1)
		{
			clearMapDetail();
		}

	}
}

async function show_catalog_window()	{
	var ord_type_val = "%";
	var ord_cat_val  = "%";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
		dataNameArray[0] = "order_category" ;
		dataNameArray[1] = "order_type_code" ;

	if(parent.frames[1].document.Order_Entry_Formats.order_category.value == "")
		ord_cat_val= "%"
	else
		ord_cat_val = parent.frames[1].document.Order_Entry_Formats.order_category.value ;

	if(parent.frames[1].document.Order_Entry_Formats.order_type.value == "")
		ord_type_val= "%"
	else
		ord_type_val = parent.frames[1].document.Order_Entry_Formats.order_type.value ;
	
	var dataValueArray = new Array() ;
		dataValueArray[0] = ord_cat_val ;
		dataValueArray[1] = ord_type_val ;

	var dataTypeArray  = new Array() ;
		dataTypeArray[0] = STRING ;
		dataTypeArray[1] = STRING ;

	var order_catalog_disp = "";
	var parNameArray  = new Array() ;
    var parValueArray  = new Array() ;    

// the fg code is written just to send the blank search criteria inorder to have the facility for the
//user to have a search of his requirement in the look up for the order catalog.
	if(parent.frames[1].document.Order_Entry_Formats.order_catalog.value == "*ALL")
		order_catalog_disp= ""
//	else
//		order_catalog_disp = parent.frames[1].document.Order_Entry_Formats.order_catalog_disp.value
	argumentArray[0]   = "";//parent.frames[1].document.Order_Entry_Formats.sql_or_order_entry_catalog.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "3,4";
	argumentArray[5]   = order_catalog_disp ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	
	argumentArray[12]  = "SQL_OR_ORDER_ENTRY_FORMAT_CATALOG" ;
    argumentArray[13]  = "eOR.Common.OrRepositoryExt" ;
    argumentArray[14]  = parNameArray 
    argumentArray[15]  = parValueArray 

	retVal = await CommonLookup( getLabel("Common.ordercatalog.label","Common"), argumentArray );
     var ret1=unescape(retVal);
     var arr=ret1.split(",");
	if(arr[1]==undefined) 
	{
		arr[0]="";	
		arr[1]="";	
	}
	if(retVal != null && retVal != "" )  {
		parent.frames[1].document.Order_Entry_Formats.order_catalog_disp.value = arr[1] ;
		parent.frames[1].document.Order_Entry_Formats.order_catalog.value = arr[0];
	}

	var mode="";
	if(parent.frames[1].document.Order_Entry_Formats)
		mode=parent.frames[1].document.Order_Entry_Formats.mode.value;
	if(mode==1)
	{
		clearMapDetail();
	}
}

function allowPositiveNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}

function checkPositiveNumber(obj) {
    var obj_value = obj.value;
    var obj_length = obj_value.length;
	if(obj.value == ""){
		return true;
	}
	if(obj != null ){
		if(obj_value > 0){
			return true;
		}else{
			alert(getMessage('ONLY_POSITIVE_NUM','OR'));
			obj.value = ""
			obj.focus();
			return false;
		}
	}else{
		return true;
	}
}

// This function is used to populate the values of selectged mnemonic
//onchange of the mnemonic option button of the OrderEntryFormatBottom.jsp file
// used to select the values of all
//			list box fo rdefault  - if the selected mnemonic is list type
//			max and min values		 - if the selected mnemonic is of Interger/Decoimal type
//and so on
//- INSERT
function populateValues(){
var modalFormObj = document.list_dtl;
var indexVal = modalFormObj.mnemonic.selectedIndex;
//to clear final value of dependency
modalFormObj.finalValue.value="";
if(depend_flag== true)
	parent.list_depend.location.href="../../eCommon/html/blank.html";

var ord_cat = modalFormObj.ord_cat.value
//var mnemonic1 = modalFormObj.mnemonic1.value
var mnemonic = modalFormObj.mnemonic.value;
var tmp_str=mnemonic.split("||");
modalFormObj.mnemonichdn.value=tmp_str[1];
    if (ord_cat == 'OT') {
        if (( (mnemonic == 'PREF_SURG_DATE'))) {
            modalFormObj.accept_option.value = 'R';
            modalFormObj.accept_option.disabled = true;
        } else {
            modalFormObj.accept_option.value = 'O';
            modalFormObj.accept_option.disabled = false;
        }
    }
	if(indexVal >0){
		modalFormObj.object_format_type.value=eval("document.list_dtl.hdn_fld_type"+indexVal).value;
		if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "N"){ //decimal
			var min_val = eval("document.list_dtl.hdn_minVal"+indexVal).value
			var max_val = eval("document.list_dtl.hdn_maxVal"+indexVal).value
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' value='' size=30 maxlength=30 style='visibility:visible' onKeyPress='return(OrAllowDecimalNumber())' onBlur = 'return OrIsValidDecimal(this)'> ("+min_val+"-"+max_val+") ("+ getLabel("eOR.Decimal.label","OR")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "I"){ //integer
			var min_val = eval("document.list_dtl.hdn_minVal"+indexVal).value
			var max_val = eval("document.list_dtl.hdn_maxVal"+indexVal).value
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' value='' size=30 maxlength=30  style='visibility:visible' onKeyPress='return(OrAllowNumber())' onBlur = 'return OrCheckPositiveNumber1(this)'> ("+min_val+"-"+max_val+")("+getLabel("eOR.Integer.label","OR")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "C"){ //checkbox
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML ="<input type=checkbox name='dflt_val' id='dflt_val' style='visibility:visible' value=''>"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "M"){ // descrete measure
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=20 maxlength=25   style='visibility:visible' value='' readonly>("+getLabel("Common.DiscreteMeasure.label","Common")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "D"){//date
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=10 maxlength=10   style='visibility:visible' value='' onBlur='checkDate(this)'>("+getLabel("Common.date.label","Common")+")(dd/mm/yyyy)"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "E"){ //date time
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=16 maxlength=16   style='visibility:visible' value='' onBlur='validateDateTime(this)'>("+getLabel("Common.Date/Time.label","COMMON")+")(dd/mm/yyyy hh:mi)"
		}else if((eval("document.list_dtl.hdn_fld_type"+indexVal).value == "A") || eval("document.list_dtl.hdn_fld_type"+indexVal).value == "V")
		{ //alphanumeric
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=30 maxlength=30   style='visibility:visible' value='' onKeyPress = 'return(CheckForSpecCharsWithoutSpace(event))' onBlur='return(CheckForSpecCharsWithoutSpaceBlur(this))'>("+getLabel("eOR.Alphanumeric.label","OR")+")"
			 if (( (mnemonic == 'PATIENT_DIAGNOSIS'))) 
			{
				document.getElementById("dflt_val").value="";
				document.getElementById("dflt_val").disabled=true;
			}
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "T"){ // time
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=5 maxlength=5   style='visibility:visible' value='' onBlur='checkTime(this)'>("+getLabel("Common.time.label","Common")+")(hh:mi)"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "L" || eval("document.list_dtl.hdn_fld_type"+indexVal).value == "R"){

			var hdnfld=eval("document.list_dtl.hdn_fld_type"+indexVal).value;
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML ="<select name=\"dflt_val\" id=\"dflt_val\"  style='visibility:visible'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</select>";
			populateListValues(ord_cat,mnemonic,hdnfld,"bottomOnchg");
			//document.getElementById("deflt_value2").innerHTML ="<input type=text name='dflt_val' id='dflt_val'  style='visibility:visible' value=''><input type='button' value='?' class='button' name='searchpctr' id='searchpctr' onClick='getdefaultValue(this)'>";
			//populateListValues(ord_cat,mnemonic)
			var presentation_type=eval("document.list_dtl.presentation_type"+indexVal+".value");
			if (presentation_type == null) presentation_type="";		
			if(presentation_type=='M' && document.getElementById("accept_option").value!="D"){
				document.getElementById("dflt_val").selectedIndex=0;
				document.getElementById("dflt_val").disabled=true;
			}
		}
		if(((mnemonic=="BLOOD_TRANS_EXP_DATE")||(mnemonic=="TRANSPLANT_DATE"))||(mnemonic=="NN_MOTHER_PAT_ID")||(mnemonic=="NN_MOTHER_PAT_NAME"))
		{
			document.getElementById("dflt_val").value="";
			document.getElementById("dflt_val").disabled=true;
		}
		if(depend_flag == true)
		{

			if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "L" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "R" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "C" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "N" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "E" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "I" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "D" )
			{
				/*Modified by Uma on 3/24/2010 for IN020073*/
				if(eval("document.list_dtl.single_multiple"+indexVal).value == "M" && eval("document.list_dtl.presentation_type"+indexVal).value == "M")
				{
					document.getElementById("depend1").innerHTML = "";
					document.getElementById("depend2").innerHTML = "";
				}
				else
				{
					if((mnemonic!="SPECIMEN_TYPE"))
					{
						if(eval("document.list_dtl.hdn_fld_type"+indexVal).value != "L" )
						{
							document.getElementById("depend1").innerHTML = getLabel('Common.Dependency.label','COMMON');
							document.getElementById("depend2").innerHTML = "<input type=checkbox name='chk_depnd' id='chk_depnd' style='visibility:visible' value='' OnClick='chkDependency(\"chkbox\")'><input type=button class='button' name='depend' id='depend' style='visibility:visible' value='"+getLabel('Common.Dependency.label','COMMON')+"'  OnClick='chkDependency(\"butn\")' >";
						}
						else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "L")
						{ //&& eval("document.list_dtl.single_multiple"+indexVal).value != "M" && eval("document.list_dtl.presentation_type"+indexVal).value != "M"){
							document.getElementById("depend1").innerHTML = getLabel('Common.Dependency.label','COMMON');
							document.getElementById("depend2").innerHTML = "<input type=checkbox name='chk_depnd' id='chk_depnd' style='visibility:visible' value='' OnClick='chkDependency(\"chkbox\")'><input type=button class='button' name='depend' id='depend' style='visibility:visible' value='"+getLabel('Common.Dependency.label','COMMON')+"'  OnClick='chkDependency(\"butn\")' >";
						}
						else
						{
							document.getElementById("depend1").innerHTML = ""
							document.getElementById("depend2").innerHTML = ""
						}
					}
					else
					{
						document.getElementById("depend1").innerHTML = ""
						document.getElementById("depend2").innerHTML = ""
					}
			    }
			}
			else
			{
				document.getElementById("depend1").innerHTML = ""
				document.getElementById("depend2").innerHTML = ""		
			}
		}
	}else if(indexVal == 0){
			document.getElementById("deflt_value1").innerHTML = ""
			document.getElementById("deflt_value2").innerHTML = ""
			document.getElementById("depend1").innerHTML = ""
			document.getElementById("depend2").innerHTML = ""
	}
	
	var install_yn = document.list_dtl.install_yn.value;
	
	if(install_yn == "Y" ){
		if (ord_cat.value == 'RD' && mnemonic == 'EXAM_VIEW_REQUESTED') {
			
			var bean_id = "Or_OrderEntryFormats";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;

			xmlStr ="<root><SEARCH " ;
			xmlStr += "order_category=\""+ ord_cat +"\" " ;
			xmlStr += "mnemonic=\""+ mnemonic +"\" " ;
			xmlStr +=" /></root>" ;

			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

			xmlHttp.open( "POST", "OrderEntryFormatsValidate.jsp?bean_id=" + bean_id + "&default_val="+default_val+"&validate=ord_cat", false ) ;

			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText ) ;
		}
	}
}

// This function is used to populate the values of Clicked mnemonic
// of the records in the OrderEntryFormatTop.jsp file
// used to select the values of all
//			list box fo rdefault  - if the selected mnemonic is list type
//			max and min values		 - if the selected mnemonic is of Interger/Decoimal type
//and so on
//- UPDATE
//IN049133 included flag
function populateValues1(min_val, max_val, objType, default_val, dependency_val,flag){	
	var modalFormObj = parent.list_bottom.document.list_dtl;

	var objectType = objType
	var ord_cat = modalFormObj.ord_cat.value
	var mnemonic = modalFormObj.mnemonic.value
	modalFormObj.object_format_type.value=objType;

	var range = "";

	if(min_val == null || min_val == " ") min_val = "";
	if(max_val == null || max_val == " ") max_val = "";

	if(min_val != ""  && max_val != "" ){
		range = "("+ min_val  +"-"+max_val +")"
	}

	if(objectType == "N"){ //decimal
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
		parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' value='"+default_val+"' size=30 maxlength=30 style='visibility:visible' onKeyPress='return(OrAllowDecimalNumber())'  onBlur = 'return OrIsValidDecimal(this)'>"+range+" ("+ getLabel("eOR.Decimal.label","OR")+")"
	}else if(objectType == "I"){ //integer
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
		parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' value='"+default_val+"' size=30 maxlength=30  style='visibility:visible' onKeyPress='return(OrAllowNumber())' onBlur = 'return OrCheckPositiveNumber1(this)'> "+range+" ("+getLabel("eOR.Integer.label","OR")+")"
	}else if(objectType == "C"){ //checkbox
		if(default_val == "Y")
			default_val = " checked ";
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
		parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<input type=checkbox name='dflt_val' id='dflt_val' style='visibility:visible' value='' "+default_val+">("+getLabel("Common.CheckBox.label","Common")+")"
	}else if(objectType == "M"){ // descrete measure
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
		parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=20 maxlength=25   style='visibility:visible' value='' readonly>("+getLabel("Common.DiscreteMeasure.label","Common")+")"
	}else if( objectType == "D"){//date
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
		parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=10 maxlength=10   style='visibility:visible' value='"+default_val+"' onBlur='checkDate(this)'>("+getLabel("Common.date.label","Common")+")(dd/mm/yyyy)"
	}else if( objectType == "E"){ //date time
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
		parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=16 maxlength=16   style='visibility:visible' value='"+default_val+"' onKeyPress='return OrAllowDateHourFormat();' onBlur='validateDateTime(this)'>("+getLabel("Common.Date/Time.label","COMMON")+")(dd/mm/yyyy hh:mi)"
	}else if( objectType == "A"){ //alphanumeric	
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
		parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=30 maxlength=30   style='visibility:visible' value='"+default_val+"' onKeyPress = 'return(CheckForSpecCharsWithoutSpace(event))'  onBlur='return(CheckForSpecCharsWithoutSpaceBlur(this))'>("+getLabel("eOR.Alphanumeric.label","OR")+")"		
	}else if( objectType == "V"){ //alphanumeric
	
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
		parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=30 maxlength=30   style='visibility:visible' value='"+default_val+"' onKeyPress = 'return(CheckForSpecCharsWithoutSpace(event))'  onBlur='return(CheckForSpecCharsWithoutSpaceBlur(this))'>("+getLabel("eOR.Alphanumeric.label","OR")+")"
	}else if( objectType == "T"){ // time
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
		parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=5 maxlength=5   style='visibility:visible' value='"+default_val+"' onBlur='checkTime(this)'>("+getLabel("Common.time.label","Common")+")(hh:mi)"
	}else if( objectType == "L" ||  objectType == "R"){	
		
		parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<select name=\"dflt_val\"  id=\"dflt_val\" style='visibility:visible'><option value=''>-----------"+getLabel("Common.defaultSelect.label","Common")+"-----</select>"
		//parent.list_bottom.document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val'  style='visibility:visible' value=''>";
		populateListValues(ord_cat,mnemonic,objectType,"topclick");
		//var optionlength=parseInt((parent.list_bottom.document.getElementById("dflt_val").lengt),10);
		//for(var i=0;i<optionlength;i++)
		//{
			//if()
		//populateListValues(ord_cat,mnemonic,default_val);
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
		var position=parent.list_bottom.document.getElementById("mnemonic").selectedIndex;
		var presentation_type=eval("parent.list_bottom.document.getElementById('presentation_type')"+position+".value");
		/*Added by Uma on 3/24/2010 for IN020073*/
		var single_multiple=eval("parent.list_bottom.document.getElementById('single_multiple')"+position+".value");
		if (presentation_type == null) presentation_type="";
		if (single_multiple == null) single_multiple="";
		/*Ends Here for IN020073*/
		if(presentation_type=='M' && parent.list_bottom.list_dtl.accept_option.value!="D"){
			parent.list_bottom.document.getElementById("dflt_val").selectedIndex=0;
			parent.list_bottom.document.getElementById("dflt_val").disabled=true;
		}
	}
	if(depend_flag == true)
	{
		var depend_chk ="";
		if(objectType == "L" || objectType == "R" ||  objectType == "I" || objectType == "C" ||objectType == "N" ||objectType == "E" ||objectType == "D")
		{
			/*Modifed by Uma on 3/24/2010 for IN020073*/
			if((single_multiple=="M")&&(presentation_type=="M"))
			{
				parent.list_bottom.document.getElementById("depend1").innerHTML = "";
				parent.list_bottom.document.getElementById("depend2").innerHTML = "";		
			}
			else
			{
				if(dependency_val !=" " || dependency_val == "Y")
					depend_chk = "checked";
				if(dependency_val == "N" || dependency_val=="")
					depend_chk="";
				if(mnemonic!="SPECIMEN_TYPE")
				{
					parent.list_bottom.document.getElementById("depend1").innerHTML = getLabel('Common.Dependency.label','COMMON');
				//IN049133 added condition
					if(flag == "Depend")
						parent.list_bottom.document.getElementById("depend2").innerHTML = "<input type=checkbox name='chk_depnd' id='chk_depnd' style='visibility:visible' value='' OnClick='chkDependency1(\"chkbox\")' "+depend_chk+"><input type=button class='button' name='depend' id='depend' style='visibility:visible' value='"+getLabel('Common.Dependency.label','COMMON')+"'  OnClick='chkDependency1(\"butn\")' >" ;
					else
						parent.list_bottom.document.getElementById("depend2").innerHTML = "<input type=checkbox name='chk_depnd' id='chk_depnd' style='visibility:visible' value='' OnClick='chkDependency(\"chkbox\")' "+depend_chk+"><input type=button class='button' name='depend' id='depend' style='visibility:visible' value='"+getLabel('Common.Dependency.label','COMMON')+"'  OnClick='chkDependency(\"butn\")' >" ;
							
				}
				else
				{
					parent.list_bottom.document.getElementById("depend1").innerHTML = "";
					parent.list_bottom.document.getElementById("depend2").innerHTML = "";		
				}
			}
		
		}
		else
		{
			parent.list_bottom.document.getElementById("depend1").innerHTML = ""
			parent.list_bottom.document.getElementById("depend2").innerHTML = ""		
		}
	}
}
function onChangeAcceptOption(obj){
	var position=parent.list_bottom.document.getElementById("mnemonic").selectedIndex;
	var presentation_type=eval("parent.list_bottom.document.getElementById('presentation_type'+position)"+".value");
	if (presentation_type == null) presentation_type="";
	if(presentation_type=='M' && obj.value!="D" && parent.list_bottom.document.getElementById("dflt_val") !=null){
	parent.list_bottom.document.getElementById("dflt_val").selectedIndex=0;	
	parent.list_bottom.document.getElementById("dflt_val").disabled=true;
	}//else 
		//parent.list_bottom.document.getElementById("dflt_val").disabled=false;
	
}

function populateListValues(ord_cat,mnemonic,default_val,from){
	var SequenceNumber = "";
	var format_id = "";
	if(from=="seqTop")
	{
		mnemonic = parent.list_bottom.document.list_dtl.mnemonic.value
		default_val= parent.list_bottom.document.list_dtl.object_format_type.value;
	}
	SequenceNumber=parent.list_bottom.document.list_dtl.seq_no.value;
	format_id = parent.list_bottom.document.list_dtl.format_id.value;
	if(default_val=="L")
		parent.list_bottom.document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");

	var bean_id = "Or_OrderEntryFormats";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += "order_category=\""+ ord_cat +"\" " ;
	xmlStr += "mnemonic=\""+ mnemonic +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST","OrderEntryFormatsValidate.jsp?bean_id="+bean_id+"&SequenceNumber="+SequenceNumber+"&format_id="+format_id+"&default_val="+default_val+"&validate=ord_cat", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

function checkDuplicateValues(level,ord_cat,order_type,ord_catalog){
	var bean_id = "Or_OrderEntryFormats";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var dupchk = "1";

	xmlStr ="<root><SEARCH " ;
	xmlStr += "order_category=\""+ ord_cat +"\" " ;
	xmlStr += "level=\""+ level +"\" " ;
	xmlStr += "order_type=\""+ order_type +"\" " ;
	xmlStr += "ord_catalog=\""+ ord_catalog +"\" " ;
	xmlStr += "dupchk=\""+ dupchk+"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryFormatsValidate.jsp?bean_id=" + bean_id +"&validate=ord_cat&order_category="+ord_cat+"&level="+level+"&order_type="+order_type+"&ord_catalog="+ord_catalog, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
}

function recordCnt(totCount){
	if(parseInt(totCount) !=0){
		recExists = 1;
	}
}
/*
function addListValues(code,value) {
		
	var element = parent.list_bottom.document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;


	parent.list_bottom.document.getElementById("dflt_val").add(element);

	/*if(default_val == value){
		element.selected = true
	}
}*/

function addListValues(code,value) 
{	
	var element = parent.list_bottom.document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	parent.list_bottom.document.getElementById("dflt_val").add(element);
}

function addList_Values(combovalue)
{	
	if((combovalue.indexOf("<option>")>0) &&(combovalue.indexOf("</option>")>0))
	{
		var combovaluetemp=combovalue.split("</option>");
		for(var j=0;j<combovaluetemp.length;j++)
		{
			var temp =trimString(combovaluetemp[j]);
			temp=temp.replace("<option>","");
			if(temp!="")
				addListValues(temp,temp);		
		}
	}
	//parent.list_bottom.document.getElementById("dflt_val").innerHTML="";
	//parent.list_bottom.document.getElementById("dflt_val").innerHTML=combovalue;	
}

function validateDateTime(objDateTime) {
	if(objDateTime.value ==  "")
		return ;

	if(!(doDateTimeChk(objDateTime))) {
		alert(getMessage("INVALID_DATE_TIME","SM"));
		objDateTime.select();
		objDateTime.focus();
		return false;
	}else{
		var date = objDateTime.value;
		var datearr=new Array()
		var date1arr =new Array() 
		date1arr = date.split(" ")
        datearr=date1arr[0].split("/")
		if(parseInt(datearr[0]) == 0 || parseInt(datearr[1]) == 0 || parseInt(datearr[2]) == 0 ){
			alert(getMessage("INVALID_DATE_TIME","SM"));
			objDateTime.select();
			objDateTime.focus();
			return false;
		}
	}

}

function checkDate(obj){

	if(obj.value ==  "")
		return ;

	if(!(checkDt(obj.value))){
		alert(getMessage("INVALID_DATE_FMT","SM"));
		obj.select();
		obj.focus();
		return false;
	}else{
		var date1 = obj.value;
		var datearr=new Array()
        datearr=date1.split("/")
		if(parseInt(datearr[0],10) == 0 || parseInt(datearr[1],10) == 0 || parseInt(datearr[2],10) == 0 ){
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
}

function checkTime(obj){

	if(obj.value ==  "")
		return ;

	if(!(chkTime(obj.value))){
		alert(getMessage("INVALID_TIME_FMT","SM"));
		obj.select();
		obj.focus();
		return false;
	}/*else{
		var time1 = obj.value;
		var timearr=new Array()
        timearr=time1.split(":")
		if(parseInt(timearr[0]) == 0 && parseInt(timearr[1]) == 0 ){
			alert(getMessage("INVALID_TIME_FMT"));
			obj.select();
			obj.focus();
			return false;
		}
	}*/
}
function checkSpecialChar(event) {
	if(event.keyCode == '')
		return (event.keyCode = 32);
	if (event.keyCode == 126 || event.keyCode == 96 || event.keyCode == 60 || event.keyCode == 34 || event.keyCode == 39 || event.keyCode == 164 || event.keyCode == 181 || event.keyCode == 185 || event.keyCode == 179 || event.keyCode == 168) // || event.keyCode == 35 || event.keyCode == 37 || event.keyCode == 38 || event.keyCode == 92 || event.keyCode == 34 || event.keyCode == 39 || event.keyCode == 43  // || event.keyCode == 35 || event.keyCode == 37 || event.keyCode == 92 || event.keyCode == 43
		return (event.keyCode = '');
}

function checkSpecialChar1(event) {
	if(event.keyCode == '')
		return (event.keyCode = 32);
	if (event.keyCode == 126 || event.keyCode == 96 || event.keyCode == 60 || event.keyCode == 34 ||event.keyCode == 35 ||event.keyCode == 36 || event.keyCode == 37  || event.keyCode == 38 ||event.keyCode == 39 || event.keyCode == 164 || event.keyCode == 181 || event.keyCode == 185 || event.keyCode == 179 || event.keyCode == 168 || event.keyCode == 166 || event.keyCode == 44 || event.keyCode == 42 || event.keyCode == 94 || event.keyCode == 33 || event.keyCode == 64 || event.keyCode == 124)//IN050609 // || event.keyCode == 35 || event.keyCode == 37 || event.keyCode == 38 || event.keyCode == 92 || event.keyCode == 34 || event.keyCode == 39 || event.keyCode == 43  // || event.keyCode == 35 || event.keyCode == 37 || event.keyCode == 92 || event.keyCode == 43
		return (event.keyCode = '');
}
function checkSpecialCharBlur(obj) {
	var str = obj.value;
	var tempStr = "";
	for(var u=0;u<str.length;u++) {
		if ((str.charCodeAt(u)==126) || (str.charCodeAt(u)==96) || (str.charCodeAt(u)==60) || (str.charCodeAt(u)==34) || (str.charCodeAt(u)==39) || (str.charCodeAt(u)==164) || (str.charCodeAt(u)==181) || (str.charCodeAt(u)==185) || (str.charCodeAt(u)==179) || (str.charCodeAt(u)==168)) {  //||((str.charCodeAt(u)==35) || (str.charCodeAt(u)==37))||((str.charCodeAt(u)==38)  || (str.charCodeAt(u)==92)) ||((str.charCodeAt(u)==34)  || (str.charCodeAt(u)==39)) || (str.charCodeAt(u)==43)
			str = str.replace(str.charAt(u),'~');
		}
	}
	str = str.replace('~','');
	obj.value = str;
}
function setFinalString(finalString){
	var bean_id = "Or_OrderEntryFormats";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var finalString1 = finalString;
	for (var i = 0; i < finalString.length;i++) {
		if (finalString.indexOf("&") != -1) {
			finalString = finalString.replace("&","Â¤");
		}
	}
	xmlStr ="<root><SEARCH " ;
	//xmlStr += "finalString=\""+ finalString +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryFormatsValidate1.jsp?bean_id=" + bean_id+"&finalString="+(finalString1), false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
	return responseText;
}

function setFinal_String(seq,finalString,from){	
	var bean_id = "Or_OrderEntryFormats";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var finalString1 = finalString;
	for (var i = 0; i < finalString.length;i++) {
		if (finalString.indexOf("&") != -1) {
			finalString = finalString.replace("&","Â¤");
		}
	}
	xmlStr ="<root><SEARCH " ;
	xmlStr += "from=\""+ from +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryFormatsValidate1.jsp?bean_id=" + bean_id+"&finalString="+(finalString1)+"&seq="+(seq), false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
	return responseText;
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
function chkDependency(val)
{		
	if(val == "butn")
		parent.list_bottom.list_dtl.chk_depnd.checked	 = true;
	
	if(parent.list_bottom.list_dtl.chk_depnd.checked){
		parent.list_top.list_top.disabled				 = true;
		parent.list_bottom.list_dtl.chk_depnd.disabled	 = true;
		parent.list_bottom.list_dtl.depend.disabled		 = true;
		parent.list_bottom.list_dtl.clear.disabled		 = true;
		parent.list_bottom.list_dtl.mnemonic.disabled	 = true;
		parent.list_bottom.list_dtl.select.disabled		 = true;
		parent.list_bottom.list_dtl.ok.disabled			 = true;
		parent.list_bottom.list_dtl.close.disabled		 = true;
		parent.list_bottom.list_dtl.seq_no.disabled		 = true;
		
		var modalFormObj = parent.list_bottom.document.list_dtl
		var indexVal = modalFormObj.mnemonic.selectedIndex
		var dflt_val =	eval("document.list_dtl.hdn_fld_type"+indexVal).value
		var min_val = eval("document.list_dtl.hdn_minVal"+indexVal).value
		var max_val = eval("document.list_dtl.hdn_maxVal"+indexVal).value
		//var ord_cat = modalFormObj.ord_cat.value
		var mnemonic = modalFormObj.mnemonic.value
		var seq_no = modalFormObj.seq_no.value;
		var format_id = modalFormObj.format_id.value;
		var depd_val;
		finalString = parent.list_bottom.document.list_dtl.finalString.value;

		ord_cat = parent.list_bottom.document.list_dtl.ord_cat.value;
		level = parent.list_bottom.document.list_dtl.level1.value;
		order_type = parent.list_bottom.document.list_dtl.order_type.value;
		ord_catalog = parent.list_bottom.document.list_dtl.order_catalog.value;
		if(parent.list_bottom.document.list_dtl.finalValue)
		{
			finalValue=parent.list_bottom.document.list_dtl.finalValue.value ;
			dontChk=parent.list_bottom.document.list_dtl.dontChk.value ;
			var finalString1	= "dflt_val="+dflt_val+"&min_val="+min_val+"&max_val="+max_val+"&ord_cat="+ord_cat+"&mnemonic="+mnemonic+"&seq_no="+seq_no+"&dontChk="+dontChk+"&format_id="+format_id;
			finalString1 += "&level=" + level;
			finalString1 += "&order_type=" + order_type;
			finalString1 += "&ord_catalog=" + ord_catalog;
			finalString1 += "&finalString=" + finalString;
			finalString1 += "&finalValue=" + finalValue;
			parent.list_depend.location.href="../../eOR/jsp/OrderEntryFormatDependency.jsp?"+finalString1;
		
		}
	}
}

async function listDetails1(index) {
       
	finalString = eval("document.decision_support.depend_finalString"+index).value;
	var value_seq_num=parseInt(index)+1;
	var parentindex=parent.list_bottom.document.list_dtl.dontChk.value ;	
	ord_cat		= document.decision_support.ord_cat.value;
	level		= document.decision_support.level.value;
	order_type	= document.decision_support.order_type.value;
	ord_catalog	= document.decision_support.order_catalog.value;
	mnemonic	= document.decision_support.mnemonic.value;
	seq_no		= document.decision_support.seq_no.value;
	format_id		= parent.list_bottom.document.list_dtl.format_id.value;
	if(mnemonic.indexOf("||")!=-1){

	var mnemonic1=mnemonic.split("||")
		mnemonic = mnemonic1[1];
	}
	
	var dialogHeight	 = '95vh' ;
	var dialogWidth		 = '85vw' ;
	var dialogTop		 = '10';
	var dialogLeft		 = '157' ;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

	var arguments = "";

	if(finalString != null ||finalString != ''  ){		
		var retVals=await top.window.showModalDialog("../../eOR/jsp/OrderEntryFormatsDependencyFrame.jsp?level="+level+"&ord_cat="+ord_cat+"&order_type="+order_type+"&ord_catalog="+ord_catalog+"&mnemonic="+mnemonic+"&seq_no="+seq_no+"&format_id="+format_id+"&value_seq_num="+value_seq_num+"&mode=updt&finalString="+finalString+"&index="+index+"&parentindex"+parentindex,arguments,features);
		if(retVals != ""){
			eval("document.decision_support.depend_finalString"+index).value = retVals ;
		}else{
			eval("document.decision_support.depend_finalString"+index).value = retVals ;
		}
	}

}

function populateValues2(){
	var modalFormObj = document.list_dtl;
	var indexVal = modalFormObj.mnemonic.selectedIndex;
	//to clear final value of dependency
	modalFormObj.finalValue.value="";

	var ord_cat = modalFormObj.ord_cat.value;
	var mnemonic = modalFormObj.mnemonic.value;
	
	if (mnemonic.indexOf("||")!=-1)
	{
		var mnemonic1=mnemonic.split("||");
		mnemonic = mnemonic1[1];
	}
	
    if (ord_cat == 'OT') {
        if (((mnemonic == 'PERFORM_TEAM_SURGEON') || (mnemonic == 'PREF_SURG_DATE'))) {
            modalFormObj.accept_option.value = 'R';
            modalFormObj.accept_option.disabled = true;
        } else {
            modalFormObj.accept_option.value = 'O';
            modalFormObj.accept_option.disabled = false;
        }
    }
	var presentation_type=eval("document.list_dtl.presentation_type"+indexVal+".value");
	if (presentation_type == null) presentation_type="";		
	
	var depend_mnemonic = modalFormObj.depend_mnemonic.value
	if(mnemonic == depend_mnemonic){
		alert(getMessage("OPTION_SELECTED","OR"))
			modalFormObj.mnemonic.value="";
		modalFormObj.mnemonic.focus();

	}else if(presentation_type=='M'){
		modalFormObj.mnemonic.selectedIndex=0;
		alert(getMessage('MULTI_PRESENTATION_CANNOT_BE_SELECTED','OR'))
		return false

	}else 
	if(indexVal >0){
	  modalFormObj.object_format_type.value=eval("document.list_dtl.hdn_fld_type"+indexVal).value;
		if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "N"){ //decimal
			var min_val = eval("document.list_dtl.hdn_minVal"+indexVal).value
			var max_val = eval("document.list_dtl.hdn_maxVal"+indexVal).value
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' value='' size=30 maxlength=30 style='visibility:visible' onKeyPress='return(OrAllowDecimalNumber())' onBlur = 'return OrIsValidDecimal(this)'> ("+min_val+"-"+max_val+") ("+ getLabel("eOR.Decimal.label","OR")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "I"){ // integer
			var min_val = eval("document.list_dtl.hdn_minVal"+indexVal).value
			var max_val = eval("document.list_dtl.hdn_maxVal"+indexVal).value
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' value='' size=30 maxlength=30  style='visibility:visible' onKeyPress='return(OrAllowNumber())' onBlur = 'return OrCheckPositiveNumber1(this)'> ("+min_val+"-"+max_val+")("+getLabel("eOR.Integer.label","OR")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "C"){ // checkbox
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=checkbox name='dflt_val' id='dflt_val' style='visibility:visible' value=''>"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "M"){ // descrete measure
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=20 maxlength=25   style='visibility:visible' value='' readonly>("+getLabel("Common.DiscreteMeasure.label","Common")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "D"){ // date
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=10 maxlength=10   style='visibility:visible' value='' onBlur='checkDate(this)'>("+getLabel("Common.date.label","Common")+")(dd/mm/yyyy)"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "E"){ // date time
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=16 maxlength=16   style='visibility:visible' value='' onBlur='validateDateTime(this)'>("+getLabel("Common.Date/Time.label","COMMON")+")(dd/mm/yyyy hh:mi)"
		}else if((eval("document.list_dtl.hdn_fld_type"+indexVal).value == "A") || eval("document.list_dtl.hdn_fld_type"+indexVal).value == "V"){ //alphanumeric
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=30 maxlength=30   style='visibility:visible' value='' onKeyPress = 'return(CheckForSpecCharsWithoutSpace(event))' onBlur='return(CheckForSpecCharsWithoutSpaceBlur(this))'>("+getLabel("eOR.Alphanumeric.label","OR")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "T"){ // time
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=5 maxlength=5   style='visibility:visible' value='' onBlur='checkTime(this)'>("+getLabel("Common.time.label","Common")+")(hh:mi)"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "L" || eval("document.list_dtl.hdn_fld_type"+indexVal).value == "R"){
			var hdnfld=eval("document.list_dtl.hdn_fld_type"+indexVal).value;
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<select name=\"dflt_val\" id=\"dflt_val\"  style='visibility:visible'><option value=''>  -----"+getLabel("Common.defaultSelect.label","Common")+"-----  </select>"
			populateListValues(ord_cat,mnemonic,hdnfld,"bottomdepend");
			presentation_type=eval("document.list_dtl.presentation_type"+indexVal+".value");
			if (presentation_type == null) presentation_type="";
			if(presentation_type=='M' && document.getElementById("accept_option").value!="D"){
				document.getElementById("dflt_val").selectedIndex=0;
				document.getElementById("dflt_val").disabled=true;
			}
		}
		if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "L"
		|| eval("document.list_dtl.hdn_fld_type"+indexVal).value == "R" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "C" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "N" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "E" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "I" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "D"){

			document.getElementById("depend1").innerHTML = getLabel('Common.Dependency.label','COMMON');
			document.getElementById("depend2").innerHTML = "<input type=checkbox name='chk_depnd' id='chk_depnd' style='visibility:visible' value='' OnClick='chkDependency1(\"chkbox\")'><input type=button class='button' name='depend' id='depend' style='visibility:visible' value='"+getLabel('Common.Dependency.label','COMMON')+"' OnClick='chkDependency1(\"butn\")' >"; //IN049133
			//document.getElementById("depend2").innerHTML = "<input type=checkbox name='chk_depnd' id='chk_depnd' style='visibility:visible' value='' OnClick='chkDependency(\"chkbox\")'><input type=button class='button' name='depend' id='depend' style='visibility:visible' value='"+getLabel('Common.Dependency.label','COMMON')+"' OnClick='chkDependency(\"butn\")' >"
		}else{
			document.getElementById("depend1").innerHTML = ""
			document.getElementById("depend2").innerHTML = ""		
		}
		
	}else if(indexVal == 0){
			document.getElementById("deflt_value1").innerHTML = ""
			document.getElementById("deflt_value2").innerHTML = ""
			document.getElementById("depend1").innerHTML = ""
			document.getElementById("depend2").innerHTML = ""
	}
	if(((mnemonic=="BLOOD_TRANS_EXP_DATE")||(mnemonic=="TRANSPLANT_DATE"))||(mnemonic=="NN_MOTHER_PAT_ID")||(mnemonic=="NN_MOTHER_PAT_NAME"))
	{
		document.getElementById("dflt_val").value="";
		document.getElementById("dflt_val").disabled=true;
	}
}
function populateDependencyvalues(seq_no,mnemonic){
	var bean_id = "Or_OrderEntryFormats";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var modalFormObj = document.list_dtl
	var level=modalFormObj.level.value;
	var order_category=modalFormObj.ord_cat.value;
	var order_catalog=modalFormObj.order_catalog.value;
	var order_type=modalFormObj.order_type.value;

	xmlStr ="<root><SEARCH " ;
	xmlStr += "seq_no=\""+ seq_no +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryFormatsValidate1.jsp?bean_id="+bean_id+"&level="+level+"&order_category="+order_category+"&order_catalog="+order_catalog+"&order_type="+order_type+"&seq_no="+seq_no+"&mnemonic="+mnemonic, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	return eval(responseText ) ;
}
function populateOtherMnemonicvalues(value_seq_num){
	var bean_id = "Or_OrderEntryFormats";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	var level=document.decision_support.level.value;
	var order_category=document.decision_support.ord_cat.value;
	var order_catalog=document.decision_support.order_catalog.value;
	var order_type=document.decision_support.order_type.value;
	
	var mnemonic = document.decision_support.mnemonic.value;
	var seq_no = document.decision_support.seq_no.value;
  
	xmlStr ="<root><SEARCH " ;
	xmlStr += "value_seq_num=\""+ value_seq_num +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryFormatsValidate1.jsp?bean_id="+bean_id+"&level="+level+"&order_category="+order_category+"&order_catalog="+order_catalog+"&order_type="+order_type+"&seq_no="+seq_no+"&mnemonic="+mnemonic, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	return eval(responseText ) ;
}
function dependencyValues(depend_final){
	var dependency_arr = depend_final;
	parent.list_bottom.document.list_dtl.dependency_arr.value=dependency_arr;
}
function othMnemonicValues(oth_mnem)
{	
	var depend_finalString = oth_mnem;
	parent.list_depend.document.decision_support.depend_finalString.value=depend_finalString;
}
function OrAllowDateHourFormat()
{
	var key = window.event.keyCode;
	if( ! ( (( key>=48 ) && ( key<=58 ) ) || (key == 47) || key == 32) ) 
	{
       return false;
	}
}

function setFormatValues(key,value)
{	
	var bean_id = "Or_OrderEntryFormats";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlHttp.open( "POST", "OrderEntryFormatsValidate.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value),false ) ;
	xmlHttp.open( "POST", "OrderEntryFormatsValidate.jsp?bean_id="+bean_id+"&key="+key+"&value="+encodeURIComponent(value)+"&validate=Formatvalues",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}
//added to get the Map size.	
function getMapDetail(){
	var bean_id = "Or_OrderEntryFormats";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryFormatsValidate1.jsp?bean_id="+bean_id+"&validate=size", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
	return responseText;
}
//added to get the Map size.	
function clearMapDetail(){
	var bean_id = "Or_OrderEntryFormats";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryFormatsValidate1.jsp?bean_id="+bean_id+"&validate=createclear", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
	return responseText;
}

//added to clear the default values for list.	
function clearDefaultList( docObj ) {
	if(parent.list_bottom.document.getElementById("dflt_val"))
	{
		if(parent.list_bottom.document.getElementById("dflt_val").type=='select-one')
		{
			var len = parent.list_bottom.document.getElementById("dflt_val").options.length ;
			for(var i=0;i<len;i++)
			{
				parent.list_bottom.document.getElementById("dflt_val").remove('atc_class_l2_code') ;
			}
			var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
			var opt = eval(docObj+".createElement(\"OPTION\")") ;
			opt.text = tp ;
			opt.value = "" ;
			parent.list_bottom.document.getElementById("dflt_val").add(opt);
		}
	}
	else
	{
		document.getElementById("deflt_value1").innerHTML = ""
		document.getElementById("deflt_value2").innerHTML = ""
	}
}

//IN049133 - Start 
function chkDependency1(val)
{	
	if(val == "butn")
		parent.list_bottom.list_dtl.chk_depnd.checked	 = true;
	
	if(parent.list_bottom.list_dtl.chk_depnd.checked){
		parent.list_top.list_top.disabled				 = true;
		parent.list_bottom.list_dtl.chk_depnd.disabled	 = true;
		parent.list_bottom.list_dtl.depend.disabled		 = true;
		parent.list_bottom.list_dtl.clear.disabled		 = true;
		parent.list_bottom.list_dtl.mnemonic.disabled	 = true;
		parent.list_bottom.list_dtl.select.disabled		 = true;
		parent.list_bottom.list_dtl.ok.disabled			 = true;
		parent.list_bottom.list_dtl.close.disabled		 = true;
		parent.list_bottom.list_dtl.seq_no.disabled		 = true;
		
		var modalFormObj = parent.list_bottom.document.list_dtl
		var indexVal = modalFormObj.mnemonic.selectedIndex
		var dflt_val =	eval("document.list_dtl.hdn_fld_type"+indexVal).value
		var min_val = eval("document.list_dtl.hdn_minVal"+indexVal).value
		var max_val = eval("document.list_dtl.hdn_maxVal"+indexVal).value
		var mnemonic = modalFormObj.mnemonic.value
		var seq_no = modalFormObj.seq_no.value;
		var format_id = modalFormObj.format_id.value;
		var depd_val;
		finalString = parent.list_bottom.document.list_dtl.finalString.value;
		ord_cat = parent.list_bottom.document.list_dtl.ord_cat.value;
		level = parent.list_bottom.document.list_dtl.level1.value;
		order_type = parent.list_bottom.document.list_dtl.order_type.value;
		ord_catalog = parent.list_bottom.document.list_dtl.order_catalog.value;
		if(parent.list_bottom.document.list_dtl.finalValue)
		{
			finalValue=parent.list_bottom.document.list_dtl.finalValue.value ;
			dontChk=parent.list_bottom.document.list_dtl.dontChk.value ;

			if(flag == undefined)
				var finalString1	= "dflt_val="+dflt_val+"&min_val="+min_val+"&max_val="+max_val+"&ord_cat="+ord_cat+"&mnemonic="+mnemonic+"&seq_no="+seq_no+"&dontChk="+dontChk+"&format_id="+format_id;
			else
				var finalString1	= "dflt_val="+dflt_val+"&min_val="+min_val+"&max_val="+max_val+"&ord_cat="+ord_cat+"&mnemonic="+mnemonic+"&seq_no="+seq_no+"&dontChk="+dontChk+"&format_id="+format_id+"&flag="+flag;
			finalString1 += "&level=" + level;
			finalString1 += "&order_type=" + order_type;
			finalString1 += "&ord_catalog=" + ord_catalog;
			finalString1 += "&finalString=" + finalString;
			finalString1 += "&finalValue=" + finalValue;

			parent.list_depend.location.href="../../eOR/jsp/OrderEntryFormatDependencyDepend.jsp?"+finalString1;
		
		}
	}
}
function populateValues3(){
	var modalFormObj = document.list_dtl;
	var indexVal = modalFormObj.mnemonic.selectedIndex;
	//to clear final value of dependency
	modalFormObj.finalValue.value="";

	var ord_cat = modalFormObj.ord_cat.value;
	var mnemonic = modalFormObj.mnemonic.value;
	
	if (mnemonic.indexOf("@")!=-1)
	{
		var mnemonic1=mnemonic.split("@");
		mnemonic = mnemonic1[1];
	}
	
    if (ord_cat == 'OT') {
        if (((mnemonic == 'PERFORM_TEAM_SURGEON') || (mnemonic == 'PREF_SURG_DATE'))) {
            modalFormObj.accept_option.value = 'R';
            modalFormObj.accept_option.disabled = true;
        } else {
            modalFormObj.accept_option.value = 'O';
            modalFormObj.accept_option.disabled = false;
        }
    }
	var presentation_type=eval("document.list_dtl.presentation_type"+indexVal+".value");
	if (presentation_type == null) presentation_type="";		
	
	var depend_mnemonic = modalFormObj.depend_mnemonic.value
	if(mnemonic == depend_mnemonic){
		alert(getMessage("OPTION_SELECTED","OR"))
			modalFormObj.mnemonic.value="";
		modalFormObj.mnemonic.focus();

	}else if(presentation_type=='M'){
		modalFormObj.mnemonic.selectedIndex=0;
		alert(getMessage('MULTI_PRESENTATION_CANNOT_BE_SELECTED','OR'))
		return false

	}else 
	if(indexVal >0){
	  modalFormObj.object_format_type.value=eval("document.list_dtl.hdn_fld_type"+indexVal).value;
		if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "N"){ //decimal
			var min_val = eval("document.list_dtl.hdn_minVal"+indexVal).value
			var max_val = eval("document.list_dtl.hdn_maxVal"+indexVal).value
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' value='' size=30 maxlength=30 style='visibility:visible' onKeyPress='return(OrAllowDecimalNumber())' onBlur = 'return OrIsValidDecimal(this)'> ("+min_val+"-"+max_val+") ("+ getLabel("eOR.Decimal.label","OR")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "I"){ // integer
			var min_val = eval("document.list_dtl.hdn_minVal"+indexVal).value
			var max_val = eval("document.list_dtl.hdn_maxVal"+indexVal).value
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' value='' size=30 maxlength=30  style='visibility:visible' onKeyPress='return(OrAllowNumber())' onBlur = 'return OrCheckPositiveNumber1(this)'> ("+min_val+"-"+max_val+")("+getLabel("eOR.Integer.label","OR")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "C"){ // checkbox
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=checkbox name='dflt_val' id='dflt_val' style='visibility:visible' value=''>"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "M"){ // descrete measure
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=20 maxlength=25   style='visibility:visible' value='' readonly>("+getLabel("Common.DiscreteMeasure.label","Common")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "D"){ // date
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=10 maxlength=10   style='visibility:visible' value='' onBlur='checkDate(this)'>("+getLabel("Common.date.label","Common")+")(dd/mm/yyyy)"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "E"){ // date time
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=16 maxlength=16   style='visibility:visible' value='' onBlur='validateDateTime(this)'>("+getLabel("Common.Date/Time.label","COMMON")+")(dd/mm/yyyy hh:mi)"
		}else if((eval("document.list_dtl.hdn_fld_type"+indexVal).value == "A") || eval("document.list_dtl.hdn_fld_type"+indexVal).value == "V"){ //alphanumeric
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=30 maxlength=30   style='visibility:visible' value='' onKeyPress = 'return(CheckForSpecCharsWithoutSpace(event))' onBlur='return(CheckForSpecCharsWithoutSpaceBlur(this))'>("+getLabel("eOR.Alphanumeric.label","OR")+")"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "T"){ // time
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<input type=text name='dflt_val' id='dflt_val' size=5 maxlength=5   style='visibility:visible' value='' onBlur='checkTime(this)'>("+getLabel("Common.time.label","Common")+")(hh:mi)"
		}else if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "L" || eval("document.list_dtl.hdn_fld_type"+indexVal).value == "R"){
			var hdnfld=eval("document.list_dtl.hdn_fld_type"+indexVal).value;
			document.getElementById("deflt_value1").innerHTML = getLabel("Common.DefaultValue.label","Common");
			document.getElementById("deflt_value2").innerHTML = "<select name=\"dflt_val\" id=\"dflt_val\"  style='visibility:visible'><option value=''>  -----"+getLabel("Common.defaultSelect.label","Common")+"-----  </select>"
			populateListValues(ord_cat,mnemonic,hdnfld,"bottomdepend");
			presentation_type=eval("document.list_dtl.presentation_type"+indexVal+".value");
			if (presentation_type == null) presentation_type="";
			if(presentation_type=='M' && document.getElementById("accept_option").value!="D"){
				document.getElementById("dflt_val").selectedIndex=0;
				document.getElementById("dflt_val").disabled=true;
			}
		}
		if(eval("document.list_dtl.hdn_fld_type"+indexVal).value == "L"
		|| eval("document.list_dtl.hdn_fld_type"+indexVal).value == "R" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "C" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "N" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "E" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "I" ||eval("document.list_dtl.hdn_fld_type"+indexVal).value == "D"){

			document.getElementById("depend1").innerHTML = getLabel('Common.Dependency.label','COMMON');
			document.getElementById("depend2").innerHTML = "<input type=checkbox name='chk_depnd' id='chk_depnd' style='visibility:visible' value='' OnClick='chkDependency1(\"chkbox\")'><input type=button class='button' name='depend' id='depend' style='visibility:visible' value='"+getLabel('Common.Dependency.label','COMMON')+"' OnClick='chkDependency1(\"butn\")' >"; 
		}else{
			document.getElementById("depend1").innerHTML = ""
			document.getElementById("depend2").innerHTML = ""		
		}
		
	}else if(indexVal == 0){
			document.getElementById("deflt_value1").innerHTML = ""
			document.getElementById("deflt_value2").innerHTML = ""
			document.getElementById("depend1").innerHTML = ""
			document.getElementById("depend2").innerHTML = ""
	}
	if(((mnemonic=="BLOOD_TRANS_EXP_DATE")||(mnemonic=="TRANSPLANT_DATE"))||(mnemonic=="NN_MOTHER_PAT_ID")||(mnemonic=="NN_MOTHER_PAT_NAME"))
	{
		document.getElementById("dflt_val").value="";
		document.getElementById("dflt_val").disabled=true;
	}
}
//IN049133 - End

