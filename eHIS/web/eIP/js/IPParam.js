function create() 
  {
	f_query_add_mod.location.href = "../../eIP/jsp/IPParameter.jsp" ; 
  } 
  
 function apply() 
  {
	
		var maxVal = f_query_add_mod.document.ipparam_form.bed_block_period_max.value;
		var normalVal	=	f_query_add_mod.document.forms[0].bed_block_period_normal.value;
        f_query_add_mod.document.ipparam_form.unregistered_patients_bkg_yn.disabled = false ; 
		f_query_add_mod.document.ipparam_form.chk_booking_limit_by.disabled = false ;
		f_query_add_mod.document.ipparam_form.adm_date_chk_days_type.disabled = false ;
		f_query_add_mod.document.ipparam_form.vital_signs_battery_id.disabled = false ;
		f_query_add_mod.document.ipparam_form.diag_update_period_max_unit.disabled = false ;
		f_query_add_mod.document.ipparam_form.priority_appl_yn.disabled = false ;
		f_query_add_mod.document.ipparam_form.priority.disabled = false ;
		f_query_add_mod.document.ipparam_form.PAT_CHECK_IN_ALLOWED_YN.disabled = false ;
		f_query_add_mod.document.ipparam_form.DEACTIVATE_PSEUDO_BED_YN.disabled = false ;
		f_query_add_mod.document.ipparam_form.change_bed_class_yn.disabled = false ;
		f_query_add_mod.document.ipparam_form.discharge_checklist_app_yn.disabled = false ;
		f_query_add_mod.document.ipparam_form.bed_block_period_max_type.disabled = false ;
		f_query_add_mod.document.ipparam_form.bed_block_period_max_type1.disabled = false ;
		f_query_add_mod.document.ipparam_form.allow_release_bed_on_lv.disabled = false ;
		f_query_add_mod.document.ipparam_form.warn_or_error_max_leave[0].disabled = false ;
		f_query_add_mod.document.ipparam_form.warn_or_error_max_leave[1].disabled = false ;
		f_query_add_mod.document.ipparam_form.bl_interfaced_yn.disabled = false ;
		f_query_add_mod.document.ipparam_form.action_for_boc.disabled=false;
		f_query_add_mod.document.ipparam_form.action_for_bou.disabled=false;
		f_query_add_mod.document.ipparam_form.action_for_bnc.disabled=false;
		f_query_add_mod.document.ipparam_form.action_for_bnu.disabled=false;
		

		var fields=new Array();
		fields[0]= f_query_add_mod.document.ipparam_form.adm_date_chk_days;
		fields[1]= f_query_add_mod.document.ipparam_form.MAX_DISCH_PERIOD_FOR_DC;
		fields[2]= f_query_add_mod.document.ipparam_form.dis_date_chk_days;
		fields[3]= f_query_add_mod.document.ipparam_form.bed_block_period_normal;
		fields[4]= f_query_add_mod.document.ipparam_form.bed_block_period_dis;
		fields[5]= f_query_add_mod.document.ipparam_form.bed_block_period_max;
		fields[6]= f_query_add_mod.document.ipparam_form.adv_bed_book_period_bkg;
		fields[7]= f_query_add_mod.document.ipparam_form.chk_booking_limit_by;
		fields[8]= f_query_add_mod.document.ipparam_form.lodger_next_srl_no;
		fields[9]= f_query_add_mod.document.ipparam_form.lodger_max_srl_no;
		/*1/8/2009 CRF 4029*/
		fields[10]= f_query_add_mod.document.ipparam_form.grc_prd_for_asgn_bed_mark_arvl;
		fields[11]= f_query_add_mod.document.forms[0].change_admi;
		

		if (f_query_add_mod.document.ipparam_form.priority_appl_yn.checked == true)
		{
			if(f_query_add_mod.document.ipparam_form.priority.options.length > 1)
			{
				/*1/8/2009 CRF 4029*/
				//fields[10]= f_query_add_mod.document.ipparam_form.priority;
				fields[12]= f_query_add_mod.document.ipparam_form.priority;
				var names = new Array (	getLabel('eIP.MaxAllowableBackdatedAdmission.label','IP'),
					getLabel('Common.MaxDischargePeriodforDayCare.label','Common'),
					getLabel('eIP.MaxAllowableBackdatedDischarge.label','IP'),
					getLabel('eIP.NormalDefaultBedBlockingPeriod.label','IP'),
					getLabel('eIP.MaxAllowablePeriodforDischarge.label','IP'),
					getLabel('eIP.MaxAllowableBedblockingPeriod.label','IP'),
					getLabel('eIP.MaxAllowablePeriodforAdvanceBedBooking.label','IP'),
					getLabel('eIP.CheckBookingLimitBasedon.label','IP'),
					getLabel('eIP.LodgerReferenceNextSrlNo.label','IP'),
					getLabel('eIP.LodgerReferenceMaxSrlNo.label','IP'),
					getLabel('eIP.GrcprdforAsgnBed.label','IP'),
					getLabel('eAM.ChangeAdmDtls.label','AM'),
					getLabel('Common.priority.label','common')
					
					);
			}
			else
			{
					
					var names = new Array (	getLabel('eIP.MaxAllowableBackdatedAdmission.label','IP'),
					getLabel('Common.MaxDischargePeriodforDayCare.label','Common'),
					getLabel('eIP.MaxAllowableBackdatedDischarge.label','IP'),
					getLabel('eIP.NormalDefaultBedBlockingPeriod.label','IP'),
					getLabel('eIP.MaxAllowablePeriodforDischarge.label','IP'),
					getLabel('eIP.MaxAllowableBedblockingPeriod.label','IP'),
					getLabel('eIP.MaxAllowablePeriodforAdvanceBedBooking.label','IP'),
					getLabel('eIP.CheckBookingLimitBasedon.label','IP'),
					getLabel('eIP.LodgerReferenceNextSrlNo.label','IP'),
					getLabel('eIP.LodgerReferenceMaxSrlNo.label','IP'),
					getLabel('eIP.GrcprdforAsgnBed.label','IP'),
					getLabel('eAM.ChangeAdmDtls.label','AM')
						);
			}
		}
		else
		{
	
			var names = new Array (	getLabel('eIP.MaxAllowableBackdatedAdmission.label','IP'),
					getLabel('Common.MaxDischargePeriodforDayCare.label','Common'),
					getLabel('eIP.MaxAllowableBackdatedDischarge.label','IP'),
					getLabel('eIP.NormalDefaultBedBlockingPeriod.label','IP'),
					getLabel('eIP.MaxAllowablePeriodforDischarge.label','IP'),
					getLabel('eIP.MaxAllowableBedblockingPeriod.label','IP'),
					getLabel('eIP.MaxAllowablePeriodforAdvanceBedBooking.label','IP'),
					getLabel('eIP.CheckBookingLimitBasedon.label','IP'),
					getLabel('eIP.LodgerReferenceNextSrlNo.label','IP'),
					getLabel('eIP.LodgerReferenceMaxSrlNo.label','IP'),
					getLabel('eIP.GrcprdforAsgnBed.label','IP'),
					getLabel('eAM.ChangeAdmDtls.label','AM')
			   		);
		}

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	  {
		if(f_query_add_mod.document.ipparam_form.PAT_CHECK_IN_ALLOWED_YN.checked==true)
			f_query_add_mod.document.ipparam_form.PCIAY.value='Y';
		else
			f_query_add_mod.document.ipparam_form.PCIAY.value='N';

			if(f_query_add_mod.document.ipparam_form.change_bed_class_yn.checked==true)
			f_query_add_mod.document.ipparam_form.cbcy.value='Y';
		else
			f_query_add_mod.document.ipparam_form.cbcy.value='N';

		if(f_query_add_mod.document.ipparam_form.discharge_checklist_app_yn.checked==true)
		f_query_add_mod.document.ipparam_form.dcay.value='Y';
		else
		f_query_add_mod.document.ipparam_form.dcay.value='N';	
	

		if(f_query_add_mod.document.ipparam_form.DEACTIVATE_PSEUDO_BED_YN.checked==true)
			f_query_add_mod.document.ipparam_form.DPBY.value='Y';
		else
			f_query_add_mod.document.ipparam_form.DPBY.value='N';
		
		
		if(f_query_add_mod.document.ipparam_form.ALLOW_GATE_PASS_PRE_DIS_ADV_YN.checked==true) //added by mujafar for MO-CRF-20157
			f_query_add_mod.document.ipparam_form.AGPDA.value='Y';
		else
			f_query_add_mod.document.ipparam_form.AGPDA.value='N';
		
		/*ADDED BY SUJI KEERTHI ON 24-MAR-2020 FOR MOHE-CRF-0014*/
		if(f_query_add_mod.document.ipparam_form.enable_disch_diagnosis_yn.checked==true)
			f_query_add_mod.document.ipparam_form.enable_disch_diagnosis_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.enable_disch_diagnosis_yn.value='N';
		/*END MOHE-CRF-0014*/
		

		if(f_query_add_mod.document.ipparam_form.multi_book_pat_yn.checked==true)
			f_query_add_mod.document.ipparam_form.multi_book_pat_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.multi_book_pat_yn.value='N';
		//Added  for PMG2016-CRF-0002 IN061508 23rd Aug 16
		if(f_query_add_mod.document.ipparam_form.rel_booked_bed_yn.checked==true)
			f_query_add_mod.document.ipparam_form.rel_booked_bed_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.rel_booked_bed_yn.value='N';
		

		if(f_query_add_mod.document.ipparam_form.capture_fin_dtls_yn)
		  {
			if(f_query_add_mod.document.ipparam_form.capture_fin_dtls_yn.checked==true)
				f_query_add_mod.document.ipparam_form.capture_fin_dtls_yn.value='Y';
			else
				f_query_add_mod.document.ipparam_form.capture_fin_dtls_yn.value='N';
		  }

		if(f_query_add_mod.document.ipparam_form.reserve_bed_on_tfr_yn.checked==true)
			f_query_add_mod.document.ipparam_form.reserve_bed_on_tfr_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.reserve_bed_on_tfr_yn.value='N';
		
		/*Added by Thamizh selvi on 4th Nov 2016 against GHL-CRF-0412.2 Start*/
		if(f_query_add_mod.document.ipparam_form.chk_pen_ward_rtn_bfr_dis_adv!= null){
			if(f_query_add_mod.document.ipparam_form.chk_pen_ward_rtn_bfr_dis_adv.checked==true)
				f_query_add_mod.document.ipparam_form.chk_pen_ward_rtn_bfr_dis_adv.value='Y';
			else
				f_query_add_mod.document.ipparam_form.chk_pen_ward_rtn_bfr_dis_adv.value='N';
		}
		/*End*/

		/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
		if(f_query_add_mod.document.ipparam_form.autoCnrmTfrReq!= null){
			if(f_query_add_mod.document.ipparam_form.autoCnrmTfrReq.checked==true)
				f_query_add_mod.document.ipparam_form.autoCnrmTfrReq.value='Y';
			else
				f_query_add_mod.document.ipparam_form.autoCnrmTfrReq.value='N';
		}
		/*End*/

		/*Added by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866 Start*/
		if(f_query_add_mod.document.ipparam_form.dispBedClsChange.checked==true)
			f_query_add_mod.document.ipparam_form.dispBedClsChange.value='Y';
		else
			f_query_add_mod.document.ipparam_form.dispBedClsChange.value='N';
		/*End*/

		/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
		if(f_query_add_mod.document.ipparam_form.isNationalIdValidationAppl.value=="true")
		{
			if(f_query_add_mod.document.ipparam_form.validate_natid_IP_admsn.checked==true)
				f_query_add_mod.document.ipparam_form.validate_natid_IP_admsn.value='Y';
			else
				f_query_add_mod.document.ipparam_form.validate_natid_IP_admsn.value='N';
		}
		/*End MO-CRF-20148*/
		/*12/9/2008 3752	PMG20089-CRF-0047*/
		if(f_query_add_mod.document.ipparam_form.invk_admsn_frm_nwbrn_regYN.checked==true)
					f_query_add_mod.document.ipparam_form.invk_admsn_frm_nwbrn_regYN.value='Y';
			else
					f_query_add_mod.document.ipparam_form.invk_admsn_frm_nwbrn_regYN.value='N';
		/**/	

		/*11/10/2008 3698	SRR20056-CRF-0228*/
	
		if(f_query_add_mod.document.ipparam_form.allow_multiple_bed_for_resv_yn.checked==true)
			f_query_add_mod.document.ipparam_form.allow_multiple_bed_for_resv_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.allow_multiple_bed_for_resv_yn.value='N';
		/*11/10/2008 3698	SRR20056-CRF-0228*/

if(f_query_add_mod.document.ipparam_form.Allow_Invoke_Maintn_Dth_Reg_YN.checked==true)
			f_query_add_mod.document.ipparam_form.Allow_Invoke_Maintn_Dth_Reg_YN.value='Y';
		else
			f_query_add_mod.document.ipparam_form.Allow_Invoke_Maintn_Dth_Reg_YN.value='N';
/*for the CRF - Bru-HIMS-CRF 157*/
		if(f_query_add_mod.document.ipparam_form.allow_reason_for_late_discharge.checked==true)
			f_query_add_mod.document.ipparam_form.allow_reason_for_late_discharge.value='Y';
		else
			f_query_add_mod.document.ipparam_form.allow_reason_for_late_discharge.value='N';
		
		/*for CRF "MZ-CRF-0017-IP"  by sathish on Wednesday, March 03, 2010 starts here*/
		/*if(f_query_add_mod.document.ipparam_form.BED_MANDATORY_FOR_ADMN_YN.checked==true)
			f_query_add_mod.document.ipparam_form.BED_MANDATORY_FOR_ADMN_YN.value='Y';
		else
			f_query_add_mod.document.ipparam_form.BED_MANDATORY_FOR_ADMN_YN.value='N';*/
		/*Ends here*/

		if(f_query_add_mod.document.ipparam_form.capture_fin_dtls_yn)
			f_query_add_mod.document.ipparam_form.capture_fin_dtls_yn.disabled=false;

		/*18/11/2008 SCR 4020 FDPMG20089CRF0119IP */
		
		if(f_query_add_mod.document.ipparam_form.allow_booking_without_edd_yn.checked==true)
			f_query_add_mod.document.ipparam_form.allow_booking_without_edd_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.allow_booking_without_edd_yn.value='N';

		if(f_query_add_mod.document.ipparam_form.allow_booking_with_edd_yn.checked==true)
			f_query_add_mod.document.ipparam_form.allow_booking_with_edd_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.allow_booking_with_edd_yn.value='N';


		if(f_query_add_mod.document.ipparam_form.future_booking_for_boc_yn.checked==true)
			f_query_add_mod.document.ipparam_form.future_booking_for_boc_yn.value='Y';
		else{
			f_query_add_mod.document.ipparam_form.future_booking_for_boc_yn.value='N';
			f_query_add_mod.document.ipparam_form.action_for_boc.value='W';
		}


		if(f_query_add_mod.document.ipparam_form.consider_edd_stop_for_boc_yn.checked==true)
			f_query_add_mod.document.ipparam_form.consider_edd_stop_for_boc_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.consider_edd_stop_for_boc_yn.value='N';


		if(f_query_add_mod.document.ipparam_form.future_booking_for_bou_yn.checked==true)
			f_query_add_mod.document.ipparam_form.future_booking_for_bou_yn.value='Y';
		else{
			f_query_add_mod.document.ipparam_form.future_booking_for_bou_yn.value='N';
			f_query_add_mod.document.ipparam_form.action_for_bou.value='W';
		}


		if(f_query_add_mod.document.ipparam_form.consider_edd_stop_for_bou_yn.checked==true)
			f_query_add_mod.document.ipparam_form.consider_edd_stop_for_bou_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.consider_edd_stop_for_bou_yn.value='N';

		
		if(f_query_add_mod.document.ipparam_form.future_booking_for_bnc_yn.checked==true)
			f_query_add_mod.document.ipparam_form.future_booking_for_bnc_yn.value='Y';
		else{
			f_query_add_mod.document.ipparam_form.future_booking_for_bnc_yn.value='N';
			f_query_add_mod.document.ipparam_form.action_for_bnc.value='W';
		}


		if(f_query_add_mod.document.ipparam_form.consider_edd_stop_for_bnc_yn.checked==true)
			f_query_add_mod.document.ipparam_form.consider_edd_stop_for_bnc_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.consider_edd_stop_for_bnc_yn.value='N';

		
		if(f_query_add_mod.document.ipparam_form.future_booking_for_bnu_yn.checked==true)
			f_query_add_mod.document.ipparam_form.future_booking_for_bnu_yn.value='Y';
		else{
			f_query_add_mod.document.ipparam_form.future_booking_for_bnu_yn.value='N';
			f_query_add_mod.document.ipparam_form.action_for_bnu.value='W';
		}


		if(f_query_add_mod.document.ipparam_form.consider_edd_stop_for_bnu_yn.checked==true)
			f_query_add_mod.document.ipparam_form.consider_edd_stop_for_bnu_yn.value='Y';
		else
			f_query_add_mod.document.ipparam_form.consider_edd_stop_for_bnu_yn.value='N';
			
			
		
//Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
		if(f_query_add_mod.document.ipparam_form.chk_for_pen_orders_bfr_dis_adv.checked==true)
			{
			f_query_add_mod.document.ipparam_form.chk_for_pen_orders_bfr_dis_adv.value='Y';
			
			if(f_query_add_mod.document.ipparam_form.YES.checked==true)
	{
	
	f_query_add_mod.document.forms[0].radioYN.value="Y";
	
	}
		if(f_query_add_mod.document.ipparam_form.NO.checked==true)
	{
	
	f_query_add_mod.document.forms[0].radioYN.value="N";
	
	}		

			
			}
			else
			{
				f_query_add_mod.document.ipparam_form.chk_for_pen_orders_bfr_dis_adv.value='N';
				
			}
			// venkatesh KDAH-CRF-0041 END			
			
			/*Below Line Code Added for this CRF [JD-CRF-0006] by Senthil */
			
	if(f_query_add_mod.document.ipparam_form.chk_for_pen_orders_bfr_dis.checked==true){
	
			f_query_add_mod.document.ipparam_form.chk_for_pen_orders_bfr_dis.value='Y';
			
	if(f_query_add_mod.document.ipparam_form.dis_allow.checked==true)
	{
	
	f_query_add_mod.document.forms[0].pending_discharge.value="Y";
	
	}
	if(f_query_add_mod.document.ipparam_form.dis_notallow.checked==true)
	{
	
	f_query_add_mod.document.forms[0].pending_discharge.value="N";
	
	}			
	}else{
				f_query_add_mod.document.ipparam_form.chk_for_pen_orders_bfr_dis.value='N';
				
	}			
			/*Above Code Added for this CRF [JD-CRF-0006] by Senthil*/
			
	/*Below line added for this CRF ML-MMOH-CRF-0688*/
	
	if(f_query_add_mod.document.forms[0].Allow_Invoke_Maintn_Dth_Reg_YN && f_query_add_mod.document.forms[0].Allow_Invoke_Maintn_Dth_Reg_YN.checked==true)
	{ 			
		if(f_query_add_mod.document.forms[0].inv_deathreg_mandatory_y && f_query_add_mod.document.forms[0].inv_deathreg_mandatory_y.checked==true){
		    
		    f_query_add_mod.document.forms[0].invdeathregmandatoryYN.value="Y";
		}else if(f_query_add_mod.document.forms[0].inv_deathreg_mandatory_n && f_query_add_mod.document.forms[0].inv_deathreg_mandatory_n.checked==false){
		    f_query_add_mod.document.forms[0].invdeathregmandatoryYN.value="N";
			
	    }
		
	}	
	//End this CRF ML-MMOH-CRF-0688			

		f_query_add_mod.document.ipparam_form.submit();

	  }	
}

function onSuccess() 
{
	f_query_add_mod.location.reload();
}

function reset() 
{
	 f_query_add_mod.location.reload();

		if(f_query_add_mod.document.forms[0].bl_interfaced_yn != null)
		{
			/*if(f_query_add_mod.document.forms[0].bl_interfaced_yn.checked)
				f_query_add_mod.document.forms[0].setup_bl_dtls_in_ip_yn.disabled=false;
			else
				f_query_add_mod.document.forms[0].setup_bl_dtls_in_ip_yn.disabled=true;
			if(f_query_add_mod.document.ipparam_form.priority_appl_yn.checked == true)
				f_query_add_mod.document.ipparam_form.priority.disabled=false;*/
		}
}

//Function moved from IPParameter.jsp

function chknxt(obj)
{
	if(obj.value < document.getElementById("lodger_next_srl_no").value)
	{
		alert(getMessage("MAX_SRL_GR_NEXT_SRL","SM"));
		obj.focus();
	}
}

// Function will check for Zero values & alert a msg if entered zero
// coded on 17 FEB 2004 by Sridhar
function setfcs()
{
	//setTimeout("tab_click('outpat_act_tab')",65);
	document.getElementById("bkg_grace_period").focus();
}

function setfcs1()
{
	//setTimeout("tab_click('inpat_act_tab')",65);
	document.getElementById("lodger_next_srl_no").focus();
}

function CheckZeroVal(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 && obj.value==0) {
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","common"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}
//end of addition 
 var currentTab = new String();
 currentTab = "outpat_act_tab";
function tab_click(objName)
{
	changeTab(objName);
   if (objName == 'outpat_act_tab')
   moveToTab(1);
   else if (objName == 'inpat_act_tab')
   moveToTab(2);
 }
 
function moveToTab(TabIndex) 
{
    if ( TabIndex == 1 )
	 {
		document.getElementById("outpat_act_tab_vw").scrollIntoView();
		document.forms[0].adv_bed_book_period_bkg.focus();
	 }
    else if ( TabIndex == 2 )
	{
		document.getElementById("inpat_act_tab_vw").scrollIntoView();
		document.forms[0].lodger_next_srl_no.focus();
	}
 }

function changeTab(TabName) 
{
   /* if (currentTab == 'outpat_act_tab')
        document.getElementById("outpat_act_tab").src = '../../eAM/images/OutPatientActivities_click.gif';
    else if (currentTab == 'inpat_act_tab')
        document.getElementById("inpat_act_tab").src = '../../eAM/images/InPatientActivities.gif';

    if (TabName == 'outpat_act_tab'){
        document.getElementById("outpat_act_tab").src = '../../eAM/images/OutPatientActivities.gif';
		document.getElementById("inpat_act_tab").src = '../../eAM/images/InPatientActivities_click.gif';
	}
    else if (TabName == 'inpat_act_tab'){
		   document.getElementById("outpat_act_tab").src = '../../eAM/images/OutPatientActivities_click.gif';

		document.getElementById("inpat_act_tab").src = '../../eAM/images/InPatientActivities.gif';
	}*/
	currentTab = TabName;
}

function checkNormalMax(obj)
{
		maxVal		=	 obj.value;
		normalVal	=	 document.forms[0].bed_block_period_normal.value;
		if(document.forms[0].bed_block_period_max_type.value=="H")
		{
		if( maxVal.length>0)
			if(parseInt(maxVal) < parseInt(normalVal))
			{
				alert(getMessage('MAX_PRD_GR_NOR_BLOCK_PRD','IP'));
				//document.forms[0].bed_block_period_max.focus();
				//document.forms[0].bed_block_period_max.select();
				obj.value = "";
				obj.focus();
				
			}
		}
}

function checkNormalMax2(obj)
{
		maxVal		=	 obj.value;
		normalVal	=	 document.forms[0].bed_block_period_max.value;
		if(document.forms[0].bed_block_period_max_type.value=="H")
		{
		if( maxVal.length>0)
			if(parseInt(maxVal) > parseInt(normalVal))
			{
				alert(getMessage('MAX_PRD_GR_NOR_BLOCK_PRD','IP'));
				//document.forms[0].bed_block_period_max.focus();
				//document.forms[0].bed_block_period_max.select();
				obj.value = "";
				obj.focus();
			}
		}
}

function checkNormalMax1()
{
	maxVal		=	 document.forms[0].bed_block_period_max.value;
	normalVal	=	 document.forms[0].bed_block_period_normal.value;
	
	if(document.forms[0].bed_block_period_max_type.value=="H")
	{
	if( maxVal.length>0)
		if(parseInt(maxVal) < parseInt(normalVal))
		{
			alert(getMessage('MAX_PRD_GR_NOR_BLOCK_PRD','IP'));
			document.forms[0].bed_block_period_max.focus();
			document.forms[0].bed_block_period_max.select();
			return false;
		}
	}
}


	var errorFlag	=	false;
	var errorSource	=	"";

function validateSrlNo(sourceObject)
{
	var	lodger_next_srl_no_db	= "" ;
	lodger_next_srl_no_db	= document.ipparam_form.lodger_next_srl_no_db;
	var	lodger_next_srl_no		=  "" ;
	lodger_next_srl_no		= document.ipparam_form.lodger_next_srl_no;
	var lodger_max_srl_no		=	"" ; 
	lodger_max_srl_no		= 	document.ipparam_form.lodger_max_srl_no;

	if(checkIsNull(lodger_next_srl_no) && checkIsNull(lodger_max_srl_no) )
		return false;

	if( errorFlag && errorSource!=sourceObject.name ) return false;

	var	val_next_srl_no_db		=	parseFloat(lodger_next_srl_no_db.value);
	var	val_next_srl_no			=	parseFloat(lodger_next_srl_no.value);
	var	val_max_srl_no			=	parseFloat(lodger_max_srl_no.value);

	if(sourceObject.name=="lodger_next_srl_no")
	{
		if( val_next_srl_no > val_max_srl_no )
		{
			alert(getMessage("LODGER_REF_NO","IP"));
			lodger_next_srl_no.select();
			lodger_next_srl_no.focus();
			errorFlag	=	true;
			errorSource	=	sourceObject.name;
			return false;
		}
		else if( val_next_srl_no < val_next_srl_no_db )
		{
			var error = getMessage('LODGER_NEXT_SRL_NO','IP');
			error = error.replace('$',val_next_srl_no_db);
			alert(error);
			lodger_next_srl_no.select();
			lodger_next_srl_no.focus();
			errorFlag	=	true;
			errorSource	=	sourceObject.name;
			return false;
		}
	}
	else
	{
		if( val_next_srl_no > val_max_srl_no )
		{
			
			alert(getMessage("LODGER_REF_NO","IP"));
			lodger_max_srl_no.select();
			lodger_max_srl_no.focus();
			errorFlag	=	true;
			errorSource	=	sourceObject.name;
			return false;
		}
		if( val_max_srl_no < val_next_srl_no_db )
		{
			var error = getMessage('LODGER_NEXT_SRL_NO','IP');
			error = error.replace('$',val_next_srl_no_db);
			alert(error);
			lodger_max_srl_no.select();
			lodger_max_srl_no.focus();
			errorFlag	=	true;
			errorSource	=	sourceObject.name;
			return false;
		}
	}
	errorFlag	=	false;
	errorSource	=	"";
}

function checkIsNull(obj)
{	
	if(trimCheck(obj.value))	
		return	false;
	else
		return	true;
}

function InterfacetoBL()
{
	/*if(document.ipparam_form.bl_interfaced_yn.checked==true)
	{
		document.getElementById("blpar").style.visibility='visible';
		document.getElementById("blparam").style.visibility='visible';
	}
	else
	{
		document.getElementById("blpar").style.visibility='hidden';
		document.getElementById("blparam").style.visibility='hidden';
	}*/
}

function focusTxt()
{	
	//document.getElementById("outpat_act_tab_vw").scrollIntoView();
	document.ipparam_form.bkg_grace_period.focus();
}

function changepriority()
{
	if (document.ipparam_form.priority.value)
		ipparam_form.star.style.visibility = 'visible';
	else 
		ipparam_form.star.style.visibility = 'hidden';
	
/*if(document.ipparam_form.priority.options[0].selected)
	document.ipparam_form.priority.disabled = false;
else
	document.ipparam_form.priority.disabled = true;*/

	/*11/10/2008 3698	SRR20056-CRF-0228*/
	if(document.forms[0].reserve_bed_on_tfr_yn.checked == true)
		document.forms[0].allow_multiple_bed_for_resv_yn.disabled = false;
	else{	
			document.forms[0].allow_multiple_bed_for_resv_yn.disabled = true;
			document.forms[0].allow_multiple_bed_for_resv_yn.checked = false;
			document.forms[0].allow_multiple_bed_for_resv_yn.value = "N";
		}

}
/*11/10/2008 3698	SRR20056-CRF-0228*/
function checkMultiple()
{ 
	if(document.forms[0].reserve_bed_on_tfr_yn.checked == true)
		document.forms[0].allow_multiple_bed_for_resv_yn.disabled = false;
	else{	
			document.forms[0].allow_multiple_bed_for_resv_yn.disabled = true;
			document.forms[0].allow_multiple_bed_for_resv_yn.checked = false;
			document.forms[0].allow_multiple_bed_for_resv_yn.value = "N";
		}

}

	//Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
function dischargeAdvice()
{

if(document.forms[0].chk_for_pen_orders_bfr_dis_adv.checked==true)
{ 

document.forms[0].NO.disabled=false;
document.forms[0].YES.disabled=false
if (document.forms[0].NO.checked==true)
{
document.forms[0].YES.checked=false;
}
}
if(document.forms[0].chk_for_pen_orders_bfr_dis_adv.checked==false)
{ 
document.forms[0].NO.disabled=true;
document.forms[0].YES.disabled=true;
document.forms[0].NO.checked=false;
document.forms[0].YES.checked=false;
}
}
function clearRadio_1(obj)
{
var radioYN="";
if(document.forms[0].YES.checked==true)
	{
	document.forms[0].YES.checked=false;
	}
	 radioYN="NO";
	
}
function clearRadio_2(obj)
{
var radioYN="";
if(document.forms[0].NO.checked==true)
	{
	document.forms[0].NO.checked=false;
	}
radioYN="YES";
	
	}

//Added for the CRF - Bru-HIMS-CRF-157
function mandatoryDischargeReason()
{

	if(document.forms[0].allow_reason_for_late_discharge.checked==true)
	{ 
		
		document.forms[0].mandatory_option_y.disabled=false;
		document.forms[0].mandatory_option_n.disabled=false;
		if (document.forms[0].mandatory_option_y.checked==true)
		{
		document.forms[0].mandatory_option_n.checked=false;
		}
	}
	if(document.forms[0].allow_reason_for_late_discharge.checked==false)
	{ 
		document.forms[0].mandatory_option_y.disabled=true;
		document.forms[0].mandatory_option_n.disabled=true;
		document.forms[0].mandatory_option_y.checked=false;
		document.forms[0].mandatory_option_n.checked=false;
		//document.forms[0].mandatory.style.visibility="hidden";

	}
}

//Added for the CRF - Bru-HIMS-CRF-157
function mandatory_radio_1()
{	
	if(document.forms[0].mandatory_option_y.checked==true)
	{	
		document.forms[0].mandatory_option_n.checked=false;	
	}
	document.forms[0].mandatoryYN.value='Y';
}

//Added for the CRF - Bru-HIMS-CRF-157
function mandatory_radio_2()
{	
	if(document.forms[0].mandatory_option_n.checked==true)
	{
		document.forms[0].mandatory_option_y.checked=false;
	}
	document.forms[0].mandatoryYN.value='N';
}


function disBAC()
{
		if(document.forms[0].future_booking_for_boc_yn.checked == false){
			document.forms[0].no_of_days_before_for_boc.value = '';
			document.forms[0].no_of_days_before_for_boc.disabled = true
			document.forms[0].consider_edd_stop_for_boc_yn.value = '';
			document.forms[0].consider_edd_stop_for_boc_yn.checked = false;
			document.forms[0].consider_edd_stop_for_boc_yn.disabled = true
			document.forms[0].action_for_boc.value = 'W';
			document.forms[0].action_for_boc.disabled = true
			
	}
		if(document.forms[0].future_booking_for_bou_yn.checked == false){
			document.forms[0].no_of_days_before_for_bou.value = '';
			document.forms[0].no_of_days_before_for_bou.disabled = true
			document.forms[0].consider_edd_stop_for_bou_yn.value = '';
			document.forms[0].consider_edd_stop_for_bou_yn.checked = false;
			document.forms[0].consider_edd_stop_for_bou_yn.disabled = true
			document.forms[0].action_for_boc.value = 'W';
			document.forms[0].action_for_bou.disabled = true
	}
		if(document.forms[0].future_booking_for_bnc_yn.checked == false){
			document.forms[0].no_of_days_before_for_bnc.value = '';
			document.forms[0].no_of_days_before_for_bnc.disabled = true
			document.forms[0].consider_edd_stop_for_bnc_yn.value = '';
			document.forms[0].consider_edd_stop_for_bnc_yn.checked = false;
			document.forms[0].consider_edd_stop_for_bnc_yn.disabled = true
			document.forms[0].action_for_boc.value = 'W';
			document.forms[0].action_for_bnc.disabled = true
	} 
		if(document.forms[0].future_booking_for_bnu_yn.checked == false){
			document.forms[0].no_of_days_before_for_bnu.value = '';
			document.forms[0].no_of_days_before_for_bnu.disabled = true
			document.forms[0].consider_edd_stop_for_bnu_yn.value = '';
			document.forms[0].consider_edd_stop_for_bnu_yn.checked = false;
			document.forms[0].consider_edd_stop_for_bnu_yn.disabled = true
			document.forms[0].action_for_boc.value = 'W';
			document.forms[0].action_for_bnu.disabled = true
		}
}

/*Below Line Added for this CRF [JD-CRF-0006] by Senthil*/
function pendingDischarge()
{

if(document.forms[0].chk_for_pen_orders_bfr_dis.checked==true)
{ 

document.forms[0].dis_notallow.disabled=false;
document.forms[0].dis_allow.disabled=false
if (document.forms[0].dis_notallow.checked==true)
{
document.forms[0].dis_allow.checked=false;
}
}
if(document.forms[0].chk_for_pen_orders_bfr_dis.checked==false)
{ 
document.forms[0].dis_notallow.disabled=true;
document.forms[0].dis_allow.disabled=true;
document.forms[0].dis_notallow.checked=false;
document.forms[0].dis_allow.checked=false;
}
}
function notAllowDischarge(obj)
{
var pending_discharge="";
if(document.forms[0].dis_allow.checked==true)
	{
	document.forms[0].dis_allow.checked=false;	
	}
	pending_discharge="NO";
	
}
function allowDischarge(obj)
{
var pending_discharge="";
if(document.forms[0].dis_notallow.checked==true)
	{
	document.forms[0].dis_notallow.checked=false;	
	}	
   pending_discharge="YES";
}

/*Above Line Added for this CRF [JD-CRF-0006] by Senthil*/

function EnableResBedIntraward()
	{
	if(document.forms[0].reserve_bed_on_tfr_yn.checked == true)
		document.forms[0].res_reserve_bed_intraward_yn.disabled = false;
	else{	
			document.forms[0].res_reserve_bed_intraward_yn.disabled = true;
			document.forms[0].res_reserve_bed_intraward_yn.checked = false;
			document.forms[0].res_reserve_bed_intraward_yn.value = "N";
		}
	}
function ChkReserveBedIntrawardYN()
		{
		if(document.forms[0].res_reserve_bed_intraward_yn.checked == true)
		document.forms[0].res_reserve_bed_intraward_yn.value='Y';
		else
		document.forms[0].res_reserve_bed_intraward_yn.value='N';
		}
		
// added by mujafar for ML-MMOH-CRF-0659		
function ChkModifyDiscTypeStatus()
{ 
		if(document.forms[0].allow_user_modify_disc_type_status_yn.checked == true)
		document.forms[0].allow_user_modify_disc_type_status_yn.value='Y';
		else
		document.forms[0].allow_user_modify_disc_type_status_yn.value='N';
	
}
		
		
		
/*Below line added for this CRF ML-MMOH-CRF-0688*/	
function invdeath_mandatory_radio()
{	
	if(document.forms[0].inv_deathreg_mandatory_y.checked==true)
	{	
		document.forms[0].inv_deathreg_mandatory_n.checked=false;	
	}
	document.forms[0].invdeathregmandatoryYN.value='Y';
}

function invdeath_nonmandatory_radio()
{	
	if(document.forms[0].inv_deathreg_mandatory_n.checked==true)
	{
		document.forms[0].inv_deathreg_mandatory_y.checked=false;
	}
	document.forms[0].invdeathregmandatoryYN.value='N';
}

function mandatoryDeathCheck()
{

	if(document.forms[0].Allow_Invoke_Maintn_Dth_Reg_YN && document.forms[0].Allow_Invoke_Maintn_Dth_Reg_YN.checked==true)
	{ 
		
		document.forms[0].inv_deathreg_mandatory_y.disabled=false;
		document.forms[0].inv_deathreg_mandatory_y.checked=false;
		document.forms[0].inv_deathreg_mandatory_n.checked=true;
		document.forms[0].inv_deathreg_mandatory_n.disabled=false;		
		
		
	}
	if(document.forms[0].Allow_Invoke_Maintn_Dth_Reg_YN && document.forms[0].Allow_Invoke_Maintn_Dth_Reg_YN.checked==false)
	{    
	    document.forms[0].inv_deathreg_mandatory_y.checked=false;
		document.forms[0].inv_deathreg_mandatory_y.disabled=true;
		document.forms[0].inv_deathreg_mandatory_n.checked=false;
		document.forms[0].inv_deathreg_mandatory_n.disabled=true;		
		

	}
}	

//End ML-MMOH-CRF-0688
		
