function create()
{
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyAnaesthesia.jsp";
}



function query()
{
	f_query_add_mod.location.href = "../../eAM/jsp/AnaesthesiaQueryCriteria.jsp";
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply()
{
	var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array(f_query_add_mod.document.anaesthesia_form.anaesth_code,
				f_query_add_mod.document.anaesthesia_form.long_desc,
				f_query_add_mod.document.anaesthesia_form.short_desc	)

	var names = new Array(getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
					        getLabel("Common.shortdescription.label","Common"));
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.checkFieldsofMst(fields,names, messageFrame))
	{
		f_query_add_mod.document.anaesthesia_form.submit();
	}
	
}

function onSuccess()
{
	f_query_add_mod.document.location.reload();
}

function reset()
{
	// f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.document.location.reload();
}
