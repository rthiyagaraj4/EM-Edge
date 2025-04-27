function reset()
{	
	f_query_add_mod.document.forms[0].reset();

	if (f_query_add_mod.document.Rep2AdmissionCensesForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2AdmissionCenses.jsp';
	}
	if (f_query_add_mod.document.Rep2MonthlyIPCensusNursingUnitForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2MonthlyCensesNursingUnit.jsp';
	}		
	if (f_query_add_mod.document.Rep2MonthlyIPCensusSpecialityForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2MonthlyCensesSpeciality.jsp';
	}
	if (f_query_add_mod.document.Rep2CurrentIPListForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2CurrentIPListDet.jsp';
	}
	if (f_query_add_mod.document.Rep2AdmissionForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2AdmissionDet_SRR.jsp';
	}
	if (f_query_add_mod.document.Rep2DischargeForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2DischargeDet.jsp';
	}
	if (f_query_add_mod.document.Rep2TransferForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2TransferDet_SRR.jsp';
	}
	if (f_query_add_mod.document.Rep2MovementHistForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2MovementHistory.jsp';
	}

	if (f_query_add_mod.document.Rep2DischargeSummaryForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2AdmissionCenses.jsp';
	}

	if (f_query_add_mod.document.Rep2AgeRangeStatForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2AgeRangeStat_SRR.jsp';
	}
	if (f_query_add_mod.document.Rep2DlyBkgListForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2DailyBookingList_SRR.jsp';
	}

	if (f_query_add_mod.document.Rep2RepLengthOfStayForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2RepLengthOfStay.jsp';
	}
	if (f_query_add_mod.document.Rep2DlyAdmnTypeForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2DlyAdmnType.jsp';
	}
	if (f_query_add_mod.document.Rep2MthlyAdmnTypeForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2MthlyAdmnType.jsp';
	}

	if (f_query_add_mod.document.Rep2YrlyAdmnTypeForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2YrlyAdmnType.jsp';
	}

	if (f_query_add_mod.document.RepIPPeriodOfStayForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2IPPeriodOfStay_SRR.jsp';
	}

	if (f_query_add_mod.document.repAssesDiagStatForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/rep2AssessDiagStat_SRR.jsp';
	}

	if (f_query_add_mod.document.repBedStatChartForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/rep2BedStatChart_SRR.jsp';
	}

	if (f_query_add_mod.document.Rep2CircumstanceofInjuryStatForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/Rep2CircumstanceofInjuryStat.jsp';
	}
	/*if(f_query_add_mod.document.Rep2AgeRangeStatForm)
	{
		f_query_add_mod.document.Rep2AgeRangeStatForm.mand_image1.style.visibility='hidden';
	}*/
}//e.o.reset

function run()
{	
	

	if (f_query_add_mod.document.Rep2CurrentIPListForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eMP.PatientSeriesCode.label','MP'), f_query_add_mod.document.Rep2CurrentIPListForm.p_fm_pat_series,f_query_add_mod.document.Rep2CurrentIPListForm.p_to_pat_series, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2CurrentIPListForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2CurrentIPListForm.p_to_nursing_unit, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2CurrentIPListForm.p_fm_bed_class,f_query_add_mod.document.Rep2CurrentIPListForm.p_to_bed_class, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.practitionerid.label','common'), f_query_add_mod.document.Rep2CurrentIPListForm.p_fm_practitioner,f_query_add_mod.document.Rep2CurrentIPListForm.p_to_practitioner, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2CurrentIPListForm.p_fm_speciality,f_query_add_mod.document.Rep2CurrentIPListForm.p_to_speciality, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.NationalityCode.label','common'), f_query_add_mod.document.Rep2CurrentIPListForm.p_fm_nationality,f_query_add_mod.document.Rep2CurrentIPListForm.p_to_nationality, messageFrame )  )
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
	    f_query_add_mod.document.Rep2CurrentIPListForm.submit() ;
	}
	else
	{
		if(f_query_add_mod.document.Rep2AdmissionForm)
		{
		var fields = new Array( f_query_add_mod.document.Rep2AdmissionForm.p_fm_admission_date,
					f_query_add_mod.document.Rep2AdmissionForm.p_to_admission_date );

		var names = new Array(getLabel('eIP.AdmDateFrom.label','IP'), getLabel('eIP.AdmDateTo.label','IP'));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
	
		if( f_query_add_mod.doDateCheck( f_query_add_mod.document.Rep2AdmissionForm.p_fm_admission_date,f_query_add_mod.document.Rep2AdmissionForm.p_to_admission_date, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('eIP.AdmissionTypeCode.label','IP'), f_query_add_mod.document.Rep2AdmissionForm.p_fm_adm_type,f_query_add_mod.document.Rep2AdmissionForm.p_to_adm_type, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2AdmissionForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2AdmissionForm.p_to_nursing_unit, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2AdmissionForm.p_fm_bed_class,f_query_add_mod.document.Rep2AdmissionForm.p_to_bed_class, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.practitionerid.label','common'), f_query_add_mod.document.Rep2AdmissionForm.p_fm_practitioner,f_query_add_mod.document.Rep2AdmissionForm.p_to_practitioner, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2AdmissionForm.p_fm_speciality,f_query_add_mod.document.Rep2AdmissionForm.p_to_speciality, messageFrame )  )
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Rep2AdmissionForm.submit() ;
		}
		}
		}
		else
		{
		if(f_query_add_mod.document.Rep2DischargeForm)
		{
			//alert("hello")
		var fields = new Array( f_query_add_mod.document.Rep2DischargeForm.p_fm_discharge_date,
		f_query_add_mod.document.Rep2DischargeForm.p_to_discharge_date );
		var names = new Array(getLabel('eIP.DischargeDateFrom.label','IP'), getLabel('eIP.DischargeDateTo.label','IP'));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		if( !doDateCheckAlert( f_query_add_mod.document.Rep2DischargeForm.p_fm_discharge_date,f_query_add_mod.document.Rep2DischargeForm.p_to_discharge_date )  )
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				f_query_add_mod.document.Rep2DischargeForm.p_to_discharge_date.select();
				return;
			}

		if( CheckString1(getLabel('eIP.DischargeTypeCode.label','IP'), f_query_add_mod.document.Rep2DischargeForm.p_fm_dis_type,f_query_add_mod.document.Rep2DischargeForm.p_to_dis_type, messageFrame )  ) {
		
		if( CheckString1(getLabel('eIP.DischargeStatus.label','IP')+' '+getLabel('Common.code.label','common'),  f_query_add_mod.document.Rep2DischargeForm.p_fm_dis_status,f_query_add_mod.document.Rep2DischargeForm.p_to_dis_status, messageFrame )  ) {

		if( CheckString1(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2DischargeForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2DischargeForm.p_to_nursing_unit, messageFrame )  ) {

		if( CheckString1(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2DischargeForm.p_fm_bed_class,f_query_add_mod.document.Rep2DischargeForm.p_to_bed_class, messageFrame )  ) {

		if( CheckString1(getLabel('Common.practitionertype.label','common'), f_query_add_mod.document.Rep2DischargeForm.fm_pract_type,f_query_add_mod.document.Rep2DischargeForm.to_pract_type, messageFrame )  ) {
		
		if( CheckString1(getLabel('Common.practitionerid.label','Common'), f_query_add_mod.document.Rep2DischargeForm.p_fm_practitioner,f_query_add_mod.document.Rep2DischargeForm.p_to_practitioner, messageFrame )  ) {

		if( CheckString1(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2DischargeForm.p_fm_speciality,f_query_add_mod.document.Rep2DischargeForm.p_to_speciality, messageFrame )  ) {





		if( f_query_add_mod.CheckString(getLabel('eIP.DischargeTypeCode.label','IP'), f_query_add_mod.document.Rep2DischargeForm.p_fm_dis_type,f_query_add_mod.document.Rep2DischargeForm.p_to_dis_type, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2DischargeForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2DischargeForm.p_to_nursing_unit, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2DischargeForm.p_fm_bed_class,f_query_add_mod.document.Rep2DischargeForm.p_to_bed_class, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.practitionerid.label','common'), f_query_add_mod.document.Rep2DischargeForm.p_fm_practitioner,f_query_add_mod.document.Rep2DischargeForm.p_to_practitioner, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2DischargeForm.p_fm_speciality,f_query_add_mod.document.Rep2DischargeForm.p_to_speciality, messageFrame )  )
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Rep2DischargeForm.submit() ;
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		else
		{
		if(f_query_add_mod.document.Rep2TransferForm  )
		{
		var fields = new Array( f_query_add_mod.document.Rep2TransferForm.p_fr_trans_date,
					f_query_add_mod.document.Rep2TransferForm.p_to_trans_date );

		var names = new Array(getLabel("Common.Transfer.label","Common")+' '+getLabel("Common.DateFrom.label","Common"),getLabel("Common.transferdate.label","Common")+' '+getLabel("Common.to.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		if( !doDateCheckAlert( f_query_add_mod.document.Rep2TransferForm.p_fr_trans_date,f_query_add_mod.document.Rep2TransferForm.p_to_trans_date)  )
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				f_query_add_mod.document.Rep2TransferForm.p_to_trans_date.select();
				return;
			}



		if( CheckString1(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2TransferForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2TransferForm.p_to_nursing_unit, messageFrame )  ) {
			
    if(CheckString1(getLabel('Common.SpecialityCode.label','Common'), f_query_add_mod.document.Rep2TransferForm.p_fm_speciality_code,f_query_add_mod.document.Rep2TransferForm.p_to_speciality_code, messageFrame )  ) {
		if( CheckString1(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2TransferForm.p_fm_bed_class,f_query_add_mod.document.Rep2TransferForm.p_to_bed_class, messageFrame )  )
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Rep2TransferForm.submit() ;
		}
		}
		}
		}


		var from_nursingunit=f_query_add_mod.document.Rep2TransferForm.p_fm_nursing_unit.value;
		var to_nursingunit=f_query_add_mod.document.Rep2TransferForm.p_to_nursing_unit.value;
		var transfer_type=f_query_add_mod.document.forms[0].transfer_type.value;
		
		if((from_nursingunit != null  && to_nursingunit != null )&&(from_nursingunit != ""  && to_nursingunit != "" ) ){
			if((from_nursingunit == to_nursingunit)&& ((transfer_type=='2') || (transfer_type=='5') ||(transfer_type=='4') || (transfer_type=='3')) || (from_nursingunit != to_nursingunit) && ((transfer_type=='1')||(transfer_type=='5'))){
			return true;
		}
		
		else
			{
			
			var arr = new Array(to_nursingunit,from_nursingunit);
			if(transfer_type != '1')
			{
				var error=getMessage("SHOULD_BE_EQUAL","IP");
				error = error.replace('$',getLabel("Common.FromNursingUnit.label","Common"));
				error = error.replace('#',getLabel("Common.ToNursingUnit.label","Common"));
			}
			else
			{
				var error=getMessage("CAN_NOT_BE_SAME","IP");
				error = error.replace('$',getLabel("Common.nursingUnit.label","Common"));
			}
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
			}
			
		}
 
	
		}
		else
		{
		if(f_query_add_mod.document.Rep2MovementHistForm || f_query_add_mod.document.Rep2DischargeSummaryForm)

		{				
		if(f_query_add_mod.document.Rep2MovementHistForm) 
		{
		if(f_query_add_mod.document.Rep2MovementHistForm.p_encounter_id.value == "")
		{
		var err = f_query_add_mod.getMessage("CAN_NOT_BE_BLANK","common");
		err = err.replace('$',getLabel("Common.encounterid.label","Common"));
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err;
		f_query_add_mod.document.Rep2MovementHistForm.p_encounter_id.focus();
		}
		else
		f_query_add_mod.document.forms[0].submit() ;
		}
		else
		f_query_add_mod.document.forms[0].submit() ;
		}
		else
		{
		if(f_query_add_mod.document.Rep2AdmissionCensesForm)
		{
			if(f_query_add_mod.document.Rep2AdmissionCensesForm.p_col1.value != "")
			{
				if(chkEqual())
				{
					/*if( !f_query_add_mod.doDateCheckAlert( f_query_add_mod.document.Rep2AdmissionCensesForm.p_fm_admission_date,f_query_add_mod.document.Rep2AdmissionCensesForm.p_to_admission_date )  )
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
						f_query_add_mod.document.Rep2AdmissionCensesForm.p_to_admission_date.select();
						return;
					}*/
					if(!chkIsBeforeDate(f_query_add_mod.document.Rep2AdmissionCensesForm.p_fm_admission_date,f_query_add_mod.document.Rep2AdmissionCensesForm.p_to_admission_date))
						return;			

					if( f_query_add_mod.CheckString(getLabel('eIP.AdmissionTypeCode.label','IP'), f_query_add_mod.document.Rep2AdmissionCensesForm.p_fm_adm_type,f_query_add_mod.document.Rep2AdmissionCensesForm.p_to_adm_type, messageFrame )  )
					if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2AdmissionCensesForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2AdmissionCensesForm.p_to_nursing_unit, messageFrame )  )
					if( f_query_add_mod.CheckString(getLabel('Common.practitionerid.label','common'), f_query_add_mod.document.Rep2AdmissionCensesForm.p_fm_practitioner,f_query_add_mod.document.Rep2AdmissionCensesForm.p_to_practitioner, messageFrame )  )
					if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2AdmissionCensesForm.p_fm_speciality,f_query_add_mod.document.Rep2AdmissionCensesForm.p_to_speciality, messageFrame )  )
					{
                     f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		             f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.Rep2AdmissionCensesForm.submit() ;
					}
				}
			}		
		}
		else
		{
		if(f_query_add_mod.document.Rep2AgeRangeStatForm)
		{
			
		/*if (f_query_add_mod.document.Rep2AgeRangeStatForm.p_all_facility_id.value=='All')
		{
		var fields = new Array(f_query_add_mod.document.Rep2AgeRangeStatForm.p_trn_date_time);
		var names = new Array ( "Date")
		}
		else*/
		//{
		var fields = new Array(	f_query_add_mod.document.Rep2AgeRangeStatForm.p_fm_age_range,
		f_query_add_mod.document.Rep2AgeRangeStatForm.P_FR_TRN_DATE_TIME,f_query_add_mod.document.Rep2AgeRangeStatForm.P_TO_TRN_DATE_TIME);
		var names = new Array (getLabel("Common.AgeRange.label","Common")+" "+getLabel("Common.code.label","Common"),getLabel("Common.admit.label","Common")+" "+getLabel("Common.date.label","Common")+" "+getLabel("Common.from.label","Common"),getLabel("Common.admit.label","Common")+" "+getLabel("Common.date.label","Common")+" "+getLabel("Common.to.label","Common"));
		//}

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if( !doDateCheckAlert( f_query_add_mod.document.Rep2AgeRangeStatForm.P_FR_TRN_DATE_TIME,f_query_add_mod.document.Rep2AgeRangeStatForm.P_TO_TRN_DATE_TIME)  )
			{
				var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");					
				 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
				return;
			}
              f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		      f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.Rep2AgeRangeStatForm.submit() ;
		}
		}
		else
		{
		if(f_query_add_mod.document.Rep2DlyBkgListForm)
		{

		if( !doDateCheckAlert(f_query_add_mod.document.Rep2DlyBkgListForm.p_fm_admission_date,f_query_add_mod.document.Rep2DlyBkgListForm.p_to_admission_date )  )
			{
					//alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
					var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");					
					 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
					//f_query_add_mod.document.Rep2DlyBkgListForm.p_to_admission_date.select();
					return false;
			}
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2DlyBkgListForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2DlyBkgListForm.p_to_nursing_unit, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.practitionerid.label','common'), f_query_add_mod.document.Rep2DlyBkgListForm.p_fm_practitioner,f_query_add_mod.document.Rep2DlyBkgListForm.p_to_practitioner, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2DlyBkgListForm.p_fm_bed_class,f_query_add_mod.document.Rep2DlyBkgListForm.p_to_bed_class, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2DlyBkgListForm.p_fm_specialty_code,f_query_add_mod.document.Rep2DlyBkgListForm.p_to_specialty_code, messageFrame )  )		
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Rep2DlyBkgListForm.submit() ;
		}
		}
		else
		{
		if(f_query_add_mod.document.Rep2RepLengthOfStayForm)
		{
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2RepLengthOfStayForm.p_fm_nursing_unit_code,f_query_add_mod.document.Rep2RepLengthOfStayForm.p_to_nursing_unit_code, messageFrame )  )
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Rep2RepLengthOfStayForm.submit() ;
		}
		}
		else
		{	// Cancelled Admission List
		if(f_query_add_mod.document.Rep2CancelAdmnListForm)
		{
		var fields = new Array( f_query_add_mod.document.Rep2CancelAdmnListForm.p_fm_adt_status_set_on_date,
		f_query_add_mod.document.Rep2CancelAdmnListForm.p_to_adt_status_set_on_date );

		var names = new Array(getLabel("Common.CancelledDateFrom.label","Common"), getLabel("eIP.CancelledDateTo.label","IP"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		
		if( !doDateCheckAlert( f_query_add_mod.document.Rep2CancelAdmnListForm.p_fm_adt_status_set_on_date,f_query_add_mod.document.Rep2CancelAdmnListForm.p_to_adt_status_set_on_date )  )
			{
				//alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				//f_query_add_mod.document.Rep2CancelAdmnListForm.p_to_adt_status_set_on_date.select();
				var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");					
				 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
				return;
			}
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2CancelAdmnListForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2CancelAdmnListForm.p_to_nursing_unit, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel("Common.roomno.label","Common"), f_query_add_mod.document.Rep2CancelAdmnListForm.p_fm_assign_room_num,f_query_add_mod.document.Rep2CancelAdmnListForm.p_to_assign_room_num, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2CancelAdmnListForm.p_fm_specialty_code,f_query_add_mod.document.Rep2CancelAdmnListForm.p_to_specialty_code, messageFrame )  )
		{
			if ( f_query_add_mod.document.Rep2CancelAdmnListForm.p_current_patient_yn.checked == true)
			{
				f_query_add_mod.document.Rep2CancelAdmnListForm.p_current_patient_yn.value="Y";
			}
			else if ( f_query_add_mod.document.Rep2CancelAdmnListForm.p_current_patient_yn.checked == false)
			{
				f_query_add_mod.document.Rep2CancelAdmnListForm.p_current_patient_yn.cheked=false;
				f_query_add_mod.document.Rep2CancelAdmnListForm.p_current_patient_yn.value="N";
			}
			f_query_add_mod.document.Rep2CancelAdmnListForm.p_current_patient_yn.value = f_query_add_mod.document.Rep2CancelAdmnListForm.current_patient_yn.value;
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		    f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.Rep2CancelAdmnListForm.submit() ;
		}
		}
		}
		else
		{
		if(f_query_add_mod.document.RepIPPeriodOfStayForm)
		{
		if(f_query_add_mod.chkAscendingOrder())
		{		
		if( f_query_add_mod.CheckString(getLabel('Common.SpecialityCode.label','Common'), f_query_add_mod.document.RepIPPeriodOfStayForm.P_FM_SPECIALTY_CODE,f_query_add_mod.document.RepIPPeriodOfStayForm.P_TO_SPECIALTY_CODE, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.RepIPPeriodOfStayForm.p_fr_nursing_unit_code,f_query_add_mod.document.RepIPPeriodOfStayForm.p_to_nursing_unit_code, messageFrame )  )		
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.RepIPPeriodOfStayForm.submit() ;
		}
		}
		}
		//added for Daily Census Summary Report 
		
	    else{
         if(f_query_add_mod.document.Rep2DailyIPCensusSummaryForm)
		 {
		 var fields = new Array(f_query_add_mod.document.Rep2DailyIPCensusSummaryForm.p_trn_date,f_query_add_mod.document.Rep2DailyIPCensusSummaryForm.P_NATIONALITY_CODE);
		 var names = new Array (	getLabel('eIP.CensusDate.label','IP') ,getLabel('Common.nationality.label','Common'))

	     if(f_query_add_mod.checkFields( fields, names, messageFrame))
		 {
		 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		 f_query_add_mod.document.forms[0].target="messageFrame";
		 f_query_add_mod.document.Rep2DailyIPCensusSummaryForm.submit() ;
		 }
		 }
        else
		{
		if(f_query_add_mod.document.Rep2DailyIPCensusForm)
		{
			 if( Check_daily_census(getLabel('Common.NursingUnitCode.label','common'), f_query_add_mod.document.Rep2DailyIPCensusForm.p_fr_nursing_unit_code,f_query_add_mod.document.Rep2DailyIPCensusForm.p_to_nursing_unit_code, messageFrame )  )
		{

		var fields = new Array(f_query_add_mod.document.Rep2DailyIPCensusForm.p_trn_date);
		var names = new Array (	getLabel('eIP.CensusDate.label','IP'))

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Rep2DailyIPCensusForm.submit() ;
		}
		}
		}
		else
		{
		if(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm)
         {
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.p_fr_speciality,f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.p_to_speciality, messageFrame )  )
		{

		var fields = new Array(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.p_trn_date);
		var names = new Array (	getLabel('eIP.CensusDate.label','IP'))

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.submit() ;
		}
		}
		}
		else 
		{
		if(f_query_add_mod.document.Rep2DailyIPCensusBedClassForm)
		{
		if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2DailyIPCensusBedClassForm.p_fr_bed_class,f_query_add_mod.document.Rep2DailyIPCensusBedClassForm.p_to_bed_class, messageFrame )  )
		{
		var fields = new Array(f_query_add_mod.document.Rep2DailyIPCensusBedClassForm.p_trn_date);
		var names = new Array (	getLabel('eIP.CensusDate.label','IP'))

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Rep2DailyIPCensusBedClassForm.submit() ;
		}
		}
		}
		else
		{
		if(f_query_add_mod.document.Rep2MonthlyIPCensusNursingUnitForm)
		{
		var fields = new Array(f_query_add_mod.document.Rep2MonthlyIPCensusNursingUnitForm.p_trn_date,f_query_add_mod.document.Rep2MonthlyIPCensusNursingUnitForm.p_nursing_unit_code);
		var names = new Array (getLabel('Common.NursingUnitCode.label','Common'))


		var reptype=f_query_add_mod.document.getElementById("p_type").value;
		if(reptype=="M")
		{		
		var names  = new Array ( getLabel('eIP.CensusMonth.label','IP'), getLabel('Common.NursingUnitCode.label','Common'));

		f_query_add_mod.document.Rep2MonthlyIPCensusNursingUnitForm.p_report_id.value="IPBMIPCN"
		}
		else
		{
		var names  = new Array (getLabel('Common.CensusYear.label','Common'), getLabel('Common.NursingUnitCode.label','Common'));
		f_query_add_mod.document.Rep2MonthlyIPCensusNursingUnitForm.p_report_id.value="IPBYIPCN"
		}
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Rep2MonthlyIPCensusNursingUnitForm.submit();
		}

		}
		else
		{
		if(f_query_add_mod.document.Rep2MonthlyIPCensusBedClassForm)
		{
		if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2MonthlyIPCensusBedClassForm.p_fr_bed_class,f_query_add_mod.document.Rep2MonthlyIPCensusBedClassForm.p_to_bed_class, messageFrame )  )
		{
		var fields = new Array(f_query_add_mod.document.Rep2MonthlyIPCensusBedClassForm.p_trn_date);
		var names = new Array (	getLabel('eIP.CensusMonthYear.label','IP'))

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Rep2MonthlyIPCensusBedClassForm.submit();
		}
		}
		}
		/*else
		{
		if(f_query_add_mod.document.Rep2MonthlyIPCensusSpecialityForm)
		{
         alert("1");
		var fields = new Array(f_query_add_mod.document.Rep2MonthlyIPCensusSpecialityForm.p_trn_date,f_query_add_mod.document.Rep2MonthlyIPCensusSpecialityForm.p_speciality_code);


		var reptype=f_query_add_mod.document.getElementById("p_type").value;
		if(reptype=="M")
		{		
		var names  = new Array ( getLabel('eIP.CensusMonth.label','IP'), getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'));

		f_query_add_mod.document.Rep2MonthlyIPCensusSpecialityForm.p_report_id.value="IPBMIPCS"
		}
		else
		{
		var names  = new Array (getLabel('Common.CensusYear.label','Common'),getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'));
		f_query_add_mod.document.Rep2MonthlyIPCensusSpecialityForm.p_report_id.value="IPBYIPCS"
		}
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{	

		f_query_add_mod.document.Rep2MonthlyIPCensusSpecialityForm.submit() ;
		}
		}*/
		 else{
         if(f_query_add_mod.document.Rep2MonthlyIPCensusSpecialityForm)
		 {
		 var fields = new Array(f_query_add_mod.document.Rep2MonthlyIPCensusSpecialityForm.p_trn_date);
		 var names = new Array (	getLabel('eIP.CensusMonthYear.label','IP') )

	     if(f_query_add_mod.checkFields( fields, names, messageFrame))
		 {
		 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	     f_query_add_mod.document.forms[0].target="messageFrame"
		 f_query_add_mod.document.Rep2MonthlyIPCensusSpecialityForm.submit() ;
		 }
		 }
		else
		{
		if(f_query_add_mod.document.Rep2MonthlyIPSummaryForm)
		{
		var fields = new Array(f_query_add_mod.document.Rep2MonthlyIPSummaryForm.p_trn_date);
		var names = new Array (	getLabel('eIP.CensusMonthYear.label','IP'))

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		if( f_query_add_mod.setFirstDate()  )
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	    f_query_add_mod.document.forms[0].target="messageFrame"
		f_query_add_mod.document.Rep2MonthlyIPSummaryForm.submit() ;
		}
		}
		}
		else
		{
		if(f_query_add_mod.document.Rep2MonthlyIPSummaryNursingUnitForm)
		{
		var fields = new Array(f_query_add_mod.document.Rep2MonthlyIPSummaryNursingUnitForm.p_trn_date);
		var names = new Array (	getLabel('eIP.CensusMonthYear.label','IP'))

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2MonthlyIPSummaryNursingUnitForm.p_fr_nursing_unit,f_query_add_mod.document.Rep2MonthlyIPSummaryNursingUnitForm.p_to_nursing_unit, messageFrame )  )
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	    f_query_add_mod.document.forms[0].target="messageFrame"
	    f_query_add_mod.document.Rep2MonthlyIPSummaryNursingUnitForm.submit() ;
		}
		}
		else
		{
		if(f_query_add_mod.document.Rep2MonthlySummaryBedClassForm)
		{
		var fields = new Array(f_query_add_mod.document.Rep2MonthlySummaryBedClassForm.p_trn_date);
		var names = new Array (getLabel('eIP.CensusMonthYear.label','IP'))

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2MonthlySummaryBedClassForm.p_fr_bed_class,f_query_add_mod.document.Rep2MonthlySummaryBedClassForm.p_to_bed_class, messageFrame )  )
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	    f_query_add_mod.document.forms[0].target="messageFrame"
	    f_query_add_mod.document.Rep2MonthlySummaryBedClassForm.submit() ;
		}
		}
		else
		{
		if(f_query_add_mod.document.Rep2MonthlyIPSummarySpecialityForm)
		{
		var fields = new Array(f_query_add_mod.document.Rep2MonthlyIPSummarySpecialityForm.p_trn_date);
		var names = new Array (getLabel('eIP.CensusMonthYear.label','IP'));

		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2MonthlyIPSummarySpecialityForm.p_fr_speciality,f_query_add_mod.document.Rep2MonthlyIPSummarySpecialityForm.p_to_speciality, messageFrame )  )
		{
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
				f_query_add_mod.document.Rep2MonthlyIPSummarySpecialityForm.submit() ;
			}
		}
		}
		else
		{		
		if(f_query_add_mod.document.repAssesDiagStatForm)
		{
			if( !doDateCheckAlert( f_query_add_mod.document.repAssesDiagStatForm.p_fr_date,f_query_add_mod.document.repAssesDiagStatForm.p_to_date ) )
			{
				//alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				//f_query_add_mod.document.Rep2CancelAdmnListForm.p_to_adt_status_set_on_date.select();
				var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");					
				 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
				return;
			}
			
		if(CheckString1(getLabel("Common.DiagnosisCode.label","Common"), f_query_add_mod.document.repAssesDiagStatForm.p_fr_diag_code,f_query_add_mod.document.repAssesDiagStatForm.p_to_diag_code, messageFrame )  )
			//if( f_query_add_mod.CheckString(getLabel("Common.Period.label","Common"), f_query_add_mod.document.repAssesDiagStatForm.p_fr_date,f_query_add_mod.document.repAssesDiagStatForm.p_to_date, messageFrame )  )
		//if( chkGrtrDate(getLabel("Common.Period.label","Common"), f_query_add_mod.document.repAssesDiagStatForm.p_fr_date,f_query_add_mod.document.repAssesDiagStatForm.p_to_date, messageFrame )  )


		f_query_add_mod.document.repAssesDiagStatForm.submit() ;
		}
		else
		{																					 
		if(f_query_add_mod.document.repBedStatChartForm)
		{
		var fields = new Array( f_query_add_mod.document.repBedStatChartForm.p_fm_trn_date,f_query_add_mod.document.repBedStatChartForm.p_to_trn_date);
		var names = new Array (	getLabel("Common.from.label","Common")+' '+getLabel("Common.Period.label","Common"), getLabel("Common.to.label","Common")+' '+getLabel("Common.Period.label","Common"))
		
		//if(!chkIsBeforeDate(f_query_add_mod.document.repBedStatChartForm.p_fm_trn_date,f_query_add_mod.document.repBedStatChartForm.p_to_trn_date))
			//return;
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if( !f_query_add_mod.doDateCheckAlert( f_query_add_mod.document.repBedStatChartForm.p_fm_trn_date,f_query_add_mod.document.repBedStatChartForm.p_to_trn_date )  )
			{
				//alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				//f_query_add_mod.document.repBedStatChartForm.p_to_trn_date.select();
				var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");					
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error; 
				return;
			}
			if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.repBedStatChartForm.p_fr_nursing_unit,f_query_add_mod.document.repBedStatChartForm.p_to_nursing_unit, messageFrame )  )
				f_query_add_mod.document.repBedStatChartForm.submit() ;
		}
		}
		else
		{ //Discharg Advice

		if(f_query_add_mod.document.Rep2DischargeAdviseForm )
		{
		var fields = new Array(f_query_add_mod.document.Rep2DischargeAdviseForm.p_encounter_id);
		var names = new Array (	getLabel('Common.encounterid.label','common'))

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		f_query_add_mod.document.Rep2DischargeAdviseForm.submit() ;
		}

		else
		{ //Bookings By Medical Service Group
		if(f_query_add_mod.document.Rep2BookingByMedServGroupForm )
		{

		if( !doDateCheckAlert( f_query_add_mod.document.Rep2BookingByMedServGroupForm.p_fm_preferred_date,f_query_add_mod.document.Rep2BookingByMedServGroupForm.p_to_preferred_date )  )
			{
				//alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				//f_query_add_mod.document.Rep2BookingByMedServGroupForm.p_to_preferred_date.select();
				var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");					
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
				return;

			}
		if( f_query_add_mod.CheckString(getLabel("eIP.MedicalServiceGroup.label","IP")+' '+getLabel("Common.code.label","Common"), f_query_add_mod.document.Rep2BookingByMedServGroupForm.p_fm_med_ser_grp_code,f_query_add_mod.document.Rep2BookingByMedServGroupForm.p_to_med_ser_grp_code, messageFrame )  )
		{						
		f_query_add_mod.document.Rep2BookingByMedServGroupForm.submit() ;
		}
		}

		else
		{ //Unassigned Patients (Beds)
		if(f_query_add_mod.document.Rep2UnassignedPatientsForm )
		{
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2UnassignedPatientsForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2UnassignedPatientsForm.p_to_nursing_unit, messageFrame )  )
		{						
		f_query_add_mod.document.Rep2UnassignedPatientsForm.submit() ;
		}
		}
		else
		{ //List of Available Beds
		if(f_query_add_mod.document.Rep2AvailableBedsForm )
		{	

		if ( f_query_add_mod.document.Rep2AvailableBedsForm.pseudo_bed_yn.checked == true)
		{
		f_query_add_mod.document.Rep2AvailableBedsForm.pseudo_bed_yn.value="Y";
		}
		else 
		if ( f_query_add_mod.document.Rep2AvailableBedsForm.pseudo_bed_yn.checked == false)
		{
		f_query_add_mod.document.Rep2AvailableBedsForm.pseudo_bed_yn.checked=false;
		f_query_add_mod.document.Rep2AvailableBedsForm.pseudo_bed_yn.value="N";				
		}
		f_query_add_mod.document.Rep2AvailableBedsForm.p_pseudo_bed_yn.value=	f_query_add_mod.document.Rep2AvailableBedsForm.pseudo_bed_yn.value;



        var fromdate = f_query_add_mod.document.Rep2AvailableBedsForm.p_fr_dt;
		var todate   = f_query_add_mod.document.Rep2AvailableBedsForm.p_to_dt ;   

		/* IN017405 , Tuesday, December 22, 2009 , Mandatory Condition removed for date range
		//var fields = new Array(f_query_add_mod.document.Rep2AvailableBedsForm.p_fr_date, f_query_add_mod.document.Rep2AvailableBedsForm.p_to_date);
		//var names = new Array (getLabel('Common.periodfrom.label','common'),getLabel('Common.periodto.label','common'))
		*/
		f_query_add_mod.document.Rep2AvailableBedsForm.p_fr_dt.value = fromdate.value ;
		f_query_add_mod.document.Rep2AvailableBedsForm.p_to_dt.value = todate.value ;		


		/*IN017405 , Tuesday, December 22, 2009 , Mandatory check removed for date range
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{*/
			if(f_query_add_mod.document.Rep2AvailableBedsForm.p_fr_dt.value>f_query_add_mod.document.Rep2AvailableBedsForm.p_to_dt.value)
			{
				//alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				//f_query_add_mod.document.Rep2AvailableBedsForm.p_to_date.select();
				var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");					
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
				return;				
			}
			else
			{
				if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2AvailableBedsForm.p_fm_nursing_unit_code,f_query_add_mod.document.Rep2AvailableBedsForm.p_to_nursing_unit_code, messageFrame )  )
				if( f_query_add_mod.CheckString(getLabel("Common.roomno.label","Common"), f_query_add_mod.document.Rep2AvailableBedsForm.p_fm_room_no,f_query_add_mod.document.Rep2AvailableBedsForm.p_to_room_no, messageFrame )  )
					f_query_add_mod.document.Rep2AvailableBedsForm.submit();					
			}
		 //}		
		}
		
		// Daily Admission By Admission Type
		else
		{
		if(f_query_add_mod.document.Rep2DlyAdmnTypeForm)
		{

		/*if( !f_query_add_mod.doDateCheckAlert( f_query_add_mod.document.Rep2DlyAdmnTypeForm.p_fm_admission_date,f_query_add_mod.document.Rep2DlyAdmnTypeForm.p_to_admission_date )  )
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				f_query_add_mod.document.Rep2DlyAdmnTypeForm.p_to_admission_date.select();
				return;
			}*/

		if( !chkIsBeforeDate( f_query_add_mod.document.Rep2DlyAdmnTypeForm.p_fm_admission_date,f_query_add_mod.document.Rep2DlyAdmnTypeForm.p_to_admission_date ) )
				return;
			
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2DlyAdmnTypeForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2DlyAdmnTypeForm.p_to_nursing_unit, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel("eIP.AdmissionTypeCode.label","IP"), f_query_add_mod.document.Rep2DlyAdmnTypeForm.p_fm_admission_type_code,f_query_add_mod.document.Rep2DlyAdmnTypeForm.p_to_admission_type_code, messageFrame )  )																									
		{
		f_query_add_mod.document.Rep2DlyAdmnTypeForm.submit() ;
		}
		}
		// Monthly Admission By Admission Type
		else
		{
		if(f_query_add_mod.document.Rep2MthlyAdmnTypeForm)
		{
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2MthlyAdmnTypeForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2MthlyAdmnTypeForm.p_to_nursing_unit, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel("eIP.AdmissionTypeCode.label","IP"), f_query_add_mod.document.Rep2MthlyAdmnTypeForm.p_fm_admission_type_code,f_query_add_mod.document.Rep2MthlyAdmnTypeForm.p_to_admission_type_code, messageFrame )  )
		if(chkMthYr(f_query_add_mod.document.Rep2MthlyAdmnTypeForm.p_fm_admission_date,
			f_query_add_mod.document.Rep2MthlyAdmnTypeForm.p_to_admission_date )  )
		{
		f_query_add_mod.document.Rep2MthlyAdmnTypeForm.submit() ;
		}
		/*if(doDateCheck(f_query_add_mod.document.Rep2MthlyAdmnTypeForm.p_fm_admission_date,
			f_query_add_mod.document.Rep2MthlyAdmnTypeForm.p_to_admission_date )  )
		{
		f_query_add_mod.document.Rep2MthlyAdmnTypeForm.submit() ;
		}*/
		}
		else{
		if(f_query_add_mod.document.Rep2MthlySpecialtyForm)
		{
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2MthlySpecialtyForm.p_fm_specialty_code,f_query_add_mod.document.Rep2MthlySpecialtyForm.p_to_specialty_code, messageFrame )  )
		if( chkMthYr(f_query_add_mod.document.Rep2MthlySpecialtyForm.p_fm_admission_date,f_query_add_mod.document.Rep2MthlySpecialtyForm.p_to_admission_date )  )
		{
		f_query_add_mod.document.Rep2MthlySpecialtyForm.submit() ;
		}
		/*if( doDateCheck(f_query_add_mod.document.Rep2MthlySpecialtyForm.p_fm_admission_date,f_query_add_mod.document.Rep2MthlySpecialtyForm.p_to_admission_date )  )
		{
		f_query_add_mod.document.Rep2MthlySpecialtyForm.submit() ;
		}*/
		}
		else{
		if(f_query_add_mod.document.Rep2MthlyPractitionerForm)
		{
		if( f_query_add_mod.CheckString(getLabel("Common.practitioner.label","Common"), f_query_add_mod.document.Rep2MthlyPractitionerForm.p_fm_pract_id,f_query_add_mod.document.Rep2MthlyPractitionerForm.p_to_pract_id, messageFrame )  )
		if( chkMthYr(f_query_add_mod.document.Rep2MthlyPractitionerForm.p_fm_admission_date,f_query_add_mod.document.Rep2MthlyPractitionerForm.p_to_admission_date )  )
		{
		f_query_add_mod.document.Rep2MthlyPractitionerForm.submit() ;
		}
		/*if( doDateCheck(f_query_add_mod.document.Rep2MthlyPractitionerForm.p_fm_admission_date,f_query_add_mod.document.Rep2MthlyPractitionerForm.p_to_admission_date )  )
		{
		f_query_add_mod.document.Rep2MthlyPractitionerForm.submit() ;
		}*/
		}
		// Yearly Admission By Admission Type
		else
		{
		if(f_query_add_mod.document.Rep2YrlyAdmnTypeForm)
		{
		if( f_query_add_mod.CheckString(getLabel("eIP.AdmissionYear.label","IP"), f_query_add_mod.document.Rep2YrlyAdmnTypeForm.p_fm_admission_date,f_query_add_mod.document.Rep2YrlyAdmnTypeForm.p_to_admission_date, messageFrame ))
		if( f_query_add_mod.CheckString(getLabel("eIP.AdmissionYear.label","IP"), f_query_add_mod.document.Rep2YrlyAdmnTypeForm.p_fm_admission_date,f_query_add_mod.document.Rep2YrlyAdmnTypeForm.p_to_admission_date, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2YrlyAdmnTypeForm.p_fm_nursing_unit,f_query_add_mod.document.Rep2YrlyAdmnTypeForm.p_to_nursing_unit, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2YrlyAdmnTypeForm.p_fm_specialty_code,f_query_add_mod.document.Rep2YrlyAdmnTypeForm.p_to_specialty_code, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.practitionerid.label','common'), f_query_add_mod.document.Rep2YrlyAdmnTypeForm.p_fm_practitioner_id,f_query_add_mod.document.Rep2YrlyAdmnTypeForm.p_to_practitioner_id, messageFrame )  )
		{
			
		f_query_add_mod.document.Rep2YrlyAdmnTypeForm.submit() ;
		}
		}
		// Cancelled Transfers
		else
		{
		if(f_query_add_mod.document.Rep2CancelledTransfersForm)
		{


		if( !doDateCheckAlert( f_query_add_mod.document.Rep2CancelledTransfersForm.p_fm_booking_date_time,f_query_add_mod.document.Rep2CancelledTransfersForm.p_to_booking_date_time )  )
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				f_query_add_mod.document.Rep2CancelledTransfersForm.p_to_booking_date_time.select();
				return;
			}

		if( !f_query_add_mod.doDateCheckAlert( f_query_add_mod.document.Rep2CancelledTransfersForm.p_fm_cancellation_date_time,f_query_add_mod.document.Rep2CancelledTransfersForm.p_to_cancellation_date_time )  )
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				f_query_add_mod.document.Rep2CancelledTransfersForm.p_to_cancellation_date_time.select();
				return;
			}
		if( f_query_add_mod.CheckString(getLabel("eIP.TransferTypeCode.label","IP"), f_query_add_mod.document.Rep2CancelledTransfersForm.p_fm_transfer_type,f_query_add_mod.document.Rep2CancelledTransfersForm.p_to_transfer_type, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2CancelledTransfersForm.p_fm_req_specialty_code,f_query_add_mod.document.Rep2CancelledTransfersForm.p_to_req_specialty_code, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2CancelledTransfersForm.p_fm_req_nursing_unit_code,f_query_add_mod.document.Rep2CancelledTransfersForm.p_to_req_nursing_unit_code, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2CancelledTransfersForm.p_fm_req_bed_class_code,f_query_add_mod.document.Rep2CancelledTransfersForm.p_to_req_bed_class_code, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.practitionerid.label','common'), f_query_add_mod.document.Rep2CancelledTransfersForm.p_fm_req_practitioner_id,f_query_add_mod.document.Rep2CancelledTransfersForm.p_to_req_practitioner_id, messageFrame )  )
		{
		f_query_add_mod.document.Rep2CancelledTransfersForm.submit() ;
		}
		}																																	
		else // Current OverStay Patients
		{
		if(f_query_add_mod.document.Rep2CurrentOverstayPatientsForm)
		{

		if( !doDateCheckAlert( f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_fm_admission_date_time,f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_to_admission_date_time )  )
			{
				//alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				//f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_to_admission_date_time.select();
				var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");					
				 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
				return;
			}
		if( f_query_add_mod.CheckString(getLabel("eIP.AdmissionTypeCode.label","IP"), f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_fm_trn_code,f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_to_trn_code, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_fm_nursing_unit_code,f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_to_nursing_unit_code, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_fm_bed_class_code,f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_to_bed_class_code, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.practitionerid.label','common'), f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_fm_practitioner_id,f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_to_practitioner_id, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_fm_specialty_code,f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_to_specialty_code, messageFrame )  )		
		if( f_query_add_mod.CheckString(getLabel("Common.NationalityCode.label","Common"), f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_fm_nationality_code,f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.p_to_nationality_code, messageFrame )  )
		
		{
		f_query_add_mod.document.Rep2CurrentOverstayPatientsForm.submit() ;
		}
		}
		else // Circumstance of Injury Statistics
		{
		if(f_query_add_mod.document.Rep2CircumstanceofInjuryStatForm)
		{
		if( !chkIsBeforeDate( f_query_add_mod.document.Rep2CircumstanceofInjuryStatForm.p_fm_visit_admn_date_time,f_query_add_mod.document.Rep2CircumstanceofInjuryStatForm.p_to_visit_admn_date_time )  )
			return;
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.Rep2CircumstanceofInjuryStatForm.p_fm_assign_care_locn_code,f_query_add_mod.document.Rep2CircumstanceofInjuryStatForm.p_to_assign_care_locn_code, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel("Common.CircumstanceofInjuryCode.label","Common"), f_query_add_mod.document.Rep2CircumstanceofInjuryStatForm.p_fm_circ_of_injury_code,f_query_add_mod.document.Rep2CircumstanceofInjuryStatForm.p_to_circ_of_injury_code, messageFrame )  )
		{
		f_query_add_mod.document.Rep2CircumstanceofInjuryStatForm.submit() ;
		}
		}

		else 
		{
		if(f_query_add_mod.document.rep2PullingListForm)
		{

		if( f_query_add_mod.doDateCheck( f_query_add_mod.document.rep2PullingListForm.p_fm_preferred_date,f_query_add_mod.document.rep2PullingListForm.p_to_preferred_date, messageFrame )  )
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.rep2PullingListForm.p_fm_nursing_unit,f_query_add_mod.document.rep2PullingListForm.p_to_nursing_unit, messageFrame )  )
		{
		orderbycolumns	=	f_query_add_mod.document.rep2PullingListForm.orderbycolumns;

		var order_by_columns	=	"";

		if(orderbycolumns.length>0)
		{

		for(var i=0; i<orderbycolumns.length; i++)
		{
		order_by_columns	+=	orderbycolumns[i].value;
		if( (i+1) < orderbycolumns.length ) order_by_columns	+=	"__";
		}
		}

		f_query_add_mod.document.rep2PullingListForm.p_order_by.value = order_by_columns;
		f_query_add_mod.document.rep2PullingListForm.submit() ;
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}																								
		}																						  
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
}
}//e.o.run

function chkEqual()
{

frm = f_query_add_mod.document.Rep2AdmissionCensesForm

var eql = true ;
if( frm.p_col1.value!="null" &&  frm.p_col2.value!="null" )
{
if ( frm.p_col1.value == frm.p_col2.value )
eql = false
else
{
if ( frm.p_col3.value!="null"  )
{
if ( frm.p_col1.value == frm.p_col3.value )
{
eql = false
}
else
{
if( frm.p_col2.value == frm.p_col3.value )
{
eql = false;
}
}
}
}
}

return eql ;
}

function chkIsBeforeDate(obj1,obj2)
{
	//alert();
	if(obj1.value != "" && obj2.value != "")
	{
		if(isBefore(obj1.value,obj2.value,"DMY",localeName) == false)
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			obj2.select();
			return false;
		}
		else
			return true;
	}
	else 
		return true;
}

function validateYear(obj)
{
	if(obj.value != "")
	{
		if(validDate(obj.value,"YY",localeName) == false)
		{
			alert(getMessage("INVALID_YR_FORMAT", "SM"));
			obj.select();	
			return;
		}
	}
}

function chkGrtrDate(str,fromDate,toDate,messageFrame)
{
	if(fromDate.value != "" && toDate.value != "")
	{
		if(isBefore(fromDate.value,toDate.value,"DMY",localeName) == false)
		{
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common");
			error=error.replace("$",str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
		}
		else 
			return true;
	}
	else 
		return true;
}

function chkMthYr(fromDate,toDate)
{
	if(fromDate.value != "" && toDate.value != "")
	{
			if(isBefore(fromDate.value,toDate.value,"MY",localeName) == false)
			{
				var error = f_query_add_mod.getMessage("FR_TRN_MNYR_GR_TO_TRN_MNYR","IP");
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
				return false;
			}
			else 
				return true;
	}
	else 
		return true;

}

function doDateCheck(from,to) 
{
var fromarray; var toarray;
var fromdate = from.value ;
var todate = to.value ;

if(fromdate.length > 0 && todate.length > 0 ) {
fromarray = fromdate.split("/");
toarray = todate.split("/");
var fromdt = new Date(fromarray[1],fromarray[0],"01");
var todt = new Date(toarray[1],toarray[0],"01");
if(Date.parse(todt) < Date.parse(fromdt)) {
var error = f_query_add_mod.getMessage("FR_TRN_MNYR_GR_TO_TRN_MNYR","IP");
messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
return false;
}
else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
}
return true;
}

function doDateCheckAlert(from,to)
		{
			var fromdate = from.value ;
			var todate = to.value ;
			if(fromdate!='' && todate!='')
			{
					var greg_fromDate = convertDate(fromdate,"DMY",localeName,"en");
					var greg_toDate = convertDate(todate,"DMY",localeName,"en");
					if(isBefore(greg_fromDate,greg_toDate,"DMY","en"))
					{
						
						return true;
					}
					else 
					{
						return false;
					
					}
			}
			else
				return true;

		}

function Check_daily_census(str ,fromobj,toobj,messageFrame) {

var arr = new Array(toobj.value,fromobj.value);

    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
		
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}

function CheckString1(str,fromobj,toobj,messageFrame) {		
	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);			
			error=error.replace("$",getLabel('Common.to.label','common_labels')+' '+str);			
			error=error.replace("#",str);			
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }

}

