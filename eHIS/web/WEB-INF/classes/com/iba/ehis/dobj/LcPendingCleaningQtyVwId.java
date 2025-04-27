/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 8/25/2009 5:31:45 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LcPendingCleaningQtyVwId.java

package com.iba.ehis.dobj;

import java.io.Serializable;

public class LcPendingCleaningQtyVwId
    implements Serializable
{

    public LcPendingCleaningQtyVwId()
    {
    }

    public LcPendingCleaningQtyVwId(String sourceType, String sourceCode, String shortDesc, String linenItem, String languageId)
    {
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.shortDesc = shortDesc;
        this.linenItem = linenItem;
        this.languageId = languageId;
    }

    public LcPendingCleaningQtyVwId(String sourceType, String sourceCode, String shortDesc, String linenItem, String languageId, Long pendingCleaningQty)
    {
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.shortDesc = shortDesc;
        this.linenItem = linenItem;
        this.languageId = languageId;
        this.pendingCleaningQty = pendingCleaningQty;
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

    public String getShortDesc()
    {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc)
    {
        this.shortDesc = shortDesc;
    }

    public String getLinenItem()
    {
        return linenItem;
    }

    public void setLinenItem(String linenItem)
    {
        this.linenItem = linenItem;
    }

    public Long getPendingCleaningQty()
    {
        return pendingCleaningQty;
    }

    public void setPendingCleaningQty(Long pendingCleaningQty)
    {
        this.pendingCleaningQty = pendingCleaningQty;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof LcPendingCleaningQtyVwId))
            return false;
        LcPendingCleaningQtyVwId castOther = (LcPendingCleaningQtyVwId)other;
        return (getSourceType() == castOther.getSourceType() || getSourceType() != null && castOther.getSourceType() != null && getSourceType().equals(castOther.getSourceType())) && (getSourceCode() == castOther.getSourceCode() || getSourceCode() != null && castOther.getSourceCode() != null && getSourceCode().equals(castOther.getSourceCode())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getLinenItem() == castOther.getLinenItem() || getLinenItem() != null && castOther.getLinenItem() != null && getLinenItem().equals(castOther.getLinenItem())) && (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getPendingCleaningQty() == castOther.getPendingCleaningQty() || getPendingCleaningQty() != null && castOther.getPendingCleaningQty() != null && getPendingCleaningQty().equals(castOther.getPendingCleaningQty()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getSourceType() != null ? getSourceType().hashCode() : 0);
        result = 37 * result + (getSourceCode() != null ? getSourceCode().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getLinenItem() != null ? getLinenItem().hashCode() : 0);
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getPendingCleaningQty() != null ? getPendingCleaningQty().hashCode() : 0);
        return result;
    }

    private String sourceType;
    private String sourceCode;
    private String shortDesc;
    private String linenItem;
    private String languageId;
    private Long pendingCleaningQty;
}
