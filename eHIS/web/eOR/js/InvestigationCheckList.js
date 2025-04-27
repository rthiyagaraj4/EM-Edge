/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset(){
	investigationChkListFrame.document.investigationChkListForm.reset() ;
}

async function callPatientSearch(){
	var pat_id = await PatientSearch('','','','','','','Y','Y','Y','Visitreg');
  	if(pat_id != null) {
		if(pat_id.charAt(0)=="Y")
			pat_id =pat_id.substring(1,pat_id.length)
			document.getElementById("P_PATIENT_ID").value = pat_id;
	}
}

// commented by Abdulhamid Mohamed
//function showCalendarValidate(str){
//	var flg = showCalendar(str);
//	eval("document.all."+str+".focus();"); 
//	return flg;
//}

// Added by Abdulhamid Mohamed
async function showCalendarValidate(str){
    // added await and async
    var flg = await showCalendar(str);
    
    // replaced document.all with document.getElementById and removed eval
    var element = document.getElementById(str);
    if (element) {
        element.focus();
    } else {
        console.error("Element with id " + str + " not found.");
    }
    
    return flg;
}

function validate_to_date(obj){
	var toDate=obj;
	var fromDate="";
	if(obj.name=="p_to_date"){
		fromDate=document.forms[0].p_fr_date;
		toDate=document.forms[0].p_to_date;
	}else if(obj.name=="p_service_to_date"){
		fromDate=document.forms[0].p_service_from_date;
		toDate=document.forms[0].p_service_to_date;
	}

	if(obj.value.length>0){
		if(obj.value!=fromDate){
			CheckDate(obj);
		}
		if(!doDateChecknew(fromDate,toDate)){
			alert( "APP-SM0012 - To Date should be greater than or equal to From Date" );
		}
	}
}

function validate_from_date(obj){	
	var fromDate=obj;
	var toDate="";
	if(obj.name=="p_fr_date"){
		fromDate=document.forms[0].p_fr_date;
		toDate=document.forms[0].p_to_date;
	}else if(obj.name=="p_service_from_date"){
		fromDate=document.forms[0].p_service_from_date;
		toDate=document.forms[0].p_service_to_date;
	}
	if(obj.value.length>0){
		if(obj.value!=fromDate.value){
			DateValidation(obj);
		}			if(!doDateChecknew(fromDate,toDate)){
			alert( "APP-SM0012 - To Date should be greater than or equal to From Date" );
		}
	}			
}

function DateValidation(obj){
	curdate = document.forms[0].to_date;
	var msg="APP-SM0034 Date should be greater than or equal to Current Date";
	if(doDateCheckAlert(curdate,obj) == false){
		obj.focus();
		obj.select();
		alert(msg);
	}
}
	
function doDateCheckAlert(from,to){
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ){
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	
		if(Date.parse(todt) < Date.parse(fromdt)){
			return false;
		}else if(Date.parse(todt) >= Date.parse(fromdt)){ 
			return true;
		}
	}	
	return true;
}

function doDateChecknew(from,to){
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;

	if(fromdate.length > 0 && todate.length > 0 ){
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	
		if(Date.parse(todt) < Date.parse(fromdt)){
				return false;
		}else if(Date.parse(todt) >= Date.parse(fromdt)){
			return true;
		}
	}	
	return true;
}

function chkCancelTest(obj){
	if(obj.checked==true && obj.name=="p_canc")
	{	obj.value="Y";
		document.getElementById("p_include_cancelled_orders").value="Y";
	}
	else 
	{
		obj.value="N";
		document.getElementById("p_include_cancelled_orders").value="N";
	}

}

function chkBilledTest(obj){


	if(obj.checked==true && obj.name=="p_bill")
	{	obj.value="Y";
		document.getElementById("p_includ_billed_only").value="Y";
	}
	else 
	{
		obj.value="N";
		document.getElementById("p_includ_billed_only").value="N";
	}


}

function run(){

	fields = new Array( investigationChkListFrame.document.forms[0].p_fr_date,investigationChkListFrame.document.forms[0].p_to_date);
	names =  new Array(getLabel("Common.OrderDateFrom.label","Common") ,getLabel("Common.to.label","Common"));
	if(investigationChkListFrame.checkFields(fields,names,messageFrame)){
	investigationChkListFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		if(doDateCheck(investigationChkListFrame.document.forms[0].p_fr_date,investigationChkListFrame.document.forms[0].p_to_date,messageFrame)==false){
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
		}else if(doDateCheck(investigationChkListFrame.document.forms[0].p_to_date,investigationChkListFrame.document.forms[0].to_date,messageFrame)==false){	
			var errors=getMessage('DATE_NOT_GREATER_SYSDATE','Common');
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
		}
		if(doDateCheck(investigationChkListFrame.document.forms[0].p_service_from_date,investigationChkListFrame.document.forms[0].p_service_to_date,messageFrame)==false){
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
		}else if(doDateCheck(investigationChkListFrame.document.forms[0].p_service_to_date,investigationChkListFrame.document.forms[0].to_date,messageFrame)==false){	
			var errors=getMessage('DATE_NOT_GREATER_SYSDATE','Common');
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
		}
		

		investigationChkListFrame.document.forms[0].submit() ;	
	}

}
	



