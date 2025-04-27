function disable_code_desc()
{
	parent.frames[0].document.forms[0].loc_id.disabled=true;
	parent.frames[0].document.forms[0].loc_desc.disabled=false;
}

function change_val(obj)
{
	if(obj.value=="C")
	{
		parent.frames[0].document.forms[0].loc_id.disabled=false;
		parent.frames[0].document.forms[0].loc_desc.disabled=true;
		parent.frames[0].document.forms[0].loc_id.value=parent.frames[0].document.forms[0].loc_desc.value;
		parent.frames[0].document.forms[0].loc_desc.value='';
	}else
	{
		parent.frames[0].document.forms[0].loc_id.disabled=true;
		parent.frames[0].document.forms[0].loc_desc.disabled=false;
		parent.frames[0].document.forms[0].loc_desc.value=parent.frames[0].document.forms[0].loc_id.value;
		parent.frames[0].document.forms[0].loc_id.value='';
	}
}


function call_result_page(obj)
{
	 	
	var locn_type=parent.frames[0].document.forms[0].locn_type.value;
	var care_locn_ind=parent.frames[0].document.forms[0].care_locn_ind.value;
	var speciality_code=parent.frames[0].document.forms[0].speciality_code.value;
	var clinic_code=parent.frames[0].document.forms[0].loc_id.value;
	var clinic_desc=parent.frames[0].document.forms[0].loc_desc.value;
	var start_ends_contains=parent.frames[0].document.forms[0].start_ends_contains.value;
	var function_id=parent.frames[0].document.forms[0].function_id.value;
	var tab_Selected=parent.frames[0].document.forms[0].tab_Selected.value;
	var oper_stn_id=parent.frames[0].document.forms[0].oper_stn_id.value;
	var order_catalog_code=parent.frames[0].document.forms[0].order_catalog_code.value;
	var rd_appt_yn=parent.frames[0].document.forms[0].rd_appt_yn.value;
	var displayAll=parent.frames[0].document.forms[0].displayAll.value;
	if(parent.frames[0].document.forms[0].search_by[0].checked)
		var order_by = "D";
	else if(parent.frames[0].document.forms[0].search_by[1].checked)
		var order_by = "C";
	 
	 var url="../../eOA/jsp/OALocationlookupresult.jsp?clinic_code="+clinic_code+"&clinic_desc="+clinic_desc+"&start_ends_contains="+start_ends_contains+"&locn_type="+locn_type+"&speciality_code="+speciality_code+"&care_locn_ind="+care_locn_ind+"&search_click="+obj+"&function_id="+function_id+"&tab_Selected="+tab_Selected+"&oper_stn_id="+oper_stn_id+"&order_catalog_code="+order_catalog_code+"&rd_appt_yn="+rd_appt_yn+"&order_by="+order_by+"&displayAll="+displayAll;
	
	parent.frames[1].location.href=url;
}


function clear_result_page()
{
parent.frames[0].document.forms[0].loc_id.value='';
parent.frames[0].document.forms[0].loc_desc.value='';
parent.frames[0].document.forms[0].start_ends_contains.options.selectedIndex="S";

	parent.frames[1].location.href='../../eCommon/html/blank.html';
}


function retvalue(obj)
{
	var retval=obj;
	var return_value="";
	var rvalues=retval.split("~")
	var code=rvalues[0];
	var desc=rvalues[1];
	var open_to_all_pract=rvalues[2];
	var i=3;
	while(desc.split("+").length>1){
	desc=desc.replace("+"," ");
	}
	return_value=code+"~"+desc+"~"+open_to_all_pract;
	while(rvalues.length >3 && i<rvalues.length){
		return_value=return_value+"~"+rvalues[i];
		i=i+1;
	}
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = return_value;
	//alert(dialogBody.contentWindow.returnValue);
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
	//top.window.returnValue =return_value;
	//top.close();
}
