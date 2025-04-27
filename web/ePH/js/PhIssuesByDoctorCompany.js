/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100               ?          		created
20/08/2014   MMS-QH-CRF-0112   SureshKumar T    Pharmacy Management->PH Reports->Issues by Doctor / Company ? Report Criteria
14/06/2021	 MOHE-SCF-0115   Prabha		 MOHE-SCF-0115
------------------------------------------------------------------------------------------------------------------------------
*/ 
function searchPractitionerName(obj) {
	var val = obj.value;
	if(val=="" || val == null)
		val ="";
	var frmObj = document.formIssuesByDoctor;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG WHERE PRACTITIONER_ID LIKE UPPER(?) AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND LANGUAGE_ID = " ; 
	var lan_id=frmObj.p_language_id.value;
	argumentArray[0] = sql+"'"+lan_id+"'"+" ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = val;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;
	retArray = CommonLookup(getLabel("Common.practitionerid.label","Common"), argumentArray );

	if(retArray != null && retArray != "" ){
		document.formIssuesByDoctor.pract_name.value=retArray[1];
		document.formIssuesByDoctor.p_practitioner_id.value=retArray[0];
	}
	else{
		obj.value = "";
		obj.focus();
	}
}

function CheckDateT(obj){
	
	var locale=document.formIssuesByDoctor.p_language_id.value;
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

function validateDate(){
	var formObj = document.formIssuesByDoctor;
	if (formObj.doc_from_date.value!="" && formObj.doc_to_date.value!=""){
		if(!doDateCheck(formObj.dt_from_disp,formObj.doc_to_date,parent.messageFrame)){
			formObj.doc_to_date.select();
		}
		else{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}

function run() {
	var frmObject = f_query_criteria.document.formIssuesByDoctor;
	messageFrame.location.href="../../eCommon/jsp/error.jsp?" ;
	var locale = frmObject.locale.value;
	if(frmObject.doc_from_date.value==""){
		alert(getLabel("Common.fromdate.label","Common")+" "+getLabel("Common.Cannotbeblank.label","Common"));
		frmObject.doc_from_date.focus();
		return false;
	}
	if(frmObject.doc_to_date.value==""){
		alert(getLabel("Common.todate.label","Common")+" "+getLabel("Common.Cannotbeblank.label","Common"));
		frmObject.doc_to_date.focus();
		return false;
	}
	if(!isBefore(frmObject.doc_from_date.value,frmObject.currentdate.value,"DMY",frmObject.p_language_id.value)){
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	if(!isBefore(frmObject.doc_from_date.value,frmObject.doc_to_date.value, "DMY",locale)){ // Added for MMS-QH-CRF-0112[IN:051240]
		alert(getMessage("FROM_DATE_LESS_EQ_TO_DT", "PH"));
		frmObject.doc_from_date.value='';
		frmObject.doc_from_date.focus();
		return false;
	}
	
	frmObject.p_doc_from_date.value=convertDate(frmObject.doc_from_date.value,'DMY',locale,"en");
	frmObject.p_doc_to_date.value=convertDate(frmObject.doc_to_date.value,'DMY',locale,"en");
	
	if(frmObject.pract_name.value=="")
		frmObject.p_practitioner_id.value="";
	frmObject.pract_name.value="";
	if(frmObject.reportType.value =="S")	 
		frmObject.p_report_id.value ="PHISSBYDOCSUM";
	else
		frmObject.p_report_id.value ="PHISSBYDOCDTL";
	frmObject.submit();
}		

function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
	   return false;
   }
}

function reset() {
    f_query_criteria.formIssuesByDoctor.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function  callDispLocSearch(obj){
	var val = obj.value;
	if(val=="" || val == null)
		val ="";
	var facility_id = document.formIssuesByDoctor.p_facility_id.value;
	var language_id    = document.formIssuesByDoctor.p_language_id.value;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = facility_id;
	dataTypeArray[0]   = STRING ;
	//argumentArray[0]   = document.formIssuesByDoctor.SQL_PH_DISP_LOCN_LANG_VW_SELECT.value+"'"+language_id+"'";
	var sql_ph_disp_locn_lang_vw_select = "SELECT A.DISP_LOCN_CODE code,SHORT_DESC description FROM PH_disp_locn_lang_vw A WHERE  A.FACILITY_ID LIKE ? AND upper(DISP_LOCN_CODE) LIKE upper(?) AND upper(SHORT_DESC )LIKE upper(?) AND A.DISP_LOCN_TYPE='P' and a.language_id='"+language_id+"' "; //Added for MOHE-SCF-0115
	argumentArray[0] = sql_ph_disp_locn_lang_vw_select; //Added for MOHE-SCF-0115
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = val ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	returnedValues = CommonLookup(getLabel("ePH.DispenseLocation.label","PH"), argumentArray );

	if(returnedValues != null && returnedValues != "" ){
		document.formIssuesByDoctor.disp_location.value=returnedValues[1];
		document.formIssuesByDoctor.p_disp_locn_id.value=returnedValues[0];
	}
	else{
		obj.value = "";
		obj.focus();
	}
}