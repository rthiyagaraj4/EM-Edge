/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
 var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var start = 0 ;
var end   = 0 ;
var maxRec = 0  ;
var displaySize = 0 ;
var firstTime	= true;


function activeLink() {
	
	if( start != 0 ){
		document.getElementById("prev").style.visibility='visible';
	}
	else{
	document.getElementById("prev").style.visibility='hidden';
	}

	if( end >= maxRec )
		document.getElementById("next").style.visibility='hidden';
	else
		document.getElementById("next").style.visibility='visible';
}
//Added By Sakti Sankar
//function enableqty(obj,i){
function enableqty(i){
	var formObject = document.groupforstore_dtls;
	if(document.getElementById("qty_"+i) != undefined){
		var es = eval("formObject.eff_status"+i);
		var ps = eval("formObject.process"+i);
		if(es.checked && ps.checked){
			document.getElementById("qty_"+i).style.visibility='visible';
			document.getElementById("reorder_qty_"+i).style.visibility='visible';
			
		}else{
			document.getElementById("qty_"+i).style.visibility='hidden';
			var min_qty = eval("formObject.min_qty"+i);
			min_qty.value="";
			document.getElementById("reorder_qty_"+i).style.visibility='hidden';
			var reorder_qty = eval("formObject.reorder_qty"+i);
			reorder_qty.value="";
		}
	}
}

//Added ends





function pageUpdatebyGeneric(){
	var initString = unescape(parent.groupforstore_dtls.groupforstore_dtls.initString.value );
	var finalString="";
	var fm=parseInt(parent.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(parent.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(parent.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 

	var count_page=1;
	
	for(var i=fm;i<tom;i++){
	var val1 = eval('parent.groupforstore_dtls.groupforstore_dtls.eff_status'+i);
	var val2 = eval('parent.groupforstore_dtls.groupforstore_dtls.process'+i);
	var val3 = eval('parent.groupforstore_dtls.groupforstore_dtls.store_code'+i);
	var val4 = eval('parent.groupforstore_dtls.groupforstore_dtls.short_desc'+i);
	var val5 = eval('parent.groupforstore_dtls.groupforstore_dtls.min_qty'+i);
	var val6 = eval('parent.groupforstore_dtls.groupforstore_dtls.reorder_qty'+i);

	if(count_page==1){
	finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	else{
	finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	count_page++;
	}
		
	var init_string=new Array();
	var final_string=new Array();
	
	init_string=initString.split("~");
	final_string=finalString.split("~");
	var xmlStr ="<root><SEARCH ";
	
	for(var i=0;i<init_string.length;i++){
	var sep_init_string=new Array();
	var sep_final_string=new Array();
	sep_init_string=init_string[i].split("|");
	sep_final_string=final_string[i].split("|");
	if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0]))  ){
	
	}
	else{
		//alert((sep_init_string[4]));
	xmlStr += " SHORT_DESC"+i+"=\""+ checkSpl((sep_init_string[3])) + "\" ";
	xmlStr += " STORE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
	xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
	xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
	xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";
	xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";
	}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GroupForStoreValidationGroup.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert( responseText ) ;
	return true;
	
}
function pageUpdateApply(){
	var initString = unescape(groupforstore_dtls.groupforstore_dtls.initString.value) ;
	var finalString="";
	var fm=parseInt(groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 

	var count_page=1;
	
	for(var i=fm;i<tom;i++){
	var val1 = eval('groupforstore_dtls.groupforstore_dtls.eff_status'+i);
	var val2 = eval('groupforstore_dtls.groupforstore_dtls.process'+i);
	var val3 = eval('groupforstore_dtls.groupforstore_dtls.group_id'+i);
	var val4 = eval('groupforstore_dtls.groupforstore_dtls.group_name'+i);
	var val5 = eval('groupforstore_dtls.groupforstore_dtls.min_qty'+i);
	var val6 = eval('groupforstore_dtls.groupforstore_dtls.reorder_qty'+i);
	//alert(val4.value);

	if(count_page==1){
	finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	else{
	finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	count_page++;
	}
		
	var init_string=new Array();
	var final_string=new Array();
	
	init_string=initString.split("~");
	final_string=finalString.split("~");
	var xmlStr ="<root><SEARCH ";
	
	for(var i=0;i<init_string.length;i++){
	var sep_init_string=new Array();
	var sep_final_string=new Array();
	sep_init_string=init_string[i].split("|");
	sep_final_string=final_string[i].split("|");
	if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0]))  ){
	
	}
	else{
	//	alert((sep_init_string[3]));
	xmlStr += " GROUP_NAME"+i+"=\""+ (sep_final_string[3]) + "\" ";
	xmlStr += " GROUP_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
	xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
	xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
	xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";
	xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";
	}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GroupForStoreValidation.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert( responseText ) ;
	return true;
	
}
function pageUpdateAssociationbyGeneric(){
		var initString = parent.groupforstore_dtls.groupforstore_dtls.initString.value ;
	var finalString="";
	var fm=parseInt(parent.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(parent.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(parent.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 

	var count_page=1;
//	alert(fm);
//	alert(tom);
	for(var i=fm;i<tom;i++){
	var val1 = eval('parent.groupforstore_dtls.groupforstore_dtls.eff_status'+i);
	var val2 = eval('parent.groupforstore_dtls.groupforstore_dtls.oper_mode'+i);
	var val3 = eval('document.groupforstore_dtls.store_code'+i);
	var val4 = eval('document.groupforstore_dtls.store_desc'+i);
	var val5 = eval('document.groupforstore_dtls.min_qty'+i);
	var val6 = eval('document.groupforstore_dtls.reorder_qty'+i);

	if(count_page==1){
	finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	else{
	finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	count_page++;
	}
		//alert(finalString);
		//alert(initString);

	var init_string=new Array();
	var final_string=new Array();
	
	init_string=initString.split("~");
	final_string=finalString.split("~");
	var xmlStr ="<root><SEARCH ";
	
	for(var i=0;i<init_string.length;i++){
	var sep_init_string=new Array();
	var sep_final_string=new Array();
	sep_init_string=init_string[i].split("|");
	sep_final_string=final_string[i].split("|");
	if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0]))  ){
	
	}
	else{	
	xmlStr += " SHORT_DESC"+i+"=\""+ checkSpl((sep_final_string[3])) + "\" ";
	xmlStr += " STORE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
	xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
	xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
	xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";
	xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";
	}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GroupForStoreValidationAssociationGroup.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert( responseText ) ;

	return true;
	
}
function pageUpdateAssociationApply(){
	var initString = unescape(groupforstore_dtls.groupforstore_dtls.initString.value);
	var finalString="";
	var fm=parseInt(groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 

	var count_page=1;
//	alert(fm);
//	alert(tom);
	for(var i=fm;i<tom;i++){
	var val1 = eval('groupforstore_dtls.groupforstore_dtls.eff_status'+i);
	var val2 = eval('groupforstore_dtls.groupforstore_dtls.oper_mode'+i);
	var val3 = eval('groupforstore_dtls.groupforstore_dtls.group_id'+i);
	var val4 = eval('groupforstore_dtls.groupforstore_dtls.group_name'+i);
	var val5 = eval('groupforstore_dtls.groupforstore_dtls.min_qty'+i);
	var val6 = eval('groupforstore_dtls.groupforstore_dtls.reorder_qty'+i);
	
	if(count_page==1){
	finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	else{
	finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	count_page++;
	}
		//alert(finalString);
		//alert(initString);

	var init_string=new Array();
	var final_string=new Array();
	
	init_string=initString.split("~");
	final_string=finalString.split("~");
	var xmlStr ="<root><SEARCH ";
	
	for(var i=0;i<init_string.length;i++){
	var sep_init_string=new Array();
	var sep_final_string=new Array();
	sep_init_string=init_string[i].split("|");
	sep_final_string=final_string[i].split("|");
	if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0])) ){
	
	}
	else{
	xmlStr += " GROUP_NAME"+i+"=\""+ (sep_init_string[3]) + "\" ";
	xmlStr += " GROUP_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
	xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
	xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
	xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";
	xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";
	}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GroupForStoreValidationAssociation.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert( responseText ) ;

	return true;
	
}




function goNext(source_mode) {

	start = parseInt( start + displaySize ) ;
	end = parseInt( end + displaySize ) ;


//validation
	var initString = unescape(document.groupforstore_dtls.initString.value) ;
	var finalString="";
	var count_next=1;

	//fm=start-displaySize;
	//tom=end-displaySize;
	

	var fm=parseInt(document.groupforstore_dtls.start.value);
	var tom=parseInt(document.groupforstore_dtls.end.value);
	

	for(var i=fm;i<tom;i++){
	var val1 = eval('document.groupforstore_dtls.eff_status'+i);
	
	if(source_mode=="association"){
	var val2 = eval('document.groupforstore_dtls.oper_mode'+i);
	}
	else if(source_mode=="select"){
	var val2 = eval('document.groupforstore_dtls.process'+i);
	}
	
	
	var val3 = eval('document.groupforstore_dtls.store_code'+i);
	var val4 = eval('document.groupforstore_dtls.store_desc'+i);
	var val5 = eval('document.groupforstore_dtls.min_qty'+i);
	var val6 = eval('document.groupforstore_dtls.reorder_qty'+i);

	if(count_next==1){
	finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	else{
	finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	count_next++;
	}

	var init_string=new Array();
	var final_string=new Array();
	
	init_string=initString.split("~");
	final_string=finalString.split("~");
	var xmlStr ="<root><SEARCH ";
	
	for(var i=0;i<parseInt((init_string.length));i++){
		
	var sep_init_string=new Array();
	var sep_final_string=new Array();
	sep_init_string=init_string[i].split("|");
	sep_final_string=final_string[i].split("|");

	

	if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0])) && ((sep_init_string[4]) == (sep_final_string[4])) && ((sep_init_string[5]) == (sep_final_string[5]))  ){
	
	}
	else{
		
	xmlStr += " SHORT_DESC"+i+"=\""+ checkSpl((sep_init_string[3])) + "\" ";
	xmlStr += " STORE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
	xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
	if(source_mode=="association"){
	xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
	}
	else if(source_mode=="select"){
	xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";	
	}
	xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";	
	xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";	
	
	}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	if(source_mode=="association"){
		xmlHttp.open("POST","GroupForStoreValidationAssociation.jsp",false);
	}else if(source_mode=="select"){
	xmlHttp.open("POST","GroupForStoreValidationGroup.jsp",false);
	}
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	
	
//end validation
if(source_mode=="association"){
parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociation.jsp?dispMode=fromlink&from="+start+"&to="+end;
}
else if(source_mode=="select"){
parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsbyGroup.jsp?dispMode=fromlink&from="+start+"&to="+end;
}
}	

function goPrev(source_mode) {
	start = parseInt( start - displaySize ) ;
	end = parseInt( end - displaySize ) ;
	//fm=parseInt(start+displaySize);
	//tom=parseInt(end+displaySize);

	//validation
	var initString = unescape(document.groupforstore_dtls.initString.value );
	var finalString="";
	var count_prev=1;

	var fm=parseInt(parent.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(parent.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(parent.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 

	

	for(var i=fm;i<tom;i++){
	var val1 = eval('document.groupforstore_dtls.eff_status'+i);
	
	if(source_mode=="association"){
	var val2 = eval('document.groupforstore_dtls.oper_mode'+i);
	}
	else if(source_mode=="select"){
	var val2 = eval('document.groupforstore_dtls.process'+i);
	}
	
	
	var val3 = eval('document.groupforstore_dtls.store_code'+i);
	var val4 = eval('document.groupforstore_dtls.store_desc'+i);
	var val5 = eval('document.groupforstore_dtls.min_qty'+i);
	var val6 = eval('document.groupforstore_dtls.reorder_qty'+i);

	if(count_prev==1){
	finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	else{
	finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	count_prev++;
	}

	//alert(initString);
	//alert(finalString);

	var init_string=new Array();
	var final_string=new Array();
	
	init_string=initString.split("~");
	final_string=finalString.split("~");
	var xmlStr ="<root><SEARCH ";
	
	for(var i=0;i<init_string.length;i++){
	var sep_init_string=new Array();
	var sep_final_string=new Array();
	sep_init_string=init_string[i].split("|");
	sep_final_string=final_string[i].split("|");
	if( (sep_init_string[1]) == (sep_final_string[1])  && ((sep_init_string[0]) == (sep_final_string[0])) && ((sep_init_string[4]) == (sep_final_string[4])) && ((sep_init_string[5]) == (sep_final_string[5])) ){
	
	}
	else{
	
	xmlStr += " SHORT_DESC"+i+"=\""+ checkSpl((sep_init_string[3])) + "\" ";
	xmlStr += " STORE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
	xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
	if(source_mode=="association"){
	xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
	}
	else if(source_mode=="select"){
	xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
	}
	xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";
	xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";
	}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(source_mode=="association"){
		xmlHttp.open("POST","GroupForStoreValidationAssociation.jsp",false);
	}else if(source_mode=="select"){
	xmlHttp.open("POST","GroupForStoreValidationGroup.jsp",false);
	}
	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	
	
//end validation
	if(source_mode=="association"){
		parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociation.jsp?dispMode=fromlink&from="+start+"&to="+end;
			}
			else if(source_mode=="select"){
			parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsbyGroup.jsp?dispMode=fromlink&from="+start+"&to="+end;
			}
}	


function assignValue(obj){
if(obj.checked)
	obj.value="Y";
else
	obj.value="N";

//alert(obj.checked);
}

function assignEffStatus(obj){
if(obj.checked)
	obj.value="E";
else
	obj.value="D";
}


function assignValueAssociation(obj){
if(obj.checked)
	obj.value="I";
else
	obj.value="DN";
}

function assignEffStatusAssociation(obj){
if(obj.checked)
	obj.value="E";
else
	obj.value="D";
}


function apply() {

var frmObj	=	groupforstore_dtls.location.href.indexOf(".jsp");
//alert(frmObj);
if(frmObj!=-1){
	var formarray = new Array ( groupforstore_dtls.document.groupforstore_dtls );
	//alert(groupforstore_dtls.groupforstore_dtls.choosen_link.value);
	if(groupforstore_dtls.groupforstore_dtls.choosen_link.value=="select"){
			if(pageUpdateApply()){
				//alert(formApply( formarray));
				eval( formApply( formarray,SS_CONTROLLER) ) ;
			}
		}
		else{
			if(pageUpdateAssociationApply()){
				eval( formApply( formarray,SS_CONTROLLER) ) ;
			}
		}
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result ) {
			onSuccess();
		}


}
else{
messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
}
function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function onSuccess() {
	groupforstore_header.location.href="../../eSS/jsp/groupforstoreHeader.jsp";
	groupforstore_button.location.href="../../eCommon/html/blank.html";
	groupforstore_label.location.href="../../eCommon/html/blank.html";
	groupforstore_dtls.location.href="../../eCommon/html/blank.html";
}

function reset() {
var frmObj	=		groupforstore_header.location.href.indexOf(".jsp");
if(frmObj !=-1){
groupforstore_header.location.href="../../eSS/jsp/groupforstoreHeader.jsp";
groupforstore_button.location.href="../../eCommon/html/blank.html";
groupforstore_label.location.href="../../eCommon/html/blank.html";
groupforstore_dtls.location.href="../../eCommon/html/blank.html";
}


}
function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function disasbleToolTipDataChange( classValue ){
    if( classValue == "DATACHANGE" )
        document.getElementById("tooltiplayer").style.visibility = "hidden" ;
}

function displayToolTipDataChange(classValue,text)
{

    if(classValue=="DATACHANGE"){
    buildTableDataChange(text);
    bodwidth  = parent.parent.frames[1].document.body.offsetWidth
    bodheight = parent.parent.frames[1].document.body.offsetHeight
    var x     = event.x
    var y     = event.y;
    x     = x + (document.getElementById("tooltiplayer").offsetWidth)
    y     = y + (document.getElementById("tooltiplayer").offsetHeight)

    if(x<bodwidth)
        x = event.x
    else
        x = x - (document.getElementById("tooltiplayer").offsetWidth*2)
    if(y<bodheight)
        y = event.y
    else
        y = y - (document.getElementById("tooltiplayer").offsetHeight*2)

    y+=document.body.scrollTop
    x+=document.body.scrollLeft
    document.getElementById("tooltiplayer").style.posLeft= x
    document.getElementById("tooltiplayer").style.posTop = y
    document.getElementById("tooltiplayer").style.visibility='visible';
    }else{

    document.getElementById("tooltiplayer").style.visibility='hidden';
    }
}

function buildTableDataChange(text)
{

        var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
        tab_dat     += "<tr>";
        tab_dat     += "<td align='right'  style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow' nowrap  >"+text+"</td>";
        tab_dat     += "</tr>";
        tab_dat     += "</table>";

    document.getElementById("t").innerHTML = tab_dat;

}
function validate_reorder_qty(i){
	
	var formObject = document.groupforstore_dtls;
	var min_qty = eval("formObject.min_qty"+i+".value");
	var reorder_qty = eval("formObject.reorder_qty"+i+".value");
	//if(parseInt(min_qty) >= parseInt(reorder_qty)){
	if(parseFloat(min_qty) >= parseFloat(reorder_qty)){
		alert(getMessage("REORDER_QTY_GR_REORDER_LEVEL","SS"));
		eval("formObject.reorder_qty"+i).value = "";
		eval("formObject.reorder_qty"+i).focus();
	}
	
}
