/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ; 
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";

//this is used for patient ID search
function callPatientSearch(){
	//alert("callPatientSearch");
	var pat_id =  PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}
function populateLocation(){

	var formObj = document.reprint_forms_search
	var location_type = document.reprint_forms_search.source_type

		
	/*if( location_type.value == "" ) {
		clearList1("document");
		clearList2("document");
		return false;
	}*/
	var bean_id = document.reprint_forms_search.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert('in populateLocation'+location_type.value);
	xmlHttp.open( "POST", "ReprintFormsValidate.jsp?bean_id=" + bean_id + "&validate=location&location=source", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText )


}

function addLocationList1(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.reprint_forms_search.source_from.add(element);
}

function clearList1( docObj ) {
	var len = eval(docObj+".reprint_forms_search.source_from.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".reprint_forms_search.source_from.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "        ---"+getLabel("Common.defaultSelect.label","Common")+"---        " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".reprint_forms_search.source_from.add(opt)") ;
}

function addLocationList2(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.reprint_forms_search.source_to.add(element);
}

function clearList2( docObj ) {
	var len = eval(docObj+".reprint_forms_search.source_to.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".reprint_forms_search.source_to.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "        ---"+getLabel("Common.defaultSelect.label","Common")+"---        " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".reprint_forms_search.source_to.add(opt)") ;
}

function fillPrintLocation(location_type) {
	var formObj 	= document.reprint_forms_search;
	var validate 	= "";
	var bean_id 	= formObj.bean_id.value;
	if (location_type.value == "") {
		clearList3("document");
		return false;
	} else {
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr = "<root><SEARCH ";
		//alert(location_type.value);
		xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
		xmlStr +=" /></root>" ;

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert('in populateLocation'+location_type.value);
		xmlHttp.open( "POST", "ReprintFormsValidate.jsp?bean_id=" + bean_id + "&validate=location&location=print", false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText )
	}
}
function addLocationList3(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.reprint_forms_search.print_at_locn.add(element);
}

function clearList3( docObj ) {
	var len = eval(docObj+".reprint_forms_search.print_at_locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".reprint_forms_search.print_at_locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "        ---"+getLabel("Common.defaultSelect.label","Common")+"---        " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".reprint_forms_search.print_at_locn.add(opt)") ;
}

function populateOrderCategory(obj) {
	var formObj = document.reprint_forms_search;
	var validate = "";
	var bean_id = formObj.bean_id.value;
	

	if (obj.value == "") {
		clearCategoryList("document");
		clearTypeList("document");
		formObj.document.getElementById("print_locn").innerHTML = "<Select name='print_at' id='print_at' onChange='fillPrintLocation(this)'><Option value=''>---<fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/>---</Option><Option value='L'>"+getLabel('Common.Location.label','Common')+"</Option><Option value='C'>"+getLabel('Common.clinic.label','Common')+"</Option><Option value='N'>"+getLabel('Common.nursingUnit.label','Common')+"</Option></Select><Select name='print_at_locn' id='print_at_locn'><Option value=''>---<fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/>---</Option></Select><img src='../../eCommon/images/mandatory.gif' align=center></img>";
		parent.ReprintFormsHeader.location.href = "../../eCommon/html/blank.html";
		parent.ReprintFormsResult.location.href = "../../eCommon/html/blank.html";
		parent.ReprintFormsBtn.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		formObj.document.getElementById("print_at_label").innerHTML = getLabel("Common.PrintAt.label","COMMON");
		return false;
	} else {
 	if(obj.value == 'C' || obj.value=="X" || obj.value=="S"  ) {
		//formObj.document.getElementById("print_at").innerHTML			= "&nbsp;";
 		//formObj.document.getElementById("print_at_locn").innerHTML	= "&nbsp;";
		formObj.document.getElementById("print_at_label").innerHTML	= "&nbsp;";
		formObj.document.getElementById("print_locn").innerHTML	= "&nbsp;";
 	} else {
		formObj.document.getElementById("print_at_label").innerHTML = getLabel("Common.PrintAt.label","COMMON");
		if (obj.value == 'L') {
			formObj.document.getElementById("print_locn").innerHTML = "<Select name='print_at' id='print_at' onChange='fillPrintLocation(this)'><Option value=''>---"+getLabel('Common.defaultSelect.label','Common')+"  ---</Option><Option value='C'>"+getLabel('Common.clinic.label','Common')+"</Option><Option value='N'>"+getLabel('Common.nursingUnit.label','Common')+"</Option></Select><Select name='print_at_locn' id='print_at_locn'><Option value=''>---"+getLabel('Common.defaultSelect.label','Common')+"  ---</Option></Select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align=center></img>";
		}else {
			formObj.document.getElementById("print_locn").innerHTML = "<Select name='print_at' id='print_at' onChange='fillPrintLocation(this)'><Option value=''>---"+getLabel('Common.defaultSelect.label','Common')+"  ---</Option><Option value='L'>"+getLabel('Common.Location.label','Common')+"</Option><Option value='C'>"+getLabel('Common.clinic.label','Common')+"</Option><Option value='N'>"+getLabel('Common.nursingUnit.label','Common')+"</Option></Select><Select name='print_at_locn' id='print_at_locn'><Option value=''>---"+getLabel('Common.defaultSelect.label','Common')+"  ---</Option></Select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align=center></img>";
		}
	   }
	    parent.ReprintFormsHeader.location.href = "../../eCommon/html/blank.html";
		parent.ReprintFormsResult.location.href = "../../eCommon/html/blank.html";
		parent.ReprintFormsBtn.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		validate = "ord_cat";
		//var xmlDoc="";

		//var xmlHTTP = new ActiveXObject("Microsoft.XMLHTTP");
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = "<root><SEARCH " ;
		xmlStr += obj.name+"=\""+ obj.value +"\" " ;
		xmlStr += "/></root>";

		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
        //alert('in js'+obj.value+obj.name+(obj.value == ""));
		xmlHTTP.open("POST","ReprintFormsValidate.jsp?bean_id=" + bean_id + "&validate="+validate,false);
		xmlHTTP.send(xmlDoc);
		responseText = xmlHTTP.responseText;
		//alert(responseText);
		eval(responseText);
	}
}
function populateOrderType(obj)
{
	var formObj = document.reprint_forms_search

	var validate = "";
	var bean_id = formObj.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;

	//alert(obj.value);
	if( obj.value == "" ) {
		clearTypeList("document");
		return false;
	}
	xmlStr += obj.name+"=\""+ obj.value +"\" " ;
	validate = "ord_type";

	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReprintFormsValidate.jsp?bean_id=" + bean_id + "&validate="+validate, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText )
}

function addTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.reprint_forms_search.order_type.add(element);
}

function clearTypeList( docObj ) {
	var len = eval(docObj+".reprint_forms_search.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".reprint_forms_search.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "        ---"+getLabel("Common.defaultSelect.label","Common")+"---        " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".reprint_forms_search.order_type.add(opt)") ;
}
function addCategoryList(code,value,selected) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	//element.selected = selected;
	document.reprint_forms_search.ord_cat.add(element);
}

function clearCategoryList( docObj ) {
	var len = eval(docObj+".reprint_forms_search.ord_cat.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".reprint_forms_search.ord_cat.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "        ---"+getLabel("Common.defaultSelect.label","Common")+"---        " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	//opt.selected = true;
	eval(docObj+".reprint_forms_search.ord_cat.add(opt)") ;
}

//called on click of search
function populateValues(){
	//alert("populateValues");
	//var report_srl_no= document.reprint_forms_search.report_srl_no
	
	var sysDate = document.reprint_forms_search.curr_sys_date
	var fromDate = document.reprint_forms_search.date_from
	//alert('begin,'+fromDate.value+','+sysDate.value+","+parent.messageFrame);
	var toDate = document.reprint_forms_search.date_to
	var print_at_locn = "";
	if(document.reprint_forms_search.print_at_locn)
		print_at_locn     =  document.reprint_forms_search.print_at_locn.value;
	var print_at = "";
	if(document.reprint_forms_search.print_at)
		print_at		  =	document.reprint_forms_search.print_at.value;

    if(document.reprint_forms_search.report.value == ""){
    	alert(getMessage("RPT_CANNOT_BE_BLANK","OR"));
    	//alert("Report cannot be Blank");
    } else if(document.reprint_forms_search.date_from.value == ""){
    	//alert("Print At cannot be Blank");
    	alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
	} else if(print_at_locn == "" && document.reprint_forms_search.report.value!="C" && document.reprint_forms_search.report.value!="X" && document.reprint_forms_search.report.value!="S" ){
    	//alert("Print At cannot be Blank");
    	alert(getMessage("PRINT_AT_LOCN_CANNOT_BE_BLANK","OR"));
	} else{

	//if(!(doSysDateCheck(fromDate,sysDate,parent.messageFrame)))
	//	return false

	//alert('begin1');
	//if(!(doSysDateCheck(toDate,sysDate,parent.messageFrame)))
	//	return false
	
 	
	qry_string = "rep_type="+document.reprint_forms_search.report.value+"&ord_cat="+document.reprint_forms_search.ord_cat.value+"&ord_type="+document.reprint_forms_search.order_type.value+"&source_type="+document.reprint_forms_search.source_type.value+"&source_from="+document.reprint_forms_search.source_from.value+"&source_to="+document.reprint_forms_search.source_to.value+"&locntype="+print_at+"&locn="+print_at_locn+"&patientId="+document.reprint_forms_search.patientId.value+"&encntr_id="+document.reprint_forms_search.encntr_id.value+"&order_id="+document.reprint_forms_search.order_id.value+"&date_from="+document.reprint_forms_search.date_from.value+"&date_to="+document.reprint_forms_search.date_to.value
	//alert('after:'+qry_string);
	if(!isAfter(toDate.value,fromDate.value,"DMY",document.reprint_forms_search.localeName.value)){//this function is available in eCommon/js/DateUtils.js
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		parent.ReprintFormsHeader.location.href ="../../eCommon/html/blank.html";
	parent.ReprintFormsResult.location.href = "../../eCommon/html/blank.html";
	parent.ReprintFormsBtn.location.href ="../../eCommon/html/blank.html";
	parent.messageFrame.location.href = "../../eCommon/html/blank.html";
		return false ;
	}else{
	
	
	parent.ReprintFormsHeader.location.href = "../jsp/ReprintFormsHeader.jsp"
	parent.ReprintFormsResult.location.href = "../jsp/ReprintFormsResults.jsp?"+qry_string
	parent.ReprintFormsBtn.location.href = "../jsp/ReprintFormsBtn.jsp?rep_type="+document.reprint_forms_search.report.value;
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	document.reprint_forms_search.search_btn.disabled = true;
	
	
	}
	
}


async function callMenuFunctions(colval1,colval,orderId,sex,patient_id){
		var dialogHeight ='37.5' ;
		var dialogWidth = '50' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;
		
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id;
//		alert(finalString)
		var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}


function clearChecked(){
//	document.reprint_forms_search.search.disabled = false;
	parent.ReprintFormsResult.document.reprint_forms_dtl.reset();
}

function reprintForms() {
	var no_of_checked = 0;
	var formObj = parent.ReprintFormsResult.document.reprint_forms_dtl
	if (parent.ReprintFormsResult.document.reprint_forms_dtl.report_type.value != "L") {
		for(cnt=0; cnt<formObj.total_recs.value; cnt++){
			val = eval("parent.ReprintFormsResult.document.reprint_forms_dtl.chk"+cnt);

			if(val.checked == true)
				no_of_checked++;
		}

		if(parseInt(no_of_checked) == 0){
			alert(getMessage('CLICK_ANY_ONE','OR'));
			return false
		}
	}
	message = getMessage('RPT_SUBMIT_TO_PRINTER','OR');
    parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	eval(formApply( parent.ReprintFormsResult.document.reprint_forms_dtl,"../../eOR/jsp/ReprintFormsPrintValidate.jsp")) ;
	//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	//alert(message);
	/*if( result ) {
		onSuccess();
	}*/
}
function assignResult(res,msg,mod,invCode){
	result			= res ;
	message			= msg ;
	flag			= mod;
	invalidCode		= invCode ;
}
function onSuccess() {
}
function changeCheckValue(chk, index) {
	if (chk.checked == true) {
		chk.value = 'Y';
	} else {
		chk.value = 'N';
	}


	if(chk.checked == true && (document.reprint_forms_dtl.report_type.value=="C" || document.reprint_forms_dtl.report_type.value=="X" || document.reprint_forms_dtl.report_type.value=="S")) // for consent orders, referral / refusal
	{
		chk.checked				= false;
		chk.value				= "N";
 	 	var bean_id				= document.reprint_forms_dtl.bean_id.value;
 		var bean_name			= document.reprint_forms_dtl.bean_name.value;
		var order_id			= eval("document.reprint_forms_dtl.ord_id"+index+".value");
		var order_line_num		= eval("document.reprint_forms_dtl.order_line_num"+index+".value");
		var report_type			= document.reprint_forms_dtl.report_type.value;
 		var dialogHeight		= '37.5';
		var dialogWidth			= '50';
		var dialogTop			= '30';
		var dialogLeft			= '100' ;
 		var title				= ''
		var	arguments			= "";	
		var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var retVals				=  window.showModalDialog("../../eOR/jsp/ReprintPreviewFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&order_line_num="+order_line_num+"&report_type="+report_type,arguments,features);
	}
}

function callConsent(order_id, order_line_num,consent_ref_id) {

	if(document.reprint_forms_dtl.report_type.value=="C" ) // for consent orders
	{
		var bean_id				= document.reprint_forms_dtl.bean_id.value;
 		var bean_name			= document.reprint_forms_dtl.bean_name.value;
		var report_type			= document.reprint_forms_dtl.report_type.value;
		var dialogHeight		= '37.5';
		var dialogWidth			= '50';
		var dialogTop			= '30';
		var dialogLeft			= '100' ;
 		var title				= ''
		var	arguments			= "";	
		var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var retVals				=  window.showModalDialog("../../eOR/jsp/ReprintPreviewFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&order_line_num="+order_line_num+"&consent_ref_id="+consent_ref_id+"&report_type="+report_type,arguments,features);
	}
}

function reset() {
	ReprintFormsSearch.location.href = "../../eOR/jsp/ReprintFormsSearch.jsp";
	ReprintFormsHeader.location.href = "../../eCommon/html/blank.html";
	ReprintFormsResult.location.href = "../../eCommon/html/blank.html";
	ReprintFormsBtn.location.href = "../../eCommon/html/blank.html";
//	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}
function query() {
}

function callPrintClose() {
	//window.parent.close()
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	dialogTag.close();
}

function printPreview()
{
	//previewfocus = parent.document.getElementById("preview");
	parent.preview.focus(); 
	//previewfocus.focus(); 
  	parent.preview.print();
	// parent.preview.document.execCommand('print');
	//	parent.preview.print();
	
}
function chckDate(Object2,focusflag,localeName)
{
if(validDateObj(Object2,"DMY",localeName)==false)
	{
	document.reprint_forms_search.date_from.value=document.reprint_forms_search.tempfromdate.value;
		
	}
}
function checkDateRange(obj,from,fmt,localeName){

	var fromDate = eval("document."+from+".date_from")
	var toDate = eval("document."+from+".date_to")
	var localeName=localeName;
	 //  this method is from ValidateControl.js

		/*if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false

	}*/
	if(validDateObj(obj,"DMY",localeName)){
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
		}
	}else{
		document.reprint_forms_search.date_to.value=document.reprint_forms_search.curr_sys_date.value;
	}
}

