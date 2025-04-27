/*Created by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1*/
var INT     = "Integer" ;
var LONG    = "Long"    ;
var FLOAT   = "Float"   ;
var DOUBLE  = "Double"  ;
var STRING  = "String"  ; 

var CODE_LINK       = "1"   ;
var DESC_LINK       = "2"   ;
var CODE_DESC_LINK  = "1,2,3" ;
var CODE_DESC       = "CODE_DESC" ;
var DESC_CODE       = "DESC_CODE" ;

var radioval	 = "D";
var firstCodeVal = "" ;
var firstDescVal = "" ;

async function AllergenLookup(title, pArgumentArray) {

    var retVal = new String();
    var dialogHeight = "30vh" ;
    var dialogWidth = "50vw" ;
    var status = "no";
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;

	firstCodeVal = "" ;
	firstDescVal = "" ;

    xmlStr = "<root><SEARCH " ;
    xmlStr += " /></root>" ;

    if (pArgumentArray[5] != "")
    {
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "GET", "../../eMR/jsp/AllergenLookupResult.jsp?callFrom=0&" + AllrgnformQueryString(pArgumentArray,0) , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		responseText = trimString(responseText)
		eval(responseText) ;
	}
    if(firstCodeVal == "")
    {
		var dialogUrl = "../../eMR/jsp/AllergenLookup.jsp?title="+title ;
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

function closewin() {
    parent.window.close();
}

function AllrgnCallDescFrame() {
	var url = "../../eMR/jsp/AllergenLookupResult.jsp?"+AllrgnformQueryString();
    parent.lookup_detail.location.href = url;
}

function AllrgnformQueryString( pArgumentArray, callFrom ) {
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

	if(sqlData.toUpperCase().indexOf("ORDER BY")> -1){
		sqlData = sqlData.substring(0,sqlData.toUpperCase().indexOf("ORDER BY"));
	}

	if(radioval=="D"){
			sqlData = sqlData.concat(" ORDER BY 2 ");
	}else{
			sqlData = sqlData.concat(" ORDER BY 1 ");
	}

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
			url += "&f" + codePosition + "=" + encodeURIComponent(document.getElementById("search_text").value)  ;
            url += "&f" + descPosition + "=";
        } else {
            url += "&f" + codePosition + "=" ;
            url += "&f" + descPosition + "=" + encodeURIComponent( document.getElementById("search_text").value ) ;
        }
    }
    else
    {   

        if(displayOrder == DESC_CODE)
        {
            url += "&f" + codePosition + "=" ;
			url += "&f" + descPosition + "=" +  encodeURIComponent(argArray[5]) ;
        }
        else
        {
			url += "&f" + codePosition + "=" + encodeURIComponent(argArray[5]);
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

	if(callFrom != 0)
	{
		url += "&searchType=" + document.getElementById("search_type").options.value ;
	}else
	{
		url += "&searchType=" ;
	}

    return url ;
}

function AllergenStoreVal(currad) {
    radioval=currad.value
}

function Allrgnvalidatetext(comp) {
    var txt=comp.value
    AllrgnCallDescFrame(this);
}

function initializeAllergenText() {
	chkBothCriteria = true ;
    var argArray = window.dialogArguments ;
    document.getElementById("search_text").value = argArray[5] ;
    makeValidString( document.getElementById("search_text") ) ;
    if(argArray[5] != '')
    {
        fromCalledPage = true
        AllrgnCallDescFrame() ;
    }
}

function ModifyRes(indx){
    var argArray = window.dialogArguments ;
    var displayOrder = argArray[7] ;
	var ret = eval(document.getElementById("hd_"+indx)).value;
	ret = ret.split("~");
    var code1 = ret[1];
    var code2 = ret[2];

    if( displayOrder == DESC_CODE ) {
        var temp = code1;
        code1 = code2;
        code2 = temp ;
    }

    var retVal = code1 + "\"" + code2 ;
    top.window.returnValue = retVal ;
    top.close()
}


function resetAllergenForm( formObj )
{
    formObj.reset();
	var argArray = window.dialogArguments ;
    parent.lookup_detail.location.href = "../../eCommon/html/blank.html";
}

function allow_no_chars( val ) {

	var text_val=val.value;
	if(text_val.indexOf("#") !=-1)
	{
		 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
		val.value="";
	}

}

function check_spcl_char()
{
	var text_val=document.forms[0].search_text.value;
	if(text_val.indexOf("#") !=-1)
	{
		 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
	  document.forms[0].search_text.value="";
	      parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

	}
}
