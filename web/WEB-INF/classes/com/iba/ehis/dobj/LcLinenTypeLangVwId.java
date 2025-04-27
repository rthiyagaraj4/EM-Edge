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
// Source File Name:   LcLinenTypeLangVwId.java

package com.iba.ehis.dobj;

import java.io.Serializable;

public class LcLinenTypeLangVwId
    implements Serializable
{

    public LcLinenTypeLangVwId()
    {
    }

    public LcLinenTypeLangVwId(String languageId, String linenTypeCode)
    {
        this.languageId = languageId;
        this.linenTypeCode = linenTypeCode;
    }

    public LcLinenTypeLangVwId(String languageId, String linenTypeCode, String linenTypeDesc, String effStatus, Long orderBy)
    {
        this.languageId = languageId;
        this.linenTypeCode = linenTypeCode;
        this.linenTypeDesc = linenTypeDesc;
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

    public String getLinenTypeCode()
    {
        return linenTypeCode;
    }

    public void setLinenTypeCode(String linenTypeCode)
    {
        this.linenTypeCode = linenTypeCode;
    }

    public String getLinenTypeDesc()
    {
        return linenTypeDesc;
    }

    public void setLinenTypeDesc(String linenTypeDesc)
    {
        this.linenTypeDesc = linenTypeDesc;
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
        if(!(other instanceof LcLinenTypeLangVwId))
            return false;
        LcLinenTypeLangVwId castOther = (LcLinenTypeLangVwId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getLinenTypeCode() == castOther.getLinenTypeCode() || getLinenTypeCode() != null && castOther.getLinenTypeCode() != null && getLinenTypeCode().equals(castOther.getLinenTypeCode())) && (getLinenTypeDesc() == castOther.getLinenTypeDesc() || getLinenTypeDesc() != null && castOther.getLinenTypeDesc() != null && getLinenTypeDesc().equals(castOther.getLinenTypeDesc())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getLinenTypeCode() != null ? getLinenTypeCode().hashCode() : 0);
        result = 37 * result + (getLinenTypeDesc() != null ? getLinenTypeDesc().hashCode() : 0);
        result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String linenTypeCode;
    private String linenTypeDesc;
    private String effStatus;
    private Long orderBy;
}
