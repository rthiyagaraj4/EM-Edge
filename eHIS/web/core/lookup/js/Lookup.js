/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var CODE_LINK = "1";
var DESC_LINK = "2";
var CODE_DESC_LINK = "1,2";
/*
    1 - Code Link, 2 - Desc Link
*/
var CODE_DESC = "CODE_DESC";
var DESC_CODE = "DESC_CODE";

//Links
var DESC_LINK = "DESC_LINK";
var CODE_LINK = "CODE_LINK";
var CODE_DESC_LINK = "CODE_DESC_LINK";
var recordCount = 0;
var retArr = new Array();
function Lookup(title, pArgumentArray) {
	
	retArr = new Array();
	var pArgumentArrayMap = "";
	var firstTime = true;
	for (i = 0; i < pArgumentArray[1].length; i++) {
		
		if (!firstTime) {
			pArgumentArrayMap += ",";
		}
		pArgumentArrayMap += "" + pArgumentArray[1][i] + "=" + pArgumentArray[2][i] + "";
		firstTime = false;
	}
	if (pArgumentArray[5] == "") {
		pArgumentArray[5] = "**";
	}
	pArgumentArray[6] = title

	pArgumentArrayMap += ",searchText=" + pArgumentArray[5] + "";
	DWREngine.setAsync(false);
	DynaLookup.doLookup(pArgumentArray[0], pArgumentArrayMap, "true", lookupCallBk);
	
	DWREngine.setAsync(true);
	var returnVal;
	if (retArr.length == 1) {
		returnVal = retArr[0];
	} else {
		var retVal = new String();
		var dialogHeight = "28";
		var dialogWidth = "43";
		var status = "no";
		var dialogUrl = contextPath + "/core/lookup/jsp/LookupMain.jsp";
		
		var dialogArguments = pArgumentArray;
		
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status;
		returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
	}
	return returnVal;
}
function lookupCallBk(dto) {
	for (key in dto) {
		var localArray = new Array();
		localArray[0] = key;
		localArray[1] = dto[key];
		retArr[retArr.length] = localArray;
		recordCount++;
	}
}
