/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMCancelRequest;

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
*	name="FMCancelRequest"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMCancelRequest"
*	local-jndi-name="FMCancelRequest"
*	impl-class-name="eFM.FMCancelRequest.FMCancelRequestManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMCancelRequest.FMCancelRequestLocal"
*	remote-class="eFM.FMCancelRequest.FMCancelRequestRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMCancelRequest.FMCancelRequestLocalHome"
*	remote-class="eFM.FMCancelRequest.FMCancelRequestHome"
*	generate= "local,remote"
*
*
*/

public class FMCancelRequestManager implements SessionBean
{
	Connection con ;
	PreparedStatement pstmt1 ;

	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext ctx ) {}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap createCancelRequest( java.util.Properties p, java.util.HashMap	htCancelRequest) 
	{
		StringBuffer sb   = new StringBuffer() ;
		HashMap results   = new HashMap() ;

		boolean result   = false ;
		int upd_req_dtl	 = 0;
		String sql1      ="";

		String p_req_no[]        = null;
		String p_remarks[]       = null;
	//	String p_cancel[]        = null;
		String p_volume_no[]     = null;
		
		String remarks            = "";
		String login_facility_id  = "";
		String login_user_id      = "";
		String addedAtWorkstation = "";
		String file_nos			  = "";
		String volume_nos		  = "";
		String req		          = "";
		String locale		          = "";
				
		con = ConnectionManager.getConnection(p);

		try
		{
			login_facility_id	= (String) htCancelRequest.get ( "login_facility_id" );
			login_user_id		= (String) htCancelRequest.get ( "login_user_id" );
			addedAtWorkstation	= (String) htCancelRequest.get ( "addedAtWorkstation" );
			file_nos			= (String) htCancelRequest.get ( "file_nos" );
			volume_nos			= (String) htCancelRequest.get ( "volume_nos" ); 
			req					= (String) htCancelRequest.get ( "req" );
			remarks				= (String) htCancelRequest.get ( "remarks" );
			locale				= (String) htCancelRequest.get ( "locale" );
					
			
			StringTokenizer st = new StringTokenizer(remarks,"`");
			p_remarks = new String[st.countTokens()];
			for(int i=0; i<p_remarks.length; i++)
			{
				p_remarks[i] = st.nextToken();
			}
			StringTokenizer token1=new StringTokenizer(req,"`");
			p_req_no = new String[token1.countTokens()];
			for(int i=0; i<p_req_no.length; i++)
			{
				p_req_no[i] = token1.nextToken();
			}
			StringTokenizer token2=new StringTokenizer(volume_nos,"`");
			p_volume_no = new String[token2.countTokens()];
			for(int i=0; i<p_volume_no.length; i++) 
			{
				p_volume_no[i] = token2.nextToken();
				if(p_volume_no[i] == null || p_volume_no[i].equals("null"))
					p_volume_no[i] = "";
			}
			
			int count = 0;
			StringTokenizer token = new StringTokenizer(file_nos,"`");

			sql1 = "UPDATE FM_REQ_DTL SET MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, CANCEL_YN = ?,REMARKS = ? WHERE FILE_NO = ? AND VOLUME_NO  = ? AND REQ_NO = ? ";
			pstmt1 = con.prepareStatement(sql1);
			
			while(token.hasMoreTokens())
			{ 
				pstmt1.setString ( 1, login_user_id) ;
				pstmt1.setString ( 2, addedAtWorkstation) ;
				pstmt1.setString ( 3, login_facility_id ) ;
				pstmt1.setString ( 4, "Y") ;
				pstmt1.setString ( 5, p_remarks[count]) ;
				pstmt1.setString ( 6, token.nextToken()) ;
				pstmt1.setString ( 7, p_volume_no[count]) ;
				pstmt1.setString ( 8, p_req_no[count]) ;
				
				upd_req_dtl = pstmt1.executeUpdate() ;
				
				count++;
			}
			if ( upd_req_dtl != 0  )
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			}
			if(pstmt1!=null)  pstmt1.close();
			htCancelRequest.clear();
		}
		catch(Exception e)
		{
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}catch (Exception ce){sb.append( ce.getMessage() + "<br>" ) ;}
		}
		finally
		{
			ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}
