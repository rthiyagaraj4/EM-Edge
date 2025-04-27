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

public class DsItemTypeLangVwId
    implements Serializable
{

    public DsItemTypeLangVwId()
    {
    }

    public DsItemTypeLangVwId(String languageId)
    {
        this.languageId = languageId;
    }

    public DsItemTypeLangVwId(String languageId, String itemType, String longDesc, String shortDesc, String commFormulaYn, String applDietCategory, String effStatus, 
            Long orderBy)
    {
        this.languageId = languageId;
        this.itemType = itemType;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.commFormulaYn = commFormulaYn;
        this.applDietCategory = applDietCategory;
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

    public String getItemType()
    {
        return itemType;
    }

    public void setItemType(String itemType)
    {
        this.itemType = itemType;
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

    public String getCommFormulaYn()
    {
        return commFormulaYn;
    }

    public void setCommFormulaYn(String commFormulaYn)
    {
        this.commFormulaYn = commFormulaYn;
    }

    public String getApplDietCategory()
    {
        return applDietCategory;
    }

    public void setApplDietCategory(String applDietCategory)
    {
        this.applDietCategory = applDietCategory;
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
        if(!(other instanceof DsItemTypeLangVwId))
            return false;
        DsItemTypeLangVwId castOther = (DsItemTypeLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getItemType() == castOther.getItemType() || getItemType() != null && castOther.getItemType() != null && getItemType().equals(castOther.getItemType())) && (getLongDesc() == castOther.getLongDesc() || getLongDesc() != null && castOther.getLongDesc() != null && getLongDesc().equals(castOther.getLongDesc())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getCommFormulaYn() == castOther.getCommFormulaYn() || getCommFormulaYn() != null && castOther.getCommFormulaYn() != null && getCommFormulaYn().equals(castOther.getCommFormulaYn())) && (getApplDietCategory() == castOther.getApplDietCategory() || getApplDietCategory() != null && castOther.getApplDietCategory() != null && getApplDietCategory().equals(castOther.getApplDietCategory())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getItemType() != null ? getItemType().hashCode() : 0);
        result = 37 * result + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getCommFormulaYn() != null ? getCommFormulaYn().hashCode() : 0);
        result = 37 * result + (getApplDietCategory() != null ? getApplDietCategory().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String itemType;
    private String longDesc;
    private String shortDesc;
    private String commFormulaYn;
    private String applDietCategory;
    private String effStatus;
    private Long orderBy;
}
