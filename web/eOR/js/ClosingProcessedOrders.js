/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var	headerDoc		= null	;
var	formObjHeader	= null	;
var	function_id		= "" ;
var	result_apply			= false;
var	message_global		= "" ;
var	flag_apply  =   true;

function create()
{
	f_query_add_mod.location.href="../../eOR/jsp/ClosingProcessedOrdersAddModify.jsp?mode=1&function_id=Closing_Processed_Order";
}

function query()
{
	f_query_add_mod.location.href='../../eOR/jsp/ClosingProcessedOrdersQueryCriteria.jsp?mode=2&function_id=Closing_Processed_Order';
	
}

function reset()
{
	var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if ( (url.indexOf("queryresult.jsp")!=-1) ||  (url.indexOf("blank")!=-1) )
	{
		 
		 return ;
	}
	/* else if(f_query_add_mod.document.forms[0].name=="query_form")
		 {
		 
		 f_query_add_mod.document.forms[0].reset();
		 }*/
	 
	 else
	{
		
		 f_query_add_mod.Closing_ProcessedOrders_top.frm_closed_processed_order.reset();
		 f_query_add_mod.Closing_ProcessedOrders_bottom.location.href="../../eCommon/html/blank.html";
	}

}


function getData(OrderTypeCode) 
{
	if(OrderTypeCode.value == "" ) 
		return ;



	var OrderTypeCodeValue = OrderTypeCode.value ;
	var bean_id = parent.f_query_add_mod.document.frm_closed_processed_order.bean_id.value ;
	
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr ="<root><SEARCH " ;
	xmlStr += OrderTypeCode.name+ "=\""+OrderTypeCode.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST","ClosingProcessedOrdersFillDetail.jsp?bean_id=eOr_Cl_Process_Order&fill=Unproces", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	eval( responseText ) ;

}

function checkIsValidForProceed()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&& (url.indexOf("blank")==-1) )
	  return true;
	 else
	  return false;
}

function apply() 
{

	if (! checkIsValidForProceed() )
    {
		var message  = getMessage("NOT_VALID","OR"); 
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	
	var	formObj	= f_query_add_mod.Closing_ProcessedOrders_top.document.frm_closed_processed_order ;
	var fields = new Array (formObj.order_category,
							formObj.order_type);

	var names = new Array ( getLabel("Common.OrderCategory.label","Common"),
							 getLabel("Common.OrderType.label","Common"));

	if(checkFieldsofMst( fields, names, messageFrame))
	{

     	eval(formApply(f_query_add_mod.Closing_ProcessedOrders_bottom.document.frm_closed_processed_order_bottom,OR_CONTROLLER)) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message_global;
		//f_query_add_mod.Closing_ProcessedOrders_bottom.document.frm_closed_processed_order_bottom
	
		if(result_apply)
		{
			onSuccess();
		}

	}
}//end of apply

function assignResult( _result,	message, _flag ) 
{
	result_apply	= _result ;
	message_global	= message	;
	flag_apply	= _flag;
}

function onSuccess() 
{
	var mode = f_query_add_mod.Closing_ProcessedOrders_top.document.frm_closed_processed_order.mode.value;
	formReset();                  	
}

function formReset () {
		//f_query_add_mod.location.reload();
		var order_type = document.frames[1].frames[0].frm_closed_processed_order.order_type.value ;
		var order_category = document.frames[1].frames[0].frm_closed_processed_order.order_category.value ;
		document.frames[1].frames[1].location.href = "../../eOR/jsp/ClosingProcessedOrdersAddModifyBottom.jsp?order_type="+order_type+"&order_category="+order_category+"&mode=1&function_id=Closing_Processed_Order" ; 
}

function getHandleHeader()
{
	headerDoc	     =f_query_add_mod.frm_closed_processed_order.document ;	
	formObjHeader   =headerDoc.frm_closed_processed_order ;
}

function CheckInValidDigit(number)
{

	var flagCheck=true;
	if( number.length==3 )
	{
				if ((number.substring(0,3)=="000") )
				{
					flagCheck=false;
					return flagCheck;
				}	
	}
	else if (number.length==2)
	{
		if((number.substring(0,2)=="00") )
			flagCheck=false;
		   return flagCheck;
	}
	else if (number.length==1)	
	{
		if (number.substring(0,1)=="0")
		{
			flagCheck=false;
			return flagCheck;
		}
	}
return flagCheck;  
}

function CheckForNumber(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function ValidNumber(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function populateOrderTypes(ord_cat){

    if( ord_cat.value == "" ) 
	{
		clearList("document")
	}
	var bean_id = document.frm_closed_processed_order.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_cat.name+"=\""+ ord_cat.value +"\" " ;
	xmlStr += document.frm_closed_processed_order.facility_id.name+"=\""+document.frm_closed_processed_order.facility_id.value+"\" ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var validate = ord_cat.name;

	xmlHttp.open( "POST", "ClosingProcessedOrdersFillDetail.jsp?bean_id=" + bean_id + "&validate="+validate, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
}

function populatePatientClass()
{
	var order_type = document.frm_closed_processed_order.order_type.value ;	
	var order_category = document.frm_closed_processed_order.order_category.value ;
	if(order_type  == "" || order_category  == "")
	{
		parent.parent.f_query_add_mod.Closing_ProcessedOrders_bottom.location.href = "../../eCommon/html/blank.html";
		
	}else
	{
		parent.parent.f_query_add_mod.Closing_ProcessedOrders_bottom.location.href = "../../eOR/jsp/ClosingProcessedOrdersAddModifyBottom.jsp?order_type="+order_type+"&order_category="+order_category+"&mode=1&function_id=Closing_Processed_Order" ; 
	}
}

function clearList( docObj ) 
{
	var len = eval(docObj+".frm_closed_processed_order.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".frm_closed_processed_order.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".frm_closed_processed_order.order_type.add(opt)") ;
}

function addOrderTypeList(code,value) 
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.frm_closed_processed_order.order_type.add(element);
}

function changeChkValue(obj)
{
	if (obj.checked)
	{
		obj.value="Y";
	}else{
		obj.value="N";
	}

}
