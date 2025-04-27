  //saved on 07/11/2005
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
	document.getElementById("prev").style.display='none';
	}

	if( end >= maxRec )
		document.getElementById("next").style.display='none';
	else
		document.getElementById("next").style.visibility='visible';
}


function pageUpdatebyGeneric(){
	var initString = unescape(parent.genericnameforservice_dtls.genericnameforservice_dtls.initString.value );
	var finalString="";
	var fm=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
	var tom=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

	var count=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
	if(count==tom){
	
	}else{
		tom=count;
	} 

	var count_page=1;
	
	for(var i=fm;i<tom;i++){
		var val1 = eval('parent.genericnameforservice_dtls.genericnameforservice_dtls.eff_status'+i);
		var val2 = eval('parent.genericnameforservice_dtls.genericnameforservice_dtls.process'+i);
		var val3 = eval('parent.genericnameforservice_dtls.genericnameforservice_dtls.service_code'+i);
		var val4 = eval('parent.genericnameforservice_dtls.genericnameforservice_dtls.short_desc'+i);

		if(count_page==1){
			finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
		}
		else{
			finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
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
			xmlStr += " SHORT_DESC"+i+"=\""+ checkSpl((sep_init_string[3])) + "\" ";
			xmlStr += " SERVICE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
			xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
			xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
		}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GenericNameForServiceValidationGen.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert( responseText ) ;
	return true;
	
}
function pageUpdateApply(){
	var initString = unescape(genericnameforservice_dtls.genericnameforservice_dtls.initString.value) ;
	var finalString="";
	var fm=parseInt(genericnameforservice_dtls.genericnameforservice_dtls.start.value);
	var tom=parseInt(genericnameforservice_dtls.genericnameforservice_dtls.end.value);

	var count=parseInt(genericnameforservice_dtls.genericnameforservice_dtls.count.value);
	if(count!=tom){
		tom=count;
	} 

	var count_page=1;
	
	for(var i=fm;i<tom;i++){
		var val1 = eval('genericnameforservice_dtls.genericnameforservice_dtls.eff_status'+i);
		var val2 = eval('genericnameforservice_dtls.genericnameforservice_dtls.process'+i);
		var val3 = eval('genericnameforservice_dtls.genericnameforservice_dtls.generic_id'+i);
		var val4 = eval('genericnameforservice_dtls.genericnameforservice_dtls.generic_name'+i);

		if(count_page==1){
			finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
		}
		else{
			finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
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
			xmlStr += " GENERIC_NAME"+i+"=\""+ (sep_final_string[3]) + "\" ";
			xmlStr += " GENERIC_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
			xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
			xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
		}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GenericNameForServiceValidation.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert( responseText ) ;
	return true;
	
}
function pageUpdateAssociationbyGeneric(){
	var initString = parent.genericnameforservice_dtls.genericnameforservice_dtls.initString.value ;
	var finalString="";
	var fm=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
	var tom=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

	var count=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
	if(count!=tom){
		tom=count;
	} 

	var count_page=1;
//	alert(fm);
//	alert(tom);
	for(var i=fm;i<tom;i++){
		var val1 = eval('parent.genericnameforservice_dtls.genericnameforservice_dtls.eff_status'+i);
		var val2 = eval('parent.genericnameforservice_dtls.genericnameforservice_dtls.oper_mode'+i);
		var val3 = eval('document.genericnameforservice_dtls.service_code'+i);
		var val4 = eval('document.genericnameforservice_dtls.service_desc'+i);


		if(count_page==1){
			finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
		}
		else{
			finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
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
			xmlStr += " SERVICE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
			xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
			xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
		}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GenericNameForServiceValidationAssociationGeneric.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert( responseText ) ;

	return true;
	
}

function pageUpdateAssociationApply(){
	var initString = unescape(genericnameforservice_dtls.genericnameforservice_dtls.initString.value);
	var finalString="";
	var fm=parseInt(genericnameforservice_dtls.genericnameforservice_dtls.start.value);
	var tom=parseInt(genericnameforservice_dtls.genericnameforservice_dtls.end.value);

	var count=parseInt(genericnameforservice_dtls.genericnameforservice_dtls.count.value);
	if(count!=tom){
		tom=count;
	} 

	var count_page=1;
//	alert(fm);
//	alert(tom);
	for(var i=fm;i<tom;i++){
		var val1 = eval('genericnameforservice_dtls.genericnameforservice_dtls.eff_status'+i);
		var val2 = eval('genericnameforservice_dtls.genericnameforservice_dtls.oper_mode'+i);
		var val3 = eval('genericnameforservice_dtls.genericnameforservice_dtls.generic_id'+i);
		var val4 = eval('genericnameforservice_dtls.genericnameforservice_dtls.generic_name'+i);

		if(count_page==1){
			finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
		}
		else{
			finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
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
			xmlStr += " GENERIC_NAME"+i+"=\""+ (sep_init_string[3]) + "\" ";
			xmlStr += " GENERIC_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
			xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
			xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
		}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GenericNameForServiceValidationAssociation.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert( responseText ) ;

	return true;
	
}

function goNext(source_mode) {
	start = parseInt( start + displaySize ) ;
	end = parseInt( end + displaySize ) ;
    
	var initString = unescape(document.genericnameforservice_dtls.initString.value) ;
	var finalString="";
	var count_next=1;

	var fm=parseInt(document.genericnameforservice_dtls.start.value);
	var tom=parseInt(document.genericnameforservice_dtls.end.value);

	for(var i=fm;i<tom;i++){
		var val1 = eval('document.genericnameforservice_dtls.eff_status'+i);
		
		if(source_mode=="association"){
			var val2 = eval('document.genericnameforservice_dtls.oper_mode'+i);
		}
		else if(source_mode=="select"){
			var val2 = eval('document.genericnameforservice_dtls.process'+i);
		}
	
		var val3 = eval('document.genericnameforservice_dtls.service_code'+i);
		var val4 = eval('document.genericnameforservice_dtls.service_desc'+i);

		if(count_next==1){
			finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
		}
		else{
			finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
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

		if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0]))  ){
		
		}
		else{
			
			xmlStr += " SHORT_DESC"+i+"=\""+ checkSpl((sep_init_string[3])) + "\" ";
			xmlStr += " SERVICE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
			xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
			if(source_mode=="association"){
				xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
			}
			else if(source_mode=="select"){
				xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";	
			}
		
		}
	}
	xmlStr +=" /></root>";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   	if(source_mode=="association"){
		xmlHttp.open("POST","GenericNameForServiceValidationAssociation.jsp",false);
	}
	else if(source_mode=="select"){
		xmlHttp.open("POST","GenericNameForServiceValidationGen.jsp",false);
	}
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	
	
//end validation
	if(source_mode=="association"){
		parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDetailsAssociation.jsp?dispMode=fromlink&from="+start+"&to="+end;
	}
	else if(source_mode=="select"){
		//alert("----"+parent.genericnameforservice_dtls.name);
		parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsbyGen.jsp?dispMode=fromlink&from="+start+"&to="+end;
	}
}	

function goPrev(source_mode) {
	start = parseInt( start - displaySize ) ;
	end = parseInt( end - displaySize ) ;
	//fm=parseInt(start+displaySize);
	//tom=parseInt(end+displaySize);

	//validation
	var initString = unescape(document.genericnameforservice_dtls.initString.value );
	var finalString="";
	var count_prev=1;

	var fm=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
	var tom=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

	var count=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
	if(count!=tom){
		tom=count;
	} 

	for(var i=fm;i<tom;i++){
		var val1 = eval('document.genericnameforservice_dtls.eff_status'+i);
		
		if(source_mode=="association"){
			var val2 = eval('document.genericnameforservice_dtls.oper_mode'+i);
		}
		else if(source_mode=="select"){
			var val2 = eval('document.genericnameforservice_dtls.process'+i);
		}
		
		var val3 = eval('document.genericnameforservice_dtls.service_code'+i);
		var val4 = eval('document.genericnameforservice_dtls.service_desc'+i);

		if(count_prev==1){
			finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
		}
		else{
			finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
		}
		count_prev++;
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
		if( (sep_init_string[1]) == (sep_final_string[1])  && ((sep_init_string[0]) == (sep_final_string[0]))  ){
		
		}
		else{
		
			xmlStr += " SHORT_DESC"+i+"=\""+ checkSpl((sep_init_string[3])) + "\" ";
			xmlStr += " SERVICE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
			xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
			if(source_mode=="association"){
				xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
			}
			else if(source_mode=="select"){
				xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
			}
		}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(source_mode=="association"){
		xmlHttp.open("POST","GenericNameForServiceValidationAssociation.jsp",false);
	}
	else if(source_mode=="select"){
		xmlHttp.open("POST","GenericNameForServiceValidationGen.jsp",false);
	}
	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	if(source_mode=="association"){
		parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDetailsAssociation.jsp?dispMode=fromlink&from="+start+"&to="+end;
	}
	else if(source_mode=="select"){
		parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsbyGen.jsp?dispMode=fromlink&from="+start+"&to="+end;
	}
}	


function assignValue(obj){
	if(obj.checked)
		obj.value="Y";
	else
		obj.value="N";
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
	var frmObj	=	genericnameforservice_dtls.location.href.indexOf(".jsp");
	if(frmObj!=-1){
		var formarray = new Array ( genericnameforservice_dtls.document.genericnameforservice_dtls );
		if(genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value=="select"){
			if(pageUpdateApply()){
				eval( formApply( formarray,PH_CONTROLLER) ) ;
			}
		}
		else{
			if(pageUpdateAssociationApply()){
				eval( formApply( formarray,PH_CONTROLLER) ) ;
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
	genericnameforservice_header.location.href="../../ePH/jsp/GenericNameForServiceHeader.jsp";
	genericnameforservice_button.location.href="../../eCommon/html/blank.html";
	genericnameforservice_label.location.href="../../eCommon/html/blank.html";
	genericnameforservice_dtls.location.href="../../eCommon/html/blank.html";
}

function reset() {
	var frmObj	=		genericnameforservice_header.location.href.indexOf(".jsp");
	if(frmObj !=-1){
		genericnameforservice_header.location.href="../../ePH/jsp/GenericNameForServiceHeader.jsp";
		genericnameforservice_button.location.href="../../eCommon/html/blank.html";
		genericnameforservice_label.location.href="../../eCommon/html/blank.html";
		genericnameforservice_dtls.location.href="../../eCommon/html/blank.html";
	}
}

function changeCursor(obj) {
	obj.style.cursor = "pointer" ;
}
