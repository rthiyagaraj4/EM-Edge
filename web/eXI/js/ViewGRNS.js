
var radioval = "U";
function query() {
	f_query_add_mod.location.href = "../../eXI/jsp/ViewGRNSCriteria.jsp";
	f_query_rst.location.href = "../../eCommon/html/blank.html";
	f_query_rst_dtl.location.href = "../../eCommon/html/blank.html";
}
function prcFlag(objSel) {
	if (document.forms[0].GRNradio[0].checked) {
		radioval = "U";
	}
	else if (document.forms[0].GRNradio[1].checked) {
		radioval = "P";
	}
	else if (document.forms[0].GRNradio[2].checked) {
		radioval = "E";
	}

	document.getElementById("dtrange").style.display = "inline";
	document.forms[0].from_date_time.value = document.forms[0].st_date.value;
	document.forms[0].to_date_time.value = document.forms[0].sys_date.value;

	parent.f_query_rst.location.href = "../../eCommon/html/blank.html";
	parent.f_query_rst_dtl.location.href = "../../eCommon/html/blank.html";
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}
function getResults() {
	var qryString = "opt=" + radioval;
	if (radioval == "P" || radioval == "E" || radioval == "U") {
		var dtfrom = document.forms[0].from_date_time;
		var dtto = document.forms[0].to_date_time;
		var fields = new Array(dtfrom, dtto);
		var names = new Array(getLabel("Common.periodfrom.label", "common"), getLabel("Common.periodto.label", "common"));
		var mandtCheck = checkMandatoryFields(fields, names, parent.messageFrame, "../../eCommon/jsp/error.jsp");
		if (mandtCheck == null || mandtCheck == "") {
			qryString = qryString + "&dt_from=" + dtfrom.value + "&dt_to=" + dtto.value;
		} else {
			return false;
		}
	}
	parent.f_query_rst.location.href = "../../eXI/jsp/ViewGRNSResult.jsp?" + qryString;
	parent.f_query_rst_dtl.location.href = "../../eCommon/html/blank.html";
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}
function showDocDetails(doctype, docno) {
	var dialogHeight = "350";
	var dialogWidth = "165";
	var dialogTop = "250";
	var center = "";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eXI/jsp/ViewGRNSResultDetails.jsp?doctype=" + doctype + "&docno=" + docno;
	parent.f_query_rst_dtl.location.href = url;
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
//	window.showModalDialog(url,arguments,features);
}
function CheckValidDate(Object2, focusflag) {
	var datefield = Object2;
	if (Object2.value != undefined) {
		Object2 = Object2.value;
	} else {
		Object2 = Object2;
	}
	if (ChkDate(Object2) == false) {
		alert(getMessage("XI1059", "XI"));
		if (datefield.value != undefined && focusflag == null) {
			datefield.select();
			datefield.focus();
		}
		return false;
	} else {
		return true;
	}
}
function AllowDateFormat() {
	var key = window.event.keyCode;
	if (!(((key >= 48) && (key < 58)) || (key == 47))) {
		return false;
	}
}
function checkDateRange(fromDate, toDate) {
	if (doDateCheckOR(fromDate, toDate) == 1) {
		alert(getMessage("XI1009", "XI"));
		parent.f_query_add_mod.document.forms[0].to_date_time.value = fromDate.value;
		toDate.focus();
		return false;
	}
}
function doDateCheckOR(from, to) {
	var fromarray;
	var toarray;
	var fromdate = from.value;
	var todate = to.value;
	if (fromdate.length > 0 && todate.length > 0) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2], fromarray[1] - 1, fromarray[0]);
		var todt = new Date(toarray[2], toarray[1] - 1, toarray[0]);
		if (Date.parse(todt) < Date.parse(fromdt)) {
			return 1;
		} else {
			if (Date.parse(todt) > Date.parse(fromdt)) {
				return -1;
			} else {
				if (Date.parse(todt) == Date.parse(fromdt)) {
					return 0;
				}
			}
		}
	}
} //End of function
function checkWithSysDate(obj) {
	var currDate = parent.f_query_add_mod.document.forms[0].sys_date;
	if (doDateCheckOR(obj, currDate) == 1) {
		alert(getMessage("DATE_NOT_GREATER_SYSDATE", "common"));
		obj.value = currDate.value;
		obj.focus();
		return false;
	}
}
function showCalendarValidate(str) {
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
function submitPrevNext(from, to) {
	document.forms[0].from.value = from;
	document.forms[0].to.value = to;
	document.forms[0].target = "f_query_rst";
	document.forms[0].submit();
	parent.f_query_rst_dtl.location.href = "../../eCommon/html/blank.html";
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}
function doSelect(obj, index) {
	var formObj = "";
	if (obj.checked == true) {
		formObj = parent.f_query_rst.document.ViewGRNsResultFrm;
		if ((parent.frames[2].document.forms[0].selDoc.value != "")) {
			alert("XI1058", "XI");
			obj.checked = false;
			return false;
		}
		obj.value = "Y";
		parent.frames[2].document.forms[0].selDoc.value = eval("parent.f_query_rst.document.ViewGRNsResultFrm.doctype_" + index).value + "~~" + eval("parent.f_query_rst.document.ViewGRNsResultFrm.docno_" + index).value;
		parent.frames[1].document.forms[0].proc.disabled = false;
	} else {
		obj.value = "N";
		parent.frames[2].document.forms[0].selDoc.value = "";
		parent.frames[1].document.forms[0].proc.disabled = true;
	}
}
function showErrDetails(doctype, docno, doctext) {
	var dialogHeight1 = "9";
	var dialogWidth = "30";
	var features = "dialogHeight:" + dialogHeight1 + "; dialogWidth:" + dialogWidth + "; scroll=no; status=no";
	var arguments = doctext;
	window.showModalDialog("../../eXI/jsp/ViewRemarks.jsp?title_name=Error Remarks", arguments, features);
}
function showSingleDetails(facility, docno, doctext, item_code) {
	var dialogHeight1 = "80vh";
	var dialogWidth = "96vw";
	var features = "dialogHeight:" + dialogHeight1 + "; dialogWidth:" + dialogWidth + "; scroll=no; status=no";
	var arguments = doctext;
	window.showModalDialog("../../eXI/jsp/ViewSingleFormDetailMain.jsp?title_name=View Details&facility=" + facility + "&docno=" + docno + "&doctext=" + doctext + "&item_code=" + item_code, arguments, features);
}
function doProcess(nIndex) {
	var selDocArr = new Array();
	var selDocType = "";
	var selDocNo = "";
	var dtFrom = "";
	var dtUpto = "";
	var opt = "";
	var qstring = "";
	if (parent.frames[2].document.forms[0]) {
		selDocType = eval("parent.frames[2].document.forms[0].doctype_" + nIndex + ".value");
		selDocNo = eval("parent.frames[2].document.forms[0].docno_" + nIndex + ".value");
	}
	dtFrom = parent.f_query_add_mod.document.forms[0].from_date_time.value;
	dtUpto = parent.f_query_add_mod.document.forms[0].to_date_time.value;
	opt = radioval;
	qstring = "?doc_type=" + selDocType + "&doc_no=" + selDocNo + "&dtfrom=" + dtFrom + "&dtUpto=" + dtUpto + "&selopt=" + opt;
	/*parent.f_query_add_mod.document.forms[0].action="../../eST/jsp/ProcessGRNs.jsp"+qstring;
    parent.f_query_add_mod.document.forms[0].target="messageFrame";
	parent.f_query_add_mod.document.forms[0].method="post";
    parent.f_query_add_mod.document.forms[0].submit();
	*/
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "../../eXI/jsp/ProcessGRNs.jsp" + qstring, false);
	xmlHttp.send(null);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

