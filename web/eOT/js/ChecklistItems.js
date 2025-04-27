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
	f_query_add_mod.location.href='../../eOT/jsp/ChecklistItemsAddModify.jsp?mode=insert&flag=disabled';
}

function apply(){	
	var checklistItem=getLabel("eOT.ChecklistItem.Label","OT");
	var description=getLabel("Common.description.label","Common");
   var frm=f_query_add_mod.document.forms[0];
	if(frm.mode=='modify'){
	 frm.submit();
	}else if(frm.checklist_type.value=='L'){
		if(frm.list_id.value==''){
		alert(getMessage("APP-OT0046","OT"));
		commontoolbarFrame.location.reload();
    }else{
		var fields = new Array (f_query_add_mod.document.forms[0].checklist_item_code,f_query_add_mod.document.forms[0].description);
		var names = new Array (checklistItem,description);
		if(checkFieldsofMst( fields, names, messageFrame)){	
			f_query_add_mod.document.forms[0].submit();
		}
	}
    }else{
		var fields = new Array (f_query_add_mod.document.forms[0].checklist_item_code,f_query_add_mod.document.forms[0].description);
		var names = new Array (checklistItem,description);
		if(checkFieldsofMst( fields, names, messageFrame)){	
			f_query_add_mod.document.forms[0].submit();
		}
	 }
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/ChecklistItemsAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset(); 
}*/

function reset() {

	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ChecklistItemsAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("ChecklistItems.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ChecklistItemsQueryCriteria.jsp") != -1){
		f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	//commontoolbarFrame.document.forms[0].apply.disabled=true; //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/ChecklistItemsQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function acceptRemarksYN()
{
	if(document.forms[0].accept_remarks_yn.checked==true)
		document.forms[0].accept_remarks_yn.value="Y";
	else
		document.forms[0].accept_remarks_yn.value="N";

}

function makeListMandatory()
{

var checklistItem=getLabel("Common.defaultSelect.label","common");	

var frmObj=window.parent.frames[1];
var obj=document.forms[0];
var listVal=obj.checklist_type.value;
if(listVal=="L")
	{
	  obj.flag.disabled=false;
      obj.list_id.disabled=false;
	           
	}
 
	else if(listVal=="E" || listVal=="C")
	{

		obj.list_id.value="";
		obj.flag.disabled=true;
		obj.list_id.disabled=true;
		
		
	}
	
}

