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

public class DsDietTypeLangId
    implements Serializable
{

    public DsDietTypeLangId()
    {
    }

    public DsDietTypeLangId(String languageId, String dietType)
    {
        this.languageId = languageId;
        this.dietType = dietType;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String languageId)
    {
        this.languageId = languageId;
    }

    public String getDietType()
    {
        return dietType;
    }

    public void setDietType(String dietType)
    {
        this.dietType = dietType;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof DsDietTypeLangId))
            return false;
        DsDietTypeLangId castOther = (DsDietTypeLangId)other;
        return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getDietType() == castOther.getDietType() || getDietType() != null && castOther.getDietType() != null && getDietType().equals(castOther.getDietType()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        result = 37 * result + (getDietType() != null ? getDietType().hashCode() : 0);
        return result;
    }

    private String languageId;
    private String dietType;
}
