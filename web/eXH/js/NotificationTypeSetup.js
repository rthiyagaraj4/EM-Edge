function apply()
{
	var fields = new Array(frames[1].document.getElementById("typeCode"), frames[1].document.forms[0].shortDesc);
	var names = new Array("Type Code", "Short Desc");

	if(!transactionFrame.checkFields(fields, names, messageFrame))	
	{
		if(!trimCheck(frames[1].document.getElementById("typeCode").value)) frames[1].document.getElementById("typeCode").focus();
		else frames[1].document.getElementById("shortDesc").focus();
	}
	else
	{
		window.transactionFrame.document.forms[0].submit();
	}
	window.commontoolbarFrame.document.location.reload();
}

function init()
{
	if($("#mode").val() == "U")
	{
		$("#shortDesc").focus();
	}
	else
	{
		$("#typeCode").focus();
	}
}

function create()
{
	window.transactionFrame.location.href = "../../eXH/jsp/NotificationTypeSetup.jsp?mode=I";
	window.messageFrame.location.href = "../../eCommon/html/blank.html";
}

function query()
{
	window.transactionFrame.location.href = "../../eXH/jsp/NotificationTypeSetupQueryCriteria.jsp";
	window.messageFrame.location.href = "../../eCommon/html/blank.html";
}

function funModify(obj)
{
	document.forms[0].action = "../servlet/eXH.NotificationTypeSetupServlet?requestType=NOTIFICATION_TYPE_INFO&typeCode="+obj.typeCode;	
	document.forms[0].submit();
}

function deleterecord()
{
	window.transactionFrame.document.forms[0].action = "../servlet/eXH.NotificationTypeSetupServlet?requestType=DELETE";	
	window.transactionFrame.document.forms[0].submit();
	window.commontoolbarFrame.document.location.reload();
}

function funAction(actionType)
{
	$("#action_type").val(actionType);
	$("#requestType").val("QUERY");
	$("#trasaction").prop("target", "notificationTypeList");
	$("#notificationTypeList").submit();
}

function reset()
{
	window.transactionFrame.document.forms[0].reset();
}
