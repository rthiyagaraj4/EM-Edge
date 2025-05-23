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
 * MpAlternateIdType generated by MyEclipse - Hibernate Tools
 */

public class MpAlternateIdType  implements java.io.Serializable {


    // Fields    

     private String altIdType;
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
     private Set mpPatRelContactsesForContact2OthAltIdType = new HashSet(0);
     private Set mpParamsForAltId3Type = new HashSet(0);
     private Set mpPatientsForOthAltIdType = new HashSet(0);
     private Set mpPatRelContactsesForContact1AltId1Type = new HashSet(0);
     private Set mpParamsForAltId4Type = new HashSet(0);
     private Set mpBirthRegisters = new HashSet(0);
     private Set mpParamsForAltId1Type = new HashSet(0);
     private Set mpPatientsForAltId3Type = new HashSet(0);
     private Set mpPatRelContactsesForContact1AltId2Type = new HashSet(0);
     private Set mpPatRelContactsesForContact1OthAltIdType = new HashSet(0);
     private Set mpParamsForAltId2Type = new HashSet(0);
     private Set mpPatientsForAltId2Type = new HashSet(0);
     private Set mpPatRelContactsesForContact1AltId3Type = new HashSet(0);
     private Set mpPatientsForAltId4Type = new HashSet(0);
     private Set mpPatientsForAltId1Type = new HashSet(0);
     private Set mpPatRelContactsesForContact1AltId4Type = new HashSet(0);


    // Constructors

    /** default constructor */
    public MpAlternateIdType() {
    }

	/** minimal constructor */
    public MpAlternateIdType(String altIdType) {
        this.altIdType = altIdType;
    }
    
    /** full constructor */
    public MpAlternateIdType(String altIdType, String longDesc, String shortDesc, Date effDateFrom, Date effDateTo, String effStatus, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, Set mpPatRelContactsesForContact2OthAltIdType, Set mpParamsForAltId3Type, Set mpPatientsForOthAltIdType, Set mpPatRelContactsesForContact1AltId1Type, Set mpParamsForAltId4Type, Set mpBirthRegisters, Set mpParamsForAltId1Type, Set mpPatientsForAltId3Type, Set mpPatRelContactsesForContact1AltId2Type, Set mpPatRelContactsesForContact1OthAltIdType, Set mpParamsForAltId2Type, Set mpPatientsForAltId2Type, Set mpPatRelContactsesForContact1AltId3Type, Set mpPatientsForAltId4Type, Set mpPatientsForAltId1Type, Set mpPatRelContactsesForContact1AltId4Type) {
        this.altIdType = altIdType;
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
        this.mpPatRelContactsesForContact2OthAltIdType = mpPatRelContactsesForContact2OthAltIdType;
        this.mpParamsForAltId3Type = mpParamsForAltId3Type;
        this.mpPatientsForOthAltIdType = mpPatientsForOthAltIdType;
        this.mpPatRelContactsesForContact1AltId1Type = mpPatRelContactsesForContact1AltId1Type;
        this.mpParamsForAltId4Type = mpParamsForAltId4Type;
        this.mpBirthRegisters = mpBirthRegisters;
        this.mpParamsForAltId1Type = mpParamsForAltId1Type;
        this.mpPatientsForAltId3Type = mpPatientsForAltId3Type;
        this.mpPatRelContactsesForContact1AltId2Type = mpPatRelContactsesForContact1AltId2Type;
        this.mpPatRelContactsesForContact1OthAltIdType = mpPatRelContactsesForContact1OthAltIdType;
        this.mpParamsForAltId2Type = mpParamsForAltId2Type;
        this.mpPatientsForAltId2Type = mpPatientsForAltId2Type;
        this.mpPatRelContactsesForContact1AltId3Type = mpPatRelContactsesForContact1AltId3Type;
        this.mpPatientsForAltId4Type = mpPatientsForAltId4Type;
        this.mpPatientsForAltId1Type = mpPatientsForAltId1Type;
        this.mpPatRelContactsesForContact1AltId4Type = mpPatRelContactsesForContact1AltId4Type;
    }

   
    // Property accessors

    public String getAltIdType() {
        return this.altIdType;
    }
    
    public void setAltIdType(String altIdType) {
        this.altIdType = altIdType;
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

    public Set getMpPatRelContactsesForContact2OthAltIdType() {
        return this.mpPatRelContactsesForContact2OthAltIdType;
    }
    
    public void setMpPatRelContactsesForContact2OthAltIdType(Set mpPatRelContactsesForContact2OthAltIdType) {
        this.mpPatRelContactsesForContact2OthAltIdType = mpPatRelContactsesForContact2OthAltIdType;
    }

    public Set getMpParamsForAltId3Type() {
        return this.mpParamsForAltId3Type;
    }
    
    public void setMpParamsForAltId3Type(Set mpParamsForAltId3Type) {
        this.mpParamsForAltId3Type = mpParamsForAltId3Type;
    }

    public Set getMpPatientsForOthAltIdType() {
        return this.mpPatientsForOthAltIdType;
    }
    
    public void setMpPatientsForOthAltIdType(Set mpPatientsForOthAltIdType) {
        this.mpPatientsForOthAltIdType = mpPatientsForOthAltIdType;
    }

    public Set getMpPatRelContactsesForContact1AltId1Type() {
        return this.mpPatRelContactsesForContact1AltId1Type;
    }
    
    public void setMpPatRelContactsesForContact1AltId1Type(Set mpPatRelContactsesForContact1AltId1Type) {
        this.mpPatRelContactsesForContact1AltId1Type = mpPatRelContactsesForContact1AltId1Type;
    }

    public Set getMpParamsForAltId4Type() {
        return this.mpParamsForAltId4Type;
    }
    
    public void setMpParamsForAltId4Type(Set mpParamsForAltId4Type) {
        this.mpParamsForAltId4Type = mpParamsForAltId4Type;
    }

    public Set getMpBirthRegisters() {
        return this.mpBirthRegisters;
    }
    
    public void setMpBirthRegisters(Set mpBirthRegisters) {
        this.mpBirthRegisters = mpBirthRegisters;
    }

    public Set getMpParamsForAltId1Type() {
        return this.mpParamsForAltId1Type;
    }
    
    public void setMpParamsForAltId1Type(Set mpParamsForAltId1Type) {
        this.mpParamsForAltId1Type = mpParamsForAltId1Type;
    }

    public Set getMpPatientsForAltId3Type() {
        return this.mpPatientsForAltId3Type;
    }
    
    public void setMpPatientsForAltId3Type(Set mpPatientsForAltId3Type) {
        this.mpPatientsForAltId3Type = mpPatientsForAltId3Type;
    }

    public Set getMpPatRelContactsesForContact1AltId2Type() {
        return this.mpPatRelContactsesForContact1AltId2Type;
    }
    
    public void setMpPatRelContactsesForContact1AltId2Type(Set mpPatRelContactsesForContact1AltId2Type) {
        this.mpPatRelContactsesForContact1AltId2Type = mpPatRelContactsesForContact1AltId2Type;
    }

    public Set getMpPatRelContactsesForContact1OthAltIdType() {
        return this.mpPatRelContactsesForContact1OthAltIdType;
    }
    
    public void setMpPatRelContactsesForContact1OthAltIdType(Set mpPatRelContactsesForContact1OthAltIdType) {
        this.mpPatRelContactsesForContact1OthAltIdType = mpPatRelContactsesForContact1OthAltIdType;
    }

    public Set getMpParamsForAltId2Type() {
        return this.mpParamsForAltId2Type;
    }
    
    public void setMpParamsForAltId2Type(Set mpParamsForAltId2Type) {
        this.mpParamsForAltId2Type = mpParamsForAltId2Type;
    }

    public Set getMpPatientsForAltId2Type() {
        return this.mpPatientsForAltId2Type;
    }
    
    public void setMpPatientsForAltId2Type(Set mpPatientsForAltId2Type) {
        this.mpPatientsForAltId2Type = mpPatientsForAltId2Type;
    }

    public Set getMpPatRelContactsesForContact1AltId3Type() {
        return this.mpPatRelContactsesForContact1AltId3Type;
    }
    
    public void setMpPatRelContactsesForContact1AltId3Type(Set mpPatRelContactsesForContact1AltId3Type) {
        this.mpPatRelContactsesForContact1AltId3Type = mpPatRelContactsesForContact1AltId3Type;
    }

    public Set getMpPatientsForAltId4Type() {
        return this.mpPatientsForAltId4Type;
    }
    
    public void setMpPatientsForAltId4Type(Set mpPatientsForAltId4Type) {
        this.mpPatientsForAltId4Type = mpPatientsForAltId4Type;
    }

    public Set getMpPatientsForAltId1Type() {
        return this.mpPatientsForAltId1Type;
    }
    
    public void setMpPatientsForAltId1Type(Set mpPatientsForAltId1Type) {
        this.mpPatientsForAltId1Type = mpPatientsForAltId1Type;
    }

    public Set getMpPatRelContactsesForContact1AltId4Type() {
        return this.mpPatRelContactsesForContact1AltId4Type;
    }
    
    public void setMpPatRelContactsesForContact1AltId4Type(Set mpPatRelContactsesForContact1AltId4Type) {
        this.mpPatRelContactsesForContact1AltId4Type = mpPatRelContactsesForContact1AltId4Type;
    }
   








}
