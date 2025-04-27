function trim(myString) {
	return myString.replace(/^\s+|\s+$/g, '');
}

function submit_user_pwd() {
	xmlStr = "<root><SEARCH ";
	xmlStr += " name=\"" + document.forms[0].name.value + "\"";
	xmlStr += " password=\"" + document.forms[0].password.value + "\"";
	xmlStr += " level=\"" + document.forms[0].level.value + "\"";
	xmlStr += " mode=\"" + document.forms[0].mode.value + "\"";
	xmlStr += " compname=\"" + document.forms[0].compname.value + "\"";
	xmlStr += " domain=\"" + document.forms[0].domain.value + "\"";
	xmlStr += " ext_user_yn=\"Y\"";
	xmlStr += " /></root>";
	var xmlDoc;
	var xmlHttp;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttp = new XMLHttpRequest();
		var oParser = new DOMParser();
		xmlDoc = oParser.parseFromString(xmlStr,"text/xml");
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlDoc = new ActiveXObject("Microsoft.XMLDom");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	}
	xmlHttp.open("POST", contextPath+"/servlet/eSM.LoginResponseServlet", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText ;
	var rText = "";
	rText = responseText;
	if (rText != null)
		rText = rText.replace(/^\s+|\s+$/g, '')
	if (rText != null && rText != "home.jsp") {
		var result = rText.split("||");
		var result0 = result[0];
		var result1 = result[1];
		var result2 = result[2];
		if (result0 == "error_num=1") {
			var result1plt = result2.split("=");
			alert(result1plt[1]);
		}else {
			var colval = result2.split("==");
			var respval = colval[0].split("$$");
			var respcount = respval[0];
			var respCode_desc = respval[1];
			var classvalue;
			var facresult = colval[1];
			var facilityval = facresult.split("$$");
			var facCount = facilityval[0];
			var facCode_desc = facilityval[1];
			var blogin = false;
			if( respcount == "0" || facCount == "0" ){
				alert("You do not have sufficient rights to Login");
			}
			else if (respcount == "1" && facCount == "1") { // checks whether the
				var responsibilities = respCode_desc.split("~");
				var facilities = facCode_desc.split("~");
				var respID = responsibilities[0];
				var respName = responsibilities[1];
				var facID = facilities[0];
				var facName = facilities[1];
				document.getElementById("responsibility_id").value = respID;
				document.getElementById("responsibility_name").value = respName;
				document.getElementById("facility_id").value = facID;
				document.getElementById("facility_name").value = facName;							
				var loginformObj = document.getElementById("login_form");							
				if (loginformObj) {
					loginformObj.action = contextPath+"/ialogin";
					loginformObj.submit();
				}
			} 
			else 
			{ // IF there are morethan one responsibilityID
				var RespFaciHdnObj = document.getElementById("RespFaciList");
				var loginformObj = document.getElementById("login_form");
				if (RespFaciHdnObj) {
					RespFaciHdnObj.value = result2;
				}
				if (loginformObj) {
					loginformObj.action = contextPath+"/ialogin";
					loginformObj.submit();
				}
			}
		}
	}	
}

function getResultForTab(){
	frmObj=document.formClaimFormsCriteria;
	var patient_id=frmObj.Patient_Id.value;
	patient_id = patient_id.toUpperCase();
	var encounter_id=frmObj.encounterId.value;
	
	if(patient_id == ""){
		alert("APP-CA0438 Patient ID cannot be blank.");
		$("#searchresultframe").load(contextPath+"/eCommon/html/blank.html");
		frmObj.Patient_Id.focus();	
		return false;
	}
	if(encounter_id == ""){
		alert("APP-CA0439 Encounter ID cannot be blank.");
		$("#searchresultframe").load(contextPath+"/eCommon/html/blank.html");
		frmObj.encounterId.focus();
		return false;
	}
	if(patient_id!=="" && encounter_id!==""){
		xmlStr = "<root><SEARCH ";
		 xmlStr += " patient_id=\"" +patient_id+ "\"";
		 xmlStr += " encounter_id=\"" +encounter_id+ "\"";
		 xmlStr += " /></root>";
		 var xmlDoc;
		 var xmlHttp;
		 xmlHttp = new XMLHttpRequest();
		 var oParser = new DOMParser();
		 xmlDoc = oParser.parseFromString(xmlStr,"text/xml");
		 xmlHttp.open("POST", contextPath+"/eIPAD/jsp/InsuranceAuthorization/IAIntermediateValidate.jsp?ACTION=VALIDATE_PAT_ENC", false);
		 xmlHttp.send(xmlDoc);
		 responseText = xmlHttp.responseText ;
		 eval(responseText);
	}
}

function populateEncounter() {
	$("#searchresultframe").load(contextPath+"/eCommon/html/blank.html");
	$("#iaform").load(contextPath+"/eCommon/html/blank.html");
	var patient_id = $("#Patient_Id").val(); 
	patient_id = patient_id.toUpperCase();
	var encClassUrl = contextPath + "/mobile/IAJsonServlet?mode=ENCOUNTER_LIST&patientId="+patient_id+"&facilityId=AK&locale=en";
	var encClassDataSrc;
	var encClassCombo = $("#encounterId").data("kendoComboBox");
	encClassCombo.value("");
	$.getJSON(encClassUrl ,function(data){
		encClassDataSrc = data;
		encClassCombo.setDataSource(encClassDataSrc.encounterList);	
		encClassCombo.select(0);
	});
}

function validationCheck(pass,patient_id,encounter_id){
	if("Y"==pass){
		$("#errorframe").load(contextPath+"/eCommon/jsp/error.jsp?err_num=");
		$("#searchresultframe").load(contextPath+"/eIPAD/jsp/InsuranceAuthorization/IASearchDetails.jsp?patientid="+patient_id+"&encounterid="+encounter_id+"&facility_id=AK");
	}else{
		alert("APP-CA0440 Invalid Input.");
		$("#searchresultframe").load(contextPath+"/eCommon/html/blank.html");
		return false;
	}
}

function myTabFunction(obj) {
	document.formClaimFormsResult.View.disabled=false;
	document.getElementsByName("p_report_id").value = obj;
}

function viewDetailsInTab(patient_id,encounter_id,facility_id){
	var path = $("#path_value").val();
	var locale =  $("#language_id").val();
	var login_user_id = $("#login_user_id").val();
	var ws_no = $("#ws_no").val();
	var p_report_id = document.getElementsByName("p_report_id").value;
	var approval_num = $("#approval_num"+p_report_id).val();
	var responseText = false;
	if(p_report_id == ""){
		alert("APP-CA0437 No report is configured for this insurance.");
		return false;
	}
	$.ajax({
		method: "GET",
		url: path+"/mobile/InsuranceAuthorization/IAFormUrl",
		data: "module_id=CA&report_id="+p_report_id+"&facility_id="+facility_id+"&ws_no="+ws_no
				+ "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&locale=" + locale
				+ "&login_user_id="+login_user_id,
		dataType: "json",
		async: false,
		success: function(data){
			responseText = data;
			$("#iaform").load(contextPath+"/eIPAD/jsp/InsuranceAuthorization/InsuranceForm.jsp?patientid="+patient_id+"&encounterid="+encounter_id
					+"&facilityid="+facility_id+"&p_report_id="+p_report_id+"&approval_num="+approval_num+"&url="+responseText);
		},
		error: function(xhr, ajaxopt, err){
						
		}
	});
}

function saveData(patient_id,facility_id,encounter_id,p_report_id,added_by_id,added_at_ws_no,approval_num){
	var path = document.getElementById("path_value").value;
	 var dataURL = canvas.toDataURL();
	 var urlSplit = dataURL.split(",");
	 result = urlSplit[1];
	 xmlStr = "<root><SEARCH ";
	 xmlStr += " result=\"" +result+ "\"";
	 xmlStr += " patient_id=\"" +patient_id+ "\"";
	 xmlStr += " facility_id=\"" +facility_id+ "\"";
	 xmlStr += " encounter_id=\"" +encounter_id+ "\"";
	 xmlStr += " p_report_id=\"" +p_report_id+ "\"";
	 xmlStr += " added_by_id=\"" +added_by_id+ "\"";
	 xmlStr += " added_at_ws_no=\"" +added_at_ws_no+ "\"";
	 xmlStr += " approval_num=\"" +approval_num+ "\"";
	 xmlStr += " /></root>";
	 var xmlDoc;
	 var xmlHttp;
	 xmlHttp = new XMLHttpRequest();
	 xmlHttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      var currSrc = $("#pdfIframe").attr("src");
	      $("#pdfIframe").attr("src", currSrc);
	    }
	  };
	  
	 var oParser = new DOMParser();
	 xmlDoc = oParser.parseFromString(xmlStr,"text/xml");
	 xmlHttp.open("POST", path+"/iainsurance", false);
	 xmlHttp.send(xmlDoc);
	 responseText = xmlHttp.responseText ;	 
	 eval(responseText);
}

function noescUser(event) { 
	return !(window.event && event.keyCode == 27); 
}
function noescPassword(event) {
	return !(window.event && event.keyCode == 27);
}

function resetFrame() {
	var patientId = $("#Patient_Id").val();
	if(patientId == "") {
		window.location.reload();
	}
}
