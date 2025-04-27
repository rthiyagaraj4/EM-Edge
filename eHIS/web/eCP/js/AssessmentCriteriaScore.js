//This file is saved on 18/10/2005


function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/AssessmentCriteriaScoresFrameset.jsp";
}
function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/AssessmentCriteriaScoresQueryCriteria.jsp";
}
function reset()
{
	if(parent.frames[2].frames[1].document.forms[0])
	{
		
		parent.frames[2].frames[1].document.forms[0].reset();
	}
	
	else if(parent.frames[2].frames[1].assess_crit_score_header)
	{
		if(parent.frames[2].frames[1].assess_crit_score_header.document.forms[0])
		{
			parent.frames[2].frames[1].assess_crit_score_header.document.forms[0].reset();
		}
	}
	//f_query_add_mod.location.href="../../eCP/jsp/AssessmentCriteriaScoresFrameset.jsp";
}

function apply()
{
    //var messageFrame= parent.frames[1].frames[2];
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;

 
	if((! checkIsValidForProceed()) || (! checkIfApply()) )
	{
		if(!checkIsValidForProceed())
		{
		var message=getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false;
		}
		//alert(f_query_add_mod.assess_crit_score_header.document.assess_crit_score_header.name);
		var frmobj=f_query_add_mod.assess_crit_score_header.document.assess_crit_score_header;
		if(f_query_add_mod.assess_crit_score_header.document.assess_crit_score_header)
		{
		var fields = new Array (frmobj.assess_note,frmobj.assess_catg);
		var names = new Array (getLabel("eCP.AssessmentNote.label","CP"),getLabel("eCP.AssessmentCategory.label","CP"))
		if(f_query_add_mod.assess_crit_score_header.checkFieldsofMst( fields, names, messageFrame))
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false ;
		}
	}
	f_query_add_mod.assess_crit_score_addmod.assess_crit_score_addmod.submit();
}

function onSuccess()
{
}

function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1) && (url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}

function checkIfApply()
{
	//alert("check apply");
	//var url=parent.frames[1].frames[1].frames[1].location.href;
	var url=parent.frames[2].frames[1].frames[1].location.href;
	url=url.toLowerCase();
	if(url.indexOf("blank")==-1)
		return true;
	else
		return false;
}
