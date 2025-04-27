//Patient Search from common.js
function callPatientLookup(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
		formObj.p_patient_id.focus();
     }
}
function DateCheck(from,to) {

   /* var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
      			fromarray = fromdate.split("/");

			toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
						parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

                to.select();
                to.focus();
				return false;

                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }*/
	if(from.value=="" || to.value=="")
	{ 
		//alert("1");
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].P_LANGUAGE_ID.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}
    return true;
}
function validate_date(Obj,ref) {
                

	/*if (CheckDate1(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].p_disp_date_to;
	  to = document.forms[0].p_disp_date_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_disp_date_from;
	  to = document.forms[0].p_disp_date_to;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].p_disp_date_to;
	  to = document.forms[0].p_disp_date_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
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
					parent.f_query_results.document.location.href='../../eCommon/html/blank.html';
            from.select();
 		    from.focus();
			return false;
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}

	return true;
}*/
if(document.forms[0].p_disp_date_from.value=='' || document.forms[0].p_disp_date_to.value=='')
{ 
					return false;
}
else{
	if(!isBefore(document.forms[0].p_disp_date_from.value,document.forms[0].p_disp_date_to.value,"DMY",document.forms[0].P_LANGUAGE_ID.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
			alert(errors);
			return false;
			
	}
}
	return true;
}
function reset() {
		f_query_add_mod.document.forms[0].reset();
	    f_query_results.document.location.href='../../eCommon/html/blank.html';
	    messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//	return (event.keyCode -= 32);
	return true;
}
function resetLocation(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	formObj.locn_code.value="";
	formObj.locn_name.value="";
}
function locationLookup(target){
	var formObj = parent.f_query_add_mod.document.forms[0];

	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.P_LANGUAGE_ID.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label", "Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.P_LANGUAGE_ID.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = CommonLookup(getLabel("Common.Location.label", "Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
}
function searchPractitionerName(obj) {
	var val = obj.value;
	if(val=="" || val == null)
		val ="";

	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var lan_id=document.FormSRRPhBalMednSheet.P_LANGUAGE_ID.value;
	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= document.FormSRRPhBalMednSheet.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= document.FormSRRPhBalMednSheet.p_facility_id.value;
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
	returnedValues = CommonLookup(getLabel("Common.practitionerid.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
        	var formObj = parent.f_query_add_mod.document.forms[0];
			formObj.pract_code.value=returnedValues[0];
		     obj.value = returnedValues[1];
		}
}
function showResult(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var adr_reported_date_from="";
	var adr_reported_date_to ="";
	var locale = formObj.P_LANGUAGE_ID.value;
	var patient_id = formObj.p_patient_id.value;
	adr_reported_date_from = formObj.p_disp_date_from.value;
	adr_reported_date_from=convertDate(adr_reported_date_from,"DMY",locale); 
	adr_reported_date_to = formObj.p_disp_date_to.value;
	adr_reported_date_to=convertDate(adr_reported_date_to,"DMY",locale); 
	var prescription_id = formObj.prescription_id.value;
	var p_token_no = formObj.p_token_no.value;
	var p_encounter= formObj.encounter_id.value;
	var pract_code= formObj.pract_code.value;
	var p_disp_locn_code= formObj.p_disp_locn_code.value;
	var locn_type = formObj.locn_type.value;
	var locn_code = formObj.locn_code.value; 
	var fields = new Array (formObj.p_patient_id,formObj.p_disp_date_from,formObj.p_disp_date_to,formObj.p_disp_locn_code);
	var names= new Array (getLabel("Common.patientId.label","Common"),getLabel("ePH.DispenseDateFrom.label","PH"), getLabel("ePH.DispenseDateTo.label","PH"),getLabel("ePH.DispenseLocation.label","PH"));

	if(checkFields(fields,names,parent.messageFrame)) 
	{
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		if(!isBefore(formObj.p_disp_date_to.value,formObj.currentdate.value,"DMY",document.forms[0].P_LANGUAGE_ID.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
		}

		if(!isBefore(formObj.p_disp_date_from.value,formObj.p_disp_date_to.value,"DMY",document.forms[0].P_LANGUAGE_ID.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
		}
		/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		parent.f_query_results.location.href="../../ePH/jsp/SRRPhBalMednSheetQueryResult.jsp?patient_id="+patient_id+"&locale="+locale+"&adr_reported_date_from="+adr_reported_date_from+"&adr_reported_date_to="+adr_reported_date_to+"&p_token_no="+p_token_no+"&prescription_id="+prescription_id+"&pract_code="+pract_code+"&p_encounter="+p_encounter+"&p_disp_locn_code="+p_disp_locn_code+"&locn_type="+locn_type+"&locn_code="+locn_code;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}else{

		parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

	}

}


function SubmitLink(from,to,patient_id,adr_reported_date_from,adr_reported_date_to,prescription_id,p_token_no,p_encounter,pract_code,p_facility_id,p_disp_locn_code,locn_type,locn_code,locale){
	var obj=document.frames.SRRPhBalMednSheetQueryResult;
	
	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value=patient_id;
	obj.prescription_id.value=prescription_id;
	obj.adr_reported_date_from.value=adr_reported_date_from;
	obj.adr_reported_date_to.value=adr_reported_date_to;
	obj.p_token_no.value=p_token_no;
	obj.p_encounter.value=p_encounter;
	obj.pract_code.value=pract_code;
	obj.p_facility_id.value=p_facility_id;
	obj.p_disp_locn_code.value=p_disp_locn_code;
	obj.locn_type.value=locn_type;
	obj.locn_code.value=locn_code;
	obj.locale.value=locale;
	
	obj.submit();
}
function showPrintReport(p_facility_id,locale,disp_date,token_daily_seq_no,patient_id,prescription_id,disp_locn_code){


if(escape(token_daily_seq_no) =='%A0') token_daily_seq_no='';
	
	var formObj = parent.f_query_add_mod.document.forms[0];
	
	formObj.p_report_id.value = "PHPRBALMS";
	formObj.p_facility_id.value =p_facility_id ;
	formObj.P_DISP_DATE.value =convertDate(disp_date,"DMY","en"); 
	formObj.p_TOKEN_no.value =token_daily_seq_no;
	formObj.P_ORDER_ID.value = prescription_id;
	formObj.P_disp_locn_code.value =disp_locn_code;
	formObj.P_PATIENT_ID.value =patient_id;
	
    parent.f_query_add_mod.document.forms[0].submit();
}
function CheckDate1(Object2,focusflag) {

	 var datefield = Object2;
	if (Object2.value != undefined)
    {
		Object2 = Object2.value;
    }
	else
	{
		Object2 = Object2;
	}


    if (ChkDate(Object2) == false) {
        alert(getMessage("INVALID_DATE_FMT", "SM"));
		parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

        if (datefield.value != undefined && focusflag == null)
        {
            datefield.select();
            datefield.focus();
        }
        return false;
    }
    else {
        return true;
    }
}

//Date Validations====== corrected on 9-mar-10 regarding Site issue
function validateDate(){
	var formObj = document.frames.FormSRRPhBalMednSheet;
	
	if (formObj.p_disp_date_from.value!="" && formObj.p_disp_date_to.value!=""){
		if(!doDateCheck(formObj.p_disp_date_from,formObj.p_disp_date_to,parent.messageFrame)){
			formObj.p_disp_date_to.select();
			formObj.p_disp_date_to.value='';
		}else{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}
