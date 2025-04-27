/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMAutoTrackOutToOPD;

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
*	name="FMAutoTrackOutToOPD"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMAutoTrackOutToOPD"
*	local-jndi-name="FMAutoTrackOutToOPD"
*	impl-class-name="eFM.FMAutoTrackOutToOPD.FMAutoTrackOutToOPDManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMAutoTrackOutToOPD.FMAutoTrackOutToOPDLocal"
*	remote-class="eFM.FMAutoTrackOutToOPD.FMAutoTrackOutToOPDRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMAutoTrackOutToOPD.FMAutoTrackOutToOPDLocalHome"
*	remote-class="eFM.FMAutoTrackOutToOPD.FMAutoTrackOutToOPDHome"
*	generate= "local,remote"
*
*
*/

public class FMAutoTrackOutToOPDManager implements SessionBean 
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
	public java.util.HashMap createOPD(
							java.util.Properties			p,
							java.util.HashMap				htOPD
						 ) 
		{
		StringBuffer sb = new StringBuffer( "" ) ;
		StringBuffer sb1 = new StringBuffer( "" ) ;
		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false ;		
		

		String sql = "" ;
		String p_iss_locn_code = "";
		String p_iss_locn_iden = "";
		String p_iss_mr_locn = "";
		String p_appt_date = "";
		String p_issue_user = "";
		String p_from_clinic = "";
		String p_to_clinic = "";

		String login_facility_id = "";
		String login_user_id = "";
		String addedAtWorkstation  = "";
		String locale  = "";
		//String  iss_locn_code_cmb="";
		String auto_track_yn="";
		String flag="false";
		/* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
	    String start_time		 = "";
	    String end_time			 = "";
	    /* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/ 
		
		int res = 0;
         int cnt=0; 
		con = ConnectionManager.getConnection(p);

		try
		{			

			login_facility_id	= (String) htOPD.get ( "login_facility_id" );
			login_user_id		= (String) htOPD.get ( "login_user_id" );
			addedAtWorkstation	= (String) htOPD.get ( "addedAtWorkstation" );
			p_iss_locn_code		= (String) htOPD.get ( "p_iss_locn_code" );
			p_iss_locn_iden		= (String) htOPD.get ( "p_iss_locn_iden" );
			p_iss_mr_locn		= (String) htOPD.get ( "p_iss_mr_locn" );
			p_appt_date			= (String) htOPD.get ( "p_appt_date" );
			p_issue_user		= (String) htOPD.get ( "p_issue_user" );
			p_from_clinic		= (String) htOPD.get ( "p_from_clinic" );
			p_to_clinic			= (String) htOPD.get ( "p_to_clinic" );
			locale			= (String) htOPD.get ( "locale" );
			/* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
			start_time			= (String) htOPD.get ( "start_time" );
			end_time			= (String) htOPD.get ( "end_time" );
			/* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/
			
					
			
           	htOPD.clear();
            CallableStatement cs = null ;

			sql = "select auto_track_yn from FM_PULLING_LIST where facility_id= ? and src_fs_locn_code= ? and trunc(appt_date)=to_date(?,'dd/mm/rrrr') and clinic_code between nvl(?,'!') and nvl(?,'~') ";	
			if(!start_time.equals("") && !end_time.equals("")){
				String start_time_number	= start_time.replace(":", "");
				String end_time_number		= end_time.replace(":", "");
				sql	= sql + "and to_number(to_char(appt_time,'hh24mi'))  between "+start_time_number+" and "+end_time_number+"";
			}	
			
			pstmt = con.prepareStatement( sql );

				pstmt.setString	( 1, login_facility_id) ;
				pstmt.setString	( 2, p_iss_locn_code) ;
				pstmt.setString	( 3, p_appt_date) ;
				pstmt.setString	( 4, p_from_clinic) ;
				pstmt.setString	( 5, p_to_clinic ) ;
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
			if(rs != null)	rs.close();

			
			cs = con.prepareCall("{call FM_AUTO_TRACK_TO_OPD(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
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
				cs.setString(4 , p_iss_locn_code);
				cs.setString(5  , p_iss_locn_iden);
				cs.setString(6 , p_iss_mr_locn);
				cs.setString( 7 , p_appt_date);
				cs.setString( 8, start_time);
				cs.setString( 9, end_time);
				cs.setString( 10 , p_issue_user);
				cs.setString( 11 , p_from_clinic);
				cs.setString( 12, p_to_clinic);
				
				
				cs.registerOutParameter( 13,java.sql.Types.INTEGER);
				cs.execute();
				res = cs.getInt(13) ;
			}

			if ( res ==1 )
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"SM" ) ;
				sb.append( (String) message.get("message") ) ;
				sb1.append("1");
				message.clear();
			}
			
			if ( res ==2 )
			{
			   result = false ;
			   java.util.Hashtable  message = MessageManager.getMessage( locale, "NO_FILES_TRACKED_OUT","FM" ) ;
			   String msg1 = (String) message.get("message"); // "APP-FM0062 Files are already Auto Tracked out";				
				sb.append(msg1);
				sb1.append("1");
				message.clear();		
					}
			 
			 
			 
			 if (pstmt!=null)  pstmt.close();
			 if (cs!=null)  cs.close();
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
				sb.append("While Rollback :"+ce.getMessage() + "<br>" ) ;
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
