var prevTabObj=null;
function create() 
{
	var file=f_query_add_mod.location.href;
	fileName=file.substring(file.length-10,file.length);
	if(fileName=="blank.html")
		f_query_add_mod.location.href = "../../eOA/jsp/OAParameterAddModify.jsp?operation=insert" ;
}
function reset()
{
	//f_query_add_mod.document.forms[0].reset();
	//f_query_add_mod.resetvalue();
	//document.getElementById('rwres').rows='42,*,0%,20'	
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="84vh";
	document.getElementById("resFrame").style.height="0vh";
	document.getElementById("messageFrame").style.height="8vh";
		
	f_query_add_mod.location.href = "../../eOA/jsp/OAParameterAddModify.jsp?";
    resFrame.location.href="../../eCommon/html/blank.html"
}

function query()
{
	f_query_add_mod.location.href = "../../eOA/jsp/OAParameterAddModify.jsp?operation=modify" ;
}

function resetvalue(){
	
	if (document.forms[0].operation.value == "modify"){
		if (document.forms[0].override_no_of_slots_yn1.value =='Y'){
			document.forms[0].override_no_of_slots_yn.value = "Y";
			document.forms[0].override_no_of_slots_yn.checked=true;
		}else{
			document.forms[0].override_no_of_slots_yn.value = "N";
			document.forms[0].override_no_of_slots_yn.checked=false;
		}
		
		if(document.forms[0].waitlist_category_appl_yn.value =='Y')
		{
			document.forms[0].wait_lst_appl.value=="Y";
			document.forms[0].wait_lst_appl.checked=true;
		}else{
			document.forms[0].wait_lst_appl.value=="N";
			document.forms[0].wait_lst_appl.checked=false;
			document.forms[0].wait_lst_reqd.disabled=true;
			document.forms[0].restrict_wtlst_cat_spec.disabled=true;
		}
		
		if(document.forms[0].waitlist_category_reqd_yn.value =='Y')
		{

			document.forms[0].wait_lst_reqd.value=="Y";
			document.forms[0].wait_lst_reqd.checked=true;
		}else{
			document.forms[0].wait_lst_reqd.value=="N";
			document.forms[0].wait_lst_reqd.checked=false;
			
		}

		if(document.forms[0].invitation_list_appl_yn.value =='Y')
		{
			document.forms[0].invite_appl.value=="Y";
			document.forms[0].invite_appl.checked=true;
		}else{
			document.forms[0].invite_appl.value=="N";
			document.forms[0].invite_appl.checked=false;
		}

		if(document.forms[0].restrict_wl_cat_agst_splty_yn.value =='Y')
		{
			document.forms[0].restrict_wtlst_cat_spec.value=="Y";
			document.forms[0].restrict_wtlst_cat_spec.checked=true;
		}else{
			document.forms[0].restrict_wtlst_cat_spec.value=="N";
			document.forms[0].restrict_wtlst_cat_spec.checked=false;
		}

		if(document.forms[0].grace_per_con_elap_wtlt.value=="")
		{
			document.forms[0].grace_per_con_elap_wtlt.disabled=false;
		}else
		{
			document.forms[0].grace_per_con_elap_wtlt.disabled=true;
		}
		if(document.forms[0].cutoff_elps_wtlt.value=="")
		{
			document.forms[0].cutoff_elps_wtlt.disabled=false;
		}else
		{
			document.forms[0].cutoff_elps_wtlt.disabled=true;
		}


		if(document.forms[0].limit_no_show_days.value =="")
		{
			document.forms[0].spec.disabled=true;
			document.forms[0].locn.disabled=true;
		}else
		{
			document.forms[0].spec.disabled=false;
			document.forms[0].locn.disabled=false;
		if(document.forms[0].noshow_ctrl_by_splty_or_clinic.value=="S")
		{
			document.forms[0].spec.checked=true;
		}else if(document.forms[0].noshow_ctrl_by_splty_or_clinic.value=="L")
		{
			document.forms[0].locn.checked=true;
		}
		}
		//document.forms[0].appt_slip_remarks1.focus();
		  document.forms[0].override_no_of_slots_yn.focus();
	}else{
		if(document.forms[0].wait_lst_appl.value=="Y")
		{

			document.forms[0].wait_lst_reqd.disabled=true;
				document.forms[0].restrict_wtlst_cat_spec.disabled=true;
		}else
		{
			document.forms[0].wait_lst_reqd_value.disabled=true;
			document.forms[0].restrict_wtlst_cat_spec.disabled=true;
		}

		if(document.forms[0].limit_no_show_days.value !="")
		{
				document.forms[0].spec.disabled=false;
				document.forms[0].locn.disabled=false;
		}else
		{
			document.forms[0].spec.disabled=true;
			document.forms[0].locn.disabled=true;
		}
	}

		if(document.oaparameter.operation.value=='insert'){
			if(document.forms[0].bl_operational.value=="Y" ){
			document.forms[0].billing_allow.disabled=false;
			document.forms[0].billing_allow.checked=false;
			document.forms[0].billing_allow.value="N";
			}else{
			document.forms[0].billing_allow.disabled=true;
			document.forms[0].billing_allow.checked=false;
			document.forms[0].billing_allow.value="N";
			}
	}else if(document.oaparameter.operation.value=='modify'){
		if(document.forms[0].capture_fin_dtls_yn.value=="N"){
			document.forms[0].billing_allow.disabled=true;
			document.forms[0].billing_allow.checked=false;
			document.forms[0].billing_allow.value="N";
		}else{
			document.forms[0].billing_allow.disabled=true;
			document.forms[0].billing_allow.checked=true;
			document.forms[0].billing_allow.value="Y";
		}
		
	}
	/*if(document.forms[0].bl_operational.value=="Y" )
	{
		if(document.forms[0].capture_fin_dtls_yn.value=="N")
		{
			document.forms[0].billing_allow.disabled=false;
			document.forms[0].billing_allow.checked=false;
			document.forms[0].billing_allow.value="N";
		}else 
		{
		document.forms[0].billing_allow.disabled=true;
		document.forms[0].billing_allow.checked=true;
		document.forms[0].billing_allow.value="Y";
		}
		
	}else
	{
	
		document.forms[0].billing_allow.disabled=true;
		document.forms[0].billing_allow.checked=false;
		document.forms[0].billing_allow.value="N";
		
	}*/

if(document.forms[0].capture_con_dtls_yn.value=="N")
		{
			document.forms[0].res_contact_mand.checked=false;
			document.forms[0].res_contact_mand.value="N";
		}else 
		{
		document.forms[0].res_contact_mand.checked=true;
		document.forms[0].res_contact_mand.value="Y";
		}


/*if(document.forms[0].email_appl_yn.value=="N"){
	document.forms[0].email_applicable.checked=false;
			document.forms[0].email_applicable.value="N";
			document.forms[0].email_applicable1.disabled = true;
            document.forms[0].sendremin_appoint.disabled =true;
		}else 
		{
		document.forms[0].email_applicable.checked=true;
		document.forms[0].email_applicable.value="Y";
        }

		if(document.forms[0].email_appl_yn1.value=="N"){
	document.forms[0].email_applicable1.checked=false;
			document.forms[0].email_applicable1.value="N";
		}else 
		{
		document.forms[0].email_applicable1.checked=true;
		document.forms[0].email_applicable1.value="Y";
        }*/

if(document.forms[0].emailappli.value=="N"){
	//alert(document.forms[0].emailappli.value);
    document.forms[0].email_applicable.checked=false;
	document.forms[0].email_applicable1.checked=false;
	document.forms[0].email_applicable.disabled = true;
	document.forms[0].email_applicable1.disabled = true;
	document.forms[0].sendremin_appoint.disabled =true;
	document.forms[0].sendremin_appoint.value="";

}
else{
	if(document.forms[0].email_appl_yn.value=="N"){
	document.forms[0].email_applicable.checked=false;
			document.forms[0].email_applicable.value="N";
			document.forms[0].email_applicable1.disabled = true;
            document.forms[0].sendremin_appoint.disabled =true;
		}else 
		{
		document.forms[0].email_applicable.checked=true;
		document.forms[0].email_applicable.value="Y";
        }

		if(document.forms[0].email_appl_yn1.value=="N"){
	document.forms[0].email_applicable1.checked=false;
			document.forms[0].email_applicable1.value="N";
		}else 
		{
		document.forms[0].email_applicable1.checked=true;
		document.forms[0].email_applicable1.value="Y";
        }
}
//Bru-hIMS-CRF 169 changes starts
if(document.forms[0].max_Cancelled_Appt){
	if(document.forms[0].max_Cancelled_Appt.value==''){
		document.forms[0].pat_cancel_reason.value='';
		document.forms[0].pat_cancel_reason.disabled=true;
	}
	else{
		document.forms[0].pat_cancel_reason.disabled=false;
		document.forms[0].patCnclMan.style.visibility="visible";
	}
}
//Bru-hIMS-CRF 169 changes ends


}

function encounter_chk(obj)
{
	if(obj.checked ==true)
	{
		obj.value='Y';
	}else
	{
		obj.value='N';
	}
}

function chkSize(obj)
{
}

function apply()
{
		var flag=true;
		if(f_query_add_mod.document.oaparameter.alcn_applicable_yn.value=="Y"){
		var fields = new Array ( 
		f_query_add_mod.document.oaparameter.alcn_criteria,
		f_query_add_mod.document.oaparameter.grace_per_con_elap_wtlt,
		f_query_add_mod.document.oaparameter.cutoff_elps_wtlt);

		var names = new Array ( 
					getLabel("eOA.AlocationCriteria.label","OA"),
					getLabel("eOA.Graceelapsedwaitlist.label","OA"), 
					getLabel("eOA.Cutoffelapsedwaitlist.label","OA") );
		}else{
			var fields = new Array ( 
		f_query_add_mod.document.oaparameter.grace_per_con_elap_wtlt,
		f_query_add_mod.document.oaparameter.cutoff_elps_wtlt);

		var names = new Array ( 
					getLabel("eOA.Graceelapsedwaitlist.label","OA"), 
					getLabel("eOA.Cutoffelapsedwaitlist.label","OA") );
		}
		//Bru-HIMS-CRF 169 changes start
		if(f_query_add_mod.document.forms[0].max_Cancelled_Appt){
			if(f_query_add_mod.document.forms[0].max_Cancelled_Appt.value!='' && f_query_add_mod.document.oaparameter.pat_cancel_reason){
			fields[fields.length]	=	f_query_add_mod.document.oaparameter.pat_cancel_reason;
			names[names.length]		=	getLabel("eOA.ReasonForPatCancelledAppt.label","OA");
			}
		}
		//Bru-HIMS-CRF 169 changes end
		f_query_add_mod.document.forms[0].restrict_wtlst_cat_spec.disabled=false;
		f_query_add_mod.document.forms[0].wait_lst_reqd.disabled=false;
		
	if(resFrame.document.forms[0]!=null)
	{
	f_query_add_mod.document.forms[0].NO_SHOW_TITLE.value=resFrame.document.forms[0].NO_SHOW_TITLE.value
	f_query_add_mod.document.forms[0].NO_SHOW_TITLE_LABEL_OTH_LANG.value=resFrame.document.forms[0].NO_SHOW_TITLE_LABEL_OTH_LANG.value
	f_query_add_mod.document.forms[0].NO_SHOW_TEXT1.value=resFrame.document.forms[0].NO_SHOW_TEXT1.value
	f_query_add_mod.document.forms[0].NO_SHOW_TEXT1_LABEL_OTH_LANG.value=resFrame.document.forms[0].NO_SHOW_TEXT1_LABEL_OTH_LANG.value
	f_query_add_mod.document.forms[0].NO_SHOW_TEXT2.value=resFrame.document.forms[0].NO_SHOW_TEXT2.value
	f_query_add_mod.document.forms[0].NO_SHOW_TEXT2_LABEL_OTH_LANG.value=resFrame.document.forms[0].NO_SHOW_TEXT2_LABEL_OTH_LANG.value
   	f_query_add_mod.document.forms[0].NO_SHOW_TEXT3.value=resFrame.document.forms[0].NO_SHOW_TEXT3.value
    f_query_add_mod.document.forms[0].NO_SHOW_TEXT3_LABEL_OTH_LANG.value=resFrame.document.forms[0].NO_SHOW_TEXT3_LABEL_OTH_LANG.value
    f_query_add_mod.document.forms[0].NO_SHOW_TEXT4.value=resFrame.document.forms[0].NO_SHOW_TEXT4.value
    f_query_add_mod.document.forms[0].NO_SHOW_TEXT4_LABEL_OTH_LANG.value=resFrame.document.forms[0].NO_SHOW_TEXT4_LABEL_OTH_LANG.value
    f_query_add_mod.document.forms[0].NO_SHOW_TEXT5.value=resFrame.document.forms[0].NO_SHOW_TEXT5.value
    f_query_add_mod.document.forms[0].NO_SHOW_TEXT5_LABEL_OTH_LANG.value=resFrame.document.forms[0].NO_SHOW_TEXT5_LABEL_OTH_LANG.value
    f_query_add_mod.document.forms[0].TFR_SCH_TITLE.value=resFrame.document.forms[0].TFR_SCH_TITLE.value
    f_query_add_mod.document.forms[0].TFR_SCH_TITLE_LABEL_OTH_LANG.value=resFrame.document.forms[0].TFR_SCH_TITLE_LABEL_OTH_LANG.value
    f_query_add_mod.document.forms[0].TFR_SCH_TEXT1.value=resFrame.document.forms[0].TFR_SCH_TEXT1.value
    f_query_add_mod.document.forms[0].TFR_SCH_TEXT1_LABEL_OTH_LANG.value=resFrame.document.forms[0].TFR_SCH_TEXT1_LABEL_OTH_LANG.value
    f_query_add_mod.document.forms[0].TFR_SCH_TEXT2.value=resFrame.document.forms[0].TFR_SCH_TEXT2.value 
    f_query_add_mod.document.forms[0].TFR_SCH_TEXT2_LABEL_OTH_LANG.value=resFrame.document.forms[0].TFR_SCH_TEXT2_LABEL_OTH_LANG.value 
    f_query_add_mod.document.forms[0].TFR_SCH_TEXT3.value=resFrame.document.forms[0].TFR_SCH_TEXT3.value 
    f_query_add_mod.document.forms[0].TFR_SCH_TEXT3_LABEL_OTH_LANG.value=resFrame.document.forms[0].TFR_SCH_TEXT3_LABEL_OTH_LANG.value 
    f_query_add_mod.document.forms[0].TFR_SCH_TEXT4.value=resFrame.document.forms[0].TFR_SCH_TEXT4.value 
    f_query_add_mod.document.forms[0].TFR_SCH_TEXT4_LABEL_OTH_LANG.value=resFrame.document.forms[0].TFR_SCH_TEXT4_LABEL_OTH_LANG.value 
    f_query_add_mod.document.forms[0].TFR_SCH_TEXT5.value=resFrame.document.forms[0].TFR_SCH_TEXT5.value 
    f_query_add_mod.document.forms[0].TFR_SCH_TEXT5_LABEL_OTH_LANG.value=resFrame.document.forms[0].TFR_SCH_TEXT5_LABEL_OTH_LANG.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TITLE.value=resFrame.document.forms[0].BLK_CANC_TITLE.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TITLE_LABEL_OTH_LANG.value=resFrame.document.forms[0].BLK_CANC_TITLE_LABEL_OTH_LANG.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TEXT1.value=resFrame.document.forms[0].BLK_CANC_TEXT1.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TEXT1_LABEL_OTH_LANG.value=resFrame.document.forms[0].BLK_CANC_TEXT1_LABEL_OTH_LANG.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TEXT2.value=resFrame.document.forms[0].BLK_CANC_TEXT2.value 
	f_query_add_mod.document.forms[0].BLK_CANC_TEXT2_LABEL_OTH_LANG.value=resFrame.document.forms[0].BLK_CANC_TEXT2_LABEL_OTH_LANG.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TEXT3.value=resFrame.document.forms[0].BLK_CANC_TEXT3.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TEXT3_LABEL_OTH_LANG.value=resFrame.document.forms[0].BLK_CANC_TEXT3_LABEL_OTH_LANG.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TEXT4.value=resFrame.document.forms[0].BLK_CANC_TEXT4.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TEXT4_LABEL_OTH_LANG.value=resFrame.document.forms[0].BLK_CANC_TEXT4_LABEL_OTH_LANG.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TEXT5.value=resFrame.document.forms[0].BLK_CANC_TEXT5.value 
    f_query_add_mod.document.forms[0].BLK_CANC_TEXT5_LABEL_OTH_LANG.value=resFrame.document.forms[0].BLK_CANC_TEXT5_LABEL_OTH_LANG.value 
	}



if(f_query_add_mod.document.oaparameter.locn.checked==true)
{
f_query_add_mod.document.oaparameter.spec_locn.value="L";
}else if(f_query_add_mod.document.oaparameter.spec.checked==true)
{
f_query_add_mod.document.oaparameter.spec_locn.value="S";
}

	if(f_query_add_mod.document.oaparameter.operation.value=="insert")
	{
	if(f_query_add_mod.checkFields(fields, names, messageFrame))
	{
		flag=true;
		
	}else
	{
		flag=false;
	}
	}else
	{
		if(f_query_add_mod.checkFields(fields, names, messageFrame))
	{
		f_query_add_mod.document.oaparameter.grace_per_con_elap_wtlt.disabled=false;
        f_query_add_mod.document.oaparameter.alcn_criteria.disabled=false;
		f_query_add_mod.document.oaparameter.cutoff_elps_wtlt.disabled=false;
		f_query_add_mod.document.oaparameter.max_recurr_days.disabled=false;
		
		flag=true;
		
	}else
	{
		flag=false;
	}

	}

	if(flag==true)
	{
		if(f_query_add_mod.document.forms[0].rule_appl_yn)
			f_query_add_mod.document.forms[0].rule_appl_yn.disabled=false;	
		if(f_query_add_mod.document.forms[0].rd_oa_integration_yn)
			f_query_add_mod.document.forms[0].rd_oa_integration_yn.disabled=false;
		f_query_add_mod.document.forms[0].billing_allow.disabled=false;		
		f_query_add_mod.document.forms[0].submit();
	}
}
function onSuccess()
{				//document.getElementById('rwres').rows='42,*,0%,20'	 
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="84vh";
	document.getElementById("resFrame").style.height="0vh";
	document.getElementById("messageFrame").style.height="8vh";
	
	f_query_add_mod.location.href = "../../eOA/jsp/OAParameterAddModify.jsp?operation=modify" ;
}

function CheckNum1(obj)
{
    var valid = 'T';
	var strCheck = '0123456789';
		
  		if ( obj.value.length > 0 ) {
			for(var i=0;i<=obj.value.length;i++) {
				if (strCheck.indexOf(obj.value.charAt(i)) == -1){
					alert(getMessage("NUM_ALLOWED","SM"));
					valid='F';
					obj.select();
					obj.value="";
					obj.focus();
					return false;
					break;
				}
			}

		} 
		if(document.forms[0].high_not_invalid_wtlt.value=='0')
		{
		var error;
		error=getMessage("HIGH_NOT_INVITED","OA");
				parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" +error;
				obj.value="";
				obj.focus();
		}
		
	
}
function zerochk(obj)
{
	if(obj.value=='0')
	{
		var error;
		error=getMessage("HIGH_NOT_INVITED","OA");
		parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" +error;
		obj.value="";
		obj.focus();
	}

}

function wait_lst_appl_value(obj)
{
	if (obj.checked == true)
	{
		obj.value='Y';
		document.forms[0].wait_lst_reqd.disabled=false;
		document.forms[0].restrict_wtlst_cat_spec.disabled=false;
		document.forms[0].wait_lst_reqd.value="Y";
		document.forms[0].restrict_wtlst_cat_spec.value="Y";


	}else{
		obj.value='N';
		document.forms[0].wait_lst_reqd.disabled=true;
		document.forms[0].wait_lst_reqd.checked=false;
		document.forms[0].wait_lst_reqd.value="N";
		document.forms[0].restrict_wtlst_cat_spec.disabled=true;
		document.forms[0].restrict_wtlst_cat_spec.checked=false;
		document.forms[0].restrict_wtlst_cat_spec.value="N";
	}
}

function wait_lst_reqd_value(obj)
{
	if (obj.checked == true)
			obj.value='Y';
		else
			obj.value='N';
}

function invite_appl_value(obj)
{
	if (obj.checked == true)
	{
			obj.value='Y';
			document.forms[0].high_not_invalid_wtlt.disabled=false;
			document.forms[0].high_not_invalid_wtlt.value=document.forms[0].uninvited_period.value

	}else{
			obj.value='N';
			document.forms[0].high_not_invalid_wtlt.disabled=true;
			document.forms[0].high_not_invalid_wtlt.value="";
	}
}

function restrict_wtlst_cat_spec_value(obj)
{
	if (obj.checked == true)
			obj.value='Y';
		else
			obj.value='N';
}

function group_app_allowed_value(obj)
{
	if (obj.checked == true)
			obj.value='Y';
		else
			obj.value='N';
}

/*function tab_click1(Object)
			{
			
				if(Object=='tab1')
				{
					document.forms[0].appt_slip_remarks1.focus();
					 document.getElementById('first_tab').scrollIntoView();
				parent.document.getElementById('rwres').rows='42,*,0%,20'	 
				parent.resFrame.document.getElementById('hideForm').style.visibility="hidden"
				}
				if(Object=='tab2')
				{
				 document.forms[0].DATE_LABEL.focus();
				 document.getElementById('second_tab').scrollIntoView();
				
				parent.document.getElementById('rwres').rows='42,*,40%,20'
				
				if(parent.resFrame.document.forms[0]==null){ 
				parent.resFrame.location.href="../../eOA/jsp/OAParameterAddModify1.jsp"
				}else
				{
				
				parent.resFrame.document.getElementById('hideForm').style.visibility="visible"
				}
				}
				if(Object=='tab3')
				{

					document.forms[0].NO_SHOW_TITLE.focus();
					 document.getElementById('third_tab').scrollIntoView();
				}
				if(Object=='tab4')
				{
					document.forms[0].TFR_SCH_TITLE.focus();
					 document.getElementById('fourth_tab').scrollIntoView();
				}
				if(Object=='tab5')
				{
					document.forms[0].BLK_CANC_TITLE.focus();
					 document.getElementById('fifth_tab').scrollIntoView();
				}

}*/

function allow_billing(obj)
{
if(obj.checked==true)
{
	document.forms[0].billing_allow.value="Y";
}else
{
document.forms[0].billing_allow.value="N"
}
}

function clear_spec(obj)
{
	
	if(obj.checked ==true)
	{
	if(document.forms[0].locn.checked==true)
	{
	document.forms[0].locn.checked=false;
	}
	}
}

function clear_locn(obj)
{
	
	if(obj.checked ==true)
	{
	if(document.forms[0].spec.checked==true)
	{
	document.forms[0].spec.checked=false;
	}
	}
}

function enab_disa_spec_locn(obj)
{
	if(obj.value !="")
	{
		if(obj.value>99){
		var error;
		error=getMessage("NUM_SHLD_BE_LESS","OA");
		error=error.replace('#',100);
		alert(error)
		obj.focus();
		}else{
		document.forms[0].spec.disabled=false;
		document.forms[0].locn.disabled=false;
		document.forms[0].spec.focus();
		}
	}else
	{
		document.forms[0].spec.value='';
		document.forms[0].locn.value='';
		document.forms[0].spec.disabled=true;
		document.forms[0].locn.disabled=true;
	}
}


function OACheckNum(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("NUM_ALLOWED", "SM"));
			obj.value='';
            obj.select();
            obj.focus();
            return false;
        }
    }
}

function res_contact_enable(obj)
{
	if(obj.checked==true)
{
	document.forms[0].res_contact_mand.value="Y";
}else
{
document.forms[0].res_contact_mand.value="N"
}
}
function assignValue(obj){
  if(obj.checked==true){
	document.forms[0].rd_oa_integration_yn.value="Y";
  }else{
	document.forms[0].rd_oa_integration_yn.value="N"
  }
}
//added  changes   for HSA-CRF-0226 [IN:050599] 
function UptContactDtls(obj){
  if(obj.checked==true){
	document.forms[0].upt_contact_dtls_mp_yn.value="Y";
  }else{
	document.forms[0].upt_contact_dtls_mp_yn.value="N"
  }
} 
//end changes for HSA-CRF-0226 [IN:050599] 
function assignValueForSchdlWithAppt(obj){
  if(obj.checked==true){
	document.forms[0].blk_schdl_with_appt_yn.value="Y";
  }else{
	document.forms[0].blk_schdl_with_appt_yn.value="N"
  }
}

function tab_click(obj){
	if (obj == 'general'){
            document.getElementById('general1').scrollIntoView();
			document.forms[0].override_no_of_slots_yn.focus();
			}
			// document.forms[0].DATE_LABEL.focus();
		if (obj == 'report'){
			 document.getElementById('report1').scrollIntoView();
			 document.forms[0].DATE_LABEL.focus();
		}
		
		
}

function recall_reminder(obj)
{
	if (obj.checked == true)
			obj.value='Y';
		else
			obj.value='N';
}


function email_appli(obj)
{
	if (obj.checked == true)
			obj.value='Y';
		else
			obj.value='N';
}
function email_appli1(obj)
{
	if (obj.checked == true)
			obj.value='Y';
		else
			obj.value='N';
}
function validate(obj)
{
 if (obj.checked == true)
{
document.forms[0].email_applicable1.disabled = false;
document.forms[0].sendremin_appoint.disabled = false;

}
else
{
document.forms[0].email_applicable1.disabled = true;
document.forms[0].sendremin_appoint.disabled =true;
document.forms[0].email_applicable1.checked=false;
document.forms[0].sendremin_appoint.value=" ";
}
}

function selectTab(tabObj){	
		if(prevTabObj!=null){
			  document.getElementById(prevTabObj).className = "tabA";
			document.getElementById(prevTabObj + "span").className = "tabAspan";
			}
			document.getElementById(tabObj).className = "tabClicked";
			document.getElementById(tabObj + "span").className = "tabSpanclicked";
			prevTabObj=tabObj
}
			

function CheckForSpecChars2(event){
	
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

//By Sudhakar RUT-CRF-0005 Starts
function sch_rule_enable(obj){
	if( obj.name == 'rule_appl_yn'){
		if(obj.checked==true){
			document.forms[0].mob_num_req_yn.disabled=false;
			document.forms[0].lang_req_yn.disabled = false;
			document.forms[0].no_of_resch_appts_for_alert.disabled=false;
			document.forms[0].per_chk_past_resch_appts.disabled=false;	
			document.forms[0].per_chk_fut_resch_appts.disabled=false;
			document.forms[0].no_of_cancld_appts_for_alert.disabled=false;
			document.forms[0].per_chk_cancld_past_appts.disabled=false;
			document.forms[0].per_chk_cancld_fut_appts.disabled=false;
			document.forms[0].no_of_fut_appts_for_alert.disabled=false;
			document.forms[0].per_chk_for_fut_appts_alert.disabled=false;
			obj.value="Y";
			document.getElementById('mobNoLangRow').style.display="";
			document.getElementById('reschApptRow').style.display="";
			document.getElementById('cancApptRow').style.display="";
			document.getElementById('futApptRow').style.display="";
		}else{
			document.forms[0].mob_num_req_yn.checked=false;
			document.forms[0].mob_num_req_yn.value="N";
			document.forms[0].mob_num_req_yn.disabled=true;
			document.forms[0].lang_req_yn.checked=false;
			document.forms[0].lang_req_yn.value="N";
			document.forms[0].lang_req_yn.disabled=true;
			document.forms[0].no_of_resch_appts_for_alert.value="0";
			document.forms[0].no_of_resch_appts_for_alert.disabled=true;
			document.forms[0].per_chk_past_resch_appts.value="0";
			document.forms[0].per_chk_past_resch_appts.disabled=true;	
			document.forms[0].per_chk_fut_resch_appts.value="0";
			document.forms[0].per_chk_fut_resch_appts.disabled=true;
			document.forms[0].no_of_cancld_appts_for_alert.value="0";
			document.forms[0].no_of_cancld_appts_for_alert.disabled=true;
			document.forms[0].per_chk_cancld_past_appts.value="0";
			document.forms[0].per_chk_cancld_past_appts.disabled=true;
			document.forms[0].per_chk_cancld_fut_appts.value="0";
			document.forms[0].per_chk_cancld_fut_appts.disabled=true;
			document.forms[0].no_of_fut_appts_for_alert.disabled=true;
			document.forms[0].no_of_fut_appts_for_alert.value="0";
			document.forms[0].per_chk_for_fut_appts_alert.disabled=true;
			document.forms[0].per_chk_for_fut_appts_alert.value="0";
			obj.value="N";
			document.getElementById('mobNoLangRow').style.display="none";
			document.getElementById('reschApptRow').style.display="none";
			document.getElementById('cancApptRow').style.display="none";
			document.getElementById('futApptRow').style.display="none";
		}
	}else{
		if(obj.checked)
			obj.value='Y';
		else
			obj.value='N';
	}
}
//By Sudhakar RUT-CRF-0005 Ends

//Bru-HIMS-CRF-169 changes Starts
function checkMandatoryReason(obj){
	if (obj != null){
		if (obj.value != "" && obj.value !=0 ){//zero should not be allowed in teh max_cancelled_appt field
			document.forms[0].patCnclMan.style.visibility="visible";		
			document.forms[0].pat_cancel_reason.disabled=false;			
		}
		else{
			document.forms[0].max_Cancelled_Appt.value='';
			document.forms[0].patCnclMan.style.visibility="hidden";
			document.forms[0].pat_cancel_reason.value="";
			document.forms[0].pat_cancel_reason.disabled=true;
		}
	}
}
//Bru-HIMS-CRF-169 changes end

/*Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112*/
function ScheduleExtendYN(obj)
{
  if(obj.checked==true){
	document.forms[0].schedule_extend_yn.value="Y";
  }else{
	document.forms[0].schedule_extend_yn.value="N"
  }
}

function allowUncheckValidate(obj)
{
	if(obj.checked == false){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH action='allowUncheckValidate' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../jsp/OAIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		var extnd_cnt = trimString(responseText);

		if( extnd_cnt > 0 )
		{
			alert(getMessage("EXTEND_SCHEDULE_EXIST","OA"));
			obj.checked = true;
			obj.value = "Y";
		}
	}
}
/*End NMC-JD-CRF-0112*/
