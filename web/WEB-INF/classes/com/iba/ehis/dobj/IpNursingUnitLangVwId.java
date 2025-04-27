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

public class IpNursingUnitLangVwId
    implements Serializable
{

    public IpNursingUnitLangVwId()
    {
    }

    public IpNursingUnitLangVwId(String s, String s1, String s2, String s3, Date date, String s4, String s5, 
            String s6, Date date1, String s7, String s8)
    {
        facilityId = s;
        nursingUnitCode = s1;
        languageId = s2;
        addedById = s3;
        addedDate = date;
        addedAtWsNo = s4;
        addedFacilityId = s5;
        modifiedById = s6;
        modifiedDate = date1;
        modifiedAtWsNo = s7;
        modifiedFacilityId = s8;
    }

    public IpNursingUnitLangVwId(String s, String s1, String s2, Long long1, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, String s10, String s11, String s12, 
            String s13, String s14, String s15, String s16, String s17, String s18, String s19, 
            Long long2, Long long3, Long long4, String s20, Long long5, String s21, String s22, 
            String s23, String s24, Date date, String s25, String s26, String s27, Date date1, 
            String s28, String s29, String s30, String s31, String s32, String s33, String s34, 
            String s35, String s36, String s37)
    {
        facilityId = s;
        nursingUnitCode = s1;
        languageId = s2;
        ordby = long1;
        longDesc = s3;
        shortDesc = s4;
        nursingUnitTypeCode = s5;
        locnType = s6;
        ageGroupCode = s7;
        deptCode = s8;
        serviceCode = s9;
        serviceShortDesc = s10;
        fsLocnCode = s11;
        inclForHospOccupCalcYn = s12;
        allowEmergTrfYn = s13;
        temporaryLocationYn = s14;
        teachingLocationYn = s15;
        allowPseudoBedYn = s16;
        generatePseudoBedSrlYn = s17;
        checkSameSexInRoomYn = s18;
        prefixForPseudoBedSrlNo = s19;
        nextPseudoBedSrl = long2;
        maxPseudoBedSrl = long3;
        numOfBeds = long4;
        numOfPseudoBeds = s20;
        numOfBedsOccupied = long5;
        onlineMrNotfnYn = s21;
        autoFileTransferYn = s22;
        effStatus = s23;
        addedById = s24;
        addedDate = date;
        addedAtWsNo = s25;
        addedFacilityId = s26;
        modifiedById = s27;
        modifiedDate = date1;
        modifiedAtWsNo = s28;
        modifiedFacilityId = s29;
        allowNewBornRegnYn = s30;
        patientClass = s31;
        dfltFileTypeCode = s32;
        levelOfCareCode = s33;
        mrSectionCode = s34;
        mrSectionType = s35;
        releaseBedOnLeaveYn = s36;
        sectionCode = s37;
    }

    public String getFacilityId()
    {
        return facilityId;
    }

    public void setFacilityId(String s)
    {
        facilityId = s;
    }

    public String getNursingUnitCode()
    {
        return nursingUnitCode;
    }

    public void setNursingUnitCode(String s)
    {
        nursingUnitCode = s;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String s)
    {
        languageId = s;
    }

    public Long getOrdby()
    {
        return ordby;
    }

    public void setOrdby(Long long1)
    {
        ordby = long1;
    }

    public String getLongDesc()
    {
        return longDesc;
    }

    public void setLongDesc(String s)
    {
        longDesc = s;
    }

    public String getShortDesc()
    {
        return shortDesc;
    }

    public void setShortDesc(String s)
    {
        shortDesc = s;
    }

    public String getNursingUnitTypeCode()
    {
        return nursingUnitTypeCode;
    }

    public void setNursingUnitTypeCode(String s)
    {
        nursingUnitTypeCode = s;
    }

    public String getLocnType()
    {
        return locnType;
    }

    public void setLocnType(String s)
    {
        locnType = s;
    }

    public String getAgeGroupCode()
    {
        return ageGroupCode;
    }

    public void setAgeGroupCode(String s)
    {
        ageGroupCode = s;
    }

    public String getDeptCode()
    {
        return deptCode;
    }

    public void setDeptCode(String s)
    {
        deptCode = s;
    }

    public String getServiceCode()
    {
        return serviceCode;
    }

    public void setServiceCode(String s)
    {
        serviceCode = s;
    }

    public String getServiceShortDesc()
    {
        return serviceShortDesc;
    }

    public void setServiceShortDesc(String s)
    {
        serviceShortDesc = s;
    }

    public String getFsLocnCode()
    {
        return fsLocnCode;
    }

    public void setFsLocnCode(String s)
    {
        fsLocnCode = s;
    }

    public String getInclForHospOccupCalcYn()
    {
        return inclForHospOccupCalcYn;
    }

    public void setInclForHospOccupCalcYn(String s)
    {
        inclForHospOccupCalcYn = s;
    }

    public String getAllowEmergTrfYn()
    {
        return allowEmergTrfYn;
    }

    public void setAllowEmergTrfYn(String s)
    {
        allowEmergTrfYn = s;
    }

    public String getTemporaryLocationYn()
    {
        return temporaryLocationYn;
    }

    public void setTemporaryLocationYn(String s)
    {
        temporaryLocationYn = s;
    }

    public String getTeachingLocationYn()
    {
        return teachingLocationYn;
    }

    public void setTeachingLocationYn(String s)
    {
        teachingLocationYn = s;
    }

    public String getAllowPseudoBedYn()
    {
        return allowPseudoBedYn;
    }

    public void setAllowPseudoBedYn(String s)
    {
        allowPseudoBedYn = s;
    }

    public String getGeneratePseudoBedSrlYn()
    {
        return generatePseudoBedSrlYn;
    }

    public void setGeneratePseudoBedSrlYn(String s)
    {
        generatePseudoBedSrlYn = s;
    }

    public String getCheckSameSexInRoomYn()
    {
        return checkSameSexInRoomYn;
    }

    public void setCheckSameSexInRoomYn(String s)
    {
        checkSameSexInRoomYn = s;
    }

    public String getPrefixForPseudoBedSrlNo()
    {
        return prefixForPseudoBedSrlNo;
    }

    public void setPrefixForPseudoBedSrlNo(String s)
    {
        prefixForPseudoBedSrlNo = s;
    }

    public Long getNextPseudoBedSrl()
    {
        return nextPseudoBedSrl;
    }

    public void setNextPseudoBedSrl(Long long1)
    {
        nextPseudoBedSrl = long1;
    }

    public Long getMaxPseudoBedSrl()
    {
        return maxPseudoBedSrl;
    }

    public void setMaxPseudoBedSrl(Long long1)
    {
        maxPseudoBedSrl = long1;
    }

    public Long getNumOfBeds()
    {
        return numOfBeds;
    }

    public void setNumOfBeds(Long long1)
    {
        numOfBeds = long1;
    }

    public String getNumOfPseudoBeds()
    {
        return numOfPseudoBeds;
    }

    public void setNumOfPseudoBeds(String s)
    {
        numOfPseudoBeds = s;
    }

    public Long getNumOfBedsOccupied()
    {
        return numOfBedsOccupied;
    }

    public void setNumOfBedsOccupied(Long long1)
    {
        numOfBedsOccupied = long1;
    }

    public String getOnlineMrNotfnYn()
    {
        return onlineMrNotfnYn;
    }

    public void setOnlineMrNotfnYn(String s)
    {
        onlineMrNotfnYn = s;
    }

    public String getAutoFileTransferYn()
    {
        return autoFileTransferYn;
    }

    public void setAutoFileTransferYn(String s)
    {
        autoFileTransferYn = s;
    }

    public String getEffStatus()
    {
        return effStatus;
    }

    public void setEffStatus(String s)
    {
        effStatus = s;
    }

    public String getAddedById()
    {
        return addedById;
    }

    public void setAddedById(String s)
    {
        addedById = s;
    }

    public Date getAddedDate()
    {
        return addedDate;
    }

    public void setAddedDate(Date date)
    {
        addedDate = date;
    }

    public String getAddedAtWsNo()
    {
        return addedAtWsNo;
    }

    public void setAddedAtWsNo(String s)
    {
        addedAtWsNo = s;
    }

    public String getAddedFacilityId()
    {
        return addedFacilityId;
    }

    public void setAddedFacilityId(String s)
    {
        addedFacilityId = s;
    }

    public String getModifiedById()
    {
        return modifiedById;
    }

    public void setModifiedById(String s)
    {
        modifiedById = s;
    }

    public Date getModifiedDate()
    {
        return modifiedDate;
    }

    public void setModifiedDate(Date date)
    {
        modifiedDate = date;
    }

    public String getModifiedAtWsNo()
    {
        return modifiedAtWsNo;
    }

    public void setModifiedAtWsNo(String s)
    {
        modifiedAtWsNo = s;
    }

    public String getModifiedFacilityId()
    {
        return modifiedFacilityId;
    }

    public void setModifiedFacilityId(String s)
    {
        modifiedFacilityId = s;
    }

    public String getAllowNewBornRegnYn()
    {
        return allowNewBornRegnYn;
    }

    public void setAllowNewBornRegnYn(String s)
    {
        allowNewBornRegnYn = s;
    }

    public String getPatientClass()
    {
        return patientClass;
    }

    public void setPatientClass(String s)
    {
        patientClass = s;
    }

    public String getDfltFileTypeCode()
    {
        return dfltFileTypeCode;
    }

    public void setDfltFileTypeCode(String s)
    {
        dfltFileTypeCode = s;
    }

    public String getLevelOfCareCode()
    {
        return levelOfCareCode;
    }

    public void setLevelOfCareCode(String s)
    {
        levelOfCareCode = s;
    }

    public String getMrSectionCode()
    {
        return mrSectionCode;
    }

    public void setMrSectionCode(String s)
    {
        mrSectionCode = s;
    }

    public String getMrSectionType()
    {
        return mrSectionType;
    }

    public void setMrSectionType(String s)
    {
        mrSectionType = s;
    }

    public String getReleaseBedOnLeaveYn()
    {
        return releaseBedOnLeaveYn;
    }

    public void setReleaseBedOnLeaveYn(String s)
    {
        releaseBedOnLeaveYn = s;
    }

    public String getSectionCode()
    {
        return sectionCode;
    }

    public void setSectionCode(String s)
    {
        sectionCode = s;
    }

    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof IpNursingUnitLangVwId))
        {
            return false;
        } else
        {
            IpNursingUnitLangVwId ipnursingunitlangvwid = (IpNursingUnitLangVwId)obj;
            return (getFacilityId() == ipnursingunitlangvwid.getFacilityId() || getFacilityId() != null && ipnursingunitlangvwid.getFacilityId() != null && getFacilityId().equals(ipnursingunitlangvwid.getFacilityId())) && (getNursingUnitCode() == ipnursingunitlangvwid.getNursingUnitCode() || getNursingUnitCode() != null && ipnursingunitlangvwid.getNursingUnitCode() != null && getNursingUnitCode().equals(ipnursingunitlangvwid.getNursingUnitCode())) && (getLanguageId() == ipnursingunitlangvwid.getLanguageId() || getLanguageId() != null && ipnursingunitlangvwid.getLanguageId() != null && getLanguageId().equals(ipnursingunitlangvwid.getLanguageId())) && (getOrdby() == ipnursingunitlangvwid.getOrdby() || getOrdby() != null && ipnursingunitlangvwid.getOrdby() != null && getOrdby().equals(ipnursingunitlangvwid.getOrdby())) && (getLongDesc() == ipnursingunitlangvwid.getLongDesc() || getLongDesc() != null && ipnursingunitlangvwid.getLongDesc() != null && getLongDesc().equals(ipnursingunitlangvwid.getLongDesc())) && (getShortDesc() == ipnursingunitlangvwid.getShortDesc() || getShortDesc() != null && ipnursingunitlangvwid.getShortDesc() != null && getShortDesc().equals(ipnursingunitlangvwid.getShortDesc())) && (getNursingUnitTypeCode() == ipnursingunitlangvwid.getNursingUnitTypeCode() || getNursingUnitTypeCode() != null && ipnursingunitlangvwid.getNursingUnitTypeCode() != null && getNursingUnitTypeCode().equals(ipnursingunitlangvwid.getNursingUnitTypeCode())) && (getLocnType() == ipnursingunitlangvwid.getLocnType() || getLocnType() != null && ipnursingunitlangvwid.getLocnType() != null && getLocnType().equals(ipnursingunitlangvwid.getLocnType())) && (getAgeGroupCode() == ipnursingunitlangvwid.getAgeGroupCode() || getAgeGroupCode() != null && ipnursingunitlangvwid.getAgeGroupCode() != null && getAgeGroupCode().equals(ipnursingunitlangvwid.getAgeGroupCode())) && (getDeptCode() == ipnursingunitlangvwid.getDeptCode() || getDeptCode() != null && ipnursingunitlangvwid.getDeptCode() != null && getDeptCode().equals(ipnursingunitlangvwid.getDeptCode())) && (getServiceCode() == ipnursingunitlangvwid.getServiceCode() || getServiceCode() != null && ipnursingunitlangvwid.getServiceCode() != null && getServiceCode().equals(ipnursingunitlangvwid.getServiceCode())) && (getServiceShortDesc() == ipnursingunitlangvwid.getServiceShortDesc() || getServiceShortDesc() != null && ipnursingunitlangvwid.getServiceShortDesc() != null && getServiceShortDesc().equals(ipnursingunitlangvwid.getServiceShortDesc())) && (getFsLocnCode() == ipnursingunitlangvwid.getFsLocnCode() || getFsLocnCode() != null && ipnursingunitlangvwid.getFsLocnCode() != null && getFsLocnCode().equals(ipnursingunitlangvwid.getFsLocnCode())) && (getInclForHospOccupCalcYn() == ipnursingunitlangvwid.getInclForHospOccupCalcYn() || getInclForHospOccupCalcYn() != null && ipnursingunitlangvwid.getInclForHospOccupCalcYn() != null && getInclForHospOccupCalcYn().equals(ipnursingunitlangvwid.getInclForHospOccupCalcYn())) && (getAllowEmergTrfYn() == ipnursingunitlangvwid.getAllowEmergTrfYn() || getAllowEmergTrfYn() != null && ipnursingunitlangvwid.getAllowEmergTrfYn() != null && getAllowEmergTrfYn().equals(ipnursingunitlangvwid.getAllowEmergTrfYn())) && (getTemporaryLocationYn() == ipnursingunitlangvwid.getTemporaryLocationYn() || getTemporaryLocationYn() != null && ipnursingunitlangvwid.getTemporaryLocationYn() != null && getTemporaryLocationYn().equals(ipnursingunitlangvwid.getTemporaryLocationYn())) && (getTeachingLocationYn() == ipnursingunitlangvwid.getTeachingLocationYn() || getTeachingLocationYn() != null && ipnursingunitlangvwid.getTeachingLocationYn() != null && getTeachingLocationYn().equals(ipnursingunitlangvwid.getTeachingLocationYn())) && (getAllowPseudoBedYn() == ipnursingunitlangvwid.getAllowPseudoBedYn() || getAllowPseudoBedYn() != null && ipnursingunitlangvwid.getAllowPseudoBedYn() != null && getAllowPseudoBedYn().equals(ipnursingunitlangvwid.getAllowPseudoBedYn())) && (getGeneratePseudoBedSrlYn() == ipnursingunitlangvwid.getGeneratePseudoBedSrlYn() || getGeneratePseudoBedSrlYn() != null && ipnursingunitlangvwid.getGeneratePseudoBedSrlYn() != null && getGeneratePseudoBedSrlYn().equals(ipnursingunitlangvwid.getGeneratePseudoBedSrlYn())) && (getCheckSameSexInRoomYn() == ipnursingunitlangvwid.getCheckSameSexInRoomYn() || getCheckSameSexInRoomYn() != null && ipnursingunitlangvwid.getCheckSameSexInRoomYn() != null && getCheckSameSexInRoomYn().equals(ipnursingunitlangvwid.getCheckSameSexInRoomYn())) && (getPrefixForPseudoBedSrlNo() == ipnursingunitlangvwid.getPrefixForPseudoBedSrlNo() || getPrefixForPseudoBedSrlNo() != null && ipnursingunitlangvwid.getPrefixForPseudoBedSrlNo() != null && getPrefixForPseudoBedSrlNo().equals(ipnursingunitlangvwid.getPrefixForPseudoBedSrlNo())) && (getNextPseudoBedSrl() == ipnursingunitlangvwid.getNextPseudoBedSrl() || getNextPseudoBedSrl() != null && ipnursingunitlangvwid.getNextPseudoBedSrl() != null && getNextPseudoBedSrl().equals(ipnursingunitlangvwid.getNextPseudoBedSrl())) && (getMaxPseudoBedSrl() == ipnursingunitlangvwid.getMaxPseudoBedSrl() || getMaxPseudoBedSrl() != null && ipnursingunitlangvwid.getMaxPseudoBedSrl() != null && getMaxPseudoBedSrl().equals(ipnursingunitlangvwid.getMaxPseudoBedSrl())) && (getNumOfBeds() == ipnursingunitlangvwid.getNumOfBeds() || getNumOfBeds() != null && ipnursingunitlangvwid.getNumOfBeds() != null && getNumOfBeds().equals(ipnursingunitlangvwid.getNumOfBeds())) && (getNumOfPseudoBeds() == ipnursingunitlangvwid.getNumOfPseudoBeds() || getNumOfPseudoBeds() != null && ipnursingunitlangvwid.getNumOfPseudoBeds() != null && getNumOfPseudoBeds().equals(ipnursingunitlangvwid.getNumOfPseudoBeds())) && (getNumOfBedsOccupied() == ipnursingunitlangvwid.getNumOfBedsOccupied() || getNumOfBedsOccupied() != null && ipnursingunitlangvwid.getNumOfBedsOccupied() != null && getNumOfBedsOccupied().equals(ipnursingunitlangvwid.getNumOfBedsOccupied())) && (getOnlineMrNotfnYn() == ipnursingunitlangvwid.getOnlineMrNotfnYn() || getOnlineMrNotfnYn() != null && ipnursingunitlangvwid.getOnlineMrNotfnYn() != null && getOnlineMrNotfnYn().equals(ipnursingunitlangvwid.getOnlineMrNotfnYn())) && (getAutoFileTransferYn() == ipnursingunitlangvwid.getAutoFileTransferYn() || getAutoFileTransferYn() != null && ipnursingunitlangvwid.getAutoFileTransferYn() != null && getAutoFileTransferYn().equals(ipnursingunitlangvwid.getAutoFileTransferYn())) && (getEffStatus() == ipnursingunitlangvwid.getEffStatus() || getEffStatus() != null && ipnursingunitlangvwid.getEffStatus() != null && getEffStatus().equals(ipnursingunitlangvwid.getEffStatus())) && (getAddedById() == ipnursingunitlangvwid.getAddedById() || getAddedById() != null && ipnursingunitlangvwid.getAddedById() != null && getAddedById().equals(ipnursingunitlangvwid.getAddedById())) && (getAddedDate() == ipnursingunitlangvwid.getAddedDate() || getAddedDate() != null && ipnursingunitlangvwid.getAddedDate() != null && getAddedDate().equals(ipnursingunitlangvwid.getAddedDate())) && (getAddedAtWsNo() == ipnursingunitlangvwid.getAddedAtWsNo() || getAddedAtWsNo() != null && ipnursingunitlangvwid.getAddedAtWsNo() != null && getAddedAtWsNo().equals(ipnursingunitlangvwid.getAddedAtWsNo())) && (getAddedFacilityId() == ipnursingunitlangvwid.getAddedFacilityId() || getAddedFacilityId() != null && ipnursingunitlangvwid.getAddedFacilityId() != null && getAddedFacilityId().equals(ipnursingunitlangvwid.getAddedFacilityId())) && (getModifiedById() == ipnursingunitlangvwid.getModifiedById() || getModifiedById() != null && ipnursingunitlangvwid.getModifiedById() != null && getModifiedById().equals(ipnursingunitlangvwid.getModifiedById())) && (getModifiedDate() == ipnursingunitlangvwid.getModifiedDate() || getModifiedDate() != null && ipnursingunitlangvwid.getModifiedDate() != null && getModifiedDate().equals(ipnursingunitlangvwid.getModifiedDate())) && (getModifiedAtWsNo() == ipnursingunitlangvwid.getModifiedAtWsNo() || getModifiedAtWsNo() != null && ipnursingunitlangvwid.getModifiedAtWsNo() != null && getModifiedAtWsNo().equals(ipnursingunitlangvwid.getModifiedAtWsNo())) && (getModifiedFacilityId() == ipnursingunitlangvwid.getModifiedFacilityId() || getModifiedFacilityId() != null && ipnursingunitlangvwid.getModifiedFacilityId() != null && getModifiedFacilityId().equals(ipnursingunitlangvwid.getModifiedFacilityId())) && (getAllowNewBornRegnYn() == ipnursingunitlangvwid.getAllowNewBornRegnYn() || getAllowNewBornRegnYn() != null && ipnursingunitlangvwid.getAllowNewBornRegnYn() != null && getAllowNewBornRegnYn().equals(ipnursingunitlangvwid.getAllowNewBornRegnYn())) && (getPatientClass() == ipnursingunitlangvwid.getPatientClass() || getPatientClass() != null && ipnursingunitlangvwid.getPatientClass() != null && getPatientClass().equals(ipnursingunitlangvwid.getPatientClass())) && (getDfltFileTypeCode() == ipnursingunitlangvwid.getDfltFileTypeCode() || getDfltFileTypeCode() != null && ipnursingunitlangvwid.getDfltFileTypeCode() != null && getDfltFileTypeCode().equals(ipnursingunitlangvwid.getDfltFileTypeCode())) && (getLevelOfCareCode() == ipnursingunitlangvwid.getLevelOfCareCode() || getLevelOfCareCode() != null && ipnursingunitlangvwid.getLevelOfCareCode() != null && getLevelOfCareCode().equals(ipnursingunitlangvwid.getLevelOfCareCode())) && (getMrSectionCode() == ipnursingunitlangvwid.getMrSectionCode() || getMrSectionCode() != null && ipnursingunitlangvwid.getMrSectionCode() != null && getMrSectionCode().equals(ipnursingunitlangvwid.getMrSectionCode())) && (getMrSectionType() == ipnursingunitlangvwid.getMrSectionType() || getMrSectionType() != null && ipnursingunitlangvwid.getMrSectionType() != null && getMrSectionType().equals(ipnursingunitlangvwid.getMrSectionType())) && (getReleaseBedOnLeaveYn() == ipnursingunitlangvwid.getReleaseBedOnLeaveYn() || getReleaseBedOnLeaveYn() != null && ipnursingunitlangvwid.getReleaseBedOnLeaveYn() != null && getReleaseBedOnLeaveYn().equals(ipnursingunitlangvwid.getReleaseBedOnLeaveYn())) && (getSectionCode() == ipnursingunitlangvwid.getSectionCode() || getSectionCode() != null && ipnursingunitlangvwid.getSectionCode() != null && getSectionCode().equals(ipnursingunitlangvwid.getSectionCode()));
        }
    }

    public int hashCode()
    {
        int i = 17;
        i = 37 * i + (getFacilityId() != null ? getFacilityId().hashCode() : 0);
        i = 37 * i + (getNursingUnitCode() != null ? getNursingUnitCode().hashCode() : 0);
        i = 37 * i + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        i = 37 * i + (getOrdby() != null ? getOrdby().hashCode() : 0);
        i = 37 * i + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        i = 37 * i + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        i = 37 * i + (getNursingUnitTypeCode() != null ? getNursingUnitTypeCode().hashCode() : 0);
        i = 37 * i + (getLocnType() != null ? getLocnType().hashCode() : 0);
        i = 37 * i + (getAgeGroupCode() != null ? getAgeGroupCode().hashCode() : 0);
        i = 37 * i + (getDeptCode() != null ? getDeptCode().hashCode() : 0);
        i = 37 * i + (getServiceCode() != null ? getServiceCode().hashCode() : 0);
        i = 37 * i + (getServiceShortDesc() != null ? getServiceShortDesc().hashCode() : 0);
        i = 37 * i + (getFsLocnCode() != null ? getFsLocnCode().hashCode() : 0);
        i = 37 * i + (getInclForHospOccupCalcYn() != null ? getInclForHospOccupCalcYn().hashCode() : 0);
        i = 37 * i + (getAllowEmergTrfYn() != null ? getAllowEmergTrfYn().hashCode() : 0);
        i = 37 * i + (getTemporaryLocationYn() != null ? getTemporaryLocationYn().hashCode() : 0);
        i = 37 * i + (getTeachingLocationYn() != null ? getTeachingLocationYn().hashCode() : 0);
        i = 37 * i + (getAllowPseudoBedYn() != null ? getAllowPseudoBedYn().hashCode() : 0);
        i = 37 * i + (getGeneratePseudoBedSrlYn() != null ? getGeneratePseudoBedSrlYn().hashCode() : 0);
        i = 37 * i + (getCheckSameSexInRoomYn() != null ? getCheckSameSexInRoomYn().hashCode() : 0);
        i = 37 * i + (getPrefixForPseudoBedSrlNo() != null ? getPrefixForPseudoBedSrlNo().hashCode() : 0);
        i = 37 * i + (getNextPseudoBedSrl() != null ? getNextPseudoBedSrl().hashCode() : 0);
        i = 37 * i + (getMaxPseudoBedSrl() != null ? getMaxPseudoBedSrl().hashCode() : 0);
        i = 37 * i + (getNumOfBeds() != null ? getNumOfBeds().hashCode() : 0);
        i = 37 * i + (getNumOfPseudoBeds() != null ? getNumOfPseudoBeds().hashCode() : 0);
        i = 37 * i + (getNumOfBedsOccupied() != null ? getNumOfBedsOccupied().hashCode() : 0);
        i = 37 * i + (getOnlineMrNotfnYn() != null ? getOnlineMrNotfnYn().hashCode() : 0);
        i = 37 * i + (getAutoFileTransferYn() != null ? getAutoFileTransferYn().hashCode() : 0);
        i = 37 * i + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        i = 37 * i + (getAddedById() != null ? getAddedById().hashCode() : 0);
        i = 37 * i + (getAddedDate() != null ? getAddedDate().hashCode() : 0);
        i = 37 * i + (getAddedAtWsNo() != null ? getAddedAtWsNo().hashCode() : 0);
        i = 37 * i + (getAddedFacilityId() != null ? getAddedFacilityId().hashCode() : 0);
        i = 37 * i + (getModifiedById() != null ? getModifiedById().hashCode() : 0);
        i = 37 * i + (getModifiedDate() != null ? getModifiedDate().hashCode() : 0);
        i = 37 * i + (getModifiedAtWsNo() != null ? getModifiedAtWsNo().hashCode() : 0);
        i = 37 * i + (getModifiedFacilityId() != null ? getModifiedFacilityId().hashCode() : 0);
        i = 37 * i + (getAllowNewBornRegnYn() != null ? getAllowNewBornRegnYn().hashCode() : 0);
        i = 37 * i + (getPatientClass() != null ? getPatientClass().hashCode() : 0);
        i = 37 * i + (getDfltFileTypeCode() != null ? getDfltFileTypeCode().hashCode() : 0);
        i = 37 * i + (getLevelOfCareCode() != null ? getLevelOfCareCode().hashCode() : 0);
        i = 37 * i + (getMrSectionCode() != null ? getMrSectionCode().hashCode() : 0);
        i = 37 * i + (getMrSectionType() != null ? getMrSectionType().hashCode() : 0);
        i = 37 * i + (getReleaseBedOnLeaveYn() != null ? getReleaseBedOnLeaveYn().hashCode() : 0);
        i = 37 * i + (getSectionCode() != null ? getSectionCode().hashCode() : 0);
        return i;
    }

    private String facilityId;
    private String nursingUnitCode;
    private String languageId;
    private Long ordby;
    private String longDesc;
    private String shortDesc;
    private String nursingUnitTypeCode;
    private String locnType;
    private String ageGroupCode;
    private String deptCode;
    private String serviceCode;
    private String serviceShortDesc;
    private String fsLocnCode;
    private String inclForHospOccupCalcYn;
    private String allowEmergTrfYn;
    private String temporaryLocationYn;
    private String teachingLocationYn;
    private String allowPseudoBedYn;
    private String generatePseudoBedSrlYn;
    private String checkSameSexInRoomYn;
    private String prefixForPseudoBedSrlNo;
    private Long nextPseudoBedSrl;
    private Long maxPseudoBedSrl;
    private Long numOfBeds;
    private String numOfPseudoBeds;
    private Long numOfBedsOccupied;
    private String onlineMrNotfnYn;
    private String autoFileTransferYn;
    private String effStatus;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
    private String allowNewBornRegnYn;
    private String patientClass;
    private String dfltFileTypeCode;
    private String levelOfCareCode;
    private String mrSectionCode;
    private String mrSectionType;
    private String releaseBedOnLeaveYn;
    private String sectionCode;
}
