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
import java.util.Date;

public class OpClinicLangVwId
    implements Serializable
{

    public OpClinicLangVwId()
    {
    }

    public OpClinicLangVwId(String facilityId, String clinicCode, String languageId, String workingWeekApplDay1, String workingWeek1Day1, String workingWeek2Day1, String workingWeek3Day1, 
            String workingWeek4Day1, String workingWeek5Day1, String workingWeekApplDay2, String workingWeek1Day2, String workingWeek2Day2, String workingWeek3Day2, String workingWeek4Day2, 
            String workingWeek5Day2, String workingWeekApplDay3, String workingWeek1Day3, String workingWeek2Day3, String workingWeek3Day3, String workingWeek4Day3, String workingWeek5Day3, 
            String workingWeekApplDay4, String workingWeek1Day4, String workingWeek2Day4, String workingWeek3Day4, String workingWeek4Day4, String workingWeek5Day4, String workingWeekApplDay5, 
            String workingWeek1Day5, String workingWeek2Day5, String workingWeek3Day5, String workingWeek4Day5, String workingWeek5Day5, String workingWeekApplDay6, String workingWeek1Day6, 
            String workingWeek2Day6, String workingWeek3Day6, String workingWeek4Day6, String workingWeek5Day6, String workingWeekApplDay7, String workingWeek1Day7, String workingWeek2Day7, 
            String workingWeek3Day7, String workingWeek4Day7, String workingWeek5Day7, String onlineMrNotfnYn, String levelOfCareInd, String specialityCode, String openToAllPractYn, 
            String identAtCheckin, String allowApptYn, String allowVisitRegnYn, String allowWalkInYn, String allowReferralYn, String allowNonReferralYn, String recordVitalSignsYn, 
            String recordImmuYn, String recordOutcomeYn, String fiVisitTypeApplYn, String fuVisitTypeApplYn, String rtVisitTypeApplYn, String srVisitTypeApplYn, String csVisitTypeApplYn, 
            String emVisitTypeApplYn, String opApplYn, String dcApplYn, String ipApplYn, String emApplYn, String effStatus, String visitSpecialistClinicYn, 
            String queueNumApplYn, String queueNumByPractYn, String queueNumByRoomYn, String queueNumByOtherResYn, String addedById, Date addedDate, String addedAtWsNo, 
            String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId)
    {
        this.facilityId = facilityId;
        this.clinicCode = clinicCode;
        this.languageId = languageId;
        this.workingWeekApplDay1 = workingWeekApplDay1;
        this.workingWeek1Day1 = workingWeek1Day1;
        this.workingWeek2Day1 = workingWeek2Day1;
        this.workingWeek3Day1 = workingWeek3Day1;
        this.workingWeek4Day1 = workingWeek4Day1;
        this.workingWeek5Day1 = workingWeek5Day1;
        this.workingWeekApplDay2 = workingWeekApplDay2;
        this.workingWeek1Day2 = workingWeek1Day2;
        this.workingWeek2Day2 = workingWeek2Day2;
        this.workingWeek3Day2 = workingWeek3Day2;
        this.workingWeek4Day2 = workingWeek4Day2;
        this.workingWeek5Day2 = workingWeek5Day2;
        this.workingWeekApplDay3 = workingWeekApplDay3;
        this.workingWeek1Day3 = workingWeek1Day3;
        this.workingWeek2Day3 = workingWeek2Day3;
        this.workingWeek3Day3 = workingWeek3Day3;
        this.workingWeek4Day3 = workingWeek4Day3;
        this.workingWeek5Day3 = workingWeek5Day3;
        this.workingWeekApplDay4 = workingWeekApplDay4;
        this.workingWeek1Day4 = workingWeek1Day4;
        this.workingWeek2Day4 = workingWeek2Day4;
        this.workingWeek3Day4 = workingWeek3Day4;
        this.workingWeek4Day4 = workingWeek4Day4;
        this.workingWeek5Day4 = workingWeek5Day4;
        this.workingWeekApplDay5 = workingWeekApplDay5;
        this.workingWeek1Day5 = workingWeek1Day5;
        this.workingWeek2Day5 = workingWeek2Day5;
        this.workingWeek3Day5 = workingWeek3Day5;
        this.workingWeek4Day5 = workingWeek4Day5;
        this.workingWeek5Day5 = workingWeek5Day5;
        this.workingWeekApplDay6 = workingWeekApplDay6;
        this.workingWeek1Day6 = workingWeek1Day6;
        this.workingWeek2Day6 = workingWeek2Day6;
        this.workingWeek3Day6 = workingWeek3Day6;
        this.workingWeek4Day6 = workingWeek4Day6;
        this.workingWeek5Day6 = workingWeek5Day6;
        this.workingWeekApplDay7 = workingWeekApplDay7;
        this.workingWeek1Day7 = workingWeek1Day7;
        this.workingWeek2Day7 = workingWeek2Day7;
        this.workingWeek3Day7 = workingWeek3Day7;
        this.workingWeek4Day7 = workingWeek4Day7;
        this.workingWeek5Day7 = workingWeek5Day7;
        this.onlineMrNotfnYn = onlineMrNotfnYn;
        this.levelOfCareInd = levelOfCareInd;
        this.specialityCode = specialityCode;
        this.openToAllPractYn = openToAllPractYn;
        this.identAtCheckin = identAtCheckin;
        this.allowApptYn = allowApptYn;
        this.allowVisitRegnYn = allowVisitRegnYn;
        this.allowWalkInYn = allowWalkInYn;
        this.allowReferralYn = allowReferralYn;
        this.allowNonReferralYn = allowNonReferralYn;
        this.recordVitalSignsYn = recordVitalSignsYn;
        this.recordImmuYn = recordImmuYn;
        this.recordOutcomeYn = recordOutcomeYn;
        this.fiVisitTypeApplYn = fiVisitTypeApplYn;
        this.fuVisitTypeApplYn = fuVisitTypeApplYn;
        this.rtVisitTypeApplYn = rtVisitTypeApplYn;
        this.srVisitTypeApplYn = srVisitTypeApplYn;
        this.csVisitTypeApplYn = csVisitTypeApplYn;
        this.emVisitTypeApplYn = emVisitTypeApplYn;
        this.opApplYn = opApplYn;
        this.dcApplYn = dcApplYn;
        this.ipApplYn = ipApplYn;
        this.emApplYn = emApplYn;
        this.effStatus = effStatus;
        this.visitSpecialistClinicYn = visitSpecialistClinicYn;
        this.queueNumApplYn = queueNumApplYn;
        this.queueNumByPractYn = queueNumByPractYn;
        this.queueNumByRoomYn = queueNumByRoomYn;
        this.queueNumByOtherResYn = queueNumByOtherResYn;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
    }

    public OpClinicLangVwId(String facilityId, String clinicCode, String languageId, Long ordby, String longDesc, String shortDesc, String careLocnTypeInd, 
            String clinicType, String specialistClinicYn, String workingDay1, String workingDay2, String workingDay3, String workingDay4, String workingDay5, 
            String workingDay6, String workingDay7, String workingWeekApplDay1, String workingWeek1Day1, String workingWeek2Day1, String workingWeek3Day1, String workingWeek4Day1, 
            String workingWeek5Day1, String workingWeekApplDay2, String workingWeek1Day2, String workingWeek2Day2, String workingWeek3Day2, String workingWeek4Day2, String workingWeek5Day2, 
            String workingWeekApplDay3, String workingWeek1Day3, String workingWeek2Day3, String workingWeek3Day3, String workingWeek4Day3, String workingWeek5Day3, String workingWeekApplDay4, 
            String workingWeek1Day4, String workingWeek2Day4, String workingWeek3Day4, String workingWeek4Day4, String workingWeek5Day4, String workingWeekApplDay5, String workingWeek1Day5, 
            String workingWeek2Day5, String workingWeek3Day5, String workingWeek4Day5, String workingWeek5Day5, String workingWeekApplDay6, String workingWeek1Day6, String workingWeek2Day6, 
            String workingWeek3Day6, String workingWeek4Day6, String workingWeek5Day6, String workingWeekApplDay7, String workingWeek1Day7, String workingWeek2Day7, String workingWeek3Day7, 
            String workingWeek4Day7, String workingWeek5Day7, Date workingDayStartTime, Date workingDayEndTime, Date baseSlotSlabTime, String primaryResourceClass, String mrLocationCode, 
            String mrSectionType, String mrSectionCode, String onlineMrNotfnYn, String ageGroupCode, String levelOfCareInd, String specialityCode, String deptCode, 
            String sectionCode, String serviceCode, String practType, String openToAllPractYn, String identAtCheckin, String allowApptYn, String allowVisitRegnYn, 
            String allowWalkInYn, String allowReferralYn, String allowNonReferralYn, String allowUnassignInPractqYn, String recordVitalSignsYn, String recordImmuYn, String recordOutcomeYn, 
            String fiVisitTypeApplYn, String fuVisitTypeApplYn, String rtVisitTypeApplYn, String srVisitTypeApplYn, String csVisitTypeApplYn, String emVisitTypeApplYn, String opApplYn, 
            String dcApplYn, String ipApplYn, String emApplYn, String vitalSignsBatteryId, String alcnCriteria, String dispInCaQueueAfter, String dfltFileTypeCode, 
            Date effDateFrom, Date effDateTo, String effStatus, String visitSpecialistClinicYn, String queueNumApplYn, String queueNumByPractYn, String queueNumByRoomYn, 
            String queueNumByOtherResYn, String queueNumOtherResClass, String queueNumOtherResType, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, 
            String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId)
    {
        this.facilityId = facilityId;
        this.clinicCode = clinicCode;
        this.languageId = languageId;
        this.ordby = ordby;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.careLocnTypeInd = careLocnTypeInd;
        this.clinicType = clinicType;
        this.specialistClinicYn = specialistClinicYn;
        this.workingDay1 = workingDay1;
        this.workingDay2 = workingDay2;
        this.workingDay3 = workingDay3;
        this.workingDay4 = workingDay4;
        this.workingDay5 = workingDay5;
        this.workingDay6 = workingDay6;
        this.workingDay7 = workingDay7;
        this.workingWeekApplDay1 = workingWeekApplDay1;
        this.workingWeek1Day1 = workingWeek1Day1;
        this.workingWeek2Day1 = workingWeek2Day1;
        this.workingWeek3Day1 = workingWeek3Day1;
        this.workingWeek4Day1 = workingWeek4Day1;
        this.workingWeek5Day1 = workingWeek5Day1;
        this.workingWeekApplDay2 = workingWeekApplDay2;
        this.workingWeek1Day2 = workingWeek1Day2;
        this.workingWeek2Day2 = workingWeek2Day2;
        this.workingWeek3Day2 = workingWeek3Day2;
        this.workingWeek4Day2 = workingWeek4Day2;
        this.workingWeek5Day2 = workingWeek5Day2;
        this.workingWeekApplDay3 = workingWeekApplDay3;
        this.workingWeek1Day3 = workingWeek1Day3;
        this.workingWeek2Day3 = workingWeek2Day3;
        this.workingWeek3Day3 = workingWeek3Day3;
        this.workingWeek4Day3 = workingWeek4Day3;
        this.workingWeek5Day3 = workingWeek5Day3;
        this.workingWeekApplDay4 = workingWeekApplDay4;
        this.workingWeek1Day4 = workingWeek1Day4;
        this.workingWeek2Day4 = workingWeek2Day4;
        this.workingWeek3Day4 = workingWeek3Day4;
        this.workingWeek4Day4 = workingWeek4Day4;
        this.workingWeek5Day4 = workingWeek5Day4;
        this.workingWeekApplDay5 = workingWeekApplDay5;
        this.workingWeek1Day5 = workingWeek1Day5;
        this.workingWeek2Day5 = workingWeek2Day5;
        this.workingWeek3Day5 = workingWeek3Day5;
        this.workingWeek4Day5 = workingWeek4Day5;
        this.workingWeek5Day5 = workingWeek5Day5;
        this.workingWeekApplDay6 = workingWeekApplDay6;
        this.workingWeek1Day6 = workingWeek1Day6;
        this.workingWeek2Day6 = workingWeek2Day6;
        this.workingWeek3Day6 = workingWeek3Day6;
        this.workingWeek4Day6 = workingWeek4Day6;
        this.workingWeek5Day6 = workingWeek5Day6;
        this.workingWeekApplDay7 = workingWeekApplDay7;
        this.workingWeek1Day7 = workingWeek1Day7;
        this.workingWeek2Day7 = workingWeek2Day7;
        this.workingWeek3Day7 = workingWeek3Day7;
        this.workingWeek4Day7 = workingWeek4Day7;
        this.workingWeek5Day7 = workingWeek5Day7;
        this.workingDayStartTime = workingDayStartTime;
        this.workingDayEndTime = workingDayEndTime;
        this.baseSlotSlabTime = baseSlotSlabTime;
        this.primaryResourceClass = primaryResourceClass;
        this.mrLocationCode = mrLocationCode;
        this.mrSectionType = mrSectionType;
        this.mrSectionCode = mrSectionCode;
        this.onlineMrNotfnYn = onlineMrNotfnYn;
        this.ageGroupCode = ageGroupCode;
        this.levelOfCareInd = levelOfCareInd;
        this.specialityCode = specialityCode;
        this.deptCode = deptCode;
        this.sectionCode = sectionCode;
        this.serviceCode = serviceCode;
        this.practType = practType;
        this.openToAllPractYn = openToAllPractYn;
        this.identAtCheckin = identAtCheckin;
        this.allowApptYn = allowApptYn;
        this.allowVisitRegnYn = allowVisitRegnYn;
        this.allowWalkInYn = allowWalkInYn;
        this.allowReferralYn = allowReferralYn;
        this.allowNonReferralYn = allowNonReferralYn;
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
        this.opApplYn = opApplYn;
        this.dcApplYn = dcApplYn;
        this.ipApplYn = ipApplYn;
        this.emApplYn = emApplYn;
        this.vitalSignsBatteryId = vitalSignsBatteryId;
        this.alcnCriteria = alcnCriteria;
        this.dispInCaQueueAfter = dispInCaQueueAfter;
        this.dfltFileTypeCode = dfltFileTypeCode;
        this.effDateFrom = effDateFrom;
        this.effDateTo = effDateTo;
        this.effStatus = effStatus;
        this.visitSpecialistClinicYn = visitSpecialistClinicYn;
        this.queueNumApplYn = queueNumApplYn;
        this.queueNumByPractYn = queueNumByPractYn;
        this.queueNumByRoomYn = queueNumByRoomYn;
        this.queueNumByOtherResYn = queueNumByOtherResYn;
        this.queueNumOtherResClass = queueNumOtherResClass;
        this.queueNumOtherResType = queueNumOtherResType;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
    }

    public String getFacilityId()
    {
        return facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    public String getClinicCode()
    {
        return clinicCode;
    }

    public void setClinicCode(String clinicCode)
    {
        this.clinicCode = clinicCode;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public Long getOrdby()
    {
        return ordby;
    }

    public void setOrdby(Long ordby)
    {
        this.ordby = ordby;
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

    public String getCareLocnTypeInd()
    {
        return careLocnTypeInd;
    }

    public void setCareLocnTypeInd(String careLocnTypeInd)
    {
        this.careLocnTypeInd = careLocnTypeInd;
    }

    public String getClinicType()
    {
        return clinicType;
    }

    public void setClinicType(String clinicType)
    {
        this.clinicType = clinicType;
    }

    public String getSpecialistClinicYn()
    {
        return specialistClinicYn;
    }

    public void setSpecialistClinicYn(String specialistClinicYn)
    {
        this.specialistClinicYn = specialistClinicYn;
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

    public String getWorkingWeekApplDay1()
    {
        return workingWeekApplDay1;
    }

    public void setWorkingWeekApplDay1(String workingWeekApplDay1)
    {
        this.workingWeekApplDay1 = workingWeekApplDay1;
    }

    public String getWorkingWeek1Day1()
    {
        return workingWeek1Day1;
    }

    public void setWorkingWeek1Day1(String workingWeek1Day1)
    {
        this.workingWeek1Day1 = workingWeek1Day1;
    }

    public String getWorkingWeek2Day1()
    {
        return workingWeek2Day1;
    }

    public void setWorkingWeek2Day1(String workingWeek2Day1)
    {
        this.workingWeek2Day1 = workingWeek2Day1;
    }

    public String getWorkingWeek3Day1()
    {
        return workingWeek3Day1;
    }

    public void setWorkingWeek3Day1(String workingWeek3Day1)
    {
        this.workingWeek3Day1 = workingWeek3Day1;
    }

    public String getWorkingWeek4Day1()
    {
        return workingWeek4Day1;
    }

    public void setWorkingWeek4Day1(String workingWeek4Day1)
    {
        this.workingWeek4Day1 = workingWeek4Day1;
    }

    public String getWorkingWeek5Day1()
    {
        return workingWeek5Day1;
    }

    public void setWorkingWeek5Day1(String workingWeek5Day1)
    {
        this.workingWeek5Day1 = workingWeek5Day1;
    }

    public String getWorkingWeekApplDay2()
    {
        return workingWeekApplDay2;
    }

    public void setWorkingWeekApplDay2(String workingWeekApplDay2)
    {
        this.workingWeekApplDay2 = workingWeekApplDay2;
    }

    public String getWorkingWeek1Day2()
    {
        return workingWeek1Day2;
    }

    public void setWorkingWeek1Day2(String workingWeek1Day2)
    {
        this.workingWeek1Day2 = workingWeek1Day2;
    }

    public String getWorkingWeek2Day2()
    {
        return workingWeek2Day2;
    }

    public void setWorkingWeek2Day2(String workingWeek2Day2)
    {
        this.workingWeek2Day2 = workingWeek2Day2;
    }

    public String getWorkingWeek3Day2()
    {
        return workingWeek3Day2;
    }

    public void setWorkingWeek3Day2(String workingWeek3Day2)
    {
        this.workingWeek3Day2 = workingWeek3Day2;
    }

    public String getWorkingWeek4Day2()
    {
        return workingWeek4Day2;
    }

    public void setWorkingWeek4Day2(String workingWeek4Day2)
    {
        this.workingWeek4Day2 = workingWeek4Day2;
    }

    public String getWorkingWeek5Day2()
    {
        return workingWeek5Day2;
    }

    public void setWorkingWeek5Day2(String workingWeek5Day2)
    {
        this.workingWeek5Day2 = workingWeek5Day2;
    }

    public String getWorkingWeekApplDay3()
    {
        return workingWeekApplDay3;
    }

    public void setWorkingWeekApplDay3(String workingWeekApplDay3)
    {
        this.workingWeekApplDay3 = workingWeekApplDay3;
    }

    public String getWorkingWeek1Day3()
    {
        return workingWeek1Day3;
    }

    public void setWorkingWeek1Day3(String workingWeek1Day3)
    {
        this.workingWeek1Day3 = workingWeek1Day3;
    }

    public String getWorkingWeek2Day3()
    {
        return workingWeek2Day3;
    }

    public void setWorkingWeek2Day3(String workingWeek2Day3)
    {
        this.workingWeek2Day3 = workingWeek2Day3;
    }

    public String getWorkingWeek3Day3()
    {
        return workingWeek3Day3;
    }

    public void setWorkingWeek3Day3(String workingWeek3Day3)
    {
        this.workingWeek3Day3 = workingWeek3Day3;
    }

    public String getWorkingWeek4Day3()
    {
        return workingWeek4Day3;
    }

    public void setWorkingWeek4Day3(String workingWeek4Day3)
    {
        this.workingWeek4Day3 = workingWeek4Day3;
    }

    public String getWorkingWeek5Day3()
    {
        return workingWeek5Day3;
    }

    public void setWorkingWeek5Day3(String workingWeek5Day3)
    {
        this.workingWeek5Day3 = workingWeek5Day3;
    }

    public String getWorkingWeekApplDay4()
    {
        return workingWeekApplDay4;
    }

    public void setWorkingWeekApplDay4(String workingWeekApplDay4)
    {
        this.workingWeekApplDay4 = workingWeekApplDay4;
    }

    public String getWorkingWeek1Day4()
    {
        return workingWeek1Day4;
    }

    public void setWorkingWeek1Day4(String workingWeek1Day4)
    {
        this.workingWeek1Day4 = workingWeek1Day4;
    }

    public String getWorkingWeek2Day4()
    {
        return workingWeek2Day4;
    }

    public void setWorkingWeek2Day4(String workingWeek2Day4)
    {
        this.workingWeek2Day4 = workingWeek2Day4;
    }

    public String getWorkingWeek3Day4()
    {
        return workingWeek3Day4;
    }

    public void setWorkingWeek3Day4(String workingWeek3Day4)
    {
        this.workingWeek3Day4 = workingWeek3Day4;
    }

    public String getWorkingWeek4Day4()
    {
        return workingWeek4Day4;
    }

    public void setWorkingWeek4Day4(String workingWeek4Day4)
    {
        this.workingWeek4Day4 = workingWeek4Day4;
    }

    public String getWorkingWeek5Day4()
    {
        return workingWeek5Day4;
    }

    public void setWorkingWeek5Day4(String workingWeek5Day4)
    {
        this.workingWeek5Day4 = workingWeek5Day4;
    }

    public String getWorkingWeekApplDay5()
    {
        return workingWeekApplDay5;
    }

    public void setWorkingWeekApplDay5(String workingWeekApplDay5)
    {
        this.workingWeekApplDay5 = workingWeekApplDay5;
    }

    public String getWorkingWeek1Day5()
    {
        return workingWeek1Day5;
    }

    public void setWorkingWeek1Day5(String workingWeek1Day5)
    {
        this.workingWeek1Day5 = workingWeek1Day5;
    }

    public String getWorkingWeek2Day5()
    {
        return workingWeek2Day5;
    }

    public void setWorkingWeek2Day5(String workingWeek2Day5)
    {
        this.workingWeek2Day5 = workingWeek2Day5;
    }

    public String getWorkingWeek3Day5()
    {
        return workingWeek3Day5;
    }

    public void setWorkingWeek3Day5(String workingWeek3Day5)
    {
        this.workingWeek3Day5 = workingWeek3Day5;
    }

    public String getWorkingWeek4Day5()
    {
        return workingWeek4Day5;
    }

    public void setWorkingWeek4Day5(String workingWeek4Day5)
    {
        this.workingWeek4Day5 = workingWeek4Day5;
    }

    public String getWorkingWeek5Day5()
    {
        return workingWeek5Day5;
    }

    public void setWorkingWeek5Day5(String workingWeek5Day5)
    {
        this.workingWeek5Day5 = workingWeek5Day5;
    }

    public String getWorkingWeekApplDay6()
    {
        return workingWeekApplDay6;
    }

    public void setWorkingWeekApplDay6(String workingWeekApplDay6)
    {
        this.workingWeekApplDay6 = workingWeekApplDay6;
    }

    public String getWorkingWeek1Day6()
    {
        return workingWeek1Day6;
    }

    public void setWorkingWeek1Day6(String workingWeek1Day6)
    {
        this.workingWeek1Day6 = workingWeek1Day6;
    }

    public String getWorkingWeek2Day6()
    {
        return workingWeek2Day6;
    }

    public void setWorkingWeek2Day6(String workingWeek2Day6)
    {
        this.workingWeek2Day6 = workingWeek2Day6;
    }

    public String getWorkingWeek3Day6()
    {
        return workingWeek3Day6;
    }

    public void setWorkingWeek3Day6(String workingWeek3Day6)
    {
        this.workingWeek3Day6 = workingWeek3Day6;
    }

    public String getWorkingWeek4Day6()
    {
        return workingWeek4Day6;
    }

    public void setWorkingWeek4Day6(String workingWeek4Day6)
    {
        this.workingWeek4Day6 = workingWeek4Day6;
    }

    public String getWorkingWeek5Day6()
    {
        return workingWeek5Day6;
    }

    public void setWorkingWeek5Day6(String workingWeek5Day6)
    {
        this.workingWeek5Day6 = workingWeek5Day6;
    }

    public String getWorkingWeekApplDay7()
    {
        return workingWeekApplDay7;
    }

    public void setWorkingWeekApplDay7(String workingWeekApplDay7)
    {
        this.workingWeekApplDay7 = workingWeekApplDay7;
    }

    public String getWorkingWeek1Day7()
    {
        return workingWeek1Day7;
    }

    public void setWorkingWeek1Day7(String workingWeek1Day7)
    {
        this.workingWeek1Day7 = workingWeek1Day7;
    }

    public String getWorkingWeek2Day7()
    {
        return workingWeek2Day7;
    }

    public void setWorkingWeek2Day7(String workingWeek2Day7)
    {
        this.workingWeek2Day7 = workingWeek2Day7;
    }

    public String getWorkingWeek3Day7()
    {
        return workingWeek3Day7;
    }

    public void setWorkingWeek3Day7(String workingWeek3Day7)
    {
        this.workingWeek3Day7 = workingWeek3Day7;
    }

    public String getWorkingWeek4Day7()
    {
        return workingWeek4Day7;
    }

    public void setWorkingWeek4Day7(String workingWeek4Day7)
    {
        this.workingWeek4Day7 = workingWeek4Day7;
    }

    public String getWorkingWeek5Day7()
    {
        return workingWeek5Day7;
    }

    public void setWorkingWeek5Day7(String workingWeek5Day7)
    {
        this.workingWeek5Day7 = workingWeek5Day7;
    }

    public Date getWorkingDayStartTime()
    {
        return workingDayStartTime;
    }

    public void setWorkingDayStartTime(Date workingDayStartTime)
    {
        this.workingDayStartTime = workingDayStartTime;
    }

    public Date getWorkingDayEndTime()
    {
        return workingDayEndTime;
    }

    public void setWorkingDayEndTime(Date workingDayEndTime)
    {
        this.workingDayEndTime = workingDayEndTime;
    }

    public Date getBaseSlotSlabTime()
    {
        return baseSlotSlabTime;
    }

    public void setBaseSlotSlabTime(Date baseSlotSlabTime)
    {
        this.baseSlotSlabTime = baseSlotSlabTime;
    }

    public String getPrimaryResourceClass()
    {
        return primaryResourceClass;
    }

    public void setPrimaryResourceClass(String primaryResourceClass)
    {
        this.primaryResourceClass = primaryResourceClass;
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

    public String getSectionCode()
    {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode)
    {
        this.sectionCode = sectionCode;
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

    public String getOpApplYn()
    {
        return opApplYn;
    }

    public void setOpApplYn(String opApplYn)
    {
        this.opApplYn = opApplYn;
    }

    public String getDcApplYn()
    {
        return dcApplYn;
    }

    public void setDcApplYn(String dcApplYn)
    {
        this.dcApplYn = dcApplYn;
    }

    public String getIpApplYn()
    {
        return ipApplYn;
    }

    public void setIpApplYn(String ipApplYn)
    {
        this.ipApplYn = ipApplYn;
    }

    public String getEmApplYn()
    {
        return emApplYn;
    }

    public void setEmApplYn(String emApplYn)
    {
        this.emApplYn = emApplYn;
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

    public String getDfltFileTypeCode()
    {
        return dfltFileTypeCode;
    }

    public void setDfltFileTypeCode(String dfltFileTypeCode)
    {
        this.dfltFileTypeCode = dfltFileTypeCode;
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

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof OpClinicLangVwId))
            return false;
        OpClinicLangVwId castOther = (OpClinicLangVwId)other;
        return (getFacilityId() == castOther.getFacilityId() || getFacilityId() != null && castOther.getFacilityId() != null && getFacilityId().equals(castOther.getFacilityId())) && (getClinicCode() == castOther.getClinicCode() || getClinicCode() != null && castOther.getClinicCode() != null && getClinicCode().equals(castOther.getClinicCode())) && (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getOrdby() == castOther.getOrdby() || getOrdby() != null && castOther.getOrdby() != null && getOrdby().equals(castOther.getOrdby())) && (getLongDesc() == castOther.getLongDesc() || getLongDesc() != null && castOther.getLongDesc() != null && getLongDesc().equals(castOther.getLongDesc())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getCareLocnTypeInd() == castOther.getCareLocnTypeInd() || getCareLocnTypeInd() != null && castOther.getCareLocnTypeInd() != null && getCareLocnTypeInd().equals(castOther.getCareLocnTypeInd())) && (getClinicType() == castOther.getClinicType() || getClinicType() != null && castOther.getClinicType() != null && getClinicType().equals(castOther.getClinicType())) && (getSpecialistClinicYn() == castOther.getSpecialistClinicYn() || getSpecialistClinicYn() != null && castOther.getSpecialistClinicYn() != null && getSpecialistClinicYn().equals(castOther.getSpecialistClinicYn())) && (getWorkingDay1() == castOther.getWorkingDay1() || getWorkingDay1() != null && castOther.getWorkingDay1() != null && getWorkingDay1().equals(castOther.getWorkingDay1())) && (getWorkingDay2() == castOther.getWorkingDay2() || getWorkingDay2() != null && castOther.getWorkingDay2() != null && getWorkingDay2().equals(castOther.getWorkingDay2())) && (getWorkingDay3() == castOther.getWorkingDay3() || getWorkingDay3() != null && castOther.getWorkingDay3() != null && getWorkingDay3().equals(castOther.getWorkingDay3())) && (getWorkingDay4() == castOther.getWorkingDay4() || getWorkingDay4() != null && castOther.getWorkingDay4() != null && getWorkingDay4().equals(castOther.getWorkingDay4())) && (getWorkingDay5() == castOther.getWorkingDay5() || getWorkingDay5() != null && castOther.getWorkingDay5() != null && getWorkingDay5().equals(castOther.getWorkingDay5())) && (getWorkingDay6() == castOther.getWorkingDay6() || getWorkingDay6() != null && castOther.getWorkingDay6() != null && getWorkingDay6().equals(castOther.getWorkingDay6())) && (getWorkingDay7() == castOther.getWorkingDay7() || getWorkingDay7() != null && castOther.getWorkingDay7() != null && getWorkingDay7().equals(castOther.getWorkingDay7())) && (getWorkingWeekApplDay1() == castOther.getWorkingWeekApplDay1() || getWorkingWeekApplDay1() != null && castOther.getWorkingWeekApplDay1() != null && getWorkingWeekApplDay1().equals(castOther.getWorkingWeekApplDay1())) && (getWorkingWeek1Day1() == castOther.getWorkingWeek1Day1() || getWorkingWeek1Day1() != null && castOther.getWorkingWeek1Day1() != null && getWorkingWeek1Day1().equals(castOther.getWorkingWeek1Day1())) && (getWorkingWeek2Day1() == castOther.getWorkingWeek2Day1() || getWorkingWeek2Day1() != null && castOther.getWorkingWeek2Day1() != null && getWorkingWeek2Day1().equals(castOther.getWorkingWeek2Day1())) && (getWorkingWeek3Day1() == castOther.getWorkingWeek3Day1() || getWorkingWeek3Day1() != null && castOther.getWorkingWeek3Day1() != null && getWorkingWeek3Day1().equals(castOther.getWorkingWeek3Day1())) && (getWorkingWeek4Day1() == castOther.getWorkingWeek4Day1() || getWorkingWeek4Day1() != null && castOther.getWorkingWeek4Day1() != null && getWorkingWeek4Day1().equals(castOther.getWorkingWeek4Day1())) && (getWorkingWeek5Day1() == castOther.getWorkingWeek5Day1() || getWorkingWeek5Day1() != null && castOther.getWorkingWeek5Day1() != null && getWorkingWeek5Day1().equals(castOther.getWorkingWeek5Day1())) && (getWorkingWeekApplDay2() == castOther.getWorkingWeekApplDay2() || getWorkingWeekApplDay2() != null && castOther.getWorkingWeekApplDay2() != null && getWorkingWeekApplDay2().equals(castOther.getWorkingWeekApplDay2())) && (getWorkingWeek1Day2() == castOther.getWorkingWeek1Day2() || getWorkingWeek1Day2() != null && castOther.getWorkingWeek1Day2() != null && getWorkingWeek1Day2().equals(castOther.getWorkingWeek1Day2())) && (getWorkingWeek2Day2() == castOther.getWorkingWeek2Day2() || getWorkingWeek2Day2() != null && castOther.getWorkingWeek2Day2() != null && getWorkingWeek2Day2().equals(castOther.getWorkingWeek2Day2())) && (getWorkingWeek3Day2() == castOther.getWorkingWeek3Day2() || getWorkingWeek3Day2() != null && castOther.getWorkingWeek3Day2() != null && getWorkingWeek3Day2().equals(castOther.getWorkingWeek3Day2())) && (getWorkingWeek4Day2() == castOther.getWorkingWeek4Day2() || getWorkingWeek4Day2() != null && castOther.getWorkingWeek4Day2() != null && getWorkingWeek4Day2().equals(castOther.getWorkingWeek4Day2())) && (getWorkingWeek5Day2() == castOther.getWorkingWeek5Day2() || getWorkingWeek5Day2() != null && castOther.getWorkingWeek5Day2() != null && getWorkingWeek5Day2().equals(castOther.getWorkingWeek5Day2())) && (getWorkingWeekApplDay3() == castOther.getWorkingWeekApplDay3() || getWorkingWeekApplDay3() != null && castOther.getWorkingWeekApplDay3() != null && getWorkingWeekApplDay3().equals(castOther.getWorkingWeekApplDay3())) && (getWorkingWeek1Day3() == castOther.getWorkingWeek1Day3() || getWorkingWeek1Day3() != null && castOther.getWorkingWeek1Day3() != null && getWorkingWeek1Day3().equals(castOther.getWorkingWeek1Day3())) && (getWorkingWeek2Day3() == castOther.getWorkingWeek2Day3() || getWorkingWeek2Day3() != null && castOther.getWorkingWeek2Day3() != null && getWorkingWeek2Day3().equals(castOther.getWorkingWeek2Day3())) && (getWorkingWeek3Day3() == castOther.getWorkingWeek3Day3() || getWorkingWeek3Day3() != null && castOther.getWorkingWeek3Day3() != null && getWorkingWeek3Day3().equals(castOther.getWorkingWeek3Day3())) && (getWorkingWeek4Day3() == castOther.getWorkingWeek4Day3() || getWorkingWeek4Day3() != null && castOther.getWorkingWeek4Day3() != null && getWorkingWeek4Day3().equals(castOther.getWorkingWeek4Day3())) && (getWorkingWeek5Day3() == castOther.getWorkingWeek5Day3() || getWorkingWeek5Day3() != null && castOther.getWorkingWeek5Day3() != null && getWorkingWeek5Day3().equals(castOther.getWorkingWeek5Day3())) && (getWorkingWeekApplDay4() == castOther.getWorkingWeekApplDay4() || getWorkingWeekApplDay4() != null && castOther.getWorkingWeekApplDay4() != null && getWorkingWeekApplDay4().equals(castOther.getWorkingWeekApplDay4())) && (getWorkingWeek1Day4() == castOther.getWorkingWeek1Day4() || getWorkingWeek1Day4() != null && castOther.getWorkingWeek1Day4() != null && getWorkingWeek1Day4().equals(castOther.getWorkingWeek1Day4())) && (getWorkingWeek2Day4() == castOther.getWorkingWeek2Day4() || getWorkingWeek2Day4() != null && castOther.getWorkingWeek2Day4() != null && getWorkingWeek2Day4().equals(castOther.getWorkingWeek2Day4())) && (getWorkingWeek3Day4() == castOther.getWorkingWeek3Day4() || getWorkingWeek3Day4() != null && castOther.getWorkingWeek3Day4() != null && getWorkingWeek3Day4().equals(castOther.getWorkingWeek3Day4())) && (getWorkingWeek4Day4() == castOther.getWorkingWeek4Day4() || getWorkingWeek4Day4() != null && castOther.getWorkingWeek4Day4() != null && getWorkingWeek4Day4().equals(castOther.getWorkingWeek4Day4())) && (getWorkingWeek5Day4() == castOther.getWorkingWeek5Day4() || getWorkingWeek5Day4() != null && castOther.getWorkingWeek5Day4() != null && getWorkingWeek5Day4().equals(castOther.getWorkingWeek5Day4())) && (getWorkingWeekApplDay5() == castOther.getWorkingWeekApplDay5() || getWorkingWeekApplDay5() != null && castOther.getWorkingWeekApplDay5() != null && getWorkingWeekApplDay5().equals(castOther.getWorkingWeekApplDay5())) && (getWorkingWeek1Day5() == castOther.getWorkingWeek1Day5() || getWorkingWeek1Day5() != null && castOther.getWorkingWeek1Day5() != null && getWorkingWeek1Day5().equals(castOther.getWorkingWeek1Day5())) && (getWorkingWeek2Day5() == castOther.getWorkingWeek2Day5() || getWorkingWeek2Day5() != null && castOther.getWorkingWeek2Day5() != null && getWorkingWeek2Day5().equals(castOther.getWorkingWeek2Day5())) && (getWorkingWeek3Day5() == castOther.getWorkingWeek3Day5() || getWorkingWeek3Day5() != null && castOther.getWorkingWeek3Day5() != null && getWorkingWeek3Day5().equals(castOther.getWorkingWeek3Day5())) && (getWorkingWeek4Day5() == castOther.getWorkingWeek4Day5() || getWorkingWeek4Day5() != null && castOther.getWorkingWeek4Day5() != null && getWorkingWeek4Day5().equals(castOther.getWorkingWeek4Day5())) && (getWorkingWeek5Day5() == castOther.getWorkingWeek5Day5() || getWorkingWeek5Day5() != null && castOther.getWorkingWeek5Day5() != null && getWorkingWeek5Day5().equals(castOther.getWorkingWeek5Day5())) && (getWorkingWeekApplDay6() == castOther.getWorkingWeekApplDay6() || getWorkingWeekApplDay6() != null && castOther.getWorkingWeekApplDay6() != null && getWorkingWeekApplDay6().equals(castOther.getWorkingWeekApplDay6())) && (getWorkingWeek1Day6() == castOther.getWorkingWeek1Day6() || getWorkingWeek1Day6() != null && castOther.getWorkingWeek1Day6() != null && getWorkingWeek1Day6().equals(castOther.getWorkingWeek1Day6())) && (getWorkingWeek2Day6() == castOther.getWorkingWeek2Day6() || getWorkingWeek2Day6() != null && castOther.getWorkingWeek2Day6() != null && getWorkingWeek2Day6().equals(castOther.getWorkingWeek2Day6())) && (getWorkingWeek3Day6() == castOther.getWorkingWeek3Day6() || getWorkingWeek3Day6() != null && castOther.getWorkingWeek3Day6() != null && getWorkingWeek3Day6().equals(castOther.getWorkingWeek3Day6())) && (getWorkingWeek4Day6() == castOther.getWorkingWeek4Day6() || getWorkingWeek4Day6() != null && castOther.getWorkingWeek4Day6() != null && getWorkingWeek4Day6().equals(castOther.getWorkingWeek4Day6())) && (getWorkingWeek5Day6() == castOther.getWorkingWeek5Day6() || getWorkingWeek5Day6() != null && castOther.getWorkingWeek5Day6() != null && getWorkingWeek5Day6().equals(castOther.getWorkingWeek5Day6())) && (getWorkingWeekApplDay7() == castOther.getWorkingWeekApplDay7() || getWorkingWeekApplDay7() != null && castOther.getWorkingWeekApplDay7() != null && getWorkingWeekApplDay7().equals(castOther.getWorkingWeekApplDay7())) && (getWorkingWeek1Day7() == castOther.getWorkingWeek1Day7() || getWorkingWeek1Day7() != null && castOther.getWorkingWeek1Day7() != null && getWorkingWeek1Day7().equals(castOther.getWorkingWeek1Day7())) && (getWorkingWeek2Day7() == castOther.getWorkingWeek2Day7() || getWorkingWeek2Day7() != null && castOther.getWorkingWeek2Day7() != null && getWorkingWeek2Day7().equals(castOther.getWorkingWeek2Day7())) && (getWorkingWeek3Day7() == castOther.getWorkingWeek3Day7() || getWorkingWeek3Day7() != null && castOther.getWorkingWeek3Day7() != null && getWorkingWeek3Day7().equals(castOther.getWorkingWeek3Day7())) && (getWorkingWeek4Day7() == castOther.getWorkingWeek4Day7() || getWorkingWeek4Day7() != null && castOther.getWorkingWeek4Day7() != null && getWorkingWeek4Day7().equals(castOther.getWorkingWeek4Day7())) && (getWorkingWeek5Day7() == castOther.getWorkingWeek5Day7() || getWorkingWeek5Day7() != null && castOther.getWorkingWeek5Day7() != null && getWorkingWeek5Day7().equals(castOther.getWorkingWeek5Day7())) && (getWorkingDayStartTime() == castOther.getWorkingDayStartTime() || getWorkingDayStartTime() != null && castOther.getWorkingDayStartTime() != null && getWorkingDayStartTime().equals(castOther.getWorkingDayStartTime())) && (getWorkingDayEndTime() == castOther.getWorkingDayEndTime() || getWorkingDayEndTime() != null && castOther.getWorkingDayEndTime() != null && getWorkingDayEndTime().equals(castOther.getWorkingDayEndTime())) && (getBaseSlotSlabTime() == castOther.getBaseSlotSlabTime() || getBaseSlotSlabTime() != null && castOther.getBaseSlotSlabTime() != null && getBaseSlotSlabTime().equals(castOther.getBaseSlotSlabTime())) && (getPrimaryResourceClass() == castOther.getPrimaryResourceClass() || getPrimaryResourceClass() != null && castOther.getPrimaryResourceClass() != null && getPrimaryResourceClass().equals(castOther.getPrimaryResourceClass())) && (getMrLocationCode() == castOther.getMrLocationCode() || getMrLocationCode() != null && castOther.getMrLocationCode() != null && getMrLocationCode().equals(castOther.getMrLocationCode())) && (getMrSectionType() == castOther.getMrSectionType() || getMrSectionType() != null && castOther.getMrSectionType() != null && getMrSectionType().equals(castOther.getMrSectionType())) && (getMrSectionCode() == castOther.getMrSectionCode() || getMrSectionCode() != null && castOther.getMrSectionCode() != null && getMrSectionCode().equals(castOther.getMrSectionCode())) && (getOnlineMrNotfnYn() == castOther.getOnlineMrNotfnYn() || getOnlineMrNotfnYn() != null && castOther.getOnlineMrNotfnYn() != null && getOnlineMrNotfnYn().equals(castOther.getOnlineMrNotfnYn())) && (getAgeGroupCode() == castOther.getAgeGroupCode() || getAgeGroupCode() != null && castOther.getAgeGroupCode() != null && getAgeGroupCode().equals(castOther.getAgeGroupCode())) && (getLevelOfCareInd() == castOther.getLevelOfCareInd() || getLevelOfCareInd() != null && castOther.getLevelOfCareInd() != null && getLevelOfCareInd().equals(castOther.getLevelOfCareInd())) && (getSpecialityCode() == castOther.getSpecialityCode() || getSpecialityCode() != null && castOther.getSpecialityCode() != null && getSpecialityCode().equals(castOther.getSpecialityCode())) && (getDeptCode() == castOther.getDeptCode() || getDeptCode() != null && castOther.getDeptCode() != null && getDeptCode().equals(castOther.getDeptCode())) && (getSectionCode() == castOther.getSectionCode() || getSectionCode() != null && castOther.getSectionCode() != null && getSectionCode().equals(castOther.getSectionCode())) && (getServiceCode() == castOther.getServiceCode() || getServiceCode() != null && castOther.getServiceCode() != null && getServiceCode().equals(castOther.getServiceCode())) && (getPractType() == castOther.getPractType() || getPractType() != null && castOther.getPractType() != null && getPractType().equals(castOther.getPractType())) && (getOpenToAllPractYn() == castOther.getOpenToAllPractYn() || getOpenToAllPractYn() != null && castOther.getOpenToAllPractYn() != null && getOpenToAllPractYn().equals(castOther.getOpenToAllPractYn())) && (getIdentAtCheckin() == castOther.getIdentAtCheckin() || getIdentAtCheckin() != null && castOther.getIdentAtCheckin() != null && getIdentAtCheckin().equals(castOther.getIdentAtCheckin())) && (getAllowApptYn() == castOther.getAllowApptYn() || getAllowApptYn() != null && castOther.getAllowApptYn() != null && getAllowApptYn().equals(castOther.getAllowApptYn())) && (getAllowVisitRegnYn() == castOther.getAllowVisitRegnYn() || getAllowVisitRegnYn() != null && castOther.getAllowVisitRegnYn() != null && getAllowVisitRegnYn().equals(castOther.getAllowVisitRegnYn())) && (getAllowWalkInYn() == castOther.getAllowWalkInYn() || getAllowWalkInYn() != null && castOther.getAllowWalkInYn() != null && getAllowWalkInYn().equals(castOther.getAllowWalkInYn())) && (getAllowReferralYn() == castOther.getAllowReferralYn() || getAllowReferralYn() != null && castOther.getAllowReferralYn() != null && getAllowReferralYn().equals(castOther.getAllowReferralYn())) && (getAllowNonReferralYn() == castOther.getAllowNonReferralYn() || getAllowNonReferralYn() != null && castOther.getAllowNonReferralYn() != null && getAllowNonReferralYn().equals(castOther.getAllowNonReferralYn())) && (getAllowUnassignInPractqYn() == castOther.getAllowUnassignInPractqYn() || getAllowUnassignInPractqYn() != null && castOther.getAllowUnassignInPractqYn() != null && getAllowUnassignInPractqYn().equals(castOther.getAllowUnassignInPractqYn())) && (getRecordVitalSignsYn() == castOther.getRecordVitalSignsYn() || getRecordVitalSignsYn() != null && castOther.getRecordVitalSignsYn() != null && getRecordVitalSignsYn().equals(castOther.getRecordVitalSignsYn())) && (getRecordImmuYn() == castOther.getRecordImmuYn() || getRecordImmuYn() != null && castOther.getRecordImmuYn() != null && getRecordImmuYn().equals(castOther.getRecordImmuYn())) && (getRecordOutcomeYn() == castOther.getRecordOutcomeYn() || getRecordOutcomeYn() != null && castOther.getRecordOutcomeYn() != null && getRecordOutcomeYn().equals(castOther.getRecordOutcomeYn())) && (getFiVisitTypeApplYn() == castOther.getFiVisitTypeApplYn() || getFiVisitTypeApplYn() != null && castOther.getFiVisitTypeApplYn() != null && getFiVisitTypeApplYn().equals(castOther.getFiVisitTypeApplYn())) && (getFuVisitTypeApplYn() == castOther.getFuVisitTypeApplYn() || getFuVisitTypeApplYn() != null && castOther.getFuVisitTypeApplYn() != null && getFuVisitTypeApplYn().equals(castOther.getFuVisitTypeApplYn())) && (getRtVisitTypeApplYn() == castOther.getRtVisitTypeApplYn() || getRtVisitTypeApplYn() != null && castOther.getRtVisitTypeApplYn() != null && getRtVisitTypeApplYn().equals(castOther.getRtVisitTypeApplYn())) && (getSrVisitTypeApplYn() == castOther.getSrVisitTypeApplYn() || getSrVisitTypeApplYn() != null && castOther.getSrVisitTypeApplYn() != null && getSrVisitTypeApplYn().equals(castOther.getSrVisitTypeApplYn())) && (getCsVisitTypeApplYn() == castOther.getCsVisitTypeApplYn() || getCsVisitTypeApplYn() != null && castOther.getCsVisitTypeApplYn() != null && getCsVisitTypeApplYn().equals(castOther.getCsVisitTypeApplYn())) && (getEmVisitTypeApplYn() == castOther.getEmVisitTypeApplYn() || getEmVisitTypeApplYn() != null && castOther.getEmVisitTypeApplYn() != null && getEmVisitTypeApplYn().equals(castOther.getEmVisitTypeApplYn())) && (getOpApplYn() == castOther.getOpApplYn() || getOpApplYn() != null && castOther.getOpApplYn() != null && getOpApplYn().equals(castOther.getOpApplYn())) && (getDcApplYn() == castOther.getDcApplYn() || getDcApplYn() != null && castOther.getDcApplYn() != null && getDcApplYn().equals(castOther.getDcApplYn())) && (getIpApplYn() == castOther.getIpApplYn() || getIpApplYn() != null && castOther.getIpApplYn() != null && getIpApplYn().equals(castOther.getIpApplYn())) && (getEmApplYn() == castOther.getEmApplYn() || getEmApplYn() != null && castOther.getEmApplYn() != null && getEmApplYn().equals(castOther.getEmApplYn())) && (getVitalSignsBatteryId() == castOther.getVitalSignsBatteryId() || getVitalSignsBatteryId() != null && castOther.getVitalSignsBatteryId() != null && getVitalSignsBatteryId().equals(castOther.getVitalSignsBatteryId())) && (getAlcnCriteria() == castOther.getAlcnCriteria() || getAlcnCriteria() != null && castOther.getAlcnCriteria() != null && getAlcnCriteria().equals(castOther.getAlcnCriteria())) && (getDispInCaQueueAfter() == castOther.getDispInCaQueueAfter() || getDispInCaQueueAfter() != null && castOther.getDispInCaQueueAfter() != null && getDispInCaQueueAfter().equals(castOther.getDispInCaQueueAfter())) && (getDfltFileTypeCode() == castOther.getDfltFileTypeCode() || getDfltFileTypeCode() != null && castOther.getDfltFileTypeCode() != null && getDfltFileTypeCode().equals(castOther.getDfltFileTypeCode())) && (getEffDateFrom() == castOther.getEffDateFrom() || getEffDateFrom() != null && castOther.getEffDateFrom() != null && getEffDateFrom().equals(castOther.getEffDateFrom())) && (getEffDateTo() == castOther.getEffDateTo() || getEffDateTo() != null && castOther.getEffDateTo() != null && getEffDateTo().equals(castOther.getEffDateTo())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus())) && (getVisitSpecialistClinicYn() == castOther.getVisitSpecialistClinicYn() || getVisitSpecialistClinicYn() != null && castOther.getVisitSpecialistClinicYn() != null && getVisitSpecialistClinicYn().equals(castOther.getVisitSpecialistClinicYn())) && (getQueueNumApplYn() == castOther.getQueueNumApplYn() || getQueueNumApplYn() != null && castOther.getQueueNumApplYn() != null && getQueueNumApplYn().equals(castOther.getQueueNumApplYn())) && (getQueueNumByPractYn() == castOther.getQueueNumByPractYn() || getQueueNumByPractYn() != null && castOther.getQueueNumByPractYn() != null && getQueueNumByPractYn().equals(castOther.getQueueNumByPractYn())) && (getQueueNumByRoomYn() == castOther.getQueueNumByRoomYn() || getQueueNumByRoomYn() != null && castOther.getQueueNumByRoomYn() != null && getQueueNumByRoomYn().equals(castOther.getQueueNumByRoomYn())) && (getQueueNumByOtherResYn() == castOther.getQueueNumByOtherResYn() || getQueueNumByOtherResYn() != null && castOther.getQueueNumByOtherResYn() != null && getQueueNumByOtherResYn().equals(castOther.getQueueNumByOtherResYn())) && (getQueueNumOtherResClass() == castOther.getQueueNumOtherResClass() || getQueueNumOtherResClass() != null && castOther.getQueueNumOtherResClass() != null && getQueueNumOtherResClass().equals(castOther.getQueueNumOtherResClass())) && (getQueueNumOtherResType() == castOther.getQueueNumOtherResType() || getQueueNumOtherResType() != null && castOther.getQueueNumOtherResType() != null && getQueueNumOtherResType().equals(castOther.getQueueNumOtherResType())) && (getAddedById() == castOther.getAddedById() || getAddedById() != null && castOther.getAddedById() != null && getAddedById().equals(castOther.getAddedById())) && (getAddedDate() == castOther.getAddedDate() || getAddedDate() != null && castOther.getAddedDate() != null && getAddedDate().equals(castOther.getAddedDate())) && (getAddedAtWsNo() == castOther.getAddedAtWsNo() || getAddedAtWsNo() != null && castOther.getAddedAtWsNo() != null && getAddedAtWsNo().equals(castOther.getAddedAtWsNo())) && (getAddedFacilityId() == castOther.getAddedFacilityId() || getAddedFacilityId() != null && castOther.getAddedFacilityId() != null && getAddedFacilityId().equals(castOther.getAddedFacilityId())) && (getModifiedById() == castOther.getModifiedById() || getModifiedById() != null && castOther.getModifiedById() != null && getModifiedById().equals(castOther.getModifiedById())) && (getModifiedDate() == castOther.getModifiedDate() || getModifiedDate() != null && castOther.getModifiedDate() != null && getModifiedDate().equals(castOther.getModifiedDate())) && (getModifiedAtWsNo() == castOther.getModifiedAtWsNo() || getModifiedAtWsNo() != null && castOther.getModifiedAtWsNo() != null && getModifiedAtWsNo().equals(castOther.getModifiedAtWsNo())) && (getModifiedFacilityId() == castOther.getModifiedFacilityId() || getModifiedFacilityId() != null && castOther.getModifiedFacilityId() != null && getModifiedFacilityId().equals(castOther.getModifiedFacilityId()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getFacilityId() != null ? getFacilityId().hashCode() : 0);
        result = 37 * result + (getClinicCode() != null ? getClinicCode().hashCode() : 0);
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getOrdby() != null ? getOrdby().hashCode() : 0);
        result = 37 * result + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getCareLocnTypeInd() != null ? getCareLocnTypeInd().hashCode() : 0);
        result = 37 * result + (getClinicType() != null ? getClinicType().hashCode() : 0);
        result = 37 * result + (getSpecialistClinicYn() != null ? getSpecialistClinicYn().hashCode() : 0);
        result = 37 * result + (getWorkingDay1() != null ? getWorkingDay1().hashCode() : 0);
        result = 37 * result + (getWorkingDay2() != null ? getWorkingDay2().hashCode() : 0);
        result = 37 * result + (getWorkingDay3() != null ? getWorkingDay3().hashCode() : 0);
        result = 37 * result + (getWorkingDay4() != null ? getWorkingDay4().hashCode() : 0);
        result = 37 * result + (getWorkingDay5() != null ? getWorkingDay5().hashCode() : 0);
        result = 37 * result + (getWorkingDay6() != null ? getWorkingDay6().hashCode() : 0);
        result = 37 * result + (getWorkingDay7() != null ? getWorkingDay7().hashCode() : 0);
        result = 37 * result + (getWorkingWeekApplDay1() != null ? getWorkingWeekApplDay1().hashCode() : 0);
        result = 37 * result + (getWorkingWeek1Day1() != null ? getWorkingWeek1Day1().hashCode() : 0);
        result = 37 * result + (getWorkingWeek2Day1() != null ? getWorkingWeek2Day1().hashCode() : 0);
        result = 37 * result + (getWorkingWeek3Day1() != null ? getWorkingWeek3Day1().hashCode() : 0);
        result = 37 * result + (getWorkingWeek4Day1() != null ? getWorkingWeek4Day1().hashCode() : 0);
        result = 37 * result + (getWorkingWeek5Day1() != null ? getWorkingWeek5Day1().hashCode() : 0);
        result = 37 * result + (getWorkingWeekApplDay2() != null ? getWorkingWeekApplDay2().hashCode() : 0);
        result = 37 * result + (getWorkingWeek1Day2() != null ? getWorkingWeek1Day2().hashCode() : 0);
        result = 37 * result + (getWorkingWeek2Day2() != null ? getWorkingWeek2Day2().hashCode() : 0);
        result = 37 * result + (getWorkingWeek3Day2() != null ? getWorkingWeek3Day2().hashCode() : 0);
        result = 37 * result + (getWorkingWeek4Day2() != null ? getWorkingWeek4Day2().hashCode() : 0);
        result = 37 * result + (getWorkingWeek5Day2() != null ? getWorkingWeek5Day2().hashCode() : 0);
        result = 37 * result + (getWorkingWeekApplDay3() != null ? getWorkingWeekApplDay3().hashCode() : 0);
        result = 37 * result + (getWorkingWeek1Day3() != null ? getWorkingWeek1Day3().hashCode() : 0);
        result = 37 * result + (getWorkingWeek2Day3() != null ? getWorkingWeek2Day3().hashCode() : 0);
        result = 37 * result + (getWorkingWeek3Day3() != null ? getWorkingWeek3Day3().hashCode() : 0);
        result = 37 * result + (getWorkingWeek4Day3() != null ? getWorkingWeek4Day3().hashCode() : 0);
        result = 37 * result + (getWorkingWeek5Day3() != null ? getWorkingWeek5Day3().hashCode() : 0);
        result = 37 * result + (getWorkingWeekApplDay4() != null ? getWorkingWeekApplDay4().hashCode() : 0);
        result = 37 * result + (getWorkingWeek1Day4() != null ? getWorkingWeek1Day4().hashCode() : 0);
        result = 37 * result + (getWorkingWeek2Day4() != null ? getWorkingWeek2Day4().hashCode() : 0);
        result = 37 * result + (getWorkingWeek3Day4() != null ? getWorkingWeek3Day4().hashCode() : 0);
        result = 37 * result + (getWorkingWeek4Day4() != null ? getWorkingWeek4Day4().hashCode() : 0);
        result = 37 * result + (getWorkingWeek5Day4() != null ? getWorkingWeek5Day4().hashCode() : 0);
        result = 37 * result + (getWorkingWeekApplDay5() != null ? getWorkingWeekApplDay5().hashCode() : 0);
        result = 37 * result + (getWorkingWeek1Day5() != null ? getWorkingWeek1Day5().hashCode() : 0);
        result = 37 * result + (getWorkingWeek2Day5() != null ? getWorkingWeek2Day5().hashCode() : 0);
        result = 37 * result + (getWorkingWeek3Day5() != null ? getWorkingWeek3Day5().hashCode() : 0);
        result = 37 * result + (getWorkingWeek4Day5() != null ? getWorkingWeek4Day5().hashCode() : 0);
        result = 37 * result + (getWorkingWeek5Day5() != null ? getWorkingWeek5Day5().hashCode() : 0);
        result = 37 * result + (getWorkingWeekApplDay6() != null ? getWorkingWeekApplDay6().hashCode() : 0);
        result = 37 * result + (getWorkingWeek1Day6() != null ? getWorkingWeek1Day6().hashCode() : 0);
        result = 37 * result + (getWorkingWeek2Day6() != null ? getWorkingWeek2Day6().hashCode() : 0);
        result = 37 * result + (getWorkingWeek3Day6() != null ? getWorkingWeek3Day6().hashCode() : 0);
        result = 37 * result + (getWorkingWeek4Day6() != null ? getWorkingWeek4Day6().hashCode() : 0);
        result = 37 * result + (getWorkingWeek5Day6() != null ? getWorkingWeek5Day6().hashCode() : 0);
        result = 37 * result + (getWorkingWeekApplDay7() != null ? getWorkingWeekApplDay7().hashCode() : 0);
        result = 37 * result + (getWorkingWeek1Day7() != null ? getWorkingWeek1Day7().hashCode() : 0);
        result = 37 * result + (getWorkingWeek2Day7() != null ? getWorkingWeek2Day7().hashCode() : 0);
        result = 37 * result + (getWorkingWeek3Day7() != null ? getWorkingWeek3Day7().hashCode() : 0);
        result = 37 * result + (getWorkingWeek4Day7() != null ? getWorkingWeek4Day7().hashCode() : 0);
        result = 37 * result + (getWorkingWeek5Day7() != null ? getWorkingWeek5Day7().hashCode() : 0);
        result = 37 * result + (getWorkingDayStartTime() != null ? getWorkingDayStartTime().hashCode() : 0);
        result = 37 * result + (getWorkingDayEndTime() != null ? getWorkingDayEndTime().hashCode() : 0);
        result = 37 * result + (getBaseSlotSlabTime() != null ? getBaseSlotSlabTime().hashCode() : 0);
        result = 37 * result + (getPrimaryResourceClass() != null ? getPrimaryResourceClass().hashCode() : 0);
        result = 37 * result + (getMrLocationCode() != null ? getMrLocationCode().hashCode() : 0);
        result = 37 * result + (getMrSectionType() != null ? getMrSectionType().hashCode() : 0);
        result = 37 * result + (getMrSectionCode() != null ? getMrSectionCode().hashCode() : 0);
        result = 37 * result + (getOnlineMrNotfnYn() != null ? getOnlineMrNotfnYn().hashCode() : 0);
        result = 37 * result + (getAgeGroupCode() != null ? getAgeGroupCode().hashCode() : 0);
        result = 37 * result + (getLevelOfCareInd() != null ? getLevelOfCareInd().hashCode() : 0);
        result = 37 * result + (getSpecialityCode() != null ? getSpecialityCode().hashCode() : 0);
        result = 37 * result + (getDeptCode() != null ? getDeptCode().hashCode() : 0);
        result = 37 * result + (getSectionCode() != null ? getSectionCode().hashCode() : 0);
        result = 37 * result + (getServiceCode() != null ? getServiceCode().hashCode() : 0);
        result = 37 * result + (getPractType() != null ? getPractType().hashCode() : 0);
        result = 37 * result + (getOpenToAllPractYn() != null ? getOpenToAllPractYn().hashCode() : 0);
        result = 37 * result + (getIdentAtCheckin() != null ? getIdentAtCheckin().hashCode() : 0);
        result = 37 * result + (getAllowApptYn() != null ? getAllowApptYn().hashCode() : 0);
        result = 37 * result + (getAllowVisitRegnYn() != null ? getAllowVisitRegnYn().hashCode() : 0);
        result = 37 * result + (getAllowWalkInYn() != null ? getAllowWalkInYn().hashCode() : 0);
        result = 37 * result + (getAllowReferralYn() != null ? getAllowReferralYn().hashCode() : 0);
        result = 37 * result + (getAllowNonReferralYn() != null ? getAllowNonReferralYn().hashCode() : 0);
        result = 37 * result + (getAllowUnassignInPractqYn() != null ? getAllowUnassignInPractqYn().hashCode() : 0);
        result = 37 * result + (getRecordVitalSignsYn() != null ? getRecordVitalSignsYn().hashCode() : 0);
        result = 37 * result + (getRecordImmuYn() != null ? getRecordImmuYn().hashCode() : 0);
        result = 37 * result + (getRecordOutcomeYn() != null ? getRecordOutcomeYn().hashCode() : 0);
        result = 37 * result + (getFiVisitTypeApplYn() != null ? getFiVisitTypeApplYn().hashCode() : 0);
        result = 37 * result + (getFuVisitTypeApplYn() != null ? getFuVisitTypeApplYn().hashCode() : 0);
        result = 37 * result + (getRtVisitTypeApplYn() != null ? getRtVisitTypeApplYn().hashCode() : 0);
        result = 37 * result + (getSrVisitTypeApplYn() != null ? getSrVisitTypeApplYn().hashCode() : 0);
        result = 37 * result + (getCsVisitTypeApplYn() != null ? getCsVisitTypeApplYn().hashCode() : 0);
        result = 37 * result + (getEmVisitTypeApplYn() != null ? getEmVisitTypeApplYn().hashCode() : 0);
        result = 37 * result + (getOpApplYn() != null ? getOpApplYn().hashCode() : 0);
        result = 37 * result + (getDcApplYn() != null ? getDcApplYn().hashCode() : 0);
        result = 37 * result + (getIpApplYn() != null ? getIpApplYn().hashCode() : 0);
        result = 37 * result + (getEmApplYn() != null ? getEmApplYn().hashCode() : 0);
        result = 37 * result + (getVitalSignsBatteryId() != null ? getVitalSignsBatteryId().hashCode() : 0);
        result = 37 * result + (getAlcnCriteria() != null ? getAlcnCriteria().hashCode() : 0);
        result = 37 * result + (getDispInCaQueueAfter() != null ? getDispInCaQueueAfter().hashCode() : 0);
        result = 37 * result + (getDfltFileTypeCode() != null ? getDfltFileTypeCode().hashCode() : 0);
        result = 37 * result + (getEffDateFrom() != null ? getEffDateFrom().hashCode() : 0);
        result = 37 * result + (getEffDateTo() != null ? getEffDateTo().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        result = 37 * result + (getVisitSpecialistClinicYn() != null ? getVisitSpecialistClinicYn().hashCode() : 0);
        result = 37 * result + (getQueueNumApplYn() != null ? getQueueNumApplYn().hashCode() : 0);
        result = 37 * result + (getQueueNumByPractYn() != null ? getQueueNumByPractYn().hashCode() : 0);
        result = 37 * result + (getQueueNumByRoomYn() != null ? getQueueNumByRoomYn().hashCode() : 0);
        result = 37 * result + (getQueueNumByOtherResYn() != null ? getQueueNumByOtherResYn().hashCode() : 0);
        result = 37 * result + (getQueueNumOtherResClass() != null ? getQueueNumOtherResClass().hashCode() : 0);
        result = 37 * result + (getQueueNumOtherResType() != null ? getQueueNumOtherResType().hashCode() : 0);
        result = 37 * result + (getAddedById() != null ? getAddedById().hashCode() : 0);
        result = 37 * result + (getAddedDate() != null ? getAddedDate().hashCode() : 0);
        result = 37 * result + (getAddedAtWsNo() != null ? getAddedAtWsNo().hashCode() : 0);
        result = 37 * result + (getAddedFacilityId() != null ? getAddedFacilityId().hashCode() : 0);
        result = 37 * result + (getModifiedById() != null ? getModifiedById().hashCode() : 0);
        result = 37 * result + (getModifiedDate() != null ? getModifiedDate().hashCode() : 0);
        result = 37 * result + (getModifiedAtWsNo() != null ? getModifiedAtWsNo().hashCode() : 0);
        result = 37 * result + (getModifiedFacilityId() != null ? getModifiedFacilityId().hashCode() : 0);
        return result;
    }

    private String facilityId;
    private String clinicCode;
    private String languageId;
    private Long ordby;
    private String longDesc;
    private String shortDesc;
    private String careLocnTypeInd;
    private String clinicType;
    private String specialistClinicYn;
    private String workingDay1;
    private String workingDay2;
    private String workingDay3;
    private String workingDay4;
    private String workingDay5;
    private String workingDay6;
    private String workingDay7;
    private String workingWeekApplDay1;
    private String workingWeek1Day1;
    private String workingWeek2Day1;
    private String workingWeek3Day1;
    private String workingWeek4Day1;
    private String workingWeek5Day1;
    private String workingWeekApplDay2;
    private String workingWeek1Day2;
    private String workingWeek2Day2;
    private String workingWeek3Day2;
    private String workingWeek4Day2;
    private String workingWeek5Day2;
    private String workingWeekApplDay3;
    private String workingWeek1Day3;
    private String workingWeek2Day3;
    private String workingWeek3Day3;
    private String workingWeek4Day3;
    private String workingWeek5Day3;
    private String workingWeekApplDay4;
    private String workingWeek1Day4;
    private String workingWeek2Day4;
    private String workingWeek3Day4;
    private String workingWeek4Day4;
    private String workingWeek5Day4;
    private String workingWeekApplDay5;
    private String workingWeek1Day5;
    private String workingWeek2Day5;
    private String workingWeek3Day5;
    private String workingWeek4Day5;
    private String workingWeek5Day5;
    private String workingWeekApplDay6;
    private String workingWeek1Day6;
    private String workingWeek2Day6;
    private String workingWeek3Day6;
    private String workingWeek4Day6;
    private String workingWeek5Day6;
    private String workingWeekApplDay7;
    private String workingWeek1Day7;
    private String workingWeek2Day7;
    private String workingWeek3Day7;
    private String workingWeek4Day7;
    private String workingWeek5Day7;
    private Date workingDayStartTime;
    private Date workingDayEndTime;
    private Date baseSlotSlabTime;
    private String primaryResourceClass;
    private String mrLocationCode;
    private String mrSectionType;
    private String mrSectionCode;
    private String onlineMrNotfnYn;
    private String ageGroupCode;
    private String levelOfCareInd;
    private String specialityCode;
    private String deptCode;
    private String sectionCode;
    private String serviceCode;
    private String practType;
    private String openToAllPractYn;
    private String identAtCheckin;
    private String allowApptYn;
    private String allowVisitRegnYn;
    private String allowWalkInYn;
    private String allowReferralYn;
    private String allowNonReferralYn;
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
    private String opApplYn;
    private String dcApplYn;
    private String ipApplYn;
    private String emApplYn;
    private String vitalSignsBatteryId;
    private String alcnCriteria;
    private String dispInCaQueueAfter;
    private String dfltFileTypeCode;
    private Date effDateFrom;
    private Date effDateTo;
    private String effStatus;
    private String visitSpecialistClinicYn;
    private String queueNumApplYn;
    private String queueNumByPractYn;
    private String queueNumByRoomYn;
    private String queueNumByOtherResYn;
    private String queueNumOtherResClass;
    private String queueNumOtherResType;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
}
