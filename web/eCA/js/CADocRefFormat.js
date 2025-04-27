function apply()
{
	var fields = new Array (
							f_query_add_mod.document.CADocRefFormatModify_form.document_type,
		                    f_query_add_mod.document.CADocRefFormatModify_form.refno_logic
							);

	var names = new Array (
						    getLabel("Common.documenttype.label",'common'),
		                    getLabel("eCA.RefNumLogic.label",'CA')
							);

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		var status = "S";
		var refno_logic = f_query_add_mod.document.CADocRefFormatModify_form.refno_logic.value;
		var strItemsArray;
		var tempText = f_query_add_mod.document.CADocRefFormatModify_form.refno_logic.value;
		var tempText2 = "";
		var temp1;
		var temp2;
		var temp3;

		if(refno_logic != null && refno_logic != '')
		{
			f_query_add_mod.document.CADocRefFormatModify_form.refno_logic.value = refno_logic;
			strItemsArray = refno_logic.split('~');
			for(i = 0 ; i<parseInt(strItemsArray.length,10)-1; i++)
			{
					temp1 = tempText.indexOf("~");
		            temp2 = tempText.indexOf('`');
		            temp3 = tempText.indexOf('`');
					temp1 = parseInt(temp1,10);
					temp2 = parseInt(temp2,10);				
					temp3 = parseInt(temp3,10);				
					temp2 = temp2 - temp1;			
					tempText2 = tempText.substr(parseInt(temp1,10)+1,parseInt(temp2,10)-1);
			        if(tempText2 != 'encounter_id' && tempText2 != 'practitioner_id' && tempText2 != 'accession_num' && tempText2 != 'date_and_time')
					{
						alert('Component Tampered');
						status = "F";
						break;
					}
			        tempText = tempText.substr(temp3+1);
			}
			
			if(status != 'F')
			{
				if((strItemsArray.length)-1 > 2)
				{
					var tempMsg = getMessage("REMARKS_CANNOT_EXCEED","Common");
					tempMsg = tempMsg.replace('$','Reference Number Logic');
					tempMsg = tempMsg.replace('#',40);
					var tempVar = window.confirm(tempMsg);
					if(tempVar == true)
						status = "S";
					else
					{
					  status = "F";
					}
				}
				else
				{
				  status = "S";
				}
			}
			else
			{
				status = "F";
			}
		}	
	}
	
	if(status == "S")
	{
		f_query_add_mod.document.CADocRefFormatModify_form.submit();
	}
	else
	{
		commontoolbarFrame.location.reload();
		return false;
	}
}

function reset() 
{
	f_query_add_mod.document.CADocRefFormatModify_form.reset() ;
}

function defineFormat(val)
{
	document.CADocRefFormatModify_form.refno_logic.value = document.CADocRefFormatModify_form.refno_logic.value+ val;
	if(val != '')
	{
		document.CADocRefFormatModify_form.refno_logic.value =  document.CADocRefFormatModify_form.refno_logic.value ;
	}
}

function showRefNum(obj)
{
	if(obj.value != '')	
		document.CADocRefFormatModify_form.refno_logic.value = obj.options[obj.selectedIndex].id ;
}

function chkTildeAndGA()
{
	var text = parseInt(event.keyCode);
	if(text == 126 || text == 96 || text == 39)
	{
		return false;
	}
}