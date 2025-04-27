function create() 
{
	f_query_add_mod.location.href = "../../eMP/jsp/addMpInternalReqRepRule.jsp" ;
}

function edit() 
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query()
{	
	f_query_add_mod.location.href ="../../eMP/jsp/MpInternalReqRepRuleQueryPage.jsp?function=MpInternalReqRepRule";
}

function apply()
{
	
			if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	
	
	
	var fields = new Array ( f_query_add_mod.document.MpInternalReqRepRule_Form.report_id,
						f_query_add_mod.document.MpInternalReqRepRule_Form.pat_ser_grp_code
					    );

	var names = new Array (f_query_add_mod.getLabel('eMP.InternalRequestReport.label','MP'), f_query_add_mod.getLabel('eMP.PatientSeries.label','MP'));
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 	
	{
		if(f_query_add_mod.document.MpInternalReqRepRule_Form.function_name.value=="insert")
		{
			f_query_add_mod.document.MpInternalReqRepRule_Form.submit();
		}
		else
		{
		
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";

		}
	}
}

function onSuccess() 
{
	//f_query_add_mod.document.forms[0].reset() ;
	f_query_add_mod.document.location.reload();
}

function reset() 
{
	f_query_add_mod.document.forms[0].reset() ;
}

function deleterecord()
{
	if(f_query_add_mod.document.MpInternalReqRepRule_Form.function_name.value!="insert")
	{
		f_query_add_mod.document.MpInternalReqRepRule_Form.function_name.value="delete";
		if (confirm(f_query_add_mod.getMessage("DELETE_RECORD","Common")))
		{
			f_query_add_mod.document.MpInternalReqRepRule_Form.submit();
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
			return true;
		}
		else
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= ";
	}
	else
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= ";
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
