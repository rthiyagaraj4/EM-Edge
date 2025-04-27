/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function validateProcDocFeeDate()
{
	parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	var procDate = document.getElementById('processDate').value;
	var locale = document.getElementById('locale').value;

	if(procDate != "")
	{
		var isBefore = isBeforeNow(procDate, 'MY', locale);
		if(isBefore == false)
		{
			alert('Current Process Month/Year cannot be greater than current month');
			document.getElementById('processDate').focus();
			return false;
		}
	}
}

function submitForm()
{
	parent.monitorItemsMoreCriteria.document.searchCriteria.reset();
	parent.schemaBrowserResultFrame.location.href = "../../eCommon/html/blank.html";

	var procDate = document.getElementById('processDate').value;
	if(procDate == "")
	{
		var message = getMessage('CAN_NOT_BE_BLANK','common');
		message = message.replace('$', getLabel('Common.CurrentProcessMonth/Year.label', 'common'));
		alert(message);
		document.getElementById('processDate').focus();
		return false;
	}
	
	parent.commontoolbarFrame.location.href = "../../eCommon/html/process.html";
	document.forms[0].submit();
}

function reset()
{
	window.f_query_add_mod.document.ssMonDPReportForm.reset();
}

function initFunc()
{	
	var locale = document.getElementById("locale").value;
	var currentDate = getCurrentDate('MY', locale);	
	var lastMonth = getMonthOfYear(currentDate, 'MY', locale) - 1;
	var currentYear = getYear(currentDate, 'MY', locale);
	if(lastMonth < 10) lastMonth = "0" + lastMonth;
	var processDate = lastMonth + "/" + currentYear;
	document.getElementById("processDate").value = processDate;
}
