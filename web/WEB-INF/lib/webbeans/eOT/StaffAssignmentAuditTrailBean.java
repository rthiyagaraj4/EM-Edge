/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eOT;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import webbeans.eCommon.ConnectionManager;
import webbeans.eOT.StaffAssignmentTimeBean;
import eOT.Common.OTRepository;

public class StaffAssignmentAuditTrailBean extends StaffAssignmentTimeBean
		implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3890871966646590219L;
	
	private String newFromTime;
	private String newToTime;
	private String newShowWidgetYN;
	
	public String getNewFromTime() {
		return newFromTime;
	}

	public void setNewFromTime(String newFromTime) {
		this.newFromTime = newFromTime;
	}

	public String getNewToTime() {
		return newToTime;
	}

	public void setNewToTime(String newToTime) {
		this.newToTime = newToTime;
	}
	
	public String getNewShowWidgetYN() {
		return newShowWidgetYN;
	}

	public void setNewShowWidgetYN(String newShowWidgetYN) {
		this.newShowWidgetYN = newShowWidgetYN;
	}
}
