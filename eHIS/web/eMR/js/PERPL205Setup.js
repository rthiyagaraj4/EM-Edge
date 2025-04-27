/*Created by Ashwini on 26-Aug-2019 for ML-MMOH-CRF-1348*/
function create()
{
	f_query_add_mod.location.href = "../../eMR/jsp/PERPL205SetupCriteria.jsp";
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
	create();
}

function EnableLocation(obj)
{	
	var obj_type = document.forms[0].location_list;

	var length = obj_type.length;

	for(i=0; i<length; i++) 
	{
		obj_type.remove(0);
	}

	if (obj.value != "")
	{
		document.forms[0].location_list.disabled = false;

		if (obj.value == 'KK')
		{
			var opt_type = document.createElement('Option');
			opt_type.text = getLabel("Common.clinic.label","Common"); 
			opt_type.value = 'CL';
			obj_type.add(opt_type);
			
			var opt_type = document.createElement('Option');
			opt_type.text = getLabel("Common.ProcedureUnit.label","Common"); 
			opt_type.value = 'PU';
			obj_type.add(opt_type);
		}
		else if (obj.value == 'PC')
		{
			var opt_type = document.createElement('Option');
			opt_type.text = getLabel("Common.ProcedureUnit.label","Common"); 
			opt_type.value = 'PU';
			obj_type.add(opt_type);
		}
	}else
	{
		var opt=document.createElement("Option");
		opt.text="--------- Select ---------"
		opt.value="";
		obj_type.add(opt);

		document.forms[0].location_list.disabled = true;
	}
}

function FetchValues()
{
	var service_list = document.forms[0].service_list.value;
	var location_list = document.forms[0].location_list.value;
	var fields = new Array (document.forms[0].service_list,document.forms[0].location_list);
	var names  = new Array (getLabel("Common.service.label","Common"),getLabel("Common.Location.label","Common"));

	if(parent.f_query_add_mod.checkFieldsofMst(fields, names, parent.messageFrame)){
		var msg = "";
		parent.frames[2].location.href="../../eMR/jsp/PERPL205SetupSearchResult.jsp?service_list="+service_list+"&location_list="+location_list;
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
	parent.content.resultFrame.PERPL205SetupResultForm.submit();
}

function checkIsValidForProceed()
{
	var url = parent.content.f_query_add_mod.location.href;
	if ((url.indexOf("PERPL205SetupCriteria.jsp"))!=-1)
		return true;
	else
		return false;
}

function onSuccess()
{
	create();
}
