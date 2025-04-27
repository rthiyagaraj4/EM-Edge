/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCommon.MessageManager ;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import webbeans.eCommon.*;

public class MessageManager implements SessionBean {
	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;

	public void ejbCreate() throws RemoteException, CreateException {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {}

	public java.util.Hashtable getMessage( java.util.Properties p, String code ) throws RemoteException {
 		java.util.Hashtable results = new java.util.Hashtable() ;
		StringBuffer sb = new StringBuffer( "" ) ;

		try {
			//String ecis_jdbc_driver = p.getProperty( "ecis_jdbc_driver" ) ; // Commented by kamatchi for checkstyle
			//String ecis_jdbc_dns 	= p.getProperty( "ecis_jdbc_dns" ) ; // Commented by kamatchi for checkstyle
			//String ecis_jdbc_user	= p.getProperty( "ecis_jdbc_user" ) ; // Commented by kamatchi for checkstyle
			//String ecis_jdbc_password=p.getProperty( "ecis_jdbc_password" ) ; // Commented by kamatchi for checkstyle

	//		Class.forName( ecis_jdbc_driver ) ;
	//		con = DriverManager.getConnection( ecis_jdbc_dns, ecis_jdbc_user, ecis_jdbc_password ) ;

			con=ConnectionManager.getConnection(p);

			pstmt = con.prepareStatement( "select message_id, message_text_sysdef from sm_message where message_ref = ? " ) ;
			pstmt.setString( 1, code ) ;
			rs = pstmt.executeQuery() ;

			if ( rs != null ) {
				rs.next() ;
				sb.append( "APP-" + rs.getString( "MESSAGE_ID" ) + " " + rs.getString( "MESSAGE_TEXT_SYSDEF" ) + "<br>" ) ;
			} else {
				sb.append( "No message found in sm_message for Duplicate Record.  Contact System Administrator." + "<br>" ) ;
			}
		} catch ( Exception e ) {
			results.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {
				if ( rs != null ) 
					rs.close() ;

				if ( pstmt != null )
					pstmt.close() ;
				if(con!=null)

					ConnectionManager.returnConnection(con,p);
			} catch ( Exception ee ) {}
		}

		results.put( "message", sb.toString() ) ;
		return results  ;
	}
}
