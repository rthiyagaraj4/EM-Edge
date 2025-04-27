/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var INT     = "Integer" ;
var LONG    = "Long"    ;
var FLOAT   = "Float"   ;
var DOUBLE  = "Double"  ;
var STRING  = "String"  ;

var CODE_LINK       = "1"   ;
var DESC_LINK       = "2"   ;
var CODE_DESC_LINK  = "1,2" ;
/*
    1 - Code Link, 2 - Desc Link
*/

var CODE_DESC       = "CODE_DESC" ;
var DESC_CODE       = "DESC_CODE" ;

var radioval    = "D"         ;

var firstCodeVal = "" ;
var firstDescVal = "" ;

async function CommonLookup(title, pArgumentArray) {
	alert(formQueryString(pArgumentArray,0));
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
    xmlHttp.open( "GET", "../../eCommon/jsp/CommonLookupResult.jsp?callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
    xmlHttp.send( xmlDoc ) ;
    responseText=xmlHttp.responseText ;
	responseText = trimString(responseText)
    eval(responseText) ;
	alert(responseText);
    if(firstCodeVal == "")
    {

		var dialogUrl       = "../../eCommon/jsp/CommonLookup.jsp?title="+title ;
		//alert(dialogUrl);
		pArgumentArray[9] = title;

		var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        
		var returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);		

        if( returnVal == null || returnVal == "" )
            return "";
        else
            return returnVal.split("\"") ;
     }
     else
     {
         if(pArgumentArray[7] == CODE_DESC )
         {
            var temp = firstCodeVal
            firstCodeVal = firstDescVal
            firstDescVal = temp
         }
          returnVal = firstCodeVal + "\"" + firstDescVal

         return returnVal.split("\"") ;
     }
}

function closew() {
    parent.window.close();
}

function CallDescFrame() {

	var url = "../../eCommon/jsp/CommonLookupResult.jsp?"+formQueryString();
    parent.lookup_detail.location.href = url;
}

function formQueryString( pArgumentArray, callFrom ) {
    var argArray
    if(callFrom != 0)
        argArray = window.dialogArguments ;
    else
        argArray = pArgumentArray

    var sqlData         = argArray[0] ;
    var dataNameArray   = argArray[1] ;
    var dataValueArray  = argArray[2] ;
    var dataTypeArray   = argArray[3] ;
    var positionVal     = argArray[4] ;

    var linkFields      = argArray[6] ;
    var displayOrder    = argArray[7] ;
	var fieldLegend     = argArray[8] ;
	if(fieldLegend == null) {
		fieldLegend = new Array() ;
		fieldLegend["CODE_LEGEND"] = "Code"
		fieldLegend["DESC_LEGEND"] = "Description"
	}

	//enhancement code - added to provide query result ordered by code or description based the radio button selection, only if supplied query does not have a ORDER BY clause

	if(sqlData.toUpperCase().indexOf("ORDER BY")==-1){
		//add order by clause based on value of radio button
		if(radioval=="D"){
				sqlData = sqlData.concat(" ORDER BY 2 ");
		}else{
				sqlData = sqlData.concat(" ORDER BY 1 ");
		}
	}

	//enhancement ends
    //var url = "sqlData="+escape(sqlData) ;
	var url = "sqlData="+sqlData ;
	
    for(i = 0 ; i<dataNameArray.length ; i++) {
        if(positionVal.indexOf( toString(i) ) == -1)
        {
            url += "&f"+(i+1)+"="  +dataValueArray[i] ;
            url += "&f"+(i+1)+"T=" +dataTypeArray[i] ;
        }
    }
    var positionValArr = positionVal.split( "," ) ;

    var codePosition = parseInt( positionValArr[0] ) ;
    var descPosition = parseInt( positionValArr[1] ) ;
    if(callFrom != 0)
    {
        if( radioval =="C" ) {
            //url += "&f" + codePosition + "=" + escape( document.getElementById("search_text").value ) ;
			url += "&f" + codePosition + "=" + document.getElementById("search_text").value  ;
            url += "&f" + descPosition + "=";
        } else {
            url += "&f" + codePosition + "=" ;
            //url += "&f" + descPosition + "=" + escape( document.getElementById("search_text").value ) ;
			url += "&f" + descPosition + "=" + document.getElementById("search_text").value ;
        }
    }
    else
    {   

        if(displayOrder == DESC_CODE)
        {
            url += "&f" + codePosition + "=" ;
            //url += "&f" + descPosition + "=" + escape( argArray[5] ) ;
			url += "&f" + descPosition + "=" +  argArray[5] ;
            //alert("descPosition:"+descPosition+argArray[5])
        }
        else
        {
            //url += "&f" + codePosition + "=" + escape( argArray[5] ) ;
			url += "&f" + codePosition + "=" + argArray[5];
            url += "&f" + descPosition + "=" ;
        }
    }

    url += "&f" + codePosition + "T=String" ;
    url += "&f" + descPosition + "T=String" ;

    if(callFrom != 0)
	{
     
		url += "&sc=" + document.getElementById("search_criteria").options.value ;
	}else
	{
        url += "&sc=S" ;
	}

    url += "&displayOrder=" + displayOrder ;

    if( displayOrder == DESC_CODE ) {
        if( linkFields == CODE_LINK )
            linkFields = DESC_LINK ;
        else if ( linkFields == DESC_LINK )
            linkFields = CODE_LINK ;
    }

	url += "&code_legend="+fieldLegend["CODE_LEGEND"]+"&desc_legend="+fieldLegend["DESC_LEGEND"]

    url += "&linkFields=" + linkFields ;



    return url ;
}

function storeVal(currad) {
    radioval=currad.value
}

function valtext(comp) {
    var txt=comp.value
    CallDescFrame(this);
}

function initializeText() {
    var argArray = window.dialogArguments ;
    document.getElementById("search_text").value = argArray[5] ;
    makeValidString( document.getElementById("search_text") ) ;
    if(argArray[5] !='' )
    {
        fromCalledPage = true
        CallDescFrame() ;
    }
}

function Modify(obj){
    var argArray = window.dialogArguments ;
    var displayOrder    = argArray[7] ;

    var code1=obj.cells[0].innerText;
    var code2=obj.cells[1].innerText;

    if( displayOrder == DESC_CODE ) {
        var temp = code1;
        code1 = code2;
        code2 = temp ;
    }
    var retVal = code1 + "\"" + code2 ;
    top.window.returnValue = retVal ;
    top.close()
}

function resetForm( formObj )
{
    formObj.reset();
    parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

}

function allow_nochars( val ) {

	var text_val=val.value;
	if(text_val.indexOf("#") !=-1)
	{
		 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
		val.value="";
	}
}

function chk_spl_char()
{

		var text_val=document.forms[0].search_text.value;
	if(text_val.indexOf("#") !=-1)
	{
		 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
	  document.forms[0].search_text.value="";
	      parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

	}
}
