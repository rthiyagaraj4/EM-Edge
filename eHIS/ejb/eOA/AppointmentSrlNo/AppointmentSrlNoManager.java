/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA.AppointmentSrlNo;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="AppointmentSrlNo"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AppointmentSrlNo"
*	local-jndi-name="AppointmentSrlNo"
*	impl-class-name="eOA.AppointmentSrlNo.AppointmentSrlNoManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOA.AppointmentSrlNo.AppointmentSrlNoManagerLocal"
*	remote-class="eOA.AppointmentSrlNo.AppointmentSrlNoManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.AppointmentSrlNo.AppointmentSrlNoManagerLocalHome"
*	remote-class="eOA.AppointmentSrlNo.AppointmentSrlNoManagerHome"
*	generate= "local,remote"
*
*
*/
public class AppointmentSrlNoManager implements SessionBean {

	Connection con ;
	PreparedStatement pstmt,pstmt1,pstmt2,pstmt5;
	ResultSet rset=null ;
	ResultSet rs2=null;
	ResultSet rs=null;
	SessionContext ctx;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;

	String next_no="";

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertAppointmentSrlNo(
		java.util.Properties p,
		java.util.HashMap passObjects
	) 
	{


		String	next_srl_no=(String) passObjects.get("next_srl_no");
		String max_srl_no=(String) passObjects.get("max_srl_no");
		String remark=(String) passObjects.get("remark");
		String facilityId=(String) passObjects.get("facilityId");
		String addedAtWorkstation=(String) passObjects.get("client_ip_address");
		String locale = p.getProperty("LOCALE");
		

		java.util.HashMap results = new java.util.HashMap() ;
		java.util.Hashtable message=new java.util.Hashtable();
		boolean result = false ;
		boolean insertable = true ;
		

		StringBuffer sb = new StringBuffer( "" ) ;

		String sql = "insert into  oa_appt_srl_no (FACILITY_ID, NEXT_SRL_NO, MAX_SRL_NO, LAST_DAY_END, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, 	MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) Values (?, ?, ?, trunc(sysdate),?, sysdate,?, ?,?,sysdate, ? ,?)" ;

		String sql2="insert into oa_trans_record  (FACILITY_ID,SRL_NO,Trans_code,Trans_date_time,Trans_eff_by_id,remarks) values(? ,? ,'SN',sysdate ,? ,? )";


		String addedById = p.getProperty( "login_user" ) ;

		try{
				
			con = ConnectionManager.getConnection(p);
			String next="select nvl(max(srl_no)+1,1) from oa_trans_record where facility_id=?";
			pstmt2=con.prepareStatement(next);
			pstmt2.setString(1,facilityId);
			rs2=pstmt2.executeQuery();

			while(rs2.next()){
				next_no = rs2.getString(1);
			}

			if (pstmt2!=null) pstmt2.close();
			String duplicateSql = "select 1 from  oa_appt_srl_no  where facility_id=?" ;
			pstmt5 = con.prepareStatement( duplicateSql ) ;

			pstmt5.setString( 1, facilityId ) ;
			rs = pstmt5.executeQuery() ;

			if ( rs.next() ){
				insertable = false ;

				message = MessageManager.getMessage( locale,"CODE_ALREADY_EXISTS","Common" ) ;
				sb.append( (String) message.get("message") ) ;

			}
		
		

			if ( insertable ){

				pstmt = con.prepareStatement( sql );
				pstmt1=con.prepareStatement(sql2);

				pstmt.setString	( 1, facilityId) ;
				pstmt.setString	( 2, next_srl_no) ;
				pstmt.setString  ( 3, max_srl_no ) ;
				pstmt.setString ( 4, addedById ) ;
				pstmt.setString	( 5, addedAtWorkstation ) ;
				pstmt.setString (6,facilityId);
				pstmt.setString	( 7, addedById ) ;
				pstmt.setString	( 8,addedAtWorkstation) ;
				pstmt.setString (9,facilityId);

				pstmt1.setString(1, facilityId) ;
				pstmt1.setString(2, next_no);
				pstmt1.setString(3,addedById);
				pstmt1.setString(4,remark);


				int res = pstmt.executeUpdate() ;
				int res1=pstmt1.executeUpdate() ;

				if ( res != 0 && res1 !=0 ){
					result = true ;

					 message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit() ;
				}
			}

			if (rs !=null) rs.close() ;
			if (rset !=null) rset.close() ;
			if (rs2 !=null) rs2.close() ;
			if (pstmt !=null) pstmt.close() ;
			if (pstmt1 !=null) pstmt1.close() ;
			if (pstmt2 !=null) pstmt2.close() ;
			if(pstmt5 !=null) pstmt5.close();
			message.clear();
		}catch ( Exception e ) {
			e.printStackTrace();
			try{
				con.rollback() ;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
		} finally {
			if (con != null) ConnectionManager.returnConnection(con,p);

		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		sb.setLength(0);
		passObjects.clear();
		return results ;
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap updateAppointmentSrlNo(
						java.util.Properties p,
						java.util.HashMap passObjects  						
	) 
	{

		String	next_srl_no=(String) passObjects.get("next_srl_no");
		String max_srl_no=(String) passObjects.get("max_srl_no");
		String remark=(String) passObjects.get("remark");
		String facilityId=(String) passObjects.get("facilityId");
		String	  addedAtWorkstation=(String) passObjects.get("client_ip_address");
		String locale = p.getProperty("LOCALE");


		java.util.Hashtable message=new java.util.Hashtable();

		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;

		String sql = "update oa_appt_srl_no set next_srl_no	=?,max_srl_no	=?,last_day_end=trunc(sysdate-1) ,modified_by_id=?,modified_date= sysdate,   modified_at_ws_no 	= ?, MODIFIED_FACILITY_ID =? where facility_id=?";


		String sql2="insert into oa_trans_record   (FACILITY_ID,SRL_NO,Trans_code,Trans_date_time,Trans_eff_by_id,remarks) values(? ,? ,'SN' ,sysdate ,? ,? )";


		
		String modifiedById = p.getProperty( "login_user" ) ;


		if ( updatable ) {
			try {
				
				con = ConnectionManager.getConnection(p);
				String next="select max(srl_no)+1 from oa_trans_record where facility_id=?";
				pstmt2=con.prepareStatement(next);
				pstmt2.setString(1,facilityId);
				rs2=pstmt2.executeQuery();
	
				while(rs2.next()){
					next_no = rs2.getString(1);
				}

				pstmt = con.prepareStatement( sql );
				pstmt.setString ( 1,next_srl_no ) ;
				pstmt.setString	( 2, max_srl_no ) ;
				pstmt.setString ( 3, modifiedById ) ;
				pstmt.setString	( 4, addedAtWorkstation ) ;
				pstmt.setString (5,facilityId);
				pstmt.setString(6,facilityId);

				pstmt1 = con.prepareStatement( sql2 );
				pstmt1.setString(1, facilityId) ;
				pstmt1.setString(2, next_no);
				pstmt1.setString(3,modifiedById);
				pstmt1.setString(4,remark);


				int res = pstmt.executeUpdate() ;
				int res1=pstmt1.executeUpdate() ;

				if ( res != 0 && res1 !=0 ) {
					result = true ;

					 message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit() ;
				}
			
				if (rs !=null) rs.close() ;
				if (rset !=null) rset.close() ;
				if (rs2 !=null) rs2.close() ;
				if (pstmt !=null) pstmt.close() ;
				if (pstmt1 !=null) pstmt1.close() ;
				if (pstmt2 !=null) pstmt2.close() ;

				
			} catch ( Exception e ) {
				e.printStackTrace();
				try{
					con.rollback() ;
				}catch(Exception ex){
					ex.printStackTrace();
				}

				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			} finally{
				if (con != null) ConnectionManager.returnConnection(con,p);
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		sb.setLength(0);
message.clear();
passObjects.clear();
		return results ;
	}
}

