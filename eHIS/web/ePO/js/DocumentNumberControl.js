var function_id = "";


function onSuccess() {
	DocumentNumberControlListFrame.location.reload();
}
function apply() {
	var formObj = DocumentNumberControlListFrame.document.formDocNoGenControl;
	if(formObj==null){
	messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return false;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	
	if((formObj.pr_auto.value =="A") && (formObj.po_auto.value =="A")){
	
	
	var fields = new Array(formObj.pr_start_no,formObj.pr_next_no,formObj.po_start_no,formObj.po_next_no,formObj.do_start_no,formObj.do_next_no,formObj.quot_start_no,formObj.quot_next_no);
		var names = new Array("Purchase Request"+ " "+ getLabel("eST.StartDocNo.label", "ST"),"Purchase Request"+ " " +getLabel("eST.NextDocNo.label", "ST"),"Purchase Order" + " " + getLabel("eST.StartDocNo.label", "ST"),"Purchase  Order" + " " + getLabel("eST.NextDocNo.label", "ST"),"Delivery  Order" + " " + getLabel("eST.StartDocNo.label", "ST"),"Delivery  Order" + " " + getLabel("eST.NextDocNo.label", "ST"),"Quotation" + " " + getLabel("eST.StartDocNo.label", "ST"),"Quotation" + " " + getLabel("eST.NextDocNo.label", "ST"));
		var blankObject = null;
		blankObject = checkPOFields(fields, names, messageFrame, errorPage);

		if (blankObject == true) {
	
		var resultText = formApply(formObj, PO_CONTROLLER);
		eval(resultText);
		messageFrame.location.href = errorPage + "?err_num=" + message;
		if (result) {
		
			onSuccess();
		}
	}
	} else if((formObj.pr_auto.value =="A") && (formObj.po_auto.value =="M")){
	
		var fields = new Array(formObj.pr_start_no,formObj.pr_next_no,formObj.do_start_no,formObj.do_next_no,formObj.quot_start_no,formObj.quot_next_no);
		var names = new Array("Purchase Request"+ " "+ getLabel("eST.StartDocNo.label", "ST"),"Purchase Request"+ " " +getLabel("eST.NextDocNo.label", "ST"),"Delivery  Order" + " " + getLabel("eST.StartDocNo.label", "ST"),"Delivery  Order" + " " + getLabel("eST.NextDocNo.label", "ST"),"Quotation" + " " + getLabel("eST.StartDocNo.label", "ST"),"Quotation" + " " + getLabel("eST.NextDocNo.label", "ST"));
		var blankObject = null;
		blankObject = checkPOFields(fields, names, messageFrame, errorPage);

	
	if (blankObject == true) {
		var resultText = formApply(formObj, PO_CONTROLLER);
		eval(resultText);
		messageFrame.location.href = errorPage + "?err_num=" + message;
		if (result) {		
			onSuccess();
		}
	}
	
	} else if((formObj.pr_auto.value =="M") && (formObj.po_auto.value =="A")){
	
	var fields = new Array(formObj.po_start_no,formObj.po_next_no,formObj.do_start_no,formObj.do_next_no,formObj.quot_start_no,formObj.quot_next_no);
		var names = new Array("Purchase Order" + " " + getLabel("eST.StartDocNo.label", "ST"),"Purchase  Order" + " " + getLabel("eST.NextDocNo.label", "ST"),"Delivery  Order" + " " + getLabel("eST.StartDocNo.label", "ST"),"Delivery  Order" + " " + getLabel("eST.NextDocNo.label", "ST"),"Quotation" + " " + getLabel("eST.StartDocNo.label", "ST"),"Quotation" + " " + getLabel("eST.NextDocNo.label", "ST"));
		var blankObject = null;
		blankObject = checkPOFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
		var resultText = formApply(formObj, PO_CONTROLLER);
		eval(resultText);
		messageFrame.location.href = errorPage + "?err_num=" + message;
		if (result) {		
			onSuccess();
		}
	}
	
	} else if((formObj.pr_auto.value =="M") && (formObj.po_auto.value =="M")){
	
		
	var fields = new Array(formObj.do_start_no,formObj.do_next_no,formObj.quot_start_no,formObj.quot_next_no);
		var names = new Array("Delivery  Order" + " " + getLabel("eST.StartDocNo.label", "ST"),"Delivery  Order" + " " + getLabel("eST.NextDocNo.label", "ST"),"Quotation" + " " + getLabel("eST.StartDocNo.label", "ST"),"Quotation" + " " + getLabel("eST.NextDocNo.label", "ST"));
		var blankObject = null;
		blankObject = checkPOFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
		var resultText = formApply(formObj, PO_CONTROLLER);
		eval(resultText);
		messageFrame.location.href = errorPage + "?err_num=" + message;
		if (result) {		
			onSuccess();
		}
	}
	}
	

}
function reset() {
	DocumentNumberControlListFrame.location.reload();
}


function isValidNumber(fld, e, maxInt, deci) {
	
	var disp_allowed_yn = "Y";
	if(document.forms[0].dec_allowed_yn!=undefined){
		disp_allowed_yn = document.forms[0].dec_allowed_yn.value;
	}
	if(disp_allowed_yn=="N"){
		deci = 0;
	}
	var count = fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (count >= maxInt) {
		if (count == maxInt) {
			var dotOccurance = fld.value.indexOf(".");
			if (((dotOccurance >= maxInt) || (dotOccurance == -1)) && (count == maxInt)) {
				if (whichCode != 46) {
					if (deci > 0) {
						fld.value = fld.value + ".";
					}else{
						return false;
					}
				}
			}
		} else {
			if (count > maxInt) {
				var objectValue = fld.value;
				var dotOccurance = objectValue.indexOf(".");
				if ((objectValue.charAt(maxInt)) != ".") {
					if (dotOccurance == -1) {
						if (deci != 0) {
							fld.value = objectValue.substring(0, maxInt) + ".";
						} else {
							//fld.value = objectValue.substring(0, maxInt);
							return false;
						}
						return false;
					}
				}
			}
		}
	}
	var strCheck = ".0123456789";
	if (deci == 0) {
		strCheck = "0123456789";
	}
	var fldvalue = fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) {
		return false;  // Enter  --  Modified by gangadharan for disable Enter button
	}
	var pointCount = 0;
	for (var i = 0; i < fldvalue.length; i++) {
		if (fldvalue.charAt(i) == ".") {
			pointCount++;
		}
	}
	if (pointCount > 0 && whichCode == 46) {
		return false;
	}
	var fldValue = fld.value;
	var dotIndex = fldValue.indexOf(".");
	var fldLength = fldValue.length;
	if (dotIndex != -1) {
		if (fldLength > (dotIndex + deci)) {
			return false;
		}
	}
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;  // Not a valid key
	}
	return true;
}

function prManualDisplay() {
	var formObj = document.formDocNoGenControl;
	//if(formObj.PRCount.value==0 && formObj.DocCount.value==0){
		if(formObj.pr_auto.value =="M") {
			
				formObj.pr_purunit_yn.checked = "";
				formObj.pr_purunit_yn.disabled = true;
				formObj.pr_facility_yn.checked = "";
				formObj.pr_facility_yn.disabled = true;
				formObj.pr_year_yn.checked = "";
				formObj.pr_year_yn.disabled = true;
				formObj.pr_start_no.value = "";
				formObj.pr_start_no.disabled = true;
				formObj.pr_next_no.value = "";
				formObj.pr_next_no.disabled = true;
		}else {
			formObj.pr_purunit_yn.disabled = false;
			formObj.pr_facility_yn.disabled = false;
			formObj.pr_year_yn.disabled = false;
			formObj.pr_start_no.disabled = false;
			formObj.pr_next_no.disabled = false;
		
		}
	//}
}

function poManualDisplay() {
	var formObj = document.formDocNoGenControl;
	//if(formObj.POCount.value==0 && formObj.DocCount.value==0 ){
		if(formObj.po_auto.value =="M") {
			formObj.po_purunit_yn.checked = "";
			formObj.po_purunit_yn.disabled = true;
			formObj.po_facility_yn.checked = "";
			formObj.po_facility_yn.disabled = true;
			formObj.po_year_yn.checked = "";
			formObj.po_year_yn.disabled = true;
			formObj.po_start_no.value = "";
			formObj.po_start_no.disabled = true;
			formObj.po_next_no.value = "";
			formObj.po_next_no.disabled = true;
			
		}else {
			formObj.po_purunit_yn.disabled = false;
			formObj.po_facility_yn.disabled = false;
			formObj.po_year_yn.disabled = false;
			formObj.po_start_no.disabled = false;
			formObj.po_next_no.disabled = false;	
		}
	//}
}

function doManualDisplay() {
	var formObj = document.formDocNoGenControl;

			formObj.do_facility_yn.disabled = false;
			formObj.do_year_yn.disabled = false;
			formObj.do_start_no.disabled = false;
			formObj.do_next_no.disabled = false;	

}

function quotManualDisplay() {
	var formObj = document.formDocNoGenControl;

			formObj.quot_facility_yn.disabled = false;
			formObj.quot_year_yn.disabled = false;
			formObj.quot_start_no.disabled = false;
			formObj.quot_next_no.disabled = false;	

}

function displaynextnumber_pr() {
	var formObj = document.formDocNoGenControl;
	if(formObj.pr_start_no.value !="") {
	var start_doc_no = formObj.pr_start_no.value;
	formObj.pr_next_no.value = start_doc_no++;
	var pr = formObj.pr_next_no.value;
	formObj.pr_next_no.value= ++pr;
	}
}

function displaynextnumber_po() {
	var formObj = document.formDocNoGenControl;
	if(formObj.po_start_no.value !="") {
	var start_doc_no = formObj.po_start_no.value;
	formObj.po_next_no.value = start_doc_no++;
	var po = formObj.po_next_no.value;
	formObj.po_next_no.value = ++po;
	}
}
//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
function tenderManualDisplay() {   
	      var formObj = document.formDocNoGenControl;
			formObj.tndr_facility_yn.disabled = false;
			formObj.tndr_year_yn.disabled = false;
			formObj.tndr_start_no.disabled = false;
			formObj.tndr_next_no.disabled = false;	
}

