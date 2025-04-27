/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------
14/04/2017		IN063655		Vijayakumar K										GHL-SCF-1162
--------------------------------------------------------------------------------------------------------------------------
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
	
		xmlHttp.open( "POST", "OrderableValidate.jsp?bean_id=" + bean_id +"&localeName="+tmplocale+ "&default_val=''&validate=ref_ord", false ) ;
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
		
		xmlHttp.open( "POST", "OrderableValidate.jsp?bean_id=" + bean_id +"&localeName="
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
		

				
	//	var table_name = frmObj.table_name.value;  
 		parent.refusal_resultframe1.location.href = "../../eOR/jsp/OrderableResult.jsp?order_category="+order_category+"&type_code="+type_code+"&activity_type="+activity_type+"&search_by="+search_by+"&description_code="+description_code+"&search_text="+encodeURIComponent(search_text)+"&called_from="+called_from+"&bean_id="+bean_id+"&bean_name="+bean_name+"&p_clinic_code="+p_clinic_code;

		 

}

function resetFormSearch(frmObj)
{
		var qry_str= document.OrderableSearch.qry_str.value;
		if(qry_str.indexOf("searchText")!=-1)
		{
			qry_str=qry_str.substring(qry_str.indexOf("&"))
		}
 		parent.parent.refusal_searchframe1.location.href = "../../eOR/jsp/OrderableSearch.jsp?"+qry_str;
		parent.parent.refusal_searchframe1.document.getElementById("search_text").value="";
		parent.parent.refusal_resultframe1.location.href = "../../eCommon/html/blank.html";
		var bean_id=parent.parent.refusal_resultframe1.document.getElementById("bean_id").value;
		var bean_name=parent.parent.refusal_resultframe1.document.getElementById("bean_name").value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
	
		var functional_mode="Reset_Order_Catalog";
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open( "POST", "OrderableValidate.jsp?validate="+functional_mode+"&bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
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

	var retVal = await window.showModalDialog("../../eOR/jsp/OrderableFrameSet.jsp?searchText="+encodeURIComponent(searchText)+"&mode="+MODE_INSERT,arguments,features);
}
function getDescription(obj,key,count)
{
			var rowno=rowno-1;
			var bean_id=document.getElementById("bean_id").value;
			var bean_name=document.getElementById("bean_name").value;
			value=eval(document.getElementById("short_desc"+count)).value;
			called_from=eval(document.getElementById("called_from")).value;//IN067246
			order_type_code=eval(document.getElementById("order_type_code1"+count)).value;
			order_category=eval(document.getElementById("order_category1"+count)).value;
			
			console.log(" Inside Orderable JS 256 getDescription obj.checked : "+obj.checked+" count : "+count+" key : "+key+
						" value : "+value+" called_from : "+called_from+" order_type_code : "+order_type_code+" order_category : "+order_category);
			if(obj.checked)
			{
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
			
				var functional_mode="Add_Temp_Order_Catalog";
				xmlStr ="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				//xmlHttp.open( "POST", "OrderableValidate.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_type_code="+order_type_code+"&order_category="+order_category,false ) ;//commented for IN067246
				xmlHttp.open( "POST", "OrderableValidate.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_type_code="+order_type_code+"&order_category="+order_category+"&called_from="+called_from,false ) ;//Modified for IN067246
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				var responseTxt = eval(responseText);
				console.log(" Inside Orderable JS 274 getDescription responseTxt : "+responseTxt);
				
				if(responseTxt=="ORDER_SET_SELECTED")
				{
					alert(getMessage("ORDER_SET_SELECTED","OR"));
					obj.checked = false;
					return; // Don't allow the user to select more than one
				}
				//IN063655 starts
				if(responseTxt=="BOTH_OR_CATALOG_SET_SELECTED")
				{
					alert(getMessage("CANNOT_PLACE_ORDER","OR"));
					obj.checked = false;
					return; // Don't allow the user to select both order catalog and order set
				}
				//IN063655 ends
			
			}
			else 
			{
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
			
				var functional_mode="Remove_Temp_Order_Catalog";
				xmlStr ="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				xmlHttp.open( "POST", "OrderableValidate.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_type_code="+order_type_code+"&order_category="+order_category,false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval(responseText );
				
				console.log(" Inside Orderable JS 308 getDescription responseTxt : "+responseTxt);
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
	var retVal 			=await window.showModalDialog("../../eOR/jsp/OrderEntryBillingFrameset.jsp?"+finalString,arguments,features);

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
	
	xmlHttp.open( "POST", "OrderableValidate.jsp?validate="+functional_mode+"&bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

function addCatalog(orderSet)
{
	return orderSet;
}
