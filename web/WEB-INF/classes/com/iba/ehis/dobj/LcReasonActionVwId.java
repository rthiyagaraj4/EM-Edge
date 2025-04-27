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
// Source File Name:   LcReasonActionVwId.java

package com.iba.ehis.dobj;

import java.io.Serializable;

public class LcReasonActionVwId
    implements Serializable
{

    public LcReasonActionVwId()
    {
    }

    public LcReasonActionVwId(String languageId, String reasonCode)
    {
        this.languageId = languageId;
        this.reasonCode = reasonCode;
    }

    public LcReasonActionVwId(String languageId, String actionTypeCode, String actionTypeDesc, String reasonCode, String activeYn, String effStatus)
    {
        this.languageId = languageId;
        this.actionTypeCode = actionTypeCode;
        this.actionTypeDesc = actionTypeDesc;
        this.reasonCode = reasonCode;
        this.activeYn = activeYn;
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

    public String getReasonCode()
    {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode)
    {
        this.reasonCode = reasonCode;
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

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof LcReasonActionVwId))
            return false;
        LcReasonActionVwId castOther = (LcReasonActionVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getActionTypeCode() == castOther.getActionTypeCode() || getActionTypeCode() != null && castOther.getActionTypeCode() != null && getActionTypeCode().equals(castOther.getActionTypeCode())) && (getActionTypeDesc() == castOther.getActionTypeDesc() || getActionTypeDesc() != null && castOther.getActionTypeDesc() != null && getActionTypeDesc().equals(castOther.getActionTypeDesc())) && (getReasonCode() == castOther.getReasonCode() || getReasonCode() != null && castOther.getReasonCode() != null && getReasonCode().equals(castOther.getReasonCode())) && (getActiveYn() == castOther.getActiveYn() || getActiveYn() != null && castOther.getActiveYn() != null && getActiveYn().equals(castOther.getActiveYn())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getActionTypeCode() != null ? getActionTypeCode().hashCode() : 0);
        result = 37 * result + (getActionTypeDesc() != null ? getActionTypeDesc().hashCode() : 0);
        result = 37 * result + (getReasonCode() != null ? getReasonCode().hashCode() : 0);
        result = 37 * result + (getActiveYn() != null ? getActiveYn().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String actionTypeCode;
    private String actionTypeDesc;
    private String reasonCode;
    private String activeYn;
    private String effStatus;
}
