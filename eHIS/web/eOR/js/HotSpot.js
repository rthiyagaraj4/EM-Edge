/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
------------------------------------------------------------------------------------------------------------------------------
*/
var	headerDoc		= null	;
var	formObjHeader	= null	;
var	function_id		= "" ;

var	result_apply	= false;
var	message_global	= "" ;
var	flag_apply		= true;
  var present=0;
  var Ypos="";
 ///////////////////////////////////////////////////
function create() {		

f_query_add_mod.location.href = "../../eOR/jsp/ImageHotspotAddModifyMultiple.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}
///////////////////////
function checkIsValidForProceed1(url) {
	url = url.toLowerCase();
	if ( (url.indexOf("blank")==-1)  )
		return true;
	else
		return false;
}
function checkIsValidForProceed() {
	var url=f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank")==-1)  )
		return true;
	else
		return false;
}
///////////////////////////////////////////////////////////////////////
function check(){
var id=f_query_add_mod.query.document.getElementById("idvalue").innerHTML;
id=id.toLowerCase();
if ( (id.indexOf("hotspot_id")!=-1)  )
		return true;
	else
		return false;
}
 
///////////////////////////////////////////////////////////////////////
function apply() {
	
	if (! checkIsValidForProceed() ){
			var message  = getMessage("NOT_VALID","OR"); 
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	}
	var	formObj	= f_query_add_mod.query.document.frm_img_hot_spot ;
	var fields1 =new Array ( f_query_add_mod.query.document.getElementById("frm_img_hot_spot").image_id);
	var names1 = new Array ( getLabel("Common.Image.label","COMMON")	);

if(checkFieldsofMst( fields1, names1, messageFrame)){ 
	if (! check() ){
			var message  = getMessage("SELECT_HOTSPOT","OR"); 
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	}
	
	var fields =new Array ( f_query_add_mod.query.document.frm_img_hot_spot.hotspot_id
							, f_query_add_mod.query.document.frm_img_hot_spot.hotspot_name);
	var names = new Array ( getLabel("Common.identification.label","Common"),getLabel("Common.name.label","Common"));

if(checkFieldsofMst( fields, names, messageFrame)){ 
//	if(f_query_add_mod.checkFields( fields, names, messageFrame)){
	    var flds=new Array(f_query_add_mod.query.document.frm_img_hot_spot.hotspot_id);
	    var name=new Array(getLabel("Common.identification.label","Common"));
	  if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
				eval(formApply(formObj,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message_global;
		 if(result_apply) {
			 present=0;
			 onSuccess(); }
	  }
	}
}
}
///////////////////////////////////////////////////////////////////////
function onSuccess() {		   formReset();  }
//////////////////////////////////////////////////////////////////////
function formReset () {
	var formObj1 = f_query_add_mod.query.document.frm_img_hot_spot ;
	var mode=formObj1.mode.value;
	if(mode == MODE_DELETE)	{
		f_query_add_mod.location.reload();	
	}else if(mode == MODE_INSERT){	 
		f_query_add_mod.location.reload();	
	}else {	
		f_query_add_mod.query.location.reload();
		f_query_add_mod.result.location.reload();}
	}
/////////////////////////////////////////////////////////////////////////////////////

function deleterecord(){
	if (! checkIsValidForProceed() ){
			var message  = getMessage("NOT_VALID_DELETE","OR"); 
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	}


var formObj1 = f_query_add_mod.query.document.frm_img_hot_spot ;
	var fields1 =new Array ( f_query_add_mod.query.document.getElementById("frm_img_hot_spot").image_id);
	var names1 = new Array ( getLabel("Common.Image.label","COMMON"));

if(checkFieldsofMst( fields1, names1, messageFrame)){ 
	if (! check() ){
			var message  = getMessage("SELECT_HOTSPOT","OR"); 
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	}
	if(formObj1.mode.value != MODE_INSERT){
		
		var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
		if(confirm_val){
			formObj1.mode.value = MODE_DELETE;
			eval(formApply(  f_query_add_mod.query.document.frm_img_hot_spot ,OR_CONTROLLER) );
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message_global;
			if(result_apply) { onSuccess();	}
			}else
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}else
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	}
}


function assignResult( _result,	message, _flag ) {
	result_apply	= _result ;
	message_global	= message	;
	flag_apply	= _flag;
}
/////////////////////////////////////////////////////////////////////////////////////
function reset(){
	if(f_query_add_mod.location.href.indexOf("ImageHotspotAddModifyMultiple")!=-1){
		if(f_query_add_mod.query.frm_img_hot_spot !=null){
		f_query_add_mod.query.frm_img_hot_spot.reset();
		
		if(f_query_add_mod.query.frm_img_hot_spot.hotspot_id==null)
		f_query_add_mod.result.location.href='../../eCommon/html/blank.html';
				
		if(f_query_add_mod.query.frm_img_hot_spot.hotspot_id!=null)
		f_query_add_mod.query.frm_img_hot_spot.hotspot_id.focus();
		}
	}
	else {
	frames[0].location.reload();
	return false;
	}

}

function change(thisObj){
	var val=thisObj.value;
	var code = "";
	var url  = "";
	clearList()
	if(thisObj.value!="") {
		obj_value = (thisObj.value.split("||"))
		code	  = obj_value[0];
 		//set the (code) image_id back to the hidden field
		if(f_query_add_mod.query)
	 		f_query_add_mod.query.document.frm_img_hot_spot.image_id.value = code;

		url		  = obj_value[1];
 		f_query_add_mod.result.location.href="../../eOR/jsp/ImageHotspotFigure.jsp?image_id="+code+"&image_url="+escape(url)+"&function_id="+function_id+"&mode="+MODE_INSERT;
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	}


}

function clearList(){

	if(f_query_add_mod.query.document.frm_img_hot_spot.hotspot_id){

		//f_query_add_mod.query.document.getElementById("id1").innerHTML="&nbsp;";
		//f_query_add_mod.query.document.getElementById("id4").innerHTML="&nbsp;";

		
		//f_query_add_mod.query.document.getElementById("idname").innerHTML="&nbsp;";
		//f_query_add_mod.query.document.getElementById("idvalue").innerHTML="&nbsp;";
		//f_query_add_mod.query.document.getElementById("imagename").innerHTML="&nbsp;";
		//f_query_add_mod.query.document.getElementById("imagevalue").innerHTML="&nbsp;";
		
		//f_query_add_mod.query.document.getElementById("imagename1").innerHTML="&nbsp;";
		//f_query_add_mod.query.document.getElementById("imagename4").innerHTML="&nbsp;";

		f_query_add_mod.result.location.href="../../eCommon/html/blank.html";

	}
}
//IN072524 Starts
function setFPPYN(obj){
	
	if(obj.checked)
	{
		document.getElementById('fpp_yn').value = 'Y';
	}
	else{
		document.getElementById('fpp_yn').value = 'N';
		
	}
}
//IN072524 Ends
/////////////////////////////////////////////////////////////////////////////////////
/*function beforePost(str){
	alert(str);
}*/

