
function create()
{
	criteriaFrame.location.href="../../eFM/jsp/DTFolderInFSLocnAddMod.jsp";
}

function getValidRecords(fs_location)
{
	if (fs_location!="")
	{
		parent.resultFrame.location.href="../../eFM/jsp/DTFolderInFSLocnResult.jsp?fs_location="+fs_location;
	}
	else
		parent.resultFrame.location.href="../../eCommon/html/blank.html";
}

function apply()
{
	if (criteriaFrame.document.DTFolderInFSLocnForm != null)
	{
		if (criteriaFrame.document.DTFolderInFSLocnForm.fs_location.value == "")
		{
			//messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 File Storage Location cannot be blank...";
			errors1 = getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
			errors1=errors1.replace('$',getLabel("eFM.ToFSLocation.label","FM"));		
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors1;
			return;
		}
		if (resultFrame.document.DTFolderInFSLocnForm.checked_yn.value != "Y")
		{
			var error = getMessage("NO_CHANGE_TO_SAVE","FM");
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
			return;
		}
		resultFrame.document.DTFolderInFSLocnForm.method="POST";
		resultFrame.document.DTFolderInFSLocnForm.target="messageFrame";
		resultFrame.document.DTFolderInFSLocnForm.action="../../servlet/eFM.DTFolderInFSLocnServlet";
		resultFrame.document.DTFolderInFSLocnForm.submit();
	}
	else
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

function reset()
{
	criteriaFrame.location.reload();
}
function onSuccess()
{
	criteriaFrame.document.DTFolderInFSLocnForm.fs_location.value = "";
	resultFrame.document.location.href="../../eCommon/html/blank.html";
}

function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

var validDictionary	= new ActiveXObject("Scripting.Dictionary"); 

function getCheckedValues(checkBox)
{
	var validcheck		=	document.forms[0].valid_values.value;
	var valid_val		=	"";
	var hiddenValidArray= new Array();
	hiddenValidArray	= validcheck.split(",");
	var validLen		= Math.abs(hiddenValidArray.length) ;
	for (j=0; j<validLen; j++)
	{
		if (!validDictionary.Exists(hiddenValidArray[j]))
			validDictionary.add(hiddenValidArray[j], hiddenValidArray[j]);
	}

	if (checkBox.checked)
	{
		valid_val	=	checkBox.value;
		if (!validDictionary.Exists(valid_val))
				validDictionary.add(valid_val, valid_val);
		document.forms[0].checked_yn.value = "Y";
	}
	else
	{
		valid_val	=	checkBox.value;
		if (validDictionary.Exists(valid_val))
				validDictionary.Remove(valid_val);
		document.forms[0].checked_yn.value = "N";
	}
	
	document.forms[0].valid_values.value = ((validDictionary.Items()).toArray()).toString();
}
