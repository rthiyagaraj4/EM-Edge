function reset(){	
	parent.frames[2].document.location.reload();
}

//Effective From and ToDate Logic
function toFromDateChk(obj)
{
	if(!(obj.value==""))
	{		
		var locale=document.forms[0].locale.value;
		var effFromDt =document.forms[0].fm_bill_date.value;
		var effToDt =document.forms[0].to_bill_date.value;
		var strYear;
		var arr = new Array();
		arr = effToDt.split("/");
		strYear = arr[2];		
		if(validDate(obj.value,"DMY",locale))
		{
			if(strYear < 1900)
		{
			var today = new Date();
			var mm = String(today.getDate());
			var dd = String(today.getMonth() + 1); 
			var yyyy = today.getFullYear();
			today = mm + '/' + dd + '/' + yyyy;
			document.forms[0].to_bill_date.value = today;
		}
			else if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL9114",'BL')); 
				obj.value = '';
				return false;
				return true;
			}
			else if(effFromDt != ''){
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
	//var date=obj.value;
    var strYear;
	var arr = new Array();
    arr = effFromDt.split("/");
	strYear = arr[2];
	if(entered_date.value!="")
	{
		if(validDate(entered_date.value,'DMY',locale))
		{
			if(strYear < 1900)
		{
			var today = new Date();
			var mm = String(today.getDate());
			var dd = String(today.getMonth() + 1); 
			var yyyy = today.getFullYear();
			today = mm + '/' + dd + '/' + yyyy;
			document.forms[0].fm_bill_date.value = today;
		}
			else if(!isBeforeNow(entered_date.value,'DMY',locale)){
				alert(getMessage("BL9114",'BL'));
				entered_date.value='';
				return false;
			}			
			else if(effToDt != ''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale))){
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
		return true;
	}
}


function dateRegEx(e){  //Added for Character Restriction in date field
var pattern = new RegExp("^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\/\-]\d{4}$");
var date=e.value;
alert(date);
    var strYear;
	var arr = new Array();
        arr = date.split("/");
	strYear = arr[2];
if (e.value.search(pattern)===0){
  return true;
}
else if(strYear < 1900)
{
	var today = new Date();
var mm = String(today.getDate());
var dd = String(today.getMonth() + 1); 
var yyyy = today.getFullYear();
today = mm + '/' + dd + '/' + yyyy;
document.getElementById(e.id).value = today;
}
else {
  alert("Please provide valid date in format dd/mm/yyyy");
  document.getElementById(e.id).focus();
  return false; 
} 
} 

function run()  
{
	var formsObj = parent.content.summaryreport.document.forms[0];
	 if(formsObj.episode_type.value<1)
	{
		alert(getMessage('BL9142','BL'));
		return false;
	} 
	else{
		if(formsObj.postedBills.checked)
		formsObj.postedBills.value = "Y";
		else
		formsObj.postedBills.value = "N";
	var p_report_id="BLRRVAT";
		var p_module_id = "BL";
		var detailed_yn ='Y';
		//var user = "CSCCA";
		$.ajax({
			type:"POST",
			url:"../jsp/TotBillForPeriodCommon.jsp",
			data:"func_mode=TotalBillsForPeriod"+
				"&p_report_id="+p_report_id+
				"&param1="+formsObj.fm_bill_date.value+
				"&param2="+formsObj.to_bill_date.value+
				"&param3="+formsObj.episode_type.value+
				"&param4="+formsObj.billing_type.value+
				"&param5="+formsObj.p_user_id.value+
				"&param6="+formsObj.postedBills.value+
				"&param7="+formsObj.vatRule.value,
			dataType:"text",
			async:false,
			success: function(data){
				var dummyDoc = parent.content.dummy_frame.document;
				var retVal = trimString(data).split(":::");
				var session_id;
				var pgm_date;
				if(retVal.length == 2){
					session_id = trimString(retVal[0]);
					pgm_date = trimString(retVal[1]);
				}
				var htmlVal = "<html><body>";
				htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
				htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formsObj.facilityId.value+"'>";
				htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formsObj.locale.value+"'>";
				htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
				htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
				htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+trim(pgm_date)+"'>";
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
	}	}

function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
	return "";
} 

 function billingType()
{
	var billingType = document.forms[0].billing_type.value;
	if(billingType == 'C')
	{
		if(document.forms[0].postedBills.checked == true)
			document.forms[0].postedBills.checked = false;
		document.forms[0].postedBills.disabled = true;
	}
	else if(billingType == 'A' || billingType == 'R')
	{
		document.forms[0].postedBills.disabled = false;
		document.forms[0].postedBills.checked = true;
	}
}

