  async function viewauditlogdetails(table_id,pkey_value){
	var dialogHeight= "50vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop = "90" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/SetupAuditLog.jsp?table_id="+table_id+"&pkey_value="+pkey_value,arguments,features);
}

function showDetails(table_id,log_id){
	
		parent.frames[1].location.href="../../ePH/jsp/SetupAuditLogDetail.jsp?table_id="+table_id+"&log_id="+log_id;

}
