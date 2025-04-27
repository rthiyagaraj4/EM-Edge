
function create()
{
	criteriaFrame.location.href="../../eFM/jsp/FMDocumentTypeInFolderAddMod.jsp";
}

function getValidRecords(folderName)
{
	if (folderName!="")
	{
		parent.resultFrame.location.href="../../eFM/jsp/FMDocumentTypeInFolderResult.jsp?folderName="+folderName;
	}
	else
		parent.resultFrame.location.href="../../eCommon/html/blank.html";
}

function apply()
{
	if (criteriaFrame.document.FMDocumentContentForm != null)
	{
		if (criteriaFrame.document.FMDocumentContentForm.document_id.value == "")
		{
			//messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Document Folder cannot be blank...";
		errors1 = getMessage("CAN_NOT_BE_BLANK","common");
		errors1=errors1.replace('$',getLabel("eFM.DocumentFolder.label","FM"));
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors1;
		//messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Document Folder cannot be blank...";
			return;
		}
		else 
		{
			var valid_val	=	resultFrame.document.FMDocumentContentForm.valid_values.value;
			var outToken	=	new Array();	
			var inToken		=	new Array();	
			var outLength	=	0;
		
			outToken	=	valid_val.split(",");
			outLength	=	Math.abs(outToken.length);
			for (i=0; i<outLength; i++ )
			{
				inToken	=	outToken[i].split("$$");
				if (inToken[1]=="")
				{
					//messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Required cannot be blank...";
					errors1 = getMessage("CAN_NOT_BE_BLANK","common")
					errors1=errors1.replace('$',getLabel('Common.required.label','common'));
					messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors1;
					return;
				}
			}
		}
		if (resultFrame.document.FMDocumentContentForm.checked_yn.value != "Y")
		{
			var error = getMessage("NO_CHANGE_TO_SAVE","FM");
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
			return;
		}
		resultFrame.document.FMDocumentContentForm.method="POST";
		resultFrame.document.FMDocumentContentForm.target="messageFrame";
		resultFrame.document.FMDocumentContentForm.action="../../servlet/eFM.FMDocumentTypeInFolderServlet";
		resultFrame.document.FMDocumentContentForm.submit();
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
	criteriaFrame.document.FMDocumentContentForm.document_id.value = "";
	resultFrame.document.location.href="../../eCommon/html/blank.html";
}
function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

//var validDictionary	= new ActiveXObject("Scripting.Dictionary"); 
var validDictionary	= {};
function getCheckedValues(checkBox, req_type)
{
	var validcheck		=	document.forms[0].valid_values.value;
	var valid_val		=	"";
	var hiddenValidArray= new Array();
	hiddenValidArray	= validcheck.split(",");
	var validLen		= Math.abs(hiddenValidArray.length) ;
	var outArray		= new Array();
	for (j=0; j<validLen; j++)
	{
		valid_val	=	hiddenValidArray[j];
		outArray	=	valid_val.split("$$");
		if (!validDictionary.Exists(outArray[0]))
			validDictionary.add(outArray[0], valid_val);
	}

	if (checkBox.checked)
	{
		valid_val	=	checkBox.value+"$$"+req_type.value;
		if (!validDictionary.Exists(checkBox.value))
				validDictionary.add(checkBox.value, valid_val);
		document.forms[0].checked_yn.value = "Y";
	}
	else
	{
		valid_val	=	checkBox.value+"$$"+req_type.value;
		if (validDictionary.Exists(checkBox.value))
				validDictionary.Remove(checkBox.value);
		document.forms[0].checked_yn.value = "N";
	}
	
	document.forms[0].valid_values.value = ((validDictionary.Items()).toArray()).toString();
}

function getSelectedValues(selectBox, checkBox)
{
	var validcheck		=	document.forms[0].valid_values.value;
	var valid_val		=	"";
	var hiddenValidArray= new Array();
	hiddenValidArray	= validcheck.split(",");
	var validLen		= Math.abs(hiddenValidArray.length) ;
	var outArray		= new Array();
	for (j=0; j<validLen; j++)
	{
		valid_val	=	hiddenValidArray[j];
		outArray	=	valid_val.split("$$");
		if (!validDictionary.Exists(outArray[0]))
			validDictionary.add(outArray[0], valid_val);
	}

	if (checkBox.checked)
	{
		valid_val	=	checkBox.value+"$$"+selectBox.value;
		if (validDictionary.Exists(checkBox.value))
				validDictionary.Remove(checkBox.value);
		if (!validDictionary.Exists(checkBox.value))
				validDictionary.add(checkBox.value, valid_val);
	}
	document.forms[0].valid_values.value = ((validDictionary.Items()).toArray()).toString();
}
