/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.resources;

import java.util.*;

public class  Labels_zh  extends ListResourceBundle{
	public Object[][] getContents() {
         return contents;
    }


	static final Object[][] contents = {
	/*	{"eOT.2ndCount.Label","2nd Count"},
		{"eOT.AcceptRemarks.Label","Accept Remarks"},
		{"eOT.AccessionNum.Label","Accession Num"},
		{"eOT.AcrossSpecialities.Label","Across Specialties"},
		{"eOT.ActionDate.Label","Action Date"},
		{"eOT.ActionIfNotDone.Label","Action If Not Done"},
		{"eOT.ActionTypesForReason.Label","Action Type for Reason"},
		{"eOT.AddaSet.Label","Add a Set"},
		{"eOT.Addaswabcount.Label","Add a swab count"},
		{"eOT.AdditionsafterClcavityCompl.Label","Additions after Cl. cavity Completed?"},
		{"eOT.AdditionsduringOP.Label","Additions during OP"},
		{"eOT.AdditionsDuringOPCompleted.Label","Additions During OP Completed?"},
		{"eOT.AdditionsduringOperation.Label","Additions during Operation"},
		{"eOT.Addns.Label","Addns.."},
		{"eOT.AddnsafterCC.Label","Additions (after CC.)"},
		{"eOT.AdmittingSpeciality.Label","Admitting Specialty"},*/
		{"eOT.AllBookings.Label","所有预订"},
		{"eOT.AllCategories.Label","所有目录"},
//		{"eOT.AllElective.Label","All Elective"},
		{"eOT.AllEmergency.Label","所有急诊"},
		{"eOT.Allow.Label","允许"},
//		{"eOT.AllowBarcode.Label","Allow Barcode"},
		{"eOT.AllowEmergPatwhilefinalizing.Label","结束时允许急诊病人"},
		{"eOT.AllowOutpatientswhilefinalizing.Label","结束后允许门诊病人"},
		{"eOT.AllTheatres.Label","所有手术室"},
		{"eOT.AllUsers.Label","所有用户"},
		{"eOT.AnaesSerialNo.Label","麻醉系列号"},
		{"eOT.AnaesDocCmplTime.Label","麻醉文档完成时间"},
		{"eOT.AnaesthesiaEndTime.Label","麻醉结束时间"},
		{"eOT.AnaesthesiaHistory.Label","麻醉史"},
		{"eOT.AnaesthesiaNotes.Label","麻醉笔记"},
		{"eOT.AnaesthesiaNumbering.Label","麻醉编号"},
		{"eOT.AnaesthesiaOrderedDate.Label","麻醉医嘱日期"},
		{"eOT.AnaesthesiaParticulars.Label","麻醉资料"},
		{"eOT.AnaesthesiaProcedure.Label","麻醉程序"},
		{"eOT.AnaesthesiaProcedureEndTime.Label","麻醉程序的结束时间"},
		{"eOT.AnaesthesiaProcedureStartTime.Label","麻醉程序的开始时间"},
		{"eOT.AnaesthesiaReviewRequired.Label","麻醉检查查要求"},
		{"eOT.AnaesthesiaStartTime.Label","麻醉开始时间"},
		{"eOT.AnaesthesiaType.Label","麻醉型"},
//		{"eOT.AnaesthetistWiseTotal.Label","Anaesthetist Wise Total"},
//		{"eOT.AnyDiscrepanciesinFirstCount.Label","Any Discrepancies in First Count"},
//		{"eOT.ApplicableForOTSlate.Label","Applicable For OT Slate"},
		{"eOT.ApplicablePosition.Label","适用位置"},
		{"eOT.AssignAnaesthetist.Label","分配麻醉师"},
		{"eOT.AssignedTheatre.Label","分配手术室"},
		{"eOT.AssignedTime.Label","分配时间"},
		{"eOT.AssignTheatre.Label","分配手术室"},
//		{"eOT.AssociatedAnaesthestist.Label","Associated Anaesthestist"},
		{"eOT.AsstSurgeon.Label","助理医生"},
//		{"eOT.AutoPopulated.Label","Auto Populated"},
		{"eOT.BackGroundColor.Label","背景颜色"},
//		{"eOT.BasicSet.Label","Basic Set"},
//		{"eOT.BasicSetSuppltemVerifySwabCnt.Label","Basic Set / Supplementary Item / Verify Swab Count"},
//		{"eOT.Bilateral.Label","Bilateral"},
		{"eOT.Black.Label","黑的"},
//		{"eOT.BlockSlotsByAgeGroup.Label","Block Slots By Age Group"},
//		{"eOT.BlockSlotsBySpeciality.Label","Block Slots By Specialty"},
//		{"eOT.BlockSlotsForTheOperatingRoom.Label","Block Slots for the OperatingRoom"},
//		{"eOT.BlockTheatreSlots.Label","Block Theatre Slots"},
		{"eOT.Blue.Label","蓝的"},
		{"eOT.BMIDetails.Label","ＢＭＩ明细"},
		{"eOT.Book.Label","预订"},
		{"eOT.BookedCases.Label","预订案例"},
		{"eOT.BookedDate.Label","预订日期"},
		{"eOT.BookingFinalizationStages.Label","预订完成附阶段"},
//		{"eOT.BookingHeader.Label","Booking Header"},
		{"eOT.BookingNextNumber.Label","下一预订号"},
		{"eOT.BookingMaxNumber.Label","最大预订号"},
		{"eOT.BookingNO.Label","预订号"},
		{"eOT.BookingNumbering.Label","预订数量"},
		{"eOT.BookingPriority.Label","优先预订"},
		{"eOT.BookingRemarks.Label","预订备注"},
		{"eOT.BookingRights.Label","预订权利"},
//		{"eOT.BookingScreenSlip.Label","Booking Screen Slip"},
		{"eOT.BookingStartTime.Label","报名开始时间"},
		{"eOT.BookingVerification.Label","预订核查"},
		{"eOT.BookingWaitList.Label","预订/ 列表"},
		{"eOT.BookingWindow.Label","预订窗口"},
		{"eOT.Brown.Label","褐色"},
		{"eOT.ByPatient.Label","病人"},
		{"eOT.BySpeciality.Label","科室"},
		{"eOT.BySurgeon.Label","外科医生"},
//		{"eOT.ByTimeSeq.Label","By Time/Seq"},
//		{"eOT.BuildAnaesthesiaIntoCR.Label","Build Anaesthesia Into CR"},
		{"eOT.CancelCheckedInCases.Label","取消检查案例"},
		{"eOT.CancelledCases.Label","取消案例"},
		{"eOT.CancelOrder.Label","取消医嘱"},
		{"eOT.CancelViewDetails.Label","取消明细"},
		{"eOT.CancelWaitlist.Label","取消列表"},
		{"eOT.CaseCalledTime.Label","案例取消时间"},
//		{"eOT.ChangeHoldingBay.Label","Change Holding Bay"},
		{"eOT.ChangeSequence.Label","变化序列"},
		{"eOT.ChangeStage.Label","变化阶段"},
		{"eOT.ChangeStatusto.Label","改变状态"},
		{"eOT.ChangeType.Label","变更类型"},
		{"eOT.CheckedInDateTime.Label","检查日期时间"},
		{"eOT.CheckForChecklistCompleted.Label","检查清单完成"},
		{"eOT.CheckIn.Label","检查"},
		{"eOT.CheckInTime.Label","检查时间"},
		{"eOT.CheckInToOperatingRoom.Label","手术室检查"},
		{"eOT.CheckIntoOR.Label","检查"},
//		{"eOT.CheckIntoORTime.Label","Check In to OR Time"},
		{"eOT.CheckInToRecoveryRoom.Label","恢复室检查"},
		{"eOT.CheckIntoRecoveryTime.Label","恢复时间检查"},
		{"eOT.Checklist.Label","清单"},
		{"eOT.Checklists.Label","清单"},
		{"eOT.CheckListCompleted.Label","完成清单"},
		{"eOT.ChecklistItem.Label","清单项目"},
		{"eOT.ChecklistItemCode.Label","清单项目代码"},
		{"eOT.ChecklistType.Label","清单类型"},
		{"eOT.CheckOut.Label","离开"},
		{"eOT.CheckOutFromRecoveryRoom.Label","离开恢复室"},
		{"eOT.CheckOutFromWard.Label","离开病区"},
		{"eOT.Check-OutPatient.Label","离开病人"},
		{"eOT.CheckOutTime.Label","离开时间"},
		{"eOT.CodingScheme.Label","编码方案"},
		{"eOT.ConsentDateTime.Label","同意的日期/时间"},
		{"eOT.ConsentTakenBy.Label","同意采取"},
		{"eOT.ConsentTakenFrom.Label","同意取自"},
		{"eOT.ConsignmentItem.Label","寄售项目"},
		{"eOT.ConsumableItemTooltip.Label","这是一个耗材项目。它不能返回"},
		{"eOT.ConsumablePacks.Label","消耗品包"},
		{"eOT.Consumables.Label","耗材"},
		{"eOT.CrossReferenceItem.Label","交叉参考项目"},
		{"eOT.CrossReferenceItemCode.Label","交叉参考项目代码"},
//		{"eOT.CrossRefMMItem.Label","Cross-Ref MM Item"},
		{"eOT.CrossRefSSGroup.Label","交参SS组"},
		{"eOT.CSSDQty.Label","消毒数量"},
		{"eOT.CSSDStoreCode.Label","消毒库房代码"},
		{"eOT.Cumulative.Label","累积"},
		{"eOT.CurrentMedicationAlert.Label","目前的药物警戒"},
		{"eOT.CurrentSequence.Label","当前序列"},
		{"eOT.CurrentStage.Label","?现阶段"},
		{"eOT.Cyan.Label","?青"},
		{"eOT.DarkBlue.Label","深蓝"},
		{"eOT.DarkCyan.Label","?暗青色"},
		{"eOT.DarkGreen.Label","?暗绿色"},
		{"eOT.DarkRed.Label","?暗红色"},
		{"eOT.DateofSurgery.Label","?手术日期"},
		{"eOT.DaySchedule.Label","时刻表"},
		{"eOT.DaySpecific.Label","特定日期"},
		{"eOT.DefaultStoreCode.Label","默认库房代码"},
//		{"eOT.DepositRequired.Label","Deposit Required?"},
//		{"eOT.DiaryGeneratedupto.Label","Diary Generated upto"},
//		{"eOT.DiaryScheduleforSurgeon.Label","Diary Schedule for Surgeon"},
//		{"eOT.DiaryScheduleforTheatre.Label","Diary Schedule for Theatre"},
		{"eOT.Disposal.Label","?处置"},
		{"eOT.DisposalCode.Label","?处置码"},
		{"eOT.DisposalDescription.Label","?处理说明"},
		{"eOT.DisposalDetails.Label","处理明细"},
		{"eOT.DisposedItem.Label","处置项目"},
		{"eOT.DocumentationCompleted.Label","?檔完成"},
		{"eOT.DocumentationCompletionStatusCheck.Label","?档完成状态检查"},
		{"eOT.DocumentationLevel.Label","?文件级别"},
		{"eOT.ConsumablesUsed.Label","耗材使用"},
		{"eOT.DrugsForNotification.Label","药物通知"},
//		{"eOT.EmailPrintReminderLetter.Label","Email/Print Reminder Letter"},
		{"eOT.EmergencyCases.Label","紧急案例"},
//		{"eOT.EncounterLookup.Label","Encounter Lookup"},
		{"eOT.EnterPIN.Label","输入密码"},
//		{"eOT.Episode.Label","Episode"},
//		{"eOT.EpisodeDetails.Label","Episode Details"},
//		{"eOT.EpisodeTypeID.Label","Episode Type / ID"},
		{"eOT.EquipmentCode.Label","设备代码"},
		{"eOT.EquipmentID.Label","?设备编号"},
		{"eOT.Equipments.Label","?设备"},
		{"eOT.EquipmentsDetails.Label","?设备详细资料"},
		{"eOT.Exam.Label","考试"},
		{"eOT.ExamsCheckList.Label","?考试须知"},
//		{"eOT.Extubated.Label","Extubated"},
		{"eOT.FacilityIDFrom.Label","设备编号"},
		{"eOT.FacilityIDTo.Label","设备编号"},
		{"eOT.FifthWeek.Label","?第五周"},
		{"eOT.FinalCount.Label","最后计数"},
		{"eOT.FinalCountCompleted.Label","?最后计数完成？"},
		{"eOT.Finalise.Label","?敲定"},
		{"eOT.FinalisedBookings.Label","?完成预订"},
		{"eOT.FinalStatus.Label","最终状态"},
		{"eOT.FinalStatusRemarks.Label","最终状态备注"},
		{"eOT.FinalStatusCompleted.Label","最终状态完成"},
		{"eOT.FinishDate.Label","完成日期"},
		{"eOT.FinishTime.Label","完成时间"},
		{"eOT.FinishDateTime.Label","完成日期／时间"},
		{"eOT.FirstAvailableDate.Label","第一允许日期"},
		{"eOT.FirstCount.Label","开始计数"},
		{"eOT.FirstCountCompleted.Label","开始计数读完成？"},
		{"eOT.FirstWeek.Label","第一周"},
		{"eOT.FourthWeek.Label","四周"},
		{"eOT.FromAdmissionDate.Label","挂号日期"},
		{"eOT.FromAnaesthesia.Label","麻醉"},
		{"eOT.FromAnaesthetist.Label","麻醉日期"},
		{"eOT.FromBookingDate.Label","预订日期"},
		{"eOT.FromOperationDate.Label","手术日期"},
		{"eOT.FromOperationRoom.Label","手术房间"},
		{"eOT.FromOperationNO.Label","手术编号"},
		{"eOT.FromOperationType.Label","手术类型"},
		{"eOT.FromPosition.Label","位置"},
		{"eOT.FromProcedure.Label","程序"},
		{"eOT.FromProcedureDate.Label","程序日期"},
		{"eOT.FromRegistrationDate.Label","登记日期"},
		{"eOT.FromSpeciality.Label","科别"},
		{"eOT.FromSurgeon.Label","外科医生"},
		{"eOT.FromSurgeryDate.Label","手术日期"},
		{"eOT.FunctionDescription.Label","功能描述"},
		{"eOT.FunctionsForRole.Label","角色功能"},
		{"eOT.FunctionsForUser.Label","用户功能"},
		{"eOT.FunctionsForStatus.Label","功能状态"},
		{"eOT.FunctionID.Label","功能编号"},
		{"eOT.Gray.Label","灰色"},
//		{"eOT.HoldingArea.Label","Holding Area"},
//		{"eOT.HoldingAreaDetails.Label","Holding Area Details"},
//		{"eOT.HoldingAreaNotes.Label","Holding Area Notes"},
//		{"eOT.HoldingAreaTime.Label","Holding Area Time"},
//		{"eOT.HoldingBay.Label","Holding Bay"},
		{"eOT.HolidayEndTime.Label","?假期结束时间"},
		{"eOT.HolidayStartTime.Label","?假期的开始时间"},
		{"eOT.HospitalPersonnel.Label","?医院人事"},
		{"eOT.Implants.Label","植入体"},
		{"eOT.ImplantType.Label","?植入型"},
		{"eOT.ImplantUsed.Label","?植入用"},
		{"eOT.ImplantVendor.Label","?植入器材供货商"},
		{"eOT.Indigo.Label","?靛蓝"},
//		{"eOT.InformedWard.Label","Informed Ward"},
		{"eOT.Interfaces.Label","界面"},
		{"eOT.InterfacetoCSSD.Label","消毒系统接口"},
		{"eOT.InterfacetoInventory.Label","清单接口"},
		{"eOT.InterfacetoPatientBilling.Label","病人账单界面"},
		{"eOT.Initial.Label","初始"},
		{"eOT.InitialCount.Label","?初步计数"},
		{"eOT.InitialStatus.Label","?初始状态"},
		{"eOT.InitialStatusRemarks.Label","初始状态备注"},
		{"eOT.InitialStatusCompleted.Label","初始状态完成？"},
		{"eOT.InitiateIPBooking.Label","预订初始的ip"},
		{"eOT.InstructionTextInLocal.Label","当地指导文字"},
		{"eOT.InstructionText.Label","?教学文本"},
		{"eOT.InstrumentCode.Label","仪器代码"},
		{"eOT.InstrumentCount.Label","计数器"},
		{"eOT.InstrumentsCSSDPacks.Label","仪器／消毒包"},
		{"eOT.IntialCount.Label","初始计数"},
		{"eOT.IntraAnaesthesia.Label","静脉麻醉"},
		{"eOT.IntraAnaesthesiaDetails.Label","静脉麻醉细节"},
		{"eOT.IntraAnaesthesiaDoc.Label","静脉麻醉医生"},
		{"eOT.IntraAnaesthesiaChartID.Label","静脉麻醉图表编号"},
		{"eOT.IntraAnaesthesiaCompleted.Label","静脉麻醉完成"},
		{"eOT.IntraAnaesthesiaNotes.Label","静脉麻醉注解"},
		{"eOT.IntraAnaesthesiaNoteType.Label","静脉麻醉注解类型"},
		{"eOT.IntraOperativeDetailsRecord.Label","术中细节记录"},
		{"eOT.Intubated.Label","气管插管"},
		{"eOT.InventoryDocumentType.Label","存货文档类型"},
		{"eOT.IPOperNextNumber.Label","住院下一手术病人编号"},
		{"eOT.IPOperMaxNumber.Label","住院最大手术病人编号"},
		{"eOT.LeftSide.Label","左边"},
		{"eOT.LightBlue.Label","浅蓝色"},
		{"eOT.LightGreen.Label","浅绿"},
		{"eOT.LinkedStatus.Label","连结状态"},
		{"eOT.LinkPreOperativeOrders.Label","链接前一个操作订单"},
//		{"eOT.LinkToCurrentEpisode.Label","Link To Current Episode"},
		{"eOT.ListOption.Label","清单操作"},
		{"eOT.Magenta.Label","紫红色"},
//		{"eOT.MarkforReschedule.Label","Mark for Reschedule"},
		{"eOT.MissingItemFound.Label","发现失踪项目"},
		{"eOT.Mortuary.Label","?殓房"},
		{"eOT.MultiSpeciality.Label","多科室"},
//		{"eOT.NatureCode.Label","Nature Code"},
//		{"eOT.NatureType.Label","Nature Type"},
		{"eOT.NextNo.Label","?下一号"},
		{"eOT.NonFinalisedBookings.Label","未最终预订"},
//		{"eOT.NoOfDaysWaitlisted.Label","No Of Days Waitlisted"},
//		{"eOT.NoOfPersons.Label","No Of Persons"},
//		{"eOT.NoofSwabCountsReqdMandatory.Label","No. of Swab Counts reqd (Mandatory)"},
//		{"eOT.NoofTimesRescheduled.Label","No. of Times Rescheduled"},
//		{"eOT.NoofUnits.Label","No of Units // New"},
//		{"eOT.NoOfUnitsPersons.Label","No Of Units/Persons"},
//		{"eOT.NoOfVerifications.Label","No. Of Verifications"},
		{"eOT.NotAdmitted.Label","不允许"},
//		{"eOT.NoteTypesForSpecialities.Label","Note Types for Specialties"},
		{"eOT.NoticeDate.Label","通知日期"},
		{"eOT.NotifyAtPreAnaesthesia.Label","麻醉前通知"},
		{"eOT.NursingDoc.Label","护理文档"},
		{"eOT.NursingDocCmplTime.Label","护理文档完成时间"},
		{"eOT.NursingNotes.Label","护理笔记"},
		{"eOT.OrderRef.Label","订单参照"},
		{"eOT.OPOperNextNumber.Label","门诊下一个手术病人编号"},
		{"eOT.OPOperMaxNumber.Label","门诊最大手术病人编号"},
		{"eOT.OpenQty.Label","打开数量"},
		{"eOT.OperationRoom.Label","手术室"},
		{"eOT.Operations.Label","手术"},
		{"eOT.OperatingSpeciality.Label","手术科室"},
		{"eOT.OperCannotbeperfin.Label","手术无法完成"},
		{"eOT.OperationCategory.Label","手术类别"},
		{"eOT.OperationCode.Label","手术代码"},
//		{"eOT.OperationCodeScheme.Label","Operation Code Scheme"},
		{"eOT.OperationDate.Label","手术日期"},
		{"eOT.OperationDescription.Label","手术描述"},
		{"eOT.OperationDetails.Label","手术细节"},
		{"eOT.OperationNo.Label","手术编号"},
		{"eOT.OperationNumberingIPDC.Label","住院／日间手术号"},
		{"eOT.OperationNumberingOPEM.Label","门诊／急诊手术号"},
		{"eOT.OperationsProcedures.Label","操作／程序"},
		{"eOT.OperationProcedure.Label","操作／程序"},
		{"eOT.OperationStatus.Label","操作状态"},
		{"eOT.OperationSubCategory.Label","操作子目录"},
		{"eOT.OperationTimings.Label","操作时间"},
		{"eOT.OperationType.Label","操作类型"},
		{"eOT.OperationTypeForRanges.Label","操作类型范围"},
		{"eOT.OperativeRecords.Label","手术记录"},
		{"eOT.OperativeRecordsNoteType.Label","手术记录说明类型"},
		{"eOT.Orange.Label","橙色"},
		{"eOT.OrderTypeForSepcialities.Label","科室订单类型"},
		{"eOT.OrganDisposal.Label","器官处理"},
		{"eOT.OtherActions.Label","其它处理"},
		{"eOT.OverBookingAllowedYN.Label","允许过量预订 Y/N"},
		{"eOT.OverrideSpecialtyRestriction.Label","超过专业限制限制"},
		{"eOT.OTNotificationWithinADay.Label","手术通知(一天内)"},
		{"eOT.OTStatusDescriptions.Label","手术状态描述"},
//		{"eOT.PACReviewOrderable.Label","PAC Review Orderable"},
//		{"eOT.PacksInstrsEquipsImplants.Label","Consumables Packs/Instruments/Equipments/Implants"},
		{"eOT.PatientConsentDetails.Label","病人同意细节"},
		{"eOT.PatientDemographics.Label","病人家族史"},
		{"eOT.PatientSurgeryHistory.Label","病人手术史"},
		{"eOT.Personnel.Label","人事"},
		{"eOT.PersonnelDetails.Label","人事信息"},
		{"eOT.PersonnelInvolved.Label","参与人员"},
		{"eOT.PersonnelRequired.Label","所需人员"},
		{"eOT.Pink.Label","粉红"},
		{"eOT.PostAnaesthesia.Label","术后麻醉"},
		{"eOT.PostAnaesthesiaDetails.Label","术后麻醉细节"},
		{"eOT.PostAnaesthesiaChartID.Label","术后麻醉图表"},
		{"eOT.PostAnaesthesiaCompleted.Label","术后麻醉完成"},
		{"eOT.PostAnaesthesiaNotes.Label","术后麻醉注解"},
		{"eOT.PostAnaesthesiaNoteType.Label","术后麻醉类型"},
		{"eOT.PostOperativeCheckList.Label","术后清单"},
		{"eOT.PostOperativeDetailsRecord.Label","术后明细细节"},
		{"eOT.PostOperativeDiagnosis.Label","术后诊断"},
		{"eOT.PostOperativeNoOfVerifications.Label","手术检查号"},
		{"eOT.PostStageDescription.Label","后阶段描述"},
		{"eOT.PractitionerTypesForRoleTypes.Label","医生的各种角色类型"},
		{"eOT.PreAnaesthesiaCompleted.Label","预麻醉完成"},
		{"eOT.PreAnaesthesiaDetails.Label","预麻醉完成"},
		{"eOT.PreAnaesthesiaEval.Label","预麻醉评价"},
		{"eOT.PreAnaesthesiaEvalStage.Label","麻醉前评估阶段"},
		{"eOT.PreAnaesthesiaForm.Label","预麻醉形式"},
		{"eOT.PreAnaesthesiaNotes.Label","预麻醉说明"},
		{"eOT.PreAnaesthesiaNoteType.Label","预麻醉备注类型"},
		{"eOT.PreAnaesthesiaStage.Label","预麻醉阶段"},
		{"eOT.PreferredSurgeryDate.Label","推荐手术日期"},
		{"eOT.PrefixDateOperationNumber.Label","前缀日期操作人数"},
		{"eOT.PreMorbidCode.Label","前病态代码"},
		{"eOT.PremorbidDetails.Label","前病态的详细资料"},
		{"eOT.PreMorbidStatus.Label","前病态的状态"},
		{"eOT.PreOperativeAssessmentNum.Label","术前评估编号"},
		{"eOT.PreOperativeCheckList.Label","术前检查"},
		{"eOT.PreOperativeDetailsRecord.Label","术前明细记录"},
		{"eOT.PreOperativeDiagnosis.Label","术前诊断"},
		{"eOT.PreOperativeIndicator.Label","术前指标"},
		{"eOT.PreOperativeNoOfVerifications.Label","术前核查号"},
		{"eOT.PreparationTime.Label","准备时间"},
		{"eOT.PrepTimeinMins.Label","准备时间（分钟）"},
		{"eOT.PreStageDescription.Label","前期阶段描述"},
//		{"eOT.PreviousRemarks.Label","Previous Remarks"},
//		{"eOT.PreviousReschedule.Label","Previous Reschedule"},
//		{"eOT.PrintBookingSlipOnConfirmation.Label","Print Booking Slip On Confirmation"},
//		{"eOT.PrintOption.Label","Print Option"},
//		{"eOT.ProcedureCoding.Label","Procedure Coding"},
//		{"eOT.Procedure(s).Label","Procedure(s)"},
//		{"eOT.ProcedureEndTime.Label","Procedure End Time"},
//		{"eOT.ProcedureRemarksData.Label","Procedure Remarks Data"},
//		{"eOT.ProcedureStartTime.Label","Procedure Start Time"},
//		{"eOT.Prosthesis.Label","Prosthesis"},
//		{"eOT.ProsthesisCategory.Label","Prosthesis Category"},
//		{"eOT.ProsthesisCode.Label","Prosthesis Code"},
//		{"eOT.ProsthesisImplantsCategories.Label","Prosthesis/Implants Categories"},
//		{"eOT.ProsthesisImplants.Label","Prosthesis/Implants"},
//		{"eOT.ProsthesisImplantsDetails.Label","Prosthesis/Implants Details"},
//		{"eOT.ProsthesisImplantsTypes.Label","Prosthesis/Implants Types"},
//		{"eOT.ProsthesisType.Label","Prosthesis Type"},
		{"eOT.Purple.Label","紫色"},
		{"eOT.RearrangeSequence.Label","排列顺序"},
		{"eOT.ReassignTheatre.Label","安排手术室"},
		{"eOT.RecordChart.Label","图表记录"},
		{"eOT.RecordIntraAnaesthesiaDetails.Label","静脉麻醉细节"},
		{"eOT.RecordNursingNotes.Label","护理记录细节"},
		{"eOT.RecordPostAnaesthesiaDetails.Label","记录麻醉后细节"},
		{"eOT.RecordSurgeonNotes.Label","麻醉医生记录"},
		{"eOT.RecordVitals.Label","记录命脉？？？"},
		{"eOT.RecoveryDetails.Label","恢复详情"},
		{"eOT.RecoveryCheckInTime.Label","恢复检查时间"},
		{"eOT.RecoveryEndDate.Label","修复结束日期"},
		{"eOT.RecoveryEndTime.Label","恢复结束时间"},
		{"eOT.RecoveryEndTransferDate.Label","恢复结束转换日期"},
		{"eOT.RecoveryNotes.Label","恢复笔记"},
		{"eOT.RecoveryParticulars.Label","恢复说情"},
		{"eOT.RecoveryStartDate.Label","恢复开始日期"},
		{"eOT.RecoveryStartTime.Label","恢复开始时间"},
		{"eOT.ReEvaluation.Label","重新评估"},
		{"eOT.Registeredforoperation.Label","手术登记"},
		{"eOT.ReleaseTheatreSlots.Label","翻译手术间隔"},
//		{"eOT.ReportEmailReminderLetter.Label","Report/Email Reminder Letter"},
//		{"eOT.ReportinExcelFormat.Label","Report in Excel Format"},
//		{"eOT.Reqd.Label","Reqd"},
		{"eOT.Resequencing.Label","测序/ /新"},
		{"eOT.ResequencingDate.Label","?测序日期/ /新"},
		{"eOT.ReScheduled.Label","改期"},
		{"eOT.ReScheduleCases.Label","改例"},
		{"eOT.RescheduleCount.Label","重新计数"},
		{"eOT.RescheduleForm.Label","安排表"},
		{"eOT.RescheduledBy.Label","改期"},
		{"eOT.RestrictBySpecialityYN.Label","科室限制 Y／N"},
		{"eOT.RestrictTheatreBooking.Label","限制手术预订"},
		{"eOT.Reversal.Label","逆转"},
		{"eOT.RightSide.Label","右边"},
		{"eOT.RoleDescription.Label","角色描述"},
		{"eOT.RoleID.Label","角色编号"},
		{"eOT.RoleTypeDescription.Label","角色类型描述"},
		{"eOT.RoomWiseTotal.Label","Room Wise Total"},
		{"eOT.ScanPatient.Label","病人扫描"},
		{"eOT.ScheduledCases.Label","预定案例"},
		{"eOT.ScheduleStatus.Label","附表状态"},
		{"eOT.ScheduleType.Label","附表类型"},
		{"eOT.SecondCount.Label","二次计数"},
		{"eOT.SecondCountCompleted.Label","二次计数完成？"},
		{"eOT.SecondWeek.Label","第二周"},
		{"eOT.Section1.Label","第1节"},
		{"eOT.Section2.Label","第2节"},
		{"eOT.Section3.Label","第3节"},
//		{"eOT.Section1NoticeFromTime.Label","Section 1 Notice From Time"},
//		{"eOT.Section1NoticeToTime.Label","Section 1 Notice To Time"},
//		{"eOT.Section2NoticeFromTime.Label","Section 2 Notice From Time"},
//		{"eOT.Section2NoticeToTime.Label","Section 2 Notice To Time"},
//		{"eOT.Section3NoticeFromTime.Label","Section 3 Notice From Time"},
//		{"eOT.Section3NoticeToTime.Label","Section 3 Notice To Time"},
		{"eOT.SelectDeselectAll.Label","选择/取消一切/ /新"},
		{"eOT.SelectNoteType.Label","?选择类型说明"},
		{"eOT.Sequence.Label","?序列"},
		{"eOT.SetComponents.Label","设置组件"},
		{"eOT.SetUpOperTimeRangesForRept.Label","为报告设置手术时间范围"},
		{"eOT.SetupParameter.Label","?安装参数"},
		{"eOT.SetupParametersForFacility.Label","设置设备参数"},
		{"eOT.ShowLastAntibioticAdminTime.Label","?显示最近抗生素管理时间"},
		{"eOT.SideApplicable.Label","?一方适用"},
//		{"eOT.SignatureAndSeal.Label","Signature & Seal"},
//		{"eOT.Slate.Label","Slate"},
//		{"eOT.SlotTime.Label","Slot time"},
		{"eOT.SourceId.Label","来源ID"},
		{"eOT.SpecificIndicator.Label","具体指标"},
		{"eOT.SpecificOperationCategoryWithinSpeciality.Label","具体操作类别（专业范围内）"},
		{"eOT.SpecificOperationSubCategoryWithinSpeciality.Label","具体操作子类别（专业范围）"},
		{"eOT.SpecificUsers.Label","特定用户"},
		{"eOT.SpecificWeeks.Label","具体周"},
		{"eOT.SpecimenNoDtl.Label","标本号／明细"},
		{"eOT.Stages.Label","阶段"},
		{"eOT.StandardDuration.Label","标准时间"},
		{"eOT.StandardInstructions.Label","标准说明"},
		{"eOT.StandInstrnsinLocalLang.Label","当地语言的标准说明"},
		{"eOT.StatusCode.Label","状态代码"},
		{"eOT.StatusDescription.Label","状态描述"},
		{"eOT.StatusDetails.Label","状态明细"},
		{"eOT.StdQty.Label","标准数量"},
		{"eOT.SubCategory.Label","子目录"},
		{"eOT.SupplementaryItem.Label","供应代码"},
		{"eOT.SurgDocCmplTime.Label","手术文档完成时间"},
		{"eOT.SurgeonAvgTime.Label","手术平均时间"},
//		{"eOT.SurgeonsDiarySchedule.Label","Surgeon Diary - Generate Schedule"},
//		{"eOT.SurgeonsDiaryMaintainSchedule.Label","Surgeon Diary - Maintain Schedule"},
		{"eOT.SurgeonDoc.Label","手术医生"},
		{"eOT.SurgeonNotes.Label","手术日志"},
		{"eOT.SurgeonPreferences.Label","手术参考"},
		{"eOT.SurgeryBookings.Label","手术预订"},
		{"eOT.SurgeryDate.Label","手术日期"},
		{"eOT.SurgeryHistory.Label","手术史"},
		{"eOT.SurgeryStartTime.Label","手术开始时间"},
		{"eOT.SurgicalAccessories.Label","手术配件"},
		{"eOT.SwabandInstrumentCount.Label","棉签和食品数量"},
		{"eOT.SwabCount.Label","棉签数量"},
		{"eOT.SwabSerialNumbers.Label","棉签序号"},
		{"eOT.SystemDefinedDescription.Label","系统定义类型"},
		{"eOT.TemplateItems.Label","模版项目"},
		{"eOT.TextColor.Label","文字颜色"},
		{"eOT.TheatretypeTheatre.Label","手术类型／手术"},
		{"eOT.TheatreDate.Label","手术日期"},
		{"eOT.Theatrefrom.Label","手术"},
		{"eOT.TheatreSequenceNo.Label","手术序列号"},
		{"eOT.TheatreType.Label","手术类型"},
		{"eOT.TheatreValue.Label","手术值／／新"},
		{"eOT.ThirdWeek.Label","第三周"},
		{"eOT.TimeandDetails.Label","时间和明细"},
		{"eOT.TimeRange.Label","时间范围"},
		{"eOT.TimeRangeCode.Label","时间范围代码"},
		{"eOT.TimeSlot.Label","时段"},
		{"eOT.TimeSlots.Label","时段"},
		{"eOT.ToAdmissionDate.Label","入院日期"},
		{"eOT.ToAnaesthesiaCode.Label","入院代码"},
		{"eOT.ToAnaesthetist.Label","麻醉师"},
		{"eOT.ToBeRescheduleCases.Label","安排病例"},
		{"eOT.ToBookingDate.Label","预订日期"},
		{"eOT.ToDiagnosis.Label","诊断"},
		{"eOT.ToImplantType.Label","植入型"},
		{"eOT.ToOperationDate.Label","手术日期"},
		{"eOT.ToOperationNo..Label","手术号"},
		{"eOT.ToOperationRoom.Label","手术室"},
		{"eOT.ToOperationType.Label","手术类型"},
		{"eOT.ToPosition.Label","位置"},
		{"eOT.ToProcedure.Label","程序"},
		{"eOT.ToProcedureDate.Label","程序日期"},
		{"eOT.ToRegistrationDate.Label","登记日期"},
		{"eOT.ToSpeciality.Label","科室"},
		{"eOT.ToSurgeon.Label","外科医生"},
		{"eOT.ToSurgeryDate.Label","手术日期"},
		{"eOT.TotalDuration.Label","总的间隔"},
		{"eOT.TotalNoOfPatientsWaitlisted.Label","总的病人等候列表号"},
		{"eOT.TotalNoOfPatientsWaitlistedSpecialitywise.Label","总的病人等候列表号"},
		{"eOT.TotalNoOfPatientsWaitlistedSurgeonwise.Label","总的病人等候列表号"},
//		{"eOT.TotalSurgeonwiseBookings.Label","Total Surgeon wise Bookings"},
//		{"eOT.TotalTheatrewiseBookings.Label","Total Theatre wise Bookings"},
		{"eOT.ToTheatre.Label","手术室"},
		{"eOT.ToWard.Label","病区"},
		{"eOT.TransferDetails.Label","转换明细"},
		{"eOT.TransferSelectedPatients.Label","转换选定病人"},
		{"eOT.TransferTime.Label","转换时间"},
		{"eOT.TransfertoOTfromRecoveryRoom.Label","从恢复室转到手术室"},
		{"eOT.UnitTimeforBooking.Label","单位时间内的预订"},
		{"eOT.UnSchedule.Label","不定的"},
		{"eOT.UnScheduledCases.Label","不定的事件"},
		{"eOT.UntowardEvent.Label","不良事件"},
		{"eOT.UntowardEvents.Label","不良事件"},
		{"eOT.UnusualOccurenceCode.Label","不寻常事件代码"},
		{"eOT.UnusualOccurrence.Label","不寻常事件"},
		{"eOT.UserRole.Label","用户角色"},
		{"eOT.VerificationAllowed.Label","允许核查"},
		{"eOT.VerificationApplicable.Label","适用核查"},
		{"eOT.VerifyCheckList.Label","清单确认"},
		{"eOT.VerifyCheckOutChecklist.Label","退出清单检查"},
		{"eOT.VerifySwabCount.Label","确认棉签数量"},
		{"eOT.ViewBookingDetails.Label","查看预订明细"},
		{"eOT.ViewCheckList.Label","查看清单"},
		{"eOT.ViewPreAnaesthesiaEvaluationDetails.Label","查看预麻醉评估细节"},
		{"eOT.ViewRemarks.Label","查看备注"},
		{"eOT.VisitingPersonnel.Label","客座人员"},
		{"eOT.Violet.Label","紫罗兰"},
		{"eOT.WaitingTimeBy.Label","等待时间"},
		{"eOT.WaitlistCases.Label","病历等待名单"},
		{"eOT.WaitlistDate.Label","等待名单日期？？？"},
		{"eOT.WaitlistDays.Label","等等名单日？？？"},
		{"eOT.WaitListDetails.Label","等待名单明细"},
		{"eOT.WaitListNextNumber.Label","等待名单下一编号"},
		{"eOT.WaitListMaxNumber.Label","等待名单最大编号"},
		{"eOT.WaitListNO.Label","等待名单号"},
		{"eOT.WaitListNumbering.Label","等待名单数"},
		{"eOT.WaitlistSelectedPatients.Label","等待名单中选中病人"},
		{"eOT.WaitlistWarning.Label","等待名单提醒"},
		{"eOT.WaitlistWarningLimitDays.Label","等待名单提醒限制天数"},
		{"eOT.WaitListWindow.Label","等待名单窗口"},
		{"eOT.WardCheckoutTime.Label","病区查房时间"},
		{"eOT.WarnForUnscheduledCasesOnly.Label","对未在等待名单中的病例提醒"},
		{"eOT.White.Label","白色"},
		{"eOT.WorkingDay.Label","工作日"},
		{"eOT.WorkingDayEndTime.Label","工作日结束时间"},
		{"eOT.WorkingDayStartTime.Label","工作日开始时间"},
		{"eOT.WoundDetails.Label","伤口详情"},
		{"eOT.WoundType.Label","创面类型"},
		{"eOT.WoundTypeCode.Label","创面类型代码"},
		{"eOT.X-rayPerformed.Label","X光检查"},
		{"eOT.SwabCountTemplate.Label","棉签计数模版"},
		{"eOT.TimeCalled.Label","时间提醒"},
		{"eOT.NameOfOTStaff.Label","手术人员姓名"},
//		{"eOT.NameOfPorter.Label","Name Of Porter"},
//		{"eOT.TimePorterLeavesOT.Label","Time Porter Leaves OT"},
//		{"eOT.ApplicableToOTSlate.Label","Applicable To OT-Slate"},
		{"eOT.AvgTime.Label","平均时间"},
		{"eOT.BookingSequenceNo.Label","预订序列号"},
		{"eOT.DateReceived.Label","收到日期"},
		{"eOT.DateSent.Label","发出日期"},
//		{"eOT.DepartmentwiseTotalNoOfPatients.Label","Department wise Total NO of Patients"},
//		{"eOT.DisposedTo.Label","Disposed To"},
		{"eOT.EndOfReport.Label","报告结束"},
		{"eOT.FinalizedBy.Label","结束"},
		{"eOT.FromCode.Label","代码"},
		{"eOT.HrsMin.Label","（小时：分钟）"},
		{"eOT.ListCheckedBy.Label","?检查清单"},
		{"eOT.MaxTime.Label","最大时间"},
		{"eOT.MinTime.Label","最小时间"},
//		{"eOT.MonthwiseTotal.Label","MonthWise Total"},
		{"eOT.MthYr.Label","月／年"},
		{"eOT.NameOfBodyPart.Label","器官名称"},
		{"eOT.NameofMedicalOfficerI/C.Label","医务人员名称 I／C"},
		{"eOT.NameOfOrNurse.Label","护十名称"},
		{"eOT.NameOfTest.Label","测试名称"},
//		{"eOT.NatureOfSurgery.Label","Nature Of Surgery"},
		{"eOT.NonSpecimenOrForeignBody.Label","非标本或异物"},
		{"eOT.NoOfCasesPerformed.Label","未操作的案例"},
		{"eOT.NoOfOperatingRoomsForThisFacility.Label","设备的手术房间号"},
		{"eOT.NoOfOperations.Label","未手术"},
		{"eOT.OperatingFacility.Label","手术设备"},
		{"eOT.OperationsPerformed.Label","手术操作"},
		{"eOT.PlannedOperation.Label","计划手术"},
		{"eOT.PatientInformationFileID.Label","病人信息档案编号"},
//		{"eOT.PersonDespatchingSpecimen.Label","Person Despatching Specimen"},
		{"eOT.Persons.Label","人类"},
		{"eOT.RecordingNurse.Label","护理记录"},
		{"eOT.SSGroup.Label","SS Group"},
		{"eOT.SurgicalDepartment.Label","外科部门"},
		{"eOT.SwabandInstrumentTemplate.Label","棉签和仪器计数模版"},
		{"eOT.TimeReceived.Label","收到时间"},
		{"eOT.TimeSent.Label","发出时间"},
/*		{"eOT.TotalNoOfBookingFinalisationStageCodes.Label","Total NO Of Booking Finalisation Stage Codes"},
		{"eOT.TotalNoOfBookingPriorityCodes.Label","Total NO Of Booking Priority Codes"},
		{"eOT.TotalNoOfChecklistCodes.Label","Total NO Of Checklist Codes"},
		{"eOT.TotalNoOfConsumablePacks.Label","Total NO Of Consumable Packs"},
		{"eOT.TotalNoOfEquipments.Label","Total NO Of Equipments"},
		{"eOT.TotalNoOfFunctionIDs.Label","Total NO Of Function IDs"},
		{"eOT.TotalNoOfHoldingAreaCodes.Label","Total NO Of Holding Area Codes"},
		{"eOT.TotalNoOfInstruments.Label","Total NO Of Instruments"},
		{"eOT.TotalNoOfOperations.Label","Total NO Of Operations"},
		{"eOT.TotalNoOfOperationTypes.Label","Total NO Of Operation Types"},
		{"eOT.TotalNoOfOrganDisposal.Label","Total NO Of Organ Disposal"},
		{"eOT.TotalNoOfPositions.Label","Total NO Of Positions"},
		{"eOT.TotalNoOfProthesisCategory.Label","Total NO Of Prothesis Category"},
		{"eOT.TotalNoOfProthesisImplants.Label","Total No Of Prothesis / Implants"},
		{"eOT.TotalNoOfProthesisType.Label","Total NO Of Prothesis Types"},
		{"eOT.TotalNoOfReasons.Label","Total NO Of Reasons"},
		{"eOT.TotalNoOfRecordsForChecklistItems.Label","Total NO Of Records For Checklist Items"},
		{"eOT.TotalNoOfRoles.Label","Total No Of Roles"},
		{"eOT.TotalNoOfRoleTypes.Label","Total No Of Role Types"},
		{"eOT.TotalNoOfSpecialities.Label","Total No Of Specialities"},
		{"eOT.TotalNoOfStatus.Label","Total No Of Status"},
		{"eOT.TotalNoOfSurgeryTypes.Label","Total No Of Surgery Types"},
		{"eOT.TotalNoOfSwabTemplate.Label","Total No OfSwab Template"},
		{"eOT.TotalNoOfSwabTemplateItems.Label","Total No Of Swab Template Items"},
		{"eOT.TotalNoOfUsers.Label","Total No Of Users"},
		{"eOT.TotalNoOfUsualOccurences.Label","Total No Of Usual Occurences"},
		{"eOT.TotalNoOfOperWithoutPostOperDtls.Label","Total No Of Oper Without Post Oper Dtls"},
		{"eOT.TotalNoOfWoundTypes.Label","Total No Of Wound Types"},*/
		{"eOT.WaitingTimeInDays.Label","一天等待时间"},
		{"eOT.WoundText.Label","伤口文本"},
		{"eOT.OrderDateVsApptDate.Label","订购日期与预约日期"},
		{"eOT.FirstScheduleDateVsReScheduledDate.Label","首次安排日期与重新安排日期"},
		{"eOT.TotalNoOfOperationsForTheAnaesthetist.Label","总的麻醉医生"},
		{"eOT.TotalNoOfOperationsForTheSurgeon.Label","总的手术医生"},
//		{"eOT.SpecialitywiseTotal.Label","Speciality wise Total"},
//		{"eOT.DatewiseTotal.Label","Date wise Total"},
//		{"eOT.OperationTypewiseTotal.Label","Operation Type wise Total"},
//		{"eOT.OperationDurationwiseTotal.Label","Operation duration wise Total"},
//		{"eOT.SurgeonwiseTotal.Label","Surgeon wise Total"},
		{"eOT.TotalNoOfOperationsForTheDate.Label","总的手术日期"},
		{"eOT.TimeDetails.Label","时间详情"},
		{"eOT.BillingSubServices.Label","结算服务小组"},
		{"eOT.Payable.label","应付帐款"},
		{"eOT.Payable.Label","应付帐款"},
		{"eOT.ReportPeriodicity.Label","报告周期"},
		{"eOT.Quarterly.Label","季刊"},
		{"eOT.Annually.Label","每年"},
		{"eOT.BiAnnually.Label","每年"},
		{"eOT.FirstHalf.Label","上半年"},
		{"eOT.SecondHalf.Label","下半年"},
		{"eOT.Quarter1.Label","1季度"},
		{"eOT.Quarter2.Label","2季度"},
		{"eOT.Quarter3.Label","3季度"},
		{"eOT.Quarter4.Label","4季度"},
		{"eOT.PatientSignature.Label","患者签名"},
		{"eOT.PreOperatingDiagnosis.Label","术前诊断"},
		{"eOT.BookingNumber.Label","预订号码"},
		{"eOT.BookingBy.Label","预订到"},
		{"eOT.GenerateBy.Label","生成"},
		{"eOT.TheatreAndSurgeon.Label","手术和手术医生"},
		{"eOT.SurgeryDepartment.Label","手术部门"},
		{"eOT.DiarySchduleForSurgeonReqd.Label","医生请求的日程表"},
		{"eOT.AssignSurgeon.Label","分配手术医生"},
		{"eOT.AllowedForOverBooking.Label","完全预订（允许超量预订）"},
		{"eOT.WardCheckOutSearchCheckBox.Label","考虑病人当前的护理级别？？"},
//		{"eOT.SlateLoginRequired.Label","Slate Login Required?"},
		{"eOT.Citizenid.Label","公民身份证"},
		{"eOT.Orderresultstatus/additionalinformation-forpatientid.Label","医嘱结果状态/附加信息-为患者编号："},
		{"eOT.Lastmealtime.Label","上次就餐时间"},
		{"eOT.Totalfor.Label","总数"},
		{"eOT.CheckOutFromOR.Label","出院"},
/*		{"eOT.BookingCut-offTimeforElectiveCases.Label","Booking Cut-off Time for Elective Cases"},
		{"eOT.ReviewedBy.Label","Reviewed By"},
		{"eOT.OperationNumber.Label","Operation Number"},
		{"eOT.NationalID.Label","National ID"},
		{"eOT.PrePackSet.Label","Pre-Pack Set"},
		{"eOT.Supplementary.Label","Supplementary"},
		{"eOT.CountItems.Label","Count Items"},
		{"eOT.AdditionsDuringCC.Label","Additions During CC"},
		{"eOT.CompletionDetails.Label","Completion Details"},
		{"eOT.CountStage.Label","Count Stage"},
		{"eOT.CompletedBy.Label","Completed By"},
		{"eOT.CompleteDate/Time.Label","Complete date/Time"},
		{"eOT.ReviewedDate.Label","Reviewed Date"},
		{"eOT.BioHazard.Label","Bio Hazard"},
		{"eOT.DetailToIndicateCorrectFinalCheckOfOtherInstruments.Label","DETAIL TO INDICATE CORRECT FINAL CHECK OF OTHER INSTRUMENTS"},
		{"eOT.ForDiscrepenciesInCount.Label","FOR DISCREPENCIES IN COUNT :"},
		{"eOT.X-RayOrdered.Label","X-RAY ORDERED :"},
		{"eOT.Taken.Label","TAKEN :"},
		{"eOT.Result.Label","RESULT :"},
		{"eOT.ParticularsOfGauzeTubesandCathetersLeftInSitu.Label","PARTICULARS OF GAUZE, TUBES AND CATHETERS LEFT IN SITU :"},
		{"eOT.UnderWaterDrainage.Label","UNDER WATER DRAINAGE :"},
		{"eOT.PacingWire.Label","PACING WIRE :"},
		{"eOT.MonitoringLine.Label","MONITORING LINE :"},
		{"eOT.Specimens.Label","SPECIMENS :"},
		{"eOT.SurgeonInformedThatAboveCountsAreCorrect.Label","SURGEON INFORMED THAT ABOVE COUNTS ARE CORRECT :"},
		{"eOT.SurgeonsSignature.Label","SURGEON'S SIGNATURE"},
		{"eOT.ScrubNursesSignature.Label","SCRUB NURSE'S SIGNATURE"},
		{"eOT.Allanaesthesia.Label","All Anaesthesia"},
		{"eOT.CirculatingNursesSignature.Label","CIRCULATING NURSE'S SIGNATURE"},
		{"eOT.operationss.Label","Operation(s)"},
		{"eOT.TotalNoOfOperationsForTheAnaesthesia.Label","Total No of Operations for the Anaesthesia"}*/
//Newly added legends on 21/01/09
{"eOT.2ndCount.Label","第二次计数"},
{"eOT.AcceptRemarks.Label","接受备注"},
{"eOT.AccessionNum.Label","新增数"},
{"eOT.AcrossSpecialities.Label","跨科室"},
{"eOT.ActionDate.Label","行动日期"},
{"eOT.ActionIfNotDone.Label","如果不做所采取的行动"},
{"eOT.ActionTypesForReason.Label","行动类型原因"},
{"eOT.AddaSet.Label","添加一组"},
{"eOT.Addaswabcount.Label","增加一个擦除计数"},
{"eOT.AdditionsafterClcavityCompl.Label","Additions after Cl. cavity Completed?"},
{"eOT.AdditionsduringOP.Label","门诊病人添加"},
{"eOT.AdditionsDuringOPCompleted.Label","门诊完成时添加?"},
{"eOT.AdditionsduringOperation.Label","手术时添加"},
{"eOT.Addns.Label","添加"},
{"eOT.AddnsafterCC.Label","添置"},
{"eOT.AdmittingSpeciality.Label","入院科室"},
{"eOT.AllElective.Label","所有可选择的"},
{"eOT.AllowBarcode.Label","允许条码"},
{"eOT.AnaesthetistWiseTotal.Label","麻醉总数"},
{"eOT.AnyDiscrepanciesinFirstCount.Label","第一计数差异"},
{"eOT.ApplicableForOTSlate.Label","适用于手术记帐"},
{"eOT.ApplicableToOTSlate.Label","适用于手术记帐"},
{"eOT.AssociatedAnaesthestist.Label","麻醉师助手"},
{"eOT.AutoPopulated.Label","自动填充"},
{"eOT.BasicSet.Label","基础设置"},
{"eOT.BasicSetSuppltemVerifySwabCnt.Label","基本设置/补充项目/确认计数"},
{"eOT.Bilateral.Label","两边"},
{"eOT.BlockSlotsByAgeGroup.Label","通过年龄分组锁定"},
{"eOT.BlockSlotsBySpeciality.Label","通过科室锁定"},
{"eOT.BlockSlotsForTheOperatingRoom.Label","手术室锁定"},
{"eOT.BlockTheatreSlots.Label","手术室锁定"},
{"eOT.BookingHeader.Label","预计标题"},
{"eOT.BookingScreenSlip.Label","预订滑动屏幕"},
{"eOT.BuildAnaesthesiaIntoCR.Label","在手术室中建立麻醉"},
{"eOT.ByTimeSeq.Label","通过时间/序列号"},
{"eOT.ChangeHoldingBay.Label","改病病人位置"},
{"eOT.CheckIntoORTime.Label","记录病人进手术时间"},
{"eOT.CrossRefMMItem.Label","库房项目编码"},
{"eOT.DatewiseTotal.Label","日期汇总"},
{"eOT.DepartmentwiseTotalNoOfPatients.Label","病人总数"},
{"eOT.DepositRequired.Label","需要押金?"},
{"eOT.DiaryGeneratedupto.Label","日记生成截止到"},
{"eOT.DiaryScheduleforSurgeon.Label","手术进度日志"},
{"eOT.DiaryScheduleforTheatre.Label","手术室进度日志"},
{"eOT.DisposedTo.Label","发送到"},
{"eOT.EmailPrintReminderLetter.Label","发送/打印提醒信"},
{"eOT.EncounterLookup.Label","特定案列"},
{"eOT.Episode.Label","特定病人"},
{"eOT.EpisodeDetails.Label","病人案例明细"},
{"eOT.EpisodeTypeID.Label","案例类型/案例编号"},
{"eOT.Extubated.Label","去管时间"},
{"eOT.HoldingArea.Label","等待区域"},
{"eOT.HoldingAreaDetails.Label","等待区域详细情况"},
{"eOT.HoldingAreaNotes.Label","等待区域备注"},
{"eOT.HoldingAreaTime.Label","进等待区时间"},
{"eOT.HoldingBay.Label","等待区域床位"},
{"eOT.InformedWard.Label","通知病区"},
{"eOT.LinkToCurrentEpisode.Label","链接当前案列"},
{"eOT.MarkforReschedule.Label","标志重规划进度表"},
{"eOT.MonthwiseTotal.Label","月汇总"},
{"eOT.NameOfPorter.Label","工务员姓名"},
{"eOT.NatureCode.Label","性质代码"},
{"eOT.NatureOfSurgery.Label","手术性质"},
{"eOT.NatureType.Label","性质类型"},
{"eOT.NoOfDaysWaitlisted.Label","等待天数"},
{"eOT.NoOfPersons.Label","病人数"},
{"eOT.NoofSwabCountsReqdMandatory.Label","擦除计数号(必填)"},
{"eOT.NoofTimesRescheduled.Label","病人手术重新安排的"},
{"eOT.NoofUnits.Label","单位编号"},
{"eOT.NoOfUnitsPersons.Label","单位编号"},
{"eOT.NoOfVerifications.Label","确认数"},
{"eOT.NoteTypesForSpecialities.Label","科室类型备注"},
{"eOT.OperationCodeScheme.Label","手术代码表"},
{"eOT.OperationDurationwiseTotal.Label","手术持续时间"},
{"eOT.OperationTypewiseTotal.Label","特定手术类型持续时间"},
{"eOT.PacksInstrsEquipsImplants.Label","耗材包/仪器/设备/植体"},
{"eOT.PACReviewOrderable.Label","PAC回顾"},
{"eOT.PersonDespatchingSpecimen.Label","发放标本者"},
{"eOT.PreviousRemarks.Label","之前备注"},
{"eOT.PreviousReschedule.Label","之前安排表"},
{"eOT.PrintBookingSlipOnConfirmation.Label","打印确认预订"},
{"eOT.PrintOption.Label","打印确认预订"},
{"eOT.Procedure(s).Label","进程数"},
{"eOT.ProcedureCoding.Label","进程代码"},
{"eOT.ProcedureEndTime.Label","进程结束时间"},
{"eOT.ProcedureRemarksData.Label","进程备注数据"},
{"eOT.ProcedureStartTime.Label","进程开始时间"},
{"eOT.Prosthesis.Label","假肢"},
{"eOT.ProsthesisCategory.Label","假肢种类"},
{"eOT.ProsthesisCode.Label","假肢代码"},
{"eOT.ProsthesisImplants.Label","假肢/植入器材"},
{"eOT.ProsthesisImplantsCategories.Label","假肢/植入器材目录"},
{"eOT.ProsthesisImplantsDetails.Label","假肢/植入器材明细"},
{"eOT.ProsthesisImplantsTypes.Label","假肢/植入器材类型"},
{"eOT.ProsthesisType.Label","假肢类型"},
{"eOT.ReportEmailReminderLetter.Label","报告/邮件提醒醒"},
{"eOT.ReportinExcelFormat.Label","用电子表格报告"},
{"eOT.Reqd.Label","特定要求"},
{"eOT.RoomWiseTotal.Label","总的房间数"},
{"eOT.Section1NoticeFromTime.Label","通知开始时间"},
{"eOT.Section1NoticeToTime.Label","通知结束时间"},
{"eOT.Section2NoticeFromTime.Label","通知开始时间"},
{"eOT.Section2NoticeToTime.Label","通知结束时间"},
{"eOT.Section3NoticeFromTime.Label","通知开始时间"},
{"eOT.Section3NoticeToTime.Label","通知结束时间"},
{"eOT.SignatureAndSeal.Label","签名及印章"},
{"eOT.Slate.Label","手术记帐"},
{"eOT.SlateLoginRequired.Label","要求登录用户?"},
{"eOT.SlotTime.Label","时间片"},
{"eOT.SpecialitywiseTotal.Label","报告总数"},
{"eOT.SSGroup.Label","器材组"},
{"eOT.SurgeonsDiaryMaintainSchedule.Label","手术日志-主要安排"},
{"eOT.SurgeonsDiarySchedule.Label","手术日志-生成进度"},
{"eOT.SurgeonwiseTotal.Label","生成手术总数"},
{"eOT.TimePorterLeavesOT.Label","工务员离开手术室时间"},
{"eOT.TotalNoOfBookingFinalisationStageCodes.Label","总的预订代码数"},
{"eOT.TotalNoOfBookingPriorityCodes.Label","预订优先级代码数"},
{"eOT.TotalNoOfChecklistCodes.Label","检查列表代码数"},
{"eOT.TotalNoOfConsumablePacks.Label","消耗包总数"},
{"eOT.TotalNoOfEquipments.Label","器械数"},
{"eOT.TotalNoOfFunctionIDs.Label","功能数"},
{"eOT.TotalNoOfHoldingAreaCodes.Label","总的复苏室代码数"},
{"eOT.TotalNoOfInstruments.Label","总的设备数"},
{"eOT.TotalNoOfOperations.Label","总的手术数"},
{"eOT.TotalNoOfOperationTypes.Label","总的手术类型数"},
{"eOT.TotalNoOfOperWithoutPostOperDtls.Label","无术后明细的手术数"},
{"eOT.TotalNoOfOrganDisposal.Label","手术清单总数"},
{"eOT.TotalNoOfPositions.Label","手术位置数"},
{"eOT.TotalNoOfProthesisCategory.Label","总的假肢类型数"},
{"eOT.TotalNoOfProthesisImplants.Label","总的假肢/植入性器材数"},
{"eOT.TotalNoOfProthesisType.Label","总的假肢类型"},
{"eOT.TotalNoOfReasons.Label","总的原因设置"},
{"eOT.TotalNoOfRecordsForChecklistItems.Label","检查列表记录数"},
{"eOT.TotalNoOfRoles.Label","应用中的角色数"},
{"eOT.TotalNoOfRoleTypes.Label","总的角色类型数"},
{"eOT.TotalNoOfSpecialities.Label","总的科室"},
{"eOT.TotalNoOfStatus.Label","总的状态"},
{"eOT.TotalNoOfSurgeryTypes.Label","手术类型"},
{"eOT.TotalNoOfSwabTemplate.Label","删除模版"},
{"eOT.TotalNoOfSwabTemplateItems.Label","删除模版项目"},
{"eOT.TotalNoOfUsers.Label","所有用户"},
{"eOT.TotalNoOfUsualOccurences.Label","所有经常发生的事件"},
{"eOT.TotalNoOfWoundTypes.Label","创伤类型"},
{"eOT.TotalSurgeonwiseBookings.Label","预订手术数"},
{"eOT.TotalTheatrewiseBookings.Label","预订手术室数"},


};
}
