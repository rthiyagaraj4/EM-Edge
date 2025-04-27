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
//            OpClinicId

public class OpClinic
    implements Serializable
{

    public OpClinic()
    {
        oaClinicScheduleDtls = new HashSet(0);
        oaBlockAppts = new HashSet(0);
        opCurrentPatients = new HashSet(0);
        oaClinicSchedules = new HashSet(0);
        oaClinicScheduleValidities = new HashSet(0);
        opClinicForServices = new HashSet(0);
        oaRosterForPracts = new HashSet(0);
        opEpisodeForServices = new HashSet(0);
        oaApptStatses = new HashSet(0);
        oaClinicBreaks = new HashSet(0);
        oaTransRecords = new HashSet(0);
        oaUserClinicRightses = new HashSet(0);
        opVisitTypeForClinics = new HashSet(0);
        opQueueNumForLocns = new HashSet(0);
        oaClinicScheduleBreaks = new HashSet(0);
        opPractForClinics = new HashSet(0);
        oaClinicTimeTables = new HashSet(0);
        oaBlockApptDtls = new HashSet(0);
        opPatientQueues = new HashSet(0);
        oaApptDelTrs = new HashSet(0);
        oaAppts = new HashSet(0);
        opPatientQueueSumms = new HashSet(0);
    }

    public OpClinic(OpClinicId id, String clinicType, String longDesc, String shortDesc, String workingDay1, String workingDay2, String workingDay3, 
            String workingDay4, String workingDay5, String workingDay6, String workingDay7, String onlineMrNotfnYn, String levelOfCareInd, String specialityCode, 
            String openToAllPractYn, String identAtCheckin, String allowApptYn, String allowVisitRegnYn, String recordVitalSignsYn, String recordImmuYn, String recordOutcomeYn, 
            String fiVisitTypeApplYn, String fuVisitTypeApplYn, String rtVisitTypeApplYn, String srVisitTypeApplYn, String csVisitTypeApplYn, String emVisitTypeApplYn, String effStatus, 
            String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, 
            String modifiedFacilityId, String allowWalkInYn, String allowReferralYn, String allowNonReferralYn, String careLocnTypeInd, String dcApplYn, String emApplYn, 
            String ipApplYn, String opApplYn, String workingWeek1Day1, String workingWeek1Day2, String workingWeek1Day3, String workingWeek1Day4, String workingWeek1Day5, 
            String workingWeek1Day6, String workingWeek1Day7, String workingWeek2Day1, String workingWeek2Day2, String workingWeek2Day3, String workingWeek2Day4, String workingWeek2Day5, 
            String workingWeek2Day6, String workingWeek2Day7, String workingWeek3Day1, String workingWeek3Day2, String workingWeek3Day3, String workingWeek3Day4, String workingWeek3Day5, 
            String workingWeek3Day6, String workingWeek3Day7, String workingWeek4Day1, String workingWeek4Day2, String workingWeek4Day3, String workingWeek4Day4, String workingWeek4Day5, 
            String workingWeek4Day6, String workingWeek4Day7, String workingWeek5Day1, String workingWeek5Day2, String workingWeek5Day3, String workingWeek5Day4, String workingWeek5Day5, 
            String workingWeek5Day6, String workingWeek5Day7, String workingWeekApplDay1, String workingWeekApplDay2, String workingWeekApplDay3, String workingWeekApplDay4, String workingWeekApplDay5, 
            String workingWeekApplDay6, String workingWeekApplDay7, String specialistClinicYn, String visitSpecialistClinicYn, String queueNumApplYn, String queueNumByPractYn, String queueNumByRoomYn, 
            String queueNumByOtherResYn)
    {
        oaClinicScheduleDtls = new HashSet(0);
        oaBlockAppts = new HashSet(0);
        opCurrentPatients = new HashSet(0);
        oaClinicSchedules = new HashSet(0);
        oaClinicScheduleValidities = new HashSet(0);
        opClinicForServices = new HashSet(0);
        oaRosterForPracts = new HashSet(0);
        opEpisodeForServices = new HashSet(0);
        oaApptStatses = new HashSet(0);
        oaClinicBreaks = new HashSet(0);
        oaTransRecords = new HashSet(0);
        oaUserClinicRightses = new HashSet(0);
        opVisitTypeForClinics = new HashSet(0);
        opQueueNumForLocns = new HashSet(0);
        oaClinicScheduleBreaks = new HashSet(0);
        opPractForClinics = new HashSet(0);
        oaClinicTimeTables = new HashSet(0);
        oaBlockApptDtls = new HashSet(0);
        opPatientQueues = new HashSet(0);
        oaApptDelTrs = new HashSet(0);
        oaAppts = new HashSet(0);
        opPatientQueueSumms = new HashSet(0);
        this.id = id;
        this.clinicType = clinicType;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.workingDay1 = workingDay1;
        this.workingDay2 = workingDay2;
        this.workingDay3 = workingDay3;
        this.workingDay4 = workingDay4;
        this.workingDay5 = workingDay5;
        this.workingDay6 = workingDay6;
        this.workingDay7 = workingDay7;
        this.onlineMrNotfnYn = onlineMrNotfnYn;
        this.levelOfCareInd = levelOfCareInd;
        this.specialityCode = specialityCode;
        this.openToAllPractYn = openToAllPractYn;
        this.identAtCheckin = identAtCheckin;
        this.allowApptYn = allowApptYn;
        this.allowVisitRegnYn = allowVisitRegnYn;
        this.recordVitalSignsYn = recordVitalSignsYn;
        this.recordImmuYn = recordImmuYn;
        this.recordOutcomeYn = recordOutcomeYn;
        this.fiVisitTypeApplYn = fiVisitTypeApplYn;
        this.fuVisitTypeApplYn = fuVisitTypeApplYn;
        this.rtVisitTypeApplYn = rtVisitTypeApplYn;
        this.srVisitTypeApplYn = srVisitTypeApplYn;
        this.csVisitTypeApplYn = csVisitTypeApplYn;
        this.emVisitTypeApplYn = emVisitTypeApplYn;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.allowWalkInYn = allowWalkInYn;
        this.allowReferralYn = allowReferralYn;
        this.allowNonReferralYn = allowNonReferralYn;
        this.careLocnTypeInd = careLocnTypeInd;
        this.dcApplYn = dcApplYn;
        this.emApplYn = emApplYn;
        this.ipApplYn = ipApplYn;
        this.opApplYn = opApplYn;
        this.workingWeek1Day1 = workingWeek1Day1;
        this.workingWeek1Day2 = workingWeek1Day2;
        this.workingWeek1Day3 = workingWeek1Day3;
        this.workingWeek1Day4 = workingWeek1Day4;
        this.workingWeek1Day5 = workingWeek1Day5;
        this.workingWeek1Day6 = workingWeek1Day6;
        this.workingWeek1Day7 = workingWeek1Day7;
        this.workingWeek2Day1 = workingWeek2Day1;
        this.workingWeek2Day2 = workingWeek2Day2;
        this.workingWeek2Day3 = workingWeek2Day3;
        this.workingWeek2Day4 = workingWeek2Day4;
        this.workingWeek2Day5 = workingWeek2Day5;
        this.workingWeek2Day6 = workingWeek2Day6;
        this.workingWeek2Day7 = workingWeek2Day7;
        this.workingWeek3Day1 = workingWeek3Day1;
        this.workingWeek3Day2 = workingWeek3Day2;
        this.workingWeek3Day3 = workingWeek3Day3;
        this.workingWeek3Day4 = workingWeek3Day4;
        this.workingWeek3Day5 = workingWeek3Day5;
        this.workingWeek3Day6 = workingWeek3Day6;
        this.workingWeek3Day7 = workingWeek3Day7;
        this.workingWeek4Day1 = workingWeek4Day1;
        this.workingWeek4Day2 = workingWeek4Day2;
        this.workingWeek4Day3 = workingWeek4Day3;
        this.workingWeek4Day4 = workingWeek4Day4;
        this.workingWeek4Day5 = workingWeek4Day5;
        this.workingWeek4Day6 = workingWeek4Day6;
        this.workingWeek4Day7 = workingWeek4Day7;
        this.workingWeek5Day1 = workingWeek5Day1;
        this.workingWeek5Day2 = workingWeek5Day2;
        this.workingWeek5Day3 = workingWeek5Day3;
        this.workingWeek5Day4 = workingWeek5Day4;
        this.workingWeek5Day5 = workingWeek5Day5;
        this.workingWeek5Day6 = workingWeek5Day6;
        this.workingWeek5Day7 = workingWeek5Day7;
        this.workingWeekApplDay1 = workingWeekApplDay1;
        this.workingWeekApplDay2 = workingWeekApplDay2;
        this.workingWeekApplDay3 = workingWeekApplDay3;
        this.workingWeekApplDay4 = workingWeekApplDay4;
        this.workingWeekApplDay5 = workingWeekApplDay5;
        this.workingWeekApplDay6 = workingWeekApplDay6;
        this.workingWeekApplDay7 = workingWeekApplDay7;
        this.specialistClinicYn = specialistClinicYn;
        this.visitSpecialistClinicYn = visitSpecialistClinicYn;
        this.queueNumApplYn = queueNumApplYn;
        this.queueNumByPractYn = queueNumByPractYn;
        this.queueNumByRoomYn = queueNumByRoomYn;
        this.queueNumByOtherResYn = queueNumByOtherResYn;
    }

    public OpClinic(OpClinicId id, String clinicType, String longDesc, String shortDesc, String workingDay1, String workingDay2, String workingDay3, 
            String workingDay4, String workingDay5, String workingDay6, String workingDay7, String mrLocationCode, String mrSectionType, String mrSectionCode, 
            String onlineMrNotfnYn, String ageGroupCode, String levelOfCareInd, String specialityCode, String deptCode, String serviceCode, String practType, 
            String openToAllPractYn, String identAtCheckin, String allowApptYn, String allowVisitRegnYn, String allowUnassignInPractqYn, String recordVitalSignsYn, String recordImmuYn, 
            String recordOutcomeYn, String fiVisitTypeApplYn, String fuVisitTypeApplYn, String rtVisitTypeApplYn, String srVisitTypeApplYn, String csVisitTypeApplYn, String emVisitTypeApplYn, 
            String vitalSignsBatteryId, String alcnCriteria, String dispInCaQueueAfter, Date effDateFrom, Date effDateTo, String effStatus, String addedById, 
            Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, 
            String allowWalkInYn, String allowReferralYn, String allowNonReferralYn, Date baseSlotSlabTime, String careLocnTypeInd, String dcApplYn, String dfltFileTypeCode, 
            String emApplYn, String ipApplYn, String opApplYn, String primaryResourceClass, String sectionCode, Date workingDayEndTime, Date workingDayStartTime, 
            String workingWeek1Day1, String workingWeek1Day2, String workingWeek1Day3, String workingWeek1Day4, String workingWeek1Day5, String workingWeek1Day6, String workingWeek1Day7, 
            String workingWeek2Day1, String workingWeek2Day2, String workingWeek2Day3, String workingWeek2Day4, String workingWeek2Day5, String workingWeek2Day6, String workingWeek2Day7, 
            String workingWeek3Day1, String workingWeek3Day2, String workingWeek3Day3, String workingWeek3Day4, String workingWeek3Day5, String workingWeek3Day6, String workingWeek3Day7, 
            String workingWeek4Day1, String workingWeek4Day2, String workingWeek4Day3, String workingWeek4Day4, String workingWeek4Day5, String workingWeek4Day6, String workingWeek4Day7, 
            String workingWeek5Day1, String workingWeek5Day2, String workingWeek5Day3, String workingWeek5Day4, String workingWeek5Day5, String workingWeek5Day6, String workingWeek5Day7, 
            String workingWeekApplDay1, String workingWeekApplDay2, String workingWeekApplDay3, String workingWeekApplDay4, String workingWeekApplDay5, String workingWeekApplDay6, String workingWeekApplDay7, 
            String specialistClinicYn, String visitSpecialistClinicYn, String queueNumApplYn, String queueNumByPractYn, String queueNumByRoomYn, String queueNumByOtherResYn, String queueNumOtherResClass, 
            String queueNumOtherResType, Set oaClinicScheduleDtls, Set oaBlockAppts, Set opCurrentPatients, Set oaClinicSchedules, Set oaClinicScheduleValidities, Set opClinicForServices, 
            Set oaRosterForPracts, Set opEpisodeForServices, Set oaApptStatses, Set oaClinicBreaks, Set oaTransRecords, Set oaUserClinicRightses, Set opVisitTypeForClinics, 
            Set opQueueNumForLocns, Set oaClinicScheduleBreaks, Set opPractForClinics, Set oaClinicTimeTables, Set oaBlockApptDtls, Set opPatientQueues, Set oaApptDelTrs, 
            Set oaAppts, Set opPatientQueueSumms)
    {
        this.oaClinicScheduleDtls = new HashSet(0);
        this.oaBlockAppts = new HashSet(0);
        this.opCurrentPatients = new HashSet(0);
        this.oaClinicSchedules = new HashSet(0);
        this.oaClinicScheduleValidities = new HashSet(0);
        this.opClinicForServices = new HashSet(0);
        this.oaRosterForPracts = new HashSet(0);
        this.opEpisodeForServices = new HashSet(0);
        this.oaApptStatses = new HashSet(0);
        this.oaClinicBreaks = new HashSet(0);
        this.oaTransRecords = new HashSet(0);
        this.oaUserClinicRightses = new HashSet(0);
        this.opVisitTypeForClinics = new HashSet(0);
        this.opQueueNumForLocns = new HashSet(0);
        this.oaClinicScheduleBreaks = new HashSet(0);
        this.opPractForClinics = new HashSet(0);
        this.oaClinicTimeTables = new HashSet(0);
        this.oaBlockApptDtls = new HashSet(0);
        this.opPatientQueues = new HashSet(0);
        this.oaApptDelTrs = new HashSet(0);
        this.oaAppts = new HashSet(0);
        this.opPatientQueueSumms = new HashSet(0);
        this.id = id;
        this.clinicType = clinicType;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.workingDay1 = workingDay1;
        this.workingDay2 = workingDay2;
        this.workingDay3 = workingDay3;
        this.workingDay4 = workingDay4;
        this.workingDay5 = workingDay5;
        this.workingDay6 = workingDay6;
        this.workingDay7 = workingDay7;
        this.mrLocationCode = mrLocationCode;
        this.mrSectionType = mrSectionType;
        this.mrSectionCode = mrSectionCode;
        this.onlineMrNotfnYn = onlineMrNotfnYn;
        this.ageGroupCode = ageGroupCode;
        this.levelOfCareInd = levelOfCareInd;
        this.specialityCode = specialityCode;
        this.deptCode = deptCode;
        this.serviceCode = serviceCode;
        this.practType = practType;
        this.openToAllPractYn = openToAllPractYn;
        this.identAtCheckin = identAtCheckin;
        this.allowApptYn = allowApptYn;
        this.allowVisitRegnYn = allowVisitRegnYn;
        this.allowUnassignInPractqYn = allowUnassignInPractqYn;
        this.recordVitalSignsYn = recordVitalSignsYn;
        this.recordImmuYn = recordImmuYn;
        this.recordOutcomeYn = recordOutcomeYn;
        this.fiVisitTypeApplYn = fiVisitTypeApplYn;
        this.fuVisitTypeApplYn = fuVisitTypeApplYn;
        this.rtVisitTypeApplYn = rtVisitTypeApplYn;
        this.srVisitTypeApplYn = srVisitTypeApplYn;
        this.csVisitTypeApplYn = csVisitTypeApplYn;
        this.emVisitTypeApplYn = emVisitTypeApplYn;
        this.vitalSignsBatteryId = vitalSignsBatteryId;
        this.alcnCriteria = alcnCriteria;
        this.dispInCaQueueAfter = dispInCaQueueAfter;
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
        this.allowWalkInYn = allowWalkInYn;
        this.allowReferralYn = allowReferralYn;
        this.allowNonReferralYn = allowNonReferralYn;
        this.baseSlotSlabTime = baseSlotSlabTime;
        this.careLocnTypeInd = careLocnTypeInd;
        this.dcApplYn = dcApplYn;
        this.dfltFileTypeCode = dfltFileTypeCode;
        this.emApplYn = emApplYn;
        this.ipApplYn = ipApplYn;
        this.opApplYn = opApplYn;
        this.primaryResourceClass = primaryResourceClass;
        this.sectionCode = sectionCode;
        this.workingDayEndTime = workingDayEndTime;
        this.workingDayStartTime = workingDayStartTime;
        this.workingWeek1Day1 = workingWeek1Day1;
        this.workingWeek1Day2 = workingWeek1Day2;
        this.workingWeek1Day3 = workingWeek1Day3;
        this.workingWeek1Day4 = workingWeek1Day4;
        this.workingWeek1Day5 = workingWeek1Day5;
        this.workingWeek1Day6 = workingWeek1Day6;
        this.workingWeek1Day7 = workingWeek1Day7;
        this.workingWeek2Day1 = workingWeek2Day1;
        this.workingWeek2Day2 = workingWeek2Day2;
        this.workingWeek2Day3 = workingWeek2Day3;
        this.workingWeek2Day4 = workingWeek2Day4;
        this.workingWeek2Day5 = workingWeek2Day5;
        this.workingWeek2Day6 = workingWeek2Day6;
        this.workingWeek2Day7 = workingWeek2Day7;
        this.workingWeek3Day1 = workingWeek3Day1;
        this.workingWeek3Day2 = workingWeek3Day2;
        this.workingWeek3Day3 = workingWeek3Day3;
        this.workingWeek3Day4 = workingWeek3Day4;
        this.workingWeek3Day5 = workingWeek3Day5;
        this.workingWeek3Day6 = workingWeek3Day6;
        this.workingWeek3Day7 = workingWeek3Day7;
        this.workingWeek4Day1 = workingWeek4Day1;
        this.workingWeek4Day2 = workingWeek4Day2;
        this.workingWeek4Day3 = workingWeek4Day3;
        this.workingWeek4Day4 = workingWeek4Day4;
        this.workingWeek4Day5 = workingWeek4Day5;
        this.workingWeek4Day6 = workingWeek4Day6;
        this.workingWeek4Day7 = workingWeek4Day7;
        this.workingWeek5Day1 = workingWeek5Day1;
        this.workingWeek5Day2 = workingWeek5Day2;
        this.workingWeek5Day3 = workingWeek5Day3;
        this.workingWeek5Day4 = workingWeek5Day4;
        this.workingWeek5Day5 = workingWeek5Day5;
        this.workingWeek5Day6 = workingWeek5Day6;
        this.workingWeek5Day7 = workingWeek5Day7;
        this.workingWeekApplDay1 = workingWeekApplDay1;
        this.workingWeekApplDay2 = workingWeekApplDay2;
        this.workingWeekApplDay3 = workingWeekApplDay3;
        this.workingWeekApplDay4 = workingWeekApplDay4;
        this.workingWeekApplDay5 = workingWeekApplDay5;
        this.workingWeekApplDay6 = workingWeekApplDay6;
        this.workingWeekApplDay7 = workingWeekApplDay7;
        this.specialistClinicYn = specialistClinicYn;
        this.visitSpecialistClinicYn = visitSpecialistClinicYn;
        this.queueNumApplYn = queueNumApplYn;
        this.queueNumByPractYn = queueNumByPractYn;
        this.queueNumByRoomYn = queueNumByRoomYn;
        this.queueNumByOtherResYn = queueNumByOtherResYn;
        this.queueNumOtherResClass = queueNumOtherResClass;
        this.queueNumOtherResType = queueNumOtherResType;
        this.oaClinicScheduleDtls = oaClinicScheduleDtls;
        this.oaBlockAppts = oaBlockAppts;
        this.opCurrentPatients = opCurrentPatients;
        this.oaClinicSchedules = oaClinicSchedules;
        this.oaClinicScheduleValidities = oaClinicScheduleValidities;
        this.opClinicForServices = opClinicForServices;
        this.oaRosterForPracts = oaRosterForPracts;
        this.opEpisodeForServices = opEpisodeForServices;
        this.oaApptStatses = oaApptStatses;
        this.oaClinicBreaks = oaClinicBreaks;
        this.oaTransRecords = oaTransRecords;
        this.oaUserClinicRightses = oaUserClinicRightses;
        this.opVisitTypeForClinics = opVisitTypeForClinics;
        this.opQueueNumForLocns = opQueueNumForLocns;
        this.oaClinicScheduleBreaks = oaClinicScheduleBreaks;
        this.opPractForClinics = opPractForClinics;
        this.oaClinicTimeTables = oaClinicTimeTables;
        this.oaBlockApptDtls = oaBlockApptDtls;
        this.opPatientQueues = opPatientQueues;
        this.oaApptDelTrs = oaApptDelTrs;
        this.oaAppts = oaAppts;
        this.opPatientQueueSumms = opPatientQueueSumms;
    }

    public OpClinicId getId()
    {
        return id;
    }

    public void setId(OpClinicId id)
    {
        this.id = id;
    }

    public String getClinicType()
    {
        return clinicType;
    }

    public void setClinicType(String clinicType)
    {
        this.clinicType = clinicType;
    }

    public String getLongDesc()
    {
        return longDesc;
    }

    public void setLongDesc(String longDesc)
    {
        this.longDesc = longDesc;
    }

    public String getShortDesc()
    {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc)
    {
        this.shortDesc = shortDesc;
    }

    public String getWorkingDay1()
    {
        return workingDay1;
    }

    public void setWorkingDay1(String workingDay1)
    {
        this.workingDay1 = workingDay1;
    }

    public String getWorkingDay2()
    {
        return workingDay2;
    }

    public void setWorkingDay2(String workingDay2)
    {
        this.workingDay2 = workingDay2;
    }

    public String getWorkingDay3()
    {
        return workingDay3;
    }

    public void setWorkingDay3(String workingDay3)
    {
        this.workingDay3 = workingDay3;
    }

    public String getWorkingDay4()
    {
        return workingDay4;
    }

    public void setWorkingDay4(String workingDay4)
    {
        this.workingDay4 = workingDay4;
    }

    public String getWorkingDay5()
    {
        return workingDay5;
    }

    public void setWorkingDay5(String workingDay5)
    {
        this.workingDay5 = workingDay5;
    }

    public String getWorkingDay6()
    {
        return workingDay6;
    }

    public void setWorkingDay6(String workingDay6)
    {
        this.workingDay6 = workingDay6;
    }

    public String getWorkingDay7()
    {
        return workingDay7;
    }

    public void setWorkingDay7(String workingDay7)
    {
        this.workingDay7 = workingDay7;
    }

    public String getMrLocationCode()
    {
        return mrLocationCode;
    }

    public void setMrLocationCode(String mrLocationCode)
    {
        this.mrLocationCode = mrLocationCode;
    }

    public String getMrSectionType()
    {
        return mrSectionType;
    }

    public void setMrSectionType(String mrSectionType)
    {
        this.mrSectionType = mrSectionType;
    }

    public String getMrSectionCode()
    {
        return mrSectionCode;
    }

    public void setMrSectionCode(String mrSectionCode)
    {
        this.mrSectionCode = mrSectionCode;
    }

    public String getOnlineMrNotfnYn()
    {
        return onlineMrNotfnYn;
    }

    public void setOnlineMrNotfnYn(String onlineMrNotfnYn)
    {
        this.onlineMrNotfnYn = onlineMrNotfnYn;
    }

    public String getAgeGroupCode()
    {
        return ageGroupCode;
    }

    public void setAgeGroupCode(String ageGroupCode)
    {
        this.ageGroupCode = ageGroupCode;
    }

    public String getLevelOfCareInd()
    {
        return levelOfCareInd;
    }

    public void setLevelOfCareInd(String levelOfCareInd)
    {
        this.levelOfCareInd = levelOfCareInd;
    }

    public String getSpecialityCode()
    {
        return specialityCode;
    }

    public void setSpecialityCode(String specialityCode)
    {
        this.specialityCode = specialityCode;
    }

    public String getDeptCode()
    {
        return deptCode;
    }

    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }

    public String getServiceCode()
    {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode)
    {
        this.serviceCode = serviceCode;
    }

    public String getPractType()
    {
        return practType;
    }

    public void setPractType(String practType)
    {
        this.practType = practType;
    }

    public String getOpenToAllPractYn()
    {
        return openToAllPractYn;
    }

    public void setOpenToAllPractYn(String openToAllPractYn)
    {
        this.openToAllPractYn = openToAllPractYn;
    }

    public String getIdentAtCheckin()
    {
        return identAtCheckin;
    }

    public void setIdentAtCheckin(String identAtCheckin)
    {
        this.identAtCheckin = identAtCheckin;
    }

    public String getAllowApptYn()
    {
        return allowApptYn;
    }

    public void setAllowApptYn(String allowApptYn)
    {
        this.allowApptYn = allowApptYn;
    }

    public String getAllowVisitRegnYn()
    {
        return allowVisitRegnYn;
    }

    public void setAllowVisitRegnYn(String allowVisitRegnYn)
    {
        this.allowVisitRegnYn = allowVisitRegnYn;
    }

    public String getAllowUnassignInPractqYn()
    {
        return allowUnassignInPractqYn;
    }

    public void setAllowUnassignInPractqYn(String allowUnassignInPractqYn)
    {
        this.allowUnassignInPractqYn = allowUnassignInPractqYn;
    }

    public String getRecordVitalSignsYn()
    {
        return recordVitalSignsYn;
    }

    public void setRecordVitalSignsYn(String recordVitalSignsYn)
    {
        this.recordVitalSignsYn = recordVitalSignsYn;
    }

    public String getRecordImmuYn()
    {
        return recordImmuYn;
    }

    public void setRecordImmuYn(String recordImmuYn)
    {
        this.recordImmuYn = recordImmuYn;
    }

    public String getRecordOutcomeYn()
    {
        return recordOutcomeYn;
    }

    public void setRecordOutcomeYn(String recordOutcomeYn)
    {
        this.recordOutcomeYn = recordOutcomeYn;
    }

    public String getFiVisitTypeApplYn()
    {
        return fiVisitTypeApplYn;
    }

    public void setFiVisitTypeApplYn(String fiVisitTypeApplYn)
    {
        this.fiVisitTypeApplYn = fiVisitTypeApplYn;
    }

    public String getFuVisitTypeApplYn()
    {
        return fuVisitTypeApplYn;
    }

    public void setFuVisitTypeApplYn(String fuVisitTypeApplYn)
    {
        this.fuVisitTypeApplYn = fuVisitTypeApplYn;
    }

    public String getRtVisitTypeApplYn()
    {
        return rtVisitTypeApplYn;
    }

    public void setRtVisitTypeApplYn(String rtVisitTypeApplYn)
    {
        this.rtVisitTypeApplYn = rtVisitTypeApplYn;
    }

    public String getSrVisitTypeApplYn()
    {
        return srVisitTypeApplYn;
    }

    public void setSrVisitTypeApplYn(String srVisitTypeApplYn)
    {
        this.srVisitTypeApplYn = srVisitTypeApplYn;
    }

    public String getCsVisitTypeApplYn()
    {
        return csVisitTypeApplYn;
    }

    public void setCsVisitTypeApplYn(String csVisitTypeApplYn)
    {
        this.csVisitTypeApplYn = csVisitTypeApplYn;
    }

    public String getEmVisitTypeApplYn()
    {
        return emVisitTypeApplYn;
    }

    public void setEmVisitTypeApplYn(String emVisitTypeApplYn)
    {
        this.emVisitTypeApplYn = emVisitTypeApplYn;
    }

    public String getVitalSignsBatteryId()
    {
        return vitalSignsBatteryId;
    }

    public void setVitalSignsBatteryId(String vitalSignsBatteryId)
    {
        this.vitalSignsBatteryId = vitalSignsBatteryId;
    }

    public String getAlcnCriteria()
    {
        return alcnCriteria;
    }

    public void setAlcnCriteria(String alcnCriteria)
    {
        this.alcnCriteria = alcnCriteria;
    }

    public String getDispInCaQueueAfter()
    {
        return dispInCaQueueAfter;
    }

    public void setDispInCaQueueAfter(String dispInCaQueueAfter)
    {
        this.dispInCaQueueAfter = dispInCaQueueAfter;
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

    public String getAllowWalkInYn()
    {
        return allowWalkInYn;
    }

    public void setAllowWalkInYn(String allowWalkInYn)
    {
        this.allowWalkInYn = allowWalkInYn;
    }

    public String getAllowReferralYn()
    {
        return allowReferralYn;
    }

    public void setAllowReferralYn(String allowReferralYn)
    {
        this.allowReferralYn = allowReferralYn;
    }

    public String getAllowNonReferralYn()
    {
        return allowNonReferralYn;
    }

    public void setAllowNonReferralYn(String allowNonReferralYn)
    {
        this.allowNonReferralYn = allowNonReferralYn;
    }

    public Date getBaseSlotSlabTime()
    {
        return baseSlotSlabTime;
    }

    public void setBaseSlotSlabTime(Date baseSlotSlabTime)
    {
        this.baseSlotSlabTime = baseSlotSlabTime;
    }

    public String getCareLocnTypeInd()
    {
        return careLocnTypeInd;
    }

    public void setCareLocnTypeInd(String careLocnTypeInd)
    {
        this.careLocnTypeInd = careLocnTypeInd;
    }

    public String getDcApplYn()
    {
        return dcApplYn;
    }

    public void setDcApplYn(String dcApplYn)
    {
        this.dcApplYn = dcApplYn;
    }

    public String getDfltFileTypeCode()
    {
        return dfltFileTypeCode;
    }

    public void setDfltFileTypeCode(String dfltFileTypeCode)
    {
        this.dfltFileTypeCode = dfltFileTypeCode;
    }

    public String getEmApplYn()
    {
        return emApplYn;
    }

    public void setEmApplYn(String emApplYn)
    {
        this.emApplYn = emApplYn;
    }

    public String getIpApplYn()
    {
        return ipApplYn;
    }

    public void setIpApplYn(String ipApplYn)
    {
        this.ipApplYn = ipApplYn;
    }

    public String getOpApplYn()
    {
        return opApplYn;
    }

    public void setOpApplYn(String opApplYn)
    {
        this.opApplYn = opApplYn;
    }

    public String getPrimaryResourceClass()
    {
        return primaryResourceClass;
    }

    public void setPrimaryResourceClass(String primaryResourceClass)
    {
        this.primaryResourceClass = primaryResourceClass;
    }

    public String getSectionCode()
    {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode)
    {
        this.sectionCode = sectionCode;
    }

    public Date getWorkingDayEndTime()
    {
        return workingDayEndTime;
    }

    public void setWorkingDayEndTime(Date workingDayEndTime)
    {
        this.workingDayEndTime = workingDayEndTime;
    }

    public Date getWorkingDayStartTime()
    {
        return workingDayStartTime;
    }

    public void setWorkingDayStartTime(Date workingDayStartTime)
    {
        this.workingDayStartTime = workingDayStartTime;
    }

    public String getWorkingWeek1Day1()
    {
        return workingWeek1Day1;
    }

    public void setWorkingWeek1Day1(String workingWeek1Day1)
    {
        this.workingWeek1Day1 = workingWeek1Day1;
    }

    public String getWorkingWeek1Day2()
    {
        return workingWeek1Day2;
    }

    public void setWorkingWeek1Day2(String workingWeek1Day2)
    {
        this.workingWeek1Day2 = workingWeek1Day2;
    }

    public String getWorkingWeek1Day3()
    {
        return workingWeek1Day3;
    }

    public void setWorkingWeek1Day3(String workingWeek1Day3)
    {
        this.workingWeek1Day3 = workingWeek1Day3;
    }

    public String getWorkingWeek1Day4()
    {
        return workingWeek1Day4;
    }

    public void setWorkingWeek1Day4(String workingWeek1Day4)
    {
        this.workingWeek1Day4 = workingWeek1Day4;
    }

    public String getWorkingWeek1Day5()
    {
        return workingWeek1Day5;
    }

    public void setWorkingWeek1Day5(String workingWeek1Day5)
    {
        this.workingWeek1Day5 = workingWeek1Day5;
    }

    public String getWorkingWeek1Day6()
    {
        return workingWeek1Day6;
    }

    public void setWorkingWeek1Day6(String workingWeek1Day6)
    {
        this.workingWeek1Day6 = workingWeek1Day6;
    }

    public String getWorkingWeek1Day7()
    {
        return workingWeek1Day7;
    }

    public void setWorkingWeek1Day7(String workingWeek1Day7)
    {
        this.workingWeek1Day7 = workingWeek1Day7;
    }

    public String getWorkingWeek2Day1()
    {
        return workingWeek2Day1;
    }

    public void setWorkingWeek2Day1(String workingWeek2Day1)
    {
        this.workingWeek2Day1 = workingWeek2Day1;
    }

    public String getWorkingWeek2Day2()
    {
        return workingWeek2Day2;
    }

    public void setWorkingWeek2Day2(String workingWeek2Day2)
    {
        this.workingWeek2Day2 = workingWeek2Day2;
    }

    public String getWorkingWeek2Day3()
    {
        return workingWeek2Day3;
    }

    public void setWorkingWeek2Day3(String workingWeek2Day3)
    {
        this.workingWeek2Day3 = workingWeek2Day3;
    }

    public String getWorkingWeek2Day4()
    {
        return workingWeek2Day4;
    }

    public void setWorkingWeek2Day4(String workingWeek2Day4)
    {
        this.workingWeek2Day4 = workingWeek2Day4;
    }

    public String getWorkingWeek2Day5()
    {
        return workingWeek2Day5;
    }

    public void setWorkingWeek2Day5(String workingWeek2Day5)
    {
        this.workingWeek2Day5 = workingWeek2Day5;
    }

    public String getWorkingWeek2Day6()
    {
        return workingWeek2Day6;
    }

    public void setWorkingWeek2Day6(String workingWeek2Day6)
    {
        this.workingWeek2Day6 = workingWeek2Day6;
    }

    public String getWorkingWeek2Day7()
    {
        return workingWeek2Day7;
    }

    public void setWorkingWeek2Day7(String workingWeek2Day7)
    {
        this.workingWeek2Day7 = workingWeek2Day7;
    }

    public String getWorkingWeek3Day1()
    {
        return workingWeek3Day1;
    }

    public void setWorkingWeek3Day1(String workingWeek3Day1)
    {
        this.workingWeek3Day1 = workingWeek3Day1;
    }

    public String getWorkingWeek3Day2()
    {
        return workingWeek3Day2;
    }

    public void setWorkingWeek3Day2(String workingWeek3Day2)
    {
        this.workingWeek3Day2 = workingWeek3Day2;
    }

    public String getWorkingWeek3Day3()
    {
        return workingWeek3Day3;
    }

    public void setWorkingWeek3Day3(String workingWeek3Day3)
    {
        this.workingWeek3Day3 = workingWeek3Day3;
    }

    public String getWorkingWeek3Day4()
    {
        return workingWeek3Day4;
    }

    public void setWorkingWeek3Day4(String workingWeek3Day4)
    {
        this.workingWeek3Day4 = workingWeek3Day4;
    }

    public String getWorkingWeek3Day5()
    {
        return workingWeek3Day5;
    }

    public void setWorkingWeek3Day5(String workingWeek3Day5)
    {
        this.workingWeek3Day5 = workingWeek3Day5;
    }

    public String getWorkingWeek3Day6()
    {
        return workingWeek3Day6;
    }

    public void setWorkingWeek3Day6(String workingWeek3Day6)
    {
        this.workingWeek3Day6 = workingWeek3Day6;
    }

    public String getWorkingWeek3Day7()
    {
        return workingWeek3Day7;
    }

    public void setWorkingWeek3Day7(String workingWeek3Day7)
    {
        this.workingWeek3Day7 = workingWeek3Day7;
    }

    public String getWorkingWeek4Day1()
    {
        return workingWeek4Day1;
    }

    public void setWorkingWeek4Day1(String workingWeek4Day1)
    {
        this.workingWeek4Day1 = workingWeek4Day1;
    }

    public String getWorkingWeek4Day2()
    {
        return workingWeek4Day2;
    }

    public void setWorkingWeek4Day2(String workingWeek4Day2)
    {
        this.workingWeek4Day2 = workingWeek4Day2;
    }

    public String getWorkingWeek4Day3()
    {
        return workingWeek4Day3;
    }

    public void setWorkingWeek4Day3(String workingWeek4Day3)
    {
        this.workingWeek4Day3 = workingWeek4Day3;
    }

    public String getWorkingWeek4Day4()
    {
        return workingWeek4Day4;
    }

    public void setWorkingWeek4Day4(String workingWeek4Day4)
    {
        this.workingWeek4Day4 = workingWeek4Day4;
    }

    public String getWorkingWeek4Day5()
    {
        return workingWeek4Day5;
    }

    public void setWorkingWeek4Day5(String workingWeek4Day5)
    {
        this.workingWeek4Day5 = workingWeek4Day5;
    }

    public String getWorkingWeek4Day6()
    {
        return workingWeek4Day6;
    }

    public void setWorkingWeek4Day6(String workingWeek4Day6)
    {
        this.workingWeek4Day6 = workingWeek4Day6;
    }

    public String getWorkingWeek4Day7()
    {
        return workingWeek4Day7;
    }

    public void setWorkingWeek4Day7(String workingWeek4Day7)
    {
        this.workingWeek4Day7 = workingWeek4Day7;
    }

    public String getWorkingWeek5Day1()
    {
        return workingWeek5Day1;
    }

    public void setWorkingWeek5Day1(String workingWeek5Day1)
    {
        this.workingWeek5Day1 = workingWeek5Day1;
    }

    public String getWorkingWeek5Day2()
    {
        return workingWeek5Day2;
    }

    public void setWorkingWeek5Day2(String workingWeek5Day2)
    {
        this.workingWeek5Day2 = workingWeek5Day2;
    }

    public String getWorkingWeek5Day3()
    {
        return workingWeek5Day3;
    }

    public void setWorkingWeek5Day3(String workingWeek5Day3)
    {
        this.workingWeek5Day3 = workingWeek5Day3;
    }

    public String getWorkingWeek5Day4()
    {
        return workingWeek5Day4;
    }

    public void setWorkingWeek5Day4(String workingWeek5Day4)
    {
        this.workingWeek5Day4 = workingWeek5Day4;
    }

    public String getWorkingWeek5Day5()
    {
        return workingWeek5Day5;
    }

    public void setWorkingWeek5Day5(String workingWeek5Day5)
    {
        this.workingWeek5Day5 = workingWeek5Day5;
    }

    public String getWorkingWeek5Day6()
    {
        return workingWeek5Day6;
    }

    public void setWorkingWeek5Day6(String workingWeek5Day6)
    {
        this.workingWeek5Day6 = workingWeek5Day6;
    }

    public String getWorkingWeek5Day7()
    {
        return workingWeek5Day7;
    }

    public void setWorkingWeek5Day7(String workingWeek5Day7)
    {
        this.workingWeek5Day7 = workingWeek5Day7;
    }

    public String getWorkingWeekApplDay1()
    {
        return workingWeekApplDay1;
    }

    public void setWorkingWeekApplDay1(String workingWeekApplDay1)
    {
        this.workingWeekApplDay1 = workingWeekApplDay1;
    }

    public String getWorkingWeekApplDay2()
    {
        return workingWeekApplDay2;
    }

    public void setWorkingWeekApplDay2(String workingWeekApplDay2)
    {
        this.workingWeekApplDay2 = workingWeekApplDay2;
    }

    public String getWorkingWeekApplDay3()
    {
        return workingWeekApplDay3;
    }

    public void setWorkingWeekApplDay3(String workingWeekApplDay3)
    {
        this.workingWeekApplDay3 = workingWeekApplDay3;
    }

    public String getWorkingWeekApplDay4()
    {
        return workingWeekApplDay4;
    }

    public void setWorkingWeekApplDay4(String workingWeekApplDay4)
    {
        this.workingWeekApplDay4 = workingWeekApplDay4;
    }

    public String getWorkingWeekApplDay5()
    {
        return workingWeekApplDay5;
    }

    public void setWorkingWeekApplDay5(String workingWeekApplDay5)
    {
        this.workingWeekApplDay5 = workingWeekApplDay5;
    }

    public String getWorkingWeekApplDay6()
    {
        return workingWeekApplDay6;
    }

    public void setWorkingWeekApplDay6(String workingWeekApplDay6)
    {
        this.workingWeekApplDay6 = workingWeekApplDay6;
    }

    public String getWorkingWeekApplDay7()
    {
        return workingWeekApplDay7;
    }

    public void setWorkingWeekApplDay7(String workingWeekApplDay7)
    {
        this.workingWeekApplDay7 = workingWeekApplDay7;
    }

    public String getSpecialistClinicYn()
    {
        return specialistClinicYn;
    }

    public void setSpecialistClinicYn(String specialistClinicYn)
    {
        this.specialistClinicYn = specialistClinicYn;
    }

    public String getVisitSpecialistClinicYn()
    {
        return visitSpecialistClinicYn;
    }

    public void setVisitSpecialistClinicYn(String visitSpecialistClinicYn)
    {
        this.visitSpecialistClinicYn = visitSpecialistClinicYn;
    }

    public String getQueueNumApplYn()
    {
        return queueNumApplYn;
    }

    public void setQueueNumApplYn(String queueNumApplYn)
    {
        this.queueNumApplYn = queueNumApplYn;
    }

    public String getQueueNumByPractYn()
    {
        return queueNumByPractYn;
    }

    public void setQueueNumByPractYn(String queueNumByPractYn)
    {
        this.queueNumByPractYn = queueNumByPractYn;
    }

    public String getQueueNumByRoomYn()
    {
        return queueNumByRoomYn;
    }

    public void setQueueNumByRoomYn(String queueNumByRoomYn)
    {
        this.queueNumByRoomYn = queueNumByRoomYn;
    }

    public String getQueueNumByOtherResYn()
    {
        return queueNumByOtherResYn;
    }

    public void setQueueNumByOtherResYn(String queueNumByOtherResYn)
    {
        this.queueNumByOtherResYn = queueNumByOtherResYn;
    }

    public String getQueueNumOtherResClass()
    {
        return queueNumOtherResClass;
    }

    public void setQueueNumOtherResClass(String queueNumOtherResClass)
    {
        this.queueNumOtherResClass = queueNumOtherResClass;
    }

    public String getQueueNumOtherResType()
    {
        return queueNumOtherResType;
    }

    public void setQueueNumOtherResType(String queueNumOtherResType)
    {
        this.queueNumOtherResType = queueNumOtherResType;
    }

    public Set getOaClinicScheduleDtls()
    {
        return oaClinicScheduleDtls;
    }

    public void setOaClinicScheduleDtls(Set oaClinicScheduleDtls)
    {
        this.oaClinicScheduleDtls = oaClinicScheduleDtls;
    }

    public Set getOaBlockAppts()
    {
        return oaBlockAppts;
    }

    public void setOaBlockAppts(Set oaBlockAppts)
    {
        this.oaBlockAppts = oaBlockAppts;
    }

    public Set getOpCurrentPatients()
    {
        return opCurrentPatients;
    }

    public void setOpCurrentPatients(Set opCurrentPatients)
    {
        this.opCurrentPatients = opCurrentPatients;
    }

    public Set getOaClinicSchedules()
    {
        return oaClinicSchedules;
    }

    public void setOaClinicSchedules(Set oaClinicSchedules)
    {
        this.oaClinicSchedules = oaClinicSchedules;
    }

    public Set getOaClinicScheduleValidities()
    {
        return oaClinicScheduleValidities;
    }

    public void setOaClinicScheduleValidities(Set oaClinicScheduleValidities)
    {
        this.oaClinicScheduleValidities = oaClinicScheduleValidities;
    }

    public Set getOpClinicForServices()
    {
        return opClinicForServices;
    }

    public void setOpClinicForServices(Set opClinicForServices)
    {
        this.opClinicForServices = opClinicForServices;
    }

    public Set getOaRosterForPracts()
    {
        return oaRosterForPracts;
    }

    public void setOaRosterForPracts(Set oaRosterForPracts)
    {
        this.oaRosterForPracts = oaRosterForPracts;
    }

    public Set getOpEpisodeForServices()
    {
        return opEpisodeForServices;
    }

    public void setOpEpisodeForServices(Set opEpisodeForServices)
    {
        this.opEpisodeForServices = opEpisodeForServices;
    }

    public Set getOaApptStatses()
    {
        return oaApptStatses;
    }

    public void setOaApptStatses(Set oaApptStatses)
    {
        this.oaApptStatses = oaApptStatses;
    }

    public Set getOaClinicBreaks()
    {
        return oaClinicBreaks;
    }

    public void setOaClinicBreaks(Set oaClinicBreaks)
    {
        this.oaClinicBreaks = oaClinicBreaks;
    }

    public Set getOaTransRecords()
    {
        return oaTransRecords;
    }

    public void setOaTransRecords(Set oaTransRecords)
    {
        this.oaTransRecords = oaTransRecords;
    }

    public Set getOaUserClinicRightses()
    {
        return oaUserClinicRightses;
    }

    public void setOaUserClinicRightses(Set oaUserClinicRightses)
    {
        this.oaUserClinicRightses = oaUserClinicRightses;
    }

    public Set getOpVisitTypeForClinics()
    {
        return opVisitTypeForClinics;
    }

    public void setOpVisitTypeForClinics(Set opVisitTypeForClinics)
    {
        this.opVisitTypeForClinics = opVisitTypeForClinics;
    }

    public Set getOpQueueNumForLocns()
    {
        return opQueueNumForLocns;
    }

    public void setOpQueueNumForLocns(Set opQueueNumForLocns)
    {
        this.opQueueNumForLocns = opQueueNumForLocns;
    }

    public Set getOaClinicScheduleBreaks()
    {
        return oaClinicScheduleBreaks;
    }

    public void setOaClinicScheduleBreaks(Set oaClinicScheduleBreaks)
    {
        this.oaClinicScheduleBreaks = oaClinicScheduleBreaks;
    }

    public Set getOpPractForClinics()
    {
        return opPractForClinics;
    }

    public void setOpPractForClinics(Set opPractForClinics)
    {
        this.opPractForClinics = opPractForClinics;
    }

    public Set getOaClinicTimeTables()
    {
        return oaClinicTimeTables;
    }

    public void setOaClinicTimeTables(Set oaClinicTimeTables)
    {
        this.oaClinicTimeTables = oaClinicTimeTables;
    }

    public Set getOaBlockApptDtls()
    {
        return oaBlockApptDtls;
    }

    public void setOaBlockApptDtls(Set oaBlockApptDtls)
    {
        this.oaBlockApptDtls = oaBlockApptDtls;
    }

    public Set getOpPatientQueues()
    {
        return opPatientQueues;
    }

    public void setOpPatientQueues(Set opPatientQueues)
    {
        this.opPatientQueues = opPatientQueues;
    }

    public Set getOaApptDelTrs()
    {
        return oaApptDelTrs;
    }

    public void setOaApptDelTrs(Set oaApptDelTrs)
    {
        this.oaApptDelTrs = oaApptDelTrs;
    }

    public Set getOaAppts()
    {
        return oaAppts;
    }

    public void setOaAppts(Set oaAppts)
    {
        this.oaAppts = oaAppts;
    }

    public Set getOpPatientQueueSumms()
    {
        return opPatientQueueSumms;
    }

    public void setOpPatientQueueSumms(Set opPatientQueueSumms)
    {
        this.opPatientQueueSumms = opPatientQueueSumms;
    }

    private OpClinicId id;
    private String clinicType;
    private String longDesc;
    private String shortDesc;
    private String workingDay1;
    private String workingDay2;
    private String workingDay3;
    private String workingDay4;
    private String workingDay5;
    private String workingDay6;
    private String workingDay7;
    private String mrLocationCode;
    private String mrSectionType;
    private String mrSectionCode;
    private String onlineMrNotfnYn;
    private String ageGroupCode;
    private String levelOfCareInd;
    private String specialityCode;
    private String deptCode;
    private String serviceCode;
    private String practType;
    private String openToAllPractYn;
    private String identAtCheckin;
    private String allowApptYn;
    private String allowVisitRegnYn;
    private String allowUnassignInPractqYn;
    private String recordVitalSignsYn;
    private String recordImmuYn;
    private String recordOutcomeYn;
    private String fiVisitTypeApplYn;
    private String fuVisitTypeApplYn;
    private String rtVisitTypeApplYn;
    private String srVisitTypeApplYn;
    private String csVisitTypeApplYn;
    private String emVisitTypeApplYn;
    private String vitalSignsBatteryId;
    private String alcnCriteria;
    private String dispInCaQueueAfter;
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
    private String allowWalkInYn;
    private String allowReferralYn;
    private String allowNonReferralYn;
    private Date baseSlotSlabTime;
    private String careLocnTypeInd;
    private String dcApplYn;
    private String dfltFileTypeCode;
    private String emApplYn;
    private String ipApplYn;
    private String opApplYn;
    private String primaryResourceClass;
    private String sectionCode;
    private Date workingDayEndTime;
    private Date workingDayStartTime;
    private String workingWeek1Day1;
    private String workingWeek1Day2;
    private String workingWeek1Day3;
    private String workingWeek1Day4;
    private String workingWeek1Day5;
    private String workingWeek1Day6;
    private String workingWeek1Day7;
    private String workingWeek2Day1;
    private String workingWeek2Day2;
    private String workingWeek2Day3;
    private String workingWeek2Day4;
    private String workingWeek2Day5;
    private String workingWeek2Day6;
    private String workingWeek2Day7;
    private String workingWeek3Day1;
    private String workingWeek3Day2;
    private String workingWeek3Day3;
    private String workingWeek3Day4;
    private String workingWeek3Day5;
    private String workingWeek3Day6;
    private String workingWeek3Day7;
    private String workingWeek4Day1;
    private String workingWeek4Day2;
    private String workingWeek4Day3;
    private String workingWeek4Day4;
    private String workingWeek4Day5;
    private String workingWeek4Day6;
    private String workingWeek4Day7;
    private String workingWeek5Day1;
    private String workingWeek5Day2;
    private String workingWeek5Day3;
    private String workingWeek5Day4;
    private String workingWeek5Day5;
    private String workingWeek5Day6;
    private String workingWeek5Day7;
    private String workingWeekApplDay1;
    private String workingWeekApplDay2;
    private String workingWeekApplDay3;
    private String workingWeekApplDay4;
    private String workingWeekApplDay5;
    private String workingWeekApplDay6;
    private String workingWeekApplDay7;
    private String specialistClinicYn;
    private String visitSpecialistClinicYn;
    private String queueNumApplYn;
    private String queueNumByPractYn;
    private String queueNumByRoomYn;
    private String queueNumByOtherResYn;
    private String queueNumOtherResClass;
    private String queueNumOtherResType;
    private Set oaClinicScheduleDtls;
    private Set oaBlockAppts;
    private Set opCurrentPatients;
    private Set oaClinicSchedules;
    private Set oaClinicScheduleValidities;
    private Set opClinicForServices;
    private Set oaRosterForPracts;
    private Set opEpisodeForServices;
    private Set oaApptStatses;
    private Set oaClinicBreaks;
    private Set oaTransRecords;
    private Set oaUserClinicRightses;
    private Set opVisitTypeForClinics;
    private Set opQueueNumForLocns;
    private Set oaClinicScheduleBreaks;
    private Set opPractForClinics;
    private Set oaClinicTimeTables;
    private Set oaBlockApptDtls;
    private Set opPatientQueues;
    private Set oaApptDelTrs;
    private Set oaAppts;
    private Set opPatientQueueSumms;
}
