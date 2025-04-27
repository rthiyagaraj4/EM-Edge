/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 8/25/2009 5:31:46 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LcSourceStk.java

package com.iba.ehis.dobj;

import java.io.Serializable;
import java.util.Date;

// Referenced classes of package com.iba.ehis.dobj:
//            LcSourceStkId

public class LcSourceStk
    implements Serializable
{

    public LcSourceStk()
    {
    }

    public LcSourceStk(LcSourceStkId id, String sourceType, String sourceCode, String addedById, Date addedDate, String addedFacilityId, String addedAtWsNo, 
            String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo)
    {
        this.id = id;
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public LcSourceStk(LcSourceStkId id, String sourceType, String sourceCode, Long inUseQty, Long soiledQty, Long loanedQty, String addedById, 
            Date addedDate, String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo)
    {
        this.id = id;
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.inUseQty = inUseQty;
        this.soiledQty = soiledQty;
        this.loanedQty = loanedQty;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public LcSourceStkId getId()
    {
        return id;
    }

    public void setId(LcSourceStkId id)
    {
        this.id = id;
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

    public Long getInUseQty()
    {
        return inUseQty;
    }

    public void setInUseQty(Long inUseQty)
    {
        this.inUseQty = inUseQty;
    }

    public Long getSoiledQty()
    {
        return soiledQty;
    }

    public void setSoiledQty(Long soiledQty)
    {
        this.soiledQty = soiledQty;
    }

    public Long getLoanedQty()
    {
        return loanedQty;
    }

    public void setLoanedQty(Long loanedQty)
    {
        this.loanedQty = loanedQty;
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

    private LcSourceStkId id;
    private String sourceType;
    private String sourceCode;
    private Long inUseQty;
    private Long soiledQty;
    private Long loanedQty;
    private String addedById;
    private Date addedDate;
    private String addedFacilityId;
    private String addedAtWsNo;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedFacilityId;
    private String modifiedAtWsNo;
}
