function initNotificationDisp(noRecords)
{
	if(noRecords == 'true') {
		alert(getXHMessage('XH1021','XH','',contextPath));
		$("#requestType").val("QUERY_CRITERIA");
		$("#notificationDisp").submit();
	}
}

function initNotificationQryCrteria()
{
	var recipientType = $("#recipientType option:selected").val();
	if(recipientType != '') {
		$("#recipientSearch").removeAttr("disabled");
	}
}

async function viewMessage(messageID)
{
	var dialogHeight = "20vh";			    
	var dialogWidth  = "55vw";
	var dialogTop    = "250";
	var dialogLeft   = "400";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	var arguments = new Array();
	var url = contextPath + "/servlet/eXH.DisplayNotificationServlet?" +
				"messageID=" + messageID +
				"&requestType=GET_NOTIFICATION_CONTENT";
 
	await window.showModalDialog(url,arguments,features);
}

function funAction(actionType)
{
	$("#action_type").val(actionType);
	$("#requestType").val("GET_NOTIFICATIONS");
	$("#notificationDisp").prop("target", "notificationDisp");
	$("#notificationDisp").submit();
}

function editCriteria()
{
	$("#requestType").val("QUERY_CRITERIA");
	$("#notificationDisp").submit();
}

function submitFormOnEnter()
{
	lockKey(); // eCommon method
	var keyPressed = event.keyCode;
	if(keyPressed == 13) document.getElementById("notificationQueryCriteriaForm").submit();
}

function submitForm(obj)
{
	var type = obj.id;
	if(type == "search") {
		$("#outputType").val("DISPLAY");
	}
	else {
		$("#outputType").val("EXCEL");
	}
	document.getElementById("notificationQueryCriteriaForm").submit();
}

function initNotificationQry()
{
	document.getElementById("search").focus();
}

function query()
{
	window.notificationDisp.location.href = '../../eXH/jsp/NotificationQueryCriteria.jsp';
	window.messageFrame.location.href = '../../eCommon/html/blank.html';
}

function reset()
{
	window.notificationDisp.location.href = '../../servlet/eXH.DisplayNotificationServlet?requestType=QUERY_CRITERIA';
}