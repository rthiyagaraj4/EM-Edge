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
		document.getElementById("id_locn").innerHTML = getLabel("eCA.DayCareUnits.label","CA")
	} else if(location_type.value == "E"){
		document.getElementById("id_locn").innerHTML = getLabel("eCA.EmergencyUnits.label","CA")
	} else if(location_type.value == "R"){
		document.getElementById("id_locn").innerHTML = getLabel("eOR.referralunits.label","OR")
	} else {
		document.getElementById("id_locn").innerHTML = getLabel("Common.Location.label","Common")
	}

	var formObj = document.cosign_order
	if( location_type.value == "" ) {
		clearList("document")
	}
	var bean_id = document.cosign_order.bean_id.value ;
	var localeName=document.cosign_order.localeName.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsignOrdersValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=ord_cat&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )


}
async function populateLoaction(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	/*dataNameArray[0] = "PRACTITIONER_ID";
	dataValueArray[0] = document.cosign_order.practitioner_id.value;
	dataTypeArray[0] = STRING;
//alert(document.consent_order.practitioner_id.value+"=="+document.consent_order.location_type.value+"=="+document.consent_order.facility_id.value);
	dataNameArray[1] = "PATIENT_CLASS";
	dataValueArray[1] = document.cosign_order.location_type.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "FACILITY_ID";
	dataValueArray[2] = document.cosign_order.facility_id.value;
	dataTypeArray[2] = STRING;*/

	//if(document.consent_order.location_type.value !="")
	//	target.value='';

	//dataNameArray[0] = "R";
	//dataValueArray[0] = document.consent_order.location_type.value;
	//dataTypeArray[0] = STRING;
/*	 dataNameArray[0] = "PRACTITIONER_ID";
	dataValueArray[0] = document.cosign_order.practitioner_id.value;
	dataTypeArray[0] = STRING;

	 dataNameArray[1] = "PRACTITIONER_ID";
	dataValueArray[1] = document.cosign_order.practitioner_id.value;
	dataTypeArray[1] = STRING;  */
	 
	/*dataNameArray[2] = "PATIENT_CLASS";
	dataValueArray[2] = document.cosign_order.location_type.value;
	dataTypeArray[2] = STRING;
	*/
	location_type	  = document.cosign_order.location_type.value
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
	dataValueArray[1] = document.cosign_order.facility_id.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "FACILITY_ID";
	dataValueArray[2] = document.cosign_order.facility_id.value;
	dataTypeArray[2] = STRING;  
	
	var localeName=document.cosign_order.localeName.value;
	var sql=document.cosign_order.location_sql.value;

	for(var x=0;x<5;x++)
	{
		sql=sql.replace('?',"'"+localeName+"'");
	}

	sql=sql.replace('?',"'"+document.cosign_order.practitioner_id.value+"'");
	
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

	//argumentArray[0]   = document.cosign_order.location_sql.value

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
	if(retVal != null && retVal != ""){
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.cosign_order.locn.value=arr[0];
		target.value = arr[1];
	}else{
		//alert('in');
		target.value=getLabel("Common.all.label","Common");
		document.cosign_order.locn.value = "";
	}
}
function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.cosign_order.locn.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".cosign_order.locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".cosign_order.locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".cosign_order.locn.add(opt)") ;
}


//this fucntion is used to clear the entries of search criteria
function resetValues(){
	document.cosign_order.reset();
	document.getElementById("locn").value = '';
	document.getElementById("id_locn").innerHTML = getLabel("Common.patientId.label","Common")
	parent.CosignOrderBottom.document.location.href="../../eCommon/html/blank.html"

}


// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll(){
	//if(document.cosign_order_hdg.select_all.checked == true){
	if(document.getElementById("select_all").checked == true){
		for(cnt=0; cnt<parent.CosignOrdersBottomRight1.document.cosign_order_dtl.total_recs.value; cnt++){
			val = eval("parent.CosignOrdersBottomRight1.document.cosign_order_dtl.chk"+cnt);
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<parent.CosignOrdersBottomRight1.document.cosign_order_dtl.total_recs.value; cnt++){
			val = eval("parent.CosignOrdersBottomRight1.document.cosign_order_dtl.chk"+cnt);
			val.checked = false;
		}
	}
}

function clearChecked(){
	parent.CosignOrdersBottomRight1.document.cosign_order_dtl.reset()
	//parent.CosignOrdersBottomRight0.document.cosign_order_hdg.reset()
}



function authorise(){
	var locn_type = parent.parent.parent.frames[0].document.cosign_order.location_type.value
	var locn = parent.parent.parent.frames[0].document.cosign_order.locn.value
	var patientId=parent.parent.parent.frames[0].document.cosign_order.patientId.value
	var period_from=parent.parent.parent.frames[0].document.cosign_order.period_from.value
	var period_to=parent.parent.parent.frames[0].document.cosign_order.period_to.value

	qry_string = "../jsp/CosignOrdersBottom.jsp?location_type="+locn_type+"&locn="+locn+"&patientId="+patientId+"&period_from="+period_from+"&period_to="+period_to;

	var no_of_checked = 0;
	var formObj = parent.CosignOrdersBottomRight1.document.cosign_order_dtl
	for(cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("parent.CosignOrdersBottomRight1.document.cosign_order_dtl.chk"+cnt);
		patient_class = eval("parent.CosignOrdersBottomRight1.document.cosign_order_dtl.patient_class"+cnt);
		priority = eval("parent.CosignOrdersBottomRight1.document.cosign_order_dtl.priority"+cnt);
		ord_id = eval("parent.CosignOrdersBottomRight1.document.cosign_order_dtl.ord_id"+cnt);
		ord_typ_code = eval("parent.CosignOrdersBottomRight1.document.cosign_order_dtl.ord_typ_code"+cnt);

		if(val.checked == true){
			no_of_checked++;
		//			qry_string_fr_print += "&ord_id"+cnt+"="+ord_id.value+"&ord_typ_code"+cnt+"="+ord_typ_code.value+"&priority"+cnt+"="+priority.value+"&patient_class"+cnt+"="+patient_class.value
		}
	}


//	qry_string_fr_print = qry_string_fr_print+"&locn_type="+locn_type+"&locn="+locn;
	//alert(">"+qry_string_fr_print )
	if(parseInt(no_of_checked) == 0){
		alert(getMessage('CLICK_ANY_ONE','OR'));
		return false
	}

		eval(formApply( parent.CosignOrdersBottomRight1.document.cosign_order_dtl,OR_CONTROLLER)) ;


		//top.frames[1].frames[3].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if (top.content) {

			//alert("message========="+message);
			
			//if(message in orMessageArray){ //"OR_STATUS_CHANGED"
			/*if( getMessage(message,"OR") != "" ){ //"OR_STATUS_CHANGED"
				eval("parent.CosignOrdersBottomRight1.document.getElementById("status")"+invalidCode).className="orcancel";
				alert(getMessage(message,"OR"));
				return false;
			}else8*/
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		} else {
			/*if( getMessage(message,"OR") != "" )
					message = getMessage(message,"OR");
			else{
				var index =0;
				index = message.lastIndexOf(".");
				message = message.substring(0,index);
			}*/
			if(message!="" && message!=null)
			alert(message);
			window.close();
		}
		if( result ) {
//			alert("APP-SM0002 Operation Completed Successfully ..." ) // this will display "operation compelted successfully" - message
			onSuccess();
		}else{
			alert(message)
		}
}

function assignResult(_result, _message, _flag, _code){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _code ;
}

function onSuccess() {

		parent.parent.parent.frames[1].location.href=qry_string
		//qry_string_fr_print = qry_string_fr_print.substr(1,qry_string_fr_print.length)
		//alert(qry_string_fr_print)
		//window.open("OnlinePrinting.jsp?"+qry_string_fr_print,"Test","height=200,width=400,status=no,toolbar=no,menubar=no,location=yes")
		//qry_string_fr_print = "";
}



async function callMenuFunctions(colval1,colval,orderId,sex,patient_id,encounter_id,patient_class){

		var dialogHeight ='90vh' ;
		var dialogWidth = '60vw' ;
		var dialogTop	= '100';
		var dialogLeft = '100' ;

       //alert("hai"+colval1);
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&encounter_id="+ encounter_id+"&patient_class="+ patient_class;
//		alert(finalString)
		var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}
// patient ID search
async function callPatientSearch(){
	var pat_id =  await PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}


//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}
*/

function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".period_from")
	var toDate = eval("document."+from+".period_to")
	var localeName = eval("document."+from+".localeName")
	//if(chckDate2(obj)){ //  this method is from ValidateControl.js

	if(validDateObj(obj,"DMY",localeName.value))
	{
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){// this function is available in eOR/js/orCommonFunctions.js
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			//obj.focus()
			return false
		}
	}

else
{

parent.CosignOrderTop.document.cosign_order.period_to.value=parent.CosignOrderTop.document.cosign_order.temp_last_week_date.value;
}
}
function populateValues(){
	
	if (top.content) {
	top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	}
	var formObj = parent.CosignOrderTop.document.cosign_order;
	var fromDate = formObj.period_from
	var toDate = formObj.period_to
	
	if(!trimCheck(fromDate.value)){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
		parent.CosignOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!trimCheck(toDate.value)){
		alert(getMessage("TO_DT_NOT_BLANK","SM"));
		parent.CosignOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}

	//if(doDateCheckOR(fromDate,toDate) == 1) {//this is commented for thai dates

     if(!isAfter(toDate.value,fromDate.value,"DMY",formObj.localeName.value)){
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		parent.CosignOrderBottom.location.href = "../../eCommon/html/blank.html"
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
		parent.CosignOrderBottom.location.href = "../../eCommon/html/blank.html";
		alert(getMessage("VALIDATE_DATE_ON_SEARCH", "OR"));
	}
	else
	{
		document.cosign_order.search_btn.disabled = true;
		document.cosign_order.action="CosignOrdersBottom.jsp";
		document.cosign_order.target="CosignOrderBottom";
		document.cosign_order.submit();
	}
	/*
		ends here.
	*/
}

function chckDate(Object2,focusflag)
{
	var localeName = parent.CosignOrderTop.document.cosign_order.localeName.value;
	
//if(CheckDate(Object2,focusflag)==false)// removed while  thai date validations 16/02/2007
  if(validDateObj(Object2,"DMY",localeName)==false)
	{
	parent.CosignOrderTop.document.cosign_order.period_from.value=parent.CosignOrderTop.document.cosign_order.temp_curr_week_date.value;
	}
}
/*removed on 14/02/2007 while doing Thai date validations
function chckDate2(Object2)
{
if(CheckDate(Object2)==false)
	{
	parent.CosignOrderTop.document.cosign_order.period_to.value=parent.CosignOrderTop.document.cosign_order.temp_last_week_date.value;
	}
}*/

function alignHeading()
{

	if(parent.CosignOrdersBottomRight0.document.getElementById("tableheader")!=null)
	{
				parent.CosignOrdersBottomRight0.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				for (j=0; j < document.getElementById("tableresult").rows(1).cells.length; j++) 
				{
					var wid=eval(document.getElementById("tableresult").rows(1).cells(j).offsetWidth);
					
					if(parent.CosignOrdersBottomRight0.document.getElementById("tableheader").rows(0).cells(j) != null)
					{
						parent.CosignOrdersBottomRight0.document.getElementById("tableheader").rows(0).cells(j).width=wid;
					}
				}
		}
		
	}

	function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.CosignOrdersBottomRight0.location.href.indexOf(".jsp") != -1)
	{
		parent.CosignOrdersBottomRight0.document.body.scrollLeft=temp;
	}
}

