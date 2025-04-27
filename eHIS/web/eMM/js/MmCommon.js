var MODE_DELETE		=	'0';
var MODE_INSERT		=	'1';
var MODE_MODIFY		=	'2';
var MESSAGE_FRAME	=	'Alert';
var function_id		=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ; 
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
        alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
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

function getMMBlankField( fields, legends, messageFrame, errorPage) {
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

        var error_msg       =   getMMMessage("DUPLICATE_CODE_EXISTS") + " : " ;

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
            errors = errors + "APP-000001 " + names[i] +" "+ getLabel("Common.Cannotbeblank.label","Common") + "<br>" ;
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




function validateMMMandatoryFields( formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage )
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
        showMMErrorMessage(error_msg1,objMessageFrame,'','',errorPage,"Common");
		//showMMErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame )
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
	 
	var firstNullObject     =   checkMMMandatoryFields( fields, names, objMessageFrame,errorPage);

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

function checkMMMandatoryFields( fields, names, messageFrame, errorPage)
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
        displayMMErrorMessage(errors,messageFrame,'',null,errorPage,'');
        //messageFrame.document.location.href   =   "../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors ;
    }
    return firstNullObject;
}

function showMMErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame, errorPage,module_Id )
{
	
    displayMMErrorMessage(getMessage(message_ref,module_Id), message_frame, restore_toolbar, toolbar_frame, errorPage);
}

function displayMMErrorMessage(display_message, message_frame, restore_toolbar, toolbar_frame, errorPage)
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


function checkMMFields( fields, names,messageFrame)
	{
		var errors = "" ;
		for( var i=0; i<fields.length; i++ ) 
		{		
			if(trimMMCheck(fields[i].value)) {}
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
	


	function trimMMCheck(inString)
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
/*function lockKey()
{
	whichCode = event.keyCode;
    if(whichCode== 93)
	{
       var error=getMessage("WELCOME","common");
	alert(error);
	}
    else 	if(whichCode == 113)
	{
		var width = 800 ;
		var height = 550 ;
		var left = (window.screen.availWidth-width)/2 ;
		var top  = (window.screen.availHeight-height)/2 ;

		var myBars = 'directories=no,location=no,menubar=no,status=no' ;
		var myOptions = 'width=' + width +', height=' + height +', resizable=no' ;
		var myFeatures = myBars + ', ' + myOptions ;
		// var helpWindow = open( '../../eCommon/jsp/help.jsp?url='+document.location.href, 'eHIS', myFeatures ) 
var helpWindow = open( '../../OnlineHelp/webhelp.jsp?url='+document.location.href, 'eHIS', myFeatures ) 
	}
}*/


function isValidInteger() {
	var key = window.event.keyCode;
	if (!(key >= 48 && key <= 57)) {
		return false;
	} else {
		return true;
	}
}

function checkIntegerFormat(obj, zeroNotAllowed) {

	if (zeroNotAllowed == null) {
		zeroNotAllowed = true;
	}
	if (obj.value == "") {
		return;
	}
	if (!isValidIntegerFormat(obj)) {
		alert(getMessage("INVALID_NUMBER_FORMAT", "PH"));
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

