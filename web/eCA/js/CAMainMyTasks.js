function reviewWindow(indicator){			
			var queryString = document.forms[0].queryString.value;			
			var retVal = 	new String();
			var dialogHeight= "32" ;
			var dialogWidth	= "60" ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			if(indicator=="Abnormal")
				queryString+="&ca_normalcy_ind=A";
			else if(indicator=="Critical")
				queryString+="&ca_normalcy_ind=C";
			else if(indicator=="Normal")
				queryString+="&ca_normalcy_ind=N";
			else
				queryString+="&ca_normalcy_ind=Z";
			
			retVal=window.open("../../eCA/jsp/ReviewResultsModalMain.jsp?"+queryString,arguments,'height=637,width=1012,top=90,left=0,resizable=yes');

	}

	function authorizeNotes(){
			
			
			var queryString = document.forms[0].queryString.value;	
			queryString = queryString+"&dateRange=N";			
			var retVal = 	new String();
			var dialogHeight= "32" ; //32
			var dialogWidth	= "40" ;//40
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal=window.open("../../eCA/jsp/SignNotesModalMain.jsp?"+queryString,arguments,'height=637,width=1012,top=90,left=0,resizable=yes');
	}

	function reviewNotes(obj){
			
			
			var queryString = document.forms[0].queryString.value;
			queryString = queryString+"&dateRange=N";		
			var retVal = 	new String();
			var dialogHeight= "32" ;
			var dialogWidth	= "60" ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
			retVal=window.open("../../eCA/jsp/ReviewNotesModalMain.jsp?"+queryString+"&requested_to="+obj,arguments,'height=637,width=1012,top=90,left=0,resizable=yes');
	}

async function pendingCosign(){
			var queryString = document.forms[0].queryString.value;
			var retVal = 	new String();
			var dialogHeight= "38" ;
			var dialogWidth	= "60" ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
			queryString+="&modal_yn=Y";
			retVal=await window.showModalDialog("../../eOR/jsp/CosignOrders.jsp?"+queryString,arguments,features);
			document.location.reload();
	}

async function pendingAuth(){
			var queryString = document.forms[0].queryString.value;
			var retVal = 	new String();
			var dialogHeight= "35" ;
			var dialogWidth	= "60" ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
			queryString+="&modal_yn=Y";
			retVal=await window.showModalDialog("../../eOR/jsp/AuthorizeOrders.jsp?"+queryString,arguments,features);
			document.location.reload();
	}

function consultOrder(){
			var queryString = document.forms[0].queryString.value;
			var retVal = 	new String();
			var dialogHeight= "32" ;
			var dialogWidth	= "60" ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
			
			queryString+="&CA=Y";

			top.content.workAreaFrame.location.href="../../eOR/jsp/ResultReporting.jsp?"+queryString;
			top.content.CommonToolbar.displayFunctionName("Consults");
			return false;
			//retVal=window.open("../../eCA/jsp/ResultReportingModalMain.jsp?"+queryString,arguments,'height=570,width=790,top=10,left=0,resizable=yes');

			//retVal=window.showModalDialog("../../eOR/jsp/ResultReporting.jsp?"+queryString,arguments,features);
	}
	async function pendingAppointment()
    {
			var queryString = document.forms[0].queryString.value;
			var retVal = 	new String();
			var dialogHeight= "36" ;
			var dialogWidth	= "60" ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
			queryString+="&modal_yn=Y";
			retVal=await window.showModalDialog("../../eOR/jsp/PendingAppointment.jsp?"+queryString,arguments,features);
			document.location.reload();
    }
function referralChart(){
// function not used
}
function callPatientList(type)
{
	var queryString =document.forms[0].queryString.value;
	queryString += "&locationType="+type;
	//alert(queryString);
	
	top.content.workAreaFrame.location.href="../../eCA/jsp/PatListByLocation.jsp?"+queryString;
	top.content.CommonToolbar.displayFunctionName("Patient List By Location");
}
function pendingConsent(name)
{
		var queryString = document.forms[0].queryString.value;
		var retVal = 	new String();
		var dialogHeight= "32" ;
		var dialogWidth	= "60" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
		queryString+="&modal_yn=N";
		top.content.workAreaFrame.location.href="../../eOR/jsp/ConsentOrders.jsp?p_called_from_ca =Y&"+queryString;
		top.content.CommonToolbar.displayFunctionName(name);
//		retVal=window.showModalDialog("../../eOR/jsp/ConsentOrders.jsp?p_called_from_ca =Y&"+queryString,arguments,features);
		top.content.CommonToolbar.displayFunctionName("Record Consent");
		document.location.reload();
}
async function callReferralRequest(practitioner_id){
		var queryString = document.forms[0].queryString.value;
		var retVal = 	new String();
		var dialogHeight= "32" ;
		var dialogWidth	= "60" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
		queryString+="&modal_yn=Y";
		retVal=await window.showModalDialog("../../eIP/jsp/CABedSideReferral.jsp?called_for=Confirm&p_called_from_ca =Y&practitioner_id="+practitioner_id+"&"+queryString,arguments,features);
		document.location.reload();
}

//function for CAMainHomePageCommonTasksNew.jsp-starts

function testCommonTaskNew(obj,check)
{
		var spl=obj.split('||');
		var obj1='';
		for(i=0;i<(spl.length-1);i++){
				obj1+=spl[i];
				if (i<(spl.length-2)){
						obj1+='\n';
				}
		}
		if(check=='A')
			document.getElementById("td1").title = obj1;
		else if(check=='C')
			document.getElementById("td2").title = obj1;
		else if(check=='E')
			document.getElementById("td3").title = obj1;
		else if(check=='Q')
			document.getElementById("td4").title = obj1;
}

//function for CAMainHomePageCommonTasksNew.jsp-ends


//function for CAMainHomePageMyTasksNew.jsp -starts
function testMyTaskNew(obj,check){
		var spl=obj.split('||');
		var obj1='';
		for(i=0;i<(spl.length-1);i++){
				obj1+=spl[i];
				if (i<(spl.length-2)){
						obj1+='\n';
				}
		}
		if(check=='All')
			document.getElementById("td0").title = obj1;
		else if(check=='Abnormal')
			document.getElementById("td1").title = obj1;
		else if(check=='Critical')
			document.getElementById("td2").title = obj1;
		else if(check=='Normal')
			document.getElementById("td3").title = obj1;
}
//function for CAMainHomePageMyTasksNew.jsp-ends

//function forCAHomePageNotesNew.jsp-starts
function testNotesNew(obj,check){
		var spl=obj.split('||');
		var obj1='';
		for(i=0;i<(spl.length-1);i++){
				obj1+=spl[i];
				if (i<(spl.length-2)){
						obj1+='\n';
				}
		}
		if(check=='S')
			document.getElementById("td1").title = obj1;
		else
			document.getElementById("td2").title = obj1;
}
//function for CAHomePageNotesNew.jsp-ends

//function forCAHomePagePatientsNew.jsp-starts
function testPatientsNew(obj,check){
		var spl=obj.split('||');
		var obj1='';
		for(i=0;i<(spl.length-1);i++){
				obj1+=spl[i];
				if (i<(spl.length-2)){
						obj1+='\n';
				}
		}
		if(check=='C')
			document.getElementById("td1").title = obj1;
		else if(check=='R')
			document.getElementById("td2").title = obj1;	
		else if(check=='O')
			document.getElementById("td3").title = obj1;		
		else if(check=='I')
			document.getElementById("td4").title = obj1;		
}

function callReportRequest()
{
	var function_id = document.patientnewform.function_id.value;
	var called_from = document.patientnewform.called_from.value;
	var patientid = document.patientnewform.patientid.value;
	var retVal = new String();
	var queryString = "function_id="+function_id+"&called_from="+called_from+"&patientid="+patientid;
	top.content.workAreaFrame.location.href="../../eMR/jsp/PrepareMedReport.jsp?"+queryString;
	top.content.CommonToolbar.displayFunctionName("Prepare Medical Report");
}
//function forCAHomePagePatientsNew.jsp-ends

function callConsults(linkValue)
{
	var queryString = document.patientnewform.queryString.value;
	top.content.workAreaFrame.location.href="../../eCA/jsp/ReferralPatList.jsp?"+queryString+"&linkValue="+linkValue;
	top.content.CommonToolbar.displayFunctionName("Referral Patient List");
}
