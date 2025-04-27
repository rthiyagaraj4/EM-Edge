 function create() 
 {
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyDischargeStatus.jsp" ; 
 } 

function query()
{
	f_query_add_mod.location.href ="../../eIP/jsp/DischargeStatusQueryCriteria.jsp" ;
}

 function apply()
 {
	
	var fields = new Array (f_query_add_mod.document.Discharge_Status_Form.discharge_status_code);
	var names  =  new Array ( getLabel('Common.code.label','common') );
	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  
		var fields = new Array(	f_query_add_mod.document.Discharge_Status_Form.discharge_status_code,
								f_query_add_mod.document.Discharge_Status_Form.long_desc,
								f_query_add_mod.document.Discharge_Status_Form.short_desc,
								f_query_add_mod.document.Discharge_Status_Form.block_indicate
							  );

		var names = new Array (	getLabel('Common.code.label','common'),
								getLabel('Common.longdescription.label','common'),
								getLabel('Common.shortdescription.label','common'),
								getLabel('eIP.DischargeStatusIndicator.label','IP')
							  )	;
		

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			if(f_query_add_mod.Discharge_Status_Form.block_indicate.disabled == true)
				f_query_add_mod.Discharge_Status_Form.block_indicate.disabled =false;
			
			f_query_add_mod.document.Discharge_Status_Form.submit();
		}
	}
 }

 function reset() 
{
	if( f_query_add_mod.document.forms[0].name == "Discharge_Status_Form") 
	{
		f_query_add_mod.document.location.reload();
		f_query_add_mod.document.Discharge_Status_Form.discharge_status_code.focus();
	}
	else 
		f_query_add_mod.document.location.reload();
}

function onSuccess()
{
	 if(f_query_add_mod.document.Discharge_Status_Form.function_name.value=="insert")
	 {
     	 f_query_add_mod.document.Discharge_Status_Form.reset() ;
		f_query_add_mod.document.Discharge_Status_Form.discharge_status_code.focus() ;
	 }
	 else
		//f_query_add_mod.document.location.reload();
	 f_query_add_mod.location.reload() ;
}
