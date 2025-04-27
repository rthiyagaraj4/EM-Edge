/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 8/25/2009 5:31:45 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LcReasonActionTypeLangVwId.java

package com.iba.ehis.dobj;

import java.io.Serializable;

public class LcReasonActionTypeLangVwId
    implements Serializable
{

    public LcReasonActionTypeLangVwId()
    {
    }

    public LcReasonActionTypeLangVwId(String languageId)
    {
        this.languageId = languageId;
    }

    public LcReasonActionTypeLangVwId(String languageId, String actionTypeCode, String actionTypeDesc, Long orderBy)
    {
        this.languageId = languageId;
        this.actionTypeCode = actionTypeCode;
        this.actionTypeDesc = actionTypeDesc;
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

    public String getActionTypeCode()
    {
        return actionTypeCode;
    }

    public void setActionTypeCode(String actionTypeCode)
    {
        this.actionTypeCode = actionTypeCode;
    }

    public String getActionTypeDesc()
    {
        return actionTypeDesc;
    }

    public void setActionTypeDesc(String actionTypeDesc)
    {
        this.actionTypeDesc = actionTypeDesc;
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
        if(!(other instanceof LcReasonActionTypeLangVwId))
            return false;
        LcReasonActionTypeLangVwId castOther = (LcReasonActionTypeLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getActionTypeCode() == castOther.getActionTypeCode() || getActionTypeCode() != null && castOther.getActionTypeCode() != null && getActionTypeCode().equals(castOther.getActionTypeCode())) && (getActionTypeDesc() == castOther.getActionTypeDesc() || getActionTypeDesc() != null && castOther.getActionTypeDesc() != null && getActionTypeDesc().equals(castOther.getActionTypeDesc())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getActionTypeCode() != null ? getActionTypeCode().hashCode() : 0);
        result = 37 * result + (getActionTypeDesc() != null ? getActionTypeDesc().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String actionTypeCode;
    private String actionTypeDesc;
    private Long orderBy;
}
