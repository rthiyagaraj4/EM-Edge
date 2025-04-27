/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP.IPNursingUnitBkgLt;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="IPNursingUnitBkgLt"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPNursingUnitBkgLt"
*	local-jndi-name="IPNursingUnitBkgLt"
*	impl-class-name="eIP.IPNursingUnitBkgLt.IPNursingUnitBkgLtManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPNursingUnitBkgLt.IPNursingUnitBkgLtManagerLocal"
*	remote-class="eIP.IPNursingUnitBkgLt.IPNursingUnitBkgLtManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPNursingUnitBkgLt.IPNursingUnitBkgLtManagerLocalHome"
*	remote-class="eIP.IPNursingUnitBkgLt.IPNursingUnitBkgLtManagerHome"
*	generate= "local,remote"
*
*
*/
public class IPNursingUnitBkgLtManager implements SessionBean {

	Connection con ;
	PreparedStatement pstmt ;
	Statement stmt ;
	ResultSet rs;
	java.text.SimpleDateFormat dateFormat   = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap NursUnitAddModify(java.util.Properties p,java.util.HashMap hashData)
	{
		String locale = p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap() ;

		String 	nursing_unit_code= (String)hashData.get("nursing_unit_code");
		String 	facility_id		= (String)hashData.get("facilityId");
		ArrayList 	F			= (ArrayList)hashData.get("female");
		ArrayList 	M			= (ArrayList)hashData.get("male");
		ArrayList 	U			= (ArrayList)hashData.get("unknown");
		ArrayList 	T			= (ArrayList)hashData.get("total");
		ArrayList 	S			= (ArrayList)hashData.get("select");
		ArrayList 	B			= (ArrayList)hashData.get("beds");
	
		String addedAtWorkstation	= (String)hashData.get("client_ip_address");
		hashData.clear();
		boolean result 				= false ;
		boolean isExistRecordDelete	= false;
		StringBuffer sb				= new StringBuffer( "" ) ;
		String addedById			= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
        java.sql.Date added_date	= java.sql.Date.valueOf( addedDate ) ;
		

		try
		{
				con = ConnectionManager.getConnection(p);
				con.setAutoCommit(false);
				int count=0;
				StringBuffer sql = new StringBuffer();
				StringBuffer sqli = new StringBuffer();			
				StringBuffer sqld = new StringBuffer();
				
				if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("Select count(*) from IP_BOOK_LIMIT_BY_NURS_UT where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"'");
			
				stmt  = con.createStatement();	
				rs    = stmt.executeQuery(sql.toString());
				rs.next();
				count = rs.getInt(1);
				if(stmt!=null) 
					stmt.close();
				if(rs != null) rs.close();
				
				if(count>0)
				{
					
					if(sqld.length() > 0) sqld.delete(0,sqld.length());
						sqld.append("delete from IP_BOOK_LIMIT_BY_NURS_UT where facility_id='"+facility_id+"' AND nursing_unit_code='"+nursing_unit_code+"'"); 
						
						pstmt=con.prepareStatement(sqld.toString());
						int res = pstmt.executeUpdate();

						if(res>0)	isExistRecordDelete = true;
						else		isExistRecordDelete = false;
						
						if(pstmt!=null) pstmt.close();

						
				}

				for(int i=0;i<S.size();i++)
				{
					
						if(sqli.length() > 0) sqli.delete(0,sqli.length());
						sqli.append("Insert into IP_BOOK_LIMIT_BY_NURS_UT (FACILITY_ID,  NURSING_UNIT_CODE, BED_CLASS_CODE,  MAX_MALE_DLY_BOOKING, MAX_FEMALE_DLY_BOOKING,  MAX_UNKNOWN_DLY_BOOKING, MAX_TOTAL_DLY_BOOKING, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? ) ");
						pstmt = con.prepareStatement(sqli.toString());
						pstmt.setString(1,facility_id);
						pstmt.setString(2,nursing_unit_code);
						pstmt.setString(3,(String) B.get(i) );
						pstmt.setInt(4,Integer.parseInt((String)M.get(i)) );
						pstmt.setInt(5,Integer.parseInt((String)F.get(i))  );
						pstmt.setInt(6,Integer.parseInt((String)U.get(i))  );
						pstmt.setInt(7,Integer.parseInt((String)T.get(i))  );
						pstmt.setString (8, addedById);
						pstmt.setDate(9, added_date ) ;
						pstmt.setString(10, addedAtWorkstation) ;
						pstmt.setString(11, facility_id  ) ;
						pstmt.setString(12, addedById ) ;
						pstmt.setDate(13, added_date ) ;
						pstmt.setString(14, addedAtWorkstation) ;
						pstmt.setString(15, facility_id  ) ;

						int res			   = pstmt.executeUpdate();

						if(res>0)	result = true;
						else		result = false;
						if(pstmt!=null) pstmt.close();
					
				
				}
			
			F.clear();
			M.clear();
			U.clear();
			T.clear();
			S.clear();
			B.clear();

  /* code changes are made for this incident 17616 date:Saturday, January 09, 2010*/
			  boolean chkcond=true;
			if(count>0)
			{
				if(result || isExistRecordDelete)
				{
					con.commit();
					final java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
					sb.append( (String) message.get("message"));
					message.clear();
					chkcond=false;
				}
				else 
					con.rollback();
			}

			if(count == 0 && result && chkcond) {				
				con.commit();				
				final java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
				sb.append( (String) message.get("message"));
				message.clear();
			} else {
				if(chkcond)
				{
				con.rollback();
				final java.util.Hashtable message = MessageManager.getMessage( locale,"NO_CHANGE_TO_SAVE","common" ) ;
				sb.append( (String) message.get("message"));
				message.clear();
				}
			}
			 /* code changes are made for this incident 17616 date:Saturday, January 09, 2010*/
			
	}	
	catch(Exception ee)
	{
		sb.append("Error in main try "+ee.getMessage());
		try
		{
		con.rollback();
		}
		catch(Exception exp)
		{
		exp.printStackTrace();
		}
	}
	finally
	{
		if (con != null)
        {
			try 
			{
				if(rs != null)  rs.close();
				if(stmt!=null)  stmt.close();
				if(pstmt!=null) pstmt.close();
            }
			catch (Exception ee) {}
				if( con != null ) ConnectionManager.returnConnection(con,p);
        }
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;

	return results ;
}
} // end session bean
