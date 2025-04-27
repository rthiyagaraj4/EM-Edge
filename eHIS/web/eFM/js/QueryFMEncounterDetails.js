function fetchResultPage()
{	
	if((document.forms[0].file_type.value != '') || (document.forms[0].encounter_id.value != ''))
	{
		if(document.forms[0].file_type.value != '')
		{
			var file_type = document.forms[0].file_type.value;
			parent.frames[2].location.href="../../eFM/jsp/QueryFMEncounterDetailsResult.jsp?file_type="+file_type;
		}
		else
		{
			var encounter_id = document.forms[0].encounter_id.value;
			parent.frames[2].location.href="../../eFM/jsp/QueryFMEncounterDetailsResult.jsp?encounter_id="+encounter_id;
		}
	}
	else
	{
//		alert('APP-FM0009 Atleast one criteria should be selected');
		alert(getMessage("ATLEAST_ONE_CRITERIA","FM"));
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";	
	}
}
function DiableField(Obj)
{
	if(Obj.name == "file_type")
	{
		if(document.forms[0].file_type.value != '')
		{
			document.forms[0].encounter_id.value = '';
			if(document.forms[0].encounter_id.disabled == false)
				document.forms[0].encounter_id.disabled = true;
			if(document.forms[0].encounter_id_search.disabled == false)
				document.forms[0].encounter_id_search.disabled = true;
			document.getElementById("th").innerHTML = getLabel("Common.encounterid.label","common");
		}
		else
		{
			document.forms[0].encounter_id.disabled = false;
			document.forms[0].encounter_id_search.disabled = false;
			document.getElementById("th").innerHTML = "";
			if(document.getElementById("tab").style.visibility == 'visible')
				document.getElementById("tab").style.visibility = 'hidden';
		}
	}
	parent.QFMEDResultFrame.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}
function reset()
{
	QFMEDSearchFrame.location.reload();
	QFMEDResultFrame.location.href="../../eCommon/html/blank.html";
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}
function clearAllData()
{
	if(document.getElementById("tab").style.visibility == 'visible')
		document.getElementById("tab").style.visibility = 'hidden';
	parent.QFMEDResultFrame.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function callSearchScreen()
{
		var retVal = new String();
		var dialogHeight = "23.4";
		var dialogWidth  = "40";
		var dialogTop    = "65";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + ";status=no;"+"dialogTop:"+dialogTop;
		var arguments;
		var file_no;
		var file_type;
		var patient_id;
		var called_from = "QFMED";
		retVal = window.showModalDialog("../../eFM/jsp/IPEncounterDisplayFrame.jsp?file_no="+file_no+"&file_type="+file_type+"&patient_id="+patient_id+"&called_from="+called_from,arguments,features);
		if(retVal != null)
		{
		retVal = retVal.split("|");
		document.forms[0].encounter_id.value = retVal[0];
		document.forms[0].file_type.value = '';
		if(document.forms[0].file_type.disabled == false)
		document.forms[0].file_type.disabled = true;
		document.getElementById("th").innerHTML = getLabel("Common.filetype.label","common");
	}
	else
	{
		document.forms[0].file_type.disabled = false;
		document.forms[0].encounter_id.value = '';
		document.getElementById("th").innerHTML = "";
		if(document.getElementById("tab").style.visibility == 'visible')
			document.getElementById("tab").style.visibility = 'hidden';

	}
	parent.QFMEDResultFrame.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function submitPrevNext(fromRecordNumber, toRecordNumber)
{
    document.forms[0].previousRecord.value = fromRecordNumber;
    document.forms[0].nextRecord.value = toRecordNumber; 
    document.forms[0].submit();
}
