 function create() 
 {
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyDischargeType.jsp" ; 
 } 

function query()
{
	f_query_add_mod.location.href ="../../eIP/jsp/DischargeTypeQueryCriteria.jsp" ;
}

function apply()
{

	var fields = new Array (f_query_add_mod.document.Discharge_Type_Form.discharge_type_code);
	
	var names  =  new Array ( getLabel('Common.code.label','common') );
	
	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 
	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  
	
	var fields = new Array(	f_query_add_mod.document.Discharge_Type_Form.discharge_type_code,
				f_query_add_mod.document.Discharge_Type_Form.long_desc,
				f_query_add_mod.document.Discharge_Type_Form.short_desc,
				f_query_add_mod.document.Discharge_Type_Form.block_indicate
				);

	var names = new Array (	getLabel('Common.code.label','common'),
				getLabel('Common.longdescription.label','common'),
				getLabel('Common.shortdescription.label','common'),
				getLabel('eIP.DischargeTypeIndicator.label','IP')
				)

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			if(f_query_add_mod.document.Discharge_Type_Form.maternal_death.disabled)
			f_query_add_mod.document.Discharge_Type_Form.maternal_death.value = 'N';

			for(var i=0; i<f_query_add_mod.document.forms[0].length;i++)
			{
				if( f_query_add_mod.document.forms[0].elements[i].disabled ==true)
					f_query_add_mod.document.forms[0].elements[i].disabled = false;
			}

			if(f_query_add_mod.document.forms[0].maternal_death.checked)
				f_query_add_mod.document.forms[0].maternal_death_yn_hid.value = 'Y';
			else
				f_query_add_mod.document.forms[0].maternal_death_yn_hid.value = 'N';

			f_query_add_mod.document.Discharge_Type_Form.submit();
			f_query_add_mod.document.Discharge_Type_Form.maternal_death.disabled = true;
		}

	}
}

function onSuccess() 
{
	 if(f_query_add_mod.document.Discharge_Type_Form.function_name.value=="insert"){
     	 f_query_add_mod.document.Discharge_Type_Form.reset() ;
		f_query_add_mod.document.Discharge_Type_Form.discharge_type_code.focus() ;
	 }
	 else
		f_query_add_mod.document.location.reload();
}

function reset() 
{
	if( f_query_add_mod.document.forms[0].name == "Discharge_Type_Form") 
	{
		f_query_add_mod.document.location.reload();
		f_query_add_mod.document.Discharge_Type_Form.discharge_type_code.focus();
	}
	else 
		f_query_add_mod.document.location.reload();
}

function callChk(obj,val)
{

	if(val=="D")
		obj.checked=!obj.checked

	if(document.forms[0].deceased_yn.checked)
		document.forms[0].deceased_yn_hid.value = 'Y';
	else
		document.forms[0].deceased_yn_hid.value = 'N';

	if(document.forms[0].maternal_death.checked)
		document.forms[0].maternal_death_yn_hid.value = 'Y';
	else
		document.forms[0].maternal_death_yn_hid.value = 'N';
}

//functin moved from addModifyDischargeType.jsp

function valuate(obj)
{
	if(obj.checked)
		document.forms[0].maternal_death.value	= "Y";
	else
		document.forms[0].maternal_death.value	= "N";
}

function enabledeath(obj)
{
	if(obj.checked)
	{
		document.forms[0].maternal_death.value		= "N";
		document.forms[0].maternal_death.disabled	= false;
		document.forms[0].maternal_death.checked	= false;
		document.forms[0].blocking_indicatior.disabled=true;
	}
	else
	{
		document.forms[0].maternal_death.value		= "N";
		document.forms[0].maternal_death.disabled	= true;
		document.forms[0].maternal_death.checked	= false;
		document.forms[0].blocking_indicatior.disabled=false;
	}
}
function setIndicator(obj)
{
var indicator = obj.value;
if(indicator=='DS'){
	document.forms[0].deceased_yn_hid.value		= 'Y';
	document.forms[0].maternal_death.value		= "N";
	document.forms[0].maternal_death.disabled	= false;
	document.forms[0].maternal_death.checked	= false;
}
else{
	document.forms[0].deceased_yn_hid.value		= 'N';
	document.forms[0].maternal_death.value		= "N";
	document.forms[0].maternal_death.disabled	= true;
	document.forms[0].maternal_death.checked	= false;
}
}
