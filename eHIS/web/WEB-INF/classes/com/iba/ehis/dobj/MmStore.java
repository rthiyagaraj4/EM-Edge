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
//            SmFacilityParam

public class MmStore
    implements Serializable
{

    public MmStore()
    {
        stStores = new HashSet(0);
        ssStores = new HashSet(0);
    }

    public MmStore(String storeCode, SmFacilityParam smFacilityParam, String longDesc, String shortDesc, String externalYn, String effStatus, String addedById, 
            Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId)
    {
        stStores = new HashSet(0);
        ssStores = new HashSet(0);
        this.storeCode = storeCode;
        this.smFacilityParam = smFacilityParam;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.externalYn = externalYn;
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

    public MmStore(String storeCode, SmFacilityParam smFacilityParam, String longDesc, String shortDesc, String deptCode, String externalYn, String custCode, 
            String storeInchargeName, String storeInchargeTitle, String storeLocation, String contactRef, String effStatus, String addedById, Date addedDate, 
            String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, Set stStores, 
            Set ssStores)
    {
        this.stStores = new HashSet(0);
        this.ssStores = new HashSet(0);
        this.storeCode = storeCode;
        this.smFacilityParam = smFacilityParam;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.deptCode = deptCode;
        this.externalYn = externalYn;
        this.custCode = custCode;
        this.storeInchargeName = storeInchargeName;
        this.storeInchargeTitle = storeInchargeTitle;
        this.storeLocation = storeLocation;
        this.contactRef = contactRef;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.stStores = stStores;
        this.ssStores = ssStores;
    }

    public String getStoreCode()
    {
        return storeCode;
    }

    public void setStoreCode(String storeCode)
    {
        this.storeCode = storeCode;
    }

    public SmFacilityParam getSmFacilityParam()
    {
        return smFacilityParam;
    }

    public void setSmFacilityParam(SmFacilityParam smFacilityParam)
    {
        this.smFacilityParam = smFacilityParam;
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

    public String getDeptCode()
    {
        return deptCode;
    }

    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }

    public String getExternalYn()
    {
        return externalYn;
    }

    public void setExternalYn(String externalYn)
    {
        this.externalYn = externalYn;
    }

    public String getCustCode()
    {
        return custCode;
    }

    public void setCustCode(String custCode)
    {
        this.custCode = custCode;
    }

    public String getStoreInchargeName()
    {
        return storeInchargeName;
    }

    public void setStoreInchargeName(String storeInchargeName)
    {
        this.storeInchargeName = storeInchargeName;
    }

    public String getStoreInchargeTitle()
    {
        return storeInchargeTitle;
    }

    public void setStoreInchargeTitle(String storeInchargeTitle)
    {
        this.storeInchargeTitle = storeInchargeTitle;
    }

    public String getStoreLocation()
    {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation)
    {
        this.storeLocation = storeLocation;
    }

    public String getContactRef()
    {
        return contactRef;
    }

    public void setContactRef(String contactRef)
    {
        this.contactRef = contactRef;
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

    public Set getStStores()
    {
        return stStores;
    }

    public void setStStores(Set stStores)
    {
        this.stStores = stStores;
    }

    public Set getSsStores()
    {
        return ssStores;
    }

    public void setSsStores(Set ssStores)
    {
        this.ssStores = ssStores;
    }

    private String storeCode;
    private SmFacilityParam smFacilityParam;
    private String longDesc;
    private String shortDesc;
    private String deptCode;
    private String externalYn;
    private String custCode;
    private String storeInchargeName;
    private String storeInchargeTitle;
    private String storeLocation;
    private String contactRef;
    private String effStatus;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
    private Set stStores;
    private Set ssStores;
}
