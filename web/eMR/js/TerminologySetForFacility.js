var  message="";
/*********************************************************/
function create()
{
	f_query_add_mod.location.href="../../eMR/jsp/TerminologySetForFacilityFrameSet.jsp";
}

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
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eMR.TerminologySetforFacilityServlet";
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
function query(){
	frames[1].location.href='../../eMR/jsp/TerminologySetForFacilityQueryCriteria.jsp';
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

function searchDetails() {
	
	   parent.frames[2].location.href='../../eMR/jsp/TerminologySetForFacilityDynamicValues.jsp';
	   parent.frames[1].location.href='../../eCommon/html/blank.html';	
	   var frmobj=parent.f_query_header.document.form_add_mod ;
	  var fields = new Array (frmobj.term_set_id);			    
	  var names = new Array (getLabel("Common.TerminologySet.label","Common"));	
	  var	msgFrame=parent.parent.messageFrame;
	  var facility_desc=document.forms[0].facility_desc.value

	  if(facility_desc.indexOf("'")!=-1){			
			facility_desc = facility_desc.replace("'","''");
	   }

	  /*if(document.forms[0].facility_desc.value!='')
		{
			var fields1 = new Array(document.forms[0].facility_desc);
			var names1 = new Array(getLabel("Common.facility.label","Common"));
			var error_page = "../../eCommon/jsp/MstCodeError.jsp";
			
			if(!SpecialCharCheck(fields1,names1,msgFrame,"M", error_page))
			{
				document.forms[0].facility_desc.focus();
				document.forms[0].facility_desc.select();
				return false;
			}
		}*/

	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))	{	
		  parent.frames[1].location.href='../../eMR/jsp/TerminologySetForFacilityDetail.jsp?term_set_id='+frmobj.term_set_id.value+'&fromSearch=true&facility_desc_text='+encodeURIComponent(facility_desc)+'&search_criteria='+document.forms[0].search_criteria.value;
		  parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';		

		}
  }

/*********************************************************/
function changeTerminology(){
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}





