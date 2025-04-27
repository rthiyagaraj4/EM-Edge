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
var invalidCode = "";

function callResultEntry(index){
		
		var dialogHeight ='45vh' ;
		var dialogWidth = '60vw' ;
		var dialogTop	= '0';
		var dialogLeft = '0' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		var report_srl_no = eval("document.getElementById('report_srl_no"+index+"')"+".value");
		var orderId		  = eval("document.getElementById('order_id" + index +"')"+".value");
		var order_line_num		  = eval("document.getElementById('order_line_num" + index +"')"+".value");
		var patient_class		  = eval("document.getElementById('patient_class" +index +"')"+".value");
		var sex		  = eval("document.getElementById('sex"+index+"')"+".value");
		var dob		  = eval("document.getElementById('dob"+index+"')"+".value");
		var order_category = document.getElementById('order_category').value;
		var header_values = document.getElementById('header_values').value;
		var qry_str = document.getElementById('qry_str').value;
		var patient_id	= eval("document.getElementById('patient_id"+index+"')"+".value");
		//var finalString	= "orderId="+ orderId + "&report_srl_no="+report_srl_no + "&requestFrom=RA";
		var finalString	= "order_category="+order_category+"&orderId="+ orderId + "&report_srl_no="+report_srl_no + "&requestFrom=RA"+"&patient_id="+patient_id+"&patient_class="+patient_class+"&header_values="+header_values+"&qry_str="+qry_str+"&order_line_num="+order_line_num+"&sex="+sex+"&dob="+dob;
		

		//var retVals = window.showModalDialog("../../eOR/jsp/ResultEntry.jsp?"+finalString,arguments,features);
		//var ReportAuthURL = top.content.workAreaFrame.location.href;

		top.content.workAreaFrame.location.href="ResultEntry.jsp?"+finalString+"&"+arguments+"&"+features;

		//if(retVals != ""){
		//document.location.href="ReportAuthorizationQueryResult.jsp?"+document.getElementById("qry_str").value
		//}


}
function query() {
	f_query_add_mod.location.href='../../eOR/jsp/ReportAuthorizationFrame.jsp?function_id='+function_id ;
}

function setLocationLabel(location_type)
{
	if(location_type.value == "C"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.clinic.label","Common")
	} else 	if(location_type.value == "W"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.nursingUnit.label","Common")
	} else {
		document.getElementById("id_locn").innerHTML = getLabel("Common.Location.label","Common")
	}
}
function clearActivityTypeList( docObj ) {
	document.report_authorization_search.activity_type.value="";
	document.report_authorization_search.activity_type_desc.value="";
}
function populateLocnActivityType(){
	
	var formObj = document.report_authorization_search;
	//var validate = "";var flag;
	var bean_id = formObj.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//validate = "activity_type";
	xmlHttp.open( "POST", "ReportAuthorizationValidate.jsp?bean_id="+bean_id+"&order_category="+formObj.locn.value+"&order_type="+formObj.order_type.value+"&validate=activity_type&flag=true", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );

}
function addActivityList(code,value) {
	
}

function populateLocation(location_type)
{
	setLocationLabel(location_type);
	var formObj = document.report_authorization_search;
	if( location_type.value == "" ) {
		clearList("document");
	}
	var bean_id = formObj.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReportAuthorizationValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=location", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

function addLocationList(code,value,selected) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	element.selected = selected;
	document.report_authorization_search.locn.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".report_authorization_search.locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".report_authorization_search.locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "    ---"+getLabel("Common.defaultSelect.label","Common")+"---    " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".report_authorization_search.locn.add(opt)") ;
}

//this fucntion is used to clear the entries of search criteria
function resetValues(){
}


//this is used for patient ID search
//function callPatientSearch(){
//	var pat_id =  PatientSearch();
//
//	if(pat_id != null)
//	document.getElementById("patient_id").value = pat_id;
//}
async function callPatientSearch(){
	var pat_id = await PatientSearch();
  	if(pat_id != null) {
		if(pat_id.charAt(0)=="Y")
			pat_id =pat_id.substring(1,pat_id.length)
			document.getElementById("patient_id").value = pat_id;
	}
}

function loadSource(){
	var len = eval(document.report_authorization_search.locn.options.length) ;
	var header_locn = document.report_authorization_search.header_locn.value ;
	for(var i=0;i<len;i++)
	{
		if(eval(document.report_authorization_search.locn.options[i]).value == header_locn) 			eval(document.report_authorization_search.locn.options[i]).selected = "selected";
	}
	
}

function loadMainScreenData()
{
	var formObj = document.report_authorization_search;
	var CancelFlag = formObj.CancelFlag.value;
	if(CancelFlag=='Y')
	{
	formObj.CancelFlag.value="";
	var header_location_type = formObj.header_location_type.value;
	var header_locn = formObj.header_locn.value;
	var header_priority = formObj.header_priority.value;
	var header_order_type = formObj.header_order_type.value;
	var header_activity_type = formObj.header_activity_type.value;
	var header_date_from = formObj.header_date_from.value;
	var header_date_to = formObj.header_date_to.value;
	var header_patient_id = formObj.header_patient_id.value;
	var header_order_id = formObj.header_order_id.value;
	var header_encounter_id = formObj.header_encounter_id.value;
	//var pract_type_is_NS = formObj.pract_type_is_NS.value;

	if(header_location_type!=null && header_location_type!="")
	{
		formObj.location_type.value = header_location_type;
		
	}
	//if(pract_type_is_NS)
	//populateLocation(formObj.location_type.value);
	

	if(header_date_from!=null && header_date_from!="")
	{
		formObj.date_from.value = header_date_from;
	}

	if(header_date_to!=null && header_date_to!="")
	{
		formObj.date_to.value = header_date_to;
	}

	if(header_priority!=null && header_priority!="")
	{
		formObj.priority.value = header_priority;
	}

	if(header_locn!=null && header_locn!="")
	{
		
		loadSource();
		formObj.order_category.value = header_locn;
		populateLocnOrdType('locn');
		if(header_order_type!=null && header_order_type!=" ")
		{
			formObj.order_type.value = header_order_type;
			if(header_activity_type!=null && header_activity_type!=" ")
			{
			formObj.activity_type.value = header_activity_type;
			}
		}
		else 
		{
			formObj.order_type.selectedIndex = 0;
			formObj.activity_type.selectedIndex = 0;
		}

	}

	if(header_patient_id!=null && header_patient_id!="")
	{
		formObj.patient_id.value = header_patient_id;
	}

	if(header_order_id!=null && header_order_id!="")
	{
		formObj.order_id.value = header_order_id;
	}

	if(header_encounter_id!=null && header_encounter_id!="")
	{
		formObj.encounter_id.value = header_encounter_id;
	}
		populateValues();
	}
}

//called on click of search
function populateValues(){

	var headerObj = document.report_authorization_search;
	var location_type = headerObj.location_type.value;
	var locn = headerObj.locn.value;
	var priority = headerObj.priority.value;
	var order_type = headerObj.order_type.value;
	var activity_type = headerObj.activity_type.value;
	var date_from = headerObj.date_from.value;
	var date_to = headerObj.date_to.value;
	var patient_id = headerObj.patient_id.value;
	var order_id = headerObj.order_id.value;
	var encounter_id = headerObj.encounter_id.value;
	

	var header_values="~~~";
	if(location_type==null || location_type=="")
		header_values += " " + "~~~";
	else
		header_values += location_type + "~~~";

	if(locn==null || locn=="")
		header_values += " " + "~~~";
	else
		header_values += locn + "~~~";

	if(priority==null || priority=="")
		header_values += " " + "~~~";
	else
		header_values += priority + "~~~";

	if(order_type==null || order_type=="")
		header_values += " " + "~~~";
	else
		header_values += order_type + "~~~";

	if(activity_type==null || activity_type=="")
		header_values += " " + "~~~";
	else
		header_values += activity_type + "~~~";

	if(date_from==null || date_from=="")
		header_values += " " + "~~~";
	else
		header_values += date_from + "~~~";

	if(date_to==null || date_to=="")
		header_values += " " + "~~~";
	else
		header_values += date_to + "~~~";

	if(patient_id==null || patient_id=="")
		header_values += " " + "~~~";
	else
		header_values += patient_id + "~~~";

	if(order_id==null || order_id=="")
		header_values += " " + "~~~";
	else
		header_values += order_id + "~~~";

	if(encounter_id==null || encounter_id=="")
		header_values += " " + "~~~";
	else
		header_values += encounter_id + "~~~";


	top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	var formObj = document.report_authorization_search;
	var sysDate = formObj.curr_sys_date
	var fromDate = formObj.date_from
	var toDate = formObj.date_to
	var localeName=formObj.localeName.value
	//order_category
	if(formObj.order_category.value == ""){
    	alert(getMessage("ORDER_CATEGORY","OR"));
    } 
	else 
	{
		if(!(doSysDateCheck(fromDate,sysDate,top.content.messageFrame)))
			return false
		if(!(doSysDateCheck(toDate,sysDate,top.content.messageFrame)))
			return false

			if(!isAfter(toDate.value,fromDate.value,"DMYHM",localeName)){//this function is available in eCommon/js/DateUtils.js
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			//parent.ReportAuthorizationHeader.location.href = "../../eCommon/html/blank.html"
			parent.ReportAuthorizationResult.location.href = "../../eCommon/html/blank.html"
			parent.ReportAuthorizationBtn.location.href = "../../eCommon/html/blank.html"
			return false ;
		}

		/*if(!checkDate1(toDate)){
			parent.ReportAuthorizationHeader.location.href = "../../eCommon/html/blank.html"
			parent.ReportAuthorizationResult.location.href = "../../eCommon/html/blank.html"
			return false ;
		}*/

	qry_string = "location_type="+formObj.location_type.value+"&location="+formObj.locn.value+"&order_category="+formObj.order_category.value+"&single_multi="+formObj.single_multi.value+"&priority="+formObj.priority.value+"&date_from="+formObj.date_from.value+"&date_to="+formObj.date_to.value+"&patient_id="+formObj.patient_id.value+"&order_id="+formObj.order_id.value+"&encounter_id="+formObj.encounter_id.value+"&patient_id_found="+formObj.patient_id_found.value+"&activity_type="+formObj.activity_type.value+"&filter="+formObj.filter_name.value;//Modified by Uma on  2/17/2010 for IN016226 to pass the filter parameter*/
		//if(formObj.practitioner_type.value!=('NS'))
			qry_string = qry_string+"&order_type="+formObj.order_type.value

		if (document.report_authorization_search.performing_location_code) {
			qry_string += "&performing_location_code="+document.report_authorization_search.performing_location_code.value;
		} else {
			qry_string += "&peforming_location_code=";
		}
		

		/*
			Added by kishore kumar N on 02-05-2010,
			Validating date for better tuning.
		*/

		var ptID = formObj.patient_id.value;
		var encounterID = formObj.encounter_id.value;
		var orderID = formObj.order_id.value;
		var locale = formObj.localeName.value;

		if((ptID == '' && orderID == '' && encounterID == '') && 
			!dateRangeValidation(fromDate, toDate, locale, '7', 'DMYHM'))
		{
			parent.ReportAuthorizationResult.location.href = "../../eCommon/html/blank.html";
			parent.ReportAuthorizationBtn.location.href = "../../eCommon/html/blank.html";
			alert(getMessage("VALIDATE_DATE_ON_SEARCH_WITH_ENC_ORDER", "OR"));
		}
		else
		{
			document.report_authorization_search.search_btn.disabled=true;
			//parent.ReportAuthorizationHeader.location.href = "../jsp/ReportAuthorizationHeader.jsp?&patient_id_found="+formObj.patient_id_found.value
			parent.ReportAuthorizationResult.location.href = "../jsp/ReportAuthorizationQueryResult.jsp?"+qry_string+"&header_values="+header_values
			parent.ReportAuthorizationBtn.location.href = "../jsp/ReportAuthorizationBtn.jsp"
		}
		/*
			ends here.
		*/
		
	}
	
}

//called on click of clear button in search criteria
function clearValues(){
	//document.report_authorization_search.reset();
	//parent.ReportAuthorizationSearch.location.reload();
	//setLocationLabel(document.report_authorization_search.location_type);
	top.content.workAreaFrame.location.href="ReportAuthorization.jsp?&CancelFlag=N";
	/*parent.ReportAuthorizationSearch.report_authorization_search.search_btn.disabled= false;
	parent.ReportAuthorizationHeader.location.href = "../../eCommon/html/blank.html"
	parent.ReportAuthorizationResult.location.href = "../../eCommon/html/blank.html"
	parent.ReportAuthorizationBtn.location.href = "../../eCommon/html/blank.html"
	if (top.content) {
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num" ;
	}*/
}

//Added by prasad
function clearValuesfor(){
	//parent.ReportAuthorizationSearch.location.reload();
	top.content.workAreaFrame.location.href="ReportAuthorization.jsp?&CancelFlag=N";
	/*parent.ReportAuthorizationSearch.report_authorization_search.search_btn.disabled= false;
	parent.ReportAuthorizationHeader.location.href = "../../eCommon/html/blank.html"
	parent.ReportAuthorizationResult.location.href = "../../eCommon/html/blank.html"
	parent.ReportAuthorizationBtn.location.href = "../../eCommon/html/blank.html"
	if (top.content) {
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num" ;
	}*/
}


// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll(){
	//if(document.report_authorization_hdg.select_all.checked == true){
	if(document.getElementById("select_all").checked == true){
		for(cnt=0; cnt<parent.ReportAuthorizationResult.document.report_authorization_dtl.total_recs.value; cnt++){
			val = eval("parent.ReportAuthorizationResult.document.report_authorization_dtl.chk"+cnt);
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<parent.ReportAuthorizationResult.document.report_authorization_dtl.total_recs.value; cnt++){
			val = eval("parent.ReportAuthorizationResult.document.report_authorization_dtl.chk"+cnt);
			val.checked = false;
		}
	}
}

function clearChecked(){
	//parent.ReportAuthorizationHeader.document.report_authorization_hdg.reset()
	parent.ReportAuthorizationResult.document.report_authorization_dtl.reset();
}

function checkDate(obj){
	if(!(trimCheck(obj.value)))
	{
		obj.value = "";
		return false;
	}
	if(!(checkDt(obj.value))){
		alert(getMessage("INVALID_DATE_FMT","common"));
		obj.select();
		obj.focus();
		return false;
	}
}

function checkDate1(obj){
	var dt = new Date()
	var formObj = document.report_authorization_search
	var fromDate = formObj.date_from
	var toDate = formObj.date_to
	if(!(trimCheck(obj.value)))
	{
		obj.value = "";
		return false;
	}
	if(!(checkDt(obj.value))){
		alert(getMessage("INVALID_DATE_FMT","common"));
		obj.select();
		obj.focus();
		return false;
	}
	if(!(doDateCheck(fromDate,toDate,top.content.messageFrame)))
		return false
}

function authorizeReport()
{
	var order_category	 = parent.ReportAuthorizationSearch.document.report_authorization_search.order_category.value;
	var single_multi	 = parent.ReportAuthorizationSearch.document.report_authorization_search.single_multi.value;

	//qry_string = "ord_cat="+order_category+"&single_multi="+single_multi

	var no_of_checked = 0;
	var formObj = parent.ReportAuthorizationResult.document.report_authorization_dtl;

	for(cnt=0; cnt<formObj.total_recs.value; cnt++){

		val = eval("parent.ReportAuthorizationResult.document.report_authorization_dtl.chk"+cnt);

		if(val.checked == true)
			no_of_checked++;
	}
	if(parseInt(no_of_checked) == 0)
	{
		alert(getMessage('CHECK_ANY_ONE','OR'))
		return false
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	bean_id = document.report_authorization_btn.bean_id.value;

    xmlStr = "";
	xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReportAuthorizationValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=fing_values&flag=true", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
    var fingurePrnYN = '';
	eval(responseText);

	if (fingurePrnYN == 'Y') {
		
	var oledb_con_string = document.forms[0].oledb_con_string.value;

        if (verifyTheFinger(oledb_con_string)) {//	alert(formApply( parent.ReportAuthorizationResult.document.report_authorization_dtl,OR_CONTROLLER)) ;
            eval(formApply( 	parent.ReportAuthorizationResult.document.report_authorization_dtl,OR_CONTROLLER)) ;
        }
	} else {
        xmlStr = "";
        eval(formApply( 	parent.ReportAuthorizationResult.document.report_authorization_dtl,OR_CONTROLLER)) ;
	}

	if( invalidCode != "" ){ //"OR_STATUS_CHANGED"
		eval("parent.ReportAuthorizationResult.document.getElementById('status')"+invalidCode).className="orcancel";
		alert(message);
		return false;
	}else
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;


	result = true ;
	if( result )
		onSuccess();

		/*else if(parseInt(no_of_checked) == 1){
		confirm('Are You Sure ???')
	}else{

		var dialogHeight ='19' ;
		var dialogWidth = '40' ;
		var dialogTop	= '291';
		var dialogLeft = '157' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";

		var retVals = window.showModalDialog("../../eOR/jsp/AuthoriseMultipleModal.jsp",arguments,features);

		if(retVals != ""){
//			parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.ZZZZZZZZZZZ.value = retVals;
		}else{
//			parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.XXXXXXXXXXXXX.value = finalString;
		}
	}*/

}

function assignResult(_result, _message, _flag , _code){
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _code ;
}

function onSuccess()
{
	callResultEntryReport();
	//parent.ReportAuthorizationHeader.document.forms[0].reset()
	parent.ReportAuthorizationResult.location.href="../jsp/ReportAuthorizationQueryResult.jsp?"+parent.ReportAuthorizationResult.document.getElementById("qry_str").value
}

function callResultEntryReport(){
	var formObj = parent.ReportAuthorizationSearch;

	var bean_id = formObj.document.report_authorization_search.bean_id.value ;
	var localeName = formObj.document.report_authorization_search.localeName.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	flag='true';
	xmlHttp.open( "POST", "ReportAuthorizationValidate.jsp?bean_id=" + bean_id + "&validate=ResultEntryReport&flag="+flag+"&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )

}

async function callMenuFunctions(colval1,colval,orderId,sex,patient_id){
		var dialogHeight ='80vh' ;
		var dialogWidth = '65vw' ;
		var dialogTop	= '0';
		var dialogLeft = '0' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var title = colval1+" - "+colval + " " +getLabel("Common.Order.label", "Common");
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&title="+ title;
		var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);

		if(retVals != ""){
			//parent.f_query_add_mod.document.Order_Entry_Format_Item.listValues.value = retVals;
			//parent.f_query_add_mod.document.Order_Entry_Format_Item.finalString.value = retVals;
		}
}

function doSysDateCheck(from,to,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) < Date.parse(fromdt)) {
				var msg=getMessage("DATE_COMPARE","OR");
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)){
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
				return true;
			}
	}
return true;
}

////////////////////////////////
function populateLocnOrdType(obj)
{

	//setLocationLabel(location_type)
	var formObj = document.report_authorization_search;

	var validate = "";
	var bean_id = formObj.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;

	if (obj == "location_type") {
		if( formObj.location_type.value == "" ) {
			clearList("document");
			return false;
		}
        xmlStr += formObj.location_type.name+"=\""+ formObj.location_type.value +"\" " ;
		validate = "location";
	} else if (obj == "locn") {
		formObj.order_category.value = formObj.locn.value;
		/*if( formObj.locn.value == "" ) {
			clearTypeList("document");
			if (formObj.performing_location_code) {
				formObj.all.performing_locn_lbl_show.innerHTML = "&nbsp;";
				formObj.all.performing_locn_show.innerHTML = "&nbsp;";
			}
			return false;
		} else*//* if (formObj.locn.value == "LB" && formObj.isLabInstalled_yn.value == "Y") {
			formObj.locn.value = "";
			formObj.order_category.value = "";
			return false;
		} else commented on 7/19/2007 for lab_instal chk change by uma*/if (formObj.locn.value == "RD" && formObj.isRDInstalled_yn.value == "Y") {
			alert(getMessage('RADIOLOGY_MODULE_INSTALLED','OR'));
			formObj.locn.value = "";
			formObj.order_category.value = "";
			return false;
		}
		xmlStr += formObj.locn.name+"=\""+ formObj.locn.value +"\" " ;
		validate = "ord_type";
	}

	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	flag='true';
	xmlHttp.open( "POST", "ReportAuthorizationValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate="+validate+'&flag='+flag, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )
}

function addTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.report_authorization_search.order_type.add(element);
}

function clearTypeList( docObj ) {
	var len = eval(docObj+".report_authorization_search.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".report_authorization_search.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".report_authorization_search.order_type.add(opt)") ;
}

function addPerformingLocnList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.report_authorization_search.performing_location_code.add(element);
}

function clearPerformingLocnList( docObj ) {
	var len = eval(docObj+".report_authorization_search.performing_location_code.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".report_authorization_search.performing_location_code.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "   ---"+getLabel("Common.defaultSelect.label","Common")+"---      " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".report_authorization_search.performing_location_code.add(opt)") ;
}

function checkValidDateTime(obj){
	if(obj.value!='')
	{
			if(!doDateTimeChk(obj))
	    	{
	    		alert(getMessage("INVALID_DATE_TIME","SM"));
	    		obj.focus();
	    		obj.select();
	    	}
    }
}

function verifyTheFinger(obj)
	{
		var result;
		s1 = new String(document.forms[0].user_id.value);
		s2 = "";
		/*for(x=0; x<= s1.length; x++)
		{
			if(s1.charAt(x)!=" ")
				s2=s2+s1.charAt(x);
		}
		if(s2.length==0)
		{
			document.forms[0].user_id.value="";
			document.forms[0].user_id.focus();
			return(false);
		}*/

		try
		{
			document.WebFp.DatabaseType=0
			document.WebFp.ConnectionType=1
			document.WebFp.ConnectionString = obj;
			document.WebFp.SecurityLevel=5
			document.WebFp.UserTableName="SM_APPL_USER"
			document.WebFp.FingerTableName="SM_APPL_USER_BIO"
			document.WebFp.AccountCodeField="APPL_USER_ID"
			document.WebFp.AccountCodeFieldType = 1
			document.WebFp.AccountCode = document.forms[0].user_id.value;
			result = document.WebFp.Verify();
			//result = document.WebFp.Enroll();
			if(result)
			{
				alert(getMessage("VERIFICATION_SUCCESS","OR"));
				return true;
				//login_form.submit();
				//location.href = "regist.htm";
				//return(false);
			}
			else
			{
				alert(document.WebFp.ErrorString);
				//location.href = "regist.htm";
				return(false);
			}
		}
		catch(e)
		{
			alert(e.message);
			return(false);
		}

	}

	function checkDateRange(obj,from,fmt,localeName){

	var fromDate = eval("document."+from+".date_from")
	var toDate = eval("document."+from+".date_to")
	var localeName=localeName;
	//if(chckDate2(obj)){ //  this method is from ValidateControl.js
	if(validDateObj(obj,"DMYHM",localeName)){
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
		if(!isAfter(toDate.value,fromDate.value,"DMYHM",localeName.value)){//this function is available in eCommon/js/DateUtils.js		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			//obj.focus()
			return false
		}
	}else{
		parent.ReportAuthorizationSearch.document.report_authorization_search.date_to.value=parent.ReportAuthorizationSearch.document.report_authorization_search.curr_sys_date.value;
	}
}
function CheckDateTime(objText)
{
	if(objText.value !='')
	{
		if(!doDateTimeChk(objText))
		{
			alert(getMessage("INVALID_DATE_FMT","CA"));
      objText.value = '';
			objText.select();
			return false
		}
		else
			return true;
	}
} 

function chckDate(Object2,focusflag,localeName)
{
if(validDateObj(Object2,"DMYHM",localeName)==false)
	{
	parent.ReportAuthorizationSearch.document.report_authorization_search.date_from.value=
		parent.ReportAuthorizationSearch.document.report_authorization_search.tempdate.value;
		
	}
}

function focusOnResult()
{
	//parent.ReportAuthorizationHeader.document.report_authorization_hdg.select_all.disabled=false;
	if(document.getElementById("select_all"))
	{
		document.getElementById("select_all").disabled=false;
	}
}	

function SelectLocation(location_type)
{
	var formObj = document.report_authorization_search;
	var localeName=formObj.localeName.value;
	if( location_type.value == "" ) {
		clearSourceLocationList("document");
		document.report_authorization_search.LocnSearch.disabled=true;
		document.report_authorization_search.locn_desc.value="";
		document.report_authorization_search.locn.value="";
	}
	else
	{
	var bean_id = formObj.bean_id.value ;
	document.report_authorization_search.LocnSearch.disabled=false;
	document.report_authorization_search.locn_desc.value="";
	document.report_authorization_search.locn.value="";
	}
}

function clearSourceLocationList( docObj ) {
	
	document.report_authorization_search.locn.value="";
	document.report_authorization_search.locn_desc.value="";
}

function populateLocation1(target,code)
{
if(target.value!="")
	{
		populateLocation(target,code);
	}
	else
		parent.ReportAuthorizationSearch.document.report_authorization_search.locn.value="";
}

async function populateLocation(target,code)
{
	
	
	location_type=parent.ReportAuthorizationSearch.document.report_authorization_search.location_type.value;
if(location_type!='')
	{
	localeName=parent.ReportAuthorizationSearch.document.report_authorization_search.localeName.value;
	var sql="";

	if(location_type=="C")
	{
		//sql="select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(CLINIC_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.ReportAuthorizationSearch.document.report_authorization_search.clinic_sql.value;
	}else if(location_type=="N")
	{
		//sql="select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(NURSING_UNIT_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.ReportAuthorizationSearch.document.report_authorization_search.nursing_sql.value;
	}
	sql=sql.replace('?',"'"+localeName+"'");
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	argumentArray[0]   =sql;
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup(getLabel("Common.locationtype.label","common") , argumentArray );

	if((retVal != null) && (retVal != "") )  {
		var ret1=unescape(retVal);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		
		code.value = arr[0];
		target.value = arr[1]
	}
	}
	
}


function callActivitySearch1(target,code)
{
if(target.value!="")
	{
	callActivitySearch(target,code);
	}
	else
	parent.ReportAuthorizationSearch.document.report_authorization_search.activity_type.value="";
}


async function callActivitySearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.ReportAuthorizationSearch.document.report_authorization_search.localeName.value;
	dataNameArray[0] 	= "order_category" ;		 
  	dataValueArray[0] 	= parent.ReportAuthorizationSearch.document.report_authorization_search.locn.value;
	dataTypeArray[0] 	= STRING ;
	dataNameArray[1] 	= "order_type_code" ;		 
  	dataValueArray[1] 	= parent.ReportAuthorizationSearch.document.report_authorization_search.order_type.value;
 	dataTypeArray[1] 	= STRING ;
	
	var sql=parent.ReportAuthorizationSearch.document.report_authorization_search.activity_sql.value;
	sql=sql.replace('?',"'"+localeName+"'");
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retVal= await CommonLookup(getLabel("eOR.ActivityType.label","OR"),argumentArray);

	if((retVal != null) && (retVal != "") )  {
		var ret1=unescape(retVal);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		
		code.value = arr[0];
		target.value = arr[1]
	}
}

function alignHeading()
{

	if(parent.ReportAuthorizationHeader.document.getElementById("tableheader")!=null)
	{
				parent.ReportAuthorizationHeader.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				for (j=0; j < document.getElementById("tableresult").rows[1].cells.length; j++) 
				{
					var wid=eval(document.getElementById("tableresult").rows[1].cells[j].offsetWidth);
					
					if(parent.ReportAuthorizationHeader.document.getElementById("tableheader").rows[0].cells[j] != null)
					{
						parent.ReportAuthorizationHeader.document.getElementById("tableheader").rows[0].cells[j].width=wid;
					}
				}
		}
		
	}

	function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.ReportAuthorizationHeader.location.href.indexOf(".jsp") != -1)
	{
		parent.ReportAuthorizationHeader.document.body.scrollLeft=temp;
	}
}

