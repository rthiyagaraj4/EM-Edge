/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
///////////////// Global Variable declaration ////////////////////////////////
var function_id = "" ;
var result = false;
var message = "" ;
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var detailDocUpdate=null;
var formObjDetailUpdate=null	;
var invalidCode			=null;
var headerDoc			=null;
var detailDoc			=null;
var formObjHeader		=null;
var formObjDetail		=null;

/////////////////Declaration ends here////////////////////////////////////
/*********************Header Handle*****************************/
function getHandleHeader(){

if(f_query_add_mod.f_query_add_mod_header == null)
	 return false;
 headerDoc	     =f_query_add_mod.f_query_add_mod_header.document ;
 formObjHeader   =headerDoc.ActivityTypeHeader ;

 var order_category_id=formObjHeader.order_category.value;

}

/**********************Detail Handle**********************************/
function getHandleDetail(){

 detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;
 formObjDetail	 =detailDoc.ActivityTypeDetail ;

}
/***************************************/

function resetColorCode(obj)
{

	var arrPKFieldNames	=	new Array();
	var formObj			=	parent.f_query_add_mod_detail.document.ActivityTypeDetail;
	arrPKFieldNames[0]	=	"activity_type";
	resetDuplicateClass( formObj, arrPKFieldNames,0, obj );
}
/********************Create function*************************************/

function create()
{
	
	f_query_add_mod.location.href='../../eOR/jsp/ActivityTypeAddModifyMultiple.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}

/***************************************/

function query()
{
	
		f_query_add_mod.location.href='../../eOR/jsp/ActivityTypeQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}

/***************************************/

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
		f_query_add_mod.f_query_add_mod_header.document.forms[0].reset();
		f_query_add_mod.f_query_add_mod_detail.location.reload();
	}
	
}
/***************************************/
function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
  return true;
 else
  return false;
}
/***************************************/

function apply() {

	//alert("1");
	if (!checkIsValidForProceed()){
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	//ert("2");

	// local variable of the function apply this only function using for modify and insert
	var flag1=true;
	var flag2=true;
	var flag	= true ;
	var msgID		= ""   ;
	var msgDesc		= ""   ;
	var arrIDS		= new Array();
	var arrIDesc		= new Array();
	var size =0;
 
	
	//alert(f_query_add_mod.f_query_add_mod_header.document.ActivityTypeHeader.order_category.value);
if(f_query_add_mod.f_query_add_mod_detail.document.ActivityTypeDetail!=null)
{
	if(f_query_add_mod.f_query_add_mod_detail.document.ActivityTypeDetail.mode.value==MODE_INSERT ){
		
		//ert("3");
		var fields = new Array (f_query_add_mod.f_query_add_mod_header.document.ActivityTypeHeader.order_category);
		var names = new Array ( getLabel("Common.OrderCategory.label","Common"));
		if(checkFieldsofMst( fields, names, messageFrame)) {

			//alert("4");
			
			var formObjH = f_query_add_mod.f_query_add_mod_header.document.ActivityTypeHeader;
			var formObj = f_query_add_mod.f_query_add_mod_detail.document.ActivityTypeDetail;
			
			formObj.order_category.value = formObjH.order_category.value;
			
			for(i = 0 ; i < 10 ; i++){
				
				var flds=new Array(eval("formObj.activity_type"+i));
				var name=new Array(getLabel("eOR.ActivityType.label","OR"));
				//alert("i@@@@@@@@="+i);
				if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
					//alert("kk");
					return false
				}
			}	
			var arrFieldName		=	new Array();
			var arrLegends			=	new Array();
			var arrPKFieldNames		=	new Array();

			arrFieldName[0]			=	"activity_type";
			arrFieldName[1]			=	"long_desc";
			arrFieldName[2]			=	"short_desc";

			arrLegends[0]			=	getLabel("eOR.ActivityType.label","OR");
			arrLegends[1]			=	getLabel("Common.LongDesc.label","COMMON");
			arrLegends[2]			=	getLabel("Common.ShortDesc.label","COMMON");

			arrPKFieldNames[0]		=	"activity_type";
			resetDuplicateClass(formObj, arrPKFieldNames );
			var	result1	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
			//alert("result1="+result1);
			if(result1) {
				
				if(!chkDulplicateActivityType())
					return false;
//alert("eee");
				

				eval(formApply(formObj,OR_CONTROLLER));
//alert("14");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
//alert("messageGlobal="+messageGlobal);
//alert("resultGlobal="+resultGlobal);
				if(resultGlobal) {
//alert("onsuccess");
					onSuccess();
				}else if(invalidCode != "" && invalidCode != "null"){
//alert("arrPKFieldNames="+arrPKFieldNames[0]);
//alert("invalidCode="+invalidCode);
					if(invalidCode.indexOf(":")!=-1)
					{
						invalidCode = invalidCode.substring((invalidCode.indexOf(":")+1), invalidCode.length);
					}
						//alert("invalidCode2222222222="+invalidCode);
						showDuplicates(formObj,arrPKFieldNames,invalidCode,"0",messageFrame );
				}
			}
		}
	}
	}		
	else {
		//alert("modify mode");
		var fields = new Array ( f_query_add_mod.f_query_add_mod_header.document.ActivityTypeUpdate.long_desc,f_query_add_mod.f_query_add_mod_header.document.ActivityTypeUpdate.short_desc);
		var names = new Array ( getLabel("Common.LongDesc.label","COMMON"),getLabel("Common.ShortDesc.label","COMMON"));

		if(checkFieldsofMst( fields, names, messageFrame)){
			eval(formApply(f_query_add_mod.f_query_add_mod_header.document.ActivityTypeUpdate ,OR_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=  "+ messageGlobal;

			if(resultGlobal) {
				onSuccess();
			}
		}
	}// else modify ends here
}
/**************************************/
function assignResult(_result , _message, _flag, invCode){
//alert("in assignResult(),_message="+_message);
//alert("in assignResult(),flagGlobal="+flagGlobal);
//alert("in assignResult(),invalidCode="+invalidCode);

	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
	invalidCode=invCode;


}
/**************************************/

/******************************************/

function chkDulplicateActivityType(){
//alert("8");
	//Chk whether detail form present or not
//	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
	
	if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1){
	return true;
	}

	getHandleDetail();
	getHandleHeader();

	var ActivityTypeArrayLocal  = new Array()
	var arrLocalLen = 0;

	
	 //Construct arrLocal array for the Page
	for(i=0;i<10;i++){
		//alert("9");

		var obj  = eval("formObjDetail.activity_type" +i) ;
		
		if(obj.value != "" && obj.value != null )
			ActivityTypeArrayLocal[i] = obj.value ;
		else
			ActivityTypeArrayLocal[i] = "";
	}


	arrLocalLen = ActivityTypeArrayLocal.length ;
//alert("ActivityTypeArrayLocal="+ActivityTypeArrayLocal);
//alert("arrLocalLen="+arrLocalLen);

	//CODE FOR CHK DUPLICATES on Local Page
	var chkDuplicate = false ;

	for(k=0;k<(ActivityTypeArrayLocal.length-1);k++)
	{
		//alert("10");
		var chk = ActivityTypeArrayLocal[k] ;

		if(chk != "" && chk != null )
		{
			//alert("11");
				for(h=k+1;h<ActivityTypeArrayLocal.length;h++)
				{
						//alert("333333333331");
					if(chk==ActivityTypeArrayLocal[h])
					{
						chkDuplicate = true ;
					}
				}
		}

	}

	if(chkDuplicate == true)
	{ 
//alert("12");
		
		var message  = getMessage("DUPLICATE_VALUES","OR");
		//alert("APP-OR0005 Duplicate values are passed");
		//var message = getOrMessage("SEQ_TICK_SHEET_SECTION_CHK") ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
//alert("13");

	return true;

}//End of Duplicate Function
/**************************************/
function onSuccess(){

		formReset ();

}
/***************************************/
function formReset () {

	f_query_add_mod.location.reload();
}

/***************************************/

function fillOrderType(OrderCategory) {
	//parent.f_query_add_mod_detail.location.reload();

	//alert("OrderCategory="+OrderCategory.name);

	if(OrderCategory.value == "" ) {
		parent.f_query_add_mod_header.location.reload();

		return ;
		}
	var OrderCategoryValue = OrderCategory.value ;
	var bean_id = document.ActivityTypeHeader.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += OrderCategory.name+"=\""+ OrderCategory.value +"\" " ;
	xmlStr +=" /></root>" ;
	//alert(xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ActivityTypeFillOrderType.jsp?bean_id=Or_activity_type&fill=OrderCategory",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval( responseText ) ;
}
/***************************************/

function addOrderType2List(code,value)
	{
		//alert("kk");
		var totalRecords=parent.f_query_add_mod_detail.document.ActivityTypeDetail.totalRecords.value ;
		for(var j=0;j<totalRecords;j++)
		{	
			var element = document.createElement('OPTION') ;
			element.value = code ;
			element.text  = value ;
			//var docObj=parent.f_query_add_mod_detail.document.ActivityTypeDetail;
			eval("parent.f_query_add_mod_detail.document.ActivityTypeDetail.order_type_code"+j+".add(element)") ;
		}

	}
/***************************************/
function clearOrderTypeList( docObj ) {
	//alert("docObj="+docObj.name);
	var totalRecords=parent.f_query_add_mod_detail.document.ActivityTypeDetail.totalRecords.value ;
	for(var j=0;j<totalRecords;j++)
	{
	
		var len = eval("parent.f_query_add_mod_detail."+docObj+".ActivityTypeDetail.order_type_code"+j+".options.length") ;
		for(var i=0;i<len;i++)
		{
			eval("parent.f_query_add_mod_detail."+docObj+".ActivityTypeDetail.order_type_code"+j+".remove(\"order_type_code\")") ;
		}
		
		var opt = eval("parent.f_query_add_mod_detail."+docObj+".createElement(\"OPTION\")") ;
		opt.text = getLabel("Common.all.label","Common") ;
		opt.value = "*ALL" ;
		eval("parent.f_query_add_mod_detail."+docObj+".ActivityTypeDetail.order_type_code"+j+".add(opt)") ;

		eval("parent.f_query_add_mod_detail."+docObj+".ActivityTypeDetail.activity_type"+j+".value=\"\" ");
		eval("parent.f_query_add_mod_detail."+docObj+".ActivityTypeDetail.long_desc"+j+".value=\"\" ");
		eval("parent.f_query_add_mod_detail."+docObj+".ActivityTypeDetail.short_desc"+j+".value=\"\" ");
		eval("parent.f_query_add_mod_detail."+docObj+".ActivityTypeDetail.eff_status"+j+".value='E' ");
		eval("parent.f_query_add_mod_detail."+docObj+".ActivityTypeDetail.eff_status"+j+".checked='true' ");
	
	}
}

/***************************************/

