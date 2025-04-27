/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to release the beds.
@author - 
@version - V3
*/

package eIP.IPReleaseBed;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPReleaseBed"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPReleaseBed"
*	local-jndi-name="IPReleaseBed"
*	impl-class-name="eIP.IPReleaseBed.IPReleaseBedManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPReleaseBed.IPReleaseBedLocal"
*	remote-class="eIP.IPReleaseBed.IPReleaseBedRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPReleaseBed.IPReleaseBedLocalHome"
*	remote-class="eIP.IPReleaseBed.IPReleaseBedHome"
*	generate= "local,remote"
*
*
*/
public class IPReleaseBedManager implements SessionBean 
{
	Connection con			= null;
	PreparedStatement pstmt = null;
	ResultSet rset			= null;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	
	SessionContext ctx;

	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}

	/**
	This method is used release the beds.
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

	public java.util.HashMap ReleaseBed(java.util.Properties p,java.util.HashMap hashData) 

	{
		String encounter_id			= (String)hashData.get("encounter_id");

		String bookingtype			= (String)hashData.get("bookingtype");
		String bedbookingrefno		= (String)hashData.get("bedbookingrefno");
		String facilityId			= (String)hashData.get("facilityId");
		String reqbedno				= (String)hashData.get("reqbedno");
		String reqnursingunitcode	= (String)hashData.get("reqnursingunitcode");
		String addedAtWorkstation	= (String)hashData.get("client_ip_address");
		hashData.clear();
		java.util.HashMap results	= new java.util.HashMap() ;
		boolean result				= false ;
		String modifiedDate			= dateFormat.format( new java.util.Date() ) ;
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		StringBuffer messageBuffer	= new StringBuffer("");
		StringBuffer sqlBuffer		= new StringBuffer("");
		String		 addedById		= p.getProperty( "login_user" ) ;

		try
		{
			String locale = p.getProperty("LOCALE");
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			String L_booking_status = "9";

/*11/27/2008 CRF 3698 SRR20056-CRF-0228 test append code*/
			try
			{

				if(sqlBuffer.length() > 0)	sqlBuffer.delete(0,sqlBuffer.length());
				/*
				sqlBuffer.append(" update IP_OPEN_ENCOUNTER set RESERVED_NURS_UNIT_CODE = '' ,RESERVED_ROOM_NO = '',RESERVED_BED_NO = '', MODIFIED_BY_ID = '"+addedById+"' , MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = '"+addedAtWorkstation+"', MODIFIED_FACILITY_ID  = '"+facilityId+"' where FACILITY_ID = '"+facilityId+"' and  ENCOUNTER_ID = '"+encounter_id+"'  ");
				*/
				/*Wednesday, May 12, 2010,update in ip_open_encounter will done through trigger IP_PR_ENCNTR_UPD_OPEN_ENC_TRG in Pr_encounter*/
				sqlBuffer.append(" update pr_encounter set reserved_nurs_unit_code = '' ,reserved_room_no = '',reserved_bed_no = '', modified_by_id = '"+addedById+"' , modified_date = sysdate, modified_at_ws_no = '"+addedAtWorkstation+"', modified_facility_id  = '"+facilityId+"' where facility_id = '"+facilityId+"' and  encounter_id = '"+encounter_id+"'  ");


				int rs1 = 0;
				pstmt = con.prepareStatement(sqlBuffer.toString());
				rs1  = pstmt.executeUpdate() ;
				if(rs1 > 0)
							result = true;
						else
							result = false;
				if(pstmt!=null) pstmt.close();
			}catch(Exception e)
			{
				result = false;
				e.printStackTrace(System.out);
			}
	//11/27/2008		
			try
			{

				if(sqlBuffer.length() > 0)	sqlBuffer.delete(0,sqlBuffer.length());
				sqlBuffer.append(" update IP_RESERVED_BED_DTL set RESERVED_TO_TIME = SYSDATE, MODIFIED_BY_ID = '"+addedById+"' , MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = '"+addedAtWorkstation+"', MODIFIED_FACILITY_ID  = '"+facilityId+"' where FACILITY_ID = '"+facilityId+"' and  ENCOUNTER_ID = '"+encounter_id+"' and RESERVED_BED_NO = '"+reqbedno+"' and RESERVED_NURSING_UNIT_CODE ='"+reqnursingunitcode+"' and reserved_to_time is null ");


				int rs = 0;
				pstmt = con.prepareStatement(sqlBuffer.toString());
				rs  = pstmt.executeUpdate() ;

				if(pstmt!=null) pstmt.close();
			}catch(Exception e)
			{
				result = false;
				e.printStackTrace();
			}

			if(sqlBuffer.length() > 0)	sqlBuffer.delete(0,sqlBuffer.length());
			//update ip_bed_booking
			sqlBuffer.append(" update ip_bed_booking set booking_status = ? , cancelled_by_id = ?, ");
			sqlBuffer.append(" cancellation_date_time = sysdate, modified_by_id=?,");
			sqlBuffer.append(" modified_date = ?,  modified_at_ws_no 	= ?,  modified_facility_id =?  ");
			sqlBuffer.append(" where facility_id = ? and booking_type =? and bed_booking_ref_no = ? ");

			pstmt = con.prepareStatement( sqlBuffer.toString() );
			pstmt.setString	( 1, L_booking_status ) ;
			pstmt.setString	( 2, addedById ) ;
			pstmt.setString	( 3, addedById ) ;
			pstmt.setDate	( 4, modified_date );
			pstmt.setString	( 5, addedAtWorkstation ) ;
			pstmt.setString	( 6, facilityId ) ;
			pstmt.setString	( 7, facilityId);
			pstmt.setString	( 8, bookingtype ) ;
			pstmt.setString	( 9, bedbookingrefno ) ;

			int res = pstmt.executeUpdate() ;

			if ( res != 0 )
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" );
				messageBuffer.append( (String) message.get("message"));
				message.clear();
				con.commit();
			}
			else
				con.rollback();
		}
		catch ( Exception e ) {
			messageBuffer.append( e.getMessage()  ) ;
			e.printStackTrace() ;
			try{
					con.rollback();
				}catch(Exception e1){}
		}
		finally {
			if (con != null) 
			{
				try {
					  pstmt.close() ;
					  rset.close();
					  con.close();
					} catch (Exception ee) {}
			}
			if(con != null)  ConnectionManager.returnConnection(con,p);
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", messageBuffer.toString() ) ;
		return results ;
	}//end insert
} 
