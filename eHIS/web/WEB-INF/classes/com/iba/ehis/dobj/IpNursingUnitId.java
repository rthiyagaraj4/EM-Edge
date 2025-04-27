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

public class IpNursingUnitId
    implements Serializable
{

    public IpNursingUnitId()
    {
    }

    public IpNursingUnitId(String facilityId, String nursingUnitCode)
    {
        this.facilityId = facilityId;
        this.nursingUnitCode = nursingUnitCode;
    }

    public String getFacilityId()
    {
        return facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    public String getNursingUnitCode()
    {
        return nursingUnitCode;
    }

    public void setNursingUnitCode(String nursingUnitCode)
    {
        this.nursingUnitCode = nursingUnitCode;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof IpNursingUnitId))
            return false;
        IpNursingUnitId castOther = (IpNursingUnitId)other;
        return (getFacilityId() == castOther.getFacilityId() || getFacilityId() != null && castOther.getFacilityId() != null && getFacilityId().equals(castOther.getFacilityId())) && (getNursingUnitCode() == castOther.getNursingUnitCode() || getNursingUnitCode() != null && castOther.getNursingUnitCode() != null && getNursingUnitCode().equals(castOther.getNursingUnitCode()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getFacilityId() != null ? getFacilityId().hashCode() : 0);
        result = 37 * result + (getNursingUnitCode() != null ? getNursingUnitCode().hashCode() : 0);
        return result;
    }

    private String facilityId;
    private String nursingUnitCode;
}
