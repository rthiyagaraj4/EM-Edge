/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 8/25/2009 5:31:46 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LcSourceStkId.java

package com.iba.ehis.dobj;

import java.io.Serializable;

// Referenced classes of package com.iba.ehis.dobj:
//            LcLinenItem

public class LcSourceStkId
    implements Serializable
{

    public LcSourceStkId()
    {
    }

    public LcSourceStkId(String operatingFacilityId, LcLinenItem lcLinenItem)
    {
        this.operatingFacilityId = operatingFacilityId;
        this.lcLinenItem = lcLinenItem;
    }

    public String getOperatingFacilityId()
    {
        return operatingFacilityId;
    }

    public void setOperatingFacilityId(String operatingFacilityId)
    {
        this.operatingFacilityId = operatingFacilityId;
    }

    public LcLinenItem getLcLinenItem()
    {
        return lcLinenItem;
    }

    public void setLcLinenItem(LcLinenItem lcLinenItem)
    {
        this.lcLinenItem = lcLinenItem;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof LcSourceStkId))
            return false;
        LcSourceStkId castOther = (LcSourceStkId)other;
        return (getOperatingFacilityId() == castOther.getOperatingFacilityId() || getOperatingFacilityId() != null && castOther.getOperatingFacilityId() != null && getOperatingFacilityId().equals(castOther.getOperatingFacilityId())) && (getLcLinenItem() == castOther.getLcLinenItem() || getLcLinenItem() != null && castOther.getLcLinenItem() != null && getLcLinenItem().equals(castOther.getLcLinenItem()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getOperatingFacilityId() != null ? getOperatingFacilityId().hashCode() : 0);
        result = 37 * result + (getLcLinenItem() != null ? getLcLinenItem().hashCode() : 0);
        return result;
    }

    private String operatingFacilityId;
    private LcLinenItem lcLinenItem;
}
