async function confirmNRIC()
{

	var retVal =    new String(); 
	var dialogHeight= "13" ;
	var dialogWidth = "35" ;
	var status = "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var vplaceofbirth = '';
	var vdateofbirth = f_query_add_mod.patient_sub.ChangePatDtlForm.v_date_of_birth.value;
	
	var vbirthplacecode = f_query_add_mod.patient_sub.ChangePatDtlForm.v_birth_place_code.value;
	var vsex = f_query_add_mod.patient_sub.ChangePatDtlForm.v_sex.value;
	var vbirthplacedesc = f_query_add_mod.patient_sub.ChangePatDtlForm.v_birth_place_desc.value;
	var vage = f_query_add_mod.patient_sub.ChangePatDtlForm.v_age.value;
	var vmonths = f_query_add_mod.patient_sub.ChangePatDtlForm.v_months.value;
    var vdays = f_query_add_mod.patient_sub.ChangePatDtlForm.v_days.value;
	var vhours = f_query_add_mod.patient_sub.ChangePatDtlForm.v_hours.value;

	var dateofbirth = f_query_add_mod.patient_sub.ChangePatDtlForm.date_of_birth.value;
	var birthplacecode = f_query_add_mod.patient_sub.ChangePatDtlForm.place_of_birth_code.value;
	var sex = f_query_add_mod.patient_sub.ChangePatDtlForm.sex.value;
	var birthplacedesc = f_query_add_mod.patient_sub.ChangePatDtlForm.place_of_birth_desc.value;
	var age = f_query_add_mod.patient_sub.ChangePatDtlForm.b_age.value;
	var months = f_query_add_mod.patient_sub.ChangePatDtlForm.b_months.value;
	var days = f_query_add_mod.patient_sub.ChangePatDtlForm.b_days.value;
	var hours = f_query_add_mod.patient_sub.ChangePatDtlForm.b_hours.value;
	var placeofbirth = f_query_add_mod.patient_sub.ChangePatDtlForm.v_place_of_birth.value;
	if(f_query_add_mod.patient_sub.ChangePatDtlForm.v_place_of_birth!=null)
		vplaceofbirth = f_query_add_mod.patient_sub.ChangePatDtlForm.v_place_of_birth.value;
	var natidprompt = f_query_add_mod.patient_sub.ChangePatDtlForm.nat_id_prompt.value;	


	
	if(vbirthplacecode!=birthplacecode || placeofbirth!=vplaceofbirth || vsex!=sex || vage!=age || vmonths!=months || days!=vdays)
	{
		if(vbirthplacedesc=="" && vplaceofbirth!="")
			vbirthplacedesc = vplaceofbirth;
		if(birthplacedesc=="" && placeofbirth!="")
			birthplacedesc = placeofbirth;

		birthplacedesc = encodeURIComponent(birthplacedesc,'UTF-8');
		vbirthplacedesc = encodeURIComponent(vbirthplacedesc,'UTF-8');

		retVal =await window.showModalDialog( "../../eMP/jsp/showNRICValues.jsp?vdateofbirth="+vdateofbirth+"&dateofbirth="+dateofbirth+"&vsex="+vsex+"&sex="+sex+"&natidprompt="+natidprompt+"&birthplacecode="+birthplacecode+"&vbirthplacecode="+vbirthplacecode+"&birthplacedesc="+birthplacedesc+"&vbirthplacedesc="+vbirthplacedesc+"&age="+age+"&months="+months+"&days="+days+"&vage="+vage+"&vmonths="+vmonths+"&vdays="+vdays+"&place_of_birth="+placeofbirth+"&vhours="+vhours+"&hours="+hours,arguments,features);
	}
    
	if(retVal==0)
	{
	   return true;
	}
	else
	{
		if(f_query_add_mod.patient_sub.ChangePatDtlForm.national_id_no.disabled == false)
		  f_query_add_mod.patient_sub.ChangePatDtlForm.national_id_no.focus();		
		return false;
	}
}

function callChangePatApply() 
{

 
//Reinitialise the LocalErrors variable to erase the OLD errors
LocalErrors = '';
var canSave = new Boolean(true);
var splField = new Array();
var splFieldName = new Array();
if(f_query_add_mod.patient_sub.document.getElementById("r_country_desc").value=="")
	f_query_add_mod.patient_sub.document.getElementById("r_country_code").value='';
if(f_query_add_mod.patient_sub.document.getElementById("r_area_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("r_area_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("r_area").value='';
}
if(f_query_add_mod.patient_sub.document.getElementById("r_town_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("r_town_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("r_town").value='';
}
if(f_query_add_mod.patient_sub.document.getElementById("r_region_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("r_region_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("r_region").value='';
}
if(f_query_add_mod.patient_sub.document.getElementById("m_country_desc").value=="")
	f_query_add_mod.patient_sub.document.getElementById("m_country_code").value='';
if(f_query_add_mod.patient_sub.document.getElementById("m_area_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("m_area_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("m_area").value='';
}
if(f_query_add_mod.patient_sub.document.getElementById("m_town_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("m_town_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("m_town").value='';
}
if(f_query_add_mod.patient_sub.document.getElementById("m_region_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("m_region_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("m_region").value=''; 
}
if(f_query_add_mod.patient_sub.document.getElementById("contact1_res_area_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("contact1_res_area_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("n_area").value="";
}

if(f_query_add_mod.patient_sub.document.getElementById("contact1_res_town_code")!=null)
{	
if(f_query_add_mod.patient_sub.document.getElementById("contact1_res_town_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("n_town").value="";
}

if(f_query_add_mod.patient_sub.document.getElementById("contact1_region_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("contact1_region_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("n_region").value="";
}

if(f_query_add_mod.patient_sub.document.getElementById("next_country_desc").value=="")
	f_query_add_mod.patient_sub.document.getElementById("next_country_code").value='';

if(f_query_add_mod.patient_sub.document.getElementById("contact2_res_area_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("contact2_res_area_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("f_area").value="";
}
if(f_query_add_mod.patient_sub.document.getElementById("contact2_res_town_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("contact2_res_town_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("f_town").value="";
}

if(f_query_add_mod.patient_sub.document.getElementById("contact2_region_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("contact2_region_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("f_region").value="";
}
if(f_query_add_mod.patient_sub.document.getElementById("first_country_desc").value=="")
	f_query_add_mod.patient_sub.document.getElementById("first_country_code").value='';		
			
if(f_query_add_mod.patient_sub.document.getElementById("contact3_res_area_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("contact3_res_area_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("e_area").value="";
}
if(f_query_add_mod.patient_sub.document.getElementById("contact3_res_town_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("contact3_res_town_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("e_town").value="";
}

if(f_query_add_mod.patient_sub.document.getElementById("contact3_region_code")!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById("contact3_region_code").value=="")
	f_query_add_mod.patient_sub.document.getElementById("e_region").value="";
}
if(f_query_add_mod.patient_sub.document.getElementById("empyr_country_desc").value=="")
	{
	f_query_add_mod.patient_sub.document.getElementById("empyr_country_code").value='';
	}
			if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
			{
				
				splField = new Array(f_query_add_mod.patient_sub.document.getElementById("national_id_no"));
		        splFieldName = new Array(f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
			}  			

            var canSave = new Boolean(true);
            if(f_query_add_mod.patient_sub.document.getElementById("function_id").value == "NEWBORN_REG")
            {
                canSave = f_query_add_mod.patient_sub.SpecialCharCheck(splField, splFieldName, '',"A")
                if(!canSave)
                parent.commontoolbarFrame.location.href ='../../eMP/jsp/ChangepatdocsToolBar.jsp';
            }
            else
                canSave = f_query_add_mod.patient_sub.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/error.jsp")
            if ( canSave )
            {

// VARIABLE TO CHECK WHETHER ANY 1 ERROR IS ENCOUNTERED SO THAT FORM IS BLOCKED FROM SUBMITION
var errorsThere = new Boolean(false);
f_query_add_mod.patient_sub.document.getElementById("patient_id").value = f_query_add_mod.patient_main.document.getElementById("patient_id").value;
//TO CHECK THE PATIENT SEX IS NOT NULL
if (f_query_add_mod.patient_sub.document.getElementById("sex").selectedIndex == 0)
{
	
    if(f_query_add_mod.patient_sub.document.getElementById("sex").value=="")
	{
		canSave=checkForNull(getLabel('Common.gender.label','common'));			
	}
}
if ( canSave == false )
    errorsThere = true;
// Added on 27/08/2003 for checking not mull

if(f_query_add_mod.patient_sub.document.getElementById("race_required_yn").value == 'Y')
{
	if(f_query_add_mod.patient_sub.document.getElementById("image1").style.visibility == 'visible') {	

		if(f_query_add_mod.patient_sub.document.getElementById("race_desc").value=="") {
			canSave=checkForNull(getLabel('Common.race.label','common'));
		}	
	}
}

if ( canSave == false )
errorsThere = true;	
  if (  f_query_add_mod.patient_sub.document.getElementById("name_prefix") != null ) 
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix").value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById("sex").value != '' )
					{	
                        canSave = checkPatSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;	 
			
            if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix") != null )
            {
                if (  f_query_add_mod.patient_sub.document.getElementById("name_suffix").value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById("sex").value != '' )
					{	
                        canSave = checkPatSuffixSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;	
			
//Mandatory check for National ID ADDED BY kumar on 16/03/2003 
if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y" && f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value == "Y")
{
	if(f_query_add_mod.patient_sub.document.getElementById("called_from_newborn"))
	{
		if(f_query_add_mod.patient_sub.document.getElementById("called_from_newborn").value!='Y')
		{
			if (f_query_add_mod.patient_sub.document.getElementById("id_type").value == 'N' || f_query_add_mod.patient_sub.document.getElementById("nat_id_reqd_all_series").value=='Y')
			{
			  canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("national_id_no"), f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
			}
		}
	}
}

if ( canSave == false )
	errorsThere = true;

//End of Addition
// FIRST CHECK FOR THE PATIENT ID
if ( f_query_add_mod.patient_sub.document.getElementById("pat_no_gen_yn").value == 'N' )
{
	if(f_query_add_mod.patient_main.document.getElementById("patient_id").value=="")
		{
			canSave=checkForNull(getLabel('Common.patientId.label','common')); 
		}
    if ( canSave == false )
        errorsThere = true;
}

if ( canSave == false )
    errorsThere = true;	   

// CHECKING FOR PATIENT DATE OF BIRTH
	if(f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value=="")
	{
		canSave = checkForNull(getLabel('Common.birthDate.label','common')); 
	}
if ( canSave == false )
    errorsThere = true;
var dflt_patient_name = f_query_add_mod.patient_sub.document.getElementById("dflt_patient_name").value;
    if ( f_query_add_mod.patient_sub.document.getElementById("first_name") != null && trimString(f_query_add_mod.patient_sub.document.getElementById("first_name").value)== "")
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("first_name_reqd_yn") != null )
                    if ( f_query_add_mod.patient_sub.document.getElementById("first_name_reqd_yn").value == 'Y' )
						f_query_add_mod.patient_sub.document.getElementById("first_name").value = dflt_patient_name; 					
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("second_name") != null && trimString(f_query_add_mod.patient_sub.document.getElementById("second_name").value)== "")
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("second_name_reqd_yn") != null)
                if ( f_query_add_mod.patient_sub.document.getElementById("second_name_reqd_yn").value == 'Y' )
				f_query_add_mod.patient_sub.document.getElementById("second_name").value = dflt_patient_name;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("third_name") != null && trimString(f_query_add_mod.patient_sub.document.getElementById("third_name").value)== "")
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("third_name_reqd_yn") != null)
                if ( f_query_add_mod.patient_sub.document.getElementById("third_name_reqd_yn").value == 'Y' )
   				f_query_add_mod.patient_sub.document.getElementById("third_name").value = dflt_patient_name;
			}

            if ( f_query_add_mod.patient_sub.document.getElementById("family_name") != null && trimString(f_query_add_mod.patient_sub.document.getElementById("family_name").value)== "")
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("family_name_reqd_yn") != null)
                if ( f_query_add_mod.patient_sub.document.getElementById("family_name_reqd_yn").value == 'Y' )
				f_query_add_mod.patient_sub.document.getElementById("family_name").value = dflt_patient_name;
            }

			if ( f_query_add_mod.patient_sub.document.getElementById("first_name") != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById("first_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("first_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("first_name"),f_query_add_mod.patient_sub.document.getElementById("first_name_prompt").value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById("second_name") != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById("second_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("second_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("second_name"),f_query_add_mod.patient_sub.document.getElementById("second_name_prompt").value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById("third_name") != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById("third_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("third_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("third_name"),f_query_add_mod.patient_sub.document.getElementById("third_name_prompt").value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById("family_name") != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById("family_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("family_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("family_name"),f_query_add_mod.patient_sub.document.getElementById("family_name_prompt").value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix") != null )
			{
				if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_reqd_yn").value == 'Y' )
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_suffix"),f_query_add_mod.patient_sub.document.getElementById("name_suffix_prompt").value);
				if ( canSave == false )
					errorsThere = true;
			}

			if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix") != null )
			{
				
				if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_img")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_img").style.visibility=='visible'))
				{
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_prompt").value);
				}
				if ( canSave == false )
					errorsThere = true;
			}

			  // CHECKING FOR PATIENT NAME
          // CHECKING FOR PATIENT NAME
            if(trimString(f_query_add_mod.patient_main.document.getElementById("patient_name").value)=="")
			{
				var patForm = f_query_add_mod.patient_sub.document.all;
				var pat_name = f_query_add_mod.patient_main.document.getElementById("patient_name");
				if (patForm.first_name)
				{
					pat_name.value = trimString(patForm.first_name.value) ;
				}
				if (patForm.second_name)
				{
					pat_name.value  = pat_name.value + ' ' +trimString(patForm.second_name.value) ;
				}
				if (patForm.third_name)
				{
					pat_name.value  =  pat_name.value + ' ' + trimString(patForm.third_name.value) ;
				}
				if (patForm.family_name)
				{
					pat_name.value  =  pat_name.value +' ' + trimString(patForm.family_name.value) ;
				}
				if (trimString(f_query_add_mod.patient_main.document.getElementById("patient_name").value)=="")
					canSave=checkForNull(getLabel('Common.PatientName.label','common'));
			}
			if(f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang") && f_query_add_mod.patient_sub.document.getElementById("pat_name_in_loc_lang_reqd_yn").value == "Y") {
				if(trimString(f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value)=="")
				{
					var patForm = f_query_add_mod.patient_sub.document.all;
					var pat_name = f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang");
					if (patForm.first_name_oth_lang)
					{
						pat_name.value = trimString(patForm.first_name_oth_lang.value) ;
					}
					if (patForm.second_name_oth_lang)
					{
						pat_name.value  = pat_name.value + ' ' +trimString(patForm.second_name_oth_lang.value) ;
					}
					if (patForm.third_name_oth_lang)
					{
						pat_name.value  =  pat_name.value + ' ' + trimString(patForm.third_name_oth_lang.value) ;
					}
					if (patForm.family_name_oth_lang)
					{
						pat_name.value  =  pat_name.value +' ' + trimString(patForm.family_name_oth_lang.value) ;
					}

					if(f_query_add_mod.patient_sub.document.getElementById("pat_name_in_loc_lang_reqd_yn").value == "Y"){
						if (trimString(f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value)=="")
							canSave=checkForNull(getLabel('eMP.PatientNameLocal.label','MP'));
					}
				}
				if( f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang") != null)
					f_query_add_mod.patient_sub.document.getElementById("patient_name_loc_lang").value = f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value;

			}
		 
            if ( canSave == false )
                errorsThere = true;

			f_query_add_mod.patient_sub.document.getElementById("patient_name").value = f_query_add_mod.patient_main.document.getElementById("patient_name").value;
			
	


            if ( f_query_add_mod.patient_sub.document.getElementById("first_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("first_oth_name_reqd_yn") != null)
                    if ( f_query_add_mod.patient_sub.document.getElementById("first_oth_name_reqd_yn").value == 'Y' )
                        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("first_name_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("first_name_oth_prompt").value);
                    if ( canSave == false )errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("second_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("second_oth_name_reqd_yn") != null)
                if ( f_query_add_mod.patient_sub.document.getElementById("second_oth_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("second_name_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("second_name_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("third_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("third_oth_name_reqd_yn") != null)
                if ( f_query_add_mod.patient_sub.document.getElementById("third_oth_name_reqd_yn").value == 'Y' )
                    canSave =checkForNull1(f_query_add_mod.patient_sub.document.getElementById("third_name_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("third_name_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("family_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("family_oth_name_reqd_yn") != null)
                if ( f_query_add_mod.patient_sub.document.getElementById("family_oth_name_reqd_yn").value == 'Y' )
                    canSave =checkForNull1(f_query_add_mod.patient_sub.document.getElementById("family_name_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("family_name_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang") != null )
            {
                 if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }


if( f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang") != null)
    f_query_add_mod.patient_sub.document.getElementById("patient_name_loc_lang").value = f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value;

// CHECKING FOR ALTERNATE ID'S

if(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no") != null)
{
	if ((f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").readOnly == false) &&  (f_query_add_mod.patient_sub.document.getElementById("alt1_gif").style.visibility=='visible')	)
 
	{
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no"), f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value);
	}
    if(canSave == false)
        errorsThere = true;
}

if ( f_query_add_mod.patient_sub.document.getElementById("alt_id2_no") != null )
{
    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id2_reqd_yn").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("alt_id2_no").readOnly == false && f_query_add_mod.patient_sub.document.getElementById("alt_id2_no").disabled == false)
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id2_no"), f_query_add_mod.patient_sub.document.getElementById("altId2Desc").value);
    if ( canSave == false )
        errorsThere = true;
}

if ( f_query_add_mod.patient_sub.document.getElementById("alt_id3_no") != null )
{
    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id3_reqd_yn").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").readOnly == false && f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").disabled == false)
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id3_no"), f_query_add_mod.patient_sub.document.getElementById("altId3Desc").value);
    if ( canSave == false )
        errorsThere = true;
}

if ( f_query_add_mod.patient_sub.document.getElementById("alt_id4_no") != null )
{
    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id4_reqd_yn").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("alt_id4_no").readOnly == false && f_query_add_mod.patient_sub.document.getElementById("alt_id4_no").disabled == false)
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id4_no"), f_query_add_mod.patient_sub.document.getElementById("altId4Desc").value);
    if ( canSave == false )
        errorsThere = true;
}
if ( f_query_add_mod.patient_sub.document.getElementById("relationship_to_head_desc"))
{
	if ( !f_query_add_mod.patient_sub.document.getElementById("relationship_to_head_desc").disabled)
	{
		if  (f_query_add_mod.patient_sub.document.getElementById("family_org_membership"))
		{
			if  ((f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value != 1)  && (f_query_add_mod.patient_sub.document.getElementById("rel").style.visibility=='visible'))
			{
				if(f_query_add_mod.patient_sub.document.getElementById("relationship_to_head_desc").value=="")
				{
				canSave = checkForNull(getLabel('Common.relationship.label','common'));
//				checkForNull(canSave);
				}
				if ( canSave == false )
					errorsThere = true;
			}
		}
		else
		{
			if(f_query_add_mod.patient_sub.document.getElementById("relationship_to_head_desc").value=="" && f_query_add_mod.patient_sub.document.getElementById("rel").style.visibility=='visible')
			{
				canSave = checkForNull(getLabel('Common.relationship.label','common'));
				
			}
		if ( canSave == false )
			errorsThere = true;
		 }
	}

	if(f_query_add_mod.patient_sub.document.getElementById("relationship_level1_desc"))
	{
		if(f_query_add_mod.patient_sub.document.getElementById("relationship_level1_desc").value=="")
		{
			canSave=checkForNull(getLabel('eMP.RelationshipLevel.label','common'));
		}
		if ( canSave == false )
			errorsThere = true;
	}
}
/* CHECKING FOR Maintain Organization - 
				Membership/Organization/Alternate Id 1  Added by Vinod 2/27/2006*/

/*
if (f_query_add_mod.patient_sub.document.getElementById("family_org_membership"))
{
	if ( (f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value == '1')  )
	{
		if (f_query_add_mod.patient_sub.document.getElementById("name_prefix_img").style.visibility=='visible') 
		{
			canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_prompt").value);
				if ( canSave == false )
				errorsThere = true;
		}
		if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth").style.visibility=='visible'))
		{
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_prompt").value);
				if ( canSave == false )
					errorsThere = true;
		}
	}
}
*/

if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth").style.visibility=='visible'))
{
	canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_prompt").value);
	if ( canSave == false )
		errorsThere = true;
}

if ( (f_query_add_mod.patient_sub.document.getElementById("entitlement_by_pat_cat_yn").value == 'Y') && (f_query_add_mod.patient_sub.document.getElementById("exp_val_appl_yn").value == 'Y') &&(f_query_add_mod.patient_sub.document.getElementById("imgCatExpDateMan").style.visibility=='visible')  )
{
	if(f_query_add_mod.patient_sub.document.getElementById("pat_cat_code_exp_date").value=="")
		{
				canSave=checkForNull(getLabel('eMP.categoryexpirydate.label','MP'));

			}
		if ( canSave == false )
		errorsThere = true;
}
			
if (f_query_add_mod.patient_sub.document.getElementById("family_org_id_accept_yn").value == 'Y')
{
	if  ( (f_query_add_mod.patient_sub.document.getElementById("pat_cat_code")) && (f_query_add_mod.patient_sub.document.getElementById("entitlement_by_pat_cat_yn").value == 'Y') )
	{
		if(f_query_add_mod.patient_sub.document.getElementById("pat_cat_code").value=="")
			{
				canSave=checkForNull(getLabel('Common.category.label','common'));

			}
			if ( canSave == false )
			errorsThere = true;
   }

	if (f_query_add_mod.patient_sub.document.getElementById("family_org_membership"))
	{	
	  if(f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value=="")
		  {
				canSave=checkForNull(getLabel('eMP.membership.label','MP'));

			}
	  if ( canSave == false )
		errorsThere = true;

	  if (f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value != 4)
	   {
			  if (f_query_add_mod.patient_sub.document.getElementById("alt1_gif").style.visibility=='visible')
			  {
				  canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no"),f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value);
				  if ( canSave == false )
					errorsThere = true;
			  }
			  if (f_query_add_mod.patient_sub.document.getElementById("org_sub_org").style.visibility=='visible')
			  {
				if(f_query_add_mod.patient_sub.document.getElementById("organization").value=="")
					{
					canSave=checkForNull(getLabel('Common.Organization.label','Common'));

					}
				if ( canSave == false )
				errorsThere = true;
				  
				if(f_query_add_mod.patient_sub.document.getElementById("sub_organization").value=="")
					{
					canSave=checkForNull(getLabel('eMP.suborgn.label','MP'));

					}
				if ( canSave == false )
				errorsThere = true;
			  }	
		}
		if ( (f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value != 1)	&&(f_query_add_mod.patient_sub.document.getElementById("mem_type_db").value == 1) )
		{	
			 var alt_id1_db_val = f_query_add_mod.patient_sub.document.getElementById("alt_id1_db").value;
			 var alt_id1_val = f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").value;
			 if ( alt_id1_db_val == alt_id1_val)
			 {
				 var msg = f_query_add_mod.patient_sub.getMessage("INVALID_ALT_ID",'MP');
				 msg.replace("$",f_query_add_mod.patient_sub.document.getElementById("alt_id1_desc").value)
				 alert(msg);
				 f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").focus();
				 parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			 }
		}
	  }
   }   

/* End of validations added on 2/27/2006*/

if(f_query_add_mod.patient_sub.document.getElementById("doc_id1").value !="")
{
	if (f_query_add_mod.patient_sub.document.getElementById("doc_num1").value == "")
    {
        if(f_query_add_mod.patient_sub.document.getElementById("doc_num1").value=="")
		{
			canSave=checkForNull(getLabel('Common.documentno.label','common')+" 1");  			
		}
    }
}
if ( canSave == false )
    errorsThere = true;

if(f_query_add_mod.patient_sub.document.getElementById("doc_id2").value !="")
{
	
    if (f_query_add_mod.patient_sub.document.getElementById("doc_num2").value == "")
    {
        if(f_query_add_mod.patient_sub.document.getElementById("doc_num2").value=="")
			{
			canSave=checkForNull(getLabel('Common.documentno.label','common')+"2");

		}
    }
}
if ( canSave == false )
    errorsThere = true;

if(f_query_add_mod.patient_sub.document.getElementById("doc_id3").value !="")
{	
    if (f_query_add_mod.patient_sub.document.getElementById("doc_num3").value == "")
    {
       if(f_query_add_mod.patient_sub.document.getElementById("doc_num3").value=="")
		{
			canSave=checkForNull(getLabel('Common.documentno.label','common')+"3");
			
		}
    }
}
if ( canSave == false )
    errorsThere = true;

if(f_query_add_mod.patient_sub.document.getElementById("doc_id4").value !="")
{

    if (f_query_add_mod.patient_sub.document.getElementById("doc_num4").value == "")
    {
        if(f_query_add_mod.patient_sub.document.getElementById("doc_num4").value=="")
		{
			canSave=checkForNull(getLabel('Common.documentno.label','common')+"4");
			
		}
    }
} 

if ( canSave == false )
    errorsThere = true;


if(f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value!="") {
	if (!f_query_add_mod.patient_sub.isBeforeNow(f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value,"DMY",localeName)) 
	{
		LocalErrors += f_query_add_mod.patient_sub.getMessage('DOB_CHECK','Common') + ' <br>';
		canSave = false;
	}
}
//Added by kumar on 16/03/2003 for National ID Validation with Date of Birth & Sex.
if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
{		
	if (f_query_add_mod.patient_sub.document.getElementById("national_id_no").value != "" && f_query_add_mod.patient_sub.document.getElementById("nat_data_source_id") != null)
	{
		if (f_query_add_mod.patient_sub.document.getElementById("nat_data_source_id").value=="NRIC" && f_query_add_mod.patient_sub.document.getElementById("invoke_routine").value=="Y")
		{
			if (f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value != '')
			{
				var dob = f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value;
				dob = dob.substring(8,10) + dob.substring(3,5)+dob.substring(0,2);
				if (f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.length >= 6)
				{
					if (dob!=f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.substring(0,6))
					{
						var natmsg = f_query_add_mod.patient_sub.getMessage("MISMATCH_NAT_DOB",'MP');
						natmsg = natmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
						LocalErrors += natmsg+ ' <br>';						
						canSave =false;
					}
				}
				if (f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.length >= 12)
				{
					var sexIdent = f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.substring(8,12);
					if (!isNaN(sexIdent))
					{
						var sexIdent = f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.substring(11,12);
						if (parseInt(sexIdent) == 1 || parseInt(sexIdent) == 3 || parseInt(sexIdent) == 5 || parseInt(sexIdent) == 7 || parseInt(sexIdent) == 9)
						{ 
							sexIdent = "M";
						}
						else
							sexIdent = "F";
						
						if (sexIdent!=f_query_add_mod.patient_sub.document.getElementById("sex").value)
						{
							var natmsg = f_query_add_mod.patient_sub.getMessage("MISMATCH_NAT_SEX",'MP');
							natmsg = natmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							LocalErrors += natmsg+ ' <br>';							
							canSave =false;
						}
					}
					else
					{
						var natmsg = f_query_add_mod.patient_sub.getMessage("NAT_ID_9_12",'MP');
						natmsg = natmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
						LocalErrors += natmsg+ ' <br>';							
						canSave =false;
					}
				}
			}
		}
	}
}
//End of Addition

//Nationality Validation
			if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
			{ 
				if(f_query_add_mod.patient_sub.document.getElementById("nationality_code").value == f_query_add_mod.patient_sub.document.getElementById("dflt_nationality_code").value)
				{
					if((f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value == "N") || (f_query_add_mod.patient_sub.document.getElementById("legal").value == "N"))
					{
						var resmsg = f_query_add_mod.patient_sub.getMessage("RES_STATUS_FOR_CITIZEN",'MP');
						resmsg = resmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById("nationality_desc").value);
						alert(resmsg);
						errorsThere = true;
						canSave = false;

					}
				}
			}
			if(f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value == "N")
			{
				if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
				{ 
					if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.length > 0)
					{
						
						var nat_id_prmt_1=f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value;
					
						var msg1=f_query_add_mod.patient_sub.getMessage("NRIC_FOR_NONCITIZEN",'MP');
						msg1=msg1.replace('$',nat_id_prmt_1)
						alert(msg1);
						//alert(f_query_add_mod.patient_sub.getMessage("NRIC_FOR_NONCITIZEN",'MP'));
						f_query_add_mod.patient_sub.document.getElementById("national_id_no").disabled = false;
						
						canSave =false;
						errorsThere = true;
					}
				}
			}	
			var dob1 = f_query_add_mod.patient_sub.document.getElementById("contact1_birth_date").value;
			dob1 = dob1.substring(8,10) + dob1.substring(3,5)+dob1.substring(0,2);
			if (f_query_add_mod.patient_sub.document.getElementById("contact1_new_nat_id_no").value.length >= 6)
			{
				if ( (f_query_add_mod.patient_sub.document.getElementById("nat_data_source_id").value=="NRIC") && (f_query_add_mod.patient_sub.document.getElementById("invoke_routine").value=="Y") &&  (dob1!=f_query_add_mod.patient_sub.document.getElementById("contact1_new_nat_id_no").value.substring(0,6)) )
				{
					var natmsg = f_query_add_mod.frames[1].getMessage('MISMATCH_NAT_DOB','MP');
					natmsg = natmsg.replace('#', f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
					LocalErrors += natmsg + ' ' +  getLabel('Common.in.label','common')+ " " +getLabel('Common.nextofkin.label','common')+' <br>';
					canSave =false;
				}
			}
			if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
			{ 
				if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.length>0)
				{
					if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value!="" && f_query_add_mod.patient_sub.document.getElementById("contact1_new_nat_id_no").value!="")
					{
						if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value == f_query_add_mod.patient_sub.document.getElementById("contact1_new_nat_id_no").value)
						{
							var resmsg = f_query_add_mod.patient_sub.getMessage("NRIC_CANNOT_BE_SAME",'MP');
							resmsg = resmsg.replace('#',getLabel("Common.nextofkin.label","Common"));
							resmsg = resmsg.replace('$',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							resmsg = resmsg.replace('~',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);

							alert(resmsg);
							errorsThere = true;
							canSave = false;
						}
					}
					if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value!="" && f_query_add_mod.patient_sub.document.getElementById("contact2_nat_id_no").value!="")
					{
						if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value == f_query_add_mod.patient_sub.document.getElementById("contact2_nat_id_no").value)
						{
							var resmsg = f_query_add_mod.patient_sub.getMessage("NRIC_CANNOT_BE_SAME",'MP');
							resmsg = resmsg.replace('#',getLabel("Common.firsttonotify.label","Common"));
							resmsg = resmsg.replace('$',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							resmsg = resmsg.replace('~',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							alert(resmsg);
							errorsThere = true;
							canSave = false;
						}
					}
				}
			}

if(f_query_add_mod.patient_sub.document.getElementById("nationality_code").value == ''){
	f_query_add_mod.patient_sub.document.getElementById("nationality_code").value ='';
}

if(f_query_add_mod.patient_sub.document.getElementById("nationality_desc").value=='')
		f_query_add_mod.patient_sub.document.getElementById("nationality_code").value='';


if (f_query_add_mod.patient_sub.document.getElementById("nationality_code").value == '')
{
	if(f_query_add_mod.patient_sub.document.getElementById("nationality_code").value=="")
{
			canSave=checkForNull(getLabel('Common.nationality.label','common'));

		}
}
if ( canSave == false )
	errorsThere = true;

//Added for Maximum age validation
var maxAge = f_query_add_mod.patient_sub.document.getElementById("max_patient_age").value;
var actAge = f_query_add_mod.patient_sub.document.getElementById("b_age").value;
var actMonth = f_query_add_mod.patient_sub.document.getElementById("b_months").value;
var actDay = f_query_add_mod.patient_sub.document.getElementById("b_days").value;
if (maxAge != '')
{
	if (parseInt(actAge) > parseInt(maxAge) || 
	   ((parseInt(actAge) == parseInt(maxAge)) && (parseInt(actMonth) > 0 || parseInt(actDay) > 0)))
	{
		LocalErrors += f_query_add_mod.patient_sub.getMessage("MAX_PATIENT_AGE",'MP')+" "+maxAge+" "+getLabel("Common.Years.label","common")+ "<br>";
		canSave = false;
	}
}
// Validation for Financial Details on 21/8/2002 by kumar
if (f_query_add_mod.patient_sub.document.getElementById("bl_install_yn").value=='Y')
{
	if (f_query_add_mod.patient_sub.document.getElementById("bl_success").value=='N')
	{
		LocalErrors += f_query_add_mod.patient_sub.getMessage("FINANCIAL_DET_MANDATORY",'MP') + ' <br>';
		canSave = false;
	}
	if(canSave == true)
	{
		if(f_query_add_mod.patient_sub.document.forms[0].dflt_nat_id_chk_val.value != f_query_add_mod.patient_sub.document.forms[0].nationality_code.value)
		{
			LocalErrors += f_query_add_mod.patient_sub.getMessage("NATIONALITY_CHANGED",'MP') + ' <br>';
			canSave = false;
		}
	}
}

//end of validation
//Added on 04/01/2005 for checking the NRIC

if(canSave == true && errorsThere == false)
{
	if(f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
	{
		if(f_query_add_mod.patient_sub.ChangePatDtlForm.national_id_no)	{
			if(f_query_add_mod.patient_sub.ChangePatDtlForm.national_id_no.value!="")
			{	
			   if(confirmNRIC())
				{
					canSave = true;
					errorsThere = false;
				}
				else
				{
					canSave = false;
					errorsThere = true;
				}
			}
		}
	}
}

//////////////////validation for Gender And Date of Birth if the patient id is Mother Patient id and national id is null and if called from direct function //////////////////////

	var count = f_query_add_mod.patient_sub.ChangePatDtlForm.count.value;
	var patAge = f_query_add_mod.patient_sub.ChangePatDtlForm.b_age.value;
	var nb_mother_cutoff_age = f_query_add_mod.patient_sub.ChangePatDtlForm.nb_mother_cutoff_age.value;

	if( (f_query_add_mod.patient_sub.ChangePatDtlForm.function_id.value != 'NEWBORN_REG') && (parseInt(count) > 0))
	{  
		if(f_query_add_mod.patient_sub.ChangePatDtlForm.sex.value != 'F')
		{  
			LocalErrors += f_query_add_mod.patient_sub.getMessage("PAT_SEX_NOT_CHANGE",'MP') + ' <br>';
			
			canSave = false;
			errorsThere = true;
		}

		if(parseInt(patAge) < parseInt(nb_mother_cutoff_age))
		{  
			LocalErrors += f_query_add_mod.patient_sub.getMessage("PAT_DOB_NOT_CHANGE",'MP') + ' <br>';
			
			canSave = false;
			errorsThere = true;
		}  
	}

  // Added by Sethu for KDAH-CRF-0362

CheckForeKYCValidate();
///////////end of validation.///////////////////////
if ( canSave == true && errorsThere == false )
{

   
        dis_list = new Array();
        for(i=0;i<f_query_add_mod.patient_sub.ChangePatDtlForm.elements.length;i++)
         {
            var ele = f_query_add_mod.patient_sub.ChangePatDtlForm.elements[i]
            if(ele.disabled)
            {
                ele.disabled=false
                dis_list[i]=ele
            }
         }


        if(f_query_add_mod.patient_sub.document.forms[0].dflt_alt_id1_in_emp_id_yn.value=='Y' && f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").value=='')
		{
			f_query_add_mod.patient_sub.document.getElementById("empyr_eid").value = f_query_add_mod.patient_sub.document.forms[0].patient_employee_id.value;
		}
		if(f_query_add_mod.patient_sub.document.getElementById("accept_pw_in_chng_pat_dtl_yn").value == "Y")
		{
			var arguments = "";
			var dialogHeight = "5";
			var dialogWidth = "15";
			var status = "no";
			var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eMP/jsp/ChangePatAcceptPassword.jsp",arguments,features);
			
			if(retVal == true)
			{
				f_query_add_mod.patient_sub.document.ChangePatDtlForm.submit();
			}
			else
			{
				messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			}
		}
		else
		{
			f_query_add_mod.patient_sub.document.ChangePatDtlForm.submit();
		}
	
}
else
{ 
	var sStyle = f_query_add_mod.patient_sub.document.forms[0].sStyle.value;
 if(f_query_add_mod.patient_sub.document.getElementById("function_id").value == '')
 { 
        var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><head><META HTTP-EQUIV='Content-Type' CONTENT='text/html;charset=UTF-8'>" +
                "</head><body onKeyDown='lockKey()'><form name='f' id='f' method='post' action='../../eCommon/jsp/error.jsp'>"+
                "<input type='hidden' name='err_num' id='err_num' value=\""+LocalErrors+"\">"
                "</form></body></html>" ;
            messageFrame.document.body.insertAdjacentHTML('afterbegin',s);
            messageFrame.document.f.submit();
 }
else
    {
        var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head>" +
                    "<body class='message' onKeyDown='lockKey()'><script> document.writeln(\""+LocalErrors+"\");"+
                    " parent.commontoolbarFrame.location.href ='../../eMP/jsp/ChangepatdocsToolBar.jsp'; "+
                "</script></body>" +
                "</html>"
	   messageFrame.document.open('text/html', 'replace');
       messageFrame.document.writeln(s);
    }
}
}

}

function callApply()
{ 

	if(f_query_add_mod.patient_sub.document.getElementById("patient_id").value!=null && f_query_add_mod.patient_sub.document.getElementById("patient_id").value!="")
	{
		callChangePatApply();
	}
	else
	{
		
	var sStyle=f_query_add_mod.patient_sub.document.getElementById("sStyle").value;
	
	if(f_query_add_mod.patient_sub !=null)
    { 
		
		if(f_query_add_mod.patient_sub.document.getElementById("relationship_to_head_desc"))
		{
			f_query_add_mod.patient_sub.document.getElementById("relationship_to_head_desc").disabled=false;		
		}
		
		if(multipleclicks=='false')
        {
            multipleclicks='true';
            LocalErrors = '';
			
            var Alt_error= new String();
			var splField = new Array();
			var splFieldName = new Array();
            if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
			{ 
				splField = new Array(f_query_add_mod.patient_main.document.getElementById("patient_id"),
		           f_query_add_mod.patient_sub.document.getElementById("national_id_no"));
				splFieldName = new Array(getLabel("Common.patientId.label","common"),f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
			}
			else
			{
				splField = new Array(f_query_add_mod.patient_main.document.getElementById("patient_id"));
				splFieldName = new Array(getLabel("Common.patientId.label","common"));
			}
			
            if(f_query_add_mod.patient_sub.document.getElementById("family_link_no") != null)
            {
                splField[splField.length] = f_query_add_mod.patient_sub.document.getElementById("family_link_no")
                splFieldName[splFieldName.length]   = getLabel("eMP.HeadPatientID.label","MP");
            }
            var canSave = new Boolean(true);

			 if ( f_query_add_mod.patient_sub.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/error.jsp") )
            {
                var errorsThere = new Boolean(false);
				if( f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang") != null)	  
				{
					f_query_add_mod.patient_sub.document.getElementById("patient_name_loc_lang").value = f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value;		  
				}
            f_query_add_mod.patient_sub.document.getElementById("patient_id").value = f_query_add_mod.patient_main.document.getElementById("patient_id").value;
		    if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
			{
				/*Added by Dharma on Feb 13th 2017 against GDOH-SCF-0244 [IN:063491] Start*/ 
				var isNatIdMandatory			= f_query_add_mod.patient_sub.document.getElementById("isNatIdMandatory").value;
				var pat_ser_grp_code			= f_query_add_mod.patient_sub.document.getElementById("pat_ser_grp_code").value;
				var nat_id_pat_ser_grp			= f_query_add_mod.patient_sub.document.getElementById("nat_id_pat_ser_grp").value;
				if(isNatIdMandatory=="Y" && pat_ser_grp_code==nat_id_pat_ser_grp){
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("national_id_no"), f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
				}else{
					if((isNatIdMandatory!="Y")){
						/*Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491] End*/
				if (f_query_add_mod.patient_sub.document.getElementById("patient_group").value == 'N' || f_query_add_mod.patient_sub.document.getElementById("nat_id_reqd_all_series").value=='Y')
				{
					if(f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value == "Y")
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("national_id_no"), f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
					
				}
				else
				{
					pat_ser_grp_obj = f_query_add_mod.patient_sub.document.getElementById("pat_ser_grp_code")

					if(f_query_add_mod.patient_sub.document.getElementById("nat_id_reqd_all_series").value=='N' && f_query_add_mod.patient_sub.pat_sergrp_id_types[pat_ser_grp_obj.selectedIndex] == "N")
					{
						if(f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value == "Y")
						canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("national_id_no"),f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							}
						}	
					}
				}				
			}

            if ( canSave == false )
                errorsThere = true;

		   if(f_query_add_mod.patient_sub.document.getElementById("sex").value=="")
			{
				canSave=checkForNull(getLabel('Common.gender.label','common'));
			}

            if ( canSave == false )
                errorsThere = true;
			if (f_query_add_mod.patient_sub.document.getElementById("pat_ser_grp_code").value=="")
			{
				
				canSave=checkForNull(getLabel('eMP.PatientSeries.label','MP'));
			}

            if ( canSave == false )
                errorsThere = true;	
 
            /*Below line added for this CRF GHL-CRF-0332 [IN:042060]*/ 
			var tempflagchk = new Boolean(false);	
			
			if(f_query_add_mod.patient_sub.document.getElementById("alt_id1_reqd_yn").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("alt_id1_man_non_ctz") && f_query_add_mod.patient_sub.document.getElementById("alt_id1_man_non_ctz").value=="true")
			{
				if(f_query_add_mod.patient_sub.document.getElementById("alt1_gif").style.visibility == 'visible') {	

					if(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").value=="")
					{
						 canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no"),f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value);
					}		 
				}
				if ( canSave == false ){
					errorsThere = true;
					tempflagchk=true;
				}	
			}
			
				if(f_query_add_mod.patient_sub.document.getElementById("alt_date1_reqd_yn").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("alt_id1_man_non_ctz") && f_query_add_mod.patient_sub.document.getElementById("alt_id1_man_non_ctz").value=="true")
			{
				if(f_query_add_mod.patient_sub.document.getElementById("alt1_exp_date1").style.visibility == 'visible') {	

					if(f_query_add_mod.patient_sub.document.getElementById("altidexpdate1").value=="")
					{
						canSave=checkForNull(getLabel('Common.expiryDate.label','common'));
					}		 
				}
				if ( canSave == false )
					errorsThere = true;
			}
			
          //End this CRF GHL-CRF-0332 [IN:042060]
		  /*Below line added for this CRF GDOH-CRF-0029 [IN:048764]*/ 

	if(f_query_add_mod.patient_sub.document.getElementById("disas_regn_date_time").value=="")
		{
		var regdate=getLabel('Common.RegistrationDate.label','common')+" "+getLabel('Common.time.label','common');
        canSave=checkForNull(regdate);
		}
    if ( canSave == false )
        errorsThere = true;

if((f_query_add_mod.patient_sub.document.getElementById("disas_regn_date_time") && f_query_add_mod.patient_sub.document.getElementById("disas_regn_date_time").value!="") && (f_query_add_mod.patient_sub.document.getElementById("disas_regn_date_time") && f_query_add_mod.patient_sub.document.getElementById("Birth_Date").value!="")){
       var subStr=f_query_add_mod.patient_sub.document.getElementById("disas_regn_date_time").value;
	   var localeName=f_query_add_mod.patient_sub.document.getElementById("localeName").value;
       var regdateFormat= convertDate(subStr,"DMYHM",localeName,"en"); /*Removed Seconds*/
       var birthDate=convertDate(f_query_add_mod.patient_sub.document.getElementById("Birth_Date").value,"DMYHMS",localeName,"en");//Added by Rameswar on 29-Sep-15 for Leap Year issue
       if(birthDate.length==19)birthDate=birthDate.substring(0,16);	   
       if(birthDate.length==18)birthDate=birthDate.substring(0,15); //Added for this incident [54759]		
       if(birthDate.length==17)birthDate=birthDate.substring(0,14);	//Added for this incident [54759]		   
 


if(!isAfter(regdateFormat,birthDate,"DMYHM","en")){/*localeName is changed to en by Rameswar on 06-OCT-15 for Leap Year Issue*/ 
		    var error = getMessage('CANNOT_LESSER','MP');			
			var message1=getLabel("Common.RegistrationDate.label",'Common')+" "+getLabel("Common.time.label",'Common'); 
			var message2=getLabel("Common.birthDate.label",'Common')+" "+getLabel("Common.time.label",'Common'); 
			error = error.replace('$',message2);			
			error = error.replace('#',message1);			
			LocalErrors += error+ "<br>";
		    canSave = false;			
						
		}		
}		
		

//End GDOH-CRF-0029 [IN:048764]
				

			if(f_query_add_mod.patient_sub.document.getElementById("race_required_yn").value == 'Y')
			{
				if(f_query_add_mod.patient_sub.document.getElementById("image1").style.visibility == 'visible') {	

					if(f_query_add_mod.patient_sub.document.getElementById("race_desc").value=="")
					{
						canSave=checkForNull(getLabel('Common.race.label','common'));
					}		 
				}
				if ( canSave == false )
					errorsThere = true;
			}

            if(f_query_add_mod.patient_sub.document.getElementById("doc_id1").value !="")
            {
                if (f_query_add_mod.patient_sub.document.getElementById("doc_num1").value == "")
                {
                    canSave = checkForNull(getLabel('Common.documentno.label','common')+"1");
                }
            }
            if ( canSave == false )
                errorsThere = true;

            if(f_query_add_mod.patient_sub.document.getElementById("doc_id2").value !="")
            {
                if (f_query_add_mod.patient_sub.document.getElementById("doc_num2").value == "")
                {
                    canSave = checkForNull(getLabel('Common.documentno.label','common')+"2");
                }
            }
            if ( canSave == false )
                errorsThere = true;

            if(f_query_add_mod.patient_sub.document.getElementById("doc_id3").value !="")
            {
               if (f_query_add_mod.patient_sub.document.getElementById("doc_num3").value == "")
                {
                    canSave = checkForNull(getLabel('Common.documentno.label','common')+"3");
                }
            }
            if ( canSave == false )
                errorsThere = true;

            if(f_query_add_mod.patient_sub.document.getElementById("doc_id4").value !="")
            {
                if(f_query_add_mod.patient_sub.document.getElementById("doc_num4").value == "")
                {
                    canSave = checkForNull(getLabel('Common.documentno.label','common')+"4");
                }
            }
            if ( canSave == false )
                errorsThere = true;	
            // TO CHECK THE PATIENT SEX MATCH WITH THE NAME PREFIX
            if (  f_query_add_mod.patient_sub.document.getElementById("name_prefix") != null ) 
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix").value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById("sex").value != '' )
					{	
                        canSave = checkPatSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;	 			

			 // TO CHECK THE PATIENT SEX MATCH WITH THE NAME PREFIX
            if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix") != null )
            {
                if (  f_query_add_mod.patient_sub.document.getElementById("name_suffix").value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById("sex").value != '' )
					{	
                        canSave = checkPatSuffixSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;	 			

            // FIRST CHECK FOR THE PATIENT ID
            if ( f_query_add_mod.patient_sub.document.getElementById("pat_no_gen_yn").value == 'N' )
            {
                if(f_query_add_mod.patient_main.document.getElementById("patient_id").value=="")
				{
					canSave=checkForNull(getLabel('Common.patientId.label','common'));
				}
                if ( canSave == false )
                    errorsThere = true;
            }

			//CHECKING FOR MANDATORY refIDValue ON APPLY
			
			if(f_query_add_mod.patient_main.document.getElementById("refrlAappt"))
			{
				if(f_query_add_mod.patient_main.document.getElementById("refrlAappt").value!="") //Modified by S.Sathish for IN020269 on Thursday, March 25, 2010
				{
				if(f_query_add_mod.patient_main.document.getElementById("refIDValue").value=="")
					{
						// All else if added by S.Sathish for IN020269 on Thursday, March 25, 2010
						if(f_query_add_mod.patient_main.document.getElementById("refrlAappt").value == "P")
							canSave=checkForNull(getLabel('eMP.PatientInformation.label','MP'));
						else if(f_query_add_mod.patient_main.document.getElementById("refrlAappt").value == "A")
							canSave=checkForNull(getLabel('eMP.ApptSch.label','MP')+" "+getLabel('Common.no.label','Common'));
						else if(f_query_add_mod.patient_main.document.getElementById("refrlAappt").value == "R")
							canSave=checkForNull(getLabel('eMP.RdAppts.label','MP')+" "+getLabel('Common.no.label','Common'));
						else if(f_query_add_mod.patient_main.document.getElementById("refrlAappt").value == "L")
							canSave=checkForNull(getLabel('Common.referral.label','Common')+" "+getLabel('Common.no.label','Common'));
						else if(f_query_add_mod.patient_main.document.getElementById("refrlAappt").value == "I")
							canSave=checkForNull(getLabel('eMP.IpBooking.label','MP')+" "+getLabel('Common.no.label','Common'));
					}
					if ( canSave == false )
						errorsThere = true;
				}
			} 		
			
            // CHECKING FOR PATIENT DATE OF BIRTH
            if(f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value=="")
			{
				canSave=checkForNull(getLabel('Common.birthDate.label','common'));
			}
            if ( canSave == false )
                errorsThere = true;

			/* CHECKING FOR Maintain Organization - 
				Membership/Organization/Alternate Id 1 */
			if (f_query_add_mod.patient_sub.document.getElementById("family_org_id_accept_yn").value == 'Y')
			{
				if  ( (f_query_add_mod.patient_sub.document.getElementById("pat_cat_code")) && (f_query_add_mod.patient_sub.document.getElementById("entitlement_by_pat_cat_yn").value == 'Y') )
				{
					if(f_query_add_mod.patient_sub.document.getElementById("pat_cat_code").value=="")
					{
						canSave=checkForNull(getLabel('Common.category.label','common'));
					}
						if ( canSave == false )
						errorsThere = true;
			   }
				if (f_query_add_mod.patient_sub.document.getElementById("family_org_membership"))
				{
					if(f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value == "4" || f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value == "3")
						chkAltIdforMemship('call_from_apply');
					if(f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value=="")
					{
						canSave=checkForNull(getLabel('eMP.membership.label','MP'));
					}
						if ( canSave == false )
						errorsThere = true;
				    /*Below line modified for this CRF GHL-CRF-0332 [IN:042060]*/	
					//Below line modified for this incident [61782]
				   if (f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value != 4 && tempflagchk==false)
				   {
					  if (f_query_add_mod.patient_sub.document.getElementById("alt1_gif").style.visibility=='visible')
					  {
						  canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no"),f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value);
	 				      if ( canSave == false )
							errorsThere = true;
					  }
					  if (f_query_add_mod.patient_sub.document.getElementById("org_sub_org").style.visibility=='visible')
					  {
						if(f_query_add_mod.patient_sub.document.getElementById("organization").value=="")
						  {
							canSave=checkForNull(getLabel('Common.Organization.label','Common'));
						  }
						if ( canSave == false )
						errorsThere = true;
						 if(f_query_add_mod.patient_sub.document.getElementById("sub_organization").value=="")
						{
							canSave=checkForNull(getLabel('eMP.suborgn.label','MP'));
						 }
						if ( canSave == false )
						errorsThere = true;
					  }	  
					 /*For Organization Member this check doen't apply*/
					if ( (f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value != 1)  && (f_query_add_mod.patient_sub.document.getElementById("rel")) && (f_query_add_mod.patient_sub.document.getElementById("rel").style.visibility=='visible') )
					 {
						if(f_query_add_mod.patient_sub.document.getElementById("relationship_to_head_desc"))
						{
							if(f_query_add_mod.patient_sub.document.getElementById("relationship_to_head_desc").value=="")
							{
								canSave=checkForNull(getLabel('Common.relationship.label','common'));
							}
						}
						if ( canSave == false )
							errorsThere = true;
				    }

					//if ( f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value != 1 )
					//{
						if(f_query_add_mod.patient_sub.document.getElementById("relationship_level1_desc"))
						{
							if(f_query_add_mod.patient_sub.document.getElementById("relationship_level1_desc").value=="")
							{
								canSave=checkForNull(getLabel('eMP.RelationshipLevel.label','MP'));
							}
						}
						if ( canSave == false )
							errorsThere = true;
				    //}


				}
			  }
			}
			else
			{
				if ( f_query_add_mod.patient_sub.document.getElementById("relationship_to_head_desc"))
				{
					if ( !f_query_add_mod.patient_sub.document.getElementById("rel").style.visibility=='visible')
					{
						if(trimString(f_query_add_mod.patient_sub.document.getElementById("relationship_to_head_desc").value)=="")
						{
							canSave=checkForNull(getLabel('Common.relationship.label','MP'));
						}
						if ( canSave == false )
							errorsThere = true;
						 }
				}
				if(f_query_add_mod.patient_sub.document.getElementById("relationship_level1_desc"))
				{
					if(f_query_add_mod.patient_sub.document.getElementById("relationship_level1_desc").value=="")
					{
						canSave=checkForNull(getLabel('eMP.RelationshipLevel.label','common'));
					}

					if ( canSave == false )
						errorsThere = true;
				}
						
			}
			
			/*
			if (f_query_add_mod.patient_sub.document.getElementById("family_org_membership"))
			{
				if ( (f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value == '1') )
				{
					if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_img")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_img").style.visibility=='visible') )
					{
						canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_prompt").value);
						if ( canSave == false )
							errorsThere = true;
					}
					if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth").style.visibility=='visible') )
					{
							canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_prompt").value);
							if ( canSave == false )
								errorsThere = true;
					}
				}
			} 			

			if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth").style.visibility=='visible') )
			{
				canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_prompt").value);
				if ( canSave == false )
					errorsThere = true;
			}
			*/

			if ( (f_query_add_mod.patient_sub.document.getElementById("entitlement_by_pat_cat_yn").value == 'Y') && (f_query_add_mod.patient_sub.document.getElementById("exp_val_appl_yn").value == 'Y') &&(f_query_add_mod.patient_sub.document.getElementById("imgCatExpDateMan").style.visibility=='visible')  )
			{
				if(f_query_add_mod.patient_sub.document.getElementById("pat_cat_code_exp_date").value=="")
				{
						canSave=checkForNull(getLabel('eMP.categoryexpirydate.label','MP'));
				}
				if ( canSave == false )
				errorsThere = true;
			}
					
			var dflt_patient_name = f_query_add_mod.patient_sub.document.getElementById("dflt_patient_name").value;  			

            if ( f_query_add_mod.patient_sub.document.getElementById("first_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("first_name_reqd_yn") != null && trimString(f_query_add_mod.patient_sub.document.getElementById("first_name").value)== "")
                    if ( f_query_add_mod.patient_sub.document.getElementById("first_name_reqd_yn").value == 'Y' )
					{
							f_query_add_mod.patient_sub.document.getElementById("first_name").value = dflt_patient_name;
							// Added & Commented the below lines for Incident 17918 on 07/01/2010 by Suresh
							f_query_add_mod.patient_sub.document.getElementById("first_name").onblur();
							//f_query_add_mod.patient_main.document.getElementById("patient_name").value +=  dflt_patient_name;
					}
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("second_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("second_name_reqd_yn") != null && trimString(f_query_add_mod.patient_sub.document.getElementById("second_name").value)=="") 
                if ( f_query_add_mod.patient_sub.document.getElementById("second_name_reqd_yn").value == 'Y' )
				{
					f_query_add_mod.patient_sub.document.getElementById("second_name").value = dflt_patient_name;
					// Added & Commented the below lines for Incident 17918 on 07/01/2010 by Suresh
					f_query_add_mod.patient_sub.document.getElementById("second_name").onblur();
					//f_query_add_mod.patient_main.document.getElementById("patient_name").value +=  dflt_patient_name ;
				}
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("third_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("third_name_reqd_yn") != null && trimString(f_query_add_mod.patient_sub.document.getElementById("third_name").value)=="")
                if ( f_query_add_mod.patient_sub.document.getElementById("third_name_reqd_yn").value == 'Y' )
				{
					f_query_add_mod.patient_sub.document.getElementById("third_name").value = dflt_patient_name;
					// Added & Commented the below lines for Incident 17918 on 07/01/2010 by Suresh
					f_query_add_mod.patient_sub.document.getElementById("third_name").onblur();
					//f_query_add_mod.patient_main.document.getElementById("patient_name").value +=  dflt_patient_name ;
				}
			}

              if ( f_query_add_mod.patient_sub.document.getElementById("family_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("family_name_reqd_yn") != null && trimString(f_query_add_mod.patient_sub.document.getElementById("family_name").value)=='')
                if ( f_query_add_mod.patient_sub.document.getElementById("family_name_reqd_yn").value == 'Y' )
                {
					f_query_add_mod.patient_sub.document.getElementById("family_name").value = dflt_patient_name;
					// Added & Commented the below lines for Incident 17918 on 07/01/2010 by Suresh
					f_query_add_mod.patient_sub.document.getElementById("family_name").onblur();
					//f_query_add_mod.patient_main.document.getElementById("patient_name").value +=  dflt_patient_name;
				}
            }
			
			if ( f_query_add_mod.patient_sub.document.getElementById("first_name") != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById("first_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("first_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("first_name"),f_query_add_mod.patient_sub.document.getElementById("first_name_prompt").value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById("second_name") != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById("second_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("second_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("second_name"),f_query_add_mod.patient_sub.document.getElementById("second_name_prompt").value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById("third_name") != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById("third_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("third_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("third_name"),f_query_add_mod.patient_sub.document.getElementById("third_name_prompt").value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById("family_name") != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById("family_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("family_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("family_name"),f_query_add_mod.patient_sub.document.getElementById("family_name_prompt").value);
                if ( canSave == false )
                    errorsThere = true;              
            }

           	if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_suffix"),f_query_add_mod.patient_sub.document.getElementById("name_suffix_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

			
            if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix") != null )
            {
               	if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_img")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_img").style.visibility=='visible'))
				{
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_prompt").value);
				}
				
                if ( canSave == false )
                    errorsThere = true;
            }
  // CHECKING FOR PATIENT NAME
            if (trimString(f_query_add_mod.patient_main.document.getElementById("patient_name").value)=="")
			{
				var patForm = f_query_add_mod.patient_sub.document.all;
				var pat_name = f_query_add_mod.patient_main.document.getElementById("patient_name");
				if (patForm.first_name)
				{
					pat_name.value = trimString(patForm.first_name.value) ;
				}
				if (patForm.second_name)
				{
					pat_name.value  = pat_name.value + ' ' +trimString(patForm.second_name.value) ;
				}
				if (patForm.third_name)
				{
					pat_name.value  =  pat_name.value + ' ' + trimString(patForm.third_name.value) ;
				}
				if (patForm.family_name)
				{
					pat_name.value  =  pat_name.value +' ' + trimString(patForm.family_name.value) ;
				}
						 
				if (trimString(f_query_add_mod.patient_main.document.getElementById("patient_name").value)=="")
					canSave=checkForNull(getLabel('Common.PatientName.label','common'));
			}
		 
			if(f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang")) {
				if(trimString(f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value)=="") {
					var patForm = f_query_add_mod.patient_sub.document.all;
					var pat_name = f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang");
					if (patForm.first_name_oth_lang) {
						pat_name.value = trimString(patForm.first_name_oth_lang.value) ;
					}
					if (patForm.second_name_oth_lang)	{
						pat_name.value  = pat_name.value + ' ' +trimString(patForm.second_name_oth_lang.value) ;
					}
					if (patForm.third_name_oth_lang){
						pat_name.value  =  pat_name.value + ' ' + trimString(patForm.third_name_oth_lang.value) ;
					}
					if (patForm.family_name_oth_lang){
						pat_name.value  =  pat_name.value +' ' + trimString(patForm.family_name_oth_lang.value) ;
					}
					if(f_query_add_mod.patient_sub.document.getElementById("pat_name_in_loc_lang_reqd_yn").value == "Y"){
						if (trimString(f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value)=="")
							canSave=checkForNull(getLabel('eMP.PatientNameLocal.label','MP'));
					}
				}

				 if( f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang") != null)
					f_query_add_mod.patient_sub.document.getElementById("patient_name_loc_lang").value = f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value;
			}
	
		
	          if ( canSave == false )
                errorsThere = true;
			
			f_query_add_mod.patient_sub.document.getElementById("patient_name").value = f_query_add_mod.patient_main.document.getElementById("patient_name").value;

            if ( f_query_add_mod.patient_sub.document.getElementById("first_name_oth_prompt") != null )
            {
 				    if (f_query_add_mod.patient_sub.document.getElementById("first_oth").style.visibility=='visible')
	                   canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("first_name_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("first_name_oth_prompt").value);
                    if ( canSave == false )
                        errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("second_name_oth_prompt") != null )
            {
                if (f_query_add_mod.patient_sub.document.getElementById("sec_oth").style.visibility=='visible')
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("second_name_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("second_name_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("third_name_oth_prompt") != null )
            {
                 if (f_query_add_mod.patient_sub.document.getElementById("third_oth").style.visibility=='visible')
                    canSave =checkForNull1(f_query_add_mod.patient_sub.document.getElementById("third_name_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("third_name_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("family_name_oth_prompt") != null )
            {
				if  (f_query_add_mod.patient_sub.document.getElementById("fam_oth").style.visibility=='visible')
					canSave =checkForNull1(f_query_add_mod.patient_sub.document.getElementById("family_name_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("family_name_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang") != null )
            {
                 if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            // CHECKING FOR ALTERNATE ID'S
			
			/*Below line modified for this CRF GHL-CRF-0332 [IN:042060]*/
			//Below line modified for this incident [61782]
						
            if ( f_query_add_mod.patient_sub.document.getElementById("alt_id1_no") != null && tempflagchk==false)
            {
									
				 if ( (!f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").disabled) && (!f_query_add_mod.patient_sub.document.getElementById("family_org_membership")))
				{
		            pat_ser_grp_obj = f_query_add_mod.patient_sub.document.getElementById("pat_ser_grp_code");
					
					
						if (f_query_add_mod.patient_sub.document.getElementById("alt1_gif").style.visibility=='visible')
						{
							canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no"),f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value);
						}
					//}
                   
                    if ( canSave == false )
                        errorsThere = true;
                }
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("alt_id2_no") != null )
            {
                if(!f_query_add_mod.patient_sub.document.getElementById("alt_id2_no").disabled)
                {
                    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id2_reqd_yn").value == 'Y' )
                        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id2_no"),f_query_add_mod.patient_sub.document.getElementById("altId2Desc").value);

                    if ( f_query_add_mod.patient_sub.document.getElementById("Alt_Id2_Unique_Yn2").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("error_alt_no2").value.length > 0)
                    {
                    }
                    if ( canSave == false )
                        errorsThere = true;
                }
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("alt_id3_no") != null )
            {
                if(!f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").disabled)
                {

                    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id3_reqd_yn").value == 'Y' )
                        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id3_no"),f_query_add_mod.patient_sub.document.getElementById("altId3Desc").value);

                    if ( f_query_add_mod.patient_sub.document.getElementById("Alt_Id3_Unique_Yn3").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("error_alt_no3").value.length > 0)
                    {
                    }
                    if ( canSave == false )
                        errorsThere = true;
                }
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("alt_id4_no") != null )
            {
                if(!f_query_add_mod.patient_sub.document.getElementById("alt_id4_no").disabled)
                {
                    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id4_reqd_yn").value == 'Y' )
                        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id4_no"),f_query_add_mod.patient_sub.document.getElementById("altId4Desc").value);

                    if ( f_query_add_mod.patient_sub.document.getElementById("Alt_Id4_Unique_Yn4").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("error_alt_no4").value.length > 0)
                    {
                    }
                    if ( canSave == false )
                        errorsThere = true;
                }
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("alt_id1_no") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").value.length == 0 && f_query_add_mod.patient_sub.document.getElementById("alt_id1_exp_date") != null)
                    f_query_add_mod.patient_sub.document.getElementById("alt_id1_exp_date").value = '';
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("alt_id2_no") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("alt_id2_no").value.length == 0  && f_query_add_mod.patient_sub.document.getElementById("alt_id2_exp_date") != null)
                    f_query_add_mod.patient_sub.document.getElementById("alt_id2_exp_date").value = '';
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("alt_id3_no") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").value.length == 0  && f_query_add_mod.patient_sub.document.getElementById("alt_id3_exp_date") != null )
                    f_query_add_mod.patient_sub.document.getElementById("alt_id3_exp_date").value = '';

            }

            if ( f_query_add_mod.patient_sub.document.getElementById("alt_id4_no") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("alt_id4_no").value.length == 0 && f_query_add_mod.patient_sub.document.getElementById("alt_id4_exp_date") != null)
                    f_query_add_mod.patient_sub.document.getElementById("alt_id4_exp_date").value = '';
            }

           if(f_query_add_mod.patient_sub.document.getElementById("living_dependency").value=="")
			{
				canSave=checkForNull(getLabel('Common.Dependency.label','Common'));
			}
            if ( canSave == false )
            errorsThere = true;

            if(f_query_add_mod.patient_sub.document.getElementById("living_arrangement").value=="")
			{
				canSave=checkForNull(getLabel('eMP.Livingarrangement.label','MP'));
			}
            if (canSave == false)
            errorsThere = true;
            if(f_query_add_mod.patient_sub.document.getElementById("datasource_id").value !=null && f_query_add_mod.patient_sub.document.getElementById("datasource_id")!='')
            {
                if(f_query_add_mod.patient_sub.document.getElementById("alt_id1_exp_date") !=null)
                {
                    if(f_query_add_mod.patient_sub.document.getElementById("alt_id1_exp_date").value != '')
                    {
                        msg =f_query_add_mod.frames[1].getMessage("ALT_ID_EXPIRED",'MP')

                       	retval = f_query_add_mod.patient_sub.isAfterNow(f_query_add_mod.patient_sub.document.getElementById("alt_id1_exp_date"),"DMY",localeName) ;
                        msg = msg.replace('$',f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value) ;
                        if(retval)
						{
							alert(msg)
						}
					}
				}
                if(f_query_add_mod.patient_sub.document.getElementById("alt_id2_exp_date") !=null)
                {
                    if(f_query_add_mod.patient_sub.document.getElementById("alt_id2_exp_date").value != '')
                    {
                        msg =f_query_add_mod.frames[1].getMessage("ALT_ID_EXPIRED",'MP')
                        retval = f_query_add_mod.patient_sub.isAfterNow(f_query_add_mod.patient_sub.document.getElementById("alt_id2_exp_date"),"DMY",localeName);
                        msg = msg.replace('$',f_query_add_mod.patient_sub.document.getElementById("altId2Desc").value) ;
                        if(retval)  {alert(msg)}
                    }
                }
                if(f_query_add_mod.patient_sub.document.getElementById("alt_id3_exp_date") !=null)
                {
                    if(f_query_add_mod.patient_sub.document.getElementById("alt_id3_exp_date").value != '')
                    {
                        msg =f_query_add_mod.frames[1].getMessage("ALT_ID_EXPIRED",'MP')
						retval = f_query_add_mod.patient_sub.isAfterNow(f_query_add_mod.patient_sub.document.getElementById("alt_id3_exp_date"),"DMY",localeName)
                        msg = msg.replace('$',f_query_add_mod.patient_sub.document.getElementById("altId3Desc").value) ;
                        if(retval)  {alert(msg)}
                    }
                }
                if(f_query_add_mod.patient_sub.document.getElementById("alt_id4_exp_date") !=null)
                {
                    if(f_query_add_mod.patient_sub.document.getElementById("alt_id4_exp_date").value != '')
                    {
                        msg =f_query_add_mod.frames[1].getMessage("ALT_ID_EXPIRED",'MP')
						retval = f_query_add_mod.patient_sub.isAfterNow(f_query_add_mod.patient_sub.document.getElementById("alt_id4_exp_date"),"DMY",localeName)
                        msg = msg.replace('$',f_query_add_mod.patient_sub.document.getElementById("altId4Desc").value) ;
                        if(retval)  {alert(msg)}
                    }
                }
            }
//Incident Fix Against for the Inci no : 34531  as on 10/08/2012
if(f_query_add_mod.patient_sub.document.getElementById("language_desc"))
{			
if(f_query_add_mod.patient_sub.document.getElementById("language_desc").value == "")
	{
	f_query_add_mod.patient_sub.document.getElementById("language_code").value="";
	}
}
//End	
if(f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value != "")
{
    if (!f_query_add_mod.patient_sub.isBeforeNow(f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value,"DMY",localeName)) 
    {
        LocalErrors += getMessage('DOB_CHECK','Common') + ' <br>';
		canSave = false;
    }
}
			//Added by kumar on 13/03/2003 for National ID Validation with Date of Birth & Sex.
			if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
			{		
				if (f_query_add_mod.patient_sub.document.getElementById("national_id_no").value != "" && f_query_add_mod.patient_sub.document.getElementById("nat_data_source_id") != null)
				{
					if (f_query_add_mod.patient_sub.document.getElementById("nat_data_source_id").value=="NRIC" && f_query_add_mod.patient_sub.document.getElementById("invoke_routine").value=="Y")
					{
						if (f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value != '')
						{
							var dob = f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value;
							dob = dob.substring(8,10) + dob.substring(3,5)+dob.substring(0,2);
							if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.length >= 6)
							{
								if (dob!=f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.substring(0,6))
								{
									var natmsg = f_query_add_mod.frames[1].getMessage('MISMATCH_NAT_DOB','MP');
									natmsg = natmsg.replace('#', f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
									LocalErrors += natmsg + ' <br>';
									canSave =false;
								}
							}
							if (f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.length >= 12)
							{
								var sexIdent = f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.substring(8,12);
								if (!isNaN(sexIdent))
								{
									var sexIdent = f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.substring(11,12);
									if (parseInt(sexIdent) == 1 || parseInt(sexIdent) == 3 || parseInt(sexIdent) == 5 || parseInt(sexIdent) == 7 || parseInt(sexIdent) == 9)
									{ 
										sexIdent = "M";
									}
									else
										sexIdent = "F";
									
									if (sexIdent!=f_query_add_mod.patient_sub.document.getElementById("sex").value)
									{
										var natmsg = f_query_add_mod.frames[1].getMessage('MISMATCH_NAT_SEX','MP') 
										natmsg = natmsg.replace('#', f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
										LocalErrors += natmsg + ' <br>';
										canSave =false;
									}
								}
								else
								{
									var natmsg = getMessage('NAT_ID_9_12','MP')
									natmsg = natmsg.replace('#', f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
									LocalErrors += natmsg + ' <br>';
									canSave =false;
								}
							}
						}
					}
				}
			}
			//End of Addition
			//Added for Nextofkin NRIC
			// Conditon Newly Added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
			if(f_query_add_mod.patient_sub.document.getElementById("region_appl_yn1").value=='Y'&& f_query_add_mod.patient_sub.document.getElementById("region_prompt1").value!=""){ 
			if(f_query_add_mod.patient_sub.document.getElementById("id1").style.visibility=='visible')
			{
			if(f_query_add_mod.patient_sub.document.getElementById("r_region_code").value=="")
			{
			canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById("region_prompt1").value);
			}
			if ( canSave == false )
                errorsThere = true;
			}
			}
			/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
			if(f_query_add_mod.patient_sub.document.getElementById("addr_pincode_mand1"))
			{
			if(f_query_add_mod.patient_sub.document.getElementById("r_addr_line1").value=="")
			{
			canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById("addr_line1_prompt").value);
			}

            if ( canSave == false )
                errorsThere = true;
			}
			if(f_query_add_mod.patient_sub.document.getElementById("addr_pincode_mand2"))
			{
			if(f_query_add_mod.patient_sub.document.getElementById("r_addr_line2").value=="")
			{
			canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById("addr_line2_prompt").value);
			}

            if ( canSave == false )
                errorsThere = true;
			}
			if(f_query_add_mod.patient_sub.document.getElementById("addr_pincode_mand3"))
			{
			if(f_query_add_mod.patient_sub.document.getElementById("r_postal_code1").value=="")
			{
			canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById("postal_code_prompt").value);
			}

            if ( canSave == false )
                errorsThere = true;
			}
			/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
			if(f_query_add_mod.patient_sub.document.getElementById("id2").style.visibility=='visible')
			{
			if(f_query_add_mod.patient_sub.document.getElementById("r_country_code").value=="")
			{
				canSave=checkForNull(getLabel('Common.country.label','common'));
			}

            if ( canSave == false )
                errorsThere = true;
			}
			if(f_query_add_mod.patient_sub.document.getElementById("id3").style.visibility=='visible')
			{
			if(f_query_add_mod.patient_sub.document.getElementById("contact2_no").value=="")
			{
				canSave=checkForNull(getLabel('Common.MobileNo.label','common'));
			}

            if ( canSave == false )
                errorsThere = true;
			}
			// Ends here
			// Newly Added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
			if(f_query_add_mod.patient_sub.document.getElementById("id4").style.visibility=='visible')
			{
			if(f_query_add_mod.patient_sub.document.getElementById("email").value=="")
			{
				canSave=checkForNull(getLabel('Common.email.label','common'));
			}

            if ( canSave == false )
                errorsThere = true;
			}
			// Ends here
			if (f_query_add_mod.patient_sub.document.getElementById("contact1_new_nat_id_no").value.length >= 6)
			{
				var dob1 = f_query_add_mod.patient_sub.document.getElementById("contact1_birth_date").value;
				dob1 = dob1.substring(8,10) + dob1.substring(3,5)+dob1.substring(0,2);
				if ( (f_query_add_mod.patient_sub.document.getElementById("nat_data_source_id").value=="NRIC") && (f_query_add_mod.patient_sub.document.getElementById("invoke_routine").value=="Y") &&  (dob1!=f_query_add_mod.patient_sub.document.getElementById("contact1_new_nat_id_no").value.substring(0,6)) )
				{
					var natmsg = f_query_add_mod.frames[1].getMessage('MISMATCH_NAT_DOB','MP');
					natmsg = natmsg.replace('#', f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
					LocalErrors += natmsg + ' ' + getLabel('Common.in.label','common')+ " " +getLabel('Common.nextofkin.label','common') +'<br>';
					
					canSave =false;
				}
			}
			if(f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value == "N")
			{
				if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
				{
					if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.length > 0)
					{
					var nat_id_prmt_1=f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value;
					
					var msg1=f_query_add_mod.patient_sub.getMessage("NRIC_FOR_NONCITIZEN",'MP');
					msg1=msg1.replace('$',nat_id_prmt_1)
					alert(msg1);
						f_query_add_mod.patient_sub.document.getElementById("national_id_no").disabled = false;
						canSave =false;
						errorsThere = true;
					}
				}
			}
		   if (f_query_add_mod.patient_sub.document.getElementById("nationality_code"))
		   {
			if(f_query_add_mod.patient_sub.document.getElementById("nationality_code").value == f_query_add_mod.patient_sub.document.getElementById("dflt_nationality_code").value)
				{
					if(!((f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value == "Y") || (f_query_add_mod.patient_sub.document.getElementById("legal_yn").value == "Y")))
					{
						var resmsg = f_query_add_mod.patient_sub.getMessage("RES_STATUS_FOR_CITIZEN",'MP');
						resmsg = resmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById("nationality_desc").value);
						alert(resmsg);
						errorsThere = true;
						canSave = false;

					}
				}
			  }
				if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
				{ 
					if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value.length>0 )
					{
						if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value == f_query_add_mod.patient_sub.document.getElementById("contact1_new_nat_id_no").value)
						{
							var resmsg = f_query_add_mod.patient_sub.getMessage("NRIC_CANNOT_BE_SAME",'MP');
							resmsg = resmsg.replace('#',getLabel("Common.nextofkin.label","Common"));
							resmsg = resmsg.replace('$',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							resmsg = resmsg.replace('~',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							alert(resmsg);
							errorsThere = true;
							canSave = false;
						}
						if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value == f_query_add_mod.patient_sub.document.getElementById("contact2_nat_id_no").value)
						{
							var resmsg = f_query_add_mod.patient_sub.getMessage("NRIC_CANNOT_BE_SAME",'MP');
							resmsg = resmsg.replace('#',getLabel("Common.firsttonotify.label","Common"));
							resmsg = resmsg.replace('$',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							resmsg = resmsg.replace('~',f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							alert(resmsg);
							errorsThere = true;
							canSave = false;
						}
					}
				}
				/*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] Start*/ 
				if(f_query_add_mod.patient_sub.document.getElementById("national_id_no") && f_query_add_mod.patient_sub.document.getElementById("isValidateNatIDWithDOB").value=="true"){
					var dobVal		= f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value;
					var natIdVal	= f_query_add_mod.patient_sub.document.getElementById("national_id_no").value;
					if(dobVal!= "" && natIdVal!=""){
						if(!fnChkDOBNatIDValidation(dobVal,natIdVal)){
							var natmsg = f_query_add_mod.frames[1].getMessage('MISMATCH_NAT_DOB','MP');
							natmsg = natmsg.replace('#', f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							LocalErrors += natmsg + ' <br>';
							canSave =false;
						}
					}
				}
				/*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] End*/ 
				/*Added by Thamizh selvi on 24th Mar 2017 for GDOH-CRF-0145 Start*/
				if(f_query_add_mod.patient_sub.document.getElementById("national_id_no") && f_query_add_mod.patient_sub.document.getElementById("chkGenderWithNatID").value=="true"){
					var gender	= f_query_add_mod.patient_sub.document.getElementById("sex").value;
					var natId	= f_query_add_mod.patient_sub.document.getElementById("national_id_no").value;
					if(gender!= "" && natId!=""){
						if(!chkNatIDWithGender(gender,natId)){
							var errmsg = f_query_add_mod.frames[1].getMessage('MISMATCH_NAT_SEX','MP');
							errmsg = errmsg.replace('National ID', f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							LocalErrors += errmsg + ' <br>';
							canSave =false;
						}
					}
				}/*End*/
			//Nationality Validation

			  if (f_query_add_mod.patient_sub.document.getElementById("nationality_code")) 
			  {
				if(f_query_add_mod.patient_sub.document.getElementById("nationality_desc").value=='')
					f_query_add_mod.patient_sub.document.getElementById("nationality_code").value='';		
				if (f_query_add_mod.patient_sub.document.getElementById("nationality_code").value =='')
				{
					if(f_query_add_mod.patient_sub.document.getElementById("nationality_code").value=="")
					{
						canSave=checkForNull(getLabel('Common.nationality.label','common'));
					}
				}
			  }
            if ( canSave == false )
                errorsThere = true;

			//Added for Maximum age validation
			var maxAge = f_query_add_mod.patient_sub.document.getElementById("max_patient_age").value;
			var actAge = f_query_add_mod.patient_sub.document.getElementById("b_age").value;
			var actMonth = f_query_add_mod.patient_sub.document.getElementById("b_months").value;
			var actDay = f_query_add_mod.patient_sub.document.getElementById("b_days").value;
			if (maxAge != '')
			{
				if (parseInt(actAge) > parseInt(maxAge) || 
					((parseInt(actAge) == parseInt(maxAge)) && (parseInt(actMonth) > 0 || parseInt(actDay) > 0)))
				{
					LocalErrors += f_query_add_mod.patient_sub.getMessage("MAX_PATIENT_AGE",'MP')+" "+maxAge+" "+ getLabel("Common.Years.label","common") + "  <br>";
					canSave = false;
				}
			}
			//end of validation

			//Added for Billing on 16/8/2002 by kumar for Validating any values are entered.
			var bl_install = f_query_add_mod.patient_sub.PatRegForm.bl_install_yn.value;
			if (bl_install=="Y")
			{
				var bl_success = f_query_add_mod.patient_sub.PatRegForm.bl_success.value;
				if (bl_success=="N")
				{
					LocalErrors += f_query_add_mod.patient_sub.getMessage("FINANCIAL_DET_MANDATORY",'MP') + ' <br>';
					canSave = false;
				}
				if(canSave == true)
				{
					if((f_query_add_mod.patient_sub.document.forms[0].nationality_code) && (f_query_add_mod.patient_sub.document.forms[0].dflt_nat_id_chk_val.value != f_query_add_mod.patient_sub.document.forms[0].nationality_code.value))
					{
						
						LocalErrors += f_query_add_mod.patient_sub.getMessage("NATIONALITY_CHANGED",'MP') + ' <br>';
						canSave = false;
					}
				}
			}
			//End of addition

			///** by meghanath **//	
			if(f_query_add_mod.frames[0].document.forms[0].acpt_appt_rfrl_in_reg_pat_yn.value == 'Y')
			{
				 f_query_add_mod.patient_sub.document.forms[0].refrlAappt.value = f_query_add_mod.frames[0].document.forms[0].refrlAappt.value;
				 f_query_add_mod.patient_sub.document.forms[0].refIDValue.value = f_query_add_mod.frames[0].document.forms[0].refIDValue.value;
			}
			///** end **//

			// Added by Sethu for KDAH-CRF-0362 on 18/01/2018
			CheckForeKYCValidate();
			
            if(canSave == true && errorsThere == false)
            {
				f_query_add_mod.patient_sub.document.getElementById("date_of_birth").disabled = false;
				
				if(f_query_add_mod.patient_sub.PatRegForm.appt_yn.value=='Appt' || f_query_add_mod.patient_sub.PatRegForm.appt_yn.value=='IPADMIT')
                {
					var flag='F';
                    if(f_query_add_mod.patient_sub.PatRegForm.first_name)
                    {
						var fname=f_query_add_mod.patient_sub.PatRegForm.first_name.value;
                        var appfname=f_query_add_mod.patient_sub.PatRegForm.appfirstname.value;
                        if(fname == appfname) flag = 'T';
                        else flag = 'F';
					}
                    if(f_query_add_mod.patient_sub.PatRegForm.second_name && flag == 'T')
                    {
                          var sname = f_query_add_mod.patient_sub.PatRegForm.second_name.value;
                          var appsname = f_query_add_mod.patient_sub.PatRegForm.appsecondname.value;
                          if(sname == appsname) flag = 'T';
                          else flag = 'F';
                    }
						
                    if(f_query_add_mod.patient_sub.PatRegForm.third_name && flag=='T')
                    {
						
						var tname = f_query_add_mod.patient_sub.PatRegForm.third_name.value;
						var apptname = f_query_add_mod.patient_sub.PatRegForm.appthirdname.value;
                        if(tname == apptname) flag = 'T';
                        else flag = 'F';
					}
                    if(f_query_add_mod.patient_sub.PatRegForm.family_name && flag == 'T')
					{ 
						var famname = f_query_add_mod.patient_sub.PatRegForm.family_name.value;
                        var appfamname = f_query_add_mod.patient_sub.PatRegForm.appfamilyname.value;
                        if(famname == appfamname) flag = 'T';
                        else flag='F';
					}
					if(f_query_add_mod.patient_sub.PatRegForm.date_of_birth && flag == 'T')
                    {
						var dob = f_query_add_mod.patient_sub.PatRegForm.date_of_birth.value;
                        var appdob = f_query_add_mod.patient_sub.PatRegForm.appdateofbirth.value;
                        if(dob == appdob) flag = 'T';
                        else flag = 'F';
					}
					if(f_query_add_mod.patient_sub.PatRegForm.sex && flag == 'T')
                     {
                          var sex = f_query_add_mod.patient_sub.PatRegForm.sex.value;
                          var appsex = f_query_add_mod.patient_sub.PatRegForm.appsex.value;
                          if(sex == appsex) flag = 'T';
                          else flag = 'F';
					}
					if(f_query_add_mod.patient_sub.PatRegForm.name_prefix && flag == 'T')
                    {
                          var prefix = f_query_add_mod.patient_sub.PatRegForm.name_prefix.value;
                          var appprefix = f_query_add_mod.patient_sub.PatRegForm.appprefix.value;
                          if(prefix == appprefix) flag = 'T';
                          else flag = 'F';
                    }
						
                    if(f_query_add_mod.patient_sub.PatRegForm.name_suffix && flag == 'T')
                    {
						var suffix = f_query_add_mod.patient_sub.PatRegForm.name_suffix.value;
						var appsuffix = f_query_add_mod.patient_sub.PatRegForm.appsuffix.value;
                        if(suffix == appsuffix) flag = 'T';
                        else flag = 'F';
                    }
						
                    dis_list = new Array()

                    if(flag == 'T')
                    { 
						for(i=0;i<f_query_add_mod.patient_sub.PatRegForm.elements.length;i++)
                        { 
							var ele = f_query_add_mod.patient_sub.PatRegForm.elements[i]
                            if(ele.disabled)
                            {   
								ele.disabled=false
                                dis_list[i]=ele
                            }
                       }
				       if(f_query_add_mod.patient_sub.document.getElementById("func_act").value == '')
							 { 
                              	f_query_add_mod.patient_sub.PatRegForm.submit();
							 }
							 else
                             {
								var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><head><META HTTP-EQUIV='Content-Type' content='text/html;charset=UTF-8'>";
                                s += "</head><body class='message' onKeyDown='lockKey()'><form name='PatRegForm' id='PatRegForm' method='post'  action='../../servlet/eMP.PatientRegistrationServlet' target='messageFrame'>";

                                var frm = f_query_add_mod.patient_sub.PatRegForm
								for(i=0;i<frm.elements.length;i++)
								{
									if(frm.elements[i].type=='checkbox')
									{
										if(frm.elements[i].checked) 
										{
											s += "<input type='hidden' name='"+frm.elements[i].name+"' id='"+frm.elements[i].name+"' value='Y'>"
										}
									 }
									else 
									{
										s += "<input type='hidden' name='"+frm.elements[i].name+"' id='"+frm.elements[i].name+"' value=\""+(frm.elements[i].value == null ?'':frm.elements[i].value)+"\">"
									}
								}
						
								s+="</body></html>"
								messageFrame.document.write(s);
								messageFrame.document.PatRegForm.submit();
                             }

                             for(i=0;i<ele.length;i++)
                             {
                                ele.disabled = true
                             }
                          }
                          else
                          {
							var altmsg=f_query_add_mod.patient_sub.getMessage("APPT_REC_CHG",'MP');
							if(f_query_add_mod.patient_sub.document.getElementById("func_act").value == '' && f_query_add_mod.patient_sub.document.getElementById("appt_yn").value=='')
							{
								f_query_add_mod.patient_sub.PatRegForm.submit();
							}
                            else
                            {
							var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><head><META HTTP-EQUIV='Content-Type' CONTENT='text/html;CHARSET=UTF-8'>";
                       
							s += "</head><body class='message' onKeyDown='lockKey()'><form name='PatRegForm' id='PatRegForm' method='post'  action='../../servlet/eMP.PatientRegistrationServlet' target='messageFrame'>";

							var frm = f_query_add_mod.patient_sub.PatRegForm
                            for(i=0;i<frm.elements.length;i++)
                            {
                                if(frm.elements[i].type=='checkbox')
                                {
                                    if(frm.elements[i].checked)
									{
										s += "<input type='hidden' name='"+frm.elements[i].name+"' id='"+frm.elements[i].name+"' value='Y'>"
									}
                                }
                                else
								{
                                    s += "<input type='hidden' name='"+frm.elements[i].name+"' id='"+frm.elements[i].name+"' value=\""+(frm.elements[i].value == null ?'':frm.elements[i].value)+"\">"
								}
                            }
                            
							s+="</body></html>"
							messageFrame.document.write(s);
							messageFrame.document.PatRegForm.submit();
                            }
                         }
                     }
                     else
                     {
						
                        for(i=0;i<f_query_add_mod.patient_sub.PatRegForm.elements.length;i++)
                        {
							var ele = f_query_add_mod.patient_sub.PatRegForm.elements[i]
                            if(ele.disabled)
                            {
                                ele.disabled=false
                                dis_list[i]=ele
							}
                        }
					
						if(f_query_add_mod.patient_sub.document.getElementById("func_act").value == '' && f_query_add_mod.patient_sub.document.getElementById("appt_yn").value=='') 
						{
							f_query_add_mod.patient_sub.PatRegForm.submit();
						}
                        else
                        { 
							var s = "<%@ page contentType=\"text/html;charset=UTF-8\"%><%request.setCharacterEncoding(\"UTF-8\");%><html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><head><META HTTP-EQUIV='Content-Type'  CONTENT='text/html; CHARSET=UTF-8'></head><body class='message' onKeyDown='lockKey()'><form name='PatRegForm' id='PatRegForm' method='post'  action='../../servlet/eMP.PatientRegistrationServlet' target='messageFrame'>";

							var frm = f_query_add_mod.patient_sub.PatRegForm
                            for(i=0;i<frm.elements.length;i++)
                            {
                                if(frm.elements[i].type=='checkbox')
                                {
                                    if(frm.elements[i].checked)
									{
                                        s += "<input type='hidden' name='"+frm.elements[i].name+"' id='"+frm.elements[i].name+"' value='Y'>"
										frm.elements[i].value='Y'
									}
                                }
                                else
								{
                                    s += "<input type='hidden' name='"+frm.elements[i].name+"' id='"+frm.elements[i].name+"' value=\""+(frm.elements[i].value == null ?'':(frm.elements[i].value))+"\">"
								}
							}
							s+="</body></html>";
							messageFrame.document.write(s);
							messageFrame.document.PatRegForm.submit();
							//f_query_add_mod.patient_sub.PatRegForm.submit();
						}
                    }
				}
	            else
		        { 
					multipleclicks='false';
					var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><head><META HTTP-EQUIV='Content-Type' CONTENT='text/html;CHARSET=UTF-8'></head><body onKeyDown='lockKey()'><form name='f' id='f' method='post' action='../../eCommon/jsp/error.jsp'><input type='hidden' name='err_num' id='err_num' value=\""+LocalErrors+Alt_error+"\"></form></body></html>" ;
					messageFrame.document.write(s);						

					setTimeout('submit_timeout()',800);

				 // settimeout used to avoid script error while submitting.
				 	//messageFrame.document.f.submit();
					//ADDED FOR DISABLING HOME BUTTON WHEN CALLED FROM OTHER MODULES.
					if ((f_query_add_mod.patient_sub.document.getElementById("func_act").value != '' && f_query_add_mod.patient_sub.document.getElementById("func_act").value != 'REF_SEARCH') || f_query_add_mod.patient_sub.document.getElementById("appt_yn").value == 'Appt')
					{
						dummy();
					}
				}
			}
            else
            {
               multipleclicks='false';
            }
        }
    }
}
} //END of the function



function submit_timeout()
{
messageFrame.document.f.submit();
}


function dummy()
{
	setTimeout("disableHome()", 1000);
}
function disableHome()
{

	if(parent.commontoolbarFrame.document.getElementById("home") != null) {
		parent.commontoolbarFrame.document.getElementById("home").disabled = true;		
	}
	else if(commontoolbarFrame.document.getElementById("home")) {
		commontoolbarFrame.document.getElementById("home").disabled = true;
	}
	if(parent.commontoolbarFrame.document.getElementById("create") != null)
		parent.commontoolbarFrame.document.getElementById("create").disabled = true;
	else if(commontoolbarFrame.document.getElementById("create"))
		commontoolbarFrame.document.getElementById("create").disabled = true;
	if(parent.commontoolbarFrame.document.getElementById("query") != null)
		parent.commontoolbarFrame.document.getElementById("query").disabled = true;
	else if(commontoolbarFrame.document.getElementById("query"))
		commontoolbarFrame.document.getElementById("query").disabled = true;
}
//* the function disableButtons() is called in PatientRegisrtationSevlet.java file when Register Patient Transaction is call from Other Modules *//

function disableButtons()
{
	setTimeout('disableToolBarButtons()', 800);
}

function disableToolBarButtons()
{
	if(parent.parent.commontoolbarFrame.document.getElementById("home") != null)
		parent.parent.commontoolbarFrame.document.getElementById("home").disabled = true;
	
	if(parent.parent.commontoolbarFrame.document.getElementById("create") != null)
		parent.parent.commontoolbarFrame.document.getElementById("create").disabled = true;
	
	if(parent.parent.commontoolbarFrame.document.getElementById("query") != null)
		parent.parent.commontoolbarFrame.document.getElementById("query").disabled = true;
}

//* end of the function disableButtons()  *//

function apply()
{
	
	if(f_query_add_mod.patient_sub != null)
	{
		if (f_query_add_mod.patient_sub.dataFetchedFromRepos!='Y')
		{ 
			setTimeout("callApply()",500);
		}
		else { 
		
			callApply();
		}
	}
	else
	{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
} 


function callDemoTab() {
		parent.patient_sub.moveToTab(1);
}
    function chkOnSub()
    {
		var pat_ser_code = "";
		if(parent.frames[1].document.getElementById("pat_ser_grp_code")) {
			pat_ser_code = parent.frames[1].document.getElementById("pat_ser_grp_code").value;			
		}
		if(pat_ser_code == "") {
			var err = getMessage("CAN_NOT_BE_BLANK",'COMMON');
			err = err.replace('$',getLabel('eMP.PatientSeries.label','MP'));
			alert(err);
			return;
		}
        var package_flag="N";
        var ins_auth_flag="N";
        var upd_pat_flag="N";
        var show_hide_blng_class="SHOW";
        var billing_group       = parent.frames[1].document.forms[0].billing_group;
        var billing_mode        = parent.frames[1].document.forms[0].billing_mode;
		var bl_data_from_repos_yn = "";
		;
		var data_source_id = parent.frames[1].document.forms[0].datasource_id;
		

		if (billing_mode.value == 'Add' && billing_group.value != '')
		{	
			bl_data_from_repos_yn = "Y";
		}
		else
		{
			bl_data_from_repos_yn = "N";
		}		
		if (billing_group.value != '')
			billing_mode.value = "Modify";

		var operation           = parent.frames[1].document.forms[0].bl_operation.value;

		if(billing_mode.value=="Modify"){
			operation="Update";
		}


		//Added for Billing validation at the time of apply on 16/8/2002
			parent.frames[1].document.forms[0].bl_success.value = "N";

		//Added for Billing Enhancements
		var calling_module_id	   = "MP";
		var calling_function_id	   = "PAT_REG";
		//end of Addition

		
		/* Start of modifications for billing enhancement on 8th Jan 04 --------------- */
		/* end of modifications for billing enhancement on 8th Jan 04--------------- */

        var episode="";
        var record="";          
		patient_id = parent.frames[1].document.getElementById("patient_id").value;	
		

        var 
		qryStr="operation="+operation+"&upd_pat_flag="+upd_pat_flag+"&show_hide_blng_class="+show_hide_blng_class+"&billing_mode="+billing_mode.value;
		qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
        qryStr += "&bl_data_from_repos_yn="+bl_data_from_repos_yn+"&data_source_id="+data_source_id.value+"&patient_id="+patient_id;


		// Start of modifications for billing enhancement on 8th Jan 04 --------------- 
		//End of modifications for billing enhancement on 8th jan 04 --------------- 

		////////August 03 2005 //////

		var nationality_yn = "N";
		if (parent.frames[1].document.forms[0].nationality_code) 
		{
			parent.frames[1].document.forms[0].dflt_nat_id_chk_val.value = parent.frames[1].document.forms[0].nationality_code.value;
			if(parent.frames[1].document.forms[0].nationality_code.value == parent.frames[1].document.forms[0].dflt_nationality_code.value)
			{
				nationality_yn = "Y";
			}
			else 
			{
				nationality_yn = "N";
			}
		}
		qryStr+="&nationality_yn="+nationality_yn;		
		//Added for this CRF CRF GDOH-CRF-0029 [IN:048764] 
		var pat_regn_date_time="";		
		if(parent.frames[1].document.forms[0].disas_regn_date_time)
		pat_regn_date_time=parent.frames[1].document.forms[0].disas_regn_date_time.value;		
		qryStr+="&pat_regn_date_time="+pat_regn_date_time;	
		
		qryStr+="&patient_class=XT&pat_ser_code="+pat_ser_code;

		//////////////////////////
		
		var returnArray = new Array();
        
        returnArray = getFinDtl(qryStr);
		//tab_click(previousTab);

		parent.patient_main.invokeTab('demogrp_tab');
		
        if(returnArray.length>0)
        {
            billing_group.value         = returnArray[0];        

            billing_mode.value          = "Modify";
			//Added for Billing validation at the time of apply
			parent.frames[1].document.forms[0].bl_success.value = "Y";		            
        } else {
			parent.frames[1].document.forms[0].bl_success.value = "N";	
            return false;
		}        
        
    }
    function checkPatientId()   {

		if(document.forms[0].refrlAappt.value != 'P')
		{  		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";

        if ( document.getElementById("patient_id").value.length != document.getElementById("patient_id").maxLength && document.getElementById("patient_id").value.length > 0)
        {
            var msg = getMessage("PAT_ID_CH",'MP');
			msg = msg.replace('$', document.getElementById("patient_id").maxLength);
			alert(msg);
            document.getElementById("patient_id").focus();
        }
		

		
        if ( document.getElementById("patient_id").value.length == document.getElementById("patient_id").maxLength )
        {
			var pat_id = document.getElementById("patient_id").value;
			pat_id = pat_id.substring(0,2);
            if (pat_id != parent.frames[1].document.forms[0].pat_ser_grp_code.value && prefixReqd == "Y")
			{				
				var msg = getMessage("PAT_SER_PREFIX",'MP');
				msg = msg.replace('$', parent.frames[1].document.forms[0].pat_ser_grp_code.value);
				alert(msg);
				document.getElementById("patient_id").focus();
			}
			else
			{
				xmlStr+=" process_id=\"3\" ";
				xmlStr+=" pat_id=\""+document.getElementById("patient_id").value+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				var url = "../../eMP/jsp/ServerValidationXML.jsp";
				xmlHttp.open("POST", url, false);
				xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
				xmlHttp.send(xmlDoc);
				eval(xmlHttp.responseText);
			}
        }

        if ( document.getElementById("patient_id").value.length == 0 )
			if (parent.patient_sub.document.getElementById("national_id_no").type=='text')
                parent.patient_sub.document.getElementById("national_id_no").focus();
			else
				parent.patient_sub.document.getElementById("pat_ser_grp_code").focus();
   }
	}

function changeTab(TabName) {

// RESET THE OLD TAB WHICH IS SELECTED FIRST .............
    if (currentTab == 'demogrp_tab')
        document.getElementById("demogrp_tab").src = '../../eCommon/images/LDemographics.gif';
    else if (currentTab == 'cmodeaddr_tab')
        document.getElementById("cmodeaddr_tab").src = '../../eCommon/images/LContactModeAddr.gif';
    else if (currentTab == 'rlcnts_tab')
        document.getElementById("rlcnts_tab").src = '../../eCommon/images/LRelatedContacts.gif';
    else if (currentTab == 'others_tab')
        document.getElementById("others_tab").src = '../../eCommon/images/LOthers.gif';
    else if (currentTab == 'pat_docs_tab')
    {
         document.getElementById("pat_docs_tab").src = '../../eMP/images/Patient Documents-click.gif';
    }
    else if (currentTab == 'findtl_tab')
        document.getElementById("findtl_tab").src = '../../eBL/images/Financial Details_click.gif';

// CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............

    if (TabName == 'demogrp_tab')
        document.getElementById("demogrp_tab").src = '../../eCommon/images/Demographics.gif';
    else if (TabName == 'cmodeaddr_tab')
        document.getElementById("cmodeaddr_tab").src = '../../eCommon/images/ContactModeAddr.gif';
    else if (TabName == 'rlcnts_tab')
        document.getElementById("rlcnts_tab").src = '../../eCommon/images/RelatedContacts.gif';
    else if (TabName == 'others_tab')
        document.getElementById("others_tab").src = '../../eCommon/images/Others.gif';
    else if (TabName == 'pat_docs_tab')
         document.getElementById("pat_docs_tab").src = '../../eMP/images/Patient Documents.gif';
    else if (TabName == 'findtl_tab')
        document.getElementById("findtl_tab").src = '../../eBL/images/Financial Details.gif';

// FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER
if (TabName == currentTab)
		previousTab = 'demogrp_tab';
	else
		previousTab = currentTab;
    currentTab = TabName;

}

function loadPatSeriesManual()
{
	if (document.getElementById("patient_id").value.length==0)
	{
		if (document.getElementById("patient_id").readOnly==false)
		{
			prefixReqd = parent.frames[1].pat_sergrp_reqd_yn[parent.frames[1].document.getElementById("pat_ser_grp_code").selectedIndex];
			if (prefixReqd == "Y")
				document.getElementById("patient_id").value = parent.frames[1].document.forms[0].pat_ser_grp_code.value;
		}
	}
}

function checkPatientId1()   {

		if(document.forms[0].refrlAappt.value == 'P')
		{
			var patient_id = document.getElementById("refIDValue").value;
		
		}
		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";

        if ( patient_id.length != document.getElementById("patient_id").maxLength && patient_id.length > 0)
        {
            var msg = getMessage("PAT_ID_CH",'MP');
			msg = msg.replace('$', document.getElementById("patient_id").maxLength);
			alert(msg);
			document.getElementById("refIDValue").value='';
			document.getElementById("refIDValue").focus();
        }
	     
		/*
        if ( patient_id.length == 0 )
			if (parent.patient_sub.document.getElementById("national_id_no").type=='text')
                parent.patient_sub.document.getElementById("national_id_no").focus();
			else
				parent.patient_sub.document.getElementById("pat_ser_grp_code").focus();
		*/
  
	}
 function changeBLSuccess(){
	 parent.frames[1].document.forms[0].bl_success.value = "N";
 }

  // Added by Sethu for KDAH-CRF-0362
function CheckForeKYCValidate()
{
	var chkAadhaarValidate = "";
	var chkeKYCValidate = "";
	var chkAadhaarStatus = "";

	if(f_query_add_mod.patient_sub.document.getElementById("chkAadhaarValidate")){
		
		chkAadhaarValidate = f_query_add_mod.patient_sub.document.getElementById("chkAadhaarValidate").value;
		if (f_query_add_mod.patient_sub.document.getElementById("chkEKYCValidate"))
		{
			chkeKYCValidate = f_query_add_mod.patient_sub.document.getElementById("chkEKYCValidate").value;

			if (chkeKYCValidate == "Y")
			{
				if (f_query_add_mod.patient_sub.document.getElementById("aadhaarStatus"))
				{					
					chkAadhaarStatus = f_query_add_mod.patient_sub.document.getElementById("aadhaarStatus").value;

					if (chkAadhaarStatus != "Y")
					{
						alert("AADHAAR Card Status has not been validated.");
					}
				}
			}
		}
	}
}

