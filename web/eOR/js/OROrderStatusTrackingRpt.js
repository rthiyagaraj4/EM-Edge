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
Date       	Edit History    Name       	 	Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
02/07/2015 	IN054381		Akbar Sharif								MMS-QF-CRF-0211
10/08/2015	IN056781		Vijayakumar K	12/08/2015	Dinesh T		CRF-OR-MMS-QF-CRF-0211/03-When Special Characters 
																		are used in Order Catalog field, system displays different error messages.
28/08/2015	IN056781_01		Vijayakumar K	28/08/2015					CRF-OR-MMS-QF-CRF-0211/03-When Special Characters 
																		are used in Order Catalog field, system displays different error messages
--------------------------------------------------------------------------------------------------------------
*/ 
function reset(){
	//OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.reset() ;
	OrOrderStatusTrackingRptFrame.document.location.href="../../eOR/jsp/OROrderStatusTrackingRptCriteria.jsp";
}

function orderingpractSearch1(target,code)
{
if(target.value!="")
	{
	orderingpractSearch(target,code);
	}
	else
	parent.OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.p_ord_pract_id.value="";
} 

async function orderingpractSearch(target,code)
{

	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.language_id.value;
	var sql="SELECT practitioner_id code, practitioner_name description  FROM am_practitioner_lang_vw where  eff_status ='E'  and language_id=? and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]   = sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal= await CommonLookup(getLabel("Common.OrderingPractitioner.label","COMMON"),argumentArray);
	var ret1 = unescape(retVal);
	arr=ret1.split(",");
	// Commented By Abdulhamid Mohamed
//	if(retVal !=null && retVal != ""){
//		code.value=retVal[0];
//		target.value=retVal[1];
//		
//		}else{
//   		target.value = "";
//   		code.value = "" ;
// 	}
	// Added By Abdulhamid Mohamed
	if(arr[1] == undefined){
		arr[0] = "";
		arr[1] = "";	
	}else{
   		target.value = arr[1];
   		code.value = arr[0];
 	}
}
function FillOrderType(OrderCatObj){
	
	var bean_id =document.Or0rderStatusTrackingRptForm.bean_id.value ;
	var callFrom1="ORDERCAT";
    var ordercatname=OrderCatObj.name;
	var ordercatvalue=OrderCatObj.value;
    var tmplocale=document.Or0rderStatusTrackingRptForm.language_id.value;
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
		//validate = "activity_type";
		xmlHttp.open( "POST", "OROrderTrackingRptValidate.jsp", false );
		xmlHttp.send( xmlDoc );
		responseText=xmlHttp.responseText ;
	eval(responseText );
}

function addLocationList1(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.Or0rderStatusTrackingRptForm.p_order_type_code.add(element);
}

function clearList1( docObj ) {
	var len = eval(docObj+".forms[0].p_order_type_code.options.length") ;
		for(var i=0;i<len;i++){
		eval(docObj+".Or0rderStatusTrackingRptForm.p_order_type_code.remove(\"locn\")") ;
		}
		var tp = getLabel("Common.all.label","Common") ;
		var opt = eval(docObj+".createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "ALL" ;
		eval(docObj+".Or0rderStatusTrackingRptForm.p_order_type_code.add(opt)") ;
}

//commented by Abdulhamid Mohamed
//function showCalendarValidate(str){
//	var flg = showCalendar(str);
//	eval("document.all."+str+".focus();"); 
//	return flg;
//}

//Added by Abdulhamid Mohamed
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

function allowDateFormat(){
   var key = window.event.keyCode;   
   if( ! ( (( key>=48 ) && ( key<=58 ) ) || (key == 47)|| (key == 32)) ) {
       return false;
   }
}

function validateDate(date, format, locale){
	if(date.value != ''){
		var dateValue=date.value;
		var dateArray="";
		var dateArray1;
		var checkFlag=true;
		if(format=="DMY"){
			dateArray=dateValue.split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="DMYHM"){
			dateArray1=dateValue.split(" ");
			dateArray=(dateArray1[0]).split("/");			
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="YY"){
			if(date==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="MY"){
			dateArray=dateValue.split("/");
			if(dateArray[1]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}	
		if(checkFlag){			
			if(!validDate(date.value,format,locale)){			
				date.select();
				date.focus();				
			}else{
				var timeArray=date.value.split(" ");
				if (!chkTime(timeArray[1]))
				{
					date.select();
					date.focus();	
				}else
					return true;
			}
		}else{			
			date.select();
			date.focus();			
		}
	}
}

function checkIsValidDate(obj,format,locale,callFrom,obj1)
{	
	if(obj.value != "" )
	{	
		if(!validateDate(obj,format,locale))
		{			
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			return false;
		}else{
			if (!validateDate(obj1,format,locale))
			{
				return false;
			}
			if (callFrom == "FROMDATE"){				
				 if(obj.value !="" && obj1.value !="" )
				{
					if(!isBefore(obj.value,obj1.value,"DMYHM",locale))
					{	
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));		
						obj1.focus();
						return false;
					}
				}
				datechecklistt(obj,obj1,'FROMDATE');						
			}else if (callFrom == "TODATE"){		
				 if(obj.value !="" && obj1.value !="" )
				{
					if(!isBefore(obj1.value,obj.value,"DMYHM",locale))
					{	
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));	
						obj.focus();
						return false;
					}
				}
				datechecklistt(obj1,obj,'TODATE');				
			}				
		}						
	}
		
}
function validate_from_date(){
	var frdt = document.getElementById("p_frm_date");
	var tdt = document.getElementById("p_to_date");
	var locale =  document.getElementById("language_id").value;
	if(frdt.value !='' && tdt.value !='' )// DateUtils.js
	{
		//IN056781 starts
/*		if(validDateObj(frdt,"DMY",locale) && validDateObj(tdt,"DMY",locale))
		{
			var fromDt	= convertDate(frdt.value,"DMY",locale,"en");
			var toDt	= convertDate(tdt.value,"DMY",locale,"en");

			if(!isBefore(fromDt,toDt,'DMY',locale))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				tdt.focus();
			}
		}
*/
		
		
		if(!validDateObj(frdt,"DMY",locale))
		{
			return false;
		}
		
		var fromDt	= convertDate(frdt.value,"DMY",locale,"en");
		var toDt	= convertDate(tdt.value,"DMY",locale,"en");
				
		if(!isBefore(fromDt,toDt,'DMY','en'))// DateUtils.js
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			tdt.value="";
			tdt.focus();
		}
		//IN056781 ends
	}
}
function datechecklistt(obj1, obj2, callFrom)
{		
		var toDate = '';
		var fromDate = '';
		if (callFrom == 'FROMDATE')
		{
			fromDate = obj1.value;	
			
		}
		else if (callFrom == 'TODATE')
		{
			toDate = obj2.value;
		}

		if (callFrom == 'FROMDATE' && fromDate != '')
		{
			getDates(fromDate, toDate,  callFrom);
		}
		else if (callFrom == 'TODATE' && toDate != '')
		{
			getDates(fromDate, toDate,  callFrom);
		}	
}

function getDates(fromDate, toDate,  callFrom)
{

	var formObj = document.Or0rderStatusTrackingRptForm;	
	var status=document.Or0rderStatusTrackingRptForm.p_status.value;
	if(status== 'EXT_ALL')
	{
		var tmplocale=formObj.language_id.value;
		var callFrom1 = 'GETDATES';
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH ";
		xmlStr += "callFrom=\""+ callFrom1 +"\" " ;
		xmlStr += "callFrom1=\""+ callFrom +"\" " ;
		xmlStr += "fromDate=\""+ fromDate +"\" " ;
		xmlStr += "toDate=\""+ toDate +"\" " ;		
		xmlStr += "tmplocale=\""+ tmplocale +"\" " ;		
		xmlStr +=" /></root>" ;	
		//alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//validate = "activity_type";
		xmlHttp.open( "POST", "OROrderTrackingRptValidate.jsp", false );
		
		xmlHttp.send( xmlDoc );
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText );
	}
}

function displayDate(fromDate,toDate){
		var formObj = document.Or0rderStatusTrackingRptForm;
		formObj.p_to_date.value=toDate;
		formObj.p_frm_date.value=fromDate;
}
function run(){
	var formobj=OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm;	
		fields = new Array( formobj.p_frm_date,formobj.p_to_date);
		names =  new Array(getLabel("Common.periodfrom.label","Common") ,getLabel("Common.periodto.label","Common"));
		var order_type_edit = ""
		if(formobj.p_order_type_code.value == "ALL" || formobj.p_order_type_code.value == "All")
		{
			order_type_edit = formobj.p_order_type_code.value;
			formobj.p_order_type_code.value = "";
		}
		if(OrOrderStatusTrackingRptFrame.checkFields(fields,names,messageFrame))
		{	
			var max_days=daysBetween(formobj.p_frm_date.value,formobj.p_to_date.value,"DMY",formobj.language_id.value);
			if(max_days > 365) {
				var errors=getMessage("PERIOD_SHOULD_LESS_THAN_YEAR","OR"); 
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				return false;
			}

			OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.action="../../eCommon/jsp/report_options.jsp";	
			if(OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.p_grp_by.value=="C")
			{
				formobj.p_order_catalog.value  = ""; //IN056781
				OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.p_report_id.value="ORORTSUM";
				OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.submit() ;	//IN056781	
			}
			else if(OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.p_grp_by.value=="O")
			{
				var catalog_value="";//IN056781_01
				OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.p_report_id.value="ORORTDTL";
				catalog_value = (formobj.p_order_catalog.value == '?')?'? ':formobj.p_order_catalog.value;//IN056781_01
				//formobj.p_order_catalog.value = encodeURIComponent(formobj.p_order_catalog.value); //IN056781
				formobj.p_order_catalog.value = encodeURIComponent(catalog_value); //IN056781_01
				OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.submit() ; //IN056781
				formobj.p_order_catalog.value = decodeURIComponent(formobj.p_order_catalog.value); //IN056781
			}
				//OrOrderStatusTrackingRptFrame.document.Or0rderStatusTrackingRptForm.submit() ;//IN056781		
		}	
		if(order_type_edit == "ALL")
		{
			formobj.p_order_type_code.value = "ALL";
		}
}
function enableOrderType() {
	if(document.Or0rderStatusTrackingRptForm.p_grp_by.value=="C") {
		//document.Or0rderStatusTrackingRptForm.p_order_type_code.disabled = true;
		document.getElementById("order_type_label").style.visibility = 'hidden';
		document.getElementById("order_type_value").style.visibility = 'hidden';
		document.getElementById("order_catalog_label").style.visibility = 'hidden';
		document.getElementById("order_catalog_value").style.visibility = 'hidden';
		document.Or0rderStatusTrackingRptForm.p_order_catalog.value = ""; //IN056781
		document.Or0rderStatusTrackingRptForm.P_CAT_FILTER_CRITERIA.options[0].selected = true; //IN056781
	}				
	else if(document.Or0rderStatusTrackingRptForm.p_grp_by.value=="O") {
		//document.Or0rderStatusTrackingRptForm.p_order_type_code.disabled = false;
		document.getElementById("order_type_label").style.visibility = 'visible';
		document.getElementById("order_type_value").style.visibility = 'visible';
		document.getElementById("order_catalog_label").style.visibility = 'visible';
		document.getElementById("order_catalog_value").style.visibility = 'visible';
	}
}
function validate_to_date(obj){
	var frdt = document.getElementById("p_frm_date");
	var tdt = document.getElementById("p_to_date");
	var locale =  document.getElementById("language_id").value;

	if(frdt.value !='' && tdt.value !='' )// DateUtils.js
	{
		//IN056781 starts
/*		if(validDate(frdt.value,"DMY",locale) && validDate(tdt.value,"DMY",locale))
		{
			var fromDt	= convertDate(frdt.value,"DMY",locale,"en");
			var toDt	= convertDate(tdt.value,"DMY",locale,"en");

			if(!isBefore(fromDt,toDt,'DMY',locale))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				frdt.focus();
			}
		}
*/

		
		
		if(!validDateObj(tdt,"DMY",locale))
		{
			return false;
		}
		var fromDt	= convertDate(frdt.value,"DMY",locale,"en");
		var toDt	= convertDate(tdt.value,"DMY",locale,"en");
		
		
		if(!isBefore(fromDt,toDt,'DMY','en'))// DateUtils.js
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			frdt.value="";
			frdt.focus();
		}
		//IN056781 ends
	}
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
function DateValidation(obj){
	curdate = document.forms[0].p_to_date;
	var msg="APP-SM0034 Date should be greater than or equal to Current Date";
	if(doDateCheckAlert(curdate,obj) == false){
		obj.focus();
		obj.select();
		alert(msg);
	}
}
