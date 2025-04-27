<!DOCTYPE html>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.io.*"%>
<HTML>

<%
	request.setCharacterEncoding("UTF-8");   

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String ip = request.getHeader("x-forwarded-for"); 


	if (ip != null && ip.length() > 0) 
		   System.out.println( " X-FORWARDED-FOR IP Address... "+ip);
	

	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
	   ip = request.getHeader("Proxy-Client-IP");

	   if (ip != null && ip.length() > 0) 
		   System.out.println( " PROXY-CLIENT-IP IP Address... "+ip);		 
	}      
	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
	   ip = request.getHeader("WL-Proxy-Client-IP");     
	   
	   if (ip != null && ip.length() > 0) 
		   System.out.println( " WL-PROXY-CLIENT-IP IP Address... "+ip);
	}      
	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
	   ip = request.getRemoteAddr();  
	   
	   if (ip != null && ip.length() > 0) 
		   System.out.println( " GETREMOTEADDR IP Address... "+ip);
	}  

	System.out.println( " Sethu IP Address... "+ip);

	

	Enumeration<String> headerNames = request.getHeaderNames();
	while(headerNames.hasMoreElements()) {
	  String headerName = headerNames.nextElement();
	  System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
	}

	Enumeration<String> params = request.getParameterNames(); 
	while(params.hasMoreElements()){
	 String paramName = params.nextElement();
	 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
	}

	System.out.println(" ***********************************");

	String line = null;
	BufferedReader reader = request.getReader();

	while ((line = reader.readLine()) != null){
		System.out.println(line);
	}

 %>
<HEAD>
<meta http-equiv="X-UA-Compatible" content="IE=10">
<TITLE>New Document</TITLE>
<meta charset="utf-8">
<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>"
	type="text/css" />
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
<script language="javascript" src="../../eCA/js/jquery-1.7.2.min.js"></script>

<script Language="JavaScript">

	
	var websocket;
	
	$(document).ready(function() {   

		$("#connect").click(function() {

			/*

			var myNav = navigator.userAgent.toLowerCase();

			$("#status").val("");
			$("#messagesList").val("");
			$("#insuranceid").val("");

			var id = invokeInsuranceCardReader("insuranceid","cardStatus"); //invokeInsuranceCardReader("insuranceid","cardStatus");	

			return false;     

			*/
			
			validate_hid_tranx();
			
			/*

			var arguments = new Array();

			var dialogWidth	= "600px";
			var dialogHeight = "200px";
			var dialogTop    = "100";
			var dialogLeft   = "100";

			var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ ";status:yes;scroll:no";	

			var action_url	="../../eXH/jsp/WebSocketPOC.jsp";

			
			var retVal = window.open(action_url,"",  "toolbar=no,scrollbars=yes,resizable=yes,top=100,left=200,width=800,height=200");
			
			*/
			
		});

		$("#paysky").click(function() {			
					
			alert("Document Mode in POC Page : "+document.documentMode);			
			

			validate_ps_tranx();
			
		});

		$("#PayerRequest").click(function() {

			PayerRequest();
			
		});

		$("#EmiratesIdBtn").click(function() {

			GetEmiratesId();
			
		});
		
		/* $("#CaptureSignature").click(function() {			
			
			alert("Document Mode in POC Page : "+document.documentMode);			

			validate_eSignature();
			
			
		}); */
		
	});

	/*
	$(document).ready(function() {   

		$("#connect").click(function() {			

			$("#status").val("");
			$("#messagesList").val("");
			$("#insuranceid").val("");

			var socketUri = $("#websocketuri").val();	

			*/

			/* ************************
			var arguments = new Array();

			var dialogWidth	= "300px";
			var dialogHeight = "300px";
			var dialogTop    = "100";
			var dialogLeft   = "100";

			var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ ";status:yes;scroll:no";	

			var action_url	="../../eXH/jsp/WebSockets.html";

			var retVal = window.open(action_url,"",  "toolbar=no,scrollbars=yes,resizable=yes,top=100,left=500,width=400,height=400");

			*/
			
			/*
			websocket = new WebSocket(socketUri,"echo-protocol");

			$("#status").val("Connected");
			
			return false;     
			
		});

		$("#send").click(function() {	
			
			var message = $("#request").val();	

			websocket.send(message);

			$("#status").val("Message Sent");

			$("#messagesList").val(message);

			var data = JSON.parse(message);
			var x=data.message;

			$("#insuranceid").val(x);

			return false;     
			
		});
		
	});

	*/

	

	function runApp(which) {
		WshShell = new ActiveXObject("WScript.Shell");
		WshShell.Run (which,1,true);
	}
	function getCardData()
	{	
		var ecr_counter = "1";
		var application_id = "11";
		var machine_port = "COM1";
		var baud_rate = "19200";
		var cash_given = "0.01";	
		var application = "PLUTUS";
		var wait_time = "";
		
		var ccData = "";
		var transNo = 0;

		application = document.getElementById("application").value;
		cash_given = document.getElementById("cash_given").value;	

		if (application == "SPECTRA") 
		{
		
			ecr_counter = document.getElementById("ecr_counter").value;
			application_id = document.getElementById("application_id").value;
			machine_port = document.getElementById("machine_port").value;
			baud_rate = document.getElementById("baud_rate").value;
			cash_given = document.getElementById("cash_given").value;	
			wait_time = document.getElementById("wait_time").value;	

			if (ecr_counter=="") {
				ecr_counter = "1";
				document.getElementById("ecr_counter").value = "1";
			}

			if (ecr_counter=="") {
				ecr_counter = "1";
				document.getElementById("ecr_counter").value = "1";
			}

			if (application_id=="") {
				application_id = "11";
				document.getElementById("application_id").value = "11";
			}

			if (machine_port==""){
				machine_port = "COM1";
				document.getElementById("machine_port").value = "COM1";
			}

			if (baud_rate==""){
				baud_rate = "19200";
				document.getElementById("baud_rate").value = "19200";
			}

			if (cash_given==""){
				cash_given = "0.01";
				document.getElementById("cash_given").value = "0.01";
			}			
			
			//ccData ="Transaction_type=debit$!^Amount=0.01$!^ECR_counter=1$!^Application_id=11$!^Refund_rrn=null$!^Menu=null$!^Printer=null$!^Printer_speed=null$!^Machine_port=COM1$!^BoudRate=19200";

			ccData ="Transaction_type=debit$!^Amount="+cash_given+"$!^ECR_counter="+ecr_counter+"$!^Application_id="+application_id+"$!^Refund_rrn=null$!^Menu=null$!^Printer=null$!^Printer_speed=null$!^Machine_port="+machine_port+"$!^BoudRate="+baud_rate+"$!^intExtAppID="+application+"$!^WaitTime="+wait_time;
		}
		
		if (application == "PLUTUS") {

			transNo = document.getElementById("transNo").value;
			transNo = Number(transNo) + Number(1);
			document.getElementById("transNo").value = transNo;
			ccData = "4001,"+transNo+",100,PLUTUS,,,,,,,,"; 
		}

		if (application == "PHONEPE") {

			transNo = document.getElementById("transNo").value;
			transNo = Number(transNo) + Number(1);
			document.getElementById("transNo").value = transNo;
			ccData = "5102,"+transNo+",100,PHONEPE,,,,,,,,"; 
		}

		var arr = ccData.split(",");
		if (arr.length>1)
		{

			if ( arr[3] != null && arr[3] != "")
			{
				if (arr[3] == "PLUTUS")
					ccData = ccData.replace("PLUTUS", "");
				else if (arr[3] == "PHONEPE")
					ccData = ccData.replace("PHONEPE", "105");
				
			}
		}

		alert(ccData);
		runApp("file://C:/em-interface/EM_CC_PLUGIN/EM_CC_COM_PORT_Start.bat");
		var summary = document.CreditCardReader.Capture(ccData);
		var arr = "";

		alert(summary);		
		
	}

	function callApplication()
	{
		var applicationID = "";
		applicationID = document.getElementById("application").value;

		if (applicationID == "PLUTUS"||applicationID == "PHONEPE") {
			document.getElementById("ecr_counter").disabled = true;
			document.getElementById("application_id").disabled = true;
			document.getElementById("machine_port").disabled = true;
			document.getElementById("baud_rate").disabled = true;
		}
		if (applicationID == "SPECTRA") {
			document.getElementById("ecr_counter").disabled = false;
			document.getElementById("application_id").disabled = false;
			document.getElementById("machine_port").disabled = false;
			document.getElementById("baud_rate").disabled = false;
		}

		document.CreditCardReader.setApplicationId(applicationID);
	}

	function loadPage()
	{
		document.getElementById("ecr_counter").disabled = true;
		document.getElementById("application_id").disabled = true;
		document.getElementById("machine_port").disabled = true;
		document.getElementById("baud_rate").disabled = true;

		var applicationID = "";
		applicationID = document.getElementById("application").value;
		//document.CreditCardReader.setApplicationId(applicationID);
	}

	function getEligibilityCheck()
	{
		var dataElements = "<PATIENT_ID>0966865$!^<ENCOUNTER_ID>106018210001$!^<NATIONAL_ID>1177299250$!^<PATIENT_NAME>Zainab Mohammed Faadel Awal$!^<PATIENT_DOB>2015-12-19$!^<MOBILE_NO>0545530032$!^<MEMBERSHIP_NO>14933819$!^<POLICY_HOLDER_NAME>Zainab Mohammed Faadel Awal$!^<POLICY_PLAN_NO>272672003$!^<PROVIDER_CODE>15$!^<SERVICE_TYPE>CAD1$!^<PAYER_CODE>15-00163$!^<FACILITY_ID>02$!^<LOGGED_IN_USER_ID>IBAEHIS$!^<LOGGED_IN_WSNO>172.18.10.93$!^<SESSION>REGVISIT";

		//var dataElements = "<PATIENT_ID>0966865$!^<ENCOUNTER_ID>106018210001$!^<NATIONAL_ID>1177299250$!^<PATIENT_NAME>Zainab Mohammed Faadel Awal$!^<PATIENT_DOB>2015-12-19$!^<MOBILE_NO>0545530032$!^<MEMBERSHIP_NO>14933819$!^<POLICY_HOLDER_NAME>Zainab Mohammed Faadel Awal$!^<POLICY_PLAN_NO>272672003$!^<PROVIDER_CODE>CP$!^<SERVICE_TYPE>O002$!^<PAYER_CODE>CORP0011$!^<FACILITY_ID>02$!^<LOGGED_IN_USER_ID>IBAEHIS$!^<LOGGED_IN_WSNO>172.18.10.93$!^<SESSION>REGVISIT";

		var patient_id = "0966865";
		
		var response = checkPatientMembershipEligibility(dataElements,patient_id);

		alert(response);
	}


	function showPDFFile()
	{
		var retVal = "";
		var url = "";
		var dialogHeight = "5";			    
		var dialogWidth  = "20";
		var dialogTop    = "300";
		var dialogLeft   = "450";
		var applicationID = "";

		dialogHeight = screen.height;			    
		dialogWidth  = screen.width;
		dialogTop    = "0";
		dialogLeft   = "0";
		features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
		
		url = "../../eMP/jsp/ViewPatientScanDocument.jsp"
		retVal = window.showModalDialog(url,arguments,features);
		//retVal = window.open(url);

		
	}

	function validOTPTransaction(request)
	{
		var phone= document.getElementById("PhoneNum").value;
		var otp= document.getElementById("OTP").value;

		var dataElements = "<FACILITY_ID>JD$!^<PATIENT_ID>JA01000027$!^<PHONE_NUM>"+phone+"$!^<PRIM_SEC_FLAG>P$!^<OTP>"+otp+"$!^<REQUEST>"+request+"$!^<USER>user$!^<WS_NO>DXCINDAI103";

		alert(dataElements);

		var response = "";

		response = OTPTransaction(dataElements);

		alert(response);
	} 

	function ShowURL()
	{
		var dataElements           = "P_USE_ID=RAO&P_NUHDEEK_ID=100628951&P_PATIENT_ID=JA01000027&P_ENCNTR_DATE=&P_VISIT_ID=&P_EPISODE_ID=&P_EPISODE_TYPE=&P_PHYSICIAN_ID=&P_ACCESSION_NUM=&P_ORDER_ID=&P_ORDER_TYPE_CODE=&P_LOCN_TYPE=&P_LOCN_CODE=&P_CUST_CODE=&P_ITEM_CODE=&P_RESP_ID=&P_FACILITY_ID=JA&P_INV_ORG_ID=&P_MODULE_ID=OP&P_FUNCTION_ID=&P_ACCESS_RIGHTS=&P_LANGUAGE_ID=en&P_MULTI_SITE_YN=&P_MULTI_LANG_YN=&P_WS_NO=&P_Ext_Input_Key=&P_Ext_Application_ID=DMS&P_Ext_Function=VIEW&P_pwd=&P_Connect_string=&P_LOCN_DESC=";
            
        dispExtApp(dataElements); 

	}
	
	function MalaffiPortal()
	{
		var practitionerid = document.getElementById("practitionerid").value;
		var patientid = document.getElementById("patientid").value;

		var dataElements = "<PATIENT_ID>"+patientid+"$!^<PRACTITIONER_ID>"+practitionerid+"$!^<USER_NAME>"+practitionerid+"$!^<MACHINE_ID>DXCINDAI696704$!^<SESSION_ID>XYZ123";

		var response = "";

		alert(dataElements);

		response = EMWebMalaffi(dataElements);

	} 	

	function invokeInsuranceCardReader(fieldName, statusFieldName)
	{
		var segment_id = "ICR", element_id = "WEBSOCKET_URL", standard_code = "INSCARDSTD";
	
		var websocketurl = getGetSegmentData(standard_code, segment_id, element_id);
		//var websocketurl = "wss://echo.websocket.org/";


		$("#websocketuri").val(websocketurl);
		
		var insuranceField = "#"+fieldName;
		$(insuranceField).val("");

		var statusfield = "#"+statusFieldName;

		$(statusfield).text("Inside Card Reader");

		insuranceid = "";
		//var socketUri = $("#websocketuri").val();
		//websocket = new WebSocket('ws://localhost:8025/ws/chat');

		websocket = new WebSocket(websocketurl);		
		websocket.onopen = function(evt) { onOpen(evt, statusFieldName) };
		websocket.onclose = function(evt) { onClose(evt, statusFieldName) };
		websocket.onmessage = function(evt) { onMessage(evt, fieldName, statusFieldName) };
		websocket.onerror = function(evt) { onError(evt, fieldName, statusFieldName) };

		return insuranceid;
	}

	function onOpen(evt, statusFieldName)
	{
		$("#status").val("Connected");
		var message = $("#request").val();	
		doSend(message, statusFieldName);
	}

	function onClose(evt, statusFieldName)
	{
		$("#status").val("Disconnected");
		var statusfield = "#"+statusFieldName;
		$(statusfield).text("Message Received and Closed");
	}

	function onMessage(evt, fieldName, statusFieldName)
	{
		$("#status").val("Message Received");

		$("#messagesList").val(JSON.stringify(evt.data));

		var data = JSON.parse(evt.data);
		var insuranceData=data.message;

		var insuranceField = "#"+fieldName;
		$(insuranceField).val(insuranceData);

		var statusfield = "#"+statusFieldName;
		$(statusfield).text("Message Received");

		insuranceid = insuranceData;
		websocket.close();
	}

	function onError(evt, fieldName, statusFieldName)
	{		
		$("#status").val( evt.data);
		var insuranceField = "#"+fieldName;
		$(insuranceField).val("");
		var statusfield = "#"+statusFieldName;
		$(statusfield).text(evt.data);
	}

	function doSend(message, statusFieldName)
	{
		websocket.send(message);
		$("#status").val("Message Sent");
		var statusfield = "#"+statusFieldName;
		$(statusfield).text("Message Sent");
	}

	function NuhdeekRequest(nuhdeek)
	{	
		
		var request = document.getElementById("nuhdeekreq").value;
		var patientid = document.getElementById("patientid1").value;
		var coupons = document.getElementById("coupons").value;
		var transactionId = document.getElementById("transactionid").value;

		response = NuhdeekTransactions(request, patientid, coupons, transactionId, "ARSHAD", "INTERFACE" );
		alert(response);
	} 	

	function getDocumentMode()
	{	
		
		var documentModeStr = document.documentMode;

		alert(documentModeStr);		
		
	}


	function PayerRequest()
	{

		var responseMsg = "S$!^3491$!^ ::: l_trans_num : 3491$!^IDCPLP3800116764$!^Rejected$!^452$!^Info Req Blocked$!^85906269853631$!^R$!^";

		var responseData = "";

		responseData = responseMsg.split("$!^");

		if (responseData.length > 0)
		{
			alert(" Response Data Length... "+responseData);
			if (responseData[0] == "S")
			{
				alert(" Response Data Flag... "+responseData[0]);
				if(!(responseData[8] !="R"))
				{
					alert(" Response Data Code... "+responseData[8]);
				}
			}
		}

		/*


		var pRequestType = document.getElementById("Request_Type").value;
		var pFacilityId = document.getElementById("Facility_Id").value;
		var pDispData = document.getElementById("Disp_Data").value;
		var pAddedById = document.getElementById("Added_By_id").value;
		var pAddedWorkstationId = document.getElementById("Workstation_id").value;

		alert(pDispData);

		var response = "";

		response = PayerAuthorization(pRequestType, pFacilityId, pDispData, pAddedById, pAddedWorkstationId);

		alert(response);

		*/
	} 

	//Added by Sethu for MOHE-CRF-0076 on 01/08/2021
	function validate_ps_tranx()
	{
		var patientID = "";
		var payAmount = "";
		var merchantOrderID = "";
		
		var payskyReturnStr = "";
		var paySkyParam = "";
		var paySkyData = "";

		patientID = $("#patientId").val();//"A100000232";			
		payAmount = $("#amount").val();//100.00;
		merchantOrderID = $("#transactionId").val();//"100001";
		
		var segmentId = "PSR";		
		var waitime = getWaitTime(segmentId);

		paySkyParam+="saledraftno="+merchantOrderID;
		paySkyParam+="&patientid="+patientID;
		paySkyParam+="&amount="+payAmount;
		paySkyParam+="&requesttype=RequestPayment";
		paySkyParam+="&waitime="+waitime;
		
		payskyReturnStr = PaySkyTransaction(paySkyParam);
		
		if (payskyReturnStr.length > 0){

			paySkyData = payskyReturnStr.split("$!^");			

			if (paySkyData.length > 0)
			{				
				if (paySkyData[0] == "SUCCESS"){					
					document.forms[0].merchantId.value = paySkyData[4];
					document.forms[0].payskyId.value = paySkyData[3];
					document.forms[0].datetime.value = paySkyData[5];	
				}
				else 
				{
					document.forms[0].merchantId.value = paySkyData[4];						
					document.forms[0].payskyId.value = "";
					document.forms[0].datetime.value = "";
				}
			}
		}
	}	
	
	//Added by Sethu for MOHE-CRF-0076 on 01/08/2021
	function validate_hid_tranx()
	{	
		var payskyReturnStr = "";
		var paySkyParam = "";
		
		var segmentId = "PSR";		
		var waitime = getWaitTime(segmentId);		

		paySkyParam+="requesttype=CustInq";		
		paySkyParam+="&waitime="+waitime;
		payskyReturnStr = PaySkyTransaction(paySkyParam);
		
		alert(payskyReturnStr);
					
		document.forms[0].insuranceid.value = payskyReturnStr;	
		document.forms[0].patientId.value = payskyReturnStr;		
		
	}	
	
	
	
	/* function validate_eSignature()
	{

		var action_url	="../../eXH/jsp/CaptureSignature.jsp";

		var center='1';
		var dialogTop = "200";
		var dialogHeight = "30" ;
		var dialogWidth = "50" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
		var arguments = "" ;

		retVal=window.showModalDialog(action_url,arguments,features);
		
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
		
		
	    return retVal;
	    
	}*/
 	
	

	function GetEmiratesId(){

		var name_prefix ='';
		var first_name='';
		var second_name='';
		var third_name='';
		var family_name='';		
		var nric_val='';
		var dob_val='';		
		var gender_val='';
		var nationality_val='';
		
		var addr_line_1='';
		var addr_line_2='';
		var addr_line_3='';
		var country_val='';				
		var mobile_no='';
		var passport_no='';
		var passport_exp='';
		var temp_arr='';			
		
		var summary = document.getElementById('CardReader').Capture();
		var arr = "";

		if(summary!=""){
			
			var cardDataArr	= summary.split("$!^");
			var nameArr		= cardDataArr[7].split(",");
			first_name		= nameArr[0];
			second_name		= nameArr[1];
			third_name		= nameArr[2];
			name_prefix		= nameArr[3];
			family_name		= nameArr[4];
			
			gender_val		= cardDataArr[8];
			nric_val		= cardDataArr[10];
			dob_val			= cardDataArr[11];
			addr_line_1		= cardDataArr[13];
			mobile_no		= cardDataArr[15];
			passport_no		= cardDataArr[16];
			passport_exp	= cardDataArr[17];
			nationality_val	= cardDataArr[12];
			country_val		= cardDataArr[12];

			document.forms[0].Emirates_Id.value = nric_val;	

		}

		alert(" Emirates Id... "+nric_val);
	}
	
	function createSearch(){
		var AbhaInfo = createSearchABHAID();
		alert("AbhaInfo: "+AbhaInfo);
	}
	
	function updateAbhaDtls(){
		var response = updateABHADetails("","","","","");
		
		if(response){
			alert("Response: "+response);
		}
	}
	
	function scanShareAbhaDtl(){
		var response = scanAndShareAbhaId("","","","","");
		
		if(response){
			alert("Response: "+response);
		}
	}	

		function eligibilityCheck() {
			alert('start eligibilityCheck...');
            var xhr = new XMLHttpRequest();
          
            var url = "XHDisplayECBenfitsTable.jsp?patient_id=AS40000255&response_ref_id=1234567";
            xhr.open("GET", url, true);

            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                   document.getElementById("tobTableDiv").innerHTML = xhr.responseText;
                }
            };

          
            xhr.send();
			alert('end eligibilityCheck...');
        }
	
	function spectraWebPayments(){
		var dataElements = "";
		var requestMsg = "Patient_id="+document.getElementById("sPatId").value+"&Amount="+document.getElementById("sAmount").value
		+"&Request_type="+document.getElementById("sReqType").value+"&WaitTime=30&Ws_url="+document.getElementById("sWeburl").value
		+"&Machine_port="+document.getElementById("sMport").value
		+"&BoudRate="+document.getElementById("sBoudRate").value+"&Print_settings=0";
		
		var responseMsg = openSpectraWebPayments(dataElements, requestMsg);
	}
	
	function openSpectraWebPayments(dataElements, p_request_data) {		

	var action_url = "../../eXH/jsp/BLSpectraWebPayments.jsp?" + p_request_data;
	//var action_url = "../../eXH/html/Geidea_Test_ECR.html?" + p_request_data;

	var center = '1';
	var dialogTop = "200";
	var dialogHeight = "30";
	var dialogWidth = "50";
	var features = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight
			+ "; center:" + center + "; dialogWidth:" + dialogWidth
			+ ";status=no";
	var arguments = "";

	retVal = window.showModalDialog(action_url, arguments, features);
	
	return retVal;
}
</script>
</HEAD>

<body onload="loadPage()">
	<form>
		<table border="1" cellpadding="3" cellspacing="0" align="center"
			width="800">
			<tr>
				<td width="25%" class="label">Application</td>
				<!--
			<td width="25%" class="fields" COLSPAN="3"><select id="application" name="application" id="application" onChange="callApplication()">
											  <option value="PLUTUS">PLUTUS</option>
											  <option value="SPECTRA">SPECTRA</option>											 
											</select> </td>	
			-->

				<td width="25%" class="fields" COLSPAN="3"><select id="application" name="application" id="application">
						<option value="PLUTUS">PLUTUS</option>
						<option value="SPECTRA">SPECTRA</option>
				</select></td>
			</tr>
			<tr>
				<td width="25%" class="label">ECR Counter (1)</td>
				<td width="25%" class="fields"><input type="text"
					name="ecr_counter" id="ecr_counter" id="ecr_counter" size="14" maxlength="10"
					value="1" style="text-align: left"></td>
				<td width="25%" class="label">Application ID (11)</td>
				<td width="25%" class="fields"><input type="text"
					name="application_id" id="application_id" id="application_id" size="14" maxlength="10"
					value="11" style="text-align: left"></td>
			</tr>
			<tr>
				<td width="25%" class="label">Port (COM1)</td>
				<td width="25%" class="fields"><input type="text"
					name="machine_port" id="machine_port" id="machine_port" size="14" maxlength="10"
					value="COM1" style="text-align: left"></td>
				<td width="25%" class="label">Baud Rate (19200)</td>
				<td width="25%" class="fields"><input type="text"
					name="baud_rate" id="baud_rate" id="baud_rate" size="14" maxlength="10"
					value="19200" style="text-align: left"></td>
			</tr>
			<tr>
				<td width="25%" class="label">Amount (0.01)</td>
				<td width="25%" class="fields"><input type="text"
					name="cash_given" id="cash_given" id="cash_given" size="14" maxlength="10"
					value="0.01" style="text-align: right"></td>
				<td width="25%" class="label">Wait Time (in seconds)</td>
				<td width="25%" class="fields"><input type="text"
					name="wait_time" id="wait_time" id="wait_time" size="14" maxlength="10" value="30"
					style="text-align: left"></td>
			</tr>
			<tr>
				<td align=left COLSPAN="2">
					<!--<input class="button" type="button"  name="Eligibility Check" value="Eligibility Check" onClick="getEligibilityCheck();"> -->
					<!--<input class="button" type="button"  name="Show PDF File" value="Show PDF File" onClick="showPDFFile();">-->
					<input class="button" type="button" name="Nuhdeek" id="Nuhdeek" value="Nuhdeek"
					onClick="ShowURL();">
				</td>
				<td align=right COLSPAN="2"><applet
						code="CreditCardApplet.class" name="CreditCardReader"
						codebase="../CreditCard" archive="CreditCardApplet.jar" width="5"
						height="5">
						<PARAM name="button_width" value="50" />
						<PARAM name="button_height" value="50" />
						<PARAM name="button_label" value="Credit Card" />
						<PARAM name="input_data"
							value="Transaction_type=debit$!^Amount=0.01$!^ECR_counter=1$!^Application_id=11$!^Refund_rrn=null$!^Menu=null$!^Printer=null$!^Printer_speed=null$!^Machine_port=COM1$!^BoudRate=19200" />
						<PARAM name="application_id" value="SPECTRA" />
						<param name="separate_jvm" value="true" />
						Sorry, Your browser does not support Java applet!
					</applet> &nbsp;&nbsp;&nbsp;&nbsp; <input class="button" type="button"
					name="Credit Card" value="Credit Card" onClick="getCardData();">


				</td>
			</tr>

			<tr>
				<td align=left COLSPAN="2">
					<!--<input class="button" type="button"  name="Eligibility Check" value="Eligibility Check" onClick="getEligibilityCheck();"> -->
					<input class="textbox" type="textbox" name="PhoneNum" id="PhoneNum" value="">
					&nbsp;&nbsp;&nbsp;&nbsp; <input class="button" type="button"
					name="Generate OTP" value="Generate OTP"
					onClick="validOTPTransaction("GENERATE_OTP");">
				</td>

				<td align=left COLSPAN="2">
					<!--<input class="button" type="button"  name="Eligibility Check" value="Eligibility Check" onClick="getEligibilityCheck();"> -->
					<input class="textbox" type="textbox" name="OTP" id="OTP" value="">
					&nbsp;&nbsp;&nbsp;&nbsp; <input class="button" type="button"
					name="Validate OTP" value="Validate OTP"
					onClick="validOTPTransaction('VALIDATE_OTP');">
				</td>

			</tr>

		</table>

		<table border="1" cellpadding="3" cellspacing="0" align="center"
			width="800">
			<tr>
				<td width="25%" class="label">Practitioner ID</td>
				<td align=left COLSPAN="2">
					<!--<input class="button" type="button"  name="Eligibility Check" value="Eligibility Check" onClick="getEligibilityCheck();"> -->
					<input class="textbox" type="textbox" id="practitionerid"
					name="practitionerid" id="practitionerid" value="">
				</td>
				<td width="25%" class="label">Patient ID</td>
				<td align=left COLSPAN="2"><input class="textbox"
					type="textbox" id="patientid" name="patientid" id="patientid" value="">
					&nbsp;&nbsp;&nbsp;&nbsp;</td>

				<td align=left COLSPAN="2"><input class="button" type="button"
					name="Malaffi Portal" value="Malaffi Portal"
					onClick="MalaffiPortal('MALAFFI');"></td>
			</tr>
		</table>
		<input type="hidden" name="transNo" id="transNo" id="transNo" VALUE="2000">

		<!--

	<table border="1" cellpadding="3" cellspacing="0" align = "center" width="800">	
		<tr>	
			<td width="20%" class="label">Request </td>
			<td width="20%" class="fields"><select id="nuhdeekreq" name="nuhdeekreq" id="nuhdeekreq">
											  <option value="COUPON">GET COUPON</option>
											  <option value="HOLD">HOLD COUPONS</option>	
											  <option value="RELEASE">RELEASE COUPONS</option>	
											  <option value="USED">USED COUPONS</option>	
											</select> </td>	
			<td width="20%" class="label">Patient ID</td>			
			<td align=left width="20%">					
				<input class="textbox" type="textbox" id="patientid1"  name="patientid1" id="patientid1" value=""> &nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<td class="label" width="20%"></td>	
		</tr>
		<tr>	
			<td width="20%" class="label">Coupons</td>
			<td width="20%" align=left >				
				<input class="textbox" type="textbox" id="coupons" name="coupons" id="coupons" value=""> 
			</td>
			<td width="20%" class="label">Trasaction ID</td>			
			<td width="20%" align=left >					
				<input class="textbox" type="textbox" id="transactionid"  name="transactionid" id="transactionid" value=""> &nbsp;&nbsp;&nbsp;&nbsp;
			</td>				
			<td width="20%" align=left >					
				<input class="button" type="button"  name="Nuhdeek" id="Nuhdeek" value="Nuhdeek" onClick="NuhdeekRequest('MALAFFI');">
			</td>	
		</tr>		
	</table>

	-->

		<table border="1" cellpadding="3" cellspacing="0" align="center"
			width="800">
			<tr>
				<td width="25%" class="label">Card Reader URI</td>
				<td width="50%" align=left><input class="textbox"
					type="textbox" id="websocketuri" name="websocketuri" id="websocketuri" value=""
					size="50"></td>
				<td width="25%" align=left><input class="button" type="button"
					id="connect" name="connect" id="connect" value="Get Insurance IDs"></td>
			</tr>
			<tr>
				<td width="25%" class="label">Request</td>
				<td width="50%" align=left><input class="textbox"
					type="textbox" id="request" name="request" id="request"
					value='{"message":"10028989, 10028990, 10028991",	"sender":"client",	"timeStamp": "Wed Aug 12 16:55:15 EET 2020"}'
					size="50"></td>
				<td width="25%" align=left><input class="button" type="button"
					id="send" name="send" id="send" value="Send"></td>

			</tr>
			<tr>
				<td width="25%" align=left>Status <!--<input class="textbox" type="textbox" id="status" name="status" id="status" value=""> -->
					<div id="cardStatus">
						<div></td>
				<td width="50%" align=left>Message Received <textarea
						id="messagesList" name="messagesList" rows="4" cols="60" disabled></textarea>
				</td>
				<td width="25%" align=left>Insurance ID's <input class="textbox" type="textbox" id="insuranceid" name="insuranceid" id="insuranceid"
					value="">
				</td>
			</tr>
			<tr>
				<td width="25%" align=left><input class="button" type="button"
					id="DocumentMode" name="DocumentMode" id="DocumentMode" value="DocumentMode"
					onClick="getDocumentMode();"></td>
			</tr>
		</table>

		<table border="1" cellpadding="3" cellspacing="0" align="center"
			width="800">
			<tr>
				<td width="100%" align="Center" colSpan="4">
					<p>
						<b>PaySky Payments</b>
					</p>
				</td>
			</tr>
			<tr>
				<td width="25%" align=left class="label">Insurance ID &nbsp; <input class="textbox" type="textbox" id="patientId" name="patientId" id="patientId"
					value="12345678" size="12">
				</td>
				<td width="25%" align=left class="label">Amount &nbsp; <input class="textbox" type="textbox" id="amount" name="amount" id="amount"
					value="150" size="10">
				</td>
				<td width="25%" align=left class="label">Transaction ID &nbsp;
					<input class="textbox" type="textbox" id="transactionId"
					name="transactionId" id="transactionId" value="101" size="10">
				</td>
				<td width="25%" align=left><input class="button" type="button"
					id="paysky" name="paysky" id="paysky" value="PaySky Payments"></td>
			</tr>
			<tr>
				<td width="25%" align=left class="label">EM Order ID &nbsp; <input class="textbox" type="textbox" id="merchantId" name="merchantId" id="merchantId"
					size="12">
				</td>
				<td width="25%" align=left class="label">PaySky ID &nbsp; <input class="textbox" type="textbox" id="payskyId" name="payskyId" id="payskyId"
					size="10">
				</td>
				<td width="25%" align=left class="label" colspan="2">Date &
					Time&nbsp; <input class="textbox" type="textbox" id="datetime"
					name="datetime" id="datetime" size="10">
				</td>
			</tr>
		</table>

		<table border="1" cellpadding="3" cellspacing="0" align="center"
			width="800">

			<tr>
				<td width="12%" class="label">Request Type</td>
				<td width="13%" class="fields"><select id="Request_Type"
					name="Request_Type" id="Request_Type">
						<option value="PHPREAUTH">PHPREAUTH</option>
						<option value="PHDISP">PHDISP</option>
						<option value="PHSTATUS">PHSTATUS</option>
				</select></td>
				<td width="12%" class="label">Facility Id</td>
				<td align=left width="13%"><input class="textbox"
					type="textbox" id="Facility_Id" name="Facility_Id" id="Facility_Id" value="A1">
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td width="12%" class="label">Dispense Data</td>
				<td width="38%" align=left><textarea id="Disp_Data"
						name="Disp_Data" value="" size="100" width=80> </textarea></td>
			</tr>
			<tr>
				<td width="12%" class="label">Added By ID</td>
				<td width="13%" align=left><input class="textbox"
					type="textbox" id="Added_By_id" name="Added_By_id" id="Added_By_id" value="RAO">
				</td>
				<td width="12%" class="label">Workstation ID</td>
				<td width="13%" align=left><input class="textbox"
					type="textbox" id="Workstation_id" name="Workstation_id" id="Workstation_id"
					value="IN-PF2DPDB7a"> &nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td width="50%" align=left colspan="2"><input class="button"
					type="button" id="PayerRequest" value="PayerRequest"
					onClick="PayerRequest()"></td>

			</tr>
			<tr>
				<td width="50%" align=left colspan="2"><input class="button"
					type="button" id="CaptureSignature" Onclick='validate_eSignature()'
					value="Capture-Signature"></td>
				<td width="50%" align=left colspan="2">
					<a href="#" onclick="updateAbhaDtls()"><span
						style="color: blue; text-decoration: underline;">Update/Download
							ABHA Details</span>
					</a>
				</td>
				<td width="50%"><a href="#" onclick="createSearch()"><span
						style="color: blue; text-decoration: underline;">Link
							Health ID</span></a></td>
				<td width="50%"><a href="#" onclick="scanShareAbhaDtl()"><span
						style="color: blue; text-decoration: underline;">Scan and Share</span></a></td>
			</tr>

<tr>
<td>
<input class="button" type="button"
					name="eligibility_check" id="eligibility_check" value="Eligibility Check"
					onClick="eligibilityCheck();">
					</td>
</tr>
<tr>
<div id="tobTableDiv" name="tobTableDiv"></div>
</tr>
		</table>
		<table border="1" cellpadding="3" cellspacing="0" align="center"
			width="800">
			<tr>
				<td width="100%" align="Center" colSpan="4">
					<p>
						<b>SPECTRA WEB PAYMENTS</b>
					</p>
				</td>
			</tr>
			<tr>
				<td width="33%" align=left class="label">Patient ID &nbsp; <input class="textbox" type="textbox" id="sPatId" name="sPatId" id="sPatId"
					value="12345" size="15">
				</td>
				<td width="33%" align=left class="label">Request Type &nbsp; <input class="textbox" type="textbox" id="sReqType" name="ReqType" id="ReqType"
					value="RequestPayment" size="15">
				</td>
				<td width="34%" align=left class="label">Amount &nbsp; <input class="textbox" type="textbox" id="sAmount" name="sAmount" id="sAmount"
					value="100" size="15">
				</td>
			</tr>
			<tr>
				<td width="40%" align=left class="label">Web URL &nbsp;
					<input class="textbox" type="textbox" id="sWeburl"
					name="sWeburl" id="sWeburl" value="ws://localhost:5000/messages" size="30">
				</td>
				<td width="25%" align=left class="label">Machine Port &nbsp; <input class="textbox" type="textbox" id="sMport" name="sMport" id="sMport" value="COM3" 
					size="15">
				</td>
				<td width="25%" align=left class="label">Boud Rate &nbsp; <input class="textbox" type="textbox" id="sBoudRate" name="sBoudRate" id="sBoudRate"
					size="15" value="38400">
				</td>
			</tr>
			<tr>
				<td width="20%" align=left><input class="button" type="button"
					id="sPayBtn" name="sPayBtn" id="sPayBtn" value="Spectra Payments" onClick="spectraWebPayments()" >
				</td>
				<td width="80%" align="left" colSpan="3">
					Response Message: &nbsp;
					<p id="sResMsg" name="sResMsg"></p>
				</td>
			</tr>
		</table>

		<!-- 
	<table border="1" cellpadding="3" cellspacing="0" align = "center" width="800">			
		<tr>					
			<td width="50%" align=left >					
				<input class="textbox" type="textbox" id="Emirates_Id"  name="Emirates_Id" id="Emirates_Id" value=""> &nbsp;&nbsp;&nbsp;&nbsp;
			</td>				
			<td width="50%" align=left colspan="2">				
				<input class="button" type="button"  id="EmiratesIdBtn" value="EmiratesId" onClick="GetEmiratesId()">&nbsp;&nbsp;
				<applet code="CardReaderApplet.class" name="CardReader"
					codebase="../../eXH/CardReader/" archive="CardReaderApplet.jar" width="5"
					height="5">
					<PARAM name="button_width" value="0" />
					<PARAM name="button_height" value="0" />
					<PARAM name="button_label" value="0" />						
					<param name="separate_jvm" value="true" />
					Sorry, Your browser does not support Java applet!
				</applet>
			</td>
		</tr>	

	</table>
	 -->
		<input type="hidden" id="sigImage" value="">

	</form>
</body>
</HTML>

