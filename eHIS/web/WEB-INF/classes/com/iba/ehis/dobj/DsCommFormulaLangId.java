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

public class DsCommFormulaLangId
    implements Serializable
{

    public DsCommFormulaLangId()
    {
    }

    public DsCommFormulaLangId(String languageId, String commFormulaCode)
    {
        this.languageId = languageId;
        this.commFormulaCode = commFormulaCode;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public String getCommFormulaCode()
    {
        return commFormulaCode;
    }

    public void setCommFormulaCode(String commFormulaCode)
    {
        this.commFormulaCode = commFormulaCode;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof DsCommFormulaLangId))
            return false;
        DsCommFormulaLangId castOther = (DsCommFormulaLangId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getCommFormulaCode() == castOther.getCommFormulaCode() || getCommFormulaCode() != null && castOther.getCommFormulaCode() != null && getCommFormulaCode().equals(castOther.getCommFormulaCode()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getCommFormulaCode() != null ? getCommFormulaCode().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String commFormulaCode;
}
