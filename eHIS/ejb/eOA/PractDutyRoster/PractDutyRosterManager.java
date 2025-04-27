/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA.PractDutyRoster;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="PractDutyRoster"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PractDutyRoster"
*	local-jndi-name="PractDutyRoster"
*	impl-class-name="eOA.PractDutyRoster.PractDutyRosterManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOA.PractDutyRoster.PractDutyRosterManagerLocal"
*	remote-class="eOA.PractDutyRoster.PractDutyRosterManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.PractDutyRoster.PractDutyRosterManagerLocalHome"
*	remote-class="eOA.PractDutyRoster.PractDutyRosterManagerHome"
*	generate= "local,remote"
*
*
*/

public class PractDutyRosterManager implements SessionBean {
	
	Connection con =null;
	PreparedStatement pstmt =null,pstmt1 =null;
	SessionContext ctx;
	ResultSet rs =null;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_DELETED = "RECORD_DELETED" ;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) { this.ctx=context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertPractDutyRoster(java.util.Properties p,
							java.util.HashMap passObjects

		) 
		{
		String facilityId=(String) passObjects.get("facilityId");
		String locations1=(String) passObjects.get("locations1");
		String	practid=(String) passObjects.get("practid");
		String resource2=(String) passObjects.get("resource2");
		String ccode=(String) passObjects.get("ccode");
		String ondutydate=(String) passObjects.get("ondutydate");
		String	addedAtWorkstation=(String) passObjects.get("client_ip_address");
		String locale = p.getProperty("LOCALE");
		

		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		StringBuffer sb = new StringBuffer( "" ) ;
		String sql = "insert into 	oa_roster_for_pract(FACILITY_ID,PRACTITIONER_ID,CLINIC_CODE,ON_DUTY_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,CARE_LOCN_TYPE_IND,RESOURCE_CLASS) values (?, ?, ?, to_date(?,'DD/MM/YYYY'), ?, sysdate, ?, ?, ?, sysdate,?,?,?,?)" ;
		String addedById = p.getProperty( "login_user" ) ;
		try
			{
				con = ConnectionManager.getConnection(p);
				StringTokenizer st = new StringTokenizer(ondutydate,"|");
				String ondutydate1 = "";
				int res=0;
				String duplicateSql = "select 1 from  oa_roster_for_pract  where facility_id=? and  practitioner_id = ? and clinic_code=? and CARE_LOCN_TYPE_IND=? and to_date(on_duty_date,'DD/MM/YYYY') = to_date(?,'DD/MM/YYYY') " ;
				pstmt = con.prepareStatement( duplicateSql ) ;
				pstmt1 = con.prepareStatement( sql );
				while(st.hasMoreTokens())
				{
					ondutydate1=st.nextToken();
					pstmt.setString( 1, facilityId ) ;
					pstmt.setString( 2, practid ) ;
					pstmt.setString(3, ccode);
					pstmt.setString(4, locations1);
					pstmt.setString(5, ondutydate1);
					rs = pstmt.executeQuery() ;
					if ( rs.next() )
					{
						java.util.Hashtable message = MessageManager.getMessage( locale,"CODE_ALREADY_EXISTS","Common" ) ;
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}else{	
						pstmt1.setString	(1, facilityId) ;
						pstmt1.setString	(2, practid) ;
						pstmt1.setString (3, ccode ) ;
						pstmt1.setString (4, ondutydate1);
						pstmt1.setString (5, addedById ) ;
						pstmt1.setString	(6, addedAtWorkstation ) ;
						pstmt1.setString (7, facilityId);
						pstmt1.setString	(8, addedById ) ;
						pstmt1.setString	(9,addedAtWorkstation) ;
						pstmt1.setString (10,facilityId);
						pstmt1.setString (11,locations1);
						pstmt1.setString (12,resource2);
						res = pstmt1.executeUpdate();
					}
					if (rs !=null) rs.close();
				
				}
				if ( res != 0 ){
					result = true ;
					java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
					message.clear();
				}else{
					result = false ;
					sb.append( "Error while generating roster" ) ;
					con.rollback();
				}
				if(rs!= null) rs.close() ;
				if(pstmt!= null) pstmt.close() ;
				if(pstmt1!= null) pstmt1.close() ;
				passObjects.clear();
			}catch ( Exception e ){
				sb.append( e+ "<br>" ) ;
				e.printStackTrace() ;
		}
		finally{
			  if (con != null){
			       try {
						ConnectionManager.returnConnection(con,p);
						} catch (Exception ee) {}
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
	public java.util.HashMap deletePractDutyRoster(
							java.util.Properties p,
							java.util.HashMap passObjects

						) 
	{
			String facilityId=(String) passObjects.get("facilityId");
			String locations1=(String) passObjects.get("locations1");
			String	practid=(String) passObjects.get("practid");
			String resource2=(String) passObjects.get("resourced");
			String ccode=(String) passObjects.get("ccode");
			String ondutydate=(String) passObjects.get("ondutydate");
			String locale = p.getProperty("LOCALE");
			PreparedStatement pstmt2 =null;
			PreparedStatement pstmt3 =null;
			ResultSet rset=null;
			String sl=null;
			int srlno=0;
			String addedById = p.getProperty( "login_user" ) ;
			String sql_oa_trans_record  = " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id=? ";
			String sql_ins_oa_trans_record = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
			

			java.util.HashMap results = new java.util.HashMap() ;
			boolean result = false ;
			StringBuffer sb = new StringBuffer( "" ) ;
			try
			{
		
				String sql = "delete from oa_roster_for_pract where facility_id =? and practitioner_id=? and clinic_code=? and on_duty_date = to_date(?,'DD/MM/YYYY')  and CARE_LOCN_TYPE_IND=? and RESOURCE_CLASS=? ";
				con = ConnectionManager.getConnection(p);

					pstmt = con.prepareStatement( sql );
					pstmt.setString	( 1, facilityId) ;
					pstmt.setString	( 2, practid) ;
					pstmt.setString	( 3, ccode) ;
					pstmt.setString	( 4, ondutydate) ;
					pstmt.setString	( 5, locations1) ;
					pstmt.setString	( 6, resource2) ;
					int res = pstmt.executeUpdate() ;
					pstmt2 = con.prepareStatement( sql_oa_trans_record );
					pstmt3 = con.prepareStatement( sql_ins_oa_trans_record );
					pstmt2.setString( 1, facilityId ) ;
					rset=pstmt2.executeQuery();
					if(rset.next()){
						sl = rset.getString("max");
						srlno = Integer.parseInt(sl);
					}
					if(rset!=null)rset.close();
					pstmt3.setString (1, facilityId);
					pstmt3.setInt	 ( 2,srlno ) ;
					pstmt3.setString (3, "RD" ) ;
					pstmt3.setString (4, addedById );
					pstmt3.setString (5, ondutydate ) ;
					pstmt3.setString (6, ondutydate);
					pstmt3.setString (7, ccode ) ;
					pstmt3.setString (8, practid) ;
					pstmt3.setString (9, "" ) ;
					pstmt3.setString (10, "" ) ;
					pstmt3.setString (11, "" ) ;
					pstmt3.setString (12, locations1 ) ;
					pstmt3.setString (13, resource2 ) ;
					pstmt3.executeUpdate() ;
					if ( res != 0 ) {
						result = true ;
						java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_DELETED","SM" ) ;
						sb.append( (String) message.get("message") ) ;
						con.commit();
						message.clear();
					}else{
						result = false ;
						sb.append( "Error while deleting roster" ) ;
						con.rollback();
					}	
				if(rs!= null) rs.close() ;
			    if(pstmt!= null) pstmt.close() ;
				passObjects.clear();
		}catch ( Exception e ){
			try {
					con.rollback() ;
					} catch ( Exception ce ) {}
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
		}finally{
			if (con != null) ConnectionManager.returnConnection(con,p);	
			try{
				if(rset!=null)rset.close();
				if(pstmt2!=null)pstmt2.close();
				if(pstmt3!=null)pstmt3.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}
