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
	f_query_add_mod.location.href='../../eOT/jsp/HoldingAreasAddModify.jsp?mode=insert';
}

function apply(){	
	var frm=f_query_add_mod.document.forms[0];
	var code=getLabel("Common.code.label","Common");
	var description=getLabel("Common.description.label","Common");

	if(frm!=null){
		if(frm.name=='query_form' || frm.name=='QueryResult'){
		}else{
			var fields = new Array (f_query_add_mod.document.forms[0].holding_area_code,f_query_add_mod.document.forms[0].holding_area_desc);
			var names = new Array (code,description);
			if(checkFieldsofMst( fields, names, messageFrame)) 
				{	
					f_query_add_mod.document.forms[0].submit();
				}
	}
	}else{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/HoldingAreasAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("HoldingAreasAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("HoldingAreas.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("HoldingAreasQueryCriteria.jsp") != -1)
	{
	f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOT/jsp/HoldingAreasQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function setCheckChargeBay()
{
	if(document.forms[0].chargeable_yn.checked==true)
		document.forms[0].chargeable_yn.value="Y";
	else
		document.forms[0].chargeable_yn.value="N";
}

