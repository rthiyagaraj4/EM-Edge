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
import java.util.Date;

public class DsFoodItemLang implements Serializable
{
 
 public DsFoodItemLang(DsFoodItemLangId id)
 {
     this.id = id;
 }

 public DsFoodItemLang(DsFoodItemLangId id, String longDesc, String shortDesc, String addedById, Date addedDate, String addedFacilityId, String addedAtWsNo, 
         String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo)
 {
     this.id = id;
     this.longDesc = longDesc;
     this.shortDesc = shortDesc;
     this.addedById = addedById;
     this.addedDate = addedDate;
     this.addedFacilityId = addedFacilityId;
     this.addedAtWsNo = addedAtWsNo;
     this.modifiedById = modifiedById;
     this.modifiedDate = modifiedDate;
     this.modifiedFacilityId = modifiedFacilityId;
     this.modifiedAtWsNo = modifiedAtWsNo;
 }

 public DsFoodItemLangId getId()
 {
     return id;
 }

 public void setId(DsFoodItemLangId id)
 {
     this.id = id;
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

 public String getAddedById()
 {
     return addedById;
 }

 public void setAddedById(String addedById)
 {
     this.addedById = addedById;
 }

 public Date getAddedDate()
 {
     return addedDate;
 }

 public void setAddedDate(Date addedDate)
 {
     this.addedDate = addedDate;
 }

 public String getAddedFacilityId()
 {
     return addedFacilityId;
 }

 public void setAddedFacilityId(String addedFacilityId)
 {
     this.addedFacilityId = addedFacilityId;
 }

 public String getAddedAtWsNo()
 {
     return addedAtWsNo;
 }

 public void setAddedAtWsNo(String addedAtWsNo)
 {
     this.addedAtWsNo = addedAtWsNo;
 }

 public String getModifiedById()
 {
     return modifiedById;
 }

 public void setModifiedById(String modifiedById)
 {
     this.modifiedById = modifiedById;
 }

 public Date getModifiedDate()
 {
     return modifiedDate;
 }

 public void setModifiedDate(Date modifiedDate)
 {
     this.modifiedDate = modifiedDate;
 }

 public String getModifiedFacilityId()
 {
     return modifiedFacilityId;
 }

 public void setModifiedFacilityId(String modifiedFacilityId)
 {
     this.modifiedFacilityId = modifiedFacilityId;
 }

 public String getModifiedAtWsNo()
 {
     return modifiedAtWsNo;
 }

 public void setModifiedAtWsNo(String modifiedAtWsNo)
 {
     this.modifiedAtWsNo = modifiedAtWsNo;
 }

 private DsFoodItemLangId id;
 private String longDesc;
 private String shortDesc;
 private String addedById;
 private Date addedDate;
 private String addedFacilityId;
 private String addedAtWsNo;
 private String modifiedById;
 private Date modifiedDate;
 private String modifiedFacilityId;
 private String modifiedAtWsNo;
}
