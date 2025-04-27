/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.UserForOperator;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="UserForOperator"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="UserForOperator"
*	local-jndi-name="UserForOperator"
*	impl-class-name="eAM.UserForOperator.UserForOperatorManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.UserForOperator.UserForOperatorManagerLocal"
*	remote-class="eAM.UserForOperator.UserForOperatorManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.UserForOperator.UserForOperatorManagerLocalHome"
*	remote-class="eAM.UserForOperator.UserForOperatorManagerHome"
*	generate= "local,remote"
*
*
*/



public class UserForOperatorManager implements SessionBean 
{
	Connection con ;
	PreparedStatement pstmt ;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	//public final String NEXT_NUMBER = "NEXT_NUMBER_IS_INVALID" ;
	public final String OVERLAP_USER_OPER_STN = "OVERLAP_USER_OPER_STN" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	public final String RECORD_DELETED = "RECORD_DELETED" ;
	
	//int n=0;
	//SessionContext ctx;

	public void ejbCreate() {}
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

public java.util.HashMap insertUserForOperator(HashMap hashmap)
{
	java.util.Properties p =(Properties) hashmap.get("p");
	String  userid				=(String)hashmap.get("userid");
	String  station				=(String)hashmap.get("station");
	String 	facility			=(String)hashmap.get("fac");
	String	effectiveDateFrom	=(String)hashmap.get("effectiveDateFrom");
	String	effectiveDateTo		=(String)hashmap.get("effectiveDateTo");
	String 	addedFacilityId		=(String)hashmap.get("facilityId");
	String	addedAtWorkstation	=(String)hashmap.get("client_ip_address");
			String locale= p.getProperty("LOCALE");			
	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false ;
	boolean insertable = true ;
	StringBuffer sb = new StringBuffer( "" ) ;
	StringBuffer duplicateSql=new StringBuffer("");
	boolean nodup=true;
	boolean dat=true;

	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	ResultSet rs = null;
	
	String sql = "insert into am_user_for_oper_stn(	"+
		 " facility_id,	 appl_user_id," 	+
		 " oper_stn_id, " 	+
 		 " eff_date_from,eff_date_to," 	+
		 " added_by_id,	added_date, " 	+
		 " added_facility_id, added_at_ws_no, "+
		 " modified_by_id, modified_date, "+
		 " modified_facility_id,modified_at_ws_no " +
		 " ) values (?, ?, ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?,  ?)" ;

	String addedById = p.getProperty( "login_user" ) ;
	String addedDate = dateFormat.format( new java.util.Date() ) ;
	String modifiedById = addedById ;
	String modifiedDate = addedDate ;
	String modifiedFacilityId = addedFacilityId ;
	String modifiedAtWorkstation = addedAtWorkstation ;

	//java.sql.Date effective_date_from = null ;
	//java.sql.Date effective_date_to = null ;
	java.sql.Date added_date =java.sql.Date.valueOf( addedDate ) ;
	java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

	hashmap.clear();

	//effective_date_from = java.sql.Date.valueOf( effectiveDateFrom ) ;
	//if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
	//	effective_date_to = java.sql.Date.valueOf( effectiveDateTo ) ;
	try
	{
		try
		{
			con=ConnectionManager.getConnection(p);
		 	//String duplicateSql = "select ?  - trunc(sysdate)  dat from dual" ;
			pstmt = con.prepareStatement( "select to_date(?,'dd/mm/yyyy')  - trunc(sysdate)  dat from dual" ) ;

			pstmt.setString( 1, effectiveDateFrom ) ;
			rs = pstmt.executeQuery() ;
           	rs.next();
			int num=rs.getInt("dat");
			if(num<0)
			{
				insertable = false ;
				dat=false;
				nodup=false;
	
				java.util.Hashtable message = MessageManager.getMessage(locale, "FROM_DATE_LESS_SYSDATE" ,"SM") ;
				sb.append( (String) message.get("message") ) ;

				message.clear();
				con.commit();

				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
			}
		}
		catch ( Exception e )
		{
			insertable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			if (con != null)
	        {
				con.rollback() ;
			}
		}
		if(dat)
		{
			try
			{
				//final String duplicateSql = "select 1 from  am_user_for_oper_stn where  appl_user_id = ? and trunc(eff_date_from) = trunc(?)" ;
				String effective_date_from_old="";
				String effective_date_to_old="";
					
				//	String sql1="select  NVL ('', TO_CHAR (eff_date_to, 'dd/mm/yyyy'))  EFF_DATE from am_user_for_oper_stn WHERE  Trunc(eff_date_from)= TO_DATE('"+effectiveDateFrom+"','dd/mm/yyyy') AND appl_user_id = '"+userid+"' and facility_id='"+facility+"'";
				pstmt2= con.prepareStatement("select  NVL ('', TO_CHAR (eff_date_from, 'dd/mm/yyyy'))  eff_date_from from am_user_for_oper_stn WHERE  appl_user_id = '"+userid+"' and facility_id='"+facility+"'");
				rs = pstmt2.executeQuery() ;
				if (rs != null &&  rs.next() )
				{
					effective_date_from_old=rs.getString("eff_date_from");
					if(effective_date_from_old ==null) effective_date_from_old="";

				}

			if(pstmt2!=null) pstmt2.close();	

pstmt3= con.prepareStatement("select  NVL ('', TO_CHAR (eff_date_to, 'dd/mm/yyyy'))  eff_date_to from am_user_for_oper_stn WHERE  Trunc(eff_date_from)= TO_DATE('"+effective_date_from_old+"','dd/mm/yyyy') AND appl_user_id = '"+userid+"' and facility_id='"+facility+"'");
rs = pstmt3.executeQuery() ;
				if (rs != null &&  rs.next() )
				{

					effective_date_to_old=rs.getString("eff_date_to");
					if(effective_date_to_old ==null) effective_date_to_old="";

				}

				if(pstmt3!=null) pstmt3.close();

				if(effective_date_to_old.equals(effectiveDateFrom))
				{

				pstmt = con.prepareStatement( "select 1 from  am_user_for_oper_stn where  appl_user_id = ? and trunc(eff_date_TO) = to_date(?,'dd/mm/yyyy') AND facility_id='"+facility+"'" ) ;
				pstmt.setString( 1, userid ) ;
				pstmt.setString( 2, effective_date_to_old ) ;

				rs = pstmt.executeQuery() ;

			   	if (rs != null &&  rs.next() )
				{
					
					insertable = false ;
					nodup=false;
		
					java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS,"Common" ) ;
					sb.append( (String) message.get("message") ) ;

					message.clear();
					con.commit();

					if(rs!=null) rs.close();
					if(pstmt!=null)pstmt.close();
				}
				}
				if(rs!=null) rs.close();
			}
			catch ( Exception e )
			{
				insertable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;

				if (con != null)
		        {
					con.rollback() ;
					
				}
			}
			
			try
			{
				if(nodup)
				{
					duplicateSql.append(" select count(*) total  from am_user_for_oper_stn where ");
					duplicateSql.append( "((to_date(?,'dd/mm/yyyy')+1) between eff_date_from and NVL(eff_date_to,to_date('31/12/9999','DD/MM/YYYY') ) ");
					duplicateSql.append("or nvl((to_date(?,'dd/mm/yyyy')+1),TO_DATE('31/12/9999','DD/MM/YYYY')) ");
					duplicateSql.append("between eff_date_from and nvl(eff_date_to,TO_DATE('31/12/9999','DD/MM/YYYY') )  ");
					duplicateSql.append("or eff_date_from between (to_date(?,'dd/mm/yyyy')+1) and ");
					duplicateSql.append("nvl((to_date(?,'dd/mm/yyyy')+1),TO_DATE('31/12/9999','DD/MM/YYYY')) ) and appl_user_id = ? and FACILITY_ID=? ");

					pstmt1 = con.prepareStatement( duplicateSql.toString() ) ;
					pstmt1.setString( 1, effectiveDateFrom) ;
					pstmt1.setString( 2, effectiveDateTo) ;
					pstmt1.setString( 3, effectiveDateFrom) ;
					pstmt1.setString( 4, effectiveDateTo) ;
					pstmt1.setString( 5, userid ) ;
					pstmt1.setString( 6, facility ) ;

					rs = pstmt1.executeQuery() ;
					if(rs !=null && rs.next() )
					{
						int total=rs.getInt("total");
						if(total>0)
						{
							insertable = false ;

							java.util.Hashtable message = MessageManager.getMessage( locale, OVERLAP_USER_OPER_STN ,"AM") ;
							sb.append( (String) message.get("message") ) ;

							message.clear();
							con.commit();

						}
					}
				}
						if(rs!=null) rs.close();
						if(pstmt!=null)pstmt.close();
			}
			catch ( Exception e )
			{
				insertable = false ;
				sb.append( "Overlap:"+e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				if (con != null)
		        {
					con.rollback() ;
					
				}
			}
			if ( insertable )
			{
				try
				{
					pstmt = con.prepareStatement( sql );
					pstmt.setString	( 1, facility ) ;
					pstmt.setString	( 2, userid ) ;
					pstmt.setString	( 3, station  ) ;
					pstmt.setString		( 4, effectiveDateFrom ) ;
					pstmt.setString		( 5, effectiveDateTo ) ;
					pstmt.setString	( 6, addedById ) ;
					pstmt.setDate		( 7, added_date ) ;
					pstmt.setString	( 8, addedFacilityId ) ;
					pstmt.setString	( 9, addedAtWorkstation ) ;
					pstmt.setString	( 10, modifiedById ) ;
					pstmt.setDate		( 11, modified_date ) ;
					pstmt.setString	( 12, modifiedFacilityId ) ;
					pstmt.setString	( 13, modifiedAtWorkstation ) ;
					int res = pstmt.executeUpdate() ;
					if ( res != 0 )
					{
						result = true ;
	
						java.util.Hashtable message = MessageManager.getMessage(locale, RECORD_INSERTED,"SM" ) ;
						sb.append( (String) message.get("message") ) ;

						message.clear();
						con.commit();
					}

					if(pstmt != null) pstmt.close();
			}
			catch ( Exception e )
		    {
				sb.append( "gen:"+e.getMessage() + "<br>" +"Date:"+effectiveDateFrom ) ;
				e.printStackTrace() ;
		    }
		    finally
		    {
				if (con != null)
				{
					con.rollback() ;
				}
					
				}
			
		}
	}
}
	catch(Exception e)
	{
		try
		{
			con.rollback() ;
		}
		catch (Exception ce) 
		{}
	}
	finally
	{
	try
	{
		if(rs!= null) rs.close();
		if(pstmt1 != null) pstmt1.close();
		
	}
	catch(Exception e)
	{}
	if(con!=null) ConnectionManager.returnConnection(con,p);
}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	return results ;
}
/**
* @ejb.interface-method
*	 view-type="both"
*/

public java.util.HashMap modifyOperator(HashMap hashmap)
{
	java.util.Properties p =(Properties) hashmap.get("p");
	String  userid				=(String)hashmap.get("userid");
	String 	station				=(String)hashmap.get("station");
	String 	facility			=(String)hashmap.get("fac");
	String	effectiveDateFrom	=(String)hashmap.get("effectiveDateFrom");
	String	effectiveDateTo		=(String)hashmap.get("effectiveDateTo");
	String 	addedFacilityId		=(String)hashmap.get("facilityId");
	String	addedAtWorkstation	=(String)hashmap.get("client_ip_address");
	String  olddate				=(String)hashmap.get("olddate");
	String  fromchk				=(String)hashmap.get("fromchk");
		String locale= p.getProperty("LOCALE");				
	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false ;
	boolean updatable = true ;
	StringBuffer sb = new StringBuffer( "" ) ;
	StringBuffer duplicateSql=new StringBuffer("");
	boolean nodup=true;
	ResultSet rs=null;

	String sql = "update am_user_for_oper_stn set " +
			     " oper_stn_id 		= ?,  " +
			     "eff_date_from=to_date(?,'dd/mm/yyyy'),"+
			     " facility_id 		= ?,  " +
			     " eff_date_to		= to_date(?,'dd/mm/yyyy'),  " +
			     " modified_by_id		= ?,  " +
			     " modified_date		= ?,  " +
			     " modified_facility_id	= ?,  " +
			     " modified_at_ws_no 	= ?   " +
			     " where  appl_user_id 	= ?   "+
			     " and eff_date_From	= to_date(?,'dd/mm/yyyy')   ";

	String modifiedById = p.getProperty( "login_user" ) ;
	String modifiedDate = dateFormat.format( new java.util.Date() ) ;
	//java.sql.Date effective_date_from = null ;
	//java.sql.Date effective_date_to = null ;
	java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
	//effectiveDateFrom=effectiveDateFrom.trim();
	//effectiveDateTo=effectiveDateTo.trim();
	String modifiedFacilityId = addedFacilityId ;
	String modifiedAtWorkstation = addedAtWorkstation ;
	boolean dat=true;
 	//effective_date_from = java.sql.Date.valueOf( effectiveDateFrom ) ;
 	//java.sql.Date OldDate=java.sql.Date.valueOf(olddate);

	hashmap.clear();

	//if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
	//	effective_date_to = java.sql.Date.valueOf( effectiveDateTo ) ;
	try
	{
		try
		{
			con = ConnectionManager.getConnection(p);

		 	//final String duplicateSql = "select ?  - trunc(sysdate)  dat from dual" ;
			pstmt = con.prepareStatement( "select to_date(?,'dd/mm/yyyy')  - trunc(sysdate)  dat from dual" ) ;
			pstmt.setString( 1, effectiveDateFrom ) ;

			rs = pstmt.executeQuery() ;
			rs.next();
			int num=rs.getInt("dat");

			if((num<0) && (fromchk.equals("check")))
			{
				updatable = false ;
				dat=false;
				nodup=false;
				java.util.Hashtable message = MessageManager.getMessage( locale, "FROM_DATE_LESS_SYSDATE" ,"SM") ;
				sb.append( (String) message.get("message") ) ;

				message.clear();
				con.commit();
			}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
		}
		catch ( Exception e )
		{
			updatable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			if (con != null)
	        {
				con.rollback() ;
				
			}
		}
		try
		{
			if(dat)
			{
				if(!olddate.equals(effectiveDateFrom))
				{
		 			//final String duplicateSql = "select 1 from  am_user_for_oper_stn where  appl_user_id = ? and trunc(eff_date_from) = trunc(?)" ;
					pstmt = con.prepareStatement( "select 1 from  am_user_for_oper_stn where  appl_user_id = ? and trunc(eff_date_from) = to_date(?,'dd/mm/yyyy') AND facility_id='"+facility+"'" ) ;

					pstmt.setString( 1, userid ) ;
					pstmt.setString( 2, effectiveDateFrom ) ;

					rs = pstmt.executeQuery() ;
					if ( rs.next() )
					{
						updatable = false ;
						nodup=false;
						java.util.Hashtable message = MessageManager.getMessage(locale , CODE_ALREADY_EXISTS,"Common" ) ;
						sb.append( (String) message.get("message") ) ;

						message.clear();
						con.commit();
					}
					if(pstmt!=null)pstmt.close();
					if(rs!=null)rs.close();
				}
			}
		}
		catch ( Exception e )
		{
			updatable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;

			if (con != null)
		    {
				con.rollback() ;
				
			}
		}
		try
		{
			if(nodup)
			{
				duplicateSql.append(" select count(*) total  from am_user_for_oper_stn where ");
				duplicateSql.append( "(to_date(?,'dd/mm/yyyy') between eff_date_from and NVL(eff_date_to,to_date('31/12/9999','DD/MM/YYYY') ) ");
				duplicateSql.append("or nvl(to_date(?,'dd/mm/yyyy'),TO_DATE('31/12/9999','DD/MM/YYYY')) ");
				duplicateSql.append("between eff_date_from and nvl(eff_date_to,TO_DATE('31/12/9999','DD/MM/YYYY') )  ");
				duplicateSql.append("or eff_date_from between to_date(?,'dd/mm/yyyy') and ");
				duplicateSql.append("nvl(to_date(?,'dd/mm/yyyy'),TO_DATE('31/12/9999','DD/MM/YYYY')) ) and appl_user_id = ? and eff_date_from != to_date(?,'dd/mm/yyyy') and facility_id=?");

				pstmt = con.prepareStatement( duplicateSql.toString() ) ;

				pstmt.setString( 1, effectiveDateFrom) ;
				pstmt.setString( 2, effectiveDateTo) ;
				pstmt.setString( 3, effectiveDateFrom) ;
				pstmt.setString( 4, effectiveDateTo) ;
				pstmt.setString( 5, userid ) ;
				pstmt.setString( 6,olddate);
				pstmt.setString( 7, facility ) ;


				rs = pstmt.executeQuery() ;
				if ( rs.next() )
				{
					int total=rs.getInt("total");
					if(total>0)
					{
						updatable = false ;
						java.util.Hashtable message = MessageManager.getMessage(locale , OVERLAP_USER_OPER_STN,"AM" ) ;
						sb.append( (String) message.get("message") ) ;

						message.clear();
						con.commit();
					}
				}
			}
		}
		catch ( Exception e )
		{
			updatable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;

			if (con != null)
		    {
				con.rollback() ;
			}
		}
			if ( updatable )
			{
				try
				{
					pstmt = con.prepareStatement( sql );
					pstmt.setString	( 1, station ) ;
					pstmt.setString	( 2, effectiveDateFrom ) ;
					pstmt.setString	( 3, facility) ;
					pstmt.setString	( 4, effectiveDateTo  ) ;
					pstmt.setString	( 5, modifiedById ) ;
					pstmt.setDate	( 6, modified_date ) ;
					pstmt.setString	( 7, modifiedFacilityId ) ;
					pstmt.setString	( 8, modifiedAtWorkstation ) ;
					pstmt.setString	( 9, userid) ;
					pstmt.setString	(10,olddate);

					int res = pstmt.executeUpdate() ;
					if ( res != 0 )
					{
						result = true ;
						java.util.Hashtable message = MessageManager.getMessage(locale , RECORD_MODIFIED ,"SM") ;
						sb.append( (String) message.get("message") ) ;

						message.clear();
						con.commit();
					}
					pstmt.close() ;
				}
				catch ( Exception e )
				{
					sb.append( e.getMessage() + "<br>" ) ;
					e.printStackTrace() ;
				}
				finally
				{
					if (con != null)
					{
						con.rollback() ;
					}
				}
				}
	}
	catch(Exception e)
	{
		try
		{
			con.rollback() ;
		}
		catch (Exception ce) 
		{}
	}
	finally
	{
		try
		{
			if(pstmt != null) pstmt.close();
			if(rs!= null) rs.close();
		}
		catch(Exception e){}
		ConnectionManager.returnConnection(con,p);
	}
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			return results ;
}
/**
* @ejb.interface-method
*	 view-type="both"
*/

public java.util.HashMap deleteUserForOperator(HashMap hashmap)
	{
		java.util.Properties p =(Properties) hashmap.get("p");
		String   userid				=(String)hashmap.get("userid");
		String 	 effectiveDateFrom	=(String)hashmap.get("effectiveDateFrom");
		String facility=(String)hashmap.get("fac");

	int res =0;
	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false ;
	StringBuffer sb = new StringBuffer( "" ) ;
		String locale=p.getProperty("LOCALE");
	try	{
		

		String sql = "delete from am_user_for_oper_stn where appl_user_id=? and TRUNC(eff_date_from)=To_date(?,'dd/mm/yyyy') AND facility_id='"+facility+"' ";
		con =ConnectionManager.getConnection(p);
		pstmt = con.prepareStatement( sql );
		pstmt.setString	( 1, userid) ;
		pstmt.setString( 2, effectiveDateFrom );
	
		 res = pstmt.executeUpdate() ;
		if ( res>0 )
		{
			result = true ;
			con.commit();
			java.util.Hashtable message = MessageManager.getMessage(locale , RECORD_DELETED ,"SM") ;
			sb.append( (String) message.get("message") ) ;

			message.clear();
			
		}else
		{
		}
		if(pstmt!=null) pstmt.close();
	}
	catch ( Exception e )
	{
		sb.append( "gen:"+e.getMessage() + "<br>" ) ;
		e.printStackTrace() ;
		try 
		{
			con.rollback() ;
		}
		catch (Exception ce) {}
	}
	finally
	{
		if (con != null)
	    {
			try 
			{
				ConnectionManager.returnConnection(con,p);
		   	} 
			catch (Exception ee) {}
	   }
    }
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	return results ;
}
}
