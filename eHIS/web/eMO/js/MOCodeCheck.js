function codeCheck(Obj){
var u=Obj;
parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
if(u==' '){
parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
}
if(u=="MO_AREA"){
	parent.f_query_add_mod.location.href ="../../eMO/jsp/repMortuaryAreaList.jsp";
}
if(u=="MO_BODY_CONDITION"){
	parent.f_query_add_mod.location.href ="../../eMO/jsp/repBodyConditionList.jsp";
}
if(u=="MO_MANNER_OF_DEATH"){
	parent.f_query_add_mod.location.href ="../../eMO/jsp/repMannerOfDeathList.jsp";
}
if(u=="MO_CLAIMANT_TYPE"){
	parent.f_query_add_mod.location.href ="../../eMO/jsp/repClaimantTypeList.jsp";
}

if(u=="MO_CONSENT_FORM"){
	parent.f_query_add_mod.location.href ="../../eMO/jsp/repConsentFormList.jsp";
}
if(u=="MO_BED_FOR_AREA"){
	parent.f_query_add_mod.location.href ="../../eMO/jsp/repBedForArea.jsp";
}
if(u=="MO_BODY_PART"){
	parent.f_query_add_mod.location.href ="../../eMO/jsp/repBodyPartList.jsp";
}
if(u=="MO_ORGAN_FOR_DONATION"){
	parent.f_query_add_mod.location.href ="../../eMO/jsp/repOrgansForDonationList.jsp";
}
}

