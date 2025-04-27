
	function isNumber(char) {
		return /^\d$/.test(char);
	}

	//to check if from date range is greater than 31 days
	function checkDateRange() {
	    var fromDateInput = document.getElementById('specimen_from_date').value;
	    var toDateInput = document.getElementById('specimen_to_date').value;

	    // Check if the input values are not empty
	    if (!fromDateInput || !toDateInput) {
	        alert('Please enter both From Date and To Date.');
	        return false;
	    }

	    // Parse the date inputs into Moment.js objects
	    var fromDate = moment(fromDateInput, 'DD/MM/YYYY HH:mm', true);
	    var toDate = moment(toDateInput, 'DD/MM/YYYY HH:mm', true);

	    // Check if the input dates are valid
	    if (!fromDate.isValid() || !toDate.isValid()) {
	        alert('Invalid date time format [Date/Time Format: DD/MM/YYYY HH:mm]');
	        return false;
	    }

	    // Check if either of the dates is greater than the current date and time
	    var currentDateAndTime = moment();
	    if (toDate.isAfter(currentDateAndTime) || fromDate.isAfter(currentDateAndTime)) {
	        alert('APP-000016 Date cannot be greater than System Date');
	        return false;
	    }

	    // Calculate the difference between the two dates in days
	    var daysDifference = toDate.diff(fromDate, 'days');

	    if (daysDifference > 31) {
	        alert('Difference between From Date and To Date should not be greater than 31 days');
	        return false;
	    } else if (daysDifference < 0) {
	        alert('APP-000016 Date cannot be greater than System Date');
	        return false;
	    } else if (daysDifference === 0) {
	        // Check time components
	        var hoursDifference = toDate.diff(fromDate, 'hours');

	        if (hoursDifference === 0) {
	            // Check minute components
	            var minutesDifference = toDate.diff(fromDate, 'minutes');

	            if (minutesDifference === 0) {
	                alert('Cannot fetch data between the same date and time');
	                return false;
	            } else if (minutesDifference < 0) {
	                alert('APP-000016 Date cannot be greater than System Date');
	                return false;
	            }
	        } else if (hoursDifference < 0 || hoursDifference > 23) {
	            alert('Invalid Time: Hours should be between 0 and 23');
	            return false;
	        }
	    }

	    // If all validations pass, you can call your fetchTableDetails function here
	    fetchTableDetails();
	    return true;
	}
	
var myTimeout;
	function load() {
		var allowNotificationUser = document.getElementById('allowedUserOrNot').value;
		if(allowNotificationUser === 'N'){
			document.getElementById('resubmitButton').disabled = true;	
		}
		
		var refInterval = document.getElementById('ref_interval').value;
		var convertMinutesToMilliseconds = refInterval * 60000;
		showAlert(convertMinutesToMilliseconds);

	}
	function showAlert(convertMinutesToMilliseconds) {
		//var convertMilliSecondsToMinutes = convertMinutesToMilliseconds / 1000;
		// setInterval(fetchTableDetails, convertMinutesToMilliseconds);
		fetchTableDetails();
		
	}


function fetchTableDetails() {
		document.getElementById('last_ref_date_time').disabled = true;
		document.getElementById('next_ref_date_time').disabled = true;
		var specimenToDate = document.getElementById('specimen_to_date').value;
		var specimenFromDate = document.getElementById('specimen_from_date').value;
		var applicationId = document.getElementById('app_id').value;
		var eventType = document.getElementById('event_type').value;
		var notificationStatus = document.getElementById('notification_status').value;

		if (applicationId == '') {
			alert('Please select the Application ID');
			document.getElementById('app_id').focus();
			return false;
		} else if (eventType == '') {
			alert('Please select the Event Type');
			document.getElementById('event_type').focus();
			return false;
		}

		var url = "TrackNotificationTable.jsp?app_id=" + applicationId
				+ "&event_type=" + eventType + "&specimen_to_date="
				+ specimenToDate + "&specimen_from_date=" + specimenFromDate
				+ "&notification_status=" + notificationStatus;

		request = new XMLHttpRequest();
		try {
			request.open("GET", url, false);
			request.send();
			document.getElementById('tabledata').innerHTML = request.responseText;
			
			// to not show the table if the data from database is empty based on the filtered values
			var isDataPresent = document.getElementById('isTableDataPresent').value;
			if(isDataPresent == 'false'){
				document.getElementById('tab').style.display = 'none';
				alert('Query Caused No Records');
				return false;
			}
			
			var table = document.getElementById('tableDetails');
			var allowNotificationUser = document.getElementById('allowedUserOrNot').value;
			checkboxes = document.getElementsByName('checkAll');
			
			// to disable all the checkboxes, if allow_notification_yn user is 'N'
			if(allowNotificationUser === 'N'){
				document.getElementById('checkAll').disabled = true;
				
				for (var i = 1, row; row = table.rows[i]; i++) {					
						checkboxes[i].disabled = true;	
				}
	
			}
			
			var table = document.getElementById('tableDetails');
			checkboxes = document.getElementsByName('checkAll');
			for (var i = 0, row; row = table.rows[i]; i++) {
				for (var j = 0, col; col = row.cells[j]; j++) {

					var cellValString = table.rows[i].cells[j].innerHTML;
					
					if ((cellValString === "Not Submitted ")
							|| (cellValString === "Not Submitted") || (cellValString === "Failed ")
							|| (cellValString === "Failed")) {
						
						table.rows[i].style.background = "#E58E8A";
					}
					if((cellValString === "Pending ")
							|| (cellValString === "Pending")){
						checkboxes[i].disabled = true;
					}
				}
			}

			updateRefreshInterval();
		} catch (e) {
			alert("Query caused no records");
		}
		
		
	}


function selectAll(source) {
		var checkboxes = document.getElementsByName('checkAll');
		var tableInSelectAll = document.getElementById('tableDetails');

		for (var i = 0, row; row = tableInSelectAll.rows[i]; i++) {
			for (var j = 0, col; col = row.cells[j]; j++) {

				var cellVal = tableInSelectAll.rows[i].cells[j].innerHTML;

				if ((cellVal === "E ")
						|| (cellVal === "E")) {
					checkboxes[i].checked = source.checked;
				}
			}
		}
}



function myReset() {
		document.getElementById("trackNotification").reset();
	}


function exporting() {
	var app_id = document.getElementById("app_id").value;
	var event_type = document.getElementById("event_type").value;
	var notification_status = document.getElementById("notification_status").value;
	var specimen_from_date = document.getElementById("specimen_from_date").value;
	var specimen_to_date = document.getElementById("specimen_to_date").value;
	var onlyRequiredColumnCompleteQuery = document.getElementById("onlyRequiredColumnCompleteQuery").value;
	
	
	var action_url	="../../eXH/jsp/ExportReport.jsp?app_id="+app_id+"&event_type="+event_type+"&notification_status="+notification_status+"&specimen_from_date="+specimen_from_date+"&specimen_to_date="+specimen_to_date+"&onlyRequiredColumnCompleteQuery="+onlyRequiredColumnCompleteQuery;

	var center='1';
	var dialogTop = "300";
	var dialogHeight = "15" ;
	var dialogWidth = "30" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
	var arguments = "" ;
	
	var retVal=window.showModalDialog(action_url,arguments,features);	
    return retVal;
 }

function closeExportReport() {
    window.close();
}
/*
function exportingTrackNotification() {
	 
	var app_id = document.getElementById("app_id").value;
	var event_type = document.getElementById("event_type").value;
	var notification_status = document.getElementById("notification_status").value;
	var specimen_from_date = document.getElementById("specimen_from_date").value;
	var specimen_to_date = document.getElementById("specimen_to_date").value;
	var onlyRequiredColumnCompleteQuery = document.getElementById("onlyRequiredColumnCompleteQuery").value;
	
	  var reportOptionElement = document.getElementById('reportOption');
	  var selectedOption = reportOptionElement.options[reportOptionElement.selectedIndex];
	  var ro = selectedOption.value;
	  
	  var fileFormatElement = document.getElementById('fileFormat');
	  var selectedFormatOption = fileFormatElement.options[fileFormatElement.selectedIndex];
	  var ff = selectedFormatOption.value;
	  
	  if (ro === 'Print') {
	    if (ff === 'SpreadSheet') {
            document.forms[0].action = "../../servlet/eXH.NotificationEventsToXLServlet?app_id="+app_id+"&event_type="+event_type+"&notification_status="+notification_status+"&specimen_from_date="+specimen_from_date+"&specimen_to_date="+specimen_to_date+"&onlyRequiredColumnCompleteQuery="+onlyRequiredColumnCompleteQuery;
	    }
	   
	  } else if (ro === 'View') {
	    if  (ff === 'SpreadSheet') {
	    	document.forms[0].action = "../../servlet/eXH.NotificationEventsToXLServlet?app_id="+app_id+"&event_type="+event_type+"&notification_status="+notification_status+"&specimen_from_date="+specimen_from_date+"&specimen_to_date="+specimen_to_date+"&onlyRequiredColumnCompleteQuery="+onlyRequiredColumnCompleteQuery;	      
	    }
	    
	  } else if (ro === 'Save') {
	    if (ff === 'SpreadSheet') {
	    	document.forms[0].action = "../../servlet/eXH.NotificationEventsToXLServlet?app_id="+app_id+"&event_type="+event_type+"&notification_status="+notification_status+"&specimen_from_date="+specimen_from_date+"&specimen_to_date="+specimen_to_date+"&onlyRequiredColumnCompleteQuery="+onlyRequiredColumnCompleteQuery;   
	  }
	  //alert('Submiting...');
	  this.document.forms[0].submit();
	}

}
*/

function exportingTrackNotification() {
    var app_id = document.getElementById("app_id").value;
    var event_type = document.getElementById("event_type").value;
    var notification_status = document.getElementById("notification_status").value;
    var specimen_from_date = document.getElementById("specimen_from_date").value;
    var specimen_to_date = document.getElementById("specimen_to_date").value;
    var onlyRequiredColumnCompleteQuery = document.getElementById("onlyRequiredColumnCompleteQuery").value;

    var reportOptionElement = document.getElementById('reportOption');
    var selectedOption = reportOptionElement.options[reportOptionElement.selectedIndex];
    var ro = selectedOption.value;

    var fileFormatElement = document.getElementById('fileFormat');
    var selectedFormatOption = fileFormatElement.options[fileFormatElement.selectedIndex];
    var ff = selectedFormatOption.value;

    if ((ro === 'view' || ro === 'print' || ro === 'Save') && ff === 'SpreadSheet') {

        document.forms[0].action = "../../servlet/eXH.NotificationEventsToXLServlet?app_id=" + app_id +
            "&event_type=" + event_type +
            "&notification_status=" + notification_status +
            "&specimen_from_date=" + specimen_from_date +
            "&specimen_to_date=" + specimen_to_date +
            "&onlyRequiredColumnCompleteQuery=" + onlyRequiredColumnCompleteQuery;

        if (ro === 'view') {
             alert('Submit...');
            document.forms[0].submit();
        }
        if (ro === 'Save') {
            alert('Submitting...');
           document.forms[0].submit();
        }    
    }
}

function resubmit(){
	document.getElementById('last_ref_date_time').disabled = true;
	document.getElementById('next_ref_date_time').disabled = true;
	var specimenToDate = document.trackNotification.specimen_to_date.value;
	var specimenFromDate = document.trackNotification.specimen_from_date.value;
	var applicationId = document.getElementById("app_id").value;
	var eventType = document.trackNotification.event_type.value;
	var notificationStatus = document.trackNotification.notification_status.value;
	var messageId;
	var tableInSelectAll;

	if (applicationId == '') {
		alert('Please select the Application ID');
		document.getElementById('app_id').focus();
		return false;
	} else if (eventType == '') {
		alert('Please select the Event Type');
		document.getElementById('event_type').focus();
		return false;
	}

	checkboxes = document.getElementsByName('checkAll');
	var countOfCheckedBoxes = 0;
	tableInSelectAll = document.getElementById('tableDetails');
	var cbox = document.getElementById('checkingBox');

	if(tableInSelectAll == null){
		alert('Nothing is selected to re-submit');
		return false;
	}
	
	var messageIdArrayToString="";
	
	//for (var i = 0, row; row = tableInSelectAll.rows[i]; i++) {
	var i=0;
	var row = tableInSelectAll.rows[i];
		for (var j = 0, col; col = row.cells[j]; j++) {
			var headerVal = tableInSelectAll.rows[i].cells[j].innerHTML;
			var messageIdArray = new Array();

			//alert(headerVal);
			
			if((headerVal === 'MESSAGE_ID ')||(headerVal === 'MESSAGE_ID')){
					var index=0;
					for(var x=1; x<checkboxes.length; x++){
						if (checkboxes[x].type == "checkbox" && checkboxes[x].checked == true){
							countOfCheckedBoxes++;
							messageId = tableInSelectAll.rows[x].cells[j].innerHTML;
							var messageIdAfterTrim = messageId.replace(/\s/g,"");
							messageIdArray[index] = messageIdAfterTrim;
							index++;
					       }
					}
					messageIdArrayToString = messageIdArray.toString();
					//messageIdArrayToString = messageIdArrayToString.replace(/\s/g, "");

					if(countOfCheckedBoxes === 0){
						alert("Please select the checkbox to Re-Submit");
						return false;
					}
			}
		}
	//}

	alert("messageIdArrayToString..."+messageIdArrayToString);
	
	var url = "TableNotificationUpdate.jsp?app_id=" + applicationId
	+ "&event_type=" + eventType + "&specimen_to_date="
	+ specimenToDate + "&specimen_from_date=" + specimenFromDate
	+ "&notification_status=" + notificationStatus	
	+ "&message_id=" + messageIdArrayToString;

	request = new XMLHttpRequest();
	try {
		request.open("GET", url, false);
		request.send();
		document.getElementById('resubmitteddata').innerHTML = request.responseText;
		
		alert('Selected record(s) has been re-submitted.');
		
	}
	catch (e) {
		alert("Unable to connect:");
	}
}

function exportToSpreadsheetAndDownload(tableDetails) {

	var tableHTML = tableDetails;
	
	var fileName = 'trackNotificationDetailsExcel.xls';

	var msie = window.navigator.userAgent.indexOf("MSIE ");
	if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
		dummyFrame.document.open();
		dummyFrame.document.write(tableHTML);
		dummyFrame.document.close();
		dummyFrame.focus();
		return dummyFrame.document.execCommand('SaveAs', true, fileName);
	} else {
		var a = document.createElement('a');
		tableHTML = tableHTML.replace(/  /g, '').replace(/ /g, '%20');
		a.href = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8,'
				+ tableHTML;
		a.setAttribute('download', fileName);
		document.body.appendChild(a);
		a.click();
		document.body.removeChild(a);
	}
}

function exportToSpreadsheetAndPrint(tableDetails) {

	var tableHTML = tableDetails;
	var url = '';
	
		dummyFrame.document.open();
		dummyFrame.document.write(tableHTML);
		window.open(url, '_blank').focus();
		dummyFrame.document.print();
		dummyFrame.document.close();
	
}

function onChangeApplication() {
	
	var applicationID = document.getElementById('app_id').options[document.getElementById("app_id").selectedIndex].value;
     
    if (applicationID == '' || applicationID == null) {
        var notifyEvent = document.getElementById("event_type");
        while (notifyEvent != null && notifyEvent.options.length > 1)
            notifyEvent.remove(1);

        document.getElementById("event_type").disabled = true;
    } else {
        document.getElementById("event_type").disabled = false;
    }

    if (applicationID != '' && applicationID != null) {
        var queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me WHERE M.APPLICATION_ID = NVL('" + applicationID + "',M.APPLICATION_ID) AND m.event_TYPE = ME.EVENT_TYPE";

        //eval(sendRequest(queryEventType, 'event_type', '--Select--', "both"));
        eval(sendRequest(queryEventType, 'event_type',''));
        var select = document.getElementById('event_type');
        var options = select.options;

        for (var i = 0; i < options.length; i++) {
            if (options[i].value === '') {
            	select.removeChild(options[i]);
                break;
            }
        }
    }
}

function updateRefreshInterval(){
	
	var refInterval = document.getElementById("ref_interval").value;
	
	var responseData = "";
	$.ajax({	
			url:"../../servlet/eXH.AutoRefreshPageservlet",
			type:"GET",
			dataType:"text",
			data:{
				ref_interval:refInterval
			},
			async:false,
			success:function(data){
				responseData = data;
			}	
		});
	
	
	if(responseData!=null){
		var resArray = responseData.split("$!^");
		var last_ref_date_time = resArray[0];
		var next_ref_date_time = resArray[1];
		
		if(last_ref_date_time!=null || last_ref_date_time!="")
			document.getElementById("last_ref_date_time").value= last_ref_date_time;
		
		if(next_ref_date_time!=null || next_ref_date_time!="")
			document.getElementById("next_ref_date_time").value= next_ref_date_time;
			
	}
 
	return true;
 }

	
