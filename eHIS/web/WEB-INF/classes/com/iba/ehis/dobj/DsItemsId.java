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

public class DsItemsId
    implements Serializable
{

    public DsItemsId()
    {
    }

    public DsItemsId(String languageId, String foodItemCode, String shortDesc, String commFormulaYn, String itemType, String servingUomCode, Long calorificContPerUom, 
            String effStatus)
    {
        this.languageId = languageId;
        this.foodItemCode = foodItemCode;
        this.shortDesc = shortDesc;
        this.commFormulaYn = commFormulaYn;
        this.itemType = itemType;
        this.servingUomCode = servingUomCode;
        this.calorificContPerUom = calorificContPerUom;
        this.effStatus = effStatus;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public String getFoodItemCode()
    {
        return foodItemCode;
    }

    public void setFoodItemCode(String foodItemCode)
    {
        this.foodItemCode = foodItemCode;
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

    public String getItemType()
    {
        return itemType;
    }

    public void setItemType(String itemType)
    {
        this.itemType = itemType;
    }

    public String getServingUomCode()
    {
        return servingUomCode;
    }

    public void setServingUomCode(String servingUomCode)
    {
        this.servingUomCode = servingUomCode;
    }

    public Long getCalorificContPerUom()
    {
        return calorificContPerUom;
    }

    public void setCalorificContPerUom(Long calorificContPerUom)
    {
        this.calorificContPerUom = calorificContPerUom;
    }

    public String getEffStatus()
    {
        return effStatus;
    }

    public void setEffStatus(String effStatus)
    {
        this.effStatus = effStatus;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof DsItemsId))
            return false;
        DsItemsId castOther = (DsItemsId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getFoodItemCode() == castOther.getFoodItemCode() || getFoodItemCode() != null && castOther.getFoodItemCode() != null && getFoodItemCode().equals(castOther.getFoodItemCode())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getCommFormulaYn() == castOther.getCommFormulaYn() || getCommFormulaYn() != null && castOther.getCommFormulaYn() != null && getCommFormulaYn().equals(castOther.getCommFormulaYn())) && (getItemType() == castOther.getItemType() || getItemType() != null && castOther.getItemType() != null && getItemType().equals(castOther.getItemType())) && (getServingUomCode() == castOther.getServingUomCode() || getServingUomCode() != null && castOther.getServingUomCode() != null && getServingUomCode().equals(castOther.getServingUomCode())) && (getCalorificContPerUom() == castOther.getCalorificContPerUom() || getCalorificContPerUom() != null && castOther.getCalorificContPerUom() != null && getCalorificContPerUom().equals(castOther.getCalorificContPerUom())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getFoodItemCode() != null ? getFoodItemCode().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getCommFormulaYn() != null ? getCommFormulaYn().hashCode() : 0);
        result = 37 * result + (getItemType() != null ? getItemType().hashCode() : 0);
        result = 37 * result + (getServingUomCode() != null ? getServingUomCode().hashCode() : 0);
        result = 37 * result + (getCalorificContPerUom() != null ? getCalorificContPerUom().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String foodItemCode;
    private String shortDesc;
    private String commFormulaYn;
    private String itemType;
    private String servingUomCode;
    private Long calorificContPerUom;
    private String effStatus;
}
