function apply()
{
	schemaBrowserResultFrame.document.forms[0].action="../../servlet/eXH.SchemaBrowserRecordServlet";	
	schemaBrowserResultFrame.document.forms[0].action_type.value='R';
	schemaBrowserResultFrame.document.forms[0].target='messageFrame'
	schemaBrowserResultFrame.document.forms[0].submit();
	window.commontoolbarFrame.document.location.reload();
}

function searchResult()
{
	var frmObj	= document.OrderableSearch;

	if(frmObj.search_by[0].checked)
	{
		search_by="D";
	}
	else
	{
		search_by="C";
	}

	description_code = frmObj.search_criteria.value
	search_text = frmObj.search_text.value;
	var called_from = frmObj.called_from.value;   
	columname = frmObj.columname.value;	   
	parent.refusal_resultframe1.location.href = "../../eXH/jsp/SchemaBrowserLookupResult.jsp?&search_by="+search_by+"&description_code="+description_code+"&search_text="+encodeURIComponent(search_text)+"&called_from="+called_from+"&columname="+columname+'&tablename='+document.forms[0].tablename.value; 
}

function isAfterCurrDate(obj,changable)
{
	document.getElementById(changable).value = "Y";   
	var date = obj.value;
	var locale = document.getElementById("locale").value;	

	if(isValidDate(obj) && date.length > 0 )
	{
		if(!isBeforeNow(date,'DMY',locale))
		{
			alert(getMessage("XH1010",'XH'));
			obj.value = "";
			obj.focus();
			return false;							   
		}
		else
		{													    

		}
	}
}

function isValidDate(obj)
{	
	var date = obj.value;
	var locale = document.getElementById("locale").value;

	if(date.length > 0 )
	{
		if(!validDate(date,'DMY',locale))
		{
			var msg = getMessage("INVALID_VALUE",'COMMON');
			msg = msg.replace('#','Date Format');
			alert(msg);

			obj.value = "";
			obj.focus();
			return false;
		}
		else
		{
			return true;
		}
	}
}

function initFunc()
{	
	parent.commontoolbarFrame.location.reload();
	parent.messageFrame.location.href = "../../eXH/jsp/DisplayRefResult.jsp?message="+document.getElementById("resultMessage").value;
}

function compareDates()
{
	locale = document.getElementById("locale").value;
	msg_dt1 = document.forms[0].msg_dt1.value;
	msg_dt2 = document.forms[0].msg_dt2.value;

	if(msg_dt1.length > 0 && msg_dt2.length > 0)
	{
		if(!isBefore(msg_dt1,msg_dt2,'DMY',locale))
		{
			alert(getMessage("XH1009",'XH'));
			return false;
		}
		else
		{
			return true;
		}
	}
	else
	{
		return true;
	}
}

async function searchDomainTables()
{
	var searchCriteriaTab = document.getElementById('searchCriteriaTab');
	var rowCount = searchCriteriaTab.rows.length;
	if(rowCount > 0)
	{
		searchCriteriaTab.deleteRow(0);
	}

	var dialogHeight= "26.5" ;
	var dialogWidth	= "35" ;
	var dialogTop = "210" ;
	var center = "1" ;
	var status = "no";
	var features  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "" ;

	domainID = document.getElementById("interfaceDomain").options[document.getElementById("interfaceDomain").selectedIndex].value;
	
	retVal =await window.showModalDialog("../../eXI/jsp/MonitorItemsTblSrch.jsp?domainID="+domainID,arguments,features);
	if (retVal != '' && retVal != undefined)
	{
		document.getElementById("tableName").value = retVal;
		getIndexCol(retVal);
	}	
}

function exportData()
{
	document.getElementById("operation").value = "E";
	getTblColsAndData();
}

function displayData()
{
	document.getElementById("operation").value = "D";	
	getTblColsAndData();
}

function getTblColsAndData()
{
	parent.schemaBrowserResultFrame.document.location.href = '../../eCommon/html/blank.html';
	parent.messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp';	

	var operation = document.getElementById("operation").value;	

	if(parent.schemaBrowserQueryFrame != null)
	{
		document.getElementById("queueType").value = parent.schemaBrowserQueryFrame.document.forms[0].queueType.value;
	}
	
	if(operation == "D")
	{
		this.document.forms[0].action = '../../eXI/jsp/MonitorItemsPopulateRecords.jsp';
		this.document.forms[0].target = 'schemaBrowserResultFrame';		
		this.document.forms[0].submit();
	//	parent.schemaBrowserResultFrame.document.location.href = '../../eXI/jsp/MonitorItemsPopulateRecords.jsp?interfaceDomain='+document.forms[0].interfaceDomain.value+'&tableName='+document.forms[0].tableName.value + url;
	}
	else if(operation == "E")
	{
		document.forms[0].action = '../../servlet/eXI.MonitorItemsExcelServlet';
		this.document.forms[0].target = 'schemaBrowserResultFrame';	
		document.forms[0].submit();
	//	parent.schemaBrowserResultFrame.document.location.href = '../servlet/eXI.MonitorItemsExportServlet?interfaceDomain='+document.forms[0].interfaceDomain.value+'&tableName='+document.forms[0].tableName.value + url;
	}	
}

function getExcelBook()
{	
	this.document.forms[0].method='Post';
	this.document.forms[0].action='../../servlet/eXH.SchemaBrowserServlet';
 	this.document.forms[0].target = 'schemaBrowserQueryFrame';
	this.document.forms[0].submit();
}

function getIndexCol(tableName)
{		
	var query = "SELECT column_name FROM all_ind_columns WHERE TABLE_OWNER = 'XI_INT' and table_name = '"+ tableName +"'";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = "<root><SEARCH ";	
	xmlStr += " query=\""+query+"\"";
	xmlStr += " function=\"SCHEMA_TAB_IND_COL\"";
	xmlStr += " /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AjaxUtil.jsp",false);	
	xmlHttp.send(xmlDoc);
	addRow(xmlHttp.responseText);
}

function addRow(indColList)
{	
	document.getElementById('staticFieldTab').style.display = 'block';
	var table = document.getElementById('searchCriteriaTab');	
	indColList = trimStr(indColList);	
 
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);

	var indCol = indColList.split('|');
	var colSize = indCol.length;
	var colSize = indCol.length;

	var cell1 = new Array();

	for (i = 0; i < colSize; i++)
	{
		cell1[i] = row.insertCell(i);
		cell1[i].innerHTML = indCol[i] + ' ';
		var element = document.createElement("input");
		element.setAttribute("type", "text");
		element.setAttribute("name", indCol[i]);		
		cell1[i].appendChild(element);
		cell1[i].className = 'LABEL';
	} 
}

function trimStr(str) 
{
    return str.replace(/^\s*/, "").replace(/\s*$/, "");
}

function searchMonItemsFunc(target)
{
	var sql = "";			
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var tit = $("#interfaceDomain :selected").text();
	var domainID = document.getElementById("interfaceDomain").options[document.getElementById("interfaceDomain").selectedIndex].value;

	sql = "SELECT DISTINCT func_id code,func_name description FROM xh_schema_brwsr_func WHERE upper(func_id) like upper(?) and upper(func_name) like upper(?) and module_id = UPPER('"+domainID+"') order by upper(func_name)";

	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1 = unescape(retVal);
		arr = ret1.split(",");		
		target.value = arr[1];
	//	target_id.value = arr[0];
	//	clearValues();
		document.forms[0].funcID.value = arr[0];

		parent.schemaBrowserResultFrame.document.location.href = '../../eCommon/html/blank.html';
		this.document.forms[0].action = '../../eXI/jsp/MonitorItemsMoreCriteria.jsp';
		this.document.forms[0].target = 'monitorItemsMoreCriteria';		
		this.document.forms[0].submit();
	}
	else target.value = "";
}

function moduleChange()
{
	clearFrames();
	document.getElementById('functionName').value = '';
	document.getElementById('funcID').value = '';
}

function clearFrames()
{
	parent.monitorItemsMoreCriteria.document.location.href = '../../eCommon/html/blank.html';
	parent.schemaBrowserResultFrame.document.location.href = '../../eCommon/html/blank.html';
}

function buildMenu(transNo)
{	
	var linkset = new Array();
	var reloadLabel = getLabel("eXH.Reload.Label","xh");
	var reloadLink = '<a href="#" onClick='+'\''+'messageReload("'+transNo+'");'+'\''+'>' + reloadLabel + '</a>';
	linkset[0] = reloadLink;
	dispMenu(linkset);
}

function messageReload(transNo)
{
	var isReloadAuthorised = $("#isReloadAuthorised ").val();
	if(isReloadAuthorised == "true")
	{
		$.ajax({
			type: "GET",
			url: "../../servlet/eXI.MonitorItemsServlet",
			data: "trxNo="+transNo,
			dataType: 'text',
			success: function(msg){
			alert(msg);
			},
			fail: function(msg){
			alert(msg);
			}
		});
		
		parent.schemaBrowserResultFrame.document.location.href = parent.schemaBrowserResultFrame.document.location.pathname 
										+ addParam(parent.schemaBrowserResultFrame.document.location.search, 'TRX_NO', transNo);
	}
	else
	{
		alert(getMessage("XH0075",'XH'));
	}
}

function addParam(search, key, val)
{
	var newParam = '&' + key + '=' + val,
	params = '?' + newParam;

	if (search) 
	{   
		params = search.replace(new RegExp('&' + key + '[^&]*'), newParam);
		if (params === search) 
		{
			params += '&' + newParam;
		}
	}
	return params;
}
