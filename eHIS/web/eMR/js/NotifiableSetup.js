//Maheshwaran K created this page for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
function create() 
{
	f_query_add_mod.location.href = "../../eMR/jsp/AddModifyNotifiableSetup.jsp" ;
}

function edit()
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() 
{
	f_query_add_mod.location.href ="../../eMR/jsp/NotifiableSetupCriteria.jsp";
}
 function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function apply()
{
	if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array (
					f_query_add_mod.document.Notification_Setup_form.notify_code,
					f_query_add_mod.document.Notification_Setup_form.long_desc,
					f_query_add_mod.document.Notification_Setup_form.short_desc,
					f_query_add_mod.document.Notification_Setup_form.default_note_type_sel
					
				);

	var names = new Array ( 
					getLabel("Common.code.label","Common"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"),
					getLabel("Common.Default.label","Common")+" "+getLabel("Common.NoteType.label","Common")
				);

	var spFields = new Array (f_query_add_mod.document.Notification_Setup_form.notify_code);
	var spNames = new Array (getLabel("Common.code.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
	{
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
		f_query_add_mod.document.Notification_Setup_form.submit();
		}
	}
}

function onSuccess()
{
	f_query_add_mod.location.reload();
}

function reset() 
{
	if(f_query_add_mod.document.forms[0])
	   f_query_add_mod.document.forms[0].reset();
}


function change() 
{
	if (Notification_Setup_form.eff_status.checked == true)
    	Notification_Setup_form.eff_status.value="E";
     else
    	Notification_Setup_form.eff_status.value="D";
}
function emailchange() 
{
	if (Notification_Setup_form.email_applicable_chk.checked == true)
    	Notification_Setup_form.email_applicable.value="Y";
     else
    	Notification_Setup_form.email_applicable.value="N";
}
