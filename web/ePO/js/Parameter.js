
function onSuccess() {
	f_query_add_mod.document.location.reload();
}
function apply() {
	var formObj = f_query_add_mod.document.formParameter;
	if(formObj==null){
	messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return false;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
		var resultText = formApply(formObj, PO_CONTROLLER);
	//	alert(resultText);
  		
		eval(resultText);
		messageFrame.location.href = errorPage + "?err_num=" + message;
		if (result) {
		
			onSuccess();
		}

}
function reset() {
	f_query_add_mod.document.formParameter.reset();
}

/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - Function to Restrict user to enter Interger Greater than 4
	*/

function validIntegerLessThanThree() {
	var key = window.event.keyCode;
	if (!(key >= 48 && key <= 52)) {
		return false;
	} else {
		return true;
	}
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
