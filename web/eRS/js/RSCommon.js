var MODE_DELETE = '0' ;
var MODE_INSERT = '1' ;
var MODE_MODIFY = '2' ;
var title       = '';

function SubmitLink(from, to) {
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}

function RSCallDescFrame() {
    //alert(unescape(formQueryString()));
    parent.lookup_detail.location.href = "RSCommonLookupResult.jsp?title="+ title + "&" + formQueryString();
}

function RSCommonLookup(title, pArgumentArray) {
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
    xmlHttp.open( "GET", "../../eRS/jsp/RSCommonLookupResult.jsp?title="+escape(title)+"&callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
    xmlHttp.send( xmlDoc ) ;
    responseText=xmlHttp.responseText ;

    eval(responseText) ;

    if(firstCodeVal == "")
    {
        var dialogUrl       = "../../eRS/jsp/RSCommonLookup.jsp?title="+escape(title) ;
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

function RSvaltext(comp) {
    var txt=comp.value;
    title = document.CriteriaForm.title.value;
    RSCallDescFrame(this);
}

function showPractWindow(practID)
	{
	    //alert(practID);
        var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	    var dialogHeight    = "30" ;
	    var dialogWidth = "40" ;
	    var dialogTop	= '49';
		var dialogLeft = '60' ;
	    var arguments   = "" ;
	    var features    = "dialogHeight:" + dialogHeight +';dialogTop:'+ dialogTop + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	    var reportURL   = window.showModalDialog( url, arguments, features ) ;
	}

function RSModify(index){
    var argArray = window.dialogArguments ;
    var displayOrder    = argArray[7] ;

    var code1=eval("document.getElementById("code")"+index).innerText;
    var code2=eval("document.getElementById("desc")"+index).innerText;
    //alert('code1='+code1+',code2='+code2);

    if( displayOrder == DESC_CODE ) {
        var temp = code1;
        code1 = code2;
        code2 = temp ;
    }
    var retVal = code1 + "\"" + code2 ;
    top.window.returnValue = retVal ;
    top.close()
}
