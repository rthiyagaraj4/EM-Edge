/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/* 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011  IN31901        	NijithaS    	Incident No: IN31901 - Bru-HIMS-CRF-263	
15/03/2013  IN032816        Chowminya G		Result Reporting > Record Clinical Note > Mark Error
30/07/2013	IN042064		Ramesh G		Re print of cardiology report is taking the previous patient details instead of current patient details in CA 
14/03/2014	  	IN047658		Vijayakumar K	17/03/2014	Chowminya G		Clinician Access ? Webpage dialog Some webpage 
21/04/2014	  	IN047658		Vijayakumar K	14/03/2014	Chowminya G		Reopen - Result Reporting > Result Entry ?Comments-webpage
---------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
16/10/2017		IN065433		Krishna Gowtham J 	16/10/2017		Ramesh G		OR-ML-MMOH-CRF-0560/01-Result Reporting
15/03/2019	    IN068778		Selvin M			14/03/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";
var window_id = ""; //IN068778
function query() {
	f_query_add_mod.location.href='../../eOR/jsp/ResultReportingFrame.jsp?function_id='+function_id ;
}

function setLocationLabel(location_type)
{
 	if(location_type.value == "C"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.clinic.label","Common")
	} else 	if(location_type.value == "W"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.nursingUnit.label","Common")
	}  else	if(location_type.value == "R"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.referral.label","Common")
	} else {
		if(document.getElementById("id_locn").innerHTML==getLabel("Common.OrderCategory.label","Common"))
			document.getElementById("id_locn").innerHTML = getLabel("Common.OrderCategory.label","Common")
		else 
			document.getElementById("id_locn").innerHTML = getLabel("Common.Location.label","Common")
	}
}

function populateLocation(location_type)
{
	setLocationLabel(location_type);
	var formObj = document.result_reporting_search;
	if( location_type.value == "" ) {
		clearList("document")
	}
	var localeName=formObj.localeName.value;
	var bean_id = formObj.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=location&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )
}
function addActivityList(code,value) {
	
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	//alert(selected);
	//element.selected = selected;
	document.result_reporting_search.activity_type.add(element);
}
function addLocationList(code,value,selected) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	//alert(selected);
	element.selected = selected;
	document.result_reporting_search.locn.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".result_reporting_search.locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".result_reporting_search.locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".result_reporting_search.locn.add(opt)") ;
}

//this fucntion is used to clear the entries of search criteria
function resetValues(){
}

function defaultOrderCategory() {
	//alert('kk');
    if (document.result_reporting_search.default_order_category.value == 'Y') {
        document.result_reporting_search.order_category.value='CN';
        document.result_reporting_search.locn.value='CN';
    }
}


//this is used for patient ID search
function callPatientSearch(){
	var pat_id =  PatientSearch();

	if(pat_id != null)
	document.getElementById("patient_id").value = pat_id;
}

//called on click of search
function populateValues(){
	
	if (top.content) {
	top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	}
	var formObj = parent.ResultReportingSearch.document.result_reporting_search;
	var sysDate = formObj.curr_sys_date
	var fromDate = formObj.date_from
	var toDate = formObj.date_to
	var localeName=formObj.localeName
	var orderid=formObj.temp_orderid.value
	var patientid=formObj.temp_patientid.value
	var days=daysBetween(fromDate.value,toDate.value,"DMY",localeName.value);
	if(days>30)
	{
	
		if(parent.ResultReportingSearch.document.getElementById("order_id").value=="" && parent.ResultReportingSearch.document.getElementById("patient_id").value=="")
		{
			alert(getMessage("CHECK_DATE_ORDERID_PATIENTID","OR"));
			if(parent.ResultReportingHeader)
			{
				parent.ResultReportingHeader.location.href = "../../eCommon/html/blank.html"
			}
			parent.ResultReportingResult.location.href = "../../eCommon/html/blank.html"
			if (top.content) 
			{
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num" ;
			}
			return false;
		}
	}
	//alert(eval(toDate-fromDate))
    //order_category
    /*if(formObj.order_category.value == "")
    {
    	alert(getMessage("RESULT_REPORTING_LOCN_BLANK","OR"));
    	//top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
		parent.ResultReportingHeader.location.href = "../../eCommon/html/blank.html"
		parent.ResultReportingResult.location.href = "../../eCommon/html/blank.html"
		return false ;
    } else*/ {

	if(fromDate.value==""){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
		return false
	}

	if(toDate.value==""){
		alert(getMessage("TO_DT_NOT_BLANK","SM"));
		return false
	}

	if(!(doSysDateCheck(fromDate,sysDate,parent.parent.parent.messageframe))) //Commented because of Thai Date Validations
	//if(!isAfter(sysDate.value,fromDate.value,"DMY",localeName))
		//{
		//alert(getMessage('DATE_NOT_GREATER_SYSDATE','common'));
		return false;
		//}
		
	if(!(doSysDateCheck(toDate,sysDate,parent.parent.parent.messageframe))) //Commented because of Thai Date Validations 
	//if(!isAfter(sysDate.value,toDate.value,"DMY",localeName))
		//{
		//alert(getMessage('DATE_NOT_GREATER_SYSDATE','common'));
		return false;
		//}
	

	/*if(!checkDate1(toDate)){
		parent.ResultReportingHeader.location.href = "../../eCommon/html/blank.html"
		parent.ResultReportingResult.location.href = "../../eCommon/html/blank.html"
		return false ;
	}*/
	//if(doDatetimeCheckAlert(fromDate.value,toDate.value)) { //commented because of Thai date Validations on 17/02/2007
	if(!isAfter(toDate.value,fromDate.value,"DMY",localeName)) {
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		//top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
		if(parent.ResultReportingHeader)
		{
			parent.ResultReportingHeader.location.href = "../../eCommon/html/blank.html"
		}
		parent.ResultReportingResult.location.href = "../../eCommon/html/blank.html"
		return false ;
	}

	qry_string = "location_type="+formObj.location_type.value+"&location="+formObj.locn.value+"&order_category="+formObj.order_category.value+"&single_multi="+formObj.single_multi.value+"&priority="+formObj.priority.value+"&date_from="+formObj.date_from.value+"&date_to="+formObj.date_to.value+"&patient_id="+formObj.patient_id.value+"&order_id="+formObj.order_id.value+"&encounter_id="+formObj.encounter_id.value+"&patient_id_found="+formObj.patient_id_found.value+"&activity_type="+formObj.activity_type.value;
	//if(formObj.practitioner_type.value!=('NS'))
		qry_string = qry_string+"&order_type="+formObj.order_type.value

	qry_string += "&catalog_desc="+formObj.catalog.value
	qry_string += "&search_criteria="+formObj.search_criteria.value
	qry_string += "&source_type="+formObj.source_location_type.value
	qry_string += "&source_location="+formObj.source_locn.value
	qry_string += "&view_by="+formObj.view_by.value
	qry_string += "&group_by="+formObj.group_by.value
	/*
	 Start 
	*/	
	if(formObj.performed_only.checked)
		performed_only='Y';
	else
		performed_only='N';
	qry_string += "&performed_only="+performed_only
	/*
	 End Here 
	*/
	qry_string += "&task_status="+formObj.task_status.value
    qry_string += "&from_ca="+formObj.from_ca.value
    qry_string += "&taskCode="+formObj.taskCode.value
    qry_string += "&period_mod_rslt_completed="+formObj.period_mod_rslt_completed.value
    qry_string += "&by_24hrs_yn="+formObj.by_24hrs_yn.value
    qry_string += "&pract_reln_id="+formObj.pract_reln_id.value

    if (formObj.specimen_no) {
	   qry_string += "&specimen_no="+formObj.specimen_no.value;
	} else {
	   qry_string += "&specimen_no=";
	}

    var flds=new Array(formObj.patient_id);
	var name=new Array(getLabel("Common.patientId.label","Common"));
	if(!SpecialCharCheck(flds,name,parent.parent.parent.messageframe,"M","../../eCommon/jsp/MstCodeError.jsp")){
			return false
	}

	if (parent.ResultReportingSearch.document.result_reporting_search.performing_location_code) {
		qry_string += "&performing_location_code="+parent.ResultReportingSearch.document.result_reporting_search.performing_location_code.value;
	} else {
		qry_string += "&peforming_location_code=";
	}
	document.result_reporting_search.search_btn.disabled= true;
	if(parent.ResultReportingHeader)
	{
		parent.ResultReportingHeader.location.href = "../jsp/ResultReportingHeader.jsp?&patient_id_found="+formObj.patient_id_found.value+"&view_by="+formObj.view_by.value
	}
 	if(formObj.called_from.value=="Coding") {
		//url = "../jsp/ResultCodingQueryResult.jsp?"+qry_string
		parent.ResultReportingResult.location.href = "../jsp/ResultCodingQueryResult.jsp?"+qry_string
	} 	else  {
			
		//url = "../jsp/ResultCodingQueryResult.jsp?"+qry_string
		parent.ResultReportingResult.location.href = "../jsp/ResultReportingResultFrameset.jsp?"+qry_string
	}
 	//parent.parent.parent.messageframe.location.href= "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	//parent.ResultReportingBtn.location.href = "../jsp/ResultReportingBtn.jsp"
	}
}

//called on click of clear button in search criteria
function clearValues(){

	//parent.ResultReportingSearch.document.result_reporting_search.reset();
	//parent.ResultReportingSearch.location.reload();//commented for IN065433
	parent.ResultReportingSearch.location.href=parent.ResultReportingSearch.location.href+"&load_search=N";//IN065433
	setLocationLabel(document.result_reporting_search.location_type);
	if(parent.ResultReportingHeader)
	{
		parent.ResultReportingHeader.location.href = "../../eCommon/html/blank.html"
	}
	parent.ResultReportingResult.location.href = "../../eCommon/html/blank.html"
	if (top.content) {
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num" ;
	}

	//parent.ResultReportingBtn.location.href = "../../eCommon/html/blank.html"
}

//Added by prasad
function clearValuesfor(){
//parent.parent.RefsultReportingSearch.location.reload();

parent.parent.ResultReportingSearch.result_reporting_search.search_btn.disabled= false;
if(parent.parent.ResultReportingHeader)
{
	parent.parent.ResultReportingHeader.location.href = "../../eCommon/html/blank.html"
}
parent.parent.ResultReportingResult.location.href = "../../eCommon/html/blank.html"
	if (top.content) {
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num" ;
	}
}

function clearValuesfor1(){ //Add by prasad
	parent.ResultReportingSearch.result_reporting_search.search_btn.disabled= false;
	if(parent.ResultReportingHeader)
	{
		parent.ResultReportingHeader.location.href = "../../eCommon/html/blank.html"
	}
		parent.ResultReportingResult.location.href = "../../eCommon/html/blank.html"
		if (top.content) {
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num" ;
		}
}
// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll(){
	if(document.result_reporting_hdg.select_all.checked == true){
		for(cnt=0; cnt<parent.ResultReportingResult.ResultReportingResult.document.result_reporting_dtl.total_recs.value; cnt++){
			val = eval("parent.ResultReportingResult.ResultReportingResult.document.result_reporting_dtl.chk"+cnt);
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<parent.ResultReportingResult.ResultReportingResult.document.result_reporting_dtl.total_recs.value; cnt++){
			val = eval("parent.ResultReportingResult.ResultReportingResult.document.result_reporting_dtl.chk"+cnt);
			val.checked = false;
		}
	}
}

function clearChecked(){
	if(parent.ResultReportingHeader)
	{
		parent.ResultReportingHeader.document.result_reporting_hdg.reset()
	}
	parent.ResultReportingResult.ResultReportingResult.document.result_reporting_dtl.reset()
//	parent.parent.parent.messageframe.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num" ;
}

/*function checkDate(obj){ // Commented because of Thai Date Validations 17/02/2007

	var formObj	 = document.result_reporting_search ;
	var fromDate = formObj.date_from ;
	var toDate	 = formObj.date_to	 ;

	if(!(trimCheck(obj.value)))
	{
		obj.value = "";
		return false;
	}
	if(!(CheckDate(obj))){
		return false;
	}


	if(!checkDate1(toDate)){
		fromDate.value = "";
		return false;
	}else{
		if (top.content) {
        top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num" ;
        }
	}
}*/

/*function checkDate1(obj){  //Commented because of Thai Date Validations on 17/02/2007
	var dt = new Date()
	var formObj = document.result_reporting_search
	var fromDate = formObj.date_from
	var toDate = formObj.date_to
	if(!(trimCheck(obj.value)))
	{
		obj.value = "";
		return true;
	}

	if(!(CheckDate(obj))){
		return false;
	}

	if(!(doDateCheck(fromDate,toDate,parent.parent.parent.messageframe))){
		obj.focus();
		obj.select();
		return false
	}else{
		if (top.content) {
        top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num" ;
        }
		return true ;
	}

}*/

function registerOrder(){
	var view_by = parent.ResultReportingSearch.document.result_reporting_search.view_by.value
	var order_category = parent.ResultReportingSearch.document.result_reporting_search.order_category.value
	var single_multi = parent.ResultReportingSearch.document.result_reporting_search.single_multi.value

	qry_string = "view_by="+view_by+"&ord_cat="+order_category+"&single_multi="+single_multi

	var no_of_checked = 0;
	var formObj = parent.ResultReportingResult.ResultReportingResult.document.result_reporting_dtl
	for(cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("parent.ResultReportingResult.ResultReportingResult.document.result_reporting_dtl.chk"+cnt);

		if(val.checked == true)
			no_of_checked++;
	}

	if(parseInt(no_of_checked) == 0){
		//alert('Check any one ')
		alert(getMessage("CLICK_ANY_ONE","OR"));
		return false
	}

		eval(formApply( parent.ResultReportingResult.ResultReportingResult.document.result_reporting_dtl,OR_CONTROLLER)) ;
		//alert("frame3"+parent.frames[1].name);

		if (top.content) {
        top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
        } else {
            alert(message);
        }
		if( result ) {
			onSuccess();
		}
}

function assignResult(_result, _message, _flag){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;

}

function onSuccess() {
	if(parent.ResultReportingHeader)
	{
		parent.ResultReportingHeader.document.register_order_hdg.reset()
	}
	parent.ResultReportingResult.location.href="../jsp/ResultReportingResultFrameset.jsp?"+qry_string
}

var returnFromResultEntryTo=""
/*function callMenuFunctions(colval1,colval,orderId,encounterId,sex,patient_id,procedure_code,patient_class){
		alert('here');
		var dialogHeight ='27' ;
		var dialogWidth = '48' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +escape(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id;

		if(colval1=="ResultEntry")
		{
			resultReportingURL = top.content.workAreaFrame.location.href;
			resultReportingURL = resultReportingURL.substr((resultReportingURL.indexOf("?")+1),resultReportingURL.length-1)
			//alert(resultReportingURL);
			resultReportingURL += '&encounter_id='+encounterId
			//alert(resultReportingURL);
			//alert(parent.ResultReportingResult.order_category.value);
			finalString = finalString + "&order_category="+parent.ResultReportingResult.order_category.value;

			finalString += "&can_location_type="+parent.ResultReportingResult.can_location_type.value;
			finalString += "&can_location="+parent.ResultReportingResult.can_location.value;
			finalString += "&can_order_category="+parent.ResultReportingResult.can_order_category.value;
			finalString += "&can_single_multi="+parent.ResultReportingResult.can_single_multi.value;
			finalString += "&can_priority="+parent.ResultReportingResult.can_priority.value;
			finalString += "&can_date_from="+parent.ResultReportingResult.can_date_from.value;
			finalString += "&can_date_to="+parent.ResultReportingResult.can_date_to.value;
			finalString += "&can_patient_id="+parent.ResultReportingResult.can_patient_id.value;
			finalString += "&can_order_id="+parent.ResultReportingResult.can_order_id.value;
			finalString += "&can_encounter_id="+parent.ResultReportingResult.can_encounter_id.value;
			finalString += "&can_patient_id_found="+parent.ResultReportingResult.can_patient_id_found.value;
			finalString += "&can_order_type="+parent.ResultReportingResult.can_order_type.value;
			finalString += "&can_performing_location_code="+parent.ResultReportingResult.can_performing_location_code.value;
			//alert("Frame Name = "+resultReportingURL+" -- "+unescape(resultReportingURL));
			//alert(">>>"+resultReportingURL );
			top.content.workAreaFrame.location.href="ResultEntry.jsp?"+finalString+"&"+resultReportingURL
		} else if (colval1=="RecordProcedure") {
			finalString += "&code="+procedure_code+"&patient_class="+patient_class+"&episode_id="+encounterId+"&modal_yn=Y&mode=OR";
            alert(finalString);
			//var retVals = window.showModalDialog("../../eCA/jsp/AddModifyOPProc.jsp?"+finalString,arguments,features);
			//top.content.workAreaFrame.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+finalString

			//var retVals = window.showModalDialog("RecordProcedureFrameset.jsp?"+finalString,arguments,features);
			var retVals = window.showModalDialog("../../eCA/jsp/PatProcRecord.jsp?"+finalString,arguments,features);
			populateValues();
		} else {alert("in else");
			var retVals = window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);

			if(retVals!=null ){
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+retVals;

			}
				document.location.reload();
		}
} */

function showCharting(patient_id,episode_id,patient_class,chartId,p_time) {

    p_time = (p_time.split(" "))[1];
    qry_string = 'patient_id='+patient_id+'&episode_id='+episode_id+'&patient_class='+patient_class+'&chartId='+chartId+'&pTime='+p_time+'&from_service_yn=Y';
    //alert(qry_string);
	var action_url	='../../eNM/jsp/ChartInModal.jsp?'+qry_string;
	var child_window	=	window.open(action_url,null,"height=450,width=790,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");
	child_window.focus();

}

function getInitialAssessment(patient_id,facility_id,encounter_id,episode_type,visit_adm_date,p_note_type,p_date_time,patient_class)
 {
    qry_string = "patient_id="+patient_id+"&facility_id="+facility_id+"&episode_id="+encounter_id+"&p_note_type="+p_note_type+"&p_date_time="+p_date_time+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class
    //alert(qry_string);
	var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?"+qry_string;
	var child_window	=	window.open(action_url,null,"height=450,width=790,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");
	child_window.focus();
 }


function callChart(patient_id,episode_visit_id,episode_id,location_code,location_type,bed_num,room_num,episode_type,discharge_date,visit_adm_date,episode_Status,sex,dob,age,pline,patient_class,order_id){
    var bean_id = parent.parent.ResultReportingSearch.document.result_reporting_search.bean_id.value ;
	var formObj=document.result_reporting;
	var localeName=formObj.localeName.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += "order_id=\""+ order_id +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=chart_updation&flag=true&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//eval(responseText );

    openChart(patient_id,episode_visit_id,episode_id,location_code,location_type,bed_num,room_num,episode_type,discharge_date,visit_adm_date,episode_Status,sex,dob,age,pline,patient_class);
}

function openChart(patient_id,episode_visit_id,episode_id,location_code,location_type,bed_num,room_num,episode_type,discharge_date,visit_adm_date,episode_Status,sex,dob,age,pline,patient_class){
	//refreshArray();
	episode_visit_id = "1";
	var arr = new Array();
	arr[0] = patient_id;
	arr[0] = episode_visit_id;
	arr[0] = episode_id;
	arr[0] = location_code;
	arr[0] = location_type;
	arr[0] = bed_num;
	arr[0] = patient_id;
	arr[0] = patient_id;
	arr[0] = patient_id;
	arr[0] = patient_id;
	arr[0] = patient_id;
	arr[0] = patient_id;
	arr[0] = patient_id;
	arr[0] = patient_id;

	
	var reln_req_yn= "N";
	//return false;
	var HTMLVal = "<html><body><form action='../../servlet/eCA.CAMainFrameValidateServlet' method='post' name='frmPatient' id='frmPatient'>";
	HTMLVal +="<input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'>";
	HTMLVal +="<input type='hidden' name='episode_visit_id' id='episode_visit_id' value='"+episode_visit_id+"'>";
	HTMLVal +="<input type='hidden' name='episode_id' id='episode_id' value='"+episode_id+"'>";
	HTMLVal +="<input type='hidden' name='location_code' id='location_code' value='"+location_code+"'>";
	HTMLVal +="<input type='hidden' name='location_type' id='location_type' value='"+location_type+"'>";
	HTMLVal +="<input type='hidden' name='bed_num' id='bed_num' value='"+bed_num+"'>";
	HTMLVal +="<input type='hidden' name='room_num' id='room_num' value='"+room_num+"'>";
	HTMLVal +="<input type='hidden' name='episode_type' id='episode_type' value='"+episode_type+"'>";
	HTMLVal +="<input type='hidden' name='discharge_date' id='discharge_date' value='"+discharge_date+"'>";
	HTMLVal +="<input type='hidden' name='visit_adm_date' id='visit_adm_date' value='"+visit_adm_date+"'>";
	HTMLVal +="<input type='hidden' name='episode_Status' id='episode_Status' value='"+episode_Status+"'>";
	HTMLVal +="<input type='hidden' name='sex' id='sex' value='"+sex+"'>";
	HTMLVal +="<input type='hidden' name='dob' id='dob' value='"+dob+"'>";
	HTMLVal +="<input type='hidden' name='age' id='age' value='"+age+"'>";
	HTMLVal +="<input type='hidden' name='pline' id='pline' value='"+pline+"'>";
	HTMLVal +="<input type='hidden' name='patient_class' id='patient_class' value='"+patient_class+"'>";
	HTMLVal +="<input type='hidden' name='reln_req_yn' id='reln_req_yn' value='"+reln_req_yn+"'>";
	HTMLVal+="</form></body></html>";
	
	top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	top.content.messageFrame.document.forms[0].submit();
}

async function callPerfMenuFunctions(colval1,colval,orderId,encounter_id,sex,patient_id,procedure_code,patient_class,ord_cat,order_status,order_line_num,performing_facility,performing_location_type,performing_location,int_or_ext,sent_out_flag,priority,order_type_code,source_type,source_code,dob){
	
	
	var bean_id		= parent.parent.ResultReportingSearch.document.result_reporting_search.bean_id.value;
	var bean_name	= parent.parent.ResultReportingSearch.document.result_reporting_search.bean_name.value;
    if (colval1 == "View") {
		var dialogHeight ='37.5' ;
		var dialogWidth = '50' ;
		var dialogTop	= '100';
		var dialogLeft = '11' ;
    } else if (colval1 == "ChangePerformLocn") {

       var dialogHeight ='63vh' ;
	   //IN047658 reopen starts
	   //var dialogWidth = '20' ;
	   var dialogWidth = '30vw' ;
	   //IN047658 reopen starts
		var dialogTop	= '250';
		var dialogLeft = '30' ;
    }
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";

        var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+ord_cat+"&order_line_num="+order_line_num;
		finalString += "&performing_facility=" + performing_facility;
		finalString += "&performing_location=" + performing_location;
		finalString += "&performing_location_type=" + performing_location_type;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&int_or_ext=" + int_or_ext;
		finalString += "&priority=" + priority;
		finalString += "&patient_class=" + patient_class;
		finalString += "&order_type_code=" + order_type_code;
		finalString += "&source_type=" + source_type;
		finalString += "&source_code=" + source_code;
		finalString += "&dob=" + dob;
		finalString += "&bean_id=" + bean_id;
		finalString += "&bean_name=" + bean_name;
	
		
        if (colval1 == "View") {
		  var retVals =await  window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		}
		if (colval1 == "ChangePerformLocn") {
		  var retVals = await window.showModalDialog("../../eOR/jsp/RegisterOrderPerformLocn.jsp?"+finalString,arguments,features);
        }
		
		if (colval1 == "SentOut" || ((colval1 == "ResultEntry" || colval1 == "Completion") && (sent_out_flag == 'S')) ) {
			
			var dialogHeight ='21vh' ;
			var dialogWidth = '28vw' ;
			var dialogTop	= '250';
			var dialogLeft = '141' ;

			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
			var retVals = await window.showModalDialog("../../eOR/jsp/RegisterOrderSentOut.jsp?"+finalString,arguments,features);
        }
		if (colval1 == "ReceiveResult"  || ((colval1 == "ResultEntry" || colval1 == "Completion") && (sent_out_flag == 'R')) ) {
		
			var dialogHeight ='23vh' ;
			var dialogWidth = '30vw' ;
			var dialogTop	= '129';
			var dialogLeft = '71' ;
		  var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		  var retVals = await window.showModalDialog("../../eOR/jsp/RegisterOrderReceiveResult.jsp?"+finalString,arguments,features);
		}
		if (colval1 != "View") {
		reloadValues();
		}
        //document.location.reload();
		//document.register_order_dtl.reset();
}
var window_obj;
var ord_id1;
var note_type;

/**
	modified by Deepa on 13/05/2010 for IN021020
	added dob to thh function to handle multiple reference range
**/	
async function callMenuFunctions(colval1,colval,orderId,encounterId,sex,patient_id,procedure_code,patient_class,image_ref,ord_cat,order_status,order_line_num,performing_facility,performing_location_type,performing_location,int_or_ext,sent_out_flag,patient_dtls,discr_msr_id,proc_code_scheme,order_type_code,order_set_id,pat_dob,accssion_num,performed_only){
	//alert("order_type_code=colval1"+colval1);
	//alert("performed_only="+performed_only);
		ord_id1=orderId;
 		var dialogHeight ='95vh' ;
		var dialogWidth = '95vw' ;
		var dialogTop	= '10';
		var dialogLeft = '10' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var finalString="";

		if(colval1=="Discontinue")
		{
			finalString	= "from=line&colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&patient_class="+ patient_class+"&order_type_code="+ order_type_code+"&order_line_num="+order_line_num+"&from=ResultReporting";
		}
		else
		{
			finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&patient_class="+ patient_class+"&order_line_num="+ order_line_num+"&order_type_code="+ order_type_code+"&from=ResultReporting&dob="+pat_dob+"&performed_only="+performed_only;
		}

		var arguments = "";
		/*if(colval1=="ResultEntry" || colval1=="Completion"){
		finalString	= finalString+"&image_ref="+image_ref+"&patient_dtls="+unescape(patient_dtls)+"&patient_class="+patient_class+"&order_type_code="+order_type_code;
		}*/
		//alert("in callMenuFunctions,colval1="+colval1);
 		if(colval1=="ResultEntry" || colval1=="Notes")
		{
			if (top.content) {
			     resultReportingURL = top.content.workAreaFrame.location.href;
            } else {
			     resultReportingURL = parent.parent.location.href;
            }
			//alert("resultReportingURL="+resultReportingURL);
			var encounter_dtls;
			if(encounterId == ""){
				
				patient_dtls = unescape(patient_dtls)
				encounter_dtls = patient_dtls.split(":");
				var ind = encounter_dtls[2].indexOf(",");
				encounterId = encounter_dtls[2].substring(0,ind);
				
			}
			
			resultReportingURL = resultReportingURL.substr((resultReportingURL.indexOf("?")+1),resultReportingURL.length-1)
			//alert(resultReportingURL);
			if((resultReportingURL.indexOf("p_called_from_ca"))!= -1){
				resultReportingURL = resultReportingURL.substr((resultReportingURL.indexOf("p_called_from_ca")),resultReportingURL.length-1);
				//alert(resultReportingURL);
				/*if(resultReportingURL.indexOf("&CanelFlag=Y") != -1)
					resultReportingURL = resultReportingURL.substr(0,resultReportingURL.indexOf("&CanelFlag=Y"));*/
								
				if(resultReportingURL.indexOf("&orderId=") != -1)
					resultReportingURL = resultReportingURL.substr(0,resultReportingURL.indexOf("&orderId=")+1);
				
				resultReportingURL = resultReportingURL.substr(0,resultReportingURL.length-1);
			}
			//IN042064 Start.
			if((resultReportingURL.indexOf("&encounter_id"))!= -1){
				resultReportingURL = resultReportingURL.substr(0,(resultReportingURL.indexOf("&encounter_id")));
			}
			//IN042064 End.
			resultReportingURL += '&encounter_id='+encounterId+"&order_status="+ order_status;//IN032816
			
			//alert(parent.name);
			//alert(parent.ResultReportingResult.name);
			//alert(parent.ResultReportingResult.ResultReportingResult.name);
			//alert(parent.ResultReportingResult.ResultReportingResult.order_category.value);
			finalString = finalString + "&order_category="+ord_cat;//parent.ResultReportingResult.order_category.value;
			finalString += "&can_location_type="+parent.ResultReportingResult.document.result_reporting.can_location_type.value;
			finalString += "&can_location="+parent.ResultReportingResult.document.result_reporting.can_location.value;
			finalString += "&can_order_category="+parent.ResultReportingResult.document.result_reporting.can_order_category.value;
			finalString += "&can_single_multi="+parent.ResultReportingResult.document.result_reporting.can_single_multi.value;
			finalString += "&can_priority="+parent.ResultReportingResult.document.result_reporting.can_priority.value;
			finalString += "&can_date_from="+parent.ResultReportingResult.document.result_reporting.can_date_from.value;
			finalString += "&can_date_to="+parent.ResultReportingResult.document.result_reporting.can_date_to.value;
			finalString += "&can_patient_id="+parent.ResultReportingResult.document.result_reporting.can_patient_id.value;
			finalString += "&can_order_id="+parent.ResultReportingResult.document.result_reporting.can_order_id.value;
			finalString += "&can_encounter_id="+parent.ResultReportingResult.document.result_reporting.can_encounter_id.value;
			finalString += "&can_patient_id_found="+parent.ResultReportingResult.document.result_reporting.can_patient_id_found.value;
			finalString += "&can_order_type="+parent.ResultReportingResult.document.result_reporting.can_order_type.value;
			finalString += "&can_performing_location_code="+parent.ResultReportingResult.document.result_reporting.can_performing_location_code.value;
			finalString += "&can_specimen_no="+parent.ResultReportingResult.document.result_reporting.can_specimen_no.value;

			finalString += "&can_catalog_desc="+parent.ResultReportingResult.document.result_reporting.can_catalog_desc.value;
			finalString += "&can_search_criteria="+parent.ResultReportingResult.document.result_reporting.can_search_criteria.value;
			finalString += "&can_source_location_type="+parent.ResultReportingResult.document.result_reporting.can_source_location_type.value;
			finalString += "&can_source_locn="+parent.ResultReportingResult.document.result_reporting.can_source_locn.value;
			finalString += "&can_group_by="+parent.ResultReportingResult.document.result_reporting.can_group_by.value;
			finalString += "&can_task_status="+parent.ResultReportingResult.document.result_reporting.can_task_status.value;
			finalString += "&performed_only="+parent.ResultReportingResult.document.result_reporting.performed_only.value;
			finalString += "&report_srl_no="+order_line_num;
			//alert("Frame Name = "+resultReportingURL+" -- "+unescape(resultReportingURL));
			//alert(">>>"+resultReportingURL );
			//alert(">>>"+finalString );
			
			if (top.content) {
				
			top.content.workAreaFrame.location.href="ResultEntry.jsp?"+finalString+"&"+resultReportingURL
			} else {
				
			 parent.parent.location.href="ResultEntry.jsp?"+finalString+"&"+resultReportingURL
			}
		} else if (colval1=="RecordProcedure") {
			//alert(proc_code_scheme);
			finalString += "&code="+procedure_code+"&patient_class="+patient_class+"&episode_id="+encounterId+"&modal_yn=Y&mode=OR&term_set_id="+proc_code_scheme;//"&term_set_id=ICD10"  term_Set_id need to be passed ...
           //alert(finalString);
			//var retVals = window.showModalDialog("../../eCA/jsp/AddModifyOPProc.jsp?"+finalString,arguments,features);
			//top.content.workAreaFrame.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+finalString

			//var retVals = window.showModalDialog("RecordProcedureFrameset.jsp?"+finalString,arguments,features);
			var retVals =await window.showModalDialog("../../eCA/jsp/PatProcRecord.jsp?"+finalString,arguments,features);
			rePopulateValues();
		} else if(colval1=="Image")
		{
  			 var retVals =await window.showModalDialog("../../eOR/jsp/ResultEntryDrawingToolFrameSet.jsp?called_from=RESULT&patient_id="+patient_id+"&encounter_id="+"&order_id="+escape(orderId), arguments,features);
  			 rePopulateValues();
			
		}/* else if(colval1=="Notes"){
			if (top.content) {
				var encounter_dtls;
				if(encounterId == ""){
					//alert(unescape(patient_dtls));
					patient_dtls = unescape(patient_dtls)
					encounter_dtls = patient_dtls.split(":");
					var ind = encounter_dtls[2].indexOf(",");
					encounterId = encounter_dtls[2].substring(1,ind);
				}//alert("note type=="+discr_msr_id);
				var assess_note_id	 = discr_msr_id ;
				note_type			 = assess_note_id;
				var accession_num	 = parent.ResultReportingResult.accession_num.value;
				var patient_id		 = patient_id;
				var note_signed		 = '';
				var patient_class	 = patient_class;
				
				var dialogTop	 = "97";
				var dialogHeight = "445";
				var dialogWidth	 = "790";
				var features = "top="+dialogTop+",height="+dialogHeight+",width="+dialogWidth+",status=no,left=0";
				var arguments = "Window_for_"+patient_id;
				var action_url	="../../eCA/jsp/RecClinicalNotesModal.jsp?title=Clinical Note&note_type="+assess_note_id+"&patient_id="+patient_id+"&patient_class="+patient_class+"&episode_id="+encounterId+"&encounter_id="+encounterId+ "&Field_Ref=parent.ResultReportingResult.accession_num&function_id=SPCL_NOTE&event_class=PHY$&accession_num="+accession_num+"&window_close=Y&note_signed="+ note_signed+"&appl_task_id=CLINICAL_NOTES";
				
				if(window_obj != null)
					window_obj.close();
				else
					window_obj = window.open(action_url,arguments,features);
				
				setInterval('updateAccession();', 2500);
					
			}
		}	*/
		//IN068778 Start.
		else if(colval1 == "UploadImageVideo"){ 
			var calledFrom  = "RESULT_REPORT";
			var dialogTop   = "10";
			var dialogLeft   = "10";
			var dialogHeight= "37.5" ;
			var dialogWidth = "50" ;
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
			var arguments = "";				
		var accession_num="";
		var note_type="";

		window_id = window.open("../../eOR/jsp/ImageVideosFileUploadMain.jsp?accession_num="+accession_num+"&note_type="+note_type+"&call_from=window&patient_id="+patient_id+"&encounter_id="+encounterId+"&order_id="+orderId+"&order_line_num="+order_line_num,'Document1',"height=580,width=650,top=50,left=130,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");  //IN70150
		} 
		//IN068778 end.
		else {
             if(colval1 == "Instructions"){

			var dialogHeight ='12' ;
			//IN047658 starts
			//var dialogWidth = '30' ;
			//IN047658 - reopen starts
			//var dialogWidth = '33' ;
			var dialogWidth = '37' ;
			//IN047658 ends
			//IN047658 - reopen ends
			var dialogTop	= '189';
			var dialogLeft = '167' ;
			 }else if( colval1 == "Discontinue" || colval1=="Hold"){
			  var dialogHeight ='37vh' ;
			  //IN047658 starts
			  //var dialogWidth = '25' ;
			  //IN047658 - reopen starts
			  //var dialogWidth = '30' ;
			  //IN047658 ends
			  var dialogWidth = '28vw' ;
			  //IN047658 - reopen ends
			  var dialogTop	= '189';
			  var dialogLeft = '167' ;
		    }else if (colval1 == "Preps" || colval1 == "Comments" || colval1 == "Resule" || colval1 == "Renew") {

		      var dialogHeight ='12' ;
			  //IN047658 starts
			  //var dialogWidth = '30' ;
			  //IN047658 - reopen starts
			  //var dialogWidth = '33';
			  //IN047658 ends
			  var dialogWidth = '37';
			  //IN047658 - reopen ends
			  var dialogTop	= '189';
			  var dialogLeft = '167' ;
		    }
			else
			{
				var dialogHeight ='80vh' ;
				//IN047658 starts
				//var dialogWidth = '50' ;
				//IN047658 - reopen starts
				//var dialogWidth = '53' ;
				//IN047658 starts
				var dialogWidth = '60vw' ;
				//IN047658 - reopen ends
				var dialogTop	= '10';
				var dialogLeft = '10' ;
			}

		    finalString += "&from=header&cont_order_ind=CO&cancel_type=CN&ord_cat="+ord_cat+"&order_status="+order_status+"&val1="+ord_cat+"&ord_cat_id="+ord_cat+"&performing_facility="+performing_facility+"&patient_class="+patient_class+"&encounter_id="+encounterId+"&order_set_id="+order_set_id+"&performed_only="+performed_only+"&accssion_num="+accssion_num;
             var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		   //alert("finalString=============#################"+finalString);
			 var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);

			if(retVals!=null ){
			     if (top.content && !top.dialogArray.length) {
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+retVals;
				} else {
				    alert(retVals);
				}

			}
				if (colval1 != "View") {
				reloadValues();  // because of next and prev
				}
			   // document.location.reload();
 		}
}
function updateAccession(){
	var orderId = ord_id1;
//alert("here ---");	//alert("accession_num.value:"+parent.ResultReportingResult.accession_num.value+"--orderId-"+orderId);
	if(orderId !="" && parent.ResultReportingResult.accession_num.value != ""){
		//alert("got the accession num..NT."+note_type+"=AN="+ parent.ResultReportingResult.accession_num.value+"=OID="+orderId)
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += "order_id=\""+ orderId +"\" " ;
	xmlStr += "accession_num=\""+ parent.ResultReportingResult.accession_num.value +"\" " ;
	xmlStr += "note_type=\""+ note_type +"\" " ;
    xmlStr +=" /></root>" ;
	//alert(parent.ResultReportingResult.accession_num.value+"----"+orderId)
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var flag="true";
	var validate = "ACCESSION_NUM";
	var accession_num=parent.ResultReportingResult.accession_num.value;
	xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=Or_ResultReporting&validate="+validate+'&accession_num='+accession_num+"&note_type="+note_type+"&flag="+flag, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
	var confirm_val = window.confirm(getMessage("PRINT_CONFIRM","OR"));
	if(confirm_val){
		//alert("Report is submitted to the printer");
		alert(getMessage("RPT_SUBMIT_TO_PRINTER","OR"));
	}else
		reloadValues();
		//document.location.reload();
	}else{
		//document.location.reload();
		//setInterval('updateAccession();', 50);
		//alert("here in else part");
	}
	/*else{
		alert();
		setInterval('updateAccession();', 50);
	}*/	
}
async function callMenuFunctions1(colval1,colval,orderId,encounterId,sex,patient_id,procedure_code,patient_class,order_line_num,ord_cat,order_status){
	
		
		var dialogHeight ='27' ;
		var dialogWidth = '48' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&encounter_id="+encounterId+"&sex="+ sex+"&patient_id="+ patient_id+"&order_status="+order_status+"&from=ResultReporting";
 		if(colval1=="ResultEntry")
		{
			
			if (top.content) {
            resultReportingURL = top.content.workAreaFrame.location.href;
            } else {
                resultReportingURL = parent.parent.location.href;
            }
			resultReportingURL = resultReportingURL.substr((resultReportingURL.indexOf("?")+1),resultReportingURL.length-1)
			resultReportingURL += '&encounter_id='+encounterId
			finalString = finalString + "&order_category="+ord_cat;//parent.ResultReportingResult.order_category.value;

			finalString += "&can_location_type="+parent.ResultReportingResult.can_location_type.value;
			finalString += "&can_location="+parent.ResultReportingResult.can_location.value;
			finalString += "&can_order_category="+parent.ResultReportingResult.can_order_category.value;
			finalString += "&can_single_multi="+parent.ResultReportingResult.can_single_multi.value;
			finalString += "&can_priority="+parent.ResultReportingResult.can_priority.value;
			finalString += "&can_date_from="+parent.ResultReportingResult.can_date_from.value;
			finalString += "&can_date_to="+parent.ResultReportingResult.can_date_to.value;
			finalString += "&can_patient_id="+parent.ResultReportingResult.can_patient_id.value;
			finalString += "&can_order_id="+parent.ResultReportingResult.can_order_id.value;
			finalString += "&can_encounter_id="+parent.ResultReportingResult.can_encounter_id.value;
			finalString += "&can_patient_id_found="+parent.ResultReportingResult.can_patient_id_found.value;
			finalString += "&can_order_type="+parent.ResultReportingResult.can_order_type.value;
			finalString += "&can_performing_location_code="+parent.ResultReportingResult.can_performing_location_code.value;
			finalString += "&can_specimen_no="+parent.ResultReportingResult.can_specimen_no.value;

			if (top.content) {

			top.content.workAreaFrame.location.href="ResultEntry.jsp?"+finalString+"&"+resultReportingURL
			} else {
			 parent.parent.location.href="ResultEntry.jsp?"+finalString+"&"+resultReportingURL
			}
		} else if (colval1=="RecordProcedure") {
			var dialogHeight ='31' ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
			finalString += "&code="+procedure_code+"&patient_class="+patient_class+"&episode_id="+encounterId+"&modal_yn=Y&mode=OR";
            //alert(finalString);
			var retVals = await window.showModalDialog("../../eCA/jsp/PatProcRecord.jsp?"+finalString,arguments,features);
			rePopulateValues();
		} else {
			finalString += "&order_id="+orderId+"&order_line_num="+order_line_num;
			//alert(colval1 == "Discontinue");
			if(colval1 == "Instructions"){
			var dialogHeight ='12' ;
			var dialogWidth = '35' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		    }else if (colval1 == "Preps" || colval1 == "Comments" || colval1 == "Discontinue" || colval1 == "Hold" || colval1 == "Resule" || colval1 == "Renew") {
		      var dialogHeight ='22' ;
			  var dialogWidth = '40' ;
			  var dialogTop	= '189';
			  var dialogLeft = '167' ;
		    }
			else
			{
				 var dialogHeight ='50' ;
				var dialogWidth = '37.5' ;
				var dialogTop	= '100';
				 var dialogLeft = '30' ;
			}
            finalString += "&cont_order_ind=CO&from=line&cancel_type=CN&ord_cat="+ord_cat+"&val1="+ord_cat;
		    var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
	
            var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);

			if(retVals!=null ){
			     if (top.content) {
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+retVals;
				} else {
				    alert(retVals);
				}
			}
				reloadValues();
				//document.location.reload();
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
			     if (top.content) {
					 var msg=getMessage("DATE_COMPARE","OR");
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				} else {
				    alert(getMessage("DATE_COMPARE","OR"));
				}
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}
return true;
}
function populateLocnActivityType(ord_cat,ord_type){
	//alert("1111"+ord_type.value);
	if(ord_type.value!="")
	{
	var formObj = document.result_reporting_search;
	var localeName=formObj.localeName.value;
	var validate = "";var flag;
	var bean_id = formObj.bean_id.value ;
	//clearActivityTypeList("document");
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	//xmlStr += formObj.locn.name+"=\""+ formObj.locn.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");//alert(bean_id+","+formObj.locn.value+","+formObj.order_type.value);
	validate = "activity_type";flag="true";
	xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id +"&order_category="+formObj.locn.value+"&order_type="+formObj.order_type.value+"&validate="+validate+"&flag="+flag+"&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText );
	}
	else
	{
		clearActivityTypeList("document");
	}

}
////////////////////////////////
function populateLocnOrdType(obj,defaultLocation,defaultType,defaultPerformLocn)
{
	
	
    //setLocationLabel(location_type)
	var formObj = document.result_reporting_search;
	var localeName=formObj.localeName.value;
	var validate = "";
	var bean_id = formObj.bean_id.value ;
	formObj.order_category.value = formObj.locn.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;


	if (obj == "location_type") {
		
		//alert(formObj.location_type.value);
		if( formObj.location_type.value == "" ) {
			clearList("document");
			return false;
		}
			
		xmlStr += formObj.location_type.name+"=\" "+ formObj.location_type.value +"\" " ;
		
        if (formObj.from_ca.value != '') {
        	xmlStr += "flagDefault=\""+ "true" +"\" " ;
        } else {
        	xmlStr += "flagDefault=\""+ "false" +"\" " ;
        }
		validate = "location";
	} else if (obj == "locn" && formObj.locn.value=="") {
		clearOrderTypeList("document");
	} else if (obj == "locn" && formObj.locn.value!="") {
		
		formObj.order_category.value = formObj.locn.value;
		clearActivityTypeList("document");
		
	
		/*if( formObj.locn.value == "" ) {
			clearTypeList("document");
			if (formObj.performing_location_code) {
				formObj.all.performing_locn_lbl_show.innerHTML = "&nbsp;";
				formObj.all.performing_locn_show.innerHTML = "&nbsp;";
			}
			return false;
		} else*/
		
		/* if (formObj.locn.value == "LB" && formObj.isLabInstalled_yn.value == "Y") {
		
			alert(getMessage('LAB_MODULE_INSTALLED','OR'));
			formObj.locn.value = "";
			formObj.order_category.value = "";
			return false;
		} else commented on 7/17/2007 for lab instal chk by uma */
		if (formObj.locn.value == "RD" && formObj.isRDInstalled_yn.value == "Y") {
			
			alert(getMessage('RADIOLOGY_MODULE_INSTALLED','OR'));
			formObj.locn.value = "";
			formObj.order_category.value = "";
			return false;
		}
		/*else if (formObj.locn.value == "OT" && formObj.isOTInstalled_yn.value == "Y") {
			
			alert(getMessage('OT_MODULE_INSTALLED','OR'));
			formObj.locn.value = "";
			formObj.order_category.value = "";
			return false;
		}*/ //Commented as part of IN31901
			
		xmlStr += formObj.locn.name+"=\""+ formObj.locn.value +"\" " ;
		validate = "ord_type";
	}
    xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	flag='true';
	
	xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id + "&default_val="+ encodeURIComponent(defaultLocation)+ "&default_val1="+defaultType+ "&default_val2="+ encodeURIComponent(defaultPerformLocn)+"&validate="+validate+"&flag="+flag+"&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText );
	
    if (obj == "locn") {
		
	   if (formObj.locn.value == "LB") {
	       formObj.specimen_no_lbl_show.innerHTML=getLabel("eOR.SpecimenNo.label","OR");
           //formObj.specimen_no_show.innerHTML="<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16'  onKeyPress=\"return(ChkNumberInput(this,event,'0'))\">" ;
           formObj.specimen_no_show.innerHTML="<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16'  onKeyPress=\"return(ChkNumberInput(this,event,'0'))\">" ;
           formObj.specimen_no_show.innerHTML="<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16'  onKeyPress=\"return(checkSpecimenNo(this,event))\">" ;
	   } else {
	       formObj.specimen_no_lbl_show.innerHTML="&nbsp;";
	       formObj.specimen_no_show.innerHTML="&nbsp;";
	   }
	}
}
function loadSource(){
	
	var len = eval(document.result_reporting_search.source_locn.options.length) ;
	var can_source_locn = document.result_reporting_search.can_source_locn.value ;
	for(var i=0;i<len;i++)
	{
		if(eval(document.result_reporting_search.source_locn.options[i]).value == can_source_locn) 			eval(document.result_reporting_search.source_locn.options[i]).selected = "selected";
	}
}

function addTypeList(code,value,selected) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	element.selected = selected;
	document.result_reporting_search.order_type.add(element);
}

function clearTypeList( docObj ) {
	var len = eval(docObj+".result_reporting_search.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".result_reporting_search.order_type.remove(\"atc_class_l2_code\")") ;
	}

	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".result_reporting_search.order_type.add(opt)") ;
	

}

function clearOrderTypeList(docObj){
var len = eval(docObj+".result_reporting_search.order_type.options.length") ;
for(var i=0;i<len;i++)
	{
		eval(docObj+".result_reporting_search.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".result_reporting_search.order_type.add(opt)") ;
	clearActivityTypeList("document");
}

function clearActivityTypeList( docObj ) {
	/*var len = eval(docObj+".result_reporting_search.activity_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".result_reporting_search.activity_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".result_reporting_search.activity_type.add(opt)") ;*/
	document.result_reporting_search.activity_type_desc.value= "";
	document.result_reporting_search.activity_type.value="";
}

function populateMoveLoaction1(target,code)
{
if(target.value!="")
	{
		populateMoveLoaction(target,code);
	}
	else
		parent.ResultReportingSearch.document.result_reporting_search.source_locn.value="";
}

function populateMoveLoaction(target,code)
{
	
	
	location_type=parent.ResultReportingSearch.document.result_reporting_search.source_location_type.value;
if(location_type!='')
	{
	localeName=parent.ResultReportingSearch.document.result_reporting_search.localeName.value;
	var sql="";

	if(location_type=="C")
	{
		//sql="select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(CLINIC_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.ResultReportingSearch.document.result_reporting_search.clinic_sql.value;
	}else if(location_type=="N")
	{
		//sql="select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(NURSING_UNIT_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.ResultReportingSearch.document.result_reporting_search.nursing_sql.value;
	}else if(location_type=="R")
	{
		//sql="select REFERRAL_CODE code ,LONG_DESC description from AM_REFERRAL_LANG_VW where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(REFERRAL_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.ResultReportingSearch.document.result_reporting_search.referral_sql.value;
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

	retVal = CommonLookup(getLabel("Common.SourceType.label","COMMON") , argumentArray );

	if(retVal !=null && retVal != ""){
		code.value=retVal[0];
		target.value=retVal[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
		//target.value=getLabel("Common.all.label","Common");
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
	parent.ResultReportingSearch.document.result_reporting_search.activity_type.value="";
}


function callActivitySearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.ResultReportingSearch.document.result_reporting_search.localeName.value;
	dataNameArray[0] 	= "order_category" ;		 
  	dataValueArray[0] 	= parent.ResultReportingSearch.document.result_reporting_search.locn.value;
	dataTypeArray[0] 	= STRING ;

	dataNameArray[1] 	= "order_type_code" ;		 
  	dataValueArray[1] 	= parent.ResultReportingSearch.document.result_reporting_search.order_type.value;
 	dataTypeArray[1] 	= STRING ;
	
	var sql=parent.ResultReportingSearch.document.result_reporting_search.activity_sql.value;
	sql=sql.replace('?',"'"+localeName+"'");




	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=CommonLookup(getLabel("eOR.ActivityType.label","OR"),argumentArray);

	if(retval !=null && retval != ""){
		code.value=retval[0];
		target.value=retval[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
 	}
}

function addPerformingLocnList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.result_reporting_search.performing_location_code.add(element);
}

function clearPerformingLocnList( docObj ) {
	var len = eval(docObj+".result_reporting_search.performing_location_code.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".result_reporting_search.performing_location_code.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "   ---"+getLabel("Common.defaultSelect.label","Common")+"---      " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".result_reporting_search.performing_location_code.add(opt)") ;
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

function resubmit() {
	if (document.getElementById("CancelFlag").value == "Y" || document.getElementById("from_ca").value != '') populateValues();
}

/*function getProcCode(catalog_code) {
	var proc_code = '';
	if (catalog_code != null || catalog_code != '') {
		var validate = "";
		var bean_id = formObj.bean_id.value ;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;

		xmlStr += "catalog_code=\""+ catalog_code +"\" " ;
		validate = "proc_code";

	    xmlStr +=" /></root>" ;
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "RecordProcedureValidate.jsp?bean_id=" + bean_id + "&validate="+validate, false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText );
	}
}
*/

function populateSourceLocation(source_location_type){
//	getSystemDate();

	var formObj = document.result_reporting_search;
	var localeName=formObj.localeName.value;
	if( source_location_type.value == "" ) {
		clearSourceLocationList("document");
		document.result_reporting_search.SourceSearch.disabled=true;
		document.result_reporting_search.source_locn_desc.value="";
		document.result_reporting_search.source_locn.value="";
	}
	else
	{
	var bean_id = formObj.bean_id.value ;
	document.result_reporting_search.SourceSearch.disabled=false;
	document.result_reporting_search.source_locn_desc.value="";
	document.result_reporting_search.source_locn.value="";
	/*var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlStr ="<root><SEARCH " ;
	xmlStr += source_location_type.name+"=\""+ source_location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    var flag='true';
	xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id + "&validate=source_location_type&flag="+flag+"&localeName="+localeName, false ) ;
	//alert(xmlHttp);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText)*/
	}
}

function addSourceLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  escape(code) ;
//	element.text = encodeURIComponent(value);
	element.text = value;

	document.result_reporting_search.source_locn.add(element);
}

function clearSourceLocationList( docObj ) {
	/*var len = eval(docObj+".result_reporting_search.source_locn.options.length") ;
	for(var i=0;i<len;i++) {
		eval(docObj+".result_reporting_search.source_locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".result_reporting_search.source_locn.add(opt)") ;*/
	document.result_reporting_search.source_locn.value="";
	document.result_reporting_search.source_locn_desc.value="";
}

function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".date_from")
	var toDate = eval("document."+from+".date_to")
	var localeName = eval("document."+from+".localeName")

	//if(chckDate2(obj)){ //  this method is from ValidateControl.js //Commented because of Thai Date Validations 
	if(validDateObj(obj,"DMY",localeName.value)){
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
		}
	}
	else
	{
		 parent.ResultReportingSearch.document.result_reporting_search.date_to.value= parent.ResultReportingSearch.document.result_reporting_search.temp_last_week_date.value;
	}
}

function fillTaskStatus(obj) {
	var formObj = document.result_reporting_search;
	var localeName=formObj.localeName.value;
	var bean_id = formObj.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += obj.name+"=\""+ obj.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    var flag='true';
	xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id + "&validate=TASK_STATUS&flag="+flag+"&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText )
}

function fillPerformingLocation(obj) {

    if (obj.value == "") {
        clearChangePerformLocnList('document') ;
    } else {
        var formObj = document.register_order_perform_locn;

		var localeName=formObj.localeName.value;
        var validate = "";
    	var bean_id = formObj.bean_id.value ;

    	var xmlDoc = "" ;
    	var xmlHttp = new XMLHttpRequest() ;
    	xmlStr ="<root><SEARCH " ;

        xmlStr += "performing_facility=\""+ obj.value +"\" " ;
    	xmlStr += "order_category=\""+ formObj.order_category.value +"\" " ;
    	xmlStr += "order_catalog_code=\""+ formObj.order_catalog_code.value +"\" " ;

    	validate = "CHANGE_PERFORM_LOCN";

    	xmlStr +=" /></root>" ;

    	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    	flag='true';
    	xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate="+validate+'&flag='+flag+"&localeName="+localeName, false ) ;

    	xmlHttp.send( xmlDoc ) ;
    	responseText=xmlHttp.responseText ;

    	eval(responseText )
	}
}

function addChangePerformLocnList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.register_order_perform_locn.performing_location.add(element);
}

function clearChangePerformLocnList( docObj ) {

	var len = eval(docObj+".register_order_perform_locn.performing_location.options.length") ;
	for(var i=0;i<len;i++)
	{

        eval(docObj+".register_order_perform_locn.performing_location.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "   ---"+getLabel("Common.defaultSelect.label","Common")+"---      " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;

	eval(docObj+".register_order_perform_locn.performing_location.add(opt)") ;

}

async function updateChangePerformLocn() {
    var formObj = document.register_order_perform_locn;
    var localeName=formObj.localeName.value;
	var bean_id = formObj.bean_id.value ;
	
    if (formObj.performing_facility.value == '') {

    	alert(getMessage("PERFORMING_FACILITY_BLANK","OR"));
    	return false;
    }

    /*if (formObj.performing_location.value == '') {
    	//alert("Performing Location cannot be blank...");
    	alert(getMessage("PERFORMING_LOCATION_BLANK","OR"));
    	return false;
    }*/

	eval(formApply( document.register_order_perform_locn,OR_CONTROLLER)) ;

	if (result) {
		if (message.indexOf("<br>") != -1) {
			message = message.substring(0,message.indexOf("<br>"))
		}
		alert(message);

		var bean_id = formObj.bean_id.value ;
 

    	var xmlDoc = "" ;
    	var xmlHttp = new XMLHttpRequest() ;
    	xmlStr ="<root><SEARCH " ;

        xmlStr += "order_id=\""+ formObj.order_id.value +"\" " ;

    	validate = "CHECK_INT_OR_EXT";

    	xmlStr +=" /></root>" ;

    	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    	flag='true';
    	xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate="+validate+'&flag='+flag+"&localeName="+localeName, false ) ;

    	xmlHttp.send( xmlDoc ) ;
    	responseText=xmlHttp.responseText ;

    	eval(responseText );
		
		if (formObj.int_or_ext.value == "X") {
		
			var confirmFlag = confirm(getMessage("CONFIRM_SEND","OR"));

			if (confirmFlag) {
			   var dialogHeight ='21' ;
			   var dialogWidth = '28' ;
			   var dialogTop	= '250';
			   var dialogLeft = '141' ;

		        var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

				var arguments = "";

		        var finalString	= "orderId="+ formObj.order_id.value;
		        finalString += "&order_line_num=" + formObj.order_line_num.value;
				finalString += "&performing_facility=" + formObj.performing_facility.value;
				finalString += "&performing_location=" + formObj.performing_location.value;
				finalString += "&performing_location_type=" + formObj.performing_location_type.value;
				finalString += "&encounter_id=" + formObj.encounter_id.value;
				finalString += "&sex=" + formObj.sex.value;
				finalString += "&patient_id=" + formObj.patient_id.value;
				finalString += "&priority=" + formObj.priority.value;
				finalString += "&patient_class=" + formObj.patient_class.value;
				finalString += "&order_type_code=" + formObj.order_type_code.value;
				finalString += "&source_type=" + formObj.source_type.value;
				finalString += "&source_code=" + formObj.source_code.value;
				finalString += "&bean_id=" + formObj.bean_id.value;
				finalString += "&bean_name=" + formObj.bean_name.value;



				var retVals = await window.showModalDialog("../../eOR/jsp/RegisterOrderSentOut.jsp?"+finalString,arguments,features);
			}
		}
	}
	window.close();
}

function updateSentOut() {

	var formObj = document.register_order_sent_out;
	var localeName=formObj.localeName.value;
	var ref_id = formObj.refferal_form.value
	document.register_order_sent_out.ref_form_id.value=ref_id;
	
	if (formObj.ref_facility_id.value == "") {

		alert(getMessage("REFERRAL_FACILITY_BLANK","OR"));
		formObj.ref_facility_id.focus();
		return false;
	}
	if(ref_id != "" && textSelected == "false" )
	{
		var bean_id = formObj.bean_id.value ;
		var bean_name = formObj.bean_name.value ;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		xmlStr ="<root><SEARCH " ;
		xmlStr += "ref_form_id=\""+ ref_id +"\" " ;
		validate = "SET_REF_CONTENT";
		xmlStr +=" /></root>" ;
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		flag='true';
		xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id + "&bean_name="+bean_name+"&validate="+validate+'&flag='+flag+"&localeName="+localeName, false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;

		eval(responseText )
		textSelected = "true";

	}
	eval(formApply( document.register_order_sent_out,OR_CONTROLLER)) ;
    
	if (result) {
		if (message.indexOf("<br>") != -1) {
			message = message.substring(0,message.indexOf("<br>"))
		}
		alert(message);
		if(ref_id != "")
			callPrinting();
		window.close();		
	}
	

	/*var confirmFlag = confirm("Do you want to Result?");

	if (confirmFlag) {
	}*/
}
//this is used to call printing
function callPrinting() {
    
	var bean_id=document.register_order_sent_out.bean_id.value;
	var bean_name=document.register_order_sent_out.bean_name.value;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReferralFormPrinting.jsp?bean_id=" + bean_id + "&bean_name="+bean_name, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

async function updateReceiveResult() {

	var formObj = document.register_order_receive_result;
	var localeName = formObj.document.register_order_receive_result.localeName.value;

	if (!trimCheck(formObj.ref_report_pract_id.value)) {

		alert(getMessage("REPORTING_PRACTITIONER_BLANK","OR"));
		formObj.ref_report_pract_id.focus();
		return false;
	}

	if (!trimCheck(formObj.ref_report_date_time.value)) {

		alert(getMessage("REPORTING_DATE_BLANK","OR"));
		formObj.ref_report_date_time.focus();
		return false;
	}

	//if (doDatetimeCheckAlert(formObj.ord_date_time.value,formObj.ref_report_date_time.value)) { //Commented because of Thai Date Validations
	if (!isAfter(formObj.ref_report_date_time.value,formObj.ord_date_time.value,"DMYHM",localeName)) {

		alert(getMessage("REPORTING_DATE_LESSER_ORDER_DATE","OR"));
		formObj.ref_report_date_time.focus();
		return false;
	}


	if (!trimCheck(formObj.ref_recieved_pract_id.value)) {

		alert(getMessage("RECEIVE_REPORTING_PRACTITIONER_BLANK","OR"));
		formObj.practitioner.focus();
		return false;
	}

	if (!trimCheck(formObj.ref_recieved_date_time.value)) {

		alert(getMessage("REFERRAL_RECEIVED_DATE_BLANK","OR"));
		formObj.ref_recieved_date_time.focus();
		return false;
	}

	//if (doDatetimeCheckAlert(formObj.ref_recieved_date_time.value,formObj.sys_date_time.value)) {
	if (!isAfter(formObj.sys_date_time.value,formObj.ref_recieved_date_time.value,"DMYHM",localeName)) {

		alert(getMessage("REFERRAL_RECEIVED_DATE_LESSER_SYSDATE","OR"));
		formObj.ref_recieved_date_time.focus();
		return false;
	}

	//if (doDatetimeCheckAlert(formObj.ref_report_date_time.value,formObj.ref_recieved_date_time.value)) {
	if (!isAfter(formObj.ref_recieved_date_time.value,formObj.ref_report_date_time.value,"DMYHM",localeName)) {

		alert(getMessage("REFERRAL_RECEIVED_DATE_LESSER_REPORTING_DATE","OR"));
		formObj.ref_recieved_date_time.focus();
		return false;
	}
    var finalString = formObj.qry_string.value;
	eval(formApply( document.register_order_receive_result,OR_CONTROLLER)) ;

	if (result) {
		if (message.indexOf("<br>") != -1) {
			message = message.substring(0,message.indexOf("<br>"))
		}
		alert(message);
		

		var confirmFlag = confirm(getMessage("CONFIRM_RESULT","OR"));

		if (confirmFlag) {

			var dialogHeight ='41' ;
			var dialogWidth = '55' ;
			var dialogTop	= '125';
			var dialogLeft = '10' ;

			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

			var arguments = "";

			finalString += "&func_type=EXTERNAL"+"&from=ResultReporting";
			var retVals = await window.showModalDialog("../../eOR/jsp/ResultEntry.jsp?"+finalString,arguments,features);

            /*if(retVals != ""){
				document.location.href="ReportAuthorizationQueryResult.jsp?"+document.getElementById("qry_str").value
			}*/
		}
		window.close();

	}

}

//for common look up for referral practioner
async function practitioner_display(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;


	argumentArray[0]   = document.register_order_receive_result.practitioner_code_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );

	if(retVal != null && retVal != ""){

		document.register_order_receive_result.ref_recieved_pract_id.value=retVal[0];
		target.value = retVal[1];
		//document.formExternalOrders.Referral_date.focus();
	}else{

		target.value="";
		document.register_order_receive_result.ref_recieved_pract_id.value = "";

		//document.formExternalOrders.practitioner.focus();
	}
}

function checkSpecimenNo( obj,event ) {
	var flag = CheckForSpecChars(event);

	if ((!flag) && (event.keyCode == 13)) {
 		populateValues();
 		return false;
 	} else {
 		return flag;
 	}
}

function rePopulateValues(){

	if (top.content) {
	top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	}
	var formObj = parent.parent.ResultReportingSearch.document.result_reporting_search;
	var sysDate = formObj.curr_sys_date
	var fromDate = formObj.date_from
	var toDate = formObj.date_to
	var localeName=formObj.localeName
    //order_category
    /*if(formObj.order_category.value == "")
    {
    	alert(getMessage("RESULT_REPORTING_LOCN_BLANK","OR"));
    	//top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
		parent.ResultReportingHeader.location.href = "../../eCommon/html/blank.html"
		parent.ResultReportingResult.location.href = "../../eCommon/html/blank.html"
		return false ;
    } else*/ {


	if(!(doSysDateCheck(fromDate,sysDate,top.content.messageFrame))) //Commented because of thai Date Validations 17/02/2007
	//if(!(isAfter(sysDate.value,fromDate.value,"DMY",localeName)))
		//{
		//alert(getMessage('DATE_NOT_GREATER_SYSDATE','common'));
		return false;
		//}

	if(!(doSysDateCheck(toDate,sysDate,top.content.messageFrame))) //Commented because of Thai Date validations 17/02/2007
	//if(!(isAfter(sysDate.value,toDate.value,"DMY",localeName)))
		//{
		//alert(getMessage('DATE_NOT_GREATER_SYSDATE','common'));
		return false;
		//}

	/*if(!checkDate1(toDate)){
		parent.ResultReportingHeader.location.href = "../../eCommon/html/blank.html"
		parent.ResultReportingResult.location.href = "../../eCommon/html/blank.html"
		return false ;
	}*/
	//if(doDatetimeCheckAlert(fromDate.value,toDate.value)) { //Commented because of Thai Date Validations
	if(!isAfter(toDate.value,fromDate.value,"DMY",localeName)) {
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		//top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
		if(parent.parent.ResultReportingHeader)
		{
			parent.parent.ResultReportingHeader.location.href = "../../eCommon/html/blank.html"
		}
		parent.parent.ResultReportingResult.location.href = "../../eCommon/html/blank.html"
		return false ;
	}

	qry_string = "location_type="+formObj.location_type.value+"&location="+formObj.locn.value+"&order_category="+formObj.order_category.value+"&single_multi="+formObj.single_multi.value+"&priority="+formObj.priority.value+"&date_from="+formObj.date_from.value+"&date_to="+formObj.date_to.value+"&patient_id="+formObj.patient_id.value+"&order_id="+formObj.order_id.value+"&encounter_id="+formObj.encounter_id.value+"&patient_id_found="+formObj.patient_id_found.value

	//if(formObj.practitioner_type.value!=('NS'))
		qry_string = qry_string+"&order_type="+formObj.order_type.value

	qry_string += "&catalog_desc="+formObj.catalog.value
	qry_string += "&search_criteria="+formObj.search_criteria.value
	qry_string += "&source_type="+formObj.source_location_type.value
	qry_string += "&source_location="+formObj.source_locn.value
	qry_string += "&view_by="+formObj.view_by.value
	qry_string += "&group_by="+formObj.group_by.value
	qry_string += "&task_status="+formObj.task_status.value
    qry_string += "&from_ca="+formObj.from_ca.value
    qry_string += "&performed_only="+formObj.performed_only.value

    if (formObj.specimen_no) {
	   qry_string += "&specimen_no="+formObj.specimen_no.value;
	} else {
	   qry_string += "&specimen_no=";
	}

    var flds=new Array(formObj.patient_id);
	var name=new Array("Patient ID");
	if(!SpecialCharCheck(flds,name,top.content.messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
			return false
	}

	if (parent.parent.ResultReportingSearch.document.result_reporting_search.performing_location_code) {
		qry_string += "&performing_location_code="+parent.parent.ResultReportingSearch.document.result_reporting_search.performing_location_code.value;
	} else {
		qry_string += "&peforming_location_code=";
	}
	if(parent.parent.ResultReportingHeader)
	{
		parent.parent.ResultReportingHeader.location.href = "../jsp/ResultReportingHeader.jsp?&patient_id_found="+formObj.patient_id_found.value+"&view_by="+formObj.view_by.value
	}
	parent.parent.ResultReportingResult.location.href = "../jsp/ResultReportingResultFrameset.jsp?"+qry_string
	//parent.parent.parent.messageframe.location.href= "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	//parent.ResultReportingBtn.location.href = "../jsp/ResultReportingBtn.jsp"
	}
}
function showRefusalText(target)
{	
	textSelected = "false";
	if(target.value == "")
	{
		refusal_text.innerHTML="";
	}
	else
	{
		refusal_text.innerHTML="<a class='gridLink' href='#'  onClick='showRefusalDesc()'>'"+getLabel('eOR.ReferralText.label','OR')+"'</a>";
		//refusal_text.innerHTML="<a href='#'>Refusal Text</a>";
	}
}
async function showRefusalDesc()
{
	var id = document.register_order_sent_out.refferal_form.value;
	document.register_order_sent_out.ref_form_id.value=id;

	var dialogHeight= "30" ;
	var dialogWidth	= "43" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status:"+status+";dialogTop :" + dialogTop;
	var arguments	= "" ;
	
	var retVal = await window.showModalDialog("../../eOR/jsp/RegisterRefusalText.jsp?id="+id+"&textSelected="+textSelected,arguments,features);
	textSelected = "true";
}
function setContent()
{
 	textSelected = "true";
	var formObj = document.formRefusalText;
	eval(formApply(formObj,"RegisterRefusalTextTemp.jsp"));
	window.close();

}

 
function callResultEntry(obj){
	var final_string = document.ResultFrameForm.query_string.value+"&called_from="+obj;
  	parent.ResultReportingSearch.location.href =  "ResultReportingSearch.jsp?"+final_string;
	if(parent.ResultReportingHeader)
	{
 		parent.ResultReportingHeader.location.href =  "../../eCommon/html/blank.html";
	}
 	parent.ResultReportingResult.location.href =  "../../eCommon/html/blank.html";
}
 

function reloadValues(){
	if (top.content) {
		top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	}
	if(parent.parent.ResultReportingSearch)
	var formObj		= parent.parent.ResultReportingSearch.document.result_reporting_search;
	else
	var formObj		= parent.ResultReportingSearch.document.result_reporting_search;
	var sysDate		= formObj.curr_sys_date
	var fromDate	= formObj.date_from
	var toDate  	= formObj.date_to
	if(fromDate.value==""){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
		return false
	}
	if(toDate.value==""){
		alert(getMessage("TO_DT_NOT_BLANK","SM"));
		return false
	}
   qry_string = "location_type="+formObj.location_type.value+"&location="+formObj.locn.value+"&order_category="+formObj.order_category.value+"&single_multi="+formObj.single_multi.value+"&priority="+formObj.priority.value+"&date_from="+formObj.date_from.value+"&date_to="+formObj.date_to.value+"&patient_id="+formObj.patient_id.value+"&order_id="+formObj.order_id.value+"&encounter_id="+formObj.encounter_id.value+"&patient_id_found="+formObj.patient_id_found.value+"&activity_type="+formObj.activity_type.value;
   qry_string = qry_string+"&order_type="+formObj.order_type.value
   qry_string += "&catalog_desc="+formObj.catalog.value
   qry_string += "&search_criteria="+formObj.search_criteria.value
   qry_string += "&source_type="+formObj.source_location_type.value
   qry_string += "&source_location="+formObj.source_locn.value
   qry_string += "&view_by="+formObj.view_by.value
   qry_string += "&group_by="+formObj.group_by.value
   qry_string += "&task_status="+formObj.task_status.value
   qry_string += "&from_ca="+formObj.from_ca.value
  if(formObj.performed_only.checked)
		performed_only='Y';
	else
		performed_only='N';
	qry_string += "&performed_only="+performed_only

    if (formObj.specimen_no) {
	   qry_string += "&specimen_no="+formObj.specimen_no.value;
	} else {
	   qry_string += "&specimen_no=";
	}
 	if (formObj.performing_location_code) {
		qry_string += "&performing_location_code="+formObj.performing_location_code.value;
	} else {
		qry_string += "&peforming_location_code=";
	}
 	
 	if(parent.parent.frames[2].document.querySelectorAll('called_from').value=="Coding") {
		parent.ResultReportingResult.location.reload();
		parent.ResultReportingResult.location.href = "../jsp/ResultCodingQueryResult.jsp?"+qry_string
	}else{
 		parent.parent.ResultReportingResult.location.href = "../jsp/ResultReportingResultFrameset.jsp?"+qry_string
	}
}

/*function RecordProcedure(){

	var formObj = parent.proc_detail.document.result_entry_proclink

	var bean_id = "Or_ResultReporting" ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += "order_id=\""+ order_id +"\" " ;
    //xmlStr += obj.name+"=\""+ obj.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=chart_updation&flag=true", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	


	eval(responseText )


}*/
async function procedureLink(orderId,order_type_code,patient_id,patient_class,encounter_id,order_line_num)
{
	var arguments = "";
 	var dialogHeight		= '30';
	var dialogWidth			= '40';
	var dialogTop			= '231';
	var dialogLeft			= '213' ;
	var title				= ''
	var features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
 	var finalString			= "orderId="+ orderId+"&order_type_code="+order_type_code+"&called_from=Coding&patient_id="+patient_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&orderLineNum="+order_line_num;
 	retVals = await window.showModalDialog("../../eOR/jsp/ResultEntryProcedureLinkFrameset.jsp?"+finalString,arguments,features);
	//parent.ResultReportingSearch.location.reload();
	if(retVals != "" && retVals != null)
		alert(getMessage("RECORD_MODIFIED","SM"));
	
	reloadValues();
	//parent.ResultReportingResult.location.reload();
}

/*function validPatient (obj) {
	var formObj = document.result_reporting_search

	var bean_id = formObj.bean_id1.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
    xmlStr += obj.name+"=\""+ obj.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PatientValidate.jsp?bean_id=" + bean_id, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText )
}

function addPatientList (patient_id,valid) {
	if (valid == "Y") {
		alert("Valid Patient");
		document.result_reporting_search.patient_id.value = patient_id;
	} else {
  		document.result_reporting_search.patient_id.value = patient_id;
	}
}*/
//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}*/

function chckDate(Object2,focusflag)
{
var localeName=	parent.ResultReportingSearch.document.result_reporting_search.localeName.value
//if(CheckDate(Object2,focusflag)==false)// Commented because of Thai Date Validations
if(!validDateObj(Object2,"DMY",localeName))// thai date validations 17/02/2007. function from DateUtils.js
	{
	 parent.ResultReportingSearch.document.result_reporting_search.date_from.value= parent.ResultReportingSearch.document.result_reporting_search.temp_last_week_date.value;
	}
}

/*function chckDate2(Object2)// Commented because of Thai Date Validations on 17th Feb 2007
{
if(CheckDate(Object2)==false)
	{
	 parent.ResultReportingSearch.document.result_reporting_search.date_to.value= parent.ResultReportingSearch.document.result_reporting_search.temp_last_week_date.value;
	}
}*/

function populateperformingSearch(target,code)
{
	
	if(target.value!="")
			callperformingSearch(target,code);
	else
		code.value="";
	
}

function callperformingSearch(target,code)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var performing_deptloc_type="";
	if(parent.ResultReportingSearch.document.result_reporting_search.order_category.value=="RX")
	{
		 performing_deptloc_type="I";
	}else if(parent.ResultReportingSearch.document.result_reporting_search.order_category.value=="RD")
	{
		performing_deptloc_type="R";
	}
	else if(parent.ResultReportingSearch.document.result_reporting_search.order_category.value=="LB")
	{
		performing_deptloc_type="L";
	}
	else if(parent.ResultReportingSearch.document.result_reporting_search.order_category.value=="MI")
	{
		performing_deptloc_type="M";
	}
	else if(parent.ResultReportingSearch.document.result_reporting_search.order_category.value=="TR")
	{
		performing_deptloc_type="T";
	}else if(parent.ResultReportingSearch.document.result_reporting_search.order_category.value=="PC")
	{
		performing_deptloc_type="P";
	}
	localeName=parent.ResultReportingSearch.document.result_reporting_search.localeName.value;
	dataNameArray[0] 	= "performing_deptloc_type" ;		 
  	dataValueArray[0] 	= performing_deptloc_type;
 	dataTypeArray[0] 	= STRING ;
	dataNameArray[1] 	= "performing_facility_id" ;		 
  	dataValueArray[1] 	= parent.ResultReportingSearch.document.result_reporting_search.facility_id.value;
 	dataTypeArray[1] 	= STRING ;
	
	var sql=parent.ResultReportingSearch.document.result_reporting_search.performing_sql.value;
	
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=CommonLookup(getLabel("Common.PerformingLocation.label","COMMON"),argumentArray);

	if(retval !=null && retval != ""){
		code.value=retval[0];
		target.value=retval[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
		target.value="";
 	}
}

function taskValue(obj)
{
	parent.ResultReportingSearch.document.result_reporting_search.taskCode.value=obj.value;
}

function alignHeading()
{

	if(parent.parent.ResultReportingHeader.document.getElementById("tableheader")!=null)
	{
				parent.parent.ResultReportingHeader.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				for (j=0; j < document.getElementById("tableresult").rows(1).cells.length; j++) 
				{
					var wid=eval(document.getElementById("tableresult").rows(1).cells(j).offsetWidth);
					
					if(parent.parent.ResultReportingHeader.document.getElementById("tableheader").rows(0).cells(j) != null)
					{
						parent.parent.ResultReportingHeader.document.getElementById("tableheader").rows(0).cells(j).width=wid;
					}
				}
		}
		
	}
	function alignCodingHeading()
{
	if(parent.ResultReportingHeader.document.getElementById("tableheader")!=null)
	{
				parent.ResultReportingHeader.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				for (j=0; j < document.getElementById("tableresult").rows(2).cells.length; j++) 
				{
					var wid=eval(document.getElementById("tableresult").rows(2).cells(j).offsetWidth);
					
					if(parent.ResultReportingHeader.document.getElementById("tableheader").rows(0).cells(j) != null)
					{
						parent.ResultReportingHeader.document.getElementById("tableheader").rows(0).cells(j).width=wid;
					}
				}
		}
		
	}

	function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.parent.ResultReportingHeader.location.href.indexOf(".jsp") != -1)
	{
		parent.parent.ResultReportingHeader.document.body.scrollLeft=temp;
	}
}

function moveHeaderFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.ResultReportingHeader.location.href.indexOf(".jsp") != -1)
	{
		parent.ResultReportingHeader.document.body.scrollLeft=temp;
	}
}
//Added By Arvind on 21/05/2010 
function fnResetDates(obj){
	if (obj.checked)
	{	
		document.result_reporting_search.date_from.value=document.result_reporting_search.from_period_mod_rslt_completed.value;	
		document.result_reporting_search.date_from.readOnly=true;
		document.result_reporting_search.date_to.readOnly=true;
		document.getElementById("fromCal").disabled=true;
		document.getElementById("toCal").disabled=true;
		
	}else{
		document.result_reporting_search.date_from.value=document.result_reporting_search.temp_last_week_date.value;		
		document.result_reporting_search.date_from.readOnly=false;
		document.result_reporting_search.date_to.readOnly=false;
		document.getElementById("fromCal").disabled=false;
		document.getElementById("toCal").disabled=false;		
	}
}

