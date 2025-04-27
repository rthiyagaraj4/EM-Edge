  //saved on 02.11.2005
function run() { 
	var frmObject = f_query_add_mod.document.formPhDrugUsageBySrcCriteria;
	if(f_query_add_mod.document.formPhDrugUsageBySrcCriteria) {
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_from.value = convertDate(f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_from1.value,'DMY',f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_language_id.value,'en');
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_to.value = convertDate(f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_to1.value,'DMY',f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_language_id.value,'en');
		
		var fields= new Array (frmObject.dt_from1,frmObject.dt_to1,frmObject.p_group_by,frmObject.p_report_by,frmObject.Location_Type);
		var names= new Array (getLabel("Common.periodfrom.label","Common"),getLabel("Common.todate.label","Common"), getLabel("Common.groupby.label","Common"),getLabel("Common.reporttype.label","Common"),getLabel("Common.locationtype.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_from1, f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_to1, messageFrame ) ) {
				var tmp_drug_desc = f_query_add_mod.document.formPhDrugUsageBySrcCriteria.drug_name.value;		//Added for ML-MMOH-SCF-0373 [IN:059797] - Start
				var tmp_drug_desc1 = f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tdrug_name.value;

				if(tmp_drug_desc != '')
					f_query_add_mod.document.getElementById("drug_from").innerHTML = "&nbsp";
				if(tmp_drug_desc1 != '')
									
					f_query_add_mod.document.getElementById("drug_to").innerHTML = "&nbsp";		//Added for ML-MMOH-SCF-0373 [IN:059797] - End
				//if(f_query_add_mod.CheckString("Location Id", f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_id, f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_id, messageFrame) ) {
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
						f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.formPhDrugUsageBySrcCriteria.submit();
						
				//}
				if(tmp_drug_desc != ''){		//Added for ML-MMOH-SCF-0373 [IN:059797] - Start
						f_query_add_mod.document.getElementById("drug_from").innerHTML = '&nbsp;<input type="text" name="drug_name" id="drug_name" readonly maxlength="30" size="30" value="'+tmp_drug_desc+'"><input type="button" class="button" value="?"  name="drug_search" id="drug_search" onClick="callDrugSearch(document.formPhDrugUsageBySrcCriteria.drug_name, 1)" >';
						}
				if(tmp_drug_desc1 != ''){	
						f_query_add_mod.document.getElementById("drug_to").innerHTML = '&nbsp;<input type="text" name="tdrug_name" id="tdrug_name" readonly maxlength="30" size="30" value="'+tmp_drug_desc1+'"><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search" onClick="callDrugSearch(document.formPhDrugUsageBySrcCriteria.tdrug_name, 2)">';
						}		//Added for ML-MMOH-SCF-0373 [IN:059797] - End
				
			}
		}
	}

}

// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhDrugUsageBySrcCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}



function reset() {
    f_query_add_mod.formPhDrugUsageBySrcCriteria.reset();
	f_query_add_mod.formPhDrugUsageBySrcCriteria.loc_search.disabled = true;
	f_query_add_mod.formPhDrugUsageBySrcCriteria.tloc_search.disabled = true;
	f_query_add_mod.formPhDrugUsageBySrcCriteria.drug_name.value = "";//Modified For reset empty
	f_query_add_mod.formPhDrugUsageBySrcCriteria.tdrug_name.value = "";//Modified For reset empty
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage() {
	var result	=	false;
	frm_obj		=	f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_from1;
	to_obj		=	f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_to1;
	msg_frame		=	messageFrame;

	if(doDateCheck(frm_obj,to_obj,msg_frame)) {
		result	=	true;
	}
	else {
		result  = false;
	}
	alert(result);
	return result;
}


		



async function callDrugSearch(obj,mode) { 

	var arrCodeDesc = await DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1)
		{  document.formPhDrugUsageBySrcCriteria.drug_code.value	=	arrCodeDesc[0];
		}
		if (mode == 2)
		{		document.formPhDrugUsageBySrcCriteria.tdrug_code.value	=	arrCodeDesc[0];
		}
			
		//document.formPhDrugUsageBySrcCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}



async function searchLocationName(target, mode) {

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_facility_code.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_facility_code.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	p_language_id = f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_language_id.value; //added for MOHE-SCF-0108
	p_user_name   = f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_user_name.value; //added for MOHE-SCF-0108

if (f_query_add_mod.document.formPhDrugUsageBySrcCriteria.Location_Type.value=="N")
{
	//Search for Nursing Unit
	//argumentArray[0]   = escape(f_query_add_mod.document.formPhDrugUsageBySrcCriteria.nursing_unit_query.value)+"'"+ f_query_add_mod.document.formPhDrugUsageBySrcCriteria.language_id.value+"'";
	
	//argumentArray[0]   =escape(f_query_add_mod.document.getElementById("nursing_unit_query").value)+"'"+f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_language_id.value+"'"+ "AND APPL_USER_ID ='"+f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_user_name.value+"'order by 2";
	
	sql_ph_generic_name = escape("SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(LONG_DESC) LIKE UPPER(?) AND A.LANGUAGE_ID =")+"'"+p_language_id+"' "+ "AND APPL_USER_ID ='"+p_user_name+"' order by 2 "; //added for MOHE-SCF-0108

	argumentArray[0] = sql_ph_generic_name; //added for MOHE-SCF-0108  

	retVal=await CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(retVal != null && retVal != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_id.value=arr[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_id.value=arr[0];

	target.value = arr[1];
	
	}
}
else
{

	//argumentArray[0]   = escape(f_query_add_mod.document.getElementById("clinic_query").value)+"'"+f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_language_id.value+"'"+ "AND b.APPL_USER_ID ='"+f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_user_name.value+"'order by 2";
	
//	sql_ph_generic_name = escape("SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND  UPPER(CLINIC_CODE) LIKE  UPPER(?) AND  UPPER(LONG_DESC) LIKE  UPPER(?) AND A.LANGUAGE_ID = ")+"'"+p_language_id+"' "+ "AND APPL_USER_ID ='"+p_user_name+"' order by 2 "; //added for MOHE-SCF-0108

	sql_ph_generic_name = escape("SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE in ('C','E') AND  UPPER(CLINIC_CODE) LIKE  UPPER(?) AND  UPPER(LONG_DESC) LIKE  UPPER(?) AND A.LANGUAGE_ID = ")+"'"+p_language_id+"' "+ "AND APPL_USER_ID ='"+p_user_name+"' order by 2 "; //added for MOHE-SCF-0108 //ML-MMOH-SCF-0210 - added clinic_type E - procedure unit

	argumentArray[0] = sql_ph_generic_name; //added for MOHE-SCF-0108  


	retVal=await CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );
    var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(retVal != null && retVal != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_id.value=arr[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_id.value=arr[0];
		target.value = arr[1];
	}
}

}

function disableLocation(val)
{
	/*f_query_add_mod.document.formPhMednStatBySrcCriteria.Disp_Locn.disabled=true;
	clearData(f_query_add_mod.document.formPhMednStatBySrcCriteria.Disp_Locn);
	addData("","  ---Select---   ",f_query_add_mod.document.formPhMednStatBySrcCriteria.Disp_Locn);*/

	if (val=="")
	{
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_name.disabled=true;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_name.value="";
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_search.disabled=true;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_name.disabled=true;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_name.value="";
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_search.disabled=true;

	}
	else
	{
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_name.value="";
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_name.disabled=false;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_search.disabled=false;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_name.value="";
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_name.disabled=false;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_search.disabled=false;
	}
	

}




function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}


