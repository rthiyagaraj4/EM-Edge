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
// Source File Name:   LcStdLinenQtyVwId.java

package com.iba.ehis.dobj;

import java.io.Serializable;

public class LcStdLinenQtyVwId
    implements Serializable
{

    public LcStdLinenQtyVwId()
    {
    }

    public LcStdLinenQtyVwId(String operatingFacilityId, String languageId, String sourceType, String sourceCode, String sourceDesc, String linenItem, Long stdQty)
    {
        this.operatingFacilityId = operatingFacilityId;
        this.languageId = languageId;
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.sourceDesc = sourceDesc;
        this.linenItem = linenItem;
        this.stdQty = stdQty;
    }

    public LcStdLinenQtyVwId(String operatingFacilityId, String languageId, String sourceType, String sourceCode, String sourceDesc, String linenItem, Long stdQty, 
            String longDesc, String shortDesc, String linenTypeCode, String disposableItem, String effStatus)
    {
        this.operatingFacilityId = operatingFacilityId;
        this.languageId = languageId;
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.sourceDesc = sourceDesc;
        this.linenItem = linenItem;
        this.stdQty = stdQty;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.linenTypeCode = linenTypeCode;
        this.disposableItem = disposableItem;
        this.effStatus = effStatus;
    }

    public String getOperatingFacilityId()
    {
        return operatingFacilityId;
    }

    public void setOperatingFacilityId(String operatingFacilityId)
    {
        this.operatingFacilityId = operatingFacilityId;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
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

    public String getLinenItem()
    {
        return linenItem;
    }

    public void setLinenItem(String linenItem)
    {
        this.linenItem = linenItem;
    }

    public Long getStdQty()
    {
        return stdQty;
    }

    public void setStdQty(Long stdQty)
    {
        this.stdQty = stdQty;
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

    public String getLinenTypeCode()
    {
        return linenTypeCode;
    }

    public void setLinenTypeCode(String linenTypeCode)
    {
        this.linenTypeCode = linenTypeCode;
    }

    public String getDisposableItem()
    {
        return disposableItem;
    }

    public void setDisposableItem(String disposableItem)
    {
        this.disposableItem = disposableItem;
    }

    public String getEffStatus()
    {
        return effStatus;
    }

    public void setEffStatus(String effStatus)
    {
        this.effStatus = effStatus;
    }

    public String getSourceDesc()
    {
        return sourceDesc;
    }

    public void setSourceDesc(String sourceDesc)
    {
        this.sourceDesc = sourceDesc;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof LcStdLinenQtyVwId))
            return false;
        LcStdLinenQtyVwId castOther = (LcStdLinenQtyVwId)other;
        return (getOperatingFacilityId() == castOther.getOperatingFacilityId() || getOperatingFacilityId() != null && castOther.getOperatingFacilityId() != null && getOperatingFacilityId().equals(castOther.getOperatingFacilityId())) && (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getSourceType() == castOther.getSourceType() || getSourceType() != null && castOther.getSourceType() != null && getSourceType().equals(castOther.getSourceType())) && (getSourceCode() == castOther.getSourceCode() || getSourceCode() != null && castOther.getSourceCode() != null && getSourceCode().equals(castOther.getSourceCode())) && (getSourceDesc() == castOther.getSourceDesc() || getSourceDesc() != null && castOther.getSourceDesc() != null && getSourceDesc().equals(castOther.getSourceDesc())) && (getLinenItem() == castOther.getLinenItem() || getLinenItem() != null && castOther.getLinenItem() != null && getLinenItem().equals(castOther.getLinenItem())) && (getStdQty() == castOther.getStdQty() || getStdQty() != null && castOther.getStdQty() != null && getStdQty().equals(castOther.getStdQty())) && (getLongDesc() == castOther.getLongDesc() || getLongDesc() != null && castOther.getLongDesc() != null && getLongDesc().equals(castOther.getLongDesc())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getLinenTypeCode() == castOther.getLinenTypeCode() || getLinenTypeCode() != null && castOther.getLinenTypeCode() != null && getLinenTypeCode().equals(castOther.getLinenTypeCode())) && (getDisposableItem() == castOther.getDisposableItem() || getDisposableItem() != null && castOther.getDisposableItem() != null && getDisposableItem().equals(castOther.getDisposableItem())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getOperatingFacilityId() != null ? getOperatingFacilityId().hashCode() : 0);
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getSourceType() != null ? getSourceType().hashCode() : 0);
        result = 37 * result + (getSourceCode() != null ? getSourceCode().hashCode() : 0);
        result = 37 * result + (getSourceDesc() != null ? getSourceDesc().hashCode() : 0);
        result = 37 * result + (getLinenItem() != null ? getLinenItem().hashCode() : 0);
        result = 37 * result + (getStdQty() != null ? getStdQty().hashCode() : 0);
        result = 37 * result + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getLinenTypeCode() != null ? getLinenTypeCode().hashCode() : 0);
        result = 37 * result + (getDisposableItem() != null ? getDisposableItem().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        return result;
    }

    private String operatingFacilityId;
    private String languageId;
    private String sourceType;
    private String sourceCode;
    private String sourceDesc;
    private String linenItem;
    private Long stdQty;
    private String longDesc;
    private String shortDesc;
    private String linenTypeCode;
    private String disposableItem;
    private String effStatus;
}
