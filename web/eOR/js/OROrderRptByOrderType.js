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
02/08/2013    IN038751      Karthi L    New report to display the number of orders placed by each practitioner under an Order Type
19/09/2013    IN043511      Karthi L    Reset function is not working properly
---------------------------------------------------------------------------------------------------------------
*/
function reset(){
	OrorderTrackingRptFrame.document.Or0rderRptByOrderTypeForm.reset();
	location.reload(); // added for IN043511
}
function FillOrderType(OrderCatObj){
	
	var bean_id =document.Or0rderRptByOrderTypeForm.bean_id.value ;
	var callFrom1="ORDERCAT";
    var ordercatname=OrderCatObj.name;
	var ordercatvalue=OrderCatObj.value;
    var tmplocale=document.Or0rderRptByOrderTypeForm.language_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH ";
		xmlStr += "callFrom=\""+ callFrom1 +"\" " ;
		//xmlStr += "callFrom1=\""+ callFrom +"\" " ;
		xmlStr += "ordercatname=\""+ ordercatname +"\" " ;
		xmlStr += "ordercatvalue=\""+ ordercatvalue +"\" " ;		
		xmlStr += "tmplocale=\""+ tmplocale +"\" " ;
		xmlStr +=" /></root>" ;	
        //alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open( "POST", "OROrderTrackingRptValidate.jsp", false );
		xmlHttp.send( xmlDoc );
		responseText=xmlHttp.responseText ;
	eval(responseText );
	
}

function addLocationList1(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.Or0rderRptByOrderTypeForm.p_order_type_code.add(element);
}
function clearList1( docObj ) {
	var len = eval(docObj+".forms[0].p_order_type_code.options.length") ;
		for(var i=0;i<len;i++){
		eval(docObj+".Or0rderRptByOrderTypeForm.p_order_type_code.remove(\"locn\")") ;
		}
		var tp = getLabel("Common.all.label","Common") ;
		var opt = eval(docObj+".createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "ALL" ;
		eval(docObj+".Or0rderRptByOrderTypeForm.p_order_type_code.add(opt)") ;
}
function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
function validate_to_date(obj){
	var frdt = document.getElementById("p_fm_date");
	var tdt = document.getElementById("p_to_date");
	var locale =  document.getElementById("language_id").value;

	if(frdt.value !='' && tdt.value !='' )// DateUtils.js
	{
		if(validDate(frdt.value,"DMY",locale) && validDate(tdt.value,"DMY",locale))
		{
			var fromDt	= convertDate(frdt.value,"DMY",locale,"en");
			var toDt	= convertDate(tdt.value,"DMY",locale,"en");

			if(!isBefore(fromDt,toDt,'DMY',locale))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				frdt.focus();
			}
		}
	}
}

function validate_from_date(){
	var frdt = document.getElementById("p_fm_date");
	var tdt = document.getElementById("p_to_date");
	var locale =  document.getElementById("language_id").value;
	if(frdt.value !='' && tdt.value !='' )// DateUtils.js
	{
		if(validDate(frdt.value,"DMY",locale) && validDate(tdt.value,"DMY",locale))
		{
			var fromDt	= convertDate(frdt.value,"DMY",locale,"en");
			var toDt	= convertDate(tdt.value,"DMY",locale,"en");

			if(!isBefore(fromDt,toDt,'DMY',locale))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				tdt.focus();
			}
		}
	}
}



function callSearch(){
 	if(window.event.keyCode==13) {    // if it is an enter key, then populate a
   	 	//populateValues();   // Call the additionalSearch 
	}
}

	
function run(){
    var formobj=OrorderTrackingRptFrame.document.Or0rderRptByOrderTypeForm;	
	var pat_cla = "";
	var locale =  formobj.language_id.value;
	if(formobj.inpatient.checked == true) {
		pat_cla= pat_cla + formobj.inpatient.value;
	}
	if(formobj.outpatient.checked == true) {
		pat_cla = pat_cla + formobj.outpatient.value;
	}
	if(formobj.daycare.checked == true) {
		pat_cla = pat_cla + formobj.daycare.value;
	}
	if(formobj.emergency.checked == true) {
		pat_cla = pat_cla + formobj.emergency.value;
	}
	if(formobj.external.checked == true) {
		pat_cla = pat_cla + formobj.external.value;
	}
	formobj.p_patient_class.value = pat_cla;

	formobj.p_from_date_en.value = convertDate(formobj.p_fm_date.value,"DMY",locale,"en");
	formobj.p_to_date_en.value = convertDate(formobj.p_to_date.value,"DMY",locale,"en");


	fields = new Array( formobj.p_fm_date,formobj.p_to_date,formobj.p_patient_class);
	names =  new Array(getLabel("Common.periodfrom.label","Common") ,getLabel("Common.periodto.label","Common"),getLabel("Common.patientclass.label","Common"));
	
	if(OrorderTrackingRptFrame.checkFields(fields,names,messageFrame))
	{
		OrorderTrackingRptFrame.document.Or0rderRptByOrderTypeForm.action="../../eCommon/jsp/report_options.jsp";			
		OrorderTrackingRptFrame.document.Or0rderRptByOrderTypeForm.submit() ;					
	}			
	
}
	



