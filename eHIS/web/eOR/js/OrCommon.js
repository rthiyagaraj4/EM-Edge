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
var title       = '';

/*function formApply(frmObj) {

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
			else if(arrObj[i].type == "select-multiple" )
			{
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
// alert(xmlStr);
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    xmlHttp.open("POST","../../eOR/jsp/OrController.jsp",false);
    xmlHttp.send(xmlDoc);
//    alert(xmlHttp.responseText );
    return xmlHttp.responseText  ;
}
*/
/*
function formApply(frmObj) {
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var arrObj = frmObj.elements;
	var xmlStr ="<root><SEARCH ";

	for(var i=0;i<arrObj.length;i++) {
		var val = "" ;
		if(arrObj[i].type == "checkbox") {
			if(arrObj[i].checked) {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		}
		else if(arrObj[i].type == "radio") {

			if(arrObj[i].checked == true) {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		}
		else if(arrObj[i].type == "select-multiple" )
		{
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

	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OrController.jsp",false);
	alert(xmlStr)
	xmlHttp.send(xmlDoc);
//	alert(xmlHttp.responseText );
	return xmlHttp.responseText ;
}

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
function SubmitLink(from, to) {
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}

function ORCallDescFrame() {
    //alert(unescape(formQueryString()));
    parent.lookup_detail.location.href = "OrCommonLookupResult.jsp?title="+ title + "&" + formQueryString();
}

async function ORCommonLookup(title, pArgumentArray) {
    var retVal = new String();
    var dialogHeight= "90vh" ;
    var dialogWidth = "700px" ;
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
    xmlHttp.open( "GET", "../../eOR/jsp/OrCommonLookupResult.jsp?title="+escape(title)+"&callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
    xmlHttp.send( xmlDoc ) ;
    responseText=xmlHttp.responseText ;

    eval(responseText) ;

    if(firstCodeVal == "")
    {
        var dialogUrl       = "../../eOR/jsp/OrCommonLookup.jsp?title="+escape(title) ;
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

function ORvaltext(comp) {
    var txt=comp.value;
    title = document.CriteriaForm.title.value;
    ORCallDescFrame(this);
}

async function showPractWindow(practID)
	{
	    //alert(practID);
        var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	    var dialogHeight    = "30" ;
	    var dialogWidth = "40" ;
	    var dialogTop	= '49';
		var dialogLeft = '60' ;
	    var arguments   = "" ;
	    var features    = "dialogHeight:" + dialogHeight +';dialogTop:'+ dialogTop + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	    var reportURL   = await window.showModalDialog( url, arguments, features ) ;
	}

function ORModify(index){
    var argArray = window.dialogArguments ;
    var displayOrder    = argArray[7] ;

    var code1=eval(document.getElementById("code"+index)).innerText;
    var code2=eval(document.getElementById("desc"+index)).innerText;
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
