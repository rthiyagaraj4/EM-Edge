/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCommon.Common ;

import java.sql.* ;
import java.util.* ;

import javax.sql.* ;
import javax.ejb.* ;
import javax.naming.* ;

import webbeans.eCommon.* ;

public abstract class CommonEJBSessionAdapter implements SessionBean {
	SessionContext sessionContext = null ;
	protected DataSource dataSource = null ;

	public CommonEJBSessionAdapter() {
	}

	protected void finalize() {
		this.sessionContext = null ;
		this.dataSource = null ;
	}
	
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}

	public void setSessionContext( SessionContext sessionContext ) {
		this.sessionContext = sessionContext ;
	}

	public Connection getConnection(Properties properties) throws Exception {
		Connection connection = ConnectionManager.getConnection(properties) ;
		return connection ;
	}

	public void closeConnection( Connection connection, Properties properties ) throws Exception {
		if( connection != null )
			ConnectionManager.returnConnection( connection, properties ) ;
	}

	public void closeStatement( Statement stmt ) throws Exception {
		if( stmt != null )
			stmt.close() ;
	}

	public void closeStatement( PreparedStatement pstmt ) throws Exception {
		if( pstmt != null )
			pstmt.close() ;
	}

	public void closeStatement( CallableStatement cstmt ) throws Exception {
		if( cstmt != null )
			cstmt.close() ;
	}

	public void closeResultSet( ResultSet resultSet ) throws Exception {
		if( resultSet != null )
			resultSet.close() ;
	}
}
