
async function CommonDocumentLookup(title, argArray, dWidth, dHeight) 
{
    var retVal			= new Array();
	var dialogHeight	= "";
	var dialogWidth		= "";
	
	if (dHeight==null)
		dialogHeight	= "28" ;
	else dialogHeight	= dHeight;	
	
	if (dWidth==null)
		dialogWidth		= "48" ;
	else dialogWidth	= dWidth;	

	var status			= "no";

	var dialogUrl       = "DTDocumentNumberLookup.jsp?title="+title;
	var dialogArguments = argArray ;
	
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var retVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
	
	return retVal;
}

function closeWindow(count) 
{
	var val = "document.getElementById('return_value')"+count;
	let dialogBody = parent.parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = eval(val).value;
		
	const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	dialogTag.close();
	//window.returnValue	=	eval(val).value;
    //parent.window.close();
}

function initializeText() 
{
    var argArray = window.dialogArguments ;
    
	document.getElementById("search_text").value	= argArray[0] ;
    document.getElementById("sql").value			= argArray[1] ;
    document.getElementById("selectArray").value	= argArray[2] ;
    document.getElementById("headArray").value	= argArray[3] ;
    document.getElementById("link_field").value	= argArray[4] ;

    makeValidString( document.getElementById("search_text") ) ;
	document.getElementById("Search").disabled	= true;	
	getValidRecords(document.getElementById("search_text"))
}

function getValidRecords(search_text)
{
	document.forms[0].action	=	"../../eFM/jsp/DTDocumentNumberLookupResult.jsp";
	document.forms[0].target	=	"lookup_detail";
	document.forms[0].submit();
}

function resetForm( formObj )
{
	parent.lookup_head.document.forms[0].search_text.value="";
	parent.lookup_head.document.forms[0].search_criteria.value="S";
    parent.lookup_detail.location.href = "../../eCommon/html/blank.html";
}


function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].prevNextClick.value = "Y"; 
	document.forms[0].submit();
}

function orderResult(headCount)
{
	var selectArray	=	parent.lookup_head.document.forms[0].selectArray.value
	splitArray		=	selectArray.split(",");
	document.forms[0].searchBy.value = splitArray[headCount];
	
	if (document.forms[0].headCountValue.value==headCount)
		document.forms[0].prevNextClick.value	=	"X";
	else document.forms[0].src_value.value		=	"";
	
	document.forms[0].headCountValue.value	=	headCount;
	
	document.forms[0].submit();
}
