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
import java.util.Date;

public class DsMenuLangVwId
    implements Serializable
{

    public DsMenuLangVwId()
    {
    }

    public DsMenuLangVwId(String languageId, String menuCode, String dietType)
    {
        this.languageId = languageId;
        this.menuCode = menuCode;
        this.dietType = dietType;
    }

    public DsMenuLangVwId(String languageId, String menuCode, String longDesc, String shortDesc, String dietType, String mealType, String mealClass, 
            String effStatus, Date effFromDate, Date effToDate, Long orderBy)
    {
        this.languageId = languageId;
        this.menuCode = menuCode;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.dietType = dietType;
        this.mealType = mealType;
        this.mealClass = mealClass;
        this.effStatus = effStatus;
        this.effFromDate = effFromDate;
        this.effToDate = effToDate;
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

    public String getMenuCode()
    {
        return menuCode;
    }

    public void setMenuCode(String menuCode)
    {
        this.menuCode = menuCode;
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

    public String getDietType()
    {
        return dietType;
    }

    public void setDietType(String dietType)
    {
        this.dietType = dietType;
    }

    public String getMealType()
    {
        return mealType;
    }

    public void setMealType(String mealType)
    {
        this.mealType = mealType;
    }

    public String getMealClass()
    {
        return mealClass;
    }

    public void setMealClass(String mealClass)
    {
        this.mealClass = mealClass;
    }

    public String getEffStatus()
    {
        return effStatus;
    }

    public void setEffStatus(String effStatus)
    {
        this.effStatus = effStatus;
    }

    public Date getEffFromDate()
    {
        return effFromDate;
    }

    public void setEffFromDate(Date effFromDate)
    {
        this.effFromDate = effFromDate;
    }

    public Date getEffToDate()
    {
        return effToDate;
    }

    public void setEffToDate(Date effToDate)
    {
        this.effToDate = effToDate;
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
        if(!(other instanceof DsMenuLangVwId))
            return false;
        DsMenuLangVwId castOther = (DsMenuLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getMenuCode() == castOther.getMenuCode() || getMenuCode() != null && castOther.getMenuCode() != null && getMenuCode().equals(castOther.getMenuCode())) && (getLongDesc() == castOther.getLongDesc() || getLongDesc() != null && castOther.getLongDesc() != null && getLongDesc().equals(castOther.getLongDesc())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getDietType() == castOther.getDietType() || getDietType() != null && castOther.getDietType() != null && getDietType().equals(castOther.getDietType())) && (getMealType() == castOther.getMealType() || getMealType() != null && castOther.getMealType() != null && getMealType().equals(castOther.getMealType())) && (getMealClass() == castOther.getMealClass() || getMealClass() != null && castOther.getMealClass() != null && getMealClass().equals(castOther.getMealClass())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus())) && (getEffFromDate() == castOther.getEffFromDate() || getEffFromDate() != null && castOther.getEffFromDate() != null && getEffFromDate().equals(castOther.getEffFromDate())) && (getEffToDate() == castOther.getEffToDate() || getEffToDate() != null && castOther.getEffToDate() != null && getEffToDate().equals(castOther.getEffToDate())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getMenuCode() != null ? getMenuCode().hashCode() : 0);
        result = 37 * result + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getDietType() != null ? getDietType().hashCode() : 0);
        result = 37 * result + (getMealType() != null ? getMealType().hashCode() : 0);
        result = 37 * result + (getMealClass() != null ? getMealClass().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        result = 37 * result + (getEffFromDate() != null ? getEffFromDate().hashCode() : 0);
        result = 37 * result + (getEffToDate() != null ? getEffToDate().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String menuCode;
    private String longDesc;
    private String shortDesc;
    private String dietType;
    private String mealType;
    private String mealClass;
    private String effStatus;
    private Date effFromDate;
    private Date effToDate;
    private Long orderBy;
}
