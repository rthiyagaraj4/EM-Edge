function reset()
{
	criteria_frame.location.reload();
	result_frame.location.href="../../eCommon/html/blank.html";
}

function DateCompare(from,to,messageFrame,getVal) 
{
	var getValue = getVal;
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.select();
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) 
		{
			return true;
		}
	}
	return true;
}

function getReladteFolders(folder_desc)
{
	var facility_id	=  document.forms[0].facility_id.value;
	var title		= getLabel("eFM.DocumentFolder.label","FM");
	var specific	= document.forms[0].specific.value;
	
	var argArray	= new Array();	
	var selectArray	= new Array();	
	var headArray	= new Array();	
	var searchArray	= new Array();	
	var arr			= new Array();	
	
	var sql			= " SELECT doc_folder_id, doc_folder_name, patient_id, to_char(from_period, 'dd/mm/rrrr') from_period, to_char(to_period, 'dd/mm/rrrr')to_period FROM fm_doc_folder WHERE facility_id = '"+facility_id+"' AND patient_period_specific = '"+specific+"' AND eff_status = 'E' ";

	selectArray[0]	= "doc_folder_name";	
	selectArray[1]	= "doc_folder_id";	
	
	headArray[0]	= getLabel("eFM.DocumentFolder.label","FM")+ " "+ getLabel("Common.name.label","common");
	headArray[1]	= getLabel("eFM.DocumentFolder.label","FM")+ " "+ getLabel("Common.identification.label","common");
	
	if (specific=="D")
	{
		selectArray[2]	= "from_period";	
		headArray[2]	= getLabel("Common.periodfrom.label","common");
		selectArray[3]	= "to_period";	
		headArray[3]	= getLabel("Common.periodto.label","common");
	}
	else if (specific=="P")
	{
		headArray[2]	= getLabel("Common.patientId.label","common");
		selectArray[2]	= "patient_id";	
	}


	argArray[0]		= folder_desc; // To get Search Criteria.
	argArray[1]		= sql; // SQL to be executed.
	argArray[2]		= selectArray;	// Column names to be used for getting data. 
	argArray[3]		= headArray;	// Column Titles
	argArray[4]		= "doc_folder_name";	 // To give Link

	var retVal		= CommonDocumentLookup(title, argArray);
	
	if(retVal != null && retVal != "" )
	{
		var ret1	=	unescape(retVal);
		arr=ret1.split("$$");
		document.forms[0].folder_desc.value			=	arr[0];
		document.forms[0].folder_id.value			=	arr[1];
		if (specific=="D")
		{
			document.forms[0].period_from.value		=	arr[2];
			document.forms[0].period_to.value		=	arr[3];
			document.getElementById("frm_legend").innerHTML		=getLabel("Common.periodfrom.label","common");
			document.getElementById("frm_date").innerHTML			="<input type='Text' name='from_period' id='from_period' value='"+arr[2]+"' maxlength='10' size='10' id='from_period' onBlur=\"validDateObj(this,'DMY',localeName);DateCompare(this, to_period, 'messageFrame','Period From');\" readonly>";
			/*document.getElementById("frm_date").innerHTML			="<input type='Text' name='from_period' id='from_period' value='"+arr[2]+"' maxlength='10' size='8' id='from_period' onBlur=\"CheckDate(this);DateCompare(this, to_period, 'messageFrame','Period From');\"><input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].from_period.focus(); return showCalendar('from_period');\">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";*/
			document.getElementById("to_legend").innerHTML		=getLabel("Common.periodto.label","common");
			document.getElementById("to_date").innerHTML			="<input type='Text' name='to_period' id='to_period' value='"+arr[3]+"' maxlength='10' size='10' id='to_period' onBlur=\"validDateObj(this,'DMY',localeName);DateCompare(from_period, this, 'messageFrame','Period From');\" readonly>";
			/*document.getElementById("to_date").innerHTML			="<input type='Text' name='to_period' id='to_period' value='"+arr[3]+"' maxlength='10' size='8' id='to_period' onBlur=\"CheckDate(this);DateCompare(from_period, this, 'messageFrame','Period From');\" ><input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].to_period.focus(); return showCalendar('to_period');\">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";*/
		}
		else if (specific=="P")
		{
			document.forms[0].patient_id.value		=	arr[2];
			document.getElementById("frm_legend").innerHTML		=getLabel("Common.patientId.label","common");
			document.getElementById("frm_date").innerHTML			="<b>"+arr[2]+"</b>";
			document.getElementById("to_legend").innerHTML		="&nbsp;";
			document.getElementById("to_date").innerHTML			="&nbsp;";
		}

	}
	else
	{
		document.forms[0].folder_desc.value			=	"";
		document.forms[0].folder_id.value			=	"";
		document.forms[0].period_from.value			=	"";
		document.forms[0].period_to.value			=	"";
		document.forms[0].patient_id.value			=	"";
		document.getElementById("frm_legend").innerHTML			=   "&nbsp;";
		document.getElementById("frm_date").innerHTML				=   "&nbsp;";
		document.getElementById("to_legend").innerHTML			=   "&nbsp;";
		document.getElementById("to_date").innerHTML				=   "&nbsp;";
	} 
}

function clearFolders(specific)
{
	if (specific=="")
	{
		document.forms[0].folder_desc.value			=	"";
		document.forms[0].folder_id.value			=	"";
		document.forms[0].folder_desc.disabled		=	true;
		document.forms[0].folder.disabled			=	true;
		document.getElementById("frm_legend").innerHTML			=   "&nbsp;";
		document.getElementById("frm_date").innerHTML				=   "&nbsp;";
		document.getElementById("to_legend").innerHTML			=   "&nbsp;";
		document.getElementById("to_date").innerHTML				=   "&nbsp;";
	}
	else
	{
		document.forms[0].folder_desc.value			=	"";
		document.forms[0].folder_id.value			=	"";
		document.forms[0].folder_desc.disabled		=	false;
		document.forms[0].folder.disabled			=	false;
		document.getElementById("frm_legend").innerHTML			=   "&nbsp;";
		document.getElementById("frm_date").innerHTML				=   "&nbsp;";
		document.getElementById("to_legend").innerHTML			=   "&nbsp;";
		document.getElementById("to_date").innerHTML				=   "&nbsp;";
	}
	parent.frames[2].location.href = "../../eCommon/html/blank.html";
	parent.frames[3].location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

function clearPage()
{
	parent.result_frame.document.location.href			=	"../../eCommon/html/blank.html";
	parent.messageFrame.document.location.href			=	"../../eCommon/jsp/error.jsp";
	document.forms[0].search.disabled					= false;
}

function getResults()
{
	var folder_id		= document.forms[0].folder_id.value;
	var specific		= document.forms[0].specific.value;
	var from_period		= "";

	if (document.forms[0].from_period != null)
		from_period		= document.forms[0].from_period.value;
	var to_period		= "";
	if (document.forms[0].to_period != null)
		to_period		= document.forms[0].to_period.value;
	
	var patient_id		= document.forms[0].patient_id.value;

	if (folder_id == "")
	{
		//alert("APP-000001 Document Folder cannot be blank...");
		var msg1=getMessage("CAN_NOT_BE_BLANK","common");
		msg1=msg1.replace('$',getLabel("eFM.DocumentFolder.label","FM"));
		alert(msg1);
		if (!document.forms[0].folder_desc.disabled)
			 document.forms[0].folder_desc.focus();
		else document.forms[0].specific.focus();
		return;
	}
	else if (specific=="D")
	{
		if (from_period=="")
		{
			//alert("APP-000001 Period From cannot be blank...");
			var msg=getMessage("CAN_NOT_BE_BLANK","common");
			msg=msg.replace('$',getLabel("Common.periodfrom.label","common"));
			alert(msg);
			document.forms[0].from_period.focus();
			return;
		}
		else if (to_period=="")
		{
			//alert("APP-000001 Period To cannot be blank...");
			var msg2=getMessage("CAN_NOT_BE_BLANK","common");
			msg2=msg2.replace('$',getLabel("Common.periodto.label","common"));
			alert(msg2);
			document.forms[0].to_period.focus();
			return;
		}
	}
	parent.result_frame.document.location.href="../../eFM/jsp/QueryFolderWiseDocumentsDetails.jsp?folder_id="+folder_id+"&specific="+specific+"&from_period="+from_period+"&to_period="+to_period+"&patient_id="+patient_id;
	document.forms[0].search.disabled = true;
}

function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value   = to; 
	document.forms[0].submit();
}

