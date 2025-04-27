/*Created by Ashwini on 29-Jul-2019 for ML-MMOH-CRF-1352*/
function create()
{
	f_query_add_mod.location.href = "../../eMR/jsp/PERPL212SetupCriteria.jsp";
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
	create();
}

function FetchValues()
{
	var service_list = document.forms[0].service_list.value;
	var fields = new Array (document.forms[0].service_list);
	var names  = new Array (getLabel("Common.service.label","Common"));

	if(parent.f_query_add_mod.checkFieldsofMst(fields, names, parent.messageFrame)){
		var msg = "";
		parent.frames[2].location.href="../../eMR/jsp/PERPL212SetupSearchResult.jsp?service_list="+service_list;
		parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}else
	{
		parent.frames[2].location.href='../../eCommon/html/blank.html';
	}
}

function ClearResult()
{
	var msg = "";
	parent.frames[2].location.href='../../eCommon/html/blank.html';
	parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
}

function OnLoadClearResult()
{
	parent.frames[2].location.href='../../eCommon/html/blank.html';
}

function funCheck(obj)
{
	if(obj.checked == true)
	{
		obj.value = "Y";
	}else
	{
		obj.value = "N";
	}
}

function apply()
{
	if (!(checkIsValidForProceed())){
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	parent.content.resultFrame.PERPL212SetupResultForm.submit();
}

function checkIsValidForProceed()
{
	var url = parent.content.f_query_add_mod.location.href;
	if ((url.indexOf("PERPL212SetupCriteria.jsp"))!=-1)
		return true;
	else
		return false;
}

function onSuccess()
{
	create();
}
