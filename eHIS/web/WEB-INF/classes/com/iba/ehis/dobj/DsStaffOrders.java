/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.dobj;



/**
 * DsStaffOrders generated by MyEclipse - Hibernate Tools
 */

public class DsStaffOrders  implements java.io.Serializable {


    // Fields    

     private DsStaffOrdersId id;
     private DsDietType dsDietType;


    // Constructors

    /** default constructor */
    public DsStaffOrders() {
    }

	/** minimal constructor */
    public DsStaffOrders(DsStaffOrdersId id) {
        this.id = id;
    }
    
    /** full constructor */
    public DsStaffOrders(DsStaffOrdersId id, DsDietType dsDietType) {
        this.id = id;
        this.dsDietType = dsDietType;
    }

   
    // Property accessors

    public DsStaffOrdersId getId() {
        return this.id;
    }
    
    public void setId(DsStaffOrdersId id) {
        this.id = id;
    }

    public DsDietType getDsDietType() {
        return this.dsDietType;
    }
    
    public void setDsDietType(DsDietType dsDietType) {
        this.dsDietType = dsDietType;
    }
   








}
