function reset()
{
	search_frame.location.reload();
}	



function trimString(sInString)
{
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function putdeci(object)
	{
		
		if(object.value!='')
		{
		var decimal=document.forms[0].noofdecimal.value;
		putDecimal(object,17,decimal);
		}
	}


function close_window()
	{
		parent.window.returnValue="failure";
		parent.window.close();
	}
