/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 2/18/2009 10:50:47 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LcWriteOff.java

package com.iba.ehis.dobj;

import java.io.Serializable;
import java.util.Date;

// Referenced classes of package com.iba.ehis.dobj:
//            LcWriteOffId, LcReason, LcLinenItem

public class LcWriteOff
    implements Serializable
{

    public LcWriteOff()
    {
    }

    public LcWriteOff(LcWriteOffId id, LcReason lcReason, LcLinenItem lcLinenItem, String sourceType, String linenType, Long writeOffQty, String addedById, 
            Date addedDate, String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo)
    {
        this.id = id;
        this.lcReason = lcReason;
        this.lcLinenItem = lcLinenItem;
        this.sourceType = sourceType;
        this.linenType = linenType;
        this.writeOffQty = writeOffQty;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public LcWriteOff(LcWriteOffId id, LcReason lcReason, LcLinenItem lcLinenItem, String sourceType, String sourceCode, String linenType, Long writeOffQty, 
            String remarks, String addedById, Date addedDate, String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, 
            String modifiedFacilityId, String modifiedAtWsNo, Date writeOffDate)
    {
        this.id = id;
        this.lcReason = lcReason;
        this.lcLinenItem = lcLinenItem;
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.linenType = linenType;
        this.writeOffQty = writeOffQty;
        this.remarks = remarks;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.writeOffDate = writeOffDate;
    }

    public LcWriteOffId getId()
    {
        return id;
    }

    public void setId(LcWriteOffId id)
    {
        this.id = id;
    }

    public LcReason getLcReason()
    {
        return lcReason;
    }

    public void setLcReason(LcReason lcReason)
    {
        this.lcReason = lcReason;
    }

    public LcLinenItem getLcLinenItem()
    {
        return lcLinenItem;
    }

    public void setLcLinenItem(LcLinenItem lcLinenItem)
    {
        this.lcLinenItem = lcLinenItem;
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

    public String getLinenType()
    {
        return linenType;
    }

    public void setLinenType(String linenType)
    {
        this.linenType = linenType;
    }

    public Long getWriteOffQty()
    {
        return writeOffQty;
    }

    public void setWriteOffQty(Long writeOffQty)
    {
        this.writeOffQty = writeOffQty;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
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

    public Date getWriteOffDate()
    {
        return writeOffDate;
    }

    public void setWriteOffDate(Date writeOffDate)
    {
        this.writeOffDate = writeOffDate;
    }

    private LcWriteOffId id;
    private LcReason lcReason;
    private LcLinenItem lcLinenItem;
    private String sourceType;
    private String sourceCode;
    private String linenType;
    private Long writeOffQty;
    private String remarks;
    private String addedById;
    private Date addedDate;
    private String addedFacilityId;
    private String addedAtWsNo;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedFacilityId;
    private String modifiedAtWsNo;
    private Date writeOffDate;
}
