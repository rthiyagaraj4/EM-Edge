/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.dobj;

import java.io.Serializable;
import java.util.*;

// Referenced classes of package com.iba.ehis.dobj:
//            PrEncounterId, AmSpeciality, AeInjuryCategory, AmContactReason, 
//            AmPatientClass, AmPractitioner, MpPatient, AmAmbulatoryStatus

public class PrEncounter
    implements Serializable
{

    public PrEncounter()
    {
        aeTraumaPrimarySurveies = new HashSet(0);
        opLastVisitForServices = new HashSet(0);
        fmEncounterVolumeLinks = new HashSet(0);
        phMednAdmins = new HashSet(0);
        oaApptDelTrs = new HashSet(0);
        prDiagnosisesForPrDiagnosisF2 = new HashSet(0);
        ipOpenEncounters = new HashSet(0);
        prDiagnosisStatuses = new HashSet(0);
        prWaitListsForPrWaitListF12 = new HashSet(0);
        cpPatCarePlanRevisions = new HashSet(0);
        fmDeficiencyHdrs = new HashSet(0);
        dsEpsdMealPlanHdrAudits = new HashSet(0);
        aePatGcsScores = new HashSet(0);
        ipPatientLastEncounters = new HashSet(0);
        prEncounterOtherDetails = new HashSet(0);
        aePatMovementLogs = new HashSet(0);
        opPatientTrackingLocns = new HashSet(0);
        prAllergiesForPrAllergyF3 = new HashSet(0);
        aePatEmergencyDetails = new HashSet(0);
        opPatientQueues = new HashSet(0);
        cpPatCarePlansForCpPatCarePlanF3 = new HashSet(0);
        ipBedBookings = new HashSet(0);
        ipAdtTrnAuditLogs = new HashSet(0);
        dsEpsdMealPlanHdrAttnds = new HashSet(0);
        opCurrentPatients = new HashSet(0);
        ipDischargeAdvices = new HashSet(0);
        prEncounterPracts = new HashSet(0);
        aeCurrentPatients = new HashSet(0);
        oaAppts = new HashSet(0);
        ipBedClassRequests = new HashSet(0);
        prDiagnosisesForPrDiagnosisF7 = new HashSet(0);
        phPatientVaccProfiles = new HashSet(0);
        phMednAdminDtls = new HashSet(0);
        prSickLeaveRegisters = new HashSet(0);
        aePatTriages = new HashSet(0);
        aeTraumaSecondarySurveies = new HashSet(0);
        prAllergiesForPrAllergyF4 = new HashSet(0);
        ipTransferRequests = new HashSet(0);
        dsEpsdDietProfileHdrs = new HashSet(0);
        mrDiagRecodings = new HashSet(0);
        cpPatCarePlansForCpPatCarePlanF8 = new HashSet(0);
        qaQindEncounterTrns = new HashSet(0);
        prWaitListsForPrWaitListF10 = new HashSet(0);
        mrDeathRegisterHdrs = new HashSet(0);
        dsEpsdMealPlanHdrs = new HashSet(0);
        aePatRelatedContactses = new HashSet(0);
        ipDischargeChecklists = new HashSet(0);
        caEncntrChiefComplaints = new HashSet(0);
        cpPatAssesses = new HashSet(0);
        ipDischargeSummaries = new HashSet(0);
        mrReportRequestDtls = new HashSet(0);
        ipNursingUnitBeds = new HashSet(0);
        prWaitListsForPrWaitListF11 = new HashSet(0);
    }

    public PrEncounter(PrEncounterId id, AmPatientClass amPatientClass, MpPatient mpPatient, Date visitAdmDateTime, String visitAdmTypeFacilityId, String visitAdmType, String visitAdmTypeInd, 
            String assignCareLocnType, String assignCareLocnCode, String apptCaseYn, String bookingCaseYn, String ancillaryYn, String backdatedYn, String aeEpisodeYn, 
            String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, 
            String modifiedFacilityId, String mlcYn, String osccYn, String broughtDeadYn, String disasterYn, String medicalYn, String surgicalYn, 
            String pmYn, String traumaYn, String highRiskYn)
    {
        aeTraumaPrimarySurveies = new HashSet(0);
        opLastVisitForServices = new HashSet(0);
        fmEncounterVolumeLinks = new HashSet(0);
        phMednAdmins = new HashSet(0);
        oaApptDelTrs = new HashSet(0);
        prDiagnosisesForPrDiagnosisF2 = new HashSet(0);
        ipOpenEncounters = new HashSet(0);
        prDiagnosisStatuses = new HashSet(0);
        prWaitListsForPrWaitListF12 = new HashSet(0);
        cpPatCarePlanRevisions = new HashSet(0);
        fmDeficiencyHdrs = new HashSet(0);
        dsEpsdMealPlanHdrAudits = new HashSet(0);
        aePatGcsScores = new HashSet(0);
        ipPatientLastEncounters = new HashSet(0);
        prEncounterOtherDetails = new HashSet(0);
        aePatMovementLogs = new HashSet(0);
        opPatientTrackingLocns = new HashSet(0);
        prAllergiesForPrAllergyF3 = new HashSet(0);
        aePatEmergencyDetails = new HashSet(0);
        opPatientQueues = new HashSet(0);
        cpPatCarePlansForCpPatCarePlanF3 = new HashSet(0);
        ipBedBookings = new HashSet(0);
        ipAdtTrnAuditLogs = new HashSet(0);
        dsEpsdMealPlanHdrAttnds = new HashSet(0);
        opCurrentPatients = new HashSet(0);
        ipDischargeAdvices = new HashSet(0);
        prEncounterPracts = new HashSet(0);
        aeCurrentPatients = new HashSet(0);
        oaAppts = new HashSet(0);
        ipBedClassRequests = new HashSet(0);
        prDiagnosisesForPrDiagnosisF7 = new HashSet(0);
        phPatientVaccProfiles = new HashSet(0);
        phMednAdminDtls = new HashSet(0);
        prSickLeaveRegisters = new HashSet(0);
        aePatTriages = new HashSet(0);
        aeTraumaSecondarySurveies = new HashSet(0);
        prAllergiesForPrAllergyF4 = new HashSet(0);
        ipTransferRequests = new HashSet(0);
        dsEpsdDietProfileHdrs = new HashSet(0);
        mrDiagRecodings = new HashSet(0);
        cpPatCarePlansForCpPatCarePlanF8 = new HashSet(0);
        qaQindEncounterTrns = new HashSet(0);
        prWaitListsForPrWaitListF10 = new HashSet(0);
        mrDeathRegisterHdrs = new HashSet(0);
        dsEpsdMealPlanHdrs = new HashSet(0);
        aePatRelatedContactses = new HashSet(0);
        ipDischargeChecklists = new HashSet(0);
        caEncntrChiefComplaints = new HashSet(0);
        cpPatAssesses = new HashSet(0);
        ipDischargeSummaries = new HashSet(0);
        mrReportRequestDtls = new HashSet(0);
        ipNursingUnitBeds = new HashSet(0);
        prWaitListsForPrWaitListF11 = new HashSet(0);
        this.id = id;
        this.amPatientClass = amPatientClass;
        this.mpPatient = mpPatient;
        this.visitAdmDateTime = visitAdmDateTime;
        this.visitAdmTypeFacilityId = visitAdmTypeFacilityId;
        this.visitAdmType = visitAdmType;
        this.visitAdmTypeInd = visitAdmTypeInd;
        this.assignCareLocnType = assignCareLocnType;
        this.assignCareLocnCode = assignCareLocnCode;
        this.apptCaseYn = apptCaseYn;
        this.bookingCaseYn = bookingCaseYn;
        this.ancillaryYn = ancillaryYn;
        this.backdatedYn = backdatedYn;
        this.aeEpisodeYn = aeEpisodeYn;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.mlcYn = mlcYn;
        this.osccYn = osccYn;
        this.broughtDeadYn = broughtDeadYn;
        this.disasterYn = disasterYn;
        this.medicalYn = medicalYn;
        this.surgicalYn = surgicalYn;
        this.pmYn = pmYn;
        this.traumaYn = traumaYn;
        this.highRiskYn = highRiskYn;
    }

    public PrEncounter(PrEncounterId id, AmSpeciality amSpeciality, AeInjuryCategory aeInjuryCategory, AmContactReason amContactReason, AmPatientClass amPatientClass, AmPractitioner amPractitioner, MpPatient mpPatient, 
            AmAmbulatoryStatus amAmbulatoryStatus, Date visitAdmDateTime, String visitAdmTypeFacilityId, String visitAdmType, String visitAdmTypeInd, String assignCareLocnType, String assignCareLocnCode, 
            String assignRoomType, String assignRoomNum, String assignBedNum, String attendPractitionerId, String referralId, String apptCaseYn, String apptId, 
            String bookingCaseYn, String bookingRefNo, String serviceCode, String subserviceCode, String ancillaryYn, String patientType, String circumstanceOfInjuryCode, 
            String courtesyCode, String chiefComplaint, String patientCondition, String newOpEpisodeYn, Long episodeId, Long opEpisodeVisitNum, String admitPractitionerId, 
            Date dischargeDateTime, String dispositionType, String recallYn, Date recallDate, String dispFacilityId, String dispReferralId, String mdsCompleteYn, 
            Date fiscalYear, Long fiscalPeriod, String shiftId, String backdatedYn, String visitStatus, Date visitStatusSetOnDate, String visitStatusSetByUser, 
            String visitStatusSetReason, String adtStatus, Date adtStatusSetOnDate, String adtStatusSetByUser, String adtStatusSetReason, String recallReason, String referredYn, 
            String prnVisitYn, Date prnVisitBefore, String aeEpisodeYn, String reviseReasonCode, String cancelReasonCode, String teamId, String creditAuthUserId, 
            String creditAuthRemarks, Long admissionNo, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, 
            Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, Date deceasedDateTime, String securityLevel, String protectionInd, String assignBedClassCode, 
            String assignBedTypeCode, Date bedAllocationDateTime, String closedById, Date closedDate, String dcUnitCode, String dischPractitionerId, Date informedDateTime, 
            String informedName, String informedTo, String ipLeaveStatus, Date leaveExpiryDateTime, String markedById, Date markedDate, String mlcYn, 
            String osccYn, String othAdtStatus, Long patientPriorityNo, String patCurrLocnCode, String patCurrLocnType, Date patTrnTime, String polId, 
            String polRepNo, String polStnId, Date markArrivalDateTime, String priorityZone, String treatmentAreaCode, String broughtDeadYn, String disasterYn, 
            String disasterTownCode, String prevAssignCareLocnCode, String prevAssignRoomNum, String prevSubserviceCode, String prevAttendPractitionerId, String prevVisitAdmType, String prevVisitAdmTypeInd, 
            Long invitationNo, String otherResourceId, String movementReasonCode, String queueId, String otherResClass, String disasterTypeCode, String medicalYn, 
            String surgicalYn, Date bodyReleaseDateTime, String pmYn, String fileNo, String traumaYn, String mechInjurySubcatgCode, String highRiskYn, 
            Set aeTraumaPrimarySurveies, Set opLastVisitForServices, Set fmEncounterVolumeLinks, Set phMednAdmins, Set oaApptDelTrs, Set prDiagnosisesForPrDiagnosisF2, Set ipOpenEncounters, 
            Set prDiagnosisStatuses, Set prWaitListsForPrWaitListF12, Set cpPatCarePlanRevisions, Set fmDeficiencyHdrs, Set dsEpsdMealPlanHdrAudits, Set aePatGcsScores, Set ipPatientLastEncounters, 
            Set prEncounterOtherDetails, Set aePatMovementLogs, Set opPatientTrackingLocns, Set prAllergiesForPrAllergyF3, Set aePatEmergencyDetails, Set opPatientQueues, Set cpPatCarePlansForCpPatCarePlanF3, 
            Set ipBedBookings, Set ipAdtTrnAuditLogs, Set dsEpsdMealPlanHdrAttnds, Set opCurrentPatients, Set ipDischargeAdvices, Set prEncounterPracts, Set aeCurrentPatients, 
            Set oaAppts, Set ipBedClassRequests, Set prDiagnosisesForPrDiagnosisF7, Set phPatientVaccProfiles, Set phMednAdminDtls, Set prSickLeaveRegisters, Set aePatTriages, 
            Set aeTraumaSecondarySurveies, Set prAllergiesForPrAllergyF4, Set ipTransferRequests, Set dsEpsdDietProfileHdrs, Set mrDiagRecodings, Set cpPatCarePlansForCpPatCarePlanF8, Set qaQindEncounterTrns, 
            Set prWaitListsForPrWaitListF10, Set mrDeathRegisterHdrs, Set dsEpsdMealPlanHdrs, Set aePatRelatedContactses, Set ipDischargeChecklists, Set caEncntrChiefComplaints, Set cpPatAssesses, 
            Set ipDischargeSummaries, Set mrReportRequestDtls, Set ipNursingUnitBeds, Set prWaitListsForPrWaitListF11)
    {
        this.aeTraumaPrimarySurveies = new HashSet(0);
        this.opLastVisitForServices = new HashSet(0);
        this.fmEncounterVolumeLinks = new HashSet(0);
        this.phMednAdmins = new HashSet(0);
        this.oaApptDelTrs = new HashSet(0);
        this.prDiagnosisesForPrDiagnosisF2 = new HashSet(0);
        this.ipOpenEncounters = new HashSet(0);
        this.prDiagnosisStatuses = new HashSet(0);
        this.prWaitListsForPrWaitListF12 = new HashSet(0);
        this.cpPatCarePlanRevisions = new HashSet(0);
        this.fmDeficiencyHdrs = new HashSet(0);
        this.dsEpsdMealPlanHdrAudits = new HashSet(0);
        this.aePatGcsScores = new HashSet(0);
        this.ipPatientLastEncounters = new HashSet(0);
        this.prEncounterOtherDetails = new HashSet(0);
        this.aePatMovementLogs = new HashSet(0);
        this.opPatientTrackingLocns = new HashSet(0);
        this.prAllergiesForPrAllergyF3 = new HashSet(0);
        this.aePatEmergencyDetails = new HashSet(0);
        this.opPatientQueues = new HashSet(0);
        this.cpPatCarePlansForCpPatCarePlanF3 = new HashSet(0);
        this.ipBedBookings = new HashSet(0);
        this.ipAdtTrnAuditLogs = new HashSet(0);
        this.dsEpsdMealPlanHdrAttnds = new HashSet(0);
        this.opCurrentPatients = new HashSet(0);
        this.ipDischargeAdvices = new HashSet(0);
        this.prEncounterPracts = new HashSet(0);
        this.aeCurrentPatients = new HashSet(0);
        this.oaAppts = new HashSet(0);
        this.ipBedClassRequests = new HashSet(0);
        this.prDiagnosisesForPrDiagnosisF7 = new HashSet(0);
        this.phPatientVaccProfiles = new HashSet(0);
        this.phMednAdminDtls = new HashSet(0);
        this.prSickLeaveRegisters = new HashSet(0);
        this.aePatTriages = new HashSet(0);
        this.aeTraumaSecondarySurveies = new HashSet(0);
        this.prAllergiesForPrAllergyF4 = new HashSet(0);
        this.ipTransferRequests = new HashSet(0);
        this.dsEpsdDietProfileHdrs = new HashSet(0);
        this.mrDiagRecodings = new HashSet(0);
        this.cpPatCarePlansForCpPatCarePlanF8 = new HashSet(0);
        this.qaQindEncounterTrns = new HashSet(0);
        this.prWaitListsForPrWaitListF10 = new HashSet(0);
        this.mrDeathRegisterHdrs = new HashSet(0);
        this.dsEpsdMealPlanHdrs = new HashSet(0);
        this.aePatRelatedContactses = new HashSet(0);
        this.ipDischargeChecklists = new HashSet(0);
        this.caEncntrChiefComplaints = new HashSet(0);
        this.cpPatAssesses = new HashSet(0);
        this.ipDischargeSummaries = new HashSet(0);
        this.mrReportRequestDtls = new HashSet(0);
        this.ipNursingUnitBeds = new HashSet(0);
        this.prWaitListsForPrWaitListF11 = new HashSet(0);
        this.id = id;
        this.amSpeciality = amSpeciality;
        this.aeInjuryCategory = aeInjuryCategory;
        this.amContactReason = amContactReason;
        this.amPatientClass = amPatientClass;
        this.amPractitioner = amPractitioner;
        this.mpPatient = mpPatient;
        this.amAmbulatoryStatus = amAmbulatoryStatus;
        this.visitAdmDateTime = visitAdmDateTime;
        this.visitAdmTypeFacilityId = visitAdmTypeFacilityId;
        this.visitAdmType = visitAdmType;
        this.visitAdmTypeInd = visitAdmTypeInd;
        this.assignCareLocnType = assignCareLocnType;
        this.assignCareLocnCode = assignCareLocnCode;
        this.assignRoomType = assignRoomType;
        this.assignRoomNum = assignRoomNum;
        this.assignBedNum = assignBedNum;
        this.attendPractitionerId = attendPractitionerId;
        this.referralId = referralId;
        this.apptCaseYn = apptCaseYn;
        this.apptId = apptId;
        this.bookingCaseYn = bookingCaseYn;
        this.bookingRefNo = bookingRefNo;
        this.serviceCode = serviceCode;
        this.subserviceCode = subserviceCode;
        this.ancillaryYn = ancillaryYn;
        this.patientType = patientType;
        this.circumstanceOfInjuryCode = circumstanceOfInjuryCode;
        this.courtesyCode = courtesyCode;
        this.chiefComplaint = chiefComplaint;
        this.patientCondition = patientCondition;
        this.newOpEpisodeYn = newOpEpisodeYn;
        this.episodeId = episodeId;
        this.opEpisodeVisitNum = opEpisodeVisitNum;
        this.admitPractitionerId = admitPractitionerId;
        this.dischargeDateTime = dischargeDateTime;
        this.dispositionType = dispositionType;
        this.recallYn = recallYn;
        this.recallDate = recallDate;
        this.dispFacilityId = dispFacilityId;
        this.dispReferralId = dispReferralId;
        this.mdsCompleteYn = mdsCompleteYn;
        this.fiscalYear = fiscalYear;
        this.fiscalPeriod = fiscalPeriod;
        this.shiftId = shiftId;
        this.backdatedYn = backdatedYn;
        this.visitStatus = visitStatus;
        this.visitStatusSetOnDate = visitStatusSetOnDate;
        this.visitStatusSetByUser = visitStatusSetByUser;
        this.visitStatusSetReason = visitStatusSetReason;
        this.adtStatus = adtStatus;
        this.adtStatusSetOnDate = adtStatusSetOnDate;
        this.adtStatusSetByUser = adtStatusSetByUser;
        this.adtStatusSetReason = adtStatusSetReason;
        this.recallReason = recallReason;
        this.referredYn = referredYn;
        this.prnVisitYn = prnVisitYn;
        this.prnVisitBefore = prnVisitBefore;
        this.aeEpisodeYn = aeEpisodeYn;
        this.reviseReasonCode = reviseReasonCode;
        this.cancelReasonCode = cancelReasonCode;
        this.teamId = teamId;
        this.creditAuthUserId = creditAuthUserId;
        this.creditAuthRemarks = creditAuthRemarks;
        this.admissionNo = admissionNo;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.deceasedDateTime = deceasedDateTime;
        this.securityLevel = securityLevel;
        this.protectionInd = protectionInd;
        this.assignBedClassCode = assignBedClassCode;
        this.assignBedTypeCode = assignBedTypeCode;
        this.bedAllocationDateTime = bedAllocationDateTime;
        this.closedById = closedById;
        this.closedDate = closedDate;
        this.dcUnitCode = dcUnitCode;
        this.dischPractitionerId = dischPractitionerId;
        this.informedDateTime = informedDateTime;
        this.informedName = informedName;
        this.informedTo = informedTo;
        this.ipLeaveStatus = ipLeaveStatus;
        this.leaveExpiryDateTime = leaveExpiryDateTime;
        this.markedById = markedById;
        this.markedDate = markedDate;
        this.mlcYn = mlcYn;
        this.osccYn = osccYn;
        this.othAdtStatus = othAdtStatus;
        this.patientPriorityNo = patientPriorityNo;
        this.patCurrLocnCode = patCurrLocnCode;
        this.patCurrLocnType = patCurrLocnType;
        this.patTrnTime = patTrnTime;
        this.polId = polId;
        this.polRepNo = polRepNo;
        this.polStnId = polStnId;
        this.markArrivalDateTime = markArrivalDateTime;
        this.priorityZone = priorityZone;
        this.treatmentAreaCode = treatmentAreaCode;
        this.broughtDeadYn = broughtDeadYn;
        this.disasterYn = disasterYn;
        this.disasterTownCode = disasterTownCode;
        this.prevAssignCareLocnCode = prevAssignCareLocnCode;
        this.prevAssignRoomNum = prevAssignRoomNum;
        this.prevSubserviceCode = prevSubserviceCode;
        this.prevAttendPractitionerId = prevAttendPractitionerId;
        this.prevVisitAdmType = prevVisitAdmType;
        this.prevVisitAdmTypeInd = prevVisitAdmTypeInd;
        this.invitationNo = invitationNo;
        this.otherResourceId = otherResourceId;
        this.movementReasonCode = movementReasonCode;
        this.queueId = queueId;
        this.otherResClass = otherResClass;
        this.disasterTypeCode = disasterTypeCode;
        this.medicalYn = medicalYn;
        this.surgicalYn = surgicalYn;
        this.bodyReleaseDateTime = bodyReleaseDateTime;
        this.pmYn = pmYn;
        this.fileNo = fileNo;
        this.traumaYn = traumaYn;
        this.mechInjurySubcatgCode = mechInjurySubcatgCode;
        this.highRiskYn = highRiskYn;
        this.aeTraumaPrimarySurveies = aeTraumaPrimarySurveies;
        this.opLastVisitForServices = opLastVisitForServices;
        this.fmEncounterVolumeLinks = fmEncounterVolumeLinks;
        this.phMednAdmins = phMednAdmins;
        this.oaApptDelTrs = oaApptDelTrs;
        this.prDiagnosisesForPrDiagnosisF2 = prDiagnosisesForPrDiagnosisF2;
        this.ipOpenEncounters = ipOpenEncounters;
        this.prDiagnosisStatuses = prDiagnosisStatuses;
        this.prWaitListsForPrWaitListF12 = prWaitListsForPrWaitListF12;
        this.cpPatCarePlanRevisions = cpPatCarePlanRevisions;
        this.fmDeficiencyHdrs = fmDeficiencyHdrs;
        this.dsEpsdMealPlanHdrAudits = dsEpsdMealPlanHdrAudits;
        this.aePatGcsScores = aePatGcsScores;
        this.ipPatientLastEncounters = ipPatientLastEncounters;
        this.prEncounterOtherDetails = prEncounterOtherDetails;
        this.aePatMovementLogs = aePatMovementLogs;
        this.opPatientTrackingLocns = opPatientTrackingLocns;
        this.prAllergiesForPrAllergyF3 = prAllergiesForPrAllergyF3;
        this.aePatEmergencyDetails = aePatEmergencyDetails;
        this.opPatientQueues = opPatientQueues;
        this.cpPatCarePlansForCpPatCarePlanF3 = cpPatCarePlansForCpPatCarePlanF3;
        this.ipBedBookings = ipBedBookings;
        this.ipAdtTrnAuditLogs = ipAdtTrnAuditLogs;
        this.dsEpsdMealPlanHdrAttnds = dsEpsdMealPlanHdrAttnds;
        this.opCurrentPatients = opCurrentPatients;
        this.ipDischargeAdvices = ipDischargeAdvices;
        this.prEncounterPracts = prEncounterPracts;
        this.aeCurrentPatients = aeCurrentPatients;
        this.oaAppts = oaAppts;
        this.ipBedClassRequests = ipBedClassRequests;
        this.prDiagnosisesForPrDiagnosisF7 = prDiagnosisesForPrDiagnosisF7;
        this.phPatientVaccProfiles = phPatientVaccProfiles;
        this.phMednAdminDtls = phMednAdminDtls;
        this.prSickLeaveRegisters = prSickLeaveRegisters;
        this.aePatTriages = aePatTriages;
        this.aeTraumaSecondarySurveies = aeTraumaSecondarySurveies;
        this.prAllergiesForPrAllergyF4 = prAllergiesForPrAllergyF4;
        this.ipTransferRequests = ipTransferRequests;
        this.dsEpsdDietProfileHdrs = dsEpsdDietProfileHdrs;
        this.mrDiagRecodings = mrDiagRecodings;
        this.cpPatCarePlansForCpPatCarePlanF8 = cpPatCarePlansForCpPatCarePlanF8;
        this.qaQindEncounterTrns = qaQindEncounterTrns;
        this.prWaitListsForPrWaitListF10 = prWaitListsForPrWaitListF10;
        this.mrDeathRegisterHdrs = mrDeathRegisterHdrs;
        this.dsEpsdMealPlanHdrs = dsEpsdMealPlanHdrs;
        this.aePatRelatedContactses = aePatRelatedContactses;
        this.ipDischargeChecklists = ipDischargeChecklists;
        this.caEncntrChiefComplaints = caEncntrChiefComplaints;
        this.cpPatAssesses = cpPatAssesses;
        this.ipDischargeSummaries = ipDischargeSummaries;
        this.mrReportRequestDtls = mrReportRequestDtls;
        this.ipNursingUnitBeds = ipNursingUnitBeds;
        this.prWaitListsForPrWaitListF11 = prWaitListsForPrWaitListF11;
    }

    public PrEncounterId getId()
    {
        return id;
    }

    public void setId(PrEncounterId id)
    {
        this.id = id;
    }

    public AmSpeciality getAmSpeciality()
    {
        return amSpeciality;
    }

    public void setAmSpeciality(AmSpeciality amSpeciality)
    {
        this.amSpeciality = amSpeciality;
    }

    public AeInjuryCategory getAeInjuryCategory()
    {
        return aeInjuryCategory;
    }

    public void setAeInjuryCategory(AeInjuryCategory aeInjuryCategory)
    {
        this.aeInjuryCategory = aeInjuryCategory;
    }

    public AmContactReason getAmContactReason()
    {
        return amContactReason;
    }

    public void setAmContactReason(AmContactReason amContactReason)
    {
        this.amContactReason = amContactReason;
    }

    public AmPatientClass getAmPatientClass()
    {
        return amPatientClass;
    }

    public void setAmPatientClass(AmPatientClass amPatientClass)
    {
        this.amPatientClass = amPatientClass;
    }

    public AmPractitioner getAmPractitioner()
    {
        return amPractitioner;
    }

    public void setAmPractitioner(AmPractitioner amPractitioner)
    {
        this.amPractitioner = amPractitioner;
    }

    public MpPatient getMpPatient()
    {
        return mpPatient;
    }

    public void setMpPatient(MpPatient mpPatient)
    {
        this.mpPatient = mpPatient;
    }

    public AmAmbulatoryStatus getAmAmbulatoryStatus()
    {
        return amAmbulatoryStatus;
    }

    public void setAmAmbulatoryStatus(AmAmbulatoryStatus amAmbulatoryStatus)
    {
        this.amAmbulatoryStatus = amAmbulatoryStatus;
    }

    public Date getVisitAdmDateTime()
    {
        return visitAdmDateTime;
    }

    public void setVisitAdmDateTime(Date visitAdmDateTime)
    {
        this.visitAdmDateTime = visitAdmDateTime;
    }

    public String getVisitAdmTypeFacilityId()
    {
        return visitAdmTypeFacilityId;
    }

    public void setVisitAdmTypeFacilityId(String visitAdmTypeFacilityId)
    {
        this.visitAdmTypeFacilityId = visitAdmTypeFacilityId;
    }

    public String getVisitAdmType()
    {
        return visitAdmType;
    }

    public void setVisitAdmType(String visitAdmType)
    {
        this.visitAdmType = visitAdmType;
    }

    public String getVisitAdmTypeInd()
    {
        return visitAdmTypeInd;
    }

    public void setVisitAdmTypeInd(String visitAdmTypeInd)
    {
        this.visitAdmTypeInd = visitAdmTypeInd;
    }

    public String getAssignCareLocnType()
    {
        return assignCareLocnType;
    }

    public void setAssignCareLocnType(String assignCareLocnType)
    {
        this.assignCareLocnType = assignCareLocnType;
    }

    public String getAssignCareLocnCode()
    {
        return assignCareLocnCode;
    }

    public void setAssignCareLocnCode(String assignCareLocnCode)
    {
        this.assignCareLocnCode = assignCareLocnCode;
    }

    public String getAssignRoomType()
    {
        return assignRoomType;
    }

    public void setAssignRoomType(String assignRoomType)
    {
        this.assignRoomType = assignRoomType;
    }

    public String getAssignRoomNum()
    {
        return assignRoomNum;
    }

    public void setAssignRoomNum(String assignRoomNum)
    {
        this.assignRoomNum = assignRoomNum;
    }

    public String getAssignBedNum()
    {
        return assignBedNum;
    }

    public void setAssignBedNum(String assignBedNum)
    {
        this.assignBedNum = assignBedNum;
    }

    public String getAttendPractitionerId()
    {
        return attendPractitionerId;
    }

    public void setAttendPractitionerId(String attendPractitionerId)
    {
        this.attendPractitionerId = attendPractitionerId;
    }

    public String getReferralId()
    {
        return referralId;
    }

    public void setReferralId(String referralId)
    {
        this.referralId = referralId;
    }

    public String getApptCaseYn()
    {
        return apptCaseYn;
    }

    public void setApptCaseYn(String apptCaseYn)
    {
        this.apptCaseYn = apptCaseYn;
    }

    public String getApptId()
    {
        return apptId;
    }

    public void setApptId(String apptId)
    {
        this.apptId = apptId;
    }

    public String getBookingCaseYn()
    {
        return bookingCaseYn;
    }

    public void setBookingCaseYn(String bookingCaseYn)
    {
        this.bookingCaseYn = bookingCaseYn;
    }

    public String getBookingRefNo()
    {
        return bookingRefNo;
    }

    public void setBookingRefNo(String bookingRefNo)
    {
        this.bookingRefNo = bookingRefNo;
    }

    public String getServiceCode()
    {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode)
    {
        this.serviceCode = serviceCode;
    }

    public String getSubserviceCode()
    {
        return subserviceCode;
    }

    public void setSubserviceCode(String subserviceCode)
    {
        this.subserviceCode = subserviceCode;
    }

    public String getAncillaryYn()
    {
        return ancillaryYn;
    }

    public void setAncillaryYn(String ancillaryYn)
    {
        this.ancillaryYn = ancillaryYn;
    }

    public String getPatientType()
    {
        return patientType;
    }

    public void setPatientType(String patientType)
    {
        this.patientType = patientType;
    }

    public String getCircumstanceOfInjuryCode()
    {
        return circumstanceOfInjuryCode;
    }

    public void setCircumstanceOfInjuryCode(String circumstanceOfInjuryCode)
    {
        this.circumstanceOfInjuryCode = circumstanceOfInjuryCode;
    }

    public String getCourtesyCode()
    {
        return courtesyCode;
    }

    public void setCourtesyCode(String courtesyCode)
    {
        this.courtesyCode = courtesyCode;
    }

    public String getChiefComplaint()
    {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint)
    {
        this.chiefComplaint = chiefComplaint;
    }

    public String getPatientCondition()
    {
        return patientCondition;
    }

    public void setPatientCondition(String patientCondition)
    {
        this.patientCondition = patientCondition;
    }

    public String getNewOpEpisodeYn()
    {
        return newOpEpisodeYn;
    }

    public void setNewOpEpisodeYn(String newOpEpisodeYn)
    {
        this.newOpEpisodeYn = newOpEpisodeYn;
    }

    public Long getEpisodeId()
    {
        return episodeId;
    }

    public void setEpisodeId(Long episodeId)
    {
        this.episodeId = episodeId;
    }

    public Long getOpEpisodeVisitNum()
    {
        return opEpisodeVisitNum;
    }

    public void setOpEpisodeVisitNum(Long opEpisodeVisitNum)
    {
        this.opEpisodeVisitNum = opEpisodeVisitNum;
    }

    public String getAdmitPractitionerId()
    {
        return admitPractitionerId;
    }

    public void setAdmitPractitionerId(String admitPractitionerId)
    {
        this.admitPractitionerId = admitPractitionerId;
    }

    public Date getDischargeDateTime()
    {
        return dischargeDateTime;
    }

    public void setDischargeDateTime(Date dischargeDateTime)
    {
        this.dischargeDateTime = dischargeDateTime;
    }

    public String getDispositionType()
    {
        return dispositionType;
    }

    public void setDispositionType(String dispositionType)
    {
        this.dispositionType = dispositionType;
    }

    public String getRecallYn()
    {
        return recallYn;
    }

    public void setRecallYn(String recallYn)
    {
        this.recallYn = recallYn;
    }

    public Date getRecallDate()
    {
        return recallDate;
    }

    public void setRecallDate(Date recallDate)
    {
        this.recallDate = recallDate;
    }

    public String getDispFacilityId()
    {
        return dispFacilityId;
    }

    public void setDispFacilityId(String dispFacilityId)
    {
        this.dispFacilityId = dispFacilityId;
    }

    public String getDispReferralId()
    {
        return dispReferralId;
    }

    public void setDispReferralId(String dispReferralId)
    {
        this.dispReferralId = dispReferralId;
    }

    public String getMdsCompleteYn()
    {
        return mdsCompleteYn;
    }

    public void setMdsCompleteYn(String mdsCompleteYn)
    {
        this.mdsCompleteYn = mdsCompleteYn;
    }

    public Date getFiscalYear()
    {
        return fiscalYear;
    }

    public void setFiscalYear(Date fiscalYear)
    {
        this.fiscalYear = fiscalYear;
    }

    public Long getFiscalPeriod()
    {
        return fiscalPeriod;
    }

    public void setFiscalPeriod(Long fiscalPeriod)
    {
        this.fiscalPeriod = fiscalPeriod;
    }

    public String getShiftId()
    {
        return shiftId;
    }

    public void setShiftId(String shiftId)
    {
        this.shiftId = shiftId;
    }

    public String getBackdatedYn()
    {
        return backdatedYn;
    }

    public void setBackdatedYn(String backdatedYn)
    {
        this.backdatedYn = backdatedYn;
    }

    public String getVisitStatus()
    {
        return visitStatus;
    }

    public void setVisitStatus(String visitStatus)
    {
        this.visitStatus = visitStatus;
    }

    public Date getVisitStatusSetOnDate()
    {
        return visitStatusSetOnDate;
    }

    public void setVisitStatusSetOnDate(Date visitStatusSetOnDate)
    {
        this.visitStatusSetOnDate = visitStatusSetOnDate;
    }

    public String getVisitStatusSetByUser()
    {
        return visitStatusSetByUser;
    }

    public void setVisitStatusSetByUser(String visitStatusSetByUser)
    {
        this.visitStatusSetByUser = visitStatusSetByUser;
    }

    public String getVisitStatusSetReason()
    {
        return visitStatusSetReason;
    }

    public void setVisitStatusSetReason(String visitStatusSetReason)
    {
        this.visitStatusSetReason = visitStatusSetReason;
    }

    public String getAdtStatus()
    {
        return adtStatus;
    }

    public void setAdtStatus(String adtStatus)
    {
        this.adtStatus = adtStatus;
    }

    public Date getAdtStatusSetOnDate()
    {
        return adtStatusSetOnDate;
    }

    public void setAdtStatusSetOnDate(Date adtStatusSetOnDate)
    {
        this.adtStatusSetOnDate = adtStatusSetOnDate;
    }

    public String getAdtStatusSetByUser()
    {
        return adtStatusSetByUser;
    }

    public void setAdtStatusSetByUser(String adtStatusSetByUser)
    {
        this.adtStatusSetByUser = adtStatusSetByUser;
    }

    public String getAdtStatusSetReason()
    {
        return adtStatusSetReason;
    }

    public void setAdtStatusSetReason(String adtStatusSetReason)
    {
        this.adtStatusSetReason = adtStatusSetReason;
    }

    public String getRecallReason()
    {
        return recallReason;
    }

    public void setRecallReason(String recallReason)
    {
        this.recallReason = recallReason;
    }

    public String getReferredYn()
    {
        return referredYn;
    }

    public void setReferredYn(String referredYn)
    {
        this.referredYn = referredYn;
    }

    public String getPrnVisitYn()
    {
        return prnVisitYn;
    }

    public void setPrnVisitYn(String prnVisitYn)
    {
        this.prnVisitYn = prnVisitYn;
    }

    public Date getPrnVisitBefore()
    {
        return prnVisitBefore;
    }

    public void setPrnVisitBefore(Date prnVisitBefore)
    {
        this.prnVisitBefore = prnVisitBefore;
    }

    public String getAeEpisodeYn()
    {
        return aeEpisodeYn;
    }

    public void setAeEpisodeYn(String aeEpisodeYn)
    {
        this.aeEpisodeYn = aeEpisodeYn;
    }

    public String getReviseReasonCode()
    {
        return reviseReasonCode;
    }

    public void setReviseReasonCode(String reviseReasonCode)
    {
        this.reviseReasonCode = reviseReasonCode;
    }

    public String getCancelReasonCode()
    {
        return cancelReasonCode;
    }

    public void setCancelReasonCode(String cancelReasonCode)
    {
        this.cancelReasonCode = cancelReasonCode;
    }

    public String getTeamId()
    {
        return teamId;
    }

    public void setTeamId(String teamId)
    {
        this.teamId = teamId;
    }

    public String getCreditAuthUserId()
    {
        return creditAuthUserId;
    }

    public void setCreditAuthUserId(String creditAuthUserId)
    {
        this.creditAuthUserId = creditAuthUserId;
    }

    public String getCreditAuthRemarks()
    {
        return creditAuthRemarks;
    }

    public void setCreditAuthRemarks(String creditAuthRemarks)
    {
        this.creditAuthRemarks = creditAuthRemarks;
    }

    public Long getAdmissionNo()
    {
        return admissionNo;
    }

    public void setAdmissionNo(Long admissionNo)
    {
        this.admissionNo = admissionNo;
    }

    public String getAddedById()
    {
        return addedById;
    }

    public void setAddedById(String addedById)
    {
        this.addedById = addedById;
    }

    public Date getAddedDate()
    {
        return addedDate;
    }

    public void setAddedDate(Date addedDate)
    {
        this.addedDate = addedDate;
    }

    public String getAddedAtWsNo()
    {
        return addedAtWsNo;
    }

    public void setAddedAtWsNo(String addedAtWsNo)
    {
        this.addedAtWsNo = addedAtWsNo;
    }

    public String getAddedFacilityId()
    {
        return addedFacilityId;
    }

    public void setAddedFacilityId(String addedFacilityId)
    {
        this.addedFacilityId = addedFacilityId;
    }

    public String getModifiedById()
    {
        return modifiedById;
    }

    public void setModifiedById(String modifiedById)
    {
        this.modifiedById = modifiedById;
    }

    public Date getModifiedDate()
    {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate)
    {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedAtWsNo()
    {
        return modifiedAtWsNo;
    }

    public void setModifiedAtWsNo(String modifiedAtWsNo)
    {
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public String getModifiedFacilityId()
    {
        return modifiedFacilityId;
    }

    public void setModifiedFacilityId(String modifiedFacilityId)
    {
        this.modifiedFacilityId = modifiedFacilityId;
    }

    public Date getDeceasedDateTime()
    {
        return deceasedDateTime;
    }

    public void setDeceasedDateTime(Date deceasedDateTime)
    {
        this.deceasedDateTime = deceasedDateTime;
    }

    public String getSecurityLevel()
    {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel)
    {
        this.securityLevel = securityLevel;
    }

    public String getProtectionInd()
    {
        return protectionInd;
    }

    public void setProtectionInd(String protectionInd)
    {
        this.protectionInd = protectionInd;
    }

    public String getAssignBedClassCode()
    {
        return assignBedClassCode;
    }

    public void setAssignBedClassCode(String assignBedClassCode)
    {
        this.assignBedClassCode = assignBedClassCode;
    }

    public String getAssignBedTypeCode()
    {
        return assignBedTypeCode;
    }

    public void setAssignBedTypeCode(String assignBedTypeCode)
    {
        this.assignBedTypeCode = assignBedTypeCode;
    }

    public Date getBedAllocationDateTime()
    {
        return bedAllocationDateTime;
    }

    public void setBedAllocationDateTime(Date bedAllocationDateTime)
    {
        this.bedAllocationDateTime = bedAllocationDateTime;
    }

    public String getClosedById()
    {
        return closedById;
    }

    public void setClosedById(String closedById)
    {
        this.closedById = closedById;
    }

    public Date getClosedDate()
    {
        return closedDate;
    }

    public void setClosedDate(Date closedDate)
    {
        this.closedDate = closedDate;
    }

    public String getDcUnitCode()
    {
        return dcUnitCode;
    }

    public void setDcUnitCode(String dcUnitCode)
    {
        this.dcUnitCode = dcUnitCode;
    }

    public String getDischPractitionerId()
    {
        return dischPractitionerId;
    }

    public void setDischPractitionerId(String dischPractitionerId)
    {
        this.dischPractitionerId = dischPractitionerId;
    }

    public Date getInformedDateTime()
    {
        return informedDateTime;
    }

    public void setInformedDateTime(Date informedDateTime)
    {
        this.informedDateTime = informedDateTime;
    }

    public String getInformedName()
    {
        return informedName;
    }

    public void setInformedName(String informedName)
    {
        this.informedName = informedName;
    }

    public String getInformedTo()
    {
        return informedTo;
    }

    public void setInformedTo(String informedTo)
    {
        this.informedTo = informedTo;
    }

    public String getIpLeaveStatus()
    {
        return ipLeaveStatus;
    }

    public void setIpLeaveStatus(String ipLeaveStatus)
    {
        this.ipLeaveStatus = ipLeaveStatus;
    }

    public Date getLeaveExpiryDateTime()
    {
        return leaveExpiryDateTime;
    }

    public void setLeaveExpiryDateTime(Date leaveExpiryDateTime)
    {
        this.leaveExpiryDateTime = leaveExpiryDateTime;
    }

    public String getMarkedById()
    {
        return markedById;
    }

    public void setMarkedById(String markedById)
    {
        this.markedById = markedById;
    }

    public Date getMarkedDate()
    {
        return markedDate;
    }

    public void setMarkedDate(Date markedDate)
    {
        this.markedDate = markedDate;
    }

    public String getMlcYn()
    {
        return mlcYn;
    }

    public void setMlcYn(String mlcYn)
    {
        this.mlcYn = mlcYn;
    }

    public String getOsccYn()
    {
        return osccYn;
    }

    public void setOsccYn(String osccYn)
    {
        this.osccYn = osccYn;
    }

    public String getOthAdtStatus()
    {
        return othAdtStatus;
    }

    public void setOthAdtStatus(String othAdtStatus)
    {
        this.othAdtStatus = othAdtStatus;
    }

    public Long getPatientPriorityNo()
    {
        return patientPriorityNo;
    }

    public void setPatientPriorityNo(Long patientPriorityNo)
    {
        this.patientPriorityNo = patientPriorityNo;
    }

    public String getPatCurrLocnCode()
    {
        return patCurrLocnCode;
    }

    public void setPatCurrLocnCode(String patCurrLocnCode)
    {
        this.patCurrLocnCode = patCurrLocnCode;
    }

    public String getPatCurrLocnType()
    {
        return patCurrLocnType;
    }

    public void setPatCurrLocnType(String patCurrLocnType)
    {
        this.patCurrLocnType = patCurrLocnType;
    }

    public Date getPatTrnTime()
    {
        return patTrnTime;
    }

    public void setPatTrnTime(Date patTrnTime)
    {
        this.patTrnTime = patTrnTime;
    }

    public String getPolId()
    {
        return polId;
    }

    public void setPolId(String polId)
    {
        this.polId = polId;
    }

    public String getPolRepNo()
    {
        return polRepNo;
    }

    public void setPolRepNo(String polRepNo)
    {
        this.polRepNo = polRepNo;
    }

    public String getPolStnId()
    {
        return polStnId;
    }

    public void setPolStnId(String polStnId)
    {
        this.polStnId = polStnId;
    }

    public Date getMarkArrivalDateTime()
    {
        return markArrivalDateTime;
    }

    public void setMarkArrivalDateTime(Date markArrivalDateTime)
    {
        this.markArrivalDateTime = markArrivalDateTime;
    }

    public String getPriorityZone()
    {
        return priorityZone;
    }

    public void setPriorityZone(String priorityZone)
    {
        this.priorityZone = priorityZone;
    }

    public String getTreatmentAreaCode()
    {
        return treatmentAreaCode;
    }

    public void setTreatmentAreaCode(String treatmentAreaCode)
    {
        this.treatmentAreaCode = treatmentAreaCode;
    }

    public String getBroughtDeadYn()
    {
        return broughtDeadYn;
    }

    public void setBroughtDeadYn(String broughtDeadYn)
    {
        this.broughtDeadYn = broughtDeadYn;
    }

    public String getDisasterYn()
    {
        return disasterYn;
    }

    public void setDisasterYn(String disasterYn)
    {
        this.disasterYn = disasterYn;
    }

    public String getDisasterTownCode()
    {
        return disasterTownCode;
    }

    public void setDisasterTownCode(String disasterTownCode)
    {
        this.disasterTownCode = disasterTownCode;
    }

    public String getPrevAssignCareLocnCode()
    {
        return prevAssignCareLocnCode;
    }

    public void setPrevAssignCareLocnCode(String prevAssignCareLocnCode)
    {
        this.prevAssignCareLocnCode = prevAssignCareLocnCode;
    }

    public String getPrevAssignRoomNum()
    {
        return prevAssignRoomNum;
    }

    public void setPrevAssignRoomNum(String prevAssignRoomNum)
    {
        this.prevAssignRoomNum = prevAssignRoomNum;
    }

    public String getPrevSubserviceCode()
    {
        return prevSubserviceCode;
    }

    public void setPrevSubserviceCode(String prevSubserviceCode)
    {
        this.prevSubserviceCode = prevSubserviceCode;
    }

    public String getPrevAttendPractitionerId()
    {
        return prevAttendPractitionerId;
    }

    public void setPrevAttendPractitionerId(String prevAttendPractitionerId)
    {
        this.prevAttendPractitionerId = prevAttendPractitionerId;
    }

    public String getPrevVisitAdmType()
    {
        return prevVisitAdmType;
    }

    public void setPrevVisitAdmType(String prevVisitAdmType)
    {
        this.prevVisitAdmType = prevVisitAdmType;
    }

    public String getPrevVisitAdmTypeInd()
    {
        return prevVisitAdmTypeInd;
    }

    public void setPrevVisitAdmTypeInd(String prevVisitAdmTypeInd)
    {
        this.prevVisitAdmTypeInd = prevVisitAdmTypeInd;
    }

    public Long getInvitationNo()
    {
        return invitationNo;
    }

    public void setInvitationNo(Long invitationNo)
    {
        this.invitationNo = invitationNo;
    }

    public String getOtherResourceId()
    {
        return otherResourceId;
    }

    public void setOtherResourceId(String otherResourceId)
    {
        this.otherResourceId = otherResourceId;
    }

    public String getMovementReasonCode()
    {
        return movementReasonCode;
    }

    public void setMovementReasonCode(String movementReasonCode)
    {
        this.movementReasonCode = movementReasonCode;
    }

    public String getQueueId()
    {
        return queueId;
    }

    public void setQueueId(String queueId)
    {
        this.queueId = queueId;
    }

    public String getOtherResClass()
    {
        return otherResClass;
    }

    public void setOtherResClass(String otherResClass)
    {
        this.otherResClass = otherResClass;
    }

    public String getDisasterTypeCode()
    {
        return disasterTypeCode;
    }

    public void setDisasterTypeCode(String disasterTypeCode)
    {
        this.disasterTypeCode = disasterTypeCode;
    }

    public String getMedicalYn()
    {
        return medicalYn;
    }

    public void setMedicalYn(String medicalYn)
    {
        this.medicalYn = medicalYn;
    }

    public String getSurgicalYn()
    {
        return surgicalYn;
    }

    public void setSurgicalYn(String surgicalYn)
    {
        this.surgicalYn = surgicalYn;
    }

    public Date getBodyReleaseDateTime()
    {
        return bodyReleaseDateTime;
    }

    public void setBodyReleaseDateTime(Date bodyReleaseDateTime)
    {
        this.bodyReleaseDateTime = bodyReleaseDateTime;
    }

    public String getPmYn()
    {
        return pmYn;
    }

    public void setPmYn(String pmYn)
    {
        this.pmYn = pmYn;
    }

    public String getFileNo()
    {
        return fileNo;
    }

    public void setFileNo(String fileNo)
    {
        this.fileNo = fileNo;
    }

    public String getTraumaYn()
    {
        return traumaYn;
    }

    public void setTraumaYn(String traumaYn)
    {
        this.traumaYn = traumaYn;
    }

    public String getMechInjurySubcatgCode()
    {
        return mechInjurySubcatgCode;
    }

    public void setMechInjurySubcatgCode(String mechInjurySubcatgCode)
    {
        this.mechInjurySubcatgCode = mechInjurySubcatgCode;
    }

    public String getHighRiskYn()
    {
        return highRiskYn;
    }

    public void setHighRiskYn(String highRiskYn)
    {
        this.highRiskYn = highRiskYn;
    }

    public Set getAeTraumaPrimarySurveies()
    {
        return aeTraumaPrimarySurveies;
    }

    public void setAeTraumaPrimarySurveies(Set aeTraumaPrimarySurveies)
    {
        this.aeTraumaPrimarySurveies = aeTraumaPrimarySurveies;
    }

    public Set getOpLastVisitForServices()
    {
        return opLastVisitForServices;
    }

    public void setOpLastVisitForServices(Set opLastVisitForServices)
    {
        this.opLastVisitForServices = opLastVisitForServices;
    }

    public Set getFmEncounterVolumeLinks()
    {
        return fmEncounterVolumeLinks;
    }

    public void setFmEncounterVolumeLinks(Set fmEncounterVolumeLinks)
    {
        this.fmEncounterVolumeLinks = fmEncounterVolumeLinks;
    }

    public Set getPhMednAdmins()
    {
        return phMednAdmins;
    }

    public void setPhMednAdmins(Set phMednAdmins)
    {
        this.phMednAdmins = phMednAdmins;
    }

    public Set getOaApptDelTrs()
    {
        return oaApptDelTrs;
    }

    public void setOaApptDelTrs(Set oaApptDelTrs)
    {
        this.oaApptDelTrs = oaApptDelTrs;
    }

    public Set getPrDiagnosisesForPrDiagnosisF2()
    {
        return prDiagnosisesForPrDiagnosisF2;
    }

    public void setPrDiagnosisesForPrDiagnosisF2(Set prDiagnosisesForPrDiagnosisF2)
    {
        this.prDiagnosisesForPrDiagnosisF2 = prDiagnosisesForPrDiagnosisF2;
    }

    public Set getIpOpenEncounters()
    {
        return ipOpenEncounters;
    }

    public void setIpOpenEncounters(Set ipOpenEncounters)
    {
        this.ipOpenEncounters = ipOpenEncounters;
    }

    public Set getPrDiagnosisStatuses()
    {
        return prDiagnosisStatuses;
    }

    public void setPrDiagnosisStatuses(Set prDiagnosisStatuses)
    {
        this.prDiagnosisStatuses = prDiagnosisStatuses;
    }

    public Set getPrWaitListsForPrWaitListF12()
    {
        return prWaitListsForPrWaitListF12;
    }

    public void setPrWaitListsForPrWaitListF12(Set prWaitListsForPrWaitListF12)
    {
        this.prWaitListsForPrWaitListF12 = prWaitListsForPrWaitListF12;
    }

    public Set getCpPatCarePlanRevisions()
    {
        return cpPatCarePlanRevisions;
    }

    public void setCpPatCarePlanRevisions(Set cpPatCarePlanRevisions)
    {
        this.cpPatCarePlanRevisions = cpPatCarePlanRevisions;
    }

    public Set getFmDeficiencyHdrs()
    {
        return fmDeficiencyHdrs;
    }

    public void setFmDeficiencyHdrs(Set fmDeficiencyHdrs)
    {
        this.fmDeficiencyHdrs = fmDeficiencyHdrs;
    }

    public Set getDsEpsdMealPlanHdrAudits()
    {
        return dsEpsdMealPlanHdrAudits;
    }

    public void setDsEpsdMealPlanHdrAudits(Set dsEpsdMealPlanHdrAudits)
    {
        this.dsEpsdMealPlanHdrAudits = dsEpsdMealPlanHdrAudits;
    }

    public Set getAePatGcsScores()
    {
        return aePatGcsScores;
    }

    public void setAePatGcsScores(Set aePatGcsScores)
    {
        this.aePatGcsScores = aePatGcsScores;
    }

    public Set getIpPatientLastEncounters()
    {
        return ipPatientLastEncounters;
    }

    public void setIpPatientLastEncounters(Set ipPatientLastEncounters)
    {
        this.ipPatientLastEncounters = ipPatientLastEncounters;
    }

    public Set getPrEncounterOtherDetails()
    {
        return prEncounterOtherDetails;
    }

    public void setPrEncounterOtherDetails(Set prEncounterOtherDetails)
    {
        this.prEncounterOtherDetails = prEncounterOtherDetails;
    }

    public Set getAePatMovementLogs()
    {
        return aePatMovementLogs;
    }

    public void setAePatMovementLogs(Set aePatMovementLogs)
    {
        this.aePatMovementLogs = aePatMovementLogs;
    }

    public Set getOpPatientTrackingLocns()
    {
        return opPatientTrackingLocns;
    }

    public void setOpPatientTrackingLocns(Set opPatientTrackingLocns)
    {
        this.opPatientTrackingLocns = opPatientTrackingLocns;
    }

    public Set getPrAllergiesForPrAllergyF3()
    {
        return prAllergiesForPrAllergyF3;
    }

    public void setPrAllergiesForPrAllergyF3(Set prAllergiesForPrAllergyF3)
    {
        this.prAllergiesForPrAllergyF3 = prAllergiesForPrAllergyF3;
    }

    public Set getAePatEmergencyDetails()
    {
        return aePatEmergencyDetails;
    }

    public void setAePatEmergencyDetails(Set aePatEmergencyDetails)
    {
        this.aePatEmergencyDetails = aePatEmergencyDetails;
    }

    public Set getOpPatientQueues()
    {
        return opPatientQueues;
    }

    public void setOpPatientQueues(Set opPatientQueues)
    {
        this.opPatientQueues = opPatientQueues;
    }

    public Set getCpPatCarePlansForCpPatCarePlanF3()
    {
        return cpPatCarePlansForCpPatCarePlanF3;
    }

    public void setCpPatCarePlansForCpPatCarePlanF3(Set cpPatCarePlansForCpPatCarePlanF3)
    {
        this.cpPatCarePlansForCpPatCarePlanF3 = cpPatCarePlansForCpPatCarePlanF3;
    }

    public Set getIpBedBookings()
    {
        return ipBedBookings;
    }

    public void setIpBedBookings(Set ipBedBookings)
    {
        this.ipBedBookings = ipBedBookings;
    }

    public Set getIpAdtTrnAuditLogs()
    {
        return ipAdtTrnAuditLogs;
    }

    public void setIpAdtTrnAuditLogs(Set ipAdtTrnAuditLogs)
    {
        this.ipAdtTrnAuditLogs = ipAdtTrnAuditLogs;
    }

    public Set getDsEpsdMealPlanHdrAttnds()
    {
        return dsEpsdMealPlanHdrAttnds;
    }

    public void setDsEpsdMealPlanHdrAttnds(Set dsEpsdMealPlanHdrAttnds)
    {
        this.dsEpsdMealPlanHdrAttnds = dsEpsdMealPlanHdrAttnds;
    }

    public Set getOpCurrentPatients()
    {
        return opCurrentPatients;
    }

    public void setOpCurrentPatients(Set opCurrentPatients)
    {
        this.opCurrentPatients = opCurrentPatients;
    }

    public Set getIpDischargeAdvices()
    {
        return ipDischargeAdvices;
    }

    public void setIpDischargeAdvices(Set ipDischargeAdvices)
    {
        this.ipDischargeAdvices = ipDischargeAdvices;
    }

    public Set getPrEncounterPracts()
    {
        return prEncounterPracts;
    }

    public void setPrEncounterPracts(Set prEncounterPracts)
    {
        this.prEncounterPracts = prEncounterPracts;
    }

    public Set getAeCurrentPatients()
    {
        return aeCurrentPatients;
    }

    public void setAeCurrentPatients(Set aeCurrentPatients)
    {
        this.aeCurrentPatients = aeCurrentPatients;
    }

    public Set getOaAppts()
    {
        return oaAppts;
    }

    public void setOaAppts(Set oaAppts)
    {
        this.oaAppts = oaAppts;
    }

    public Set getIpBedClassRequests()
    {
        return ipBedClassRequests;
    }

    public void setIpBedClassRequests(Set ipBedClassRequests)
    {
        this.ipBedClassRequests = ipBedClassRequests;
    }

    public Set getPrDiagnosisesForPrDiagnosisF7()
    {
        return prDiagnosisesForPrDiagnosisF7;
    }

    public void setPrDiagnosisesForPrDiagnosisF7(Set prDiagnosisesForPrDiagnosisF7)
    {
        this.prDiagnosisesForPrDiagnosisF7 = prDiagnosisesForPrDiagnosisF7;
    }

    public Set getPhPatientVaccProfiles()
    {
        return phPatientVaccProfiles;
    }

    public void setPhPatientVaccProfiles(Set phPatientVaccProfiles)
    {
        this.phPatientVaccProfiles = phPatientVaccProfiles;
    }

    public Set getPhMednAdminDtls()
    {
        return phMednAdminDtls;
    }

    public void setPhMednAdminDtls(Set phMednAdminDtls)
    {
        this.phMednAdminDtls = phMednAdminDtls;
    }

    public Set getPrSickLeaveRegisters()
    {
        return prSickLeaveRegisters;
    }

    public void setPrSickLeaveRegisters(Set prSickLeaveRegisters)
    {
        this.prSickLeaveRegisters = prSickLeaveRegisters;
    }

    public Set getAePatTriages()
    {
        return aePatTriages;
    }

    public void setAePatTriages(Set aePatTriages)
    {
        this.aePatTriages = aePatTriages;
    }

    public Set getAeTraumaSecondarySurveies()
    {
        return aeTraumaSecondarySurveies;
    }

    public void setAeTraumaSecondarySurveies(Set aeTraumaSecondarySurveies)
    {
        this.aeTraumaSecondarySurveies = aeTraumaSecondarySurveies;
    }

    public Set getPrAllergiesForPrAllergyF4()
    {
        return prAllergiesForPrAllergyF4;
    }

    public void setPrAllergiesForPrAllergyF4(Set prAllergiesForPrAllergyF4)
    {
        this.prAllergiesForPrAllergyF4 = prAllergiesForPrAllergyF4;
    }

    public Set getIpTransferRequests()
    {
        return ipTransferRequests;
    }

    public void setIpTransferRequests(Set ipTransferRequests)
    {
        this.ipTransferRequests = ipTransferRequests;
    }

    public Set getDsEpsdDietProfileHdrs()
    {
        return dsEpsdDietProfileHdrs;
    }

    public void setDsEpsdDietProfileHdrs(Set dsEpsdDietProfileHdrs)
    {
        this.dsEpsdDietProfileHdrs = dsEpsdDietProfileHdrs;
    }

    public Set getMrDiagRecodings()
    {
        return mrDiagRecodings;
    }

    public void setMrDiagRecodings(Set mrDiagRecodings)
    {
        this.mrDiagRecodings = mrDiagRecodings;
    }

    public Set getCpPatCarePlansForCpPatCarePlanF8()
    {
        return cpPatCarePlansForCpPatCarePlanF8;
    }

    public void setCpPatCarePlansForCpPatCarePlanF8(Set cpPatCarePlansForCpPatCarePlanF8)
    {
        this.cpPatCarePlansForCpPatCarePlanF8 = cpPatCarePlansForCpPatCarePlanF8;
    }

    public Set getQaQindEncounterTrns()
    {
        return qaQindEncounterTrns;
    }

    public void setQaQindEncounterTrns(Set qaQindEncounterTrns)
    {
        this.qaQindEncounterTrns = qaQindEncounterTrns;
    }

    public Set getPrWaitListsForPrWaitListF10()
    {
        return prWaitListsForPrWaitListF10;
    }

    public void setPrWaitListsForPrWaitListF10(Set prWaitListsForPrWaitListF10)
    {
        this.prWaitListsForPrWaitListF10 = prWaitListsForPrWaitListF10;
    }

    public Set getMrDeathRegisterHdrs()
    {
        return mrDeathRegisterHdrs;
    }

    public void setMrDeathRegisterHdrs(Set mrDeathRegisterHdrs)
    {
        this.mrDeathRegisterHdrs = mrDeathRegisterHdrs;
    }

    public Set getDsEpsdMealPlanHdrs()
    {
        return dsEpsdMealPlanHdrs;
    }

    public void setDsEpsdMealPlanHdrs(Set dsEpsdMealPlanHdrs)
    {
        this.dsEpsdMealPlanHdrs = dsEpsdMealPlanHdrs;
    }

    public Set getAePatRelatedContactses()
    {
        return aePatRelatedContactses;
    }

    public void setAePatRelatedContactses(Set aePatRelatedContactses)
    {
        this.aePatRelatedContactses = aePatRelatedContactses;
    }

    public Set getIpDischargeChecklists()
    {
        return ipDischargeChecklists;
    }

    public void setIpDischargeChecklists(Set ipDischargeChecklists)
    {
        this.ipDischargeChecklists = ipDischargeChecklists;
    }

    public Set getCaEncntrChiefComplaints()
    {
        return caEncntrChiefComplaints;
    }

    public void setCaEncntrChiefComplaints(Set caEncntrChiefComplaints)
    {
        this.caEncntrChiefComplaints = caEncntrChiefComplaints;
    }

    public Set getCpPatAssesses()
    {
        return cpPatAssesses;
    }

    public void setCpPatAssesses(Set cpPatAssesses)
    {
        this.cpPatAssesses = cpPatAssesses;
    }

    public Set getIpDischargeSummaries()
    {
        return ipDischargeSummaries;
    }

    public void setIpDischargeSummaries(Set ipDischargeSummaries)
    {
        this.ipDischargeSummaries = ipDischargeSummaries;
    }

    public Set getMrReportRequestDtls()
    {
        return mrReportRequestDtls;
    }

    public void setMrReportRequestDtls(Set mrReportRequestDtls)
    {
        this.mrReportRequestDtls = mrReportRequestDtls;
    }

    public Set getIpNursingUnitBeds()
    {
        return ipNursingUnitBeds;
    }

    public void setIpNursingUnitBeds(Set ipNursingUnitBeds)
    {
        this.ipNursingUnitBeds = ipNursingUnitBeds;
    }

    public Set getPrWaitListsForPrWaitListF11()
    {
        return prWaitListsForPrWaitListF11;
    }

    public void setPrWaitListsForPrWaitListF11(Set prWaitListsForPrWaitListF11)
    {
        this.prWaitListsForPrWaitListF11 = prWaitListsForPrWaitListF11;
    }

    private PrEncounterId id;
    private AmSpeciality amSpeciality;
    private AeInjuryCategory aeInjuryCategory;
    private AmContactReason amContactReason;
    private AmPatientClass amPatientClass;
    private AmPractitioner amPractitioner;
    private MpPatient mpPatient;
    private AmAmbulatoryStatus amAmbulatoryStatus;
    private Date visitAdmDateTime;
    private String visitAdmTypeFacilityId;
    private String visitAdmType;
    private String visitAdmTypeInd;
    private String assignCareLocnType;
    private String assignCareLocnCode;
    private String assignRoomType;
    private String assignRoomNum;
    private String assignBedNum;
    private String attendPractitionerId;
    private String referralId;
    private String apptCaseYn;
    private String apptId;
    private String bookingCaseYn;
    private String bookingRefNo;
    private String serviceCode;
    private String subserviceCode;
    private String ancillaryYn;
    private String patientType;
    private String circumstanceOfInjuryCode;
    private String courtesyCode;
    private String chiefComplaint;
    private String patientCondition;
    private String newOpEpisodeYn;
    private Long episodeId;
    private Long opEpisodeVisitNum;
    private String admitPractitionerId;
    private Date dischargeDateTime;
    private String dispositionType;
    private String recallYn;
    private Date recallDate;
    private String dispFacilityId;
    private String dispReferralId;
    private String mdsCompleteYn;
    private Date fiscalYear;
    private Long fiscalPeriod;
    private String shiftId;
    private String backdatedYn;
    private String visitStatus;
    private Date visitStatusSetOnDate;
    private String visitStatusSetByUser;
    private String visitStatusSetReason;
    private String adtStatus;
    private Date adtStatusSetOnDate;
    private String adtStatusSetByUser;
    private String adtStatusSetReason;
    private String recallReason;
    private String referredYn;
    private String prnVisitYn;
    private Date prnVisitBefore;
    private String aeEpisodeYn;
    private String reviseReasonCode;
    private String cancelReasonCode;
    private String teamId;
    private String creditAuthUserId;
    private String creditAuthRemarks;
    private Long admissionNo;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
    private Date deceasedDateTime;
    private String securityLevel;
    private String protectionInd;
    private String assignBedClassCode;
    private String assignBedTypeCode;
    private Date bedAllocationDateTime;
    private String closedById;
    private Date closedDate;
    private String dcUnitCode;
    private String dischPractitionerId;
    private Date informedDateTime;
    private String informedName;
    private String informedTo;
    private String ipLeaveStatus;
    private Date leaveExpiryDateTime;
    private String markedById;
    private Date markedDate;
    private String mlcYn;
    private String osccYn;
    private String othAdtStatus;
    private Long patientPriorityNo;
    private String patCurrLocnCode;
    private String patCurrLocnType;
    private Date patTrnTime;
    private String polId;
    private String polRepNo;
    private String polStnId;
    private Date markArrivalDateTime;
    private String priorityZone;
    private String treatmentAreaCode;
    private String broughtDeadYn;
    private String disasterYn;
    private String disasterTownCode;
    private String prevAssignCareLocnCode;
    private String prevAssignRoomNum;
    private String prevSubserviceCode;
    private String prevAttendPractitionerId;
    private String prevVisitAdmType;
    private String prevVisitAdmTypeInd;
    private Long invitationNo;
    private String otherResourceId;
    private String movementReasonCode;
    private String queueId;
    private String otherResClass;
    private String disasterTypeCode;
    private String medicalYn;
    private String surgicalYn;
    private Date bodyReleaseDateTime;
    private String pmYn;
    private String fileNo;
    private String traumaYn;
    private String mechInjurySubcatgCode;
    private String highRiskYn;
    private Set aeTraumaPrimarySurveies;
    private Set opLastVisitForServices;
    private Set fmEncounterVolumeLinks;
    private Set phMednAdmins;
    private Set oaApptDelTrs;
    private Set prDiagnosisesForPrDiagnosisF2;
    private Set ipOpenEncounters;
    private Set prDiagnosisStatuses;
    private Set prWaitListsForPrWaitListF12;
    private Set cpPatCarePlanRevisions;
    private Set fmDeficiencyHdrs;
    private Set dsEpsdMealPlanHdrAudits;
    private Set aePatGcsScores;
    private Set ipPatientLastEncounters;
    private Set prEncounterOtherDetails;
    private Set aePatMovementLogs;
    private Set opPatientTrackingLocns;
    private Set prAllergiesForPrAllergyF3;
    private Set aePatEmergencyDetails;
    private Set opPatientQueues;
    private Set cpPatCarePlansForCpPatCarePlanF3;
    private Set ipBedBookings;
    private Set ipAdtTrnAuditLogs;
    private Set dsEpsdMealPlanHdrAttnds;
    private Set opCurrentPatients;
    private Set ipDischargeAdvices;
    private Set prEncounterPracts;
    private Set aeCurrentPatients;
    private Set oaAppts;
    private Set ipBedClassRequests;
    private Set prDiagnosisesForPrDiagnosisF7;
    private Set phPatientVaccProfiles;
    private Set phMednAdminDtls;
    private Set prSickLeaveRegisters;
    private Set aePatTriages;
    private Set aeTraumaSecondarySurveies;
    private Set prAllergiesForPrAllergyF4;
    private Set ipTransferRequests;
    private Set dsEpsdDietProfileHdrs;
    private Set mrDiagRecodings;
    private Set cpPatCarePlansForCpPatCarePlanF8;
    private Set qaQindEncounterTrns;
    private Set prWaitListsForPrWaitListF10;
    private Set mrDeathRegisterHdrs;
    private Set dsEpsdMealPlanHdrs;
    private Set aePatRelatedContactses;
    private Set ipDischargeChecklists;
    private Set caEncntrChiefComplaints;
    private Set cpPatAssesses;
    private Set ipDischargeSummaries;
    private Set mrReportRequestDtls;
    private Set ipNursingUnitBeds;
    private Set prWaitListsForPrWaitListF11;
}
