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
import java.util.HashSet;
import java.util.Set;


/**
 * MpPatCategory generated by MyEclipse - Hibernate Tools
 */

public class MpPatCategory  implements java.io.Serializable {


    // Fields    

     private String patCatCode;
     private String longDesc;
     private String shortDesc;
     private String govtOrPvtInd;
     private Date effDateFrom;
     private Date effDateTo;
     private String effStatus;
     private String addedById;
     private Date addedDate;
     private String addedAtWsNo;
     private String addedFacilityId;
     private String modifiedById;
     private Date modifiedDate;
     private String modifiedAtWsNo;
     private String modifiedFacilityId;
     private String expValApplYn;
     private Long expPeriodInDays;
     private Set mpPatCategoryDerivRules = new HashSet(0);
     private Set mpEntitlementCriterias = new HashSet(0);
     private Set mpPatients = new HashSet(0);


    // Constructors

    /** default constructor */
    public MpPatCategory() {
    }

	/** minimal constructor */
    public MpPatCategory(String patCatCode) {
        this.patCatCode = patCatCode;
    }
    
    /** full constructor */
    public MpPatCategory(String patCatCode, String longDesc, String shortDesc, String govtOrPvtInd, Date effDateFrom, Date effDateTo, String effStatus, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, String expValApplYn, Long expPeriodInDays, Set mpPatCategoryDerivRules, Set mpEntitlementCriterias, Set mpPatients) {
        this.patCatCode = patCatCode;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.govtOrPvtInd = govtOrPvtInd;
        this.effDateFrom = effDateFrom;
        this.effDateTo = effDateTo;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.expValApplYn = expValApplYn;
        this.expPeriodInDays = expPeriodInDays;
        this.mpPatCategoryDerivRules = mpPatCategoryDerivRules;
        this.mpEntitlementCriterias = mpEntitlementCriterias;
        this.mpPatients = mpPatients;
    }

   
    // Property accessors

    public String getPatCatCode() {
        return this.patCatCode;
    }
    
    public void setPatCatCode(String patCatCode) {
        this.patCatCode = patCatCode;
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

    public String getGovtOrPvtInd() {
        return this.govtOrPvtInd;
    }
    
    public void setGovtOrPvtInd(String govtOrPvtInd) {
        this.govtOrPvtInd = govtOrPvtInd;
    }

    public Date getEffDateFrom() {
        return this.effDateFrom;
    }
    
    public void setEffDateFrom(Date effDateFrom) {
        this.effDateFrom = effDateFrom;
    }

    public Date getEffDateTo() {
        return this.effDateTo;
    }
    
    public void setEffDateTo(Date effDateTo) {
        this.effDateTo = effDateTo;
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

    public String getAddedAtWsNo() {
        return this.addedAtWsNo;
    }
    
    public void setAddedAtWsNo(String addedAtWsNo) {
        this.addedAtWsNo = addedAtWsNo;
    }

    public String getAddedFacilityId() {
        return this.addedFacilityId;
    }
    
    public void setAddedFacilityId(String addedFacilityId) {
        this.addedFacilityId = addedFacilityId;
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

    public String getModifiedAtWsNo() {
        return this.modifiedAtWsNo;
    }
    
    public void setModifiedAtWsNo(String modifiedAtWsNo) {
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public String getModifiedFacilityId() {
        return this.modifiedFacilityId;
    }
    
    public void setModifiedFacilityId(String modifiedFacilityId) {
        this.modifiedFacilityId = modifiedFacilityId;
    }

    public String getExpValApplYn() {
        return this.expValApplYn;
    }
    
    public void setExpValApplYn(String expValApplYn) {
        this.expValApplYn = expValApplYn;
    }

    public Long getExpPeriodInDays() {
        return this.expPeriodInDays;
    }
    
    public void setExpPeriodInDays(Long expPeriodInDays) {
        this.expPeriodInDays = expPeriodInDays;
    }

    public Set getMpPatCategoryDerivRules() {
        return this.mpPatCategoryDerivRules;
    }
    
    public void setMpPatCategoryDerivRules(Set mpPatCategoryDerivRules) {
        this.mpPatCategoryDerivRules = mpPatCategoryDerivRules;
    }

    public Set getMpEntitlementCriterias() {
        return this.mpEntitlementCriterias;
    }
    
    public void setMpEntitlementCriterias(Set mpEntitlementCriterias) {
        this.mpEntitlementCriterias = mpEntitlementCriterias;
    }

    public Set getMpPatients() {
        return this.mpPatients;
    }
    
    public void setMpPatients(Set mpPatients) {
        this.mpPatients = mpPatients;
    }
   








}
