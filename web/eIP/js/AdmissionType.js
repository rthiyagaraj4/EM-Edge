function create() 
  {
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyAdmissionType.jsp" ; 
  } 

function query() 
  {
	f_query_add_mod.location.href ="../../eIP/jsp/AdmissionTypeQueryCriteria.jsp" ;
  }

function apply()
  {
	var fields = new Array (f_query_add_mod.document.Admission_Type_Form.admission_type_code);

	var names  =  new Array ( getLabel('Common.code.label','common') );

	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 

	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  

	var fields = new Array(
				f_query_add_mod.document.Admission_Type_Form.admission_type_code,
	   	       		f_query_add_mod.document.Admission_Type_Form.long_desc,
				f_query_add_mod.document.Admission_Type_Form.short_desc,
				f_query_add_mod.document.Admission_Type_Form.admn_type_ind
			      );

	var names = new Array (	getLabel('Common.code.label','common'),
				getLabel('Common.longdescription.label','common'),
				getLabel('Common.shortdescription.label','common'),
				getLabel('Common.INDICATOR.label','common')
			      )

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{     
		f_query_add_mod.document.Admission_Type_Form.submit();
	}
     }
  }

function onSuccess() 
 {
	 if(f_query_add_mod.document.Admission_Type_Form.function_name.value=="insert"){
	  	 f_query_add_mod.document.Admission_Type_Form.reset() ;
	    f_query_add_mod.document.Admission_Type_Form.admission_type_code.focus() ;
	 }
	 else
		f_query_add_mod.document.location.reload();
 }

function reset() 
   {

    if(  f_query_add_mod.document.forms[0].name == "Admission_Type_Form") 
	{
		     f_query_add_mod.document.location.reload();
			 f_query_add_mod.document.Admission_Type_Form.admission_type_code.focus() ;
        } 
    else 
         f_query_add_mod.document.query_form.reset() ;
    }

function callChk(obj,val)
{
	if(val=="D")
		obj.checked=!obj.checked
}

function CheckIndicator1(Obj)
{
	if(Obj.value == 'A')
		parent.frames[1].document.forms[0].patient_class.value='IP';
	else if(Obj.value == 'U')
		parent.frames[1].document.forms[0].patient_class.value='IP';
	else if(Obj.value == 'M')
		parent.frames[1].document.forms[0].patient_class.value='IP';
	else if(Obj.value == 'N')
		parent.frames[1].document.forms[0].patient_class.value='IP';
	else if(Obj.value == 'O')
		parent.frames[1].document.forms[0].patient_class.value='IP';
	else if(Obj.value == 'D')
		parent.frames[1].document.forms[0].patient_class.value='IP';
}

//functions moved from  addModifyAdmissionType.jsp

	function check(obj)
	{
		if(obj.checked == true)
			obj.value	="E";
		else
			obj.value = "D";
	}

	function fun_workup(obj)
	{

	  if (document.Admission_Type_Form.work_up.checked==true)
	  document.Admission_Type_Form.billingservcode_workup.disabled=false;
	  else
	  {
	  document.Admission_Type_Form.billingservcode_workup.disabled=true;
	  document.Admission_Type_Form.billingservcode_workup.options[0].selected=true;
	  }
	}
	
	function fun_consumable(obj)
	{
	  if (document.Admission_Type_Form.consumable_fee.checked==true)
	  document.Admission_Type_Form.billingservcode_consumable.disabled=false;
	  else
	  {
	  document.Admission_Type_Form.billingservcode_consumable.disabled=true;
	  document.Admission_Type_Form.billingservcode_consumable.options[0].selected=true;
	  }
	}

	function fun_round(obj)
	{
	  if (document.Admission_Type_Form.rounding_fee.checked==true)
	  document.Admission_Type_Form.billingservcode_rounding.disabled=false;
	  else
	 {
	  document.Admission_Type_Form.billingservcode_rounding.disabled=true;
	  document.Admission_Type_Form.billingservcode_rounding.options[0].selected=true;
	 }
	}
	
	function focusTxt()
	{
		document.forms[0].admission_type_code.focus();
	}		

	function CheckIndicator(Obj)
	{
		if(Obj.value == 'A')
			document.forms[0].patient_class.value='IP';
		else if(Obj.value == 'U')
			document.forms[0].patient_class.value='IP';
		else if(Obj.value == 'M')
			document.forms[0].patient_class.value='IP';
		else if(Obj.value == 'N')
			document.forms[0].patient_class.value='IP';
		else if(Obj.value == 'O')
			document.forms[0].patient_class.value='IP';
		else if(Obj.value == 'D')
			document.forms[0].patient_class.value='IP';
	}
