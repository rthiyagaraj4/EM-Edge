var YES = "Yes";
var NO = "No";
var MODE_DELETE		=	'0';
var MODE_INSERT		=	'1';
var MODE_MODIFY		=	'2';
var MESSAGE_FRAME	=	'Alert';
var function_id		=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ; 

var INT = "Integer";
var LONG = "Long";
var FLOAT = "Float";
var DOUBLE = "Double";
var STRING = "String";
var DATE = "Date";


/**
  * Added by Arul on 4th Dec 2002, to change the lower-case to upper-case letters.
  * especially meant for Master Code Fields.
  */
function changeCase()
{
	if( (window.event.keyCode >= 97) && (window.event.keyCode <= 122) )	
		return (window.event.keyCode -= 32);
	else if ( !( ((window.event.keyCode >= 65) && (window.event.keyCode <= 90)) || ((window.event.keyCode >= 48) && (window.event.keyCode <= 57)) ) )	
		return false;
}

/**
  * This function is used to allow only the valid time format on key press.
  */
function allowValidTime()
{
	var key = window.event.keyCode;
	if ( !( ( key >= 48 ) && ( key <= 58 ) ) )
		return false;
}

/**
  * This function is used to "lock the windows property key" 
  * on browser when trying to view the source.
  */
/*function lockKey() 
{
	if(event.keyCode == 93)
		alert(getMessage("WELCOME","Common"));
}*/

/**
  * Method to enable Long Desc and Short Desc in Master functions,
  * on checking the Effective Status 
  * when the record is disabled/enabled.
  */

function checkEnableDisable()
{
	var mode		=	document.forms[0].mode;
	var eff_status	=	document.forms[0].eff_status;
	var long_desc	=	document.forms[0].long_desc;	
	var short_desc	=	document.forms[0].short_desc;	

	if(mode.value==MODE_INSERT) return;

	if(eff_status.checked==true)
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
		eff_status.checked	=	false;
	}
}

function findAndReplace(inputString, findString, replaceString)
{
	while(inputString.indexOf(findString)!=-1)
	{
		inputString = inputString.replace(findString,replaceString);
	}
	return inputString;
}

function checkSpecialChars(obj){
    if(obj.value=="") return;
	if(!CheckChars(obj)){
        alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PO"));
        obj.focus();
        return false;
    }
}

function convertToUpperCase(obj) {
	obj.value=obj.value.toUpperCase();
}


function resetColorCode(formObj, currObject){	
	var arrPKFieldNames	=	new Array();
	var startIndex = 0;
	arrPKFieldNames[0]	=	"code_";
	resetDuplicateClass( formObj, arrPKFieldNames, startIndex, currObject);
}
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
			document.body.onkeydown=disableBackspace;
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

function displayMessage(messageFrame, HTMLMessage){
	messageFrame.document.open();
	messageFrame.document.writeln("<html><head><link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link></head><body class=\"MESSAGE\">"+HTMLMessage+"</body></html>");
	messageFrame.document.close();
}

function getPOBlankField( fields, legends, messageFrame, errorPage) {
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


function validateMMSTMandatoryFields (formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage )
{
    /**
      * Initialize default values
      */
	  
    if(startIndex==null)        startIndex      =   0;

    if(objMessageFrame==null)   objMessageFrame =   messageFrame;
	else messageFrame = objMessageFrame
//    else                        objMessageFrame =   null;
    if(errorPage==null)         errorPage       =   "../../eCommon/jsp/error.jsp";

    var fields              =   new Array();
    var names               =   new Array();
    var masterCodes         =   new Array();
    var arrPKFields         =   null;

    var notNullIndex        =   0;
    var currRowIndex        =   0;
    var masterIndex         =   0;
    var pkIndex             =   0;
    var uniqueFields        =   "";

    var totalRecords        =   formObj.totalRecords.value;
    var totalColumns        =   arrFieldName.length;
    var totalPKColumns      =   arrPKFieldNames.length;
    totalRecords            =   parseFloat(totalRecords) + parseFloat(startIndex);
    //alert("totalRecords : "+totalRecords);
    //alert("totalColumns : "+totalColumns);
    //alert("totalPKColumns : "+totalPKColumns);

    /**
      * Identify the rows and respective columns in the form, which has some values entered.
      */
    for( var rowIndex=startIndex; rowIndex<totalRecords; rowIndex++ )
    {
        var isNotNull       =   false;
        for( var colIndex=0; colIndex<totalColumns; colIndex++ )
        {
            current_field   =   eval("formObj."+arrFieldName[colIndex]+rowIndex);
			//alert("current_field--"+current_field);
            if( trimString(current_field.value)!="")
            {
                isNotNull       =   true;
                break;
            }
        }
//        alert("isNotNull : "+isNotNull);
        if(isNotNull)
        {
            currRowIndex                =   rowIndex + 1;
            arrPKFields                 =   new Array();
            pkIndex                     =   0;

            for( var colIndex=0; colIndex<totalColumns; colIndex++ )
            {
                current_field           =   eval("formObj."+arrFieldName[colIndex]+rowIndex);
                if( (uniqueFields.indexOf(arrFieldName[colIndex])==-1) && (trimString(current_field.value)=="") )
                {
                    fields [ notNullIndex ]     =   current_field;
                    names  [ notNullIndex++ ]   =   arrLegends[colIndex]; // + " #" + currRowIndex; //" %23" + currRowIndex;
                    uniqueFields                +=  current_field.name + " " ;
                }

                if( colIndex < totalPKColumns )
                {
                    pk_field            =   eval("formObj."+arrPKFieldNames[colIndex]+rowIndex);
                    if( current_field.name == pk_field.name )
                    {
                        arrPKFields[pkIndex++]  =   pk_field;
                    }
                }
            }
            masterCodes [ masterIndex++ ]   =   arrPKFields;
        }
    }

    /**
      * If there are no values entered, the length will be zero, so alert and return.
      */


    if(masterCodes.length==0)
    { var error_msg=getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
        showErrorMessage(error_msg,objMessageFrame,'','',errorPage);
//		showErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame )
        formObj.document.parentWindow.FocusFirstElement();
        return false;
    }
    /**
      * Check for the duplicating primary key columns by calling the returnDuplicates function.
      */

    var arrDuplicate        =   returnDuplicates(masterCodes);


    /**
      * The first index of the array will contain duplicating primary keys seperated by a delimiter ", ".
      */
    var duplicateCodes      =   arrDuplicate[0];

    /**
      * The second index of the array will contain duplicating primary key fields as an Array.
      */
    var duplicateField      =   arrDuplicate[1];

    /**
      * The third index of the array will contain duplicating primary key fields description
      * seperated by the delimeter ", " in the case of a input type is a select item.
      */
    var duplicateCodesValue =   arrDuplicate[2];

    if(duplicateCodesValue==null)   duplicateCodesValue = "";

    //alert("duplicateCodesValue : "+duplicateCodesValue);
    var inputType           =   "text";
    var duplicateValue      =   "";

    /**
      * Check for the duplicate primary key fields and if any, display the error message and
      * mark the first duplicating primary key fields using the css class "DUPLICATE".
      */
    if(duplicateCodes!="")
    {
        var duplicateCode       =   "";
        var firstIndex          =   duplicateCodes.indexOf(",");

        if(firstIndex==-1)
        {
            firstIndex          =   duplicateCodes.length;
        }

        var firstDuplicate      =   duplicateCodes.substring(0,firstIndex);
        var startingIndex       =   0;

        for(var i=0; i<duplicateField.length; i++)
        {
            duplicatePKFields   =   duplicateField[i];

            for(var pkIndex=0; pkIndex<duplicatePKFields.length; pkIndex++)
            {
                if( (pkIndex%totalPKColumns) < totalPKColumns )
                {
                    duplicateCode += duplicatePKFields[pkIndex].value + ":";
                }

                if( (pkIndex%totalPKColumns) == (totalPKColumns-1) )
                {
                    duplicateCode   =   duplicateCode.substring(0,duplicateCode.length-1);

                    if(firstDuplicate==duplicateCode)
                    {
                        for(var j=startingIndex; j<=pkIndex; j++)
                        {
                            if( (pkIndex-startingIndex)<=totalPKColumns )
                            {
                                duplicatePKFields[j].className = "DUPLICATE";
                            }
                        }
                        startingIndex   =   pkIndex;
                    }
                    duplicateCode   =   "";
                }
            }
        }

        duplicatePKFields   =   duplicateField[0];

        if( duplicatePKFields[0].type=="select-one" )
        {
            inputType       =   "select-one";
        }

        //var error_msg       =   getPOMessage("DUPLICATE_CODE_EXISTS") + " : " ;
		var error_msg       =   getMessage("DUPLICATE_CODE_EXISTS","Common") + " : " ;

        if( inputType == "text" )
        {
            error_msg       +=  duplicateCodes;
        }
        else if( inputType == "select-one" )
        {
            error_msg       +=  duplicateCodesValue;
        }

        displayErrorMessage(error_msg,objMessageFrame,'',null,errorPage);

        if( inputType != "select-one" )
        {
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
	var firstNullObject     =   checkMMSTMandatoryFields( fields, names, objMessageFrame,errorPage);

    if(firstNullObject!=null)
    {
        firstNullObject.className = "DUPLICATE";
        firstNullObject.focus();
        return false;
    }
    else
    {
        return true;
    }
}

function checkMMSTMandatoryFields( fields, names, messageFrame, errorPage)
{
    var errors = "" ,   firstNullObject =   null;
    //alert("Total No of Fields : "+fields.length);
    for( var i=0; i<fields.length; i++ )
    {
        if(trimString(fields[i].value)!="")
        {
            fields[i].value = trimString(fields[i].value);
        }
        else
        {
            if ( errors.length == 0 )
            {
                firstNullObject =   fields[i];
            }
            errors = errors + "APP-000001 " + names[i] + getLabel("Common.Cannotbeblank.label","Common") + "<br>" ;
        }
    }
    if ( errors.length != 0 )
    {
        displayErrorMessage(errors,messageFrame,'',null,errorPage);
        //messageFrame.document.location.href   =   "../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors ;
    }
    return firstNullObject;
}

function checkMMSTFields( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else    errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}

function checkMMSTFieldsofMst( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else    errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}

function checkMMSTField( field, name ) {
    if( trimCheck(field.value) )
    {
        field.value = trimString(field.value);
        return true;
    }
    else
    {
        alert("APP-000001 " + name + " cannot be blank...") ;
        field.focus();
        return false ;
    }
}




function validatePOMandatoryFields( formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage )
{
    /**
      * Initialize default values
      */
    if(startIndex==null)        startIndex      =   0;

    if(objMessageFrame==null)   objMessageFrame =   messageFrame;
	else messageFrame = objMessageFrame
//    else                        objMessageFrame =   null;
    if(errorPage==null)         errorPage       =   "../../eCommon/jsp/error.jsp";

    var fields              =   new Array();
    var names               =   new Array();
    var masterCodes         =   new Array();
    var arrPKFields         =   null;

    var notNullIndex        =   0;
    var currRowIndex        =   0;
    var masterIndex         =   0;
    var pkIndex             =   0;
    var uniqueFields        =   "";

    var totalRecords        =   formObj.totalRecords.value;
    var totalColumns        =   arrFieldName.length;
    var totalPKColumns      =   arrPKFieldNames.length;
    totalRecords            =   parseFloat(totalRecords) + parseFloat(startIndex);
    //alert("totalRecords : "+totalRecords);
    //alert("totalColumns : "+totalColumns);
    //alert("totalPKColumns : "+totalPKColumns);

    /**
      * Identify the rows and respective columns in the form, which has some values entered.
      */
    for( var rowIndex=startIndex; rowIndex<totalRecords; rowIndex++ )
    {
        var isNotNull       =   false;
        for( var colIndex=0; colIndex<totalColumns; colIndex++ )
        {
            current_field   =   eval("formObj."+arrFieldName[colIndex]+rowIndex);
			//alert("current_field--"+current_field);
            if( trimString(current_field.value)!="")
            {
                isNotNull       =   true;
                break;
            }
        }
//        alert("isNotNull : "+isNotNull);
        if(isNotNull)
        {
            currRowIndex                =   rowIndex + 1;
            arrPKFields                 =   new Array();
            pkIndex                     =   0;

            for( var colIndex=0; colIndex<totalColumns; colIndex++ )
            {
                current_field           =   eval("formObj."+arrFieldName[colIndex]+rowIndex);
                if( (uniqueFields.indexOf(arrFieldName[colIndex])==-1) && (trimString(current_field.value)=="") )
                {
                    fields [ notNullIndex ]     =   current_field;
                    names  [ notNullIndex++ ]   =   arrLegends[colIndex]; // + " #" + currRowIndex; //" %23" + currRowIndex;
                    uniqueFields                +=  current_field.name + " " ;
                }

                if( colIndex < totalPKColumns )
                {
                    pk_field            =   eval("formObj."+arrPKFieldNames[colIndex]+rowIndex);
                    if( current_field.name == pk_field.name )
                    {
                        arrPKFields[pkIndex++]  =   pk_field;
                    }
                }
            }
            masterCodes [ masterIndex++ ]   =   arrPKFields;
        }
    }

    /**
      * If there are no values entered, the length will be zero, so alert and return.
      */


    if(masterCodes.length==0)
    {
    var error_msg1=getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
        showPOErrorMessage(error_msg1,objMessageFrame,'','',errorPage,"Common");
		formObj.document.parentWindow.FocusFirstElement();
        return false;
    }
    /**
      * Check for the duplicating primary key columns by calling the returnDuplicates function.
      */

    var arrDuplicate        =   returnDuplicates(masterCodes);


    /**
      * The first index of the array will contain duplicating primary keys seperated by a delimiter ", ".
      */
    var duplicateCodes      =   arrDuplicate[0];

    /**
      * The second index of the array will contain duplicating primary key fields as an Array.
      */
    var duplicateField      =   arrDuplicate[1];

    /**
      * The third index of the array will contain duplicating primary key fields description
      * seperated by the delimeter ", " in the case of a input type is a select item.
      */
    var duplicateCodesValue =   arrDuplicate[2];

    if(duplicateCodesValue==null)   duplicateCodesValue = "";

    //alert("duplicateCodesValue : "+duplicateCodesValue);
    var inputType           =   "text";
    var duplicateValue      =   "";

    /**
      * Check for the duplicate primary key fields and if any, display the error message and
      * mark the first duplicating primary key fields using the css class "DUPLICATE".
      */
    if(duplicateCodes!="")
    {
        var duplicateCode       =   "";
        var firstIndex          =   duplicateCodes.indexOf(",");

        if(firstIndex==-1)
        {
            firstIndex          =   duplicateCodes.length;
        }

        var firstDuplicate      =   duplicateCodes.substring(0,firstIndex);
        var startingIndex       =   0;

        for(var i=0; i<duplicateField.length; i++)
        {
            duplicatePKFields   =   duplicateField[i];

            for(var pkIndex=0; pkIndex<duplicatePKFields.length; pkIndex++)
            {
                if( (pkIndex%totalPKColumns) < totalPKColumns )
                {
                    duplicateCode += duplicatePKFields[pkIndex].value + ":";
                }

                if( (pkIndex%totalPKColumns) == (totalPKColumns-1) )
                {
                    duplicateCode   =   duplicateCode.substring(0,duplicateCode.length-1);

                    if(firstDuplicate==duplicateCode)
                    {
                        for(var j=startingIndex; j<=pkIndex; j++)
                        {
                            if( (pkIndex-startingIndex)<=totalPKColumns )
                            {
                                duplicatePKFields[j].className = "DUPLICATE";
                            }
                        }
                        startingIndex   =   pkIndex;
                    }
                    duplicateCode   =   "";
                }
            }
        }

        duplicatePKFields   =   duplicateField[0];

        if( duplicatePKFields[0].type=="select-one" )
        {
            inputType       =   "select-one";
        }

        var error_msg       =   getMessage("DUPLICATE_CODE_EXISTS","Common") + " : " ;

        if( inputType == "text" )
        {
            error_msg       +=  duplicateCodes;
        }
        else if( inputType == "select-one" )
        {
            error_msg       +=  duplicateCodesValue;
        }

        displayErrorMessage(error_msg,objMessageFrame,'',null,errorPage);

        if( inputType != "select-one" )
        {
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
	 
	var firstNullObject     =   checkPOMandatoryFields( fields, names, objMessageFrame,errorPage);

    if(firstNullObject!=null)
    {
        firstNullObject.className = "DUPLICATE";
        firstNullObject.focus();
        return false;
    }
    else
    {
        return true;
    }
}

function checkPOMandatoryFields( fields, names, messageFrame, errorPage)
{
    var errors = "" ,   firstNullObject =   null;
   
var msg_1=getLabel("Common.Cannotbeblank.label","Common");
    for( var i=0; i<fields.length; i++ )
    {
        if(trimString(fields[i].value)!="")
        {
            fields[i].value = trimString(fields[i].value);
			
        }
        else
        {
            if ( errors.length == 0 )
            {
                firstNullObject =   fields[i];
            }
             errors +=" APP-000001 "+  names[i] +"   "+msg_1 + "<br>" ;
        }
    }
	
    if ( errors.length != 0 )
    {
        displayPOErrorMessage(errors,messageFrame,'',null,errorPage,'');
        //messageFrame.document.location.href   =   "../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors ;
    }
    return firstNullObject;
}

function showPOErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame, errorPage,module_Id )
{
	
    displayPOErrorMessage(getMessage(message_ref,module_Id), message_frame, restore_toolbar, toolbar_frame, errorPage);
}

function displayPOErrorMessage(display_message, message_frame, restore_toolbar, toolbar_frame, errorPage)
{

    //alert("message_frame : "+message_frame.name);
	
    if(errorPage==null || errorPage=="")    errorPage       =   "../../eCommon/jsp/MstCodeError.jsp";
    if(message_frame==null || message_frame=="") //|| message_frame==MESSAGE_FRAME)
    {
        while(display_message.indexOf("<br>")!=-1)
        {
            display_message =   display_message.replace("<br>","\n");
        }
        alert(display_message);
        return;
    }
    //paintMessage( display_message, message_frame, restore_toolbar, toolbar_frame );
    //alert("errorPage : "+errorPage);
    message_frame.location.href = errorPage+"?err_num=" + display_message;
}


function checkPOFields( fields, names,messageFrame)
	{
		var errors = "" ;
		for( var i=0; i<fields.length; i++ ) 
		{		
			if(trimPOCheck(fields[i].value)) {}
			else	
			{
				//;var msg_1=getMessage("SHOULD_NOT_BE_BLANK","Common");
				var msg_1=getLabel("Common.Cannotbeblank.label","Common");
				//alert("msg_1--"+msg_1);
				//alert("names[i]--"+names[i]);
				errors +=" APP-000001 "+  names[i] +"   "+msg_1 + "<br>" ;
				
			}
		}
		if ( errors.length != 0 ) {
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			//alert(errors) ;
			return false ;
		}
		return true ;
	}
	


	function trimPOCheck(inString)
	{
		var startPos;
		var ch;
		startPos = 0;
		strlength = inString.length;

		for(var i=0;i<=strlength;i++) {
			ch = inString.charAt(startPos);
			if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
				startPos++;
			}
		}
		if(startPos == inString.length) return false;
		else return true;
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

function createListOption(code, text, selectedValue) {
	var listOption = document.createElement("OPTION");
	listOption.text = text;
	listOption.value = code;
	if (code == selectedValue) {
		listOption.selected = true;
	}
	return listOption;
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

async function callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, chkitemstorecmb, to_store_code, store_disable, item_class_desc, kit, direct_sale) {
	retVal =await window.showModalDialog("../../eST/jsp/ItemSearch.jsp?search_string=" + encodeURIComponent(search_string,"UTF-8") + "&store_code=" + store_code + "&category=" + category + "&sole_source=" + sole_source + "&ps_item=" + ps_item + "&mfg_item=" + mfg_item + "&expiry=" + expiry + "&item_class=" + item_class + "&consignment=" + consignment + "&chkitemstorecmb=" + chkitemstorecmb + "&to_store_code=" + to_store_code + "&store_disable=" + store_disable + "&kit=" + kit + "&direct_sale=" + direct_sale + "&item_class_desc=" + item_class_desc, "", "dialogHeight:38; dialogWidth:55; center:0; status: no; dialogLeft :115; dialogTop :125;");
	return retVal;
}
function clearListItemsNoSelect(listObject) {
	var select_option = "---" + getLabel("Common.defaultSelect.label", "Common") + "---";
	var len = eval(listObject + ".options.length");
	for (i = 0; i < len; i++) {
		eval(listObject + ".remove(0)");
	}
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
		alert(getMessage("INVALID_NUMBER_FORMAT", "Common"));
		obj.focus();
		return false;
	} else {
		if ((parseFloat(obj.value) == 0) && zeroNotAllowed) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
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
function isValidInteger() {
	var key = window.event.keyCode;
	if (!(key >= 48 && key <= 57)) {
		return false;
	} else {
		return true;
	}
}
function clickYes() {
	//parent.window.returnValue = YES;
	//parent.window.close();
	let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = YES;
    
    const dialogTag = parent.document.getElementById('dialog_tag');    
    dialogTag.close(); 
    
	//return returnValue;
}
function clickNo() {
	/*parent.window.returnValue = NO;
	parent.window.close();
	return returnValue;*/
	
	let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = NO;
    
    const dialogTag =parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
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

function ChekDate(obj,locale){
	if(obj.value){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
	alert("convertDate = "+obj);
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}

async function callBatchSearchWindow(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, cuttOffDate, doc_type_code, doc_no, trn_type,itemStoreDisable) {
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
	retVal =await window.showModalDialog("../jsp/BatchSearchFrame.jsp?item_code=" + item_code + "&store_code=" + store_code + "&includeZeroStockBatches=" + includeZeroStockBatches + "&includeExpiredBatches=" + includeExpiredBatches + "&includeSuspendedBatches=" + includeSuspendedBatches + "&searchFunction=" + searchFunction + "&multipleSelect=" + multipleSelect + "&cuttOffDate=" + cuttOffDate + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&trn_type=" + trn_type+"&itemStoreDisable="+itemStoreDisable, "", "dialogHeight:30; dialogWidth:60; center:0; status: no; dialogLeft :200; dialogTop :100;");
	return retVal;
}

function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
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
			obj.focus();
			return false;
		}
	}
	if (!isValidDoubleFormat(obj)) {
		//alert("!isValidDoubleFormat(obj)");
		alert(getMessage("INVALID_NUMBER_FORMAT", "Common"));
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
			obj.focus();
			return false;
		}
	}
}

function checkDateWithSysDate(entered_date,sys_date) {
	//alert("entered_date value : "+entered_date.getDate());
//	alert("entered_date value : "+entered_date);
//	alert("sys_date : "+sys_date);
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	var enteredDate = entered_date;
	var sysDate = sys_date;
//	alert("sysDate : "+sysDate);
//	alert("enteredDate : "+enteredDate);
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

