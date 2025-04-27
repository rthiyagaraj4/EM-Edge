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

function CommonLookup(title, pArgumentArray) {
    var retVal = new String(); 
    var dialogHeight= "28" ;
    var dialogWidth = "43" ;
    var status = "no";

    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;

    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;

    //alert(pArgumentArray)

    firstCodeVal = "" ;
    firstDescVal = "" ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    //alert(formQueryString(pArgumentArray,0))
    xmlHttp.open( "GET", "../../eCP/jsp/GCPGenerateCarePlan1.jsp?callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
    xmlHttp.send( xmlDoc ) ;
    responseText=xmlHttp.responseText ;

    eval(responseText) ;

    if(firstCodeVal == "")
    {
        var dialogUrl       = "../../eCP/jsp/GCPGenerateCarePlan2.jsp?title="+title ;
        var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

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
    //alert(formQueryString());
    parent.lookup_detail.location.href = "../../eCP/jsp/GCPGenerateCarePlan1.jsp?" + formQueryString();
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
    var url = "sqlData="+escape(sqlData) ;
	
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

    //alert( "callFrom:" + callFrom );
    if(callFrom != 0)
    {
        if( radioval =="C" ) {
            url += "&f" + codePosition + "=" + escape( document.getElementById("search_text").value ) ;
            url += "&f" + descPosition + "=";
        } else {
            url += "&f" + codePosition + "=" ;
            url += "&f" + descPosition + "=" + escape( document.getElementById("search_text").value ) ;
        }
    }
    else
    {
        if(displayOrder == DESC_CODE)
        {
            url += "&f" + codePosition + "=" ;
            url += "&f" + descPosition + "=" + escape( argArray[5] ) ;
            //alert("descPosition:"+descPosition+argArray[5])
        }
        else
        {
            url += "&f" + codePosition + "=" + escape( argArray[5] ) ;
            url += "&f" + descPosition + "=" ;
        }
    }

    url += "&f" + codePosition + "T=String" ;
    url += "&f" + descPosition + "T=String" ;

    if(callFrom != 0)
        url += "&sc=" + escape(document.getElementById("search_criteria").options.value) ;
    else
        url += "&sc=S" ;

    url += "&displayOrder=" + displayOrder ;
    if( displayOrder == DESC_CODE ) {
        if( linkFields == CODE_LINK )
            linkFields = DESC_LINK ;
        else if ( linkFields == DESC_LINK )
            linkFields = CODE_LINK ;
    }

    url += "&linkFields=" + linkFields ;
    //alert( "urlFinal:"+url );
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
	var code3=obj.cells[2].children(0).value;//innerText;
    //var code4=obj.cells[3].innerText;

    if( displayOrder == DESC_CODE ) {
        var temp = code1;
        code1 = code2;
        code2 = temp ;
    }
    var retVal = code1 + "\"" + code2 + "\"" + code3  ;
    top.window.returnValue = retVal ;
    top.close()
}

function resetForm( formObj )
{
    formObj.reset();
    parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

}
