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
//            MpCountry, SmFacilityParam, AmPractType, MpMaritalStatus, 
//            AmSpeciality

public class AmPractitioner
    implements Serializable
{

    public AmPractitioner()
    {
        aePatMovementLogs = new HashSet(0);
        aePatGcsScores = new HashSet(0);
        orOrderLinePhs = new HashSet(0);
        prSickLeaveRegisters = new HashSet(0);
        fmDeficiencyDtls = new HashSet(0);
        ipNursingUnitForPracts = new HashSet(0);
        prEncounterPracts = new HashSet(0);
        prDiagnosisesForOnsetPractitionerId = new HashSet(0);
        prAllergiesForOnsetPractitionerId = new HashSet(0);
        caTextBlkByServPracts = new HashSet(0);
        prEpisodeOfCaresForOpenPractitionerId = new HashSet(0);
        amPractSpecialitieses = new HashSet(0);
        amPractForTeams = new HashSet(0);
        ipBedBookings = new HashSet(0);
        mrReportRequestHdrsForRequestingPractId = new HashSet(0);
        atAnaesthesiaRecordHdrsForAnaesthetistCode = new HashSet(0);
        prEpisodeOfCaresForResolvePractitionerId = new HashSet(0);
        cpPatCarePlansForStatusPractId = new HashSet(0);
        prEpisodeOfCaresForErrorPractitionerId = new HashSet(0);
        aeTraumaSecondarySurveies = new HashSet(0);
        atAnaesthesiaRecordHdrsForAnaesthetist2Code = new HashSet(0);
        fmIpPullingLists = new HashSet(0);
        orPractForConsents = new HashSet(0);
        cpPatGoalEvals = new HashSet(0);
        mrDeathRegisterHdrs = new HashSet(0);
        prEncounterProcedures = new HashSet(0);
        aePatTriagesForPhysicianId = new HashSet(0);
        ipTransferRequestsForAuthPractitionerId = new HashSet(0);
        cpPatCarePlanRevisions = new HashSet(0);
        ipBookingLists = new HashSet(0);
        prAllergiesForClosePractitionerId = new HashSet(0);
        caPractByLocns = new HashSet(0);
        prProblemsForOnsetPractitionerId = new HashSet(0);
        cpPatOutcomeEvals = new HashSet(0);
        mrReportRequestHdrsForPreparePractId = new HashSet(0);
        atAnaesthesiaRecordHdrsForSurgeonCode = new HashSet(0);
        ipPatientLastEncountersForAttendPractitionerId = new HashSet(0);
        aePatTriagesForNurseId = new HashSet(0);
        aeTraumaPrimarySurveies = new HashSet(0);
        prDiagnosisStatuses = new HashSet(0);
        prEncounters = new HashSet(0);
        moMortuaryRegns = new HashSet(0);
        ipAdtTrnsForToPractitionerId = new HashSet(0);
        cpPatCarePlanEvals = new HashSet(0);
        orConsentRefHdrs = new HashSet(0);
        orOrderSetByIndexes = new HashSet(0);
        orReviewUserCategorieses = new HashSet(0);
        phPatientVaccProfiles = new HashSet(0);
        cpPatCarePlanVars = new HashSet(0);
        orResultUsers = new HashSet(0);
        cpPatCarePlansForCreatedPractId = new HashSet(0);
        mrDiagGroups = new HashSet(0);
        aePractForTmtAreas = new HashSet(0);
        ipTransferRequestsForReqPractitionerId = new HashSet(0);
        prReferralRegistersForToPractId = new HashSet(0);
        prReferralRegistersForFromPractId = new HashSet(0);
        caEncntrPractRelns = new HashSet(0);
        ipOpenEncountersForAttendPractitionerId = new HashSet(0);
        ipLeaveDetails = new HashSet(0);
        prProblemsForClosePractitionerId = new HashSet(0);
        atAnaesthesiaRecordHdrsForAnaesthetist1Code = new HashSet(0);
        cpPatCarePlansForFinalizedPractId = new HashSet(0);
        ipAdtTrnsForFrPractitionerId = new HashSet(0);
        ipPatientLastEncountersForAdmitPractitionerId = new HashSet(0);
        cpPatTermCodeEvals = new HashSet(0);
        ipOpenEncountersForAdmitPractitionerId = new HashSet(0);
        amPractForFacilities = new HashSet(0);
        cpPatCarePlanManagers = new HashSet(0);
        mrTermSetForPracts = new HashSet(0);
        prDiagnosisesForCurrPractitionerId = new HashSet(0);
    }

    public AmPractitioner(String practitionerId, AmPractType amPractType, AmSpeciality amSpeciality, String practitionerName, String shortName, String gender, Date dateOfBirth, 
            String emplStatus, String allFacilitiesYn, String effStatus, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, 
            String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId)
    {
        aePatMovementLogs = new HashSet(0);
        aePatGcsScores = new HashSet(0);
        orOrderLinePhs = new HashSet(0);
        prSickLeaveRegisters = new HashSet(0);
        fmDeficiencyDtls = new HashSet(0);
        ipNursingUnitForPracts = new HashSet(0);
        prEncounterPracts = new HashSet(0);
        prDiagnosisesForOnsetPractitionerId = new HashSet(0);
        prAllergiesForOnsetPractitionerId = new HashSet(0);
        caTextBlkByServPracts = new HashSet(0);
        prEpisodeOfCaresForOpenPractitionerId = new HashSet(0);
        amPractSpecialitieses = new HashSet(0);
        amPractForTeams = new HashSet(0);
        ipBedBookings = new HashSet(0);
        mrReportRequestHdrsForRequestingPractId = new HashSet(0);
        atAnaesthesiaRecordHdrsForAnaesthetistCode = new HashSet(0);
        prEpisodeOfCaresForResolvePractitionerId = new HashSet(0);
        cpPatCarePlansForStatusPractId = new HashSet(0);
        prEpisodeOfCaresForErrorPractitionerId = new HashSet(0);
        aeTraumaSecondarySurveies = new HashSet(0);
        atAnaesthesiaRecordHdrsForAnaesthetist2Code = new HashSet(0);
        fmIpPullingLists = new HashSet(0);
        orPractForConsents = new HashSet(0);
        cpPatGoalEvals = new HashSet(0);
        mrDeathRegisterHdrs = new HashSet(0);
        prEncounterProcedures = new HashSet(0);
        aePatTriagesForPhysicianId = new HashSet(0);
        ipTransferRequestsForAuthPractitionerId = new HashSet(0);
        cpPatCarePlanRevisions = new HashSet(0);
        ipBookingLists = new HashSet(0);
        prAllergiesForClosePractitionerId = new HashSet(0);
        caPractByLocns = new HashSet(0);
        prProblemsForOnsetPractitionerId = new HashSet(0);
        cpPatOutcomeEvals = new HashSet(0);
        mrReportRequestHdrsForPreparePractId = new HashSet(0);
        atAnaesthesiaRecordHdrsForSurgeonCode = new HashSet(0);
        ipPatientLastEncountersForAttendPractitionerId = new HashSet(0);
        aePatTriagesForNurseId = new HashSet(0);
        aeTraumaPrimarySurveies = new HashSet(0);
        prDiagnosisStatuses = new HashSet(0);
        prEncounters = new HashSet(0);
        moMortuaryRegns = new HashSet(0);
        ipAdtTrnsForToPractitionerId = new HashSet(0);
        cpPatCarePlanEvals = new HashSet(0);
        orConsentRefHdrs = new HashSet(0);
        orOrderSetByIndexes = new HashSet(0);
        orReviewUserCategorieses = new HashSet(0);
        phPatientVaccProfiles = new HashSet(0);
        cpPatCarePlanVars = new HashSet(0);
        orResultUsers = new HashSet(0);
        cpPatCarePlansForCreatedPractId = new HashSet(0);
        mrDiagGroups = new HashSet(0);
        aePractForTmtAreas = new HashSet(0);
        ipTransferRequestsForReqPractitionerId = new HashSet(0);
        prReferralRegistersForToPractId = new HashSet(0);
        prReferralRegistersForFromPractId = new HashSet(0);
        caEncntrPractRelns = new HashSet(0);
        ipOpenEncountersForAttendPractitionerId = new HashSet(0);
        ipLeaveDetails = new HashSet(0);
        prProblemsForClosePractitionerId = new HashSet(0);
        atAnaesthesiaRecordHdrsForAnaesthetist1Code = new HashSet(0);
        cpPatCarePlansForFinalizedPractId = new HashSet(0);
        ipAdtTrnsForFrPractitionerId = new HashSet(0);
        ipPatientLastEncountersForAdmitPractitionerId = new HashSet(0);
        cpPatTermCodeEvals = new HashSet(0);
        ipOpenEncountersForAdmitPractitionerId = new HashSet(0);
        amPractForFacilities = new HashSet(0);
        cpPatCarePlanManagers = new HashSet(0);
        mrTermSetForPracts = new HashSet(0);
        prDiagnosisesForCurrPractitionerId = new HashSet(0);
        this.practitionerId = practitionerId;
        this.amPractType = amPractType;
        this.amSpeciality = amSpeciality;
        this.practitionerName = practitionerName;
        this.shortName = shortName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.emplStatus = emplStatus;
        this.allFacilitiesYn = allFacilitiesYn;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
    }

    public AmPractitioner(String practitionerId, MpCountry mpCountryByResAddCountryCode, SmFacilityParam smFacilityParam, AmPractType amPractType, MpMaritalStatus mpMaritalStatus, MpCountry mpCountryByOffAddCountryCode, AmSpeciality amSpeciality, 
            MpCountry mpCountryByMailAddCountryCode, MpCountry mpCountryByCitizenshipCode, String practitionerName, String shortName, String nationalIdNum, String gender, Date dateOfBirth, 
            String aliasName, String placeOfBirth, String credentialId, String jobTitle, String emplStatus, String degree, String allFacilitiesYn, 
            String offTelNum, String offTelExt, String resTelNum, String faxNum, String mobileNum, String pagerNum, String emailId, 
            String prefContactMode, String resAddLn1, String resAddLn2, String resAddLn3, String resAddLn4, String resAddPostalCode, String offAddLn1, 
            String offAddLn2, String offAddLn3, String offAddLn4, String offAddPostalCode, String mailAddLn1, String mailAddLn2, String mailAddLn3, 
            String mailAddLn4, String mailAddPostalCode, String employeeId, Date effDateFrom, Date effDateTo, String effStatus, String addedById, 
            Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, 
            String credentialId1, String credentialId2, String credentialId3, String apcNo, String degree1, String degree1Univ, String degree1Year, 
            String degree2, String degree2Univ, String degree2Year, String degree3, String degree3Univ, String degree3Year, String degree4, 
            String degree4Univ, String degree4Year, String reportingServiceCode, String trainingCondBy1, String trainingCondBy2, String trainingCondBy3, String trainingCondBy4, 
            String trainingDtls1, String trainingDtls2, String trainingDtls3, String trainingDtls4, String positionCode, String gradeCode, Set aePatMovementLogs, 
            Set aePatGcsScores, Set orOrderLinePhs, Set prSickLeaveRegisters, Set fmDeficiencyDtls, Set ipNursingUnitForPracts, Set prEncounterPracts, Set prDiagnosisesForOnsetPractitionerId, 
            Set prAllergiesForOnsetPractitionerId, Set caTextBlkByServPracts, Set prEpisodeOfCaresForOpenPractitionerId, Set amPractSpecialitieses, Set amPractForTeams, Set ipBedBookings, Set mrReportRequestHdrsForRequestingPractId, 
            Set atAnaesthesiaRecordHdrsForAnaesthetistCode, Set prEpisodeOfCaresForResolvePractitionerId, Set cpPatCarePlansForStatusPractId, Set prEpisodeOfCaresForErrorPractitionerId, Set aeTraumaSecondarySurveies, Set atAnaesthesiaRecordHdrsForAnaesthetist2Code, Set fmIpPullingLists, 
            Set orPractForConsents, Set cpPatGoalEvals, Set mrDeathRegisterHdrs, Set prEncounterProcedures, Set aePatTriagesForPhysicianId, Set ipTransferRequestsForAuthPractitionerId, Set cpPatCarePlanRevisions, 
            Set ipBookingLists, Set prAllergiesForClosePractitionerId, Set caPractByLocns, Set prProblemsForOnsetPractitionerId, Set cpPatOutcomeEvals, Set mrReportRequestHdrsForPreparePractId, Set atAnaesthesiaRecordHdrsForSurgeonCode, 
            Set ipPatientLastEncountersForAttendPractitionerId, Set aePatTriagesForNurseId, Set aeTraumaPrimarySurveies, Set prDiagnosisStatuses, Set prEncounters, Set moMortuaryRegns, Set ipAdtTrnsForToPractitionerId, 
            Set cpPatCarePlanEvals, Set orConsentRefHdrs, Set orOrderSetByIndexes, Set orReviewUserCategorieses, Set phPatientVaccProfiles, Set cpPatCarePlanVars, Set orResultUsers, 
            Set cpPatCarePlansForCreatedPractId, Set mrDiagGroups, Set aePractForTmtAreas, Set ipTransferRequestsForReqPractitionerId, Set prReferralRegistersForToPractId, Set prReferralRegistersForFromPractId, Set caEncntrPractRelns, 
            Set ipOpenEncountersForAttendPractitionerId, Set ipLeaveDetails, Set prProblemsForClosePractitionerId, Set atAnaesthesiaRecordHdrsForAnaesthetist1Code, Set cpPatCarePlansForFinalizedPractId, Set ipAdtTrnsForFrPractitionerId, Set ipPatientLastEncountersForAdmitPractitionerId, 
            Set cpPatTermCodeEvals, Set ipOpenEncountersForAdmitPractitionerId, Set amPractForFacilities, Set cpPatCarePlanManagers, Set mrTermSetForPracts, Set prDiagnosisesForCurrPractitionerId)
    {
        this.aePatMovementLogs = new HashSet(0);
        this.aePatGcsScores = new HashSet(0);
        this.orOrderLinePhs = new HashSet(0);
        this.prSickLeaveRegisters = new HashSet(0);
        this.fmDeficiencyDtls = new HashSet(0);
        this.ipNursingUnitForPracts = new HashSet(0);
        this.prEncounterPracts = new HashSet(0);
        this.prDiagnosisesForOnsetPractitionerId = new HashSet(0);
        this.prAllergiesForOnsetPractitionerId = new HashSet(0);
        this.caTextBlkByServPracts = new HashSet(0);
        this.prEpisodeOfCaresForOpenPractitionerId = new HashSet(0);
        this.amPractSpecialitieses = new HashSet(0);
        this.amPractForTeams = new HashSet(0);
        this.ipBedBookings = new HashSet(0);
        this.mrReportRequestHdrsForRequestingPractId = new HashSet(0);
        this.atAnaesthesiaRecordHdrsForAnaesthetistCode = new HashSet(0);
        this.prEpisodeOfCaresForResolvePractitionerId = new HashSet(0);
        this.cpPatCarePlansForStatusPractId = new HashSet(0);
        this.prEpisodeOfCaresForErrorPractitionerId = new HashSet(0);
        this.aeTraumaSecondarySurveies = new HashSet(0);
        this.atAnaesthesiaRecordHdrsForAnaesthetist2Code = new HashSet(0);
        this.fmIpPullingLists = new HashSet(0);
        this.orPractForConsents = new HashSet(0);
        this.cpPatGoalEvals = new HashSet(0);
        this.mrDeathRegisterHdrs = new HashSet(0);
        this.prEncounterProcedures = new HashSet(0);
        this.aePatTriagesForPhysicianId = new HashSet(0);
        this.ipTransferRequestsForAuthPractitionerId = new HashSet(0);
        this.cpPatCarePlanRevisions = new HashSet(0);
        this.ipBookingLists = new HashSet(0);
        this.prAllergiesForClosePractitionerId = new HashSet(0);
        this.caPractByLocns = new HashSet(0);
        this.prProblemsForOnsetPractitionerId = new HashSet(0);
        this.cpPatOutcomeEvals = new HashSet(0);
        this.mrReportRequestHdrsForPreparePractId = new HashSet(0);
        this.atAnaesthesiaRecordHdrsForSurgeonCode = new HashSet(0);
        this.ipPatientLastEncountersForAttendPractitionerId = new HashSet(0);
        this.aePatTriagesForNurseId = new HashSet(0);
        this.aeTraumaPrimarySurveies = new HashSet(0);
        this.prDiagnosisStatuses = new HashSet(0);
        this.prEncounters = new HashSet(0);
        this.moMortuaryRegns = new HashSet(0);
        this.ipAdtTrnsForToPractitionerId = new HashSet(0);
        this.cpPatCarePlanEvals = new HashSet(0);
        this.orConsentRefHdrs = new HashSet(0);
        this.orOrderSetByIndexes = new HashSet(0);
        this.orReviewUserCategorieses = new HashSet(0);
        this.phPatientVaccProfiles = new HashSet(0);
        this.cpPatCarePlanVars = new HashSet(0);
        this.orResultUsers = new HashSet(0);
        this.cpPatCarePlansForCreatedPractId = new HashSet(0);
        this.mrDiagGroups = new HashSet(0);
        this.aePractForTmtAreas = new HashSet(0);
        this.ipTransferRequestsForReqPractitionerId = new HashSet(0);
        this.prReferralRegistersForToPractId = new HashSet(0);
        this.prReferralRegistersForFromPractId = new HashSet(0);
        this.caEncntrPractRelns = new HashSet(0);
        this.ipOpenEncountersForAttendPractitionerId = new HashSet(0);
        this.ipLeaveDetails = new HashSet(0);
        this.prProblemsForClosePractitionerId = new HashSet(0);
        this.atAnaesthesiaRecordHdrsForAnaesthetist1Code = new HashSet(0);
        this.cpPatCarePlansForFinalizedPractId = new HashSet(0);
        this.ipAdtTrnsForFrPractitionerId = new HashSet(0);
        this.ipPatientLastEncountersForAdmitPractitionerId = new HashSet(0);
        this.cpPatTermCodeEvals = new HashSet(0);
        this.ipOpenEncountersForAdmitPractitionerId = new HashSet(0);
        this.amPractForFacilities = new HashSet(0);
        this.cpPatCarePlanManagers = new HashSet(0);
        this.mrTermSetForPracts = new HashSet(0);
        this.prDiagnosisesForCurrPractitionerId = new HashSet(0);
        this.practitionerId = practitionerId;
        this.mpCountryByResAddCountryCode = mpCountryByResAddCountryCode;
        this.smFacilityParam = smFacilityParam;
        this.amPractType = amPractType;
        this.mpMaritalStatus = mpMaritalStatus;
        this.mpCountryByOffAddCountryCode = mpCountryByOffAddCountryCode;
        this.amSpeciality = amSpeciality;
        this.mpCountryByMailAddCountryCode = mpCountryByMailAddCountryCode;
        this.mpCountryByCitizenshipCode = mpCountryByCitizenshipCode;
        this.practitionerName = practitionerName;
        this.shortName = shortName;
        this.nationalIdNum = nationalIdNum;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.aliasName = aliasName;
        this.placeOfBirth = placeOfBirth;
        this.credentialId = credentialId;
        this.jobTitle = jobTitle;
        this.emplStatus = emplStatus;
        this.degree = degree;
        this.allFacilitiesYn = allFacilitiesYn;
        this.offTelNum = offTelNum;
        this.offTelExt = offTelExt;
        this.resTelNum = resTelNum;
        this.faxNum = faxNum;
        this.mobileNum = mobileNum;
        this.pagerNum = pagerNum;
        this.emailId = emailId;
        this.prefContactMode = prefContactMode;
        this.resAddLn1 = resAddLn1;
        this.resAddLn2 = resAddLn2;
        this.resAddLn3 = resAddLn3;
        this.resAddLn4 = resAddLn4;
        this.resAddPostalCode = resAddPostalCode;
        this.offAddLn1 = offAddLn1;
        this.offAddLn2 = offAddLn2;
        this.offAddLn3 = offAddLn3;
        this.offAddLn4 = offAddLn4;
        this.offAddPostalCode = offAddPostalCode;
        this.mailAddLn1 = mailAddLn1;
        this.mailAddLn2 = mailAddLn2;
        this.mailAddLn3 = mailAddLn3;
        this.mailAddLn4 = mailAddLn4;
        this.mailAddPostalCode = mailAddPostalCode;
        this.employeeId = employeeId;
        this.effDateFrom = effDateFrom;
        this.effDateTo = effDateTo;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.credentialId1 = credentialId1;
        this.credentialId2 = credentialId2;
        this.credentialId3 = credentialId3;
        this.apcNo = apcNo;
        this.degree1 = degree1;
        this.degree1Univ = degree1Univ;
        this.degree1Year = degree1Year;
        this.degree2 = degree2;
        this.degree2Univ = degree2Univ;
        this.degree2Year = degree2Year;
        this.degree3 = degree3;
        this.degree3Univ = degree3Univ;
        this.degree3Year = degree3Year;
        this.degree4 = degree4;
        this.degree4Univ = degree4Univ;
        this.degree4Year = degree4Year;
        this.reportingServiceCode = reportingServiceCode;
        this.trainingCondBy1 = trainingCondBy1;
        this.trainingCondBy2 = trainingCondBy2;
        this.trainingCondBy3 = trainingCondBy3;
        this.trainingCondBy4 = trainingCondBy4;
        this.trainingDtls1 = trainingDtls1;
        this.trainingDtls2 = trainingDtls2;
        this.trainingDtls3 = trainingDtls3;
        this.trainingDtls4 = trainingDtls4;
        this.positionCode = positionCode;
        this.gradeCode = gradeCode;
        this.aePatMovementLogs = aePatMovementLogs;
        this.aePatGcsScores = aePatGcsScores;
        this.orOrderLinePhs = orOrderLinePhs;
        this.prSickLeaveRegisters = prSickLeaveRegisters;
        this.fmDeficiencyDtls = fmDeficiencyDtls;
        this.ipNursingUnitForPracts = ipNursingUnitForPracts;
        this.prEncounterPracts = prEncounterPracts;
        this.prDiagnosisesForOnsetPractitionerId = prDiagnosisesForOnsetPractitionerId;
        this.prAllergiesForOnsetPractitionerId = prAllergiesForOnsetPractitionerId;
        this.caTextBlkByServPracts = caTextBlkByServPracts;
        this.prEpisodeOfCaresForOpenPractitionerId = prEpisodeOfCaresForOpenPractitionerId;
        this.amPractSpecialitieses = amPractSpecialitieses;
        this.amPractForTeams = amPractForTeams;
        this.ipBedBookings = ipBedBookings;
        this.mrReportRequestHdrsForRequestingPractId = mrReportRequestHdrsForRequestingPractId;
        this.atAnaesthesiaRecordHdrsForAnaesthetistCode = atAnaesthesiaRecordHdrsForAnaesthetistCode;
        this.prEpisodeOfCaresForResolvePractitionerId = prEpisodeOfCaresForResolvePractitionerId;
        this.cpPatCarePlansForStatusPractId = cpPatCarePlansForStatusPractId;
        this.prEpisodeOfCaresForErrorPractitionerId = prEpisodeOfCaresForErrorPractitionerId;
        this.aeTraumaSecondarySurveies = aeTraumaSecondarySurveies;
        this.atAnaesthesiaRecordHdrsForAnaesthetist2Code = atAnaesthesiaRecordHdrsForAnaesthetist2Code;
        this.fmIpPullingLists = fmIpPullingLists;
        this.orPractForConsents = orPractForConsents;
        this.cpPatGoalEvals = cpPatGoalEvals;
        this.mrDeathRegisterHdrs = mrDeathRegisterHdrs;
        this.prEncounterProcedures = prEncounterProcedures;
        this.aePatTriagesForPhysicianId = aePatTriagesForPhysicianId;
        this.ipTransferRequestsForAuthPractitionerId = ipTransferRequestsForAuthPractitionerId;
        this.cpPatCarePlanRevisions = cpPatCarePlanRevisions;
        this.ipBookingLists = ipBookingLists;
        this.prAllergiesForClosePractitionerId = prAllergiesForClosePractitionerId;
        this.caPractByLocns = caPractByLocns;
        this.prProblemsForOnsetPractitionerId = prProblemsForOnsetPractitionerId;
        this.cpPatOutcomeEvals = cpPatOutcomeEvals;
        this.mrReportRequestHdrsForPreparePractId = mrReportRequestHdrsForPreparePractId;
        this.atAnaesthesiaRecordHdrsForSurgeonCode = atAnaesthesiaRecordHdrsForSurgeonCode;
        this.ipPatientLastEncountersForAttendPractitionerId = ipPatientLastEncountersForAttendPractitionerId;
        this.aePatTriagesForNurseId = aePatTriagesForNurseId;
        this.aeTraumaPrimarySurveies = aeTraumaPrimarySurveies;
        this.prDiagnosisStatuses = prDiagnosisStatuses;
        this.prEncounters = prEncounters;
        this.moMortuaryRegns = moMortuaryRegns;
        this.ipAdtTrnsForToPractitionerId = ipAdtTrnsForToPractitionerId;
        this.cpPatCarePlanEvals = cpPatCarePlanEvals;
        this.orConsentRefHdrs = orConsentRefHdrs;
        this.orOrderSetByIndexes = orOrderSetByIndexes;
        this.orReviewUserCategorieses = orReviewUserCategorieses;
        this.phPatientVaccProfiles = phPatientVaccProfiles;
        this.cpPatCarePlanVars = cpPatCarePlanVars;
        this.orResultUsers = orResultUsers;
        this.cpPatCarePlansForCreatedPractId = cpPatCarePlansForCreatedPractId;
        this.mrDiagGroups = mrDiagGroups;
        this.aePractForTmtAreas = aePractForTmtAreas;
        this.ipTransferRequestsForReqPractitionerId = ipTransferRequestsForReqPractitionerId;
        this.prReferralRegistersForToPractId = prReferralRegistersForToPractId;
        this.prReferralRegistersForFromPractId = prReferralRegistersForFromPractId;
        this.caEncntrPractRelns = caEncntrPractRelns;
        this.ipOpenEncountersForAttendPractitionerId = ipOpenEncountersForAttendPractitionerId;
        this.ipLeaveDetails = ipLeaveDetails;
        this.prProblemsForClosePractitionerId = prProblemsForClosePractitionerId;
        this.atAnaesthesiaRecordHdrsForAnaesthetist1Code = atAnaesthesiaRecordHdrsForAnaesthetist1Code;
        this.cpPatCarePlansForFinalizedPractId = cpPatCarePlansForFinalizedPractId;
        this.ipAdtTrnsForFrPractitionerId = ipAdtTrnsForFrPractitionerId;
        this.ipPatientLastEncountersForAdmitPractitionerId = ipPatientLastEncountersForAdmitPractitionerId;
        this.cpPatTermCodeEvals = cpPatTermCodeEvals;
        this.ipOpenEncountersForAdmitPractitionerId = ipOpenEncountersForAdmitPractitionerId;
        this.amPractForFacilities = amPractForFacilities;
        this.cpPatCarePlanManagers = cpPatCarePlanManagers;
        this.mrTermSetForPracts = mrTermSetForPracts;
        this.prDiagnosisesForCurrPractitionerId = prDiagnosisesForCurrPractitionerId;
    }

    public String getPractitionerId()
    {
        return practitionerId;
    }

    public void setPractitionerId(String practitionerId)
    {
        this.practitionerId = practitionerId;
    }

    public MpCountry getMpCountryByResAddCountryCode()
    {
        return mpCountryByResAddCountryCode;
    }

    public void setMpCountryByResAddCountryCode(MpCountry mpCountryByResAddCountryCode)
    {
        this.mpCountryByResAddCountryCode = mpCountryByResAddCountryCode;
    }

    public SmFacilityParam getSmFacilityParam()
    {
        return smFacilityParam;
    }

    public void setSmFacilityParam(SmFacilityParam smFacilityParam)
    {
        this.smFacilityParam = smFacilityParam;
    }

    public AmPractType getAmPractType()
    {
        return amPractType;
    }

    public void setAmPractType(AmPractType amPractType)
    {
        this.amPractType = amPractType;
    }

    public MpMaritalStatus getMpMaritalStatus()
    {
        return mpMaritalStatus;
    }

    public void setMpMaritalStatus(MpMaritalStatus mpMaritalStatus)
    {
        this.mpMaritalStatus = mpMaritalStatus;
    }

    public MpCountry getMpCountryByOffAddCountryCode()
    {
        return mpCountryByOffAddCountryCode;
    }

    public void setMpCountryByOffAddCountryCode(MpCountry mpCountryByOffAddCountryCode)
    {
        this.mpCountryByOffAddCountryCode = mpCountryByOffAddCountryCode;
    }

    public AmSpeciality getAmSpeciality()
    {
        return amSpeciality;
    }

    public void setAmSpeciality(AmSpeciality amSpeciality)
    {
        this.amSpeciality = amSpeciality;
    }

    public MpCountry getMpCountryByMailAddCountryCode()
    {
        return mpCountryByMailAddCountryCode;
    }

    public void setMpCountryByMailAddCountryCode(MpCountry mpCountryByMailAddCountryCode)
    {
        this.mpCountryByMailAddCountryCode = mpCountryByMailAddCountryCode;
    }

    public MpCountry getMpCountryByCitizenshipCode()
    {
        return mpCountryByCitizenshipCode;
    }

    public void setMpCountryByCitizenshipCode(MpCountry mpCountryByCitizenshipCode)
    {
        this.mpCountryByCitizenshipCode = mpCountryByCitizenshipCode;
    }

    public String getPractitionerName()
    {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName)
    {
        this.practitionerName = practitionerName;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public String getNationalIdNum()
    {
        return nationalIdNum;
    }

    public void setNationalIdNum(String nationalIdNum)
    {
        this.nationalIdNum = nationalIdNum;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAliasName()
    {
        return aliasName;
    }

    public void setAliasName(String aliasName)
    {
        this.aliasName = aliasName;
    }

    public String getPlaceOfBirth()
    {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth)
    {
        this.placeOfBirth = placeOfBirth;
    }

    public String getCredentialId()
    {
        return credentialId;
    }

    public void setCredentialId(String credentialId)
    {
        this.credentialId = credentialId;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public String getEmplStatus()
    {
        return emplStatus;
    }

    public void setEmplStatus(String emplStatus)
    {
        this.emplStatus = emplStatus;
    }

    public String getDegree()
    {
        return degree;
    }

    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public String getAllFacilitiesYn()
    {
        return allFacilitiesYn;
    }

    public void setAllFacilitiesYn(String allFacilitiesYn)
    {
        this.allFacilitiesYn = allFacilitiesYn;
    }

    public String getOffTelNum()
    {
        return offTelNum;
    }

    public void setOffTelNum(String offTelNum)
    {
        this.offTelNum = offTelNum;
    }

    public String getOffTelExt()
    {
        return offTelExt;
    }

    public void setOffTelExt(String offTelExt)
    {
        this.offTelExt = offTelExt;
    }

    public String getResTelNum()
    {
        return resTelNum;
    }

    public void setResTelNum(String resTelNum)
    {
        this.resTelNum = resTelNum;
    }

    public String getFaxNum()
    {
        return faxNum;
    }

    public void setFaxNum(String faxNum)
    {
        this.faxNum = faxNum;
    }

    public String getMobileNum()
    {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum)
    {
        this.mobileNum = mobileNum;
    }

    public String getPagerNum()
    {
        return pagerNum;
    }

    public void setPagerNum(String pagerNum)
    {
        this.pagerNum = pagerNum;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    public String getPrefContactMode()
    {
        return prefContactMode;
    }

    public void setPrefContactMode(String prefContactMode)
    {
        this.prefContactMode = prefContactMode;
    }

    public String getResAddLn1()
    {
        return resAddLn1;
    }

    public void setResAddLn1(String resAddLn1)
    {
        this.resAddLn1 = resAddLn1;
    }

    public String getResAddLn2()
    {
        return resAddLn2;
    }

    public void setResAddLn2(String resAddLn2)
    {
        this.resAddLn2 = resAddLn2;
    }

    public String getResAddLn3()
    {
        return resAddLn3;
    }

    public void setResAddLn3(String resAddLn3)
    {
        this.resAddLn3 = resAddLn3;
    }

    public String getResAddLn4()
    {
        return resAddLn4;
    }

    public void setResAddLn4(String resAddLn4)
    {
        this.resAddLn4 = resAddLn4;
    }

    public String getResAddPostalCode()
    {
        return resAddPostalCode;
    }

    public void setResAddPostalCode(String resAddPostalCode)
    {
        this.resAddPostalCode = resAddPostalCode;
    }

    public String getOffAddLn1()
    {
        return offAddLn1;
    }

    public void setOffAddLn1(String offAddLn1)
    {
        this.offAddLn1 = offAddLn1;
    }

    public String getOffAddLn2()
    {
        return offAddLn2;
    }

    public void setOffAddLn2(String offAddLn2)
    {
        this.offAddLn2 = offAddLn2;
    }

    public String getOffAddLn3()
    {
        return offAddLn3;
    }

    public void setOffAddLn3(String offAddLn3)
    {
        this.offAddLn3 = offAddLn3;
    }

    public String getOffAddLn4()
    {
        return offAddLn4;
    }

    public void setOffAddLn4(String offAddLn4)
    {
        this.offAddLn4 = offAddLn4;
    }

    public String getOffAddPostalCode()
    {
        return offAddPostalCode;
    }

    public void setOffAddPostalCode(String offAddPostalCode)
    {
        this.offAddPostalCode = offAddPostalCode;
    }

    public String getMailAddLn1()
    {
        return mailAddLn1;
    }

    public void setMailAddLn1(String mailAddLn1)
    {
        this.mailAddLn1 = mailAddLn1;
    }

    public String getMailAddLn2()
    {
        return mailAddLn2;
    }

    public void setMailAddLn2(String mailAddLn2)
    {
        this.mailAddLn2 = mailAddLn2;
    }

    public String getMailAddLn3()
    {
        return mailAddLn3;
    }

    public void setMailAddLn3(String mailAddLn3)
    {
        this.mailAddLn3 = mailAddLn3;
    }

    public String getMailAddLn4()
    {
        return mailAddLn4;
    }

    public void setMailAddLn4(String mailAddLn4)
    {
        this.mailAddLn4 = mailAddLn4;
    }

    public String getMailAddPostalCode()
    {
        return mailAddPostalCode;
    }

    public void setMailAddPostalCode(String mailAddPostalCode)
    {
        this.mailAddPostalCode = mailAddPostalCode;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public Date getEffDateFrom()
    {
        return effDateFrom;
    }

    public void setEffDateFrom(Date effDateFrom)
    {
        this.effDateFrom = effDateFrom;
    }

    public Date getEffDateTo()
    {
        return effDateTo;
    }

    public void setEffDateTo(Date effDateTo)
    {
        this.effDateTo = effDateTo;
    }

    public String getEffStatus()
    {
        return effStatus;
    }

    public void setEffStatus(String effStatus)
    {
        this.effStatus = effStatus;
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

    public String getCredentialId1()
    {
        return credentialId1;
    }

    public void setCredentialId1(String credentialId1)
    {
        this.credentialId1 = credentialId1;
    }

    public String getCredentialId2()
    {
        return credentialId2;
    }

    public void setCredentialId2(String credentialId2)
    {
        this.credentialId2 = credentialId2;
    }

    public String getCredentialId3()
    {
        return credentialId3;
    }

    public void setCredentialId3(String credentialId3)
    {
        this.credentialId3 = credentialId3;
    }

    public String getApcNo()
    {
        return apcNo;
    }

    public void setApcNo(String apcNo)
    {
        this.apcNo = apcNo;
    }

    public String getDegree1()
    {
        return degree1;
    }

    public void setDegree1(String degree1)
    {
        this.degree1 = degree1;
    }

    public String getDegree1Univ()
    {
        return degree1Univ;
    }

    public void setDegree1Univ(String degree1Univ)
    {
        this.degree1Univ = degree1Univ;
    }

    public String getDegree1Year()
    {
        return degree1Year;
    }

    public void setDegree1Year(String degree1Year)
    {
        this.degree1Year = degree1Year;
    }

    public String getDegree2()
    {
        return degree2;
    }

    public void setDegree2(String degree2)
    {
        this.degree2 = degree2;
    }

    public String getDegree2Univ()
    {
        return degree2Univ;
    }

    public void setDegree2Univ(String degree2Univ)
    {
        this.degree2Univ = degree2Univ;
    }

    public String getDegree2Year()
    {
        return degree2Year;
    }

    public void setDegree2Year(String degree2Year)
    {
        this.degree2Year = degree2Year;
    }

    public String getDegree3()
    {
        return degree3;
    }

    public void setDegree3(String degree3)
    {
        this.degree3 = degree3;
    }

    public String getDegree3Univ()
    {
        return degree3Univ;
    }

    public void setDegree3Univ(String degree3Univ)
    {
        this.degree3Univ = degree3Univ;
    }

    public String getDegree3Year()
    {
        return degree3Year;
    }

    public void setDegree3Year(String degree3Year)
    {
        this.degree3Year = degree3Year;
    }

    public String getDegree4()
    {
        return degree4;
    }

    public void setDegree4(String degree4)
    {
        this.degree4 = degree4;
    }

    public String getDegree4Univ()
    {
        return degree4Univ;
    }

    public void setDegree4Univ(String degree4Univ)
    {
        this.degree4Univ = degree4Univ;
    }

    public String getDegree4Year()
    {
        return degree4Year;
    }

    public void setDegree4Year(String degree4Year)
    {
        this.degree4Year = degree4Year;
    }

    public String getReportingServiceCode()
    {
        return reportingServiceCode;
    }

    public void setReportingServiceCode(String reportingServiceCode)
    {
        this.reportingServiceCode = reportingServiceCode;
    }

    public String getTrainingCondBy1()
    {
        return trainingCondBy1;
    }

    public void setTrainingCondBy1(String trainingCondBy1)
    {
        this.trainingCondBy1 = trainingCondBy1;
    }

    public String getTrainingCondBy2()
    {
        return trainingCondBy2;
    }

    public void setTrainingCondBy2(String trainingCondBy2)
    {
        this.trainingCondBy2 = trainingCondBy2;
    }

    public String getTrainingCondBy3()
    {
        return trainingCondBy3;
    }

    public void setTrainingCondBy3(String trainingCondBy3)
    {
        this.trainingCondBy3 = trainingCondBy3;
    }

    public String getTrainingCondBy4()
    {
        return trainingCondBy4;
    }

    public void setTrainingCondBy4(String trainingCondBy4)
    {
        this.trainingCondBy4 = trainingCondBy4;
    }

    public String getTrainingDtls1()
    {
        return trainingDtls1;
    }

    public void setTrainingDtls1(String trainingDtls1)
    {
        this.trainingDtls1 = trainingDtls1;
    }

    public String getTrainingDtls2()
    {
        return trainingDtls2;
    }

    public void setTrainingDtls2(String trainingDtls2)
    {
        this.trainingDtls2 = trainingDtls2;
    }

    public String getTrainingDtls3()
    {
        return trainingDtls3;
    }

    public void setTrainingDtls3(String trainingDtls3)
    {
        this.trainingDtls3 = trainingDtls3;
    }

    public String getTrainingDtls4()
    {
        return trainingDtls4;
    }

    public void setTrainingDtls4(String trainingDtls4)
    {
        this.trainingDtls4 = trainingDtls4;
    }

    public String getPositionCode()
    {
        return positionCode;
    }

    public void setPositionCode(String positionCode)
    {
        this.positionCode = positionCode;
    }

    public String getGradeCode()
    {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode)
    {
        this.gradeCode = gradeCode;
    }

    public Set getAePatMovementLogs()
    {
        return aePatMovementLogs;
    }

    public void setAePatMovementLogs(Set aePatMovementLogs)
    {
        this.aePatMovementLogs = aePatMovementLogs;
    }

    public Set getAePatGcsScores()
    {
        return aePatGcsScores;
    }

    public void setAePatGcsScores(Set aePatGcsScores)
    {
        this.aePatGcsScores = aePatGcsScores;
    }

    public Set getOrOrderLinePhs()
    {
        return orOrderLinePhs;
    }

    public void setOrOrderLinePhs(Set orOrderLinePhs)
    {
        this.orOrderLinePhs = orOrderLinePhs;
    }

    public Set getPrSickLeaveRegisters()
    {
        return prSickLeaveRegisters;
    }

    public void setPrSickLeaveRegisters(Set prSickLeaveRegisters)
    {
        this.prSickLeaveRegisters = prSickLeaveRegisters;
    }

    public Set getFmDeficiencyDtls()
    {
        return fmDeficiencyDtls;
    }

    public void setFmDeficiencyDtls(Set fmDeficiencyDtls)
    {
        this.fmDeficiencyDtls = fmDeficiencyDtls;
    }

    public Set getIpNursingUnitForPracts()
    {
        return ipNursingUnitForPracts;
    }

    public void setIpNursingUnitForPracts(Set ipNursingUnitForPracts)
    {
        this.ipNursingUnitForPracts = ipNursingUnitForPracts;
    }

    public Set getPrEncounterPracts()
    {
        return prEncounterPracts;
    }

    public void setPrEncounterPracts(Set prEncounterPracts)
    {
        this.prEncounterPracts = prEncounterPracts;
    }

    public Set getPrDiagnosisesForOnsetPractitionerId()
    {
        return prDiagnosisesForOnsetPractitionerId;
    }

    public void setPrDiagnosisesForOnsetPractitionerId(Set prDiagnosisesForOnsetPractitionerId)
    {
        this.prDiagnosisesForOnsetPractitionerId = prDiagnosisesForOnsetPractitionerId;
    }

    public Set getPrAllergiesForOnsetPractitionerId()
    {
        return prAllergiesForOnsetPractitionerId;
    }

    public void setPrAllergiesForOnsetPractitionerId(Set prAllergiesForOnsetPractitionerId)
    {
        this.prAllergiesForOnsetPractitionerId = prAllergiesForOnsetPractitionerId;
    }

    public Set getCaTextBlkByServPracts()
    {
        return caTextBlkByServPracts;
    }

    public void setCaTextBlkByServPracts(Set caTextBlkByServPracts)
    {
        this.caTextBlkByServPracts = caTextBlkByServPracts;
    }

    public Set getPrEpisodeOfCaresForOpenPractitionerId()
    {
        return prEpisodeOfCaresForOpenPractitionerId;
    }

    public void setPrEpisodeOfCaresForOpenPractitionerId(Set prEpisodeOfCaresForOpenPractitionerId)
    {
        this.prEpisodeOfCaresForOpenPractitionerId = prEpisodeOfCaresForOpenPractitionerId;
    }

    public Set getAmPractSpecialitieses()
    {
        return amPractSpecialitieses;
    }

    public void setAmPractSpecialitieses(Set amPractSpecialitieses)
    {
        this.amPractSpecialitieses = amPractSpecialitieses;
    }

    public Set getAmPractForTeams()
    {
        return amPractForTeams;
    }

    public void setAmPractForTeams(Set amPractForTeams)
    {
        this.amPractForTeams = amPractForTeams;
    }

    public Set getIpBedBookings()
    {
        return ipBedBookings;
    }

    public void setIpBedBookings(Set ipBedBookings)
    {
        this.ipBedBookings = ipBedBookings;
    }

    public Set getMrReportRequestHdrsForRequestingPractId()
    {
        return mrReportRequestHdrsForRequestingPractId;
    }

    public void setMrReportRequestHdrsForRequestingPractId(Set mrReportRequestHdrsForRequestingPractId)
    {
        this.mrReportRequestHdrsForRequestingPractId = mrReportRequestHdrsForRequestingPractId;
    }

    public Set getAtAnaesthesiaRecordHdrsForAnaesthetistCode()
    {
        return atAnaesthesiaRecordHdrsForAnaesthetistCode;
    }

    public void setAtAnaesthesiaRecordHdrsForAnaesthetistCode(Set atAnaesthesiaRecordHdrsForAnaesthetistCode)
    {
        this.atAnaesthesiaRecordHdrsForAnaesthetistCode = atAnaesthesiaRecordHdrsForAnaesthetistCode;
    }

    public Set getPrEpisodeOfCaresForResolvePractitionerId()
    {
        return prEpisodeOfCaresForResolvePractitionerId;
    }

    public void setPrEpisodeOfCaresForResolvePractitionerId(Set prEpisodeOfCaresForResolvePractitionerId)
    {
        this.prEpisodeOfCaresForResolvePractitionerId = prEpisodeOfCaresForResolvePractitionerId;
    }

    public Set getCpPatCarePlansForStatusPractId()
    {
        return cpPatCarePlansForStatusPractId;
    }

    public void setCpPatCarePlansForStatusPractId(Set cpPatCarePlansForStatusPractId)
    {
        this.cpPatCarePlansForStatusPractId = cpPatCarePlansForStatusPractId;
    }

    public Set getPrEpisodeOfCaresForErrorPractitionerId()
    {
        return prEpisodeOfCaresForErrorPractitionerId;
    }

    public void setPrEpisodeOfCaresForErrorPractitionerId(Set prEpisodeOfCaresForErrorPractitionerId)
    {
        this.prEpisodeOfCaresForErrorPractitionerId = prEpisodeOfCaresForErrorPractitionerId;
    }

    public Set getAeTraumaSecondarySurveies()
    {
        return aeTraumaSecondarySurveies;
    }

    public void setAeTraumaSecondarySurveies(Set aeTraumaSecondarySurveies)
    {
        this.aeTraumaSecondarySurveies = aeTraumaSecondarySurveies;
    }

    public Set getAtAnaesthesiaRecordHdrsForAnaesthetist2Code()
    {
        return atAnaesthesiaRecordHdrsForAnaesthetist2Code;
    }

    public void setAtAnaesthesiaRecordHdrsForAnaesthetist2Code(Set atAnaesthesiaRecordHdrsForAnaesthetist2Code)
    {
        this.atAnaesthesiaRecordHdrsForAnaesthetist2Code = atAnaesthesiaRecordHdrsForAnaesthetist2Code;
    }

    public Set getFmIpPullingLists()
    {
        return fmIpPullingLists;
    }

    public void setFmIpPullingLists(Set fmIpPullingLists)
    {
        this.fmIpPullingLists = fmIpPullingLists;
    }

    public Set getOrPractForConsents()
    {
        return orPractForConsents;
    }

    public void setOrPractForConsents(Set orPractForConsents)
    {
        this.orPractForConsents = orPractForConsents;
    }

    public Set getCpPatGoalEvals()
    {
        return cpPatGoalEvals;
    }

    public void setCpPatGoalEvals(Set cpPatGoalEvals)
    {
        this.cpPatGoalEvals = cpPatGoalEvals;
    }

    public Set getMrDeathRegisterHdrs()
    {
        return mrDeathRegisterHdrs;
    }

    public void setMrDeathRegisterHdrs(Set mrDeathRegisterHdrs)
    {
        this.mrDeathRegisterHdrs = mrDeathRegisterHdrs;
    }

    public Set getPrEncounterProcedures()
    {
        return prEncounterProcedures;
    }

    public void setPrEncounterProcedures(Set prEncounterProcedures)
    {
        this.prEncounterProcedures = prEncounterProcedures;
    }

    public Set getAePatTriagesForPhysicianId()
    {
        return aePatTriagesForPhysicianId;
    }

    public void setAePatTriagesForPhysicianId(Set aePatTriagesForPhysicianId)
    {
        this.aePatTriagesForPhysicianId = aePatTriagesForPhysicianId;
    }

    public Set getIpTransferRequestsForAuthPractitionerId()
    {
        return ipTransferRequestsForAuthPractitionerId;
    }

    public void setIpTransferRequestsForAuthPractitionerId(Set ipTransferRequestsForAuthPractitionerId)
    {
        this.ipTransferRequestsForAuthPractitionerId = ipTransferRequestsForAuthPractitionerId;
    }

    public Set getCpPatCarePlanRevisions()
    {
        return cpPatCarePlanRevisions;
    }

    public void setCpPatCarePlanRevisions(Set cpPatCarePlanRevisions)
    {
        this.cpPatCarePlanRevisions = cpPatCarePlanRevisions;
    }

    public Set getIpBookingLists()
    {
        return ipBookingLists;
    }

    public void setIpBookingLists(Set ipBookingLists)
    {
        this.ipBookingLists = ipBookingLists;
    }

    public Set getPrAllergiesForClosePractitionerId()
    {
        return prAllergiesForClosePractitionerId;
    }

    public void setPrAllergiesForClosePractitionerId(Set prAllergiesForClosePractitionerId)
    {
        this.prAllergiesForClosePractitionerId = prAllergiesForClosePractitionerId;
    }

    public Set getCaPractByLocns()
    {
        return caPractByLocns;
    }

    public void setCaPractByLocns(Set caPractByLocns)
    {
        this.caPractByLocns = caPractByLocns;
    }

    public Set getPrProblemsForOnsetPractitionerId()
    {
        return prProblemsForOnsetPractitionerId;
    }

    public void setPrProblemsForOnsetPractitionerId(Set prProblemsForOnsetPractitionerId)
    {
        this.prProblemsForOnsetPractitionerId = prProblemsForOnsetPractitionerId;
    }

    public Set getCpPatOutcomeEvals()
    {
        return cpPatOutcomeEvals;
    }

    public void setCpPatOutcomeEvals(Set cpPatOutcomeEvals)
    {
        this.cpPatOutcomeEvals = cpPatOutcomeEvals;
    }

    public Set getMrReportRequestHdrsForPreparePractId()
    {
        return mrReportRequestHdrsForPreparePractId;
    }

    public void setMrReportRequestHdrsForPreparePractId(Set mrReportRequestHdrsForPreparePractId)
    {
        this.mrReportRequestHdrsForPreparePractId = mrReportRequestHdrsForPreparePractId;
    }

    public Set getAtAnaesthesiaRecordHdrsForSurgeonCode()
    {
        return atAnaesthesiaRecordHdrsForSurgeonCode;
    }

    public void setAtAnaesthesiaRecordHdrsForSurgeonCode(Set atAnaesthesiaRecordHdrsForSurgeonCode)
    {
        this.atAnaesthesiaRecordHdrsForSurgeonCode = atAnaesthesiaRecordHdrsForSurgeonCode;
    }

    public Set getIpPatientLastEncountersForAttendPractitionerId()
    {
        return ipPatientLastEncountersForAttendPractitionerId;
    }

    public void setIpPatientLastEncountersForAttendPractitionerId(Set ipPatientLastEncountersForAttendPractitionerId)
    {
        this.ipPatientLastEncountersForAttendPractitionerId = ipPatientLastEncountersForAttendPractitionerId;
    }

    public Set getAePatTriagesForNurseId()
    {
        return aePatTriagesForNurseId;
    }

    public void setAePatTriagesForNurseId(Set aePatTriagesForNurseId)
    {
        this.aePatTriagesForNurseId = aePatTriagesForNurseId;
    }

    public Set getAeTraumaPrimarySurveies()
    {
        return aeTraumaPrimarySurveies;
    }

    public void setAeTraumaPrimarySurveies(Set aeTraumaPrimarySurveies)
    {
        this.aeTraumaPrimarySurveies = aeTraumaPrimarySurveies;
    }

    public Set getPrDiagnosisStatuses()
    {
        return prDiagnosisStatuses;
    }

    public void setPrDiagnosisStatuses(Set prDiagnosisStatuses)
    {
        this.prDiagnosisStatuses = prDiagnosisStatuses;
    }

    public Set getPrEncounters()
    {
        return prEncounters;
    }

    public void setPrEncounters(Set prEncounters)
    {
        this.prEncounters = prEncounters;
    }

    public Set getMoMortuaryRegns()
    {
        return moMortuaryRegns;
    }

    public void setMoMortuaryRegns(Set moMortuaryRegns)
    {
        this.moMortuaryRegns = moMortuaryRegns;
    }

    public Set getIpAdtTrnsForToPractitionerId()
    {
        return ipAdtTrnsForToPractitionerId;
    }

    public void setIpAdtTrnsForToPractitionerId(Set ipAdtTrnsForToPractitionerId)
    {
        this.ipAdtTrnsForToPractitionerId = ipAdtTrnsForToPractitionerId;
    }

    public Set getCpPatCarePlanEvals()
    {
        return cpPatCarePlanEvals;
    }

    public void setCpPatCarePlanEvals(Set cpPatCarePlanEvals)
    {
        this.cpPatCarePlanEvals = cpPatCarePlanEvals;
    }

    public Set getOrConsentRefHdrs()
    {
        return orConsentRefHdrs;
    }

    public void setOrConsentRefHdrs(Set orConsentRefHdrs)
    {
        this.orConsentRefHdrs = orConsentRefHdrs;
    }

    public Set getOrOrderSetByIndexes()
    {
        return orOrderSetByIndexes;
    }

    public void setOrOrderSetByIndexes(Set orOrderSetByIndexes)
    {
        this.orOrderSetByIndexes = orOrderSetByIndexes;
    }

    public Set getOrReviewUserCategorieses()
    {
        return orReviewUserCategorieses;
    }

    public void setOrReviewUserCategorieses(Set orReviewUserCategorieses)
    {
        this.orReviewUserCategorieses = orReviewUserCategorieses;
    }

    public Set getPhPatientVaccProfiles()
    {
        return phPatientVaccProfiles;
    }

    public void setPhPatientVaccProfiles(Set phPatientVaccProfiles)
    {
        this.phPatientVaccProfiles = phPatientVaccProfiles;
    }

    public Set getCpPatCarePlanVars()
    {
        return cpPatCarePlanVars;
    }

    public void setCpPatCarePlanVars(Set cpPatCarePlanVars)
    {
        this.cpPatCarePlanVars = cpPatCarePlanVars;
    }

    public Set getOrResultUsers()
    {
        return orResultUsers;
    }

    public void setOrResultUsers(Set orResultUsers)
    {
        this.orResultUsers = orResultUsers;
    }

    public Set getCpPatCarePlansForCreatedPractId()
    {
        return cpPatCarePlansForCreatedPractId;
    }

    public void setCpPatCarePlansForCreatedPractId(Set cpPatCarePlansForCreatedPractId)
    {
        this.cpPatCarePlansForCreatedPractId = cpPatCarePlansForCreatedPractId;
    }

    public Set getMrDiagGroups()
    {
        return mrDiagGroups;
    }

    public void setMrDiagGroups(Set mrDiagGroups)
    {
        this.mrDiagGroups = mrDiagGroups;
    }

    public Set getAePractForTmtAreas()
    {
        return aePractForTmtAreas;
    }

    public void setAePractForTmtAreas(Set aePractForTmtAreas)
    {
        this.aePractForTmtAreas = aePractForTmtAreas;
    }

    public Set getIpTransferRequestsForReqPractitionerId()
    {
        return ipTransferRequestsForReqPractitionerId;
    }

    public void setIpTransferRequestsForReqPractitionerId(Set ipTransferRequestsForReqPractitionerId)
    {
        this.ipTransferRequestsForReqPractitionerId = ipTransferRequestsForReqPractitionerId;
    }

    public Set getPrReferralRegistersForToPractId()
    {
        return prReferralRegistersForToPractId;
    }

    public void setPrReferralRegistersForToPractId(Set prReferralRegistersForToPractId)
    {
        this.prReferralRegistersForToPractId = prReferralRegistersForToPractId;
    }

    public Set getPrReferralRegistersForFromPractId()
    {
        return prReferralRegistersForFromPractId;
    }

    public void setPrReferralRegistersForFromPractId(Set prReferralRegistersForFromPractId)
    {
        this.prReferralRegistersForFromPractId = prReferralRegistersForFromPractId;
    }

    public Set getCaEncntrPractRelns()
    {
        return caEncntrPractRelns;
    }

    public void setCaEncntrPractRelns(Set caEncntrPractRelns)
    {
        this.caEncntrPractRelns = caEncntrPractRelns;
    }

    public Set getIpOpenEncountersForAttendPractitionerId()
    {
        return ipOpenEncountersForAttendPractitionerId;
    }

    public void setIpOpenEncountersForAttendPractitionerId(Set ipOpenEncountersForAttendPractitionerId)
    {
        this.ipOpenEncountersForAttendPractitionerId = ipOpenEncountersForAttendPractitionerId;
    }

    public Set getIpLeaveDetails()
    {
        return ipLeaveDetails;
    }

    public void setIpLeaveDetails(Set ipLeaveDetails)
    {
        this.ipLeaveDetails = ipLeaveDetails;
    }

    public Set getPrProblemsForClosePractitionerId()
    {
        return prProblemsForClosePractitionerId;
    }

    public void setPrProblemsForClosePractitionerId(Set prProblemsForClosePractitionerId)
    {
        this.prProblemsForClosePractitionerId = prProblemsForClosePractitionerId;
    }

    public Set getAtAnaesthesiaRecordHdrsForAnaesthetist1Code()
    {
        return atAnaesthesiaRecordHdrsForAnaesthetist1Code;
    }

    public void setAtAnaesthesiaRecordHdrsForAnaesthetist1Code(Set atAnaesthesiaRecordHdrsForAnaesthetist1Code)
    {
        this.atAnaesthesiaRecordHdrsForAnaesthetist1Code = atAnaesthesiaRecordHdrsForAnaesthetist1Code;
    }

    public Set getCpPatCarePlansForFinalizedPractId()
    {
        return cpPatCarePlansForFinalizedPractId;
    }

    public void setCpPatCarePlansForFinalizedPractId(Set cpPatCarePlansForFinalizedPractId)
    {
        this.cpPatCarePlansForFinalizedPractId = cpPatCarePlansForFinalizedPractId;
    }

    public Set getIpAdtTrnsForFrPractitionerId()
    {
        return ipAdtTrnsForFrPractitionerId;
    }

    public void setIpAdtTrnsForFrPractitionerId(Set ipAdtTrnsForFrPractitionerId)
    {
        this.ipAdtTrnsForFrPractitionerId = ipAdtTrnsForFrPractitionerId;
    }

    public Set getIpPatientLastEncountersForAdmitPractitionerId()
    {
        return ipPatientLastEncountersForAdmitPractitionerId;
    }

    public void setIpPatientLastEncountersForAdmitPractitionerId(Set ipPatientLastEncountersForAdmitPractitionerId)
    {
        this.ipPatientLastEncountersForAdmitPractitionerId = ipPatientLastEncountersForAdmitPractitionerId;
    }

    public Set getCpPatTermCodeEvals()
    {
        return cpPatTermCodeEvals;
    }

    public void setCpPatTermCodeEvals(Set cpPatTermCodeEvals)
    {
        this.cpPatTermCodeEvals = cpPatTermCodeEvals;
    }

    public Set getIpOpenEncountersForAdmitPractitionerId()
    {
        return ipOpenEncountersForAdmitPractitionerId;
    }

    public void setIpOpenEncountersForAdmitPractitionerId(Set ipOpenEncountersForAdmitPractitionerId)
    {
        this.ipOpenEncountersForAdmitPractitionerId = ipOpenEncountersForAdmitPractitionerId;
    }

    public Set getAmPractForFacilities()
    {
        return amPractForFacilities;
    }

    public void setAmPractForFacilities(Set amPractForFacilities)
    {
        this.amPractForFacilities = amPractForFacilities;
    }

    public Set getCpPatCarePlanManagers()
    {
        return cpPatCarePlanManagers;
    }

    public void setCpPatCarePlanManagers(Set cpPatCarePlanManagers)
    {
        this.cpPatCarePlanManagers = cpPatCarePlanManagers;
    }

    public Set getMrTermSetForPracts()
    {
        return mrTermSetForPracts;
    }

    public void setMrTermSetForPracts(Set mrTermSetForPracts)
    {
        this.mrTermSetForPracts = mrTermSetForPracts;
    }

    public Set getPrDiagnosisesForCurrPractitionerId()
    {
        return prDiagnosisesForCurrPractitionerId;
    }

    public void setPrDiagnosisesForCurrPractitionerId(Set prDiagnosisesForCurrPractitionerId)
    {
        this.prDiagnosisesForCurrPractitionerId = prDiagnosisesForCurrPractitionerId;
    }

    private String practitionerId;
    private MpCountry mpCountryByResAddCountryCode;
    private SmFacilityParam smFacilityParam;
    private AmPractType amPractType;
    private MpMaritalStatus mpMaritalStatus;
    private MpCountry mpCountryByOffAddCountryCode;
    private AmSpeciality amSpeciality;
    private MpCountry mpCountryByMailAddCountryCode;
    private MpCountry mpCountryByCitizenshipCode;
    private String practitionerName;
    private String shortName;
    private String nationalIdNum;
    private String gender;
    private Date dateOfBirth;
    private String aliasName;
    private String placeOfBirth;
    private String credentialId;
    private String jobTitle;
    private String emplStatus;
    private String degree;
    private String allFacilitiesYn;
    private String offTelNum;
    private String offTelExt;
    private String resTelNum;
    private String faxNum;
    private String mobileNum;
    private String pagerNum;
    private String emailId;
    private String prefContactMode;
    private String resAddLn1;
    private String resAddLn2;
    private String resAddLn3;
    private String resAddLn4;
    private String resAddPostalCode;
    private String offAddLn1;
    private String offAddLn2;
    private String offAddLn3;
    private String offAddLn4;
    private String offAddPostalCode;
    private String mailAddLn1;
    private String mailAddLn2;
    private String mailAddLn3;
    private String mailAddLn4;
    private String mailAddPostalCode;
    private String employeeId;
    private Date effDateFrom;
    private Date effDateTo;
    private String effStatus;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
    private String credentialId1;
    private String credentialId2;
    private String credentialId3;
    private String apcNo;
    private String degree1;
    private String degree1Univ;
    private String degree1Year;
    private String degree2;
    private String degree2Univ;
    private String degree2Year;
    private String degree3;
    private String degree3Univ;
    private String degree3Year;
    private String degree4;
    private String degree4Univ;
    private String degree4Year;
    private String reportingServiceCode;
    private String trainingCondBy1;
    private String trainingCondBy2;
    private String trainingCondBy3;
    private String trainingCondBy4;
    private String trainingDtls1;
    private String trainingDtls2;
    private String trainingDtls3;
    private String trainingDtls4;
    private String positionCode;
    private String gradeCode;
    private Set aePatMovementLogs;
    private Set aePatGcsScores;
    private Set orOrderLinePhs;
    private Set prSickLeaveRegisters;
    private Set fmDeficiencyDtls;
    private Set ipNursingUnitForPracts;
    private Set prEncounterPracts;
    private Set prDiagnosisesForOnsetPractitionerId;
    private Set prAllergiesForOnsetPractitionerId;
    private Set caTextBlkByServPracts;
    private Set prEpisodeOfCaresForOpenPractitionerId;
    private Set amPractSpecialitieses;
    private Set amPractForTeams;
    private Set ipBedBookings;
    private Set mrReportRequestHdrsForRequestingPractId;
    private Set atAnaesthesiaRecordHdrsForAnaesthetistCode;
    private Set prEpisodeOfCaresForResolvePractitionerId;
    private Set cpPatCarePlansForStatusPractId;
    private Set prEpisodeOfCaresForErrorPractitionerId;
    private Set aeTraumaSecondarySurveies;
    private Set atAnaesthesiaRecordHdrsForAnaesthetist2Code;
    private Set fmIpPullingLists;
    private Set orPractForConsents;
    private Set cpPatGoalEvals;
    private Set mrDeathRegisterHdrs;
    private Set prEncounterProcedures;
    private Set aePatTriagesForPhysicianId;
    private Set ipTransferRequestsForAuthPractitionerId;
    private Set cpPatCarePlanRevisions;
    private Set ipBookingLists;
    private Set prAllergiesForClosePractitionerId;
    private Set caPractByLocns;
    private Set prProblemsForOnsetPractitionerId;
    private Set cpPatOutcomeEvals;
    private Set mrReportRequestHdrsForPreparePractId;
    private Set atAnaesthesiaRecordHdrsForSurgeonCode;
    private Set ipPatientLastEncountersForAttendPractitionerId;
    private Set aePatTriagesForNurseId;
    private Set aeTraumaPrimarySurveies;
    private Set prDiagnosisStatuses;
    private Set prEncounters;
    private Set moMortuaryRegns;
    private Set ipAdtTrnsForToPractitionerId;
    private Set cpPatCarePlanEvals;
    private Set orConsentRefHdrs;
    private Set orOrderSetByIndexes;
    private Set orReviewUserCategorieses;
    private Set phPatientVaccProfiles;
    private Set cpPatCarePlanVars;
    private Set orResultUsers;
    private Set cpPatCarePlansForCreatedPractId;
    private Set mrDiagGroups;
    private Set aePractForTmtAreas;
    private Set ipTransferRequestsForReqPractitionerId;
    private Set prReferralRegistersForToPractId;
    private Set prReferralRegistersForFromPractId;
    private Set caEncntrPractRelns;
    private Set ipOpenEncountersForAttendPractitionerId;
    private Set ipLeaveDetails;
    private Set prProblemsForClosePractitionerId;
    private Set atAnaesthesiaRecordHdrsForAnaesthetist1Code;
    private Set cpPatCarePlansForFinalizedPractId;
    private Set ipAdtTrnsForFrPractitionerId;
    private Set ipPatientLastEncountersForAdmitPractitionerId;
    private Set cpPatTermCodeEvals;
    private Set ipOpenEncountersForAdmitPractitionerId;
    private Set amPractForFacilities;
    private Set cpPatCarePlanManagers;
    private Set mrTermSetForPracts;
    private Set prDiagnosisesForCurrPractitionerId;
}
