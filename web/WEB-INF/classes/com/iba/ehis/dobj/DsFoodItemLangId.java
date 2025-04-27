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

public class DsFoodItemLangId implements Serializable
{
public DsFoodItemLangId(String languageId, String foodItemCode)
 {
     this.languageId = languageId;
     this.foodItemCode = foodItemCode;
 }

 public String getLanguageId()
 {
     return languageId;
 }

 public void setLanguageId(String languageId)
 {
     this.languageId = languageId;
 }

 public String getFoodItemCode()
 {
     return foodItemCode;
 }

 public void setFoodItemCode(String foodItemCode)
 {
     this.foodItemCode = foodItemCode;
 }

 public boolean equals(Object other)
 {
     if(this == other)
         return true;
     if(other == null)
         return false;
     if(!(other instanceof DsFoodItemLangId))
         return false;
     DsFoodItemLangId castOther = (DsFoodItemLangId)other;
     return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getFoodItemCode() == castOther.getFoodItemCode() || getFoodItemCode() != null && castOther.getFoodItemCode() != null && getFoodItemCode().equals(castOther.getFoodItemCode()));
 }

 public int hashCode()
 {
     int result = 17;
     result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
     result = 37 * result + (getFoodItemCode() != null ? getFoodItemCode().hashCode() : 0);
     return result;
 }

 private String languageId;
 private String foodItemCode;
}
