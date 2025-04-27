function codeCheck(val)
{
	if(val.length==0)
		parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
	else if(val == "IP_ADMISSION_TYPE")
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepAdmissionType.jsp';
	else if(val == "IP_NURSING_UNIT")
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepNursingUnit.jsp';
    else if (val == "IP_BOOK_LIMIT_BY_AGE_GRP")
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepAgeGrpBookingLt.jsp';
	else if ( val== "IP_BED_CLASS" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepBedClass.jsp';
	else if ( val== "IP_BED_TYPE" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepBedType.jsp';
	else if ( val== "IP_NURSING_UNIT_TYPE" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepNursingType.jsp';
	else if ( val== "IP_NURSING_UNIT_ROOM" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepRoomsForNursingUnit.jsp';
	else if(val == "IP_NURSING_UNIT_FOR_PRACT")
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepPractitionersForNursingUnit.jsp';
	else if ( val== "IP_NURS_UNIT_FOR_SPECIALTY" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepSpecialtiesForNursingUnit.jsp';
	else if ( val== "IP_NURSING_UNIT_BED" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepBedsForNursingUnit.jsp';
	else if ( val== "IP_BLOCKING_TYPE" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepBlockingType.jsp';
	else if ( val== "IP_MEDICAL_SERVICE_GROUP" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepMedSrvcGrp.jsp';
	else if ( val== "IP_TRANSFER_TYPE" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepTransferType.jsp';
	else if ( val== "IP_DISCHARGE_TYPE" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepDischargeType.jsp';
	else if ( val== "IP_REASON_FOR_LODGER_STAY" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepReasonForLodgersStay.jsp';
	else if ( val== "IP_NURSING_UNIT_LOCATION" )
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepPhyLocnForNursingUnit.jsp';
	else if (val == "IP_MED_SER_GRP_NURS_UT_TYPE")
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepNursUnitForMedSrvcGrp.jsp';
	else if (val == "IP_BOOK_LIMIT_BY_NURS_UT") 
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepNursUnitBedClassBkgLmt.jsp';
	else if (val == "IP_TRANSFER_CHARGE")
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepBedTransferCharge.jsp';
	else if (val == "IP_BED_BOOKING_SRL_CTRL")
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepBedBookingSrlControl.jsp';
	else if (val == "IP_NURS_UNIT_FOR_SERVICE")
		parent.f_query_add_mod.location.href='../../eIP/jsp/RepServiceForNursingUnit.jsp';
}

function reset() 
{
	if(f_query_add_mod.document.forms[0] != null)
		f_query_add_mod.document.forms[0].reset() ;
}	

function run() 
{
	if(f_query_add_mod.document.RepNursingUnitForm)
	{
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.RepNursingUnitForm.p_fm_nursing_unit,f_query_add_mod.document.RepNursingUnitForm.p_to_nursing_unit, messageFrame )  )
			
		f_query_add_mod.document.RepNursingUnitForm.submit() ;
	}
	else if(f_query_add_mod.document.RepAdmissionTypeForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.AdmissionTypeCode.label','IP'), f_query_add_mod.document.RepAdmissionTypeForm.p_fr_adm_type,f_query_add_mod.document.RepAdmissionTypeForm.p_to_adm_type, messageFrame )  )
			f_query_add_mod.document.RepAdmissionTypeForm.submit() ;
	}
	else if(f_query_add_mod.document.RepAgeGrpBookingLtForm)
	{
		if( f_query_add_mod.CheckString(getLabel('Common.agegroupcode.label','common'), f_query_add_mod.document.RepAgeGrpBookingLtForm.p_fm_age_grp,f_query_add_mod.document.RepAgeGrpBookingLtForm.p_to_age_grp, messageFrame )  )
			if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.RepAgeGrpBookingLtForm.p_fm_bed_class,f_query_add_mod.document.RepAgeGrpBookingLtForm.p_to_bed_class, messageFrame )  )	
				f_query_add_mod.document.RepAgeGrpBookingLtForm.submit() ;
	}
	else if(f_query_add_mod.document.RepBedClassForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.RepBedClassForm.p_fr_bed_class,f_query_add_mod.document.RepBedClassForm.p_to_bed_class, messageFrame )  )	
			f_query_add_mod.document.RepBedClassForm.submit() ;
	}
	else if (f_query_add_mod.document.RepBedTypeForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.BedTypeCode.label','IP'), f_query_add_mod.document.RepBedTypeForm.p_fr_bed_type,f_query_add_mod.document.RepBedTypeForm.p_to_bed_type, messageFrame )  )
			f_query_add_mod.document.RepBedTypeForm.submit() ;
	}
	else if(f_query_add_mod.document.NursingUnitTypeForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.NursingTypeCode.label','IP'), f_query_add_mod.document.NursingUnitTypeForm.p_fm_nursing_unit_type,f_query_add_mod.document.NursingUnitTypeForm.p_to_nursing_unit_type, messageFrame )  )	
			f_query_add_mod.document.NursingUnitTypeForm.submit() ;
	}
	else if (f_query_add_mod.document.RoomsForNursingUnitForm)
	{
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.RoomsForNursingUnitForm.p_fm_nursing_unit,f_query_add_mod.document.RoomsForNursingUnitForm.p_to_nursing_unit, messageFrame )  )	
			f_query_add_mod.document.RoomsForNursingUnitForm.submit() ;
	}
	else if (f_query_add_mod.document.RepPractNursingUnitForm)
	{
		if( f_query_add_mod.CheckString(getLabel('Common.practitionerid.label','common'), f_query_add_mod.document.RepPractNursingUnitForm.p_fm_pract,f_query_add_mod.document.RepPractNursingUnitForm.p_to_pract, messageFrame )  )
			if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.RepPractNursingUnitForm.p_fm_nursing_unit,f_query_add_mod.document.RepPractNursingUnitForm.p_to_nursing_unit, messageFrame )  )	
				
			f_query_add_mod.document.RepPractNursingUnitForm.submit() ;
	}
	else if (f_query_add_mod.document.RepSpltyNursingUnitForm)
	{
		if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.RepSpltyNursingUnitForm.p_fm_speciality,f_query_add_mod.document.RepSpltyNursingUnitForm.p_to_speciality, messageFrame )  )
			if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.RepSpltyNursingUnitForm.p_fm_nursing_unit,f_query_add_mod.document.RepSpltyNursingUnitForm.p_to_nursing_unit, messageFrame )  )
				f_query_add_mod.document.RepSpltyNursingUnitForm.submit() ;
	}
	else if (f_query_add_mod.document.RepBedsForNursingUnitForm)
	{
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.RepBedsForNursingUnitForm.p_fr_nur_unit_code,f_query_add_mod.document.RepBedsForNursingUnitForm.p_to_nur_unit_code, messageFrame )  )	
			f_query_add_mod.document.RepBedsForNursingUnitForm.submit() ;
	}
	else if (f_query_add_mod.document.RepBlockingTypeForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.BlockingTypeCode.label','IP'), f_query_add_mod.document.RepBlockingTypeForm.p_fr_blocking_type,f_query_add_mod.document.RepBlockingTypeForm.p_to_blocking_type, messageFrame )  )	
			f_query_add_mod.document.RepBlockingTypeForm.submit() ;
	}
	else if (f_query_add_mod.document.RepMedSrvcGrpForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.MedicalServiceGroup.label','IP')+" "+getLabel('Common.code.label','common'), f_query_add_mod.document.RepMedSrvcGrpForm.p_fm_medical_service_grp,f_query_add_mod.document.RepMedSrvcGrpForm.p_to_medical_service_grp, messageFrame )  )	
			f_query_add_mod.document.RepMedSrvcGrpForm.submit() ;
	}	
	else if (f_query_add_mod.document.RepTransferTypeForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.TransferTypeCode.label','IP'), f_query_add_mod.document.RepTransferTypeForm.p_fr_trn_type,f_query_add_mod.document.RepTransferTypeForm.p_to_trn_type, messageFrame )  )	
			f_query_add_mod.document.RepTransferTypeForm.submit() ;
	}
	else if (f_query_add_mod.document.RepDischargeTypeForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.DischargeTypeCode.label','IP'), f_query_add_mod.document.RepDischargeTypeForm.p_fr_dis_type,f_query_add_mod.document.RepDischargeTypeForm.p_to_dis_type, messageFrame )  )	
			f_query_add_mod.document.RepDischargeTypeForm.submit() ;
	}
	else if (f_query_add_mod.document.RepReasonForStayForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.ReasonForLodgerStayCode.label','IP'), f_query_add_mod.document.RepReasonForStayForm.p_fr_lodger_stay,f_query_add_mod.document.RepReasonForStayForm.p_to_lodger_stay, messageFrame )  )	
			f_query_add_mod.document.RepReasonForStayForm.submit() ;
	}
	else if( f_query_add_mod.document.RepPhyLocnForNursingUnitForm)	
	{
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.RepPhyLocnForNursingUnitForm.p_fm_nursing_unit,f_query_add_mod.document.RepPhyLocnForNursingUnitForm.p_to_nursing_unit, messageFrame )  )	
			if( f_query_add_mod.CheckString(getLabel('Common.FloorCode.label','Common'), f_query_add_mod.document.RepPhyLocnForNursingUnitForm.p_fm_floor,f_query_add_mod.document.RepPhyLocnForNursingUnitForm.p_to_floor, messageFrame )  )
				if( f_query_add_mod.CheckString(getLabel('Common.BuildingCode.label','Common'), f_query_add_mod.document.RepPhyLocnForNursingUnitForm.p_fm_bldng,f_query_add_mod.document.RepPhyLocnForNursingUnitForm.p_to_bldng, messageFrame )  )	
					f_query_add_mod.document.RepPhyLocnForNursingUnitForm.submit() ;														
	}
	else if (f_query_add_mod.document.RepNursUnitForMedSrvcGrpForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.NursingTypeCode.label','IP'), f_query_add_mod.document.RepNursUnitForMedSrvcGrpForm.p_fm_nursing_unit_type,f_query_add_mod.document.RepNursUnitForMedSrvcGrpForm.p_to_nursing_unit_type, messageFrame )  )	
			if( f_query_add_mod.CheckString(getLabel('eIP.MedicalServiceGroup.label','IP')+" "+getLabel('Common.code.label','common'), f_query_add_mod.document.RepNursUnitForMedSrvcGrpForm.p_fm_med_serv,f_query_add_mod.document.RepNursUnitForMedSrvcGrpForm.p_to_med_serv, messageFrame )  )	
				f_query_add_mod.document.RepNursUnitForMedSrvcGrpForm.submit() ;
	}
	else if (f_query_add_mod.document.RepNursUnitBedClassBkgLmtForm)
	{
		if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.RepNursUnitBedClassBkgLmtForm.p_fm_nursing_unit,f_query_add_mod.document.RepNursUnitBedClassBkgLmtForm.p_to_nursing_unit, messageFrame )  )	
			if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.RepNursUnitBedClassBkgLmtForm.p_fm_bed_class,f_query_add_mod.document.RepNursUnitBedClassBkgLmtForm.p_to_bed_class, messageFrame )  )	
				f_query_add_mod.document.RepNursUnitBedClassBkgLmtForm.submit() ;
	}
	else if (f_query_add_mod.document.RepBedTransferChargeForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.FromBedTypeCode.label','IP'), f_query_add_mod.document.RepBedTransferChargeForm.p_fr_fr_bed_type,f_query_add_mod.document.RepBedTransferChargeForm.p_to_fr_bed_type, messageFrame )  )	
			if( f_query_add_mod.CheckString(getLabel('eIP.ToBedTypeCode.label','IP'), f_query_add_mod.document.RepBedTransferChargeForm.p_fr_to_bed_type,f_query_add_mod.document.RepBedTransferChargeForm.p_to_to_bed_type, messageFrame )  )	
				f_query_add_mod.document.RepBedTransferChargeForm.submit() ;															
	}
	else if (f_query_add_mod.document.RepBedBookingSrlControlForm)
	{
		if( f_query_add_mod.CheckString(getLabel('eIP.BookingType.label','IP')+" "+getLabel('Common.code.label','common'), f_query_add_mod.document.RepBedBookingSrlControlForm.p_fr_booking,f_query_add_mod.document.RepBedBookingSrlControlForm.p_to_booking, messageFrame )  )	
			f_query_add_mod.document.RepBedBookingSrlControlForm.submit() ;
	}	
	else if (f_query_add_mod.document.RepSrvcNursingUnitForm)
	{
		if( f_query_add_mod.CheckString(getLabel('Common.ServiceCode.label','common'), f_query_add_mod.document.RepSrvcNursingUnitForm.p_fm_service,f_query_add_mod.document.RepSrvcNursingUnitForm.p_to_service, messageFrame )  )
			if( f_query_add_mod.CheckString(getLabel('Common.acctdept.label','common')+" "+getLabel('Common.code.label','common'), f_query_add_mod.document.RepSrvcNursingUnitForm.p_fm_dept,f_query_add_mod.document.RepSrvcNursingUnitForm.p_to_dept, messageFrame )  )
				if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.RepSrvcNursingUnitForm.p_fm_nursing_unit,f_query_add_mod.document.RepSrvcNursingUnitForm.p_to_nursing_unit, messageFrame )  )
					f_query_add_mod.document.RepSrvcNursingUnitForm.submit() ;
	}
}
