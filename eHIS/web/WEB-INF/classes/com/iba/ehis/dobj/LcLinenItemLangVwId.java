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
// Source File Name:   LcLinenItemLangVwId.java

package com.iba.ehis.dobj;

import java.io.Serializable;

public class LcLinenItemLangVwId
    implements Serializable
{

    public LcLinenItemLangVwId()
    {
    }

    public LcLinenItemLangVwId(String languageId, String linenItem)
    {
        this.languageId = languageId;
        this.linenItem = linenItem;
    }

    public LcLinenItemLangVwId(String languageId, String linenItem, String longDesc, String shortDesc, String linenTypeCode, String washingInstructions, String disposableItem, 
            String effStatus, Long orderBy)
    {
        this.languageId = languageId;
        this.linenItem = linenItem;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.linenTypeCode = linenTypeCode;
        this.washingInstructions = washingInstructions;
        this.disposableItem = disposableItem;
        this.effStatus = effStatus;
        this.orderBy = orderBy;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public String getLinenItem()
    {
        return linenItem;
    }

    public void setLinenItem(String linenItem)
    {
        this.linenItem = linenItem;
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

    public String getWashingInstructions()
    {
        return washingInstructions;
    }

    public void setWashingInstructions(String washingInstructions)
    {
        this.washingInstructions = washingInstructions;
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

    public Long getOrderBy()
    {
        return orderBy;
    }

    public void setOrderBy(Long orderBy)
    {
        this.orderBy = orderBy;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof LcLinenItemLangVwId))
            return false;
        LcLinenItemLangVwId castOther = (LcLinenItemLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getLinenItem() == castOther.getLinenItem() || getLinenItem() != null && castOther.getLinenItem() != null && getLinenItem().equals(castOther.getLinenItem())) && (getLongDesc() == castOther.getLongDesc() || getLongDesc() != null && castOther.getLongDesc() != null && getLongDesc().equals(castOther.getLongDesc())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getLinenTypeCode() == castOther.getLinenTypeCode() || getLinenTypeCode() != null && castOther.getLinenTypeCode() != null && getLinenTypeCode().equals(castOther.getLinenTypeCode())) && (getWashingInstructions() == castOther.getWashingInstructions() || getWashingInstructions() != null && castOther.getWashingInstructions() != null && getWashingInstructions().equals(castOther.getWashingInstructions())) && (getDisposableItem() == castOther.getDisposableItem() || getDisposableItem() != null && castOther.getDisposableItem() != null && getDisposableItem().equals(castOther.getDisposableItem())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getLinenItem() != null ? getLinenItem().hashCode() : 0);
        result = 37 * result + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getLinenTypeCode() != null ? getLinenTypeCode().hashCode() : 0);
        result = 37 * result + (getWashingInstructions() != null ? getWashingInstructions().hashCode() : 0);
        result = 37 * result + (getDisposableItem() != null ? getDisposableItem().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String linenItem;
    private String longDesc;
    private String shortDesc;
    private String linenTypeCode;
    private String washingInstructions;
    private String disposableItem;
    private String effStatus;
    private Long orderBy;
}
