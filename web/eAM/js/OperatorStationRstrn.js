function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addOperatorStationRstrnFrames.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/queryOperatorStnRstrn.jsp?function=operatorstation" ;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply() {
		
		if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	  if(parent.frames[2].frames[1].frames[2].document.forms[0]!=null){
		var obj=parent.frames[2].frames[1].frames[2].document.forms[0];
		
		//var obj = f_query_add_mod.addOperatorStationRstrnDetailsFrame.document.opstn_detail_form ;
		if(f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.oprstnid.value){
		var arrvals = f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.oprstnid.value;
		obj.oprstn.value = arrvals;
		obj.user.value = f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.user.value;
		
		if(f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.function_name.value == 'insert')
		{
			//var arrvals1=f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.locationtype.value.split('#');
			//obj.loctype.value = arrvals1[1];

			obj.loctype.value = f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.locationtype.value;
		}

		if(f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.function_name.value == 'modify')
		{
			obj.loctype.value =f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.locationtype.value;
		}
		obj.locid.value=f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.locationid.value;
		obj.operation_type.value = f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.function_name.value; 

		if(f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.ws_no != null)
			obj.ws_no.value = f_query_add_mod.addOperatorStationRstrnFrame.document.opstnrstrn_form.ws_no.value;
		}
		
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_yn)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_yn.checked==true)
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_wo_pid_yn.checked==true)
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_wo_pid_yn.value="Y";
			}
			else
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_wo_pid_yn.value="N";
			}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.FORCED_BOOK_APPT_YN.checked==true)
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.FORCED_BOOK_APPT_YN.value="Y";
			}
			else
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.FORCED_BOOK_APPT_YN.value="N";
			}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.GLOBAL_BOOK_APPT_YN.checked==true)
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.GLOBAL_BOOK_APPT_YN.value="Y";
			}
			else
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.GLOBAL_BOOK_APPT_YN.value="N";
			}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.obook_appt_yn.checked==true)
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.obook_appt_yn.value="Y";
			}
			else
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.obook_appt_yn.value="N";
			}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_across_catg_yn)
			{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_across_catg_yn.checked==true)
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_across_catg_yn.value="Y"; 
			}
			}
			else
			{
				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_across_catg_yn)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_across_catg_yn.value="N";
			}
		}
}
		else
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_wo_pid_yn)
			parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_wo_pid_yn.value="N";
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.obook_appt_yn)
			parent.frames[2].frames[1].frames[2].document.opstn_detail_form.obook_appt_yn.value="N";	
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_across_catg_yn)
			parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_across_catg_yn.value="N";
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.FORCED_BOOK_APPT_YN)
			parent.frames[2].frames[1].frames[2].document.opstn_detail_form.FORCED_BOOK_APPT_YN.value="N";
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.GLOBAL_BOOK_APPT_YN)
			parent.frames[2].frames[1].frames[2].document.opstn_detail_form.GLOBAL_BOOK_APPT_YN.value="N";
		}

	if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_yn)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_yn.checked==true)
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_across_catg_yn)
			{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_across_catg_yn.checked==true)
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_across_catg_yn.value="Y";
			}
			}
			else
			{
				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_across_catg_yn)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_across_catg_yn.value="N";
			}
		}
	}
		else
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_across_catg_yn)
			parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_across_catg_yn.value="N";
		}
		
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_visit_yn)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_visit_yn.checked==true)
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_pat_yn.checked==true)
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_pat_yn.value="Y";
			}
			else
			{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_pat_yn.value="N";
			}
		}
	}
		else
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_pat_yn)
			parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_pat_yn.value="N";
		}
		//
if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_wait_list_yn)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_wait_list_yn.checked==true)
		{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_wait_list_yn.value="Y";
		}
	}
		else
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_wait_list_yn)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_wait_list_yn.value="N";
		}

		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.modify_wait_list_yn)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.modify_wait_list_yn.checked==true)
		{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.modify_wait_list_yn.value="Y";
		}
	}
		else
		{
				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.modify_wait_list_yn)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.modify_wait_list_yn.value="N";
		}

if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.LINK_BABY_TO_MOTHER_YN)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.LINK_BABY_TO_MOTHER_YN.checked==true)
		{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.LINK_BABY_TO_MOTHER_YN.value="Y";
		}
	}
		else
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.LINK_BABY_TO_MOTHER_YN)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.LINK_BABY_TO_MOTHER_YN.value="N";
		}
		
	if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_NEWBORN_FOR_IP_YN)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_NEWBORN_FOR_IP_YN.checked==true)
		{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_NEWBORN_FOR_IP_YN.value="Y";
		}
	}
		else
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_NEWBORN_FOR_IP_YN)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_NEWBORN_FOR_IP_YN.value="N";
		}
	
	if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.DISCHARGE_CHECKLIST_YN)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.DISCHARGE_CHECKLIST_YN.checked==true)
		{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.DISCHARGE_CHECKLIST_YN.value="Y";
		}
	}
		else
		{
				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.DISCHARGE_CHECKLIST_YN)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.DISCHARGE_CHECKLIST_YN.value="N";
		}
		
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RESERVE_BED_BAY_YN)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RESERVE_BED_BAY_YN.checked==true)
		{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RESERVE_BED_BAY_YN.value="Y";
		}
	}
		else
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RESERVE_BED_BAY_YN)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RESERVE_BED_BAY_YN.value="N";
		}
		
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RELEASE_BED_BAY_YN)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RELEASE_BED_BAY_YN.checked==true)
		{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RELEASE_BED_BAY_YN.value="Y";
		}
	}
		else
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RELEASE_BED_BAY_YN)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RELEASE_BED_BAY_YN.value="N";
		}

		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_IP_REFERRAL_YN)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_IP_REFERRAL_YN.checked==true)
		{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_IP_REFERRAL_YN.value="Y";
		}
	}
		else
		{
				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_IP_REFERRAL_YN)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_IP_REFERRAL_YN.value="N";
		}

		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CONFIRM_BEDSIDE_REFERRAL_YN)
	{
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CONFIRM_BEDSIDE_REFERRAL_YN.checked==true)
		{
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CONFIRM_BEDSIDE_REFERRAL_YN.value="Y";
		}
	}
		else
		{
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CONFIRM_BEDSIDE_REFERRAL_YN)
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CONFIRM_BEDSIDE_REFERRAL_YN.value="N";
		}
	  
		obj.submit();
	}
	else{
    	var msg=parent.frames[0].getMessage("AM0100","AM");
	    messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
        return false;

	}
}
function reset() 
{
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.location.reload();
		//f_query_add_mod.document.forms[0].reset();
	else if(f_query_add_mod.frames[0].document.forms[0].function_name.value !='modify')
		f_query_add_mod.location.href = "../../eAM/jsp/addOperatorStationRstrnFrames.jsp" ;
	else
		f_query_add_mod.frames[1].location.reload();
}
function deleterecord()
{
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	if(f_query_add_mod.frames[0].document.opstnrstrn_form.function_name.value!="insert")
	{
		if(confirm(f_query_add_mod.frames[0].getMessage('DELETE_RECORD','Common')))
		{
			f_query_add_mod.frames[0].document.opstnrstrn_form.operation_type.value="delete";
			f_query_add_mod.frames[0].document.opstnrstrn_form.submit();
			
			var fn_status = f_query_add_mod.frames[0].document.opstnrstrn_form.function_name.value ;
			//f_query_add_mod.location.href="../../eCommon/html/blank.html"
			//f_query_add_mod.frames[0].document.opstnrstrn_form.reset();
			//return true;
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "
		}
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "
	}
}
function onSuccess() 
{ 
	if(f_query_add_mod.frames[0].document.opstnrstrn_form.operation_type.value == 'delete')
	{
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	}
	if(parent.frames[2].frames[1].frames[0].document.forms[0].function_name.value == 'insert')
	{
		var facId = parent.frames[2].frames[1].frames[0].document.forms[0].facility.value;	parent.frames[2].frames[1].frames[0].location.href='../../eAM/jsp/addOperatorStationRstrn.jsp?facility_id='+facId
		parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html'
		parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html'
	}
	
}
/*function enableBeforeSubmit()
{
	var obj = f_query_add_mod.addOperatorStationRstrnDetailsFrame.document.opstn_detail_form; 
	for(var i=0;i<obj.elements.length;i++)
	{
		if(obj.elements(i).disabled ==true)
			obj.elements(i).disabled = false;
	}

	return true;
}*/

function chkMandatory()
{
var fields = new Array (parent.frames[0].document.forms[0].facility, parent.frames[0].document.forms[0].oprstnid,
				 parent.frames[0].document.forms[0].user_desc,
				 parent.frames[0].document.forms[0].locationtype,
				 parent.frames[0].document.forms[0].location_desc);
							
	 var names  = new Array (getLabel('Common.facility.label','Common'), getLabel('Common.operatorstation.label','Common'),
	 getLabel('Common.user.label','Common'),
	 getLabel('Common.locationtype.label','Common'),
	 getLabel('Common.Location.label','Common'));

	if( parent.frames[0].document.forms[0].rule.value=="W")
	{
		fields[3]= parent.frames[0].document.forms[0].ws_no;
		names[3]=getLabel('Common.WorkStation.label','Common')
	}
	
	if(parent.frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2])) 
	{
		return true;
	}
	else
		return false;
}

