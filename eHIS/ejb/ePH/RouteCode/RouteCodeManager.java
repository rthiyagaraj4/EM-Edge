/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//saved on 08/11/2005
package ePH.RouteCode                    ;

import java.rmi.*                        ;
import java.util.HashMap                 ;
import java.util.ArrayList               ;
import java.util.Properties              ;

import java.sql.*                        ;

import javax.ejb.*                       ;
import ePH.Common.PhEJBSessionAdapter    ;
//import oracle.jdbc.pool.OracleConnectionCacheImpl;
//import javax.naming.Context;
import javax.naming.InitialContext;
/**
*
* @ejb.bean
*	name="RouteCode"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"

*	jndi-name="SingleTableHandler"
*	local-jndi-name="SingleTableHandler"

*	impl-class-name="ePH.RouteCode.RouteCodeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.RouteCode.RouteCodeLocal"
*	remote-class="ePH.RouteCode.RouteCodeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.RouteCode.RouteCodeLocalHome"
*	remote-class="ePH.RouteCode.RouteCodeHome"
*	generate= "local,remote"
*
*
*/
public class RouteCodeManager extends PhEJBSessionAdapter {


/************************  insert()  ***********************************************************/
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public HashMap insert( HashMap tabData, HashMap sqlMap ) 
{

StringBuffer messages = new StringBuffer() ;
//StringBuffer debugbuffer=new StringBuffer();
HashMap map = new HashMap() ;
map.put( "result", new Boolean( false ) ) ;
map.put( "flag", "0" ) ;

final String SQL_PH_ROUTE_INSERT = (String) sqlMap.get( "SQL_PH_ROUTE_INSERT" );

String  login_by_id         = (String)tabData.get("login_by_id");
String  login_at_ws_no      = (String)tabData.get("login_at_ws_no");
String  login_facility_id   = (String)tabData.get("login_facility_id");


        /*String  added_by_id           = (String)tabData.get("added_by_id");
        String  added_at_ws_no      = (String)tabData.get("added_at_ws_no");
        String  added_facility_id   = (String)tabData.get("added_facility_id");
        String  modified_by_id      = (String)tabData.get("modified_by_id");
        String  modified_facility_id= (String)tabData.get("modified_facility_id");
        String  modified_at_ws_no   = (String)tabData.get("modified_at_ws_no");
        */
ArrayList arrList=(ArrayList)tabData.get("arrList");



Connection connection = null ;
PreparedStatement pstmt_insert = null ;
    try {
        //connection = getConnection( (Properties)tabData.get( "properties" ) ) ;
        InitialContext initialcontext = new InitialContext();
        /* OracleConnectionCacheImpl oracleconnectioncacheimpl = (OracleConnectionCacheImpl)initialcontext.lookup("jdbc/OracleDS"); */

        javax.sql.DataSource oracleconnectioncacheimpl = (javax.sql.DataSource)initialcontext.lookup("jdbc/OracleDS");
        connection = oracleconnectioncacheimpl.getConnection();

        pstmt_insert = connection.prepareStatement( SQL_PH_ROUTE_INSERT ) ;
        for (int i=0;i<arrList.size() ;i++ )
            {
            String[] record=(String[])arrList.get(i);
            pstmt_insert.setString(1,record[0]);
            pstmt_insert.setString(2,record[1]);
            pstmt_insert.setString(3,record[2]);
            pstmt_insert.setString(4,record[3]);
            pstmt_insert.setString(5,record[4]);
            pstmt_insert.setString(6,login_by_id);
            pstmt_insert.setString(7,login_at_ws_no);
            pstmt_insert.setString(8,login_facility_id);
            pstmt_insert.setString(9,login_by_id);
            pstmt_insert.setString(10,login_at_ws_no);
            pstmt_insert.setString(11,login_facility_id);
            pstmt_insert.executeUpdate();
            throw new EJBException("UserDefined Error thrown") ;
            }//for end

/*        int[] result= pstmt_insert.executeBatch();

        for (int i=0;i<result.length ;i++ )
        {
            if(result[i]<0  && result[i] != -2 ){
                    pstmt_insert.cancel();
                    throw new EJBException("Insert Failed");
                }
        }
*/
        map.put( "result", new Boolean( true ) ) ;
        messages.append( "RECORD_INSERTED" ) ;
        }//try end

        catch( Exception e )
        {
            try{

                throw new EJBException( e.getMessage() ) ;
            }
            catch ( Exception ee ) {
                messages.append( ee.getMessage() ) ;
            }
            messages.append( e.getMessage() ) ;
            e.printStackTrace() ;
        }
        finally
        {
            try
            {
            closeStatement( pstmt_insert ) ;
            closeConnection( connection,(Properties)tabData.get( "properties" ) );
            }
            catch ( Exception fe )
            {
            System.err.println( fe.getMessage() ) ;
            fe.printStackTrace() ;
            }
        }


        map.put( "msgid", messages.toString() ) ;
        return map ;

}//insert method end



	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap modify( HashMap tabData, HashMap sqlMap )  {

        StringBuffer debug =new StringBuffer();
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put( "flag", "0" ) ;
        StringBuffer messages = new StringBuffer() ;
        Connection connection = null ;
        PreparedStatement pstmt_update = null ;

        try {
            connection = getConnection( (Properties)tabData.get( "properties" ) ) ;

            debug.append("After Getting the connection (EJB)"+ (Properties)tabData.get( "properties" ));

            pstmt_update = connection.prepareStatement( (String) sqlMap.get( "SQL_PH_ROUTE_UPDATE" ) ) ;

        //  pstmt_update.setString(1, (String)tabData.get( "route_code" ));
            pstmt_update.setString(1, (String)tabData.get( "route_desc" ));
            pstmt_update.setString(2, (String)tabData.get( "eff_status" ));
            pstmt_update.setString(3, (String)tabData.get( "ext_route_code" ));
            pstmt_update.setString(4, (String)tabData.get( "ext_route_desc" ));
            pstmt_update.setString(5, (String)tabData.get( "login_by_id" ));
            pstmt_update.setString(6, (String)tabData.get( "login_at_ws_no" ));
            pstmt_update.setString(7, (String)tabData.get( "login_facility_id" ));
            pstmt_update.setString(8, (String)tabData.get( "route_code" ));

            debug.append("Before Execute (EJB)"+(String)tabData.get( "route_desc" ));
            debug.append(tabData.get( "route_desc" ));
            debug.append(tabData.get( "eff_status" ));

            int result = pstmt_update.executeUpdate() ;

            debug.append("After Execute(EJB)"+result);

            if ( result < 1 ) {

                    map.put( "flag", debug.toString() ) ;
                    throw new EJBException("Update Failed");
            }
            else {

                map.put( "result", new Boolean( true ) ) ;
                messages.append( "RECORD_MODIFIED" ) ;
                map.put( "flag", debug.toString() ) ;

            }
        }
        catch( Exception e ) {
            try {

                throw new EJBException( this + " : " + e.getMessage() ) ;
            }
            catch ( Exception ee ) {
                map.put( "msgid", ee.getMessage() ) ;
            }
            map.put( "msgid", e.getMessage() ) ;
            System.err.println(debug );
            e.printStackTrace() ;
        }
        finally {
            try {
                closeStatement( pstmt_update ) ;
                closeConnection( connection, (Properties)tabData.get( "properties" ) );
            }
            catch ( Exception fe ) {
                System.err.println( fe.getMessage() ) ;
                fe.printStackTrace() ;
            }
        }
        map.put( "msgid", messages.toString() ) ;
        return map ;
    }


	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


    public HashMap delete( HashMap tabData, HashMap sqlMap )  {

        StringBuffer messages = new StringBuffer() ;
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put( "flag", "0" ) ;
        map.put( "msgid", messages.toString() ) ;
        return map ;
    }
}
