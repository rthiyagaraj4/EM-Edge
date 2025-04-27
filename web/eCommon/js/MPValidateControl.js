/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
	Function to check the difference between two dates '(from+diffrence)' and 'to' date to validate for other era date of birth.
	By :- Vinod 7/18/2006 8:15 AM
*/
function doDateCheckAlert(from,to,diff) {
    var fromarray; 
	var toarray;
	var fromdate;
	var todate;
	var difference = 0;	  /*The value of the year to be subtracted from 'From Date' and checked with system date.*/
	if (diff!=null)
	{
		difference = diff;
	}

	if ( from.value != undefined)
	{
		fromdate = from.value ;
	}
	else
		fromdate = from;

	if (to.value != undefined)
	{
		todate = to.value ;
	}
	else
		todate = to;

    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(eval(fromarray[2]-difference),fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
			if(Date.parse(todt) < Date.parse(fromdt)) {
                return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    }
return true;
}

function trimCheck(inString) {
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

//Function to give the Last Date of the Current Month
function LastDate(Object) {
    var strDate;
    var strMonth;
    var strYear;
    var datefield = Object;

	if ( datefield.value != undefined )
	{
		strDate = datefield.value;
	}
	else
		strDate = datefield;

    var strDateArray = new Array();

    strDate = datefield.value;

    strDateArray = strDate.split("/");
    strMonth = strDateArray[0];
    strYear = strDateArray[1];

    if  (strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12)
        return 31;
    else if (strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11)
        return 30;
    else if (strMonth == 2) {
        if (LeapYear(strYear) == true) {
            return 29;
        }
        else {
            return 28;
        }
    }
}
// End of Function which returns the last date of current month

/**
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
function allowValidNumber(fld, e, maxInt, deci)
{
    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok

	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45 && count>0)
	{
		return false
	}

    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');
			//alert("dotOccurance : "+dotOccurance);

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                    //alert("APP-0001 Reached Maximum Integer value");
                    //return false;
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
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
                    return false;
                }
            }
        }
    }
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789-';

//	alert(e.getKeyCode())
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789-';

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
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}


//Function to disable all special characters in master codes.
function CheckForSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


//Function to check if spacial characters occur in an object value
function CheckChars(Obj){
        var str = Obj.value;
        var specCharsExist = true;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==42));
            else{
                specCharsExist = false;
                break;
            }
        }
        return specCharsExist;
    }

//Function to check a group of objects for special character occurences
//Arguments Usage
//fields : array f fields to be checked for special characters
//names : Array of names to be appended to error messages
//messageFrame : valid reference to messageFrame object.
//disp_type : "A" or "M" If option is "A" an alert is given and if it is "M" error is routed to messageFrame
//error_jsp : the relative location of error file to which the error should be routed.
function SpecialCharCheck( fields, names, messageFrame,disp_type,error_jsp) {
        var errors = "" ;
        for( var i=0; i<fields.length; i++ ) {
            if(CheckChars(fields[i])) {
            }
            else{
                if (disp_type=="A")errors += getMessage("CANNOT_BE_SPECIAL_CHAR","Common",names);
                else if(disp_type=="M")errors += getMessage("CANNOT_BE_SPECIAL_CHAR","Common",names);
            }
        }
        if ( errors.length != 0 ) {
            var loc_route = error_jsp+"?err_num="+errors;
            if (disp_type=="M")messageFrame.document.location.href=loc_route;
            else if (disp_type=="A")alert(errors);
            return false ;
        }
        return true ;
    }

function codeArrestThruSelect()
{
   var error=getMessage("WELCOME","common");
	alert(error);
}

/* Added on 10/1/2003, Front end validations for checking duplication and other validations of multiple insert */
// Added by Arul

/**
  * GENERAL NOTE:
  *             (opt)   -   stands for OPTIONAL PARAMETER.
  *             (*)     -   stands for MANDATORY PARAMETER.
  */


/**
  * This function is used to check for the manadatory fields and will return
  * the first null object.
  * The Syntax:         checkMandatoryFields( fields, names, messageFrame)
  *
  * @param fields (*)       - represents the array of fields
  * @param names  (*)       - represents the array of fields names or legends to be displayed
  * @param messageFrame(*)  - represents the message frame object where the messages are to be displayed.
  *
  * @return Object          - where object is the First Null Object
  */
function checkMandatoryFields( fields, names, messageFrame, errorPage)
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
                firstNullObject =   fields[i];12/4/2006
            }
            errors +=  getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
        }
    }
    if ( errors.length != 0 )
    {
        displayErrorMessage(errors,messageFrame,'',null,errorPage);
        //messageFrame.document.location.href   =   "../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors ;
    }
    return firstNullObject;
}

/**
  * This function is used to trim the string passed as parameter and return the
  * string that is without leading and trailing blank spaces.
  * The Syntax:         trimString( inString )
  *
  * @param inString (*) - represents the input string which is to be trimmed
  *
  * @return outString   - where outString is the trimmed string
  */
function trimString(inString) {
    var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);
    while ( ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) && startPos<inString.length) {
        startPos++;
        ch = inString.charAt(startPos);
    }
    if(startPos>0)
        inString = inString.substring(startPos, inString.length) ;
    // where do we end?
    endPos = inString.length - 1;

    ch = inString.charAt(endPos);
    while ( ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) && endPos>0  ) {
        endPos--;
        ch = inString.charAt(endPos);
    }

    // get the string
    outString = inString.substring(0, (endPos+1) );
    return outString;
}

/**
  * This function is used to validate the mandatory fields and perform duplicate check also.
  * the first null object.
  * The Syntax:             validateMandatoryFields( formObj, arrFieldName, arrLegends,
  *                                                  arrPKFieldNames, startIndex, objMessageFrame )
  *
  * @param formObj      (*) -   Represents the form object in which all the elements are to be validated.
  * @param arrFieldName (*) -   Represents the array of mandatory fields names.
  * @param arrLegends   (*) -   Represents the array of mandatory fields legends
  *                             that is to be displayed in the error message.
  * @param arrPKFieldNames(*)-  Represents the array of primary key columns,
  *                             on which the duplication validatation is to be performed
  * @param startIndex (opt) -   Starting Index of the element name suffix in multiple insert screen.
  *         NOTE:           -   if the start index is null, the default value is "zero"(0).
  * @param objMessageFrame  -   Represents the message frame object
  *             (opt)           where the messages are to be displayed.
  *         NOTE:           -   It can represent the message frame object location or else
  *                         -   It can have a java script variable MESSAGE_FRAME which is available under
  *                             module level Common js file which denotes the error message
  *                             should be given as alert.
  * @return booleanValue    -   Where booleanValue is the end result of the function,
  *                             which decides whether to proceed further or not.
  *                             if it is true, we can proceed further to submit the form
  *                             if it is false, we should return false and stop the operation.
  */
function validateMandatoryFields( formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage )
{
    /**
      * Initialize default values
      */
    if(startIndex==null)        startIndex      =   0;

    if(objMessageFrame==null)   objMessageFrame =   messageFrame;
	else messageFrame = objMessageFrame
//    else                        objMessageFrame =   null;
    if(errorPage==null)         errorPage       =   "../../eCommon/jsp/MstCodeError.jsp";

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
  /*  alert("totalRecords : "+totalRecords);
    alert("totalColumns : "+totalColumns);
    alert("totalPKColumns : "+totalPKColumns);
 alert("formObj : "+f_query_add_mod.f_query_add_mod_detail.document.Tick_Sheets_insert.totalRecords.value);
 alert(formObj);
alert(formObj.name);
 alert("formObj :"+formObj.totalRecords.value);
  alert("formObj :"+formObj.function_id.value);*/
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
//alert(masterCodes.length);

    if(masterCodes.length==0)
    {
			var error = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common")
        showErrorMessage(error,objMessageFrame,'','',errorPage);
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
	var firstNullObject     =   checkMandatoryFields( fields, names, objMessageFrame,errorPage);

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


/**
  * This function is used to reset the duplicate class displayed in the form.
  * This function can be called on form Apply, in order to reset the color code.
  * This function can be called for resetting the color code for a particular row also.
  * if that needs to be done, pass the third parameter, which will reset the primary key columns
  * belongs to that object - row.
  *
  * The Syntax:             resetDuplicateClass( formObj, arrPKFieldNames )
  *
  * @param formObj      (*) -   Form Object, where the reset operation is to be performed.
  * @param arrPKFieldNames(*)-  Array of Primary Key Columns
  * @param startIndex (opt) -   Starting Index of the element name suffix in multiple insert screen.
  *         NOTE:           -   if the start index is null, the default value is "zero"(0).
  * @param currObject (opt) -   Current Object on which the onBlur event is being triggered.
  *
  * @return void            -   returns void.
  */
function resetDuplicateClass( formObj, arrPKFieldNames, startIndex, currObject )
{
    if(startIndex==null)    startIndex  =   0;

    var totalRecords    =   formObj.totalRecords.value;
    var pkFieldsLength  =   arrPKFieldNames.length;
    var objRowIndex     =   -1;
    totalRecords        =   parseFloat(totalRecords) + parseFloat(startIndex);

    if(currObject!=null)
    {
        for(var colIndex=0; colIndex<pkFieldsLength; colIndex++)
        {
            if(currObject.name.indexOf(arrPKFieldNames[colIndex])!=-1)
            {
                objRowIndex =   currObject.name.substring(arrPKFieldNames[colIndex].length, currObject.name.length);
            }
        }
        //alert("rowIndex : "+rowIndex);
        if(objRowIndex==-1)
        {
            resetColor(currObject);
            return true;
        }
    }

    for(var rowIndex=startIndex; rowIndex<totalRecords; rowIndex++)
    {
        if( (objRowIndex!=-1) && (objRowIndex!=rowIndex) )
            continue;
        for(var colIndex=0; colIndex<pkFieldsLength; colIndex++)
        {
            eval("formObj."+arrPKFieldNames[colIndex]+rowIndex).className = "";
        }
    }
}

/**
  * This function is used to reset the class on the current object
  * The Syntax:         resetColor( currentObj )
  *
  * @param currentObj(*)-   represents an object on which the class name is to be reset
  *
  * @return void        -   returns void
  */
function resetColor(obj)
{
    obj.className   =   "";
}

/**
  * This function is used to return the duplicating primary key values, primary key fields,
  * and its descriptions in the case of select item.
  * The Syntax:         returnDuplicates( masterCodes )
  *
  * @param masterCodes  (*) -   represents the array of primary key columns ( which is in turn an array )
  *
  * @return arrDuplicate    -   returns an array of three values.
  *             @first      -   represents the duplicating primary key values
  *             @second     -   represents the array of duplicating primary key objects
  *             @third      -   represents the duplicating primary key text description in the display
  *                             in the case of the primary key column is a list item.
  */
function returnDuplicates( masterCodes )
{
    var duplicateCodes      =   "";
    var duplicateCodesValue =   "";
    var duplicateField      =   new Array();
    var arrDuplicate        =   new Array();
    var enteredRecords      =   masterCodes.length;
    var dupIndex            =   0;

    var arrCurrPKFields     =   null;
    var arrNextPKFields     =   null;
    /**
      * Check for the duplicate primary key columns / combination exists with the entered records
      */
    for(var i=0; i<enteredRecords;  i++)
    {
        arrCurrPKFields         =   masterCodes[i];

        for(var j=i+1; j<enteredRecords;  j++)
        {
            var duplicateExists =   true;

            arrNextPKFields     =   masterCodes[j];

            for( var pkIndex=0; pkIndex<arrNextPKFields.length; pkIndex++ )
            {
                if( trimString(arrCurrPKFields[pkIndex].value) != trimString(arrNextPKFields[pkIndex].value) )
                {
                    duplicateExists     =   false;
                    break;
                }
            }

            if( duplicateExists )
            {
                var duplicatePKFields   =   new Array();
                var duplicateCode       =   "";
                for( var pkIndex=0; pkIndex<arrCurrPKFields.length; pkIndex++ )
                {
                    duplicatePKFields[duplicatePKFields.length] =   arrCurrPKFields[pkIndex];
                }
                duplicateField[dupIndex++]  =   duplicatePKFields;
                var duplicateCode       =   "";
                var duplicateCodeValue  =   "";
                for( var pkIndex=0; pkIndex<arrNextPKFields.length; pkIndex++ )
                {
                    duplicatePKFields[duplicatePKFields.length] =   arrNextPKFields[pkIndex];
                    if(arrNextPKFields[pkIndex].type=="select-one")
                    {
                        duplicateCodeValue  +=  arrNextPKFields[pkIndex].options(arrNextPKFields[pkIndex].selectedIndex).text + ":";
                    }
                    else
                    {
                        duplicateCodeValue  +=  arrNextPKFields[pkIndex].value + ":";
                    }
                    duplicateCode           +=  arrNextPKFields[pkIndex].value + ":";
                }
                if(duplicateCode.length>0)
                {
                    duplicateCode       =   duplicateCode.substring(0, duplicateCode.length-1);
                    duplicateCodeValue  =   duplicateCodeValue.substring(0, duplicateCodeValue.length-1);
                }
                duplicateField[dupIndex++]  =   duplicatePKFields;
                if(duplicateCodes.indexOf(duplicateCode)==-1) // next_master_code.value
                {
                    duplicateCodes      +=  duplicateCode + ", "; // next_master_code.value+", ";
                    duplicateCodesValue +=  duplicateCodeValue + ", ";
                }
            }
        }
    }
    if(duplicateCodes.length>0)
    {
        duplicateCodes      =   duplicateCodes.substring(0, duplicateCodes.length-2);
        duplicateCodesValue =   duplicateCodesValue.substring(0, duplicateCodesValue.length-2);
    }

    /**
      * Put the duplicating primary key values, primary key fields and
      * its descriptions in the return array and return it back.
      */
    arrDuplicate[0] =   duplicateCodes;
    arrDuplicate[1] =   duplicateField;
    arrDuplicate[2] =   duplicateCodesValue;

    return arrDuplicate;
}

/**
  * This function is used to mark the duplicating primary key fields in the css class "DUPLICATE"
  * The Syntax:         showDuplicates( formObject, arrPKFieldNames, strDuplicates, startIndex )
  *
  * @param formObj      (*) -   Form Object, where the duplicate marking is performed.
  * @param arrPKFieldNames(*)-  Array of Primary Key column names.
  * @param strDuplicates (*)-   A string that represents the duplicate primary key values
  *                             seperated by the delimiter ", " and or ":".
  * @param startIndex (opt) -   Starting Index of the element name suffix in multiple insert screen.
  *         NOTE:           -   if the start index is null, the default value is "zero"(0).
  * @param objMessageFrame  -   Represents the message frame object
  *             (opt)           where the messages are to be displayed.
  *         NOTE:           -   It can represent the message frame object location or else
  *                         -   It can have a java script variable MESSAGE_FRAME
  *                             which is available under module level Common js file
  *                             which denotes the error message should be given as alert.
  *
  * @return void            -   returns void.
  */
function showDuplicates( formObject, arrPKFieldNames, strDuplicates, startIndex, objMessageFrame, errorPage)
{
    if(startIndex==null)    startIndex  =   0;
    if(errorPage==null)     errorPage       =   "../../eCommon/jsp/MstCodeError.jsp";

    var totalRecords    =   formObject.totalRecords.value;
    var totalFields     =   arrPKFieldNames.length;
    var arrDuplicates   =   strDuplicates.split(",");
    var focusFirst      =   true;
    var duplicateCodeValue  =   "";
    var duplicateCodesValue =   "";

    totalRecords        =   parseFloat(totalRecords) + parseFloat(startIndex);

    for( iRowIndex=startIndex; iRowIndex<totalRecords; iRowIndex++ )
    {
        var objectValues    =   "";
        var arrObjects      =   new Array();

        for(iFieldIndex=0; iFieldIndex<arrPKFieldNames.length; iFieldIndex++ )
        {
            arrObjects[iFieldIndex] =   eval("formObject."+arrPKFieldNames[iFieldIndex]+iRowIndex);
            objectValues            +=  arrObjects[iFieldIndex].value;
            if( iFieldIndex < arrPKFieldNames.length-1 )
                objectValues        +=  ":";
        }

        if( isInArray(arrDuplicates, objectValues) )
        {
            if(focusFirst)
            {
                if(arrObjects[0].type!="select-one")
                    arrObjects[0].select();
                arrObjects[0].focus();
                focusFirst = false;
            }
            duplicateCodeValue  =   "";
            for(iFieldIndex=0;iFieldIndex<arrPKFieldNames.length ;iFieldIndex++ )
            {
                arrObjects[iFieldIndex].className   =   "DUPLICATE";
                if(arrObjects[iFieldIndex].type=="select-one")
                {
                    duplicateCodeValue  +=  arrObjects[iFieldIndex].options(arrObjects[iFieldIndex].selectedIndex).text + ":";
                }
                else
                {
                    duplicateCodeValue  +=  arrObjects[iFieldIndex].value + ":";
                }
            }
            if(duplicateCodeValue.length>0)
            {
                duplicateCodeValue  =   duplicateCodeValue.substring(0, duplicateCodeValue.length-1);
            }
            if(duplicateCodesValue.indexOf(duplicateCodeValue)==-1) // next_master_code.value
            {
                duplicateCodesValue +=  duplicateCodeValue + ", ";
            }
        }
    }
    if(duplicateCodesValue.length>0)
    {
        duplicateCodesValue =   duplicateCodesValue.substring(0,duplicateCodesValue.length-2);
    }
    //alert("duplicateCodesValue : "+duplicateCodesValue);
    var error_msg       =   getMessage("CODE_ALREADY_EXISTS","Common") + " : " + duplicateCodesValue;
    displayErrorMessage(error_msg,objMessageFrame,'',null,errorPage);
}

/**
  * This function is used to check the duplicate primary key value is exits in the array or not
  * The Syntax:         isInArray( _array, _value )
  *
  * @param _array(*)    -   represents the array object on which the duplicate values
  *                         should be checked
  * @param _value(*)    -   Primary key value(s) on a single row
  *         NOTE:       -   It can be a composite primary key also.
  *
  * @return found       -   returns true if the _value is found. otherwise, returns false;
  */
function isInArray(_array, _value)
{
    var found   =   false;
    for (index=0;index<_array.length ;index++ )
    {
        if(_array[index]==_value)
        {
            found   =   true;
            break;
        }
    }
    return found;
}

/**
  * This function is used to display the error message with respect to the MESSAGE_REFERENCE
  * The Syntax:         showErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame )
  *
  * @param message_ref(*)       -   represents the MESSAGE_REFERENCE code in the messages array.
  * @param message_frame(opt)   -   message frame object on which the message is to be painted.
  *         NOTE:               -   It can take either one of the following values.
  *         @value1             -   The message frame object reference (ie., parent.messageFrame)
  *         @value2             -   The variable MESSAGE_FRAME defined in module level common
  *                                 javascript file which denotes an java script ALERT.
  * @param restore_toolbar(opt) -   indicates whether to restore the toolbar or not,
  *                                 default is "no restore".
  * @param toolbar_frame(opt)   -   indicates the toolbar frame which is to be restored after submit.
  *                             -   if not specified, it will take, parent.frames[0] as default.
  *
  * @return void                -   returns void
  */
function showErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame, errorPage )
{
    displayErrorMessage(message_ref, message_frame, restore_toolbar, toolbar_frame, errorPage);
}

/**
  * This function is used to display the error message with respect to the actual display message.
  * The Syntax:     displayErrorMessage( message_ref, message_frame, errorPage, restore_toolbar, toolbar_frame )
  *
  * @param display_message(*)   -   represents the actual message which is to be displayed in the output.
  * @param message_frame(opt)   -   message frame object on which the message is to be painted.
  *         NOTE:               -   It can take either one of the following values.
  *         @value1             -   The message frame object reference (ie., parent.messageFrame)
  *         @value2             -   The variable MESSAGE_FRAME defined in module level common
  *                                 javascript file which denotes an java script ALERT.
  * @param restore_toolbar(opt) -   indicates whether to restore the toolbar or not,
  *                                 default is "no restore".
  * @param toolbar_frame(opt)   -   indicates the toolbar frame which is to be restored after submit.
  *                             -   if not specified, it will take, parent.frames[0] as default.
  *
  * @return void                -   returns void
  */
function displayErrorMessage(display_message, message_frame, restore_toolbar, toolbar_frame, errorPage)
{
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
    message_frame.location.href = errorPage+"?err_num=" + display_message;
}

/**
  * This function is used to display the error message in messageFrame.
  * The Syntax:     paintMessage( display_message, message_frame, restore_toolbar, toolbar_frame )
  *
  * @param display_message(*)   -   represents the actual message which is to be displayed in the output.
  * @param message_frame(*)     -   message frame object on which the message is to be painted.
  *         NOTE:               -   It can take either one of the following values.
  *         @value1             -   The message frame object reference (ie., parent.messageFrame)
  *         @value2             -   The variable MESSAGE_FRAME defined in module level common
  *                                 javascript file which denotes an java script ALERT.
  * @param restore_toolbar(opt) -   indicates whether to restore the toolbar or not,
  *                                 default is "no restore".
  * @param toolbar_frame(opt)   -   indicates the toolbar frame which is to be restored after submit.
  *                             -   if not specified, it will take, parent.frames[0] as default.
  *
  * @return void                -   returns void
  */
function paintMessage( display_message, message_frame, restore_toolbar, toolbar_frame )
{
    var HTMLText    =   "";
    HTMLText        =   "<html><head><title>Result</title>";
    HTMLText        +=  "<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>";
    HTMLText        +=  "<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>";
    HTMLText        +=  "</head><body onKeyDown =\"lockKey()\" class=\"MESSAGE\">";
    HTMLText        +=  display_message;
    HTMLText        +=  "</body></html>";
    //alert("message_frame : "+message_frame);
    message_frame.document.open();
    message_frame.document.writeln(HTMLText);
    message_frame.document.close();
    //errorObject.createError();
    //if(restore_toolbar!=null)
    //{
        //setTimeout("goBack("+toolbar_frame+");",150);
    //}
}

/**
  * This function is used to restore the toolbar by moving window.history.back().
  * The Syntax:     goBack( toolbar_frame )
  *
  * @param toolbar_frame(opt)   -   indicates the toolbar frame which is to be restored after submit.
  *
  * @return void                -   returns void
  */
function goBack( toolbar_frame )
{
    if(toolbar_frame==null)
        toolbar_frame   =   parent.frames[0];
    toolbar_frame.history.back();
}
// End of addition by Arul


