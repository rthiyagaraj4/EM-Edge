//************************************************************
var arrTabPages = new Array();
//************************************************************
function onPage(sel)
{
	if(sel==3)
	{
		for(y1=0;y1<arrTabPages.length;y1++)
		{
		arrTabPages[y1].className='XHTAB2';
		}

	}
    else{

	arrTabPages[sel].className='XHTAB1';
	for(y1=0;y1<arrTabPages.length;y1++)
	{

		if (y1!=sel)
		{
			arrTabPages[y1].className='XHTAB2';
		}

	}
}	

}
//************************************************************
function checkAttributeNull(element,attribute)
{
	
	var val = element.getAttribute(attribute) ;
	if ((val != null)&&(val != 'undefined')&&(val != '')&&(val != 'null'))
	{
		
		return val;
	}
	return('');
}
//************************************************************
function checkIpAddress(obj)
{
	var val = obj.value;
	if(val!=''){
	var ip = val.split(".");
	if (ip.length != 4)
	{
		alert(getMessage('XH1002','XH'));
      obj.value="" ;
		obj.focus();
		return false;
	}
	
	for (k=0;k<ip.length ;k++ )
	{
		if (!(parseInt(ip[k])<=255))
		{

			alert(getMessage('XH1002','XH'));
        obj.value="" ;
			obj.focus();
			return false;
		}
	}

	}
	

}
//**************************************************************
//************************************************************
function check(obj)
{
	var val = obj.value;
	
	if (isNaN(val))
	{
		alert(getMessage('INVALID_NUMBER_FORMAT'));
    obj.value="" ;
		obj.focus();
		return false;
	}
	
}
//************************************************************
function checkNumber(obj)
{
	var val = obj.value;
	
	if (isNaN(val))
	{
		alert(getMessage('XH1028','XH'));
    obj.value="" ;
		obj.focus();
		return false;
	}
	
}

//*************************************************************
function checkValid(obj)
{
var val = obj.value;
if (isNaN(val))
	{
		alert(getMessage('XH1015','XH'));
    obj.value="";
		obj.focus();
		return false;
	}


}





//************************************************************
function eachMandatory(obj)
{
	try
	{  alert("each1");
		if (obj.MANDATORY_YN == 'Y')
		{  alert("each2");
			var val = checkAttributeNull(obj,'value')
			if (val == '')
			{
				return(getMessage('MANDATORY_YN',checkAttributeNull(obj,'title'))+'<br>');
			}

		}
	}
	catch(e)
	{
	}
	return(true);
}
//************************************************************

function checkMandatoryAllElements(frmObj) 
{
	alert("chck mandat1");
	var arrObj = frmObj.elements;
	var returnArr = new Array();
	for(var k=0;k<arrObj.length;k++) 
	{
		alert("chck mandat2");
		alert(arrObj[k]);
		result = eachMandatory(arrObj[k]);
	
		if (result != true)
		{
			returnArr.push(result);

		}
		
	}
	
	return(returnArr);
}
//************************************************************
//FUNCTION TO CHECK THE MANDATORY VALUES 

function checkMandatoryForAddModify(frmObj) 
{	
	
	var outObj = frmObj.out_use.value;
	var inObj = frmObj.in_use.value;

   	alert("outObj :"+outObj);
	alert("inObj  :"+inObj);
    
	var returnArr;

	if(((outObj=='N')&&(inObj=='N'))||((outObj=='N')&&(inObj=='Y')))
    {  
		returnArr=new Array();
		alert("NN");
		var appl_value = frmObj.appl_name.value;
		if ((appl_value == null)||(appl_value==" ")||(appl_value==""))
		{
			returnArr.push("Application is Mandatory!!!!!");
		}
	}
	
	if(((outObj=='Y')&&(inObj=='N'))||((outObj=='Y')&&(inObj=='Y')))
    {  
		returnArr=new Array();
		alert("YN");
		var appl_value = frmObj.appl_name.value;
		if ((appl_value == null)||(appl_value==" ")||(appl_value==""))
		{
			returnArr.push("Application is Mandatory!!!!!");
		}
		var facility_value = frmObj.facility.value;
		if ((facility_value == null)||(facility_value==" ")||(facility_value==""))
		{
			returnArr.push("Facility is Mandatory!!!!!");
		}
	}
	
return returnArr;
}
//************************************************************