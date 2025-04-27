/* 
Sr No        Version           Incident        SCF/CRF                   Developer Name
---------------------------------------------------------------------------------------
1            V201027            74212       MOHE-CRF-0050.2 US004         Ram kumar S
2            V201202            9595        MOHE-CRF-0050.2 US004         Ram kumar S
 */

//V201202 Starts
function process(date){
   var parts = date.split("/");
   return new Date(parts[2], parts[1] - 1, parts[0]);
}
//V201202 Ends

function run() {
	var facilityId=window.frames["billsperiodreport"].document.getElementById("facilityId").value;
	var locale=window.frames["billsperiodreport"].document.getElementById("locale").value;
	var from_date=window.frames["billsperiodreport"].document.getElementById("fm_bill_date").value;
	var to_date=window.frames["billsperiodreport"].document.getElementById("to_bill_date").value;
	var episodeType=window.frames["billsperiodreport"].document.getElementById("EpisodeType").value;
	var billingType=window.frames["billsperiodreport"].document.getElementById("BillingType").value;
	var userId=window.frames["billsperiodreport"].document.getElementById("p_user_id").value;
	var postBillsOnly="";
	if($("#postBillsOnly",window.frames["billsperiodreport"].document).prop('checked') == true){
		postBillsOnly="Y";
	}else{
		postBillsOnly="N";
	}
	if (from_date!=null && from_date !="" && to_date!=null && to_date !="" && process(from_date) > process(to_date)) { // V201202 Modified
		alert(getMessage('BL7060', 'BL'));
		return false;
	}else if(episodeType=="Select"){    // V201202 Added if Condition
		alert(getMessage('BL00948','BL'));
		window.frames["billsperiodreport"].document.getElementById("EpisodeType").focus();
		return false;
	}else if(billingType=="Select"){   // V201202 Added if Condition
		alert(getMessage('BL00948','BL'));
		window.frames["billsperiodreport"].document.getElementById("BillingType").focus();
		return false;
	}
	else{
		var p_report_id="BLRITBFP";
		var p_module_id = "BL";
		var detailed_yn ='Y';
		$.ajax({
			type:"POST",
			url:"../jsp/TotBillForPeriodCommon.jsp",
			data:"func_mode=TotalBillsForPeriod"+
				"&p_report_id="+p_report_id+
				"&param1="+from_date+
				"&param2="+to_date+
				"&param3="+episodeType+
				"&param4="+billingType+
				"&param5="+userId+
				"&param6="+postBillsOnly,
			dataType:"text",
			async:false,
			success: function(data){
				var dummyDoc = window.frames["dummy_frame"].document;
				var retVal = trimString(data).split(":::");
				var session_id;
				var pgm_date;
				if(retVal.length == 2){
					session_id = trimString(retVal[0]);
					pgm_date = trimString(retVal[1]);
				}
				var htmlVal = "<html><body>";
				htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
				htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
				htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
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
}

function reset() {
	billsperiodreport.document.location.reload();          // V201202 Modified
	billsperiodreport.document.location.href = '../../eCommon/jsp/blank.html';   // V201202 Modified
}

//Function to Trim String
function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
	return "";
} 

// Date Format validation
function dateRegEx(e) {
	var RowIndex = e.parentNode.parentNode.rowIndex;
	var pattern = new RegExp(
			"^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$");
	if(e.value!=null && e.value!==""){    // V201202 Added If Condition 
	if (e.value.search(pattern) === 0) {
		if (isFutureDate(e.value)) {
			alert(getMessage('BL9114', 'BL'));
			$("#" + e.id).focus();
			$("#" + e.id).val(getCurrentDateTime());
			return false;
		} else {
			var dateString=e.value;
			var dateParts = dateString.split("/");
			// month is 0-based, that's why we need dataParts[1] - 1
			var d = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
			var n = d.getFullYear();
			if(n<1900){
				alert("Year should Not Be less than 1900");
				$("#" + e.id).val(getCurrentDateTime());
				return false;
			}else{
				return true;	
			}
		}
	} else {
		alert("Please provide valid date in format dd/mm/yyyy. Exapmle: 01/02/2015");
		$("#" + e.id).focus();
		$("#" + e.id).val(getCurrentDateTime());
		return false;
	}
	}else{        // V201202 Added else
		$("#" + e.id).focus();
		$("#" + e.id).val(getCurrentDateTime());
	}
}

// Function to get current date
function getCurrentDateTime() {
	var currentdate = new Date();
	var dayVal=("0" + currentdate.getDate()).slice(-2);    // V201202 Added
	var month = ("0" + (currentdate.getMonth() + 1)).slice(-2);
	var datetime = dayVal + "/" + month + "/"
			+ currentdate.getFullYear();     // V201202 Modified
	return datetime;
}

// Billing Type Change
function billTypeChange(e) {
	if (e.value == "C") {
		$("#postBillsOnly").prop('disabled', true);
	} else {
		$("#postBillsOnly").prop('disabled', false);
	}
}

// Future Date Validation
function isFutureDate(idate) {
	var today = new Date().getTime(), idate = idate.split("/");
	idate = new Date(idate[2], idate[1] - 1, idate[0]).getTime();
	return (today - idate) < 0;
}

