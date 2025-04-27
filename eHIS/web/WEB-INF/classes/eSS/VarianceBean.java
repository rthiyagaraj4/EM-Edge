/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;
import eSS.Common.SsAdapter;

public class VarianceBean extends eSS.Common.SsTransaction implements Serializable {
	public VarianceBean() {
	}

	public String getPhyId() {
		String sql = (String) getSsRepositoryValue("SQL_SS_PHY_INV_PARAM_SELECT_LIST");
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,getLoginFacilityId());
		return getListOptionTag(alOptionValues);
	}

	public String getReport_type(){
		return getStaticListOptionTag( "D,Detail;S,Summary;" );
	}

	
		
}
