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
 * DsDietMenuTimeTable generated by MyEclipse - Hibernate Tools
 */

public class DsDietMenuTimeTable  implements java.io.Serializable {


    // Fields    

     private DsDietMenuTimeTableId id;
     private DsMenu dsMenu;
     private Date fromServingTime;
     private Date toServingTime;
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
    public DsDietMenuTimeTable() {
    }

	/** minimal constructor */
    public DsDietMenuTimeTable(DsDietMenuTimeTableId id, DsMenu dsMenu) {
        this.id = id;
        this.dsMenu = dsMenu;
    }
    
    /** full constructor */
    public DsDietMenuTimeTable(DsDietMenuTimeTableId id, DsMenu dsMenu, Date fromServingTime, Date toServingTime, String effStatus, String addedById, Date addedDate, String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo) {
        this.id = id;
        this.dsMenu = dsMenu;
        this.fromServingTime = fromServingTime;
        this.toServingTime = toServingTime;
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

    public DsDietMenuTimeTableId getId() {
        return this.id;
    }
    
    public void setId(DsDietMenuTimeTableId id) {
        this.id = id;
    }

    public DsMenu getDsMenu() {
        return this.dsMenu;
    }
    
    public void setDsMenu(DsMenu dsMenu) {
        this.dsMenu = dsMenu;
    }

    public Date getFromServingTime() {
        return this.fromServingTime;
    }
    
    public void setFromServingTime(Date fromServingTime) {
        this.fromServingTime = fromServingTime;
    }

    public Date getToServingTime() {
        return this.toServingTime;
    }
    
    public void setToServingTime(Date toServingTime) {
        this.toServingTime = toServingTime;
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
