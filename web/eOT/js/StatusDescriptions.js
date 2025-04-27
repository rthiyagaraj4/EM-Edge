/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
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

else{
	var fields = new Array (f_query_add_mod.document.forms[0].status_desc);
	var description =getLabel("Common.description.label","Common");
	var names = new Array (description);
	if(checkFieldsofMst(fields,names,messageFrame)) 
		{	
			f_query_add_mod.document.forms[0].submit();
		}
}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/StatusDescriptionsModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}
*/

function reset() {
	 //if(f_query_add_mod.document.location.href.indexOf("StatusDescriptions.jsp") != -1)

	 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("StatusDescriptionsModify.jsp") != -1)
		  f_query_add_mod.document.forms[0].reset();
	 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("StatusDescriptionsQueryCriteria.jsp") != -1)
		 f_query_add_mod.document.forms[0].reset();
	 else
		return false;
	}
function query()
{
	//commontoolbarFrame.document.forms[0].reset.disabled=true;
	f_query_add_mod.location.href='../../eOT/jsp/StatusDescriptionsQueryCriteria.jsp';
}


