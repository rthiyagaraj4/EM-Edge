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

public class DsDietTypeLangVwId implements Serializable
{

    public DsDietTypeLangVwId() {
    }

    public DsDietTypeLangVwId(String languageId, String ageGroupCode)
    {
        this.languageId = languageId;
        this.ageGroupCode = ageGroupCode;
    }

    public DsDietTypeLangVwId(String languageId, String dietType, String longDesc, String shortDesc, String ageGroupCode, String dietCategoryCode, String defaultFeedType, 
            String defaultYn, String dietCycleType, String orderCatalogCode, String effStatus, Long orderBy)
    {
        this.languageId = languageId;
        this.dietType = dietType;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.ageGroupCode = ageGroupCode;
        this.dietCategoryCode = dietCategoryCode;
        this.defaultFeedType = defaultFeedType;
        this.defaultYn = defaultYn;
        this.dietCycleType = dietCycleType;
        this.orderCatalogCode = orderCatalogCode;
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

    public String getDietType()
    {
        return dietType;
    }

    public void setDietType(String dietType)
    {
        this.dietType = dietType;
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

    public String getAgeGroupCode()
    {
        return ageGroupCode;
    }

    public void setAgeGroupCode(String ageGroupCode)
    {
        this.ageGroupCode = ageGroupCode;
    }

    public String getDietCategoryCode()
    {
        return dietCategoryCode;
    }

    public void setDietCategoryCode(String dietCategoryCode)
    {
        this.dietCategoryCode = dietCategoryCode;
    }

    public String getDefaultFeedType()
    {
        return defaultFeedType;
    }

    public void setDefaultFeedType(String defaultFeedType)
    {
        this.defaultFeedType = defaultFeedType;
    }

    public String getDefaultYn()
    {
        return defaultYn;
    }

    public void setDefaultYn(String defaultYn)
    {
        this.defaultYn = defaultYn;
    }

    public String getDietCycleType()
    {
        return dietCycleType;
    }

    public void setDietCycleType(String dietCycleType)
    {
        this.dietCycleType = dietCycleType;
    }

    public String getOrderCatalogCode()
    {
        return orderCatalogCode;
    }

    public void setOrderCatalogCode(String orderCatalogCode)
    {
        this.orderCatalogCode = orderCatalogCode;
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
        if(!(other instanceof DsDietTypeLangVwId))
            return false;
        DsDietTypeLangVwId castOther = (DsDietTypeLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getDietType() == castOther.getDietType() || getDietType() != null && castOther.getDietType() != null && getDietType().equals(castOther.getDietType())) && (getLongDesc() == castOther.getLongDesc() || getLongDesc() != null && castOther.getLongDesc() != null && getLongDesc().equals(castOther.getLongDesc())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getAgeGroupCode() == castOther.getAgeGroupCode() || getAgeGroupCode() != null && castOther.getAgeGroupCode() != null && getAgeGroupCode().equals(castOther.getAgeGroupCode())) && (getDietCategoryCode() == castOther.getDietCategoryCode() || getDietCategoryCode() != null && castOther.getDietCategoryCode() != null && getDietCategoryCode().equals(castOther.getDietCategoryCode())) && (getDefaultFeedType() == castOther.getDefaultFeedType() || getDefaultFeedType() != null && castOther.getDefaultFeedType() != null && getDefaultFeedType().equals(castOther.getDefaultFeedType())) && (getDefaultYn() == castOther.getDefaultYn() || getDefaultYn() != null && castOther.getDefaultYn() != null && getDefaultYn().equals(castOther.getDefaultYn())) && (getDietCycleType() == castOther.getDietCycleType() || getDietCycleType() != null && castOther.getDietCycleType() != null && getDietCycleType().equals(castOther.getDietCycleType())) && (getOrderCatalogCode() == castOther.getOrderCatalogCode() || getOrderCatalogCode() != null && castOther.getOrderCatalogCode() != null && getOrderCatalogCode().equals(castOther.getOrderCatalogCode())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getDietType() != null ? getDietType().hashCode() : 0);
        result = 37 * result + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getAgeGroupCode() != null ? getAgeGroupCode().hashCode() : 0);
        result = 37 * result + (getDietCategoryCode() != null ? getDietCategoryCode().hashCode() : 0);
        result = 37 * result + (getDefaultFeedType() != null ? getDefaultFeedType().hashCode() : 0);
        result = 37 * result + (getDefaultYn() != null ? getDefaultYn().hashCode() : 0);
        result = 37 * result + (getDietCycleType() != null ? getDietCycleType().hashCode() : 0);
        result = 37 * result + (getOrderCatalogCode() != null ? getOrderCatalogCode().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String dietType;
    private String longDesc;
    private String shortDesc;
    private String ageGroupCode;
    private String dietCategoryCode;
    private String defaultFeedType;
    private String defaultYn;
    private String dietCycleType;
    private String orderCatalogCode;
    private String effStatus;
    private Long orderBy;
}
