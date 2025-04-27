function show() {
	//parent.parent.window.document.title = "Setup AlternativeID" ;
}
function blank(lab) {
	var error='';
	error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
	error = error.replace('$',lab);
	error = error + "<br>" ;

return error;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=14";
	plineFrame.location.href ="../../eCommon/html/blank.html";
}

function apply() {
	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var errors = "";
	var reason = f_query_add_mod.document.restrict_reinstate_patient_form.reason.value;
		
//	var fields = new Array ( f_query_add_mod.document.restrict_reinstate_patient_form.reason
//			       );	
			       
//	var names = new Array ( f_query_add_mod.getLabel('Common.reason.label','common'));	
	
	if(reason.length == 0){
		errors = errors +  blank(getLabel('Common.reason.label','common'));
	}
		
//		if (f_query_add_mod.checkFieldsofMst(fields, names, messageFrame)) 
		if(errors.length > 0){	
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;			
		}else{
			f_query_add_mod.document.restrict_reinstate_patient_form.submit();
		}	
}	

function reset() {
	f_query_add_mod.document.forms[0].reset() ; 
}

function onSuccess() {
	alert(getMessage("RECORD_INSERTED",'SM'));
	query(); 
	messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function trimCheck(inString) 
{
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) 
	{
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) 
		{
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}

function trimString(inString) 
{
	var outString;
	var startPos;
	var endPos;
	var ch;

	startPos = 0;
	ch = inString.charAt(startPos);
	while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) 
	{
		startPos++;
		ch = inString.charAt(startPos);
	}

	endPos = inString.length - 1;
	ch = inString.charAt(endPos);
	while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) 
	{
		endPos--;
		ch = inString.charAt(endPos);
	}

	outString = inString.substring(startPos, endPos + 1);

	return outString;
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

async function callAuditTrailScreen(){
	var dialogHeight= "180px";//modified on 30-10-2023
	var dialogWidth = "800px";
	var dialogTop	= "30px";
	var status = "no";
	var arguments	= "" ;			
	var patient = document.forms[0].patient_id.value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var jsp_name;
	jsp_name = "../../eMP/jsp/ViewRestrictReinstateAuditTrail.jsp?patient_id=" + patient;			
	retVal = await window.showModalDialog(jsp_name,arguments,features);
}

function maxLengthPaste(field,maxChars)
{
      event.returnValue=false;
      if((field.value.length +  window.clipboardData.getData("Text").length) > maxChars) {	 
	     var errors1 = getMessage('OBJ_CANNOT_EXCEED','Common');
		errors1 = errors1.replace('$', maxChars);		  
		  alert(errors1);  
	    return false;
      }
      event.returnValue=true;
}

