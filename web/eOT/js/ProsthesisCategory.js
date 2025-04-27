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
	f_query_add_mod.location.href='../../eOT/jsp/ProsthesisCategoryAddModify.jsp?mode=insert';
}

function apply()
{	
	var frm=f_query_add_mod.document.forms[0];
	if(frm.name=='query_form' || frm.name=='QueryResult')
	{
		commontoolbarFrame.location.reload();
	}
	else
		{
		var prosthesis_catagory=getLabel("eOT.ProsthesisCategory.Label","OT");
		var description=getLabel("Common.description.label","Common");
		var fields = new Array (f_query_add_mod.document.forms[0].prosthesis_cat_code,f_query_add_mod.document.forms[0].prosthesis_cat_desc );
		var names = new Array ( prosthesis_catagory,description );

		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}  
	}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/ProsthesisCategoryAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}
/*
function reset()
{
	f_query_add_mod.document.forms[0].reset();
} */

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ProsthesisCategoryAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("ProsthesisCatagory.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ProsthesisCategoryQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}
function query()
{
	//commontoolbarFrame.document.forms[0].apply.disabled=true; //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/ProsthesisCategoryQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

