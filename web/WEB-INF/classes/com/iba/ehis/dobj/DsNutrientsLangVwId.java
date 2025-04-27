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

public class DsNutrientsLangVwId
    implements Serializable
{

    public DsNutrientsLangVwId()
    {
    }

    public DsNutrientsLangVwId(String languageId, String uomCode)
    {
        this.languageId = languageId;
        this.uomCode = uomCode;
    }

    public DsNutrientsLangVwId(String languageId, String nutrientsCode, String longDesc, String shortDesc, String uomCode, Long nutrientConversion, Long energyConversion, 
            String effStatus, Long orderBy)
    {
        this.languageId = languageId;
        this.nutrientsCode = nutrientsCode;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.uomCode = uomCode;
        this.nutrientConversion = nutrientConversion;
        this.energyConversion = energyConversion;
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

    public String getNutrientsCode()
    {
        return nutrientsCode;
    }

    public void setNutrientsCode(String nutrientsCode)
    {
        this.nutrientsCode = nutrientsCode;
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

    public String getUomCode()
    {
        return uomCode;
    }

    public void setUomCode(String uomCode)
    {
        this.uomCode = uomCode;
    }

    public Long getNutrientConversion()
    {
        return nutrientConversion;
    }

    public void setNutrientConversion(Long nutrientConversion)
    {
        this.nutrientConversion = nutrientConversion;
    }

    public Long getEnergyConversion()
    {
        return energyConversion;
    }

    public void setEnergyConversion(Long energyConversion)
    {
        this.energyConversion = energyConversion;
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
        if(!(other instanceof DsNutrientsLangVwId))
            return false;
        DsNutrientsLangVwId castOther = (DsNutrientsLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getNutrientsCode() == castOther.getNutrientsCode() || getNutrientsCode() != null && castOther.getNutrientsCode() != null && getNutrientsCode().equals(castOther.getNutrientsCode())) && (getLongDesc() == castOther.getLongDesc() || getLongDesc() != null && castOther.getLongDesc() != null && getLongDesc().equals(castOther.getLongDesc())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getUomCode() == castOther.getUomCode() || getUomCode() != null && castOther.getUomCode() != null && getUomCode().equals(castOther.getUomCode())) && (getNutrientConversion() == castOther.getNutrientConversion() || getNutrientConversion() != null && castOther.getNutrientConversion() != null && getNutrientConversion().equals(castOther.getNutrientConversion())) && (getEnergyConversion() == castOther.getEnergyConversion() || getEnergyConversion() != null && castOther.getEnergyConversion() != null && getEnergyConversion().equals(castOther.getEnergyConversion())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getNutrientsCode() != null ? getNutrientsCode().hashCode() : 0);
        result = 37 * result + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getUomCode() != null ? getUomCode().hashCode() : 0);
        result = 37 * result + (getNutrientConversion() != null ? getNutrientConversion().hashCode() : 0);
        result = 37 * result + (getEnergyConversion() != null ? getEnergyConversion().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String nutrientsCode;
    private String longDesc;
    private String shortDesc;
    private String uomCode;
    private Long nutrientConversion;
    private Long energyConversion;
    private String effStatus;
    private Long orderBy;
}
