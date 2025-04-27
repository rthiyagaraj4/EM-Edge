//This file is saved on 18/10/2005

function apply()
{
	if (! checkIsValidForProceed() ) {
		message  = getMessage("APPLY_NOT_VALID","CP");
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	
	parent.frames[1].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[1].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.LevelOfCareForDependencyServlet";
	parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[1].frames[1].frames[1].document.forms[0].submit();
	
	
}

function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/LevelOfCareForDependencyFrameSet.jsp";
}

function query()
{
	frames[1].location.href='../../eCP/jsp/LevelOfCareForDependencyQueryCriteria.jsp';
}

function reset()
{

	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
				parent.frames[1].frames[1].f_query_header.document.forms[0].reset();
				parent.frames[1].frames[1].f_query_header.document.forms[0].elements(0).focus();
				parent.frames[1].frames[1].f_query_detail.location.href='../../eCommon/html/blank.html';
				parent.frames[1].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
		}else
			parent.frames[1].frames[1].document.forms[0].reset();
	}
}
function onSuccess() 
{
	parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[1].frames[1].frames[0].location.reload();
}

function searchDetails()
  {

	  var frmobj=parent.f_query_header.document.form_add_mod ;
	  var fields = new Array (frmobj.level_care_code);			    
	  var names = new Array (getLabel("Common.levelofcare.label","Common"));	
	  var	msgFrame=parent.parent.messageFrame;
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{	
	    	parent.parent.messageFrame.location.href= "../../eCommon/jsp/error.jsp"+"";	
		    parent.frames[1].location.href='../../eCP/jsp/LevelOfCareForDependencyDetail.jsp?level_of_care_code='+frmobj.level_care_code.value+'&fromSearch=true';

		  	 parent.frames[2].location.href='../../eCP/jsp/LevelOfCareForDependencyDynamicValues.jsp';


		}
  }


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
{		var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}

function clearDetail()
{
parent.frames[1].location.href='../../eCommon/html/blank.html';
}
