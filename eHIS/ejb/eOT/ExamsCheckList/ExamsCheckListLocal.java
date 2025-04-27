/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.ExamsCheckList;

import javax.ejb.EJBLocalObject ;
import java.rmi.RemoteException ;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;

public interface ExamsCheckListLocal extends EJBLocalObject {
	public String executeTransaction(HashMap tabData,String hdr_insert_sql,String dtl_insert_sql,String hdr_update_sql,String dtl_update_sql);
	public ArrayList updateRDCheckList(Properties prop,String sql,String appt_ref_num,String login_facility_id,String login_by_id,String login_at_ws_no);	
}
