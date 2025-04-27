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

public class DsCommFormulaLangVwId
    implements Serializable
{

    public DsCommFormulaLangVwId()
    {
    }

    public DsCommFormulaLangVwId(String languageId)
    {
        this.languageId = languageId;
    }

    public DsCommFormulaLangVwId(String languageId, String commFormulaCode, String longDesc, String shortDesc, String itemType, String servingUomCode, Long calorificContentPerUom, 
            String prepUom, Long prepFactor, Long prepBaseQty, String itemCode, String effStatus, Long orderBy)
    {
        this.languageId = languageId;
        this.commFormulaCode = commFormulaCode;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.itemType = itemType;
        this.servingUomCode = servingUomCode;
        this.calorificContentPerUom = calorificContentPerUom;
        this.prepUom = prepUom;
        this.prepFactor = prepFactor;
        this.prepBaseQty = prepBaseQty;
        this.itemCode = itemCode;
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

    public String getCommFormulaCode()
    {
        return commFormulaCode;
    }

    public void setCommFormulaCode(String commFormulaCode)
    {
        this.commFormulaCode = commFormulaCode;
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

    public Long getCalorificContentPerUom()
    {
        return calorificContentPerUom;
    }

    public void setCalorificContentPerUom(Long calorificContentPerUom)
    {
        this.calorificContentPerUom = calorificContentPerUom;
    }

    public String getPrepUom()
    {
        return prepUom;
    }

    public void setPrepUom(String prepUom)
    {
        this.prepUom = prepUom;
    }

    public Long getPrepFactor()
    {
        return prepFactor;
    }

    public void setPrepFactor(Long prepFactor)
    {
        this.prepFactor = prepFactor;
    }

    public Long getPrepBaseQty()
    {
        return prepBaseQty;
    }

    public void setPrepBaseQty(Long prepBaseQty)
    {
        this.prepBaseQty = prepBaseQty;
    }

    public String getItemCode()
    {
        return itemCode;
    }

    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
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
        if(!(other instanceof DsCommFormulaLangVwId))
            return false;
        DsCommFormulaLangVwId castOther = (DsCommFormulaLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getCommFormulaCode() == castOther.getCommFormulaCode() || getCommFormulaCode() != null && castOther.getCommFormulaCode() != null && getCommFormulaCode().equals(castOther.getCommFormulaCode())) && (getLongDesc() == castOther.getLongDesc() || getLongDesc() != null && castOther.getLongDesc() != null && getLongDesc().equals(castOther.getLongDesc())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getItemType() == castOther.getItemType() || getItemType() != null && castOther.getItemType() != null && getItemType().equals(castOther.getItemType())) && (getServingUomCode() == castOther.getServingUomCode() || getServingUomCode() != null && castOther.getServingUomCode() != null && getServingUomCode().equals(castOther.getServingUomCode())) && (getCalorificContentPerUom() == castOther.getCalorificContentPerUom() || getCalorificContentPerUom() != null && castOther.getCalorificContentPerUom() != null && getCalorificContentPerUom().equals(castOther.getCalorificContentPerUom())) && (getPrepUom() == castOther.getPrepUom() || getPrepUom() != null && castOther.getPrepUom() != null && getPrepUom().equals(castOther.getPrepUom())) && (getPrepFactor() == castOther.getPrepFactor() || getPrepFactor() != null && castOther.getPrepFactor() != null && getPrepFactor().equals(castOther.getPrepFactor())) && (getPrepBaseQty() == castOther.getPrepBaseQty() || getPrepBaseQty() != null && castOther.getPrepBaseQty() != null && getPrepBaseQty().equals(castOther.getPrepBaseQty())) && (getItemCode() == castOther.getItemCode() || getItemCode() != null && castOther.getItemCode() != null && getItemCode().equals(castOther.getItemCode())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getCommFormulaCode() != null ? getCommFormulaCode().hashCode() : 0);
        result = 37 * result + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getItemType() != null ? getItemType().hashCode() : 0);
        result = 37 * result + (getServingUomCode() != null ? getServingUomCode().hashCode() : 0);
        result = 37 * result + (getCalorificContentPerUom() != null ? getCalorificContentPerUom().hashCode() : 0);
        result = 37 * result + (getPrepUom() != null ? getPrepUom().hashCode() : 0);
        result = 37 * result + (getPrepFactor() != null ? getPrepFactor().hashCode() : 0);
        result = 37 * result + (getPrepBaseQty() != null ? getPrepBaseQty().hashCode() : 0);
        result = 37 * result + (getItemCode() != null ? getItemCode().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String commFormulaCode;
    private String longDesc;
    private String shortDesc;
    private String itemType;
    private String servingUomCode;
    private Long calorificContentPerUom;
    private String prepUom;
    private Long prepFactor;
    private Long prepBaseQty;
    private String itemCode;
    private String effStatus;
    private Long orderBy;
}
