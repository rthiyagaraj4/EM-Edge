/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       	Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           										created

08/01/2013   IN036513       Karthi L    										System displaying all the locations, including  Facility 2  locations in the  Location search criteria
26/12/2013   IN045729   	Chowminya											[Reopen]Appointments slip showing a blank page for radiology orders Multi-facility
05/02/2014 	 IN047918		NijithaS
15/08/2016	 IN059315		Raja S			18/08/2016		Ramesh G			When an appointment is given is RIS PACS for a radiology order placed from eHIS the order status in eHIS changes to Appointment Scheduled. But the actual appointment display is in order comments and in the Audit trail.											KDAH-CRF-0284
16/03/2017	 IN063736		Raja S			24/03/2017		Ramesh G			MMS-DM-SCF-0403
28/08/2017	IN065091		Krishna Gowtham J 	29/08/2017		Ramesh G		GHL-CRF-0440.1
16/10/2017		IN065433		Krishna Gowtham J 	16/10/2017		Ramesh G		OR-ML-MMOH-CRF-0560/01-Result Reporting
05/11/2018	IN068986		Ramya Maddena		05/11/2018		Ramesh G		MO-CRF-20137.1
28/09/2020		ord_track		Nijitha S			28/09/2020		Nijitha S	Interaction Dtls not working in order tracking	
24/02/2022	25671			Ramesh G											NMC-JD-CRF-0091.2	
02/11/2022   35142          Krishna Pranay  03/11/2022       Ramesh G                TH-KW-CRF-0020.6	
---------------------------------------------------------------------------------------------------------------
*/ 

var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";

function populateLocationOnChange(location_type){
//PatOrderByPrivReln_search
var formObj = document.PatOrderByPrivReln_search;
var bean_id = document.PatOrderByPrivReln_search.bean_id.value ;
//var xmlDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
//var xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
var xmlHttp = new XMLHttpRequest();
xmlStr ="<root><SEARCH " ;
xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
xmlStr +=" /></root>" ;
//xmlDoc.loadXML( xmlStr ) ;
var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
xmlHttp.open( "POST", "PatOrderByPrivRelnValidate.jsp?bean_id=" + bean_id + " &default_val=''&validate=ord_cat", false ) ;
xmlHttp.send( xmlDoc ) ;
responseText=xmlHttp.responseText ;

eval(responseText )	;

}

async function populateMoveLoaction1(target,code)
{
if(target.value!="")
	{
	await populateMoveLoaction(target,code);
	}
	else
		parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.locn.value="";
}

function alignHeading()
{

	if(parent.framePatOrderByPrHeaderDtl.document.getElementById("tableheader")!=null)
	{
			parent.framePatOrderByPrHeaderDtl.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				for (j=0; j < document.getElementById("tableresult").rows(1).cells.length; j++) 
				{
					var wid=eval(document.getElementById("tableresult").rows(1).cells(j).offsetWidth);
					//var wid1=eval(parent.framePatOrderByPrHeaderDtl.document.getElementById("tableheader").rows(0).cells(j).offsetWidth);
				
					if(parent.framePatOrderByPrHeaderDtl.document.getElementById("tableheader").rows(0).cells(j) != null)
					{
						//if(wid>wid1)
						parent.framePatOrderByPrHeaderDtl.document.getElementById("tableheader").rows(0).cells(j).width=wid;
						//else
						//document.getElementById("tableresult").rows(1).cells(j).width=wid1;
					}
				}
		}
		
	}

	function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.framePatOrderByPrHeaderDtl.location.href.indexOf(".jsp") != -1)
	{
		parent.framePatOrderByPrHeaderDtl.document.body.scrollLeft=temp;
	}
}

	async function populateMoveLoaction(target,code)
{
	var facilityid=parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.facilityid.value; // added for IN036513
	
	location_type=parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.location_type.value;
if(location_type!='')
	{
	localeName=parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.localeName.value;
	var sql="";

	if(location_type=="C")
	{
		//sql="select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(CLINIC_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		//var sql=parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.clinic_sql.value; commented for IN036513
		var sql = "select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID=? and upper(CLINIC_CODE)  like upper(?) and upper(LONG_DESC) like upper(?) and upper(FACILITY_ID) like upper('"+facilityid+"')"; // modified for IN036513
	}else if(location_type=="N")
	{
		//sql="select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(NURSING_UNIT_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
	//	var sql=parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.nursing_sql.value; commented for IN036513
		var sql = " select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID=?  and upper(NURSING_UNIT_CODE) like upper(?) and upper(LONG_DESC) like upper(?) and upper(FACILITY_ID) like upper('"+facilityid+"') ";  // modified for IN036513
	}else if(location_type=="R")
	{
		//sql="select REFERRAL_CODE code ,LONG_DESC description from AM_REFERRAL_LANG_VW where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(REFERRAL_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.referral_sql.value;
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

	retVal = await CommonLookup(getLabel("Common.Location.label","common") , argumentArray );

	if(retVal !=null && retVal != ""){
		var str =unescape(retVal);
		var arr = str.split(",");
		code.value=arr[0];
		target.value=arr[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
		//target.value=getLabel("Common.all.label","Common");
 	}
	}
	
}

function populateSourceLocation(source_location_type){
//	getSystemDate();

	var formObj = document.PatOrderByPrivReln_search;
	var localeName=formObj.localeName.value;
	if( source_location_type.value == "" ) {
		document.PatOrderByPrivReln_search.SourceSearch.disabled=true;
		document.PatOrderByPrivReln_search.source_locn_desc.value="";
		document.PatOrderByPrivReln_search.locn.value="";
		//IN047918 Starts
		document.PatOrderByPrivReln_search.current_ip_list_check.disabled=true;
		document.PatOrderByPrivReln_search.current_ip_list_check.value="N";
		document.PatOrderByPrivReln_search.current_ip_list_check.checked=false;
		//IN047918 Ends
	}
	else
	{
	var bean_id = formObj.bean_id.value ;
	document.PatOrderByPrivReln_search.SourceSearch.disabled=false;
	document.PatOrderByPrivReln_search.source_locn_desc.value="";
	document.PatOrderByPrivReln_search.locn.value="";
	//IN047918 Starts
	if( source_location_type.value == "N" )
	{
		document.PatOrderByPrivReln_search.current_ip_list_check.disabled=false;
	}
	else
	{
		document.PatOrderByPrivReln_search.current_ip_list_check.disabled=true;
		document.PatOrderByPrivReln_search.current_ip_list_check.value="N";
		document.PatOrderByPrivReln_search.current_ip_list_check.checked=false;
	}
	//IN047918 Ends
	/*var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlStr ="<root><SEARCH " ;
	xmlStr += source_location_type.name+"=\""+ source_location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    var flag='true';
	xmlHttp.open( "POST", "PatOrderByPrivRelnValidate.jsp?bean_id=" + bean_id + " &default_val=''&validate=ord_cat", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText)*/
	}
}

function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.PatOrderByPrivReln_search.locn.add(element);
}

function clearList( docObj ) {
document.PatOrderByPrivReln_search.locn.value="";
document.PatOrderByPrivReln_search.source_locn_desc.value="";

}
/////////////////

//this fucntion is used to clear the entries of search criteria
//this is used for patient ID search

async function callPatientSearch(){
	var pat_id = await  PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}

async function callPatientSearch1(){
	var pat_id = await  PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId1").value = pat_id;
}

//called on click of search
function populateValues()
{	
	var formObj = document.PatOrderByPrivReln_search;
	var order_by = formObj.order_by.value;
	var view_by = formObj.view_by.value;
	var status = formObj.status.value;
	var current_ip_list_check = "N";//IN047918
	var BTColorYN	= formObj.BTColorYN.value; //IN065091

	if(formObj.patientId.value=="")
	{
		var days=daysBetween(formObj.period_from.value,formObj.period_to.value,
			"DMY",formObj.templocale.value);

		if(status=="EXT_ALL" && days>1)
		{		
			alert(getMessage("ORDERTRACKING_SEARCH_VALIDATE","OR"));
			return false;			
		}
		else if(days>7)
		{
			parent.framePatOrderByPrResult.location.href = "../../eCommon/html/blank.html";
			parent.framePatOrderByPrColor.location.href="../../eCommon/html/blank.html";
			alert(getMessage("ORDERTRACKING_SEARCH_VALIDATE","OR"));
			return false;
		}

	}
	//var QRY_STRING ="order_status="+formObj.status.value+"&pat_id1="+ formObj.patientId.value+"&encounterId="+ formObj.encounterId.value+"&period_from="+formObj.period_from.value+"&period_to="+formObj.period_to.value+"&location_type="+formObj.location_type.value+"&locn="+formObj.locn.value+"&order_type="+formObj.order_type.value +"&order_cat="+formObj.order_category.value+"&curr_sys_date="+formObj.curr_sys_date.value +"&order_by="+formObj.order_by.value+"&order_catelog="+formObj.item.value+"&ordering_pract="+formObj.ordering_pract.value+"&search_crt="+formObj.search_crt.value+"&priority="+formObj.urgency.value;


	if(formObj.period_from.value != "")
	{
		if(!isAfter(formObj.period_to.value,formObj.period_from.value,"DMY",
			formObj.templocale.value))//this function is available in eCommon/js/DateUtils.js
		{			
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			if(parent.framePatOrderByPrHeaderDtl)
			{
				parent.framePatOrderByPrHeaderDtl.location.href="../../eCommon/html/blank.html";
			}
			parent.framePatOrderByPrResult.location.href = "../../eCommon/html/blank.html";
			parent.framePatOrderByPrColor.location.href="../../eCommon/html/blank.html";
			return false ;
		}
	}
	else
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', "From Date");
		alert(error);
		formObj.period_from.focus();
		return false;
		
	}	

	/*
		Added by kishore kumar N on 02-05-2010,
		Validating date for better tuning.
	*/

	var ptID = formObj.patientId.value;
	var locale = formObj.localeName.value;
	var toDate = formObj.period_to;
	var fromDate = formObj.period_from;
	var encounterID = formObj.encounterId.value;

	if((ptID == '' && encounterID == '') && !dateRangeValidation(fromDate, toDate, locale, '7', 'DMY'))
	{
		//parent.framePatOrderByPrHeaderDtl.location.href="../../eCommon/html/blank.html";
		parent.framePatOrderByPrResult.location.href = "../../eCommon/html/blank.html";
		parent.framePatOrderByPrColor.location.href="../../eCommon/html/blank.html";
		alert("  tst   "+getMessage("VALIDATE_DATE_ON_SEARCH_WITH_ENC", "OR"))
	}
	else
	{
		if(parent.framePatOrderByPrHeaderDtl)
		{
			parent.framePatOrderByPrHeaderDtl.location.href = 
				"../../eOR/jsp/PatOrderByPrHeader.jsp?order_by="+order_by+"&view_by="+view_by;
		}
		parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.search.disabled = true;

		elapsed_orders = "";
		sys_cancelled_orders = "";
		if(formObj.elapsed_orders)
			elapsed_orders	= formObj.elapsed_orders.value;
		if(formObj.sys_cancelled_orders)
			sys_cancelled_orders	= formObj.sys_cancelled_orders.value;
		//IN047918 Starts	
		if(formObj.current_ip_list_check)
			current_ip_list_check	= formObj.current_ip_list_check.value;
		//parent.framePatOrderByPrResult.location.href = "../../eOR/jsp/PatOrderByPRSearchResult.jsp?order_status="+formObj.status.value+"&pat_id1="+ formObj.patientId.value+"&encounterId="+ formObj.encounterId.value+"&period_from="+formObj.period_from.value+"&period_to="+formObj.period_to.value+"&location_type="+formObj.location_type.value+"&locn="+formObj.locn.value+"&order_type="+formObj.order_type.value +"&order_cat="+formObj.order_category.value+"&curr_sys_date="+formObj.curr_sys_date.value +"&order_by="+formObj.order_by.value+"&order_catelog="+formObj.item.value+"&ordering_pract="+formObj.ordering_pract.value+"&search_crt="+formObj.search_crt.value+"&priority="+formObj.urgency.value+"&practitioner_id="+ formObj.practitioner_id.value+"&activity_type="+formObj.activity_type.value+"&view_by="+view_by+"&elapsed_orders="+elapsed_orders+"&sys_cancelled_orders="+sys_cancelled_orders;
		//IN065091 starts
		//parent.framePatOrderByPrResult.location.href = "../../eOR/jsp/PatOrderByPRSearchResult.jsp?order_status="+formObj.status.value+"&pat_id1="+ formObj.patientId.value+"&encounterId="+ formObj.encounterId.value+"&period_from="+formObj.period_from.value+"&period_to="+formObj.period_to.value+"&location_type="+formObj.location_type.value+"&locn="+formObj.locn.value+"&order_type="+formObj.order_type.value +"&order_cat="+formObj.order_category.value+"&curr_sys_date="+formObj.curr_sys_date.value +"&order_by="+formObj.order_by.value+"&order_catelog="+formObj.item.value+"&ordering_pract="+formObj.ordering_pract.value+"&search_crt="+formObj.search_crt.value+"&priority="+formObj.urgency.value+"&practitioner_id="+ formObj.practitioner_id.value+"&activity_type="+formObj.activity_type.value+"&view_by="+view_by+"&elapsed_orders="+elapsed_orders+"&sys_cancelled_orders="+sys_cancelled_orders+"&current_ip_list_check="+current_ip_list_check;
		parent.framePatOrderByPrResult.location.href = "../../eOR/jsp/PatOrderByPRSearchResult.jsp?order_status="+formObj.status.value+"&pat_id1="+ formObj.patientId.value+"&encounterId="+ formObj.encounterId.value+"&period_from="+formObj.period_from.value+"&period_to="+formObj.period_to.value+"&location_type="+formObj.location_type.value+"&locn="+formObj.locn.value+"&order_type="+formObj.order_type.value +"&order_cat="+formObj.order_category.value+"&curr_sys_date="+formObj.curr_sys_date.value +"&order_by="+formObj.order_by.value+"&order_catelog="+formObj.item.value+"&ordering_pract="+formObj.ordering_pract.value+"&search_crt="+formObj.search_crt.value+"&priority="+formObj.urgency.value+"&practitioner_id="+ formObj.practitioner_id.value+"&activity_type="+formObj.activity_type.value+"&view_by="+view_by+"&elapsed_orders="+elapsed_orders+"&sys_cancelled_orders="+sys_cancelled_orders+"&current_ip_list_check="+current_ip_list_check+"&BTColorYN="+BTColorYN;
		//IN047918 Ends
		//parent.framePatOrderByPrColor.location.href="../../eOR/jsp/ExistingOrderResultsColors.jsp?function=OrderTracking&view_by="+view_by;
		parent.framePatOrderByPrColor.location.href="../../eOR/jsp/ExistingOrderResultsColors.jsp?function=OrderTracking&view_by="+view_by+"&BTColorYN="+BTColorYN;
		//IN065091 ends
	}

	/*
		ends here.
	*/


	//parent.framePatOrderByPrResult.location.href = "../../eOR/jsp/PatOrderByPRSearchResult.jsp?order_status="+formObj.status.value+"&pat_id1="+ formObj.patientId.value+"&encounterId="+ formObj.encounterId.value+"&period_from="+formObj.period_from.value+"&period_to="+formObj.period_to.value+"&location_type="+formObj.location_type.value+"&locn="+formObj.locn.value+"&order_type="+formObj.order_type.value +"&order_cat="+formObj.order_category.value+"&curr_sys_date="+formObj.curr_sys_date.value +"&order_by="+formObj.order_by.value+"&order_catelog="+formObj.item.value+"&ordering_pract="+formObj.ordering_pract.value+"&search_crt="+formObj.search_crt.value+"&priority="+formObj.urgency.value+"&practitioner_id="+ formObj.practitioner_id.value+"&activity_type="+formObj.activity_type.value;


	//parent.PatOrderByPRHeader.location.href = "../jsp/PatOrderByPrivRelnHeader.jsp";
	//parent.PatOrderByPRResult.location.href = "../../jsp/PatOrderByPRSearchResult.jsp?"+QRY_STRING;

}

//called on click of clear button in search criteria
function clearValues(){
	//document.PatOrderByPrivReln_search.reset();
	//parent.framePatOrderByPrivRelnSearch.location.reload();// commented for IN065433	
	parent.framePatOrderByPrivRelnSearch.location.href=parent.framePatOrderByPrivRelnSearch.location.href+"&load_search=N";//IN065433
	if(parent.framePatOrderByPrHeaderDtl)
	{
		parent.framePatOrderByPrHeaderDtl.location.href = "../../eCommon/html/blank.html"
	}
	parent.framePatOrderByPrResult.location.href = "../../eCommon/html/blank.html"
	parent.framePatOrderByPrColor.location.href = "../../eCommon/html/blank.html"
}

function checkDate(obj){
	if(!(trimCheck(obj.value)))
	{
		obj.value = "";
		return false;
	}
	if(!(checkDt(obj.value))){
		alert(getMessage("INVALID_DATE_FMT","SM"));
		//obj.select();
		obj.value="";
		obj.focus();
		return false;
	}
}

function checkDate1(obj){
	var dt = new Date()
	var fromDate = document.PatOrderByPrivReln_search.date_from
	var toDate = document.PatOrderByPrivReln_search.date_to
	if(!(trimCheck(obj.value)))
	{
		obj.value = "";
		return false;
	}

	if(!(checkDt(obj.value))){

		obj.select();
		obj.focus();
		return false;
	}

	if(!(doDateCheck(fromDate,toDate,parent.parent.messageFrame)))
		return false
}

/*function insert(){
	var no_of_checked = 0;

	var formObj = parent.SpecimenOrderResult.document.specimen_reporting_dtl
	formObj.option_list.value 		= parent.PatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.option_list.value
	formObj.specimen_hdr_date_time.value = parent.PatOrderByPrivRelnHeader.document.specimen_order_hdg.specimen_date_time.value
	for(cnt=0; cnt<formObj.total_recs.value; cnt++){
//		val = eval("parent.PatOrderByPrivRelnResult.document.specimen_reporting_dtl.select"+cnt);

		if(val.checked == true)
			no_of_checked++;
	}
	if(no_of_checked == 0){
		alert(getOrMessage("CLICK_ANY_ONE"))
		return false
	}
		eval(formApply( parent.PatOrderByPrivRelnResult.document.specimen_reporting_dtl,OR_CONTROLLER)) ;
		top.content.messageframe.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result ) {
			onSuccess();
		}
}
  */
function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;

}

function onSuccess() {
		parent.PatOrderByPrivRelnResult.location.reload();

}

//this function will give the final xml string on click of apply
function beforePost(str) {


}
//function callMenuFunctions(colval1,colval,orderId,sex,patient_id,order_line_num){//ord_track
async function callMenuFunctions(colval1,colval,orderId,sex,patient_id,order_line_num,encounter_id){//ord_track

		var dialogHeight ='70vh' ;
		var dialogWidth = '60vw' ;
		var dialogTop	= '10';
		var dialogLeft = '10' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		
		if((colval1=="ViewReplacedOrder")||(colval1=="ViewOriginalOrder"))
		{
			//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlHttp = new XMLHttpRequest() ;
			var bean_id				=  "";
			var bean_name			=  "";
			bean_id		  = document.formPatOrderByPRSearchResult.bean_id.value;
			bean_name	  = document.formPatOrderByPRSearchResult.bean_name.value;
			var func_mode = colval1;
			xmlStr ="<root><SEARCH " ;
			xmlStr += " orderId=\""+ orderId +"\" " ;
			xmlStr +=" /></root>" ;
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "PatOrderByPrivRelnValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate="+func_mode,false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText = xmlHttp.responseText ;
			if((responseText!=null)||(responseText!=undefined))
				orderId = responseText;		
		}

		var arguments = "";
		//var finalString	= "colval1="+colval1+ "&colval=" +colval+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&order_line_num="+order_line_num;//ord_track
		var finalString	= "colval1="+colval1+ "&colval=" +colval+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&order_line_num="+order_line_num+"&encounter_id="+encounter_id;//ord_track
		var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}

 function OrCheckTimeFormat(obj) {
   var sequence = "1234567890:";
   var obj_value = obj.value;
   var obj_length = obj_value.length;
   var firstString="";
   var  lastString="";
	var len="";
   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
				alert(getMessage('ONLY_POSITIVE_NUM','OR'));
				obj.focus();
				return false;
		}
   }
   if (!( sequence.indexOf(":")  == -1) ){
	    len= obj_value.indexOf(":");
		if(len!=-1){
		firstString=obj_value.substr(0 ,len ) ;
			if(firstString>=24){
				alert(getMessage("INVALID_TIME_FMT","OR"));
				obj.focus();
				}
	    lastString=obj_value.substr(len+1 ,obj_length ) ;
		if (lastString>=60)
		{
			alert(getMessage("INVALID_TIME_FMT","OR"));
							obj.focus();
		}
	 }
   }
   else{
   if(obj_value>=24){
		alert(getMessage("INVALID_TIME_FMT","OR"));
   }
 }
}
// Included by MOHAMED
function displayHeaderDate() {
		if(parent.PatOrderByPrivRelnHeader.specimen_order_hdg.specimen_date_time.value=='')
		  specimen_date_time = "";
		else
		  specimen_date_time = parent.PatOrderByPrivRelnHeader.specimen_order_hdg.specimen_date_time.value
		var returnVal = displayDate(specimen_date_time)
		parent.PatOrderByPrivRelnHeader.specimen_order_hdg.specimen_date_time.value = returnVal
		specimen_date_time = returnVal
		if(specimen_date_time != "" )	{
			document.getElementById("hdr").href="javascript:displayHeaderDate()" ;
		}else{
			document.getElementById("hdr").href="";
			parent.PatOrderByPrivRelnHeader.specimen_order_hdg.specimen_date_time.value = "";
		}
}
async function displayDate(specimen_date_time){
	curr_sys_date = parent.PatOrderByPrivRelnResult.document.specimen_reporting_dtl.curr_sys_date.value;
	var dialogHeight= '18' ;
	var dialogWidth = '24' ;
	var dialogTop	= '290';
	var dialogLeft 	= '280' ;
	var title 	= ''
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments 	= "";
	var retVals = await window.showModalDialog("../../eOR/jsp/PatOrderByPrivRelnDate.jsp?&specimen_date_time="+specimen_date_time+"&curr_sys_date="+curr_sys_date,arguments,features);
	return retVals
}
function closeDate()
{
	window.returnValue = document.specimenDate.specimen_date_time.value;
	window.close();
}

function clickLine(obj,rec_num){
	if(obj.checked == true ){
		obj.value = "Y";
		var specimen_date_time = eval("parent.PatOrderByPrivRelnResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value
		var returnVal = "";
		var totalResult=parent.PatOrderByPrivRelnResult.document.specimen_reporting_dtl.total_recs.value;
		if(parent.PatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.option_list.value=="C" && totalResult > 0)
		var returnVal = displayDate(specimen_date_time)
		if(returnVal!='')
			eval("parent.PatOrderByPrivRelnResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value = returnVal
		if(eval("parent.PatOrderByPrivRelnResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value != "" ){
			document.getElementById('lins'+rec_num).href="javascript:clickLine(\"document\","+rec_num+")" ;
		}
	}else{
		obj.value = "N";
		document.getElementById('lins'+rec_num).href="#";
		eval("parent.PatOrderByPrivRelnResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value = "";
		parent.PatOrderByPrivRelnHeader.specimen_order_hdg.hdr.href="#";
	}

}
function clearActivityTypeList( docObj ) {
	var len = eval(docObj+".PatOrderByPrivReln_search.activity_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".PatOrderByPrivReln_search.activity_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     ---"+getLabel("Common.all.label","Common")+"---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".PatOrderByPrivReln_search.activity_type.add(opt)") ;
}
function populateLocnActivityType(){
	
	var formObj = document.PatOrderByPrivReln_search;
	var validate = "";var flag;
	var bean_id = formObj.bean_id.value ;
	var tmplocale=formObj.templocale.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	validate = "activity_type";
	xmlHttp.open( "POST", "PatOrderByPrivRelnFillOrderTypeValidate.jsp?bean_id="+bean_id+"&order_category="+formObj.order_category.value+"&order_type="+formObj.order_type.value+"&localeName="+tmplocale+"&validate="+validate, false ) ;
	
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText );

}

function callActivitySearch1(target,code)
{
if(target.value!="")
	{
	callActivitySearch(target,code);
	}
	else
	parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.activity_type.value="";
}


async function callActivitySearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.localeName.value;
	dataNameArray[0] 	= "order_category" ;		 
  	dataValueArray[0] 	= parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.order_category.value;
	dataTypeArray[0] 	= STRING ;

	dataNameArray[1] 	= "order_type_code" ;		 
  	dataValueArray[1] 	= parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.order_type.value;
 	dataTypeArray[1] 	= STRING ;
	
	var sql=parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.activity_sql.value;
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

	if(retval !=null && retval != ""){
		var str =unescape(retval);
		var arr = str.split(",");
		code.value=arr[0];
		target.value=arr[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
 	}
}

async function callpractSearch1(target,code)
{
if(target.value!="")
	{
	await callpractSearch(target,code);
	}
	else
	parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.ordering_pract.value="";
}


async function callpractSearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.localeName.value;
	var sql=parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.Orderby_pract.value;
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]   =sql;
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retval= await CommonLookup(getLabel("Common.OrderingPractitioner.label","COMMON"),argumentArray);

	if(retval !=null && retval != ""){
		var str =unescape(retval);
		var arr = str.split(",");
		code.value=arr[0];
		target.value=arr[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
 	}
}

function addActivityList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.PatOrderByPrivReln_search.activity_type.add(element);
}
function FillOrderType(OrderCatObj){

	var formObj = document.PatOrderByPrivReln_search;
	var bean_id = document.PatOrderByPrivReln_search.bean_id.value ;
	var tmplocale=document.PatOrderByPrivReln_search.templocale.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
 	xmlStr ="<root><SEARCH " ;
	xmlStr += OrderCatObj.name+"=\""+ OrderCatObj.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "PatOrderByPrivRelnFillOrderTypeValidate.jsp?bean_id=" + bean_id + "&localeName="+tmplocale+"&default_val=''&validate=ord_cat", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText )
	displayElapsedFields(document.PatOrderByPrivReln_search.status);
}
function addLocationList1(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.PatOrderByPrivReln_search.order_type.add(element);
}
function clearList1( docObj ) {
var len = eval(docObj+".forms[0].order_type.options.length") ;

for(var i=0;i<len;i++){
		eval(docObj+".PatOrderByPrivReln_search.order_type.remove(\"locn\")") ;
}
var tp = getLabel("Common.all.label","Common") ;
var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
eval(docObj+".PatOrderByPrivReln_search.order_type.add(opt)") ;
}


function clickAll(){
	//if(document.formPatOrderByPrHeader.CheckPrint.checked == true){
	if(document.getElementById("CheckPrint").checked == true){
		for(cnt=0;cnt<parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.total_recs.value; cnt++){
			val = eval("parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.chk"+cnt);
			val.checked = true;
			clickLine(val);

		}
	}else{
		for(cnt=0; cnt<parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.total_recs.value; cnt++){
			val = eval("parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.chk"+cnt);
			val.checked = false;
			clickLine(val);

		}
	}
}


function clickLine(chk) {
	var chk_count=0;
	var unchk_count=0;
	var cnt=0;
	var hidden_cunt=parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.hidden_cunt.value;
		for(cnt=0;cnt<parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.total_recs.value; cnt++){
			val = eval("parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.chk"+cnt);
			if(val.checked==true)
				chk_count++;
			else
				unchk_count++;			
						
		}		
			if(chk_count==cnt-hidden_cunt)
				document.getElementById("CheckPrint").checked=true;	
			
	
	if (chk.checked == true) {
		chk.value = 'Y';
	} else {
		chk.value = 'N';
		document.getElementById("CheckPrint").checked=false;
	}
}


function printValuesTracking(){
	var no_of_checked = 0;
	var formObj = parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult;
	var eSignatureYN= formObj.eSignatureYN.value; //25671
	var labOrderSelected ="N";   //25671
	var includeESignature = false;   //25671
	if(formObj){
		for(cnt=0; cnt<formObj.total_recs.value; cnt++){
			val = eval("parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.chk"+cnt);

			if(val.checked == true){
				if("LB"==eval("parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.order_category"+cnt).value
					&&
					(
						"CD"==eval("parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.order_status_"+cnt).value
						||
						"RS"==eval("parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.order_status_"+cnt).value
						||
						"RM"==eval("parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.order_status_"+cnt).value
						||
						"MA"==eval("parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.order_status_"+cnt).value	
						||
						"RA"==eval("parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult.order_status_"+cnt).value						
					)
				
				){
					labOrderSelected="Y";
				
				}
				no_of_checked++;
			}
		}
	}		
	if(parseInt(no_of_checked) == 0){
		alert(getMessage('CLICK_ANY_ONE','OR'))
		return false
	}
	//25671 Statt.
	if("Y"==eSignatureYN && "Y"==labOrderSelected){
		includeESignature=confirm("Do you want to include E-stamp while printing LAB: Specimen Result Report");
		if(formObj.includeESignature!=undefined){
			if(includeESignature)
				formObj.includeESignature.value="Y";
			else
				formObj.includeESignature.value="N";
		}
	}
	//25671 End.
	

	//alert(formApply( parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult,OR_CONTROLLER));
		alert(getMessage('RPT_SUBMIT_TO_PRINTER','OR'))
		//eval(formApply( parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult,"../../eOR/jsp/PatOrderByPrivRelnPrintValidate.jsp")) ; //Commented for IN063736
	//onSuccessDisplay();
	//IN063736 changes starts
	var frmObj= parent.framePatOrderByPrResult.document.formPatOrderByPRSearchResult;
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;

    var xmlStr ="<root><SEARCH ";

    for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount]
        var arrObj = frmObj.elements;

        for(var i=0;i<arrObj.length;i++) {
            var val = "" ;			
            if(arrObj[i].type == "checkbox") {
                if(arrObj[i].checked)
                    val = arrObj[i].value;
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
            else if(arrObj[i].type == "radio") {
                if(arrObj[i].checked) {
                    val = arrObj[i].value;
                    if(arrObj[i].name != null && arrObj[i].name != "")
                        xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
                }
            }
            else if(arrObj[i].type == "select-multiple" ) {
                for(var j=0; j<arrObj[i].options.length; j++)
                {
                    if(arrObj[i].options[j].selected)
                        val+=arrObj[i].options[j].value +"~"
                }
                val= val.substring(0,val.lastIndexOf('~'))
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

            }
            else {
                val = arrObj[i].value;
			
                if(arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
            }
        }
    }

    xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", "../../eOR/jsp/PatOrderByPrivRelnPrintValidate.jsp", true);
    xmlHttp.send(xmlDoc);
	//IN063736 Changes Ends
}



/*function onSuccessDisplay(){
	alert(message);
}*/



/*********************************************************************************/
/***********function called on click of hyperlink of the status*******************/
/*********************************************************************************/


async function resultViewOrder(colval1,colval,orderId,order_line_num,cont_order_ind,patient_id, ord_cat){

		var dialogHeight ='50vh' ;
		var dialogWidth = '66vw' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;

		if((screen.width==800) && (screen.height==600))
		{
			
			dialogHeight   = "37.5" ;
			dialogTop	= '129';
			dialogLeft = '30' ;
			dialogWidth = '50' ;
		}
		else
		{			
			dialogHeight   = "90vh" ;
			dialogTop	= '145';
			dialogLeft = '30' ;
			dialogWidth = '60vw' ;
		}

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "fromFunction=ORDER_TRACKING"+"&colval1="+colval1+ "&colval=" +colval+"&orderId="+ orderId+"&order_line_num="+ order_line_num+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id+"&ord_cat="+ord_cat; //Added fromFunction=ORDER_TRACKING for 35142

		var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		
}
//IN068986 Start.
async function resultViewForRegisteredOrder(colval1,colval,orderId,order_line_num,cont_order_ind,patient_id, ord_cat,order_status){
	
		var dialogHeight ='27' ;
		var dialogWidth = '66' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;

		if((screen.width==800) && (screen.height==600))
		{
			
			dialogHeight   = "37.5" ;
			dialogTop	= '129';
			dialogLeft = '30' ;
			dialogWidth = '50' ;
		}
		else
		{			
			dialogHeight   = "49.5" ;
			dialogTop	= '145';
			dialogLeft = '30' ;
			dialogWidth = '66' ;
		}

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +colval+"&orderId="+ orderId+"&order_line_num="+ order_line_num+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id+"&ord_cat="+ord_cat+"&order_status="+order_status;

		var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		
}
//IN068986 End.
async function viewComments(comments){

		var dialogHeight ='22.5' ;
		var dialogWidth = '30' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "comments="+comments;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewComment.jsp?"+finalString,arguments,features);
}

async function viewClobData(row_index){
		//row_index = unescape(row_index)

		var dialogHeight ='33' ;
		var dialogWidth = '44' ;
		var dialogTop	= '150';
		var dialogLeft = '107' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "row_index="+ row_index;

		var retVals = await window.showModalDialog("../../eOR/jsp/ResultViewClobData.jsp?"+finalString,arguments,features);

}
async function viewResultComment(result_comment){
		//row_index = unescape(row_index)

		var dialogHeight ='22.5' ;
		var dialogWidth = '30' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "result_comment="+ result_comment;

		var retVals = await window.showModalDialog("../../eOR/jsp/ViewResultComment.jsp?"+finalString,arguments,features);

}

/****************************************************************************************/
/********************hyperlink functions end*******************************************/
/**************************************************************************************/

function checkDateRange(obj,from,fmt,localeName){

	var fromDate = eval("document."+from+".period_from")
	var toDate = eval("document."+from+".period_to")
	var localeName=localeName;
	
	
	 //  this method is from ValidateControl.js

		/*if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false

	}*/
	if(validDateObj(obj,"DMY",localeName)){
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
		if(fromDate.value!=""){
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.value="";
			obj.focus();
			return false;
		}}
	}else{
		document.PatOrderByPrivReln_search.period_to.value=document.PatOrderByPrivReln_search.curr_sys_date.value;
	}
}



async function checkStatus(obj) {
    if (obj.value == 'B') {
    	document.getElementById('period_td').innerHTML = "Appt. Period&nbsp;";
    } else {
    	document.getElementById('period_td').innerHTML = "Period&nbsp;";
    }
    await displayElapsedFields(obj);
}


async function viewApptData(line){
	
		var dialogHeight ='30vh' ;
		var dialogWidth = '30vw' ;
		var dialogTop	= '10';
		var dialogLeft = '10' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var arguments = "";
		 
		var appt_ref_num 			= eval("document.formPatOrderByPRSearchResult.Appt"+line+".value");
		var appt_date 				= eval("document.formPatOrderByPRSearchResult.Appt_date"+line+".value");
		var appt_locn	 			= eval("document.formPatOrderByPRSearchResult.appt_locn"+line+".value");
		var appt_resched_yn			= eval("document.formPatOrderByPRSearchResult.appt_resched_yn"+line+".value");
		var appt_resched_reason		= eval("document.formPatOrderByPRSearchResult.appt_resched_reason"+line+".value");
		var order_category			= eval("document.formPatOrderByPRSearchResult.order_category"+line+".value");
		var no_of_reschedules		= eval("document.formPatOrderByPRSearchResult.no_of_reschedules"+line+".value");
		var performing_facility_id		= eval("document.formPatOrderByPRSearchResult.performing_facility_id"+line+".value"); //IN045729
		var item_narration			= eval("document.formPatOrderByPRSearchResult.item_narration"+line+".value"); //IN059315
		var order_id				= eval("document.formPatOrderByPRSearchResult.Order_Id"+line+".value");//IN64543
		var order_line_num				= eval("document.formPatOrderByPRSearchResult.Order_line_num"+line+".value");//IN64543


 		var bean_id					= document.formPatOrderByPRSearchResult.bean_id.value;
		var bean_name				= document.formPatOrderByPRSearchResult.bean_name.value;
 		var patient_id			 	= document.formPatOrderByPRSearchResult.patientId.value;
		//Modifed by Uma on 3/17/2010 for IN020017
		var finalString				= "appt_ref_num="+ escape(appt_ref_num)+"&appt_date="+escape(appt_date)+"&appt_locn="+escape(appt_locn)+"&appt_resched_yn="+escape(appt_resched_yn)+"&appt_resched_reason="+escape(appt_resched_reason)+"&no_of_reschedules="+escape(no_of_reschedules)+"&order_category="+escape(order_category);
		//finalString					+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&patient_id="+patient_id //IN045729 to add performing_facility_id
		//finalString					+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&patient_id="+patient_id+"&performing_facility_id="+performing_facility_id //Commented for IN059315
		//finalString					+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&patient_id="+patient_id+"&performing_facility_id="+performing_facility_id+"&item_narration="+item_narration;//IN64543
		finalString					+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&patient_id="+patient_id+"&performing_facility_id="+performing_facility_id+"&item_narration="+item_narration+"&parent_order_id="+order_id+"&parent_order_line_num="+order_line_num;//IN64543
  		var retVals = await top.window.showModalDialog("../../eOR/jsp/ViewApptFrameset.jsp?"+finalString,arguments,features);

}

async function viewOAApptData(line){
	var dialogHeight ='37.5' ;
	var dialogWidth = '50' ;
	var dialogTop	= '100';
	var dialogLeft = '30' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	  
		var appt_ref_num 			= eval("document.formPatOrderByPRSearchResult.Appt"+line+".value");
		var appt_date 				= eval("document.formPatOrderByPRSearchResult.Appt_date"+line+".value");
		var performing_facility_id 				= eval("document.formPatOrderByPRSearchResult.performing_facility_id"+line+".value");
 		var bean_id					= document.formPatOrderByPRSearchResult.bean_id.value;
		var bean_name				= document.formPatOrderByPRSearchResult.bean_name.value;
 		var patient_id			 	= document.formPatOrderByPRSearchResult.patientId.value;
		if(appt_date!=null)
	    {
			var appt_date1=appt_date.split(" ");
			appt_date=appt_date1[0];
	    }
      
		var finalString				= 'i_appt_ref_no='+ escape(appt_ref_num)+'&i_appt_date='+escape(appt_date)+'&performing_facility_id='+performing_facility_id 
		finalString					+= '&bean_id='+escape(bean_id)+'&bean_name='+escape(bean_name)+'&patient_id='+patient_id+'&flag=Visit_Reg'
 		var retVals = await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?"+finalString,arguments,features);
}

function callSearch(){
 	if(window.event.keyCode==13) {    // if it is an enter key, then populate a
   	 	populateValues();   // Call the additionalSearch Function
	}
}


// Calling the Notes View
async function showNotes(accession_num) {
 	var dialogHeight ='37.5' ;
	var dialogWidth = '50' ;
	var dialogTop	= '129';
	var dialogLeft	= '11' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
 	var arguments = "";
	var retVals = await window.showModalDialog("../../eCA/jsp/PhysicianNotesDetailsFrame.jsp?accession_num="+escape(accession_num),arguments,features);
}


function chckDate(Object2,focusflag,localeName)
{
	if(Object2.value!=""){
	if(validDateObj(Object2,"DMY",localeName)==false)
	{
	document.PatOrderByPrivReln_search.period_from.value=document.PatOrderByPrivReln_search.tempdate.value;
		//document.PatOrderByPrivReln_search.curr_sys_date.value;
	/*var temp1;
	temp1=temp.split('/')
		var temp2=parseInt(temp1[0])-7;
	if(temp2.length==1)temp2="0".concat(temp2);
		var temp3=temp2.concat("/").temp1[1].concat("/").temp1[2];
*/
	//parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.period_from.value=parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.temp_curr_week_date.value;
	}
	}else{
		document.PatOrderByPrivReln_search.period_from.value=document.PatOrderByPrivReln_search.tempdate.value;
	}
}
function ondetail()
{
	if(parent.framePatOrderByPrHeaderDtl)
	{
		if(parent.framePatOrderByPrHeaderDtl.document)
		{
			if(parent.framePatOrderByPrHeaderDtl.document.forms[0])
			{
					if(parent.framePatOrderByPrHeaderDtl.document.forms[0].CheckPrint)
					{
						parent.framePatOrderByPrHeaderDtl.document.forms[0].CheckPrint.disabled=false;
					}
			}
		}
	}
	if(document.getElementById("CheckPrint"))
	{
		document.getElementById("CheckPrint").disabled=false;
	}
}
function displayElapsedFields(Obj)
	{
		var order_category="";
		if(Obj.value=="EXT_ACTIVE")
		{
			order_category=document.PatOrderByPrivReln_search.order_category.value;
			if(order_category!=""&&((order_category=="RX")||(order_category=="MI")||(order_category=="OT")||(order_category=="OH")))
			{
					
					document.getElementById('displayOrders').innerHTML=getLabel("eOR.ElapsedOrders.label","OR")+"<input type='checkbox' name='elapsed_orders' id='elapsed_orders' value='N' onclick='ChkElapseOrders()'>";
				 if(document.getElementById('displayOrders'))
					document.getElementById('displayOrders').style.visibility="visible";
				 if(document.PatOrderByPrivReln_search.elapsed_orders)
				{
					document.PatOrderByPrivReln_search.elapsed_orders.checked=false;
					document.PatOrderByPrivReln_search.elapsed_orders.disabled=true;
					document.PatOrderByPrivReln_search.elapsed_orders.value="N";
				}
			}
			else
			{
				   document.getElementById('displayOrders').innerHTML=getLabel("eOR.ElapsedOrders.label","OR")+"<input type='checkbox' name='elapsed_orders' id='elapsed_orders' value='N' onclick='ChkElapseOrders()'>";
				if(document.getElementById('displayOrders'))
				   document.getElementById('displayOrders').style.visibility = "visible";
				if(document.PatOrderByPrivReln_search.elapsed_orders)
				{
					document.PatOrderByPrivReln_search.elapsed_orders.checked=false;
					document.PatOrderByPrivReln_search.elapsed_orders.disabled=false;
					document.PatOrderByPrivReln_search.elapsed_orders.value="N";
				}
			}
		}
		else
		{
			if((Obj.value=="EXT_ALL")||(Obj.value=="EXT_DISC_CAN"))
			{
			   	   document.getElementById('displayOrders').innerHTML=getLabel("eOR.IncludeSystemCancelledOrders.label","OR")+"<input type='checkbox' name='sys_cancelled_orders' id='sys_cancelled_orders' value='' onclick='ChkSysCancelledOrders()'>";
				if(document.getElementById('displayOrders'))
				   document.getElementById('displayOrders').style.visibility="visible";
			}
			else
			{
				 if(document.getElementById('displayOrders'))
					document.getElementById('displayOrders').style.visibility="hidden";
			}
			//document.PatOrderByPrivReln_search.all.ElapsedOrders.style.visibility="hidden";
		}
	}

	function ChkElapseOrders()
	{
		if(document.PatOrderByPrivReln_search.elapsed_orders)
		{
			if(document.PatOrderByPrivReln_search.elapsed_orders.checked==true)
			{
				document.PatOrderByPrivReln_search.elapsed_orders.value="Y";
			}
			else
			{
				document.PatOrderByPrivReln_search.elapsed_orders.value="N";
			}
		}
	}
	/*Added by Arvind on 3/3/2010 for IN012637 to open medadminchart*/
	async function viewMedication(patient_id,nursing_unit,admin_date,patient_class) 
	{

		var dialogHeight	= "35vh";
		var dialogWidth		= "60vw";
		var dialogTop		= "100px";
		var dialogLeft		= "50px";
		var center			= "0";
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments		= "";
		retVal 				= await window.showModalDialog("../../ePH/jsp/QueryMednAdminChart.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_date="+admin_date+"&patient_class="+patient_class+"&called_from=OR",arguments,features);
	}
	/*Ends Here IN012637*/
	function ChkSysCancelledOrders()
	{
		if(document.getElementById("sys_cancelled_orders"))
		{
			if(document.getElementById("sys_cancelled_orders").checked==true)
			{
				document.getElementById("sys_cancelled_orders").value="Y";
			}
			else
			{
				document.getElementById("sys_cancelled_orders").value="N";
			}
		}
	}
	//IN047918 Starts
	function ChkCurrectIPList()
	{
		if(document.getElementById("current_ip_list_check"))
		{
			if(document.getElementById("current_ip_list_check").checked==true)
			{
				document.getElementById("current_ip_list_check").value="Y";
			}
			else
			{
				document.getElementById("current_ip_list_check").value="N";
			}
		}
	}
	//IN047918 Ends

