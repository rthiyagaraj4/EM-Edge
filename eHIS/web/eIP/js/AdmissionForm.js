/*Created by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779*/
function create() 
{
	f_query_add_mod.location.href = "../../eIP/jsp/AddModifyAdmissionForm.jsp" ; 
} 

function query() 
{
	f_query_add_mod.location.href ="../../eIP/jsp/AdmissionFormQueryCriteria.jsp" ;
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
	if(!(checkIsValidForProceed()))
	{
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else
	{
		var fields = new Array(
					f_query_add_mod.document.AdmissionForm.admission_form_code,
					f_query_add_mod.document.AdmissionForm.long_desc,
					f_query_add_mod.document.AdmissionForm.short_desc,
					f_query_add_mod.document.AdmissionForm.speciality_desc
					  );

		var names = new Array (	getLabel('Common.code.label','common'),
					getLabel('Common.longdescription.label','common'),
					getLabel('Common.shortdescription.label','common'),
					getLabel('Common.speciality.label','common')
					  );

		if(f_query_add_mod.checkFieldsofMst(fields, names, messageFrame))
		{  
			f_query_add_mod.document.AdmissionForm.submit();
		}
	}
}

function onSuccess() 
{
	if(f_query_add_mod.document.AdmissionForm.function_name.value =="insert")
	{
		f_query_add_mod.document.AdmissionForm.reset();
		f_query_add_mod.document.AdmissionForm.admission_form_code.focus();
	}
	else
		f_query_add_mod.document.location.reload();
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
	{
		f_query_add_mod.location.reload();
	}
}

function ClearMsg()
{
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function changeByDefault() 
{
	 if (AdmissionForm.by_default.checked)
		AdmissionForm.by_default.value="Y";
	 else
		AdmissionForm.by_default.value="N";
}

function changeEffStatus() 
{
	 if (AdmissionForm.eff_status.checked)
		AdmissionForm.eff_status.value="E";
	 else
		AdmissionForm.eff_status.value="D";
}

function getValues(obj,target,targetId)
{
	var locale		   = document.forms[0].locale.value;
	var facilityid	   = document.forms[0].facilityID.value;
	var tit			   = "";
	var sql			   = "";
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var argumentArray  = new Array(8);

	target.value=trimString(target.value);

		if(target.value=="" && window.event.target == target)
		{
			targetId.value="";
			return;
		}

		if(obj.name=="speciality_button")
		{
			tit=getLabel("Common.speciality.label","Common");							

			argumentArray[0]="select SPECIALITY_CODE code, am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2) description from AM_SPECIALITY where EFF_STATUS = 'E' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)) like upper(nvl(?,am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)))"; 

			argumentArray[1] = dataNameArray;
			argumentArray[2] = dataValueArray;
			argumentArray[3] = dataTypeArray;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_DESC_LINK;
			argumentArray[7] = CODE_DESC;
		}

		var retVal=CommonLookup(tit,argumentArray);
			
		if(retVal ==null || retVal=="" || !retVal)
		{
			target.value="";
			targetId.value="";
		}
		else
		{
			targetId.value=retVal[0];
			target.value=retVal[1];
		}
}

function CheckForSpecCharsAdmsnForm(event)
{ 
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if(strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if((event.keyCode >= 97) && (event.keyCode <= 122))
		return (event.keyCode -= 32);
		return true;
}
