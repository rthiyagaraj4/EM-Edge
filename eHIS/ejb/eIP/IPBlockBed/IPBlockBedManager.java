/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to block the bed.
@author - 
@version - V3
*/

package eIP.IPBlockBed;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
 
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPBlockBed"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPBlockBed"
*	local-jndi-name="IPBlockBed"
*	impl-class-name="eIP.IPBlockBed.IPBlockBedManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPBlockBed.IPBlockBedLocal"
*	remote-class="eIP.IPBlockBed.IPBlockBedRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPBlockBed.IPBlockBedLocalHome"
*	remote-class="eIP.IPBlockBed.IPBlockBedHome"
*	generate= "local,remote"
*
*
*/
public class IPBlockBedManager implements SessionBean
{

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context)
		{ 
			this.ctx=context;
		}

	/**
	This method is used to block the bed.
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

	public java.util.HashMap insertIPBooking(java.util.Properties p,java.util.HashMap hashData) 
	{
			Connection con			= null;
			PreparedStatement pstmt = null ;
			ResultSet rset			= null;
			CallableStatement cstmt	= null;
			String locale			= "";
		locale = p.getProperty("LOCALE");
		String facilityId				= (String)hashData.get("facilityId");
		String auto_gen_yn				= (String)hashData.get("auto_gen_yn");
		String blocking_type			= (String)hashData.get("blocking_type");
		String bed_blocking_ref_no		= (String)hashData.get("bed_booking_ref_no");
		String req_nursing_unit_code	= (String)hashData.get("req_nursing_unit_code");
		String req_bed_no				= (String)hashData.get("req_bed_no");
		String req_room_no				= (String)hashData.get("req_room_no");
		String req_bed_class_code		= (String)hashData.get("req_bed_class_code");
		String req_bed_type_code		= (String)hashData.get("req_bed_type_code");
		String blocked_from_date_time	= (String)hashData.get("blocked_from_date_time");
		String blocked_until_date_time	= (String)hashData.get("blocked_until_date_time");
		String blocking_remarks			= (String)hashData.get("blocking_remarks");
		String override_yn				= (String)hashData.get("override_yn");
		String addedFacilityId			= (String)hashData.get("facilityId");
		String modifiedAtWorkstation	= (String)hashData.get("client_ip_address");
		java.util.HashMap results		= new java.util.HashMap() ;
		boolean result					= false ;
		boolean updatable				= true ;
		boolean valid					= true ;
		StringBuffer sb					= new StringBuffer("");
		StringBuffer sql				= new StringBuffer();
		String addedById				= p.getProperty( "login_user" ) ;

		
		try
		{
				con = ConnectionManager.getConnection(p);
				con.setAutoCommit(false);

			try
			{
				sql.append("select 'x' from ip_nursing_unit_bed where facility_id='"+facilityId+"' and ");
				sql.append("bed_no='"+req_bed_no+"' and current_status='A'");
				Statement stmt   = con.createStatement();
				ResultSet rs       =  stmt.executeQuery(sql.toString());
						if(!rs.next())
						{
							valid  = false;
							result = false;
							java.util.Hashtable message = MessageManager.getMessage(locale, "ONLY_FREE_BED_BKG_ALLOWED","IP" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					stmt.close();
					rs.close();
			}
			catch(Exception e)
			{
				sb.append("<br>err in dup chk:"+e);
				e.printStackTrace();
				valid=false;
			}
if(valid)
{
	try
	{
				
		StringBuffer blockedsql = new StringBuffer();
		blockedsql.append("select booking_type,override_yn ");
		blockedsql.append(" from ip_bed_booking bkg where facility_id='"+facilityId+"'");
		blockedsql.append(" and req_nursing_unit_code='"+req_nursing_unit_code+"'");
		blockedsql.append(" and req_bed_no='"+req_bed_no+"' and booking_status='0' ");
		blockedsql.append(" and sysdate between blocked_from_date_time and blocked_until_date_time and booking_date_time=");
		blockedsql.append(" (select max (booking_date_time) from ip_bed_booking where facility_id=bkg.facility_id");
		blockedsql.append(" and req_nursing_unit_code=bkg.req_nursing_unit_code and req_bed_no=bkg.req_bed_no ");
		blockedsql.append("and booking_status='0' and sysdate between blocked_from_date_time and blocked_until_date_time ) ");
		
		Statement stmt       = con.createStatement();
		ResultSet rs         =  stmt.executeQuery(blockedsql.toString());
		String overrides_yn  = "";
		String bookings_type = "";

		if(rs != null)
		{
			while(rs.next())
			{
				overrides_yn  = rs.getString("override_yn");
				bookings_type = rs.getString("booking_type");

				if(overrides_yn==null) overrides_yn   = "";
				if(bookings_type==null) bookings_type = "";

				if(overrides_yn.equals("N"))
				{
					valid  = false;
					result = false;
				}
				else
				{
					valid  = true;
					result = true;
				}
			}
		}
					stmt.close();
					rs.close();
	}
	catch(Exception e)
	{
		sb.append("<br>err in block chk:"+e);
		e.printStackTrace();
		valid=false;
	}
}
			if(valid)
			{
				try
				{
					if(auto_gen_yn.equals("N"))
					{
						/*
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("select next_booking_srl_no from ip_bed_booking_srl_ctrl ");
						sql.append(" where facility_id='"+facilityId+"' and booking_type='B'");
						Statement stmt     = con.createStatement();
						ResultSet rs       =  stmt.executeQuery(sql.toString());
						if((rs!=null)&&(rs.next()))
							bed_blocking_ref_no =	rs.getString(1);
						stmt.close();
						rs.close();
						try
						{
							if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append("update ip_bed_booking_srl_ctrl set next_booking_srl_no = next_booking_srl_no+1 ");
							sql.append(" where facility_id='"+facilityId+"' and booking_type='B' ");

							
							stmt  = con.createStatement();
							stmt.executeUpdate(sql.toString());
							stmt.close();
						}
						catch(Exception e)
						{
							sb.append("<br>err in updating seq no" +e);
							con.rollback();
						}
						*/
						/*Friday, May 14, 2010 ,update ip_bed_booking_srl_ctrl will done through following procedure */
						try
						{
								cstmt=con.prepareCall("{call IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO(?,?,?,?,?,?)}");
								cstmt.setString(1,facilityId);
								cstmt.setString(2,"B");
								cstmt.setString(3,"Y");
								cstmt.setString(4,modifiedAtWorkstation);
								cstmt.setString(5,addedById);
								cstmt.registerOutParameter(6,java.sql.Types.NUMERIC);
								cstmt.execute();
								bed_blocking_ref_no=cstmt.getString(6);
								if(cstmt != null) cstmt.close();
				
						}
						catch (Exception e1)
						{
							result = false;
							e1.printStackTrace();
						}
					}
					else
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" select 'x' from ip_bed_booking where facility_id = '"+facilityId+"' ");
						sql.append(" and booking_type='B' and bed_booking_ref_no='"+bed_blocking_ref_no+"'");
						

						Statement stmt     = con.createStatement();
						ResultSet rs       =  stmt.executeQuery(sql.toString());

						if(rs!=null)
						if(rs.next())
						{
							updatable= false;
							result = false ;
							java.util.Hashtable message = MessageManager.getMessage( locale, "CODE_ALREADY_EXISTS","Common" ) ;
							sb.append( (String) message.get("message") ) ;
							//message.clear();
						}
						stmt.close();
						rs.close();
					}
				}
				catch(Exception e)
				{
					sb.append("<br>err in srl no gen:"+e);
					e.printStackTrace();
				}
				if(updatable)
				{
					try
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("insert into ip_bed_booking ( FACILITY_ID,BOOKING_TYPE ,	BLOCKING_TYPE_CODE ,BED_BOOKING_REF_NO  ,BOOKED_BY_ID,REQ_NURSING_UNIT_CODE,REQ_BED_NO ,REQ_ROOM_NO,REQ_BED_CLASS_CODE,REQ_BED_TYPE_CODE  ,BOOKING_DATE_TIME,BLOCKED_FROM_DATE_TIME ,BLOCKED_UNTIL_DATE_TIME,OVERRIDE_YN,BLOCKING_REMARKS ,BOOKING_STATUS ,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID ,MODIFIED_DATE ,MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID)values('"+ facilityId+"', 'B','"+blocking_type+"','"+bed_blocking_ref_no+"','"+addedById+"','"+req_nursing_unit_code+"','"+req_bed_no+"','"+req_room_no+"','"+req_bed_class_code+"','"+req_bed_type_code+"',sysdate,to_date('"+blocked_from_date_time+"','dd/mm/yyyy hh24:MI'),to_date('"+blocked_until_date_time+"','dd/mm/yyyy hh24:MI'),'"+override_yn+"','"+blocking_remarks+"','0','"+addedById+"',sysdate,'"+modifiedAtWorkstation+"','"+addedFacilityId+"','"+addedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facilityId+"')");

						
						Statement stmt   = con.createStatement();
					    int i = stmt.executeUpdate(sql.toString());
						if(i>0)
					   {
							result = true ;
							java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
							sb.append( (String) message.get("message") ) ;
							stmt.close();
							con.commit();
							message.clear();
					   }
					   else con.rollback();
					}
					catch(Exception e)
					{
						sb.append("<br>err while inserting.... :"+e);
						e.printStackTrace();
						con.rollback();
					}
				}
			}
		}
		catch(Exception e)
		{
			sb.append(e);
			e.printStackTrace();
			try{
			con.rollback();
			}catch(Exception ee) {}
		}
		finally
			{
				 try{
		              if(pstmt != null)      pstmt.close();
					  if(rset != null)      rset.close();
					}
				catch(Exception e)
					{
					}
					 if(con != null)  ConnectionManager.returnConnection(con,p);
			}

			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			hashData.clear();

			return results ;
	}
} // end session bean
