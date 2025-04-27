function reset() {
	
/*repMortuaryAreaList
repBodyConditionList
repMannerOfDeathList
repClaimantTypeList
repConsentFormList
*/


	if(f_query_add_mod.document.repMortuaryAreaList){
	   f_query_add_mod.document.repMortuaryAreaList.reset() ;
	}
	if(f_query_add_mod.document.repBodyConditionList){
	   f_query_add_mod.document.repBodyConditionList.reset() ;
	}
	if(f_query_add_mod.document.repMannerOfDeathList){
	   f_query_add_mod.document.repMannerOfDeathList.reset() ;
	}
	if(f_query_add_mod.document.repClaimantTypeList){
	   f_query_add_mod.document.repClaimantTypeList.reset() ;
	}
	if(f_query_add_mod.document.repConsentFormList){
	   f_query_add_mod.document.repConsentFormList.reset() ;
	}
    if(f_query_add_mod.document.repBedforArea){
	   f_query_add_mod.document.repBedforArea.reset() ;
	}
	if(f_query_add_mod.document.repOrgansForDonationList){
	   f_query_add_mod.document.repOrgansForDonationList.reset() ;
	}
	
}//e.o.reset

function run() 
{

if(f_query_add_mod.document.repMortuaryAreaList){
if( f_query_add_mod.CheckString(getLabel("Common.AreaCode.label","Common"), f_query_add_mod.document.repMortuaryAreaList.p_fm_area_code,f_query_add_mod.document.repMortuaryAreaList.p_to_area_code, messageFrame ) ) 
	f_query_add_mod.document.repMortuaryAreaList.submit() ;	

}
else
if(f_query_add_mod.document.repBodyConditionList){
if( f_query_add_mod.CheckString(getLabel("eMO.BodyConditionCode.label","MO"), f_query_add_mod.document.repBodyConditionList.p_fm_body_cond_code,f_query_add_mod.document.repBodyConditionList.p_to_body_cond_code, messageFrame ) ) 
	f_query_add_mod.document.repBodyConditionList.submit() ;	
}
else
if(f_query_add_mod.document.repMannerOfDeathList){
if( f_query_add_mod.CheckString(getLabel("eMO.MannerOfDeathCode.label","MO"), f_query_add_mod.document.repMannerOfDeathList.p_fm_death_code,f_query_add_mod.document.repMannerOfDeathList.p_to_death_code, messageFrame ) ) 
	f_query_add_mod.document.repMannerOfDeathList.submit() ;	
}
else
if(f_query_add_mod.document.repClaimantTypeList){
if( f_query_add_mod.CheckString(getLabel("eMO.ClaimantCode.label","MO"),  f_query_add_mod.document.repClaimantTypeList.p_fm_claimant_code,f_query_add_mod.document.repClaimantTypeList.p_to_claimant_code, messageFrame ) ) 
	f_query_add_mod.document.repClaimantTypeList.submit() ;	
}
else
if(f_query_add_mod.document.repConsentFormList){
if( f_query_add_mod.CheckString(getLabel("eMO.ConsentCode.label","MO"),  f_query_add_mod.document.repConsentFormList.p_fm_consent_code,f_query_add_mod.document.repConsentFormList.p_to_consent_code, messageFrame ) ) 
f_query_add_mod.document.repConsentFormList.submit() ;
}
else
if(f_query_add_mod.document.repBodyTag){
if( f_query_add_mod.CheckString(getLabel("eMO.ConsentCode.label","MO"), f_query_add_mod.document.repConsentFormList.p_fm_consent_code,f_query_add_mod.document.repConsentFormList.p_to_consent_code, messageFrame ) ) 
f_query_add_mod.document.repConsentFormList.submit() ;
}
else
if(f_query_add_mod.document.repBedforArea){
if( f_query_add_mod.CheckString(getLabel("Common.AreaCode.label","Common"), f_query_add_mod.document.repBedforArea.p_fm_bed_area_code,f_query_add_mod.document.repBedforArea.p_to_bed_area_code, messageFrame ) ) 
f_query_add_mod.document.repBedforArea.submit() ;
}
else
if(f_query_add_mod.document.repOrgansForDonationList){
if( f_query_add_mod.CheckString(getLabel("eMO.OrganforDonation.label","MO"), f_query_add_mod.document.repOrgansForDonationList.p_fm_organ_code,f_query_add_mod.document.repOrgansForDonationList.p_to_organ_code, messageFrame ) ) 
f_query_add_mod.document.repOrgansForDonationList.submit() ;
}
//---------------------------------

}//e.o.run

function validSplchars(obj,name)
{				
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]=name;									
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

async function searchCode(obj,target)
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
		 
			var facility_id = document.forms[0].p_facility_id.value;
			if(obj.name=="mortuary type")
			{
				tit= getLabel("eMO.AreaType.label","MO");
				//tit= "Area Type";
				//sql="select area_code ,short_desc from mo_area	";
				sql="select area_code ,short_desc from MO_AREA_LANG_VW where facility_id = `"+facility_id+"` and language_id=`"+localeName+"` ";
				search_code="area_code";
				search_desc= "short_desc";
			}
			if(obj.name=="Bed Code")
			{
				tit= getLabel("Common.AreaCode.label","Common");
				//tit = "Area Code";
				//sql="select area_code, short_desc from MO_AREA";
				sql="select area_code ,short_desc from MO_AREA_LANG_VW where facility_id = `"+facility_id+"` and language_id=`"+localeName+"` ";
				search_code="area_code";
				search_desc= "short_desc";
			}
			
			if(obj.name=="body part type")
			{
				tit = getLabel("Common.BodyPart.label","Common"); 
				//sql="select BODY_PART_CODE ,short_desc from MO_BODY_PART";
				sql="select BODY_PART_CODE ,short_desc from MO_BODY_PART_LANG_VW where LANGUAGE_ID=`"+localeName+"` ";
				search_code="BODY_PART_CODE";
				search_desc= "short_desc";
			}

			if(obj.name=="organ for donation")
			{
				tit= getLabel("eMO.OrganforDonation.label","MO");  
				//sql="select ORGAN_CODE ,short_desc from MO_ORGAN_FOR_DONATION ";
				sql="select ORGAN_CODE ,short_desc from MO_ORGAN_FOR_DONATION_LANG_VW where LANGUAGE_ID=`"+localeName+"` ";
				search_code="ORGAN_CODE";
				search_desc= "short_desc";
			}

			if(obj.name=="body condition type")
			{
				//tit="Body Condition Type";
				tit= getLabel("eMO.BodyConditionType.label","MO"); 
				//sql="select body_cond_code ,short_desc from mo_body_condition";
				sql="select body_cond_code ,short_desc from MO_BODY_CONDITION_LANG_VW where LANGUAGE_ID=`"+localeName+"` ";
				search_code="body_cond_code";
				search_desc= "short_desc";
			}
			if(obj.name=="manner of death type")
			{
				//tit="Manner Of Death Type";
				tit= getLabel("eMO.MannerOfDeathType.label","MO"); 				
				//sql="select DEATH_MANNER_CODE  ,short_desc from mo_manner_of_death";
				sql="select DEATH_MANNER_CODE  ,short_desc from MO_MANNER_OF_DEATH_LANG_VW where LANGUAGE_ID=`"+localeName+"` ";
				search_code="DEATH_MANNER_CODE";
				search_desc= "short_desc";
			}
			if(obj.name=="claimant type")
			{
				//tit="Claimant Type";
				tit= getLabel("eMO.ClaimantType.label","MO"); 				
				//sql="select claimant_type_code, short_desc from mo_claimant_type";
				sql="select claimant_type_code, short_desc from MO_CLAIMANT_TYPE_LANG_VW where LANGUAGE_ID=`"+localeName+"` ";
				search_code="claimant_type_code";
				search_desc= "short_desc";
			}
			if(obj.name=="consent type")
			{
				//tit="Consent Type";
				tit= getLabel("Common.ConsentType.label","Common"); 					
				sql="select consent_form_code, title from mo_consent_form";
				search_code="consent_form_code";
				search_desc= "title";
			}

			//alert('sql:'+sql);
			//alert('search_code:'+search_code);
			//alert('search_desc:'+search_desc);
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

