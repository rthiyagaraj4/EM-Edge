/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMAutoTrackOutToIPW;

import javax.ejb.* ;

import java.sql.*;
import java.rmi.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="FMAutoTrackOutToIPW"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMAutoTrackOutToIPW"
*	local-jndi-name="FMAutoTrackOutToIPW"
*	impl-class-name="eFM.FMAutoTrackOutToIPW.FMAutoTrackOutToIPWManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMAutoTrackOutToIPW.FMAutoTrackOutToIPWLocal"
*	remote-class="eFM.FMAutoTrackOutToIPW.FMAutoTrackOutToIPWRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMAutoTrackOutToIPW.FMAutoTrackOutToIPWLocalHome"
*	remote-class="eFM.FMAutoTrackOutToIPW.FMAutoTrackOutToIPWHome"
*	generate= "local,remote"
*
*
*/

public class FMAutoTrackOutToIPWManager implements SessionBean 
{
	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs = null;
	

	SessionContext ctx;
	
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;	

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) 
	{
		this.ctx=context;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap createIPW(
							java.util.Properties			p,
							java.util.HashMap				htIPW
						 ) 
		{
		StringBuffer sb = new StringBuffer( "" ) ;
		StringBuffer sb1 = new StringBuffer( "" ) ;
		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false ;		
		
		String sql = "";
		String p_iss_locn_code = "";
		String p_iss_locn_iden = "";
		String p_iss_mr_locn = "";
		String p_preferred_date = "";
		String p_issue_user = "";
		String p_from_nursing_unit = "";
		String p_to_nursing_unit = "";

		String login_facility_id = "";
		String login_user_id = "";
		String addedAtWorkstation  = "";
		String locale  = "";
		String auto_track_yn="";
		String flag="false";
		int res = 0;
       int cnt=0;
		con = ConnectionManager.getConnection(p);

		try
		{			

			login_facility_id	= (String) htIPW.get ( "login_facility_id" );
			login_user_id		= (String) htIPW.get ( "login_user_id" );
			addedAtWorkstation	= (String) htIPW.get ( "addedAtWorkstation" );
			p_iss_locn_code		= (String) htIPW.get ( "p_iss_locn_code" );
			p_iss_locn_iden		= (String) htIPW.get ( "p_iss_locn_iden" );
			p_iss_mr_locn		= (String) htIPW.get ( "p_iss_mr_locn" );
			p_preferred_date			= (String) htIPW.get ( "p_preferred_date" );
			p_issue_user		= (String) htIPW.get ( "p_issue_user" );
			p_from_nursing_unit		= (String) htIPW.get ( "p_from_nursing_unit" );
			p_to_nursing_unit			= (String) htIPW.get ( "p_to_nursing_unit" );
			locale			= (String) htIPW.get ( "locale" );

					htIPW.clear();

            CallableStatement cs = null ;

			sql = "select a.auto_track_yn from FM_IP_PULLING_LIST a , IP_nursing_unit b where a.facility_id= ? and a.src_fs_locn_code= ? and a.dest_fs_locn_code=b.fs_locn_code and trunc(a.preferred_date)=to_date( ?,'dd/mm/rrrr') and a.facility_id=b.facility_id and b.nursing_unit_code between nvl(?,'!') and nvl(?,'~') ";	

			pstmt = con.prepareStatement( sql );

				pstmt.setString	( 1, login_facility_id) ;
				pstmt.setString	( 2, p_iss_locn_code) ;
				pstmt.setString	( 3, p_preferred_date) ;
				pstmt.setString	( 4, p_from_nursing_unit) ;
				pstmt.setString	( 5, p_to_nursing_unit ) ;
			rs = pstmt.executeQuery() ;

			while (rs.next())
			{
				  auto_track_yn=rs.getString("auto_track_yn");
			cnt++;		
		   	
			if(auto_track_yn == null ) auto_track_yn ="";
			if(auto_track_yn.equals("N"))
			{
              flag="true";
			}
		
		    }

			
			cs = con.prepareCall("{call FM_IP_AUTO_TRACK_TO_OPD(?,?,?,?,?,?,?,?,?,?,?)}");
			if (flag.equals("false"))
			{
					
				java.util.Hashtable message=null;
				if(cnt>0)
				{
				message = MessageManager.getMessage( locale, "ALREADY_TRACKED_OUT","FM" ) ;
				result = false ;
				}else{
                message = MessageManager.getMessage( locale, "NO_FILES_TRACKED_OUT","FM" ) ;
				result = false ;
					}
				
				
				String msg1 = (String) message.get("message"); // "APP-FM0062 Files are already Auto Tracked out";				
				message.clear();
				sb.append(msg1);
				sb1.append("1");
			}
			else
			{
				
				cs.setString( 1 , login_facility_id);
				cs.setString( 2 , addedAtWorkstation);
				cs.setString( 3 , login_user_id);
				cs.setString( 4 , p_iss_locn_code);
				cs.setString( 5 , p_iss_locn_iden);
				cs.setString( 6 , p_iss_mr_locn);
				cs.setString( 7 , p_preferred_date);
				cs.setString( 8 , p_issue_user);
				cs.setString( 9 , p_from_nursing_unit);
				cs.setString( 10, p_to_nursing_unit);
				cs.registerOutParameter( 11,java.sql.Types.INTEGER);
				cs.execute();
				res = cs.getInt(11) ;
		
       }
		
			if ( res ==1 )
			{
				con.commit();
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"SM" ) ;
				sb.append( (String) message.get("message") ) ;
				sb1.append("1");
				message.clear();
        			}
			
			
			if ( res ==2 )
			{
				result =false ;
				java.util.Hashtable  message = MessageManager.getMessage( locale, "NO_FILES_TRACKED_OUT","FM" ) ;
			   String msg1 = (String) message.get("message"); // "APP-FM0062 Files are already Auto Tracked out";				
				sb.append(msg1);
				sb1.append("1");
				message.clear();	
					}
			
			if(rs != null)		rs.close();
			if (pstmt!=null)  pstmt.close();
			if(cs != null)		cs.close();
		}
		catch(Exception e)
		{
			sb.append("Main Catch :"+e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try
				{
					con.rollback();
				}
				catch (Exception ce){
				sb.append("While Rolling back :"+ce.getMessage() + "<br>" ) ;
				}
		}
		finally
		{			  
			  ConnectionManager.returnConnection(con,p);			
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "errorval", sb1.toString() ) ;
		return results ;
	}
}
