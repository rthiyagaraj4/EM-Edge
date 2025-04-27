/*Created by Ashwini on 03-Sep-2020 for ML-MMOH-CRF-1351*/
function create()
{
	f_query_add_mod.location.href = "../../eMR/jsp/PERPL210ASetupCriteria.jsp";
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
		parent.frames[2].location.href="../../eMR/jsp/PERPL210ASetupSearchResult.jsp?service_list="+service_list;
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

function funCheck(obj,clinic_code)
{
	var clinic_code = clinic_code.value;
	var facility_id = document.forms[0].facility_id.value;
	var service_code = document.forms[0].service_list.value;

	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH clinic_code=\""+clinic_code+"\" facility_id=\""+facility_id+"\" service_code=\""+service_code+"\" action='getEDOBClinicCnt'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	var clinic_cnt = trimString(responseText);
	
	if(clinic_cnt > 0)
	{
		var msg = getMessage("CLINIC_ALRDY_MAPPED","MR");
		if(service_code == "ED")
		{
			msg	= msg.replace("#"," - "+getLabel("Common.Observation.label","Common"));
		}else
		{
			msg	= msg.replace("#"," - "+getLabel("Common.emergency.label","Common")+" "+getLabel("Common.department.label","Common"));
		}
		alert(msg);
		obj.checked = false;
	}else
	{
		if(obj.checked == true)
		{
			obj.value = "Y";
		}else
		{
			obj.value = "N";
		}
	}
}

function apply()
{
	if (!(checkIsValidForProceed())){
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	parent.content.resultFrame.PERPL210ASetupResultForm.submit();
}

function checkIsValidForProceed()
{
	var url = parent.content.f_query_add_mod.location.href;
	if ((url.indexOf("PERPL210ASetupCriteria.jsp"))!=-1)
		return true;
	else
		return false;
}

function onSuccess()
{
	create();
}
