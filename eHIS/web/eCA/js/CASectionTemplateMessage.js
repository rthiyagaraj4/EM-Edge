/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
30/09/2013	IN043577		Vijayakumar K		Alpha-CA-by entering special Characters at Hint message in Section template getting Internal Server Error 
28/05/2015	IN054269		Vijayakumar K		28/05/2015	Dinesh T	GHL-SCF-894 [IN:054269] 
--------------------------------------------------------------------------------------------------------------------
*/
function apply()
{

}
function clearform()
{
	document.CASectionTemplateMessageAddModifyForm.reset();
}
function charTextarea(elem,limit)
{
	if(elem.value.length>limit)
	{
		elem.value=elem.value.substring(0,limit);
		var msg = getMessage("ONLY_MAX_CHARS","CA");
		msg =msg.replace('$$',limit);
		alert(msg);
	}
}
function CheckForSpecCharsNoCaps(event){
	//IN054269 starts
    //var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*%~!$%^&(){}[]?/.,;:|>=+- ';
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_@<#\\*%~!$%^&(){}[]?/.,;:|>=+- ";
	//IN054269 ends
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}
function OnSelection()
{

	var rowCount = document.CASectionTemplateMessageListsForm.rowCount.value;
	var temp = 0;
	for(var i=0; i<rowCount; i++){
		var object = eval(parent.Result.document.getElementById("chk_"+i));
		
		if(object.checked ==true)
		{
			var OptnVal = object.value;
			temp++;
		}
	}

	if(temp > 1)
	{
		var mesg = getMessage("ONLY_MAX_CHARS","CA");
		alert(mesg);
	}
   
}
function RecordVal()
{
	var label_desc = document.CASectionTemplateMessageAddModifyForm.MessageVal.value;
	var label_type = document.CASectionTemplateMessageAddModifyForm.label_type.value;
    var comp_id    = document.CASectionTemplateMessageAddModifyForm.comp_id.value;
	document.CASectionTemplateMessageAddModifyForm.label_desc.value=
	parent.AddModify.document.CASectionTemplateMessageAddModifyForm.submit();
	
				
}
//IN043577 starts
function CheckForSpecialCharactersOnBlur(objmsg)
{
	var val=objmsg.value;
	var specialchar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	var charval = "";
	
	for(i=0;i<val.length;i++)
	{
     charval = val.charAt(i);
	 if (specialchar.indexOf(charval) == -1)
	 {
		var msg = getMessage("CA_SPCL_CHAR_NOT_ALLOWED","CA");
		alert(msg);
		objmsg.focus();
		return;
	 }
	}
}

function CheckForSpecialCharactersOnKeyPress(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

//IN043577 ends
