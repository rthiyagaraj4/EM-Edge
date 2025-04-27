
function showLookup1() {
	var sourceType=document.getElementById("wardsDesc").value;
	document.getElementById("wardsCode").value="";
	if(sourceType!=null)
		lookup1();
	
}
function lookup1() {
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array(document.getElementById("operatingFacilityId").value,document.getElementById("languageId").value);
		var sourceType=document.getElementById("sourceType").value;
		namesArray[0]="facilityId";
		namesArray[1]="languageId";
		if(sourceType=="W")
			argArray[0] = "ehis.lc.standardStock.nursingUnit"
		else if(sourceType=="C")
			argArray[0] = "ehis.lc.standardStock.clinic"
		else if(sourceType=="D")
			argArray[0] = "ehis.lc.standardStock.deptCode"
		else argArray[0] = "ehis.lc.standardStock.nursingUnit"
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = DESC_CODE;
		argArray[4] = DESC_LINK;
		argArray[5]=document.getElementById("wardsDesc").value;
		retArr = Lookup("Source", argArray);
		var sourceCode = document.getElementById("wardsCode");
		var sourceDesc = document.getElementById("wardsDesc");
		if(retArr!=null){
			//Set the data in to the fields
			sourceCode.value = retArr[0];
			sourceDesc.value = retArr[1];
		}
		else
		{
			sourceCode.value = "";
			sourceDesc.value = "";
		}
	}
	function deleteRows2() {
	var tableObj = document.getElementById("StatusTable1");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}}
	function deleteRows() {
	var tableObj = document.getElementById("StatusTable");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}}

function callDWRLookUp(){
	var f1=check();
	if(f1==true){
	var facilityId=document.getElementById("operatingFacilityId").value;
	var languageId=document.getElementById("languageId").value;
	var source=document.getElementById("wardsCode").value;
	var sourceType=document.getElementById("sourceType").value;
	//alert(facilityId+" "+languageId+" "+source+" "+sourceType);
	if(source!=""||source!=null)
		
	LinenIssue.getPendingCleaning(languageId,facilityId,sourceType,source,callPendingCleaning);
	}
}


function callPendingCleaning(rec){
	//deleteRows();
	var count=0;
	var row_ind=0;
	var ind=1;
	var tableObj = null;
	getServerMessage("com.iba.ehis.lc.pendingCleaning");
	var label1=dwrMessage;
	getServerMessage("com.iba.ehis.lc.requestForCleaningLinen.quantity");
	var Qtylabel=dwrMessage;
	tableObj = document.getElementById("StatusTable");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}
	var row = tableObj.insertRow(tableObj.rows.length);
		var head1 = row.insertCell();
		head1.className = "COLUMNHEADER";
		head1.width="100%";
		head1.colspan="2";
		head1.innerHTML ="<b>"+label1+"</b>";

		var head2 = row.insertCell();
		head2.className = "COLUMNHEADER";
		head2.width="100%";
		head2.innerHTML ="<b>"+Qtylabel+"</b>";
		var m=0;
		var qryEven = "QRYEVEN";
		var qryOdd = "QRYODD";
		for(prop in rec)
		{
		
		var  linenItem=prop	;
		var pendingQty=rec[prop];
		//alert(linenItem+"=="+pendingQty)
		
		var classVal = (m % 2 == 0) ? qryEven : qryOdd;
		var newRow = tableObj.insertRow(tableObj.rows.length);
		var col1 = newRow.insertCell();
		col1.className = classVal;
		col1.width="50%";
		col1.appendChild(document.createTextNode(linenItem));
		var col2 = newRow.insertCell();
		col2.className =classVal;
		col2.width="50%";
		col2.appendChild(document.createTextNode(pendingQty));
		row_ind++;
		m++;
	}
	var facilityId=document.getElementById("operatingFacilityId").value;
	var languageId=document.getElementById("languageId").value;
	var source=document.getElementById("wardsCode").value;
	var sourceType=document.getElementById("sourceType").value;
	//alert(facilityId+" "+languageId+" "+source+" "+sourceType);
	LinenIssue.getPendingIssue(languageId,facilityId,sourceType,source,callPendingIssue);
}
function callPendingIssue(data){
	deleteRows2();
	var count=0;
	var row_ind=0;
	var ind=1;
	var tableObj = null;
	getServerMessage("com.iba.ehis.lc.pendingIssue");
	var label1=dwrMessage;
	getServerMessage("com.iba.ehis.lc.requestForCleaningLinen.quantity");
	var Qtylabel=dwrMessage;
	tableObj = document.getElementById("StatusTable1");
	var row = tableObj.insertRow(tableObj.rows.length);
		var head1 = row.insertCell();
		head1.className = "COLUMNHEADER";
		head1.width="100%";
		head1.innerHTML ="<b>"+label1+"</b>";

		var head2 = row.insertCell();
		head2.className = "COLUMNHEADER";
		head2.width="100%";
		head2.innerHTML ="<b>"+Qtylabel+"</b>";
		var m=0;
		var qryEven = "QRYEVEN";
		var qryOdd = "QRYODD";
	for(prop in data)
		{

			
					var  linenItem=prop;
					var pendingQty=data[prop];
					//alert(linenItem+"=="+requestedQty+"== "+deliveredQty)
		
		var classVal = (m % 2 == 0) ? qryEven : qryOdd;
		var newRow = tableObj.insertRow(tableObj.rows.length);
		var col1 = newRow.insertCell();
		col1.className = classVal;
		col1.width="50%";
		col1.appendChild(document.createTextNode(linenItem));
		var col2 = newRow.insertCell();
		col2.className = classVal;
		col2.width="50%";
		col2.appendChild(document.createTextNode(pendingQty));
		row_ind++;
		m++;
	}
}
	function check(){
	 	var flag=true;
		var error="";
		var fieldName = "com.iba.ehis.lc.standardStock.source";
		var fields = document.getElementById("wardsDesc").value;
 		if(fields=="")
		{	
	 		getServerMessage(fieldName);
	 		key_value=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
	 		msgArray=msg.split('#');
	 		error=error +msgArray[0]+ key_value + " " + msgArray[1] +"<br>";
	 		flag=false;
 		}
	parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}
