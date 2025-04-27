//*************************************************************************************************
// Function apply()
//**************************************************************************************************
function apply()
{ 
	var fields = new Array ( f_query_add_mod.document.forms[0].dbConnStr,
								f_query_add_mod.document.forms[0].idle_time) ;

	var names = new Array ( getLabel("eXH.DBConnectString.Label","XH"),
                            getLabel("eXH.IdleTime.Label","XH"));

	if(!window.f_query_add_mod.checkFields( fields, names, messageFrame))
	{ 
	} 
	else
	{
		window.f_query_add_mod.document.forms[0].submit();
	}

	//window.commontoolbarFrame.document.location.reload();
	
	window.parent.commontoolbarFrame.document.location.reload();
}

//******************************************************************************************************
// Function reset()
//*******************************************************************************************************
function reset() 
{
	if(window.f_query_add_mod.document.forms[0])
	{
		window.f_query_add_mod.document.forms[0].reset();
	}
}
//**********************************************************************************************************

// Function to change the value of the selected check box
function validatecheckbox(obj)
{	
	if(obj.checked==true)	obj.value="Y";		
	else	obj.value="N";		
}

// Function checks for a max of 2 digits after decimal and number format
function IsDecimal(obj)
{		
	var decimalRE = "^(\\+|-)?([0-9][0-9]{0,4})?(\\.[0-9]{1,2})?$";
	var valid=false;
	if(obj.value.match(decimalRE) != null)
	{
		valid=true;
	}
	if(!valid)
	{
		var index=obj.value.lastIndexOf(".");
		if(index != -1)
		{
			count=obj.value.substring(index+1);			
			if(count.length > 2)
			{
				msg=getMessage('XH0051','XH');
				msg=msg.replace('{1}',getLabel("eXH.Precision.Label","XH"));
				msg=msg.replace('{2}','2');
				alert(msg);
			}
			else
				alert(getMessage('INVALID_NUMBER_FORMAT','COMMON'));
		}	  
		else
		{
			alert(getMessage('INVALID_NUMBER_FORMAT','COMMON'));
		}
		obj.focus();
	}
}

// Used to control the field length of temporary purge interval incase decimal is not used.
// Function called on each key press for this field.
function checkMaxLength(obj)
{
	var keyPressed = event.keyCode;
	var size = obj.value.length;
	var index = obj.value.indexOf(".");

	if(index == -1 && size == 3 && keyPressed != 46)
	{
		obj.maxLength=3;
	}
	else obj.maxLength=6;
}

//function to check value greater than zero
function isValGreaterThanZero(obj)
{
	if(obj.value <= 0)
	{
		alert(getMessage("INVALID_MAX_NUMBER","COMMON"));
		obj.focus();
	}
}

function IsNumeric(obj)
{	
	sText = obj.value
	
	var ValidChars = "0123456789";
	var isNumber = true;
	var Char;

	for (i = 0; i < sText.length && isNumber == true; i++) 
	{ 
		Char = sText.charAt(i); 
		if (ValidChars.indexOf(Char) == -1) 
		{
			isNumber = false;
			if(Char == '.')
			{
				msg = getMessage("XH0079","XH");
			}
			else if(obj.value <= 0)
			{
				alert(getMessage("INVALID_MAX_NUMBER","COMMON"));
				obj.focus();
			}
			else
			{
				msg = getMessage("INVALID_NUMBER_FORMAT","COMMON");
			}
			alert(msg);
			obj.focus();
			return;
		}
	}
	if((obj.value.length > 0) && (obj.value <= 0))
	{
		alert(getMessage("INVALID_MAX_NUMBER","COMMON"));
		obj.focus();
	}
	return isNumber;
}

function IsNumericMax(obj,minVal,maxVal)
{		
	sText = obj.value;	
	
	var ValidChars = "0123456789";
	var isNumber = true;
	var Char;

	for (i = 0; i < sText.length && isNumber == true; i++) 
	{ 
		Char = sText.charAt(i); 
		if (ValidChars.indexOf(Char) == -1) 
		{
			isNumber = false;
			if(Char == '.')
			{
				msg = getMessage("XH0079","XH");
			}
			else if(obj.value <= 0)
			{
				msg = getMessage("INVALID_MAX_NUMBER","COMMON");
			}
			else
			{
				msg = getMessage("INVALID_NUMBER_FORMAT","COMMON");
			}
			alert(msg);
			obj.focus();
			return;
		}
	}	
	if((parseInt(obj.value,10) < parseInt(minVal,10)) || obj.value == '')
	{		
		msg1 = getMessage("XH0078","XH");
		msg1 = msg1.replace("$","Value");
		msg1 = msg1.replace("#",minVal);
		obj.focus();
		alert(msg1);		
		return;
	}
	else if(maxVal != '' && (parseInt(obj.value,10) > parseInt(maxVal,10)))
	{		
		msg1 = getMessage("XH0051","XH");
		msg1 = msg1.replace("{1}","Value");
		msg1 = msg1.replace("{2}",maxVal);
		obj.focus();
		alert(msg1);		
		return;
	}
//	return isNumber;
}

function initFunc()
{
	parent.messageFrame.location.href="../../eXH/jsp/DisplayRefResult.jsp?message="+document.getElementById("resultMessage").value;
}


