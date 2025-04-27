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


function create()
{
	f_query_add_mod.location.href='../../eOR/jsp/TestFrame.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}

/***************************************/

/*function query()
{
		f_query_add_mod.location.href='../../eOR/jsp/TestQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}*/

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
		if (f_query_add_mod.f_query_add_mod_detail.document.forms[0] !=null){
			f_query_add_mod.f_query_add_mod_detail.document.forms[0].reset();
		}
	}
	
}

function apply() {

	//alert("1");
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

			arrLegends[0]			=	getLabel("eOR.ActivityType.label","OR");
			arrLegends[1]			=	getLabel("Common.description.label","Common");
			arrLegends[2]			=	getLabel("Common.ExplanatoryText.label","Common");

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
						invalidCode=invalidCode.substring(3, invalidCode.length);
					}
						//alert("invalidCode2222222222="+invalidCode);
						showDuplicates(formObj,arrPKFieldNames,invalidCode,"0",messageFrame );
				}
			}
		}
	}
	}		
	else {
		//alert("description="+f_query_add_mod.f_query_add_mod_header.document.ChargeTypeSingle.description.value);
		var fields = new Array ( f_query_add_mod.f_query_add_mod_header.document.ChargeTypeSingle.description,f_query_add_mod.f_query_add_mod_header.document.ChargeTypeSingle.explanatory_note);
		var names = new Array ( getLabel("Common.description.label","Common"),getLabel("Common.ExplanatoryText.label","Common"));

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

function onSuccess(){

		formReset ();

}
/***************************************/
function formReset () {
	//alert("in reset");

	f_query_add_mod.location.reload();
}
/***********************************************/
function reset(){
	create();	
}
/***********************************************/

function ord_cat(obj){
	//alert("onchange of order category");
	document.getElementById("order_category").value=obj.value;
	parent.f_query_add_mod_left.TestLeft.document.getElementById("hid_order_category").value=obj.value;
}
function com(obj){
	document.getElementById("comment").value=obj.value;
	parent.f_query_add_mod_left.TestLeft.document.getElementById("hid_comment").value=obj.value;
}
function ord_date(obj){
	document.getElementById("ordered_date").value=obj.value;
	parent.f_query_add_mod_left.TestLeft.document.getElementById("hid_ord_date").value=obj.value;
}
	
function spec_yn(obj){
if(obj.checked)
	document.getElementById("specimen_yn").value="Y";
else
	document.getElementById("specimen_yn").value="N";

	parent.f_query_add_mod_left.TestLeft.document.getElementById("hid_spec_yn").value=document.getElementById("specimen_yn").value;
}

