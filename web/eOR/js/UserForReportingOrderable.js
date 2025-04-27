/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var linkContent = "";
var ord_type_value ="";



function populateOrderTypes(){

	
	var bean_id = document.formOrderableHeader.bean_id.value ;
	var ord_cat = document.formOrderableHeader.order_category ;


	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_cat.name+"=\""+ ord_cat.value +"\" " ;
	xmlStr +=" /></root>" ;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "UserForReportingOrderableValidate.jsp?bean_id=" + bean_id + "&validate=ord_cat", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;

}

function addOrderTypeList(code,value) {
	
		var element = document.createElement('OPTION') ;
		element.value =  code ;
		element.text = value ;
		document.formOrderableHeader.order_type.add(element);
	
}

function clearL2List( docObj ) {
	var len = eval(docObj+".formOrderableHeader.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".formOrderableHeader.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".formOrderableHeader.order_type.add(opt)") ;
	
}




/***************************************************************************************/
/**************************************************************************************/
/********onClick of the select button *******************************************/
/*************************************************************************************/

function display(obj){
	

		var buttonVal			   	= obj;
		var formObj				   	= document.detailUpperForm;
		var ord_category_value   	= formObj.ord_category_value;
		var ord_type_value		   	= formObj.ord_type_value;
				
		if(buttonVal == "S"){
			//document.detailUpperForm.all.SelectTab.className="clicked";
			document.getElementById("SelectTab").className="clicked";
			//document.detailUpperForm.all.AssociateTab.className="normal";
			document.getElementById("AssociateTab").className="normal";
			
		}else if(buttonVal == "A"){
			//document.detailUpperForm.all.SelectTab.className="normal";
			document.getElementById("SelectTab").className="normal";
			//document.detailUpperForm.all.AssociateTab.className="clicked";
			document.getElementById("AssociateTab").className="clicked";
		}
		//document.detailUpperForm.all.tabVal.value = buttonVal;
		document.getElementById("tabVal").value = buttonVal;

		if(parent.frameUserOrderableResult.location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
		}

		if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;

		var queryString ="tabVal="+buttonVal+"&ord_category_value="+ord_category_value.value+"&ord_type_value="+ord_type_value.value;
		

		if(buttonVal=="A"){
		//document.detailUpperForm.all.linkId.className ="";
			document.getElementById("linkId").className ="";
		//document.detailUpperForm.all.linkId.innerHTML = "&nbsp;";
			document.getElementById("linkId").innerHTML = "&nbsp;";
		parent.frameUserOrderableResult.location.href="../../eOR/jsp/UserForReportingResult.jsp?"+queryString;

		parent.frameUserOrderableSubmit.location.href="../../eOR/jsp/UserForReportingSubmit.jsp";	
		

		}else{
			parent.frameUserOrderableResult.location.href="../../eCommon/html/blank.html";
			//document.detailUpperForm.all.linkId.innerHTML = linkContent;
			document.getElementById("linkId").innerHTML= linkContent;
			
		}
	
}

/*****************************************************************************/

function callOnAlphaLink(obj, obj2){
	changeAlphaColor(obj2);


		if(parent.frameUserOrderableResult.location.href.indexOf(".jsp") != -1){
				var flag = latestUpdate();
		}
		var formObj				= document.detailUpperForm;
	

		var ord_category_value   	= formObj.ord_category_value;
			 ord_type_value	   		= formObj.ord_type_value;
		
		if( ord_type_value.value=="*ALL"){
		 	ord_type_value=parent.frameUserOrderable.document.formOrderableHeader.order_type;
		}
				
		var queryString ="index="+obj+"&tabVal=S&ord_category_value="+ord_category_value.value+"&ord_type_value="+ord_type_value.value;

	parent.frameUserOrderableResult.location.href="../../eOR/jsp/UserForReportingResult.jsp?"+queryString;	

	parent.frameUserOrderableSubmit.location.href="../../eOR/jsp/UserForReportingSubmit.jsp";	
}

/************************************************************************************/
/************************************************************************************/

function latestUpdate(){

	var bean_id		= parent.frameUserOrderableResult.document.formUserForReportingResult.bean_id.value;
	var bean_name	= parent.frameUserOrderableResult.document.formUserForReportingResult.bean_name.value;
	var tabVal		= parent.frameUserOrderableResult.document.formUserForReportingResult.tabVal.value;
	var row_count   = parent.frameUserOrderableResult.document.formUserForReportingResult.row_count.value;
	var value_str	= "";
	
	row_count = parseInt(row_count);
	//alert("tabVal:"+tabVal);
	//alert("row_count:"+row_count);
	
	for(i=0; i<row_count; i++){
		var value = eval('parent.frameUserOrderableResult.document.formUserForReportingResult.select_yn'+i);
				
		if(!value.disabled){
			if(value.checked==true)
				val = "Y";
			else
				val = "N";
		}else
			val ="N";
			
		value_str += val+"~";
//	alert(value_str);
	}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " ROW_COUNT=\""+ row_count + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"UserForReporting\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","UserForReportingValidateOrderable.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert( responseText ) ;

		return true;

}
	/**********************************************************************************/

	function clickAll(){
	var row_count = parent.frameUserOrderableResult.document.formUserForReportingResult.row_count.value;
	if(parent.frameUserOrderableResult.document.formUserForReportingResult.All.checked==
	true){
		for(cnt=0;cnt<row_count; cnt++){
			val = eval("parent.frameUserOrderableResult.document.formUserForReportingResult.select_yn"+cnt);
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<row_count; cnt++){
			val = eval("parent.frameUserOrderableResult.document.formUserForReportingResult.select_yn"+cnt);
			val.checked = false;
		}
	}
}

/*****************************************************************************/

function onSubmit(){
	//alert("ok");
if(parent.frameUserOrderableResult.location.href.indexOf(".jsp") != -1){
	retainValues();
}
//window.close();
const dialogTag = parent.parent.document.getElementById("dialog_tag");    
dialogTag.close();
}

/*var val =new Array();
		var catalog_code="";
	var formObj=parent.frameUserOrderable.document.formOrderableHeader.order_type_value.value;
	
	val[0]=parent.frameUserOrderable.document.formOrderableHeader.order_type_text.value;
	val[1]=parent.frameUserOrderable.document.formOrderableHeader.order_type_value.value;
		if(formObj=="" ||formObj=="*ALL"){
		val[1]=parent.frameUserOrderable.document.formOrderableHeader.order_type[parent.frameUserOrderable.document.formOrderableHeader.order_type.selectedIndex].value;
		}
	val[2]=parent.frameUserOrderable.document.formOrderableHeader.order_category_text.value;
	val[3]=parent.frameUserOrderable.document.formOrderableHeader.order_category.value;	
	var row_count=parent.frameUserOrderableResult.document.formUserForReportingResult.row_count.value;	
	var All= eval(parent.frameUserOrderableResult.document.formUserForReportingResult.all);
	if(All.checked==true){
		var all_value=parent.frameUserOrderableResult.document.formUserForReportingResult.all.value;
	}else
		all_value="";

	for(i=0;i<row_count;i++){
		var chk=eval('parent.frameUserOrderableResult.document.formUserForReportingResult.select_yn'+i);
		
			if(chk.checked==true){
			catalog_code+=","+eval('parent.frameUserOrderableResult.document.formUserForReportingResult.catalog_code'+i).value;
				
			}
		}
	if(all_value!=""){
			catalog_code+=","+all_value;
		}
	if(catalog_code.length>1){
	catalog_code = catalog_code.substring(1);
	}
	val[4]=catalog_code;
	latestUpdate();
	
		
		window.returnValue = val;
		window.close();*/



/**************************************************************************/

function refreshScr(){
	if(parent.frameUserOrderableResult.location.href.indexOf(".jsp") != -1){
		latestUpdate();
	}
	parent.frameUserOrderableResult.location.href="../../eCommon/html/blank.html";

}
/*************************************************************************/

function retainValues(){

	var bean_id		= parent.frameUserOrderableResult.document.formUserForReportingResult.bean_id.value;
	var bean_name	= parent.frameUserOrderableResult.document.formUserForReportingResult.bean_name.value;
	var tabVal		= parent.frameUserOrderableResult.document.formUserForReportingResult.tabVal.value;
	var row_count   = parent.frameUserOrderableResult.document.formUserForReportingResult.row_count.value;
	var all_value	="";
	var value_str	= "";


	row_count = parseInt(row_count);
	//alert(tabVal);

	for(i=0; i<row_count; i++){
		var value = eval('parent.frameUserOrderableResult.document.formUserForReportingResult.select_yn'+i);
		//alert(value.checked+"===="+value.disabled);
		if(!value.disabled){
			if(value.checked==true)
				val = "Y";
			else
				val = "N";
			}
			else
				val ="N";
		value_str += val+"~";

//alert(value_str);
	}

		var xmlStr ="<root><SEARCH ";
	//	xmlStr += " all_value=\""+ all_value + "\" ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " ROW_COUNT=\""+ row_count + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"UserForReporting\"";
		xmlStr +=" /></root>";
	//	alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","UserReportingValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert( responseText ) ;
	//	alert("line312");
		return true;

}


