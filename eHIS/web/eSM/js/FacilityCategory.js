/*
    Created: S V Narayana
	Created on 	: 14-04-2009
*/

function create() {
	f_query_add_mod.location.href = "../../eSM/jsp/AddModifyFacilityCategory.jsp?function_name=insert" ;
      }
function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/FacilityCategoryQuery.jsp?" ;
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
function apply() {
	if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	if(f_query_add_mod.document.FacilityCategory_form!=null){

	var fields = new Array (f_query_add_mod.document.FacilityCategory_form.facility_category_code,
						f_query_add_mod.document.FacilityCategory_form.long_desc,
						f_query_add_mod.document.FacilityCategory_form.short_desc
					    );
	 var names = new Array (getLabel("Common.code.label","Common")
                  ,getLabel("Common.longdescription.label","Common")
                  ,getLabel("Common.shortdescription.label","Common")

					      );
	var spFields = new Array (f_query_add_mod.document.FacilityCategory_form.facility_category_code);
	var spNames = new Array (getLabel("Common.code.label","Common")
);
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			f_query_add_mod.document.FacilityCategory_form.submit() ;
	}
}
else
	{
	frames[0].location.reload();
	return false;
	}
}

function reset() {
		if(f_query_add_mod.document.forms[0])
			f_query_add_mod.document.location.reload();
			//f_query_add_mod.document.forms[0].reset();

}

function onSuccess() {
	f_query_add_mod.location.reload();

}
function SpeCharCheck(which) {
fldval = which.value;
fldval = fldval.replace(/^\s+/,""); // strip leading spaces
if (/[^a-z0-9\s]/i.test(fldval)) { // only alphanumeric and space allowed
alert ("You have entered one or more invalid characters - try again!");
which.value = "";
which.focus();
return false;
}
}
