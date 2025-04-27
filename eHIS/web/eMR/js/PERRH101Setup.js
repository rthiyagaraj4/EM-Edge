/*Created by Afruddin on 28-jun-2020 for ML-MMOH-CRF-1527*/
function create()
{
	f_query_add_mod.location.href = "../../eMR/jsp/PERRH101SetupCriteria.jsp";
}

function reset()
{
	var maxrecord = parent.content.f_query_add_mod.PERRH101SetupCriteriaForm.maxrecord.value;
	
	if(maxrecord > 0)
	{
		if(f_query_add_mod.document.forms[0])
		create();
	}
	else{
document.location.reload();
	}
	
}

function apply()
{
	var maxrecord = parent.content.f_query_add_mod.PERRH101SetupCriteriaForm.maxrecord.value;
	if(maxrecord > 0)
		{
		if (!(checkIsValidForProceed())){
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	parent.content.f_query_add_mod.PERRH101SetupCriteriaForm.submit();
		}
	else
		{
	document.location.reload();
		}
		
}

function checkIsValidForProceed()
{
	var url = parent.content.f_query_add_mod.location.href;
	if ((url.indexOf("PERRH101SetupCriteria.jsp"))!=-1)
		return true;
	else
		return false;
}

function onSuccess()
{
	create();
}




	
