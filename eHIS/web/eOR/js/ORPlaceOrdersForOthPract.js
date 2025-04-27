/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// Global Variables
var linkContent = "";
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;

/*
Function called on click of Create button
*/
function create()
{
	f_query_add_mod.location.href = "../../eOR/jsp/ORPlaceOrdersForOthPractAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
}

/*
Function called on click of Apply button
*/
function apply() 
{
	var message;

	if (! checkIsValidForProceed() )
    {
		message  = getMessage("NOT_VALID","Common");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var formObjHeader	= f_query_add_mod.place_order_pract_header.document.forms[0];
	var allowed_type = formObjHeader.allowed_type.value;
	if(allowed_type=='')
	{
		message  = getMessage("ATLEAST_ONE_ALLOWED_TYPE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false;
	}

	
	var flag = false;
	if(allowed_type=='T')
	{
		flag = true;
	}
	else
	{
		flag = onApplyUpdate();
	}
	if(flag )
	{
		//eval( formApply(f_query_add_mod.place_order_pract_header.document.place_order_pract_header,OR_CONTROLLER) ) ;
		if(allowed_type=='T')
			eval( formApply(f_query_add_mod.place_order_pract_middle.document.place_order_pract_middle,OR_CONTROLLER) ) ;
		else
			eval( formApply(f_query_add_mod.place_order_pract_header.document.place_order_pract_header,OR_CONTROLLER) ) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
		if(resultGlobal)
		{
			onSuccess();
		}
	}
}

function onSuccess()
{
	create();
}


function onApplyUpdate()
{
	var refForm = frames[1].frames[2].document.forms[0];
	if(frames[1].frames[2].location.href.indexOf(".jsp") != -1)
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
			var value = eval(frames[1].frames[2].document.getElementById('select_yn'+i));
			if(!value.disabled)
			{
				if(value.checked)
				{
					val = "Y";
				}else
					val = "N";
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
		xmlStr += " CLASS_NAME=\"PractForConsentBean\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ORPlaceOrdersForOthPractValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
		return true;
	}
	else
	{
		return true;
	}
}


function assignResult(res,msg,mod)
{
	resultGlobal  = res ;
	messageGlobal = msg ;
	flagGlobal    = mod;
	if((messageGlobal=="ATLEAST_ONE_PRACTITIONER"||messageGlobal=="ATLEAST_ONE_PRACTITIONER_TYPE" ||messageGlobal=="ATLEAST_ONE_RESPONSIBILITY")&& resultGlobal==false)
	{
		messageGlobal=getMessage(messageGlobal,"OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		return false;
	}
}

/*
This Function is called on Click of Reset Button
*/
function reset()
{
	if(f_query_add_mod.location.href.indexOf(".jsp") != -1)
	{
		create();
	}
}
/*
This Function is called on change of Allowed type in Header Screen
*/
function loadPage(obj)
{
	objVal = obj.value;
	// if Allowed Type is seleceted, than loading the middle frame
	if(obj.value!='')
	{
		if(obj.value=='T')
		{
			//parent.document.getElementById("main_frame").rows = '4%,87%,*';
			parent.document.getElementById("place_order_pract_header").style.height="4vh";
		parent.document.getElementById("place_order_pract_middle").style.height="80vh";
	parent.	document.getElementById("place_order_pract_bottom").style.height="12vh";
		
		}
		else{
			//alert("practioner");
			//parent.document.getElementById("main_frame").rows = '4%,12%,*';
			parent.document.getElementById("place_order_pract_header").style.height="4vh";
			parent.document.getElementById("place_order_pract_middle").style.height="12vh";
			parent.document.getElementById("place_order_pract_bottom").style.height="80vh";
		}
			parent.place_order_pract_middle.location.href = "../../eOR/jsp/ORPlaceOrdersForOthPractAddModifyMiddle.jsp?mode=1&function_id="+function_id+"&type="+objVal;
			parent.place_order_pract_bottom.location.href = "../../eCommon/html/blank.html";
			
		}
	// else assigning to blank.html
	else
	{
		parent.place_order_pract_middle.location.href = "../../eCommon/html/blank.html";
		parent.place_order_pract_bottom.location.href = "../../eCommon/html/blank.html";
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

/*
This Function is called on click of Select/Associate tabs in Middle frame
and to display the Bottom frame depending on the button selected
*/
function dispLink(obj)
{
	var formObjHeader	= parent.place_order_pract_header.document.forms[0];
	var formObjBottom	= parent.place_order_pract_header.document.forms[0];
	var allowed_type	= formObjHeader.allowed_type.value;
	
	if(allowed_type != "")
	{
		var buttonVal = obj;
		// Setting the class names
		if(buttonVal == "S")
		{
			document.getElementById('SelectTab').className="clicked";
			document.getElementById('AssociateTab').className="normal";
		}
		else if(buttonVal == "A")
		{
			document.getElementById('SelectTab').className="normal";
			document.getElementById('AssociateTab').className="clicked";
		}
		// Making the Header Frame Field disabled
		formObjHeader.allowed_type.disabled = true;

		document.getElementById('tabVal').value = buttonVal;
		if(parent.frames[2].location.href.indexOf(".jsp") != -1)
		{
			var flag = latestUpdate();
		}
		if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;
		if(buttonVal=="A")
		{
			document.getElementById('linkId').className ="";
			document.getElementById('linkId').innerHTML = "&nbsp;";
			parent.frames[2].location.href="../../eOR/jsp/ORPlaceOrdersForOthPractAddModifyBottom.jsp?tabVal="+buttonVal+"&allowed_type="+allowed_type;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		else
		{
			parent.frames[2].location.href="../../eCommon/html/blank.html";
			document.getElementById('linkId').innerHTML = linkContent;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else
	{
		if(allowed_type=='P')
			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.practitioner.label","Common"))));
		else if(allowed_type=='R')
  			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.responsibility.label","Common"))));
		else if(allowed_type=='T')
  			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.practitionertype.label","Common"))));
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
}

/*
Function called on Click of Alphabets in the middle frame to display the bottom frame for the Select Records
*/

function callOnAlphaLink(obj, obj2)
{
	changeAlphaColor(obj2);
	var fldObj1 = parent.place_order_pract_header.document.getElementById('allowed_type');
	if(parent.frames[2].location.href.indexOf(".jsp") != -1)
	{
		var flag = latestUpdate();
	}
	var allowed_type			=	 fldObj1.value;
	if(allowed_type !="")
	{
		parent.place_order_pract_bottom.location.href="../../eOR/jsp/ORPlaceOrdersForOthPractAddModifyBottom.jsp?index="+obj+"&allowed_type="+allowed_type;		
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		parent.place_order_pract_header.document.forms[0].allowed_type.disabled = true;
	}
	else
	{
		parent.place_order_pract_bottom.location.href="../../eCommon/html/blank.html";
		if(allowed_type=='P')
			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.practitioner.label","Common"))));
		else if(allowed_type=='R')
  			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.responsibility.label","Common"))));
		else if(allowed_type=='T')
  			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.practitionertype.label","Common"))));
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
}


function latestUpdate()
{
	var bean_id		= parent.place_order_pract_bottom.document.place_order_pract_bottom.bean_id.value;
	var bean_name	= parent.place_order_pract_bottom.document.place_order_pract_bottom.bean_name.value;
	var fm_disp		= parent.place_order_pract_bottom.document.place_order_pract_bottom.fm_disp.value;
	var to_disp		= parent.place_order_pract_bottom.document.place_order_pract_bottom.to_disp.value;
	var tabVal		= parent.place_order_pract_bottom.document.place_order_pract_bottom.tabVal.value;
	var value_str	= "";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++)
	{
		var value = eval('parent.place_order_pract_bottom.document.place_order_pract_bottom.select_yn'+i);
		if(!value.disabled)
		{
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
	xmlStr += " CLASS_NAME=\"PlaceOrdersForOthPractBean\"";
	xmlStr +=" /></root>";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ORPlaceOrdersForOthPractValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return true;
}


/**********************Check for Valid Operation*******************************/
function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	{
		return true;
	}
	else
	{
		return false;
	}
}

/*
Function called on click of Previous/Next buttons
*/
function checkVal(obj)
{
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}
