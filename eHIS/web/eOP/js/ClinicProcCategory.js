function create() {
	f_query_add_mod.location.href = "../../eOP/jsp/addClinicProcCategory.jsp?mode=insert" ;
}

function query() {
	f_query_add_mod.location.href ="../../eOP/jsp/queryClinicProcCategory.jsp?mode=modify" ;
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
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }

   
	if(f_query_add_mod.document.clinic_proc_catg_form.function_name.value=="insert") {
	 var fields = new Array ( f_query_add_mod.document.clinic_proc_catg_form.clinic_proc_catg_code,
				  f_query_add_mod.document.clinic_proc_catg_form.long_desc,
				  f_query_add_mod.document.clinic_proc_catg_form.short_desc);

	 var names  = new Array (getLabel('Common.code.label','Common'),getLabel('Common.longdescription.label','Common'),getLabel('Common.shortdescription.label','Common'));
	 

	var field = new Array ( f_query_add_mod.document.clinic_proc_catg_form.clinic_proc_catg_code );
    var name  = new Array ( getLabel('Common.code.label','Common') );

}
else if(f_query_add_mod.document.clinic_proc_catg_form.function_name.value=="modify") 
{
	var fields = new Array ( f_query_add_mod.document.clinic_proc_catg_form.clinic_proc_catg_code,
							  f_query_add_mod.document.clinic_proc_catg_form.long_desc,
							  f_query_add_mod.document.clinic_proc_catg_form.short_desc
							);

	 var names  = new Array (getLabel('Common.code.label','Common'),
							  getLabel('Common.longdescription.label','Common'),								  getLabel('Common.shortdescription.label','Common')		
							);
 var  field = new Array (f_query_add_mod.document.clinic_proc_catg_form.clinic_proc_catg_code);
 var name  = new Array (getLabel('Common.code.label','Common')); 
}
var error_page = "../../eCommon/jsp/error.jsp";
	
	if(f_query_add_mod.checkFields(fields,names,messageFrame)) 
	{
		if (f_query_add_mod.SpecialCharCheck(field,name,messageFrame,"M",error_page))
	    {
			f_query_add_mod.document.clinic_proc_catg_form.submit();
		}
	}

}


function reset() {
var url = f_query_add_mod.document.location.href;
	 if((url.indexOf("queryClinicProcCategory.jsp") != -1) || (url.indexOf("addClinicProcCategory.jsp") != -1 ))
{		f_query_add_mod.document.location.reload();
}	 else{
		 return false;
}
}

function onSuccess() {
	if(f_query_add_mod.document.clinic_proc_catg_form.mode.value=="insert")
	{

		f_query_add_mod.location.reload(); 
	}
	else{
			f_query_add_mod.document.location.reload();
	}
}



function change() {
      	 if (clinic_proc_catg_form.eff_status.checked == true)
      	 	clinic_proc_catg_form.eff_status.value="E";
      	 else
      		clinic_proc_catg_form.eff_status.value="D";
      	}
