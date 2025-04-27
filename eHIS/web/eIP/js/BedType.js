function create()
{
	
	f_query_add_mod.location.href = "../../eIP/jsp/AddModifyBedType.jsp" ;

}


function query()
{
	
	f_query_add_mod.location.href ="../../eIP/jsp/BedTypeQueryCriteria.jsp" ;
}

function checkIsValidForProceed(){
	var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
}
function apply()
{
	if (! (checkIsValidForProceed())){
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else{
	var fields = new Array (f_query_add_mod.document.bedtype_form.code);
	var names  =  new Array ( getLabel('Common.code.label','common') );
	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  
		if(f_query_add_mod.document.forms[0].setup_bl_dtls_in_ip_yn.value=="Y")
		{
			 var fields=new Array();

			 fields[0]= f_query_add_mod.document.bedtype_form.code;
			 fields[1]= f_query_add_mod.document.bedtype_form.long_desc;
			 fields[2]= f_query_add_mod.document.bedtype_form.short_desc;
			 fields[3]= f_query_add_mod.document.bedtype_form.bedclass;
			 fields[4]= f_query_add_mod.document.bedtype_form.billingclass;
			 fields[5]= f_query_add_mod.document.bedtype_form.billingservice;
			 fields[6]= f_query_add_mod.document.bedtype_form.daily_charge;

			var names = new Array (	getLabel('Common.code.label','common'),
					getLabel('Common.longdescription.label','common'),
					getLabel('Common.shortdescription.label','common'),
					getLabel('Common.BedClass.label','common'),
					getLabel('Common.BillingClass.label','common'),
					getLabel('Common.BillingService.label','commmon'),
					getLabel('eIP.DailyCharges.label','ip')
					)

					if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
					{
						f_query_add_mod.document.bedtype_form.bedclass.disabled=false;
						f_query_add_mod.document.bedtype_form.special_bed_type.disabled=false;
						f_query_add_mod.document.bedtype_form.submit();
					}
		  }
		  else
		  {
				var fields=new Array();

				fields[0]= f_query_add_mod.document.bedtype_form.code;
				fields[1]= f_query_add_mod.document.bedtype_form.long_desc;
				fields[2]= f_query_add_mod.document.bedtype_form.short_desc;
				fields[3]= f_query_add_mod.document.bedtype_form.bedclass;


				var names = new Array (	getLabel('Common.code.label','common'),
										getLabel('Common.longdescription.label','common'),
										getLabel('Common.shortdescription.label','common'),
										getLabel('Common.BedClass.label','common')
									  )

				if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
				{
					f_query_add_mod.document.bedtype_form.bedclass.disabled=false;
					f_query_add_mod.document.bedtype_form.special_bed_type.disabled=false;
					f_query_add_mod.document.bedtype_form.submit();
				}
		}
	}
	}

}


function reset()
{
	if (! (checkIsValidForProceed())){
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else{
  	if(f_query_add_mod.document.forms[0].name == "query_form")
	   	f_query_add_mod.document.forms[0].reset();	
	       		
    if(f_query_add_mod.document.forms[0].name =="bedtype_form")
	{
		f_query_add_mod.document.forms[0].reset();		
		f_query_add_mod.document.forms[0].code.focus();	
	}
	}
}


function onSuccess()
{
	
	
	if (f_query_add_mod.document.bedtype_form.function_name.value == "insert")
	{
       f_query_add_mod.document.bedtype_form.reset();
	   f_query_add_mod.document.forms[0].code.focus();	
	}
	else
	{
		f_query_add_mod.document.location.reload();
	}
}

//functions moved from AddModifyBedType.jsp

function bedClsDef()
{
	
	if(bedtype_form.bed_count.value > 0)
	{
		bedtype_form.bedclass.disabled=true;
	}
	if(bedtype_form.eff_status.checked == true)
	{
		bedtype_form.special_bed_type.disabled=false;
	}
	else
		bedtype_form.special_bed_type.disabled=true;
}

 function Change1()
	{
		
		if(bedtype_form.eff_status.checked == true)
		{
			bedtype_form.special_bed_type.disabled=false;
		}
		else
			bedtype_form.special_bed_type.disabled=true;

	   //added on 29-09-2003 by dhanasekaran
		if ( bedtype_form.eff_status.checked == false)
		{
			if(bedtype_form.bed_count.value > 0)
			{
				alert(getMessage("BED_TYPE_IS_ASSOCIATED","IP"));
				bedtype_form.eff_status.checked = true ;
				return;
			}
		}
		//end addition
	   if ( bedtype_form.eff_status.checked == true)

	   if ( bedtype_form.eff_status.checked == true)
			bedtype_form.eff_status.value="E";
	   else
			bedtype_form.eff_status.value="D";
	}
      	
function focusTxt()
{
	
	bedtype_form.code.focus();
}
