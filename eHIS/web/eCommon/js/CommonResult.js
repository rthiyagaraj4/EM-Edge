/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var start = 0 ;
var end   = 0 ;
var maxRec = 0  ;
var displaySize = 0 ;

function goNext() {
	document.getElementById("xmlTab").nextPage() ;
	start = parseInt( start + displaySize ) ;
	end = parseInt( end + displaySize ) ;
	changeColor() ;
}	

function goPrev() {
	document.getElementById("xmlTab").previousPage();
	start = parseInt( start - displaySize ) ;
	end = parseInt( end - displaySize ) ;
	changeColor() ;
}	

function changeColor() {
	if( start != 0 )
		document.getElementById("prev").style.visibility = "visible";
	else
		document.getElementById("prev").style.visibility = "hidden";

	if( end > maxRec )
		document.getElementById("next").style.visibility = "hidden";
	else
		document.getElementById("next").style.visibility = "visible";
}

function onReady() {
	for( i=1; i<document.getElementById("xmlTab").rows.length; i++ ) {	
		classValue=((i%2)==0)?"QRYEVEN":"QRYODD";
		for(j=0;j<document.getElementById("xmlTab").rows[i].cells.length;j++)
			document.getElementById("xmlTab").rows[i].cells[j].className=classValue ;
	}
	
	document.getElementById("xmlTab").style.visibility = "visible" ;
}

function changeCursor(obj) {
	
	//obj.style.cursor = "hand" ;
	obj.style.cursor='pointer';
}

function disableClick(evnt) {
	evnt.cancelBubble = true ;
}

function SubmitLink(from, to) {
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}
