/*
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
28-JAN-2019      100           	Aravindh H          Created
---------------------------------------------------------------------------------------------------------------
 */

function reset() {
	genRcptForVendorsSrch.document.location.reload();
	genRcptForVendorsRslt.document.location.href = '../../eCommon/html/blank.html';
}

function trimString(sInString) {
	return sInString.replace(/^\s+|\s+$/g, "");
}

async function patientIdLookup(obj, mode, selectedRowNum) {
	var frm = document.genRcptForVendorsSrchFrm;
	if(mode == "result") {		
		document.getElementById("chk_" + selectedRowNum).checked = false;
	}
	var pat_id = await PatientSearch();
	if (pat_id != null) {
		obj.value = pat_id;
		getPatDetails(obj, mode, selectedRowNum);
	} else {
		obj.value = '';
		if(frm != 'undefined' && frm != undefined) {
			frm.patName.value = '';
			frm.patName.disabled = false;
		}
	}
}

function callPatValidation(obj, mode, selectedRowNum) {
	var frm = document.genRcptForVendorsSrchFrm;
	var patient_id = obj.value;
	if (patient_id != "") {
		var xmlStr = "<root><SEARCH ";
		xmlStr += " /></root>";
		var temp_jsp = "../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=CHK_PAT_ID&patient_id="
				+ patient_id;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		var responseText = trimString(xmlHttp.responseText);
		if (responseText == "N") {
			alert(getMessage("INVALID_PATIENT", "MP"));
			obj.select();
			if(frm != 'undefined' && frm != undefined) {
				frm.patName.value = '';
			}
		} else if (responseText == "Y") {
			getPatDetails(obj, mode, selectedRowNum);
		}
	}
}

function getPatDetails(obj, mode, selectedRowNum) {
	var frm = document.genRcptForVendorsSrchFrm;
	var patientID = obj.value;
	if (patientID.length > 0) {
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=getPatientName&patientID="
				+ patientID;
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var  res = trimString(xmlHttp.responseText);
		var responseText = res.replace(/<!DOCTYPE html>[\s\S]*?/, "").trim();
		if(frm != 'undefined' && frm != undefined) {
			frm.patName.value = responseText;
			frm.patName.disabled = true;
		}
		if(mode == "result") {
			validatePatIdWithDetails(obj, selectedRowNum);
		}
	} else {
		if(frm != 'undefined' && frm != undefined) {
			frm.patName.value = '';
			frm.patName.disabled = false;
		}
	}
}

function validateFromDate() {
	var bool = checkDateBL(document.forms[0].practoDateFrom);

	if (!bool) {
		$('#practoDateFrom').val($('#todaysDate').val());
		return false;
	}

	if ($("#practoDateFrom").val() != '') {
		var fromLesserThanCurrentDt = true;
		var lesserThanCurrentDt = true;
		var toGrtThanFromDt = true;

		fromLesserThanCurrentDt = isBeforeNow($("#practoDateFrom").val(),
				'DMY', $("#locale").val());
		if ($("#practoDateTo").val() != '') {
			lesserThanCurrentDt = isBeforeNow($("#practoDateTo").val(), 'DMY',
					$("#locale").val());
			toGrtThanFromDt = isAfter($("#practoDateTo").val(), $(
					"#practoDateFrom").val(), 'DMY', $("#locale").val());

		}
		if (fromLesserThanCurrentDt == false) {
			alert("Practo Receipt Date From Cannot be greater than Current Date");
			$("#practoDateFrom").val($('#todaysDate').val());
		} else if (lesserThanCurrentDt == false) {
			alert("Practo Receipt Date To Cannot be greater than Current Date");
			$("#practoDateTo").val($('#todaysDate').val());
		} else if (toGrtThanFromDt == false) {
			if ($("#practoDateFrom").val() != '') {
				alert(getMessage('BL4115', 'BL'));
				$("#practoDateFrom").val($("#practoDateTo").val());
			}
		}

	}
}

function validateToDate() {
	var bool = checkDateBL(document.forms[0].practoDateTo);

	if (!bool) {
		$('#practoDateTo').val($('#todaysDate').val());
		return false;
	}
	if ($("#practoDateTo").val() != '') {

		var fromLesserThanCurrentDt = isBeforeNow($("#practoDateTo").val(),
				'DMY', $("#locale").val());

		var lesserThanCurrentDt = isBeforeNow($("#practoDateFrom").val(),
				'DMY', $("#locale").val());
		var toGrtThanFromDt = isAfter($("#practoDateTo").val(), $(
				"#practoDateFrom").val(), 'DMY', $("#locale").val());

		if (fromLesserThanCurrentDt == false) {
			alert("Practo Receipt Date To Cannot be greater than Current Date");

			$("#practoDateTo").val($('#todaysDate').val());
		} else if (lesserThanCurrentDt == false) {
			alert("Practo Receipt Date From Cannot be greater than Current Date");
			$("#practoDateFrom").val($('#todaysDate').val());
		} else if (toGrtThanFromDt == false) {
			if ($("#practoDateTo").val() != '') {
				alert(getMessage('BL4115', 'BL'));
				$("#practoDateTo").val($('#practoDateFrom').val());
			}
		}

	}
}

function checkDateBL(entered_date) {
	var locale = document.forms[0].locale.value;
	if (entered_date.value != "") {
		if (validDate(entered_date.value, 'DMY', locale)) {
			return true;
		} else {
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			entered_date.select();
			return false;
		}
	} else {
		return true;
	}
}

function searchReceipts() {
	var frm = document.forms[0];
	var facilityId = frm.facilityId.value;
	var locale = frm.locale.value;
	var strLoggedUser = frm.strLoggedUser.value;
	var clientIpAddress = frm.clientIpAddress.value;
	var vendorType = frm.vendorType.value;
	var patID = frm.patID.value;
	var patName = frm.patName.value;
	var practoDateFrom = frm.practoDateFrom.value;
	var practoDateTo = frm.practoDateTo.value;
	var receiptStatus = frm.receiptStatus.value;
	var patIdLength = frm.pat_id_len.value;
	
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	
	if (practoDateFrom == undefined || practoDateFrom == '') {
		alert(getMessage("BL0797", "BL"));
		return false;
	}
	if (practoDateTo == undefined || practoDateTo == '') {
		alert(getMessage("BL0798", "BL"));
		return false;
	}

	var starr = practoDateFrom.split("/");
	var enarr = practoDateTo.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1] - 1, enarr[0]);
	var timeDiff;
	var daysDiff;
	if (startdt > enddt) {
		alert(getMessage('BL4115', 'BL'));
		return false;
	}
	timeDiff = enddt.getTime() - startdt.getTime();
	daysDiff = Math.floor(timeDiff / (1000 * 60 * 60 * 24));
	var dayDiff = 31;
	if (daysDiff > dayDiff - 1) {
		alert("Practo Receipt Date To Cannot be greater than " + dayDiff
				+ " Days from Practo Receipt Date From");
		return false;
	}

	parent.genRcptForVendorsRslt.location.href = "../../eBL/jsp/BLGenRcptForVendorsResult.jsp?"
			+ "facilityId="
			+ facilityId
			+ "&locale="
			+ locale
			+ "&strLoggedUser="
			+ strLoggedUser
			+ "&clientIpAddress="
			+ clientIpAddress
			+ "&vendorType="
			+ vendorType
			+ "&patientId="
			+ patID
			+ "&patientName="
			+ patName
			+ "&practoDateFrom="
			+ practoDateFrom
			+ "&practoDateTo="
			+ practoDateTo
			+ "&receiptStatus="
			+ receiptStatus
			+ "&patIdLength=" + patIdLength + "&mode=search";

}

function checkAll() {
	var locale = document.getElementById("locale").value;
	var facilityId = document.getElementById("facilityId").value;
	var clientIpAddress = document.getElementById("clientIpAddress").value;
	var practoUser = document.getElementById("practoUser").value;
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=validateLoginCashCounter&facilityId="+ facilityId+"&locale="+locale
					+ "&clientIpAddress=" + clientIpAddress + "&practoUser=" + practoUser; 
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var responseText = trimString(xmlHttp.responseText);
	if(responseText != "") {
		alert(responseText);//Error returns from BLCommonAjax.jsp
		document.getElementById('chkall').checked = false;
		return;
	}
	
	var totalRecCount = document.getElementById("totalRecord").value;
	if (document.getElementById('chkall').checked == true) {
		for ( var i = 0; i < totalRecCount; i++) {
			if (document.getElementById("chk_" + i) != undefined
					&& document.getElementById("chk_" + i) != 'undefined'
					&& document.getElementById("chk_" + i) != null
					&& document.getElementById("chk_" + i) != 'null') {
				if(document.getElementById("patId_" + i).value != "") {
					document.getElementById("chk_" + i).checked = true;
				}
			}
		}
	} else {
		for ( var i = 0; i < totalRecCount; i++) {
			if (document.getElementById("chk_" + i) != undefined
					&& document.getElementById("chk_" + i) != 'undefined'
					&& document.getElementById("chk_" + i) != null
					&& document.getElementById("chk_" + i) != 'null') {
				document.getElementById("chk_" + i).checked = false;
			}
		}
	}
}

function apply() {
	var rsltFormObj = genRcptForVendorsRslt.document.genRcptForVendorsRsltFrm;
	var xmlString = formXMLStringMain(rsltFormObj);
	var updation = formValidation(xmlString, "APPLY");
	if(updation == true) {
		genRcptForVendorsRslt.document.forms[0].target = 'messageFrame';
		genRcptForVendorsRslt.document.forms[0].method = 'post';
		genRcptForVendorsRslt.document.forms[0].action = "../../servlet/eBL.BLGenRcptForVendorsServlet";
		genRcptForVendorsRslt.document.forms[0].submit();
		reset();
	}
}

function formXMLStringMain(frmObj) {
	var xmlStr = "";
	if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
		xmlStr = "<root><SEARCH ";
		if (true) {
			var arrObj = frmObj.elements;
			for ( var i = 0; i < arrObj.length; i++) {
				var val = "";
				if (arrObj[i].type == "checkbox") {
					val = arrObj[i].checked;
					if (val == true || val == "true") {
						val = "Y";
					} else {
						val = "N";
					}
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";
				} else if (arrObj[i].type == "radio") {
					if (arrObj[i].checked) {
						val = arrObj[i].value;
						if (arrObj[i].name != null && arrObj[i].name != "")
							xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
									+ "\" ";
					}
				} else if (arrObj[i].type == "select-multiple") {
					for ( var j = 0; j < arrObj[i].options.length; j++) {
						if (arrObj[i].options[j].selected)
							val += arrObj[i].options[j].value + "~";
					}
					val = val.substring(0, val.lastIndexOf('~'));
					if (arrObj[i].name != null && arrObj[i].name != "")
						;
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
				} else {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";
				}
			}
		}
		xmlStr += " /></root>";
	}
	return xmlStr;
}

// XML String passing for validation
async function formValidation(xmlStr, last_link) {
	var temp_jsp = "BLGenRcptForVendorsValidation.jsp?func_mode=" + last_link;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	return true;
}

function chkEmptyPatientId(obj, selectedRowNum) {
	if(obj.checked == true) {
		var patId = eval(document.getElementById("patId_"+selectedRowNum));
		if(patId.value == "") {
			alert(getMessage("BL6103", "BL"));
			obj.checked = false;
			patId.focus();
		}
	}
}

function validatePatIdWithDetails(obj, selectedRowNum) {
	var frm = document.genRcptForVendorsRsltFrm;
	var patientName = eval(document.getElementById("patName_"+selectedRowNum));
	var patientDob = eval(document.getElementById("patDob_"+selectedRowNum));
	var patientGender = eval(document.getElementById("patGender_"+selectedRowNum));
	var patientID = obj.value;
	
	if (patientID.length > 0) {
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=validatePatientIdWithDetails&patientID=" + patientID 
						+ "&patientName=" + patientName.value + "&patientDob=" + patientDob.value 
						+ "&patientGender=" + patientGender.value;
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var responseText = trimString(xmlHttp.responseText);
		responseText = responseText.split(":::");
		
		if(frm != 'undefined' && frm != undefined) {
			if(responseText[0] == "false") {				
				alert(getMessage("BL0801", "BL"));
				obj.value = '';
				obj.focus();
			} else if(responseText[0] == "patientNamePartial") {
				var chkUser = confirm(getMessage("BL0802", "BL"));
				if(chkUser == false) {
					obj.value = '';
					obj.focus();
				}
			} else if(responseText[0] == "patientNameMismatch") {
				var msg = getMessage("BL0803", "BL");
				msg = msg.replace('$', responseText[1]);
				var chkUser = confirm(msg);
				if(chkUser == false) {
					obj.value = '';
					obj.focus();
				}
			}
		}
	}
}
