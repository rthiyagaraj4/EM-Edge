//This file is saved on 18/10/2005
 
 
 
 var message     = "";
//*************************************************************************************************
//function for create mode
function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/CPAccessRightsFrameSet.jsp";
	}
//*************************************************************************************************
function searchDetails()
  {
	 var frmobj=parent.f_query_header.document.cp_access_right_header ;
	 parent.f_query_detail.location.href='../../eCP/jsp/CPAccessRightsDetail.jsp?practitioner_type='+frmobj.practitioner_type.value+'&practitioner_name='+frmobj.practitioner_name.value+'&practitioner_id='+frmobj.practitioner_id.value+'&search_text='+frmobj.search_text.value+'&fromSearch=true';
	
	parent.frames[2].location.href='../../eCP/jsp/CPAccessRightsDynamicValues.jsp?practitioner_type='+frmobj.practitioner_type.value+'&practitioner_name='+frmobj.practitioner_name.value+'&practitioner_id='+frmobj.practitioner_id.value;	
  }
//*************************************************************************************************
//function for query mode
function query(){
	f_query_add_mod.location.href='../../eCP/jsp/CPAccessRightsQueryCriteria.jsp';
}
//*************************************************************************************************
function onSuccess() {
	parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[1].frames[1].frames[0].location.reload();
}
//*************************************************************************************************
//function to check whether on apply,the flow can be proceeded...
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1) && (url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
//*************************************************************************************************
//function whether the flow can proceed if on click of apply
function checkIfApply()
{
	var url=parent.frames[1].frames[1].frames[1].location.href;
	url=url.toLowerCase();
	if(url.indexOf("blank")==-1)
		return true;
	else
		return false;
}
//*************************************************************************************************
function apply()
{
	var messageFrame= parent.frames[1].frames[2];

  if((! checkIsValidForProceed()) || (! checkIfApply()) )
	{
		
		var message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
 	parent.frames[1].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[1].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[1].frames[1].frames[1].document.forms[0].action='../../servlet/eCP.CPAccessRightsServlet';
	parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[1].frames[1].frames[1].document.forms[0].submit();
 }
//*************************************************************************************************
function reset()
{
	var url=f_query_add_mod.location.href;

	if(url.indexOf("blank")==-1) {
		if((url.indexOf("Query")==-1)){
				parent.frames[1].frames[1].f_query_header.document.forms[0].reset();
				parent.frames[1].frames[1].f_query_header.document.forms[0].elements(0).focus();
				parent.frames[1].frames[1].f_query_detail.location.href='../../eCommon/html/blank.html';
				parent.frames[1].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
		}else
			parent.frames[1].frames[1].document.forms[0].reset();
	}

}
 //*********************************************************************************************
 function selectAll(Obj,start,end){

   //int start1=String.valueOf(start);
  // int end1=(String)end;
  var practitioner_name=parent.frames[0].document.forms[0].practitioner_name.value;
  var practitioner_type=parent.frames[0].document.forms[0].practitioner_type.value;
  var practitioner_id = parent.frames[0].document.forms[0].practitioner_id.value;
	if(Obj.checked){

		for(var i=start;i<=end;i++){
			if(eval("document.forms[0].select"+i))
			eval("document.forms[0].select"+i).checked=true;
			}
		
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='CPAccessRightsDynamicValues.jsp?'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='practitioner_name' id='practitioner_name' value='"+practitioner_name+"'><input type='hidden' name='practitioner_id' id='practitioner_id' value='"+practitioner_id+"'><input type='hidden' name='practitioner_type' id='practitioner_type' value='"+practitioner_type+"'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
	}
	else{
		for(var i=start;i<=end;i++){
			if(eval("document.forms[0].select"+i))
			eval("document.forms[0].select"+i).checked=false;
			}
	
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='CPAccessRightsDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'><input type='hidden' name='practitioner_name' id='practitioner_name' value='"+practitioner_name+"'><input type='hidden' name='practitioner_id' id='practitioner_id' value='"+practitioner_id+"'><input type='hidden' name='practitioner_type' id='practitioner_type' value='"+practitioner_type+"'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
	}
}
/****************************************************************************************************/

 function chkForSelectAll(start,end){
	if(parent.frames[2].document.forms[0].E.value == 'selectAll'){
		document.forms[0].selectall.checked=true;
		alert(document.forms[0].selectall.checked);
		selectAll(document.forms[0].selectall,start,end)
	}
}
//*************************************************************************************************

function submitPrevNext(from, to){
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}
//*************************************************************************************************

function OnClickCheckBox(obj)
{
	//alert("name"+obj);
	if((obj.checked)==true)
	{
	//	alert("ccccccccccccc");
	    obj.value="Y";
	}
	else
		obj.value="N";
}
//*************************************************************************************************		
function clearDetail(){
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}

