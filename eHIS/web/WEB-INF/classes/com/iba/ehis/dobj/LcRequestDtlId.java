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
 * LcRequestDtlId generated by MyEclipse - Hibernate Tools
 */

public class LcRequestDtlId  implements java.io.Serializable {


    // Fields    

     private LcRequestHdr lcRequestHdr;
     private LcLinenItem lcLinenItem;


    // Constructors

    /** default constructor */
    public LcRequestDtlId() {
    }

    
    /** full constructor */
    public LcRequestDtlId(LcRequestHdr lcRequestHdr, LcLinenItem lcLinenItem) {
        this.lcRequestHdr = lcRequestHdr;
        this.lcLinenItem = lcLinenItem;
    }

   
    // Property accessors

    public LcRequestHdr getLcRequestHdr() {
        return this.lcRequestHdr;
    }
    
    public void setLcRequestHdr(LcRequestHdr lcRequestHdr) {
        this.lcRequestHdr = lcRequestHdr;
    }

    public LcLinenItem getLcLinenItem() {
        return this.lcLinenItem;
    }
    
    public void setLcLinenItem(LcLinenItem lcLinenItem) {
        this.lcLinenItem = lcLinenItem;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LcRequestDtlId) ) return false;
		 LcRequestDtlId castOther = ( LcRequestDtlId ) other; 
         
		 return ( (this.getLcRequestHdr()==castOther.getLcRequestHdr()) || ( this.getLcRequestHdr()!=null && castOther.getLcRequestHdr()!=null && this.getLcRequestHdr().equals(castOther.getLcRequestHdr()) ) )
 && ( (this.getLcLinenItem()==castOther.getLcLinenItem()) || ( this.getLcLinenItem()!=null && castOther.getLcLinenItem()!=null && this.getLcLinenItem().equals(castOther.getLcLinenItem()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLcRequestHdr() == null ? 0 : this.getLcRequestHdr().hashCode() );
         result = 37 * result + ( getLcLinenItem() == null ? 0 : this.getLcLinenItem().hashCode() );
         return result;
   }   





}
