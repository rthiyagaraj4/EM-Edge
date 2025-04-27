<!DOCTYPE html>
<%@ page import="java.util.*,com.ehis.util.*,eXH.*"%>
<%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	Connection conn = null;
	boolean isDebugYN = false;
	
	try{
		isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PROTOCOL_LINK WHERE PROTOCOL_LINK_ID = 'ABDMPL1'").equals("Y")) ? true : false;
		System.out.println("***Inside Update ABHA ID - isDebugYN..."+isDebugYN);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("***Inside Update ABHA ID - Exception while checking isDebugYN Flag... "+e);
	}finally{
		ConnectionManager.returnConnection(conn);
		if(isDebugYN)
			System.out.println("***Inside Update ABHA ID - Conection closed");
	}
	
	String aadhaar_no = checkForNull(request.getParameter("aadhaar_no"));
	String mobile_no = checkForNull(request.getParameter("mobile_no"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String logged_in_user = checkForNull(request.getParameter("logged_in_user"));
	String logged_in_ws_no = checkForNull(request.getParameter("logged_in_ws_no"));
	String session_id = checkForNull(request.getParameter("session_id"));
	boolean timerOn = true;
	String waitTime = "30";
%>
<title>Link Health ID</title>
<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>" type="text/css" />
<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eCA/js/jquery-1.7.2.min.js"></script>
<style type="text/css">
.okBtn{
	width: 60px;
}
.content {
	padding: 10px;
	padding-bottom: 35px;
}
#footer {  
	bottom: 0;
	position: fixed;
	width: 99%;
	text-align: right;
	padding: 10px;
	background-color: white;
}
</style>
<script type="text/javascript">
function SearchCreateEvent(object){

	var strMode = "";
	var serEle = document.getElementsByName("searchRad");
    for (i=0; i < serEle.length; i++) {
        if (serEle[i].checked)
        	strMode =  serEle[i].value;
    }
    fieldsReset(strMode);
}

function fieldsReset(strMode){
	
	document.forms[0].reset();

	$("#abhaIdInfoTable").html("");
	document.getElementById("resMsg").innerHTML = "";
	
	var searchDiv = document.getElementById("searchDiv");
	var createDiv = document.getElementById("createDiv");
	var otpDiv = document.getElementById("otpDiv");
	var searchFooter = document.getElementById("searchFooter");
	var createFooter = document.getElementById("createFooter");

	if(strMode=="SEARCHABHA"){
		document.getElementById("searchRad").checked=true;
		searchDiv.style.display = 'block';
		createDiv.style.display = 'none';

		document.getElementById("SearchMobileNo").disabled = false;
		document.getElementById("Name").disabled = false;
		document.getElementById("BirthYear").disabled = false;
		document.getElementById("genSltId").disabled = false;
		
		otpDiv.style.display = 'none';
		
		document.getElementById("searchBtn").disabled = false;
		document.getElementById("searchOkBtn").disabled = true;
		
		searchFooter.style.display = 'block';
		createFooter.style.display = 'none';
		
	}else if(strMode=="CREATEABHA"){	
		document.getElementById("createRad").checked=true;
		searchDiv.style.display = 'none';
		createDiv.style.display = 'block';

		document.getElementById("CreateMobileNo").disabled = false;
		document.getElementById("AadhaarNo").disabled = false;
		var genOtpEle = document.getElementById("genOTPBtn");
		genOtpEle.disabled = false;
		genOtpEle.style.display = 'block';
		var genMobOtpEle = document.getElementById("genMobOTPBtn");
		genMobOtpEle.disabled = false;
		genMobOtpEle.style.display = 'none';		
		
		otpDiv.style.display = 'block';
		document.getElementById("etrAotpLabel").style.display = 'block';
		document.getElementById("etrMotpLabel").style.display = 'none';	
		document.getElementById("Otp").disabled=true;
		
		document.getElementById("verCreateBtn").disabled = true;
		document.getElementById("createOkBtn").disabled = true;
		
		searchFooter.style.display = 'none';
		createFooter.style.display = 'block';
	}	
}

function formRequestData(request_type,request_option){
	
	var patient_id = document.getElementById("patient_id").value;
	var facility_id = document.getElementById("facility_id").value;
	var logged_in_user = document.getElementById("logged_in_user").value;
	var logged_in_ws_no = document.getElementById("logged_in_ws_no").value;
	var session_id = document.getElementById("session_id").value;
	
	return "<REQUEST_TYPE>"+request_type+"$!^<REQUEST_OPTION>"+request_option+"$!^<PATIENT_ID>"+patient_id+"$!^<FACILITY_ID>"+facility_id+"$!^<LOGGED_IN_USER_ID>"+logged_in_user+"$!^<LOGGED_IN_WSNO>"+logged_in_ws_no+"$!^<SESSION>"+session_id+"$!^";
}

function search(){
	
	var isDebugYN = document.getElementById("isDebugYN").value;

	var mobileEle = document.getElementById("SearchMobileNo");
	var nameEle = document.getElementById("Name");
	var byEle = document.getElementById("BirthYear");
	
	var MobileNumber = mobileEle.value;
	var Name = nameEle.value;
	var BirthYear = byEle.value;
	var Gender="";
    var genEle = document.getElementById("genSltId");
    Gender = genEle.value;
	
    if(isDebugYN=="true")
		alert('Search ABHA... mobile_no:'+MobileNumber+' Name:'+Name+' BirthYear:'+BirthYear+' Gender:'+Gender);
	
	if(MobileNumber != null && MobileNumber !="" && Name != null && Name !="" 
			&& BirthYear != null && BirthYear !="" && Gender != null && Gender !=""){
		
		mobileEle.disabled = true;
		nameEle.disabled = true;
		byEle.disabled = true;
		genEle.disabled = true;
		document.getElementById("searchBtn").disabled = true;
		
		var request_type="SEARCHABHAID";
		var request_option="BYDEMOAUTH";
		var request_data = formRequestData(request_type,request_option);

		request_data = request_data+"<MOBILE_NO>"+MobileNumber+"$!^<NAME>"+Name+"$!^<BIRTHOFYEAR>"+BirthYear+"$!^<GENDER>"+Gender;
		
		if(isDebugYN=="true")
			alert("requestData: "+request_data);
		
		//var responseMsg = '{"authMethods":["AADHAAR_OTP","DEMOGRAPHICS","AADHAAR_BIO","MOBILE_OTP"],"healthIdNumber":"91-3171-3025-3881","status":"ACTIVE"}$!^S$!^ Success';
		var responseMsg = callABDM(request_type,request_option,request_data);
		
		if(isDebugYN=="true")
			alert('responseMsg: '+responseMsg);
		
		var resArray = responseMsg.split("$!^");
		var response = resArray[0];
		var errorCode = resArray[1];
		var errorMsg = resArray[2];
		
		$("#abhaIdInfoTable").html("");
		if(errorCode=="S" && response!="null"){
			var jsonResponse = jQuery.parseJSON(response);
			document.getElementById("abhaInfo").value=response;
			
			var tableData = '[{"ABHA Address":"'+jsonResponse.healthId+'","Health ID":"'+jsonResponse.healthIdNumber+'"}]';
			tableData = jQuery.parseJSON(tableData);
			
			document.getElementById("abhaIdInfoTable").style.display = 'block';		
			$("#abhaIdInfoTable").append('<tr id="headerRow"></tr>');
			$.each(tableData[0], function(a, b) {
				$("#headerRow").append('<th>' + a + '</th>');
			});
	
			$.each(tableData, function(a, b) {
				$("#abhaIdInfoTable").append('<tr id="' + a + '"></tr>');
				var dataRowId = '#' + a;
				$.each(tableData[a], function(c, d) {
					if(d=='undefined'){
						$(dataRowId).append('<td>Not Available</td>');
					}else{
						$(dataRowId).append('<td>' + d + '</td>');
					}
				});
			});
			
			document.getElementById("searchOkBtn").disabled = false;
			ResponseMsg('green','ABHA ID retrieved successfully!');
			
		} else if(errorCode=="F" && response!="null") {
			
			mobileEle.disabled = false;
			nameEle.disabled = false;
			byEle.disabled = false;
			genEle.disabled = false;
			document.getElementById("searchBtn").disabled = false;
			
			if(response=="" || response=="Failure"){
				ResponseMsg('red','ABHA ID not found for the given criteria.');
			}else{
				if(jQuery.parseJSON(response)){
					var jObj = jQuery.parseJSON(response);
				
					if(jObj.details[0].code!=null)
						ResponseMsg('red',jObj.details[0].code+":"+jObj.details[0].message);
				}else{
					ResponseMsg('red',response);
				}
			}
							
		}else{
			mobileEle.disabled = false;
			nameEle.disabled = false;
			byEle.disabled = false;
			genEle.disabled = false;
			document.getElementById("searchBtn").disabled = false;
			
			ResponseMsg('red','Unable to process response data, please check with your system administrator.');
		}
	}else {
		ResponseMsg('red','Enter all the mandatory details.');
	}
}

function generateOTP(option){
	
	var isDebugYN = document.getElementById("isDebugYN").value;
	
	var mobileEle = document.getElementById("CreateMobileNo");
	var aadharEle = document.getElementById("AadhaarNo");
	var otpEle = document.getElementById("Otp");
	
	var mobile_no = mobileEle.value;
	var aadhaar_no = aadharEle.value;
	
	if(isDebugYN=="true")
		alert('Generate OPT... mobile_no:'+mobile_no+' aadhaar_no:'+aadhaar_no+' option: '+option);
	
	if(option=="GENERATEOTP"){
	
		if(mobile_no!=null && mobile_no!=="" && aadhaar_no!=null && aadhaar_no!=""){
			mobileEle.disabled=true;
			aadharEle.disabled=true;
			document.getElementById("genOTPBtn").disabled = true;
		
			var request_type="CREATEABHAID";
			var request_option=option;
			var request_data = formRequestData(request_type,request_option);
			request_data = request_data+"<AADHAAR_ID>"+aadhaar_no+"$!^<MOBILE_NO>"+mobile_no;
			
			if(isDebugYN=="true")
				alert("requestData: "+request_data);
			
			var responseMsg = callABDM(request_type,request_option,request_data);
			
			if(isDebugYN=="true")
				alert('responseMsg: '+responseMsg);
			
			var resArray = responseMsg.split("$!^");
			var response = resArray[0];
			var errorCode = resArray[1];
			var errorMsg = resArray[2];
			
			if(errorCode=="S" && response!="null"){
				var jsonResponse = jQuery.parseJSON(response);
				//alert('ParsedJson: '+jsonResponse);
				document.getElementById("VerifyReqOption").value = "VERIFYOTP";
				document.getElementById("txnId").value = jsonResponse.txnId;				
				otpDiv.style.display = 'block';
				otpEle.disabled=false;
				ResponseMsg('green','OTP successfully sent to linked Aadhaar mobile number!');
				
			} else if(errorCode=="F" && response!="null") {
				mobileEle.disabled=false;
				aadharEle.disabled=false;
				document.getElementById("genOTPBtn").disabled = false;
				
				if(jQuery.parseJSON(response)){
					var jObj = jQuery.parseJSON(response);
				
					if(jObj.details[0].code!=null){
						var resmsg = jObj.details[0].code+":"+jObj.details[0].message;
						ResponseMsg('red',resmsg);
						
						if(jObj.details[0].code=="HIS-1023"){
							document.getElementById("genMobOTPBtn").disabled = true;
							otpEle.disabled=true;
							var timerOn = document.getElementById('timerOn').value;
							var waitTime = document.getElementById('waitTime').value;
							timer(waitTime,timerOn,option);
						}
					}
				}else{
					ResponseMsg('red',response);
				}
			}else{
				mobileEle.disabled=false;
				aadharEle.disabled=false;
				document.getElementById("genOTPBtn").disabled = false;
				ResponseMsg('red','Unable to process response data, please check with your system administrator.');
			}
		}else {
			ResponseMsg('red','Enter all the mandatory details.');
		}
	}else if(option=="GENERATEMOBILEOTP"){
		document.getElementById("genMobOTPBtn").disabled = true;
		
		var txnId = document.getElementById("txnId").value;
		
		var request_type="CREATEABHAID";
		var request_option=option;
		var request_data = formRequestData(request_type,request_option);
		request_data = request_data+"<TXN_ID>"+txnId+"$!^<MOBILE_NO>"+mobile_no;
		
		if(isDebugYN=="true")
			alert("requestData: "+request_data);
		
		var responseMsg = callABDM(request_type,request_option,request_data);
		
		if(isDebugYN=="true")
			alert('responseMsg: '+responseMsg);
		
		var resArray = responseMsg.split("$!^");
		var response = resArray[0];
		var errorCode = resArray[1];
		var errorMsg = resArray[2];
		
		if(errorCode=="S" && response!="null"){	
			document.getElementById("VerifyReqOption").value = "VERIFYMOBILEOTP";	
			document.getElementById("txnId").value = jsonResponse.txnId;				
			otpDiv.style.display = 'block';
			otpEle.disabled=false;
			ResponseMsg('green','OTP successfully sent to this mobile number ('+mobile_no+').');
		}else if(errorCode=="F" && response!="null")  {
			document.getElementById("genMobOTPBtn").disabled = false;
			otpEle.disabled = false;
			if(jQuery.parseJSON(response)){
				var jObj = jQuery.parseJSON(response);
			
				if(jObj.details[0].code!=null){
					var resmsg = jObj.details[0].code+":"+jObj.details[0].message;
					ResponseMsg('red',resmsg);
					
					if(jObj.details[0].code=="HIS-1023"){
						document.getElementById("genMobOTPBtn").disabled = true;
						otpEle.disabled=true;
						var timerOn = document.getElementById('timerOn').value;
						var waitTime = document.getElementById('waitTime').value;
						timer(waitTime,timerOn,option);
					}
				}
			}else{
				ResponseMsg('red',response);
			}
		}else{
			document.getElementById("genMobOTPBtn").disabled = false;
			otpEle.disabled = false;
			ResponseMsg('red',response);
		}		
	}
}

function verifyOtpOrCreateAbha(){
	
	var isDebugYN = document.getElementById("isDebugYN").value;
	
	var otpEle = document.getElementById("Otp");
	var otp = otpEle.value;
	var txnId = document.getElementById("txnId").value;
	var VerifyReqOption = document.getElementById("VerifyReqOption").value;
	
	if(isDebugYN=="true")
		alert('Verify Otp / Create ABHA... otp:'+otp+' txnId:'+txnId+' option: '+VerifyReqOption);
	
	var verCreBtnEle = document.getElementById("verCreateBtn");
	verCreBtnEle.disabled = true;
	otpEle.disabled=true;
	
	var request_type="CREATEABHAID";
	var request_option=VerifyReqOption;//"VERIFYOTP";
	var request_data = formRequestData(request_type,request_option);
	request_data = request_data+"<OTP>"+otp+"$!^<TXN_ID>"+txnId;
	
	if(isDebugYN=="true")
		alert("requestData: "+request_data);
	
	var responseMsg = callABDM(request_type,request_option,request_data);
	
	if(isDebugYN=="true")
		alert('responseMsg: '+responseMsg);
	
	var resArray = responseMsg.split("$!^");
	var response = resArray[0];
	var errorCode = resArray[1];
	var errorMsg = resArray[2];
	
	if(errorCode=="S" && response!="null"){
		
		var jObj = jQuery.parseJSON(response);
		var name = jObj.name;
		var gender = jObj.gender;
		var dayOfBirth = jObj.dayOfBirth;
		var monthOfBirth = jObj.monthOfBirth;
		var yearOfBirth = jObj.yearOfBirth;
		var healthIdNumber = jObj.healthIdNumber;
		var mobile = jObj.mobile;
		
		var email = "Not Available";
		if(jObj.email)
			email = jObj.email;
		
		var tableData = '[{"Name":"' + name +'","Gender":"' + gender +'","DOB":"' + dayOfBirth + '/' + monthOfBirth + '/' + yearOfBirth + '","ABHA ID":"' + healthIdNumber + '","Mobile Numbrer":"' + mobile + '","Email ID":"' + email + '"}]';
		tableData = jQuery.parseJSON(tableData);
		
		if(jObj.token!=null){

			document.getElementById("abhaInfo").value = response;
			
			document.getElementById("abhaIdInfoTable").style.display = 'block';
			$("#abhaIdInfoTable").append('<tr id="headerRow"></tr>');
			$.each(tableData[0], function(a, b) {
				$("#headerRow").append('<th>' + a + '</th>');
			});

			$.each(tableData, function(a, b) {
				$("#abhaIdInfoTable").append('<tr id="' + a + '"></tr>');
				var dataRowId = '#' + a;
				$.each(tableData[a], function(c, d) {
					$(dataRowId).append('<td>' + d + '</td>');
				});
			});
			
			document.getElementById("otpDiv").style.display='none';			
			document.getElementById("createOkBtn").disabled = false;
			
			if(jObj.New){
				ResponseMsg('green','ABHA ID Created Successfully!');
			}else{
				ResponseMsg('green','ABHA ID Details Retrieved Successfully!');
			}
		}else if(jObj.txnId!=null){
			document.getElementById("VerifyReqOption").value = "VERIFYMOBILEOTP";	
			document.getElementById("txnId").value = jObj.txnId;				
			otpDiv.style.display = 'block';
			document.getElementById("etrAotpLabel").style.display = 'none';
			document.getElementById("etrMotpLabel").style.display = 'block';
			otpEle.value = "";
			otpEle.disabled=false;
			verCreBtnEle.disabled = true;
			
			var mobile_no = document.getElementById("CreateMobileNo").value;
			ResponseMsg('green','OTP successfully sent to this mobile number ('+mobile_no+').');
			
		}else{
			verCreBtnEle.disabled = false;
			otpEle.disabled=false;
			if(jQuery.parseJSON(response)){
				var jObj = jQuery.parseJSON(response);
			
				if(jObj.details[0].code!=null)
					ResponseMsg('red',jObj.details[0].code+":"+jObj.details[0].message);
			}else{
				ResponseMsg('red',response);
			}
		}
		
	} else if(errorCode=="F" && response!="null")  {
		verCreBtnEle.disabled = false;
		otpEle.disabled=false;
		if(jQuery.parseJSON(response)){
			var jObj = jQuery.parseJSON(response);
		
			if(jObj.details[0].code!=null)
				ResponseMsg('red',jObj.details[0].code+":"+jObj.details[0].message);
		}else{
			ResponseMsg('red',response);
		}
	}else{
		verCreBtnEle.disabled = false;
		otpEle.disabled=false;
		ResponseMsg('red','Unable to process response data, please check with your system administrator.');
	}
}

function cancel(){
	var returnVal = "";
		
		
		window.returnValue=returnVal;
	window.close();
}

function finish(option) {
	var isDebugYN = document.getElementById("isDebugYN").value;
	//var consent = document.getElementById("consent")").value;
	
	//if(consent){
		var responseData = document.getElementById("abhaInfo").value;
		var aadhaar_no = document.getElementById("AadhaarNo").value;
		var returnVal = responseData+"$!^"+aadhaar_no+"$!^"+option;
		
		if(isDebugYN=="true")
			alert("ReturnVal: "+returnVal);
		
		window.returnValue=returnVal;
	//}	
	window.close();
}

function otpValidation(evt) {
	var val = document.getElementById("Otp").value;
	if (val.length == 6) {
		document.getElementById("verCreateBtn").disabled = false;
	} else {
		document.getElementById("verCreateBtn").disabled = true;
	}
	
	var retVal = numberValidation(evt);
	
	return retVal;
}

function numberValidation(evt) {
	// Only ASCII character in that range allowed
	var ASCIICode = (evt.which) ? evt.which : evt.keyCode;
	if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
		return false;
	
	return true;
}

function timer(remaining,timerOn,reqOption) {
	  var m = Math.floor(remaining / 60);
	  var s = remaining;
	  
	  m = m < 10 ? '0' + m : m;
	  s = s < 10 ? '0' + s : s;
	  document.getElementById('timer').innerHTML = m + ':' + s;
	  remaining -= 1;
	  
	  if(remaining >= 0 && timerOn) {
	    setTimeout(function() {
	        timer(remaining,timerOn,reqOption);
	    }, 1000);
	    return;
	  }

	  if(!timerOn) {
	    // Do validate stuff here
	    //alert('validate stuff');
	    return;
	  }
	  
	  // Do timeout stuff here
	  document.getElementById('timer').innerHTML = "";
	  if(reqOption=="GENERATEOTP"){
		  document.getElementById("genOTPBtn").disabled = false;  
	  }else if(reqOption=="GENERATEMOBILEOTP"){		  
	  	  document.getElementById("genMobOTPBtn").disabled = false;
	  }
}

function ResponseMsg(color,resMsg){
	$("#footerResId").html("");
	$("#footerResId").append('<p id="resMsg" style="color: '+color+';">'+resMsg+'</p>');
}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<body>
<form name="linkHealthIDForm" id="linkHealthIDForm" method="post" >
	<div class="content">
		<table cellspacing=0 cellpadding=3>
			<tr>
				<td align="left">
					<input type="radio" id="searchRad" name="searchRad" id="searchRad" value="SEARCHABHA" onclick="SearchCreateEvent(this)" checked /><label for="searchRad">Search ABHA</label>
					<input type="radio" id="createRad" name="searchRad" id="searchRad" value="CREATEABHA" onclick="SearchCreateEvent(this)" /><label for="createRad">Create ABHA</label>
				</td>				
			</tr>
		</table>
		<div id="searchDiv" style="display: block;">		
			<table cellspacing=0 cellpadding=3>
				<tr>
					<td class='label'><fmt:message key="eXH.MobileNumber.label" bundle="${xh_labels}"/><img src='../../eCommon/images/mandatory.gif'></td>
					<td align="left"><input type="number" title="10 Digit mobile number Ex. 9840012345" id="SearchMobileNo" name="SearchMobileNo" id="SearchMobileNo" size=20 maxlength=10 value='<%= mobile_no %>' 
						onkeyup="return numberValidation(event)" onkeydown="return numberValidation(event)" onkeypress="return numberValidation(event)"></td>
					
					<td align="right" class='label'><fmt:message key="eXH.Name.label" bundle="${xh_labels}"/><img src='../../eCommon/images/mandatory.gif'></td>
					<td align="left"><input type="text" id="Name" name="Name" id="Name" size=20 value=''></td>
					
					<td class='label'><fmt:message key="eXH.BirthYear.label" bundle="${xh_labels}"/><img src='../../eCommon/images/mandatory.gif'></td>
					<td align="left"><input type="number" id="BirthYear" name="BirthYear" id="BirthYear" size=8 maxlength=4 value=''
						onkeyup="return numberValidation(event)" onkeydown="return numberValidation(event)" onkeypress="return numberValidation(event)"></td>
					
					<td class='label'><fmt:message key="eXH.Gender.label" bundle="${xh_labels}"/><img src='../../eCommon/images/mandatory.gif'></td>
					<td align="left">
						<select id="genSltId" name="gender" id="gender">
							<option selected disabled value="">Select Gender</option>
							<option value="M">Male</option>
							<option value="F">Female</option>
							<option value="U">Unknown</option>
						</select>
					</td>
					
					<td align="right"><input id="searchBtn" type="button" class="button" value="Search" onclick="search()"></td>
					<td align="right"><input id="resetBtn" type="button" class="button" value="Reset" onclick="SearchCreateEvent(this)"></td>
				</tr>
			</table>
		</div>
		
		<div id="createDiv" style="display: none;">
			<table cellspacing=0 cellpadding=3>
				<tr>
					<td class='label'><fmt:message key="eXH.MobileNumber.label" bundle="${xh_labels}"/><img src='../../eCommon/images/mandatory.gif'></td>
					<td align="left"><input type="number" title="10 Digit mobile number Ex. 9840012345" id="CreateMobileNo" name="CreateMobileNo" id="CreateMobileNo" size=20 maxlength=10 value='<%= mobile_no %>' 
						onkeyup="return numberValidation(event)" onkeydown="return numberValidation(event)" onkeypress="return numberValidation(event)"></td>
					
					<td class='label'><fmt:message key="eXH.AadhaarNumber.label" bundle="${xh_labels}"/><img src='../../eCommon/images/mandatory.gif'></td>
					<td align="left"><input type="text" title="12 Digit Aadhaar number Ex. 123456789012" id="AadhaarNo" name="AadhaarNo" id="AadhaarNo" size=20 maxlength=12 value='<%= aadhaar_no %>' 
						onkeyup="return numberValidation(event)" onkeydown="return numberValidation(event)" onkeypress="return numberValidation(event)"></td>					
					
					<td align="right"><input id="genOTPBtn" type="button" class="button" value="Generate OTP" onclick="generateOTP('GENERATEOTP')"></td>
					<td align="right"><input id="genMobOTPBtn" type="button" class="button" value="Generate Mobile OTP" onclick="generateOTP('GENERATEMOBILEOTP')" style="display: none;"></td>
					<td align="right"><input id="resetBtn" type="button" class="button" value="Reset" onclick="fieldsReset('CREATEABHA')"></td>					
				</tr>				
			</table>			
		</div>
		</br>
		<hr style="border-top: 1px solid #bbb">
		</br>
		<div id="abhaNumDiv" style="text-align: center;display: none;width: 100%;">
			<input id="abhaId" name="abhaId" id="abhaId" style="display: block;" value=""/>
		</div>
		<div id="otpDiv" style="text-align: center;display: none;width: 100%;">
			<table cellspacing=0 cellpadding=3>
				<tr>
					<td class='label' id="etrAotpLabel"><fmt:message key="eXH.EnterAadhaarOTP.label" bundle="${xh_labels}"/></td>
					<td class='label' id="etrMotpLabel" style="display: none;"><fmt:message key="eXH.EnterMobileOTP.label" bundle="${xh_labels}"/></td>
					<td align="right"><input type="number" id="Otp" name="Otp" id="Otp" size=10 maxlength=6 value='' 
						onkeydown="return otpValidation(event)" onkeyup="return otpValidation(event)" onkeypress="return otpValidation(event)"></td>
				</tr>
			</table>
			<p id="timer" style="color:blue;"></p>
		</div>
		</br></br>
		<table id='abhaIdInfoTable' border=1 cellspacing=0 cellpadding=3 align="center" width="95%"></table>		
	</div>
	<div id="footer">
		<div id="footerResId" style="padding-left: 10px;float: left;text-align: left;"><p id="resMsg"></p></div>
		<div id="searchFooter" style="width:40%;padding-right: 10px;">		
			<input type="button" class="button" value="Cancel" onclick="cancel()">	
			<input id="searchOkBtn" type="button" class="button okBtn" value="OK" onclick="finish('SEARCH')" disabled>
		</div>
		<div id="createFooter" style="width:60%;display: none;padding-right: 10px;">
			<input type="button" class="button" value="Cancel" onclick="cancel()">
			<input id="verCreateBtn" type="button" class="button" value="Verify OTP / Create ABHA" onclick="verifyOtpOrCreateAbha()">
			<input id="createOkBtn" type="button" class="button okBtn" value="OK" onclick="finish('CREATE')" disabled>
		</div>
	</div>

	<input type="hidden" id="isDebugYN" name="isDebugYN" id="isDebugYN" value="<%=isDebugYN%>"> 
	<input type="hidden" id="txnId" name="txnId" id="txnId" value=""> 
	<input type="hidden" id="patient_id" name="patient_id" id="patient_id" value="<%=patient_id%>"> 
	<input type="hidden" id="facility_id" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<input type="hidden" id="logged_in_user" name="logged_in_user" id="logged_in_user" value="<%=logged_in_user%>"> 
	<input type="hidden" id="logged_in_ws_no" name="logged_in_ws_no" id="logged_in_ws_no" value="<%=logged_in_ws_no%>"> 
	<input type="hidden" id="session_id" name="session_id" id="session_id" value="<%=session_id%>"> 
	<input type="hidden" id="abhaInfo" name="abhaInfo" id="abhaInfo" value="">
	<input type="hidden" id="timerOn" name="timerOn" id="timerOn" value=<%= timerOn %>>
	<input type="hidden" id="waitTime" name="waitTime" id="waitTime" value=<%= waitTime %>>
	<input type="hidden" id="VerifyReqOption" name="VerifyReqOption" id="VerifyReqOption" value="">
</form>
</body>
<%!
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
</html>

