function create()
{
	f_query_add_mod.location.href = "../../eCA/jsp/PractSpecialityFrameSet.jsp";
}
function apply()
{
	if(f_query_add_mod.specialtySearch!=null)
	{
	if(f_query_add_mod.specialtySearch.specialtySearchForm.specialtySearch.value=="")
	{
			var error1 = getMessage("SHOULD_NOT_BE_BLANK","common");
			var label=getLabel("eCA.SpecialityDesc.label",'CA');
			error=error1.replace('{1}',label);
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=";		
	}
	else
		f_query_add_mod.SpecialtyRelationCode.document.forms[0].submit();
	}
	else
	{
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}

function onSuccess()
{
	f_query_add_mod.specialtySearch.location.reload();	
	f_query_add_mod.SpecialtyRelationCode.location.href ="../../eCommon/html/blank.html"
}

function reset()
{
	f_query_add_mod.specialtySearch.location.reload();
	f_query_add_mod.SpecialtyRelationCode.location.href ="../../eCommon/html/blank.html";
}

function getValue()
{
	if(parent.specialtySearch.specialtySearchForm.specialtySearch.value=="")
	{
		parent.SpecialtyRelationCode.location.href ="../../eCommon/html/blank.html";
	}
	else
	{
		parent.SpecialtyRelationCode.location.href ="../../eCA/jsp/PractSpecialityRelationShipCode.jsp?specialty_code="+document.forms[0].specialtySearch.value;
	}
}


function CheckForSpecCharsWithSpaceBlur(ObjText)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}




function getSpecialty(specialtyObject)
{
	if(specialtyObject.name=='spec_name')
	{
		var target  = document.forms[0].spec_name;		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			getSpecialtyWindow();
		}
	}
	else if(specialtyObject.name=='spec_desc_search')
	{	
		getSpecialtyWindow();
	}
}
async function getSpecialtyWindow()
{
		parent.SpecialtyRelationCode.location.href	= "../../eCommon/html/blank.html";
		specialtySearchForm.specialtySearch.disabled = true ;
		var target = "";
		var i = 0;
		var retVal			=  new String();
		
		var search_desc	= "";
		var title			= getLabel('Common.speciality.label','COMMON');
		var target=document.forms[0].spec_name;
		var sql = "SELECT SPECIALITY_CODE code, LONG_DESC description  FROM AM_SPECIALITY WHERE EFF_STATUS='E' and upper( SPECIALITY_CODE) like upper(?) and  upper( LONG_DESC) like upper(?)"
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] =target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retArray != null && retArray !="")	
		{
			document.forms[0].spec_name.value = arr[1];
			document.forms[0].specialtySearch.value = arr[0];
		}
		else
		{
			document.forms[0].spec_name.value = '';
			document.forms[0].specialtySearch.value = ''
		}
}
