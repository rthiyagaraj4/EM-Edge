/*********************************************************/
function apply()
{
	if (! checkIsValidForProceed() ) {
	     message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed3()){
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}



	parent.frames[2].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eMR.TerminologySetForSpecialtyServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
}
/*********************************************************/
function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
/*********************************************************/

function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
/*********************************************************/
function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
/*********************************************************/
function checkIsValidForProceed3()
{		var url = f_query_add_mod.Dummy.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
/*********************************************************/
function create()
{
	f_query_add_mod.location.href="../../eMR/jsp/TerminologySetForSpecialtyFrameSet.jsp";
}
/*********************************************************/
function query(){

	frames[1].location.href='../../eMR/jsp/TerminologySetForSpecialtyQueryCriteria.jsp';
}

/*********************************************************/

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

/*********************************************************/
function onSuccess() {
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.reload();
}
/*********************************************************/
function searchDetails()
  {
		
	  parent.frames[1].location.href='../../eCommon/html/blank.html';
	  parent.frames[2].location.href='../../eMR/jsp/TerminologySetForSpecialtyDynamicValues.jsp';
	  var frmobj=parent.f_query_header.document.form_add_mod ;
	  var fields = new Array (frmobj.term_set_id);			    
	  var names = new Array (getLabel("Common.TerminologySet.label","Common"));	
	  var	msgFrame=parent.parent.messageFrame;
	  var speciality=document.forms[0].specialty_desc.value;

		if(speciality.indexOf("'")!=-1)
		{			
			speciality = speciality.replace("'","''");
		}

	  /*if(document.forms[0].specialty_desc.value!='')
		{
			var fields1 = new Array(document.forms[0].specialty_desc);
			var names1 = new Array(getLabel("Common.speciality.label","Common"));
			var error_page = "../../eCommon/jsp/MstCodeError.jsp";
			
			if(!SpecialCharCheck(fields1,names1,msgFrame,"M", error_page))
			{
				document.forms[0].specialty_desc.focus();
				document.forms[0].specialty_desc.select();
				return false;
			}
		}
		*/
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{	
		 
		  parent.frames[1].location.href='../../eMR/jsp/TerminologySetForSpecialtyDetail.jsp?term_set_id='+frmobj.term_set_id.value+'&fromSearch=true&specialty_desc_text='+encodeURIComponent(speciality)+'&search_criteria='+document.forms[0].search_criteria.value;
		   parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';

		
		}
  }



/*********************************************************/
function changeTerminology(){
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}

/*********************************************************/


