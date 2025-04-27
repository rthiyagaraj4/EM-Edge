  //saved on 02.11.2005
function loadPage(objVal) {
	if(objVal=="") {
		parent.searchResultFrame.location.href="../../eCommon/html/blank.html";
	}
	if(objVal==1) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepATClassification.jsp";
	}
	if(objVal==5) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepAdminRoute.jsp";
	}
	if(objVal==6) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepAppFormRoute.jsp";
	}
	if(objVal==7) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepAppFormUOM.jsp";
	}
	if(objVal==10) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepAssoDrugRules.jsp";
	}
	if(objVal==15) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepDiscontinuedDrugs.jsp";
	}
	if(objVal==9) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepDrugCategory.jsp";
	}
	if(objVal==14) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepDrugDoseLimit.jsp";
	}
	if(objVal==13) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepDrugList.jsp";
	}
	if(objVal==8) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepDrugSchedule.jsp";
	}
	if(objVal==4) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepFormOfDrug.jsp";
	}
	if(objVal==2) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepGenericName.jsp";
	}
	if(objVal==3) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepGenericNameByService.jsp";
	}
	if(objVal==11) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepOrdTypeForDrugClass.jsp";
	}
	if(objVal==12) {
		parent.searchResultFrame.location.href="../../ePH/jsp/PHRepPresRemarks.jsp";
	}
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}

function run() {
	var code1=getLabel("Common.code.label","Common")+" 1";
	var code2=getLabel("Common.code.label","Common")+" 2";
	var code3=getLabel("Common.code.label","Common")+" 3";
	var code4=getLabel("Common.code.label","Common")+" 4";
	var code5=getLabel("Common.code.label","Common")+" 5";
	
	if(searchResultFrame.document.formPHRepATClassification) {
		if(CheckString(code1,searchResultFrame.document.formPHRepATClassification.p_from_atcl1, searchResultFrame.document.formPHRepATClassification.p_to_atcl1, messageFrame) ) {
			if(CheckString(code2, searchResultFrame.document.formPHRepATClassification.p_from_atcl2, searchResultFrame.document.formPHRepATClassification.p_to_atcl2, messageFrame) ) {
				if(CheckString(code3, searchResultFrame.document.formPHRepATClassification.p_from_atcl3, searchResultFrame.document.formPHRepATClassification.p_to_atcl3, messageFrame) ) {
					if(CheckString(code4, searchResultFrame.document.formPHRepATClassification.p_from_atcl4, searchResultFrame.document.formPHRepATClassification.p_to_atcl4, messageFrame) ) {
						if(CheckString(code5, searchResultFrame.document.formPHRepATClassification.p_from_atcl5, searchResultFrame.document.formPHRepATClassification.p_to_atcl5, messageFrame) ) {
							searchResultFrame.document.formPHRepATClassification.submit();
						}
					}
				}
			}
		}
	}

	if(searchResultFrame.document.formPHRepAdminRoute) {
//		alert(getLabel("ePH.Route.label","PH"))
		if(CheckString(getLabel("Common.Route.label","Common"), searchResultFrame.document.formPHRepAdminRoute.p_from_rcode, searchResultFrame.document.formPHRepAdminRoute.p_to_rcode, messageFrame) )
			searchResultFrame.document.formPHRepAdminRoute.submit();
	}

	if(searchResultFrame.document.formPHRepAppFormRoute) {
		if(CheckString(getLabel("ePH.Form.label","PH"), searchResultFrame.document.formPHRepAppFormRoute.p_from_fcode, searchResultFrame.document.formPHRepAppFormRoute.p_to_fcode, messageFrame) )
			searchResultFrame.document.formPHRepAppFormRoute.submit();
	}

	if(searchResultFrame.document.formPHRepAppFormUOM) {
		if(CheckString(getLabel("ePH.Form.label","PH"), searchResultFrame.document.formPHRepAppFormUOM.p_from_fcode, searchResultFrame.document.formPHRepAppFormUOM.p_to_fcode, messageFrame) )
			searchResultFrame.document.formPHRepAppFormUOM.submit();
	}

	if(searchResultFrame.document.formPHRepAssoDrugRules) {
		if(CheckString(getLabel("ePH.DrugCategory.label","PH"), searchResultFrame.document.formPHRepAssoDrugRules.p_from_ctgid, searchResultFrame.document.formPHRepAssoDrugRules.p_to_ctgid, messageFrame) )
			searchResultFrame.document.formPHRepAssoDrugRules.submit();
	}

	if(searchResultFrame.document.formPHRepDiscontinuedDrugs) {
		if(CheckString(getLabel("Common.generic.label","Common"), searchResultFrame.document.formPHRepDiscontinuedDrugs.p_from_genid, searchResultFrame.document.formPHRepDiscontinuedDrugs.p_to_genid, messageFrame) ) {
			if(CheckString(getLabel("Common.Drug.label","Common"), searchResultFrame.document.formPHRepDiscontinuedDrugs.p_from_drcd, searchResultFrame.document.formPHRepDiscontinuedDrugs.p_to_drcd, messageFrame) ) {
				if(CheckString(getLabel("ePH.Form.label","PH"), searchResultFrame.document.formPHRepDiscontinuedDrugs.p_from_fcode, searchResultFrame.document.formPHRepDiscontinuedDrugs.p_to_fcode, messageFrame) ) {
					if(CheckString(getLabel("Common.Route.label","Common"), searchResultFrame.document.formPHRepDiscontinuedDrugs.p_from_rcode, searchResultFrame.document.formPHRepDiscontinuedDrugs.p_to_rcode, messageFrame) ) {
						searchResultFrame.document.formPHRepDiscontinuedDrugs.submit();
					}
				}
			}
		}
	}

	if(searchResultFrame.document.formPHRepDrugCategory) {
		if(CheckString(getLabel("ePH.DrugCategory.label","PH"), searchResultFrame.document.formPHRepDrugCategory.p_from_ctgid, searchResultFrame.document.formPHRepDrugCategory.p_to_ctgid, messageFrame) )
			searchResultFrame.document.formPHRepDrugCategory.submit();
	}

	if(searchResultFrame.document.formPHRepDrugDoseLimit) {
		if(CheckString(getLabel("Common.agegroup.label","PH"), searchResultFrame.document.formPHRepDrugDoseLimit.p_from_agcode, searchResultFrame.document.formPHRepDrugDoseLimit.p_to_agcode, messageFrame) ) {
			if(CheckString(getLabel("Common.Drug.label","Common"), searchResultFrame.document.formPHRepDrugDoseLimit.p_from_drcd, searchResultFrame.document.formPHRepDrugDoseLimit.p_to_drcd, messageFrame) ) {
				if(CheckString(getLabel("ePH.Form.label","PH"), searchResultFrame.document.formPHRepDrugDoseLimit.p_from_fcode, searchResultFrame.document.formPHRepDrugDoseLimit.p_to_fcode, messageFrame) ) {
					if(CheckString(getLabel("Common.Route.label","Common"), searchResultFrame.document.formPHRepDrugDoseLimit.p_from_rcode, searchResultFrame.document.formPHRepDrugDoseLimit.p_to_rcode, messageFrame) ) {
						searchResultFrame.document.formPHRepDrugDoseLimit.submit();
					}
				}
			}
		}
	}

	if(searchResultFrame.document.formPHRepDrugList) {
		if(CheckString(getLabel("Common.generic.label","Common"), searchResultFrame.document.formPHRepDrugList.p_from_genid, searchResultFrame.document.formPHRepDrugList.p_to_genid, messageFrame) ) {
			if(CheckString(getLabel("Common.Drug.label","Common"), searchResultFrame.document.formPHRepDrugList.p_from_drcd, searchResultFrame.document.formPHRepDrugList.p_to_drcd, messageFrame) ) {
				if(CheckString(getLabel("ePH.Form.label","PH")+" "+getLabel("Common.code.label","Common"), searchResultFrame.document.formPHRepDrugList.p_from_fcode, searchResultFrame.document.formPHRepDrugList.p_to_fcode, messageFrame) ) {
					if(CheckString(getLabel("Common.Route.label","Common"), searchResultFrame.document.formPHRepDrugList.p_from_rcode, searchResultFrame.document.formPHRepDrugList.p_to_rcode, messageFrame) ) {
						searchResultFrame.document.formPHRepDrugList.submit();
					}
				}
			}
		}
	}

	if(searchResultFrame.document.formPHRepDrugSchedule) {
		if(CheckString(getLabel("ePH.DrugSchedule.label","PH"), searchResultFrame.document.formPHRepDrugSchedule.p_from_schid, searchResultFrame.document.formPHRepDrugSchedule.p_to_schid, messageFrame) )
			searchResultFrame.document.formPHRepDrugSchedule.submit();
	}

	if(searchResultFrame.document.formPHRepFormOfDrug) {
		if(CheckString(getLabel("ePH.Form.label","PH"), searchResultFrame.document.formPHRepFormOfDrug.p_from_fcode, searchResultFrame.document.formPHRepFormOfDrug.p_to_fcode, messageFrame) )
			searchResultFrame.document.formPHRepFormOfDrug.submit();
	}

	if(searchResultFrame.document.formPHRepGenericName) {
		if(CheckString(getLabel("ePH.GenericID.label","PH"), searchResultFrame.document.formPHRepGenericName.p_from_genid, searchResultFrame.document.formPHRepGenericName.p_to_genid, messageFrame) )
			searchResultFrame.document.formPHRepGenericName.submit();
	}

	if(searchResultFrame.document.formPHRepGenericNameByService) {
		if(CheckString(getLabel("Common.ServiceCode.label","Common"), searchResultFrame.document.formPHRepGenericNameByService.p_from_scode, searchResultFrame.document.formPHRepGenericNameByService.p_to_scode, messageFrame) ) {
			
			if(CheckString(getLabel("ePH.GenericID.label","ePH"), searchResultFrame.document.formPHRepGenericNameByService.p_from_genid, searchResultFrame.document.formPHRepGenericNameByService.p_to_genid, messageFrame) ) {
				searchResultFrame.document.formPHRepGenericNameByService.submit();
			}
		}
	}

	if(searchResultFrame.document.formPHRepOrdTypeForDrugClass) {
		if(CheckString(getLabel("ePH.OrderCode.label","PH"), searchResultFrame.document.formPHRepOrdTypeForDrugClass.p_from_otcode, searchResultFrame.document.formPHRepOrdTypeForDrugClass.p_to_otcode, messageFrame) )
			searchResultFrame.document.formPHRepOrdTypeForDrugClass.submit();
	}

	if(searchResultFrame.document.formPHRepPresRemarks) {
		if(CheckString(getLabel("Common.Route.label","Common"), searchResultFrame.document.formPHRepPresRemarks.p_from_rcode, searchResultFrame.document.formPHRepPresRemarks.p_to_rcode, messageFrame) )
			searchResultFrame.document.formPHRepPresRemarks.submit();
	}

}

async function searchCode( frmObj, searchFor, target ) {
	 
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var retArray 		= new Array() ;

	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	
	if (searchFor == "Route") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_ROUTE_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "Form") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_FORM_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "Drug Category") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_DRCTG_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "Drug") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_DRUG_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "Generic ID") {
				var LANGUAGE_ID=frmObj.language_id.value;
		//var LANGUAGE_ID=frmObj.language_id.value+"'";
		//argumentArray[0] = frmObj.SQL_PH_REPORTS_GENID_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[0] ="";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
		
		parNameArray[0] ="~LANGUAGE_ID`";
		parValueArray[0]=LANGUAGE_ID;
		
		argumentArray[12]  = "SQL_PH_REPORTS_GENID_LOOKUP_NEW";
		argumentArray[13]  = "ePH.Common.PhRepository";
		argumentArray[14]  = parNameArray;
		argumentArray[15]  = parValueArray;
	
	}

	if (searchFor == "Age Group") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_AGEDRP_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "Drug Schedule") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_SCHED_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "Service ID") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_SERVICE_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "Order Code") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_ORDER_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "Remark Code") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_REMARK_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "ATC Level1") {
		
		argumentArray[0] = frmObj.SQL_PH_REPORTS_ATC1_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "ATC Level2") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_ATC2_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "ATC Level3") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_ATC3_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "ATC Level4") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_ATC4_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	if (searchFor == "ATC Level5") {
		argumentArray[0] = frmObj.SQL_PH_REPORTS_ATC5_LOOKUP.value+"'"+frmObj.language_id.value+"'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;
	}

	retArray =await CommonLookup( searchFor, argumentArray );
	var str =unescape(retArray).replace('"', ",");
	var arr = str.split(",");

	if(retArray != null && retArray != "" ) {
		target.value = arr[0];	/* if code need to be returned */
		target.focus();
	}
}

function reset() {
	searchFrame.formPHReportsMasterList.reset();
	searchResultFrame.document.location.href='../../eCommon/html/blank.html';
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

async function searchNursingUnit(target){

	var formObj = document.frames.formPHRepPatFillCriteria;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	dataNameArray[0]   = "facility_id" ;
	dataValueArray[0]  = formObj.p_facility_id.value;
	dataTypeArray[0]   = STRING ;

	argumentArray[0]   = formObj.SQL_PH_DISP_MEDICATION_SELECT32.value+"'"+formObj.p_language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	var retVal = await CommonLookup( "Nursing Unit", argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
		if(target.name=="nursing_unit_from") {
			formObj.nunit_from.value = arr[0];
		} else {
			formObj.nunit_to.value = arr[0];
		}
		target.value = arr[1] ;
		target.disabled = true;
	}
}