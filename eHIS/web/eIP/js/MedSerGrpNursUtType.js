 function create() 
  {
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyMedSerGrpNursUtType.jsp" ; 
  } 

function query()
  {
	f_query_add_mod.location.href ="../../eIP/jsp/MedSerGrpNursUtTypeQueryCriteria.jsp" ;
  }

function apply()
  {

	var function_name = f_query_add_mod.document.MedSerGrpNursUtType_Form.function_name.value;
	if(function_name=="insert")	
	  {
		var fields = new Array(
					 f_query_add_mod.document.MedSerGrpNursUtType_Form.med_ser_grp_code,
					 f_query_add_mod.document.MedSerGrpNursUtType_Form.nursing_unit_type_code
					  );

		var names = new Array (	getLabel('eIP.MedicalServiceGroup.label','IP'),
					getLabel('eIP.NursingUnitType.label','IP')
					  )

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{     
			f_query_add_mod.document.MedSerGrpNursUtType_Form.submit();
		}
	  }
	  else if(function_name=="modify")	
	  {
		
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
		f_query_add_mod.document.MedSerGrpNursUtType_Form.submit();

	  }
  }

function deleterecord()
{
	if(f_query_add_mod.document.MedSerGrpNursUtType_Form.function_name.value!="insert")
	{   
		if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','common')))
		{
		f_query_add_mod.document.MedSerGrpNursUtType_Form.function_name.value="delete";		
		f_query_add_mod.document.MedSerGrpNursUtType_Form.submit();	
		}
		else
		{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "
		}
	}else{
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	
	}
}

function onSuccess() 
{
	var function_name = f_query_add_mod.document.MedSerGrpNursUtType_Form.function_name.value;
	if(function_name=="modify")	
		f_query_add_mod.document.location.reload(); 	 
	else if(function_name=="insert")
	{
		f_query_add_mod.document.MedSerGrpNursUtType_Form.reset() ;
		f_query_add_mod.document.MedSerGrpNursUtType_Form.med_ser_grp_code.focus() ;
	}
	else
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
}

function reset() 
{
	if(f_query_add_mod.document.forms[0].name == "MedSerGrpNursUtType_Form") 
	{
		f_query_add_mod.document.MedSerGrpNursUtType_Form.reset() ;
		if(f_query_add_mod.document.MedSerGrpNursUtType_Form.function_name.value=="insert")
			f_query_add_mod.document.MedSerGrpNursUtType_Form.med_ser_grp_code.focus() ;
	}
    else 
         f_query_add_mod.document.query_form.reset() ;
}

//functions moved from addModifyMedSerGrpNursUtType.jsp

function focusTxt()
{
	MedSerGrpNursUtType_Form.med_ser_grp_code.focus();
}
