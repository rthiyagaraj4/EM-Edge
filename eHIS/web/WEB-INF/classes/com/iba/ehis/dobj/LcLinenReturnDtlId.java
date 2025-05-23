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
 * LcLinenReturnDtlId generated by MyEclipse - Hibernate Tools
 */

public class LcLinenReturnDtlId  implements java.io.Serializable {


    // Fields    

     private LcLinenReturnHdr lcLinenReturnHdr;
     private String linenItem;


    // Constructors

    /** default constructor */
    public LcLinenReturnDtlId() {
    }

    
    /** full constructor */
    public LcLinenReturnDtlId(LcLinenReturnHdr lcLinenReturnHdr, String linenItem) {
        this.lcLinenReturnHdr = lcLinenReturnHdr;
        this.linenItem = linenItem;
    }

   
    // Property accessors

    public LcLinenReturnHdr getLcLinenReturnHdr() {
        return this.lcLinenReturnHdr;
    }
    
    public void setLcLinenReturnHdr(LcLinenReturnHdr lcLinenReturnHdr) {
        this.lcLinenReturnHdr = lcLinenReturnHdr;
    }

    public String getLinenItem() {
        return this.linenItem;
    }
    
    public void setLinenItem(String linenItem) {
        this.linenItem = linenItem;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LcLinenReturnDtlId) ) return false;
		 LcLinenReturnDtlId castOther = ( LcLinenReturnDtlId ) other; 
         
		 return ( (this.getLcLinenReturnHdr()==castOther.getLcLinenReturnHdr()) || ( this.getLcLinenReturnHdr()!=null && castOther.getLcLinenReturnHdr()!=null && this.getLcLinenReturnHdr().equals(castOther.getLcLinenReturnHdr()) ) )
 && ( (this.getLinenItem()==castOther.getLinenItem()) || ( this.getLinenItem()!=null && castOther.getLinenItem()!=null && this.getLinenItem().equals(castOther.getLinenItem()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLcLinenReturnHdr() == null ? 0 : this.getLcLinenReturnHdr().hashCode() );
         result = 37 * result + ( getLinenItem() == null ? 0 : this.getLinenItem().hashCode() );
         return result;
   }   





}
