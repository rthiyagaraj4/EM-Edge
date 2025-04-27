/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
///////////////// Added by Martin \\\\\\\\\\\\\\\\\\\\\\\\\\\\\

var YES = "Yes";
var NO = "No";
var CLOSED = "";

var function_id = "" ;
//var result = false ;
//var message = "" ;
//var flag = "" ;
//var invalidCode = "";
///////////////// End Martin \\\\\\\\\\\\\\\\\\\\\\\\\\\\\

////////*******TO BE REMOVED WHEN ADDED IN COMMON***********//////////
var INT     = "Integer" ;
var LONG    = "Long"    ;
var FLOAT   = "Float"   ;
var DOUBLE  = "Double"  ;
var STRING  = "String"  ;
var DATE	= "Date"  ;
////////*******TO BE REMOVED WHEN ADDED IN COMMON***********//////////

//References eSS.Common.SsRepository.DEFAULT_LIST_OPTION_TEXT

var DEFAULT_LIST_OPTION_TEXT = "    --- Select ---    ";

//var defaultSelectHTML = "&nbsp;&nbsp;&nbsp;&nbsp;---- Select ---- &nbsp;&nbsp;&nbsp;&nbsp;";

function searchResult() {	
    	if (typeof(originalFormAction) != 'undefined' && originalFormAction != null)
    	{
    		parent.frames[0].document.forms[0].action = originalFormAction;
    		parent.frames[0].document.forms[0].target = originalFormTarget;
    	}
		
		parent.frames[0].document.forms[0].submit();	
}
function getBlankField( fields, legends, messageFrame, errorPage) {
	var obj=null;
	var errors = "" ;
	if (errorPage==null) {
		errorPage = "../../eCommon/jsp/error.jsp"
	}
	for( var i=0;i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
			fields[i].value = trimString(fields[i].value);
		else
		{
			if(obj==null)
				obj=fields[i];
			errors = errors + "APP-000001 " + legends[i] + " cannot be blank..." + "<br>" ;
		}
	}
	if ( errors.length != 0 ) {
		messageFrame.location.href=errorPage+"?err_num="+errors;
	}
		return obj ;
}
/* //Commented by Martin 
function searchCode(codeField,descField,tableName,title,target)
{
	var sql="select distinct "+codeField+","+descField+" from  "+tableName+"";
	var retVal = "";
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var search_code=codeField;
	var search_desc=descField;
	var tit=title;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eSS/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
	if (!(retVal == null))
		target.value=retVal;
	else
		target.focus();
}
*/
/* Comment/Uncomment to toggle RightClick arrest*/

setTimeout("setFunction();",100);
setTimeout("setFunction();",500);
setTimeout("setFunction();",1000);
setTimeout("setFunction();",2000);
setTimeout("setFunction();",4000);

function setFunction(){
	if(document!=null)
		if(document.body!=null){
			document.body.oncontextmenu=disableViewSource;
			//document.body.onkeydown=disableBackspace;
		}
}

function disableViewSource(){
	if(""+event.target.type!="undefined") 
		return true;
	else if(event.target.disabled)
		return false;
	else
		alert(getMessage("WELCOME","Common"));
	return false;
}
function disableBackspace(){
	if (event.keyCode == 113)
		lockKey();
	if(""+event.target.type=="undefined") return false;
}

/**/
function checkForNonZeroNumber(obj){
	if(isNaN(obj.value)){
		alert(getMessage("INVALID_NUMBER_FORMAT","Common"));
		//obj.select();
		//obj.focus();
		obj.value="";
		return false;
	}
	else if(parseFloat(obj.value)==0){
		alert(getMessage("CANNOT_BE_ZERO","Common"));
		//obj.select();
		//obj.focus();
		obj.value="";
		return false;
	}
	else 
		return true;
}

function toUpperCase(ev) {
	asciiCode=ev.keyCode;
	if((asciiCode>=97)&&(asciiCode<=122))
		ev.keyCode=asciiCode-32;
}

function convertToUpperCase(obj) {
	obj.value=obj.value.toUpperCase();
}



//////////////////////////////////ValidateControl version........................
function doDateCheckFrom(from,today) { //args objects 1st is this object & second is the date object
 if(from.value != "")
	 {
			alert();
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;

				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt)) {
							var msg = getMessage('FROM_DATE_GREATER_TO_DATE',"SS");
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							//from.focus();
							//from.select();
							from.value="";
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	return true;
}


function isValidInteger()
{
	var key = window.event.keyCode;
	if( !( key >= 48 && key <= 57 ) )
		return false;
	else
		return true;
}


function isValidNumber(fld, e, maxInt, deci)
{
    var count=fld.value.length;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');
            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt))
            {
                if(whichCode!=46)
                {
					if(deci>1)
					{ 
						fld.value = fld.value+".";
					}
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1)
                {
                    if(deci!=0)
						fld.value = objectValue.substring(0,maxInt)+".";
					else
						fld.value = objectValue.substring(0,maxInt);

                    return false;
                }
            }
        }
    }
	var strCheck = '.0123456789';
	if(deci==0)
	{
	   strCheck = '0123456789';
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

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;

    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
    return true;
}

function assignResult( _result, _message, _flag, _invalidCode ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
	if( _invalidCode==null)
		 _invalidCode="";
	invalidCode = _invalidCode;
}


// Method to enable Long Desc and Short Desc in Master functions,
// on checking the Effective Status 
// when the record is disabled/enabled.
	function checkEnableDisable()
	{
		var mode		=	document.forms[0].mode;
		var eff_status	=	document.forms[0].eff_status;
		var long_desc	=	document.forms[0].long_desc;	
		var short_desc	=	document.forms[0].short_desc;	

		if(mode.value==MODE_INSERT) return true;

		if(eff_status.checked)
		{
			long_desc.readOnly	=	false;
			short_desc.readOnly =	false;
		}
		else
		{
			if(mode.value==MODE_MODIFY)
			{
				document.forms[0].reset();
			}
			long_desc.readOnly	=	true;
			short_desc.readOnly =	true;
		}
	}

////////////////// END \\\\\\\\\\\\\\\\\\\\\\\

/**  Functions needed in manipulating list box dynamically. 
  *
  */

function clearListItems( listObject ) {
	var len = eval(listObject +".options.length") ; 
	for(i=0;i<len;i++) {
		eval(listObject +".remove(0)") ;
	}
	var listOption = createListOption("",DEFAULT_LIST_OPTION_TEXT);
	eval(listObject +".add(listOption)") ;
}

function addListItem(listObject,code,text,selectedValue) {
	if(selectedValue==null){
		selectedValue="";
	}
	var listOption = createListOption(code,text,selectedValue);
	eval(listObject+".add(listOption)");
}

function createListOption(code,text,selectedValue){
	var listOption	=	document.createElement('OPTION');
	listOption.text =	text;
	listOption.value=	code ;
	if(code==selectedValue){
		listOption.selected=true;
	}
	return listOption;
}

/**************************************************************/
function clickYes() {
	/*parent.window.returnValue=YES;
	parent.window.close();*/
	
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = YES;
    
    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
    dialogTag.close();  
    
	//return returnValue;
}
function clickNo() {
	/*parent.window.returnValue=NO;
	parent.window.close();*/
	
	let dialogBody = parent.parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = "NO";
	
	const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	dialogTag.close();   
	//return returnValue;
}

function displayMessage(messageFrame, HTMLMessage){

	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ HTMLMessage;

/* Commented on 9/16/2006 by RAMMOHAN.C  for V3 dynamic stylesheet and included the above line.
	messageFrame.document.open();
	messageFrame.document.writeln("<html><head><link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link></head><body class=\"MESSAGE\">"+HTMLMessage+"</body></html>");

	messageFrame.document.writeln("<html><head><link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/"+sStyle+"\"></link></head><body class=\"MESSAGE\">"+HTMLMessage+"</body></html>");

	messageFrame.document.close(); */
	

}
/*
function searchSsItemCode( target ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( "Item", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		target.value = returnedValues[0];
	} 
	target.focus();
}
*/
function resetColorCode(formObj, currObject){	
	var arrPKFieldNames	=	new Array();
	var startIndex = 0;
	arrPKFieldNames[0]	=	"code_";
	resetDuplicateClass( formObj, arrPKFieldNames, startIndex, currObject);
}

function getXMLString(arrayObject) {
	xmlStr ="<root><SEARCH ";
	if (arrayObject!=null)
		for (index=0;index<arrayObject.length;index++)	{
			xmlStr += arrayObject[index].name+"=\""+ arrayObject[index].value +"\" ";
		}
	xmlStr +=" /></root>";
	return xmlStr;
}

function getEnhancedXMLString(frmObj) {
    var arrObj = frmObj.elements;
    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
	var xmlStr ="<root><SEARCH ";

    for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount]
        var arrObj = frmObj.elements;

        for(var i=0;i<arrObj.length;i++) {
            var val = "" ;
            if(arrObj[i].type == "checkbox") {
                if(arrObj[i].checked)
                    val = "Y";
				else 
					val = "N";
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
            else if(arrObj[i].type == "radio") {
                if(arrObj[i].checked) {
                    val = arrObj[i].value;
                    if(arrObj[i].name != null && arrObj[i].name != "")
                        xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
                }
            }
            else if(arrObj[i].type == "select-multiple" ) {
                for(var j=0; j<arrObj[i].options.length; j++)
                {
                    if(arrObj[i].options[j].selected)
                        val+=arrObj[i].options[j].value +"~"
                }
                val= val.substring(0,val.lastIndexOf('~'))
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

            }
            else {
                val = arrObj[i].value;
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
        }
    }
	xmlStr +=" /></root>";
	return xmlStr;
}

function setTextAreaMaxLength(obj, len){
	return (obj.value.length<len)?true:false;
}
function checkSetTextAreaMaxLength(obj, len){
if(obj.value.length<=len)
	return true;
else 
	//alert(getMessage("EXCEED_MAX_LENGTH","SS"));
alert(getMessage("REMARKS_NOT_EXCEED_200_CH","SS"));//Added against inc#42391 as above message is not available in messages.java
	obj.focus();
	return false;
}

function checkSpecialChars(obj){
    if(obj.value=="") return;
	if(!CheckChars(obj)){
        alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
        obj.value="";
        obj.focus();
        return false;
    }
}

function checkIntegerFormat(obj){
    if(obj.value=="") return;
    if(!isValidIntegerFormat(obj)){
        alert(getMessage("INVALID_NUMBER_FORMAT","PH"));
        obj.value="";
        obj.focus();
        return false;
    }
	else if(parseFloat(obj.value)==0){
        alert(getMessage("CANNOT_BE_ZERO","Common"));
        obj.value="";
        obj.focus();
        return false;
	}
	return true;
}
function checkDoubleFormat(obj){
    if(!isValidDoubleFormat(obj)){
        alert(getMessage("INVALID_NUMBER_FORMAT","Common"));
        obj.value="";
        obj.focus();
        return false;
    }
	else if(parseFloat(obj.value)==0){
        alert(getMessage("CANNOT_BE_ZERO","Common"));
        obj.value="";
        obj.focus();
        return false;
	}
	return true;
}

function isValidIntegerFormat(Obj){
	var str = Obj.value;
	var validIntegerExists = true;
	for (u=0;u<str.length;u++){
		if (!((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))){
			validIntegerExists  = false;
			break;
		}
	}
	return validIntegerExists;
}

function isValidDoubleFormat(Obj){
	var str = Obj.value;
	var validDoubleExists = true;
	var totalDecimal	=	0;
	for (u=0;u<str.length;u++){
		if (str.charCodeAt(u)==46) {
			totalDecimal++;
			if(totalDecimal>1){
				validDoubleExists  = false;
				break;
			}
		}
		if (!(((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||(str.charCodeAt(u)==46))){
			validDoubleExists  = false;
			break;
		}
	}
	return validDoubleExists ;
}

function checkDateWithSysDate(entered_date,sys_date) 
{
	var enteredDateArray; var sysDateArray;
	var enteredDate = entered_date.value ;
	var sysDate = sys_date.value;

	if(enteredDate.length > 0 && sysDate.length > 0 ) 
	{
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
		if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) 
		{
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			return false;
		}
		else if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) return true;
	}	
	return true;
}

/*
function che
GR_OR_EQ
*/
function getQueryString(frmObj) {
    var arrObj = frmObj.elements;
    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
	var qryStr ="?";

    for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount]
        var arrObj = frmObj.elements;

        for(var i=0;i<arrObj.length;i++) {
            var val = "" ;
            if(arrObj[i].type == "checkbox") {
                if(arrObj[i].checked)
                    val = "Y";
				else 
					val = "N";
                if(arrObj[i].name != null && arrObj[i].name != "")
                    qryStr+= arrObj[i].name+"=" + checkSpl(val) + "&" ;
            }
            else if(arrObj[i].type == "radio") {
                if(arrObj[i].checked) {
                    val = arrObj[i].value;
                    if(arrObj[i].name != null && arrObj[i].name != "")
                        qryStr+= arrObj[i].name+"=" + checkSpl(val) + "&" ;
                }
            }
            else if(arrObj[i].type == "select-multiple" ) {
                for(var j=0; j<arrObj[i].options.length; j++)
                {
                    if(arrObj[i].options[j].selected)
                        val+=arrObj[i].options[j].value +"~"
                }
                val= val.substring(0,val.lastIndexOf('~'))
                if(arrObj[i].name != null && arrObj[i].name != "")
                    qryStr+= arrObj[i].name+"=" + checkSpl(val) + "&" ;

            }
            else {
                val = arrObj[i].value;
                if(arrObj[i].name != null && arrObj[i].name != "")
                    qryStr+= arrObj[i].name+"=" + checkSpl(val) + "&" ;
            }
        }
    }
	return qryStr;
}

//											|<----------------optional--------------->|
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
		var stMessage	=	getMessage("LESS_OR_EQUAL","SS");
		stMessage		=	stMessage.replace(/@/g, stLegend)
		messageFrame.location.href=errorPage+"?err_num="+stMessage;
		toObj.focus();
	}

	return bReturn;
}
function checkSSMandatoryFields(fields, names, messageFrame, errorPage) {
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

function checkSSMandatoryFields(fields, names, messageFrame, errorPage) {
	var errors = "", firstNullObject = null;
    //alert("Total No of Fields : "+fields.length);
	for (var i = 0; i < fields.length; i++) {
		if (trimString(fields[i].value) != "") {
			fields[i].value = trimString(fields[i].value);
		} else {
			if (errors.length == 0) {
				firstNullObject = fields[i];
			}
			//errors = errors + "APP-000001 " + names[i] + getLabel("Common.Cannotbeblank.label", "Common") + "<br>";
			errors = errors + "APP-000001 " + names[i] + " " + getLabel("Common.Cannotbeblank.label", "Common") + "<br>";//Added space between legend and field name
		}
	}
	if (errors.length != 0) {
		displayErrorMessage(errors, messageFrame, "", null, errorPage);
        //messageFrame.document.location.href   =   "../../eCommon/jsp/error.jsp?err_num=" + errors ;
	}
	return firstNullObject;
}
function validateSSMandatoryFields(formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage) {
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
		//var error_msg = getMMMessage("DUPLICATE_CODE_EXISTS") + " : ";
		var error_msg = getMessage("DUPLICATE_CODE_EXISTS","SS") + " : ";//Added by sakti problem came while doing KDAH-CRF-0247 
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
	var firstNullObject = checkSSMandatoryFields(fields, names, objMessageFrame, errorPage);
	if (firstNullObject != null) {
		firstNullObject.className = "DUPLICATE";
		firstNullObject.focus();
		return false;
	} else {
		return true;
	}
}


function checkSSFields(fields, names, messageFrame) {
	var errors = "";
	for (var i = 0; i < fields.length; i++) {
		if (trimSSCheck(fields[i].value)) {
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

function trimSSCheck(inString) {
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

//Added by Sakti against inc#48848
function checkDateWithSysDate(from_date,to_date, sys_date) {
	var enteredDateArray;
	var enteredtoDateArray;
	var sysDateArray;
	//var enteredDate = entered_date.value;
	//var sysDate = sys_date.value;
	if (from_date.length > 0 && to_date.length > 0 && sys_date.length > 0) {
		enteredfmDateArray = from_date.split("/");
		enteredtoDateArray = to_date.split("/");
		sysDateArray = sys_date.split("/");
		var enteredfmDateObject = new Date(enteredfmDateArray[2], (enteredfmDateArray[1] - 1), enteredfmDateArray[0]);
		var enteredtoDateObject = new Date(enteredtoDateArray[2], (enteredtoDateArray[1] - 1), enteredtoDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) < Date.parse(enteredfmDateObject) && Date.parse(sysDateObject) < Date.parse(enteredtoDateObject)) {
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			return false;
		} else {
			if (Date.parse(sysDateObject) >= Date.parse(enteredfmDateObject) && Date.parse(sysDateObject) >= Date.parse(enteredtoDateObject)) {
				return true;
			}
		}
	}
	return true;
}
//Added ends
