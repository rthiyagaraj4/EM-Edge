/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201028            74212       MOHE-CRF-0050.2      	Shikha Seth
*/
function reset(){	
	parent.frames[2].document.location.reload();
}

//Effective From and ToDate Logic
function toFromDateChk(obj)
{
	if(!(obj.value==""))
	{		
		var locale=document.forms[0].locale.value;
		var effFromDt =document.forms[0].fm_report_date.value;
		var effToDt =document.forms[0].to_report_date.value;		
		if(validDate(obj.value,"DMYHM",locale))
		{
			if(  effToDt!=getCurrentDate('DMYHM',locale) && isAfterNow(effToDt,'DMYHM',locale)==true){
				//alert(getMessage("BL00952",'BL'));
				alert(getMessage("BL9114",'BL')); 
				obj.value = '';
				return false;				
			}
			/*if(effToDt==getCurrentDate('DMY',locale)){
				alert(getMessage("BL1470",'BL'));
				obj.value = '';
				return false;
				return true;
			}*/
			if(effFromDt != ''){
				if((!isBefore(effFromDt,effToDt,'DMYHM',locale)))
				{		
					//alert(getMessage("BL4115",'BL'));
					alert(getMessage("BL7060",'BL'));
					obj.value = '';
					return false;
				}
				else
				{			
					return true;
				}
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
	var effFromDt =document.forms[0].fm_report_date.value;
	var effToDt =document.forms[0].to_report_date.value;
	if(entered_date.value!="")
	{
		if(validDate(entered_date.value,'DMYHM',locale)) //DMY
		{
			if(!isBeforeNow(entered_date.value,'DMYHM',locale)){
				//alert(getMessage("BL00951",'BL'));				
				alert(getMessage("BL9114",'BL'));
				entered_date.value='';
				return false;
			}			
			if(effToDt != ''){
				if((!isBefore(effFromDt,effToDt,'DMYHM',locale))){
					alert(getMessage("BL00953",'BL'));
					entered_date.value='';
					return false;
			}
			else{
					return true;
			}
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
		//alert(getMessage("BL00948",'BL')); 
		//document.CashCollectionPeriod.fm_report_date.focus();
		return false;		
	}
}
//Effective From and ToDate Logic


function dateRegEx(e){  //Added for Character Restriction in date field
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

//V201024 start
function run()  
{
	var formObj = parent.content.summaryreport.document.forms[0];	
	var fm_report_date=formObj.fm_report_date.value;	
	var to_report_date=formObj.to_report_date.value;
	var fm_report_date1 = formObj.fm_report_date;
	if(fm_report_date=='' || fm_report_date == 'undefined') {		
		alert(getMessage("BL00948",'BL')); 
		return false;
	}
	if(to_report_date=='' || to_report_date == 'undefined') {
		alert(getMessage("BL00948",'BL')); 
		return false;
	}
	if (formObj.fm_cash_counter1.value != '' && formObj.to_cash_counter1.value != '') {
		if (formObj.fm_cash_counter1.value > formObj.to_cash_counter1.value) {
			alert(getMessage("BL7060",'BL'));
			formObj.to_cash_counter.value = '';
			formObj.to_cash_counter1.value = '';
			return false;
		}
	}
	if (formObj.fm_recpt_nature1.value != '' && formObj.to_recpt_nature1.value != '') {
		if (formObj.fm_recpt_nature1.value > formObj.to_recpt_nature1.value) {
			alert(getMessage("BL7060",'BL'));
			formObj.to_recpt_nature.value = '';
			formObj.to_recpt_nature1.value = '';
			return false;
		}
	}
	if (formObj.fm_recpt_type1.value != '' && formObj.to_recpt_type1.value != '') {
		if (formObj.fm_recpt_type1.value > formObj.to_recpt_type1.value) {
			alert(getMessage("BL7060",'BL'));
			formObj.to_recpt_type.value = '';
			formObj.to_recpt_type1.value = '';
			return false;
		}
	}
	if (formObj.fm_stlmnt_type1.value != '' &&  formObj.to_stlmnt_type1.value != '') {
		if (formObj.fm_stlmnt_type1.value > formObj.to_stlmnt_type1.value) {
			alert(getMessage("BL7060",'BL'));
			formObj.to_stlmnt_type.value = '';
			formObj.to_stlmnt_type1.value = '';
			return false;
		}
	}
	var p_report_id=formObj.p_report_id.value;
	var p_module_id = formObj.p_module_id.value;	
	$.ajax({
		type:"POST",
		url:"../jsp/BLCommonReportValidation.jsp",
		data:"func_mode=CashCollectionPeriod"+
			"&p_report_id="+p_report_id+
			"&param1="+formObj.fm_report_date.value+
			"&param2="+formObj.to_report_date.value+
			"&param3="+formObj.fm_cash_counter1.value+
			"&param4="+formObj.to_cash_counter1.value+
			"&param5="+formObj.fm_recpt_nature1.value+
			"&param6="+formObj.to_recpt_nature1.value+
			"&param7="+formObj.fm_recpt_type1.value+
			"&param8="+formObj.to_recpt_type1.value+
			"&param9="+formObj.fm_stlmnt_type1.value+
			"&param10="+formObj.to_stlmnt_type1.value+
			"&param11="+formObj.CancelledDocsOnly.value+
			"&param12="+formObj.ReceiptsRefundsBoth.value,			

		dataType:"text",
		async:false,
		success: function(data){			
			var retVal = trimString(data).split(":::");			
			var session_id;
			var pgm_date;
			if(retVal.length == 2){
				session_id = trimString(retVal[0]);
				pgm_date = trimString(retVal[1]);
			}			
	
			var dummyDoc = parent.content.messageFrame.document;
			var htmlVal = "<html><body>";
			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.facilityId.value+"'>";
			htmlVal += "<input type='hidden' name='facility_id' id='facility_id' value='"+formObj.facilityId.value+"'>";
			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.locale.value+"'>";
			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
			htmlVal += "<input type='hidden' name='session_id' id='session_id' value='"+session_id+"'>";
			htmlVal += "<input type='hidden' name='pgm_date' id='pgm_date' value='"+trim(pgm_date)+"'>";
			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'>";
			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+p_report_id+"'>";			
			htmlVal += "</form></body></html>";			
			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
			dummyDoc.dummy_frm.submit();
			},
			 error: function(data){
				 alert(data);
		  }
	});	
}

function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
	return "";
} 


function counterLookup_fm(){
	var facility=document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
	var sql="";	
	sql="select distinct cash_counter_code code, long_desc description from bl_cash_counter_lang_vw WHERE language_id = '"+locale+"' and upper(operating_facility_id) = '"+facility+"' AND UPPER (cash_counter_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) order by 2 " 
	var title									= 	getLabel("eBL.CASH_COUNTER.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.fm_cash_counter.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{
		formObj.fm_cash_counter.value			=   retVal[1];
		formObj.fm_cash_counter1.value 				= 	retVal[0];
	}
	else
	{	
		formObj.fm_cash_counter.value			=   "";
		formObj.fm_cash_counter1.value 				= 	"";	
	}	
	if (formObj.to_cash_counter1.value != '' && formObj.to_cash_counter1.value != 'undefined' ) {
		if (formObj.fm_cash_counter1.value > formObj.to_cash_counter1.value) {
			alert(getMessage("BL7060",'BL'));
			formObj.fm_cash_counter.value = '';
			formObj.fm_cash_counter1.value = '';
			return false;
		}
	}
	
}


function counterLookup(){
	var facility=document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
	var sql="";
	
	sql="select distinct cash_counter_code code, long_desc description from bl_cash_counter_lang_vw WHERE language_id = '"+locale+"' and upper(operating_facility_id) = '"+facility+"' AND UPPER (cash_counter_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) order by 2 " 
	var title									= 	getLabel("eBL.CASH_COUNTER.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.to_cash_counter.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{	
		formObj.to_cash_counter.value			=   retVal[1];
		formObj.to_cash_counter1.value 				= 	retVal[0];
	}
	else
	{	
		formObj.to_cash_counter.value			=   "";
		formObj.to_cash_counter1.value 				= 	"";	
	}	
	
	if (formObj.fm_cash_counter1.value > formObj.to_cash_counter1.value) {
		alert(getMessage("BL7060",'BL'));
		formObj.to_cash_counter.value = '';
		formObj.to_cash_counter1.value = '';
		return false;
	}
}

function recptNatureFM(){
	var facility=document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
	var module_id = document.forms[0].p_module_id.value;
	var FUNCTION_ID = document.forms[0].FUNCTION_ID.value;
	var sql="";	
	sql="select distinct LABEL_REF code, LABEL_VALUE description from SM_FUNCTION_LEGEND_LANG WHERE MODULE_ID ='"+module_id+"' and FUNCTION_ID ='"+FUNCTION_ID+"' and LABEL_TYPE = 'DV' AND language_id = '"+locale+"'  AND UPPER (LABEL_REF) LIKE UPPER (?) AND UPPER (LABEL_VALUE) LIKE UPPER (?) order by 2 " 
	var title									= 	getLabel("eBL.REC_NATURE.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.fm_recpt_nature.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{	
		formObj.fm_recpt_nature.value			=   retVal[1];
		formObj.fm_recpt_nature1.value 				= 	retVal[0];
	}
	else
	{	
		formObj.fm_recpt_nature.value			=   "";
		formObj.fm_recpt_nature1.value 				= 	"";	
	}

	if (formObj.to_recpt_nature1.value != '' && formObj.to_recpt_nature1.value != 'undefined') {
		if (formObj.fm_recpt_nature1.value > formObj.to_recpt_nature1.value) {
			alert(getMessage("BL7060",'BL'));
			formObj.fm_recpt_nature.value = '';
			formObj.fm_recpt_nature1.value = '';
			return false;
		}
	}
}

function recptNatureTO(){
	var facility=document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
	var module_id = document.forms[0].p_module_id.value;
	var FUNCTION_ID = document.forms[0].FUNCTION_ID.value;
	var sql="";
	
	sql="select distinct LABEL_REF code, LABEL_VALUE description from SM_FUNCTION_LEGEND_LANG WHERE MODULE_ID ='"+module_id+"' and FUNCTION_ID ='"+FUNCTION_ID+"' and LABEL_TYPE = 'DV' AND language_id = '"+locale+"'  AND UPPER (LABEL_REF) LIKE UPPER (?) AND UPPER (LABEL_VALUE) LIKE UPPER (?) order by 2 " 
	var title									= 	getLabel("eBL.REC_NATURE.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.to_recpt_nature.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{	
		formObj.to_recpt_nature.value			=   retVal[1];
		formObj.to_recpt_nature1.value 				= 	retVal[0];
	}
	else
	{	
		formObj.to_recpt_nature.value			=   "";
		formObj.to_recpt_nature1.value 				= 	"";	
	}	
	if (formObj.fm_recpt_nature1.value > formObj.to_recpt_nature1.value) {
		alert(getMessage("BL7060",'BL'));
		formObj.to_recpt_nature.value = '';
		formObj.to_recpt_nature1.value = '';
		return false;
	}
}

function recptTypeFM() {
	var facility=document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
	var sql="";	
	sql="select distinct receipt_type_code code, long_desc description from bl_receipt_type_lang_vw WHERE language_id = '"+locale+"'  AND UPPER (receipt_type_code) LIKE UPPER (?) AND UPPER (long_desc) LIKE UPPER (?) order by 2 " 
	var title									= 	getLabel("eBL.RECEIPT_TYPE.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.fm_recpt_type.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{	
		formObj.fm_recpt_type.value			=   retVal[1];
		formObj.fm_recpt_type1.value 				= 	retVal[0];
	}
	else
	{	
		formObj.fm_recpt_type.value			=   "";
		formObj.fm_recpt_type1.value 				= 	"";	
	}

	if (formObj.to_recpt_type1.value != '' && formObj.to_recpt_type1.value != 'undefined') {
		if (formObj.fm_recpt_type1.value > formObj.to_recpt_type1.value) {
			alert(getMessage("BL7060",'BL'));
			formObj.fm_recpt_type.value = '';
			formObj.fm_recpt_type1.value = '';
			return false;
		}
	}
}

function recptTypeTO() {
	var facility=document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
	var sql="";	
	sql="select distinct receipt_type_code code, long_desc description from bl_receipt_type_lang_vw WHERE language_id = '"+locale+"'  AND UPPER (receipt_type_code) LIKE UPPER (?) AND UPPER (long_desc) LIKE UPPER (?) order by 2 " 
	var title									= 	getLabel("eBL.RECEIPT_TYPE.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.to_recpt_type.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{	
		formObj.to_recpt_type.value			=   retVal[1];
		formObj.to_recpt_type1.value 				= 	retVal[0];
	}
	else
	{	
		formObj.to_recpt_type.value			=   "";
		formObj.to_recpt_type1.value 				= 	"";	
	}	
	if (formObj.fm_recpt_type1.value > formObj.to_recpt_type1.value) {
		alert(getMessage("BL7060",'BL'));
		formObj.to_recpt_type.value = '';
		formObj.to_recpt_type1.value = '';
		return false;
	}
}

function stlmntTypeFM() {
	var facility=document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
	var sql="";		
	sql="select distinct slmt_type_code code, long_desc description from bl_slmt_type_lang_vw WHERE language_id = '"+locale+"'  AND UPPER (slmt_type_code) LIKE UPPER (?) AND UPPER (long_desc) LIKE UPPER (?) order by 2 " 
	var title									= 	getLabel("eBL.IRBSettlementType.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.fm_stlmnt_type.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{	
		formObj.fm_stlmnt_type.value			=   retVal[1];
		formObj.fm_stlmnt_type1.value 				= 	retVal[0];
	}
	else
	{	
		formObj.fm_stlmnt_type.value			=   "";
		formObj.fm_stlmnt_type1.value 				= 	"";	
	}	
	
	if (formObj.to_stlmnt_type1.value != '' && formObj.to_stlmnt_type1.value != 'undefined' ) {
		if (formObj.fm_stlmnt_type1.value > formObj.to_stlmnt_type1.value) {
			alert(getMessage("BL7060",'BL'));
			formObj.fm_stlmnt_type.value = '';
			formObj.fm_stlmnt_type1.value = '';
			return false;
		}
	}
}

function stlmntTypeTO() {
	var facility=document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
	var sql="";	
	sql="select distinct slmt_type_code code, long_desc description from bl_slmt_type_lang_vw WHERE language_id = '"+locale+"'  AND UPPER (slmt_type_code) LIKE UPPER (?) AND UPPER (long_desc) LIKE UPPER (?) order by 2 " 
	var title									= 	getLabel("eBL.IRBSettlementType.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.to_stlmnt_type.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{	
		formObj.to_stlmnt_type.value			=   retVal[1];
		formObj.to_stlmnt_type1.value 				= 	retVal[0];
	}
	else
	{	
		formObj.to_stlmnt_type.value			=   "";
		formObj.to_stlmnt_type1.value 				= 	"";	
	}	
	if (formObj.fm_stlmnt_type1.value > formObj.to_stlmnt_type1.value) {
		alert(getMessage("BL7060",'BL'));
		formObj.to_stlmnt_type.value = '';
		formObj.to_stlmnt_type1.value = '';
		return false;
	}
}

