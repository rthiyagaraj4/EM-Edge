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

public class DsFoodItemLangVwId implements Serializable
{

 public DsFoodItemLangVwId(String languageId)
 {
     this.languageId = languageId;
 }

 public DsFoodItemLangVwId(String languageId, String foodItemCode, String longDesc, String shortDesc, String itemType, String servingUomCode, Long calorificContPerUom, 
         String prepUom, Long prepFactor, Long prepBaseQty, String effStatus, Long orderBy)
 {
     this.languageId = languageId;
     this.foodItemCode = foodItemCode;
     this.longDesc = longDesc;
     this.shortDesc = shortDesc;
     this.itemType = itemType;
     this.servingUomCode = servingUomCode;
     this.calorificContPerUom = calorificContPerUom;
     this.prepUom = prepUom;
     this.prepFactor = prepFactor;
     this.prepBaseQty = prepBaseQty;
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

 public String getFoodItemCode()
 {
     return foodItemCode;
 }

 public void setFoodItemCode(String foodItemCode)
 {
     this.foodItemCode = foodItemCode;
 }

 public String getLongDesc()
 {
     return longDesc;
 }

 public void setLongDesc(String longDesc)
 {
     this.longDesc = longDesc;
 }

 public String getShortDesc()
 {
     return shortDesc;
 }

 public void setShortDesc(String shortDesc)
 {
     this.shortDesc = shortDesc;
 }

 public String getItemType()
 {
     return itemType;
 }

 public void setItemType(String itemType)
 {
     this.itemType = itemType;
 }

 public String getServingUomCode()
 {
     return servingUomCode;
 }

 public void setServingUomCode(String servingUomCode)
 {
     this.servingUomCode = servingUomCode;
 }

 public Long getCalorificContPerUom()
 {
     return calorificContPerUom;
 }

 public void setCalorificContPerUom(Long calorificContPerUom)
 {
     this.calorificContPerUom = calorificContPerUom;
 }

 public String getPrepUom()
 {
     return prepUom;
 }

 public void setPrepUom(String prepUom)
 {
     this.prepUom = prepUom;
 }

 public Long getPrepFactor()
 {
     return prepFactor;
 }

 public void setPrepFactor(Long prepFactor)
 {
     this.prepFactor = prepFactor;
 }

 public Long getPrepBaseQty()
 {
     return prepBaseQty;
 }

 public void setPrepBaseQty(Long prepBaseQty)
 {
     this.prepBaseQty = prepBaseQty;
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
     if(!(other instanceof DsFoodItemLangVwId))
         return false;
     DsFoodItemLangVwId castOther = (DsFoodItemLangVwId)other;
     return (getLanguageId() == castOther.getLanguageId() || getLanguageId() != null && castOther.getLanguageId() != null && getLanguageId().equals(castOther.getLanguageId())) && (getFoodItemCode() == castOther.getFoodItemCode() || getFoodItemCode() != null && castOther.getFoodItemCode() != null && getFoodItemCode().equals(castOther.getFoodItemCode())) && (getLongDesc() == castOther.getLongDesc() || getLongDesc() != null && castOther.getLongDesc() != null && getLongDesc().equals(castOther.getLongDesc())) && (getShortDesc() == castOther.getShortDesc() || getShortDesc() != null && castOther.getShortDesc() != null && getShortDesc().equals(castOther.getShortDesc())) && (getItemType() == castOther.getItemType() || getItemType() != null && castOther.getItemType() != null && getItemType().equals(castOther.getItemType())) && (getServingUomCode() == castOther.getServingUomCode() || getServingUomCode() != null && castOther.getServingUomCode() != null && getServingUomCode().equals(castOther.getServingUomCode())) && (getCalorificContPerUom() == castOther.getCalorificContPerUom() || getCalorificContPerUom() != null && castOther.getCalorificContPerUom() != null && getCalorificContPerUom().equals(castOther.getCalorificContPerUom())) && (getPrepUom() == castOther.getPrepUom() || getPrepUom() != null && castOther.getPrepUom() != null && getPrepUom().equals(castOther.getPrepUom())) && (getPrepFactor() == castOther.getPrepFactor() || getPrepFactor() != null && castOther.getPrepFactor() != null && getPrepFactor().equals(castOther.getPrepFactor())) && (getPrepBaseQty() == castOther.getPrepBaseQty() || getPrepBaseQty() != null && castOther.getPrepBaseQty() != null && getPrepBaseQty().equals(castOther.getPrepBaseQty())) && (getEffStatus() == castOther.getEffStatus() || getEffStatus() != null && castOther.getEffStatus() != null && getEffStatus().equals(castOther.getEffStatus())) && (getOrderBy() == castOther.getOrderBy() || getOrderBy() != null && castOther.getOrderBy() != null && getOrderBy().equals(castOther.getOrderBy()));
 }

 public int hashCode()
 {
     int result = 17;
     result = 37 * result + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
     result = 37 * result + (getFoodItemCode() != null ? getFoodItemCode().hashCode() : 0);
     result = 37 * result + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
     result = 37 * result + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
     result = 37 * result + (getItemType() != null ? getItemType().hashCode() : 0);
     result = 37 * result + (getServingUomCode() != null ? getServingUomCode().hashCode() : 0);
     result = 37 * result + (getCalorificContPerUom() != null ? getCalorificContPerUom().hashCode() : 0);
     result = 37 * result + (getPrepUom() != null ? getPrepUom().hashCode() : 0);
     result = 37 * result + (getPrepFactor() != null ? getPrepFactor().hashCode() : 0);
     result = 37 * result + (getPrepBaseQty() != null ? getPrepBaseQty().hashCode() : 0);
     result = 37 * result + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
     result = 37 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
     return result;
 }

 private String languageId;
 private String foodItemCode;
 private String longDesc;
 private String shortDesc;
 private String itemType;
 private String servingUomCode;
 private Long calorificContPerUom;
 private String prepUom;
 private Long prepFactor;
 private Long prepBaseQty;
 private String effStatus;
 private Long orderBy;
}
