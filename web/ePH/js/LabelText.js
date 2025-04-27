  //saved on 07/11/2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var GLlabel_text_id="";         


function create() {
	//alert("here in js");
	f_query_add_mod.location.href="../../ePH/jsp/LabelTextAddModify.jsp?mode="+MODE_INSERT; 
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/LabelTextQueryCriteria.jsp" ;
}


/***************************apply()****************************************************/
/*function apply(){
	if(f_query_add_mod.document.forms[0].name=="formLabelText"){
	   f_query_add_mod.document.forms[0].submit();
	}
	else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}*/

function apply(){
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	
	//this mode would come null from queryCriteria page on apply button press if checkIsValidForProceed() function is not used
	var mode = f_query_add_mod.document.formLabelText.mode.value;
	if(mode=="1"){
		var formObj = f_query_add_mod.document.formLabelText ;
		//var fields = new Array (formObj.label_text_id ,formObj.label_text_type,formObj.label_text_1,formObj.label_text_2);
		var fields = new Array (formObj.label_text_id ,formObj.label_text_type,formObj.label_text_1);
		var text=getLabel("Common.Text.label","Common");
		var text1=text+"1";
		//var text2=text+"2";
		var names = new Array ( getLabel("Common.identification.label","Common"),getLabel("Common.type.label","Common"),getLabel("Common.description.label","Common"),text2);
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			eval( formApply( formObj,PH_CONTROLLER ) ) ;		
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) {
				onSuccess();
			}
		}
		/*var errorPage	=	"../../eCommon/jsp/MstCodeError.jsp";
		var blankObj	=	null;
		blankObject		=	f_query_add_mod.getBlankField( fields, names, messageFrame,errorPage);
		if(blankObject==null) {
			eval(formApply(formObj,PH_CONTROLLER));
			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) {
				onSuccess();
			}
		}
		else{
			blankObject.focus();
		}*/
	}
	else if( mode == "2" ){
		var frmobj = f_query_add_mod.document.formLabelText;
		var fields = new Array (frmobj.label_text_id,frmobj.label_text_type,frmobj.label_text_1,frmobj.label_text_2);
		var text=getLabel("Common.Text.label","Common");
		var text1=text+"1";
		var text2=text+"2";
		var names = new Array ( getLabel("Common.identification.label","Common"),getLabel("Common.type.label","Common"),getLabel("Common.description.label","Common"),text2);
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			GLlabel_text_id		=  f_query_add_mod.document.formLabelText.label_text_id.value;
			eval( formApply( frmobj,PH_CONTROLLER ) ) ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) {
				onSuccess();
			}
		}
	}//modify if
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function onSuccess() {
	var mode = f_query_add_mod.document.formLabelText.mode.value;
	if( mode == MODE_INSERT ) {
		f_query_add_mod.document.formLabelText.reset();
		f_query_add_mod.document.formLabelText.label_text_id.focus();
		//formReset();
	}
	else if(mode == MODE_MODIFY ){
          f_query_add_mod.location.href="../../ePH/jsp/LabelTextAddModify.jsp?mode="+MODE_MODIFY+"&label_text_id="+GLlabel_text_id;	  
	}
}
/*******************  formReset()  ***********************************************/
/*function formReset () {
	var formObj = f_query_add_mod.document.formLabelText ;
	//clearL2List("f_query_add_mod.document");
	////////////////////////////////////////////////////////////
	var label_text_id=eval("formObj.label_text_id");
	var label_text_type=eval("formObj.label_text_type");
	var label_text_1=eval("formObj.label_text_1");
	var label_text_2=eval("formObj.label_text_2");
	var label_text_1_loc_lang=eval("formObj.label_text_1_loc_lang");
	var label_text_2_loc_lang=eval("formObj.label_text_2_loc_lang");
	var eff_status=eval("formObj.eff_status");
	//////////////////////////////////////////////////////////
	label_text_id.value="";
	label_text_type.value="";
	label_text_1.value= "";
	label_text_2.value="";
	label_text_1_loc_lang.value="";
	label_text_2_loc_lang.value="";
	eff_status.checked=true;
	///////////////////////////////////////////////////////////
	formObj.label_text_id.focus();

}*/

function toUpper(obj) {
	obj.value=obj.value.toUpperCase();
}

function Modify(obj) {
	var label_text_id=obj.cells[0].innerText;
	parent.f_query_add_mod.location.href="../../ePH/jsp/LabelTextAddModify.jsp?mode="+MODE_MODIFY+"&label_text_id="+label_text_id;
}

function reset(){
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("labeltextquerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}
	else if ( (url.indexOf("labeltextaddmodify")!=-1) ) {
		if(f_query_add_mod.document.formLabelText.mode.value == MODE_INSERT){
			f_query_add_mod.document.formLabelText.reset();
			//formReset() ;
		}
		else {
			f_query_add_mod.document.formLabelText.reset();
		}
	}
}
//In case of pressing Apply button from QueryCriteria page..the 'mode' would come null this is to avoid that 
function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;		
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("labeltextquery")==-1) )
		return true;
	else
		return false;
}
//function not to check for special char's onBlur in AddModify////////////////////////////
function LabelTextCheck(obj){
	if(!CheckChars(obj)){
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return false;
	}
}

//Function to control ampersand in description text on may/11/2010 for the incident number 20846 
function ChkChars(obj){
	var str=obj.value;
	var chk="&";
	for(var i=0; i<str.length; i++){
		if (chk==str.charAt(i)){
			alert("invalid string ");
			//obj.select();
			obj.focus();
			return;
		}
	}
}
