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
var invalidCode = "" ;
var qry_string = "";
var qry_string_fr_print = "";

function populateLocation(location_type){
	if(location_type.value == "C"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.clinic.label","Common")
	} else if(location_type.value == "W"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.nursingUnit.label","Common")
	} else if(location_type.value == "D"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.DaycareUnit.label","Common")
	} else if(location_type.value == "E"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.EmergencyUnits.label","Common")
	} else if(location_type.value == "R"){
		document.getElementById("id_locn").innerHTML = getLabel("eOR.referralunits.label","OR")
	} else {
		document.getElementById("id_locn").innerHTML = getLabel("Common.Location.label","Common")
	}


	var formObj = document.aspl_apprv_order
	if( location_type.value == "" ) {
		clearList("document")
	}
	var bean_id = document.aspl_apprv_order.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SpecialApprovalOrdersValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=ord_cat", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )


}

function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.aspl_apprv_order.locn.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".aspl_apprv_order.locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".aspl_apprv_order.locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".aspl_apprv_order.locn.add(opt)") ;
}


//this fucntion is used to clear the entries of search criteria
function resetValues(){
	document.aspl_apprv_order.search_btn.disabled = false;
	document.aspl_apprv_order.reset();
	document.getElementById("id_locn").innerHTML = getLabel("Common.patientId.label","Common")
	parent.SpecialApprovalOrdersBottom.document.location.href="../../eCommon/html/blank.html"

}


// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll(){
	//if(document.spl_apprv_order_hdg.select_all.checked == true){
	if(document.getElementById("select_all").checked == true){
		if(parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl ){
		for(cnt=0; cnt<parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.total_recs.value; cnt++){
			val = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.chk"+cnt);
			val.checked = true;
		}}
	}else{
		if(parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl ){
		for(cnt=0; cnt<parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.total_recs.value; cnt++){
			val = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.chk"+cnt);
			val.checked = false;
		}
	}
	}
}

function clearChecked(){
	parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.reset()
	//parent.SpecialApprovalOrdersBottomRight0.document.spl_apprv_order_hdg.reset()
}



function splApprove(){
	
	var locn_type = parent.parent.parent.frames[0].document.aspl_apprv_order.location_type.value
	var locn = parent.parent.parent.frames[0].document.aspl_apprv_order.locn.value
	var patientId=parent.parent.parent.frames[0].document.aspl_apprv_order.patientId.value
	var period_from=parent.parent.parent.frames[0].document.aspl_apprv_order.period_from.value
	var period_to=parent.parent.parent.frames[0].document.aspl_apprv_order.period_to.value

	qry_string = "../jsp/SpecialApprovalOrdersBottom.jsp?location_type="+locn_type+"&locn="+locn+"&patientId="+patientId+"&period_from="+period_from+"&period_to="+period_to;

	var no_of_checked = 0;
	var formObj = parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl
	var arguments = "";

	var bean_id = parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.bean_id.value ;

	//var xmlDocs = new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttpp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc = "";
			xmlStr ="<root><SEARCH " ;
	incr=0;
	flag = false
	for(cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.chk"+cnt);
		patient_class = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.patient_class"+cnt);
		priority = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.priority"+cnt);
		ord_id = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.ord_id"+cnt);
		ord_typ_code = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.ord_typ_code"+cnt);
		ord_catalog = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.ord_catalog"+cnt);
		ord_consent_yn = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.ord_consent_yn"+cnt);
		cont_order_ind = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.cont_order_ind"+cnt);
		ord_appr_by_user_id = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.ord_appr_by_user_id"+cnt);
		ord_appr_reqd_yn = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.ord_appr_reqd_yn"+cnt);
		order_category = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.order_category"+cnt);
		ord_consent_reqd_yn = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.ord_consent_reqd_yn"+cnt);
		ord_consent_by_id = eval("parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl.ord_consent_by_id"+cnt);


		if(val.checked == true){
			no_of_checked++;
		}
	}

	if(parseInt(no_of_checked) == 0){
		alert(getMessage('CLICK_ANY_ONE','OR'));
		return false
	}
//alert("eeeeee");
		xmlStr = "";
		eval(formApply( parent.SpecialApprovalOrdersBottomRight1.document.spl_apprv_order_dtl,OR_CONTROLLER)) ;
		//top.frames[1].frames[3].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		/*if( getMessage(message,"OR") != "" ){ //"OR_STATUS_CHANGED"
			eval("parent.SpecialApprovalOrdersBottomRight1.document.getElementById("status")"+invalidCode).className="orcancel";
			alert(getMessage(message,"OR"));
			return false;
		}else*/
		if(top.content){
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		}
		else
	{
			if(message!="" && message!=null)
			alert(message);
			window.close();
	}
		if( result ) {
			onSuccess();
		}

}

function authoriseSpecial(){

	eval(formApply( parent.SplApprvlTop.document.spl_auth,OR_CONTROLLER)) ;

	if( result ) {
		alert(getMessage("RECORD_MODIFIED","SM" ))
		onSuccess();
	}
}


function assignResult(_result, _message, _flag, _invalidCode){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _invalidCode;
}

function onSuccess() {
    callPrinting();
	parent.parent.parent.frames[1].location.href=qry_string
}

//onClick="callMenuFunctions('view','view','<%=register_details[2]%>')"
async function callMenuFunctions(colval1,colval,orderId,sex,patient_id,encounter_id,patient_class){

		var dialogHeight ='90vh' ;//37/5
		var dialogWidth = '65vw' ;//50
		var dialogTop	= '10px';//100
		var dialogLeft = '30' ;//30

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&encounter_id="+ encounter_id+"&patient_class="+ patient_class;
	//	alert(finalString)
		var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);



}


// patient ID search
async function callPatientSearch(){
	var pat_id = await PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}

//this is used to call printing
function callPrinting() {
    var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	//xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert('incallPrinting()');
	xmlHttp.open( "POST", "SpecialApprovalOrdersPrinting.jsp", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}

//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}
*/
function checkDateRange(obj,from,fmt,localeName){

	var fromDate = eval("document."+from+".period_from")
	var toDate = eval("document."+from+".period_to")
	var localeName=localeName;
	//if(chckDate2(obj)){ //  this method is from ValidateControl.js
	if(validDateObj(obj,"DMY",localeName)){
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			//obj.focus()
			return false
		}
	}else{
		parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.period_to.value=parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.temp_last_week_date.value;
	}
}
function populateValues(){
	
	if (top.content) {
	top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	}
	var formObj = parent.SpecialApprovalOrdersTop.document.aspl_apprv_order;
	var fromDate = formObj.period_from
	var toDate = formObj.period_to
	
	if(!trimCheck(fromDate.value)){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
		parent.SpecialApprovalOrdersBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!trimCheck(toDate.value)){
		alert(getMessage("TO_DT_NOT_BLANK","SM"));
		parent.SpecialApprovalOrdersBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}
	if(!isAfter(toDate.value,fromDate.value,"DMY",formObj.localeName.value)){//this function is available in eCommon/js/DateUtils.js
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		parent.SpecialApprovalOrdersBottom.location.href = "../../eCommon/html/blank.html"
		return false ;
	}
	/*
		Added by kishore kumar N on 02-05-2010,
		Validating date for better tuning.
	*/

	var ptID = formObj.patientId.value;
	var locale = formObj.localeName.value;

	if(ptID == '' && !dateRangeValidation(fromDate, toDate, locale, '7', 'DMY'))
	{
		parent.SpecialApprovalOrdersBottom.location.href = "../../eCommon/html/blank.html";
		alert(getMessage("VALIDATE_DATE_ON_SEARCH", "OR"));
	}
	else
	{
		document.aspl_apprv_order.search_btn.disabled = true;
		document.aspl_apprv_order.submit();
	}
	/*
		ends here.
	*/
	
}

async function populateLoaction(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	/*dataNameArray[0] = "PRACTITIONER_ID";
	dataValueArray[0] = document.aspl_apprv_order.practitioner_id.value;
	dataTypeArray[0] = STRING;
//alert(document.aspl_apprv_order.practitioner_id.value+"=="+document.aspl_apprv_order.location_type.value+"=="+document.aspl_apprv_order.facility_id.value);
	dataNameArray[1] = "PATIENT_CLASS";
	dataValueArray[1] = document.aspl_apprv_order.location_type.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "FACILITY_ID";
	dataValueArray[2] = document.aspl_apprv_order.facility_id.value;
	dataTypeArray[2] = STRING;*/

/*	 dataNameArray[0] = "PRACTITIONER_ID";
	dataValueArray[0] = document.aspl_apprv_order.practitioner_id.value;
	dataTypeArray[0] = STRING;

	 dataNameArray[1] = "PRACTITIONER_ID";
	dataValueArray[1] = document.aspl_apprv_order.practitioner_id.value;
	dataTypeArray[1] = STRING;   */
	 
	/*dataNameArray[2] = "PATIENT_CLASS";
	dataValueArray[2] = document.aspl_apprv_order.location_type.value;
	dataTypeArray[2] = STRING;
	*/
	location_type	  = document.aspl_apprv_order.location_type.value
	// Decode the value and then pass as a value to the query
	if(location_type!=null && location_type=="C")
	   location_type	= "OP";
	else if(location_type!=null && location_type=="D")
	   location_type	= "DC";
	else if(location_type!=null && location_type=="E")
	   location_type	= "EM";
	else if(location_type!=null && location_type=="W")
	   location_type	= "IP";
 	dataNameArray[0] = "PATIENT_CLASS";
	dataValueArray[0] = location_type;
	dataTypeArray[0] = STRING;
	
	dataNameArray[1] = "FACILITY_ID";
	dataValueArray[1] = document.aspl_apprv_order.facility_id.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "FACILITY_ID";
	dataValueArray[2] = document.aspl_apprv_order.facility_id.value;
	dataTypeArray[2] = STRING;  

	//if(document.aspl_apprv_order.location_type.value !="")
	//	target.value='';

	//dataNameArray[0] = "R";
	//dataValueArray[0] = document.aspl_apprv_order.location_type.value;
	//dataTypeArray[0] = STRING;

	var localeName=document.aspl_apprv_order.localeName.value;
	var sql=document.aspl_apprv_order.location_sql.value;

	for(var x=0;x<5;x++)
	{
		sql=sql.replace('?',"'"+localeName+"'");
	}
	sql=sql.replace('?',"'"+document.aspl_apprv_order.practitioner_id.value+"'");

	/*Added by Uma on 12/7/2010 for IN025361*/
	if(location_type!=null && location_type=="D")
	{
		sql = sql.replace("##FILTER##"," and CLINIC_TYPE='Y' ");
	}
	else if(location_type!=null && location_type=="E")
	{
		sql = sql.replace("##FILTER##"," and CLINIC_TYPE='C' AND LEVEL_OF_CARE_IND='E' ");
	}
	else if(location_type!=null && location_type=="C")
	{
		sql = sql.replace("##FILTER##"," and CLINIC_TYPE='C' AND LEVEL_OF_CARE_IND='A' ");
	}
	else
	{
		sql = sql.replace("##FILTER##"," ");
	}
	/*Ends Here*/

	argumentArray[0]=sql;
	
	//argumentArray[0]   = document.aspl_apprv_order.location_sql.value

	//alert(argumentArray[0]);
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "4,5";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
//alert(retVal[0]+"=="+retVal[1]);
	var ret1=unescape(retVal);
				var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
	if(retVal != null && retVal != ""){
		document.aspl_apprv_order.locn.value=arr[0];
		target.value = arr[1];
	}else{
		//alert('in');
		target.value="All";
		document.aspl_apprv_order.locn.value = "";
	}
}


function chckDate(Object2,focusflag,localeName)
{
if(validDateObj(Object2,"DMY",localeName)==false)
	{
	parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.period_from.value=parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.temp_curr_week_date.value;
	}
}


/*function chckDate2(Object2)
{
if(CheckDate(Object2)==false)
	{
	parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.period_to.value=parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.temp_last_week_date.value;
	}
}*/
function ondetail()
{
	//if(parent.SpecialApprovalOrdersBottomRight0.document.spl_apprv_order_hdg)
	//{
		//if(parent.SpecialApprovalOrdersBottomRight0.document.spl_apprv_order_hdg.select_all)
		//{
			if(document.getElementById("select_all"))
			{
				//parent.SpecialApprovalOrdersBottomRight0.document.spl_apprv_order_hdg.select_all.disabled=false;
				document.getElementById("select_all").disabled=false;
			}
		//}
	//}
}

async function callBilling(row_value,order_id,patient_id,performing_facility_id,encounter_id,patient_class,order_category,sex,colval1,colval,order_set_id)
{
	var dialogTop   = "10px";//300
	var dialogLeft   = "30";//30
	var dialogHeight= "90vh" ;//45
	var dialogWidth = "70vw" ;//60
	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +';dialogLeft:'+dialogLeft +'; scroll=yes; status=no';

	var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+order_category;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&row_value=" + row_value;
		//finalString += "&location_details=" + location_details;
		//finalString += "&priority=" + Priority;
		finalString += "&patient_class=" + patient_class;
		//finalString += "&order_type_code=" + order_type_code;
		//finalString += "&source_type=" + source_type;
		//finalString += "&source_code=" + source_code;
		finalString += "&orderId=" + order_id;
		finalString += "&performing_facility_id=" + performing_facility_id;
		finalString += "&order_set_id=" + order_set_id;
	var arguments	= "";
	var retVal 			=  await top.window.showModalDialog("../../eOR/jsp/OrderEntryBillingFrameset.jsp?"+finalString,arguments,features);
}

function alignHeading()
{

	if(parent.SpecialApprovalOrdersBottomRight0.document.getElementById("tableheader")!=null)
	{
				parent.SpecialApprovalOrdersBottomRight0.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				if(document.getElementById("tableresult").rows(1))
				{
					for (j=0; j < document.getElementById("tableresult").rows(1).cells.length; j++) 
					{
						var wid=eval(document.getElementById("tableresult").rows(1).cells(j).offsetWidth);
						
						if(parent.SpecialApprovalOrdersBottomRight0.document.getElementById("tableheader").rows(0).cells(j) != null)
						{
							parent.SpecialApprovalOrdersBottomRight0.document.getElementById("tableheader").rows(0).cells(j).width=wid;
						}
					}
				}
		}
		
	}

	function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.SpecialApprovalOrdersBottomRight0.location.href.indexOf(".jsp") != -1)
	{
		parent.SpecialApprovalOrdersBottomRight0.document.body.scrollLeft=temp;
	}
}

async function callPatientHistory(patient_id)
{
		var dialogHeight ='95vh' ;
		var dialogWidth = '70vw' ;
		var dialogTop	= '10px';
		var dialogLeft = '30' ;


		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		var ammend_called_from="existing_order";
 		var retVals =await top.window.showModalDialog("../../eCA/jsp/EncounterInDialog.jsp?patient_id="+patient_id+"&called_from=OR",arguments,features);
}
function dummy()
{
}

function hideToolTip()	
{
	  document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

