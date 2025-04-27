/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.Common ;

import eCommon.Common.* ;

import java.io.*;
import java.util.Hashtable;

public abstract class OTAdapter extends CommonAdapter implements Serializable {
	public boolean flag=true;
	public OTAdapter() {
		super( CommonRepository.getCommonKeyValue( "ID_OT" )  ) ;
	}
	// To set the Mode for the Local EJB or Remote EJB
	public void setLocalEJB(boolean flag){
		this.flag=flag;
	}

	// To get the Mode for the Local EJB or Remote EJB
	public boolean getLocalEJB(){
		return flag;
	}
	
	//Added by lakshmi against performing facility change
	  public void setAll( Hashtable recordSet ) {
	    }
	    
	    //Added by lakshmi against performing facility change
	    public void setFacilityId(String facility_id){
	    	
	    }
}
