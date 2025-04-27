function validateResidency() {

	var visit_dtl_temp_code = ""; 
	var p_referral_id = "";
	var functionId = ""; 
	var nat_id_prompt = "";
	var register_visit_yn = "";	
	var invitation_no = "";
	var appt_ref_no = "";
	var patient_id = "";
	var episodeReqd = "";
	var visit_adm_type = "";
	var q_visit_adm_type_ind = "";
	var override_vtype_on_epsd_yn = "";
	var or_install_yn = "";	
	
	if(parent.frames[3].document.forms[0].vis_det_temp_code)
		visit_dtl_temp_code = parent.frames[3].document.forms[0].vis_det_temp_code.value;

	if(parent.frames[1].document.forms[0].referal_id1)
		p_referral_id = parent.frames[1].document.forms[0].referal_id1.value;

	if(parent.frames[3].document.forms[0].functionId)
		functionId	  = parent.frames[3].document.forms[0].functionId.value;

	if(parent.frames[1].document.forms[0].nat_id_prompt)
		nat_id_prompt = parent.frames[1].document.forms[0].nat_id_prompt.value;

	if(parent.frames[1].document.forms[0].register_visit_yn)
		register_visit_yn = parent.frames[1].document.forms[0].register_visit_yn.value;	

	if(parent.frames[3].document.forms[0].invitation_no)
		invitation_no = parent.frames[3].document.forms[0].invitation_no.value;

	if(parent.frames[3].document.forms[0].appt_ref_no_2)
		appt_ref_no = parent.frames[3].document.forms[0].appt_ref_no_2.value;

	if(parent.frames[3].document.forms[0].patient_id)
		patient_id = parent.frames[3].document.forms[0].patient_id.value;

	if(parent.frames[3].document.forms[0].build_episode_rule)
		episodeReqd = parent.frames[3].document.forms[0].build_episode_rule.value;

	if(parent.frames[3].document.forms[0].visit_adm_type)
		visit_adm_type = parent.frames[3].document.forms[0].visit_adm_type.value;

	if(parent.frames[3].document.forms[0].q_visit_adm_type_ind)
		q_visit_adm_type_ind = parent.frames[3].document.forms[0].q_visit_adm_type_ind.value;

	if(parent.frames[3].document.forms[0].override_vtype_on_epsd_yn)
		override_vtype_on_epsd_yn = parent.frames[3].document.forms[0].override_vtype_on_epsd_yn.value;

	if(parent.frames[3].document.forms[0].or_install_yn)
		or_install_yn = parent.frames[3].document.forms[0].or_install_yn.value;	

	if(parent.frames[3].document.forms[0].visit_type_derv_rule)
		visit_type_derv_rule = parent.frames[3].document.forms[0].visit_type_derv_rule.value;

	//Added for the SCf - MMS-SCF-0072 - Start
	if(parent.frames[3].document.forms[0].vst_regn_date_time)
		vst_date_time = parent.frames[3].document.forms[0].vst_regn_date_time.value;
	//Added for the SCf - MMS-SCF-0072 - end

	var HTMLVal = new String();			
	//modified for the SCF - MMS-SCF-0072
  //modified By mujafar for NC-JD-CRF-0025
	HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/ValidateVisitDtlsTemplate.jsp'><input type='hidden' name='visit_dtl_temp_code' id='visit_dtl_temp_code' value='"+visit_dtl_temp_code+"'><input type='hidden' name='p_referral_id' id='p_referral_id' value='"+p_referral_id+"'><input type='hidden' name='functionId' id='functionId' value='"+functionId+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='register_visit_yn' id='register_visit_yn' value='"+register_visit_yn+"'><input type='hidden' name='invitation_no' id='invitation_no' value='"+invitation_no+"'><input type='hidden' name='appt_ref_no' id='appt_ref_no' value='"+appt_ref_no+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='episodeReqd' id='episodeReqd' value='"+episodeReqd+"'><input type='hidden' name='visit_adm_type' id='visit_adm_type' value='"+visit_adm_type+"'><input type='hidden' name='q_visit_adm_type_ind' id='q_visit_adm_type_ind' value='"+q_visit_adm_type_ind+"'><input type='hidden' name='override_vtype_on_epsd_yn' id='override_vtype_on_epsd_yn' value='"+override_vtype_on_epsd_yn+"'><input type='hidden' name='or_install_yn' id='or_install_yn' value='"+or_install_yn+"'><input type='hidden' name='visit_type_derv_rule' id='visit_type_derv_rule' value='"+visit_type_derv_rule+"'><input type='hidden' name='allow_pop_subser' id='allow_pop_subser' value='Y'><input type='hidden' name='vst_date_time' id='vst_date_time' value='"+vst_date_time+"'><input type = 'hidden' name = 'isRoomMandatoryRegVisit' value = '"+parent.frames[3].document.forms[0].isRoomMandatoryRegVisit.value+"'></form></BODY></HTML>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.form1.submit();
}

function onBlurgetLoc(invitation_no,referal_id,register_visit_referral,to_speciality_code,register_visit_walkin,functionId,patient,facilityid,oper_stn_id,userid,target)
{
		target.value = trimString(target.value);		 
		if(target.value == "") {		 
			target.value="";
			 PatVisHid(1);//added by munisekhar for MMS-QH-CRF-0167 [IN:044923] 
			clearAll();
			ClearList(document.forms[0].assign_care_locn_code);		
			return;
		}     getLocn(invitation_no,referal_id,register_visit_referral,to_speciality_code,register_visit_walkin,functionId,patient,facilityid,oper_stn_id,userid,target)
		PatVisHid(1);//added by munisekhar for MMS-QH-CRF-0167 [IN:044923] 
}
//added by munisekhar for MMS-QH-CRF-0167 [IN:044923] 
function PatVisHid(obj){
if(obj==1){
var iSPractVisitLoad=document.forms[0].iSPractVisitLoad.value;
if(iSPractVisitLoad=="true"){
	if(document.forms[0].assign_care_locn_desc.value!=""){
	document.getElementById("loc_name").style.visibility="visible";
	}else{
	document.getElementById("loc_name").style.visibility="hidden";
	}
	}
}else if(obj==2){
var iSPractVisitLoad=parent.frames[1].frames[3].document.forms[0].iSPractVisitLoad.value;
if(iSPractVisitLoad=="true"){
	if(parent.frames[1].frames[3].document.forms[0].assign_care_locn_desc.value!=""){
	parent.frames[1].frames[3].document.getElementById("loc_name").style.visibility="visible";
	}else{
	parent.frames[1].frames[3].document.getElementById("loc_name").style.visibility="hidden";
	}
	}
}else if(obj==3){// added by munisekhar for MMS-QH-CRF-0162
	var isSiteSpe_change_pat_dtls=parent.frames[1].frames[1].document.forms[0].isSiteSpe_change_pat_dtls.value;
	var userFunRightsCount	= parseInt(parent.frames[1].frames[1].document.forms[0].userFunRightsCount.value);//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]


	if(isSiteSpe_change_pat_dtls=="true"  && userFunRightsCount > 0){
		if(parent.frames[1].frames[1].document.forms[0].pat_id1.value!=""){
		parent.frames[1].frames[1].document.getElementById("Update_pat").style.visibility="visible";
		}else if(parent.frames[1].frames[1].document.forms[0].referal_id1!=null){
		parent.frames[1].frames[1].document.getElementById("Update_pat").style.visibility="visible";
		}else{
		parent.frames[1].frames[1].document.getElementById("Update_pat").style.visibility="hidden";
		}
		
		}
}else if(obj==4){// added by munisekhar for MMS-QH-CRF-0162
	var isSiteSpe_change_pat_dtls=parent.frames[1].document.forms[0].isSiteSpe_change_pat_dtls.value;
	var userFunRightsCount	= parseInt(parent.frames[1].document.forms[0].userFunRightsCount.value);//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
	if(isSiteSpe_change_pat_dtls=="true"  && userFunRightsCount > 0){
		if(parent.frames[1].document.forms[0].pat_id1.value!=""){
		parent.frames[1].document.getElementById("Update_pat").style.visibility="visible";
		}else if(parent.frames[1].document.forms[0].referal_id1!=null){
		parent.frames[1].document.getElementById("Update_pat").style.visibility="visible";
		}else{
		parent.frames[1].document.getElementById("Update_pat").style.visibility="hidden";
		}
		
		}
}
}

async function getLocn(invitation_no,referal_id,register_visit_referral,to_speciality_code,register_visit_walkin,functionId,patient,facilityid,oper_stn_id,userid,target)
{
    
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";				
   locale=document.forms[0].locale.value; 
   inv_splty_code=document.forms[0].inv_splty_code.value
   var locn_type=document.forms[0].locn_type.value;	   

   //spec_code=document.forms[0].Qspeciality.value
   tit=getLabel("Common.Location.label",'Common')
    sql="select clinic_code code ,long_desc description  from op_clinic_lang_vw a,(select day_no from sm_day_of_week where day_of_week=rtrim(to_char(sysdate,'DAY'))) where decode(day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3,'4',working_day_4,'5',working_day_5,'6',working_day_6,working_day_7)='Y' and level_of_care_ind='A' and allow_visit_regn_yn ='Y' and eff_status='E'";
    sql=sql+" and ((age_group_code is null ) or ((age_group_code is not null) and exists (select age_group.age_group_code from am_age_group age_group,mp_patient patient where patient.patient_id ='"+patient+"' and age_group.age_group_code=a.age_group_code and nvl(age_group.gender,patient.sex)=patient.sex and trunc(sysdate)-trunc(patient.date_of_birth) between decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.min_age and decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.max_age and age_group.eff_status='E' ))) and facility_id='"+facilityid+"' and (facility_id, clinic_type, clinic_code) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+facilityid+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+userid+"' and (register_visit_yn = 'Y')";
        if(invitation_no!="")
         {
           sql=sql+ " and SPECIALITY_CODE = '"+inv_splty_code+"'";
         } 
		if(referal_id!="")
         { 
	       if(register_visit_referral=="Y")
	         sql=sql+ " or REGISTER_VISIT_REFERRAL_YN = 'N' )) and SPECIALITY_CODE = '"+to_speciality_code+"' ";
	         else
	         sql=sql+ " ) and SPECIALITY_CODE = '"+to_speciality_code+"' ";
         }
         else 
         {   
            if(register_visit_walkin=="Y")
            sql=sql+ " or REGISTER_VISIT_WALKIN_YN = 'N' ))";
            else
            sql=sql+ " ) ";
         }

		 sql=sql+ " and care_locn_type_ind='"+locn_type+"' and a.language_id='"+locale+"' and rd_appl_yn='N'  and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) " ;    
		
		 /*
        if(functionId=="VISIT_REGISTRATION") {
            sql=sql+" and care_locn_type_ind='C' " ;
        }else if(functionId=="PROCD_REGISTRATION"){
	        sql=sql+" and care_locn_type_ind = 'E' ";
        }	  		 
		sql=sql+ " and a.language_id='"+locale+"'  and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2" ;    		
		*/
  	
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;

				retVal = await CommonLookup( tit, argumentArray );			 

				if(retVal != null && retVal != "" ) { 
					 var ret1=unescape(retVal);
					 arr=ret1.split(",");					
					 document.forms[0].assign_care_locn_code.value=arr[0];
					 if(arr[1] !=document.forms[0].assign_care_locn_desc.value ){
						ChangeObj1(document.forms[0].assign_care_locn_code,document.forms[0].oa_install_yn.value)						
						if(document.getElementById('enablelookup')){ 
							document.getElementById('enablelookup').innerHTML = '<input type="text" name="pract_name" id="pract_name" readonly maxlength="30" size="30"  onblur="onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);" ><input type="button" name="pract_butt" id="pract_butt" value="?" disabled class="button" onClick="callPractSearchQuery(this,pract_name);"><img id="gifpop" style="visibility:hidden" src="../../eCommon/images/mandatory.gif"></img>'
					    }
					}
					 target.value=arr[1];				
					 document.forms[0].bl_success.value="N"    					
				}else{
					target.value="";
					PatVisHid(1);//added by munisekhar for MMS-QH-CRF-0167 [IN:044923] 
					clearAll();
					ClearList(document.forms[0].assign_care_locn_code);		
				}
				
			
				
		PatVisHid(1);	//added by munisekhar for MMS-QH-CRF-0167 [IN:044923] 	
				
}
async function onBlurgetVisdetails(fac_id ,target)
{	 
	if(target.value !="")
	{
		await getVisdetails(fac_id,target);
	}
}

function clearVisitDtls() {  
	clearAll();	
	parent.frames[3].document.forms[0].locn_type.value = "";	
	ClearList(parent.frames[3].document.forms[0].vis_det_temp_desc);		
}
       
async function getVisdetails(fac_id,target)
{	    
		//removeitems(document.forms[0].service);
		
		var retVal =    new String();
        var argumentArray  = new Array() ;
        var dataNameArray  = new Array() ;
        var dataValueArray = new Array() ;
        var dataTypeArray  = new Array() ;
        var tit="";	
        var sql;
		var user_id = document.forms[0].user_id.value;
		tit=getLabel('eOP.VisitDtlsTemplate.label','Op');
			sql ="select template_code code , DESCRIPTION description from op_template_for_vis_regn a where a.facility_id='"+fac_id+"' and  upper(a.template_code) like upper(?) and upper(a.DESCRIPTION) like upper(?) and exists (select 1 from AM_LOCN_FOR_OPER_STN b,AM_USER_FOR_OPER_STN c where b.facility_id=a.facility_id and locn_code=a.locn_code and c.facility_id=a.facility_id and b.OPER_STN_ID=c.OPER_STN_ID and c.APPL_USER_ID='"+user_id+"') order by 2";
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = DESC_LINK  ;
			argumentArray[7] = DESC_CODE ;
			retVal = await CommonLookup( tit,argumentArray);
			
			if(retVal != null && retVal != "" ){
				var ret1=unescape(retVal);
				arr=ret1.split(",");
				if(arr[1]==undefined) arr[1]="";
				
				
				//Commented the following condition for the SCF - MMS-SCF-0072
				//if(arr[1] != parent.frames[3].document.forms[0].vis_det_temp_desc.value){			
					target.value=arr[1];				 
					document.forms[0].vis_det_temp_code.value=arr[0];			 
					validateResidency();
				//}				
			}else{
				target.value="";
			}
}

 function removeitems(obj)
{
    var len=obj.length;
    var i=1;
    while(i<len)
    {
        len=obj.length
        obj.remove(i)
    }
}

async function appointment(confirmAppointment,referral_id,splty_code,P_practitioner_id,P_locn_code,
recall_date,P_locn_type,no_dwm,visittype,dwm_desc,resource_class) 
{	

	var retVal = 	new String();
	/*var dialogHeight= "1000px" ;//modified by N Munisekhar for[IN:048929] 
	var dialogWidth = "1800px" ;
	var dialogTop 	= "50px";*/
	
	var dialogHeight= "90vh" ;//modified by N Munisekhar for[IN:048929] 
	var dialogWidth = "90vw" ;
	var dialogTop 	= "0vh";
	
	var center = "1" ;
	var status="no";
    var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	
	if(recall_date==null || recall_date == "")
		recall_date=document.forms[0].currentdate.value
		
	functionId=document.forms[0].functionId.value;	
     if(splty_code==undefined)
	    splty_code="";
	var parameters	= "i_practitioner_id="+P_practitioner_id+"&clinic_code="+P_locn_code+"&recall_date="+recall_date+"&care_locn_ind="+P_locn_type+"&specialty_code="+splty_code+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&resource_class="+resource_class;
	
	if(functionId=="PROCD_REGISTRATION")
	{			
		retVal = await top.window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?callingMode=OP_RV&CA=Y&loc_type=E&"+parameters,arguments,features);
	}
	else
	{		
		retVal = await top.window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?callingMode=OP_RV&CA=Y&loc_type=CE&"+parameters,arguments,features);
	}    
	
	
	if (retVal != null && retVal != "")
	{
	 	var returnVal = retVal.split("^");
		var mode = returnVal[0];
		h = returnVal[1];		
		

		if (mode=="1")
	    {
		     h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');					
			 retVal = await top.window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+h,arguments,features);			 
			 if (retVal=="OP"){
			     await appointment(false);
				 retVal="";
				 }
				 
		}
		else if (mode=="2")
		{
			 h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');
			 retVal = await top.window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+h,arguments,features);
			 if (retVal=="OP"){
			     await appointment(false);
				 retVal="";
				 }
		}
		else if (mode=="3")
		{
			h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');
			retVal = await top.window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+h,arguments,features);
			if (retVal=="OP"){
				await appointment(false);
				retVal="";
				}
		}

		if(retVal != null && retVal != "")
		{
			 var arr=new Array();
			 arr=retVal.split("&");
			 var i=0;

				while(arr[i]!=null)
				{
					 
				     var arrayElement =arr[i];
					 if(arrayElement.indexOf("specialty_code")!=-1)
					 {
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 splty_code = arrayOfValue[1];
					 }
					 if(arrayElement.indexOf("practitioner_id")!=-1)
					 {
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 P_practitioner_id = arrayOfValue[1];
					 }
					 if(arrayElement.indexOf("clinic_code")!=-1)
					 {
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 P_locn_code = arrayOfValue[1];
					 }
					 if(arrayElement.indexOf("recall_date")!=-1)
					 {
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 recall_date = arrayOfValue[1];
					 } 
					 if(arrayElement.indexOf("care_locn_ind")!=-1)
					 {
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 P_locn_type = arrayOfValue[1];
					 } 
					 if(arrayElement.indexOf("no_dwm")!=-1)
					 {
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 no_dwm = arrayOfValue[1];
					 } 
					 if(arrayElement.indexOf("visittype")!=-1)
					 {
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 visittype = arrayOfValue[1];
					 } 
					 if(arrayElement.indexOf("dwm_desc")!=-1)
					 {
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 dwm_desc = arrayOfValue[1];
					 } 
					 if(arrayElement.indexOf("resource_class")!=-1)
					 {
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 resource_class = arrayOfValue[1];
					 } 
					i++;
				}						
				
				if(retVal !="")
				{
					await appointment(confirmAppointment,referral_id,splty_code,P_practitioner_id,P_locn_code,recall_date,P_locn_type,no_dwm,visittype,dwm_desc,resource_class);				
					
				}
			}
	}		
}

async function clear_vals()
{
	if(document.forms[0].category_desc_txt.value=='')
	{
		document.forms[0].category_code.value='';
	}else{
		await callCataegorySearch();
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
          locale=document.forms[0].locale.value;     					
         tit=getLabel("Common.nationality.label",'Common')
         sql="Select country_code code,long_desc description from Mp_Country_lang_vw where eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?) and language_id='"+locale+"'";					
				
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
				document.forms[0].nationality_id.value=arr[0];
				}
				else{
					target.value='';
				}
			}



	async function searchCommonCode(obj,target,title)
            {
				var retVal =    new String();                
                var tit=title;				
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
                locale=document.forms[0].locale.value
				if(obj.name=="town_code")
                {
					 sql="Select res_town_code code,long_Desc description from Mp_res_town_lang_vw where eff_status='E' and upper(res_town_code) like upper(?) and upper(long_Desc) like upper(?) and eff_status = 'E' and language_id='"+locale+"'";
                 }
				if(obj.name=="region_code")
                {
                    sql="Select region_code code,long_Desc description from Mp_region_lang_vw where eff_status='E' and upper(region_code) like upper(?) and upper(long_Desc) like upper(?) and eff_status = 'E'  and language_id='"+locale+"'";
                }
				if(obj.name=="area_code")
                {
                    sql="Select res_area_code code ,long_Desc description from Mp_res_area_lang_vw where eff_status='E' and upper(res_area_code) like upper(?) and upper(long_Desc) like upper(?) and eff_status = 'E' and language_id='"+locale+"'";
                }
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				if(obj.name=="postal_code"){
					argumentArray[6] = CODE_LINK  ;
					argumentArray[7] = CODE_DESC ;
				}
				else{
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				}               
				retVal = await CommonLookup( tit, argumentArray );
				var arr=new Array();
                if(retVal != null && retVal != "" )
                {
				
                    var ret1=unescape(retVal);
					arr=ret1.split(",");
					if(obj.name=="postal_code"){
					target.value=arr[0];
					}
					else{
					target.value=arr[1];
					}
				
					 if(target.name=='r_area_code'){
						document.forms[0].r_area.value= arr[0];
					}
					else if(target.name=='m_area_code'){
						document.forms[0].m_area.value= arr[0];
					}else if(target.name=='r_region_code'){
						document.forms[0].r_region.value= arr[0];
					}else if(target.name=='m_region_code'){
						document.forms[0].m_region.value= arr[0];

					} else if(target.name=='r_town_code'){
						document.forms[0].r_town.value= arr[0];
					}
					else if(target.name=='m_town_code'){
						document.forms[0].m_town.value= arr[0];
					}

		
              }
                else
				{
					if(obj.name=='postal_code'){
                    target.value='';
					}
					else
					{
					 if(target.name=='r_area_code'){
						document.forms[0].r_area.value= '';
					 }
					 else if(target.name=='m_area_code'){
						document.forms[0].m_area.value= '';
					 }else if(target.name=='r_region_code'){
					  document.forms[0].r_region.value='';
					 }
					 else if(target.name=='m_region_code'){
						document.forms[0].m_region.value= '';
					 } else if(target.name=='r_town_code'){
						document.forms[0].r_town.value= '';
					 }
					 else if(target.name=='m_town_code'){
						document.forms[0].m_town.value= '';
					 }
					}
					target.value='';
				}
            } 


async function callCataegorySearch()
{
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		locale=document.forms[0].locale.value;
		var sql="select WAITLIST_CATEGORY_CODE code, LONG_DESC description from OA_WAITLIST_CATEGORY_lang_vw  where upper(LONG_DESC) like upper(?) and upper(WAITLIST_CATEGORY_CODE) like upper(?) and language_id='"+locale+"'";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("Common.WaitList.label","COMMON")+"-"+getLabel("Common.category1.label","COMMON"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].category_desc_txt.value=desc;
			document.forms[0].category_code.value=code;
		}else
		{
			document.forms[0].category_desc_txt.value="";
			document.forms[0].category_code.value="";
		}
}

function disableData()
{
	if(document.forms[0].pat_id1)
	{
if(document.forms[0].pat_id1.value!="")
{	
if(document.forms[0].pat_id1!=null)
//document.forms[0].pat_id1.readOnly=true; 
document.forms[0].pat_id1.disabled=true; /*this line Added for this incident MMS-SCF-0105 [IN:043502]*/
if(document.forms[0].referal_id1!=null)
document.forms[0].referal_id1.readOnly=true;
if(document.forms[0].national_id_no!=null)
document.forms[0].national_id_no.readOnly=true;
if(document.forms[0].other_alt_type!=null)
document.forms[0].other_alt_type.disabled=true;
if(document.forms[0].alert_reqd_yn!=null)
document.forms[0].alert_reqd_yn.readOnly=true;
if(document.forms[0].alt_id1_no!=null)
document.forms[0].alt_id1_no.readOnly=true;
if(document.forms[0].referal_id1!=null)
document.forms[0].referal_id1.readOnly=true;
if(document.forms[0].alt_id2_no!=null)
document.forms[0].alt_id2_no.readOnly=true;
if(document.forms[0].alt_id3_no!=null)
document.forms[0].alt_id3_no.readOnly=true;
if(document.forms[0].alt_id4_no!=null)
document.forms[0].alt_id4_no.readOnly=true;
if(document.forms[0].srch!=null)
document.forms[0].srch.disabled=true;
document.forms[0].ref_id_search.disabled=true;
document.forms[0].srch_code.disabled=true;
document.forms[0].clear1.disabled=true;

}
	}

}

function reset()
{
	var function_id=frames[1].frames[1].document.forms[0].functionId.value
	var call_from=frames[1].frames[0].document.forms[0].call_from.value;	
		
	if(function_id=='PROCD_REGISTRATION')
	{
	function_name=getLabel("Common.RegisterVisit.label",'Common')+" "+getLabel("Common.to.label",'Common')+" "+getLabel("Common.ProcedureUnit.label",'Common');
	}else
	{
	function_name=getLabel("Common.RegisterVisit.label",'Common')
	}
	
  if(call_from=="CA")	{
	  self.frames[1].frames[3].document.forms[0].reset();
  }else{					 //parent.content.location.href='../../eOP/jsp/VisitRegistration.jsp?menu_id=OP&module_id=OP&function_id='+function_id+'&function_name='+function_name+'&function_type=F&access=NYNNN';
	parent.content.location.reload();
  }
	
}

function chk_max_walkin()
{

	var functionId="";
    if(frames[1].frames[3].document.forms[0].functionId.value)  
	{
		functionId = frames[1].frames[3].document.forms[0].functionId.value;
	}
	
	var locntype = "";

	if(functionId=="VISIT_REGISTRATION" || functionId == "")
    {
        locntype = "C";
    }
	else if(functionId=="PROCD_REGISTRATION")
	{
	    locntype = "E";
    }	

	var practitioner_id = "";
	
	if(frames[1].frames[3].document.forms[0].attend_practitioner_id.value)  
	{
		practitioner_id = frames[1].frames[3].document.forms[0].attend_practitioner_id.value;
	}


	if(localeName=="en"){
		var visit_regn_date_time=frames[1].frames[3].document.forms[0].vst_regn_date_time.value;	 
	}else{
		var visit_regn_date_time = convertDate(frames[1].frames[3].document.forms[0].vst_regn_date_time.value,"DMYHMS",localeName,"en");	
	}
	var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='validation_form' id='validation_form' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='callfunc' id='callfunc' value='VisitRegn'><input type='hidden' name='clinic_code' id='clinic_code' value='"+frames[1].frames[3].document.forms[0].assign_care_locn_code.value+"'><input type='hidden' name='vst_regn_date_time' id='vst_regn_date_time' value='"+visit_regn_date_time+"'><input type='hidden' name='oper_stn_id' id='oper_stn_id' value='"+frames[1].frames[3].document.forms[0].oper_stn_id.value+"'><input type='hidden' name='locntype' id='locntype' value='"+locntype+"'><input type='hidden' name='att_pract_id' id='att_pract_id' value='"+practitioner_id+"'><input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+frames[1].frames[3].document.forms[0].bl_install_yn.value+"'><input type='hidden' name='appt_ref_no' id='appt_ref_no' value='"+frames[1].frames[3].document.forms[0].appt_ref_no.value+"'><input type='hidden' name='invitation_no' id='invitation_no' value='"+frames[1].frames[3].document.forms[0].invitation_no.value+"'><input type='hidden' name='patient_id' id='patient_id' value='"+frames[1].frames[3].document.forms[0].patient_id.value+"'/><input type='hidden' name='bl_success' id='bl_success' value='"+frames[1].frames[3].document.forms[0].bl_success.value+"'/></form></body></html>"; 
	// Include appt_ref_no Issue Fix against Incident Number : 35375
	// Include invitation_no Issue Fix against Incident Number : 35375
	// changed for package billing 	 

	 messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
	
	 if(messageFrame!=null)
	 {
		 messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		 messageFrame.document.validation_form.submit();
	 }	 
}


async function apply(allow_flag) 
{
 
 frames_list = frames[1].frames[3];

var regref=getLabel('Common.Register.label','Common')+" "+getLabel('Common.Visit.label','Common');
commontoolbarFrame.document.location.href = "../../eCommon/jsp/commonToolbar.jsp?menu_id=OP&module_id=OP&function_id=VISIT_REGISTRATION&			function_name="+regref+"&function_type=F&access=NYNNN&home_required_yn=Y&expand=0";	

	/*if(f_query_add_mod.patient_main.checkin_tab){
		f_query_add_mod.patient_main.checkin_tab.disabled=true;
	}
	if(f_query_add_mod.patient_main.addvisit_tab){
		f_query_add_mod.patient_main.addvisit_tab.disabled=true;
	}
	if(f_query_add_mod.patient_main.invitation_tab){
		f_query_add_mod.patient_main.invitation_tab.disabled=true;
	}*/
	frames_list.document.getElementById("new_episode_yn").value=frames_list.document.getElementById('new_op_episode_yn').value;
var downtimePatient = frames_list.document.getElementById("downtimePatient").value;

if(downtimePatient=="false"){
	var res_class="";
	
	if(frames_list.document.getElementById('resource_class') != null)	{
		 res_class=frames_list.document.getElementById('resource_class').value;
	}							
							
	if(frames_list.document.getElementById('clptype') != null){
	res_class=frames_list.document.getElementById('clptype').value;
	}	
 
	if( frames_list.document.getElementById('assign_care_locn_code') != null)	{
		frames_list.document.getElementById('assign_care_locn_code').disabled = false ;
	}
	
	var sstyle="";
	if(frames_list.document.getElementById('sStyle') != null)
		sstyle=frames_list.document.getElementById('sStyle').value;
	
	if(frames_list.document.forms[0].function_name != null)
	{
		if(frames_list.document.forms[0].function_name.value=="Generate_File")
		{
			
			if (frames_list.document.forms[0].ident_at_checkin.value =="P") {
				var fields = new Array (frames_list.document.forms[0].assign_care_locn_code,
                        frames_list.document.forms[0].visit_adm_type,
                        frames_list.document.forms[0].service_code);

				var names  = new Array (getLabel("Common.Location.label","Common"),getLabel("Common.visittype.label","Common"),getLabel("Common.service.label","Common"));

				var ordreq=frames_list.document.getElementById('order_req').value;   

				if(frames_list.document.forms[0].isRoomMandatoryRegVisit.value == "true" && frames_list.document.forms[0].room_img.style.visibility == "visible"){ // Added by mujafar for NMC-JD-CRF-0025
						fields[fields.length++]= frames_list.document.forms[0].room_no ;
						names[names.length++]=getLabel("Common.room.label","Common");
				}	
           
			/*Below line modified for this incident GHL-SCF-851 [IN:053049]*/
			
               if((res_class=="P"&&frames_list.document.forms[0].gifpop&&frames_list.document.forms[0].gifpop.style.visibility=="visible") || (res_class=="P"&&frames_list.document.forms[0].gifpoppract&&frames_list.document.forms[0].gifpoppract.style.visibility=="visible")){ 
						fields[fields.length++]= frames_list.document.forms[0].pract_name ;
						names[names.length++]=getLabel("Common.practitioner.label","Common");
				}					
				if(ordreq != "" && ordreq == "R")
				{
					if(frames_list.document.forms[0].multiple_orders_yn.value=='N') {							
						fields[fields.length++]= frames_list.document.forms[0].order_cat_code;
						names[names.length++]=getLabel("Common.ordercatalog.label","Common");	
						
					}
				}				
				//End GHL-SCF-851 [IN:053049]		
			} else { 
				if(frames_list.document.forms[0].visit_type_derv_rule.value =="S" || frames_list.document.forms[0].visit_type_derv_rule.value =="B" ){
					var fields = new Array (frames_list.document.forms[0].assign_care_locn_code,
					frames_list.document.forms[0].visit_adm_type, frames_list.document.forms[0].service_code);
					var names  = new Array (getLabel("Common.Location.label","Common"),getLabel("Common.visittype.label","Common"),getLabel("Common.service.label","Common")); 
					var ordreq=frames_list.document.getElementById('order_req').value;
					
					if(frames_list.document.forms[0].isRoomMandatoryRegVisit.value == "true" && frames_list.document.forms[0].room_img.style.visibility == "visible"){ // Added by mujafar for NMC-JD-CRF-0025
						fields[fields.length++]= frames_list.document.forms[0].room_no ;
						names[names.length++]=getLabel("Common.room.label","Common");
				}	
				
				//Below line annded and modified for this incident GHL-SCF-851 [IN:053049]						
				if((res_class=="P"&&frames_list.document.forms[0].gifpop&&frames_list.document.forms[0].gifpop.style.visibility=="visible") || (res_class=="P"&&frames_list.document.forms[0].gifpoppract&&frames_list.document.forms[0].gifpoppract.style.visibility=="visible")){ 
						fields[fields.length++]= frames_list.document.forms[0].pract_name ;
						names[names.length++]=getLabel("Common.practitioner.label","Common");
			    }					
				if(ordreq != "" && ordreq == "R"){					
					 if(frames_list.document.forms[0].multiple_orders_yn.value=='N') {							
						fields[fields.length++]= frames_list.document.forms[0].order_cat_code;
						names[names.length++]=getLabel("Common.ordercatalog.label","Common");
					}										
				}
                //End GHL-SCF-851 [IN:053049]
				
				}else{  
					var fields = new Array (frames_list.document.forms[0].assign_care_locn_code,
					frames_list.document.forms[0].visit_adm_type, frames_list.document.forms[0].service_code,frames_list.document.forms[0].pract_name);
					var names  = new Array (getLabel("Common.Location.label","Common"),getLabel("Common.visittype.label","Common"),getLabel("Common.service.label","Common"),getLabel("Common.practitioner.label","Common")); 
					var ordreq=frames_list.document.getElementById('order_req').value;							
												
					if(ordreq != "" && ordreq == "R"){					
						if(frames_list.document.forms[0].multiple_orders_yn.value=='N') {							
							fields[4]= frames_list.document.forms[0].order_cat_code;
							names[4]=getLabel("Common.ordercatalog.label","Common");
						}										
					}	
				}				 
				
				
			}

				if(frames_list.document.forms[0].visit_back_yn.value=="Y"){
					if(frames_list.document.forms[0].vst_regn_date_time.value=="") {							
						 fields[fields.length]=frames_list.document.forms[0].vst_regn_date_time;
						 names[names.length]=getLabel("Common.VisitDateTime.label","Common");
					}	
				}

				/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
				if(frames_list.document.forms[0].remarks_img!=null){
					if(frames_list.document.forms[0].remarks_img.style.visibility == 'visible')
					{
						fields[fields.length] = frames_list.document.forms[0].other_remarks;
						names[names.length] = getLabel("Common.remarks.label","Common");
					}
				}
				/*End ML-MMOH-CRF-1114*/
		}
    }
	/*Added for JD-CRF-0183 [IN:041353] By Dharma on 26th Nov 2013 Start*/
	var action_on_pract_schedule	= frames_list.document.forms[0].action_on_pract_schedule.value;
	var cl_code						= frames_list.document.forms[0].assign_care_locn_code.value;

	var block_date_time		= frames_list.document.forms[0].vst_regn_date_time.value;
	var datearr				= block_date_time.split(" ");
	var block_date			= datearr[0];
	var block_time			= datearr[1];
	if(frames_list.document.forms[0].attend_practitioner_id.value!=null && frames_list.document.forms[0].attend_practitioner_id.value!="" && action_on_pract_schedule!="N" ){
		var pract_id			= frames_list.document.forms[0].attend_practitioner_id.value;
		FNCheckBlockScheduleForPract(block_date,pract_id,block_time,frames_list,'registervisit',cl_code);
		var is_prac_blocked	= frames_list.document.forms[0].is_prac_blocked.value;
	
		if(is_prac_blocked){
		
			if(action_on_pract_schedule=="S"){
				var err_msg	= getMessage("BLOCK_SCH_FOR_PRACT","OP");
				err_msg		= err_msg.replace("#",block_date_time);
				alert(err_msg);
				commontoolbarFrame.location.reload();
				return;
			}else if(action_on_pract_schedule=="W"){
				var err_msg	= getMessage("BLOCK_SCH_FOR_PRACT_WARNING","OP");
				err_msg		= err_msg.replace("#",block_date_time);
				if(confirm(err_msg)){
				
				
				}else{
					commontoolbarFrame.location.reload();
					return;
				}
			}
		
		}
		
	}
	/*Added for JD-CRF-0183 [IN:041353] By Dharma on 26th Nov 2013 End*/
	
    if (frames_list.document.forms[0].visit_charge_stage != null && frames_list.document.forms[0].visit_charge_stage.value=="R" && frames_list.document.forms[0].bl_interface_yn.value=="Y")    {
        show_visit_dtls('N');
		
    }
    else
    {  
		if( frames_list.document.getElementById('assign_care_locn_code') != null)	{		
			var errs = frames_list.checkFieldsLocal( fields, names, messageFrame);		
			
			if(errs == null)    errs = '';
			if (frames_list.document.forms[0].bl_success.value=="N" &&  frames_list.document.forms[0].bl_install_yn.value=="Y"){
				//errs += window.frames[1].frames[1].getMessage("CHG_FIN_DTLS_OP","OP");
				await chkOnSub('onApply');
				if(frames_list.document.forms[0].bl_success.value=="N")
				errs = getMessage("FINANCIAL_DET_MANDATORY",'MP')+"<br>";
			}else{	
			if(frames_list.document.forms[0].bl_install_yn.value=="Y"){
				if(frames_list.document.forms[0].appt_ref_no_2.value == "")	{
					if(frames_list.document.getElementById('dummy_locn_code') != null && (frames_list.document.getElementById('dummy_locn_code').value   != frames_list.document.forms[0].assign_care_locn_code.value )){
						//errs+= window.frames[1].frames[1].getMessage("CHG_FIN_DTLS_OP","OP");					
						await chkOnSub('onApply');
						if(frames_list.document.forms[0].bl_success.value=="N")
						errs = getMessage("FINANCIAL_DET_MANDATORY",'MP')+"<br>";						
					}
					else if(frames_list.document.getElementById('dummy_visit_type') != null && ((frames_list.document.getElementById('dummy_visit_type').value   != frames_list.document.forms[0].visit_adm_type.value) && (frames_list.document.forms[0].visit_type_derv_rule.value!='B')) )//condition modified for the incident MMs-SCF-0163
					{
						//errs+=window.frames[1].frames[1].getMessage("CHG_FIN_DTLS_OP","OP");					
						await chkOnSub('onApply');
						if(frames_list.document.forms[0].bl_success.value=="N")
						errs = getMessage("FINANCIAL_DET_MANDATORY",'MP')+"<br>";						
					}
					else if(frames_list.document.getElementById('dummy_visit_dttime') != null && (frames_list.document.getElementById('dummy_visit_dttime').value   != frames_list.document.forms[0].vst_regn_date_time.value) )
					{
						//errs+=window.frames[1].frames[1].getMessage("CHG_FIN_DTLS_OP","OP");	
						await chkOnSub('onApply');
						if(frames_list.document.forms[0].bl_success.value=="N")
						errs = getMessage("FINANCIAL_DET_MANDATORY",'MP')+"<br>";
					}
				}
			}   	
			}
						
		
			if(errs == '')
			{    
				if(frames_list.document.forms[0].visit_adm_type.disabled == true){
					frames_list.document.forms[0].visit_adm_type.disabled=false;
				}
				frames_list.document.forms[0].room_no1.value=frames_list.document.forms[0].room_no.value;
				//following condition added for the SCF - MMS-SCF-163 - Begin
				if(frames_list.document.forms[0].visit_type_derv_rule.value!='B'){
					chk_max_walkin(); 		
				}else{
					if(frames_list.document.forms[0].proceed_visit_regn.value!='N'){
						chk_max_walkin(); 		
					}else{
						frames_list.document.forms[0].proceed_visit_regn.value='Y';
						var errs="";
						messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errs;
						
					}
				}
				//Above condition added for the SCF - MMS-SCF-163  - End
				//chk_max_walkin(); 		

				var fn_status = frames_list.document.forms[0].function_name.value ;			
			}
			else{
				
				if(frames_list.document.forms[0].oa_install_yn.value =="Y" ){					
					messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errs ;					
				}
				else{				
					messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errs ;				
				}
				/*if(f_query_add_mod.patient_main.checkin_tab){
					f_query_add_mod.patient_main.checkin_tab.disabled=false;
				}
				if(f_query_add_mod.patient_main.addvisit_tab){
					f_query_add_mod.patient_main.addvisit_tab.disabled=false;
				}
				if(f_query_add_mod.patient_main.invitation_tab){
					f_query_add_mod.patient_main.invitation_tab.disabled=false;
				}*/
			}
		}else{
			var errs="";
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errs;
			/*if(f_query_add_mod.patient_main.checkin_tab){
				f_query_add_mod.patient_main.checkin_tab.disabled=false;
			}
			if(f_query_add_mod.patient_main.addvisit_tab){
				f_query_add_mod.patient_main.addvisit_tab.disabled=false;
			}
			if(f_query_add_mod.patient_main.invitation_tab){
				f_query_add_mod.patient_main.invitation_tab.disabled=false;
			}*/
		}
    }
		
    	/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] Start*/
		var reg_date_time	= frames_list.document.forms[0].reg_date_time.value;
		var visit_date_time	= frames_list.document.forms[0].vst_regn_date_time.value;
		
		if(reg_date_time!="" && visit_date_time!=""){
			if(!isAfter(visit_date_time,reg_date_time,"DMYHMS",localeName)){ 
				var error = getMessage('REG_DATE_TIME_SHOULD_GR_EQUAL','Common');			
				error = error.replace('$',getLabel("Common.VisitDateTime.label",'Common'));	
				errs +=error+ "<br>";
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errs ;
			}
		}
		/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] End*/
		
		/*Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1*/
		var isQMSInOPVisitRegAppl = frames_list.document.forms[0].isQMSInOPVisitRegAppl.value;
		var practitioner_id = frames_list.document.forms[0].attend_practitioner_id.value;
		//var qms_queue_pkid = frames_list.document.forms[0].qms_queue_pkid.value;

		if(isQMSInOPVisitRegAppl == 'true'){
		var qms_queue_pkid = frames_list.document.forms[0].qms_queue_pkid.value;
			if(qms_queue_pkid == ""){
				var err_msg	= getMessage("QUEUE_PKID_BLANK","OP");
				
				if(confirm(err_msg)){
					frames_list.document.forms[0].common_queue_status.value = "E";
					frames_list.document.forms[0].common_queue_status_msg.value = "User missed entering Primary Key of Queue No";
				}else{
					frames_list.document.forms[0].qms_queue_pkid.focus();
					var status_msg = "";
					messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+status_msg;
				}
			}
			
			if(practitioner_id != ""){
				getVirtualQueueDtls('onApply');
			}
		}
		/*End TH-KW-CRF-0020.1*/

		/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start*/
		if(errs==''){
			var isForm60Warning=chkForm60OrPanCardAvail(frames_list.document.forms[0].patient_id,frames_list.document.forms[0].isForm60Available.value);
			//added by Sangeetha on 10/apr/17 for KDAH-CRF-0347
			var validationForPanCardAvail=PanCardAvailCheck(frames_list.document.forms[0].patient_id,frames_list.document.forms[0].validationForPanCardAvail.value);

			if(validationForPanCardAvail == "Y"){
				frames_list.document.forms[0].form60_YN.value= "Y";
				alert(getMessage("VALIDATE_PANCARD_MNDT_FORM60",'MP'));
			}else{
			 if(validationForPanCardAvail == "N")
				frames_list.document.forms[0].form60_YN.value= "N";
			 if(isForm60Warning=="Y"){
				alert(getMessage("FORM_60_OR_PAN_CARD",'MP'));
			 }
			}
		}
		/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End*/


	   var call_from=frames[1].frames[0].document.forms[0].call_from.value;
	   
	   if(call_from == "CA")
	   { 
		   setTimeout('assignToolBar()',100);
	   }	
	   }else{
	   	alert(getMessage("DOWNTIME_PATIENT_NOT_ALLOWED",'COMMON'));
				commontoolbarFrame.location.reload();
	   }
}

function assignToolBar()
{
	
	commontoolbarFrame.document.location.href = "../../eCommon/jsp/commonToolbar.jsp?menu_id=OP&module_id=OP&function_id=VISIT_REGISTRATION&function_name=Register%20Visit&function_type=F&access=NYNNN&home_required_yn=N";
	
}

function onSuccess(){
}
/*Added By Dharma on 25th Nov 2014 against HSA-SCF-0145 [IN:051698] Start*/
function onError(err){
	if(err=="NO_REC_ON_OA_APPT"){
		var mes	= getMessage("APPT_CANCELLED_CANNOT_PROCEED","OP");
		parent.parent.f_query_add_mod.location.reload();
		parent.parent.messageFrame.document.location.href="../eCommon/jsp/error.jsp?err_num="+mes;
	}
}
/*Added By Dharma on 25th Nov 2014 against HSA-SCF-0145 [IN:051698] End*/

function ChangeObj2(obj,oa_install_yn)
{
	var nat_id_prompt;
	var obj_value       = obj.value;
	var obj_name        = obj.name;
	

	ClearList(obj);	   
	functionId=parent.frames[3].document.forms[0].functionId.value
	register_visit_yn=parent.frames[1].document.forms[0].register_visit_yn.value
	
	if(parent.frames[1].document.forms[0].nat_id_prompt)
		nat_id_prompt=parent.frames[1].document.forms[0].nat_id_prompt.value		
	or_install_yn=parent.frames[3].document.forms[0].or_install_yn.value
		
			if(obj.name=="visit_adm_type") 	{
				
			   if(obj.value!="") {	 
					parent.frames[3].document.forms[0].order_cat_txt.readOnly=false;
					parent.frames[3].document.forms[0].order_cat_butt.disabled = false;
						//Modified for the CRF - Bru-HIMS-CRF-0198
					if(parent.frames[3].document.forms[0].pract_butt!=null && parent.frames[3].document.forms[0].multi_speciality_yn.value=='N'){ 
						parent.frames[3].document.forms[0].pract_butt.disabled = false;
						parent.frames[3].document.forms[0].pract_name.readOnly=false;
					}
			   } else {								 
				   if(parent.frames[3].document.forms[0].visit_type_derv_rule.value=="S" || parent.frames[3].document.forms[0].visit_type_derv_rule.value=="B"){//included for the CRF - MMS-QH-CRF 41.1
						parent.frames[3].document.forms[0].order_cat_txt.readOnly=true;
						parent.frames[3].document.forms[0].order_cat_butt.disabled = true;			
						if(parent.frames[3].document.forms[0].pract_butt!=null)
							parent.frames[3].document.forms[0].pract_name.value=""; 
						parent.frames[3].document.forms[0].pract_name.readOnly=true;
						if(parent.frames[3].document.forms[0].pract_butt!=null)
							parent.frames[3].document.forms[0].pract_butt.disabled = true;
						/* below line added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */ 
						if(parent.frames[3].document.forms[0].order_count_select && parent.frames[3].document.forms[0].order_count_select.value==0){
						clearOrderCatalog();	
						}
				   }
					
				  }
			}
	/*Below line modified for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
		/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
	 var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient6' id='dummypromptpatient6' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='visit_adm_type'><input type='hidden' name='service_code' id='service_code' value='"+parent.frames[3].document.forms[0].service_code.value+"'><input type = 'hidden' name = 'patient_id' value = '"+parent.frames[3].document.forms[0].patient_id.value+"' ><input type = 'hidden' name = 'care_locn_code' value = '"+parent.frames[3].document.forms[0].assign_care_locn_code.value+"'><input type='hidden' name='episodeReqd' id='episodeReqd' value='"+parent.frames[3].document.forms[0].build_episode_rule.value+"'><input type='hidden' name='visit_adm_type' id='visit_adm_type' value='"+parent.frames[3].document.forms[0].visit_adm_type.value+"'><input type = 'hidden' name = 'q_visit_adm_type_ind' value = '"+parent.frames[3].document.forms[0].q_visit_adm_type_ind.value+"' ><input type = 'hidden' name = 'functionId' value = '"+parent.frames[3].document.forms[0].functionId.value+"'><input type='hidden' name='or_install_yn' id='or_install_yn' value='"+or_install_yn+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='register_visit_yn' id='register_visit_yn' value='"+register_visit_yn+"'><input type='hidden' name='override_vtype_on_epsd_yn' id='override_vtype_on_epsd_yn' value='"+parent.frames[3].document.forms[0].override_vtype_on_epsd_yn.value+"'><input type='hidden' name='visit_type_derv_rule' id='visit_type_derv_rule' value='"+parent.frames[3].document.forms[0].visit_type_derv_rule.value+"'><input type = 'hidden' name = 'appt_vst_type_code' value = '"+parent.frames[3].document.forms[0].q_visit_adm_type.value+"' ><input type='hidden' name='populate_visit_type' id='populate_visit_type' value='"+parent.frames[3].document.forms[0].populate_visit_type.value+"'><input type = 'hidden' name = 'order_count_select' value = '"+parent.frames[3].document.forms[0].order_count_select.value+"' ><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'></form></body></html>";  
	 
		var message_frame=parent.parent.frames[2];
		 
		if(message_frame!=null) {
		  message_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		  message_frame.document.dummypromptpatient6.submit();
		}
		
		//ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005
		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		
		var patient_id= document.forms[0].patient_id.value;
		var locn_type = document.forms[0].locn_type.value;
		var assign_care_locn_code =document.forms[0].assign_care_locn_code.value;
		var speciality_code = document.forms[0].locationSpeciality.value;
		var service_code=document.forms[0].service_code.value;
		
		xmlStr = "<root><SEARCH locn_type=\""+locn_type+"\" assign_care_locn_code=\""+assign_care_locn_code+"\" speciality_code=\""+speciality_code+"\" service_code=\""+service_code+"\" patient_id=\""+patient_id+"\" facility_id=\""+document.forms[0].facilityid.value+"\" action='visit_clinic' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eOP/jsp/OPIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		var response = trimString(xmlHttp.responseText);
		var responseArray =  new Array();
		responseArray = response.split(',');
	
		var category = responseArray[0];
		var firstVisitReferalId=(responseArray[1] != "null" && responseArray[1]!="")?responseArray[1]:"";
		var referal_id = "";
		if(document.forms[0].referral_code.value!=""){
			referal_id = document.forms[0].referral_code.value 
		} else {
			document.getElementById("refdetails").innerHTML ="";
		}
		
		
		var visitType = document.forms[0].visit_adm_type.value;
		var isClinicCategory = document.forms[0].isClinicCategory.value;
		var firstVisit = document.forms[0].firstVisitList.value;	
		var referral_req_yn = document.forms[0].referral_req_yn.value;	
		var firstVisitList = new Array();
		firstVisitList = firstVisit.split(',');
		var isFirstVisit = false;
		for(i=0;i<firstVisitList.length;i++){
			if(firstVisitList[i]==visitType){
				isFirstVisit = true;
				break;
			}
		}
		
		var followUpVisit = document.forms[0].followUpVisitList.value;
		var followUpVisitList = new Array();
		followUpVisitList = followUpVisit.split(',');
		var isfollowUpVisit = false;
		for(i=0;i<followUpVisitList.length;i++){
			if(followUpVisitList[i]==visitType){
				isfollowUpVisit = true;
				break;
			}
		}
		
		if((firstVisitReferalId!="" && firstVisitReferalId != "null") && isfollowUpVisit==true){
			var locale=document.forms[0].locale.value; 
			document.forms[0].financial_detail_ref_id.value= firstVisitReferalId;
			document.forms[0].referral_code.value= firstVisitReferalId;
			
			var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr = "<root><SEARCH referal_id=\""+firstVisitReferalId+"\" locale=\""+locale+"\" action='visit_clinic_referalId' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eOP/jsp/OPIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText = xmlHttp.responseText
			var ref_dtls = trimString(xmlHttp.responseText);
			document.getElementById("refdetails").innerHTML = ref_dtls;
		}
		
		
		if(isClinicCategory=="true" && referral_req_yn=="Y" && referal_id=="" && isFirstVisit==true && (category =="P" || category=="S")){
			document.getElementById('reqReff').style.visibility='visible';
		} else {
			document.getElementById('reqReff').style.visibility='hidden';
		}
		//End
}

function ChangeObj1(obj,oa_install_yn)
{
	
	var p_referral_id = parent.frames[1].document.forms[0].referal_id1.value;
	var nat_id_prompt;
	var obj_value       = obj.value;
	var obj_name        = obj.name;
	ClearList(obj);	    
	functionId=parent.frames[3].document.forms[0].functionId.value
	if(parent.frames[1].document.forms[0].nat_id_prompt)
		nat_id_prompt=parent.frames[1].document.forms[0].nat_id_prompt.value
	register_visit_yn=parent.frames[1].document.forms[0].register_visit_yn.value
	/*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
	/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
	// MODIFIED by mujafar for NMC-JD-CRF-0025
	var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient6' id='dummypromptpatient6' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type = 'hidden' name = 'list_name' value = 'populate_service'><input type = 'hidden' name = 'care_locn_code' value = '"+parent.frames[3].document.forms[0].assign_care_locn_code.value+"'><input type = 'hidden' name = 'invitation_no' value = '"+parent.frames[3].document.forms[0].invitation_no.value+"'><input type = 'hidden' name = 'appt_ref_no' value = '"+parent.frames[3].document.forms[0].appt_ref_no_2.value+"'><input type = 'hidden' name = 'functionId' value = '"+parent.frames[3].document.forms[0].functionId.value+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='register_visit_yn' id='register_visit_yn' value='"+register_visit_yn+"'><input type='hidden' name='p_referral_id' id='p_referral_id' value='"+p_referral_id+"'><input type = 'hidden' name = 'order_count_select' value = '"+parent.frames[3].document.forms[0].order_count_select.value+"' ><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'><input type = 'hidden' name = 'isRoomMandatoryRegVisit' value = '"+parent.frames[3].document.forms[0].isRoomMandatoryRegVisit.value+"'></form></body></html>";  
	var message_frame=parent.parent.frames[2];
	message_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	message_frame.document.dummypromptpatient6.submit();  
	clearOrderCatalog();
}

function ClearList(object)
{
	
	var list1   = "";
    var length  ="";
    //var element = parent.frames[3].document.forms[0].document.createElement('OPTION');
    var element = parent.frames[3].document.createElement('OPTION');

	if(object != null){
		var obj = object.name;
	}
 
    element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
    element.value="";   
	 
    if(obj=='vis_det_temp_desc'){	
		var length  =parent.frames[3].document.forms[0].service_code.length;
		//var element = parent.frames[3].document.forms[0].document.createElement('OPTION');
		var element = parent.frames[3].document.createElement('OPTION');
		element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
		element.value="";
	    for(i=1;i<length;i++)
          parent.frames[3].document.forms[0].service_code.remove(1);

		var length  =parent.frames[3].document.forms[0].visit_adm_type.length;
        for(i=1;i<length;i++)
          parent.frames[3].document.forms[0].visit_adm_type.remove(1);
        var length  =parent.frames[3].document.forms[0].room_no.length;
        for(i=1;i<length;i++)
          parent.frames[3].document.forms[0].room_no.remove(1);		 
		parent.frames[3].document.getElementById('roomDesc').innerHTML="";
		  ClearList(parent.frames[3].document.forms[0].room_no);

		ClearList(parent.frames[3].document.forms[0].visit_adm_type);
		ClearList(parent.frames[3].document.forms[0].service_code);
	
	}	
	
	
	
	if(obj=='service_code'){	
		var length  =parent.frames[3].document.forms[0].subservice_code.length;
		//var element = parent.frames[3].document.forms[0].document.createElement('OPTION');
		var element = parent.frames[3].document.createElement('OPTION');
		element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
		element.value="";
	    for(i=1;i<length;i++)
          parent.frames[3].document.forms[0].subservice_code.remove(1);
		
	if(parent.frames[3].document.forms[0].visit_type_derv_rule.value == "S" || parent.frames[3].document.forms[0].visit_type_derv_rule.value == "B"){
		var length  =parent.frames[3].document.forms[0].visit_adm_type.length;
        for(i=1;i<length;i++)
          parent.frames[3].document.forms[0].visit_adm_type.remove(1);		
		ClearList(parent.frames[3].document.forms[0].visit_adm_type);
	}
		ClearList(parent.frames[3].document.forms[0].subservice_code);
	}	
	if (obj == "visit_adm_type_ind"){
		if(parent.frames[3].document.forms[0].visit_type != null){
			list1   = parent.frames[3].document.forms[0].visit_type;
			length  = list1.length;
			for(i=1;i<length;i++)
				list1.remove(1);
		}
		if(parent.frames[3].document.forms[0].assign_care_locn_code != null){
			list1 = parent.frames[3].document.forms[0].assign_care_locn_code;
			length  = list1.length;
			for(i=1;i<length;i++)
				list1.remove(1);
		}
       	if(parent.frames[3].document.forms[0].visit_adm_type != null){ // Visit Type 
		
			list1 = parent.frames[3].document.forms[0].visit_adm_type;
			length  = list1.length;
			for(i=1;i<length;i++)
				list1.remove(1);
		}     
        parent.frames[3].document.forms[0].visit_adm_type.value="";
        parent.frames[3].document.forms[0].vst_type_ind.value="";//Added for the SCF - MMS-SCF-0167
		parent.frames[3].document.forms[0].attend_practitioner_id.value=""; 
        
        parent.frames[3].document.forms[0].subservice_code.value="";// Sub Service
    }
    else if (obj == "assign_care_locn_code"){ 
		list1 = parent.frames[3].document.forms[0].service_code;
        length  = list1.length;
        for(i=1;i<length;i++)
            list1.remove(1);

		var length  =parent.frames[3].document.forms[0].room_no.length;
   	
        for(i=1;i<length;i++)
          parent.frames[3].document.forms[0].room_no.remove(1);
		parent.frames[3].document.getElementById('roomDesc').innerHTML="";
		parent.frames[3].document.forms[0].pract_name.value = "";
		parent.frames[3].document.forms[0].attend_practitioner_id.value = "";
		
		ClearList(parent.frames[3].document.forms[0].room_no);
		ClearList(parent.frames[3].document.forms[0].service_code);
		ClearList(parent.frames[3].document.forms[0].pat_class);
		if(parent.frames[3].document.forms[0].visit_adm_type != null){ // Visit Type 		
			list1 = parent.frames[3].document.forms[0].visit_adm_type;
			
			length  = list1.length;
			for(i=1;i<length;i++)
				list1.remove(1);
			parent.frames[3].document.forms[0].visit_adm_type.value="";
			parent.frames[3].document.forms[0].vst_type_ind.value="";//Added for the SCF - MMS-SCF-0167
			if(parent.frames[3].document.forms[0].visit_adm_type.disabled==false)
				parent.frames[3].document.forms[0].visit_adm_type.disabled = true;
		}     
        
    }
    else if (obj == "visit_adm_type"){ 
		var apptref="";
        list1 = parent.frames[3].document.forms[0].attend_practitioner_id;
		if(parent.frames[3].document.forms[0].appt_ref_no != null)
		{
			apptref=parent.frames[3].document.forms[0].appt_ref_no.value;
		}

        length  = list1.length;
        for(i=1;i<length;i++)
            list1.remove(1);
		if(apptref == ""){      
			parent.frames[3].document.forms[0].pract_type.value="";
		}
		var isClinicCategory = document.forms[0].isClinicCategory.value;
		var referral_req_yn = document.forms[0].referral_req_yn.value;	
		if(isClinicCategory=="true" && referral_req_yn=="Y"){
			document.getElementById('reqReff').style.visibility='hidden';
		}
			
    }
    else if (obj == "attend_practitioner_id"){		
        if(parent.frames[3].document.forms[0].pract_type != null)
            parent.frames[3].document.forms[0].pract_type.value="";
    }
	else if(obj == "service_code"){
		list1 = parent.frames[3].document.forms[0].subservice_code;
        length  = list1.length;
        for(i=1;i<length;i++)
            list1.remove(1);
		
		ClearList(parent.frames[3].document.forms[0].subservice_code);
	}
	else if(obj == "pat_class"){
		list1 = parent.frames[3].document.forms[0].pat_class;
        length  = list1.length;
        for(i=1;i<length;i++)
            list1.remove(1);	
	}

	/*Below Condition Modified on 11th May 2020 by Dharma against NMC-JD-SCF-0057 [IN:072961] */
   // if (obj == "visit_adm_type_ind" || obj == "assign_care_locn_code" || obj == "visit_adm_type"){ 
    if (obj == "visit_adm_type_ind" || obj == "assign_care_locn_code" || (obj == "visit_adm_type" && parent.frames[3].document.getElementById('vst_type_ind').value=='F') ){ 
               if (parent.frames[3].document.getElementById("op_episode_visit_num") != null){ // OP Episode Number and Visit Number
            parent.frames[3].document.forms[0].op_episode_visit_num.value="";
            parent.frames[3].document.forms[0].op_episode_id.value="";
            if(parent.frames[3].document.getElementById('episode_visit') != null)
			{
				parent.frames[3].document.getElementById('episode_visit').innerText="";
			}
            parent.frames[3].document.forms[0].old_op_episode_visit_num.value="";
            parent.frames[3].document.forms[0].old_op_episode_id.value="";
			/*if(parent.frames[3].document.forms[0].new_op_episode_yn != null)
			{
				parent.frames[3].document.forms[0].new_op_episode_yn.value="N";
				parent.frames[3].document.forms[0].new_op_episode_yn.disabled=true;
			}*/
        }
    }
	 /*Below line Added for this CRF Bru-HIMS-CRF-165.1*/
 if(parent.frames[3].document.forms[0].order_count_select && parent.frames[3].document.forms[0].order_count_select.value>0){
        if(parent.frames[3].document.forms[0].order_cat_butt)parent.frames[3].document.forms[0].order_cat_butt.disabled = true;
		if(parent.frames[3].document.forms[0].order_cat_txt)parent.frames[3].document.forms[0].order_cat_txt.disabled = true;
		//Above line modified for this incident [IN43468]
  }
  /*End this CRF Bru-HIMS-CRF-165.1*/
}



function encounterDtls(obj,oa_install_yn,val,ref_val,from_head,prev_visit)
{
	if (obj=='last_visit')
    {
		// var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient5' id='dummypromptpatient5' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='last_visit'><input type='hidden' name='patient_id' id='patient_id' value='"+parent.frames[3].document.forms[0].patient_id.value+"'><input type='hidden' name='l_encounter_id' id='l_encounter_id' value='"+parent.frames[3].document.forms[0].l_encounter_id.value+"'><input type='hidden' name='l_service_code' id='l_service_code' value='"+parent.frames[3].document.forms[0].service_code.value+"'>"		

		/*Above line commented and Below line added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
		/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient5' id='dummypromptpatient5' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='last_visit'><input type='hidden' name='patient_id' id='patient_id' value='"+parent.frames[3].document.forms[0].patient_id.value+"'><input type='hidden' name='l_encounter_id' id='l_encounter_id' value='"+parent.frames[3].document.forms[0].l_encounter_id.value+"'><input type = 'hidden' name = 'order_count_select' value = '"+parent.frames[3].document.forms[0].order_count_select.value+"'><input type='hidden' name='l_service_code' id='l_service_code' value='"+parent.frames[3].document.forms[0].service_code.value+"'><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'>"
        if(prev_visit == 'prev_visit')
            HTMLVal += "<input type='hidden' name='prev_visit' id='prev_visit' value='Y'> " ;
        HTMLVal += " </form></body></html>";

		if(oa_install_yn == "Y")
		{		
			parent.parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.frames[3].document.dummypromptpatient5.submit();
		}
		else
		{
			parent.parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.frames[3].document.dummypromptpatient5.submit();
		}
	}
}

function showPatientListforAltId1 (pat_id1) {
	var nat_id_prompt;
	functionId=parent.frames[1].frames[1].document.forms[0].functionId.value
	bl_install_yn=parent.frames[1].frames[1].document.forms[0].bl_interface_yn.value
	oper_stn_id=parent.frames[1].frames[1].document.forms[0].oper_stn_id.value
	if(parent.frames[1].frames[1].document.forms[0].nat_id_prompt)
		nat_id_prompt=parent.frames[1].frames[1].document.forms[0].nat_id_prompt.value
	build_episode_rule=parent.frames[1].frames[1].document.forms[0].build_episode_rule.value
	or_install_yn=parent.frames[1].frames[1].document.forms[0].or_install_yn.value
	emer_regn_allow_yn=parent.frames[1].frames[1].document.forms[0].emer_regn_allow_yn.value
	visit_for_inpat_yn=parent.frames[1].frames[1].document.forms[0].visit_for_inpat_yn.value
	register_visit_yn=parent.frames[1].frames[1].document.forms[0].register_visit_yn.value
	queryString=parent.frames[1].frames[1].document.forms[0].queryString.value;	
	oa_install_yn=parent.frames[1].frames[1].document.forms[0].oa_install_yn.value;

	alt_id1_desc=parent.frames[1].frames[1].document.forms[0].alt_id1_desc.value;
	alt_id2_desc=parent.frames[1].frames[1].document.forms[0].alt_id2_desc.value;
	alt_id3_desc=parent.frames[1].frames[1].document.forms[0].alt_id3_desc.value;
	alt_id4_desc=parent.frames[1].frames[1].document.forms[0].alt_id4_desc.value;
	names_in_oth_lang_yn=parent.frames[1].frames[1].document.forms[0].names_in_oth_lang_yn.value;

	
	parent.frames[1].frames[2].document.location.href='../../eCommon/html/blank.html'
	parent.frames[1].frames[3].document.location.href='../../eCommon/html/blank.html'
	parent.frames[1].frames[4].document.location.href='../../eCommon/html/blank.html'
	/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
	var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient6' id='dummypromptpatient6' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='check_pat'><input type = 'hidden' name = 'prompt_patient_id' value = '"+pat_id1+"' ><input type='hidden' name='oa_install_yn' id='oa_install_yn' value='"+oa_install_yn+"'><input type='hidden' name='fromPatidF1' id='fromPatidF1' value='true'><input type='hidden' name='functionId' id='functionId' value='"+functionId+"'><input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+bl_install_yn+"'><input type='hidden' name='build_episode_rule' id='build_episode_rule' value='"+build_episode_rule+"'><input type='hidden' name='oper_stn_id' id='oper_stn_id' value='"+oper_stn_id+"'><input type='hidden' name='or_install_yn' id='or_install_yn' value='"+or_install_yn+"'><input type='hidden' name='emer_regn_allow_yn' id='emer_regn_allow_yn' value='"+emer_regn_allow_yn+"'><input type='hidden' name='visit_for_inpat_yn' id='visit_for_inpat_yn' value='"+visit_for_inpat_yn+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='register_visit_yn' id='register_visit_yn' value='"+register_visit_yn+"'><input type='hidden' name='alt_id1_desc' id='alt_id1_desc' value='"+alt_id1_desc+"'><input type='hidden' name='alt_id2_desc' id='alt_id2_desc' value='"+alt_id2_desc+"'><input type='hidden' name='alt_id3_desc' id='alt_id3_desc' value='"+alt_id3_desc+"'><input type='hidden' name='alt_id4_desc' id='alt_id4_desc' value='"+alt_id4_desc+"'><input type='hidden' name='names_in_oth_lang_yn' id='names_in_oth_lang_yn' value='"+names_in_oth_lang_yn+"'><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'>"; 	

	HTMLVal = HTMLVal + "<input type = 'hidden' name = 'query_str' value = " + encodeURIComponent(parent.frames[1].frames[1].document.forms[0].queryString.value) + " >";	
	
	HTMLVal = HTMLVal +"</form></body></html>";

	var message_frame=parent.frames[2];		
	
	if(message_frame.document.body!=null)
	{
		message_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		message_frame.document.dummypromptpatient6.submit()
	} 
		

}
 //  Below code added for Scrum 10638
	async function funPatRegCharges(patient_id)
	{
		var patient_id = patient_id;
		var retVal_BL =    new String();

		var center='1';
		var dialogTop = "30";
		var dialogHeight = "10" ;
		var dialogWidth = '40' ;
		var title='Pat Reg Charges'
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"step1=STEP_OTH&function_id=VISIT_REGISTRATION&"+"patient_id="+patient_id;	
		
		retVal_BL=await window.showModalDialog("../../eBL/jsp/BLPatRegChargeDetValidationFrame.jsp?"+param,arguments,features);
		
		if ((retVal_BL == "N")  || (retVal_BL == undefined) ||  (retVal_BL == "undefined"))  
	{
		parent.parent.frames[0].document.getElementById('reset').click();	
		
	}
	

	}

async function image_click1(search,oa_install_yn,pat_id1,referal_id1)
{  
	var entitlement_by_cat_yn=parent.frames[1].document.forms[0].entitlement_by_cat_yn.value;
	var currentPath = window.location.pathname;
	var basePath = currentPath.substring(0, currentPath.lastIndexOf("/")); // Get base path

	// Build the correct URL based on the base path
	var targetUrl = basePath + "/VisitRegistrationInt.jsp";
	
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	var nat_id_prompt;
	functionId=parent.frames[1].document.forms[0].functionId.value
	bl_install_yn=parent.frames[1].document.forms[0].bl_interface_yn.value
	oper_stn_id=parent.frames[1].document.forms[0].oper_stn_id.value
	if(parent.frames[1].document.forms[0].nat_id_prompt)
		nat_id_prompt=parent.frames[1].document.forms[0].nat_id_prompt.value
	build_episode_rule=parent.frames[1].document.forms[0].build_episode_rule.value
	or_install_yn=parent.frames[1].document.forms[0].or_install_yn.value
	emer_regn_allow_yn=parent.frames[1].document.forms[0].emer_regn_allow_yn.value
	visit_for_inpat_yn=parent.frames[1].document.forms[0].visit_for_inpat_yn.value
	register_visit_yn=parent.frames[1].document.forms[0].register_visit_yn.value
	queryString=parent.frames[1].document.forms[0].queryString.value
	
	alt_id1_desc=parent.frames[1].document.forms[0].alt_id1_desc.value
	alt_id2_desc=parent.frames[1].document.forms[0].alt_id2_desc.value
	alt_id3_desc=parent.frames[1].document.forms[0].alt_id3_desc.value
	alt_id4_desc=parent.frames[1].document.forms[0].alt_id4_desc.value
	names_in_oth_lang_yn=parent.frames[1].document.forms[0].names_in_oth_lang_yn.value

	if(referal_id1!=""||pat_id1!="")
	{	 
		if(parent.frames[1].document.forms[0].other_alt_type!=null)
		parent.frames[1].document.forms[0].other_alt_type.disabled=true;
		if(parent.frames[1].document.forms[0].alt_id1_no!=null)
		parent.frames[1].document.forms[0].alt_id1_no.readOnly=true;
		if(parent.frames[1].document.forms[0].alt_id2_no!=null)
		parent.frames[1].document.forms[0].alt_id2_no.readOnly=true;
		if(parent.frames[1].document.forms[0].alt_id3_no!=null)
		parent.frames[1].document.forms[0].alt_id3_no.readOnly=true;
		if(parent.frames[1].document.forms[0].alt_id4_no!=null)
		parent.frames[1].document.forms[0].alt_id4_no.readOnly=true;
		parent.frames[1].document.forms[0].referal_id1.readOnly=true;
		parent.frames[1].document.forms[0].srch_code.disabled=true;
		//parent.frames[1].document.forms[0].pat_id1.readOnly=true;  
		parent.frames[1].document.forms[0].pat_id1.disabled=true;   //this line Added for this incident MMS-SCF-0105 [IN:043502]
		parent.frames[1].document.forms[0].srch.disabled=true;
		parent.frames[1].document.forms[0].ref_id_search.disabled=true;
		//Below line added for this CRF Linked incident MMS-QH-CRF-0162.1
		if(parent.frames[1].document.forms[0].national_id_no!=null)
		parent.frames[1].document.forms[0].national_id_no.readOnly=true; 

	}
	//parent.frames[1].document.forms[0].clear1.disabled=true;


	if(referal_id1!="")
	{
	 	/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient6' id='dummypromptpatient6' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='ValidateReferal'><input type = 'hidden' name = 'p_referral_id' value = '"+referal_id1+"' ><input type='hidden' name='oa_install_yn' id='oa_install_yn' value='"+oa_install_yn+"'><input type='hidden' name='fromPatidF1' id='fromPatidF1' value='true'><input type='hidden' name='functionId' id='functionId' value='"+functionId+"'><input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+bl_install_yn+"'><input type='hidden' name='build_episode_rule' id='build_episode_rule' value='"+build_episode_rule+"'><input type='hidden' name='oper_stn_id' id='oper_stn_id' value='"+oper_stn_id+"'><input type='hidden' name='or_install_yn' id='or_install_yn' value='"+or_install_yn+"'><input type='hidden' name='emer_regn_allow_yn' id='emer_regn_allow_yn' value='"+emer_regn_allow_yn+"'><input type='hidden' name='visit_for_inpat_yn' id='visit_for_inpat_yn' value='"+visit_for_inpat_yn+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='register_visit_yn' id='register_visit_yn' value='"+register_visit_yn+"'><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'>";  
		if(document.forms[0].national_id_no && document.forms[0].national_id_no.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'NRICNo' value = '" + document.forms[0].national_id_no.value + "' >";
			
		if(document.forms[0].other_alt_Id && document.forms[0].other_alt_Id.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'otherAlternateIDType' value = '" + document.forms[0].other_alt_type.value + "' ><input type = 'hidden' name = 'otherAlternateIDNo' value = '" + document.forms[0].other_alt_Id.value + "' >";

		if(document.forms[0].alt_id1_no && document.forms[0].alt_id1_no.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'alternateIDNo1' value = '" + document.forms[0].alt_id1_no.value + "' >";

		if(document.forms[0].alt_id2_no && document.forms[0].alt_id2_no.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'alternateIDNo2' value = '" + document.forms[0].alt_id2_no.value + "' >";

		if(document.forms[0].alt_id3_no && document.forms[0].alt_id3_no.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'alternateIDNo3' value = '" + document.forms[0].alt_id3_no.value + "' >";

		if(document.forms[0].alt_id4_no && document.forms[0].alt_id4_no.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'alternateIDNo4' value = '" + document.forms[0].alt_id4_no.value + "' >";	HTMLVal = HTMLVal + "<input type = 'hidden' name = 'query_str' value = " + encodeURIComponent(parent.frames[1].document.forms[0].queryString.value) + " >";			
		HTMLVal = HTMLVal +"</form></body></html>";
		
		var message_frame=parent.parent.frames[2];
		if(message_frame.document.body!=null)
		{
			message_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			message_frame.document.dummypromptpatient6.submit()
		}
	}
	else
	{  
		parent.frames[2].document.location.href='../../eCommon/html/blank.html'
		parent.frames[3].document.location.href='../../eCommon/html/blank.html'
		parent.frames[4].document.location.href='../../eCommon/html/blank.html'
		 
		 /*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient6' id='dummypromptpatient6' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='check_pat'><input type = 'hidden' name = 'prompt_patient_id' value = '"+pat_id1+"' ><input type='hidden' name='oa_install_yn' id='oa_install_yn' value='"+oa_install_yn+"'><input type='hidden' name='fromPatidF1' id='fromPatidF1' value='true'><input type='hidden' name='functionId' id='functionId' value='"+functionId+"'><input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+bl_install_yn+"'><input type='hidden' name='build_episode_rule' id='build_episode_rule' value='"+build_episode_rule+"'><input type='hidden' name='oper_stn_id' id='oper_stn_id' value='"+oper_stn_id+"'><input type='hidden' name='or_install_yn' id='or_install_yn' value='"+or_install_yn+"'><input type='hidden' name='emer_regn_allow_yn' id='emer_regn_allow_yn' value='"+emer_regn_allow_yn+"'><input type='hidden' name='visit_for_inpat_yn' id='visit_for_inpat_yn' value='"+visit_for_inpat_yn+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='register_visit_yn' id='register_visit_yn' value='"+register_visit_yn+"'><input type='hidden' name='alt_id1_desc' id='alt_id1_desc' value='"+alt_id1_desc+"'><input type='hidden' name='alt_id2_desc' id='alt_id2_desc' value='"+alt_id2_desc+"'><input type='hidden' name='alt_id3_desc' id='alt_id3_desc' value='"+alt_id3_desc+"'><input type='hidden' name='alt_id4_desc' id='alt_id4_desc' value='"+alt_id4_desc+"'><input type='hidden' name='entitlement_by_cat_yn' id='entitlement_by_cat_yn' value='"+entitlement_by_cat_yn+"' ><input type='hidden' name='names_in_oth_lang_yn' id='names_in_oth_lang_yn' value='"+names_in_oth_lang_yn+"'><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'>";
		
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'NRICNo' value = '" + document.forms[0].national_id_no.value + "' >";
					
		if(document.forms[0].other_alt_Id && document.forms[0].other_alt_Id.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'otherAlternateIDType' value = '" + document.forms[0].other_alt_type.value + "' ><input type = 'hidden' name = 'otherAlternateIDNo' value = '" + document.forms[0].other_alt_Id.value + "' >";
		
		if(document.forms[0].alt_id1_no && document.forms[0].alt_id1_no.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'alternateIDNo1' value = '" + document.forms[0].alt_id1_no.value + "' >";
		
		if(document.forms[0].alt_id2_no && document.forms[0].alt_id2_no.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'alternateIDNo2' value = '" + document.forms[0].alt_id2_no.value + "' >";
		
		if(document.forms[0].alt_id3_no && document.forms[0].alt_id3_no.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'alternateIDNo3' value = '" + document.forms[0].alt_id3_no.value + "' >";
		
		if(document.forms[0].alt_id4_no && document.forms[0].alt_id4_no.value != '')
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'alternateIDNo4' value = '" + document.forms[0].alt_id4_no.value + "' >";			
		HTMLVal = HTMLVal + "<input type = 'hidden' name = 'query_str' value = " + encodeURIComponent(parent.frames[1].document.forms[0].queryString.value) + " >";			
		HTMLVal = HTMLVal +"</form></body></html>";

		var message_frame=parent.parent.frames[2];
		if(message_frame.document.body!=null)
		{
			message_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			message_frame.document.dummypromptpatient6.submit()
		}
 
	}
//setTimeout('AppoinmentVist()',1200);
/*Added for this incident [52415]*/

	//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	//alert("name"+parent.frames[3].document.getElementById('isImproveReferralProcessAppl'));
	var  isImproveReferralProcessAppl = parent.frames[3].document.getElementById('isImproveReferralProcessAppl');
	if(isImproveReferralProcessAppl) {
		isImproveReferralProcessAppl = isImproveReferralProcessAppl.value; 
	}
	var referral_clicked_yn = parent.frames[3].document.getElementById('referral_clicked_yn');
	if(referral_clicked_yn) {
		referral_clicked_yn = referral_clicked_yn.value; 
	}
	if(parent.frames[1].document.forms[0].appt_refno_flag!=null && parent.frames[1].document.forms[0].appt_refno_flag.value!=""){
		var patient=parent.frames[3].document.forms[0].patient_id.value
		var q_clinic_code=parent.frames[3].document.forms[0].assign_care_locn_code.value
		var q_practitioner_id=parent.frames[3].document.forms[0].appt_practitioner_id.value // (or) attend_practitioner_id appt_practitioner_id
		var q_appt_ref_no=parent.frames[3].document.forms[0].appt_ref_no.value// (or) appt_ref_no_2
		var q_appt_time=parent.frames[3].document.forms[0].q_appt_time.value
		var q_visit_adm_type=parent.frames[3].document.forms[0].q_visit_adm_type.value
		var referral_id=parent.frames[3].document.forms[0].financial_detail_ref_id.value
		var referral_reg_yn = "";
		var Rpractitioner_name=""
		var resource_class=parent.frames[3].document.forms[0].resource_class.value
		var ordering_facility_id =parent.frames[3].document.forms[0].ordering_facility_id.value
		var order_id=parent.frames[3].document.forms[0].order_id.value
		var order_line_num=parent.frames[3].document.forms[0].order_line_num.value
		var order_type_code=parent.frames[3].document.forms[0].order_type_code.value
		var order_catalog_code=parent.frames[3].document.forms[0].order_catalog_code.value
		var order_catalog_desc=parent.frames[3].document.forms[0].order_catalog_desc.value
		var contact_reason_code=parent.frames[3].document.forms[0].contact_reason_code.value
		var rec_no=parent.frames[3].document.forms[0].rec_no.value 
		var locn_type=parent.frames[3].document.forms[0].locn_type.value
		var functionId=parent.frames[3].document.forms[0].functionId.value
		var service_code=parent.frames[1].document.forms[0].appt_service_code.value;  //Added for this incident [52513]
		
		
		var accept_dis_inv_no=parent.frames[3].document.forms[0].accept_dis_inv_no.value
		var multi_speciality_yn=parent.frames[3].document.forms[0].multi_speciality_yn.value
		var q_visit_adm_type_ind=parent.frames[3].document.forms[0].q_visit_adm_type_ind.value
		var oper_stn_id=parent.frames[3].document.forms[0].oper_stn_id.value 
		var reason=parent.frames[3].document.forms[0].contact_reason_txt.value  
		var visit_for_inpat_yn=parent.frames[3].document.forms[0].visit_for_inpat_yn.value 
		var appt_refno_flag=parent.frames[1].document.forms[0].appt_refno_flag.value; 
		var auth_win_reqd_yn=parent.frames[3].document.forms[0].auth_win_reqd_yn.value; 
		parent.frames[1].document.forms[0].blflag_op_yn.value=auth_win_reqd_yn;
	
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl == "true"){
			if(referral_clicked_yn == 'N')
			{
				setTimeout("await tab_click_add_visitapptrecds('"+patient+"','"+q_clinic_code+"','"+q_practitioner_id+"','"+q_appt_ref_no+"','"+q_visit_adm_type_ind+"','"+q_visit_adm_type+"','','"+resource_class+"','"+ordering_facility_id+"','"+order_id+"','"+order_line_num+"','"+order_type_code+"','"+order_catalog_code+"','"+order_catalog_desc+"','"+referral_id+"','"+referral_reg_yn+"','N','','','"+oper_stn_id+"','"+functionId+"','"+contact_reason_code+"','"+reason+"','"+locn_type+"','"+service_code+"','"+Rpractitioner_name+"','"+visit_for_inpat_yn+"','"+q_appt_time+"','"+multi_speciality_yn+"');",1000);
			}
			parent.frames[3].document.forms[0].referral_clicked_yn.value = 'N';
		}
		else{
			setTimeout("await tab_click_add_visitapptrecds('"+patient+"','"+q_clinic_code+"','"+q_practitioner_id+"','"+q_appt_ref_no+"','"+q_visit_adm_type_ind+"','"+q_visit_adm_type+"','','"+resource_class+"','"+ordering_facility_id+"','"+order_id+"','"+order_line_num+"','"+order_type_code+"','"+order_catalog_code+"','"+order_catalog_desc+"','"+referral_id+"','"+referral_reg_yn+"','N','','','"+oper_stn_id+"','"+functionId+"','"+contact_reason_code+"','"+reason+"','"+locn_type+"','"+service_code+"','"+Rpractitioner_name+"','"+visit_for_inpat_yn+"','"+q_appt_time+"','"+multi_speciality_yn+"');",100000);
		}
	
	}//End	
//Added for this incident[52619]
	if(parent.frames[1].document.forms[0].invitation_no!=null && parent.frames[1].document.forms[0].invitation_no.value!=""){
		var oa_install_yn=parent.frames[3].document.forms[0].oa_install_yn.value; 
		var patient=parent.frames[3].document.forms[0].patient_id.value
		var patient=parent.frames[3].document.forms[0].patient_id.value
		var invitation_no=parent.frames[3].document.forms[0].invitation_no.value
		var from_head=parent.frames[3].document.forms[0].from_head.value 
		var wait_list_flag=parent.frames[3].document.forms[0].wait_list_flag.value 
		//var q_clinic_code=parent.frames[3].document.forms[0].assign_care_locn_code.value
		var locn_ind=parent.frames[3].document.forms[0].locn_ind.value
		var waitlist_status=parent.frames[3].document.forms[0].waitlist_status.value
		var spec_code=parent.frames[3].document.forms[0].inv_splty_code.value
		var accept_dis_inv_no=parent.frames[3].document.forms[0].accept_dis_inv_no.value
		//var practitioner_id=parent.frames[3].document.forms[0].appt_practitioner_id.value
		var practitioner_name="";
		var multi_speciality_yn=parent.frames[3].document.forms[0].multi_speciality_yn.value
		var order_catalog_code=parent.frames[3].document.forms[0].order_catalog_code.value
		var q_clinic_code=parent.frames[1].document.forms[0].locn_code.value;
		var practitioner_id=parent.frames[1].document.forms[0].practitioner_id.value;
		
		//Added for this incident[52854]
		parent.frames[1].document.forms[0].episode.value=parent.frames[3].document.forms[0].episode.value; 
		parent.frames[1].document.forms[0].record.value=parent.frames[3].document.forms[0].record.value;
		parent.frames[1].document.forms[0].oper_stn_id.value=parent.frames[3].document.forms[0].oper_stn_id.value;
		//End incident[52854]
		
		
		//image_click('wait',oa_install_yn,patient,invitation_no,from_head,wait_list_flag,q_clinic_code,locn_ind,waitlist_status,spec_code,accept_dis_inv_no,practitioner_id,practitioner_name,order_catalog_code,multi_speciality_yn)
		setTimeout("await image_click('wait','"+oa_install_yn+"','"+patient+"','"+invitation_no+"','"+from_head+"','"+wait_list_flag+"','"+q_clinic_code+"','"+locn_ind+"','"+waitlist_status+"','"+spec_code+"','"+accept_dis_inv_no+"','"+practitioner_id+"','"+practitioner_name+"','"+order_catalog_code+"','"+multi_speciality_yn+"');",99800);
	}
//Added by Ashwin K for AAKH-CRF-0150
	if(document.getElementById('AddVisit_EmiratesID_edit'))
	{
		$("#national_id_no").prop('disabled', true);
		$('#AddVisit_EmiratesID_edit').prop('checked', false);
		$("#M_btn2").prop('disabled', false);
	}
//Ended by Ashwin K for AAKH-CRF-0150

}

//Included multi_speciality_yn for the CRf - Bru-HIMS-CRF-198
async function image_click(obj,oa_install_yn,val,ref_val,from_head,prev_visit,locn_code,locn_ind,waitlist_status,spec_code,accept_dis_inv_no,practitioner_id,practitioner_name,order_catalog_code,multi_speciality_yn)
{	
	//order_catalog_code passed by S.Sathish for PMG20089-CRF-0850 on Friday, July 02, 2010
		var frlst="";	
	if(parent.parent.frames[0].document.getElementById('function_id') != null)
	{
		funcid=parent.parent.frames[0].document.getElementById('function_id').value;
	}

	var obj_name = obj;
    var frames_list;
    var frames_hierarchy;
    var add_arg;
    var callFromMenu_yn;
    var message_frame;
    var search_but_yn;

	var loccode=from_head;

	if(from_head == null)   from_head = "N";

	if (oa_install_yn == "Y")
    {
        frames_list = parent.window.frames[0].document;
        callFromMenu_yn = "N";
        frames_hierarchy = parent.window.frames[0].document;      
        search_but_yn="Y";
    }
    else
    {
        frames_list = parent.frames[3].document;
        callFromMenu_yn = "Y";
		frames_hierarchy = parent.frames[3].document;      
        search_but_yn="N";
    }
	
//	if( frames_hierarchy.forms[0].ct_patient_id != null){
//		frames_hierarchy.forms[0].ct_patient_id.value = "";
//	}
    
	//frames_hierarchy.forms[0].error.value = "";
	
	 if (obj_name=='wait')
	{

		var patient_id;
		patient_id = val;

		referral_id="";
		var list_name = "invitation_list";
		//Added for this incident [52619]	
        var facility_id="";	
		if(parent.frames[1].document.forms[0].inviate_facility_id!=null && parent.frames[1].document.forms[0].inviate_facility_id.value!=""){
		 facility_id= parent.frames[1].document.forms[0].inviate_facility_id.value;
		}else{
		 facility_id = parent.frames[3].document.forms[0].facility_id.value;
		} 
		//Below line added for this incident [52854]
		var episode=parent.frames[1].document.forms[0].episode.value;
		var record=parent.frames[1].document.forms[0].record.value;
		oper_stn_id=parent.frames[1].document.forms[0].oper_stn_id.value;
		
		//calling model window for validation.

		if(accept_dis_inv_no == "A")
		{   
			var invite_number=await show_invitation(ref_val);
			
		}
		else 
			var invite_number = " ";
		
		if(invite_number == "C" || invite_number == null)
		{
			
		}
        else
		{
		parent.frames[2].document.location.href='../../eCommon/html/blank.html'
	    parent.frames[3].document.location.href='../../eCommon/html/blank.html'
		parent.frames[4].document.location.href='../../eCommon/html/blank.html'
	  parent.visit.rows='18,23.5%,7.5%,*,12%'
	  build_episode_rule=parent.frames[1].document.forms[0].build_episode_rule.value;	
	  var query_string=parent.frames[0].document.forms[0].query_string.value; 
	  //parent.frames[0].document.forms[0].query_string.value;
	  oper_stn_id=document.forms[0].oper_stn_id.value;
	  functionid=parent.frames[1].document.forms[0].functionId.value; 	 
	  var menu_function_id = functionid;
		
		if(locn_ind == 'C')
		{
			functionid = "VISIT_REGISTRATION";
		}
		else if(locn_ind == 'E')
		{
			functionid = "PROCD_REGISTRATION";
		}
	  invitation_no=ref_val;
	  bl_interface_yn=document.forms[0].bl_interface_yn.value;
	  or_install_yn=document.forms[0].or_install_yn.value;
	  emer_regn_allow_yn=document.forms[0].emer_regn_allow_yn.value;
       visit_for_inpat_yn=parent.frames[1].document.forms[0].visit_for_inpat_yn.value;
	  parent.frames[0].document.getElementById('addvisit_tab').className="tabClicked";
	  parent.frames[0].document.getElementById('addvisit_tabspan').className="tabSpanclicked";
	  parent.frames[0].document.getElementById('invitation_tab').className="tabA";
	  parent.frames[0].document.getElementById('invitation_tabspan').className="tabAspan";
	  
	  parent.frames[1].document.location.href='../../eOP/jsp/VisitRegistrationCriteria.jsp?patient='+patient_id+"&accept_dis_inv_no="+accept_dis_inv_no+"&query_string="+query_string+"&invitation_no="+invitation_no+"&facility_id="+facility_id+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&locn_code="+locn_code+"&practitioner_id="+practitioner_id+"&episode="+episode+"&record="+record; //modified this line for this incident[52619]
     // parent.frames[2].location.href="../../eCommon/jsp/patLine.jsp?Patient_Id="+patient_id
	
	/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
	  parent.frames[3].document.location.href='../../eOP/jsp/VisitRegistrationResult.jsp?patient='+patient_id+"&accept_dis_inv_no="+accept_dis_inv_no+"&oper_stn_id="+oper_stn_id+"&invitation_no="+invitation_no+"&q_practitioner_id="+practitioner_id+"&bl_interface_yn="+bl_interface_yn+"&or_install_yn="+or_install_yn+"&oa_install_yn="+oa_install_yn+"&locn_ind="+locn_ind+"&q_clinic_code="+locn_code+"&waitlist_status="+waitlist_status+"&inv_splty_code="+spec_code+"&functionId="+functionid+"&menu_function_id="+menu_function_id+"&build_episode_rule="+build_episode_rule+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&visit_for_inpat_yn="+visit_for_inpat_yn+"&query_String="+encodeURIComponent(query_string)+"&order_catalog_code="+order_catalog_code+"&multi_speciality_yn="+multi_speciality_yn+"&upt_contact_dtls_oa_yn="+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"&q_practitioner_name="+practitioner_name+"&from_head="+from_head+"&episode="+episode+"&record="+record; //Added for this incident[52619]
	  //Above line modified for this incident [52854]	 
		
    }
}}

function auto_query(where_clause)
{
    var whereClause = "";
    var strand  = "";
    // Clinic Code
    if( trimCheck(parent.frames[0].document.forms[0].clinic_code.value)) {
        whereClause = whereClause + strand + "b.clinic_code=trim('" + parent.frames[0].document.forms[0].clinic_code.value + "') " ;
        strand = "AND ";
    }
    // Practitioner ID
    if( trimCheck(parent.frames[0].document.forms[0].practitioner_id.value)) {
        whereClause = whereClause + strand + "a.practitioner_id=trim('" + parent.frames[0].document.forms[0].practitioner_id.value + "') ";
        strand = "AND ";
    }
    if (whereClause != null)
    {
        return " and "+whereClause;
    }
}
function get_message_text(message,prompt,module_id)
{
    var message_text;
      
        if(module_id=='OP')
		message_text = getOPMessage(message,module_id);
		else
       message_text = getMessage(message,module_id);
    return message_text;
}
function setValue(val, obj)
{	
	//ChangeUpperCase(obj)
	if(val == "patient")
	{
		document.getElementById('pat_id1').value= obj.value
		if(document.getElementById('pat_id2') != null)
		document.getElementById('pat_id2').value= obj.value
	
	}
	else
	{
		document.getElementById('referal_id1').value= obj.value            
		
		if(document.getElementById('referal_id2') != null)
		document.getElementById('referal_id2').value= obj.value
	}

		
		
}


 // added by munisekhar for MMS-QH-CRF-0162
async function getPatientDetails(patient_id){

	var dialogHeight = '90vh';
	var dialogWidth = '90vw';
	var wintop = '65';
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +  '; dialogTop: ' + wintop +';status=no';
	var arguments = '';
	var retVal = '';
	//called_from_newborn changed as "N" by Dharma against MMS-DM-SCF-0611 [IN:070200] on 15th Apr 2019
	//var param = "../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=Y&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id;
	var param = "../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id;
	
	var retVal = await top.window.showModalDialog(param,arguments,features);
	if(retVal == true){
	parent.patient_sub2.location.reload();
	parent.patient_sub3.location.reload();
	}

	if(retVal == undefined || retVal == true) {
		changeToolBar();
	} 
	
}
function changeToolBar() {
			home_required_yn = 'Y';
			parent.parent.commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?module_id=OP&function_id=VISIT_REGISTRATION&function_name=Register Visit&function_type=F&access=NYNNN&home_required_yn='+home_required_yn;
			parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
		}



function show_visit_dtls(mode)
{
    var frame_list="frames[1].frames[1]";
   
    var clinic_code = frame_list.assign_care_locn_code.value;
    var visit_type_code = frame_list.visit_adm_type.value;
    if ((clinic_code.length>0) && (visit_type_code.length>0))
    {
        var visit_date=frame_list.sys_date.value;
        var billing_class = frame_list.billing_class.value;
        var mpi_yn = "Y";
        var patient_id = frame_list.patient_id.value;
        var op_episode_id = frame_list.op_episode_id.value;
        var op_episode_type = "O";
        var op_episode_visit_num = frame_list.op_episode_visit_num.value;
        var billing_group = frame_list.billing_group.value;
        var trx_date = visit_date;
        var cust_code = "";

        if (!(frame_list.cust_1.value=="")) cust_code=frame_list.cust_1.value;
        if (!(frame_list.cust_2.value=="")) cust_code=frame_list.cust_2.value;
        if (!(frame_list.cust_3.value=="")) cust_code=frame_list.cust_3.value;

        var non_ins_blng_grp = frame_list.non_insur_blng_grp.value;
        var non_ins_cust_code = frame_list.cust_4.value;
        var pkg_bill_doc_type = frame_list.pkg_bill_type.value;
        var pkg_bill_doc_num = frame_list.pkg_bill_no.value; /* In Out */
        var policy_type_code = frame_list.policy_type.value;/* In Out */
        if (policy_type_code.indexOf('%')!=-1)
            policy_type_code = escape(policy_type_code);

        var policy_expiry_date= frame_list.policy_expiry_date.value;
        var mesg_reqd = "0";
        var effective_date = ""; /* In Out */
        var credit_auth_ref = ""; /* In Out */
        var approved_days = 0; /* In Out */
        var pkg_bill_type = frame_list.pkg_bill_type.value;
        var serv_qty = 1;
        var addl_factor = 0;
        var pkg_price = 0;
        var pkg_value = 0;
        var policy_type = frame_list.policy_type.value;
        if (policy_type.indexOf('%')!=-1)
            policy_type = escape(policy_type);
        var base_qty = 1; /* In Out */
        var base_rate = 0;
        var base_charge_amt = 0;
        var gross_charge_amt = 0;
        var disc_amt = 0;
        var net_charge_amt = 0;
        var pat_base_qty = 0;
        var pat_base_rate = 0;
        var pat_serv_qty = 0;
        var pat_base_charge_amt = 0;
        var pat_gross_charge_amt = 0;
        var pat_disc_amt = 0;
        var pat_net_charge_amt = 0;
        var cust_base_qty = 0;
        var cust_base_rate = 0;
        var cust_serv_qty = 0;
        var cust_base_charge_amt = 0;
        var cust_gross_charge_amt = 0;
        var cust_disc_amt = 0;
        var cust_net_charge_amt = 0;

        var qry="";

        var HTMLVal = new String();
        HTMLVal = "<HTML><BODY onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eBL/jsp/CalculateVisitCharge.jsp'><input type='hidden' name='visit_date' id='visit_date' value='"+visit_date+"'><input type='hidden' name='billing_class' id='billing_class' value='"+billing_class+"'><input type='hidden' name='billing_group' id='billing_group' value='"+billing_group+"'>";
        HTMLVal += "<input type='hidden' name='mpi_yn' id='mpi_yn' value='"+mpi_yn+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='op_episode_id' id='op_episode_id' value='"+op_episode_id+"'><input type='hidden' name='op_episode_type' id='op_episode_type' value='"+op_episode_type+"'>";
        HTMLVal += "<input type='hidden' name='op_episode_visit_num' id='op_episode_visit_num' value='"+op_episode_visit_num+"'><input type='hidden' name='trx_date' id='trx_date' value='"+trx_date+"'><input type='hidden' name='cust_code' id='cust_code' value='"+cust_code+"'><input type='hidden' name='non_ins_blng_grp' id='non_ins_blng_grp' value='"+non_ins_blng_grp+"'><input type='hidden' name='non_ins_cust_code' id='non_ins_cust_code' value='"+non_ins_cust_code+"'><input type='hidden' name='pkg_bill_doc_type' id='pkg_bill_doc_type' value='"+pkg_bill_doc_type+"'>";
        HTMLVal += "<input type='hidden' name='pkg_bill_doc_num' id='pkg_bill_doc_num' value='"+pkg_bill_doc_num+"'><input type='hidden' name='policy_type_code' id='policy_type_code' value='"+policy_type_code+"'><input type='hidden' name='policy_expiry_date' id='policy_expiry_date' value='"+policy_expiry_date+"'><input type='hidden' name='mesg_reqd' id='mesg_reqd' value='"+mesg_reqd+"'><input type='hidden' name='effective_date' id='effective_date' value='"+effective_date+"'><input type='hidden' name='credit_auth_ref' id='credit_auth_ref' value='"+credit_auth_ref+"'>";
        HTMLVal += "<input type='hidden' name='approved_days' id='approved_days' value='"+approved_days+"'><input type='hidden' name='pkg_bill_type' id='pkg_bill_type' value='"+pkg_bill_type+"'><input type='hidden' name='serv_qty' id='serv_qty' value='"+serv_qty+"'><input type='hidden' name='pkg_price' id='pkg_price' value='"+pkg_price+"'><input type='hidden' name='pkg_value' id='pkg_value' value='"+pkg_value+"'><input type='hidden' name='policy_type' id='policy_type' value='"+policy_type+"'><input type='hidden' name='base_qty' id='base_qty' value='"+base_qty+"'>";
        HTMLVal += "<input type='hidden' name='base_rate' id='base_rate' value='"+base_rate+"'><input type='hidden' name='base_charge_amt' id='base_charge_amt' value='"+base_charge_amt+"'><input type='hidden' name='gross_charge_amt' id='gross_charge_amt' value='"+gross_charge_amt+"'><input type='hidden' name='disc_amt' id='disc_amt' value='"+disc_amt+"'><input type='hidden' name='net_charge_amt' id='net_charge_amt' value='"+net_charge_amt+"'><input type='hidden' name='pat_base_qty' id='pat_base_qty' value='"+pat_base_qty+"'><input type='hidden' name='pat_base_rate' id='pat_base_rate' value='"+pat_base_rate+"'>";
        HTMLVal += "<input type='hidden' name='pat_serv_qty' id='pat_serv_qty' value='"+pat_serv_qty+"'><input type='hidden' name='pat_base_charge_amt' id='pat_base_charge_amt' value='"+pat_base_charge_amt+"'><input type='hidden' name='pat_gross_charge_amt' id='pat_gross_charge_amt' value='"+pat_gross_charge_amt+"'><input type='hidden' name='pat_disc_amt' id='pat_disc_amt' value='"+pat_disc_amt+"'><input type='hidden' name='pat_net_charge_amt' id='pat_net_charge_amt' value='"+pat_net_charge_amt+"'><input type='hidden' name='cust_base_qty' id='cust_base_qty' value='"+cust_base_qty+"'><input type='hidden' name='cust_base_rate' id='cust_base_rate' value='"+cust_base_rate+"'>";
        HTMLVal += "<input type='hidden' name='cust_serv_qty' id='cust_serv_qty' value='"+cust_serv_qty+"'><input type='hidden' name='cust_base_charge_amt' id='cust_base_charge_amt' value='"+cust_base_charge_amt+"'><input type='hidden' name='cust_gross_charge_amt' id='cust_gross_charge_amt' value='"+cust_gross_charge_amt+"'><input type='hidden' name='cust_disc_amt' id='cust_disc_amt' value='"+cust_disc_amt+"'><input type='hidden' name='cust_net_charge_amt' id='cust_net_charge_amt' value='"+cust_net_charge_amt+"'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='visit_type_code' id='visit_type_code' value='"+visit_type_code+"'><input type='hidden' name='mode' id='mode' value='"+mode+"'></form></BODY></HTML>";
        if (mode=="Y")
        { 
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.parent.messageFrame.document.form1.submit();
        }
        else
        {
			parent.frames[1].messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.frames[1].messageFrame.document.form1.submit();
        }
    }
}

async function dispVisitCharge(mode)
{
    var frame_list1=  parent.frames[0].document.forms[0]; 
	var frames_list = "";
  
    var retVal;
    var dialogHeight= "10" ;
    var dialogWidth = "48" ;
    var dialogTop = "225" ;
    var center = "1" ;
    var status="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scrolling :" + "NO" ;
    var arguments   = "" ;
    var billing_group       = frame_list1.billing_group.value;
    var billing_class       = frame_list1.billing_class.value;
    var pkg_serv_code   = frame_list1.pkg_serv_code.value;
    var gross_charge_amt   = frame_list1.gross_charge_amt.value;
    var disc_amt = frame_list1.disc_amt.value;
    var net_charge_amt   = frame_list1.net_charge_amt.value;
    frame_list1.visit_charge.value = frame_list1.net_charge_amt.value;
    if (mode=="Y")
    {
        var qry="billing_group="+billing_group+"&billing_class="+billing_class+"&pkg_serv_code="+pkg_serv_code+"&gross_charge_amt="+gross_charge_amt+"&disc_amt="+disc_amt+"&net_charge_amt="+net_charge_amt;

        var url = "../../eBL/jsp/QueryVisitChargeDetails.jsp?"+qry;
        retVal = await window.showModalDialog(url,arguments,features);
        if(retVal==null) retVal="";
    }
    else
    {      
       
        //frames_list = parent.frames[0];
       /* if (frames_list.document.getElementById("new_op_episode_yn") != null)
        {
            frames_list.document.forms[0].new_episode_yn.value = frames_list.document.forms[0].new_op_episode_yn.value;
        }
        else
            frames_list.document.forms[0].new_episode_yn.value = "N";*/

        if(frames_list.document.forms[0].function_name.value=="Generate_File")
        {
            if (frames_list.document.forms[0].ident_at_checkin.value =="P")
            {
                var fields = new Array (frames_list.document.forms[0].visit_adm_type_ind,
                            frames_list.document.forms[0].assign_care_locn_code,
                            frames_list.document.forms[0].visit_adm_type,
                            frames_list.document.forms[0].attend_practitioner_id
                            );
                var names  = new Array (getLabel("eOP.NatureofVisit.label","OP"),
                            getLabel("Common.Location.label","Common"),
                            getLabel("Common.visittype.label","Common"),
                             getLabel("Common.AttendingPractitioner.label","Common"));
            }
            else
            {
                var fields = new Array (frames_list.document.forms[0].visit_adm_type_ind,
                            frames_list.document.forms[0].assign_care_locn_code,
                            frames_list.document.forms[0].visit_adm_type
                            );
                var names  = new Array (getLabel("eOP.NatureofVisit.label","OP"),
                              getLabel("Common.Location.label","Common"),
                            getLabel("Common.visittype.label","Common"));
            }
        }
        if(frames_list.checkFields( fields, names, parent.parent.messageFrame))
        {
            frames_list.document.forms[0].submit();
            var fn_status = frames_list.document.forms[0].function_name.value ;
        }
    }
    return true;
}
async function dispAuth(outstamt, patient_id)
{

		// Below code added for Scrum 10638

		var patient_id = patient_id;
		var retVal_BL =    new String();
		var center='1';
		var dialogTop = "30";
		var dialogHeight = "600px" ;
		var dialogWidth = '1000px' ;
		var title='Pat Reg Charges'
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"step1=STEP_OTH&function_id=VISIT_REGISTRATION&"+"patient_id="+patient_id;	
		

		retVal_BL=await window.showModalDialog("../../eBL/jsp/BLPatRegChargeDetValidationFrame.jsp?"+param,arguments,features);
	
		if ((retVal_BL == "N")  || (retVal_BL == undefined) ||  (retVal_BL == "undefined"))  
	{
		parent.parent.frames[0].document.getElementById("reset").click();	
		
	}
	else
	{
		// code end  for Scrum 10638
	var retVal =    new String();
	var dialogHeight= "400px" ;
	var dialogWidth = "700px" ;
	var status = "no";
	var arguments   = "" ;
	var frame_list;
	frame_list =  parent.frames[3].document.forms[0];

	var patient_id=patient_id;
	var outst_amount = outstamt;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eBL/jsp/dispCreditAuth.jsp?patient_id="+patient_id+"&calling_module_id=OP&outst_amt="+outst_amount,arguments,features);
	
	if (retVal == null) retVal="";
	
	if ((retVal[0] == "N")  || (retVal[0] == undefined) ||  (retVal[0] == "undefined"))  
	{ 		
		if(parent.frames[3].document.forms[0].ct_patient_id != null){
			parent.frames[3].document.forms[0].ct_patient_id.value = "";
		}
		var func_id=parent.frames[1].document.forms[0].functionId.value;
		
		if(parent.frames[3].document.forms[0].call_from)
		{
			if(parent.frames[3].document.forms[0].call_from.value=="CA")
			{
				//parent.parent.window.returnValue = 'N';
				//parent.parent.window.close();

				let dialogBody = parent.parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = 'Y';
				const dialogTag = parent.parent.document.getElementById('dialog_tag');    
				dialogTag.close();				
			}
		}
		
		parent.parent.frames[0].document.getElementById("reset").click();		
	}
	else
	{
		if(retVal.length>0)
		{
			if(retVal[0]=="Y")  /// this is the new condition added
			{
				var remarks=frame_list.remarks;
				var user_id=frame_list.user_id;
				remarks.value=retVal[2];
				user_id.value=retVal[3];
				frame_list.upd_user_flag.value = "Y";
			}
		}
	}
	}

}

function checkFieldsLocal( fields, names, messageFrame)
{
    var errors = "" ;
   
    	
	for( var i=0; i<fields.length; i++ )
	{
      
		if(trimCheck(fields[i].value))
		{
			
            fields[i].value = trimString(fields[i].value);
        }
		else
		{
			var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
			err = err.replace('$', names[i]);
			errors = errors + err + "<br>" ;
		}
    }
    return errors ;
}
function callQueryVisitRegistration(oa_install_yn)
{
	
	var financial_detail_ref_id="";
	var service_code="";
	var patient_id="";
	
	
	service_code=document.forms[0].service_code.value;
	visit_type_derv_rule=document.forms[0].visit_type_derv_rule.value;
	populate_visit_type=document.forms[0].populate_visit_type.value;
	
	patient_id=document.forms[0].patient_id.value;
	var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient6' id='dummypromptpatient6' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='financial_detail_ref_id'><input type='hidden' name='service_code' id='service_code' value='"+service_code+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='visit_type_derv_rule' id='visit_type_derv_rule' value='"+visit_type_derv_rule+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='populate_visit_type' id='populate_visit_type' value='"+populate_visit_type+"'>";
/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
	HTMLVal+="<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value='"+parent.frames[1].document.forms[0].bl_interface_yn.value+"'><input type='hidden' name='or_install_yn' id='or_install_yn' value='"+parent.frames[1].document.forms[0].or_install_yn.value+"'><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'></form></body></html>";
  
    var message_frame=parent.parent.frames[2];
    message_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
   message_frame.document.dummypromptpatient6.submit();
}
/********** added on 12/2/2003******************/ 
function ClearListItem(object)
{    
	if (object)
		var length  =object.length;
	var element = window.frames[1].frames[1].document.frames[0].document.forms[0].document.createElement('OPTION');
	element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
	element.value="";   	
	for(i=1;i<length;i++)
		object.remove(1);   

}
/**********************************************************/
function enableGif()
{
	
if(document.forms[0].assign_care_locn_code.value=="")
document.forms[0].clptype.value="";

if(document.forms[0].visit_type_derv_rule.value == "S" || document.forms[0].visit_type_derv_rule.value == "B" ){
	if(document.forms[0].clptype.value=="P" &&document.forms[0].ident_at_checkin.value=='P'){
	  document.getElementById('gifpop').style.visibility='visible';
	}else{
	document.getElementById('gifpop').style.visibility='hidden';
	}
  }
  /*Below line Added for this CRF Bru-HIMS-CRF-165.1*/
 if(parent.frames[3].document.forms[0].order_count_select && parent.frames[3].document.forms[0].order_count_select.value>0){
        if(parent.frames[3].document.forms[0].order_cat_butt)parent.frames[3].document.forms[0].order_cat_butt.disabled = true;
		if(parent.frames[3].document.forms[0].order_cat_txt)parent.frames[3].document.forms[0].order_cat_txt.disabled=true;
		//Above line modified for this incident [IN43468]
  }
  /*End this CRF Bru-HIMS-CRF-165.1*/
}
function popSubservice(obj)
{	
	var service_code=obj.name;
	var service_code_value=obj.value;
	ClearList(obj);
	//ClearList(parent.frames[3].document.forms[0].subservice_code);
	if(obj.value == "")
	{
		if(parent.frames[3].document.forms[0].visit_type_derv_rule.value == "S" || parent.frames[3].document.forms[0].visit_type_derv_rule.value == "B"){
			/*Below  condtions added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]*/
			if(parent.frames[3].document.forms[0].order_count_select && parent.frames[3].document.forms[0].order_count_select.value==0){
			// Modified against PMG2014-TTM-CRF-0001 [IN:048624] 
			if(!parent.frames[3].document.forms[0].isMohbr.value)
			{
				parent.frames[3].document.forms[0].visit_adm_type.disabled = true;
				parent.frames[3].document.forms[0].visit_adm_type.value = "";
			}
				
			parent.frames[3].document.forms[0].vst_type_ind.value = "";//Added for the SCF - MMS-SCF-0167

			}else{
				if(parent.frames[3].document.forms[0].order_cat_butt)parent.frames[3].document.forms[0].order_cat_butt.disabled = true;
				if(parent.frames[3].document.forms[0].order_cat_txt)parent.frames[3].document.forms[0].order_cat_txt.disabled = true;
				//Above line modified for this incident [IN43468]
				if(parent.frames[3].document.forms[0].gifpopord)parent.frames[3].document.forms[0].gifpopord.style.visibility="hidden";
			}
			//End this CRF Bru-HIMS-CRF-165.1 [IN:035659]
		if((parent.frames[3].document.forms[0].appt_ref_no.value  == "") && (parent.frames[3].document.forms[0].invitation_no.value == "")){
			clearOrderCatalog();			 
			parent.frames[3].document.forms[0].pract_name.readOnly=true;
			if(parent.frames[3].document.forms[0].pract_butt!=null)
				parent.frames[3].document.forms[0].pract_butt.disabled=true;	
			parent.frames[3].document.forms[0].pract_name.value="";
			if(parent.frames[3].document.getElementById('gifpop') != null)
				parent.frames[3].document.getElementById('gifpop').style.visibility='hidden';
		}
		return;
	  }
	}

if(parent.frames[3].document.forms[0].visit_type_derv_rule.value == "S" || parent.frames[3].document.forms[0].visit_type_derv_rule.value == "B"){
   parent.frames[3].document.forms[0].visit_adm_type.disabled = false;   
}else{	
	if(parent.frames[3].document.forms[0].pract_name){
		parent.frames[3].document.forms[0].pract_name.readOnly = false;
		if(parent.frames[3].document.forms[0].pract_butt!=null)
			parent.frames[3].document.forms[0].pract_butt.disabled = false;
	}
	if(parent.frames[3].document.forms[0].order_cat_txt && parent.frames[3].document.forms[0].order_count_select && parent.frames[3].document.forms[0].order_count_select.value==0){ 
		parent.frames[3].document.forms[0].order_cat_txt.readOnly = false;
		parent.frames[3].document.forms[0].order_cat_butt.disabled = false;
	}
}
  /*Below line modified for this CRF Bru-HIMS-CRF-165.1 [IN:035659]*/   
  /*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
   var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient6' id='dummypromptpatient6' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='service_code' id='service_code' value='"+service_code_value+"'><input type = 'hidden' name = 'patient_id' value = '"+parent.frames[3].document.forms[0].patient_id.value+"' ><input type = 'hidden' name = 'care_locn_code' value = '"+parent.frames[3].document.forms[0].assign_care_locn_code.value+"'><input type='hidden' name='episodeReqd' id='episodeReqd' value='"+parent.frames[3].document.forms[0].build_episode_rule.value+"'><input type='hidden' name='visit_adm_type' id='visit_adm_type' value='"+parent.frames[3].document.forms[0].visit_adm_type.value+"'><input type = 'hidden' name = 'q_visit_adm_type_ind' value = '"+parent.frames[3].document.forms[0].q_visit_adm_type_ind.value+"' ><input type = 'hidden' name = 'allow_pop_subser' value = 'Y' ><input type='hidden' name='override_vtype_on_epsd_yn' id='override_vtype_on_epsd_yn' value='"+parent.frames[3].document.forms[0].override_vtype_on_epsd_yn.value+"'><input type = 'hidden' name = 'visit_type_derv_rule' value = '"+parent.frames[3].document.forms[0].visit_type_derv_rule.value+"' ><input type = 'hidden' name = 'appt_vst_type_code' value = '"+parent.frames[3].document.forms[0].q_visit_adm_type.value+"' ><input type = 'hidden' name = 'order_count_select' value = '"+parent.frames[3].document.forms[0].order_count_select.value+"' ><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'></form></body></html>";  
    var message_frame=parent.parent.frames[2];
		

	message_frame.document.write(HTMLVal);	
		
	if(message_frame.document.dummypromptpatient6)
		message_frame.document.dummypromptpatient6.submit();
	else{			 
		message_frame.document.write(HTMLVal);
		message_frame.document.dummypromptpatient6.submit();			 
	}
	
	
	 if(parent.frames[3].document.forms[0].visit_type_derv_rule.value == "P"){
		if(document.forms[0].pract_name.value !=""){	
				//		parent.frames[3].document.forms[0].visit_adm_type.disabled = false;
				removeitems(document.forms[0].visit_adm_type);
			  defaultVisitType();
		   } 
	    }
		 if(parent.frames[3].document.forms[0].visit_type_derv_rule.value == "B" && parent.frames[3].document.forms[0].bl_install_yn.value == "Y" ){
			populateVisitTypeForBillingInsurance('','','','','','',parent.frames[3],parent.parent.frames[2]);//modified for the incident - MMS-SCF 0163
		 }
}
function assignnewfileno(val)
{	
	if(parent.frames[3].document.forms[0].new_file_no != null)
	{
		parent.frames[3].document.forms[0].new_file_no.value=val;		
	}	
}

//Tab setting in VisitRegistrationHead.jsp
var currentTab = new String();
//currentTab = "checkin_tab";
//currentTab="invitation_tab";

function tab_click(objName,errorMsg)
{   
	if( (objName == "checkin_tab" || objName == "invitation_tab" ) && prevTabObj == "checkin_tab" )
	{
		eval(parent.frames[0].document.getElementById("addvisit_tab")).className="tabA";
		eval(parent.frames[0].document.getElementById("addvisit_tabspan")).className="tabASpan";
	}
	else if( (objName == "checkin_tab" || objName == "invitation_tab" ) && prevTabObj == "invitation_tab" )
	{
		eval(parent.frames[0].document.getElementById("addvisit_tab")).className="tabA";
		eval(parent.frames[0].document.getElementById("addvisit_tabspan")).className="tabASpan";
	}

	selectTab(objName);
			
		
    // FIRST CHANGE THE CURRENT SELECTED TAB
    bl_interface_yn=document.forms[0].bl_interface_yn.value;
	var accept_dis_inv_no=parent.frames[1].document.forms[0].accept_dis_inv_no;
	if(accept_dis_inv_no) {
		accept_dis_inv_no = accept_dis_inv_no.value; 
	}
	
	var error = errorMsg;
	var build_episode_rule=parent.frames[1].document.forms[0].build_episode_rule;
	if(build_episode_rule) {
		build_episode_rule = build_episode_rule.value; 
	}
	
	var patientid=parent.frames[0].document.forms[0].ct_patient_id.value;
	var oper_stn_id=parent.frames[0].document.forms[0].oper_stn_id.value;
	var clinic_code=parent.frames[0].document.forms[0].assign_care_locn_code.value;
	var oa_install_yn=parent.frames[0].document.forms[0].oa_install_yn.value;
	register_pat_yn=parent.frames[0].document.forms[0].register_pat_yn.value;
	var or_install_yn=parent.frames[0].document.forms[0].or_install_yn.value;
	
	var emer_regn_allow_yn=parent.frames[0].document.forms[0].emer_regn_allow_yn.value;
    var visit_for_inpat_yn=parent.frames[0].document.forms[0].visit_for_inpat_yn.value;
	var function_id=parent.frames[0].document.forms[0].function_id.value;
	var reg_vis_param=parent.frames[0].document.forms[0].reg_vis_param.value;
	var disable_pat_reg=parent.frames[0].document.forms[0].disable_pat_reg.value;
	var register_visit_referral=parent.frames[0].document.forms[0].register_visit_referral.value;  
	var register_visit_walkin=parent.frames[0].document.forms[0].register_visit_walkin.value;  

	var register_visit_walkin=parent.frames[0].document.forms[0].register_visit_walkin.value;  
	var query_string=parent.frames[0].document.forms[0].query_string.value;  
    
	var wait_list_inv=parent.frames[0].document.forms[0].wait_list_inv.value;
	parent.frames[2].document.location.href='../../eCommon/html/blank.html'
	parent.frames[3].document.location.href='../../eCommon/html/blank.html'
	parent.frames[4].document.location.href='../../eCommon/html/blank.html'
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	if (objName == "checkin_tab")
    {
		//parent.visit.rows='20,45%,7.5%,*,0';
		parent.document.getElementById("patient_main").style.height = '4vh';
    	parent.document.getElementById("patient_sub").style.height = '57vh';
    	parent.document.getElementById("patient_sub2").style.height = '10vh';//12vh
    	parent.document.getElementById("patient_sub3").style.height = '27vh';//27vh
    	parent.document.getElementById("patient_sub4").style.height = '12vh';//12vh
          	//below lines modified by Venkatesh.S (4008) on 28-April-2012 againist RUT-CRF-0060 [IN029598]
	 window.parent.patient_sub.document.location.href = "../../eOP/jsp/VisitRegistrationCriteria.jsp?Patient="+patientid+"&oper_stn_id="+oper_stn_id+"&objName="+objName+"&accept_dis_inv_no="+accept_dis_inv_no+"&clinic_code="+clinic_code+"&oa_install_yn="+oa_install_yn+"&register_visit_referral="+register_visit_referral+"&register_visit_walkin="+register_visit_walkin+"&wait_list_inv=N"+"&function_id="+function_id+"&or_install_yn="+or_install_yn+"&build_episode_rule="+build_episode_rule+"&bl_interface_yn="+bl_interface_yn+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&visit_for_inpat_yn="+visit_for_inpat_yn+"&register_pat_yn="+register_pat_yn+"&query_string="+encodeURIComponent(query_string);
	 //end  RUT-CRF-0060 [IN029598]

    }
    else if (objName == 'addvisit_tab')
    {
    	//parent.visit.rows='18,23.5%,7.5%,*,12%';
    	parent.document.getElementById("patient_main").style.height = '4vh';
    	parent.document.getElementById("patient_sub").style.height = '32vh';
    	parent.document.getElementById("patient_sub2").style.height = '10vh';//12vh
    	parent.document.getElementById("patient_sub3").style.height = '49vh';//53vh
    	parent.document.getElementById("patient_sub4").style.height = '12vh';//12vh
    	
       // changeTab(objName);        
       //below lines modified by Venkatesh.S (4008) on 28-April-2012 againist RUT-CRF-0060 [IN029598]     
parent.frames[0].document.getElementById('init_params').value = "oper_stn_id="+oper_stn_id+"&accept_dis_inv_no="+accept_dis_inv_no+"&oa_install_yn="+oa_install_yn+"&gen_file_yn="+parent.frames[0].document.forms[0].gen_file_yn.value+"&error="+error+"&reg_vis_param="+reg_vis_param+"&disable_pat_reg="+disable_pat_reg+"&from_head=Y"+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&visit_for_inpat_yn="+visit_for_inpat_yn+"&objName="+objName+"&register_pat_yn="+register_pat_yn+"&query_string="+encodeURIComponent(query_string);
//end  RUT-CRF-0060 [IN029598]


		if(parent.frames[0].document.forms[0].ct_patient_id != null)
		{        
			patient_head.ct_patient_id.value = "";
		}
	  //below lines modified by Venkatesh.S (4008) on 28-April-2012 againist RUT-CRF-0060 [IN029598]	  
	  window.parent.patient_sub.document.location.href = "../../eOP/jsp/VisitRegistrationCriteria.jsp?Patient="+parent.frames[0].document.forms[0].ct_patient_id.value+"&accept_dis_inv_no="+accept_dis_inv_no+"&referral_id="+parent.frames[0].document.forms[0].referral_id.value+"&oper_stn_id="+oper_stn_id+"&oa_install_yn="+oa_install_yn+"&gen_file_yn="+parent.frames[0].document.forms[0].gen_file_yn.value+"&error="+error+"&reg_vis_param="+reg_vis_param+"&disable_pat_reg="+disable_pat_reg+"&from_head=Y&register_visit_referral="+register_visit_referral+"&divval=Y&register_visit_walkin="+register_visit_walkin+"&function_id="+function_id+"&or_install_yn="+or_install_yn+"&build_episode_rule="+build_episode_rule+"&bl_interface_yn="+bl_interface_yn+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&visit_for_inpat_yn="+visit_for_inpat_yn+"&objName="+objName+"&register_pat_yn="+register_pat_yn+"&query_string="+encodeURIComponent(query_string);
	  //end  RUT-CRF-0060 [IN029598]

       parent.patient_sub2.location.href='../../eCommon/html/blank.html'
	   parent.patient_sub3.location.href='../../eCommon/html/blank.html'
	}
	else if (objName=='invitation_tab')
	{
		//parent.visit.rows='20,45%,7.5%,*,0%';
		parent.document.getElementById("patient_main").style.height = '4vh';
    	parent.document.getElementById("patient_sub").style.height = '57vh';
    	parent.document.getElementById("patient_sub2").style.height = '12vh'; //12vh
    	parent.document.getElementById("patient_sub3").style.height = '27vh';//27vh
    	parent.document.getElementById("patient_sub4").style.height = '12vh';//12vh
		//changeTab(objName);
				//below lines modified by Venkatesh.S (4008) on 28-April-2012 againist RUT-CRF-0060 [IN029598]
		window.parent.patient_sub.document.location.href="../../eOP/jsp/VisitRegistrationCriteria.jsp?oper_stn_id="+oper_stn_id+"&accept_dis_inv_no="+accept_dis_inv_no+"&oa_install_yn="+oa_install_yn+"&wait_list_inv=Y"+"&function_id="+function_id+"&or_install_yn="+or_install_yn+"&build_episode_rule="+build_episode_rule+"&bl_interface_yn="+bl_interface_yn+"&emer_regn_allow_yn="+emer_regn_allow_yn+"&objName="+objName+"&visit_for_inpat_yn="+visit_for_inpat_yn+"&register_pat_yn="+register_pat_yn+"&query_string="+encodeURIComponent(query_string);
		//end  RUT-CRF-0060 [IN029598]

		parent.patient_sub2.location.href='../../eCommon/html/blank.html'
	   parent.patient_sub3.location.href='../../eCommon/html/blank.html'
	}
}

function onBlurCallPractitionerSearchQuery(obj,target_name)
{    
	 target_name.value = trimString(target_name.value);

	 if(target_name.readonly == true)
	{
		return;
	}
	
	 
	 if(target_name.value == "")
	{
		document.forms[0].bl_success.value="N"
		document.forms[0].attend_practitioner_id.value="";
		if(parent.frames[3].document.forms[0].visit_adm_type && parent.frames[3].document.forms[0].visit_type_derv_rule.value == "P"){
			 
			var length  =parent.frames[3].document.forms[0].visit_adm_type.length;
			for(i=1;i<length;i++)
			  parent.frames[3].document.forms[0].visit_adm_type.remove(1);		
		}
		  
		return;
	}
	var prev_pract=document.forms[0].prev_pract_name.value;
	var present_pract=document.forms[0].pract_name.value;


	if(present_pract!="" && prev_pract ==present_pract)
	{	
		//document.forms[0].bl_success.value="N"
		
		return;
	}
	
	callPractSearchQuery(obj,target_name);

}

async function callPractSearchQuery(obj,target)
{ 
	document.forms[0].bl_success.value="N"
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	target.value=trimString(target.value);

	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].attend_practitioner_id.name;

	document.forms[0].prev_pract_name.value=document.forms[0].pract_name.value;
	var sql="";
	var sqlSec="";
	var open_to_all_pract_yn = visit_registration.open_to_all_pract_yn.value;
	var locncode	 = visit_registration.assign_care_locn_code.value;
	var visitadmtype = visit_registration.visit_adm_type.value;
	var facility_id = visit_registration.facilityid.value;
	var no_pract_for_appt = visit_registration.no_practitioner_for_appt.value;
    functionid=parent.frames[3].document.getElementById('functionId').value;
	var ptype=visit_registration.clptype.value;
	var locationSpeciality = visit_registration.locationSpeciality.value;
	
	locale=document.forms[0].locale.value;
	var appt_ref_no = "";
	if(visit_registration.appt_ref_no)
		appt_ref_no = visit_registration.appt_ref_no.value;
	var override_pract_for_appt = visit_registration.override_pract_for_appt.value;
//	var vst_regn_date_time = visit_registration.vst_regn_date_time.value;	
//Commented the above line added the below code for SKR-SCF-0428 [IN:031602] on 20.03.2012 by Suresh M
	var vst_regn_date_time = visit_registration.vst_regn_date_time_new.value;	
	
	if(appt_ref_no != "")
	{
		//Commented the below code by suresh M on 16.08.2010
		//if(override_pract_for_appt == "Y")	{
			if (open_to_all_pract_yn == "Y")
			{	
				await getPractitioner(obj,target,facility_id,locationSpeciality,'',locncode,vst_regn_date_time,'FromAppt','','',"Q4");	
			}
			else
			{
				await getPractitioner(obj,target,facility_id,locationSpeciality,'',locncode,vst_regn_date_time,'FromAppt',ptype,visitadmtype,"Q3");
			}	
		  //getPractitioner(obj,target,facility_id,locationSpeciality,'',locncode,'','','',vst_regn_date_time,"Q8"); 		
		//}	
	}
	else if(appt_ref_no == "")
	{
		if (open_to_all_pract_yn == "Y")
		{	
			await getPractitioner(obj,target,facility_id,locationSpeciality,'',locncode,'','','','',"Q4");	
		}
		else
		{
			await getPractitioner(obj,target,facility_id,locationSpeciality,'',locncode,'','',ptype,visitadmtype,"Q3");//Q4 changed to Q3 for the SCF 34272
		}
	}	
	 if(parent.frames[3].document.forms[0].visit_type_derv_rule.value == "P"){
		if(document.forms[0].pract_name.value !=""){		  
		  defaultVisitType();
	   }
    }
}

function PractLookupRetVal(retVal,objName)
{
	var arr;
	
	if(visit_registration.assign_care_locn_code!=null)
	{
		if (retVal != null)
		{
			arr=retVal.split("~"); 
			document.forms[0].attend_practitioner_id.value=arr[0];
			document.forms[0].prev_pract_name.value=arr[1];
			document.forms[0].pract_name.value=arr[1];			
		}
		else
		{
			document.forms[0].attend_practitioner_id.value="";
			document.forms[0].prev_pract_name.value="";
			document.forms[0].pract_name.value="";				
		}
	}
	else
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].practitioner_id.value=arr[0];
			document.forms[0].pract_name.value=arr[1];

		}else{
			document.forms[0].practitioner_id.value="";
			document.forms[0].pract_name.value="";
		}	
	}
}	

function populateContactDetails()
{
	var concat_address_hidden=document.forms[0].concat_address_hidden.value;
	
	var arr_concat_vals=concat_address_hidden.split("^^");

	document.forms[0].addr1_type.value					= arr_concat_vals[0];
	document.forms[0].addr_line1.value						= arr_concat_vals[1]; 
	document.forms[0].addr_line2.value						= arr_concat_vals[2]; 
	document.forms[0].addr_line3.value						= arr_concat_vals[3]; 
	document.forms[0].addr_line4.value						= arr_concat_vals[4]; 
	document.forms[0].res_town_code.value			= arr_concat_vals[5]; //
	document.forms[0].res_area_code.value				= arr_concat_vals[6]; //
	document.forms[0].postal_code.value					= arr_concat_vals[7]; //
	document.forms[0].region_code.value					= arr_concat_vals[8]; //
	document.forms[0].country_code.value				= arr_concat_vals[9]; //
	document.forms[0].contact1_name.value			= arr_concat_vals[10];
	document.forms[0].invalid1_yn.value				= arr_concat_vals[11];
	document.forms[0].addr2_type.value					= arr_concat_vals[12];
	document.forms[0].mail_addr_line1.value			= arr_concat_vals[13];
	document.forms[0].mail_addr_line2.value			= arr_concat_vals[14];
	document.forms[0].mail_addr_line3.value			= arr_concat_vals[15];
	document.forms[0].mail_addr_line4.value			= arr_concat_vals[16]; //
	document.forms[0].mail_res_town_code.value	= arr_concat_vals[17]; //
	document.forms[0].mail_res_area_code.value	= arr_concat_vals[18]; //
	document.forms[0].mail_postal_code.value	    = arr_concat_vals[19]; //
	document.forms[0].mail_region_code.value		=  arr_concat_vals[20]; //
	document.forms[0].mail_country_code.value		=  arr_concat_vals[21]; //
	document.forms[0].contact2_name.value		=  arr_concat_vals[22]; //
	document.forms[0].invalid2_yn.value		=  arr_concat_vals[23]; //
	document.forms[0].contact1_no.value		=  arr_concat_vals[24];
	document.forms[0].contact2_no.value		=  arr_concat_vals[25];
	document.forms[0].email.value		=  arr_concat_vals[26];
	document.forms[0].change_address.value  = 'Y';
	document.forms[0].res_town_desc.value =arr_concat_vals[28];
	document.forms[0].res_area_desc.value =arr_concat_vals[29];
	document.forms[0].region_desc.value =arr_concat_vals[30];
	document.forms[0].mail_res_town_desc.value =arr_concat_vals[31];
	document.forms[0].mail_res_area_desc.value =arr_concat_vals[32];
	document.forms[0].mail_region_desc.value =arr_concat_vals[33];
	document.forms[0].country_desc.value =arr_concat_vals[34];
	document.forms[0].mail_country_desc.value =arr_concat_vals[35];
	document.forms[0].r_postal_code1.value = unescape(arr_concat_vals[36]);	
	document.forms[0].m_postal_code1.value = unescape(arr_concat_vals[37]);
	/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
	document.forms[0].alt_addr_line1.value = unescape(arr_concat_vals[38]);
	document.forms[0].alt_addr_line2.value = unescape(arr_concat_vals[39]);
	document.forms[0].alt_addr_line3.value = unescape(arr_concat_vals[40]);
	document.forms[0].alt_addr_line4.value = unescape(arr_concat_vals[41]);
	document.forms[0].alt_town_code.value = unescape(arr_concat_vals[42]);
	document.forms[0].alt_area_code.value = unescape(arr_concat_vals[43]);
	document.forms[0].alt_postal_code.value = unescape(arr_concat_vals[44]);
	document.forms[0].alt_region_code.value = unescape(arr_concat_vals[45]);
	document.forms[0].alt_country_code.value = unescape(arr_concat_vals[46]);
	document.forms[0].alt_town_desc.value = unescape(arr_concat_vals[47]);
	document.forms[0].alt_area_desc.value = unescape(arr_concat_vals[48]);
	document.forms[0].alt_postal_code1.value = unescape(arr_concat_vals[49]);
	document.forms[0].alt_region_desc.value = unescape(arr_concat_vals[50]);
	document.forms[0].alt_country_desc.value = unescape(arr_concat_vals[51]);
	/*End*/
}

async function Modal_Contact_Details(obj)
{ 
	var isAlternateAddressAppl = document.forms[0].isAlternateAddressAppl.value;//Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601
	var retVal =    new String();
	var dialogHeight= "700px" ;
	var dialogWidth = "1000px" ;
	/*Modified by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
	if(isAlternateAddressAppl == "true")
		dialogWidth = "80" ;
	/*End*/
	var status = "no";
	var patient_id = document.forms[0].patient_id.value	

	var concat_address_hidden=document.forms[0].addr1_type.value					+"^^"
	+document.forms[0].addr_line1.value						+"^^"
	+document.forms[0].addr_line2.value						+"^^"
	+document.forms[0].addr_line3.value						+"^^"
	+document.forms[0].addr_line4.value						+"^^"
	+document.forms[0].res_town_code.value			+"^^"
	+document.forms[0].res_area_code.value				+"^^"
	+document.forms[0].postal_code.value					+"^^"
	+document.forms[0].region_code.value					+"^^"
	+document.forms[0].country_code.value				+"^^"
	+document.forms[0].contact1_name.value				+"^^"
	+document.forms[0].invalid1_yn.value				+"^^"
	+document.forms[0].addr2_type.value					+"^^"
	+document.forms[0].mail_addr_line1.value			+"^^"
	+document.forms[0].mail_addr_line2.value			+"^^"
	+document.forms[0].mail_addr_line3.value			+"^^"
	+document.forms[0].mail_addr_line4.value			+"^^"
	+document.forms[0].mail_res_town_code.value	+"^^"
	+document.forms[0].mail_res_area_code.value	+"^^"
	+document.forms[0].mail_postal_code.value	    +"^^"
	+document.forms[0].mail_region_code.value		+"^^"
	+document.forms[0].mail_country_code.value+"^^"
	+document.forms[0].contact2_name.value		+"^^"
	+document.forms[0].invalid2_yn.value +"^^"
	+document.forms[0].contact1_no.value +"^^"
	+document.forms[0].contact2_no.value +"^^"
	+document.forms[0].email.value +"^^"
	+document.forms[0].change_address.value +"^^"
	+document.forms[0].res_town_desc.value +"^^"
	+document.forms[0].res_area_desc.value +"^^"
	+document.forms[0].region_desc.value +"^^"
	+document.forms[0].mail_res_town_desc.value +"^^"
	+document.forms[0].mail_res_area_desc.value +"^^"
	+document.forms[0].mail_region_desc.value +"^^"
	+document.forms[0].country_desc.value +"^^"
	+document.forms[0].mail_country_desc.value +"^^"
    +document.forms[0].r_postal_code1.value+"^^"
	+document.forms[0].m_postal_code1.value ;
	/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
	if(isAlternateAddressAppl == "true"){
		concat_address_hidden = concat_address_hidden +"^^"
		+document.forms[0].alt_addr_line1.value	+"^^"
		+document.forms[0].alt_addr_line2.value	+"^^"
		+document.forms[0].alt_addr_line3.value	+"^^"
		+document.forms[0].alt_addr_line4.value	+"^^"
		+document.forms[0].alt_town_code.value	+"^^"
		+document.forms[0].alt_area_code.value	+"^^"
		+document.forms[0].alt_postal_code.value +"^^"
		+document.forms[0].alt_region_code.value +"^^"
		+document.forms[0].alt_country_code.value +"^^"
		+document.forms[0].alt_town_desc.value +"^^"
		+document.forms[0].alt_area_desc.value +"^^"
		+document.forms[0].alt_postal_code1.value +"^^"
		+document.forms[0].alt_region_desc.value +"^^"
		+document.forms[0].alt_country_desc.value ;
	}/*End*/
	var arguments	=concat_address_hidden;		
	var calling_from = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;		
	retVal = await window.showModalDialog( "../../eMP/jsp/ContactDetailsFrame.jsp?patient_id="+patient_id,arguments,features);
	
	if(retVal != null)
	{
		document.forms[0].concat_address_hidden.value=retVal;
		var arr_concat_vals=retVal.split("^^");
		
		document.forms[0].addr1_type.value					= arr_concat_vals[0];//  
		document.forms[0].addr_line1.value						= arr_concat_vals[1]; 
		document.forms[0].addr_line2.value						= arr_concat_vals[2]; 
		document.forms[0].addr_line3.value						= arr_concat_vals[3]; 
		document.forms[0].addr_line4.value						= arr_concat_vals[4]; 
		document.forms[0].res_town_code.value			= arr_concat_vals[5]; //
		document.forms[0].res_area_code.value				= arr_concat_vals[6]; //
		document.forms[0].postal_code.value					= arr_concat_vals[7]; //
		document.forms[0].region_code.value					= arr_concat_vals[8]; //
		document.forms[0].country_code.value				= arr_concat_vals[9]; //
		document.forms[0].contact1_name.value			= arr_concat_vals[10]; //
		document.forms[0].invalid1_yn.value				= arr_concat_vals[11]; //
		document.forms[0].addr2_type.value					= arr_concat_vals[12]; //
		document.forms[0].mail_addr_line1.value			= arr_concat_vals[13];
		document.forms[0].mail_addr_line2.value			= arr_concat_vals[14];
		document.forms[0].mail_addr_line3.value			= arr_concat_vals[15];
		document.forms[0].mail_addr_line4.value			= arr_concat_vals[16]; //
		document.forms[0].mail_res_town_code.value	= arr_concat_vals[17]; //
		document.forms[0].mail_res_area_code.value	= arr_concat_vals[18]; //
		document.forms[0].mail_postal_code.value	    = arr_concat_vals[19]; //
		document.forms[0].mail_region_code.value		=  arr_concat_vals[20]; //
		document.forms[0].mail_country_code.value		=  arr_concat_vals[21]; //
		document.forms[0].contact2_name.value		=  arr_concat_vals[22]; //
		document.forms[0].invalid2_yn.value		=  arr_concat_vals[23]; //
		document.forms[0].contact1_no.value		=  arr_concat_vals[24];
		document.forms[0].contact2_no.value		=  arr_concat_vals[25];
		document.forms[0].email.value		=  arr_concat_vals[26];
		document.forms[0].change_address.value  = 'Y';
		document.forms[0].res_town_desc.value =arr_concat_vals[27];
		document.forms[0].res_area_desc.value =arr_concat_vals[28];
		document.forms[0].region_desc.value =arr_concat_vals[29];
		document.forms[0].mail_res_town_desc.value =arr_concat_vals[30];
		document.forms[0].mail_res_area_desc.value =arr_concat_vals[31];
		document.forms[0].mail_region_desc.value =arr_concat_vals[32];
		document.forms[0].country_desc.value =arr_concat_vals[33];
		document.forms[0].mail_country_desc.value =arr_concat_vals[34];
        document.forms[0].r_postal_code1.value =arr_concat_vals[35];
		document.forms[0].m_postal_code1.value =arr_concat_vals[36];
		/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		if(isAlternateAddressAppl == "true"){
			document.forms[0].alt_addr_line1.value		= arr_concat_vals[37];
			document.forms[0].alt_addr_line2.value		= arr_concat_vals[38];
			document.forms[0].alt_addr_line3.value		= arr_concat_vals[39];
			document.forms[0].alt_addr_line4.value		= arr_concat_vals[40];
			document.forms[0].alt_town_code.value	= arr_concat_vals[41];
			document.forms[0].alt_area_code.value	= arr_concat_vals[42];
			document.forms[0].alt_postal_code.value		= arr_concat_vals[43];
			document.forms[0].alt_region_code.value		= arr_concat_vals[44];
			document.forms[0].alt_country_code.value	= arr_concat_vals[45];
			document.forms[0].alt_town_desc.value	= arr_concat_vals[46];
			document.forms[0].alt_area_desc.value	= arr_concat_vals[47];
			document.forms[0].alt_postal_code1.value	= arr_concat_vals[48];
			document.forms[0].alt_region_desc.value		= arr_concat_vals[49];
			document.forms[0].alt_country_desc.value	= arr_concat_vals[50];
		}/*End*/
		
	}
}

function onBlurCallContactReasonSearch(obj,target_name,val)
{
	target_name.value = trimString(target_name.value);
	 if(target_name.readonly == true)
	{
	 return;
	}	 
	if(target_name.value == "")
	{
		 document.forms[0].contact_reason_code.value="";
		 return;
	}
	var prev_cat=document.forms[0].contact_reason_txt_hidd.value;
	var present_cat=document.forms[0].contact_reason_txt.value;	
	if(present_cat!="" && prev_cat ==present_cat)
	{
		 return;
	}
	CallContactReasonSearch(obj,target_name,val);
}
async function CallContactReasonSearch(obj,target,val)
{
	var tit				= getLabel("Common.ReasonforVisit.label",'Common');
	
	/*Below line added for this CRF GDOH-CRF-0129*/
	var isReferral      = document.forms[0].isReferral.value;
	 if(isReferral=="true")	tit=getLabel("Common.Referralfrom.label","Common");
	//End this CRF GDOH-CRF-0129
	
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;	
    locale=document.forms[0].locale.value;
	sql="select contact_reason_code code,contact_reason description from am_contact_reason_lang_vw where VISIT_REGISTRATION_YN = 'Y' and eff_status='E' and upper(contact_reason_code) like upper(?) and upper(contact_reason)   like upper(?) and language_id='"+locale+"'";			

	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= document.forms[0].contact_reason_txt.value;
	argumentArray[6]	= CODE_LINK;
	argumentArray[7]	= CODE_DESC;	
	retVal = await CommonLookup( tit, argumentArray );		
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].contact_reason_txt.value=arr[1];
		document.forms[0].contact_reason_code.value=arr[0];			
		document.forms[0].contact_reason_txt_hidd.value=document.forms[0].contact_reason_txt.value;
		//Below line added for this CRF GDOH-CRF-0129
		if(document.forms[0].isReferral && document.forms[0].isReferral.value=="true"){
		  document.forms[0].assigncare_loctype_ind.value="R";
		  document.forms[0].assigncare_locacode.value=arr[0];		
		 }
		//End GDOH-CRF-0129
	}	
	else
	{
		document.forms[0].contact_reason_txt.value="";
		document.forms[0].contact_reason_code.value="";			
		document.forms[0].contact_reason_txt_hidd.value=document.forms[0].contact_reason_txt.value;		
		//Below line added for this CRF GDOH-CRF-0129
		if(document.forms[0].isReferral && document.forms[0].isReferral.value=="true"){
		  document.forms[0].assigncare_loctype_ind.value="";
		  document.forms[0].assigncare_locacode.value="";		
		}
		//End GDOH-CRF-0129
	}
}
function onBlurCallCatalogSearch(obj,target_name)
{
	//target_name.value = trimString(target_name.value);
		 
	if(target_name.value == "")
	{
		 document.forms[0].order_cat_code.value="";
		 return;
	}
	var prev_cat=document.forms[0].order_cat_txt_hidd.value;
	var present_cat=document.forms[0].order_cat_txt.value;

	if(present_cat!="" && prev_cat ==present_cat)
	{
		 return;
	}
	CallCatalogSearch(obj,target_name);
}

async function CallCatalogSearch(obj,target)
{
	var module_id='OP';
	var order_type="";
	var order_category="";
	var mode="";
	var searchtext=target.value;

	var clinic_code = parent.frames[3].document.forms[0].assign_care_locn_code.value;

	/*var dialogTop	= "56";
	var dialogHeight= "33" ;
	var dialogWidth = "50" ;*/
	
	var dialogTop	= "0vh";
	var dialogHeight= "90vh" ;
	var dialogWidth = "60vw" ;
	
	var status = "no";
	var scroll = "no";
	var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
	var arguments   = "" ;			
	var retVal=await top.window.showModalDialog("../../eOR/jsp/OrderableFrameSet.jsp?searchText="+encodeURIComponent(searchtext)+"&called_from=OP&mode="+mode+"&order_category="+order_category+"&order_type="+order_type+"&p_clinic_code="+clinic_code,arguments,features);	
	/*patient_id,clinic_code,bl_success Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461]*/				
	var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='popordercatalog' id='popordercatalog' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='callfunc' id='callfunc' value='OrderCatalog'><input type='hidden' name='patient_id' id='patient_id' value='"+parent.frames[3].document.forms[0].patient_id.value+"'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='bl_success' id='bl_success' value='"+parent.frames[3].document.forms[0].bl_success.value+"'/></form></body></html>";	

	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.popordercatalog.submit();
}

async function otherResourceLookUp(obj,target)
{
	var clinic_code = parent.frames[3].document.forms[0].assign_care_locn_code.value;
	var other_resType=parent.frames[3].document.forms[0].other_res_type.value;
	var facility_id = parent.frames[3].document.forms[0].facilityid.value;

		locale=document.forms[0].locale.value;
	if(other_resType != '')
	{
	var sql="SELECT PRACTITIONER_ID code, DECODE(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2'),'R', AM_GET_DESC.AM_FACILITY_ROOM(facility_id, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2'),		 'O',AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2')) description FROM op_pract_for_clinic WHERE facility_id='"+facility_id+"'  AND resource_class='"+other_resType+"' AND clinic_code='"+clinic_code+"' AND eff_status='E' AND  UPPER(PRACTITIONER_ID) LIKE UPPER(?) AND(UPPER(am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2)) LIKE UPPER(?) OR  UPPER(am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2)) IS NULL) ORDER BY 2";

	
	var tit				= getLabel('Common.resource.label','Common');
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var arr			= new Array() ;

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.forms[0].other_res_txt.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].other_res_txt.value=arr[1];
		document.forms[0].other_res_code.value=arr[0];
	}else
	{
		document.forms[0].other_res_txt.value="";
		document.forms[0].other_res_code.value="";
	}
	}
	else
	{
		document.forms[0].other_res_txt.value="";
		document.forms[0].other_res_code.value="";
	}

}
function clearResourceVal(obj)
{
   document.forms[0].other_res_txt.value="";
   document.forms[0].other_res_code.value="";
   if(obj.value != '')
	{
	   document.forms[0].other_res_txt.readOnly=false;
	   document.forms[0].other_res_butt.disabled=false;
	}else
	{
	   document.forms[0].other_res_txt.readOnly=true;
	   document.forms[0].other_res_butt.disabled=true;
	}

}

function focusElement()
{


if(document.forms[0].pat_id1!=null )
	{
if(document.forms[0].pat_id1.value=="")
	{
document.forms[0].pat_id1.focus() ;
	}
	}
}
async function show_patwindow(q_clinic_code,q_appt_ref_no,referral_id,fac_id)
{  
    
	var retVal =    new String();
    var dialogHeight= "15.5" ;
    //var dialogWidth = "40" ;
	var dialogWidth = "52" ; //Modofied for this CRF HSA-CRF-0289
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
    var arguments   = "" ;
    q_add_params = ""
       if(referral_id != '')
         q_add_params = "&p_referral_id="+referral_id+"" ; 
         
    retVal = await window.showModalDialog("../../eMP/jsp/VisitRegistrationPromptPatID.jsp?from_VR=Y&q_appt_ref_no="+q_appt_ref_no+"&function_id="+fac_id+"&q_clinic_code="+q_clinic_code+q_add_params,arguments,features);
    self.location.reload();// RELOADS THE FORM 
    
    return retVal;
    
}

async function show_invitation(val)
{
	
		var retVal =    new String();
		var dialogHeight= "12.5" ;
		var dialogWidth = "20" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments   = "" ;
		q_add_params = ""
		 
		retVal = await window.showModalDialog("../../eOP/jsp/AcceptInvitationNo.jsp?invite_no="+val,arguments,features);
		
		return retVal;

}

async function show_patwindowReferral(q_clinic_code,q_appt_ref_no,referral_id)
{  
 
	var retVal =    new String();
    var dialogHeight= "55vh" ;
    //var dialogWidth = "40" ; 
	//Modified iidth for HSA-CRF-0289
	var dialogWidth = "60vw" ; 
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
    var arguments   = "" ;
    q_add_params = ""
       if(referral_id != '')
         q_add_params = "&p_referral_id="+referral_id+"" ; 
    if(q_appt_ref_no!=null && q_appt_ref_no!="")
	{
	retVal = await window.showModalDialog("../../eMP/jsp/VisitRegistrationPromptPatID.jsp?q_appt_ref_no="+q_appt_ref_no+"&function_id="+parent.frames[1].document.forms[0].functionId.value+"&func_act=&q_clinic_code="+q_clinic_code+q_add_params,arguments,features);
	}else{
	retVal = await window.showModalDialog("../../eMP/jsp/VisitRegistrationPromptPatID.jsp?q_appt_ref_no="+q_appt_ref_no+"&function_id="+parent.frames[1].document.forms[0].functionId.value+"&func_act=REF_SEARCH&q_clinic_code="+q_clinic_code+q_add_params,arguments,features);
	}
	PatVisHid(4);// added by munisekhar for MMS-QH-CRF-0162	
	return retVal;
	   
   // self.location.reload();// RELOADS THE FORM 
    
    
	
	
    
}


function setBL(){
 	if(parent.frames[0].document.forms[0].bl_enter_yn != null)
	{
 		parent.frames[0].document.forms[0].bl_enter_yn.value='Y';	
	}	
}

function checkingBL()
{	
	var retVal = true;
	if(parent.frames[3].document.forms[0].bl_enter_yn != null)
	{
  		if(	parent.frames[3].document.forms[0].bl_enter_yn.value=='Y'){
			retVal = false;
		}
			
	}	
 	return retVal;
}

/**
Used to Validate Visit Date Time.
**/
function chkFromToTime2(Obj)
{
	var fromFormDate ='';
	var errors='';
	var AllowedDate ='';
	var sysDateSer	='';//Added by Rameswar on 01-Oct-15 for Leap Year Issue
	if(Obj.value != '') 
	{
		if(!validDate(Obj.value,'DMYHMS',localeName))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'))
			Obj.select();
		}
		else
		{
			fromFormDate = convertDate(Obj.value,"DMYHMS",localeName,"en");
			/*Below Changes are done by Rameswar on 01-Oct-15 for Leap Year Issue*/
            AllowedDate = convertDate(document.forms[0].AllowedDate.value,"DMYHMS","en",localeName);
			sysDateSer	= convertDate(document.forms[0].sysDateSer.value,"DMYHMS",localeName,"en");
			
            if((!isBetween(document.forms[0].AllowedDate.value,sysDateSer,fromFormDate,'DMYHMS',"en")))
			{
				errors = errors + getMessage("OP_VISIT_PARAM_DATE_TIME","OP"); 
                errors = errors.replace('$',AllowedDate);
				alert(errors);
				Obj.select();
			}
		}
	}
}

function chkValue(obj,rownum)
{			
			var key = eval(document.getElementById("order_ctl_code"+rownum)).value;
			var value = eval(document.getElementById("order_ctl_desc"+rownum)).value;
			var order_category = eval(document.getElementById("order_cat_"+rownum)).value;
			var order_type_code= eval(document.getElementById("order_type_"+rownum)).value;
			var bean_id=document.getElementById("bean_id").value;
			var bean_name=document.getElementById("bean_name").value;		
			
			if(obj.checked)
			{
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
			
				var functional_mode="Add_Order_Catalog";
				xmlStr ="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				xmlHttp.open( "POST", "../../eOR/jsp/OrderableValidate.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_category="+order_category+"&order_type_code="+order_type_code,false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval(responseText );
			}			
			else
			{
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
			
				var functional_mode="Remove_Order_Catalog";
				xmlStr ="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				xmlHttp.open( "POST", "../../eOR/jsp/OrderableValidate.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_category="+order_category+"&order_type_code="+order_type_code,false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval(responseText );
			}			
}
		function  clearOrderCatalog() {    
		   parent.frames[3].document.getElementById('order_ctlg_tbl').innerHTML ="";	
		   parent.frames[3].document.forms[0].order_cat_txt.readOnly=true;
		   parent.frames[3].document.forms[0].order_cat_butt.disabled=true;
		   parent.frames[3].document.forms[0].order_cat_txt.value="";
		   parent.frames[3].document.forms[0].order_cat_code.value="";
		   parent.frames[3].document.forms[0].order_category_code.value="";
		   parent.frames[3].document.forms[0].order_type_code.value="";
		   if(parent.frames[3].document.getElementById('gifpopord') != null)
				parent.frames[3].document.getElementById('gifpopord').style.visibility='hidden';
		   var bean_id=document.getElementById('bean_id').value;
		   var bean_name=document.getElementById('bean_name').value;				
		   var xmlDoc = "" ;
		   var xmlHttp = new XMLHttpRequest() ;			
		   var functional_mode="Clear_Order_Catalogs";
				xmlStr ="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");				
				xmlHttp.open( "POST", "../../eOR/jsp/OrderableValidate.jsp?validate="+functional_mode+"&bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval(responseText );		
       }

function populateRoomDesc(obj){
	 
	if(!obj.value == ""){
		
		/*Below line modified for this CRF  Bru-HIMS-CRF-165.1 [IN:035659]*/		
		/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */	
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient6' id='dummypromptpatient6' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='populate_room'><input type='hidden' name='room_no' id='room_no' value='"+obj.value+"'><input type = 'hidden' name = 'order_count_select' value = '"+parent.frames[3].document.forms[0].order_count_select.value+"' ><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'></form></body></html>";  
		 
		var message_frame=parent.parent.frames[2];
		if(message_frame!=null) {
		  message_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		  message_frame.document.dummypromptpatient6.submit();
		}
	} else {
		parent.frames[3].document.getElementById('roomDesc').innerHTML="";
	}
		 
}
function msgDisplayFromServlet(msgKey,modID){
	//var msg=getMessage(msgKey,modID);
	//alert(msg)
	//alert(parent.parent.frames[0].name)
	//alert(parent.parent.frames[1].name)
	//alert(parent.parent.frames[2].name)
	//parent.parent.frames[0].location.reload();
	//parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
}
function defaultVisitType(){ 
	if(document.forms[0].visit_adm_type)
	  removeitems(document.forms[0].visit_adm_type);
	/*Below line modified for this CRF  Bru-HIMS-CRF-165.1 [IN:035659]*/
	/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
	var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient10' id='dummypromptpatient10' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='default_Visit'><input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value='"+parent.frames[3].document.forms[0].attend_practitioner_id.value+"'><input type='hidden' name='patient_id' id='patient_id' value='"+parent.frames[3].document.forms[0].patient_id.value+"'><input type='hidden' name='care_locn_code' id='care_locn_code' value='"+parent.frames[3].document.forms[0].assign_care_locn_code.value+"'><input type='hidden' name='service_code' id='service_code' value='"+parent.frames[3].document.forms[0].service_code.value+"'><input type = 'hidden' name = 'order_count_select' value = '"+parent.frames[3].document.forms[0].order_count_select.value+"' ><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'></form></body></html>"; 			
	var message_frame=parent.parent.frames[2];
	if(message_frame!=null) {
		message_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		message_frame.document.dummypromptpatient10.submit();
	}
}

//included for MMS-QH-CRF-41.1 

function populateVisitTypeForBillingInsurance(vst_typ_ind,episode_id,blng_grp_id,cust_code,cust_grp_code,policy_type_code,frame_ref,message_frame){ 
	//Added for the sCF - MMS-SCF-0082
	//Added for this incident[52513]	
	if(frame_ref == 'undefined' || frame_ref=='null' || frame_ref==null) frame_ref=parent.frames[3];
	if(message_frame == 'undefined' || message_frame=='null' || message_frame==null)  message_frame=parent.parent.frames[2];
	var old_vst_type_ind=frame_ref.document.forms[0].vst_type_ind.value;
	//var old_vst_type_ind="";
	if(old_vst_type_ind=='' || (vst_typ_ind!='' && old_vst_type_ind!=vst_typ_ind) || (old_vst_type_ind!='' && vst_typ_ind=='') ){
		if(frame_ref.document.forms[0].visit_adm_type){
			removeitems(frame_ref.document.forms[0].visit_adm_type);
		}
	

		var vst_regn_date_time = frame_ref.document.forms[0].vst_regn_date_time.value;
		var vst_date_time=convertDate(vst_regn_date_time,"DMYHMS",localeName,"en");	
		
		//var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient11' id='dummypromptpatient11' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='visit_for_blng'><input type='hidden' name='patient_id' id='patient_id' value='"+parent.frames[3].document.forms[0].patient_id.value+"'><input type='hidden' name='care_locn_code' id='care_locn_code' value='"+parent.frames[3].document.forms[0].assign_care_locn_code.value+"'><input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+parent.frames[3].document.forms[0].bl_install_yn.value+"'><input type='hidden' name='service_code' id='service_code' value='"+parent.frames[3].document.forms[0].service_code.value+"'><input type='hidden' name='vst_date_time' id='vst_date_time' value='"+vst_date_time+"'><input type='hidden' name='vst_typ_frm_blng' id='vst_typ_frm_blng' value='"+vst_type_ind+"'></form></body></html>"; 			
		/*above line commented and below line added for this CRF  Bru-HIMS-CRF-165.1 [IN:035659]*/
		/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dummypromptpatient11' id='dummypromptpatient11' method='post' action='../../eOP/jsp/VisitRegistrationInt.jsp'><input type='hidden' name='list_name' id='list_name' value='visit_for_blng'><input type='hidden' name='patient_id' id='patient_id' value='"+frame_ref.document.forms[0].patient_id.value+"'><input type='hidden' name='care_locn_code' id='care_locn_code' value='"+frame_ref.document.forms[0].assign_care_locn_code.value+"'><input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+frame_ref.document.forms[0].bl_install_yn.value+"'><input type='hidden' name='service_code' id='service_code' value='"+frame_ref.document.forms[0].service_code.value+"'><input type='hidden' name='vst_date_time' id='vst_date_time' value='"+vst_date_time+"'><input type='hidden' name='old_vst_type_ind' id='old_vst_type_ind' value='"+frame_ref.document.forms[0].vst_type_ind.value+"'><input type='hidden' name='vst_typ_frm_blng' id='vst_typ_frm_blng' value='"+vst_typ_ind+"'><input type = 'hidden' name = 'order_count_select' value = '"+frame_ref.document.forms[0].order_count_select.value+"' ><input type = 'hidden' name = 'episode_id' value = '"+episode_id+"' ><input type = 'hidden' name = 'policy_type_code' value = '"+policy_type_code+"' ><input type = 'hidden' name = 'cust_code' value = '"+cust_code+"' ><input type = 'hidden' name = 'cust_grp_code' value = '"+cust_grp_code+"' ><input type = 'hidden' name = 'blng_grp_id' value = '"+blng_grp_id+"' ><input type = 'hidden' name = 'billing_frame' value = '"+frame_ref+"' ><input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='"+parent.frames[1].document.forms[0].upt_contact_dtls_oa_yn.value+"'></form></body></html>";
		
		//var message_frame=parent.parent.frames[2];
		if(message_frame!=null) {
		  message_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		  message_frame.document.dummypromptpatient11.submit();
		}

	}
}

/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start*/

function chkForm60OrPanCardAvail(obj,isForm60Available){
	var patientId			= obj.value;
	if(isForm60Available=="true" && patientId!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='chkForm60OrPanCardAvail' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		return responseText;
	}
}
/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End*/

//Added by Sangeetha for KDAH-CRF-0347 on 13/apr/17
function PanCardAvailCheck(obj,isPanCardAvailable){
	var patientId			= obj.value;
	if(isPanCardAvailable=="true" && patientId!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='PanCardAvailCheck' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		return responseText;
	}
}
/*Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461] Start*/
function calOrdCtlgAmt(calledFrom){
	var frameRef	= "";
	if(calledFrom=='onApply'){
		frameRef	= frames[1].frames[3].document.all;
	}else{
		frameRef	= parent.frames[3].document.all;
	}

	//var frameRef	= parent.patient_sub3.document.all;
	var isOrderCtlgAmtCalc = frameRef.isOrderCtlgAmtCalc.value;
	if(isOrderCtlgAmtCalc=="true"){
		var selCtlgCodeList	= "";
		var bl_success	= frameRef.bl_success.value
		var clinic_code = frameRef.assign_care_locn_code.value;
		var	amtArr			= {};	
		$('input[type=checkbox]',frameRef).filter(':checked').each(function() {
			selCtlgCodeList	= selCtlgCodeList+$(this).val()+"~~";
		});
		if(selCtlgCodeList!=""){
			 $.ajax({
				 async: false,
				 url:"../../eBL/jsp/BLCommonAjax.jsp?patientId="+frameRef.patient_id.value+"&orderCatalogCode=~~"+selCtlgCodeList+"&functionMode=getOrderCatalogAmt"+"&bl_success="+bl_success+"&clinic_code="+clinic_code,  
				 type:'get', 
				 dataType: 'json',
				 success: function(data) {
						 if(data!=null){
							if(data.orderCatalogDtls!="undefined"){

								var codeArr	= selCtlgCodeList.split("~~");
								$.each(codeArr,function(index,ctlgCode){
									if(ctlgCode!=""){
											ctlgArr	= data.orderCatalogDtls[index];
											ctlgAmtArr	= ctlgArr[ctlgCode];
											$("#netAmt"+ctlgCode,frameRef).html(ctlgAmtArr.netAmt);
											$("#payerNetAmt"+ctlgCode,frameRef).html(ctlgAmtArr.payerNetAmt);
											$("#patNetAmt"+ctlgCode,frameRef).html(ctlgAmtArr.patNetAmt);

									}else{
										var total	= data.orderCatalogDtls[index]
										totalAmtArr	= total['totals'];
										$("#totNetAmt",frameRef).html(totalAmtArr.totalNetAmt);
										$("#totPayerNetAmt",frameRef).html(totalAmtArr.payerTotalNetAmt);
										$("#totPatNetAmt",frameRef).html(totalAmtArr.patTotalNetAmt);
									}
								});
		
							}
						 }
				 
				 }});

				 selCtlgCodeList	="~~"+selCtlgCodeList;	
				
		}else{
			$("#totNetAmt",frameRef).html("0");
			$("#totPayerNetAmt",frameRef).html("0");
			$("#totPatNetAmt",frameRef).html("0");

		}
		 $("#selOrdCtlgCodes",frameRef).val(selCtlgCodeList);
	}
}

/*Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461] End*/

/*Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1*/
function getCommonQueueDtls(queue_pkid_obj,facility_id,calledFrom){
	
	var frameRef = "";
	var queue_pkid = "";
	var token_details = "";
	var split_token_details = "";
	var status = "";
	var status_msg = "";
	var common_queue_id = "";
	var common_queue_no = "";
	var common_queue_issue_dt_tm = "";
	var common_queue_called_dt_tm = "";
	var patient_id = "";
	var encounter_id = "";
	var user_id = "";
	var disp_msg = "";

	if(calledFrom == 'onApply'){
		frameRef = frames[1].frames[3].document.all;
	}else{
		frameRef = parent.frames[3].document.all;
	}
	
	patient_id = frameRef.patient_id.value;
	user_id = frameRef.user_id.value;
	
	queue_pkid = queue_pkid_obj.value;
	
	if(queue_pkid != ""){

		token_details = getTokenDetails('VSTREG',facility_id,queue_pkid,patient_id,encounter_id,user_id);

		if(token_details != ""){
			split_token_details = token_details.split("$!^");

			status = split_token_details[0];
			status_msg = split_token_details[1];
			common_queue_id = split_token_details[2];
			common_queue_no = split_token_details[3];
			common_queue_issue_dt_tm = split_token_details[4];
			common_queue_called_dt_tm = split_token_details[5];
		}
		
		frameRef.common_queue_status.value = status;
		frameRef.common_queue_status_msg.value = status_msg;
		frameRef.common_queue_id.value = common_queue_id;
		frameRef.common_queue_no.value = common_queue_no;
		frameRef.common_queue_issue_dt_tm.value = common_queue_issue_dt_tm;
		frameRef.common_queue_called_dt_tm.value = common_queue_called_dt_tm;

		var str_pos1 = status_msg.indexOf("invalid");
		var str_pos2 = status_msg.indexOf("Invalid");
		var str_pos3 = status_msg.indexOf("does not exist");
		
		if(status == "S"){
			disp_msg = getMessage("TOK_DISPDTL_RECEIVED","OP");
			parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+disp_msg;
		}else if(str_pos1 > -1 || str_pos2 > -1 || str_pos3 > -1){
			disp_msg = getMessage("INVALID_QUEUE_PKID","OP");
			parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+disp_msg;
		}else{
			disp_msg = getMessage("TOK_DISPDTL_NOT_RECEIVED","OP");
			parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+disp_msg;
		}
		
	}else{
		disp_msg = getMessage("CANNOT_CAPTURE_TOK_DISPDTL","OP");
		frameRef.common_queue_status.value = "";
		frameRef.common_queue_status_msg.value = "";
		frameRef.common_queue_id.value = "";
		frameRef.common_queue_no.value = "";
		frameRef.common_queue_issue_dt_tm.value = "";
		frameRef.common_queue_called_dt_tm.value = "";
		
		status_msg = "";
		parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+status_msg;
	}
}

function getVirtualQueueDtls(calledFrom){
	
	var frameRef = "";
	var token_details = "";
	var split_token_details = "";
	var status = "";
	var status_msg = "";
	var virtual_queue_id = "";
	var virtual_queue_no = "";
	var virtual_queue_issue_dt_tm = "";
	var virtual_queue_called_dt_tm = "";
	var encounter_id = "";
	var appt_true_yn = "";
	var split_appt_date = "";
	var appt_date = "";

	if(calledFrom == 'onApply'){
		frameRef = frames[1].frames[3].document.all;
	}else{
		frameRef = parent.frames[3].document.all;
	}

	var facility_id = frameRef.facilityId.value;
	var practitioner_id = frameRef.attend_practitioner_id.value;
	var location_id = frameRef.assign_care_locn_code.value;
	var patient_id = frameRef.patient_id.value;
	var patient_name = frameRef.patient_name.value;
	var appt_ref_no = frameRef.appt_ref_no.value;
	var visit_date = frameRef.visit_date.value;
	var appt_time = frameRef.q_appt_time.value;
	var user_id = frameRef.user_id.value;

	if(appt_ref_no == ""){
		appt_true_yn = 'N';
		appt_date = "";
	}else{
		appt_true_yn = 'Y';
		split_appt_date = visit_date.split(" ");
		appt_date = split_appt_date[0];
	}
	
	token_details = getNewToken('VSTREG',facility_id,practitioner_id,location_id,patient_id,patient_name,appt_true_yn,appt_date,appt_time,encounter_id,user_id);
	
	if(token_details != ""){
		split_token_details = token_details.split("$!^");

		status = split_token_details[0];
		status_msg = split_token_details[1];
		virtual_queue_id = split_token_details[2];
		virtual_queue_no = split_token_details[3];
		virtual_queue_issue_dt_tm = split_token_details[4];
		virtual_queue_called_dt_tm = split_token_details[5];
	}
	
	frameRef.virtual_queue_status.value = status;
	frameRef.virtual_queue_status_msg.value = status_msg;
	frameRef.virtual_queue_id.value = virtual_queue_id;
	frameRef.virtual_queue_no.value = virtual_queue_no;
	frameRef.virtual_queue_issue_dt_tm.value = virtual_queue_issue_dt_tm;
	frameRef.virtual_queue_called_dt_tm.value = virtual_queue_called_dt_tm;

	if(status == "E"){
		var err_msg	= getMessage("QUEUE_NO_NOT_GENERATED","OP");
		
		if(confirm(err_msg)){
				
		}else{
			getVirtualQueueDtls('onApply');
		}
	}
}
/*End TH-KW-CRF-0020.1*/

//ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005
async function getReferralReqID(obj){
	if(obj.checked){
		var funcid=document.forms[0].functionId.value;
		
		var retVal;
		var dialogTop       = "61";
		var dialogHeight    = "700px";
		var dialogWidth = "800px";    
		var arguments   = "" ;
		var center = "1" ;
		var status="no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scrolling :" + "NO" ;
		
		var patient_id= document.forms[0].patient_id.value;
		var locn_type = document.forms[0].locn_type.value;
		var assign_care_locn_code =document.forms[0].assign_care_locn_code.value;
		var speciality_code = document.forms[0].locationSpeciality.value;
		var visit_type_code = document.forms[0].visit_adm_type.value;
		var service_code=document.forms[0].service_code.value;
		
		var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?p_to_locn_code="+assign_care_locn_code+"&p_service_code="+service_code+"&p_calling_function=OP_REG_VISIT&p_select=YES&p_reg_patient=YES&ass_func_id=REFERAL_REQUIRED&p_speciality_code="+speciality_code+"&p_to_locn_type="+locn_type+"&p_patient_id="+patient_id;
				
		retVal = await window.showModalDialog(url,arguments,features);
		if(retVal!="" && retVal!=undefined) {
			var locale=document.forms[0].locale.value; 
			
			var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr = "<root><SEARCH referal_id=\""+retVal+"\" locale=\""+locale+"\" action='visit_clinic_referalId' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eOP/jsp/OPIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText = xmlHttp.responseText
			var ref_dtls = trimString(xmlHttp.responseText);
			document.getElementById("refdetails").innerHTML = ref_dtls;
			
			var Referal_Required = document.getElementById("Referal_Required");
			$(Referal_Required).prop('disabled', true);
			document.getElementById('qloc_butt_id').style.visibility='hidden';
		} else {
			var Referal_Required = document.getElementById("Referal_Required");
			$(Referal_Required).prop('checked', false);
		}
		if(retVal==null){
			retVal="";
		}
		document.forms[0].financial_detail_ref_id.value= retVal;
		document.forms[0].referral_code.value= retVal;
			
	  
	}
}
//END

