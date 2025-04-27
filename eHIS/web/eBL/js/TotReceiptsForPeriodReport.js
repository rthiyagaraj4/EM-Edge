/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201109            74212       MOHE-CRF-0050.2      	Shikha Seth
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
		var effFromDt =document.forms[0].fm_receipt_date.value;
		var effToDt =document.forms[0].to_receipt_date.value;		
		if(validDate(obj.value,"DMY",locale))
		{
			if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){				
				alert(getMessage("BL9114",'BL')); 
				obj.value = '';
				return false;				
			}
			
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
	var effFromDt =document.forms[0].fm_receipt_date.value;
	var effToDt =document.forms[0].to_receipt_date.value;
	if(entered_date.value!="")
	{
		if(validDate(entered_date.value,'DMY',locale))
		{
			if(!isBeforeNow(entered_date.value,'DMY',locale)){
				//alert(getMessage("BL00951",'BL'));				
				alert(getMessage("BL9114",'BL'));
				entered_date.value='';
				return false;
			}			
			if(effToDt != ''){
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

function run()  
{
	var formsObj = parent.content.summaryreport.document.forms[0];	
	
	var p_report_id=formsObj.p_report_id.value;
	var p_module_id = formsObj.p_module_id.value;	
	$.ajax({
		type:"POST",
		url:"../jsp/BLCommonReportValidation.jsp",
		data:"func_mode=TotalReceiptForPeriod"+
			"&p_report_id="+p_report_id+
			"&param1="+formsObj.fm_receipt_date.value+
			"&param2="+formsObj.to_receipt_date.value+
			"&param3="+formsObj.episode_type.value+
			"&param4="+formsObj.loggedInUser.value+
			"&param5="+formsObj.receipt_refund.value+
			"&param6="+formsObj.posted_bills_only.value,			

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
}


function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
	return "";
} 

