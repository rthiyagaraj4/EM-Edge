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
	f_query_add_mod.location.href='../../eOT/jsp/OperationTypesAddModify.jsp?mode=insert';
}

function apply(){	
	var frm=f_query_add_mod.document.forms[0];
	//alert(frm.name);
	
	if(frm.mode.value=='modify' && frm.long_desc.disabled==true && frm.short_desc.disabled==true){
		var chk_box = frm.status;
		//alert(chk_box.checked)
		if(chk_box.checked==true){	
		frm.submit();
		} else {	
		var msg = getMessage("NO_CHANGE_TO_SAVE","common");
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
		}
	}else{
		var fields = new Array (f_query_add_mod.document.forms[0].oper_type,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
		var operationtype_title = getLabel("eOT.OperationType.Label","OT");
		var longdescription_title = getLabel("Common.longdescription.label","Common")
		var shortdescription_title = getLabel("Common.shortdescription.label","Common");
		var names = new Array (operationtype_title,longdescription_title, shortdescription_title);
		if(checkFieldsofMst( fields, names, messageFrame)){	
			frm.submit();
		}
	
		//messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
	}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/OperationTypesAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("OperationTypesAddModify.jsp") != -1){

		 if(f_query_add_mod.document.location.href.indexOf("OperationTypes.jsp") != -1)
			  return false;
		 else
			 f_query_add_mod.document.location.reload();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("OperationTypesQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	//commontoolbarFrame.document.forms[0].apply.disabled=true; //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/OperationTypesQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

