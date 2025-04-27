  //saved on 07/11/2005
function checkSplChar( val ) {
    var result = "" ;
    var ch = "" ;

    var spChars = new Array( "<", ">", "&", "\"", "'" ) ;
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;" ) ;
    for(i=0; i<val.length; i++) {
        for(j=0; j<spChars.length; j++) {	
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }

    return result ;
}

//Added by sudhakaran for display the tool tip for data change - 4/1/2003
//parameters class value and text to be displayed in tool tip.
function disasbleToolTipDataChange( classValue ){
    if( classValue == "DATACHANGE" )
        document.getElementById("tooltiplayer").style.visibility = "hidden" ;
}

function displayToolTipDataChange(classValue,text)
{
    if(classValue=="DATACHANGE"){
    buildTableDataChange(text);
    bodwidth  = parent.parent.frames[1].document.body.offsetWidth
    bodheight = parent.parent.frames[1].document.body.offsetHeight
    var x     = event.x
    var y     = event.y;
    x     = x + (document.getElementById("tooltiplayer").offsetWidth)
    y     = y + (document.getElementById("tooltiplayer").offsetHeight)

    if(x<bodwidth)
        x = event.x
    else
        x = x - (document.getElementById("tooltiplayer").offsetWidth*2)
    if(y<bodheight)
        y = event.y
    else
        y = y - (document.getElementById("tooltiplayer").offsetHeight*2)

    y+=document.body.scrollTop
    x+=document.body.scrollLeft
    document.getElementById("tooltiplayer").style.posLeft= x
    document.getElementById("tooltiplayer").style.posTop = y
    document.getElementById("tooltiplayer").style.visibility='visible';
    }else{

    document.getElementById("tooltiplayer").style.visibility='hidden';
    }
}

function buildTableDataChange(text)
{

        var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
        tab_dat     += "<tr>";
        tab_dat     += "<td align='right'  style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow' nowrap  >"+text+"</td>";
        tab_dat     += "</tr>";
        tab_dat     += "</table>";

    document.getElementById("t").innerHTML = tab_dat;

}
//end of sudhakaran.

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
  *-/


function checkMandatoryFields( fields, names, messageFrame)
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
            errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
        }
    }
    if ( errors.length != 0 )
    {
        displayErrorMessage(errors,messageFrame,'');
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
  *-/
function trimString(inString) {
    var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        startPos++;
        ch = inString.charAt(startPos);
    }

    // where do we end?
    endPos = inString.length - 1;
    ch = inString.charAt(endPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        endPos--;
        ch = inString.charAt(endPos);
    }

    // get the string
    outString = inString.substring(startPos, endPos + 1);

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
  *-/
function validateMandatoryFields( formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame )
{
    /**
      * Initialize default values
      *-/
    if(startIndex==null)        startIndex      =   0;
    if(objMessageFrame==null)   objMessageFrame =   messageFrame;
    else                        objMessageFrame =   null;

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
      *-/
    for( var rowIndex=startIndex; rowIndex<totalRecords; rowIndex++ )
    {
        var isNotNull       =   false;
        for( var colIndex=0; colIndex<totalColumns; colIndex++ )
        {
            current_field   =   eval("formObj."+arrFieldName[colIndex]+rowIndex);
            if( trimString(current_field.value)!="")
            {
                isNotNull       =   true;
                break;
            }
        }
        //alert("isNotNull : "+isNotNull);
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
      *-/
    if(masterCodes.length==0)
    {
        showErrorMessage("ATLEAST_ONE_RECORD_ENTERED",objMessageFrame,'');
        formObj.document.parentWindow.FocusFirstElement();
        return false;
    }
    //alert("masterCodes.length : "+masterCodes.length);

    /**
      * Check for the duplicating primary key columns by calling the returnDuplicates function.
      *-/
    var arrDuplicate        =   returnDuplicates(masterCodes);

    /**
      * The first index of the array will contain duplicating primary keys seperated by a delimiter ", ".
      *-/
    var duplicateCodes      =   arrDuplicate[0];

    /**
      * The second index of the array will contain duplicating primary key fields as an Array.
      *-/
    var duplicateField      =   arrDuplicate[1];

    /**
      * The third index of the array will contain duplicating primary key fields description
      * seperated by the delimeter ", " in the case of a input type is a select item.
      *-/
    var duplicateCodesValue =   arrDuplicate[2];

    if(duplicateCodesValue==null)   duplicateCodesValue = "";

    //alert("duplicateCodesValue : "+duplicateCodesValue);
    var inputType           =   "text";
    var duplicateValue      =   "";

    /**
      * Check for the duplicate primary key fields and if any, display the error message and
      * mark the first duplicating primary key fields using the css class "DUPLICATE".
      *-/
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

        var error_msg       =   getMessage("DUPLICATE_CODE_EXISTS") + " : " ;

        if( inputType == "text" )
        {
            error_msg       +=  duplicateCodes;
        }
        else if( inputType == "select-one" )
        {
            error_msg       +=  duplicateCodesValue;
        }

        displayErrorMessage(error_msg,objMessageFrame,'');

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
      *-/
    var firstNullObject     =   checkMandatoryFields( fields, names, objMessageFrame);
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
  *-/
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
  *-/
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
  *-/
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
      *-/
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
      *-/
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
  *-/
function showDuplicates( formObject, arrPKFieldNames, strDuplicates, startIndex, objMessageFrame )
{
    if(startIndex==null)    startIndex  =   0;

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
    var error_msg       =   getMessage("CODE_ALREADY_EXISTS") + " : " + duplicateCodesValue;
    displayErrorMessage(error_msg,objMessageFrame,'');
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
  *-/
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
  *-/
function showErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame )
{
    displayErrorMessage(getMessage(message_ref), message_frame, restore_toolbar, toolbar_frame);
}

/**
  * This function is used to display the error message with respect to the actual display message.
  * The Syntax:     displayErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame )
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
  *-/
function displayErrorMessage(display_message, message_frame, restore_toolbar, toolbar_frame)
{
    //alert("message_frame : "+message_frame.name);
    if(message_frame==null || message_frame=="" || message_frame==MESSAGE_FRAME)
    {
        while(display_message.indexOf("<br>")!=-1)
        {
            display_message =   display_message.replace("<br>","\n");
        }
        alert(display_message);
        return;
    }
    paintMessage( display_message, message_frame, restore_toolbar, toolbar_frame );
    //message_frame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + display_message;
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
  *-/
function paintMessage( display_message, message_frame, restore_toolbar, toolbar_frame )
{
    var HTMLText    =   "";
    HTMLText        =   "<html><head><title>Result</title>";
    HTMLText        +=  "<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>";
    HTMLText        +=  "</head><body class=\"MESSAGE\">";
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
  *-/
function goBack( toolbar_frame )
{
    if(toolbar_frame==null)
        toolbar_frame   =   parent.frames[0];
    toolbar_frame.history.back();
}
// End of addition by Arul
*/




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
    else                        objMessageFrame =   null;
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
            if( trimString(current_field.value)!="")
            {
                isNotNull       =   true;
                break;
            }
        }
        //alert("isNotNull : "+isNotNull);
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
		var error = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common")
        showErrorMessage(error,objMessageFrame,'');
        formObj.document.parentWindow.FocusFirstElement();
        return false;
    }
    //alert("masterCodes.length : "+masterCodes.length);

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
    var firstNullObject     =   checkMandatoryFields( fields, names, objMessageFrame);
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
function CheckSpecChars(event){	
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*.';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		//return (event.keyCode -= 32);
	return true ;
	}

  function validateNumbers(obj,intPart,decimalPart)
  {

	var number = obj.value;
	var dotOccurance = number.indexOf('.');
	var totalLength = number.length;

	if(dotOccurance == -1)
	{
		if(parseInt(totalLength) > parseInt(intPart))
		{
			var msg = getMessage("INTEGER_NOT_VALID", "PH");
			msg = msg.replace('~', intPart);
			alert(msg);
			obj.focus();
			return false;
		}
	}
	else
	{
		var iPart = number.split(".")[0];
		var dPart = number.split(".")[1];

		if(parseInt(intPart)<parseInt(iPart.length))
		{
			var msg = getMessage("INTEGER_NOT_VALID", "PH");
			msg = msg.replace('~', intPart);
			alert(msg);
			obj.focus();
			return false;
		}
		if(parseInt(decimalPart)<dPart.length)
		{
			var msg = getMessage("DECIMAL_NOT_VALID", "PH");
			msg = msg.replace('~', decimalPart);
			alert(msg);
			obj.focus();
			return false;
		}
	}
	return true;
  }

function showTable(){
	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
		tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eCA.NoofRows.label","CA")+"</td><td class='fields'><input type='text' name='rows' id='rows' size='2' maxLength='2' value='5' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td><td class='data' nowrap"+getLabel("eOR.NoofColumns.label","OR")+"</td><td class='fields'><input type='text' name='cols' id='cols' size='1' maxLength='1'  value='3' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>"
					tab_dat     += "<td class='label'><input type='button' class='button' name='ok' id='ok' value="+getLabel("Common.ok.label","Common")+" onClick='setBuildTable()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
		tab_dat     += "</table> "
		resizeWindow(tab_dat);
		//table_count = document.getElementById("table_count").value;
		//if(table_count=="") table_count = 0;
		//document.getElementById("table_count").value = parseInt(table_count)+1;
}
 
function deleteTable(){
//	var table	 =  parent.editor.RTEditor0.document.body.all.tags("TABLE");
//	table_length = table.length;
// 	if(document.getElementById("table_count").value!="" && document.getElementById("table_count").value <=1) {
//	if(table_length!="" && table_length >0) {
		var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 			tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eOR.TableNo.label","OR")+"</td><td class='fields'><input type='text' name='table_no' id='table_no' size='2' maxLength='2' value='1' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ><td class='data' nowrap>"+getLabel("eOR.RowNotobedeleted.label","OR")+"</td><td class='fields'><input type='text' name='delete_row' id='delete_row' size='2' maxLength='2' value='1' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>"
			tab_dat     += "<td class='label'><input type='button' class='button' name='ok' id='ok' Value="+getLabel("Common.ok.label","Common")+" onClick='deleteTableRow()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' Value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 			tab_dat     += "</table> "
			resizeWindow(tab_dat);	
//	}
//	}
}
function deleteTableRow(){
		hideToolTip();
		var table_no	= document.getElementById("table_no").value;
		if(table_no!="" && table_no!=0) {
 			table_no	= parseInt(table_no-1);
	 	}	
		else
			table_no	= 0;
		var rows = document.getElementById("delete_row").value;
		if(rows!="")
			rows = parseInt(rows) - 1;

		if(parent.editor.RTEditor0.document.getElementById(table+table_no) && 		parent.editor.RTEditor0.document.getElementById('table'+table_no).rows["+rows+"])
		{
			parent.editor.RTEditor0.document.getElementById('table'+table_no).deleteRow("+rows+");
 			if(parent.editor.RTEditor0.document.getElementById('table'+table_no).rows.length==0){
				parent.editor.RTEditor0.document.getElementById('table'+table_no).clear;
 			}
		}
}

function addTable(){
		var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 			tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eOR.TableNo.label","OR")+"</td><td class='fields'><input type='text' name='table_no' id='table_no' size='2' maxLength='2' value='' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ><td class='data' nowrap>"+getLabel("eOR.RowNo.label","OR")+"</td><td class='fields'><input type='text' name='add_row' id='add_row' size='2' maxLength='2' value='2' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>"
			tab_dat		+="<td class='data' nowrap>"+getLabel("eOR.ColumnNo.label","OR")+"</td><td class='fields'><input type='text' name='add_columns' id='add_columns' size='1' maxLength='1' value='1' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>";
			tab_dat     += "<td class='fields'><input type='button' class='button' name='ok' id='ok' Value="+getLabel("Common.ok.label","Common")+" onClick='addTableRow()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' Value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 			tab_dat     += "</table> "
			resizeWindow(tab_dat);	
}

function addTableRow(){
	
	hideToolTip();
	var table_no	= document.getElementById("table_no").value;
	if(table_no!="" && table_no!=0) {
 		table_no	= parseInt(table_no-1);
 	}	
	else
		table_no	= 0;
   	if(table_no>=0){
   		var rows		= document.getElementById("add_row").value;
		var cols		= document.getElementById("add_columns").value;
 		if(rows > 1) {
			rows	 = rows-1;
			if(cols!="" && cols>0)
				cols = parseInt(cols);
   	 		if(parent.editor.RTEditor0.document.getElementById('table'+table_no) && rows>0) {
				if(parent.editor.RTEditor0.document.getElementById('table'+table_no).rows.length!=0)
	  				parent.editor.RTEditor0.document.getElementById('table'+table_no).insertRow("+rows+");
			}
			for( j=0;j<cols;j++) {
				if(parent.editor.RTEditor0.document.getElementById('table'+table_no) && parent.editor.RTEditor0.document.getElementById('table'+table_no).rows["+rows+"])
					parent.editor.RTEditor0.document.getElementById('table'+table_no).rows["+rows+"].insertCell();
	  		}
		}
	}
}

function checkBeforeDecimal(val,e){//added checkBeforeDecimal() function for ML-BRU-SCF-1437
	var num = val.value;
	 var whichCode = (window.Event) ? e.which : e.keyCode;
	var nString = String(num);
	if(document.getElementById('id_qty_value')!=null){
		if(nString.indexOf(".")==-1)
			document.getElementById('id_qty_value').maxLength=8;
		else
			document.getElementById('id_qty_value').maxLength=13;
	}
	var nArray = nString.split('.');
	if(nArray[0].length > 7){
		if(whichCode!=46){
			val.value = val.value;
        }
	}
}
function CheckDateLeap(obj, format, locale){//Added CheckDateLeap funtion for RollForward from SRR - SRR20056-SCF-9383 [IN:056576]  
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
}
function allowAlphaNumeric(event) { // Added for ML-MMOH-CRF-1266 [IN:068728] - Start	
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		return true ;
} // Added for ML-MMOH-CRF-1266 [IN:068728] - End

