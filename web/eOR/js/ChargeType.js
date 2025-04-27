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
/************************************************************************/
function intialiseGlobal(){
function_id = "" ;
resultGlobal = false;
messageGlobal = "" ;
flagGlobal = true;
}
/*********************Header Handle*****************************/
function getHandleHeader(){

if(f_query_add_mod.f_query_add_mod_header == null)
	 return false;
 headerDoc	     =f_query_add_mod.f_query_add_mod_header.document ;
 formObjHeader   =headerDoc.ChargeTypeHeader ;
 var order_category_id=formObjHeader.order_category.value;

}

/**********************Detail Handle**********************************/
function getHandleDetail(){

 detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;
 formObjDetail	 =detailDoc.ChargeTypeDetail ;

}
/***************************************/

function resetColorCode(obj)
{
//alert();
	var arrPKFieldNames	=	new Array();
	var formObj			=	parent.f_query_add_mod_detail.document.ChargeTypeDetail;
	arrPKFieldNames[0]	=	"charge_type_code";
	resetDuplicateClass( formObj, arrPKFieldNames,0, obj );
}

/********************Create function*************************************/

function create()
{
	f_query_add_mod.location.href='../../eOR/jsp/ChargeTypeMultiple.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}

/***************************************/

function query()
{
		f_query_add_mod.location.href='../../eOR/jsp/ChargeTypeQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}

/***************************delete record********************************/


function deleterecord(){

  //  alert("in delete");

	if (f_query_add_mod.f_query_add_mod_header.document.ChargeTypeSingle !=null){
		if (!checkIsValidForProceed() || mode == '1' ) {
  		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
		}              


	var formObj=f_query_add_mod.f_query_add_mod_header.document.ChargeTypeSingle;
	var mode = formObj.mode.value ;
    //alert("mode"+mode);
	//formObj.mode.value = "0"; //set mode to delete
	//alert("formObj.mode.value="+formObj.elements.length());
	var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));	
	if(confirm_val){
	formObj.mode.value = "0"; //set mode to delete
	eval(formApply(formObj,OR_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;	
	if(resultGlobal){//	onSuccess();
	create();
	intialiseGlobal();
	}
	}else
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}else
	{	
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

}


/******************************************************************************/

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
		if (f_query_add_mod.f_query_add_mod_detail.document.forms[0] !=null){
			f_query_add_mod.f_query_add_mod_detail.document.forms[0].reset();
		}
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
	//alert(" mod :"+f_query_add_mod.f_query_add_mod_detail.document.ChargeTypeDetail.mode.value);
	if (!checkIsValidForProceed()){
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	//alert("2");

	// local variable of the function apply this only function using for modify and insert
	var flag1=true;
	var flag2=true;
	var flag	= true ;
	var msgID		= ""   ;
	var msgDesc		= ""   ;
	var arrIDS		= new Array();
	var arrIDesc		= new Array();
	var size =0;
 var invalidCode="" ;
	
	//alert(f_query_add_mod.f_query_add_mod_header.document.ActivityTypeHeader.order_category.value);
if(f_query_add_mod.f_query_add_mod_detail.document.ChargeTypeDetail!=null)
{
	if(f_query_add_mod.f_query_add_mod_detail.document.ChargeTypeDetail.mode.value==MODE_INSERT ){
		
		//alert("3");
		var fields = new Array (f_query_add_mod.f_query_add_mod_header.document.ChargeTypeHeader.order_category);
		var names = new Array ( getLabel("Common.OrderCategory.label","Common"));
		if(checkFieldsofMst( fields, names, messageFrame)) {

			//alert("4");
			
			var formObjH = f_query_add_mod.f_query_add_mod_header.document.ChargeTypeHeader;
			var formObj = f_query_add_mod.f_query_add_mod_detail.document.ChargeTypeDetail;
			
			formObj.order_category.value = formObjH.order_category.value;
			//alert(formObj.explanatory_note0.value.length);
			
			for(i = 0 ; i < 8 ; i++){
				
				var flds=new Array(eval("formObj.charge_type_code"+i));
				var name=new Array(getLabel("eOR.ChargeType.label","OR"));
				//alert("i@@@@@@@@="+i);
				if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
					//alert("kk");
					return false
				}
			}	
			//alert("sssssssss");
			var arrFieldName		=	new Array();
			var arrLegends			=	new Array();
			var arrPKFieldNames		=	new Array();

			arrFieldName[0]			=	"charge_type_code";
			arrFieldName[1]			=	"description";
			arrFieldName[2]			=	"explanatory_note";

			arrLegends[0]			=	getLabel("eOR.ChargeTypeCode.label","OR");
			arrLegends[1]			=	getLabel("Common.description.label","COMMON");
			arrLegends[2]			=	getLabel("Common.ExplanatoryText.label","COMMON");

			arrPKFieldNames[0]		=	"charge_type_code";
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
	else{
		//alert("modify");
		     
		//alert("description="+f_query_add_mod.f_query_add_mod_header.document.ChargeTypeSingle.description.value);
		var fields = new Array ( f_query_add_mod.f_query_add_mod_header.document.ChargeTypeSingle.description,f_query_add_mod.f_query_add_mod_header.document.ChargeTypeSingle.explanatory_note);
		var names = new Array ( getLabel("Common.description.label","COMMON"),getLabel("Common.ExplanatoryText.label","COMMON"));

		if(checkFieldsofMst( fields, names, messageFrame)){
			eval(formApply(f_query_add_mod.f_query_add_mod_header.document.ChargeTypeSingle ,OR_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=  "+ messageGlobal;

			if(resultGlobal) {
				onSuccess();
			}
		}
	}// else modify ends here       
}
/**************************************/
function assignResult(_result , _message, _flag, invCode){
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
	invalidCode=invCode;
}

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

	var ChargeTypeArrayLocal  = new Array()
	var arrLocalLen = 0;

	
	 //Construct arrLocal array for the Page
	for(i=0;i<8;i++){
		//alert("9");

		var obj  = eval("formObjDetail.charge_type_code" +i) ;
		
		if(obj.value != "" && obj.value != null )
			ChargeTypeArrayLocal[i] = obj.value ;
		else
			ChargeTypeArrayLocal[i] = "";
	}


	arrLocalLen = ChargeTypeArrayLocal.length ;
//alert("ActivityTypeArrayLocal="+ActivityTypeArrayLocal);
//alert("arrLocalLen="+arrLocalLen);

	//CODE FOR CHK DUPLICATES on Local Page
	var chkDuplicate = false ;

	for(k=0;k<(ChargeTypeArrayLocal.length-1);k++)
	{
		//alert("10");
		var chk = ChargeTypeArrayLocal[k] ;

		if(chk != "" && chk != null )
		{
			//alert("11");
				for(h=k+1;h<ChargeTypeArrayLocal.length;h++)
				{
						//alert("333333333331");
					if(chk==ChargeTypeArrayLocal[h])
					{
						chkDuplicate = true ;
					}
				}
		}

	}

	if(chkDuplicate == true)
	{ 
//alert("12");
		
		var message  =getMessage("DUPLICATE_VALUES","OR");
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

function detailPageReload()
{
	parent.f_query_add_mod_detail.location.reload()
}
/***********************************************/
/*function discharge()
{
	var retVal;
 	var dialogTop   = "260";
 	var dialogHeight= "25" ;
 	var dialogWidth = "40" ;
 	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments	= "";

 	var qryString = "";
 	//qryString += "bean_id="+bean_id+"&bean_name="+bean_name;
		//+"&start_date_time="+start_date_time;
 	//qryString += "&pri_order_catalog_code="+pri_order_catalog_code+"&priority="+priority+"&patient_class="+patient_class+"&sec_order_catalog_type="+sec_order_catalog_type;
 	retVal 			= window.showModalDialog("../../eOR/jsp/OrderEntryIPDischargeFrameSet.jsp?"+qryString,arguments,features);
}*/



