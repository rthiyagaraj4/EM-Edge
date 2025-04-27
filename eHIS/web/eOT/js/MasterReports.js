/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function run(){
	var formObj = searchResultFrame.document.forms[0];
	var frmObj = f_query_add_mod.document.forms[0];
	if(frmObj.speciality_description.value==""){
	alert("Code Cannot Be Blank.")
	window.returnValue=false;
	}

	if(formObj) {
	formObj.submit();
		window.returnValue=true;
		window.close();
	}
}

function reset(){
	//f_query_add_mod.document.forms[0].reset();
	if(searchResultFrame.document.forms[0]){
	searchResultFrame.document.forms[0].reset();
	//searchResultFrame.document.location.href='../../eCommon/html/blank.html';
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}
 }

function loadPage(objVal) {
		//alert(objVal);
	if(objVal=="") {
		parent.searchResultFrame.location.href="../../eCommon/html/blank.html";
	}
	if(objVal==" OT_OPER_GROUP") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepSpecialities.jsp";
	}
	if(objVal==" OT_SPECIALITIES") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepSpecialityCat.jsp";
	}
	if(objVal==" OT_OPER_TYPE") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepOperationType.jsp";
	}
	if(objVal==" OT_NATURE_OF_SURGERY") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepSurgeryType.jsp";
	}
	if(objVal==" OT_OPER_MAST") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepOperProcedures.jsp";
	}
	if(objVal==" OT_PACKAGE_HDR") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepConsumablepacks.jsp";
	}
	if(objVal==" OT_OPER_SURGICAL_ACCESSORIES") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepSurgicalAccessories.jsp";
	}
	if(objVal==" OT_CHECKLIST_ITEMS") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepCheckListItems.jsp";
	}
	if(objVal==" OT_CHECKLIST_HDR") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepCheckLists.jsp";
	}
	if(objVal==" OT_SWAB_INSTR_TMPL_HDR") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepSwabandInsCount.jsp ";
	}
	if(objVal==" OT_SWAB_INSTR_TMPL_ITEMS") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepSwabandInsCountitem.jsp";
	}
	if(objVal==" OT_POSITION") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepPatientposition.jsp";
	}
	if(objVal==" OT_WOUND_TYPE") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepWoundType.jsp";
	}
	if(objVal==" OT_UNUSUAL_OCCUR_CODE") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepUnOccur.jsp";
	}
	if(objVal==" OT_ORGAN_DISPOSAL") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepOrganDisposal.jsp";
	}
	if(objVal==" OT_REASONS") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepReasons.jsp";
	}



	if(objVal==" OT_EQUIPMENT") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepEquipments.jsp";
	}
	if(objVal==" OT_INSTRUMENT") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepInstruments.jsp";
	}
	if(objVal==" OT_PROSTHESIS_CATEGORY") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepImplantCatagory.jsp";
	}
	if(objVal==" OT_PROSTHESIS_TYPE") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepImplantTypes.jsp";
	}
	if(objVal==" OT_PROSTHESIS") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepImplants.jsp";
	}	
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

	if(objVal==" OT_STATUS") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepStatusDescriptions.jsp";
	}	
	if(objVal==" OT_FUNCTIONS") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepFunctions.jsp";
	}	
	if(objVal==" OT_ROLE_TYPE") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepRoleTypes.jsp";
	}
	if(objVal==" OT_ROLES") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepRoles.jsp";
	}
	if(objVal==" OT_USER_FUNCTIONS") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepFunctionsforuser.jsp";
	}
	if(objVal==" OT_BOOKING_FIN_STAGES") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepBookingfinalstages.jsp";
	}
	if(objVal==" OT_BOOKING_PRIORITY") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepBookingpriority.jsp";
	}
	if(objVal==" OT_HOLIDAY") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepHolidays.jsp";
	}
	if(objVal==" OT_BOOKING_ACCESS_RIGHTS") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepBookingRights.jsp";
	}
	if(objVal==" OT_OPER_ROOM") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepOperatingRoom.jsp";
	}
	if(objVal==" OT_HOLDING_AREAS") {
		parent.searchResultFrame.location.href="../../eOT/jsp/MRepHoldingareas.jsp";
	}
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}


async function searchCode( frmObj, searchFor,title, target ) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var retArray 		= new Array() ;
	var sql				= "";
	var locale			= frmObj.locale.value;
	var facility_id		= frmObj.facility_id.value;
	//	title=encodeURIComponent(title);
	if (searchFor == "SPECIALITY") {
		sql = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY_LANG_VW B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 2";
	}
	if (searchFor == "SPECIALITYCAT") {
   		sql = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY_LANG_VW B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 2";
	}
	if (searchFor == "CATEGORY") {
   	    sql = "SELECT OPER_CAT_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_CATEGORY_LANG_VW WHERE UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CAT_CODE) LIKE UPPER(?) AND LANGUAGE_ID = '"+locale+"' ORDER BY 2";
	// sql1="SELECT OPER_SUB_CAT_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_SUB_CATEGORY_LANG_VW WHERE UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_SUB_CAT_CODE) LIKE UPPER(?) AND LANGUAGE_ID= '"+locale+"
	}
	if (searchFor == "OPERATIONTYPE") {
   		sql = "SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE_LANG_VW WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) AND LANGUAGE_ID ='"+locale+"' ORDER BY 2";
	}
	if (searchFor == "SURGERYTYPE") {
	     sql = "SELECT NATURE_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE  UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(NATURE_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 2";
	}
	if (searchFor == "OPERATIONPROCEDURE") {
   	     //sql = "SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST_LANG_VW WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 2";//MMS-QH-CRF-0199 
		 sql = "SELECT OPER_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_MAST_LANG_VW WHERE UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 2";//MMS-QH-CRF-0199
	}
	if (searchFor == "CONSUMABLEPACKS") {
	//Code altered by Selvam for PHASE 3 Delivery
	//  sql = "SELECT SHORT_DESC DESCRIPTION, PACKAGE_CODE CODE FROM OT_PACKAGE_HDR_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(PACKAGE_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
   	     sql = "SELECT LONG_DESC DESCRIPTION, PACKAGE_CODE CODE FROM OT_PACKAGE_HDR_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(PACKAGE_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
	}
	//  Query should be modified //
	if (searchFor == "SURGICALACCESSORIES") {
		var applicability=getLabel("Common.Applicability.label","Common");
		var alloperations=getLabel("Common.AllOperations.label","Common");
		var specificspeciality=getLabel("Common.SpecificSpecialty.label","Common");
		var specificoperation=getLabel("Common.SpecificOperation.label","Common");
var specificoperationcategorywithinspeciality=getLabel("eOT.SpecificOperationCategoryWithinSpeciality.Label","OT");
		var specificoperationsubcategorywithinspeciality=getLabel("eOT.SpecificOperationSubCategoryWithinSpeciality.Label","OT");

		//sql="SELECT DISTINCT APPLICABILITY CODE , DECODE(APPLICABILITY, ''AOPR'', ''All Operations'', ''SSPL'', ''Specific Speciality'', ''SCAT'', ''Specific Operation Category (within the Speciality)'', ''SSUB'', ''Specific Operation Sub-category (within the Category)'', ''SOPR'', ''Specific Operation'') descr FROM OT_OPER_SURGICAL_ACCESSORIES ORDER BY 1";	

		//sql="SELECT DISTINCT APPLICABILITY CODE , DECODE('"+applicability+"', 'AOPR', '"+alloperations+"', 'SSPL', '"+specificspeciality+"', 'SCAT', '"+specificoperationcategorywithinspeciality+"', 'SSUB', '"+specificoperationsubcategorywithinspeciality+"', 'SOPR', '"+specificoperation+"') DESCRIPTION FROM OT_OPER_SURGICAL_ACCESSORIES ORDER BY APPLICABILITY";
		
		sql="SELECT DISTINCT APPLICABILITY CODE , DECODE(APPLICABILITY, 'AOPR', '"+alloperations+"', 'SSPL', '"+specificspeciality+"', 'SCAT', '"+specificoperationcategorywithinspeciality+"', 'SSUB', '"+specificoperationsubcategorywithinspeciality+"', 'SOPR', '"+specificoperation+"') DESCRIPTION FROM OT_OPER_SURGICAL_ACCESSORIES ORDER BY APPLICABILITY";
	}
	if (searchFor == "CHECKLISTITEM") {
   	     sql = "SELECT DESCRIPTION DESCRIPTION, CHECKLIST_ITEM_CODE CODE FROM OT_CHECKLIST_ITEMS_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CHECKLIST_ITEM_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
	}
	if (searchFor == "CHECKLISTS") {
   	     sql = "SELECT DESCRIPTION DESCRIPTION, CHECKLIST_CODE CODE FROM OT_CHECKLIST_HDR_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CHECKLIST_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
	}
	//   LANG VIEW IS NOT THERE
	if (searchFor == "SWABINS") {
   	     sql = "SELECT DESCRIPTION DESCRIPTION, TEMPLATE_ID CODE FROM OT_SWAB_INSTR_TMPL_HDR WHERE  NVL(STATUS,'E')='E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(TEMPLATE_ID) LIKE UPPER(?) ORDER BY 1";
	}
	if (searchFor == "SWABINSITEM") {
		 sql="SELECT DESCRIPTION DESCRIPTION, ITEM_CODE CODE FROM OT_SWAB_INSTR_ITEMS_LANG_VW WHERE NVL(STATUS,'E')='E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(ITEM_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
	}
	//   LANG VIEW IS NOT THERE
	if (searchFor == "PATIENTPOSITION") {
   	     sql = "SELECT LONG_DESC DESCRIPTION, POSITION_CODE CODE FROM OT_POSITION WHERE UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(POSITION_CODE) LIKE UPPER(?) ORDER BY 1";
	}
	if (searchFor == "WOUNDTYPE") {
   	     sql = "SELECT LONG_DESC DESCRIPTION, WOUND_TYPE_CODE CODE FROM OT_WOUND_TYPE_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(WOUND_TYPE_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
	}
	if (searchFor == "UNOCCUR") {
   	     sql = "SELECT LONG_DESC DESCRIPTION, UNUSUAL_OCCUR_CODE CODE FROM OT_UNUSUAL_OCCUR_CODE_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(UNUSUAL_OCCUR_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
	}
	if (searchFor == "ORGANDISPOSAL") {
   	     sql = "SELECT DISPOSAL_DESC DESCRIPTION, DISPOSAL_CODE CODE FROM OT_ORGAN_DISPOSAL_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(DISPOSAL_DESC) LIKE UPPER(?) AND UPPER(DISPOSAL_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
	}
	if (searchFor == "REASONS") {
   	     sql = "SELECT REASON_DESC DESCRIPTION, REASON_CODE CODE FROM OT_REASONS_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(REASON_DESC) LIKE UPPER(?) AND UPPER(REASON_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
	}


	if (searchFor == "EQUIPMENTS") {
		sql="SELECT EQUIPMENT_CODE CODE, LONG_DESC DESCRIPTION FROM OT_EQUIPMENT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(EQUIPMENT_CODE) LIKE UPPER(?) ORDER BY 2";
	}
	if (searchFor == "INSTRUMENTS") {
		sql="SELECT INSTR_CODE CODE, LONG_DESC DESCRIPTION FROM OT_INSTRUMENT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(INSTR_CODE) LIKE UPPER(?) ORDER BY 2";
	}
	if (searchFor == "IMPLANTSCATEGORY") {
		sql="SELECT PROSTHESIS_CAT_CODE CODE, PROSTHESIS_CAT_DESC DESCRIPTION FROM OT_PROSTHESIS_CATEGORY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(PROSTHESIS_CAT_DESC) LIKE UPPER(?) AND UPPER(PROSTHESIS_CAT_CODE) LIKE UPPER(?) ORDER BY PROSTHESIS_CAT_DESC";
	}
	if (searchFor == "IMPLANTTYPES") {
		sql="SELECT PROSTHESIS_TYPE CODE, PROSTHESIS_TYPE_DESC DESCRIPTION FROM OT_PROSTHESIS_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(PROSTHESIS_TYPE_DESC) LIKE UPPER(?) AND UPPER(PROSTHESIS_TYPE) LIKE UPPER(?) ORDER BY 2";
	}
	if (searchFor == "IMPLANTS") {
		sql="SELECT PROSTHESIS_CODE CODE, LONG_DESC DESCRIPTION FROM OT_PROSTHESIS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(PROSTHESIS_CODE) LIKE UPPER(?) ORDER BY 2";
	}
	if (searchFor == "STATUSDESCRIPTIONS") {
		sql="SELECT STATUS_CODE CODE, STATUS_DESC DESCRIPTION FROM OT_STATUS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(STATUS_DESC) LIKE UPPER(?) AND UPPER(STATUS_CODE) LIKE UPPER(?) ORDER BY STATUS_DESC";
	}
	if (searchFor == "FUNCTIONS") {
		sql="SELECT FUNCTION_ID CODE, FUNCTION_DESC_USER DESCRIPTION FROM OT_FUNCTIONS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(FUNCTION_DESC_USER) LIKE UPPER(?) AND UPPER(FUNCTION_ID) LIKE UPPER(?) ORDER BY FUNCTION_DESC_USER";
	}
	if (searchFor == "ROLETYPES") {
		sql="SELECT ROLE_TYPE CODE, ROLE_TYPE_DESC DESCRIPTION FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(ROLE_TYPE_DESC) LIKE UPPER(?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) ORDER BY ROLE_TYPE_DESC";
	}
	if (searchFor == "ROLES") {
		sql="SELECT A.ROLE_ID CODE, A.ROLE_DESC DESCRIPTION FROM OT_ROLES_LANG_VW A  WHERE LANGUAGE_ID='"+locale+"' AND UPPER(A.ROLE_DESC) LIKE UPPER(?) AND UPPER(A.ROLE_ID) LIKE UPPER(?)ORDER BY 2";
	}
	if (searchFor == "FUNCTIONSFORUSER") {
		//sql="select distinct user_id code,appl_user_name description from ot_user_functions a,sm_appl_user_lang_vw b where a.user_id = b.appl_user_id and LANGUAGE_ID='en' AND UPPER(appl_user_name) LIKE UPPER(?) AND UPPER(user_id) LIKE UPPER(?) order by user_id";
		sql="select distinct user_id code,appl_user_name description from ot_user_functions a,sm_appl_user_lang_vw b where a.user_id = b.appl_user_id and b.LANGUAGE_ID='"+locale+"' AND UPPER(appl_user_name) LIKE UPPER(?) AND UPPER(user_id) LIKE UPPER(?) order by user_id";
	}
	if (searchFor == "BOOKINGFINALSTAGES") {
		sql="SELECT STAGE_CODE CODE, POST_STAGE_DESC DESCRIPTION FROM OT_BOOKING_FIN_STAGES_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(POST_STAGE_DESC) LIKE UPPER(?) AND UPPER(STAGE_CODE) LIKE UPPER(?) ORDER BY POST_STAGE_DESC";
	}
	if (searchFor == "BOOKINGPRIORITIES") {
		sql="SELECT PRIORITY_CODE CODE, PRIORITY_DESC DESCRIPTION FROM OT_BOOKING_PRIORITY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(PRIORITY_DESC) LIKE UPPER(?) AND UPPER(PRIORITY_CODE) LIKE UPPER(?) ORDER BY PRIORITY_DESC";
	}
	if (searchFor == "HOLIDAYS") {
		sql="SELECT PRIORITY_CODE CODE, PRIORITY_DESC DESCRIPTION FROM OT_BOOKING_PRIORITY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(PRIORITY_DESC) LIKE UPPER(?) AND UPPER(PRIORITY_CODE) LIKE UPPER(?) ORDER BY PRIORITY_DESC";
	}
	if (searchFor == "BOOKINGRIGHTS") {
		sql="SELECT A.APPL_USER_ID CODE,  B.APPL_USER_NAME  DESCRIPTION FROM OT_BOOKING_ACCESS_RIGHTS A, SM_APPL_USER_LANG_VW B WHERE  A.APPL_USER_ID = B.APPL_USER_ID AND B.LANGUAGE_ID='"+locale+"' AND UPPER(B.APPL_USER_NAME) LIKE UPPER(?) AND UPPER(A.APPL_USER_ID) LIKE UPPER(?) ORDER BY 1";
	}
	if (searchFor == "OPERATINGROOM") {
		sql="SELECT OPER_ROOM_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY LONG_DESC";
	}
	if (searchFor == "HOLDINGAREA") {
		sql="SELECT holding_area_CODE CODE, holding_area_DESC DESCRIPTION FROM OT_holding_areas_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID='"+facility_id+"' AND UPPER(holding_area_DESC) LIKE UPPER(?) AND UPPER(holding_area_CODE) LIKE UPPER(?) ORDER BY holding_area_DESC";
	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;

	retArray = await CommonLookup( title, argumentArray );
	if(retArray != null && retArray != "" ) {
		var ret1=unescape(retArray);
	 	var arr=ret1.split(",");
	 	if(arr[0]==undefined) { 
		arr[0]="";
		}
		target.value = arr[0];	/* if code need to be returned */
		//target.focus();
	}
	else{
	target.value ="";
	}
}



