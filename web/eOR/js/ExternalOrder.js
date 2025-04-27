/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           created
04/06/2013	  IN039587		Nijitha S	 Alpha-ADHOC-OR-System displays 'null' in External orders- Amend - Preview window.
--------------------------------------------------------------------------------
Date       	Edit History   	Name        Rev.Date		Rev.Name	Description
--------------------------------------------------------------------------------
24/12/2015	IN058704		Karthi L								MMOH-SCF-0323 - IN058704
24/09/2020	IN074110		Nijitha S	24/09/2020	Remesh G	MMS-KH-CRF-0029.4/05
31/05/2023		44884		Krishna		31/05/2023		Ramesh G 	MO-CRF-20183
------------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";
var record_no = "";

/**************************************************************************/

//this is used for patient ID search
async function callPatientSearch(){
	//alert("in callPatientSearch()");
	// var pat_id=PatientSearch('','','','','','','','Y','Y','VIEW');
	//var pat_id=PatientSearch('','','','','','','','Y','Y','Visitreg');
	var pat_id = await PatientSearch('','','','','','','Y','Y','Y','Visitreg');
  	if(pat_id != null) {
		if(pat_id.charAt(0)=="Y")
			pat_id =pat_id.substring(1,pat_id.length)
			document.getElementById("patientId").value = pat_id;
	 }
		var frmObj=document.formExternalOrdersPatient;
		populatePatientAge(frmObj.patientId);
		//document.formExternalOrders.facility.focus();
/*

	 var url=PatientSearch('','','','','','','','Y','Y','VIEW');
 	  if(url!=null)	
			parent.f_query_add_mod.location.href = url;
 */
}

/************************************************************************/

function populatePatientAge(getpatientId){
	//alert("getpatientId="+getpatientId.value);

	if(getpatientId.value == "" || getpatientId.value == null){
 		document.getElementById("result_name").innerHTML="";
		document.getElementById("name_id").innerHTML="";
 		var formobj=document.formExternalOrdersPatient;
		formobj.sex.value="";
		formobj.age.value="";
		formobj.dob.value="";
		clearFrames();
			
	}else if(getpatientId.value!="" || getpatientId.value != null)
	{
		//alert("in first else if");
		var formobj=document.formExternalOrdersPatient;
		var bean_id = formobj.bean_id.value ;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr += getpatientId.name+"=\""+ getpatientId.value +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ExternalOrdersValidate.jsp?bean_id="+bean_id+"&default_val=&validate=pat_det", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			//alert(responseText);
			eval(responseText);
	}
}

function addpatient(patientname,locale,dob){ // added for 'dob' MMOH-SCF-0323 - IN058704
	var patientarray=patientname.split("<b>");
	var parlength=	patientarray.length;
	var par1array;
	var parpatient;
	par1array=patientarray[1].split("</b>");
	var convert;
if(locale!='en')
{
	if(par1array[0].indexOf("-")!=-1)
	{
		parpatient=par1array[0].split("-");
		convert=parpatient[1].substring(2,parpatient[1].length);
		var toalert	=convertDate(convert,'DMYHMS',"en",locale);
		par1array[0]=parpatient[0].concat("-").concat(parpatient[1].substring(0,2)).concat(toalert);
	}
}
	var sex=patientarray[2].split("/");
	var sexVal = sex[0];//IN039587
	if(sex[0]=='F')
	{
		sex[0]=getLabel("Common.female.label","Common") ;
	}
	else if(sex[0]=='M')
	{
		sex[0]=getLabel("Common.male.label","Common") ;
	}
	if(trimString(par1array[1])=='Sex/Age :')
	{
		 var patientname1=patientarray[0].concat("<b>").concat(par1array[0]).concat("      ").concat("</b>").concat(getLabel("eOR.SexAge.label","OR")).concat("<b>").concat(sex[0]).concat("/").concat(sex[1]).concat(patientarray[3]).concat("</b>");
 	}
	document.getElementById("name_id").innerHTML=getLabel("Common.PatientName.label","Common");
	document.getElementById("result_name").innerHTML="&nbsp;&nbsp;"+patientname1;
	document.formExternalOrdersPatient.patient_details.value=patientname;
	var queryString=document.formExternalOrdersPatient.qryString.value;
	if(queryString.indexOf("&patientId=")!=-1)
	{
		queryString=queryString.substring(0,(queryString.indexOf("&patientId=")));
	}
	qry_string	=queryString+"&patientId="+document.formExternalOrdersPatient.patientId.value+"&patient_details="+patientname1;
	// Populate the Frames.
	parent.externalOrdersHeader.location.href = "../../eOR/jsp/ExternalOrdersHeader.jsp?"+qry_string;
	//parent.externalOrdersResult.location.href = "../../eOR/jsp/ExternalOrdersMain.jsp?"+qry_string;//IN039587
	parent.externalOrdersResult.location.href = "../../eOR/jsp/ExternalOrdersMain.jsp?"+qry_string+"&Sex="+sexVal+"&Age="+sex[1]+"&Dob="+dob;//IN039587  //added for 'Dob' MMOH-SCF-0323 - IN058704
}


function addsex(sex){
  	
/*if(sex=='F')
{		
		sex=getLabel("Common.female.label","Common") ;
	}else if(sex=='M')
	{
		sex=getLabel("Common.male.label","Common") ;
	}*/
	//alert("chking"+sex);
	document.formExternalOrdersPatient.sex.value=sex;
}

function addage(age){

	//alert("here"+age);
  	document.formExternalOrdersPatient.age.value=age;
}

function adddob(dob){
  	document.formExternalOrdersPatient.dob.value=dob;
}


function clearFrames(){
	parent.externalOrdersHeader.location.href = "../../eCommon/html/blank.html";
	parent.externalOrdersResult.location.href = "../../eCommon/html/blank.html";
}

/***************************************************************************/

//called to populate referral facility
function populateList()
{
	var formobj=document.formExternalOrders;
	var bean_id = formobj.bean_id.value ;
	var templocale=formobj.tmplocale.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlHttp.open( "POST", "ExternalOrdersValidate1.jsp?bean_id="+bean_id+"&localeName="+templocale+"&default_val=&validate=pat_det", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}


//called to populate referral facility
function addfacility(code,desc, source_lb_ord_yn, source_rd_ord_yn,applicability_for_direct_ord){
	code = code+"::"+source_lb_ord_yn+"::"+source_rd_ord_yn+"::"+applicability_for_direct_ord
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = desc ;
	document.formExternalOrders.facility_code.add(element);
}

/*****************************************************************************/

//for common look up for referral practioner
function practitioner_display(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;


	argumentArray[0]   = formExternalOrders.practitioner_code_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = CommonLookup(getLabel("Common.practitioner.label","Common"),argumentArray );

	if(retVal != null && retVal != ""){

		document.formExternalOrders.practitionerId.value=retVal[0];
		target.value = retVal[1];
		document.formExternalOrders.Referral_date.focus();
	}else{
				target.value="";
				document.formExternalOrders.practitioner.focus();
			}
	}




/*******************************************************************************/

//to check for invalid patient id, called frm externalOrdersvalidate.jsp

function InvalidPatient(){
	
	var formobj=document.formExternalOrdersPatient;
	formobj.patientId.value="";
	document.getElementById("name_id").innerHTML="";
	document.getElementById("result_name").innerHTML="";
//	formobj.practitionerId.value="";
//	formobj.Referral_date.value="";
//	formobj.remarks.value="";
	alert(getMessage('INVALID_PATIENT','OR'));
			formobj.patientId.focus();
}

/******************************************************************************/
/*
function onblur_pract_disp(target){
	if(target.value == ""|| target.value == null){
		//do nothing
	}else{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;


	argumentArray[0]   = formExternalOrders.practitioner_code_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup( "Practitioner", argumentArray );

	if(retVal != null && retVal != ""){

		document.formExternalOrders.practitionerId.value=retVal[0];
		target.value = retVal[1];
		document.formExternalOrders.Referral_date.focus();
	}else{
				target.value="";
				document.formExternalOrders.practitioner.focus();
			}
	}
}
*/
/*****************************************************************************/
//to check for date validation

function chkdate(target){
	if(target.value=="" || target.value==null){
		//do nothing
	}else{
		doDateTimeChk(target);
	}
}

/****************************************************************************/
//called when submiting the form-on click of place orders

function PlaceOrder(){

	var frmObj					= document.formExternalOrders;
	//var Patientid				= frmObj.patientId.value;Commented by Uma on 3/13/2010 for IN019490
	var Referral_facility		= frmObj.facility.value;
	var Referral_pract			= frmObj.practitionerId.value;
	var Referral_dt_time		= frmObj.Referral_date.value;
	var Remarks					= frmObj.remarks.value;
	var function_from			= frmObj.function_from.value;
	var bean_id					= frmObj.bean_id.value;
	var bean_name				= frmObj.bean_name.value;
	var order_category			= frmObj.order_category.value;
	var order_type				= frmObj.order_type.value;
	var ordercode				= frmObj.ordercode.value;
	var patient_details			= frmObj.patient_details.value;
	var source_use_at_lb_ord_yn = trimString(frmObj.source_use_at_lb_ord_yn.value);
	var applicability_for_direct_ord = trimString(frmObj.applicability_for_direct_ord.value);
	var source_use_at_rd_ord_yn = trimString(frmObj.source_use_at_rd_ord_yn.value);
	/*Added by Uma on 3/13/2010 for IN019490*/
	var Patientid				= parent.externalOrders.document.formExternalOrdersPatient.patientId.value;
	frmObj.patientId.value		= Patientid;
	/*Ends Here IN019490*/
	
 
	var fields=new Array(Patientid,Referral_facility,Referral_pract,Referral_dt_time,Remarks,order_category);
	var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("Common.ReferralFacility.label","COMMON"), getLabel("eOR.ReferralPractitioner.label","OR"), getLabel("eOR.ReferralDateTime.label","OR"),getLabel("Common.remarks.label","Common"),getLabel("Common.OrderCategory.label","Common"));
	if(mandatory( fields, names)==false){
		return true;
	}
	else{
  		if(ordercode!="")
		{
			/*if( order_type=="")
			{
			 
					alert(getMessage("EXT_ORD_TYPE_BLANK","OR"));
			}
			else
			{Commented by Uma on 6/3/2009 for IN011098*/
			if(order_category!=null &&   (order_category=="LB" && (source_use_at_lb_ord_yn!="Y" || applicability_for_direct_ord=="E")))
			{
					alert(getMessage("LB_ORDER_NOT_ALLOWED_SOURCE","OR"));
					return;
			}
			if(order_category!=null &&  (order_category=="RD" && source_use_at_rd_ord_yn!="Y") )
			{
					alert(getMessage("RD_ORDER_NOT_ALLOWED_SOURCE","OR"));
					return;
			 
			}
			parent.externalOrdersResult.document.formExternalOrders.target=top.content.workAreaFrame.name;
			parent.externalOrdersResult.document.formExternalOrders.submit();
			//}

		}
		else 
		{
			if(order_category!=null &&   (order_category=="LB" && (source_use_at_lb_ord_yn!="Y" || applicability_for_direct_ord=="E")))
			{
					alert(getMessage("LB_ORDER_NOT_ALLOWED_SOURCE","OR"));
					return;
			}
			if(order_category!=null &&  (order_category=="RD" && source_use_at_rd_ord_yn!="Y") )
			{
					alert(getMessage("RD_ORDER_NOT_ALLOWED_SOURCE","OR"));
					return;
			 
			}
			else
			{
				parent.externalOrdersResult.document.formExternalOrders.target=top.content.workAreaFrame.name;
				parent.externalOrdersResult.document.formExternalOrders.submit();
			}
		}
	}
}

function mandatory( fields, names) 	{
		var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
		if (fields[i]==""||fields[i]==null){
			//errors = errors + "APP-000001 " + names[i] + " cannot be blank...                                                           "
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n";
			 }
	}
    if ( errors.length != 0 ) {
		alert(errors);
        return false ;
    }
    return true ;
}

/***************************************************************************/

//to clear the page
function Clear(){
	clearFrames();
	/*var frmObj			= document.formExternalOrders;
	frmObj.patientId.value="";
	document.getElementById("name_id").innerHTML="";
	document.getElementById("result_name").innerHTML="";
    frmObj.patient_details.value="";
	
	frmObj.facility.value="";
	frmObj.practitionerId.value="";
	var currDate = new Date();
	var date = currDate.getDate();
	var mon = currDate.getMonth();
	mon = mon+1;
	var year = currDate.getYear();
	var hour = currDate.getHours();
	if(hour >= 12)
		hour = hour - 12;
	var min = currDate.getMinutes();
	if(date <10)
		date = "0"+date;
	if(mon <10)
		mon = "0"+mon;
	if(hour <10)
		hour = "0"+hour;
	if(min < 10)
		min = "0"+min;
	frmObj.Referral_date.value= date + "/" + mon + "/" + year + " " + hour + ":" + min;
	frmObj.remarks.value="";
	frmObj.order_category.selectedIndex = 0;
	frmObj.order_type.selectedIndex = 0;*/
}

/*****************************************************************************/

async function PatientPendingOrders(){

		var frmObj					= document.formExternalOrders;
		var Patientid				= frmObj.patientId.value;
		var fields=new Array(Patientid);
		var names = new Array (getLabel("Common.patientId.label","Common"));
		if(mandatory( fields, names)==false)
		{
			return true;
		}
		else
		{
			var dialogHeight ='22' ;
			var dialogWidth = '45' ;
			var dialogTop	= '129';
			var dialogLeft = '11' ;

			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

			var arguments = "";
			var frmObj					= document.formExternalOrders;
			var Patient_id				= frmObj.patientId.value;
	
			var retVals = await window.showModalDialog("../../eOR/jsp/PatientPendingOrders.jsp?Patient_id="+Patient_id,arguments,features);
		}
}

function RenewOrders() {
    var bean_id = parent.framePatientPendingOrdersResult.document.formPatientPendingOrders.bean_id.value ;
    var order_id = parent.framePatientPendingOrdersResult.document.formPatientPendingOrders.order_id;
    var order_type_code = parent.framePatientPendingOrdersResult.document.formPatientPendingOrders.ord_typ_code;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += order_id.name+"=\""+ order_id.value +"\" " ;
	xmlStr += order_type_code.name+"=\""+ order_type_code.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ExistingOrderRenewValidate.jsp?bean_id=" + bean_id + "&validate=order_id", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
}

async function resultViewOrder(colval1,colval,orderId,order_line_num,cont_order_ind,patient_id, ord_cat){

		var dialogHeight ='37.5' ;
		var dialogWidth = '50' ;
		var dialogTop	= '100';
		var dialogLeft = '100' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +colval+"&orderId="+ orderId+"&order_line_num="+ order_line_num+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id+"&ord_cat="+ord_cat;
		//alert(finalString)
		var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}								

function clearOrderable(){
	document.formExternalOrders.orderable.value="";
	document.formExternalOrders.ordercode.value="";
}

function populateOrderTypes(target)
{
	removeListItems(document.formExternalOrders.order_type);
	removeActivityListItems(document.formExternalOrders.activity_type);
	document.formExternalOrders.orderable.value="";
	document.formExternalOrders.ordercode.value="";
	var bean_id = document.formExternalOrders.bean_id.value ;
	//alert(bean_id);
	var bean_name = document.formExternalOrders.bean_name.value ;
	//alert(bean_name);
	var ord_cat = target.value;
	var order_type = document.formExternalOrders.order_type.value ;
	//alert(ord_cat);
	var templocale=document.formExternalOrders.tmplocale.value;
	//alert("injs"+templocale);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
 	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ExternalOrdersOrderTypes.jsp?bean_id=" + bean_id +"&localeName="+templocale+ "&bean_name=" + bean_name + "&ord_cat="+ ord_cat+"&order_type="+order_type, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText ) ;
}


function populateActivityType(target)
{
 	removeActivityListItems(document.formExternalOrders.activity_type);
 	var bean_id = document.formExternalOrders.bean_id.value ;
 	var bean_name = document.formExternalOrders.bean_name.value ;
 	var order_type = target.value;
	var ord_cat = document.formExternalOrders.order_category.value ;
	var templocale=document.formExternalOrders.tmplocale.value;
 	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ExternalOrdersOrderTypes.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&ord_cat="+ ord_cat+"&order_type="+order_type+"&localeName="+templocale+"&func_mode=activity_type", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
 	eval(responseText ) ;
}


function addOrderType(desc, code)
{
		var oOption = document.createElement("OPTION");
		oOption.text = desc;
		oOption.value = code;
		document.formExternalOrders.order_type.add(oOption);
}

function addActivityType(desc, code)
{
		var oOption = document.createElement("OPTION");
		oOption.text = desc;
		oOption.value = code;
		document.formExternalOrders.activity_type.add(oOption);
}

function removeListItems(target)
{
	var length = target.length;
	while(length !=0)
	{
		for(var i=0;i<length;i++)
		{
			target.remove(i);
		}
	   length = target.length;
   }
	
		var oOption = document.createElement("OPTION");
		oOption.text = "        ------"+getLabel("Common.defaultSelect.label","Common")+" ------        ";
		oOption.value = "";
		oOption.selected = "selected";
		document.formExternalOrders.order_type.add(oOption);

	return true;
}

function removeActivityListItems(target)
{
	var length = target.length;
	while(length !=0)
	{
		for(var i=0;i<length;i++)
		{
			target.remove(i);
		}
	   length = target.length;
   }
	
		var oOption = document.createElement("OPTION");
		oOption.text = "        ------"+getLabel("Common.defaultSelect.label","Common")+" ------        ";
		oOption.value = "";
		oOption.selected = "selected";
		document.formExternalOrders.activity_type.add(oOption);

	return true;
}
async function callOrderablesearch(target)
{
	if(target.value!="")
	{
		await callOrderable(target);
	}
}

async function callOrderable(target)
{
	var searchText = target.value;
	var dialogHeight= "67vh" ;//30
	var dialogWidth	= "42vw" ;//40
	var dialogTop = "10" ;//100
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var order_category	= document.formExternalOrders.order_category.value;
    var order_type		= document.formExternalOrders.order_type.value;
	var activity_type	= document.formExternalOrders.activity_type.value;
	//Added by Uma on 3/12/2010 for IN019490
	var practitionerId	= document.formExternalOrders.practitionerId.value;
	//Modified by Uma on 3/12/2010 for IN019490
	var retVal =await top.window.showModalDialog("../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?CallingModule=OR"+"&searchText="+encodeURIComponent(searchText)+"&called_from=generic_atc&mode="+MODE_INSERT+"&order_category="+order_category+"&order_type="+order_type+"&activity_type="+activity_type+"&practitionerId="+practitionerId,arguments,features);

	if(retVal != undefined)
	{
		document.formExternalOrders.ordercode.value	=retVal[0];
		document.formExternalOrders.orderable.value = retVal[1];
		var order_type_code=retVal[2];
		var order_type_desc=retVal[3];
		var activity_code=retVal[4];		
		var activity_desc=retVal[5];		
		if(document.formExternalOrders.order_type_desc)
		{	
			if(order_type_desc=="All")
			{	
				document.formExternalOrders.order_type.value="";
				document.formExternalOrders.order_type_desc.value="";
			}
			else
			{
				document.formExternalOrders.order_type.value=order_type_code;
				document.formExternalOrders.order_type_desc.value=order_type_desc;
			}
		}
		if(document.formExternalOrders.activity_type_desc)
		{		
			if(activity_desc=="All")
			{
			document.formExternalOrders.activity_type.value="";
			document.formExternalOrders.activity_type_desc.value=""
			}
			else
			{
			document.formExternalOrders.activity_type.value=activity_code;
			document.formExternalOrders.activity_type_desc.value=activity_desc;
			}
		}		

	}
	else
	{
		document.formExternalOrders.orderable.value = "";
		document.formExternalOrders.ordercode.value = "";
	}
}


function populatePractitioner(obj)
{
	if(obj.value!="") 
	{
		var formobj = document.formExternalOrders;
		/*var val = obj.value.split("::");
		facility = val[0];
	 
		document.formExternalOrders.facility.value= facility
		document.formExternalOrders.source_use_at_lb_ord_yn.value=  val[1];
		document.formExternalOrders.source_use_at_rd_ord_yn.value=  val[2];
		document.formExternalOrders.applicability_for_direct_ord.value=  val[3];*/
		var bean_id    = formobj.bean_id.value ;
		var templocale = formobj.tmplocale.value;
 
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
 
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ExternalOrdersPractitioner.jsp?bean_id=" + bean_id +"&localeName="+templocale+ "&validate=practitioner&ref_facility_id="+formobj.facility_code.value,false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText ) ;
 
	}  else {
		clearList();
		document.formExternalOrders.facility.value= "";
		document.formExternalOrders.practitionerName.value= "";
		document.formExternalOrders.source_use_at_lb_ord_yn.value= "";
		document.formExternalOrders.source_use_at_rd_ord_yn.value= "";
		document.formExternalOrders.applicability_for_direct_ord.value= "";
		 
	}
}
 function Clear1(obj)
 {
	 if(obj.value!="")
	document.formExternalOrders.practitionerName.value="";

 }
function clearList(){
	target = document.formExternalOrders.practitionerId
	var length = target.length;
	while(length !=0)
	{
		for(var i=0;i<length;i++)
		{
			target.remove(i);
		}
	   length = target.length;
   }
	
		var oOption = document.createElement("OPTION");
		oOption.text = "        ------"+getLabel("Common.defaultSelect.label","Common")+" ------        ";
		oOption.value = "";
		oOption.selected = "selected";
		document.formExternalOrders.practitionerId.add(oOption);
 
}

function addPractitionerList(code, value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.formExternalOrders.practitionerId.add(element);
}

function getPractitionerName(obj){
	 
	if(obj.value!="") {
		var selectObj = document.getElementsByTagName("SELECT").practitionerId;
		var selOptionValue = selectObj.options[document.formExternalOrders.practitionerId.selectedIndex].text;
		document.formExternalOrders.practitionerName.value= selOptionValue;
	} else { 
		document.formExternalOrders.practitionerName.value="";
	}
}	


function callExternal(obj){

 


		var formobj			= parent.externalOrders.document.formExternalOrdersPatient
			sex				= formobj.sex.value;
			date_of_birth	= formobj.dob.value;
			age				= formobj.age.value;
			patient_id		= formobj.patientId.value;
 	if(obj=="ExistingOrder") {
 		//var url="../../eOR/jsp/ExistingOrder.jsp?patient_id="+patient_id+"&episode_id=&Sex="+sex+"Age="+age+"&Dob="+date_of_birth+"&p_called_from_ca=PASSED_ORDERS";//IN039587
		var url="../../eOR/jsp/ExistingOrder.jsp?patient_id="+patient_id+"&episode_id=&Sex="+sex+"&Age="+age+"&Dob="+date_of_birth+"&p_called_from_ca=PASSED_ORDERS&existing_order_called_from=EXTERNAL_ORDER";//IN039587// existing_order_called_from for Added IN074110
	}
	else {
		//var url='../../eOR/jsp/ExternalOrdersMain.jsp?patient_id='+patient_id//IN039587
		//var url='../../eOR/jsp/ExternalOrdersMain.jsp?patient_id='+patient_id+"&Sex="+sex+"&Age="+age;//IN039587 //commented for MMOH-SCF-0323 - IN058704/22/03/2016
		var url='../../eOR/jsp/ExternalOrdersMain.jsp?patient_id='+patient_id+"&Sex="+sex+"&Age="+age+"&Dob="+date_of_birth;//modified for MMOH-SCF-0323 - IN058704/22/03/2016
	}
	//alert("here 681 url"+url);
 	parent.externalOrdersResult.location.href = url;
	//top.content.workAreaFrame.location.href = url;

}


function changeColor(obj){
 	cellref		= document.getElementById("tab").rows[0].cells
   for(i=0; i<cellref.length; i++)
	{
		if(i!=2)
	  		cellref[i].className = "CAFIRSTSELECTHORZ"
	}
 	obj.className 	= "CASECONDSELECTHORZ"
}

function validtime(obj,currdate)
{
var strHr;
	var strMi;
	

	var timefield = obj.value;
	var timefield1=timefield.substring(11);
	var strTimeArray = new Array();
		
    if(timefield1.indexOf(":")!=-1){
	strTimeArray = timefield1.split(":");
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];

	
    
		if(strHr>=24|| strMi>=60)
	{
       // alert(getMessage("ALT_TIMING_INVALID","PH"));
	   alert(getMessage("INVALID_TIME_FMT","OR"));
	        clearData1(obj);
			obj.value=currdate;

		 		return false;

	}    else {return true; }
	}
}

function clearData1(obj) {
	obj = eval(obj);
	//alert(obj.value);
	var len = obj.length;
 		obj.value="";
		obj.focus();
		 
}
function CheckForNumsAndColon(event){
   var key = window.event.keyCode;
   if( !(( ( key>=47 ) && ( key<=58 ) )||(key==32)) ) {
       return false;
  }
	
}

function CheckDateTime(objText,currdate)
{
	if(objText.value !='')
	{
		if(!doDateTimeChk(objText))
		{
			alert(getMessage("INVALID_DATE_TIME_FORMAT","OR"))
			objText.value=currdate;
			objText.select();
			return false
		}
		else
		{
			var dateArray=objText.value.split(" ");
			var timeArray=dateArray[0].split("/");
			if(timeArray[1]==0)
			{
				alert(getMessage("INVALID_DATE_TIME_FORMAT","OR"))
				objText.value=currdate;
				objText.select();
				return false
			}
		}
	}
}
function  appedzero(obj){
	
	 if(obj.value != null && obj.value != ""){
		var from_val	=	obj.value;
		var from_val1	=	obj.value;
		var frm_hrs		=	new Array();
		from_val=from_val.substring(11);
		if(from_val.indexOf(":") != -1){
			frm_hrs=from_val.split(":");
			var strHr;
			var strMi;
			strHr = frm_hrs[0];
			strMi = frm_hrs[1];
			if(strHr.length==1) { strHr	= "0"+ strHr; }else if(strHr.length==0){strHr = "00"; }
			if(strMi.length==1) { strMi	= "0"+ strMi; }else if(strMi.length==0){strMi = "00"; }
			obj.value=from_val1.substring(0,11)+strHr+":"+strMi;
			
		}else{
			if(from_val.length == 1){
				obj.value= from_val1.substring(0,11)+"0"+from_val+":"+"00";
			}else if (from_val.length == 2){
				obj.value= from_val1.substring(0,11)+from_val+":"+"00";
			}
		}
	}
	
}
function chckDate(Object2,focusflag,localeName)
{
if(validDateObj(Object2,"DMYHM",localeName)==false)
	{
	Object2.value=document.formExternalOrders.tempdate.value;
		
	}
}

async function populateordertypeSearch(target,code)
{

	var formobj=document.formExternalOrders;

	if(trimString(target.value).length>0)
	{
		await callordertypeSearch(target,code);
	}
	else
	{
		if(target.value=="")
		{
			code.value="";
			formobj.activity_type.value="";
			formobj.activity_type_desc.value="";
			formobj.orderable.value="";
			formobj.ordercode.value="";
		}
		
	}
}

async function callordertypeSearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	
	var formobj=document.formExternalOrders;
	
	dataNameArray[0] 	= "order_category" ;	
	dataValueArray[0] 	= formobj.order_category.value;
 	dataTypeArray[0] 	= STRING ;
	
	var localeName= formobj.tmplocale.value;
	var sql=formobj.order_type_sql.value;
	
	
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="2,3";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=await CommonLookup(getLabel("Common.OrderType.label","Common"),argumentArray);
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retval !=null && retval != "")
	{
		code.value=arr[0];
		target.value=arr[1];
	}else{
   		target.value = "";
   		code.value = "" ;
	 }
		formobj.activity_type.value="";
		formobj.activity_type_desc.value="";
		formobj.orderable.value="";
		formobj.ordercode.value="";
}

async function populateActivitySearch(target,code)
{
	var formobj=document.formExternalOrders;
	if(trimString(target.value).length>0)
	{
		await callActivitySearch(target,code);
	}
	if(target.value=="")
	{
		code.value="";
		//formobj.orderable.value="";
		//formobj.ordercode.value="";
	}
}

async function callActivitySearch(target,code)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	
	var formobj=document.formExternalOrders;

	localeName=formobj.tmplocale.value;
	dataNameArray[0] 	= "order_category" ;		 
  	dataValueArray[0] 	= formobj.order_category.value;
 	dataTypeArray[0] 	= STRING ;
	dataNameArray[1] 	= "order_type_code" ;		 
  	dataValueArray[1] 	= formobj.order_type.value;
 	dataTypeArray[1] 	= STRING ;
	
	var sql=formobj.activity_sql.value;
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=await CommonLookup(getLabel("eOR.ActivityType.label","OR"),argumentArray);
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

	if(retval !=null && retval != "")
	{
		code.value=arr[0];
		target.value=arr[1];
		formobj.orderable.value="";
		formobj.ordercode.value="";
		
	}else
	{
   		target.value = "";
   		code.value = "" ;
		//formobj.orderable.value="";
		//formobj.ordercode.value="";
	 }
}

function clearFields()
{
	//44884 Starts.
	var practitionerRel="N";
	var restOrdersSelf="N";
	var restOrdersFamily="N";
	
	practitionerRel = document.formExternalOrders.practitionerRel.value;
	var orderCategory=document.formExternalOrders.order_category.value;
	restOrdersSelf=eval("document.formExternalOrders.restBfrPlaceOrderS"+orderCategory).value;
	restOrdersFamily=eval("document.formExternalOrders.restBfrPlaceOrderF"+orderCategory).value;
	
	if("N"!=practitionerRel){
		if("S"==practitionerRel && "Y"==restOrdersSelf ){
			if("PH"==orderCategory)
				alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
			else
				alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
			document.formExternalOrders.order_category.value="";
		return false;
		}
		if("F"==practitionerRel && "Y"==restOrdersFamily ){
			if("PH"==orderCategory)
				alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
			else
				alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
			document.formExternalOrders.order_category.value="";
			return false;
		}
	}
	//44884 Ends.
	var formobj=document.formExternalOrders;
	formobj.order_type.value="";
	formobj.order_type_desc.value="";
	formobj.activity_type.value="";
	formobj.activity_type_desc.value="";
	formobj.orderable.value="";
	formobj.ordercode.value="";
}

function clearMsgFrame()
{
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
}

async function populateFacilityDesc(obj)
{
	if(obj.value!="")
	{
		await populateFacility(obj);
	}
}

async function populateFacility(obj)  //Called on click of the speciality
{
	var formobj = document.formExternalOrders;
	localeName=formobj.tmplocale.value;
	var dataNameArray  		= new Array() ;
	var dataValueArray 		= new Array() ;
	var dataTypeArray 		= new Array() ;
	var sql_query			= formobj.ref_facility_sql.value;
	sql_query               = sql_query.replace('?',"'"+localeName+"'");

	var argumentArray  		= new Array() ;
		argumentArray[0]	= sql_query;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
		argumentArray[3]	= dataTypeArray ;
		argumentArray[4]	= "2,3";
		argumentArray[5]	= formobj.facility_desc.value ;//Target
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup(getLabel("Common.ReferralFacility.label","Common"),argumentArray);
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal!=null && retVal!='')
	{
		formobj.facility_desc.value 		= arr[1] ;
		formobj.facility_code.value			= arr[0];
		formobj.facility.value				= arr[0];

		if((formobj.facility_code.value!=null) && (formobj.facility_code.value!=''))
		{
			var formobj=document.formExternalOrders;
			var bean_id = formobj.bean_id.value ;
			var bean_id = formobj.bean_id.value ;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;

			xmlHttp.open( "POST", "ExternalOrdersValidate1.jsp?bean_id="+bean_id+"&validate=referral_det&ref_facility_code="+formobj.facility_code.value, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);

			populatePractitioner(formobj.facility_code);
			Clear1(formobj.facility_code);
		}
	}
	else
	{
		formobj.facility_desc.value 		= "";
		formobj.facility_code.value 		= "";
		clearList();
		document.formExternalOrders.facility.value= "";
		document.formExternalOrders.practitionerName.value= "";
	}	
	
}

function addReferralDtls(source_use_at_lb_ord_yn,source_use_at_rd_ord_yn,applicability_for_direct_ord)
{ 
	document.formExternalOrders.source_use_at_lb_ord_yn.value      =  source_use_at_lb_ord_yn;
	document.formExternalOrders.source_use_at_rd_ord_yn.value      =  source_use_at_rd_ord_yn;
	document.formExternalOrders.applicability_for_direct_ord.value = applicability_for_direct_ord;
}
