var location0_array = new Array () ;
var locationT0_array = new Array();

/// Added by Sridhar R on 13 SEP 2004
/// This function will be called only for Registering More referrals 
/// The Referred From values are disabled & only to values are Enterable...

function enableDisableFrom()
{
	if(parent.frames[1].document.forms[0].ref_letter_no.disabled == false)
	{
		 parent.frames[1].document.forms[0].ref_letter_no.disabled	= true;
		parent.frames[1].document.forms[0].received_date.disabled	= true;
		parent.frames[1].document.getElementById('recd').disabled					= true;
		parent.frames[1].document.forms[0].referral_date.disabled	= true;
		parent.frames[1].document.forms[0].preferred_date.disabled	= true;
		parent.frames[1].document.getElementById('red').disabled					= true;
		parent.frames[1].document.getElementById('pred').disabled					= true;
		parent.frames[1].document.forms[0].referral_reason_desc.disabled = true;
		parent.frames[1].document.forms[0].ref_reason.disabled		= true;
		parent.frames[1].document.forms[0].referral_type.disabled	= true;
		parent.frames[1].document.forms[0].from_practitioner_id.disabled = true;
		parent.frames[1].document.forms[0].b_pract.disabled			= true;
		parent.frames[1].document.forms[0].referral_source.disabled = true;
		parent.frames[1].document.forms[0].referral_source_lkp_but.disabled = true; // added for rf 508
		parent.frames[1].document.forms[0].location0.disabled		= true;
		parent.frames[1].document.forms[0].from_locn.disabled		= true;
		parent.frames[1].document.forms[0].mobile_no.disabled		= true;
		parent.frames[1].document.forms[0].speciality.disabled		= true;
		parent.frames[1].document.forms[0].tel_no.disabled			= true;
		parent.frames[1].document.forms[0].pager_no.disabled		= true;
		parent.frames[1].document.forms[0].b_pract.disabled			=true;
		
			
		tab_click('refto_tab')
		setTimeout("enableDisableTo()",100);
	}
}

 function enableDisableTo()
{
	parent.frames[1].document.forms[0].to_speciality_code.value = "";
	parent.frames[1].document.forms[0].to_practitioner_id.value = "";
	parent.frames[1].document.forms[0].to_locn.value			= "";
	parent.frames[1].document.forms[0].locationT0.value			= "";
	parent.frames[1].document.forms[0].to_service_code.value	= "";
	parent.frames[1].document.forms[0].priority.value			= "";
	
	parent.frames[1].document.forms[0].referred_for_ip.disabled = false;
	parent.frames[1].document.forms[0].referred_for_ip.value	= "";
	parent.frames[1].document.forms[0].referred_for_ip.disabled = true;
}

//End of added by Sridhar
/*
function popservice(obj)
{
	parent.frames[1].document.forms[0].to_service_code.value =obj;
}
*/

function onBlurCallPractitionerSearch(obj,target_name,caller_id)
{
	if(parent.frames[1].document.forms[0].from_practitioner_id.value==""){
			parent.frames[1].document.forms[0].tel_no.value="";	
			parent.frames[1].document.forms[0].mobile_no.value="";
			parent.frames[1].document.forms[0].pager_no.value="";
	}
//	if(!(target_name.name == "from_practitioner_id" && parent.frames[1].document.forms[0].referral_type.value=='X') )
//	{  Commented for SRR20056-SCF-7848 [IN:028798] by Suresh M on 20.09.2011
		target_name.value = trimString(target_name.value);
	 	if(target_name.value == "")
		{
			 if(obj=="b_pract")
				parent.frames[1].document.forms[0].from_practitioner_id.value="";
			 else
				parent.frames[1].document.forms[0].to_practitioner_id.value="";
			 return;
		}
		callPractSearch(obj,target_name,caller_id);
//	}
}

async function callPractSearch(obj,target,caller_id)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	var locale=document.forms[0].localeth.value
	var facilityid=parent.frames[1].document.forms[0].facilityid.value;
	var locn_type;
	if(parent.frames[1].document.forms[0].location0){ //Added if condition for incident IN023039 by Suresh M on 24.08.2010 
	locn_type=parent.frames[1].document.forms[0].location0.value;
	var u=parent.frames[1].document.forms[0].from_locn.value;
	}
	 
	 
	var open_to_all_pract_yn=parent.frames[1].document.forms[0].open_to_all_pract_yn.value;
	
	var to_from_speciality="";

	target.value=trimString(target.value);
	if(obj.name=="b_pract")
	{
		practName_FName=target.name;
		practName_FValue=target.value;
		//var ref_hcare_arr=parent.frames[1].document.forms[0].referral_source.value.split("~");// commented for crf 508 and below line added
		var ref_hcare_arr=parent.frames[1].document.forms[0].referral_source_lkp_id.value.split("~");
		facilityid		=	ref_hcare_arr[1];

		practId_FName=parent.frames[1].document.forms[0].from_practitioner.name;
		to_from_speciality=parent.frames[1].document.forms[0].speciality.value;
		if(parent.frames[1].document.forms[0].referral_type.value!='X'){
			locn_type=parent.frames[1].document.forms[0].location0.value;
			u=parent.frames[1].document.forms[0].from_locn.value;
			strArray = u.split("$");
			var locn_code=strArray[0];
			var open_to_all_pract_yn=strArray[1];
		}else{
			locn_code="";
			locn_type="";
		}
	}

	if(obj.name=="b_pract1")
	{
		practName_FName=target.name;
		practName_FValue=target.value;
		practId_FName=parent.frames[1].document.forms[0].to_practitioner.name;
		to_from_speciality=parent.frames[1].document.forms[0].to_speciality_code.value;
		locn_type=parent.frames[1].document.forms[0].locationT0.value;
		u=parent.frames[1].document.forms[0].to_locn.value;
		strArray = u.split("$");
		var locn_code=strArray[0];
		var open_to_all_pract_yn=strArray[1];
	}

	var sqlSec="";	



/* Changed the query to fetch all the Practioners assigned to the specialities including Primary specaility
	5/3/2006 - By Vinod	
*/	
	// code added for 20854
/*
		if(parent.frames[1].document.forms[0].referral_type.value!='X'){ 
			strArray = u.split("$");
			var locn_code=strArray[0];
			var open_to_all_pract_yn=strArray[1];
	//	alert(locn_type+" "+open_to_all_pract_yn);
		}
	*/
		if (locn_code!="")
		{
			if (locn_type == "C" || locn_type == "Y" || locn_type == "E" || locn_type == "W")
			{
				if(open_to_all_pract_yn=='Y'){
					sql	="SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner (a.practitioner_id, '"+localeName+"', 1) practitioner_name, am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type, am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',  2) primary_specialty,a.gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE a.facility_id = '"+facilityid+"'   AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type)) AND a.practitioner_id = b.practitioner_id AND b.language_id ='"+localeName+"' AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND (UPPER(b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER (b.practitioner_name) LIKE  UPPER (NVL (?, b.practitioner_name)))   AND DECODE (UPPER(a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE   NVL (UPPER (?),  DECODE (UPPER (a.gender),  'MALE', 'M',  'FEMALE', 'F', 'Unknown', 'U' ))  AND UPPER(NVL (a.position_code, '123')) LIKE  UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";
					sqlSec	="SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner (a.practitioner_id, '"+localeName+"', 1) practitioner_name, am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type, am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',  2) primary_specialty,a.gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE a.facility_id = '"+facilityid+"'   AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type)) AND a.practitioner_id = b.practitioner_id AND b.language_id ='"+localeName+"' AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND ( UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) AND UPPER (b.practitioner_name) LIKE  UPPER (NVL (?, b.practitioner_name)))   AND DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE   NVL (UPPER(?),  DECODE (UPPER(a.gender),  'MALE', 'M',  'FEMALE', 'F', 'Unknown', 'U' ))  AND UPPER (NVL (a.position_code, '123')) LIKE  UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";	
				}else{
					sql = "SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner (a.practitioner_id,  '"+localeName+"', 1)  practitioner_name, am_get_desc.am_pract_type (a.pract_type,'"+localeName+"',2) practitioner_type,a.specialty_code, am_get_desc.am_speciality(a.primary_speciality_code,'"+localeName+"', 2) primary_specialty, a.gender, a.position_code job_title FROM am_pract_all_splty_vw a, am_practitioner_lang_vw b , op_pract_for_clinic c,op_clinic d  WHERE c.facility_id = '"+facilityid+"' AND c.clinic_code =nvl ('"+locn_code+"',c.clinic_code) AND c.facility_id = d.facility_id and c.clinic_code = d.clinic_code  AND a.practitioner_id = c.practitioner_id AND a.pract_type LIKE (?) AND a.facility_id = '"+facilityid+"' AND a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"' and c.eff_status = 'E' AND a.primary_speciality_code LIKE UPPER (NVL (replace(?,'%',''),b.primary_speciality_code)) AND ((UPPER(b.practitioner_id)) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER(b.practitioner_name)  LIKE UPPER (NVL (?, b.practitioner_name))) AND  DECODE (UPPER (a.gender), 'MALE','M', 'FEMALE', 'F', 'Unknown', 'U') LIKE  NVL (UPPER (?),DECODE (UPPER (a.gender),'MALE', 'M', 'FEMALE', 'F','Unknown', 'U')) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123')))  order by 2";
					sqlSec = "SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner (a.practitioner_id,  '"+localeName+"', 1)  practitioner_name, am_get_desc.am_pract_type (a.pract_type,'"+localeName+"',2) practitioner_type,a.specialty_code, am_get_desc.am_speciality(a.primary_speciality_code,'"+localeName+"', 2) primary_specialty, a.gender, a.position_code job_title FROM am_pract_all_splty_vw a, am_practitioner_lang_vw b , op_pract_for_clinic c,op_clinic d  WHERE c.facility_id = '"+facilityid+"' AND c.clinic_code =nvl('"+locn_code+"',c.clinic_code) AND c.facility_id = d.facility_id and c.clinic_code = d.clinic_code AND   a.practitioner_id = c.practitioner_id AND a.pract_type LIKE (?) AND a.facility_id = '"+facilityid+"' AND a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"' and c.eff_status = 'E' AND a.primary_speciality_code LIKE UPPER (NVL (replace(?,'%',''),b.primary_speciality_code)) AND ((UPPER(b.practitioner_id)) LIKE UPPER (NVL (?, b.practitioner_id)) AND UPPER(b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND DECODE (UPPER (a.gender), 'MALE','M', 'FEMALE', 'F', 'Unknown', 'U') LIKE  NVL (UPPER (?),DECODE (UPPER (a.gender),'MALE', 'M', 'FEMALE', 'F','Unknown', 'U')) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123')))  order by 2"; 				
				} 			   
			}
			else if(locn_type == "N")
			{
               sql	 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_practitioner (a.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type (a.pract_type, '"+localeName+"', 2) practitioner_type,  am_get_desc.am_speciality (a.primary_speciality_code,'"+localeName+"',2) primary_specialty, a.gender, a.position_code job_title  FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b  WHERE a.facility_id = '"+facilityid+"' AND a.practitioner_id IN (SELECT practitioner_id FROM ip_nursing_unit_for_pract  WHERE facility_id = '"+facilityid+"'  AND nursing_unit_code = '"+locn_code+"') AND a.practitioner_id = b.practitioner_id  AND b.language_id = '"+localeName+"'  AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type)) AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND (UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE    NVL (UPPER (?),DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F',  'Unknown', 'U' ))  AND UPPER (NVL (a.position_code, '123')) LIKE  UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";
			   sqlSec	 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_practitioner (a.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type (a.pract_type, '"+localeName+"', 2) practitioner_type,  am_get_desc.am_speciality (a.primary_speciality_code,'"+localeName+"',2) primary_specialty, a.gender, a.position_code job_title  FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b  WHERE a.facility_id = '"+facilityid+"' AND a.practitioner_id IN (SELECT practitioner_id FROM ip_nursing_unit_for_pract  WHERE facility_id = '"+facilityid+"'  AND nursing_unit_code = '"+locn_code+"') AND a.practitioner_id = b.practitioner_id  AND b.language_id = '"+localeName+"'  AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type)) AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND (UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) AND UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE    NVL (UPPER (?),DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F',  'Unknown', 'U' ))  AND UPPER (NVL (a.position_code, '123')) LIKE  UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2"; 				
			}
		}else if(locn_code == ""){	
			if(parent.frames[1].document.forms[0].referral_type.value!='X'){
				if(locn_type == "N"){	
					sql	 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_practitioner (a.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type,am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',2) primary_specialty,a.gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b  WHERE a.facility_id = '"+facilityid+"' AND  a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"'  AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type))  AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code)) AND ( UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id))  OR UPPER (b.practitioner_name) LIKE  UPPER (NVL (?, b.practitioner_name)))  AND DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE   NVL (UPPER (?),DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U')) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";	
					sqlSec	 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_practitioner (a.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type,am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',2) primary_specialty,a.gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b  WHERE a.facility_id = '"+facilityid+"' AND  a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"'  AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type))  AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code)) AND ( UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id))  AND UPPER (b.practitioner_name) LIKE  UPPER (NVL (?, b.practitioner_name)))  AND DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE   NVL (UPPER (?),DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U')) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";		
				}else{ 
					sql	="SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner (a.practitioner_id, '"+localeName+"', 1) practitioner_name, am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type, am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',  2) primary_specialty,a.gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE a.facility_id = '"+facilityid+"'   AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type)) AND a.practitioner_id = b.practitioner_id AND b.language_id ='"+localeName+"' AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND (UPPER(b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER (b.practitioner_name) LIKE  UPPER (NVL (?, b.practitioner_name)))   AND DECODE (UPPER(a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE   NVL (UPPER (?),  DECODE (UPPER (a.gender),  'MALE', 'M',  'FEMALE', 'F', 'Unknown', 'U' ))  AND UPPER(NVL (a.position_code, '123')) LIKE  UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";
					sqlSec	="SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner (a.practitioner_id, '"+localeName+"', 1) practitioner_name, am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type, am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',  2) primary_specialty,a.gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE a.facility_id = '"+facilityid+"'   AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type)) AND a.practitioner_id = b.practitioner_id AND b.language_id ='"+localeName+"' AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND ( UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) AND UPPER (b.practitioner_name) LIKE  UPPER (NVL (?, b.practitioner_name)))   AND DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE   NVL (UPPER(?),  DECODE (UPPER(a.gender),  'MALE', 'M',  'FEMALE', 'F', 'Unknown', 'U' ))  AND UPPER (NVL (a.position_code, '123')) LIKE  UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";
				}
			}else{					
					if(obj.name=="b_pract"){ 			
						/*sql	 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_ext_practitioner (a.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type,am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',2) primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_ext_practitioner_lang_vw  a,AM_EXT_PRACT_FOR_REFERRAL b, AM_REFERRAL c  WHERE b.REFERRAL_CODE=c.REFERRAL_CODE and c.REFERRAL_CODE='"+facilityid+"' and b.eff_status='E' AND  a.practitioner_id = b.practitioner_id AND a.language_id = '"+localeName+"'  AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type))  AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), a.primary_speciality_code)) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id))  OR UPPER (a.practitioner_name) LIKE  UPPER (NVL (?, a.practitioner_name)))  AND  a.gender LIKE   NVL (DECODE (UPPER (?), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U'),a.gender) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";	*//*Commented By Rameswar Against AMRI-SCF-0390 On 1st Sept 2015*/
						
						sql	 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_ext_practitioner (a.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type,am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',2) primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_ext_practitioner_lang_vw  a,AM_EXT_PRACT_FOR_REFERRAL b, AM_REFERRAL c  WHERE b.REFERRAL_CODE=c.REFERRAL_CODE and c.REFERRAL_CODE='"+facilityid+"' and b.eff_status='E' AND  a.practitioner_id = b.practitioner_id AND a.language_id = '"+localeName+"'  AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type))  AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), a.primary_speciality_code)) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id))  OR UPPER (a.practitioner_name) LIKE  UPPER (NVL (?, a.practitioner_name)))  AND  a.gender LIKE   NVL (DECODE (UPPER (?), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U'),a.gender) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";	/*Modified By Rameswar Against AMRI-SCF-0390 On 1st Sept 2015*/
						

						sqlSec	 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_ext_practitioner (a.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type,am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',2) primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_ext_practitioner_lang_vw  a,AM_EXT_PRACT_FOR_REFERRAL b, AM_REFERRAL c  WHERE b.REFERRAL_CODE=c.REFERRAL_CODE and c.REFERRAL_CODE='"+facilityid+"' and b.eff_status='E' AND  a.practitioner_id = b.practitioner_id AND a.language_id = '"+localeName+"'  AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type))  AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), a.primary_speciality_code)) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id))  AND UPPER (a.practitioner_name) LIKE  UPPER (NVL (?, a.practitioner_name)))  AND  a.gender LIKE   NVL (DECODE (UPPER (?), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U'),a.gender) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";	/*Added By Rameswar Against AMRI-SCF-0390 On 2nd Sept 2015*/

						//sqlSec	 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_practitioner (a.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type,am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',2) primary_specialty,a.gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_ext_practitioner_lang_vw  b  WHERE a.facility_id = '"+facilityid+"' AND  a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"'  AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type))  AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code)) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id))  AND UPPER (a.practitioner_name) LIKE  UPPER (NVL (?, a.practitioner_name)))  AND DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE   NVL (UPPER (?),DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U')) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";	
						//sqlSec=sql;//Commented By Rameswar Against AMRI-SCF-0390 On 2nd Sept 2015
					}else{ 
						sql	="SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner (a.practitioner_id, '"+localeName+"', 1) practitioner_name, am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type, am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',  2) primary_specialty,a.gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE a.facility_id = '"+facilityid+"'   AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type)) AND a.practitioner_id = b.practitioner_id AND b.language_id ='"+localeName+"' AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND (UPPER(b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER (b.practitioner_name) LIKE  UPPER (NVL (?, b.practitioner_name)))   AND DECODE (UPPER(a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE   NVL (UPPER (?),  DECODE (UPPER (a.gender),  'MALE', 'M',  'FEMALE', 'F', 'Unknown', 'U' ))  AND UPPER(NVL (a.position_code, '123')) LIKE  UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";
						sqlSec	="SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner (a.practitioner_id, '"+localeName+"', 1) practitioner_name, am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type, am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',  2) primary_specialty,a.gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE a.facility_id = '"+facilityid+"'   AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type)) AND a.practitioner_id = b.practitioner_id AND b.language_id ='"+localeName+"' AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND ( UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) AND UPPER (b.practitioner_name) LIKE  UPPER (NVL (?, b.practitioner_name)))   AND DECODE (UPPER (a.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U') LIKE   NVL (UPPER(?),  DECODE (UPPER(a.gender),  'MALE', 'M',  'FEMALE', 'F', 'Unknown', 'U' ))  AND UPPER (NVL (a.position_code, '123')) LIKE  UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";
					}
			}
		}


				
/*
* if you are passing User Defined SQL and in that if you want to pass any of the folowing in where criteria  :-
*	1.  practioner type
*   2. Speciality /Clinic code
*   3. Job Title
*   4. Gender
*
* then you must pass them in the query string below with folowing names
*	1.  practioner type         ----->practitioner_type
*   2. Speciality /Clinic code  ----->specialty_code
*   3. Job Title				----->job_title
*   4. Gender					----->gender
*
*
*///practName_FName
	//encodeURIComponent(practName_FValue)
	//alert('regpatreferral1'+caller_id);
var xmlDoc		= "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName+ "\"";
	xmlStr += " practName_FValue=\"" +encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sqlSec)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +to_from_speciality+ "\"";
	xmlStr += " caller_id=\"" +caller_id+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	//eval(responseText);	
	//return;
	eval(await practSearch(practName_FName,encodeURIComponent(practName_FValue),to_from_speciality,responseText));
}

async function practSearch(practName_FName,practName_FValue,to_from_speciality,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "450px" ;
	var dialogWidth	= "700px" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+to_from_speciality+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}

function PractLookupRetVal(retVal,objName)
{

	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");

		if(objName=='from_practitioner_id')
		{
			//	if(parent.frames[1].document.forms[0].referral_type.value!='X'){ //MAy 05

				parent.frames[1].document.forms[0].from_practitioner.value=arr[0];
				parent.frames[1].document.forms[0].from_practitioner_id.value=arr[1];	
		//	}
				//parent.frames[1].document.forms[0].tel_no.value=arr[2];	
				//parent.frames[1].document.forms[0].mobile_no.value=arr[3];	
				//parent.frames[1].document.forms[0].pager_no.value=arr[4];

			if(parent.frames[1].document.forms[0].referral_type.value=='X'){
				if(objName.value !=''){
					parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=true;
					parent.frames[1].document.forms[0].from_ext_practitioner_id.value="";
				}else{
					parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=false;
					parent.frames[1].document.forms[0].from_ext_practitioner_id.value="";
				}		
			}
			var HTMLVal = new String();
			HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/RegPatReferralValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='1024'><input type='hidden' name='practitioner' id='practitioner' value='"+arr[0]+"'><input type='hidden' name='referral_type' id='referral_type' value='"+parent.frames[1].document.forms[0].referral_type.value+"'></form></BODY></HTML>";
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.document.form1.submit();			
			// Below Condition Newly Added Against Incident : ML-BRU-SCF-1200 [IN:045701] By Saanthaakumar
			setTimeout('callSamepage()',100)
			
		
		}		// do intermediate and query the data.
		
		if(objName=='to_practitioner_id'){		
			parent.frames[1].document.forms[0].to_practitioner.value=arr[0];
			parent.frames[1].document.forms[0].to_practitioner_id.value=arr[1];			
		}
	}else
	{
		if(objName=='from_practitioner_id' )
		{
			parent.frames[1].document.forms[0].from_practitioner.value="";
			parent.frames[1].document.forms[0].from_practitioner_id.value="";			
			parent.frames[1].document.forms[0].tel_no.value="";	
			parent.frames[1].document.forms[0].mobile_no.value="";	
			parent.frames[1].document.forms[0].pager_no.value="";
		}

		if(objName=='to_practitioner_id')
		{
			parent.frames[1].document.forms[0].to_practitioner.value="";
			parent.frames[1].document.forms[0].to_practitioner_id.value="";			
		}
	}
}
// Below Condition Newly Added Against Incident : ML-BRU-SCF-1200 [IN:045701] By Saanthaakumar
function callSamepage() 
{   
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		
         } //End Here

function checkMaxLenDtls(obj,name)
{
	if (obj.value.length >200 && obj.readOnly==false)
	{
		var error = getMessage("REMARKS_CANNOT_EXCEED","Common");
		error = error.replace("$",name);
		error = error.replace("#","200");
		alert(error);
		obj.focus();
	}
}

function close_meDtls()
{
    window.close();
    var concat_vals= escape(document.forms[0].exm_clinical_find.value)+"&"+escape(document.forms[0].diagnosis.value)+"&"+escape(document.forms[0].treatment.value);
	window.returnValue =concat_vals;
}

function populateClinicaldetails()
{	
	var concat_vals=parent.document.getElementById('dialog-body').contentWindow.dialogArguments;	
	if(concat_vals == null || concat_vals =='null') concat_vals='';
	
	var arr_concat_vals=concat_vals.split("&");
	var exm_clinical_find=unescape(arr_concat_vals[0]);
	var diagnosis=unescape(arr_concat_vals[1]);
	var treatment=unescape(arr_concat_vals[2]);
	if(arr_concat_vals[0])
	document.forms[0].exm_clinical_find.value=exm_clinical_find;
	if(arr_concat_vals[1])
	document.forms[0].diagnosis.value=diagnosis;
	if(arr_concat_vals[2])
	document.forms[0].treatment.value=treatment;
}

function checkMaxLen(obj)
{
	if (obj.value.length>1500)
	{
		var error = getMessage("REMARKS_CANNOT_EXCEED","Common");
		error = error.replace("$",getLabel("eMP.ReferralNotes.label","MP"));
		error = error.replace("#","1500");
		alert(error)
		obj.focus();
	}
}



function disable_onload()
{
	if( parent.frames[1].document.getElementById('operation_type') != null && parent.frames[1].document.getElementById('operation_type').value!="modify")
	{
		parent.frames[1].document.getElementById('hcare_type').disabled=true;		
	}

	if(parent.frames[1].document.forms[0].referral_type.value=='X')
	{
		parent.frames[1].document.forms[0].tel_no.readOnly=false;
		parent.frames[1].document.forms[0].mobile_no.readOnly=false;
		parent.frames[1].document.forms[0].pager_no.readOnly=false;
	}
	else
	{

		parent.frames[1].document.forms[0].tel_no.readOnly=true;
		parent.frames[1].document.forms[0].mobile_no.readOnly=true;
		parent.frames[1].document.forms[0].pager_no.readOnly=true;
	}
}

function SecondframesValidation(referred_for_ip,referral_priority,to_service_code,referral_date,referral_letter_no,received_date,preferred_treatment_date,from_speciality_code,referral_reason_code,from_ref_type,pract_res_tel_num,pract_mobile_num,pract_pager_num,from_pract_name,from_locn_desc,from_ref_code,from_pract_name1,from_pract_id,from_fcy_id,from_locn_type,mode,referral_id,patientid,from_hcare_setting_type,to_pract_name,to_pract_id)
{	
	var locn = parent.frames[1].document.forms[0].locationT0.value;

	/*
	var exam_and_clin_findings = decodeURIComponent(exam_and_clin_findings,'UTF-8');
	var diagnosisTab = decodeURIComponent(diagnosisTab,'UTF-8');
	var treatmentTab = decodeURIComponent(treatmentTab,'UTF-8');    
	*/  
	

	if(locn == 'N')
	{
		if(parent.frames[1].document.forms[0].referred_for_ip)
		{
			parent.frames[1].document.forms[0].referred_for_ip.disabled=false;
			parent.frames[1].document.forms[0].referred_for_ip.value = referred_for_ip;
			parent.frames[1].document.forms[0].referred_for_ip.disabled=true;
		}
	}
	else
	{
		if(parent.frames[1].document.forms[0].referred_for_ip)
		{
			parent.frames[1].document.forms[0].referred_for_ip.disabled=true;
		}
	}

	if (parent.frames[1].document.forms[0].priority)
	parent.frames[1].document.forms[0].priority.value =referral_priority;

	if (parent.frames[1].document.forms[0].to_service_code)
	parent.frames[1].document.forms[0].to_service_code.value = to_service_code;

	
	if (parent.frames[1].document.forms[0].referral_date)
	parent.frames[1].document.forms[0].referral_date.value =referral_date;

	if (parent.frames[1].document.forms[0].ref_letter_no)
	parent.frames[1].document.forms[0].ref_letter_no.value =referral_letter_no;

	if (parent.frames[1].document.forms[0].received_date)
	parent.frames[1].document.forms[0].received_date.value =received_date;

	if (parent.frames[1].document.forms[0].preferred_date)
	parent.frames[1].document.forms[0].preferred_date.value =preferred_treatment_date;

	/*
	if (parent.frames[1].document.forms[0].treatment!=null)
	parent.frames[1].document.forms[0].treatment.value =treatmentTab;

	if (parent.frames[1].document.forms[0].diagnosis!=null)
	parent.frames[1].document.forms[0].diagnosis.value =diagnosisTab;	

	if (parent.frames[1].document.forms[0].exm_clinical_find!=null)
	parent.frames[1].document.forms[0].exm_clinical_find.value =exam_and_clin_findings;

	if (parent.frames[1].document.forms[0].other_doc_att)
	parent.frames[1].document.forms[0].other_doc_att.value =other_doc_att;

	*/

	parent.frames[1].document.forms[0].speciality.value	 = from_speciality_code;

	parent.frames[1].document.forms[0].referral_reason_code.value = referral_reason_code;

	if(from_ref_type=="X")
	{
		if (parent.frames[1].document.forms[0].tel_no)
		parent.frames[1].document.forms[0].tel_no.value =pract_res_tel_num;

		if (parent.frames[1].document.forms[0].mobile_no)
		parent.frames[1].document.forms[0].mobile_no.value =pract_mobile_num;

		if (parent.frames[1].document.forms[0].pager_no)
		parent.frames[1].document.forms[0].pager_no.value =pract_pager_num;

		parent.frames[1].document.forms[0].tel_no.readOnly=false;
		parent.frames[1].document.forms[0].mobile_no.readOnly=false;
		parent.frames[1].document.forms[0].pager_no.readOnly=false;

	}
	else
	{	
		if (parent.frames[1].document.forms[0].tel_no)
		parent.frames[1].document.forms[0].tel_no.value =pract_res_tel_num;

		if (parent.frames[1].document.forms[0].mobile_no)
		parent.frames[1].document.forms[0].mobile_no.value=pract_mobile_num;

		if (parent.frames[1].document.forms[0].pager_no)
		parent.frames[1].document.forms[0].pager_no.value =pract_pager_num;

		parent.frames[1].document.forms[0].tel_no.readOnly=true;
		parent.frames[1].document.forms[0].mobile_no.readOnly=true;
		parent.frames[1].document.forms[0].pager_no.readOnly=true;
	}

	var from_ref_type = from_ref_type;
	parent.frames[1].document.forms[0].b_pract1.disabled=false;

	if (from_ref_type=="X")
	{
		//parent.frames[1].document.forms[0].from_practitioner_id.value =from_pract_name;
		parent.frames[1].document.forms[0].from_ext_practitioner_id.value =from_pract_name;


		if(parent.frames[1].document.forms[0].from_ext_practitioner_id.value!=''){
		parent.frames[1].document.forms[0].from_practitioner_id.disabled=true;
		parent.frames[1].document.getElementById('b_pract').disabled=true;	
		parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=false;

		}

		//
		parent.frames[1].document.forms[0].from_locn.value =from_locn_desc;
		parent.frames[1].document.forms[0].referral_type.value =from_ref_type;
		parent.frames[1].document.forms[0].referral_source1.value =from_ref_code;

		
		//parent.frames[1].document.getElementById("b_pract").style.visibility='hidden';

      //

		parent.frames[1].document.forms[0].pract_ext_name.style.display='inline';
		parent.frames[1].document.forms[0].from_practitioner_id.value =from_pract_name1;			
		parent.frames[1].document.forms[0].from_practitioner.value =from_pract_id;	

		if(parent.frames[1].document.forms[0].from_practitioner_id.value!='') {

			parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=true;
			parent.frames[1].document.forms[0].from_practitioner_id.disabled=false;
		    parent.frames[1].document.getElementById('b_pract').disabled=false;	
		}


	}
	else
	{
	

		parent.frames[1].document.forms[0].b_pract.disabled=false;
		parent.frames[1].document.forms[0].from_practitioner_id.value =from_pract_name1;			
		parent.frames[1].document.forms[0].from_practitioner.value =from_pract_id;			
	
		parent.frames[1].document.forms[0].referral_source1.value =from_fcy_id;
		parent.frames[1].document.getElementById("b_pract").style.visibility='visible';
	
		if (from_fcy_id ==parent.frames[1].document.forms[0].facilityid.value)
			parent.frames[1].document.forms[0].referral_type.value ="L";
		else
			parent.frames[1].document.forms[0].referral_type.value =from_ref_type;
		
		parent.frames[1].document.forms[0].location0.value =from_locn_type;

	}

	disable_onload();
	parent.frames[1].document.forms[0].operation_type.value =mode;
	parent.frames[1].document.forms[0].referral_id.value =referral_id;
	parent.frames[1].document.forms[0].pat_id.value =patientid;

	parent.frames[1].document.forms[0].from_hcare_setting_type.value =from_hcare_setting_type;
	parent.frames[1].document.forms[0].to_practitioner_id.value =to_pract_name;		
	parent.frames[1].document.forms[0].to_practitioner.value =to_pract_id;	
	parent.frames[1].document.forms[0].to_pract1.value =to_pract_id;

	if(from_ref_type=="X" )
	{

		parent.frames[1].document.forms[0].hcare_type.value =from_hcare_setting_type;
		parent.frames[1].document.forms[0].from_hcare_setting_type.value=from_hcare_setting_type;	
		//parent.frames[1].document.forms[0].referral_source.value =from_hcare_setting_type+"~"+from_ref_code;	// commencted of rcrf 508 & below line added
		parent.frames[1].document.forms[0].referral_source_lkp_id.value =from_hcare_setting_type+"~"+from_ref_code;	
	}

	if(from_ref_type=="E")
	{
		parent.frames[1].document.forms[0].hcare_type.value =from_hcare_setting_type;	
		parent.frames[1].document.forms[0].from_hcare_setting_type.value=from_hcare_setting_type;
		//parent.frames[1].document.forms[0].referral_source.value =from_hcare_setting_type+"~"+from_fcy_id;	// commencted of rcrf 508 & below line 
		parent.frames[1].document.forms[0].referral_source_lkp_id.value =from_hcare_setting_type+"~"+from_fcy_id;	
	}

	if(from_ref_type=="L")
	{
		parent.frames[1].document.forms[0].hcare_type.value =from_hcare_setting_type;	
		parent.frames[1].document.forms[0].from_hcare_setting_type.value=from_hcare_setting_type;
		parent.frames[1].document.forms[0].hcare_type.disabled =true;
		parent.frames[1].document.forms[0].referral_source.disabled=true;
		parent.frames[1].document.forms[0].referral_source_lkp_but.disabled=true;
	}
	
}

function close_me()
{
	window.close();
	window.returnValue = parent.frames[0].document.forms[0].referral_notes.value;

}

function disablefields_callingfrom()
{
	if(document.forms[0].calling_from.value =="View_Referral" || document.forms[0].mode.value == "RegisterMoreReferral")
	{	
		if(document.forms[0].treatment)
		document.forms[0].treatment.readOnly=true;

		if(document.forms[0].diagnosis)
		document.forms[0].diagnosis.readOnly=true;

		if(document.forms[0].exm_clinical_find)
		document.forms[0].exm_clinical_find.readOnly=true;
	}
}

function close_meNotes()
{  	
	if(document.forms[0].ref_comp.value == "reg_pat")
	{
	
   		window.returnValue = escape(document.forms[0].other_doc_att.value) + "|"+escape(document.forms[0].referral_notes.value);
	}
	else
	{
		window.returnValue = escape(document.forms[0].referral_notes.value);
	}
	window.close();
}

function populateRemarks()
{

	var valarr;
	//var text=parent.window.dialogArguments;
	var text=parent.document.getElementById('dialog-body').contentWindow.dialogArguments;
	
	if(text == null || text =='null') text='';
	if(document.forms[0].ref_comp.value == "reg_pat")
	{
		if(text.indexOf("|") >-1)
		{
			vararr=text.split("|");
			document.forms[0].other_doc_att.value=unescape(vararr[0]);
			document.forms[0].referral_notes.value=unescape(vararr[1]);
		}			
	}
	else
	{
		document.forms[0].referral_notes.value=unescape(text);
	}	
}

function checkMaxLenNotes(obj)
{	
	if(obj.name=='other_doc_att')
	{
		if(obj.value.length>200&&obj.readOnly==false)
		{
			var error=getMessage("REMARKS_CANNOT_EXCEED","Common");
			
			error=error.replace("$",getLabel("eMP.OtherDocAttached.label",'MP'));
			error=error.replace("#","200");
			alert(error);
			obj.focus();
		}
	}
	else if(obj.name=='referral_notes')
	{ 
		if (obj.value.length>1500&&obj.readOnly==false)
		{
			var error = getMessage("REMARKS_CANNOT_EXCEED","Common");
			error = error.replace("$",getLabel("eMP.ReferralNotes.label","MP"));
			error = error.replace("#","1500");
			alert(error)
			obj.focus();
		}
	}
}

async function ref_note()
{
	var notes = document.forms[0].referral_notes.value;
	
	var dialogHeight= "29vh" ;
	var dialogWidth = "43vw" ;                    
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
	var arguments	= document.forms[0].referral_notes.value;
	var temp=notes;
	var arr =new Array();
	arr=temp.split('\n');
	for(u=0;u<arr.length;u++)
	arr[u]=arr[u]+"`";
	var retVal = await window.showModalDialog("../../eMP/jsp/Referral_Notes.jsp?from=search&ref_comp=viewpat",arguments,features);
}


function CheckForSpecChars1(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
function CheckForSpecChars2(event){
    var strCheck = '&<}{[])"\'(';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return false ;
}

