function recordLink(obj)
{
	var record_present = "N";
	if(obj.name=='record')
		document.forms[0].click_mode.value = "Record";
	else
		document.forms[0].click_mode.value = "Close";

	var total_no_of_record = document.forms[0].record_count.value;
	
	for(var i=1;i<=total_no_of_record;i++)
		{
			if(eval("document.forms[0].link_condition_"+i).checked==true && eval("document.forms[0].link_condition_"+i).disabled==false){
				eval("document.forms[0].link_code_chk"+i).value="Y";
				record_present = "Y";
			}
			else{
				eval("document.forms[0].link_code_chk"+i).value="N";
			}
		}
	if(record_present == "N"){
		alert(getMessage("APP-OH00079","OH"));
	}
	else{
		document.forms[0].submit();
		window.close();
	}
	
}


function selectAll()
{
	var total_no_of_record = parent.frames[1].document.forms[0].record_count.value;
	if(document.forms[0].chkAll.checked==true)
	{
		for(var i=1;i<=total_no_of_record;i++)
		{
			if(eval("parent.frames[1].document.forms[0].link_condition_"+i).disabled==false){
				eval("parent.frames[1].document.forms[0].link_condition_"+i).checked=true;
				eval("parent.frames[1].document.forms[0].link_code_chk"+i).value="Y";			
			}
		}
	}
	else
	{
		for(var i=1;i<=total_no_of_record;i++)
		{
			if(eval("parent.frames[1].document.forms[0].link_condition_"+i).disabled==false){
				eval("parent.frames[1].document.forms[0].link_condition_"+i).checked=false;
				eval("parent.frames[1].document.forms[0].link_code_chk"+i).value="N";			
			}
		}
	}
	
}

function checkAllRecord()
{
	var isAllChecked = true;
	var total_no_of_record = document.forms[0].record_count.value;
	for(var i=1;i<=total_no_of_record;i++)
		{
			if(eval("document.forms[0].link_condition_"+i).checked!=true)
				isAllChecked = false;			
		}
		if(isAllChecked && total_no_of_record>0)
			eval("parent.frames[0].document.forms[0].chkAll").checked=true;
}

