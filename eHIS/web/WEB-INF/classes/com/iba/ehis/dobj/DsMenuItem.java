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
 * DsMenuItem generated by MyEclipse - Hibernate Tools
 */

public class DsMenuItem  implements java.io.Serializable {


    // Fields    

     private DsMenuItemId id;
     private String itemType;
     private Double itemQty;
     private String alternateItemCode;
     private Double alternateItemQty;
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
    public DsMenuItem() {
    }

	/** minimal constructor */
    public DsMenuItem(DsMenuItemId id, String itemType, Double itemQty) {
        this.id = id;
        this.itemType = itemType;
        this.itemQty = itemQty;
    }
    
    /** full constructor */
    public DsMenuItem(DsMenuItemId id, String itemType, Double itemQty, String alternateItemCode, Double alternateItemQty, String addedById, Date addedDate, String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo) {
        this.id = id;
        this.itemType = itemType;
        this.itemQty = itemQty;
        this.alternateItemCode = alternateItemCode;
        this.alternateItemQty = alternateItemQty;
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

    public DsMenuItemId getId() {
        return this.id;
    }
    
    public void setId(DsMenuItemId id) {
        this.id = id;
    }

    public String getItemType() {
        return this.itemType;
    }
    
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Double getItemQty() {
        return this.itemQty;
    }
    
    public void setItemQty(Double itemQty) {
        this.itemQty = itemQty;
    }

    public String getAlternateItemCode() {
        return this.alternateItemCode;
    }
    
    public void setAlternateItemCode(String alternateItemCode) {
        this.alternateItemCode = alternateItemCode;
    }

    public Double getAlternateItemQty() {
        return this.alternateItemQty;
    }
    
    public void setAlternateItemQty(Double alternateItemQty) {
        this.alternateItemQty = alternateItemQty;
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
