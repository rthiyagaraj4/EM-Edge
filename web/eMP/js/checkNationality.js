 function callPrev(series)
    {
        document.location.href="../../eMP/jsp/checkNationality.jsp?step=first&series="+series
    }
function checkBoxClicked()
{
			
	if ( document.getElementById("nat_holder_yn").checked == true )
	{
		document.getElementById("nat_id_no").readOnly = false;
		document.getElementById("nat_holder_yn").checked = true;
		document.getElementById("nat_id_no").focus();
	}
	else
	{
		document.getElementById("nat_holder_yn").checked = false;
		document.getElementById("nat_id_no").readOnly = true;
		document.getElementById("nat_id_no").value = '';
	}
}
function checkNatNo(nat_valid_yn)
{
	if ( document.getElementById("nat_holder_yn").checked == true )
	{
		var bool =checkField(document.getElementById("nat_id_no"),document.getElementById("nat_id_prompt").value)
		
		if(!bool)   return false;
		else if (  nat_valid_yn =="Y")
		{
			if ( document.getElementById("nat_id_no").value.length == document.getElementById("nat_id_no").maxLength )
				return true;
			else
			{

				  var val = getMessage("NAT_ID_CHARS",'MP'); 
				  val = val.replace("@",document.getElementById("nat_id_no").maxLength)
				  val = val.replace("#",document.getElementById("nat_id_prompt").value)
				  alert(val)

				  document.getElementById("nat_id_no").focus();
				  return false;
			}
		}
		else
		{
			if(nat_valid_yn =="N")  return true;
		}
			
	} //End of the Main IF
	else
	{
		//parent.window.returnValue = 'G';
		//parent.window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = 'G';
    
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();
	}

}  // End of the Function

function submitAll(nat_valid_yn)
{
	var continue_yn = true

	continue_yn =  checkNatNo(nat_valid_yn)
	if(continue_yn)
	{
		//document.nat_form.submit();
		 var params = "?";
		for(var i=0;i<document.nat_form.elements.length;i++)
		{
			params+=document.nat_form.elements[i].name+"="+document.nat_form.elements[i].value+"&"
		}
		params += "prompt="
		//alert("params "+params);
		location.href ="../../eMP/jsp/checkNationality.jsp"+params
	}

}

function CancelModal()
{
	//parent.window.returnValue='G';
	//parent.window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = 'G';
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}

function checkValues()  {
	var ar = window.dialogArguments;
	var msgFrame = ar[0];

	var HTMLVal = new String();
	HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/checkNationality.jsp?step=second&id="+document.getElementById("nat_id_no").value+"'></body></html>";
	msgFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	msgFrame.document.form1.submit();
}

function CheckForCharsNatID(event){
    var strCheck = '0123456789X';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckForAlphaCharsNatID(event){

	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

