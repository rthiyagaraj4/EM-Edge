/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------------------------------------
07/02/2013	  IN029949	    Chowminya G     Created 
12/02/2013	  IN037901	    Chowminya G     Pharmacy Orders - On Hold ->View->HTML tags displayed in header
20/02/2013	  IN037927	    Chowminya G     Pharmacy Orders - On Hold ->Query Criteria displayed wrongly
-------------------------------------------------------------------------------------------------------------------------------------
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



	var formObj = document.authorise_order;
	if( location_type.value == "" ) {
		clearList("document")
	}
	var bean_id = document.hold_order.bean_id.value ;
	var localeName=document.hold_order.localeName.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AuthorizeOrdersValidate1.jsp?bean_id=" + bean_id + "&default_val=''&validate=ord_cat&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )


}
function populateLoaction(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	location_type	  = document.hold_order.location_type.value

	if(location_type!=null && location_type=="C")
	   location_type	= "OP";
	else if(location_type!=null && location_type=="D")
	   location_type	= "DC";
	else if(location_type!=null && location_type=="E")
	   location_type	= "EM";
	else if(location_type!=null && location_type=="W")
	   location_type	= "IP";
 

	dataNameArray[0] = "FACILITY_ID";
	dataValueArray[0] = document.hold_order.facility_id.value;
	dataTypeArray[0] = STRING;

	dataNameArray[1] = "FACILITY_ID";
	dataValueArray[1] = document.hold_order.facility_id.value;
	dataTypeArray[1] = STRING;  


	var localeName=document.hold_order.localeName.value;
	var sql=document.hold_order.location_sql.value;

	for(var x=0;x<5;x++)
	{
		sql = sql.replace('?',"'"+localeName+"'");
	}

	sql=sql.replace('?',"'"+document.hold_order.practitioner_id.value+"'");
	//IN037927 - Start
	if(location_type!=null && location_type=="OP")
	{
		sql = sql.replace("##FILTER1##"," and patient_class IN ( 'OP' ,'EM')");
	}
	else if(location_type!=null && location_type=="IP")
	{
		sql = sql.replace("##FILTER1##"," and patient_class IN ( 'IP' ,'DC') ");
	}
	else if(location_type!=null && location_type=="R")
	{
		sql = sql.replace("##FILTER1##"," and patient_class IN ( 'R') ");
	}
	else
	{
		sql = sql.replace("##FILTER1##"," ");
	}
	//IN037927 - End

	argumentArray[0]=sql;
 
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "4,5";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
 
   	retVal = await CommonLookup( getLabel("Common.Location.label","Common"),argumentArray ); 
	if(retVal != null && retVal != ""){
		document.hold_order.locn.value=retVal[0];
		target.value = retVal[1];
	}else{

		target.value=getLabel("Common.all.label","Common");
		document.hold_order.locn.value = "";
	}
}
function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.hold_order.locn.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".hold_order.locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".hold_order.locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".hold_order.locn.add(opt)") ;
}


//this fucntion is used to clear the entries of search criteria
function resetValues(){
	document.hold_order.search_btn.disabled = false;
	document.hold_order.reset();
	document.getElementById("id_locn").innerHTML = getLabel("Common.patientId.label","Common") 
	parent.MediHoldOrderBottom.document.location.href="../../eCommon/html/blank.html"
}


// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll()
{
	//if(document.hold_order_hdg.select_all.checked == true)
	if(document.getElementById("select_all").checked == true)
	{
		for(cnt=0; cnt<parent.MediHoldOrderResult.document.medi_hold_order_dtl.total_recs.value; cnt++)
		{
			if(eval("parent.MediHoldOrderResult.document.medi_hold_order_dtl.chk"+cnt).disabled==false)
			{
				
				val = eval("parent.MediHoldOrderResult.document.medi_hold_order_dtl.chk"+cnt);
				val.checked = true;
			}
			else
			{
				eval("parent.MediHoldOrderResult.document.medi_hold_order_dtl.chk"+cnt).disabled=true
			}
		}
	}else
	{
		for(cnt=0; cnt<parent.MediHoldOrderResult.document.medi_hold_order_dtl.total_recs.value; cnt++)
		{
			if(eval("parent.MediHoldOrderResult.document.medi_hold_order_dtl.chk"+cnt).disabled==false)
			{
				val = eval("parent.MediHoldOrderResult.document.medi_hold_order_dtl.chk"+cnt);
				val.checked = false;
			}
			else
			{
				eval("parent.MediHoldOrderResult.document.medi_hold_order_dtl.chk"+cnt).disabled=true
			}
		}
	}
}

function clearChecked(){
	parent.MediHoldOrderResult.document.medi_hold_order_dtl.reset()
	//parent.AuthorizeOrdersBottomRight0.document.hold_order_hdg.reset()
}
function populateValues(){
	
	if (top.content) {
	top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	}
	var formObj = parent.MediHoldOrderTop.document.hold_order;
	var fromDate = formObj.period_from
	var toDate = formObj.period_to
	
	if(!trimCheck(fromDate.value)){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
		parent.MediHoldOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!trimCheck(toDate.value)){
		alert(getMessage("TO_DT_NOT_BLANK","SM"));
		parent.MediHoldOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!isAfter(toDate.value,fromDate.value,"DMY",formObj.localeName.value)){//this function is available in eCommon/js/DateUtils.js
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		parent.MediHoldOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false ;
	}

	var ptID = formObj.patientId.value;
	var locale = formObj.localeName.value;
		
	if(ptID == '' && !dateRangeValidation(fromDate, toDate, locale, '7', 'DMY'))
	{
		parent.MediHoldOrderBottom.location.href = "../../eCommon/html/blank.html";
		alert(getMessage("VALIDATE_DATE_ON_SEARCH", "OR"))
	}
	else
	{
	
		document.hold_order.search_btn.disabled = false;
		document.hold_order.submit();
	}
	
}
function checkDateRange(obj,from){
	var fromDate = eval("document."+from+".period_from")
	var toDate = eval("document."+from+".period_to")
	var localeName = eval("document."+from+".localeName")
		
	if(validDateObj(obj,"DMY",localeName)){
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
		}
	}else{
		parent.MediHoldOrderTop.document.hold_order.period_to.value=parent.MediHoldOrderTop.document.hold_order.temp_last_week_date.value;
	
	}


}

function discontinue(){
	var locn_type = parent.parent.frames[0].document.hold_order.location_type.value
	var locn = parent.parent.frames[0].document.hold_order.locn.value
	var patientId=parent.parent.frames[0].document.hold_order.patientId.value
	var period_from=parent.parent.frames[0].document.hold_order.period_from.value
	var period_to=parent.parent.frames[0].document.hold_order.period_to.value

	qry_string = "../jsp/MedicationHoldOrdersBottom.jsp?location_type="+locn_type+"&locn="+locn+"&patientId="+patientId+"&period_from="+period_from+"&period_to="+period_to;

	var no_of_checked = 0;
	var formObj = parent.MediHoldOrderResult.document.medi_hold_order_dtl
	var arguments = "";

	var bean_id = parent.MediHoldOrderResult.document.medi_hold_order_dtl.bean_id.value ;

	var xmlDocs = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttpp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;

			xmlStr ="<root><SEARCH " ;
	incr=0;
	flag = false
	for(cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("parent.MediHoldOrderResult.document.medi_hold_order_dtl.chk"+cnt);
		patient_class = eval("parent.MediHoldOrderResult.document.medi_hold_order_dtl.patient_class"+cnt);
		priority = eval("parent.MediHoldOrderResult.document.medi_hold_order_dtl.priority"+cnt);
		ord_id = eval("parent.MediHoldOrderResult.document.medi_hold_order_dtl.ord_id"+cnt);
			

		if(val.checked == true){

			no_of_checked++;
		}
	}
	if(parseInt(no_of_checked) == 0){
		alert(getMessage('CLICK_ANY_ONE','OR'));
		return false
	}
		var dialogHeight ='37.5' ;
		var dialogWidth = '50' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		var colval1 = "Discontinue";
		var finalString	= "colval1="+colval1+"&orderId="+ ord_id+"&patient_id="+ patientId+"&patient_class="+ patient_class;

		var retVals = window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
			reloadValues();
		 /* xmlStr = "";
    		eval(formApply( parent.MediHoldOrderResult.document.medi_hold_order_dtl,OR_CONTROLLER)) ;*/
    		if (top.content) {
				if( invalidCode != "" && invalidCode!=null){ 
					eval("parent.MediHoldOrderResult.document.getElementById("status")"+invalidCode).className="orcancel";
					alert(message);
					return false;
				}else
					top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
            } else {
				
				if(message!="" && message!=null)
    			alert(message);
                window.close();
            }
    		if( result ) {
    			onSuccess1();
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
	window.close();
	//parent.parent.parent.frames[1].location.href=qry_string
}

function onSuccess1() {
	callPrinting();
	parent.parent.parent.frames[1].location.href=qry_string
}
function callPrinting(){
	var bean_id = parent.MediHoldOrderResult.document.medi_hold_order_dtl.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr +="/></root>" ;
	
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AuthorizeOrdersValidate.jsp?bean_id=" + bean_id + "&validate=print_values", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);

}


function callMenuFunctions(colval1,ord_cat,colval,orderId,sex,patient_id,encounter_id,patient_class,order_catalog_code,order_type_code,order_line_num,cont_order_ind,order_line_status){

		var dialogHeight ='37.5' ;
		var dialogWidth = '50' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;
		
		if(colval1 == "Discontinue")
		{
			dialogHeight ='18.5' ;
			dialogWidth = '25' ;
			dialogTop	= '100';
			dialogLeft = '20' ;
		}

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
			
		var finalString	= "colval1="+colval1+"&colval="+encodeURIComponent(colval1)+"&orderId="+orderId+"&val1="+ord_cat+"&patient_id="+patient_id+"&cont_order_ind="+cont_order_ind+"&order_status="+order_line_status+"&sex="+sex+"&ord_cat="+ord_cat+"&order_type_code="+order_type_code+"&catalog_code="+order_catalog_code+"&ord_cat_id="+ord_cat+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&order_line_num="+order_line_num; //IN037901
		
		var retVals = window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);

		if(colval1 == "Discontinue" || colval == "Amend" ){
			reloadValues();
		}


}

// patient ID search
function callPatientSearch(){
	var pat_id =  PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}


/*******/
function getNext(flagSelect){
var formObj= parent.MediHoldOrderResult.document.medi_hold_order_dtl
top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
formObj.nextPrevFlag.value=flagSelect;//set the Flag to next or Prevoius
formObj.action.value="nextPrev";//var late=applyupdate();
//if(late)
//	formObjDetail.submit();
}
/*******/
//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}
*/
async function callPatientHistory(patient_id){
		var dialogHeight ='45' ;
		var dialogWidth = '60' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;


		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		var ammend_called_from="existing_order";
 		var retVals = await window.showModalDialog("../../eCA/jsp/EncounterInDialog.jsp?patient_id="+patient_id+"&called_from=OR",arguments,features);
}
function show_locn_window( target )
{
	var frmObj = parent.MediHoldOrderTop.document.hold_order;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array("pract_id","location_type","fact_id","location_type") ;
	var dataValueArray = new Array(frmObj.pract_id.value,target.value,frmObj.fact_id.value,target.value) ;
	var dataTypeArray  = new Array("String","String","String","String") ;
	
	argumentArray[0]   = parent.MediHoldOrderTop.document.hold_order.locn_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

//alert("argumentArray[1]::"+argumentArray[1]+"::argumentArray[2]-"+argumentArray[2]+"-argumentArray[3]-"+argumentArray[3]+"-argumentArray[4]-"+argumentArray[4]+"-argumentArray[5]-"+argumentArray[5]+"::argumentArray[5]-"+argumentArray[5]+"-argumentArray[6]-"+argumentArray[6]+"-argumentArray[7]-"+argumentArray[7]+"--");
	retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );

	if(retVal != null && retVal != ""){
		target.value = retVal[1];
		parent.MediHoldOrderTop.document.hold_order.locn_val.value=retVal[1];
		parent.MediHoldOrderTop.document.hold_order.locn.value=retVal[0];
	
	}

}

function reloadValues(){
 	var formObj = parent.parent.MediHoldOrderTop.document.hold_order;
	qry_string = "../jsp/MedicationHoldOrdersBottom.jsp?location_type="+formObj.location_type.value+"&locn="+formObj.locn.value+"&patientId="+formObj.patientId.value+"&period_from="+formObj.period_from.value+"&period_to="+formObj.period_to.value;
	parent.parent.frames[1].location.href=qry_string;
}

function chckDate(Object2, focusflag)
{
	var localeName = parent.MediHoldOrderTop.document.hold_order.localeName.value

	if(!validDateObj(Object2,"DMY",localeName))// thai date validations 16/02/2007. function from DateUtils.js
	{
		parent.MediHoldOrderTop.document.hold_order.period_from.value=parent.MediHoldOrderTop.document.hold_order.temp_curr_week_date.value;
	}
}


async function callBilling(row_value,order_id,patient_id,performing_facility_id,encounter_id,patient_class,order_category,sex,colval1,colval,order_set_id)
{

	var dialogTop   = "100";
	var dialogLeft   = "30";
	var dialogHeight= "45" ;
	var dialogWidth = "60" ;
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
		//alert("final String="+finalString);
	var arguments	= "";
	var retVal 			= await window.showModalDialog("../../eOR/jsp/OrderEntryBillingFrameset.jsp?"+finalString,arguments,features);

}

function alignHeading()
{

	if(parent.AuthorizeOrdersBottomRight0.document.getElementById("tableheader")!=null)
	{
				parent.AuthorizeOrdersBottomRight0.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				if(document.getElementById("tableresult").rows(1))
				{
					for (j=0; j < document.getElementById("tableresult").rows(1).cells.length; j++) 
					{
						var wid=eval(document.getElementById("tableresult").rows(1).cells(j).offsetWidth);
						
						if(parent.AuthorizeOrdersBottomRight0.document.getElementById("tableheader").rows(0).cells(j) != null)
						{
							parent.AuthorizeOrdersBottomRight0.document.getElementById("tableheader").rows(0).cells(j).width=wid;
						}
					}
				}
		}
		
	}

	

