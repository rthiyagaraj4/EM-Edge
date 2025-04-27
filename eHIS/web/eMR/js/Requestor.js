  function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1)&&(url.indexOf("result")==-1) )
		
	return true;
	else
		return false;
}

function create() 
{
	f_query_add_mod.location.href = "../../eMR/jsp/RequestorFrames.jsp" ;
	dummyFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp";
} 

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eMR/jsp/RequestorQueryCriteria.jsp";
	dummyFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp";
}

function apply()
{	
	if (!(checkIsValidForProceed()) )
    {
		
		message  = getMessage("APPLY_NOT_VALID",'MR');
		
		dummyFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
    }

	if(parent.frames[2].frames[1].frames[0].document.Requestor.requestor_country)
	{
		if(parent.frames[2].frames[1].frames[0].document.Requestor.requestor_country.value == "")
			parent.frames[2].frames[1].frames[0].document.Requestor.req_country_code.value="";
	}

	if(parent.frames[2].frames[1].frames[0].document.Requestor.r_region_code)
	{
		if(parent.frames[2].frames[1].frames[0].document.Requestor.r_region_code.value == "")
			parent.frames[2].frames[1].frames[0].document.Requestor.r_region.value="";
	}

	if(parent.frames[2].frames[1].frames[0].document.Requestor.r_area_code)
	{
		if(parent.frames[2].frames[1].frames[0].document.Requestor.r_area_code.value == "")
			parent.frames[2].frames[1].frames[0].document.Requestor.r_area.value="";
	}

	if(parent.frames[2].frames[1].frames[0].document.Requestor.r_town_code)
	{
		if(parent.frames[2].frames[1].frames[0].document.Requestor.r_town_code.value == "")
			parent.frames[2].frames[1].frames[0].document.Requestor.r_town.value="";
	}

	if(parent.frames[2].frames[1].frames[0].document.Requestor.r_postal_code1)
	{
		if(parent.frames[2].frames[1].frames[0].document.Requestor.r_postal_code1.value == "")
			parent.frames[2].frames[1].frames[0].document.Requestor.r_postal_code.value="";
	}


	//alert(parent.frames[2].frames[1].frames[0].document.Requestor.r_postal_code.value);
	//alert(parent.frames[2].frames[1].frames[0].document.Requestor.r_postal_code1.value);

	 

	var fields = new Array (parent.frames[2].frames[1].frames[0].document.Requestor.requestor_code,
					parent.frames[2].frames[1].frames[0].document.Requestor.long_desc,
					parent.frames[2].frames[1].frames[0].document.Requestor.short_desc,
					parent.frames[2].frames[1].frames[0].document.Requestor.requestor_type
				);
	var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),
		getLabel("Common.shortdescription.label","Common"),getLabel("Common.INDICATOR.label","Common"));
	var field = new Array (	parent.frames[2].frames[1].frames[0].document.Requestor.requestor_code,
	parent.frames[2].frames[1].frames[0].document.Requestor.long_desc,
	parent.frames[2].frames[1].frames[0].document.Requestor.short_desc,
	parent.frames[2].frames[1].frames[0].document.Requestor.requestor_type);
	var name = new Array (getLabel("Common.code.label","Common"));
		if(parent.frames[2].frames[1].frames[0].checkFieldsofMst( fields, names, dummyFrame)) 
		{
			if (SpecialCharCheck (field,name,dummyFrame,'M','MstCodeError.jsp'))
			{
				for(var i=0; i<parent.frames[2].frames[1].frames[0].document.Requestor.length;i++)
				{
					parent.frames[2].frames[1].frames[0].document.Requestor.elements[i].disabled = false;
				}

				parent.frames[2].frames[1].frames[0].document.Requestor.submit();
			}
		}
}
function SpecialCharCheck( fields, names, dummyFrame,disp_type,error_jsp)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(CheckChars(fields[i])) {
		}
		else{
			if (disp_type=="A")
			{
				errors += getMessage('CANNOT_BE_SPECIAL_CHAR','common');
				errors = errors.replace('APP-002452','APP-002452'+ names[i]);
			}
			else if(disp_type=="M")
			{
				errors += getMessage('CANNOT_BE_SPECIAL_CHAR','common');
				errors = errors.replace('APP-002452','APP-002452'+ names[i]);
			}
		}
	}
	if ( errors.length != 0 ) {
		var loc_route = error_jsp+"?err_num="+errors;
		if (disp_type=="M")dummyFrame.document.location.href=loc_route;
		else if (disp_type=="A")alert(errors);
		return false ;
	}
	return true ;
}
    
function CheckChars(Obj)
{
	var str = Obj.value;
	var specCharsExist = true;
	for (u=0;u<str.length;u++){
		if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==42) ||(str.charCodeAt(u)==43) || (str.charCodeAt(u)==32) || (str.charCodeAt(u)==45));
		else{
			specCharsExist = false;
			break;
		}
	}
	return specCharsExist;
}
function onSuccess() 
{

//parent.parent.frames[1].frames[0].location.href=
	//parent.parent.frames[1].frames[0].location.reload();
	frames[1].location.reload();

}

function reset() 
	
{
	var loc=frames[2].document.forms[0]

	if (loc!=null )
	{
			f_query_add_mod.document.forms[0].reset();
			
	}
	else  if(loc==null)
	{
		f_query_add_mod.location.reload();
		
	}
	dummyFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp";
}




//added

function foc()
{
	document.Requestor.requestor_code.focus();
}
function ValidString(event)
{
	if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)))
	{
		return true
	}
	else
	{	
		return false
	}
}function effcheck()
{
	if(document.Requestor.requestor_status.checked)
	{
		document.Requestor.requestor_status.value="E";
	}
	else
	{
		document.Requestor.requestor_status.value="D";
	}
}
async function searchCountry(obj,target)
{
var retVal =    new String();
var argumentArray  = new Array() ;
var dataNameArray  = new Array() ;
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;
var tit="";				

var localeName = document.forms[0].locale.value;

if(obj.name=="contry_code" || obj.name=="requestor_country")
{
	if(target.name=="requestor_country")
	{
		tit=getLabel("Common.country.label","Common");
		sql=" Select country_code code, long_name description from MP_COUNTRY_LANG_VW where language_id= '"+localeName+"' and eff_status='E' and upper(country_code) like upper(?) and upper(short_name) like upper(?) and eff_status = 'E'";
	}
}
argumentArray[0] = sql;
argumentArray[1] = dataNameArray ;
argumentArray[2] = dataValueArray ;
argumentArray[3] = dataTypeArray ;
argumentArray[4] = "1,2";
argumentArray[5] = target.value;
argumentArray[6] = DESC_LINK  ;
argumentArray[7] = DESC_CODE ;
retVal = await CommonLookup( tit, argumentArray );
if(retVal != null && retVal != "" )
{
	var ret1=unescape(retVal);
	arr=ret1.split(",");
	target.value=arr[1];
	if(target.name == 'requestor_country')
	document.forms[0].requestor_country.value= arr[1];
	document.forms[0].req_country_code.value=arr[0];
}
else
{
	target.value='';
}
}

/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
function ReqTypeValue()
{
	if(document.forms[0].function_name.value == "modify")
	{
		var ReqTypeValue	= document.forms[0].indicators.value;
		for(var i=0;i<document.forms[0].requestor_type.options.length;i++ )
		{
			if(document.forms[0].requestor_type.options[i].value == ReqTypeValue)
				document.forms[0].requestor_type.options[i].selected=true;
		}
	}
}
function CheckForSpecCharsInReq(event){ 
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
/*End ML-MMOH-CRF-0707*/
