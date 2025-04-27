
function create()
{
    f_query_add_mod.location.href ="../../eAE/jsp/AddModifyBayType.jsp" ;
}

function query()
 {
	 f_query_add_mod.location.href ="../../eAE/jsp/BayTypeQueryCriteria.jsp" ;
 }
function reset()
{
    if(f_query_add_mod.document.forms[0])
    f_query_add_mod.document.location.reload();
		

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
	 
      
	
   var fields = new Array (f_query_add_mod.document.bay_type_form.bay_type_code,f_query_add_mod.document.bay_type_form.long_desc,f_query_add_mod.document.bay_type_form.short_desc);
   var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));   /*
	 The checkfields function checks for the validity of the fields...The fields in the fields array passed are supposed to be mandatory field and they are not supposed to be null or blank.
	 If none of the mandatory fields are blank , the function returns true else it returns false alert the corresponding field name should not be blank.

	 The function checkFields( fields, names, messageFrame) is implemented in the common directories...in eCommon/js/common.js
   */
    var fields1 = new Array (f_query_add_mod.document.bay_type_form.bay_type_code);
	var names1 = new Array (getLabel("Common.code.label","Common"));
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
	
   if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
       if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
	    {
	      f_query_add_mod.document.bay_type_form.submit();
		}
	 }
}

 
  function changeCase(obj)
 {
	 document.forms[0].accident_cause_code.value=obj.value.toUpperCase();
 }

 
function onSuccess() 
 {
   f_query_add_mod.document.location.reload();
 }

function changeStatus() 
	{
      	
		 if (bay_type_form.eff_status.checked == true)
      	 	bay_type_form.eff_status.value="E";
      	 else
      		bay_type_form.eff_status.value="D";
     }
 
 function changeCase(obj)
 {
	 document.forms[0].bay_type_code.value=obj.value.toUpperCase();
 }
