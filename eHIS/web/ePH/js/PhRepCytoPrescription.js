  //saved on 02.11.2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

function reset() {
	f_query_add_mod.frmCytoPrescriptionQueryCriteria.reset();
    f_query_add_mod.frmCytoPrescriptionQueryCriteria.btnPatientID.disabled=false;
	f_query_results.location.href="../../eCommon/html/blank.html";
	f_query_status.location.href="../../eCommon/html/blank.html";
}
// This will call common patient search
function callPatientSearch(){

	var formObj=document.frames.frmCytoPrescriptionQueryCriteria;
	var patient_id = PatientSearch();
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
		xmlHttp.open( "POST", "PhRepPrintPrescriptionValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;		
		eval(xmlHttp.responseText);
	}
}

// This is to assign nationality and Health CardNo based on patient id
function assignNationalityHealthCardNo(nationality,healthCardNo){
	var formObj = document.frames.frmCytoPrescriptionQueryCriteria;
	formObj.nationality.value=nationality;
	if(healthCardNo=='null'){		
		healthCardNo="";
	}
	formObj.healthCardNo.value=healthCardNo;
}


function validateDate(){
	var formObj = document.frames.frmCytoPrescriptionQueryCriteria;
	if (formObj.order_date_from.value!="" && formObj.order_date_to.value!=""){
		if(!doDateCheck(formObj.order_date_from,formObj.order_date_to,parent.messageFrame)){
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

	var formObj = document.frames.frmCytoPrescriptionQueryCriteria;
	var patient_id      = formObj.patient_id.value ;
	var orig_order_id   = formObj.order_id.value;
	var order_date_from = formObj.order_date_from.value;
	var order_date_to   = formObj.order_date_to.value;
	var encounter_id    = formObj.encounter_id.value;	
	var pres_practitioner_id = formObj.practitioner_id.value;	
	var locn_type=formObj.locn_type.value;
	var locn_code=formObj.locn_code.value;
	var iv_type=formObj.iv_type.value;
		
	if(patient_id !="" || orig_order_id != ""){
		if(iv_type!="" ){
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		parent.f_query_results.location.href="../../ePH/jsp/PhRepCytoPrescripResult.jsp?patient_id="+patient_id+"&orig_order_id="+orig_order_id+"&order_date_from="+order_date_from+"&encounter_id="+encounter_id+"&pres_practitioner_id="+pres_practitioner_id+"&locn_type="+locn_type+"&locn_code"+locn_code+"&iv_type="+iv_type;
		parent.f_query_status.location.href="../../ePH/jsp/PhRepPrintPrescriptionStatus.jsp";
		}else{
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=APP-PH0073 CYTO_Type can't be blank";
		}
	}else{
		
		if(formObj.order_id.value == "" && formObj.patient_id.value == "" ){
			parent.f_query_results.location.href="../../eCommon/html/blank.html";
			parent.f_query_status.location.href="../../eCommon/html/blank.html";	parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PRES_NO_OR_PATIENT_ID_NOT_BLANK") ;
			formObj.order_id.focus();
		}		
	}
} else {

	var formObj = document.frames.frmCytoPrescriptionQueryCriteria;

	var patient_id      = formObj.patient_id.value ;
	var orig_order_id   = formObj.order_id.value;
	var order_date_from = formObj.order_date_from.value;
	var order_date_to   = formObj.order_date_to.value;
	var encounter_id    = formObj.encounter_id.value;	
	var pres_practitioner_id = formObj.practitioner_id.value;	
	var locn_type=formObj.locn_type.value;
	var locn_code=formObj.locn_code.value;

		parent.f_query_results.location.href="../../ePH/jsp/PhRepCytoPrescriptionResult.jsp?patient_id="+patient_id+"&orig_order_id="+orig_order_id+"&order_date_from="+order_date_from+"&encounter_id="+encounter_id+"&pres_practitioner_id="+pres_practitioner_id+"&locn_type="+locn_type+"&locn_code"+locn_code;
		parent.f_query_status.location.href="../../ePH/jsp/PhRepPrintPrescriptionStatus.jsp";
	}
}

function SubmitLink(from,to,patient_id,orig_order_id,order_date_from,order_date_to,encounter_id,pres_practitioner_id){
	var obj=document.frames.frmCytoPrescriptionReportResult;
	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value=patient_id;
	obj.order_id.value=orig_order_id;
	obj.order_date_from.value=order_date_from;
	obj.order_date_to.value=order_date_to;
	obj.encounter_id.value=encounter_id;
	obj.pres_practitioner_id.value=pres_practitioner_id;
	obj.submit();
}

function locationLookup(target){
	var formObj = document.frames.frmCytoPrescriptionQueryCriteria;
	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( "", argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( "", argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
}

function resetLocation(){
	var formObj = document.frames.frmCytoPrescriptionQueryCriteria;
	formObj.locn_code.value="";
	formObj.locn_name.value="";
}

function showReportPrescription(order_id,patient_id,encounter_id,patient_class,locn_code,iv_type){
	var dialogHeight= "10" ;
	var dialogWidth	= "33" ;
	var dialogTop = "200" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = window.showModalDialog("../../ePH/jsp/PhRepPrintIVPrescriptionWindow.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&locn_code="+locn_code+"&iv_type="+iv_type,arguments,features);
}

function showReport(){

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
		xmlHttp.open( "POST", "PhRepPrintPrescriptionWindowTemp.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
		xmlHttp.send( xmlDoc ) ;
	//	alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
		parent.window.close();
}

function submitTheWindow() {
	document.frmPrintPrescriptionReportWindow.submit();
}
function showPrintReport(order_id,patient_class,locn_code,iv_type){

	var formObj = parent.f_query_add_mod.frmCytoPrescriptionQueryCriteria;

	formObj.p_fm_order_id.value = order_id ;
	formObj.p_to_order_id.value = order_id ;
	formObj.p_patclass.value = patient_class; 
	formObj.p_locncode.value = locn_code;
	formObj.p_iv_prep_yn.value = iv_type;

	parent.f_query_add_mod.frmCytoPrescriptionQueryCriteria.submit(); 

}
//added on 12.09.2005
function validate_date(Obj,ref) {
                

	if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].order_date_to;
	  to = document.forms[0].order_date_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].order_date_from;
	  to = document.forms[0].order_date_to;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].order_date_to;
	  to = parent.frames[1].document.forms[0].order_date_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT');
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
}
}

function DateCheck(from,to) {

    var fromarray;
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
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE") ;
                alert(invaldt);
                to.select();
                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
}
