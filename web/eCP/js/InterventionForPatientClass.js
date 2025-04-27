//This file is saved on 18/10/2005

var message="";

function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/InterventionForPatientClassFrameSet.jsp";
}
//*******************************************************************************************************
function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/InterventionForPatientClassQueryCriteria.jsp";
}
//*************

function searchDetails()
  {
	  parent.frames[2].location.href='../../eCP/jsp/InterventionForPatientClassDynamicValues.jsp';
	  var frmobj=parent.f_query_header.document.form_add_mod ;
	  var fields = new Array (frmobj.patient_class);			    
	  var names = new Array (getLabel("Common.patientclass.label","Common"));	
	  var	msgFrame=parent.parent.messageFrame;
	
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{	
		  
		    parent.frames[1].location.href='../../eCP/jsp/InterventionForPatientClassDetail.jsp?patient_class='+frmobj.patient_class.value+'&fromSearch=true';
		  parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';

		  		}

		  }
		  
  //*************************
  /********************************************/

function apply(){

if (! checkIsValidForProceed() ) {
		message  =getMessage("APPLY_NOT_VALID","CP");
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		message  = " ";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		message  = " ";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	parent.frames[2].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;

	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.InterventionForPatientClassServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
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



/********************************************/
/********************************************/
function checkActive(target)
{
	if(target.checked==false)
	{
		target.value="D";
		target.checked=false;
	}
	else
	{
		target.value="E";
		target.checked=true;
	}
}
/*************************************************/
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

/*************************************************/
function onSuccess() {
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.reload();
}


