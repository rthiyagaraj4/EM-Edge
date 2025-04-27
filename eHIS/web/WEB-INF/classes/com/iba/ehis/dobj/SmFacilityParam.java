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
//            SmFacilityLevel, SmSiteParam

public class SmFacilityParam
    implements Serializable
{

    public SmFacilityParam()
    {
        smReportForFcies = new HashSet(0);
        prAllergiesForOnsetFacilityId = new HashSet(0);
        caPractByLocns = new HashSet(0);
        ipMlyMedSerGrpBkgStats = new HashSet(0);
        rsShiftPatterns = new HashSet(0);
        phDispLocns = new HashSet(0);
        prEpisodeOfCaresForOpenFacilityId = new HashSet(0);
        oaClinicSchedules = new HashSet(0);
        opQueueNumForLocns = new HashSet(0);
        drDupGroupDtlses = new HashSet(0);
        ipNursingUnitBeds = new HashSet(0);
        rsStaffLicensures = new HashSet(0);
        stFacilityParams = new HashSet(0);
        ipNursingUnitForPracts = new HashSet(0);
        smGrpMasterCodesForMasterFacilityId = new HashSet(0);
        oaRosterForPracts = new HashSet(0);
        aePractForTmtAreas = new HashSet(0);
        ipDlyMedSerGrpBkgStats = new HashSet(0);
        ipNursingUnitRooms = new HashSet(0);
        mrDiagGroups = new HashSet(0);
        smApplUsers = new HashSet(0);
        prReferralRegistersForFromFacilityId = new HashSet(0);
        prProblemsForCloseFacilityId = new HashSet(0);
        amFacilityServices = new HashSet(0);
        mrRequestors = new HashSet(0);
        amOperStns = new HashSet(0);
        drMergedPatientDtlses = new HashSet(0);
        opEpisodeForServices = new HashSet(0);
        fmCurrLocnsForCurrFacilityId = new HashSet(0);
        mpParamForFacilities = new HashSet(0);
        prEncounters = new HashSet(0);
        fmMovementLogsForFacilityId = new HashSet(0);
        smAccEntityParamFacls = new HashSet(0);
        mrMdsForTermSets = new HashSet(0);
        oaApptStatses = new HashSet(0);
        aeTmtAreaForClinics = new HashSet(0);
        smGrpMasterCodesForFacilityId = new HashSet(0);
        fmIpPullingLists = new HashSet(0);
        fmTransitFilesForDestFacilityId = new HashSet(0);
        orOrderSetByIndexes = new HashSet(0);
        cpPatCarePlans = new HashSet(0);
        ssPhyInvParams = new HashSet(0);
        opClinics = new HashSet(0);
        rsWorkplaces = new HashSet(0);
        prPorterageDetailses = new HashSet(0);
        prAllergiesForCloseFacilityId = new HashSet(0);
        opPatientTrackingLocns = new HashSet(0);
        ipAdtTrns = new HashSet(0);
        opOnlineReports = new HashSet(0);
        xhApplForFacilities = new HashSet(0);
        amOtherStaffs = new HashSet(0);
        phPatientVaccProfiles = new HashSet(0);
        fmReqHdrs = new HashSet(0);
        oaUserClinicRightses = new HashSet(0);
        prPatientValuableses = new HashSet(0);
        phOrderRoutingDtlsForPerformingFacilityId = new HashSet(0);
        stTrnDocTypes = new HashSet(0);
        ipNursingUnits = new HashSet(0);
        mrUserAccessRightses = new HashSet(0);
        phWsForTokenSerieses = new HashSet(0);
        phOrderRoutingDtlsForOrderingFacilityId = new HashSet(0);
        orOrderTypeRoutings = new HashSet(0);
        amRefIdNumForFcies = new HashSet(0);
        amOtherStaffForFacilities = new HashSet(0);
        oaClinicBreaks = new HashSet(0);
        opPractForClinics = new HashSet(0);
        opPatientQueueSumms = new HashSet(0);
        orOrderFacilityCrossRefsForOrderingFacilityId = new HashSet(0);
        mrTermSetForFacilities = new HashSet(0);
        opVisitTypeForClinics = new HashSet(0);
        amFacilitySubsrvcs = new HashSet(0);
        phOrderRoutingsForOrderingFacilityId = new HashSet(0);
        aeOnlineReports = new HashSet(0);
        caEncntrDiscrMsrs = new HashSet(0);
        ipDlyAgeGrpBkgStats = new HashSet(0);
        fmDeficiencyHdrs = new HashSet(0);
        amDeptForFacilityRooms = new HashSet(0);
        orOrderFacilityCrossRefsForPerformingFacilityId = new HashSet(0);
        fmReqDtlsForReqToFacilityId = new HashSet(0);
        orPerformingDeptlocs = new HashSet(0);
        oaHolidaies = new HashSet(0);
        oaTransRecords = new HashSet(0);
        fmMovementLogsForSrcFacilityId = new HashSet(0);
        rsStaffExperiences = new HashSet(0);
        aePatMovementLogs = new HashSet(0);
        prEncounterProcedures = new HashSet(0);
        ssFacilityParams = new HashSet(0);
        oaClinicScheduleBreaks = new HashSet(0);
        caEncntrPractRelns = new HashSet(0);
        amBldngs = new HashSet(0);
        oaApptSrlNos = new HashSet(0);
        ssServiceLocations = new HashSet(0);
        opPatientQueues = new HashSet(0);
        prEncounterPracts = new HashSet(0);
        phFacilityParams = new HashSet(0);
        fmParameters = new HashSet(0);
        phTokenSerieses = new HashSet(0);
        amPractSpecialitieses = new HashSet(0);
        amBldngFloors = new HashSet(0);
        ipMedSerGrpNursUtTypes = new HashSet(0);
        oaClinicTimeTables = new HashSet(0);
        cpPositionForMdcps = new HashSet(0);
        prWaitLists = new HashSet(0);
        mmStores = new HashSet(0);
        mpPatientsForPrefFacilityId = new HashSet(0);
        ipDlyNursUtBkgStats = new HashSet(0);
        prReferralRegistersForToFacilityId = new HashSet(0);
        opLastVisitForServices = new HashSet(0);
        mpPatientsForRegnFacilityId = new HashSet(0);
        amFacilityRooms = new HashSet(0);
        smFacilityForResps = new HashSet(0);
        fmCurrLocnsForFacilityId = new HashSet(0);
        ipBedBookingSrlCtrls = new HashSet(0);
        fmMovementLogsForDestFacilityId = new HashSet(0);
        stPrepareLocations = new HashSet(0);
        caApplTaskForSplties = new HashSet(0);
        amPractitioners = new HashSet(0);
        opParams = new HashSet(0);
        mrFileTypes = new HashSet(0);
        ipNursingUnitLocations = new HashSet(0);
        fmDeficiencyDtls = new HashSet(0);
        ipTransferPriorities = new HashSet(0);
        rsStaffUnavailabilityLogs = new HashSet(0);
        prProblemsForOnsetFacilityId = new HashSet(0);
        oaClinicScheduleValidities = new HashSet(0);
        fmReqDtlsForCurrFacilityId = new HashSet(0);
        opParamForFacilityServices = new HashSet(0);
        smFacilityForUsers = new HashSet(0);
        caEncntrNotes = new HashSet(0);
        caApplTaskForRespRelns = new HashSet(0);
        fmUserAccessRightses = new HashSet(0);
        aePatEmergencyDetails = new HashSet(0);
        amPractForFacilities = new HashSet(0);
        caNoteTypeForSplties = new HashSet(0);
        amFacilityDepts = new HashSet(0);
        ipBookLimitByNursUts = new HashSet(0);
        fmPullingLists = new HashSet(0);
        amRestrnForOperStns = new HashSet(0);
        oaApptDelTrs = new HashSet(0);
        smModulesFacilities = new HashSet(0);
        phOrderRoutingsForPerformingFacilityId = new HashSet(0);
        fmTransitFilesForSrcFacilityId = new HashSet(0);
        ipBookLimitByAgeGrps = new HashSet(0);
        prEncIdNumForFcies = new HashSet(0);
        phDispRightses = new HashSet(0);
        ipBedBookings = new HashSet(0);
        mrSections = new HashSet(0);
        caNoteTypeByServs = new HashSet(0);
        fmStorageLocns = new HashSet(0);
        ipBookingLists = new HashSet(0);
        mrPatFileIndexes = new HashSet(0);
        ipMedicalServiceGroups = new HashSet(0);
        smPrintRoutings = new HashSet(0);
        aeCurrentPatients = new HashSet(0);
        opCurrentPatients = new HashSet(0);
        drSearchCriterias = new HashSet(0);
        stRepackingGroups = new HashSet(0);
        prEpisodeOfCaresForResolveFacilityId = new HashSet(0);
        oaAppts = new HashSet(0);
        amMedicalTeams = new HashSet(0);
        rsStaffTrainings = new HashSet(0);
        opVisitTypes = new HashSet(0);
        qaQindFacilityClinds = new HashSet(0);
        aePatRelatedContactses = new HashSet(0);
        oaBlockAppts = new HashSet(0);
        prEpisodeOfCaresForErrorFacilityId = new HashSet(0);
    }

    public SmFacilityParam(String facilityId, SmSiteParam smSiteParam, String facilityName, String facilityType, String status, String wsByIpName, String addedById, 
            Date addedDate, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String faxInterfaceYn, String mailInterfaceYn, 
            String displaySiteNameYn)
    {
        smReportForFcies = new HashSet(0);
        prAllergiesForOnsetFacilityId = new HashSet(0);
        caPractByLocns = new HashSet(0);
        ipMlyMedSerGrpBkgStats = new HashSet(0);
        rsShiftPatterns = new HashSet(0);
        phDispLocns = new HashSet(0);
        prEpisodeOfCaresForOpenFacilityId = new HashSet(0);
        oaClinicSchedules = new HashSet(0);
        opQueueNumForLocns = new HashSet(0);
        drDupGroupDtlses = new HashSet(0);
        ipNursingUnitBeds = new HashSet(0);
        rsStaffLicensures = new HashSet(0);
        stFacilityParams = new HashSet(0);
        ipNursingUnitForPracts = new HashSet(0);
        smGrpMasterCodesForMasterFacilityId = new HashSet(0);
        oaRosterForPracts = new HashSet(0);
        aePractForTmtAreas = new HashSet(0);
        ipDlyMedSerGrpBkgStats = new HashSet(0);
        ipNursingUnitRooms = new HashSet(0);
        mrDiagGroups = new HashSet(0);
        smApplUsers = new HashSet(0);
        prReferralRegistersForFromFacilityId = new HashSet(0);
        prProblemsForCloseFacilityId = new HashSet(0);
        amFacilityServices = new HashSet(0);
        mrRequestors = new HashSet(0);
        amOperStns = new HashSet(0);
        drMergedPatientDtlses = new HashSet(0);
        opEpisodeForServices = new HashSet(0);
        fmCurrLocnsForCurrFacilityId = new HashSet(0);
        mpParamForFacilities = new HashSet(0);
        prEncounters = new HashSet(0);
        fmMovementLogsForFacilityId = new HashSet(0);
        smAccEntityParamFacls = new HashSet(0);
        mrMdsForTermSets = new HashSet(0);
        oaApptStatses = new HashSet(0);
        aeTmtAreaForClinics = new HashSet(0);
        smGrpMasterCodesForFacilityId = new HashSet(0);
        fmIpPullingLists = new HashSet(0);
        fmTransitFilesForDestFacilityId = new HashSet(0);
        orOrderSetByIndexes = new HashSet(0);
        cpPatCarePlans = new HashSet(0);
        ssPhyInvParams = new HashSet(0);
        opClinics = new HashSet(0);
        rsWorkplaces = new HashSet(0);
        prPorterageDetailses = new HashSet(0);
        prAllergiesForCloseFacilityId = new HashSet(0);
        opPatientTrackingLocns = new HashSet(0);
        ipAdtTrns = new HashSet(0);
        opOnlineReports = new HashSet(0);
        xhApplForFacilities = new HashSet(0);
        amOtherStaffs = new HashSet(0);
        phPatientVaccProfiles = new HashSet(0);
        fmReqHdrs = new HashSet(0);
        oaUserClinicRightses = new HashSet(0);
        prPatientValuableses = new HashSet(0);
        phOrderRoutingDtlsForPerformingFacilityId = new HashSet(0);
        stTrnDocTypes = new HashSet(0);
        ipNursingUnits = new HashSet(0);
        mrUserAccessRightses = new HashSet(0);
        phWsForTokenSerieses = new HashSet(0);
        phOrderRoutingDtlsForOrderingFacilityId = new HashSet(0);
        orOrderTypeRoutings = new HashSet(0);
        amRefIdNumForFcies = new HashSet(0);
        amOtherStaffForFacilities = new HashSet(0);
        oaClinicBreaks = new HashSet(0);
        opPractForClinics = new HashSet(0);
        opPatientQueueSumms = new HashSet(0);
        orOrderFacilityCrossRefsForOrderingFacilityId = new HashSet(0);
        mrTermSetForFacilities = new HashSet(0);
        opVisitTypeForClinics = new HashSet(0);
        amFacilitySubsrvcs = new HashSet(0);
        phOrderRoutingsForOrderingFacilityId = new HashSet(0);
        aeOnlineReports = new HashSet(0);
        caEncntrDiscrMsrs = new HashSet(0);
        ipDlyAgeGrpBkgStats = new HashSet(0);
        fmDeficiencyHdrs = new HashSet(0);
        amDeptForFacilityRooms = new HashSet(0);
        orOrderFacilityCrossRefsForPerformingFacilityId = new HashSet(0);
        fmReqDtlsForReqToFacilityId = new HashSet(0);
        orPerformingDeptlocs = new HashSet(0);
        oaHolidaies = new HashSet(0);
        oaTransRecords = new HashSet(0);
        fmMovementLogsForSrcFacilityId = new HashSet(0);
        rsStaffExperiences = new HashSet(0);
        aePatMovementLogs = new HashSet(0);
        prEncounterProcedures = new HashSet(0);
        ssFacilityParams = new HashSet(0);
        oaClinicScheduleBreaks = new HashSet(0);
        caEncntrPractRelns = new HashSet(0);
        amBldngs = new HashSet(0);
        oaApptSrlNos = new HashSet(0);
        ssServiceLocations = new HashSet(0);
        opPatientQueues = new HashSet(0);
        prEncounterPracts = new HashSet(0);
        phFacilityParams = new HashSet(0);
        fmParameters = new HashSet(0);
        phTokenSerieses = new HashSet(0);
        amPractSpecialitieses = new HashSet(0);
        amBldngFloors = new HashSet(0);
        ipMedSerGrpNursUtTypes = new HashSet(0);
        oaClinicTimeTables = new HashSet(0);
        cpPositionForMdcps = new HashSet(0);
        prWaitLists = new HashSet(0);
        mmStores = new HashSet(0);
        mpPatientsForPrefFacilityId = new HashSet(0);
        ipDlyNursUtBkgStats = new HashSet(0);
        prReferralRegistersForToFacilityId = new HashSet(0);
        opLastVisitForServices = new HashSet(0);
        mpPatientsForRegnFacilityId = new HashSet(0);
        amFacilityRooms = new HashSet(0);
        smFacilityForResps = new HashSet(0);
        fmCurrLocnsForFacilityId = new HashSet(0);
        ipBedBookingSrlCtrls = new HashSet(0);
        fmMovementLogsForDestFacilityId = new HashSet(0);
        stPrepareLocations = new HashSet(0);
        caApplTaskForSplties = new HashSet(0);
        amPractitioners = new HashSet(0);
        opParams = new HashSet(0);
        mrFileTypes = new HashSet(0);
        ipNursingUnitLocations = new HashSet(0);
        fmDeficiencyDtls = new HashSet(0);
        ipTransferPriorities = new HashSet(0);
        rsStaffUnavailabilityLogs = new HashSet(0);
        prProblemsForOnsetFacilityId = new HashSet(0);
        oaClinicScheduleValidities = new HashSet(0);
        fmReqDtlsForCurrFacilityId = new HashSet(0);
        opParamForFacilityServices = new HashSet(0);
        smFacilityForUsers = new HashSet(0);
        caEncntrNotes = new HashSet(0);
        caApplTaskForRespRelns = new HashSet(0);
        fmUserAccessRightses = new HashSet(0);
        aePatEmergencyDetails = new HashSet(0);
        amPractForFacilities = new HashSet(0);
        caNoteTypeForSplties = new HashSet(0);
        amFacilityDepts = new HashSet(0);
        ipBookLimitByNursUts = new HashSet(0);
        fmPullingLists = new HashSet(0);
        amRestrnForOperStns = new HashSet(0);
        oaApptDelTrs = new HashSet(0);
        smModulesFacilities = new HashSet(0);
        phOrderRoutingsForPerformingFacilityId = new HashSet(0);
        fmTransitFilesForSrcFacilityId = new HashSet(0);
        ipBookLimitByAgeGrps = new HashSet(0);
        prEncIdNumForFcies = new HashSet(0);
        phDispRightses = new HashSet(0);
        ipBedBookings = new HashSet(0);
        mrSections = new HashSet(0);
        caNoteTypeByServs = new HashSet(0);
        fmStorageLocns = new HashSet(0);
        ipBookingLists = new HashSet(0);
        mrPatFileIndexes = new HashSet(0);
        ipMedicalServiceGroups = new HashSet(0);
        smPrintRoutings = new HashSet(0);
        aeCurrentPatients = new HashSet(0);
        opCurrentPatients = new HashSet(0);
        drSearchCriterias = new HashSet(0);
        stRepackingGroups = new HashSet(0);
        prEpisodeOfCaresForResolveFacilityId = new HashSet(0);
        oaAppts = new HashSet(0);
        amMedicalTeams = new HashSet(0);
        rsStaffTrainings = new HashSet(0);
        opVisitTypes = new HashSet(0);
        qaQindFacilityClinds = new HashSet(0);
        aePatRelatedContactses = new HashSet(0);
        oaBlockAppts = new HashSet(0);
        prEpisodeOfCaresForErrorFacilityId = new HashSet(0);
        this.facilityId = facilityId;
        this.smSiteParam = smSiteParam;
        this.facilityName = facilityName;
        this.facilityType = facilityType;
        this.status = status;
        this.wsByIpName = wsByIpName;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.faxInterfaceYn = faxInterfaceYn;
        this.mailInterfaceYn = mailInterfaceYn;
        this.displaySiteNameYn = displaySiteNameYn;
    }

    public SmFacilityParam(String facilityId, SmFacilityLevel smFacilityLevel, SmSiteParam smSiteParam, String facilityName, String addrLine1, String addrLine2, String addrLine3, 
            String addrLine4, String addrPostalCode, String countryCode, String telNo1, String telNo2, String telNo3, String telNo4, 
            String faxNo, String emailId, String websiteId, String headOfFacilityName, String headOfFacilityJobTitle, String licenseNo, String facilityType, 
            String masterFacilityId, String hcareSettingTypeCode, String facilityClass, String languageId, String appServerIp, String status, String wsByIpName, 
            String addedById, Date addedDate, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String faxInterfaceYn, 
            String mailInterfaceYn, String resAreaCode, String resTownCode, String regionCode, String facilityLogo, String displaySiteNameYn, Set smReportForFcies, 
            Set prAllergiesForOnsetFacilityId, Set caPractByLocns, Set ipMlyMedSerGrpBkgStats, Set rsShiftPatterns, Set phDispLocns, Set prEpisodeOfCaresForOpenFacilityId, Set oaClinicSchedules, 
            Set opQueueNumForLocns, Set drDupGroupDtlses, Set ipNursingUnitBeds, Set rsStaffLicensures, Set stFacilityParams, Set ipNursingUnitForPracts, Set smGrpMasterCodesForMasterFacilityId, 
            Set oaRosterForPracts, Set aePractForTmtAreas, Set ipDlyMedSerGrpBkgStats, Set ipNursingUnitRooms, Set mrDiagGroups, Set smApplUsers, Set prReferralRegistersForFromFacilityId, 
            Set prProblemsForCloseFacilityId, Set amFacilityServices, Set mrRequestors, Set amOperStns, Set drMergedPatientDtlses, Set opEpisodeForServices, Set fmCurrLocnsForCurrFacilityId, 
            Set mpParamForFacilities, Set prEncounters, Set fmMovementLogsForFacilityId, Set smAccEntityParamFacls, Set mrMdsForTermSets, Set oaApptStatses, Set aeTmtAreaForClinics, 
            Set smGrpMasterCodesForFacilityId, Set fmIpPullingLists, Set fmTransitFilesForDestFacilityId, Set orOrderSetByIndexes, Set cpPatCarePlans, Set ssPhyInvParams, Set opClinics, 
            Set rsWorkplaces, Set prPorterageDetailses, Set prAllergiesForCloseFacilityId, Set opPatientTrackingLocns, Set ipAdtTrns, Set opOnlineReports, Set xhApplForFacilities, 
            Set amOtherStaffs, Set phPatientVaccProfiles, Set fmReqHdrs, Set oaUserClinicRightses, Set prPatientValuableses, Set phOrderRoutingDtlsForPerformingFacilityId, Set stTrnDocTypes, 
            Set ipNursingUnits, Set mrUserAccessRightses, Set phWsForTokenSerieses, Set phOrderRoutingDtlsForOrderingFacilityId, Set orOrderTypeRoutings, Set amRefIdNumForFcies, Set amOtherStaffForFacilities, 
            Set oaClinicBreaks, Set opPractForClinics, Set opPatientQueueSumms, Set orOrderFacilityCrossRefsForOrderingFacilityId, Set mrTermSetForFacilities, Set opVisitTypeForClinics, Set amFacilitySubsrvcs, 
            Set phOrderRoutingsForOrderingFacilityId, Set aeOnlineReports, Set caEncntrDiscrMsrs, Set ipDlyAgeGrpBkgStats, Set fmDeficiencyHdrs, Set amDeptForFacilityRooms, Set orOrderFacilityCrossRefsForPerformingFacilityId, 
            Set fmReqDtlsForReqToFacilityId, Set orPerformingDeptlocs, Set oaHolidaies, Set oaTransRecords, Set fmMovementLogsForSrcFacilityId, Set rsStaffExperiences, Set aePatMovementLogs, 
            Set prEncounterProcedures, Set ssFacilityParams, Set oaClinicScheduleBreaks, Set caEncntrPractRelns, Set amBldngs, Set oaApptSrlNos, Set ssServiceLocations, 
            Set opPatientQueues, Set prEncounterPracts, Set phFacilityParams, Set fmParameters, Set phTokenSerieses, Set amPractSpecialitieses, Set amBldngFloors, 
            Set ipMedSerGrpNursUtTypes, Set oaClinicTimeTables, Set cpPositionForMdcps, Set prWaitLists, Set mmStores, Set mpPatientsForPrefFacilityId, Set ipDlyNursUtBkgStats, 
            Set prReferralRegistersForToFacilityId, Set opLastVisitForServices, Set mpPatientsForRegnFacilityId, Set amFacilityRooms, Set smFacilityForResps, Set fmCurrLocnsForFacilityId, Set ipBedBookingSrlCtrls, 
            Set fmMovementLogsForDestFacilityId, Set stPrepareLocations, Set caApplTaskForSplties, Set amPractitioners, Set opParams, Set mrFileTypes, Set ipNursingUnitLocations, 
            Set fmDeficiencyDtls, Set ipTransferPriorities, Set rsStaffUnavailabilityLogs, Set prProblemsForOnsetFacilityId, Set oaClinicScheduleValidities, Set fmReqDtlsForCurrFacilityId, Set opParamForFacilityServices, 
            Set smFacilityForUsers, Set caEncntrNotes, Set caApplTaskForRespRelns, Set fmUserAccessRightses, Set aePatEmergencyDetails, Set amPractForFacilities, Set caNoteTypeForSplties, 
            Set amFacilityDepts, Set ipBookLimitByNursUts, Set fmPullingLists, Set amRestrnForOperStns, Set oaApptDelTrs, Set smModulesFacilities, Set phOrderRoutingsForPerformingFacilityId, 
            Set fmTransitFilesForSrcFacilityId, Set ipBookLimitByAgeGrps, Set prEncIdNumForFcies, Set phDispRightses, Set ipBedBookings, Set mrSections, Set caNoteTypeByServs, 
            Set fmStorageLocns, Set ipBookingLists, Set mrPatFileIndexes, Set ipMedicalServiceGroups, Set smPrintRoutings, Set aeCurrentPatients, Set opCurrentPatients, 
            Set drSearchCriterias, Set stRepackingGroups, Set prEpisodeOfCaresForResolveFacilityId, Set oaAppts, Set amMedicalTeams, Set rsStaffTrainings, Set opVisitTypes, 
            Set qaQindFacilityClinds, Set aePatRelatedContactses, Set oaBlockAppts, Set prEpisodeOfCaresForErrorFacilityId)
    {
        this.smReportForFcies = new HashSet(0);
        this.prAllergiesForOnsetFacilityId = new HashSet(0);
        this.caPractByLocns = new HashSet(0);
        this.ipMlyMedSerGrpBkgStats = new HashSet(0);
        this.rsShiftPatterns = new HashSet(0);
        this.phDispLocns = new HashSet(0);
        this.prEpisodeOfCaresForOpenFacilityId = new HashSet(0);
        this.oaClinicSchedules = new HashSet(0);
        this.opQueueNumForLocns = new HashSet(0);
        this.drDupGroupDtlses = new HashSet(0);
        this.ipNursingUnitBeds = new HashSet(0);
        this.rsStaffLicensures = new HashSet(0);
        this.stFacilityParams = new HashSet(0);
        this.ipNursingUnitForPracts = new HashSet(0);
        this.smGrpMasterCodesForMasterFacilityId = new HashSet(0);
        this.oaRosterForPracts = new HashSet(0);
        this.aePractForTmtAreas = new HashSet(0);
        this.ipDlyMedSerGrpBkgStats = new HashSet(0);
        this.ipNursingUnitRooms = new HashSet(0);
        this.mrDiagGroups = new HashSet(0);
        this.smApplUsers = new HashSet(0);
        this.prReferralRegistersForFromFacilityId = new HashSet(0);
        this.prProblemsForCloseFacilityId = new HashSet(0);
        this.amFacilityServices = new HashSet(0);
        this.mrRequestors = new HashSet(0);
        this.amOperStns = new HashSet(0);
        this.drMergedPatientDtlses = new HashSet(0);
        this.opEpisodeForServices = new HashSet(0);
        this.fmCurrLocnsForCurrFacilityId = new HashSet(0);
        this.mpParamForFacilities = new HashSet(0);
        this.prEncounters = new HashSet(0);
        this.fmMovementLogsForFacilityId = new HashSet(0);
        this.smAccEntityParamFacls = new HashSet(0);
        this.mrMdsForTermSets = new HashSet(0);
        this.oaApptStatses = new HashSet(0);
        this.aeTmtAreaForClinics = new HashSet(0);
        this.smGrpMasterCodesForFacilityId = new HashSet(0);
        this.fmIpPullingLists = new HashSet(0);
        this.fmTransitFilesForDestFacilityId = new HashSet(0);
        this.orOrderSetByIndexes = new HashSet(0);
        this.cpPatCarePlans = new HashSet(0);
        this.ssPhyInvParams = new HashSet(0);
        this.opClinics = new HashSet(0);
        this.rsWorkplaces = new HashSet(0);
        this.prPorterageDetailses = new HashSet(0);
        this.prAllergiesForCloseFacilityId = new HashSet(0);
        this.opPatientTrackingLocns = new HashSet(0);
        this.ipAdtTrns = new HashSet(0);
        this.opOnlineReports = new HashSet(0);
        this.xhApplForFacilities = new HashSet(0);
        this.amOtherStaffs = new HashSet(0);
        this.phPatientVaccProfiles = new HashSet(0);
        this.fmReqHdrs = new HashSet(0);
        this.oaUserClinicRightses = new HashSet(0);
        this.prPatientValuableses = new HashSet(0);
        this.phOrderRoutingDtlsForPerformingFacilityId = new HashSet(0);
        this.stTrnDocTypes = new HashSet(0);
        this.ipNursingUnits = new HashSet(0);
        this.mrUserAccessRightses = new HashSet(0);
        this.phWsForTokenSerieses = new HashSet(0);
        this.phOrderRoutingDtlsForOrderingFacilityId = new HashSet(0);
        this.orOrderTypeRoutings = new HashSet(0);
        this.amRefIdNumForFcies = new HashSet(0);
        this.amOtherStaffForFacilities = new HashSet(0);
        this.oaClinicBreaks = new HashSet(0);
        this.opPractForClinics = new HashSet(0);
        this.opPatientQueueSumms = new HashSet(0);
        this.orOrderFacilityCrossRefsForOrderingFacilityId = new HashSet(0);
        this.mrTermSetForFacilities = new HashSet(0);
        this.opVisitTypeForClinics = new HashSet(0);
        this.amFacilitySubsrvcs = new HashSet(0);
        this.phOrderRoutingsForOrderingFacilityId = new HashSet(0);
        this.aeOnlineReports = new HashSet(0);
        this.caEncntrDiscrMsrs = new HashSet(0);
        this.ipDlyAgeGrpBkgStats = new HashSet(0);
        this.fmDeficiencyHdrs = new HashSet(0);
        this.amDeptForFacilityRooms = new HashSet(0);
        this.orOrderFacilityCrossRefsForPerformingFacilityId = new HashSet(0);
        this.fmReqDtlsForReqToFacilityId = new HashSet(0);
        this.orPerformingDeptlocs = new HashSet(0);
        this.oaHolidaies = new HashSet(0);
        this.oaTransRecords = new HashSet(0);
        this.fmMovementLogsForSrcFacilityId = new HashSet(0);
        this.rsStaffExperiences = new HashSet(0);
        this.aePatMovementLogs = new HashSet(0);
        this.prEncounterProcedures = new HashSet(0);
        this.ssFacilityParams = new HashSet(0);
        this.oaClinicScheduleBreaks = new HashSet(0);
        this.caEncntrPractRelns = new HashSet(0);
        this.amBldngs = new HashSet(0);
        this.oaApptSrlNos = new HashSet(0);
        this.ssServiceLocations = new HashSet(0);
        this.opPatientQueues = new HashSet(0);
        this.prEncounterPracts = new HashSet(0);
        this.phFacilityParams = new HashSet(0);
        this.fmParameters = new HashSet(0);
        this.phTokenSerieses = new HashSet(0);
        this.amPractSpecialitieses = new HashSet(0);
        this.amBldngFloors = new HashSet(0);
        this.ipMedSerGrpNursUtTypes = new HashSet(0);
        this.oaClinicTimeTables = new HashSet(0);
        this.cpPositionForMdcps = new HashSet(0);
        this.prWaitLists = new HashSet(0);
        this.mmStores = new HashSet(0);
        this.mpPatientsForPrefFacilityId = new HashSet(0);
        this.ipDlyNursUtBkgStats = new HashSet(0);
        this.prReferralRegistersForToFacilityId = new HashSet(0);
        this.opLastVisitForServices = new HashSet(0);
        this.mpPatientsForRegnFacilityId = new HashSet(0);
        this.amFacilityRooms = new HashSet(0);
        this.smFacilityForResps = new HashSet(0);
        this.fmCurrLocnsForFacilityId = new HashSet(0);
        this.ipBedBookingSrlCtrls = new HashSet(0);
        this.fmMovementLogsForDestFacilityId = new HashSet(0);
        this.stPrepareLocations = new HashSet(0);
        this.caApplTaskForSplties = new HashSet(0);
        this.amPractitioners = new HashSet(0);
        this.opParams = new HashSet(0);
        this.mrFileTypes = new HashSet(0);
        this.ipNursingUnitLocations = new HashSet(0);
        this.fmDeficiencyDtls = new HashSet(0);
        this.ipTransferPriorities = new HashSet(0);
        this.rsStaffUnavailabilityLogs = new HashSet(0);
        this.prProblemsForOnsetFacilityId = new HashSet(0);
        this.oaClinicScheduleValidities = new HashSet(0);
        this.fmReqDtlsForCurrFacilityId = new HashSet(0);
        this.opParamForFacilityServices = new HashSet(0);
        this.smFacilityForUsers = new HashSet(0);
        this.caEncntrNotes = new HashSet(0);
        this.caApplTaskForRespRelns = new HashSet(0);
        this.fmUserAccessRightses = new HashSet(0);
        this.aePatEmergencyDetails = new HashSet(0);
        this.amPractForFacilities = new HashSet(0);
        this.caNoteTypeForSplties = new HashSet(0);
        this.amFacilityDepts = new HashSet(0);
        this.ipBookLimitByNursUts = new HashSet(0);
        this.fmPullingLists = new HashSet(0);
        this.amRestrnForOperStns = new HashSet(0);
        this.oaApptDelTrs = new HashSet(0);
        this.smModulesFacilities = new HashSet(0);
        this.phOrderRoutingsForPerformingFacilityId = new HashSet(0);
        this.fmTransitFilesForSrcFacilityId = new HashSet(0);
        this.ipBookLimitByAgeGrps = new HashSet(0);
        this.prEncIdNumForFcies = new HashSet(0);
        this.phDispRightses = new HashSet(0);
        this.ipBedBookings = new HashSet(0);
        this.mrSections = new HashSet(0);
        this.caNoteTypeByServs = new HashSet(0);
        this.fmStorageLocns = new HashSet(0);
        this.ipBookingLists = new HashSet(0);
        this.mrPatFileIndexes = new HashSet(0);
        this.ipMedicalServiceGroups = new HashSet(0);
        this.smPrintRoutings = new HashSet(0);
        this.aeCurrentPatients = new HashSet(0);
        this.opCurrentPatients = new HashSet(0);
        this.drSearchCriterias = new HashSet(0);
        this.stRepackingGroups = new HashSet(0);
        this.prEpisodeOfCaresForResolveFacilityId = new HashSet(0);
        this.oaAppts = new HashSet(0);
        this.amMedicalTeams = new HashSet(0);
        this.rsStaffTrainings = new HashSet(0);
        this.opVisitTypes = new HashSet(0);
        this.qaQindFacilityClinds = new HashSet(0);
        this.aePatRelatedContactses = new HashSet(0);
        this.oaBlockAppts = new HashSet(0);
        this.prEpisodeOfCaresForErrorFacilityId = new HashSet(0);
        this.facilityId = facilityId;
        this.smFacilityLevel = smFacilityLevel;
        this.smSiteParam = smSiteParam;
        this.facilityName = facilityName;
        this.addrLine1 = addrLine1;
        this.addrLine2 = addrLine2;
        this.addrLine3 = addrLine3;
        this.addrLine4 = addrLine4;
        this.addrPostalCode = addrPostalCode;
        this.countryCode = countryCode;
        this.telNo1 = telNo1;
        this.telNo2 = telNo2;
        this.telNo3 = telNo3;
        this.telNo4 = telNo4;
        this.faxNo = faxNo;
        this.emailId = emailId;
        this.websiteId = websiteId;
        this.headOfFacilityName = headOfFacilityName;
        this.headOfFacilityJobTitle = headOfFacilityJobTitle;
        this.licenseNo = licenseNo;
        this.facilityType = facilityType;
        this.masterFacilityId = masterFacilityId;
        this.hcareSettingTypeCode = hcareSettingTypeCode;
        this.facilityClass = facilityClass;
        this.languageId = languageId;
        this.appServerIp = appServerIp;
        this.status = status;
        this.wsByIpName = wsByIpName;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.faxInterfaceYn = faxInterfaceYn;
        this.mailInterfaceYn = mailInterfaceYn;
        this.resAreaCode = resAreaCode;
        this.resTownCode = resTownCode;
        this.regionCode = regionCode;
        this.facilityLogo = facilityLogo;
        this.displaySiteNameYn = displaySiteNameYn;
        this.smReportForFcies = smReportForFcies;
        this.prAllergiesForOnsetFacilityId = prAllergiesForOnsetFacilityId;
        this.caPractByLocns = caPractByLocns;
        this.ipMlyMedSerGrpBkgStats = ipMlyMedSerGrpBkgStats;
        this.rsShiftPatterns = rsShiftPatterns;
        this.phDispLocns = phDispLocns;
        this.prEpisodeOfCaresForOpenFacilityId = prEpisodeOfCaresForOpenFacilityId;
        this.oaClinicSchedules = oaClinicSchedules;
        this.opQueueNumForLocns = opQueueNumForLocns;
        this.drDupGroupDtlses = drDupGroupDtlses;
        this.ipNursingUnitBeds = ipNursingUnitBeds;
        this.rsStaffLicensures = rsStaffLicensures;
        this.stFacilityParams = stFacilityParams;
        this.ipNursingUnitForPracts = ipNursingUnitForPracts;
        this.smGrpMasterCodesForMasterFacilityId = smGrpMasterCodesForMasterFacilityId;
        this.oaRosterForPracts = oaRosterForPracts;
        this.aePractForTmtAreas = aePractForTmtAreas;
        this.ipDlyMedSerGrpBkgStats = ipDlyMedSerGrpBkgStats;
        this.ipNursingUnitRooms = ipNursingUnitRooms;
        this.mrDiagGroups = mrDiagGroups;
        this.smApplUsers = smApplUsers;
        this.prReferralRegistersForFromFacilityId = prReferralRegistersForFromFacilityId;
        this.prProblemsForCloseFacilityId = prProblemsForCloseFacilityId;
        this.amFacilityServices = amFacilityServices;
        this.mrRequestors = mrRequestors;
        this.amOperStns = amOperStns;
        this.drMergedPatientDtlses = drMergedPatientDtlses;
        this.opEpisodeForServices = opEpisodeForServices;
        this.fmCurrLocnsForCurrFacilityId = fmCurrLocnsForCurrFacilityId;
        this.mpParamForFacilities = mpParamForFacilities;
        this.prEncounters = prEncounters;
        this.fmMovementLogsForFacilityId = fmMovementLogsForFacilityId;
        this.smAccEntityParamFacls = smAccEntityParamFacls;
        this.mrMdsForTermSets = mrMdsForTermSets;
        this.oaApptStatses = oaApptStatses;
        this.aeTmtAreaForClinics = aeTmtAreaForClinics;
        this.smGrpMasterCodesForFacilityId = smGrpMasterCodesForFacilityId;
        this.fmIpPullingLists = fmIpPullingLists;
        this.fmTransitFilesForDestFacilityId = fmTransitFilesForDestFacilityId;
        this.orOrderSetByIndexes = orOrderSetByIndexes;
        this.cpPatCarePlans = cpPatCarePlans;
        this.ssPhyInvParams = ssPhyInvParams;
        this.opClinics = opClinics;
        this.rsWorkplaces = rsWorkplaces;
        this.prPorterageDetailses = prPorterageDetailses;
        this.prAllergiesForCloseFacilityId = prAllergiesForCloseFacilityId;
        this.opPatientTrackingLocns = opPatientTrackingLocns;
        this.ipAdtTrns = ipAdtTrns;
        this.opOnlineReports = opOnlineReports;
        this.xhApplForFacilities = xhApplForFacilities;
        this.amOtherStaffs = amOtherStaffs;
        this.phPatientVaccProfiles = phPatientVaccProfiles;
        this.fmReqHdrs = fmReqHdrs;
        this.oaUserClinicRightses = oaUserClinicRightses;
        this.prPatientValuableses = prPatientValuableses;
        this.phOrderRoutingDtlsForPerformingFacilityId = phOrderRoutingDtlsForPerformingFacilityId;
        this.stTrnDocTypes = stTrnDocTypes;
        this.ipNursingUnits = ipNursingUnits;
        this.mrUserAccessRightses = mrUserAccessRightses;
        this.phWsForTokenSerieses = phWsForTokenSerieses;
        this.phOrderRoutingDtlsForOrderingFacilityId = phOrderRoutingDtlsForOrderingFacilityId;
        this.orOrderTypeRoutings = orOrderTypeRoutings;
        this.amRefIdNumForFcies = amRefIdNumForFcies;
        this.amOtherStaffForFacilities = amOtherStaffForFacilities;
        this.oaClinicBreaks = oaClinicBreaks;
        this.opPractForClinics = opPractForClinics;
        this.opPatientQueueSumms = opPatientQueueSumms;
        this.orOrderFacilityCrossRefsForOrderingFacilityId = orOrderFacilityCrossRefsForOrderingFacilityId;
        this.mrTermSetForFacilities = mrTermSetForFacilities;
        this.opVisitTypeForClinics = opVisitTypeForClinics;
        this.amFacilitySubsrvcs = amFacilitySubsrvcs;
        this.phOrderRoutingsForOrderingFacilityId = phOrderRoutingsForOrderingFacilityId;
        this.aeOnlineReports = aeOnlineReports;
        this.caEncntrDiscrMsrs = caEncntrDiscrMsrs;
        this.ipDlyAgeGrpBkgStats = ipDlyAgeGrpBkgStats;
        this.fmDeficiencyHdrs = fmDeficiencyHdrs;
        this.amDeptForFacilityRooms = amDeptForFacilityRooms;
        this.orOrderFacilityCrossRefsForPerformingFacilityId = orOrderFacilityCrossRefsForPerformingFacilityId;
        this.fmReqDtlsForReqToFacilityId = fmReqDtlsForReqToFacilityId;
        this.orPerformingDeptlocs = orPerformingDeptlocs;
        this.oaHolidaies = oaHolidaies;
        this.oaTransRecords = oaTransRecords;
        this.fmMovementLogsForSrcFacilityId = fmMovementLogsForSrcFacilityId;
        this.rsStaffExperiences = rsStaffExperiences;
        this.aePatMovementLogs = aePatMovementLogs;
        this.prEncounterProcedures = prEncounterProcedures;
        this.ssFacilityParams = ssFacilityParams;
        this.oaClinicScheduleBreaks = oaClinicScheduleBreaks;
        this.caEncntrPractRelns = caEncntrPractRelns;
        this.amBldngs = amBldngs;
        this.oaApptSrlNos = oaApptSrlNos;
        this.ssServiceLocations = ssServiceLocations;
        this.opPatientQueues = opPatientQueues;
        this.prEncounterPracts = prEncounterPracts;
        this.phFacilityParams = phFacilityParams;
        this.fmParameters = fmParameters;
        this.phTokenSerieses = phTokenSerieses;
        this.amPractSpecialitieses = amPractSpecialitieses;
        this.amBldngFloors = amBldngFloors;
        this.ipMedSerGrpNursUtTypes = ipMedSerGrpNursUtTypes;
        this.oaClinicTimeTables = oaClinicTimeTables;
        this.cpPositionForMdcps = cpPositionForMdcps;
        this.prWaitLists = prWaitLists;
        this.mmStores = mmStores;
        this.mpPatientsForPrefFacilityId = mpPatientsForPrefFacilityId;
        this.ipDlyNursUtBkgStats = ipDlyNursUtBkgStats;
        this.prReferralRegistersForToFacilityId = prReferralRegistersForToFacilityId;
        this.opLastVisitForServices = opLastVisitForServices;
        this.mpPatientsForRegnFacilityId = mpPatientsForRegnFacilityId;
        this.amFacilityRooms = amFacilityRooms;
        this.smFacilityForResps = smFacilityForResps;
        this.fmCurrLocnsForFacilityId = fmCurrLocnsForFacilityId;
        this.ipBedBookingSrlCtrls = ipBedBookingSrlCtrls;
        this.fmMovementLogsForDestFacilityId = fmMovementLogsForDestFacilityId;
        this.stPrepareLocations = stPrepareLocations;
        this.caApplTaskForSplties = caApplTaskForSplties;
        this.amPractitioners = amPractitioners;
        this.opParams = opParams;
        this.mrFileTypes = mrFileTypes;
        this.ipNursingUnitLocations = ipNursingUnitLocations;
        this.fmDeficiencyDtls = fmDeficiencyDtls;
        this.ipTransferPriorities = ipTransferPriorities;
        this.rsStaffUnavailabilityLogs = rsStaffUnavailabilityLogs;
        this.prProblemsForOnsetFacilityId = prProblemsForOnsetFacilityId;
        this.oaClinicScheduleValidities = oaClinicScheduleValidities;
        this.fmReqDtlsForCurrFacilityId = fmReqDtlsForCurrFacilityId;
        this.opParamForFacilityServices = opParamForFacilityServices;
        this.smFacilityForUsers = smFacilityForUsers;
        this.caEncntrNotes = caEncntrNotes;
        this.caApplTaskForRespRelns = caApplTaskForRespRelns;
        this.fmUserAccessRightses = fmUserAccessRightses;
        this.aePatEmergencyDetails = aePatEmergencyDetails;
        this.amPractForFacilities = amPractForFacilities;
        this.caNoteTypeForSplties = caNoteTypeForSplties;
        this.amFacilityDepts = amFacilityDepts;
        this.ipBookLimitByNursUts = ipBookLimitByNursUts;
        this.fmPullingLists = fmPullingLists;
        this.amRestrnForOperStns = amRestrnForOperStns;
        this.oaApptDelTrs = oaApptDelTrs;
        this.smModulesFacilities = smModulesFacilities;
        this.phOrderRoutingsForPerformingFacilityId = phOrderRoutingsForPerformingFacilityId;
        this.fmTransitFilesForSrcFacilityId = fmTransitFilesForSrcFacilityId;
        this.ipBookLimitByAgeGrps = ipBookLimitByAgeGrps;
        this.prEncIdNumForFcies = prEncIdNumForFcies;
        this.phDispRightses = phDispRightses;
        this.ipBedBookings = ipBedBookings;
        this.mrSections = mrSections;
        this.caNoteTypeByServs = caNoteTypeByServs;
        this.fmStorageLocns = fmStorageLocns;
        this.ipBookingLists = ipBookingLists;
        this.mrPatFileIndexes = mrPatFileIndexes;
        this.ipMedicalServiceGroups = ipMedicalServiceGroups;
        this.smPrintRoutings = smPrintRoutings;
        this.aeCurrentPatients = aeCurrentPatients;
        this.opCurrentPatients = opCurrentPatients;
        this.drSearchCriterias = drSearchCriterias;
        this.stRepackingGroups = stRepackingGroups;
        this.prEpisodeOfCaresForResolveFacilityId = prEpisodeOfCaresForResolveFacilityId;
        this.oaAppts = oaAppts;
        this.amMedicalTeams = amMedicalTeams;
        this.rsStaffTrainings = rsStaffTrainings;
        this.opVisitTypes = opVisitTypes;
        this.qaQindFacilityClinds = qaQindFacilityClinds;
        this.aePatRelatedContactses = aePatRelatedContactses;
        this.oaBlockAppts = oaBlockAppts;
        this.prEpisodeOfCaresForErrorFacilityId = prEpisodeOfCaresForErrorFacilityId;
    }

    public String getFacilityId()
    {
        return facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    public SmFacilityLevel getSmFacilityLevel()
    {
        return smFacilityLevel;
    }

    public void setSmFacilityLevel(SmFacilityLevel smFacilityLevel)
    {
        this.smFacilityLevel = smFacilityLevel;
    }

    public SmSiteParam getSmSiteParam()
    {
        return smSiteParam;
    }

    public void setSmSiteParam(SmSiteParam smSiteParam)
    {
        this.smSiteParam = smSiteParam;
    }

    public String getFacilityName()
    {
        return facilityName;
    }

    public void setFacilityName(String facilityName)
    {
        this.facilityName = facilityName;
    }

    public String getAddrLine1()
    {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1)
    {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2()
    {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2)
    {
        this.addrLine2 = addrLine2;
    }

    public String getAddrLine3()
    {
        return addrLine3;
    }

    public void setAddrLine3(String addrLine3)
    {
        this.addrLine3 = addrLine3;
    }

    public String getAddrLine4()
    {
        return addrLine4;
    }

    public void setAddrLine4(String addrLine4)
    {
        this.addrLine4 = addrLine4;
    }

    public String getAddrPostalCode()
    {
        return addrPostalCode;
    }

    public void setAddrPostalCode(String addrPostalCode)
    {
        this.addrPostalCode = addrPostalCode;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getTelNo1()
    {
        return telNo1;
    }

    public void setTelNo1(String telNo1)
    {
        this.telNo1 = telNo1;
    }

    public String getTelNo2()
    {
        return telNo2;
    }

    public void setTelNo2(String telNo2)
    {
        this.telNo2 = telNo2;
    }

    public String getTelNo3()
    {
        return telNo3;
    }

    public void setTelNo3(String telNo3)
    {
        this.telNo3 = telNo3;
    }

    public String getTelNo4()
    {
        return telNo4;
    }

    public void setTelNo4(String telNo4)
    {
        this.telNo4 = telNo4;
    }

    public String getFaxNo()
    {
        return faxNo;
    }

    public void setFaxNo(String faxNo)
    {
        this.faxNo = faxNo;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    public String getWebsiteId()
    {
        return websiteId;
    }

    public void setWebsiteId(String websiteId)
    {
        this.websiteId = websiteId;
    }

    public String getHeadOfFacilityName()
    {
        return headOfFacilityName;
    }

    public void setHeadOfFacilityName(String headOfFacilityName)
    {
        this.headOfFacilityName = headOfFacilityName;
    }

    public String getHeadOfFacilityJobTitle()
    {
        return headOfFacilityJobTitle;
    }

    public void setHeadOfFacilityJobTitle(String headOfFacilityJobTitle)
    {
        this.headOfFacilityJobTitle = headOfFacilityJobTitle;
    }

    public String getLicenseNo()
    {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo)
    {
        this.licenseNo = licenseNo;
    }

    public String getFacilityType()
    {
        return facilityType;
    }

    public void setFacilityType(String facilityType)
    {
        this.facilityType = facilityType;
    }

    public String getMasterFacilityId()
    {
        return masterFacilityId;
    }

    public void setMasterFacilityId(String masterFacilityId)
    {
        this.masterFacilityId = masterFacilityId;
    }

    public String getHcareSettingTypeCode()
    {
        return hcareSettingTypeCode;
    }

    public void setHcareSettingTypeCode(String hcareSettingTypeCode)
    {
        this.hcareSettingTypeCode = hcareSettingTypeCode;
    }

    public String getFacilityClass()
    {
        return facilityClass;
    }

    public void setFacilityClass(String facilityClass)
    {
        this.facilityClass = facilityClass;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public String getAppServerIp()
    {
        return appServerIp;
    }

    public void setAppServerIp(String appServerIp)
    {
        this.appServerIp = appServerIp;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getWsByIpName()
    {
        return wsByIpName;
    }

    public void setWsByIpName(String wsByIpName)
    {
        this.wsByIpName = wsByIpName;
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

    public String getFaxInterfaceYn()
    {
        return faxInterfaceYn;
    }

    public void setFaxInterfaceYn(String faxInterfaceYn)
    {
        this.faxInterfaceYn = faxInterfaceYn;
    }

    public String getMailInterfaceYn()
    {
        return mailInterfaceYn;
    }

    public void setMailInterfaceYn(String mailInterfaceYn)
    {
        this.mailInterfaceYn = mailInterfaceYn;
    }

    public String getResAreaCode()
    {
        return resAreaCode;
    }

    public void setResAreaCode(String resAreaCode)
    {
        this.resAreaCode = resAreaCode;
    }

    public String getResTownCode()
    {
        return resTownCode;
    }

    public void setResTownCode(String resTownCode)
    {
        this.resTownCode = resTownCode;
    }

    public String getRegionCode()
    {
        return regionCode;
    }

    public void setRegionCode(String regionCode)
    {
        this.regionCode = regionCode;
    }

    public String getFacilityLogo()
    {
        return facilityLogo;
    }

    public void setFacilityLogo(String facilityLogo)
    {
        this.facilityLogo = facilityLogo;
    }

    public String getDisplaySiteNameYn()
    {
        return displaySiteNameYn;
    }

    public void setDisplaySiteNameYn(String displaySiteNameYn)
    {
        this.displaySiteNameYn = displaySiteNameYn;
    }

    public Set getSmReportForFcies()
    {
        return smReportForFcies;
    }

    public void setSmReportForFcies(Set smReportForFcies)
    {
        this.smReportForFcies = smReportForFcies;
    }

    public Set getPrAllergiesForOnsetFacilityId()
    {
        return prAllergiesForOnsetFacilityId;
    }

    public void setPrAllergiesForOnsetFacilityId(Set prAllergiesForOnsetFacilityId)
    {
        this.prAllergiesForOnsetFacilityId = prAllergiesForOnsetFacilityId;
    }

    public Set getCaPractByLocns()
    {
        return caPractByLocns;
    }

    public void setCaPractByLocns(Set caPractByLocns)
    {
        this.caPractByLocns = caPractByLocns;
    }

    public Set getIpMlyMedSerGrpBkgStats()
    {
        return ipMlyMedSerGrpBkgStats;
    }

    public void setIpMlyMedSerGrpBkgStats(Set ipMlyMedSerGrpBkgStats)
    {
        this.ipMlyMedSerGrpBkgStats = ipMlyMedSerGrpBkgStats;
    }

    public Set getRsShiftPatterns()
    {
        return rsShiftPatterns;
    }

    public void setRsShiftPatterns(Set rsShiftPatterns)
    {
        this.rsShiftPatterns = rsShiftPatterns;
    }

    public Set getPhDispLocns()
    {
        return phDispLocns;
    }

    public void setPhDispLocns(Set phDispLocns)
    {
        this.phDispLocns = phDispLocns;
    }

    public Set getPrEpisodeOfCaresForOpenFacilityId()
    {
        return prEpisodeOfCaresForOpenFacilityId;
    }

    public void setPrEpisodeOfCaresForOpenFacilityId(Set prEpisodeOfCaresForOpenFacilityId)
    {
        this.prEpisodeOfCaresForOpenFacilityId = prEpisodeOfCaresForOpenFacilityId;
    }

    public Set getOaClinicSchedules()
    {
        return oaClinicSchedules;
    }

    public void setOaClinicSchedules(Set oaClinicSchedules)
    {
        this.oaClinicSchedules = oaClinicSchedules;
    }

    public Set getOpQueueNumForLocns()
    {
        return opQueueNumForLocns;
    }

    public void setOpQueueNumForLocns(Set opQueueNumForLocns)
    {
        this.opQueueNumForLocns = opQueueNumForLocns;
    }

    public Set getDrDupGroupDtlses()
    {
        return drDupGroupDtlses;
    }

    public void setDrDupGroupDtlses(Set drDupGroupDtlses)
    {
        this.drDupGroupDtlses = drDupGroupDtlses;
    }

    public Set getIpNursingUnitBeds()
    {
        return ipNursingUnitBeds;
    }

    public void setIpNursingUnitBeds(Set ipNursingUnitBeds)
    {
        this.ipNursingUnitBeds = ipNursingUnitBeds;
    }

    public Set getRsStaffLicensures()
    {
        return rsStaffLicensures;
    }

    public void setRsStaffLicensures(Set rsStaffLicensures)
    {
        this.rsStaffLicensures = rsStaffLicensures;
    }

    public Set getStFacilityParams()
    {
        return stFacilityParams;
    }

    public void setStFacilityParams(Set stFacilityParams)
    {
        this.stFacilityParams = stFacilityParams;
    }

    public Set getIpNursingUnitForPracts()
    {
        return ipNursingUnitForPracts;
    }

    public void setIpNursingUnitForPracts(Set ipNursingUnitForPracts)
    {
        this.ipNursingUnitForPracts = ipNursingUnitForPracts;
    }

    public Set getSmGrpMasterCodesForMasterFacilityId()
    {
        return smGrpMasterCodesForMasterFacilityId;
    }

    public void setSmGrpMasterCodesForMasterFacilityId(Set smGrpMasterCodesForMasterFacilityId)
    {
        this.smGrpMasterCodesForMasterFacilityId = smGrpMasterCodesForMasterFacilityId;
    }

    public Set getOaRosterForPracts()
    {
        return oaRosterForPracts;
    }

    public void setOaRosterForPracts(Set oaRosterForPracts)
    {
        this.oaRosterForPracts = oaRosterForPracts;
    }

    public Set getAePractForTmtAreas()
    {
        return aePractForTmtAreas;
    }

    public void setAePractForTmtAreas(Set aePractForTmtAreas)
    {
        this.aePractForTmtAreas = aePractForTmtAreas;
    }

    public Set getIpDlyMedSerGrpBkgStats()
    {
        return ipDlyMedSerGrpBkgStats;
    }

    public void setIpDlyMedSerGrpBkgStats(Set ipDlyMedSerGrpBkgStats)
    {
        this.ipDlyMedSerGrpBkgStats = ipDlyMedSerGrpBkgStats;
    }

    public Set getIpNursingUnitRooms()
    {
        return ipNursingUnitRooms;
    }

    public void setIpNursingUnitRooms(Set ipNursingUnitRooms)
    {
        this.ipNursingUnitRooms = ipNursingUnitRooms;
    }

    public Set getMrDiagGroups()
    {
        return mrDiagGroups;
    }

    public void setMrDiagGroups(Set mrDiagGroups)
    {
        this.mrDiagGroups = mrDiagGroups;
    }

    public Set getSmApplUsers()
    {
        return smApplUsers;
    }

    public void setSmApplUsers(Set smApplUsers)
    {
        this.smApplUsers = smApplUsers;
    }

    public Set getPrReferralRegistersForFromFacilityId()
    {
        return prReferralRegistersForFromFacilityId;
    }

    public void setPrReferralRegistersForFromFacilityId(Set prReferralRegistersForFromFacilityId)
    {
        this.prReferralRegistersForFromFacilityId = prReferralRegistersForFromFacilityId;
    }

    public Set getPrProblemsForCloseFacilityId()
    {
        return prProblemsForCloseFacilityId;
    }

    public void setPrProblemsForCloseFacilityId(Set prProblemsForCloseFacilityId)
    {
        this.prProblemsForCloseFacilityId = prProblemsForCloseFacilityId;
    }

    public Set getAmFacilityServices()
    {
        return amFacilityServices;
    }

    public void setAmFacilityServices(Set amFacilityServices)
    {
        this.amFacilityServices = amFacilityServices;
    }

    public Set getMrRequestors()
    {
        return mrRequestors;
    }

    public void setMrRequestors(Set mrRequestors)
    {
        this.mrRequestors = mrRequestors;
    }

    public Set getAmOperStns()
    {
        return amOperStns;
    }

    public void setAmOperStns(Set amOperStns)
    {
        this.amOperStns = amOperStns;
    }

    public Set getDrMergedPatientDtlses()
    {
        return drMergedPatientDtlses;
    }

    public void setDrMergedPatientDtlses(Set drMergedPatientDtlses)
    {
        this.drMergedPatientDtlses = drMergedPatientDtlses;
    }

    public Set getOpEpisodeForServices()
    {
        return opEpisodeForServices;
    }

    public void setOpEpisodeForServices(Set opEpisodeForServices)
    {
        this.opEpisodeForServices = opEpisodeForServices;
    }

    public Set getFmCurrLocnsForCurrFacilityId()
    {
        return fmCurrLocnsForCurrFacilityId;
    }

    public void setFmCurrLocnsForCurrFacilityId(Set fmCurrLocnsForCurrFacilityId)
    {
        this.fmCurrLocnsForCurrFacilityId = fmCurrLocnsForCurrFacilityId;
    }

    public Set getMpParamForFacilities()
    {
        return mpParamForFacilities;
    }

    public void setMpParamForFacilities(Set mpParamForFacilities)
    {
        this.mpParamForFacilities = mpParamForFacilities;
    }

    public Set getPrEncounters()
    {
        return prEncounters;
    }

    public void setPrEncounters(Set prEncounters)
    {
        this.prEncounters = prEncounters;
    }

    public Set getFmMovementLogsForFacilityId()
    {
        return fmMovementLogsForFacilityId;
    }

    public void setFmMovementLogsForFacilityId(Set fmMovementLogsForFacilityId)
    {
        this.fmMovementLogsForFacilityId = fmMovementLogsForFacilityId;
    }

    public Set getSmAccEntityParamFacls()
    {
        return smAccEntityParamFacls;
    }

    public void setSmAccEntityParamFacls(Set smAccEntityParamFacls)
    {
        this.smAccEntityParamFacls = smAccEntityParamFacls;
    }

    public Set getMrMdsForTermSets()
    {
        return mrMdsForTermSets;
    }

    public void setMrMdsForTermSets(Set mrMdsForTermSets)
    {
        this.mrMdsForTermSets = mrMdsForTermSets;
    }

    public Set getOaApptStatses()
    {
        return oaApptStatses;
    }

    public void setOaApptStatses(Set oaApptStatses)
    {
        this.oaApptStatses = oaApptStatses;
    }

    public Set getAeTmtAreaForClinics()
    {
        return aeTmtAreaForClinics;
    }

    public void setAeTmtAreaForClinics(Set aeTmtAreaForClinics)
    {
        this.aeTmtAreaForClinics = aeTmtAreaForClinics;
    }

    public Set getSmGrpMasterCodesForFacilityId()
    {
        return smGrpMasterCodesForFacilityId;
    }

    public void setSmGrpMasterCodesForFacilityId(Set smGrpMasterCodesForFacilityId)
    {
        this.smGrpMasterCodesForFacilityId = smGrpMasterCodesForFacilityId;
    }

    public Set getFmIpPullingLists()
    {
        return fmIpPullingLists;
    }

    public void setFmIpPullingLists(Set fmIpPullingLists)
    {
        this.fmIpPullingLists = fmIpPullingLists;
    }

    public Set getFmTransitFilesForDestFacilityId()
    {
        return fmTransitFilesForDestFacilityId;
    }

    public void setFmTransitFilesForDestFacilityId(Set fmTransitFilesForDestFacilityId)
    {
        this.fmTransitFilesForDestFacilityId = fmTransitFilesForDestFacilityId;
    }

    public Set getOrOrderSetByIndexes()
    {
        return orOrderSetByIndexes;
    }

    public void setOrOrderSetByIndexes(Set orOrderSetByIndexes)
    {
        this.orOrderSetByIndexes = orOrderSetByIndexes;
    }

    public Set getCpPatCarePlans()
    {
        return cpPatCarePlans;
    }

    public void setCpPatCarePlans(Set cpPatCarePlans)
    {
        this.cpPatCarePlans = cpPatCarePlans;
    }

    public Set getSsPhyInvParams()
    {
        return ssPhyInvParams;
    }

    public void setSsPhyInvParams(Set ssPhyInvParams)
    {
        this.ssPhyInvParams = ssPhyInvParams;
    }

    public Set getOpClinics()
    {
        return opClinics;
    }

    public void setOpClinics(Set opClinics)
    {
        this.opClinics = opClinics;
    }

    public Set getRsWorkplaces()
    {
        return rsWorkplaces;
    }

    public void setRsWorkplaces(Set rsWorkplaces)
    {
        this.rsWorkplaces = rsWorkplaces;
    }

    public Set getPrPorterageDetailses()
    {
        return prPorterageDetailses;
    }

    public void setPrPorterageDetailses(Set prPorterageDetailses)
    {
        this.prPorterageDetailses = prPorterageDetailses;
    }

    public Set getPrAllergiesForCloseFacilityId()
    {
        return prAllergiesForCloseFacilityId;
    }

    public void setPrAllergiesForCloseFacilityId(Set prAllergiesForCloseFacilityId)
    {
        this.prAllergiesForCloseFacilityId = prAllergiesForCloseFacilityId;
    }

    public Set getOpPatientTrackingLocns()
    {
        return opPatientTrackingLocns;
    }

    public void setOpPatientTrackingLocns(Set opPatientTrackingLocns)
    {
        this.opPatientTrackingLocns = opPatientTrackingLocns;
    }

    public Set getIpAdtTrns()
    {
        return ipAdtTrns;
    }

    public void setIpAdtTrns(Set ipAdtTrns)
    {
        this.ipAdtTrns = ipAdtTrns;
    }

    public Set getOpOnlineReports()
    {
        return opOnlineReports;
    }

    public void setOpOnlineReports(Set opOnlineReports)
    {
        this.opOnlineReports = opOnlineReports;
    }

    public Set getXhApplForFacilities()
    {
        return xhApplForFacilities;
    }

    public void setXhApplForFacilities(Set xhApplForFacilities)
    {
        this.xhApplForFacilities = xhApplForFacilities;
    }

    public Set getAmOtherStaffs()
    {
        return amOtherStaffs;
    }

    public void setAmOtherStaffs(Set amOtherStaffs)
    {
        this.amOtherStaffs = amOtherStaffs;
    }

    public Set getPhPatientVaccProfiles()
    {
        return phPatientVaccProfiles;
    }

    public void setPhPatientVaccProfiles(Set phPatientVaccProfiles)
    {
        this.phPatientVaccProfiles = phPatientVaccProfiles;
    }

    public Set getFmReqHdrs()
    {
        return fmReqHdrs;
    }

    public void setFmReqHdrs(Set fmReqHdrs)
    {
        this.fmReqHdrs = fmReqHdrs;
    }

    public Set getOaUserClinicRightses()
    {
        return oaUserClinicRightses;
    }

    public void setOaUserClinicRightses(Set oaUserClinicRightses)
    {
        this.oaUserClinicRightses = oaUserClinicRightses;
    }

    public Set getPrPatientValuableses()
    {
        return prPatientValuableses;
    }

    public void setPrPatientValuableses(Set prPatientValuableses)
    {
        this.prPatientValuableses = prPatientValuableses;
    }

    public Set getPhOrderRoutingDtlsForPerformingFacilityId()
    {
        return phOrderRoutingDtlsForPerformingFacilityId;
    }

    public void setPhOrderRoutingDtlsForPerformingFacilityId(Set phOrderRoutingDtlsForPerformingFacilityId)
    {
        this.phOrderRoutingDtlsForPerformingFacilityId = phOrderRoutingDtlsForPerformingFacilityId;
    }

    public Set getStTrnDocTypes()
    {
        return stTrnDocTypes;
    }

    public void setStTrnDocTypes(Set stTrnDocTypes)
    {
        this.stTrnDocTypes = stTrnDocTypes;
    }

    public Set getIpNursingUnits()
    {
        return ipNursingUnits;
    }

    public void setIpNursingUnits(Set ipNursingUnits)
    {
        this.ipNursingUnits = ipNursingUnits;
    }

    public Set getMrUserAccessRightses()
    {
        return mrUserAccessRightses;
    }

    public void setMrUserAccessRightses(Set mrUserAccessRightses)
    {
        this.mrUserAccessRightses = mrUserAccessRightses;
    }

    public Set getPhWsForTokenSerieses()
    {
        return phWsForTokenSerieses;
    }

    public void setPhWsForTokenSerieses(Set phWsForTokenSerieses)
    {
        this.phWsForTokenSerieses = phWsForTokenSerieses;
    }

    public Set getPhOrderRoutingDtlsForOrderingFacilityId()
    {
        return phOrderRoutingDtlsForOrderingFacilityId;
    }

    public void setPhOrderRoutingDtlsForOrderingFacilityId(Set phOrderRoutingDtlsForOrderingFacilityId)
    {
        this.phOrderRoutingDtlsForOrderingFacilityId = phOrderRoutingDtlsForOrderingFacilityId;
    }

    public Set getOrOrderTypeRoutings()
    {
        return orOrderTypeRoutings;
    }

    public void setOrOrderTypeRoutings(Set orOrderTypeRoutings)
    {
        this.orOrderTypeRoutings = orOrderTypeRoutings;
    }

    public Set getAmRefIdNumForFcies()
    {
        return amRefIdNumForFcies;
    }

    public void setAmRefIdNumForFcies(Set amRefIdNumForFcies)
    {
        this.amRefIdNumForFcies = amRefIdNumForFcies;
    }

    public Set getAmOtherStaffForFacilities()
    {
        return amOtherStaffForFacilities;
    }

    public void setAmOtherStaffForFacilities(Set amOtherStaffForFacilities)
    {
        this.amOtherStaffForFacilities = amOtherStaffForFacilities;
    }

    public Set getOaClinicBreaks()
    {
        return oaClinicBreaks;
    }

    public void setOaClinicBreaks(Set oaClinicBreaks)
    {
        this.oaClinicBreaks = oaClinicBreaks;
    }

    public Set getOpPractForClinics()
    {
        return opPractForClinics;
    }

    public void setOpPractForClinics(Set opPractForClinics)
    {
        this.opPractForClinics = opPractForClinics;
    }

    public Set getOpPatientQueueSumms()
    {
        return opPatientQueueSumms;
    }

    public void setOpPatientQueueSumms(Set opPatientQueueSumms)
    {
        this.opPatientQueueSumms = opPatientQueueSumms;
    }

    public Set getOrOrderFacilityCrossRefsForOrderingFacilityId()
    {
        return orOrderFacilityCrossRefsForOrderingFacilityId;
    }

    public void setOrOrderFacilityCrossRefsForOrderingFacilityId(Set orOrderFacilityCrossRefsForOrderingFacilityId)
    {
        this.orOrderFacilityCrossRefsForOrderingFacilityId = orOrderFacilityCrossRefsForOrderingFacilityId;
    }

    public Set getMrTermSetForFacilities()
    {
        return mrTermSetForFacilities;
    }

    public void setMrTermSetForFacilities(Set mrTermSetForFacilities)
    {
        this.mrTermSetForFacilities = mrTermSetForFacilities;
    }

    public Set getOpVisitTypeForClinics()
    {
        return opVisitTypeForClinics;
    }

    public void setOpVisitTypeForClinics(Set opVisitTypeForClinics)
    {
        this.opVisitTypeForClinics = opVisitTypeForClinics;
    }

    public Set getAmFacilitySubsrvcs()
    {
        return amFacilitySubsrvcs;
    }

    public void setAmFacilitySubsrvcs(Set amFacilitySubsrvcs)
    {
        this.amFacilitySubsrvcs = amFacilitySubsrvcs;
    }

    public Set getPhOrderRoutingsForOrderingFacilityId()
    {
        return phOrderRoutingsForOrderingFacilityId;
    }

    public void setPhOrderRoutingsForOrderingFacilityId(Set phOrderRoutingsForOrderingFacilityId)
    {
        this.phOrderRoutingsForOrderingFacilityId = phOrderRoutingsForOrderingFacilityId;
    }

    public Set getAeOnlineReports()
    {
        return aeOnlineReports;
    }

    public void setAeOnlineReports(Set aeOnlineReports)
    {
        this.aeOnlineReports = aeOnlineReports;
    }

    public Set getCaEncntrDiscrMsrs()
    {
        return caEncntrDiscrMsrs;
    }

    public void setCaEncntrDiscrMsrs(Set caEncntrDiscrMsrs)
    {
        this.caEncntrDiscrMsrs = caEncntrDiscrMsrs;
    }

    public Set getIpDlyAgeGrpBkgStats()
    {
        return ipDlyAgeGrpBkgStats;
    }

    public void setIpDlyAgeGrpBkgStats(Set ipDlyAgeGrpBkgStats)
    {
        this.ipDlyAgeGrpBkgStats = ipDlyAgeGrpBkgStats;
    }

    public Set getFmDeficiencyHdrs()
    {
        return fmDeficiencyHdrs;
    }

    public void setFmDeficiencyHdrs(Set fmDeficiencyHdrs)
    {
        this.fmDeficiencyHdrs = fmDeficiencyHdrs;
    }

    public Set getAmDeptForFacilityRooms()
    {
        return amDeptForFacilityRooms;
    }

    public void setAmDeptForFacilityRooms(Set amDeptForFacilityRooms)
    {
        this.amDeptForFacilityRooms = amDeptForFacilityRooms;
    }

    public Set getOrOrderFacilityCrossRefsForPerformingFacilityId()
    {
        return orOrderFacilityCrossRefsForPerformingFacilityId;
    }

    public void setOrOrderFacilityCrossRefsForPerformingFacilityId(Set orOrderFacilityCrossRefsForPerformingFacilityId)
    {
        this.orOrderFacilityCrossRefsForPerformingFacilityId = orOrderFacilityCrossRefsForPerformingFacilityId;
    }

    public Set getFmReqDtlsForReqToFacilityId()
    {
        return fmReqDtlsForReqToFacilityId;
    }

    public void setFmReqDtlsForReqToFacilityId(Set fmReqDtlsForReqToFacilityId)
    {
        this.fmReqDtlsForReqToFacilityId = fmReqDtlsForReqToFacilityId;
    }

    public Set getOrPerformingDeptlocs()
    {
        return orPerformingDeptlocs;
    }

    public void setOrPerformingDeptlocs(Set orPerformingDeptlocs)
    {
        this.orPerformingDeptlocs = orPerformingDeptlocs;
    }

    public Set getOaHolidaies()
    {
        return oaHolidaies;
    }

    public void setOaHolidaies(Set oaHolidaies)
    {
        this.oaHolidaies = oaHolidaies;
    }

    public Set getOaTransRecords()
    {
        return oaTransRecords;
    }

    public void setOaTransRecords(Set oaTransRecords)
    {
        this.oaTransRecords = oaTransRecords;
    }

    public Set getFmMovementLogsForSrcFacilityId()
    {
        return fmMovementLogsForSrcFacilityId;
    }

    public void setFmMovementLogsForSrcFacilityId(Set fmMovementLogsForSrcFacilityId)
    {
        this.fmMovementLogsForSrcFacilityId = fmMovementLogsForSrcFacilityId;
    }

    public Set getRsStaffExperiences()
    {
        return rsStaffExperiences;
    }

    public void setRsStaffExperiences(Set rsStaffExperiences)
    {
        this.rsStaffExperiences = rsStaffExperiences;
    }

    public Set getAePatMovementLogs()
    {
        return aePatMovementLogs;
    }

    public void setAePatMovementLogs(Set aePatMovementLogs)
    {
        this.aePatMovementLogs = aePatMovementLogs;
    }

    public Set getPrEncounterProcedures()
    {
        return prEncounterProcedures;
    }

    public void setPrEncounterProcedures(Set prEncounterProcedures)
    {
        this.prEncounterProcedures = prEncounterProcedures;
    }

    public Set getSsFacilityParams()
    {
        return ssFacilityParams;
    }

    public void setSsFacilityParams(Set ssFacilityParams)
    {
        this.ssFacilityParams = ssFacilityParams;
    }

    public Set getOaClinicScheduleBreaks()
    {
        return oaClinicScheduleBreaks;
    }

    public void setOaClinicScheduleBreaks(Set oaClinicScheduleBreaks)
    {
        this.oaClinicScheduleBreaks = oaClinicScheduleBreaks;
    }

    public Set getCaEncntrPractRelns()
    {
        return caEncntrPractRelns;
    }

    public void setCaEncntrPractRelns(Set caEncntrPractRelns)
    {
        this.caEncntrPractRelns = caEncntrPractRelns;
    }

    public Set getAmBldngs()
    {
        return amBldngs;
    }

    public void setAmBldngs(Set amBldngs)
    {
        this.amBldngs = amBldngs;
    }

    public Set getOaApptSrlNos()
    {
        return oaApptSrlNos;
    }

    public void setOaApptSrlNos(Set oaApptSrlNos)
    {
        this.oaApptSrlNos = oaApptSrlNos;
    }

    public Set getSsServiceLocations()
    {
        return ssServiceLocations;
    }

    public void setSsServiceLocations(Set ssServiceLocations)
    {
        this.ssServiceLocations = ssServiceLocations;
    }

    public Set getOpPatientQueues()
    {
        return opPatientQueues;
    }

    public void setOpPatientQueues(Set opPatientQueues)
    {
        this.opPatientQueues = opPatientQueues;
    }

    public Set getPrEncounterPracts()
    {
        return prEncounterPracts;
    }

    public void setPrEncounterPracts(Set prEncounterPracts)
    {
        this.prEncounterPracts = prEncounterPracts;
    }

    public Set getPhFacilityParams()
    {
        return phFacilityParams;
    }

    public void setPhFacilityParams(Set phFacilityParams)
    {
        this.phFacilityParams = phFacilityParams;
    }

    public Set getFmParameters()
    {
        return fmParameters;
    }

    public void setFmParameters(Set fmParameters)
    {
        this.fmParameters = fmParameters;
    }

    public Set getPhTokenSerieses()
    {
        return phTokenSerieses;
    }

    public void setPhTokenSerieses(Set phTokenSerieses)
    {
        this.phTokenSerieses = phTokenSerieses;
    }

    public Set getAmPractSpecialitieses()
    {
        return amPractSpecialitieses;
    }

    public void setAmPractSpecialitieses(Set amPractSpecialitieses)
    {
        this.amPractSpecialitieses = amPractSpecialitieses;
    }

    public Set getAmBldngFloors()
    {
        return amBldngFloors;
    }

    public void setAmBldngFloors(Set amBldngFloors)
    {
        this.amBldngFloors = amBldngFloors;
    }

    public Set getIpMedSerGrpNursUtTypes()
    {
        return ipMedSerGrpNursUtTypes;
    }

    public void setIpMedSerGrpNursUtTypes(Set ipMedSerGrpNursUtTypes)
    {
        this.ipMedSerGrpNursUtTypes = ipMedSerGrpNursUtTypes;
    }

    public Set getOaClinicTimeTables()
    {
        return oaClinicTimeTables;
    }

    public void setOaClinicTimeTables(Set oaClinicTimeTables)
    {
        this.oaClinicTimeTables = oaClinicTimeTables;
    }

    public Set getCpPositionForMdcps()
    {
        return cpPositionForMdcps;
    }

    public void setCpPositionForMdcps(Set cpPositionForMdcps)
    {
        this.cpPositionForMdcps = cpPositionForMdcps;
    }

    public Set getPrWaitLists()
    {
        return prWaitLists;
    }

    public void setPrWaitLists(Set prWaitLists)
    {
        this.prWaitLists = prWaitLists;
    }

    public Set getMmStores()
    {
        return mmStores;
    }

    public void setMmStores(Set mmStores)
    {
        this.mmStores = mmStores;
    }

    public Set getMpPatientsForPrefFacilityId()
    {
        return mpPatientsForPrefFacilityId;
    }

    public void setMpPatientsForPrefFacilityId(Set mpPatientsForPrefFacilityId)
    {
        this.mpPatientsForPrefFacilityId = mpPatientsForPrefFacilityId;
    }

    public Set getIpDlyNursUtBkgStats()
    {
        return ipDlyNursUtBkgStats;
    }

    public void setIpDlyNursUtBkgStats(Set ipDlyNursUtBkgStats)
    {
        this.ipDlyNursUtBkgStats = ipDlyNursUtBkgStats;
    }

    public Set getPrReferralRegistersForToFacilityId()
    {
        return prReferralRegistersForToFacilityId;
    }

    public void setPrReferralRegistersForToFacilityId(Set prReferralRegistersForToFacilityId)
    {
        this.prReferralRegistersForToFacilityId = prReferralRegistersForToFacilityId;
    }

    public Set getOpLastVisitForServices()
    {
        return opLastVisitForServices;
    }

    public void setOpLastVisitForServices(Set opLastVisitForServices)
    {
        this.opLastVisitForServices = opLastVisitForServices;
    }

    public Set getMpPatientsForRegnFacilityId()
    {
        return mpPatientsForRegnFacilityId;
    }

    public void setMpPatientsForRegnFacilityId(Set mpPatientsForRegnFacilityId)
    {
        this.mpPatientsForRegnFacilityId = mpPatientsForRegnFacilityId;
    }

    public Set getAmFacilityRooms()
    {
        return amFacilityRooms;
    }

    public void setAmFacilityRooms(Set amFacilityRooms)
    {
        this.amFacilityRooms = amFacilityRooms;
    }

    public Set getSmFacilityForResps()
    {
        return smFacilityForResps;
    }

    public void setSmFacilityForResps(Set smFacilityForResps)
    {
        this.smFacilityForResps = smFacilityForResps;
    }

    public Set getFmCurrLocnsForFacilityId()
    {
        return fmCurrLocnsForFacilityId;
    }

    public void setFmCurrLocnsForFacilityId(Set fmCurrLocnsForFacilityId)
    {
        this.fmCurrLocnsForFacilityId = fmCurrLocnsForFacilityId;
    }

    public Set getIpBedBookingSrlCtrls()
    {
        return ipBedBookingSrlCtrls;
    }

    public void setIpBedBookingSrlCtrls(Set ipBedBookingSrlCtrls)
    {
        this.ipBedBookingSrlCtrls = ipBedBookingSrlCtrls;
    }

    public Set getFmMovementLogsForDestFacilityId()
    {
        return fmMovementLogsForDestFacilityId;
    }

    public void setFmMovementLogsForDestFacilityId(Set fmMovementLogsForDestFacilityId)
    {
        this.fmMovementLogsForDestFacilityId = fmMovementLogsForDestFacilityId;
    }

    public Set getStPrepareLocations()
    {
        return stPrepareLocations;
    }

    public void setStPrepareLocations(Set stPrepareLocations)
    {
        this.stPrepareLocations = stPrepareLocations;
    }

    public Set getCaApplTaskForSplties()
    {
        return caApplTaskForSplties;
    }

    public void setCaApplTaskForSplties(Set caApplTaskForSplties)
    {
        this.caApplTaskForSplties = caApplTaskForSplties;
    }

    public Set getAmPractitioners()
    {
        return amPractitioners;
    }

    public void setAmPractitioners(Set amPractitioners)
    {
        this.amPractitioners = amPractitioners;
    }

    public Set getOpParams()
    {
        return opParams;
    }

    public void setOpParams(Set opParams)
    {
        this.opParams = opParams;
    }

    public Set getMrFileTypes()
    {
        return mrFileTypes;
    }

    public void setMrFileTypes(Set mrFileTypes)
    {
        this.mrFileTypes = mrFileTypes;
    }

    public Set getIpNursingUnitLocations()
    {
        return ipNursingUnitLocations;
    }

    public void setIpNursingUnitLocations(Set ipNursingUnitLocations)
    {
        this.ipNursingUnitLocations = ipNursingUnitLocations;
    }

    public Set getFmDeficiencyDtls()
    {
        return fmDeficiencyDtls;
    }

    public void setFmDeficiencyDtls(Set fmDeficiencyDtls)
    {
        this.fmDeficiencyDtls = fmDeficiencyDtls;
    }

    public Set getIpTransferPriorities()
    {
        return ipTransferPriorities;
    }

    public void setIpTransferPriorities(Set ipTransferPriorities)
    {
        this.ipTransferPriorities = ipTransferPriorities;
    }

    public Set getRsStaffUnavailabilityLogs()
    {
        return rsStaffUnavailabilityLogs;
    }

    public void setRsStaffUnavailabilityLogs(Set rsStaffUnavailabilityLogs)
    {
        this.rsStaffUnavailabilityLogs = rsStaffUnavailabilityLogs;
    }

    public Set getPrProblemsForOnsetFacilityId()
    {
        return prProblemsForOnsetFacilityId;
    }

    public void setPrProblemsForOnsetFacilityId(Set prProblemsForOnsetFacilityId)
    {
        this.prProblemsForOnsetFacilityId = prProblemsForOnsetFacilityId;
    }

    public Set getOaClinicScheduleValidities()
    {
        return oaClinicScheduleValidities;
    }

    public void setOaClinicScheduleValidities(Set oaClinicScheduleValidities)
    {
        this.oaClinicScheduleValidities = oaClinicScheduleValidities;
    }

    public Set getFmReqDtlsForCurrFacilityId()
    {
        return fmReqDtlsForCurrFacilityId;
    }

    public void setFmReqDtlsForCurrFacilityId(Set fmReqDtlsForCurrFacilityId)
    {
        this.fmReqDtlsForCurrFacilityId = fmReqDtlsForCurrFacilityId;
    }

    public Set getOpParamForFacilityServices()
    {
        return opParamForFacilityServices;
    }

    public void setOpParamForFacilityServices(Set opParamForFacilityServices)
    {
        this.opParamForFacilityServices = opParamForFacilityServices;
    }

    public Set getSmFacilityForUsers()
    {
        return smFacilityForUsers;
    }

    public void setSmFacilityForUsers(Set smFacilityForUsers)
    {
        this.smFacilityForUsers = smFacilityForUsers;
    }

    public Set getCaEncntrNotes()
    {
        return caEncntrNotes;
    }

    public void setCaEncntrNotes(Set caEncntrNotes)
    {
        this.caEncntrNotes = caEncntrNotes;
    }

    public Set getCaApplTaskForRespRelns()
    {
        return caApplTaskForRespRelns;
    }

    public void setCaApplTaskForRespRelns(Set caApplTaskForRespRelns)
    {
        this.caApplTaskForRespRelns = caApplTaskForRespRelns;
    }

    public Set getFmUserAccessRightses()
    {
        return fmUserAccessRightses;
    }

    public void setFmUserAccessRightses(Set fmUserAccessRightses)
    {
        this.fmUserAccessRightses = fmUserAccessRightses;
    }

    public Set getAePatEmergencyDetails()
    {
        return aePatEmergencyDetails;
    }

    public void setAePatEmergencyDetails(Set aePatEmergencyDetails)
    {
        this.aePatEmergencyDetails = aePatEmergencyDetails;
    }

    public Set getAmPractForFacilities()
    {
        return amPractForFacilities;
    }

    public void setAmPractForFacilities(Set amPractForFacilities)
    {
        this.amPractForFacilities = amPractForFacilities;
    }

    public Set getCaNoteTypeForSplties()
    {
        return caNoteTypeForSplties;
    }

    public void setCaNoteTypeForSplties(Set caNoteTypeForSplties)
    {
        this.caNoteTypeForSplties = caNoteTypeForSplties;
    }

    public Set getAmFacilityDepts()
    {
        return amFacilityDepts;
    }

    public void setAmFacilityDepts(Set amFacilityDepts)
    {
        this.amFacilityDepts = amFacilityDepts;
    }

    public Set getIpBookLimitByNursUts()
    {
        return ipBookLimitByNursUts;
    }

    public void setIpBookLimitByNursUts(Set ipBookLimitByNursUts)
    {
        this.ipBookLimitByNursUts = ipBookLimitByNursUts;
    }

    public Set getFmPullingLists()
    {
        return fmPullingLists;
    }

    public void setFmPullingLists(Set fmPullingLists)
    {
        this.fmPullingLists = fmPullingLists;
    }

    public Set getAmRestrnForOperStns()
    {
        return amRestrnForOperStns;
    }

    public void setAmRestrnForOperStns(Set amRestrnForOperStns)
    {
        this.amRestrnForOperStns = amRestrnForOperStns;
    }

    public Set getOaApptDelTrs()
    {
        return oaApptDelTrs;
    }

    public void setOaApptDelTrs(Set oaApptDelTrs)
    {
        this.oaApptDelTrs = oaApptDelTrs;
    }

    public Set getSmModulesFacilities()
    {
        return smModulesFacilities;
    }

    public void setSmModulesFacilities(Set smModulesFacilities)
    {
        this.smModulesFacilities = smModulesFacilities;
    }

    public Set getPhOrderRoutingsForPerformingFacilityId()
    {
        return phOrderRoutingsForPerformingFacilityId;
    }

    public void setPhOrderRoutingsForPerformingFacilityId(Set phOrderRoutingsForPerformingFacilityId)
    {
        this.phOrderRoutingsForPerformingFacilityId = phOrderRoutingsForPerformingFacilityId;
    }

    public Set getFmTransitFilesForSrcFacilityId()
    {
        return fmTransitFilesForSrcFacilityId;
    }

    public void setFmTransitFilesForSrcFacilityId(Set fmTransitFilesForSrcFacilityId)
    {
        this.fmTransitFilesForSrcFacilityId = fmTransitFilesForSrcFacilityId;
    }

    public Set getIpBookLimitByAgeGrps()
    {
        return ipBookLimitByAgeGrps;
    }

    public void setIpBookLimitByAgeGrps(Set ipBookLimitByAgeGrps)
    {
        this.ipBookLimitByAgeGrps = ipBookLimitByAgeGrps;
    }

    public Set getPrEncIdNumForFcies()
    {
        return prEncIdNumForFcies;
    }

    public void setPrEncIdNumForFcies(Set prEncIdNumForFcies)
    {
        this.prEncIdNumForFcies = prEncIdNumForFcies;
    }

    public Set getPhDispRightses()
    {
        return phDispRightses;
    }

    public void setPhDispRightses(Set phDispRightses)
    {
        this.phDispRightses = phDispRightses;
    }

    public Set getIpBedBookings()
    {
        return ipBedBookings;
    }

    public void setIpBedBookings(Set ipBedBookings)
    {
        this.ipBedBookings = ipBedBookings;
    }

    public Set getMrSections()
    {
        return mrSections;
    }

    public void setMrSections(Set mrSections)
    {
        this.mrSections = mrSections;
    }

    public Set getCaNoteTypeByServs()
    {
        return caNoteTypeByServs;
    }

    public void setCaNoteTypeByServs(Set caNoteTypeByServs)
    {
        this.caNoteTypeByServs = caNoteTypeByServs;
    }

    public Set getFmStorageLocns()
    {
        return fmStorageLocns;
    }

    public void setFmStorageLocns(Set fmStorageLocns)
    {
        this.fmStorageLocns = fmStorageLocns;
    }

    public Set getIpBookingLists()
    {
        return ipBookingLists;
    }

    public void setIpBookingLists(Set ipBookingLists)
    {
        this.ipBookingLists = ipBookingLists;
    }

    public Set getMrPatFileIndexes()
    {
        return mrPatFileIndexes;
    }

    public void setMrPatFileIndexes(Set mrPatFileIndexes)
    {
        this.mrPatFileIndexes = mrPatFileIndexes;
    }

    public Set getIpMedicalServiceGroups()
    {
        return ipMedicalServiceGroups;
    }

    public void setIpMedicalServiceGroups(Set ipMedicalServiceGroups)
    {
        this.ipMedicalServiceGroups = ipMedicalServiceGroups;
    }

    public Set getSmPrintRoutings()
    {
        return smPrintRoutings;
    }

    public void setSmPrintRoutings(Set smPrintRoutings)
    {
        this.smPrintRoutings = smPrintRoutings;
    }

    public Set getAeCurrentPatients()
    {
        return aeCurrentPatients;
    }

    public void setAeCurrentPatients(Set aeCurrentPatients)
    {
        this.aeCurrentPatients = aeCurrentPatients;
    }

    public Set getOpCurrentPatients()
    {
        return opCurrentPatients;
    }

    public void setOpCurrentPatients(Set opCurrentPatients)
    {
        this.opCurrentPatients = opCurrentPatients;
    }

    public Set getDrSearchCriterias()
    {
        return drSearchCriterias;
    }

    public void setDrSearchCriterias(Set drSearchCriterias)
    {
        this.drSearchCriterias = drSearchCriterias;
    }

    public Set getStRepackingGroups()
    {
        return stRepackingGroups;
    }

    public void setStRepackingGroups(Set stRepackingGroups)
    {
        this.stRepackingGroups = stRepackingGroups;
    }

    public Set getPrEpisodeOfCaresForResolveFacilityId()
    {
        return prEpisodeOfCaresForResolveFacilityId;
    }

    public void setPrEpisodeOfCaresForResolveFacilityId(Set prEpisodeOfCaresForResolveFacilityId)
    {
        this.prEpisodeOfCaresForResolveFacilityId = prEpisodeOfCaresForResolveFacilityId;
    }

    public Set getOaAppts()
    {
        return oaAppts;
    }

    public void setOaAppts(Set oaAppts)
    {
        this.oaAppts = oaAppts;
    }

    public Set getAmMedicalTeams()
    {
        return amMedicalTeams;
    }

    public void setAmMedicalTeams(Set amMedicalTeams)
    {
        this.amMedicalTeams = amMedicalTeams;
    }

    public Set getRsStaffTrainings()
    {
        return rsStaffTrainings;
    }

    public void setRsStaffTrainings(Set rsStaffTrainings)
    {
        this.rsStaffTrainings = rsStaffTrainings;
    }

    public Set getOpVisitTypes()
    {
        return opVisitTypes;
    }

    public void setOpVisitTypes(Set opVisitTypes)
    {
        this.opVisitTypes = opVisitTypes;
    }

    public Set getQaQindFacilityClinds()
    {
        return qaQindFacilityClinds;
    }

    public void setQaQindFacilityClinds(Set qaQindFacilityClinds)
    {
        this.qaQindFacilityClinds = qaQindFacilityClinds;
    }

    public Set getAePatRelatedContactses()
    {
        return aePatRelatedContactses;
    }

    public void setAePatRelatedContactses(Set aePatRelatedContactses)
    {
        this.aePatRelatedContactses = aePatRelatedContactses;
    }

    public Set getOaBlockAppts()
    {
        return oaBlockAppts;
    }

    public void setOaBlockAppts(Set oaBlockAppts)
    {
        this.oaBlockAppts = oaBlockAppts;
    }

    public Set getPrEpisodeOfCaresForErrorFacilityId()
    {
        return prEpisodeOfCaresForErrorFacilityId;
    }

    public void setPrEpisodeOfCaresForErrorFacilityId(Set prEpisodeOfCaresForErrorFacilityId)
    {
        this.prEpisodeOfCaresForErrorFacilityId = prEpisodeOfCaresForErrorFacilityId;
    }

    private String facilityId;
    private SmFacilityLevel smFacilityLevel;
    private SmSiteParam smSiteParam;
    private String facilityName;
    private String addrLine1;
    private String addrLine2;
    private String addrLine3;
    private String addrLine4;
    private String addrPostalCode;
    private String countryCode;
    private String telNo1;
    private String telNo2;
    private String telNo3;
    private String telNo4;
    private String faxNo;
    private String emailId;
    private String websiteId;
    private String headOfFacilityName;
    private String headOfFacilityJobTitle;
    private String licenseNo;
    private String facilityType;
    private String masterFacilityId;
    private String hcareSettingTypeCode;
    private String facilityClass;
    private String languageId;
    private String appServerIp;
    private String status;
    private String wsByIpName;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String faxInterfaceYn;
    private String mailInterfaceYn;
    private String resAreaCode;
    private String resTownCode;
    private String regionCode;
    private String facilityLogo;
    private String displaySiteNameYn;
    private Set smReportForFcies;
    private Set prAllergiesForOnsetFacilityId;
    private Set caPractByLocns;
    private Set ipMlyMedSerGrpBkgStats;
    private Set rsShiftPatterns;
    private Set phDispLocns;
    private Set prEpisodeOfCaresForOpenFacilityId;
    private Set oaClinicSchedules;
    private Set opQueueNumForLocns;
    private Set drDupGroupDtlses;
    private Set ipNursingUnitBeds;
    private Set rsStaffLicensures;
    private Set stFacilityParams;
    private Set ipNursingUnitForPracts;
    private Set smGrpMasterCodesForMasterFacilityId;
    private Set oaRosterForPracts;
    private Set aePractForTmtAreas;
    private Set ipDlyMedSerGrpBkgStats;
    private Set ipNursingUnitRooms;
    private Set mrDiagGroups;
    private Set smApplUsers;
    private Set prReferralRegistersForFromFacilityId;
    private Set prProblemsForCloseFacilityId;
    private Set amFacilityServices;
    private Set mrRequestors;
    private Set amOperStns;
    private Set drMergedPatientDtlses;
    private Set opEpisodeForServices;
    private Set fmCurrLocnsForCurrFacilityId;
    private Set mpParamForFacilities;
    private Set prEncounters;
    private Set fmMovementLogsForFacilityId;
    private Set smAccEntityParamFacls;
    private Set mrMdsForTermSets;
    private Set oaApptStatses;
    private Set aeTmtAreaForClinics;
    private Set smGrpMasterCodesForFacilityId;
    private Set fmIpPullingLists;
    private Set fmTransitFilesForDestFacilityId;
    private Set orOrderSetByIndexes;
    private Set cpPatCarePlans;
    private Set ssPhyInvParams;
    private Set opClinics;
    private Set rsWorkplaces;
    private Set prPorterageDetailses;
    private Set prAllergiesForCloseFacilityId;
    private Set opPatientTrackingLocns;
    private Set ipAdtTrns;
    private Set opOnlineReports;
    private Set xhApplForFacilities;
    private Set amOtherStaffs;
    private Set phPatientVaccProfiles;
    private Set fmReqHdrs;
    private Set oaUserClinicRightses;
    private Set prPatientValuableses;
    private Set phOrderRoutingDtlsForPerformingFacilityId;
    private Set stTrnDocTypes;
    private Set ipNursingUnits;
    private Set mrUserAccessRightses;
    private Set phWsForTokenSerieses;
    private Set phOrderRoutingDtlsForOrderingFacilityId;
    private Set orOrderTypeRoutings;
    private Set amRefIdNumForFcies;
    private Set amOtherStaffForFacilities;
    private Set oaClinicBreaks;
    private Set opPractForClinics;
    private Set opPatientQueueSumms;
    private Set orOrderFacilityCrossRefsForOrderingFacilityId;
    private Set mrTermSetForFacilities;
    private Set opVisitTypeForClinics;
    private Set amFacilitySubsrvcs;
    private Set phOrderRoutingsForOrderingFacilityId;
    private Set aeOnlineReports;
    private Set caEncntrDiscrMsrs;
    private Set ipDlyAgeGrpBkgStats;
    private Set fmDeficiencyHdrs;
    private Set amDeptForFacilityRooms;
    private Set orOrderFacilityCrossRefsForPerformingFacilityId;
    private Set fmReqDtlsForReqToFacilityId;
    private Set orPerformingDeptlocs;
    private Set oaHolidaies;
    private Set oaTransRecords;
    private Set fmMovementLogsForSrcFacilityId;
    private Set rsStaffExperiences;
    private Set aePatMovementLogs;
    private Set prEncounterProcedures;
    private Set ssFacilityParams;
    private Set oaClinicScheduleBreaks;
    private Set caEncntrPractRelns;
    private Set amBldngs;
    private Set oaApptSrlNos;
    private Set ssServiceLocations;
    private Set opPatientQueues;
    private Set prEncounterPracts;
    private Set phFacilityParams;
    private Set fmParameters;
    private Set phTokenSerieses;
    private Set amPractSpecialitieses;
    private Set amBldngFloors;
    private Set ipMedSerGrpNursUtTypes;
    private Set oaClinicTimeTables;
    private Set cpPositionForMdcps;
    private Set prWaitLists;
    private Set mmStores;
    private Set mpPatientsForPrefFacilityId;
    private Set ipDlyNursUtBkgStats;
    private Set prReferralRegistersForToFacilityId;
    private Set opLastVisitForServices;
    private Set mpPatientsForRegnFacilityId;
    private Set amFacilityRooms;
    private Set smFacilityForResps;
    private Set fmCurrLocnsForFacilityId;
    private Set ipBedBookingSrlCtrls;
    private Set fmMovementLogsForDestFacilityId;
    private Set stPrepareLocations;
    private Set caApplTaskForSplties;
    private Set amPractitioners;
    private Set opParams;
    private Set mrFileTypes;
    private Set ipNursingUnitLocations;
    private Set fmDeficiencyDtls;
    private Set ipTransferPriorities;
    private Set rsStaffUnavailabilityLogs;
    private Set prProblemsForOnsetFacilityId;
    private Set oaClinicScheduleValidities;
    private Set fmReqDtlsForCurrFacilityId;
    private Set opParamForFacilityServices;
    private Set smFacilityForUsers;
    private Set caEncntrNotes;
    private Set caApplTaskForRespRelns;
    private Set fmUserAccessRightses;
    private Set aePatEmergencyDetails;
    private Set amPractForFacilities;
    private Set caNoteTypeForSplties;
    private Set amFacilityDepts;
    private Set ipBookLimitByNursUts;
    private Set fmPullingLists;
    private Set amRestrnForOperStns;
    private Set oaApptDelTrs;
    private Set smModulesFacilities;
    private Set phOrderRoutingsForPerformingFacilityId;
    private Set fmTransitFilesForSrcFacilityId;
    private Set ipBookLimitByAgeGrps;
    private Set prEncIdNumForFcies;
    private Set phDispRightses;
    private Set ipBedBookings;
    private Set mrSections;
    private Set caNoteTypeByServs;
    private Set fmStorageLocns;
    private Set ipBookingLists;
    private Set mrPatFileIndexes;
    private Set ipMedicalServiceGroups;
    private Set smPrintRoutings;
    private Set aeCurrentPatients;
    private Set opCurrentPatients;
    private Set drSearchCriterias;
    private Set stRepackingGroups;
    private Set prEpisodeOfCaresForResolveFacilityId;
    private Set oaAppts;
    private Set amMedicalTeams;
    private Set rsStaffTrainings;
    private Set opVisitTypes;
    private Set qaQindFacilityClinds;
    private Set aePatRelatedContactses;
    private Set oaBlockAppts;
    private Set prEpisodeOfCaresForErrorFacilityId;
}
