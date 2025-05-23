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
 * AmAmbulatoryStatus generated by MyEclipse - Hibernate Tools
 */

public class AmAmbulatoryStatus  implements java.io.Serializable {


    // Fields    

     private String ambulatoryStatus;
     private String longDesc;
     private String shortDesc;
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
     private Set prEncounters = new HashSet(0);


    // Constructors

    /** default constructor */
    public AmAmbulatoryStatus() {
    }

	/** minimal constructor */
    public AmAmbulatoryStatus(String ambulatoryStatus) {
        this.ambulatoryStatus = ambulatoryStatus;
    }
    
    /** full constructor */
    public AmAmbulatoryStatus(String ambulatoryStatus, String longDesc, String shortDesc, Date effDateFrom, Date effDateTo, String effStatus, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, Set prEncounters) {
        this.ambulatoryStatus = ambulatoryStatus;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
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
        this.prEncounters = prEncounters;
    }

   
    // Property accessors

    public String getAmbulatoryStatus() {
        return this.ambulatoryStatus;
    }
    
    public void setAmbulatoryStatus(String ambulatoryStatus) {
        this.ambulatoryStatus = ambulatoryStatus;
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

    public Set getPrEncounters() {
        return this.prEncounters;
    }
    
    public void setPrEncounters(Set prEncounters) {
        this.prEncounters = prEncounters;
    }
   








}
