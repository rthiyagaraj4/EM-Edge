/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;
//var grt="";
function create()
{
	clearObject();
	OrderEntryReport.rows = "10%,27%,*,12%";
		//document.getElementById("commontoolbarFrame").style.height="8vh";
		//document.getElementById("OROrderentryreportGrpdtl").style.height="66vh";
		//document.getElementById("paneldetails1").style.height="14vh";
		//document.getElementById("messageFrame").style.height="9vh";
 OROrderentryreportGrpdtl.location.href='../../eOR/jsp/OROrderEntryRepGrpAddModify.jsp'
 paneldetails1.location.href="../../eCommon/html/blank.html";
}

function query()
{
		OrderEntryReport.rows = "8%,*,0%,12%";
		//document.getElementById("commontoolbarFrame").style.height="8vh";
		//document.getElementById("OROrderentryreportGrpdtl").style.height="66vh";
		//document.getElementById("paneldetails1").style.height="14vh";
		//document.getElementById("messageFrame").style.height="9vh";
		OROrderentryreportGrpdtl.location.href='../../eOR/jsp/OROrderEntryRepGrpQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}

function addelementList(code,value) 
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.OROrderentryreportgrp.listOrderCategory1.add(element);
}
function OrderCatg(obj)
{
	// Order_Category = document.getElementById("Order_Category").value
	//grt=obj.value;
	//alert(Order_Category);
	/*if(obj.value=="LB")
	{
       id="mnmnmm";
      var value=new Array(getLabel("eOR.OrderSheetForLaboratory.label","OR")
		                   );
	  var value1=new Array(getLabel("eOR.OrderSheetForBT.label","OR"));
       addelementList(id,value);
	   addelementList(id,value1);
	}*/
 if(obj.value!="")
	{
		
	document.getElementById('appl_ord_type').disabled=false;
	document.getElementById('appl_ord_type').checked=false;
	document.getElementById('appl_ord_type').disabled=false;
	document.getElementById('appl_ord_type').checked=true;
	parent.paneldetails1.location.href="../../eCommon/html/blank.html";
	
	}
  if(obj.value=="")
	{
	 parent.paneldetails1.location.href="../../eCommon/html/blank.html";
	 document.getElementById('appl_ord_type').checked=false;
	 document.getElementById('appl_ord_type').checked=true;
	 document.getElementById('appl_ord_type').disabled=true;
	 document.getElementById('appl_ord_type').disabled=false;
	}

}
function clearObject()
{
		var xmlStr = "";
		var CallFrom = "CLEAR_OBJECT";		
		xmlStr ="<root><SEARCH ";
		xmlStr += "CallFrom=\""+ CallFrom +"\" " ;		
		xmlStr +=" /></root>" ;		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OROrderEntryRepGrpInterMediate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);	
}
function getordertype(obj)
{
	if (obj.value == "A")
	{		
		clearObject();
		parent.paneldetails1.location.href="../../eCommon/html/blank.html";
	}
	else if (obj.value == "S")
	{
		order_category = document.getElementById("order_category").value	;
		
		if(order_category!="")
		{
			parent.OrderEntryReport.rows = "10%,27%,*,12%";
			parent.paneldetails1.location.href="../../eOR/jsp/OROrderEntryRepGrpDetail.jsp?order_category="+order_category;
		}
	}
	
}


function assignResult( _result,	_message, _flag ) 
{
	result	= _result ;
	message	= _message	;
	flag	= _flag;
}


function apply()
{
	if (! checkIsValidForProceed() ) 
	{
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	
	var formobj=OROrderentryreportGrpdtl.document.OROrderentryreportgrp;
	var fields= new Array(formobj.report_type_id
		                   ,formobj.cust_rep_grp_code
		                   ,formobj.cust_rep_grp_desc
		                   ,formobj.order_category
		                   ,formobj.cust_report_id		                  
		                  );
	var names= new Array(getLabel("eOR.ReportType.label","OR")
		                ,getLabel("eOR.GroupingCode.label","OR")
		                ,getLabel("eOR.GroupingDescription.label","OR")
		                ,getLabel("Common.OrderCategory.label","COMMON")
		                ,getLabel("eOR.PrintReportFormat.label","OR")		               
		               );
	
	 if(OROrderentryreportGrpdtl.checkFieldsofMst(fields,names,messageFrame)) 
	 {
		 var appl_ord_type = "";
		 for (var i=0; i <formobj.appl_ord_type.length; i++)
		{
		   if (formobj.appl_ord_type[i].checked)
		   {
				appl_ord_type = formobj.appl_ord_type[i].value;
				
		   }
		 
		}
		
		var xmlStr = "";
		var eff_status = formobj.eff_status.value;
		var CallFrom = "SAVE_RPT_GRP";		
		xmlStr ="<root><SEARCH ";
		xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
		xmlStr += "REPORT_TYPE_ID=\""+ formobj.report_type_id.value +"\" " ;
		xmlStr += "CUST_REP_GRP_CODE=\""+ formobj.cust_rep_grp_code.value +"\" " ;		
		xmlStr += "CUST_REP_GRP_DESC=\""+ formobj.cust_rep_grp_desc.value +"\" " ;		
		xmlStr += "ORDER_CATEGORY=\""+ formobj.order_category.value +"\" " ;		
		xmlStr += "CUST_REPORT_ID=\""+ formobj.cust_report_id.value +"\" " ;				
		xmlStr += "MODE=\""+ formobj.mode.value +"\" " ;				
		xmlStr += "APPL_ORD_TYPE=\""+ appl_ord_type +"\" " ;		
		xmlStr += "EFF_STATUS=\""+ eff_status +"\" " ;		
		xmlStr +=" /></root>" ;			
		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OROrderEntryRepGrpInterMediate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
	 }
}


function reset()
{
	var url = OROrderentryreportGrpdtl.location.href;

	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")!= -1) &&(url.indexOf("blank")!= -1) ){
		return false;
	}
	if(url.indexOf("query") != -1){
		OROrderentryreportGrpdtl.document.forms[0].reset();
		return true;
	}
	clearObject();
	OROrderentryreportGrpdtl.location.reload();
	paneldetails1.location.href="../../eCommon/html/blank.html";
}

function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

/*
    Function Name :  stringConCatenate(objIndex,objRowId)
	Description :	The Function is Used For ConCatenation of Text Fields Values and TD Data
   @param objIndex  Index of the Dynamically Created HTML Object
    @param objRow  is the  ID for the Table Row  Dynamically Created 
 */
function setOrderType(obj)
{
	var xmlStr = "";
	var CallFrom = "";
	if (obj.checked)
	{	
		 CallFrom = "ADD_ORDER_TYPE";			
	}
	else
	{
		
		 CallFrom = "REMOVE_ORDER_TYPE";	
	}
		
		xmlStr ="<root><SEARCH ";
		xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
		xmlStr += "order_type=\""+ obj.value +"\" " ;		
		xmlStr +=" /></root>" ;		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OROrderEntryRepGrpInterMediate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);	
	
}

function changeStatus(obj)
{
	if (obj.checked)
	{
		obj.value = "E";
	}else{
		obj.value = "D";
	}

}

function checkIsValidForProceed()
{
		 var url = OROrderentryreportGrpdtl.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}

