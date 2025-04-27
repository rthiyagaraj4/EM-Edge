function getPatientID(fieldID1, fieldID2)
{ 
	var patientid = PatientSearch('','','','','','','Y','','','VIEW');
	
	if(patientid != null)
	{
		document.getElementById(fieldID1).value = patientid;
		if(fieldID2 != null && fieldID2 != '')
		{
			document.getElementById(fieldID2).value = patientid;
			document.getElementById(fieldID2).focus();
		}
		else
		{
			document.getElementById(fieldID1).focus();
		}
	}
}

function xhBeforeNow(obj, format)
{
	var locale = document.getElementById("locale").value;
	if(obj.value != "") 
	{
		if((!isBeforeNow(obj.value,format,localeName))) 	
		{
			if('MY' == format)
			{
				alert(getMessage("XH0105","xh"));
			}
			else
			{
				alert(getMessage("START_DATE_GREATER_SYSDATE","common"));
			}
			obj.value = "";
			obj.select();
			return false;
		}
	}
}

function xhAfterNow(obj, format)
{
	var locale = document.getElementById("locale").value;
	if(obj.value != "") 
	{
		if((isAfterNow(obj.value,format,localeName))) 	
		{
			alert(getMessage("XH0106","xh"));
			obj.value = "";
			obj.select();
			return false;
		}
	}
}

function fromToDateVal(fromObj, toObj, format, focusObj)
{
	var fromDate = fromObj.value;
	var toDate = toObj.value;
	var locale = document.getElementById("locale").value;
	
	if(fromDate == "" && (focusObj.name == fromObj.name))
	{
		return;
	}
	else if(toDate == "" && (focusObj.name == toObj.name))
	{
		return;
	}

	var isAfterN = isBeforeNow(focusObj.value, format, locale);
	if(!isAfterN)
	{
		var msg = getMessage("XH1010","xh");			
		alert(msg);
		focusObj.value = "";
		focusObj.focus();
		return;
	}

	if(fromDate != "" && toDate != "")
	{		
		var isBeforeD = isBefore(fromDate, toDate, format, locale);
		if(!isBeforeD)
		{
			if(focusObj.name == fromObj.name)
			{
				var msg = getMessage("XH0051","xh");
				msg = msg.replace("{1}", fromObj.label);
				msg = msg.replace("{2}", toObj.label);
				alert(msg);				
			}
			else
			{
				var msg = getMessage("XH0052","xh");
				msg = msg.replace("{1}", toObj.label);
				msg = msg.replace("{2}", fromObj.label);
				alert(msg);
			}
			focusObj.value = "";
			focusObj.focus();
			return;
		}
	}
}

function xhStartsWith(str, substr)
{
	return str.substring(0, substr.length) == substr;
}

function loadjscssfile(filename, filetype)
{
	if (filetype == "js") //if filename is a external JavaScript file
	{
		var fileref = document.createElement('script');
		fileref.setAttribute("type","text/javascript");
		fileref.setAttribute("src", filename);
	}
	else if (filetype == "css") //if filename is an external CSS file
	{
		var fileref = document.createElement("link");
		fileref.setAttribute("rel", "stylesheet");
		fileref.setAttribute("type", "text/css");
		fileref.setAttribute("href", filename);
	}
	
	if (typeof fileref != null)
	{		
		document.getElementsByTagName("head")[0].appendChild(fileref);		
	}
}

function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}

function isValidIPAddress(ipaddr)
{
    var re = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;
    if (re.test(ipaddr))
    {
        var parts = ipaddr.split(".");
        if (parseInt(parseFloat(parts[0])) == 0)
        {
            return false;
        }
        for (var i = 0; i < parts.length; i++)
        {
            if (parseInt(parseFloat(parts[i])) > 255)
            {
                return false;
            }
        }
        return true;
    }
    else
    {
        return false;
    }
}

function trimStr(str) 
{
    return str.replace(/^\s*/, "").replace(/\s*$/, "");
}