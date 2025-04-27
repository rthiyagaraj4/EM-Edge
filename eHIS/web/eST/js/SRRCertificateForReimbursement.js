function searchPatient() {
	var patient_id = PatientSearch();
	var formObj = document.forms[0];
	if (!((patient_id == null) || (patient_id == ""))) {
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}
function DateCheck(from,to) {
    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;

	//alert("fromdate "+fromdate+" todate "+todate);
    if(fromdate.length > 0 && todate.length > 0 ) {
      			fromarray = fromdate.split("/");

			toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],(Number(fromarray[1])-1),fromarray[0]);
            var todt = new Date(toarray[2],(Number(toarray [1])-1),toarray[0]);
            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
				var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
				alert(invaldt);
				parent.f_query_results.document.location.href='../../eCommon/html/blank.html';
				to.select();
				to.focus();
			//	return false; 
                  
            }
            if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
}

function reset() {
	f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.document.forms[0].print.disabled =true;
	f_query_results.document.location.href='../../eCommon/html/blank.html';
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function showResult(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var adr_reported_date_from="";
	var adr_reported_date_to ="";
	var locale = formObj.p_language_id.value;
	var patient_id = formObj.patient_id.value;
	adr_reported_date_from = formObj.p_disp_date_from.value;
	adr_reported_date_from=convertDate(adr_reported_date_from,"DMY",locale); 
	adr_reported_date_to = formObj.p_disp_date_to.value;
	adr_reported_date_to=convertDate(adr_reported_date_to,"DMY",locale); 
	var sale_doc_no_from = formObj.sale_doc_no_from.value;
	var sale_doc_no_to = formObj.sale_doc_no_to.value;
	var store_code = formObj.store.value;
   	bean_id		  =	parent.f_query_add_mod.document.forms[0].bean_id.value;
	bean_name     =	parent.f_query_add_mod.document.forms[0].bean_name.value;
	mode = "CLEAR";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " mode=\""+mode+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRCertificateForReimbursementReportValidate.jsp?validate=RECORDS_FOR_CERTIFREIMBURSEMENT",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);   
 var fields = new Array (formObj.p_disp_date_from,formObj.p_disp_date_to,formObj.store);
	var names= new Array (getLabel("Common.DateFrom.label","Common"),getLabel("Common.DateTo.label","Common"),getLabel("Common.Store.label","Common"));
	if(checkFields(fields,names,parent.messageFrame))  
	{
 if (isValidFromToField(formObj.sale_doc_no_from, formObj.sale_doc_no_to, STRING, getLabel("Common.Sale.label", "Common")+getLabel("Common.DocNo.label", "Common"), parent.messageFrame)) {

parent.f_query_results.location.href="../../eST/jsp/SRRCertificateForReimbursementReportQueryCriteriaResult.jsp?patient_id="+patient_id+"&adr_reported_date_from="+adr_reported_date_from+"&adr_reported_date_to="+adr_reported_date_to+"&sale_doc_no_from="+sale_doc_no_from+"&sale_doc_no_to="+sale_doc_no_to+"&store_code="+store_code;
formObj.print.disabled =false;
parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
 }else{
	 parent.f_query_results.location.href='../../eCommon/html/blank.html';
	formObj.print.disabled =true;

 }
			
	}
	else{
	parent.f_query_results.location.href='../../eCommon/html/blank.html';
	formObj.print.disabled =true;

	} 
}
function chkall(formObject) {
	var allElements = formObject.elements;
	var ischecked = formObject.selectall_yn.checked;
	var doc_no = "";
	for (i = 1; i < allElements.length; i++) {
		if (allElements[i].type == "checkbox") {
			objName = allElements[i].name;	
			index = objName.substring(objName.lastIndexOf("_yn")+3,objName.length);	
			allElements[i].checked = ischecked;
	        val = eval("document.SRRCertiforReimbursementQueryResultForm.doc_no_"+index).value;
			if (doc_no == "")
				doc_no =val;
			else
				doc_no =doc_no+"~"+val;			
		}
	}
 // alert(doc_no);
  if (formObject.selectall_yn.checked)
	{
		mode = "ADD_ELEMENT_ALL";
	}else{
		mode = "REMOVE_ELEMENT_ALL";
	}

      bean_id		=	parent.f_query_results.document.forms[0].bean_id.value;
	bean_name       =	parent.f_query_results.document.forms[0].bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";	
	xmlStr += " doc_no=\""+doc_no+"\"";
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRCertificateForReimbursementReportValidate.jsp?validate=RECORDS_FOR_CERTIFREIMBURSEMENT",false);
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

function calvalidation(obj,record_cnt,doc_no){
    var k=0;
	var formObjcheck	 = parent.f_query_results.document.forms[0];
	var checked_yn ="N";
	   if (obj.checked){
		checked_yn ="Y";
		this.value = "Y";
		mode = "ADD_ELEMENT"
	   }else{
		checked_yn ="N";
		this.value = "N";
		mode = "REMOVE_ELEMENT"
	   }

	bean_id		  =	parent.f_query_results.document.forms[0].bean_id.value;
	bean_name       =	parent.f_query_results.document.forms[0].bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " record_cnt=\""+record_cnt+"\"";
	xmlStr += " checked_yn=\""+checked_yn+"\"";
	xmlStr += " doc_no=\""+doc_no+"\"";
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRCertificateForReimbursementReportValidate.jsp?validate=RECORDS_FOR_CERTIFREIMBURSEMENT",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);

}


function SubmitLink(from,to,patient_id,adr_reported_date_from,adr_reported_date_to,sale_doc_no_from,sale_doc_no_to,store_code,doc_type_code){
	var obj=parent.f_query_results.document.forms[0];


	obj.from.value=from;
	obj.to.value=to;
   	obj.patient_id.value=patient_id;
	obj.adr_reported_date_from.value=adr_reported_date_from;
	obj.adr_reported_date_to.value=adr_reported_date_to;
	obj.sale_doc_no_from.value=sale_doc_no_from;
	obj.sale_doc_no_to.value=sale_doc_no_to;
	obj.store_code.value=store_code;
	obj.doc_type_code.value=doc_type_code;
	obj.submit();
}
function showPrint(facility_id){

	headerObj=parent.f_query_results.document.forms[0];

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
	alert("APP-ST0178 Atleast one Record should be selected");
	 return false;
	}  

	mode="PRINT_FOR_CERTIFREIMBURSEMENT";
 	bean_id		  =	parent.f_query_results.document.forms[0].bean_id.value;
	bean_name       =	parent.f_query_results.document.forms[0].bean_name.value;
	p_store_code       =	parent.f_query_results.document.forms[0].store_code.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr += " p_store_code=\""+p_store_code+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRCertificateForReimbursementReportValidate.jsp?validate=RECORDS_FOR_CERTIFREIMBURSEMENT",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);         
}
function show_Print_for_certi(doc_date,doc_no,index){

	var ResultObj = parent.f_query_results.document.forms[0];

	var allElements = ResultObj.elements;
	var cnt = 0;
	/*for (i = 1; i < allElements.length; i++) {
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
	alert("APP-ST0178 Atleast one Record should be selected");
	 return false;
	} */ 
	var formObj = parent.f_query_add_mod.document.forms[0];
	 val = eval("ResultObj.p_print_yn"+index).checked;

	//if(val){
            formObj.P_DOC_NO.value = doc_no ;
	        formObj.P_DOC_DATE.value = doc_date ;
	        formObj.P_STORE_CODE.value = ResultObj.store_code.value;
	        formObj.P_REPRINT.value = "Y" ;
            formObj.submit();
	//}
	

}
function isAfterCurrDate(obj)
{	
	//Added By Sakti Sankar against inc#38120
	var language_id = document.CertificateForReimbursementCriteria.p_language_id.value;
	var date = obj.value;
	if(language_id != "en") {
		date = convertDate(date, "DMY", language_id, "en");
	}
	//Added ends
		

	if(isValidDate(obj) && date.length > 0 )    
	{
		if(!isBeforeNow(date,'DMY',"en"))							    
		{
			alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE", "ST"));
			//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("NOT_LESS_THAN_SYSDATE", "ST");
			  obj.value = "";   
			obj.focus();
			return false;
		}  													   
	}
}
function isValidDate(obj)
{	
	var date = obj.value;

	
	if(date.length > 0 )
	{
		if(!validDate(date,'DMY',"en"))
		{
			obj.value = "";
			return false;
		}												  
		else
		{
			return true;
		}
	}				   
}
function validate_date(Obj,ref) {
                
	if (CheckDate1(Obj))
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
		var fromdt = new Date(fromarray[2],(Number(fromarray[1])-1),fromarray[0]);
		var todt = new Date(toarray[2],(Number(toarray[1])-1),toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
			parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

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
