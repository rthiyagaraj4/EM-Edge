function reset()
{
	var query_string = BillReimbAmtFrame.frames[1].document.forms[0].query_string.value;

	BillReimbAmtFrame.location.href="../../eBL/jsp/BLBillReimburseAmtFrame.jsp?"+query_string;
 }	

function create()
{

}

function apply()
{
	
	var toc_rec = parent.window[3].window[1].window[1].document.getElementById('total_records').value;
	

	for(var i=0;i<toc_rec;i++)
	{
		
		var stup_reimb_YN = eval("parent.window[3].window[1].window[1].document.forms[0].stup_reimb_YN_"+i);
		var stup_reimb_type = eval("parent.window[3].window[1].window[1].document.forms[0].stup_reimb_type_hid_"+i);
		var stup_reimb_amt = eval(parent.window[3].window[1].window[1].document.getElementById('stup_reimb_amt_'+i));

		var rtn_stup_reimb_YN = eval("parent.window[3].window[1].window[1].document.forms[0].rtn_stup_reimb_YN_"+i);
		var rtn_stup_reimb_type = eval("parent.window[3].window[1].window[1].document.forms[0].rtn_stup_reimb_type_"+i);
		var rtn_stup_reimb_amt = eval("parent.window[3].window[1].window[1].document.forms[0].rtn_stup_reimb_amt_"+i);

		var curr_reimb_YN = eval("parent.window[3].window[1].window[1].document.forms[0].curr_reimb_YN_"+i);
		var curr_reimb_type = eval("parent.window[3].window[1].window[1].document.forms[0].curr_reimb_type_"+i);
		var curr_rev_amt = eval("parent.window[3].window[1].window[1].document.forms[0].curr_rev_amt_"+i);

		var rtn_curr_reimb_YN = eval("parent.window[3].window[1].window[1].document.forms[0].rtn_curr_reimb_YN_"+i);
		var rtn_curr_reimb_type = eval("parent.window[3].window[1].window[1].document.forms[0].rtn_curr_reimb_type_"+i);
		var rtn_curr_rev_amt = eval("parent.window[3].window[1].window[1].document.forms[0].rtn_curr_rev_amt_"+i);

		if(stup_reimb_YN.checked)
			rtn_stup_reimb_YN.value = "Y";
		else
			rtn_stup_reimb_YN.value = "N";

		rtn_stup_reimb_type.value = stup_reimb_type.value;
		rtn_stup_reimb_amt.value = stup_reimb_amt.innerText;

		if(curr_reimb_YN.checked)
			rtn_curr_reimb_YN.value = "Y";
		else
			rtn_curr_reimb_YN.value = "N";

		rtn_curr_reimb_type.value = curr_reimb_type.value;
		rtn_curr_rev_amt.value = curr_rev_amt.value;
	}

	parent.window[3].window[1].window[1].document.forms[0].target='submit_frame';
	parent.window[3].window[1].window[1].document.forms[0].action="../../servlet/eBL.BLBillReimburseAmtServlet";
	parent.window[3].window[1].window[1].document.forms[0].submit();
}
