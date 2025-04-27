async function funMedicationsDue(){
	var queryString = document.forms[0].queryString.value;
	var retVal = 	new String();
	var dialogHeight= "32" ;
	var dialogWidth	= "60" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
	retVal=await window.showModalDialog("../../eOR/jsp/PatientPendingOrders.jsp?"+queryString,arguments,features);
}
function refresh()
{
		top.content.workAreaFrame.location.reload();
}



