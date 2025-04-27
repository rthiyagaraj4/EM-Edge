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

public class DsItemTypeLangId
    implements Serializable
{

    public DsItemTypeLangId()
    {
    }

    public DsItemTypeLangId(String languageId, String itemType)
    {
        this.languageId = languageId;
        this.itemType = itemType;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public String getItemType()
    {
        return itemType;
    }

    public void setItemType(String itemType)
    {
        this.itemType = itemType;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof DsItemTypeLangId))
            return false;
        DsItemTypeLangId castOther = (DsItemTypeLangId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getItemType() == castOther.getItemType() || getItemType() != null && castOther.getItemType() != null && getItemType().equals(castOther.getItemType()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getItemType() != null ? getItemType().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String itemType;
}
