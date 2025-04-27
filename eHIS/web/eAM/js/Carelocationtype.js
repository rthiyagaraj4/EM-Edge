function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addmodifyCarelocationtype.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eAM/jsp/CarelocationtypeQueryCriteria.jsp";
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
        if(f_query_add_mod.document.Carelocn_form.function_name.value=='insert')
       {
       var fields=new Array (f_query_add_mod.document.Carelocn_form.locn_type,
				f_query_add_mod.document.Carelocn_form.long_desc,
				f_query_add_mod.document.Carelocn_form.short_desc,
				f_query_add_mod.document.Carelocn_form.locntype_ind
				    );

	var names = new Array ( getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common"),
							getLabel("Common.INDICATOR.label","Common"));
	}
	else if(f_query_add_mod.document.Carelocn_form.function_name.value=='modify')
	{
	var fields = new Array (f_query_add_mod.document.Carelocn_form.locn_type,
				f_query_add_mod.document.Carelocn_form.long_desc,
				f_query_add_mod.document.Carelocn_form.short_desc
				    );

	var names = new Array (getLabel("eAM.CareLocationCode.label","am"),
					getLabel("Common.longdescription.label","Common"),
				getLabel("Common.shortdescription.label","Common"));			
	}

//////////Added by Manish Anand on 01-07-2002////////////////////
	var spFields = new Array (f_query_add_mod.document.Carelocn_form.locn_type);
	var spNames = new Array ( getLabel("Common.code.label","Common") );
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//////////----------------------------------////////////////////
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			 f_query_add_mod.document.Carelocn_form.submit()
			 var fn_status = f_query_add_mod.document.Carelocn_form.function_name.value ;
		}
}

function onSuccess() {

	//if(f_query_add_mod.document.Carelocn_form.function_name.value == "insert") {
/////////////////Added by Manish Anand on 01-07-2002///////////////
	f_query_add_mod.location.reload();
///////////////////////////////////////////////////////////////////

/*		f_query_add_mod.document.Carelocn_form.locn_type.value	= "" ;
		f_query_add_mod.document.Carelocn_form.short_desc.value	= "" ;
		f_query_add_mod.document.Carelocn_form.long_desc.value	= "" ;
		f_query_add_mod.document.Carelocn_form.locntype_ind.options[0].selected=true;*/
	//}
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
				//f_query_add_mod.document.forms[0].reset();
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
