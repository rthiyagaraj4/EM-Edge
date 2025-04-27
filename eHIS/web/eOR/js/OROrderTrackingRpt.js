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
Date       Edit History      Name       	 Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
21/11/2012 IN036390			vijayakumark									For all the OR reports where the ?Report criteria? has ?Locations? as a filter, the system should only displays all the locations in that log in facility only
05/02/2014 IN047918			NijithaS										KDAH-CRF-0284
14/05/2014 IN049140			NijithaS										OR-Reports-Order Tracking Report-?Current IP List? does not get disable when Reset button is pressed.
10/11/2016	IN055010		Karthi L										MMS-QH-CRF-0213
31/07/2017	IN064890		Krishna Gowtham J	31/07/2017		Ramesh G	OR ->OR Reports -> Order Tracking Report -> Active Status Elapsed Orders check box not coming on Reset
02/06/2019	19208			Nijitha S			02/06/2019		Ramesh G	MOHE-SCF-0108-TF
--------------------------------------------------------------------------------------------------------------
*/ 
function reset(){
	//IN049140 Starts
	OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.P_IP_CHK_LIST.disabled=true;
	OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.P_IP_CHK_LIST.checked=false;
	OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.P_IP_CHK_LIST.value="N";
	//IN049140 Starts
	
//	OrorderTrackingRptFrame.Or0rderTrackingRptForm.all.ElapsedOrders.style.visibility="visible";//IN064890
	if (document.getElementById("ElapsedOrders")) {
		document.getElementById("ElapsedOrders").style.visibility = "visible";
	}
	OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.reset() ;
}

function orderingpractSearch1(target,code)
{
if(target.value!="")
	{
	orderingpractSearch(target,code);
	}
	else
	parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.p_ord_pract_id.value="";
} 

async function orderingpractSearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.language_id.value;
	var sql="SELECT practitioner_id code, practitioner_name description  FROM am_practitioner_lang_vw where  eff_status ='E'  and language_id='"+localeName+"' and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";//19208
	//sql=sql.replace('?',"'"+localeName+"' ");//19208
	
	argumentArray[0]   =sql;	
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

function callPatientSearch(){
	var pat_id =  PatientSearch();

	if(pat_id != null)
	document.getElementById("p_patient_id").value = pat_id;
}
function populateSourceLocation(p_source_type){
	var formObj = document.Or0rderTrackingRptForm;
	var localeName=formObj.language_id.value;
	
	if( p_source_type.value == "ALL" ) {
		// Commented By Abdulhamid Mohamed
//		document.Or0rderTrackingRptForm.SourceSearch.disabled=true;
//		document.Or0rderTrackingRptForm.source_locn_desc.disabled=true;
//		document.Or0rderTrackingRptForm.source_locn_desc.value="";
//		document.Or0rderTrackingRptForm.p_source_code.value="";
		
		// Added By Abdulhamid Mohamed
		document.getElementById('SourceSearch').disabled=true;
		document.getElementById('source_locn_desc').disabled=true;
		document.getElementById('source_locn_desc').value="";
		document.getElementById('p_source_code').value="";
		
		// Commented by Abdulhamid Mohamed
//		//KDAH-CRF-0284 Starts
//		document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST.disabled=true;
//		document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST.value="N";
//		document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST.checked=false;
//		//KDAH-CRF-0284 Ends
//		
		// Added By Abdulhamid Mohamed
		document.getElementById('P_IP_CHK_LIST').disabled=false;
		document.getElementById('P_IP_CHK_LIST').value="N";
		document.getElementById('P_IP_CHK_LIST').checked=false;
		
	}
	else
	{
	//var bean_id = formObj.bean_id.value ;
	// Commented By Abdulhamid Mohamed
//	document.Or0rderTrackingRptForm.SourceSearch.disabled=false;
//	document.Or0rderTrackingRptForm.source_locn_desc.disabled=false;
//	document.Or0rderTrackingRptForm.source_locn_desc.value="";
//	document.Or0rderTrackingRptForm.p_source_code.value="";
//	
	// Added By Abdulhamid Mohamed
	document.getElementById('SourceSearch').disabled=false;
	document.getElementById('source_locn_desc').disabled=false;
	document.getElementById('source_locn_desc').value="";
	document.getElementById('p_source_code').value="";
	
	//KDAH-CRF-0284 Starts
	if( p_source_type.value == "N" )
	{
		// commented by Abdulhamid Mohamed
//		document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST.disabled=false;
		// Added By Abdulhamid Mohamed
		document.getElementById('P_IP_CHK_LIST').disabled=false;
	}
	else
	{
		
//		commented by Abdulhamid Mohamed
//		document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST.disabled=true;	
//		document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST.value="N";
//		document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST.checked=false;
		
		// Added By Abdulhamid Mohamed
		document.getElementById('P_IP_CHK_LIST').disabled=false;
		document.getElementById('P_IP_CHK_LIST').value="N";
		document.getElementById('P_IP_CHK_LIST').checked=false;
		
	}
	//KDAH-CRF-0284 Ends
	}
}

async function populateMoveLoaction(target,code)
{
	
	
	location_type=parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.p_source_type.value;
	var facility_id =parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.p_facility_id.value;//IN036390
	if(location_type!='')
	{
	localeName=parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.language_id.value;
	var sql="";

	if(location_type=="C")
	{
	/*IN036390 starts here */
	//var sql="select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID=?  and upper(CLINIC_CODE) like upper(?) and upper(LONG_DESC) like upper(?)";
		 sql="select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='"+localeName+"'  and upper(CLINIC_CODE) like upper(?) and upper(LONG_DESC) like upper(?)and facility_id = '"+facility_id+"' ";//19208
		/*IN036390 ends here */
	}else if(location_type=="N")
	{
	/*IN036390 starts here */
		//var sql="select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID=?  and upper(NURSING_UNIT_CODE) like upper(?) and upper(LONG_DESC) like upper(?)";
		 sql="select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='"+localeName+"'  and upper(NURSING_UNIT_CODE) like upper(?) and upper(LONG_DESC) like upper(?) and facility_id = '"+facility_id+"' ";//19208
		/*IN036390 ends here */
	}//else if(location_type=="R")
	//{
	//	var sql=parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.referral_sql.value;
	//}
	//sql=sql.replace('?',"'"+localeName+"'");//19208
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

	retVal = await CommonLookup(getLabel("Common.Location.label","common") , argumentArray );
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
	
}


function populateMoveLoaction1(target,code)
{
if(target.value!="")
	{
		populateMoveLoaction(target,code);
	}
	else{
		parent.OrorderTrackingRptFrame.document.forms[0].p_source_code.value="";
	}
	
}
async function callPatientSearch(){
	var pat_id = await PatientSearch('','','','','','','Y','Y','Y','Visitreg');
  	if(pat_id != null) {
		if(pat_id.charAt(0)=="Y")
			pat_id =pat_id.substring(1,pat_id.length)
			document.getElementById("p_patient_id").value = pat_id;
	}
}
function callActivitySearch1(target,code)
{
if(target.value!="")
	{
	callActivitySearch(target,code);
	}
	else
	parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.p_activity_type.value="";
}


async function callActivitySearch(target,code)
{
	var p_order_category=parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.p_order_category.value;
	
	if(p_order_category=='ALL')
	{
		p_order_category='';
	}
	else
		p_order_category=p_order_category;

	//alert(parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.p_order_category.value);

	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.language_id.value;
	dataNameArray[0] 	= "order_category" ;		 
  	dataValueArray[0] 	= p_order_category;//parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.p_order_category.value;
	dataTypeArray[0] 	= STRING ;
	dataNameArray[1] 	= "order_type_code" ;		 
  	dataValueArray[1] 	= parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.p_order_type_code.value;
 	dataTypeArray[1] 	= STRING ;
	
	var sql="SELECT activity_type code, short_desc description FROM or_activity_type_lang_vw WHERE language_id='"+localeName+"' and order_category like ? AND  (order_type_code  like ? OR order_type_code ='*ALL' ) and eff_status ='E'  and upper(ACTIVITY_TYPE) like upper(?) and upper(SHORT_DESC) like upper(?)";//19208 
	//sql=sql.replace('?',"'"+localeName+"'");//19208
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retVal= await CommonLookup(getLabel("eOR.ActivityType.label","OR"),argumentArray);
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

function checkTrackingStatus(obj) {
	//alert(obj.value);
	if (obj.value == 'EXT_ALL'){
		//alert(obj.value);
		// Commented By Abdulhamid Mohamed
//		document.Or0rderTrackingRptForm.all.p_period_from.value=document.Or0rderTrackingRptForm.prev_date.value;
//		document.Or0rderTrackingRptForm.all.p_period_to.value = document.Or0rderTrackingRptForm.curr_sys_date.value;
		// Added By Abdulhamid Mohamed
        document.getElementById('p_period_from').value=document.Or0rderTrackingRptForm.prev_date.value;
        document.getElementById('p_period_to').value= document.Or0rderTrackingRptForm.curr_sys_date.value;
		
       } else {
//    	   document.Or0rderTrackingRptForm.all.p_period_from.value=document.Or0rderTrackingRptForm.all.tempdate.value;
//			document.Or0rderTrackingRptForm.all.p_period_to.value = document.Or0rderTrackingRptForm.all.curr_sys_date.value;
    	   document.getElementById('p_period_from').value=document.getElementById("tempdate").value;
    	   document.getElementById('p_period_to').value = document.getElementById("curr_sys_date").value;
		   
        }
		displayElapsedFields(obj);
}
function FillOrderType(OrderCatObj){
	
	var bean_id =document.Or0rderTrackingRptForm.bean_id.value ;
	var callFrom1="ORDERCAT";
    var ordercatname=OrderCatObj.name;
	var ordercatvalue=OrderCatObj.value;
    var tmplocale=document.Or0rderTrackingRptForm.language_id.value;
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
	displayElapsedFields(document.Or0rderTrackingRptForm.p_status);
}

function addLocationList1(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.Or0rderTrackingRptForm.p_order_type_code.add(element);
}
function clearList1( docObj ) {
	var len = eval(docObj+".forms[0].p_order_type_code.options.length") ;
		//	alert(len);
		for(var i=0;i<len;i++){
		eval(docObj+".Or0rderTrackingRptForm.p_order_type_code.remove(\"locn\")") ;
		}
		var tp = getLabel("Common.all.label","Common") ;
		var opt = eval(docObj+".createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "ALL" ;
		eval(docObj+".Or0rderTrackingRptForm.p_order_type_code.add(opt)") ;
}
function populateLocnActivityType(){
	/*
	
	var formObj = document.Or0rderTrackingRptForm;
	var callFrom1 = "ORDERTYPE";
	var bean_id = formObj.bean_id.value ;
	var tmplocale=formObj.templocale.value;
	var order_category=formObj.p_order_category.value;
	var order_type=formObj.p_order_type_code.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH ";
		xmlStr += "callFrom=\""+ callFrom1 +"\" " ;
		//xmlStr += "callFrom1=\""+ callFrom +"\" " ;
		xmlStr += "order_category=\""+ order_category +"\" " ;
		xmlStr += "bean_id=\""+ bean_id +"\" " ;	
		xmlStr += "order_type=\""+ order_type +"\" " ;	
		xmlStr += "tmplocale=\""+ tmplocale +"\" " ;
		xmlStr +=" /></root>" ;	
       xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//validate = "activity_type";
		xmlHttp.open( "POST", "OROrderTrackingRptValidate.jsp", false );
		xmlHttp.send( xmlDoc );
		responseText=xmlHttp.responseText ;
	eval(responseText );
*/
}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
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
/*function ValidateDateTimeOfPeriod(Objfrom,objTo,obj)
{
	
	var from_date=parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.p_period_from.value;
	var to_date=parent.OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.p_period_to.value;
	
	if(objTo.value !="" && Objfrom.value != "")
	{
		if(!ValidateDateTime(Objfrom,objTo))
		{
			if(obj.name=='TODATE')
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"))
				objTo.value=to_date;
				objTo.focus();
				return false
			}
			else if(obj.name=='FROMDATE')
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"))
				Objfrom.value=from_date;
				Objfrom.focus();
				return false
			}
		}
	}
}*/
/*function validateDateTime(obj,val)
		{
			if(obj.value != ''){
				if(val == 'E'){
					if(!doDateTimeChk(obj)){
						alert(getMessage('INVALID_DATE_TIME','SM'));
						obj.select();
						obj.focus();
					}
				}
				else if(val == 'D'){
					if(CheckDate(obj)){}
				}
				else if(val == 'T')
				{
					if(!chkTime(obj.value))
					{
						alert(getMessage('INVALID_TIME_FMT','OR'));
						obj.select();
						obj.focus();
					}
				}
			}
		}*/
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

	var formObj = document.Or0rderTrackingRptForm;	
	var status=document.Or0rderTrackingRptForm.p_status.value;
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
		var formObj = document.Or0rderTrackingRptForm;
		formObj.p_period_to.value=toDate;
		formObj.p_period_from.value=fromDate;
}


function callSearch(){
 	if(window.event.keyCode==13) {    // if it is an enter key, then populate a
   	 	//populateValues();   // Call the additionalSearch 
	}
}
function ChkElapseOrders(obj)
	{
		/*if(document.Or0rderTrackingRptForm.all.elapsed_orders)
		{*/
			if(obj.checked==true)
			{
				obj.value="Y";
			}
			else
			{
				obj.value="N";
			}
		//}
	}
	function displayElapsedFields(Obj)
	{
		var order_category="";		
		if(Obj.value=="EXT_ACTIVE")
		{
			document.getElementById('ElapsedOrders').style.visibility="visible";
			order_category=document.Or0rderTrackingRptForm.p_order_category.value;			
			if(order_category!=""&&((order_category=="RX")||(order_category=="MI")||(order_category=="OT")||(order_category=="OH")))
			{
				// Commented By Abdulhamid Mohamed
//				document.Or0rderTrackingRptForm.all.p_elapsed_order_yn.checked=false;
//				document.Or0rderTrackingRptForm.all.p_elapsed_order_yn.disabled=true;
//				document.Or0rderTrackingRptForm.all.p_elapsed_order_yn.value="N";
				
				// Added By Abdulhamid Mohamed
				document.getElementById('p_elapsed_order_yn').checked=false;
				document.getElementById('p_elapsed_order_yn').disabled=true;
				document.getElementById('p_elapsed_order_yn').value="N";
			}
			else
			{
				// Commented By Abdulhamid Mohamed
//				document.Or0rderTrackingRptForm.all.p_elapsed_order_yn.checked=false;
//				document.Or0rderTrackingRptForm.all.p_elapsed_order_yn.disabled=false;
//				document.Or0rderTrackingRptForm.all.p_elapsed_order_yn.value="N";
				
				// Added By Abdulhamid Mohamed
				document.getElementById('p_elapsed_order_yn').checked=false;
				document.getElementById('p_elapsed_order_yn').disabled=false;
				document.getElementById('p_elapsed_order_yn').value="N";
			}
		}
		else
		{
//			document.Or0rderTrackingRptForm.all.ElapsedOrders.style.visibility="hidden";
			document.getElementById('ElapsedOrders').style.visibility="hidden";
		}
	}

function run(){
    var formobj=OrorderTrackingRptFrame.document.Or0rderTrackingRptForm;	
	var patid=formobj.p_patient_id.value;
	var lction=formobj.p_source_code.value;	
	var isSiteSpecific = formobj.isSiteSpecific.value; //MMS-QH-CRF-0213 [IN055010]
	var P_IP_CHK_LIST = formobj.P_IP_CHK_LIST.value;//KDAH-CRF-0284 Starts
	var names = getLabel("Common.patientId.label","Common");
	var names1 = getLabel("Common.Location.label","Common");
	var names2=names+" "+"0r"+" "+names1;		
	//if(patid !="" || lction !="" )//Commented for KDAH-CRF-0284
	//MMS-QH-CRF-0213 [IN055010] - Start
	if(isSiteSpecific == 'true') {
		fields = new Array( formobj.p_period_from,formobj.p_period_to);
		names =  new Array(getLabel("Common.periodfrom.label","Common") ,getLabel("Common.periodto.label","Common"));

		if(OrorderTrackingRptFrame.checkFields(fields,names,messageFrame))
		{
			OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.action="../../eCommon/jsp/report_options.jsp";			
			OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.submit() ;					
		}	
	} else { //MMS-QH-CRF-0213 [IN055010] - End
		if(patid !="" || lction !="" || (P_IP_CHK_LIST=='Y' && lction ==""))//KDAH-CRF-0284
		{
			fields = new Array( formobj.p_period_from,formobj.p_period_to);
			names =  new Array(getLabel("Common.periodfrom.label","Common") ,getLabel("Common.periodto.label","Common"));
	
				if(OrorderTrackingRptFrame.checkFields(fields,names,messageFrame))
				{
					OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.action="../../eCommon/jsp/report_options.jsp";			
					OrorderTrackingRptFrame.document.Or0rderTrackingRptForm.submit() ;					
				}			
		}
		else{ 
			errorMsg = "APP-OR0414 Patient Id or Location must be entered";
			//errorMsg =getMessage("OR_ORDER_TRACKING_RPT_MANDATORY","OR");
			//alert(errorMsg);
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errorMsg ;
		}
	}
}
	
/*function chckDate(Object2,focusflag,localeName)
{
	if(Object2.value!=""){
		if(validDateObj(Object2,"DMY",localeName)==false)
	{
	document.Or0rderTrackingRptForm.p_period_from.select();
    }
	}else{
		document.Or0rderTrackingRptForm.p_period_from.value="";//document.Or0rderTrackingRptForm.tempdate.value;
	}
}*/

/*function chckDate1(Object2,focusflag,localeName)
{
	if(Object2.value!=""){
		if(validDateObj(Object2,"DMY",localeName)==false)
	{
	  document.Or0rderTrackingRptForm.p_period_to.select();
    }
	}else{
		document.Or0rderTrackingRptForm.p_period_to.value="";//document.Or0rderTrackingRptForm.tempdate.value;
		}
}*/


function validate_to_date(obj){
	
	var toDate=obj;
	var fromDate="";
	if(obj.name!="ALL"){
		fromDate=document.forms[0].p_period_from;
		toDate=document.forms[0].p_period_to;
	}
     if(fromDate.length>0){
		if(fromDate!=fromDate){
			DateValidation(obj);
		}
		if(!doDateChecknew(fromDate,toDate)){
			alert( "APP-SM0012 - To Date should be greater than or equal to From Date" );
			obj.focus();
			
		}
	}
	return true
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
	curdate = document.forms[0].p_period_to;
	var msg="APP-SM0034 Date should be greater than or equal to Current Date";
	if(doDateCheckAlert(curdate,obj) == false){
		obj.focus();
		obj.select();
		alert(msg);
	}
}
	
/*function doDateCheckAlert(from,to){
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
}*/


//KDAH-CRF-0284 Starts
// Commented By Abdulhamid Mohamed
//function ChkCurrectIPList()
//{
//	
//	if(document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST)
//	{
//		if(document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST.checked==true)
//		{
//			document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST.value="Y";
//		}
//		else
//		{
//			document.Or0rderTrackingRptForm.all.P_IP_CHK_LIST.value="N";
//		}
//	}
//}
// Added By Abdulhamid Mohamed
function ChkCurrectIPList()
{
	
	if(document.getElementById('P_IP_CHK_LIST'))
	{
		if(document.getElementById('P_IP_CHK_LIST').checked==true)
		{
			document.getElementById('P_IP_CHK_LIST').value="Y";
		}
		else
		{
			document.getElementById('P_IP_CHK_LIST').value="N";
		}
	}
}
//KDAH-CRF-0284 Ends
