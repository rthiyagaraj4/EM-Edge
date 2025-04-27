/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
06/02/2017		IN0061112		Badmavathi B							GHL-CRF-0413 - Barcode search
24/05/2017		IN063603		Badmavathi B							GHL-CRF-0456
08/Aug/2017					Chithra M							GHL-CRF-0462
2/09/2017		IN064209		Soorya Prakash M						GHL-CRF-0465
15/11/2017		INC065695		Shazana Hasan							MMS-DM-CRF-0112 - Barcode search
31/Jan/2018						Chithra M							 	barcode Not wrkg in GHL
30/01/2020      IN071972            Haribabu                                AAKH-CRF-0117.2 
03/09/2020      IN073900            Haribabu                                MMS-DM-CRF-0174.2
07/09/2020      IN073938        B Haribabu          07/09/2020                    MMS-DM-CRF-0174.2
30/12/2020      TFSid:11896      B Haribabu          30/12/2020          ST-MMS-DM-CRF-0174.2/03(TF) - Request Issue
19/01/2021      TFS id:6938        B Haribabu          19/01/2021                    MMS-DM-CRF-0174.3
---------------------------------------------------------------------------------------------------------
*/
var YES = "Yes";
var NO = "No";
var CLOSED = "";
var function_id = "";
var result = false;
var message = "";
var flag = "";
var invalidCode = ""; 
////////*******TO BE REMOVED WHEN ADDED IN COMMON***********//////////
var INT = "Integer";
var LONG = "Long";
var FLOAT = "Float";
var DOUBLE = "Double";
var STRING = "String";
var DATE = "Date";
////////*******TO BE REMOVED WHEN ADDED IN COMMON***********//////////

//References eST.Common.SsRepository.DEFAULT_LIST_OPTION_TEXT
var DEFAULT_LIST_OPTION_TEXT = "    --- Select ---    ";
/* Comment/Uncomment to toggle RightClick arrest*/
setTimeout("setFunction();", 100);
setTimeout("setFunction();", 500);
setTimeout("setFunction();", 1000);
setTimeout("setFunction();", 2000);
setTimeout("setFunction();", 4000);
function setFunction() {
	if (document != null) {
		if (document.body != null) {
			document.body.oncontextmenu = disableViewSource;
			document.body.onkeydown = disableBackspace;
		}
	}
}
function disableViewSource() {
	/*if ("" + event.target.type != "undefined") {
		return true;
	} else {
		if (event.target.disabled) {
			return false;
		} else {
			alert(getMessage("WELCOME", "Common"));
		}
	}
	return false;*/
	return true;
}
function disableBackspace() {
	if (event.keyCode == 113) {
		lockKey();
	}
	if (("" + event.target.type == "undefined") && (event.keyCode == 8)) {
		return false;
	}
}
/**/
function checkForNonZeroNumber(obj) {
	//alert("checkForNonZeroNumber");
	if (isNaN(obj.value)) {
		alert(getMessage("INVALID_NUMBER_FORMAT", "Common"));
		obj.value=""; //Edge
		obj.select();
		obj.focus();
		return false;
	} else {
		if (parseFloat(obj.value) == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
			obj.value=""; //Edge
			obj.select();
			obj.focus();
			return false;
		} else {
			return true;
		}
	}
}
function toUpperCase(ev) {
	asciiCode = ev.keyCode;
	if ((asciiCode >= 97) && (asciiCode <= 122)) {
		ev.keyCode = asciiCode - 32;
	}
}
function convertToUpperCase(obj) {
	obj.value = obj.value.toUpperCase();
}


//////////////////////////////////ValidateControl version........................
function isValidInteger() {
	var key = window.event.keyCode;
	if (!(key >= 48 && key <= 57)) {
		return false;
	} else {
		return true;
	}
}

// Function added to check positive as well as negative numbers
function isValidIntegerForAllNumbers() {
	var key = window.event.keyCode;
	if (!(key >= 48 && key <= 57)) {
		return false;
	} else {
		return true;
	}
}
function isValidNumber(fld, e, maxInt, deci) {
	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - Code added to accept decimal values dynamically.
	*/
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

function assignResult(_result, _message, _flag, _invalidCode) {
	result = _result;
	message = _message;
	flag = _flag;
	if (_invalidCode == null) {
		_invalidCode = "";
	}
	invalidCode = _invalidCode;
}
function clearListItems(listObject) {
	var select_option = "---" + getLabel("Common.defaultSelect.label", "Common") + "---";
	var len = eval(listObject + ".options.length");
	for (i = 0; i < len; i++) {
		eval(listObject + ".remove(0)");
	}
	var listOption = createListOption("", select_option);
	eval(listObject + ".add(listOption)");
}
function clearListItemsNoSelect(listObject) {
	var select_option = "---" + getLabel("Common.defaultSelect.label", "Common") + "---";
	var len = eval(listObject + ".options.length");
	for (i = 0; i < len; i++) {
		eval(listObject + ".remove(0)");
	}
	//var listOption = createListOption("", select_option);
	//eval(listObject + ".add(listOption)");
}
function addListItem(listObject, code, text, selectedValue) {
	if (selectedValue == null) {
		selectedValue = "";
	}
	var listOption = createListOption(code, text, selectedValue);
	eval(listObject + ".add(listOption)");
}
function createListOption(code, text, selectedValue) {
	var listOption = document.createElement("OPTION");
	listOption.text = text;
	listOption.value = code;
	if (code == selectedValue) {
		listOption.selected = true;
	}
	return listOption;
}
function clickYes() {
	parent.window.returnValue = YES;
	parent.window.close();
	return returnValue;
}
function clickNo() {
	parent.window.returnValue = NO;
	parent.window.close();
	return returnValue;
}
function displayMessage(messageFrame, HTMLMessage) {
	messageFrame.document.open();
	messageFrame.document.writeln("<html><head><link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link></head><body class=\"MESSAGE\">" + HTMLMessage + "</body></html>");
	messageFrame.document.close();
}
function resetColorCode(formObj, currObject) {
	var arrPKFieldNames = new Array();
	var startIndex = 0;
	arrPKFieldNames[0] = "code_";
	resetDuplicateClass(formObj, arrPKFieldNames, startIndex, currObject);
}
function getXMLString(arrayObject) {
	xmlStr = "<root><SEARCH ";
	if (arrayObject != null) {
		for (index = 0; index < arrayObject.length; index++) {
			xmlStr += arrayObject[index].name + "=\"" + arrayObject[index].value + "\" ";
		}
	}
	xmlStr += " /></root>";
	return xmlStr;
}
function getEnhancedXMLString(frmObj) {
	var arrObj = frmObj.elements;
	var frmObjs = new Array();
	if (frmObj.name == null) {
		frmObjs = frmObj;
	} else {
		frmObjs[0] = frmObj;
	}
	var xmlStr = "<root><SEARCH ";
	for (var frmCount = 0; frmCount < frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount];
		var arrObj = frmObj.elements;
		for (var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				if (arrObj[i].checked) {
					val = "Y";
				} else {
					val = "N";
				}
				if (arrObj[i].name != null && arrObj[i].name != "") {
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
				}
			} else {
				if (arrObj[i].type == "radio") {
					if (arrObj[i].checked) {
						val = arrObj[i].value;
						if (arrObj[i].name != null && arrObj[i].name != "") {
							xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
						}
					}
				} else {
					if (arrObj[i].type == "select-multiple") {
						for (var j = 0; j < arrObj[i].options.length; j++) {
							if (arrObj[i].options[j].selected) {
								val += arrObj[i].options[j].value + "~";
							}
						}
						val = val.substring(0, val.lastIndexOf("~"));
						if (arrObj[i].name != null && arrObj[i].name != "") {
							xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
						}
					} else {
						val = arrObj[i].value;
						if (arrObj[i].name != null && arrObj[i].name != "") {
							xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
						}
					}
				}
			}
		}
	}
	xmlStr += " /></root>";
	return xmlStr;
}
function setTextAreaMaxLength(obj, len) {
	return (obj.value.length < len) ? true : false;
}
function checkSpecialChars(obj) {
	if (obj.value == "") {
		return;
	} 
	if (!CheckChars(obj)) {
	     //commented by Rabbani #INC no:38382 on 06-FEB-2013 
		//alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED", "PH"));
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED", "ST"));
		obj.value=""; //Edge
		obj.focus();
		return false;
	}
	return true;
}
function checkIntegerFormat(obj, zeroNotAllowed) {
	if (zeroNotAllowed == null) {
		zeroNotAllowed = true;
	}
	//alert("checkIntegerFormat");
	if (obj.value == "") {
		return;
	}
	if (!isValidIntegerFormat(obj)) {
		alert(getMessage("INVALID_NUMBER_FORMAT", "PH"));
		obj.value = "";
		obj.focus();
		return false;
	} else {
		if ((parseFloat(obj.value) == 0) && zeroNotAllowed) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
			obj.value = "";
			obj.focus();
			return false;
		}
	}
	return true;
}
function isValidIntegerZero(obj) {
	//alert("isValidIntegerZero");
	if (obj.value == "") {
		return;
	}
	if (!isValidIntegerFormat(obj)) {
		alert(getMessage("INVALID_NUMBER_FORMAT", "Common"));
		obj.value = "";
		obj.focus();
		return false;
	}
	return true;
}
function checkDoubleFormat(obj, zeroNotAllowed) {
	//alert("checkDoubleFormat");
	if (zeroNotAllowed == null) {
		zeroNotAllowed = true;
	}
	validDigits = "0123456789.";
	for (i = 0; i < obj.value.length; i++) {
		if (validDigits.indexOf(obj.value.charAt(i)) == -1) {
			//alert("32432");
			alert(getMessage("INVALID_NUMBER_FORMAT", "Common"));
			obj.value=""; //Edge Having issue as it is going in loop, so have to clear.
			obj.focus();
			return false;
		}
	}
	if (!isValidDoubleFormat(obj)) {
		//alert("!isValidDoubleFormat(obj)");
		alert(getMessage("INVALID_NUMBER_FORMAT", "Common"));
		obj.value = "";//Edge Having issue as it is going in loop, so have to clear.
		obj.focus();
		return false;
	} else {
		if ((parseFloat(obj.value) == 0) && zeroNotAllowed) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
			obj.value = "";
			obj.focus();
			return false;
		}
	}
	return true;
}
function isValidIntegerFormat(Obj) {
	var str = Obj.value;
	var validIntegerExists = true;
	for (u = 0; u < str.length; u++) {
		if (!((str.charCodeAt(u) >= 48) && (str.charCodeAt(u) <= 57))) {
			validIntegerExists = false;
			break;
		}
	}
	return validIntegerExists;
}
function isValidDoubleFormat(Obj) {
	var str = Obj.value;
	var validDoubleExists = true;
	var totalDecimal = 0;
	for (u = 0; u < str.length; u++) {
		if (str.charCodeAt(u) == 46) {
			totalDecimal++;
			if (totalDecimal > 1) {
				validDoubleExists = false;
				break;
			}
		}
		if (!(((str.charCodeAt(u) >= 48) && (str.charCodeAt(u) <= 57)) || (str.charCodeAt(u) == 46))) {
			validDoubleExists = false;
			break;
		}
	}
	return validDoubleExists;
}
function checkDateWithSysDate(entered_date, sys_date) {
	//alert("entered_date value : "+entered_date.getDate());
	//alert("sys_date : "+sys_date);
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	//alert("sysDate : "+sysDate);
	//alert("enteredDate : "+enteredDate);
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
			return false;
		} else {
			if (Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}
/*
function isValidFromToField(fromObj, toObj, dataType, stLegend, messageFrame, errorPage){
	var bReturn	= true;
	var stFromValue	=	fromObj.value;
	var stToValue	=	toObj.value;
	if( (!trimCheck(stFromValue)) || (!trimCheck(stToValue)) ) {
		return bReturn;
	}
	if (dataType==null) 
		dataType=STRING;

	switch (dataType)
	{
		case INT:
		case LONG:
		case FLOAT:
		case DOUBLE:
			if(parseFloat(stFromValue)>parseFloat(stToValue))
				bReturn=false;	
			break;
		case DATE:
            var arFromDate	= stFromValue.split("/");
            var arToDate	= stToValue.split("/");
            if(Date.parse(""+arFromDate[1]+"/"+arFromDate[0]+"/"+arFromDate[2]+"/") > Date.parse(""+arToDate[1]+"/"+arToDate[0]+"/"+arToDate[2]+"/"))
				bReturn=false;
			break;
		default:
			if(stFromValue>stToValue)
				bReturn=false;	
	}
	
	if ( (!bReturn) && (messageFrame!=null)){
		if (errorPage==null) 
			errorPage="../../eCommon/jsp/error.jsp";
		var stMessage	=	getMessage("LESS_OR_EQUAL");
		stMessage		=	stMessage.replace(/@/g, stLegend)
		messageFrame.location.href=errorPage+"?err_num="+stMessage;
		toObj.focus();
	}

	return bReturn;
}
*/
/* 1 - Item */
/* type_code - Optional */
/* function_type - Default '1' */
function validateCommonCodeSearch(code, desc, function_type, type_code) {
	if (desc.value == "" || desc.readOnly || desc.disabled) {
		return true;
	}
	if (function_type == null) {
		function_type = "1";
	}
	//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	var arrayObjects = new Array();
	arrayObjects[0] = code;
	arrayObjects[1] = desc;
	if (type_code != null) {
		arrayObjects[2] = type_code;
	}
	var xmlString = "";
	for (index = 0; index < arrayObjects.length; index++) {
		xmlString += arrayObjects[index].name + "=\"" + checkSpl(arrayObjects[index].value) + "\" ";
	}
	xmlString += " function_type=\"" + function_type + "\"";
	xmlString = "<root><SEARCH " + xmlString + " /></root>";
	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		desc.focus();
		return result;
	}
	desc.readOnly = true;
	return result;
	/*
	var msgFrame = top.content.messageFrame;
	if (!result) {
		msgFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+message;
		desc.focus();
		return result;
	}
	desc.readOnly = true;
	msgFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	*/
}
function isValidFromToField(fromObj, toObj, dataType, stLegend, messageFrame, errorPage) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue.toUpperCase() > stToValue.toUpperCase()) {
			bReturn = false;
		}
	}
	if ((!bReturn) && (messageFrame != null)) {
		if (errorPage == null) {
			errorPage = "../../eCommon/jsp/error.jsp";
		}
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		messageFrame.location.href = errorPage + "?err_num=" + stMessage;
		toObj.focus();
	}
	return bReturn;
}
/* Modified on 5/31/2005 by Ram chkitemstorecmb is added to display the  item check check box in  item search  query criteria page and it is used to check the item which exist in both the stores. If that check box is checked it will display the items which is associated in both the stores and also have qty_on_hand >0 . If  there is no to_store  code , then assign blank to it. Used in the function which  has two stores eg.. Issue  */
/*function callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, chkitemstorecmb, to_store_code, store_disable, item_class_desc, kit, direct_sale) {
	retVal = window.showModalDialog("../../eST/jsp/ItemSearch.jsp?search_string=" + encodeURIComponent(search_string,"UTF-8") + "&store_code=" + store_code + "&category=" + category + "&sole_source=" + sole_source + "&ps_item=" + ps_item + "&mfg_item=" + mfg_item + "&expiry=" + expiry + "&item_class=" + item_class + "&consignment=" + consignment + "&chkitemstorecmb=" + chkitemstorecmb + "&to_store_code=" + to_store_code + "&store_disable=" + store_disable + "&kit=" + kit + "&direct_sale=" + direct_sale + "&item_class_desc=" + item_class_desc, "", "dialogHeight:38; dialogWidth:55; center:0; status: no; dialogLeft :115; dialogTop :125;");
	//retVal=window.open("../jsp/ItemSearch.jsp?search_string="+search_string+"&store_code="+store_code+"&category="+category+"&sole_source="+sole_source+"&ps_item="+ps_item+"&mfg_item="+mfg_item+"&expiry="+expiry+"&item_class="+item_class,'','dialogHeight:30; dialogWidth:50; center:0; status: no; dialogLeft :200; dialogTop :100;');
	return retVal;
}*/
//Modified By sakti against against AMRI-CRF-100024 and AMS-CRF-0028 increased width of dialogue window from 55 to 65
//Modified by Sakti against AMS-CRF-0011 trn_type passing
async function callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,trn_type, chkitemstorecmb, to_store_code, store_disable, item_class_desc, kit, direct_sale) {
	retVal = await top.window.showModalDialog("../../eST/jsp/ItemSearch.jsp?search_string=" + encodeURIComponent(search_string,"UTF-8") + "&store_code=" + store_code + "&category=" + category + "&sole_source=" + sole_source + "&ps_item=" + ps_item + "&mfg_item=" + mfg_item + "&expiry=" + expiry + "&item_class=" + item_class + "&consignment=" + consignment + "&chkitemstorecmb=" + chkitemstorecmb + "&to_store_code=" + to_store_code + "&store_disable=" + store_disable + "&kit=" + kit + "&direct_sale=" + direct_sale + "&item_class_desc=" + item_class_desc+ "&trn_type=" + trn_type, "", "dialogHeight:90vh; dialogWidth:90vw; center:0; status: no; dialogLeft :50; dialogTop :10;");
	//retVal=window.open("../jsp/ItemSearch.jsp?search_string="+search_string+"&store_code="+store_code+"&category="+category+"&sole_source="+sole_source+"&ps_item="+ps_item+"&mfg_item="+mfg_item+"&expiry="+expiry+"&item_class="+item_class,'','dialogHeight:30; dialogWidth:50; center:0; status: no; dialogLeft :200; dialogTop :100;');
	return retVal;
}

//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 beg
async function callItemSearchWindow_PRD(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,trn_type,search_no, chkitemstorecmb, to_store_code, store_disable, item_class_desc, kit, direct_sale) {
	retVal =await top.window.showModalDialog("../../eST/jsp/ItemSearch.jsp?search_string=" + encodeURIComponent(search_string,"UTF-8") + "&store_code=" + store_code + "&category=" + category + "&sole_source=" + sole_source + "&ps_item=" + ps_item + "&mfg_item=" + mfg_item + "&expiry=" + expiry + "&item_class=" + item_class + "&consignment=" + consignment + "&chkitemstorecmb=" + chkitemstorecmb + "&to_store_code=" + to_store_code + "&store_disable=" + store_disable + "&kit=" + kit + "&direct_sale=" + direct_sale + "&item_class_desc=" + item_class_desc+ "&trn_type=" + trn_type + "&search_no="+search_no , "", "dialogHeight:90vh; dialogWidth:90vw; center:0; status: no; dialogLeft :15; dialogTop :15;");
	return retVal;
}
//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 end

// Added on 10/1/2005  by RAM for itemsearch which includes "array_itemsearch " as a parameter . It  is used to customize the query based upon the function eg. Assembly and manufacturing request function
/*function callItemSearchWindowParam(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, array_itemsearch) {
	retVal = window.showModalDialog("../jsp/ItemSearch.jsp?search_string=" + escape(search_string) + "&store_code=" + store_code + "&category=" + category + "&sole_source=" + sole_source + "&ps_item=" + ps_item + "&mfg_item=" + mfg_item + "&expiry=" + expiry + "&item_class=" + item_class + "&consignment=" + consignment + "&array_itemsearch=" + array_itemsearch, "", "dialogHeight:35; dialogWidth:57; center:0; status: no; dialogLeft :90; dialogTop :125;");
	return retVal;
}*/
//Modified By sakti against against AMRI-CRF-100024 and AMS-CRF-0028  increased width of dialogue window from 57 to 65
async function callItemSearchWindowParam(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, array_itemsearch,trn_type) {
	retVal =await top.window.showModalDialog("../../eST/jsp/ItemSearch.jsp?search_string=" + escape(search_string) + "&store_code=" + store_code + "&category=" + category + "&sole_source=" + sole_source + "&ps_item=" + ps_item + "&mfg_item=" + mfg_item + "&expiry=" + expiry + "&item_class=" + item_class + "&consignment=" + consignment + "&array_itemsearch=" + array_itemsearch+ "&trn_type=" + trn_type, "", "dialogHeight:90vh; dialogWidth:90vw; center:0; status: no; dialogLeft :50; dialogTop :10;");
	return retVal;
}
/* Commented on 5/31/2005  since  function is modified to include  2 extra parameter  chkitemstorecmb and to_store_code
function callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,item_class,consignment)
{
retVal=window.open("../jsp/ItemSearch.jsp?search_string="+search_string+"&store_code="+store_code+"&category="+category+"&sole_source="+sole_source+"&ps_item="+ps_item+"&mfg_item="+mfg_item+"&expiry="+expiry+"&item_class="+item_class,'','dialogHeight:30; dialogWidth:50; center:0; status: no; dialogLeft :200; dialogTop :100;');
}*/
async function callBatchSearchWindow(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, cuttOffDate, doc_type_code, doc_no, trn_type,itemStoreDisable,called_from,item_qty,temp_conv) {//Added called_from,item_qty,temp_conv for TH-KW-CRF-0043
	if (cuttOffDate == null) {
		cuttOffDate = "";
	}
	if (doc_type_code == null) {
		doc_type_code = "";
	}
	if (doc_no == null) {
		doc_no = "";
	}
	if (trn_type == null) {
		trn_type = "";
	}
	retVal = await top.window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code=" + item_code + "&store_code=" + store_code + "&includeZeroStockBatches=" + includeZeroStockBatches + "&includeExpiredBatches=" + includeExpiredBatches + "&includeSuspendedBatches=" + includeSuspendedBatches + "&searchFunction=" + searchFunction + "&multipleSelect=" + multipleSelect + "&cuttOffDate=" + cuttOffDate + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&trn_type=" + trn_type+"&called_from="+called_from+"&item_qty="+item_qty+"&temp_conv="+temp_conv+"&itemStoreDisable="+itemStoreDisable, "", "dialogHeight:70vh; dialogWidth:70vw; center:0; status: no; dialogLeft :10px; dialogTop :10px;");//called_from,item_qty,temp_conv added for TH-KW-CRF-0043
//alert("Inside StCommon..");
//alert(retVal);
	//retVal=window.open("../jsp/ItemSearch.jsp?search_string="+search_string+"&store_code="+store_code+"&category="+category+"&sole_source="+sole_source+"&ps_item="+ps_item+"&mfg_item="+mfg_item+"&expiry="+expiry+"&item_class="+item_class,'','dialogHeight:30; dialogWidth:50; center:0; status: no; dialogLeft :200; dialogTop :100;');
	return retVal;
}
function checkDateWithSysDate(entered_date, sys_date) {
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			return false;
		} else {
			if (Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}

function checkdateWithSysDateTo(entered_date, sys_date) {
	/* Entered Date Should not be less than sysdate Krishna 1/13/2009 */
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) {
				
			return false;
		} else {
			if (Date.parse(sysDateObject) > Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}

// Function added to check and accept positive and negative numbers.
function checkDoubleFormatForAllNumbers(obj) {
	//alert("checkDoubleFormatForAllNumbers");
	validDigits = "0123456789.-";
	for (i = 0; i < obj.value.length; i++) {
		if (validDigits.indexOf(obj.value.charAt(i)) == -1) {
			alert(getMessage("INVALID_NUMBER_FORMAT", "Common"));
			obj.value=""; //Edge
			obj.focus();
			return false;
		}
	}
	if (!isValidDoubleFormatForAllNumbers(obj)) {
		//alert("!isValidDoubleFormatForAllNumbers(obj)");
		alert(getMessage("INVALID_NUMBER_FORMAT", "Common"));
		obj.value=""; //Edge
		obj.focus();
		return false;
	}
	/*else if(parseFloat(obj.value)==0){
        alert(getMessage("CANNOT_BE_ZERO"));
        obj.focus();
        return false;
	}*/
	return true;
}

// Function to check and add positive as  well as negative numebers.
function isValidDoubleFormatForAllNumbers(Obj) {
	var str = Obj.value;
	var validDoubleExists = true;
	var totalDecimal = 0;
	for (u = 0; u < str.length; u++) {
		if (str.charCodeAt(u) == 46) {
			totalDecimal++;
			if (totalDecimal > 1) {
				validDoubleExists = false;
				break;
			}
		}
		if (!(((str.charCodeAt(u) >= 48) && (str.charCodeAt(u) <= 57)) || (str.charCodeAt(u) == 46) || (str.charCodeAt(u) == 45))) {
			validDoubleExists = false;
			break;
		}
		if (str.charCodeAt(u) == 45 && u > 0) {
			validDoubleExists = false;
			break;
		}
	}
	if (str.length == 1 && str.charCodeAt(0) == 45) {
		validDoubleExists = false;
	}
	return validDoubleExists;
}
function checkDateNotLessSysDate(entered_date, sys_date) {
	//alert("entered_date value : "+entered_date.getDate());
	//alert("sys_date : "+sys_date);
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	//alert("sysDate : "+sysDate);
	//alert("enteredDate : "+enteredDate);
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) > Date.parse(enteredDateObject)) {
			return false;
		} else {
			if (Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}
function checkForAvaliableQty(obj1, obj2) {
	if (parseFloat(obj1.value) > parseFloat(obj2)) {
		alert(getMessage("REQ_QTY_NOT_GR_PEND_QTY", "ST"));
		obj1.focus();
		return false;
	}
	return true;
}
/*function checkSTFields( fields, names, messageFrame) {
    var errors = "" ;
	//alert("names--"+names);
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else {
			//alert("123--");
			//alert("");
			//alert
			errors += getSTMessage("SHOULD_NOT_BE_BLANK","Common",new Array(names[i]))+"<br>"
			//alert(errors);
		}
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;

        return false ;
    }
    return true ;
}

function getSTMessage( message_ref, moduleId, param ) {
	if(param ==null)	param = new Array()

//alert("param--"+param);
  var xmlHttp
		if(navigator.appName.indexOf("Internet") ==-1)
			xmlHttp = new XMLHttpRequest();
		else
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");


		message_ref=message_ref.toUpperCase();
		moduleId = moduleId.toLowerCase()
//alert("message_ref--"+message_ref);
//alert("moduleId--"+moduleId);

		var urlString ="?msgId="+message_ref+"&moduleId="+moduleId

			for(var i=1;i<=param.length;i++) {
				urlString +="&"+i+"="+param[i-1]
			}
//alert("urlString"+urlString);
		xmlHttp.open("POST","../../eCommon/jsp/MessageContainer.jsp"+urlString, false);
		xmlHttp.setRequestHeader("Content-Type","text/html;charset=UTF-8")
		xmlHttp.send();

		var xmlText = xmlHttp.responseText
		//alert("xmlText"+xmlText);
		return(TrimStr(xmlHttp.responseText))
		    
}

if(checkFields1( fields, names))
				return true;
			else
				return false;*/
function checkSTFields(fields, names, messageFrame) {
	
	var errors = "";
	for (var i = 0; i < fields.length; i++) {
		if (trimSTCheck(fields[i].value)) {
		} else {
				//;var msg_1=getMessage("SHOULD_NOT_BE_BLANK","Common");
			var msg_1 = getLabel("Common.Cannotbeblank.label", "Common");
			
				//alert("msg_1--"+msg_1);
				//alert("names[i]--"+names[i]);
			errors += " APP-000001 " + names[i] + "   " + msg_1 + "<br>";
		}
	}
	if (errors.length != 0) {
		messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num=" + errors;
			//alert(errors) ;
		return false;
	}
	return true;
}
function trimSTCheck(inString) {
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;
	for (var i = 0; i <= strlength; i++) {
		ch = inString.charAt(startPos);
		if ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if (startPos == inString.length) {
		return false;
	} else {
		return true;
	}
}
function getSTBlankField(fields, legends, messageFrame, errorPage) {
	var obj = null;
	var errors = "";
	if (errorPage == null) {
		errorPage = "../../eCommon/jsp/error.jsp";
	}
	for (var i = 0; i < fields.length; i++) {
		if (trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		} else {
			if (obj == null) {
				obj = fields[i];
			}
			errors = errors + "APP-000001 " + legends[i] + getLabel("Common.Cannotbeblank.label", "Common") + "<br>";
		}
	}
	if (errors.length != 0) {
		messageFrame.location.href = errorPage + "?err_num=" + errors;
	}
	return obj;
}
function checkSTMandatoryFields(fields, names, messageFrame, errorPage) {
	var errors = "", firstNullObject = null;
    //alert("Total No of Fields : "+fields.length);
	for (var i = 0; i < fields.length; i++) {
		if (trimString(fields[i].value) != "") {
			fields[i].value = trimString(fields[i].value);
		} else {
			if (errors.length == 0) {
				firstNullObject = fields[i];
			}
			errors = errors + "APP-000001 " + names[i] + getLabel("Common.Cannotbeblank.label", "Common") + "<br>";
		}
	}
	if (errors.length != 0) {
		displayErrorMessage(errors, messageFrame, "", null, errorPage);
        //messageFrame.document.location.href   =   "../../eCommon/jsp/error.jsp?err_num=" + errors ;
	}
	return firstNullObject;
}
function validateSTMandatoryFields(formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage) {
	/**
      * Initialize default values
      */
	if (startIndex == null) {
		startIndex = 0;
	}
	if (objMessageFrame == null) {
		objMessageFrame = messageFrame;
	} else {
		messageFrame = objMessageFrame;
	}
//    else                        objMessageFrame =   null;
	if (errorPage == null) {
		errorPage = "../../eCommon/jsp/error.jsp";
	}
	var fields = new Array();
	var names = new Array();
	var masterCodes = new Array();
	var arrPKFields = null;
	var notNullIndex = 0;
	var currRowIndex = 0;
	var masterIndex = 0;
	var pkIndex = 0;
	var uniqueFields = "";
	var totalRecords = formObj.totalRecords.value;
	var totalColumns = arrFieldName.length;
	var totalPKColumns = arrPKFieldNames.length;
	totalRecords = parseFloat(totalRecords) + parseFloat(startIndex);
    //alert("totalRecords : "+totalRecords);
    //alert("totalColumns : "+totalColumns);
    //alert("totalPKColumns : "+totalPKColumns);
	/**
      * Identify the rows and respective columns in the form, which has some values entered.
      */
	for (var rowIndex = startIndex; rowIndex < totalRecords; rowIndex++) {
		var isNotNull = false;
		for (var colIndex = 0; colIndex < totalColumns; colIndex++) {
			current_field = eval("formObj." + arrFieldName[colIndex] + rowIndex);
			//alert("current_field--"+current_field);
			if (trimString(current_field.value) != "") {
				isNotNull = true;
				break;
			}
		}
//        alert("isNotNull : "+isNotNull);
		if (isNotNull) {
			currRowIndex = rowIndex + 1;
			arrPKFields = new Array();
			pkIndex = 0;
			for (var colIndex = 0; colIndex < totalColumns; colIndex++) {
				current_field = eval("formObj." + arrFieldName[colIndex] + rowIndex);
				if ((uniqueFields.indexOf(arrFieldName[colIndex]) == -1) && (trimString(current_field.value) == "")) {
					fields[notNullIndex] = current_field;
					names[notNullIndex++] = arrLegends[colIndex]; // + " #" + currRowIndex; //" %23" + currRowIndex;
					uniqueFields += current_field.name + " ";
				}
				if (colIndex < totalPKColumns) {
					pk_field = eval("formObj." + arrPKFieldNames[colIndex] + rowIndex);
					if (current_field.name == pk_field.name) {
						arrPKFields[pkIndex++] = pk_field;
					}
				}
			}
			masterCodes[masterIndex++] = arrPKFields;
		}
	}
	/**
      * If there are no values entered, the length will be zero, so alert and return.
      */
	if (masterCodes.length == 0) {
		var error_msg = getMessage("ATLEAST_ONE_RECORD_ENTERED", "Common");
		showErrorMessage(error_msg, objMessageFrame, "", "", errorPage);
//		showErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame )
		formObj.document.parentWindow.FocusFirstElement();
		return false;
	}
	/**
      * Check for the duplicating primary key columns by calling the returnDuplicates function.
      */
	var arrDuplicate = returnDuplicates(masterCodes);
	/**
      * The first index of the array will contain duplicating primary keys seperated by a delimiter ", ".
      */
	var duplicateCodes = arrDuplicate[0];
	/**
      * The second index of the array will contain duplicating primary key fields as an Array.
      */
	var duplicateField = arrDuplicate[1];
	/**
      * The third index of the array will contain duplicating primary key fields description
      * seperated by the delimeter ", " in the case of a input type is a select item.
      */
	var duplicateCodesValue = arrDuplicate[2];
	if (duplicateCodesValue == null) {
		duplicateCodesValue = "";
	}

    //alert("duplicateCodesValue : "+duplicateCodesValue);
	var inputType = "text";
	var duplicateValue = "";
	/**
      * Check for the duplicate primary key fields and if any, display the error message and
      * mark the first duplicating primary key fields using the css class "DUPLICATE".
      */
	if (duplicateCodes != "") {
		var duplicateCode = "";
		var firstIndex = duplicateCodes.indexOf(",");
		if (firstIndex == -1) {
			firstIndex = duplicateCodes.length;
		}
		var firstDuplicate = duplicateCodes.substring(0, firstIndex);
		var startingIndex = 0;
		for (var i = 0; i < duplicateField.length; i++) {
			duplicatePKFields = duplicateField[i];
			for (var pkIndex = 0; pkIndex < duplicatePKFields.length; pkIndex++) {
				if ((pkIndex % totalPKColumns) < totalPKColumns) {
					duplicateCode += duplicatePKFields[pkIndex].value + ":";
				}
				if ((pkIndex % totalPKColumns) == (totalPKColumns - 1)) {
					duplicateCode = duplicateCode.substring(0, duplicateCode.length - 1);
					if (firstDuplicate == duplicateCode) {
						for (var j = startingIndex; j <= pkIndex; j++) {
							if ((pkIndex - startingIndex) <= totalPKColumns) {
								duplicatePKFields[j].className = "DUPLICATE";
							}
						}
						startingIndex = pkIndex;
					}
					duplicateCode = "";
				}
			}
		}
		duplicatePKFields = duplicateField[0];
		if (duplicatePKFields[0].type == "select-one") {
			inputType = "select-one";
		}
		var error_msg = getMessage("DUPLICATE_CODE_EXISTS","Common") + " : ";
		if (inputType == "text") {
			error_msg += duplicateCodes;
		} else {
			if (inputType == "select-one") {
				error_msg += duplicateCodesValue;
			}
		}
		displayErrorMessage(error_msg, objMessageFrame, "", null, errorPage);
		if (inputType != "select-one") {
			duplicatePKFields[0].select();
		}
		duplicatePKFields[0].focus();
		return false;
	}
	/**
      * Check for the mandatory fields, if anything is left out.
      * if anything left out, display the error message and return "false"
      * otherwise, return "true" to indicate the operation is success.
      */
	var firstNullObject = checkSTMandatoryFields(fields, names, objMessageFrame, errorPage);
	if (firstNullObject != null) {
		firstNullObject.className = "DUPLICATE";
		firstNullObject.focus();
		return false;
	} else {
		return true;
	}
}
function isSTValidFromToField(fromObj, toObj, dataType, stLegend, messageFrame, errorPage) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue.toUpperCase() > stToValue.toUpperCase()) {
			bReturn = false;
		}
	}
//alert(bReturn);
//alert(messageFrame);
	if ((!bReturn) && (messageFrame != null)) {
		if (errorPage == null) {
			errorPage = "../../eCommon/jsp/error.jsp";
		}
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		//alert(stMessage);
		stMessage = stMessage.replace(/@/g, stLegend);
		messageFrame.location.href = errorPage + "?err_num=" + stMessage;
		toObj.focus();
	}
	return bReturn;
}
function doDateCheck(from, to, messageFrame) {
	var fromarray;
	var toarray;
	var fromdate = from.value;
	var todate = to.value;
	var arr = new Array(todate, fromdate);
	if (fromdate.length > 0 && todate.length > 0) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2], fromarray[1] - 1, fromarray[0]);
		var todt = new Date(toarray[2], toarray[1] - 1, toarray[0]);
		if (Date.parse(todt) < Date.parse(fromdt)) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("TO_DT_GR_FM_DT", "ST");
			return false;
		} else {
			if (Date.parse(todt) >= Date.parse(fromdt)) {
				return true;
			}
		}
	}
	return true;
}
/*function lockKey() {
	whichCode = event.keyCode;
	if (whichCode == 93) {
		var error = getMessage("WELCOME", "common");
		alert(error);
	} else {
		if (whichCode == 113) {
			var width = 800;
			var height = 550;
			var left = (window.screen.availWidth - width) / 2;
			var top = (window.screen.availHeight - height) / 2;
			var myBars = "directories=no,location=no,menubar=no,status=no";
			var myOptions = "width=" + width + ", height=" + height + ", resizable=no";
			var myFeatures = myBars + ", " + myOptions;
		// var helpWindow = open( '../../eCommon/jsp/help.jsp?url='+document.location.href, 'eHIS', myFeatures ) 
			var helpWindow = open("../../OnlineHelp/webhelp.jsp?url=" + document.location.href, "eHIS", myFeatures);
		}
	}
}*/

function setNumberForNumberFormat (objVal,_d){
	var _v="";
	decobjVal="";
	if (objVal.indexOf(".") > 0)
		{
			_v  =  objVal.substring(0,objVal.indexOf("."));
			decobjVal = objVal.substring(objVal.indexOf("."),objVal.length);		
		}else{
			_v = objVal;
		}


	var v = String(_v).replace(/[^\d.-]*/gi, ""), m = "###,###";
	// make sure there's only one decimal point
	v = v.replace(/\./, "d").replace(/\./g, "").replace(/d/, ".");

	// check to see if an invalid mask operation has been entered
	if( !/^[\$]?((\$?[\+-]?([0#]{1,3},)?[0#]*(\.[0#]*)?)|([\+-]?\([\+-]?([0#]{1,3},)?[0#]*(\.[0#]*)?\)))$/.test(m) )
		return this.throwError(1, "An invalid mask was specified for the \nMask constructor.", _v);

	if( (_d == true) && (v.length == this.strippedValue.length) ) v = v.substring(0, v.length-1);

	if( this.allowPartial && (v.replace(/[^0-9]/, "").length == 0) ) return v;
	this.strippedValue = v;

	if( v.length == 0 ) v = NaN;
	var vn = Number(v);
	if( isNaN(vn) ) return this.throwError(2, "The value entered was not a number.", _v);

	// if no mask, stop processing
	if( m.length == 0 ) return v;

	// get the value before the decimal point
	var vi = String(Math.abs((v.indexOf(".") > -1 ) ? v.split(".")[0] : v));
	// get the value after the decimal point
	var vd = (v.indexOf(".") > -1) ? v.split(".")[1] : "";
	var _vd = vd;

	var isNegative = (vn != 0 && Math.abs(vn)*-1 == vn);

	// check for masking operations
	var show = {
		"$" : /^[\$]/.test(m),
		"(": (isNegative && (m.indexOf("(") > -1)),
		"+" : ( (m.indexOf("+") != -1) && !isNegative )
	}
	show["-"] = (isNegative && (!show["("] || (m.indexOf("-") != -1)));


	// replace all non-place holders from the mask
	m = m.replace(/[^#0.,]*/gi, "");

	/*
		make sure there are the correct number of decimal places
	*/
	// get number of digits after decimal point in mask
	var dm = (m.indexOf(".") > -1 ) ? m.split(".")[1] : "";
	if( dm.length == 0 ){
		vi = String(Math.round(Number(vi)));
		vd = "";
	} else {
		// find the last zero, which indicates the minimum number
		// of decimal places to show
		var md = dm.lastIndexOf("0")+1;
		// if the number of decimal places is greater than the mask, then round off
		if( vd.length > dm.length ) vd = String(Math.round(Number(vd.substring(0, dm.length + 1))/10));
		// otherwise, pad the string w/the required zeros
		else while( vd.length < md ) vd += "0";
	}

	/*
		pad the int with any necessary zeros
	*/
	// get number of digits before decimal point in mask
	var im = (m.indexOf(".") > -1 ) ? m.split(".")[0] : m;
	im = im.replace(/[^0#]+/gi, "");
	// find the first zero, which indicates the minimum length
	// that the value must be padded w/zeros
	var mv = im.indexOf("0")+1;
	// if there is a zero found, make sure it's padded
	if( mv > 0 ){
		mv = im.length - mv + 1;
		while( vi.length < mv ) vi = "0" + vi;
	}


	/*
		check to see if we need commas in the thousands place holder
	*/
	if( /[#0]+,[#0]{3}/.test(m) ){
		// add the commas as the place holder
		var x = [], i=0, n=Number(vi);
		while( n > 999 ){
			x[i] = "00" + String(n%1000);
			x[i] = x[i].substring(x[i].length - 3);
			n = Math.floor(n/1000);
			i++;
		}
		x[i] = String(n%1000);
		vi = x.reverse().join(",");
	}


	/*
		combine the new value together
	*/
	if( (vd.length > 0 && !this.allowPartial) || ((dm.length > 0) && this.allowPartial && (v.indexOf(".") > -1) && (_vd.length >= vd.length)) ){
		v = vi + "." + vd;
	} else if( (dm.length > 0) && this.allowPartial && (v.indexOf(".") > -1) && (_vd.length < vd.length) ){
		v = vi + "." + _vd;
	} else {
		v = vi;
	}

	if( show["$"] ) v = this.mask.replace(/(^[\$])(.+)/gi, "$") + v;
	if( show["+"] ) v = "+" + v;
	if( show["-"] ) v = "-" + v;
	if( show["("] ) v = "(" + v + ")";
	
	if (decobjVal != "")
		{
			v = v+""+decobjVal;
		}
	return v;
}


// Bar Code implementation starts here  

function callBarCodeApplicable(trntype,formObj,bean_id,bean_name){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=BARCODE_APPL&bean_id="+bean_id+"&bean_name="+bean_name + "&trn_type=" + trntype+ "&formObj=" + formObj +"&BARCODE_YN=TRUE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
//Added for GHL-CRF-0413 starts
function callBarCodeBatchSearchforBarcode1(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){// doc_type_Code added for GHL-CRF-0465
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		//Added against GHL-CRF-0413.2-US002 starts
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value+"&trntype=" + trntype.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALIDATE_ISS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);// alert("responseText"+responseText);
		if(result){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		//Added against GHL-CRF-0413.2-US002 ends
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value +"&trntype=" + trntype.value+ "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALID_BARCODE", false);// trn_type added for GHL-CRF-0456
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText); 
		if(result){
			//Added against GHL-CRF-0413.2-US002 starts
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			//alert(Doc_type_code+"::"+Doc_no);
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&store_code="+fromStore.value+"&toStore="+toStore.value+"&barcode="+ barcode.value+"&trntype=" + trntype.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name +"&BARCODE_YN=TRUE"+"&validate=VALIDATE_ISS_BATCH", false);//GHL-CRF-0465
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText); 
					if(result){
						var resultArray1;
						resultArray1 = message.split(";");
						 var  auth_batch  = 	resultArray1[0];
						 var  newitem  = 	resultArray1[1];
						 var batch_item=resultArray1[2];// added for ICN 65143 against GHL-CRF-0465
						 var item_check = parent.frames[0].document.forms[0].item_code.value;
						 if(item_check != "" ){
							 if(item_check != newitem)
							 auth_batch = false;}
						 if(auth_batch){// added for GHl-CRF-0465
							 var xmlHttp = new XMLHttpRequest();
								var xmlDoc="";
								//xmlDoc.loadXML(getXMLString(null));
								xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
								xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&store_code="+fromStore.value+"&toStore="+toStore.value+"&barcode="+ barcode.value+"&trntype=" + trntype.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name +"&batch_item="+batch_item+"&BARCODE_YN=TRUE"+"&validate=VALIDATE_SCANNED_AUNUTHORIZED_BATCH", false);//GHL-CRF-0465
								xmlHttp.send(xmlDoc);
								responseText = xmlHttp.responseText;
								eval(responseText);
								if(result)
									{
									alert(getMessage("ST_NOT_AUTHORIZED_BATCH", "ST"));
									}//end ICN 65143 against GHL-CRF-0465
						 }
				 	//Added against GHL-CRF-0413.2-US002 ends
				if(parent.frames[1].document.forms[0] != null)
				{
					var index = parent.frames[1].document.forms[0].total_checkboxes.value ;
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					//xmlDoc.loadXML(getXMLString(null));
					xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
					xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&validate=BATCH_EXP_DETAILS"+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name +"&BARCODE_YN=TRUE", false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					eval(responseText);
					if(result){
						var tmp_conv = parent.frames[0].document.forms[0].tmp_conv.value;
						/*Added by Shazana for INC065695 start*/
						if((trntype.value == "SAL" )||(trntype.value == "CON")){
							tmp_conv=parent.frames[1].document.forms[0].tmp_conv.value;

						}
						/*Added by Shazana for INC065695 end*/
						var item_qty = 0;
						if((trntype.value == "URG" )||(trntype.value == "ISS")){
							 item_qty = parent.frames[0].document.forms[0].iss_uom_qty.value;
							 //Modified  for In:073938 Start 
							 var incriment_val=parseFloat(parent.frames[0].document.forms[0].issue_uom_multiples.value);//Added for In:073938
							item_qty=parseFloat(item_qty)+parseFloat(incriment_val);//Added for In:073938
						}else{
						 item_qty = parent.frames[0].document.forms[0].item_qty.value;
						 item_qty++;
						}
                                        //Modified  for In:073938 end
						if(trntype.value == "URG"){
							parent.frames[0].document.forms[0].iss_uom_qty.value =item_qty;
							parent.frames[0].document.forms[0].item_qty.value =(item_qty * parent.frames[0].document.forms[0].batch_multiples.value)/parent.frames[0].document.forms[0].issue_uom_multiples.value;
						}
						else if(trntype.value == "ISS"){//Added against GHL-CRF-0413.2-US002
							parent.frames[0].document.forms[0].iss_uom_qty.value =item_qty;
							parent.frames[0].document.forms[0].item_qty.value =(item_qty * parent.frames[0].document.forms[0].batch_multiples.value)/parent.frames[0].document.forms[0].issue_uom_multiples.value;
							valueChange1(item_qty);
						}
						else{
						parent.frames[0].document.forms[0].item_qty.value =item_qty;
						}
						if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
						parent.frames[0].document.forms[0].tot_item_qty.value = item_qty * tmp_conv;
							}
							 else if(parent.frames[0].document.forms[0].ret_qty!=undefined){
								 parent.frames[0].document.forms[0].ret_qty.value =item_qty * tmp_conv;
							}
						if (parseInt(index)==1 && trntype.value == "SAL"){
							/*Added by Shazana for INC065695*/
						 tmp_conv = parent.frames[1].document.forms[0].tmp_conv.value;
						 /*Added by Shazana for INC065695*/
							parent.frames[1].document.forms[0].item_qty_0.value =  item_qty * tmp_conv;
							if (parseFloat(parent.frames[1].document.forms[0].available_qty_0.value) < parseFloat(item_qty * tmp_conv)) {
								alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
								parent.frames[1].document.forms[0].item_qty_0.value ="";
								parent.frames[1].document.forms[0].item_qty_0.focus();
							}
						}else if (parseInt(index)==1 && ((trntype.value == "URG" )||(trntype.value == "ISS"))){
							var temp_value=parent.frames[1].document.forms[0].item_qty_0.value;// added for GHL-CRF-0465
							parent.frames[1].document.forms[0].item_qty_0.value =  (item_qty * parent.frames[0].document.forms[0].batch_multiples.value)/parent.frames[0].document.forms[0].issue_uom_multiples.value;
							/*Added for GHL-CRf-0465 Start  */
							var old_qty = parent.frames[0].document.forms[0].auth_qty.value;
							var old_qty_1 = parent.frames[0].document.forms[0].auth_qty_1.value;//added for GHL-CRF-465
							 var results=true;
								if(trntype.value == "ISS"){
							var qt_1=parent.frames[1].document.forms[0].item_qty_0.value;
							if(parseFloat(old_qty)==parseFloat(old_qty_1)){// if addedd ICN 65139 against GHL-CRF-0465
							if(parseFloat(old_qty_1)<parseFloat(qt_1/((parent.frames[0].document.forms[0].batch_multiples.value)/(parent.frames[0].document.forms[0].issue_uom_multiples.value)))){//Modified for TFS id: 11896
								results=false;
							}
							else{
								results=true;
							}							
							CheckDtlQuantityBarcode1(0,results,temp_value);
							}
							else //added for GHL-CRF-465
								CheckDtlQuantityBarcode(0);//added for GHL-CRF-465
							
						}else 
							CheckDtlQuantityBarcode(0);
						}//end GHL-CRF-0465
						else{
							var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&validate=ITEM_QTY_INCREMENT"+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
						xmlHttp.send(xmlDoc);
						responseText = xmlHttp.responseText;
						eval(responseText);
						if(result){
							var resultArray	;
							resultArray = message.split(";");
							 var  m   = 	resultArray[0];
							 var itm_qty = eval("parent.frames[1].document.forms[0].item_qty_"+m).value;
							 var item_qty_ = eval("parent.frames[1].document.forms[0].item_qty_"+m);
									 if((trntype.value == "SAL" )||(trntype.value == "CON")){
							    item_qty_.value = parseInt(itm_qty) + parseInt(tmp_conv);
							    if (parseFloat(eval("parent.frames[1].document.forms[0].available_qty_"+m).value) < parseFloat(parseInt(item_qty_.value) )) {
									alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
									item_qty_.value ="";
									item_qty_.focus();
							    }
							 }
							 if((trntype.value == "URG" )||(trntype.value == "ISS")){
								 var batch_multiples = parseInt(parent.frames[0].document.forms[0].batch_multiples.value);
								 var iss_uom_mult = parseInt(parent.frames[0].document.forms[0].issue_uom_multiples.value);
								 var temp_value= item_qty_.value;
								 item_qty_.value =(parseInt(itm_qty)+batch_multiples);// Modified for TFS id: 11896
								 var results=false;// GHL-CRF-0465 start
									var old_qty = parent.frames[0].document.forms[0].auth_qty.value;//added for GHL-CRF-0465
									if(trntype.value == "ISS")
									 {
								 var formObjDtl= parent.frames[1].document.forms[0];
									var _total_checkboxes = formObjDtl.total_checkboxes.value;
									var no_of_decimals=formObjDtl.no_of_decimals.value;
									 //alert(_total_checkboxes);
									var sum = 0;
									var i =0;
									for ( i = 0; i < _total_checkboxes; i++) {
										var qty = eval("formObjDtl.item_qty_" + i).value;
										if (qty == "") {
											qty = 0;
										}
										if (!isNaN(qty)) {
											sum += parseFloat(qty);
										}
									}
									var qt_1=sum;
									var old_qty_1 = parent.frames[0].document.forms[0].auth_qty_1.value;//added for GHL-CRF-465
									if(parseFloat(old_qty_1)==parseFloat(old_qty)){// if addedd ICN 65139 against GHL-CRF-0465
									if(parseFloat(old_qty_1)<parseFloat(qt_1/((parent.frames[0].document.forms[0].batch_multiples.value)/(parent.frames[0].document.forms[0].issue_uom_multiples.value))))//Modified for TFS id: 11896
										results=false;
									else
										results=true;
									CheckDtlQuantityBarcode1(m,results,temp_value);	
							 
							 } CheckDtlQuantityBarcode(m);//added for GHL-CRF-465
							 }else
								 CheckDtlQuantityBarcode(m);
						}// GHL-CRF-0465 END
							}
						}
						if((trntype.value == "URG" )||(trntype.value == "ISS")){
						CheckQuantity(parent.frames[0].document.forms[0].iss_uom_qty);
						}
						else{
						CheckQuantity(parent.frames[0].document.forms[0].item_qty);
						}
						 parent.frames[0].document.forms[0].barcode.value = "";
					}
					else{
						var tmpbarcode  = barcode.value;
						var index = parent.frames[1].document.forms[0].total_checkboxes.value ;
						index++;
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&validate=BARCODECHECK_SAMEITEM"+"&store_code="+fromStore.value+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
						xmlHttp.send(xmlDoc);
						responseText = xmlHttp.responseText;
						eval(responseText);
						if(result)
							{
							//Added against IN:062242 starts
							var xmlHttp = new XMLHttpRequest();
							var xmlDoc="";
							//xmlDoc.loadXML(getXMLString(null));
							xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
							xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&validate=SUSPENDED_YN"+"&store_code="+fromStore.value+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
							xmlHttp.send(xmlDoc);
							responseText = xmlHttp.responseText;
							eval(responseText);
							if(result){
							//Added against IN:062242 ends
							if(parent.parent.frames[0].document.forms[0].store_code != undefined)
								var store_code = parent.parent.frames[0].document.forms[0].store_code.value;
								else
								var store_code = parent.parent.frames[0].document.forms[0].from_store_code.value;
							var index = parent.frames[1].document.forms[0].total_checkboxes.value ;
						var qtyList=[] ;
						if(parent.frames[1].document.forms[0].tmp_conv!=null || parent.frames[1].document.forms[0].tmp_conv!=undefined)// added for script error
						tmp_conv = parent.frames[1].document.forms[0].tmp_conv.value;//Added by Shazana for INC065695
							for(var m=0 ; m< index; m++){
								qtyList.push(	eval("parent.frames[1].document.forms[0].item_qty_"+m).value);
							}
									if((trntype.value == "SAL" )||(trntype.value == "CON"))
							qtyList.push(1*tmp_conv);//Modified by Shazana for INC065695 MMS-DM-CRF-0112
							if((trntype.value == "URG" )||(trntype.value == "ISS"))
								qtyList.push(parent.frames[0].document.forms[0].batch_multiples.value);
							var tmp_conv = parent.frames[0].document.forms[0].tmp_conv.value;
							var item_qty=0;
						 //Modified  for In:073938 start
							if((trntype.value == "URG" )||(trntype.value == "ISS")){
								 item_qty = parent.frames[0].document.forms[0].iss_uom_qty.value;
								 var incriment_val=parseFloat(parent.frames[0].document.forms[0].issue_uom_multiples.value);
									item_qty=parseFloat(item_qty)+parseFloat(incriment_val);
							}
									if((trntype.value == "SAL" )||(trntype.value == "CON"))
										{ //Added by Shazana for INC065695
										item_qty = parent.frames[0].document.forms[0].item_qty.value;
										item_qty++;
										 //Modified  for In:073938 end
									tmp_conv=parent.frames[1].document.forms[0].tmp_conv.value;//Added by Shazana for INC065695
									//alert("tmp_conv in StCommon.js: "+tmp_conv);

										} //Added by Shazana for INC065695
							
							var defaultqty_appl= parent.parent.frames[0].document.forms[0].defaultqty_appl1.value;
							var site = parent.frames[0].document.forms[0].site.value;
							var toStore		= toStore.value;
							if (toStore==undefined)
								toStore="";
									var frombarcode ="";
									if( parent.frames[0].document.forms[0].barcode != undefined){
										if(parent.frames[0].document.forms[0].barcode.value != "" )
										 frombarcode = "Y";
									}
							//var xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
							//var xmlDoc   = new ActiveXObject("Microsoft.XMLDom");
							var xmlHttp = new XMLHttpRequest();
							var xmlDoc="";
							//xmlDoc.loadXML(getXMLString(null));
							xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
							xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + trntype.value + "&bar_code=" + barcode.value + "&formObj=" + formObj.name  +"&fromStore=" + fromStore.value + "&toStore=" + toStore + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&jsp_page=" + ListDetail + "&site=" + site +"&frombarcode="+frombarcode+ "&validate=BARCODE", false);
							xmlHttp.send(xmlDoc);
							responseText = xmlHttp.responseText;
							eval(responseText);
							if(result){
								 resultArray = message.split(";");//alert("resultArray"+resultArray);
								if(trntype.value == "URG"){
									parent.frames[0].document.forms[0].iss_uom_qty.value =item_qty;
									parent.frames[0].document.forms[0].item_qty.value =(item_qty * parent.frames[0].document.forms[0].batch_multiples.value)/parent.frames[0].document.forms[0].issue_uom_multiples.value;
									CheckQuantity(parent.frames[0].document.forms[0].iss_uom_qty);
								} else if(trntype.value == "ISS"){//Added against GHL-CRF-0413.2-US002
									parent.frames[0].document.forms[0].iss_uom_qty.value =item_qty;
									parent.frames[0].document.forms[0].item_qty.value =(item_qty * parent.frames[0].document.forms[0].batch_multiples.value)/parent.frames[0].document.forms[0].issue_uom_multiples.value;
									CheckQuantity(parent.frames[0].document.forms[0].iss_uom_qty);
									var old_qty = parent.frames[0].document.forms[0].auth_qty.value;//added for GHL-CRF-0465
									var old_qty_1 = parent.frames[0].document.forms[0].auth_qty_1.value;//added for GHL-CRF-0465
									if(parseFloat(old_qty_1)==parseFloat(old_qty)){// if added ICN65193 against GHL-CRF-0465
									if(parseFloat(old_qty_1)<parseFloat(qt_1))
										{
										var confirm1=confirm(getMessage("ISS_QTY_EXCEED_AUTHORIZED_QTY", "ST"));
										}
									}
									valueChange1(item_qty);
									//GHL-CRF-0465 END
								}
								else{
									parent.frames[0].document.forms[0].item_qty.value =item_qty;
									CheckQuantity(parent.frames[0].document.forms[0].item_qty);
								}
							if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
							parent.frames[0].document.forms[0].tot_item_qty.value =item_qty * tmp_conv;
							}
							 else if(parent.frames[0].document.forms[0].ret_qty!=undefined){
								 parent.frames[0].document.forms[0].ret_qty.value =item_qty * tmp_conv;
							}
								if (document.forms[0].bar_or_item_code.value == 'B'){
									
								 var  item_code   = 	resultArray[0];
								 var  batch_id    = 	resultArray[1];
								 var  expiry_date = 	resultArray[2];	
									 var  BarcodeWithMultipleBatches = resultArray[3];			
									 var xmlHttp = new XMLHttpRequest();
										var xmlDoc="";
											//xmlDoc.loadXML(getXMLString(null));
											xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
											xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=BarcodeWithMultipleBatches_yn"+"&store_code="+store_code+"&item_code="+item_code+"&BarcodeWithMultipleBatches_yn=" + BarcodeWithMultipleBatches + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
										xmlHttp.send(xmlDoc);
										var responseText=xmlHttp.responseText;
										eval(responseText);
										if(result){
											// end INC65145 against GHL-CRF-0465
											if(trntype.value == "ISS"){// added if 
											var old_qty = parent.frames[0].document.forms[0].auth_qty.value;
											var old_qty_1 = parent.frames[0].document.forms[0].auth_qty_1.value;
											var tem_qty=parent.frames[0].document.forms[0].iss_uom_qty.value;
											}
											if(parseFloat(old_qty_1)==parseFloat(old_qty)&&trntype.value == "ISS"){
												if(parseFloat(old_qty_1)<parseFloat(tem_qty)){
													tem_qty--;
												var confirm1=confirm(getMessage("ISS_QTY_EXCEED_AUTHORIZED_QTY", "ST"));
												if(confirm1)
													editViewBatchForBarCode1(ListDetail,fromStore.value,barcode.value,BarcodeWithMultipleBatches,qtyList,trntype.value);
												else{
													//alert("@@@@@ :"+batch_item);
													 var xmlHttp = new XMLHttpRequest();
														var xmlDoc="";
															//xmlDoc.loadXML(getXMLString(null));
															xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
															xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&batch_item="+batch_item+"&barcode="+ barcode.value+"&trntype=" + trntype.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name +"&batch_item="+batch_item+"&BARCODE_YN=TRUE"+"&validate=REMOVE_AUTH_BATCH_IN_LIST", false);//GHL-CRF-0465
															xmlHttp.send(xmlDoc);
														var responseText=xmlHttp.responseText;
														eval(responseText);														
													parent.frames[0].document.forms[0].iss_uom_qty.value=tem_qty;
												}
												}else
													editViewBatchForBarCode1(ListDetail,fromStore.value,barcode.value,BarcodeWithMultipleBatches,qtyList,trntype.value);
											}else
											editViewBatchForBarCode1(ListDetail,fromStore.value,barcode.value,BarcodeWithMultipleBatches,qtyList,trntype.value);
											// end INC65145 against GHL-CRF-0465
										}else{
												callBatchSearchforBarcodeMultiBatch1(fromStore.value,barcode.value,ListDetail,BarcodeWithMultipleBatches,qtyList);
							}parent.frames[0].document.forms[0].barcode.value = "";
								}
							}else{
								if(getMessage(message, "ST") != ""){
									alert(getMessage(message, "ST"));
									parent.frames[0].document.forms[0].barcode.value = "";
									return false;								
									}
								else{
								parent.frames[0].document.forms[0].barcode.value = "";
								return false;
								}
							}
					}
						else{
					//Added against IN:062242 starts
								alert(getMessage(message, "ST"));
								parent.frames[0].document.forms[0].barcode.value = "";
								return false;
							}
				        	}
						else{
					//Added against IN:062242 ends
							if (confirm("Proceed with the next Item?") == true) {
										if(trntype.value == "CON")
											addToListforBarcode();
										else
								addToListforBarCode(bean_id,bean_name, parent.parent.frames[0].document.forms[0].barcode_applicable1,ListHeader,ListDetail,Detail);
						    } else {
						    	 parent.frames[0].document.forms[0].barcode.value = "";
						    	return false;
						    }
						}
					}
				}
				else{
					callBarCodeBatchSearchforBarcode(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail);
				}
	}
		}
		else{
			alert(getMessage("ST_INVALID_BAR_CODE", "ST"));
			 parent.frames[0].document.forms[0].barcode.value = "";
			return false;
		}
}
	else{
		if(getMessage(message, "ST") != ""){
			alert(getMessage(message, "ST"));
			parent.frames[0].document.forms[0].barcode.value = "";
			return false;								
			}
		else{
		alert(getMessage("ST_NOT_AUTHORIZED_ITEM", "ST"));
		 parent.frames[0].document.forms[0].barcode.value = "";
		return false;
		}
	}
	}
}

function checkQtyBarcode(qty,item_code,qty_1){//Added against GHL-CRF-0413.2-US002// //added for GHL-CRF-465
 //parent.frames[0].document.forms[0].auth_qty.value = qty;// added forGHL-CRF-0465
 //alert(parent.frames[0].document.forms[0].item_code.value);
	parent.frames[0].document.forms[0].auth_qty_1.value=qty_1;//added for GHL-CRF-465
	parent.frames[0].document.forms[0].issue_qty_1.value = qty;//added for GHL-CRF-465
	if(item_code == parent.frames[0].document.forms[0].item_code.value||parent.frames[0].document.forms[0].item_code.value==""){//|| added for GHL-CRF-0465
	 parent.frames[0].document.forms[0].auth_qty.value = qty;
	 parent.frames[0].document.forms[0].iss_uom_qty_chk.value = qty;
	 }
}
function editViewBatchForBarCode1(ListDetail,fromStore,bar_code,BarcodeWithMultipleBatches,qtyList,trn_type) {  
	var formObj = document.forms[0];
	var _item_code = formObj.item_code.value;
	var item_qty = "";
	formObj.edit.disabled=true;
	if(trn_type == "SAL")
		formObj.batchsearch.disabled=true;
	var defaultqty_appl= parent.parent.frames[0].document.forms[0].defaultqty_appl1.value; 
	var editqty_appl= parent.parent.frames[0].document.forms[0].editqty_appl1.value; 
	if(item_qty== ""){
			parent.frames[1].location.href = ["../../eST/jsp/"+ListDetail+".jsp?function=additionalBatch&item_code=" + _item_code +"&store_code=" + fromStore +"&barcode="+bar_code+ "&expiry_yn=" + formObj.expiry_yn.value + "&item_qty=" + item_qty+ "&index=" + formObj.index.value  + "&defaultqty_appl=" + defaultqty_appl  + "&editqty_appl=" + editqty_appl +"&BarcodeWithMultipleBatches=" + BarcodeWithMultipleBatches+"&qtyList="+qtyList ] ;		
						}
					}
async function callBatchSearchforBarcodeMultiBatch1(fromStore,barcode,ListDetail,BarcodeWithMultipleBatches,qtyList) {
	var formObj = document.forms[0];
	var arrayObject = new Array(formObj.item_code);
	var names = new Array(getLabel("Common.item.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	formObj.edit.disabled=true;
	formObj.batchsearch.disabled=true;
	var defaultqty_appl= parent.parent.frames[0].document.forms[0].defaultqty_appl1.value; 
	var editqty_appl= parent.parent.frames[0].document.forms[0].editqty_appl1.value; 
	if (blankObject == true) {
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.item_qty.value;
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "Y";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "N";
		var retval =await callBatchSearchWindowforBarcode(_item_code, fromStore, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, "", "", "", "","",barcode);
		if (retval != null && retval!="" && retval!=undefined) {
			var noofbatches = retval.indexOf("~");
			if(noofbatches==-1){
				document.forms[0].noofbatchesforbarcode.value = "1";
		} else {
				document.forms[0].noofbatchesforbarcode.value = "2";
			}
	parent.frames[1].location.href = ["../../eST/jsp/"+ListDetail+".jsp?function=additionalBatch&item_code=" + _item_code +"&store_code=" + fromStore +"&barcode="+barcode+ "&expiry_yn=" + formObj.expiry_yn.value + "&item_qty=" + item_qty+ "&index=" + formObj.index.value  + "&defaultqty_appl=" + defaultqty_appl  + "&editqty_appl=" + editqty_appl +"&BarcodeWithMultipleBatches=" + BarcodeWithMultipleBatches+"&qtyList="+qtyList] ;		
		}
}
}

async function callBarCodeBatchSearch(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail) {
	if (e.type === 'keypress' || e.type === 'keydown' || e.type === 'keyup') {
        if (e.keyCode === 13 || e.keyCode === 9 || e.keyCode === 0) {
        	await barCodeBatchSearch(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail);
        }
    } 
    else if (e.type === 'click') {
    	await barCodeBatchSearch(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail);
    }
}

//Added for GHL-CRF-0413 ends
//new function created for edge related changes
async function barCodeBatchSearch(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	var bar_code	= barcode.value;
	var trn_type	= trntype.value;
	var fromStore   = fromStore.value;
	var toStore		= toStore.value;
	var formObj		= formObj.name; 
	var barcode_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
	var resultArray	;	
	if (barcode_appl=="Y" && bar_code!=""){
	if (toStore==undefined)
		toStore="";

	//var xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
	//var xmlDoc   = new ActiveXObject("Microsoft.XMLDom");
	//xmlDoc.loadXML(getXMLString(null));
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + trn_type + "&bar_code=" + bar_code + "&formObj=" + formObj  +"&fromStore=" + fromStore + "&toStore=" + toStore + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&jsp_page=" + ListDetail + "&validate=BARCODE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if(result){
		if (document.forms[0].bar_or_item_code.value == 'B'){
		 resultArray = message.split(";");
		 var  item_code   = 	resultArray[0];
		 var  batch_id    = 	resultArray[1];
		 var  expiry_date = 	resultArray[2];	
		 var  BarcodeWithMultipleBatches = resultArray[3];	

		if (trn_type=="SAL"){
		 
		 var bill_linked =await callItemValProcedure(item_code,fromStore,batch_id,expiry_date,ListDetail,bean_id,bean_name);
		 if (bill_linked)
		 {
				    //var _xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					//var _xmlDoc = new ActiveXObject("Microsoft.XMLDom");
					var _xmlHttp = new XMLHttpRequest();
					var _xmlDoc="";
					//_xmlDoc.loadXML(getXMLString(null));
					_xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
					_xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=AFTER_BILLING_LINKED&item_code=" + item_code + "&store_code=" + fromStore + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&jsp_page=" + ListDetail + "&bean_id=" + bean_id + "&bean_name=" + bean_name+ "&BarcodeWithMultipleBatches=" + BarcodeWithMultipleBatches  + "&BARCODE_YN=TRUE", false);
					_xmlHttp.send(_xmlDoc);
					eval(responseText);
			if(result){
					if(BarcodeWithMultipleBatches=="Y"){
						callBatchSearchforBarcodeMultiBatch(fromStore,bar_code,ListDetail);
					}else{
						editViewBatchForBarCode(ListDetail);
					}
					if (parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'Y'  && parent.parent.frames[0].document.forms[0].editqty_appl1.value=='N') {
						setInterval('CheckQuantity(document.forms[0].item_qty)',200);
						setInterval('calTotalQty();',200);
						setInterval('chargeDetailsExp(document.forms[0].item_code.value);',200);
						if(document.forms[0].index.value==-1  && document.forms[0].noofbatchesforbarcode.value=="1"){
						setInterval("addToListforBarCode1('"+bean_id+"','"+bean_name+"','"+ListHeader+"','"+ListDetail+"','"+Detail+"');",500);
						}
					}
			}
		}
		else{
		 		alert(getMessage("EFFECTIVE_RATE_NOT_AVAILABLE", "ST"));
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
		}
		}else{		
			/*if (parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'Y'  && parent.parent.frames[0].document.forms[0].editqty_appl1.value=='N') {
				setInterval('CheckQuantity(document.forms[0].item_qty)',200);
				setInterval('calTotalQty();',200);
				setInterval('chargeDetailsExp(document.forms[0].item_code.value);',200);

				if(document.forms[0].index.value==-1 ){
				setInterval("addToListforBarCode1('"+bean_id+"','"+bean_name+"','"+ListHeader+"','"+ListDetail+"','"+Detail+"');",500);
				}
			}*/
				if(BarcodeWithMultipleBatches=="Y"){
					callBatchSearchforBarcodeMultiBatch(fromStore,bar_code,ListDetail);
				}
				if (parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'Y'  && parent.parent.frames[0].document.forms[0].editqty_appl1.value=='N') {
					setInterval('checkminmaxstatus()',200);
					setInterval('totalqty()',200);
					setInterval('calIssueQty()',200);
					setInterval('CheckQuantity()',200);
				//	setInterval('CheckDtlQuantity(document.forms[0].index.value)',200);
					if(document.forms[0].index.value==-1  && document.forms[0].noofbatchesforbarcode.value=="1" ){
					setInterval("addToListforBarCode1('"+bean_id+"','"+bean_name+"','"+ListHeader+"','"+ListDetail+"','"+Detail+"');",500);
					}
				}else if(parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'N'){
					if(document.forms[0].iss_uom_qty!=undefined)
						document.forms[0].iss_uom_qty.focus();
					else
						document.forms[0].item_qty.focus();				
				}
			}	
		}
	
	}
	else
	 {
	    parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";	//err_num=" + message;

		if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.forms[0].phy_inv_id.value);
				return;
		} else {
			if(getMessage(message, "ST") != ""){
				alert(getMessage(message, "ST"));
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			}
			else{
				alert(message);
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			}
		}
	 }
	}
	else{
		await callItemSearchScreen();
	}
}

function addToListforBarCode(bean_id,bean_name,barcode_applicable,ListHeader,ListDetail,Detail) {
	if (barcode_applicable.value=="Y"){
	var formHeader	   = parent.parent.frames[0].document.forms[0];
	var formDetail     = parent.parent.frames[1].document.forms[0];
	var formListHeader = parent.frames[0].document.forms[0];
	var formListDetail = parent.frames[1].document.forms[0];
	
	var trn_type;
	if(formListHeader.trn_type!=undefined)
	trn_type = formListHeader.trn_type.value;
	else
	trn_type = formListHeader.trn_type1.value;
	
	//Added for GHL-CRF-0413 starts
	if(formListHeader.site!=undefined){
	var site = formListHeader.site.value;
	if(site){
	if(formListDetail !=  null && trn_type == "SAL"){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?doc_srl_no_forbean=" + parent.frames[1].document.forms[0].doc_srl_no_forbean.value +  "&validate=SET_IN_BEAN", false);
		//xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?doc_srl_no_forbean=" + parent.frames[1].document.forms[0].doc_srl_no_forbean.value +  "&validate=SET_IN_BEAN" + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
	if(formListHeader.trn_type_barcode!=undefined){
		if( formListDetail !=  null && formListHeader.trn_type_barcode.value == "URG" ){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?doc_srl_no_forbean=" + parent.frames[1].document.forms[0].doc_srl_no_forbean.value +  "&validate=SET_IN_BEAN_URG", false);
		//xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?doc_srl_no_forbean=" + parent.frames[1].document.forms[0].doc_srl_no_forbean.value +  "&validate=SET_IN_BEAN" + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		}
		if( formListDetail !=  null && formListHeader.trn_type_barcode.value == "ISS" ){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?doc_srl_no_forbean=" + parent.frames[1].document.forms[0].doc_srl_no_forbean.value +  "&validate=SET_IN_BEAN_ISS", false);
			//xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?doc_srl_no_forbean=" + parent.frames[1].document.forms[0].doc_srl_no_forbean.value +  "&validate=SET_IN_BEAN" + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
		}
		}
	}
	}
	//Added for GHL-CRF-0413 ends
	if(trn_type == "URG"){
    if(formListHeader.iss_uom_code.value == ""){
    alert("Issue Uom Cannot be blank...");
	formListHeader.iss_uom_code.focus();
	return;
	}
	}
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	for (i = 0; i < parseInt(formDetail.total_checkboxes.value); i++) {
		checkBoxObj = eval("formDetail.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}
	
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formHeader.records_to_delete.value = forDeletion;
	/*	Commented against GHL-CRF-0413.2-US002
    var arrayObject = new Array(formListHeader.item_code, formListHeader.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
*/
	//Added against GHL-CRF-0413.2-US002 starts
	 var arrayObject;
   	 var names;
	if (formListHeader.trn_type_barcode!=undefined && formListHeader.trn_type_barcode.value == "ISS" && document.formIssueListHeader.iss_uom_qty.value != "" && document.formIssueListHeader.iss_uom_qty.value != parent.frames[0].document.forms[0].auth_qty.value ) 
		{
		if(document.formIssueListHeader.remarks_mandatory.style.visibility=="visible"){// if else condition added for ICN 065143 
		arrayObject = new Array(formListHeader.item_code, formListHeader.item_qty, formListHeader.remarks);
		names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"), getLabel("Common.remarks.label", "Common"));
		document.formIssueListHeader.remarks_mandatory.style.visibility = "visible";
		}else if(document.formIssueListHeader.remarks_mandatory.style.visibility=="hidden")
		{
				arrayObject = new Array(formListHeader.item_code, formListHeader.item_qty);
				names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));		
				}// end ICN 065143
		
	} else { 
		arrayObject = new Array(formListHeader.item_code, formListHeader.item_qty);
		names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
		
	}
	if (formListHeader.trn_type_barcode!=undefined && formListHeader.trn_type_barcode.value == "ISS"  && document.formIssueListHeader.iss_uom_qty.value != "" && document.formIssueListHeader.iss_uom_qty.value != parent.frames[0].document.forms[0].auth_qty.value) {
		var formObject = document.formIssueListHeader;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlStr = getXMLString(formObject);Commended by sakti due to problem for special character in remarks
		xmlStr = getEnhancedXMLString(formObject);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=SET_REMARKS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
	//Added against GHL-CRF-0413.2-US002 ends
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
			
			if(formHeader.store_code != undefined)
			var store_code = formHeader.store_code.value;
			else
			var store_code = formHeader.from_store_code.value;

		if (formListDetail == null && formListHeader.stock_item_yn.value == "Y") {
			//var store_code = formHeader.store_code.value;
			var _item_code = formListHeader.item_code.value;
			//var  item_qty   = formListHeader.tot_item_qty.value;	
			var item_qty;			
			if(formListHeader.tot_item_qty != undefined)
			item_qty = formListHeader.tot_item_qty.value;
			else if(formListHeader.ret_qty!=undefined)
			item_qty = formListHeader.ret_qty.value;
			else
			item_qty = formListHeader.item_qty.value;

			parent.frames[1].location.href = ["../../eST/jsp/"+ListDetail+".jsp?function=addbarcode&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id=" + parent.parent.function_id ];
			return;
		}
	

		if (formListHeader.stock_item_yn.value == "Y") {
			var proceed = false;
			var messageFrame = parent.parent.messageFrame;
			var errorPage = "../../eCommon/jsp/error.jsp";

			var item_qty;			
			if(formListHeader.tot_item_qty!=undefined)
			item_qty = formListHeader.tot_item_qty.value;
			else if(formListHeader.ret_qty!=undefined)
			item_qty = formListHeader.ret_qty.value;
			else
			item_qty = formListHeader.item_qty.value;


			_total_checkboxes = formListDetail.total_checkboxes.value;


		//	var no_of_decimals=formListDetail.no_of_decimals.value;

			var no_of_decimals = '0';
			if(formListDetail.dec_allowed_yn != undefined)
			no_of_decimals=formListDetail.no_of_decimals.value;
			else
			no_of_decimals=formListDetail.no_deci.value;


			
			var sum = 0;
			for (i = 0; i < _total_checkboxes; i++) {
				var qty = eval("formListDetail.item_qty_" + i).value;
				if (qty == "") {
					qty = 0;
				}
				if (!isNaN(qty)) {
					
					sum += parseFloat(qty);
				}
			}
		//if(formListDetail.dec_allowed_yn.value=='Y')
		//	sum=sum.toFixed(no_of_decimals);
		

		var dec_allowed_yn;
		if(formListDetail.dec_allowed_yn != undefined){
			dec_allowed_yn  = formListDetail.dec_allowed_yn.value;
			if(formListDetail.dec_allowed_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);
		}else{
			dec_allowed_yn  = formListDetail.allow_deci_yn.value;
			if(formListDetail.allow_deci_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);
		}		
			if (parseInt(sum) != parseInt(item_qty)) {
				alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
				formListHeader.apply.disabled = false;
				return;
			}

		}
		if (formListDetail.batchsearch.value == "newbatch") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getEnhancedXMLString(formListHeader));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formListHeader), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=setnewbatch&index=" + formListHeader.index.value + "&mode=" + formListHeader.mode.value + "&bean_id="+bean_id+"&bean_name="+bean_name+ "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value +"&BARCODE_YN=TRUE ", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + (message);
				return;
			}
		}
	
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		if (formListHeader.stock_item_yn.value == "Y") {
			//xmlDoc.loadXML(getEnhancedXMLString(formListDetail));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formListDetail), "text/xml");
		} else {
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		}

		parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" ;
		
		var kit_temp_code = formListHeader.kit_temp_code.value;//for kit_temp
		var usage_type = formListHeader.usage_type.value;
		var kit = formListHeader.kit.value;

//		if (formHeader.chargeable_yn.value == "Y" && formListHeader.billable_item_yn.value=="Y") {
		if (formHeader.chargeable_yn.value == "Y") {
			if(formListHeader.bl_override_excl_incl_ind.value!="" ){
			if(formListHeader.bl_override_excl_incl_ind.value!="S" && formListHeader.bl_incl_excl_override_reason_code.value==""){
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("ST_REASON_CODE_NOT_BLANK", "ST");
				formListHeader.apply.disabled = false;
				return;
			}
			}
			if(trn_type == "URG")
			{
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value) + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + document.getElementById('id_store_item_unit_cost').innerText + "&item_cost_value=" + parent.frames[0].document.getElementById('id_item_sal_value').innerText+"&pat_net_amt=" + parent.frames[0].document.getElementById('id_payable_amt').innerText+"&gross_charge_amt=" + parent.frames[0].document.getElementById('id_charge_amt').innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&uom_code=" + formListHeader.uom_code.value + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&remarks=" + encodeURIComponent(formListHeader.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById('uom_desc').innerText,"UTF-8") + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&batch_records=" + formListDetail.total_checkboxes.value +"&remarks_code="+formListHeader.remarks_code.value+"&bl_override_excl_incl_ind="+formListHeader.bl_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_code="+formListHeader.bl_incl_excl_override_reason_code.value+"&bl_def_override_excl_incl_ind="+formListHeader.bl_def_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_desc="+encodeURIComponent(formListHeader.bl_incl_excl_override_reason_desc.value,"UTF-8")+"&approval_reqd_yn="+formListHeader.approval_reqd_yn.value+"&bl_override_allowed_yn="+formListHeader.bl_override_allowed_yn.value+ "&pat_paid_amt=" + parent.frames[0].document.getElementById('id_paid_amt').innerText+"&decimal_allowedYN="+formListHeader.decimal_allowedYN.value+"&no_of_decimals="+formListHeader.no_of_decimals.value+"&records_to_delete="+formHeader.records_to_delete.value+"&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&trn_type="+trn_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type+"&approval_no="+encodeURIComponent(formListHeader.approval_number.value)+"&validate=ADD_TO_LIST", false); //kit_temp_code,Modified for for IN:071972,Modified for 48809
			}
			else
			{
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value) + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + document.getElementById('id_store_item_unit_cost').innerText + "&item_cost_value=" + parent.frames[0].document.getElementById('id_item_sal_value').innerText+"&pat_net_amt=" + parent.frames[0].document.getElementById('id_payable_amt').innerText+"&gross_charge_amt=" + parent.frames[0].document.getElementById('id_charge_amt').innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&uom_code=" + formListHeader.uom_code.value + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&remarks=" + encodeURIComponent(formListHeader.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById('id_uom').innerText,"UTF-8") + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&batch_records=" + formListDetail.total_checkboxes.value +"&remarks_code="+formListHeader.remarks_code.value+"&bl_override_excl_incl_ind="+formListHeader.bl_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_code="+formListHeader.bl_incl_excl_override_reason_code.value+"&bl_def_override_excl_incl_ind="+formListHeader.bl_def_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_desc="+encodeURIComponent(formListHeader.bl_incl_excl_override_reason_desc.value,"UTF-8")+"&approval_reqd_yn="+formListHeader.approval_reqd_yn.value+"&bl_override_allowed_yn="+formListHeader.bl_override_allowed_yn.value+ "&pat_paid_amt=" + parent.frames[0].document.getElementById('id_paid_amt').innerText+"&decimal_allowedYN="+formListHeader.decimal_allowedYN.value+"&no_of_decimals="+formListHeader.no_of_decimals.value+"&records_to_delete="+formHeader.records_to_delete.value+"&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&trn_type="+trn_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type+"&approval_no="+encodeURIComponent(formListHeader.approval_number.value)+"&validate=ADD_TO_LIST", false); //kit_temp_code,Modified for for IN:071972
			}	
		} else {
			//xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value) + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + document.getElementById("id_store_item_unit_cost").innerText + "&item_cost_value=" + parent.frames[0].document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&uom_code=" + formListHeader.uom_code.value + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&remarks=" + escape(formListHeader.remarks.value) + "&uom_desc=" +encodeURIComponent( document.getElementById("id_uom").innerText,"UTF-8" )+ "&batch_records=" + formListDetail.total_checkboxes.value + "&stock_available=" + document.getElementById("id_stock_available").innerText+"&remarks_code="+formListHeader.remarks_code.value +"&decimal_allowedYN="+formListHeader.decimal_allowedYN.value+"&no_of_decimals="+formListHeader.no_of_decimals.value+"&records_to_delete="+formHeader.records_to_delete.value+ "&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&validate=ADD_TO_LIST", false);			
			//xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&store_code=" + store_code + "&uom_code=" + formListHeader.uom_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value,"UTF-8") + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + document.getElementById("item_unit_cost").value + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&item_cost_value=" + document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&store_alt_code=" + store_code + "&uom_desc=" + document.getElementById("id_uom").innerText + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&expired_batch=" + formListDetail.expired_batch.value + "&ex_param_days=" + formListDetail.ex_param_days.value + "&frm_store_qty_on_hand=" + formListHeader.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formListHeader.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formListHeader.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formListHeader.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formListHeader.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formListHeader.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formListHeader.to_store_max_stk_level.value + "&to_store_reorder_level=" + formListHeader.to_store_reorder_level.value + "&to_conv_fact=" + formListHeader.tmp_conv.value + "&frm_conv_fact=" + formListHeader.frm_tmp_conv.value + "&frm_store_uom_desc=" + formListHeader.frm_store_uom_desc.value + "&batch_records=" + formListDetail.total_checkboxes.value + "&to_store_uom_desc=" + formListHeader.to_store_uom_desc.value +"&allow_yn="+formListHeader.allow_deci_yn.value+"&no_decimals="+formListHeader.no_deci.value+"&kit_item_yn="+formListHeader.kit_item_yn.value+"&from_multiples="+formListHeader.from_multiples.value+"&to_multiples="+formListHeader.to_multiples.value+"&batch_multiples="+formListHeader.batch_multiples.value+"&decimal_allowedYN="+dec_allowed_yn+"&no_of_decimals="+no_of_decimals+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&validate=ADD_TO_LIST", false);
			
			toConvFactor();//newly added for kit template

			var expired_batch="";
			var ex_param_days="";
			var frm_store_qty_on_hand="";
			var frm_store_min_stk_level="";
			var frm_store_max_stk_level="";
			var frm_store_reorder_level="";
			var to_store_qty_on_hand ="";
			var to_store_min_stk_level="";
			var to_store_max_stk_level="";
			var to_store_reorder_level="";
			var to_store_reorder_level="";
			var to_conv_fact="";
			var frm_conv_fact="";
			var to_store_uom_desc="";
			var kit_item_yn="";
			var from_multiples="";
			var to_multiples="";
			var batch_multiples="";
			var remarks="";
			var remarks_code="";
			var kit = "";
			var for_bin_to_store_hidden="";
			var iss_uom_code="";
			var uom_conv_code="";
			var iss_uom_qty="";
			var iss_uom_conv_text="";
			var issue_uom_multiples="";
			var frm_store_uom_desc="";
			if(formListHeader.remarks!=undefined){
			 remarks = formListHeader.remarks.value;
			 remarks_code  = formListHeader.remarks_code.value;
			}
			var approval_no="";//Added for IN:071972
			if(formListDetail.expired_batch!=undefined){
			expired_batch=formListDetail.expired_batch.value;
			ex_param_days=formListDetail.ex_param_days.value;
			frm_store_qty_on_hand=formListHeader.frm_store_qty_on_hand.value;
			frm_store_min_stk_level=formListHeader.frm_store_min_stk_level.value;
			frm_store_max_stk_level=formListHeader.frm_store_max_stk_level.value;
			frm_store_reorder_level=formListHeader.frm_store_reorder_level.value;
			to_store_qty_on_hand =formListHeader.to_store_qty_on_hand.value;
			to_store_min_stk_level=formListHeader.to_store_min_stk_level.value;
			to_store_max_stk_level=formListHeader.to_store_max_stk_level.value;
			to_store_reorder_level=formListHeader.to_store_reorder_level.value;
			to_conv_fact = formListHeader.tmp_conv.value;

			if(formListHeader.frm_tmp_conv!=undefined)
			frm_conv_fact=  formListHeader.frm_tmp_conv.value;
			else
			frm_conv_fact=  formListHeader.frm_conv_fact.value;

			frm_store_uom_desc=formListHeader.frm_store_uom_desc.value;
			to_store_uom_desc=  formListHeader.to_store_uom_desc.value;
			kit_item_yn= formListHeader.kit_item_yn.value;
			from_multiples= formListHeader.from_multiples.value;
			to_multiples= formListHeader.to_multiples.value;
			batch_multiples= formListHeader.batch_multiples.value;
			//kit = formListHeader.kit.value;moved up

			if(formListHeader.for_bin_to_store_hidden!=undefined){
			for_bin_to_store_hidden= formListHeader.for_bin_to_store_hidden.value;
			iss_uom_code= formListHeader.iss_uom_code.value;
			uom_conv_code= formListHeader.iss_conv_fact.value;
			iss_uom_qty= formListHeader.iss_uom_qty.value;
			iss_uom_conv_text= document.getElementById('id_iss_uom_conv').innerHTML;
			issue_uom_multiples=formListHeader.issue_uom_multiples.value;
			}
			}
			var barcode_scanned_yn="";//ADDED FOR RUT-CRF-0079
			if(formListHeader.barcode_scanned_yn!=undefined){
				barcode_scanned_yn=formListHeader.barcode_scanned_yn.value;
			}
			//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014 Starts
			var iss_item_hold_yn="Y";
			var iss_item_hold_qty=""; 
			var iss_item_hold_chk="N"; 
			
			if(formListHeader.iss_item_hold_yn!=undefined){
				iss_item_hold_yn = formListHeader.iss_item_hold_yn.value;
			}
			if(formListHeader.iss_item_hold_chk!=undefined){
				iss_item_hold_chk = formListHeader.iss_item_hold_chk.value;
			}
			if(formListHeader.iss_item_hold_qty!=undefined){
				iss_item_hold_qty = formListHeader.iss_item_hold_qty.value;
			} 
			//ends
			var trntype_barcode ="";
			if(formListHeader.trn_type_barcode == undefined){
				trntype_barcode = trn_type;
			}
			else{
				trntype_barcode = formListHeader.trn_type_barcode.value;
			}
			var item_unit_cost ="";
			if(trn_type == 'SAL' ){
				item_unit_cost = document.getElementById('id_store_item_unit_cost').innerText;
				approval_no = encodeURIComponent(formListHeader.approval_number.value);//Added for IN:071972
			}
			else 
				item_unit_cost = document.getElementById('item_unit_cost').value ;

//			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&store_code=" + store_code + "&uom_code=" + formListHeader.uom_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value,"UTF-8") + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + document.getElementById("item_unit_cost").value + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&item_cost_value=" + document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&store_alt_code=" + store_code + "&uom_desc=" + encodeURIComponent( document.getElementById("id_uom").innerText,"UTF-8" ) + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&expired_batch=" + expired_batch + "&ex_param_days=" + ex_param_days + "&frm_store_qty_on_hand=" + frm_store_qty_on_hand + "&frm_store_min_stk_level=" + frm_store_min_stk_level + "&frm_store_max_stk_level=" + frm_store_max_stk_level + "&frm_store_reorder_level=" + frm_store_reorder_level + "&to_store_qty_on_hand=" + to_store_qty_on_hand + "&to_store_min_stk_level=" + to_store_min_stk_level + "&to_store_max_stk_level=" + to_store_max_stk_level + "&to_store_reorder_level=" + to_store_reorder_level + "&to_conv_fact=" + to_conv_fact + "&frm_conv_fact=" + frm_conv_fact + "&frm_store_uom_desc=" + frm_store_uom_desc + "&batch_records=" + formListDetail.total_checkboxes.value + "&to_store_uom_desc=" + to_store_uom_desc+"&kit_item_yn="+kit_item_yn+"&from_multiples="+from_multiples+"&to_multiples="+to_multiples+"&batch_multiples="+batch_multiples+"&decimal_allowedYN="+dec_allowed_yn+"&no_of_decimals="+no_of_decimals + "&remarks=" + escape(remarks) +"&remarks_code="+ remarks_code + "&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&records_to_delete="+formHeader.records_to_delete.value+ "&for_bin_to_store_hidden=" + for_bin_to_store_hidden	+ "&iss_uom_code=" + iss_uom_code + "&uom_conv_code=" + uom_conv_code+ "&iss_uom_qty=" + iss_uom_qty + "&iss_uom_conv_text=" + iss_uom_conv_text + "&issue_uom_multiples=" + issue_uom_multiples+"&trn_type="+trn_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type+"&barcode_scanned_yn="+barcode_scanned_yn+"&iss_item_hold_yn="+iss_item_hold_yn+"&iss_item_hold_chk="+iss_item_hold_chk+"&iss_item_hold_qty="+iss_item_hold_qty+"&validate=ADD_TO_LIST", false); Modified against GHL-CRF-0413.2-US002
			if(trn_type == 'URG'){
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value +"&site="+site+"&trn_type_barcode="+trntype_barcode+ "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&store_code=" + store_code + "&uom_code=" + formListHeader.uom_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value,"UTF-8") + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + item_unit_cost + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&item_cost_value=" + document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&store_alt_code=" + store_code + "&uom_desc=" + encodeURIComponent( document.getElementById('uom_desc').innerText,"UTF-8" ) + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&expired_batch=" + expired_batch + "&ex_param_days=" + ex_param_days + "&frm_store_qty_on_hand=" + frm_store_qty_on_hand + "&frm_store_min_stk_level=" + frm_store_min_stk_level + "&frm_store_max_stk_level=" + frm_store_max_stk_level + "&frm_store_reorder_level=" + frm_store_reorder_level + "&to_store_qty_on_hand=" + to_store_qty_on_hand + "&to_store_min_stk_level=" + to_store_min_stk_level + "&to_store_max_stk_level=" + to_store_max_stk_level + "&to_store_reorder_level=" + to_store_reorder_level + "&to_conv_fact=" + to_conv_fact + "&frm_conv_fact=" + frm_conv_fact + "&frm_store_uom_desc=" + frm_store_uom_desc + "&batch_records=" + formListDetail.total_checkboxes.value + "&to_store_uom_desc=" + to_store_uom_desc+"&kit_item_yn="+kit_item_yn+"&from_multiples="+from_multiples+"&to_multiples="+to_multiples+"&batch_multiples="+batch_multiples+"&decimal_allowedYN="+dec_allowed_yn+"&no_of_decimals="+no_of_decimals + "&remarks=" + escape(remarks) +"&remarks_code="+ remarks_code + "&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&records_to_delete="+formHeader.records_to_delete.value+ "&for_bin_to_store_hidden=" + for_bin_to_store_hidden	+ "&iss_uom_code=" + iss_uom_code + "&uom_conv_code=" + uom_conv_code+ "&iss_uom_qty=" + iss_uom_qty + "&iss_uom_conv_text=" + iss_uom_conv_text + "&issue_uom_multiples=" + issue_uom_multiples+"&trn_type="+trn_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type+"&barcode_scanned_yn="+barcode_scanned_yn+"&iss_item_hold_yn="+iss_item_hold_yn+"&iss_item_hold_chk="+iss_item_hold_chk+"&iss_item_hold_qty="+iss_item_hold_qty+"&approval_no="+approval_no+"&validate=ADD_TO_LIST", false);//Modified for for IN:071972,Modified for 48809
			}
			else{
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value +"&site="+site+"&trn_type_barcode="+trntype_barcode+ "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&store_code=" + store_code + "&uom_code=" + formListHeader.uom_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value,"UTF-8") + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + item_unit_cost + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&item_cost_value=" + document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&store_alt_code=" + store_code + "&uom_desc=" + encodeURIComponent( document.getElementById('id_uom').innerText,"UTF-8" ) + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&expired_batch=" + expired_batch + "&ex_param_days=" + ex_param_days + "&frm_store_qty_on_hand=" + frm_store_qty_on_hand + "&frm_store_min_stk_level=" + frm_store_min_stk_level + "&frm_store_max_stk_level=" + frm_store_max_stk_level + "&frm_store_reorder_level=" + frm_store_reorder_level + "&to_store_qty_on_hand=" + to_store_qty_on_hand + "&to_store_min_stk_level=" + to_store_min_stk_level + "&to_store_max_stk_level=" + to_store_max_stk_level + "&to_store_reorder_level=" + to_store_reorder_level + "&to_conv_fact=" + to_conv_fact + "&frm_conv_fact=" + frm_conv_fact + "&frm_store_uom_desc=" + frm_store_uom_desc + "&batch_records=" + formListDetail.total_checkboxes.value + "&to_store_uom_desc=" + to_store_uom_desc+"&kit_item_yn="+kit_item_yn+"&from_multiples="+from_multiples+"&to_multiples="+to_multiples+"&batch_multiples="+batch_multiples+"&decimal_allowedYN="+dec_allowed_yn+"&no_of_decimals="+no_of_decimals + "&remarks=" + escape(remarks) +"&remarks_code="+ remarks_code + "&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&records_to_delete="+formHeader.records_to_delete.value+ "&for_bin_to_store_hidden=" + for_bin_to_store_hidden	+ "&iss_uom_code=" + iss_uom_code + "&uom_conv_code=" + uom_conv_code+ "&iss_uom_qty=" + iss_uom_qty + "&iss_uom_conv_text=" + iss_uom_conv_text + "&issue_uom_multiples=" + issue_uom_multiples+"&trn_type="+trn_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type+"&barcode_scanned_yn="+barcode_scanned_yn+"&iss_item_hold_yn="+iss_item_hold_yn+"&iss_item_hold_chk="+iss_item_hold_chk+"&iss_item_hold_qty="+iss_item_hold_qty+"&approval_no="+approval_no+"&validate=ADD_TO_LIST", false);//Modified for for IN:071972
			}	
			
		}

		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {

			if (formHeader.preview!=undefined)
			formHeader.preview.disabled = false;

			var arr = "";
			for (i = 0; i < parseInt(formDetail.total_checkboxes.value); i++) {
				if ((eval("formDetail.checkbox" + i).checked)) {
					arr = arr + "," + "CHECKED";
				} else {
					arr = arr + "," + "s";
				}
			}				
				
				refreshDetailsforBarCode(formListHeader.index.value,ListHeader,Detail,store_code,arr,to_conv_fact,frm_conv_fact,kit);			
			
			//refreshDetailsforBarCode(formListHeader.index.value,ListHeader,Detail,'','','','','');
		} else {
			formListHeader.apply.disabled = false;
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + (message);
			parent.frames[1].location.href = "../../eCommon/html/blank.html";
		}
	} else {
	}
	//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 
	if(trn_type == "SAL"){
	restoreToolbar();
	}
}
else{
	addToList(); 
}
}



function addToListforBarCode1(bean_id,bean_name,ListHeader,ListDetail,Detail) { 

	var formHeader	   = parent.parent.frames[0].document.forms[0];
	var formDetail     = parent.parent.frames[1].document.forms[0];
	var formListHeader = parent.frames[0].document.forms[0];
	var formListDetail = parent.frames[1].document.forms[0];
	
	var trn_type;
	if(formListHeader.trn_type!=undefined)
	trn_type = formListHeader.trn_type.value;
	else
	trn_type = formListHeader.trn_type1.value;

	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;

	for (i = 0; i < parseInt(formDetail.total_checkboxes.value); i++) {
		checkBoxObj = eval("formDetail.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}

	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formHeader.records_to_delete.value = forDeletion;

	var arrayObject = new Array(formListHeader.item_code);

	var names = new Array(getLabel("Common.item.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		
			if(formHeader.store_code != undefined)
			var store_code = formHeader.store_code.value;
			else
			var store_code = formHeader.from_store_code.value;

			
//		if (formListDetail == null && formListHeader.stock_item_yn.value == "Y") {	
		if (formListDetail == null) {

			var _item_code = formListHeader.item_code.value;
			//var  item_qty   = formListHeader.tot_item_qty.value;	
			
			var item_qty;			
			if(formListHeader.tot_item_qty!=undefined)
			item_qty = formListHeader.tot_item_qty.value;
			else if(formListHeader.ret_qty!=undefined)
			item_qty = formListHeader.ret_qty.value;
			else
			item_qty = formListHeader.item_qty.value;


			parent.frames[1].location.href = ["../../eST/jsp/"+ListDetail+".jsp?function=addbarcode&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id=" + parent.parent.function_id ];
			return;
		}
			var errorPage = "../../eCommon/jsp/error.jsp";
		if (formListHeader.stock_item_yn.value == "Y") {
			var proceed = false;
			var messageFrame = parent.parent.messageFrame;
			//var errorPage = "../../eCommon/jsp/error.jsp";
			//var item_qty = formListHeader.tot_item_qty.value;

			var item_qty;			
			if(formListHeader.tot_item_qty!=undefined)
			item_qty = formListHeader.tot_item_qty.value;
			else if(formListHeader.ret_qty!=undefined)
			item_qty = formListHeader.ret_qty.value;
			else
			item_qty = formListHeader.item_qty.value;


			_total_checkboxes = formListDetail.total_checkboxes.value;

			var no_of_decimals = '0';
			if(formListDetail.dec_allowed_yn != undefined)
			no_of_decimals=formListDetail.no_of_decimals.value;
			else
			no_of_decimals=formListDetail.no_deci.value;

			
			var sum = 0;
			for (i = 0; i < _total_checkboxes; i++) {
				var qty = eval("formListDetail.item_qty_" + i).value;
				if (qty == "") {
					qty = 0;
				}
				if (!isNaN(qty)) {					
					sum += parseFloat(qty);
				}
			}
		var dec_allowed_yn;
		if(formListDetail.dec_allowed_yn != undefined){
		dec_allowed_yn  = formListDetail.dec_allowed_yn.value;
			if(formListDetail.dec_allowed_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);
		}else{
		dec_allowed_yn  = formListDetail.allow_deci_yn.value;
			if(formListDetail.allow_deci_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);			
		}		
		}
		
		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		if (formListHeader.stock_item_yn.value == "Y") {
			//xmlDoc.loadXML(getEnhancedXMLString(formListDetail));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formListDetail), "text/xml");
		} else {
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		}

		parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" ;

		var kit_temp_code = formListHeader.kit_temp_code.value;//for kit_temp
		var usage_type = formListHeader.usage_type.value;//for usage_type
		var kit = formListHeader.kit.value;

//		if (formHeader.chargeable_yn.value == "Y" && formListHeader.billable_item_yn.value=="Y") {
		if (formHeader.chargeable_yn.value == "Y") {
			if(formListHeader.bl_override_excl_incl_ind.value!="" ){
			if(formListHeader.bl_override_excl_incl_ind.value!="S" && formListHeader.bl_incl_excl_override_reason_code.value==""){
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("ST_REASON_CODE_NOT_BLANK", "ST");
				formListHeader.apply.disabled = false;
				return;
			}
			}
			if(trn_type == "URG")
			{
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value) + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + document.getElementById('id_store_item_unit_cost').innerText + "&item_cost_value=" + parent.frames[0].document.getElementById('id_item_sal_value').innerText+"&pat_net_amt=" + parent.frames[0].document.getElementById('id_payable_amt').innerText+"&gross_charge_amt=" + parent.frames[0].document.getElementById('id_charge_amt').innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&uom_code=" + formListHeader.uom_code.value + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&remarks=" + encodeURIComponent(formListHeader.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById('uom_desc').innerText,"UTF-8") + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&batch_records=" + formListDetail.total_checkboxes.value +"&remarks_code="+formListHeader.remarks_code.value+"&bl_override_excl_incl_ind="+formListHeader.bl_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_code="+formListHeader.bl_incl_excl_override_reason_code.value+"&bl_def_override_excl_incl_ind="+formListHeader.bl_def_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_desc="+encodeURIComponent(formListHeader.bl_incl_excl_override_reason_desc.value,"UTF-8")+"&approval_reqd_yn="+formListHeader.approval_reqd_yn.value+"&bl_override_allowed_yn="+formListHeader.bl_override_allowed_yn.value+ "&pat_paid_amt=" + parent.frames[0].document.getElementById('id_paid_amt').innerText+"&decimal_allowedYN="+formListHeader.decimal_allowedYN.value+"&no_of_decimals="+formListHeader.no_of_decimals.value+"&records_to_delete="+formHeader.records_to_delete.value+"&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&trn_type="+trn_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type + "&approval_no=" + encodeURIComponent(formListHeader.approval_number.value) +"&validate=ADD_TO_LIST", false);//Modified for 48809
			}
			else{
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value) + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + document.getElementById('id_store_item_unit_cost').innerText + "&item_cost_value=" + parent.frames[0].document.getElementById('id_item_sal_value').innerText+"&pat_net_amt=" + parent.frames[0].document.getElementById('id_payable_amt').innerText+"&gross_charge_amt=" + parent.frames[0].document.getElementById('id_charge_amt').innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&uom_code=" + formListHeader.uom_code.value + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&remarks=" + encodeURIComponent(formListHeader.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById('id_uom').innerText,"UTF-8") + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&batch_records=" + formListDetail.total_checkboxes.value +"&remarks_code="+formListHeader.remarks_code.value+"&bl_override_excl_incl_ind="+formListHeader.bl_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_code="+formListHeader.bl_incl_excl_override_reason_code.value+"&bl_def_override_excl_incl_ind="+formListHeader.bl_def_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_desc="+encodeURIComponent(formListHeader.bl_incl_excl_override_reason_desc.value,"UTF-8")+"&approval_reqd_yn="+formListHeader.approval_reqd_yn.value+"&bl_override_allowed_yn="+formListHeader.bl_override_allowed_yn.value+ "&pat_paid_amt=" + parent.frames[0].document.getElementById('id_paid_amt').innerText+"&decimal_allowedYN="+formListHeader.decimal_allowedYN.value+"&no_of_decimals="+formListHeader.no_of_decimals.value+"&records_to_delete="+formHeader.records_to_delete.value+"&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&trn_type="+trn_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type + "&approval_no=" + encodeURIComponent(formListHeader.approval_number.value) +"&validate=ADD_TO_LIST", false);
			}
		} else {
			//xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value) + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + document.getElementById("id_store_item_unit_cost").innerText + "&item_cost_value=" + parent.frames[0].document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&uom_code=" + formListHeader.uom_code.value + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&remarks=" + escape(formListHeader.remarks.value) + "&uom_desc=" +encodeURIComponent( document.getElementById("id_uom").innerText,"UTF-8" )+ "&batch_records=" + formListDetail.total_checkboxes.value + "&stock_available=" + document.getElementById("id_stock_available").innerText+"&remarks_code="+formListHeader.remarks_code.value +"&decimal_allowedYN="+formListHeader.decimal_allowedYN.value+"&no_of_decimals="+formListHeader.no_of_decimals.value+"&records_to_delete="+formHeader.records_to_delete.value+ "&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&validate=ADD_TO_LIST", false);
			//xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&store_code=" + store_code + "&uom_code=" + formListHeader.uom_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value,"UTF-8") + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + document.getElementById("item_unit_cost").value + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&item_cost_value=" + document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&store_alt_code=" + store_code + "&uom_desc=" + document.getElementById("id_uom").innerText + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&expired_batch=" + formListDetail.expired_batch.value + "&ex_param_days=" + formListDetail.ex_param_days.value + "&frm_store_qty_on_hand=" + formListHeader.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formListHeader.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formListHeader.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formListHeader.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formListHeader.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formListHeader.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formListHeader.to_store_max_stk_level.value + "&to_store_reorder_level=" + formListHeader.to_store_reorder_level.value + "&to_conv_fact=" + formListHeader.tmp_conv.value + "&frm_conv_fact=" + formListHeader.frm_tmp_conv.value + "&frm_store_uom_desc=" + formListHeader.frm_store_uom_desc.value + "&batch_records=" + formListDetail.total_checkboxes.value + "&to_store_uom_desc=" + formListHeader.to_store_uom_desc.value +"&allow_yn="+formListHeader.allow_deci_yn.value+"&no_decimals="+formListHeader.no_deci.value+"&kit_item_yn="+formListHeader.kit_item_yn.value+"&from_multiples="+formListHeader.from_multiples.value+"&to_multiples="+formListHeader.to_multiples.value+"&batch_multiples="+formListHeader.batch_multiples.value+"&decimal_allowedYN="+dec_allowed_yn+"&no_of_decimals="+no_of_decimals+"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&validate=ADD_TO_LIST", false);

			toConvFactor();//newly added for kit template

			var expired_batch="";
			var ex_param_days="";
			var frm_store_qty_on_hand="";
			var frm_store_min_stk_level="";
			var frm_store_max_stk_level="";
			var frm_store_reorder_level="";
			var to_store_qty_on_hand ="";
			var to_store_min_stk_level="";
			var to_store_max_stk_level="";
			var to_store_reorder_level="";
			var to_store_reorder_level="";
			var to_conv_fact="";
			var frm_conv_fact="";
			var frm_store_uom_desc="";
			var to_store_uom_desc="";
			var kit_item_yn="";
			var from_multiples="";
			var to_multiples="";
			var batch_multiples="";
			var remarks="";
			var remarks_code="";
			//var kit =""; moved up
			var for_bin_to_store_hidden="";
			var iss_uom_code="";
			var uom_conv_code="";
			var iss_uom_qty="";
			var iss_uom_conv_text="";
			var issue_uom_multiples="";
			var approval_no="";
			
			
			if(formListHeader.remarks!=undefined){
			 remarks = formListHeader.remarks.value;
			 remarks_code  = formListHeader.remarks_code.value;
			}
			
			if(formListDetail.expired_batch!=undefined){
			expired_batch=formListDetail.expired_batch.value;
			ex_param_days=formListDetail.ex_param_days.value;
			frm_store_qty_on_hand=formListHeader.frm_store_qty_on_hand.value;
			frm_store_min_stk_level=formListHeader.frm_store_min_stk_level.value;
			frm_store_max_stk_level=formListHeader.frm_store_max_stk_level.value;
			frm_store_reorder_level=formListHeader.frm_store_reorder_level.value;
			to_store_qty_on_hand =formListHeader.to_store_qty_on_hand.value;
			to_store_min_stk_level=formListHeader.to_store_min_stk_level.value;
			to_store_max_stk_level=formListHeader.to_store_max_stk_level.value;
			to_store_reorder_level=formListHeader.to_store_reorder_level.value;
			to_conv_fact = formListHeader.tmp_conv.value;
			
			if(formListHeader.frm_tmp_conv!=undefined)
			frm_conv_fact=  formListHeader.frm_tmp_conv.value;
			else
			frm_conv_fact=  formListHeader.frm_conv_fact.value;

			frm_store_uom_desc=formListHeader.frm_store_uom_desc.value;
			to_store_uom_desc=  formListHeader.to_store_uom_desc.value;
			kit_item_yn= formListHeader.kit_item_yn.value;
			from_multiples= formListHeader.from_multiples.value;
			to_multiples= formListHeader.to_multiples.value;
			batch_multiples= formListHeader.batch_multiples.value;
			//kit = formListHeader.kit.value; moved up
			
			if(formListHeader.for_bin_to_store_hidden!=undefined){
			for_bin_to_store_hidden= formListHeader.for_bin_to_store_hidden.value;
			iss_uom_code= formListHeader.iss_uom_code.value;
			uom_conv_code= formListHeader.iss_conv_fact.value;
			iss_uom_qty= formListHeader.iss_uom_qty.value;
			iss_uom_conv_text= document.getElementById('id_iss_uom_conv').innerHTML;
			issue_uom_multiples=formListHeader.issue_uom_multiples.value;
			}

			}
		var item_unit_cost ="";
		if(trn_type == 'SAL' ){
			 item_unit_cost = document.getElementById('id_store_item_unit_cost').innerText;
			 approval_no=encodeURIComponent(formListHeader.approval_number.value);//Added for IN:071972
		}
		else 
			item_unit_cost = document.getElementById('item_unit_cost').value ;
			if(trn_type == "URG"){
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&store_code=" + store_code + "&uom_code=" + formListHeader.uom_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value,"UTF-8") + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + item_unit_cost + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&item_cost_value=" + document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&store_alt_code=" + store_code + "&uom_desc=" + encodeURIComponent( document.getElementById('uom_desc').innerText,"UTF-8" ) + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&expired_batch=" + expired_batch + "&ex_param_days=" + ex_param_days + "&frm_store_qty_on_hand=" + frm_store_qty_on_hand + "&frm_store_min_stk_level=" + frm_store_min_stk_level + "&frm_store_max_stk_level=" + frm_store_max_stk_level + "&frm_store_reorder_level=" + frm_store_reorder_level + "&to_store_qty_on_hand=" + to_store_qty_on_hand + "&to_store_min_stk_level=" + to_store_min_stk_level + "&to_store_max_stk_level=" + to_store_max_stk_level + "&to_store_reorder_level=" + to_store_reorder_level + "&to_conv_fact=" + to_conv_fact + "&frm_conv_fact=" + frm_conv_fact + "&frm_store_uom_desc=" + frm_store_uom_desc + "&batch_records=" + formListDetail.total_checkboxes.value + "&to_store_uom_desc=" + to_store_uom_desc+"&kit_item_yn="+kit_item_yn+"&from_multiples="+from_multiples+"&to_multiples="+to_multiples+"&batch_multiples="+batch_multiples+"&decimal_allowedYN="+dec_allowed_yn+"&no_of_decimals="+no_of_decimals + "&remarks=" + escape(remarks) +"&remarks_code="+ remarks_code + "&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&records_to_delete="+formHeader.records_to_delete.value+ "&for_bin_to_store_hidden=" + for_bin_to_store_hidden	+ "&iss_uom_code=" + iss_uom_code + "&uom_conv_code=" + uom_conv_code+ "&iss_uom_qty=" + iss_uom_qty + "&iss_uom_conv_text=" + iss_uom_conv_text + "&issue_uom_multiples=" + issue_uom_multiples+"&trn_type="+trn_type +"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type+"&approval_no="+approval_no+"&validate=ADD_TO_LIST", false);//Modified for for IN:071972,Modified for 48809
			}
			else{
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value + "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&store_code=" + store_code + "&uom_code=" + formListHeader.uom_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value,"UTF-8") + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + item_unit_cost + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&item_cost_value=" + document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formListHeader.expiry_yn.value + "&store_alt_code=" + store_code + "&uom_desc=" + encodeURIComponent( document.getElementById('id_uom').innerText,"UTF-8" ) + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&expired_batch=" + expired_batch + "&ex_param_days=" + ex_param_days + "&frm_store_qty_on_hand=" + frm_store_qty_on_hand + "&frm_store_min_stk_level=" + frm_store_min_stk_level + "&frm_store_max_stk_level=" + frm_store_max_stk_level + "&frm_store_reorder_level=" + frm_store_reorder_level + "&to_store_qty_on_hand=" + to_store_qty_on_hand + "&to_store_min_stk_level=" + to_store_min_stk_level + "&to_store_max_stk_level=" + to_store_max_stk_level + "&to_store_reorder_level=" + to_store_reorder_level + "&to_conv_fact=" + to_conv_fact + "&frm_conv_fact=" + frm_conv_fact + "&frm_store_uom_desc=" + frm_store_uom_desc + "&batch_records=" + formListDetail.total_checkboxes.value + "&to_store_uom_desc=" + to_store_uom_desc+"&kit_item_yn="+kit_item_yn+"&from_multiples="+from_multiples+"&to_multiples="+to_multiples+"&batch_multiples="+batch_multiples+"&decimal_allowedYN="+dec_allowed_yn+"&no_of_decimals="+no_of_decimals + "&remarks=" + escape(remarks) +"&remarks_code="+ remarks_code + "&billable_item_yn="+formListHeader.billable_item_yn.value+"&sale_req_qty="+formListHeader.sale_req_qty.value+"&records_to_delete="+formHeader.records_to_delete.value+ "&for_bin_to_store_hidden=" + for_bin_to_store_hidden	+ "&iss_uom_code=" + iss_uom_code + "&uom_conv_code=" + uom_conv_code+ "&iss_uom_qty=" + iss_uom_qty + "&iss_uom_conv_text=" + iss_uom_conv_text + "&issue_uom_multiples=" + issue_uom_multiples+"&trn_type="+trn_type +"&bean_id="+bean_id+"&bean_name="+bean_name+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type+"&approval_no="+approval_no+"&validate=ADD_TO_LIST", false);//Modified for for IN:071972
			}
		}

		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			if (formHeader.preview!=undefined)
			formHeader.preview.disabled = false;

			var arr = "";
			for (i = 0; i < parseInt(formDetail.total_checkboxes.value); i++) {
				if ((eval("formDetail.checkbox" + i).checked)) {
					arr = arr + "," + "CHECKED";
				} else {
					arr = arr + "," + "s";
				}
			}			
			refreshDetailsforBarCode(formListHeader.index.value,ListHeader,Detail,store_code,arr,to_conv_fact,frm_conv_fact,kit);		
			//refreshDetailsforBarCode(formListHeader.index.value,ListHeader,Detail);

		} else {
			formListHeader.apply.disabled = false;
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + (message);
			parent.frames[1].location.href = "../../eCommon/html/blank.html";
		}
	} 
}



function refreshDetailsforBarCode(index,ListHeader,Detail,store_code,arr,tmp_conv,frm_tmp_conv,kit) {
	if(index!='999')
	parent.parent.frames[1].location.href = ["../../eST/jsp/"+Detail+".jsp?index=" + index + "&store_code=" + store_code + "&arr=" + arr + "&tmp_conv=" + tmp_conv + "&frm_tmp_conv=" + frm_tmp_conv + "&kit=" + kit+ "&kit12=" + kit + "&BARCODE_YN=TRUE"];
	parent.frames[0].location.href = ["../../eST/jsp/" + ListHeader + ".jsp"];	
	parent.frames[1].location.href = "../../eCommon/html/blank.html";	
}


function callItemQtyUpdate(){
	
	var Obj	=  parent.parent.frames[0].document.forms[0].defaultqty_value1;
	var bar_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1;
	if(bar_appl.value=='Y' && document.forms[0].item_code.value!=null){
	if(Obj.value==1 && parent.parent.frames[0].document.forms[0].editqty_appl1.value != 'Y' &&  document.forms[0].bar_or_item_code.value == 'B'){
		if (parent.frames[1].document.forms[0] != undefined) {
			var index = parent.frames[1].document.forms[0].total_checkboxes.value ;	
				if(parent.frames[0].document.forms[0].noofbatchesforbarcode.value=="1"){
					if(parent.frames[0].document.forms[0].iss_uom_qty!=undefined){
						parent.frames[0].document.forms[0].iss_uom_qty.value = Obj.value;
					}				
					parent.frames[0].document.forms[0].item_qty.value = Obj.value;
					//parent.frames[0].document.forms[0].tot_item_qty.value = Obj.value;	
						
					if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
					parent.frames[0].document.forms[0].tot_item_qty.value = Obj.value;
					}else if(parent.frames[0].document.forms[0].ret_qty!=undefined){
					parent.frames[0].document.forms[0].ret_qty.value= Obj.value;
					}
				}
			

			if (parseInt(index)==1){
				parent.frames[1].document.forms[0].item_qty_0.value = Obj.value;
			}
	  }
	}
	else if(document.forms[0].item_qty.value>0){
		if (parent.frames[1].document.forms[0] != undefined) {
		var index = parent.frames[1].document.forms[0].total_checkboxes.value ;		
		if (parseInt(index)==1 ){			
			var item_qty_new = document.forms[0].item_qty;
			parent.frames[1].document.forms[0].item_qty_0.value = document.forms[0].item_qty.value;
			var avail_qty = parent.frames[1].document.forms[0].available_qty_0.value ;
			var dec_allowed_yn = parent.frames[1].document.forms[0].dec_allowed_yn.value ;			
			var qty_val = checkBatchQtyforBarcode(item_qty_new,avail_qty,dec_allowed_yn);

			var tot_item_qty;
			if(document.forms[0].tot_item_qty!=undefined)
			var tot_item_qty = document.forms[0].tot_item_qty.value ;
			else
			var tot_item_qty = document.forms[0].ret_qty.value;

			if(qty_val)
			chargeDetailsExp(document.forms[0].item_code.value,tot_item_qty);   
			//document.forms[0].apply.click();
		}
		}else{
			//document.forms[0].apply.click();
		}
	}
	}
}
function checkBatchQtyforBarcode(obj, available_qty,dec_allowed_yn) {
	var ret = true;
	if(dec_allowed_yn=="Y"){
		if (!checkDoubleFormat(eval(obj))) {  
			ret = false;
			return false;
		}
	}else{
		if (!checkIntegerFormat(eval(obj))) {  
			ret = false;
			return false;
		}
	}
		if (parseFloat(available_qty) < parseFloat(obj.value)) {
			alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
			ret = false;
			obj.value="";
			obj.focus();
		}
	return ret;
}


function editViewBatchForBarCode(ListDetail) {
	var formObj = document.forms[0];
	
	if (parent.frames[1].document.forms[0] != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}			
		var _item_code = formObj.item_code.value;
		var item_qty = "";
		formObj.edit.disabled=true;
		formObj.batchsearch.disabled=true;
		//var defaultqty_appl= parent.parent.frameSalesHeader.document.formSalesHeader.defaultqty_appl1.value; 
		//var editqty_appl= parent.parent.frameSalesHeader.document.formSalesHeader.editqty_appl1.value; 
		var defaultqty_appl= parent.parent.frames[0].document.forms[0].defaultqty_appl1.value; 
		var editqty_appl= parent.parent.frames[0].document.forms[0].editqty_appl1.value; 
		if(item_qty== ""){
		parent.frames[1].location.href = ["../../eST/jsp/"+ListDetail+".jsp?function=barcode&item_code=" + _item_code + "&expiry_yn=" + formObj.expiry_yn.value + "&item_qty=" + item_qty+ "&index=" + formObj.index.value  + "&defaultqty_appl=" + defaultqty_appl  + "&editqty_appl=" + editqty_appl ] ;		
		}
}

function newbatch(bean_id,bean_name){

	var formListHeader = parent.frames[0].document.forms[0];
	//var xmlHttp_ = new ActiveXObject("Microsoft.XMLHTTP");
	//var xmlDoc_ = new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp_ = new XMLHttpRequest();
	var xmlDoc_="";
	//xmlDoc_.loadXML(getEnhancedXMLString(formListHeader));	
	xmlDoc_ = new DOMParser().parseFromString(getEnhancedXMLString(formListHeader), "text/xml");	
	xmlHttp_.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=addnewbatch&index=" + formListHeader.index.value+"&bean_id="+bean_id+"&bean_name="+bean_name+ "&item_code=" + formListHeader.item_code.value +"&BARCODE_YN=TRUE" + "&AddBatchRecords=Y", false);
	xmlHttp_.send(xmlDoc_);
	responseText = xmlHttp_.responseText;
	eval(responseText);
}

function GoItem_desc(){
if(document.forms[0] != undefined){
if(parent.frameSalesList.frameSalesListHeader.document.formSalesListHeader.item_desc.value=="")
parent.frameSalesList.frameSalesListHeader.document.formSalesListHeader.item_desc.focus();
}
}
//Added for GHL-CRF-0413 starts
function GoBarcode(){
	if(document.forms[0] != undefined){
		if(parent.frameSalesList.frameSalesListHeader.document.formSalesListHeader.barcode != undefined && parent.frameSalesList.frameSalesListHeader.document.formSalesListHeader.barcode.value=="" && parent.frameSalesList.frameSalesListHeader.document.formSalesListHeader.barcode.disabled != true )
			parent.frameSalesList.frameSalesListHeader.document.formSalesListHeader.barcode.focus();
		else if(parent.frameSalesList.frameSalesListHeader.document.formSalesListHeader.item_desc.value=="")
			parent.frameSalesList.frameSalesListHeader.document.formSalesListHeader.item_desc.focus();
		}
	}
//Added for GHL-CRF-0413 ends

function GoItem_desc1(){
if(parent.parent.frames[0].document.forms[0].remarks != undefined){
parent.parent.frames[0].document.forms[0].remarks.focus();
parent.parent.frames[0].document.forms[0].remarks.blur();
}
}
/* added in the above itself
function callBarCodeBatchSearchonClick(barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	
	//alert(barcode.value+"-"+trntype.value +"-"+fromStore.value +"-"+toStore.value +"-"+formObj.name +"-"+bean_id +"-"+bean_name+"-"+ ListHeader+"-"+ ListDetail +"-"+Detail);
	var bar_code	= barcode.value;
	var trn_type	= trntype.value;
	var fromStore   = fromStore.value;
	var toStore		= toStore.value;
	var formObj		= formObj.name; 
	var barcode_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;

	var resultArray	;	
	if (barcode_appl=="Y"){
	if (toStore==undefined)
		toStore="";	
	

	var xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc   = new ActiveXObject("Microsoft.XMLDom");
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + trn_type + "&bar_code=" + bar_code + "&formObj=" + formObj  +"&fromStore=" + fromStore + "&toStore=" + toStore + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&jsp_page=" + ListDetail + "&validate=BARCODE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if(result){
		if (document.forms[0].bar_or_item_code.value == 'B'){
		if (trn_type=="SAL"){  		
		 resultArray = message.split(";");
		 var  item_code   = 	resultArray[0];
		 var  batch_id    = 	resultArray[1];
		 var  expiry_date = 	resultArray[2];		  
		 var bill_linked = callItemValProcedure(item_code,fromStore,batch_id,expiry_date,ListDetail,bean_id,bean_name);
		 if (bill_linked)
		 {
				    var _xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					var _xmlDoc = new ActiveXObject("Microsoft.XMLDom");
					_xmlDoc.loadXML(getXMLString(null));
					_xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=AFTER_BILLING_LINKED&item_code=" + item_code + "&store_code=" + fromStore + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&jsp_page=" + ListDetail + "&bean_id=" + bean_id + "&bean_name=" + bean_name  + "&BARCODE_YN=TRUE", false);
					_xmlHttp.send(_xmlDoc);
					eval(responseText);
			if(result){
				editViewBatchForBarCode(ListDetail);

			 if (parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'Y'  && parent.parent.frames[0].document.forms[0].editqty_appl1.value=='N') {
				setInterval('CheckQuantity(document.forms[0].item_qty)',200);
				setInterval('calTotalQty();',200);
				setInterval('chargeDetailsExp(document.forms[0].item_code.value);',200);
				if(document.forms[0].index.value==-1 ){
				setInterval("addToListforBarCode1('"+bean_id+"','"+bean_name+"','"+ListHeader+"','"+ListDetail+"','"+Detail+"');",500);
				}
			}
			}
		}
		else{
		 		alert(getMessage("EFFECTIVE_RATE_NOT_AVAILABLE", "ST"));
				refreshDetailsforBarCode('999',ListHeader,Detail);
		}
		}else{		
				if (parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'Y'  && parent.parent.frames[0].document.forms[0].editqty_appl1.value=='N') {
				setInterval('checkminmaxstatus()',200);
				setInterval('totalqty()',200);
				setInterval('calIssueQty()',200);
				setInterval('CheckQuantity()',200);
			//	setInterval('CheckDtlQuantity(document.forms[0].index.value)',200);
				if(document.forms[0].index.value==-1 ){
				setInterval("addToListforBarCode1('"+bean_id+"','"+bean_name+"','"+ListHeader+"','"+ListDetail+"','"+Detail+"');",500);
				}
			}
			}
		}
	
	}
	else
	 {	
	    parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";	//err_num=" + message;

		if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.forms[0].phy_inv_id.value);
				return;
		} else {
			if(getMessage(message, "ST") != ""){
				alert(getMessage(message, "ST"));
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			}
			else{
				alert(message);
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			}
		}
	 }
	}
	else{
		callItemSearchScreen();
	}
}
*/
function MINMAX_CONVCALCULATE(allow_decimals_yn,trn_type){
	var page="";

	if (trn_type=="TFR"){
	page="StockTransferValidate";
	}else if(trn_type=="URG"){
	page="IssueValidate";
	}
	//Added against GHL-CRF-0413 starts
	else if(trn_type=="ISS"){
	page="IssueValidate";
	}
	else if(trn_type=="RET"){
	page="IssueReturnValidate";
	}
	//Added against GHL-CRF-0413 ends
	var formObj = document.forms[0];
	var from_store_code = parent.parent.frames[0].document.forms[0].from_store_code.value; 
	var to_store_code = parent.parent.frames[0].document.forms[0].to_store_code.value; 
	var iss_uom_code ="";

	if(document.forms[0].iss_uom_code!=undefined)
	iss_uom_code=	document.forms[0].iss_uom_code.value;

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + from_store_code + "&to_store_code=" + to_store_code + "&validate=MIN_MAX_STATUS", false);
	xmlHttp.open("POST", ["../../eST/jsp/"+page+".jsp?item_code=" + formObj.item_code.value + "&store_code=" + from_store_code + "&to_store_code=" + to_store_code + "&validate=MIN_MAX_STATUS"], false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	if(allow_decimals_yn=="N"){
	//var xmlHttp1 = new ActiveXObject("Microsoft.XMLHTTP");
	//var xmlDoc1 = new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc1="";
	//xmlDoc1.loadXML(getXMLString(null));
	xmlDoc1 = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//xmlHttp1.open("POST", "../../eST/jsp/StockTransferValidate.jsp?item_code=" + formObj.item_code.value + "&fm_store_code=" + from_store_code + "&to_store_code=" + to_store_code + "&validate=CONV_CALCULATE", false);
	xmlHttp1.open("POST", ["../../eST/jsp/"+page+".jsp?item_code=" + formObj.item_code.value + "&fm_store_code=" + from_store_code + "&to_store_code=" + to_store_code + "&issue_uom_code=" + iss_uom_code + "&validate=CONV_CALCULATE"], false);
	xmlHttp1.send(xmlDoc1);
	responseText = xmlHttp1.responseText;
	eval(responseText);
	}

}
// Bar Code implementation ends here

//Added NewFunction  By Sakti Sankar for the leap year issue on 27/02/2012

function ChekDate(obj,locale){
	if(obj.value){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			//obj.select();
			obj.value = "";
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}
//Added ended

function CallNewBarcodeString(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,trade_id,binlocn_code,store_code,barcode_id,item_qty,mrp){
	//if(document.forms[0].BarcodeRule.value=="P" || document.forms[0].BarcodeRule.value=="S"){
		var trn_type = document.forms[0].trn_type.value;
	 if(document.forms[0].BarcodeRule.value=="P"){
		if(batch_id.value!= "" || Expiry_date.value!= ""){
			var manufacturer_id = document.forms[0].manufacturer_id.value;
			var supplier_id = document.forms[0].supplier_id.value;
			//var mrp = document.forms[0].mrp.value;

			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id.value+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp.value+ "&trade_id=" + trade_id.value+ "&trn_type=" + trn_type+ "&BarcodeRule=" + document.forms[0].BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			barcode_id.value= message.substring(0,60);
		}
		} else if(document.forms[0].BarcodeRule.value=="S"){
		if(barcode_id.value=="" && item_qty != undefined && item_qty.value!="" && batch_id.value!= ""){
			var manufacturer_id = document.forms[0].manufacturer_id.value;
			var supplier_id = document.forms[0].supplier_id.value;
			//var mrp = document.forms[0].mrp.value;

			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id.value+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp.value+ "&trade_id=" + trade_id.value+ "&trn_type=" + trn_type+ "&BarcodeRule=" + document.forms[0].BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			barcode_id.value=message;
		}
	}
}

function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-/:";// modified by chandrashekar for the incident MO-GN-5351
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122)) {
		return (event.keyCode -= 32);
	}
	return true;
}


function isValidNumberforMultiLine(fld, e, maxInt, deci,dec_allowed_yn) {

	dec_allowed_yn = dec_allowed_yn.value;

	if(dec_allowed_yn=="N"){
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

//Added By Sakti Sankar on 10/09/2012 against Inc#34872
function CheckMaxYearForExpiryDate(obj,locale){
	var enteredDate = "";
	var MaxExpDate = ""
	if(obj.value){
		if(locale == "th"){
		 MaxExpDate = "31/12/3542";
		 enteredDate = convertDate(obj.value,'DMY',locale,"en");
		}else{
			MaxExpDate = "31/12/2999";
			enteredDate = obj.value;
		}
		
		var enteredDateArray = enteredDate.split("/");
		if (enteredDateArray[2] > "2999" ) {
			alert(getMessage("EXP_DATE_CANNOT_GRTR", "ST")+ MaxExpDate);
			obj.select();
			obj.value=''; //Edge Having issue as it is going in loop, so have to clear.
			obj.focus();
			return false;
		}
	}
}

async function callBatchSearchforBarcodeMultiBatch(fromStore,barcode,ListDetail) {
	var formObj = document.forms[0];
	var arrayObject = new Array(formObj.item_code);
	var names = new Array(getLabel("Common.item.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);

	formObj.edit.disabled=true;
	formObj.batchsearch.disabled=true;
	var defaultqty_appl= parent.parent.frames[0].document.forms[0].defaultqty_appl1.value; 
	var editqty_appl= parent.parent.frames[0].document.forms[0].editqty_appl1.value; 

	if (blankObject == true) {
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.item_qty.value;
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "Y";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "Y";
		var retval =await callBatchSearchWindowforBarcode(_item_code, fromStore, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, "", "", "", "","",barcode);
		
		//alert(retval.match(/~/g).length); to check the number of occurance
		if (retval != null && retval!="" && retval!=undefined) {
			var noofbatches = retval.indexOf("~");
			if(noofbatches==-1){
				document.forms[0].noofbatchesforbarcode.value = "1";
			}else{
				document.forms[0].noofbatchesforbarcode.value = "2";
			}

			parent.frames[1].location.href = ["../../eST/jsp/"+ListDetail+".jsp?function=barcode&BarcodeWithMultipleBatches=Y&item_code=" + _item_code + "&expiry_yn=" + formObj.expiry_yn.value + "&index=" + formObj.index.value + "&defaultqty_appl=" + defaultqty_appl  + "&editqty_appl=" + editqty_appl] ;	
		}
	}
}
async function callBatchSearchWindowforBarcode(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, cuttOffDate, doc_type_code, doc_no, trn_type,itemStoreDisable,barcode) {
	if (cuttOffDate == null) {
		cuttOffDate = "";
	}
	if (doc_type_code == null) {
		doc_type_code = "";
	}
	if (doc_no == null) {
		doc_no = "";
	}
	if (trn_type == null) {
		trn_type = "";
	}
	retVal = await window.showModalDialog("../../eST/jsp/BatchSearchFrameForBarcode.jsp?item_code=" + item_code + "&store_code=" + store_code + "&includeZeroStockBatches=" + includeZeroStockBatches + "&includeExpiredBatches=" + includeExpiredBatches + "&includeSuspendedBatches=" + includeSuspendedBatches + "&searchFunction=" + searchFunction + "&multipleSelect=" + multipleSelect + "&cuttOffDate=" + cuttOffDate + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&trn_type=" + trn_type+"&itemStoreDisable="+itemStoreDisable+"&barcode="+barcode, "", "dialogHeight:80vh; dialogWidth:70vw; center:0; status: no; dialogLeft :200; dialogTop :100;");	

	while(retVal==undefined){
		retVal =await window.showModalDialog("../../eST/jsp/BatchSearchFrameForBarcode.jsp?item_code=" + item_code + "&store_code=" + store_code + "&includeZeroStockBatches=" + includeZeroStockBatches + "&includeExpiredBatches=" + includeExpiredBatches + "&includeSuspendedBatches=" + includeSuspendedBatches + "&searchFunction=" + searchFunction + "&multipleSelect=" + multipleSelect + "&cuttOffDate=" + cuttOffDate + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&trn_type=" + trn_type+"&itemStoreDisable="+itemStoreDisable+"&barcode="+barcode, "", "dialogHeight:80vh; dialogWidth:70vw; center:0; status: no; dialogLeft :200; dialogTop :100;");
	
	}
	return retVal;
}
//Added ends
//Added By Sakti sankar against inc#34757 CRF#81
function CheckForSpecialCharsForAllCase(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-/:";// modified by chandrashekar for the incident MO-GN-5351
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	return true;
}

function checkdateWithSysDateTo(entered_date, sys_date) {
	/* Entered Date Should not be less than sysdate Krishna 1/13/2009 */
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) {
				
			return false;
		} else {
			if (Date.parse(sysDateObject) > Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}
//Added By Sakti Sankar for commonly validating from_date and to_date
/*function checkSysdateTo(receiptdate, sysdate) {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(receiptdate.value!=""){
		var flag = ChkDate(receiptdate);
		if (!flag) {

		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}

		if (flag) {
			if (checkdateWithSysDateTo(receiptdate, sysdate)) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("TO_DOC_DATE_NOT_LESS_FRM_DOC_DATE","ST");
			return false;
						
			}else{
			parent.frames[0].document.forms[0].submit();
			}
		}
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	
}*/
//Added ends
function checkSysdateTo(sysdate,receiptdate) {
    if (isValidSysDateField(receiptdate, sysdate, DATE, getLabel("Common.DocDate.label", "Common"))) {
		//formObj.submit();  
    	
    	if (typeof(originalFormAction) != 'undefined' && originalFormAction != null)
    	{
    		parent.frames[0].document.forms[0].action = originalFormAction;
    		parent.frames[0].document.forms[0].target = originalFormTarget;
    	}
		
		parent.frames[0].document.forms[0].submit();
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}else {
		return; 
	}
}
function isValidSysDateField(fromObj, toObj, dataType, stLegend) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:		
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue > stToValue) {
			bReturn = false;
		}
	}
	if ((!bReturn)) {
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		//alert(stMessage);
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + stMessage;
		 toObj.focus();
		 return false;	
	}
	return bReturn;
}

//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	 
async function callItemSpcfnWindow(item_code,item_name) {
		//var retVal		=	window.showModalDialog("../../eST/jsp/DisplayItemspecification.jsp?item_name=" + encodeURIComponent(item_name,"UTF-8")+"&item_code=" + item_code , "", "dialogHeight:15; dialogWidth:50; center:0; status: no; dialogLeft :120; dialogTop :250;scroll:yes");

		//Modified by sakti against ML-BRU-SCF-0963[INC#42099]	
	var retVal		=	await window.showModalDialog("../../eST/jsp/DisplayItemspecification.jsp?item_name=" + item_name.value+"&item_code=" + item_code , "", "dialogHeight:70vh; dialogWidth:80vw; center:0; status: no; dialogLeft :120; dialogTop :250;scroll:yes");

}

function onMOut(obj) {
	obj.innerHTML = "";
	obj.style.width = 0;
	obj.style.borderColor = "";
	obj.style.borderWidth = "";
	obj.style.borderStyle = "";
}

function onMOver(obj, e, item_specfn_name,item_remarks,item_name) {

	item_remarks = decodeURIComponent(item_remarks,"UTF-8");
	item_specfn_name = decodeURIComponent(item_specfn_name,"UTF-8");
	item_name = decodeURIComponent(item_name,"UTF-8");

	if(item_remarks.length > 100) {//Added against inc#39623 for displaying 100 characters in tooltip
		item_remarks =  item_remarks.substring(0, 100);
		item_remarks = item_remarks + " ...";
	}
	if(item_specfn_name.length > 100) {
		item_specfn_name =  item_specfn_name.substring(0, 100);
		item_specfn_name = item_specfn_name + " ...";
	}
//Added ends

	//obj.style.left = e.x - 180;
	obj.style.left = 30; //Added against inc#39529 for fixed size of tooltip
	obj.style.top = e.y + 30;
	obj.style.borderColor = "";
	obj.style.borderWidth = "thin";
	obj.style.borderStyle = "groove";
	obj.style.width = 30;
		
	if(item_specfn_name != "" && item_remarks !="" ) {
	obj.innerHTML = "<table cellspacing='0' cellpadding='0' border='1'  ><tr><td class='ITEMSELECT' width=300 nowrap align=left> <b>" + "Item "+ " :</b>"+ item_name+ "</td></tr><tr></tr><tr><th width=300 nowrap align=center>" + getLabel("eMM.ItemRemarks.label", "MM") + "</th></tr><tr><td class='OAQRYEVEN' align='left'  >" + item_remarks + "</td> </tr> <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr> <tr><th width=300 nowrap align=center>" + getLabel("eMM.ItemSpecification.label", "MM") + "</tr></th><tr><td class='OAQRYODD' align='left' >" +  item_specfn_name + "</td></tr></table>";
	return;
	} if(item_remarks !="" )  {
	obj.innerHTML = "<table cellspacing='0' cellpadding='0' border='1' height=100% ><tr><td class='ITEMSELECT' width=300 nowrap align=left><b> " + "Item "+ " :</b>"+  item_name+ "</td></tr><tr></tr><tr><th width=300 nowrap align=center>" + getLabel("eMM.ItemRemarks.label", "MM") + "</th></tr><tr><td class='OAQRYEVEN' align='left'  >" + item_remarks +"</td> </tr> </table>";
	return;
	} if(item_specfn_name !="" ) {
	obj.innerHTML = "<table cellspacing='0' cellpadding='0' border='1' height=100% ><tr><td class='ITEMSELECT' width=300 nowrap align=left><b> " + "Item "+ " :</b>"+  item_name+ "</td></tr> <tr><th width=300 nowrap align=center>" + getLabel("eMM.ItemSpecification.label", "MM") + "</tr></th><tr><td class='OAQRYODD' align='left' >" +  item_specfn_name + "</td></tr></table>";
	return;
	} 

}//Added ends

//Added by suresh.r 07-against JD-CRF-156 beg
async function callFinancialDetailScreen() {
	var formObj								= document.forms[0];
	var resultArray							="";
	var episodeid                           	= "";
	var episode1                           	= "";
	var dialogTop                          	= "200";
	var dialogHeight                      	= "100vh" ; 
	var dialogWidth                       	= "90vw" ; 
	var features                           	= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments                         	= "" ;
	//var search_desc                       	= ""; 
	var title                              	= getLabel("eBL.PAT_ENCOUNTER_FIN_DTLS.label","BL");
	var encounter_id 					  	= formObj.encounter_id.value;
	var patient_id 						   	= formObj.patient_id.value;
	var visitid							   	= "";
	var column_sizes 					   	= escape("");               
	var column_descriptions 				= "";       
	if(encounter_id!="" && patient_id!=""){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?patient_id=" + patient_id + "&validate=VAL_DISPFINDTL&encounter_id=" +encounter_id+"&val_flag=2" , false); 
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		resultArray = message.split("|");
		episodeid   = 	resultArray[0];
		visitid    = 	resultArray[1];
		var param 								= "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episodeid="+
		episodeid+"&"+"visitid="+visitid+"&"+"patientid="+patient_id+"&episode1="+episode1;
		await window.showModalDialog("../../eBL/jsp/BLFinDtlQryMain.jsp?"+param,arguments,features);
	}

}

function blinkText(name,textId,timeA,timeB,colourA,colourB){/* (C)2002 S Chalmers */
	if(document.getElementById){
		this.isEnabled=true;
		this.textId=document.getElementById(textId);
		this.name=name;
		this.timeA=timeA;
		this.timeB=timeB;
		this.colourA=colourA;
		this.colourB=colourB; 
		this.state=0;
		this.timer=null;
		setTimeout(this.name+'.tBlink()',10);
	}
}

blinkText.prototype.tBlink=function(){
	if(this.isEnabled){
		this.textId.style.color = (this.state^=1) ? this.colourA : this.colourB;
		this.timer=setTimeout(this.name+".tBlink()", this.state ? 
		this.timeA : this.timeB )
	}
}

blinkText.prototype.stopBlink=function(){
	this.isEnabled=false;
}

blinkText.prototype.startBlink=function(){
	if(this.isEnabled==false){
		this.isEnabled=true;
		this.tBlink();
	}
}

blinkText.prototype.toggleBlink=function(){
	if(this.isEnabled^=true);
		this.tBlink();
}
//Added by suresh.r 07-11-2013 against JD-CRF-156 end
//Added by B.Badmavathi for leap year issue on 22/7/2015 beg
function CheckDateLeap(obj, format, locale){
	if(obj.value!=""){
		if(!validDate(obj.value, format,locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			//obj.select();
			obj.value="";
			obj.focus();
			return false;
		}else{
			return true;
		}
	} 
}//Added by B.Badmavathi for leap year issue on 22/7/2015 End
//Added for GHL-CRF-0464 starts
function autoQtyUpdate(){ 
	var Obj	=  parent.parent.frames[0].document.forms[0].defaultqty_value1.value;
	var site = parent.frames[0].document.forms[0].site.value;
	var bar_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
	var trn_type=parent.parent.frames[0].document.forms[0].trn_type.value;
	var barcode = parent.frames[0].document.forms[0].barcode;
	var editqty = parent.parent.frames[0].document.forms[0].editqty_appl1.value;
	var bar_or_item_code = parent.frames[0].document.forms[0].bar_or_item_code.value;
	if(bar_appl=='Y' && parent.frames[0].document.forms[0].item_code.value!=null && Obj==1 && editqty != 'Y' &&  bar_or_item_code == 'B' && site){
		if (parent.frames[1].document.forms[0] != undefined && parent.frames[1].document.forms[0] != null) {
			var formObjDtl = parent.frames[1].document.forms[0];
			if(parent.frames[0].document.forms[0].tot_item_qty !=undefined)
				var item_qty = parent.frames[0].document.forms[0].tot_item_qty.value;
			if(parent.frames[0].document.forms[0].ret_qty !=undefined)
				var item_qty = parent.frames[0].document.forms[0].ret_qty.value;
			if(parent.frames[0].document.forms[0].item_qty !=undefined)// added for GHL-CRF-0465 Start
				var item_qty = parent.frames[0].document.forms[0].item_qty.value;
				if(parent.frames[0].document.forms[0].iss_uom_qty !=undefined)
					var item_qty = parent.frames[0].document.forms[0].iss_uom_qty.value;	
			var _total_checkboxes = formObjDtl.total_checkboxes.value;// GHL-CRF-0465 END
			var no_of_decimals=formObjDtl.no_of_decimals.value;
			var sum = 0;
			var i =0;
			for ( i = 0; i < _total_checkboxes; i++) {
				var qty = eval("formObjDtl.item_qty_" + i).value;
				if (qty == "") {
					qty = 0;
				}
				if (!isNaN(qty)) {
					sum += parseFloat(qty);
				}
			}
		if(formObjDtl.dec_allowed_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);
			if (sum != item_qty) {
				if(parent.frames[0].document.forms[0].tot_item_qty !=undefined)
					parent.frames[0].document.forms[0].tot_item_qty.value =sum;
				if(parent.frames[0].document.forms[0].ret_qty !=undefined)
					parent.frames[0].document.forms[0].ret_qty.value =sum;
				if(parent.frames[0].document.forms[0].iss_uom_qty !=undefined)//added GHL-CRF-0465
					parent.frames[0].document.forms[0].iss_uom_qty.value=sum;//added GHL-CRF-0465
				parent.frames[0].document.forms[0].item_qty.value = sum;
				barcode.focus();	
			}
		}
	}
}
//Added for GHL-CRF-0464 ends


//added AMS-SCF-0677 - barcode issue
function setItemDescription(formname,item_desc){

	//document.formStockTransferListHeader.item_desc.value=decodeURIComponent(item_desc,"UTF-8");
	document.getElementById(formname).item_desc.value=decodeURIComponent(item_desc,"UTF-8");
	
}
// Modified for IN:073900 start
async function callItemSearchWindow1(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,trn_type,barcodeid) {
	retVal = await window.showModalDialog("../../eST/jsp/ItemSearch.jsp?search_string=" + encodeURIComponent(search_string,"UTF-8") + "&store_code=" + store_code + "&category=" + category + "&sole_source=" + sole_source + "&ps_item=" + ps_item + "&mfg_item=" + mfg_item + "&expiry=" + expiry + "&item_class=" + item_class + "&consignment=" + consignment +"&trn_type=" + trn_type+"&barcode_id=" + barcodeid, "", "dialogHeight:70vh; dialogWidth:80vw; center:0; status: no; dialogLeft :115; dialogTop :100;");
	return retVal;
}
// Modified for IN:073900 end
//Added for TFS id:6938 start
async function callItemSearchScreenForQueryFunction(e,barcode,calledfrom,bean_id,bean_name,formobj){
	
	if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0){
		var bar_code	= barcode.value;
		if (bar_code != ''){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=BARCODE_QUERY_FUNCTION&barcode=" + bar_code+ "&calledfrom=" + calledfrom+ "&bean_id=" + bean_id+ "&bean_name=" + bean_name+"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if(result){
				 barcode.value = "";
				 if(calledfrom=="SSBI"){
					 var search_string = formobj.item_code.value;
						var store_code = "";
						var category = "A";
						var sole_source = "A";
						var ps_item = "A";
						var mfg_item = "A";
						var expiry = "A";
						var consignment = "A";
						var item_class = "";
						var retVal = await callItemSearchWindow1(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"",bar_code);
						if (retVal != null) {
								var item_C = retVal[0];
								item_Cod = item_C;
								var no_of_decimals_for_cost = eval(parent.frameStockStatusSearchQueryCriteria.formStockStatusQueryCriteria.no_of_decimals_for_cost.value);
								var unit_cost = setNumber(retVal[14], no_of_decimals_for_cost);
								var exp_yn = retVal[2];
								var store_code = retVal[20];
								var dflt_facility_id  = parent.frameStockStatusSearchQueryCriteria.formStockStatusQueryCriteria.dflt_facility_id.value;
								document.formStockStatusQueryCriteria.unit_cost_facility.value = unit_cost;
								document.formStockStatusQueryCriteria.id_min_lev.value = retVal[7];
								var temp_jsp = "../../eST/jsp/StockStatusByItemSearchValidate.jsp?item_code=" + item_C + "&unit_cost=" + unit_cost + "&store_code=" + store_code + "&id_minl=" + retVal[7]+"&dflt_facility_id="+dflt_facility_id;
								var xmlStr = "<root><SEARCH /></root>";
								var xmlDoc="";
								var xmlHttp = new XMLHttpRequest();
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST", temp_jsp, false);
								xmlHttp.send(xmlDoc);
								responseText = xmlHttp.responseText;
								eval(responseText);
								document.formStockStatusQueryCriteria.item_code.value = item_C;
								document.formStockStatusQueryCriteria.item_desc.value = retVal[1];
								document.formStockStatusQueryCriteria.item_desc.readOnly=true;
								if (exp_yn == "Y") {
									document.getElementById('id_exp').innerHTML = "<image src='../../eCommon/images/enabled.gif'>";
								} else {
									document.getElementById('id_exp').innerHTML = "<image src='../../eCommon/images/disabled.gif'>";
								}
								document.getElementById('id_uom').innerHTML = retVal[15];
								document.getElementById('id_minl').innerHTML =setNumberForNumberFormat(retVal[7]);
								document.getElementById('id_maxl').innerHTML = setNumberForNumberFormat(retVal[8]);
								if (retVal[20] != null) {
									document.getElementById('id_pstore').innerHTML = retVal[21];
								}
								document.formStockStatusQueryCriteria.all.trhidden.style.visibility="hidden";
								//document.getElementById("trhidden").style.visibility="hidden";
								parent.frameStockStatusQueryResult.location.href = "../../eCommon/html/blank.html";
							
							
							}
				 }
			}
			else{
				alert(getMessage("ST_INVALID_BAR_CODE", "ST"));
				barcode.value = "";
				barcode.disabled = false;
				barcode.focus();
			}
		}
	}
}
//Added for TFS id:6938 end
