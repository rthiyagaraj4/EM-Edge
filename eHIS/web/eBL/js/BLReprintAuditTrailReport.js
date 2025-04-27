/*
--------------------------------------------------------------------------------------------------------------
Date     	   Edit History              Name     			Description
--------------------------------------------------------------------------------------------------------------
10-JULY-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
*/

function run() {
	var parentForm = frames[1].document.forms[0];
	var facility_id = parentForm.facility_id.value;
	var locale = parentForm.locale.value;
	var loggedUserId = parentForm.userid.value;
	var episodeType = parentForm.episode_type.value;
	var reprintDateFrom = parentForm.reprint_date_from.value;
	var reprintDateTo = parentForm.reprint_date_to.value;
	var docTypeFrom = parentForm.doctype_from.value;
	var docNoFrom = parentForm.docnum_from.value;
	var docTypeTo = parentForm.doctype_to.value;
	var docNoTo = parentForm.docnum_to.value;
	var reprintDateFromLabel = getLabel("eBL.ReprintDateFrom.label", "BL");
	var reprintDateToLabel = getLabel("eBL.ReprintDateTo.label", "BL");
	var fields = new Array(parentForm.reprint_date_from, parentForm.reprint_date_to);
	var names = new Array(reprintDateFromLabel, reprintDateToLabel);
	var reportId = parentForm.reportId.value;
	var moduleId = parentForm.moduleId.value;
	if (docTypeFrom != "" && docTypeTo == "") {
		parentForm.document.getElementById("doctype_to").value = docTypeFrom;
		docTypeTo = docTypeFrom;
	}
	if(docNoFrom != "" && docNoTo == "") {
		parentForm.document.getElementById("docnum_to").value = docNoFrom;
		docNoTo = docNoFrom;
	}
	if (docTypeFrom == "" && docTypeTo != "") {
		parentForm.document.getElementById("doctype_from").value = docTypeTo;
		docTypeFrom = docTypeTo;
	}
	if(docNoFrom == "" && docNoTo != "") {
		parentForm.document.getElementById("docnum_from").value = docNoTo;
		docNoFrom = docNoTo;
	}
	if(checkFields(fields,names,messageFrame)) {
		$
		.ajax({
			type : "GET",
			url : "../jsp/BLCommonReportValidation.jsp?p_report_id="
					+ reportId + "&param1=" + episodeType + "&param2="
					+ reprintDateFrom + "&param3=" + reprintDateTo + "&param4="
					+ docTypeFrom + "&param5=" + docNoFrom + "&param6=" + docTypeTo 
					+ "&param7=" + docNoTo + "&param8=" + locale + "&param9=" + loggedUserId,
			data : "",
			async : false,
			dataType : "text",
			success : function(data) {
				var session_id = '';
				var pgm_date = '';
				var retVal = trimString(data).split(":::");
				if (retVal.length == 2) {
					session_id = retVal[0];
					pgm_date = retVal[1];
				}
				var dummyDoc = dummyFrame.document;
				var htmlVal = "<html><body>";
				htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
				htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"
						+ facility_id + "'>";
				htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"
						+ locale + "'>";
				htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"
						+ reportId + "'>";
				htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"
						+ session_id + "'>";
				htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"
						+ pgm_date + "'>";
				htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"
						+ moduleId + "'>";
				htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"
						+ reportId + "'>";

				htmlVal += "</form></body></html>";

				dummyDoc.body.insertAdjacentHTML("afterbegin", HTMLVal);
				dummyDoc.dummy_frm.submit();

			},
			error : function(xhr, ajaxOptions, thrownError) {
				alert(xhr);
				alert(ajaxOptions);
			}
		});
	}
}

function reset() {
	reprintaudittrail.document.location.reload();
}

function doctypeLookUp(obj, docnumObj, type, sqlData) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = "";
	var parentForm = parent.frames[1].document.forms[0];
	var facilityId = parentForm.facility_id.value;
	var episodeType = parentForm.episode_type.value;
	var reprintFrom = parentForm.reprint_date_from.value;
	var reprintTo = parentForm.reprint_date_to.value;
	argumentArray[0] = "SELECT code,description "
			+ " FROM (SELECT DISTINCT doc_num as description, doc_type_code as code"
			+ " FROM bl_bill_reprint_audit_trail"
			+ " WHERE operating_facility_id = '"+facilityId+"' "
			+ " AND (('"+episodeType+"' <> 'A' AND '"+episodeType+"' = episode_type) OR ('"+episodeType+"' = 'A'))"
			+ " AND TRUNC (bill_reprint_date_time)"
            + " BETWEEN TRUNC (to_date('" + reprintFrom +"','dd/MM/yyyy'))"
            + " AND TRUNC (to_date('" + reprintTo +"','dd/MM/yyyy'))"
            + " ) where code like upper(?) and description like upper(?)";
	if(sqlData == 'FROM') {
		title = getLabel("eBL.DocTypeFrom.label", "BL");
	}	
	else if(sqlData == 'TO') {
		title = getLabel("eBL.DocTypeTo.label", "BL");
	}
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(type == 'T') {
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
	} else if(type == 'N') {
		argumentArray[4] = "1,2";
		argumentArray[5] = docnumObj.value;
	}
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = CommonLookup(title, argumentArray);
	if (retVal != null && retVal != "") {
		docnumObj.value = retVal[1];
		obj.value = retVal[0];
	} else {
		docnumObj.value = "";
		obj.value = "";
	}
}

function trimString(sInString) {
	return sInString.replace(/^\s+|\s+$/g, "");
}

function fnClearCode(obj) {
	obj.value = '';
}

function docNoFromToValidation(fromOrTo){
	var docTypeFrom = $("#doctype_from").val();
	var docNoFrom = $("#docnum_from").val();
	var docTypeTo = $("#doctype_to").val();
	var docNoTo = $("#docnum_to").val();
	var fromTypeNo = docTypeFrom + docNoFrom;
	var toTypeNo = docTypeTo + docNoTo;
	if(fromTypeNo != "" && toTypeNo != "") {
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=comparePatientId&fromPatId="
			+ fromTypeNo + "&toPatId=" + toTypeNo;
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var responseText = trimString(xmlHttp.responseText);
		if (responseText == "false") {
			var str1 = getLabel("eBL.DocTypeFrom.label", "BL");
			var str2 = getLabel("eBL.DocTypeTo.label", "BL");
			var error = str1 + " cannot be greater than " + str2;
			alert(error);
			if(fromOrTo=='FROM'){
				$("#docnum_from").val('');
				$("#doctype_from").val('');
			}
			if(fromOrTo=='TO'){
				$("#doctype_to").val('');
				$("#docnum_to").val('');
			}
		return false;
		}
	}
}

