/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// these two variables are used for the function TextBlink() and BlinkText()
var textStr = new Array();
var i=0;
var prevTabObj=null

function CheckFunction(str) {
    alert("APP-MP0016 - " + str);
}

function CheckChartMaintenance(str,messageFrame) {
    messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-MP0088 - " + str ;
}

function checkval(str,str1,obj,obj1)
    {
	/*	if ( obj.value != undefined)
		{
			obj = obj.value ;
		}
		else
			obj = obj;

		if ( obj1.value != undefined)
		{
			obj1 = obj1.value ;
		}
		else
			obj1 = obj1;*/

        var val=parseInt(obj.value,10);
        var val1=parseInt(obj1.value,10);
		var arr = new Array(str,str1)
        if (val>=val1) {
           var msg = getMessage("CANNOT_GREATER","MP");
			msg = msg.replace('$',str);
			msg = msg.replace('#',str1);
			alert(msg);
            obj1.select();
            obj1.focus();
        }
    }

function CheckMonth(obj)
{
    if(monthcheck(obj)==false)
    {
        alert(getMessage("MONTH_YEAR_INVALID", "SM"));
        obj.select();
        obj.focus();
    }
}

function monthcheck(obj)
{
   if ( obj.value != undefined)
	{
		obj = obj.value ;
	}
	else
		obj = obj;

	var dt=obj;
    var strMonth ;
    var strYear;
    if( dt.length > 0 )
    {
        var arr = new Array();
        arr = dt.split("/");
        if(arr.length != 2) return false;
        else
        {
            strMonth = arr[0];
            strYear = arr[1];

            if (strMonth.substring(1,2) == ".") return false;
            if (strYear.length < 4 || strYear.length > 4) return false;

            if (isNaN(strMonth)==true) return false;
            if (isNaN(strYear)==true) return false;

            if (strYear < 1900) return false;
            if (strMonth>12 || strMonth<1) return false;
        }
    } else return true;
    return true;
}

function checkmonths(str,fromdt,todt,messageFrame) {

	if ( fromdt.value != undefined)
	{
		fromdt = fromdt.value ;
	}
	else
		fromdt = fromdt;
	
	if ( todt.value != undefined)
	{
		todt = todt.value ;
	}
	else
		todt = todt;

    var arr = new Array();
    var arr1 = new Array();
    arr = fromdt.split("/");
    arr1 = todt.split("/");
    if(arr[0].length == 1)
        var fr=arr[1] + '0' + arr[0];
    else
        var fr=arr[1] + arr[0];

    if(arr1[0].length == 1)
        var to=arr1[1] + '0'+arr1[0];
    else
        var to=arr1[1] + arr1[0];

    if(fr <= to)
        return true;
    else {
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("REMARKS_MUST_GR_EQUAL","common",arr)  ;
        return false;
    }
}



function CheckNum(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

function CheckForNumber(val) {
    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            return false;
        }
}

function CheckMaxLen(lab,obj,max,messageFrame) {
	
        if(obj.value.length > max) {
           // messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-SM0045 - " + lab + " cannot exceed " + max  + " characters" ;
		   var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		   msg = msg.replace("$",lab);
		   msg = msg.replace("#",max);
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+ msg
            return false;
        } else return true;
}

function checkFields( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else {
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
		}
    }
    if ( errors.length != 0 ) {
        
		/*var expand_value;
		var type_value;
		var buttonobj_value;
buttonobj_value=parent.parent.frames[0].document.forms[0].home;
parent.parent.parent.frames[1].expand_val.expandState=0;
if(parent.parent.parent.frames[1].expand_val.expandState=="0")
		{
		parent.parent.parent.frames[1].expand(buttonobj_value,type_value,"cm");
		}
		var expand =parent.parent.parent.frames[1].expand_val.expandState;*/
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
       return false ;
		//alert(parent.parent.parent.frames[1].type_val.value);

//	if(parent.parent.frames[0].document.forms[0].home.value=="")
    }
    return true ;
}

function checkFieldsofMst( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else    errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}
// ADDED BY MADHAVAN.S FOR DISPLAYING THE ERROR MESSAGES AS ALERT BOX INSTEAD OF IN ERROR FRAME IN MODAL WINDOW

function checkField( field, name ) {
    if( trimCheck(field.value) )
    {
        field.value = trimString(field.value);
        return true;
    }
    else
    {
        alert(getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(name))) ;
        field.focus();
        return false ;
    }
}

function trimCheck(inString) {
if ( (inString != 'undefined') && (inString != undefined ) )
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
}

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
	if (startPos>endPos)
	{
		return '';
	}
	else
	    return outString;
}



// ADDED BY MADHAVAN.S. FOR CHECKING NOT NULL WITHOUT TRIMMING THE blank SPACE..........

//Function to Validate the year
function CheckYear(Obj) {
    var val = Obj.value;
    var Year = Obj.value;
    if ((trimCheck(val)==false && isNaN(val) && val >=0 )
    ||( Year.length < 4 && Year.length > 0)
    ||(Year.length == 4 && isNaN(val) == true) )
    {
        alert(getMessage("INVALID_YR_FORMAT", "SM"));
        Obj.select();
        Obj.focus();
    }
}

function TextBlink(str) {
    var arr=new Array();
    var val="";
    arr=str.split("#");
    temp = "document.getElementById('patdetails').firstElementChild.nodeValue =arr[0];";
    eval(temp);
    if(arr[3]=="D") val="Deceased";
    else {
        if(arr[1]=="I" && arr[2]=="S" ) val = "Inactive/Suspended";
        else if(arr[1]=="I") val="Inactive";
        else if(arr[2]=="S") val="Suspended";
    }
    textStr[0] = ""+val;
    textStr[1] = "";
    setInterval("BlinkText()", 500);
}

function BlinkText() {
  temp = "document.getElementById('message').firstElementChild.nodeValue = textStr[i];";
  eval(temp);
    if (i == 1) i = 0;
    else i++;
}

/*function GifBlink(str,frm) {
    var arr=new Array();
    var temp;
    var temp1;
    var val="";
    var pat_line = "";
    str = unescape(str);
	
    //Added by kumar for handling special characters. "#"
    pat_line=str.substring(0,str.length-6);
    str = str.substring(str.length-5);
    arr=str.split("#");
	
	temp = "document.getElementById('patdetails').firstElementChild.nodeValue = pat_line;";
	//alert(arr);
    eval(temp);
	if(arr[2]=="D") {
        temp = frm + ".nam.src='../../eCommon/images/Blank1.gif';";
        temp1 = frm + ".nam1.src='../../eCommon/images/Deceased.gif';";
    }
    else {
        if(arr[0]=="I" && arr[1]=="S" ) {
            temp = frm + ".nam.src='../../eCommon/images/Inactive.gif';";
            temp1= frm + ".nam1.src='../../eCommon/images/Suspended.gif';";
        }
        else if(arr[0]=="I") {
            temp = frm + ".nam.src='../../eCommon/images/Blank1.gif';";
            temp1 = frm + ".nam1.src='../../eCommon/images/Inactive.gif';";
        }
        else if(arr[1]=="S") {
            temp = frm + ".nam.src='../../eCommon/images/Blank1.gif';";
            temp1 = frm + ".nam1.src='../../eCommon/images/Suspended.gif';";
        }
    }
//	alert(temp);
	//alert(temp1);
     eval(temp);
     eval(temp1);
    }
*/
function GifBlink(str,frm) {
    var arr=new Array();
    var temp;
    var temp1;
    var val="";
    var pat_line = "";
	var strt="<BLINK><font color='yellow'><b>";
	var end="</b></font></BLINK>";
    str = unescape(str);
	
    //Added by kumar for handling special characters. "#"
    pat_line=str.substring(0,str.length-6);
    str = str.substring(str.length-5);
    arr=str.split("#");
	
	temp = "document.getElementById('patdetails').firstElementChild.nodeValue = pat_line;";
	//alert(arr);
    eval(temp);
	if(arr[2]=="D") {
		var inhtm=strt + getLabel('Common.deceased.label','common') + end;
        temp1= frm + ".nam.innerHTML=\""+inhtm+"\";";
    }
    else {
        if(arr[0]=="I" && arr[1]=="S" ) {
		  var inhtm=strt + getLabel('Common.Inactive.label','common')+" "+ getLabel('Common.and.label','common')+ " ";
		  inhtm= getLabel('Common.Suspended.label','common') + end;
			
            temp1= frm + ".nam.innerHTML=\""+inhtm+"\";";
        }
        else if(arr[0]=="I") {
			var inhtm=strt + getLabel('Common.Inactive.label','common') + end;
            temp1= frm + ".nam.innerHTML=\""+inhtm+"\";";
        }
        else if(arr[1]=="S") {
			 var inhtm=strt + getLabel('Common.Suspended.label','common') + end;
            temp1= frm + ".nam.innerHTML=\""+inhtm+"\";";
        }
    }
     eval(temp);
     eval(temp1);
    }
// *************************************************************************************
function CheckPositiveNumber(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("ONLY_POSITIVE_NUM", "SM"));
            obj.select();
            obj.focus();
        }
        else if ( obj.value.length == 0 )
            obj.value = 0;
    }
}
// *************************************************************************************
function callOnlineReportsPrinting(module_id,step,patient_id,target) {
    var retVal =    new String();
    var dialogHeight    = "30" ;
    var dialogWidth = "50" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
    var arguments   = "" ;
    retVal = window.showModalDialog("../../eCommon/jsp/InternalReportsReprint.jsp?module_id="+module_id+"&step="+step+"&patient_id="+patient_id+"&target="+target,arguments,features);
}
// *************************************************************************************

// *************************************************************************************
// Function for Patient Search

async function PatientSearch(jsp_name,window_styl,close_yn,win_top,win_height,win_width,act_yn,srr,register_button_yn,func_act,dr_function_id) {
        if (window_styl == null || window_styl.length     == 0)         window_styl='O';
        if (close_yn    == null || close_yn.length         == 0)        close_yn='Y';
        if (jsp_name    == null || jsp_name.length        ==0   )   jsp_name='';
        if (win_top == null || win_top.length == 0) win_top= '0px';
        if (win_height == null || win_height.length == 0) win_height= '700px';
        if (win_width == null || win_width.length == 0) win_width= '900px';
        if (act_yn == null || act_yn.length == 0) act_yn= 'N';
        if (register_button_yn == null || register_button_yn.length == 0) register_button_yn = 'N';
        if(func_act == null || func_act.length == 0) func_act='';
        if(dr_function_id == null || dr_function_id.length == 0) dr_function_id='';

         if (srr == null || srr.length == 0) srr='Y';

        window_styl = window_styl.toUpperCase();
        close_yn = close_yn.toUpperCase();
        act_yn = act_yn.toUpperCase();


        var url     = "../../eMP/jsp/ModelPatientSearch.jsp?jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_top="+win_top+"&win_height="+win_height+"&win_width="+win_width+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&func_act="+func_act+"&dr_function_id="+dr_function_id;
        /*var dialogTop   = "65";
        var dialogHeight    = "44" ; //30.5
        var dialogWidth = "65" ;*/
		var dialogTop   = "0px";
		var dialogHeight    = "700px" ; //30.5
		var dialogWidth = "950px" ;
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
        var returnval = await window.showModalDialog( url, arguments, features ) ;
        return returnval;
}


//*******Help***********
//jsp_name -- jsp name to call
//window_styl -- Same browser value N/O  N-New O-old
//close_yn  -- Close search window? Y/N
//win_top --  shift from top of screen
//win_height -- height of the window
//win_width -- width of the top
//act_yn --  hyperlink for deceased/suspended records
//register_button_yn -- register patient button
//func_act -- facilitate different actions for register button

// *************************************************************************************


/*
    Funtion     : function PatientSearchWithDefaultGender(defaultgender, enablegenderyn)
    Added by    : Chitra
    Purpose     : To default the Sex value in Search criteria to the one passed as paramater.
    Parameters :
    defaultgender = 'M' for male and 'F' for female
    enablegenderyn = 'N' if select item is to be disabled

*/
async function PatientSearchWithDefaultGender(defaultgender, enablegenderyn) {
//alert(defaultgender+enablegenderyn);

        window_styl='O';
        close_yn='Y';
        jsp_name='';
        /*win_top= '61';
        win_height= '44';
        win_width= '65';
		*/
		var win_height= "400px" ;
	    var win_top = "10px" ;
	    var win_width	= "700px" ;
		
        act_yn= 'N';
        register_button_yn = 'N';
        func_act='NEWBORN_REG';
        srr='Y';

        window_styl = window_styl.toUpperCase();
        close_yn = close_yn.toUpperCase();
        act_yn = act_yn.toUpperCase();

        var url     = "../../eMP/jsp/ModelPatientSearch.jsp?jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_top="+win_top+"&win_height="+win_height+"&win_width="+win_width+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&func_act="+func_act+"&default_gender="+defaultgender+"&enable_gender_yn="+enablegenderyn;
       /* var dialogTop   = "65";
        var dialogHeight    = "44" ;
        var dialogWidth = "65" ;
        var arguments   = "" ; */
		var dialogHeight= "400px" ;
	    var dialogTop = "10px" ;
	    var dialogWidth	= "700px" ;
		
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
        var returnval = await window.showModalDialog( url, arguments, features ) ;
        return returnval;
}

function SPCheckFields( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else    errors += getMessage("SHOULD_NOT_BE_BLANK","Common",encodeURIComponent(names));
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../sp/jsp/SPError.jsp?MsgBodyContent="+errors ;
        return false ;
    }
    return true ;
}
// *************************************************************************************
function SPCheckMaxLen(lab,obj,max) {
        if(obj.value.length > max) {
			//var arr = new Array(lab,max)
			var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
			msg = msg.replace("$",lab);
			msg = msg.replace("#",max);
            alert(msg) ;
            obj.focus();
            return false;
        }
        else
            return true;

}
// *************************************************************************************
function SPCheckPositiveNumber(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("ONLY_POSITIVE_NUM", "SM"));
            obj.select();
            obj.focus();
        }
    }
}
// *************************************************************************************
//This function is to limit the no of character entry into text box/ text area.
function checkMaxLimit(obj,maxSize) {
        if ( obj.value.length >= maxSize )
        {
            event.returnValue = false;
        }
    }

// To get focus to the first readable element in the form
// To be called in body-onload event

    function FocusFirstElement()
{
    for(i=0;i<document.forms[0].elements.length;i++)
    {
        if(document.forms[0].elements(i).type!="hidden" && document.forms[0].elements(i).type!="password" && document.forms[0].elements(i).type!="button"  )
        {
            if( document.forms[0].elements(i).readOnly!=true && document.forms[0].elements(i).disabled!=true)
            {
                document.forms[0].elements(i).focus();
                break;
            }
        }
    }
}
/**
  * Included by Arul on 10th July 2002 for Handling Special Characters
    * Purpose:-
    *       - It will findout double quote and replace with single quote
    *       - It will findout "&" or "<" and suffix that character with a blank space
    * Usage:-
    *       - Should be called in onBlur of a text field
    */
function makeValidString(txtObj)
{
    var text_value  =   txtObj.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    txtObj.value = text_value;

    if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

    for(var i=0; i<text_value.length; i++)
    {
        if( (text_value.charAt(i)=='&')  || (text_value.charAt(i)=='<') )
        {
            if(text_value.charAt(i+1)!=' ')
            {
                text_value  =   text_value.substring(0,(i+1))+' '+ text_value.substring((i+1),text_value.length);
                i++;
            }
        }
    }
    txtObj.value = text_value;
    if(txtObj.value.length>txtObj.maxLength)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));

        txtObj.select();
        txtObj.focus();
    }
}

/**
  * Included by Arul on 17th July 2002 for Handling Special Characters on Query Criteria
    * Purpose:-
    *       - It will findout double quote and replace with single quote
    *       - It will findout single quote and replace with two single quotes
    *       - It will findout "&" or "<" and suffix that character with a blank space
    * Usage:-
    *       - Should be called in onBlur of a text field
    */
function makeValidQueryCriteria(txtObj)
{
    var text_value  =   txtObj.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    txtObj.value = text_value;

    if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

    for(var i=0; i<text_value.length; i++)
    {
        if( (text_value.charAt(i)=='&')  || (text_value.charAt(i)=='<') || (text_value.charCodeAt(i)==92)   )
        {
            if(text_value.charAt(i+1)!=' ')
            {
                text_value  =   text_value.substring(0,(i+1))+' '+ text_value.substring((i+1),text_value.length);
                i++;
            }
        }
    }
    txtObj.value = text_value;
    for(var i=0; i<text_value.length; i++)
    {
        if( text_value.charAt(i)=="'" )
        {
            var j= i+1 ;
            if( !(text_value.charAt(j)=="'"))
            {
                text_value  =   text_value.substring(0,(i+1))+"'"+ text_value.substring((i+1),text_value.length);
            }
            i++;
        }

    }
    txtObj.value = text_value;
    if(txtObj.value.length>txtObj.maxLength)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "SM"));
        txtObj.select();
        txtObj.focus();
    }
}

function getRelativeURL(targetURL)/* Created by Arul*/
{
    var url = "";

    if(top.messageframe!=null)
        url = top.messageFrame.location.href;
    else
        url = top.content.messageFrame.location.href;

    var action_url = targetURL;
    if(url.indexOf("/servlet")!=-1) {
        action_url = ".."+targetURL;
    }
    else {
        action_url = "../.."+targetURL;
    }
    return action_url;
}

/* Online Reports functions added by BalaRR on 08/01/2003 Starts */
function callOnlineReport() {
    var width = 2 ;
    var height = 2 ;
    var left = (window.screen.availWidth-width)/2 ;
    var top  = (window.screen.availHeight-height)/2 ;

    var myBars = "directories=no,location=no,menubar=no,status=no" ;
    var myOptions = "width=" + width +", height=" + height ;
    var myFeatures = myBars + ", " + myOptions ;
    var reportWindow = open( "../html/onLineReportsCaller.html" , "_blank", myFeatures ) ;
    reportWindow.moveTo( left, top ) ;
}
/* Online Reports functions added by BalaRR on 08/01/2003 Ends */


/* Added on 13/1/2003, By Parimala  Start */

var MODE_DELETE = '0' ;
var MODE_INSERT = '1' ;
var MODE_MODIFY = '2' ;
var MESSAGE_FRAME = 'Alert' ;
var PH_CONTROLLER = "../../ePH/jsp/PhController.jsp" ;
var OR_CONTROLLER = "../../eOR/jsp/OrController.jsp" ;
var MM_CONTROLLER = "../../eMM/jsp/MmController.jsp" ;
var ST_CONTROLLER = "../../eST/jsp/StController.jsp" ;
var SS_CONTROLLER = "../../eSS/jsp/SsController.jsp" ;
var PO_CONTROLLER = "../../ePO/jsp/PoController.jsp" ;
var RS_CONTROLLER = "../../eRS/jsp/RsController.jsp" ;

function formApply(frmObj, controllerJSP) {

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
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
                    val = arrObj[i].value;
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

    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    beforePost(xmlStr) ;
    xmlHttp.open("POST", controllerJSP, false);
	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.send(xmlDoc);
    return xmlHttp.responseText  ;
}


function beforePost(xmlStr){}

/*
function checkSpl( val ) {
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
*/

function checkSpl( val ) {
    var result = "" ;
    var ch = "" ;

    var indVal = 0;
    while ( (indVal = val.indexOf('\n',indVal)) != -1 )
    {
        val = val.replace("\n","\"")
    }

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
    //alert(result)
    return result ;
}

/* Added on 13/1/2003, By Parimala  End  */

/* Added on 14/2/2003, By BalaRR Start */
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
           errors += getMessage("SHOULD_NOT_BE_BLANK","Common",legends)
        }
    }
    if ( errors.length != 0 ) {
        messageFrame.location.href=errorPage+"?err_num="+errors;
    }
        return obj ;
}

/* Added on 14/2/2003, By BalaRR End */

////*** Start Function to Show the patient Image in a Modal Window Added by ChandraSekhar M  ***///
	function showPatientImage(patient_id) 
	{
		var width = 200 ;
		var height = 200 ;
		var left = (window.screen.availWidth-width)/2 ;
		var top  = (window.screen.availHeight-height)/2 ;

		var myBars = 'directories=no,location=no,menubar=no,status=no' ;
		var myOptions = 'width=' + width +', height=' + height +', resizable=no' ;
		var myFeatures = myBars + ', ' + myOptions ;
		var imageWindow = open( '../../eMP/jsp/ViewPatientImage.jsp?patient_id='+patient_id, 'eHISMain', myFeatures ) ;
		imageWindow.moveTo( left, top ) ;
	}
	
////**** End Function to Show the patient Image in a Modal Window by ChandraSekhar M ****////

function getMessage( message_ref, moduleId, param ) {
	if(param ==null)	param = new Array()

  var xmlHttp
		if(navigator.appName.indexOf("Internet") ==-1)
			xmlHttp = new XMLHttpRequest();
		else
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");


		message_ref=message_ref.toUpperCase();
		moduleId = moduleId.toLowerCase()


		var urlString ="?msgId="+message_ref+"&moduleId="+moduleId

			for(var i=1;i<=param.length;i++) {
				urlString +="&"+i+"="+param[i-1]
			}

		xmlHttp.open("POST","../../eCommon/jsp/MessageContainer.jsp"+urlString, false);
		xmlHttp.setRequestHeader("Content-Type","text/html;charset=UTF-8")
		xmlHttp.send();

		var xmlText = xmlHttp.responseText
		
		return(TrimStr(xmlHttp.responseText))
		    
}

function TrimStr(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function getLabel( label_ref, moduleId ) {
  var xmlHttp
		if(navigator.appName.indexOf("Internet") ==-1)
			xmlHttp = new XMLHttpRequest();
		else
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		
		message_ref=label_ref.toUpperCase();
		moduleId = moduleId.toLowerCase()
		xmlHttp.open("POST", "../../eCommon/jsp/LabelContainer.jsp?labelId="+label_ref+"&moduleId="+moduleId, false);
		xmlHttp.setRequestHeader("Content-Type","text/html;charset=UTF-8")
		xmlHttp.send("");

		var xmlText = xmlHttp.responseText
		return(TrimStr(xmlText));
		    
}


function selectTab(tabObj){
	
//	alert(tabObj);
		if(prevTabObj!=null){
				document.getElementById(prevTabObj).className="tabA"
				document.getElementByIdprevTabObj+"span").className="tabAspan"
			}
			document.getElementById(tabObj).className="tabClicked"
			document.getElementById(tabObj+"span").className="tabSpanclicked"
			prevTabObj=tabObj
}

function checkForNull1(Obj,fieldName)    {

    if ( Obj.value == '' || Obj.value == null || Obj.value.length == 0 )
    {
       var msg = getMessage("CAN_NOT_BE_BLANK","Common");
    msg = msg.replace('$', fieldName);
    LocalErrors = LocalErrors +msg+'<br>';
 
	return false;
    }
    else
        return true;
}
function checkForNull(fieldName)    {

      var msg = getMessage("CAN_NOT_BE_BLANK","Common");
    msg = msg.replace('$', fieldName);
    LocalErrors = LocalErrors +msg+'<br>';
 
	return false;
}
function ClearMsg() {
		parent.messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num= ';
}

function doDateCheckMst(from,to,messageFrame) {

	if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}

	if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}
	var fromarray; var toarray;
	var fromdate = from ;
	var todate = to ;
	var arr = new Array(todate,fromdate);
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				messageFrame.location.href = "../jsp/MstCodeError.jsp?err_num="+getMessage("REMARKS_MUST_GR_EQUAL","common",arr)  ;
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}

function doDateCheck(from,to,messageFrame) {
	if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}

	if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}
    var fromarray; var toarray;
    var fromdate = from ;
    var todate = to ;
	 var arr = new Array(todate,fromdate)
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;
			error=error.replace("$",getLabel("Common.to.label","Common"));
			//error=error.replace("#",getLabel("Common.from.label","Common"));
                messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
                return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    }
return true;
}

/*	Added by Kiran Kumar E on 11/25/2006
	- > To blink the text elements with BLINK tags in the form 
*/

function startBlink() {
  if (document.all)
    setInterval("doBlink()",500)
}

function doBlink() {
  var blink = document.getElementsByTagName("BLINK")
  for (var i=0; i < blink.length; i++)
    blink[i].style.visibility = blink[i].style.visibility == "" ? "hidden" : "" 
}

/*End By Kiran 11/25/2006*/
