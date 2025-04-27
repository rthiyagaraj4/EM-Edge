/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Source File Name:   LcLoanDtlsId.java

package com.iba.ehis.dobj;

import java.io.Serializable;

public class LcLoanDtlsId
    implements Serializable
{

    public LcLoanDtlsId()
    {
    }

    public LcLoanDtlsId(String operatingFacilityId, String loanRefNum)
    {
        this.operatingFacilityId = operatingFacilityId;
        this.loanRefNum = loanRefNum;
    }

    public String getOperatingFacilityId()
    {
        return operatingFacilityId;
    }

    public void setOperatingFacilityId(String operatingFacilityId)
    {
        this.operatingFacilityId = operatingFacilityId;
    }

    public String getLoanRefNum()
    {
        return loanRefNum;
    }

    public void setLoanRefNum(String loanRefNum)
    {
        this.loanRefNum = loanRefNum;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof LcLoanDtlsId))
            return false;
        LcLoanDtlsId castOther = (LcLoanDtlsId)other;
        return (getOperatingFacilityId() == castOther.getOperatingFacilityId() || getOperatingFacilityId() != null && castOther.getOperatingFacilityId() != null && getOperatingFacilityId().equals(castOther.getOperatingFacilityId())) && (getLoanRefNum() == castOther.getLoanRefNum() || getLoanRefNum() != null && castOther.getLoanRefNum() != null && getLoanRefNum().equals(castOther.getLoanRefNum()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getOperatingFacilityId() != null ? getOperatingFacilityId().hashCode() : 0);
        result = 37 * result + (getLoanRefNum() != null ? getLoanRefNum().hashCode() : 0);
        return result;
    }

    private String operatingFacilityId;
    private String loanRefNum;
}
