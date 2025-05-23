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
 * DsEpsdDietProfileSuppl generated by MyEclipse - Hibernate Tools
 */

public class DsEpsdDietProfileSuppl  implements java.io.Serializable {


    // Fields    

     private DsEpsdDietProfileSupplId id;
     private String patientClass;
     private Date servingStartTime;
     private Date servingEndTime;
     private String mealType;
     private String itemType;
     private String itemCode;
     private Double itemQty;
     private Long itemCharge;
     private String chargeItem;
     private String mealPlanCreatedYn;
     private Date mealPlanCreatedDate;
     private Date mealPlanRefDate;
     private Long mealPlanRefDayNo;
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
    public DsEpsdDietProfileSuppl() {
    }

	/** minimal constructor */
    public DsEpsdDietProfileSuppl(DsEpsdDietProfileSupplId id, String patientClass, Date servingStartTime, String mealType, String itemType) {
        this.id = id;
        this.patientClass = patientClass;
        this.servingStartTime = servingStartTime;
        this.mealType = mealType;
        this.itemType = itemType;
    }
    
    /** full constructor */
    public DsEpsdDietProfileSuppl(DsEpsdDietProfileSupplId id, String patientClass, Date servingStartTime, Date servingEndTime, String mealType, String itemType, String itemCode, Double itemQty, Long itemCharge, String chargeItem, String mealPlanCreatedYn, Date mealPlanCreatedDate, Date mealPlanRefDate, Long mealPlanRefDayNo, String addedById, Date addedDate, String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo) {
        this.id = id;
        this.patientClass = patientClass;
        this.servingStartTime = servingStartTime;
        this.servingEndTime = servingEndTime;
        this.mealType = mealType;
        this.itemType = itemType;
        this.itemCode = itemCode;
        this.itemQty = itemQty;
        this.itemCharge = itemCharge;
        this.chargeItem = chargeItem;
        this.mealPlanCreatedYn = mealPlanCreatedYn;
        this.mealPlanCreatedDate = mealPlanCreatedDate;
        this.mealPlanRefDate = mealPlanRefDate;
        this.mealPlanRefDayNo = mealPlanRefDayNo;
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

    public DsEpsdDietProfileSupplId getId() {
        return this.id;
    }
    
    public void setId(DsEpsdDietProfileSupplId id) {
        this.id = id;
    }

    public String getPatientClass() {
        return this.patientClass;
    }
    
    public void setPatientClass(String patientClass) {
        this.patientClass = patientClass;
    }

    public Date getServingStartTime() {
        return this.servingStartTime;
    }
    
    public void setServingStartTime(Date servingStartTime) {
        this.servingStartTime = servingStartTime;
    }

    public Date getServingEndTime() {
        return this.servingEndTime;
    }
    
    public void setServingEndTime(Date servingEndTime) {
        this.servingEndTime = servingEndTime;
    }

    public String getMealType() {
        return this.mealType;
    }
    
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getItemType() {
        return this.itemType;
    }
    
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemCode() {
        return this.itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getItemQty() {
        return this.itemQty;
    }
    
    public void setItemQty(Double itemQty) {
        this.itemQty = itemQty;
    }

    public Long getItemCharge() {
        return this.itemCharge;
    }
    
    public void setItemCharge(Long itemCharge) {
        this.itemCharge = itemCharge;
    }

    public String getChargeItem() {
        return this.chargeItem;
    }
    
    public void setChargeItem(String chargeItem) {
        this.chargeItem = chargeItem;
    }

    public String getMealPlanCreatedYn() {
        return this.mealPlanCreatedYn;
    }
    
    public void setMealPlanCreatedYn(String mealPlanCreatedYn) {
        this.mealPlanCreatedYn = mealPlanCreatedYn;
    }

    public Date getMealPlanCreatedDate() {
        return this.mealPlanCreatedDate;
    }
    
    public void setMealPlanCreatedDate(Date mealPlanCreatedDate) {
        this.mealPlanCreatedDate = mealPlanCreatedDate;
    }

    public Date getMealPlanRefDate() {
        return this.mealPlanRefDate;
    }
    
    public void setMealPlanRefDate(Date mealPlanRefDate) {
        this.mealPlanRefDate = mealPlanRefDate;
    }

    public Long getMealPlanRefDayNo() {
        return this.mealPlanRefDayNo;
    }
    
    public void setMealPlanRefDayNo(Long mealPlanRefDayNo) {
        this.mealPlanRefDayNo = mealPlanRefDayNo;
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
