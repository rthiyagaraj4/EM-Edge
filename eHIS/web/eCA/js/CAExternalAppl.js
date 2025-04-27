function query()
{
	CAEx_Query.location.href='../../eCA/jsp/CAExternalApplResult.jsp';
}

function apply()

{
	//alert();
	if(CAEx_Query.document.ExternalApplSetupform.eff_status.checked==true)
	{
	CAEx_Query.document.ExternalApplSetupform.eff_status.value="E";
	}
	else
	{
		CAEx_Query.document.ExternalApplSetupform.eff_status.value="D";
	}

	var fields = new Array(CAEx_Query.document.ExternalApplSetupform.appl_id,CAEx_Query.document.ExternalApplSetupform.appl_name,CAEx_Query.document.ExternalApplSetupform.base_url);
    
	var names = new Array (getLabel("Common.identification.label",'common'),getLabel("Common.name.label",'common'),getLabel("Common.URL.label",'COMMON'));
	//if(CAEx_Query.checkFields(fields, names, messageFrame))
    var ExternalApplSetupform = CAEx_Query.document.ExternalApplSetupform.externalParamResult.value;
	 ExternalApplSetupform = ExternalApplSetupform.replace(/\s/g,'');
     CAEx_Query.document.ExternalApplSetupform.externalParamResult1.value=ExternalApplSetupform;
	if(CAEx_Query.checkFieldsofMst(fields, names, messageFrame))
	{
		CAEx_Query.document.forms[0].submit();
	}

}

function onSuccess()
{
	CAEx_Query.location.reload();

}

function reset()
{
	CAEx_Query.location.reload();
}
/*Below function is added by Channaveer B for External Application Function */
function callExternalList()
{
	var parameterName = document.getElementById("parameterName").value;
	var param_name = document.getElementById("param_list").value;
	var  new_value = parameterName+"="+param_name;
/*	var ext_value = ExternalApplSetupform.externalParamResult.value;
	if (ext_value != "" && ext_value.indexOf("&"+parameterName+"=") >= 0)
	{
		alert(ext_value.indexOf("&"+parameterName+"="));
		return false;
	}*/
	if(param_name !=null && param_name !="" && parameterName != null && parameterName != "" )
	{
        document.getElementById("externalParamResult").focus();
		if (ExternalApplSetupform.externalParamResult.value=="")
		{
//			 ExternalApplSetupform.externalParamResult.document.execCommand("paste","",new_value);
			 ExternalApplSetupform.externalParamResult.value = new_value;
		}else
		{
//			 ExternalApplSetupform.externalParamResult.document.execCommand("paste","",new_value+"&");
			 ExternalApplSetupform.externalParamResult.value = new_value+"&"+ExternalApplSetupform.externalParamResult.value;
		}
	   
		document.getElementById("parameterName").value = "";
		document.getElementById("param_list").value = "";
	}else{
           if(parameterName == "" || param_name != "")
		{
			alert(getMessage("PARAM_LIST_NOT_BLNK","CA"));
			document.getElementById("parameterName").focus();
		}
		else if(parameterName != "" || param_name == "")
		{
			alert(getMessage("PARAM_LIST_NOT_BLNK","CA"));
			document.getElementById("param_list").focus();
		}
	}
}
/*Ends Here*/

/*Below function is added by Channaveer B on 22/04/2010 for External Application Function */

function CheckForSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}
/*ends here*/
// Added By Channaveer B on 30/07/2010 
//called from External application setup to check Maxlength of a textarea .
function chkMaxLenForLongTest(textarea_name,maxLen)
{	
	if (maxLen == undefined || maxLen == null || maxLen == "")
	{
		maxLen = 3000;
	}
	
	var textArea	 = eval("document.forms[0]."+textarea_name);
	var val	 = textArea.value;
	var valLength	 = val.length;	
	if (parseInt(valLength)  > maxLen)
	{		
		var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
		msg = msg.replace("$","Constructed Parameter list");
		msg = msg.replace("#",maxLen);
		alert(msg);
		textArea.focus();
		return false;
	}
	
}
