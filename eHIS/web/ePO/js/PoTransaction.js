  
/**
  * The Following function makeValidAmount is used for 
  * displaying the valid Amount.
  * This function should be called on onBlur of any Amount column.
  * The Syntax is : 
  *     allowValidNumber( <fld>, <e>, <maxInt>, <deci>)
  * ************************************************************************
  * @param <fld> referred as Actual Object where-in this function 
  *        should be carried out.
  * @param <e> is the Event which is fired when the Key is pressed.
  * @param <maxInt> referred as Maximum Integer Positions allowed for
  *        this number field.
  * @param <deci> referred as No. of Decimal Places for rounding 
  *        of the actual amount field object which is passed as parameter.
  * The Return value of this function is the Actual Object passed as a parameter
  * to this function.
  */
function setNumber(number, decimalPlaces) {
	if (isNaN(number)) {
		return 0;
	}
	var power = Math.pow(10, decimalPlaces);
	number = number * power;
	number = Math.round(number);
	number = number / Math.pow(10, decimalPlaces);
	return number;
}
function getDefaultBatchID(expiry_date) {
	var array = expiry_date.split("/");
	return "" + array[0] + array[1] + array[2];
}
/*
function valid_number(fld)
{
	
	if(isNaN(fld.value))
	{
		alert("APP-SM0046 - Only number is allowed");
		fld.select();
		fld.focus();
		
		return false;
	}
	else
		return true;
	
}
 
function allowValidNumber(fld, e, maxInt, deci)
{
	var count=fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if(count>=maxInt)
	{
		if(count==maxInt)
		{
		    var dotOccurance = fld.value.indexOf('.');
			//alert("dotOccurance : "+dotOccurance);
			if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt))
			{
				if(whichCode!=46)
				{
					alert("APP-0001 Reached Maximum Integer value");
					return false;
				}
			}
		}
		else if(count>maxInt)
		{
			var objectValue = fld.value;
		    var dotOccurance = objectValue.indexOf('.');
			//alert(objectValue.charAt(maxInt));
			if((objectValue.charAt(maxInt))!='.')
			{
				if(dotOccurance==-1)
				{
					fld.value = objectValue.substring(0,maxInt)+".";
					return false;
				}
			}
		}
	}
	if (parseInt(deci)==1)//For Minus,Decimal Point and 0-9
	  var strCheck = '.0123456789-';
	else if (parseInt(deci)==2) //For Decimal Point and 0-9
	{
	   var strCheck = '.0123456789';
	}
	else if (parseInt(deci)==0)//For Only Nos 0 - 9
	{
		var strCheck = '0123456789';
	}
	else if (parseInt(deci)==3)//For Minus and 0-9 Only
	{
		var strCheck = '0123456789-';
	}
	if (parseInt(deci)==1)
	{
		var fldvalue=fld.value;
		if (whichCode == 45 && (fldvalue.length==0)) return true;  // minus 
		if (whichCode == 45 && (fldvalue.length>0)) return false;  // minus 
	}

	var fldvalue=fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	var pointCount=0;
	for(var i=0;i<fldvalue.length;i++)
	{
		if(fldvalue.charAt(i)=='.') pointCount++;
	}
	if (pointCount>0 && whichCode == 46) return false;

	var fldValue	=	fld.value;
	var dotIndex	=	fldValue.indexOf(".");
	var fldLength	=	fldValue.length;

	if(dotIndex!=-1)
		if( fldLength > (dotIndex+3) ) return false;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true;
}

/**
  * The function checkValidQty is used to check whether the entered qty is a valid one.
  * This function allows maximum of three decimal places if one exists as a precision
  * after the decimal place. If one does not have any decimal place it will let it out as it is.
  * The Syntax of this function is 
  *       checkValidQty(<Qty_Object>) 
  * Returns the same object with corrected Qty Output
  */
function checkValidQty(Obj) {
	//alert("inside checkValidQty!");
	objValue = Obj.value;
	var deciIndex = objValue.indexOf(".");
	//alert("deciIndex : "+deciIndex);
	if (deciIndex != -1) {
		var lengthAfterFP = (objValue.substring(deciIndex + 1, objValue.length)).length;
		if (lengthAfterFP == 0) {
			Obj.value = objValue.substring(0, (objValue.length - 1));
		}
		if (lengthAfterFP > 3) {
			Obj.value = objValue.substring(0, deciIndex + 4);
		}
	}
	return true;
}
/**
  * The Following function makeValidQty is used for 
  * displaying the valid Qty.
  * This function should be called on onBlur of any qty column.
  * The Syntax is : 
  *     makeValidQty(<Actual Object>,<maxIntValue>,<No.of decimalplaces>)
  * ************************************************************************
  * The Return value of this function is the Actual Object passed as a parameter
  * to this function.
  */
function makeValidQty(Obj, maxvalue, deci) {
	var objVal = Obj.value;
	var objLength = Obj.value.length;
	if (!(valid_number(Obj))) {
		return false;
	}
	var dotOccurance = objVal.indexOf(".");
	if (dotOccurance != -1) {
		var maxDeci = parseInt(dotOccurance) + parseInt(deci) + 1;
		var original_value = parseFloat(objVal);
		//alert("original_value : "+original_value);
		var result1 = original_value * Math.pow(10, deci);
			//alert("result1 : "+result1);
		var result2 = Math.round(result1);
			//alert("result2 : "+result2);
		var result3 = result2 / Math.pow(10, deci);
		objVal = "" + result3;
		Obj.value = objVal.substring(0, maxDeci);
	}
	if ((objVal.charAt(objVal.length - 1)) == ".") {
		Obj.value = objVal.substring(0, objVal.length - 1);
	}
	objVal = Obj.value;
	if (objVal.charAt(0) == ".") {
		Obj.value = "0" + objVal;
	}
	return true;
}
/**
  * The Following function makeValidAmount is used for 
  * displaying the valid Amount.
  * This function should be called on onBlur of any Amount column.
  * The Syntax is : 
  *     makeValidAmount(<Actual Object>,<maxIntValue>,<No.of decimalplaces>)
  * ************************************************************************
  * @param <Actual Object> referred as Actual Object where-in this function 
  *        should be carried out.
  * @param <maxIntValue> referred as Maximum Integer Positions allowed for
  *        this amount field.
  * @param <No.of decimalplaces> referred as No. of Decimal Places for rounding 
  *        of the actual amount field object which is passed as parameter.
  * The Return value of this function is the Actual Object passed as a parameter
  * to this function.
  */
function makeValidAmount(Obj, maxvalue, deci) {
	var objVal = Obj.value;
	var objLength = Obj.value.length;
	if (!(valid_number(Obj))) {
		return false;
	}
	var dotOccurance = objVal.indexOf(".");
	if (dotOccurance != -1) {
		var maxDeci = parseInt(dotOccurance) + parseInt(deci) + 1;
		Obj.value = objVal.substring(0, maxDeci);
		var lengthAfterDot = parseInt(objLength) - (parseInt(dotOccurance) + 1);
		if (lengthAfterDot < parseInt(deci)) {
			var zeroCount = parseInt(deci) - parseInt(lengthAfterDot);
			var actValue = objVal;
			for (var j = 0; j < zeroCount; j++) {
				actValue += "0";
			}
			Obj.value = actValue;
		}
	}
	if ((objVal.charAt(objVal.length - 1)) == ".") {
		Obj.value = objVal.substring(0, objVal.length - 1);
	}
	//alert("dotOccurance : "+dotOccurance);
	objVal = Obj.value;
	dotOccurance = objVal.indexOf(".");
	if (objVal.length == 0) {
		objVal = "0";
	}
	if (parseInt(dotOccurance) == -1) {
		var actAmount = objVal + ".";
		for (var i = 0; i < parseInt(deci); i++) {
			actAmount += "0";
		}
		Obj.value = actAmount;
	}
	if (objVal.charAt(0) == ".") {
		Obj.value = "0" + objVal;
	}
	return true;
}
/**
  * The function cancelRecord(obj,n) is used to display the selected table row in a different color
  * if it is selected for delete operation/ if the adjacent check box is checked.
  * The Syntax of this method is
  *   <row_obj> cancelRecord (obj,n)
  * @param <obj> is the row object of a table.
  * @param <n> refers the no.of columns (ie., no. of <TD>) painted in that row.
  * <row_obj> refers the return value of this function
  */
function cancelRecord(obj, n) {
	var i = 0;
	for (i = 0; i < n; i++) {
		obj.cells(i).className = "SUSPENDED";
	}//#FFDCBC";style.backgroundColor="#B2B6D7";
	return true;
}
/**
  * The function activateRecord(obj,n,colorVal) is used to display the selected 
  * table row in a different color,
  * if it is de-selected for delete operation/ if the adjacent check box is un-checked.
  * The Syntax of this method is
  *   <row_obj> activateRecord(obj,n,colorVal)
  * @param <obj> is the row object of a table.
  * @param <n> refers the no.of columns (ie., no. of <TD>) painted in that row.
  * @param <colorVal> refers the color which is to be painted for that row.
  * <row_obj> refers the return value of this function
  */
function activateRecord(obj, n) {
	var prev = 0;
	var i = 0;
	var colorVal = "";
	var row_index = obj.rowIndex;
	if ((row_index % 2) == 0) {
		colorVal = "QRY_EVEN";
	} else {
		colorVal = "QRY_ODD";
	}
	for (i = 0; i < n; i++) {
		obj.cells(i).className = colorVal;
	}
	return true;
}
/**
  * The following function indicateModify(chkObj,tblrow_id,noOfCols) is used to display the selected
  * table row for modification in a different color. This function in turn calls the changeRowColor 
  * method of source "/eCIS/common/js/rowcolor.js".
  */
function indicateModify(chkObj, tblrow_id, noOfCols, checkBoxName) {
	//chkObj.disabled=true;
	changeRowColor(tblrow_id, noOfCols, 1, checkBoxName);
}
/***
   * Function
   */
function checkIsValidDocDate(doc_date, sys_date, curr_proc_month, curr_proc_year, messageFrame) {
	/**
	  * The function CheckDate(obj) is available in ValidationControl.js file
	  * The function checkDateWithSysDate(entered_date,sys_date) is Written in this file itself.
	  */
	if (!(CheckDate(doc_date))) {
		return false;
	}
	if (!(checkDateWithSysDate(doc_date, sys_date))) {
		msg = getMessage("DATE_NOT_GREATER_SYSDATE", "PO");
		messageFrame.location.href = "/eCIS/common/jsp/error.jsp?err_num=" + msg;
		doc_date.select();
		doc_date.focus();
		return false;
	}
	//else
	//	messageFrame.location.href="/eCIS/common/jsp/error.jsp?err_num=";
	var docdate = (doc_date.value).split("/");
	var currMonth = parseFloat(curr_proc_month.value);
	var currYear = parseFloat(curr_proc_year.value);
	var entrdDay = "" + docdate[0];
	var entrdMonth = "" + docdate[1];
	var entrdYear = "" + docdate[2];
	if (parseFloat(entrdDay) < 10) {
		entrdDay = "0" + parseFloat(entrdDay);
	}
	if (parseFloat(entrdMonth) < 10) {
		entrdMonth = "0" + parseFloat(entrdMonth);
	}
	doc_date.value = entrdDay + "/" + entrdMonth + "/" + entrdYear;
	if ((currMonth != parseFloat(entrdMonth)) || (currYear != parseFloat(entrdYear))) {
		if ((currMonth != entrdMonth)) {
			msg = getMessage("NOT_PROCESSING_MONTH");
		}
		if ((currYear != entrdYear)) {
			msg = getMessage("NOT_PROCESSING_YEAR");
		}
		doc_date.focus();
		doc_date.select();
		messageFrame.location.href = "/eCIS/common/jsp/error.jsp?err_num=" + msg;
		return false;
	} else {
		messageFrame.location.href = "/eCIS/common/jsp/error.jsp?err_num=";
	}
	return true;
}
/**
  * This function is used to check the "entered_date" Date with the "sys_date".
  * Note that here "entered_date" date is an HTML Object(i.e., a HTML Hidden Field) and
  * sysDate is also an Object(i.e., a HTML Hidden Field) of the Current System date.
  * The Syntax is  
  *	checkDateWithSysDate(<entered_date>,<sys_date>) 
  */
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
function changeRowColor(obj, n, hdrCnt, checkBoxName) {
	var rowCnt = document.getElementById("tb1").rows.length;
	rowCnt = parseInt(rowCnt) - parseInt(hdrCnt);
	/**
	  * Here we are checking the Object Id passed here, starts with a string 'tblrow_id' or not
	  * This is required because, it is used to identify which type of table styles we are using.
	  * The Type of Table Styles are considered (Totally 3 Styles) 
	  *     as follows as for as this function is concerned.
	  *		<<<<<  CASE - 1 >>>>>
	  *		# Table with Only One Header   
	  *
	  *		<<<<<  CASE - 2 >>>>>
	  *		# Table with Only Two Header Continueously one after another.
	  *			(Like, Revise Price Category Markup Display Screen)
	  *
	  *		<<<<<  CASE - 3 >>>>>
	  *		# Table with One Header at the TOP (for Column Heading) 
	  *        and One at the BOTTOM (for SUMMARY) of Table. 
	  *			# The TOP Header contains the Column Headings
	  *			# The BOTTOM Header(FOOTER) contains the Total Summary of the items/ details
	  *			  furnished in the Table.
	  *
	  *		Note that in the case of 
	  *			<<<<<  CASE - 1 >>>>>  AND  <<<<<  CASE - 2 >>>>> 
	  *				Here the Table Row ID is Must and 
	  *				It Should Start with the String "tblrow_id" 
	  *
	  *			<<<<<  CASE - 3 >>>>>  
	  *				Here the Table Row ID is Must and 
	  *				It Should not start with the String "tblrow_id", But it can be any other String.
	  */
	if (((obj.id).indexOf("tblrow_id")) != -1) {
		rowCnt = document.getElementById("tb1").rows.length - 1;
	} else {
		hdrCnt = 1;
	}

	//alert('rowCnt'+rowCnt);
	var prev = 0;
	var i = 0;
	var className = "";
	for (i = hdrCnt; i <= rowCnt; i++) {
		if (i % 2 == 0) {
			classValue = "QRY_EVEN";
		} else {
			classValue = "QRY_ODD";
		}
		if (checkBoxName != "") {
			var isChecked = false;
			isChecked = eval("document.forms[0]." + checkBoxName + (i - 1) + ".checked");
			if (isChecked) {
				classValue = "SUSPENDED";
			} else {
				if (i % 2 == 0) {
					classValue = "QRY_EVEN";
				} else {
					if (i % 2 == 1) {
						classValue = "QRY_ODD";
					}
				}
			}
		}
		if (((obj.id).indexOf("tblrow_id")) != -1) {
			if (hdrCnt == 2) {
				if (isChecked) {
					classValue = "SUSPENDED";
				} else {
					if ((i + 1) % 2 == 0) {
						classValue = "QRY_EVEN";
					} else {
						if ((i + 1) % 2 == 1) {
							classValue = "QRY_ODD";
						}
					}
				}
			}
		}
		for (j = 0; j < n; j++) {
			if (document.getElementById("tb1").rows(i).id != "one") {
				document.getElementById("tb1").rows(i).cells(j).className = classValue;
			}
		}
	}
	for (i = 0; i < n; i++) {
		obj.cells(i).className = "ITEM_SELECT";
	}
}

function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ((url.indexOf("blank.html") == -1) && (url.indexOf("query") == -1)) {
		return true;
	} else {
		return false;
	}
}
/**
  *	Function Syntax
  *				changeOnSelectFacility(<checkBoxObject>)
  *		-	This Function takes the value of the check box clicked and it will create a temporary form
  *			and submit to one JSP called "STStkLBGetRefSrcCode.jsp" in order to 
  *			get the respective Enterprise/ External Referral Names and Codes 
  *			into the adjacent "SELECT" item.
  */
function changeOnSelectFacility(selectObj) {
	//if(checkedObj.value=='') return true;
	var ref_source_type = selectObj.value;
	parent.frames[0].document.forms[0].href_source_type.value = ref_source_type;
	var optlength = parent.frames[0].document.forms[0].ref_source_code.options.length;
	for (var i = 0; i < optlength; i++) {
		parent.frames[0].document.forms[0].ref_source_code.options.remove("ref_source_code");
	}
	if ((ref_source_type == "") || (ref_source_type == "select")) {
		var referral_code = "select";
		var referral_desc = "        ---- Select ----        ";
		var opt = parent.frames[0].document.createElement("OPTION");
		opt.text = referral_desc;
		opt.value = referral_code;
		parent.frames[0].document.forms[0].ref_source_code.add(opt);
		parent.frames[0].document.forms[0].ref_source_code.selectedIndex = 0;
		return false;
	}
	var HTMLVal = "<html><body><form name='STStkGetRefSrcCodeForm' id='STStkGetRefSrcCodeForm' method='post' action='/eCIS/st/jsp/STStkLBGetRefSrcCode.jsp'>" + "<input type='hidden' name='ref_source_type' id='ref_source_type' value='" + ref_source_type + "'>" + "</form></body></html>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML("AfterBegin", HTMLVal);
	parent.parent.messageFrame.document.STStkGetRefSrcCodeForm.submit();
	return true;
}

async function getItemBatchSearch(item_code, item_desc, store_code, store_desc, expired_items) {
	var retArr = new Array();
	var dialogHeight = "17";
	var dialogWidth = "25";
	var status = "no";
	var arguments = "";
	var sql = "";
	var tit = "";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status;
	var item_short_desc = escape(item_desc);
	var store_short_desc = escape(store_desc);
	var url = "/eCIS/st/jsp/BatchSearch.jsp?item_code=" + item_code + "&item_desc=" + item_short_desc + "&store_code=" + store_code + "&store_desc=" + store_short_desc + "&expired_items=" + expired_items;
	retArr = await window.showModalDialog(url, arguments, features);
	return retArr;
}
function checkIsNull(obj) {
	if (trimCheck(obj.value) == "") {
		return true;
	} else {
		return false;
	}
}
async function confirmFinalize() {
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "19";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmTransaction.jsp";
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}
async function confirmCancel() {
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "19";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmCancel.jsp";
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}
async function confirmClose() {
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "19";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmClose.jsp";
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}
async function confirmDelete() {
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "19";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmDelete.jsp";
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}
async function confirmPrinting() {
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "19";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmOnlinePrint.jsp";
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}
async function confirmPrintView() {
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "19";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmPrintView.jsp";
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}

async function confirmWindow(title,header) {
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "30";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmWindow.jsp?title="+title + "&header="+header;
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}



