/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	    Edit History      		Name        		             Rev.Date		        Rev.Name		          Description
------------------------------------------------------------------------------------------------------------------------------------------------------
21/04/2023	IN061903			Srinivasa			                  21/04/2023		Ramesh G		           ML-BRU-CRF-0605.4		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";
function create() {
	f_query_add_mod.location.href = "../../eCA/jsp/CAReasonCodeAddModifyReason.jsp?mode=insert&function_id="+function_id ;
	
}

function query() {  
	f_query_add_mod.location.href='../../eCA/jsp/CAReasonCodeQueryCriteria.jsp?function_id='+function_id ;
}

function apply() 
{
	
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var mode = f_query_add_mod.document.forms[0].mode
	var fields = new Array (f_query_add_mod.document.reasonCode_form.reason_code,
						             	f_query_add_mod.document.reasonCode_form.reason_short_desc,
						             	f_query_add_mod.document.reasonCode_form.reason_desc );

	var names = new Array ( getLabel("Common.code.label","COMMON"),
							              getLabel("Common.description.label","COMMON"),
							              getLabel("eOR.ReasonText.label","OR_LABEL")
							              );

	if(f_query_add_mod.document.reasonCode_form != null)
	 { 
		
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{		
			if(mode != null)
			{
				if(mode.value=='update')
				{ 
					
					f_query_add_mod.document.forms[0].reason_code1.value= f_query_add_mod.document.forms[0].reason_code.value
					f_query_add_mod.document.forms[0].reason_desc1.value= f_query_add_mod.document.forms[0].reason_short_desc.value
					f_query_add_mod.document.forms[0].reason_description1.value= f_query_add_mod.document.forms[0].reason_desc.value					
				}else{
					f_query_add_mod.document.forms[0].reason_code1.value= f_query_add_mod.document.forms[0].reason_code.value
					f_query_add_mod.document.forms[0].reason_desc1.value= f_query_add_mod.document.forms[0].reason_short_desc.value
					f_query_add_mod.document.forms[0].reason_description1.value= f_query_add_mod.document.forms[0].reason_desc.value		
				}
			}
			if(f_query_add_mod.document.forms[0].eff_status.checked)
				f_query_add_mod.document.forms[0].eff_status1.value="E";
			else
				f_query_add_mod.document.forms[0].eff_status1.value="D"; 
			
			if(f_query_add_mod.document.forms[0].reason_desc.value.length > 200) {
				var msg = getMessage("MAX_TEXT_REASON_DESC","CA");

				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				return false
			}
		   f_query_add_mod.document.reasonCode_form.submit();
		}
	 }
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/CAReasonCodeAddModifyReason.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{   
		f_query_add_mod.location.href='../../eCA/jsp/CAReasonCodeAddModifyReason.jsp?mode=update&reason_code='+f_query_add_mod.document.forms[0].reason_code.value;
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}

function formReset () {
	var formObj = f_query_add_mod.reason_code.document.reasonCode_form ;
	formObj.reason_code.value = "";
	formObj.reason_desc.value = "";
	formObj.reason_short_desc.value = "";

	for(var i=0;i<formObj1.length;i++) {
		if(formObj1[i].type == "checkbox") {
			formObj1[i].checked = false;
		}
	}

}

function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;

}

function reset(){
	if(f_query_add_mod.reason_code){
		if(f_query_add_mod.reason_code.document.forms[0].name == "reason_code"){
			f_query_add_mod.reason_code.document.reason_code.reset();
			//f_query_add_mod.reason_code_bottom.document.reason_code_ord_cat.reset();
		}
	}
	else if(f_query_add_mod.document.forms[0]!=null)
		f_query_add_mod.document.forms[0].reset();
	else{
			frames[0].location.reload();
			return false;
	}
}

function reset()
{
	if(f_query_add_mod.document.forms[0]!=null)
	f_query_add_mod.document.forms[0].reset();

}

function checkForMode(objCheck)
{
	var mode = document.forms[0].mode.value;
	
	if(mode == 'update')
	{
		
		if(objCheck.checked== true)
		{
			document.forms[0].eff_status1.value='Y'
		}
		else
		{
			document.forms[0].eff_status1.value='N'
		}
	}
}

function CheckMaxLength(obj,max) {
	if(obj.value.length >= max) {
		alert(getMessage("MAX_TEXT_REASON_DESC","CA"));
		return false;
	} else return true;
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
function ValidateTextBox() { 
	var formObj = f_query_add_mod.reasonCode_form ;
    if (formObj.reason_code.value.trim() == "") {
        return false;
    }
};

