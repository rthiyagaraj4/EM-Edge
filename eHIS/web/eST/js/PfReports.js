
var message = "";
function reset() {
	frames[1].document.formPfReportsCriteria.reset();
	frames[1].document.getElementById("rp1").style.display = "none";
//frames[1].document.getElementById("rp2").style.display = "none";
	frames[1].document.getElementById("rp3").style.display = "none";
	frames[1].document.getElementById("rp4").style.display = "none";
//frames[1].document.getElementById("rp5").style.display = "none";
	frames[1].document.getElementById("rp6").style.display = "none";
}
function loadPage() {
	if (parent.f_query_add_mod.document.formPfReportsCriteria.pf_report_id.value == "STGRNSTDRGS") {
		document.getElementById("rp1").style.display = "inline";
//		document.getElementById("rp2").style.display = "inline";
		document.getElementById("rp3").style.display = "inline";
		document.getElementById("rp4").style.display = "inline";
//		document.getElementById("rp5").style.display = "inline";
		document.getElementById("rp6").style.display = "inline";
	} else {
		document.getElementById("rp1").style.display = "none";
//		document.getElementById("rp2").style.display = "none";
		document.getElementById("rp3").style.display = "none";
		document.getElementById("rp4").style.display = "none";
//		document.getElementById("rp5").style.visibility = "hidden";
		document.getElementById("rp6").style.display = "none";
	}
}
function run() {
	frames[1].document.formPfReportsCriteria.p_report_id.value = frames[1].document.formPfReportsCriteria.pf_report_id.value;
	/*frames[1].document.formPfReportsCriteria.p_date_from.value=frames[1].document.formPfReportsCriteria.p_date_from.value;
	frames[1].document.formPfReportsCriteria.p_date_to.value=frames[1].document.formPfReportsCriteria.p_date_to.value; */
	var frmObject = frames[1].document.formPfReportsCriteria;
	if (frames[1].document.formPfReportsCriteria) {
		if (frmObject.p_report_id.value == "STGRNSTDRGS") {
			frmObject.p_count.value = frmObject.p_count.value;
			var fields = new Array(frmObject.p_report_id, frmObject.p_date_from, frmObject.p_date_to, frmObject.p_count);
			var names = new Array(getLabel("Common.PFReports.label", "Common"), getLabel("Common.fromdate.label", "common"), getLabel("Common.todate.label", "common"), getLabel("eST.TopValue.label", "ST"));
		} else {
			var fields = new Array(frmObject.p_report_id, frmObject.p_date_from, frmObject.p_date_to);
			var names = new Array(getLabel("Common.PFReports.label", "Common"), getLabel("Common.fromdate.label", "common"), getLabel("Common.todate.label", "common"));
		}
		if (checkSTFields(fields, names, messageFrame)) {
			if (DateCheck(frmObject.p_date_from, frmObject.p_date_to)) {
				frmObject.submit();
			}
		}
	}
}
function DateCheck(from, to) {
	var fromarray;
	var toarray;
	var fromdate = from.value;
	var todate = to.value;
	if (fromdate.length > 0 && todate.length > 0) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2], fromarray[1], fromarray[0]);
		var todt = new Date(toarray[2], toarray[1], toarray[0]);
		if (Date.parse(todt) < Date.parse(fromdt)) {
			alert(getMessage("TO_DT_GR_EQ_FM_DT", "SM"));
			return false;
		}
	}
	return true;
}

