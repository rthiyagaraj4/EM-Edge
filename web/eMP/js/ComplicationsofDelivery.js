function show() {
	parent.parent.window.document.title = getLabel('Common.setup.label','common') + " "+getLabel('Common.birthPlace.label','common');
}


function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/ComplicationsofDelivery.jsp" ;
}

function query() {
   f_query_add_mod.location.href ="../../eMP/jsp/ComplicationsofDeliveryQueryPage.jsp?";
}

function apply() {	
	
	if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	var fields = new Array ( f_query_add_mod.document.res_town_form.compln_dely_code,
						f_query_add_mod.document.res_town_form.long_desc,
						f_query_add_mod.document.res_town_form.short_desc,f_query_add_mod.document.res_town_form.type_of_complication

					    );
	var names = new Array ( getLabel('Common.code.label','common'),
						getLabel('Common.longdescription.label','common'),
						getLabel('Common.shortdescription.label','common'),getLabel('eMP.TypeofComplication.label','MP')

					      );
	var transform = new Array (	f_query_add_mod.document.res_town_form,
							f_query_add_mod.document.res_town_form.eff_date_from,
							f_query_add_mod.document.res_town_form.eff_date_from1,
							f_query_add_mod.document.res_town_form.eff_date_to,
							f_query_add_mod.document.res_town_form.eff_date_to1
						  );
	var splField = new Array (f_query_add_mod.document.res_town_form.compln_dely_code);
	var splFieldName = new Array (getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {			
				var fn_status = f_query_add_mod.document.res_town_form.function_name.value ;		
					f_query_add_mod.document.res_town_form.type_of_complication.disabled=false;
					f_query_add_mod.document.res_town_form.stage1.disabled=false;
					f_query_add_mod.document.res_town_form.stage2.disabled=false;
					f_query_add_mod.document.res_town_form.stage3.disabled=false;
					f_query_add_mod.document.res_town_form.submit();
			}
		}
	}
	


function reset() {
	f_query_add_mod.document.forms[0].reset() ;
	        var type_of_complication  = f_query_add_mod.document.forms[0].type_of_complication.value;
			if(type_of_complication == 'F')
			{
              	f_query_add_mod.document.forms[0].stage1.checked = false;
				f_query_add_mod.document.forms[0].stage2.checked = false;
				f_query_add_mod.document.forms[0].stage3.checked = false;
				f_query_add_mod.document.forms[0].stage1.disabled= true;
				f_query_add_mod.document.forms[0].stage2.disabled= true;
				f_query_add_mod.document.forms[0].stage3.disabled= true;

			}
			else if(type_of_complication == 'M')
			{
              f_query_add_mod.document.forms[0].stage1.disabled= false;
              f_query_add_mod.document.forms[0].stage2.disabled= false;
              f_query_add_mod.document.forms[0].stage3.disabled= false;
			}
}

function onSuccess() {
	f_query_add_mod.location.reload();
}

function CheckSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode );
	return true ;
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

function checkStage(obj)
{
	if(obj.value!='') 
	     { 
	        var type_of_complication  = document.forms[0].type_of_complication.value;
			if(type_of_complication == 'F')
			{
              	document.forms[0].stage1.checked = false;
				document.forms[0].stage2.checked = false;
				document.forms[0].stage3.checked = false;
				document.forms[0].stage1.disabled= true;
				document.forms[0].stage2.disabled= true;
				document.forms[0].stage3.disabled= true;

			}
			else if(type_of_complication == 'M')
			{
              document.forms[0].stage1.disabled= false;
              document.forms[0].stage2.disabled= false;
              document.forms[0].stage3.disabled= false;
			}
         }else
		 {
			  document.forms[0].stage1.disabled= false;
              document.forms[0].stage2.disabled= false;
              document.forms[0].stage3.disabled= false;
		 }
}
