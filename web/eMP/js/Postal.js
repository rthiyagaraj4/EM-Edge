
function show() {
	//parent.parent.window.document.title = "Setup Country" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/PostalCodesAdd.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eMP/jsp/PostalQueryPage.jsp?function=postal" ;
}
function apply() 
{
	
	  if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	
	
	var fields = new Array ( 		f_query_add_mod.document.postal_form.postal_code,
						f_query_add_mod.document.postal_form.long_desc,
						f_query_add_mod.document.postal_form.short_desc				   
						);
	 var names = new Array (f_query_add_mod.getLabel('Common.code.label','common'),	f_query_add_mod.getLabel('Common.longdescription.label','common'),	f_query_add_mod.getLabel('Common.shortdescription.label','common'));

	 var transform = new Array (	f_query_add_mod.document.postal_form,
							f_query_add_mod.document.postal_form.eff_date_from,
							f_query_add_mod.document.postal_form.eff_date_from1,
							f_query_add_mod.document.postal_form.eff_date_to,
							f_query_add_mod.document.postal_form.eff_date_to1
						   );
	var splField = new Array (f_query_add_mod.document.postal_form.postal_code);
	var splFieldName = new Array (f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if(f_query_add_mod.DateTransform(transform,messageFrame)) {
				var fn_status = f_query_add_mod.document.postal_form.function_name.value ;

			}
		}
	}
}

function reset()
{
	f_query_add_mod.document.forms[0].reset() ;
}

function onSuccess()
{
	f_query_add_mod.location.reload() ;
}

function help() { }


async function searchTown(obj,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";	

	tit = getLabel('Common.Town.label','common');
	sql = "SELECT res_town_code code, long_desc description FROM mp_res_town_lang_vw  WHERE eff_status = 'E' and  language_id='"+localeName+"' and upper(long_desc) like upper(?) and  upper(res_town_code) like upper(?) ORDER BY long_desc";
	//sql = "SELECT res_town_code code, long_desc description FROM mp_res_town  WHERE eff_status = 'E' and  upper(res_town_code) like upper(?) and upper(long_desc) like upper(?) ORDER BY long_desc ";
			
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	if(obj.value != null && obj.value != "")
		retVal = await CommonLookup_servlet( tit, argumentArray );


	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		
		document.forms[0].res_town_code.value= arr[0];
	}
	else
	{
		target.value='';
		document.forms[0].res_town_code.value= '';
	}
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
