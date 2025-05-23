/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.dobj;

import java.util.Date;


/**
 * DsItemType generated by MyEclipse - Hibernate Tools
 */

public class DsItemType  implements java.io.Serializable {


    // Fields    

     private String itemType;
     private String longDesc;
     private String shortDesc;
     private String commFormulaYn;
     private String applDietCategory;
     private String effStatus;
     private String addedById;
     private Date addedDate;
     private String addedFacilityId;
     private String addedAtWsNo;
     private String modifiedById;
     private Date modifiedDate;
     private String modifiedFacilityId;
     private String modifiedAtWsNo;


    // Constructors

    /** default constructor */
    public DsItemType() {
    }

	/** minimal constructor */
    public DsItemType(String itemType, String longDesc, String shortDesc) {
        this.itemType = itemType;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
    }
    
    /** full constructor */
    public DsItemType(String itemType, String longDesc, String shortDesc, String commFormulaYn, String applDietCategory, String effStatus, String addedById, Date addedDate, String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo) {
        this.itemType = itemType;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.commFormulaYn = commFormulaYn;
        this.applDietCategory = applDietCategory;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

   
    // Property accessors

    public String getItemType() {
        return this.itemType;
    }
    
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getLongDesc() {
        return this.longDesc;
    }
    
    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getShortDesc() {
        return this.shortDesc;
    }
    
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getCommFormulaYn() {
        return this.commFormulaYn;
    }
    
    public void setCommFormulaYn(String commFormulaYn) {
        this.commFormulaYn = commFormulaYn;
    }

    public String getApplDietCategory() {
        return this.applDietCategory;
    }
    
    public void setApplDietCategory(String applDietCategory) {
        this.applDietCategory = applDietCategory;
    }

    public String getEffStatus() {
        return this.effStatus;
    }
    
    public void setEffStatus(String effStatus) {
        this.effStatus = effStatus;
    }

    public String getAddedById() {
        return this.addedById;
    }
    
    public void setAddedById(String addedById) {
        this.addedById = addedById;
    }

    public Date getAddedDate() {
        return this.addedDate;
    }
    
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getAddedFacilityId() {
        return this.addedFacilityId;
    }
    
    public void setAddedFacilityId(String addedFacilityId) {
        this.addedFacilityId = addedFacilityId;
    }

    public String getAddedAtWsNo() {
        return this.addedAtWsNo;
    }
    
    public void setAddedAtWsNo(String addedAtWsNo) {
        this.addedAtWsNo = addedAtWsNo;
    }

    public String getModifiedById() {
        return this.modifiedById;
    }
    
    public void setModifiedById(String modifiedById) {
        this.modifiedById = modifiedById;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }
    
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedFacilityId() {
        return this.modifiedFacilityId;
    }
    
    public void setModifiedFacilityId(String modifiedFacilityId) {
        this.modifiedFacilityId = modifiedFacilityId;
    }

    public String getModifiedAtWsNo() {
        return this.modifiedAtWsNo;
    }
    
    public void setModifiedAtWsNo(String modifiedAtWsNo) {
        this.modifiedAtWsNo = modifiedAtWsNo;
    }
   








}
