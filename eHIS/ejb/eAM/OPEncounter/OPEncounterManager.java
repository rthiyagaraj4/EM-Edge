/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.OPEncounter;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.Properties ;


import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="OPEncounter"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OPEncounter"
*	local-jndi-name="OPEncounter"
*	impl-class-name="eAM.OPEncounter.OPEncounterManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.OPEncounter.OPEncounterManagerLocal"
*	remote-class="eAM.OPEncounter.OPEncounterManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.OPEncounter.OPEncounterManagerLocalHome"
*	remote-class="eAM.OPEncounter.OPEncounterManagerHome"
*	generate= "local,remote"
*
*
*/


public class OPEncounterManager implements SessionBean {

    Connection con ;
    PreparedStatement pstmt ;
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

    public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
   // public final String NEXT_NUMBER = "NEXT_NUMBER_IS_INVALID" ;
    public final String RECORD_INSERTED = "RECORD_INSERTED" ;
    public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
    //SessionContext ctx;
    //int n=0;

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

    public java.util.HashMap insertEncounter(java.util.HashMap hmParams)
	{		
		int         next_num			=((Integer)hmParams.get("nextnum")).intValue();
		java.util.Properties p			 =(Properties) hmParams.get("p");
		String      effectiveDateFrom	=(String)hmParams.get("effectiveDateFrom");
		String      effectiveDateTo		=(String)hmParams.get("effectiveDateTo");
		String      effectiveStatus		=(String)hmParams.get("effectiveStatus");
		String      addedFacilityId		=(String)hmParams.get("facilityId");
		String      addedAtWorkstation	=(String)hmParams.get("client_ip_address");

             String locale="";
		locale= p.getProperty("LOCALE");            
        java.util.HashMap results = new java.util.HashMap() ;

        boolean result = false ;
        boolean insertable = true ;

        StringBuffer	sb = new StringBuffer( "" ) ;
		StringBuffer	sql=new StringBuffer("");
        sql.append("insert into   PR_ENC_ID_NUM_FOR_FCY(  "				);
        sql.append(" facility_id, "										);
        sql.append(" next_num, "										);		
        sql.append(" eff_date_from,    eff_date_to,    "				);
        sql.append(" eff_status, "										);
        sql.append(" added_by_id,      added_date, "					);
        sql.append(" added_facility_id, added_at_ws_no, "				);
        sql.append(" modified_by_id,    modified_date, "				);
        sql.append(" modified_facility_id, modified_at_ws_no "			);
        sql.append(" ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)"	);


        String addedById = p.getProperty( "login_user" ) ;
        String addedDate = dateFormat.format( new java.util.Date() ) ;
        String modifiedById = addedById ;
        String modifiedDate = addedDate ;
        String modifiedFacilityId = addedFacilityId ;
        String modifiedAtWorkstation = addedAtWorkstation ;

        Date effective_date_from = null ;
        Date effective_date_to = null ;
        Date added_date = Date.valueOf( addedDate ) ;
        Date modified_date = Date.valueOf( modifiedDate ) ;
		ResultSet rs =null;

        hmParams.clear();

        if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
            effective_date_from = Date.valueOf( effectiveDateFrom ) ;

        if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
            effective_date_to = Date.valueOf( effectiveDateTo ) ;

        try
            {
               con = ConnectionManager.getConnection(p);

                String duplicateSql = "select 1 from  PR_ENC_ID_NUM_FOR_FCY where facility_id = ?" ;
                pstmt = con.prepareStatement( duplicateSql ) ;

                pstmt.setString( 1, addedFacilityId ) ;
                rs = pstmt.executeQuery() ;

                if ( rs.next() )
                {
                    insertable = false ;

                    java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS,"Common" ) ;
                    sb.append( (String) message.get("message") ) ;
					message.clear();
                    con.commit();
                }
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close() ;
            }
            catch ( Exception e )
            {
                insertable = false ;
                sb.append( e+ "<br>" ) ;
                e.printStackTrace() ;

                if (con != null)
                {
                    try
					{
                         con.rollback() ;
                    }
					catch (Exception ce)
					{
						ce.printStackTrace();
					}
				  }
			}
			

        if ( insertable )
        {
            try
            {
                pstmt = con.prepareStatement( sql.toString() );
                pstmt.setString ( 1, addedFacilityId ) ;
                pstmt.setInt    ( 2, next_num  ) ;
                pstmt.setDate   ( 3, effective_date_from ) ;
                pstmt.setDate   ( 4, effective_date_to ) ;
                pstmt.setString ( 5, effectiveStatus ) ;
                pstmt.setString ( 6, addedById ) ;
                pstmt.setDate   ( 7, added_date ) ;
                pstmt.setString ( 8, addedFacilityId ) ;
                pstmt.setString ( 9, addedAtWorkstation ) ;
                pstmt.setString ( 10, modifiedById ) ;
                pstmt.setDate   ( 11, modified_date ) ;
                pstmt.setString ( 12, modifiedFacilityId ) ;
                pstmt.setString ( 13, modifiedAtWorkstation ) ;
                int res = pstmt.executeUpdate() ;

                if ( res != 0 )
                {
                    result = true ;
                

                java.util.Hashtable message = MessageManager.getMessage(locale, RECORD_INSERTED,"SM" ) ;
                sb.append( (String) message.get("message") ) ;
				message.clear();
                con.commit();
                }
            }
            catch ( Exception e ) {
                sb.append( e.getMessage() + "<br>" ) ;
                e.printStackTrace() ;
                try { con.rollback(); } catch (Exception ee) {}
            }
          finally
			  {
              if (con != null)
              {
               try 
				   {
                    pstmt.close() ;
					ConnectionManager.returnConnection(con,p);
               }
			   catch (Exception ee)
                 {
				   ee.printStackTrace();
                 }
              }
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

    public java.util.HashMap updateEncounter(java.util.HashMap hashmap)
	{
		int         next_num			=((Integer)hashmap.get("nextnum")).intValue();
		java.util.Properties p			 =(Properties) hashmap.get("p");
		String      effectiveDateFrom	=(String)hashmap.get("effectiveDateFrom");
		String      effectiveDateTo		=(String)hashmap.get("effectiveDateTo");		
		String      effectiveStatus		=(String)hashmap.get("effectiveStatus");
		String      addedFacilityId		=(String)hashmap.get("facilityId");
		String      addedAtWorkstation	=(String)hashmap.get("client_ip_address");
                                   
String locale="";
		locale= p.getProperty("LOCALE");
        java.util.HashMap results = new java.util.HashMap() ;
        boolean result = false ;
        boolean updatable = true ;
        StringBuffer sb = new StringBuffer( "" ) ;
		StringBuffer sql = new StringBuffer( "" ) ;
        sql.append("update PR_ENC_ID_NUM_FOR_FCY set " );
        sql.append(" next_num      = ?,  " ) ;
        sql.append(" eff_date_from     = ?,  " ) ;
        sql.append(" eff_date_to       = ?,  " ) ;
        sql.append(" eff_status        = ?,  " ) ;
        sql.append(" modified_by_id    = ?,  " ) ;
        sql.append("modified_date     = ?,  " ) ;
        sql.append(" modified_facility_id  = ?, " ) ;
        sql.append(" modified_at_ws_no = ? "  ) ;
        sql.append(" where facility_id     = ?") ;


        String modifiedById = p.getProperty( "login_user" ) ;
        String modifiedDate = dateFormat.format( new java.util.Date() ) ;
        Date effective_date_from = null ;
        Date effective_date_to = null ;
        Date modified_date = Date.valueOf( modifiedDate ) ;
        String modifiedFacilityId = addedFacilityId ;
        String modifiedAtWorkstation = addedAtWorkstation ;
		ResultSet rs = null;

		hashmap.clear();

        if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
            effective_date_from = Date.valueOf( effectiveDateFrom ) ;

        if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
            effective_date_to = Date.valueOf( effectiveDateTo ) ;
        try
        {
        con = ConnectionManager.getConnection(p);

        String duplicateSql = "select next_num from  PR_ENC_ID_NUM_FOR_FCY where facility_id = ?" ;
        pstmt = con.prepareStatement( duplicateSql ) ;
        pstmt.setString( 1, modifiedFacilityId ) ;

        rs = pstmt.executeQuery() ;
        int ni=0;

        if(rs!=null)
        {
            rs.next() ;
            ni=rs.getInt("next_num");
        }

        if (next_num<ni )
        {
            updatable = false ;
        
            java.util.Hashtable message = MessageManager.getMessage(locale, "NEXT_NUMBER_CHECK","AM") ;
			
            sb.append( (String) message.get("message") ) ;
			message.clear();
        }

    }
    catch(Exception e)
    {
            updatable = false ;
            sb.append( e + "<br>" ) ;
            e.printStackTrace() ;
    }
	finally
	{
		try 
		{
            if(pstmt!=null) pstmt.close() ;
			if(rs != null) rs.close();
			//ConnectionManager.returnConnection(con,p);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


        if ( updatable ) 
			{
            try {

				//con = ConnectionManager.getConnection(p);

                pstmt = con.prepareStatement( sql.toString() );
                pstmt.setInt( 1, next_num) ;
                pstmt.setDate   ( 2, effective_date_from  ) ;
                pstmt.setDate   ( 3, effective_date_to  ) ;
                pstmt.setString ( 4, effectiveStatus ) ;
                pstmt.setString ( 5, modifiedById ) ;
                pstmt.setDate   ( 6, modified_date ) ;
                pstmt.setString ( 7, modifiedFacilityId ) ;
                pstmt.setString ( 8, modifiedAtWorkstation ) ;
                pstmt.setString ( 9, modifiedFacilityId ) ;

                int res = pstmt.executeUpdate() ;

                if ( res != 0 ) 
				{
                    result = true ;
                    java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
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
                try { con.rollback(); } 
				catch (Exception ee) {
					ee.printStackTrace();
				}
            }
          finally {
              if (con != null)
              {
               try 
				{
                    ConnectionManager.returnConnection(con,p);
               } 
			   catch (Exception ee)
				{
				   ee.printStackTrace();
			     }
               }
            }
        }

        results.put( "status", new Boolean(result) ) ;
        results.put( "error", sb.toString() ) ;
        return results ;
    }
}

