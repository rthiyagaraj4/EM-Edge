function create()
{
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyTransferType.jsp" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eIP/jsp/TransferTypeQueryCriteria.jsp" ;
}

function apply()
  {
  	var fields = new Array (f_query_add_mod.document.Transfer_Type_Form.transfer_type_code);
  	
  	var names  =  new Array ( getLabel('Common.code.label','common'));
  	
  	//var messageFrame = parent.frames[1].frames[2]; 
  	var messageFrame = frames[2]; 
  	
  	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
  
  	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
  	{  
  	
	var fields = new Array(
				f_query_add_mod.document.Transfer_Type_Form.transfer_type_code,
	 	     	        f_query_add_mod.document.Transfer_Type_Form.long_desc,
				f_query_add_mod.document.Transfer_Type_Form.short_desc
			      );

	var names = new Array (	getLabel('Common.code.label','common'),
				getLabel('Common.longdescription.label','common'),
				getLabel('Common.shortdescription.label','common')
			      )

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			if(f_query_add_mod.Transfer_Type_Form.blocking_type.disabled == true)
				f_query_add_mod.Transfer_Type_Form.blocking_type.disabled =false;
			
			f_query_add_mod.document.Transfer_Type_Form.submit();
		}
     }
  }

function onSuccess()
 {
	 if(f_query_add_mod.document.Transfer_Type_Form.function_name.value=="insert"){
	  	 f_query_add_mod.document.Transfer_Type_Form.reset() ;
		 f_query_add_mod.document.Transfer_Type_Form.transfer_type_code.focus() ;
	 }
	 else
		f_query_add_mod.document.location.reload();
 }

function reset()
   {

    if(  f_query_add_mod.document.forms[0].name == "Transfer_Type_Form"){
         f_query_add_mod.document.Transfer_Type_Form.reset() ;
         f_query_add_mod.document.Transfer_Type_Form.transfer_type_code.focus() ;
        } 
    else
         f_query_add_mod.document.query_form.reset() ;
    }


// moved from addModifyTransferType.jsp

		function focusTxt()
		{
			Transfer_Type_Form.transfer_type_code.focus();
		}

		function change()
		{
			if(Transfer_Type_Form.eff_status.checked)
			{
//				Transfer_Type_Form.blocking_type.value = Transfer_Type_Form.hid_block_type_old.value;
//				Transfer_Type_Form.blocking_type.disabled = false;
			}
			else
			{
//				Transfer_Type_Form.blocking_type.value = Transfer_Type_Form.hid_block_type_old.value;
//				Transfer_Type_Form.blocking_type.disabled = true;
			}
		}

/*
		function change1()
		{
			Transfer_Type_Form.hid_block_type.value = Transfer_Type_Form.blocking_type.value;
		}
*/
