 function create() 
  {
	f_query_add_mod.location.href = "../../eIP/jsp/AddModifyLodgerstayReason.jsp" ;
  }
 function query()
  {
  	f_query_add_mod.location.href="../../eIP/jsp/LodgerStayReasonQueryCriteria.jsp";  	
  }
  
 function apply()
 {
	var fields = new Array (f_query_add_mod.document.lodgerstay_form.reason_for_stay_code);

	var names  =  new Array ( getLabel('Common.code.label','common'));

	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 

	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  
	var fields=new Array();
	//if (f_query_add_mod.document.lodgerstay_form.function_name.value == "insert")
	//{
		fields[0]= f_query_add_mod.document.lodgerstay_form.reason_for_stay_code;
		fields[1]= f_query_add_mod.document.lodgerstay_form.long_desc;	
		fields[2]= f_query_add_mod.document.lodgerstay_form.short_desc;	
		//fields[3]= f_query_add_mod.document.lodgerstay_form.eff_status;	
	//}
		var names = new Array (	getLabel('Common.code.label','common'), getLabel('Common.longdescription.label','common'), getLabel('Common.shortdescription.label','common'));
		
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			f_query_add_mod.document.lodgerstay_form.submit();		
		}
	}
}

 function onSuccess() 
 {
	   if(f_query_add_mod.document.lodgerstay_form.function_name.value=="insert")
	   {
		f_query_add_mod.document.lodgerstay_form.reason_for_stay_code.value	= "" ;
		f_query_add_mod.document.lodgerstay_form.short_desc.value		= "" ;
		f_query_add_mod.document.lodgerstay_form.long_desc.value		= "" ;
		f_query_add_mod.document.lodgerstay_form.eff_status.checked		= true ;
		f_query_add_mod.document.lodgerstay_form.reason_for_stay_code.focus();

	    }else{
			f_query_add_mod.document.location.reload();
		}
}

function reset()
{
	if(f_query_add_mod.document.forms[0].name == "lodgerstay_form")
		f_query_add_mod.document.location.reload();
	if(f_query_add_mod.document.forms[0].name == "query_form")
		f_query_add_mod.document.query_form.reset() ;
}

//function from AddModifyLodgerstayReason.jsp

function change() 
{
	 if (lodgerstay_form.eff_status.checked == true)
		lodgerstay_form.eff_status.value="E";
	 else
		lodgerstay_form.eff_status.value="D";
}

function focusTxt()
{
	lodgerstay_form.reason_for_stay_code.focus();
}   
