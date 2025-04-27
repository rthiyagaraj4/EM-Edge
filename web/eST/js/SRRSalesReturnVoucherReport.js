function reset() {
		f_query_add_mod.document.forms[0].reset();
		f_query_results.document.location.href="../../eCommon/html/blank.html"
	    messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

}
function showResults(){
	
	var formObj = parent.f_query_add_mod.document.forms[0];
	var fr_rtndate="";
	var to_rtndate ="";
	var patient_id = formObj.p_patient_id.value;
	var p_encounter= formObj.p_encounter.value;
	var p_rtnstore= formObj.p_rtnstore.value;
	var p_sal_trn_type= formObj.p_sal_trn_type.value;
	var p_document= formObj.p_document.value;
	var locale = formObj.p_language_id.value;
	var p_fr_rtn_date = formObj.p_fr_rtn_date.value;
	formObj.p_rtn_store_code.value = p_rtnstore;

	fr_rtndate=convertDate(p_fr_rtn_date,"DMY",locale); 
	var p_to_rtn_date = formObj.p_to_rtn_date.value;
	to_rtndate=convertDate(p_to_rtn_date,"DMY",locale); 
	//====================================================================================================
		
if(document.forms[0].p_fr_rtn_date.value!='' && document.forms[0].p_to_rtn_date.value!='')
{ 
	if(!isBefore(formObj.p_to_rtn_date.value,formObj.currentdate.value,"DMY",document.forms[0].p_language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
	}

    if(!isBefore(formObj.p_fr_rtn_date.value,formObj.p_to_rtn_date.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
	}
}

	//========================================================================================================	
	var fields = new Array (formObj.p_fr_rtn_date,formObj.p_to_rtn_date,formObj.p_rtnstore);
	var names= new Array (getLabel("eST.ReturnDateFrom.label","ST"), getLabel("eST.ReturnDateTo.label","ST"),getLabel("eST.ReturnStore.label","ST"));
	if(checkFields(fields,names,parent.messageFrame)) 
	{
		
		if(doDateCheck(formObj.p_fr_rtn_date,formObj.p_to_rtn_date,parent.messageFrame)){
		parent.f_query_results.location.href="../../eST/jsp/SRRSalesReturnVoucherReportQueryCriteriaResult.jsp?patient_id="+patient_id	+"&fr_rtndate="+fr_rtndate+"&to_rtndate="+to_rtndate+"&p_encounter="+p_encounter+"&p_rtnstore="+p_rtnstore+"&p_sal_trn_type="+p_sal_trn_type+"&p_document="+p_document;
		}

		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		
		
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
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		to.select();
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
	  from = document.forms[0].p_to_rtn_date;
	  to = document.forms[0].p_fr_rtn_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_fr_rtn_date;
	  to = document.forms[0].p_to_rtn_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].p_to_rtn_date;
	  to = document.forms[0].p_fr_rtn_date;
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
/*if(!isBefore(document.forms[0].p_fr_rtn_date.value,document.forms[0].p_to_rtn_date.value,"DMY",document.forms[0].p_language_id.value)) {
			
			if(document.forms[0].p_to_rtn_date.value=='')
			{
				return false;
			}
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
			alert(errors);
			return false;
			
	}*/
	if(document.forms[0].p_fr_rtn_date.value=='' || document.forms[0].p_to_rtn_date.value=='')
{ 
					return false;
}
	else{
		if(!isBefore(document.forms[0].p_fr_rtn_date.value,document.forms[0].p_to_rtn_date.value,"DMY",document.forms[0].p_language_id.value)) {
			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				document.forms[0].p_fr_rtn_date.select();
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

function showPrintReport(p_doc_rtn_date,p_doc_no){

	var formObj = parent.f_query_add_mod.SRRSalesRtnVoucherForm;

	formObj.p_doc_no.value = p_doc_no;
	formObj.p_doc_rtn_date.value = p_doc_rtn_date;
	formObj.p_report_id.value = "STBSALRT_SRR" ;
		
		
	parent.f_query_add_mod.document.SRRSalesRtnVoucherForm.submit();


}



