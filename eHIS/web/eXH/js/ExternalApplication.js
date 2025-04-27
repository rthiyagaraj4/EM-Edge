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

	var dialogHeight = "80vh";			    
	var dialogWidth  = "90vw";
	var dialogTop    = "200";
	var dialogLeft   = "450";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	var arguments = new Array();
	var url = "../../servlet/eXH.InvokeExternalApplication?" + dataElements;
	var retVal = await window.showModalDialog(url,arguments,features);
	window.close();
}

async function dispExtApp(dataElements)
{
	var retData = "";
	var url = "";
	var isExtAppEnabled = true;
	var isMultiAppEnabled = false;
	var dialogHeight = "70vh";			    
	var dialogWidth  = "80vw";
	var dialogTop    = "300";
	var dialogLeft   = "450";
	var applicationID = "";
	var key_2=""; // Added by prithivi on 29/07/2016 for medicity walletree and paytm changes. key_2 will indicate the single app key_2 = 'Y'

	var retVal = "";
	
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
				  dialogHeight = "70vh";			    
				  dialogWidth  = "80vw";
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
			retVal = await top.window.showModalDialog(url,arguments,features);
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
		/* To check for Applet Code  */
		if(applicationID == "SPECTRA")
		{
			//creditcardInterface2();
			var responseMsg ="";
            dataElements += "&PluginPort=8081";			
			
			responseMsg = ePosTransaction(dataElements);

		    return responseMsg;

		}

		if (applicationID == "PAYSYS") {			
			var responseMsg = "";
			dataElements += "&PluginPort=8081";
			responseMsg = paysysTransaction(dataElements);

			return responseMsg;

		}
		
		//Added by Gopinath for NMC-JD-CRF-0202 on 23/05/2023
		if (applicationID == "SPECTRAWEB") {			
			var responseMsg = "";
			//alert("spectraWebTransaction started...");
			
			responseMsg = spectraWebTransaction(dataElements);
			responseMsg = openSpectraWebPayments(dataElements, responseMsg);
			
			return responseMsg;

		}

		// Uncommented for ML-BRU-SCF-1837.1 on 29/10/2018
		// Uncommented for ML-MMOF-SCF-1434 on 29/10/2018
		dialogHeight = "70vh";			    
		dialogWidth  = "80vw";
		// Uncommented for ML-MMOF-SCF-1434 on 29/10/2018
		// Commented for ML-BRU-SCF-1837.1 on 29/10/2018
		//dialogHeight = "50";
		//dialogWidth = "50";
		dialogTop    = "0";
		dialogLeft   = "0";
		features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
		
		url = "../../servlet/eXH.InvokeExternalApplication?" + dataElements;
		retVal = await top.window.showModalDialog(url,arguments,features);
		//retval = window.open(url,null,features);


	}

	if (retVal != undefined)
	{
		var startStr = retVal.substring(0, 8);
	
		if(startStr == 'toModule') {
			retVal = retVal.substring(9);
		}
		return retVal;
	}		
}

/*
* This function is used to call the applet function to make the TCP/IP connection in client machine
* currently in use
*/
function creditCardApplet(dataInput)
{
	var summary = "";
	var arr = "";

	if(dataInput!='' && dataInput!=null){		
		
		arr = dataInput.split(",");		

		if (arr.length > 1)
		{
			if ( arr[4] != null && arr[4] != "" && (arr[4] == "PLUTUS" || arr[4] == "PHONEPE")) {		
			
				parent.frames[1].document.CreditCardReader.setApplicationId(arr[4]);
				dataInput = dataInput.replace("PLUTUS", "");
				dataInput = dataInput.replace("PHONEPE", "");
				summary = parent.frames[1].document.CreditCardReader.Capture(dataInput);
			}		
		}
		else
		{
			arr = dataInput.split("$!^");
			if ( arr[10] != null && arr[10] != "" && arr[10] == "intExtAppID=SPECTRA") {		
			
				runApp('file://C:/em-interface/EM_CC_PLUGIN/EM_CC_COM_PORT_Start.bat');
				parent.frames[1].document.CreditCardReader.setApplicationId("SPECTRA");
				summary = parent.frames[1].document.CreditCardReader.Capture(dataInput);
			}				
		}		
	}

	return summary;
   
}

function runApp(which) {
	WshShell = new ActiveXObject("WScript.Shell");
	WshShell.Run (which,1,true);
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

function paysysTransaction(dataElements) {
	var responseMsg = "";
	$.ajax({
		url : '../../servlet/eXH.InvokeExternalApplication',
		type : 'POST',
		cache : false,
		data : 'callType=PAYSYS&' + dataElements,
		success : function(data1) {
			responseMsg = data1;
		},
		dataType : 'text',
		async : false
	});

	return responseMsg;
}

//Added by Gopinath for NMC-JD-CRF-0202 on 23/05/2023
function spectraWebTransaction(dataElements) {
	var responseMsg = "";
	$.ajax({
		url : '../../servlet/eXH.InvokeExternalApplication',
		type : 'POST',
		cache : false,
		data : 'callType=SPECTRAWEB&' + dataElements,
		success : function(data1) {
			responseMsg = data1;
		},
		dataType : 'text',
		async : false
	});

	return responseMsg;
}

// Function added for NMC-JD-CRF-0038.1
function OTPTransaction(dataElements) {
	var responseMsg = "";
	var data1 = true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',	
		type: 'POST',
		cache: false,
		data: {
				callType: 'OTP',
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
//Function added by Ravisankar for PMG-CRF-015.1
async function EMWebSnomed(dataElements,searchString)
{
	//<SEARCH_TERM>typhoid$!^<RETURN_LIMIT>-1$!^<STATE>active$!^<SEMANTIC_TAG>disorder$!^<USER>Ravisankar$!^<WSNO>DFLT_WSNO$!^ 
	//<APPLICATION_ID>SNOMED$!^<PROTOCOL_LINK_ID>SNOMEDG$!^<STANDARD_CODE>SNOSTD$!^<SEGMENT_ID>PWEB$!^
	
	 dataElements = "<APPLICATION_ID>SNOMED$!^<PROTOCOL_LINK_ID>SNOMEDG$!^<STANDARD_CODE>SNOSTD$!^<SEGMENT_ID>PWEB$!^"+dataElements;
	var protocolLinkId = "SNOMEDG";

/*	var responseMsg="";
	var data1=true;
	
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',	
		type: 'POST',
		cache: false,
		data: {
				callType: 'SNOMED',
				paramString: dataElements
		}, 
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
	
	alert(responseMsg); */
	var arguments = new Array();

	var dialogWidth	= "60vw";
	var dialogHeight = "30vh";
	var dialogTop    = "100";
	var dialogLeft   = "200";

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ ";status:no;scroll:auto";	
	//var action_url	="../../eXH/jsp/ShowSnomedPortal.jsp?protocolLinkId="+protocolLinkId+"&dataElements="+dataElements;
	var action_url	="../../eXH/jsp/ShowSnomedPortalMain.jsp?protocolLinkId="+protocolLinkId+"&dataElements="+dataElements+"&searchString="+searchString; //+"&responseMsg="+responseMsg;

	var retVal =await window.showModalDialog(action_url,arguments,features);
	
	//alert(retVal);

	return retVal;
}

//function added by Ravisankar for PMG2019-TECH-CRF-015.1
function returnCode(code)
{
	//alert(code);
	var code_new=code.value;
	//alert(code_new);
	//alert("Inside returncode");
	
	window.returnValue=code_new;
	window.close();
	//return code_new;
}

//Function added for AAKH-CRF-0119
async function EMWebMalaffi(dataElements)
{	

	//<PATIENT_ID>0105354$!^<PRACTITIONER_ID>DRJAMEEL$!^<USER_NAME>SHIVA$!^<MACHINE_ID>DXCINDAI696704$!^<SESSION_ID>XYZ123
	//<APPLICATION_ID>MALAFFI$!^<PROTOCOL_LINK_ID>MLFIAKP1$!^<STANDARD_CODE>MLFIHL725$!^<SEGMENT_ID>SAML$!^<PATIENT_ID>0105354$!^<PRACTITIONER_ID>DRJAMEEL$!^<USER_NAME>SHIVA$!^<MACHINE_ID>DXCINDAI696704$!^<SESSION_ID>XYZ123

	dataElements = "<APPLICATION_ID>MALAFFI$!^<PROTOCOL_LINK_ID>MLFIAKP1$!^<STANDARD_CODE>MLFIHL725$!^<SEGMENT_ID>SAML$!^"+dataElements;
	var protocolLinkId = "MLFIAKP1";

	var arguments = new Array();

	var dialogWidth	= window.screen.width;
	var dialogHeight = window.screen.height;
	var dialogTop    = "0";
	var dialogLeft   = "0";

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ ";status:no;scroll:auto";	

	var action_url	="../../eXH/jsp/ShowMalaffiPortal.jsp?protocolLinkId="+protocolLinkId+"&dataElements="+dataElements;

	var retVal = await window.showModalDialog(action_url,arguments,features);

	/*
	
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',	
		type: 'POST',
		cache: false,
		data: {
				callType: 'MALAFFI',
				paramString: dataElements
		}, 
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
	
	*/

	return retVal;
} 



function CreditCardResponse(dataElements)
{
	//var dataElements = "";
	//dataElements = "<FACILITY_ID>SI$!^<PATIENT_ID>GE00000142$!^<ENCOUNTER_ID>10101985$!^<USER>anilp$!^<WSNO>DFLT_WSNO$!^<NRICTYPE>02$!^<NRICVALUE>780101087716";
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',
		type: 'GET',
		cache: false,
		data: 'callType=CCRESPONSE&' + dataElements, 		
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
		retVal = await window.showModalDialog(url,arguments,features);
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
	
	var retVal =await window.showModalDialog(url,arguments,features);
	
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
	
	document.forms[0].clientMsg.value = responseMsg;
	return responseMsg;
}

/*
* This function is used to show the sample screen to check the response from creditcard plugin
* design and this box wil be in billing module.
* currently not in use
*/
function creditcardInterface()
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
	
	retVal =window.showModalDialog(url,arguments,features);

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
	var l_referral_id = parent.frames[0].document.forms[0].p_referral_id.value;
	dataElements = dataElements + "$!^<REFERRAL_ID>"+l_referral_id;
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

/* Commented by Sethu for NMC-JD-CRF-0054.1 */
/*

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

*/

function checkCustomerGroupInterface(cust_group, calling_module_id)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'CheckCustGroupInterfaceProfile',
				cust_group_code: cust_group,
				module_id: calling_module_id
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

// Added by Sethu on 14/04/2017 for KDAH-CRF-0370 
function invokePanCardValidation(dataElements)
{

	//var pancard = document.getElementById("Pancard").value;
	//var dataElements = "<FACILITY_ID>SI$!^<PATIENT_ID>GE00000142$!^<LOGGED_IN_USER_ID>SETHU$!^<LOGGED_IN_WSNO>DFLT_WSNO$!^<SESSION>REGPAT$!^<PANCARDNO>"+pancard;

	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'PanCardValidation',
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

function payTMTransaction(dataElements)
{

    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',
		type: 'POST',
		cache: false,
		data: {
				callType: 'payTM',
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

function PhisTransaction()
{

    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',
		type: 'POST',
		cache: false,
		data: {
				callType: 'PHIS'
		}, 
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
    
	return responseMsg;
} 

function getExtLink(patient_id, encounter_id, accession_no, order_id, facility_id, locale, login_user, resp_id, login_at_ws_no, order_type_code, op_episode_visit_num, attend_practitioner_id, assign_care_locn_type, assign_care_locn_code, visit_adm_date,  patient_class, locn_desc,ext_image_appli_id, ext_image_obj_id, ext_image_source, ext_srce_doc_ref_no, ext_srce_doc_ref_line_no) {
	//var Ext_Application_ID = 'DMS'; //added for IN048253 
	var Ext_Application_ID = ext_image_appli_id; //IN047205
	var Ext_Function = 'VIEW'; //added for IN048253 
	//var qry_string =  'P_PATIENT_ID='+patient_id+'&P_EPISODE_ID='+encounter_id+'&P_ACCESSION_NUM='+accession_no+'&P_ORDER_ID='+order_id+'&P_FACILITY_ID='+facility_id+'&P_LANGUAGE_ID='+locale+'&P_USE_ID='+login_user+'&P_RESP_ID='+resp_id+'&P_WS_NO='+login_at_ws_no+'&P_ORDER_TYPE_CODE='+order_type_code+'&P_ENCNTR_DATE=' +visit_adm_date+'&P_VISIT_ID='+op_episode_visit_num+'&P_PHYSICIAN_ID='+attend_practitioner_id+'&P_LOCN_TYPE='+assign_care_locn_type+'&P_LOCN_CODE='+assign_care_locn_code+'&P_LOC_DESC='+locn_desc+'&P_EPISODE_TYPE='+patient_class; //commented for IN048253 
	var qry_string =  'P_PATIENT_ID='+patient_id+'&P_EPISODE_ID='+encounter_id+'&P_ACCESSION_NUM='+escape(accession_no)+'&P_ORDER_ID='+order_id+'&P_FACILITY_ID='+facility_id+'&P_LANGUAGE_ID='+locale+'&P_USE_ID='+login_user+'&P_RESP_ID='+resp_id+'&P_WS_NO='+login_at_ws_no+'&P_ORDER_TYPE_CODE='+order_type_code+'&P_ENCNTR_DATE=' +visit_adm_date+'&P_VISIT_ID='+op_episode_visit_num+'&P_PHYSICIAN_ID='+attend_practitioner_id+'&P_LOCN_TYPE='+assign_care_locn_type+'&P_LOCN_CODE='+assign_care_locn_code+'&P_LOC_DESC='+locn_desc+'&P_EPISODE_TYPE='+patient_class+'&P_Ext_Application_ID='+Ext_Application_ID+'&P_Ext_Function='+Ext_Function+'&P_DOC_ID='+ext_image_obj_id; //modified for IN048253 
	dispExtApp(qry_string);	  //dispExtApp function avalible on ExternalApplication.js of eXH Module. 
}

function getExtLink(facility_id, patient_id, login_user, resp_id, regn_date) {	

	/*Added by Ashwini on 15-Oct-2018 for TBMC-CRF-0005*/
	regn_date = decodeURIComponent(regn_date);
	regn_date = regn_date.replace("+"," ");
	/*End TBMC-CRF-0005*/
	
	//var qry_string =  'P_PATIENT_ID='+patient_id+'&P_EPISODE_ID='+encounter_id+'&P_ACCESSION_NUM='+accession_no+'&P_ORDER_ID='+order_id+'&P_FACILITY_ID='+facility_id+'&P_LANGUAGE_ID='+locale+'&P_USE_ID='+login_user+'&P_RESP_ID='+resp_id+'&P_WS_NO='+login_at_ws_no+'&P_ORDER_TYPE_CODE='+order_type_code+'&P_ENCNTR_DATE=' +visit_adm_date+'&P_VISIT_ID='+op_episode_visit_num+'&P_PHYSICIAN_ID='+attend_practitioner_id+'&P_LOCN_TYPE='+assign_care_locn_type+'&P_LOCN_CODE='+assign_care_locn_code+'&P_LOC_DESC='+locn_desc+'&P_EPISODE_TYPE='+patient_class; //commented for IN048253 

	var locale = "en";
	var resp_id = "";

	//var qry_string =  "P_PATIENT_ID="+patient_id+"&P_START_DATE="+start_date+"&P_END_DATE="+end_date+"&P_FACILITY_ID="+facility_id+"&P_LANGUAGE_ID="+locale+"&P_USE_ID="+login_user+"&P_RESP_ID="+resp_id;

	var qry_string =  "P_PATIENT_ID="+patient_id+"&P_FACILITY_ID="+facility_id+"&P_LANGUAGE_ID="+locale+"&P_USE_ID="+login_user+"&P_RESP_ID="+resp_id;

	qry_string = checkURL(qry_string, "P_START_DATE");

	qry_string = checkURL(qry_string, "P_END_DATE");

	dispExtApp(qry_string);	  
}


function getCurrentDate(days, months)
{
	var today = new Date();
	today.setDate(today.getDate() + days);

	today.setMonth(today.getMonth() + months);
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();

	if(dd<10) {
		dd = '0'+dd
	} 

	if(mm<10) {
		mm = '0'+mm
	} 
	
	today = dd + '/' + mm + '/' + yyyy;

	return today;

}

function checkURL(dataElements, key)
{
	var value = "";

	var start_date = "";
	var end_date = "";

	var configData = "<SEGMENT_ID>DCS$!^<ELEMENT_ID>DATE_PERIOD$!^<STD_CODE>BMDCS$!^";

	var months = getConfigData(configData);	

	if (!(months.length>0))
	{
		months = 10;
	}

	if (!(dataElements.indexOf(key)>0))
	{
		if (key == "P_START_DATE")
		{
			value = getCurrentDate(-15,-months);
		}
		
		if (key == "P_END_DATE")
		{
			value = getCurrentDate(15,0);
		}		

		dataElements = dataElements + "&"+key+"="+value;
	}

	return dataElements;

}

function getConfigData(dataElements)
{

    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',
		type: 'POST',
		cache: false,
		data: {
				callType: 'DCS',
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

function CheckMyHixDisplay(){
	
	var dataElements = "<REQ_ID>DISREQQ$!^<FACILITY_ID>AY$!^<PATIENT_ID>17000007$!^<ENCOUNTER_ID>17000007$!^<MYHIX_PAT_ID>ABC17000007XYZ$!^<FROM_DATE>10/01/2018$!^<TO_DATE>10/01/2019$!^<MYHIX_DOC_ID>ABCID$!^<REQ_TYPE>RETREQUEST$!^<LOGGED_USER>PARIYAPHORN$!^";

	var action_url	="../../eMP/jsp/MyHixDetail.jsp?dataElements="+dataElements;

	var dialogWidth	= window.screen.width;
	var dialogHeight = window.screen.height;

	window.open(action_url,null,"height="+dialogHeight +",width="+dialogWidth+",top=0,left=0,resizable=yes, scrollbars=yes,status=NO,toolbar=no,menubar=no,location=no");
}

//Function added for AAKH-CRF-0119
async function EMWebMalaffi(dataElements)
{	

	//<PATIENT_ID>0105354$!^<PRACTITIONER_ID>DRJAMEEL$!^<USER_NAME>SHIVA$!^<MACHINE_ID>DXCINDAI696704$!^<SESSION_ID>XYZ123
	//<APPLICATION_ID>MALAFFI$!^<PROTOCOL_LINK_ID>MLFIAKP1$!^<STANDARD_CODE>MLFIHL725$!^<SEGMENT_ID>SAML$!^<PATIENT_ID>0105354$!^<PRACTITIONER_ID>DRJAMEEL$!^<USER_NAME>SHIVA$!^<MACHINE_ID>DXCINDAI696704$!^<SESSION_ID>XYZ123

	dataElements = "<APPLICATION_ID>MALAFFI$!^<PROTOCOL_LINK_ID>MLFIAKP1$!^<STANDARD_CODE>MLFIHL725$!^<SEGMENT_ID>SAML$!^"+dataElements+"XYZ123";

	var protocolLinkId = "MLFIAKP1";

	var arguments = new Array();

	var dialogWidth	= window.screen.width;
	var dialogHeight = window.screen.height;
	var dialogTop    = "0";
	var dialogLeft   = "0";

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ ";status:yes;scroll:no";	

	var action_url	="../../eXH/jsp/ShowMalaffiPortal.jsp?protocolLinkId="+protocolLinkId+"&dataElements="+dataElements;

	var retVal =await window.showModalDialog(action_url,arguments,features);
	//var retVal = window.open(action_url,arguments,features);

	/*
	
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',	
		type: 'POST',
		cache: false,
		data: {
				callType: 'MALAFFI',
				paramString: dataElements
		}, 
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
	
	*/

	return retVal;
} 

//Code changes made for MOHE-CRF-0016 by Sethu on 01/10/2020
var insuranceid;

function invokeCardReader(fieldName, statusFieldName)
{
	/*
	var segment_id = "ICR", element_id = "WEBSOCKET_URL", standard_code = "INSCARDSTD";
	
	insuranceid = "";
	var insuranceField = "#"+fieldName;
	$(insuranceField).val("");
	var statusField = "#"+statusFieldName;
	$(statusField).text("");
	var websocketurl = getGetSegmentData(standard_code, segment_id, element_id);
	websocket = new WebSocket(websocketurl);
	websocket.onopen = function(evt) { onOpen(evt, statusFieldName) };
	websocket.onclose = function(evt) { onClose(evt, statusFieldName) };
	websocket.onmessage = function(evt) { onMessage(evt, fieldName, statusFieldName) };
	websocket.onerror = function(evt) { onError(evt, fieldName, statusFieldName) };
	
	*/
	
	var payskyReturnStr = "";
	var paySkyParam = "";

	paySkyParam+="requesttype=CustInq";		
	payskyReturnStr = PaySkyTransaction(paySkyParam);

	return payskyReturnStr;
}


function getInsuranceID(){
	return insuranceid;
}

function onOpen(evt, statusFieldName)
{
	
	var statusField = "#"+statusFieldName;
	$(statusField).text("Connection Opened");

	//var message = $("#request").val();	
	//doSend(message, statusFieldName);
}

function onClose(evt, statusFieldName)
{
	var statusField = "#"+statusFieldName;
	$(statusField).text("Connection Closed");

}

function onMessage(evt, fieldName, statusFieldName)
{
	var data = JSON.parse(evt.data);
	var insuranceData=data.message;

	var insuranceField = "#"+fieldName;
	$(insuranceField).val(insuranceData);

	var statusField = "#"+statusFieldName;
	$(statusField).text("Message Received");

	insuranceid = insuranceData;

	websocket.close();
}

function onError(evt, fieldName, statusFieldName)
{
	insuranceid = evt.data;
	var insuranceField = "#"+fieldName;
	$(insuranceField).val("");
	var statusField = "#"+statusFieldName;
	$(statusField).text(evt.data);
}

function doSend(message, statusFieldName)
{
	websocket.send(message);
	var statusField = "#"+statusFieldName;
	$(statusField).text("Message Sent");
}

function getGetSegmentData(standard_code, segment_id, element_id)
{
	var responseData = "";
	$.ajax({	
			url:"../../servlet/eXH.InvokeExternalApplication",
			type:"GET",
			dataType:"text",
			data:{
				 callType:'SegmentData',
				 standardcode:standard_code,
				 segmentid:segment_id,
				 elementid:element_id
			},
			async:false,
			success:function(data){
				responseData = data;
				
			}	
		});

	return responseData;
}
//Code changes made for MOHE-CRF-0016 by Sethu on 01/10/2020

//Code changes made for NMC-JD-CRF-0072.1 by Sethu on 30/12/2020
/*
Request parameters
	request: (COUPON,HOLD,RELEASE,USED)- Can be anyone
	patientid: Patient ID - Mandatory for all request
	Coupon: NMC100000011240000000000007538,NMC100000011300000000001542650,NMC100000011300000000001542649 - Mandatory for HOLD, RELEASE, USED
	transactionid: Actual Bill Number generated - for USED request, for other request it can be empty.
	loginuserid: Logged in user id - Mandatory for all request
	Workstationno: Logged in Workstation No - Mandatory for all request

Response:
	For Coupon Request: 
		//S$!^SUCCESS$!^NMC100000011240000000000007538~50#NMC100000011300000000001542650~70#NMC100000011300000000001542649~10$!^S$!^
		//S$!^SUCCESS$!^NMC100000011240000000000007538~50~Cash Coupon test#NMC100000011300000000001542650~70~Cash Coupon test#NMC100000011300000000001542649~10~Cash Coupon test$!^S$!^
		//E$!^ERROR$!^$!^E$!^<Error Message>
	For other transactions
		//S$!^SUCCESS$!^$!^S$!^
		//E$!^ERROR$!^$!^E$!^<Error Message>

*/
function NuhdeekTransactions(request,patientid,coupon,transactionid, loginuserid, workstationno)
{
	/*
	var alertData = "";
	
	if (request == "")
	{
		alertData = "Request Type";
	}
	
	if (patientid == "")  
	{
		if (alertData.length>0)
		{
			alertData = alertData + ", ";
		}
		alertData = alertData + "Patient ID";
	}
	
	if ((request == "HOLD") || (request == "RELEASE") || (request == "USED"))
	{
		if (coupon == "")  
		{
			if (alertData.length>0)
			{
				alertData = alertData + ", ";
			}
			alertData = alertData + "Coupon Codes";
		}
	}

	if (alertData.length>0)
	{
		return "E$!^ERROR$!^$!^E$!^Parameters "+alertData+" should not be empty, unable to proceed with the request ";
	}

	*/

	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'NUHDEEK',
				request_type: request,
				patient_id: patientid,
				coupon_no:coupon,
				transaction_id:transactionid,
				login_user_id:loginuserid,
				workstation_no:workstationno
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  

	// Response Messages
	//S$!^SUCCESS$!^NMC100000011240000000000007538~50#NMC100000011300000000001542650~70#NMC100000011300000000001542649~10$!^S$!^
	//E$!^ERROR$!^$!^E$!^<Error Message>

   return responseMsg;
}

// Added by Apoorva for MOHE-CRF-0020 - This is used for getting the check status flag
function getTrnStatusFlag(cust_group, seg_id)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'CheckEligibilityStatusProfile',
				cust_group_code: cust_group,
				segment_id: seg_id
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   return responseMsg;
}

//Code changes made for MOHE-CRF-0026 by Sethu on 01/10/2020

/*
Request parameters

	P_REQUEST_TYPE	- (PHPREAUTH/PHSTATUS/PHDISP)	- Mandatory for all request
	P_FACILITY_ID	- FACILITY_ID			- Mandatory for all request
	P_DISP_DATA		- Concatenated String	- As given here
	
	---- Preauthorization Status Request
		P_PATIENT_ID~P_ENCOUNTER_ID~P_ORDER_ID~P_DISP_ID~P_ITEM_SEQUENCE~P_DRUG_CODE~P_STATUS~P_DISPENSE_QTY~P_DISPENSE_UOM~P_UNIT_PRICE_VALUE#P_PATIENT_ID~P_ENCOUNTER_ID~P_ORDER_ID~P_DISP_ID~P_ITEM_SEQUENCE~P_DRUG_CODE~P_STATUS~P_DISPENSE_QTY~P_DISPENSE_UOM~P_UNIT_PRICE_VALUE#

	Sample 1 := 'A100000044~100000850001~PHOP00000000332~164~1~260-00054~R~1~120~7.5#A100000044~100000850001~PHOP00000000332~164~2~260-00070~R~1~TUBE~6.9';
	
	---- Status Check Request
		P_PATIENT_ID~P_ENCOUNTER_ID~P_ORDER_ID~P_DISP_ID~P_ITEM_SEQUENCE~P_DRUG_CODE~P_STATUS~P_DISPENSE_QTY~P_DISPENSE_UOM~P_UNIT_PRICE_VALUE~P_RESP_STATUS~P_CLAIM_ID#P_PATIENT_ID~P_ENCOUNTER_ID~P_ORDER_ID~P_DISP_ID~P_ITEM_SEQUENCE~P_DRUG_CODE~P_STATUS~P_DISPENSE_QTY~P_DISPENSE_UOM~P_UNIT_PRICE_VALUE~P_RESP_STATUS~P_CLAIM_ID
	
	Sample 2 := 'A100000044~100000850001~PHOP00000000332~164~1~260-00054~R~1~120~7.5~S~100011#A100000044~100000850001~PHOP00000000332~164~2~260-00070~R~1~TUBE~6.9~S~100011';

	---- Dispense Request
		P_PATIENT_ID~P_ENCOUNTER_ID~P_ORDER_ID~P_DISP_ID~P_ITEM_SEQUENCE~P_DRUG_CODE~P_STATUS~P_DISPENSE_QTY~P_DISPENSE_UOM~P_UNIT_PRICE_VALUE~DOSAGE_FREQUENCY_CODE~DOSAGE_FREQUENCY~DOSAGE_PERIOD~DOSAGE_PERIOD_UNIT~ROUTE_CODE~DOSE_QUANTITY_VALUE~DOSE_QUANTITY_UNIT#P_PATIENT_ID~P_ENCOUNTER_ID~P_ORDER_ID~P_DISP_ID~P_ITEM_SEQUENCE~P_DRUG_CODE~P_STATUS~P_DISPENSE_QTY~P_DISPENSE_UOM~P_UNIT_PRICE_VALUE~DOSAGE_FREQUENCY_CODE~DOSAGE_FREQUENCY~DOSAGE_PERIOD~DOSAGE_PERIOD_UNIT~ROUTE_CODE~DOSE_QUANTITY_VALUE~DOSE_QUANTITY_UNIT

	Sample 3 := 'A100000044~100000850001~PHOP00000000312~144~1~200-00414~R~2~TAB~.15~OD~1~7~D~PO~500~MG#A100000082~100001630001~PHOP00000000358~181~1~200-00414~R~10~TAB~.15~TID~3~5~D~TOP~1~TAB';
					
					- Composition - String tokenizer with ~ between attributes and # for each order item.
						---- Preauthorization Status Request
						1	P_patient_id			- Mandatory
						2	P_encounter_id			- Mandatory
						3	P_order_id				- Mandatory
						4	P_disp_id				- Optional
						5	P_item_sequence_no		- Mandatory
						6	P_drug code				- Mandatory
						7	P_status				- N - Mandatory
						8	P_dispense qty			- Mandatory
						9	P_dispense uom			- Mandatory
						10	P_unit price			- Mandatory
						---- Status Check Request (In Continuation with Preauthorization Request)
						11	P_resp_status			- Optional
						12	P_claim_id				- Mandatory
						---- Dispense Request (In Continuation with Preauthorization Request)
						11	P_dosage_frequency_code	- Mandatory
						12	P_dosage_frequency		- Mandatory
						13	P_dosage_period			- Mandatory
						14	P_dosage_period_unit	- Mandatory
						15	P_route_code			- Mandatory
						16	P_dose_quantity_value	- Mandatory
						17	P_dose_quantity_unit	- Mandatory


	P_LOGINUSERID	- Logged in user id		- Mandatory for all request
	P_WORKSTATIONNO	- Logged in Workstation No - Mandatory for all request

Response: responseMsg
	For PHPREAUTH/PHSTATUS Request: 
		//S$!^SUCCESS$!^P_PATIENT_ID~P_ENCOUNTER_ID~P_ORDER_ID~P_DISP_ID~P_ITEM_SEQUENCE~P_DRUG_CODE~P_STATUS~P_DISPENSE_QTY~P_DISPENSE_UOM~P_UNIT_PRICE_VALUE~RESPONSE_STATUS~CLAIM_ID~APPROVAL_NO~ADJUDICATION_STATUS~BENEFIT_VALUE#$!^S$!^

		S$!^SUCCESS$!^P_PATIENT_ID~P_ENCOUNTER_ID~P_ORDER_ID~P_DISP_ID~P_ITEM_SEQUENCE~P_DRUG_CODE~P_STATUS~P_DISPENSE_QTY~P_DISPENSE_UOM~P_UNIT_PRICE_VALUE~P_STATUS~P_CLAIM_ID

---- Preauthorization Status Respomse
		
	Sample 1 := 'S$!^SUCCESS$!^A100000044~100000850001~PHOP00000000332~164~1~260-00054~R~1~120~7.5~P~100011-123456~B~5#A100000044~100000850001~PHOP00000000332~164~2~260-00070~R~1~TUBE~6.9~P~100011-123456~B~5#A100000044~100000850001~PHOP00000000332~164~2~260-00070~R~1~TUBE~6.9~P~100011-123456~B~5#A100000044~100000850001~PHOP00000000332~164~2~260-00070~R~1~TUBE~6.9~P~100011-123456~B~5';


		Expected - 
		RESPONSE_STATUS		- (P - Processed / S - Submitted / E - Error / R - Partial) - (Default - S)
		CLAIM_ID			- Mandatory  
		APPROVAL_NO			- Optional
		ADJUDICATION_STATUS - (B - Benefit FOR Status P & R only) Otherwise NULL 
		BENEFIT_VALUE		- (100 - Benefit value in amount) If ADJUDICATION_STATUS is B Otherwise 0
	For PHDISP transactions
		//S$!^SUCCESS$!^$!^S$!^

	//E$!^ERROR$!^$!^E$!^<Error Message>

*/
function PayerAuthorization(p_request_type, p_facility_id, p_disp_data, p_loginuserid, p_workstationno)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'XHPAYER',
				request_type: p_request_type,
				facility_id: p_facility_id,
				disp_data: p_disp_data,
				login_user_id: p_loginuserid,
				workstation_no: p_workstationno
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  

   return responseMsg;
}

/* Code added by Sethu for MOHE-CRF-0076 on 01/08/2021 */
function GetTransactionId(p_request_data)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'GENERATE_ID',				
				request_data: p_request_data
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  

   return responseMsg;
}

/* Code added by Sethu for MOHE-CRF-0076 on 01/08/2021 */
function GetInsuranceId(patientid)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'GET_INSURANCE_ID',				
				patient_id: patientid
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  

   return responseMsg;
}

async function PaySkyTransaction(p_request_data)
{

	var action_url	="../../eXH/jsp/BLPaySkyPayments.jsp?"+p_request_data;

	var center='1';
	var dialogTop = "200";
	var dialogHeight = "30vh" ;
	var dialogWidth = "50vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
	var arguments = "" ;

	retVal=await window.showModalDialog(action_url,arguments,features);	
    return retVal;
}

//Added by Gopinath for NMC-JD-CRF-0202 on 23/05/2023
async function openSpectraWebPayments(dataElements, p_request_data) {

	var action_url = "../../eXH/jsp/BLSpectraWebPayments.jsp?" + p_request_data;

	var center = '1';
	var dialogTop = "200";
	var dialogHeight = "30vh";
	var dialogWidth = "50vw";
	var features = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight
			+ "; center:" + center + "; dialogWidth:" + dialogWidth
			+ ";status=no";
	var arguments = "";

	retVal =await window.showModalDialog(action_url, arguments, features);
	
	/*
	* Added by Gopinath on 28/07/2023
	*/
	var AuditResponse = "";
	$.ajax({
		url : '../../servlet/eXH.InvokeExternalApplication',
		type : 'POST',
		cache : false,
		data : 'callType=AuditInfoIU&AuditMode=U&RESPONSE_TEXT=' + retVal+"&"+dataElements,
		success : function(data1) {
			AuditResponse = data1;
		},
		dataType : 'text',
		async : false
	});
	
	return retVal;
}

function getWaitTime(segment_id) 
{
	var responseData = "";
	$.ajax({	
			url:"../../servlet/eXH.InvokeExternalApplication",
			type:"GET",
			dataType:"text",
			data:{
				 callType:'GetWaitTime',
				 segmentid:segment_id
			},
			async:false,
			success:function(data){
				responseData = data;
				
			}	
		});

	return responseData;
}

function PaySkyAuditInfo(p_request_data)
{
	var responseData = "";
	$.ajax({	
			url:"../../servlet/eXH.InvokeExternalApplication",
			type:"GET",
			dataType:"text",
			data: 'callType=AuditInfo&' + p_request_data,		
			async:false,
			success:function(data){
				responseData = data;
				
			}	
		});

	return responseData;
}
//Code changes made for MOHE-CRF-0076 by Sethu on 25/08/2021

function validate_hid_tranx()
{	
	var payskyReturnStr = "";
	var paySkyParam = "";

	paySkyParam+="requesttype=CustInq";		
	payskyReturnStr = PaySkyTransaction(paySkyParam);
	
	document.forms[0].insuranceid.value = payskyReturnStr;	
	document.forms[0].patientId.value = payskyReturnStr;		
	
}
// Added by Apoorva for TH-KW-CRF-0020 on 03/10/2022 Starts here
function getNewToken(func_id, facility_id, doc_id, clinic_id, pat_id, pat_name, appt_true_yn, appt_date, appt_time, enc_id,user_id)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'FetchNewToken',
				function_id: func_id,
				facility_id: facility_id,
				doctor_id: doc_id,
				clinic_code: clinic_id,
				patient_id: pat_id,
				patient_name: pat_name,
				appointment_true_yn: appt_true_yn,
				appointment_date: appt_date,
				appointment_time: appt_time,
				encounter_id: enc_id,
				user_id: user_id
		},		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   return responseMsg;
}


function getTokenDetails(func_id, facility_id, token_num, pat_id,enc_id,user_id)
{
	if(token_num == null || token_num == ""){
		alert("Queue PKID is empty");
	}
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'FetchTokenDetails',
				function_id: func_id,
				facility_id: facility_id,
				token_number: token_num,
				patient_id: pat_id,
				encounter_id: enc_id,
				user_id: user_id
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   return responseMsg;
}


function releaseToken(func_id, facility_id, token_num, pat_id,enc_id,user_id)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'ReleaseTokenDetails',
				function_id: func_id,
				facility_id: facility_id,
				token_number: token_num,
				patient_id: pat_id,
				encounter_id: enc_id,
				user_id: user_id
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   return responseMsg;
}

function insertIntoXhQmsTable(func_id,facility_id,queue_id,token_num,issue_dt,call_dt,pat_id,enc_id,ref_id,status_code,status_text,user_id)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'InsertIntoXhQmsTable',
				function_id: func_id,
				facility_id: facility_id,
				queue_pkid: queue_id,
				token_number: token_num,
				issued_date: issue_dt,
				called_date: call_dt,
				patient_id: pat_id,
				encounter_id: enc_id,
				reference_id: ref_id,
				status_code: status_code,
				status_text: status_text,
				user_id: user_id
							
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   return responseMsg;
}


// Added by Apoorva for TH-KW-CRF-0020 on 03/10/2022 ends here

//Added by Kranthi kumar TH-KW-CRF-082 on 07/11/2022
async function validate_eSignature()
{
	
	var action_url	="../../eXH/jsp/CaptureSignature.jsp";

	var center='1';
	var dialogTop = "200";
	var dialogHeight = "30vh" ;
	var dialogWidth = "50vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
	var arguments = "" ;

	retVal=await window.showModalDialog(action_url,arguments,features);
	
	//alert(" *** Base64 Data :"+retVal);
	
			
	/* var img = new Image();
	function getBase64Img() {
	    //var x = "data:image/png;base64,"+ retVal;
	    var x = retVal;
	    return x;
	    
	}
	
	var base64img = getBase64Img();
	
	
	function Base64ToImage(base64img, callback) {
	    img.onload = function() {
	        callback(img);
	    };
	    img.src = base64img;
	    
	    
	}
	Base64ToImage(base64img, function(img) {
		document.getElementById('main').appendChild(img) ;		  		  
	});	 
*/	

    return retVal;
    
}

async function openLinkHealthIdDialog(patient_id, facility, loginUser, p_ws_no, sessionID) {
var mobile_no = document.getElementById("contact2_no").value;
var alt_id4_no = document.getElementById("alt_id4_no").value;
var abha_id = document.getElementById("abha_pat_id").value;
var action_url = "../../eXH/jsp/SearchCreateABHAID.jsp?aadhaar_no=" + alt_id4_no + "&patient_id=" + patient_id + "&facility_id=" + facility + "&logged_in_user=" + loginUser + "&logged_in_ws_no=" + p_ws_no + "&session_id=" + sessionID + "&mobile_no=" + mobile_no;
var center = '1';
var dialogTop = "150";
var dialogHeight = "20vh";
var dialogWidth = "75vw";
var features = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight
+ "; center:" + center + "; dialogWidth:" + dialogWidth
+ ";status=no";
var arguments = "";
var retVal = await window.showModalDialog(action_url, arguments, features);

var resArray = retVal.split("$!^");
var response = resArray[0];
var aadhaar_no = resArray[1];
var response_option = resArray[2];

var resdata = jQuery.parseJSON(response);
if (resdata != "" && resdata != null) {
	
	/*Condition Added By Gopinath for GHL-CRF-0657.2*/
	if(response_option=="CREATE"){
		document.getElementById("first_name").value = nullCheck(resdata.firstName);
		document.getElementById("family_name").value = nullCheck(resdata.lastName);
		document.getElementById("first_name").onblur();
		document.getElementById("family_name").onblur();
		document.getElementById("alt_id4_no").value = nullCheck(aadhaar_no);
		//document.getElementById("alt_id4_no").onblur();
		document.getElementById("contact2_no").value = nullCheck(resdata.mobile);
		document.getElementById("abha_pat_id").value = nullCheck(resdata.healthIdNumber);
		document.getElementById("abha_pat_id_1").value = 'XX-XXX-XXX-'+nullCheck(resdata.healthIdNumber).substring(13);
		document.getElementById("sex").value = nullCheck(resdata.gender);
		document.getElementById("date_of_birth").value = dateFomatter(resdata.dayOfBirth) + '/' + dateFomatter(resdata.monthOfBirth) + '/' + nullCheck(resdata.yearOfBirth);
		//document.getElementById("date_of_birth").onblur();
		document.getElementById("email").value = nullCheck(resdata.email);
		//document.getElementById("r_addr_line3").value = nullCheck(resdata.districtName);
		//document.getElementById("r_addr_line4").value = nullCheck(resdata.stateName);
		document.getElementById("r_area_code").value = nullCheck(resdata.districtName);
		document.getElementById("r_region_code").value = nullCheck(resdata.stateName);
		
		document.getElementById('first_name').disabled = isNotNull(resdata.firstName);
		document.getElementById('family_name').disabled =isNotNull(resdata.lastName);
		document.getElementById('alt_id4_no').disabled = isNotNull(aadhaar_no);
		document.getElementById('contact2_no').disabled =isNotNull(resdata.mobile);
		document.getElementById('abha_pat_id_1').disabled =isNotNull(resdata.healthIdNumber);
		document.getElementById('sex').disabled =isNotNull(resdata.gender);		
		document.getElementById('email').disabled =isNotNull(resdata.email);
		//document.getElementById('r_addr_line3').disabled =isNotNull(resdata.districtName);
		//document.getElementById('r_addr_line4').disabled =isNotNull(resdata.stateName);
		document.getElementById('r_area_code').disabled =isNotNull(resdata.districtName);
		document.getElementById('r_region_code').disabled =isNotNull(resdata.stateName);
		document.getElementById('date_of_birth').disabled = true;
		document.getElementById('imgdateofbirth').disabled = true;
		document.getElementById("age_or_dob").checked = false;
		document.getElementById("b_age").disabled = true;
		document.getElementById("b_months").disabled = true;
		document.getElementById("b_days").disabled = true;
		document.getElementById("age_or_dob").disabled = true;		
		document.getElementById("date_of_birth").onblur();
		
		document.getElementById("abha_pat_id_1").style.visibility = 'visible';
		document.getElementById("aadhaar_visible").style.visibility = 'visible';
		document.getElementById("abha_label_visible").style.visibility = 'visible';
		//document.getElementById("abha_field_visible").style.visibility = 'visible';
		
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eXH/jsp/SearchAreaRegion.jsp'><input type='hidden' name='area_desc' id='area_desc' value=\""+nullCheck(resdata.districtName)+"\"><input type='hidden' name='region_desc' id='region_desc' value=\""+nullCheck(resdata.stateName)+"\"></form></body></html>";
		parent.parent.messageFrame.document.write(HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
	}
	/*Condition Added By Gopinath for GHL-CRF-0657.2*/
	else if(response_option=="SEARCH"){
		var health_id=nullCheck(resdata.healthIdNumber);
		if(health_id!=""){
			document.getElementById("abha_label_visible").style.visibility = 'visible';
			document.getElementById("abha_pat_id").value = nullCheck(resdata.healthIdNumber);
			document.getElementById("abha_pat_id_1").value = 'XX-XXX-XXX-'+health_id.substring(13);
			document.getElementById("abha_pat_id_1").disabled =isNotNull(resdata.healthIdNumber);
			document.getElementById("abha_pat_id_1").style.visibility = 'visible';
		}
	}	
}
}

function dateFomatter(val){
	return val<10? "0"+val:val;
}

function isNotNull(val){
	
	if(val==null || val=="")
		return false;
		
	return true;
}

function nullCheck(val){
	return val==null?"":val;
}

function ndhmReset() {
	document.getElementById("mobile_no").disabled = true;
	document.getElementById("mobile_no").readOnly = false;
	document.getElementById("mobile_no").value = "";

	document.getElementById("saotpbtn").style.display = "inline";
	document.getElementById("smotpbtn").style.display = "none";

	document.getElementById("aadhaar_otp").value = "";
	document.getElementById("mobile_otp").value = "";
	document.getElementById("aotpdiv").style.display = "none";
	document.getElementById("motpdiv").style.display = "none";

	document.getElementById("sMsgId").innerHTML = "";
	document.getElementById("erMsgId").innerHTML = "";
	document.getElementById("ntfMsgId").innerHTML = "";
	document.getElementById("sMsgId").style.display = "none";
	document.getElementById("erMsgId").style.display = "none";
	document.getElementById("ntfMsgId").style.display = "none";

	document.getElementById("reset").disabled = true;

	document.getElementById("verAOtp").disabled = true;
	document.getElementById("verMOtp").disabled = true;
	document.getElementById("verAOtp").style.display = "inline";
	document.getElementById("verMOtp").style.display = "none";

}

function otpValidation(elementId, enableId) {
	var val = document.getElementById(elementId).value;
	if (val.length == 6) {
		document.getElementById(enableId).disabled = false;
	} else {
		document.getElementById(enableId).disabled = true;
	}
}

function aadhaarValidation(evt, elementId, enableId) {
	var val = document.getElementById(elementId).value;

	if (val.length == 12) {
		document.getElementById(enableId).disabled = false;
	} else {
		document.getElementById(enableId).disabled = true;
	}

	// Only ASCII character in that range allowed
	var ASCIICode = (evt.which) ? evt.which : evt.keyCode
	if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
		return false;
	return true;
}

function mobileValidation(evt, elementId, enableId) {
	var val = document.getElementById(elementId).value;

	if (val.length == 10) {
		document.getElementById(enableId).disabled = false;
	} else {
		document.getElementById(enableId).disabled = true;
	}

	// Only ASCII character in that range allowed
	var ASCIICode = (evt.which) ? evt.which : evt.keyCode
	if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
		return false;
	return true;
}

function linkHealthId(request_type) {
	
	var aadhaar_no = document.getElementById("aadhaar_no").value;
	var mobile_no = document.getElementById("mobile_no").value;
	var patient_id = document.getElementById("patient_id").value;
	var aadhaar_otp = document.getElementById("aadhaar_otp").value;
	var mobile_otp = document.getElementById("mobile_otp").value;
	var aadhaar_trans_id = document.getElementById("atxnId").value;
	var mobile_trans_id = document.getElementById("mtxnId").value;
	var facility_id = document.getElementById("facility_id").value;
	var logged_in_user = document.getElementById("logged_in_user").value;
	var logged_in_ws_no = document.getElementById("logged_in_ws_no").value;
	var session_id = document.getElementById("session_id").value;

	if (aadhaar_no != "" && aadhaar_no.length == 12) {
		$.ajax({
			url: '../../servlet/eXH.InvokeEGLapplication',
			type: 'POST',
			cache: false,
			data: {
				callType: 'GetNDHMOTP',
				request_type: request_type,
				aadhaar_no: aadhaar_no,
				mobile_no: mobile_no,
				patient_id: patient_id,
				aadhaar_otp: aadhaar_otp,
				mobile_otp: mobile_otp,
				aadhaar_trans_id: aadhaar_trans_id,
				mobile_trans_id: mobile_trans_id,
				facility_id: facility_id,
				logged_in_user: logged_in_user,
				logged_in_ws_no: logged_in_ws_no,
				session_id: session_id
			},
			success: function(resdata) {
				var resArray = resdata.split("$!^");
				var response = resArray[0];
				var errorCode = resArray[1];
				//var errorMsg = resArray[2];
				
				document.getElementById("sMsgId").style.display = "none";
				document.getElementById("erMsgId").style.display = "none";
				document.getElementById("ntfMsgId").style.display = "none";

				if (errorCode == "S") {
					var response_text = jQuery.parseJSON(response);

					document.getElementById("erMsgId").style.display = "none";
					document.getElementById("ntfMsgId").style.display = "none";

					if (request_type == "NDHAD1"
						|| request_type == "NDHAD6") {
						document.getElementById("atxnId").value = response_text.txnId;

						document.getElementById("aadhaar_no").readOnly = true;
						document.getElementById("aotpdiv").style.display = "inline";
						document.getElementById("saotpbtn").style.display = "none";
						document.getElementById("verAOtp").disabled = true;

						if (request_type == "NDHAD1") {
							document.getElementById("sMsgId").innerHTML = "OTP successfully sent to linked Aadhaar mobile number!";
						} else {
							document.getElementById("sMsgId").innerHTML = "OTP successfully Resent to linked Aadhaar mobile number!";
						}
						document.getElementById("sMsgId").style.display = "inline";						
					}

					if (request_type == "NDHAD3"
						|| request_type == "NDHAD7") {

						document.getElementById("mtxnId").value = response_text.txnId;
						document.getElementById("verMOtp").disabled = true;
						document.getElementById("mobile_no").readOnly = true;

						if (response_text.mobileLinked == false) {
							document.getElementById("smotpbtn").style.display = "none";
							document.getElementById("aotpdiv").style.display = "none";
							document.getElementById("motpdiv").style.display = "inline";							

							if (request_type == "NDHAD3") {
								//document.getElementById("sMsgId").innerHTML = "OTP successfully sent to Entered mobile number!";
							} else {
								//document.getElementById("sMsgId").innerHTML = "OTP successfully Resent to Entered mobile number!";
							}
							document.getElementById("ntfMsgId").innerHTML = "Given Mobile Number is different from Aadhar mobile Number. Please Enter Mobile OTP.";
							document.getElementById("ntfMsgId").style.display = "inline";
							//document.getElementById("sMsgId").style.display = "inline";
						} else if (response_text.mobileLinked == true) {
							document.getElementById("reset").disabled = true;
							var mobile_trans_id = document.getElementById("mtxnId").value;

							$.ajax({
								url: '../../servlet/eXH.InvokeEGLapplication',
								type: 'POST',
								cache: false,
								data: {
									callType: 'GetNDHMOTP',
									request_type: 'NDHAD5',
									aadhaar_no: aadhaar_no,
									mobile_no: mobile_no,
									patient_id: patient_id,
									aadhaar_otp: aadhaar_otp,
									mobile_otp: mobile_otp,
									aadhaar_trans_id: aadhaar_trans_id,
									mobile_trans_id: mobile_trans_id,
									facility_id: facility_id,
									logged_in_user: logged_in_user,
									logged_in_ws_no: logged_in_ws_no,
									session_id: session_id
								},
								success: function(responseData) {

									getAbhaInfo(responseData);
								},
								dataType: 'text',
								async: false
							});
						}

					} else if (request_type == "NDHAD2"
						|| request_type == "NDHAD4") {
						
						document.getElementById("aotpdiv").style.display = "none";
						document.getElementById("motpdiv").style.display = "none";
						document.getElementById("sMsgId").innerHTML = "OTP verified successfully!";
						document.getElementById("sMsgId").style.display = "inline";

					}

					//document.getElementById("aadhaar_otp").value = "";
					//document.getElementById("mobile_otp").value = "";

					if (request_type == "NDHAD2") {
						document.getElementById("atxnId").value = response_text.txnId;
						var mobileNo = document.getElementById("mobile_no").value;
						if (mobileNo.length < 10) {
							document.getElementById("smotpbtn").disabled = true;
						} else {

							document.getElementById("smotpbtn").disabled = false;
						}

						document.getElementById("mobile_no").disabled = false;
						document.getElementById("smotpbtn").style.display = "inline";
						document.getElementById("verAOtp").style.display = "none";
						document.getElementById("verMOtp").style.display = "inline";
					}

					if (request_type == "NDHAD4") {
						document.getElementById("mtxnId").value = response_text.txnId;
						var mobile_trans_id = document.getElementById("mtxnId").value;

						$.ajax({
							url: '../../servlet/eXH.InvokeEGLapplication',
							type: 'POST',
							cache: false,
							data: {
								callType: 'GetNDHMOTP',
								request_type: 'NDHAD5',
								aadhaar_no: aadhaar_no,
								mobile_no: mobile_no,
								patient_id: patient_id,
								aadhaar_otp: aadhaar_otp,
								mobile_otp: mobile_otp,
								aadhaar_trans_id: aadhaar_trans_id,
								mobile_trans_id: mobile_trans_id,
								facility_id: facility_id,
								logged_in_user: logged_in_user,
								logged_in_ws_no: logged_in_ws_no,
								session_id: session_id
							},
							success: function(responseData) {

								document.getElementById("reset").disabled = true;
								document.getElementById("verMOtp").disabled = true;

								getAbhaInfo(responseData);

							},
							dataType: 'text',
							async: false
						});
					}
				} else if (errorCode == "F") {
					document.getElementById("sMsgId").style.display = "none";

					if (request_type == "NDHAD1") {
						document.getElementById("erMsgId").innerHTML = "Check the Aadhaar number";
					} else if (request_type == "NDHAD2") {
						document.getElementById("erMsgId").innerHTML = "The OTP is invalid. Try again.";
					} else if (request_type == "NDHAD3") {
						document.getElementById("erMsgId").innerHTML = "Check the Mobile number. or Send Mobile OTP again.";
					} else if (request_type == "NDHAD4") {
						document.getElementById("erMsgId").innerHTML = "The OTP is invalid. Try again.";
					} else if (request_type == "NDHAD5") {
						document.getElementById("erMsgId").innerHTML = "There is a problem linking Health ID. Try again.";
					} else if (request_type == "NDHAD6") {
						document.getElementById("erMsgId").innerHTML = "There is a problem with Resending the OTP. Try again.";
					} else if (request_type == "NDHAD7") {
						document.getElementById("erMsgId").innerHTML = "There is a problem with Resending the OTP. Try again.";
					}

					document.getElementById("erMsgId").style.display = "inline";
				} else {
					document.getElementById("sMsgId").style.display = "none";

					document.getElementById("erMsgId").innerHTML = "Something went wrong please try again.";
					document.getElementById("erMsgId").style.display = "inline";
				}
			}

		});
	} else {
		document.getElementById("aadhaar_no").readOnly = false;
		document.getElementById("saotpbtn").disabled = true;
		document.getElementById("erMsgId").innerHTML = "Please Enter the correct Aadhaar number.";
		document.getElementById("erMsgId").style.display = "inline";
	}
}


function getAbhaInfo(responseData) {

	var resArray = responseData.split("$!^");
	var response = resArray[0];
	var errorCode = resArray[1];
	// var errorMsg = resArray[2];

	if (errorCode == "S") {
		var newVal = resArray[3];
		var fullResponse = resArray[4];

		document.getElementById("abhaInfo").value = fullResponse;

		var resdata = jQuery.parseJSON(response);
		$("#abhaIdInfoTable").append('<tr id="headerRow"></tr>');
		$.each(resdata[0], function(a, b) {
			$("#headerRow").append('<th>' + a + '</th>');
		});
		$.each(resdata, function(a, b) {
			$("#abhaIdInfoTable").append('<tr id="' + a + '"></tr>');
			var dataRowId = '#' + a;
			$.each(resdata[a], function(c, d) {
				$(dataRowId).append('<td>' + d + '</td>');
			});
		});

		if (newVal == "true") {
			document.getElementById("erMsgId").style.display = "none";
			document.getElementById("sMsgId").innerHTML = "ABHA ID Created Successfully!";
			document.getElementById("sMsgId").style.display = "inline";
		} else {
			document.getElementById("erMsgId").style.display = "none";
			document.getElementById("sMsgId").innerHTML = "ABHA ID Details Retrieved Successfully!";
			document.getElementById("sMsgId").style.display = "inline";
		}
		document.getElementById("smotpbtn").style.display = "none";
		document.getElementById("finish").disabled=false;
	} else if (errorCode == "F") {
		document.getElementById("erMsgId").innerHTML = "Error creating while Linking AbhaID. Try again.";
		document.getElementById("erMsgId").style.display = "inline";
	} else {
		document.getElementById("sMsgId").style.display = "none";
		document.getElementById("erMsgId").innerHTML = "Something went wrong please try again.";
		document.getElementById("erMsgId").style.display = "inline";
	}
}

function closeLinkHealthIdWindow() {
	var consent = document.getElementById("consent").value;
	
	if(consent){
		var responseData = document.getElementById("abhaInfo").value;
		var aadhaar_no = document.getElementById("aadhaar_no").value;
		window.returnValue=responseData+"$!^"+aadhaar_no;
	}	
	window.close();
}

async function validateNationalID(nationalID, sessionID, facility, loginUser, p_ws_no) {
	var action_url = "../../eXH/jsp/validateNationalID.jsp?nationalID="+nationalID+"&sessionID="+sessionID+"&facility="+facility+"&loginUser="+loginUser+"&p_ws_no="+p_ws_no;
	// var action_url = "../../eXH/jsp/.jsp";
	var center = '1';
	var dialogTop = "200";
	var dialogHeight = "15";
	var dialogWidth = "35";
	var features = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight
			+ "; center:" + center + "; dialogWidth:" + dialogWidth
			+ ";status=no";
	var arguments = "";

	retVal =await window.showModalDialog(action_url, arguments, features);
	return retVal;
}

// Added by Nagarjun for ML-BRU-CRF-628.10 on 14/05/2023
function fetchQueueNumber(facility_id, assign_care_locn_code, patient_id, EncounterId,user_id,workStationId)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'FetchQueueNumber',
				facility_id : facility_id,
				location_id : assign_care_locn_code,
				patient_id : patient_id,
				encounter_id : EncounterId,
				user_id : user_id,
				workStation_id : workStationId
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   return responseMsg;
}

// Added by Nagarjun for ML-BRU-CRF-628.10 on 14/05/2023 ends


// Added by Gopinath for GHL-CRF-0657.2 on 25/08/2023
async function createSearchABHAID(){
	var action_url	="../../eXH/jsp/SearchCreateABHAID.jsp";

	var center='1';
	var dialogTop = "200";
	var dialogHeight = "20vh" ;
	var dialogWidth = "60vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
	var arguments = "" ;

	var retVal=await window.showModalDialog(action_url,arguments,features);	
    return retVal;
}

async function updateABHADetails(patient_id, facility, loginUser, p_ws_no, sessionID){
	var action_url	="../../eXH/jsp/UpdateDownloadABHACard.jsp?patient_id=" + patient_id + "&facility_id=" + facility + "&logged_in_user=" + loginUser + "&logged_in_ws_no=" + p_ws_no + "&session_id=" + sessionID;

	var center='1';
	var dialogTop = "200";
	var dialogHeight = "25vh" ;
	var dialogWidth = "60vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
	var arguments = "" ;

	var retVal=await window.showModalDialog(action_url,arguments,features);
	
   // return retVal;
	var resArray = retVal.split("$!^");
	var resmode = nullCheck(resArray[0]);

	if(resmode=="UPDATEABHA") {
		var resmobile = nullCheck(resArray[1]);
		var resemail = nullCheck(resArray[2]);
		if(resmobile!=""){
			document.getElementById("contact2_no").value =resmobile ;
		}
		if(resemail!=""){
			document.getElementById("email").value =resemail;
		}
		document.location.reload();
	}
}

function callABDM(request_type,request_option,request_data){

	var responseMsg = "";
	$.ajax({
		url : '../../servlet/eXH.InvokeEGLapplication',
		type : 'POST',
		cache : false,
		data: {
			callType: 'ABDM',
			request_type: request_type,
			request_option: request_option,
			request_data: request_data
		},
		success : function(resData) {
			responseMsg = resData;
		},
		dataType : 'text',
		async : false
	});

	return responseMsg;
}

async function scanAndShareAbhaId(patient_id, facility, loginUser, p_ws_no, sessionID) {
	//document.getElementById("abha_pat_id").value = "33333fG4e";
	var action_url = "../../eXH/jsp/ScanAndShareABHADetails.jsp?patient_id=" + patient_id + "&facility_id=" + facility + "&logged_in_user=" + loginUser + "&logged_in_ws_no=" + p_ws_no + "&session_id=" + sessionID;

	var center = '1';
	var dialogTop = "200";
	var dialogHeight = "20vh";
	var dialogWidth = "60vw";
	var features = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight
			+ "; center:" + center + "; dialogWidth:" + dialogWidth
			+ ";status=no";
	var arguments = "";

	var retVal =await window.showModalDialog(action_url, arguments, features);
	
	if(retVal!=undefined)
		document.getElementById("abha_pat_id").value = retVal;

}

function callScanABHA(name,mobile_no,SearchMode,UsedFlag){
	var responseMsg = "";
	$.ajax({
		url : '../../servlet/eXH.InvokeEGLapplication',
		type : 'POST',
		cache : false,
		data: {
			callType: 'SCANABHA',
			name : name,
			mobileNumber: mobile_no,
			searchMode:SearchMode,
			usedFlag : UsedFlag
		},
		success : function(resData) {
			responseMsg = resData;
		},
		dataType : 'text',
		async : false
	});

	return responseMsg;
}

// Added by Kranthi for ML-MMOH-CRF-1844
function callSingleSignOnAuth(requestType,username,password){
	
	var responseMsg = "";
	$.ajax({
		url : '../../servlet/eXH.InvokeEGLapplication',
		type : 'GET',
		cache : false,
		data: {
			callType : 'SINGLESIGNON',
			request_type : 'VALIDATE_AUTH', 
			Username : username	,   // AD Username
			Password : password       
		},
		success : function(resData) {
			responseMsg = resData;
		},
		dataType : 'text',
		async : false
	});
	
	return responseMsg;
}

// Added by Kranthi for ML-MMOH-CRF-1844
function callSingleSignOnSearch(requestType,requestOption,searchText){

	var responseMsg = "";
	$.ajax({
		url : '../../servlet/eXH.InvokeEGLapplication',
		type : 'GET',
		cache : false,
		data: {
			callType : 'SINGLESIGNON',
			request_type : 'GET_ACTIVE_USERS', 
			request_option : requestOption,	// If requestType is SEARCH means requestOption value should be (ALL, S, E or C)
			Username : searchText
		},
		success : function(resData) {
			responseMsg = resData;
		},
		dataType : 'text',
		async : false
	});
	
	return responseMsg;
}

// Added by Kranthi for ML-MMOH-CRF-1844
function callSingleSignOnInactiveUsers(requestOption,searchText){

	var responseMsg = "";
	$.ajax({
		url : '../../servlet/eXH.InvokeEGLapplication',
		type : 'GET',
		cache : false,
		data: {
			callType : 'SINGLESIGNON',
			request_type : 'GET_INACTIVE_USERS'
		},
		success : function(resData) {
			responseMsg = resData;
		},
		dataType : 'text',
		async : false
	});
	
	return responseMsg;
}

