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
//            SmFacilityParam, MpNamePrefix, MpRace, MpRegion, 
//            MpAlternateIdType, MpContactMode, MpNameSuffix, MpReligion, 
//            MpResTown, MpRelationship, AmReferral, MpPatCategory, 
//            MpPatSuspReason, MpCountry, MpPatSerGrp, MpMaritalStatus, 
//            MpResArea

public class MpPatient
    implements Serializable
{

    public MpPatient()
    {
        prPatientValuableses = new HashSet(0);
        cpPatCarePlanOutcomes = new HashSet(0);
        ipTransferRequests = new HashSet(0);
        mpBirthRegistersForMotherPatientId = new HashSet(0);
        prProblemAssessments = new HashSet(0);
        caPatTaskLists = new HashSet(0);
        ipNursingUnitBedsForMothersPatientId = new HashSet(0);
        oaApptDelTrs = new HashSet(0);
        moBedForAreas = new HashSet(0);
        ipAdtTrnAuditLogs = new HashSet(0);
        aeSpareBayses = new HashSet(0);
        cpPatCarePlanRevisions = new HashSet(0);
        opPatientTrackingLocns = new HashSet(0);
        mrMedEventLogs = new HashSet(0);
        dsEpsdDietProfileHdrs = new HashSet(0);
        prHighRiskConditions = new HashSet(0);
        ipBedBookings = new HashSet(0);
        aeBedForTrmtAreas = new HashSet(0);
        ipPatientLastEncounters = new HashSet(0);
        fmPullingLists = new HashSet(0);
        cpPatCarePlanGoals = new HashSet(0);
        prSickLeaveRegisters = new HashSet(0);
        prAdvDrugReactions = new HashSet(0);
        mrPatOtherMedInfos = new HashSet(0);
        ipAdtTrns = new HashSet(0);
        prDiagnosises = new HashSet(0);
        cpPatCarePlanIntvns = new HashSet(0);
        moMortuaryRegns = new HashSet(0);
        mpPatAddresseses = new HashSet(0);
        mpPatDocumentses = new HashSet(0);
        atAnaesthesiaRecordHdrs = new HashSet(0);
        aeCurrentPatients = new HashSet(0);
        oaAppts = new HashSet(0);
        fmTransitFiles = new HashSet(0);
        opPatientQueues = new HashSet(0);
        mpPatOthDtlses = new HashSet(0);
        mpBirthRegistersForFatherPatientId = new HashSet(0);
        cpPatCarePlanManagers = new HashSet(0);
        mrReportRequestHdrs = new HashSet(0);
        ipNursingUnitBedsForOccupyingPatientId = new HashSet(0);
        prPorterageDetailses = new HashSet(0);
        caEncntrDiscrMsrs = new HashSet(0);
        mrPatFileIndexes = new HashSet(0);
        fmMovementLogs = new HashSet(0);
        cpPatCarePlanIntvnDtls = new HashSet(0);
        orConsentRefHdrs = new HashSet(0);
        prWaitLists = new HashSet(0);
        mpPatRelContactses = new HashSet(0);
        opCurrentPatients = new HashSet(0);
        otPostOperHdrs = new HashSet(0);
        caEncntrPractRelns = new HashSet(0);
        mpPatientPhotos = new HashSet(0);
        cpPatMdCarePlans = new HashSet(0);
        cpPatCarePlans = new HashSet(0);
        ipOpenEncounters = new HashSet(0);
        mrReportRequestDtls = new HashSet(0);
        mrReportRequestRevDtls = new HashSet(0);
        prEpisodeOfCares = new HashSet(0);
        fmIpPullingLists = new HashSet(0);
        cpPatCarePlanTermCodes = new HashSet(0);
        prReferralRegisters = new HashSet(0);
        opLastVisitForServices = new HashSet(0);
        phPatientVaccProfiles = new HashSet(0);
        prEncounterProcedures = new HashSet(0);
        prEncounters = new HashSet(0);
        phPatientDrugProfiles = new HashSet(0);
    }

    public MpPatient(String patientId, SmFacilityParam smFacilityParamByRegnFacilityId, MpPatSerGrp mpPatSerGrp, String patientName, String sex, Date dateOfBirth, String calculatedAgeYn, 
            String emegRegnYn, String inhouseBirthYn, String activeYn, String suspendYn, String deceasedYn, String addedById, Date addedDate, 
            String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, String bedAssignedForNbYn, 
            String citizenYn, String legalYn, String patDtlsUnknownYn, String disasterRegnYn, String patPhotoInDbYn, String registeredInMoYn)
    {
        prPatientValuableses = new HashSet(0);
        cpPatCarePlanOutcomes = new HashSet(0);
        ipTransferRequests = new HashSet(0);
        mpBirthRegistersForMotherPatientId = new HashSet(0);
        prProblemAssessments = new HashSet(0);
        caPatTaskLists = new HashSet(0);
        ipNursingUnitBedsForMothersPatientId = new HashSet(0);
        oaApptDelTrs = new HashSet(0);
        moBedForAreas = new HashSet(0);
        ipAdtTrnAuditLogs = new HashSet(0);
        aeSpareBayses = new HashSet(0);
        cpPatCarePlanRevisions = new HashSet(0);
        opPatientTrackingLocns = new HashSet(0);
        mrMedEventLogs = new HashSet(0);
        dsEpsdDietProfileHdrs = new HashSet(0);
        prHighRiskConditions = new HashSet(0);
        ipBedBookings = new HashSet(0);
        aeBedForTrmtAreas = new HashSet(0);
        ipPatientLastEncounters = new HashSet(0);
        fmPullingLists = new HashSet(0);
        cpPatCarePlanGoals = new HashSet(0);
        prSickLeaveRegisters = new HashSet(0);
        prAdvDrugReactions = new HashSet(0);
        mrPatOtherMedInfos = new HashSet(0);
        ipAdtTrns = new HashSet(0);
        prDiagnosises = new HashSet(0);
        cpPatCarePlanIntvns = new HashSet(0);
        moMortuaryRegns = new HashSet(0);
        mpPatAddresseses = new HashSet(0);
        mpPatDocumentses = new HashSet(0);
        atAnaesthesiaRecordHdrs = new HashSet(0);
        aeCurrentPatients = new HashSet(0);
        oaAppts = new HashSet(0);
        fmTransitFiles = new HashSet(0);
        opPatientQueues = new HashSet(0);
        mpPatOthDtlses = new HashSet(0);
        mpBirthRegistersForFatherPatientId = new HashSet(0);
        cpPatCarePlanManagers = new HashSet(0);
        mrReportRequestHdrs = new HashSet(0);
        ipNursingUnitBedsForOccupyingPatientId = new HashSet(0);
        prPorterageDetailses = new HashSet(0);
        caEncntrDiscrMsrs = new HashSet(0);
        mrPatFileIndexes = new HashSet(0);
        fmMovementLogs = new HashSet(0);
        cpPatCarePlanIntvnDtls = new HashSet(0);
        orConsentRefHdrs = new HashSet(0);
        prWaitLists = new HashSet(0);
        mpPatRelContactses = new HashSet(0);
        opCurrentPatients = new HashSet(0);
        otPostOperHdrs = new HashSet(0);
        caEncntrPractRelns = new HashSet(0);
        mpPatientPhotos = new HashSet(0);
        cpPatMdCarePlans = new HashSet(0);
        cpPatCarePlans = new HashSet(0);
        ipOpenEncounters = new HashSet(0);
        mrReportRequestDtls = new HashSet(0);
        mrReportRequestRevDtls = new HashSet(0);
        prEpisodeOfCares = new HashSet(0);
        fmIpPullingLists = new HashSet(0);
        cpPatCarePlanTermCodes = new HashSet(0);
        prReferralRegisters = new HashSet(0);
        opLastVisitForServices = new HashSet(0);
        phPatientVaccProfiles = new HashSet(0);
        prEncounterProcedures = new HashSet(0);
        prEncounters = new HashSet(0);
        phPatientDrugProfiles = new HashSet(0);
        this.patientId = patientId;
        this.smFacilityParamByRegnFacilityId = smFacilityParamByRegnFacilityId;
        this.mpPatSerGrp = mpPatSerGrp;
        this.patientName = patientName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.calculatedAgeYn = calculatedAgeYn;
        this.emegRegnYn = emegRegnYn;
        this.inhouseBirthYn = inhouseBirthYn;
        this.activeYn = activeYn;
        this.suspendYn = suspendYn;
        this.deceasedYn = deceasedYn;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.bedAssignedForNbYn = bedAssignedForNbYn;
        this.citizenYn = citizenYn;
        this.legalYn = legalYn;
        this.patDtlsUnknownYn = patDtlsUnknownYn;
        this.disasterRegnYn = disasterRegnYn;
        this.patPhotoInDbYn = patPhotoInDbYn;
        this.registeredInMoYn = registeredInMoYn;
    }

    public MpPatient(String patientId, SmFacilityParam smFacilityParamByRegnFacilityId, MpNamePrefix mpNamePrefix, MpRace mpRace, MpRegion mpRegion, MpAlternateIdType mpAlternateIdTypeByAltId2Type, MpAlternateIdType mpAlternateIdTypeByAltId1Type, 
            MpContactMode mpContactModeByContact5Mode, MpNameSuffix mpNameSuffix, SmFacilityParam smFacilityParamByPrefFacilityId, MpAlternateIdType mpAlternateIdTypeByAltId4Type, MpReligion mpReligion, MpResTown mpResTown, MpRelationship mpRelationship, 
            AmReferral amReferral, MpContactMode mpContactModeByContact4Mode, MpContactMode mpContactModeByContact3Mode, MpPatCategory mpPatCategory, MpAlternateIdType mpAlternateIdTypeByAltId3Type, MpPatSuspReason mpPatSuspReason, MpContactMode mpContactModeByContact2Mode, 
            MpCountry mpCountry, MpPatSerGrp mpPatSerGrp, MpMaritalStatus mpMaritalStatus, MpContactMode mpContactModeByContact1Mode, MpResArea mpResArea, Date regnDate, String oldPatientId, 
            String nationalIdNo, String altId1No, Date altId1ExpDate, String altId2No, Date altId2ExpDate, String altId3No, Date altId3ExpDate, 
            String altId4No, Date altId4ExpDate, Long newbornIdNoSuffix, String dataSource, String contact1Status, String contact1No, String contact2Status, 
            String contact2No, String contact3Status, String contact3No, String contact4Status, String contact4No, String contact5Status, String contact5No, 
            String emailId, String resTownDesc, String familyOrgId, String familyLinkNo, String firstName, String secondName, String thirdName, 
            String familyNamePrefix, String familyName, String patientName, String namePrefixLocLang, String firstNameLocLang, String secondNameLocLang, String thirdNameLocLang, 
            String familyNameLocLang, String nameSuffixLocLang, String patientNameLocLang, String genericSndxFirst, String genericSndxSecond, String genericSndxThird, String genericSndxFamily, 
            String genericSndxFirstSecond, String genericSndxFirstFamily, String ethnicSndxFirst, String ethnicSndxSecond, String ethnicSndxThird, String ethnicSndxFamily, String ethnicSndxFirstSecond, 
            String ethnicSndxFirstFamily, String sex, Date dateOfBirth, String calculatedAgeYn, String aliasName, String motherMaidenName, String publicityLevel, 
            String protectionInd, String codedPseudoName, String ethnicGrpCode, String relgnSectCode, String placeOfBirth, String primaryLanguageId, String splHandlingCode, 
            String referralFacilityId, String refPhysicianId, String primaryCarePhysicianId, String guarantorType, String patGuarantorYn, String guarantorId, String guarantorName, 
            String guarantorRelnCode, Long annualFamilyIncome, Long householdSize, Long familyAssetsValue, String financialClass, String studentInd, String slmtInd, 
            String slmtTypeCode, String slmtDocRef, Date slmtDocDate, String slmtDocRemarks, String emegRegnYn, String inhouseBirthYn, String generalAlert, 
            String activeYn, String suspendYn, String statusRemarks, String inactActReasonCode, String inactActRemarks, Date lastContactDate, String deceasedYn, 
            Date deceasedDate, String deathStatusRemarks, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, 
            Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, String bedAssignedForNbYn, String birthPlaceCode, String citizenYn, String legalYn, 
            String othAltIdNo, String othAltIdType, String patDtlsUnknownYn, String disasterRegnYn, String patPhotoInDbYn, String registeredInMoYn, String deceasedFacilityId, 
            Long deceasedEncounterId, String familyOrgSubId, String familyOrgMembership, Date patCatCodeExpDate, String motherPatientId, String fatherPatientId, String practitionerId, 
            String sourceType, String sourceCode, Set prPatientValuableses, Set cpPatCarePlanOutcomes, Set ipTransferRequests, Set mpBirthRegistersForMotherPatientId, Set prProblemAssessments, 
            Set caPatTaskLists, Set ipNursingUnitBedsForMothersPatientId, Set oaApptDelTrs, Set moBedForAreas, Set ipAdtTrnAuditLogs, Set aeSpareBayses, Set cpPatCarePlanRevisions, 
            Set opPatientTrackingLocns, Set mrMedEventLogs, Set dsEpsdDietProfileHdrs, Set prHighRiskConditions, Set ipBedBookings, Set aeBedForTrmtAreas, Set ipPatientLastEncounters, 
            Set fmPullingLists, Set cpPatCarePlanGoals, Set prSickLeaveRegisters, Set prAdvDrugReactions, Set mrPatOtherMedInfos, Set ipAdtTrns, Set prDiagnosises, 
            Set cpPatCarePlanIntvns, Set moMortuaryRegns, Set mpPatAddresseses, Set mpPatDocumentses, Set atAnaesthesiaRecordHdrs, Set aeCurrentPatients, Set oaAppts, 
            Set fmTransitFiles, Set opPatientQueues, Set mpPatOthDtlses, Set mpBirthRegistersForFatherPatientId, Set cpPatCarePlanManagers, Set mrReportRequestHdrs, Set ipNursingUnitBedsForOccupyingPatientId, 
            Set prPorterageDetailses, Set caEncntrDiscrMsrs, Set mrPatFileIndexes, Set fmMovementLogs, Set cpPatCarePlanIntvnDtls, Set orConsentRefHdrs, Set prWaitLists, 
            Set mpPatRelContactses, Set opCurrentPatients, Set otPostOperHdrs, Set caEncntrPractRelns, Set mpPatientPhotos, Set cpPatMdCarePlans, Set cpPatCarePlans, 
            Set ipOpenEncounters, Set mrReportRequestDtls, Set mrReportRequestRevDtls, Set prEpisodeOfCares, Set fmIpPullingLists, Set cpPatCarePlanTermCodes, Set prReferralRegisters, 
            Set opLastVisitForServices, Set phPatientVaccProfiles, Set prEncounterProcedures, Set prEncounters, Set phPatientDrugProfiles)
    {
        this.prPatientValuableses = new HashSet(0);
        this.cpPatCarePlanOutcomes = new HashSet(0);
        this.ipTransferRequests = new HashSet(0);
        this.mpBirthRegistersForMotherPatientId = new HashSet(0);
        this.prProblemAssessments = new HashSet(0);
        this.caPatTaskLists = new HashSet(0);
        this.ipNursingUnitBedsForMothersPatientId = new HashSet(0);
        this.oaApptDelTrs = new HashSet(0);
        this.moBedForAreas = new HashSet(0);
        this.ipAdtTrnAuditLogs = new HashSet(0);
        this.aeSpareBayses = new HashSet(0);
        this.cpPatCarePlanRevisions = new HashSet(0);
        this.opPatientTrackingLocns = new HashSet(0);
        this.mrMedEventLogs = new HashSet(0);
        this.dsEpsdDietProfileHdrs = new HashSet(0);
        this.prHighRiskConditions = new HashSet(0);
        this.ipBedBookings = new HashSet(0);
        this.aeBedForTrmtAreas = new HashSet(0);
        this.ipPatientLastEncounters = new HashSet(0);
        this.fmPullingLists = new HashSet(0);
        this.cpPatCarePlanGoals = new HashSet(0);
        this.prSickLeaveRegisters = new HashSet(0);
        this.prAdvDrugReactions = new HashSet(0);
        this.mrPatOtherMedInfos = new HashSet(0);
        this.ipAdtTrns = new HashSet(0);
        this.prDiagnosises = new HashSet(0);
        this.cpPatCarePlanIntvns = new HashSet(0);
        this.moMortuaryRegns = new HashSet(0);
        this.mpPatAddresseses = new HashSet(0);
        this.mpPatDocumentses = new HashSet(0);
        this.atAnaesthesiaRecordHdrs = new HashSet(0);
        this.aeCurrentPatients = new HashSet(0);
        this.oaAppts = new HashSet(0);
        this.fmTransitFiles = new HashSet(0);
        this.opPatientQueues = new HashSet(0);
        this.mpPatOthDtlses = new HashSet(0);
        this.mpBirthRegistersForFatherPatientId = new HashSet(0);
        this.cpPatCarePlanManagers = new HashSet(0);
        this.mrReportRequestHdrs = new HashSet(0);
        this.ipNursingUnitBedsForOccupyingPatientId = new HashSet(0);
        this.prPorterageDetailses = new HashSet(0);
        this.caEncntrDiscrMsrs = new HashSet(0);
        this.mrPatFileIndexes = new HashSet(0);
        this.fmMovementLogs = new HashSet(0);
        this.cpPatCarePlanIntvnDtls = new HashSet(0);
        this.orConsentRefHdrs = new HashSet(0);
        this.prWaitLists = new HashSet(0);
        this.mpPatRelContactses = new HashSet(0);
        this.opCurrentPatients = new HashSet(0);
        this.otPostOperHdrs = new HashSet(0);
        this.caEncntrPractRelns = new HashSet(0);
        this.mpPatientPhotos = new HashSet(0);
        this.cpPatMdCarePlans = new HashSet(0);
        this.cpPatCarePlans = new HashSet(0);
        this.ipOpenEncounters = new HashSet(0);
        this.mrReportRequestDtls = new HashSet(0);
        this.mrReportRequestRevDtls = new HashSet(0);
        this.prEpisodeOfCares = new HashSet(0);
        this.fmIpPullingLists = new HashSet(0);
        this.cpPatCarePlanTermCodes = new HashSet(0);
        this.prReferralRegisters = new HashSet(0);
        this.opLastVisitForServices = new HashSet(0);
        this.phPatientVaccProfiles = new HashSet(0);
        this.prEncounterProcedures = new HashSet(0);
        this.prEncounters = new HashSet(0);
        this.phPatientDrugProfiles = new HashSet(0);
        this.patientId = patientId;
        this.smFacilityParamByRegnFacilityId = smFacilityParamByRegnFacilityId;
        this.mpNamePrefix = mpNamePrefix;
        this.mpRace = mpRace;
        this.mpRegion = mpRegion;
        this.mpAlternateIdTypeByAltId2Type = mpAlternateIdTypeByAltId2Type;
        this.mpAlternateIdTypeByAltId1Type = mpAlternateIdTypeByAltId1Type;
        this.mpContactModeByContact5Mode = mpContactModeByContact5Mode;
        this.mpNameSuffix = mpNameSuffix;
        this.smFacilityParamByPrefFacilityId = smFacilityParamByPrefFacilityId;
        this.mpAlternateIdTypeByAltId4Type = mpAlternateIdTypeByAltId4Type;
        this.mpReligion = mpReligion;
        this.mpResTown = mpResTown;
        this.mpRelationship = mpRelationship;
        this.amReferral = amReferral;
        this.mpContactModeByContact4Mode = mpContactModeByContact4Mode;
        this.mpContactModeByContact3Mode = mpContactModeByContact3Mode;
        this.mpPatCategory = mpPatCategory;
        this.mpAlternateIdTypeByAltId3Type = mpAlternateIdTypeByAltId3Type;
        this.mpPatSuspReason = mpPatSuspReason;
        this.mpContactModeByContact2Mode = mpContactModeByContact2Mode;
        this.mpCountry = mpCountry;
        this.mpPatSerGrp = mpPatSerGrp;
        this.mpMaritalStatus = mpMaritalStatus;
        this.mpContactModeByContact1Mode = mpContactModeByContact1Mode;
        this.mpResArea = mpResArea;
        this.regnDate = regnDate;
        this.oldPatientId = oldPatientId;
        this.nationalIdNo = nationalIdNo;
        this.altId1No = altId1No;
        this.altId1ExpDate = altId1ExpDate;
        this.altId2No = altId2No;
        this.altId2ExpDate = altId2ExpDate;
        this.altId3No = altId3No;
        this.altId3ExpDate = altId3ExpDate;
        this.altId4No = altId4No;
        this.altId4ExpDate = altId4ExpDate;
        this.newbornIdNoSuffix = newbornIdNoSuffix;
        this.dataSource = dataSource;
        this.contact1Status = contact1Status;
        this.contact1No = contact1No;
        this.contact2Status = contact2Status;
        this.contact2No = contact2No;
        this.contact3Status = contact3Status;
        this.contact3No = contact3No;
        this.contact4Status = contact4Status;
        this.contact4No = contact4No;
        this.contact5Status = contact5Status;
        this.contact5No = contact5No;
        this.emailId = emailId;
        this.resTownDesc = resTownDesc;
        this.familyOrgId = familyOrgId;
        this.familyLinkNo = familyLinkNo;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.familyNamePrefix = familyNamePrefix;
        this.familyName = familyName;
        this.patientName = patientName;
        this.namePrefixLocLang = namePrefixLocLang;
        this.firstNameLocLang = firstNameLocLang;
        this.secondNameLocLang = secondNameLocLang;
        this.thirdNameLocLang = thirdNameLocLang;
        this.familyNameLocLang = familyNameLocLang;
        this.nameSuffixLocLang = nameSuffixLocLang;
        this.patientNameLocLang = patientNameLocLang;
        this.genericSndxFirst = genericSndxFirst;
        this.genericSndxSecond = genericSndxSecond;
        this.genericSndxThird = genericSndxThird;
        this.genericSndxFamily = genericSndxFamily;
        this.genericSndxFirstSecond = genericSndxFirstSecond;
        this.genericSndxFirstFamily = genericSndxFirstFamily;
        this.ethnicSndxFirst = ethnicSndxFirst;
        this.ethnicSndxSecond = ethnicSndxSecond;
        this.ethnicSndxThird = ethnicSndxThird;
        this.ethnicSndxFamily = ethnicSndxFamily;
        this.ethnicSndxFirstSecond = ethnicSndxFirstSecond;
        this.ethnicSndxFirstFamily = ethnicSndxFirstFamily;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.calculatedAgeYn = calculatedAgeYn;
        this.aliasName = aliasName;
        this.motherMaidenName = motherMaidenName;
        this.publicityLevel = publicityLevel;
        this.protectionInd = protectionInd;
        this.codedPseudoName = codedPseudoName;
        this.ethnicGrpCode = ethnicGrpCode;
        this.relgnSectCode = relgnSectCode;
        this.placeOfBirth = placeOfBirth;
        this.primaryLanguageId = primaryLanguageId;
        this.splHandlingCode = splHandlingCode;
        this.referralFacilityId = referralFacilityId;
        this.refPhysicianId = refPhysicianId;
        this.primaryCarePhysicianId = primaryCarePhysicianId;
        this.guarantorType = guarantorType;
        this.patGuarantorYn = patGuarantorYn;
        this.guarantorId = guarantorId;
        this.guarantorName = guarantorName;
        this.guarantorRelnCode = guarantorRelnCode;
        this.annualFamilyIncome = annualFamilyIncome;
        this.householdSize = householdSize;
        this.familyAssetsValue = familyAssetsValue;
        this.financialClass = financialClass;
        this.studentInd = studentInd;
        this.slmtInd = slmtInd;
        this.slmtTypeCode = slmtTypeCode;
        this.slmtDocRef = slmtDocRef;
        this.slmtDocDate = slmtDocDate;
        this.slmtDocRemarks = slmtDocRemarks;
        this.emegRegnYn = emegRegnYn;
        this.inhouseBirthYn = inhouseBirthYn;
        this.generalAlert = generalAlert;
        this.activeYn = activeYn;
        this.suspendYn = suspendYn;
        this.statusRemarks = statusRemarks;
        this.inactActReasonCode = inactActReasonCode;
        this.inactActRemarks = inactActRemarks;
        this.lastContactDate = lastContactDate;
        this.deceasedYn = deceasedYn;
        this.deceasedDate = deceasedDate;
        this.deathStatusRemarks = deathStatusRemarks;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.bedAssignedForNbYn = bedAssignedForNbYn;
        this.birthPlaceCode = birthPlaceCode;
        this.citizenYn = citizenYn;
        this.legalYn = legalYn;
        this.othAltIdNo = othAltIdNo;
        this.othAltIdType = othAltIdType;
        this.patDtlsUnknownYn = patDtlsUnknownYn;
        this.disasterRegnYn = disasterRegnYn;
        this.patPhotoInDbYn = patPhotoInDbYn;
        this.registeredInMoYn = registeredInMoYn;
        this.deceasedFacilityId = deceasedFacilityId;
        this.deceasedEncounterId = deceasedEncounterId;
        this.familyOrgSubId = familyOrgSubId;
        this.familyOrgMembership = familyOrgMembership;
        this.patCatCodeExpDate = patCatCodeExpDate;
        this.motherPatientId = motherPatientId;
        this.fatherPatientId = fatherPatientId;
        this.practitionerId = practitionerId;
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.prPatientValuableses = prPatientValuableses;
        this.cpPatCarePlanOutcomes = cpPatCarePlanOutcomes;
        this.ipTransferRequests = ipTransferRequests;
        this.mpBirthRegistersForMotherPatientId = mpBirthRegistersForMotherPatientId;
        this.prProblemAssessments = prProblemAssessments;
        this.caPatTaskLists = caPatTaskLists;
        this.ipNursingUnitBedsForMothersPatientId = ipNursingUnitBedsForMothersPatientId;
        this.oaApptDelTrs = oaApptDelTrs;
        this.moBedForAreas = moBedForAreas;
        this.ipAdtTrnAuditLogs = ipAdtTrnAuditLogs;
        this.aeSpareBayses = aeSpareBayses;
        this.cpPatCarePlanRevisions = cpPatCarePlanRevisions;
        this.opPatientTrackingLocns = opPatientTrackingLocns;
        this.mrMedEventLogs = mrMedEventLogs;
        this.dsEpsdDietProfileHdrs = dsEpsdDietProfileHdrs;
        this.prHighRiskConditions = prHighRiskConditions;
        this.ipBedBookings = ipBedBookings;
        this.aeBedForTrmtAreas = aeBedForTrmtAreas;
        this.ipPatientLastEncounters = ipPatientLastEncounters;
        this.fmPullingLists = fmPullingLists;
        this.cpPatCarePlanGoals = cpPatCarePlanGoals;
        this.prSickLeaveRegisters = prSickLeaveRegisters;
        this.prAdvDrugReactions = prAdvDrugReactions;
        this.mrPatOtherMedInfos = mrPatOtherMedInfos;
        this.ipAdtTrns = ipAdtTrns;
        this.prDiagnosises = prDiagnosises;
        this.cpPatCarePlanIntvns = cpPatCarePlanIntvns;
        this.moMortuaryRegns = moMortuaryRegns;
        this.mpPatAddresseses = mpPatAddresseses;
        this.mpPatDocumentses = mpPatDocumentses;
        this.atAnaesthesiaRecordHdrs = atAnaesthesiaRecordHdrs;
        this.aeCurrentPatients = aeCurrentPatients;
        this.oaAppts = oaAppts;
        this.fmTransitFiles = fmTransitFiles;
        this.opPatientQueues = opPatientQueues;
        this.mpPatOthDtlses = mpPatOthDtlses;
        this.mpBirthRegistersForFatherPatientId = mpBirthRegistersForFatherPatientId;
        this.cpPatCarePlanManagers = cpPatCarePlanManagers;
        this.mrReportRequestHdrs = mrReportRequestHdrs;
        this.ipNursingUnitBedsForOccupyingPatientId = ipNursingUnitBedsForOccupyingPatientId;
        this.prPorterageDetailses = prPorterageDetailses;
        this.caEncntrDiscrMsrs = caEncntrDiscrMsrs;
        this.mrPatFileIndexes = mrPatFileIndexes;
        this.fmMovementLogs = fmMovementLogs;
        this.cpPatCarePlanIntvnDtls = cpPatCarePlanIntvnDtls;
        this.orConsentRefHdrs = orConsentRefHdrs;
        this.prWaitLists = prWaitLists;
        this.mpPatRelContactses = mpPatRelContactses;
        this.opCurrentPatients = opCurrentPatients;
        this.otPostOperHdrs = otPostOperHdrs;
        this.caEncntrPractRelns = caEncntrPractRelns;
        this.mpPatientPhotos = mpPatientPhotos;
        this.cpPatMdCarePlans = cpPatMdCarePlans;
        this.cpPatCarePlans = cpPatCarePlans;
        this.ipOpenEncounters = ipOpenEncounters;
        this.mrReportRequestDtls = mrReportRequestDtls;
        this.mrReportRequestRevDtls = mrReportRequestRevDtls;
        this.prEpisodeOfCares = prEpisodeOfCares;
        this.fmIpPullingLists = fmIpPullingLists;
        this.cpPatCarePlanTermCodes = cpPatCarePlanTermCodes;
        this.prReferralRegisters = prReferralRegisters;
        this.opLastVisitForServices = opLastVisitForServices;
        this.phPatientVaccProfiles = phPatientVaccProfiles;
        this.prEncounterProcedures = prEncounterProcedures;
        this.prEncounters = prEncounters;
        this.phPatientDrugProfiles = phPatientDrugProfiles;
    }

    public String getPatientId()
    {
        return patientId;
    }

    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }

    public SmFacilityParam getSmFacilityParamByRegnFacilityId()
    {
        return smFacilityParamByRegnFacilityId;
    }

    public void setSmFacilityParamByRegnFacilityId(SmFacilityParam smFacilityParamByRegnFacilityId)
    {
        this.smFacilityParamByRegnFacilityId = smFacilityParamByRegnFacilityId;
    }

    public MpNamePrefix getMpNamePrefix()
    {
        return mpNamePrefix;
    }

    public void setMpNamePrefix(MpNamePrefix mpNamePrefix)
    {
        this.mpNamePrefix = mpNamePrefix;
    }

    public MpRace getMpRace()
    {
        return mpRace;
    }

    public void setMpRace(MpRace mpRace)
    {
        this.mpRace = mpRace;
    }

    public MpRegion getMpRegion()
    {
        return mpRegion;
    }

    public void setMpRegion(MpRegion mpRegion)
    {
        this.mpRegion = mpRegion;
    }

    public MpAlternateIdType getMpAlternateIdTypeByAltId2Type()
    {
        return mpAlternateIdTypeByAltId2Type;
    }

    public void setMpAlternateIdTypeByAltId2Type(MpAlternateIdType mpAlternateIdTypeByAltId2Type)
    {
        this.mpAlternateIdTypeByAltId2Type = mpAlternateIdTypeByAltId2Type;
    }

    public MpAlternateIdType getMpAlternateIdTypeByAltId1Type()
    {
        return mpAlternateIdTypeByAltId1Type;
    }

    public void setMpAlternateIdTypeByAltId1Type(MpAlternateIdType mpAlternateIdTypeByAltId1Type)
    {
        this.mpAlternateIdTypeByAltId1Type = mpAlternateIdTypeByAltId1Type;
    }

    public MpContactMode getMpContactModeByContact5Mode()
    {
        return mpContactModeByContact5Mode;
    }

    public void setMpContactModeByContact5Mode(MpContactMode mpContactModeByContact5Mode)
    {
        this.mpContactModeByContact5Mode = mpContactModeByContact5Mode;
    }

    public MpNameSuffix getMpNameSuffix()
    {
        return mpNameSuffix;
    }

    public void setMpNameSuffix(MpNameSuffix mpNameSuffix)
    {
        this.mpNameSuffix = mpNameSuffix;
    }

    public SmFacilityParam getSmFacilityParamByPrefFacilityId()
    {
        return smFacilityParamByPrefFacilityId;
    }

    public void setSmFacilityParamByPrefFacilityId(SmFacilityParam smFacilityParamByPrefFacilityId)
    {
        this.smFacilityParamByPrefFacilityId = smFacilityParamByPrefFacilityId;
    }

    public MpAlternateIdType getMpAlternateIdTypeByAltId4Type()
    {
        return mpAlternateIdTypeByAltId4Type;
    }

    public void setMpAlternateIdTypeByAltId4Type(MpAlternateIdType mpAlternateIdTypeByAltId4Type)
    {
        this.mpAlternateIdTypeByAltId4Type = mpAlternateIdTypeByAltId4Type;
    }

    public MpReligion getMpReligion()
    {
        return mpReligion;
    }

    public void setMpReligion(MpReligion mpReligion)
    {
        this.mpReligion = mpReligion;
    }

    public MpResTown getMpResTown()
    {
        return mpResTown;
    }

    public void setMpResTown(MpResTown mpResTown)
    {
        this.mpResTown = mpResTown;
    }

    public MpRelationship getMpRelationship()
    {
        return mpRelationship;
    }

    public void setMpRelationship(MpRelationship mpRelationship)
    {
        this.mpRelationship = mpRelationship;
    }

    public AmReferral getAmReferral()
    {
        return amReferral;
    }

    public void setAmReferral(AmReferral amReferral)
    {
        this.amReferral = amReferral;
    }

    public MpContactMode getMpContactModeByContact4Mode()
    {
        return mpContactModeByContact4Mode;
    }

    public void setMpContactModeByContact4Mode(MpContactMode mpContactModeByContact4Mode)
    {
        this.mpContactModeByContact4Mode = mpContactModeByContact4Mode;
    }

    public MpContactMode getMpContactModeByContact3Mode()
    {
        return mpContactModeByContact3Mode;
    }

    public void setMpContactModeByContact3Mode(MpContactMode mpContactModeByContact3Mode)
    {
        this.mpContactModeByContact3Mode = mpContactModeByContact3Mode;
    }

    public MpPatCategory getMpPatCategory()
    {
        return mpPatCategory;
    }

    public void setMpPatCategory(MpPatCategory mpPatCategory)
    {
        this.mpPatCategory = mpPatCategory;
    }

    public MpAlternateIdType getMpAlternateIdTypeByAltId3Type()
    {
        return mpAlternateIdTypeByAltId3Type;
    }

    public void setMpAlternateIdTypeByAltId3Type(MpAlternateIdType mpAlternateIdTypeByAltId3Type)
    {
        this.mpAlternateIdTypeByAltId3Type = mpAlternateIdTypeByAltId3Type;
    }

    public MpPatSuspReason getMpPatSuspReason()
    {
        return mpPatSuspReason;
    }

    public void setMpPatSuspReason(MpPatSuspReason mpPatSuspReason)
    {
        this.mpPatSuspReason = mpPatSuspReason;
    }

    public MpContactMode getMpContactModeByContact2Mode()
    {
        return mpContactModeByContact2Mode;
    }

    public void setMpContactModeByContact2Mode(MpContactMode mpContactModeByContact2Mode)
    {
        this.mpContactModeByContact2Mode = mpContactModeByContact2Mode;
    }

    public MpCountry getMpCountry()
    {
        return mpCountry;
    }

    public void setMpCountry(MpCountry mpCountry)
    {
        this.mpCountry = mpCountry;
    }

    public MpPatSerGrp getMpPatSerGrp()
    {
        return mpPatSerGrp;
    }

    public void setMpPatSerGrp(MpPatSerGrp mpPatSerGrp)
    {
        this.mpPatSerGrp = mpPatSerGrp;
    }

    public MpMaritalStatus getMpMaritalStatus()
    {
        return mpMaritalStatus;
    }

    public void setMpMaritalStatus(MpMaritalStatus mpMaritalStatus)
    {
        this.mpMaritalStatus = mpMaritalStatus;
    }

    public MpContactMode getMpContactModeByContact1Mode()
    {
        return mpContactModeByContact1Mode;
    }

    public void setMpContactModeByContact1Mode(MpContactMode mpContactModeByContact1Mode)
    {
        this.mpContactModeByContact1Mode = mpContactModeByContact1Mode;
    }

    public MpResArea getMpResArea()
    {
        return mpResArea;
    }

    public void setMpResArea(MpResArea mpResArea)
    {
        this.mpResArea = mpResArea;
    }

    public Date getRegnDate()
    {
        return regnDate;
    }

    public void setRegnDate(Date regnDate)
    {
        this.regnDate = regnDate;
    }

    public String getOldPatientId()
    {
        return oldPatientId;
    }

    public void setOldPatientId(String oldPatientId)
    {
        this.oldPatientId = oldPatientId;
    }

    public String getNationalIdNo()
    {
        return nationalIdNo;
    }

    public void setNationalIdNo(String nationalIdNo)
    {
        this.nationalIdNo = nationalIdNo;
    }

    public String getAltId1No()
    {
        return altId1No;
    }

    public void setAltId1No(String altId1No)
    {
        this.altId1No = altId1No;
    }

    public Date getAltId1ExpDate()
    {
        return altId1ExpDate;
    }

    public void setAltId1ExpDate(Date altId1ExpDate)
    {
        this.altId1ExpDate = altId1ExpDate;
    }

    public String getAltId2No()
    {
        return altId2No;
    }

    public void setAltId2No(String altId2No)
    {
        this.altId2No = altId2No;
    }

    public Date getAltId2ExpDate()
    {
        return altId2ExpDate;
    }

    public void setAltId2ExpDate(Date altId2ExpDate)
    {
        this.altId2ExpDate = altId2ExpDate;
    }

    public String getAltId3No()
    {
        return altId3No;
    }

    public void setAltId3No(String altId3No)
    {
        this.altId3No = altId3No;
    }

    public Date getAltId3ExpDate()
    {
        return altId3ExpDate;
    }

    public void setAltId3ExpDate(Date altId3ExpDate)
    {
        this.altId3ExpDate = altId3ExpDate;
    }

    public String getAltId4No()
    {
        return altId4No;
    }

    public void setAltId4No(String altId4No)
    {
        this.altId4No = altId4No;
    }

    public Date getAltId4ExpDate()
    {
        return altId4ExpDate;
    }

    public void setAltId4ExpDate(Date altId4ExpDate)
    {
        this.altId4ExpDate = altId4ExpDate;
    }

    public Long getNewbornIdNoSuffix()
    {
        return newbornIdNoSuffix;
    }

    public void setNewbornIdNoSuffix(Long newbornIdNoSuffix)
    {
        this.newbornIdNoSuffix = newbornIdNoSuffix;
    }

    public String getDataSource()
    {
        return dataSource;
    }

    public void setDataSource(String dataSource)
    {
        this.dataSource = dataSource;
    }

    public String getContact1Status()
    {
        return contact1Status;
    }

    public void setContact1Status(String contact1Status)
    {
        this.contact1Status = contact1Status;
    }

    public String getContact1No()
    {
        return contact1No;
    }

    public void setContact1No(String contact1No)
    {
        this.contact1No = contact1No;
    }

    public String getContact2Status()
    {
        return contact2Status;
    }

    public void setContact2Status(String contact2Status)
    {
        this.contact2Status = contact2Status;
    }

    public String getContact2No()
    {
        return contact2No;
    }

    public void setContact2No(String contact2No)
    {
        this.contact2No = contact2No;
    }

    public String getContact3Status()
    {
        return contact3Status;
    }

    public void setContact3Status(String contact3Status)
    {
        this.contact3Status = contact3Status;
    }

    public String getContact3No()
    {
        return contact3No;
    }

    public void setContact3No(String contact3No)
    {
        this.contact3No = contact3No;
    }

    public String getContact4Status()
    {
        return contact4Status;
    }

    public void setContact4Status(String contact4Status)
    {
        this.contact4Status = contact4Status;
    }

    public String getContact4No()
    {
        return contact4No;
    }

    public void setContact4No(String contact4No)
    {
        this.contact4No = contact4No;
    }

    public String getContact5Status()
    {
        return contact5Status;
    }

    public void setContact5Status(String contact5Status)
    {
        this.contact5Status = contact5Status;
    }

    public String getContact5No()
    {
        return contact5No;
    }

    public void setContact5No(String contact5No)
    {
        this.contact5No = contact5No;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    public String getResTownDesc()
    {
        return resTownDesc;
    }

    public void setResTownDesc(String resTownDesc)
    {
        this.resTownDesc = resTownDesc;
    }

    public String getFamilyOrgId()
    {
        return familyOrgId;
    }

    public void setFamilyOrgId(String familyOrgId)
    {
        this.familyOrgId = familyOrgId;
    }

    public String getFamilyLinkNo()
    {
        return familyLinkNo;
    }

    public void setFamilyLinkNo(String familyLinkNo)
    {
        this.familyLinkNo = familyLinkNo;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSecondName()
    {
        return secondName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }

    public String getThirdName()
    {
        return thirdName;
    }

    public void setThirdName(String thirdName)
    {
        this.thirdName = thirdName;
    }

    public String getFamilyNamePrefix()
    {
        return familyNamePrefix;
    }

    public void setFamilyNamePrefix(String familyNamePrefix)
    {
        this.familyNamePrefix = familyNamePrefix;
    }

    public String getFamilyName()
    {
        return familyName;
    }

    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public String getPatientName()
    {
        return patientName;
    }

    public void setPatientName(String patientName)
    {
        this.patientName = patientName;
    }

    public String getNamePrefixLocLang()
    {
        return namePrefixLocLang;
    }

    public void setNamePrefixLocLang(String namePrefixLocLang)
    {
        this.namePrefixLocLang = namePrefixLocLang;
    }

    public String getFirstNameLocLang()
    {
        return firstNameLocLang;
    }

    public void setFirstNameLocLang(String firstNameLocLang)
    {
        this.firstNameLocLang = firstNameLocLang;
    }

    public String getSecondNameLocLang()
    {
        return secondNameLocLang;
    }

    public void setSecondNameLocLang(String secondNameLocLang)
    {
        this.secondNameLocLang = secondNameLocLang;
    }

    public String getThirdNameLocLang()
    {
        return thirdNameLocLang;
    }

    public void setThirdNameLocLang(String thirdNameLocLang)
    {
        this.thirdNameLocLang = thirdNameLocLang;
    }

    public String getFamilyNameLocLang()
    {
        return familyNameLocLang;
    }

    public void setFamilyNameLocLang(String familyNameLocLang)
    {
        this.familyNameLocLang = familyNameLocLang;
    }

    public String getNameSuffixLocLang()
    {
        return nameSuffixLocLang;
    }

    public void setNameSuffixLocLang(String nameSuffixLocLang)
    {
        this.nameSuffixLocLang = nameSuffixLocLang;
    }

    public String getPatientNameLocLang()
    {
        return patientNameLocLang;
    }

    public void setPatientNameLocLang(String patientNameLocLang)
    {
        this.patientNameLocLang = patientNameLocLang;
    }

    public String getGenericSndxFirst()
    {
        return genericSndxFirst;
    }

    public void setGenericSndxFirst(String genericSndxFirst)
    {
        this.genericSndxFirst = genericSndxFirst;
    }

    public String getGenericSndxSecond()
    {
        return genericSndxSecond;
    }

    public void setGenericSndxSecond(String genericSndxSecond)
    {
        this.genericSndxSecond = genericSndxSecond;
    }

    public String getGenericSndxThird()
    {
        return genericSndxThird;
    }

    public void setGenericSndxThird(String genericSndxThird)
    {
        this.genericSndxThird = genericSndxThird;
    }

    public String getGenericSndxFamily()
    {
        return genericSndxFamily;
    }

    public void setGenericSndxFamily(String genericSndxFamily)
    {
        this.genericSndxFamily = genericSndxFamily;
    }

    public String getGenericSndxFirstSecond()
    {
        return genericSndxFirstSecond;
    }

    public void setGenericSndxFirstSecond(String genericSndxFirstSecond)
    {
        this.genericSndxFirstSecond = genericSndxFirstSecond;
    }

    public String getGenericSndxFirstFamily()
    {
        return genericSndxFirstFamily;
    }

    public void setGenericSndxFirstFamily(String genericSndxFirstFamily)
    {
        this.genericSndxFirstFamily = genericSndxFirstFamily;
    }

    public String getEthnicSndxFirst()
    {
        return ethnicSndxFirst;
    }

    public void setEthnicSndxFirst(String ethnicSndxFirst)
    {
        this.ethnicSndxFirst = ethnicSndxFirst;
    }

    public String getEthnicSndxSecond()
    {
        return ethnicSndxSecond;
    }

    public void setEthnicSndxSecond(String ethnicSndxSecond)
    {
        this.ethnicSndxSecond = ethnicSndxSecond;
    }

    public String getEthnicSndxThird()
    {
        return ethnicSndxThird;
    }

    public void setEthnicSndxThird(String ethnicSndxThird)
    {
        this.ethnicSndxThird = ethnicSndxThird;
    }

    public String getEthnicSndxFamily()
    {
        return ethnicSndxFamily;
    }

    public void setEthnicSndxFamily(String ethnicSndxFamily)
    {
        this.ethnicSndxFamily = ethnicSndxFamily;
    }

    public String getEthnicSndxFirstSecond()
    {
        return ethnicSndxFirstSecond;
    }

    public void setEthnicSndxFirstSecond(String ethnicSndxFirstSecond)
    {
        this.ethnicSndxFirstSecond = ethnicSndxFirstSecond;
    }

    public String getEthnicSndxFirstFamily()
    {
        return ethnicSndxFirstFamily;
    }

    public void setEthnicSndxFirstFamily(String ethnicSndxFirstFamily)
    {
        this.ethnicSndxFirstFamily = ethnicSndxFirstFamily;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCalculatedAgeYn()
    {
        return calculatedAgeYn;
    }

    public void setCalculatedAgeYn(String calculatedAgeYn)
    {
        this.calculatedAgeYn = calculatedAgeYn;
    }

    public String getAliasName()
    {
        return aliasName;
    }

    public void setAliasName(String aliasName)
    {
        this.aliasName = aliasName;
    }

    public String getMotherMaidenName()
    {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName)
    {
        this.motherMaidenName = motherMaidenName;
    }

    public String getPublicityLevel()
    {
        return publicityLevel;
    }

    public void setPublicityLevel(String publicityLevel)
    {
        this.publicityLevel = publicityLevel;
    }

    public String getProtectionInd()
    {
        return protectionInd;
    }

    public void setProtectionInd(String protectionInd)
    {
        this.protectionInd = protectionInd;
    }

    public String getCodedPseudoName()
    {
        return codedPseudoName;
    }

    public void setCodedPseudoName(String codedPseudoName)
    {
        this.codedPseudoName = codedPseudoName;
    }

    public String getEthnicGrpCode()
    {
        return ethnicGrpCode;
    }

    public void setEthnicGrpCode(String ethnicGrpCode)
    {
        this.ethnicGrpCode = ethnicGrpCode;
    }

    public String getRelgnSectCode()
    {
        return relgnSectCode;
    }

    public void setRelgnSectCode(String relgnSectCode)
    {
        this.relgnSectCode = relgnSectCode;
    }

    public String getPlaceOfBirth()
    {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth)
    {
        this.placeOfBirth = placeOfBirth;
    }

    public String getPrimaryLanguageId()
    {
        return primaryLanguageId;
    }

    public void setPrimaryLanguageId(String primaryLanguageId)
    {
        this.primaryLanguageId = primaryLanguageId;
    }

    public String getSplHandlingCode()
    {
        return splHandlingCode;
    }

    public void setSplHandlingCode(String splHandlingCode)
    {
        this.splHandlingCode = splHandlingCode;
    }

    public String getReferralFacilityId()
    {
        return referralFacilityId;
    }

    public void setReferralFacilityId(String referralFacilityId)
    {
        this.referralFacilityId = referralFacilityId;
    }

    public String getRefPhysicianId()
    {
        return refPhysicianId;
    }

    public void setRefPhysicianId(String refPhysicianId)
    {
        this.refPhysicianId = refPhysicianId;
    }

    public String getPrimaryCarePhysicianId()
    {
        return primaryCarePhysicianId;
    }

    public void setPrimaryCarePhysicianId(String primaryCarePhysicianId)
    {
        this.primaryCarePhysicianId = primaryCarePhysicianId;
    }

    public String getGuarantorType()
    {
        return guarantorType;
    }

    public void setGuarantorType(String guarantorType)
    {
        this.guarantorType = guarantorType;
    }

    public String getPatGuarantorYn()
    {
        return patGuarantorYn;
    }

    public void setPatGuarantorYn(String patGuarantorYn)
    {
        this.patGuarantorYn = patGuarantorYn;
    }

    public String getGuarantorId()
    {
        return guarantorId;
    }

    public void setGuarantorId(String guarantorId)
    {
        this.guarantorId = guarantorId;
    }

    public String getGuarantorName()
    {
        return guarantorName;
    }

    public void setGuarantorName(String guarantorName)
    {
        this.guarantorName = guarantorName;
    }

    public String getGuarantorRelnCode()
    {
        return guarantorRelnCode;
    }

    public void setGuarantorRelnCode(String guarantorRelnCode)
    {
        this.guarantorRelnCode = guarantorRelnCode;
    }

    public Long getAnnualFamilyIncome()
    {
        return annualFamilyIncome;
    }

    public void setAnnualFamilyIncome(Long annualFamilyIncome)
    {
        this.annualFamilyIncome = annualFamilyIncome;
    }

    public Long getHouseholdSize()
    {
        return householdSize;
    }

    public void setHouseholdSize(Long householdSize)
    {
        this.householdSize = householdSize;
    }

    public Long getFamilyAssetsValue()
    {
        return familyAssetsValue;
    }

    public void setFamilyAssetsValue(Long familyAssetsValue)
    {
        this.familyAssetsValue = familyAssetsValue;
    }

    public String getFinancialClass()
    {
        return financialClass;
    }

    public void setFinancialClass(String financialClass)
    {
        this.financialClass = financialClass;
    }

    public String getStudentInd()
    {
        return studentInd;
    }

    public void setStudentInd(String studentInd)
    {
        this.studentInd = studentInd;
    }

    public String getSlmtInd()
    {
        return slmtInd;
    }

    public void setSlmtInd(String slmtInd)
    {
        this.slmtInd = slmtInd;
    }

    public String getSlmtTypeCode()
    {
        return slmtTypeCode;
    }

    public void setSlmtTypeCode(String slmtTypeCode)
    {
        this.slmtTypeCode = slmtTypeCode;
    }

    public String getSlmtDocRef()
    {
        return slmtDocRef;
    }

    public void setSlmtDocRef(String slmtDocRef)
    {
        this.slmtDocRef = slmtDocRef;
    }

    public Date getSlmtDocDate()
    {
        return slmtDocDate;
    }

    public void setSlmtDocDate(Date slmtDocDate)
    {
        this.slmtDocDate = slmtDocDate;
    }

    public String getSlmtDocRemarks()
    {
        return slmtDocRemarks;
    }

    public void setSlmtDocRemarks(String slmtDocRemarks)
    {
        this.slmtDocRemarks = slmtDocRemarks;
    }

    public String getEmegRegnYn()
    {
        return emegRegnYn;
    }

    public void setEmegRegnYn(String emegRegnYn)
    {
        this.emegRegnYn = emegRegnYn;
    }

    public String getInhouseBirthYn()
    {
        return inhouseBirthYn;
    }

    public void setInhouseBirthYn(String inhouseBirthYn)
    {
        this.inhouseBirthYn = inhouseBirthYn;
    }

    public String getGeneralAlert()
    {
        return generalAlert;
    }

    public void setGeneralAlert(String generalAlert)
    {
        this.generalAlert = generalAlert;
    }

    public String getActiveYn()
    {
        return activeYn;
    }

    public void setActiveYn(String activeYn)
    {
        this.activeYn = activeYn;
    }

    public String getSuspendYn()
    {
        return suspendYn;
    }

    public void setSuspendYn(String suspendYn)
    {
        this.suspendYn = suspendYn;
    }

    public String getStatusRemarks()
    {
        return statusRemarks;
    }

    public void setStatusRemarks(String statusRemarks)
    {
        this.statusRemarks = statusRemarks;
    }

    public String getInactActReasonCode()
    {
        return inactActReasonCode;
    }

    public void setInactActReasonCode(String inactActReasonCode)
    {
        this.inactActReasonCode = inactActReasonCode;
    }

    public String getInactActRemarks()
    {
        return inactActRemarks;
    }

    public void setInactActRemarks(String inactActRemarks)
    {
        this.inactActRemarks = inactActRemarks;
    }

    public Date getLastContactDate()
    {
        return lastContactDate;
    }

    public void setLastContactDate(Date lastContactDate)
    {
        this.lastContactDate = lastContactDate;
    }

    public String getDeceasedYn()
    {
        return deceasedYn;
    }

    public void setDeceasedYn(String deceasedYn)
    {
        this.deceasedYn = deceasedYn;
    }

    public Date getDeceasedDate()
    {
        return deceasedDate;
    }

    public void setDeceasedDate(Date deceasedDate)
    {
        this.deceasedDate = deceasedDate;
    }

    public String getDeathStatusRemarks()
    {
        return deathStatusRemarks;
    }

    public void setDeathStatusRemarks(String deathStatusRemarks)
    {
        this.deathStatusRemarks = deathStatusRemarks;
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

    public String getBedAssignedForNbYn()
    {
        return bedAssignedForNbYn;
    }

    public void setBedAssignedForNbYn(String bedAssignedForNbYn)
    {
        this.bedAssignedForNbYn = bedAssignedForNbYn;
    }

    public String getBirthPlaceCode()
    {
        return birthPlaceCode;
    }

    public void setBirthPlaceCode(String birthPlaceCode)
    {
        this.birthPlaceCode = birthPlaceCode;
    }

    public String getCitizenYn()
    {
        return citizenYn;
    }

    public void setCitizenYn(String citizenYn)
    {
        this.citizenYn = citizenYn;
    }

    public String getLegalYn()
    {
        return legalYn;
    }

    public void setLegalYn(String legalYn)
    {
        this.legalYn = legalYn;
    }

    public String getOthAltIdNo()
    {
        return othAltIdNo;
    }

    public void setOthAltIdNo(String othAltIdNo)
    {
        this.othAltIdNo = othAltIdNo;
    }

    public String getOthAltIdType()
    {
        return othAltIdType;
    }

    public void setOthAltIdType(String othAltIdType)
    {
        this.othAltIdType = othAltIdType;
    }

    public String getPatDtlsUnknownYn()
    {
        return patDtlsUnknownYn;
    }

    public void setPatDtlsUnknownYn(String patDtlsUnknownYn)
    {
        this.patDtlsUnknownYn = patDtlsUnknownYn;
    }

    public String getDisasterRegnYn()
    {
        return disasterRegnYn;
    }

    public void setDisasterRegnYn(String disasterRegnYn)
    {
        this.disasterRegnYn = disasterRegnYn;
    }

    public String getPatPhotoInDbYn()
    {
        return patPhotoInDbYn;
    }

    public void setPatPhotoInDbYn(String patPhotoInDbYn)
    {
        this.patPhotoInDbYn = patPhotoInDbYn;
    }

    public String getRegisteredInMoYn()
    {
        return registeredInMoYn;
    }

    public void setRegisteredInMoYn(String registeredInMoYn)
    {
        this.registeredInMoYn = registeredInMoYn;
    }

    public String getDeceasedFacilityId()
    {
        return deceasedFacilityId;
    }

    public void setDeceasedFacilityId(String deceasedFacilityId)
    {
        this.deceasedFacilityId = deceasedFacilityId;
    }

    public Long getDeceasedEncounterId()
    {
        return deceasedEncounterId;
    }

    public void setDeceasedEncounterId(Long deceasedEncounterId)
    {
        this.deceasedEncounterId = deceasedEncounterId;
    }

    public String getFamilyOrgSubId()
    {
        return familyOrgSubId;
    }

    public void setFamilyOrgSubId(String familyOrgSubId)
    {
        this.familyOrgSubId = familyOrgSubId;
    }

    public String getFamilyOrgMembership()
    {
        return familyOrgMembership;
    }

    public void setFamilyOrgMembership(String familyOrgMembership)
    {
        this.familyOrgMembership = familyOrgMembership;
    }

    public Date getPatCatCodeExpDate()
    {
        return patCatCodeExpDate;
    }

    public void setPatCatCodeExpDate(Date patCatCodeExpDate)
    {
        this.patCatCodeExpDate = patCatCodeExpDate;
    }

    public String getMotherPatientId()
    {
        return motherPatientId;
    }

    public void setMotherPatientId(String motherPatientId)
    {
        this.motherPatientId = motherPatientId;
    }

    public String getFatherPatientId()
    {
        return fatherPatientId;
    }

    public void setFatherPatientId(String fatherPatientId)
    {
        this.fatherPatientId = fatherPatientId;
    }

    public String getPractitionerId()
    {
        return practitionerId;
    }

    public void setPractitionerId(String practitionerId)
    {
        this.practitionerId = practitionerId;
    }

    public String getSourceType()
    {
        return sourceType;
    }

    public void setSourceType(String sourceType)
    {
        this.sourceType = sourceType;
    }

    public String getSourceCode()
    {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode)
    {
        this.sourceCode = sourceCode;
    }

    public Set getPrPatientValuableses()
    {
        return prPatientValuableses;
    }

    public void setPrPatientValuableses(Set prPatientValuableses)
    {
        this.prPatientValuableses = prPatientValuableses;
    }

    public Set getCpPatCarePlanOutcomes()
    {
        return cpPatCarePlanOutcomes;
    }

    public void setCpPatCarePlanOutcomes(Set cpPatCarePlanOutcomes)
    {
        this.cpPatCarePlanOutcomes = cpPatCarePlanOutcomes;
    }

    public Set getIpTransferRequests()
    {
        return ipTransferRequests;
    }

    public void setIpTransferRequests(Set ipTransferRequests)
    {
        this.ipTransferRequests = ipTransferRequests;
    }

    public Set getMpBirthRegistersForMotherPatientId()
    {
        return mpBirthRegistersForMotherPatientId;
    }

    public void setMpBirthRegistersForMotherPatientId(Set mpBirthRegistersForMotherPatientId)
    {
        this.mpBirthRegistersForMotherPatientId = mpBirthRegistersForMotherPatientId;
    }

    public Set getPrProblemAssessments()
    {
        return prProblemAssessments;
    }

    public void setPrProblemAssessments(Set prProblemAssessments)
    {
        this.prProblemAssessments = prProblemAssessments;
    }

    public Set getCaPatTaskLists()
    {
        return caPatTaskLists;
    }

    public void setCaPatTaskLists(Set caPatTaskLists)
    {
        this.caPatTaskLists = caPatTaskLists;
    }

    public Set getIpNursingUnitBedsForMothersPatientId()
    {
        return ipNursingUnitBedsForMothersPatientId;
    }

    public void setIpNursingUnitBedsForMothersPatientId(Set ipNursingUnitBedsForMothersPatientId)
    {
        this.ipNursingUnitBedsForMothersPatientId = ipNursingUnitBedsForMothersPatientId;
    }

    public Set getOaApptDelTrs()
    {
        return oaApptDelTrs;
    }

    public void setOaApptDelTrs(Set oaApptDelTrs)
    {
        this.oaApptDelTrs = oaApptDelTrs;
    }

    public Set getMoBedForAreas()
    {
        return moBedForAreas;
    }

    public void setMoBedForAreas(Set moBedForAreas)
    {
        this.moBedForAreas = moBedForAreas;
    }

    public Set getIpAdtTrnAuditLogs()
    {
        return ipAdtTrnAuditLogs;
    }

    public void setIpAdtTrnAuditLogs(Set ipAdtTrnAuditLogs)
    {
        this.ipAdtTrnAuditLogs = ipAdtTrnAuditLogs;
    }

    public Set getAeSpareBayses()
    {
        return aeSpareBayses;
    }

    public void setAeSpareBayses(Set aeSpareBayses)
    {
        this.aeSpareBayses = aeSpareBayses;
    }

    public Set getCpPatCarePlanRevisions()
    {
        return cpPatCarePlanRevisions;
    }

    public void setCpPatCarePlanRevisions(Set cpPatCarePlanRevisions)
    {
        this.cpPatCarePlanRevisions = cpPatCarePlanRevisions;
    }

    public Set getOpPatientTrackingLocns()
    {
        return opPatientTrackingLocns;
    }

    public void setOpPatientTrackingLocns(Set opPatientTrackingLocns)
    {
        this.opPatientTrackingLocns = opPatientTrackingLocns;
    }

    public Set getMrMedEventLogs()
    {
        return mrMedEventLogs;
    }

    public void setMrMedEventLogs(Set mrMedEventLogs)
    {
        this.mrMedEventLogs = mrMedEventLogs;
    }

    public Set getDsEpsdDietProfileHdrs()
    {
        return dsEpsdDietProfileHdrs;
    }

    public void setDsEpsdDietProfileHdrs(Set dsEpsdDietProfileHdrs)
    {
        this.dsEpsdDietProfileHdrs = dsEpsdDietProfileHdrs;
    }

    public Set getPrHighRiskConditions()
    {
        return prHighRiskConditions;
    }

    public void setPrHighRiskConditions(Set prHighRiskConditions)
    {
        this.prHighRiskConditions = prHighRiskConditions;
    }

    public Set getIpBedBookings()
    {
        return ipBedBookings;
    }

    public void setIpBedBookings(Set ipBedBookings)
    {
        this.ipBedBookings = ipBedBookings;
    }

    public Set getAeBedForTrmtAreas()
    {
        return aeBedForTrmtAreas;
    }

    public void setAeBedForTrmtAreas(Set aeBedForTrmtAreas)
    {
        this.aeBedForTrmtAreas = aeBedForTrmtAreas;
    }

    public Set getIpPatientLastEncounters()
    {
        return ipPatientLastEncounters;
    }

    public void setIpPatientLastEncounters(Set ipPatientLastEncounters)
    {
        this.ipPatientLastEncounters = ipPatientLastEncounters;
    }

    public Set getFmPullingLists()
    {
        return fmPullingLists;
    }

    public void setFmPullingLists(Set fmPullingLists)
    {
        this.fmPullingLists = fmPullingLists;
    }

    public Set getCpPatCarePlanGoals()
    {
        return cpPatCarePlanGoals;
    }

    public void setCpPatCarePlanGoals(Set cpPatCarePlanGoals)
    {
        this.cpPatCarePlanGoals = cpPatCarePlanGoals;
    }

    public Set getPrSickLeaveRegisters()
    {
        return prSickLeaveRegisters;
    }

    public void setPrSickLeaveRegisters(Set prSickLeaveRegisters)
    {
        this.prSickLeaveRegisters = prSickLeaveRegisters;
    }

    public Set getPrAdvDrugReactions()
    {
        return prAdvDrugReactions;
    }

    public void setPrAdvDrugReactions(Set prAdvDrugReactions)
    {
        this.prAdvDrugReactions = prAdvDrugReactions;
    }

    public Set getMrPatOtherMedInfos()
    {
        return mrPatOtherMedInfos;
    }

    public void setMrPatOtherMedInfos(Set mrPatOtherMedInfos)
    {
        this.mrPatOtherMedInfos = mrPatOtherMedInfos;
    }

    public Set getIpAdtTrns()
    {
        return ipAdtTrns;
    }

    public void setIpAdtTrns(Set ipAdtTrns)
    {
        this.ipAdtTrns = ipAdtTrns;
    }

    public Set getPrDiagnosises()
    {
        return prDiagnosises;
    }

    public void setPrDiagnosises(Set prDiagnosises)
    {
        this.prDiagnosises = prDiagnosises;
    }

    public Set getCpPatCarePlanIntvns()
    {
        return cpPatCarePlanIntvns;
    }

    public void setCpPatCarePlanIntvns(Set cpPatCarePlanIntvns)
    {
        this.cpPatCarePlanIntvns = cpPatCarePlanIntvns;
    }

    public Set getMoMortuaryRegns()
    {
        return moMortuaryRegns;
    }

    public void setMoMortuaryRegns(Set moMortuaryRegns)
    {
        this.moMortuaryRegns = moMortuaryRegns;
    }

    public Set getMpPatAddresseses()
    {
        return mpPatAddresseses;
    }

    public void setMpPatAddresseses(Set mpPatAddresseses)
    {
        this.mpPatAddresseses = mpPatAddresseses;
    }

    public Set getMpPatDocumentses()
    {
        return mpPatDocumentses;
    }

    public void setMpPatDocumentses(Set mpPatDocumentses)
    {
        this.mpPatDocumentses = mpPatDocumentses;
    }

    public Set getAtAnaesthesiaRecordHdrs()
    {
        return atAnaesthesiaRecordHdrs;
    }

    public void setAtAnaesthesiaRecordHdrs(Set atAnaesthesiaRecordHdrs)
    {
        this.atAnaesthesiaRecordHdrs = atAnaesthesiaRecordHdrs;
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

    public Set getFmTransitFiles()
    {
        return fmTransitFiles;
    }

    public void setFmTransitFiles(Set fmTransitFiles)
    {
        this.fmTransitFiles = fmTransitFiles;
    }

    public Set getOpPatientQueues()
    {
        return opPatientQueues;
    }

    public void setOpPatientQueues(Set opPatientQueues)
    {
        this.opPatientQueues = opPatientQueues;
    }

    public Set getMpPatOthDtlses()
    {
        return mpPatOthDtlses;
    }

    public void setMpPatOthDtlses(Set mpPatOthDtlses)
    {
        this.mpPatOthDtlses = mpPatOthDtlses;
    }

    public Set getMpBirthRegistersForFatherPatientId()
    {
        return mpBirthRegistersForFatherPatientId;
    }

    public void setMpBirthRegistersForFatherPatientId(Set mpBirthRegistersForFatherPatientId)
    {
        this.mpBirthRegistersForFatherPatientId = mpBirthRegistersForFatherPatientId;
    }

    public Set getCpPatCarePlanManagers()
    {
        return cpPatCarePlanManagers;
    }

    public void setCpPatCarePlanManagers(Set cpPatCarePlanManagers)
    {
        this.cpPatCarePlanManagers = cpPatCarePlanManagers;
    }

    public Set getMrReportRequestHdrs()
    {
        return mrReportRequestHdrs;
    }

    public void setMrReportRequestHdrs(Set mrReportRequestHdrs)
    {
        this.mrReportRequestHdrs = mrReportRequestHdrs;
    }

    public Set getIpNursingUnitBedsForOccupyingPatientId()
    {
        return ipNursingUnitBedsForOccupyingPatientId;
    }

    public void setIpNursingUnitBedsForOccupyingPatientId(Set ipNursingUnitBedsForOccupyingPatientId)
    {
        this.ipNursingUnitBedsForOccupyingPatientId = ipNursingUnitBedsForOccupyingPatientId;
    }

    public Set getPrPorterageDetailses()
    {
        return prPorterageDetailses;
    }

    public void setPrPorterageDetailses(Set prPorterageDetailses)
    {
        this.prPorterageDetailses = prPorterageDetailses;
    }

    public Set getCaEncntrDiscrMsrs()
    {
        return caEncntrDiscrMsrs;
    }

    public void setCaEncntrDiscrMsrs(Set caEncntrDiscrMsrs)
    {
        this.caEncntrDiscrMsrs = caEncntrDiscrMsrs;
    }

    public Set getMrPatFileIndexes()
    {
        return mrPatFileIndexes;
    }

    public void setMrPatFileIndexes(Set mrPatFileIndexes)
    {
        this.mrPatFileIndexes = mrPatFileIndexes;
    }

    public Set getFmMovementLogs()
    {
        return fmMovementLogs;
    }

    public void setFmMovementLogs(Set fmMovementLogs)
    {
        this.fmMovementLogs = fmMovementLogs;
    }

    public Set getCpPatCarePlanIntvnDtls()
    {
        return cpPatCarePlanIntvnDtls;
    }

    public void setCpPatCarePlanIntvnDtls(Set cpPatCarePlanIntvnDtls)
    {
        this.cpPatCarePlanIntvnDtls = cpPatCarePlanIntvnDtls;
    }

    public Set getOrConsentRefHdrs()
    {
        return orConsentRefHdrs;
    }

    public void setOrConsentRefHdrs(Set orConsentRefHdrs)
    {
        this.orConsentRefHdrs = orConsentRefHdrs;
    }

    public Set getPrWaitLists()
    {
        return prWaitLists;
    }

    public void setPrWaitLists(Set prWaitLists)
    {
        this.prWaitLists = prWaitLists;
    }

    public Set getMpPatRelContactses()
    {
        return mpPatRelContactses;
    }

    public void setMpPatRelContactses(Set mpPatRelContactses)
    {
        this.mpPatRelContactses = mpPatRelContactses;
    }

    public Set getOpCurrentPatients()
    {
        return opCurrentPatients;
    }

    public void setOpCurrentPatients(Set opCurrentPatients)
    {
        this.opCurrentPatients = opCurrentPatients;
    }

    public Set getOtPostOperHdrs()
    {
        return otPostOperHdrs;
    }

    public void setOtPostOperHdrs(Set otPostOperHdrs)
    {
        this.otPostOperHdrs = otPostOperHdrs;
    }

    public Set getCaEncntrPractRelns()
    {
        return caEncntrPractRelns;
    }

    public void setCaEncntrPractRelns(Set caEncntrPractRelns)
    {
        this.caEncntrPractRelns = caEncntrPractRelns;
    }

    public Set getMpPatientPhotos()
    {
        return mpPatientPhotos;
    }

    public void setMpPatientPhotos(Set mpPatientPhotos)
    {
        this.mpPatientPhotos = mpPatientPhotos;
    }

    public Set getCpPatMdCarePlans()
    {
        return cpPatMdCarePlans;
    }

    public void setCpPatMdCarePlans(Set cpPatMdCarePlans)
    {
        this.cpPatMdCarePlans = cpPatMdCarePlans;
    }

    public Set getCpPatCarePlans()
    {
        return cpPatCarePlans;
    }

    public void setCpPatCarePlans(Set cpPatCarePlans)
    {
        this.cpPatCarePlans = cpPatCarePlans;
    }

    public Set getIpOpenEncounters()
    {
        return ipOpenEncounters;
    }

    public void setIpOpenEncounters(Set ipOpenEncounters)
    {
        this.ipOpenEncounters = ipOpenEncounters;
    }

    public Set getMrReportRequestDtls()
    {
        return mrReportRequestDtls;
    }

    public void setMrReportRequestDtls(Set mrReportRequestDtls)
    {
        this.mrReportRequestDtls = mrReportRequestDtls;
    }

    public Set getMrReportRequestRevDtls()
    {
        return mrReportRequestRevDtls;
    }

    public void setMrReportRequestRevDtls(Set mrReportRequestRevDtls)
    {
        this.mrReportRequestRevDtls = mrReportRequestRevDtls;
    }

    public Set getPrEpisodeOfCares()
    {
        return prEpisodeOfCares;
    }

    public void setPrEpisodeOfCares(Set prEpisodeOfCares)
    {
        this.prEpisodeOfCares = prEpisodeOfCares;
    }

    public Set getFmIpPullingLists()
    {
        return fmIpPullingLists;
    }

    public void setFmIpPullingLists(Set fmIpPullingLists)
    {
        this.fmIpPullingLists = fmIpPullingLists;
    }

    public Set getCpPatCarePlanTermCodes()
    {
        return cpPatCarePlanTermCodes;
    }

    public void setCpPatCarePlanTermCodes(Set cpPatCarePlanTermCodes)
    {
        this.cpPatCarePlanTermCodes = cpPatCarePlanTermCodes;
    }

    public Set getPrReferralRegisters()
    {
        return prReferralRegisters;
    }

    public void setPrReferralRegisters(Set prReferralRegisters)
    {
        this.prReferralRegisters = prReferralRegisters;
    }

    public Set getOpLastVisitForServices()
    {
        return opLastVisitForServices;
    }

    public void setOpLastVisitForServices(Set opLastVisitForServices)
    {
        this.opLastVisitForServices = opLastVisitForServices;
    }

    public Set getPhPatientVaccProfiles()
    {
        return phPatientVaccProfiles;
    }

    public void setPhPatientVaccProfiles(Set phPatientVaccProfiles)
    {
        this.phPatientVaccProfiles = phPatientVaccProfiles;
    }

    public Set getPrEncounterProcedures()
    {
        return prEncounterProcedures;
    }

    public void setPrEncounterProcedures(Set prEncounterProcedures)
    {
        this.prEncounterProcedures = prEncounterProcedures;
    }

    public Set getPrEncounters()
    {
        return prEncounters;
    }

    public void setPrEncounters(Set prEncounters)
    {
        this.prEncounters = prEncounters;
    }

    public Set getPhPatientDrugProfiles()
    {
        return phPatientDrugProfiles;
    }

    public void setPhPatientDrugProfiles(Set phPatientDrugProfiles)
    {
        this.phPatientDrugProfiles = phPatientDrugProfiles;
    }

    private String patientId;
    private SmFacilityParam smFacilityParamByRegnFacilityId;
    private MpNamePrefix mpNamePrefix;
    private MpRace mpRace;
    private MpRegion mpRegion;
    private MpAlternateIdType mpAlternateIdTypeByAltId2Type;
    private MpAlternateIdType mpAlternateIdTypeByAltId1Type;
    private MpContactMode mpContactModeByContact5Mode;
    private MpNameSuffix mpNameSuffix;
    private SmFacilityParam smFacilityParamByPrefFacilityId;
    private MpAlternateIdType mpAlternateIdTypeByAltId4Type;
    private MpReligion mpReligion;
    private MpResTown mpResTown;
    private MpRelationship mpRelationship;
    private AmReferral amReferral;
    private MpContactMode mpContactModeByContact4Mode;
    private MpContactMode mpContactModeByContact3Mode;
    private MpPatCategory mpPatCategory;
    private MpAlternateIdType mpAlternateIdTypeByAltId3Type;
    private MpPatSuspReason mpPatSuspReason;
    private MpContactMode mpContactModeByContact2Mode;
    private MpCountry mpCountry;
    private MpPatSerGrp mpPatSerGrp;
    private MpMaritalStatus mpMaritalStatus;
    private MpContactMode mpContactModeByContact1Mode;
    private MpResArea mpResArea;
    private Date regnDate;
    private String oldPatientId;
    private String nationalIdNo;
    private String altId1No;
    private Date altId1ExpDate;
    private String altId2No;
    private Date altId2ExpDate;
    private String altId3No;
    private Date altId3ExpDate;
    private String altId4No;
    private Date altId4ExpDate;
    private Long newbornIdNoSuffix;
    private String dataSource;
    private String contact1Status;
    private String contact1No;
    private String contact2Status;
    private String contact2No;
    private String contact3Status;
    private String contact3No;
    private String contact4Status;
    private String contact4No;
    private String contact5Status;
    private String contact5No;
    private String emailId;
    private String resTownDesc;
    private String familyOrgId;
    private String familyLinkNo;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String familyNamePrefix;
    private String familyName;
    private String patientName;
    private String namePrefixLocLang;
    private String firstNameLocLang;
    private String secondNameLocLang;
    private String thirdNameLocLang;
    private String familyNameLocLang;
    private String nameSuffixLocLang;
    private String patientNameLocLang;
    private String genericSndxFirst;
    private String genericSndxSecond;
    private String genericSndxThird;
    private String genericSndxFamily;
    private String genericSndxFirstSecond;
    private String genericSndxFirstFamily;
    private String ethnicSndxFirst;
    private String ethnicSndxSecond;
    private String ethnicSndxThird;
    private String ethnicSndxFamily;
    private String ethnicSndxFirstSecond;
    private String ethnicSndxFirstFamily;
    private String sex;
    private Date dateOfBirth;
    private String calculatedAgeYn;
    private String aliasName;
    private String motherMaidenName;
    private String publicityLevel;
    private String protectionInd;
    private String codedPseudoName;
    private String ethnicGrpCode;
    private String relgnSectCode;
    private String placeOfBirth;
    private String primaryLanguageId;
    private String splHandlingCode;
    private String referralFacilityId;
    private String refPhysicianId;
    private String primaryCarePhysicianId;
    private String guarantorType;
    private String patGuarantorYn;
    private String guarantorId;
    private String guarantorName;
    private String guarantorRelnCode;
    private Long annualFamilyIncome;
    private Long householdSize;
    private Long familyAssetsValue;
    private String financialClass;
    private String studentInd;
    private String slmtInd;
    private String slmtTypeCode;
    private String slmtDocRef;
    private Date slmtDocDate;
    private String slmtDocRemarks;
    private String emegRegnYn;
    private String inhouseBirthYn;
    private String generalAlert;
    private String activeYn;
    private String suspendYn;
    private String statusRemarks;
    private String inactActReasonCode;
    private String inactActRemarks;
    private Date lastContactDate;
    private String deceasedYn;
    private Date deceasedDate;
    private String deathStatusRemarks;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
    private String bedAssignedForNbYn;
    private String birthPlaceCode;
    private String citizenYn;
    private String legalYn;
    private String othAltIdNo;
    private String othAltIdType;
    private String patDtlsUnknownYn;
    private String disasterRegnYn;
    private String patPhotoInDbYn;
    private String registeredInMoYn;
    private String deceasedFacilityId;
    private Long deceasedEncounterId;
    private String familyOrgSubId;
    private String familyOrgMembership;
    private Date patCatCodeExpDate;
    private String motherPatientId;
    private String fatherPatientId;
    private String practitionerId;
    private String sourceType;
    private String sourceCode;
    private Set prPatientValuableses;
    private Set cpPatCarePlanOutcomes;
    private Set ipTransferRequests;
    private Set mpBirthRegistersForMotherPatientId;
    private Set prProblemAssessments;
    private Set caPatTaskLists;
    private Set ipNursingUnitBedsForMothersPatientId;
    private Set oaApptDelTrs;
    private Set moBedForAreas;
    private Set ipAdtTrnAuditLogs;
    private Set aeSpareBayses;
    private Set cpPatCarePlanRevisions;
    private Set opPatientTrackingLocns;
    private Set mrMedEventLogs;
    private Set dsEpsdDietProfileHdrs;
    private Set prHighRiskConditions;
    private Set ipBedBookings;
    private Set aeBedForTrmtAreas;
    private Set ipPatientLastEncounters;
    private Set fmPullingLists;
    private Set cpPatCarePlanGoals;
    private Set prSickLeaveRegisters;
    private Set prAdvDrugReactions;
    private Set mrPatOtherMedInfos;
    private Set ipAdtTrns;
    private Set prDiagnosises;
    private Set cpPatCarePlanIntvns;
    private Set moMortuaryRegns;
    private Set mpPatAddresseses;
    private Set mpPatDocumentses;
    private Set atAnaesthesiaRecordHdrs;
    private Set aeCurrentPatients;
    private Set oaAppts;
    private Set fmTransitFiles;
    private Set opPatientQueues;
    private Set mpPatOthDtlses;
    private Set mpBirthRegistersForFatherPatientId;
    private Set cpPatCarePlanManagers;
    private Set mrReportRequestHdrs;
    private Set ipNursingUnitBedsForOccupyingPatientId;
    private Set prPorterageDetailses;
    private Set caEncntrDiscrMsrs;
    private Set mrPatFileIndexes;
    private Set fmMovementLogs;
    private Set cpPatCarePlanIntvnDtls;
    private Set orConsentRefHdrs;
    private Set prWaitLists;
    private Set mpPatRelContactses;
    private Set opCurrentPatients;
    private Set otPostOperHdrs;
    private Set caEncntrPractRelns;
    private Set mpPatientPhotos;
    private Set cpPatMdCarePlans;
    private Set cpPatCarePlans;
    private Set ipOpenEncounters;
    private Set mrReportRequestDtls;
    private Set mrReportRequestRevDtls;
    private Set prEpisodeOfCares;
    private Set fmIpPullingLists;
    private Set cpPatCarePlanTermCodes;
    private Set prReferralRegisters;
    private Set opLastVisitForServices;
    private Set phPatientVaccProfiles;
    private Set prEncounterProcedures;
    private Set prEncounters;
    private Set phPatientDrugProfiles;
}
