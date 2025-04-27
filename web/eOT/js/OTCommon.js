/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var MODE_DELETE = '0' ;
var MODE_INSERT = '1' ;
var MODE_MODIFY = '2' ;
var MESSAGE_FRAME = 'Alert' ;
var OT_CONTROLLER = "../../eOT/jsp/OTController.jsp" ;
var OT_PERSISTENCE_MANAGER = "../../eOT/jsp/ParamForFacilityValidation.jsp" ;
var OT_TAB_MANAGER = "../../eOT/jsp/ObjectCollector.jsp" ;

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
    xmlHttp.send(xmlDoc);
    return xmlHttp.responseText  ;
}


function beforePost(xmlStr){}

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
    return result ;
}
function enable_all(fields){
	for( var i=0; i<fields.length; i++ ) {
		fields[i].disabled=false;
	}
}

function compareDates(fromdate,todate,locale,format) {
	var fromarray; var toarray;
	var fromdate = dateUtils(fromdate,locale,format); 
	var todate = dateUtils(todate,locale,format); 
	if(fromdate.length > 0 && todate.length > 0 ) {
		var from_date_array = fromdate.split(" ");
		var from_date = from_date_array[0];
		var from_time = from_date_array[1];
		var to_date_array = todate.split(" ");
		var to_date = to_date_array[0];
		var to_time = to_date_array[1];
		var fromdatearray = from_date.split("/");
		var todatearray = to_date.split("/");
		var fromtimearray = from_time.split(":");
		var totimearray = to_time.split(":");
		//added against 61689
		var fromdt = new Date(fromdatearray[2],fromdatearray[1]-1,fromdatearray[0],fromtimearray[0],fromtimearray[1]);
		var todt = new Date(todatearray[2],todatearray[1]-1,todatearray[0],totimearray[0],totimearray[1]);
		//added against 61689
	if(Date.parse(todt) < Date.parse(fromdt)) {
		return false;
	}
    }
	return true;
}


function dateUtils(date,locale,format){
		format=(format!=null)?format:"DMY";
		return (locale=="en")?date:trimString(convertDate(date,format,locale,"en"));
	}


function trimString(sInString){
   return sInString.replace(/^\s+|\s+$/g,"");
 }

function OTCommonLookUp(param) {
	/*var param = param;
	var pArgumentArray = new Array[];
	pArgumentArray[0] = param;
    var retVal = new String();
    var dialogHeight= "38" ;
    var dialogWidth = "65" ;
    var status = "no";
	//var fin_Val=pArgumentArray.split(",");
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;

    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;

    firstCodeVal = "" ;
    firstDescVal = "" ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open( "GET", "../../eCommon/jsp/OTGeneralSearchResults.jsp?callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
    xmlHttp.send( xmlDoc ) ;
    responseText=xmlHttp.responseText ;
	responseText = trimString(responseText)
    eval(responseText) ;

	if(responseText!=null)
		{
		var resText = responseText.split("::");
		var argArr = pArgumentArray[0].split("&");
		var length = argArr.length;
		argArr[length] = resText[0];
		}
	else{
		callDialog(param);
	
	}	*/

}

//PMG-KDAH-CRF-0001
function isOTAvailable(check_in_date_time,oper_room_code,facility_id,oper_num,called_from){

	  var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=isOTAvailable&oper_room_code="+oper_room_code+"&check_in_date_time="+check_in_date_time+"&facility_id="+facility_id+"&oper_num="+oper_num+"&called_from="+called_from,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);

		return retVal;
	  
}
//PMG-KDAH-CRF-0001
function localTrimString(sInString) {
	  sInString = sInString.replace( /^\s+/g, "" );// strip leading space
	  //return sInString.replace( /\s+$/g, "" );// strip trailing space
	  return sInString.replace(/^\s+|\s+$/g,"");
	}
