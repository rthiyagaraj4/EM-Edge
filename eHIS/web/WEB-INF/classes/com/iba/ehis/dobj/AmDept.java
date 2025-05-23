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
 * AmDept generated by MyEclipse - Hibernate Tools
 */

public class AmDept  implements java.io.Serializable {


    // Fields    

     private String deptCode;
     private String longDesc;
     private String shortDesc;
     private String accEntityId;
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
     private Set amDeptSections = new HashSet(0);
     private Set ipNursUnitForServices = new HashSet(0);
     private Set dsParams = new HashSet(0);
     private Set opClinicForServices = new HashSet(0);
     private Set amFacilityDepts = new HashSet(0);


    // Constructors

    /** default constructor */
    public AmDept() {
    }

	/** minimal constructor */
    public AmDept(String deptCode) {
        this.deptCode = deptCode;
    }
    
    /** full constructor */
    public AmDept(String deptCode, String longDesc, String shortDesc, String accEntityId, Date effDateFrom, Date effDateTo, String effStatus, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, Set amDeptSections, Set ipNursUnitForServices, Set dsParams, Set opClinicForServices, Set amFacilityDepts) {
        this.deptCode = deptCode;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.accEntityId = accEntityId;
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
        this.amDeptSections = amDeptSections;
        this.ipNursUnitForServices = ipNursUnitForServices;
        this.dsParams = dsParams;
        this.opClinicForServices = opClinicForServices;
        this.amFacilityDepts = amFacilityDepts;
    }

   
    // Property accessors

    public String getDeptCode() {
        return this.deptCode;
    }
    
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
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

    public String getAccEntityId() {
        return this.accEntityId;
    }
    
    public void setAccEntityId(String accEntityId) {
        this.accEntityId = accEntityId;
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

    public Set getAmDeptSections() {
        return this.amDeptSections;
    }
    
    public void setAmDeptSections(Set amDeptSections) {
        this.amDeptSections = amDeptSections;
    }

    public Set getIpNursUnitForServices() {
        return this.ipNursUnitForServices;
    }
    
    public void setIpNursUnitForServices(Set ipNursUnitForServices) {
        this.ipNursUnitForServices = ipNursUnitForServices;
    }

    public Set getDsParams() {
        return this.dsParams;
    }
    
    public void setDsParams(Set dsParams) {
        this.dsParams = dsParams;
    }

    public Set getOpClinicForServices() {
        return this.opClinicForServices;
    }
    
    public void setOpClinicForServices(Set opClinicForServices) {
        this.opClinicForServices = opClinicForServices;
    }

    public Set getAmFacilityDepts() {
        return this.amFacilityDepts;
    }
    
    public void setAmFacilityDepts(Set amFacilityDepts) {
        this.amFacilityDepts = amFacilityDepts;
    }
   








}
