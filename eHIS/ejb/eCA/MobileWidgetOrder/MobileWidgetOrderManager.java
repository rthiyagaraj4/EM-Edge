/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA.MobileWidgetOrder; 

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="MobileWidgetOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="MobileWidgetOrder"
*	local-jndi-name="MobileWidgetOrder"
*	impl-class-name=eCA.MobileWidgetOrder.MobileWidgetOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.MobileWidgetOrder.MobileWidgetOrderLocal"
*	remote-class="eCA.MobileWidgetOrder.MobileWidgetOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.MobileWidgetOrder.MobileWidgetOrderLocalHome"
*	remote-class="eCA.MobileWidgetOrder.MobileWidgetOrderHome"
*	generate= "local,remote"
*
*
*/

public class MobileWidgetOrderManager implements SessionBean 
{
	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext(SessionContext sessionContext) 
	{
		this.ctx = sessionContext;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertWidgetOrder
								(
									java.util.Properties p,
									java.util.HashMap htWidgetOrder
								)	
	{
		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;
		CallableStatement cs = null;

		java.util.HashMap results =	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;

		
		String locale = "";
		String error1 = "";
		
		String appl_user_id;
		String facility_id;
		int wid_vitals;
		int wid_allergy;
		int wid_procedure;
		int wid_problems;
		int wid_notes;
		int wid_results;
		int wid_pendingorders;
		int wid_medications;
		String accessed_item_cat;
		String accessed_item_value;
		String access_date_time;
		String resp_id;
		String added_by_id;
		String added_date;
		String added_at_ws_no;
		String added_facility_id;
		String modified_by_id;
		String modified_date;
		String modified_at_ws_no;
		String modified_facility_id;
		
		
		boolean result = false, commit_flag = true ;
		int insert_result = 0;

		try
		{
			
			/*facility_id			=	(String) htRecentAccess.get ( "facility_id"		);
			//episode_type		=	(String) htRecentAccess.get ( "episode_type"		);
			
			//visit_id			=	(String) htRecentAccess.get ( "visit_id"			);
			//phys_prov_id		=	(String) htRecentAccess.get ( "phys_prov_id"		);
			
			begin_date_time		=	(String) htRecentAccess.get ( "begin_date_time"	);
			end_date_time		=	(String) htRecentAccess.get ( "end_date_time"		);
			
			//login_user_id		=	(String) htRecentAccess.get ( "login_user_id"		);
			
			patient_class		=	(String) htRecentAccess.get ( "patient_class"	);
			practitioner_id		=	(String) htRecentAccess.get ( "practitioner_id");
			
			addedAtWorkstation	=	(String) htRecentAccess.get ( "added_at_ws_no");
			fromOpenChart_yn	=	(String) htRecentAccess.get ( "fromOpenChart_yn");*/
			
			appl_user_id = (String)htWidgetOrder.get("login_user");
			facility_id = (String)htWidgetOrder.get("facility_id");
			/*wid_vitals = (Integer)htWidgetOrder.get("wid_vitals");
			wid_allergy = (Integer)htWidgetOrder.get("wid_allergy");
			wid_procedure = (Integer)htWidgetOrder.get("wid_procedure");
			wid_problems = (Integer)htWidgetOrder.get("wid_problems");
			wid_notes = (Integer)htWidgetOrder.get("wid_notes");
			wid_results = (Integer)htWidgetOrder.get("wid_results");
			wid_pendingorders = (Integer)htWidgetOrder.get("wid_pendingorders");
			wid_medications = (Integer)htWidgetOrder.get("wid_medications");*/
			HashMap<String,Integer> widgetOrderHash = (HashMap<String,Integer>)htWidgetOrder.get("widgetOrderHash");
			added_by_id = p.getProperty("login_user");
			added_at_ws_no = (String)htWidgetOrder.get("wsNo");
			added_facility_id =	facility_id;
			modified_by_id = added_by_id;
			modified_at_ws_no = added_at_ws_no;
			modified_facility_id = added_facility_id;


			//ecis_jdbc_driver	=	p.getProperty("ecis_jdbc_driver");
			//ecis_jdbc_dns 		=	p.getProperty("ecis_jdbc_dns");
			//ecis_jdbc_user		=	p.getProperty("ecis_jdbc_user");
			//ecis_jdbc_password	=	p.getProperty("ecis_jdbc_password");


			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			for (String widget_id : widgetOrderHash.keySet()) {
				
				int widget_order = widgetOrderHash.get(widget_id);
				cs = con.prepareCall("{call MAINTAIN_MOBILE_WIDGET_ORDER (?,?,?,?,sysdate,?,?,?,sysdate,?,?) }" );

				cs.setString(1, appl_user_id);
				cs.setString(2, widget_id);
				cs.setInt(3, widget_order);
				cs.setString(4, added_by_id);
				//sysdate
				cs.setString(5, added_at_ws_no);
				cs.setString(6, added_facility_id);
				cs.setString(7, modified_by_id);
				//sysdate
				cs.setString(8, modified_at_ws_no);
				cs.setString(9, modified_facility_id);
				cs.execute();
				if(cs!=null) cs.close();
			}
			//con.commit();
		}
		catch(Exception e)
		{
			commit_flag = false;
			sb.append("Exception@EJB1:"+e);
		}
		finally
		{
			try
			{
				htWidgetOrder.clear();
				if(commit_flag)
				{
					result = true ;
					error1 = getMessage(locale,"RECORD_INSERTED","CA");
					sb.append( error1 ) ;
					con.commit();
				} // if(commit_flag)
				else
				{
					commit_flag = false;
					con.rollback();
				}
			}
			catch(Exception e)
			{
				commit_flag = false;
				sb.append("Exception@EJB2:"+e);
				try
				{
					con.rollback();
				}
				catch(Exception e1) {e1.printStackTrace();}
			}
			finally
			{	try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null) ConnectionManager.returnConnection(con,p);
				}catch(Exception eClose){eClose.printStackTrace();}
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	} // end of method insertMobileWidgetOrderData


	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
} // end of class MobileWidgetOrderManager 

