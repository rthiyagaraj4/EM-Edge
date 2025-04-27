/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 8/25/2009 5:31:44 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LcLaundryStk.java

package com.iba.ehis.dobj;

import java.io.Serializable;
import java.util.Date;

// Referenced classes of package com.iba.ehis.dobj:
//            LcLaundryStkId

public class LcLaundryStk
    implements Serializable
{

    public LcLaundryStk()
    {
    }

    public LcLaundryStk(LcLaundryStkId id, String addedById, Date addedDate, String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, 
            String modifiedFacilityId, String modifiedAtWsNo)
    {
        this.id = id;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public LcLaundryStk(LcLaundryStkId id, Long withLaundryQty, Long issuedOutQty, Long inCleaningQty, Long inMendingQty, String addedById, Date addedDate, 
            String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo, Long writeOffQty)
    {
        this.id = id;
        this.withLaundryQty = withLaundryQty;
        this.issuedOutQty = issuedOutQty;
        this.inCleaningQty = inCleaningQty;
        this.inMendingQty = inMendingQty;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.writeOffQty = writeOffQty;
    }

    public LcLaundryStkId getId()
    {
        return id;
    }

    public void setId(LcLaundryStkId id)
    {
        this.id = id;
    }

    public Long getWithLaundryQty()
    {
        return withLaundryQty;
    }

    public void setWithLaundryQty(Long withLaundryQty)
    {
        this.withLaundryQty = withLaundryQty;
    }

    public Long getIssuedOutQty()
    {
        return issuedOutQty;
    }

    public void setIssuedOutQty(Long issuedOutQty)
    {
        this.issuedOutQty = issuedOutQty;
    }

    public Long getInCleaningQty()
    {
        return inCleaningQty;
    }

    public void setInCleaningQty(Long inCleaningQty)
    {
        this.inCleaningQty = inCleaningQty;
    }

    public Long getInMendingQty()
    {
        return inMendingQty;
    }

    public void setInMendingQty(Long inMendingQty)
    {
        this.inMendingQty = inMendingQty;
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

    public String getAddedFacilityId()
    {
        return addedFacilityId;
    }

    public void setAddedFacilityId(String addedFacilityId)
    {
        this.addedFacilityId = addedFacilityId;
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

    public String getModifiedFacilityId()
    {
        return modifiedFacilityId;
    }

    public void setModifiedFacilityId(String modifiedFacilityId)
    {
        this.modifiedFacilityId = modifiedFacilityId;
    }

    public String getModifiedAtWsNo()
    {
        return modifiedAtWsNo;
    }

    public void setModifiedAtWsNo(String modifiedAtWsNo)
    {
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public Long getWriteOffQty()
    {
        return writeOffQty;
    }

    public void setWriteOffQty(Long writeOffQty)
    {
        this.writeOffQty = writeOffQty;
    }

    private LcLaundryStkId id;
    private Long withLaundryQty;
    private Long issuedOutQty;
    private Long inCleaningQty;
    private Long inMendingQty;
    private String addedById;
    private Date addedDate;
    private String addedFacilityId;
    private String addedAtWsNo;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedFacilityId;
    private String modifiedAtWsNo;
    private Long writeOffQty;
}
