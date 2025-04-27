/*

--------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100               ?          		created
01/07/2014   MMS-QH-CRF-0108   SureshKumar T    Pharmacy Management->PH Reports->Consumption by Doctor ? Report Criteria
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

function searchPractitionerName(obj) {
	var val = obj.value;
	if(val=="" || val == null)
		val ="";

	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	var lan_id=document.formDrugConsumCriteria.p_language_id.value;
	
	//var sql = "SELECT DISTINCT A.PRACTITIONER_ID CODE,B.PRACTITIONER_NAME DESCRIPTION FROM AM_PRACT_FOR_FACILITY A,AM_PRACTITIONER_LANG_VW B,SM_FACILITY_FOR_USER C WHERE A.PRACTITIONER_ID=B.PRACTITIONER_ID  AND C.FACILITY_ID=A.FACILITY_ID  AND UPPER(APPL_USER_ID)LIKE UPPER(?) AND UPPER(A.FACILITY_ID) LIKE UPPER(?)  AND A.PRACTITIONER_ID LIKE UPPER(?) AND UPPER(B.PRACTITIONER_NAME) LIKE UPPER(?) AND B.LANGUAGE_ID ="+"'"+lan_id+"'";

	var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG WHERE PRACTITIONER_ID LIKE UPPER(?) AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND LANGUAGE_ID = " ;//Added for INC 50493 

	argumentArray[0] = sql+"'"+lan_id+"'"+" ORDER BY 2";//Added for INC 50493 
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = val;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.practitionerid.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		//obj.value = returnedValues[1];
		document.formDrugConsumCriteria.pract_name.value=returnedValues[1];
		document.formDrugConsumCriteria.p_pract_id.value=returnedValues[0];
	}
}

function CheckDateT(obj){
	
	var locale=document.formDrugConsumCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.value="";
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}


function DateCheck(from,to) {
	var fromarray;
	var toarray;
	var fromdate =from.value;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
	fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)){
			var invaldt = getMessage("FROM_DATE_LESS_THAN_SYSDATE","PH") ;
			alert(invaldt);
			to.value="";
			to.focus();
			return false;
		}
		else if(Date.parse(todt) <= Date.parse(fromdt)){		
			validate_date(to,'TO_DATE_LESS_FROM');
			return true;
		}
   
	}
	return true;
}
function validate_date(Obj,ref) {
	
	if (CheckDate(Obj)){
		if(ref == "TO_DT_GR_EQ_FM_DT"){
			from = document.forms[0].dt_to;
			to = document.forms[0].from_dt;
			error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
		}
		else if(ref == "TO_DT_GR_EQ_FM_DT1"){
			from = document.forms[0].from_dt;
			to = document.forms[0].dt_to;
			error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
		}
		else if(ref == "TO_DATE_LESS_FROM"){
			from = parent.frames[1].document.forms[0].p_date_to;
			to = parent.frames[1].document.forms[0].p_date_from;
			error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
		}
		
		var fromarray;
		var toarray;
		var fromdate = eval(from).value ;
		var todate = eval(to).value ;
		
		if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) > Date.parse(fromdt)) {	
				alert(error_id);
				from.value="";
				from.focus();
				return true ;
			}
			
		}
		
		return true;
	}
}

function run() {
	var frmObject = f_query_criteria.document.formDrugConsumCriteria;
	messageFrame.location.href="../../eCommon/jsp/error.jsp?" ; 
	if(frmObject.p_date_from.value==""){
		alert(getLabel("Common.fromdate.label","Common")+" "+getLabel("Common.Cannotbeblank.label","Common"));
		frmObject.p_date_from.focus();
		return false;
			
	}
	else if(frmObject.p_date_to.value==""){
		alert(getLabel("Common.todate.label","Common")+" "+getLabel("Common.Cannotbeblank.label","Common"));
		frmObject.p_date_to.focus();
		return false;
	}
	else if(!isBefore(frmObject.p_date_from.value,frmObject.currentdate.value,"DMY",frmObject.p_language_id.value)){
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	else{
		var locale = frmObject.locale.value;
		frmObject.p_date_from.value=convertDate(frmObject.p_date_from.value,'DMY',locale,"en");
		frmObject.p_date_to.value=convertDate(frmObject.p_date_to.value,'DMY',locale,"en");
	}
	if(frmObject.pract_name.value=="")
		 frmObject.p_pract_id.value="";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="";
	xmlStr ="<root><SEARCH " ;
	xmlStr		+= "bean_id  ='PHReportsBean' " ;
	xmlStr		+= "bean_name = 'ePH.PHReportsBean' " ;
	xmlStr		+= "p_date_from=\""+ frmObject.p_date_from.value + "\" ";
	xmlStr		+= "p_date_to=\""+ frmObject.p_date_to.value + "\" ";
	xmlStr		+= "p_patient_class=\""+ frmObject.P_patient_class.value + "\" ";
	xmlStr		+= "p_pract_id=\""+ frmObject.p_pract_id.value + "\" ";
	xmlStr		+= "p_locn_code=\""+ frmObject.p_spec_code.value + "\" ";
	xmlStr		+= "p_cust_grp_frm_code=\""+ frmObject.p_cust_grp_frm_code.value + "\" ";
	xmlStr		+= "p_cust_grp_to_code=\""+ frmObject.p_cust_grp_to_code.value + "\" ";
	xmlStr		+= "p_cust_frm_code=\""+ frmObject.p_cust_frm_code.value + "\" ";
	xmlStr		+= "p_policy_type_code=\""+ frmObject.p_policy_type_code.value + "\" ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReportsValidate.jsp?called_from=ReportConsumptionByDoctor", false ) ;
	xmlHttp.send( xmlDoc ) ;
	var recCount=eval(xmlHttp.responseText);
	if(recCount!="0"){
		frmObject.pract_name.value="";//added for MMS-QH-CRF-0108/04[IN:050530] 
		frmObject.submit();
		frmObject.p_pract_id.value="";//added for MMS-QH-CRF-0108/04[IN:050530]
	}
	else{
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA", "PH"));
		// messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("NO_RECORD_FOUND_FOR_CRITERIA","PH");
	}
}		


function AllowDateFormat(){
	var key = window.event.keyCode;
	if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
		return false;
	}
}

function reset() {
	f_query_criteria.formDrugConsumCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
