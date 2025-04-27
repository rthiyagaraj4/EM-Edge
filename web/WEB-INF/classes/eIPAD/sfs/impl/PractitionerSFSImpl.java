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
package eIPAD.sfs.impl;

import eIPAD.HealthObjects.SFSContext;
import eIPAD.sfs.SFS;
import eIPAD.sfs.SFSReturnData;

/**
 * @author NavyaI
 * 
 */
public class PractitionerSFSImpl implements SFS {

	/**
	 * 
	 */
	public PractitionerSFSImpl() {
	}

	/**
	 * 
	 */
	public SFSReturnData getQuery(SFSContext oSFSContext) {
		// here the SQL Query string will be specific
		// for a practitioner
		String facility_id = oSFSContext.getSfacility_id();
		if(facility_id == null)
		{
			facility_id = "";
		}
		
		
		String practSearchText = (oSFSContext.getsSearchText()==null)?"":oSFSContext.getsSearchText();
		StringBuffer sqlStr = new StringBuffer("");
		
		
		sqlStr.append(" Select a.practitioner_id code , b.practitioner_name  description "); 
		sqlStr.append(" from am_pract_for_facility_vw a, am_practitioner_lang_vw b  ");
		sqlStr.append(" where a.operating_facility_id = '" + facility_id +"' and a.practitioner_id = b.practitioner_id "); 
		sqlStr.append(" and b.language_id = 'en' and a.eff_status = 'E'  and (upper(a.practitioner_id) like upper('%"+ practSearchText +"%') or upper(b.practitioner_name) like upper('%"+ practSearchText +"%'))  ORDER BY 2 ");
		/*and ROWNUM<50*/
		
		SFSReturnData returndata = new SFSReturnData();
		returndata.setQuery(sqlStr.toString());
		return returndata;

	}

}
