function reset()
{
	interim_main.location.reload();
}

function run()
{
	alert(1);
	var err="";
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+err ;
	frames_list_body = frames[1].frames[1];
	frames_list_hdr = frames[1].frames[0];
	var total_records=frames_list_hdr.document.forms[0].total_records.value;
	
	if(total_records!=0)
	{
		var checked_row=frames_list_body.document.forms[0].checked_row.value;
		var total_records=frames_list_body.document.forms[0].total_records.value;
		
		if(checked_row=="")
		{		
			alert(getMessage("ATLEAST_ONE_SELECTED","common"));
			return false;
		}
		else
		{			
			for(var i=0;i<total_records;i++)
			{
				var selected_row=eval("frames_list_body.document.forms[0].selected_row"+i);
				if(selected_row.checked)
				{
					selected_row.value="1";	
				}
				else
				{
					selected_row.value="0";	
				}
				
				var adjust_dep =eval("frames_list_body.document.forms[0].adjust_dep"+i);
				var prepay_adj_yn =eval("frames_list_body.document.forms[0].prepay_adj_yn"+i);
						
				if(adjust_dep.checked)
				{
					adjust_dep.value="Y";	
				}
				else
				{
					adjust_dep.value="N";
				}

				if(prepay_adj_yn.checked)
				{
					prepay_adj_yn.value="Y";	
				}
				else
				{
					prepay_adj_yn.value="N";	
				}
			}		
		}
		frames_list_body.document.forms[0].action="../../servlet/eBL.BLInterimBillServlet" 
		frames_list_body.document.forms[0].submit();
	}
	else
	{
		err=getMessage("NO_RECORD_FOUND","common");
	}

	if(err!="")
	{
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+err ;
	}
}
