/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id	= "" ;
var result 		= false;
var message		= "" ;
var flag 		= "" ;
var qry_string 	= "";

function query() {
	f_query_add_mod.location.href='../../eOR/jsp/DispenseFrame.jsp?function_id='+function_id ;
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

function populateLocation(location_type)
{
	setLocationLabel(location_type)
	var formObj = document.dispense_search
	if( location_type.value == "" ) {
		clearList("document")
	}
	var bean_id = formObj.bean_id.value ;
	var bean_name = formObj.bean_name.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispenseValidate.jsp?bean_id=" + bean_id + "&bean_name="+bean_name+"&default_val=''&validate=ord_cat", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )
}

function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.dispense_search.locn.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".dispense_search.locn.options.length") ; 
	for(var i=0;i<len;i++)
	{
		eval(docObj+".dispense_search.locn.remove(\"locn\")") ;
	}
	var tp = getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".dispense_search.locn.add(opt)") ;
}

//this fucntion is used to clear the entries of search criteria
function resetValues(){
}


//this is used for patient ID search
async function callPatientSearch(){
	var pat_id = await PatientSearch();

	if(pat_id != null)
	document.getElementById("patient_id").value = pat_id;							
}

//called on click of search
function populateValues(){
	var formObj;

	if(document.dispense_search)
	{
		formObj 	= document.dispense_search;
	}
	else if(parent.DispenseSearch.dispense_search)
	{
		formObj 	= parent.DispenseSearch.dispense_search;
	}

	if(formObj)
	{

		var sysDate 	= formObj.curr_sys_date
		var fromDate 	= formObj.date_from
		var toDate 	    = formObj.date_to

		if(fromDate.value == "")
		{
			alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
			fromDate.focus();
			return false;
		}

		if(toDate.value == ""){
			alert(getMessage("TO_DT_NOT_BLANK","SM"));
			toDate.focus();
			return false;
		}

		if(!isAfter(toDate.value,fromDate.value,"DMY", formObj.localeName.value))//this function is available in eCommon/js/DateUtils.js
		{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				parent.DispenseResult.location.href = "../../eCommon/html/blank.html"
				return false ;
		}

		if(!(doSysDateCheck(fromDate,sysDate,parent.parent.parent.messageframe)))
			return false
		if(!(doSysDateCheck(toDate,sysDate,parent.parent.parent.messageframe)))
			return false
		/*
			Added by kishore kumar N on 02-05-2010,
			Validating date for better tuning.
		*/

		var ptID = formObj.patient_id.value;
		var encounterID = formObj.encounter_id.value;
		var orderID = formObj.order_id.value;
		var locale = formObj.localeName.value;

		if((ptID == '' && orderID == '' && encounterID == '') && 
			!dateRangeValidation(fromDate, toDate, locale, '7', 'DMY'))
		{
			parent.DispenseResult.location.href = "../../eCommon/html/blank.html";
			alert(getMessage("VALIDATE_DATE_ON_SEARCH_WITH_ENC_ORDER", "OR"));
		}
		else
		{
			qry_string = "bean_id="+formObj.bean_id.value+"&bean_name="+formObj.bean_name.value+"&location_type="+formObj.location_type.value+"&location="+formObj.locn.value+"&order_category="+formObj.order_category.value+"&single_multi="+formObj.single_multi.value+"&priority="+formObj.priority.value+"&date_from="+formObj.date_from.value+"&date_to="+formObj.date_to.value+"&patient_id="+formObj.patient_id.value+"&order_id="+formObj.order_id.value+"&encounter_id="+formObj.encounter_id.value+"&patient_id_found="+formObj.patient_id_found.value+"&patient_class="+formObj.patient_class.value;
			if(formObj.practitioner_type.value==('PH'))
				qry_string = qry_string+"&order_type="+formObj.order_type.value
				
			parent.DispenseHeader.location.href = "../jsp/DispenseHeader.jsp?&patient_id_found="+formObj.patient_id_found.value
			parent.DispenseResult.location.href = "../jsp/DispenseQueryResult.jsp?"+qry_string
		}

		/*
			ends here.
		*/

	}
}

//called on click of clear button in search criteria
function clearValues(){
	document.dispense_search.reset();
	setLocationLabel(document.dispense_search.location_type);
	parent.DispenseHeader.location.href = "../../eCommon/html/blank.html"
	parent.DispenseResult.location.href = "../../eCommon/html/blank.html"
}


function checkDate(obj){
	if(!(trimCheck(obj.value))) 
	{
		obj.value = "";
		return false;
	}
	if(!(checkDt(obj.value))){
		alert(getMessage("INVALID_DATE_FMT","OR"));
		//obj.select();
		obj.value="";
		obj.focus();
		return false;
	}
}

function checkDate1(obj){
	var dt = new Date()
	var formObj = document.dispense_search
	var fromDate = formObj.date_from
	var toDate = formObj.date_to
	if(!(trimCheck(obj.value))) 
	{
		obj.value = "";
		return false;
	}
	if(!(checkDt(obj.value))){
		alert(getMessage("INVALID_DATE_FMT","OR"));
		//obj.select();
		obj.value="";
		obj.focus();
		return false;
	}
	if(!(doDateCheck(fromDate,toDate,parent.parent.parent.messageframe)))
		return false
}

async function callMenuFunctions(colval1,colval,orderId,order_category){
		var dialogHeight ='90vh' ;
		var dialogWidth = '85vw' ;
		var dialogTop	= '10';
		var dialogLeft = '100' ; 
	
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		
		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&ord_cat="+order_category+"&perform_from=COMPLETE_MEDICATION";
		var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		if(colval1 == "Completion"){
			//parent.DispenseResult.location.reload()
			populateValues();
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
					top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=APP-SM0012 - Date should be less than or equal to System Date";		
				} else {
					alert(getMessage('DATE_LESS_SYS_DATE','OR'));
				}
				
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)){
				if (top.content) {
					top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
				}
				return true;
			}
	}	
return true;
}

function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".date_from")
	var toDate = eval("document."+from+".date_to")
		var localeName = eval("document."+from+".localeName")
	//if(chckDate2(obj)){ //  this method is from ValidateControl.js
	if(validDateObj(obj,"DMY",localeName)){// function in DateUtils.js added for thai date validations
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js// removed on 14/02/2007 while doing thai date validations
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			//obj.focus()
			return false
		}
	}else{
		document.dispense_search.date_to.value=document.dispense_search.curr_sys_date.value;
	}
}

function chckDate(Object2,focusflag)
{
	var localeName = document.dispense_search.localeName.value
//if(CheckDate(Object2,focusflag)==false)// revomed while thai date validations
if(validDateObj(Object2,"DMY",localeName)==false)// thai date validations 16/02/2007. function from DateUtils.js
	{	document.dispense_search.date_from.value=document.dispense_search.tempdate.value;
	}
}
