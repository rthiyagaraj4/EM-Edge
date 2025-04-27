function getNotifyEventList(obj) {
	var notifyEvent = document.getElementById("notifyEventId");
	while (notifyEvent != null && notifyEvent.options.length > 1)
		notifyEvent.remove(1);

	//alert("obj.value..."+obj.value);
	var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eXH/jsp/NotificationEventList.jsp'><input type='hidden' name='applicationID' id='applicationID' value='"
			+ obj.value + "'></form></BODY></HTML>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.messageFrame.document.form1.submit();

}
function apply() {
	frames[2].document.forms[0].submit();
	window.commontoolbarFrame.document.location.reload();
}

function onSuccess(){
	frames[2].location.reload();
}

function reset() {
	window.f_query_add_mod.document.forms[0].reset();
	window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
	window.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function searchNotificationDetails() {
	var appl_id = document.getElementById("appSelectId").value;
	
	if(appl_id!="" && appl_id!=null){
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/NotificationEventDtlView.jsp?Application_ID="+appl_id;
	} else {
		//alert("please select Application Id");
	}
}


function next(){
	var applicationId = document.getElementById("strApplicationID").value;
	var start = document.getElementById("start").value;
	var end = document.getElementById("end").value;
	var records_to_show = document.getElementById("records_to_show").value;
	var URL = "../../eXH/jsp/NotificationEventDtlView.jsp?";
    var param ="from="+(parseInt(start)+parseInt(records_to_show))+"&to="+(parseInt(end)+parseInt(records_to_show))+"&Application_ID="+applicationId;
    document.location.href=URL+param;
}

 

function previous(){
	var applicationId = document.getElementById("strApplicationID").value;
	var start = document.getElementById("start").value;
	var end = document.getElementById("end").value;
	var records_to_show = document.getElementById("records_to_show").value;
	var URL = "../../eXH/jsp/NotificationEventDtlView.jsp?";
    var param ="from="+(parseInt(start)-parseInt(records_to_show))+"&to="+(parseInt(end)-parseInt(records_to_show))+"&Application_ID="+applicationId;
    document.location.href=URL+param;
}

