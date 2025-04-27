/**
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201021            74212       MOHE-CRF-0050.3      	Nandhini M
 */

function reset()
{
	summaryreport.location.reload();
}	

//Effective From and ToDate Logic
function toFromDateChk(obj)
{	
	var effFromDt =document.forms[0].fm_bill_date.value;
	
	if(effFromDt=='')
	{
		alert("APP-BL0878 Bill Date cannot be null");
		document.getElementById("fm_bill_date").focus();
	  	return false;
	}
	
	if(!(obj.value==""))
	{		
		var locale=document.forms[0].locale.value;
		var effFromDt =document.forms[0].fm_bill_date.value;
		var effToDt =document.forms[0].to_bill_date.value;
		
		if(validDate(obj.value,"DMY",locale))
		{
			/*if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL9114",'BL'));
				obj.value = '';
				return false;
				
			}*/
			
			if(effFromDt != ''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale)))
				{		
					alert(getMessage("BL7060",'BL'));
					obj.value = '';
					return false;
				}
				else
				{			
					return true;
				}				
			}		
			if(effFromDt=='' && effToDt==''){
  				alert("APP-BL0878 Bill Date cannot be null");
  			  	return false;
  			}
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value='';
			return false;
		}
	}
	else
	{
		return true;
	}
}

function checkDateBL(entered_date)
{		
  	var locale=document.forms[0].locale.value;
  	var effFromDt =document.forms[0].fm_bill_date.value;
  	var effToDt =document.forms[0].to_bill_date.value;
  	if(entered_date.value!="")
  	{
  		if(validDate(entered_date.value,'DMY',locale))
  		{
  			if(!isBeforeNow(entered_date.value,'DMY',locale)){
  				alert(getMessage("BL9114",'BL'));
  				entered_date.value='';
  				return false;
  			}		
  			if(effToDt != ''){
  				if((!isBefore(effFromDt,effToDt,'DMY',locale)))
				{
  					alert(getMessage("BL7060",'BL'));
  					entered_date.value='';
  					return false;
				}
				else{
						return true;
				}
  			}
			
  			if(effFromDt=='' && effToDt==''){
  				alert(getMessage('BL0878','BLEXT'));
				document.getElementById("to_bill_date").focus();
  			  	return false;
  			}
  		}
  		else
  		{	
  			alert(getMessage("INVALID_DATE_FMT","SM"));
  			entered_date.value='';
  			return false;
  		}
  	}
  	else
  	{
  		return true;
  	}
}
//Effective From and ToDate Logic

function dateRegEx(e)
	{  //Added for Character Restriction in date field
	  var pattern = new RegExp("^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\/\-]\d{4}$");
	  if (e.value.search(pattern)===0){
	    return true;
	  }
	  else {
	    alert("Please provide valid date in format dd/mm/yyyy");
	    document.getElementById(e.id).focus();
	    return false; 
	  } 
}

function frmBillNOLookup(){	
	var facility=document.forms[0].facilityId.value;
	var effFromDt =document.forms[0].fm_bill_date.value;
  	var effToDt =document.forms[0].to_bill_date.value;
    	var formObj = document.forms[0];
	var locale=formObj.locale.value;
	if(effFromDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("fm_bill_date").focus();
			return false;
	}
	else if(effToDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("to_bill_date").focus();
			return false;
	}
	
	var sql="";
	
	sql=" SELECT distinct a.doc_type_code code, a.doc_num description FROM bl_bill_hdr a, bl_addl_charge_for_bill_audit b WHERE UPPER(a.operating_facility_id) = UPPER('"+facility+"') AND TO_CHAR(a.doc_date,'DD/MM/YYYY') >=TO_CHAR(TO_DATE ('"+effFromDt+"', 'DD/MM/YYYY'),'DD/MM/YYYY') AND TO_CHAR(a.doc_date,'DD/MM/YYYY') <= TO_CHAR(TO_DATE ('"+effToDt+"', 'DD/MM/YYYY'),'DD/MM/YYYY') ANd a.operating_facility_id=b.operating_facility_id AND a.doc_type_code=b.bill_doc_type AND a.doc_num=b.bill_doc_number AND UPPER (a.doc_type_code) LIKE UPPER (?) AND UPPER (a.doc_num) LIKE UPPER (?) ORDER BY a.doc_type_code, a.doc_num ";
	//sql=" SELECT distinct a.doc_type_code code, a.doc_num description FROM bl_bill_hdr a, bl_addl_charge_for_bill_audit b WHERE UPPER(a.operating_facility_id) = UPPER('"+facility+"') AND AND a.doc_date between TO_DATE('"+effFromDt+"','DD/MM/YYYY') AND  to_date('"+effToDt+"','DD/MM/YYYY') ANd a.operating_facility_id=b.operating_facility_id AND a.doc_type_code=b.bill_doc_type AND a.doc_num=b.bill_doc_number AND UPPER (a.doc_type_code) LIKE UPPER (?) AND UPPER (a.doc_num) LIKE UPPER (?) ORDER BY a.doc_type_code, a.doc_num ";
	
		
	var title									= 	getLabel("eBL.BillNumber.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"2,1";
	argumentArray[5]   							= 	formObj.FromBillNo.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		formObj.fromBill.value			=   retVal[0];
		formObj.FromBillNo.value 		= 	retVal[1];
	}
	else
	{
		formObj.fromBill.value			=   "";
		formObj.FromBillNo.value 		= 	"";
	}	
}

function toBillNOLookup(){	
	var facility=document.forms[0].facilityId.value;
	var effFromDt =document.forms[0].fm_bill_date.value;
  	var effToDt =document.forms[0].to_bill_date.value;
    var formObj = document.forms[0];
	if(effFromDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("fm_bill_date").focus();
			return false;
	}
	else if(effToDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("to_bill_date").focus();
			return false;
	}
	 
	var sql="SELECT distinct a.doc_type_code code, a.doc_num description FROM bl_bill_hdr a, bl_addl_charge_for_bill_audit b WHERE UPPER(a.operating_facility_id) = UPPER('"+facility+"') AND TO_CHAR(a.doc_date,'DD/MM/YYYY') >=TO_CHAR(TO_DATE ('"+effFromDt+"', 'DD/MM/YYYY'),'DD/MM/YYYY') AND TO_CHAR(a.doc_date,'DD/MM/YYYY') <= TO_CHAR(TO_DATE ('"+effToDt+"', 'DD/MM/YYYY'),'DD/MM/YYYY') ANd a.operating_facility_id=b.operating_facility_id AND a.doc_type_code=b.bill_doc_type AND a.doc_num=b.bill_doc_number AND UPPER (a.doc_type_code) LIKE UPPER (?) AND UPPER (a.doc_num) LIKE UPPER (?) ORDER BY a.doc_type_code, a.doc_num";
	//var sql="SELECT distinct a.doc_type_code code, a.doc_num description FROM bl_bill_hdr a, bl_addl_charge_for_bill_audit b WHERE UPPER(a.operating_facility_id) = UPPER('"+facility+"') AND a.doc_date <= to_date('"+effToDt+"','DD/MM/YYYY')  ANd a.operating_facility_id=b.operating_facility_id AND a.doc_type_code=b.bill_doc_type AND a.doc_num=b.bill_doc_number AND UPPER (a.doc_type_code) LIKE UPPER (?) AND UPPER (a.doc_num) LIKE UPPER (?) ORDER BY a.doc_type_code, a.doc_num";
		
		 
	var title									= 	getLabel("eBL.BillNumber.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"2,1";
	argumentArray[5]   							= 	formObj.ToBillNo.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		formObj.Tobill.value			=   retVal[0];
		formObj.ToBillNo.value 			= 	retVal[1];
	}
	else
	{
		formObj.Tobill.value			=   "";
		formObj.ToBillNo.value 			= 	"";		
	}	
}

function customerLookup(){	
	var facility=document.forms[0].facilityId.value;
	var formObj = document.forms[0];
	var effFromDt =document.forms[0].fm_bill_date.value;
  	var effToDt =document.forms[0].to_bill_date.value;
	if(effFromDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("fm_bill_date").focus();
			return false;
	}
	else if(effToDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("to_bill_date").focus();
			return false;
	}
	 
	var sql="";
	sql="select CUST_CODE code , LONG_NAME description from ar_customer where upper(CUST_CODE) like UPPER(?) and upper(LONG_NAME) like UPPER(?) ORDER BY 2 ";                                
		 
	var title									= 	getLabel("eBL.Customers.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.customer.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		formObj.cust_.value			=   retVal[0];
		formObj.customer.value 				= 	retVal[1];
	}
	else
	{
		formObj.cust_.value			=   "";
		formObj.customer.value 				= 	"";		
	}	
}

function tocustomerLookup(){	
	var facility=document.forms[0].facilityId.value;
	var formObj = document.forms[0];
	var effFromDt =document.forms[0].fm_bill_date.value;
  	var effToDt =document.forms[0].to_bill_date.value;
	if(effFromDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("fm_bill_date").focus();
			return false;
	}
	else if(effToDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("to_bill_date").focus();
			return false;
	}
	 
	var sql="";
	sql="select CUST_CODE code , LONG_NAME description from ar_customer where upper(CUST_CODE) like UPPER(?) and upper(LONG_NAME) like UPPER(?) ORDER BY 2 ";                                
		 
	var title									= 	getLabel("eBL.Customers.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.tocustomer.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		formObj.cust_to.value			=   retVal[0];
		formObj.tocustomer.value 		= 	retVal[1];
	}
	else
	{
		formObj.cust_to.value			=   "";
		formObj.tocustomer.value 		= 	"";		
	}	
}

function frmpolicyLookup(){	
	var facility=document.forms[0].facilityId.value;
	var locale=document.forms[0].locale.value;
	var effFromDt =document.forms[0].fm_bill_date.value;
  	var effToDt =document.forms[0].to_bill_date.value;
	var formObj = document.forms[0];
	
	if(effFromDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("fm_bill_date").focus();
			return false;
	}
	else if(effToDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("to_bill_date").focus();
			return false;
	}
	 
	var sql="";
	sql="select distinct long_desc code,policy_type_code description from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and  upper(language_id) = upper('"+locale+"') and upper(operating_facility_id) = upper('"+facility+"') and upper(long_desc) like UPPER(?) and upper(policy_type_code) like UPPER(?) order by 1 "
                                
		 
	var title									= 	getLabel("eBL.POLICY.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.FromPolicy.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		formObj.fromPol.value			=   retVal[1];
		formObj.FromPolicy.value 		= 	retVal[0];
	}
	else
	{
		formObj.fromPol.value			=   "";
		formObj.FromPolicy.value 		= 	"";		
	}	
}

function topolicyLookup(){
	var facility=document.forms[0].facilityId.value;
	var locale=document.forms[0].locale.value;
	var effFromDt =document.forms[0].fm_bill_date.value;
  	var effToDt =document.forms[0].to_bill_date.value;
	var formObj = document.forms[0];
	if(effFromDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("fm_bill_date").focus();
			return false;
	}
	else if(effToDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("to_bill_date").focus();
			return false;
	}
	 
	var sql="";
	sql="select distinct long_desc code,policy_type_code description from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and  upper(language_id) = UPPER('"+locale+"') and upper(operating_facility_id) = UPPER('"+facility+"') and upper(long_desc) like UPPER(?) and upper(policy_type_code) like UPPER(?) order by 1 ";          
		 
	var title									= 	getLabel("eBL.POLICY.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.ToPolicy.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		formObj.toPol.value			=   retVal[1];
		formObj.ToPolicy.value 				= 	retVal[0];

	}
	else
	{
		formObj.toPol.value			=   "";
		formObj.ToPolicy.value 				= 	"";
		
	}	
}
function fromPatIDLookup(){
	var facility=document.forms[0].facilityId.value;
	var patient_id=document.forms[0].p_patient_id.value;
	var locale=document.forms[0].locale.value;
	var effFromDt =document.forms[0].fm_bill_date.value;
  	var effToDt =document.forms[0].to_bill_date.value;
	var formObj = document.forms[0];
	var FromBillNo=document.forms[0].FromBillNo.value;//description
	var fromBill=document.forms[0].fromBill.value;//code
	var ToBillNo=document.forms[0].ToBillNo.value;//description
	var Tobill=document.forms[0].Tobill.value;//code
	if(effFromDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("fm_bill_date").focus();
			return false;
	}
	else if(effToDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("to_bill_date").focus();
			return false;
	}
	 
	 
	 var sql="";
	 
	 sql="select Distinct a.patient_id code, b.patient_name description from bl_bill_hdr a,mp_patient b,bl_addl_charge_for_bill_audit c WHERE a.patient_id=b.patient_id AND TO_CHAR(a.doc_date,'DD/MM/YYYY') >=TO_CHAR(TO_DATE ('"+effFromDt+"', 'DD/MM/YYYY'),'DD/MM/YYYY') AND TO_CHAR(a.doc_date,'DD/MM/YYYY') <= TO_CHAR(TO_DATE ('"+effToDt+"', 'DD/MM/YYYY'),'DD/MM/YYYY')and a.doc_type_code between nvl('"+fromBill+"',a.doc_type_code) and nvl('"+Tobill+"',a.doc_type_code) and a.doc_num between nvl('"+FromBillNo+"',a.doc_num) and nvl('"+ToBillNo+"',a.doc_num) and a.operating_facility_id = c.operating_facility_id AND a.doc_type_code=c.bill_doc_type AND a.doc_num=c.bill_doc_number AND UPPER (a.patient_id) LIKE UPPER (?) AND UPPER (b.patient_name) LIKE UPPER (?) "; 
		 
	var title									= 	getLabel("eBL.PatientID.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.FromPatientID.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		formObj.FromPat.value			=   retVal[0];
		formObj.FromPatientID.value 				= 	retVal[1];

	}
	else
	{
		formObj.FromPat.value			=   "";
		formObj.FromPatientID.value 				= 	"";
		
	}	
}
function toPatIDLookup(){
	var facility=document.forms[0].facilityId.value;
	var patient_id=document.forms[0].p_patient_id.value;
	var locale=document.forms[0].locale.value;
	var effFromDt =document.forms[0].fm_bill_date.value;
  	var effToDt =document.forms[0].to_bill_date.value;
	var formObj = document.forms[0];
	var FromBillNo=document.forms[0].FromBillNo.value;//description
	var fromBill=document.forms[0].fromBill.value;//code
	var ToBillNo=document.forms[0].ToBillNo.value;//description
	var Tobill=document.forms[0].Tobill.value;//code
	if(effFromDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("fm_bill_date").focus();
			return false;
	}
	else if(effToDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			document.getElementById("to_bill_date").focus();
			return false;
	}
	 
	var sql="";
	sql="select Distinct a.patient_id code, b.patient_name description from bl_bill_hdr a,mp_patient b,bl_addl_charge_for_bill_audit c WHERE a.patient_id=b.patient_id AND TO_CHAR(a.doc_date,'DD/MM/YYYY') >=TO_CHAR(TO_DATE ('"+effFromDt+"', 'DD/MM/YYYY'),'DD/MM/YYYY') AND TO_CHAR(a.doc_date,'DD/MM/YYYY') <= TO_CHAR(TO_DATE ('"+effToDt+"', 'DD/MM/YYYY'),'DD/MM/YYYY')and a.doc_type_code between nvl('"+fromBill+"',a.doc_type_code) and nvl('"+Tobill+"',a.doc_type_code) and a.doc_num between nvl('"+FromBillNo+"',a.doc_num) and nvl('"+ToBillNo+"',a.doc_num) and a.operating_facility_id = c.operating_facility_id AND a.doc_type_code=c.bill_doc_type AND a.doc_num=c.bill_doc_number AND UPPER (a.patient_id) LIKE UPPER (?) AND UPPER (b.patient_name) LIKE UPPER (?)";
		 
	var title									= 	getLabel("eBL.PatientID.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.ToPatientID.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		formObj.ToPat_.value			=   retVal[0];
		formObj.ToPatientID.value 				= 	retVal[1];

	}
	else
	{
		formObj.ToPat_.value			=   "";
		formObj.ToPatientID.value 				= 	"";
		
	}
 
	
}
function run()  
{	

  var formsObj = parent.content.summaryreport.document.forms[0];
  var effFromDt	=formsObj.fm_bill_date.value;
  var effToDt =formsObj.to_bill_date.value;
  var P_FACILITY_ID=formsObj.facilityId.value;
  var p_report_id=formsObj.p_report_id.value;
  var P_language_id=formsObj.locale.value;
  var p_session_id=formsObj.p_session_id.value;
  var p_module_id=formsObj.p_module_id.value;
  var p_pgm_date=formsObj.p_pgm_date.value;
  var FromBillNo	=formsObj.FromBillNo.value;
  var ToBillNo	=formsObj.ToBillNo.value;
  var fromBill= formsObj.fromBill.value;
  var Tobill= formsObj.Tobill.value;
  var customer=formsObj.cust_.value;
  var tocustomer=formsObj.cust_to.value;
  var FromPolicy=formsObj.fromPol.value;
  var ToPolicy=formsObj.toPol.value;
  var FromPatientID=formsObj.FromPat.value;
  var ToPatientID=formsObj.ToPat_.value;
  var loggedUserId = formsObj.p_user_name.value;
  
  if(effFromDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			formsObj.fm_bill_date.focus();
			return false;
	}
	else if(effToDt=='')
	{
			alert("APP-BL0878 Bill Date cannot be null");
			formsObj.to_bill_date.focus();
			return false;
	}
  
	FromBillNo = (FromBillNo=="" || FromBillNo==null) ? '0' : FromBillNo;
	ToBillNo = (ToBillNo=="" || ToBillNo==null) ? '999999999' : ToBillNo;
	customer = (customer=="" || customer==null) ? '`' : customer;
	tocustomer = (tocustomer=="" || tocustomer==null) ? '!!!!!!' : tocustomer;
	FromPolicy = (FromPolicy=="" || FromPolicy==null) ? '`' : FromPolicy;
	ToPolicy = (ToPolicy=="" || ToPolicy==null) ? '!!!!!!' : ToPolicy;
	FromPatientID = (FromPatientID=="" || FromPatientID==null) ? '`' : FromPatientID;
	ToPatientID = (ToPatientID=="" || ToPatientID==null) ? '!!!!!!' : ToPatientID;
	fromBill = (fromBill=="" || fromBill==null) ? '`' : fromBill;
	Tobill = (Tobill=="" || Tobill==null) ? '!!!!!!' : Tobill;

	var pgm_id=p_report_id;	

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	var param1 = "&P_FACILITY_ID="+P_FACILITY_ID+"&p_report_id="+p_report_id+"&param1="+effFromDt+
	"&param2="+effToDt+
	"&param3="+fromBill+
	"&param4="+Tobill+
	"&param5="+FromBillNo+
	"&param6="+ToBillNo+
	"&param7="+FromPatientID+
	"&param8="+ToPatientID+
	"&param9="+'R'+
	"&param10="+customer+
	"&param11="+tocustomer+
	"&param12="+FromPolicy+
	"&param13="+ToPolicy ;
		
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/BLCommonReportValidation.jsp?func_mode=col_sum"+param1,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var retValArr = retVal.split(":::");
	if(retValArr.length == 2)
	{	
	p_session_id = retValArr[0];
	p_pgm_date = retValArr[1];
	
	var htmlVal = "<html><body>";
	htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
	htmlVal += "<input type='hidden' name='P_PGM_ID' id='P_PGM_ID' value='"+pgm_id+"'>";
	htmlVal += "<input type='hidden' name='P_PGM_DATE' id='P_PGM_DATE' value='"+p_pgm_date+"'>";
	htmlVal += "<input type='hidden' name='P_SESSION_ID' id='P_SESSION_ID' value='"+p_session_id+"'>";
	htmlVal += "<input type='hidden' name='P_FACILITY_ID' id='P_FACILITY_ID' value='"+P_FACILITY_ID+"'>";
	htmlVal += "<input type='hidden' name='P_language_id' id='P_language_id' value='"+P_language_id+"'>";
	htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'>";
	htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
	htmlVal += "</form></body></html>";
 
	dummy_frame.document.body.insertAdjacentHTML("afterbegin",HTMLVal);
	dummy_frame.document.dummy_frm.submit();		 
	}
	else{
		alert(retValArr[1]); 
		}
}	

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

