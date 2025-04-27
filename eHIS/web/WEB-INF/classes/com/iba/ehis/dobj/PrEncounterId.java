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

// Referenced classes of package com.iba.ehis.dobj:
//            SmFacilityParam

public class PrEncounterId
    implements Serializable
{

    public PrEncounterId()
    {
    }

    public PrEncounterId(SmFacilityParam smFacilityParam, Long encounterId)
    {
        this.smFacilityParam = smFacilityParam;
        this.encounterId = encounterId;
    }

    public SmFacilityParam getSmFacilityParam()
    {
        return smFacilityParam;
    }

    public void setSmFacilityParam(SmFacilityParam smFacilityParam)
    {
        this.smFacilityParam = smFacilityParam;
    }

    public Long getEncounterId()
    {
        return encounterId;
    }

    public void setEncounterId(Long encounterId)
    {
        this.encounterId = encounterId;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof PrEncounterId))
            return false;
        PrEncounterId castOther = (PrEncounterId)other;
        return (getSmFacilityParam() == castOther.getSmFacilityParam() || getSmFacilityParam() != null && castOther.getSmFacilityParam() != null && getSmFacilityParam().equals(castOther.getSmFacilityParam())) && (getEncounterId() == castOther.getEncounterId() || getEncounterId() != null && castOther.getEncounterId() != null && getEncounterId().equals(castOther.getEncounterId()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getSmFacilityParam() != null ? getSmFacilityParam().hashCode() : 0);
        result = 37 * result + (getEncounterId() != null ? getEncounterId().hashCode() : 0);
        return result;
    }

    private SmFacilityParam smFacilityParam;
    private Long encounterId;
}
