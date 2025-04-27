function populateTokenSeries(facility_id,disp_locn_code)
{
	bean_id		=	document.formSRRPhIssueTokenCriteria.bean_id.value;
	bean_name	=	document.formSRRPhIssueTokenCriteria.bean_name.value;

	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
	xmlStr += " disp_locn_code=\""+disp_locn_code+"\"";
	xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=POPULATE_TOKEN_SERIES",false);
	xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
	
}
function clearList()	{
		
    var len			= document.formSRRPhIssueTokenCriteria.p_token_series_code.options.length;
	for(var i=0;i<len;i++) {
		document.formSRRPhIssueTokenCriteria.p_token_series_code.remove("p_token_series_code") ;
	}


	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ; 
	opt.text = tp ;
	opt.value = "" ;
	document.formSRRPhIssueTokenCriteria.p_token_series_code.add(opt);
}
function addList(code,desc)	{ 
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.formSRRPhIssueTokenCriteria.p_token_series_code.add(element);
	
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
function DateCheck(from,to) {

    /*var fromarray;
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
//ADDED=======================================================================================	
if(from.value=="" || to.value=="")
	{ 
		//alert("1");
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}
	//=========================================================================================
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
	return true;*/
	/*if(!isBefore(document.forms[0].p_disp_date_from.value,document.forms[0].p_disp_date_to.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
			alert(errors);
			return false;
			
	}*/
	//===================================================================================================
	if(document.forms[0].p_disp_date_from.value=='' || document.forms[0].p_disp_date_to.value=='')
{ 
					return false;
}
	else{
		if(!isBefore(document.forms[0].p_disp_date_from.value,document.forms[0].p_disp_date_to.value,"DMY",document.forms[0].language_id.value)) {
			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				return false;
	}
			

}
	return true;
	//====================================================================================================
}

//Patient Search from common.js
function callPatientLookup(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
		formObj.p_patient_id.focus();
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
	var lan_id=document.formSRRPhIssueTokenCriteria.language_id.value;
	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= document.formSRRPhIssueTokenCriteria.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= document.formSRRPhIssueTokenCriteria.P_FACILITY_ID.value;
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
function reset() {
		f_query_add_mod.document.forms[0].reset();
	    f_query_results.document.location.href='../../eCommon/html/blank.html';
	    messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
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
			argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.language_id.value+"'";
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
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.language_id.value+"'";
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
		}
	}else{
		formObj.locn_type.focus()
	}
}
function showResults()
{

		var formObj = parent.f_query_add_mod.document.forms[0];
		//var adr_reported_date_from="";
		//var adr_reported_date_to ="";
		var locale = formObj.language_id.value;
		var patient_id = formObj.p_patient_id.value;
		var p_disp_date_from = formObj.p_disp_date_from.value;
		var p_disp_date_from=convertDate(p_disp_date_from,"DMY",locale); 
		p_disp_date_to = formObj.p_disp_date_to.value;
		p_disp_date_to=convertDate(p_disp_date_to,"DMY",locale); 
		var p_token_series_code = formObj.p_token_series_code.value;
		var p_token_no = formObj.p_token_no.value;
		var p_disp_locn_code = formObj.p_disp_locn_code.value;
		var prescription_id= formObj.prescription_id.value;
		var encounter_id = formObj.encounter_id.value;
		var pract_code = formObj.pract_code.value;
		var locn_type = formObj.locn_type.value;
		var locn_code = formObj.locn_code.value;
		var p_langue = formObj.p_langue.value;
		if(document.forms[0].p_disp_date_from.value!='' && document.forms[0].p_disp_date_to.value!='')
{ 
					
	if(!isBefore(formObj.p_disp_date_to.value,formObj.currentdate.value,"DMY",document.forms[0].language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
	}

    if(!isBefore(formObj.p_disp_date_from.value,formObj.p_disp_date_to.value,"DMY",document.forms[0].language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
	}
}
//=====================================================================================================================	

		
		parent.f_query_results.location.href="../../ePH/jsp/SRRPhIssueTokenQueryResult.jsp?patient_id="+patient_id+"&locale="+locale+"&p_disp_date_from="+p_disp_date_from+"&p_disp_date_to="+p_disp_date_to+"&p_token_series_code="+p_token_series_code+"&p_token_no="+p_token_no+"&p_disp_locn_code="+p_disp_locn_code+"&prescription_id="+prescription_id+"&encounter_id="+encounter_id+"&pract_code="+pract_code+"&locn_type="+locn_type+"&locn_code="+locn_code+"&p_langue="+p_langue;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";

}
function showPrintReport(p_facility_id,locale,patient_id,disp_locn_code,token_series_code,token_no,queue_date,order_id){
	var formObj = parent.f_query_add_mod.document.forms[0];
    formObj.P_FACILITY_ID.value = p_facility_id ;
	formObj.p_language_id.value = locale;
	formObj.P_PATIENT_ID.value = patient_id;
	formObj.P_TOKEN_SERIES_CODE.value = token_series_code;
	formObj.P_DISP_LOCN_CODE.value = disp_locn_code;
	formObj.p_QUEUE_DATE.value =convertDate(queue_date,"DMY","en"); 
	formObj.P_SERIAL_NO.value = token_no;
	formObj.P_ORDER_ID.value = order_id;
	formObj.p_report_id.value = "PHBREGPR";

	
	parent.f_query_add_mod.document.forms[0].submit();
}
function SubmitLink(from,to,p_token_no,p_token_series_code,p_patient_id,p_disp_date_from,p_disp_date_to,encounter_id,pract_code,p_disp_locn_code,locn_type,locn_code,prescription_id,p_langue){

	var obj=document.frames.SRRPhIssueTokenQueryResult;
	obj.from.value=from;
	obj.to.value=to;
	obj.p_patient_id.value=p_patient_id;
	obj.p_token_series_code.value=p_token_series_code;
	obj.p_token_no.value=p_token_no;
	obj.p_disp_locn_code.value=p_disp_locn_code;
	obj.prescription_id.value=prescription_id;
	obj.p_disp_date_from.value=p_disp_date_from;
	obj.p_disp_date_to.value=p_disp_date_to;
	obj.encounter_id.value=encounter_id;
	obj.locn_type.value=locn_type;
	obj.locn_code.value=locn_code;
	obj.pract_code.value=pract_code;
	obj.p_langue.value=p_langue;
	obj.submit();
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
