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

public class DsDailyMealStatisticsId
    implements Serializable
{

    public DsDailyMealStatisticsId()
    {
    }

    public DsDailyMealStatisticsId(String languageId)
    {
        this.languageId = languageId;
    }

    public DsDailyMealStatisticsId(String languageId, String operatingFacilityId, String kitchenCode, String mealType, Date servDate, String curWardCode, String dietType, 
            Long patientMeals, Long attMeals)
    {
        this.languageId = languageId;
        this.operatingFacilityId = operatingFacilityId;
        this.kitchenCode = kitchenCode;
        this.mealType = mealType;
        this.servDate = servDate;
        this.curWardCode = curWardCode;
        this.dietType = dietType;
        this.patientMeals = patientMeals;
        this.attMeals = attMeals;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public String getOperatingFacilityId()
    {
        return operatingFacilityId;
    }

    public void setOperatingFacilityId(String operatingFacilityId)
    {
        this.operatingFacilityId = operatingFacilityId;
    }

    public String getKitchenCode()
    {
        return kitchenCode;
    }

    public void setKitchenCode(String kitchenCode)
    {
        this.kitchenCode = kitchenCode;
    }

    public String getMealType()
    {
        return mealType;
    }

    public void setMealType(String mealType)
    {
        this.mealType = mealType;
    }

    public Date getServDate()
    {
        return servDate;
    }

    public void setServDate(Date servDate)
    {
        this.servDate = servDate;
    }

    public String getCurWardCode()
    {
        return curWardCode;
    }

    public void setCurWardCode(String curWardCode)
    {
        this.curWardCode = curWardCode;
    }

    public String getDietType()
    {
        return dietType;
    }

    public void setDietType(String dietType)
    {
        this.dietType = dietType;
    }

    public Long getPatientMeals()
    {
        return patientMeals;
    }

    public void setPatientMeals(Long patientMeals)
    {
        this.patientMeals = patientMeals;
    }

    public Long getAttMeals()
    {
        return attMeals;
    }

    public void setAttMeals(Long attMeals)
    {
        this.attMeals = attMeals;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof DsDailyMealStatisticsId))
            return false;
        DsDailyMealStatisticsId castOther = (DsDailyMealStatisticsId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getOperatingFacilityId() == castOther.getOperatingFacilityId() || getOperatingFacilityId() != null && castOther.getOperatingFacilityId() != null && getOperatingFacilityId().equals(castOther.getOperatingFacilityId())) && (getKitchenCode() == castOther.getKitchenCode() || getKitchenCode() != null && castOther.getKitchenCode() != null && getKitchenCode().equals(castOther.getKitchenCode())) && (getMealType() == castOther.getMealType() || getMealType() != null && castOther.getMealType() != null && getMealType().equals(castOther.getMealType())) && (getServDate() == castOther.getServDate() || getServDate() != null && castOther.getServDate() != null && getServDate().equals(castOther.getServDate())) && (getCurWardCode() == castOther.getCurWardCode() || getCurWardCode() != null && castOther.getCurWardCode() != null && getCurWardCode().equals(castOther.getCurWardCode())) && (getDietType() == castOther.getDietType() || getDietType() != null && castOther.getDietType() != null && getDietType().equals(castOther.getDietType())) && (getPatientMeals() == castOther.getPatientMeals() || getPatientMeals() != null && castOther.getPatientMeals() != null && getPatientMeals().equals(castOther.getPatientMeals())) && (getAttMeals() == castOther.getAttMeals() || getAttMeals() != null && castOther.getAttMeals() != null && getAttMeals().equals(castOther.getAttMeals()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getOperatingFacilityId() != null ? getOperatingFacilityId().hashCode() : 0);
        result = 37 * result + (getKitchenCode() != null ? getKitchenCode().hashCode() : 0);
        result = 37 * result + (getMealType() != null ? getMealType().hashCode() : 0);
        result = 37 * result + (getServDate() != null ? getServDate().hashCode() : 0);
        result = 37 * result + (getCurWardCode() != null ? getCurWardCode().hashCode() : 0);
        result = 37 * result + (getDietType() != null ? getDietType().hashCode() : 0);
        result = 37 * result + (getPatientMeals() != null ? getPatientMeals().hashCode() : 0);
        result = 37 * result + (getAttMeals() != null ? getAttMeals().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String operatingFacilityId;
    private String kitchenCode;
    private String mealType;
    private Date servDate;
    private String curWardCode;
    private String dietType;
    private Long patientMeals;
    private Long attMeals;
}
