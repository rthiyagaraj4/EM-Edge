/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var	headerDoc		= null	;
var	formObjHeader	= null	;
var	function_id		= "" ;
var	result_apply	= false;
var	message_global	= "" ;
var	flag_apply		= true;
var query_string="";
 ///////////////////////////////////////////////////
function create() {
	//alert("create");
f_query_add_mod.location.href = "../../eOR/jsp/ImageHotspotAddModifyMultiple.jsp?mode=1&function_id=Image_Hotspot";
}

///////////////////////////////////////////////////////////////////////////
function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("blank")==-1) && (url.indexOf("multiple")==-1) )
		return true;
	else
		return false;
}
///////////////////////////////////////////////////////////////////////

function onSuccess() {
			   formReset();
}
//////////////////////////////////////////////////////////////////////
function formReset () {
				var formObj1 = f_query_add_mod.query.document.frm_img_hot_spot ;
				var mode=formObj1.mode.value;
if(mode==MODE_DELETE)
			{	   //alert(mode);
						f_query_add_mod.location.reload();}
else if(mode == MODE_INSERT){
			f_query_add_mod.location.reload();	}
else{
				f_query_add_mod.query.location.reload();
				f_query_add_mod.result.location.reload();}
 }
/////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////
function deleterecord(){

var formObj1 = f_query_add_mod.query.document.frm_img_hot_spot ;

if(formObj1.mode.value != MODE_INSERT){
		formObj1.mode.value = MODE_DELETE;
	eval(formApply(  f_query_add_mod.query.document.frm_img_hot_spot ,OR_CONTROLLER) );
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message_global;
		 if(result_apply) {
				onSuccess();
				}
		}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
			}
}
/////////////////////////////////////////////////////////////////////////////////////
function apply() {
	 if (! checkIsValidForProceed() )
    {
		var message  = getMessage("NOT_VALID","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
		}

	var	formObj	= f_query_add_mod.query.document.frm_img_hot_spot ;
	var fields = new Array ( f_query_add_mod.query.document.frm_img_hot_spot.hotspot_id, f_query_add_mod.query.document.frm_img_hot_spot.hotspot_name);
	var names = new Array ( getLabel("Common.identification.label","Common"),getLabel("Common.name.label","Common")	);


	if(checkFieldsofMst( fields, names, messageFrame)){
		eval(formApply(formObj,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message_global;
		 if(result_apply) {
			onSuccess();
		}

	}
}
/////////////////////////////////////////////////////////////////////////////////////
function assignResult( _result,	message, _flag ) {
	result_apply	= _result ;
	message_global	= message	;
	flag_apply	= _flag;
}
/////////////////////////////////////////////////////////////////////////////////////
function reset(){

}
/////////////////////////////////////////////////////////////////////////////////////
function change(thisObj){

	if(thisObj.value!="")
	f_query_add_mod.result.location.href="../../eOR/jsp/ImageHotspotFigure.jsp?image_id="+thisObj.value+"&mode="+;
	else{
		f_query_add_mod.query.document.getElementById("idname").innerHTML="&nbsp;";
		f_query_add_mod.query.document.getElementById("idvalue").innerHTML="&nbsp;";
		f_query_add_mod.query.document.getElementById("imagename").innerHTML="&nbsp;";
		f_query_add_mod.query.document.getElementById("imagevalue").innerHTML="&nbsp;";
		f_query_add_mod.result.location.href="../../eCommon/html/blank.html";
	}

}
/////////////////////////////////////////////////////////////////////////////////////
/*function beforePost(str){
	alert(str);
}*/
