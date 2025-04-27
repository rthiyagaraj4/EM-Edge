
function onSuccess() 
 {
	
	f_query_add_mod.document.location.reload();
 }

function create()
{
	  
    f_query_add_mod.location.href ="../../eAE/jsp/addModifyBedforTreatmentArea.jsp" ;
}

function query()
 {
	
	 f_query_add_mod.location.href ="../../eAE/jsp/BedforTreatmentAreaQueryCriteria.jsp" ;
 }

function deleterecord()
{	
	if(f_query_add_mod.document.bed_treatment_area_form.mode.value!="INSERT")
	 {	
		f_query_add_mod.document.forms[0].mode.value='delete';
		f_query_add_mod.document.forms[0].submit();
		f_query_add_mod.location.href = '../../eAE/jsp/addModifyBedforTreatmentArea.jsp?mode=insert' ;
	 }
	 else
	 {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
	 }
}

function reset() 
  {
    /*if(f_query_add_mod.document.forms[0]){
		if(f_query_add_mod.document.forms[0].name=='bed_treatment_area_form'){
			if(f_query_add_mod.document.getElementById("mode").value == "MODIFY"){
				f_query_add_mod.location.reload();
			}else
				f_query_add_mod.document.forms[0].reset();
		}else*/
				f_query_add_mod.location.reload();
	  //} 
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
	
	 var fields = new Array (f_query_add_mod.document.bed_treatment_area_form.clinic_code,
		 f_query_add_mod.document.bed_treatment_area_form.treatment_area_code,
		 f_query_add_mod.document.bed_treatment_area_form.bed_no,
		 f_query_add_mod.document.bed_treatment_area_form.bay_type );
        
	var names = new Array (getLabel("Common.clinic.label",'Common'),getLabel("Common.treatmentarea.label",'Common'),getLabel("eAE.BedBayNo.label","AE"),getLabel("eAE.BedBayType.label","AE"));
	
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	 {

		f_query_add_mod.document.forms[0].clinic_code_val.value			= f_query_add_mod.document.forms[0].clinic_code.value;

		f_query_add_mod.document.forms[0].treatment_area_code_val.value = f_query_add_mod.document.forms[0].treatment_area_code.value;
		f_query_add_mod.document.forms[0].bed_no_val.value		= f_query_add_mod.document.forms[0].bed_no.value;
		f_query_add_mod.document.forms[0].eff_status_val.value			= f_query_add_mod.document.forms[0].eff_status.value;
		//f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn_val.value			= f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn.value;

		if (f_query_add_mod.document.forms[0].pseudo_bed.value!=null && f_query_add_mod.document.forms[0].pseudo_bed.value!='')
		{
		f_query_add_mod.document.forms[0].pseudo_bed_val.value			= f_query_add_mod.document.forms[0].pseudo_bed.value;
		}
		

		f_query_add_mod.document.bed_treatment_area_form.submit();
	 }
}

  function chkValue(obj)
   {
	  
	  if(obj.checked==true)
       {
				obj.checked=true;
				obj.value='Y';
       }
      else
       {
				obj.checked=false;
				obj.value='N';
       }
   }

  function chkValuePseudoBed(obj)
   {
	  
	  if(obj.checked==true)
       {
				obj.checked=true;
				obj.value='Y';

       }
      else
       {
				obj.checked=false;
				obj.value='N';

       }
   }


   function popTreatmentCode(obj)
   {
		
	   if(obj.value!='')
	   {
		   	var treatment_area_code = document.forms[0].treatment_area_code;
			while(treatment_area_code.options.length > 1)
			treatment_area_code.remove(1);

			//document.forms[0].practitioner_id.value = "";
		//	document.forms[0].practitioner_desc.value = "";

		 //	var practitioner_id = document.forms[0].practitioner_id;
			//while(practitioner_id.options.length > 1)
			//practitioner_id.remove(1);
            	var treatment = document.forms[0].treatment_area_code_val.value;
			
			var bedno =  document.forms[0].bed_no_val.value;
			
			var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/PopulateTreatmentArea.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='" +obj.value + "'><input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+treatment+"'><input type='hidden' name='bed_no' id='bed_no' value='"+bedno+"'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
	   }
   else
	   {
		   	var treatment_area_code = document.forms[0].treatment_area_code;
			while(treatment_area_code.options.length > 1)
			treatment_area_code.remove(1);
			document.forms[0].bed_no.value = "";
			//document.forms[0].practitioner_desc.value = "";

		 	//var practitioner_id = document.forms[0].practitioner_id;
			//while(practitioner_id.options.length > 1)
			//practitioner_id.remove(1);
	   }

   }
 function setFocus()
	  {
		  if(document.forms[0].clinic_code.disabled==false)
			  document.forms[0].clinic_code.focus();
		 
	  }

  function chkval(obj)
{
if(obj.checked)
	{
	obj.value="E"
	}
	else
	{
	obj.value="D"
	}

}



