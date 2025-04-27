
function dispText(obj)
{
	var code =obj.value;
	
	if(code=='B')
	{
		document.getElementById("disptext").style.display='inline';
	}
	else
	{
		document.getElementById("disptext").style.display='none';
	}

}
function apply()
{
	f_query_add_mod.document.specialityParamaddmodifyForm.submit();

}
function reset()
{
	 f_query_add_mod.location.reload();
}

function onSuccess()
{

	f_query_add_mod.location.reload();
}
/*
	Modified By : Sridhar Reddy
	Date : 60/01/2010
	CRF : PMG20089-CRF-0690.1
*/
function defaultOne(obj)
{
	
	if (trimString(obj.value) == "" || trimString(obj.value) == 0)
	{
		obj.value =1;
	}	
	obj.value  = trimString(obj.value);
	var objVal =  obj.value;
	strCheck = '1234567890';
	for (var i=0;i<obj.value.length ;i++ )
	{
		if (strCheck.indexOf(objVal.charAt(i)) == -1) 
		{
			alert(getMessage("NUM_ALLOWED","CA"));
			obj.focus();
			return false;
		}
	}
	if (obj.value.charAt(0) == "0")
	{
		obj.value = obj.value.substring(1,obj.value.length);				
	}			

}

function allowValidNumberLocal(fld, e, maxInt, deci)
{
	if ((event.keyCode < 48 || event.keyCode > 57))
			return false;		
	
	return true;   
}
/*
Modified End
*/
