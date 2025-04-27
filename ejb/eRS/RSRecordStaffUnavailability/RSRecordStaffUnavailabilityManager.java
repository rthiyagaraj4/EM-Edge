/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSRecordStaffUnavailability;

import java.rmi.* ;
import java.sql.* ;
import java.util.* ;
import javax.ejb.* ;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="RSRecordStaffUnavailability"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSRecordStaffUnavailability"
*	local-jndi-name="RSRecordStaffUnavailability"
*	impl-class-name="eRS.RSRecordStaffUnavailability.RSRecordStaffUnavailabilityManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSRecordStaffUnavailability.RSRecordStaffUnavailabilityLocal"
*	remote-class="eRS.RSRecordStaffUnavailability.RSRecordStaffUnavailabilityRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSRecordStaffUnavailability.RSRecordStaffUnavailabilityLocalHome"
*	remote-class="eRS.RSRecordStaffUnavailability.RSRecordStaffUnavailabilityHome"
*	generate= "local,remote"
*
*
*/

public class RSRecordStaffUnavailabilityManager implements SessionBean {

	Connection connection = null;
	StringBuffer traceVal	= new StringBuffer();
	CallableStatement cstmt =null;

	String role_type="";
	String staff_id="";
	String leave_from_date="";
	String leave_to_date="";
	String user_id	="";
	String ws_no="";
	String facility_id	="";
	String reason_code="";
	String locale				="";
	String result="";
	public RSRecordStaffUnavailabilityManager(){}

	public void ejbCreate() throws  CreateException{}

	public void ejbRemove(){}

	public void ejbActivate(){}

	public void ejbPassivate(){}

    public void setSessionContext(SessionContext sessioncontext){
	}
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap tabData){

		
		Properties ppts = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		try{
				role_type = (String )tabData.get("role_type");
				staff_id = (String )tabData.get("staff_id");
				leave_from_date = (String )tabData.get("leave_from_date");
				leave_to_date = (String )tabData.get("leave_to_date");
				reason_code = (String )tabData.get("reason_code");
				user_id = (String )tabData.get("user_id");
				ws_no = (String )tabData.get("ws_no");
				facility_id = (String )tabData.get("facility_id");
				locale= (String )tabData.get("locale");
												
				ppts = (Properties )tabData.get("properties");
				connection = ConnectionManager.getConnection(ppts);
				connection.setAutoCommit( false );
				cstmt=connection.prepareCall("{call RS_RECORD_STAFF_UNAVAILABILITY(?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setString(1, role_type.trim());
				cstmt.setString(2, staff_id.trim());
				cstmt.setString(3, leave_from_date);
				cstmt.setString(4, leave_to_date);
				cstmt.setString(5, facility_id);
				cstmt.setString(6, user_id);
				cstmt.setString(7, ws_no);
				cstmt.setString(8, reason_code.trim());
				cstmt.registerOutParameter(9,Types.VARCHAR);
				cstmt.registerOutParameter(10,Types.VARCHAR);
				cstmt.execute();
				result = cstmt.getString(9);
				String msg_id = cstmt.getString(10);
										    
				if(result.equalsIgnoreCase("Y")){
					retMap.put( "result", "true" ) ;
					Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_INSERTED","RS");
					messages.append((String)massageMap.get("message"));
				}
				/*else{
					retMap.put( "result", "false" ) ;
					Hashtable massageMap = MessageManager.getMessage(connection, msg_id);
					messages.append((String)massageMap.get("message"));*/


				else{
				connection.rollback();
				retMap.put( "result", new Boolean( false ) ) ;
				retMap.put( "flag" , "" );
				//Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_INSERTING_INTO");
				Hashtable massageMap = MessageManager.getMessage(locale, "ERROR_IN_INSERTING_INTO","RS");
				messages.append((String)massageMap.get("message"));			
			}
		}catch(Exception e){
			try{
				connection.rollback();
				retMap.put( "result", "false" ) ;
				retMap.put( "flag" , "" );
				e.printStackTrace();
			   	traceVal.append(e.getMessage());
				Hashtable massageMap = MessageManager.getMessage(locale, "ERROR_IN_INSERTING_INTO","RS");
				//Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_INSERTING_INTO");
				messages.append((String)massageMap.get("message"));
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		finally{
				try{

				if(cstmt != null)
					cstmt.close();
				if(connection != null)
					ConnectionManager.returnConnection(connection,ppts);
			}catch(Exception ey){
				ey.printStackTrace();
			}
		}
		retMap.put( "message", messages.toString() ) ;
		retMap.put( "traceVal",traceVal.toString());
		return retMap;
	}
	/**************************end of INSERT*************************************/
}
