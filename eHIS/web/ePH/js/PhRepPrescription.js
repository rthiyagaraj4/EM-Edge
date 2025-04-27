/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name			Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
31/3/2021		TFS:15977			Shazana											NMC-JD-SCF-0160
---------------------------------------------------------------------------------------------------------
*/      

//saved on 02.11.2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/PhRepPrescriptionCriteria.jsp";	
}

/*function run()
{  
	
//	alert(parent.name);
	if(parent.f_query_add_mod != undefined || 	 parent.f_query_add_mod!= null)
	{
	var frmObject = parent.f_query_add_mod.document.frmPrescriptionQueryCriteria;
	}else  {
	var frmObject = f_query_add_mod.document.frmPrescriptionQueryCriteria;
	}
//	var formObj = parent.f_query_add_mod.frmPrescriptionQueryCriteria;

	var order_id =	frmObject.p_order_id.value  ;
	var patient_class =frmObject.p_patclass.value  ;
	var locn_code =frmObject.p_locncode.value  ;

	frmObject.p_report_id.value = "PHBOPPRS" ;
	frmObject.submit();
  }	*/


function reset(obj) {
	f_query_add_mod.PhRepPrescriptionCriteriaForm.reset();
	f_query_add_mod.PhRepPrescriptionCriteriaForm.btnPatientID.disabled=false;
	f_query_results.location.href="../../eCommon/html/blank.html";
	f_query_status.location.href="../../eCommon/html/blank.html";
	
}
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
// This will call common patient search
async function callPatientSearch(){

	var formObj=document.PhRepPrescriptionCriteriaForm;
	var patient_id = await PatientSearch();
	if (patient_id!= "" && patient_id != undefined){

		formObj.patient_id.value = patient_id;
		formObj.patient_id.disabled = true;
		formObj.btnPatientID.disabled = true;

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PhRepPrescriptionValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;		
		eval(xmlHttp.responseText);
	}
}

// This is to assign nationality and Health CardNo based on patient id
function assignNationalityHealthCardNo(nationality,healthCardNo){
	var formObj = document.PhRepPrescriptionCriteriaForm;
	formObj.nationality.value=nationality;
	
	if(healthCardNo=='null'){		
		healthCardNo="";
	}
	
	formObj.healthCardNo.value=healthCardNo;
}


function validateDate(){
	var formObj = document.PhRepPrescriptionCriteriaForm;
	if (formObj.order_date_from.value!="" && formObj.order_date_to.value!=""){
		if(!doDateCheck(formObj.order_date_from,formObj.order_date_to,parent.messageFrame)){
			formObj.order_date_to.value="";
			formObj.order_date_to.select();
			return false;
		}else{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		
		}
	}
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	return true;
}

function showResults(pat_id){
	

if(pat_id=="") {
	if (!validateDate())
	{
		return;
	}

	var formObj			= document.PhRepPrescriptionCriteriaForm;
	var locale			= formObj.language_id.value;
	var patient_id      = formObj.patient_id.value ;
	var orig_order_id   = formObj.order_id.value;
	var order_date_from = convertDate(formObj.order_date_from.value,'DMY',locale,"en");
	var order_date_to	= convertDate(formObj.order_date_to.value,'DMY',locale,"en");
//	var order_date_to   = formObj.order_date_to.value;
	var encounter_id    = formObj.encounter_id.value;	
	var pres_practitioner_id = formObj.practitioner_id.value;	
	var locn_type=formObj.locn_type.value;
	var locn_code=formObj.locn_code.value;
	var order_type=formObj.order_type.value;
	var ordby=formObj.lstOrderBy.value;
	
	if(patient_id !="" ){
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		parent.f_query_results.location.href="../../ePH/jsp/PhRepPrescriptionResult.jsp?patient_id="+patient_id+"&orig_order_id="+orig_order_id+"&order_date_from="+order_date_from+"&encounter_id="+encounter_id+"&pres_practitioner_id="+pres_practitioner_id+"&locn_type="+locn_type+"&locn_code="+locn_code+"&order_type="+order_type+"&order_date_to="+order_date_to+"&order_by="+ordby;
		parent.f_query_status.location.href="../../ePH/jsp/PhRepPrescriptionStatus.jsp";
	}else{
		
		if( formObj.patient_id.value == "" ){
			parent.f_query_results.location.href="../../eCommon/html/blank.html";
			parent.f_query_status.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PATIENT_ID_REQUIRED","PH") ;
			formObj.order_id.focus();
		}		
	}
} else {
	

	var formObj = document.PhRepPrescriptionCriteriaForm;

	var patient_id      = formObj.patient_id.value ;
	var orig_order_id   = formObj.order_id.value;
	var order_date_from = formObj.order_date_from.value;
	var order_date_to   = formObj.order_date_to.value;
	var encounter_id    = formObj.encounter_id.value;	
	var pres_practitioner_id = formObj.practitioner_id.value;	
	var locn_type=formObj.locn_type.value;
	var locn_code=formObj.locn_code.value;
	var order_type=formObj.order_type.value;
	parent.f_query_results.location.href="../../ePH/jsp/PhRepPrescriptionResult.jsp?patient_id="+patient_id+"&orig_order_id="+orig_order_id+"&order_date_from="+order_date_from+"&encounter_id="+encounter_id+"&pres_practitioner_id="+pres_practitioner_id+"&locn_type="+locn_type+"&locn_code="+locn_code+"&order_type="+order_type+"&order_date_to="+order_date_to;
	parent.f_query_status.location.href="../../ePH/jsp/PhRepPrescriptionStatus.jsp";
}
}

function SubmitLink(from,to,patient_id,orig_order_id,order_date_from,order_date_to,encounter_id,pres_practitioner_id,order_type,ordby){
	var obj=document.PhRepPrescriptionResultForm;
	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value=patient_id;
	obj.order_id.value=orig_order_id;
	obj.order_date_from.value=order_date_from;
	obj.order_date_to.value=order_date_to;
	obj.encounter_id.value=encounter_id;
	obj.pres_practitioner_id.value=pres_practitioner_id;
	obj.order_type.value=order_type;
	obj.order_by.value=ordby;
	obj.submit();
}

async function locationLookup(target){
	var formObj = document.PhRepPrescriptionCriteriaForm;
	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql_ph_print_prescription_select1= "SELECT CLINIC_CODE code, SHORT_DESC description FROM OP_CLINIC_LANG_VW OP_CLINIC  WHERE  UPPER(CLINIC_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND EFF_STATUS='E' AND LANGUAGE_ID = ";// added for 15977 start
	var sql_ph_print_prescription_select2= "SELECT NURSING_UNIT_CODE code, SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW IP_NURSING_UNIT  WHERE  UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND EFF_STATUS='E' AND LANGUAGE_ID = ";//end  
	if (locn_type!=""){
		if (locn_type=="N"){
			//argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.language_id.value+"'";//commented for 15977
			argumentArray[0]   = escape(sql_ph_print_prescription_select2)+"'"+formObj.language_id.value+"'"; //added for 15977
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray ); //Modified for MOHE-ICN-0006 
			var ret1=unescape(retVal);
		 	arr=ret1.split(",");
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=arr[0];
				target.value = arr[1] ;
			} 
		}else if (locn_type=="C"){
		//	argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.language_id.value+"'";//commented for 15977
			argumentArray[0]   =  escape(sql_ph_print_prescription_select1)+"'"+formObj.language_id.value+"'"; //15977
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup(  getLabel("Common.Location.label","Common"), argumentArray );//Modified for MOHE-ICN-0006  
			var ret1=unescape(retVal);
		 	arr=ret1.split(",");
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=arr[0];
				target.value = arr[1] ;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
}

function resetLocation(){
	var formObj = document.PhRepPrescriptionCriteriaForm;
	formObj.locn_code.value="";
	formObj.locn_name.value="";
}

async function showReportPrescription(order_id,patient_id,encounter_id,patient_class,locn_code){
	var dialogHeight= "400px";
	var dialogWidth	= "700px";
	var dialogTop = "200" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/PhRepPrescriptionWindow.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&locn_code="+locn_code,arguments,features);
}

function showReport(){

//	document.frmPrintPrescriptionReportWindow.submit();f
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
		parent.document.getElementById('dialog_tag').close();  
		//parent.window.close();
}

function submitTheWindow() {
	document.frmPrintPrescriptionReportWindow.submit();
}

function showPrintReport(order_id,patient_class,locn_code,order_type){
	
	var formObj = parent.f_query_add_mod.PhRepPrescriptionCriteriaForm;

	formObj.p_order_id.value = order_id ;
	formObj.p_order_id1.value = order_id ;
	formObj.p_patclass.value = patient_class;
	formObj.p_locncode.value = locn_code;

	var report_id="";

	if(order_type=="")
	{
		if(patient_class == 'IP'||patient_class == 'DC')
	       report_id="PHBOPPRS_IP";
		else if(patient_class == 'OP'||patient_class == 'EM')
			report_id = "PHBOPPRS";
		else if(patient_class == 'XT')//added for 52625
			report_id = "PHBOPPEX";
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
	else if(order_type=="9" || order_type=="0" || order_type=="C"){
		report_id="PHBOPPCYTO";
	}
	/*else if(order_type=="0")
	{
		report_id="PHBOPPCYTO";
	}*/

    formObj.p_iv_prep_yn.value=order_type;
    formObj.p_report_id.value=report_id;
    //console.log(parent);
   // console.log(parent.f_query_add_mod.PhRepPrescriptionCriteriaForm);
    var msgframe = "";
	if(top.document.getElementById('dialog-body'))
	{
		msgframe=top.document.getElementById('dialog-body').contentWindow.messageFrame;
		msgframe.name="messageframe1";
		msgframe="messageframe1";
	}
	else
		msgframe="messageframe";
	parent.f_query_add_mod.PhRepPrescriptionCriteriaForm.target=msgframe;
	parent.f_query_add_mod.PhRepPrescriptionCriteriaForm.submit();

}

function validate_date(Obj,ref) {
  //alert(" Obj======>" +Obj.value);             

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].order_date_to;
	  to = document.forms[0].order_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].order_date_from;
	  to = document.forms[0].order_date_to;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].order_date_to;
	  to = parent.frames[1].document.forms[0].order_date_from;
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
//ADDEd
//alert("document.forms[0].order_date_from.value=====" +document.forms[0].order_date_from.value);
//alert("document.forms[0].order_date_to.value=====" +document.forms[0].order_date_to.value);
/*if(!isBefore(document.forms[0].order_date_from.value,document.forms[0].order_date_to.value,"DMY",document.forms[0].p_language_id.value)) {
			//alert("2");
			if(document.forms[0].order_date_to.value=='')
			{
				return false;
			}
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
			alert(errors);
			return false;
			
	}*/
	if(document.forms[0].order_date_from.value=='' || document.forms[0].order_date_to.value==''){ 
		return false;
	}
	else{
		if(!isBefore(document.forms[0].order_date_from.value,document.forms[0].order_date_to.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			alert(errors);
			document.forms[0].order_date_from.slect();
			return false;
		}
	}
	return true;
}


function DateCheck(from,to) {
////alert("from=====>" +from.value);
//alert("to=====>" +to.value);
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
    }
	*/
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
}
 
function Duplicatecheck(){ /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */  
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
