//This file is saved on 18/10/2005

var radioval    = "C"         ;
function retvalcode(value,number)
{
	code=value+"||"+number;
	/*parent.window.returnValue=code;*/
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = code;
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}
function storeLibVal(currad) {
    radioval=currad.value
}

function CallLibDescFrame() {
		var frmobj=document.formBuildLibraryHeader;
		var search_by=radioval;
		var search_criteria=frmobj.search_criteria.value;
		var search_text=frmobj.search_text.value;
		parent.LibraryLookup_details.location.href = "../../eCP/jsp/LibraryLookupDetails.jsp?search_by="+search_by +"&search_criteria="+search_criteria+"&search_text="+search_text ;
}
function navigation(frmObj,link)
	{
		var start		=	frmObj.start.value;
		var end		=	frmObj.end.value;
		var search_by=frmObj.search_by.value;
		var search_criteria=frmObj.search_criteria.value;
		var search_text=frmObj.search_text.value;
					
		if (link=="next")
		{
			start		=	parseInt(start)+14;
			end		=	parseInt(end)+14;
			parent.LibraryLookup_details.location.href	=	"../../eCP/jsp/LibraryLookupDetails.jsp?from="+start+"&to="+end+"&search_by="+search_by +"&search_criteria="+search_criteria+"&search_text="+search_text ;

	}
	else if(link=="previous")
	{
		start		=	parseInt(start)-14;
		end		=	parseInt(end)-14;
		parent.LibraryLookup_details.location.href		=	"../../eCP/jsp/LibraryLookupDetails.jsp?from="+start+"&to="+end+"&search_by="+search_by +"&search_criteria="+search_criteria+"&search_text="+search_text;

	}
}

function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function resetForm( formObj )
{
	formObj.reset();
	formObj.Search.disabled=false;
    parent.LibraryLookup_details.location.href = "../../eCommon/html/blank.html";

}
function closeW()
{
	 parent.parent.document.getElementById("dialog_tag").close();
	//parent.window.close();
}
