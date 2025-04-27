function reset() {
		f_query_add_mod.document.forms[0].reset();
		f_query_results.document.location.href="../../eCommon/html/blank.html"
	    messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

}
function showResults(){
	 var formObj = parent.f_query_add_mod.document.forms[0];
	var fr_dispdate="";
	var to_dispdate ="";

	var locale = formObj.language_id.value;
	var p_type_ord = formObj.p_type_ord.value;
	var p_facility_id = formObj.p_facility_id.value;
	var p_wrksheet_id = formObj.p_wrksheet_id.value;
	var patient_id = formObj.p_patient_id.value;
	var p_pres_id = formObj.p_pres_id.value;
	var p_tokfr = formObj.p_tokfr.value;

	
	var p_tokto = formObj.p_tokto.value;
	var p_encounter= formObj.p_encounter.value;

	var p_pract_id = formObj.p_pract_id.value;
	var p_disp_locn = formObj.p_disp_locn.value;
	var p_locn_type = formObj.p_locn_type.value;

	var p_locn_code = formObj.locn_code.value;

	var p_fr_disp_date = formObj.p_fr_disp_date.value;
	fr_dispdate=convertDate(p_fr_disp_date,"DMY",locale); 
	var p_to_disp_date = formObj.p_to_disp_date.value;
	to_dispdate=convertDate(p_to_disp_date,"DMY",locale); 
	//ADDEdd======================
	if(document.forms[0].p_fr_disp_date.value!='' && document.forms[0].p_to_disp_date.value!='')
{ 
		if(!isBefore(formObj.p_to_disp_date.value,formObj.currentdate.value,"DMY",document.forms[0].language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
		}

		if(!isBefore(formObj.p_fr_disp_date.value,formObj.p_to_disp_date.value,"DMY",document.forms[0].language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
		}	
}
		//Ends==============================================================================
	
	var fields = new Array (formObj.p_type_ord,formObj.p_fr_disp_date,formObj.p_to_disp_date,formObj.p_disp_locn);
	var names= new Array (getLabel("ePH.TypeofOrder.label","PH"),getLabel("ePH.DispensedDateFrom.label","PH"), getLabel("Common.todate.label","Common"),getLabel("ePH.DispenseLocation.label","PH"));

	if(checkFields(fields,names,parent.messageFrame)) 

		
	{    	

		if(parent.f_query_add_mod.CheckString("Token No./Daily Seq No", parent.f_query_add_mod.document.SRRPhManufacturinglblForm.p_tokfr,parent.f_query_add_mod.document.SRRPhManufacturinglblForm.p_tokto, parent.messageFrame) )					
				{



		//if(formObj.CheckString("Token No./Daily Seq No",formObj.p_tokfr,formObj.p_tokto, parent.messageFrame)){
		if(doDateCheck(formObj.p_fr_disp_date,formObj.p_to_disp_date,parent.messageFrame) )		parent.f_query_results.location.href="../../ePH/jsp/SRRPhManufacturinglabelResult.jsp?patient_id="+patient_id+"&locale="+locale+"&fr_dispdate="+fr_dispdate+"&to_dispdate="+to_dispdate+"&p_pres_id="+p_pres_id+"&p_pract_id="+p_pract_id+"&p_disp_locn="+p_disp_locn+"&p_locn_type="+p_locn_type+"&p_encounter="+p_encounter+"&p_tokto="+p_tokto+"&p_tokfr="+p_tokfr+"&p_wrksheet_id="+p_wrksheet_id+"&p_type_ord="+p_type_ord+"&p_locn_code="+p_locn_code+"&p_facility_id="+p_facility_id;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		}
	}else{
	parent.f_query_results.location.href='../../eCommon/html/blank.html';
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
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].language_id.value)) {
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
	  from = document.forms[0].p_to_disp_date;
	  to = document.forms[0].p_fr_disp_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_fr_disp_date;
	  to = document.forms[0].p_to_disp_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].p_to_disp_date;
	  to = document.forms[0].p_fr_disp_date;
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
if(document.forms[0].p_fr_disp_date.value=='' || document.forms[0].p_to_disp_date.value=='')
{ 
					return false;
}
else{
		if(!isBefore(document.forms[0].p_fr_disp_date.value,document.forms[0].p_to_disp_date.value,"DMY",document.forms[0].language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
			alert(errors);
			return false;
			
		}
}
	return true;
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

	var lan_id=document.SRRPhManufacturinglblForm.p_language_id.value;
	

	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= document.SRRPhManufacturinglblForm.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= document.SRRPhManufacturinglblForm.p_facility_id.value;
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
	var formObj = document.frames.SRRPhManufacturinglblForm;
	formObj.locn_code.value="";
	formObj.p_locn_code.value="";
}

function locationLookup(target){
	var formObj = document.frames.SRRPhManufacturinglblForm;
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

			var retVal = await CommonLookup(  getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} 
		}else if (p_locn_type=="C"){
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.language_id.value+"'";
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

function SubmitLink(from,to,patient_id,p_wrksheet_id,p_pres_id,fr_dispdate,to_dispdate,p_encounter,p_pract_id,p_facility_id,p_disp_locn,p_tokfr,p_tokto,p_locn_type,p_locn_code){
	var obj=document.frames.SRRPhManufacturinglabelResult;
	
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
	obj.p_disp_locn.value=p_disp_locn;
	obj.p_tokfr.value=p_tokfr;
	obj.p_tokto.value=p_tokto;
	obj.p_locn_type.value=p_locn_type;
	obj.p_locn_code.value=p_locn_code;
	
	obj.submit();
}
function showPrintReport(worksheet_id,report_type){

	var formObj = parent.f_query_add_mod.SRRPhManufacturinglblForm;

	formObj.p_worksheet_id.value = worksheet_id;
	
	
		if(report_type == "IV" )
		{
			formObj.p_report_id.value = "PHBRMFGLB" ;
		}
		else  if(report_type == "CYTO")
		{
			formObj.p_report_id.value = "PHCYTOMFGLB" ;
		}
		else  if(report_type == "CMP")
		{
			formObj.p_report_id.value = "PHCPMFGLB" ;
		}
		else  if(report_type == "TPN")
		{
			formObj.p_report_id.value = "PHBRWRKTP" ;
		}

		
	parent.f_query_add_mod.document.SRRPhManufacturinglblForm.submit();


}



