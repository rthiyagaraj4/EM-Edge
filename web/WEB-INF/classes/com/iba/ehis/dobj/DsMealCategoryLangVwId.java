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

public class DsMealCategoryLangVwId
    implements Serializable
{

    public DsMealCategoryLangVwId()
    {
    }

    public DsMealCategoryLangVwId(String languageId)
    {
        this.languageId = languageId;
    }

    public DsMealCategoryLangVwId(String languageId, String mealCategoryCode, String description, String defaultDietType, String defaultMealClass, Long orderBy)
    {
        this.languageId = languageId;
        this.mealCategoryCode = mealCategoryCode;
        this.description = description;
        this.defaultDietType = defaultDietType;
        this.defaultMealClass = defaultMealClass;
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

    public String getMealCategoryCode()
    {
        return mealCategoryCode;
    }

    public void setMealCategoryCode(String mealCategoryCode)
    {
        this.mealCategoryCode = mealCategoryCode;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDefaultDietType()
    {
        return defaultDietType;
    }

    public void setDefaultDietType(String defaultDietType)
    {
        this.defaultDietType = defaultDietType;
    }

    public String getDefaultMealClass()
    {
        return defaultMealClass;
    }

    public void setDefaultMealClass(String defaultMealClass)
    {
        this.defaultMealClass = defaultMealClass;
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
        if(!(other instanceof DsMealCategoryLangVwId))
            return false;
        DsMealCategoryLangVwId castOther = (DsMealCategoryLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getMealCategoryCode() == castOther.getMealCategoryCode() || getMealCategoryCode() != null && castOther.getMealCategoryCode() != null && getMealCategoryCode().equals(castOther.getMealCategoryCode())) && (getDescription() == castOther.getDescription() || getDescription() != null && castOther.getDescription() != null && getDescription().equals(castOther.getDescription())) && (getDefaultDietType() == castOther.getDefaultDietType() || getDefaultDietType() != null && castOther.getDefaultDietType() != null && getDefaultDietType().equals(castOther.getDefaultDietType())) && (getDefaultMealClass() == castOther.getDefaultMealClass() || getDefaultMealClass() != null && castOther.getDefaultMealClass() != null && getDefaultMealClass().equals(castOther.getDefaultMealClass())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getMealCategoryCode() != null ? getMealCategoryCode().hashCode() : 0);
        result = 37 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 37 * result + (getDefaultDietType() != null ? getDefaultDietType().hashCode() : 0);
        result = 37 * result + (getDefaultMealClass() != null ? getDefaultMealClass().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String mealCategoryCode;
    private String description;
    private String defaultDietType;
    private String defaultMealClass;
    private Long orderBy;
}
