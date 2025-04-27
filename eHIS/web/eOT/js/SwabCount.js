/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function lockKey()
{
    if(event.keyCode == 93)
		alert(getMessage("APP-OT0084","OT"));
}

function addItems()
{
	var hdr_formObj = parent.f_swab_count_confirm_item.document.SwabCountItemConfirmForm;
	var reviewed_by	 = hdr_formObj.reviewed_by.value;
	var cnt = hdr_formObj.cnt.value;
	var formObj = parent.f_swab_count_dtls.document.SwabCountForm;
	var swab_count = formObj.swab_count.value;
	var complete_count = formObj.count.value;
	var allwdSwabCntsVal = formObj.allwdSwabCntsVal.value;
	var no_of_records = formObj.no_of_records.value;
	var current_item = formObj.current_item.value;
	var total_second_val_count = formObj.total_second_val_count.value;
	var totalThirdCount = formObj.totalThirdCount.value;
	var totalFourthCount = formObj.totalFourthCount.value;
	var totalFifthCount = formObj.totalFifthCount.value;
	var total_final_count = formObj.total_final_count.value;
	//Added against start PMG2017-MO-CRF-0001 [IN:063849]
	/* Added 2nd Count Completed*/	
	var second_chk = hdr_formObj.second_cnt_cmpl_yn.checked;
	var second_chk_dis = hdr_formObj.second_cnt_disabled.value;
	var add_aft_clcav_cmpl_yn_chk = hdr_formObj.add_aft_clcav_cmpl_yn.checked;
	var after_cavity_dis = hdr_formObj.after_cavity_disabled.value;
	if(allwdSwabCntsVal > 3){
	/* Added 3rd Count Completed*/
	var third_chk = hdr_formObj.third_cnt_cmpl_yn.checked;
	var third_chk_dis = hdr_formObj.third_cnt_cmpl_yn_disabled.value;
	var additions_after_3c_cmpl_yn_chk = hdr_formObj.addt_third_cnt_cmpl_yn.checked;
	var additions_after_3c_cmpl_yn_dis = hdr_formObj.additions_after_3c_cmpl_yn_disabled.value;
	}if(allwdSwabCntsVal > 4){
	/* Added 4th Count Completed*/
	var fourth_chk = hdr_formObj.fourth_cnt_cmpl_yn.checked;
	var fourth_chk_dis = hdr_formObj.fourth_cnt_cmpl_yn_disabled.value;
	var addt_fourth_cnt_cmpl_yn_chk = hdr_formObj.addt_fourth_cnt_cmpl_yn.checked;
	var additions_after_4c_cmpl_yn_dis = hdr_formObj.additions_after_4c_cmpl_yn_disabled.value;
	}if(allwdSwabCntsVal > 5){
	/* Added 5th Count Completed*/ 
	var fifth_chk = hdr_formObj.fifth_cnt_cmpl_yn.checked;
	var fifth_chk_dis = hdr_formObj.fifth_cnt_cmpl_yn_disabled.value;
	var addt_fifth_cnt_cmpl_yn_chk = hdr_formObj.addt_fifth_cnt_cmpl_yn.checked;
	var additions_after_5c_cmpl_yn_dis = hdr_formObj.additions_after_5c_cmpl_yn_disabled.value;
	}
	/* Added Final Count Completed*/
	var final_chk = hdr_formObj.final_cnt_cmpl_yn.checked;
	var final_chk_dis = hdr_formObj.final_cnt_disabled.value;
	for(row=1;row<=no_of_records;row++)
	{
		second_count_no	= eval("formObj.second_count_"+row);
		item_after_close_cavity_no = eval("formObj.item_after_close_cavity_"+row);
		total_cavity_count_no = eval("formObj.total_cavity_count_"+row);
		final_count_no = eval("formObj.final_count_"+row);

		if(second_count_no !="" && final_count_no=="" && item_after_close_cavity_no=="")
		{
			current_item = "second_cnt_cmpl_yn";
		}
		else if (final_count_no !="" &&  second_count_no=="" && item_after_close_cavity_no=="")
		{
			current_item = "final_cnt_cmpl_yn";
		}
		else if (item_after_close_cavity_no !="" && final_count_no =="" &&  second_count_no=="")
		{
			current_item = "add_aft_clcav_cmpl_yn";
		}
		else if(final_count_no.value !="" )
		{
			current_item = "final_cnt_cmpl_yn";
		}		
		
		if(total_final_count!="" && total_final_count.length > 0)
		{
			current_item = "final_cnt_cmpl_yn";
		} 
		if(second_chk == true && second_chk_dis != "disabled" )
		{
			current_item = "second_cnt_cmpl_yn";
		}
		if(add_aft_clcav_cmpl_yn_chk == true && after_cavity_dis != "disabled")
		{
			current_item = "add_aft_clcav_cmpl_yn";
		}
		if(third_chk == true && third_chk_dis != "disabled" )
		{
			current_item = "third_cnt_cmpl_yn";		
		}
 		if(additions_after_3c_cmpl_yn_chk == true && additions_after_3c_cmpl_yn_dis != "disabled" )
		{
			current_item = "additions_after_3c_cmpl_yn";		
		} 
		if(fourth_chk == true && fourth_chk_dis != "disabled" )
		{
			current_item = "fourth_cnt_cmpl_yn";		
		}
		if(addt_fourth_cnt_cmpl_yn_chk == true && additions_after_4c_cmpl_yn_dis != "disabled" )
		{
			current_item = "additions_after_4c_cmpl_yn";		
		}
		if(fifth_chk == true && fifth_chk_dis != "disabled" )
		{
			current_item = "fifth_cnt_cmpl_yn";		
		}	
		if(addt_fifth_cnt_cmpl_yn_chk == true && additions_after_5c_cmpl_yn_dis != "disabled" )
		{
			current_item = "additions_after_5c_cmpl_yn";		
		}
		if(final_chk == true && final_chk_dis != "disabled" && final_count_no.value !="" || (final_chk == true && final_chk_dis != "disabled"))
		{
		current_item = "final_cnt_cmpl_yn";	
	}	
	}

	//Added against end PMG2017-MO-CRF-0001 [IN:063849]

	var item_name = "";
	if(current_item == "first_cnt_cmpl_yn")
	{
		item_name = "formObj.first_count_";
		formObj.first_count_yn.value = "Y";
		formObj.item_stage.value = "F";
	}
	else if(current_item == "add_during_op_cmpl_yn")
	{
		item_name = "formObj.item_during_op_";
		formObj.additions_during_op.value = "OP";	
		formObj.item_stage.value = "O";
	}

	else if(current_item == "second_cnt_cmpl_yn")
	{
		item_name = "formObj.second_count_";
		formObj.second_count_yn.value="Y";
		formObj.item_stage.value = "S";
	}
	else if(current_item == "add_aft_clcav_cmpl_yn")
	{
		item_name = "formObj.item_after_close_cavity_";
		formObj.additions_during_op.value = "CL";
		formObj.item_stage.value = "C";		
	}
	else if(current_item == "third_cnt_cmpl_yn")
	{
		item_name = "formObj.third_count_";
		formObj.third_count_yn.value="Y";
		formObj.item_stage.value = "3";
	}
	else if(current_item == "additions_after_3c_cmpl_yn")
	{
		item_name = "formObj.add_after_third_count_";
		formObj.additions_during_op.value = "3C";
		formObj.item_stage.value = "3C";		
	}

	else if(current_item == "fourth_cnt_cmpl_yn")
	{
		item_name = "formObj.fourth_count_";
		formObj.fourth_count_yn.value="Y";
		formObj.item_stage.value = "4";
	}
	else if(current_item == "additions_after_4c_cmpl_yn")
	{
		item_name = "formObj.add_after_fourth_count_";
		formObj.additions_during_op.value = "4C";
		formObj.item_stage.value = "4C";		
	}

	else if(current_item == "fifth_cnt_cmpl_yn")
	{
		item_name = "formObj.fifth_count_";
		formObj.fifth_count_yn.value="Y";
		formObj.item_stage.value = "5";
	}
	else if(current_item == "additions_after_5c_cmpl_yn")
	{
		item_name = "formObj.add_after_fifth_count_";
		formObj.additions_during_op.value = "5C";
		formObj.item_stage.value = "5C";		
	}
	else if(current_item == "final_cnt_cmpl_yn")
	{
		item_name = "formObj.final_count_";
		formObj.final_count_yn.value="Y";
		formObj.item_stage.value = "L";
		formObj.reviewed_by.value=reviewed_by;
	}

	var remarks					= "";
	var remarks_exist			= "";
	var total_count_during_op	= "";
	var total_count_during_op_chk	= "";
	var current_item_count_obj	= "";	
	var current_item_count		= "";
	var mandatory_count_entry	= "";
	var mandatory_remarks_msg	= "";

	for(row=1;row<=no_of_records;row++)
	{
		eval("formObj.item_value_"+row).value = eval(item_name+row).value;

		// Check For Mandatory Review By applicable only for Final Count stage
		// Check For Mandatory Remarks for Second and Final Count

		if(current_item == "first_cnt_cmpl_yn")
		{
			total_count_during_op = eval("formObj.initial_count_val_"+row).value;
		}

		else if(current_item == "second_cnt_cmpl_yn" )
		{
			total_count_during_op = eval("formObj.total_count_during_op_"+row).value;
			total_count_during_op_chk = "formObj.total_cavity_count_";
		}
		else if(current_item == "third_cnt_cmpl_yn" )
		{
			total_count_during_op = eval("formObj.total_cavity_count_"+row).value;
			total_count_during_op_chk = "formObj.total_third_count_";
		}
		else if(current_item == "fourth_cnt_cmpl_yn" )
		{
			total_count_during_op = eval("formObj.total_third_count_"+row).value;
			total_count_during_op_chk = "formObj.total_fourth_count_";
		}
		else if(current_item == "fifth_cnt_cmpl_yn" )
		{
			total_count_during_op = eval("formObj.total_fourth_count_"+row).value;
			total_count_during_op_chk = "formObj.total_fifth_count_";
		}
		else if(current_item == "final_cnt_cmpl_yn")
		{
			if(allwdSwabCntsVal == '3')
				total_count_during_op = eval("formObj.total_cavity_count_"+row).value;
			else if(allwdSwabCntsVal == '4')
				total_count_during_op = eval("formObj.total_third_count_"+row).value;
			else if(allwdSwabCntsVal == '5')
				total_count_during_op = eval("formObj.total_fourth_count_"+row).value;
			else if(allwdSwabCntsVal == '6')
				total_count_during_op = eval("formObj.total_fifth_count_"+row).value;
		}
		//total_count_during_op = eval("formObj.total_count_during_op_"+row).value;//CRF-001 // commented for SKR-SCF-1196
		if(current_item == "first_cnt_cmpl_yn" || current_item == "second_cnt_cmpl_yn" || current_item == "third_cnt_cmpl_yn" ||
			current_item == "fourth_cnt_cmpl_yn" || current_item == "fifth_cnt_cmpl_yn" || current_item == "final_cnt_cmpl_yn")
		{
			if(total_count_during_op == null || total_count_during_op == "null")
				total_count_during_op = "0";
			if(total_count_during_op == " ")
				total_count_during_op = "";
			if(current_item == "first_cnt_cmpl_yn")
			{
				current_item_count_obj	= eval("formObj.first_count_"+row);
				mandatory_count_entry	= getMessage("APP-OT0086","OT")+" "+getLabel("eOT.FirstCount.Label","OT");
				mandatory_remarks_msg	= getMessage("APP-OT0087","OT")+" "+getLabel("eOT.FirstCount.Label","OT");
			}
			else if(current_item == "second_cnt_cmpl_yn")
			{
				current_item_count_obj	= eval("formObj.second_count_"+row);
				mandatory_count_entry	= getMessage("APP-OT0086","OT")+" "+getLabel("eOT.SecondCount.Label","OT");
				mandatory_remarks_msg	= getMessage("APP-OT0087","OT")+" "+getLabel("eOT.SecondCount.Label","OT");
			}
			else if(current_item == "third_cnt_cmpl_yn")
			{
				current_item_count_obj	= eval("formObj.third_count_"+row);
				mandatory_count_entry	= getMessage("APP-OT0086","OT")+" "+getLabel("eOT.ThirdCount.Label","OT");
				mandatory_remarks_msg	= getMessage("APP-OT0087","OT")+" "+getLabel("eOT.ThirdCount.Label","OT");
			}
			else if(current_item == "fourth_cnt_cmpl_yn")
			{
				current_item_count_obj	= eval("formObj.fourth_count_"+row);
				mandatory_count_entry	= getMessage("APP-OT0086","OT")+" "+getLabel("eOT.FourthCount.Label","OT");
				mandatory_remarks_msg	= getMessage("APP-OT0087","OT")+" "+getLabel("eOT.FourthCount.Label","OT");
			}
			else if(current_item == "fifth_cnt_cmpl_yn")
			{
				current_item_count_obj	= eval("formObj.fifth_count_"+row);
				mandatory_count_entry	= getMessage("APP-OT0086","OT")+" "+getLabel("eOT.FifthCount.Label","OT");
				mandatory_remarks_msg	= getMessage("APP-OT0087","OT")+" "+getLabel("eOT.FifthCount.Label","OT");
			}

			else if(current_item == "final_cnt_cmpl_yn")
			{
				current_item_count_obj	= eval("formObj.final_count_"+row);
				mandatory_count_entry	= getMessage("APP-OT0086","OT")+" "+getLabel("eOT.FinalCount.Label","OT");
				mandatory_remarks_msg	= getMessage("APP-OT0087","OT")+" "+getLabel("eOT.FinalCount.Label","OT");
			}
			current_item_count = current_item_count_obj.value;
			if(current_item_count == null || current_item_count == "null")
				current_item_count = "";

			if(current_item == "second_cnt_cmpl_yn")
			{
				if(parent.frames[0].document.forms[0].second_cnt_cmpl_yn.value == "Y")
				{
					if(total_count_during_op != "" && current_item_count == "")
					{
						alert(mandatory_count_entry);
						current_item_count_obj.focus();
						current_item_count_obj.select();
						return;
					}
				}
			}

			else if(current_item == "third_cnt_cmpl_yn")
			{
				if(parent.frames[0].document.forms[0].third_cnt_cmpl_yn.value == "Y")
				{
					if(total_count_during_op != "" && current_item_count == "")
					{
						alert(mandatory_count_entry);
						current_item_count_obj.focus();
						current_item_count_obj.select();
						return;
					}
				}
			}
			else if(current_item == "fourth_cnt_cmpl_yn")
			{
				if(parent.frames[0].document.forms[0].fourth_cnt_cmpl_yn.value == "Y")
				{
					if(total_count_during_op != "" && current_item_count == "")
					{
						alert(mandatory_count_entry);
						current_item_count_obj.focus();
						current_item_count_obj.select();
						return;
					}
				}
			}
			else if(current_item == "fifth_cnt_cmpl_yn")
			{
				if(parent.frames[0].document.forms[0].fifth_cnt_cmpl_yn.value == "Y")
				{
					if(total_count_during_op != "" && current_item_count == "")
					{
						alert(mandatory_count_entry);
						current_item_count_obj.focus();
						current_item_count_obj.select();
						return;
					}
				}
			}

			else if(current_item == "final_cnt_cmpl_yn")
			{
				if(parent.frames[0].document.forms[0].final_cnt_cmpl_yn.value == "Y")
				{
					if(total_count_during_op != "" && current_item_count == "")
					{
						alert(mandatory_count_entry);
						current_item_count_obj.focus();
						current_item_count_obj.select();
						return;
					}
				}
			}

			if(current_item == "second_cnt_cmpl_yn")
			{
				if(parent.frames[0].document.forms[0].second_cnt_cmpl_yn.value == "Y")
				{
					if(parseInt(current_item_count) != parseInt(total_count_during_op) )
					{
						remarks = eval("formObj.new_remarks_"+row).value;
						remarks_exist = eval("formObj.second_count_remarks_yn_"+row).value;
						if(remarks == null || remarks == "null")
							remarks = "";
						if((total_count_during_op !="" && current_item_count != "") || (total_count_during_op  == "" && current_item_count != ""))
						{
							if(remarks == "" && remarks_exist == "N")
							{	
								alert(mandatory_remarks_msg);
								current_item_count_obj.focus();
								current_item_count_obj.select();
								return;
							}
						}
					}
				}
			}

			else if(current_item == "third_cnt_cmpl_yn")
			{
				if(parent.frames[0].document.forms[0].third_cnt_cmpl_yn.value == "Y")
				{						
				 if(total_second_val_count!="" && total_second_val_count.length > 0) {
					//total_count_during_op = parseInt(total_second_val_count);						
					for(i=1;i<=no_of_records;i++){
					total_count_during_op = (eval("formObj.old_item_after_cc_"+row).value);
					}
					}
					if(parseInt(current_item_count) != parseInt(total_count_during_op))
					{
						remarks = eval("formObj.new_remarks_"+row).value;
						remarks_exist = eval("formObj.third_count_remarks_yn_"+row).value;
						if(remarks == null || remarks == "null")
							remarks = "";
						if((total_count_during_op !="" && current_item_count != "") || (total_count_during_op  == "" && current_item_count != ""))
						{
							if(remarks == "" && remarks_exist == "N")
							{
								alert(mandatory_remarks_msg);
								current_item_count_obj.focus();
								current_item_count_obj.select();
								return;
							}
						}
					}
				}
			}

			else if(current_item == "fourth_cnt_cmpl_yn")
			{
				if(parent.frames[0].document.forms[0].fourth_cnt_cmpl_yn.value == "Y")
				{
					if(totalThirdCount!= "" && totalThirdCount.length > 0) // Allowed 4th scenario
					{
						//total_count_during_op = totalThirdCount;
					for(i=1;i<=no_of_records;i++){
						total_count_during_op = (eval("formObj.old_item_after_3c_"+row).value);
					}
					}
					if(totalFourthCount!= "" && totalFourthCount.length > 0) // Allowed 5 scenario
					{
						//total_count_during_op = totalFourthCount;
					
					for(i=1;i<=no_of_records;i++){
						total_count_during_op = (eval("formObj.old_item_after_4c_"+row).value);
					}
					} 
					if(parseInt(current_item_count) != parseInt(total_count_during_op))
					{
						remarks = eval("formObj.new_remarks_"+row).value;
						remarks_exist = eval("formObj.fourth_count_remarks_yn_"+row).value;
						if(remarks == null || remarks == "null")
							remarks = "";
						if((total_count_during_op !="" && current_item_count != "") || (total_count_during_op  == "" && current_item_count != ""))
						{
							if(remarks == "" && remarks_exist == "N")
							{
								alert(mandatory_remarks_msg);
								current_item_count_obj.focus();
								current_item_count_obj.select();
								return;
							}
						}
					}
				}
			}

			else if(current_item == "fifth_cnt_cmpl_yn")
			{
				if(parent.frames[0].document.forms[0].fifth_cnt_cmpl_yn.value == "Y")
				{
				 if(totalFourthCount!= "" && totalFourthCount.length>0) // Allowed 5 scenario
					{
						//total_count_during_op = totalFourthCount;
						for(i=1;i<=no_of_records;i++){
						total_count_during_op = (eval("formObj.old_item_after_4c_"+row).value);
						}	
					} 
					if(parseInt(current_item_count) != parseInt(total_count_during_op))
					{
						remarks = eval("formObj.new_remarks_"+row).value;
						remarks_exist = eval("formObj.fifth_count_remarks_yn_"+row).value;
						if(remarks == null || remarks == "null")
							remarks = "";
						if((total_count_during_op !="" && current_item_count != "") || (total_count_during_op  == "" && current_item_count != ""))
						{
							if(remarks == "" && remarks_exist == "N")
							{	
								alert(mandatory_remarks_msg);
								current_item_count_obj.focus();
								current_item_count_obj.select();
								return;
							}
						}
					}
				}
			}

			else if(current_item == "final_cnt_cmpl_yn")
			{
				if(parent.frames[0].document.forms[0].final_cnt_cmpl_yn.value == "Y")
				{				
				if(total_second_val_count!= "" && total_second_val_count.length>0){ // Allowed 3rd scenario
				//total_count_during_op = total_second_val_count;					
					//if(allwdSwabCntsVal == 3){
					for(i=1;i<=no_of_records;i++){
						total_count_during_op = (eval("formObj.old_item_after_cc_"+row).value);	
					}
					//}
					} 
					if(totalThirdCount!= "" && totalThirdCount.length>0){ // Allowed 4th scenario
					//total_count_during_op = totalThirdCount;
					//if(allwdSwabCntsVal == 4){
					for(i=1;i<=no_of_records;i++){
						total_count_during_op = (eval("formObj.old_item_after_3c_"+row).value);
					}
				//	}
					}
					if(totalFourthCount!= "" && totalFourthCount.length>0){ // Allowed 5 scenario
						//total_count_during_op = totalFourthCount;
					//if(allwdSwabCntsVal == 5){
					for(i=1;i<=no_of_records;i++){
						total_count_during_op = (eval("formObj.old_item_after_4c_"+row).value);
					}	
					//}
					}
					if(totalFifthCount!= "" && totalFifthCount.length>0){ // Allowed 5 scenario
					//total_count_during_op = totalFifthCount;
					//if(allwdSwabCntsVal == 6){
					for(i=1;i<=no_of_records;i++){
						total_count_during_op = (eval("formObj.old_item_after_5c_"+row).value);
					}
					//}
					}			
					if(parseInt(current_item_count) != parseInt(total_count_during_op))
					{
						remarks = eval("formObj.new_remarks_"+row).value;
						remarks_exist = eval("formObj.final_count_remarks_yn_"+row).value;
						if(remarks == null || remarks == "null")
							remarks="";
						if((total_count_during_op !="" && current_item_count!="") || (total_count_during_op == "" && current_item_count!=""))
						{
							if(remarks == "" && remarks_exist == "N")
							{
								alert(mandatory_remarks_msg);
								current_item_count_obj.focus();
								current_item_count_obj.select();
								return;
							}
						}
					}
				}
			}
		}
	}
	formObj.first_cnt_cmpl_yn.value = hdr_formObj.first_cnt_cmpl_yn.value;
	formObj.additions_during_op_cmpl_yn.value = hdr_formObj.add_during_op_cmpl_yn.value;
	formObj.second_cnt_cmpl_yn.value = hdr_formObj.second_cnt_cmpl_yn.value;
	formObj.additions_aft_clcav_cmpl_yn.value = hdr_formObj.add_aft_clcav_cmpl_yn.value;

	if(current_item == "third_cnt_cmpl_yn" )
	formObj.third_cnt_cmpl_yn.value = hdr_formObj.third_cnt_cmpl_yn.value;
	else if(current_item == "additions_after_3c_cmpl_yn" )
	formObj.add_after_third_count.value = hdr_formObj.addt_third_cnt_cmpl_yn.value;
	else if(current_item == "fourth_cnt_cmpl_yn" )
	formObj.fourth_cnt_cmpl_yn.value = hdr_formObj.fourth_cnt_cmpl_yn.value;
	else if(current_item == "additions_after_4c_cmpl_yn" )
	formObj.add_after_fourth_count.value = hdr_formObj.addt_fourth_cnt_cmpl_yn.value;
	else if(current_item == "fifth_cnt_cmpl_yn" )
	formObj.fifth_cnt_cmpl_yn.value = hdr_formObj.fifth_cnt_cmpl_yn.value;
	else if(current_item == "additions_after_5c_cmpl_yn" )
	formObj.add_after_fifth_count.value = hdr_formObj.addt_fifth_cnt_cmpl_yn.value;

	formObj.final_cnt_cmpl_yn.value = hdr_formObj.final_cnt_cmpl_yn.value;

	formObj.action="../../servlet/eOT.SwabCountServlet";
	if(current_item == "final_cnt_cmpl_yn" && hdr_formObj.final_cnt_cmpl_yn.value == "Y")
	{
		if(parseInt(cnt) == 0)
			alert(getMessage("APP-OT0125","OT"));
		else if(reviewed_by == "")
		{
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			var reviewedby=getLabel("eOT.ReviewedBy.Label","OT");
			alert(msgArray[0]+reviewedby+msgArray[1]);
			hdr_formObj.reviewed_by.focus();
			return;
		}
		else
		{
			formObj.submit();
		}
	}
	else
	{
		formObj.submit();
	}
	parent.f_swab_count_record.document.SwabCountRecordForm.record.disabled=true;
}

/* This function used Check and UnCheck for 2 Check Boxes */
function control(check,obj){
	var hdr_formObj = parent.f_swab_count_confirm_item.document.SwabCountItemConfirmForm;
	var formObj = parent.f_swab_count_dtls.document.SwabCountForm;
	/* Added for 2nd Count Completed*/	
	var second_cnt_checked = hdr_formObj.second_cnt_checked.value;
	var second_cnt_disabled = hdr_formObj.second_cnt_disabled.value;
	var second_cnt_cmpl_yn =document.getElementById("second_cnt_cmpl_yn"); // check value = 1	
	var after_cavity_checked = hdr_formObj.after_cavity_checked.value;	// check value = 2
	var after_cavity_disabled = hdr_formObj.after_cavity_disabled.value;
	var add_aft_clcav_cmpl_yn =document.getElementById("add_aft_clcav_cmpl_yn");
	/* Added for 3rd Start Count Completed*/
	var third_cnt_cmpl_yn_chked = hdr_formObj.third_cnt_cmpl_yn_chked.value;
	var third_cnt_cmpl_yn_disabled = hdr_formObj.third_cnt_cmpl_yn_disabled.value;
	var third_cnt_cmpl_yn =document.getElementById("third_cnt_cmpl_yn");
	var additions_after_3c_cmpl_yn_chked = hdr_formObj.additions_after_3c_cmpl_yn_chked.value;
	var additions_after_3c_cmpl_yn_disabled = hdr_formObj.additions_after_3c_cmpl_yn_disabled.value;
	var addt_third_cnt_cmpl_yn = document.getElementById("addt_third_cnt_cmpl_yn");
	/* Added for 4th Start Count Completed*/
	var fourth_cnt_cmpl_yn_chked = hdr_formObj.fourth_cnt_cmpl_yn_chked.value;
	var fourth_cnt_cmpl_yn_disabled = hdr_formObj.fourth_cnt_cmpl_yn_disabled.value;
	var fourth_cnt_cmpl_yn =document.getElementById("fourth_cnt_cmpl_yn");
	var additions_after_4c_cmpl_yn_chked = hdr_formObj.additions_after_4c_cmpl_yn_chked.value;
	var additions_after_4c_cmpl_yn_disabled = hdr_formObj.additions_after_4c_cmpl_yn_disabled.value;
	var addt_fourth_cnt_cmpl_yn =document.getElementById("addt_fourth_cnt_cmpl_yn");
	/* Added for 5th Start Count Completed*/
	var fifth_cnt_cmpl_yn_chked = hdr_formObj.fifth_cnt_cmpl_yn_chked.value;
	var fifth_cnt_cmpl_yn_disabled = hdr_formObj.fifth_cnt_cmpl_yn_disabled.value;
	var fifth_cnt_cmpl_yn =document.getElementById("fifth_cnt_cmpl_yn");
	var additions_after_5c_cmpl_yn_chked = hdr_formObj.additions_after_5c_cmpl_yn_chked.value;
	var additions_after_5c_cmpl_yn_disabled = hdr_formObj.additions_after_5c_cmpl_yn_disabled.value;
	var addt_fifth_cnt_cmpl_yn =document.getElementById("addt_fifth_cnt_cmpl_yn");
	/* Added for Final Start Count Completed*/
	var final_cnt_cmpl_yn=document.getElementById("final_cnt_cmpl_yn");
	var allwdSwabCntsVal = formObj.allwdSwabCntsVal.value;

	if(allwdSwabCntsVal >=3){
	if(second_cnt_checked=="" && second_cnt_disabled=="" && second_cnt_cmpl_yn.checked==true && final_cnt_cmpl_yn.checked==true){
		if(check==1 || check==3){
final_cnt_cmpl_yn.checked=false;
			if(final_cnt_cmpl_yn.checked==false){
				obj="N";
				reviwedbyCheckBoxvalue(obj);
				checkRefresh(obj);
			}
}else if(check==9){
second_cnt_cmpl_yn.checked=false;
			checkRefresh(obj);
		}
}else if(after_cavity_checked=="" && after_cavity_disabled=="" && add_aft_clcav_cmpl_yn.checked==true &&	final_cnt_cmpl_yn.checked==true){	
			if(check==2 || check==4){
final_cnt_cmpl_yn.checked=false;
			if(final_cnt_cmpl_yn.checked==false){
				obj="N";
				reviwedbyCheckBoxvalue(obj);
				checkRefresh(obj);
				}
}
	else if(check==9){
add_aft_clcav_cmpl_yn.checked=false;
				checkRefresh(obj);
			}
}
}
	if(allwdSwabCntsVal>=4){
	if(third_cnt_cmpl_yn_chked=="" && third_cnt_cmpl_yn_disabled=="" && third_cnt_cmpl_yn.checked==true && 
   	final_cnt_cmpl_yn.checked==true){
			if(check==3){
final_cnt_cmpl_yn.checked=false;
			if(final_cnt_cmpl_yn.checked==false){
				obj="N";
				reviwedbyCheckBoxvalue(obj);
				checkRefresh(obj);
			}
}else if(check==9){
third_cnt_cmpl_yn.checked=false;
				checkRefresh(obj);
			}
}else if(additions_after_3c_cmpl_yn_chked=="" && additions_after_3c_cmpl_yn_disabled=="" && 
	addt_third_cnt_cmpl_yn.checked==true && final_cnt_cmpl_yn.checked==true){		
			if(check==4){
final_cnt_cmpl_yn.checked=false;
			if(final_cnt_cmpl_yn.checked==false){
					obj="N";
					reviwedbyCheckBoxvalue(obj);
					checkRefresh(obj);
				}
}
		else if(check==9){
addt_third_cnt_cmpl_yn.checked=false;
				checkRefresh(obj);
			}
		}
	}
	if(allwdSwabCntsVal>=5){
		if (fourth_cnt_cmpl_yn_chked=="" && fourth_cnt_cmpl_yn_disabled=="" && fourth_cnt_cmpl_yn.checked==true &&	final_cnt_cmpl_yn.checked==true){
			if(check==3){
final_cnt_cmpl_yn.checked=false;
			if(final_cnt_cmpl_yn.checked==false){
				obj="N";
				reviwedbyCheckBoxvalue(obj);
				checkRefresh(obj);
			}
}else if(check==9){
fourth_cnt_cmpl_yn.checked=false;
				checkRefresh(obj);
			}		
}else if(additions_after_4c_cmpl_yn_chked=="" && additions_after_4c_cmpl_yn_disabled=="" && addt_fourth_cnt_cmpl_yn.checked==true && final_cnt_cmpl_yn.checked==true){
			if(check==4){
final_cnt_cmpl_yn.checked=false;
			if(final_cnt_cmpl_yn.checked==false){
					obj="N";
					reviwedbyCheckBoxvalue(obj);
					checkRefresh(obj);
				}
}else if(check==9){
addt_fourth_cnt_cmpl_yn.checked=false;
				checkRefresh(obj);
			}
	}
  }
  if(allwdSwabCntsVal>=6){
	if (fifth_cnt_cmpl_yn_chked=="" && fifth_cnt_cmpl_yn_disabled=="" && fifth_cnt_cmpl_yn.checked==true &&
	final_cnt_cmpl_yn.checked==true){
			if(check==3){
final_cnt_cmpl_yn.checked=false;
			if(final_cnt_cmpl_yn.checked==false){
				obj="N";
				reviwedbyCheckBoxvalue(obj);
				checkRefresh(obj);
			}
}else if(check==9){
fifth_cnt_cmpl_yn.checked=false;
				checkRefresh(obj);
			}		
}else if(additions_after_5c_cmpl_yn_chked=="" && additions_after_5c_cmpl_yn_disabled=="" && addt_fifth_cnt_cmpl_yn.checked==true && final_cnt_cmpl_yn.checked==true){
			if(check==4){
final_cnt_cmpl_yn.checked=false;
			if(final_cnt_cmpl_yn.checked==false){
				obj="N";
				reviwedbyCheckBoxvalue(obj);
				checkRefresh(obj);	
			}
}else if(check==9){
addt_fifth_cnt_cmpl_yn.checked=false;
					checkRefresh(obj);
			}		
	}		
	}
}

function checkRefresh(value)
{
	var formObj = parent.f_swab_count_dtls.document.SwabCountForm;
	formObj.submit(); 
}

function assignCheckboxValue(obj){
	if(obj.checked == true)
		obj.value="Y";
	else
		obj.value="N";
}

async function viewSwabCountRemarks(rownum)
{
	var formObj = document.SwabCountForm;
	var allwdSwabCntsVal = formObj.allwdSwabCntsVal.value;
	var viewrem_val=encodeURIComponent(getLabel("eOT.ViewRemarks.Label","OT"));
	var remarks_title = viewrem_val+eval("formObj.item_desc_"+rownum).value;
	var oper_num = formObj.oper_num.value;
	var swab_serial_number = formObj.swab_serial_number.value;	
	var template_id = eval("formObj.template_id_"+rownum).value;
	var item_code = eval("formObj.item_code_"+rownum).value;
	var dialogHeight	= "70vh";
	var dialogWidth		= "50vw";
	var dialogTop		= "0";
	var dialogLeft		= "80";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal = await top.window.showModalDialog("../../eOT/jsp/SwabCountViewRemarks.jsp?oper_num="+oper_num+"&remarks_title="+remarks_title+"&item_code="+item_code+"&template_id="+template_id+"&swab_serial_number="+swab_serial_number+"&allwdSwabCntsVal="+allwdSwabCntsVal,arguments, features);
}

/* Modified By Yadav  for 13039  */
function recordSwabVerify()
{	
	var flag=true;
	var txtremarks=parent.frames[0].document.forms[0].new_remarks.value;
	var suppremarks=parent.frames[0].document.forms[0].supplementary_set.value;
	var basic_setremarks=parent.frames[0].document.forms[0].basic_set.value;
	var size="500";
	
	txtremarks=TrimStr(txtremarks);
	suppremarks=TrimStr(suppremarks);
	basic_setremarks=TrimStr(basic_setremarks);	

	if(parseInt(basic_setremarks.length) > parseInt(size))
		{
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			var errors = max_len_msg_arr[0]+getLabel("eOT.BasicSet.Label","OT")+max_len_msg_arr[1]+size+max_len_msg_arr[2];
			alert(errors)
			parent.frames[0].document.forms[0].basic_set.value="";
			flag=false;
		}else{
			flag=true;
		}
	
	if(flag==true)
		{ 
		if(parseInt(suppremarks.length) > parseInt(size)){
				var max_len = getMessage("MAX_LENGTH_DATA","OT");
				var max_len_msg_arr = max_len.split("#");
				var errors = max_len_msg_arr[0]+getLabel("eOT.SupplementaryItem.Label","OT")+max_len_msg_arr[1]+size+max_len_msg_arr[2];
				alert(errors)
				parent.frames[0].document.forms[0].supplementary_set.value="";
				flag=false;
			}else{
				flag=true;
			}
		}
	
	if(flag==true)
		{ 
		if(parseInt(txtremarks.length) > parseInt(size)){
				var max_len = getMessage("MAX_LENGTH_DATA","OT");
				var max_len_msg_arr = max_len.split("#");
				var errors = max_len_msg_arr[0]+" "+max_len_msg_arr[1]+size+max_len_msg_arr[2];
				alert(errors)
				parent.frames[0].document.forms[0].new_remarks.value="";
				flag=false;
			}else{
				flag=true;
			}
		}
	if(flag==true)
		{
			var formObj = parent.f_verify_details.SwabCountVerifyForm;
			formObj.action="../../servlet/eOT.SwabCountVerifyServlet";
			formObj.submit();
		}
}

function assignSwabVerifyCheckboxValues(obj)
{
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
}

async function openSwabVerifyRemarksWindow(formObj,remarks_title)
{
	var old_remarks = formObj.old_remarks.value;
	var new_remarks = formObj.new_remarks.value;
	// remarks_title is modified here for Thai
	var remarks_title = encodeURIComponent(getLabel("Common.remarks.label","Common"));
	var dialogHeight	= "27";
	var dialogWidth		= "38";
	var dialogTop		= "110";
	var dialogLeft		= "350";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal = await window.showModalDialog("../../eOT/jsp/ExamsCheckListRemarks.jsp?remarks_title="+remarks_title+"&old_remarks="+old_remarks+"&new_remarks="+new_remarks+"&checklist_completed_yn=N",arguments, features);
	if(retVal!=null && retVal!="undefined" && retVal!="null")
		formObj.new_remarks.value = retVal;
}

async function openSwabCountRemarksWindow(formObj, remarks_title, rownum,size)
{
	var old_remarks = eval("formObj.old_remarks_"+rownum).value;
	var new_remarks = eval("formObj.new_remarks_"+rownum).value;
	new_remarks = encodeURIComponent(new_remarks);
	old_remarks = encodeURIComponent(old_remarks);

	var remarks_title =encodeURIComponent(getLabel("Common.remarks.label","Common"));
	var dialogHeight	= "18";
	var dialogWidth		= "29";
	var dialogTop		= "200";
	var dialogLeft		= "350";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal = await window.showModalDialog("../../eOT/jsp/ExamsCheckListRemarks.jsp?remarks_title="+remarks_title+"&old_remarks="+old_remarks+"&new_remarks="+new_remarks+"&swab_count_remarks=NO_OLD_REMARKS&checklist_completed_yn=N"+'&size='+size,arguments, features);
	if(retVal!=null && retVal!="undefined" && retVal!="null")
		eval("formObj.new_remarks_"+rownum).value = retVal;
}

function assignNewRemarks(formObj)
{
	var formObj = document.ExamsCheckListRemarksForm;
	window.returnValue = formObj.new_remarks.value;
	window.close();
}

function recordPersonnelData()
{	
	var frmObj = parent.RecordFrame;
	var recordFormObj = parent.RecordFrame.RecordFrame.PersonnelRecordForm;
	//var msg = "No Changes to Commit..";
	var msg = getMessage("NO_CHANGE_TO_SAVE","common");
	var doc_complete = "N";
	var params = recordFormObj.params.value;
	var oper_num = recordFormObj.oper_num.value;
	var doc_level = recordFormObj.doc_level.value;
	var theatre_code ="";
	var param = params+"&doc_level="+doc_level+"&oper_num="+oper_num+"&theatre_code="+theatre_code+"&doc_complete="+doc_complete;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root>";
	var action = '../../servlet/eOT.RecordNursingServlet?'+param;
	xmlStr+=frmObj.createXMLForPersonnel1(oper_num);
	xmlStr+="</root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",action,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal!=null && retVal!="" && retVal!="undefined")
	{
	   if(retVal == "RECORD_INSERTED")
		 {
			  var msg1 = getMessage("RECORD_INSERTED","SM");
			  parent.parent.f_tab_frames.changeTab('PERSONNELDTLS');
			  alert(msg1);
			 //parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg1;
	   }else
		{
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+retVal;
	    }
	}else
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
}

function callPopulateList(flag)
{
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var formObj = document.forms[0];
	var params = formObj.params.value;
	params = params+"&flag="+flag;
	var temp_jsp="../../servlet/eOT.PopulateListItemServlet?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	eval(responseText);
}

function assignListItems(code,desc)
{
	  var formObj=document.forms[0];
	  var descArr=new Array();
	  var codeArr=new Array();
	  descArr=desc.split(",");
	  codeArr=code.split(",");		  
	  listObj=formObj.speciality;
	  var len=0;
	  len=listObj.length-1;
	  //List Box length starts from 1 where as array starts from 0
	  for( var co=len;co>=0; co--){
		listObj.remove(co);
	  }
	  for(len=0;len<=codeArr.length-1;len++){
			listObj.options[len]=new Option(descArr[len],codeArr[len]);
	  }
}

function CheckSwabCountNumber(obj,op_cl_flag,rownum)
{
	var formObj = document.SwabCountForm;
	var min_value_to_check = "0";
	if(op_cl_flag == "OP")
		min_value_to_check = eval("formObj.old_item_during_op_"+rownum).value;
	else if(op_cl_flag == "CL")
		min_value_to_check = eval("formObj.old_item_after_cc_"+rownum).value;
	else if(op_cl_flag == "3C")
		min_value_to_check = eval("formObj.old_item_after_3c_"+rownum).value;
	else if(op_cl_flag == "4C")
		min_value_to_check = eval("formObj.old_item_after_4c_"+rownum).value;
	else if(op_cl_flag == "5C")
		min_value_to_check = eval("formObj.old_item_after_5c_"+rownum).value;
	var swab_value = obj.value;
	var len = swab_value.length;
	if(swab_value != "")
	{
		var minusOccurance = swab_value.indexOf('-');
		if(minusOccurance > 0)
		{
			//alert("Minus symbol should be in the beginning of the number entered");
			alert(getMessage("APP-OT0064","OT"));
			obj.select();
			obj.focus();
			return false;
		}
		else if(minusOccurance == 0)
		{
			if(len==1)
			{
	            alert(getMessage("NUM_ALLOWED","SM"));
				obj.select();
				obj.focus();
				return false;
			}
			if(parseInt(obj.value) + parseInt(min_value_to_check) < 0)
			{
	            //alert("Cannot deduct items more than the total additions for the item, "+min_value_to_check);
				alert(getMessage("APP-OT0065","OT") + min_value_to_check);
				obj.select();
				obj.focus();
				return false;
			}
			swab_value = swab_value.substring(1, len);
		}
		else if(parseInt(obj.value) + parseInt(min_value_to_check) > 999)
		{
			alert(getMessage("APP-OT0232","OT"));
			obj.select();
			obj.focus();
			return false;
		}
		var flag = CheckForNumber(swab_value);
		if(flag == false)
		{
			obj.select();
			obj.focus();
		}
		var plusOccurance = swab_value.indexOf('+');
		if(plusOccurance == 0)
			obj.value = (obj.value).substring(1, len);
	}
}

function changeColor(i, obj, valToChkColor)
{
	var enter_val = trimString(obj.value);
	var formObj = document.forms[0];
	var count;
	var complete_count = formObj.count.value;
	var swab_count = formObj.swab_count.value;
	var allwdSwabCntsVal = formObj.allwdSwabCntsVal.value;
	var op_count = "formObj.old_item_during_op_"+i;
	var sec_tot = "formObj.old_item_after_cc_"+i;
	var thrid_count = "formObj.old_item_after_3c_"+i;
	var fourth_count = "formObj.old_item_after_4c_"+i;
	var fifth_count = "formObj.old_item_after_5c_"+i;
	var op_count = trimString(eval(op_count).value);
	var sec_tot = trimString(eval(sec_tot).value);
	var thrid_count = trimString(eval(thrid_count).value);
	var fourth_count = trimString(eval(fourth_count).value);
	var fifth_count = trimString(eval(fifth_count).value);
	if(valToChkColor == 'OP')
		count = "formObj.total_count_during_op_"+i;
	else if(valToChkColor == 'CL')
		count = "formObj.total_cavity_count_"+i;
	else if(valToChkColor == '3C')
		count = "formObj.total_third_count_"+i;
	else if(valToChkColor == '4C')
		count = "formObj.total_fourth_count_"+i;
	else if(valToChkColor == '5C')
		count = "formObj.total_fifth_count_"+i;
	var tot = trimString(eval(count).value);
	if(allwdSwabCntsVal == 3 && swab_count ==2 && complete_count >= 1 ){
		if(tot == "" || tot.length == 0){
			tot = op_count;
		}
	}	
	if(allwdSwabCntsVal >= 4 && swab_count >=2 && complete_count >= 1 ){	
		if(op_count != "" && op_count.length > 0 && sec_tot =="" && sec_tot.length ==0 && thrid_count=="" && thrid_count.length== 0){
			tot = op_count;
	}else if(op_count != "" && op_count.length > 0 && sec_tot !="" && sec_tot.length > 0 && thrid_count=="" && thrid_count.length== 0){
		if(tot == "" || tot.length == 0)	
		tot = sec_tot;
		}
	else if(op_count != "" && op_count.length > 0 && sec_tot !="" && sec_tot.length > 0 && thrid_count!="" && thrid_count.length > 0 && fourth_count=="" && fourth_count.length== 0){
			if(tot == "" || tot.length == 0)	
			tot = thrid_count;
		} 
	else if(op_count != "" && op_count.length > 0 && sec_tot !="" && sec_tot.length > 0 && thrid_count!="" && thrid_count.length > 0 && fourth_count!="" && fourth_count.length > 0 && fifth_count == "" && fifth_count.length == 0 ){
			if(tot == "" || tot.length == 0)	
			tot = fourth_count;
		}
	else if(op_count != "" && op_count.length > 0 && sec_tot !="" && sec_tot.length > 0 && thrid_count!="" && thrid_count.length > 0 && fourth_count!="" && fourth_count.length > 0 && fifth_count!="" &&  fifth_count.length > 0){
			if(tot == "" || tot.length == 0)	
			tot = fifth_count;
		}		
	}
	obj.style.color = "#400040";
	if(enter_val != tot)
		obj.style.color="#FF0033";
	else
		obj.style.color="#400040";
}

function changeColor1(i, obj)
{ 
	var enter_val = trimString(obj.value);
	var formObj = document.forms[0];
	var count = "formObj.total_cavity_count_"+i;
	var tot = trimString(eval(count).value);
	obj.style.color="#400040";
	if(enter_val != tot)
		obj.style.color = "#FF0033";
	else
		obj.style.color = "#400040";
}

function reasonToolTip(arrMsg)
{
	var arr=new Array();
	arr=arrMsg.split(",");
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	var id_name_colval  = arr[0];	
	tab_dat     += "<tr>"
	tab_dat     += "<td   nowrap > <B>"+id_name_colval + " </B> </a> </td>"
	tab_dat     += "</tr> ";

	for( cou=1;cou<arr.length;cou++)
	{
		msg=arr[cou];
		tab_dat     += "<tr>"
		tab_dat     += "<td class='label' > <B>"+msg+ " </B> </a> </td>"		
		tab_dat     += "</tr> ";	
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer1").innerHTML = tab_dat;
	resizeWindow1();
}

function resizeWindow1()
{
	bodwidth = parent.frames[1].document.body.offsetWidth
	bodheight = parent.frames[1].document.body.offsetHeight

	var x =event.x
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer1").offsetWidth)
	y = y + (document.getElementById("tooltiplayer1").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer1").offsetWidth*1)

	if(y<bodheight)
	{
		 y =event.y
	}else
	{
		y = y - (document.getElementById("tooltiplayer1").offsetHeight*1)
	}

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer1").style.posLeft= x-35
	document.getElementById("tooltiplayer1").style.posTop = y-35
	document.getElementById("tooltiplayer1").style.visibility='visible'
}

function hideToolTip1()
{
	document.getElementById("tooltiplayer1").style.visibility = 'hidden';
}

function addNewSwabCount()
{
	var formObj = parent.f_header.document.SwabCountHeaderForm;
	var params = formObj.params.value;
	params=params+"&add_new_serial_yn=Y";
	parent.f_serial_number_frame.location.href="../../eOT/jsp/SwabCountAddSerialNumberButtons.jsp?"+params;	
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function getSwabCountDetails(swab_serial_number)
{
	var formObj = parent.f_serial_number_frame.document.SwabCountAddSerialNumberButtonsForm;
	var params = formObj.params.value;
	params=params+"&swab_serial_number="+swab_serial_number;
	var max_serial_number = formObj.max_serial_number.value;
	for(i=1;i<=max_serial_number;i++)
	{
		eval(document.getElementById("serial_"+i)).style.color="DARKBLUE";
	}
	eval(document.getElementById("serial_"+swab_serial_number)).style.color="#BC8F8F";
	parent.f_tab_frames.location.href="../../eOT/jsp/SwabCountTabs.jsp?"+params;	
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function CheckForNumber(val)
{
	if(trimCheck(val) && isNaN(val) == false && val >= 0)
		return true;
	else
		if (val.length > 0)
		{
			alert(getMessage("NUM_ALLOWED", "SM"));
			return false;
		}
}

async function printSwabCount()
{
	var params = document.SwabCountHeaderForm.params.value;
	params = params + "&p_report_id="+document.forms[0].p_report_id.value +"&P_NO_OF_SWAB_COUNT="+document.forms[0].P_NO_OF_SWAB_COUNT.value;
	var dialogHeight	= "11" ;
	var dialogWidth	= "25" ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
	var url = "../../eOT/jsp/SwabCountReportOption.jsp?"+params;
	//url=url+"?oper_num="+oper_num+"&slate_user_id="+slate_user_id+"&patient_id="+patient_id;
	//url=url+"?oper_num="+oper_num+"&slate_user_id="+slate_user_id+"&patient_id="+patient_id;
	retVal 	   = await window.showModalDialog(url, arguments, features);
}

function reviwedbyCheckBoxvalue(obj)
{
	var formObj = parent.f_swab_count_confirm_item.document.SwabCountItemConfirmForm;		
	var cnt = formObj.cnt.value;
	if(obj.checked==true){
		if(parseInt(cnt)==1){
			formObj.reviewed_by.options[1].selected = true;
		}
		obj.value="Y";
		formObj.reviewed_by.disabled = false;
		formObj.img1.src="../../eCommon/images/mandatory.gif";
	}else{
		obj.value="N";
		formObj.reviewed_by.disabled = true;	   
		formObj.reviewed_by.value = "";
		formObj.img1.src="../../eCommon/images/Blank1.gif";
	}
}

function reviewedby()
{
	 var formObj = parent.f_swab_count_confirm_item.document.SwabCountItemConfirmForm;
	 formObj.reviewed_by.disabled = true;   
}

/*function checkForSpecCharsforID(event)
{
    var strCheck = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_#*&%()[]';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}*/

function CheckForOHSpecChars(event)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

function Class_personnelrow()
{
     this.speciality_code="";
	 this.speciality_desc="";
	 this.role_id ="";
	 this.role_desc ="";
	 this.role_type="";
     this.practitioner_id="";
     this.practitioner_name="";
	 this.db_mode="";
	 this.recId ="";
}
function splitString(strVal)
{
	var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.speciality.value=arr[0];
	frmObj.role_id.value=arr[2];
	frmObj.role_desc.value=arr[3]
	frmObj.practitioner_id.value=arr[4];
	frmObj.practitioner_name.value=arr[5];
	frmObj.recId.value = arr[6];
	frmObj.role_type.value=arr[7];
	frmObj.mode.value=arr[8];
	frmObj.speciality.disabled=true;
	frmObj.role_desc.disabled=true;
	frmObj.speciality.disabled=true;
	frmObj.DoctorLookUp.disabled=true;
	frmObj.practitioner_name.disabled=true;
	frmObj.record.disabled=true;
}

function resetFields()
{
	var frmObj = document.PersonnelRecordForm;
	frmObj.mode.value='I';
	frmObj.role_desc.value='';
	frmObj.practitioner_name.value='';
	frmObj.role_desc.value='';
	frmObj.role_type.value='';
	//frmObj.RoleLookUp.disabled=false;
	frmObj.role_desc.disabled=false;
	frmObj.DoctorLookUp.disabled=false;
	frmObj.practitioner_name.disabled=false;
	frmObj.record.disabled=false;	
}

function loadDBRows(speciality_code,speciality_desc,role_id,role_desc,practitioner_id,practitioner_desc,recId,role_type,mode){
  //var params = document.forms[0].params.value;		  
  var objrow = newRow();
  var rows=parent.parent.RecordFrame.personnelrows1;
  var rowLength=parent.parent.RecordFrame.personnelrowLength1;
   if(mode=='L' && rowLength==0)
	{
	  objrow.speciality_code = speciality_code;
	  objrow.speciality_desc= speciality_desc;
	  objrow.role_id= role_id;
	  objrow.role_desc= role_desc;
	  objrow.practitioner_id= practitioner_id;
	  objrow.practitioner_name=practitioner_desc;
	  objrow.role_type=role_type;
	  objrow.db_mode="L";
	  objrow.recId=recId;
	  rows.push(objrow);
	  //parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/SwabCountPersonnelDtls.jsp?'+params;
	}
}

function refresh()
{
	var params = document.forms[0].params.value;
	parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/SwabCountPersonnelDtls.jsp?'+params;
}

function addRow()
{
  var objrow = newRow();
  var formObj = document.PersonnelRecordForm;
  var params = formObj.params.value;
  var mode = formObj.mode.value;
		if(mode=='I'){
			  if(chkEmpty()){	
			  if(alreadyExist())
			   {
				  var obj = formObj.speciality;
				  var obj1 = formObj.role_desc;
				  var rows = parent.parent.RecordFrame.personnelrows1;
				  objrow.speciality_code =formObj.speciality.value; 
				  objrow.speciality_desc=formObj.speciality.options[obj.selectedIndex].text;
				  objrow.role_id=formObj.role_id.value;
				  objrow.role_desc = formObj.role_desc.options[obj1.selectedIndex].text;// formObj.role_desc.value;
				  objrow.role_type=formObj.role_type.value;
				  objrow.practitioner_id=formObj.practitioner_id.value;
				  objrow.practitioner_name=formObj.practitioner_name.value;
				  objrow.db_mode='I';
				  objrow.recId = getRecId();
				  rows.push(objrow);
				  resetFields();
				  parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/SwabCountPersonnelDtls.jsp?'+params;
				  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		   }else 
			{	
			    //else part of alreadyExist method
				//var msg = 'Details already Selected';
				 var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
				 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		   }
		}
    }//if part of mode Check Ends Here
}

function assignRecId()
{
	var rows = parent.parent.RecordFrame.personnelrows1;
	parent.parent.RecordFrame.personnelrowLength11=rows.length;
}

function getRecId()
{
    var rowLength=parent.parent.RecordFrame.personnelrowLength11;
	var recId = rowLength+1;
	parent.parent.RecordFrame.personnelrowLength11  =  recId;
	return recId;
}

function removeRow()
{
	 var formObj = document.PersonnelRecordForm;
	 var mode = formObj.mode.value;
	 var recId = formObj.recId.value;
	 var params = formObj.params.value;
	 var rows = parent.parent.RecordFrame.personnelrows1;
	 if(rows.length>0&& mode=='U'){        
	 for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null  && rows[jj].recId!=null && rows[jj].recId!="") {
		 if(rows[jj].recId==recId ){
		  if(rows[jj].db_mode=='L')
			rows[jj].db_mode='D';
		  else
			delete rows[jj];
		   break;
		 }
	  }else
		continue;
	 }//end for-Loop
	   resetFields();
	   parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
	   parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/SwabCountPersonnelDtls.jsp?'+params;
	 }else
	   resetFields();
}

function newRow()
{
   var objrow = new Class_personnelrow();
   objrow.recId = parent.parent.RecordFrame.personnelrows1.length+1;
   return(objrow);
}

function chkEmpty()
{
	var role_value=getLabel("Common.Role.label","Common");
	var name_value=getLabel("Common.name.label","Common");
	var formObj = document.PersonnelRecordForm;
	var fields = new Array(formObj.role_desc,formObj.practitioner_name);
	var names = new Array(role_value,name_value);
	var messageFrame = parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function alreadyExist()
{
	var formObj = document.PersonnelRecordForm;
	var codeDtl = parent.parent.RecordFrame.DetailFrame.code; 
	var rows = parent.parent.RecordFrame.personnelrows1;
	var speciality_code=formObj.speciality.value;
	var role_id = formObj.role_id.value;
	var practitioner_id = formObj.practitioner_id.value;
	var codeRecord = speciality_code+role_id+practitioner_id;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
 }

function assign(obj)
{
	 formObj = document.PersonnelRecordForm;
	 var str = obj.value;
	 var arr = str.split("##");
	 formObj.role_id.value=arr[0];
	 formObj.role_type.value=arr[1];
 }

function stripSpaces(elm)
{
		var x = elm.value;
		elm.value = (x.replace( /^\s+/g, "" )).replace( /\s+$/g, "" );
		//elm.value = (x.replace(/^\W+/,'')).replace(/\W+$/,'');		
}

function setCaretPosition(ctrl)
{
    stripSpaces(ctrl);
	pos = ctrl.value.length;
	if(ctrl.setSelectionRange)
	{
		ctrl.focus();
		ctrl.setSelectionRange(pos,pos);
	}
	else if (ctrl.createTextRange) {
		var range = ctrl.createTextRange();
		range.collapse(true);
		range.moveEnd('character', pos);
		range.moveStart('character', pos);
		range.select();
	}
}
//  End IN024199

function checkBlank(obj, secound_cnt_val)
{
	var total_cnt_during_op = "";
	var formObj = parent.f_swab_count_dtls.document.SwabCountForm;
	var current_item = formObj.current_item.value;
	var cnt_val = secound_cnt_val.value;
	if(cnt_val == "00" || cnt_val == "000")
	{
		if(current_item == "second_cnt_cmpl_yn" )
			eval("formObj.second_count_"+obj).value = "0";
		else if(current_item == "third_cnt_cmpl_yn" )
			eval("formObj.third_count_"+obj).value = "0";
		else if(current_item == "fourth_cnt_cmpl_yn" )
			eval("formObj.fourth_count_"+obj).value = "0";
		else if(current_item == "fifth_cnt_cmpl_yn" )
			eval("formObj.fifth_count_"+obj).value = "0";
		else if(current_item == "final_cnt_cmpl_yn" )
			eval("formObj.final_count_"+obj).value = "0";
	}
}

function enable_disable(obj)
{
	var hdr_formObj = parent.f_swab_count_confirm_item.document.SwabCountItemConfirmForm;
	var formObj = parent.f_swab_count_dtls.document.SwabCountForm;
	var second_count_no = "";
	var total_cavity_count_no = "";
	var final_count_no = "";
	var swab_count = formObj.swab_count.value;
	var complete_count = formObj.count.value;
	/* Added for 2nd Count Completed*/
	var second_cnt_checked = hdr_formObj.second_cnt_checked.value;
	var second_cnt_disabled = hdr_formObj.second_cnt_disabled.value;
	var after_cavity_checked = hdr_formObj.after_cavity_checked.value;
	var after_cavity_disabled = hdr_formObj.after_cavity_disabled.value;
	/* Added for Final Count Completed*/
	var final_cnt_checked = hdr_formObj.final_cnt_checked.value;
	var final_cnt_disabled = hdr_formObj.final_cnt_disabled.value;
	/* Added for 3rd Start Count Completed*/
	var third_cnt_cmpl_yn_chked = hdr_formObj.third_cnt_cmpl_yn_chked.value;
	var third_cnt_cmpl_yn_disabled = hdr_formObj.third_cnt_cmpl_yn_disabled.value;
	var additions_after_3c_cmpl_yn_chked = hdr_formObj.additions_after_3c_cmpl_yn_chked.value;
	var additions_after_3c_cmpl_yn_disabled = hdr_formObj.additions_after_3c_cmpl_yn_disabled.value;
	/* Added for fouth Start Count Completed*/
	var fourth_cnt_cmpl_yn_chked = hdr_formObj.fourth_cnt_cmpl_yn_chked.value;
	var fourth_cnt_cmpl_yn_disabled = hdr_formObj.fourth_cnt_cmpl_yn_disabled.value;
	var additions_after_4c_cmpl_yn_chked = hdr_formObj.additions_after_4c_cmpl_yn_chked.value;
	var additions_after_4c_cmpl_yn_disabled = hdr_formObj.additions_after_4c_cmpl_yn_disabled.value;
	/* Added for Fifth Start Count Completed*/
	var fifth_cnt_cmpl_yn_chked = hdr_formObj.fifth_cnt_cmpl_yn_chked.value;
	var fifth_cnt_cmpl_yn_disabled = hdr_formObj.fifth_cnt_cmpl_yn_disabled.value;
	var additions_after_5c_cmpl_yn_chked = hdr_formObj.additions_after_5c_cmpl_yn_chked.value;
	var additions_after_5c_cmpl_yn_disabled = hdr_formObj.additions_after_5c_cmpl_yn_disabled.value;
	var allwdSwabCntsVal = formObj.allwdSwabCntsVal.value;
	var no_of_records = formObj.no_of_records.value;	
	var fifth_count_no="";
	for(row=1;row<=no_of_records;row++)
	{
		second_count_no	= eval("formObj.second_count_"+row);
		item_after_close_cavity_no = eval("formObj.item_after_close_cavity_"+row);
		final_count_no = eval("formObj.final_count_"+row);
		/* Added Start Against 2nd Count Completed*/
		if((second_cnt_checked=="" && second_cnt_disabled=="")&&(final_cnt_disabled=="" && final_cnt_checked=="")){
		if(second_count_no.value != "" && second_count_no.value.length > 0 && final_count_no.value == "" && final_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.final_count_"+i).disabled = true;
				eval("formObj.second_count_"+i).disabled = false;
			 }			 
			break;
		}if(second_count_no.value == "" && second_count_no.value.length == 0 && final_count_no.value == "" && final_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.second_count_"+i).disabled = false;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
		}else if(final_count_no.value != "" && final_count_no.value.length > 0 && second_count_no.value == "" && second_count_no.value.length == 0 ){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.second_count_"+i).disabled = true;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
		}  
		}
		
	if((after_cavity_checked=="" && after_cavity_disabled=="")&&(final_cnt_disabled=="" && final_cnt_checked=="")){
	if(item_after_close_cavity_no.value != "" && item_after_close_cavity_no.value.length > 0 && final_count_no.value =="" && final_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.item_after_close_cavity_"+i).disabled = false;
				eval("formObj.final_count_"+i).disabled = true;
			}
			break;
		}else if(item_after_close_cavity_no.value == "" && item_after_close_cavity_no.value.length == 0 && final_count_no.value =="" && final_count_no.value.length == 0 ){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.final_count_"+i).disabled = false;
				eval("formObj.item_after_close_cavity_"+i).disabled = false;
			}
			break;
		}if(final_count_no.value != "" && final_count_no.value.length > 0 && item_after_close_cavity_no.value == "" && item_after_close_cavity_no.value.length == 0){
			item_after_close_cavity_no.value="";
			for(i=1;i<=no_of_records;i++){
				eval("formObj.final_count_"+i).disabled = false;
				eval("formObj.item_after_close_cavity_"+i).disabled = true;
			}
			break;
		}
	}
	/* Added End Against 2nd Count Completed*/
	/* Added Start Against 3rd Count Completed*/	
	if(allwdSwabCntsVal > 3){
		third_count_no = eval("formObj.third_count_"+row);
		add_after_third_count_no = eval("formObj.add_after_third_count_"+row);
		
	if((third_cnt_cmpl_yn_chked=="" && third_cnt_cmpl_yn_disabled=="")&&(final_cnt_disabled=="" && final_cnt_checked=="")){
		if(third_count_no.value != "" && third_count_no.value.length > 0 && final_count_no.value == "" && final_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.final_count_"+i).disabled = true;
				eval("formObj.third_count_"+i).disabled = false;
			 }
			break;
	}if(final_count_no.value != "" && final_count_no.value.length > 0 && third_count_no.value == "" && third_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
			eval("formObj.third_count_"+i).disabled = true;
			eval("formObj.final_count_"+i).disabled = false;
			}
			break;
	}else if(final_count_no.value == "" && final_count_no.value.length == 0 && third_count_no.value == "" && third_count_no.value.length == 0 ){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.third_count_"+i).disabled = false;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
		}  
	}	
		if((additions_after_3c_cmpl_yn_chked=="" && additions_after_3c_cmpl_yn_disabled=="")&&(final_cnt_disabled=="" && final_cnt_checked=="")){
	if(add_after_third_count_no.value != "" && add_after_third_count_no.value.length > 0 && final_count_no.value == "" && final_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.final_count_"+i).disabled = true;
				eval("formObj.add_after_third_count_"+i).disabled = false;
			 }
			break;
	}if(final_count_no.value != "" && final_count_no.value.length > 0 && add_after_third_count_no.value == "" && add_after_third_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.add_after_third_count_"+i).disabled = true;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
	}else if(final_count_no.value == "" && final_count_no.value.length == 0 && add_after_third_count_no.value == "" && add_after_third_count_no.value.length == 0 ){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.add_after_third_count_"+i).disabled = false;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
			}
			}
		
	}
	/* Added End Against 3rd Count Completed and Added Start Against 4th Count Completed*/
	if(allwdSwabCntsVal > 4){
		fourth_count_no = eval("formObj.fourth_count_"+row);
		add_after_fourth_count_no = eval("formObj.add_after_fourth_count_"+row);
	if((fourth_cnt_cmpl_yn_chked=="" && fourth_cnt_cmpl_yn_disabled=="")&&(final_cnt_disabled=="" && final_cnt_checked=="")){
	if(fourth_count_no.value != "" && fourth_count_no.value.length > 0 && final_count_no.value == "" && final_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.final_count_"+i).disabled = true;
				eval("formObj.fourth_count_"+i).disabled = false;
			 }
			break;
	}if(final_count_no.value != "" && final_count_no.value.length > 0 && fourth_count_no.value == "" && fourth_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.fourth_count_"+i).disabled = true;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
	}else if(final_count_no.value == "" && final_count_no.value.length == 0 && fourth_count_no.value == "" && fourth_count_no.value.length == 0 ){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.fourth_count_"+i).disabled = false;
				eval("formObj.final_count_"+i).disabled = false;
				}
			break;
			}  
		}	
	if((additions_after_4c_cmpl_yn_chked=="" && additions_after_4c_cmpl_yn_disabled=="")&&(final_cnt_disabled=="" && final_cnt_checked=="")){
	if(add_after_fourth_count_no.value != "" && add_after_fourth_count_no.value.length > 0 && final_count_no.value == "" && final_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.final_count_"+i).disabled = true;
				eval("formObj.add_after_fourth_count_"+i).disabled = false;
			 }
			break;
	}if(final_count_no.value != "" && final_count_no.value.length > 0 && add_after_fourth_count_no.value == "" && add_after_fourth_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.add_after_fourth_count_"+i).disabled = true;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
	}else if(final_count_no.value == "" && final_count_no.value.length == 0 && add_after_fourth_count_no.value == "" && add_after_fourth_count_no.value.length == 0 ){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.add_after_fourth_count_"+i).disabled = false;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
				}  
			}
	}		
	/* Added End Against 4th Count Completed and Added Start Against 5th Count Completed*/	
	if(allwdSwabCntsVal > 5 ){	
		fifth_count_no = eval("formObj.fifth_count_"+row);
		add_after_fifth_count_no = eval("formObj.add_after_fifth_count_"+row);
	if((fifth_cnt_cmpl_yn_chked=="" && fifth_cnt_cmpl_yn_disabled=="")&&(final_cnt_disabled=="" && final_cnt_checked=="")){
	if(fifth_count_no.value != "" && fifth_count_no.value.length > 0 && final_count_no.value == "" && final_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.final_count_"+i).disabled = true;
				eval("formObj.fifth_count_"+i).disabled = false;
			 }
			break;
	}if(final_count_no.value != "" && final_count_no.value.length > 0 && fifth_count_no.value == "" && fifth_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.fifth_count_"+i).disabled = true;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
	}else if(final_count_no.value == "" && final_count_no.value.length == 0 && fifth_count_no.value == "" && fifth_count_no.value.length == 0 ){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.fifth_count_"+i).disabled = false;
				eval("formObj.final_count_"+i).disabled = false;
				}
			break;
			}  
		}	
	if((additions_after_5c_cmpl_yn_chked=="" && additions_after_5c_cmpl_yn_disabled=="")&&(final_cnt_disabled=="" && final_cnt_checked=="")){
	if(add_after_fifth_count_no.value != "" && add_after_fifth_count_no.value.length > 0 && final_count_no.value == "" && final_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.final_count_"+i).disabled = true;
				eval("formObj.add_after_fifth_count_"+i).disabled = false;
			 }
			break;
	}if(final_count_no.value != "" && final_count_no.value.length > 0 && add_after_fifth_count_no.value == "" && add_after_fifth_count_no.value.length == 0){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.add_after_fifth_count_"+i).disabled = true;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
	}else if(final_count_no.value == "" && final_count_no.value.length == 0 && add_after_fifth_count_no.value == "" && add_after_fifth_count_no.value.length == 0 ){
			for(i=1;i<=no_of_records;i++){
				eval("formObj.add_after_fifth_count_"+i).disabled = false;
				eval("formObj.final_count_"+i).disabled = false;
			}
			break;
				}  
			}	
		}	
	/* Added End Against 5th Count Completed*/		
	} 
}

function scrollTo()
{
	var formObj = parent.f_swab_count_dtls.document.SwabCountForm;
	var current_item = formObj.current_item.value;
	var hdr_formObj = parent.f_swab_count_confirm_item.document.SwabCountItemConfirmForm;	
	var item_name = '';
	var no_of_records = formObj.no_of_records.value;	
	if(current_item == "first_cnt_cmpl_yn")
		item_name = "formObj.first_count_";
	else if(current_item == "add_during_op_cmpl_yn")
		item_name = "formObj.item_during_op_";
	else if(current_item == "second_cnt_cmpl_yn")
		item_name = "formObj.second_count_";
	else if(current_item == "add_aft_clcav_cmpl_yn")
		item_name = "formObj.item_after_close_cavity_";
	else if(current_item == "third_cnt_cmpl_yn")
		item_name = "formObj.third_count_";
	else if(current_item == "additions_after_3c_cmpl_yn")
		item_name = "formObj.add_after_third_count_";
	else if(current_item == "fourth_cnt_cmpl_yn")
		item_name = "formObj.fourth_count_";
	else if(current_item == "additions_after_4c_cmpl_yn")
		item_name = "formObj.add_after_fourth_count_";
	else if(current_item == "fifth_cnt_cmpl_yn")
		item_name = "formObj.fifth_count_";
	else if(current_item == "additions_after_5c_cmpl_yn")
		item_name = "formObj.add_after_fifth_count_";
	else if(current_item == "final_cnt_cmpl_yn")
		item_name = "formObj.final_count_";

 	for(row=1;row<=no_of_records;row++){
		final_count_no = eval("formObj.final_count_"+row);	
	if(final_count_no.value != "" && final_count_no.value.length > 0)
		final_count_no.focus();
	if(item_name != ''){	
		var isDisabled = eval(item_name+1).disabled;
		if(!isDisabled)
			eval(item_name+1).focus();
		} 
	}	
}
