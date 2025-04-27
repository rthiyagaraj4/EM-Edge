// ---  Author  Arvind Singh Pal Created on 4/9/2009 --%>

function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AlertCategAddModify.jsp?mode=insert';
}

function apply()
{
if(f_query_add_mod.document.AlertCategForm != null)	
	{
		var fields = new Array (f_query_add_mod.document.AlertCategForm.alert_categ_code,
		f_query_add_mod.document.AlertCategForm.alert_categ_desc);

	var names = new Array ( getLabel("eCA.AlertCategoryCode.label",'CA'),getLabel("eCA.AlertCategoryDescription.label",'common'));
	if(( f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) )
		{			

			f_query_add_mod.document.AlertCategForm.submit();			
		}
	}
else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		return false;
	}
}

function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/AlertCategoryQuery.jsp';
}

function onSuccess()
{

f_query_add_mod.location.reload();
}

function reset()
{
	if(f_query_add_mod.document.forms[0] != null)
		f_query_add_mod.document.forms[0].reset();
}
function CheckForSpecCharsWithSpaceBlur(ObjText)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

function resetValues()
{
   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}

function checkSpeciality(spl)
{
	
	if(spl.name=='speciality_desc')
	{
		var target  = document.forms[0].speciality_desc;
		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			checkSpl();
		}
	}
	else if(spl.name=='specialty_desc_search')
	{		
		checkSpl();
	}
}






