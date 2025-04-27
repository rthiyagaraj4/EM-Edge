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
	f_query_add_mod.location.href='../../eOT/jsp/RolesAddModify.jsp?mode=insert';
}

function apply()
{	
	
	var frm=f_query_add_mod.document.forms[0];
	//alert(frm.name);

	if(frm.name=='query_form' || frm.name=='QueryResult')
{
	//alert('This Operation is not allowed Here');
	//return;
	commontoolbarFrame.location.reload();
}
else
	{
		var fields = new Array (f_query_add_mod.document.forms[0].role_id,f_query_add_mod.document.forms[0].role_desc,f_query_add_mod.document.forms[0].role_type_desc);
		var roleid=getLabel("eOT.RoleID.Label","OT");
		var description=getLabel("Common.description.label","common");
		var reoltype=getLabel("Common.RoleType.label","common");
		var names = new Array (roleid,description,reoltype);
		if(checkFieldsofMst( fields, names, messageFrame)) {	
			f_query_add_mod.document.forms[0].submit();
		}
	}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/RolesAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();
}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("RolesAddModify.jsp") != -1){


	 if(f_query_add_mod.document.location.href.indexOf("Roles.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	 }else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("RolesQueryCriteria.jsp") != -1)
	{
		 f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	//commontoolbarFrame.document.forms[0].apply.disabled=true; //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/RolesQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function appl_for_ot_slate()
{
	if(document.forms[0].appl_to_ot_slate.checked==true)
		 document.forms[0].appl_to_ot_slate.value="Y";
	else
		document.forms[0].appl_to_ot_slate.value="N";
}
