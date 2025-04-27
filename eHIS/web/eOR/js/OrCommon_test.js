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

function formApply(frmObj) {
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var arrObj = frmObj.elements;
	var xmlStr ="<root><SEARCH ";

	for(var i=0;i<arrObj.length;i++) {
		var val = "" ;
		if(arrObj[i].type == "checkbox") {
			if(arrObj[i].checked)
				val = arrObj[i].value;
		}
		else if(arrObj[i].type == "radio") {
			if(arrObj[i].checked)
				val = arrObj[i].value;
		}
		else if(arrObj[i].type == "select-multiple" )
		{
			for(var j=0; j<arrObj[i].options.length; j++)
			{
				if(arrObj[i].options[j].selected)
					val+=arrObj[i].options[j].value +"~"
			}
			val= val.substring(0,val.lastIndexOf('~'))
		}
		else{
			val = arrObj[i].value;

		val = checkSpl( val ) ;

		xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
	}
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST","OrController_test.jsp",false);
//	alert(xmlStr)
	xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText );
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
