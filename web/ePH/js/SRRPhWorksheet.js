function reset() {
	f_query_add_mod.SRRPhWorksheetChartForm.reset();
    f_query_results.location.href	="../../eCommon/html/blank.html";
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
function showResults(){
	
	 var formObj = parent.f_query_add_mod.document.forms[0];
	var fr_dispdate="";
	var to_dispdate ="";

	var locale = formObj.p_language_id.value;
	var report_by = formObj.report_by.value;
	var p_facility_id = formObj.p_facility_id.value;
	var p_wrksheet_id = formObj.p_wrksheet_id.value;
	var patient_id = formObj.p_patient_id.value;
	var p_pres_id = formObj.p_pres_id.value;
	var p_tokfr = formObj.p_tokfr.value;

	
	var p_tokto = formObj.p_tokto.value;
	var p_encounter= formObj.p_encounter.value;

	var p_pract_id = formObj.p_pract_id.value;
	var p_disp_locn_code = formObj.p_disp_locn_code.value;
	var p_locn_type = formObj.p_locn_type.value;

	var p_locn_code = formObj.locn_code.value;


	var from_date = formObj.from_date.value;
	fr_dispdate=convertDate(from_date,"DMY",locale); 
	var to_date = formObj.to_date.value;
	to_dispdate=convertDate(to_date,"DMY",locale); 
//Addedd=================================================================================

if(document.forms[0].from_date.value!='' && document.forms[0].to_date.value!='')
{ 
	
	if(!isBefore(formObj.to_date.value,formObj.currentdate.value,"DMY",document.forms[0].p_language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
	}

    if(!isBefore(formObj.from_date.value,formObj.to_date.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
	}
}
//Ends==============================================================

	var fields = new Array (formObj.report_by,formObj.from_date,formObj.to_date,formObj.p_disp_locn_code);
	var names= new Array (getLabel("ePH.TypeofOrder.label","PH"),getLabel("ePH.DispensedDateFrom.label","PH"), getLabel("ePH.DispensedDateTo.label","PH"),getLabel("ePH.DispenseLocation.label","PH"));

	if(checkFields(fields,names,parent.messageFrame)) 
	{
			
		if(parent.f_query_add_mod.CheckString("Token No./Daily Seq No", parent.f_query_add_mod.document.SRRPhWorksheetChartForm.p_tokfr,parent.f_query_add_mod.document.SRRPhWorksheetChartForm.p_tokto, parent.messageFrame) )					
				{

		if(doDateCheck(formObj.from_date,formObj.to_date,parent.messageFrame) )		parent.f_query_results.location.href="../../ePH/jsp/SRRPhWorksheetChartResult.jsp?patient_id="+patient_id+"&locale="+locale+"&fr_dispdate="+fr_dispdate+"&to_dispdate="+to_dispdate+"&p_pres_id="+p_pres_id+"&p_pract_id="+p_pract_id+"&p_disp_locn_code="+p_disp_locn_code+"&p_locn_type="+p_locn_type+"&p_encounter="+p_encounter+"&p_tokto="+p_tokto+"&p_tokfr="+p_tokfr+"&p_wrksheet_id="+p_wrksheet_id+"&report_by="+report_by+"&p_locn_code="+p_locn_code+"&p_facility_id="+p_facility_id;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
				}
	}else{
	parent.f_query_results.location.href='../../eCommon/html/blank.html';
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

	var lan_id=document.SRRPhWorksheetChartForm.p_language_id.value;
	

	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= document.SRRPhWorksheetChartForm.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= document.SRRPhWorksheetChartForm.p_facility_id.value;
	dataTypeArray[1]	= STRING ;


	// AND	A.INSTRN_CODE  LIKE UPPER(?) AND UPPER(A.INSTRN_TEXT)	LIKE UPPER(?) 



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
		obj.value = returnedValues[0];
	}
}
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
                to.select();
                to.focus();

                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }*/
	
	if(from.value=="" || to.value=="")
	{ 
		//alert("1");
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}
    return true;
}
function validate_date(Obj,ref) {
                

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].to_date;
	  to = document.forms[0].from_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].from_date;
	  to = document.forms[0].to_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].to_date;
	  to = document.forms[0].from_date;
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
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}*/
if(document.forms[0].from_date.value=='' || document.forms[0].to_date.value=='')
{ 
					return false;
}
else{
if(!isBefore(document.forms[0].from_date.value,document.forms[0].to_date.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
			alert(errors);
			return false;
			
	}
}
	return true;
}
function reset() {
		f_query_add_mod.document.forms[0].reset();
		f_query_results.document.location.href="../../eCommon/html/blank.html"
	    messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

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

	var lan_id=document.SRRPhWorksheetChartForm.p_language_id.value;
	

	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= document.SRRPhWorksheetChartForm.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= document.SRRPhWorksheetChartForm.p_facility_id.value;
	dataTypeArray[1]	= STRING ;


	// AND	A.INSTRN_CODE  LIKE UPPER(?) AND UPPER(A.INSTRN_TEXT)	LIKE UPPER(?) 



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
		obj.value = returnedValues[0];
	}
}

function resetLocation(){
	var formObj = document.frames.SRRPhWorksheetChartForm;
	formObj.locn_code.value="";
	formObj.p_locn_code.value="";
}

function locationLookup(target){
	var formObj = document.frames.SRRPhWorksheetChartForm;
	var p_locn_type=formObj.p_locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (p_locn_type!=""){
		if (p_locn_type=="N"){
			argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} 
		}else if (p_locn_type=="C"){
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup(  getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
		}
	}else{
		formObj.p_locn_type.focus()
	}
}

function SubmitLink(from,to,patient_id,p_wrksheet_id,p_pres_id,fr_dispdate,to_dispdate,p_encounter,p_pract_id,p_facility_id,p_disp_locn_code,p_tokfr,p_tokto,p_locn_type,p_locn_code){
	var obj=document.frames.SRRPhWorksheetChartResult;
	
	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value=patient_id;
	obj.p_wrksheet_id.value=p_wrksheet_id;
	obj.p_pres_id.value=p_pres_id;
	obj.fr_dispdate.value=fr_dispdate;
	obj.to_dispdate.value=to_dispdate;
	obj.p_encounter.value=p_encounter;
	obj.p_pract_id.value=p_pract_id;
	obj.p_facility_id.value=p_facility_id;
	obj.p_disp_locn_code.value=p_disp_locn_code;
	obj.p_tokfr.value=p_tokfr;
	obj.p_tokto.value=p_tokto;
	obj.p_locn_type.value=p_locn_type;
	obj.p_locn_code.value=p_locn_code;
	
	obj.submit();
}
function showPrintReport(worksheet_id,report_type){

	var repStage = document.forms[0].repStage.value;

	var formObj = parent.f_query_add_mod.SRRPhWorksheetChartForm;

	formObj.p_worksheet_id.value = worksheet_id ;
	
	
		if(report_type == "IV" || report_type == "CYTO" || report_type == "CMP")
		{
			if(repStage=='D'){
			formObj.p_report_id.value = "PHBRWRKSH1" ;
			}
			else{
				formObj.p_report_id.value = "PHBRWRKSH1" ;
			}

		}
		else  if(report_type == "TPN")
		{
			formObj.p_report_id.value = "PHBRWRKTP" ;
		}

		
	parent.f_query_add_mod.document.SRRPhWorksheetChartForm.submit();


}
