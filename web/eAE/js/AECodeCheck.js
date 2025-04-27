function codeCheck(Obj){
var u=Obj;
if(u==' '){
parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
}

if(u=="AE_IMMOBILIZATION"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repImmobilizationCodeList.jsp";
}

// ************** Disaster Type ***************
if(u=="AE_DISASTER_TYPE"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repDisasterTypeList.jsp";
}


if(u=="AE_PROTECTIVE_DEVICE"){  
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repProtectiveDeviceList.jsp";
}
if(u=="AE_PAT_POSITION"){ 
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repPatPositionList.jsp";
}
if(u=="AE_PAT_PRIORITY"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repPatPriorityList.jsp";
}
if(u=="AE_RESPONSIVENESS"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repResponsivenessList.jsp";
}

if(u=="AE_GCS_RESPONSE"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repGCSResponseList.jsp";
}
if(u=="AE_GCS_FOR_RESPONSE"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repGCSforResponseList.jsp";
}

if(u=="AE_GCS_SCORE"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repGCSResponseScoreList.jsp";
}
if(u=="AE_TMT_AREA_FOR_CLINIC"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repTreatmentAreaforClinicList.jsp";

}
if(u=="AE_PRACT_FOR_TMT_AREA"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repPractitionerforTreatmentAreaList.jsp";

}
if(u=="AE_BAY_TYPE"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repBedOrBayTypeCodeList.jsp";

}
if(u=="AE_BED_FOR_TRMT_AREA"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repBedsForTreatmentAreaList.jsp";

}
if(u=="AE_INJURY_SUBCATEGORY"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repInjurySubcategoryList.jsp";

}
if(u=="AE_INJURY_CATEGORY"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repInjuryCategoryCodeList.jsp";

}
if(u=="AE_SPARE_BAYS"){
	parent.f_query_add_mod.location.href ="../../eAE/jsp/repBedOrBayList.jsp";

}

}

//TreatmentArea for clinic
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "65vh" ;
			var dialogWidth	= "95vh" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility_id= "`"+'<%=p_facility_id%>'+"`"
			var facility_id ="`"+ document.repTreatmentAreaforClinicList.p_facility_id.value+"`";
			var locale ="`"+ document.repTreatmentAreaforClinicList.locale.value+"`";

  		    if(obj.name=="clinic code")
			{
				
				tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));
				//sql="select clinic_code, LONG_DESC from op_clinic_lang_vw where facility_id ="+facility_id+"   and language_id = "+locale;
				sql="select clinic_code,short_desc from op_clinic_lang_vw where level_of_care_ind = `E` and facility_id ="+facility_id+" and language_id="+locale ;
				search_code="clinic_code"
				search_desc= "LONG_DESC"
			}
            else 
			{
				tit=encodeURIComponent(getLabel("Common.treatmentarea.label","Common"));
				sql="select treatment_area_code,short_desc from ae_tmt_area_for_clinic_lang_vw where facility_id="+facility_id+"  and language_id ="+locale;
				search_code="treatment_area_code";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
//Bed or Bay Type
async function searchCodeBedorBay(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "65vh" ;
			var dialogWidth	= "95vh" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale ="`"+ document.repBedBayList.locale.value+"`";
		
			if(obj.name=="bedbaycode")
			{
				tit=encodeURIComponent(getLabel("eAE.BedBayType.label","AE")); 
			
				sql="select bay_type_code,short_desc from ae_bay_type_lang_vw where language_id = "+locale;
				search_code="bay_type_code";
				search_desc= "short_desc";
				}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
    //Bed or Bay
async function searchCodeBedorBay2(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "65vh" ;
			var dialogWidth	= "95vh" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility_id= "`"+'<%=p_facility_id%>'+"`"
			var facility_id="`"+document.repBedorbay.p_facility_id.value+"`"
			var locale="`"+document.repBedorbay.locale.value+"`"
  		    if(obj.name=="clinic code")
			{
				tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));
				sql	="select clinic_code, LONG_DESC from op_clinic_lang_vw where facility_id = "+facility_id+"  and language_id = "+locale+" and LEVEL_OF_CARE_IND=`E` ";
				search_code="clinic_code"
				search_desc= "LONG_DESC"
			}
            else
			{
				tit=encodeURIComponent(getLabel("eAE.BedBayType.label","AE")); 
				sql="select bay_type_code,short_desc from ae_bay_type_lang_vw where language_id = "+locale; 
				search_code="bay_type_code";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
    //Bed for TreatmentArea
async function searchCodeBedorBayforTMT(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "65vh" ;
			var dialogWidth	= "95vh" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility_id= "`"+'<%=p_facility_id%>'+"`"
			var facility_id = "`"+document.repBedsForTreatmentAreaList.p_facility_id.value+"`";
			var locale = "`"+document.repBedsForTreatmentAreaList.locale.value+"`";
  		    if(obj.name=="clinic code")
			{
			
				tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));
				sql="select clinic_code, LONG_DESC from op_clinic_lang_vw where   level_of_care_ind = `E` and facility_id ="+facility_id+" and language_id = "+locale  ;
				search_code="clinic_code"
				search_desc= "LONG_DESC"
			}
            else if(obj.name=="tr area code")
			{
				tit=encodeURIComponent(getLabel("Common.treatmentarea.label","Common"));
				sql="select treatment_area_code,short_desc from ae_tmt_area_for_clinic_lang_vw where facility_id="+facility_id+"  and language_id = "+locale ;
				search_code="treatment_area_code";
				search_desc= "short_desc"
			}
            else
			{
				tit=encodeURIComponent(getLabel("eAE.BedBayType.label","AE")); 
				sql="select bay_type_code,short_desc from ae_bay_type_lang_vw where language_id = "+locale;
				search_code="bay_type_code";
				search_desc= "short_desc"
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
//PractitionerforTreatmentArea
async function searchPractitionerforTMTArea(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "65vh" ;
			var dialogWidth	= "95vh" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility_id= "`"+'<%=p_facility_id%>'+"`"
			var facility_id = "`"+document.repPractitionerforTreatmentAreaList.p_facility_id.value+"`";
			var locale = "`"+document.repPractitionerforTreatmentAreaList.locale.value+"`";
  		    if(obj.name=="clinic code")
			{
				
				tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));
				sql="select clinic_code, LONG_DESC from op_clinic_lang_vw where   level_of_care_ind = `E`  and facility_id ="+facility_id+" and language_id = "+locale  ;
				search_code="clinic_code"
				search_desc= "LONG_DESC"
			}
            else if(obj.name=="tr area code")
			{
				tit=encodeURIComponent(getLabel("Common.treatmentarea.label","Common"));
				sql="select treatment_area_code,short_desc from ae_tmt_area_for_clinic_lang_vw where facility_id="+facility_id+"  and language_id = "+locale ;
				search_code="treatment_area_code";
				search_desc= "short_desc"
			}
            else
			{
				/*tit=encodeURIComponent(getLabel("Common.practitioner.label","Common"));
				//sql="select practitioner_id,practitioner_name from am_pract_for_facility ";
				sql="select practitioner_id,practitioner_name from am_practitioner_lang_vw where language_id = "+locale;
				//	"where facility_id = "+facility_id;
				search_code="practitioner_id";
				search_desc= "practitioner_name"*/
				var specialty_code="";
				var clinic_code="";
				var treatment_area_code="";
				var open_to_all_prac_for_clinic_yn="";
				var open_to_all_pract_yn="";
				var practitioner_type="";
				getPractitioner(obj,target,facility_id,specialty_code,practitioner_type,"Q5",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn);
				return;
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

function PractLookupRetVal(retVal,objName)
{

	var arr;

	if (retVal != null)
	{
		arr=retVal.split("~");
	
		if(objName=="p_fm_practitioner_id")
			document.forms[0].p_fm_practitioner_id.value=arr[0];
		else
			document.forms[0].p_to_practitioner_id.value=arr[0];
	}
	else
	{
		
		if(objName=="p_fm_practitioner_id")
			document.forms[0].p_fm_practitioner_id.value="";
		else
			document.forms[0].p_to_practitioner_id.value="";
						
	}
}


//PatientPosition
async function searchPatientPostion(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "65vh" ;
			var dialogWidth	= "95vh" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale = "`"+document.repPatPositionList.locale.value+"`";

			if(obj.name=="pat position code")
			{ 
				tit=encodeURIComponent(getLabel("Common.PatientPosition.label","Common")); 
				sql="select pat_position_code, short_desc from ae_pat_position_lang_vw where language_id = "+locale;
				search_code="pat_position_code";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else 
				target.focus();
	}
//Protective Device
async function searchProtectiveDevice(obj,target) 
	{
			var retVal = 	new String();
			var dialogHeight= "65vh" ;
			var dialogWidth	= "95vh" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale = "`"+document.repProtectiveDeviceList.locale.value+"`";

			if(obj.name=="protective device code")
			{
				tit=encodeURIComponent(getLabel("eAE.ProtectiveDevice.label","AE")); 
				sql="select protective_device_code, short_desc from ae_protective_device_lang_vw where language_id = "+locale;
				search_code="protective_device_code";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await top.window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
//InjuryCategory
async function searchInjuryCategory(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "55vh" ;
			var dialogWidth	= "65vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale = "`"+document.repinjurycategory.locale.value+"`";

			if(obj.name=="injurycode") 
			{
				tit=encodeURIComponent(getLabel("eAE.InjuryCategory.label","AE")); 
			
				sql="select inj_category_code,short_desc from ae_injury_category_lang_vw where language_id = "+locale;
				search_code="inj_category_code";
				search_desc= "short_desc";
				}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await top.window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
//InjurySubCategory
async function searchInjurySubCategory(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "55vh" ;
			var dialogWidth	= "65vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility_id= "`"+'<%=p_facility_id%>'+"`"
			var facility_id="`"+document.repInjurySubcategoryList.p_facility_id.value+"`";
			var locale="`"+document.repInjurySubcategoryList.locale.value+"`";
  		    if(obj.name=="injury_code")
			{
				tit=encodeURIComponent(getLabel("eAE.InjuryCategory.label","AE")); 
				sql="select inj_category_code,short_desc from ae_injury_category_lang_vw where language_id = "+locale; 
				search_code="inj_category_code"
				search_desc= "short_desc"
			}
            else  
			{
				tit=encodeURIComponent(getLabel("eAE.InjurySubcategory.label","AE")); 
				sql="select inj_subcategory_code,short_desc from ae_injury_subcategory_lang_vw where language_id = "+locale;
				search_code="inj_subcategory_code";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await top.window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
//PatientPriority
async function searchPatientPriority(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "55vh" ;
			var dialogWidth	= "65vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale="`"+document.repPatPriorityList.locale.value+"`";

			if(obj.name=="priority code") 
			{
				tit=encodeURIComponent(getLabel("eAE.PatientPriority.label","AE")); 
				sql="select priority_code, short_desc from ae_pat_priority_lang_vw where language_id = "+locale;
				search_code="priority_code";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await top.window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
//GCSResponse
async function searchGCSforResponse(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "55vh" ;
			var dialogWidth	= "65vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			if(obj.name=="GCS response code") 
			{
				tit=encodeURIComponent(getLabel("eAE.GCSforResponse.label","AE")); 
				sql="select gcs_response_code, gcs_response_desc from ae_gcs_response";
				search_code="gcs_response_code";
				search_desc= "gcs_response_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await top.window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
//GCSforResponse
async function searchGCSResponse(obj,target) 
	{
			var retVal = 	new String();
			var dialogHeight= "55vh" ;
			var dialogWidth	= "65vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
  		    if(obj.name=="response code")
			{
				tit=encodeURIComponent(getLabel("eAE.GCSforResponse.label","AE")); 
				sql="select gcs_response_code,gcs_response_desc from ae_gcs_response"
				search_code="gcs_response_Code"
				search_desc= "gcs_response_desc"
			}
            else 
			{
				tit=encodeURIComponent(getLabel("eAE.GCSCodes.label","AE")); 
				sql="select gcs_code,gcs_Desc from ae_gcs_for_response"
				search_code="gcs_code";
				search_desc= "gcs_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await top.window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
				target.focus();

			}
			else
				target.focus();
	}
//Immobilization
async function searchImmobilization(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "55vh" ;
			var dialogWidth	= "65vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale="`"+document.repImmobilizationCodeList.locale.value+"`";

			if(obj.name=="Immobilization Code") 
			{
				tit=encodeURIComponent(getLabel("eAE.Immobilization.label","AE")); 
				sql="select immobilization_code, short_desc from ae_immobilization_lang_vw where language_id = "+locale;
				search_code="immobilization_code";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await top.window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

//************** Search Disaster Type *****************
async function searchDisasterType(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "55vh" ;
			var dialogWidth	= "65vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale="`"+document.repDisasterCodeList.locale.value+"`";
			if(obj.name=="DisasterType Code") 
			{
				tit=encodeURIComponent(getLabel("eAE.DisasterType.label","AE")); 
				sql="select DISASTER_TYPE_CODE, short_desc from AE_DISASTER_TYPE_lang_vw where language_id = "+locale;
				search_code="disaster_type_code";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await top.window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

function CheckString2(str,fromobj,toobj,messageFrame) {

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}
