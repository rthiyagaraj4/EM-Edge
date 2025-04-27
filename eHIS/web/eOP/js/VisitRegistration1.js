
//Function from Visitregistrationapptrecds.jsp
 
function WaitList()
{
	 parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	parent.frames[1].document.forms[0].search.disabled=true;
	var nat_id_prompt; 
	patient_id=parent.frames[1].document.forms[0].pat_id1.value;
	nationality_id=parent.frames[1].document.forms[0].nationality_id.value;
	var URL="";
	if(parent.frames[1].document.forms[0].national_id_no)
	URL+="&NRICNo="+escape(parent.frames[1].document.forms[0].national_id_no.value);
	if(parent.frames[1].document.forms[0].name_prefix)
	URL+="&name_prefix="+escape(parent.frames[1].document.forms[0].name_prefix.value);
	if(parent.frames[1].document.forms[0].other_alt_type)
	{
	URL+="&otherAlternateIDType="+escape(parent.frames[1].document.forms[0].other_alt_type.value);
	URL+="&otherAlternateIDNo="+escape(parent.frames[1].document.forms[0].other_alt_Id.value);
	}
	if(parent.frames[1].document.forms[0].alt_id1_no)
	URL+="&alternateIDNo1="+escape(parent.frames[1].document.forms[0].alt_id1_no.value);

	if(parent.frames[1].document.forms[0].alt_id2_no)
	URL+="&alternateIDNo2="+escape(parent.frames[1].document.forms[0].alt_id2_no.value);

	if(parent.frames[1].document.forms[0].alt_id3_no)
	URL+="&alternateIDNo3="+escape(parent.frames[1].document.forms[0].alt_id3_no.value);

	if(parent.frames[1].document.forms[0].alt_id4_no)
	URL+="&alternateIDNo4="+escape(parent.frames[1].document.forms[0].alt_id4_no.value);
    
	if(parent.frames[1].document.forms[0].r_area)
	 {
	var r_area=parent.frames[1].document.forms[0].r_area.value;
	 
	 }

	if(parent.frames[1].document.forms[0].m_area)
	{
	var m_area=parent.frames[1].document.forms[0].m_area.value;
	}
	if(parent.frames[1].document.forms[0].r_region)
	{
	var r_region=parent.frames[1].document.forms[0].r_region.value;
	}
	if(parent.frames[1].document.forms[0].m_region)
    {
    var m_region=parent.frames[1].document.forms[0].m_region.value;
	}
	if(parent.frames[1].document.forms[0].r_town)
    {
	var r_town=parent.frames[1].document.forms[0].r_town.value;
    }
	if(parent.frames[1].document.forms[0].m_town)
    {
	var m_town=parent.frames[1].document.forms[0].m_town.value;
   } 
    
	var specCode=parent.frames[1].document.forms[0].speciality.value;
    var wait_list_priority=parent.frames[1].document.forms[0].priority.value; 
	
	var oper_stn_id=parent.frames[1].document.forms[0].oper_stn_id.value; 
   var oa_install_yn=parent.frames[1].document.forms[0].oa_install_yn.value;
	var or_install_yn=parent.frames[1].document.forms[0].or_install_yn.value;
    var functionId=parent.frames[1].document.forms[0].functionId.value;
    
	var wait_list_inv=parent.frames[1].document.forms[0].wait_list_inv.value;
    
	var category=parent.frames[1].document.forms[0].category_code.value;
	
	var WaitListNo = parent.frames[1].document.forms[0].WaitListNo.value ;
    var waitlist_fromdate=parent.frames[1].document.forms[0].frmDate.value;
	var waitlist_todate=parent.frames[1].document.forms[0].ToDate.value;
    var build_episode_rule=parent.frames[1].document.forms[0].build_episode_rule.value;
    var bl_interface_yn=parent.frames[1].document.forms[0].bl_interface_yn.value;
    var emer_regn_allow_yn=parent.frames[1].document.forms[0].emer_regn_allow_yn.value;
	if(parent.frames[1].document.forms[0].nat_id_prompt)
		nat_id_prompt=parent.frames[1].document.forms[0].nat_id_prompt.value

	 if(waitlist_fromdate!="" && waitlist_todate!="")	 
		{
			if(isBefore(waitlist_fromdate,waitlist_todate,'DMY',localeName)==false)
			{
				alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'))
				parent.frames[1].document.forms[0].ToDate.select();				
				return false;
			}
		} 
 	    if(waitlist_fromdate!="")
		waitlist_fromdate=convertDate(waitlist_fromdate,"DMY",localeName,"en");
		if(waitlist_todate!="")
		waitlist_todate=convertDate(waitlist_todate,"DMY",localeName,"en");

		var locn_type;
		if(document.forms[0].locn_type)
			locn_type = document.forms[0].locn_type.value;			

		var clinic_code;
		if(document.forms[0].clinic_code)
			clinic_code= document.forms[0].clinic_code.value;

		var accept_dis_inv_no;
		if(document.forms[0].accept_dis_inv_no)
			accept_dis_inv_no = document.forms[0].accept_dis_inv_no.value;		
		parent.patient_sub3.location.href="../../eOP/jsp/VisitRegistrationQueryResult.jsp?oper_stn_id="+oper_stn_id+"&oa_install_yn="+oa_install_yn+"&or_install_yn="+or_install_yn+"&function_id="+functionId+"&Patient="+patient_id+"&nationality_id="+nationality_id+"&r_area="+r_area+"&m_area="+m_area+"&r_region="+r_region+"&m_region="+m_region+"&r_town="+r_town+"&m_town="+m_town+"&specCode="+specCode+"&wait_list_priority="+wait_list_priority+"&wait_list_inv="+wait_list_inv+"&category="+category+"&WaitListNo="+WaitListNo+"&waitlist_fromdate="+waitlist_fromdate+"&waitlist_todate="+waitlist_todate+"&nat_id_prompt="+nat_id_prompt+"&build_episode_rule="+build_episode_rule+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&bl_interface_yn="+bl_interface_yn+URL+"&clinic_type="+locn_type+"&clinic_code="+clinic_code+"&accept_dis_inv_no="+accept_dis_inv_no;
		
	    
 
}

//Included multi_speciality_yn for the CRF - Bru-HIMS-CRF - 0198
//isPractoApptYn Added by Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446]
async function tab_click_add_visitapptrecds(patient,q_clinic_code,q_practitioner_id,q_appt_ref_no,q_visit_adm_type_ind,q_visit_adm_type,q_room_num,resource_class,ordering_facility_id,order_id,order_line_num,order_type_code,order_catalog_code,order_catalog_desc,referral_id,referral_reg_yn,fromchk,recur_wo_sec_res,cur_appt_ref_no,oper_stn_id,functionId,contact_reason_code,reason,locn_type,service_code,Rpractitioner_name,visit_for_inpat_yn,q_appt_time,multi_speciality_yn,appointment_flag,isPractoApptYn)
{
	
/*Above line modified for this incident [52415]*/ 
  var nat_id_prompt;
  bl_interface_yn=document.forms[0].bl_interface_yn.value;
  build_episode_rule=document.forms[0].build_episode_rule.value;
  oa_install_yn=document.forms[0].oa_install_yn.value;
  function_id=parent.frames[1].document.forms[0].functionId.value;
  if(parent.frames[1].document.forms[0].nat_id_prompt)
	nat_id_prompt=parent.frames[1].document.forms[0].nat_id_prompt.value;
  or_install_yn=document.forms[0].or_install_yn.value;
  emer_regn_allow_yn=document.forms[0].emer_regn_allow_yn.value;
  
  oper_stn_id=document.forms[0].oper_stn_id.value;
  register_visit_walkin=document.forms[0].register_visit_walkin.value;
  register_visit_referral=document.forms[0].register_visit_referral.value;
//  contact_reason_code=document.forms[0].contact_reason_code.value;
   
 // reason=document.forms[0].reason.value;
 if(parent.frames[1].document.forms[0].pat_id1!=null)
 parent.frames[1].document.forms[0].pat_id1.value=patient;
 if(parent.frames[1].document.forms[0].referal_id1!=null)
 parent.frames[1].document.forms[0].referal_id1.value=referral_id;
 // parent.frames[1].document.forms[0].pat_id1.readOnly=true;
 /*Above line commented and belwo line Added for this SCF MMS-SCF-0105 [IN:043502]*/
 if(!parent.frames[1].document.forms[0].pat_id1.disabled)
 parent.frames[1].document.forms[0].pat_id1.disabled=true;
 
 parent.frames[1].document.forms[0].referal_id1.readOnly=true;
 if(parent.frames[1].document.forms[0].national_id_no!=null)
  parent.frames[1].document.forms[0].national_id_no.readOnly=true;
  if(parent.frames[1].document.forms[0].other_alt_type!=null)
 parent.frames[1].document.forms[0].other_alt_type.disabled=true;
  if(parent.frames[1].document.forms[0].alert_reqd_yn!=null)
 parent.frames[1].document.forms[0].alert_reqd_yn.readOnly=true;
 if(parent.frames[1].document.forms[0].alt_id1_no!=null)
 parent.frames[1].document.forms[0].alt_id1_no.readOnly=true;
  if(parent.frames[1].document.forms[0].referal_id1!=null)
 parent.frames[1].document.forms[0].referal_id1.readOnly=true;
  if(parent.frames[1].document.forms[0].alt_id2_no!=null)
 parent.frames[1].document.forms[0].alt_id2_no.readOnly=true;
  if(parent.frames[1].document.forms[0].alt_id3_no!=null)
 parent.frames[1].document.forms[0].alt_id3_no.readOnly=true;
    if(parent.frames[1].document.forms[0].alt_id4_no!=null)
 parent.frames[1].document.forms[0].alt_id4_no.readOnly=true;
if(parent.frames[1].document.forms[0].srch!=null)
 parent.frames[1].document.forms[0].srch.disabled=true;
if(parent.frames[1].document.forms[0].ref_id_search!=null)
 parent.frames[1].document.forms[0].ref_id_search.disabled=true;
 parent.frames[1].document.forms[0].srch_code.disabled=true;
 parent.frames[1].document.forms[0].clear1.disabled=true; 

 //Added for this incident [52415] 
 if(parent.frames[1].document.forms[0].appt_refno_flag!=null && q_appt_ref_no!="")
   parent.frames[1].document.forms[0].appt_refno_flag.value=q_appt_ref_no;
 var blflag_op_yn=parent.frames[1].document.forms[0].blflag_op_yn.value;
if(parent.frames[1].document.forms[0].appt_service_code!=null) 
parent.frames[1].document.forms[0].appt_service_code.value=service_code;// Added for this incident[52513]
 var call_from="";//Added for this incident [52415]
 if(document.forms[0].call_from)
	call_from = document.forms[0].call_from.value;

query_string= parent.frames[0].document.forms[0].query_string.value;
 
 if(referral_id != "" && referral_reg_yn == "N")
	{
		var error = getMessage("REFERRAL_REG_NOT_ALLOWED","OP");
		alert(error);
	    return false; 
	}
	
	
	var patFlag="N";

	if (patient == null || patient=="null" || patient=='')
	{
		 var patient=await show_patwindowReferral(q_clinic_code,q_appt_ref_no,referral_id); 		
		 patFlag=patient.charAt(0);
		 if(patFlag=="Y")
			patient=patient.substring(1,patient.length);
		else if(patFlag=="N")
			patient=patient.substring(1,pat_id.length); 
	}

	if((patient == null) ||(patient=='O')||(patient=='C')||(patient == ''))
	{
		window.close();
		parent.frames[3].document.location.reload();
	}else{	

		var function_id="";
		var menu_function_id = functionId;
		
		if(locn_type == 'C')
		{
			function_id = "VISIT_REGISTRATION";
		}
		else if(locn_type == 'E')
		{
			function_id = "PROCD_REGISTRATION";
		}	
		/*Below line Added for this CRF  Bru-HIMS-CRF-165.1 [IN:035659]*/
			var appt_order="";
			if(q_appt_ref_no!=""){
				appt_order="AppointmentOrder";
			}	
 
		 parent.frames[3].document.location.href='../../eOP/jsp/VisitRegistrationResult.jsp?patient='+patient+"&q_appt_ref_no="+q_appt_ref_no+"&referral_id="+referral_id+"&q_clinic_code="+q_clinic_code+"&q_visit_adm_type="+q_visit_adm_type+"&q_practitioner_id="+q_practitioner_id+"&q_practitioner_id1="+q_room_num+"&q_visit_adm_type_ind=R"+"&build_episode_rule="+build_episode_rule+"&bl_interface_yn="+bl_interface_yn+"&oa_install_yn="+oa_install_yn+"&oper_stn_id="+oper_stn_id+"&functionId="+function_id+"&menu_function_id="+menu_function_id+"&or_install_yn="+or_install_yn+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&nat_id_prompt="+nat_id_prompt+"&contact_reason_code="+contact_reason_code+"&reason="+encodeURIComponent(reason)+"&patFlag="+patFlag+"&query_String="+encodeURIComponent(query_string)+"&service_code="+service_code+"&call_from="+call_from+"&locn_ind="+locn_type+ "&resource_class="+resource_class+"&Rpractitioner_name="+Rpractitioner_name+"&visit_for_inpat_yn="+visit_for_inpat_yn+"&q_appt_time="+q_appt_time+"&multi_speciality_yn="+multi_speciality_yn+"&blflag_op_yn="+blflag_op_yn+"&isPractoApptYn="+isPractoApptYn;//modified for the CRF - Bru-HIMS-CRF-0198
		  parent.frames[4].document.location.href='../../eOP/jsp/VisitRegistrationApptRecds.jsp?patient_id='+patient+"&cur_appt_ref_no="+q_appt_ref_no+"&referral_id="+referral_id+"&bl_interface_yn="+bl_interface_yn+"&oa_install_yn="+oa_install_yn+"&oper_stn_id="+oper_stn_id+"&function_id="+menu_function_id+"&or_install_yn="+or_install_yn+"&register_visit_walkin="+register_visit_walkin+"&register_visit_referral="+register_visit_referral+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&nat_id_prompt="+nat_id_prompt+"&patFlag="+patFlag+"&call_from="+call_from+"&visit_for_inpat_yn="+visit_for_inpat_yn;

		 
	
	}

}

function alignHeading1()
{
	if(document.getElementById('th_table') != null)
	{				
		for (j=0; j < document.getElementById('tb1').rows(1).cells.length; j++)
		{			
			var wid=eval(document.getElementById('tb1').rows(1).cells(j).offsetWidth);			
			if(document.getElementById('th_table').rows(0).cells(j) != null)
			{								
				var  wid1 = eval(document.getElementById('th_table').rows(0).cells(j).offsetWidth);
				if(wid1<wid)
				{						
					document.getElementById('th_table').rows(0).cells(j).width=wid;
				}
				else
				{								
					document.getElementById('tb1').rows(1).cells(j).width=eval(document.getElementById('th_table').rows(0).cells(j).offsetWidth);					
				}
			
			}
			
		}
		document.getElementById('th_table').width =	eval(document.getElementById('tb1').offsetWidth);
		document.getElementById('TitleTab').width =	eval(document.getElementById('tb1').offsetWidth);
	}
}

function scrollTitle()
{
	var x = document.body.scrollTop;
	if(x == 0)
	{
		document.getElementById('divTitleTable').style.position = 'static';
		document.getElementById('divTitleTable').style.posTop  = 0;
    
		document.getElementById('head1').style.position='static';
		document.getElementById('head1').style.posTop  = 0;
		document.getElementById('head2').style.position='static';
		document.getElementById('head2').style.posTop  = 0;
		document.getElementById('head3').style.position='static';
		document.getElementById('head3').style.posTop  = 0;
		document.getElementById('head4').style.position='static';
		document.getElementById('head4').style.posTop  = 0;
		document.getElementById('head5').style.position='static';
		document.getElementById('head5').style.posTop  = 0;
		document.getElementById('head6').style.position='static';
		document.getElementById('head6').style.posTop  = 0;
		document.getElementById('head7').style.position='static';
		document.getElementById('head7').style.posTop  = 0;

		document.getElementById('head8').style.position='static';
		document.getElementById('head8').style.posTop  = 0;
		document.getElementById('head9').style.position='static';
		document.getElementById('head9').style.posTop  = 0;  
  
	}
	else
	{
		document.getElementById('divTitleTable').style.position = 'relative';
		document.getElementById('divTitleTable').style.posTop  = x-2;
		  
		document.getElementById('head1').style.position = 'relative';
		document.getElementById('head1').style.posTop  = x-2;
		document.getElementById('head2').style.position = 'relative';
		document.getElementById('head2').style.posTop  = x-2;
		document.getElementById('head3').style.position = 'relative';
		document.getElementById('head3').style.posTop  = x-2;
		document.getElementById('head4').style.position = 'relative';
		document.getElementById('head4').style.posTop  = x-2;
		document.getElementById('head5').style.position = 'relative';
		document.getElementById('head5').style.posTop  = x-2;
		document.getElementById('head6').style.position = 'relative';
		document.getElementById('head6').style.posTop  = x-2;
		document.getElementById('head7').style.position = 'relative';
		document.getElementById('head7').style.posTop  = x-2;
	
		document.getElementById('head8').style.position = 'relative';
		document.getElementById('head8').style.posTop  = x-2;
		document.getElementById('head9').style.position = 'relative';
		document.getElementById('head9').style.posTop  = x-2;
	}
}

//JS functions used in Check in Criteria.jsp

/*function CheckChars(Obj){
        var str = Obj
        var asciiCharsExist = true;
        for (u=0;u<str.length;u++){
            if ((str.charCodeAt(u)>=0) && (str.charCodeAt(u)<=127));
            else{
                asciiCharsExist = false;
                break;
            }
        }
        return asciiCharsExist;
    }*/

function localLang(obj)
{
if(obj.checked==true)
	{
	obj.value="Y";
	}
else
	{
	obj.value="N";
	}
}

function image_clickappt(objName)
{
	  
	parent.document.getElementById("patient_main").style.height = '4vh';
	parent.document.getElementById("patient_sub").style.height = '40vh';
	parent.document.getElementById("patient_sub").scrolling = "auto";
	parent.document.getElementById("patient_sub2").style.height = '0vh';//12vh
	parent.document.getElementById("patient_sub3").style.height = '45vh';//53vh
	parent.document.getElementById("patient_sub4").style.height = '10vh';//12vh
	
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
     //  var srchbyascii="";
		var srchbyascii="N"; //modified by Srinivas  for  Incident NO: 33057
		parent.frames[1].document.forms[0].search.disabled=true;
		// FIRST CHANGE THE CURRENT SELECTED TAB

		var where_clause ="";
		var name_params = "";

		where_clause = construct_where_clause();

		var oper_stn_id= parent.frames[1].document.getElementById("oper_stn_id").value;

		/*Below lines modified by Venkatesh.S on 15/Feb/2013 against CHL-SCF-0013 [IN035559] */
		if( parent.frames[1].document.getElementById("first_name") !=null)
			{
		               
					if( trimCheck(parent.frames[1].document.getElementById('first_name').value))					   
							 name_params = name_params + "&first_name="+encodeURIComponent(makeValidQueryString(parent.frames[1].document.getElementById('first_name').value));
			}

		
		if( parent.frames[1].document.getElementById("second_name") !=null)
		{     
			if( trimCheck(parent.frames[1].document.getElementById("second_name").value))			
				 name_params = name_params + "&second_name="+encodeURIComponent(makeValidQueryString(parent.frames[1].document.getElementById("second_name").value));
		}

		
		if( parent.frames[1].document.getElementById("third_name") !=null)
		{       
           		
			if( trimCheck(parent.frames[1].document.getElementById("third_name").value))			
				name_params = name_params + "&third_name="+encodeURIComponent(makeValidQueryString(parent.frames[1].document.getElementById("third_name").value));
		}
		
		if( parent.frames[1].document.getElementById("family_name") !=null)
		{    
		 
			if( trimCheck(parent.frames[1].document.getElementById("family_name").value))			
				  name_params = name_params + "&family_name="+encodeURIComponent(makeValidQueryString(parent.frames[1].document.getElementById("family_name").value));
		}
		/* end CHL-SCF-0013 [IN035559] */
          build_episode_rule=parent.frames[1].document.forms[0].build_episode_rule.value;	  
		 
		 bl_interface_yn=parent.frames[1].document.forms[0].bl_interface_yn.value;	  
		 oa_install_yn=parent.frames[1].document.forms[0].oa_install_yn.value;
		
			or_install_yn=parent.frames[1].document.forms[0].or_install_yn.value;
			
			functionId=parent.frames[1].document.forms[0].functionId.value;
			register_visit_walkin=parent.frames[1].document.forms[0].register_visit_walkin.value;
			register_visit_referral=parent.frames[1].document.forms[0].register_visit_referral.value;
			emer_regn_allow_yn=parent.frames[1].document.forms[0].emer_regn_allow_yn.value;
			if(parent.frames[1].document.forms[0].local_lang)
				srchbyascii=parent.frames[1].document.forms[0].local_lang.value;

		var nat_id_prompt;
		if(parent.frames[1].document.forms[0].nat_id_prompt)
			nat_id_prompt = parent.frames[1].document.forms[0].nat_id_prompt.value

		var locn_type;
		if(document.forms[0].locn_type)
			locn_type = document.forms[0].locn_type.value

		var accept_dis_inv_no;
		if(document.forms[0].accept_dis_inv_no)
			accept_dis_inv_no = document.forms[0].accept_dis_inv_no.value;
		/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
		
		var URL="../../eOP/jsp/VisitRegistrationQueryResult.jsp?where_clause="+where_clause+name_params+"&oper_stn_id="+oper_stn_id+"&FromSerach=Y&Patient="+escape(parent.frames[1].document.forms[0].pat_id1.value)+"&nat_id_prompt="+encodeURIComponent(nat_id_prompt)+"&nationality_id="+parent.frames[1].document.forms[0].nationality_id.value+"&oa_install_yn="+oa_install_yn+"&or_install_yn="+or_install_yn+"&function_id="+functionId+"&build_episode_rule="+build_episode_rule+"&bl_interface_yn="+bl_interface_yn+"&register_visit_walkin="+register_visit_walkin+"&register_visit_referral="+register_visit_referral+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&upt_contact_dtls_oa_yn="+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"&srchbyascii="+srchbyascii+"&clinic_type="+locn_type+"&accept_dis_inv_no="+accept_dis_inv_no;

		/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
		if(parent.frames[1].document.forms[0].extApptOnly){
			var exrApptVal	= "N";
			if(parent.frames[1].document.forms[0].extApptOnly.checked == true)
				exrApptVal = "Y"
			
			URL+="&extApptOnly="+exrApptVal;
		}
		
		if(parent.frames[1].document.forms[0].isPractoApptApplYN)
			URL+="&isPractoApptApplYN="+escape(parent.frames[1].document.forms[0].isPractoApptApplYN.value);
		/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/

		/*Added ByLakshmanan  on 17mar2023 against ML-MMOH-CRF-1930 US007 Start*/
		if(parent.frames[1].document.forms[0].virtualConsultVisit){
			var virtualConsultVisit	= "N";
			if(parent.frames[1].document.forms[0].virtualConsultVisit.checked == true)
				virtualConsultVisit = "Y"
			URL+="&virtualConsultVisit="+virtualConsultVisit;
		}
		if(parent.frames[1].document.forms[0].isVirtualConsultationVisit)
			URL+="&isVirtualConsultationVisit="+escape(parent.frames[1].document.forms[0].isVirtualConsultationVisit.value);
		
		/* ML-MMOH-CRF-1930 US007 end*/
		
		if(parent.frames[1].document.forms[0].national_id_no)
			URL+="&NRICNo="+escape(parent.frames[1].document.forms[0].national_id_no.value);

		if(parent.frames[1].document.forms[0].name_prefix)
			URL+="&name_prefix="+escape(parent.frames[1].document.forms[0].name_prefix.value);

		
		if(parent.frames[1].document.forms[0].other_alt_type)
		{
			URL+="&otherAlternateIDType="+escape(parent.frames[1].document.forms[0].other_alt_type.value);

			URL+="&otherAlternateIDNo="+escape(parent.frames[1].document.forms[0].other_alt_Id.value);
		}
		
		if(parent.frames[1].document.forms[0].alt_id1_no)
			URL+="&alternateIDNo1="+escape(parent.frames[1].document.forms[0].alt_id1_no.value);

		if(parent.frames[1].document.forms[0].alt_id2_no)
			URL+="&alternateIDNo2="+escape(parent.frames[1].document.forms[0].alt_id2_no.value);

		if(parent.frames[1].document.forms[0].alt_id3_no)
			URL+="&alternateIDNo3="+escape(parent.frames[1].document.forms[0].alt_id3_no.value);

		if(parent.frames[1].document.forms[0].alt_id4_no)
			URL+="&alternateIDNo4="+escape(parent.frames[1].document.forms[0].alt_id4_no.value);
		
		parent.patient_sub3.location.href = URL;
//Added by Ashwin K for AAKH-CRF-0150
	if(document.getElementById('AddVisit_EmiratesID_edit'))
	{
	$("#national_id_no").prop('disabled', true);
	$('#AddVisit_EmiratesID_edit').prop('checked', false);
	$("#M_btn2").prop('disabled', false);

	}
//Ended by Ashwin K for AAKH-CRF-0150
}

function clear_all()
        { 
			 parent.frames[1].document.forms[0].reset();
		     parent.frames[2].location.href = "../../eCommon/html/blank.html";
			 parent.frames[3].location.href = "../../eCommon/html/blank.html";
            //if(document.getElementById('hdr_tab') != null){document.getElementById('hdr_tab').style.visibility='hidden'; }           
        parent.frames[1].document.getElementById('search').disabled=false;
		}

async function onBlurCallPractitionerSearch(obj,target_name)
 {
		 target_name.value = trimString(target_name.value);
		 
		 if(target_name.value == "")
			{
			 
			document.forms[0].practitioner_id.value="";
			 document.forms[0].pract_name.value="";
			 return;
			}

			await callPractSearch(obj,target_name);
 }


async function callPractSearch(obj,target)
	{
 			var practName_FName="";
			var practName_FValue="";
			var practId_FName="";
			
			var facilityid =document.forms[0].facilityid.value;
			var locale=document.forms[0].locale.value;
	    
			target.value=trimString(target.value);
			
			practName_FName=target.name;
			practName_FValue=target.value;

			var sql="";
			var sqlsec="";

			await getPractitioner(obj,target,facilityid,'','','','','','','',"Q2");

			/*
			sql ="SELECT   DISTINCT a.practitioner_id  practitioner_id,  a.practitioner_name practitioner_name ,  am_get_desc.am_pract_type(a.pract_type,'"+locale+"',1)practitioner_type ,  am_get_desc.am_speciality(a.primary_speciality_code,'"+locale+"',2) primary_specialty,  DECODE(a.gender,  'M',  'Male',  'F',  'Female', 'U',  'Unknown') gender,  a.position_code job_title FROM   am_practitioner_lang_vw a,  am_pract_for_facility d WHERE  a.language_id='"+locale+"'AND   a.pract_type LIKE (?)  AND  a.primary_speciality_code LIKE UPPER(?)  AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND  (a.position_code LIKE (?) OR a.position_code IS NULL) AND  a.practitioner_id=d.practitioner_id AND  d.eff_status='E' AND  d.facility_id='"+facilityid+"' ";


				//sql = " SELECT   distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c,am_pract_for_facility d WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and a.practitioner_id=d.practitioner_id and d.eff_status='E' and d.facility_id='"+facilityid+"' ";
				
				sqlsec="SELECT   DISTINCT a.practitioner_id  practitioner_id,  a.practitioner_name practitioner_name ,  am_get_desc.am_pract_type(a.pract_type,'"+locale+"',1)practitioner_type ,  am_get_desc.am_speciality(a.primary_speciality_code,'"+locale+"',2) primary_specialty,  DECODE(a.gender,  'M',  'Male',  'F',  'Female', 'U',  'Unknown') gender,  a.position_code job_title FROM   am_practitioner_lang_vw a,  am_pract_for_facility d WHERE  a.language_id='"+locale+"'AND   a.pract_type LIKE (?)  AND  a.primary_speciality_code LIKE UPPER(?)  AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND  (a.position_code LIKE (?) OR a.position_code IS NULL) AND  a.practitioner_id=d.practitioner_id AND  d.eff_status='E' AND  d.facility_id='"+facilityid+"' ";
			
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr += " practName_FName=\"" + practName_FName + "\"";
			xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
			xmlStr += " sql=\"" +escape(sql)+"\"";
			xmlStr += " sqlSec=\"" +escape(sqlsec)+"\"";
			xmlStr += " practitioner_type=\"" + "" + "\"";
			xmlStr += " specialty_code=\"" + "" + "\"";
			xmlStr += " job_title=\"" + "" + "\"";
			xmlStr += " gender=\"" + "" + "\"";			
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);*/
	
		}

/*	function PractLookupRetVal(retVal,objName)
	{  							
				
			
	}*/




async function selectNationality1(desc,code)
{
	if(desc.value == "")
	{desc.value="";
	 code.value="";
	
	return ;
	}
await selectNationality(desc,code)

}

async function selectNationality(desc,code)
{
			tar=desc.value
		
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel('Common.nationality.label','Common')	
		functionId=document.forms[0].functionId.value
		//facility_id=document.forms[0].Facility_Id.value
		oper_stn_id=document.forms[0].oper_stn_id.value
		var locale=document.forms[0].locale.value;
		
		sql="select Country_Code code,long_desc description from Mp_Country_lang_vw where  language_id='"+locale+"' and eff_status='E'   and upper(Country_Code) like upper(?) and upper(long_desc) like upper(?) and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 2"	
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = tar;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		  {
			
		    var ret1=unescape(retVal);
			
			arr=ret1.split(",");
			
			desc.value=arr[1];
			code.value=arr[0];
    
		
			}else
		{
		desc.value="";
		code.value="";
		}
}

	function clearList() 
	{
		document.forms[0].clinic_desc.value = "";
		document.forms[0].clinic_code.value = "";

	}

	function clearLocnVal(obj) {
		
        if(obj.value=='C') {
			document.forms[0].pat_class.disabled=true;
			document.forms[0].functionId.value = 'VISIT_REGISTRATION';	
		} else if(obj.value=='E'){
			document.forms[0].pat_class.disabled=false;
			document.forms[0].functionId.value = 'PROCD_REGISTRATION';
		} 		
		
		if(document.forms[0].assign_care_locn_code) {			
			clearAll();
			ClearList(document.forms[0].assign_care_locn_code);		
		}	
	}
	
	async function selectClinic(desc,code)
	{
		tar=desc.value
		var locale=document.forms[0].locale.value;
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel('Common.Location.label','Common')
		functionId=document.forms[0].functionId.value
		facility_id=document.forms[0].facilityid.value
		oper_stn_id=document.forms[0].oper_stn_id.value
		var locn_type = document.forms[0].locn_type.value;

		sql="select clinic_code code,long_desc description from op_clinic_lang_vw where facility_id ='"+facility_id+"' and eff_status='E'  and language_id='"+locale+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and clinic_code in(select a.clinic_code from op_clinic a, am_locn_for_oper_stn b where a.facility_id='"+facility_id+"' and a.allow_appt_yn='Y' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.level_of_care_ind='A' and a.rd_appl_yn='N' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E')"	

		if(locn_type == 'C')
		{
			sql=sql+"  and care_locn_type_ind = 'C' order by 2"
		}
		else if(locn_type == 'E')
		{
			sql=sql+"  and care_locn_type_ind = 'E' order by 2"
		}
		else {
			sql=sql+" order by 2";
		}

		/*
		if(functionId=="VISIT_REGISTRATION")
		{
					sql=sql+"  and care_locn_type_ind ='C'  order by 2"
		}
		else if(functionId=="PROCD_REGISTRATION")
		{
			 sql=sql+"   and care_locn_type_ind ='E' order by 2";
		}else
		{
		sql=sql+" order by 2";
		}
		*/

		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = tar;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		  {
			
		    var ret1=unescape(retVal);
			
			arr=ret1.split(",");
			
			desc.value=arr[1];
			code.value=arr[0];
       
			}else
		{
		desc.value="";
		code.value="";
		}
				
	
	}

async function selectClinic1(desc,code)
{
	if(desc.value == "")
	{desc.value="";
	 code.value="";
	
	return ;
	}
await selectClinic(desc,code)

}

	
	function PractEnableDisable(Obj)
		{
			if(Obj.value != "")
			{
				visit_regn_checkin_criteria.practitioner_id.value = "";
				visit_regn_checkin_criteria.pract_name.value = "";
				visit_regn_checkin_criteria.pract_name.readOnly = false;
				if(visit_regn_checkin_criteria.pract_butt!=null)
				visit_regn_checkin_criteria.pract_butt.disabled = false;
			}
			else
			{
				visit_regn_checkin_criteria.practitioner_id.value = "";
				visit_regn_checkin_criteria.pract_name.value = ""; 
				visit_regn_checkin_criteria.pract_name.readOnly = true;
				if(visit_regn_checkin_criteria.pract_butt!=null)
				visit_regn_checkin_criteria.pract_butt.disabled = true;				
			}
		}
		
  function temp()
  {
  }

  //Added by Ashwin K for AAKH-CRF-0150
  async function getPatID_Mbtn(contact_no)
  { 
 	 var func_id=parent.frames[1].document.forms[0].functionId.value;
	if(parent.frames[1].document.forms[0].pat_id1.value=="")
	  {
		if (document.forms[0].wait_list_inv.value=="")
		{	   
		if(func_id == "VISIT_REGISTRATION")
		{
			pat_id=await PatientSearch('','','','','','','','Y','Y','Visitreg','','AdvanceTab','','','',contact_no);
    		if(pat_id != null)
			{
			patFlag=pat_id.charAt[0];
			 if(patFlag=="Y")
			 patientID=pat_id.substring(1,pat_id.length);
	         else if(patFlag=="N")
			  patientID=pat_id.substring(0,pat_id.length); 			
		     else
				patientID=pat_id	;	
			//if(patFlag == 'Y')
			//{
				//var patientID=pat_id.substring(1,pat_id.length);				
				document.getElementById("pat_id1").value = patientID 
                 if(document.getElementById("srch_code")!=null)   
				document.getElementById("srch_code").click()
				}
		}
		else if(func_id == "PROCD_REGISTRATION")
		{
			pat_id=await PatientSearch('','','','','','','','Y','Y','','','AdvanceTab','','','',contact_no);		
			if( pat_id != null )
              {
               patFlag=pat_id.charAt(0);
			 if(patFlag=="Y")
              patientID=pat_id.substring(1,pat_id.length);
	           else if(patFlag=="N")
	          patientID=pat_id.substring(0,pat_id.length); 			
			else
				patientID=pat_id;		
				document.getElementById('pat_id1').value = patientID 
                 if(document.getElementById('srch_code')!=null)   
				document.getElementById('srch_code').click()
				}
		}
		else if(func_id == "PROCD_REGISTRATION")
		{
			pat_id=PatientSearch('','','','','','','','Y','Y','','','AdvanceTab','','','',contact_no);		
			if( pat_id != null )
              {
               patFlag=pat_id.charAt(0);
			 if(patFlag=="Y")
              patientID=pat_id.substring(1,pat_id.length);
	           else if(patFlag=="N")
	          patientID=pat_id.substring(0,pat_id.length); 			
			else
				patientID=pat_id;		
				document.getElementById('pat_id1').value = patientID 
                 if(document.getElementById('srch_code')!=null)   
				document.getElementById('srch_code').click()
				}

			}
		}
	else{
		pat_id=await PatientSearch('','','','','','','','','','','','AdvanceTab','','','',contact_no);		
		if( pat_id != null )
              {
                document.getElementById('pat_id1').value = pat_id 
                 if(document.getElementById('srch_code')!=null)   
				document.getElementById('srch_code').click()

				}
		}	
	}
  }
  //Ended by Ashwin K for AAKH-CRF-0150
  async function getPatID()
  {
 	 	var func_id=parent.frames[1].document.forms[0].functionId.value;
	if(parent.frames[1].document.forms[0].pat_id1.value==""||document.forms[0].wait_list_inv.value=="Y"||document.forms[0].wait_list_inv.value=="N")
	  {
	  
	  
	 
	
	if (document.forms[0].wait_list_inv.value==""&&document.forms[0].register_pat_yn.value=="Y")
	{	   
		if(func_id == "VISIT_REGISTRATION")
		{
			var pat_id=await PatientSearch('','','','','','','','Y','Y','Visitreg');
			    
				if(pat_id != null)
			{
				
			 patFlag=pat_id.charAt(0);
			 if(patFlag=="Y")
			 patientID=pat_id.substring(1,pat_id.length);
	         else if(patFlag=="N")
			  patientID=pat_id.substring(0,pat_id.length); 			
		     else
				patientID=pat_id	;	
			//if(patFlag == 'Y')
			//{
				//var patientID=pat_id.substring(1,pat_id.length);				
				document.getElementById('pat_id1').value = patientID 
                 if(document.getElementById('srch_code')!=null)   
				document.getElementById('srch_code').click()
				
				//document.getElementById("pat_id1").blur();
			//}	
				}
		}
		else if(func_id == "PROCD_REGISTRATION")
		{
			pat_id=await PatientSearch('','','','','','','','Y','Y','ProcdReg');
			
			if( pat_id != null )
              {
               patFlag=pat_id.charAt(0);
			 
			 if(patFlag=="Y")
              patientID=pat_id.substring(1,pat_id.length);
	           else if(patFlag=="N")
	          patientID=pat_id.substring(0,pat_id.length); 			
			else
				patientID=pat_id;		
			//if(patFlag == 'Y')
			//{
				//var patientID=pat_id.substring(1,pat_id.length);
				document.getElementById('pat_id1').value = patientID 
				//document.getElementById('pat_id1').value = pat_id 
                 if(document.getElementById('srch_code')!=null)   
				document.getElementById('srch_code').click()
				
				//document.getElementById("pat_id1").blur();
			//}	
				}

		}}
	else{
  	pat_id=await PatientSearch();
		
		if( pat_id != null )
              {
                document.getElementById('pat_id1').value = pat_id 
                 if(document.getElementById('srch_code')!=null)   
				document.getElementById('srch_code').click()
				
				//document.getElementById("pat_id1").blur();
				
				}
	}
	//parent.parent.frames[0].document.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OP&module_id=OP&function_id=VISIT_REGISTRATION&function_name=Register Visit&function_type=F&access=NYNNN&expand=0";
//	alert(parent.parent.frames[0].document.location.href)
	}
  }

 function construct_where_clause()
{
    var whereClause = "";
    var strand  = "";

    // Appointment ID
    if( trimCheck(parent.frames[1].document.forms[0].appt_ref_no.value)) {
        whereClause = whereClause + "a.appt_ref_no ='" + parent.frames[1].document.forms[0].appt_ref_no.value + "' ";
        strand = "AND ";
    }

    // Clinic Code
    if( trimCheck(parent.frames[1].document.forms[0].clinic_code.value)) 
	{
		var clcodes = parent.frames[1].document.forms[0].clinic_code.value;
		var arrval = clcodes.split("|");
		var cliniccode = arrval[0];
        whereClause = whereClause + strand + "a.clinic_code=trim('" +cliniccode+ "') " ;
        strand = "AND ";
    }

    // Practitioner ID
    if( trimCheck(parent.frames[1].document.forms[0].practitioner_id.value)) {
        whereClause = whereClause + strand + "a.practitioner_id=trim('" + parent.frames[1].document.forms[0].practitioner_id.value + "') ";
        strand = "AND ";
    }
 
    // Name suffix
    if( parent.frames[1].document.getElementById('name_suffix') != null)
    {
        if( trimCheck(parent.frames[1].document.forms[0].name_suffix.value))
        {
            whereClause = whereClause + strand + " a.name_suffix =trim('" + parent.frames[1].document.forms[0].name_suffix.value + "') ";
            strand = "AND ";
        }
    }

    // Sex
    if(trimCheck(parent.frames[1].document.forms[0].gender.value)) {
        whereClause = whereClause + strand + "a.gender=trim('" + parent.frames[1].document.forms[0].gender.value + "') ";
        strand = "AND ";
    }


    // Patient ID
    if(trimCheck(parent.frames[1].document.forms[0].pat_id1.value)) {
        whereClause = whereClause + strand + "a.patient_id=trim('" + escape(parent.frames[1].document.forms[0].pat_id1.value) + "') ";
        strand = "AND ";
    }

    if (whereClause != null && whereClause != "")
    {
        return " and "+whereClause;
    }
    else
        return "";
}

//JS functions used in checkin result.jsp

function scrollTitleResult(){

  var x = document.body.scrollTop;
  
  if(x == 0){
	 
   document.getElementById('head1').style.position='static';
   document.getElementById('head1').style.posTop  = 0;
   document.getElementById('head2').style.position='static';
   document.getElementById('head2').style.posTop  = 0;
   document.getElementById('head3').style.position='static';
   document.getElementById('head3').style.posTop  = 0;
   document.getElementById('head4').style.position='static';
   document.getElementById('head4').style.posTop  = 0;
   document.getElementById('head5').style.position='static';
   document.getElementById('head5').style.posTop  = 0;
   document.getElementById('head6').style.position='static';
   document.getElementById('head6').style.posTop  = 0;
   document.getElementById('head7').style.position='static';
   document.getElementById('head7').style.posTop  = 0;

   document.getElementById('head8').style.position='static';
   document.getElementById('head8').style.posTop  = 0;
   document.getElementById('head9').style.position='static';
   document.getElementById('head9').style.posTop  = 0;
   document.getElementById('head10').style.position='static';
   document.getElementById('head10').style.posTop  = 0;
  }else{
	document.getElementById('head1').style.position = 'relative';
	document.getElementById('head1').style.posTop  = x-2;
	document.getElementById('head2').style.position = 'relative';
	document.getElementById('head2').style.posTop  = x-2;
	document.getElementById('head3').style.position = 'relative';
	document.getElementById('head3').style.posTop  = x-2;
	document.getElementById('head4').style.position = 'relative';
	document.getElementById('head4').style.posTop  = x-2;
	document.getElementById('head5').style.position = 'relative';
	document.getElementById('head5').style.posTop  = x-2;
	document.getElementById('head6').style.position = 'relative';
	document.getElementById('head6').style.posTop  = x-2;
	document.getElementById('head7').style.position = 'relative';
	document.getElementById('head7').style.posTop  = x-2;
	
	document.getElementById('head8').style.position = 'relative';
	document.getElementById('head8').style.posTop  = x-2;
	document.getElementById('head9').style.position = 'relative';
	document.getElementById('head9').style.posTop  = x-2;
	document.getElementById('head10').style.position = 'relative';
	document.getElementById('head10').style.posTop  = x-2;
  
  }
}

//Included multi_speciality_yn for the CRF - Bru-HIMs-CRF-0198
async function tab_click_add_visit(patient,q_clinic_code,q_practitioner_id,q_appt_ref_no,q_appt_time,q_visit_adm_type,referral_id,referral_reg_yn,resource_class,ordering_facility_id,order_id,order_line_num,order_type_code,order_catalog_code,order_catalog_desc,q_room_num,fromchk,recur_wo_sec_res,cur_appt_ref_no,contact_reason_code,rec_no,locn_type,functionId,service_code,Rpractitioner_name,accept_dis_inv_no,multi_speciality_yn,isPractoApptYn,virtualConsultEnable)
{ //Above line modified for this incident[52415]
	

	var reason = eval("document.forms[0].reason_"+rec_no).value;	
	Rpractitioner_name= eval("document.forms[0].pract_"+rec_no).value;
	var nat_id_prompt;
	parent.frames[2].document.location.href='../../eCommon/html/blank.html'
	parent.frames[3].document.location.href='../../eCommon/html/blank.html'
	parent.frames[4].document.location.href='../../eCommon/html/blank.html'
	bl_interface_yn=document.forms[0].bl_interface_yn.value;
	var query_string=parent.frames[0].document.forms[0].query_string.value; 
	build_episode_rule=document.forms[0].build_episode_rule.value;
	if(parent.frames[1].document.forms[0].nat_id_prompt)
		nat_id_prompt=parent.frames[1].document.forms[0].nat_id_prompt.value
	oa_install_yn=document.forms[0].oa_install_yn.value;
	
	function_id=parent.frames[1].document.forms[0].functionId.value;
	visit_for_inpat_yn=parent.frames[1].document.forms[0].visit_for_inpat_yn.value;
	emer_regn_allow_yn=parent.frames[1].document.forms[0].emer_regn_allow_yn.value;
	or_install_yn=document.forms[0].or_install_yn.value; 
	oper_stn_id=document.forms[0].oper_stn_id.value;
	register_visit_walkin=document.forms[0].register_visit_walkin.value;
	/*contact_reason_code=document.forms[0].contact_reason_code.value;
	reason=document.forms[0].reason.value;*/

	register_visit_referral=document.forms[0].register_visit_referral.value;
	
	
	var patFlag="N"	
	if(patient=="")
	{
			
	var patient=await parent.frames[1].show_patwindowReferral(q_clinic_code,q_appt_ref_no,referral_id);	
	 patFlag=patient.charAt(0);
      if(patFlag=="Y")
      patient=patient.substring(1,patient.length);
	  else if(patFlag=="N")
	 patient=patient.substring(1,pat_id.length); 
	
	  if(parent.frames[1].document.forms[0].search!=null)   
	 parent.frames[1].document.forms[0].search.click()
	} 
	if((patient == null) ||(patient=='O')||(patient=='C')||(patient == ''))
	{		
	parent.frames[2].document.location.reload();
	}else{
		
		
		var function_id="";
		var menu_function_id = functionId;
		
		if(locn_type == 'C')
		{
			function_id = "VISIT_REGISTRATION";
		}
		else if(locn_type == 'E')
		{
			function_id = "PROCD_REGISTRATION";
		}
			
	parent.frames[0].document.getElementById('addvisit_tab').className="tabClicked";
	parent.frames[0].document.getElementById('addvisit_tabspan').className="tabSpanclicked";
	parent.frames[0].document.getElementById('checkin_tab').className="tabA";
	parent.frames[0].document.getElementById('checkin_tabspan').className="tabAspan";	
	
	//parent.visit.rows='18,23.5%,7.5%,*,13%';
	
	parent.document.getElementById("patient_main").style.height = '4vh';
	parent.document.getElementById("patient_sub").style.height = '32vh';
	parent.document.getElementById("patient_sub2").style.height = '10vh';//12vh
	parent.document.getElementById("patient_sub3").style.height = '49vh';//53vh
	parent.document.getElementById("patient_sub4").style.height = '12vh';//12vh
  
	/*Below line Added for this CRF  Bru-HIMS-CRF-165.1 [IN:035659]*/
	var appt_order="";
	if(q_appt_ref_no!=""){
		appt_order="AppointmentOrder";
	}	
	
	

	parent.frames[1].document.location.href='../../eOP/jsp/VisitRegistrationCriteria.jsp?patient='+patient+"&accept_dis_inv_no="+accept_dis_inv_no+"&q_appt_ref_no="+q_appt_ref_no+"&referral_id="+referral_id+"&q_clinic_code="+q_clinic_code+"&q_visit_adm_type="+q_visit_adm_type+"&q_practitioner_id="+q_practitioner_id+"&q_visit_adm_type_ind=R"+"&build_episode_rule="+build_episode_rule+"&bl_interface_yn="+bl_interface_yn+"&oa_install_yn="+oa_install_yn+"&oper_stn_id="+oper_stn_id+"&function_id="+menu_function_id+"&or_install_yn="+or_install_yn+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&query_string="+encodeURIComponent(query_string)+"&q_appt_time="+q_appt_time+"&service_code="+service_code; //modified this line incident[52415] 
    parent.frames[2].document.location.href="../../eCommon/jsp/patLine.jsp?Patient_Id="+patient
	/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
	parent.frames[3].document.location.href='../../eOP/jsp/VisitRegistrationResult.jsp?patient='+patient+"&accept_dis_inv_no="+accept_dis_inv_no+"&q_appt_ref_no="+q_appt_ref_no+"&referral_id="+referral_id+"&q_clinic_code="+q_clinic_code+"&q_visit_adm_type="+q_visit_adm_type+"&q_practitioner_id="+q_practitioner_id+"&q_practitioner_id1="+q_room_num+"&q_visit_adm_type_ind=R"+"&build_episode_rule="+build_episode_rule+"&bl_interface_yn="+bl_interface_yn+"&oa_install_yn="+oa_install_yn+"&oper_stn_id="+oper_stn_id+"&functionId="+function_id+"&menu_function_id="+menu_function_id+"&or_install_yn="+or_install_yn+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&nat_id_prompt="+nat_id_prompt+"&contact_reason_code="+contact_reason_code+"&reason="+encodeURIComponent(reason)+"&patFlag="+patFlag+"&query_String="+encodeURIComponent(query_string)+"&service_code="+service_code+"&q_appt_time="+q_appt_time+"&locn_ind="+locn_type+"&upt_contact_dtls_oa_yn="+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"&visit_for_inpat_yn="+visit_for_inpat_yn+"&resource_class="+resource_class+"&Rpractitioner_name="+Rpractitioner_name+"&appt_order="+appt_order+""+"&multi_speciality_yn="+multi_speciality_yn+"&rec_no="+rec_no+"&isPractoApptYn="+isPractoApptYn+"&virtualConsultEnable="+virtualConsultEnable;
   	/*Above line modified for this CRF  Bru-HIMS-CRF-165.1 [IN:035659]*/	

	//passed the value visit_for_inpat_yn for SRR20056-SCF-3046.1 [IN:026060] by Suresh M on 21.01.2010
	parent.frames[4].document.location.href='../../eOP/jsp/VisitRegistrationApptRecds.jsp?patient_id='+patient+"&accept_dis_inv_no="+accept_dis_inv_no+"&cur_appt_ref_no="+q_appt_ref_no+"&referral_id="+referral_id+"&bl_interface_yn="+bl_interface_yn+"&oa_install_yn="+oa_install_yn+"&oper_stn_id="+oper_stn_id+"&function_id="+menu_function_id+"&or_install_yn="+or_install_yn+"&register_visit_walkin="+register_visit_walkin+"&register_visit_referral="+register_visit_referral+"&build_episode_rule="+build_episode_rule+"&nat_id_prompt="+nat_id_prompt+"&patFlag="+patFlag+"&q_appt_time="+q_appt_time+"&visit_for_inpat_yn="+visit_for_inpat_yn;


	
	/*}*/
	
	}
	
}


async function show_window(q_clinic_code,q_appt_ref_no,referral_id)
{  
    


	var retVal =    new String();
    var dialogHeight= "100px" ;
    //var dialogWidth = "40" ;
	var dialogWidth = "500px" ; //Modofied for this CRF HSA-CRF-0289
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
    var arguments   = "" ;
    q_add_params = ""
       if(referral_id != '')
         q_add_params = "&p_referral_id="+referral_id+"" ; 
         
    retVal = await window.showModalDialog("../../eMP/jsp/VisitRegistrationPromptPatID.jsp?from_VR=Y&q_appt_ref_no="+q_appt_ref_no+"&function_id="+document.forms[0].function_id.value+"&q_clinic_code="+q_clinic_code+q_add_params,arguments,features);
    
	var patFlag=retVal.charAt(0);
						
	if(patFlag == 'Y')
	{
		document.forms[0].patientFlag.value=patFlag;
		var patientID=retVal.substring(1,retVal.length);
		retVal=patientID;
	}else
	{
		patFlag='N';
	}

			
//	self.location.reload();// RELOADS THE FORM 
    
    return retVal;
    
}

async function showRefDtls (ref_id)
{
	
	var retVal = 	new String();
	var dialogHeight= "90vh" ;
	var dialogTop = "0" ;
	var dialogWidth	= "80vw" ;
	var status = "no";
	var arguments   = "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ; dialogTop:" + dialogTop + " ; scroll=no; status:" + status ;
	
	var retVal = await top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref_id,arguments,features);
}
var date;
var ref_no;
var clinic_code;
var pract_id;

async function view_appt_dtl(ref_no,appt_date,clinic_code,pract_id,from_time,to_time,res_class,clinic_type){
    
   
	var retVal =    new String();
	var dialogHeight="80vh";	
    var dialogWidth = "70vw" ;
    var center = "1" ;
    var status="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status  
    var arguments   = "" ;
    retVal = await top.window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+ref_no+"&i_clinic_code="+clinic_code+"&i_practitioner_id="+pract_id+"&i_appt_date="+appt_date+"&i_from_time="+from_time+"&i_to_time="+to_time+"&res_type="+res_class+"&flag=Visit_Reg&clinic_type="+clinic_type,arguments,features);
    }

//JS functions used in visitRegistrationPomptpatIDF1.jsp

function check_patient_id( obj )
  {
      var nat_id_prompt;
	  var q_clinic_code=parent.frames[0].document.forms[0].q_clinic_code.value;
	  var q_appt_ref_no=parent.frames[0].document.forms[0].q_appt_ref_no.value;
      var function_id = parent.frames[0].document.forms[0].function_id.value;
	  if(parent.frames[1].document.forms[0].nat_id_prompt)
		nat_id_prompt=parent.frames[0].document.forms[0].nat_id_prompt.value;
	  var alt_id_type= parent.frames[0].document.forms[0].alt_id_type.value;
      register_visit_yn=parent.frames[1].document.forms[0].register_visit_yn.value
	  
	  if (parent.frames[0].document.forms[0].valid_patient_id.value != parent.frames[0].document.forms[0].patient_id.value || obj!=null)
         {
           var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient1' id='dummypromptpatient1' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='check_patient_id'><input type='hidden' name='prompt_patient_id' id='prompt_patient_id' value='"+parent.frames[0].document.forms[0].patient_id.value+"'><input type='hidden' name='q_clinic_code' id='q_clinic_code' value='"+q_clinic_code+"'><input type='hidden' name='q_appt_ref_no' id='q_appt_ref_no' value='"+q_appt_ref_no+"'><input type='hidden' name='from_PatIDF1' id='from_PatIDF1' value='true'><input type='hidden' name='function_id' id='function_id' value='"+function_id+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='register_visit_yn' id='register_visit_yn' value='"+register_visit_yn+"'>";

			if(obj !=null)
                if(obj.name == 'alt_id1_no')
                    {
                      HTMLVal= HTMLVal + "<input type = 'hidden' name='alt_id1_no' id='alt_id1_no' value='"+obj.value+"'><input type='hidden' name='alt_id_type' id='alt_id_type' value='"+alt_id_type+"'>" ;
                    }
                HTMLVal = HTMLVal+"</form></body></html>";
                parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
                parent.frames[1].document.dummypromptpatient1.submit();
        }
  }

  async function getPatientID()
        {
			pat_id=await PatientSearch();
            if( pat_id != null )
            {
                document.getElementById("patient_id").value = pat_id 
                check_patient_id()
            }
		}

 function closing()
		{		
			var Unregpatbkgyn = document.forms[0].Unregpatbkgyn.value;
			var calledFrom = document.forms[0].calledFrom.value;
			var p_referral_id= parent.frames[0].document.forms[0].p_referral_id.value;
			if(calledFrom == 'Booking')
			{
				if(Unregpatbkgyn == "Y")
					parent.window.returnValue=p_referral_id;
			}
			
			if (parent.window.returnValue == null)
			{	
				parent.window.returnValue='C';
			
			}
			parent.window.close();
		
		}
var patnt_id_regd="";
  function ButtonClick(flag)
    {
	  var nat_id_prompt;
	  var q_clinic_code=parent.frames[0].document.forms[0].q_clinic_code.value;
	  var q_appt_ref_no=parent.frames[0].document.forms[0].q_appt_ref_no.value;
	  var function_id = parent.frames[0].document.forms[0].function_id.value;
	  if(parent.frames[1].document.forms[0].nat_id_prompt)
		 nat_id_prompt=parent.frames[0].document.forms[0].nat_id_prompt.value;
	  var q_from_funct= parent.frames[0].document.forms[0].q_from_funct.value;
	  var q_booking_ref_no= parent.frames[0].document.forms[0].q_booking_ref_no.value;
	  var p_referral_id= parent.frames[0].document.forms[0].p_referral_id.value;
	  var func_act= parent.frames[0].document.forms[0].func_act.value;
	  var fromVR= parent.frames[0].document.forms[0].fromVR.value;
	   register_visit_yn =parent.frames[0].document.forms[0].register_visit_yn.value
	  if (flag=="O")
      {
		 	if((parent.frames[0].document.forms[0].patient_id.value != "") )
			{

				var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient2' id='dummypromptpatient2' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='ok'><input type='hidden' name='prompt_patient_id' id='prompt_patient_id' value='"+parent.frames[0].document.forms[0].patient_id.value+"'><input type='hidden' name='q_clinic_code' id='q_clinic_code' value='"+q_clinic_code+"'><input type='hidden' name='q_appt_ref_no' id='q_appt_ref_no' value='"+q_appt_ref_no+"'><input type='hidden' name='q_from_funct' id='q_from_funct' value='"+q_from_funct+"'><input type='hidden' name='q_booking_ref_no' id='q_booking_ref_no' value='"+q_booking_ref_no+"'><input type='hidden' name='p_referral_id' id='p_referral_id' value='"+p_referral_id+"'><input type='hidden' name='func_act' id='func_act' value='"+func_act+"'><input type='hidden' name='fromVR' id='fromVR' value='"+fromVR+"'><input type='hidden' name='from_PatIDF1' id='from_PatIDF1' value='true'><input type='hidden' name='function_id' id='function_id' value='"+function_id+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='register_visit_yn' id='register_visit_yn' value='"+register_visit_yn+"'>";

			   HTMLVal = HTMLVal+"</form></body></html>";
		       parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			   parent.frames[1].document.dummypromptpatient2.submit();
			}else{

			if((parent.frames[0].document.forms[0].alt_id1_no.value == "") && (parent.frames[0].document.forms[0].patient_id.disabled !=  true))
			{
		
		var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
		error = error.replace('$',getLabel('Common.patientId.label','Common'));
		alert(error);
		if(parent.frames[0].document.forms[0].patient_id.disabled != true){
		parent.frames[0].document.forms[0].patient_id.focus();
		}
	
		}
		}
				
	}else if (flag=="R")
        {
			
						
		     
			patnt_id_regd="";
			show_patient_registration();
			
			 
				patient_id_regd=patnt_id_regd;
			  window.close();
			 if(patient_id_regd != "")
                {
					var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient3' id='dummypromptpatient3' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='register'><input type='hidden' name='prompt_patient_id' id='prompt_patient_id' value='"+patnt_id_regd+"'><input type='hidden' name='q_clinic_code' id='q_clinic_code' value='"+q_clinic_code+"'><input type='hidden' name='q_appt_ref_no' id='q_appt_ref_no' value='"+q_appt_ref_no+"'><input type='hidden' name='p_referral_id' id='p_referral_id' value='"+p_referral_id+"'><input type='hidden' name='func_act' id='func_act' value='"+func_act+"'><input type='hidden' name='fromchk' id='fromchk' value='N'><input type='hidden' name='from_PatIDF1' id='from_PatIDF1' value='false'><input type='hidden' name='function_id' id='function_id' value='"+function_id+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='register_visit_yn' id='register_visit_yn' value='"+register_visit_yn+"'>";
					HTMLVal = HTMLVal+"</form></body></html>";
					
					parent.frames[1].document.write(HTMLVal);
					parent.frames[1].document.dummypromptpatient3.submit();
				}
         }
         else
              {
					var Unregpatbkgyn = document.forms[0].Unregpatbkgyn.value;
					var calledFrom = document.forms[0].calledFrom.value;
					if(calledFrom == 'Booking')
					{
						if(Unregpatbkgyn == "Y")
							parent.window.returnValue=p_referral_id;
					}
					else
						parent.window.returnValue="C";
					
					parent.window.close();
                }

  }
   
async function show_patient_registration()
   {
	  var q_appt_ref_no=parent.frames[0].document.forms[0].q_appt_ref_no.value;
      var q_booking_ref_no= parent.frames[0].document.forms[0].q_booking_ref_no.value;
	  var p_referral_id= parent.frames[0].document.forms[0].p_referral_id.value;
	  var func_act= parent.frames[0].document.forms[0].func_act.value;
	  var q_booking_type= parent.frames[0].document.forms[0].q_booking_type.value;
	 
		

	   var retVal =  new String();
	   var dialogTop= "0vh";
	   var dialogHeight= "90vh" ;
	   var dialogWidth = "90vw" ;
	   var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
	   var arguments = "" ;
	   retVal = await window.showModalDialog("../../eMP/jsp/PatientRegistrationMain.jsp?module_id=MP&function_id=PAT_REG&function_name=Register%20Patient&function_type=F&access=YYYNN&appt_ref_no="+q_appt_ref_no+"&booking_ref_no="+q_booking_ref_no+"&p_referral_id="+p_referral_id+"&func_act="+func_act+"&q_booking_type="+q_booking_type+"&title=Register Patient",arguments,features);
		
		if( retVal != null )
		{			
		  
		    patnt_id_regd=retVal;
			parent.window.returnValue=retVal;
		   //parent.window.close();				  
		 } 
				 
 }  
 
		/* The below function "clearAll()" is added for the incident IN018116 on 12.01.2010 by Suresh 
		    To clear the dependant values of the location 
		*/

    function clearAll(){	
					
			parent.frames[3].document.forms[0].visit_adm_type.disabled=true; 
			parent.frames[3].document.forms[0].pract_name.readOnly=true;
			if(parent.frames[3].document.forms[0].pract_butt)
				parent.frames[3].document.forms[0].pract_butt.disabled=true;			
			parent.frames[3].document.forms[0].assign_care_locn_desc.value="";
			parent.frames[3].document.forms[0].assign_care_locn_code.value="";
			parent.frames[3].document.forms[0].pract_name.value="";
			parent.frames[3].document.forms[0].attend_practitioner_id.value="";
			parent.frames[3].document.forms[0].other_res_txt.value="";
			parent.frames[3].document.forms[0].other_res_code.value="";
			
			//Below line added for this CRF GDOH-CRF-0129
			if(parent.frames[3].document.forms[0].contact_reason_txt)parent.frames[3].document.forms[0].contact_reason_txt.value="";
			//End this GDOH-CRF-0129
			
			parent.frames[3].document.forms[0].contact_reason_code.value="";			
			parent.frames[3].document.forms[0].other_res_type.value="";
			parent.frames[3].document.forms[0].other_res_code.value="";	
			var iSPractVisitLoad=document.forms[0].iSPractVisitLoad.value;//added by munisekhar for MMS-QH-CRF-0167 [IN:044923]
            if(iSPractVisitLoad=="true"){
			document.getElementById("loc_name").style.visibility="hidden";
			}
			var isRoomMandatoryRegVisit = document.forms[0].isRoomMandatoryRegVisit.value; // Added by mujafar for NMC-JD-CRF-0025	
			 if(isRoomMandatoryRegVisit=="true"){
			document.getElementById("room_img").style.visibility="hidden";
			}
				
			if(parent.frames[3].document.forms[0].visit_type_derv_rule.value == "S" || parent.frames[3].document.forms[0].visit_type_derv_rule.value == "B"){//added for MMS-QH-CRF 41.1
			if(parent.frames[3].document.getElementById('gifpop') != null)
				parent.frames[3].document.getElementById('gifpop').style.visibility='hidden';
			}
			clearOrderCatalog();			
   }

/*Below line was added by Suresh.M on 28-Nov-2012 against RUT-SCF-0160 [IN:033589] and RUT-CRF-0060 also*/
function readyToBlur(e){	
	if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0){
			var tabname = document.forms[0].tabName.value;
			if(tabname=='' || tabname== 'invitation_tab'){
				document.getElementById('search').click();
			}else if(tabname == 'checkin_tab'){
				document.forms[0].search.click();
			}else if(tabname == 'addvisit_tab'){
				document.forms[0].srch_code.click();
			}
	}
}
/*Below line Added for this CRF  Bru-HIMS-CRF-165.1 [IN:035659]*/
async function SelectOrderCatalogSearch(obj,target)
{ 
	
	var appt_ref_no=parent.frames[3].document.forms[0].appt_ref_no.value; 
	var appt_order=parent.frames[3].document.forms[0].appt_order.value; 
	var facilityId=parent.frames[3].document.forms[0].facilityId.value; 
	var order_select_count= parent.frames[3].document.forms[0].order_count_select.value; 
	
	
		

	var dialogTop	= "56";
	var dialogHeight= "33vh" ;
	var dialogWidth = "50vw" ;
	var status = "no";
	var scroll = "no";
	var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
	var arguments   = "" ;			
	//var retVal=window.showModalDialog("../../eOR/jsp/OrderableFrameSet.jsp?searchText="+encodeURIComponent(searchtext)+"&called_from=OP&mode="+mode+"&order_category="+order_category+"&order_type="+order_type+"&p_clinic_code="+clinic_code+"&appt_ref_no="+appt_ref_no+"&appt_order="+appt_order+"&facilityId="+facilityId,arguments,features);	
	//var retVal=window.showModalDialog("../../eOP/jsp/AppointmentOrderFrameSet.jsp?searchText="+encodeURIComponent(searchtext)+"&called_from=OP&mode="+mode+"&order_category="+order_category+"&order_type="+order_type+"&p_clinic_code="+clinic_code+"&appt_ref_no="+appt_ref_no+"&appt_order="+appt_order+"&facilityId="+facilityId,arguments,features);
	//location.href = "../../eOP/jsp/AppointmentOrderSelect.jsp?appt_ref_no="+appt_ref_no+"&appt_order="+appt_order;
	//var retVal=window.showModalDialog("../../eOP/jsp/AppointmentOrderSelect.jsp?appt_ref_no="+appt_ref_no+"&appt_order="+appt_order+"&facilityId="+facilityId,arguments,features);
	var retVal=await window.showModalDialog("../../eOP/jsp/AppointmentOrderFrameSet.jsp?appt_ref_no="+appt_ref_no+"&appt_order="+appt_order+"&facilityId="+facilityId,arguments,features);
	
	/*var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr	="<root><SEARCH appt_ref_no=\""+appt_ref_no+"\" appt_order=\""+appt_order+"\"/></root>";
	alert("xmlStr=="+xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","AppointmentOrderSelect.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	eval(responseText); alert(resrt_wtlst_Flag1);
	if(resrt_wtlst_Flag1=1)
	{
	
	}*/
	/*patient_id,clinic_code,bl_success Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461]*/
	var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='popordercatalog' id='popordercatalog' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='callfunc' id='callfunc' value='OrderCatalog'><input type='hidden' name='order_select_count' id='order_select_count' value = '"+order_select_count+"' ><input type='hidden' name='clinic_code' id='clinic_code' value='"+parent.frames[3].document.forms[0].assign_care_locn_code.value+"'><input type='hidden' name='patient_id' id='patient_id' value='"+parent.frames[3].document.forms[0].patient_id.value+"'><input type='hidden' name='bl_success' id='bl_success' value='"+parent.frames[3].document.forms[0].bl_success.value+"'/></form></body></html>";		
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.popordercatalog.submit();
}


//End this CRF  Bru-HIMS-CRF-165.1 [IN:035659]

//Function added for the CRF - Bru-HIMS-0198
async function showSecondaryResource(){
	var appt_ref_no=parent.frames[3].document.forms[0].appt_ref_no.value;
	var facilityId=parent.frames[3].document.forms[0].facilityId.value;	
	var dialogHeight= "15" ;
	var dialogWidth	= "40" ;
	var dialogTop = "190" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var url="../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_ref_no+"&fac_id2="+facilityId+"&called_from=VISITREG";	
	await window.showModalDialog(url,arguments,features);
}

/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
function displayApptRefDtls(){
	var appt_count = document.forms[0].appt_count.value;
	var ref_count = document.forms[0].ref_count.value;
	
	if(ref_count <= 0){
		if(appt_count > 0){
			document.forms[0].appt_list.style.display='inline';
			document.getElementById("appt_button_list").style="display"
		}
	}else{
		if(ref_count > 0){
			document.forms[0].ref_list.style.display='inline';
			document.getElementById("ref_button_list").style="display";
		}
	}

	if(appt_count > 0 && ref_count > 0){
		document.forms[0].appt_list.style.display='inline';
	}
}

function populateRefTab(location_code){
	var selected_loc_code = location_code;
	var patient = document.forms[0].patient_id.value;
	var accept_dis_inv_no = document.forms[0].accept_dis_inv_no.value;
	var q_appt_ref_no = document.forms[0].apptrefno.value;
	var referral_id = document.forms[0].referral_code.value;
	var bl_interface_yn = document.forms[0].bl_interface_yn.value;
	var oa_install_yn = document.forms[0].oa_install_yn.value;
	var oper_stn_id = document.forms[0].oper_stn_id.value;
	var menu_function_id = document.forms[0].menu_function_id.value;
	var or_install_yn = document.forms[0].or_install_yn.value;
	var build_episode_rule = document.forms[0].build_episode_rule.value;
	var nat_id_prompt = document.forms[0].nat_id_prompt.value;
	var patFlag = document.forms[0].patFlag.value;
	var q_appt_time = document.forms[0].q_appt_time.value;
	var visit_for_inpat_yn = document.forms[0].visit_for_inpat_yn.value;
	//Added by Kamatchi S for MMS-DM-CRF-0223
	var locale=document.forms[0].locale.value; 
	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH selected_loc_code=\""+selected_loc_code+"\" locale=\""+locale+"\" action='Speciality' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOP/jsp/OPIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	var spec = trimString(xmlHttp.responseText);
	var speciality = spec;
	// END MMS-DM-CRF-0223
	parent.frames[4].document.location.href='../../eOP/jsp/VisitRegistrationApptRecds.jsp?patient_id='+patient+"&accept_dis_inv_no="+accept_dis_inv_no+"&cur_appt_ref_no="+q_appt_ref_no+"&referral_id="+referral_id+"&bl_interface_yn="+bl_interface_yn+"&oa_install_yn="+oa_install_yn+"&oper_stn_id="+oper_stn_id+"&function_id="+menu_function_id+"&or_install_yn="+or_install_yn+"&build_episode_rule="+build_episode_rule+"&nat_id_prompt="+nat_id_prompt+"&patFlag="+patFlag+"&q_appt_time="+q_appt_time+"&visit_for_inpat_yn="+visit_for_inpat_yn+"&selected_loc_code="+selected_loc_code+"&speciality="+speciality;
	// Added speciality for MMS-DM-CRF-0223 by KAMATCHI S
}

function populateLocationValues(q_referral_id){

	parent.frames[1].document.forms[0].referal_id1.value = q_referral_id;

	if(parent.frames[1].document.forms[0].referal_id2 != null)
		parent.frames[1].document.forms[0].referal_id2.value = q_referral_id;	

	if(q_referral_id!=""){
		parent.frames[3].document.forms[0].referral_clicked_yn.value = 'Y';
		parent.frames[1].document.forms[0].srch_code.disabled = false;
		parent.frames[1].document.forms[0].srch_code.click();
		parent.frames[1].document.forms[0].srch_code.disabled = true;
	}
}

function displayApptList(){
	document.getElementById("appt_button_list").style="display"
	//document.getElementById("ref_button_list").style="";
	document.getElementById("ref_button_list").style.cssText = '';

}

function displayRefList(){
	document.getElementById("ref_button_list").style="display"
	document.getElementById("appt_button_list").style="";
}
/*End MMS-DM-CRF-0187*/


