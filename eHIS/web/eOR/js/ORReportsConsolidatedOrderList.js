/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";

function run(){
	f_query_add_mod.RepConsolidatedOrderList.submit();
   alert('sdf');
}

function repSelect(obj) {
	if(obj.value != '') {
		//alert('herein');
		parent.f_query_add_mod.location.href = "../../eOR/jsp/ORReportsConsolidatedOrderListQuery.jsp?rep="+obj.value;
	} else {
		parent.f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	}
}

//this is used for patient ID search
function callPatientSearch(){
	var pat_id =  PatientSearch();

	if(pat_id != null)
	document.getElementById("p_patient_id").value = pat_id;
}

async function searchCode(obj,target1,target2)
{
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";
	var facility_id = document.getElementById("p_facility_id").value;

	//alert(obj.name)
	//if(obj.name=="visitTypeCode")
	{
		tit="Location";
		if (document.getElementById("p_location_type").value != 'N')
			sql="select clinic_code location_code,short_desc from op_clinic where facility_id=`"+facility_id+"`";
       	if (document.getElementById("p_location_type").value == '')
		   	sql+="union ";
		if (document.getElementById("p_location_type").value != 'C')
			sql+="select nursing_unit_code location_code, short_desc from Ip_nursing_unit where facility_id=`"+facility_id+"`";
		//alert('sql='+sql);
        search_code="1";
		search_desc= "short_desc";
		//sql="select visit_type_code, short_desc from op_visit_type where facility_id=`"+facilityid+"`";
		sc = "facility_id="+facility_id;
	}

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst", arguments, features);
	//retVal = window.showModalDialog("../../eCommon/jsp/CommonLookup.jsp?sqlData="+sql+"&title="+tit, arguments, features);
	//alert('retVal='+unescape(retVal));
	if (!(retVal == null))
	{
		retVal = unescape(retVal);
		var retArray = new Array();
		retArray = retVal.split("::");
		target1.value=retArray[0];
		target2.value=retArray[1];
	}
	else
		target1.focus();
}

function clearLocations() {
	document.getElementById("from_location").value = '';
	document.getElementById("p_from_location").value = '';
	document.getElementById("to_location").value = '';
	document.getElementById("p_to_location").value = '';
}

function populateOrderTypes(ord_cat){

	var bean_id = document.RepConsolidatedOrderList.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	//alert(ord_cat.value);
	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_cat.name+"=\""+ ord_cat.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var category = "";
	if (ord_cat.name == "p_from_category") category = "from";
	else if (ord_cat.name == "p_to_category") category = "to";
	xmlHttp.open( "POST", "ORReportsConsolidatedOrderListValidate.jsp?bean_id=" + bean_id + "&validate=ord_cat&category="+category, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText ) ;
}

function addOrderType1List(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.RepConsolidatedOrderList.p_from_order_type.add(element);
}

function clearL1List( docObj ) {
	var len = eval(docObj+".RepConsolidatedOrderList.p_from_order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".RepConsolidatedOrderList.p_from_order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     ---"+getLabel("Common.all.label","Common")+"---     " ;
	opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval(docObj+".RepConsolidatedOrderList.p_from_order_type.add(opt)") ;
}

function addOrderType2List(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.RepConsolidatedOrderList.p_to_order_type.add(element);
}

function clearL2List( docObj ) {
	var len = eval(docObj+".RepConsolidatedOrderList.p_to_order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".RepConsolidatedOrderList.p_to_order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     ---"+getLabel("Common.all.label","Common")+"---     ";
	opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval(docObj+".RepConsolidatedOrderList.p_to_order_type.add(opt)") ;
}

function setDateType(obj) {
	if (obj.value == 'D') {
		document.getElementById("from_period").innerHTML = "&nbsp;<Input type='text' Name='p_from_period_range'  maxlength='10' size='10' onBlur='CheckDate(this)' onKeyPress='return OrAllowDateFormat()'>";
		document.getElementById("to_period").innerHTML = "&nbsp;<Input type='text' Name='p_to_period_range'  maxlength='10' size='10' onBlur='CheckDate(this)' onKeyPress='return OrAllowDateFormat()'>";
	} else if (obj.value == 'M') {
		document.getElementById("from_period").innerHTML = "&nbsp;<Input type='text' Name='p_from_period_range'  maxlength='7' size='10' onBlur='CheckMonth(this)' onKeyPress='return OrAllowDateFormat()'>";
		document.getElementById("to_period").innerHTML = "&nbsp;<Input type='text' Name='p_to_period_range'  maxlength='7' size='10' onBlur='CheckMonth(this)' onKeyPress='return OrAllowDateFormat()'>";
	} else if (obj.value == 'Y') {
		document.getElementById("from_period").innerHTML = "&nbsp;<Input type='text' Name='p_from_period_range'  maxlength='4' size='10' onBlur='CheckYear(this)' onKeyPress='return OrAllowDateFormat()'>";
		document.getElementById("to_period").innerHTML = "&nbsp;<Input type='text' Name='p_to_period_range'  maxlength='4' size='10' onBlur='CheckYear(this)' onKeyPress='return OrAllowDateFormat()'>";
	}
}

function reset() {
	f_query_add_mod.location.href = '../../eOR/jsp/ORReportsConsolidatedOrderListQuery.jsp';
	messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
}

function query() {
}
