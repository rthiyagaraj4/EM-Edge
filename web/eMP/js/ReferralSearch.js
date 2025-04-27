// Developed By :- M.F.Mohamed Ali Suhail

var flag="N";

function reset()
{
   f_query_add_mod_main.location.reload() ;
}
async function RefCallPatientSearch()
{
	var patientid = await PatientSearch('','','','','','','','','','PAT_REG');
	if(patientid !=null)
	{
		parent.f_query_add_mod.document.getElementById("patient_id").value = patientid;
		parent.f_query_add_mod.document.getElementById("patient_id").focus();
	}
}

function ClearSearch(call)
 {
   document.forms[0].search.disabled = false ;
   if(document.forms[0].patient_id.disabled ==false)
	 {
	document.forms[0].patient_id.value="";
	}
document.forms[0].referral_id.value="";
document.forms[0].priority.value="";

//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
var isImproveReferralProcessAppl = document.forms[0].isImproveReferralProcessAppl.value;
var current_from_date = document.forms[0].current_from_date.value;
var current_to_date = document.forms[0].current_to_date.value;

if(isImproveReferralProcessAppl == "true")
{
	document.forms[0].created_frm_date.value=current_from_date;
	document.forms[0].created_to_date.value=current_to_date;
	document.forms[0].pref_frm_date.value="";
	document.forms[0].pref_to_date.value="";
}

if(document.forms[0].first_name)
document.forms[0].first_name.value="";
if(document.forms[0].family_name)
document.forms[0].family_name.value="";

if(document.forms[0].second_name)
document.forms[0].second_name.value="";
if(document.forms[0].name_prefix)
document.forms[0].name_prefix.value="";
if(document.forms[0].name_suffix)
document.forms[0].name_suffix.value="";

if(document.forms[0].third_name)
	document.forms[0].third_name.value="";

if(document.forms[0].national_id_no)
	 document.forms[0].national_id_no.value="";
if(document.forms[0].alt_id1_no)
	 document.forms[0].alt_id1_no.value="";
if(document.forms[0].alt_id2_no)
  document.forms[0].alt_id2_no.value="";
 if(document.forms[0].alt_id3_no)
	document.forms[0].alt_id3_no.value="";
if(document.forms[0].alt_id4_no)
   document.forms[0].alt_id4_no.value="";
if(document.forms[0].other_alt_type)
  document.forms[0].other_alt_type.value="";
if(document.forms[0].other_alt_Id)
  document.forms[0].other_alt_Id.value="";	

document.forms[0].source_type.value="";
document.forms[0].fm_speciality_code.value="";
document.forms[0].fm_service_code.value="";
document.forms[0].referred_from_location_type.value="";
document.forms[0].referred_from_location.value="";
document.forms[0].referred_from_practitioner_name.value="";
document.forms[0].fm_service_desc.value="";
document.forms[0].to_service_desc.value="";
if(document.forms[0].source_type.value==""){
	document.forms[0].fm_service_desc.disabled = true ;
	document.forms[0].search_service.disabled = true ;
}

document.forms[0].source.value="";
if(document.forms[0].to_speciality_code.disabled==false)
   document.forms[0].to_speciality_code.value="";
document.forms[0].to_service_code.value="";
if(document.forms[0].referred_to_location_type.disabled==false)
document.forms[0].referred_to_location_type.value="";

if(document.forms[0].referred_to_location.disabled==false)
  document.forms[0].referred_to_location.value="";

document.forms[0].referred_to_practitioner_name.value=""; 

document.forms[0].source_display.value=""; 
if(document.forms[0].source_display.disabled==true)
	document.forms[0].source_display.disabled=false;
if(document.forms[0].referral_source_lkp_but.disabled==true)
	document.forms[0].referral_source_lkp_but.disabled=false;
if(document.forms[0].status)
	document.forms[0].status.value = "";

//Code added by Tushar .T. Bhat on 05-Mar-04

resetList(document.forms[0].referred_from_location);
resetList(document.forms[0].source);
resetList(document.forms[0].fm_service_code);
if(document.forms[0].referred_to_location.disabled==false)
 resetList(document.forms[0].referred_to_location);

//Code added by Tushar .T. Bhat on 05-Mar-04 ends	
//document.forms[0].referred_from_location.setFocus();
	
	parent.frames[1].document.location.href="../../eCommon/html/blank.html";
	
    
 }

 //Code added by Tushar .T. Bhat on 05-Mar-04

 function resetList(object)
 {
	 if(!object)
		 return;
	 
	 var length = object.length;

	 for(var i = 1;i<length;i++)
		 object.remove[1];

 }

 //Code added by Tushar .T. Bhat on 05-Mar-04 ends

function closeWind(call_function)
{
	 parent.window.close();
}



function searching()
{	
	//Added by santhosh for MMS-DM-CRF-0209.4
	var ass_func_id=document.forms[0].ass_func_id.value;
	if(ass_func_id=="REFERAL_REQUIRED"){
		document.forms[0].to_service_desc.onblur();
	}
	//END
	p_calling_function	= document.forms[0].p_calling_function.value;
	calledFrom	= document.forms[0].calledFrom.value;
	p_select			= document.forms[0].p_select.value;
	p_reg_patient		= document.forms[0].p_reg_patient.value;

	//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	var isImproveReferralProcessAppl = document.forms[0].isImproveReferralProcessAppl.value;
	var created_frm_date = "";
	var created_to_date = "";
	var pref_frm_date = "";
	var pref_to_date = "";
	var proceed_yn = "Y";

	if(isImproveReferralProcessAppl == "true")
	{
		created_frm_date = document.forms[0].created_frm_date.value;
		created_to_date = document.forms[0].created_to_date.value;
		pref_frm_date = document.forms[0].pref_frm_date.value;
		pref_to_date = document.forms[0].pref_to_date.value;

		if(created_frm_date != "" && created_to_date == ""){
			var invaldt = getMessage("CAN_NOT_BE_BLANK",'Common');
			var created_to_date = getLabel("Common.createddate.label","Common")+" "+getLabel("Common.to.label","Common");
			invaldt = invaldt.replace('$',created_to_date);
			alert(invaldt);
			document.forms[0].created_to_date.focus();
			proceed_yn = "N";
		}else if(created_frm_date == "" && created_to_date != ""){
			var invaldt = getMessage("CAN_NOT_BE_BLANK",'Common');
			var created_frm_date = getLabel("Common.createddate.label","Common")+" "+getLabel("Common.from.label","Common");
			invaldt = invaldt.replace('$',created_frm_date);
			alert(invaldt);
			document.forms[0].created_frm_date.focus();
			proceed_yn = "N";
		}else if(pref_frm_date != "" && pref_to_date == ""){
			var invaldt = getMessage("CAN_NOT_BE_BLANK",'Common');
			var pref_to_date = getLabel("Common.PreferredDate.label","Common")+" "+getLabel("Common.to.label","Common");
			invaldt = invaldt.replace('$',pref_to_date);
			alert(invaldt);
			document.forms[0].pref_to_date.focus();
			proceed_yn = "N";
		}else if(pref_frm_date == "" && pref_to_date != ""){
			var invaldt = getMessage("CAN_NOT_BE_BLANK",'Common');
			var pref_frm_date = getLabel("Common.PreferredDate.label","Common")+" "+getLabel("Common.from.label","Common");
			invaldt = invaldt.replace('$',pref_frm_date);
			alert(invaldt);
			document.forms[0].pref_frm_date.focus();
			proceed_yn = "N";
		}
	}
	
	if(flag == "Y")
	{
		if(p_calling_function == "INDEPENDENT" || p_calling_function =="REPRINT_REF_LETTER" )  {
			 //parent.refsearch.rows="75%,25%,0%";
		parent.document.getElementById("f_query_add_mod").style.height="45vh";
		parent.document.getElementById("f_query_add_mod_result").style.height="53vh";
		parent.document.getElementById("validation_frame").style.height="0vh"; }
		else {
			 //parent.refsearch.rows="75%,25%,0%";
		parent.document.getElementById("f_query_add_mod").style.height="70vh";
		parent.document.getElementById("f_query_add_mod_result").style.height="25vh";
		parent.document.getElementById("validation_frame").style.height="0vh";
		}
	}else
	{
		//parent.refsearch.rows="48%,50%,0%";//modified by N Munisekhar for[IN:048929] 
		parent.document.getElementById("f_query_add_mod").style.height="45vh";
		parent.document.getElementById("f_query_add_mod_result").style.height="53vh";
		parent.document.getElementById("validation_frame").style.height="0vh";
	} 	
	
	if(p_calling_function=='OA_BOOK_APPT' || p_calling_function=="OA_MODIFY_APPT") {
			p_to_locn_type		=  document.forms[0].referred_to_location_type.value;

	}else{
			p_to_locn_type		=  document.forms[0].p_to_locn_type.value;

	}
	p_to_locn_code		=  document.forms[0].p_to_locn_code.value;

	//var ass_func_id=document.forms[0].ass_func_id.value;
    
	var p_res_class = document.forms[0].p_res_class.value;

	patient_id			= document.forms[0].patient_id.value;
    if(document.forms[0].first_name)
		first_name		= document.forms[0].first_name.value;
	else
		first_name		=  "";
    if(document.forms[0].second_name)
		second_name		= document.forms[0].second_name.value;
	else
		second_name		= "";
    if(document.forms[0].third_name)
		third_name		= document.forms[0].third_name.value;
	else
		third_name		= "";
	if(document.forms[0].family_name)
		family_name		= document.forms[0].family_name.value;
	else
		family_name	= "";	
	if(document.forms[0].name_prefix)
		name_prefix		= document.forms[0].name_prefix.value;
	else
		name_prefix		= "";
   if(document.forms[0].name_suffix)
	 	name_suffix		= document.forms[0].name_suffix.value;
     else
		name_suffix = "";
   
   if(document.forms[0].national_id_no)
	   nric_no =document.forms[0].national_id_no.value;
     else
	   nric_no="";

	if(document.forms[0].alt_id1_no)
	  pmi_no =escape(document.forms[0].alt_id1_no.value);
     else
	   pmi_no="";

	 if(document.forms[0].alt_id2_no)
	   passport_no =escape(document.forms[0].alt_id2_no.value);
     else
	   passport_no="";

	 if(document.forms[0].alt_id3_no)
	   license_no =escape(document.forms[0].alt_id3_no.value);
     else
	   license_no="";

	 if(document.forms[0].alt_id4_no)
	   old_ic_no =escape(document.forms[0].alt_id4_no.value);
     else
	   old_ic_no="";

	 if(document.forms[0].other_alt_type)
	   other_alt_type =document.forms[0].other_alt_type.value;
     else
	   other_alt_type="";

	 if(document.forms[0].other_alt_Id)
	  other_alt_id =document.forms[0].other_alt_Id.value;
     else
	   other_alt_id="";

		referral_id		= escape(document.forms[0].referral_id.value);	
		source_type		= document.forms[0].source_type.value;
		source			= document.forms[0].source.value;
		ref_from_loc_typ= document.forms[0].referred_from_location_type.value;
		ref_from_loc    = document.forms[0].referred_from_location.value;
		ref_from_pract  = document.forms[0].referred_from_practitioner.value;
		ref_from_ext_pract  = document.forms[0].from_ext_practitioner_id.value;

		ref_to_loc_typ  = document.forms[0].referred_to_location_type.value;
		ref_to_loc	    = document.forms[0].referred_to_location.value;
		ref_to_pract	= document.forms[0].referred_to_practitioner.value;
		fm_speciality_code = document.forms[0].fm_speciality_code.value;
		
		if(document.forms[0].to_speciality_code.disabled == true)
	{
			document.forms[0].to_speciality_code.disabled = false;
	}
		to_speciality_code = document.forms[0].to_speciality_code.value;		
		if(p_calling_function == "OA_BOOK_APPT" || p_calling_function == "CHG_REG_DTLS" || p_calling_function=="OA_MODIFY_APPT" || p_calling_function=="CHG_ADM_DTLS" || p_calling_function=="REV_VISIT_DTLS" || ass_func_id=="REFERAL_REQUIRED")
		{
			if(document.forms[0].to_speciality_code.disabled == false)
			{
				document.forms[0].to_speciality_code.disabled = true;
			}
		}

		p_search_speciality_code = document.forms[0].p_search_speciality_code.value;
		fm_service_code    = document.forms[0].fm_service_code.value;
		to_service_code    = document.forms[0].to_service_code.value;
		status    = document.forms[0].status.value;  
		priority    = document.forms[0].priority.value;

		var old_referrals=document.forms[0].old_referrals.value;
		var local_lang = "";
		if(document.forms[0].local_lang) {
			local_lang = document.forms[0].local_lang.value;
		}
		
		//document.forms[0].search.disabled = true ;

		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(proceed_yn == "Y"){
    		parent.frames[1].location.href='../../eMP/jsp/ReferralSearchResult.jsp?p_calling_function='+p_calling_function+'&patient_id='+patient_id+'&first_name='+first_name+'&second_name='+second_name+'&third_name='+third_name+'&family_name='+family_name+'&calledFrom='+calledFrom+'&name_prefix='+name_prefix+'&name_suffix='+name_suffix+'&referral_id='+referral_id+'&source_type='+source_type+'&source='+source+'&ref_from_loc_typ='+ref_from_loc_typ+
									'&ref_from_loc='+ref_from_loc+'&ref_from_ext_pract='+ref_from_ext_pract+'&ref_from_pract='+ref_from_pract+
									'&ref_to_loc_typ='+ref_to_loc_typ+'&ref_to_loc='+ref_to_loc+
									'&ref_to_pract='+ref_to_pract+'&p_to_locn_type='+p_to_locn_type+'&p_to_locn_code='+p_to_locn_code+'&p_select='+p_select+'&p_reg_patient='+p_reg_patient+'&from_speciality_code='+fm_speciality_code +'&to_speciality_code='+to_speciality_code+'&p_search_speciality_code='+p_search_speciality_code+'&from_service_code='+fm_service_code+'&to_service_code='+to_service_code+'&priority='+priority+'&res_class='+p_res_class+'&ass_func_id='+ass_func_id+'&nric_no='+nric_no+'&pmi_no='+pmi_no+'&passport_no='+passport_no+'&license_no='+license_no+'&old_ic_no='+old_ic_no+'&other_alt_type='+other_alt_type+'&other_alt_id='+other_alt_id+'&old_referrals='+old_referrals+"&status="+status+"&local_lang="+local_lang+"&created_frm_date="+created_frm_date+"&created_to_date="+created_to_date+"&pref_frm_date="+pref_frm_date+"&pref_to_date="+pref_to_date;
		}
}

function enableClearAll()
{
	if(parent.f_query_add_mod.document.getElementById('name_prefix') != null)
	{
		parent.f_query_add_mod.document.getElementById('name_prefix').disabled = false;
		parent.f_query_add_mod.document.getElementById('name_prefix').value = '';
	}
	if(parent.f_query_add_mod.document.getElementById('first_name') != null)
	{
		parent.f_query_add_mod.document.getElementById('first_name').readOnly = false;
		parent.f_query_add_mod.document.getElementById('first_name').value = '';
	}
	if(parent.f_query_add_mod.document.getElementById('second_name') != null)
	{
		parent.f_query_add_mod.document.getElementById('second_name').readOnly = false;
		parent.f_query_add_mod.document.getElementById('second_name').value = '';
	}
	if(parent.f_query_add_mod.document.getElementById('third_name') != null)
	{
		parent.f_query_add_mod.document.getElementById('third_name').readOnly = false;
		parent.f_query_add_mod.document.getElementById('third_name').value = '';
	}
	if(parent.f_query_add_mod.document.getElementById('family_name') != null)
	{
		parent.f_query_add_mod.document.getElementById('family_name').readOnly = false;
		parent.f_query_add_mod.document.getElementById('family_name').value = '';
	}
	if(parent.f_query_add_mod.document.getElementById('name_suffix') != null)
	{
		parent.f_query_add_mod.document.getElementById('name_suffix').disabled = false;
		parent.f_query_add_mod.document.getElementById('name_suffix').value = '';
	}
}


function disableItemsPat()
{
	if(parent.f_query_add_mod.document.getElementById('name_prefix') != null)
		parent.f_query_add_mod.document.getElementById('name_prefix').disabled = true;
	if(parent.f_query_add_mod.document.getElementById('first_name') != null)
		parent.f_query_add_mod.document.getElementById('first_name').readOnly = true;
	if(parent.f_query_add_mod.document.getElementById('second_name') != null)
		parent.f_query_add_mod.document.getElementById('second_name').readOnly = true;
	if(parent.f_query_add_mod.document.getElementById('third_name') != null)
		parent.f_query_add_mod.document.getElementById('third_name').readOnly = true;
	if(parent.f_query_add_mod.document.getElementById('family_name') != null)
		parent.f_query_add_mod.document.getElementById('family_name').readOnly = true;
	if(parent.f_query_add_mod.document.getElementById('name_suffix') != null)
		parent.f_query_add_mod.document.getElementById('name_suffix').disabled = true;
} 

function getService1(obj2,facilityid,obj4)
{
if (obj2.name=='fm_service_desc')
{
	if(obj2.value == "")
		{
			 obj2.value="";
			 obj4.value="";
			 return;
			}
	}else if(obj2.name=="to_service_desc")
	{
		if(obj2.value == "")
		{
			 obj2.value="";
			 obj4.value="";
			 return;
			}
	
	}

getService(obj2,facilityid,obj4)
}
async function getService(obj2,facilityid,obj4)
{
  source_type=document.forms[0].source_type.value;
var sqlservice="";

		
		var locale=document.forms[0].localeth.value
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel('Common.service.label','common');
		var sql="";
	
		
	/*if(source_type=="E" || source_type=="L"||obj2.name=="to_service_desc")
	 {
	 sql="select a.service_code code,b.short_desc description from am_facility_service a, am_service_lang_vw b where a.operating_facility_id='"+facilityid+"'  and b.language_id='"+locale+"' and a.service_code=b.service_code  and upper(a.service_code) like upper(?) and upper(b.short_desc) like upper(?) order by 2 ";
	 }else if(source_type=="X")
	 {*/
	 sql="Select service_code code,short_desc  description from  am_service_lang_vw where  eff_status= 'E'  and language_id='"+locale+"' and  upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	// } 
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = obj2.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );

		if (!(retVal == null||retVal == ""))
		{
				
		var ret1=unescape(retVal);
		arr=ret1.split(",");
			obj2.value=arr[1];
			obj4.value=arr[0];
			
		
			
		}
		else
	{	obj2.value="";
        obj4.value=""; 
		
	}

}

function disablecol()
{
document.forms[0].fm_service_desc.disabled=true;
	document.getElementById('serv1').disabled=true;
	
}
function populateSource(obj)
{

	document.forms[0].source.value="";
		document.forms[0].source_display.value="";
		document.forms[0].source_display.disabled=false;
        document.forms[0].referral_source_lkp_but.disabled=false;
		document.forms[0].referral_source_lkp_bkup_text.value="";
		document.getElementById('lng_name').style.visibility="hidden";

	if(document.forms[0].source_type.value=="")
	{

	document.forms[0].fm_service_desc.value="";
	document.forms[0].fm_service_code.value="";

	

	document.forms[0].fm_service_desc.disabled=true;
	document.getElementById('serv1').disabled=true;
	//document.forms[0].source.value="";
		//document.forms[0].source.disabled=false;
        //document.forms[0].referral_source_lkp_but.disabled=false;

	
	}else
	{

	document.forms[0].fm_service_desc.disabled=false;
	document.forms[0].fm_service_desc.value="";
	document.forms[0].fm_service_code.value="";
	document.getElementById('serv1').disabled=false;

	}
/*	var fm_service_code = document.forms[0].fm_service_code;
	   while(fm_service_code.options.length > 1)
             fm_service_code.remove[1];*/
	var referred_from_location_type = document.forms[0].referred_from_location_type;
		 while(referred_from_location_type.options.length > 1)
          referred_from_location_type.remove[1];
	
	if(obj.value != null && obj.value!='')
	{
	    //var source = document.forms[0].source;
		//while(source.options.length > 1)
        //source.remove[1];
		var pCallingFunction =document.forms[0].p_calling_function.value;		
		var p_from_ref_code = document.forms[0].p_from_ref_code.value;  
		
		//document.forms[0].source_display.disabled=true;
        //document.forms[0].referral_source_lkp_but.disabled=true;
		
		
		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PopulateSource.jsp'><input type='hidden' name='source_type' id='source_type' value='" +obj.value + "'><input type='hidden' name='p_from_ref_code' id='p_from_ref_code' value='"+p_from_ref_code+"'><input type='hidden' name='p_calling_function' id='p_calling_function' value='"+pCallingFunction+"'><input type='hidden' name='List' id='List' value='SOURCE'></form></BODY></HTML>";
		if(parent.frames[2].document.body)
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		if(parent.frames[2].document.form1)
			parent.frames[2].document.form1.submit();
	}	
	else 
	{
	
		 //var source = document.forms[0].source;
		// while(source.options.length > 1)
         // source.remove[1];
		 var referred_from_location = document.forms[0].referred_from_location;
		 while(referred_from_location.options.length > 1)
          referred_from_location.remove[1];
		
		document.forms[0].referred_from_practitioner.value="";
		document.forms[0].referred_from_practitioner_name.value="";
		
		
    }

	
}

function Enabled(){
       if(document.forms[0].source_type.value=='X') {
			//document.forms[0].pract_ext_name.style.display='inline';
			document.forms[0].from_ext_practitioner_id.style.display='inline';
	       document.forms[0].referred_from_practitioner_name.value="";
			document.forms[0].referred_from_practitioner.value="";
			document.forms[0].from_ext_practitioner_id.value="";
	      }
			else{
			    //document.forms[0].pract_ext_name.style.display='none';
				document.forms[0].from_ext_practitioner_id.style.display='none';
				document.forms[0].referred_from_practitioner_name.value="";
			   document.forms[0].referred_from_practitioner.value="";
			   document.forms[0].from_ext_practitioner_id.value="";
			}
 }

// This function is not used for population of service

function populateService(obj)
{
	if (obj.name=="fm_speciality_code")
    {
		var p_fm_speciality_code = document.forms[0].fm_speciality_code.value;  
		document.forms[0].referred_from_location_type.options[0].selected=true;
		 var referred_from_location = document.forms[0].referred_from_location;
		 while(referred_from_location.options.length > 1)
          referred_from_location.remove[1];

		 if(document.forms[0].source_type.value == 'X')
		{
		//	if(document.getElementById('referred_from_practitioner_name').value !=''){
			document.getElementById('referred_from_practitioner_name').value="";
			document.getElementById('referred_from_practitioner').value="";
			document.getElementById('from_ext_practitioner_id').value="";
			document.forms[0].referred_from_practitioner_name.disabled=false;
			document.forms[0].search_pract.disabled=false;
			document.forms[0].from_ext_practitioner_id.disabled=false;
		/*	if(document.getElementById("from_ext_practitioner_id").value !=''){
			document.forms[0].referred_from_practitioner_name.disabled=true;
			document.forms[0].search_pract.disabled=true;
 		    }  */
			
   		}
	}
    else 
	{	
		var p_to_speciality_code = document.forms[0].to_speciality_code.value;  
		document.forms[0].referred_to_location_type.options[0].selected=true;
		 var referred_to_location = document.forms[0].referred_to_location;
		 while(referred_to_location.options.length > 1)
          referred_to_location.remove[1];
	}
}


/*function populateHealthDesc(obj)
{
		
		 var referred_from_location_type = document.forms[0].referred_from_location_type;
		 while(referred_from_location_type.options.length > 1)
		 referred_from_location_type.remove[1];
		 var source_type = document.forms[0].source_type.value;
         var source = document.forms[0].source.value;
		 var pCallingFunction =document.forms[0].p_calling_function.value;
		 var function_id=document.forms[0].ass_func_id.value;

		
		 if((source_type=='E' || source_type=='X')) 
	 	 {
				
        var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form2' id='form2' method='post' action='../../eMP/jsp/PopulateSource.jsp'><input type='hidden' name='p_calling_function' id='p_calling_function' value='"+pCallingFunction+"'><input type='hidden' name='List' id='List' value='Location_Populate'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form2.submit();
		     
		 }
	 
	if(obj.value!=null && obj.value!='')
	{
       if(obj.value == "E"){
		 var referred_from_location_type = document.forms[0].referred_from_location_type;
		 while(referred_from_location_type.options.length > 1)
          referred_from_location_type.remove[1];
		 var referred_from_location = document.forms[0].referred_from_location;
		 while(referred_from_location.options.length > 1)
          referred_from_location.remove[1];
		document.forms[0].referred_from_practitioner.value="";
		document.forms[0].referred_from_practitioner_name.value="";
		 }
	   if(document.forms[0].health_care_setting_type_desc.value!=null)
         window.setTimeout("populateLocation(document.forms[0].referred_from_location_type)",700);
	}
	else 
	{
         
		 if(obj.name != "source_type"){
		 var referred_from_location_type = document.forms[0].referred_from_location_type;
		 while(referred_from_location_type.options.length > 1)
          referred_from_location_type.remove[1];
		 var referred_from_location = document.forms[0].referred_from_location;
		 while(referred_from_location.options.length > 1)
          referred_from_location.remove[1];
		document.forms[0].referred_from_practitioner.value="";
		document.forms[0].referred_from_practitioner_name.value="";
		 }
	}

}*/

function populateLocation(obj)
{
	if (obj.name =="referred_from_location_type")
	{
	if(obj.value!=null && obj.value!='')
	{
	   source_type = document.forms[0].source_type.value;
	   source = document.forms[0].source.value;
	   if(source_type=="E" || source_type=="L")
		{
			var referred_from_location = document.forms[0].referred_from_location;
			var p_from_locn_code = document.forms[0].p_from_locn_code.value;
			while(referred_from_location.options.length > 1)
			 referred_from_location.remove[1];

			var to_speciality_code=document.forms[0].fm_speciality_code.value;
			var pCallingFunction = document.forms[0].p_calling_function.value;			
						

			var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PopulateSource.jsp'><input type='hidden' name='referred_from_location_type' id='referred_from_location_type' value='" +obj.value + "'><input type='hidden' name='p_from_locn_code' id='p_from_locn_code' value='"+p_from_locn_code+"'><input type='hidden' name='p_calling_function' id='p_calling_function' value='" +pCallingFunction + "'><input type='hidden' name='source' id='source' value='"+source+"'><input type='hidden' name='List' id='List' value='FROM_LOCATION'><input type='hidden' name='to_speciality_code' id='to_speciality_code' value='"+to_speciality_code+"'></form></BODY></HTML>";
			if(parent.frames[2].document.body)
				parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			if(parent.frames[2].document.form1)
				parent.frames[2].document.form1.submit();
  		 }
    }
	else 
	{
		 var referred_from_location = document.forms[0].referred_from_location;
		 while(referred_from_location.options.length > 1)
          referred_from_location.remove[1];
		document.forms[0].referred_from_practitioner.value="";
		document.forms[0].referred_from_practitioner_name.value="";
	}
	}
else
	{
if(obj.value!=null && obj.value!='')
	{
	   source_type = document.forms[0].source_type.value;
	   source = document.forms[0].source.value;

	   if(source_type=="E")
		{
			var referred_to_location = document.forms[0].referred_to_location;
			var p_to_locn_code = document.forms[0].p_to_locn_code.value;
			while(referred_to_location.options.length > 1)
			 referred_to_location.remove[1];
			var pCallingFunction = document.forms[0].p_calling_function.value;
			var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PopulateSource.jsp'><input type='hidden' name='referred_to_location_type' id='referred_to_location_type' value='" +obj.value + "'><input type='hidden' name='p_to_locn_code' id='p_to_locn_code' value='"+p_to_locn_code+"'><input type='hidden' name='p_calling_function' id='p_calling_function' value='" +pCallingFunction + "'><input type='hidden' name='source' id='source' value='"+source+"'><input type='hidden' name='List' id='List' value='TO_LOCATION'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
  		}
    }
	else 
	{
		 var referred_to_location = document.forms[0].referred_to_location;
		 while(referred_to_location.options.length > 1)
          referred_to_location.remove[1];
		 var referred_to_practitioner = document.forms[0].referred_to_practitioner;
    	document.forms[0].referred_to_practitioner.value="";
		document.forms[0].referred_to_practitioner_name.value="";
	}
	}
}

//This function is used for Population of From service

function populateFmService(obj)
{
	var fm_service_code = document.forms[0].fm_service_code;
	/*   while(fm_service_code.options.length > 1)
             fm_service_code.remove[1];*/
	   source_type = document.forms[0].source_type.value;
	   source = document.forms[0].source.value;
	   locn_type=document.forms[0].referred_from_location_type.value;
	  if(source_type=="E" ||source_type=="L")
		{
			
        	
			var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PopulateSource.jsp'><input type='hidden' name='referred_from_location' id='referred_from_location' value='" +obj.value + "'><input type='hidden' name='source' id='source' value='"+source+"'><input type='hidden' name='source_type' id='source_type' value='"+source_type+"'><input type='hidden' name='referred_from_location_type' id='referred_from_location_type' value="+locn_type+"><input type='hidden' name='List' id='List' value='PRACTITIONER'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
		}

}

// Referral to 
function populateRefToLocation(obj)
{
	if(obj.value!=null && obj.value!='' )
	   {
			var referred_to_location = document.forms[0].referred_to_location;
			var pCallingFunction = document.forms[0].p_calling_function.value;
			while(referred_to_location.options.length > 1)
			 referred_to_location.remove[1];
            var p_to_locn_code = document.forms[0].p_to_locn_code.value

			var to_speciality_code=document.forms[0].to_speciality_code.value;
           
			var index=document.forms[0].referred_to_location_type.options.selectedIndex;
	        var care_ind;
	  if(index != 0)
		  care_ind=careArray[index];
	   else
		   care_ind="";
         
		   

			var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PopulateSource.jsp'><input type='hidden' name='p_calling_function' id='p_calling_function' value='" +pCallingFunction + "'><input type='hidden' name='referred_to_location_type' id='referred_to_location_type' value='" +obj.value + "'><input type='hidden' name='p_to_locn_code' id='p_to_locn_code' value='"+p_to_locn_code+"'><input type='hidden' name='List' id='List' value='REF_TO_LOCATION'><input type='hidden' name='care_ind' id='care_ind' value='"+care_ind+"'><input type='hidden' name='to_speciality_code' id='to_speciality_code' value='"+to_speciality_code+"'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();

		}
   else 
	{

		 var referred_to_location = document.forms[0].referred_to_location;
		 while(referred_to_location.options.length > 1)
          referred_to_location.remove[1];
		document.forms[0].referred_to_practitioner.value="";
		document.forms[0].referred_to_practitioner_name.value="";
	   
	}
}

//This function is used for population of To service

function populateToService(obj)
{
	
    var to_service_code = document.forms[0].to_service_code;
	   /*while(to_service_code.options.length > 1)
             to_service_code.remove[1];*/
	  
	   source_type = document.forms[0].source_type.value;
	   source = document.forms[0].source.value;
	   locn_type=document.forms[0].referred_to_location_type.value;
	
	   
	 		
        	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PopulateSource.jsp'><input type='hidden' name='referred_from_location' id='referred_from_location' value='" +obj.value + "'><input type='hidden' name='source' id='source' value='"+source+"'><input type='hidden' name='source_type' id='source_type' value='"+source_type+"'><input type='hidden' name='referred_from_location_type' id='referred_from_location_type' value="+locn_type+"><input type='hidden' name='List' id='List' value='PRACTITIONER'><input type='hidden' name='svalue' id='svalue' value='toService'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
}

   /* function reg_referral()
		 {
				var retVal = 	new String();
				var speciality_code = document.forms[0].p_search_speciality_code.value;
				var practitioner = document.forms[0].p_to_pract_id.value;
				var dialogHeight= "33"
				var dialogWidth	= "50" ;
				var dialogTop = "120" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				retVal = window.showModalDialog("../../eOP/jsp/RegPatReferral.jsp?module_id=AM&home_required_yn=N&function_id=REG_PAT_REF&function_name=&function_type=F&access=NYNNN&calling_from=SEARCH&speciality_code="+speciality_code+"&practitioner="+practitioner,arguments,features);
                if (retVal!=null)
				parent.window.returnValue=retVal;
			    parent.window.close();


	}*/

// JS functions used in Referral criteria.jsp

function oldReferrals(obj)
{
	if(obj.checked==true)
		document.forms[0].old_referrals.value='Y';
	else
		document.forms[0].old_referrals.value='N';
}

function localLang(obj)
{
	if(obj.checked==true)
		document.forms[0].local_lang.value='Y';
	else
		document.forms[0].local_lang.value='N';
}

function reprint_all_click()  {
    parent.f_query_add_mod_result.printrep.p_referral_id.value = parent.f_query_add_mod_result.document.printrep.p_referral_ids.value;
	var confirmprint = confirm(getMessage("REFLETTER_REPRINT","Common")); 
	  if (confirmprint)
	parent.f_query_add_mod_result.document.printrep.submit();
}
function getpractval1(obj)
{
	
	if(obj.value != null && obj.value != '')
	{
		getpractval(obj);
	}
	else
	{
		
	}

}
function getpractval(obj)
	{
		var open_to_all_pract="";
		var clinic_code="";
		var speciality_code="";
		var practitionerName="";
		var practitionerValue="";
		var sql="";
		var sqlSecond="";
		var facilityid=document.forms[0].facilityid.value; 
	    var ref_type=document.forms[0].source_type.value;
		var referral_source_code=document.forms[0].source.value;

		if (obj.name=="search_pract")
        {
		clinic_code		  = document.forms[0].referred_from_location.value;
		open_to_all_pract = document.forms[0].open_to_all_pract_yn1.value;        
		if(clinic_code == "") open_to_all_pract="";
		speciality_code   = document.forms[0].fm_speciality_code.value;
		practitionerName  = document.forms[0].referred_from_practitioner_name.name;
		practitionerValue = document.forms[0].referred_from_practitioner_name.value;
		referred_location_type=document.forms[0].referred_from_location_type.value;
		}
		else
		{
		open_to_all_pract = document.forms[0].open_to_all_pract_yn1.value;
		clinic_code		  = document.forms[0].referred_to_location.value;
		if(clinic_code == "") open_to_all_pract="";
		speciality_code   = document.forms[0].to_speciality_code.value;
		practitionerName  = document.forms[0].referred_to_practitioner_name.name;
		practitionerValue = document.getElementById('referred_to_practitioner_name').value;
		referred_location_type=document.forms[0].referred_to_location_type.value;
		}
 		practitionerValue=trimString(practitionerValue);
		if(practitionerValue=="" && window.event.target != obj)
			return;
		
		if((ref_type!='X')||(obj.name=="search_pract1")){
		if(clinic_code=="")
		{
		 sql="SELECT b.practitioner_id practitioner_id, am_get_desc.am_practitioner (b.practitioner_id, '"+localeName+"',1) practitioner_name, NVL (c.desc_sysdef, c.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender,am_get_desc.am_speciality (d.primary_speciality_code,'"+localeName+"',2) primary_specialty  FROM am_pract_for_facility a,am_practitioner_lang_vw b, am_pract_type c, am_pract_all_splty_vw d WHERE a.practitioner_id = b.practitioner_id  AND a.facility_id = d.facility_id AND a.facility_id = '"+facilityid+"'  AND b.language_id = '"+localeName+"'  AND c.pract_type = b.pract_type AND UPPER (c.pract_type) LIKE UPPER (NVL (?, c.pract_type)) AND d.practitioner_id = b.practitioner_id  AND UPPER (d.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code)) AND (UPPER (d.practitioner_id) LIKE  UPPER (NVL (?, d.practitioner_id)) OR UPPER (am_get_desc.am_practitioner (d.practitioner_id, '"+localeName+"', 1)) LIKE  UPPER (NVL (?, am_get_desc.am_practitioner (d.practitioner_id,'"+localeName+"',1)))) AND UPPER (d.gender) LIKE UPPER (NVL (?, d.gender))  AND UPPER (NVL (d.job_title, '123')) LIKE  UPPER (NVL (?, NVL (d.job_title, '123'))) ORDER BY 2";


         sqlSecond="SELECT b.practitioner_id practitioner_id, am_get_desc.am_practitioner (b.practitioner_id, '"+localeName+"',1) practitioner_name, NVL (c.desc_sysdef, c.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender,am_get_desc.am_speciality (d.primary_speciality_code,'"+localeName+"',2) primary_specialty  FROM am_pract_for_facility a,am_practitioner_lang_vw b, am_pract_type c, am_pract_all_splty_vw d WHERE a.practitioner_id = b.practitioner_id  AND a.facility_id = d.facility_id AND a.facility_id = '"+facilityid+"'  AND b.language_id = '"+localeName+"'  AND c.pract_type = b.pract_type AND UPPER (c.pract_type) LIKE UPPER (NVL (?, c.pract_type)) AND d.practitioner_id = b.practitioner_id  AND UPPER (d.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code)) AND (UPPER (d.practitioner_id) LIKE  UPPER (NVL (?, d.practitioner_id)) AND UPPER (am_get_desc.am_practitioner (d.practitioner_id, '"+localeName+"',1)) LIKE  UPPER (NVL (?, am_get_desc.am_practitioner (d.practitioner_id,'"+localeName+"',1)))) AND UPPER (d.gender) LIKE UPPER (NVL (?, d.gender))  AND UPPER (NVL (d.job_title, '123')) LIKE  UPPER (NVL (?, NVL (d.job_title, '123'))) ORDER BY 2";

		  //sql="select b.practitioner_id practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name, nvl(c.desc_sysdef,c.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender, d.short_desc primary_specialty  from am_pract_for_facility a, am_practitioner_lang_vw b, am_pract_type c, am_speciality d where a.practitioner_id = b.practitioner_id and a.facility_id = '"+facilityid+"' and b.language_id='"+localeName+"' and d.speciality_code=b.primary_speciality_code and c.pract_type=b.pract_type and upper(c.pract_type) like upper(nvl(?,c.pract_type)) and upper(d.speciality_code) like upper(nvl(?,d.speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123'))) order by 2";
		  
		  //sqlSecond="select b.practitioner_id practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name, nvl(c.desc_sysdef,c.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender, d.short_desc primary_specialty  from am_pract_for_facility a, am_practitioner_lang_vw b, am_pract_type c, am_speciality d where a.practitioner_id = b.practitioner_id and a.facility_id = '"+facilityid+"' and b.language_id='"+localeName+"' and d.speciality_code=b.primary_speciality_code and c.pract_type=b.pract_type and upper(c.pract_type) like upper(nvl(?,c.pract_type)) and upper(d.speciality_code) like upper(nvl(?,d.speciality_code)) and upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123'))) order by 2";		
		
		}
		else
		{
			if(referred_location_type =="C" )
			{
		       if(open_to_all_pract=="Y")
		          {
			sql="SELECT  b.practitioner_id practitioner_id,am_get_desc.am_practitioner (b.practitioner_id,'"+localeName+"',1) practitioner_name,NVL (d.desc_sysdef, d.desc_userdef) practitioner_type,b.position_code job_title, b.gender gender,am_get_desc.am_speciality (e.primary_speciality_code,'"+localeName+"',2) primary_specialty FROM am_pract_for_facility a,am_practitioner_lang_vw b,op_clinic c,am_pract_type d, am_pract_all_splty_vw e WHERE b.eff_status = 'E'  AND c.eff_status = 'E' AND b.practitioner_id = a.practitioner_id  AND a.eff_status = 'E'  AND a.facility_id = '"+facilityid+"' AND b.language_id = '"+localeName+"' AND c.facility_id = a.facility_id   AND c.clinic_code = '"+clinic_code+"' AND (c.speciality_code = b.primary_speciality_code OR c.speciality_code IN (SELECT speciality_code FROM am_pract_specialities  WHERE facility_id = '"+facilityid+"'  AND practitioner_id = b.practitioner_id  AND practitioner_id NOT IN (SELECT practitioner_id FROM am_practitioner))) AND NVL (c.pract_type, b.pract_type) = b.pract_type  AND d.pract_type = b.pract_type AND UPPER (d.pract_type) LIKE UPPER (NVL (?, d.pract_type)) AND a.facility_id = e.facility_id  AND UPPER (e.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND b.practitioner_id = e.practitioner_id AND (UPPER (e.practitioner_id) LIKE  UPPER (NVL (?, e.practitioner_id))  OR UPPER (am_get_desc.am_practitioner (e.practitioner_id, '"+localeName+"', 1)) LIKE  UPPER (NVL (?,am_get_desc.am_practitioner (e.practitioner_id,'"+localeName+"',1 )))) AND UPPER (e.gender) LIKE UPPER (NVL(?, e.gender)) AND UPPER (NVL (e.job_title, '123')) LIKE  UPPER (NVL (?, NVL (e.job_title, '123'))) ORDER BY 2";

			sqlSecond="SELECT  b.practitioner_id practitioner_id,am_get_desc.am_practitioner (b.practitioner_id,'"+localeName+"',1) practitioner_name,NVL (d.desc_sysdef, d.desc_userdef) practitioner_type,b.position_code job_title, b.gender gender,am_get_desc.am_speciality (e.primary_speciality_code,'"+localeName+"',2) primary_specialty FROM am_pract_for_facility a,am_practitioner_lang_vw b,op_clinic c,am_pract_type d, am_pract_all_splty_vw e WHERE b.eff_status = 'E'  AND c.eff_status = 'E' AND b.practitioner_id = a.practitioner_id  AND a.eff_status = 'E'  AND a.facility_id = '"+facilityid+"' AND b.language_id = '"+localeName+"' AND c.facility_id = a.facility_id   AND c.clinic_code = '"+clinic_code+"' AND (c.speciality_code = b.primary_speciality_code OR c.speciality_code IN (SELECT speciality_code FROM am_pract_specialities  WHERE facility_id = '"+facilityid+"'  AND practitioner_id = b.practitioner_id  AND practitioner_id NOT IN (SELECT practitioner_id FROM am_practitioner))) AND NVL (c.pract_type, b.pract_type) = b.pract_type  AND d.pract_type = b.pract_type AND UPPER (d.pract_type) LIKE UPPER (NVL (?, d.pract_type)) AND a.facility_id = e.facility_id  AND UPPER (e.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND b.practitioner_id = e.practitioner_id AND (UPPER (e.practitioner_id) LIKE  UPPER (NVL (?, e.practitioner_id))  AND UPPER (am_get_desc.am_practitioner (e.practitioner_id, '"+localeName+"', 1)) LIKE  UPPER (NVL (?,am_get_desc.am_practitioner (e.practitioner_id,'"+localeName+"',1 )))) AND UPPER (e.gender) LIKE UPPER (NVL(?, e.gender)) AND UPPER (NVL (e.job_title, '123')) LIKE  UPPER (NVL (?, NVL (e.job_title, '123'))) ORDER BY 2";
            
				      
			//sql="Select b.practitioner_id practitioner_id,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name, nvl(d.desc_sysdef,d.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender, e.short_desc primary_specialty from am_pract_for_facility a, am_practitioner_lang_vw b , op_clinic c, am_pract_type d, am_speciality e where b.eff_status = 'E' and c.eff_status = 'E' and b.practitioner_id = a.practitioner_id and a.eff_status = 'E' and a.facility_id = '"+facilityid+"' and b.language_id='"+localeName+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id ='"+facilityid+"' and practitioner_id = b.practitioner_id  AND practitioner_id NOT IN (SELECT practitioner_id FROM AM_PRACTITIONER))) and nvl(c.pract_type, b.pract_type) = b.pract_type and e.speciality_code=b.primary_speciality_code and d.pract_type=b.pract_type and upper(d.pract_type) like upper(nvl(?,d.pract_type)) and upper(c.speciality_code) like upper(nvl(?,c.speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123'))) order by 2" ;	
			
			//sqlSecond="Select b.practitioner_id practitioner_id,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name, nvl(d.desc_sysdef,d.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender, e.short_desc primary_specialty from am_pract_for_facility a, am_practitioner_lang_vw b , op_clinic c, am_pract_type d, am_speciality e where b.eff_status = 'E' and c.eff_status = 'E' and b.practitioner_id = a.practitioner_id and a.eff_status = 'E' and a.facility_id = '"+facilityid+"' and b.language_id='"+localeName+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id ='"+facilityid+"' and practitioner_id = b.practitioner_id  AND practitioner_id NOT IN (SELECT practitioner_id FROM AM_PRACTITIONER))) and nvl(c.pract_type, b.pract_type) = b.pract_type and e.speciality_code=b.primary_speciality_code and d.pract_type=b.pract_type and upper(d.pract_type) like upper(nvl(?,d.pract_type)) and upper(e.speciality_code) like upper(nvl(?,e.speciality_code)) and upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123'))) order by 2" ;					
		 
		  }
		else 
		{
		   	  	
			//sql="SELECT  a.PRACTITIONER_ID practitioner_id  , b.PRACTITIONER_NAME practitioner_name  , am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',1) practitioner_type  , b.position_code job_title  , b.gender gender  , am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty  FROM  op_pract_for_clinic a  , am_practitioner_lang_vw b WHERE a.FACILITY_ID ='"+facilityid+"'   AND a.eff_status = 'E' and b.language_id='"+localeName+"'  AND a.CLINIC_CODE ='"+clinic_code+"'   AND a.practitioner_id=b.practitioner_id  and b.language_id = '"+localeName+"'   AND upper(b.pract_type) like upper(nvl(?,b.pract_type))   AND upper(b.PRIMARY_SPECIALITY_CODE) like upper(nvl(?,b.PRIMARY_SPECIALITY_CODE))   AND   (  upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id))   OR upper(am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)))  )   AND upper(b.gender) like upper(nvl(?,b.gender))   AND upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123')))  ORDER BY  2";

			sql="SELECT   a.practitioner_id practitioner_id, b.practitioner_name practitioner_name,          am_get_desc.am_pract_type (b.pract_type, '"+localeName+"', 1) practitioner_type,  b.position_code job_title, b.gender gender,am_get_desc.am_speciality(c.primary_speciality_code, '"+localeName+"', 2 ) primary_specialty FROM op_pract_for_clinic a, am_practitioner_lang_vw b,am_pract_all_splty_vw c WHERE a.facility_id = '"+facilityid+"'  AND a.eff_status = 'E' AND b.language_id = '"+localeName+"' AND a.clinic_code = '"+clinic_code+"' AND a.practitioner_id = b.practitioner_id  AND b.language_id = '"+localeName+"' AND UPPER (b.pract_type) LIKE UPPER (NVL(?, b.pract_type)) AND a.facility_id = c.facility_id  AND a.practitioner_id = c.practitioner_id  AND UPPER (c.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code)) AND (UPPER (a.practitioner_id) LIKE  UPPER (NVL (?, a.practitioner_id))  OR UPPER (am_get_desc.am_practitioner (a.practitioner_id, '"+localeName+"', 1)) LIKE UPPER (NVL(?,am_get_desc.am_practitioner (a.practitioner_id,'"+localeName+"', 1)))) AND UPPER (b.gender) LIKE UPPER (NVL (?, b.gender)) AND UPPER (NVL (b.job_title, '123')) LIKE  UPPER (NVL (?, NVL (b.job_title, '123'))) ORDER BY 2";

			sqlSecond="SELECT   a.practitioner_id practitioner_id, b.practitioner_name practitioner_name,          am_get_desc.am_pract_type (b.pract_type, '"+localeName+"', 1) practitioner_type,  b.position_code job_title, b.gender gender,am_get_desc.am_speciality(c.primary_speciality_code, '"+localeName+"', 2 ) primary_specialty FROM op_pract_for_clinic a, am_practitioner_lang_vw b,am_pract_all_splty_vw c WHERE a.facility_id = '"+facilityid+"'  AND a.eff_status = 'E' AND b.language_id = '"+localeName+"' AND a.clinic_code = '"+clinic_code+"' AND a.practitioner_id = b.practitioner_id  AND b.language_id = '"+localeName+"' AND UPPER (b.pract_type) LIKE UPPER (NVL(?, b.pract_type)) AND a.facility_id = c.facility_id  AND a.practitioner_id = c.practitioner_id  AND UPPER (c.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code)) AND (UPPER (a.practitioner_id) LIKE  UPPER (NVL (?, a.practitioner_id))  AND UPPER (am_get_desc.am_practitioner (a.practitioner_id, '"+localeName+"', 1)) LIKE UPPER (NVL(?,am_get_desc.am_practitioner (a.practitioner_id,'"+localeName+"', 1)))) AND UPPER (b.gender) LIKE UPPER (NVL (?, b.gender)) AND UPPER (NVL (b.job_title, '123')) LIKE  UPPER (NVL (?, NVL (b.job_title, '123'))) ORDER BY 2";
			
		    //sqlSecond="SELECT  a.PRACTITIONER_ID practitioner_id  , b.PRACTITIONER_NAME practitioner_name  , am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',1) practitioner_type  , b.position_code job_title  , b.gender gender  , am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty  FROM  op_pract_for_clinic a  , am_practitioner_lang_vw b WHERE a.FACILITY_ID ='"+facilityid+"'   AND a.eff_status = 'E' and b.language_id='"+localeName+"'  AND a.CLINIC_CODE ='"+clinic_code+"'   AND a.practitioner_id=b.practitioner_id  and b.language_id = '"+localeName+"'   AND upper(b.pract_type) like upper(nvl(?,b.pract_type))   AND upper(b.PRIMARY_SPECIALITY_CODE) like upper(nvl(?,b.PRIMARY_SPECIALITY_CODE))   AND   (  upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id))   AND upper(am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)))  )   AND upper(b.gender) like upper(nvl(?,b.gender))   AND upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123')))  ORDER BY  2";
	     }
		}else if(referred_location_type =="E" || referred_location_type =="Y" )
			{
			 sql="SELECT   a.practitioner_id practitioner_id,b.practitioner_name practitioner_name,          am_get_desc.am_pract_type (b.pract_type, '"+localeName+"', 1) practitioner_type, b.position_code job_title, b.gender gender,am_get_desc.am_speciality(c.primary_speciality_code, '"+localeName+"', 2 ) primary_specialty FROM op_pract_for_clinic a, am_practitioner_lang_vw b,am_pract_all_splty_vw c WHERE a.facility_id = '"+facilityid+"'  AND b.language_id = '"+localeName+"' AND a.eff_status = 'E' AND a.clinic_code = '"+clinic_code+"' AND a.practitioner_id = b.practitioner_id   AND b.language_id = '"+localeName+"'  AND UPPER (b.pract_type) LIKE UPPER (NVL (?, b.pract_type)) AND a.facility_id = c.facility_id  AND a.practitioner_id = c.practitioner_id  AND UPPER (c.primary_speciality_code) LIKE  UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND (UPPER (c.practitioner_id) LIKE  UPPER (NVL (?, c.practitioner_id))  OR UPPER (am_get_desc.am_practitioner (c.practitioner_id, '"+localeName+"', 1)) LIKE  UPPER (NVL ('%',am_get_desc.am_practitioner (c.practitioner_id, '"+localeName+"',1 )))) AND UPPER (b.gender) LIKE UPPER (NVL ('%', b.gender))  AND UPPER (NVL (b.job_title, '123')) LIKE   UPPER (NVL ('%', NVL (b.job_title, '123'))) ORDER BY 2";

			 sqlSecond="SELECT   a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, am_get_desc.am_pract_type (b.pract_type, '"+localeName+"', 1) practitioner_type, b.position_code job_title, b.gender gender,am_get_desc.am_speciality(c.primary_speciality_code, '"+localeName+"', 2 ) primary_specialty FROM op_pract_for_clinic a, am_practitioner_lang_vw b,am_pract_all_splty_vw c WHERE a.facility_id = '"+facilityid+"'      AND b.language_id = '"+localeName+"' AND a.eff_status = 'E' AND a.clinic_code = '"+clinic_code+"' AND a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"'  AND UPPER (b.pract_type) LIKE UPPER (NVL (?, b.pract_type)) AND a.facility_id = c.facility_id  AND a.practitioner_id = c.practitioner_id  AND UPPER (c.primary_speciality_code) LIKE  UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND (UPPER (c.practitioner_id) LIKE  UPPER (NVL (?, c.practitioner_id))  AND UPPER (am_get_desc.am_practitioner (c.practitioner_id, '"+localeName+"', 1)) LIKE  UPPER (NVL ('%',am_get_desc.am_practitioner (c.practitioner_id, '"+localeName+"',1 )))) AND UPPER (b.gender) LIKE UPPER (NVL ('%', b.gender))  AND UPPER (NVL (b.job_title, '123')) LIKE   UPPER (NVL ('%', NVL (b.job_title, '123'))) ORDER BY 2";

			  //sql="SELECT  a.PRACTITIONER_ID practitioner_id  , b.PRACTITIONER_NAME practitioner_name  , am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',1) practitioner_type  , b.position_code job_title  , b.gender gender  , am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty  FROM  op_pract_for_clinic a  , am_practitioner_lang_vw b WHERE a.FACILITY_ID ='"+facilityid+"' and b.language_id='"+localeName+"'  AND a.eff_status = 'E'   AND a.CLINIC_CODE ='"+clinic_code+"'   AND a.practitioner_id=b.practitioner_id  and b.language_id = '"+localeName+"'   AND upper(b.pract_type) like upper(nvl(?,b.pract_type))   AND upper(b.PRIMARY_SPECIALITY_CODE) like upper(nvl(?,b.PRIMARY_SPECIALITY_CODE))   AND   (  upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id))   OR upper(am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)))  )   AND upper(b.gender) like upper(nvl(?,b.gender))   AND upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123')))  ORDER BY  2";
			
		 	  //sqlSecond="SELECT  a.PRACTITIONER_ID practitioner_id  , b.PRACTITIONER_NAME practitioner_name  , am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',1) practitioner_type  , b.position_code job_title  , b.gender gender  , am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty  FROM  op_pract_for_clinic a  , am_practitioner_lang_vw b WHERE a.FACILITY_ID ='"+facilityid+"'  and b.language_id='"+localeName+"' AND a.eff_status = 'E'   AND a.CLINIC_CODE ='"+clinic_code+"'   AND a.practitioner_id=b.practitioner_id  and b.language_id = '"+localeName+"'   AND upper(b.pract_type) like upper(nvl(?,b.pract_type))   AND upper(b.PRIMARY_SPECIALITY_CODE) like upper(nvl(?,b.PRIMARY_SPECIALITY_CODE))   AND   (  upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id))   AND upper(am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)))  )   AND upper(b.gender) like upper(nvl(?,b.gender))   AND upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123')))  ORDER BY  2";
	        
			}
		 else if(referred_location_type == "N")
			{
			sql= "SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner (b.practitioner_id, '"+localeName+"',1) practitioner_name, c.desc_sysdef practitioner_type, a.specialty_code,        am_get_desc.am_speciality  (a.primary_speciality_code, '"+localeName+"', 2 ) primary_specialty, a.gender gender, a.position_code job_title   FROM am_pract_all_splty_vw a, am_practitioner_lang_vw b, am_pract_type c, am_speciality d, ip_nursing_unit_for_pract e  WHERE a.facility_id = '"+facilityid+"'    AND b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?) UPPER (a.primary_speciality_code) LIKE  UPPER (NVL (replace(?,'%',''), b.primary_speciality_code)) AND b.practitioner_id = a.practitioner_id  AND c.pract_type = b.pract_type  AND d.speciality_code = a.specialty_code AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+clinic_code+"' AND e.practitioner_id = a.practitioner_id  AND   AND a.specialty_code LIKE UPPER (?) AND (UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.am_practitioner (b.practitioner_id, '"+localeName+"', 1)) LIKE UPPER (NVL (?,am_get_desc.am_practitioner (b.practitioner_id,'"+localeName+"',1)))) AND a.gender LIKE (?) AND (a.job_title LIKE (?) OR a.job_title IS NULL) ORDER BY 2";

			sqlSecond ="SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner (b.practitioner_id, '"+localeName+"',1) practitioner_name, c.desc_sysdef practitioner_type, a.specialty_code,        am_get_desc.am_speciality  (a.primary_speciality_code, '"+localeName+"', 2 ) primary_specialty, a.gender gender, a.position_code job_title   FROM am_pract_all_splty_vw a, am_practitioner_lang_vw b, am_pract_type c, am_speciality d, ip_nursing_unit_for_pract e  WHERE a.facility_id = '"+facilityid+"'    AND b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?) UPPER (a.primary_speciality_code) LIKE  UPPER (NVL (replace(?,'%',''), b.primary_speciality_code)) AND b.practitioner_id = a.practitioner_id  AND c.pract_type = b.pract_type  AND d.speciality_code = a.specialty_code AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+clinic_code+"' AND e.practitioner_id = a.practitioner_id  AND   AND a.specialty_code LIKE UPPER (?) AND (UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) AND UPPER (am_get_desc.am_practitioner (b.practitioner_id, '"+localeName+"', 1)) LIKE UPPER (NVL (?,am_get_desc.am_practitioner (b.practitioner_id,'"+localeName+"',1)))) AND a.gender LIKE (?) AND (a.job_title LIKE (?) OR a.job_title IS NULL) ORDER BY 2";
			
			//sql= "SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name, c.desc_sysdef practitioner_type,   a.specialty_code, d.short_desc primary_specialty, a.gender gender,a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner b,am_pract_type c,am_speciality d,ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facilityid+"' and a.language_id='"+localeName+"' AND a.specialty_code = '"+speciality_code+"' AND b.practitioner_id = a.practitioner_id AND c.pract_type = b.pract_type AND d.speciality_code = a.specialty_code AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+clinic_code+"' AND e.practitioner_id = a.practitioner_id AND b.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?)  AND (UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) LIKE UPPER (NVL (?, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) AND a.gender LIKE (?) AND (a.job_title LIKE (?) OR a.job_title IS NULL)";

			//sql= "SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name, c.desc_sysdef practitioner_type,   a.specialty_code, d.short_desc primary_specialty, a.gender gender,a.position_code job_title FROM am_pract_all_splty_vw a,AM_PRACTITIONER_LANG_VW b,am_pract_type c,am_speciality d,ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facilityid+"' and b.language_id='"+localeName+"' AND a.specialty_code = '"+speciality_code+"' AND b.practitioner_id = a.practitioner_id AND c.pract_type = b.pract_type AND d.speciality_code = a.specialty_code AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+clinic_code+"' AND e.practitioner_id = a.practitioner_id AND b.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?)  AND (UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) LIKE UPPER (NVL (?, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) AND a.gender LIKE (?) AND (a.job_title LIKE (?) OR a.job_title IS NULL)";

	       // sqlSecond ="SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name, c.desc_sysdef practitioner_type,   a.specialty_code, d.short_desc primary_specialty, a.gender gender, a.position_code job_title FROM am_pract_all_splty_vw a, am_practitioner_lang_vw b,am_pract_type c,am_speciality d,ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facilityid+"' and a.language_id='"+localeName+"' AND a.specialty_code = '"+speciality_code+"' AND b.practitioner_id = a.practitioner_id AND c.pract_type = b.pract_type AND d.speciality_code = a.specialty_code AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+clinic_code+"' AND e.practitioner_id = a.practitioner_id AND b.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?)  AND (UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) AND UPPER (am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) LIKE UPPER (NVL (?, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) AND a.gender LIKE (?) AND (a.job_title LIKE (?) OR a.job_title IS NULL)";

		   //sqlSecond ="SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name, c.desc_sysdef practitioner_type,   a.specialty_code, d.short_desc primary_specialty, a.gender gender, a.position_code job_title FROM am_pract_all_splty_vw a, am_practitioner_lang_vw b,am_pract_type c,am_speciality d,ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facilityid+"' and b.language_id='"+localeName+"' AND a.specialty_code = '"+speciality_code+"' AND b.practitioner_id = a.practitioner_id AND c.pract_type = b.pract_type AND d.speciality_code = a.specialty_code AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+clinic_code+"' AND e.practitioner_id = a.practitioner_id AND b.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?)  AND (UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) AND UPPER (am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) LIKE UPPER (NVL (?, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) AND a.gender LIKE (?) AND (a.job_title LIKE (?) OR a.job_title IS NULL)";
			}

		}

		}else{
          sql	 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_ext_practitioner (a.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type,am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',2) primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_ext_practitioner_lang_vw  a,AM_EXT_PRACT_FOR_REFERRAL b, AM_REFERRAL c  WHERE b.REFERRAL_CODE=c.REFERRAL_CODE and c.REFERRAL_CODE='"+referral_source_code+"'   and b.eff_status='E' AND  a.practitioner_id = b.practitioner_id AND a.language_id = '"+localeName+"'  AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type))  AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), a.primary_speciality_code)) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id))  OR UPPER (a.practitioner_name) LIKE  UPPER (NVL (?, a.practitioner_name)))  AND  a.gender LIKE   NVL (DECODE (UPPER (?), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U'),a.gender) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";	
          sqlSecond=sql;

		}
	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + practitionerName + "\""	;
		xmlStr += " practName_FValue=\"" + encodeURIComponent(practitionerValue) + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + speciality_code + "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " title=\"" + getLabel('Common.practitioner.label','Common') + "\"";
		xmlStr += " gender=\"" + "" + "\"";

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		//eval(responseText);
		eval(practSearch(practitionerName,encodeURIComponent(practitionerValue),speciality_code,responseText));

	}
	
	async function practSearch(practName_FName,practName_FValue,speciality_code,responseText) {
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
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+speciality_code+"&job_title="+"\""+"&gender="+"\""+"&title="+getLabel('Common.practitioner.label','Common'),arguments,features);
	PractLookupRetVal(retVal,objName);
}

  function PractLookupRetVal(retVal,objName)
	{
		var arr;
		if (retVal != null)
		{

			arr=retVal.split("~");
			
			if(objName=="referred_to_practitioner_name")
			{
				document.forms[0].referred_to_practitioner.value=arr[0];
				document.forms[0].referred_to_practitioner_name.value=arr[1];
			}
			else
			{  

				document.forms[0].referred_from_practitioner.value=arr[0];
				document.forms[0].referred_from_practitioner_name.value=arr[1];
				if(document.forms[0].source_type.value=='X'){
				if(	document.forms[0].referred_from_practitioner_name.value !=''){
				document.forms[0].from_ext_practitioner_id.disabled=true;
				document.forms[0].from_ext_practitioner_id.value="";
				   }else{
		        document.forms[0].from_ext_practitioner_id.disabled=false;
				document.forms[0].from_ext_practitioner_id.value="";

		}
				}
             }
		}
		else
		{

			if(objName=="referred_to_practitioner_name")
			{
				document.forms[0].referred_to_practitioner.value="";
				document.forms[0].referred_to_practitioner_name.value="";
			}
			else
			{
				document.forms[0].referred_from_practitioner.value="";
				document.forms[0].referred_from_practitioner_name.value="";
			}
		}
 }

 async function reg_referral()
		 {

				var p_calling_function = document.forms[0].p_calling_function.value;
				
				var ass_func_id=document.forms[0].ass_func_id.value;
				var p_to_locn_type=document.forms[0].p_to_locn_type.value;
				var p_to_locn_code=document.forms[0].p_to_locn_code.value;
				var retVal = 	new String();
				var speciality_code = document.forms[0].p_search_speciality_code.value;
				var service_code = document.forms[0].to_service_code_search.value;
				var practitioner = document.forms[0].pract_id1.value;
				var practitioner_name = document.forms[0].pract_name1.value;
				var res_class = document.forms[0].p_res_class.value;
				//var patient_id=document.forms[0].patient_id.value;
				var ca_patient_id=document.forms[0].ca_patient_id.value;
				if(ca_patient_id =="")
				 {
					var patient_id=document.forms[0].patient_id.value;
				 }else
				 {
					var patient_id=document.forms[0].ca_patient_id.value;
				 }	
				
				var p_service_desc=document.forms[0].p_service_desc.value;//ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005
				
			
				var dialogHeight= "100vh"
				var dialogWidth	= "85vw" ;
				var dialogTop = "0" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				

				retVal = await top.window.showModalDialog("../../eMP/jsp/RegPatReferral.jsp?module_id=AM&home_required_yn=N&function_id=REG_PAT_REF&function_name=&function_type=F&access=NYNNN&calling_from=SEARCH&speciality_code="+speciality_code+"&service_code="+service_code+"&practitioner="+practitioner+"&p_calling_function="+p_calling_function+"&practitioner_name="+encodeURIComponent(practitioner_name)+"&res_class="+res_class+"&patient_id="+patient_id+"&ass_func_id="+ass_func_id+"&p_to_locn_type="+p_to_locn_type+"&p_to_locn_code="+p_to_locn_code+"&p_service_desc="+p_service_desc+"&ca_patient_id="+ca_patient_id,arguments,features); 
				//alert("retVal:"+retVal);
                if (retVal!= null)
				{
					var arrval = new Array();
					arrval = retVal.split("%");
					var ref_id = arrval[0];
					var pat_id = arrval[1];

					if(p_calling_function == "OP_REG_VISIT")
					{
						if(pat_id == null || pat_id == "")
						{
							
							var retVal =    new String();
							var dialogHeight= "15.5" ;
							var dialogWidth = "40" ;
							var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
							 var arguments   = "" ;
							 retVal = await window.showModalDialog("../../eMP/jsp/VisitRegistrationPromptPatID.jsp?p_referral_id="+ref_id+"&func_act=REF_SEARCH",arguments,features);
							 parent.window.returnValue=ref_id;
							 parent.window.close();						
						}
						else
						{
							 parent.window.returnValue=ref_id;
							 parent.window.close();						
						}
					}	
					else
					{	
						parent.window.returnValue=ref_id;
						parent.window.close();
					}
				}
	}

/*function checkme(obj)
	 {
		 if(CheckDate(obj))
		 doDateCheckRef(document.forms[0].referral_date_from,document.forms[0].sysdate)
	 }*/
//JS functions in Referral search result.jsp



function sendReferralId(referralId,locncode)
{		 
	 
	if(locncode == null) locncode = "";	 
	p_calling_function =document.forms[0].p_calling_function.value;
	if(locncode != "null" && locncode != "")	{		
			var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PopulateSource.jsp'><input type='hidden' name='tolocncode' id='tolocncode' value='" +locncode+ "'><input type='hidden' name='p_calling_function' id='p_calling_function' value='" +p_calling_function+ "'><input type='hidden' name='referralId' id='referralId' value='" +referralId+ "'><input type='hidden' name='List' id='List' value='OPER_STN_ACCESS_CHECK'></form></BODY></HTML>";
		 

			if(parent.frames[2].document.body != null ){ 
				parent.frames[2].document.write(HTMLVal);
				parent.frames[2].document.form1.submit();
			}


	} else { 		
			parent.window.returnValue=referralId;
			parent.window.close();	
		}
}

function sendtochangereferral(referralId) {
    parent.window.returnValue = referralId;

    // Close the dialog, considering the backdrop
    if (parent.window.frameElement && parent.window.frameElement.tagName === "IFRAME") {
        parent.window.parent.document.querySelector('dialog').close();
    } else {
        parent.window.close();
    }
}


function registerPatientId(referralId,clinic_code)
		{ 		   
			var msg=getMessage('PAT_ID_NOT_FOUND_FOR_REF','MP');
			alert(msg);				
		}
   function reprintreferral(ref)
   {
	  var confirmprint = confirm(getMessage("REFLETTER_REPRINT","Common"));
	  if (confirmprint)
	   {
		parent.frames[1].document.forms[1].p_referral_id.value=ref;
		parent.frames[1].document.forms[1].submit();
	   }
   }

	async function referral_notes(notes)
	{
		var dialogHeight= "35vh" ;
		var dialogWidth = "57vw" ;                      
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
		var arguments	= unescape(eval("document.forms[0]."+notes).value);
		var temp		= notes;
		var arr			= new Array();
		arr				= temp.split('\n');
		
		for(u=0;u<arr.length;u++)
			arr[u]=arr[u]+"`";

		var retVal = await window.showModalDialog("../../eMP/jsp/Referral_Notes.jsp?from=search",arguments,features);
	}

	async function viewReferral(ref)
	{
		var ordercatlogcode = document.forms[0].ordercatlog.value;
		var retVal		= new String();
		var dialogHeight= "95vh" ;
		var dialogTop	= "0px" ;
		var dialogWidth	= "95vw" ;
		var status		= "no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ; dialogTop:" + dialogTop + " ; scroll=no; status:" + status ;
		var retVal		= await top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref+'&ordercatlogcode='+ordercatlogcode,arguments,features);
	}

	function callMethod(start,end)
	{
		 var start1=parseInt(start)+10;
		 var end1=parseInt(end)+10;
		 var  HTMLVal = new String();
		 var old_referrals=document.forms[0].old_referrals.value;
		HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMP/jsp/ReferralSearchResult.jsp'><input type='hidden' name='whereClause' id='whereClause' value='"+document.forms[0].whereClause.value+"'><input type='hidden' name='calledFrom' id='calledFrom' value='"+document.forms[0].calledFrom.value+"'><input type='hidden' name='Unregpatbkgyn' id='Unregpatbkgyn' value='"+document.forms[0].Unregpatbkgyn.value+"'><input type='hidden' name='p_select' id='p_select' value='"+document.forms[0].p_select.value+"'><input type='hidden' name='p_calling_function' id='p_calling_function' value='"+document.forms[0].p_calling_function.value+"'><input type='hidden' name='p_search_speciality_code' id='p_search_speciality_code' value='"+document.forms[0].p_search_speciality_code.value+"'><input type='hidden' name='p_reg_patient' id='p_reg_patient' value='"+document.forms[0].p_reg_patient.value+"'><input type='hidden' name='from' id='from' value="+start1+"><input type='hidden' name='old_referrals' id='old_referrals' value='"+old_referrals+"'><input type='hidden' name='to' id='to' value="+end1+"></form></body></html>";
		parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[1].document.dum_form.submit();
	}
function callMethod1(start,end)
			{
			 var start1=parseInt(start)-10;
			 var end1=parseInt(end)-10;
			 var  HTMLVal = new String();
			  var old_referrals=document.forms[0].old_referrals.value;

			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMP/jsp/ReferralSearchResult.jsp'><input type='hidden' name='whereClause' id='whereClause' value='"+document.forms[0].whereClause.value+"'><input type='hidden' name='calledFrom' id='calledFrom' value='"+document.forms[0].calledFrom.value+"'><input type='hidden' name='Unregpatbkgyn' id='Unregpatbkgyn' value='"+document.forms[0].Unregpatbkgyn.value+"'><input type='hidden' name='p_select' id='p_select' value='"+document.forms[0].p_select.value+"'><input type='hidden' name='p_calling_function' id='p_calling_function' value='"+document.forms[0].p_calling_function.value+"'><input type='hidden' name='p_search_speciality_code' id='p_search_speciality_code' value='"+document.forms[0].p_search_speciality_code.value+"'><input type='hidden' name='p_reg_patient' id='p_reg_patient' value='"+document.forms[0].p_reg_patient.value+"'><input type='hidden' name='from' id='from' value="+start1+"><input type='hidden' name='old_referrals' id='old_referrals' value='"+old_referrals+"'><input type='hidden' name='to' id='to' value="+end1+"></form></body></html>";
			parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[1].document.dum_form.submit();
			
	}

function makeVisible(obj)
{
	
	var p_calling_function	= document.forms[0].p_calling_function.value;
	if(obj.value == getLabel('Common.morecriteria.label','Common'))	
	{
		document.forms[0].mcriteria.value=getLabel('Common.lesscriteria.label','Common');
		flag="Y";
	}else
	{
		document.forms[0].mcriteria.value=getLabel('Common.morecriteria.label','Common');
		flag="N";
	}
	
	if(flag == "Y")
	{
		
		if(p_calling_function == "INDEPENDENT" || p_calling_function =="REPRINT_REF_LETTER" )  {
			//parent.refsearch.rows="75%,25%,0%";
		parent.document.getElementById("f_query_add_mod").style.height="56vh";
		parent.document.getElementById("f_query_add_mod_result").style.height="38vh";
		parent.document.getElementById("validation_frame").style.height="0vh";			
		 }
		else {
		//parent.refsearch.rows="75%,25%,0%"; 
		parent.document.getElementById("f_query_add_mod").style.height="67.2vh";
		parent.document.getElementById("f_query_add_mod_result").style.height="30vh";
		parent.document.getElementById("validation_frame").style.height="0vh";
		}
		document.getElementById("moreCrite1").style.visibility='visible';
		document.getElementById("moreCrite1").style.display='';
		document.getElementById("moreCrite2").style.visibility='visible';
		document.getElementById("moreCrite2").style.display='';
		document.forms[0].from_ext_practitioner_id.style.display='none';

		
	}else
	{
		//parent.refsearch.rows="48%,49%,0%";//modified by N Munisekhar for[IN:048929] 
		parent.document.getElementById("f_query_add_mod").style.height="50vh";
		parent.document.getElementById("f_query_add_mod_result").style.height="42vh";
		parent.document.getElementById("validation_frame").style.height="0vh";
		
		document.getElementById("moreCrite1").style.visibility='hidden';
		document.getElementById("moreCrite1").style.display='none';
		document.getElementById("moreCrite2").style.visibility='hidden';
		document.getElementById("moreCrite2").style.display='none';
	}
	
}

async function bookReferral(refID,loc_type,resourceId,patient_id,clinicCode,careLocnTypeInd,speciality,locnCode,to_locn_desc,resourcedesc,preferDate)
{	
	
	var retVal = 	new String();
	var dialogHeight= "400px";
	var dialogWidth = "700px";
	var dialogTop	= "72";
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ; dialogTop:" + dialogTop + " ; scroll=no; status:" + status ;
	var callingMode=parent.frames[0].document.forms[0].callingMode.value;	
	if(clinicCode == null) clinicCode = "";	
	p_calling_function =document.forms[0].p_calling_function.value;
	if(loc_type == "C" || loc_type == "D" || loc_type == "E" || loc_type == "Y"){			
		if(clinicCode != "null" && clinicCode != "")	{	//Added some additional parameters by S.Sathish IN021901 on Friday, June 11, 2010 		
				var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PopulateSource.jsp'><input type='hidden' name='tolocncode' id='tolocncode' value='" +locnCode+ "'><input type='hidden' name='p_calling_function' id='p_calling_function' value='" +p_calling_function+ "'><input type='hidden' name='referralId' id='referralId' value='" +refID+ "'><input type='hidden' name='resourceId' id='resourceId' value='" +resourceId+ "'><input type='hidden' name='patient_id' id='patient_id' value='" +patient_id+ "'><input type='hidden' name='careLocnTypeInd' id='careLocnTypeInd' value='" +careLocnTypeInd+ "'><input type='hidden' name='speciality' id='speciality' value='" +speciality+ "'><input type='hidden' name='callingMode' id='callingMode' value='" +callingMode+ "'><input type='hidden' name='loc_type' id='loc_type' value='" +loc_type+ "'>	<input type='hidden' name='preferDate' id='preferDate' value='" +preferDate+ "'><input type='hidden' name='clinicCode' id='clinicCode' value='" +clinicCode+ "'>			<input type='hidden' name='List' id='List' value='OPER_STN_ACCESS_CHECK'><input type='hidden' name='to_locn_desc' id='to_locn_desc' value='" +to_locn_desc+ "'><input type='hidden' name='resourcedesc' id='resourcedesc' value='" +resourcedesc+ "'></form></BODY></HTML>";
				
				if(parent.frames[2].document.body)
					parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				if(parent.frames[2].document.form1)
					parent.frames[2].document.form1.submit();					
		} else {			
		
		if(loc_type=='N')
		{
			var retVal = await window.showModalDialog("../../eIP/jsp/Booking.jsp?home_required_yn=N&referral_id="+refID+"&function_type=F&access=NYNNN&call_func=OP_Pending_Referral_Booking",arguments,features);
			
		}	
		else if(loc_type!='N')
		{
			var qryStr = "../../eOA/jsp/CAOAAppointment.jsp?referral_id="+refID+"&i_practitioner_id="+resourceId+"&patient_id="+patient_id+"&i_clinic_code="+clinicCode+"&recall_date=&locn_type="+careLocnTypeInd+"&specialty_code="+speciality+"&callingMode="+callingMode+"&from_page=Pending_referral&waitListNo=&resource_class=&clinic_code="+clinicCode+"&from_OR=N&from_AE=N&care_locn_ind="+careLocnTypeInd+"&recall_date="+preferDate+"&to_locn_desc="+to_locn_desc+"&resourcedesc="+resourcedesc;
			parent.parent.location.href =qryStr;
		}
		else
		{
			alert('Location Type is emergency and need to investigate for this case');
		}
	  }
}else{
		alert(getMessage('APP_NOT_APPL','OA'));
	   }

}

async function referralSourceLookup1(obj){
	
	var retVal			= new String();	

	var dialogTop			= "0px";
	var dialogHeight		= "400px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql1				= "";	
	var target=obj;
	
	var title=getLabel("Common.ReferredTo.label","common");	
	title=encodeURIComponent(title);
	var column_sizes = escape("10%,20%,20%,20%,20%");
	
	

	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);	

	var shortDesc=getLabel("Common.shortdescription.label","common");
	shortDesc=encodeURIComponent(shortDesc);
	
	var longDesc=getLabel("Common.longdescription.label","common");
	longDesc=encodeURIComponent(longDesc);

	var longname=getLabel("Common.longname.label","common");
	longname=encodeURIComponent(longname);

	var hlthcrsttyp="Healthcaresettingstype";

	var column_descriptions = code+","+shortDesc+","+longDesc+","+longname+","+hlthcrsttyp;
	
	var message = '';
	var facilityid=document.forms[0].facilityid.value;			
	var target=document.forms[0].source_display;
	var ref_type=document.forms[0].source_type.value;
	//var hcareType=parent.frames[1].document.forms[0].hcare_setting_type.value;
	var locale=document.forms[0].localeth.value;
	

	var sql = '';
	var param='';
	if(ref_type==''){
		var error= getMessage("CAN_NOT_BE_BLANK",'Common').replace('$','Referral Type')+ "\n" ;
		alert(error)
		document.forms[0].source_type.focus();
		document.forms[0].source.value="";

	}else{

		if(ref_type=='L'){
				//sql="select nvl(a.FACILITY_ID,'') referred_to_id,nvl(a.FACILITY_NAME,'') referred_to_id_desc ,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code,nvl(b.short_desc,'') hcare_setting_type_desc,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code from SM_FACILITY_PARAM_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = ? ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id=? and b.language_id=? and a.facility_id=? ";
				sql="select substr(a.facility_name,1,25) FACILITY_NAME, a.facility_id, 'X', b.short_desc hcare_setting_type_desc from sm_facility_param_lang_vw a,  am_hcare_setting_type_lang_vw b where a.hcare_setting_type_code = b.hcare_setting_type_code and a.facility_id = ? and a.language_id=? and b.language_id=?  ";

				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&locale="+locale+"&srch_by_clmn_index=2"+"&col_show_hide=YYNNN";

		}
		else if(ref_type=='X'){
				sql="select a.referral_code healthcare_setting_type,a.short_desc, a.long_desc health_care_type_desc,a.long_name source_desc from AM_REFERRAL_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW  b  where a.healthcare_setting_type = b.hcare_setting_type_code and a.eff_status='E' and a.language_id=? and b.language_id=? ";
				
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&locale="+locale+"&srch_by_clmn_index=3"+"&col_show_hide=YYYYN";

			}else if(ref_type=='E'){
				sql="select  a.facility_id,substr(a.facility_name,1,25) FACILITY_NAME, 'X', b.short_desc hcare_setting_type_desc  from sm_facility_param_lang_vw a, am_hcare_setting_type_lang_vw b where a.hcare_setting_type_code = b.hcare_setting_type_code and a.language_id=? and b.language_id=?  "
				
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&locale="+locale+"&srch_by_clmn_index=2"+"&col_show_hide=YYNNN";

			}
			retVal=await window.showModalDialog("../../eAM/jsp/ReferralSourceLookupFrames.jsp?calling_from=query&"+param,arguments,features);
				if(retVal){
					
					var ret_array = retVal.split("^~^");
				document.forms[0].source.value=ret_array[0];
             
				if(ref_type=='X'){
					document.forms[0].source_display.value=ret_array[2];
					
					document.forms[0].referral_source_lkp_bkup_text.value=ret_array[2];
				
				}else{
					
					document.forms[0].source_display.value=ret_array[1];
					document.forms[0].referral_source_lkp_bkup_text.value=ret_array[1];
				}

				if(ret_array[3] !='' && ref_type=='X' && ret_array[3] !='-select-'){			
					document.getElementById("lng_name").style.visibility="visible";
					document.getElementById("lng_name").alt=ret_array[3];

				}else{
					document.getElementById("lng_name").style.visibility="hidden";
				}
				//populateSource(document.forms[0].source_type);
		}
	}
	}


async function clear_ref1(){
	
	if(document.forms[0].source_display.value==''){
		if(document.forms[0].source_type.value == 'X')
		{
			document.forms[0].from_ext_practitioner_id.disabled=false; 
			document.getElementById("from_ext_practitioner_id").value="";
		//	if(document.getElementById("referred_from_practitioner_name").value !=''){
			document.getElementById("referred_from_practitioner_name").value="";
			document.getElementById("referred_from_practitioner").value="";
			document.forms[0].referred_from_practitioner_name.disabled=false;
			document.forms[0].search_pract.disabled=false;
	
		/*	if(document.getElementById("from_ext_practitioner_id").value !=''){
			 document.forms[0].referred_from_practitioner_name.disabled=true;
			document.forms[0].search_pract.disabled=true;
 
		    } */

   		}
		document.getElementById("lng_name").style.visibility="hidden";
		document.forms[0].source_display.value="";
		document.forms[0].source.value="";
		document.forms[0].referral_source_lkp_bkup_text.value="";

	}else{
		

		if(document.forms[0].referral_source_lkp_bkup_text.value != document.forms[0].source_display.value){
			
			await referralSourceLookup1(document.forms[0].referral_source_lkp_but)
		}
	}
	
	

}
function disable_criteria_pract(obj)
{
	
	if(document.forms[0].source_type.value=='X'){
		if(obj.value !='' ){
		document.forms[0].referred_from_practitioner_name.disabled=true;
        document.forms[0].search_pract.disabled=true;	
		}else{
		document.forms[0].referred_from_practitioner_name.disabled=false;
		document.forms[0].search_pract.disabled=false;	
		}
    
	}
}
function disable_criteria_ext_pract(obj)
{
	if(document.forms[0].source_type.value=='X'){
		if(obj.value !='')
		document.forms[0].from_ext_practitioner_id.disabled=true;
	    else
		document.forms[0].from_ext_practitioner_id.disabled=false;
	}
}

/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
function ComparePeriodCreatedFromToDate(from,to)
{
	var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
	
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(!isBefore(greg_frdt,greg_tdt,"DMY","en"))
		{
			var invaldt = getMessage("TO_DT_GR_EQ_FM_DT",'SM');
			var created_frm_date = getLabel("Common.createddate.label","Common")+" "+getLabel("Common.from.label","Common");
			var created_to_date = getLabel("Common.createddate.label","Common")+" "+getLabel("Common.to.label","Common");
			invaldt = invaldt.replace('From Date',created_frm_date);
			invaldt = invaldt.replace('To Date',created_to_date);
			alert(invaldt);
			document.forms[0].created_to_date.value="";
			//document.forms[0].created_to_date.focus();
			//document.forms[0].created_to_date.select();
		}
	}
}

function ComparePeriodPrefFromToDate(from,to)
{
	var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
	
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(!isBefore(greg_frdt,greg_tdt,"DMY","en"))
		{
			var invaldt = getMessage("TO_DT_GR_EQ_FM_DT",'SM');
			var pref_frm_date = getLabel("Common.PreferredDate.label","Common")+" "+getLabel("Common.from.label","Common");
			var pref_to_date = getLabel("Common.PreferredDate.label","Common")+" "+getLabel("Common.to.label","Common");
			invaldt = invaldt.replace('From Date',pref_frm_date);
			invaldt = invaldt.replace('To Date',pref_to_date);
			alert(invaldt);
			document.forms[0].pref_to_date.value="";
			document.forms[0].pref_to_date.focus();
			//document.forms[0].pref_to_date.select();
		}
	}
}
/*End MMS-DM-CRF-0187*/

