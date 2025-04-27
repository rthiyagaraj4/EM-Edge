/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

function query()
{
	
	
	f_query_add_mod.location.href = "../../eSS/jsp/MaintainROFStatusMain.jsp?mode="+MODE_MODIFY+"&function_id="+function_id;
}

function reset()
{
		
//	if(f_query_add_mod.document.formMaintainROFStatus!=null)
//		f_query_add_mod.document.formMaintainROFStatus.reset();
	f_query_add_mod.location.reload();
	
	
}

function showTrayDtl()
{
	parent.qryResultMaintainROFStatus.location.href="../../eSS/jsp/MaintainROFStatusQueryResult.jsp?mode="+MODE_MODIFY+"function_id="+function_id;
}

function Modify(obj){
	var doc_type_code =obj.cells[4].innerText;
	var doc_no =obj.cells[1].innerText;
	var store_code =obj.cells[5].innerText;
	parent.document.location.href="../../eSS/jsp/MaintainROFStatusAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&store_code="+store_code;
}



function apply()
{
		var formObj = f_query_add_mod.document.formMaintainROFStatus;
		var errorPage	=	"../../eCommon/jsp/error.jsp";
		var fields = new Array (formObj.doc_type_code, formObj.doc_no,formObj.doc_date,formObj.store_code);
		var names = new Array (getLabel("Common.DocType.label","Common"),getLabel("eSS.DocNo.label","SS"),getLabel("eSS.DocDate.label","SS"),getLabel("eSS.Store.label","SS"));
		var blankObject = null;
		if(formObj.mode.value==MODE_MODIFY){
			
		blankObject = getBlankField( fields, names, messageFrame,errorPage);
		if(blankObject == null) {
				eval(formApply(formObj,SS_CONTROLLER));
			
				 messageFrame.location.href = errorPage+"?err_num="+ message;
				 result=true;
			if( result ) {	
				
				onSuccess();
			}
		}
		else 
			
			blankObject.focus();
		}
}
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
		
    if ( (url.indexOf("blank.html")!=-1) && (url.indexOf("AddModify")!=-1) )
        return true;
    else
		
        return false;
	
}
function assignResult( _result, _message, _flag ) 
{
	result		=	_result ;
	message		=	_message ;
	flag		=	_flag ;
}
	
function onSuccess(){
	
	f_query_add_mod.location.reload();
 	
	
}

function assignBean() {
	bean_id = document.formMaintainROFStatus.bean_id.value;
	bean_name = document.formMaintainROFStatus.bean_name.value;
	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
}
