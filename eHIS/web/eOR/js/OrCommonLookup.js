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
    var retVal = new String();
    var dialogHeight= "80vh" ;
    var dialogWidth = "700px" ;
    var status = "no";
	
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;

	firstCodeVal = "" ;
	firstDescVal = "" ;

    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;

    if (pArgumentArray[5] != "")
    {
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "GET", "../../eOR/jsp/OrCommonLookupResult.jsp?callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
		xmlHttp.send( xmlDoc ) ;
		var responseText=xmlHttp.responseText ;
		responseText = trimString(responseText);
		//eval(responseText) ;
	}
    if(firstCodeVal == "")
    {

		var dialogUrl       = "../../eOR/jsp/OrCommonLookup.jsp?title="+title ;
		//alert(dialogUrl);
		pArgumentArray[9] = title;

		var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        
		var returnVal =await  window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);		

        if( returnVal == null || returnVal == "" )
            return "";
        else
            //return returnVal.split("\"") ;
		    return returnVal.split(",") ;
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
  //  parent.window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}

function CallDescFrame() {
	var url = "../../eOR/jsp/OrCommonLookupResult.jsp?"+formQueryString();
    parent.lookup_detail.location.href = url;
}

function formQueryString( pArgumentArray, callFrom ) {	
    var argArray;
    if(callFrom != 0)
    {
    	  var  dialogFrame=parent.parent.document.getElementById('dialog-body');
           argArray = window.parent.dialogArguments ;
      	if(argArray == undefined){
      		argArray=dialogFrame.contentWindow.dialogArguments;
      		}
    }
    else{
        argArray = pArgumentArray;
    }
    var sqlData         	= argArray[0] ;
    var dataNameArray   	= argArray[1] ;
    var dataValueArray  	= argArray[2] ;
    var dataTypeArray   	= argArray[3] ;
    var positionVal     	= argArray[4] ;

    var linkFields      	= argArray[6] ;
    var displayOrder    	= argArray[7] ;
	var fieldLegend     	= argArray[8] ;
	/* Below code is added to default the search criteria in common lookup window based on the value passed in argArray[10]
	   Pass function_id as "DefaultSearchCriteria" in argArray[11] and "S/E/C" in argArray[10] */
	
	var searchCrit			= argArray[10] ;
	var functionId			= argArray[11] ;
	
	//argArray[12]  --> RepositoryKey
	//argArray[13]  ---> RepositoryFullPath
	var repositoryKey		= "";
	var repositoryFullPath 	= "";	
	
	if(argArray[12]!=undefined && argArray[13]!=undefined){
		repositoryKey		= argArray[12];
		repositoryFullPath	= argArray[13];
	}
	
	if(fieldLegend == null) {
		fieldLegend = new Array() ;
		fieldLegend["CODE_LEGEND"] = "Code"
		fieldLegend["DESC_LEGEND"] = "Description"
	}

	//enhancement code - added to provide query result ordered by code or description based the radio button selection, only if supplied query does not have a ORDER BY clause

	//if(sqlData!="" && sqlData!=undefined){
		if(sqlData.toUpperCase().indexOf("ORDER BY")> -1){
			//add order by clause based on value of radio button
			sqlData = sqlData.substring(0,sqlData.toUpperCase().indexOf("ORDER BY"));
		}
		if(radioval=="D"){
				sqlData = sqlData.concat(" ORDER BY 2 ");
		}else{
				sqlData = sqlData.concat(" ORDER BY 1 ");
		}
	//}
	//enhancement ends
	    
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
		url += "&sc=" + document.getElementById("search_criteria").value ;
	}else
	{		
		if(functionId == "DefaultSearchCriteria"){
			url += "&sc=" + searchCrit ;
		}else{
			url += "&sc=S" ;
		}
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

		
	url += "&repositoryKey=" + repositoryKey ;
	url += "&repositoryFullPath=" + repositoryFullPath ;
	if(argArray[14]!=undefined && argArray[15]!=undefined){
		url += "&parNameArray=" + argArray[14] ;
		url += "&parValueArray=" + argArray[15] ;
	}	
	url += "&radioval=" + radioval ;	
    return url ;
}

function storeVal(currad) {
    radioval=currad.value
}

function valtext(comp) {
    var txt=comp.value;
    CallDescFrame(this);
}

function initializeText() {
	chkBothCriteria = true ;
    
    var  dialogFrame=parent.parent.document.getElementById('dialog-body');
    var argArray = window.parent.dialogArguments ;
	if(argArray == undefined){
		argArray=dialogFrame.contentWindow.dialogArguments;
	}
    document.getElementById("search_text").value = argArray[5] ;
	/*Added by Thamizh selvi on 19th Dec 2017 against ML-MMOH-CRF-0751 Start*/
	var functionId = argArray[11];
	if(functionId == "DefaultSearchCriteria")
		document.forms[0].search_criteria.value = argArray[10] ;
	/*End*/
    makeValidString( document.getElementById("search_text") ) ;
    if(argArray[5] !='' )
    {
        fromCalledPage = true
        CallDescFrame() ;
    }
}

function Modify(indx){
	
	  var  dialogFrame=parent.parent.document.getElementById('dialog-body');
	 
      var argArray = window.parent.dialogArguments ;
  	if(argArray == undefined){
  		argArray=dialogFrame.contentWindow.dialogArguments;
  	}
    var displayOrder    = argArray[7] ;
	var var1= "hd_"+indx;
	//var ret=eval(document.getElementById('var1')).value;
	var ret=eval(document.getElementById("hd_"+indx)).value;
	ret=ret.split("~");
    var code1=ret[1];
    var code2=ret[2];
    if( displayOrder == DESC_CODE ) {
        var temp = code1;
        code1 = code2;
        code2 = temp ;
    }
    var retVal = code1 + "," + code2 ;
   // top.window.returnValue = retVal ;
   let dialogBody = parent.parent.document.getElementById('dialog-body');
   dialogBody.contentWindow.returnValue = retVal;
    
    parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = retVal;
    parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
    //top.close()
}


function resetForm( formObj )
{
	formObj.reset();
	//Added by kamatchi S Alpha-CA-Specialty Lookup
	document.CriteriaForm.search_by.checked=true;
	document.CriteriaForm.search_by.value="D";
	storeVal(document.CriteriaForm.search_by);
	
	  var  dialogFrame=parent.parent.document.getElementById('dialog-body');
      var argArray = window.parent.dialogArguments ;
  	if(argArray == undefined){
  		argArray=dialogFrame.contentWindow.dialogArguments;
  	}
	
	/*Added by Thamizh selvi on 19th Dec 2017 against ML-MMOH-CRF-0751 Start*/
	var functionId = argArray[11];
	if(functionId == "DefaultSearchCriteria")
		document.forms[0].search_criteria.value = argArray[10] ;
	/*End*/
    //parent.lookup_detail.location.href = "../../eCommon/html/blank.html";
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
