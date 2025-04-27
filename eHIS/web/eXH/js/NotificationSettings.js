var rowClassName = 'QRYEVEN';

function startTypeChange(startType)
{
	if(startType == "A")
	{
		$("#startAt").prop('disabled', false);
		$("#startAtCalendar").prop('disabled', false);
	}
	else
	{
		$("#startAt").prop('disabled', true);
		$("#startAtCalendar").prop('disabled', true);
	}
}

function repeatTypeChange(repeatType)
{
	$('#noRepeatTR').find('select').prop('disabled', true);
	$('#beforeTR').find('select').prop('disabled', true);
	$('#weekBeforeTR').find('select').prop('disabled', true);
	$('#lastTR').find('select').prop('disabled', true);

	if(repeatType == "D")
	{
		$('#noRepeatTR').find('select').prop('disabled', false);
	}
	else if(repeatType == "B")
	{
		$('#beforeTR').find('select').prop('disabled', false);
	}
	else if(repeatType == "W")
	{
		$('#weekBeforeTR').find('select').prop('disabled', false);
	}
	else if(repeatType == "L")
	{
		$('#lastTR').find('select').prop('disabled', false);
	}
}

function scheduleEventInit()
{
	startTypeChange('I');
	repeatTypeChange('D');
}

function apply()
{
	recipientSchedule.document.getElementById("requestType").value = "SAVE";
	recipientSchedule.document.getElementById("recipientSchedule").target = "messageFrame";
	recipientSchedule.document.getElementById("recipientSchedule").submit();
	window.commontoolbarFrame.document.location.reload();
}

function funAction(actionType)
{
	$("#action_type").val(actionType);
	$("#requestType").val("RECIPIENT_LIST");
	$("#recipientSchedule").prop("target", "recipientSchedule");
	$("#recipientSchedule").submit();
}

async function dispEventSchedule(fieldName)
{
	var dialogHeight = "25vh";			    
	var dialogWidth  = "50vw";
	var dialogTop    = "200";
	var dialogLeft   = "450";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	var arguments = new Array();
	var url = "../eXH/jsp/NotificationScheduleEvent.jsp";
 
	var retVal =await window.showModalDialog(url,arguments,features);
	if(retVal != null) document.getElementById(fieldName).value = retVal;
}

function eventSchedule()
{
	var startType = $("[name=startType]:checked").val();
	var remindBefore = $("#remindBefore").val();
	var remindBeforeTimeUnit = $("#remindBeforeTimeUnit").val();
	var repeatVal = '';

	repeatVal = startType + '#' + remindBefore + '#' + remindBeforeTimeUnit;
alert(repeatVal);
	window.returnValue = repeatVal;
	window.close();
}

function messageTypeChange()
{
	populateEventList();
	$("#searchCriteria").prop("target", "recipientSchedule");
	document.getElementById("searchCriteria").action = "../servlet/eXH.NotificationSettingsServlet";
	$("#searchCriteria").submit();
}

function eventTypeChange()
{
	$("#searchCriteria").prop("target", "recipientSchedule");
	document.getElementById("searchCriteria").action = "../servlet/eXH.NotificationSettingsServlet";
	$("#searchCriteria").submit();
}

function populateEventList()
{
	var dataElements = "messageType=" + $("#messageType").val() + "&requestType=GET_EVENTS";

	$.ajax({
		type: "POST",
		async: false,
		url: '../servlet/eXH.NotificationSettingsServlet',
		data: dataElements,
		success: function (data) {
			var select = $('#eventType').empty();
			$.each(data, function (key, value) {
			$('#eventType').append('<option value="' + key + '">' + value + '</option>');
			});
		},
		dataType: 'json'
	});	
}