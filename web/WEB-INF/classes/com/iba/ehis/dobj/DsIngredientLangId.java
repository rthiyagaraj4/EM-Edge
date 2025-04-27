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

public class DsIngredientLangId
    implements Serializable
{

    public DsIngredientLangId()
    {
    }

    public DsIngredientLangId(String languageId, String ingredientCode)
    {
        this.languageId = languageId;
        this.ingredientCode = ingredientCode;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public String getIngredientCode()
    {
        return ingredientCode;
    }

    public void setIngredientCode(String ingredientCode)
    {
        this.ingredientCode = ingredientCode;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof DsIngredientLangId))
            return false;
        DsIngredientLangId castOther = (DsIngredientLangId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getIngredientCode() == castOther.getIngredientCode() || getIngredientCode() != null && castOther.getIngredientCode() != null && getIngredientCode().equals(castOther.getIngredientCode()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getIngredientCode() != null ? getIngredientCode().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String ingredientCode;
}
