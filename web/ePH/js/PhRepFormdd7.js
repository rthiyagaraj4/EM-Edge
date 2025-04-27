//saved on 02.11.2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/PhFormdd7Criteria.jsp";	
}

function run(){  
	//alert("Inside Run");
}	

function reset(obj) {
	//alert("Inside Reset");
	f_query_add_mod.PhRepPrescriptionCriteriaForm.reset();
	f_query_add_mod.PhRepPrescriptionCriteriaForm.btnPatientID.disabled=false;
	f_query_results.location.href="../../eCommon/html/blank.html";
	f_query_status.location.href="../../eCommon/html/blank.html";
}
//***********************************callPatientSearch function starts*********************************
// This will call common patient search
async function callPatientSearch(){
	var formObj=document.PhRepPrescriptionCriteriaForm;
	var patient_id =await PatientSearch();
	if (patient_id!= "" && patient_id != undefined){
		formObj.patient_id.value = patient_id;
		formObj.patient_id.disabled = true;
		formObj.btnPatientID.disabled = true;
		//alert(formObj.patient_id.value);

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PhRepPrescriptionValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		//alert(xmlHttp.responseText)
		eval(xmlHttp.responseText);
	}
}// End of callPatientSearch function.

// This is to assign nationality and Health CardNo based on patient id
function assignNationalityHealthCardNo(nationality,healthCardNo){
	//alert("inside assignNationalityHealthCardNo");
	var formObj = document.PhRepPrescriptionCriteriaForm;
	formObj.nationality.value=nationality;
	//alert("nationality-->" +formObj.nationality.value);
	if(healthCardNo=='null'){		
		healthCardNo="";
	}
	
	formObj.healthCardNo.value=healthCardNo;
} //End





//********************** showResults func starts************************
function showResults(pat_id){
	//alert("Inside showResults");
	

if(pat_id=="") {
	if (!validateDate())
	{
		//alert("chking !validateDate");
		return;
	}

	var formObj = document.PhRepPrescriptionCriteriaForm;
	var patient_id      = formObj.patient_id.value ;
	var orig_order_id   = formObj.order_id.value;
	var order_date_from = formObj.order_date_from1.value;
	var order_date_to   = formObj.order_date_to1.value;
	var encounter_id    = formObj.encounter_id.value;	
	var pres_practitioner_id = formObj.practitioner_id.value;	
	var locn_type=formObj.locn_type.value;
	var locn_code=formObj.locn_code.value;
	var order_type=formObj.order_type.value;
	var order_by=formObj.order_by.value;
	//alert("order_date_to---->" +order_date_to.value)
	//alert("order_date_from---->" +order_date_from.value)
	
	
	if(patient_id !="" || orig_order_id != ""){
		//alert("chking patient_id not equal to null");
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		parent.f_query_results.location.href="../../ePH/jsp/PhRepFormdd7Result.jsp?patient_id="+patient_id+"&orig_order_id="+orig_order_id+"&order_date_from="+order_date_from+"&encounter_id="+encounter_id+"&pres_practitioner_id="+pres_practitioner_id+"&locn_type="+locn_type+"&locn_code="+locn_code+"&order_type="+order_type+"&order_date_to="+order_date_to+"&order_by="+order_by;
		parent.f_query_status.location.href="../../ePH/jsp/PhRepPrescriptionStatus.jsp";
		
	}else{
		//alert("chking else part");
		if(formObj.order_id.value == "" && formObj.patient_id.value == "" ){
			//alert("chking patient_id not equal to null");
			//parent.f_query_results.location.href="../../eCommon/html/blank.html";
			//parent.f_query_status.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PRES_NO_OR_PATIENT_ID_NOT_BLANK","PH") ;
			formObj.order_id.focus();
			
		}		
	}
} else {

	var formObj = document.PhRepPrescriptionCriteriaForm;

	var patient_id      = formObj.patient_id.value ;
	var orig_order_id   = formObj.order_id.value;
	var order_date_from = formObj.order_date_from1.value;
	var order_date_to   = formObj.order_date_to1.value;
	//alert("order_date_to in else---->" +formObj.order_date_to1.value)
	//alert("order_date_from---->" +formObj.order_date_from1.value)
	var encounter_id    = formObj.encounter_id.value;	
	var pres_practitioner_id = formObj.practitioner_id.value;	
	var locn_type=formObj.locn_type.value;
	var locn_code=formObj.locn_code.value;
	var order_type=formObj.order_type.value;
	var order_by=formObj.order_by.value;

	parent.f_query_results.location.href="../../ePH/jsp/PhRepFormdd7Result.jsp?patient_id="+patient_id+"&orig_order_id="+orig_order_id+"&order_date_from="+order_date_from+"&encounter_id="+encounter_id+"&pres_practitioner_id="+pres_practitioner_id+"&locn_type="+locn_type+"&locn_code="+locn_code+"&order_type="+order_type+"&order_date_to="+order_date_to+"&order_by="+order_by;
	parent.f_query_status.location.href="../../ePH/jsp/PhRepPrescriptionStatus.jsp";
}
}  //End of showResults func.

//********************* validateDate func starts **********************/
function validateDate(){
	
	var formObj = document.PhRepPrescriptionCriteriaForm;
/*	alert("formObj--->" +formObj.name);
	alert("order_date_to---->" +formObj.order_date_to1.value)
	alert("order_date_from---->" +formObj.order_date_from1.value)*/
	if (formObj.order_date_from1.value!="" && formObj.order_date_to1.value!=""){
		if(!doDateCheck(formObj.order_date_from1,formObj.order_date_to1,parent.messageFrame)){
			formObj.order_date_to1.select();
			return false;
		}else{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		
		}
	}
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	return true;
}  // Ends validateDate func.




//****************** locationLookup function starts**********************
async function locationLookup(target){
	//alert("Inside locationLookup");
	var formObj = document.PhRepPrescriptionCriteriaForm;
	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0]	="LANGUAGE_ID";
	dataValueArray[0]	=formObj.p_language_id.value;
	//alert(formObj.p_language_id.value);
	dataTypeArray[0]	=STRING;
	if (locn_type!=""){
		if (locn_type=="N"){
			//argumentArray[0]   = document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value;
			argumentArray[0]   = "SELECT NURSING_UNIT_CODE code, SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW  WHERE  LANGUAGE_ID LIKE ? AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND EFF_STATUS='E' ";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "2,3";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( "", argumentArray );
			var str =unescape(retVal);
			var arr = str.split(",");
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=arr[0];
				target.value = arr[1] ;
			} 
		}else if (locn_type=="C"){
			//argumentArray[0]   =  document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value;
			argumentArray[0]   =  "SELECT CLINIC_CODE code, SHORT_DESC description FROM OP_CLINIC_LANG_VW  WHERE  LANGUAGE_ID LIKE ? AND UPPER(CLINIC_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND EFF_STATUS='E'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "2,3";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( "", argumentArray );
			var str =unescape(retVal);
			var arr = str.split(",");
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=arr[0];
				target.value = arr[1] ;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
} //End locationLookup func.

//************************************resetLocation function starts*************
function resetLocation(){
	//alert("Inside resetLocation");
	var formObj = document.PhRepPrescriptionCriteriaForm;
	formObj.locn_code.value="";
	formObj.locn_name.value="";
} //end of resetLocation func.

async function showReportPrescription(order_id,patient_id,encounter_id,patient_class,locn_code){
	//alert("Inside showReportPrescription");
	var dialogHeight= "10" ;
	var dialogWidth	= "33" ;
	var dialogTop = "200" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal =await window.showModalDialog("../../ePH/jsp/PhRepPrescriptionWindow.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&locn_code="+locn_code,arguments,features);
}

function showReport(){
//alert("showReport");
//	document.frmPrintPrescriptionReportWindow.submit();
//../../eCommon/jsp/report_options.jsp

		var bean_id		= document.frmPrintPrescriptionReportWindow.bean_id.value ;
		var bean_name	= document.frmPrintPrescriptionReportWindow.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		
		xmlStr	="<root><SEARCH " ;
		xmlStr += "p_order_id=\""+ document.frmPrintPrescriptionReportWindow.p_order_id.value +"\" " ;
		xmlStr += "p_patclass=\""+ document.frmPrintPrescriptionReportWindow.p_patclass.value +"\" " ;
		xmlStr += "p_locncode=\""+ document.frmPrintPrescriptionReportWindow.p_locncode.value +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
//		alert(xmlStr);
		xmlHttp.open( "POST", "PhRepPrescriptionWindowTemp.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
		xmlHttp.send( xmlDoc ) ;
	//	alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
		parent.window.close();
}

function submitTheWindow() {
	document.frmPrintPrescriptionReportWindow.submit();
}











// ******************** showPrintReport function starts ******************
function showPrintReport(order_id,patient_class,locn_code,order_type,patient_id,order_line_no){
	//alert("Inside showPrintReport");
	
	var formObj = parent.f_query_add_mod.PhRepPrescriptionCriteriaForm;

	formObj.p_order_id.value = order_id ;
	formObj.p_order_id1.value = order_id ;
	formObj.p_patclass.value = patient_class;
	formObj.p_locncode.value = locn_code;
	formObj.p_patient_id.value = patient_id;
	/*alert("formObj.p_order_id.value--->" +formObj.p_order_id.value);
	alert("formObj.p_order_id1.value--->" +formObj.p_order_id1.value);
	alert("formObj.p_patclass.value--->" +formObj.p_patclass.value);
	alert("formObj.p_locncode.value--->" +formObj.p_locncode.value);
	alert("formObj.p_patient_id.value--->" +formObj.p_patient_id.value);*/
  //  formObj.p_order_line_no = order_line_no;

	var report_id="";

	/*if(order_type=="")
	{
		if(patient_class == 'IP'||patient_class == 'DC')
	       report_id="PHBOPPRS_IP";
		else if(patient_class == 'OP'||patient_class == 'EM')
			report_id = "PHBOPPRS";
	}
	else if(order_type=="5")
	{
		report_id="PHPRDPRESIVCONT";
	}
    else if(order_type=="1")
	{
		report_id="PHPRDPRESIVCONT";
	}
    else if(order_type=="2")
	{
		report_id="PHPRDPRESIVCONT";
	}
	else if(order_type=="3")
	{
		report_id="PHPRDPRESIVCONT";
	}
	else if(order_type=="4")
	{
		report_id="PHPRDPRESIVCONT";
	}
	else if(order_type=="6")
	{
		report_id="PHPRDPRESCOMP";
	}
	else if(order_type=="7")
	{
		report_id="PHBOPPTPN";
	}
	else if(order_type=="8")
	{
		report_id="PHBOPPTPN";
	}
	else if(order_type=="9")
	{
		report_id="PHBOPPCYTO";
	}
	else if(order_type=="0")
	{
		report_id="PHBOPPCYTO";
	}
*/

		//report_id="PHBFMDD7";
		report_id="PHBFMDD7";
    //formObj.p_iv_prep_yn.value=order_type;
    formObj.p_report_id.value=report_id;
	parent.f_query_add_mod.PhRepPrescriptionCriteriaForm.submit();

} // End 







//********************Validate_Date function starts***************************
function validate_date(Obj,ref) {
	//alert("inside validate_date");
                

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].order_date_to1;
	  to = document.forms[0].order_date_from1;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].order_date_from1;
	  to = document.forms[0].order_date_to1;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH' );
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].order_date_to1;
	  to = parent.frames[1].document.forms[0].order_date_from1;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT', 'PH');
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

if(document.forms[0].order_date_from1.value=='' || document.forms[0].order_date_to1.value=='')
{ 
					return false;
}
	else{
		if(!isBefore(document.forms[0].order_date_from1.value,document.forms[0].order_date_to1.value,"DMY",document.forms[0].p_language_id.value)) {
		
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				return false;
	}
			

}

	return true;
}  //End of Validate_date function.

//******************Datecheck function starts************************************
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

            if(Date.parse(todt) > Date.parse(fromdt)) {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
                to.select();
                to.focus();
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }*/
	if(from.value=="" || to.value==""){ 
		//alert("1");
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			to.select();
			return false;
		}
	}
    return true;
}//end Date chk function.

// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.PhRepPrescriptionCriteriaForm.p_language_id.value;
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
 
function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.PhRepPrescriptionCriteriaForm.patient_id.value; 
	if( (patientId != null) && (patientId !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;	
		xmlStr+= "chkPatientID=\"false\" " ;
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}	
} 

function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.PhRepPrescriptionCriteriaForm.patient_id.value=main_patientid;  
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
