
	function reset() {
		
	if(f_query_add_mod.document.repallergytype){
	f_query_add_mod.document.repallergytype.reset() ;	
	}
	if(f_query_add_mod.document.repbloodgroup){
	f_query_add_mod.document.repbloodgroup.reset() ;
	}
	if(f_query_add_mod.document.repcptcode){
	f_query_add_mod.document.repcptcode.reset() ;
	}
	if(f_query_add_mod.document.repdiaggroup){
	f_query_add_mod.document.repdiaggroup.reset() ;
	}
	if(f_query_add_mod.document.repdiaggroupdet){
	f_query_add_mod.document.repdiaggroupdet.reset() ;
	}
	if(f_query_add_mod.document.rephighrisk){
	f_query_add_mod.document.rephighrisk.reset() ;
	}
	if(f_query_add_mod.document.repnotessection){
	f_query_add_mod.document.repnotessection.reset() ;
	}
	if(f_query_add_mod.document.reprhesusfactor){
	f_query_add_mod.document.reprhesusfactor.reset() ;
	}
	if(f_query_add_mod.document.reptabulationlist){
	f_query_add_mod.document.reptabulationlist.reset() ;
	}
	if(f_query_add_mod.document.repaccessright){
	f_query_add_mod.document.repaccessright.reset() ;
	}
	if(f_query_add_mod.document.repicdcode){
	f_query_add_mod.document.repicdcode.reset() ;
	}
	if(f_query_add_mod.document.repNotifiableDiseaseVisitForm){
	f_query_add_mod.document.repNotifiableDiseaseVisitForm.reset() ;
	}
	if(f_query_add_mod.document.repMedEventType)
	{
	f_query_add_mod.document.repMedEventType.reset() ;
	}

	if(f_query_add_mod.document.repDiagGroup)
	{
	f_query_add_mod.document.repDiagGroup.reset() ;
	}

	if(f_query_add_mod.document.repGroupDetail)
	{
	f_query_add_mod.document.repGroupDetail.reset() ;
	}

	if(f_query_add_mod.document.repICDForTablist)
	{
	f_query_add_mod.document.repICDForTablist.reset() ;
	}



}//e.o.reset

function run()
{

if(f_query_add_mod.document.repallergytype)
{

	if( f_query_add_mod.CheckString(getLabel("eMR.AllergyTypeCode.label","MR"), f_query_add_mod.document.repallergytype.p_fm_allergy_code,f_query_add_mod.document.repallergytype.p_to_allergy_code, messageFrame )  )
	f_query_add_mod.document.repallergytype.submit() ;
}


if(f_query_add_mod.document.repbloodgroup){
if( f_query_add_mod.CheckString(getLabel("Common.bloodgroup.label","Common"), f_query_add_mod.document.repbloodgroup.p_fm_blood_grp,f_query_add_mod.document.repbloodgroup.p_to_blood_grp, messageFrame )  )
f_query_add_mod.document.repbloodgroup.submit() ;
}

if(f_query_add_mod.document.repcptcode){
if( f_query_add_mod.CheckString(getLabel("eMR.CPTCode.label","MR"), f_query_add_mod.document.repcptcode.p_fm_cpt_code,f_query_add_mod.document.repcptcode.p_to_cpt_code, messageFrame )  )
f_query_add_mod.document.repcptcode.submit() ;
}

if(f_query_add_mod.document.repdiaggroup){
if( f_query_add_mod.CheckString(getLabel("eMR.CustomDiagnosisGroup.label","MR"), f_query_add_mod.document.repdiaggroup.p_fm_daig_code,f_query_add_mod.document.repdiaggroup.p_to_daig_code, messageFrame )  )
f_query_add_mod.document.repdiaggroup.submit() ;
}

if(f_query_add_mod.document.repdiaggroupdet){
if( f_query_add_mod.CheckString(getLabel("eMR.CustomDiagnosisGroupDetails.label","MR"), f_query_add_mod.document.repdiaggroupdet.p_fm_diag_group_code,f_query_add_mod.document.repdiaggroupdet.p_to_diag_group_code, messageFrame )  )
f_query_add_mod.document.repdiaggroupdet.submit() ;
}

if(f_query_add_mod.document.rephighrisk){
if( f_query_add_mod.CheckString(getLabel("Common.HighRisk.label","Common"), f_query_add_mod.document.rephighrisk.p_fm_risk_code,f_query_add_mod.document.rephighrisk.p_to_risk_code, messageFrame )  )
f_query_add_mod.document.rephighrisk.submit() ;
}

if(f_query_add_mod.document.repnotessection){
if( f_query_add_mod.CheckString(getLabel("eMR.NotesSectionHeading.label","MR"), f_query_add_mod.document.repnotessection.p_fm_sec_hgd,f_query_add_mod.document.repnotessection.p_to_sec_hgd, messageFrame )  )
f_query_add_mod.document.repnotessection.submit() ;
}

if(f_query_add_mod.document.reprhesusfactor){
if( f_query_add_mod.CheckString(getLabel("eMR.RhesusFactorCode.label","MR"), f_query_add_mod.document.reprhesusfactor.p_fm_rhesus_code,f_query_add_mod.document.reprhesusfactor.p_to_rhesus_code, messageFrame )  )
f_query_add_mod.document.reprhesusfactor.submit() ;
}

if(f_query_add_mod.document.reptabulationlist){
if( f_query_add_mod.CheckString(getLabel("eMR.TabulationListCode.label","MR"), f_query_add_mod.document.reptabulationlist.p_fm_tab_list,f_query_add_mod.document.reptabulationlist.p_to_tab_list, messageFrame )  )
f_query_add_mod.document.reptabulationlist.submit() ;
}

if(f_query_add_mod.document.repaccessright){
if( f_query_add_mod.CheckString(getLabel("Common.UserAccessRights.label","Common"), f_query_add_mod.document.repaccessright.p_fm_appl_user_id,f_query_add_mod.document.repaccessright.p_to_appl_user_id, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.UserAccessRights.label","Common"), f_query_add_mod.document.repaccessright.p_fm_facility_id,f_query_add_mod.document.repaccessright.p_to_facility_id, messageFrame )  )
f_query_add_mod.document.repaccessright.submit() ;
}


if(f_query_add_mod.document.repicdcode){

if( f_query_add_mod.CheckString(getLabel("Common.DiagnosisCode.label","Common"), f_query_add_mod.document.repicdcode.p_fm_diag_code,f_query_add_mod.document.repicdcode.p_to_diag_code, messageFrame )  )
f_query_add_mod.document.repicdcode.submit() ;
}

if(f_query_add_mod.document.repNotifiableDiseaseVisitForm){

if( f_query_add_mod.CheckString(getLabel("Common.DiagnosisCode.label","Common"), f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_fm_diag_code,f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_to_diag_code, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.FacilityID.label","Common"), f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_fm_facility_id,f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_to_facility_id, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.ClinicCode.label","Common"), f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_fm_clinic_code,f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_to_clinic_code, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.practitionerid.label","Common"), f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_fm_pract_id,f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_to_pract_id, messageFrame )  )
if(f_query_add_mod.doDateCheck(f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_fm_diag_date,f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_to_diag_date,messageFrame))

	{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	f_query_add_mod.document.forms[0].target="messageFrame"
	f_query_add_mod.document.repNotifiableDiseaseVisitForm.submit() ;
	}
}

if(f_query_add_mod.document.repMedEventType)
{
if( f_query_add_mod.CheckString(getLabel("Common.EventType.label","Common"), f_query_add_mod.document.repMedEventType.p_fm_event_type,f_query_add_mod.document.repMedEventType.p_to_event_type, messageFrame )  )
	f_query_add_mod.document.repMedEventType.submit() ;
}

if(f_query_add_mod.document.repDiagGroup)
{
if( f_query_add_mod.CheckString(getLabel("eMR.DiagnosisGroupCode.label","MR"), f_query_add_mod.document.repDiagGroup.p_fm_diag_code,f_query_add_mod.document.repDiagGroup.p_to_diag_code, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.speciality.label","Common"), f_query_add_mod.document.repDiagGroup.p_fm_sp_code,f_query_add_mod.document.repDiagGroup.p_to_sp_code, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.facility.label","Common"), f_query_add_mod.document.repDiagGroup.p_fm_fac_id,f_query_add_mod.document.repDiagGroup.p_to_fac_id, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.practitioner.label","Common"), f_query_add_mod.document.repDiagGroup.p_fm_pract_id,f_query_add_mod.document.repDiagGroup.p_to_pract_id, messageFrame )  )
	f_query_add_mod.document.repDiagGroup.submit() ;
}

if(f_query_add_mod.document.repGroupDetail)
{
if( f_query_add_mod.CheckString(getLabel("eMR.DiagGroup.label","MR"), f_query_add_mod.document.repGroupDetail.p_fm_diag_code,f_query_add_mod.document.repGroupDetail.p_to_diag_code, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.speciality.label","Common"), f_query_add_mod.document.repGroupDetail.p_fm_icd_code,f_query_add_mod.document.repGroupDetail.p_to_icd_code, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.speciality.label","Common"), f_query_add_mod.document.repGroupDetail.p_fm_sp_code,f_query_add_mod.document.repGroupDetail.p_to_sp_code, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.FacilityID.label","Common"), f_query_add_mod.document.repGroupDetail.p_fm_fac_id,f_query_add_mod.document.repGroupDetail.p_to_fac_id, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.practitioner.label","Common"), f_query_add_mod.document.repGroupDetail.p_fm_pract_id,f_query_add_mod.document.repGroupDetail.p_to_pract_id, messageFrame )  )
	f_query_add_mod.document.repGroupDetail.submit() ;
}

if(f_query_add_mod.document.repICDForTablist)
{
if( f_query_add_mod.CheckString(getLabel("eMR.TabulationList.label","MR"), f_query_add_mod.document.repICDForTablist.p_fm_tab_list,f_query_add_mod.document.repICDForTablist.p_to_tab_list, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.ICDCode.label","Common"), f_query_add_mod.document.repICDForTablist.p_fm_icd_code,f_query_add_mod.document.repICDForTablist.p_to_icd_code, messageFrame )  )
	f_query_add_mod.document.repICDForTablist.submit() ;
}


}//e.o.run

//added from repallegrytype.jsp

async function searchCodeAllergyType(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="allergyclass")
			{
				tit=getLabel("Common.AllergyClass.label","Common");
				//sql="select clinic_code, short_desc from op_clinic ";
				//sql="select ALLERGY_TYPE_CODE,short_desc from MR_ALLERGY_TYPE";
				sql="select ALLERGY_TYPE_CODE,short_desc from MR_ALLERGY_TYPE_lang_vw where language_id=`"+localeName+"`";
				search_code="ALLERGY_TYPE_CODE";
				search_desc= "short_desc"
			}
			
			if(obj.name=="allergyclass1")
			{
				tit=getLabel("Common.AllergyClass.label","Common");
				//sql="select clinic_code, short_desc from op_clinic where FACILITY_ID="+facility;
				//sql="select ALLERGY_TYPE_CODE,short_desc from MR_ALLERGY_TYPE";
				sql="select ALLERGY_TYPE_CODE,short_desc from MR_ALLERGY_TYPE_lang_vw where language_id=`"+localeName+"`";
				search_code="ALLERGY_TYPE_CODE";
				search_desc= "short_desc"
			}

			if(obj.name=="allergytype")
			{
				tit=getLabel("Common.AllergyType.label","Common");
				sql="select ALLERGY_TYPE_CODE,short_desc from MR_ALLERGY_TYPE_lang_vw where language_id=`"+localeName+"`" ;
				search_code="ALLERGY_TYPE_CODE";
				search_desc= "short_desc"
			}
			
			if(obj.name=="allergytype1")
			{
				tit=getLabel("Common.AllergyType.label","Common");
				//sql="select ALLERGY_TYPE_CODE,short_desc from MR_ALLERGY_TYPE";
				sql="select ALLERGY_TYPE_CODE,short_desc from MR_ALLERGY_TYPE_lang_vw where language_id=`"+localeName+"`";
				search_code="ALLERGY_TYPE_CODE";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

// added from repbloodgroup.jsp

async function searchCodeBloodGroup(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="locn")
			{
				tit=getLabel("Common.bloodgroup.label","Common");
				//sql="select clinic_code, short_desc from op_clinic ";
				//sql="select BLOOD_GRP,short_desc from MR_BLOOD_GRP";
				sql="select BLOOD_GRP,short_desc from MR_BLOOD_GRP_lang_vw where language_id=`"+localeName+"`";
				search_code="BLOOD_GRP";
				search_desc= "short_desc"
			}

			if(obj.name=="locn1")
			{
				tit=getLabel("Common.bloodgroup.label","Common");
				//sql="select clinic_code, short_desc from op_clinic where FACILITY_ID="+facility;
				//sql="select BLOOD_GRP,short_desc from MR_BLOOD_GRP";
				sql="select BLOOD_GRP,short_desc from MR_BLOOD_GRP_lang_vw where language_id=`"+localeName+"`"; 
				search_code="BLOOD_GRP";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
			target.focus();
	}

//added from rephighrisk.jsp

async function searchCodeRepHighRisk(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="locn")
			{
				tit=getLabel("Common.HighRisk.label","Common");
				//sql="select clinic_code, short_desc from op_clinic ";
				//sql="select HIGH_RISK_CODE,short_desc from MR_HIGH_RISK";
				sql="select HIGH_RISK_CODE,short_desc from MR_HIGH_RISK_lang_vw where language_id=`"+localeName+"`";
				search_code="HIGH_RISK_CODE";
 				search_desc= "short_desc";
			}

			if(obj.name=="locn1")
			{
				tit=getLabel("Common.HighRisk.label","Common");
				//sql="select clinic_code, short_desc from op_clinic where FACILITY_ID="+facility;
				//sql="select HIGH_RISK_CODE,short_desc from MR_HIGH_RISK";
				sql="select HIGH_RISK_CODE,short_desc from MR_HIGH_RISK_lang_vw where language_id=`"+localeName+"`";
				search_code="HIGH_RISK_CODE";
				search_desc= "short_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
			target.focus();
	}

//added from repicdcode.jsp

async function searchCodeICDCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="locn")
			{
				tit=getLabel("Common.ICDCode.label","Common");
				//sql="select TAB_LIST_NO,short_desc from MR_TAB_LIST";
				sql="select TAB_LIST_NO,short_desc from MR_TAB_LIST_lang_vw where language_id=`"+localeName+"`";
				search_code="TAB_LIST_NO";
 				search_desc= "short_desc";
			}

			if(obj.name=="locn1")
			{
				tit=getLabel("Common.ICDCode.label","Common");

				sql="select DIAG_CODE,short_desc from MR_ICD_CODE";
				search_code="DIAG_CODE";
				search_desc= "short_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
			target.focus();
	}

// added from repicdcodfortablist.jsp
async function searchCodeICDCodeForTabList(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			if(target.name == 'p_fm_tab_list' || target.name == 'p_to_tab_list')
			{
			tit=getLabel("eMR.TabulationList.label","MR");
			//sql="select tab_list_no,long_desc from mr_tab_list  ";
			sql="select tab_list_no,long_desc from mr_tab_list_lang_vw where language_id=`"+localeName+"`";
			search_code="tab_list_no";
			search_desc= "long_desc"
			}
			else
			if(target.name == 'p_fm_icd_code' || target.name == 'p_to_icd_code')
			{
			tit=getLabel("Common.ICDCode.label","Common");
			sql="select diag_code,short_desc   from mr_icd_code ";
			search_code="diag_code";
			search_desc= "short_desc";			
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
 function ValidString(event)
{
	if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)))
	{
		return true
	}
	else
	{	
		return false
	}
}

 
// added from repMedEventType.jsp

async function searchCodeMedEventType(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			tit=getLabel("Common.EventType.label","Common");
			//sql="select MED_EVENT_TYPE_CODE,short_desc from mr_med_event_type ";
			sql="select MED_EVENT_TYPE_CODE,short_desc from mr_med_event_type_lang_vw where language_id=`"+localeName+"`"; 
			search_code="MED_EVENT_TYPE_CODE";
			search_desc= "short_desc"
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

//added from reprhesusfactor.jsp
async function searchCodeRhesusfactor(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="locn")
			{
				tit=getLabel("eMR.RhesusFactor.label","MR");
				
				//sql="select RHESUS_FACTOR_CODE,short_desc from MR_RHESUS_FACTOR";
				sql="select RHESUS_FACTOR_CODE,short_desc from MR_RHESUS_FACTOR_lang_vw where language_id=`"+localeName+"`";
				search_code="RHESUS_FACTOR_CODE";       
 				search_desc= "short_desc";
			}
			
			if(obj.name=="locn1")
			{
				tit=getLabel("eMR.RhesusFactor.label","MR");
				
				//sql="select RHESUS_FACTOR_CODE,short_desc from MR_RHESUS_FACTOR";
				sql="select RHESUS_FACTOR_CODE,short_desc from MR_RHESUS_FACTOR_lang_vw where language_id=`"+localeName+"`";
				search_code="RHESUS_FACTOR_CODE";
				search_desc= "short_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
			target.focus();
	}

//added by reptabulationlist.jsp

async function searchCodeTabulationList(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="locn")
			{
				tit=getLabel("eMR.TabulationListCode.label","MR");
				//sql="select TAB_LIST_NO,short_desc from MR_TAB_LIST";
				sql="select TAB_LIST_NO,short_desc from MR_TAB_LIST_lang_vw where language_id=`"+localeName+"`";
				search_code="TAB_LIST_NO";
 				search_desc= "short_desc";
			}

			if(obj.name=="locn1")
			{
				tit=getLabel("eMR.TabulationListCode.label","MR");

				//sql="select TAB_LIST_NO,short_desc from MR_TAB_LIST";
				sql="select TAB_LIST_NO,short_desc from MR_TAB_LIST_lang_vw where language_id=`"+localeName+"`";
				search_code="TAB_LIST_NO";
				search_desc= "short_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
			target.focus();
	}


//added from repaccessright.jsp

async function searchCodeAccessRight(obj,target)
	{
			
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="locn1")
			{
				tit=getLabel("Common.FacilityID.label","Common");
				//sql="select FACILITY_ID ,FACILITY_NAME from sm_facility_param";
				sql="select FACILITY_ID ,FACILITY_NAME from sm_facility_param_lang_vw where language_id=`"+localeName+"`";
				search_code="FACILITY_ID";       
 				search_desc= "FACILITY_NAME";
			}
			
			if(obj.name=="locn2")
			{
				tit=getLabel("Common.userid.label","Common");
				//sql="select  APPL_USER_ID, APPL_USER_NAME  from sm_appl_user";
				sql="select  APPL_USER_ID, APPL_USER_NAME  from sm_appl_user_lang_vw where language_id=`"+localeName+"`";
				search_code="APPL_USER_ID";       
				search_desc= "APPL_USER_NAME";
			}
			
			
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
			target.focus();
	}


