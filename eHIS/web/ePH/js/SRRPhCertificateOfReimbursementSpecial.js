function callPatientSearch(target)
{

	var patient_id = PatientSearch();
 if(patient_id != null && patient_id != "" )  
	 {		
		target.value = patient_id;
	 }
}
function selectBillingGroup(obj)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= formCRForSpecial.p_language_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3"; 
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK ;//CODE_LINK
	argumentArray[7] = DESC_CODE;//CODE_DESC
	retVal = CommonLookup(getLabel("Common.BillingGroup.label","Common"), argumentArray );
		
		if(retVal != null && retVal != "") {
		
			obj.value = retVal[1] ;				
			formCRForSpecial.p_privilege.value = retVal[0];
		}else{
			obj.value ="";			
		}				
}

function enableBillReceipt(obj){
	/*if (obj.value != '')	
		formCRForSpecial.p_patient_chk.style.display="inline";		
	else
		formCRForSpecial.p_patient_chk.style.display="none";	*/
	
	if (obj.value == 'B')
	{
		formCRForSpecial.bill_date.disabled = false;
		formCRForSpecial.bill_date.value = formCRForSpecial.currentdate.value;
		formCRForSpecial.bill_number.disabled = false;
		formCRForSpecial.bill_number1.disabled = false;
		document.getElementById("Calendar").disabled =false;				
		formCRForSpecial.receipt_date.disabled = true;			
		formCRForSpecial.receipt_date.value = '';			
		formCRForSpecial.receipt_number.disabled = true;
		formCRForSpecial.receipt_number1.disabled = true;
		formCRForSpecial.receipt_number.value = '';
		formCRForSpecial.receipt_number1.value = '';
		document.getElementById("Calendar1").disabled =true;	
	}
	else{
		formCRForSpecial.bill_date.disabled = true;			
		formCRForSpecial.bill_date.value = '';			
		formCRForSpecial.bill_number.disabled = true;
		formCRForSpecial.bill_number1.disabled = true;
		formCRForSpecial.bill_number.value = '';
		formCRForSpecial.bill_number1.value = '';
		document.getElementById("Calendar").disabled =true;	
		formCRForSpecial.receipt_date.disabled = false;
		formCRForSpecial.receipt_date.value = formCRForSpecial.currentdate.value;
		formCRForSpecial.receipt_number.disabled = false;
		formCRForSpecial.receipt_number1.disabled = false;
		document.getElementById("Calendar1").disabled =false;	
		
	}
}

function callResultPage(){
	
	var frmObject = parent.f_query_add_mod.document.formCRForSpecial;	
	var fields= new Array (frmObject.p_report_type,frmObject.p_search_by);
	var names= new Array (getLabel("Common.reporttype.label","Common"),getLabel("Common.searchby.label","Common"));

	var bean_id			=	parent.f_query_add_mod.document.formCRForSpecial.bean_id.value;
	var bean_name       =	parent.f_query_add_mod.document.formCRForSpecial.bean_name.value;

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
	
    var locale			= frmObject.p_language_id.value;
	var p_report_type	= frmObject.p_report_type.value;
	var p_search_by		= frmObject.p_search_by.value;
	var p_bill_date		= frmObject.bill_date.value;
	//Date conversion related to p_bill_date and p_receipt_date is added on 12/1/2010 by Archanan Dhal related to incident no. IN023829
	if(p_bill_date!= null && p_bill_date!="")
	{
    	p_bill_date = convertDate(p_bill_date,'DMY',locale,'en');
		
	}
	var p_bill_number	= frmObject.bill_number.value;
	var p_bill_number1	= frmObject.bill_number1.value;
	var p_receipt_date	= frmObject.receipt_date.value;
	if(p_receipt_date!= null && p_receipt_date!="")
	{
    	p_receipt_date = convertDate(p_receipt_date,'DMY',locale,'en');
		
	}
	var p_receipt_number= frmObject.receipt_number.value;
	var p_receipt_number1= frmObject.receipt_number1.value;
	var p_patient_id	= frmObject.p_patient_id.value;
	var p_privilege		= frmObject.p_privilege.value;
	var p_payer			= frmObject.p_payer.value;
	var p_report_option	= frmObject.p_report_option.value;
	

	if(checkFields(fields,names,parent.messageFrame)){	
		if ( p_patient_id == '' && p_bill_date == '' && p_receipt_date == '' )
		{
          var msg = getMessage("PATIENTID_BILLDATE_REQUIRED",'PH');//"Patient ID / Bill Date / Receipt Date is required ";
		  parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
		  parent.f_query_results.location.href='../../eCommon/html/blank.html';	
		  return false;
		}

		parent.f_query_results.location.href="../../ePH/jsp/SRRPhCertificateforReimbursementQueryResult.jsp?p_report_type="+p_report_type+"&p_search_by="+p_search_by+"&p_bill_date="+p_bill_date+"&p_bill_number="+p_bill_number+"&p_receipt_date="+p_receipt_date+"&p_receipt_number="+p_receipt_number+"&p_patient_id="+p_patient_id+"&p_privilege="+p_privilege+"&p_payer="+p_payer+"&p_report_option="+p_report_option+"&locale="+locale+"&p_bill_number1="+p_bill_number1+"&p_receipt_number1="+p_receipt_number1;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
			
	}
	else{
		parent.f_query_results.location.href='../../eCommon/html/blank.html';
	
	}		

}

function reset() {
		f_query_add_mod.location.reload();
		f_query_results.location.href='../../eCommon/html/blank.html';
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
function reset1() {
		parent.f_query_add_mod.location.reload();
		parent.f_query_results.location.href='../../eCommon/html/blank.html';
		
}

function query(){
		f_query_add_mod.location.reload();
		f_query_results.location.href='../../eCommon/html/blank.html';
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function assignValue(obj,index){
	var msg=''
	var msg1='';
  if (obj.checked)
  {
	  obj.value='Y';
  }
  else
	  obj.value='N';
  for (i=0;i<formCRForSpecialResult.listSize.value ;i++ )
  {	 
	  if (eval("formCRForSpecialResult.p_print_yn"+i).checked)
	  {
		  msg="checked";
		  break;
	  }	
  }
    if (msg != '')
	  {		
		parent.f_query_add_mod.document.formCRForSpecial.print.disabled = false;
	  }
	  else{		  
		parent.f_query_add_mod.document.formCRForSpecial.print.disabled = true;
	  }
	for (j=0;j<formCRForSpecialResult.listSize.value ;j++ )
	{
		 if (!eval("formCRForSpecialResult.p_print_yn"+j).checked){
		   msg1="uncheked";
		   break;
		 }
	}
	if (msg1 != '')
	{
		formCRForSpecialResult.p_print_all.value ='N';
		formCRForSpecialResult.p_print_all.checked =false;
	}
	else{
		formCRForSpecialResult.p_print_all.value ='Y';
		formCRForSpecialResult.p_print_all.checked =true;
	}
}

function  updateList(index){

	var bean_id			=	parent.f_query_add_mod.document.formCRForSpecial.bean_id.value;
	var bean_name       =	parent.f_query_add_mod.document.formCRForSpecial.bean_name.value;
    var checkedValue	=	eval("formCRForSpecialResult.p_print_yn"+index).value

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=updateList&checkedValue="+checkedValue+"&index="+index,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText); 
}

function assignAll(obj){
	if (obj.checked)
	{
		obj.value ='Y'
		parent.f_query_add_mod.document.formCRForSpecial.print.disabled = false;
	}
	else{
		obj.value='N';
		parent.f_query_add_mod.document.formCRForSpecial.print.disabled = true;
	}
	for (i=0;i<formCRForSpecialResult.listSize.value ; i++)
	{
		if (obj.value == 'Y')
		{
			eval("formCRForSpecialResult.p_print_yn"+i).checked = true;
			eval("formCRForSpecialResult.p_print_yn"+i).value = 'Y';
			updateList(i);
		}
		else
		{
			eval("formCRForSpecialResult.p_print_yn"+i).checked = false;
			eval("formCRForSpecialResult.p_print_yn"+i).value = 'N';
			updateList(i);
		}
	}
}

function showPrint(){
/*var cnt=0;
   Obj=parent.f_query_results.document.forms[0];
	elements=   Obj.elements
   for (i = 1; i < elements.length; i++) {

		if (elements[i].type == "checkbox") {
			if (elements[i].checked)
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
	} */

 	bean_id			=	parent.f_query_add_mod.formCRForSpecial.bean_id.value;
	bean_name       =	parent.f_query_add_mod.formCRForSpecial.bean_name.value;
	p_facility_id	=	parent.f_query_add_mod.formCRForSpecial.p_facility_id.value;
	p_report_type	=	parent.f_query_add_mod.formCRForSpecial.p_report_type.value;
	p_search_by		=	parent.f_query_add_mod.formCRForSpecial.p_search_by.value;
	p_report_option	=	parent.f_query_add_mod.formCRForSpecial.p_report_option.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+p_facility_id+"\"";
//	xmlStr += " record_cnt=\""+record_cnt+"\"";
//	xmlStr += " checked_yn=\""+checked_yn+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=printList&p_facility_id="+p_facility_id+"&p_report_type="+p_report_type+"&p_search_by="+p_search_by+"&p_report_option="+p_report_option,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);      
}

 function reload() {
		parent.f_query_add_mod.location.reload();
		parent.f_query_results.location.href='../../eCommon/html/blank.html';
		parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
function callPayerLookup(obj)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	

 	//argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";


 	argumentArray[0] ="select cust_code code, long_name description from ar_customer_lang_vw where acc_entity_code  = 'ZZ' and nvl(patient_flag,'N')  ='Y' and nvl(pat_com_flag,'N')='N' and nvl(insurance_yn, 'N') = 'Y' and status is null and language_id like ? and UPPER(cust_code) LIKE UPPER(?) AND UPPER(long_name) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= formCRForSpecial.p_language_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3"; 
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK ;//CODE_LINK
	argumentArray[7] = DESC_CODE;//CODE_DESC
	retVal = CommonLookup(getLabel("Common.Payer.label","Common"), argumentArray );
		
		if(retVal != null && retVal != "") {
		
			obj.value = retVal[1] ;				
			formCRForSpecial.p_payer.value = retVal[0];
		}else{
			obj.value ="";			
		}				
}

