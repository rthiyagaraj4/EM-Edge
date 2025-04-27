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
Date       		Edit History    Name        	Description
--------------------------------------------------------------------------------------------------------------
?             	100            	?           	created						
04/12/2012		IN031304		ChowminyaG		Include Dept_authorization validation for RD orders br appt schedule(IN035976)
---------------------------------------------------------------------------------------------------------------
*/

async function callOrderable(obj)
{
	var searchText = obj.value;
	//var dialogHeight= "30" ;
	//var dialogWidth	= "40" ;
	//var dialogTop = "100" ;
	var dialogHeight= "450px" ;
	var dialogWidth	= "800px" ;
	var dialogTop = "10px" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
// Pass a parameter table_name, if needed,FROM AM when it is called table_name will be passed, for Waiting List...
	var retVal = await window.showModalDialog("../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+encodeURIComponent(searchText)+"&called_from=generic_atc&mode="+MODE_INSERT,arguments,features);

	if(retVal != undefined)
	{
		storeVal=retVal.split("&");

		document.pendingOrder_schedule.ordercode.value=storeVal[0];
		document.pendingOrder_schedule.orderable.value = storeVal[1];
	}
	else
	{
		document.pendingOrder_schedule.orderable.value = "";
	}
}

async function callPatientSearch(){
	var pat_id =  await PatientSearch();
	if(pat_id != null)
	document.getElementById("patient_id").value = pat_id;
}

function addCategoryList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	//alert(selected);
	//element.selected = selected;
	document.pendingOrder_schedule.order_category.add(element);
}
function addOrderTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value;
	
	document.pendingOrder_schedule.order_type.add(element);
}

function addActivityList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.pendingOrder_schedule.activity_type.add(element);
}
function addPerfLocnList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.pendingOrder_schedule.performing_locn.add(element);
}
function addPatClass(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.pendingOrder_schedule.patient_class.add(element);
}
function clearOrderTypeList( docObj ) {
	var len = eval(docObj+".pendingOrder_schedule.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".pendingOrder_schedule.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     ---"+getLabel("Common.all.label","Common")+"---     ";
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".pendingOrder_schedule.order_type.add(opt)") ;
}
function clearActivityTypeList( docObj ) {
	var len = eval(docObj+".pendingOrder_schedule.activity_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".pendingOrder_schedule.activity_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     ---"+getLabel("Common.all.label","Common")+"---     ";
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".pendingOrder_schedule.activity_type.add(opt)") ;
}

function populateListItems(obj){
	
	var formObj = document.pendingOrder_schedule
	var localeName=document.pendingOrder_schedule.localeName.value;
	var validate = "";var flag;
	var bean_id = formObj.bean_id.value ;
	//clearActivityTypeList("document");
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += formObj.order_category.name+"=\""+ formObj.order_category.value +"\" " ;
	
	if(obj == "activity_type"){
		xmlStr += formObj.order_type.name+"=\""+ formObj.order_type.value +"\" " ;
		
	}
	validate = obj;
		
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");//alert(bean_id+","+formObj.locn.value+","+formObj.order_type.value);

	xmlHttp.open( "POST", "PendingOrdersScheduleValidate.jsp?bean_id=" + bean_id +"&validate="+validate+"&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText );

}
function populateValues()
{
	var	formObj = parent.pendingOrdersScheduleSearch.document.pendingOrder_schedule;
	formObj.search_result.disabled = true;
	var fields = new Array ( formObj.date_from,formObj.date_to);
	var names = new Array ( "Period From","Period To");
	if(!checkFields( fields, names, parent.parent.parent.messageFrame)) 
	{
		formObj.search_result.disabled = false;
		parent.pendingOrdersScheduleHeader.location.href="../../eCommon/html/blank.html";
		parent.pendingOrdersScheduleResult.location.href="../../eCommon/html/blank.html";
		return false;
	}

	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	

	var qry_string = "order_category="+formObj.order_category.value+"&order_type="+formObj.order_type.value+"&activity_type="+formObj.activity_type.value+"&orderable="+formObj.orderable.value+"&performing_locn="+formObj.performing_locn.value+"&priority="+formObj.priority.value+"&patient_id="+formObj.patient_id.value+"&patient_class="+formObj.patient_class.value+"&date_from="+formObj.date_from.value+"&date_to="+formObj.date_to.value;

	parent.pendingOrdersScheduleHeader.location.href="../jsp/PendingOrdersScheduleHeader.jsp"
	parent.pendingOrdersScheduleResult.location.href="../jsp/PendingOrdersScheduleResult.jsp?"+qry_string;
	

}
function clearValues(){
		var formObj = parent.pendingOrdersScheduleSearch.document.pendingOrder_schedule;
	formObj.search_result.disabled=false;
	formObj.reset();
	parent.pendingOrdersScheduleHeader.location.href = "../../eCommon/html/blank.html"
	parent.pendingOrdersScheduleResult.location.href = "../../eCommon/html/blank.html"
	/*if (top.content) {
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num" ;
	}*/


}
function checkDateRange(obj){

	var fromDate = eval("document.pendingOrder_schedule.date_from")
	var toDate = eval("document.pendingOrder_schedule.date_to")
    var localeName = eval("document.pendingOrder_schedule.localeName")
	//if(!CheckDate(toDate))
	//	return false;
	//if(doDateCheckOR(fromDate,toDate) == 1) { 
//if(CheckDate(obj)){//this commented for thai dateUtils
	if(validDateObj(obj,"DMY",localeName.value))
	{
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.Value)){
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); 
		obj.focus()
		return false
		}
	
}
else
	{
	document.pendingOrder_schedule.date_to.value=document.pendingOrder_schedule.temp_curr_date.value;
	
	}

}
async function callfunc(colval1, colval, orderId, sex, patient_id){

	var dialogHeight ='37.5' ;
	var dialogWidth = '50' ;
	var dialogTop	= '100';
	var dialogLeft = '30' ;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

	var arguments = "";
	var finalString	= "colval1="+colval1+ "&colval=" +colval+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id;
//		alert(finalString)
	var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}

// Code from OA Module ,
function BookAppointment(Patient_Id, locn_code, start_date_time, order_catalog_code, order_id,order_line_num,rad_auth_yn){

//--[IN031304] - Start
if(rad_auth_yn == "Y")
{
	alert(getMessage("AUTH_RAD_SCH","OR")); 
	return;
}
//--[IN031304] - End
	//alert();
 	var referral_id = "";  
	if(start_date_time!=null && start_date_time.length>10 &&  start_date_time.length==16) { // (with time truncate it ) 
	  start_date_time  	= start_date_time.substring(0,10); 
	}
	var curr_date = document.pendingOrder_schedule_result.current_date.value;
	if(start_date_time.length > 0 && curr_date.length > 0 ) {
            fromarray = start_date_time.split("/");
            toarray = curr_date.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt))
				start_date_time =  start_date_time ;
			else if(Date.parse(todt) > Date.parse(fromdt))
				start_date_time =  curr_date ;
			else if(Date.parse(todt) == Date.parse(fromdt))
				start_date_time =  start_date_time ;
   }
	var condition	=  "i_practitioner_id=&practitioner_id=" 
		condition	+= "&patient_id="+Patient_Id+"&i_clinic_code=" 
		condition	+= "&clinic_code=&recall_date="+start_date_time;
		condition	+= "&location_code="+locn_code+"&care_locn_ind="; 
		condition	+= "&specialty_code=&selectedPractId="//+ordering_practitioner;
		condition	+= "&selectedLocnCode=&referral_id="; 
		condition	+= "&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code; 
		condition	+= "&callingMode=OR&from_OR=Y&from_AE=N";
		condition	+= "&calledFrom=OR";
		condition	+= "&order_category="+order_id.substring(0,2);

	parent.parent.location.href = "../../eOA/jsp/CAOAAppointment.jsp?"+condition;

	/*var retVal 			= ""
	var dialogHeight 	= "29" ;
	var dialogWidth  	= "50" ;
	var dialogTop    	= "100";
	var status 			= "no";
	var arguments		= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";

	
	retVal				= window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?"+condition,arguments,features);
	
	if(retVal != null && retVal != "")
	{
		var Val				= retVal.split("^");
		var mode			= Val[0];
		var oa_query_string	= Val[1];
		oa_query_string		+= "&title=Book Appointment";
		if (mode=="1"){
			returnVal		= window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+oa_query_string,arguments,features);
		} else if (mode=="2"){
			returnVal		= window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+oa_query_string,arguments,features);
		} else if (mode=="3"){
			returnVal		= window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+oa_query_string,arguments,features);
		}
		if(returnVal != null && returnVal != "")
		{
			if(returnVal=="OP")
			{ 
				BookAppointment(Patient_Id, locn_code, start_date_time, order_catalog_code, order_id,order_line_num)
			}
			else if(returnVal != null && returnVal != "")
			{
				var result	= returnVal.split("*");
				if(result[0] != "OP")
				{
					var ApptNo		= result[0];
				}
			} // End of else 
		} // End of returnVal
			
	} // End of retVal
	parent.pendingOrdersScheduleResult.location.reload();*/
} // End of  BookAppointmentu

function chckDate(Object2,focusflag)
{

	var localeName=document.pendingOrder_schedule.localeName.value
//if(CheckDate(Object2,focusflag)==false)

  if(validDateObj(Object2,"DMY",localeName)==false)
	{
	document.pendingOrder_schedule.date_from.value=document.pendingOrder_schedule.temp_next_week_date.value;
	}
}
