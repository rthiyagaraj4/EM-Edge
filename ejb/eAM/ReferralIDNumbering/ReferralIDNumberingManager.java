/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.ReferralIDNumbering;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import java.util.HashMap;
import java.util.Properties;

/**
*
* @ejb.bean
*	name="ReferralIDNumbering"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ReferralIDNumbering"
*	local-jndi-name="ReferralIDNumbering"
*	impl-class-name="eAM.ReferralIDNumbering.ReferralIDNumberingManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.ReferralIDNumbering.ReferralIDNumberingLocal"
*	remote-class="eAM.ReferralIDNumbering.ReferralIDNumberingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.ReferralIDNumbering.ReferralIDNumberingLocalHome"
*	remote-class="eAM.ReferralIDNumbering.ReferralIDNumberingHome"
*	generate= "local,remote"
*
*
*/




public class ReferralIDNumberingManager implements SessionBean {
    Connection con ;
    PreparedStatement pstmt ;
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

    public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
    public final String NEXT_NUMBER_CHECK = "NEXT_NUMBER_CHECK" ;
    public final String RECORD_INSERTED = "RECORD_INSERTED" ;
    public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
    //SessionContext ctx;
  

    public void ejbCreate()  {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context )
	{
		context=context;//for avoiding PMD violation
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
    public java.util.HashMap insertReferralIDNumbering(HashMap mapData) {
		
		Properties p = (Properties)mapData.get("p");
		int year_num =  ((Integer)mapData.get("year_num")).intValue();
		int next_referral_num = ((Integer)mapData.get("next_referral_num")).intValue();
		String addedFacilityId = (String) mapData.get("addedFacilityId");
		String addedAtWorkstation = (String) mapData.get("addedAtWorkstation");

		HashMap results = new HashMap() ;

		boolean result = false ;
		boolean insertable = true ;

		StringBuffer sb = new StringBuffer( "" ) ;

		String sql = "insert into AM_REF_ID_NUM_FOR_FCY(facility_id,year_num,next_referral_num,added_by_id,added_date,added_facility_id, added_at_ws_no, modified_by_id,modified_date,modified_facility_id, modified_at_ws_no) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;

		String addedById = p.getProperty( "login_user" ) ;
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
		String modifiedDate = addedDate ;
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		ResultSet rs = null;
		String locale="";
		locale= p.getProperty("LOCALE");
		Date added_date = Date.valueOf( addedDate ) ;
		Date modified_date = Date.valueOf( modifiedDate ) ;

        mapData.clear();
		try{
		con = ConnectionManager.getConnection(p);

		try{
			

			String duplicateSql = "select 1 from  AM_REF_ID_NUM_FOR_FCY where facility_id = ? and year_num = ?" ;
			pstmt = con.prepareStatement( duplicateSql ) ;

			pstmt.setString( 1, addedFacilityId ) ;
			pstmt.setInt( 2, year_num);
			rs = pstmt.executeQuery();
			if ( rs.next() ){
				insertable = false ;
				java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS,"Common" ) ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
				con.commit();
			}
			if(rs!=null) rs.close();	
			if(pstmt!=null)pstmt.close();		
		}catch ( Exception e ){
			insertable = false ;
			sb.append( e+ "<br>");
			e.printStackTrace();
			if (con != null)
				{
				try
					{
					con.rollback() ;
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
					}
				}
		}
		if ( insertable ){
			try
			{
				pstmt = con.prepareStatement( sql );
				pstmt.setString ( 1, addedFacilityId ) ;
				pstmt.setInt    ( 2, year_num) ;
				pstmt.setInt    ( 3, next_referral_num  ) ;
				pstmt.setString ( 4, addedById ) ;
				pstmt.setDate   ( 5, added_date) ;
				pstmt.setString ( 6, addedFacilityId) ;
				pstmt.setString ( 7, addedAtWorkstation) ;
				pstmt.setString ( 8, modifiedById) ;
				pstmt.setDate   ( 9, modified_date) ;
				pstmt.setString ( 10, modifiedFacilityId) ;
				pstmt.setString ( 11, modifiedAtWorkstation) ;
				int res = pstmt.executeUpdate() ;

				if ( res != 0 ){
					result = true ;
					java.util.Hashtable message = MessageManager.getMessage(locale, RECORD_INSERTED,"SM" ) ;
					sb.append( (String) message.get("message") ) ;

				    message.clear();
					con.commit();
				}

				if(pstmt != null) pstmt.close() ;
			}catch (Exception e) 
				{
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try 
					{
					con.rollback();
					}
					catch (Exception ee) {
						ee.printStackTrace();
					}
			}
			finally 
			{
				if (con != null)
				{
					ConnectionManager.returnConnection(con,p);				
				}
			}
		}
	  }catch(Exception e)
	 {
		  e.printStackTrace();
	 }
	 finally 
			{
				if (con != null)
				{
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
	public java.util.HashMap updateReferralIDNumbering(HashMap mapData){
		Properties p = (Properties)mapData.get("p");
		int year_num =  ((Integer)mapData.get("year_num")).intValue();
		int next_referral_num = ((Integer)mapData.get("next_referral_num")).intValue();
		String addedFacilityId = (String) mapData.get("addedFacilityId");
		String addedAtWorkstation = (String) mapData.get("addedAtWorkstation");
String locale="";
			locale= p.getProperty("LOCALE");
        java.util.HashMap results = new java.util.HashMap() ;
        boolean result = false ;
        boolean updatable = true ;
        StringBuffer sb = new StringBuffer( "" ) ;

        String sql = "update AM_REF_ID_NUM_FOR_FCY set next_referral_num = ?, modified_by_id = ?,modified_date = ?, modified_facility_id = ?,modified_at_ws_no = ? where facility_id = ? and year_num = ?";

        String modifiedById = p.getProperty( "login_user" ) ;
        String modifiedDate = dateFormat.format( new java.util.Date() ) ;
        Date modified_date = Date.valueOf( modifiedDate ) ;
        String modifiedFacilityId = addedFacilityId ;
		
        String modifiedAtWorkstation = addedAtWorkstation ;
			
	
		ResultSet rs=null;
		mapData.clear();
		try{

        try
		{
			con = ConnectionManager.getConnection(p);

			String duplicateSql = "select next_referral_num from AM_REF_ID_NUM_FOR_FCY where facility_id=? and year_num= ?" ;
			pstmt = con.prepareStatement( duplicateSql ) ;
			pstmt.setString( 1, addedFacilityId ) ;
			pstmt.setInt( 2, year_num ) ;
			rs = pstmt.executeQuery() ;
			int ni=0;

			if(rs!=null){
				rs.next() ;
				ni=rs.getInt("next_referral_num");
			}

			if (next_referral_num<ni ){
				updatable = false ;
				java.util.Hashtable message= MessageManager.getMessage(locale, NEXT_NUMBER_CHECK,"AM") ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
			}
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();	
		}catch(Exception e)
			{
			updatable = false ;
			sb.append( "number check "+e + "<br>" ) ;
			e.printStackTrace() ;
		}

		if ( updatable ) {
			try
				{
				pstmt = con.prepareStatement( sql );
				pstmt.setInt( 1, next_referral_num) ;
				pstmt.setString ( 2, modifiedById ) ;
				pstmt.setDate   ( 3, modified_date ) ;
				pstmt.setString ( 4, modifiedFacilityId ) ;
				pstmt.setString ( 5, modifiedAtWorkstation ) ;
				pstmt.setString ( 6, modifiedFacilityId ) ;
				pstmt.setInt    ( 7, year_num ) ;

				int res = pstmt.executeUpdate() ;

				if ( res != 0 )
				{
					result = true ;
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED ,"SM") ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
					con.commit();
				}
				if(pstmt != null) pstmt.close() ;
			}
			catch ( Exception e )
			{
				sb.append( next_referral_num + modifiedById + modified_date + modifiedFacilityId +modifiedAtWorkstation+year_num+e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try 
					{
					con.rollback();
					
					if(pstmt!=null) pstmt.close();
					
					}
					catch (Exception ee) 
					{
						ee.printStackTrace();
					}
			}finally {
				if (con != null)
				ConnectionManager.returnConnection(con,p);
			}
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
				if (con != null)
				ConnectionManager.returnConnection(con,p);
			}
        results.put( "status", new Boolean(result) ) ;
        results.put( "error", sb.toString() ) ;
        return results ;
    }
}
