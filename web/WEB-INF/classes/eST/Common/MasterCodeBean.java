/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.Common;

import java.util.Hashtable;

public abstract class MasterCodeBean extends eST.Common.StAdapter {
	protected String	long_desc 		=	"";
	protected String	short_desc		=	"";
	protected String	eff_status		=	"E";

	public MasterCodeBean() 
	{

	}
	/* Set Methods Start */
	public void setLong_desc( String long_desc ) {
		this.long_desc		=	checkForNull(long_desc)  ;
	}

	public void setShort_desc( String short_desc ) {
		this.short_desc		=	checkForNull(short_desc)  ;
	}

	public void setEff_status( String eff_status ) {
		this.eff_status		=	checkForNull(eff_status,"D");
	}
	/* Set Methods End */

	/* Get Methods Start */
	public String getLong_desc() {
		return this.long_desc;
	}

	public String getShort_desc() {
		return this.short_desc ;
	}

	public String getEff_status() {
		return this.eff_status ;
	}
	/* Get Methods End */

	/* Over-ridden Adapter methods start here */

	public void clear() {
		super.clear() ;
		long_desc 		=	"" ;   
		short_desc		=	"" ;   
		eff_status		=	"E" ;   
	}

	public void setAll( Hashtable recordSet ) {
		super.setAll(recordSet);
		setLong_desc((String)recordSet.get("long_desc")) ;
		setShort_desc((String)recordSet.get("short_desc")) ;
		setEff_status((String)recordSet.get("eff_status")) ;
	}
	public String toString() {
		return "Long Description: " + long_desc + " Short Description: " + short_desc + " Eff_Status: " + eff_status +" Mode:"+mode;
	}
}
