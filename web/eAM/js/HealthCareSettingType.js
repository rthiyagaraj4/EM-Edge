function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addHealthCareSettingType.jsp" ;
}
function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/HealthCareSettingTypeQueryPage.jsp?" ;
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
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	if(f_query_add_mod.document.HealthCareSettingType_form!=null){

	var fields = new Array (f_query_add_mod.document.HealthCareSettingType_form.hcare_setting_type_code,
						f_query_add_mod.document.HealthCareSettingType_form.long_desc,
						f_query_add_mod.document.HealthCareSettingType_form.short_desc
					    );
	 var names = new Array (getLabel("Common.code.label","Common")
,getLabel("Common.longdescription.label","Common")
,getLabel("Common.shortdescription.label","Common")

					      );
//////////Added by Manish Anand on 01-07-2002////////////////////
	var spFields = new Array (f_query_add_mod.document.HealthCareSettingType_form.hcare_setting_type_code);
	var spNames = new Array (getLabel("Common.code.label","Common")
);
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//////////----------------------------------////////////////////
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			f_query_add_mod.document.HealthCareSettingType_form.submit() ;
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
			//f_query_add_mod.document.forms[0].reset();
		   f_query_add_mod.document.location.reload();

}

function onSuccess() {
/////////////////Added by Manish Anand on 01-07-2002///////////////
	f_query_add_mod.location.reload();
///////////////////////////////////////////////////////////////////

//	f_query_add_mod.HealthCareSettingType_form.reset();
}
