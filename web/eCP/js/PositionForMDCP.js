//This file is saved on 18/10/2005

function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/PositionForMDCPFrameSet.jsp";
}

/********************************************/

function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/PositionForMDCPQueryCriteria.jsp";
}


/********************************************/

function apply()
{
	if (! checkIsValidForProceed() ) {
		message  =" ";
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

	parent.frames[1].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[1].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.PositionForMDCPServlet";
	parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[1].frames[1].frames[1].document.forms[0].submit();
}
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
function onSuccess()
{
	frames[1].frames[0].document.forms[0].reset();
	frames[1].frames[0].document.forms[0].elements(0).focus();
	frames[1].frames[1].location.href='../../eCommon/html/blank.html';
}
/******************************************************/
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
/*************************************************/
function viewPosition()
{
	var facility=document.forms[0].facility_id1;

	var facility_id=facility[facility.selectedIndex].value;
	var practitioner=document.forms[0].pract_type;
	var pract_type=practitioner[practitioner.selectedIndex].value;
	parent.frames[2].location.href='../../eCP/jsp/PositionForMDCPDynamicValues.jsp';
	  var fields = new Array (facility);
	  var names = new Array (getLabel("Common.facility.label","common"));	
	  var	msgFrame=parent.parent.messageFrame;
	 if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
	{		
		 parent.frames[1].location.href="../../eCP/jsp/PositionForMDCPDetail.jsp?facility_id1="+facility_id+"&pract_type="+pract_type+"&fromSearch=true";
	}
}
/********************************************/
function oncheck(target){
	if(target.checked == false){
		target.value = "N";
	}	else	{
		target.value = "Y";
		target.checked = true;
	}
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
/******************************************************************/
function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
			return true;
		else
			return false;
}
/*********************************************************************/
function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
			return true;
		else
			return false;
}
/******************************************************************/
function clearDetail(){
	parent.f_query_detail.location.href='../../eCommon/html/blank.html';
	parent.Dummy.location.href='../../eCommon/html/blank.html';
}
