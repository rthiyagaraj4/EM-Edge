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
	//parent.configSpecimenFormat.rows = "9%,25%,*,10%";
		document.getElementById("commontoolbarFrame").style.height="8vh";
		document.getElementById("frameCofigSpecimenFrmt").style.height="25vh";
		document.getElementById("frameCofigSpecimenFrmtDtl").style.height="55vh";
		document.getElementById("messageFrame").style.height="14vh";

	
	frameCofigSpecimenFrmt.location.href='../../eOR/jsp/ORConfigureSpeciLabelHdr.jsp'
	frameCofigSpecimenFrmtDtl.location.href="../../eCommon/html/blank.html";
}

function query()
{
		clearObject();
		frameCofigSpecimenFrmtDtl.location.href="../../eCommon/html/blank.html";
		//parent.configSpecimenFormat.rows = "7%,*,0%,10%";
		document.getElementById("commontoolbarFrame").style.height="8vh";
		document.getElementById("frameCofigSpecimenFrmt").style.height="53vh";
		document.getElementById("frameCofigSpecimenFrmtDtl").style.height="22vh";
		document.getElementById("messageFrame").style.height="14vh";
		frameCofigSpecimenFrmt.location.href='../../eOR/jsp/ORConfigureSpeciLabelQuery.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
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
		xmlHttp.open( "POST", "ORConfigSpecLabelInterMediate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);	
}
function isExistsSpeFrmt(facility_id)
{	
	var xmlStr = "";
	var CallFrom = "CHK_SPEC_FRMT_EXT";		
	xmlStr ="<root><SEARCH ";
	xmlStr += "CallFrom=\""+ CallFrom +"\" " ;		
	xmlStr += "FACILITY_ID=\""+ facility_id+"\" " ;			
	xmlStr +=" /></root>" ;		
	var xmlHttp = new XMLHttpRequest() ;
	var xmlDoc = "" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ORConfigSpecLabelInterMediate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;		
	document.ORConfigSpecLabelFrm.config_ref_no.value=trimString(responseText);		
	eval(responseText);
}
function apply()
{		
	var formObj=frameCofigSpecimenFrmt.document.ORConfigSpecLabelFrm;
		
	formObj.facility_id.disabled=false;
	formObj.ext_appl.disabled=false;
	formObj.spec_num_format.disabled=false;
	var config_ref_no = formObj.config_ref_no.value;
	var appl_order_type = "";	

	for (var i=0; i <formObj.appl_order_type.length; i++)
	{
	   if (formObj.appl_order_type[i].checked)
	   {
			appl_order_type = formObj.appl_order_type[i].value;			
	   }	 
	}
	
	var fields= new Array(formObj.facility_id
					   ,formObj.ext_appl			                                         
					   ,formObj.spec_num_format	     	                                          
					  );
	var names= new Array(getLabel("Common.facility.label","COMMON")
					,getLabel("eOR.ExternalApplication.label","OR")
					,getLabel("eOR.SpecimenNoFormat.label","OR")
				   );
	

	 if(frameCofigSpecimenFrmt.checkFieldsofMst(fields,names,messageFrame)) 
	 {			
		 var isTrue = true;		
		 if (config_ref_no != "")
		 {
			 isTrue = confirm(getMessage("RESET_SPEC_FRMT_FOR_ALL","OR"));
		 }		 
		if (isTrue)
		{
			var xmlStr = "";		
			var xmlHttp = new XMLHttpRequest() ;
			var xmlDoc = "" ;			
				CallFrom = "SAVE_SPEC_FRMT";		
				xmlStr ="<root><SEARCH ";
				xmlStr += "CallFrom=\""+ CallFrom +"\" " ;				
				xmlStr += "FACILITY_ID=\""+ formObj.facility_id.value+"\" " ;		
				xmlStr += "EXT_APPL=\""+ formObj.ext_appl.value +"\" " ;		
				xmlStr += "SPEC_NUM_FORMAT=\""+ formObj.spec_num_format.value +"\" " ;			
				xmlStr += "APPL_ORDER_TYPE=\""+ appl_order_type +"\" " ;			
				xmlStr += "MODE=\""+ formObj.mode.value +"\" " ;											
				xmlStr +=" /></root>" ;				
				
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "ORConfigSpecLabelInterMediate.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;					
				eval(responseText);
		}else{				
			var queryString = "home_required_yn=Y&module_id=OR&function_id=ORMS_CONFIG_SPECIMEN_LBL_NO&function_name=Configure Specimen Label and No&function_type=F&access=YYYNN&desktopFlag=N";			
			commontoolbarFrame.location.href='../../eCommon/jsp/MstCodeToolbar.jsp?'+queryString; 
			frameCofigSpecimenFrmt.location.href='../../eOR/jsp/ORConfigureSpeciLabelHdr.jsp?'+queryString; 
			frameCofigSpecimenFrmtDtl.location.href='../../eCommon/html/blank.html'; 
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='; 								
		}						
	 }
}


function reset()
{
	var url = frameCofigSpecimenFrmt.location.href;

	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")!= -1) &&(url.indexOf("blank")!= -1) ){
		return false;
	}
	if(url.indexOf("query") != -1){
		frameCofigSpecimenFrmtDtl.document.OROrderTypefrm.reset();
		return true;
	}
	clearObject();
	frameCofigSpecimenFrmt.location.reload();
	frameCofigSpecimenFrmtDtl.location.href='../../eOR/jsp/ORConfigureSpeciLabelForOrderType.jsp?mode='+MODE_MODIFY+"&function_id="+function_id;
}



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
		xmlHttp.open( "POST", "ORConfigSpecLabelInterMediate.jsp", false ) ;
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

function loadOrderTypes(obj)
{	
	var formObj=document.ORConfigSpecLabelFrm;	
	var facility_id = formObj.facility_id.value;
	var ext_appl = formObj.ext_appl.value;	
	var spec_num_format = formObj.spec_num_format.value;
	
	var appl_order_type = "";
	if (facility_id != "")
	{
		isExistsSpeFrmt(facility_id);
	}
	
	for (var i=0; i <formObj.appl_order_type.length; i++)
	{
	   if (formObj.appl_order_type[i].checked)
	   {
			appl_order_type = formObj.appl_order_type[i].value;			
	   }	 
	}
		
	if (spec_num_format != "" && facility_id != "" && ext_appl != "" && appl_order_type =="S")
	{
		clearObject();		
		parent.frameCofigSpecimenFrmtDtl.location.href='../../eOR/jsp/ORConfigureSpeciLabelForOrderType.jsp?function_id='+function_id+'&spec_num_format='+spec_num_format+'&facility_id='+facility_id+'&ext_appl='+ext_appl+'&appl_order_type='+appl_order_type ;
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';

	}else if(obj.value == "" && appl_order_type =="S"){
		clearObject();		
		parent.frameCofigSpecimenFrmtDtl.location.href='../../eOR/jsp/ORConfigureSpeciLabelForOrderType.jsp?function_id='+function_id+'&spec_num_format='+spec_num_format+'&facility_id='+facility_id+'&ext_appl='+ext_appl+'&appl_order_type='+appl_order_type ;
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
	}

	
}

function getordertype(obj)
{
	if (obj.value == "A")
	{		
		clearObject();
		parent.frameCofigSpecimenFrmtDtl.location.href="../../eCommon/html/blank.html";
	}
	else if (obj.value == "S")
	{		
		var formObj=document.ORConfigSpecLabelFrm;	
		var facility_id = formObj.facility_id.value;
		var ext_appl = formObj.ext_appl.value;	
		var spec_num_format = formObj.spec_num_format.value;
		//parent.configSpecimenFormat.rows = "9%,25%,*,10%";
		parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.document.getElementById("frameCofigSpecimenFrmt").style.height="25vh";
		parent.document.getElementById("frameCofigSpecimenFrmtDtl").style.height="55vh";
		parent.document.getElementById("messageFrame").style.height="14vh";
		parent.frameCofigSpecimenFrmtDtl.location.href='../../eOR/jsp/ORConfigureSpeciLabelForOrderType.jsp?function_id='+function_id+'&spec_num_format='+spec_num_format+'&facility_id='+facility_id+'&ext_appl='+ext_appl;
	}
	
}

