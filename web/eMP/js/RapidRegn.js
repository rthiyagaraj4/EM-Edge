
// GLOBAL Variables
   var LocalErrors = new String();
   var multipleclicks='false';
    var queryStr= "" ;
    dis_list = new Array () ;
function create() 
{
	var parameter = document.getElementById("parameters").value ;	
   // f_query_add_mod.location.href = "../../eMP/jsp/PaintRapidRegn.jsp?"+queryStr ;
    f_query_add_mod.location.href = "../../eMP/jsp/PaintRapidRegn.jsp?"+parameter ;	
}

function edit() {

}

async function query() {
    //messageFrame.location = '../../eCommon/jsp/error.jsp?err_num= '
    var url = await PatientSearch('','','','','','','','N','Y','RPDRG');	
    if(url)
    {		
		var parameter = document.getElementById('parameters').value;		
             f_query_add_mod.location.href=url+"&"+parameter;			
    }
}

function callApply() {

	if( f_query_add_mod.patient_sub.Rapid_Regn.date_of_birth.disabled )
    {
        f_query_add_mod.patient_sub.Rapid_Regn.date_of_birth.disabled = false;
        f_query_add_mod.patient_sub.Rapid_Regn.date_of_birth.readOnly = true;
    }

	var sStyle = f_query_add_mod.patient_sub.document.Rapid_Regn.sStyle.value;

		if(multipleclicks=='false')
		{
			multipleclicks='true';
			LocalErrors = '';
			var Alt_error= new String();

			var canSave = new Boolean(true);

			var splField = new Array();
			var splFieldName = new Array();

            if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y")
			{

				splField = new Array(f_query_add_mod.patient_main.document.getElementById("patient_id"),
                                     f_query_add_mod.patient_sub.document.getElementById("national_id_no")
                                     );
				splFieldName = new Array(getLabel("Common.patientId.label","common"), f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
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
           
if(f_query_add_mod.patient_sub.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/error.jsp"))
{
// VARIABLE TO CHECK WHETHER ANY 1 ERROR IS ENCOUNTERED SO THAT FORM IS BLOCKED FROM SUBMITION
var errorsThere = new Boolean(false);

if( f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang") != null)
    f_query_add_mod.patient_sub.document.getElementById("patient_name_loc_lang").value = f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value;

f_query_add_mod.patient_sub.document.getElementById("patient_id").value = f_query_add_mod.patient_main.document.getElementById("patient_id").value;


//TO CHECK THE PATIENT SEX IS NOT NULL
//if (f_query_add_mod.patient_sub.document.getElementById("sex").selectedIndex == 0)
//{

if(f_query_add_mod.patient_sub.document.getElementById("sex").value=="")
	{
	    canSave = checkForNull(getLabel("Common.gender.label","common"));
//		checkForNull(canSave);
	}

//}
if ( canSave == false )
    errorsThere = true;
	if(f_query_add_mod.patient_sub.document.getElementById("visa_type")){
			//Added by Kamatchi S for AAKH-CRF-0145
			if(f_query_add_mod.patient_sub.document.getElementById("visa_type").value=="" && f_query_add_mod.patient_sub.document.getElementById("citizen")[1].checked==true)
			{  
				canSave=checkForNull(getLabel('eMP.VisaType.label','MP'));
			}
	}
            if ( canSave == false )
                errorsThere = true;

if(f_query_add_mod.patient_sub.document.getElementById("pat_ser_grp_code").value=="")
	{
	    canSave = checkForNull(getLabel('eMP.PatientSeries.label','MP'));
//		checkForNull(canSave);
	}

//}
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


//CHECKING FOR MANDATORY refIDValue ON APPLY
			if(f_query_add_mod.patient_main.document.getElementById("refrlAappt").value=="P")
			{
			if(f_query_add_mod.patient_main.document.getElementById("refIDValue").value=="")
				{
					canSave=checkForNull(getLabel('eMP.PatientInformation.label','MP'));
				}
                if ( canSave == false )
                    errorsThere = true;
			}


// TO CHECK THE PATIENT SEX MATCH WITH THE NAME PREFIX
 /*if ( ( f_query_add_mod.patient_sub.document.getElementById("name_prefix") != null ) || ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang") != null ) )
{
			if ( ( f_query_add_mod.patient_sub.document.getElementById("name_prefix").value.length != 0 ) || ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang").value.length != 0 ) )
			{
				   if( f_query_add_mod.patient_sub.document.getElementById("sex").value != '' )
						canSave = checkPatSex();
			}
}
if ( canSave == false )
    errorsThere = true;

// TO CHECK THE PATIENT SEX MATCH WITH THE NAME SUFFIX
if ( ( f_query_add_mod.patient_sub.document.getElementById("name_suffix") != null ) || ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang") != null ) )
 {
			if ( ( f_query_add_mod.patient_sub.document.getElementById("name_suffix").value.length != 0 ) || ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang").value.length != 0 ) )
			{
				canSave = checkPatSuffixSex();
			}
}

if ( canSave == false )
    errorsThere = true;
	*/
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

		/*	if (  f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang") != null ) 
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang").value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById("sex").value != '' )
					{	
                        canSave = checkPatOthSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;*/

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

		/*	if (  f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang") != null ) 
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang").value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById("sex").value != '' )
					{	
                        canSave = checkPatOthSuffixSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;*/

			if(f_query_add_mod.patient_sub.document.getElementById("race_required_yn").value == 'Y')
			{
				if(f_query_add_mod.patient_sub.document.getElementById("image1").style.visibility == 'visible') {	

					if(f_query_add_mod.patient_sub.document.getElementById("race_desc").value=="") {						 
						canSave =  checkForNull(getLabel("Common.race.label","common"));
					}			 
				}
				if ( canSave == false )
					errorsThere = true;
			}
			
			/* below Added for ML-MMOH-CRF-0736 by Mano */
			
			if(f_query_add_mod.patient_sub.document.getElementById("religion_reqd_yn").value == 'Y')
			{
				if(f_query_add_mod.patient_sub.document.getElementById("image2").style.visibility == 'visible') {
					
					if(f_query_add_mod.patient_sub.document.getElementById("relgn_desc").value=="") {
						canSave = checkForNull(getLabel('Common.religion.label','common'));
					}
				}
				if( canSave == false )
					errorThere = true;
			}	/* End of CRF-0736 by Mano */

// FIRST CHECK FOR THE PATIENT ID
if ( f_query_add_mod.patient_sub.document.getElementById("pat_no_gen_yn").value == 'N' )
{
    if(f_query_add_mod.patient_main.document.getElementById("patient_id").value=="")
	{

	canSave = checkForNull(getLabel('Common.patientId.label','common'));
//	checkForNull(canSave);
	}
    if ( canSave == false )
        errorsThere = true;
}

if ( canSave == false )
    errorsThere = true;

//Incident Fix Against for the Inci no : 34725  as on 04/09/2012	
	
	if(f_query_add_mod.patient_sub.document.getElementById("language_desc"))
{			
if(f_query_add_mod.patient_sub.document.getElementById("language_desc").value == "")
	{
	f_query_add_mod.patient_sub.document.getElementById("language_code").value="";
	}
}
// 34725 End
// CHECKING FOR PATIENT DATE OF BIRTH
if(f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value=="")
{
	canSave = checkForNull(getLabel('Common.birthDate.label','common'));
//	checkForNull(canSave);
}
if ( canSave == false )
    errorsThere = true;
/* CHECKING FOR Maintain Organization - 
				Membership/Organization/Alternate Id 1 */
//Below Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
if  ( (f_query_add_mod.patient_sub.document.getElementById("pat_cat_code")) && (f_query_add_mod.patient_sub.document.getElementById("pat_category_reqd_yn").value == 'Y') )
{
	if(f_query_add_mod.patient_sub.document.getElementById("pat_cat_code").value=="")
	{
	canSave=checkForNull(getLabel('Common.category.label','common'));
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
					//checkForNull(canSave);
					}
						if ( canSave == false )
						errorsThere = true;
			   }
			 
				if (f_query_add_mod.patient_sub.document.getElementById("family_org_membership"))
				{
					
					if(f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value=="")
					{
						canSave=checkForNull(getLabel('eMP.membership.label','MP'));
						//checkForNull(canSave);
					}
						if ( canSave == false )
						errorsThere = true;
				   if (f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value != 4)
				   {
					  /*
					  if (f_query_add_mod.patient_sub.document.getElementById("alt1_gif").style.visibility=='visible')
					  {
						  canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no"),f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value);
	 				      if ( canSave == false )
							errorsThere = true;
					  }
					  */
					  if (f_query_add_mod.patient_sub.document.getElementById("org_sub_org").style.visibility=='visible')
					  {
						if(f_query_add_mod.patient_sub.document.getElementById("organization").value=="")
						  {
								canSave=checkForNull(getLabel('Common.Organization.label','Common'));
								//checkForNull(canSave);
						}
						if ( canSave == false )
						errorsThere = true;
						  
						if(f_query_add_mod.patient_sub.document.getElementById("sub_organization").value=="")
						 {
							canSave=checkForNull(getLabel('eMP.suborgn.label','MP'));
								//checkForNull(canSave);
						}
						if ( canSave == false )
						errorsThere = true;
					  }	  
					 /*For Organization Member this check doen't apply*/					
					if(f_query_add_mod.patient_sub.document.getElementById("rel")) {
					if ( (f_query_add_mod.patient_sub.document.getElementById("family_org_membership").value != 1)  && (f_query_add_mod.patient_sub.document.getElementById("rel").style.visibility=='visible') )
					 {
						if(f_query_add_mod.patient_sub.document.getElementById("relationship_to_head").value=="")
						 {
						canSave=checkForNull(getLabel('Common.relationship.label','common'));
						//		checkForNull(canSave);
						}
						if ( canSave == false )
							errorsThere = true;
				    } }
				}
			  }
			}
			else
			 if ( f_query_add_mod.patient_sub.document.getElementById("relationship_to_head"))
			{
				if ( !f_query_add_mod.patient_sub.document.getElementById("rel").style.visibility=='visible')
				{
					if(f_query_add_mod.patient_sub.document.getElementById("relationship_to_head").value=="")
						 {
							canSave=checkForNull(getLabel('Common.relationship.label','common'));
								//checkForNull(canSave);
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
					if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang")) &&  (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth").style.visibility=='visible'))
					{
								canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_prompt").value);
							if ( canSave == false )
								errorsThere = true;
					}
				}
			}
			*/

			if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_img")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_img").style.visibility=='visible') )
			{
				canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix"),f_query_add_mod.patient_sub.document.getElementById("name_prefix_prompt").value);
				if ( canSave == false )
					errorsThere = true;
			}
			if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang")) &&  (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth")) && (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth").style.visibility=='visible'))
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
//				checkForNull(canSave);
				}
					if ( canSave == false )
					errorsThere = true;
			}
			/* End of Membership Type validations*/  
var dflt_patient_name = f_query_add_mod.patient_sub.document.getElementById("dflt_patient_name").value;
if ( (f_query_add_mod.patient_sub.document.getElementById("first_name") != null ) && (trimString(f_query_add_mod.patient_sub.document.getElementById("first_name").value)==''))
{
	if ( f_query_add_mod.patient_sub.document.getElementById("first_name_reqd_yn") != null)
		if ( f_query_add_mod.patient_sub.document.getElementById("first_name_reqd_yn").value == 'Y' )
	      {
			f_query_add_mod.patient_sub.document.getElementById("first_name").value = dflt_patient_name;
			// Added the below line for Incident 17918 on 07/01/2010 by Suresh
			f_query_add_mod.patient_sub.document.getElementById("first_name").onblur();
	       
		  }
}

if ( ( f_query_add_mod.patient_sub.document.getElementById("second_name") != null ) && (trimString(f_query_add_mod.patient_sub.document.getElementById("second_name").value)==''))
{
	if ( f_query_add_mod.patient_sub.document.getElementById("second_name_reqd_yn") != null)
	if ( f_query_add_mod.patient_sub.document.getElementById("second_name_reqd_yn").value == 'Y' )
	{
	  f_query_add_mod.patient_sub.document.getElementById("second_name").value = dflt_patient_name;
	  // Added the below line for Incident 17918 on 07/01/2010 by Suresh
	  f_query_add_mod.patient_sub.document.getElementById("second_name").onblur();
	}
}

if ( (f_query_add_mod.patient_sub.document.getElementById("third_name") != null ) && (trimString(f_query_add_mod.patient_sub.document.getElementById("third_name").value)==''))
{
	if ( f_query_add_mod.patient_sub.document.getElementById("third_name_reqd_yn") != null)
	if ( f_query_add_mod.patient_sub.document.getElementById("third_name_reqd_yn").value == 'Y' )
	{
	   f_query_add_mod.patient_sub.document.getElementById("third_name").value = dflt_patient_name;
	   // Added the below line for Incident 17918 on 07/01/2010 by Suresh
	   f_query_add_mod.patient_sub.document.getElementById("third_name").onblur();
	}
}

if ( (f_query_add_mod.patient_sub.document.getElementById("family_name") != null ) && (trimString(f_query_add_mod.patient_sub.document.getElementById("family_name").value)==''))
{  
	if ( f_query_add_mod.patient_sub.document.getElementById("family_name_reqd_yn") != null)
	if ( f_query_add_mod.patient_sub.document.getElementById("family_name_reqd_yn").value == 'Y' )
		{
	       f_query_add_mod.patient_sub.document.getElementById("family_name").value = dflt_patient_name;
		   // Added the below line for Incident 17918 on 07/01/2010 by Suresh
		   f_query_add_mod.patient_sub.document.getElementById("family_name").onblur();	       
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
    if(f_query_add_mod.patient_sub.document.getElementById("name_suffix_reqd_yn") != null)
        if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_reqd_yn").value == 'Y' )
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_suffix"), f_query_add_mod.patient_sub.document.getElementById("name_suffix_prompt").value);
    if ( canSave == false )
        errorsThere = true;
}

/*
if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix") != null )
{
    if(f_query_add_mod.patient_sub.document.getElementById("name_prefix_reqd_yn") != null)
        if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_reqd_yn").value == 'Y' )
            canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix"), f_query_add_mod.patient_sub.document.getElementById("name_prefix_prompt").value);
    if ( canSave == false )
        errorsThere = true;
}
*/
/*Modified by Arthi on 20-May-2022 for AAKH-CRF-0145*/

if(f_query_add_mod.patient_sub.document.getElementById("isNatIdAltIdMandVisaType").value == "true" && f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value=='N' && f_query_add_mod.patient_sub.document.getElementById("visa_type").value == "W" && f_query_add_mod.patient_sub.document.getElementById("national_id_no").value == "")
			{
				/*Added by Arthi on 20-May-2022 for AAKH-CRF-0145*/
				if(f_query_add_mod.patient_sub.document.getElementById("nat_gif").style.visibility == "visible"){
					var message1=getLabel('eMP.ResidentWork.label','MP')
					error	= getMessage('RES_VISA_TYPE','MP');
					error = error.replace("#",f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
					error = error.replace("$",message1);
					LocalErrors += error+ "<br>";
					canSave = false;
				}

			}
			if ( canSave == false )
                errorsThere = true;
		if(f_query_add_mod.patient_sub.document.getElementById("isNatIdAltIdMandVisaType").value == "true" && f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value=='N' && f_query_add_mod.patient_sub.document.getElementById("visa_type").value == "V" && f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").value == "" && f_query_add_mod.patient_sub.document.getElementById("alt_id2_no").value == "")
			{
	
				if(f_query_add_mod.patient_sub.document.getElementById("alt1_gif").style.visibility == "visible" && f_query_add_mod.patient_sub.document.getElementById("alt2_gif").style.visibility == "visible"){
					var message1=f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value;
					var message2=f_query_add_mod.patient_sub.document.getElementById("altId2Desc").value;
					var message3=getLabel('Common.Visit.label','common');
					error	= getMessage('VISIT_VISA_TYPE','MP');
					error = error.replace("#",message1);
					error = error.replace("@",message2);
					error = error.replace("$",message3);
					LocalErrors += error+ "<br>";
					canSave = false
				}
			}
			else if(f_query_add_mod.patient_sub.document.getElementById("isNatIdAltIdMandVisaType").value == "true" && f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value=='N' && f_query_add_mod.patient_sub.document.getElementById("visa_type").value == "V" && f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").value == "")
			{
		
				if(f_query_add_mod.patient_sub.document.getElementById("alt1_gif").style.visibility == "visible"){
					var message1=f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value;
					var message3=getLabel('Common.Visit.label','common');
					error	= getMessage('VISIT_VISA_TYPE','MP');
					error = error.replace("# and @",message1);
					error = error.replace("$",message3);
					LocalErrors += error+ "<br>";
					canSave = false
				}
			}
			else if(f_query_add_mod.patient_sub.document.getElementById("isNatIdAltIdMandVisaType").value == "true" && f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value=='N' && f_query_add_mod.patient_sub.document.getElementById("visa_type").value == "V" && f_query_add_mod.patient_sub.document.getElementById("alt_id2_no").value == "")
			{
			
				if(f_query_add_mod.patient_sub.document.getElementById("alt2_gif").style.visibility == "visible"){
					var message2=f_query_add_mod.patient_sub.document.getElementById("altId2Desc").value;
					var message3=getLabel('Common.Visit.label','common');
					error	= getMessage('VISIT_VISA_TYPE','MP');
					error = error.replace("# and @",message2);
					error = error.replace("$",message3);
					LocalErrors += error+ "<br>";
					canSave = false
				}
			}

			if ( canSave == false )
                errorsThere = true;
			/*End AAKH-CRF-0145*/
			
			//AAKH CRF 168
			  if ( f_query_add_mod.patient_sub.document.getElementById("alt_id1_no") != null && tempflagchk==false)
            {
									
				 if ( (!f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").disabled) && (!f_query_add_mod.patient_sub.document.getElementById("family_org_membership")))
				{
		            pat_ser_grp_obj = f_query_add_mod.patient_sub.document.getElementById("pat_ser_grp_code");
					
					
						if (f_query_add_mod.patient_sub.document.getElementById("alt1_gif").style.visibility=='visible')
						{
					//Added by Kamatchi S for AAKH-CRF-0145
					var isNatIdAltIdMandVisaType	= f_query_add_mod.patient_sub.document.getElementById("isNatIdAltIdMandVisaType").value;
					//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
					if( isNatIdAltIdMandVisaType == "true" && f_query_add_mod.patient_sub.document.getElementById("visa_type").value != "V"){
				//	if( isNatIdAltIdMandVisaType == "false"){
							canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no"),f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value);
					}
				/*	var isNatIdOrAltId1MandRes	= f_query_add_mod.patient_sub.document.getElementById("isNatIdOrAltId1MandRes").value;
					if( isNatIdOrAltId1MandRes == "true"){
							canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no"),f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value);
					}*/
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
 
                 //   if ( f_query_add_mod.patient_sub.document.getElementById("alt_id2_reqd_yn").value == 'Y' ){
					  if (f_query_add_mod.patient_sub.document.getElementById("alt2_gif").style.visibility=='visible') { 
					//Added by Kamatchi S for AAKH-CRF-0145
					var isNatIdAltIdMandVisaType	= f_query_add_mod.patient_sub.document.getElementById("isNatIdAltIdMandVisaType").value;
					//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
					if( isNatIdAltIdMandVisaType == "true" && f_query_add_mod.patient_sub.document.getElementById("alt2_gif").style.visibility=='visible' && f_query_add_mod.patient_sub.document.getElementById("visa_type").value != "V"){
				//	if( isNatIdAltIdMandVisaType == "false"){
                        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id2_no"),f_query_add_mod.patient_sub.document.getElementById("altId2Desc").value);
					}
				/*	var isNatIdOrAltId1MandRes	= f_query_add_mod.patient_sub.document.getElementById("isNatIdOrAltId1MandRes").value;
					if( isNatIdOrAltId1MandRes == "true"){
							canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id2_no"),f_query_add_mod.patient_sub.document.getElementById("altId2Desc").value);
					}*/
					}

                    if ( f_query_add_mod.patient_sub.document.getElementById("Alt_Id2_Unique_Yn2").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("error_alt_no2").value.length > 0)
                    {
                    }
                    if ( canSave == false )
                        errorsThere = true;
                }
            }
			//Ends aakh 168
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
			
			//putPatientName();
			if (trimString(f_query_add_mod.patient_main.document.getElementById("patient_name").value)=="")
				canSave=checkForNull(getLabel('Common.PatientName.label','common'));
		}
			if(f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang")) { 
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

	
			/*  Commented code by Suresh M for IN023043 on 03-08-2010
            if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang") != null )
            {
                 if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_name_reqd_yn") != null )
				{
					if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_name_reqd_yn").value == 'Y' )
					{
					  canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang"), f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_prompt").value);
					}
				}
                if ( canSave == false )
                    errorsThere = true;
            }
			*/
            if ( f_query_add_mod.patient_sub.document.getElementById("first_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("first_oth_name_reqd_yn") != null)
                    if ( f_query_add_mod.patient_sub.document.getElementById("first_oth_name_reqd_yn").value == 'Y' )
                        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("first_name_oth_lang"), f_query_add_mod.patient_sub.document.getElementById("first_name_oth_prompt").value);
                    if ( canSave == false )
                        errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("second_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("second_oth_name_reqd_yn") != null)
                if ( f_query_add_mod.patient_sub.document.getElementById("second_oth_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("second_name_oth_lang"), f_query_add_mod.patient_sub.document.getElementById("second_name_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("third_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("third_oth_name_reqd_yn") != null)
                if ( f_query_add_mod.patient_sub.document.getElementById("third_oth_name_reqd_yn").value == 'Y' )
                    canSave =checkForNull1(f_query_add_mod.patient_sub.document.getElementById("third_name_oth_lang"), f_query_add_mod.patient_sub.document.getElementById("third_name_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("family_name") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("family_oth_name_reqd_yn") != null)
                if ( f_query_add_mod.patient_sub.document.getElementById("family_oth_name_reqd_yn").value == 'Y' )
                    canSave =checkForNull1(f_query_add_mod.patient_sub.document.getElementById("family_name_oth_lang"), f_query_add_mod.patient_sub.document.getElementById("family_name_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix") != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang"), f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }
		/*  Commented code by Suresh M for IN023043 on 03-08-2010
            if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang") != null )
            {
                 if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_name_reqd_yn") != null )
                if ( f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_name_reqd_yn").value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang"), f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_prompt").value);
                if ( canSave == false )
                    errorsThere = true;
            }
		*/

// CHECKING FOR ALTERNATE ID'S

/*Below line modified for this CRF GHL-CRF-0332 [IN:042060]*/
//Below line modified for this incident [61782]
if(f_query_add_mod.patient_sub.document.getElementById("isNatIdAltIdMandVisaType").value=='false') //Maheshwaran added for AAKH-CRF-0145
{
if ( f_query_add_mod.patient_sub.document.getElementById("alt_id1_no") != null && tempflagchk==false )
{
	if(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").readOnly == false && f_query_add_mod.patient_sub.document.getElementById("alt1_gif").style.visibility=='visible') {
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no"), f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value);
	}

    if ( f_query_add_mod.patient_sub.document.getElementById("Alt_Id1_Unique_Yn1").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("error_alt_no1").value.length > 0)
    {
       // errorsThere = true;
       // Alt_error= Alt_error+f_query_add_mod.patient_sub.document.getElementById("error_alt_no1").value+'<br>';
    }
    if ( canSave == false )
        errorsThere = true;
}

if ( f_query_add_mod.patient_sub.document.getElementById("alt_id2_no") != null )
{
    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id2_reqd_yn").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("alt_id2_no").disabled==false)
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id2_no"), f_query_add_mod.patient_sub.document.getElementById("altId2Desc").value);

    if(f_query_add_mod.patient_sub.document.getElementById("Alt_Id2_Unique_Yn2").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("error_alt_no2").value.length > 0)
    {
           // errorsThere = true;
           // Alt_error= Alt_error+f_query_add_mod.patient_sub.document.getElementById("error_alt_no2").value+'<br>';
    }

    if ( canSave == false )
        errorsThere = true;
}
		}
if ( f_query_add_mod.patient_sub.document.getElementById("alt_id3_no") != null )
{
    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id3_reqd_yn").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").disabled==false)
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id3_no"), f_query_add_mod.patient_sub.document.getElementById("altId3Desc").value);

    if(f_query_add_mod.patient_sub.document.getElementById("Alt_Id3_Unique_Yn3").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("error_alt_no3").value.length > 0)
    {
           // errorsThere = true;
           // Alt_error= Alt_error+f_query_add_mod.patient_sub.document.getElementById("error_alt_no3").value+'<br>';
    }

    if ( canSave == false )
        errorsThere = true;
}
if ( f_query_add_mod.patient_sub.document.getElementById("alt_id4_no") != null )
{
    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id4_reqd_yn").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("alt_id4_no").disabled==false)
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id4_no"), f_query_add_mod.patient_sub.document.getElementById("altId4Desc").value);

    if(f_query_add_mod.patient_sub.document.getElementById("Alt_Id4_Unique_Yn4").value == 'Y' && f_query_add_mod.patient_sub.document.getElementById("error_alt_no4").value.length > 0)
    {
           // errorsThere = true;
           // Alt_error= Alt_error+f_query_add_mod.patient_sub.document.getElementById("error_alt_no4").value+'<br>';
    }

    if ( canSave == false )
        errorsThere = true;
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
    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").value.length == 0  && f_query_add_mod.patient_sub.document.getElementById("alt_id3_exp_date") != null)
        f_query_add_mod.patient_sub.document.getElementById("alt_id3_exp_date").value = '';
}
if ( f_query_add_mod.patient_sub.document.getElementById("alt_id4_no") != null )
{
    if ( f_query_add_mod.patient_sub.document.getElementById("alt_id4_no").value.length == 0  && f_query_add_mod.patient_sub.document.getElementById("alt_id4_exp_date") != null)
        f_query_add_mod.patient_sub.document.getElementById("alt_id4_exp_date").value = '';
}

var isNatIdOrAltId1MandRes		= f_query_add_mod.patient_sub.document.getElementById("isNatIdOrAltId1MandRes").value;
var isNatIdOrAltIdMandVisaType		= f_query_add_mod.patient_sub.document.getElementById("isNatIdOrAltIdMandVisaType").value;
var isNatIdAltIdMandVisaType		= f_query_add_mod.patient_sub.document.getElementById("isNatIdAltIdMandVisaType").value;//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
var isValidateNatId				= "Y";
//Maheshwaran added isNatIdAltIdMandVisaType- for AAKH-CRF-0145 as on 22-04-2022
if((isNatIdOrAltId1MandRes == "true" || isNatIdOrAltIdMandVisaType=="true" || isNatIdAltIdMandVisaType=="true")&& f_query_add_mod.patient_sub.document.getElementById("nat_id_reqd_all_series").value=='N'){
	isValidateNatId		= "N";
}

/*Modified by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491] */
//if (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y" && f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value == "Y"){
if ((f_query_add_mod.patient_sub.document.getElementById("isNatIdMandatory").value!="Y") && (f_query_add_mod.patient_sub.document.getElementById("accept_national_id_no").value=="Y" && f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value == "Y")){
	if (f_query_add_mod.patient_sub.document.getElementById("patient_group").value == 'N' || f_query_add_mod.patient_sub.document.getElementById("nat_id_reqd_all_series").value=='Y')
	{
		canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("national_id_no"), f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
	}
	else
	{
		pat_ser_grp_obj = f_query_add_mod.patient_sub.document.getElementById("pat_ser_grp_code")

		if(f_query_add_mod.patient_sub.document.getElementById("nat_id_reqd_all_series").value=='N' && f_query_add_mod.patient_sub.pat_sergrp_id_types[pat_ser_grp_obj.selectedIndex] == "N" && isValidateNatId=="Y")
		{
			canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("national_id_no"), f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
		}
	}
}else if(f_query_add_mod.patient_sub.document.getElementById("isNatIdMandatory").value=="Y" && f_query_add_mod.patient_sub.document.getElementById("nat_id_reqd_all_series").value=='Y'){
	canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("national_id_no"), f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
}//Above else if condition by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491]
if(f_query_add_mod.patient_sub.document.getElementById("national_id_no").value!=""){
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ='<root><SEARCH /></root>';
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open('POST','../../eMP/jsp/MPIntermediate.jsp?action=chkInActiveNatId&national_id_no='+f_query_add_mod.patient_sub.document.getElementById("national_id_no").value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	if(responseText > 0){
		canSave == false;
		error	= getMessage('NAT_ID_INACTIVE','MP');
		error = error.replace("#",f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
		LocalErrors += error+ "<br>";
	}
}

//Below validation commented by Dharma on 21st June 2019 against 70784
/*pat_ser_grp_obj = f_query_add_mod.patient_sub.document.getElementById("pat_ser_grp_code")

if(f_query_add_mod.patient_sub.pat_sergrp_id_types[pat_ser_grp_obj.selectedIndex] == "A")
{

	canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no"), f_query_add_mod.patient_sub.document.getElementById("altId1Desc").value);
}*/

//if ( !doDateCheckAlert(f_query_add_mod.patient_sub.document.getElementById("date_of_birth"),f_query_add_mod.patient_sub.document.getElementById("ServerDate"),f_query_add_mod.patient_sub.document.getElementById("other_era_diff").value) )
if(f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value!="")
{
	if ( !f_query_add_mod.patient_sub.isBeforeNow(f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value,"DMY",localeName) ) 
	{
		LocalErrors += f_query_add_mod.patient_sub.getMessage('DOB_CHECK','Common') + ' <br>';
		canSave = false;
	}
}
//Added by Mallikarjuna on 13/03/2003 for National ID Validation with Date of Birth & Sex.
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
										
									
									 //Below contion modified for this CRF ML-MMOH-CRF-0778
									if ((sexIdent!=f_query_add_mod.patient_sub.document.getElementById("sex").value) && (f_query_add_mod.patient_sub.document.getElementById("checkNatIdWithGender") && f_query_add_mod.patient_sub.document.getElementById("checkNatIdWithGender").value=="false"))
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
			//End of the addition

				/*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] Start*/ 
				if(f_query_add_mod.patient_sub.document.getElementById("national_id_no") && f_query_add_mod.patient_sub.document.getElementById("isValidateNatIDWithDOB").value=="true"){
					var dobVal		= f_query_add_mod.patient_sub.document.getElementById("date_of_birth").value;
					var natIdVal	= f_query_add_mod.patient_sub.document.getElementById("national_id_no").value;
					if(dobVal!= "" && natIdVal!=""){
						if(!f_query_add_mod.patient_sub.fnChkDOBNatIDValidation(dobVal,natIdVal)){
							var natmsg = f_query_add_mod.patient_sub.getMessage("MISMATCH_NAT_DOB",'MP');
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
						if(!f_query_add_mod.patient_sub.chkNatIDWithGender(gender,natId)){
							var errmsg = f_query_add_mod.patient_sub.getMessage('MISMATCH_NAT_SEX','MP');
							errmsg = errmsg.replace('National ID', f_query_add_mod.patient_sub.document.getElementById("nat_id_prompt").value);
							LocalErrors += errmsg + ' <br>';
							canSave =false;
						}
					}
				}/*End*/

//Nationality Validation
if(f_query_add_mod.patient_sub.document.getElementById("nationality_desc").value=='')
	f_query_add_mod.patient_sub.document.getElementById("nationality_code").value='';

if (f_query_add_mod.patient_sub.document.getElementById("nationality_code").value == '')
{
	if(f_query_add_mod.patient_sub.document.getElementById("nationality_code").value=="")
	{
	canSave=checkForNull(getLabel('Common.nationality.label','common'));
	//checkForNull(canSave);
	}
}
if ( canSave == false )
	errorsThere = true;
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
		// Added against AMRI-CRF-0388 by shagar
			if(f_query_add_mod.patient_sub.document.getElementById("area_code_mand"))
			{
			if(f_query_add_mod.patient_sub.document.getElementById("r_area_code").value=="")
			{
				canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById("area_code_prompt").value);
			}
            if ( canSave == false )
                errorsThere = true;
			}
            if(f_query_add_mod.patient_sub.document.getElementById("postal_code_mand"))
			{
			if(f_query_add_mod.patient_sub.document.getElementById("r_postal_code").value=="")
			{
				canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById("postal_code_prompt").value);
			}
            if ( canSave == false )
                errorsThere = true;
			}
			//end here
            //Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
            if(f_query_add_mod.patient_sub.document.getElementById("town_code_mand"))
			{
			if(f_query_add_mod.patient_sub.document.getElementById("r_town_code").value=="")
			{
				canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById("town_code_prompt").value);
			}
            if ( canSave == false )
                errorsThere = true;
			}
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
//Ends here			
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
		LocalErrors += f_query_add_mod.patient_sub.getMessage("MAX_PATIENT_AGE",'MP')+" "+maxAge+" "+getLabel("Common.Years.label","common")+"  <br>";
		canSave = false;
	}
}
//end of validation
if(f_query_add_mod.patient_sub.document.getElementById("isNatIdAltIdMandVisaType").value=='false') //Maheshwaran added for AAKH-CRF-0145
{
			if(f_query_add_mod.patient_sub.document.getElementById("citizen_yn").value == "N")
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
//Added for Billing on 16/8/2002 by kumar for Validating any values are entered.
var bl_install = f_query_add_mod.patient_sub.Rapid_Regn.bl_install_yn.value;

if (bl_install=="Y")
{
	var bl_success = f_query_add_mod.patient_sub.Rapid_Regn.bl_success.value;
	if (bl_success=="N")
	{
		LocalErrors += f_query_add_mod.patient_sub.getMessage("FINANCIAL_DET_MANDATORY",'MP') + ' <br>';
		canSave = false;
	}
	
	//Added by Ashwini on 07-Sep-2018
	var finDtlsChkNationality = f_query_add_mod.patient_sub.document.getElementById("finDtlsChkNationality").value;
	if(canSave && finDtlsChkNationality != "true")
	{  
		if(f_query_add_mod.patient_sub.document.forms[0].dflt_nat_id_chk_val.value != f_query_add_mod.patient_sub.document.forms[0].nationality_code.value)
		{  
			LocalErrors += f_query_add_mod.patient_sub.getMessage("NATIONALITY_CHANGED",'MP') + ' <br>';
			canSave = false;
		}
	}
}
//End of addition
if ( canSave == false )
    errorsThere = true;
// added by mujafar for KDAH-CRF-370.1  start
if(f_query_add_mod.patient_sub.document.getElementById("chkPanValidate").value=="true" && f_query_add_mod.patient_sub.document.getElementById("alt_id3_no"))
{
if(canSave==true && errorsThere == false )	
{
if(f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").value)
{ 
	if(f_query_add_mod.patient_sub.document.getElementById("pan_holder_name").value=="" && f_query_add_mod.patient_sub.document.getElementById("pan_status").value=="")
	{	
		
		if(f_query_add_mod.patient_sub.document.getElementById("pancard_no").value != f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").value)
		{
		
		alert(getMessage('PANCARD_VALIDATE_MNDT','MP'));
		f_query_add_mod.patient_sub.document.getElementById("pan_val_button").focus();
		canSave = false;
		if ( canSave == false )
        errorsThere = true;
		}
	}
}

}
// added by mujafar for KDAH-CRF-370.1  end
if(canSave==true && errorsThere == false )	
{
       // added by mujafar for KDAH-CRF-370.1 start
	if(f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").value)
	{
		if(f_query_add_mod.patient_sub.document.getElementById("pan_status").value!="")
			if(f_query_add_mod.patient_sub.document.getElementById("pan_rel_mem").value=="")
			{
				
				alert(getMessage('PANCARD_RELATION_MNDT','MP'));
				f_query_add_mod.patient_sub.document.getElementById("pan_rel_mem").focus();
				canSave = false;
				if ( canSave == false )
				errorsThere = true;
			}
			
	}
} 
if(canSave==true && errorsThere == false )	
{
var birthDate=convertDate(f_query_add_mod.patient_sub.document.getElementById("Birth_Date").value,"DMYHMS",localeName,"en");
		if(birthDate.length==19)birthDate=birthDate.substring(0,16);	
       if(birthDate.length==18)birthDate=birthDate.substring(0,15);		
       if(birthDate.length==17)birthDate=birthDate.substring(0,14);
	   
if(birthDate!= null)
{
var time_temp = birthDate.split("/");
var time_yr = time_temp[2].split(" ");

var  ages =  calculate_age(time_temp[1],time_temp[0],time_yr[0]);

if(f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").value && (ages>=18))
{ 
	
	
		if(f_query_add_mod.patient_sub.document.getElementById("pan_rel_mem").value != 'S')
		{
			
			alert(getMessage('PANCARD_SELF_MNDT','MP'));
		f_query_add_mod.patient_sub.document.getElementById("pan_rel_mem").focus();
		canSave = false;
		if ( canSave == false )
        errorsThere = true;
		}
		
}	
	
}   
}
}

	
	

    if ( canSave == true && errorsThere == false )
     { 
        // added by mujafar for KDAH-CRF-370.1  end
        for(i=0;i<f_query_add_mod.patient_sub.Rapid_Regn.elements.length;i++)
         {
            var ele = f_query_add_mod.patient_sub.Rapid_Regn.elements[i]
            if(ele.disabled)
            {
                ele.disabled=false
                dis_list[i]=ele
            }
         }
	// added by mujafar for KDAH-CRF-370.1  start
		if(f_query_add_mod.patient_sub.document.getElementById("chkPanValidate").value=="true" && f_query_add_mod.patient_sub.document.getElementById("alt_id3_no"))
		{		
		if(f_query_add_mod.patient_sub.document.getElementById("alt_id3_no").value && f_query_add_mod.patient_sub.document.getElementById("pan_rel_mem").value == 'S')
				{
				var temp1 = f_query_add_mod.patient_sub.document.getElementById("pan_holder_name").value;
				
				var temp_var = f_query_add_mod.patient_main.document.getElementById("patient_name").value;
				if(temp_var !=null)
				{
				temp_var = temp_var.split(". ");
				if(temp_var[1] !=null)
				var temp2= temp_var[1].toUpperCase();
				
				if(temp1!=temp2)
					
				alert(getMessage('PANCARD_NOT_MATCH_NAME','MP'));
				}
			}
		}
	// added by mujafar for KDAH-CRF-370.1 end
         f_query_add_mod.patient_sub.Rapid_Regn.submit();
     }
     else
     {
        multipleclicks='false';                 
      
      var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><head><META HTTP-EQUIV='Content-Type' CONTENT='text/html; charset=UTF-8'>" +
                        "</head><body onKeyDown='lockKey()'><form name='f' id='f' method='post' action='../../eCommon/jsp/error.jsp'>"+
                        "<input type='hidden' name='err_num' id='err_num' value=\""+LocalErrors+Alt_error+"\">"
                        "</form></body></html>" ;
                    messageFrame.document.body.insertAdjacentHTML('afterbegin',s);
                    messageFrame.document.f.submit();
      }
    }
    else
        multipleclicks='false';
  }
else
{
    //messageFrame.location = '../../eCommon/jsp/error.jsp?err_num='+LocalErrors+Alt_error;
    var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><head><META HTTP-EQUIV='Content-Type' CONTENT='text/html; charset=UTF-8'>" +
            "</head><body onKeyDown='lockKey()'><form name='f' id='f' method='post' action='../../eCommon/jsp/error.jsp'>"+
            "<input type='hidden' name='err_num' id='err_num' value=\""+LocalErrors+Alt_error+"\">"
            "</form></body></html>" ;
        messageFrame.document.body.insertAdjacentHTML('afterbegin',s);
        messageFrame.document.f.submit();

    multipleclicks='false';
}
}

function reset() {
    /*
    f_query_add_mod.patient_sub.document.forms[0].reset();
    f_query_add_mod.patient_main.document.getElementById("patient_id").value='';
    f_query_add_mod.patient_main.document.getElementById("patient_name").value='';
    if (f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang") != null)
        f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value = '';

    if(f_query_add_mod.patient_sub.document.getElementById("alt_id1_exp_date") != null)
    {
        if(f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").value == '' || f_query_add_mod.patient_sub.document.getElementById("alt_id1_no").value == null)
            f_query_add_mod.patient_sub.document.getElementById("alt_id1_exp_date").readOnly = true;
     }

    if(f_query_add_mod.patient_sub.document.getElementById("alt_id2_exp_date") != null)
    {
        if(f_query_add_mod.patient_sub.document.getElementById("alt_id2_no").value == '' ||  f_query_add_mod.patient_sub.document.getElementById("alt_id2_no").value == null)
            f_query_add_mod.patient_sub.document.getElementById("alt_id2_exp_date").readOnly = true;
    }
    dispMandatoryImage()*/
if(f_query_add_mod.patient_sub!=null)
 {
    f_query_add_mod.patient_main.document.getElementById("patient_id").value='';
    f_query_add_mod.patient_main.document.getElementById("patient_name").value='';
    if (f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang") != null)
        f_query_add_mod.patient_main.document.getElementById("patient_name_loc_lang").value = '';
	    f_query_add_mod.location.reload();  //Changed by S.Sathish for IN020269 on Thursday, March 25, 2010
	doValidation = false;
 }
}
function onSuccess() {

}

async function searchCode(obj,target)
    {
            var retVal =    new String();
            var dialogHeight= "400px" ;
            var dialogWidth = "700px" ;
            var status = "no";
            var arguments   = "" ;
            var sql="";
            var search_code="";
            var search_desc="";
            var tit="";

            if(obj.name=="postal_code")
            {
                tit=getLabel("eMP.postalcode.label","MP");
                sql="select postal_code, short_desc from mp_postal_code_lang_vw where language_id=`"+localeName+"`";
                search_code="postal_code";
                search_desc= "short_desc"
            }
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
            retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

            if (!(retVal == null))
            {
                target.value=retVal;
            }
            else
                target.focus();
    }

    function copyDetails(Val)   {
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
        if ( Val == 1 )
        {
            if ( document.getElementById("family_link_no").value.length > 0 )
            {
               /*var HTMLVal = new String();
                HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='8'><input type='hidden' name='head_patient_id' id='head_patient_id' value='" + document.getElementById("family_link_no").value +"'></form></BODY></HTML>";
                parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
                parent.parent.messageFrame.document.form1.submit();*/
				xmlStr+=" process_id=\"8\" ";
				xmlStr+=" head_patient_id=\""+document.getElementById("family_link_no").value+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				var url = "../../eMP/jsp/ServerValidationXML.jsp";
				xmlHttp.open("POST", url, false);
				xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
				xmlHttp.send(xmlDoc);
				eval(xmlHttp.responseText);
            }
        }
        if ( Val == 2 )
        {
		
		/*
		if(document.getElementById("next_contact_name") != null)
            document.getElementById("next_contact_name").value = "";
		*/

        if(document.getElementById("next_addr_line1") != null)
           document.getElementById("next_addr_line1").value = document.getElementById("r_addr_line1").value ;
        if(document.getElementById("next_addr_line2") != null)
			document.getElementById("next_addr_line2").value = document.getElementById("r_addr_line2").value ;

        if(document.getElementById("next_addr_line3") != null)
			document.getElementById("next_addr_line3").value = document.getElementById("r_addr_line3").value ;
		if(document.getElementById("contact1_res_town_code") != null)
            document.getElementById("contact1_res_town_code").value = document.getElementById("r_town_code").value ;
		if(document.getElementById("n_town") != null)
            document.getElementById("n_town").value = document.getElementById("r_town").value ;

		if(document.getElementById("contact1_region_code") != null)
            document.getElementById("contact1_region_code").value = document.getElementById("r_region_code").value ;
		if(document.getElementById("n_region") != null)
            document.getElementById("n_region").value = document.getElementById("r_region").value ;
		
		if(document.getElementById("contact1_res_area_code") != null)
            document.getElementById("contact1_res_area_code").value = document.getElementById("r_area_code").value ;
		if(document.getElementById("n_area") != null)
            document.getElementById("n_area").value = document.getElementById("r_area").value ;

        if(document.getElementById("next_addr_line4") != null)
        document.getElementById("next_addr_line4").value = document.getElementById("r_addr_line4").value ;

        if(document.getElementById("next_postal_code") != null)
        document.getElementById("next_postal_code").value = document.getElementById("r_postal_code").value ;

		 if(document.getElementById("next_postal_code1") != null)
        document.getElementById("next_postal_code1").value = document.getElementById("r_postal_code1").value ;

        if(document.getElementById("next_country_code") != null)
        document.getElementById("next_country_code").value = document.getElementById("r_country_code").value ;
		if(document.getElementById("next_country_desc") != null)
        document.getElementById("next_country_desc").value = document.getElementById("r_country_desc").value ;

        if(document.getElementById("next_res_tel_no") != null)
        document.getElementById("next_res_tel_no").value = document.getElementById("contact1_no").value ;

        if(document.getElementById("next_off_tel_no") != null)
			{
			if(document.getElementById("contact2_no") != null)
				{
		        //document.getElementById("next_off_tel_no").value = document.getElementById("contact2_no").value ;
				}
			}

       
        }
		if(Val == 3)
		{
			if(document.getElementById("m_addr_line1") != null)
				document.getElementById("m_addr_line1").value = document.getElementById("r_addr_line1").value;     
			
			if(document.getElementById("m_addr_line2") != null)
			   document.getElementById("m_addr_line2").value = document.getElementById("r_addr_line2").value;       
			
			if(document.getElementById("m_addr_line3") != null)
			   document.getElementById("m_addr_line3").value = document.getElementById("r_addr_line3").value;       
			
			if(document.getElementById("m_addr_line4") != null)
			   document.getElementById("m_addr_line4").value = document.getElementById("r_addr_line4").value;        
			
			if(document.getElementById("m_postal_code") != null)
			   document.getElementById("m_postal_code").value = document.getElementById("r_postal_code").value;		

			if(document.getElementById("m_postal_code1") != null)
			   document.getElementById("m_postal_code1").value = document.getElementById("r_postal_code1").value;
			
			if(document.getElementById("m_town_code") != null)
			   document.getElementById("m_town_code").value = document.getElementById("r_town_code").value;	
			
			if(document.getElementById("m_town") != null)
			   document.getElementById("m_town").value = document.getElementById("r_town").value;	
			
			if(document.getElementById("m_region_code") != null)
			   document.getElementById("m_region_code").value = document.getElementById("r_region_code").value;	
			
			if(document.getElementById("m_region") != null)
			   document.getElementById("m_region").value = document.getElementById("r_region").value;		
			
			if( document.getElementById("m_area_code") != null)
			   document.getElementById("m_area_code").value = document.getElementById("r_area_code").value;	
			
			if(document.getElementById("m_area") != null)
			   document.getElementById("m_area").value = document.getElementById("r_area").value;     
			
			if(document.getElementById("m_country_code") != null)
			   document.getElementById("m_country_code").value = document.getElementById("r_country_code").value;
			
			if(document.getElementById("m_country_desc") != null)
			   document.getElementById("m_country_desc").value = document.getElementById("r_country_desc").value;
			
			if(document.getElementById("contact1_no") != null)
			   document.getElementById("contact1_no").value = document.getElementById("contact1_no").value;
			
			if(document.getElementById("contact2_no") != null)
			   document.getElementById("contact2_no").value = document.getElementById("contact2_no").value;
			
			if(document.getElementById("m_contact_name") != null)
			   document.getElementById("m_contact_name").value = document.getElementById("r_contact_name").value;
			
			if(document.getElementById("m_addr_line1") != null)
				document.getElementById("m_addr_line1").focus();
			   
		}/*Below line added for ML-MMOH-CRF-0601*/
		if(Val == 4)
		{
			if(document.getElementById("m_addr_line1") != null)
				document.getElementById("m_addr_line1").value = document.getElementById("a_addr_line1").value;     
			
			if(document.getElementById("m_addr_line2") != null)
			   document.getElementById("m_addr_line2").value = document.getElementById("a_addr_line2").value;       
			
			if(document.getElementById("m_addr_line3") != null)
			   document.getElementById("m_addr_line3").value = document.getElementById("a_addr_line3").value;       
			
			if(document.getElementById("m_addr_line4") != null)
			   document.getElementById("m_addr_line4").value = document.getElementById("a_addr_line4").value;        
			
			if(document.getElementById("m_postal_code") != null)
			   document.getElementById("m_postal_code").value = document.getElementById("alt_postal_code").value;		

			if(document.getElementById("m_postal_code1") != null)
			   document.getElementById("m_postal_code1").value = document.getElementById("alt_postal_code1").value;
			
			if(document.getElementById("m_town_code") != null)
			   document.getElementById("m_town_code").value = document.getElementById("a_town_code").value;	
			
			if(document.getElementById("m_town") != null)
			   document.getElementById("m_town").value = document.getElementById("a_town").value;	
			
			if(document.getElementById("m_region_code") != null)
			   document.getElementById("m_region_code").value = document.getElementById("a_region_code").value;	
			
			if(document.getElementById("m_region") != null)
			   document.getElementById("m_region").value = document.getElementById("a_region").value;		
			
			if( document.getElementById("m_area_code") != null)
			   document.getElementById("m_area_code").value = document.getElementById("a_area_code").value;	
			
			if(document.getElementById("m_area") != null)
			   document.getElementById("m_area").value = document.getElementById("a_area").value;     
			
			if(document.getElementById("m_country_code") != null)
			   document.getElementById("m_country_code").value = document.getElementById("a_country_code").value;
			
			if(document.getElementById("m_country_desc") != null)
			   document.getElementById("m_country_desc").value = document.getElementById("a_country_desc").value;
			
			/*if(document.getElementById("contact1_no") != null)
			   document.getElementById("contact1_no").value = document.getElementById("contact1_no").value;
			
			if(document.getElementById("contact2_no") != null)
			   document.getElementById("contact2_no").value = document.getElementById("contact2_no").value;
			
			if(document.getElementById("m_contact_name") != null)
			   document.getElementById("m_contact_name").value = document.getElementById("r_contact_name").value;*/
			
			if(document.getElementById("m_addr_line1") != null)
				document.getElementById("m_addr_line1").focus();
			   
		}
		
		//End ML-MMOH-CRF-0601
    }

    function get_patient_id()
    {
        var patient_id_back =  PatientSearch('','','','','','','','','','PAT_REG');

        if ((patient_id_back != null))
        {
            document.forms[0].family_link_no.value=patient_id_back;
            document.forms[0].family_link_no.focus();
        }
        else document.forms[0].family_link_no.focus();
}

/*function checkPatSex()  {
    var arLength = f_query_add_mod.patient_sub.NamePrefixArray.length;
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix").value!='')  && ( unescape(f_query_add_mod.patient_sub.NamePrefixArray[q]) == f_query_add_mod.patient_sub.document.getElementById("name_prefix").value ) )
            {
				if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById("sex").value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
                {
                //LocalErrors = LocalErrors +f_query_add_mod.patient_sub.getMessage("SEX_MIS_PREFIX",'MP')	+ " <br>";
				var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_prefix_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }

			if( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang").value!='') && (unescape(f_query_add_mod.patient_sub.NamePrefixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang").value) )
            {
				if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById("sex").value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_prefix_oth_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
					res = false;
                }
                else
                    res = true;
            }
            q++;
        }

    return res;
}
function checkPatSuffixSex()  {
    var arLength = f_query_add_mod.patient_sub.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (f_query_add_mod.patient_sub.document.getElementById("name_suffix").value!='')  && ( unescape(f_query_add_mod.patient_sub.NameSuffixArray[q]) == f_query_add_mod.patient_sub.document.getElementById("name_suffix").value ) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById("sex").value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }

			if( (f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang").value!='') && (unescape(f_query_add_mod.patient_sub.NameSuffixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang").value) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById("sex").value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_oth_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
					res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}
*/
function checkPatSex()  {
    var arLength = f_query_add_mod.patient_sub.NamePrefixArray.length;
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (f_query_add_mod.patient_sub.document.getElementById("name_prefix").value!='')  && ( unescape(f_query_add_mod.patient_sub.NamePrefixArray[q]) == f_query_add_mod.patient_sub.document.getElementById("name_prefix").value ) )
            {
				if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById("sex").value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					if(localeName=='en')
					{
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_prefix_prompt.value);
					}
					else
					{
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_prefix_oth_prompt.value);
					}
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}

function checkPatOthSex()  
{
    var arLength = f_query_add_mod.patient_sub.NamePrefixArray.length;
    var q = 0;
    var res = new Boolean(false);
	while ( q <= arLength  )
	{
		if( (f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang").value!='') && (unescape(f_query_add_mod.patient_sub.NamePrefixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById("name_prefix_oth_lang").value) )
		{
			if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById("sex").value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
			{
				var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
				msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_prefix_oth_prompt.value);
				LocalErrors = LocalErrors +msg	+ " <br>";
				res = false;
			}
			else
				res = true;
		}
            q++;
    }
    return res;
}
function checkPatSuffixSex()  {
    var arLength = f_query_add_mod.patient_sub.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (f_query_add_mod.patient_sub.document.getElementById("name_suffix").value!='')  && ( unescape(f_query_add_mod.patient_sub.NameSuffixArray[q]) == f_query_add_mod.patient_sub.document.getElementById("name_suffix").value ) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById("sex").value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					if(localeName=='en')
					{
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_prompt.value);
					}
					else
					{
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_oth_prompt.value);
					}
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}
function checkPatOthSuffixSex()  {
    var arLength = f_query_add_mod.patient_sub.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);
    while ( q <= arLength  )
    {
			if( (f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang").value!='') && (unescape(f_query_add_mod.patient_sub.NameSuffixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById("name_suffix_oth_lang").value) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById("sex").value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_oth_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
					res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}

function enableFields()
{
     for(i=0;i<dis_list.length;i++)
     {
         if(dis_list[i] != null)
            dis_list[i].disabled = true
     }
}

function apply() { 
if(f_query_add_mod.patient_sub!=null)
{
	if (f_query_add_mod.patient_sub.dataFetchedFromRepos!='Y')
		setTimeout("callApply()",500);
	else
		callApply();
 }
 else
 {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
 }

}
var currentTab = new String();
currentTab = "demogrp_tab";
var previousTab = new String();
previousTab = "demogrp_tab";
var prefixReqd;
function checkPatientId()   
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
			/*var HTMLVal = new String();
			HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='3'><input name='pat_id' id='pat_id' type='hidden' value=\""+document.getElementById("patient_id").value+"\"></form></BODY></HTML>";
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.document.form1.submit();*/
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
	
	function tab_click(objName)
	{
		// FIRST CHANGE THE CURRENT SELECTED TAB
		//changeTab(objName);
		if (objName == 'demogrp_tab')
		{
			parent.patient_sub.moveToTab(1);
		}

		else if (objName == 'others_tab')
		{
			parent.patient_sub.moveToTab(4);
		}
		else if (objName == 'findtl_tab')
		{
			chkOnSub();
		}
		if(objName=='#misc')
		{
			 document.getElementById("misc").scrollIntoView();
		}
		if(objName=='#kin')
		{
		   document.getElementById("kin").scrollIntoView();
		}
	}
	
	function changeTab(TabName) {


	// RESET THE OLD TAB WHICH IS SELECTED FIRST .............
		if (currentTab == 'demogrp_tab')
			document.getElementById("demogrp_tab").src = '../../eCommon/images/LDemographics.gif';
		else if (currentTab == 'others_tab')
			document.getElementById("others_tab").src = '../../eCommon/images/LOthers.gif';
		else if (currentTab == 'findtl_tab')
			document.getElementById("findtl_tab").src = '../../eBL/images/Financial Details_click.gif';

	// CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............

		if (TabName == 'demogrp_tab')
			document.getElementById("demogrp_tab").src = '../../eCommon/images/Demographics.gif';
		else if (TabName == 'others_tab')
			document.getElementById("others_tab").src = '../../eCommon/images/Others.gif';
		else if (TabName == 'findtl_tab')
			document.getElementById("findtl_tab").src = '../../eBL/images/Financial Details.gif';

		// FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER
		previousTab = currentTab;
		currentTab = TabName;

	}
/*added->05th Feb*/
async function getFinDtl(qryStr)
{
	var retVal;
/*	var dialogHeight= "24" ;//"22";
	var dialogWidth = "49" ;//"48";
	var dialogTop = "180" ;//"194";
	*/
	
	var dialogHeight= "90vh";
	var dialogWidth = "80vw";
	var dialogTop	= "0px";

	var center = "1" ;                                                         
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
	retVal = await top.window.showModalDialog(url,arguments,features);
	if(retVal==null) retVal="";
	return retVal;
	
}

function invokeRapidRegnTabs(objName)
{
	selectTab(objName);		
	parent.patient_sub.callTab(objName);				
}

async function callTab(objName)
{
						
	if(objName == 'demogrp_tab') { 
		document.getElementById("demo").style.display = 'inline';
		document.getElementById("misc").style.display = 'none';										
	} else if(objName == 'others_tab') {		
		document.getElementById("demo").style.display = 'none';		
		document.getElementById("misc").style.display = 'inline';
	} else if(objName == 'findtl_tab') {
		await chkOnSub();					
	}	
}

async function chkOnSub()
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
	var operation="Insert";
	var package_flag="N";
	var ins_auth_flag="N";
	var upd_pat_flag="N";
	var show_hide_blng_class="SHOW";
	var billing_group       = parent.frames[1].document.forms[0].billing_group;
	var billing_class       = parent.frames[1].document.forms[0].billing_class;
	var employer_code       = parent.frames[1].document.forms[0].employer_code;
	var cash_set_type1      = parent.frames[1].document.forms[0].cash_set_type1;
	var cash_insmt_ref1     = parent.frames[1].document.forms[0].cash_insmt_ref1;
	var cash_insmt_date1    = parent.frames[1].document.forms[0].cash_insmt_date1;
	var cash_insmt_rmks1    = parent.frames[1].document.forms[0].cash_insmt_rmks1;
	var cust_1              = parent.frames[1].document.forms[0].cust_1;
	var credit_doc_ref1     = parent.frames[1].document.forms[0].credit_doc_ref1;
	var credit_doc_date1    = parent.frames[1].document.forms[0].credit_doc_date1;
	var cust_2              = parent.frames[1].document.forms[0].cust_2;
	var credit_doc_ref2     = parent.frames[1].document.forms[0].credit_doc_ref2;
	var credit_doc_date2    = parent.frames[1].document.forms[0].credit_doc_date2;
	var cust_3              = parent.frames[1].document.forms[0].cust_3;
	var policy_type         = parent.frames[1].document.forms[0].policy_type;
	var policy_no           = parent.frames[1].document.forms[0].policy_no;
	var policy_expiry_date  = parent.frames[1].document.forms[0].policy_expiry_date;
	var non_insur_blng_grp  = parent.frames[1].document.forms[0].non_insur_blng_grp;
	var cash_set_type2      = parent.frames[1].document.forms[0].cash_set_type2;
	var cash_insmt_ref2     = parent.frames[1].document.forms[0].cash_insmt_ref2;
	var cash_insmt_date2    = parent.frames[1].document.forms[0].cash_insmt_date2;
	var cash_insmt_rmks2    = parent.frames[1].document.forms[0].cash_insmt_rmks2;
	var cust_4              = parent.frames[1].document.forms[0].cust_4;
	var credit_doc_ref3     = parent.frames[1].document.forms[0].credit_doc_ref3;
	var credit_doc_date3    = parent.frames[1].document.forms[0].credit_doc_date3;
	var setlmt_ind          = parent.frames[1].document.forms[0].setlmt_ind;
	var billing_mode        = parent.frames[1].document.forms[0].billing_mode;
	var cred_start_dt1    = parent.frames[1].document.forms[0].cred_start_dt1;
	var cred_start_dt2    = parent.frames[1].document.forms[0].cred_start_dt2;
	var cred_start_dt3    = parent.frames[1].document.forms[0].cred_start_dt3;
	
	var bl_data_from_repos_yn = "";
	var data_source_id = parent.frames[1].document.forms[0].datasource_id;
	if (data_source_id.value != '' && billing_group.value != '')
	{
		bl_data_from_repos_yn = "Y";
	}	

	if (billing_group.value != '')
		billing_mode.value = "Modify";

	if(billing_mode.value=="Modify"){
		operation="Update";
	}
	var upd_fin_dtls        = parent.frames[1].document.forms[0].upd_fin_dtls;
	var credit_auth_ref     = parent.frames[1].document.forms[0].credit_auth_ref;
	var credit_auth_date    = parent.frames[1].document.forms[0].credit_auth_date;
	var app_days            = parent.frames[1].document.forms[0].app_days;
	var app_amount          = parent.frames[1].document.forms[0].app_amount;
	var eff_frm_date        = parent.frames[1].document.forms[0].eff_frm_date;
	var remarks             = parent.frames[1].document.forms[0].remarks;

	//Added for Billing validation at the time of apply on 16/8/2002
		parent.frames[1].document.forms[0].bl_success.value = "N";

	//Added for Billing Enhancements
	var health_card_expired_yn = parent.frames[1].document.forms[0].health_card_expired_yn;
	var annual_income          = parent.frames[1].document.forms[0].annual_income;
	var family_asset           = parent.frames[1].document.forms[0].family_asset;
	var no_of_dependants       = parent.frames[1].document.forms[0].no_of_dependants;
	var resp_for_payment       = parent.frames[1].document.forms[0].resp_for_payment;
	var credit_doc_reqd_yn1    = parent.frames[1].document.forms[0].credit_doc_reqd_yn1;
	var credit_doc_reqd_yn2    = parent.frames[1].document.forms[0].credit_doc_reqd_yn2;   
	var calling_module_id	   = "MP";
	//var calling_function_id	   = "PAT_REG";
	var calling_function_id	   = parent.frames[1].document.forms[0].function_id.value; 	
	//end of Addition

	var episode="";
	var record="";  
		
	var qryStr="operation="+operation+"&package_flag="+package_flag+"&upd_pat_flag="+upd_pat_flag+"&show_hide_blng_class="+show_hide_blng_class+"&billing_mode="+billing_mode.value;

	qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
	qryStr += "&health_card_expired_yn="+health_card_expired_yn.value+"&bl_data_from_repos_yn="+bl_data_from_repos_yn+"&data_source_id="+data_source_id.value+"&episode="+episode+"&record="+record;
	
	
	////////August 03 2005 //////

		var nationality_yn = "N";
		parent.frames[1].document.forms[0].dflt_nat_id_chk_val.value = parent.frames[1].document.forms[0].nationality_code.value;
		if(parent.frames[1].document.forms[0].nationality_code.value == parent.frames[1].document.forms[0].dflt_nationality_code.value)
		{
			nationality_yn = "Y";
		}
		else 
		{
			nationality_yn = "N";
		}
		
		qryStr+="&nationality_yn="+nationality_yn;
		qryStr+="&patient_class=XT&pat_ser_code="+pat_ser_code;

		//////////////////////////
	//var qryStr="";
	var returnArray = new Array();
	returnArray = await getFinDtl(qryStr);

	//tab_click(previousTab);

	parent.patient_main.invokeRapidRegnTabs('demogrp_tab');	
	

	if(returnArray.length>0)
	{
		billing_group.value         = returnArray[0];	
		billing_mode.value          = "Modify"
		parent.frames[1].document.forms[0].bl_success.value = "Y";

		if(billing_mode.value=="Modify")
			operation="Update";
	} else {
		parent.frames[1].document.forms[0].bl_success.value = "N";
		return false;
	}		 	
	
}/*added->05th Feb*/
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
var PSGCodeArray = new Array(); 
var PSGYNArray = new Array(); 
/*var NamePrefixArray = new Array(); 
var NamePrefixLocArray = new Array(); 
var PrefixSexArray = new Array();
var NameSuffixArray = new Array();
var NameSuffixLocArray = new Array();
var SuffixSexArray = new Array();*/
var pat_name_in_loc_lang = new Array () ;


/*function ChangeInitCase(obj)
{
  var name=obj.value;
  var spltval = name.split(" ") ;
  var temp_name = ""
 for(var i=0;i<spltval.length;i++)
 {
	var length= obj.value.length;
  var letter = spltval[i].substring(0,length-(length-1));
  var rest = spltval[i].substring(1,length);
  letter=letter.toUpperCase();
  rest=rest.toLowerCase();
  var  namenow= letter.concat(rest);
  temp_name+= namenow+" "
 }
 obj.value= temp_name.substring(0,temp_name.length-1);
}*/

function focusBack()
{
	FocusFirstElement()
}

function CheckBirthPlace()
{

if(document.forms[0].place_of_birth_desc.value=="")			
   document.forms[0].place_of_birth.disabled=false;
else
   document.forms[0].place_of_birth.disabled=true;


}
function enableimg()
{
if(document.getElementById("family_link_no").value.length!=0)
document.getElementById("rel").style.visibility = 'visible';
else
document.getElementById("rel").style.visibility = 'hidden';
}
function CheckBirthCode()
{
if(document.forms[0].place_of_birth.value=="")
{
   document.forms[0].place_of_birth_desc.disabled=false;
	document.forms[0].birth_place.disabled=false;
}
else
{
document.forms[0].place_of_birth_desc.disabled=true;
document.forms[0].place_of_birth_code.value="";
   document.forms[0].birth_place.disabled=true;
}
	
}
function checkNRIC()
{

//if(!(document.forms[0].national_id_no.value==""))
	//document.forms[0].image1.style.visibility='visible';

}

function change_stat_dis() { 

	var dflt_nationality_code = document.Rapid_Regn.dft_natCd.value;

	if(dflt_nationality_code=='null') dflt_nationality_code='';	


	/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
	var isForm60Available	= document.Rapid_Regn.isForm60Available.value;
	var CalledFromFunction	=  document.Rapid_Regn.CalledFromFunction.value;
	var isForm60Validation	=  document.Rapid_Regn.isForm60Validation.value;
	/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/

	if(document.Rapid_Regn.citizen[0].checked==true) {
		document.Rapid_Regn.legal[0].checked=true;
		//document.Rapid_Regn.all.citizen_yn.value='Y';
		//document.Rapid_Regn.all.legal_yn.value='Y';

		document.Rapid_Regn.citizen_yn.value='Y';
		document.Rapid_Regn.legal_yn.value='Y';			
		document.Rapid_Regn.legal[0].disabled=true;
		document.Rapid_Regn.legal[1].disabled=true;	
		
		document.Rapid_Regn.nationality_code.value=document.Rapid_Regn.dft_natCd.value;
		document.Rapid_Regn.nationality_desc.value=document.Rapid_Regn.dft_natDesc.value;
		document.Rapid_Regn.race_code.value=document.Rapid_Regn.dft_raceCd.value;
		document.getElementById("race_desc").value = document.getElementById("default_race_desc").value;
		
		/*Below line Added for this CRF GHL-CRF-0332 [IN:042060]*/
				  if(document.Rapid_Regn.alt_id1_man_non_ctz && document.Rapid_Regn.alt_id1_man_non_ctz.value=="true"){ 
					   if(document.forms[0].alt1_gif){
					      document.Rapid_Regn.alt_id1_reqd_yn.value='N'; 
					      document.forms[0].alt1_gif.style.visibility='hidden';
					   }
					   if(document.forms[0].alt1_exp_date1){
					      document.Rapid_Regn.alt_date1_reqd_yn.value='N';
					      document.forms[0].alt1_exp_date1.style.visibility='hidden';			
				       } 
				  }	  //End GHL-CRF-0332 [IN:042060]
				/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] Start*/
				//Maheshwaran added isNatIdAltIdMandVisaType- for AAKH-CRF-0145 as on 22-04-2022
				if((document.Rapid_Regn.isNatIdOrAltId1MandRes && document.Rapid_Regn.isNatIdOrAltId1MandRes.value=="true") || (document.Rapid_Regn.isNatIdOrAltIdMandVisaType.value=="true") || (document.Rapid_Regn.isNatIdAltIdMandVisaType.value=="true")){
					getVisibleMandNatAltIds();
				}
				/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] End*/

				  /*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
					if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){

						//document.Rapid_Regn.formno60.value="N";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
						document.Rapid_Regn.formno60.disabled=false;

						//document.Rapid_Regn.alt_id3_no.value="";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
						if(document.Rapid_Regn.formno60.value=="N")
							document.Rapid_Regn.alt_id3_no.disabled=false;
						//Commented by Dharma on July 14th 2016 against KDAH-SCF-0358 [IN:060809]
						/*document.Rapid_Regn.alt_id3_reqd_yn.value="Y";
						document.getElementById("alt3_gif").style.visibility='visible';*/
					}
				/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
		
		
	} else { 
		document.Rapid_Regn.legal[0].checked=true;
		document.Rapid_Regn.citizen_yn.value='N';
		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
		if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){
			/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] Start*/
			
			/*document.Rapid_Regn.formno60.value="N";
			document.PatRegForm.formno60.disabled=true;

			document.Rapid_Regn.alt_id3_no.value="";
			document.Rapid_Regn.alt_id3_no.disabled=true;*/

			/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] End*/

			document.Rapid_Regn.alt_id3_reqd_yn.value="N";
			document.getElementById("alt3_gif").style.visibility='hidden';
		}
		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
	}
	
}
function select_val() {

	if(document.Rapid_Regn.legal[0].checked==true) {
		document.Rapid_Regn.legal_yn.value='Y';
	} else	{
		document.Rapid_Regn.legal_yn.value='N';
	}	
}

function enableAltID(){
	
	document.forms[0].other_alt_Id_text.value="";	
	if(document.forms[0].other_alt_id.selectedIndex != 0){
		document.forms[0].other_alt_Id_text.disabled = false;
	}
	else 
		document.forms[0].other_alt_Id_text.disabled = true;

}
async function searchBirthplace(obj,target)
{
	

	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	
		
		if(target.name == 'place_of_birth_desc'){
		tit=getLabel("Common.birthPlace.label","common");
		sql="Select birth_place_code code,long_desc description from Mp_birth_place_lang_vw where eff_status='E' and  upper(birth_place_code) like upper(?) and upper(long_desc) like upper(?) and language_id='"+localeName+"' order by 2";
		}
		/*else{
			tit=getLabel('Common.country.label','common');
			sql="Select country_code code,short_name description from Mp_Country where eff_status='E' and upper(country_code) like upper(?) and upper(short_name) like upper(?)  and language_id='"+localeName+"' order by 2";
		} */
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'place_of_birth_desc')
		{
			document.forms[0].place_of_birth_code.value= arr[0];
			
			//Below line commented for this SCF ML-MMOH-SCF-0860
			//document.forms[0].place_of_birth.disabled=true;
		}
		/*else if(target.name == 'r_country_desc')
			document.forms[0].r_country_code.value= arr[0];
		else if(target.name == 'm_country_desc')
			document.forms[0].m_country_code.value= arr[0];
		else if(target.name == 'next_country_desc')
			document.forms[0].next_country_code.value= arr[0]; */
		//target.focus();		
	}
	else{
		target.value='';
		//target.focus();
	}
}
async function searchCountry(obj,target)
{ 
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	if(obj.name=="contry_code")
	{
		
		if(target.name == 'nationality_desc'){
		tit=getLabel("Common.nationality.label","common");
		sql="Select country_code code,long_desc description from Mp_Country_lang_vw where eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?)  and language_id='"+localeName+"' order by 2";
		}
		else{
			tit=getLabel("Common.country.label","common");
			sql="Select country_code code,long_name description from Mp_Country_lang_vw where eff_status='E' and upper(country_code) like upper(?) and upper(long_name) like upper(?)  and language_id='"+localeName+"' order by 2";
		}
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'nationality_desc')
			document.forms[0].nationality_code.value= arr[0];
		else if(target.name == 'r_country_desc')
			document.forms[0].r_country_code.value= arr[0];
		else if(target.name == 'm_country_desc')
			document.forms[0].m_country_code.value= arr[0];
		else if(target.name == 'next_country_desc')
			document.forms[0].next_country_code.value= arr[0];
		else if(target.name == 'a_country_desc')
			document.forms[0].a_country_code.value= arr[0];				
		/*Above line added for this CRF ML-MMOH-CRF-0860.2*/	
		//target.focus();		
	}
	else{
		target.value='';
		//target.focus();
	}
}
var PSGCodeArray = new Array(); 
var PSGYNArray = new Array(); 
var NamePrefixArray = new Array(); 
var PrefixSexArray = new Array();
var NamePrefixLocArray = new Array(); 
var pat_name_in_loc_lang = new Array () ;


/*function ChangeInitCase(obj)
{
  var name=obj.value;
  var spltval = name.split(" ") ;
  var temp_name = ""
 for(var i=0;i<spltval.length;i++)
 {
	var length= obj.value.length;
  var letter = spltval[i].substring(0,length-(length-1));
  var rest = spltval[i].substring(1,length);
  letter=letter.toUpperCase();
  rest=rest.toLowerCase();
  var  namenow= letter.concat(rest);
  temp_name+= namenow+" "
 }
 obj.value= temp_name.substring(0,temp_name.length-1);
}*/

function focusBack(){
FocusFirstElement()

}

//added by gomathi.
function CheckBirthPlace()
{
//Added by Sangeetha for ML-MMOH-SCF-0717
if(document.forms[0].txtSmart_fn_name.value != '03'){
	if(document.forms[0].place_of_birth_desc.value=="")			
	   document.forms[0].place_of_birth.disabled=false;
	else
	   document.forms[0].place_of_birth.disabled=true;
}

}
function enableimg()
{
if(document.getElementById("family_link_no").value.length!=0)
document.getElementById("rel").style.visibility = 'visible';
else
document.getElementById("rel").style.visibility = 'hidden';
}
function CheckBirthCode()
{
//Added by Sangeetha for ML-MMOH-SCF-0717
if(document.forms[0].txtSmart_fn_name.value != '03'){
	if(document.forms[0].place_of_birth.value=="")
	{
	   document.forms[0].place_of_birth_desc.disabled=false;
		document.forms[0].birth_place.disabled=false;
	}
	else
	{
	document.forms[0].place_of_birth_desc.disabled=true;
	document.forms[0].place_of_birth_code.value="";
	   document.forms[0].birth_place.disabled=true;
	}
}	
}
function checkNRIC()
{

//if(!(document.forms[0].national_id_no.value==""))
	//document.forms[0].image1.style.visibility='visible';
}

function change_status() {

	document.Rapid_Regn.nationality_code.value='';
	document.Rapid_Regn.nationality_desc.value='';
	document.Rapid_Regn.race_code.value='';	
	document.Rapid_Regn.race_desc.value='';	

	/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
	var isForm60Available	= document.Rapid_Regn.isForm60Available.value;
	var CalledFromFunction	=  document.Rapid_Regn.CalledFromFunction.value;
	var isForm60Validation	=  document.Rapid_Regn.isForm60Validation.value;
	/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
	
	if(document.Rapid_Regn.citizen[0].checked==true) {
		document.Rapid_Regn.legal[0].disabled=true;
		document.Rapid_Regn.legal[1].disabled=true;
		document.Rapid_Regn.citizen_yn.value='Y';		
		document.Rapid_Regn.legal_yn.value='Y';	
		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
		if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){
			//document.Rapid_Regn.formno60.value="N";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
			document.Rapid_Regn.formno60.disabled=false;

			//document.Rapid_Regn.alt_id3_no.value="";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
			if(document.Rapid_Regn.formno60.value=="N")
				document.Rapid_Regn.alt_id3_no.disabled=false;
			//Commented by Dharma on July 14th 2016 against KDAH-SCF-0358 [IN:060809]
			/*document.Rapid_Regn.alt_id3_reqd_yn.value="Y";
			document.getElementById("alt3_gif").style.visibility='visible';*/
		}
		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/


	} else {
		document.Rapid_Regn.legal[0].disabled=false;
		document.Rapid_Regn.legal[1].disabled=false;
		document.Rapid_Regn.citizen_yn.value='N';	    
	   /*Below line Added for this CRF GHL-CRF-0332 [IN:042060]*/
	   	if(document.Rapid_Regn.alt_id1_man_non_ctz && document.Rapid_Regn.alt_id1_man_non_ctz.value=="true") { 
					  if(document.forms[0].alt1_gif){
					     document.Rapid_Regn.alt_id1_reqd_yn.value='Y'; 
					     document.forms[0].alt1_gif.style.visibility='visible';
						 document.Rapid_Regn.alt_id1_no.disabled=false;
					  }
					  if(document.forms[0].alt1_exp_date1){
					     document.Rapid_Regn.alt_date1_reqd_yn.value='Y';
					     document.forms[0].alt1_exp_date1.style.visibility='visible';
					  }						
		}//End GHL-CRF-0332 [IN:042060] 
	  /*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] Start*/
	  //Maheshwaran added isNatIdAltIdMandVisaType- for AAKH-CRF-0145 as on 22-04-2022
		if((document.Rapid_Regn.isNatIdOrAltId1MandRes && document.Rapid_Regn.isNatIdOrAltId1MandRes.value=="true") || (document.Rapid_Regn.isNatIdOrAltIdMandVisaType.value=="true") || (document.Rapid_Regn.isNatIdAltIdMandVisaType.value=="true")){
			getVisibleMandNatAltIds();
		}
		/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] End*/
	  
	   /*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
		if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){
			/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] Start*/
			/*document.Rapid_Regn.formno60.value="N";
			document.Rapid_Regn.formno60.disabled=true;

			document.Rapid_Regn.alt_id3_no.value="";
			document.Rapid_Regn.alt_id3_no.disabled=true;*/
			/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] End*/
			document.Rapid_Regn.alt_id3_reqd_yn.value="N";
			document.getElementById("alt3_gif").style.visibility='hidden';
		}
		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
		
	}
}

function enableAltID(){
	
	document.forms[0].document.getElementById('other_alt_Id_text').value="";	
	if(document.forms[0].document.getElementById('other_alt_id').selectedIndex != 0){
		document.forms[0].document.getElementById('other_alt_Id_text').disabled = false;
	}
	else 
		document.forms[0].other_alt_Id_text.disabled = true;

}
async function searchBirthplace(obj,target)
{   
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	
		
		if(target.name == 'place_of_birth_desc'){
		tit=getLabel("Common.birthPlace.label","common");
		sql="Select birth_place_code code,long_desc description from Mp_birth_place_lang_vw where eff_status='E' and  upper(birth_place_code) like upper(?) and upper(long_desc) like upper(?)  and language_id='"+localeName+"' order by 2";
		}
		/*else{
			tit="Country"
			sql="Select country_code code,short_name description from Mp_Country where eff_status='E' and upper(country_code) like upper(?) and upper(short_name) like upper(?) order by 2";
		} */
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'place_of_birth_desc')
		{
			document.forms[0].place_of_birth_code.value= arr[0];

			 //Below line modified for this SCF ML-MMOH-SCF-0860
			/*Added by Sangeetha for ML-MMOH-SCF-0717
			if(document.forms[0].txtSmart_fn_name.value != '03')
			document.forms[0].place_of_birth.disabled=true;*/
			//End this SCF ML-MMOH-SCF-0680
			
		}
		/*else if(target.name == 'r_country_desc')
			document.forms[0].r_country_code.value= arr[0];
		else if(target.name == 'm_country_desc')
			document.forms[0].m_country_code.value= arr[0];
		else if(target.name == 'next_country_desc')
			document.forms[0].next_country_code.value= arr[0]; */
		//target.focus();		
	}
	else{
		target.value='';
		//target.focus();
	}
}
async function searchCountry(obj,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	if(obj.name=="contry_code")
	{
		
		if(target.name == 'nationality_desc'){
		tit=getLabel("Common.nationality.label","common");
		sql="Select country_code code,long_desc description from Mp_Country_lang_vw where eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?)  and language_id='"+localeName+"' order by 2";
		}
		else{
			tit=getLabel("Common.country.label","common");
			sql="Select country_code code,long_name description from Mp_Country_lang_vw where eff_status='E' and upper(country_code) like upper(?) and upper(long_name) like upper(?)  and language_id='"+localeName+"' order by 2";
		}
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'nationality_desc')
			document.forms[0].nationality_code.value= arr[0];
		else if(target.name == 'r_country_desc')
			document.forms[0].r_country_code.value= arr[0];
		else if(target.name == 'm_country_desc')
			document.forms[0].m_country_code.value= arr[0];
		else if(target.name == 'next_country_desc')
			document.forms[0].next_country_code.value= arr[0];
		else if(target.name == 'a_country_desc')
			document.forms[0].a_country_code.value= arr[0];				
		/*Above line added for this CRF ML-MMOH-CRF-0860.2*/	
			
		//target.focus();		
	}
	else{
		target.value='';
		//target.focus();
	}
}

function checkPatGenYN()    {
	var arLength = PSGCodeArray.length;
    var q = 0;

	if(parent.frames[1].document.forms[0].bl_success) {
		parent.frames[1].document.forms[0].bl_success.value = "N";
	}

	if(parent.patient_main.patient_id)
		parent.patient_main.patient_id.readOnly = true;

    while ( q <= arLength  )
    {
    if ( PSGCodeArray[q] == document.getElementById("pat_ser_grp_code").value )
    {
        if ( PSGYNArray[q] == 'N' )
        {
            alert(getMessage("PAT_ID_SERIES",'MP'))
			
			if(parent.patient_main.document.getElementById(patient_id)){
			  parent.patient_main.document.getElementById(patient_id).readOnly = false;
			  parent.patient_main.document.getElementById(patient_id).value = '';
			  parent.patient_main.document.getElementById(patient_id).focus();
			}
            document.getElementById("pat_no_gen_yn").value  = 'N';
        }
        else
        {
            document.getElementById("pat_no_gen_yn").value  = 'Y';
			if(parent.patient_main.document.getElementById(patient_id)){
	            parent.patient_main.document.getElementById(patient_id).readOnly = true;
		        parent.patient_main.document.getElementById(patient_id).value = '';
			}
        }
    }
    q++;
    }
    dispMandatoryImage();
//	if (parent.patient_sub.document.forms[0].pat_name_in_loc_lang_reqd_yn.value=='Y')
	dispMandatoryImageForOthNames();
	var isNatIdOrAltIdMandVisaType	= document.getElementById("isNatIdOrAltIdMandVisaType").value;
	var isNatIdAltIdMandVisaType	= document.getElementById("isNatIdAltIdMandVisaType").value;//Maheshwaran added isNatIdAltIdMandVisaType- for AAKH-CRF-0145 as on 22-04-2022
	if(isNatIdOrAltIdMandVisaType=="true" || isNatIdOrAltIdMandVisaType=="true"){
		getVisibleMandNatAltIds();
	}
	}

//Patient inf enhancement

function enbDsbRefIDVal(obj)
{
	
	if(document.getElementById("refrlAappt").value == 'P')
	{		
		document.forms[0].RapidPatInfflag.value='Y';
		document.getElementById("phimg").style.visibility='visible';
	}
	else
	{		
		document.forms[0].RapidPatInfflag.value='N';
		document.getElementById("phimg").style.visibility='hidden';
	}



	if(obj.value != '')
	{
		document.getElementById("refIDValue").value			= '';
		document.getElementById("refIDValue").disabled		= false;
		document.getElementById("refIDValueButton").disabled	= false;
		document.getElementById("patient_id").value			= '';

	}
	else 
	{
		document.getElementById("refIDValue").value			= '';
		document.getElementById("refIDValue").disabled		= true;
		document.getElementById("refIDValueButton").disabled	= true;
		document.getElementById("patient_id").value			= '';
	}
}

async function PopAppRefDetails()
{
	if(document.getElementById("refrlAappt").value == 'P')
	{
		//var patid=PatientSearch('','','','','','','Y','','Y','Patreg','');
		var patid=await PatientSearch('','','','','','','Y','','','Patreg','');

		if(patid != undefined && patid != "undefined") {
			if(patid != null)
			{
				document.getElementById("refIDValue").value=patid;
				document.getElementById("refIDValue").focus();

			}
			else
			{
				document.getElementById("refIDValue").value='';
				document.getElementById("refIDValue").focus();
			}
		}
	}
}

function chkrefIDValue(obj)
{
	if(document.getElementById("refrlAappt").value == 'P')
	{
		checkPatientId1();
	}
	
	if(obj.value!='')
	{	

		
		var refrlAappt = document.getElementById("refrlAappt").value;
		var refIDValue = document.getElementById("refIDValue").value;
		var sStyle = document.getElementById("sStyle").value;
			
		var HTMLVal = new String();

		HTMLVal = "<HTML><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='message' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatRegExpChk.jsp'><input name='funcId' id='funcId' type='hidden' value='registerPatient'><input name='refrlAappt' id='refrlAappt' type='hidden' value='"+refrlAappt+"'><input name='refIDValue' id='refIDValue' type='hidden' value='"+refIDValue+"'></form></BODY></HTML>";

		parent.parent.frames[2].document.open() ;
		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.form1.submit();
	}
}

function checkPatientId1()  
{

		if(document.getElementById("refrlAappt").value == 'P')
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
		      
       /* if ( patient_id.length == 0 )
			if (parent.patient_sub.document.getElementById("national_id_no").type=='text')
                parent.patient_sub.document.getElementById("national_id_no").focus();
			else
				parent.patient_sub.document.getElementById("pat_ser_grp_code").focus();*/
  
}

function callResultPage(val)
{
		var refrlAappt = '';	
		var refIDValue = '';
		var patient_id = '';
		var RapidPatInfflag = '';
		
		if(val != '')
		{
			refrlAappt	= document.getElementById("refrlAappt").value;
			refIDValue	= document.getElementById("refIDValue").value;
			patient_id = document.getElementById("refIDValue").value;
			RapidPatInfflag = document.getElementById("RapidPatInfflag").value;
		}
		var parameter = document.getElementById("parameter").value
		
		
		//var appt_ref_no		= parent.frames[1].document.getElementById("temp_appt_ref_no").value;
		var patient_grp		= parent.patient_sub.document.getElementById("patient_group").value;
		
		//var NationalIdNo	= parent.patient_sub.document.getElementById("a_national_id_no").value;
		//var booking_ref_no	= parent.patient_sub.document.getElementById("temp_booking_ref_no").value;
		//var nat_id			= parent.patient_sub.document.getElementById("temp_nat_id").value;
		//var referral_id		= parent.patient_sub.document.getElementById("temp_referral_id").value;	
		/*var FirstName		= parent.patient_sub.document.getElementById("First_Name").value;
		var SecondName		= parent.patient_sub.document.getElementById("Second_Name").value;
		var ThirdName		= parent.patient_sub.document.getElementById("Third_Name").value;
		var FamilyName		= parent.patient_sub.document.getElementById("Family_Name").value;
		var Dob				= parent.patient_sub.document.getElementById("Dob").value;
		var Sex				= parent.patient_sub.document.getElementById("Sex").value;
		var AltIdNo			= parent.patient_sub.document.getElementById("Alt_Id_No").value;
		var AltId2No		= parent.patient_sub.document.getElementById("Alt_Id2_No").value;
		var AltId3No		= parent.patient_sub.document.getElementById("Alt_Id3_No").value;
		var AltId4No		= parent.patient_sub.document.getElementById("Alt_Id4_No").value;*/
		//var drfunctionid	= parent.patient_sub.document.getElementById("dr_function_id").value;
		//var FamilyNo		= parent.patient_sub.document.getElementById("Family_No").value;
		//var func_act		= parent.patient_sub.document.getElementById("func_act").value;
		//var q_booking_type	= parent.patient_sub.document.getElementById("q_booking_type").value;		
		
		
		if(patient_grp == "N")
		{
			parent.frames[1].location.href="../jsp/InsertRapidRegn.jsp?refIDValue="+refIDValue+"&refrlAappt="+refrlAappt+"&group="+patient_grp+"&patient_id="+patient_id+"&RapidPatInfflag="+RapidPatInfflag+"&"+parameter;
			//parent.frames[1].location.href="../jsp/InsertRapidRegn.jsp?refIDValue="+refIDValue+"&refrlAappt="+refrlAappt+"&group="+patient_grp+"&nat_id="+nat_id+"&First_Name="+FirstName+"&Second_Name="+SecondName+"&Third_Name="+ThirdName+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&Dob="+Dob+"&Sex="+Sex+"&Family_No="+FamilyNo+"&referral_id="+referral_id+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&patient_id="+patient_id;
		}
		if(patient_grp == "A")
		{
			parent.frames[1].location.href="../jsp/InsertRapidRegn.jsp?refIDValue="+refIDValue+"&refrlAappt="+refrlAappt+"&group="+patient_grp+"&patient_id="+patient_id+"&RapidPatInfflag="+RapidPatInfflag+"&"+parameter;
		}
		if(patient_grp == "G")
		{
			 parent.frames[1].location.href="../jsp/InsertRapidRegn.jsp?refIDValue="+refIDValue+"&refrlAappt="+refrlAappt+"&group="+patient_grp+"&patient_id="+patient_id+"&RapidPatInfflag="+RapidPatInfflag+"&"+parameter;  			
		}
		if(val != '')
		{
			document.getElementById("refrlAappt").disabled		= true;
			document.getElementById("refIDValue").disabled		= true;
			document.getElementById("refIDValueButton").disabled	= true;
		}
	
}
/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
function form60OnChange(){
	var form60value	= document.forms[0].formno60.value;
	if(form60value=="Y"){
		document.forms[0].alt_id3_no.value="";
		document.forms[0].alt_id3_no.disabled=true;
		document.forms[0].alt_id3_reqd_yn.value="N";
		document.getElementById("alt3_gif").style.visibility='hidden';
	}else{
		//Commented by Dharma on July 14th 2016 against KDAH-SCF-0358 [IN:060809]
		/*document.forms[0].alt_id3_reqd_yn.value="Y";
		document.getElementById("alt3_gif").style.visibility='visible';*/
		document.forms[0].alt_id3_no.disabled=false;
	}
}
/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/

// added by mujafar for KDAH-CRF-370.1 start
function calculate_age(birth_month,birth_day,birth_year)
{
    today_date = new Date();
    today_year = today_date.getFullYear();
    today_month = today_date.getMonth()+1;
    today_day = today_date.getDate();
    age = today_year - birth_year;
    

    if ( today_month < (birth_month ))
    { 
        age--;
    }
    if (((birth_month ) == today_month) && (today_day < birth_day))
    { 
        age--;
    }
    return age;
}
	// added by mujafar for KDAH-CRF-370.1 end

