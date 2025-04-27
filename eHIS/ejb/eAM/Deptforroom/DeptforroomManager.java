/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.Deptforroom;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import java.util.*;
import javax.rmi.*;
import webbeans.eCommon.*;



/**
*
* @ejb.bean
*	name="Deptforroom"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Deptforroom"
*	local-jndi-name="Deptforroom"
*	impl-class-name="eAM.Deptforroom.DeptforroomManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.Deptforroom.DeptforroomManagerLocal"
*	remote-class="eAM.Deptforroom.DeptforroomManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.Deptforroom.DeptforroomManagerLocalHome"
*	remote-class="eAM.Deptforroom.DeptforroomManagerHome"
*	generate= "local,remote"
*
*
*/



public class DeptforroomManager implements SessionBean 
{

	Connection con ;
	PreparedStatement pstmt ;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	public final String DEPT_CANNOT_SPECIFIED = "DEPT_CANNOT_SPECIFIED" ;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){
	context=context;//for avoiding PMD violation
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertDeptRoom(HashMap hashData)  
	{
		java.util.Properties p =(Properties) hashData.get("p");		

		HashMap hashdata = (HashMap) hashData.get("hashdata");
		String facilityId = (String)hashdata.get("facilityId");
		String room = (String)hashdata.get("room");
		String department = (String)hashdata.get("department");
		String service = (String)hashdata.get("service");
		String addedAtWorkstation = (String)hashdata.get("addedAtWorkstation");
		String addedFacilityId = (String)hashdata.get("addedFacilityId");
		java.util.HashMap results = new java.util.HashMap() ;
		String locale="";
		locale= p.getProperty("LOCALE");
		boolean result = false ;
		boolean insertable = true ;
		boolean dup = false ;
		StringBuffer sb = new StringBuffer("");
		StringBuffer sql = new StringBuffer("");
		sql.append(" insert into 	am_dept_for_facility_room(	" );
		sql.append(" operating_facility_id,		room_num," );
		sql.append(" dept_code, service_code, " 	);
		sql.append(" added_by_id,		added_date, " 	);
		sql.append(" added_facility_id, added_at_ws_no, " );
		sql.append(" modified_by_id,	 modified_date, " );
		sql.append(" modified_facility_id,	modified_at_ws_no " );
		sql.append(" ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,? )" );

		String addedById = p.getProperty( "login_user" ) ;
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
		String modifiedDate = addedDate ;
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		ResultSet rs =null;

         hashdata.clear();
         hashData.clear();

		try
		{
			con=ConnectionManager.getConnection(p);
			String duplicateSql = "select 1 from  am_dept_for_facility_room where operating_facility_id = ? and room_num = ? and dept_code = ? " ;
			pstmt = con.prepareStatement( duplicateSql ) ;
			pstmt.setString( 1, facilityId) ;
			pstmt.setString( 2, room) ;
			pstmt.setString( 3, department ) ;
			rs = pstmt.executeQuery() ;
			if(rs!=null)
			{
				if ( rs.next()  )
				{
					insertable = false ;
					dup = true;

					java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS ,"Common") ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}
			}
				if(rs!=null) rs.close();	
				if(pstmt!=null)pstmt.close();
				
		}catch ( Exception e )
		{
			insertable = false ;
			sb.append( e+ "<br>" ) ;
			e.printStackTrace() ;

			/*if (con != null)
			ConnectionManager.returnConnection(con,p);*/
		}
		if (!dup ) 
		{
			try 
			{
				//con=ConnectionManager.getConnection(p);

				String duplicateSql = "select count(*) as total from am_dept_for_facility_room_vw where (resident_stay_yn ='Y' or room_type in ('E','O')) and room_num=? and operating_facility_id = ? " ;
				pstmt = con.prepareStatement( duplicateSql ) ;
				pstmt.setString( 1, room ) ;
				pstmt.setString( 2, addedFacilityId ) ;

				rs = pstmt.executeQuery() ;
				rs.next();
				int rs1=rs.getInt("total");
				if (rs1 >= 1 )
				{
					insertable = false ;
					java.util.Hashtable message = MessageManager.getMessage( locale, DEPT_CANNOT_SPECIFIED,"AM" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
			}catch(Exception e)
			{
				insertable = false ;
				sb.append( e + "<br>" ) ;
				e.printStackTrace() ;
			}
		}
		if ( insertable )
		{
			try
			{
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString	( 1, facilityId ) ;
				pstmt.setString	( 2, room) ;
				pstmt.setString	( 3, department  ) ;
				pstmt.setString	( 4, service ) ;
				pstmt.setString	( 5, addedById ) ;
				pstmt.setDate	( 6, added_date ) ;
				pstmt.setString	( 7, addedFacilityId ) ;
				pstmt.setString	( 8, addedAtWorkstation ) ;
				pstmt.setString	( 9, modifiedById ) ;
				pstmt.setDate	( 10, modified_date ) ;
				pstmt.setString	( 11, modifiedFacilityId ) ;
				pstmt.setString	( 12, modifiedAtWorkstation ) ;
				int res = pstmt.executeUpdate() ;
						
				if ( res != 0 )
				{
					result = true ;
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"SM" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}
				if(pstmt!=null) pstmt.close();
			}catch ( Exception e ) 
			{
				try{
				con.rollback();
				}catch(Exception ce){}
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}
			finally 
			{
				if(con != null) 
				ConnectionManager.returnConnection(con,p);
			}
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap updateDeptRoom(HashMap hashData)  
	{
		java.util.Properties p =(Properties) hashData.get("p");
		
		HashMap hashdata = (HashMap) hashData.get("hashdata");
	//	String facilityId = (String)hashdata.get("facilityId");
		String room = (String)hashdata.get("room");
		String department = (String)hashdata.get("department");
		String service = (String)hashdata.get("service");
		String addedAtWorkstation = (String)hashdata.get("addedAtWorkstation");
		String addedFacilityId = (String)hashdata.get("addedFacilityId");
		String locale="";
		locale= p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean updatable = true ;

		StringBuffer sb = new StringBuffer("");
		StringBuffer sql = new StringBuffer("");

		sql.append(" update am_dept_for_facility_room set " );
		sql.append(" service_code 		= ?,  " );
		sql.append(" modified_by_id	= ?,  " );
		sql.append(" modified_date		= ?,  " );
		sql.append(" modified_facility_id	= ?, " );
		sql.append(" modified_at_ws_no = ? "  );
		sql.append(" where	operating_facility_id 	= ? ");
		sql.append(" and room_num = ?" );
		sql.append(" and dept_code = ?");

		String modifiedById = p.getProperty( "login_user" ) ;
		String modifiedDate = dateFormat.format( new java.util.Date() ) ;
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;

		 hashdata.clear();
         hashData.clear();

		if ( updatable ) 
		{
			try
			{
				con=ConnectionManager.getConnection(p);
				pstmt = con.prepareStatement( sql.toString() );
				pstmt.setString ( 1, service) ;
				pstmt.setString	( 2, modifiedById ) ;
				pstmt.setDate	( 3, modified_date ) ;
				pstmt.setString	( 4, modifiedFacilityId ) ;
				pstmt.setString	( 5, modifiedAtWorkstation ) ;
				pstmt.setString ( 6, addedFacilityId );
				pstmt.setString ( 7, room );
				pstmt.setString ( 8, department );

				int res = pstmt.executeUpdate() ;
			
				if ( res != 0 ) 
				{
					result = true ;
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}

					if(pstmt!=null) pstmt.close();
						con.close();
			} catch ( Exception e ) 
			{
				try
				{
					con.rollback();
				}catch(Exception ce){}
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}
			finally
			{
				if (con != null)
				ConnectionManager.returnConnection(con,p);
				
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
		}

} // end session bean

