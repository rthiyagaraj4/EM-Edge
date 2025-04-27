 var message     = "";
//function for create mode
function create()
{
	f_query_add_mod.location.href="../../eMR/jsp/AccuracyForPatientClassFrameSet.jsp";
	}

function searchDetails()
  {
	 var frmobj=parent.f_query_header.document.form_add_mod ;
	  var fields = new Array (frmobj.accuracy_code);			    
	  var names = new Array (getLabel("eMR.AccuracyCode.label","MR"));	
	  var	msgFrame=parent.parent.messageFrame;
	  if(parent.f_query_header.checkFieldsofMst(fields, names, msgFrame))
		{	
  parent.frames[1].location.href='../../eMR/jsp/AccuracyForPatientClassDetail.jsp?accuracy_code='+frmobj.accuracy_code.value;
		}
  }
//function for query mode
function query(){
	frames[1].location.href='../../eMR/jsp/AccuracyForPatientClassQueryCriteria.jsp';
}

function onSuccess() {
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.reload();
}

//function to check whether on apply,the flow can be proceeded...
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
//function whether the flow can proceed if on click of apply
function checkIfApply()
{
	var url=parent.frames[2].frames[1].frames[1].location.href;
	url=url.toLowerCase();
	if(url.indexOf("blank")==-1)
		return true;
	else
		return false;
}
function apply()
{
	var msgFrame= parent.frames[2].frames[2];
	
  if((! checkIsValidForProceed()) || (! checkIfApply()) )
	{
		message  = getMessage("APPLY_NOT_VALID",'MR');
		msgFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var frmObj=parent.frames[2].frames[1].frames[1].document.detail_form;
	var tot_rec=frmObj.total_records.value;

    for(i=0;i<tot_rec;i++){
		var select = frmObj["select_yn" + i].checked;
		if(select==true)
			frmObj["select_yn" + i].value = 'Y';
		else
			frmObj["select_yn" + i].value = 'N';
						}
	
	parent.frames[2].frames[1].frames[1].document.forms[0].action='../../servlet/eMR.AccuracyForPatientClassServlet';
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();

}
function reset()
{
	var loc=frames[2].document.forms[0]

	if (loc!=null )
	{
			f_query_add_mod.document.forms[0].reset();
	}
	else  if(loc==null)
	{
f_query_add_mod.frames[0].document.forms[0].reset();	}
}


	

