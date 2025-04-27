function reset() {
	
	if(f_query_add_mod.document.repNameSuffixList){
	f_query_add_mod.document.repNameSuffixList.reset() ;
	}
	if(f_query_add_mod.document.repNamePrefixList){
	f_query_add_mod.document.repNamePrefixList.reset() ;
	}
	if(f_query_add_mod.document.repAltIdTypeList){
	f_query_add_mod.document.repAltIdTypeList.reset() ;
	}
	if(f_query_add_mod.document.repReligionList){
	f_query_add_mod.document.repReligionList.reset() ;
	}
	if(f_query_add_mod.document.repPatCatList){
	f_query_add_mod.document.repPatCatList.reset() ;
	}
	if(f_query_add_mod.document.repMaritalStatusList){
		f_query_add_mod.document.repMaritalStatusList.reset() ;
	}
	if(f_query_add_mod.document.repPostalcodeList){
		f_query_add_mod.document.repPostalcodeList.reset() ;
	}
	if(f_query_add_mod.document.repReasonforSuspList){
		f_query_add_mod.document.repReasonforSuspList.reset() ;
	}
	if(f_query_add_mod.document.repContactModeList){
			f_query_add_mod.document.repContactModeList.reset() ;
	}
	
	if(f_query_add_mod.document.repCountryList){
		f_query_add_mod.document.repCountryList.reset();
	}
	
	if(f_query_add_mod.document.repRelationshipList){
		f_query_add_mod.document.repRelationshipList.reset();
	}
	if(f_query_add_mod.document.repOcpnClassList){
			f_query_add_mod.document.repOcpnClassList.reset();
	}
	
	if(f_query_add_mod.document.repOcpnList){
		f_query_add_mod.document.repOcpnList.reset();
	}
	
	if(f_query_add_mod.document.repRegionList){
	f_query_add_mod.document.repRegionList.reset();
	}
	
	if(f_query_add_mod.document.repAreaList){
	f_query_add_mod.document.repAreaList.reset();
	}
	
	if(f_query_add_mod.document.repTownList){
	f_query_add_mod.document.repTownList.reset();
	}

	if(f_query_add_mod.document.repChkDgtScheme){
	f_query_add_mod.document.repChkDgtScheme.reset();
	}

	if(f_query_add_mod.document.repDocumentType){
	f_query_add_mod.document.repDocumentType.reset();
	}

	if(f_query_add_mod.document.repEduLevel){
	f_query_add_mod.document.repEduLevel.reset();
	}

	if(f_query_add_mod.document.repNODType){
	f_query_add_mod.document.repNODType.reset();
	}

	if(f_query_add_mod.document.repActInact){
	f_query_add_mod.document.repActInact.reset();
	}

	if(f_query_add_mod.document.repSTDFamilyName){
	f_query_add_mod.document.repSTDFamilyName.reset();
	}


	if(f_query_add_mod.document.repSTDOtherName){
	f_query_add_mod.document.repSTDOtherName.reset();
	}
//Code added on July16 starts
	if(f_query_add_mod.document.repBirthPlace){
	f_query_add_mod.document.repBirthPlace.reset();
	}

	if(f_query_add_mod.document.repComplnDelivery){
	f_query_add_mod.document.repComplnDelivery.reset();
	}

	if(f_query_add_mod.document.repCongenitalAnomalies){
	f_query_add_mod.document.repCongenitalAnomalies.reset();
	}

	if(f_query_add_mod.document.repEthnicGroup){
	f_query_add_mod.document.repEthnicGroup.reset();
	}

	if(f_query_add_mod.document.repRacecodeList){
	f_query_add_mod.document.repRacecodeList.reset();
	}

	if(f_query_add_mod.document.repEthnicSubGroup){
	f_query_add_mod.document.repEthnicSubGroup.reset();
	}
//Code added on July16 ends
	//Added on 5/04/2004 by Sen.
	if(f_query_add_mod.document.repDeliveryIndication){
	f_query_add_mod.document.repDeliveryIndication.reset();
	}
	if(f_query_add_mod.document.repDelySurgClass){
	f_query_add_mod.document.repDelySurgClass.reset();
	}
	if(f_query_add_mod.document.repProcClass){
	f_query_add_mod.document.repProcClass.reset();
	}
	if(f_query_add_mod.document.repVagDlyType){
	f_query_add_mod.document.repVagDlyType.reset();
	}



}//e.o.reset

function run() 
{

if(f_query_add_mod.document.repNameSuffixList){

if( f_query_add_mod.CheckString( getLabel('Common.NameSuffix.label','common'), f_query_add_mod.document.repNameSuffixList.p_fm_name_suffix,f_query_add_mod.document.repNameSuffixList.p_to_name_suffix, messageFrame )  ) {
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
f_query_add_mod.document.repNameSuffixList.submit() ; }

}
else
if(f_query_add_mod.document.repNamePrefixList){
if( f_query_add_mod.CheckString( getLabel('Common.NameSuffix.label','common'), f_query_add_mod.document.repNamePrefixList.p_fm_name_prefix,f_query_add_mod.document.repNamePrefixList.p_to_name_prefix, messageFrame )  )	{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repNamePrefixList.submit() ; }
	}

else
if(f_query_add_mod.document.repAltIdTypeList){
if( f_query_add_mod.CheckString( getLabel('Common.AlternateID.label','common'), f_query_add_mod.document.repAltIdTypeList.p_from_idtype,f_query_add_mod.document.repAltIdTypeList.p_to_idtype, messageFrame )  ) {
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    	f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.repAltIdTypeList.submit() ; }
}
else
if(f_query_add_mod.document.repReligionList){
if( f_query_add_mod.CheckString( getLabel('Common.ReligionCode.label','common'), f_query_add_mod.document.repReligionList.p_from_relgn_code,f_query_add_mod.document.repReligionList.p_to_relgn_code, messageFrame ) ) {
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	f_query_add_mod.document.forms[0].target="messageFrame";
f_query_add_mod.document.repReligionList.submit() ; }

}

else
if(f_query_add_mod.document.repPatCatList){
if( f_query_add_mod.CheckString(getLabel('Common.category.label','common')+" "+ getLabel('Common.code.label','common'), f_query_add_mod.document.repPatCatList.p_from_catcode,f_query_add_mod.document.repPatCatList.p_to_catcode, messageFrame ) ) {
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repPatCatList.submit() ;
}

}

else
if(f_query_add_mod.document.repMaritalStatusList){
if( f_query_add_mod.CheckString( getLabel('eMP.MaritalStatusCode.label','MP'), f_query_add_mod.document.repMaritalStatusList.p_fm_mar_status_code,f_query_add_mod.document.repMaritalStatusList.p_to_mar_status_code, messageFrame ) )
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";	
	f_query_add_mod.document.repMaritalStatusList.submit() ;
}
	
}

else
if(f_query_add_mod.document.repPostalcodeList){
if( f_query_add_mod.CheckString( getLabel('eMP.postalcode.label','MP'), f_query_add_mod.document.repPostalcodeList.p_fm_postal_code,f_query_add_mod.document.repPostalcodeList.p_to_postal_code, messageFrame ) ) 
if( f_query_add_mod.CheckString( getLabel('Common.TownCode.label','common'), f_query_add_mod.document.repPostalcodeList.p_from_res_town_code,f_query_add_mod.document.repPostalcodeList.p_to_res_town_code, messageFrame ) )
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";	
	f_query_add_mod.document.repPostalcodeList.submit() ; }
	
}
else
if(f_query_add_mod.document.repReasonforSuspList){
if( f_query_add_mod.CheckString(getLabel('Common.ReasonCode.label','common') , f_query_add_mod.document.repReasonforSuspList.p_from_reacode,f_query_add_mod.document.repReasonforSuspList.p_to_reacode, messageFrame ) ) 
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repReasonforSuspList.submit() ; }
	
}
else
if(f_query_add_mod.document.repContactModeList){
if( f_query_add_mod.CheckString( getLabel('eMP.ContactModes.label','MP') , f_query_add_mod.document.repContactModeList.p_from_conmode,f_query_add_mod.document.repContactModeList.p_to_conmode, messageFrame ) ) 
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repContactModeList.submit() ;
}	
}

else
if(f_query_add_mod.document.repCountryList){
if( f_query_add_mod.CheckString(getLabel('Common.country.label','common')+" "+ getLabel('Common.code.label','common'), f_query_add_mod.document.repCountryList.p_fm_country_code,f_query_add_mod.document.repCountryList.p_to_country_code, messageFrame ) ) 
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repCountryList.submit() ; }
	
}
else
if(f_query_add_mod.document.repRelationshipList){
if( f_query_add_mod.CheckString(getLabel('eMP.RelationshipCode.label','MP'), f_query_add_mod.document.repRelationshipList.p_from_relcode,f_query_add_mod.document.repRelationshipList.p_to_relcode, messageFrame ) ) 
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repRelationshipList.submit() ; }
	
}
else
if(f_query_add_mod.document.repOcpnClassList){
if( f_query_add_mod.CheckString(getLabel('eMP.OccupationClassCode.label','MP'), f_query_add_mod.document.repOcpnClassList.p_from_occpn_class_code,f_query_add_mod.document.repOcpnClassList.p_to_occpn_class_code, messageFrame ) )
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";	
	f_query_add_mod.document.repOcpnClassList.submit() ;
}
}

else
if(f_query_add_mod.document.repOcpnList){
if( f_query_add_mod.CheckString( getLabel('eMP.occupation.label','MP')+ " " + getLabel('Common.code.label','common'), f_query_add_mod.document.repOcpnList.p_from_occpn_class_code,f_query_add_mod.document.repOcpnList.p_to_occpn_class_code, messageFrame ) )
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";	
	f_query_add_mod.document.repOcpnList.submit() ;
}
}

else
if(f_query_add_mod.document.repRegionList){
if( f_query_add_mod.CheckString(getLabel('eMP.Regioncode.label','MP'), f_query_add_mod.document.repRegionList.p_from_regn_code,f_query_add_mod.document.repRegionList.p_to_regn_code, messageFrame ) )
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";	
	f_query_add_mod.document.repRegionList.submit() ;
}
}

else
if(f_query_add_mod.document.repAreaList){
if( f_query_add_mod.CheckString(getLabel('eMP.Regioncode.label','MP'), f_query_add_mod.document.repAreaList.p_from_regn_code,f_query_add_mod.document.repAreaList.p_to_regn_code, messageFrame ) ) {
if( f_query_add_mod.CheckString(getLabel('Common.AreaCode.label','common') , f_query_add_mod.document.repAreaList.p_from_res_area_code,f_query_add_mod.document.repAreaList.p_to_res_area_code, messageFrame ) ) 
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repAreaList.submit() ;
}	
	}

}
else
if (f_query_add_mod.document.repRacecodeList)
	{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repRacecodeList.submit();
	}
else
if(f_query_add_mod.document.repTownList){
if( f_query_add_mod.CheckString(getLabel('eMP.Regioncode.label','MP'), f_query_add_mod.document.repTownList.p_from_regn_code,f_query_add_mod.document.repTownList.p_to_regn_code, messageFrame ) ) {
if( f_query_add_mod.CheckString(getLabel('Common.AreaCode.label','common'), f_query_add_mod.document.repTownList.p_from_res_area_code,f_query_add_mod.document.repTownList.p_to_res_area_code, messageFrame ) ) 
if( f_query_add_mod.CheckString( getLabel('Common.TownCode.label','common'), f_query_add_mod.document.repTownList.p_from_res_town_code,f_query_add_mod.document.repTownList.p_to_res_town_code, messageFrame ) )
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame"; 	
	f_query_add_mod.document.repTownList.submit() ;
}
	}
}

else
if(f_query_add_mod.document.repNODType){
if( f_query_add_mod.CheckString( getLabel('eMP.NODType.label','MP'), f_query_add_mod.document.repNODType.p_fm_nod_type_code,f_query_add_mod.document.repNODType.p_to_nod_type_code, messageFrame ) ) {
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repNODType.submit() ;
}
}

else
if(f_query_add_mod.document.repSTDFamilyName){
if( f_query_add_mod.CheckString( getLabel('Common.FamilyName.label','common'), f_query_add_mod.document.repSTDFamilyName.p_fm_last_name,f_query_add_mod.document.repSTDFamilyName.p_to_last_name, messageFrame ) ) {
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repSTDFamilyName.submit() ;
}
}


else
if(f_query_add_mod.document.repSTDOtherName){
if( f_query_add_mod.CheckString( getLabel('eMP.OtherName.label','MP'), f_query_add_mod.document.repSTDOtherName.p_fm_other_name,f_query_add_mod.document.repSTDOtherName.p_to_other_name, messageFrame ) ) {
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repSTDOtherName.submit() ;
}
}

else
if(f_query_add_mod.document.repDocumentType){
if( f_query_add_mod.CheckString( getLabel('Common.documenttype.label','common'), f_query_add_mod.document.repDocumentType.p_fm_doc_type,f_query_add_mod.document.repDocumentType.p_to_doc_type, messageFrame ) ) {
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repDocumentType.submit() ;
}
}

else
if(f_query_add_mod.document.repActInact){
if( f_query_add_mod.CheckString(getLabel('Common.documenttype.label','common') , f_query_add_mod.document.repActInact.p_fm_reason_code,f_query_add_mod.document.repActInact.p_to_reason_code, messageFrame ) ) {
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repActInact.submit() ;
}
}

else
if(f_query_add_mod.document.repChkDgtScheme){
if( f_query_add_mod.CheckString( getLabel('eMP.CheckDigitScheme.label','MP') , f_query_add_mod.document.repChkDgtScheme.p_fm_scheme_id,f_query_add_mod.document.repChkDgtScheme.p_to_scheme_id, messageFrame ) ) {
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repChkDgtScheme.submit() ;
}
}

else
if(f_query_add_mod.document.repEduLevel){
if( f_query_add_mod.CheckString( getLabel('eMP.EducationLevel.label','MP'), f_query_add_mod.document.repEduLevel.p_fm_level_code,f_query_add_mod.document.repEduLevel.p_to_level_code, messageFrame ) ) {
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repEduLevel.submit() ;
}
}
///////////////
//Code added on July16 starts
else
if(f_query_add_mod.document.repBirthPlace){
if( f_query_add_mod.CheckString( getLabel('Common.birthPlace.label','common')+" "+ getLabel('Common.code.label','common'), f_query_add_mod.document.repBirthPlace.p_fm_birth_place_code,f_query_add_mod.document.repBirthPlace.p_to_birth_place_code, messageFrame ) ) 
{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repBirthPlace.submit() ;
}
	
}

else
if(f_query_add_mod.document.repComplnDelivery){
if( f_query_add_mod.CheckString(getLabel('eMP.CompofDelivery.label','MP')+" " + getLabel('Common.code.label','common'), f_query_add_mod.document.repComplnDelivery.p_fm_compln_dely_code,f_query_add_mod.document.repComplnDelivery.p_to_compln_dely_code, messageFrame ) ) 
{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repComplnDelivery.submit() ;
}
	
}

else
if(f_query_add_mod.document.repCongenitalAnomalies){
if( f_query_add_mod.CheckString( getLabel('eMP.CongenitalAnomalies.label','MP')+ " "+getLabel('Common.code.label','common'), f_query_add_mod.document.repCongenitalAnomalies.p_fm_cong_anomalies_code,f_query_add_mod.document.repCongenitalAnomalies.p_to_cong_anomalies_code, messageFrame ) ) 
{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repCongenitalAnomalies.submit() ;
}
}


else
if(f_query_add_mod.document.repEthnicGroup){
if( f_query_add_mod.CheckString(getLabel('eMP.EthnicGroupCode.label','MP'), f_query_add_mod.document.repEthnicGroup.p_from_ethnic_group_code,f_query_add_mod.document.repEthnicGroup.p_to_ethnic_group_code, messageFrame ) ) {
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repEthnicGroup.submit() ;
}
	
}

else if(f_query_add_mod.document.repEthnicSubGroup)
{
	if( f_query_add_mod.CheckString(getLabel('eMP.EthnicGroupCode.label','MP'), f_query_add_mod.document.repEthnicSubGroup.p_from_ethnic_group_code,f_query_add_mod.document.repEthnicSubGroup.p_to_ethnic_group_code, messageFrame ) ) 
	{
		if( f_query_add_mod.CheckString( getLabel('eMP.EthnicSubGroupCode.label','MP'), f_query_add_mod.document.repEthnicSubGroup.p_from_ethnic_group_code,f_query_add_mod.document.repEthnicSubGroup.p_to_ethnic_group_code, messageFrame ) ) {
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.repEthnicSubGroup.submit() ; }
	}	
}
//Code added on July16 ends
//Added on 04/04/2005 by Sen
else
if(f_query_add_mod.document.repDeliveryIndication){
if( f_query_add_mod.CheckString( getLabel('eMP.DeliveryIndication.label','MP')+" "+getLabel('Common.code.label','common'), f_query_add_mod.document.repDeliveryIndication.p_fm_dely_ind_code,f_query_add_mod.document.repDeliveryIndication.p_to_dely_ind_code, messageFrame ) ) {
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
f_query_add_mod.document.repDeliveryIndication.submit() ; 
}
	
}
else
if(f_query_add_mod.document.repDelySurgClass){
if( f_query_add_mod.CheckString( getLabel('eMP.DeliverySurgicalClassification.label','MP')+" "+getLabel('Common.code.label','common') , f_query_add_mod.document.repDelySurgClass.p_fm_surg_code,f_query_add_mod.document.repDelySurgClass.p_to_surg_code, messageFrame ) ) {
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repDelySurgClass.submit() ;
}
	
}
else
if(f_query_add_mod.document.repProcClass){
if( f_query_add_mod.CheckString( getLabel('eMP.ProcedureClassificationCode.label','MP'), f_query_add_mod.document.repProcClass.p_fm_proc_code,f_query_add_mod.document.repProcClass.p_to_proc_code, messageFrame ) ) {
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repProcClass.submit() ;
}
}
else
if(f_query_add_mod.document.repVagDlyType){
if( f_query_add_mod.CheckString( getLabel('eMP.VaginalDeliveryTypeCode.label','MP'), f_query_add_mod.document.repVagDlyType.p_fm_vag_dely_type,f_query_add_mod.document.repVagDlyType.p_to_vag_dely_type, messageFrame ) ) {
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repVagDlyType.submit() ;
}
}
//end of adition on 05/04/2004

}//e.o.run