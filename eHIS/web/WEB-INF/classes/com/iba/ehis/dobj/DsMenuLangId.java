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

public class DsMenuLangId
    implements Serializable
{

    public DsMenuLangId()
    {
    }

    public DsMenuLangId(String languageId, String menuCode)
    {
        this.languageId = languageId;
        this.menuCode = menuCode;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public String getMenuCode()
    {
        return menuCode;
    }

    public void setMenuCode(String menuCode)
    {
        this.menuCode = menuCode;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof DsMenuLangId))
            return false;
        DsMenuLangId castOther = (DsMenuLangId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getMenuCode() == castOther.getMenuCode() || getMenuCode() != null && castOther.getMenuCode() != null && getMenuCode().equals(castOther.getMenuCode()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getMenuCode() != null ? getMenuCode().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String menuCode;
}
