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
//            IpNursingUnitId, IpNursingUnitType

public class IpNursingUnit
    implements Serializable
{

    public IpNursingUnit()
    {
        ipBedClassRequestsForIpBedClassRequestF2 = new HashSet(0);
        ipPatientLastEncounters = new HashSet(0);
        ipAdtTrnAuditLogs = new HashSet(0);
        ipAdtTrnsForIpAdtTrnF10 = new HashSet(0);
        ipNursingUnitRooms = new HashSet(0);
        ipNursingUnitForPracts = new HashSet(0);
        ipBedBookings = new HashSet(0);
        ipOpenEncounters = new HashSet(0);
        ipBookLimitByNursUts = new HashSet(0);
        ipNursingUnitBeds = new HashSet(0);
        ipBedClassRequestsForIpBedClassRequestF3 = new HashSet(0);
        ipNursUnitForServices = new HashSet(0);
        ipNursingUnitLocations = new HashSet(0);
        ipDcUnitForNursUnits = new HashSet(0);
        ipBedClassRequestsForIpBedClassRequestF4 = new HashSet(0);
        ipAdtTrnsForIpAdtTrnF3 = new HashSet(0);
        ipDlyNursUtBkgStats = new HashSet(0);
        ipBookingLists = new HashSet(0);
    }

    public IpNursingUnit(IpNursingUnitId id, IpNursingUnitType ipNursingUnitType, String longDesc, String shortDesc, String locnType, String deptCode, String serviceCode, 
            String inclForHospOccupCalcYn, String allowEmergTrfYn, String temporaryLocationYn, String teachingLocationYn, String allowPseudoBedYn, String generatePseudoBedSrlYn, String checkSameSexInRoomYn, 
            Long numOfBeds, String onlineMrNotfnYn, String autoFileTransferYn, String effStatus, String addedById, Date addedDate, String addedAtWsNo, 
            String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, String allowNewBornRegnYn, String applPatientClass, 
            String releaseBedOnLeaveYn)
    {
        ipBedClassRequestsForIpBedClassRequestF2 = new HashSet(0);
        ipPatientLastEncounters = new HashSet(0);
        ipAdtTrnAuditLogs = new HashSet(0);
        ipAdtTrnsForIpAdtTrnF10 = new HashSet(0);
        ipNursingUnitRooms = new HashSet(0);
        ipNursingUnitForPracts = new HashSet(0);
        ipBedBookings = new HashSet(0);
        ipOpenEncounters = new HashSet(0);
        ipBookLimitByNursUts = new HashSet(0);
        ipNursingUnitBeds = new HashSet(0);
        ipBedClassRequestsForIpBedClassRequestF3 = new HashSet(0);
        ipNursUnitForServices = new HashSet(0);
        ipNursingUnitLocations = new HashSet(0);
        ipDcUnitForNursUnits = new HashSet(0);
        ipBedClassRequestsForIpBedClassRequestF4 = new HashSet(0);
        ipAdtTrnsForIpAdtTrnF3 = new HashSet(0);
        ipDlyNursUtBkgStats = new HashSet(0);
        ipBookingLists = new HashSet(0);
        this.id = id;
        this.ipNursingUnitType = ipNursingUnitType;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.locnType = locnType;
        this.deptCode = deptCode;
        this.serviceCode = serviceCode;
        this.inclForHospOccupCalcYn = inclForHospOccupCalcYn;
        this.allowEmergTrfYn = allowEmergTrfYn;
        this.temporaryLocationYn = temporaryLocationYn;
        this.teachingLocationYn = teachingLocationYn;
        this.allowPseudoBedYn = allowPseudoBedYn;
        this.generatePseudoBedSrlYn = generatePseudoBedSrlYn;
        this.checkSameSexInRoomYn = checkSameSexInRoomYn;
        this.numOfBeds = numOfBeds;
        this.onlineMrNotfnYn = onlineMrNotfnYn;
        this.autoFileTransferYn = autoFileTransferYn;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.allowNewBornRegnYn = allowNewBornRegnYn;
        this.applPatientClass = applPatientClass;
        this.releaseBedOnLeaveYn = releaseBedOnLeaveYn;
    }

    public IpNursingUnit(IpNursingUnitId id, IpNursingUnitType ipNursingUnitType, String longDesc, String shortDesc, String locnType, String ageGroupCode, String deptCode, 
            String serviceCode, String fsLocnCode, String levelOfCareInd, String inclForHospOccupCalcYn, String allowEmergTrfYn, String temporaryLocationYn, String teachingLocationYn, 
            String allowPseudoBedYn, String generatePseudoBedSrlYn, String checkSameSexInRoomYn, String prefixForPseudoBedSrlNo, Long nextPseudoBedSrl, Long maxPseudoBedSrl, Long numOfBeds, 
            String numOfPseudoBeds, Long numOfBedsOccupied, String onlineMrNotfnYn, String autoFileTransferYn, String effStatus, String addedById, Date addedDate, 
            String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, String allowNewBornRegnYn, 
            String applPatientClass, String dfltFileTypeCode, String levelOfCareCode, String mrSectionCode, String mrSectionType, String releaseBedOnLeaveYn, String sectionCode, 
            Set ipBedClassRequestsForIpBedClassRequestF2, Set ipPatientLastEncounters, Set ipAdtTrnAuditLogs, Set ipAdtTrnsForIpAdtTrnF10, Set ipNursingUnitRooms, Set ipNursingUnitForPracts, Set ipBedBookings, 
            Set ipOpenEncounters, Set ipBookLimitByNursUts, Set ipNursingUnitBeds, Set ipBedClassRequestsForIpBedClassRequestF3, Set ipNursUnitForServices, Set ipNursingUnitLocations, Set ipDcUnitForNursUnits, 
            Set ipBedClassRequestsForIpBedClassRequestF4, Set ipAdtTrnsForIpAdtTrnF3, Set ipDlyNursUtBkgStats, Set ipBookingLists)
    {
        this.ipBedClassRequestsForIpBedClassRequestF2 = new HashSet(0);
        this.ipPatientLastEncounters = new HashSet(0);
        this.ipAdtTrnAuditLogs = new HashSet(0);
        this.ipAdtTrnsForIpAdtTrnF10 = new HashSet(0);
        this.ipNursingUnitRooms = new HashSet(0);
        this.ipNursingUnitForPracts = new HashSet(0);
        this.ipBedBookings = new HashSet(0);
        this.ipOpenEncounters = new HashSet(0);
        this.ipBookLimitByNursUts = new HashSet(0);
        this.ipNursingUnitBeds = new HashSet(0);
        this.ipBedClassRequestsForIpBedClassRequestF3 = new HashSet(0);
        this.ipNursUnitForServices = new HashSet(0);
        this.ipNursingUnitLocations = new HashSet(0);
        this.ipDcUnitForNursUnits = new HashSet(0);
        this.ipBedClassRequestsForIpBedClassRequestF4 = new HashSet(0);
        this.ipAdtTrnsForIpAdtTrnF3 = new HashSet(0);
        this.ipDlyNursUtBkgStats = new HashSet(0);
        this.ipBookingLists = new HashSet(0);
        this.id = id;
        this.ipNursingUnitType = ipNursingUnitType;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.locnType = locnType;
        this.ageGroupCode = ageGroupCode;
        this.deptCode = deptCode;
        this.serviceCode = serviceCode;
        this.fsLocnCode = fsLocnCode;
        this.levelOfCareInd = levelOfCareInd;
        this.inclForHospOccupCalcYn = inclForHospOccupCalcYn;
        this.allowEmergTrfYn = allowEmergTrfYn;
        this.temporaryLocationYn = temporaryLocationYn;
        this.teachingLocationYn = teachingLocationYn;
        this.allowPseudoBedYn = allowPseudoBedYn;
        this.generatePseudoBedSrlYn = generatePseudoBedSrlYn;
        this.checkSameSexInRoomYn = checkSameSexInRoomYn;
        this.prefixForPseudoBedSrlNo = prefixForPseudoBedSrlNo;
        this.nextPseudoBedSrl = nextPseudoBedSrl;
        this.maxPseudoBedSrl = maxPseudoBedSrl;
        this.numOfBeds = numOfBeds;
        this.numOfPseudoBeds = numOfPseudoBeds;
        this.numOfBedsOccupied = numOfBedsOccupied;
        this.onlineMrNotfnYn = onlineMrNotfnYn;
        this.autoFileTransferYn = autoFileTransferYn;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.allowNewBornRegnYn = allowNewBornRegnYn;
        this.applPatientClass = applPatientClass;
        this.dfltFileTypeCode = dfltFileTypeCode;
        this.levelOfCareCode = levelOfCareCode;
        this.mrSectionCode = mrSectionCode;
        this.mrSectionType = mrSectionType;
        this.releaseBedOnLeaveYn = releaseBedOnLeaveYn;
        this.sectionCode = sectionCode;
        this.ipBedClassRequestsForIpBedClassRequestF2 = ipBedClassRequestsForIpBedClassRequestF2;
        this.ipPatientLastEncounters = ipPatientLastEncounters;
        this.ipAdtTrnAuditLogs = ipAdtTrnAuditLogs;
        this.ipAdtTrnsForIpAdtTrnF10 = ipAdtTrnsForIpAdtTrnF10;
        this.ipNursingUnitRooms = ipNursingUnitRooms;
        this.ipNursingUnitForPracts = ipNursingUnitForPracts;
        this.ipBedBookings = ipBedBookings;
        this.ipOpenEncounters = ipOpenEncounters;
        this.ipBookLimitByNursUts = ipBookLimitByNursUts;
        this.ipNursingUnitBeds = ipNursingUnitBeds;
        this.ipBedClassRequestsForIpBedClassRequestF3 = ipBedClassRequestsForIpBedClassRequestF3;
        this.ipNursUnitForServices = ipNursUnitForServices;
        this.ipNursingUnitLocations = ipNursingUnitLocations;
        this.ipDcUnitForNursUnits = ipDcUnitForNursUnits;
        this.ipBedClassRequestsForIpBedClassRequestF4 = ipBedClassRequestsForIpBedClassRequestF4;
        this.ipAdtTrnsForIpAdtTrnF3 = ipAdtTrnsForIpAdtTrnF3;
        this.ipDlyNursUtBkgStats = ipDlyNursUtBkgStats;
        this.ipBookingLists = ipBookingLists;
    }

    public IpNursingUnitId getId()
    {
        return id;
    }

    public void setId(IpNursingUnitId id)
    {
        this.id = id;
    }

    public IpNursingUnitType getIpNursingUnitType()
    {
        return ipNursingUnitType;
    }

    public void setIpNursingUnitType(IpNursingUnitType ipNursingUnitType)
    {
        this.ipNursingUnitType = ipNursingUnitType;
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

    public String getLocnType()
    {
        return locnType;
    }

    public void setLocnType(String locnType)
    {
        this.locnType = locnType;
    }

    public String getAgeGroupCode()
    {
        return ageGroupCode;
    }

    public void setAgeGroupCode(String ageGroupCode)
    {
        this.ageGroupCode = ageGroupCode;
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

    public String getFsLocnCode()
    {
        return fsLocnCode;
    }

    public void setFsLocnCode(String fsLocnCode)
    {
        this.fsLocnCode = fsLocnCode;
    }

    public String getLevelOfCareInd()
    {
        return levelOfCareInd;
    }

    public void setLevelOfCareInd(String levelOfCareInd)
    {
        this.levelOfCareInd = levelOfCareInd;
    }

    public String getInclForHospOccupCalcYn()
    {
        return inclForHospOccupCalcYn;
    }

    public void setInclForHospOccupCalcYn(String inclForHospOccupCalcYn)
    {
        this.inclForHospOccupCalcYn = inclForHospOccupCalcYn;
    }

    public String getAllowEmergTrfYn()
    {
        return allowEmergTrfYn;
    }

    public void setAllowEmergTrfYn(String allowEmergTrfYn)
    {
        this.allowEmergTrfYn = allowEmergTrfYn;
    }

    public String getTemporaryLocationYn()
    {
        return temporaryLocationYn;
    }

    public void setTemporaryLocationYn(String temporaryLocationYn)
    {
        this.temporaryLocationYn = temporaryLocationYn;
    }

    public String getTeachingLocationYn()
    {
        return teachingLocationYn;
    }

    public void setTeachingLocationYn(String teachingLocationYn)
    {
        this.teachingLocationYn = teachingLocationYn;
    }

    public String getAllowPseudoBedYn()
    {
        return allowPseudoBedYn;
    }

    public void setAllowPseudoBedYn(String allowPseudoBedYn)
    {
        this.allowPseudoBedYn = allowPseudoBedYn;
    }

    public String getGeneratePseudoBedSrlYn()
    {
        return generatePseudoBedSrlYn;
    }

    public void setGeneratePseudoBedSrlYn(String generatePseudoBedSrlYn)
    {
        this.generatePseudoBedSrlYn = generatePseudoBedSrlYn;
    }

    public String getCheckSameSexInRoomYn()
    {
        return checkSameSexInRoomYn;
    }

    public void setCheckSameSexInRoomYn(String checkSameSexInRoomYn)
    {
        this.checkSameSexInRoomYn = checkSameSexInRoomYn;
    }

    public String getPrefixForPseudoBedSrlNo()
    {
        return prefixForPseudoBedSrlNo;
    }

    public void setPrefixForPseudoBedSrlNo(String prefixForPseudoBedSrlNo)
    {
        this.prefixForPseudoBedSrlNo = prefixForPseudoBedSrlNo;
    }

    public Long getNextPseudoBedSrl()
    {
        return nextPseudoBedSrl;
    }

    public void setNextPseudoBedSrl(Long nextPseudoBedSrl)
    {
        this.nextPseudoBedSrl = nextPseudoBedSrl;
    }

    public Long getMaxPseudoBedSrl()
    {
        return maxPseudoBedSrl;
    }

    public void setMaxPseudoBedSrl(Long maxPseudoBedSrl)
    {
        this.maxPseudoBedSrl = maxPseudoBedSrl;
    }

    public Long getNumOfBeds()
    {
        return numOfBeds;
    }

    public void setNumOfBeds(Long numOfBeds)
    {
        this.numOfBeds = numOfBeds;
    }

    public String getNumOfPseudoBeds()
    {
        return numOfPseudoBeds;
    }

    public void setNumOfPseudoBeds(String numOfPseudoBeds)
    {
        this.numOfPseudoBeds = numOfPseudoBeds;
    }

    public Long getNumOfBedsOccupied()
    {
        return numOfBedsOccupied;
    }

    public void setNumOfBedsOccupied(Long numOfBedsOccupied)
    {
        this.numOfBedsOccupied = numOfBedsOccupied;
    }

    public String getOnlineMrNotfnYn()
    {
        return onlineMrNotfnYn;
    }

    public void setOnlineMrNotfnYn(String onlineMrNotfnYn)
    {
        this.onlineMrNotfnYn = onlineMrNotfnYn;
    }

    public String getAutoFileTransferYn()
    {
        return autoFileTransferYn;
    }

    public void setAutoFileTransferYn(String autoFileTransferYn)
    {
        this.autoFileTransferYn = autoFileTransferYn;
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

    public String getAllowNewBornRegnYn()
    {
        return allowNewBornRegnYn;
    }

    public void setAllowNewBornRegnYn(String allowNewBornRegnYn)
    {
        this.allowNewBornRegnYn = allowNewBornRegnYn;
    }

    public String getApplPatientClass()
    {
        return applPatientClass;
    }

    public void setApplPatientClass(String applPatientClass)
    {
        this.applPatientClass = applPatientClass;
    }

    public String getDfltFileTypeCode()
    {
        return dfltFileTypeCode;
    }

    public void setDfltFileTypeCode(String dfltFileTypeCode)
    {
        this.dfltFileTypeCode = dfltFileTypeCode;
    }

    public String getLevelOfCareCode()
    {
        return levelOfCareCode;
    }

    public void setLevelOfCareCode(String levelOfCareCode)
    {
        this.levelOfCareCode = levelOfCareCode;
    }

    public String getMrSectionCode()
    {
        return mrSectionCode;
    }

    public void setMrSectionCode(String mrSectionCode)
    {
        this.mrSectionCode = mrSectionCode;
    }

    public String getMrSectionType()
    {
        return mrSectionType;
    }

    public void setMrSectionType(String mrSectionType)
    {
        this.mrSectionType = mrSectionType;
    }

    public String getReleaseBedOnLeaveYn()
    {
        return releaseBedOnLeaveYn;
    }

    public void setReleaseBedOnLeaveYn(String releaseBedOnLeaveYn)
    {
        this.releaseBedOnLeaveYn = releaseBedOnLeaveYn;
    }

    public String getSectionCode()
    {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode)
    {
        this.sectionCode = sectionCode;
    }

    public Set getIpBedClassRequestsForIpBedClassRequestF2()
    {
        return ipBedClassRequestsForIpBedClassRequestF2;
    }

    public void setIpBedClassRequestsForIpBedClassRequestF2(Set ipBedClassRequestsForIpBedClassRequestF2)
    {
        this.ipBedClassRequestsForIpBedClassRequestF2 = ipBedClassRequestsForIpBedClassRequestF2;
    }

    public Set getIpPatientLastEncounters()
    {
        return ipPatientLastEncounters;
    }

    public void setIpPatientLastEncounters(Set ipPatientLastEncounters)
    {
        this.ipPatientLastEncounters = ipPatientLastEncounters;
    }

    public Set getIpAdtTrnAuditLogs()
    {
        return ipAdtTrnAuditLogs;
    }

    public void setIpAdtTrnAuditLogs(Set ipAdtTrnAuditLogs)
    {
        this.ipAdtTrnAuditLogs = ipAdtTrnAuditLogs;
    }

    public Set getIpAdtTrnsForIpAdtTrnF10()
    {
        return ipAdtTrnsForIpAdtTrnF10;
    }

    public void setIpAdtTrnsForIpAdtTrnF10(Set ipAdtTrnsForIpAdtTrnF10)
    {
        this.ipAdtTrnsForIpAdtTrnF10 = ipAdtTrnsForIpAdtTrnF10;
    }

    public Set getIpNursingUnitRooms()
    {
        return ipNursingUnitRooms;
    }

    public void setIpNursingUnitRooms(Set ipNursingUnitRooms)
    {
        this.ipNursingUnitRooms = ipNursingUnitRooms;
    }

    public Set getIpNursingUnitForPracts()
    {
        return ipNursingUnitForPracts;
    }

    public void setIpNursingUnitForPracts(Set ipNursingUnitForPracts)
    {
        this.ipNursingUnitForPracts = ipNursingUnitForPracts;
    }

    public Set getIpBedBookings()
    {
        return ipBedBookings;
    }

    public void setIpBedBookings(Set ipBedBookings)
    {
        this.ipBedBookings = ipBedBookings;
    }

    public Set getIpOpenEncounters()
    {
        return ipOpenEncounters;
    }

    public void setIpOpenEncounters(Set ipOpenEncounters)
    {
        this.ipOpenEncounters = ipOpenEncounters;
    }

    public Set getIpBookLimitByNursUts()
    {
        return ipBookLimitByNursUts;
    }

    public void setIpBookLimitByNursUts(Set ipBookLimitByNursUts)
    {
        this.ipBookLimitByNursUts = ipBookLimitByNursUts;
    }

    public Set getIpNursingUnitBeds()
    {
        return ipNursingUnitBeds;
    }

    public void setIpNursingUnitBeds(Set ipNursingUnitBeds)
    {
        this.ipNursingUnitBeds = ipNursingUnitBeds;
    }

    public Set getIpBedClassRequestsForIpBedClassRequestF3()
    {
        return ipBedClassRequestsForIpBedClassRequestF3;
    }

    public void setIpBedClassRequestsForIpBedClassRequestF3(Set ipBedClassRequestsForIpBedClassRequestF3)
    {
        this.ipBedClassRequestsForIpBedClassRequestF3 = ipBedClassRequestsForIpBedClassRequestF3;
    }

    public Set getIpNursUnitForServices()
    {
        return ipNursUnitForServices;
    }

    public void setIpNursUnitForServices(Set ipNursUnitForServices)
    {
        this.ipNursUnitForServices = ipNursUnitForServices;
    }

    public Set getIpNursingUnitLocations()
    {
        return ipNursingUnitLocations;
    }

    public void setIpNursingUnitLocations(Set ipNursingUnitLocations)
    {
        this.ipNursingUnitLocations = ipNursingUnitLocations;
    }

    public Set getIpDcUnitForNursUnits()
    {
        return ipDcUnitForNursUnits;
    }

    public void setIpDcUnitForNursUnits(Set ipDcUnitForNursUnits)
    {
        this.ipDcUnitForNursUnits = ipDcUnitForNursUnits;
    }

    public Set getIpBedClassRequestsForIpBedClassRequestF4()
    {
        return ipBedClassRequestsForIpBedClassRequestF4;
    }

    public void setIpBedClassRequestsForIpBedClassRequestF4(Set ipBedClassRequestsForIpBedClassRequestF4)
    {
        this.ipBedClassRequestsForIpBedClassRequestF4 = ipBedClassRequestsForIpBedClassRequestF4;
    }

    public Set getIpAdtTrnsForIpAdtTrnF3()
    {
        return ipAdtTrnsForIpAdtTrnF3;
    }

    public void setIpAdtTrnsForIpAdtTrnF3(Set ipAdtTrnsForIpAdtTrnF3)
    {
        this.ipAdtTrnsForIpAdtTrnF3 = ipAdtTrnsForIpAdtTrnF3;
    }

    public Set getIpDlyNursUtBkgStats()
    {
        return ipDlyNursUtBkgStats;
    }

    public void setIpDlyNursUtBkgStats(Set ipDlyNursUtBkgStats)
    {
        this.ipDlyNursUtBkgStats = ipDlyNursUtBkgStats;
    }

    public Set getIpBookingLists()
    {
        return ipBookingLists;
    }

    public void setIpBookingLists(Set ipBookingLists)
    {
        this.ipBookingLists = ipBookingLists;
    }

    private IpNursingUnitId id;
    private IpNursingUnitType ipNursingUnitType;
    private String longDesc;
    private String shortDesc;
    private String locnType;
    private String ageGroupCode;
    private String deptCode;
    private String serviceCode;
    private String fsLocnCode;
    private String levelOfCareInd;
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
    private String applPatientClass;
    private String dfltFileTypeCode;
    private String levelOfCareCode;
    private String mrSectionCode;
    private String mrSectionType;
    private String releaseBedOnLeaveYn;
    private String sectionCode;
    private Set ipBedClassRequestsForIpBedClassRequestF2;
    private Set ipPatientLastEncounters;
    private Set ipAdtTrnAuditLogs;
    private Set ipAdtTrnsForIpAdtTrnF10;
    private Set ipNursingUnitRooms;
    private Set ipNursingUnitForPracts;
    private Set ipBedBookings;
    private Set ipOpenEncounters;
    private Set ipBookLimitByNursUts;
    private Set ipNursingUnitBeds;
    private Set ipBedClassRequestsForIpBedClassRequestF3;
    private Set ipNursUnitForServices;
    private Set ipNursingUnitLocations;
    private Set ipDcUnitForNursUnits;
    private Set ipBedClassRequestsForIpBedClassRequestF4;
    private Set ipAdtTrnsForIpAdtTrnF3;
    private Set ipDlyNursUtBkgStats;
    private Set ipBookingLists;
}
