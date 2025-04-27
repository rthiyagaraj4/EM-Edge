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
	boolean timerOn = true;
	String waitTime = "30";
	
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
	
	String mobile_no = checkForNull(request.getParameter("mobile_no"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String logged_in_user = checkForNull(request.getParameter("logged_in_user"));
	String logged_in_ws_no = checkForNull(request.getParameter("logged_in_ws_no"));
	String session_id = checkForNull(request.getParameter("session_id"));
%>
<title>Update / Download ABHA Card</title>
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
}
</style>
<script type="text/javascript">

function formRequestData(request_type,request_option){
	
	var patient_id = document.getElementById("patient_id").value;
	var facility_id = document.getElementById("facility_id").value;
	var logged_in_user = document.getElementById("logged_in_user").value;
	var logged_in_ws_no = document.getElementById("logged_in_ws_no").value;
	var session_id = document.getElementById("session_id").value;
	
	return "<REQUEST_TYPE>"+request_type+"$!^<REQUEST_OPTION>"+request_option+"$!^<PATIENT_ID>"+patient_id+"$!^<FACILITY_ID>"+facility_id+"$!^<LOGGED_IN_USER_ID>"+logged_in_user+"$!^<LOGGED_IN_WSNO>"+logged_in_ws_no+"$!^<SESSION>"+session_id+"$!^";
}

function otpValidation(evt) {
	var val = document.getElementById("Otp").value;
	if (val.length == 6) {
		document.getElementById("verifyOTP").disabled = false;
	} else {
		document.getElementById("verifyOTP").disabled = true;
	}
	
	var retVal = numberValidation(evt);
	
	return retVal;
}

function mobileOtpValidation(evt) {
	var val = document.getElementById("MobileOtp").value;
	if (val.length == 6) {
		document.getElementById("VerMobOtpBtn").disabled = false;
	} else {
		document.getElementById("VerMobOtpBtn").disabled = true;
	}
	
	var retVal = numberValidation(evt);
	
	return retVal;
}

function emailOtpValidation(evt) {
	var val = document.getElementById("EmailOtp").value;
	if (val.length == 6) {
		document.getElementById("VerEmlOtpBtn").disabled = false;
	} else {
		document.getElementById("VerEmlOtpBtn").disabled = true;
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

function reset(){
	document.forms[0].reset();
}

function ResponseMsg(color,resMsg){
	$("#footerResId").html("");
	$("#footerResId").append('<p id="resMsg" style="color: '+color+';">'+resMsg+'</p>');
}

function generateOTP(){
	
	var isDebugYN = document.getElementById("isDebugYN").value;
	var mobileEle = document.getElementById("MobileNo");
	
	var otpEle = document.getElementById("Otp");
	var mobile_no = mobileEle.value;
	
	if(isDebugYN=="true") 
		alert('Generate OTP... mobile_no:'+mobile_no);
	
	if(mobile_no!=null && mobile_no!=""){
		mobileEle.disabled=true;
		document.getElementById("genOTPBtn").disabled=true;
		
		var request_type="";
		var strMode = getMode();
		if(strMode=="UPDATEABHA"){
			request_type="UPDATEABHAID";
		}else{
			request_type="DOWNLOADABHAID";
		}
		var option = "SENDLOGINOTP";		
		var request_option=option;
		
		var request_data = formRequestData(request_type,request_option);
		request_data = request_data+"<MOBILE_NO>"+mobile_no;
		
		if(isDebugYN=="true")
			alert("requestData: "+request_data);
		
		//var responseMsg = '{"txnId":"0a67db9b-af9c-4c63-9774-3947f475053c"}$!^S$!^SUCCESS';//
		var responseMsg = callABDM(request_type,request_option,request_data);
			
		if(isDebugYN=="true")
			alert('responseMsg: '+responseMsg);
		
		var resArray = responseMsg.split("$!^");
		var response = resArray[0];
		var errorCode = resArray[1];
		var errorMsg = resArray[2];
		
		 if(errorCode=="S" && response!="null"){ 
			var jsonResponse = jQuery.parseJSON(response);
			document.getElementById("txnId").value = jsonResponse.txnId;
			otpEle.disabled = false;
		
			ResponseMsg('green','OTP successfully sent to the mobile number!');
		} else if(errorCode=="F" && response!="null"){
			mobileEle.disabled=false;
			document.getElementById("genOTPBtn").disabled=false;
			otpEle.disabled = true;
			
			if(jQuery.parseJSON(response)){
				var jObj = jQuery.parseJSON(response);
			
				if(jObj.details[0].code!=null){
					var resmsg = jObj.details[0].code+":"+jObj.details[0].message;
					ResponseMsg('red',resmsg);
					
					if(jObj.details[0].code=="HIS-1023"){
						mobileEle.disabled=true;
						document.getElementById("genOTPBtn").disabled=true;
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
			document.getElementById("genOTPBtn").disabled=false;
			otpEle.disabled = true;
			
			ResponseMsg('red','Unable to process response data, please check with your system administrator.');
		}
	}else {
		ResponseMsg('red','Enter mobile number.');
	}
}

function verifyMobileOTP(){
	
	var isDebugYN = document.getElementById("isDebugYN").value;
	
	var otpEle = document.getElementById("Otp");
	var otp = otpEle.value;
	var txnId = document.getElementById("txnId").value;
	
	document.getElementById("verifyOTP").disabled = true;
	otpEle.disabled=true;
	
	if(isDebugYN=="true")
		alert('Update ABHA... otp:'+otp+' txnId:'+txnId);
	
	var request_type="";
	var strMode = getMode();
	if(strMode=="UPDATEABHA"){
		request_type="UPDATEABHAID";
	}else{
		request_type="DOWNLOADABHAID";
	}
	var request_option="VERIFYLOGINOTP";
	
	var request_data = formRequestData(request_type,request_option);
	request_data = request_data+"<OTP>"+otp+"$!^<TXN_ID>"+txnId;
	
	if(isDebugYN=="true")
		alert("requestData: "+request_data);
	
	//var responseMsg = '{"txnId":"0a67db9b-af9c-4c63-9774-3947f475053c","token":"eyJhbGciOiJSUzUxMiJ9.eyJzdWIiOiI5Njc3MTEyMDAxIiwiY2xpZW50SWQiOiJTQlhfMDAwMTU0Iiwic3lzdGVtIjoiQUJIQS1OIiwiZXhwIjoxNjkzMjI2MDY1LCJpYXQiOjE2OTMyMjQyNjUsInR4bklkIjoiMGE2N2RiOWItYWY5Yy00YzYzLTk3NzQtMzk0N2Y0NzUwNTNjIn0.KHQO5TzJOeR1oeHdalwLlfYz514XhZQKeGYoiFTtVt2pW371PHfQZ_1HAbCkEgp9QmcaJGITPJCscnk0vJVO6pJBJ4nrp0NwQ76B8kjBvi6JngS2vD5u5WwkakMkxeshUdq3u2vo9ugSeLGt0OUVfx3C6ze88O-10uiFwS3kCgBgYGNsgqqAkuIccd0O_Q0GxYgkX9v3Ji3zpg9rkS_v2fu5KQEfEpZmv0kp-IupJctghF1KUL3TpmJtX82znJvnLAdjRbRleQUu7Kriuz0v9bGX5oTNyu6atLtYjGevNLE505epam-FnsalqLYQeU5lmhqJg1vSMewywPavIDezsVE4tp5EP8WpYwi3tOJus8kkE4QPWNq2e_3Od4vIA9-DXqW14k2z8gsqnbgFWVX8-ma2FqxgcXWlpDZVWZT267QDkB7wm7gj1yiYYiV2cAop1qPbuap-MnBDHdT5sDv9gSyyDHz6NAzMNYedLLq08rjNmHdAZX-RO1ohfe2S2t5T_AQL8SAH70D9HKxZloAG4ysHkcK7glT2BQcrCAhQcu8CugfTWV_gxevERVnJccWgjjWcaEe-6TCSu6xjmsdPDyqPYE5qat3hGC-D_KV8Zb6jWnollOQJiSWOy0NwfCCJ-0mfC286HMP2RG8JMdDXpoVhj7sdjdqiwHzTMBX9-dg","mobileLinkedHid":[{"healthIdNumber":"91-3670-8272-5162","healthId":"guruhealth1806@sbx","name":"Padidam Thirupathi Rao","profilePhoto":null,"phrAddress":null},{"healthIdNumber":"91-2757-5352-6811","healthId":"91275753526811@sbx","name":"K Vignesh","profilePhoto":null,"phrAddress":null}]}$!^S$!^SUCCESS';//callABDM(request_type,request_option,request_data);
	//var responseMsg = '{"token": "trdqwytq-qwewqe-qweqwe-eqwwaedwq"}$!^S$!^SUCCESS';
	var responseMsg = callABDM(request_type,request_option,request_data);
	
	if(isDebugYN=="true")
		alert('responseMsg: '+responseMsg);
	
	var resArray = responseMsg.split("$!^");
	var response = resArray[0];
	var errorCode = resArray[1];
	var errorMsg = resArray[2];
	
	$("#SearchAbhaDtlTbl").html("");
	 if(errorCode=="S" && response!="null"){ 
		
		var jObj = jQuery.parseJSON(response);
		
		if(jObj.mobileLinkedHid!=null){
			document.getElementById("txnId").value = jObj.txnId;
			document.getElementById("T_token").value = jObj.token;
			
			var mobileLinkedHid = jObj.mobileLinkedHid;
			var tableData =mobileLinkedHid;//
			
			document.getElementById("SearchAbhaDtlTbl").style.display = 'block';
			$("#SearchAbhaDtlTbl").append('<tr id="headerRow"></tr>');
			
			if(request_type=="UPDATEABHAID")
				$("#headerRow").append('<th></th>');
			
			$("#headerRow").append('<th>HealthId Number</th>');
			$("#headerRow").append('<th>HealthId</th>');
			$("#headerRow").append('<th>Name</th>');
			
			if(request_type=="DOWNLOADABHAID")
				$("#headerRow").append('<th>Download</th>');

			$.each(tableData, function(a, b) {
				$("#SearchAbhaDtlTbl").append('<tr id="' + a + '"></tr>');
				var dataRowId = '#' + a;
				
				if(request_type=="UPDATEABHAID")
					$(dataRowId).append('<td><input id="abha'+a+'Id" name="selectAbha" id="selectAbha" type="radio" onclick="selectAbhaDtl(this)" value="'+b.healthIdNumber+'"></td>');
				
				$(dataRowId).append('<td>' + b.healthIdNumber + '</td>');
				
				if(b.healthId==""){
					$(dataRowId).append('<td>Not Available</td>');
				}else{
					$(dataRowId).append('<td>' + b.healthId + '</td>');
				}
				$(dataRowId).append('<td>' + b.name + '</td>');
				
				if(request_type=="DOWNLOADABHAID")
					$(dataRowId).append('<td><a href="#" onclick="onclickDownload(\''+b.healthIdNumber+'\')">Download</a></td>');
				
			});
			
			document.getElementById("eOtpLbl").style.display = 'none';
			document.getElementById("verifyOTP").style.display = 'none';
			otpEle.style.display = 'none';
			ResponseMsg('green','OTP verified successfully!');
		}
		else if(jObj.token!=null){			
			document.getElementById("X_token").value = jObj.token;
			
			document.getElementById("eOtpLbl").style.display = 'none';
			document.getElementById("verifyOTP").style.display = 'none';
			otpEle.style.display = 'none';
			
			ResponseMsg('green','OTP verified successfully!');
			
			if(request_type=="UPDATEABHAID"){
				document.getElementById("VerifyTbl").style.display = 'block';
			}else{
				downloadAbha();
			}
			
		}else{
			document.getElementById("verifyOTP").disable=false;
			otpEle.disabled=false;
			
			ResponseMsg('red','Unable to process response data, please check with your system administrator.');
		}	
		
	}else if(errorCode=="F" && response!="null") {
		document.getElementById("verifyOTP").disable=false;
		otpEle.disabled=false;
		
		if(jQuery.parseJSON(response)){
			var jObj = jQuery.parseJSON(response);
		
			if(jObj.details[0].code!=null)
				ResponseMsg('red',jObj.details[0].code+":"+jObj.details[0].message);
		}else{
			ResponseMsg('red',response);
		}
	}else{	
		document.getElementById("verifyOTP").disable=false;
		otpEle.disabled=false;
		
		ResponseMsg('red','Unable to process response data, please check with your system administrator.');
	}
}

function selectAbhaDtl(data){
	document.getElementById("healthIdNumber").value = data.value;
	genProfileToken();
}

function onclickDownload(healthIdNumber){
	document.getElementById("healthIdNumber").value = healthIdNumber;
	genProfileToken();
}

function genProfileToken(){
	
	var isDebugYN = document.getElementById("isDebugYN").value;
	
	var txnId = document.getElementById("txnId").value;
	var token = document.getElementById("T_token").value;
	var healthIdNumber = document.getElementById("healthIdNumber").value;
	
	if(isDebugYN=="true")
		alert('Generate Profile Token... txnId:'+txnId+' token:'+token+' healthIdNumber:'+healthIdNumber);
	
	var mobileEle = document.getElementById("NewMobileNo");
	mobileEle.value="";
	mobileEle.disabled=false;
	var emailEle = document.getElementById("NewEmailId");
	emailEle.value="";
	emailEle.disabled=false;
	var MobOtpEle = document.getElementById("MobileOtp");
	MobOtpEle.value="";
	MobOtpEle.disabled=true;
	var EmlOtpEle = document.getElementById("EmailOtp");
	EmlOtpEle.value="";
	EmlOtpEle.disabled=true;
	document.getElementById("GenMobOtpBtn").disabled=false;
	document.getElementById("GenEmlOtpBtn").disabled=false;
	document.getElementById("VerifyTbl").style.display = 'none';
	document.getElementById("resMsg").innerHTML = "";
	
	var request_type="";
	var strMode = getMode();
	if(strMode=="UPDATEABHA"){
		request_type="UPDATEABHAID";
	}else{
		request_type="DOWNLOADABHAID";
	}
	var request_option="GENERATEPROFILETOKEN";
	var request_data = formRequestData(request_type,request_option);
	request_data = request_data+"<TXN_ID>"+txnId+"$!^<TOKEN>"+token+"$!^<HEALTHIDNUMBER>"+healthIdNumber;
	
	if(isDebugYN=="true")
		alert("requestData: "+request_data);
	
	//var responseMsg = '{"token":"asfdag-asdadhja-asdasd"}$!^S$!^SUCCESS';//callABDM(request_type,request_option,request_data);
	var responseMsg = callABDM(request_type,request_option,request_data);
	
	if(isDebugYN=="true")
		alert('responseMsg: '+responseMsg);
	
	var resArray = responseMsg.split("$!^");
	var response = resArray[0];
	var errorCode = resArray[1];
	var errorMsg = resArray[2];
	
	 if(errorCode=="S" && response!="null"){ 
		var jObj = jQuery.parseJSON(response);
		
		document.getElementById("X_token").value = jObj.token;		
		ResponseMsg('green','Profile token generated successfully for healthId number ('+healthIdNumber+')');
		
		if(request_type=="DOWNLOADABHAID"){
			downloadAbha();
		}else{
			document.getElementById("VerifyTbl").style.display = 'block';
		}
		
	}else if(errorCode=="F" && response!="null") {
		if(jQuery.parseJSON(response)){
			var jObj = jQuery.parseJSON(response);
		
			if(jObj.details[0].code!=null)
				ResponseMsg('red',jObj.details[0].code+":"+jObj.details[0].message);
		}else{
			ResponseMsg('red',response);
		}
	}else{
		ResponseMsg('red','Unable to process response data, please check with your system administrator.');
	}
}

function generateUpdateOTP(option){
	
	var isDebugYN = document.getElementById("isDebugYN").value;
	var mobileEle = document.getElementById("NewMobileNo");
	var emailEle = document.getElementById("NewEmailId");
	
	var MobOtpEle = document.getElementById("MobileOtp");
	var EmlOtpEle = document.getElementById("EmailOtp");
	var mobile_no = mobileEle.value;
	var email_id = emailEle.value;
	
	var token = document.getElementById("X_token").value;
	
	
	
	//if(mobile_no!=null && mobile_no!==""){
		var request_type="UPDATEABHAID";
		var request_option=option;
		var request_data = formRequestData(request_type,request_option);
		
		if(option=="UPDATEMOBILEINIT"){	
			if(isDebugYN=="true")
				alert('Generate OTP... mobile_no:'+mobile_no);
			
			request_data = request_data+"<TOKEN>"+token+"$!^<MOBILE_NO>"+mobile_no;
		}else{
			if(isDebugYN=="true")
				alert('Generate OTP... email_id:'+email_id);
			
			request_data = request_data+"<TOKEN>"+token+"$!^<EMAIL>"+email_id;
		}
		
		if(isDebugYN=="true")
			alert("requestData: "+request_data);
		
		//var responseMsg = '{"txnId":"0a67db9b-af9c-4c63-9774-3947f475053c"}$!^S$!^SUCCESS';//callABDM(request_type,request_option,request_data);
		var responseMsg = callABDM(request_type,request_option,request_data);
		
		if(isDebugYN=="true")
			alert('responseMsg: '+responseMsg);
		
		var resArray = responseMsg.split("$!^");
		var response = resArray[0];
		var errorCode = resArray[1];
		var errorMsg = resArray[2];
		
		 if(errorCode=="S" && response!="null"){ 
			var jsonResponse = jQuery.parseJSON(response);
			document.getElementById("U_txnId").value = jsonResponse.txnId;
			
			if(option=="UPDATEMOBILEINIT"){	
				MobOtpEle.disabled = false;
				mobileEle.disabled = true;
				document.getElementById("GenMobOtpBtn").disabled=true;
				ResponseMsg('green','OTP successfully sent to the mobile number!');
			}else{
				EmlOtpEle.disabled = false;
				emailEle.disabled = true;
				document.getElementById("GenEmlOtpBtn").disabled=true;
				ResponseMsg('green','OTP successfully sent to the emailId!');
			}
			
		} else if(errorCode=="F" && response!="null"){
			if(jQuery.parseJSON(response)){
				var jObj = jQuery.parseJSON(response);
			
				if(jObj.details[0].code!=null){
					var resmsg = jObj.details[0].code+":"+jObj.details[0].message;
					ResponseMsg('red',resmsg);
				}
			}else{
				ResponseMsg('red',response);
			}
		}else{
			ResponseMsg('red','Unable to process response data, please check with your system administrator.');
		}
	/*}else {
		ResponseMsg('red','Enter mobile number.');
	}*/
}

function verifyUpdate(option){
	var isDebugYN = document.getElementById("isDebugYN").value;
	
	var txnId = document.getElementById("U_txnId").value;
	var token = document.getElementById("X_token").value;
	var MobOtpEle = document.getElementById("MobileOtp");
	var EmlOtpEle = document.getElementById("EmailOtp");
	
	var otp="";
	if(option=="CHANGEMOBILENUMBER"){
		otp = MobOtpEle.value;
	}else{
		otp = EmlOtpEle.value;
	}

	if(isDebugYN=="true")
		alert('verifyUpdateMobile... txnId:'+txnId+' token:'+token+' otp:'+otp);
	
	var request_type="UPDATEABHAID";
	var request_option=option;
	var request_data = formRequestData(request_type,request_option);
	request_data = request_data+"<TXN_ID>"+txnId+"$!^<TOKEN>"+token+"$!^<OTP>"+otp;
	
	
	if(isDebugYN=="true")
		alert("requestData: "+request_data);
	
	//var responseMsg = '{"txnId":"0a67db9b-af9c-4c63-9774-3947f475053c"}$!^S$!^SUCCESS';//callABDM(request_type,request_option,request_data);
	var responseMsg = callABDM(request_type,request_option,request_data);
	
	if(isDebugYN=="true")
		alert('responseMsg: '+responseMsg);
	
	var resArray = responseMsg.split("$!^");
	var response = resArray[0];
	var errorCode = resArray[1];
	var errorMsg = resArray[2];
	
	 if(errorCode=="S" && response!="null"){ 
		//var jsonResponse = jQuery.parseJSON(response);
		//document.getElementById("txnId").value = jsonResponse.txnId;
		var mobileEle = document.getElementById("NewMobileNo");
		var emailEle = document.getElementById("NewEmailId");
		if(option=="CHANGEMOBILENUMBER"){
			MobOtpEle.disabled = true;
			document.getElementById("VerMobOtpBtn").disabled=true;
			document.getElementById("UpdatedMobile").value = mobileEle.value;
			ResponseMsg('green','Mobile number updated successfully!');
		}else{
			EmlOtpEle.disabled = true;
			document.getElementById("VerEmlOtpBtn").disabled=true;
			document.getElementById("UpdatedEmail").value = emailEle.value;
			ResponseMsg('green','Email updated successfully!');
		}
		document.getElementById("okBtn").disabled=false;
		
	} else if(errorCode=="F" && response!="null"){
		if(jQuery.parseJSON(response)){
			var jObj = jQuery.parseJSON(response);
		
			if(jObj.details[0].code!=null){
				var resmsg = jObj.details[0].code+":"+jObj.details[0].message;
				ResponseMsg('red',resmsg);
			}
		}else{
			ResponseMsg('red',response);
		}
	}else{
		ResponseMsg('red','Unable to process response data, please check with your system administrator.');
	}
}

function downloadAbha(){
	
	var isDebugYN = document.getElementById("isDebugYN").value;
	var token = document.getElementById("X_token").value;
	
	if(isDebugYN=="true")
		alert('Download.... token:'+token);
	
	var request_type="DOWNLOADABHAID";
	var request_option="DOWNLOADABHACARD";
	var request_data = formRequestData(request_type,request_option);
	request_data = request_data+"<TOKEN>"+token;
	
	if(isDebugYN=="true")
		alert("requestData: "+request_data);
	
	//var responseMsg = '{"image":"asfdag-asdadhja-asdasd","patient_id":"123412653"}$!^S$!^SUCCESS';
	var responseMsg = callABDM(request_type,request_option,request_data);
	
	if(isDebugYN=="true")
		alert('responseMsg: '+responseMsg);
	
	var resArray = responseMsg.split("$!^");
	var response = resArray[0];
	var errorCode = resArray[1];
	var errorMsg = resArray[2];
	
	if(errorCode=="S"){
		var jObj = jQuery.parseJSON(response);
		
		document.getElementById("X_token").value = jObj.token;
		ResponseMsg('green','Downloaded successfully!');
		document.getElementById("okBtn").disabled=false;
		
	}else if(errorCode=="F") {
		if(jQuery.parseJSON(response)){
			var jObj = jQuery.parseJSON(response);
		
			if(jObj.details[0].code!=null)
				ResponseMsg('red',jObj.details[0].code+":"+jObj.details[0].message);
		}else{
			ResponseMsg('red',response);
		}
	}else{
		ResponseMsg('red','Unable to process response data, please check with your system administrator.');
	}
	
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
	  }else if(reqOption=="SENDLOGINOTP"){
		  document.getElementById("MobileNo").disabled=false;
		  document.getElementById("genOTPBtn").disabled=false;
	  }
}

function getMode(){
	var strMode = "";
	var serEle = document.getElementsByName("updwRad");
    for (i=0; i < serEle.length; i++) {
        if (serEle[i].checked)
        	strMode =  serEle[i].value;
    }
    return strMode;
}

function filedReset(){
	
	var strMode = getMode();
	
	document.forms[0].reset();
	
	if(strMode=="UPDATEABHA"){	
		document.getElementById("updateRad").checked=true;
	}else{
		document.getElementById("downloadRad").checked=true;
	}
	document.getElementById("MobileNo").disabled=false;
	document.getElementById("genOTPBtn").disabled=false;
	document.getElementById("eOtpLbl").style.display = 'block';
	document.getElementById("verifyOTP").style.display = 'block';
	var otpEle=document.getElementById("Otp");
	otpEle.style.display = 'block';
	otpEle.disabled=true;
	$("#SearchAbhaDtlTbl").html("");
	document.getElementById("SearchAbhaDtlTbl").style.display = 'none';
	document.getElementById("NewMobileNo").disabled=false;
	document.getElementById("NewEmailId").disabled=false;
	document.getElementById("GenMobOtpBtn").disabled=false;
	document.getElementById("GenEmlOtpBtn").disabled=false;
	document.getElementById("VerifyTbl").style.display = 'none';
	document.getElementById("okBtn").disabled=true;
	document.getElementById("resMsg").innerHTML = "";
}

function cancel(){
	window.close();
}

function finish() {
	
	var strMode = getMode();
	var strRes = strMode;
	if(strMode=="UPDATEABHA"){	
		var mobile = document.getElementById("UpdatedMobile").value;
		var email = document.getElementById("UpdatedEmail").value;
		strRes = strRes+"$!^"+mobile+"$!^"+email
	}
	window.returnValue = strRes;
	window.close();
}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<body>
<form name="UpdateABHADetailsForm" id="UpdateABHADetailsForm" method="post" >
	<div class="content">
		<table cellspacing=0 cellpadding=3>
			<tr>
				<td align="left">
					<input type="radio" id="updateRad" name="updwRad" id="updwRad" value="UPDATEABHA" onclick="filedReset()" checked /><label for="updateRad">Update ABHA</label>
					<input type="radio" id="downloadRad" name="updwRad" id="updwRad" value="DOWNLOADABHA" onclick="filedReset()" /><label for="dowloadRad">Download ABHA</label>
				</td>				
			</tr>
		</table>
		<table cellspacing=0 cellpadding=3 >
			<tr>
				<td align="left">
					<td class='label'><fmt:message key="eXH.MobileNumber.label" bundle="${xh_labels}"/><img src='../../eCommon/images/mandatory.gif'></td>
					<td align="left"><input type="number" title="10 Digit mobile number Ex. 9840012345" id="MobileNo" name="MobileNo" id="MobileNo" size=20 maxlength=10  
						onkeyup="return numberValidation(event)" onkeydown="return numberValidation(event)" onkeypress="return numberValidation(event)"></td>
				</td>
				<td align="left"><input id="genOTPBtn" type="button" class="button" value="Generate OTP" onclick="generateOTP()"></td>
				
				<td class='label' id="eOtpLbl"><fmt:message key="eXH.EnterOTP.label" bundle="${xh_labels}"/></td>
				<td align="left"><input type="number" id="Otp" name="Otp" id="Otp" size=10 maxlength=6 value='' disabled 
				onkeyup="return otpValidation(event)" onkeydown="return otpValidation(event)" onkeypress="return otpValidation(event)"></td>
				<td align="left"><input type="button" class="button" id="verifyOTP" value="Verify OTP" onclick="verifyMobileOTP()" disabled></td>
				<td align="left"><input type="button" class="button" id="resetBtn" value="Reset" onclick="filedReset()"></td>
			</tr>
		</table>
		</br>
		<hr style="border-top: 1px solid #bbb">
		</br>
		<div style="width: 100%;text-align: center;">
			<p id="timer" style="color:blue;"></p>
		</div>
		<table id="SearchAbhaDtlTbl" border=1 cellspacing=0 cellpadding=3 width='98%' align="center" style="display: none;"></table>
		</br>
		<div style="padding: 10px;">
			<table id="VerifyTbl" cellspacing=0 cellpadding=0 width="100%" style="display: none;">
				<tr>
					<td>
						<table id="GenMobileOtpTbl" width="100%" cellspacing=0 cellpadding=3>
							<tr>
								<td class='label' width="25%"><fmt:message key="eXH.MobileNumber.label" bundle="${xh_labels}"/></td>
								<td align="left" width="55%"><input type="number" title="10 Digit mobile number Ex. 9840012345" id="NewMobileNo" name="NewMobileNo" id="NewMobileNo" style="width:98%" maxlength=10  
									onkeyup="return numberValidation(event)" onkeydown="return numberValidation(event)" onkeypress="return numberValidation(event)"></td>	
								<td align="right" width="20%"><input type="button" id="GenMobOtpBtn" class="button" value="Generate OTP" onclick="generateUpdateOTP('UPDATEMOBILEINIT')" </td>
							</tr>
						</table>
					</td>
					<td>
						<table id="GenEmailOtpTbl" width="100%" cellspacing=0 cellpadding=3>
							<tr>
								<td class='label' width="25%"><fmt:message key="eXH.EmailId.label" bundle="${xh_labels}"/></td>
								<td align="right" width="55%"><input type="text" id="NewEmailId" name="NewEmailId" id="NewEmailId" style="width:98%" value='' ></td>
								<td align="right" width="20%"><input type="button" id="GenEmlOtpBtn" class="button" value="Generate OTP" onclick="generateUpdateOTP('UPDATEEMAILINIT')" ></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table id="VerMobileOtpTbl" width="100%" cellspacing=0 cellpadding=3>
							<tr>
								<td class='label' width="25%"><fmt:message key="eXH.EnterOTP.label" bundle="${xh_labels}"/></td>
								<td align="right" width="20%"><input type="number" id="MobileOtp" name="MobileOtp" id="MobileOtp" maxlength=6 value='' disabled 
								onkeyup="return mobileOtpValidation(event)" onkeydown="return mobileOtpValidation(event)" onkeypress="return mobileOtpValidation(event)"></td>
								<td align="right" width="55%"><input type="button" id="VerMobOtpBtn" class="button" value="Verify OTP / Update Mobile" onclick="verifyUpdate('CHANGEMOBILENUMBER')" disabled></td>
							</tr>
						</table>
					</td>
					<td>
						<table id="VerEmailOtpTbl" width="100%" cellspacing=0 cellpadding=3>
							<tr>
								<td class='label' width="25%"><fmt:message key="eXH.EnterOTP.label" bundle="${xh_labels}"/></td>
								<td align="right" width="20%"><input type="number" id="EmailOtp" name="EmailOtp" id="EmailOtp" maxlength=6 value='' disabled 
								onkeyup="return emailOtpValidation(event)" onkeydown="return emailOtpValidation(event)" onkeypress="return emailOtpValidation(event)"></td>
								<td align="right" width="55%"><input type="button" id="VerEmlOtpBtn" class="button" value="Verify OTP / Update Email" onclick="verifyUpdate('CHANGEEMAIL')" disabled></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div id="footer">
		<div id="footerResId" style="padding-left: 10px;float: left;text-align: left;"><p id="resMsg"></p></div>
		<div style="padding-right: 10px;">
			<!-- <input type="button" class="button" value="Cancel" onclick="cancel()"> -->
			<input id="OkBtn" type="button" class="button okBtn" value="OK" onclick="finish()" disabled >
		</div>
	</div>
	
	<input type="hidden" id="isDebugYN" name="isDebugYN" id="isDebugYN" value="<%=isDebugYN%>"> 
	<input type="hidden" id="patient_id" name="patient_id" id="patient_id" value="<%=patient_id%>"> 
	<input type="hidden" id="facility_id" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<input type="hidden" id="logged_in_user" name="logged_in_user" id="logged_in_user" value="<%=logged_in_user%>"> 
	<input type="hidden" id="logged_in_ws_no" name="logged_in_ws_no" id="logged_in_ws_no" value="<%=logged_in_ws_no%>"> 
	<input type="hidden" id="session_id" name="session_id" id="session_id" value="<%=session_id%>">
	<input type="hidden" id="txnId" name="txnId" id="txnId" value="">
	<input type="hidden" id="U_txnId" name="U_txnId" id="U_txnId" value=""> 
	<input type="hidden" id="X_token" name="X_token" id="X_token" value=""> 
	<input type="hidden" id="T_token" name="T_token" id="T_token" value=""> 
	<input type="hidden" id="timerOn" name="timerOn" id="timerOn" value=<%= timerOn %>>
	<input type="hidden" id="waitTime" name="waitTime" id="waitTime" value=<%= waitTime %>>
	<input type="hidden" id="healthIdNumber" name="healthIdNumber" id="healthIdNumber" value=""> 
	<input type="hidden" id="UpdatedMobile" name="UpdatedMobile" id="UpdatedMobile" value=""> 
	<input type="hidden" id="UpdatedEmail" name="UpdatedEmail" id="UpdatedEmail" value=""> 
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

