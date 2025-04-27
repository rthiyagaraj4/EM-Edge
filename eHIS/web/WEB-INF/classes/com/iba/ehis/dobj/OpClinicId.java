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

public class OpClinicId
    implements Serializable
{

    public OpClinicId()
    {
    }

    public OpClinicId(String facilityId, String clinicCode)
    {
        this.facilityId = facilityId;
        this.clinicCode = clinicCode;
    }

    public String getFacilityId()
    {
        return facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    public String getClinicCode()
    {
        return clinicCode;
    }

    public void setClinicCode(String clinicCode)
    {
        this.clinicCode = clinicCode;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof OpClinicId))
            return false;
        OpClinicId castOther = (OpClinicId)other;
        return (getFacilityId() == castOther.getFacilityId() || getFacilityId() != null && castOther.getFacilityId() != null && getFacilityId().equals(castOther.getFacilityId())) && (getClinicCode() == castOther.getClinicCode() || getClinicCode() != null && castOther.getClinicCode() != null && getClinicCode().equals(castOther.getClinicCode()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getFacilityId() != null ? getFacilityId().hashCode() : 0);
        result = 37 * result + (getClinicCode() != null ? getClinicCode().hashCode() : 0);
        return result;
    }

    private String facilityId;
    private String clinicCode;
}
