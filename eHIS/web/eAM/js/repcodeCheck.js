function codeCheck(Obj){

	Obj = Obj.toUpperCase();

	switch(Obj)
	{
		case "AM_SERVICE":				fileName="../../eAM/jsp/repServiceList.jsp";		break;
		case "AM_SUBSERVICE":			fileName="../../eAM/jsp/repSubServiceList.jsp";		break;
		case "AM_DEPT":					fileName="../../eAM/jsp/repDeptList.jsp";			break;
		case "AM_DEPT_SECTION":			fileName="../../eAM/jsp/repSectionList.jsp";		break;
		case "AM_FACILITY_DEPT":		fileName="../../eAM/jsp/repFacilityDeptList.jsp";	break;
		case "AM_FACILITY_SECTION":		fileName="../../eAM/jsp/repFacilitySectionList.jsp";break;
		case "AM_FACILITY_SERVICE":		fileName="../../eAM/jsp/repFacilityService.jsp";	break;
		case "AM_FACILITY_SUBSERVC":	fileName="../../eAM/jsp/repFacilitySubService.jsp"; break;
		case "AM_SPECIALITY":			fileName="../../eAM/jsp/repSpecialityList.jsp";		break;
		case "AM_PRACT_TYPE":			fileName="../../eAM/jsp/repPractType.jsp";			break;
		case "AM_PRACTITIONER":			fileName="../../eAM/jsp/repPractitionerList.jsp";	break;
		case "AM_PRACT_FOR_FACILITY":	fileName="../../eAM/jsp/repPractForFacility.jsp";	break;
		case "AM_PRACT_SPECIALITIES":	fileName="../../eAM/jsp/repSpecialityForPract.jsp"; break;
		case "AM_OPER_STN":				fileName="../../eAM/jsp/repOperStnList.jsp";		break;
		case "AM_LOCN_FOR_OPER_STN":	fileName="../../eAM/jsp/repLocnForOperStn.jsp";		break;
		case "AM_USER_FOR_OPER_STN":	fileName="../../eAM/jsp/repUserOperStn.jsp";		break;
      	case "AM_RESTRN_FOR_OPER_STN":	fileName="../../eAM/jsp/repOperRestrn.jsp";			break;
		case "AM_CARE_LOCN_TYPE":		fileName="../../eAM/jsp/repCareLocnType.jsp";		break;
		case "AM_BLDING":				fileName="../../eAM/jsp/repBldnginfacility.jsp";	break;
		case "AM_BLDING_FLOOR":			fileName="../../eAM/jsp/repFloorinfacility.jsp";	break;
		case "AM_FACILITY_ROOM":		fileName="../../eAM/jsp/repFacilityRoom.jsp";		break;
		case "AM_DEPT_FOR_FACILITY_ROOM":	fileName="../../eAM/jsp/repDeptRoomList.jsp";	break;
		case "AM_AGE_GROUP":				fileName="../../eAM/jsp/repAgeGroupList.jsp";	break;
		case "AM_AMBULATORY_STATUS":		fileName="../../eAM/jsp/repAmbStatus.jsp";		break;
		case "AM_CIRCUMSTANCE_OF_INJURY":	fileName="../../eAM/jsp/repCOIList.jsp";		break;
		case "AM_COMPLAINT":			fileName="../../eAM/jsp/repComplaintList.jsp";		break;
		case "AM_DISPOSITION_TYPE":		fileName="../../eAM/jsp/repDispTypeList.jsp";		break;
		case "AM_REACTION":				fileName="../../eAM/jsp/repReactionList.jsp";		break;
		case "AM_REFERRAL":				fileName="../../eAM/jsp/repReferralList.jsp";		break;
		case "AM_ARRIVAL":				fileName="../../eAM/jsp/repArrivalList.jsp";		break;
		case "AM_PATIENT_TYPE":			fileName="../../eAM/jsp/repPatType.jsp";			break;
		case "AM_PATIENT_TYPE_CLASS":	fileName="../../eAM/jsp/repPatTypeClass.jsp";		break;
		case "AM_CONTACT_REASON":		fileName="../../eAM/jsp/repContactReason.jsp";		break;
		case "AM_SUMM_RANGE":			fileName="../../eAM/jsp/repAgeRange.jsp";			break;
		case "AM_HCARE_SETTING_TYPE":	fileName="../../eAM/jsp/repHealtcareSetting.jsp";	break;
		case "AM_HCARE_SETTING_TYPE_RSTRN":	fileName="../../eAM/jsp/repHltcareSetgRestrn.jsp";  break;
		case "AM_REF_ID_NUM_FOR_FCY":	fileName="../../eAM/jsp/repReferralNumControl.jsp";		break;
		case "AM_STAT_GROUP":			fileName="../../eAM/jsp/repStatisticsGroup.jsp";		break;
		case "AM_STAT_GROUP_DTL":		fileName="../../eAM/jsp/repStatisticsGroupDetail.jsp";	break;
		case "AM_STAT_GRP_DETAIL":		fileName="../../eAM/jsp/repStatisticsGroupDetail.jsp";	break;
		case "AM_STAT_GRP_FOR_PROGRAM":	fileName="../../eAM/jsp/repPgmForStatisticsGroup.jsp";	break;
		case "AM_MEDICAL_TEAM":			fileName="../../eAM/jsp/repMedicalTeam.jsp";			break;
		case "AM_PRACT_FOR_TEAM":		fileName="../../eAM/jsp/repPractForMedicalTeam.jsp";	break;
		case "PR_ENC_ID_NUM_FOR_FCY":	fileName="../../eAM/jsp/repEncounterNumControl.jsp";	break;
		///////////////// Added by Praveen on 15 Apr 20003////////////////////////////		
		case "AM_UOM_EQVL":	fileName="../../eAM/jsp/repEquiUOM.jsp";	break;
		case "AM_UOM":	fileName="../../eAM/jsp/repUnitofMeasure.jsp";	break;
		case "AM_MANUFACTURER":	fileName="../../eAM/jsp/repManufacturer.jsp";	break;
		case "AM_FREQUENCY":	fileName="../../eAM/jsp/repFrequency.jsp";	break;
		case "AM_DURATION_TYPE":	fileName="../../eAM/jsp/repDurationType.jsp";	break;
		case "AM_TRADE_NAME":	fileName="../../eAM/jsp/repTradeName.jsp";	break;
		case "AM_FREQUENCY_ADMIN_DAY_TIME":	fileName="../../eAM/jsp/repFrequencySchedule.jsp";	break;
		case "AM_REFERRAL_FOR_SPECIALTY": fileName="../../eAM/jsp/repSpecialityforReferral.jsp";	break;
		//////////////////// Added by Kavitha on 5 July 2004 //////////////////////////
		case "AM_ANAESTHESIA": fileName="../../eAM/jsp/repAnaesthesia.jsp";	break;
        case "AM_ANATOMICAL_SITE": fileName="../../eAM/jsp/repAnatomicalSite.jsp";	break;
        case "AM_ESCORT_TYPE": fileName="../../eAM/jsp/repEscortType.jsp";	break;
        case "AM_RESOURCE_TYPE": fileName="../../eAM/jsp/repEquipandOtherResourceType.jsp";	break;
		case "AM_RESOURCE": fileName="../../eAM/jsp/repEquipmentandOtherResource.jsp";	break;
		case "AM_LEVEL_OF_CARE": fileName="../../eAM/jsp/repLevelofCare.jsp";	break;
		default	 :	fileName="../../eCommon/html/blank.html";								break;

	}
	parent.f_query_add_mod.location.href=fileName;

/*
var u=Obj;
if(u==' '){
parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
}
if(u==1){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repServiceList.jsp";
}
if(u==2){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repSubServiceList.jsp";
}
if(u==3){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repDeptList.jsp";
}
if(u==4){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repSectionList.jsp";
}
if(u==5){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repFacilityDeptList.jsp";
}
if(u==6){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repFacilitySectionList.jsp";
}
if(u==7){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repFacilityService.jsp";
}
if(u==8){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repFacilitySubService.jsp";
}
if(u==9){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repSpecialityList.jsp";
}
if(u==10){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repPractType.jsp";
}
if(u==11){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repPractitionerList.jsp";
}
if(u==12){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repPractForFacility.jsp";
}
if(u==13){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repSpecialityForPract.jsp";
}
if(u==14){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repOperStnList.jsp";
}
if(u==15){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repLocnForOperStn.jsp";
}
if(u==16){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repUserOperStn.jsp";
}
if(u==17){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repCareLocnType.jsp";
}
if(u==18){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repBldnginfacility.jsp";
}
if(u==19){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repFloorinfacility.jsp";
}
if(u==20){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repFacilityRoom.jsp";
}
if(u==21){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repDeptRoomList.jsp";
}
if(u==22){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repAgeGroupList.jsp";
}
if(u==23){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repAmbStatus.jsp";
}
if(u==24){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repCOIList.jsp";
}
if(u==25){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repComplaintList.jsp";
}
if(u==26){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repDispTypeList.jsp"; 
}
if(u==27){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repReferralList.jsp";
}
if(u==28){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repArrivalList.jsp";
}
if(u==29){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repPatType.jsp";
}
if(u==30){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repPatTypeClass.jsp";
}
if(u==31){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repContactReason.jsp";
}
if(u==32){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repAgeRange.jsp";
}
if(u==33){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repOperRestrn.jsp";
}
if(u==34){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repHealtcareSetting.jsp";
}
if(u==35){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repHltcareSetgRestrn.jsp";
}
if(u==36){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repReferralNumControl.jsp";
}
if(u==37){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repStatisticsGroup.jsp";
}
if(u==38){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repStatisticsGroupDetail.jsp";
}
if(u==39){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repPgmForStatisticsGroup.jsp";
}
if(u==40){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repMedicalTeam.jsp";
}
if(u==41){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repPractForMedicalTeam.jsp";
}
if(u==42){
parent.f_query_add_mod.location.href ="../../eAM/jsp/repEncounterNumControl.jsp";
}*/

}


