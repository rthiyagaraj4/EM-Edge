var linkContent = "";
var MODE_DELETE = '0' ;
var MODE_INSERT = '1' ;
var MODE_MODIFY = '2' ;

function create()
{
	f_query_add_mod.location.href="../../eCA/jsp/CASpltyForConsultOrderMain.jsp?mode="+MODE_INSERT;//+"&function_id="+function_id;
}

function reset()
{
	var formObj = f_query_add_mod.CASpltyForConsultHdr.document.formCASpltyForConsultHdr;

	formObj.order_catalog_desc.disabled = false;
	formObj.service_butoon.disabled = false;
	formObj.group_by.disabled = false;
	formObj.group_by.selectedIndex = 0;
	formObj.order_catalog_desc.value = '';
	formObj.order_catalog.value = '';
	formObj.order_catalog_code.value = '';
	formObj.order_catalog_value.value = '';
	f_query_add_mod.CASpltyForConsultHdr.document.getElementById("spltRow").style.display='none';
	f_query_add_mod.CASpltyForConsultHdr.document.getElementById("orderRow").style='display';
	f_query_add_mod.CASpltyForConsultHdr.document.getElementById("ordercatalogRow").style.display='none';
	f_query_add_mod.CASpltyForConsultHdr.document.getElementById("ordercatalogValue").style.display='none';
	parent.frames[1].frames[1].location.href="../../eCommon/html/blank.html";

	if(linkContent == "")
	{
		linkContent	=	f_query_add_mod.CASpltyForConsultHdr.document.getElementById("linkId").innerHTML;
	}
	f_query_add_mod.CASpltyForConsultHdr.document.getElementById("linkId").innerHTML = linkContent;	
	formObj.order_catalog_desc.focus();
	f_query_add_mod.CASpltyForConsultHdr.document.getElementById("selectTable").style='display';
	f_query_add_mod.CASpltyForConsultHdr.document.getElementById("selectLink").style='display';
}

function checkText(txtVal)
{

	var txt = txtVal.value;

	if(txt != '')
	{
		lookupByGroup();
	}
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
    var gruopBy = document.formCASpltyForConsultHdr.group_by.value;
	var retArray;
	var sql = '';

	
	sql = "SELECT ORDER_CATALOG_CODE CODE, SHORT_DESC DESCRIPTION FROM OR_ORDER_CATALOG WHERE EFF_STATUS='E' AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND ORDER_CATEGORY = 'CN' ORDER BY 2";
	retArray =await callLookupFunction(sql,getLabel("Common.OrderCategory.label","Common"),document.formCASpltyForConsultHdr.order_catalog_value);
	var str =unescape(retArray);
	var arr = str.split(",");
	 
	if(retArray != null && retArray !="")	
	{
		document.formCASpltyForConsultHdr.order_catalog_value.value = arr[1];
		document.formCASpltyForConsultHdr.order_catalog_code.value = arr[0];
	}
	else
	{
		document.formCASpltyForConsultHdr.order_catalog_value.value = '';
		document.formCASpltyForConsultHdr.order_catalog_code.value = '';
	}
}
async function lookupByGroup()
{
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp"
    var gruopBy = document.formCASpltyForConsultHdr.group_by.value;
	var retArray;
	var sql = '';

	if(gruopBy == "S")
	{
		sql = "SELECT SPECIALITY_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_SPECIALITY WHERE EFF_STATUS='E' AND UPPER(SPECIALITY_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 2";
		retArray = await callLookupFunction(sql,getLabel("Common.speciality.label","Common"),document.formCASpltyForConsultHdr.order_catalog_desc);
	}
	else if(gruopBy == "O")
	{
		sql = "SELECT ORDER_CATALOG_CODE CODE, SHORT_DESC DESCRIPTION FROM OR_ORDER_CATALOG WHERE EFF_STATUS='E' AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND ORDER_CATEGORY = 'CN' ORDER BY 2";
		retArray = await callLookupFunction(sql,getLabel("Common.OrderCategory.label","Common"),document.formCASpltyForConsultHdr.order_catalog_desc);
	}
	 
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray !="")	
	{
		document.formCASpltyForConsultHdr.order_catalog_desc.value = arr[1];
		document.formCASpltyForConsultHdr.order_catalog.value = arr[0];
		if(gruopBy=="S")
		{
			lookupValue();
		}
	}
	else
	{
		document.formCASpltyForConsultHdr.order_catalog_desc.value = '';
		document.formCASpltyForConsultHdr.order_catalog.value = '';
	}
}

function CodeArrest() 
{
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) 
	{
        alert("Welcome to eHIS");
    }

}

function displayLabel(obj)
{
	var selVal = obj.value;
	var spltRow = document.getElementById('spltRow');
	var orderRow = document.getElementById('orderRow');
	
	if (selVal == "S")
	{
		spltRow.style='display';
		orderRow.style.display='none';
		ordercatalogRow.style='display';
		ordercatalogValue.style='display';
		selectTable.style.display='none';
		selectLink.style.display='none';
		
	}
	else if (selVal == "O")
	{
		spltRow.style.display='none';
		orderRow.style.style='display';
		ordercatalogRow.style.display='none';
		ordercatalogValue.style.display='none';
		selectTable.style.style='display';
		selectLink.style='display';
	}
	document.formCASpltyForConsultHdr.order_catalog_desc.value = '';
	document.formCASpltyForConsultHdr.order_catalog.value = '';
	document.formCASpltyForConsultHdr.order_catalog_desc.focus();
	//document.formCASpltyForConsultHdr.service_butoon.disabled = false;
	//document.formCASpltyForConsultHdr.order_catalog_desc.disabled = false;
	parent.frames[1].location.href="../../eCommon/html/blank.html";

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

function latestUpdate()
{
	var bean_id		= parent.CASpltyForConsultDtl.document.formCASpltyForConsultDtl.bean_id.value;
	var bean_name	= parent.CASpltyForConsultDtl.document.formCASpltyForConsultDtl.bean_name.value;
	var fm_disp		= parent.CASpltyForConsultDtl.document.formCASpltyForConsultDtl.fm_disp.value;
	var to_disp		= parent.CASpltyForConsultDtl.document.formCASpltyForConsultDtl.to_disp.value;
	var tabVal		= parent.CASpltyForConsultDtl.document.formCASpltyForConsultDtl.tabVal.value;
	var value_str	= "";
	var temp="";
	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++)
	{
		var value = eval('parent.CASpltyForConsultDtl.document.formCASpltyForConsultDtl.select_yn'+i);
		//alert("value="+value.value);
		//alert("value.disabled="+value.disabled);
		//alert("value.checked="+value.checked);
			if(!value.disabled)
			{
				if(value.checked)
				{
					val = "Y";
				}
				else
				{
					val = "N";
				}
			}
			else
			{
				val ="N";
			}
			value_str += val+"~";
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


function callOnAlphaLink(obj, obj2)
{
	changeAlphaColor(obj2);
	var fldObj = document.forms[0].group_by;
	var fldObj1 = document.forms[0].order_catalog;

	if(parent.frames[1].location.href.indexOf(".jsp") != -1)
	{
		var flag = latestUpdate();
	}
	var group_by = fldObj.value;
	var resource_code = fldObj1.value;

	if(group_by !="" && resource_code != "")
	{
		document.formCASpltyForConsultHdr.order_catalog_desc.disabled = true;
		document.formCASpltyForConsultHdr.service_butoon.disabled = true;
		document.formCASpltyForConsultHdr.group_by.disabled = true;
		parent.frames[1].location.href="../../eCA/jsp/CASpltyForConsultOrderDtl.jsp?group_by="+group_by+"&index="+obj+"&tabVal=S&order_catalog="+resource_code;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		//fldObj.disabled=true;
	}
	else
	{
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
			}
			else if (group_by == 'S')
			{
				msg = msg.replace("$","Speciality");
			}					
		}
		document.formCASpltyForConsultHdr.order_catalog_desc.focus();
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;

	}
}
function dispLink(obj)
{
	var group_by	= document.getElementById("group_by").value;
	var resource_code	= document.getElementById("order_catalog").value;
	var msg = "";
	
	if(group_by != "" && resource_code != "")
	{
		document.formCASpltyForConsultHdr.order_catalog_desc.disabled = true;
		document.formCASpltyForConsultHdr.service_butoon.disabled = true;
		document.formCASpltyForConsultHdr.group_by.disabled = true;

		if(group_by == "S")
		{
			document.getElementById("SelectTab").className="clicked";
			document.getElementById("AssociateTab").className="normal";
		}
		else if(group_by == "A")
		{
			document.getElementById("SelectTab").className="normal";
			document.getElementById("AssociateTab").className="clicked";
		}

		if(parent.frames[1].location.href.indexOf(".jsp") != -1)
		{
			var flag = latestUpdate();
		}
		/***/
		if(linkContent=="")
		{
			linkContent	=	document.getElementById("linkId").innerHTML;
		}
		//alert(linkContent);
		
		if(obj=="A")
		{
			document.getElementById("linkId").className ="";
			document.getElementById("linkId").innerHTML = "&nbsp;";
			parent.frames[1].location.href="../../eCA/jsp/CASpltyForConsultOrderDtl.jsp?tabVal="+obj+"&group_by="+group_by+"&order_catalog="+resource_code;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		else
		{
			parent.frames[1].location.href="../../eCommon/html/blank.html";
			document.getElementById("linkId").innerHTML = linkContent;
			//document.forms[0].all.linkId.className ="linkStyle";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else
	{
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
			}
			else if (group_by == 'S')
			{
				msg = msg.replace("$","Speciality");
			}					
		}
		document.formCASpltyForConsultHdr.order_catalog_desc.focus();
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}

}

function apply()
{
	var message;
	if (! checkIsValidForProceed() )
    {
		message  = getMessage("NOT_VALID","CA");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	//var result=true;
	var formObj = f_query_add_mod.CASpltyForConsultHdr.document.formCASpltyForConsultHdr;
	var lableMsg = getLabel("Common.ordercatalog.label","Common");
	//formObj.linkStr.value="";
	if (formObj.group_by.value == "O")
	{
		lableMsg = getLabel("Common.ordercatalog.label","Common");
	}
	/*else if (formObj.group_by.value == "S")
	{
		lableMsg = getLabel("Common.Specialty.label","Common");
	}*/
	if(formObj.group_by.value == "S")
	{
		var fields = new Array (formObj.group_by,formObj.order_catalog_desc,formObj.order_catalog_value);
		var names = new Array (getLabel("Common.groupby.label","Common"),getLabel("Common.Specialty.label","Common"),getLabel("Common.ordercatalog.label","Common"));
	}
	else
	{
		var fields = new Array (formObj.group_by,formObj.order_catalog_desc);
		var names = new Array (getLabel("Common.groupby.label","Common"),lableMsg);
	}
	if(checkFieldsofMst( fields, names, messageFrame))
	{
		if(formObj.group_by.value == "S")
		{
			f_query_add_mod.CASpltyForConsultHdr.document.formCASpltyForConsultHdr.action='../../servlet/eCA.CAConsultationServlet';
			f_query_add_mod.CASpltyForConsultHdr.document.formCASpltyForConsultHdr.target='messageFrame';
			f_query_add_mod.CASpltyForConsultHdr.document.formCASpltyForConsultHdr.method='post';		
			f_query_add_mod.CASpltyForConsultHdr.document.formCASpltyForConsultHdr.submit();
		}
		else
		{
			var flag = onApplyUpdate();	
			if(flag )
			{
				//alert( formApply(f_query_add_mod.headerFrame.document.formIndexOrCatalogHdr));
				//alert("Hi");
				 f_query_add_mod.CASpltyForConsultDtl.document.formCASpltyForConsultDtl.action='../../servlet/eCA.CAConsultationServlet';
				 f_query_add_mod.CASpltyForConsultDtl.document.formCASpltyForConsultDtl.target='messageFrame';
				 f_query_add_mod.CASpltyForConsultDtl.document.formCASpltyForConsultDtl.method='post';		
				 f_query_add_mod.CASpltyForConsultDtl.document.formCASpltyForConsultDtl.submit();					
				/*	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
				if(resultGlobal){*/
					onSuccess();
			}
		}
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

function onApplyUpdate()
{
	var refForm = f_query_add_mod.CASpltyForConsultDtl.document.formCASpltyForConsultDtl;
	
	var temp="";
	if(f_query_add_mod.CASpltyForConsultDtl.document.formCASpltyForConsultDtl)
	{

		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);

		for(i=fm_disp; i<=to_disp; i++)
		{
			var value =f_query_add_mod.CASpltyForConsultDtl.document.getElementById('select_yn'+i);
			if(!value.disabled)
			{
				if(value.checked)
				{
					val = "Y";
					//**chk_Valflag=true;
				}
				else
				{
					val = "N";
				}
			}
			else
			{
				val ="N";
			}
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

function onSuccess()
{
	/*f_query_add_mod.CASpltyForConsultHdr.location.href="../../eCA/jsp/CASpltyForConsultOrderHdr.jsp?mode="+MODE_INSERT;
	f_query_add_mod.location.href="../../eCommon/html/blank.html";*/
	f_query_add_mod.location.reload();
}
function lookupValue()
{
		var temp="";
		var called_from="create";
		var splty_code=document.formCASpltyForConsultHdr.order_catalog.value;
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
		//xmlHttp.send(xmlDoc);
		xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
}
function CatalogValues(code,description)
{
	document.formCASpltyForConsultHdr.order_catalog_code.value=code;
	document.formCASpltyForConsultHdr.order_catalog_value.value=description;
}

function checkVal(obj){
	document.forms[0].dispMode.value = obj;		
	document.forms[0].submit();
}
