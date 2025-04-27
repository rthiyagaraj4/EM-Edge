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
// Source File Name:   LcReasonLangVwId.java

package com.iba.ehis.dobj;

import java.io.Serializable;

public class LcReasonLangVwId
    implements Serializable
{

    public LcReasonLangVwId()
    {
    }

    public LcReasonLangVwId(String languageId)
    {
        this.languageId = languageId;
    }

    public LcReasonLangVwId(String languageId, String reasonCode, String reasonDesc, String actionTypeCode, String activeYn, String effStatus, Long orderBy)
    {
        this.languageId = languageId;
        this.reasonCode = reasonCode;
        this.reasonDesc = reasonDesc;
        this.actionTypeCode = actionTypeCode;
        this.activeYn = activeYn;
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

    public String getReasonCode()
    {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode)
    {
        this.reasonCode = reasonCode;
    }

    public String getReasonDesc()
    {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc)
    {
        this.reasonDesc = reasonDesc;
    }

    public String getActionTypeCode()
    {
        return actionTypeCode;
    }

    public void setActionTypeCode(String actionTypeCode)
    {
        this.actionTypeCode = actionTypeCode;
    }

    public String getActiveYn()
    {
        return activeYn;
    }

    public void setActiveYn(String activeYn)
    {
        this.activeYn = activeYn;
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
        if(!(other instanceof LcReasonLangVwId))
            return false;
        LcReasonLangVwId castOther = (LcReasonLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getReasonCode() == castOther.getReasonCode() || getReasonCode() != null && castOther.getReasonCode() != null && getReasonCode().equals(castOther.getReasonCode())) && (getReasonDesc() == castOther.getReasonDesc() || getReasonDesc() != null && castOther.getReasonDesc() != null && getReasonDesc().equals(castOther.getReasonDesc())) && (getActionTypeCode() == castOther.getActionTypeCode() || getActionTypeCode() != null && castOther.getActionTypeCode() != null && getActionTypeCode().equals(castOther.getActionTypeCode())) && (getActiveYn() == castOther.getActiveYn() || getActiveYn() != null && castOther.getActiveYn() != null && getActiveYn().equals(castOther.getActiveYn())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getReasonCode() != null ? getReasonCode().hashCode() : 0);
        result = 37 * result + (getReasonDesc() != null ? getReasonDesc().hashCode() : 0);
        result = 37 * result + (getActionTypeCode() != null ? getActionTypeCode().hashCode() : 0);
        result = 37 * result + (getActiveYn() != null ? getActiveYn().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String reasonCode;
    private String reasonDesc;
    private String actionTypeCode;
    private String activeYn;
    private String effStatus;
    private Long orderBy;
}
