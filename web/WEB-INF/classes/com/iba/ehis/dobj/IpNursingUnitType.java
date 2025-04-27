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

public class IpNursingUnitType
    implements Serializable
{

    public IpNursingUnitType()
    {
        ipNursingUnits = new HashSet(0);
        ipBookingLists = new HashSet(0);
        ipMedSerGrpNursUtTypes = new HashSet(0);
    }

    public IpNursingUnitType(String nursingUnitTypeCode, String longDesc, String shortDesc, String effStatus, String addedById, Date addedDate, String addedAtWsNo, 
            String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId)
    {
        ipNursingUnits = new HashSet(0);
        ipBookingLists = new HashSet(0);
        ipMedSerGrpNursUtTypes = new HashSet(0);
        this.nursingUnitTypeCode = nursingUnitTypeCode;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
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

    public IpNursingUnitType(String nursingUnitTypeCode, String longDesc, String shortDesc, String effStatus, String addedById, Date addedDate, String addedAtWsNo, 
            String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, String nursingUnitTypeIndicator, Set ipNursingUnits, 
            Set ipBookingLists, Set ipMedSerGrpNursUtTypes)
    {
        this.ipNursingUnits = new HashSet(0);
        this.ipBookingLists = new HashSet(0);
        this.ipMedSerGrpNursUtTypes = new HashSet(0);
        this.nursingUnitTypeCode = nursingUnitTypeCode;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.nursingUnitTypeIndicator = nursingUnitTypeIndicator;
        this.ipNursingUnits = ipNursingUnits;
        this.ipBookingLists = ipBookingLists;
        this.ipMedSerGrpNursUtTypes = ipMedSerGrpNursUtTypes;
    }

    public String getNursingUnitTypeCode()
    {
        return nursingUnitTypeCode;
    }

    public void setNursingUnitTypeCode(String nursingUnitTypeCode)
    {
        this.nursingUnitTypeCode = nursingUnitTypeCode;
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

    public String getNursingUnitTypeIndicator()
    {
        return nursingUnitTypeIndicator;
    }

    public void setNursingUnitTypeIndicator(String nursingUnitTypeIndicator)
    {
        this.nursingUnitTypeIndicator = nursingUnitTypeIndicator;
    }

    public Set getIpNursingUnits()
    {
        return ipNursingUnits;
    }

    public void setIpNursingUnits(Set ipNursingUnits)
    {
        this.ipNursingUnits = ipNursingUnits;
    }

    public Set getIpBookingLists()
    {
        return ipBookingLists;
    }

    public void setIpBookingLists(Set ipBookingLists)
    {
        this.ipBookingLists = ipBookingLists;
    }

    public Set getIpMedSerGrpNursUtTypes()
    {
        return ipMedSerGrpNursUtTypes;
    }

    public void setIpMedSerGrpNursUtTypes(Set ipMedSerGrpNursUtTypes)
    {
        this.ipMedSerGrpNursUtTypes = ipMedSerGrpNursUtTypes;
    }

    private String nursingUnitTypeCode;
    private String longDesc;
    private String shortDesc;
    private String effStatus;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
    private String nursingUnitTypeIndicator;
    private Set ipNursingUnits;
    private Set ipBookingLists;
    private Set ipMedSerGrpNursUtTypes;
}
