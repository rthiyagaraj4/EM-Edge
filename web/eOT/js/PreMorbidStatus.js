/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create()
{
	f_query_add_mod.location.href='../../eOT/jsp/PreMorbidStatusAddModify.jsp?mode=insert';
}

function apply(){	
	var frm=f_query_add_mod.document.forms[0];
	if(frm.mode.value=="modify"){
	//	frm.submit();
		var fields = new Array (f_query_add_mod.document.forms[0].premorbid_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
		var preMorbidCode	=getLabel("eOT.PreMorbidCode.Label","OT")  ;
		var longdescription =getLabel("Common.longdescription.label","common");
		var shortdescription=getLabel("Common.shortdescription.label","common");
		var names = new Array (preMorbidCode,longdescription,shortdescription);
		if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame)) {	
			frm.submit();
		}
	}else {
		var fields = new Array (f_query_add_mod.document.forms[0].premorbid_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
		var preMorbidCode	=getLabel("eOT.PreMorbidCode.Label","OT")  ;
		var longdescription =getLabel("Common.longdescription.label","common");
		var shortdescription=getLabel("Common.shortdescription.label","common");
		var names = new Array (preMorbidCode,longdescription,shortdescription);
		if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame)) {	
			frm.submit();
		}
}
	
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/PreMorbidStatusAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("PreMorbidStatusAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("PreMorbidStatus.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("PreMorbidStatusQueryCriteria.jsp") != -1)
	{
	 f_query_add_mod.document.forms[0].reset();
}
}
function query()
{

	commontoolbarFrame.document.forms[0].apply.disabled=true
	f_query_add_mod.location.href='../../eOT/jsp/PreMorbidStatusQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

