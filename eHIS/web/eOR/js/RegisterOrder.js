/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
-------------------------------------------------------------------------------------------------------------------------------
15/12/2017	IN065942		Dinesh T			15/12/2017		Ramesh G		In Nuclear medicine  department we required the 																				barcode functionality at the time of 																						Registration of order,required patient 																						Id,patient name,age,sex,register date and name 																				of study.
23/04/2020	IN071618	    Nijitha S	 										PMG2019-MMS-CRF-0004
-------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var invalidCode = "" ;
var qry_string = "";
var textSelected = "false";

function clearActivityTypeList( docObj ) {
	var len = eval(docObj+".register_order_search.activity_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".register_order_search.activity_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     ---"+getLabel("Common.all.label","Common")+"---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".register_order_search.activity_type.add(opt)") ;
}
function populateLocnActivityType(){
	
	var formObj = document.register_order_search;
	var localeName=document.register_order_search.localeName.value;
	login_value=parent.RegisterOrderSearch.document.register_order_search.cat_value.value;
	var validate = "";var flag;
	var bean_id = formObj.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	validate = "activity_type";
	xmlHttp.open( "POST", "RegisterOrderValidate.jsp?bean_id="+bean_id+"&login_value="+login_value+"&order_category="+formObj.ord_cat.value+"&order_type="+formObj.order_type.value+"&validate="+validate+"&flag=true&localeName="+localeName, false ) ;
	
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText );

}
function addActivityList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.register_order_search.activity_type.add(element);
}

function populateLocation(location_type){
//	getSystemDate();
	if(location_type.value == "C"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.clinic.label","Common")
	} else 	if(location_type.value == "N"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.nursingUnit.label","Common")
	} else 	if(location_type.value == "R"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.referral.label","Common")
	} else {
		document.getElementById("id_locn").innerHTML = getLabel("Common.Location.label","Common")
	}


	var formObj = document.register_order_search;
	var localeName=formObj.localeName.value;
	if( location_type.value == "" ) {
		//clearList("document")
	}
	var bean_id = document.register_order_search.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegisterOrderValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=location&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText )


}


function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.register_order_search.locn.add(element);
}

/*function clearList( docObj ) {
	var len = eval(docObj+".register_order_search.locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".register_order_search.locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".register_order_search.locn.add(opt)") ;
}*/
function populateMvLoaction(target,code)
{
	if(trimString(target.value).length>0)
	{
		
			populateMoveLoaction(target,code);
		
	}
	if(target.value=="")
		code.value="";
}
async function populateMoveLoaction(target,code){
	
	location_type=parent.RegisterOrderSearch.document.register_order_search.location_type.value;
if(location_type!='')
	{
	localeName=parent.RegisterOrderSearch.document.register_order_search.localeName.value;
	var sql="";

	if(location_type=="C")
	{
		//sql="select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(CLINIC_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.RegisterOrderSearch.document.register_order_search.clinic_sql.value;
	}else if(location_type=="N")
	{
		//sql="select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(NURSING_UNIT_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.RegisterOrderSearch.document.register_order_search.nursing_sql.value;
	}else if(location_type=="R")
	{
		//sql="select REFERRAL_CODE code ,LONG_DESC description from AM_REFERRAL_LANG_VW where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(REFERRAL_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.RegisterOrderSearch.document.register_order_search.referral_sql.value;
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

	retVal = await CommonLookup(getLabel("Common.SourceType.label","COMMON") , argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal !=null && retVal != ""){
		code.value=arr[0];
		target.value=arr[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
		//target.value=getLabel("Common.all.label","Common");
 	}
	}
	
}


//this fucntion is used to clear the entries of search criteria
function resetValues(){
}


//this is used for patient ID search
async function callPatientSearch(){
	var pat_id =  await PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}


//called on click of search
function populateValues(){

 
top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	var sysDate = parent.RegisterOrderSearch.document.register_order_search.curr_sys_date
	var fromDate = parent.RegisterOrderSearch.document.register_order_search.date_from
	var toDate = parent.RegisterOrderSearch.document.register_order_search.date_to
	var formObj=parent.RegisterOrderSearch.document.register_order_search;
	/*if(parent.RegisterOrderSearch.document.register_order_search.order_category.value == ""){
    	alert(getMessage("ORDER_CATEGORY","OR"));
    	//top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
		parent.RegisterOrderHeader.location.href='../../eCommon/html/blank.html';
		parent.RegisterOrderResult.location.href='../../eCommon/html/blank.html';
		parent.RegisterOrderBtn.location.href='../../eCommon/html/blank.html';
    } else {*/

if(!trimCheck(fromDate.value)){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
		if(parent.RegisterOrderHeader)
		{
			parent.RegisterOrderHeader.location.href='../../eCommon/html/blank.html';
		}
		parent.RegisterOrderResult.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!trimCheck(toDate.value)){
		alert(getMessage("TO_DT_NOT_BLANK","SM"));
		if(parent.RegisterOrderHeader)
		{
			parent.RegisterOrderHeader.location.href='../../eCommon/html/blank.html';
		}
		parent.RegisterOrderResult.location.href = "../../eCommon/html/blank.html"
		return false
	}

	//if(doDateCheckOR(fromDate,toDate) == 1) { //Commented because of Thai Date Validations
	if(!isAfter(toDate.value,fromDate.value,"DMY",formObj.localeName.value)){//this function is available in eCommon/js/DateUtils.js
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		//top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
		if(parent.RegisterOrderHeader)
		{
			parent.RegisterOrderHeader.location.href='../../eCommon/html/blank.html';
		}
		parent.RegisterOrderResult.location.href='../../eCommon/html/blank.html';
		parent.RegisterOrderBtn.location.href='../../eCommon/html/blank.html';
		return false;
	}
	
	if((formObj.patientId.value=="")&&(formObj.order_no.value==""))
	{	
		var days=daysBetween(fromDate.value,toDate.value,"DMY",formObj.localeName.value);

		if(parent.RegisterOrderSearch.document.register_order_search.order_category.value!= "")
		{  
			
			if(days>30)
			{
				alert(getMessage("REGORDER_SEARCH_VALIDATE","OR"));
				if(parent.RegisterOrderHeader)
				{
					parent.RegisterOrderHeader.location.href='../../eCommon/html/blank.html';
				}
				parent.RegisterOrderResult.location.href='../../eCommon/html/blank.html';
				parent.RegisterOrderBtn.location.href='../../eCommon/html/blank.html';
				return false;
			}
		}else
		{
			if(days>7)
			{
				alert(getMessage("REGORDER_SEARCH_VALIDATE","OR"));
				if(parent.RegisterOrderHeader)
				{
					parent.RegisterOrderHeader.location.href='../../eCommon/html/blank.html';
				}
				parent.RegisterOrderResult.location.href='../../eCommon/html/blank.html';
				parent.RegisterOrderBtn.location.href='../../eCommon/html/blank.html';
				return false;
			}
		}

	}
	qry_string = "view_by="+parent.RegisterOrderSearch.document.register_order_search.view_by.value+"&ord_cat="+parent.RegisterOrderSearch.document.register_order_search.order_category.value+"&single_multi="+parent.RegisterOrderSearch.document.register_order_search.single_multi.value+"&ord_type="+parent.RegisterOrderSearch.document.register_order_search.order_type.value+"&priority="+parent.RegisterOrderSearch.document.register_order_search.priority.value+"&location_type="+parent.RegisterOrderSearch.document.register_order_search.location_type.value+"&locn="+parent.RegisterOrderSearch.document.register_order_search.locn.value+"&patientId="+parent.RegisterOrderSearch.document.register_order_search.patientId.value+"&encntr_id="+parent.RegisterOrderSearch.document.register_order_search.encntr_id.value+"&order_no="+parent.RegisterOrderSearch.document.register_order_search.order_no.value+"&date_from="+parent.RegisterOrderSearch.document.register_order_search.date_from.value+"&date_to="+parent.RegisterOrderSearch.document.register_order_search.date_to.value+"&activity_type="+parent.RegisterOrderSearch.document.register_order_search.activity_type.value ;

	if (parent.RegisterOrderSearch.document.register_order_search.performing_location_code) {
		qry_string += "&performing_location_code="+parent.RegisterOrderSearch.document.register_order_search.performing_location_code.value;

	} else {
		qry_string += "&peforming_location_code=";

	}
	if (parent.RegisterOrderSearch.document.register_order_search.int_or_ext) {
	   qry_string += "&int_or_ext="+parent.RegisterOrderSearch.document.register_order_search.int_or_ext.value;
	} else {
	   qry_string += "&int_or_ext=";
	}
	if (parent.RegisterOrderSearch.document.register_order_search.specimen_no) {
	   qry_string += "&specimen_no="+parent.RegisterOrderSearch.document.register_order_search.specimen_no.value;
	} else {
	   qry_string += "&specimen_no=";
	}
	if (parent.RegisterOrderSearch.document.register_order_search.cat_value) {
	   qry_string += "&login_value="+parent.RegisterOrderSearch.document.register_order_search.cat_value.value;
	}
	

	parent.RegisterOrderSearch.document.register_order_search.search_btn.disabled = true;
	//parent.RegisterOrderHeader.location.href = "../jsp/RegisterOrderHeader.jsp"
	parent.RegisterOrderResult.location.href = "../jsp/RegisterOrderResults.jsp?"+qry_string
	parent.RegisterOrderBtn.location.href = "../jsp/RegisterOrderBtn.jsp"
	//}
}

//called on click of clear button in search criteria
function clearValues(){
	//document.register_order_search.reset();
	parent.RegisterOrderSearch.location.reload();
	//parent.RegisterOrderHeader.location.href = "../../eCommon/html/blank.html"
	parent.RegisterOrderResult.location.href = "../../eCommon/html/blank.html"
	parent.RegisterOrderBtn.location.href = "../../eCommon/html/blank.html"
}


// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll(){
	//if(document.register_order_hdg.select_all.checked == true){
	if(document.getElementById("select_all").checked == true){
		for(cnt=0; cnt<parent.RegisterOrderResult.document.register_order_dtl.total_recs.value; cnt++){
			val = eval("parent.RegisterOrderResult.document.register_order_dtl.chk"+cnt);
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<parent.RegisterOrderResult.document.register_order_dtl.total_recs.value; cnt++){
			val = eval("parent.RegisterOrderResult.document.register_order_dtl.chk"+cnt);
			val.checked = false;
		}
	}
}

function clearChecked(){
	//parent.RegisterOrderHeader.document.register_order_hdg.reset()
	parent.RegisterOrderResult.document.register_order_dtl.reset()
}


/*function checkDateRange(obj){ //Commented on 16th feb because no where this function is in use

	var fromDate = document.register_order_search.date_from
	var toDate = document.register_order_search.date_to
	var localeName=document.register_order_search.localeName.value;

	//if(CheckDate(obj)){ //  this method is from ValidateControl.js //Commented on 16th Feb for Date Validations
if(validDateObj(obj,"DMY",localeName.value)){// function in DateUtils.js added for thai date validations
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js // removed on 14/02/2007 while doing thai date validations
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
		}
	}
	else
	{
		parent.RegisterOrderSearch.document.register_order_search.date_to.value= parent.RegisterOrderSearch.document.register_order_search.temp_last_week_date.value;
	}
}*/


function registerOrder(){
	
	//parent.RegisterOrderBtn.document.register_order_btn.register.disabled=true;
	var view_by = parent.RegisterOrderSearch.document.register_order_search.view_by.value
	var order_category = parent.RegisterOrderSearch.document.register_order_search.order_category.value
	var single_multi = parent.RegisterOrderSearch.document.register_order_search.single_multi.value
	var ord_type = parent.RegisterOrderSearch.document.register_order_search.order_type.value
	var priority = parent.RegisterOrderSearch.document.register_order_search.priority.value
	var location_type = parent.RegisterOrderSearch.document.register_order_search.location_type.value
	var locn = parent.RegisterOrderSearch.document.register_order_search.locn.value
	var patientId = parent.RegisterOrderSearch.document.register_order_search.patientId.value
	var encntr_id = parent.RegisterOrderSearch.document.register_order_search.encntr_id.value
	var order_no = parent.RegisterOrderSearch.document.register_order_search.order_no.value
	var date_from = parent.RegisterOrderSearch.document.register_order_search.date_from.value
	var date_to = parent.RegisterOrderSearch.document.register_order_search.date_to.value
	var login_value = parent.RegisterOrderSearch.document.register_order_search.cat_value.value

	qry_string = "view_by="+view_by+"&ord_cat="+order_category+"&single_multi="+single_multi+"&ord_type="+ord_type+"&priority="+priority+"&location_type="+location_type+"&locn="+locn+"&patientId="+patientId+"&encntr_id="+encntr_id+"&order_no="+escape(order_no)+"&date_from="+date_from+"&date_to="+date_to+"&login_value="+login_value;


	var no_of_checked = 0;

	var formObj = parent.RegisterOrderResult.document.register_order_dtl;
	for(cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("parent.RegisterOrderResult.document.register_order_dtl.chk"+cnt);
		
		if(val.checked == true){
		
			no_of_checked++;
			var ord_consent_status = eval("parent.RegisterOrderResult.document.register_order_dtl.ord_consent_status"+cnt).value;
			if(ord_consent_status == "P"){

				alert(getMessage("CONSENT_TO_BE_OBTAINED","OR"));
				val.checked = false;
				return false;	
			}
		}
	}

	if(parseInt(no_of_checked) == 0){
		alert(getMessage('CLICK_ANY_ONE','OR'));
		return false
	}
		
		parent.RegisterOrderBtn.document.register_order_btn.register.disabled=true;		
		eval(formApply( parent.RegisterOrderResult.document.register_order_dtl,OR_CONTROLLER)) ;		

		parent.RegisterOrderBtn.document.register_order_btn.register.disabled=false;
		
		
		if( result ) {
			prnRegLabel();//IN065942
			onSuccess();
		}

		if( invalidCode != "" && invalidCode!=null ){ //"OR_STATUS_CHANGED"
			var invalidArray = invalidCode.split(",");
			for(key in invalidArray)
				eval("parent.RegisterOrderResult.document.getElementById('status')"+invalidArray[key]).className="orcancel";
				alert(message);
			//alert(getMessage(message,'OR'));
			return false;
		}else
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		
		
				
		
}

function assignResult(_result, _message, _flag, _code){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _code ;

}

function onSuccess(input) {//IN071618
	//parent.RegisterOrderSearch.document.register_order_search.reset()
	//IN071618 Starts
	//parent.RegisterOrderResult.location.href="../jsp/RegisterOrderResults.jsp?"+qry_string
	//top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	if("Y" ==input)
	{
		populateValues()
	}
	else{
		parent.RegisterOrderResult.location.href="../jsp/RegisterOrderResults.jsp?"+qry_string
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}//IN071618 ENDS

}

//onClick="callMenuFunctions('view','view','<%=register_details[2]%>')"
async function callMenuFunctions(colval1,order_category,colval,orderId,sex,patient_id,order_line_num,performing_facility,performing_location_type,performing_location,encounter_id,int_or_ext,priority,patient_class,order_type_code,source_type,source_code,dob){

    var bean_id = parent.RegisterOrderResult.document.register_order_dtl.bean_id.value;
    var bean_name = parent.RegisterOrderResult.document.register_order_dtl.bean_name.value;

	if (colval1 == "View") {
		var dialogHeight ='90vh' ;
		var dialogWidth = '70vw' ;
		var dialogTop	= '10';
		var dialogLeft = '30' ;
    } else if (colval1 == "ChangePerformLocn") {
         var dialogHeight ='26vh' ;
		var dialogWidth = '24vw' ;
		var dialogTop	= '10';
		var dialogLeft = '10' ;
    }
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";

		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+order_category;
		if (colval1 != "SentOut" && colval1 != "ReceiveResult" ) 
		{
			finalString += "&order_line_num="+order_line_num;
		}
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
		

        if (colval1 == "View") {
		  var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		}
		if (colval1 == "ChangePerformLocn") {
			finalString += "&bean_id=" + bean_id;
			finalString += "&bean_name=" + bean_name;

			var retVals = await top.window.showModalDialog("../../eOR/jsp/RegisterOrderPerformLocn.jsp?"+finalString,arguments,features);
			populateValues();
        }
		if (colval1 == "SentOut") {
			finalString += "&bean_id=" + bean_id;
			finalString += "&bean_name=" + bean_name;

			var dialogHeight ='21' ;
			var dialogWidth = '28' ;
			var dialogTop	= '250';
			var dialogLeft = '141' ;

			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

			var retVals = await window.showModalDialog("../../eOR/jsp/RegisterOrderSentOut.jsp?"+finalString,arguments,features);
			populateValues();
        }
		if (colval1 == "ReceiveResult") {
			finalString += "&bean_id=" + bean_id;
			finalString += "&bean_name=" + bean_name;

			var dialogHeight ='23' ;
			var dialogWidth = '30' ;
			var dialogTop	= '129';
			var dialogLeft = '71' ;
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		  var retVals = await window.showModalDialog("../../eOR/jsp/RegisterOrderReceiveResult.jsp?"+finalString,arguments,features);
		  populateValues();
		}
        
		//document.register_order_dtl.reset();
}


/*function doSysDateCheck(from,to,messageFrame) { //Commented  because no where this function is used as on 16th feb
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) < Date.parse(fromdt)) {
				var tmp=getMessage("DATE_LESS_SYS_DATE","OR");
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+tmp;
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}
return true;
}*/
////////////////////////////////
function populateLocnOrdType1(obj)
{

	//setLocationLabel(location_type)
	var formObj = document.register_order_search
	var localeName=formObj.localeName.value;
	var validate = "";
	var bean_id = formObj.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;

	if (obj == "order_category") {

		/*if( formObj.ord_cat.value == "" ) {
			clearList("document");
			return false;
		}*/
        xmlStr += formObj.ord_cat.name+"=\""+ formObj.ord_cat.value +"\" " ;

		validate = "ord_cat";
		parent.RegisterOrderSearch.document.register_order_search.activity_type.value="";
		parent.RegisterOrderSearch.document.register_order_search.activity_type_desc.value="";//getLabel("Common.all.label","Common");
	} 
	login_value=parent.RegisterOrderSearch.document.register_order_search.cat_value.value;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	flag='true';
	xmlHttp.open( "POST", "RegisterOrderValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate="+validate+"&flag="+flag+"&localeName="+localeName+"&login_value="+login_value, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText );
	
	   if (formObj.ord_cat.value == "LB") {
	       formObj.specimen_no_lbl_show.innerHTML=getLabel("eOR.SpecimenNo.label","OR");
           //formObj.specimen_no_show.innerHTML="&nbsp;<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16'  onKeyPress=\"return(ChkNumberInput(this,event,'0'))\">" ;
           formObj.specimen_no_show.innerHTML="<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16'  onKeyPress=\"return(ChkNumberInput(this,event,'0'))\">" ;
           formObj.specimen_no_show.innerHTML="<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16'  onKeyPress=\"return(checkSpecimenNo(this,event))\">" ;
	   } else {
	       formObj.specimen_no_lbl_show.innerHTML="&nbsp;";
	       formObj.specimen_no_show.innerHTML="&nbsp;";
	   }
	
}

function populateLocnOrdType(obj)
{

	//setLocationLabel(location_type)
	var formObj = document.register_order_search
	var localeName=formObj.localeName.value;
	var validate = "";
	var bean_id = formObj.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;


	if (obj == "order_category") {

		/*if( formObj.ord_cat.value == "" ) {
			clearList("document");
			return false;
		}*/
        xmlStr += formObj.ord_cat.name+"=\""+ formObj.ord_cat.value +"\" " ;

		validate = "ord_cat";
		parent.RegisterOrderSearch.document.register_order_search.activity_type.value="";
		parent.RegisterOrderSearch.document.register_order_search.activity_type_desc.value="";//getLabel("Common.all.label","Common");
		
	} else if (obj == "ord_type") {
		parent.RegisterOrderSearch.document.register_order_search.activity_type.value="";
		parent.RegisterOrderSearch.document.register_order_search.activity_type_desc.value="";//getLabel("Common.all.label","Common");
		formObj.order_category.value = formObj.ord_cat.value;
		parent.RegisterOrderSearch.document.register_order_search.performing_location_code.value="";
		parent.RegisterOrderSearch.document.register_order_search.performing_type_desc.value="";//getLabel("Common.all.label","Common");


		/*if( formObj.ord_cat.value == "" ) {
			clearTypeList("document");
			if (formObj.performing_location_code) {
				formObj.all.performing_locn_lbl_show.innerHTML = "&nbsp;";
				formObj.all.performing_locn_show.innerHTML = "&nbsp;";
			}
			return false;
		} else 
		
		/*if (formObj.ord_cat.value == "LB" && formObj.isLabInstalled_yn.value == "Y") {
			alert(getMessage('LAB_MODULE_INSTALLED','OR'));
			formObj.ord_cat.value = "";
			formObj.order_category.value = "";
			return false;
		} else commented on 7/17/2007 for allowing lab orders */
			
		/*if (formObj.ord_cat.value == "RD" && formObj.isRDInstalled_yn.value == "Y") {
			alert(getMessage('RADIOLOGY_MODULE_INSTALLED','OR'));
			formObj.ord_cat.value = "";
			formObj.order_category.value = "";
			//return false;
		}else if (formObj.ord_cat.value == "OT" && formObj.isOTInstalled_yn.value == "Y") {
			alert(getMessage('OT_MODULE_INSTALLED','OR'));
			formObj.ord_cat.value = "";
			formObj.order_category.value = "";
			//return false;
		}*/
		xmlStr += formObj.ord_cat.name+"=\""+ formObj.ord_cat.value +"\" " ;
		validate = "ord_type";
	
	}
	login_value=parent.RegisterOrderSearch.document.register_order_search.cat_value.value;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	flag='true';
	xmlHttp.open( "POST", "RegisterOrderValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate="+validate+"&flag="+flag+"&localeName="+localeName+"&login_value="+login_value, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
	if (obj == "ord_type") {
	   if (formObj.ord_cat.value == "LB") {
		   document.getElementById('specimen_no_lbl_show').innerHTML=getLabel("eOR.SpecimenNo.label","OR");
           //formObj.all.specimen_no_show.innerHTML="&nbsp;<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16'  onKeyPress=\"return(ChkNumberInput(this,event,'0'))\">" ;
		   document.getElementById('specimen_no_show').innerHTML="<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16'  onKeyPress=\"return(ChkNumberInput(this,event,'0'))\">" ;
		   document.getElementById('specimen_no_show').innerHTML="<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16'  onKeyPress=\"return(checkSpecimenNo(this,event))\">" ;
	   } else {
		   document.getElementById('specimen_no_lbl_show').innerHTML="&nbsp;";
		   document.getElementById('specimen_no_show').innerHTML="&nbsp;";
	   }
	}
}

function addTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.register_order_search.order_type.add(element);
}

function clearTypeList( docObj ) {
	var len = eval(docObj+".register_order_search.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".register_order_search.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".register_order_search.order_type.add(opt)") ;
}

function addPerformingLocnList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.register_order_search.performing_location_code.add(element);
}

function clearPerformingLocnList( docObj ) {
	var len = eval(docObj+".register_order_search.performing_location_code.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".register_order_search.performing_location_code.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "   ---"+getLabel("Common.defaultSelect.label","Common")+"---      " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".register_order_search.performing_location_code.add(opt)") ;
}

function addCategoryList(code,value,selected) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	element.selected = selected;
	document.register_order_search.ord_cat.add(element);
}

function clearCategoryList( docObj ) {
	var len = eval(docObj+".register_order_search.ord_cat.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".register_order_search.ord_cat.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "    ---"+getLabel("Common.defaultSelect.label","Common")+"---    " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".register_order_search.ord_cat.add(opt)") ;
}

function checkValidDateTime(obj){ 
	var localeName = eval("document."+from+".localeName")
	if(obj.value!='')
	{
			if(!validDateObj(obj,"DMY",localeName.value))
	    	{
	    		alert(getMessage("INVALID_DATE_TIME","SM"));
	    		obj.select();
	    	}
    }
}

function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".date_from")
	var toDate = eval("document."+from+".date_to")
	var localeName = eval("document."+from+".localeName")

	//if(chckDate2(obj)){ //  this method is from ValidateControl.js //  this method is from ValidateControl.js //Commented on 16th Feb for Date Validations
	if(validDateObj(obj,"DMY",localeName.value)){
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js // removed on 14/02/2007 while doing thai date validations
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
		}
	}
	else
	{
		parent.RegisterOrderSearch.document.register_order_search.date_to.value= parent.RegisterOrderSearch.document.register_order_search.temp_last_week_date.value;
	}
}

function showIntOrExt(obj) {

    var formObj = parent.RegisterOrderSearch.register_order_search;
    var localeName=formObj.localeName.value;


    var validate = "";
	var bean_id = formObj.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;


	xmlStr += "order_category=\""+ formObj.order_category.value +"\" " ;
	xmlStr += "perform_locn=\""+ obj.value +"\" " ;
	validate = "PERFORM_LOCN_INT_OR_EXT";

	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	flag='true';
	xmlHttp.open( "POST", "RegisterOrderValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate="+validate+'&flag='+flag+"&localeName="+localeName, false ) ;

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
    	xmlHttp.open( "POST", "RegisterOrderValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate="+validate+'&flag='+flag+"&localeName="+localeName, false ) ;

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

function enableOK(obj) {

	var formObj = document.register_order_perform_locn;

	if(obj.name == "performing_facility" && obj.value != "" && obj.value != formObj.perf_facility.value)
		formObj.ok_but.disabled = false;
	else if(obj.name == "performing_location" && obj.value != "" && obj.value != formObj.perf_location.value)
		formObj.ok_but.disabled = false;
	else
		formObj.ok_but.disabled = true;
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
    	xmlHttp.open( "POST", "RegisterOrderValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate="+validate+"&flag="+flag+"&localeName="+localeName, false ) ;

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
				finalString += "&order_category=" + formObj.order_category.value;
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
	//window.close();
	parent.document.getElementById('dialog_tag').close();
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
	if( ref_id != "" && textSelected == "false" )
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
		xmlHttp.open( "POST", "RegisterOrderValidate.jsp?bean_id=" + bean_id + "&bean_name="+bean_name+"&validate="+validate+'&flag='+flag+"&localeName="+localeName, false ) ;

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

	//if (doDatetimeCheckAlert(formObj.ord_date_time.value,formObj.ref_report_date_time.value)) { //Commented because of Thai Date Validations 17/02/2007
	if (!isAfter(formObj.ref_report_date_time.value,formObj.ord_date_time.value,"DMYHM",localeName)) {
		alert(getMessage("REPORTING_DATE_LESSER_ORDER_DATE","OR"));
		formObj.ref_report_date_time.focus();
		return false;
	}

	//alert(formObj.ref_recieved_pract_id.value);
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

	//if (doDatetimeCheckAlert(formObj.ref_recieved_date_time.value,formObj.sys_date_time.value)) { //Commented because of Thai Date Validations 17/02/2007
	if (!isAfter(formObj.sys_date_time.value,formObj.ref_recieved_date_time.value,"DMYHM",localeName)) {

		alert(getMessage("REFERRAL_RECEIVED_DATE_LESSER_SYSDATE","OR"));
		formObj.ref_recieved_date_time.focus();
		return false;
	}

	//if (doDatetimeCheckAlert(formObj.ref_report_date_time.value,formObj.ref_recieved_date_time.value)) {  //Commented because of Thai Date Validations 17/02/2007
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

			var dialogHeight ='52' ;
			var dialogWidth = '70' ;
			var dialogTop	= '90';
			var dialogLeft = '10' ;

			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

			var arguments = "";

			finalString += "&func_type=EXTERNAL";

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
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != ""){

		document.register_order_receive_result.ref_recieved_pract_id.value=arr[0];
		target.value = arr[1];
		//document.formExternalOrders.Referral_date.focus();
	}else{

		target.value="";
		document.register_order_receive_result.ref_recieved_pract_id.value = "";

		//document.formExternalOrders.practitioner.focus();
	}
}

async function chkSentOut(sent_out_flag,order_category,colval,orderId,patient_id,sex,order_line_num,performing_facility,performing_location_type,performing_location,encounter_id,int_or_ext,priority,patient_class,order_type_code,dob) {
	var bean_id = parent.RegisterOrderResult.document.register_order_dtl.bean_id.value;
    var bean_name = parent.RegisterOrderResult.document.register_order_dtl.bean_name.value;
	if (sent_out_flag == 'S') {

		var arguments = "";

        var finalString	= "colval1="+"SentOut"+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+order_category+"&order_line_num="+order_line_num;
		finalString += "&performing_facility=" + performing_facility;
		finalString += "&performing_location=" + performing_location;
		finalString += "&performing_location_type=" + performing_location_type;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&int_or_ext=" + int_or_ext;
		finalString += "&priority=" + priority;
		finalString += "&patient_class=" + patient_class;
		finalString += "&order_type_code=" + order_type_code;
		finalString += "&dob=" + dob;
		finalString += "&bean_id=" + bean_id;
		finalString += "&bean_name=" + bean_name;

    	var dialogHeight ='21' ;
		var dialogWidth = '28' ;
		var dialogTop	= '250';
		var dialogLeft = '141' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var retVals = await window.showModalDialog("../../eOR/jsp/RegisterOrderSentOut.jsp?"+finalString,arguments,features);

		populateValues();
	} else if (sent_out_flag == 'R') {

		var arguments = "";

        var finalString	= "colval1="+"ReceiveResult"+ "&colval=" +escape(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+order_category+"&order_line_num="+order_line_num;
		finalString += "&performing_facility=" + performing_facility;
		finalString += "&performing_location=" + performing_location;
		finalString += "&performing_location_type=" + performing_location_type;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&int_or_ext=" + int_or_ext;
		finalString += "&dob=" + dob;
        finalString += "&bean_id=" + bean_id;
		finalString += "&bean_name=" + bean_name;

    	var dialogHeight ='23' ;
		var dialogWidth = '30' ;
		var dialogTop	= '129';
		var dialogLeft = '71' ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var retVals = await window.showModalDialog("../../eOR/jsp/RegisterOrderReceiveResult.jsp?"+finalString,arguments,features);

		populateValues();
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
function showRefusalText(target)
{	
	textSelected = "false";
	if(target.value == "")
	{
		refusal_text.innerHTML="";
	}
	else
	{
		refusal_text.innerHTML="<a class='gridLink' href='#'  onClick='showRefusalDesc()'>"+getLabel("eOR.ReferralText.label","OR")+"</a>";
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
	var features	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + '; center: ' + center + '; status:'+status+';dialogTop :' + dialogTop + ';scroll=no';
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


//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}*/

function chckDate(Object2,focusflag)
{
	var localeName = parent.RegisterOrderSearch.document.register_order_search.localeName.value
//if(CheckDate(Object2,focusflag)==false)//commented because of Thai Date Validations
if(validDateObj(Object2,"DMY",localeName)==false)// thai date validations 16/02/2007. function from DateUtils.js
	{
	 parent.RegisterOrderSearch.document.register_order_search.date_from.value= parent.RegisterOrderSearch.document.register_order_search.temp_curr_week_date.value;
	}
}

async function callBilling(row_value,order_id,patient_id,performing_facility_id,encounter_id,patient_class,sex,order_category,order_category_short_desc,order_line_num,performing_location,int_or_ext,Priority,order_type_code,source_type,source_code,colval1,colval,order_set_id)
{
	var dialogTop   = "10";
	var dialogLeft   = "10";
	var dialogHeight= "90vh" ;
	var dialogWidth = "90vw" ;
	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +';dialogLeft:'+dialogLeft +'; scroll=yes; status=no';
	var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+order_category+"&lineId="+order_line_num;
		finalString += "&performing_location=" + performing_location;
		//finalString += "&performing_location_type=" + performing_location_type;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&int_or_ext=" + int_or_ext;
		finalString += "&priority=" + Priority;
		finalString += "&patient_class=" + patient_class;
		finalString += "&order_type_code=" + order_type_code;
		finalString += "&source_type=" + source_type;
		finalString += "&source_code=" + source_code;
		finalString += "&orderId=" + order_id;
		finalString += "&performing_facility_id=" + performing_facility_id;
		finalString += "&order_set_id=" + order_set_id;

	var arguments	= "";
	var retVal 			= await window.showModalDialog("../../eOR/jsp/OrderEntryBillingFrameset.jsp?"+finalString,arguments,features);

}
function populateActivitySearch(target,code)
{
	
	if(trimString(target.value).length>0)
	{
		
			callActivitySearch(target,code);
		
	}
	if(target.value=="")
	{
		code.value="";
	}

}
async function callActivitySearch(target,code)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.RegisterOrderSearch.document.register_order_search.localeName.value;
	dataNameArray[0] 	= "order_category" ;		 
  	dataValueArray[0] 	= parent.RegisterOrderSearch.document.register_order_search.order_category.value;
 	dataTypeArray[0] 	= STRING ;
	dataNameArray[1] 	= "order_type_code" ;		 
  	dataValueArray[1] 	= parent.RegisterOrderSearch.document.register_order_search.order_type.value;
 	dataTypeArray[1] 	= STRING ;
	
	var sql=parent.RegisterOrderSearch.document.register_order_search.activity_sql.value;
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval= await CommonLookup(getLabel("eOR.ActivityType.label","OR"),argumentArray);
 
	var str =unescape(retval);
	
	if(retval !=null && retval != ""){
	
		var arr = str.split(",");
	 	code.value=arr[0];
		target.value=arr[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
		//target.value=getLabel("Common.all.label","Common");
 	}
}
function clearvalues()
{
	parent.RegisterOrderSearch.document.register_order_search.locn_code.value="";
	parent.RegisterOrderSearch.document.register_order_search.locn.value="";
	parent.RegisterOrderSearch.document.register_order_search.location_lookup.disabled=false;
	parent.RegisterOrderSearch.document.register_order_search.locn_code.disabled=false;
	parent.RegisterOrderSearch.document.register_order_search.locn_code.value="";//getLabel("Common.all.label","Common");
	if(parent.RegisterOrderSearch.document.register_order_search.location_type.value=='')
	{
	
	parent.RegisterOrderSearch.document.register_order_search.location_lookup.disabled=true;
	parent.RegisterOrderSearch.document.register_order_search.locn_code.disabled=true;
	}

}
function clearactivityvalues()
{
	parent.RegisterOrderSearch.document.register_order_search.activity_type.value="";
	parent.RegisterOrderSearch.document.register_order_search.activity_type_desc.value="";//getLabel("Common.all.label","Common");
}

//Commented on 16th Feb for the Date Validations
/*function chckDate2(Object2)
{
if(CheckDate(Object2)==false)
	{
	parent.RegisterOrderSearch.document.register_order_search.date_to.value= parent.RegisterOrderSearch.document.register_order_search.temp_last_week_date.value;
	}
}*/
function setvalue(value)
{
	parent.RegisterOrderSearch.document.register_order_search.cat_value.value=value;
}
function setRDvalue(RDinstall_yn)
{
	
	parent.RegisterOrderSearch.document.register_order_search.isRDInstalled_yn.value=RDinstall_yn;
	if (parent.RegisterOrderSearch.document.register_order_search.ord_cat.value == "RD" && parent.RegisterOrderSearch.document.register_order_search.isRDInstalled_yn.value == "Y") 
	{
		alert(getMessage('RADIOLOGY_MODULE_INSTALLED','OR'));
		parent.RegisterOrderSearch.document.register_order_search.ord_cat.value = "";
		parent.RegisterOrderSearch.document.register_order_search.order_category.value = "";
	}
}
function setOTvalue(OTinstall_yn)
{
	parent.RegisterOrderSearch.document.register_order_search.isOTInstalled_yn.value=OTinstall_yn;
	if (parent.RegisterOrderSearch.document.register_order_search.ord_cat.value == "OT" && parent.RegisterOrderSearch.document.register_order_search.isOTInstalled_yn.value == "Y") 
	{
			alert(getMessage('OT_MODULE_INSTALLED','OR'));
			parent.RegisterOrderSearch.document.register_order_search.ord_cat.value = "";
			parent.RegisterOrderSearch.document.register_order_search.order_category.value = "";
	}
}
function alignHeading()
{
	if(parent.RegisterOrderHeader.document.getElementById("tableheader")!=null)
	{
				parent.RegisterOrderHeader.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				for (j=0; j < document.getElementById("tableresult").rows(0).cells.length; j++) 
				{
					var wid=eval(document.getElementById("tableresult").rows(0).cells(j).offsetWidth);
					
					if(parent.RegisterOrderHeader.document.getElementById("tableheader").rows(0).cells(j) != null)
					{
						parent.RegisterOrderHeader.document.getElementById("tableheader").rows(0).cells(j).width=wid;
					}
				}
		}
		
	}
function populateperformingSearch(target,code)
{
	
	if(trimString(target.value).length>0)
	{
		
			callperformingSearch(target,code);
		
	}
	if(target.value=="")
	{
		code.value="";
	}

}
async function callperformingSearch(target,code)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var performing_deptloc_type="";
	if(parent.RegisterOrderSearch.document.register_order_search.order_category.value=="RX")
	{
		 performing_deptloc_type="I";
	}else if(parent.RegisterOrderSearch.document.register_order_search.order_category.value=="RD")
	{
		performing_deptloc_type="R";
	}
	else if(parent.RegisterOrderSearch.document.register_order_search.order_category.value=="LB")
	{
		performing_deptloc_type="L";
	}
	else if(parent.RegisterOrderSearch.document.register_order_search.order_category.value=="MI")
	{
		performing_deptloc_type="M";
	}
	else if(parent.RegisterOrderSearch.document.register_order_search.order_category.value=="TR")
	{
		performing_deptloc_type="T";
	}else if(parent.RegisterOrderSearch.document.register_order_search.order_category.value=="PC")
	{
		performing_deptloc_type="P";
	}
	localeName=parent.RegisterOrderSearch.document.register_order_search.localeName.value;
	dataNameArray[0] 	= "performing_deptloc_type" ;		 
  	dataValueArray[0] 	= performing_deptloc_type;
 	dataTypeArray[0] 	= STRING ;
	dataNameArray[1] 	= "performing_facility_id" ;		 
  	dataValueArray[1] 	= parent.RegisterOrderSearch.document.register_order_search.facility_id.value;
 	dataTypeArray[1] 	= STRING ;
	
	var sql=parent.RegisterOrderSearch.document.register_order_search.performing_sql.value;
	
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval= await CommonLookup(getLabel("Common.PerformingLocation.label","COMMON"),argumentArray);
	var str =unescape(retval);
	var arr = str.split(",");
	if(retval !=null && retval != ""){
		code.value=arr[0];
		target.value=arr[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
		//target.value=getLabel("Common.all.label","Common");
 	}
}
function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	//if(parent.RegisterOrderHeader.location.href.indexOf(".jsp") != -1)
	//{
		//parent.RegisterOrderHeader.document.body.scrollLeft=temp;
	//}
}

//IN065942, starts
function prnRegLabel()
{
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
	var bean_id = document.getElementById("bean_id").value;
	
    var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var params = "validate=PRINT_REG_ORDER_LABEL&flag=true&bean_id="+bean_id;

    xmlHttp.open("POST", "../../eOR/jsp/RegisterOrderValidate.jsp?"+params, true);
    xmlHttp.send(xmlDoc);
}
//IN065942, ends
//IN071618 Starts
function chkUnbilled(order_id,patient_id,facility_id,encounter_id,patient_class,order_type_code,row_value){
	var split_unbilled_order_yn =parent.RegisterOrderResult.document.getElementById("split_unbilled_order_yn"+row_value).value;
	
	if("Y"==split_unbilled_order_yn)
		checkBillSettlementforCatalog(order_id,order_type_code,patient_class,patient_id,encounter_id,row_value,facility_id);
}


function checkBillSettlementforCatalog(order_id,order_type_code,patient_class,patient_id,encounter_id,cnt,ordering_facility)
{
	var bean_id = parent.RegisterOrderResult.document.register_order_dtl.bean_id.value ;
	var bean_name = parent.RegisterOrderResult.document.register_order_dtl.bean_name.value ;
	var localeName = parent.RegisterOrderResult.document.register_order_dtl.localeName.value ;
	//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
    xmlStr += "ordering_facility=\""+ ordering_facility +"\" " ;
    xmlStr += "order_id=\""+ order_id +"\" " ;
    xmlStr += "order_type_code=\""+ order_type_code +"\" " ;
    xmlStr += "patient_class=\""+ patient_class +"\" " ;
    xmlStr += "patient_id=\""+ patient_id +"\" " ;
    xmlStr += "encounter_id=\""+ encounter_id +"\" " ;
    xmlStr += "rec_num=\""+ cnt +"\" " ;
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegisterOrderValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&localeName="+localeName+"&validate=CHECK_BILLSETTLEMENT&flag=true", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);

}

async function settlementPendingMsg(message,details,patient_id,encounter_id,facility_id,cnt)
{
	var dialogHeight ='8' ;
	var dialogWidth = '25' ;
	var dialogTop	= '250';
	var dialogLeft = '30' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

	var arguments = "";
	var finalString = "message="+escape(message)+"&details="+escape(details)+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&rec_num="+cnt;
	var result = await window.showModalDialog("../../eOR/jsp/RegisterOrderBillDetails.jsp?"+finalString,arguments,features);	
	if(result)
	{	
		onSuccess("Y");
	}	
	else
		deSelChkbox(cnt);
}
function windowRet()
{
 	window.returnValue = document.bill_unsettled_order.rec_res.value;
}

function amendUnbillLineRecord()
{
	eval(formApply( document.bill_unsettled_order,OR_CONTROLLER)) ;
	document.bill_unsettled_order.rec_res.value = true;
    window.close();
}

function deSelChkbox(cnt)
{
	var val = eval("parent.RegisterOrderResult.document.register_order_dtl.chk"+cnt);
	
	if(val.checked == true)
	{
		val.checked = false;
		parent.RegisterOrderResult.document.getElementById("total_recs").value = parseInt(parent.RegisterOrderResult.document.getElementById("total_recs").value) - 1; 
	}
}
//IN071618 Ends

