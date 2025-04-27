/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function opdCriteria()
{
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	var funcSel = document.getElementById('ssDPFunc').value;
	if(funcSel == "") return false;
	var url = '../../eXB/jsp/ssMonOPDCriteria.jsp';
	var arguments = new Array();
	var dialogTop = "350";
	var dialogHeight = "7" ;
	var dialogLeft = "400" ;
	var dialogWidth  = "30" ;	
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	var opdData = window.showModalDialog(url,arguments,features);
	if(opdData == null)
	{
		initFunc();
		return false;
	}
	document.getElementById("opdDate").value = opdData.opdDate;
	document.getElementById("custCode").value = opdData.custCode;	

	if(funcSel == "OPD")
	{
	//	var gatewayServerID = getGatewayServerID(document.getElementById('protocolLinkID').value, "Generate MDB File");		
		var gatewayServerID = "TEMP";
		if(gatewayServerID == null || gatewayServerID == "") 
		{
			alert("Gateway Server is not selected, Unable to procees...");
			initFunc();
			return false;
		}
		else
		{
			document.getElementById('gatewayServerID').value = gatewayServerID;
			document.forms[0].action = '../../servlet/eXB.SSMonDPServlet';
			document.forms[0].submit();
		}
	}
	else if(funcSel == "IPD")
	{
		document.getElementById('p_report_id').value = 'XBSSIPDRPT_SKR';
		document.getElementById('P_CUST_CODE_ONE').value = document.getElementById("custCode").value;
		document.getElementById('P_PERIOD').value = document.getElementById("opdDate").value;
		document.dummyForm.action = '../../eCommon/jsp/report_options.jsp';
		document.dummyForm.submit();
	}
}

function run() 
{
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	var funcSelected = f_query_add_mod.document.getElementById('ssDPFunc').value;
	var locale = f_query_add_mod.document.getElementById('locale').value;
	
	if(funcSelected == "")
	{		
		var msg = getMessage('CAN_NOT_BE_BLANK','common');
		msg = msg.replace('$', getLabel("Common.Function.label",'COMMON'));
		alert(msg);
		f_query_add_mod.document.getElementById('ssDPFunc').focus();
		return false;
	}
	else if(funcSelected == "OPD")
	{
		f_query_add_mod.document.forms[0].action = '../../servlet/eXB.SSMonDPServlet';
		f_query_add_mod.document.forms[0].submit();
	}
	else if(funcSelected == "IPD")
	{
		f_query_add_mod.document.getElementById('p_report_id').value = 'XBSSIPDRPT_SKR';
		f_query_add_mod.document.getElementById('P_CUST_CODE_ONE').value = f_query_add_mod.document.getElementById("custCode").value;
		f_query_add_mod.document.getElementById('P_PERIOD').value = f_query_add_mod.document.getElementById("opdDate").value;
		f_query_add_mod.document.dummyForm.action = '../../eCommon/jsp/report_options.jsp';
		f_query_add_mod.document.dummyForm.submit();
	}
}

function opdDataProcess()
{
	var opdDate = document.getElementById("opdDate").value;
	if(opdDate == "")
	{
		var message = getMessage('CAN_NOT_BE_BLANK','common');
		message = message.replace('$', getLabel('eXH.OP_Mon_Year.Label','XH'));
		alert(message);
		document.getElementById('opdDate').focus();
		return false;
	}

	var payer1 = document.getElementById("payer1").value;
	var payer2 = document.getElementById("payer2").value;
	var payer3 = document.getElementById("payer3").value;
	var custCode = "";

	if(payer1 != "null" && payer1 != null && payer1 != "") custCode = custCode + payer1;
	if(payer2 != "null" && payer2 != null && payer2 != "") 
	{
		if(custCode == "") custCode = custCode + payer2;
		else custCode = custCode + "|" + payer2;
	}
	if(payer3 != "null" && payer3 != null && payer3 != "") 
	{
		if(custCode == "") custCode = custCode + payer3;
		else custCode = custCode + "|" + payer3;
	}

	if(custCode == "")
	{
		var message = getMessage('CAN_NOT_BE_BLANK','common');
		message = message.replace('$', getLabel("eXH.PAYER_CODE.Label",'XH'));
		alert(message);
		document.getElementById('payer1Desc').focus();
		return false;
	}

	var retObj = new Object();
	retObj.opdDate = opdDate;
	retObj.custCode = custCode	
	window.close();
	window.returnValue = retObj;
}

function payerSearch(objDesc, objID)
{
	var locale = document.getElementById("locale").value;
	var facilityID = document.getElementById("facilityID").value;
	var excludePayerList = "";
	var excludePayerFlag = false;	
	
	var retVal = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit = getLabel("eXH.PAYER_CODE.Label",'XH');
	var target = objDesc;
	var id = objID;

	excludePayerList = getExcludePayerList(id);

	sql = "select A.cust_code code, b.long_name description from BL_CUST_BY_CUST_GROUP  A, ar_customer_lang_vw B "
			+"where A.cust_code = b.cust_code and b.language_id = '"+locale+"' and "
			+"A.cust_group_code in (select DEF_SS_CUST_GROUP_CODE from XF_SS_PRIV_DEFAULT_VALUES where rownum = 1) and "
			+"a.acc_entity_code in (select acc_entity_code from sy_acc_entity where acc_entity_id='"+facilityID+"')"
			+" AND UPPER(A.cust_code) LIKE UPPER(?) AND UPPER(b.long_name) LIKE UPPER(?)";

	if(excludePayerList != "") sql = sql + " AND A.cust_code NOT IN ("+excludePayerList+")"

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = "2"  ;
	argumentArray[7] = "DESC_CODE" ;
 
	retVal = await CommonLookup( tit, argumentArray );			
	
	var ret1 = unescape(retVal);
	arr = ret1.split(",");
	id.value = arr[0];
	
	if(arr[1] == undefined)	target.value = "";
	else target.value = arr[1];          
}

function getExcludePayerList(id)
{
	var excludePayerFlag = false;
	var excludePayerList = "";

	if(id.name == "payer1")
	{
		if(document.getElementById("payer2").value != "") 
		{
			excludePayerList = "'" + document.getElementById("payer2").value + "'";
			excludePayerFlag = true;
		}
		if(document.getElementById("payer3").value != "") 
		{
			if(excludePayerFlag) excludePayerList = excludePayerList + ",";
			excludePayerList = excludePayerList + "'" + document.getElementById("payer3").value + "'";			
		}
	}
	else if(id.name == "payer2")
	{
		if(document.getElementById("payer1").value != "") 
		{
			excludePayerList = "'" + document.getElementById("payer1").value + "'";
			excludePayerFlag = true;
		}
		if(document.getElementById("payer3").value != "") 
		{
			if(excludePayerFlag) excludePayerList = excludePayerList + ",";
			excludePayerList = excludePayerList +  "'" + document.getElementById("payer3").value + "'";			
		}
	}
	else if(id.name == "payer3")
	{
		if(document.getElementById("payer1").value != "") 
		{
			excludePayerList =  "'" + document.getElementById("payer1").value + "'";
			excludePayerFlag = true;
		}
		if(document.getElementById("payer2").value != "") 
		{
			if(excludePayerFlag) excludePayerList = excludePayerList + ",";
			excludePayerList = excludePayerList + "'" + document.getElementById("payer2").value + "'";			
		}
	}
	return excludePayerList;
}

function reset()
{	
	f_query_add_mod.document.forms[0].reset();
}

function initFunc()
{
	parent.messageFrame.location.href="../../eXH/jsp/DisplayRefResult.jsp?message="+document.getElementById("resultMessage").value;
	document.getElementById("resultMessage").value = "";
	document.getElementById('ssDPFunc').selectedIndex = 0;
	document.getElementById('ssDPFunc').focus();
}
