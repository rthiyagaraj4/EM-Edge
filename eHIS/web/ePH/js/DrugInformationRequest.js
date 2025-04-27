  var function_id = "" ;
var result1 = false ;
var message = "" ;
var flag = "" ;
var bean_id="";
var bean_name="";
var gloabl_code="";
var gloabl_description="";



function query() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugInformationRequestQueryCriteria.jsp" ;
}



function reset() {
	var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if ( (url.indexOf("queryresult.jsp")!=-1) ||  (url.indexOf("blank")!=-1) )
		 return ;
	f_query_add_mod.document.forms[0].reset(); 
	messageFrame.document.href ='../../eCommon/jsp/MstCodeError.jsp' ;
}


function create() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugInformationRequestAddmodify.jsp?mode="+MODE_INSERT;
}


function apply() {
if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	var mode = f_query_add_mod.document.frmdruginformationrequestAddModify.mode.value;
	
	if(mode == MODE_MODIFY || mode == '2'){
		applymodify();
		return ;
	}
	if( mode == MODE_INSERT || mode =='1' ) {
		var formObj = f_query_add_mod.document.frmdruginformationrequestAddModify ;
		
		var fields = new Array ( formObj.code ,formObj.description,formObj.display_sequence_no);

var names= new Array (getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),getLabel("ePH.DisplaySequence.label","PH"));

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			
			gloabl_code = formObj.code.value;
			gloabl_description = formObj.description.value;

			eval(formApply( f_query_add_mod.document.frmdruginformationrequestAddModify,PH_CONTROLLER ));

			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
			if(result1) {
				onSuccess();		
			}
		}
	}
}


function onSuccess() {
	f_query_add_mod.document.frmdruginformationrequestAddModify.reset();

//	   f_query_add_mod.document.document_type.reset();
 }

/******************************************************************************/
function assignResult( _result, _message, _flag, _invalidCode ) {
    result1 = _result ;
    message  = _message ;
    flag = _flag ;
    invalidCode = _invalidCode ;
}
/***************************************************************************/



function DurationValidate(obj){
	if(obj.value!="" && obj!=null)	{
		if(parseInt(document.dispense_rules.max_durn_for_disp.value)<parseInt(obj.value)){
			var message=getMessage("PH_MAX_DISP_DURN_PARAM","PH");
			obj.value="";
			obj.focus();
			}
			else{
			var message="";
			}
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
	}
}
function Modify(obj){

}

//**************************************************************************/
 function chkzero(obj)
 {
 if(obj.value =="0" || obj.value=="")
	 {
	 alert(getMessage("PH_NOT_BLANK_ZERO","PH"));
	 obj.focus();
 }
 }

 function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

if ((url.indexOf("queryresult.jsp")==-1) &&(url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}


/***************************delete record********************************/
function deleterecord(){
	//alert("in delete");
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID_DELETE","PH");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObj = f_query_add_mod.document.frmdruginformationrequestAddModify ;
	var mode = formObj.mode.value ;
	//alert("mode="+mode);
	
	if(mode == '1' ){//no action
//		var message  = getOrMessage("NOT_VALID_DELETE"); 
		var message  = getMessage("NOT_VALID_DELETE","PH");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
		
	}else
		formObj.mode.value = "0"; //set mode to delete
	//alert("formObj.mode.value="+formObj.mode.value);
	
	eval(formApply(formObj,PH_CONTROLLER ));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
	if(result1) {
		onSuccess();		
	}

	}


	
function applymodify(){

	var formObj = f_query_add_mod.document.frmdruginformationrequestAddModify ;
	
	var fields = new Array ( formObj.code ,formObj.description,formObj.display_sequence_no);
	var names= new Array (getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),getLabel("ePH.DisplaySequence.label","PH"));
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		
		gloabl_code = formObj.code.value;
		gloabl_description = formObj.description.value;

	var temp_seq_no = formObj.temp_seq_no.value;
		if(temp_seq_no == formObj.display_sequence_no.value)
			formObj.dup_chk.value = 'N'
		else
			formObj.dup_chk.value = 'Y'
//alert(formObj.dup_chk.value);
	
	  if(formObj.eff_status.checked==true)
		 	 formObj.eff_status.value	= "E";
		 else
			 formObj.eff_status.value	= "D";
	
	//alert(formObj.sys_def.checked);

	 if(formObj.sys_def.checked==true)
		 	 formObj.sys_def.value	= "Y";
		 else
			 formObj.sys_def.value	= "N";

	eval(formApply( f_query_add_mod.document.frmdruginformationrequestAddModify,PH_CONTROLLER ));

		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
		if(result1) {
		//	onSuccess();
		f_query_add_mod.location.reload();		
		}
	}
}
