// Added/Modified by Nanda - 11/8/2002   

function onSuccess() 
 {
	f_query_add_mod.document.location.reload();
 }

function create()
{
     f_query_add_mod.location.href ="../../eAE/jsp/AddModifyTreatmentAreaforClinic.jsp" ;
}

function query()
 {
	 f_query_add_mod.location.href ="../../eAE/jsp/TreatmentAreaforClinicQueryCriteria.jsp" ;
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

	f_query_add_mod.document.forms[0].clinic_code_val.value			= f_query_add_mod.document.forms[0].clinic_code_res.value;
	f_query_add_mod.document.forms[0].treatment_area_code_val.value = f_query_add_mod.document.forms[0].treatment_area_code.value;
	f_query_add_mod.document.forms[0].long_desc_val.value			= f_query_add_mod.document.forms[0].long_desc.value;
	f_query_add_mod.document.forms[0].short_desc_val.value			= f_query_add_mod.document.forms[0].short_desc.value;
    f_query_add_mod.document.forms[0].priority_zone_val.value		= f_query_add_mod.document.forms[0].priority_zone.value;
	f_query_add_mod.document.forms[0].gender_val.value				= f_query_add_mod.document.forms[0].gender.value;
	if(f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn.disabled==false)
	{
		f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn.disabled=true;
		f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn_val.value = f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn.value;
		f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn.disabled=false;
	}
	if(f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn.disabled==true)
	{
		f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn.disabled=true;
		f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn_val.value = f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn.value;
		f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn.disabled=false;
	}
	f_query_add_mod.document.forms[0].eff_status_val.value			= f_query_add_mod.document.forms[0].eff_status.value;
// added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 start
var isAppearAsTabEnable=f_query_add_mod.document.forms[0].isAppearAsTabEnable.value;
if((isAppearAsTabEnable==true || isAppearAsTabEnable=='true' ) && f_query_add_mod.document.forms[0].AppearAsTab) {
	if(f_query_add_mod.document.forms[0].AppearAsTab.checked==true){
	var fields = new Array (f_query_add_mod.document.treatment_area_form.clinic_code,
							f_query_add_mod.document.treatment_area_form.treatment_area_code,
							f_query_add_mod.document.treatment_area_form.long_desc,
							f_query_add_mod.document.treatment_area_form.short_desc,
							f_query_add_mod.document.treatment_area_form.priority_zone,
							f_query_add_mod.document.treatment_area_form.Tap_Colour);
		 
	var names = new Array (getLabel("Common.Location.label","Common"),
						getLabel("eAE.TreatmentAreaCode.label","AE"),
						getLabel("Common.longdescription.label","Common"),
						getLabel("Common.shortdescription.label","Common"),
						getLabel("Common.PriorityZone.label","Common"),
						getLabel("eAE.TabColour.label","AE")
						);
	}
		else {  
	var fields = new Array (f_query_add_mod.document.treatment_area_form.clinic_code,
		 f_query_add_mod.document.treatment_area_form.treatment_area_code,
         f_query_add_mod.document.treatment_area_form.long_desc,
		 f_query_add_mod.document.treatment_area_form.short_desc,
		 f_query_add_mod.document.treatment_area_form.priority_zone);
        
	//var names = new Array ("Clinic","Treatment Area Code","Long Description","Short Description","Priority Zone");	
	var names = new Array (getLabel("Common.Location.label","Common"),getLabel("eAE.TreatmentAreaCode.label","AE"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.PriorityZone.label","Common"));	
	}
}
	else {  
	var fields = new Array (f_query_add_mod.document.treatment_area_form.clinic_code,
		 f_query_add_mod.document.treatment_area_form.treatment_area_code,
         f_query_add_mod.document.treatment_area_form.long_desc,
		 f_query_add_mod.document.treatment_area_form.short_desc,
		 f_query_add_mod.document.treatment_area_form.priority_zone);
        
	//var names = new Array ("Clinic","Treatment Area Code","Long Description","Short Description","Priority Zone");	
	var names = new Array (getLabel("Common.Location.label","Common"),getLabel("eAE.TreatmentAreaCode.label","AE"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.PriorityZone.label","Common"));	
	}
	// added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 end
	// For special Characters
	var fields1 = new Array (f_query_add_mod.document.treatment_area_form.treatment_area_code);
	var names1 = new Array (getLabel("eAE.TreatmentAreaCode.label","AE"));
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
		if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
			{
			    f_query_add_mod.document.forms[0].open_to_all_prac_for_clinic_yn.disabled = false;
				f_query_add_mod.document.treatment_area_form.submit();
			}
	 }

}

function getClinic(obj)  
{
	if(obj.value!='')
	{
        var values = obj.value.split("::");
		var cliniccode = values[0];
		var open_to_all_pract_yn = values[1];
		var gender = values[2];
		document.forms[0].clinic_code_res.value=cliniccode;
		if(gender!='' && gender!=null && gender!='NA')
		{
			var genderVal = document.forms[0].gender;
			while(genderVal.options.length > 1)
			genderVal.remove(1);
			
			var opt=document.createElement("OPTION");
			opt.text=getLabel("Common.male.label","Common");
			opt.value="M";
			if(gender=="M") 
			  {
				 opt.selected=true;
			  }
			document.forms[0].gender.add(opt);
			if(gender=="M") 
				document.forms[0].gender.disabled=true;

			var opt=document.createElement("OPTION");
			opt.text=getLabel("Common.female.label","Common");
			opt.value="F";
			if(gender=="F") 
			  {
				 opt.selected=true;
			  }
			document.forms[0].gender.add(opt);
			if(gender=="F") 
			  	  document.forms[0].gender.disabled=true;

  			var opt=document.createElement("OPTION");
			opt.text=getLabel("Common.unknown.label","Common");
			opt.value="U";
			if(gender=="U") 
			  {
				 opt.selected=true;
			  }
			document.forms[0].gender.add(opt);
			if(gender=="U") 
				document.forms[0].gender.disabled=true;
		}
		else
	    {
			var genderVal = document.forms[0].gender;
			while(genderVal.options.length > 1)
			genderVal.remove(1);

			document.forms[0].gender.disabled=false;
			var opt=document.createElement("OPTION");
			opt.text=getLabel("Common.male.label","Common");
			opt.value="M";
			document.forms[0].gender.add(opt);
			var opt=document.createElement("OPTION");
			opt.text=getLabel("Common.female.label","Common");
			opt.value="F";
			document.forms[0].gender.add(opt);
			var opt=document.createElement("OPTION");
			opt.text=getLabel("Common.unknown.label","Common");
			opt.value="U";
			document.forms[0].gender.add(opt);
		}
		if(open_to_all_pract_yn=='N')
		{
          	document.forms[0].open_to_all_prac_for_clinic_yn.checked=false;
			document.forms[0].open_to_all_prac_for_clinic_yn.disabled=false;
			document.forms[0].open_to_all_prac_for_clinic_yn_val.value='N';
		}
		else
		{
			document.forms[0].open_to_all_prac_for_clinic_yn.disabled=false;
			document.forms[0].open_to_all_prac_for_clinic_yn.checked=true;
			document.forms[0].open_to_all_prac_for_clinic_yn_val.value='Y';
		}
	}  // end of obj

}

  function chkValue(obj)
   { 
		var isAppearAsTabEnable=document.forms[0].isAppearAsTabEnable.value; // added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023
	  if(obj.checked==true)
       {
		  if(obj.name=='eff_status')
		   {
				obj.checked=true;
				obj.value='E';
           }
		   // added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 start
			else if((isAppearAsTabEnable==true || isAppearAsTabEnable=='true' ) && document.forms[0].AppearAsTab)
				{  
				if(obj.name=='AppearAsTab') 
					{
					obj.checked=true;
					obj.value='Y';
					document.forms[0].disp_man_tab_clr_gif.style.visibility='visible';
					document.forms[0].Tap_Colour.disabled=false;
					}
			}
		   // added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 end
		   else
		   {
				obj.checked=true;
				obj.value='Y';
		   }
       }
      else
      {
           if(obj.name=='eff_status')
		   {
				obj.checked=false;
				obj.value='D';
           }
		   // added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 start
       else if((isAppearAsTabEnable==true || isAppearAsTabEnable=='true' ) && document.forms[0].AppearAsTab)
				{
		     if(obj.name=='AppearAsTab') 
		   {
			  obj.checked=false;
				obj.value='N';
				document.forms[0].disp_man_tab_clr_gif.style.visibility='hidden';
				document.forms[0].Tap_Colour.disabled=true;
				document.forms[0].Tap_Colour.value='';
		   }
       }
		   // added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 end
		   else
		   {
				 obj.checked=false;
				 obj.value='N';
		   }
       }

   }

 /*  function loadGender(obj)
   {

       if(document.treatment_area_form.mode.value!="INSERT")
	   {
			var opt=document.createElement("OPTION");
			opt.text="Male";
			opt.value="M";
			if(obj=="M") opt.selected = true;
			document.forms[0].gender.add(opt);

			var opt=document.createElement("OPTION");
			opt.text="Female";
			opt.value="F";
			if(obj=="F") opt.selected = true;
			document.forms[0].gender.add(opt);

			var opt=document.createElement("OPTION");
			opt.text="Unknown";
			opt.value="U";
			if(obj=="U") opt.selected = true;
			document.forms[0].gender.add(opt);
	   }
   }
*/
   function changeCase(obj)
   {
		document.forms[0].treatment_area_code.value=obj.value.toUpperCase();
	}
   function setFocus()
	  {
		  if(document.forms[0].clinic_code.disabled==false)
			  document.forms[0].clinic_code.focus();
	  }
