
function onSuccess() 
 {
	f_query_add_mod.document.location.reload();
 }

function create()
{
	f_query_add_mod.location.href ="../../eAE/jsp/addModifySpareBays.jsp" ;
}

function query()
 {
	
	 f_query_add_mod.location.href ="../../eAE/jsp/SpareBaysQueryCriteria.jsp" ;
 }

 

function reset() 
  {
	  if(f_query_add_mod.document.forms[0])
    f_query_add_mod.document.location.reload();
	//if(f_query_add_mod.document.forms[0] !=null)
	//{
	////f_query_add_mod.document.forms[0].reset() ;
    //   parent.frames[1].frames[1].location.reload();
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
	f_query_add_mod.document.bed_treatment_area_form.bay_no,f_query_add_mod.document.bed_treatment_area_form.bay_type	);
	//var names = new Array ("Clinic","Bed/Bay No","Bed/Bay Type");	
	var names = new Array (getLabel("Common.Location.label","Common"),getLabel("eAE.BedBayNo.label","AE"),getLabel("eAE.BedBayType.label","AE"));	

	var fields1 = new Array (f_query_add_mod.document.bed_treatment_area_form.bay_no);
	var names1 = new Array (getLabel("eAE.BedBayNo.label","AE"));
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{  
	    if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
	    {
		
		f_query_add_mod.document.forms[0].clinic_code.disabled=false;
        f_query_add_mod.document.forms[0].bay_no.disabled=false;
		f_query_add_mod.document.bed_treatment_area_form.submit();
		}
	}
}

  function chkValue(obj)
   {
	   if(obj.name=="spare_bay1")
	   {
		    if(obj.checked==true)
		 {
		    obj.checked=true;
			obj.value='Y';
		    document.forms[0].spare_bay.value="Y";
		 }
		  else 
		 {   
			  obj.checked=false;
			   obj.value='N';
			   document.forms[0].spare_bay.value="N";
	     }
	   }else{
		
		/*Added by Ashwini on 30-Mar-2018 for PMG2018-COMN-CRF-0001*/
		if(obj.checked==false)
		   {
			 if(document.forms[0].bed_occupied_status.value=="EXIST")
			   {
				alert(getMessage('BED_OCCUPD_RESRVD','AE'))
				obj.checked=true;
				return false;
			   }
		   }
		 /*End PMG2018-COMN-CRF-0001*/
	  
	   if(obj.checked==true)
       {
				obj.checked=true;
				obj.value='E';
       }
      else
       {
				obj.checked=false;
				obj.value='D';
       }
	   }
    
   }
  function setFocus()
	  {
		  if(document.forms[0].clinic_code.disabled==false)
			  document.forms[0].clinic_code.focus();
	  }

