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
 * LcAgencyLangVwId generated by MyEclipse - Hibernate Tools
 */

public class LcAgencyLangVwId  implements java.io.Serializable {


    // Fields    

     private String languageId;
     private String agencyCode;
     private String agencyName;
     private Long orderBy;


    // Constructors

    /** default constructor */
    public LcAgencyLangVwId() {
    }

	/** minimal constructor */
    public LcAgencyLangVwId(String languageId) {
        this.languageId = languageId;
    }
    
    /** full constructor */
    public LcAgencyLangVwId(String languageId, String agencyCode, String agencyName, Long orderBy) {
        this.languageId = languageId;
        this.agencyCode = agencyCode;
        this.agencyName = agencyName;
        this.orderBy = orderBy;
    }

   
    // Property accessors

    public String getLanguageId() {
        return this.languageId;
    }
    
    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getAgencyCode() {
        return this.agencyCode;
    }
    
    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getAgencyName() {
        return this.agencyName;
    }
    
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public Long getOrderBy() {
        return this.orderBy;
    }
    
    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LcAgencyLangVwId) ) return false;
		 LcAgencyLangVwId castOther = ( LcAgencyLangVwId ) other; 
         
		 return ( (this.getLanguageId()==castOther.getLanguageId()) || ( this.getLanguageId()!=null && castOther.getLanguageId()!=null && this.getLanguageId().equals(castOther.getLanguageId()) ) )
 && ( (this.getAgencyCode()==castOther.getAgencyCode()) || ( this.getAgencyCode()!=null && castOther.getAgencyCode()!=null && this.getAgencyCode().equals(castOther.getAgencyCode()) ) )
 && ( (this.getAgencyName()==castOther.getAgencyName()) || ( this.getAgencyName()!=null && castOther.getAgencyName()!=null && this.getAgencyName().equals(castOther.getAgencyName()) ) )
 && ( (this.getOrderBy()==castOther.getOrderBy()) || ( this.getOrderBy()!=null && castOther.getOrderBy()!=null && this.getOrderBy().equals(castOther.getOrderBy()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLanguageId() == null ? 0 : this.getLanguageId().hashCode() );
         result = 37 * result + ( getAgencyCode() == null ? 0 : this.getAgencyCode().hashCode() );
         result = 37 * result + ( getAgencyName() == null ? 0 : this.getAgencyName().hashCode() );
         result = 37 * result + ( getOrderBy() == null ? 0 : this.getOrderBy().hashCode() );
         return result;
   }   





}
