function fetchData()
{
	var doc_type_code = document.forms[0].doc_type_code.value;
	parent.QueryDocTypeResult.location.href="../../eFM/jsp/QueryLocnWiseDetails.jsp?doc_type_code="+doc_type_code;
}
function clearData()
{
	//parent.QueryDocTypeCriteria.document.location.reload();
	document.getElementById("tab1").style.visibility = "hidden";
	parent.QueryDocTypeResult.location.href='../../eCommon/html/blank.html';
}
function reset()
{
	QueryDocTypeCriteria.document.location.reload();
	QueryDocTypeResult.location.href='../../eCommon/html/blank.html';
}

function docTypeLookup(document_type)
			{	
				var title		= getLabel('Common.Location.label','common');
				var argArray	= new Array();	
				var selectArray	= new Array();	
				var headArray	= new Array();	
				var searchArray	= new Array();	
				var arr			= new Array();	
				var sql			= "SELECT FS_LOCN_CODE, short_desc FROM fm_storage_locn WHERE eff_status = 'E' ";
				
				selectArray[0]	= "short_desc";	
				selectArray[1]	= "FS_LOCN_CODE";	
				
				headArray[0]	= getLabel('Common.locationcode.label','common');
				headArray[1]	= getLabel('Common.locationcode.label','common');
				
				argArray[0]		= document_type;    // To get Search Criteria.
				argArray[1]		= sql;			    // SQL to be executed.
				argArray[2]		= selectArray;	    // Column names to be used for getting data. 
				argArray[3]		= headArray;	    // Column Titles
				argArray[4]		= "short_desc";	// To give Link

				var retVal		= CommonDocumentLookup(title, argArray);
				if(retVal != null && retVal != "" ) 
				{
					var ret1	=	unescape(retVal);
					arr=ret1.split("$$");
					document.forms[0].document_type.value	=	arr[0];
					document.forms[0].doc_type_code.value	=	arr[1];
					document.forms[0].Search.disabled	    =	false;
				}
				else
				{
					document.forms[0].doc_type_code.value	=	"";
					document.forms[0].document_type.value	=	"";
					document.forms[0].Search.disabled	    =	true;
				} 
			}
