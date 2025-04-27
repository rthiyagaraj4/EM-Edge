function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/ResearchPatientMaster.jsp?mode=insert';
}

function apply()
{
	if(f_query_add_mod.document.ResearchPatientMasterfrm != null)
	{
	var fields = new Array (f_query_add_mod.document.ResearchPatientMasterfrm.research_categ_id,
	f_query_add_mod.document.ResearchPatientMasterfrm.research_categ_desc
	);

	var names = new Array ( getLabel("eCA.ResearchCategoryID.label",'CA'),getLabel("eCA.ResearchCategoryDescription.label",'CA'));

	
	if(( f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) )
	{

		f_query_add_mod.document.ResearchPatientMasterfrm.submit();
	}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}


function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/ResearchPatientMasterQuery.jsp';
}

function onSuccess()
{
	f_query_add_mod.location.reload();
}

function reset()
{
	//f_query_add_mod.location.reload();
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
}

//Functions for the file ResearchPatientMaster.jsp-start
 
function assign_desc()
{
	document.forms[0].research_categ_desc1.value = document.forms[0].research_categ_desc.value;
}

function AssignCheck(obj)
{
	if(obj.checked)
		document.forms[0].eff_status.value="E";
	else
		document.forms[0].eff_status.value="D";
}

function CheckSpecChar(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}


//Functions for the file ResearchPatientMaster.jsp-end
