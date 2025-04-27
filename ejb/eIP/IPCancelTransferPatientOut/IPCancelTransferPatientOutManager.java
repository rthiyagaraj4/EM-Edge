/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
This ejb is used to admit the patients.
@author - 
@version - V3
*/
package eIP.IPCancelTransferPatientOut;
import blipin.*;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPCancelTransferPatientOut"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPCancelTransferPatientOut"
*	local-jndi-name="IPCancelTransferPatientOut"
*	impl-class-name="eIP.IPCancelTransferPatientOut.IPCancelTransferPatientOutManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPCancelTransferPatientOut.IPCancelTransferPatientOutLocal"
*	remote-class="eIP.IPCancelTransferPatientOut.IPCancelTransferPatientOutRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPCancelTransferPatientOut.IPCancelTransferPatientOutLocalHome"
*	remote-class="eIP.IPCancelTransferPatientOut.IPCancelTransferPatientOutHome"
*	generate= "local,remote"
*
*
*/
public class IPCancelTransferPatientOutManager implements SessionBean 
{

	Connection con = null;
	PreparedStatement preparedStatement = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs=null;
	long encounterid;

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}

	/**
	This method is used to cancel patient transfer.
	@author - 
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

public java.util.HashMap insertCancelTransferPatientOut(java.util.Properties p,java.util.HashMap hashData) 
{
	String  facilityId			= (String)hashData.get("facilityId");
	String  patientid			= (String)hashData.get("patientid");
	String  encounter_id		= (String)hashData.get("encounterid");
	String  bed_booking_ref_no	= (String)hashData.get("bed_booking_ref_no");
	String  cancel_reason		= (String)hashData.get("cancel_reason");
	String  practid				= (String)hashData.get("practid");
	String  addedAtWorkstation	= (String)hashData.get("client_ip_address");
	 String locale = p.getProperty("LOCALE");

	java.util.HashMap results	= new java.util.HashMap() ;
	boolean result = true ;

	StringBuffer sb = new StringBuffer("");
	results.put( "error", "no error" ) ;
	String addedById = p.getProperty( "login_user" ) ;
	StringBuffer strBuffer = new StringBuffer();
	if(sb.length()>0)
		 sb.setLength(0);

	try
	{
		encounterid		= Long.parseLong(encounter_id);
		int	res			= 0;
		con				= ConnectionManager.getConnection(p);
		StringBuffer bedBookingQuery = new StringBuffer();
		String status="";
		
		try
		{
			bedBookingQuery.append("select TFR_REQ_STATUS from IP_TRANSFER_REQUEST where    TFR_REQ_REF_NO = ?  and facility_id = ? and ENCOUNTER_ID = ? and PATIENT_ID = ? ");
			preparedStatement = con.prepareStatement(bedBookingQuery.toString());

			preparedStatement.setString	( 1, bed_booking_ref_no);
			preparedStatement.setString	( 2, facilityId ) ;
			preparedStatement.setLong	( 3, encounterid ) ;
			preparedStatement.setString	( 4, patientid ) ;
			rs = preparedStatement.executeQuery() ;
			if(rs.next())
			{
				status=rs.getString("TFR_REQ_STATUS");
			
			
			}
			if(rs!=null) rs.close();
			if(preparedStatement!=null) preparedStatement.close();
			
			if(status.equals("9"))
			{
				result=false;
				java.util.Hashtable msg = MessageManager.getMessage( locale, "REQUEST_CANCELLED","IP" ) ;
				sb.append("CancelTransferPatientOutManager already done <br>") ;
				sb.append( (String) msg.get("message") ) ;
				msg.clear();
			}
			else if(status.equals("4"))
			{
				result=false;
				java.util.Hashtable msg = MessageManager.getMessage( locale, "REQUEST_CONFIRMED","IP" ) ;
				sb.append("Request confirmed <br>") ;
				sb.append( (String) msg.get("message") ) ;
				msg.clear();
			}
			else if(status.equals("3"))
			{
				result=true;
			}
			
             
			 if(bedBookingQuery.length()>0)
				 bedBookingQuery.setLength(0);
			//StringBuffer bedBookingQuery = new StringBuffer();
			if(result){ //Added audit column
			bedBookingQuery.append(" update IP_TRANSFER_REQUEST set ");
			bedBookingQuery.append(" cancellation_date_time = sysdate,cancelled_by_id = ?, ");
			bedBookingQuery.append(" TFR_REQ_STATUS = '9', modified_by_id = ?, ");
			bedBookingQuery.append(" modified_at_ws_no = ?, modified_date = sysdate, ");
			bedBookingQuery.append(" CANCEL_REASON_CODE = ?,AUTH_CANCELLED_PRACT_ID=?, MODIFIED_FACILITY_ID=? where  ");
			bedBookingQuery.append(" TFR_REQ_REF_NO = ?  and facility_id = ? and ENCOUNTER_ID = ? and PATIENT_ID = ? ");
			preparedStatement = con.prepareStatement(bedBookingQuery.toString());

			preparedStatement.setString	( 1, addedById ) ;
			preparedStatement.setString	( 2, addedById ) ;
			preparedStatement.setString	( 3, addedAtWorkstation ) ;
			preparedStatement.setString	( 4, cancel_reason);
			preparedStatement.setString	( 5, practid);
			preparedStatement.setString	( 6, facilityId ) ; //Added audit column
			preparedStatement.setString	( 7, bed_booking_ref_no);
			preparedStatement.setString	( 8, facilityId ) ;
			preparedStatement.setLong	( 9, encounterid ) ;
			preparedStatement.setString	( 10, patientid ) ;
	
			res = preparedStatement.executeUpdate() ;
			
			if(res>0 )  result = true; else result = false;
			if(preparedStatement != null)  preparedStatement.close() ;
		}
		}
		catch(SQLException e1)
		{
			

			e1.printStackTrace();
			result = false;
			sb.append("Exception in IP_TRANSFER_REQUEST : " + e1);
		}

		if(result)
		{
			try
			{
				if(bedBookingQuery.length() > 0) bedBookingQuery.delete(0,bedBookingQuery.length());
				//Added Audit column
				bedBookingQuery.append(" update IP_BED_CLASS_REQUEST set ");
				bedBookingQuery.append(" request_status = '9', ");
				bedBookingQuery.append(" modified_by_id = ?, ");
				bedBookingQuery.append(" modified_at_ws_no = ?, modified_date = sysdate, MODIFIED_FACILITY_ID=? ");
				bedBookingQuery.append(" where ");
				bedBookingQuery.append(" REQUEST_STATUS = '0' and facility_id = ? and ENCOUNTER_ID = ? and PATIENT_ID = ? ");
				preparedStatement = con.prepareStatement(bedBookingQuery.toString());

				preparedStatement.setString	( 1, addedById ) ;
				preparedStatement.setString	( 2, addedAtWorkstation ) ;
				preparedStatement.setString	( 3, facilityId ) ; //Added Audit column
				preparedStatement.setString	( 4, facilityId ) ;
				preparedStatement.setLong	( 5, encounterid);
				preparedStatement.setString	( 6, patientid);

				/*preparedStatement.setString	( 6, bed_booking_ref_no);
				preparedStatement.setString	( 7, facilityId ) ;
				preparedStatement.setLong	( 8, encounterid ) ;
				preparedStatement.setString	( 9, patientid ) ;*/
				preparedStatement.executeUpdate() ;
				//if(res>0 )  result = true; else result = false;
				if(preparedStatement != null)  preparedStatement.close() ;
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
				sb.append("Exception in IP_BED_CLASS_REQUEST : " + e1);
			}
		}



			if(result)
			{
				int count = 0;
				try
				{   //Added Audit column
					if(strBuffer.length() > 0)	strBuffer.delete(0, strBuffer.length());
					strBuffer.append("  update IP_OPEN_ENCOUNTER set ");
					strBuffer.append("  TFR_REQ_STATUS = '', ");
					strBuffer.append(" modified_by_id = ?, ");
					strBuffer.append(" modified_at_ws_no = ?, modified_date = sysdate , MODIFIED_FACILITY_ID=?");
					strBuffer.append(" where ");
					strBuffer.append(" facility_id = ? and encounter_id = ?");
					pstmt = con.prepareStatement(strBuffer.toString());
					pstmt.setString(1, addedById);
					pstmt.setString(2, addedAtWorkstation);
					pstmt.setString(3, facilityId); //Added Audit column
					pstmt.setString(4, facilityId);
					pstmt.setString(5, encounter_id);
					count = pstmt.executeUpdate();
					if(count > 0)
						result = true;
					else
						result = false;

					if(pstmt != null) pstmt.close();

				}catch(Exception ex)
				{
					result = false;
					sb.append("error while updating into ip_open_encounter : " + ex.getMessage());
				}
			}

		if(result) 
		{  
			result = true ;
			java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			message.clear();
			con.commit();
		}
	
	}catch ( Exception e ) 
	{
		
		sb.append( e.getMessage()  ) ;
		e.printStackTrace() ;
		try
		{
			con.rollback();
		}catch(Exception e1){}
	}
	finally 
	{
		 try
		 {
		   if(preparedStatement != null)  preparedStatement.close() ;
		 }catch(Exception ce){}
		 if(con != null) ConnectionManager.returnConnection(con,p);
	}

	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	
	hashData.clear();
	return results ;

}// end insert
} // end session bean

