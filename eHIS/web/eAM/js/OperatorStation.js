//parent.frames[1].... changed as parent.frames[2]....
function create() {

	//parent.frames[1].frames[1].location.href = "../../eAM/jsp/addOperatorStationFrame.jsp";
	f_query_add_mod_frame.location.href = "../../eAM/jsp/addOperatorStationFrame.jsp";
	
}
function query() {
	//parent.frames[1].frames[1].location.href ="../../eAM/jsp/queryOperatorStn.jsp?function=operatorstation";
	f_query_add_mod_frame.location.href ="../../eAM/jsp/queryOperatorStn.jsp?function=operatorstation";

}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod_frame.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply() {

	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

var fields = new Array ( parent.frames[2].frames[1].frames[0].document.opstn_form.facility,
				parent.frames[2].frames[1].frames[0].document.opstn_form.oper_stn_id,
				 parent.frames[2].frames[1].frames[0].document.opstn_form.long_desc,
				 parent.frames[2].frames[1].frames[0].document.opstn_form.short_desc,
				 parent.frames[2].frames[1].frames[0].document.opstn_form.operstntype);

	 var names  = new Array(getLabel('Common.facility.label','Common')
		         ,getLabel('Common.code.label','Common')
	 			  ,getLabel('Common.longdescription.label','Common')
				 ,getLabel('Common.shortdescription.label','Common')
		         ,getLabel('eAM.OperatorStationType.label','AM'));
	if( parent.frames[2].frames[1].frames[0].document.opstn_form.rule.value=="W")
	{
		fields[3]= parent.frames[2].frames[1].frames[0].document.opstn_form.ws_no;
		names[3]=getLabel('Common.WorkStation.label','Common')
	}
//////////Added by Manish Anand on 30-06-2002////////////////////
//	var spFields = new Array (parent.frames[2].frames[1].frames[0].document.opstn_form.oper_stn_id);
//	var spNames = new Array (getLabel('Common.code.label','Common'));
//	var error_page="../../eCommon/jsp/MstCodeError.jsp" 
//	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//////////----------------------------------////////////////////
//if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form){
	if(parent.frames[2].frames[1].frames[0].checkFieldsofMst( fields, names, messageFrame)){
	if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form) 
	{   
		var obj = parent.frames[2].frames[1].frames[2].document.opstn_detail_form ; 
		obj.facility_id.value=parent.frames[2].frames[1].frames[0].document.opstn_form.facility.value;
		obj.oper_stn_id.value =parent.frames[2].frames[1].frames[0].document.opstn_form.oper_stn_id.value;
		obj.long_desc.value = parent.frames[2].frames[1].frames[0].document.opstn_form.long_desc.value;
		obj.short_desc.value = parent.frames[2].frames[1].frames[0].document.opstn_form.short_desc.value;
		obj.operstntype.value = parent.frames[2].frames[1].frames[0].document.opstn_form.operstntype.value;
		obj.function_name.value = parent.frames[2].frames[1].frames[0].document.opstn_form.function_name.value; 
//alert(obj.oper_stn_id.value+"  "+obj.long_desc.value+"  "+obj.short_desc.value+"  "+obj.operstntype.value+"  "+obj.function_name.value);
		if(parent.frames[2].frames[1].frames[0].document.opstn_form.ws_no != null)
			obj.ws_no.value = parent.frames[2].frames[1].frames[0].document.opstn_form.ws_no.value;
	
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_yn != null)
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_yn.checked==true){
			
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_wo_pid_yn != null)

    //Newly added on 09/01/2006 
	if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_wait_list_yn.checked==true)
	{
	    parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_wait_list_yn.value="Y";

		}
	else
	{
	   parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_wait_list_yn.value="N";
	}
	if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.modify_wait_list_yn.checked==true)
	{
	    parent.frames[2].frames[1].frames[2].document.opstn_detail_form.modify_wait_list_yn.value="Y";
	}
	else
	{
	   parent.frames[2].frames[1].frames[2].document.opstn_detail_form.modify_wait_list_yn.value="N";
	}
	///ending of Newly added code on 09/01/2006
	if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_wo_pid_yn.checked==true)
	{
	    parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_wo_pid_yn.value="Y";
	}
	else
	{
	   parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_wo_pid_yn.value="N";
	}
				 if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.obook_appt_yn.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.obook_appt_yn.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.obook_appt_yn.value="N";
					}
				
		
		}else{
			parent.frames[2].frames[1].frames[2].document.opstn_detail_form.book_appt_wo_pid_yn.value="N";
		parent.frames[2].frames[1].frames[2].document.opstn_detail_form.obook_appt_yn.value="N";		//parent.frames[1].frames[1].frames[2].document.opstn_detail_form.book_appt_across_catg_yn.value="N";
		}
		
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_yn){
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.tfr_appt_yn.checked==true){
			
		}
		}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_visit_yn){
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_visit_yn.checked==true){
				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_pat_yn.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_pat_yn.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_pat_yn.value="N";
					}
				 
		
		}
			}else{	if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_pat_yn){
				parent.frames[2].frames[1].frames[2].document.opstn_detail_form.register_pat_yn.value="N";
		}
			}
	
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.ADMIT_PATIENT_WITH_BED_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.ADMIT_PATIENT_WITH_BED_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.ADMIT_PATIENT_WITH_BED_YN.value="N";
					}
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CHG_NURS_UNIT_IN_ASSIGN_BED_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CHG_NURS_UNIT_IN_ASSIGN_BED_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CHG_NURS_UNIT_IN_ASSIGN_BED_YN.value="N";
					}

				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.TRANSFER_OUT_PATIENT_YN != null)
					if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.TRANSFER_OUT_PATIENT_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.TRANSFER_OUT_PATIENT_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.TRANSFER_OUT_PATIENT_YN.value="N";
					}
			
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.TRANSFER_IN_PATIENT_YN != null)
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.TRANSFER_IN_PATIENT_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.TRANSFER_IN_PATIENT_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.TRANSFER_IN_PATIENT_YN.value="N";
					}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.SWAP_BED_YN != null)
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.SWAP_BED_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.SWAP_BED_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.SWAP_BED_YN.value="N";
					}
					if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.BACKDATED_ADMISSION_YN != null)
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.BACKDATED_ADMISSION_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.BACKDATED_ADMISSION_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.BACKDATED_ADMISSION_YN.value="N";
					}
				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.BED_CLASS_CHANGE_YN != null)
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.BED_CLASS_CHANGE_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.BED_CLASS_CHANGE_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.BED_CLASS_CHANGE_YN.value="N";
					}	if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_booking_yn != null)
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_booking_yn.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_booking_yn.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.create_booking_yn.value="N";
					}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CREATE_BOOKING_WITH_CONF_YN != null)
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CREATE_BOOKING_WITH_CONF_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CREATE_BOOKING_WITH_CONF_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CREATE_BOOKING_WITH_CONF_YN.value="N";
					}
		/*if(parent.frames[1].frames[1].frames[1].document.opstn_detail_form.cancel_transfer != null)
			if(parent.frames[1].frames[1].frames[1].document.opstn_detail_form.cancel_transfer.checked==true){
					parent.frames[1].frames[1].frames[1].document.opstn_detail_form.cancel_transfer.value="Y";
					}else{
					parent.frames[1].frames[1].frames[1].document.opstn_detail_form.cancel_transfer.value="N";
					}
			if(parent.frames[1].frames[1].frames[1].document.opstn_detail_form.cancel_discharge != null)
			if(parent.frames[1].frames[1].frames[1].document.opstn_detail_form.cancel_discharge.checked==true){
					parent.frames[1].frames[1].frames[1].document.opstn_detail_form.cancel_discharge.value="Y";
					}else{
					parent.frames[1].frames[1].frames[1].document.opstn_detail_form.cancel_discharge.value="N";
					}*/

				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.GLOBAL_BOOK_APPT_YN){
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.GLOBAL_BOOK_APPT_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.GLOBAL_BOOK_APPT_YN.value="Y";
					}
				}else{
					if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.GLOBAL_BOOK_APPT_YN){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.GLOBAL_BOOK_APPT_YN.value="N";
					}
				}

			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.FORCED_BOOK_APPT_YN){
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.FORCED_BOOK_APPT_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.FORCED_BOOK_APPT_YN.value="Y";
					}
			}else{
				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.FORCED_BOOK_APPT_YN){
					parent.frames[1].frames[1].frames[2].document.opstn_detail_form.FORCED_BOOK_APPT_YN.value="N";
					}
			}
		if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.eff_status.value== 'D')
		{
		for(j=0;j<parent.frames[2].frames[1].frames[2].document.forms[0].elements.length;j++) parent.frames[2].frames[1].frames[2].document.forms[0].elements(j).disabled=false;
		}
		
		if(parent.frames[2].frames[1].frames[0].document.forms[0].eff_status.checked)
			parent.frames[2].frames[1].frames[2].document.opstn_detail_form.eff_status.value='E';
			else
			parent.frames[2].frames[1].frames[2].document.opstn_detail_form.eff_status.value='D';

		
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RESERVE_BED_BAY_YN){
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RESERVE_BED_BAY_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RESERVE_BED_BAY_YN.value="Y";
					}
			}else{
				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RESERVE_BED_BAY_YN){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RESERVE_BED_BAY_YN.value="N";
					}
			}

			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RELEASE_BED_BAY_YN){
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RELEASE_BED_BAY_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RELEASE_BED_BAY_YN.value="Y";
					}
			}else{
				if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RELEASE_BED_BAY_YN){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.RELEASE_BED_BAY_YN.value="N";
					}
			}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.LINK_BABY_TO_MOTHER_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.LINK_BABY_TO_MOTHER_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.LINK_BABY_TO_MOTHER_YN.value="N";
					}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_NEWBORN_FOR_IP_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_NEWBORN_FOR_IP_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_NEWBORN_FOR_IP_YN.value="N";
					}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.DISCHARGE_CHECKLIST_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.DISCHARGE_CHECKLIST_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.DISCHARGE_CHECKLIST_YN.value="N";
					}
				
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_IP_REFERRAL_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_IP_REFERRAL_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.REG_IP_REFERRAL_YN.value="N";
					}
			if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CONFIRM_BEDSIDE_REFERRAL_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CONFIRM_BEDSIDE_REFERRAL_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.CONFIRM_BEDSIDE_REFERRAL_YN.value="N";
					}	

					if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.MAINTAIN_DEATH_REGISTER_YN.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.MAINTAIN_DEATH_REGISTER_YN.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.MAINTAIN_DEATH_REGISTER_YN.value="N";
					}	
                  /*Below line Added for this CRF Bru-HIMS-CRF-261*/
				   if(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.quick_admission_yn.checked==true){
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.quick_admission_yn.value="Y";
					}else{
					parent.frames[2].frames[1].frames[2].document.opstn_detail_form.quick_admission_yn.value="N";
					}				
					//alert(parent.frames[2].frames[1].frames[2].document.opstn_detail_form.quick_admission_yn.value);
			      //End Bru-HIMS-CRF-261	

		obj.submit();
	}
	}
}

function cancelCheckout(Obj)
{
	if(document.opstn_detail_form.CANCEL_CHECKOUT_YN.checked==true)
	{
		document.opstn_detail_form.CANCEL_CHECKOUT_YN.value="Y";
		var val = document.opstn_detail_form.CANCEL_CHECKOUT_YN.value;
				

	}
    else
	{
		document.opstn_detail_form.CANCEL_CHECKOUT_YN.value="N";
				var val1 = document.opstn_detail_form.CANCEL_CHECKOUT_YN.value;
				

	}	
}

function reset() 
{
if(parent.frames[1].frames[1])
{

	if(parent.frames[1].frames[1].document.forms[0])
	{
	if(parent.frames[1].frames[1].document.forms[0].name=="query_form")
	{
			f_query_add_mod_frame.document.location.reload();

	}else
	{

	}
	}else
	{
	f_query_add_mod_frame.document.location.reload();
	}
}

}

var facId='';
function onSuccess() {
facId = parent.frames[2].frames[1].frames[0].document.opstn_form.facility.value;

if(parent.frames[2].frames[1].frames[0].document.opstn_form.function_name.value == 'insert')
{
    
	parent.frames[2].frames[1].frames[0].location.href='../../eAM/jsp/addOperatorStation.jsp?facility_id='+facId
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html'
	parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html'
}
/*else
{	
	parent.frames[2].frames[1].location.href =parent.frames[1].frames[1].location;
	parent.frames[1].frames[1].frames[0].location.reload();
}*/
}

function deleterecord()
{
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
if(parent.frames[2].frames[1].frames[0].document.opstn_form.function_name.value!="insert")
	{
		if(confirm(parent.frames[2].frames[1].frames[0].getMessage('DELETE_RECORD','Common')))
		{

		parent.frames[2].frames[1].frames[0].document.opstn_form.function_name.value="delete";

		parent.frames[2].frames[1].frames[0].document.opstn_form.submit();
		var fn_status = parent.frames[2].frames[1].frames[0].document.opstn_form.function_name.value ;

		parent.frames[2].frames[1].frames[1].location.href="../../eCommon/html/blank.html";
		parent.frames[2].frames[1].frames[2].location.href="../../eCommon/html/blank.html";
		parent.frames[2].frames[1].frames[0].location.href="../../eCommon/html/blank.html"
	return true;
	}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "
		}
}
	else
	{
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	}
}

function qryModify(facilityid1,code,type,eff_status,fac_name)
{
var url="../../eAM/jsp/addOperatorStationFrame.jsp?mode='m'&facility_id="+facilityid1+"&oper_stn_id="+code+"&oper_stn_type="+type+"&eff_status="+eff_status+"&fac_name="+fac_name+"&facility_id_new="+facilityid1;
//alert(url);
parent.frames[1].location.href=url; 
}


