

// GLOBAL Variables
var validateFlag = 'Y';
var LocalErrors = new String();      
var dis_list;

// ***********************************************************************

function moveToTab(TabIndex)
{

      var bookmarkToMove;
    if ( TabIndex == 1 )
        document.getElementById('demo').scrollIntoView();
    else if ( TabIndex == 2 )
	    document.getElementById('addr').scrollIntoView();
    else if ( TabIndex == 3 )
        document.getElementById('kin').scrollIntoView();
    else if ( TabIndex == 4 )
            document.getElementById('misc').scrollIntoView();
	 else if ( TabIndex == 5 )
		document.getElementById('fin').scrollIntoView();
	else if ( TabIndex == 6 )
            document.getElementById('pat_docs_tab').scrollIntoView();
    else if ( TabIndex == 7 )
            document.getElementById('add_mod_dtl').scrollIntoView();
	else if ( TabIndex == 8 )
		 document.getElementById('ancParent_det').scrollIntoView();
}

// ***********************************************************************

function create()
{
    var err=getMessage("INVALID_VALUE","common");
	err=err.replace('#',"Function");
}

// ***********************************************************************

function edit() { }

// ***********************************************************************

function query() 
{
    f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=5" ;
}

// ***********************************************************************

async function callApply() 
{	 
//Reinitialise the LocalErrors variable to erase the OLD errors
LocalErrors = '';
var canSave = new Boolean(true);
var splField = new Array();
var splFieldName = new Array();
if(f_query_add_mod.patient_sub.document.getElementById('r_country_desc').value=="")
	f_query_add_mod.patient_sub.document.getElementById('r_country_code').value='';
if(f_query_add_mod.patient_sub.document.getElementById('r_area_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('r_area_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('r_area').value='';
}
if(f_query_add_mod.patient_sub.document.getElementById('r_town_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('r_town_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('r_town').value='';
}
if(f_query_add_mod.patient_sub.document.getElementById('r_region_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('r_region_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('r_region').value='';
}
if(f_query_add_mod.patient_sub.document.getElementById('m_country_desc').value=="")
	f_query_add_mod.patient_sub.document.getElementById('m_country_code').value='';
if(f_query_add_mod.patient_sub.document.getElementById('m_area_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('m_area_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('m_area').value='';
}
if(f_query_add_mod.patient_sub.document.getElementById('m_town_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('m_town_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('m_town').value='';
}
if(f_query_add_mod.patient_sub.document.getElementById('m_region_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('m_region_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('m_region').value=''; 
}
if(f_query_add_mod.patient_sub.document.getElementById('contact1_res_area_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('contact1_res_area_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('n_area').value="";
}

if(f_query_add_mod.patient_sub.document.getElementById('contact1_res_town_code')!=null)
{	
if(f_query_add_mod.patient_sub.document.getElementById('contact1_res_town_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('n_town').value="";
}

if(f_query_add_mod.patient_sub.document.getElementById('contact1_region_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('contact1_region_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('n_region').value="";
}

if(f_query_add_mod.patient_sub.document.getElementById('next_country_desc').value=="")
	f_query_add_mod.patient_sub.document.getElementById('next_country_code').value='';
//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
var resiAddMailAdd = f_query_add_mod.patient_sub.document.getElementById('resiAddMailAdd').value;
if(resiAddMailAdd=="true"){
if(f_query_add_mod.patient_sub.document.getElementById('nk_ma_country_desc').value=="")
	f_query_add_mod.patient_sub.document.getElementById('nkin_mail_country_code').value='';

if(f_query_add_mod.patient_sub.document.getElementById('n_contact_ma_area_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('n_contact_ma_area_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('nkma_area').value="";
}

if(f_query_add_mod.patient_sub.document.getElementById('n_contact_ma_town_code')!=null)
{	
if(f_query_add_mod.patient_sub.document.getElementById('n_contact_ma_town_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('nkma_town').value="";
}

if(f_query_add_mod.patient_sub.document.getElementById('n_contac_region_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('n_contac_region_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('contact1_region').value="";
}

if(f_query_add_mod.patient_sub.document.getElementById('first_mail_country_desc').value=="")
	f_query_add_mod.patient_sub.document.getElementById('first_mail_country_code').value='';

if(f_query_add_mod.patient_sub.document.getElementById('fst_to_no_ma_area_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('fst_to_no_ma_area_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('contact2_res_area').value="";
}

if(f_query_add_mod.patient_sub.document.getElementById('fst_to_no_ma_town_code')!=null)
{	
if(f_query_add_mod.patient_sub.document.getElementById('fst_to_no_ma_town_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('contact2_res_town').value="";
}

if(f_query_add_mod.patient_sub.document.getElementById('fst_to_no_ma_reg_cod')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('fst_to_no_ma_reg_cod').value=="")
	f_query_add_mod.patient_sub.document.getElementById('contact2_region').value="";
}
}
//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
if(f_query_add_mod.patient_sub.document.getElementById('contact2_res_area_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('contact2_res_area_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('f_area').value="";
}
if(f_query_add_mod.patient_sub.document.getElementById('contact2_res_town_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('contact2_res_town_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('f_town').value="";
}

if(f_query_add_mod.patient_sub.document.getElementById('contact2_region_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('contact2_region_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('f_region').value="";
}
if(f_query_add_mod.patient_sub.document.getElementById('first_country_desc').value=="")
	f_query_add_mod.patient_sub.document.getElementById('first_country_code').value='';		
			
if(f_query_add_mod.patient_sub.document.getElementById('contact3_res_area_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('contact3_res_area_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('e_area').value="";
}
if(f_query_add_mod.patient_sub.document.getElementById('contact3_res_town_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('contact3_res_town_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('e_town').value="";
}

if(f_query_add_mod.patient_sub.document.getElementById('contact3_region_code')!=null)
{
if(f_query_add_mod.patient_sub.document.getElementById('contact3_region_code').value=="")
	f_query_add_mod.patient_sub.document.getElementById('e_region').value="";
}
//Incident Fix added for the Inci no : 34531  as on 10/08/2012
if(f_query_add_mod.patient_sub.document.getElementById('language_desc'))
{			
if(f_query_add_mod.patient_sub.document.getElementById('language_desc').value == "")
	{
	f_query_add_mod.patient_sub.document.getElementById('language_code').value="";
	}
}
//End	
if(f_query_add_mod.patient_sub.document.getElementById('empyr_country_desc').value=="")
	{
	f_query_add_mod.patient_sub.document.getElementById('empyr_country_code').value='';
	}
			//if (f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y")
			if (f_query_add_mod.patient_sub.document.getElementById('isNatIdMandatory').value!="Y" && f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y")
			{
				
				splField = new Array(f_query_add_mod.patient_sub.document.getElementById('national_id_no'));
		        splFieldName = new Array(f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
			}

			/*
			if (f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y")
			{
				
				splField = new Array(f_query_add_mod.patient_main.document.getElementById('patient_id'),
                                     f_query_add_mod.patient_sub.document.getElementById('national_id_no')
                                     );
		        splFieldName = new Array(getLabel("Common.patientId.label","common"),f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
			}
			
			else
			{
				splField = new Array(f_query_add_mod.patient_main.document.getElementById('patient_id'));
		        splFieldName = new Array(getLabel("Common.patientId.label","common"));
			}
			*/
          

			/*if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no') != null)
            {
                splField[splField.length] = f_query_add_mod.patient_sub.document.getElementById('alt_id1_no')
                splFieldName[splFieldName.length]   = f_query_add_mod.patient_sub.document.getElementById('alt_id1_type').value
            }
            if(f_query_add_mod.patient_sub.document.getElementById('alt_id2_no') != null)
            {
                splField[splField.length] = f_query_add_mod.patient_sub.document.getElementById('alt_id2_no')
                splFieldName[splFieldName.length]   = f_query_add_mod.patient_sub.document.getElementById('alt_id2_type').value
            }
            if(f_query_add_mod.patient_sub.document.getElementById('alt_id3_no') != null)
            {
                splField[splField.length] = f_query_add_mod.patient_sub.document.getElementById('alt_id3_no')
                splFieldName[splFieldName.length]   = f_query_add_mod.patient_sub.document.getElementById('alt_id3_type').value
            }
            if(f_query_add_mod.patient_sub.document.getElementById('alt_id4_no') != null)
            {
                splField[splField.length] = f_query_add_mod.patient_sub.document.getElementById('alt_id4_no')
                splFieldName[splFieldName.length]   = f_query_add_mod.patient_sub.document.getElementById('alt_id4_type').value
            }*/

            var canSave = new Boolean(true);
			
            if(f_query_add_mod.patient_sub.document.getElementById('function_id').value == "NEWBORN_REG")
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
var errorsThere1 = new Boolean(false);
var canSave1 = new Boolean(true);
f_query_add_mod.patient_sub.document.getElementById('patient_id').value = f_query_add_mod.patient_main.document.getElementById('patient_id').value;
//TO CHECK THE PATIENT SEX IS NOT NULL
if (f_query_add_mod.patient_sub.document.getElementById('sex').selectedIndex == 0)
{
	
    if(f_query_add_mod.patient_sub.document.getElementById('sex').value=="")
	{
		canSave=checkForNull(getLabel('Common.gender.label','common'));
		//checkForNull(canSave);
	}
}
if ( canSave == false )
    errorsThere = true;

			//Added by Kamatchi S for AAKH-CRF-0145
			if(f_query_add_mod.patient_sub.document.getElementById('visa_type'))
			{
				if(f_query_add_mod.patient_sub.document.getElementById('visa_type').value=="" && f_query_add_mod.patient_sub.document.getElementById('citizen')[1].checked==true)
				{  
				canSave=checkForNull(getLabel('eMP.VisaType.label','MP'));
				}
			}

            if ( canSave == false )
                errorsThere = true;

if(f_query_add_mod.patient_sub.document.getElementById('isNuhdeekIDAppl').value=="true"){
	if (f_query_add_mod.patient_sub.document.getElementById('primaryMember').value==""){					
				canSave=checkForNull(getLabel('Common.primary.label','common'));
	}
	if ( canSave == false )
		errorsThere = true;	
}	


//TO CHECK THE PATIENT known_allergy_yn IS NOT NULL

/*
if (f_query_add_mod.patient_sub.document.getElementById('known_allergy_yn').selectedIndex == 0)
{
	
    if(f_query_add_mod.patient_sub.document.getElementById('known_allergy_yn').value=="")
	{
		canSave=checkForNull(getLabel('Common.KnownAllergy.label','common'));
		//checkForNull(canSave);
	}
}
if ( canSave == false )
    errorsThere = true;
*/


// Added on 27/08/2003 for checking not mull

if(f_query_add_mod.patient_sub.document.getElementById('race_required_yn').value == 'Y')
{
	if(f_query_add_mod.patient_sub.document.getElementById('image1').style.visibility == 'visible') {		

		if(f_query_add_mod.patient_sub.document.getElementById('race_desc').value=="") {
			canSave=checkForNull(getLabel('Common.race.label','common'));
		}	
	}
}


if ( canSave == false )
errorsThere = true;
// End of addition on 27/08/2003 for checking not null

//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US007
var aliasnameNationalityRace = f_query_add_mod.patient_sub.document.getElementById('aliasnameNationalityRace').value;
//Below Commented for ML-MMOH-CRF-1583
/*if(aliasnameNationalityRace=="true"){
if(f_query_add_mod.patient_sub.document.getElementById('race_required_yn').value == 'Y')
{
	if(f_query_add_mod.patient_sub.document.getElementById('rel_image').style.visibility == 'visible') {		

		if(f_query_add_mod.patient_sub.document.getElementById('rel_race_desc').value=="") {
			canSave=checkForNull(getLabel('eMP.relatedcontacts.label','MP') + " "+ getLabel('Common.race.label','common'));
		}	
	}
}


if ( canSave == false )
errorsThere = true;
}*/
//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US007
// TO CHECK THE PATIENT SEX MATCH WITH THE NAME PREFIX
/* if ( ( f_query_add_mod.patient_sub.document.getElementById('name_prefix') != null ) || ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang') != null ) )
 {
			if ( ( f_query_add_mod.patient_sub.document.getElementById('name_prefix').value.length != 0 ) || ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value.length != 0 ) )
			{
				canSave = checkPatSex();
			}
}

if ( canSave == false )
    errorsThere = true;

// TO CHECK THE PATIENT SEX MATCH WITH THE NAME SUFFIX
if ( ( f_query_add_mod.patient_sub.document.getElementById('name_suffix') != null ) || ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang') != null ) )
 {
			if ( ( f_query_add_mod.patient_sub.document.getElementById('name_suffix').value.length != 0 ) || ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value.length != 0 ) )
			{
				canSave = checkPatSuffixSex();
			}
}

if ( canSave == false )
    errorsThere = true;
*/
/* Added below For ML-MMOH-CRF-0736 by Mano */
if(f_query_add_mod.patient_sub.document.getElementById('religion_reqd_yn').value == 'Y')
{
	if(f_query_add_mod.patient_sub.document.getElementById('image2').style.visibility == 'visible') {		

		if(f_query_add_mod.patient_sub.document.getElementById('relgn_desc').value=="") {
			canSave=checkForNull(getLabel('Common.religion.label','common'));
		}	
	}
}
/*Modified by Arthi on 20-May-2022 for AAKH-CRF-0145*/
if(f_query_add_mod.patient_sub.document.getElementById('visa_type'))
{
	//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
	var isNatIdAltIdMandVisaType	= f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value;
	if (f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility=='visible')
		{
			if( isNatIdAltIdMandVisaType == "true" && f_query_add_mod.patient_sub.document.getElementById('visa_type').value != "V"){
			canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'),f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value);
			}
		if ( canSave == false )
		errorsThere = true;
		}

	if (f_query_add_mod.patient_sub.document.getElementById('alt2_gif').style.visibility=='visible')
		{
		//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
		if( isNatIdAltIdMandVisaType == "true" && f_query_add_mod.patient_sub.document.getElementById('alt2_gif').style.visibility=='visible' && f_query_add_mod.patient_sub.document.getElementById('visa_type').value != "V"){
		canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id2_no'),f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value);
		}
		if ( canSave == false)
		errorsThere = true;
		}	
	if (f_query_add_mod.patient_sub.document.getElementById('nat_gif').style.visibility=='visible')
		{
			//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
			if( isNatIdAltIdMandVisaType == "true" && f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value=='N' && f_query_add_mod.patient_sub.document.getElementById('nat_gif').style.visibility=='visible' && f_query_add_mod.patient_sub.document.getElementById('visa_type').value == ""){
			canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('national_id_no'),f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
			}
			if ( canSave == false)
			errorsThere = true;
		}		

if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "true" && f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value=='N' && f_query_add_mod.patient_sub.document.getElementById('visa_type').value == "W" && f_query_add_mod.patient_sub.document.getElementById('national_id_no').value == "")
			{
				/*Added by Arthi on 20-May-2022 for AAKH-CRF-0145*/
				if(f_query_add_mod.patient_sub.document.getElementById('nat_gif').style.visibility == "visible"){
					var message1=getLabel('eMP.ResidentWork.label','MP')
					error	= getMessage('RES_VISA_TYPE','MP');
					error = error.replace("#",f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
					error = error.replace("$",message1);
					LocalErrors += error+ "<br>";
					canSave = false;
				}

			}
			if ( canSave == false )
                errorsThere = true;
			if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "true" && f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value=='N' && f_query_add_mod.patient_sub.document.getElementById('visa_type').value == "V" && f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value == "" && f_query_add_mod.patient_sub.document.getElementById('alt_id2_no').value == "")
			{
				if(f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility == "visible" && f_query_add_mod.patient_sub.document.getElementById('alt2_gif').style.visibility == "visible"){
					var message1=f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value;
					var message2=f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value;
					var message3=getLabel('Common.Visit.label','common');
					error	= getMessage('VISIT_VISA_TYPE','MP');
					error = error.replace("#",message1);
					error = error.replace("@",message2);
					error = error.replace("$",message3);
					LocalErrors += error+ "<br>";
					canSave = false
				}
			}
			else if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "true" && f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value=='N' && f_query_add_mod.patient_sub.document.getElementById('visa_type').value == "V" && f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value == "")
			{
				if(f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility == "visible"){
					var message1=f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value;
					var message3=getLabel('Common.Visit.label','common');
					error	= getMessage('VISIT_VISA_TYPE','MP');
					error = error.replace("# and @",message1);
					error = error.replace("$",message3);
					LocalErrors += error+ "<br>";
					canSave = false
				}
			}
			else if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "true" && f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value=='N' && f_query_add_mod.patient_sub.document.getElementById('visa_type').value == "V" && f_query_add_mod.patient_sub.document.getElementById('alt_id2_no').value == "")
			{
				if(f_query_add_mod.patient_sub.document.getElementById('alt2_gif').style.visibility == "visible"){
					var message2=f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value;
					var message3=getLabel('Common.Visit.label','common');
					error	= getMessage('VISIT_VISA_TYPE','MP');
					error = error.replace("# and @",message2);
					error = error.replace("$",message3);
					LocalErrors += error+ "<br>";
					canSave = false
				}
			}
			/*End AAKH-CRF-0145*/
			if ( canSave == false )
                errorsThere = true;
			}		

if ( canSave == false )
errorsThere = true;
/* End of CRF-0736 by Mano */
  if (  f_query_add_mod.patient_sub.document.getElementById('name_prefix') != null ) 
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix').value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById('sex').value != '' )
					{	
                        canSave = checkPatSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;

			/*if (  f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang') != null ) 
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById('sex').value != '' )
					{	
                        canSave = checkPatOthSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;*/

			 // TO CHECK THE PATIENT SEX MATCH WITH THE NAME PREFIX
            if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix') != null )
            {
                if (  f_query_add_mod.patient_sub.document.getElementById('name_suffix').value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById('sex').value != '' )
					{	
                        canSave = checkPatSuffixSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;

			/*if (  f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang') != null ) 
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById('sex').value != '' )
					{	
                        canSave = checkPatOthSuffixSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;*/
//Mandatory check for National ID ADDED BY kumar on 16/03/2003 
var isNatIdOrAltId1MandRes		= f_query_add_mod.patient_sub.document.getElementById('isNatIdOrAltId1MandRes').value;
var isNatIdOrAltIdMandVisaType		= f_query_add_mod.patient_sub.document.getElementById('isNatIdOrAltIdMandVisaType').value;
var isNatIdAltIdMandVisaType		= f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value;//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
var isValidateNatId				= "Y";
//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
if((isNatIdOrAltId1MandRes == "true" || isNatIdOrAltIdMandVisaType=="true" || isNatIdAltIdMandVisaType=="true") && f_query_add_mod.patient_sub.document.getElementById('nat_id_reqd_all_series').value=="N"){
	isValidateNatId		= "N";
}

/*Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
if (f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y" && f_query_add_mod.patient_sub.document.getElementById('nat_id_pat_ser_grp').value==f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').value && f_query_add_mod.patient_sub.document.getElementById('isNatIdMandatory').value=="Y"){
	canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('national_id_no'), f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
}else{
	if(f_query_add_mod.patient_sub.document.getElementById('isNatIdMandatory').value!="Y" && isValidateNatId=="Y"){
		
		/*Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491] End*/
if (f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y" && f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value == "Y")
{
	if(f_query_add_mod.patient_sub.document.getElementById('called_from_newborn'))
	{
		if(f_query_add_mod.patient_sub.document.getElementById('called_from_newborn').value!='Y')
		{
			if (f_query_add_mod.patient_sub.document.getElementById('id_type').value == 'N' || f_query_add_mod.patient_sub.document.getElementById('nat_id_reqd_all_series').value=='Y')
			{
			  canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('national_id_no'), f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
					}
				}
			}
		}
	}
}

if ( canSave == false )
	errorsThere = true;

//End of Addition

/*Below line added for this CRF GHL-CRF-0332 [IN:042060]*/ 
var tempflagchk = new Boolean(false);
				
		if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_reqd_yn').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz') && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz').value=="true")
			{
				if(f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility == 'visible') {	

					if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value=="")
					{
						canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'),f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value);
						
					}		 
				}
				if ( canSave == false ){
					errorsThere = true;
					tempflagchk = true;
					}
			}
	if(f_query_add_mod.patient_sub.document.getElementById('alt_date1_reqd_yn').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz') && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz').value=="true")
			{
				if(f_query_add_mod.patient_sub.document.getElementById('alt1_exp_date1').style.visibility == 'visible') {	

					if(f_query_add_mod.patient_sub.document.getElementById('altidexpdate1').value=="")
					{
						canSave=checkForNull(getLabel('Common.expiryDate.label','common'));
					}		 
				}
				if ( canSave == false )
					errorsThere = true;
			}			
        //End this CRF GHL-CRF-0332 [IN:042060]

/*Below line added for this CRF GDOH-CRF-0029 [IN:048764]*/ 
//if ( f_query_add_mod.patient_sub.document.getElementById('disaster_regn_yn').value == 'Y' ){
	if(f_query_add_mod.patient_sub.document.getElementById('disas_regn_date_time') && f_query_add_mod.patient_sub.document.getElementById('disas_regn_date_time').value=="")
		{
		var regdate=getLabel('Common.RegistrationDate.label','common')+" "+getLabel('Common.time.label','common');
        canSave=checkForNull(regdate);
		}
    if ( canSave == false )
        errorsThere = true;
	if((f_query_add_mod.patient_sub.document.getElementById('disas_regn_date_time')&&f_query_add_mod.patient_sub.document.getElementById('disas_regn_date_time').value!="") && (f_query_add_mod.patient_sub.document.getElementById('Birth_Date')&&f_query_add_mod.patient_sub.document.getElementById('Birth_Date').value!="")){
       var subStr=f_query_add_mod.patient_sub.document.getElementById('disas_regn_date_time').value; 
	  // var localeName=f_query_add_mod.patient_sub.document.getElementById('localeName').value; 
	  
	   var regdateFormat= convertDate(subStr,"DMYHM",localeName,"en"); /*Removed Seconds*/
       var birthDate=convertDate(f_query_add_mod.patient_sub.document.getElementById('Birth_Date').value,"DMYHMS",localeName,"en"); /*Added by Rameswar on 06-OCT-16 for Leap Year Issue*/
	   
	    if(birthDate.length==19)birthDate=birthDate.substring(0,16);
	    if(birthDate.length==18)birthDate=birthDate.substring(0,15); //Added for this incident [54759]	
        if(birthDate.length==17)birthDate=birthDate.substring(0,14); //Added for this incident [54759]	
	
        
if(!isAfter(regdateFormat,birthDate,"DMYHM","en")){ /*Removed Seconds*//*localName is changed to en by Rameswar on 06-OCT-16 for Leap Year Issue*/
		    var error = getMessage('CANNOT_LESSER','MP');			
			var message1=getLabel("Common.RegistrationDate.label",'Common')+" "+getLabel("Common.time.label",'Common'); 
			var message2=getLabel("Common.birthDate.label",'Common')+" "+getLabel("Common.time.label",'Common'); 
			error = error.replace('$',message2);			
			error = error.replace('#',message1);			
			LocalErrors += error+ "<br>";
		    canSave = false;			
			
			
		}		
}		
		
//}
//End GDOH-CRF-0029 [IN:048764]

/* Added for GDOH -CRF-0029 by Dharma on 11th sep 2014 Start*/
if(f_query_add_mod.patient_sub.document.getElementById('disas_regn_date_time')!=null && f_query_add_mod.patient_sub.document.getElementById('visit_adm_date_time')!=null){
	var visit_adm_date_time	= f_query_add_mod.patient_sub.document.getElementById('visit_adm_date_time').value;
	var disas_regn_date_time = f_query_add_mod.patient_sub.document.getElementById('disas_regn_date_time').value;    
	
	if(visit_adm_date_time!="" && disas_regn_date_time!=""){
	if(visit_adm_date_time.length==19)visit_adm_date_time=visit_adm_date_time.substring(0,16);
	if(disas_regn_date_time.length==19)disas_regn_date_time=disas_regn_date_time.substring(0,16);
	if(disas_regn_date_time.length==18)disas_regn_date_time=disas_regn_date_time.substring(0,15); //Added for this incident [54759]	
	if(disas_regn_date_time.length==17)disas_regn_date_time=disas_regn_date_time.substring(0,14); //Added for this incident [54759]
	
		if(!isAfter(visit_adm_date_time,disas_regn_date_time,"DMYHM",localeName)){ /*Removed Seconds*/
			var error = getMessage('CANNOT_GREATER','MP');			
			var message1=getLabel("Common.RegistrationDate.label",'Common')+" "+getLabel("Common.time.label",'Common'); 
			var message2=getLabel("Common.encounter.label",'Common')+" "+getLabel("Common.date.label",'Common')+" "+getLabel("Common.time.label",'Common'); 
			error = error.replace('$',message2);			
			error = error.replace('#',message1);			
			LocalErrors += error+ "<br>";
		    canSave = false;	
		}
	}
}
/* Added for GDOH -CRF-0029 by Dharma on 11th sep 2014 End*/



// FIRST CHECK FOR THE PATIENT ID
if ( f_query_add_mod.patient_sub.document.getElementById('pat_no_gen_yn').value == 'N' )
{
	if(f_query_add_mod.patient_main.document.getElementById('patient_id').value=="")
		{
		canSave=checkForNull(getLabel('Common.patientId.label','common'));
//		checkForNull(canSave);
		}
    if ( canSave == false )
        errorsThere = true;
}

if ( canSave == false )
    errorsThere = true;

// CHECKING FOR PATIENT DATE OF BIRTH
	if(f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value=="")
	{
	canSave = checkForNull(getLabel('Common.birthDate.label','common'));
//	checkForNull(canSave);
	}
if ( canSave == false )
    errorsThere = true;
var dflt_patient_name = f_query_add_mod.patient_sub.document.getElementById('dflt_patient_name').value;
    if ( f_query_add_mod.patient_sub.document.getElementById('first_name') != null && trimString(f_query_add_mod.patient_sub.document.getElementById('first_name').value)== "")
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('first_name_reqd_yn') != null )
                    if ( f_query_add_mod.patient_sub.document.getElementById('first_name_reqd_yn').value == 'Y' )
						f_query_add_mod.patient_sub.document.getElementById('first_name').value = dflt_patient_name;
						//f_query_add_mod.patient_sub.document.getElementById('first_name').value = 'Unknown Name';
						// Added the below line for Incident 17918 on 07/01/2010 by Suresh
						f_query_add_mod.patient_sub.document.getElementById('first_name').onblur();
            }

            if ( f_query_add_mod.patient_sub.document.getElementById('second_name') != null && trimString(f_query_add_mod.patient_sub.document.getElementById('second_name').value)== "")
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('second_name_reqd_yn') != null)
                if ( f_query_add_mod.patient_sub.document.getElementById('second_name_reqd_yn').value == 'Y' )
				f_query_add_mod.patient_sub.document.getElementById('second_name').value = dflt_patient_name;
				// Added the below line for Incident 17918 on 07/01/2010 by Suresh
				f_query_add_mod.patient_sub.document.getElementById('second_name').onblur();
            }

            if ( f_query_add_mod.patient_sub.document.getElementById('third_name') != null && trimString(f_query_add_mod.patient_sub.document.getElementById('third_name').value)== "")
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('third_name_reqd_yn') != null)
                if ( f_query_add_mod.patient_sub.document.getElementById('third_name_reqd_yn').value == 'Y' )
   				f_query_add_mod.patient_sub.document.getElementById('third_name').value = dflt_patient_name;
				// Added the below line for Incident 17918 on 07/01/2010 by Suresh
				f_query_add_mod.patient_sub.document.getElementById('third_name').onblur();
			}

            if ( f_query_add_mod.patient_sub.document.getElementById('family_name') != null && trimString(f_query_add_mod.patient_sub.document.getElementById('family_name').value)== "")
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('family_name_reqd_yn') != null)
                if ( f_query_add_mod.patient_sub.document.getElementById('family_name_reqd_yn').value == 'Y' )
				f_query_add_mod.patient_sub.document.getElementById('family_name').value = dflt_patient_name;
				// Added the below line for Incident 17918 on 07/01/2010 by Suresh
				f_query_add_mod.patient_sub.document.getElementById('family_name').onblur();
            }

			if ( f_query_add_mod.patient_sub.document.getElementById('first_name') != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById('first_name_reqd_yn') != null )
                if ( f_query_add_mod.patient_sub.document.getElementById('first_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('first_name'),f_query_add_mod.patient_sub.document.getElementById('first_name_prompt').value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById('second_name') != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById('second_name_reqd_yn') != null )
                if ( f_query_add_mod.patient_sub.document.getElementById('second_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('second_name'),f_query_add_mod.patient_sub.document.getElementById('second_name_prompt').value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById('third_name') != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById('third_name_reqd_yn') != null )
                if ( f_query_add_mod.patient_sub.document.getElementById('third_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('third_name'),f_query_add_mod.patient_sub.document.getElementById('third_name_prompt').value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById('family_name') != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById('family_name_reqd_yn') != null )
                if ( f_query_add_mod.patient_sub.document.getElementById('family_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('family_name'),f_query_add_mod.patient_sub.document.getElementById('family_name_prompt').value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix') != null )
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_reqd_yn').value == 'Y' )
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_suffix'),f_query_add_mod.patient_sub.document.getElementById('name_suffix_prompt').value);
				if ( canSave == false )
					errorsThere = true;
			}

			if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix') != null )
			{
				//if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_reqd_yn').value == 'Y' )
				if ( (f_query_add_mod.patient_sub.document.getElementById('name_prefix_img')) && (f_query_add_mod.patient_sub.document.getElementById('name_prefix_img').style.visibility=='visible'))
				{
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_prefix'),f_query_add_mod.patient_sub.document.getElementById('name_prefix_prompt').value);
				}
				if ( canSave == false )
					errorsThere = true;
			}
			
			  // CHECKING FOR PATIENT NAME
          // CHECKING FOR PATIENT NAME
            if(trimString(f_query_add_mod.patient_main.document.getElementById('patient_name').value)=="")
			{
				//var patForm = f_query_add_mod.patient_sub.document.all;
				var patForm = f_query_add_mod.patient_sub.document;
				var pat_name = f_query_add_mod.patient_main.document.getElementById('patient_name');
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
				if (trimString(f_query_add_mod.patient_main.document.getElementById('patient_name').value)=="")
					canSave=checkForNull(getLabel('Common.PatientName.label','common'));
			}
		 
			if(f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang')){
			 if(trimString(f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang').value)=="")
				{
					//var patForm = f_query_add_mod.patient_sub.document.all;
					var patForm = f_query_add_mod.patient_sub.document;
					var pat_name = f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang');
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
					if(f_query_add_mod.patient_sub.document.getElementById('pat_name_in_loc_lang_reqd_yn').value == "Y"){
						if (trimString(f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang').value)=="")
							canSave=checkForNull(getLabel('eMP.PatientNameLocal.label','MP'));
					}
			  }
		    	if( f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang') != null)
			    	f_query_add_mod.patient_sub.document.getElementById('patient_name_loc_lang').value = f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang').value;
			}

			putLocalLangPatientName(f_query_add_mod.patient_sub.document.getElementById('patient_name_loc_lang_long').value);
            if ( canSave == false )
                errorsThere = true;

			f_query_add_mod.patient_sub.document.getElementById('patient_name').value = f_query_add_mod.patient_main.document.getElementById('patient_name').value;
		
			


            if ( f_query_add_mod.patient_sub.document.getElementById('first_name') != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('first_oth_name_reqd_yn') != null)
                    if ( f_query_add_mod.patient_sub.document.getElementById('first_oth_name_reqd_yn').value == 'Y' )
                        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('first_name_oth_prompt').value);
                    if ( canSave == false )errorsThere = true;

					//Added by Sathish.S for 20824 on Thursday, April 22, 2010 starts here
					if(f_query_add_mod.patient_sub.document.getElementById('first_name')) {
						canSave1 =CheckForSpecChr(f_query_add_mod.patient_sub.document.getElementById('first_name'));					
						if ( canSave1 == false ){errorsThere = true;errorsThere1=true;}
					}
					if(f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang')) {
						canSave1 =CheckForSpecChr(f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang'));					
						if ( canSave1 == false ){errorsThere = true;errorsThere1=true;}
					}
					//Ends here
            }

            if ( f_query_add_mod.patient_sub.document.getElementById('second_name') != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('second_oth_name_reqd_yn') != null)
                if ( f_query_add_mod.patient_sub.document.getElementById('second_oth_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('second_name_oth_prompt').value);
                if ( canSave == false )
                    errorsThere = true;

				//Added by Sathish.S for 20824 on Thursday, April 22, 2010 starts here
				if(f_query_add_mod.patient_sub.document.getElementById('second_name')) {
					canSave1 =CheckForSpecChr(f_query_add_mod.patient_sub.document.getElementById('second_name'));					
					if ( canSave1 == false ){errorsThere = true;errorsThere1=true;}
				}
				if(f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang')) {
					canSave1 =CheckForSpecChr(f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang'));					
					if ( canSave1 == false ){errorsThere = true;errorsThere1=true;}
				}
				//Ends here
            }

            if ( f_query_add_mod.patient_sub.document.getElementById('third_name') != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('third_oth_name_reqd_yn') != null)
                if ( f_query_add_mod.patient_sub.document.getElementById('third_oth_name_reqd_yn').value == 'Y' )
                    canSave =checkForNull1(f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('third_name_oth_prompt').value);
                if ( canSave == false )
                    errorsThere = true;

				//Added by Sathish.S for 20824 on Thursday, April 22, 2010 starts here
				if(f_query_add_mod.patient_sub.document.getElementById('third_name')) {
					canSave1 =CheckForSpecChr(f_query_add_mod.patient_sub.document.getElementById('third_name'));					
					if ( canSave1 == false ){errorsThere = true;errorsThere1=true;}
				}
				if(f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang')) {
					canSave1 =CheckForSpecChr(f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang'));					
					if ( canSave1 == false ){errorsThere = true;errorsThere1=true;}
				}
				//Ends here
            }

            if ( f_query_add_mod.patient_sub.document.getElementById('family_name') != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('family_oth_name_reqd_yn') != null)
                if ( f_query_add_mod.patient_sub.document.getElementById('family_oth_name_reqd_yn').value == 'Y' )
                    canSave =checkForNull1(f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('family_name_oth_prompt').value);
                if ( canSave == false )
                    errorsThere = true;
			
				//Added by Sathish.S for 20824 on Thursday, April 22, 2010 starts here
				if(f_query_add_mod.patient_sub.document.getElementById('family_name')) {
					canSave1 =CheckForSpecChr(f_query_add_mod.patient_sub.document.getElementById('family_name'));					
					if ( canSave1 == false ){errorsThere = true;errorsThere1=true;}
				}
				if(f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang')) {
					canSave1 =CheckForSpecChr(f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang'));					
					if ( canSave1 == false ){errorsThere = true;errorsThere1=true;}
				}
				//Ends here
            }

            if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix') != null )
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_name_reqd_yn') != null )
                if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_prompt').value);
                if ( canSave == false )
                    errorsThere = true;
            }

            if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang') != null )
            {
                 if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_name_reqd_yn') != null )
                if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_prompt').value);
                if ( canSave == false )
                    errorsThere = true;
            }


if( f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang') != null)
    f_query_add_mod.patient_sub.document.getElementById('patient_name_loc_lang').value = f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang').value;



if(errorsThere1 == true){ //Added by Sathish.S for 20824 on Thursday, April 22, 2010
	var newmsg = f_query_add_mod.patient_sub.getMessage("SPEC_CHAR_EXISTS_NAME_COMP",'MP');
	alert(newmsg);
}

// CHECKING FOR ALTERNATE ID'S

/*below line modified for this CRF  GHL-CRF-0332 [IN:042060]*/ 
//Below line modified for this incident [61782]
if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "false")//Added for AAKH CRF 145
{
if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no') != null && tempflagchk==false)
{ 
	//if ((f_query_add_mod.patient_sub.document.getElementById('alt_id1_reqd_yn').value == 'Y' && //f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').readOnly == false) || //(f_query_add_mod.patient_sub.document.getElementById('id_type').value=='A'))

	if ((f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').readOnly == false) &&  (f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility=='visible')	)
 
	{
		if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no') && f_query_add_mod.patient_sub.document.getElementById('altId1Desc')) {
			canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'), f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value);
			
		}
	}
    if(canSave == false)
        errorsThere = true;
} 


if ( f_query_add_mod.patient_sub.document.getElementById('alt_id2_no') != null )
{
  
	if ( f_query_add_mod.patient_sub.document.getElementById('alt_id2_reqd_yn').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('alt_id2_no').readOnly == false &&  f_query_add_mod.patient_sub.document.getElementById('alt_id2_no').disabled==false) {
		if(f_query_add_mod.patient_sub.document.getElementById('altId2Desc')) {
			canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id2_no'), f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value);			
		}
	}
    if ( canSave == false )
        errorsThere = true;
}
}
if ( f_query_add_mod.patient_sub.document.getElementById('alt_id3_no') != null )
{
    if ( f_query_add_mod.patient_sub.document.getElementById('alt_id3_reqd_yn').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('alt_id3_no').readOnly == false && f_query_add_mod.patient_sub.document.getElementById('alt_id3_no').disabled == false) 
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id3_no'), f_query_add_mod.patient_sub.document.getElementById('altId3Desc').value);
    if ( canSave == false )
        errorsThere = true;
}

if ( f_query_add_mod.patient_sub.document.getElementById('alt_id4_no') != null )
{
    if ( f_query_add_mod.patient_sub.document.getElementById('alt_id4_reqd_yn').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('alt_id4_no').readOnly == false && f_query_add_mod.patient_sub.document.getElementById('alt_id4_no').disabled == false)
        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id4_no'), f_query_add_mod.patient_sub.document.getElementById('altId4Desc').value);
    if ( canSave == false )
        errorsThere = true;
}
if ( f_query_add_mod.patient_sub.document.getElementById('relationship_to_head_desc'))
{
	if ( !f_query_add_mod.patient_sub.document.getElementById('relationship_to_head_desc').disabled)
	{
		if  (f_query_add_mod.patient_sub.document.getElementById('family_org_membership'))
		{
			if  ((f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value != 1)  && (f_query_add_mod.patient_sub.document.getElementById('rel').style.visibility=='visible'))
			{
				if(f_query_add_mod.patient_sub.document.getElementById('relationship_to_head_desc').value=="")
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
			if(f_query_add_mod.patient_sub.document.getElementById('relationship_to_head_desc').value=="" && f_query_add_mod.patient_sub.document.getElementById('rel').style.visibility=='visible')
			{
				canSave = checkForNull(getLabel('Common.relationship.label','common'));
				//checkForNull(canSave);
			}
		if ( canSave == false )
			errorsThere = true;
		 }
	}

	if(f_query_add_mod.patient_sub.document.getElementById('relationship_level1_desc'))
	{
		if(f_query_add_mod.patient_sub.document.getElementById('relationship_level1_desc').value=="")
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
if (f_query_add_mod.patient_sub.document.getElementById('family_org_membership'))
{
	if ( (f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value == '1')  )
	{
		if (f_query_add_mod.patient_sub.document.getElementById('name_prefix_img').style.visibility=='visible') 
		{
			canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_prefix'),f_query_add_mod.patient_sub.document.getElementById('name_prefix_prompt').value);
				if ( canSave == false )
				errorsThere = true;
		}
		if ( (f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang')) && (f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth').style.visibility=='visible'))
		{
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_prompt').value);
				if ( canSave == false )
					errorsThere = true;
		}
	}
}
*/
/* Commented code by Suresh M for IN023043 on 03-08-2010
if ( (f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang')) && (f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth').style.visibility=='visible'))
{
	canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_prompt').value);
	if ( canSave == false )
		errorsThere = true;
}
*/
if ( (f_query_add_mod.patient_sub.document.getElementById('entitlement_by_pat_cat_yn').value == 'Y') && (f_query_add_mod.patient_sub.document.getElementById('exp_val_appl_yn').value == 'Y') &&(f_query_add_mod.patient_sub.document.getElementById('imgCatExpDateMan').style.visibility=='visible')  )
{
	if(f_query_add_mod.patient_sub.document.getElementById('pat_cat_code_exp_date').value=="")
		{
				canSave=checkForNull(getLabel('eMP.categoryexpirydate.label','MP'));
//				checkForNull(canSave);
			}
		if ( canSave == false )
		errorsThere = true;
}
//Below Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
if  ( (f_query_add_mod.patient_sub.document.getElementById('pat_cat_code')) && (f_query_add_mod.patient_sub.document.getElementById('pat_category_reqd_yn').value == 'Y') )
{
	if(f_query_add_mod.patient_sub.document.getElementById('pat_cat_code').value=="")
		{
			canSave=checkForNull(getLabel('Common.category.label','common'));
		}
		if ( canSave == false )
		errorsThere = true;
}	
if (f_query_add_mod.patient_sub.document.getElementById('family_org_id_accept_yn').value == 'Y')
{
	if  ( (f_query_add_mod.patient_sub.document.getElementById('pat_cat_code')) && (f_query_add_mod.patient_sub.document.getElementById('entitlement_by_pat_cat_yn').value == 'Y') )
	{
		if(f_query_add_mod.patient_sub.document.getElementById('pat_cat_code').value=="")
			{
				canSave=checkForNull(getLabel('Common.category.label','common'));
//				checkForNull(canSave);
			}
			if ( canSave == false )
			errorsThere = true;
   }

	if (f_query_add_mod.patient_sub.document.getElementById('family_org_membership'))
	{	
	  if(f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value=="")
		  {
				canSave=checkForNull(getLabel('eMP.membership.label','MP'));
//				checkForNull(canSave);
			}
	  if ( canSave == false )
		errorsThere = true;

	   if (f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value != 4)
	   {
			  /*
			  if (f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility=='visible')
			  {
				  if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no') && f_query_add_mod.patient_sub.document.getElementById('altId1Desc')) {
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'),f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value);
				  }
				  if ( canSave == false )
					errorsThere = true;
			  }
			  */
			  if (f_query_add_mod.patient_sub.document.getElementById('org_sub_org').style.visibility=='visible')
			  {
				if(f_query_add_mod.patient_sub.document.getElementById('organization').value=="")
					{
					canSave=checkForNull(getLabel('Common.Organization.label','Common'));
//					checkForNull(canSave);
					}
				if ( canSave == false )
				errorsThere = true;
				  
				if(f_query_add_mod.patient_sub.document.getElementById('sub_organization').value=="")
					{
					canSave=checkForNull(getLabel('eMP.suborgn.label','MP'));
//					checkForNull(canSave);
					}
				if ( canSave == false )
				errorsThere = true;
			  }	  

			 /*For Organization Member this check doen't apply*/
			/*
			if ( (f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value != 1)  && (f_query_add_mod.patient_sub.document.getElementById('rel').style.visibility=='visible') )
			 {
				if(f_query_add_mod.patient_sub.document.getElementById('relationship_to_head').value=="")
				{
					canSave=checkForNull(getLabel('Common.relationship.label','common'));
//					checkForNull(canSave);
					}
				if ( canSave == false )
					errorsThere = true;
			}
			*/
		}
		if ( (f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value != 1)	&&(f_query_add_mod.patient_sub.document.getElementById('mem_type_db').value == 1) )
		{	
			 var alt_id1_db_val = f_query_add_mod.patient_sub.document.getElementById('alt_id1_db').value;
			 var alt_id1_val = f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value;
			 if ( alt_id1_db_val == alt_id1_val)
			 {				
				 var msg = f_query_add_mod.patient_sub.getMessage("INVALID_ALT_ID",'MP');
				msg =  msg.replace("$",f_query_add_mod.patient_sub.document.getElementById('alt_id1_desc').value)
				 alert(msg);
				 f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').focus();
				// parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			 }
		}
	  }
   }

   /*
	else
	 if ( f_query_add_mod.patient_sub.document.getElementById('relationship_to_head'))
	{
		if ( !f_query_add_mod.patient_sub.document.getElementById('rel').style.visibility=='visible')
		{
			if(f_query_add_mod.patient_sub.document.getElementById('relationship_to_head').value=="")
{
					canSave=checkForNull(getLabel('Common.relationship.label','common'));
//					checkForNull(canSave);
					}
			if ( canSave == false )
				errorsThere = true;
			 }
	}

	*/

/* End of validations added on 2/27/2006*/

if(f_query_add_mod.patient_sub.document.getElementById('doc_id1').value !="")
{
	/*
    if (f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt1').value == "")
    {
        canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt1'),'Expiry Date1');
    }*/
    if (f_query_add_mod.patient_sub.document.getElementById('doc_num1').value == "")
    {
        if(f_query_add_mod.patient_sub.document.getElementById('doc_num1').value=="")
		{
			canSave=checkForNull(getLabel('Common.documentno.label','common')+" 1");
			//checkForNull(canSave);
		}
    }
}
if ( canSave == false )
    errorsThere = true;

if(f_query_add_mod.patient_sub.document.getElementById('doc_id2').value !="")
{
	/*
    if (f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt2').value == "")
    {
        canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt2'),'Expiry Date2');
    }*/
    if (f_query_add_mod.patient_sub.document.getElementById('doc_num2').value == "")
    {
        if(f_query_add_mod.patient_sub.document.getElementById('doc_num2').value=="")
			{
			canSave=checkForNull(getLabel('Common.documentno.label','common')+"2");
//			checkForNull(canSave);
		}
    }
}
if ( canSave == false )
    errorsThere = true;

if(f_query_add_mod.patient_sub.document.getElementById('doc_id3').value !="")
{	/*
    if (f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt3').value == "")
    {
        canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt3'),'Expiry Date3');
    }*/
    if (f_query_add_mod.patient_sub.document.getElementById('doc_num3').value == "")
    {
       if(f_query_add_mod.patient_sub.document.getElementById('doc_num3').value=="")
		{
			canSave=checkForNull(getLabel('Common.documentno.label','common')+"3");
			//checkForNull(canSave);
		}
    }
}
if ( canSave == false )
    errorsThere = true;

if(f_query_add_mod.patient_sub.document.getElementById('doc_id4').value !="")
{/*
    if (f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt4').value == "")
    {
        canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt4'),'Expiry Date4');
    }*/

    if (f_query_add_mod.patient_sub.document.getElementById('doc_num4').value == "")
    {
        if(f_query_add_mod.patient_sub.document.getElementById('doc_num4').value=="")
		{
			canSave=checkForNull(getLabel('Common.documentno.label','common')+"4");
			//checkForNull(canSave);
		}
    }
} 

if ( canSave == false )
    errorsThere = true;


//if ( !f_query_add_mod.patient_sub.doDateCheckAlert(f_query_add_mod.patient_sub.document.getElementById('date_of_birth'),f_query_add_mod.patient_sub.document.getElementById('ServerDate'),f_query_add_mod.patient_sub.document.getElementById('other_era_diff').value) )
if(f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value!="") {
	if (!f_query_add_mod.patient_sub.isBeforeNow(f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value,"DMY",localeName)) 
	{
		LocalErrors += f_query_add_mod.patient_sub.getMessage('DOB_CHECK','Common') + ' <br>';
		canSave = false;
	}
}
/*Added by Thamizh selvi on 2nd Aug 2018 against ML-MMOH-CRF-1177 Start*/
if(f_query_add_mod.patient_sub.document.getElementById('isAutoPopulateNOKDOBAppl').value == 'true' && f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date') && f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').value!="") {
	if (!f_query_add_mod.patient_sub.isBeforeNow(f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').value,"DMY",localeName)) 
	{
		var errMsg = f_query_add_mod.patient_sub.getMessage('DOB_CHECK','Common');
		var repMsg = getLabel('eMP.NOK.label','MP')+" "+getLabel('Common.date.label','common');
		errMsg = errMsg.replace('Date', repMsg);
		LocalErrors += errMsg + ' <br>';
		canSave = false;
	}
}/*End*/
//Added by kumar on 16/03/2003 for National ID Validation with Date of Birth & Sex.
if (f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y")
{		
	if (f_query_add_mod.patient_sub.document.getElementById('national_id_no').value != "" && f_query_add_mod.patient_sub.document.getElementById('nat_data_source_id') != null)
	{
		if (f_query_add_mod.patient_sub.document.getElementById('nat_data_source_id').value=="NRIC" && f_query_add_mod.patient_sub.document.getElementById('invoke_routine').value=="Y")
		{
			if (f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value != '')
			{
				var dob = f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value;
				dob = dob.substring(8,10) + dob.substring(3,5)+dob.substring(0,2);
				if (f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.length >= 6)
				{
					if (dob!=f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.substring(0,6))
					{
						var natmsg = f_query_add_mod.patient_sub.getMessage("MISMATCH_NAT_DOB",'MP');
						natmsg = natmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
						LocalErrors += natmsg+ ' <br>';						
						canSave =false;
					}
				}
				if (f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.length >= 12)
				{
					var sexIdent = f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.substring(8,12);
					if (!isNaN(sexIdent))
					{
						var sexIdent = f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.substring(11,12);
						if (parseInt(sexIdent) == 1 || parseInt(sexIdent) == 3 || parseInt(sexIdent) == 5 || parseInt(sexIdent) == 7 || parseInt(sexIdent) == 9)
						{ 
							sexIdent = "M";
						}
						else
							sexIdent = "F";
							
						
						//Below contion modified for this CRF ML-MMOH-CRF-0778                        						
						if ((sexIdent!=f_query_add_mod.patient_sub.document.getElementById('sex').value) && (f_query_add_mod.patient_sub.document.getElementById('checkNatIdWithGender') && f_query_add_mod.patient_sub.document.getElementById('checkNatIdWithGender').value=="false"))
						{
							var natmsg = f_query_add_mod.patient_sub.getMessage("MISMATCH_NAT_SEX",'MP');
							natmsg = natmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
							LocalErrors += natmsg+ ' <br>';							
							canSave =false;
						}
					}
					else
					{
						var natmsg = f_query_add_mod.patient_sub.getMessage("NAT_ID_9_12",'MP');
						natmsg = natmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
						LocalErrors += natmsg+ ' <br>';							
						canSave =false;
					}
				}
			}
		}
	}
}
//End of Addition

	/*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] Start*/ 
	if(f_query_add_mod.patient_sub.document.getElementById('national_id_no') && f_query_add_mod.patient_sub.document.getElementById('isValidateNatIDWithDOB').value=="true"){
		var dobVal		= f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value;
		var natIdVal	= f_query_add_mod.patient_sub.document.getElementById('national_id_no').value;
		if(dobVal!= "" && natIdVal!=""){
			if(!f_query_add_mod.patient_sub.fnChkDOBNatIDValidation(dobVal,natIdVal)){
				var natmsg = f_query_add_mod.patient_sub.getMessage("MISMATCH_NAT_DOB",'MP');
				natmsg = natmsg.replace('#', f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
				LocalErrors += natmsg + ' <br>';
				canSave =false;
			}
		}
	}
	/*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] End*/ 
	/*Added by Thamizh selvi on 24th Mar 2017 for GDOH-CRF-0145 Start*/
	if(f_query_add_mod.patient_sub.document.getElementById('national_id_no') && f_query_add_mod.patient_sub.document.getElementById('chkGenderWithNatID').value=="true"){
		var gender	= f_query_add_mod.patient_sub.document.getElementById('sex').value;
		var natId	= f_query_add_mod.patient_sub.document.getElementById('national_id_no').value;
		if(gender!= "" && natId!=""){
			if(!f_query_add_mod.patient_sub.chkNatIDWithGender(gender,natId)){
				var errmsg = f_query_add_mod.patient_sub.getMessage('MISMATCH_NAT_SEX','MP');
				errmsg = errmsg.replace('National ID', f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
				LocalErrors += errmsg + ' <br>';
				canSave =false;
			}
		}
	}/*End*/
//Nationality Validation
// Conditon Newly Added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
if(f_query_add_mod.patient_sub.document.getElementById('region_appl_yn1').value=='Y'&& f_query_add_mod.patient_sub.document.getElementById('region_prompt1').value!=""){ 
			if(f_query_add_mod.patient_sub.document.getElementById('id1').style.visibility=='visible')
			{
			if(f_query_add_mod.patient_sub.document.getElementById('r_region_code').value=="")
			{
			canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById('region_prompt1').value);
			}
			if ( canSave == false )
                errorsThere = true;
			}
			}

/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
if(f_query_add_mod.patient_sub.document.getElementById('addr_pincode_mand1'))
			{
			if(f_query_add_mod.patient_sub.document.getElementById('r_addr_line1').value=="")
			{
				canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById('addr_line1_prompt').value);
			}

            if ( canSave == false )
                errorsThere = true;
			}
if(f_query_add_mod.patient_sub.document.getElementById('addr_pincode_mand2'))
			{
			if(f_query_add_mod.patient_sub.document.getElementById('r_addr_line2').value=="")
			{
				canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById('addr_line2_prompt').value);
			}

            if ( canSave == false )
                errorsThere = true;
			}
			/*Added against AMRI-CRF-0388 by shagar*/
			if(f_query_add_mod.patient_sub.document.getElementById('area_code_mand'))
			{
			if(f_query_add_mod.patient_sub.document.getElementById('r_area_code').value=="")
			{
				canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById('area_code_prompt').value);
			}
            if ( canSave == false )
                errorsThere = true;
			}
			/*Below Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522*/
			if(f_query_add_mod.patient_sub.document.getElementById('town_code_mand'))
			{
			if(f_query_add_mod.patient_sub.document.getElementById('r_town_code').value=="")
			{
				canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById('town_code_prompt').value);
			}
            if ( canSave == false )
                errorsThere = true;
			}
			
if(f_query_add_mod.patient_sub.document.getElementById('addr_pincode_mand3'))
			{
			if(f_query_add_mod.patient_sub.document.getElementById('r_postal_code1').value=="")
			{
				canSave = checkForNull(f_query_add_mod.patient_sub.document.getElementById('postal_code_prompt').value);
			}

            if ( canSave == false )
                errorsThere = true;
			}
/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/

if(f_query_add_mod.patient_sub.document.getElementById('id2').style.visibility=='visible')
			{
			if(f_query_add_mod.patient_sub.document.getElementById('r_country_code').value=="")
			{
				canSave=checkForNull(getLabel('Common.country.label','common'));
			}

            if ( canSave == false )
                errorsThere = true;
			}
			if(f_query_add_mod.patient_sub.document.getElementById('id3').style.visibility=='visible')
			{
			if(f_query_add_mod.patient_sub.document.getElementById('contact2_no').value=="")
			{
				canSave=checkForNull(getLabel('Common.MobileNo.label','common'));
			}

            if ( canSave == false )
                errorsThere = true;
			}
// Ends here
// Newly Added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
			if(f_query_add_mod.patient_sub.document.getElementById('id4').style.visibility=='visible')
			{
			if(f_query_add_mod.patient_sub.document.getElementById('email').value=="")
			{
				canSave=checkForNull(getLabel('Common.email.label','common'));
			}

            if ( canSave == false )
                errorsThere = true;
			}// Ends here
			if (f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y")
			{ 
				if(f_query_add_mod.patient_sub.document.getElementById('nationality_code').value == f_query_add_mod.patient_sub.document.getElementById('dflt_nationality_code').value)
				{
					if((f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value == "N") || (f_query_add_mod.patient_sub.document.getElementById('legal').value == "N"))
					{
						var resmsg = f_query_add_mod.patient_sub.getMessage("RES_STATUS_FOR_CITIZEN",'MP');
						resmsg = resmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById('nationality_desc').value);
						alert(resmsg);
						errorsThere = true;
						canSave = false;

					}
				}
			}
			if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "false")//Added for AAKH-CRF-0145
			{
			if(f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value == "N")
			{
				if (f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y")
				{ 
					if(f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.length > 0)
					{
						
						var nat_id_prmt_1=f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value;
					
						var msg1=f_query_add_mod.patient_sub.getMessage("NRIC_FOR_NONCITIZEN",'MP');
						msg1=msg1.replace('$',nat_id_prmt_1)
						alert(msg1);						
						f_query_add_mod.patient_sub.document.getElementById('national_id_no').disabled = false;
						
						canSave =false;
						errorsThere = true;
					}
				}
			}	
			}
			var dob1 = f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').value;
			dob1 = dob1.substring(8,10) + dob1.substring(3,5)+dob1.substring(0,2);
			if (f_query_add_mod.patient_sub.document.getElementById('contact1_new_nat_id_no').value.length >= 6)
			{
				if ( (f_query_add_mod.patient_sub.document.getElementById('nat_data_source_id').value=="NRIC") && (f_query_add_mod.patient_sub.document.getElementById('invoke_routine').value=="Y") &&  (dob1!=f_query_add_mod.patient_sub.document.getElementById('contact1_new_nat_id_no').value.substring(0,6)) )
				{
					var natmsg = f_query_add_mod.frames[1].getMessage('MISMATCH_NAT_DOB','MP');
					natmsg = natmsg.replace('#', f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
					LocalErrors += natmsg + ' ' + getLabel('Common.in.label','common')+ " " +getLabel('Common.nextofkin.label','common')+' <br>';
					canSave =false;
				}
			}
			if (f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y")
			{ 
				if(f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.length>0)
				{
					if(f_query_add_mod.patient_sub.document.getElementById('national_id_no').value!="" && f_query_add_mod.patient_sub.document.getElementById('contact1_new_nat_id_no').value!="")
					{
						if(f_query_add_mod.patient_sub.document.getElementById('national_id_no').value == f_query_add_mod.patient_sub.document.getElementById('contact1_new_nat_id_no').value)
						{
							var resmsg = f_query_add_mod.patient_sub.getMessage("NRIC_CANNOT_BE_SAME",'MP');
							resmsg = resmsg.replace('#',getLabel("Common.nextofkin.label","Common"));
							resmsg = resmsg.replace('$',f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
							resmsg = resmsg.replace('~',f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);

							alert(resmsg);
							errorsThere = true;
							canSave = false;
						}
					}
					if(f_query_add_mod.patient_sub.document.getElementById('national_id_no').value!="" && f_query_add_mod.patient_sub.document.getElementById('contact2_nat_id_no').value!="")
					{
						if(f_query_add_mod.patient_sub.document.getElementById('national_id_no').value == f_query_add_mod.patient_sub.document.getElementById('contact2_nat_id_no').value)
						{
							var resmsg = f_query_add_mod.patient_sub.getMessage("NRIC_CANNOT_BE_SAME",'MP');
							resmsg = resmsg.replace('#',getLabel("Common.firsttonotify.label","Common"));
							resmsg = resmsg.replace('$',f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
							resmsg = resmsg.replace('~',f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
							alert(resmsg);
							errorsThere = true;
							canSave = false;
						}
					}
				}
			}

if(f_query_add_mod.patient_sub.document.getElementById('nationality_code').value == ''){
	f_query_add_mod.patient_sub.document.getElementById('nationality_code').value ='';
}

if(f_query_add_mod.patient_sub.document.getElementById('nationality_desc').value=='')
		f_query_add_mod.patient_sub.document.getElementById('nationality_code').value='';

//Below added by Suji keerthi for ML-MMOH-CRF-1527 US007
if(aliasnameNationalityRace=="true"){
if(f_query_add_mod.patient_sub.document.getElementById('rel_nationality_desc'))
{
if(f_query_add_mod.patient_sub.document.getElementById('rel_nationality_desc').value == "")
	{
	f_query_add_mod.patient_sub.document.getElementById('rel_nationality_code').value="";
	}
}

if(f_query_add_mod.patient_sub.document.getElementById('rel_race_desc'))
{
if(f_query_add_mod.patient_sub.document.getElementById('rel_race_desc').value == "")
	{
	f_query_add_mod.patient_sub.document.getElementById('rel_race_code').value="";
	}
}

}
//Ended by Suji keerthi for ML-MMOH-CRF-1527 US007


if (f_query_add_mod.patient_sub.document.getElementById('nationality_code').value == '')
{
	if(f_query_add_mod.patient_sub.document.getElementById('nationality_code').value=="")
{
			canSave=checkForNull(getLabel('Common.nationality.label','common'));
//			checkForNull(canSave);
		}
}
if ( canSave == false )
	errorsThere = true;

//Added for Maximum age validation
var maxAge = f_query_add_mod.patient_sub.document.getElementById('max_patient_age').value;
var actAge = f_query_add_mod.patient_sub.document.getElementById('b_age').value;
var actMonth = f_query_add_mod.patient_sub.document.getElementById('b_months').value;
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
if (f_query_add_mod.patient_sub.document.getElementById('bl_install_yn').value=='Y')
{
	if (f_query_add_mod.patient_sub.document.getElementById('bl_success').value=='N')
	{
	//Added by Gayathri for GDOH-CRF-0142 
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	var temp_jsp="../../eBL/jsp/BillReceiptAjax.jsp?calledFrom=changePatDtls";					
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);	
	if(responseText=="N")
	{
		LocalErrors += f_query_add_mod.patient_sub.getMessage("FINANCIAL_DET_MANDATORY",'MP') + ' <br>';
		canSave = false;
	}
	}

	//Added by Ashwini on 07-Sep-2018
	var finDtlsChkNationality = f_query_add_mod.patient_sub.document.getElementById('finDtlsChkNationality').value;
	if(canSave == true && finDtlsChkNationality != "true")
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
	if(f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y")
	{ 
		if(f_query_add_mod.patient_sub.ChangePatDtlForm.national_id_no.value!="")
		{	
	       if(await confirmNRIC())
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

	var patient_deceased_yn	= "N";
	var patient_deceased_date	= "";
	var locale = f_query_add_mod.patient_sub.ChangePatDtlForm.locale.value;	
	
	if(f_query_add_mod.patient_sub.ChangePatDtlForm.patient_deceased_yn)
		patient_deceased_yn = f_query_add_mod.patient_sub.ChangePatDtlForm.patient_deceased_yn.value;

	if(f_query_add_mod.patient_sub.ChangePatDtlForm.patient_deceased_date)
		patient_deceased_date = f_query_add_mod.patient_sub.ChangePatDtlForm.patient_deceased_date.value;

	var Birth_Date = f_query_add_mod.patient_sub.ChangePatDtlForm.Birth_Date.value;	
		
		if((patient_deceased_yn == 'Y')&&(Birth_Date != "")){			
			if(isBefore(Birth_Date,patient_deceased_date,"DMYHMS",locale)==false)
			{			
				var str  = f_query_add_mod.patient_sub.getMessage("CANNOT_GREATER","MP");
				str  = str.replace('#', getLabel('Common.birthDate.label','Common')+" "+getLabel('Common.time.label','Common'));
				str  = str.replace('$', getLabel('Common.DeceasedDate.label','Common')+" "+getLabel('Common.time.label','Common'));				
				LocalErrors += str + ' <br>';				
				canSave = false;
				errorsThere = true;
			}				
		}
	// added by mujafar for KDAH-CRF-347 start	
	if(f_query_add_mod.patient_sub.document.getElementById('chkForm60Allow').value=="true" && f_query_add_mod.patient_sub.document.getElementById('alt_id3_no_dup'))
		{  
			if(f_query_add_mod.patient_sub.document.getElementById('alt_id3_no_dup').value == "")
			{ 
				if(f_query_add_mod.patient_sub.document.getElementById('alt_id3_no').value != f_query_add_mod.patient_sub.document.getElementById('alt_id3_no_dup').value)
				{
					var form60_value_chk =f_query_add_mod.patient_sub.document.getElementById('form60_value_chk').value;
					if(form60_value_chk>0)
					{
						var str =getMessage('PANCARD_NOT_ALLOWED','MP');
						LocalErrors += str + ' <br>';				
						canSave = false;
						errorsThere = true;
					}
				}
			}
		}
		 // added by mujafar for KDAH-CRF-347 end
		 // added by mujafar for KDAH-CRF-370.1 start	
		
if(f_query_add_mod.patient_sub.document.getElementById('chkPanValidate').value=="true" && f_query_add_mod.patient_sub.document.getElementById('alt_id3_no'))
{ 
if(canSave==true && errorsThere == false )	
{
if(f_query_add_mod.patient_sub.document.getElementById('alt_id3_no').value!="")
{ 
	
		
		if(f_query_add_mod.patient_sub.document.getElementById('pan_status').value=="")
		{
		
		alert(getMessage('PANCARD_VALIDATE_MNDT','MP'));
		f_query_add_mod.patient_sub.document.getElementById('pan_val_button').focus();
		canSave = false;
		if ( canSave == false )
        errorsThere = true;
		}
	
}

}

if(canSave==true && errorsThere == false )	
{
	if(f_query_add_mod.patient_sub.document.getElementById('alt_id3_no').value)
	{
		if(f_query_add_mod.patient_sub.document.getElementById('pan_status').value!="")
			if(f_query_add_mod.patient_sub.document.getElementById('pan_rel_mem').value=="")
			{
				
				alert(getMessage('PANCARD_RELATION_MNDT','MP'));
				f_query_add_mod.patient_sub.document.getElementById('pan_rel_mem').focus();
				canSave = false;
				if ( canSave == false )
				errorsThere = true;
			}
			
	}
} 
if(canSave==true && errorsThere == false )	
{ 
var birthDate=convertDate(f_query_add_mod.patient_sub.document.getElementById('Birth_Date').value,"DMYHMS",localeName,"en");
		if(birthDate.length==19)birthDate=birthDate.substring(0,16);	
       if(birthDate.length==18)birthDate=birthDate.substring(0,15);		
       if(birthDate.length==17)birthDate=birthDate.substring(0,14);
	   
if(birthDate!= null)
{
var time_temp = birthDate.split("/");
var time_yr = time_temp[2].split(" ");

var  ages =  calculate_age(time_temp[1],time_temp[0],time_yr[0]);

if(f_query_add_mod.patient_sub.document.getElementById('alt_id3_no').value && (ages>=18))
{ 
	
	
		if(f_query_add_mod.patient_sub.document.getElementById('pan_rel_mem').value != 'S')
		{
			
			alert(getMessage('PANCARD_SELF_MNDT','MP'));
		f_query_add_mod.patient_sub.document.getElementById('pan_rel_mem').focus();
		canSave = false;
		if ( canSave == false )
        errorsThere = true;
		}
		
}	
	
}   
}
		
		
		
		if(f_query_add_mod.patient_sub.document.getElementById('alt_id3_no').value && f_query_add_mod.patient_sub.document.getElementById('pan_rel_mem').value == 'S' && f_query_add_mod.patient_sub.document.getElementById('pancard_no').value != f_query_add_mod.patient_sub.document.getElementById('alt_id3_no').value)
				{
					
				var temp1 = f_query_add_mod.patient_sub.document.getElementById('pan_holder_name').value;
				
				var temp_var = f_query_add_mod.patient_main.document.getElementById('patient_name').value;
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
		
		
		
		
		

		
// added by mujafar for KDAH-CRF-370.1  end	

// Added by Sethu for KDAH-CRF-0362


var national_id = "";
var aadhaar_id = "";
var aadhaar_status = "";

if (f_query_add_mod.patient_sub.document.getElementById('national_id_no'))
{	
	if (f_query_add_mod.patient_sub.document.getElementById('national_id_no').value != "")
	{	
		national_id = f_query_add_mod.patient_sub.document.getElementById('national_id_no').value;
		aadhaar_id = f_query_add_mod.patient_sub.document.getElementById('aadhaarID').value;
		aadhaar_status = f_query_add_mod.patient_sub.document.getElementById('aadhaarStatus').value;

	if (aadhaar_id != "")
	{
		if ((national_id != aadhaar_id) && (aadhaar_status == "Y"))
		{
			f_query_add_mod.patient_sub.document.getElementById('aadhaarStatus').value = "N";
			f_query_add_mod.patient_sub.document.getElementById('aadhaarTransId').value = "";
		}
		else
			f_query_add_mod.patient_sub.document.getElementById('aadhaarStatus').value = "Y";
	}

		CheckForeKYCValidate(); 	
	}
}

if ( canSave == true && errorsThere == false ) {
 
	if(f_query_add_mod.patient_sub.document.getElementById('abha_pat_id') !=null && f_query_add_mod.patient_sub.document.getElementById('abha_pat_id').value!="" && f_query_add_mod.patient_sub.document.getElementById('ndhm_appl_YN').value=="Y" ){
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					var abha_id=f_query_add_mod.patient_sub.document.getElementById('abha_pat_id').value;
					xmlStr ='<root><SEARCH /></root>';
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open('POST','../../eMP/jsp/MPIntermediate.jsp?action=chkDuplicateABHAId&abha_id='+abha_id+"&patient_id="+f_query_add_mod.patient_sub.ChangePatDtlForm.patient_id.value,false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText;
					responseText = trimString(responseText);
					if(responseText >= 1){
						canSave = false;
						error	= getMessage('DUP_ABHA_NO','MP');
						error = error.replace("#",f_query_add_mod.patient_sub.document.getElementById('abha_pat_id').value);
						LocalErrors += error+ "<br>";
						errorsThere = true
					}
				}
}
///////////end of validation.///////////////////////
if ( canSave == true && errorsThere == false )
{

		if(f_query_add_mod.patient_sub.document.forms[0].dflt_alt_id1_in_emp_id_yn.value=='Y' && f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value=='') {
			f_query_add_mod.patient_sub.document.getElementById('empyr_eid').value = f_query_add_mod.patient_sub.document.forms[0].patient_employee_id.value;
		}
   
		/*Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
		if(f_query_add_mod.patient_sub.document.getElementById('nat_id_pat_ser_grp').value!=f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').value && f_query_add_mod.patient_sub.document.getElementById('isNatIdMandatory').value=="Y" && f_query_add_mod.patient_sub.document.getElementById('isClearNatIdValues').value=="C"){
			f_query_add_mod.patient_sub.document.getElementById('national_id_no').value="";
		}
//	isSubmit conditions added by Dharma. Reason : All the fields enabled while canceling Password popup window.
		var isSubmit		= "Y";
		if(f_query_add_mod.patient_sub.document.getElementById('accept_pw_in_chng_pat_dtl_yn').value == "Y")
		{
			var arguments = "";
			var dialogHeight = "15vh";
			var dialogWidth = "25vw";
			var status = "no";
			var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scrolling=no; overflow: hidden; status:" + status;
			if(top.window.document.getElementById('dialog-body')){
			
			retVal = await window[1].showModalDialog("../../eMP/jsp/ChangePatAcceptPassword.jsp",arguments,features);}
			else
			retVal = await window.showModalDialog("../../eMP/jsp/ChangePatAcceptPassword.jsp",arguments,features);
			if(retVal == true) {
				isSubmit	= "Y";
			}
			else {
				isSubmit	= "N";
			}
		}
		if(isSubmit	=="Y"){
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
        	
        	/*var msgFrame = top.window.document.getElementById('dialog-body').contentWindow ;
        //console.log(msgFrame.frames[2].name)
        	f_query_add_mod.patient_sub.document.ChangePatDtlForm.target = msgFrame.frames[2].name;*/
        	//console.log(f_query_add_mod.patient_sub.document.ChangePatDtlForm);
        	f_query_add_mod.patient_sub.document.ChangePatDtlForm.action = "../../servlet/eMP.PatientRegistrationServlet";
        	f_query_add_mod.patient_sub.document.ChangePatDtlForm.target = "messageFrame";
			f_query_add_mod.patient_sub.document.ChangePatDtlForm.submit();
        	/*alert("BEfore submit in CHangepatient 1943")*/

		}else{
			messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	
		/*Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491] End*/ 
	/*	if(f_query_add_mod.patient_sub.document.getElementById('accept_pw_in_chng_pat_dtl_yn').value == "Y")
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
		}*/
	
}
else
{ 
	var sStyle = f_query_add_mod.patient_sub.document.forms[0].sStyle.value;
 if(f_query_add_mod.patient_sub.document.getElementById('function_id').value == '')
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
                    " parent.commontoolbarFrame.location.href ='../../eMP/jsp/ChangepatdocsToolBar.jsp?home_required_yn=N&function_id="+f_query_add_mod.patient_sub.document.getElementById('function_id').value+"';"+
                "</script></body>" +
                "</html>"
				/*var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head>" +
                    "<body class='message' onKeyDown='lockKey()'><script> document.writeln(\""+LocalErrors+"\");"+
                    " parent.commontoolbarFrame.location.href ='../../eCommon/jsp/commonToolbar.jsp?&function_type=F&home_required_yn=N&access=NYNNN'"+
                "</script></body>" +
                "</html>"*/
	   messageFrame.document.open('text/html', 'replace');
       messageFrame.document.writeln(s);
    }
}
}

} //END of the function

async function confirmNRIC()
{

	var retVal =    new String();
	var dialogHeight= "18vh" ;
	var dialogWidth = "30vw" ;
	var status = "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var vdateofbirth = f_query_add_mod.patient_sub.ChangePatDtlForm.v_date_of_birth.value;
	//var greg_date_of_birth = f_query_add_mod.patient_sub.ChangePatDtlForm.greg_date_of_birth.value;
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
	var placeofbirth = f_query_add_mod.patient_sub.ChangePatDtlForm.place_of_birth.value;
	var vplaceofbirth = f_query_add_mod.patient_sub.ChangePatDtlForm.v_place_of_birth.value;
	var natidprompt = f_query_add_mod.patient_sub.ChangePatDtlForm.nat_id_prompt.value;

	//if(vdateofbirth!=greg_date_of_birth || vbirthplacecode!=birthplacecode || vsex!=sex || vage!=age || vmonths!=months || days!=vdays)	

	if(vbirthplacecode!=birthplacecode || placeofbirth!=vplaceofbirth || vsex!=sex || vage!=age || vmonths!=months || days!=vdays || vhours!=hours)
	{
		if(vbirthplacedesc=="" && vplaceofbirth!="")
			vbirthplacedesc = vplaceofbirth;
		if(birthplacedesc=="" && placeofbirth!="")
			birthplacedesc = placeofbirth;

		birthplacedesc = encodeURIComponent(birthplacedesc,'UTF-8');
		vbirthplacedesc = encodeURIComponent(vbirthplacedesc,'UTF-8');
		natidprompt = encodeURIComponent(natidprompt,'UTF-8');

		retVal = await window.showModalDialog( "../../eMP/jsp/showNRICValues.jsp?vdateofbirth="+vdateofbirth+"&dateofbirth="+dateofbirth+"&vsex="+vsex+"&sex="+sex+"&natidprompt="+natidprompt+"&birthplacecode="+birthplacecode+"&vbirthplacecode="+vbirthplacecode+"&birthplacedesc="+birthplacedesc+"&vbirthplacedesc="+vbirthplacedesc+"&age="+age+"&months="+months+"&days="+days+"&vage="+vage+"&vmonths="+vmonths+"&vdays="+vdays+"&place_of_birth="+placeofbirth+"&vhours="+vhours+"&hours="+hours,arguments,features);
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


// ***********************************************************************

/*
function reset() {
	if( f_query_add_mod.patient_sub!=null){
	    f_query_add_mod.patient_sub.location.reload();
	doValidation = false;
}
}
*/







function reset() 
{
	if(f_query_add_mod.patient_sub != null)
	{
		if(window.dialogArguments != undefined) {
			 var patient_id = "";
			 var function_id = "";
			 var load_tab = "";
			 var reset_dem = "";
			 if(f_query_add_mod.patient_sub.ChangePatDtlForm.patient_id)
				patientId = f_query_add_mod.patient_sub.ChangePatDtlForm.patient_id.value;	
			 if(f_query_add_mod.patient_sub.ChangePatDtlForm.function_id)
				function_id = f_query_add_mod.patient_sub.ChangePatDtlForm.function_id.value;
			 /*Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1*/
			 if(f_query_add_mod.patient_sub.ChangePatDtlForm.load_tab)
				load_tab = f_query_add_mod.patient_sub.ChangePatDtlForm.load_tab.value;
				if(load_tab == 'CONTACT_ADDR_TAB'){
					 reset_dem = 'DEM_DTLS_TAB'
				}
			 /*End AAKH-CRF-0128.1*/

			 f_query_add_mod.patient_sub.location.href = "../../eMP/jsp/ChangePatientSub.jsp?patient_id="+patientId+"&function_id="+function_id+"&load_tab="+load_tab+"&reset_dem="+reset_dem;		
			 messageFrame.location.href='../../eCommon/jsp/error.jsp';
		 } else {			
			 f_query_add_mod.location.reload();
		 }

		  if (f_query_add_mod.patient_sub.document.getElementById('func_act')!= null && f_query_add_mod.patient_sub.document.getElementById('appt_yn')!=null) {
			if (f_query_add_mod.patient_sub.document.getElementById('func_act').value != '' || f_query_add_mod.patient_sub.document.getElementById('appt_yn').value == 'Appt') {		
				setTimeout("disableHome()", 100);
			}
		  }
	}
}




// ***********************************************************************

function help() {

}


function sendToServer(Val)  {

// 1 indicates the calculation of DAYS,MONTH,AGE
// 2 indicates the calculation of DATE OF BIRTH
// 3 indicates the Validation of the PATIENT ID and Duplication .
var HTMLVal = new String();

if ( Val == 1 )
{
   	xmlStr+=" process_id=\"1\" ";
	xmlStr+=" date_of_birth=\""+document.getElementById('date_of_birth').value+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var url = "../../eMP/jsp/ServerValidationXML.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

if ( Val == 2 )
{
   	xmlStr+=" process_id=\"2\" ";
	xmlStr+=" b_age=\""+document.getElementById('b_age').value+"\"";
	xmlStr+=" b_months=\""+document.getElementById('b_months').value+"\"";
	xmlStr+=" b_days=\""+document.getElementById("b_days").value+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var url = "../../eMP/jsp/ServerValidationXML.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

if ( Val == 3 )
{
    /*HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='../../eMP/jsp/ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='3'><input type='hidden' name='b_age' id='b_age' value='" + document.getElementById('b_age').value + "'><input type='hidden' name='b_months' id='b_months' value='" + document.getElementById('b_months').value +"'><input name='b_days' id='b_days' type='hidden' value='"+document.getElementById("b_days").value + "'></form></BODY></HTML>";
    parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.messageFrame.document.form1.submit();*/

	xmlStr+=" process_id=\"3\" ";
	xmlStr+=" b_age=\""+document.getElementById('b_age').value+"\"";
	xmlStr+=" b_months=\""+document.getElementById('b_months').value+"\"";
	xmlStr+=" b_days=\""+document.getElementById("b_days").value+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var url = "../../eMP/jsp/ServerValidationXML.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);

}

if ( Val == 4 )
{
    var varLength = new String();
    varLength = document.getElementById('family_link_no').value;
    varLength = varLength.length;
    if ( varLength > 0 )
    {
		if ( varLength == document.getElementById('family_link_no').maxLength)
        {
            if ( document.getElementById('family_link_no').value == document.getElementById('patient_id').value )
            {
                
				alert(f_query_add_mod.patient_sub.getMessage("HEAD_PAT_SAME_AS_PAT",'MP'));
                document.getElementById('family_link_no').focus();
            }
            else
            {
               	xmlStr+=" process_id=\"4\" ";
				xmlStr+=" family_link_no=\""+document.getElementById('family_link_no').value+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				var url = "../../eMP/jsp/ServerValidationXML.jsp";
				xmlHttp.open("POST", url, false);
				xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
				xmlHttp.send(xmlDoc);
				eval(xmlHttp.responseText);

               // document.getElementById('relationship_to_head').disabled  = true;
            }
        }
        else
        {
            var msg = f_query_add_mod.patient_sub.getMessage("HEAD_PATID_CHAR",'MP');
			msg = msg.replace('@', document.getElementById('family_link_no').maxLength);
			alert(msg);
            document.getElementById('family_link_no').focus();
        }
    }
    else    if ( varLength == 0 )
    {
       	/*If Membership type exixts do not clear relationship*/
		document.getElementById('head_pat_name').innerText = "";
		if (document.getElementById('family_org_id_accept_yn').value=='N')
        {
			if(document.getElementById('relationship_to_head_desc') != null)
			{
				document.getElementById('relationship_to_head_desc').value = "";
				document.getElementById('relationship_to_head').value = "";
				document.getElementById('relationship_to_head_desc').disabled = true;
			}
		}
		else
		{		   
			if(document.getElementById('relationship_to_head_desc') != null)
			{
				if (document.getElementById('family_org_membership'))
				{
					if (document.getElementById('family_org_membership').value ==1 )
					{
						document.getElementById('relationship_to_head').value = document.getElementById('org_member_relationship_code').value;
						document.getElementById('relationship_to_head_desc').disabled=true;
						document.getElementById('rel').style.visibility=='hidden';
					}
					else
					if ( (document.getElementById('family_org_membership').value ==2 ) || (document.getElementById('family_org_membership').value ==3 ) )
					{
						document.getElementById('relationship_to_head').value ='';
						document.getElementById('relationship_to_head_desc').value ='';
						document.getElementById('rel').style.visibility=='visible';
						document.getElementById('relationship_to_head_desc').disabled = false;
					}
				}
				else
				{
					document.getElementById('rel').style.visibility=='hidden';
					document.getElementById('relationship_to_head').value = '';
					document.getElementById('relationship_to_head_desc').value = '';
					document.getElementById('relationship_to_head_desc').disabled = true;
				}
			}
		}
     }
}

if ( Val == 7 )
{

          /*  HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='../../eMP/jsp/ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='7'><input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById('area_code').value + "'></form></BODY></HTML>";

            parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.parent.messageFrame.document.form1.submit();*/

			xmlStr+=" process_id=\"7\" ";
			xmlStr+=" res_area_code=\""+document.getElementById('area_code').value+"\"";
                    		
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			var url = "../../eMP/jsp/ServerValidationXML.jsp";
			xmlHttp.open("POST", url, false);
			xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
			xmlHttp.send(xmlDoc);
			eval(xmlHttp.responseText);

}

} // END OF THE FUNCTION

// ***********************************************************************

function putPatientName(from)   {

    var logic = new String();
    logic = document.getElementById('name_drvn_logic').value;
    var derievedName = new String();
    derievedName = '';
    var logicElements = new Array();
    logicElements = logic.split('+');
    var i=0;

    for ( i=0;i<logicElements.length;i++)
    {
        if ( logicElements[i] == '1N' && document.getElementById('first_name') != null)
        {
            if ( document.getElementById('first_name').value != '' )
                derievedName = derievedName + document.getElementById('first_name').value;
        }
        else if ( logicElements[i] == '2N' && document.getElementById('second_name') != null )
        {
            if ( document.getElementById('second_name').value != '' )
                derievedName = derievedName + document.getElementById('second_name').value;
        }
        else if ( logicElements[i] == '3N' && document.getElementById('third_name') != null)
        {
            if ( document.getElementById('third_name').value != '' )
                derievedName = derievedName + document.getElementById('third_name').value;
        }
        else if ( logicElements[i] == 'FN' && document.getElementById('family_name') != null)
        {
            if ( document.getElementById('family_name').value != '' )
                derievedName = derievedName + document.getElementById('family_name').value;
        }
        else if ( logicElements[i] == 'PR' && document.getElementById('name_prefix') != null)
        {
            if ( document.getElementById('name_prefix').value != '' )
                derievedName = derievedName + document.getElementById('name_prefix').value;
        }
        else if ( logicElements[i] == 'SF' && document.getElementById('name_suffix') != null)
        {
            if ( document.getElementById('name_suffix').value != '' )
                derievedName = derievedName + document.getElementById('name_suffix').value;
        }
        else
        {
            if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' )
            {
                var arLen = logicElements[i].length;
                var tempVal = logicElements[i].substring(1,arLen - 1);
                derievedName = derievedName + tempVal;
            }
        }
    
    }

    if ( derievedName.length >= 40 )
        derievedName = derievedName.substr(0,40);

	var derievedName1 = derievedName.split(',');
	if(derievedName1[1] == ' ')
	{
		derievedName = 	derievedName1[0];
	}

    parent.patient_main.document.getElementById('patient_name').value = derievedName;
    parent.patient_sub.document.getElementById('patient_name').value = derievedName;
	//putLocalLangPatientName();


}// End of FUNCTION

	function putLocalLangPatientName(from){  
		
		var language_direction;
		if (f_query_add_mod.patient_main.document.getElementById('language_direction'))
		{
			language_direction= f_query_add_mod.patient_main.document.getElementById('language_direction').value;
		}
		

		var localLongNamelogic = new String();	   
		localLongNamelogic = f_query_add_mod.patient_sub.ChangePatDtlForm.name_drvn_logic_oth_lang_long.value;
		
		var derivedName = new String();
		derivedName = '';
		var logicElements = new Array();
		logicElements = localLongNamelogic.split('+');
		var i=0;	
		for ( i=0;i<logicElements.length;i++)
		{
				   
			if ( logicElements[i] == '1N' && f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang')!= null)
			{			
				if ( f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang').value != '' ){
					if(language_direction=='R'){
						derivedName =  f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang').value+derivedName ;
					}else{
						derivedName =  derivedName+  f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang').value  ;
					}
					
				}

				
			}
			else if ( logicElements[i] == '2N' &&  f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang') != null )
			{
				if (  f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang').value != '' ){
					if(language_direction=='R'){
						derivedName =   f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang').value+derivedName ;
					}else{
						derivedName =  derivedName+  f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang').value ;
					}
					
				}
			
			}
			else if ( logicElements[i] == '3N' &&  f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang') != null)
			{
				if (  f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang').value != '' ){
					if(language_direction=='R'){
						derivedName =   f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang').value+derivedName ;
					}else{
						derivedName = derivedName+  f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang').value ;
					}
					
				}
			
			}
			else if ( logicElements[i] == 'FN' &&  f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang') != null)
			{
				if (  f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang').value != '' ){
					if(language_direction=='R'){
						derivedName =   f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang').value+derivedName ;
					}else{
						derivedName =  derivedName+ f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang').value ;
					}
					
				}
				
			}
			else if ( logicElements[i] == 'PR' &&  f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang') != null)
			{
				if ( ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang')) && ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value != '') )
				{
					var prefix_loc_lang =  f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value;
					if(language_direction=='R'){
						derivedName =  prefix_loc_lang +derivedName;
					}else{
						derivedName =   derivedName+prefix_loc_lang ;
					}		
				}
			}
			else if ( logicElements[i] == 'SF' &&  f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang') != null)
			{
				 if (  f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value != '') 
				{
					var suffix_loc_lang =  f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value;
					if(language_direction=='R'){
						derivedName =   suffix_loc_lang+derivedName;
					}else{
						derivedName =   derivedName + suffix_loc_lang ;
					}
				}
			}
			else
			{
				if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' )
				{
					var arLen = logicElements[i].length;
					var tempVal = logicElements[i].substring(1,arLen - 1);
					if(derivedName == "")  tempVal="";
					if(language_direction=='R'){
						derivedName =  tempVal+derivedName;
					}else{
						derivedName = derivedName + tempVal;
					}
				}
			
			}
		
		}

		if(f_query_add_mod.patient_sub.ChangePatDtlForm.patient_name_loc_lang_long)
		{
			
			f_query_add_mod.patient_sub.document.getElementById('patient_name_loc_lang_long').value = derivedName;			
		}	
		

}
// ***********************************************************************


function validateFamilyNumber(Obj)  {	

    if ( document.getElementById('family_link_no').value == '' || document.getElementById('family_link_no').value.length == 0)
    {
        if ( document.getElementById('relationship_to_head_desc').value != '' )
        {            
			
			alert(f_query_add_mod.patient_sub.getMessage("HEAD_PATID_BLANK",'MP'));
            document.getElementById('relationship_to_head').value="";
            document.getElementById('relationship_to_head_desc').value="";
        }
    }
}

// ***********************************************************************

function setTownDesc(Obj)   {

}

// ***********************************************************************




// ***********************************************************************

/*function checkPatSex()  {
    var arLength = f_query_add_mod.patient_sub.NamePrefixArray.length;
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (f_query_add_mod.patient_sub.document.getElementById('name_prefix').value!='')  && ( unescape(f_query_add_mod.patient_sub.NamePrefixArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_prefix').value ) )
            {
				if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
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

			if( (f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value!='') && (unescape(f_query_add_mod.patient_sub.NamePrefixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value) )
            {
				if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
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
			if ( (f_query_add_mod.patient_sub.document.getElementById('name_suffix').value!='')  && ( unescape(f_query_add_mod.patient_sub.NameSuffixArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_suffix').value ) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }

			if( (f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value!='') && (unescape(f_query_add_mod.patient_sub.NameSuffixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
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
			if ( (f_query_add_mod.patient_sub.document.getElementById('name_prefix').value!='')  && ( unescape(f_query_add_mod.patient_sub.NamePrefixArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_prefix').value ) )
            {
				if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
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
		if( (f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value!='') && (unescape(f_query_add_mod.patient_sub.NamePrefixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value) )
		{
			if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
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
			if ( (f_query_add_mod.patient_sub.document.getElementById('name_suffix').value!='')  && ( unescape(f_query_add_mod.patient_sub.NameSuffixArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_suffix').value ) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
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
			if( (f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value!='') && (unescape(f_query_add_mod.patient_sub.NameSuffixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
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

// ***********************************************************************

function doDefaulting(from) {

if ( from == 1 )
{
    document.getElementById('nationality_code').value = document.getElementById('dflt_nationality_code').value;
    document.getElementById('pat_ser_grp_code').value = document.getElementById('dflt_pat_ser_grp_code').value;
    document.getElementById('pref_facility_id').value = document.getElementById('dflt_pref_facility_id').value;

    // IN CASE OF DEFAULTING A NON-AVAILABLE SERIES , SELECT WILL BECOME BLANK. TO AVOID THAT  THIS CHECKING IS MADE.....

    if ( document.getElementById('pat_ser_grp_code').value == '' || document.getElementById('pat_ser_grp_code').value == null)
        document.getElementById('pat_ser_grp_code').selectedIndex = 0;
    document.getElementById('pat_ser_grp_code').focus();
}
else if ( from == 2 )
{
    f_query_add_mod.patient_sub.document.getElementById('nationality_code').value = f_query_add_mod.patient_sub.document.getElementById('dflt_nationality_code').value;

    f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').value = f_query_add_mod.patient_sub.document.getElementById('dflt_pat_ser_grp_code').value;

    f_query_add_mod.patient_sub.document.getElementById('pref_facility_id').value = f_query_add_mod.patient_sub.document.getElementById('dflt_pref_facility_id').value;

    // IN CASE OF DEFAULTING A NON-AVAILABLE SERIES , SELECT WILL BECOME BLANK. TO AVOID THAT  THIS CHECKING IS MADE.....

    if ( f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').value == '' || f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').value == null)

        f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').selectedIndex = 0;
    f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').focus();

    f_query_add_mod.patient_main.document.getElementById('patient_name').value = f_query_add_mod.patient_sub.document.getElementById('patient_name').value;

}
}


// ***********************************************************************


// ***********************************************************************
/*
function disableEnableDate()    {
    if ( document.getElementById('age_or_dob').checked == true )
    {
	    document.getElementById('age_or_dob').value='Y';
        document.getElementById('b_age').disabled = false;
        document.getElementById('b_months').disabled = false;
        document.getElementById("b_days").disabled = false;
        document.getElementById('date_of_birth').disabled = true;
    }
    else if ( document.getElementById('age_or_dob').checked == false )
    {
	    document.getElementById('age_or_dob').value='N';
        document.getElementById('b_age').disabled = true;
        document.getElementById('b_months').disabled = true;
        document.getElementById("b_days").disabled = true;
        document.getElementById('date_of_birth').disabled = false;
    }
}
*/

function disableEnableDate()    {

	var disp_newborn_age = document.forms[0].display_new_born_age_in_hrs.value;
	/*
	var b_age = document.getElementById('b_age').value == "0"?"": document.getElementById('b_age').value;
	var b_months = document.getElementById('b_months').value == "0"?"": document.getElementById('b_months').value;
	var b_days = document.getElementById("b_days").value == "0"?"": document.getElementById("b_days").value;
	var b_hours = document.getElementById('b_hours').value == "0"?"": document.getElementById('b_hours').value;
	*/

	var b_age = document.getElementById('b_age').value;
	var b_months = document.getElementById('b_months').value;
	var b_days = document.getElementById("b_days").value;
	var b_hours = document.getElementById('b_hours').value;
	
    if ( document.getElementById('age_or_dob').checked == true )
    {
	    document.getElementById('age_or_dob').value='Y';
        
        document.getElementById('date_of_birth').disabled = true;
        document.getElementById('imgdateofbirth').disabled = true;
		document.getElementById('dateofbirth').disabled = true;
		document.getElementById('b_time').disabled = true;
		
		if(b_hours=="") {
			document.getElementById('b_age').disabled = false;		
			document.getElementById('b_months').disabled = false;		
			document.getElementById("b_days").disabled = false;
		}

		if( disp_newborn_age == "" || b_age !="" || b_months !="" || b_days !="" ) {
			document.getElementById('b_hours').disabled = true;
		} else {
			document.getElementById('b_hours').disabled = false;
		}

		if(b_age!="")
			document.getElementById('b_age').focus();
		else if(b_months!="")
			document.getElementById('b_months').focus();
		else if(b_days!="")
			document.getElementById("b_days").focus();
		else if(b_hours!="" && disp_newborn_age!="")
			document.getElementById('b_hours').focus();			
		
		if(b_age == "" && b_months == "" && b_days == "" && b_hours == "") {
			document.getElementById('b_age').focus();
		}		
			
    }
    else if ( document.getElementById('age_or_dob').checked == false )
    {
	    document.getElementById('age_or_dob').value='N';
        document.getElementById('b_age').disabled = true;
        document.getElementById('b_months').disabled = true;
        document.getElementById("b_days").disabled = true;
        document.getElementById('b_hours').disabled = true;
        document.getElementById('date_of_birth').disabled = false;
		document.getElementById('imgdateofbirth').disabled = false;
		document.getElementById('dateofbirth').disabled = false;
		if(disp_newborn_age != "" && document.getElementById('date_of_birth').value=="")
			document.getElementById('b_time').disabled = false;
		if(document.getElementById('date_of_birth').value!="")
			document.getElementById('date_of_birth').focus();		
    }
}

// ***********************************************************************
function checkLength(Obj,SizeVal)   {
    if ( Obj.value.length > SizeVal )
    {
		var msg = f_query_add_mod.patient_sub.getMessage("OBJ_CANNOT_EXCEED",'Common');
		msg = msg.replace('$', SizeVal);
		alert(msg);
        Obj.focus();
		 return false;
    }
	else
	    return true;
}
// ***********************************************************************
function setOcpnDesc(Obj)   {
    document.getElementById('empyr_ocpn_desc').value = '';
    if ( Obj == document.getElementById('empyr_ocpn_code') )
    {
        if ( document.getElementById('empyr_ocpn_code').value.length != 0 )
            document.getElementById('empyr_ocpn_desc').value = Obj.options[Obj.selectedIndex].text;
    }
    else if ( Obj == document.getElementById('empyr_ocpn_desc_temp') )
    {
        document.getElementById('empyr_ocpn_desc').value = Obj.value;
    }
}
// ***********************************************************************
function enableOcpnTemp()   {
    if ( document.getElementById('empyr_ocpn_code').selectedIndex != 0 )
    {
        document.getElementById('empyr_ocpn_desc_temp').value = '';
        document.getElementById('empyr_ocpn_desc_temp').disabled = true;
    }
    else if ( document.getElementById('empyr_ocpn_code').selectedIndex == 0 )
        document.getElementById('empyr_ocpn_desc_temp').disabled = false;
}
// ***********************************************************************
function copyDetails(Val)   { 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
    if ( Val == 1 )
    {
        /*if ( document.getElementById('family_link_no').value.length > 0 )
        {
            var HTMLVal = new String();
            HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='../../eMP/jsp/ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='8'><input type='hidden' name='head_patient_id' id='head_patient_id' value='" + document.getElementById('family_link_no').value +"'></form></BODY></HTML>";
            parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.parent.messageFrame.document.form1.submit();
        }*/
		if(document.getElementById('family_link_no').value.length > 0)
            {
                xmlStr+=" process_id=\"8\" ";
				xmlStr+=" head_patient_id=\""+document.getElementById('family_link_no').value+"\"";
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
        document.getElementById('next_addr_line1').value = document.getElementById('r_addr_line1').value ;
        document.getElementById('next_addr_line2').value = document.getElementById('r_addr_line2').value ;
        document.getElementById('next_addr_line3').value = document.getElementById('r_addr_line3').value ;
        document.getElementById('next_addr_line4').value = document.getElementById('r_addr_line4').value ;
        document.getElementById('next_postal_code').value = document.getElementById('r_postal_code').value ;
        document.getElementById('next_country_code').value = document.getElementById('r_country_code').value ;
        document.getElementById('next_res_tel_no').value = document.getElementById('contact1_no').value ;
        document.getElementById('next_off_tel_no').value = document.getElementById('contact2_no').value ;
        document.getElementById('next_contact_name').value = document.getElementById('r_contact_name').value;
		
		
    }
    if ( Val == 3 )
    {
        document.getElementById('first_contact_relation').value = document.getElementById('next_contact_relation').value ;
        document.getElementById('first_job_title').value = document.getElementById('next_job_title').value ;
        document.getElementById('first_addr_line1').value = document.getElementById('next_addr_line1').value ;
        document.getElementById('first_addr_line2').value = document.getElementById('next_addr_line2').value ;
        document.getElementById('first_addr_line3').value = document.getElementById('next_addr_line3').value ;
        document.getElementById('first_addr_line4').value = document.getElementById('next_addr_line4').value ;
        document.getElementById('first_postal_code').value = document.getElementById('next_postal_code').value ;
        document.getElementById('first_country_code').value = document.getElementById('next_country_code').value ;
        document.getElementById('first_res_tel_no').value = document.getElementById('next_res_tel_no').value ;
        document.getElementById('first_off_tel_no').value = document.getElementById('next_off_tel_no').value ;
        document.getElementById('first_contact_name').value = document.getElementById('next_contact_name').value;
		document.getElementById('first_contact_relation').focus();
    }
}

function enableFields()
{

     for(i=0;i<dis_list.length;i++)
     {

         if(dis_list[i] != null)
            dis_list[i].disabled = true
     }
}

function disableEnableFields()
{
	for(i=0;i<dis_list.length;i++)
	 {
		dis_list[i].disabled=true
	 }
}


//=====================================================================

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




function selVal() {
	if(document.ChangePatDtlForm.legal[0].checked==true) {
		document.ChangePatDtlForm.legal_yn.value='Y';
	} else {
		document.ChangePatDtlForm.legal_yn.value='N';
	}
}

//New function Added by Sathish.S for 20824 on Thursday, April 22, 2010 
function CheckForSpecChr(obj){
		var strCheck = '|,~,=,#';				
		var str=strCheck.split(",");		
		for(var i=0;i<str.length;i++){			
			if(obj.value.indexOf(str[i]) != -1)
				return false;
		}
		return true;	
}

 // Added by Sethu for KDAH-CRF-0362
function CheckForeKYCValidate()
{
	var chkAadhaarValidate = "";
	var chkeKYCValidate = "";
	var chkAadhaarStatus = "";
	
	if(f_query_add_mod.patient_sub.document.getElementById('chkAadhaarValidate')){
		
		chkAadhaarValidate = f_query_add_mod.patient_sub.document.getElementById('chkAadhaarValidate').value;
		if (f_query_add_mod.patient_sub.document.getElementById('chkEKYCValidate'))
		{
			chkeKYCValidate = f_query_add_mod.patient_sub.document.getElementById('chkEKYCValidate').value;

			if (chkeKYCValidate == "Y")
			{
				if (f_query_add_mod.patient_sub.document.getElementById('aadhaarStatus'))
				{					
					chkAadhaarStatus = f_query_add_mod.patient_sub.document.getElementById('aadhaarStatus').value;

					if (chkAadhaarStatus != "Y")
					{
						if (f_query_add_mod.patient_sub.document.getElementById('national_id_no').value != "")
							alert("Aadhaar Card Status has not been validated.");
					}
				}
			}
		}
	}
}

