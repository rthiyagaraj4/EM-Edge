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

public class DsDietCategoryLangVwId
    implements Serializable
{

    public DsDietCategoryLangVwId()
    {
    }

    public DsDietCategoryLangVwId(String languageId)
    {
        this.languageId = languageId;
    }

    public DsDietCategoryLangVwId(String languageId, String dietCategoryCode, String description, String orderTypeCode, Long orderBy)
    {
        this.languageId = languageId;
        this.dietCategoryCode = dietCategoryCode;
        this.description = description;
        this.orderTypeCode = orderTypeCode;
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

    public String getDietCategoryCode()
    {
        return dietCategoryCode;
    }

    public void setDietCategoryCode(String dietCategoryCode)
    {
        this.dietCategoryCode = dietCategoryCode;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getOrderTypeCode()
    {
        return orderTypeCode;
    }

    public void setOrderTypeCode(String orderTypeCode)
    {
        this.orderTypeCode = orderTypeCode;
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
        if(!(other instanceof DsDietCategoryLangVwId))
            return false;
        DsDietCategoryLangVwId castOther = (DsDietCategoryLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getDietCategoryCode() == castOther.getDietCategoryCode() || getDietCategoryCode() != null && castOther.getDietCategoryCode() != null && getDietCategoryCode().equals(castOther.getDietCategoryCode())) && (getDescription() == castOther.getDescription() || getDescription() != null && castOther.getDescription() != null && getDescription().equals(castOther.getDescription())) && (getOrderTypeCode() == castOther.getOrderTypeCode() || getOrderTypeCode() != null && castOther.getOrderTypeCode() != null && getOrderTypeCode().equals(castOther.getOrderTypeCode())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getDietCategoryCode() != null ? getDietCategoryCode().hashCode() : 0);
        result = 37 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 37 * result + (getOrderTypeCode() != null ? getOrderTypeCode().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String dietCategoryCode;
    private String description;
    private String orderTypeCode;
    private Long orderBy;
}
