/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.sfs;

import eIPAD.HealthObjects.SFSContext;

/**
 * This interface defines a SFS.
 * All SFS implementations implement this interface to return
 * SFS Data
 * @author NavyaI
 *
 */
public interface SFS {

	/**
	 * This method returns the SFSData which can be used
	 * to get data about SFS
	 * As of now, the SFSData contains only SQL Query string
	 * which can be executed readily
	 * @return
	 */
	public SFSReturnData getQuery(SFSContext oSFSContext);
	
}
