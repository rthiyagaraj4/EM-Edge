
function run() {
	var frmObject = f_query_add_mod.document.formPhMednOrdStatCriteria;
	var locale=frmObject.p_language_id.value;
	if(frmObject.p_dt_from.value==""){ 
		var msg=getLabel("Common.periodfrom.label","PH")+" "+getLabel("Common.Cannotbeblank.label","PH");
		alert(msg);
		frmObject.p_dt_from.focus();
		return false;
	}
	else if(frmObject.p_dt_to.value==""){
		var msg=getLabel("Common.to.label","PH")+" "+getLabel("Common.Cannotbeblank.label","PH");
		alert(msg);
		frmObject.p_dt_to.focus();
		return false;
	}
	else if(f_query_add_mod.document.formPhMednOrdStatCriteria) {
		var fields= new Array (frmObject.p_report_by);
		var names= new Array (getLabel("Common.reporttype.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck(f_query_add_mod.document.formPhMednOrdStatCriteria.p_dt_from, f_query_add_mod.document.formPhMednOrdStatCriteria.p_dt_to, messageFrame )){ 
				frmObject.dt_from.value=convertDate(frmObject.p_dt_from.value,'DMY',locale,"en");
				frmObject.dt_to.value=convertDate(frmObject.p_dt_to.value,'DMY',locale,"en");
				if(frmObject.p_report_by.value=="SM")
					{
				frmObject.p_report_id.value="PHRMEDOSSUM";
					}else
					{
				frmObject.p_report_id.value="PHRMEDOSDTL";
					}
				f_query_add_mod.document.formPhMednOrdStatCriteria.submit();
				
			}
		}
	}
	
}

function reset() {
	//Modified  on date 14-04-2009 for Medication Order Statistics By Dispense Location  because The common use of js
    //f_query_add_mod.formPhMednStatByPractCriteria.reset();
     f_query_add_mod.document.forms[0].reset(); //newly addded
    if(f_query_add_mod.document.getElementById("p_job_title")!=undefined||f_query_add_mod.document.getElementById("p_job_title")!=null)
     f_query_add_mod.document.getElementById("p_job_title").disabled=true;//Added for ML-BRU-SCF-1220
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function searchPractitionerName(target, mode) {

	var val = target.value;
	if(val=="" || val == null)
		val ="";
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var lan_id=f_query_add_mod.document.formPhMednOrdStatCriteria.p_language_id.value;
	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= f_query_add_mod.document.formPhMednOrdStatCriteria.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_add_mod.document.formPhMednOrdStatCriteria.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	var sql = "SELECT DISTINCT A.PRACTITIONER_ID CODE,B.PRACTITIONER_NAME DESCRIPTION FROM AM_PRACT_FOR_FACILITY A,AM_PRACTITIONER_LANG_VW B,SM_FACILITY_FOR_USER C WHERE A.PRACTITIONER_ID=B.PRACTITIONER_ID  AND C.FACILITY_ID=A.FACILITY_ID  AND UPPER(APPL_USER_ID)LIKE UPPER(?) AND UPPER(A.FACILITY_ID) LIKE UPPER(?)  AND A.PRACTITIONER_ID LIKE UPPER(?) AND UPPER(B.PRACTITIONER_NAME) LIKE UPPER(?) AND B.LANGUAGE_ID ="+"'"+lan_id+"'";
	argumentArray[0] = encodeURIComponent(sql);
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = val;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	retArray = CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );

	if(retArray != null && retArray != "") {
			if (mode == 1){
			f_query_add_mod.document.formPhMednOrdStatCriteria.pract_id.value = retArray[0];

		}
		else if (mode == 2){
			f_query_add_mod.document.formPhMednOrdStatCriteria.tpract_id.value = retArray[0];

		}
		target.value = retArray[1];
	}
	else{
		 if (mode == 1){
			f_query_add_mod.document.formPhMednOrdStatCriteria.pract_name.value ="";
		 }
	else if (mode == 2){
			f_query_add_mod.document.formPhMednOrdStatCriteria.tpract_name.value = "";

		}
	 }
}
function CustomerGroupSearch(target){ 
	var frmObject = parent.f_query_add_mod.document.formPhMednOrdStatCriteria;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var lan_id=frmObject.p_language_id.value;
	var customer_group_query="SELECT  CUST_GROUP_CODE CODE,SHORT_DESC DESCRIPTION FROM AR_CUST_GROUP_LANG_VW WHERE upper(CUST_GROUP_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) AND LANGUAGE_ID=";
	argumentArray[0] = customer_group_query+"'"+lan_id+"' ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] =target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.CustomerGroup.label","PH"), argumentArray );
	if(retVal != null && retVal != "") {
		frmObject.p_customer_group.value = retVal[1];
		frmObject.P_CUST_GROUP_CODE.value = retVal[0];
	}
}

function CustomerSearch(target){
	var frm_obj = parent.f_query_add_mod.document.formPhMednOrdStatCriteria;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var lan_id=frm_obj.p_language_id.value;
	var customer_query="SELECT CUST_CODE CODE,SHORT_NAME DESCRIPTION FROM AR_CUSTOMER_LANG_VW WHERE upper(CUST_CODE) like upper(?) and upper(SHORT_NAME) like upper(?) AND LANGUAGE_ID=";//added for MMS CRF-0105 end
	argumentArray[0] = customer_query+"'"+lan_id+"' ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( getLabel("Common.Customer.label","PH"), argumentArray );
	if(retVal != null && retVal != "") {
		frm_obj.p_customer.value = retVal[1];
		frm_obj.P_CUST_CODE.value = retVal[0];
	}
}

function locationSearch(obj)
{
	var val ="";
	if(obj==null || val == undefined)
		{
		val ="";
		}else
		{
			val =obj.value
		}
	var formObj = parent.f_query_add_mod.document.formPhMednOrdStatCriteria;
	var lan_id=formObj.p_language_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var lan_id=formPhMednOrdStatCriteria.p_language_id.value;
	var facility_id=formPhMednOrdStatCriteria.p_facility_id.value;
	var sql="select code, description,facility_id,eff_status,language_id from (SELECT clinic_code code, long_desc description,facility_id,eff_status,language_id,clinic_type  FROM op_clinic_lang_vw op_clinic   UNION  SELECT nursing_unit_code code, long_desc description,facility_id,eff_status,language_id,'C' clinic_type  FROM ip_nursing_unit_lang_vw ip_nursing_unit)WHERE  facility_id='#'  AND UPPER (code) LIKE UPPER (?)   AND UPPER (description) LIKE UPPER (?) AND eff_status = 'E' AND clinic_type ='C'  AND language_id ='$'";
	sql=sql.replace("$",lan_id);
	sql=sql.replace("#",facility_id);
	argumentArray[0]   =sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = val;
	argumentArray[6]   =  CODE_DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		formObj.p_locn_name.value = retVal[1] ;
		formObj.p_locn_code.value = retVal[0] ;
	}	
}
function SpecialistSearch(obj)
{ 

	var val ="";
	if(obj==null || val == undefined)
		{
		val ="";
		}else
			{
			val =obj.value
			}
	var formObj = parent.f_query_add_mod.document.formPhMednOrdStatCriteria;
	var lan_id=formObj.p_language_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var lan_id=formPhMednOrdStatCriteria.p_language_id.value;
	var sql="SELECT SPECIALITY_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_SPECIALITY_LANG_VW WHERE EFF_STATUS = 'E' AND UPPER(SPECIALITY_CODE) LIKE UPPER (?)AND UPPER (SHORT_DESC) LIKE UPPER (?) AND LANGUAGE_ID= '#' ORDER BY 2"
	sql=sql.replace("#",lan_id);
	
	argumentArray[0]   =sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = val;
	argumentArray[6]   =  CODE_DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var retVal = await CommonLookup( getLabel("Common.speciality.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		formObj.p_spec_desc.value = retVal[1] ;
		formObj.p_spec_code.value = retVal[0] ;
	}	
}


function selectBillingGroup(obj)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= formPhMednOrdStatCriteria.p_language_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3"; 
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK ;//CODE_LINK
	argumentArray[7] = DESC_CODE;//CODE_DESC
	retVal = CommonLookup(getLabel("Common.BillingGroup.label","Common"), argumentArray );
		
		if(retVal != null && retVal != "") {
 			obj.value = retVal[1] ;				
			formPhMednOrdStatCriteria.P_BLNG_GRP_ID.value = retVal[0];
		}else{
			obj.value ="";			
		}				
}


function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}

function ValidateFrom(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert(getMessage("SHOULD_BE_GREATER_THAN_CURRENT_TIME","PH"));
	to.select();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
        	to.select();
			result	=	false;
		}
	}

return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert(getMessage("SHOULD_BE_GREATER_THAN_FROM_TIME","PH"));
	to.select();
	to.focus();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH")+" + 1");
        	to.select();
			result	=	false;
			to.focus();
		}
	}

return result;
}

//To Check Date
function checkSysDate(from,to,systemdate)
{
	var frmObjectOfDispLocnCriteria = f_query_add_mod.document.formPhMednOrdStatCriteria;
	var locale=frmObjectOfDispLocnCriteria.language_id.value;
	var fromDate=convertDate(from.value,'DMY',locale,"en");
	var toDate =convertDate(to.value,'DMY',locale,"en");
	var message;
	//messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
	if(!doDateCheckAlert(fromDate,systemdate,0))
	{
	//alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
		message=getMessage("FROM_DATE_LESS_THAN_SYSDATE","PH");
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		from.select();
		from.focus();
		return false;
	}
	if(!doDateCheckAlert(toDate,systemdate,0))
	{
		//alert("To Should be Less than Sysdate");//For less then Sys date
		message=getMessage("TO_DATE_LESS_THAN_SYSDATE","PH");
         messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		to.select();
		to.focus();
		return false;
	}
    	if(!doDateCheck(fromDate,toDate,messageFrame))
	{
		//alert("To Should be Greater than From");//For less then Sys date
		message=getMessage("TO_DT_GR_EQ_FM_DT","PH");
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		to.select();
		to.focus();
		return false;
	}
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
	return true;
}

function callPatientLookup(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
		formObj.p_patient_id.focus();
     }
}
function callDrugSearch(obj) {
	var frm_obj = parent.f_query_add_mod.document.formPhMednOrdStatCriteria;
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		frm_obj.p_drug_code.value	=	arrCodeDesc[0]; 
		frm_obj.p_drug_name.value =	arrCodeDesc[1]; 
	}
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	} 
	return true;
}
