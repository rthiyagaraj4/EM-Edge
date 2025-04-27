/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP.IPAgeGroupBkgLimit;
 
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import java.util.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="IPAgeGroupBkgLimit"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPAgeGroupBkgLimit"
*	local-jndi-name="IPAgeGroupBkgLimit"
*	impl-class-name="eIP.IPAgeGroupBkgLimit.IPAgeGroupBkgLimitManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPAgeGroupBkgLimit.IPAgeGroupBkgLimitManagerLocal"
*	remote-class="eIP.IPAgeGroupBkgLimit.IPAgeGroupBkgLimitManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPAgeGroupBkgLimit.IPAgeGroupBkgLimitManagerLocalHome"
*	remote-class="eIP.IPAgeGroupBkgLimit.IPAgeGroupBkgLimitManagerHome"
*	generate= "local,remote"
*
*
*/
public class IPAgeGroupBkgLimitManager implements SessionBean 
{
	Connection con ;
	PreparedStatement pstmt ;
	Statement stmt ;
	ResultSet rs;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String RECORD_INSERTED 	= "RECORD_INSERTED" ;
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

	public HashMap AddModify( Properties p, HashMap hashData )
	{
		String locale = p.getProperty("LOCALE");
		HashMap results = new HashMap() ;
		boolean isExistRecordDelete	= false;
		String 	age_group_code	= (String)hashData.get("age_group_code");
		String 	facility_id		= (String)hashData.get("facilityId");
		ArrayList 	F			= (ArrayList)hashData.get("female");
		ArrayList 	M			= (ArrayList)hashData.get("male");
		ArrayList 	U			= (ArrayList)hashData.get("unknown");
		ArrayList 	T			= (ArrayList)hashData.get("total");
		ArrayList 	S			= (ArrayList)hashData.get("select");
		ArrayList 	B			= (ArrayList)hashData.get("beds");
		String client_ip_address = (String)hashData.get("client_ip_address");
		boolean result 			 = false ;

		StringBuffer sb					= new StringBuffer( "" ) ;
		String modifiedById				= p.getProperty( "login_user" ) ;
		String addedDate				= dateFormat.format( new java.util.Date() ); 
		java.sql.Date added_date		= java.sql.Date.valueOf( addedDate ) ;

		try
		{
			con						= ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			int count		  = 0;
			StringBuffer sql  = new StringBuffer("");
			StringBuffer sqli = new StringBuffer("");
			StringBuffer sqld = new StringBuffer("");
		/*		
		the line are commeted and for this 17742 and 17616 and implemented new logic
			for(int i=0;i<S.size();i++)
			{   
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("Select count(*) from IP_BOOK_LIMIT_BY_AGE_GRP where facility_id='"+facility_id+"' and age_group_code='"+age_group_code+"' and bed_class_code='"+B.get(i)+"'");
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql.toString());
				rs.next();
				count = rs.getInt(1);

				if(count==0)
				{
					//INSERT
					if(sqli.length() > 0) sqli.delete(0,sqli.length());
					sqli.append(" Insert into IP_BOOK_LIMIT_BY_AGE_GRP ( facility_id,  age_group_code, bed_class_code, max_male_dly_booking, max_female_dly_booking, max_unknown_dly_booking, max_total_dly_booking, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,? ) ");
					pstmt = con.prepareStatement(sqli.toString());
					pstmt.setString(1,facility_id);
					pstmt.setString(2,age_group_code);
					pstmt.setString(3,(String) B.get(i));
					pstmt.setInt(4,Integer.parseInt((String)M.get(i)) );
					pstmt.setInt(5,Integer.parseInt((String)F.get(i)) );
					pstmt.setInt(6,Integer.parseInt((String)U.get(i)) );
					pstmt.setInt(7,Integer.parseInt((String)T.get(i)) );
					pstmt.setString(8, modifiedById);
					pstmt.setDate(9, added_date ) ;
					pstmt.setString(10, client_ip_address) ;
					pstmt.setString(11, facility_id  ) ;
					pstmt.setString(12, modifiedById ) ;
					pstmt.setDate(13, added_date ) ;
					pstmt.setString(14, client_ip_address) ;
					pstmt.setString(15, facility_id  ) ;

					int res=pstmt.executeUpdate();

					if(res>0) result = true;
					else      result = false;

					if(pstmt!=null)
						pstmt.close();
				}
				else if(count>0)
				{
					//UPDATE
		
					if(sqlu.length() > 0) sqlu.delete(0,sqlu.length());
					sqlu.append("UPDATE IP_BOOK_LIMIT_BY_AGE_GRP SET MAX_MALE_DLY_BOOKING=?,MAX_FEMALE_DLY_BOOKING=?,MAX_UNKNOWN_DLY_BOOKING=?,MAX_TOTAL_DLY_BOOKING=?,modified_by_id=?,modified_date=?,modified_at_ws_no=?,modified_facility_id=? WHERE facility_id=? AND age_group_code=? AND bed_class_code=?");
					pstmt=con.prepareStatement(sqlu.toString());
					pstmt.setInt(1,Integer.parseInt((String)M.get(i) ) );
					pstmt.setInt(2,Integer.parseInt((String)F.get(i) ) );
					pstmt.setInt(3,Integer.parseInt((String)U.get(i) ) );
					pstmt.setInt(4,Integer.parseInt((String)T.get(i) ) );
					pstmt.setString(5, modifiedById ) ;
					pstmt.setDate(6, added_date ) ;
					pstmt.setString(7, client_ip_address) ;
					pstmt.setString(8, facility_id ) ;
					pstmt.setString(9, facility_id) ;
					pstmt.setString(10, age_group_code) ;
					pstmt.setString(11, (String) B.get(i) ) ;

					int res = pstmt.executeUpdate();

					if(res>0) 
						result = true;
					else 
						result = false;

					if(pstmt!=null)
					   pstmt.close();
				}
				if( rs   != null) rs.close();
				if(stmt  != null) stmt.close();
			}*/

			if(sql.length() > 0) sql.delete(0,sql.length());
			  sql.append("Select count(*) from IP_BOOK_LIMIT_BY_AGE_GRP where facility_id='"+facility_id+"' and age_group_code='"+age_group_code+"'");

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
						sqld.append("delete from IP_BOOK_LIMIT_BY_AGE_GRP where facility_id='"+facility_id+"' AND age_group_code='"+age_group_code+"'"); 
						
						pstmt=con.prepareStatement(sqld.toString());
						int res = pstmt.executeUpdate();

						if(res>0)	isExistRecordDelete = true;
						else		isExistRecordDelete = false;
						
						if(pstmt!=null) pstmt.close();

						
				}

				for(int i=0;i<S.size();i++)
				{
					if(sqli.length() > 0) sqli.delete(0,sqli.length());
					sqli.append(" Insert into IP_BOOK_LIMIT_BY_AGE_GRP ( facility_id,  age_group_code, bed_class_code, max_male_dly_booking, max_female_dly_booking, max_unknown_dly_booking, max_total_dly_booking, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,? ) ");
					pstmt = con.prepareStatement(sqli.toString());
					pstmt.setString(1,facility_id);
					pstmt.setString(2,age_group_code);
					pstmt.setString(3,(String) B.get(i));
					pstmt.setInt(4,Integer.parseInt((String)M.get(i)) );
					pstmt.setInt(5,Integer.parseInt((String)F.get(i)) );
					pstmt.setInt(6,Integer.parseInt((String)U.get(i)) );
					pstmt.setInt(7,Integer.parseInt((String)T.get(i)) );
					pstmt.setString(8, modifiedById);
					pstmt.setDate(9, added_date ) ;
					pstmt.setString(10, client_ip_address) ;
					pstmt.setString(11, facility_id  ) ;
					pstmt.setString(12, modifiedById ) ;
					pstmt.setDate(13, added_date ) ;
					pstmt.setString(14, client_ip_address) ;
					pstmt.setString(15, facility_id  ) ;

					int res=pstmt.executeUpdate();

					if(res>0) result = true;
					else      result = false;

					if(pstmt!=null)
						pstmt.close();

				}
				/*
			if(result)
				con.commit();
			else 
				con.rollback();

			final Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM") ;
			sb.append( (String) message.get("message") ) ;
			message.clear();
			*/
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
			
		
		}catch(Exception ee)
		{
			sb.append("Error in main try "+ee.getMessage());
			ee.printStackTrace();
		}
		finally
		{
				try 
				{
					if( rs   != null) rs.close();
					if(stmt  != null) stmt.close();
					if(pstmt != null) pstmt.close();
								} 
				catch (Exception ee) {     }
				if( con  != null ) ConnectionManager.returnConnection(con,p);
		}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	
	hashData.clear();
	F.clear();
	M.clear();
	U.clear();
	T.clear();
	S.clear();
	B.clear();

	return results ;
	}
} // end session bean
