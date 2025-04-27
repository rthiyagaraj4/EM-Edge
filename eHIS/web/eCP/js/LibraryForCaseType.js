//This file is saved on 18/10/2005

var message="";
function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/LibraryForCaseTypeFrameSet.jsp";
}

async function viewAgeGroup(target)
{ 
	var frmobj=parent.f_query_header.document.form_add_mod ;
	frmobj.case_type_desc.value="";
	 var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

 	argumentArray[0] ="Select case_type_code code, short_desc description from cp_case_type_lang_vw where eff_status = 'E'  and language_id like ? AND UPPER(case_type_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) ORDER by short_desc";
		dataNameArray[0] = "locale";
		dataValueArray[0]= frmobj.locale.value;
		dataTypeArray[0] = STRING;

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(getLabel("eCP.CaseType.label","CP"), argumentArray );
		
		
		if(retVal != null && retVal != "") {
			var ret1=unescape(retVal);
			 var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
			
			target.value = arr[1] ;
			document.forms[0].case_type_code.value = arr[0];
			//alert("document.forms[0].assess_note_id.value"+document.forms[0].assess_note_id.value);
		}else
			target.value ="";
}



function searchDetails()
  {
	
     parent.frames[2].location.href='../../eCP/jsp/LibraryForCaseTypeDynamicValues.jsp';
	 var frmobj=parent.f_query_header.document.form_add_mod ;
	var fields = new Array (frmobj.case_type_code);	
	 var names = new Array (getLabel("eCP.CaseType.label","CP"));	
	  var	msgFrame=parent.parent.messageFrame;
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{	
		 
		  parent.frames[1].location.href='../../eCP/jsp/LibraryForCaseTypeDetail.jsp?case_type_code='+frmobj.case_type_code.value+'&fromSearch=true';

				  parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	}
  }




	
function query()
{
	frames[1].location.href='../../eCP/jsp/LibraryForCaseTypeQueryCriteria.jsp';
}

function reset()
{
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
				parent.frames[2].frames[1].f_query_header.document.forms[0].reset();
				parent.frames[2].frames[1].f_query_header.document.forms[0].elements(0).focus();
				parent.frames[2].frames[1].f_query_detail.location.href='../../eCommon/html/blank.html';
				parent.frames[2].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
		}else
			parent.frames[2].frames[1].document.forms[0].reset();
	}
}
//Changes Made on 17/11/08 -----By SANDHYA---------
function apply()
{
	if (! checkIsValidForProceed() ) {
		
		//message  = getMessage("APPLY_NOT_VALID","CP");
		//frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
		
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		//alert("3rd if chkproceed");
		//message  = getMessage("APPLY_NOT_VALID","CP");
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		//alert(f_query_add_mod.f_query_header.document.form_add_mod.name);
		var frmobj=f_query_add_mod.f_query_header.document.form_add_mod;
		var fields = new Array (frmobj.case_type_desc);
		var names = new Array (getLabel("eCP.CaseType.label","CP"))
		if(f_query_add_mod.f_query_header.checkFieldsofMst( fields, names, messageFrame))
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false ;
	}
	
	//parent.frames[1].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[1].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[2].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;
	//parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.LibraryForCaseTypeServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.LibraryForCaseTypeServlet";
	//parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	//parent.frames[1].frames[1].frames[1].document.forms[0].submit();
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
	
	
}
/***********************************************************************/


function checkIsValidForProceed()
{
	
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function checkIsValidForProceed1()
{		
	
	var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
function checkIsValidForProceed2()
{	
	var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}


function onSuccess() 
{
	//parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	//parent.frames[1].frames[1].frames[0].location.reload();
	parent.frames[2].frames[1].frames[1].location.reload();
}



function clearDetail()
{
parent.frames[1].location.href='../../eCommon/html/blank.html';
}
