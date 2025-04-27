/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v2.9.9.61 Copyright 2000 Atanas Neshkov  Date: 06/11/2009 10:19:40
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LcWriteOffId.java

package com.iba.ehis.dobj;

import java.io.Serializable;

public class LcWriteOffId
    implements Serializable
{

    public LcWriteOffId()
    {
    }

    public LcWriteOffId(String operatingFacilityId, String writeOffRefNum)
    {
        this.operatingFacilityId = operatingFacilityId;
        this.writeOffRefNum = writeOffRefNum;
    }

    public String getOperatingFacilityId()
    {
        return operatingFacilityId;
    }

    public void setOperatingFacilityId(String operatingFacilityId)
    {
        this.operatingFacilityId = operatingFacilityId;
    }

    public String getWriteOffRefNum()
    {
        return writeOffRefNum;
    }

    public void setWriteOffRefNum(String writeOffRefNum)
    {
        this.writeOffRefNum = writeOffRefNum;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof LcWriteOffId))
            return false;
        LcWriteOffId castOther = (LcWriteOffId)other;
        return (getOperatingFacilityId() == castOther.getOperatingFacilityId() || getOperatingFacilityId() != null && castOther.getOperatingFacilityId() != null && getOperatingFacilityId().equals(castOther.getOperatingFacilityId())) && (getWriteOffRefNum() == castOther.getWriteOffRefNum() || getWriteOffRefNum() != null && castOther.getWriteOffRefNum() != null && getWriteOffRefNum().equals(castOther.getWriteOffRefNum()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getOperatingFacilityId() != null ? getOperatingFacilityId().hashCode() : 0);
        result = 37 * result + (getWriteOffRefNum() != null ? getWriteOffRefNum().hashCode() : 0);
        return result;
    }

    private String operatingFacilityId;
    private String writeOffRefNum;
}
