function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addHlthCareSetgTypRestns.jsp" ;
}
function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/HlthCareSetgTypRestnsQueryPage.jsp?" ;
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
		var fields = new Array (f_query_add_mod.document.HlthCareSetgTypRestns_form.from_hcare_setting_type_code,
							f_query_add_mod.document.HlthCareSetgTypRestns_form.to_hcare_setting_type_code
							);
		 var names = new Array (getLabel("eAM.FromHealthCareSettingType.label","am")
								,getLabel("eAM.ToHealthCareSettingType.label","am")

							 );
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
				f_query_add_mod.document.HlthCareSetgTypRestns_form.submit() ;
		}
}

function reset() {
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	var function_name = f_query_add_mod.document.forms[0].function_name;
	if(f_query_add_mod.document.forms[0])
	{
		if((function_name != null) && (function_name.value=="modify"))
		{
			if(messageFrame.document.body.innerText.indexOf("Operation Completed Successfully")==-1)
			{
			//	f_query_add_mod.document.forms[0].reset();
				f_query_add_mod.document.location.reload();
			}
		}
		else
		{
			//f_query_add_mod.document.forms[0].reset();
			f_query_add_mod.document.location.reload();
		}
	}
      
				
		}

function onSuccess() {
	//alert('caller');
	f_query_add_mod.location.reload();
}
