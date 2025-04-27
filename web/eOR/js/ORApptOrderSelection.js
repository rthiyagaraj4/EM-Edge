/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
24/08/2013    IN030284		Chowminya G 	Created:To capture Pre-consultation orders in Appointment Scheduling
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
var message = "" ;
var getorderdate="";
var getenid="";
var getadmindate1="";
var a1;
var get_curr_sys_date;
var function_id="";
var flag="";
var getlineno="";
var store_ordid_linenum=new Array();
var count=0;
var getresult;
var store_ordid_check=new Array();
var store_ordid_name=new Array();
var store_ord_line_num="";
var store_ordid_name1=new Array();
var store_ordid_check1=new Array();
var ordid;
var mycounter=0;
var checkpatientId;
var resultGlobal;
var textSelected = "false";
var resultScrnDisplay = false;
var chkConsent = "";
var flgEncounter = "";
var open_preview=true;

function clearSearchValues(){

	document.refusalsearch_form.reset();
	parent.refusal_main_label.location.href = "../../eCommon/html/blank.html";
    parent.refusal_main_result.location.href =  "../../eCommon/html/blank.html";

}

function populateOrderCodes(ordercategory)
{
		var frmObj		= document.OrderableSearch;
		var tmplocale   = frmObj.templocale.value;
		if( ordercategory.value == "" ) {
				clearList("document");
				clearActivityList("document");
			}
		var bean_id = frmObj.bean_id.value ;
		order_type	= frmObj.typecode.value ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += ordercategory.name+"=\""+ ordercategory.value +"\" " ;
		xmlStr += "order_type=\""+ order_type +"\" " ;

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
		xmlHttp.open( "POST", "ORApptOrderSelectionValidate.jsp?bean_id=" + bean_id +"&localeName="+tmplocale+ "&default_val=''&validate=ref_ord", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );

}


function populateActivity(ordertype)
{
 		var frmObj		= document.OrderableSearch;
		var tmplocale   =frmObj.templocale.value;
 		clearActivityList("document");
 		var bean_id		= frmObj.bean_id.value ;
		order_category	= frmObj.ordercategory.value ;
		order_type		= ordertype.value ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += "order_category=\""+ order_category +"\" " ;
		xmlStr += "order_type=\""+ order_type +"\" " ;

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open( "POST", "ORApptOrderSelectionValidate.jsp?bean_id=" + bean_id +"&localeName="
		+tmplocale+"&default_val=''&validate=ref_order_type", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );

}

function clearList( docObj ) {
		var frmObj		= document.OrderableSearch;
	
	var len = frmObj.typecode.options.length;
	for(var i=0;i<len;i++)
	{
		frmObj.typecode.remove("typecode");
	}
		var tp = getLabel("Common.all.label","Common") ;
		var opt = eval(docObj+".createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval("frmObj.typecode.add(opt)") ;
}

function clearActivityList( docObj ) {
		var frmObj		= document.OrderableSearch;
	
	var len = frmObj.activity_type.options.length;
	for(var i=0;i<len;i++)
	{
		frmObj.activity_type.remove("activity_type");
	}
		var tp = getLabel("Common.all.label","Common") ;
		var opt = eval(docObj+".createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval("frmObj.activity_type.add(opt)") ;
}
function addLocationList(code,value) {

		var frmObj		= document.OrderableSearch;
		var element = document.createElement('OPTION') ;
		element.value =  code ;
		element.text = value ;
		frmObj.typecode.add(element);
	
}
function addActivityTypeList(code,value) {

		var frmObj		= document.OrderableSearch;
		var element = document.createElement('OPTION') ;
		element.value =  code ;
		element.text = value ;
		frmObj.activity_type.add(element);
	
}

function searchResult()
{

	var frmObj	= document.OrderableSearch;
	order_category=frmObj.ordercategory.value;
	type_code=frmObj.typecode.value;
	activity_type=frmObj.activity_type.value;
	
	if(frmObj.search_by[0].checked)
	{
		search_by="D";
	}
	else
	{
		search_by="C";
	}
		description_code=frmObj.search_criteria.value
		search_text=frmObj.search_text.value;
 		var called_from = frmObj.called_from.value;  
 		var bean_id = frmObj.bean_id.value;  
 		var bean_name = frmObj.bean_name.value;  
 		var p_clinic_code = frmObj.p_clinic_code.value;  
 		var qry_str = frmObj.qry_str.value;
 		parent.OrderSelectionResult.location.href = "../../eOR/jsp/ORApptOrderSelectionResult.jsp?qry_str="+qry_str+"&order_category="+order_category+"&type_code="+type_code+"&activity_type="+activity_type+"&search_by="+search_by+"&description_code="+description_code+"&search_text="+encodeURIComponent(search_text)+"&called_from="+called_from+"&bean_id="+bean_id+"&bean_name="+bean_name+"&p_clinic_code="+p_clinic_code;

		 

}

function resetFormSearch(frmObj)
{
		var qry_str= document.OrderableSearch.qry_str.value;
		if(qry_str.indexOf("searchText")!=-1)
		{
			qry_str=qry_str.substring(qry_str.indexOf("&"));
		}
 		parent.parent.OrderSelectionCriteriaFrame.location.href = "../../eOR/jsp/ORApptOrderSelection.jsp?"+qry_str;
		parent.parent.OrderSelectionCriteriaFrame.document.getElementById("search_text").value="";
		parent.parent.OrderSelectionResult.location.href = "../../eCommon/html/blank.html";
		var bean_id=parent.parent.OrderSelectionCriteriaFrame.document.getElementById("bean_id").value;
		var bean_name=parent.parent.OrderSelectionCriteriaFrame.document.getElementById("bean_name").value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
	
		var functional_mode="Reset_Order_Catalog";
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open( "POST", "ORApptOrderSelectionValidate.jsp?validate="+functional_mode+"&bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );

}

function populateSearch()
{
	if(window.event.keyCode==13)
	{
		searchResult();
	}
}

function callDisable(){
	
	var ord_cat=document.OrderableSearch.ordercategory.value;
	var ord_type=document.OrderableSearch.typecode.value;
	if(ord_cat !="")
		document.OrderableSearch.ordercategory.disabled= true;
	else
		document.OrderableSearch.ordercategory.disabled= false;
		
	if(ord_type != "")
		document.OrderableSearch.typecode.disabled= true;
	else
		document.OrderableSearch.typecode.disabled= false;

}
async function callOrderable(target)
{
	var searchText = target.value;
	var dialogHeight= "37.5" ;
	var dialogWidth	= "50" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;

	var retVal =await window.showModalDialog("../../eOR/jsp/OrderableFrameSet.jsp?searchText="+encodeURIComponent(searchText)+"&mode="+MODE_INSERT,arguments,features);
}
var appt_ref_no = "";
function getDescription(obj,key,count)
{
			var rowno=rowno-1;
			var bean_id=document.getElementById("bean_id").value;
			var bean_name=document.getElementById("bean_name").value;
			value=eval(document.getElementById("short_desc"+count)).value;
			order_type_code=eval(document.getElementById("order_type_code1"+count)).value;
			order_category=eval(document.getElementById("order_category1"+count)).value;
			appt_ref_no=eval(document.getElementById("appt_ref_no"+count)).value;
			var from =document.getElementById("from").value;
			var to =document.getElementById("to").value;
				
			if(obj.checked)
			{
					
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
			
				var functional_mode="Add_Temp_Order_Catalog";
				xmlStr ="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				xmlHttp.open( "POST", "ORApptOrderSelectionValidate.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_type_code="+order_type_code+"&order_category="+order_category+"&appt_ref_no="+appt_ref_no+"&from="+from+"&to="+to,false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				var responseTxt = eval(responseText);
				
				parent.OrderSelectionSelectedText.location.href = "../../eOR/jsp/ORApptOrderSelectionSelectedText.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_type_code="+order_type_code+"&order_category="+order_category+"&appt_ref_no="+appt_ref_no+"&from="+from+"&to="+to;
			
			}
			else 
			{
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
			
				var functional_mode="Remove_Temp_Order_Catalog";
				xmlStr ="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				xmlHttp.open( "POST", "ORApptOrderSelectionValidate.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_type_code="+order_type_code+"&order_category="+order_category+"&appt_ref_no="+appt_ref_no+"&from="+from+"&to="+to,false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval(responseText );
				parent.OrderSelectionSelectedText.location.href = "../../eOR/jsp/ORApptOrderSelectionSelectedText.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_type_code="+order_type_code+"&order_category="+order_category+"&appt_ref_no="+appt_ref_no+"&from="+from+"&to="+to;
			
				parent.OrderSelectionResult.location.href = parent.OrderSelectionResult.location.href;
			}
			
}
async function callBilling(patient_id,encounter_id,patient_class,facility_id,called_from)
{

	var dialogTop   = "100";
	var dialogLeft   = "30";
	var dialogHeight= "45" ;
	var dialogWidth = "60" ;
	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +';dialogLeft:'+dialogLeft +'; scroll=yes; status=no';

	var finalString="patient_id="+patient_id+ "&encounter_id=" +encounter_id+"&patient_class="+patient_class+"&facility_id="+ facility_id+"&called_from="+called_from;
	var arguments	= "";
	var retVal 			= await window.showModalDialog("../../eOR/jsp/OrderEntryBillingFrameset.jsp?"+finalString,arguments,features);

}

function submitOrderable()
{
	var bean_id=document.getElementById("bean_id").value;
	var bean_name=document.getElementById("bean_name").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	var functional_mode="Submit_Order_Catalog";
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open( "POST", "ORApptOrderSelectionValidate.jsp?validate="+functional_mode+"&bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}


function addCatalog(orderSet)
{
	return orderSet;
}

var message = "";
function assignResult(_result, _message, _flag)
{
	result	= _result ;
	message = _message ;
	flag	= _flag ;
	
}

function Add()
{
	var bean_id=document.OrderSelectionRecord.bean_id.value;
	var bean_name=document.OrderSelectionRecord.bean_name.value;
	var appt_ref_no=document.OrderSelectionRecord.appt_ref_no.value;
	var facilityid=document.OrderSelectionRecord.facilityid.value;
	var frmObj = parent.OrderSelectionRecordButton.document.OrderSelectionRecord ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	var functional_mode="Record_Order_Catalog";
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open( "POST", "ORApptOrderSelectionValidate.jsp?validate="+functional_mode+"&bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
	if(frmObj)
		eval( formApply(frmObj ,OR_CONTROLLER ) );							
	if(result)
	{
		if(message != null && message != "" && message != " ")
		{
			if(message.indexOf("<br>") != -1)
			{
				message = message.replace("<br>","");
			}
		}							
		alert(message);
		submitOrderable();
		parent.window.close();
	}	
}

function Cancel()
{
	var bean_id=document.OrderSelectionRecord.bean_id.value;
	var bean_name=document.OrderSelectionRecord.bean_name.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	var functional_mode="Clear_Order_Catalogs";
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open( "POST", "ORApptOrderSelectionValidate.jsp?validate="+functional_mode+"&bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
	//parent.window.close();
	const dialogTag = parent.parent.document.getElementById('dialog_tag');dialogTag.close();
}
