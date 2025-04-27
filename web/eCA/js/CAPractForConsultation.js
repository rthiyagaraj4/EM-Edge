var linkContent = "";
var MODE_DELETE = '0' ;
var MODE_INSERT = '1' ;
var MODE_MODIFY = '2' ;

function create()
{
	f_query_add_mod.location.href="../../eCA/jsp/CAPractForConsultOrderMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}

function apply(){
	var message;
	if (! checkIsValidForProceed() )
    {
		message  = getMessage("NOT_VALID","CA");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	//var result=true;
	var formObj = f_query_add_mod.CAPractForConsultHdr.document.formPractForConsultOrderHdr;
	var lableMsg = getLabel("Common.ordercatalog.label","Common");
	//formObj.linkStr.value="";
	if (formObj.group_by.value == "O")
	{
		lableMsg = getLabel("Common.ordercatalog.label","Common");
	}else if (formObj.group_by.value == "P")
	{
		lableMsg = getLabel("Common.practitioner.label","Common");
	}
	if(formObj.group_by.value == "P")
	{
		var fields = new Array (formObj.group_by,formObj.order_catalog_desc,formObj.order_catalog_value);
		var names = new Array (getLabel("Common.groupby.label","Common"),lableMsg,getLabel("Common.ordercatalog.label","Common"));
	}
	else
	{
		var fields = new Array (formObj.group_by,formObj.order_catalog_desc);
		var names = new Array (getLabel("Common.groupby.label","Common"),lableMsg);
	}
	if(checkFieldsofMst( fields, names, messageFrame)){
		if(formObj.group_by.value == "P")
		{
			 f_query_add_mod.CAPractForConsultHdr.document.formPractForConsultOrderHdr.action='../../servlet/eCA.CAConsultationServlet';
			 f_query_add_mod.CAPractForConsultHdr.document.formPractForConsultOrderHdr.target='messageFrame';
			 f_query_add_mod.CAPractForConsultHdr.document.formPractForConsultOrderHdr.method='post';		
			 f_query_add_mod.CAPractForConsultHdr.document.formPractForConsultOrderHdr.submit();
		}
		else
		{
		var flag = onApplyUpdate();	
		if(flag ){
			//alert( formApply(f_query_add_mod.headerFrame.document.formIndexOrCatalogHdr));
			//alert("Hi");
			 f_query_add_mod.CAPractForConsultDtl.document.formPractConsultCatDtl.action='../../servlet/eCA.CAConsultationServlet';
		     f_query_add_mod.CAPractForConsultDtl.document.formPractConsultCatDtl.target='messageFrame';
		     f_query_add_mod.CAPractForConsultDtl.document.formPractConsultCatDtl.method='post';		
		     f_query_add_mod.CAPractForConsultDtl.document.formPractConsultCatDtl.submit();					
			/*	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
			if(resultGlobal){
				onSuccess();
			}   */
		}		
	}
}
}
function  fnDisplaySelectedRow(obj){

	var selVal = obj.value;

	if (selVal == "O")
	{
		document.getElementById("catalog_row").style='display';
		document.getElementById("pract_row").style.display='none';
		document.getElementById("ordercatalogRow").style.display='none';
		document.getElementById("ordercatalogValue").style.display='none';
		document.getElementById("selectTable").style='display';
		document.getElementById("linkId").style='display';
	}else if (selVal == "P")
	{
		document.getElementById("catalog_row").style.display='none';
		document.getElementById("pract_row").style='display';
		document.getElementById("ordercatalogRow").style='display';
		document.getElementById("ordercatalogValue").style='display';
		document.getElementById("selectTable").style.display='none';
		document.getElementById("linkId").style.display='none';
	}
	document.formPractForConsultOrderHdr.order_catalog.value = '';
	document.formPractForConsultOrderHdr.order_catalog_desc.value = '';

}

async function fnLookupByGroup()
{
    var gruopBy = document.getElementById('group_by');
    var locale = document.formPractForConsultOrderHdr.locale.value;
	var index = gruopBy.selectedIndex;
	var groupByValue = gruopBy.options[index].value;
	var sql = '';
	var title = "";
	var target =document.formPractForConsultOrderHdr.order_catalog_desc;
	if(groupByValue == "P")
	{
		sql = "Select PRACTITIONER_ID code, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1') description from AM_PRACTITIONER where eff_status='E' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?) order by 2";
		title = getLabel("Common.practitioner.label","Common");
	//	target = document.formPractForConsultOrderHdr.practitioner_name;
	}
	else if(groupByValue == "O")
	{
		sql = "SELECT ORDER_CATALOG_CODE CODE, SHORT_DESC DESCRIPTION FROM OR_ORDER_CATALOG WHERE EFF_STATUS='E' AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND ORDER_CATEGORY = 'CN' ORDER BY 2";
		title = getLabel("Common.ordercatalog.label","Common");		
	}
	var retArray = await callLookupFunction(sql,title,target);
	var str =unescape(retArray);
	var arr = str.split(",");
	if (retArray != null && retArray != "")
	{	
	/*	if (groupByValue == "P")
		{
			document.formPractForConsultOrderHdr.practitioner_id.value = retArray[0];
			document.formPractForConsultOrderHdr.practitioner_name.value = retArray[1];
		}else if (groupByValue == "O")
		{*/
			document.formPractForConsultOrderHdr.order_catalog.value = arr[0];
			document.formPractForConsultOrderHdr.order_catalog_desc.value = arr[1];
		//}
		if(groupByValue=="P")
		{
			lookupValue();
		}
	}else{
		/*if (groupByValue == "P")
		{
			document.formPractForConsultOrderHdr.practitioner_id.value = '';
			document.formPractForConsultOrderHdr.practitioner_name.value = '';
		}else if (groupByValue == "O")
		{*/
			document.formPractForConsultOrderHdr.order_catalog.value = '';
			document.formPractForConsultOrderHdr.order_catalog_desc.value = '';
		//}
	}	
}

function checkText(txtVal)
{
	var txt = txtVal.value;
 
	if(txt !='')
	{
		fnLookupByGroup();
	}
}
async function callLookupFunction(sql,title,target)
{	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal = await CommonLookup( title, argArray );

	return retVal;
}

function callOnAlphaLink(obj, obj2){
	changeAlphaColor(obj2);
	var fldObj = document.forms[0].group_by;
	var fldObj1 = document.forms[0].order_catalog;
	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
	}
	var group_by = fldObj.value;
	var resource_code = fldObj1.value;
	if(group_by !="" && resource_code != ""){
		parent.CAPractForConsultDtl.location.href="../../eCA/jsp/CAPractForConsultOrderDtl.jsp?group_by="+group_by+"&index="+obj+"&tabVal=S&order_catalog="+resource_code;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		//fldObj.disabled=true;
		document.forms[0].group_by.disabled=true;
		document.forms[0].order_catalog_desc.disabled=true;
		document.forms[0].order_catalog_butoon.disabled=true;
	}
	else{
		parent.CAPractForConsultDtl.location.href="../../eCommon/html/blank.html";
		var msg = ""; 
		if (group_by == "")
		{
			msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
			msg = msg.replace("$","Group By");
		}
		if (resource_code == "")
		{
			msg +=getMessage("CAN_NOT_BE_BLANK","COMMON");
			if (group_by == "O")
			{
				msg = msg.replace("$","Order Catalog");
			}else if (group_by == 'P')
			{
				msg = msg.replace("$","Practitioner");
			}					
		}
		
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;

	}
}

function latestUpdate(){

	//alert(parent.detailFrame.document.formIndexOrderCatalogDtl.name);

	var bean_id		= parent.CAPractForConsultDtl.document.formPractConsultCatDtl.bean_id.value;
	var bean_name	= parent.CAPractForConsultDtl.document.formPractConsultCatDtl.bean_name.value;
	var fm_disp		= parent.CAPractForConsultDtl.document.formPractConsultCatDtl.fm_disp.value;
	var to_disp		= parent.CAPractForConsultDtl.document.formPractConsultCatDtl.to_disp.value;
	var tabVal		= parent.CAPractForConsultDtl.document.formPractConsultCatDtl.tabVal.value;
	var value_str	= "";
	var temp="";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++){
		var value = eval('parent.CAPractForConsultDtl.document.formPractConsultCatDtl.select_yn'+i);
		//alert("value="+value);
		//alert("value.disabled="+value.disabled);
		//alert("value.checked="+value.checked);
		if((value!="") || (value!=null) || (value!=undefined))
		{
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
		}
		//alert("value_str="+value_str);
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CALLED_FROM=\""+temp+"\" ";
		xmlStr += " SPECIALITY_CODE=\""+temp+"\" ";
		xmlStr += " CLASS_NAME=\"CAConsultationBean\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CAConsultOrderCatalogValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert( responseText ) ;
		return true;
	}
function checkVal(obj){
	document.querySelectorAll('input[type="checkbox"][id^="select_yn"]').forEach(checkbox => {
		if (!checkbox.checked) {
			// Create a hidden input with the same name and value="N"
			const hiddenInput = document.createElement('input');
			hiddenInput.type = 'hidden';
			hiddenInput.name = checkbox.name;
			hiddenInput.value = checkbox.disabled ? "A" : "N";
			document.forms[0].appendChild(hiddenInput);
		}
	});
	console.log(obj);
	console.log(document.forms[0].dispMode.value);
	console.log();
	document.forms[0].dispMode.value = obj;		
	document.forms[0].submit();
}

function dispLink(obj)
{
	var group_by	= document.getElementById("group_by").value;
	var resource_code	= document.getElementById("order_catalog").value;
	var msg = "";
		
	if(group_by != "" && resource_code != ""){
		var buttonVal = obj;
		if(buttonVal == "S"){
			document.getElementById("SelectTab").className="clicked";
			document.getElementById("AssociateTab").className="normal";
		}else if(buttonVal == "A"){
			document.getElementById("SelectTab").className="normal";
			document.getElementById("AssociateTab").className="clicked";
		}
		var formObjAddMod = document.forms[0];
		//alert("formObjAddMod="+formObjAddMod.name);
		formObjAddMod.group_by.disabled=true;
		formObjAddMod.order_catalog_desc.disabled=true;
		formObjAddMod.order_catalog_butoon.disabled=true;
		document.getElementById("tabVal").value = buttonVal;


		if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
		}

		/***/
		if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;
//alert(linkContent);
		if(buttonVal=="A"){
			document.getElementById("linkId").className ="";
			document.getElementById("linkId").innerHTML = "&nbsp;";
		parent.frames[1].location.href="../../eCA/jsp/CAPractForConsultOrderDtl.jsp?tabVal="+buttonVal+"&group_by="+group_by+"&order_catalog="+resource_code;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}else{
			parent.frames[1].location.href="../../eCommon/html/blank.html";
			document.getElementById("linkId").innerHTML = linkContent;
			//document.forms[0].all.linkId.className ="linkStyle";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else{
		if (group_by == "")
		{
			msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
			msg = msg.replace("$","Group By");
		}
		if (resource_code == "")
		{
			msg +=getMessage("CAN_NOT_BE_BLANK","COMMON");
			if (group_by == "O")
			{
				msg = msg.replace("$","Order Catalog");
			}else if (group_by == 'P')
			{
				msg = msg.replace("$","Practitioner");
			}					
		}
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}

}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
	/*	url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;*/

return true;
}

function onApplyUpdate(){
	var refForm =f_query_add_mod.CAPractForConsultDtl.document.formPractConsultCatDtl;
	//var refForm =document.frames[1].frames[1].document.forms[0];
	if(f_query_add_mod.CAPractForConsultDtl.document.formPractConsultCatDtl){

		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";
		var temp="";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);

		for(i=fm_disp; i<=to_disp; i++){
			var value = eval('f_query_add_mod.CAPractForConsultDtl.document.formPractConsultCatDtl.select_yn'+i);
			if(!value.disabled){
				if(value.checked){
					val = "Y";
					//**chk_Valflag=true;
				}else
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
		xmlStr += " CALLED_FROM=\""+temp+"\" ";
		xmlStr += " SPECIALITY_CODE=\""+temp+"\" ";
		xmlStr += " CLASS_NAME=\"CAConsultationBean\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CAConsultOrderCatalogValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert( responseText ) ;
		return true;
	}
	else
	{
		return false;
	}

}

function onSuccess(){
	/*document.frames[1].frames[0].location.href="../../eCA/jsp/CAPractForConsultOrderHdr.jsp?mode="+MODE_INSERT;
	document.frames[1].frames[1].location.href="../../eCommon/html/blank.html";*/
	f_query_add_mod.location.reload();
	
}
function checkTexts(txtVal)
{

	var txt = txtVal.value;

	if(txt != '')
	{
		lookupByGroups();
	}
}

async function lookupByGroups()
{
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp"
    var gruopBy = document.formPractForConsultOrderHdr.group_by.value;
	var retArray;
	var sql = '';

	
	sql = "SELECT ORDER_CATALOG_CODE CODE, SHORT_DESC DESCRIPTION FROM OR_ORDER_CATALOG WHERE EFF_STATUS='E' AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND ORDER_CATEGORY = 'CN' ORDER BY 2";
	retArray =await callLookupFunction(sql,getLabel("Common.OrderCategory.label","Common"),document.formPractForConsultOrderHdr.order_catalog_value);
	var str =unescape(retArray);
	var arr = str.split(",");
	 
	if(retArray != null && retArray !="")	
	{
		document.formPractForConsultOrderHdr.order_catalog_value.value = arr[1];
		document.formPractForConsultOrderHdr.order_catalog_code.value = arr[0];
	}
	else
	{
		document.formPractForConsultOrderHdr.order_catalog_value.value = '';
		document.formPractForConsultOrderHdr.order_catalog_code.value = '';
	}
}
function lookupValue()
{
		var temp="";
		var called_from="practcreate";
		var splty_code=document.formPractForConsultOrderHdr.order_catalog.value;
		var bean_id=document.getElementById("bean_id").value;
		var bean_name=document.getElementById("bean_name").value;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+temp+"\" ";
		xmlStr += " FROM_VALUE=\""+temp+"\" ";
		xmlStr += " TO_VALUE=\""+temp+"\" ";
		xmlStr += " BEAN_ID=\""+bean_id+"\" ";
		xmlStr += " BEAN_NAME=\""+bean_name+"\" ";
		xmlStr += " TAB_VALUE=\""+temp+"\" ";
		xmlStr += " CALLED_FROM=\""+called_from+"\" ";
		xmlStr += " SPECIALITY_CODE=\""+splty_code+"\" ";
		xmlStr += " CLASS_NAME=\"CAConsultationBean\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/CAConsultOrderCatalogValidate.jsp", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
}
function practCatalogValues(code,description)
{
	document.formPractForConsultOrderHdr.order_catalog_code.value=code;
	document.formPractForConsultOrderHdr.order_catalog_value.value=description;
}
function reset()
{
	var formObj = f_query_add_mod.CAPractForConsultHdr.document.formPractForConsultOrderHdr;

	formObj.order_catalog_desc.disabled = false;
	formObj.order_catalog_butoon.disabled = false;
	formObj.group_by.disabled = false;
	formObj.group_by.selectedIndex = 0;
	formObj.order_catalog_desc.value = '';
	formObj.order_catalog.value = '';
	formObj.order_catalog_code.value = '';
	formObj.order_catalog_value.value = '';
	f_query_add_mod.CAPractForConsultHdr.document.getElementById("pract_row").style.display='none';
	f_query_add_mod.CAPractForConsultHdr.document.getElementById("catalog_row").style='display';
	f_query_add_mod.CAPractForConsultHdr.document.getElementById("ordercatalogRow").style.display='none';
	f_query_add_mod.CAPractForConsultHdr.document.getElementById("ordercatalogValue").style.display='none';
	f_query_add_mod.CAPractForConsultDtl.location.href="../../eCommon/html/blank.html";
	
	if(linkContent == "")
	{
		linkContent	=	f_query_add_mod.CAPractForConsultHdr.document.getElementById("linkId").innerHTML;
	}
	f_query_add_mod.CAPractForConsultHdr.document.getElementById("linkId").innerHTML = linkContent;	
	formObj.order_catalog_desc.focus();
	f_query_add_mod.CAPractForConsultHdr.document.getElementById("selectTable").style='display';
	f_query_add_mod.CAPractForConsultHdr.document.getElementById("linkId").style='display';
	document.f_query_add_mod.location.reload();
}
