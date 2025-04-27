function apply()
{
	var fields = new Array(frames[1].document.getElementById("recipientID"), frames[1].document.forms[0].shortDesc);
	var names = new Array("Recipient ID", "Short Desc");

	if(!transactionFrame.checkFields(fields, names, messageFrame))	
	{
		if(!trimCheck(frames[1].document.getElementById("recipientID").value)) frames[1].document.getElementById("recipientID").focus();
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
		$("#recipientID").focus();
	}
}

function create()
{
	window.transactionFrame.location.href = "../../eXH/jsp/NotificationRecipient.jsp?mode=I";
	window.messageFrame.location.href = "../../eCommon/html/blank.html";
}

function query()
{
	window.transactionFrame.location.href = "../../eXH/jsp/NotificationRecipientQueryCriteria.jsp";
	window.messageFrame.location.href = "../../eCommon/html/blank.html";
}

function funModify(obj)
{
	document.forms[0].action = "../servlet/eXH.NotificationRecipientServlet?requestType=RECIPIENT_INFO&recipientID="+obj.recipientID;	
	document.forms[0].submit();
}

function deleterecord()
{
	window.transactionFrame.document.forms[0].action = "../servlet/eXH.NotificationRecipientServlet?requestType=DELETE";	
	window.transactionFrame.document.forms[0].submit();
	window.commontoolbarFrame.document.location.reload();
}

function funAction(actionType)
{
	$("#action_type").val(actionType);
	$("#requestType").val("QUERY");
	$("#trasaction").prop("target", "recipientList");
	$("#recipientList").submit();
}

function reset()
{
	window.transactionFrame.document.forms[0].reset();
}
