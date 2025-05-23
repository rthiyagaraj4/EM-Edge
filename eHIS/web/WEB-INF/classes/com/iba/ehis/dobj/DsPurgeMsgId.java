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
 * DsPurgeMsgId generated by MyEclipse - Hibernate Tools
 */

public class DsPurgeMsgId  implements java.io.Serializable {


    // Fields    

     private String tableId;
     private String masterCode;
     private String msgNum;
     private String msgDesc;


    // Constructors

    /** default constructor */
    public DsPurgeMsgId() {
    }

    
    /** full constructor */
    public DsPurgeMsgId(String tableId, String masterCode, String msgNum, String msgDesc) {
        this.tableId = tableId;
        this.masterCode = masterCode;
        this.msgNum = msgNum;
        this.msgDesc = msgDesc;
    }

   
    // Property accessors

    public String getTableId() {
        return this.tableId;
    }
    
    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getMasterCode() {
        return this.masterCode;
    }
    
    public void setMasterCode(String masterCode) {
        this.masterCode = masterCode;
    }

    public String getMsgNum() {
        return this.msgNum;
    }
    
    public void setMsgNum(String msgNum) {
        this.msgNum = msgNum;
    }

    public String getMsgDesc() {
        return this.msgDesc;
    }
    
    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }
   








}
