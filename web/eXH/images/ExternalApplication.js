function invokeEMExternalAppServlet(contextPath)
{
	var dataElements = 'P_Ext_Application_ID=CCIS&' + $('#dmsSimulator').serialize();
/*
	$.ajax({
		  type: 'POST',
		  url: contextPath + '/servlet/eXH.EMExternalUpdates',
		  data: dataElements,
		  success: function(data) {	
			},
		  dataType: 'text',
		  async:false
		});
*/
	var ret = dispExtApp(dataElements);
	alert(ret);
}

function invokeEMExternalApp(contextParam)
{
	var appID = document.getElementById("applicationID").value;
	if(appID != '') {
	//	var dataElements = 'intExtAppID=' + appID + "&callType=INTERFACE_CALL" + '&' + $('#showExternalApps').serialize();
	//	dispExtApp1(dataElements, contextParam);
		window.close();
		window.returnValue = appID;
	}
}

function invokeExternalApp(exePath, exeParams)
{
	exePath = decodeURIComponent(exePath);
	exeParams = decodeURIComponent(exeParams);
	exePath = exePath.replace(/\//g,"\\");
	var oShell = new ActiveXObject("Shell.Application");
	oShell.ShellExecute(exePath, exeParams, "", "open", "1");
	window.close();
}

async function dispExtApp1(dataElements, contextParam)
{
	var retData = "";
	var url = "";

	var dialogHeight = screen.height;			    
	var dialogWidth  = screen.width;
	var dialogTop    = "200";
	var dialogLeft   = "450";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	var arguments = new Array();
	var url = contextParam + "/servlet/eXH.InvokeExternalApplication?" + dataElements;
	var retVal =await window.showModalDialog(url,arguments,features);
	window.close();
}

async function dispExtApp(dataElements)
{
	var retData = "";
	var url = "";
	var isExtAppEnabled = true;
	var isMultiAppEnabled = false;
	var dialogHeight = "5vh";			    
	var dialogWidth  = "20vw";
	var dialogTop    = "300";
	var dialogLeft   = "450";
	var applicationID = "";
	var key_2=""; // Added by prithivi on 29/07/2016 for medicity walletree and paytm changes. key_2 will indicate the single app key_2 = 'Y'
	
	// Calling servlet before opening dialog window so that window size can be set accordingly 
	// if the calling module function don't have multiple external applications enabled
	$.ajax({
		  type: 'POST',
		  url: '../../servlet/eXH.InvokeExternalApplication',
		  data: 'callType=IS_MULTIPLE_APP_ENABLED&' + dataElements,
		  success: function(isMultipleAppEnabled) {
			  	// if multiple applications are not enabled, 
				// calling the interface servlet with enabled single application 
				// or throwing alert if no applications are enabled
			 
			  if(isMultipleAppEnabled.indexOf("|") != -1) { // indicates single application
				  dataElements += "&intExtAppID=" + isMultipleAppEnabled.split("|")[1];
				  applicationID = isMultipleAppEnabled.split("|")[1];
				  key_2 = isMultipleAppEnabled.split("|")[2];
				  dialogHeight = screen.height;			    
				  dialogWidth  = screen.width;
				  dialogTop    = "200";
				  dialogLeft   = "450";
			  }
			  else if(isMultipleAppEnabled == 'FALSE') {
				  alert("No external applications enabled !!!");
				  isExtAppEnabled = false;
			  }
			  else {
				  isMultiAppEnabled = true;
			  }
			},
		  dataType: 'text',
		  async:false
		});
	if(isExtAppEnabled) {
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
		var arguments = new Array();
		
		if(isMultiAppEnabled) {
			var url = "../../servlet/eXH.InvokeExternalApplication?" + dataElements;
			retVal = await window.showModalDialog(url,arguments,features);
			applicationID = retVal;
			dataElements = "callType=INTERFACE_CALL&intExtAppID=" + retVal + "&" + dataElements;
		}
		
		//if(applicationID == "WALLETREE") { changed by prithivi on 29/07/2016 for medicity walletree and paytm changes. key_2 will indicate the single app
		//It will work for MMS creditcard transaction
			if(key_2 == "Y") {
			retVal = walletreeBilling(dataElements); 
			var messageTemp = retVal.split("$|#");
			var message = messageTemp[1];
			
			if(message == "" || message == undefined) {
				var walletreeCardNo = messageTemp[0];
				dataElements = "P_Preapaid_Card_Number=" + walletreeCardNo + "&" + dataElements;
			}
			else {
				return message;
			}
		}
        //alert(applicationID);
		if(applicationID == "SPECTRA")
		{
			//creditcardInterface2();
			var responseMsg ="";
            dataElements += "&PluginPort=8081";
			
			responseMsg = ePosTransaction(dataElements);
			
		    return responseMsg;

		}
		
		//dialogHeight = screen.height;			    
		//dialogWidth  = screen.width;
		dialogHeight = "50vh";
		dialogWidth = "50vw";
		dialogTop    = "200";
		dialogLeft   = "450";
		features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
		
		url = "../../servlet/eXH.InvokeExternalApplication?" + dataElements;
		retVal =await window.showModalDialog(url,arguments,features);
	}
	
	var startStr = retVal.substring(0, 8);
	
	if(startStr == 'toModule') {
		retVal = retVal.substring(9);
	}
	return retVal;
}

function ePosTransaction(dataElements)
{

    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',
		type: 'POST',
		cache: false,
		data: 'callType=SPANePos&' + dataElements, 
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
    
	return responseMsg;
} 


async function processAdditionalRequest(retVal, dataElements, features) 
{
	var responseMessage = retVal.split('$|#');
	var url = "";
	var arguments = new Array();
	
	if(confirm(responseMessage[2])) {
		url = "../../servlet/eXH.InvokeExternalApplication?interfaceRequestType=SETTLE_BILL&" + dataElements;
		retVal =await window.showModalDialog(url,arguments,features);
	}
	else {
		retVal = "User cancelled further processing of the transaction";
		retVal = "E" + "$|#" + retVal + "$|#" + retVal;
	}
	return retVal;
}
async function walletreeBilling(dataElements){
	var dialogHeight = "8vh";			    
	var dialogWidth  = "25vw";
	var dialogTop    = "300";
	var dialogLeft   = "500";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	var url = "../../eXH/jsp/CreditCardGUITransactions.jsp?title=Walletree Card" + dataElements;
	
	var retVal = await window.showModalDialog(url,arguments,features);
	
	return retVal;
}

/*
*Created by prithivi- this function is used to invoke the eGL application
*/
function invokeEGLapplication(dataElements)
{
	//var dataElements = "";
	//dataElements = "<FACILITY_ID>SI$!^<PATIENT_ID>GE00000142$!^<ENCOUNTER_ID>10101985$!^<USER>anilp$!^<WSNO>DFLT_WSNO$!^<NRICTYPE>02$!^<NRICVALUE>780101087716";
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'InvokeEGLapplication',
				paramString: dataElements
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
    
	//alert(responseMsg);
	return responseMsg;
}


async function checkBLeligibility()
{
   var warnCodeFormat="WARN/@cd(1)-->";
   var responseTypeFormat="res(1)-->";
   var warnDescFormat="WARN/@desc(1)-->";
   var caseNumberFormat="case_nbr(1)-->";
   var caseNumber="";
   var warnCode="";
   var responseType="";
   var warnDesc="";

	var facilityId=document.forms[0].facility_id.value;
	var patientId=document.forms[0].patient_id.value;
	var loggedUserId=document.forms[0].logged_user_id.value;
	var wsNO=document.forms[0].strclientip.value;
	var custCode=document.forms[0].cust_2.value;
    //alert("custCode...."+custCode);
	var dependantNum=document.forms[0].dependant_num.value;
	var dependantRelation=document.forms[0].dependant_relation.value;
	var wcaNumber=document.forms[0].wcaNumber.value;
	var membershipNum=document.forms[0].membership_num.value;
	var billNum="";
	var encounterId="";
	var startEncounterDate="";
	var endEncounterDate="";

    var responseMsg="";
	

	var dependantRelationNumber="";

	if(membershipNum !=null && membershipNum!="")
    {
	
	
    if(dependantRelation=="" && dependantRelation == null)
	{
		dependantRelationNumber="";
	}
    else if(dependantRelation=="Self")
	{
      dependantRelationNumber="1";  // Self
	}
	else if(dependantRelation=="Wife" || dependantRelation=="Husband")
	{
      dependantRelationNumber="2";  // Spouse
	}
	else if(dependantRelation=="Son" || dependantRelation=="Daughter" || dependantRelation=="Adopted Son" || dependantRelation=="AdoptedDaughter" || dependantRelation=="Child")
	{
       dependantRelationNumber="3";  // child
	}
	else{
      	dependantRelationNumber="4"; //Others
	}

    var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeMedikreditApplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'MedikreditApplication',
				facility_id: facilityId,
				patient_id: patientId,
				cust_code: custCode,
				encounter_id: encounterId,
				start_encounter_date: startEncounterDate,
				end_encounter_date: endEncounterDate,
				bill_num: billNum,
				membership_num: membershipNum,
				dependant_num: dependantNum,
				dependant_relation: dependantRelationNumber,
                wca_number: wcaNumber,
				user_id: loggedUserId,
				ws_no: wsNO
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   
   if(responseMsg.indexOf("Request Timed Out..")== -1)
   {
    
    caseNumber=getTheRequiredValue(responseMsg, caseNumberFormat)
	warnCode=getTheRequiredValue(responseMsg, warnCodeFormat)
	warnDesc=getTheRequiredValue(responseMsg, warnDescFormat)
	responseType=getTheRequiredValue(responseMsg, responseTypeFormat)

    if(responseType.indexOf("A")!= -1)
	{
      responseType="Authorised";
	}
	else if(responseType.indexOf("R")!= -1)
	{
      responseType="Rejected";
	}

    var dialogHeight =  "13vh";
    var dialogWidth  = "28vw";
	var dialogTop    = "300";
	var dialogLeft   = "400";
	

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;center:yes" ;
	var url = "../../eXH/jsp/BLcheckEligibilityMain.jsp?caseNumber="+caseNumber+"&warningCode="+warnCode+"&warningDesc="+warnDesc+"&responseType="+responseType;
	
	var retVal =await window.showModalDialog(url,arguments,features);
   // document.getElementById('eligibilityResponse').value= responseMsg;  
   
   // document.getElementById('checkEligibilityResultDiv').style.display = 'block';
   return responseMsg;
   }
   else
	   {
	     alert(responseMsg);
       }
	}
	else{
	alert("Please Enter the Membership Number");
	}
}


/*
* This function is used to call the creditcard plugin and make the transaction by using servlet.
*
*debit - Port_number=COM1,Amount=1,ECR_counter=1,Application_id=11
*refund - 
* currently not in use
*
*/
function callCreditcardExternalApp ()
{  
   var responseMsg="";
  
   var dataElements="Transaction_type=debit$!^Amount=1$!^ECR_counter=1$!^Application_id=11$!^Refund_rrn=627316191012$!^Menu=null$!^Printer=null$!^Printer_speed=null$!^Machine_port=COM1$!^BoudRate=16200" ;

    var callType=""; 
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'SPANePos',
				paramString: dataElements
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
	alert(responseMsg);
	//document.forms[0].clientMsg.value = responseMsg;
	//return responseMsg;
}

/*
* This function is used to show the sample screen to check the response from creditcard plugin
* design and this box wil be in billing module.
* currently not in use
*/
async function creditcardInterface()
{
	var retVal = "";
	//billing team has to call this below function
	creditcardInterface2();

setTimeout(function() {
	var dialogHeight = "40vh";			    
	var dialogWidth  = "40vw";
	var dialogTop    = "40";
	var dialogLeft   = "40";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;center:yes" ;
	var url = "../../eXH/jsp/CreditcardInterfaceMain.jsp";
	
	retVal =await window.showModalDialog(url,arguments,features);

	}, 7000);	
	return retVal;
}

/*
* This function is used to call the jnlp file which executes the plugin program in client machine
* jnlp file embedded with below jsp file.
* currently in use
*/
function creditcardInterface2()
{
   window.location.href = "../../eXH/jsp/ExternalAppInterfaceJNLP.jsp?PluginPort=8081&PluginTransactionType=ePosTransaction";
}

function getTheRequiredValue(sourceResponse, splitFormat)
{
     var result="";
		
	 var resultResponseArray=null;

	        if(sourceResponse!=null && sourceResponse!="")
			{
	          resultResponseArray=sourceResponse.split(splitFormat); //WARN/@cd(1)-->
                  
	          if(resultResponseArray.length > 1){
	        	  resultResponseArray=resultResponseArray[1].split("/");
				  result=resultResponseArray[0];
	          }
			}
			return result;
}



function invokeMyHixApplication(dataElements)
{
	//var dataElements = "";
	//dataElements = "<REQ_ID>REFREQQ$!^<FACILITY_ID>SI$!^<PATIENT_ID>GE00000142$!^<ENCOUNTER_ID>10101985$!^<MYHIX_PAT_ID>anilp$!^<FROM_DATE>DFLT_WSNO$!^<TO_DATE>DFLT_WSNO$!^<MYHIX_DOC_ID>CN11$0000000000000311"
	//dataElements = "<REQ_ID>DISREQQ$!^<FACILITY_ID>SI$!^<PATIENT_ID>GE00000142$!^<ENCOUNTER_ID>10101985$!^<MYHIX_PAT_ID>anilp$!^<FROM_DATE>DFLT_WSNO$!^<TO_DATE>DFLT_WSNO$!^<MYHIX_DOC_ID>CN11$0000000000000311"

	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeMyHixApplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'InvokeMyHixApplication',
				paramString: dataElements
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});     
	//alert(responseMsg);
	return responseMsg;
}

function checkEnotification(dataElements)
{	
	var callType="";
	var responseMsg="";
	var data1=true;

	$.ajax({
		url: '../../servlet/eXH.InvokeEnotificationApplication',
		type: 'POST',
		cache: false,
		data: {
				callType: 'CheckEnotification',
				paramString: dataElements
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	}); 
    
	return responseMsg;
}


function checkPatientMembershipEligibility(dataElements,patient_id)
{
   //var dataElements = "";
	//dataElements = '<NATIONAL_ID>xxx$!^<PATIENT_NAME>FATHY HASSAN ALI ABDULLAH AL GODEHE$!^<PATIENT_DOB>1979-05-09$!^<MOBILE_NO>966543122800$!^<MEMBERSHIP_NO>MEM0005$!^<POLICY_HOLDER_NAME>FATHY HASSAN ALI ABDULLAH AL GODEHE$!^<POLICY_PLAN_NO>57746$!^<PROVIDER_CODE>15$!^<SERVICE_TYPE>7196$!^<PAYER_CODE>15-00341';
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'PayerMembershipEligibilityCheck',
				paramString: dataElements,
				patientId: patient_id
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
    
	return responseMsg;
}

function checkCustomerGroupInterface(cust_group)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'CheckCustGroupInterfaceProfile',
				cust_group_code: cust_group
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   return responseMsg;
}

function visitRegProcEnabledInterface(cust_group)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'CheckVisitRegProcEnabledYN',
				cust_group_code: cust_group
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   return responseMsg;
}

function checkModuleIdForPayerEligibility(callingModuleId)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'checkModuleIdForPayerEligibility',
				callingModuleId: callingModuleId
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   return responseMsg;
}
