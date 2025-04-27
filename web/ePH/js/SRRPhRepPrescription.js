  //saved on 02.11.2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
function query(){
	//f_query_add_mod.location.href="../../ePH/jsp/PhRepPrescriptionCriteria.jsp";	
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
// This will call common patient search
function callPatientSearch(){

	var formObj=document.frames.PhRepPrescriptionCriteriaForm;
	var patient_id = PatientSearch();
	if (patient_id!= "" && patient_id != undefined){

		formObj.patient_id.value = patient_id;
		formObj.patient_id.disabled = true;
		formObj.btnPatientID.disabled = true;

	
	}

	
}




function validateDate(){
	var formObj = document.frames.PhRepPrescriptionCriteriaForm;
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


	bean_id		  =	parent.f_query_add_mod.document.forms[0].bean_id.value;
	bean_name       =	parent.f_query_add_mod.document.forms[0].bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=CLEAR",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText); 

if(pat_id=="") {
	if (!validateDate())
	{
		return;
	}

	var formObj			= document.frames.PhRepPrescriptionCriteriaForm;
	var locale			= formObj.language_id.value;
	var patient_id      = formObj.patient_id.value ;
	var orig_order_id   = formObj.order_id.value;
	var order_date_from = convertDate(formObj.order_date_from.value,'DMY',locale,"en");
	var order_date_to	= convertDate(formObj.order_date_to.value,'DMY',locale,"en");
	var encounter_id    = formObj.encounter_id.value;	
	var pract_code = formObj.pract_code.value;	
	var p_token_no = formObj.p_token_no.value;	
	var locn_type=formObj.locn_type.value;
	var locn_code=formObj.locn_code.value;
	var order_type=formObj.order_type.value;
	
		//if(patient_id !="" || orig_order_id != ""){ Removed if-else condition for the incident num----21808(Pat-Id cannot be blank) on 9/jun/2010
			
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		parent.f_query_results.location.href="../../ePH/jsp/SRRPhRepPrescriptionResult.jsp?patient_id="+patient_id+"&orig_order_id="+orig_order_id+"&order_date_from="+order_date_from+"&encounter_id="+encounter_id+"&pract_code="+pract_code+"&p_token_no="+p_token_no+"&locn_type="+locn_type+"&locn_code="+locn_code+"&order_type="+order_type+"&order_date_to="+order_date_to;
		parent.f_query_status.location.href="../../ePH/jsp/SRRPhRepPrescriptionStatus.jsp";
	/*}
	else{
		
		return false;
		/*if(formObj.order_id.value == "" && formObj.patient_id.value == "" ){
			parent.f_query_results.location.href="../../eCommon/html/blank.html";
			parent.f_query_status.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PRES_ID_OR_PATIENT_ID_NOT_BLANK","PH") ;
			formObj.order_id.focus();
		}		
	}*/
} else {
	

	var formObj = document.frames.PhRepPrescriptionCriteriaForm;

	var patient_id      = formObj.patient_id.value ;
	var orig_order_id   = formObj.order_id.value;
	var order_date_from = formObj.order_date_from.value;
	var order_date_to   = formObj.order_date_to.value;
	var encounter_id    = formObj.encounter_id.value;	
	var pract_code = formObj.pract_code.value;	 
	var p_token_no = formObj.p_token_no.value;	
	var locn_type=formObj.locn_type.value;
	var locn_code=formObj.locn_code.value;
	var order_type=formObj.order_type.value;
	parent.f_query_results.location.href="../../ePH/jsp/SRRPhRepPrescriptionResult.jsp?patient_id="+patient_id+"&orig_order_id="+orig_order_id+"&order_date_from="+order_date_from+"&encounter_id="+encounter_id+"&pract_code="+pract_code+"&p_token_no="+p_token_no+"&locn_type="+locn_type+"&locn_code="+locn_code+"&order_type="+order_type+"&order_date_to="+order_date_to;
	parent.f_query_status.location.href="../../ePH/jsp/SRRPhRepPrescriptionStatus.jsp";
}
}

function SubmitLink(from,to,patient_id,orig_order_id,order_date_from,order_date_to,encounter_id,pract_code,order_type){
	var obj=document.frames.PhRepPrescriptionResultForm;
	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value=patient_id;
	obj.order_id.value=orig_order_id;
	obj.order_date_from.value=order_date_from;
	obj.order_date_to.value=order_date_to;
	obj.encounter_id.value=encounter_id;
	obj.pract_code.value=pract_code;
	obj.order_type.value=order_type;
//	obj.order_by.value=ordby;
	obj.submit();
}

function locationLookup(target){
	var formObj = document.frames.PhRepPrescriptionCriteriaForm;
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

			var retVal = CommonLookup(getLabel("Common.Location.label", "Common"), argumentArray );
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

function resetLocation(){
	var formObj = document.frames.PhRepPrescriptionCriteriaForm;
	formObj.locn_code.value="";
	formObj.locn_name.value="";
}

async function showReportPrescription(order_id,patient_id,encounter_id,patient_class,locn_code){
	var dialogHeight= "40vh" ;
	var dialogWidth	= "63vw" ;
	var dialogTop = "200" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/PhRepPrescriptionWindow.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&locn_code="+locn_code,arguments,features);
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
		xmlHttp.open( "POST", "PhRepPrescriptionWindowTemp.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
		xmlHttp.send( xmlDoc ) ;
	//	alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
		parent.window.close();
}

function submitTheWindow() {
	document.frmPrintPrescriptionReportWindow.submit();
}

function show_Print(order_type,order_id,patient_id,func_name){

		
	 if(func_name=="CR") {
		showCurrent(order_type,order_id,'','','IP',patient_id);
	}
}
async function showCurrent(order_type,order_id,encounter_id,order_date,pat_class,patient_id){

		//var formObj			= 	parent.f_query_results.PhRepPrescriptionResultForm;
//alert(order_type);
   
	encounter_id = "DUMMYENCOUNTERID";
	var dialogHeight	= "40vh" ;
	var dialogWidth		= "70vw" ;
	var dialogTop		= "250" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				= await window.showModalDialog("../../ePH/jsp/SRRPrescriptionActiveOrderDetailsFrame.jsp?order_type="+order_type+"&orderid="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_frm=PH&order_date="+order_date+"&patient_class="+pat_class,arguments,features);
}

function validate_date(Obj,ref) {
                

	/*if (CheckDate1(Obj))
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

	if(document.forms[0].order_date_from.value=='' || document.forms[0].order_date_to.value=='')
{ 
					return false;
}
	else{
		if(!isBefore(document.forms[0].order_date_from.value,document.forms[0].order_date_to.value,"DMY",document.forms[0].p_language_id.value)) {
			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				return false;
	}
			

}
	return true;
}


function DateCheck(from,to) {
	
	//alert("to.value===352==" +to.value+ "from.value====" +from.value);
	if(from.value=="" || to.value=="")
	{ 
		//alert("1");
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].language_id.value)) {
	
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		to.select();
		return false;
	}
	}
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
	var lan_id=document.PhRepPrescriptionCriteriaForm.p_language_id.value;
	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= document.PhRepPrescriptionCriteriaForm.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= document.PhRepPrescriptionCriteriaForm.p_facility_id.value;
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

async function showReasons(allergy,dosage,duplicate) {
//alert("showReasons---->");
	var dialogHeight="";
	if(allergy!="" && dosage!="" && duplicate!="")
		dialogHeight= "40vh" ;
	else if ( (allergy!=""  && dosage!="") || (allergy!="" && duplicate!="") || (dosage!="" && duplicate!=""))
		dialogHeight= "33vh" ;
	else
		dialogHeight= "30vh" ;

	var dialogWidth	= "38vw" ;
	var dialogTop = "285" ;
	var dialogLeft ="300";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionDrugReasons.jsp?allergy="+allergy+"&dosage="+dosage+"&duplicate="+duplicate,arguments,features);
}
async function callFreqDet(patient_id,encounter_id,order_id,order_line_no,freq_desc,start_date) {
	//alert("callFreqDet---->");

	var dialogHeight= "34vh";
	var dialogWidth	= "54vw" ;
	var dialogTop = "360" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionFreqFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&freq_desc="+freq_desc+"&start_date="+unescape(start_date),arguments,features);
}
function callDiagText(patient_id,encounter_id,called_frm) {
	//alert("callDiagText---->");


	var dialogHeight= "10";
	var dialogWidth	= "34" ;
	var dialogTop = "169" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = window.showModalDialog("../../ePH/jsp/PrescriptionDiagTextFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_frm="+encodeURIComponent(called_frm),arguments,features);
}
function chkall(formObject) {
		 var checked_yn ="N";

	var prescription_id = "";
	var order_line_no = "";

	var max_cnt = formObject.max_cnt;
	var allElements = formObject.elements;
	var ischecked = formObject.selectall_yn.checked;
	for (i = 1; i < allElements.length; i++) {
		if (allElements[i].type == "checkbox") {
			objName = allElements[i].name;	
			allElements[i].checked = ischecked;

			         index = objName.substring(objName.lastIndexOf("_yn")+3,objName.length);
		   pre_id = eval("document.PrescriptionActiveOrderDetailsForm.prescription_"+index).value;
              if (prescription_id == "")
								prescription_id =pre_id;
			else
				prescription_id =prescription_id+"@"+pre_id; 


		 }
		}
		

    if (formObject.selectall_yn.checked)
	{
	  	 mode = "ADD_ELEMENT_ALL";

	}else{
	//	checked_yn ="N";
	//	this.value = "N";
		mode = "REMOVE_ELEMENT_ALL"
	   }

  	bean_id		   =	   document.forms[0].bean_id.value;
	bean_name       =	document.forms[0].bean_name.value;
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";	
	xmlStr += " prescription_id=\""+prescription_id+"\"";
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=RECORDS_FOR_PRESCRIPTION",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	

}
function assignValue(obj){
	if(obj.checked==true){
		obj.value = "Y";
	}else{
		obj.value = "N";
	}
} 

function Printforpre(formobj,facility_id){
        	
		headerObj=parent.document.frames[0].PrescriptionActiveOrderDetailsForm


	orderid=headerObj.orderid.value
	order_type=headerObj.order_type.value
	//	alert(order_type);
	var allElements = headerObj.elements;
	var cnt = 0;
	for (i = 1; i < allElements.length; i++) {
		if (allElements[i].type == "checkbox") {
			objName = allElements[i].name;	
			if (allElements[i].checked)
			{
				cnt++;
			}
		 }
		}

	if (cnt == 0)
	{
	 var Msg=getMessage("NO_RECORDS_FOR_PRINT",'PH');
	 alert(Msg);
	 return false;
	}  

 	bean_id		  =	formobj.bean_id.value;
	bean_name       =	formobj.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
	xmlStr += " order_id=\""+orderid+"\"";
	xmlStr += " order_type=\""+order_type+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=PRINT_FOR_PRESCRIPTION",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	window.close();
}
function calvalidation(formObject,obj,facility_id,record_cnt,pre_id){

	
	var k=0;
//	var formObjcheck	 = parent.f_query_results.document.forms[0];
	var checked_yn ="N";
	   if (obj.checked){
		checked_yn ="Y";
	//	this.value = "Y";
		mode = "ADD_ELEMENT"
	   }else{
	//	checked_yn ="N";
	//	this.value = "N";
		mode = "REMOVE_ELEMENT"
	   } 

	
	bean_id		  =	formObject.bean_id.value;
	bean_name       =	formObject.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
	xmlStr += " record_cnt=\""+record_cnt+"\"";
	xmlStr += " checked_yn=\""+checked_yn+"\"";
	xmlStr += " prescription_id=\""+pre_id+"\"";
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=RECORDS_FOR_PRESCRIPTION",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);   
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
