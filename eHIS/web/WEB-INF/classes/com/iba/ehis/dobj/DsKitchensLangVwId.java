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

public class DsKitchensLangVwId
    implements Serializable
{

    public DsKitchensLangVwId()
    {
    }

    public DsKitchensLangVwId(String languageId)
    {
        this.languageId = languageId;
    }

    public DsKitchensLangVwId(String languageId, String operatingFacilityId, String kitchenCode, String longDesc, String shortDesc, Long orderBy, String effStatus)
    {
        this.languageId = languageId;
        this.operatingFacilityId = operatingFacilityId;
        this.kitchenCode = kitchenCode;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.orderBy = orderBy;
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

    public Long getOrderBy()
    {
        return orderBy;
    }

    public void setOrderBy(Long orderBy)
    {
        this.orderBy = orderBy;
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
        if(!(other instanceof DsKitchensLangVwId))
            return false;
        DsKitchensLangVwId castOther = (DsKitchensLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getOperatingFacilityId() == castOther.getOperatingFacilityId() || getOperatingFacilityId() != null && castOther.getOperatingFacilityId() != null && getOperatingFacilityId().equals(castOther.getOperatingFacilityId())) && (getKitchenCode() == castOther.getKitchenCode() || getKitchenCode() != null && castOther.getKitchenCode() != null && getKitchenCode().equals(castOther.getKitchenCode())) && (getLongDesc() == castOther.getLongDesc() || getLongDesc() != null && castOther.getLongDesc() != null && getLongDesc().equals(castOther.getLongDesc())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getOperatingFacilityId() != null ? getOperatingFacilityId().hashCode() : 0);
        result = 37 * result + (getKitchenCode() != null ? getKitchenCode().hashCode() : 0);
        result = 37 * result + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String operatingFacilityId;
    private String kitchenCode;
    private String longDesc;
    private String shortDesc;
    private Long orderBy;
    private String effStatus;
}
