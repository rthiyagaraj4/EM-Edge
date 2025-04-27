function create()
{
	f_query_add_mod.location.href = "../../eAE/jsp/addModifyInjurySubCategory.jsp?&source=Insert" ;
}

function edit()
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eAE/jsp/InjurySubCategoryQueryCriteria.jsp?function=InjurySubCategory";
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

	 if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }

	var fields = new Array ( f_query_add_mod.document.subcategory_form.inj_category_code,
				 /*f_query_add_mod.document.subcategory_form.inj_category_short_desc,*/	
				 f_query_add_mod.document.subcategory_form.inj_subcategory_code,
				 f_query_add_mod.document.subcategory_form.inj_subcategory_long_desc,
				 f_query_add_mod.document.subcategory_form.inj_subcategory_short_desc
				);

	var names = new Array ( f_query_add_mod.getLabel("Common.CategoryCode.label","Common"),f_query_add_mod.getLabel("eAE.SubCategoryCode.label","AE"),f_query_add_mod.getLabel("Common.longdescription.label","Common"),f_query_add_mod.getLabel("Common.shortdescription.label","Common"));

//	var spFields = new Array (f_query_add_mod.document.subcategory_form.inj_subcategory_code);
//	var spNames = new Array ("SubCategory Code");
//	var error_page="../../eCommon/jsp/MstCodeError.jsp"
//	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//  
	var fields1 = new Array (f_query_add_mod.document.subcategory_form.inj_subcategory_code);
	var names1 = new Array (f_query_add_mod.getLabel("eAE.SubCategoryCode.label","AE"));
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
 	
      if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			//alert("Before Submit")
			//var fn_status = f_query_add_mod.document.subcategory_form.function_name.value ;
           if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
	    {
      	 f_query_add_mod.document.subcategory_form.submit();
		}

		}
//		alert("ok");

}

function onSuccess()
{
    if(f_query_add_mod.document.forms[0])
    {

	f_query_add_mod.location.reload();

    }
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset() ;

}
