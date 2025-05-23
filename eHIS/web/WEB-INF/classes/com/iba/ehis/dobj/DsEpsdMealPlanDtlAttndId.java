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
 * DsEpsdMealPlanDtlAttndId generated by MyEclipse - Hibernate Tools
 */

public class DsEpsdMealPlanDtlAttndId  implements java.io.Serializable {


    // Fields    

     private DsEpsdMealPlanHdrAttnd dsEpsdMealPlanHdrAttnd;
     private String itemCode;


    // Constructors

    /** default constructor */
    public DsEpsdMealPlanDtlAttndId() {
    }

    
    /** full constructor */
    public DsEpsdMealPlanDtlAttndId(DsEpsdMealPlanHdrAttnd dsEpsdMealPlanHdrAttnd, String itemCode) {
        this.dsEpsdMealPlanHdrAttnd = dsEpsdMealPlanHdrAttnd;
        this.itemCode = itemCode;
    }

   
    // Property accessors

    public DsEpsdMealPlanHdrAttnd getDsEpsdMealPlanHdrAttnd() {
        return this.dsEpsdMealPlanHdrAttnd;
    }
    
    public void setDsEpsdMealPlanHdrAttnd(DsEpsdMealPlanHdrAttnd dsEpsdMealPlanHdrAttnd) {
        this.dsEpsdMealPlanHdrAttnd = dsEpsdMealPlanHdrAttnd;
    }

    public String getItemCode() {
        return this.itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
   








}
