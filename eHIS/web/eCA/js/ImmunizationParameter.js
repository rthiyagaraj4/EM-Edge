/*--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date 		Rev.by 					Description
--------------------------------------------------------------------------------------------------------------
23/02/2023      41650               Twinkle Shah    	                                        MMS-JU-CRF-0015.1
18/05/2023	    41653		        Twinkle Shah	    18/05/2023	    M.f.mohamed Ali         MMS-JU-CRF-0015.3
-------------------------------------------------------------------------------------------------------------- 
*/
function allowNumeric()
{
	if ((event.keyCode < 48 || event.keyCode > 57))
	{
		return false;		
	}
	return true;
}
function  callFunctionButton(obj, locale)
{
	if (obj.value != '')
	{
		getAdhocCateg(locale)
	}
}

async function getAdhocCateg(locale)
{
	var sql = "SELECT   vacc_categ_id code, short_desc description FROM CA_IM_VAC_CATEG_LANG_VW WHERE adhoc_yn = 'Y' AND eff_status = 'E'      and LANGUAGE_ID = '"+locale+"' AND UPPER (vacc_categ_id) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) AND vacc_categ_id NOT IN (SELECT DISTINCT vacc_categ_id FROM ca_im_vac_for_categ) ORDER BY 2";
	var title = getLabel('Common.adhoc.label','COMMON')+getLabel('Common.Vaccine.label','COMMON')+getLabel('Common.category1.label','COMMON');
	
		

	var target = document.imPramForm1.vacc_categ_desc;
	//target.value='';
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;	
	retArray = await CommonLookup( title, argArray );

	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray !="")	
	{
		document.imPramForm1.vacc_categ_desc.value = arr[1];
		document.imPramForm1.vacc_categ_id.value =  arr[0];					
	}
	else
	{
		document.imPramForm1.vacc_categ_desc.value = '';
		document.imPramForm1.vacc_categ_id.value = '';
	}
}


function apply()
{	
	formObj = imParamFrm.document.imPramForm1;
	var fields = new Array (formObj.vacc_categ_id,formObj.vacc_link_days);
	var names = new Array (getLabel("eCA.VaccineCatagoryForRXVaccines.label","CA"),getLabel("eCA.NoDaysVaccinesSchedule.label","CA"));
	//alert("vacc_categ_id"+formObj.vacc_categ_id.value);
	//alert("vacc_link_days"+formObj.vacc_link_days.value);
	//alert("names"+names);
	if(checkFieldsofMst( fields, names, messageFrame))
	{
		formObj.action='../../servlet/eCA.ImmunizationParameter';
		formObj.target='messageFrame';
		formObj.method="post";
		formObj.submit();
	}
}

function onSuccess()
{	
	
}
function Clearhidden()
{
	document.imPramForm1.vacc_categ_id.value = '';
}

function reset()
{	
	imParamFrm.location.reload();	
}

//start 41650
function toAutoPopSchedManageImmun(obj)
{
	if(obj.checked)
	document.imPramForm1.auto_sch_immun_yn.value = 'Y';
	else
	document.imPramForm1.auto_sch_immun_yn.value = 'N';
}
// end 41650

//start 41653
function toDisplayVaccineSchedulesSorted(obj)
{
	if(obj.checked)
	document.imPramForm1.disp_vacc_sort_yn.value = 'Y';
	else
	document.imPramForm1.disp_vacc_sort_yn.value = 'N';
}
// end 41653



