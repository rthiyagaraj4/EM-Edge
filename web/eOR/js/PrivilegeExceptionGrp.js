/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var linkContent = "";
var isQuery = "N";

function create(){
	f_query_add_mod.location.href="../../eOR/jsp/PrivilegeExceptionGrpMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
	isQuery = "N";
}

function query(){
	f_query_add_mod.location.href="../../eOR/jsp/PrivilegeExceptionGrpQueryCriteria.jsp?function_id="+function_id; 
	isQuery = "Y";
}

function Modify(obj){
	var grp_exception_id	=obj.cells[0].innerText;
	var grp_exception_name	=obj.cells[1].innerText;
	var exception_type		=obj.cells[2].innerText;

	if(exception_type=="Order Category ")
		exception_type="OC";
	else if(exception_type=="Order Type ")
		exception_type="OT";
	else if(exception_type=="Orderable ")
		exception_type="OR";

	document.location.href="../../eOR/jsp/PrivilegeExceptionGrpMain.jsp?mode=2&grp_exception_id="+grp_exception_id+"&grp_exception_name="+encodeURIComponent(grp_exception_name)+"&exception_type="+exception_type+"&function_id="+parent.function_id;
}

function apply(){
		//alert("apply called");
	if (! checkIsValidForProceed() )
    {
			var message  = getMessage("NOT_VALID","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	}	
	var result=true;
	var formHdrObj	= f_query_add_mod.headerFrame.document.formPrivilegeExpGrpHdr;	
	if(f_query_add_mod.detailFrame.location.href.indexOf(".jsp") != -1){
	var formObj		= f_query_add_mod.detailFrame.document.formPrivilegeExpGrpDtl;
		var	fields		= new Array (formHdrObj.exception_type
									,formObj.grp_exception_id
									,formObj.grp_exception_name
									);

		var	names		=	new	Array (getLabel("eOR.PrivilegeLevel.label","OR")
									  ,getLabel("eOR.GroupID.label","OR")
									  ,getLabel("eOR.GroupName.label","OR")
									  );

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
			var flds=new Array( f_query_add_mod.detailFrame.document.formPrivilegeExpGrpDtl.grp_exception_id , f_query_add_mod.headerFrame.document.forms[0].grp_exception_name);
			var name=new Array(getLabel("eOR.GroupID.label","OR") ,getLabel("eOR.GroupName.label","OR"));
			//alert(f_query_add_mod.detailFrame.document.formPrivilegeExpGrpDtl.grp_exception_id.value);
			//alert(document.forms[0].grp_exception_id.value);
			//if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
			//	return false;
			//}
			
			var flag = onApplyUpdate();
			if(flag){

				formObj.mode.value = "1";
				

				//alert( formApply(f_query_add_mod.detailFrame.document.formPrivilegeExpGrpDtl, OR_CONTROLLER));
				//alert("before eval");
				
				eval( formApply(f_query_add_mod.detailFrame.document.formPrivilegeExpGrpDtl, OR_CONTROLLER) ) ;
				//alert("after eval");
				/*	if(messageGlobal == "RECORD_INSERTED")
					{
						messageGlobal = getMessage("RECORD_INSERTED");
					}
				*/	
				if(result){
					if(isQuery == "Y"){
						messageGlobal = getMessage("RECORD_MODIFIED","SM");
						f_query_add_mod.location.reload();
					}else{
						messageGlobal = getMessage("RECORD_INSERTED","SM");
						onSuccess();
					}

					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
				}
						isQuery = "N";
			}
		}
	}else{
			if(formHdrObj.exception_type.value == ""){
				var msg = getMessage("PRIVILEGE_LEVEL_BLANK","OR");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				return false;
			}
		}
}

function onSuccess(){
	f_query_add_mod.headerFrame.location.href="../../eOR/jsp/PrivilegeExceptionGrpHdr.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
	f_query_add_mod.detailFrame.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.listFrame.location.href="../../eCommon/html/blank.html";
}

function onApplyUpdate(){
	//alert("apply update called");
	var refForm = f_query_add_mod.listFrame.document.formPrivilegeExpGrpList;	
	if(f_query_add_mod.listFrame.location.href.indexOf(".jsp") != -1){
		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";
		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);
		
		//alert(" check prop " + refForm.select_ynAll.checked);
		//alert(" check value " + refForm.select_ynAll.value);

/*		if(isQuery == "Y")
		{
			//alert(" isQuery = Y");
			if(f_query_add_mod.listFrame.document.forms[0].select_ynAll.checked)
				val = "Y";
			else
				val = "N";

			value_str += val + "~";
		}
*/
		//var strValue = "";
		for(i=fm_disp; i<=to_disp; i++)
		{
			var value = eval('f_query_add_mod.listFrame.document.forms[0].select_yn'+i);
			//alert("index  " + i + " value  " + value);
			if(!value.disabled){
				//alert(value.checked);
				if(value.checked) 
				{
					val = "Y";
					//str = eval('f_query_add_mod.listFrame.document.forms[0].strHidden' + i);
					//strValue = str.value;
					//alert(strValue);
				}
				else 
					val = "N";
				}
				else
					val = "N";
				//if(strValue != "" || strValue != " " || strValue == null)
				//	value_str += val+ "#"+ strValue + "~";
				//else
					value_str += val + "~";

				//	strValue = "";
		}
		
		
		//alert("value string   #$%^^&&     " + value_str);
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";// if necessary add + 1
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"PrivilegeExceptionGrpBean\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert("before submitting to validate");
		xmlHttp.open("POST","PrivilegeExceptionGrpValidate.jsp",false);
		//alert("after submitting to validate");
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert( responseText ) ;
		return true;
	}
	else
	{
		return true;
	}
}

function reset(){
	
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();

 if ( (url.indexOf("queryresult.jsp")!=-1) &&(url.indexOf("blank")!=-1) )
	 {
			// return true;
			//f_query_add_mod.location.href="../../eOR/jsp/PrivilegeExceptionGrpQueryCriteria.jsp";
			return ;
	 }

if(url.indexOf("query") != -1)
	{
		//f_query_add_mod.location.href="../../eOR/jsp/PrivilegeExceptionGrpQueryCriteria.jsp";
			f_query_add_mod.document.forms[0].reset();
			//return true;
	}
if(url.indexOf("main.jsp") != -1)
	{
		var mode = f_query_add_mod.document.formMain.mode.value;
		if(mode == "1")
			f_query_add_mod.location.href="../../eOR/jsp/PrivilegeExceptionGrpMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
		else
			//	f_query_add_mod.location.href="../../eOR/jsp/PrivilegeExceptionGrpQueryCriteria.jsp";
		f_query_add_mod.listFrame.document.formPrivilegeExpGrpList.reset();
	}
/*if(url.indexOf("addmodify.jsp") != -1)
	{
		f_query_add_mod.location.href="../../eOR/jsp/PrivilegeExceptionGroupAddModifyMultiple.jsp";
	}*/
	//create();
}

function assignResult(res,msg,mod){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;
	//alert(flagGlobal);
}

function loadDtlFrame(obj){
	var value=obj.value
	var function_val = document.formPrivilegeExpGrpHdr.function_id.value;
	if(value !=""){
		parent.detailFrame.location.href="../../eOR/jsp/PrivilegeExceptionGrpDtl.jsp?exception_type="+value+"&function_id="+function_val;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		if(value=="OC"){
			parent.listFrame.location.href="../../eOR/jsp/PrivilegeExceptionGrpList.jsp?exception_type="+value;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}else{
			parent.listFrame.location.href="../../eCommon/html/blank.html";
		}
	}else{
		parent.detailFrame.location.href="../../eCommon/html/blank.html";
		parent.listFrame.location.href="../../eCommon/html/blank.html";
	}
}



function latestUpdate(){
		
	var bean_id		= parent.listFrame.document.formPrivilegeExpGrpList.bean_id.value;
	var bean_name	= parent.listFrame.document.formPrivilegeExpGrpList.bean_name.value;
	var fm_disp		= parent.listFrame.document.formPrivilegeExpGrpList.fm_disp.value;
	var to_disp		= parent.listFrame.document.formPrivilegeExpGrpList.to_disp.value;
	var tabVal		= parent.listFrame.document.formPrivilegeExpGrpList.tabVal.value;
	var from		= parent.listFrame.document.formPrivilegeExpGrpList.from.value	
	var value_str	= "";
	if(from != "null"){
	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);
	
	for(i=fm_disp; i<=to_disp; i++){
		var value = eval('parent.listFrame.document.formPrivilegeExpGrpList.select_yn'+i);
		if(!value.disabled){
				if(value.checked) 
					val = "Y";
				else 
					val = "N";
				}
				else
					val ="N";

			value_str += val+"~";
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"PrivilegeExceptionGrpBean\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrivilegeExceptionGrpValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert( responseText ) ;
	}
	return true;
}

function callOnAlphaLink(obj, obj2){
	changeAlphaColor(obj2);
	if(parent.listFrame.location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
	}
	var formFld					= document.formPrivilegeExpGrpDtl.all;
	var formHdrFld				= parent.headerFrame.document.getElementById("formPrivilegeExpGrpHdr");
	var exception_type			= formFld.exception_type;
	var grp_exception_id		= formFld.grp_exception_id;
	var grp_exception_name		= formFld.grp_exception_name;
	var mode					= formFld.mode.value;
	var fields					= new Array (grp_exception_id, grp_exception_name);
	var names					= new Array (getLabel("eOR.GroupID.label","OR"), getLabel("Common.GroupName.label","Common"));
	if(parent.parent.checkFieldsofMst( fields, names, parent.parent.messageFrame)){
		//alert("exception_type :"+exception_type.value);
		
		if(exception_type.value == "OR"){
			var order_category	= formFld.order_category;
			var order_type		= formFld.order_type_code;
			if((order_category.value =="") && (order_type.value =="")){
				//var msg = getMessage("ATLEAST_ONE_RECORD_ENTERED","common");
				var msg = getMessage("ATLEAST_ONE_EXCEPTION_IDENTIFIER","OR");
				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			}else{

				

				parent.listFrame.location.href="../../eOR/jsp/PrivilegeExceptionGrpList.jsp?exception_type="+exception_type.value+"&order_category="+order_category.value+"&order_type_code="+order_type.value+"&index="+obj+"&grp_exception_id="+grp_exception_id.value+"&mode="+mode;
				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
				grp_exception_id.disabled=true;	
				grp_exception_name.disabled=true;
				order_category.disabled=true;	
				order_type.disabled=true;
				formHdrFld.exception_type.disabled=true;
			}
		}else if(exception_type.value == "OT"){
			parent.listFrame.location.href="../../eOR/jsp/PrivilegeExceptionGrpList.jsp?exception_type="+exception_type.value+"&index="+obj+"&grp_exception_id="+grp_exception_id.value+"&mode="+mode;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			grp_exception_id.disabled=true;	
			grp_exception_name.disabled=true;
			formHdrFld.exception_type.disabled=true;
		}
	}
}


function fillComboOptions(obj){
	var formObjectHeader    = document.forms[0];
	var objName = obj.name;
	var xmlAppend				= ""; 
	var bean_id				= formObjectHeader.bean_id ;
	var order_type_code		= formObjectHeader.order_type_code;
	if(obj.value != ""){
		if(obj.name == "order_category" ){
			if(obj.value == "" ){
				removeOptions(order_type_code ,"OrderType");
				return ;		
			}else{
			OrderCategory = obj.value ;	
			xmlAppend += "order_category"+"=\""+ OrderCategory+"\" " ;
			xmlAppend += "type"+"=\"OrderCategory\"" ;
			}
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr =xmlStr + xmlAppend ;
			xmlStr +=" /></root>" ;
			//alert(xmlStr);
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "PrivilegeExceptionGrpFetchValues.jsp?bean_id="+bean_id.value,false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			//alert(responseText);
			eval(responseText ) ;
		}
	}else{
		OrderCategory = obj.value ;	
		xmlAppend += "order_category"+"=\""+ OrderCategory+"\" " ;
		xmlAppend += "type"+"=\"OrderCategory\"" ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr =xmlStr + xmlAppend ;
		xmlStr +=" /></root>" ;
		//alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PrivilegeExceptionGrpFetchValues.jsp?bean_id="+bean_id.value,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText ) ;
	}
}

function removeOptions(formObject,comboObject,optionName) {
	var len = comboObject.length;
	for(var i=0;i<len;i++){
		if(optionName == "OrderType")
			formObject.forms[0].order_type_code.remove("order_type_code");
	}
	var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt = formObject.createElement("OPTION");
	opt.text = tp ;
	opt.value = "" ;

	if(optionName == "OrderType")
		formObject.forms[0].order_type_code.add(opt);
}
/********/
function addComboObject(comboObjectString,Object){
	var order_type_code				= 	document.forms[0].order_type_id;
	if(Object == "order_category")		  	
		order_type_code.innerHTML = comboObjectString ;
}

function dispModRecords(obj){
	if(obj!="OC"){
		document.forms[0].SelectTab.className="normal";
		document.forms[0].AssociateTab.className="clicked";
		document.forms[0].linkId.className ="";
		if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;
		document.forms[0].linkId.innerHTML = "&nbsp;";
	}
}

function dispLink(obj){

	var checkManFlag = checkMandatory();
	if(checkManFlag){

		var buttonVal			= obj;
		var formObj				= document.forms[0];

		var exception_type		= formObj.exception_type;
		var grp_exception_id	= formObj.grp_exception_id;	
		var	grp_exception_name	= formObj.grp_exception_name; 
		var mode				= formObj.mode.value;
		var order_category		= "";
		var order_type_code		= "";

		if(exception_type.value == "OR"){
			order_category		= formObj.order_category.value; 
			order_type_code		= formObj.order_type_code.value; 
		}
		
		
		if(buttonVal == "S"){
			document.forms[0].SelectTab.className="clicked";
			document.forms[0].AssociateTab.className="normal";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}else if(buttonVal == "A"){
			document.forms[0].SelectTab.className="normal";
			document.forms[0].AssociateTab.className="clicked";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		document.forms[0].tabVal.value = buttonVal;

		if(parent.listFrame.location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
		}
			
		if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;
		
		var queryStr ="tabVal="+buttonVal+"&exception_type="+exception_type.value+"&grp_exception_name="+grp_exception_name.value+"&grp_exception_id="+grp_exception_id.value+"&order_category="+order_category+"&order_type_code="+order_type_code+"&mode="+mode;

		if(buttonVal=="A"){
			document.forms[0].linkId.className ="";
			document.forms[0].linkId.innerHTML = "&nbsp;";
			parent.listFrame.location.href="../../eOR/jsp/PrivilegeExceptionGrpList.jsp?"+queryStr;
			parent.headerFrame.document.formPrivilegeExpGrpHdr.exception_type.disabled=true;		
			grp_exception_id.disabled=true;	
			grp_exception_name.disabled=true;
			if(exception_type == "OR"){
				order_category.disabled=true;			
				order_type_code.disabled=true;	
			}
		}else{
			parent.listFrame.location.href="../../eCommon/html/blank.html";
			document.forms[0].linkId.innerHTML = linkContent;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
}


function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function checkMandatory(){
	var	formHdrObj	= parent.headerFrame.document.getElementById("formPrivilegeExpGrpHdr") ;
	var formDtlObj	= parent.detailFrame.document.getElementById("formPrivilegeExpGrpDtl") ;	
	var	fields = new Array ( formHdrObj.exception_type
							,formDtlObj.grp_exception_id
							,formDtlObj.grp_exception_name
							);

	var	names		=	new	Array (getLabel("eOR.PrivilegeLevel.label","OR")
									  ,getLabel("eOR.GroupID.label","OR")
									  ,getLabel("eOR.GroupName.label","OR")
									  );
	
	var msgFrame = parent.parent.messageFrame;
	if(parent.headerFrame.checkFieldsofMst(	fields,	names, msgFrame)) {
	   return true;
	}
	else
	  return false;
}
//Added by Subhash.Y

function checkIsValidForProceed()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	  return true;
	 else
	  return false;
}

function displayMsg(msg)
{
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
}

function checkAll()
{
	//alert("inside checkAll()");
	var frmObj = f_query_add_mod.listFrame.document.formPrivilegeExpGrpList;
	if(frmObj.select_ynAll.checked)
	{
		//alert("inside if in checkAll");
		frmObj.select_ynAll.value = "Y";
	}
	else
	{
		//alert("inside else in checkAll");
		frmObj.select_ynAll.value = "N";
	}
}
/**
Reference Pattern for Frame's and form Object 
Menu
	|
	PrivilegeExceptionGroup.jsp---->PrivilegeExceptionGrp.js
		|
		+------MstToolBar
		|				Frameobj --- commontoolbarFrame
		|
		+------PrivilegeExceptionGrpMain.jsp
		|		|		FrameObj --- f_query_add_mod
		|		|
		|		+---PrivilegeExceptionGrpHdr.jsp
		|		|		FrameObj --- headerFrame
		|		|		FormObj  --- formPrivilegeExpGrpHdr	
		|		|
		|		+---PrivilegeExceptionGrpDtl.jsp     
		|		|		FrameObj --- detailFrame
		|		|		FormObj	 --- formPrivilegeExpGrpDtl
		|		|	
		|		+---PrivilegeExceptionGrpList.jsp
		|				FrameObj --- listFrame	
		|				FormObj  --- formPrivilegeExpGrpList
		|			
		+------MessageFrame
		|				Frameobj --- messageFrame
		|
**/
