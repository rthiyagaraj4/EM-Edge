//Opens the respective search dialog for the given code
async function searchCode(obj,target){
	var retVal = 	new String();
	//var dialogHeight = "28" ;
	//var dialogWidth	= "43" ;
	var dialogHeight = "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";

	search_desc= "short_desc";
	switch(obj.name.toLowerCase()){
		case "altid":
			tit=getLabel('eMP.AlternateIDType.label','MP');
			//sql="select alt_id_type,short_desc from mp_alternate_id_type";
			sql="select alt_id_type,long_desc from mp_alternate_id_type_lang_vw where language_id=`"+localeName+"`";
			search_code="alt_id_type";
			break;
		case "birthplace":
			tit=getLabel('Common.birthPlace.label','common');
			//sql="select birth_place_code,short_desc from mp_birth_place";
			sql="select birth_place_code,short_desc from mp_birth_place_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="birth_place_code";
			break;
		case "chkdgtsch":
			tit=getLabel('eMP.CheckDigitScheme.label','MP');
			sql="select scheme_id,scheme_name from mp_check_digit_scheme ";
			search_code="scheme_id";
			search_desc= "scheme_name";
			break;
		case "complndelivery":			
			tit=getLabel('eMP.CompofDelivery.label','MP');
			sql="select compln_dely_code,short_desc from mp_compln_delivery_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="compln_dely_code";
			break;
		case "congenitalanomalies":
			tit=getLabel('eMP.CongenitalAnomalies.label','MP');
			sql="select cong_anomalies_code,short_desc from mp_cong_anomalies_lang_vw  where LANGUAGE_ID=`"+localeName+"`";
			search_code="cong_anomalies_code";
			break;
		case "conmode":
			tit=getLabel('eMP.ContactModes.label','MP');
			sql="select contact_mode, short_desc from mp_contact_mode_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="contact_mode";
			break;
		case "country":
			tit=getLabel('Common.country.label','common');
			sql="select country_code, long_name from mp_country_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="country_code";
			search_desc= "short_name";
			break;
		case "deliveryindication":
			tit=getLabel('eMP.DeliveryIndication.label','MP');
			sql="select dely_ind_code,short_desc from mp_dlvry_indication_lang_vw  where LANGUAGE_ID=`"+localeName+"`";
			search_code="dely_ind_code";
			break;
		case "delysurgclass":
			tit=getLabel('eMP.DeliverySurgicalClassification.label','MP');
			sql="select dely_surg_class_code, short_desc from mp_dely_surg_clfn_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="dely_surg_class_code";
			break;
		case "doctype":
			tit=getLabel('Common.documenttype.label','common');
			sql="select doc_type,short_desc from mp_document_type_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="doc_type";
			break;
		case "edulevel":
			tit=getLabel('eMP.EducationLevel.label','MP');
			sql="select educ_level_code,short_desc from mp_education_level_lang_vw  where LANGUAGE_ID=`"+localeName+"`";
			search_code="educ_level_code";
			break;
		case "ethnicgroup":
			tit=getLabel('Common.EthnicGroup.label','common');
			sql="select ethnic_group_code,short_desc from mp_ethnic_group_lang_vw  where LANGUAGE_ID=`"+localeName+"`";
			search_code="ethnic_group_code";
			break;
		case "marstatus":
			tit=getLabel('eMP.maritalstatus.label','MP');
			sql="select mar_status_code, short_desc from mp_marital_status_lang_vw  where LANGUAGE_ID=`"+localeName+"`";
			search_code="mar_status_code";
			break;
		case "nod":
			tit=getLabel('eMP.NODType.label','MP');
			sql="select nod_type, short_desc from mp_nod_type_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="nod_type";
			break;
		case "occupation":
			tit=getLabel('eMP.occupation.label','MP');
			sql="select ocpn_code, short_desc from mp_occupation_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="ocpn_code";
			break;
		case "occpnclass":
			tit=getLabel('eMP.OccupationClass.label','MP');
			sql="select ocpn_class_code, long_desc from mp_occupation_class_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="ocpn_class_code";
			break;
		case "occpnclass":
			tit=getLabel('eMP.OccupationClass.label','MP');
			sql="select ocpn_class_code, long_desc from mp_occupation_class_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="ocpn_class_code";
			break;
		case "patcategory":
			tit=getLabel('Common.category.label','common');
			sql="select pat_cat_code, short_desc from mp_pat_category_lang_vw  where LANGUAGE_ID=`"+localeName+"`";
			search_code="pat_cat_code";
			break;
		case "patsuspreason":
			tit=getLabel('eMP.PatientSuspension.label','MP');
			sql="select reason_code, short_desc from mp_pat_susp_reason_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="reason_code";
			break;
		case "postal":
			tit=getLabel('eMP.postalcode.label','MP');
			sql="select postal_code, short_desc from mp_postal_code_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="postal_code";
			break;
		case "town":
			tit=getLabel('eMP.ResidentialTown.label','MP');
			sql="select res_town_code, long_desc from mp_res_town_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="res_town_code";
			break;
		case "race":
			tit=getLabel('eMP.RaceCodes.label','MP');
			sql="select race_code, short_desc from mp_race_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="race_code";
			break;
		case "procclass":
			tit=getLabel('eMP.ProcedureClassification.label','MP');
			sql="select proc_class_code ,short_desc from mp_proc_classification_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="proc_class_code";
			break;
		case "actinact":
			tit=getLabel('eMP.ActivateInactivateReason.label','MP');
			sql="select reason_code,long_desc from mp_pat_inact_reason_lang_vw  where LANGUAGE_ID=`"+localeName+"`";
			search_code="reason_code";
			break;
		case "region":
			tit=getLabel('eMP.region.label','MP');
			sql="select region_code, short_desc from mp_region_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="region_code";
			break;
		case "relationship":
			tit=getLabel('Common.relationship.label','common');
			sql="select relationship_code, short_desc from mp_relationship_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="relationship_code";
			break;
		case "religion":
			tit=getLabel('Common.religion.label','common');
			sql="select relgn_code, short_desc from mp_religion_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="relgn_code";
			break;
		case "area":
			tit=getLabel('eMP.ResidentialArea.label','MP');
			sql="select res_area_code, long_desc from mp_res_area_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="res_area_code";
			break;
		case "vdtype":
			tit=getLabel('eMP.VaginalDeliveryType.label','MP');
			sql="select VAG_DELY_TYPE ,short_desc from mp_vaginal_dely_type_lang_vw where LANGUAGE_ID=`"+localeName+"`";
			search_code="VAG_DELY_TYPE";
			break;
	}
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
	if (!(retVal == null)){
		target.value=retVal;
	}
	else
		target.focus();
}

//From repCountryList.jsp
function abc(obj){
	if(!(obj.value=='file')){
		document.forms[0].pref.value='h';
		document.forms[0].text.value='';
		document.forms[0].pref.disabled=true;
		document.forms[0].text.disabled=true;
	}
	else if(obj.value=='file'){
		document.forms[0].pref.disabled=false;
		document.forms[0].text.disabled=false;
		document.forms[0].text.focus();
	}
}

function sub(obj1){
	var f=obj1;
	if(f==''){
		//alert('pls enter a file name');
		alert(getMessage("ENTR_FILE_NAME","MP"));
	}
}//End repCountryList.jsp


//repNamePrefixList.jsp,repNameSuffixList.jsp,repSTDFamilyName.jsp,repSTDOtherName.jsp
async function callSearch(fromobj,target)
{ 

	var retVal =    new String();
	/*var dialogHeight= "28" ;
	var dialogWidth = "43" ;*/
	var dialogHeight = "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments   = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var frmName = document.forms[0].name;
	var title;
	var url;
	switch(frmName){
		case "repNameSuffixList":
			url="../../eMP/jsp/SearchNamePrefixSuffix.jsp?titles=Suffix";
			break;
		case "repNamePrefixList":
			url="../../eMP/jsp/SearchNamePrefixSuffix.jsp?titles=Prefix";
			break;
		case "repSTDFamilyName":
			url="../../eMP/jsp/SearchStdFamilyName.jsp";
			break;
		case "repSTDOtherName":
			url="../../eMP/jsp/SearchStdOtherName.jsp";
			break;
	}

	retVal = await window.showModalDialog(url,arguments,features);

	if(retVal != null) 
	{
		retVal = unescape(retVal);
		var arr = retVal.split("`");
		target.value=arr[0];
		target.focus();
	}
}//End-repNamePrefixList.jsp

//repOcpnList.jsp
function check(obj) {
	if(repOcpnList.incocpn.checked==true) {
		repOcpnList.p_from_occpn_code.disabled=false;
		repOcpnList.p_to_occpn_code.disabled=false;
	}
	else {
		repOcpnList.p_from_occpn_code.disabled=true;
		repOcpnList.p_to_occpn_code.disabled=true;
	}
}//End-repOcpnList.jsp
