/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCommon.SingleTableHandler; 

import java.rmi.*;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import javax.naming.InitialContext;
import webbeans.eCommon.*;
import eCommon.CommonEJBAdapter.*;


/**
*
* @ejb.bean
*	name="SingleTableHandler"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SingleTableHandler"
*	local-jndi-name="SingleTableHandler"
*	impl-class-name="eCommon.SingleTableHandler.SingleTableHandlerManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCommon.SingleTableHandler.SingleTableHandlerLocal"
*	remote-class="eCommon.SingleTableHandler.SingleTableHandlerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCommon.SingleTableHandler.SingleTableHandlerLocalHome"
*	remote-class="eCommon.SingleTableHandler.SingleTableHandlerHome"
*	generate= "local,remote"
*
*
*/

public class SingleTableHandlerManager extends CommonEJBSessionAdapter
{
    Connection connection;
    PreparedStatement stmt;
	ResultSet rset; //Added for checkstyle
    SessionContext ctx;
    /*public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS";
    public final String RECORD_INSERTED = "RECORD_INSERTED";
    public final String RECORD_MODIFIED = "RECORD_MODIFIED";
    public final String RECORD_DELETED = "RECORD_DELETED";*/

    StringBuffer sb;
	String invalidcode="";
    ArrayList invalideCodeList = null ;

    ArrayList tempInvalidDataList = null ;
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData,HashMap sqlMap )
    {
        HashMap retHash = new HashMap();
        sb = new StringBuffer("");
        boolean continue_execution = false;
        try
        {
            connection = getConnection((Properties)tabData.get("properties")) ;

            String selectSQL = (String)sqlMap.get("SelectSQL") ;
            // sb.append("<br>insertSQL:"+selectSQL) ;
            if(selectSQL == null)   selectSQL = "" ;

            String insertSQL = (String)sqlMap.get("InsertSQL") ;
            // sb.append("<br>insertSQL:"+insertSQL) ;
            if(insertSQL == null)   insertSQL = "" ;

            if( !selectSQL.equals("") )
            {
                try
                {
                    stmt = connection.prepareStatement( selectSQL );
                    ArrayList dataObject = (ArrayList) tabData.get("WhereData");
                    stmt = setData(stmt, dataObject, "validate" );
                    ResultSet resultset = stmt.executeQuery();
                    if(resultset.next())
                    {
                        if( resultset.getInt(1)>0 )
                        {
                            continue_execution = false;
                            sb.append( "CODE_ALREADY_EXISTS" );
                            closeResultSet( resultset ) ;
                            closeStatement( stmt ) ;
                        }else{  //condition added by p.sudhakaran
                        continue_execution = true;
                        }  //end
                     }
                    else
                        continue_execution = true;
                }
                catch(Exception e)
                {
                    sb.append( "Error while validating:"+e.toString() ) ;
		            e.printStackTrace();
                    continue_execution = false ;
                }
            }
            else
                continue_execution = true;

            if(continue_execution)
            {
                stmt = connection.prepareStatement( insertSQL );
                ArrayList dataObject = (ArrayList) tabData.get("InsertData");

                stmt = setData(stmt, dataObject, "insert" );
                int j1 = stmt.executeUpdate();
                if(j1 != 0)
                {
                    connection.commit();
                    continue_execution = true;
                    sb.append("RECORD_INSERTED" );
                }
                    closeStatement( stmt ) ;
					dataObject.clear();
            }
        }
        catch(Exception exception)
        {
            try
            {
            connection.rollback();
            continue_execution = false;
            exception.printStackTrace();
            sb.append(exception.toString() + "<br>");
//            throw new EJBException(exception.toString()) ;
            }
            catch(Exception e ){
				System.out.println(e.toString());
				e.printStackTrace();
			}
        }
        finally
        {
            try
            {
                 if(connection != null)
                    closeConnection(connection, (Properties)tabData.get("properties")) ;
            }
            catch(Exception exception3) { 
				System.out.println(exception3.toString());
				exception3.printStackTrace();
			}
        }
        retHash.put("result", new Boolean(continue_execution));
        retHash.put("msgid", sb.toString());
        return retHash;
    }
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap modify( HashMap tabData,HashMap sqlMap )
       {
        HashMap retHash = new HashMap();
        sb = new StringBuffer("");
        boolean continue_execution = false;

        try
        {
            String modifySQL = (String)sqlMap.get("ModifySQL") ;
            if(modifySQL == null)   modifySQL = "" ;
//System.out.println("modifySQL "+modifySQL);
            connection =getConnection((Properties)tabData.get("properties")) ;
            stmt = connection.prepareStatement( modifySQL );
            //int k;

            ArrayList dataObject = (ArrayList) tabData.get("ModifyData") ;
//System.out.println("dataObject "+dataObject);
            stmt = setData(stmt, dataObject, "modify" );
            int l = stmt.executeUpdate();
//System.out.println("l "+l);
            if(l != 0)
            {
                connection.commit();
                continue_execution = true;
                sb.append( "RECORD_MODIFIED");
            }
            closeStatement( stmt ) ;
			dataObject.clear();
        }
        catch(Exception exception)
        {
            try
            {
                connection.rollback();
                exception.printStackTrace();
				//System.out.println("exception modify"+exception.toString());
                sb.append(exception.toString() + "<br>");
//            throw new EJBException(exception.toString()) ;
            }
            catch(Exception e) {
                e.printStackTrace();
				System.out.println("e modify"+e.toString());

			}
        }
        finally
        {
            try
            {
                if(connection != null)
                    closeConnection(connection, (Properties)tabData.get("properties")) ;
            }
            catch(Exception exception3) { 
			    exception3.printStackTrace();
				System.out.println("exception3 modify"+exception3.toString());

			}
        }
        retHash.put("result", new Boolean(continue_execution));
        retHash.put("msgid", sb.toString());
        return retHash;
    }

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap singleBatchHandler( HashMap tabData,HashMap sqlMap)
    {
        HashMap retHash = new HashMap();
        sb = new StringBuffer("");
        invalideCodeList = new ArrayList() ;
        boolean continue_execution = false;
        //boolean inserted =false;
        String mode = "" ;
        String sqlStmt = "" ;
        invalidcode = "" ;

        try
        {
            ArrayList dataObject = null ;
            ArrayList whereObject = null ;
            String returnMessage = "" ;
            String selectSQL = "" ;

            if(sqlMap.get( "InsertSQL" ) != null)
            {
                sqlStmt = (String)sqlMap.get( "InsertSQL" ) ;
                returnMessage= "RECORD_INSERTED" ;
                mode = "insert" ;
                dataObject = (ArrayList) tabData.get("InsertData") ;

                selectSQL = (String)sqlMap.get( "SelectSQL" ) ;
                if( selectSQL == null ) selectSQL = "" ;

                if(tabData.get( "WhereData" ) != null)
                    whereObject = (ArrayList) tabData.get( "WhereData" );
            }
            else if(sqlMap.get( "ModifySQL" ) != null)
            {
                sqlStmt = (String)sqlMap.get("ModifySQL") ;
                dataObject = (ArrayList) tabData.get("ModifyData") ;
                returnMessage= "RECORD_MODIFIED" ;
                mode = "modify" ;
            }
            else if(sqlMap.get( "DeleteSQL" ) != null)
            {
                sqlStmt = (String)sqlMap.get("DeleteSQL") ;
                dataObject = (ArrayList) tabData.get("DeleteData") ;
                returnMessage= "RECORD_DELETED" ;
                mode = "delete" ;
            }

            connection =getConnection((Properties)tabData.get("properties")) ;

            if(whereObject == null) whereObject = new ArrayList() ;

            if(!isDuplicated(selectSQL, whereObject ))
            {
                stmt = connection.prepareStatement(sqlStmt) ;
                for( int i=0; i<dataObject.size(); i++ )
                {
                    stmt = setData(stmt, (ArrayList)dataObject.get(i), mode );
                    stmt.addBatch() ;
                }
                int[] countExecute = stmt.executeBatch() ;

                if( !recordsTransacted( countExecute ) )
                {
                   connection.rollback();
                    continue_execution = false;
//                    throw new EJBException() ;
                }
                else
                {
                    continue_execution = true;
                    connection.commit();
                }
            }
            else
            {
                returnMessage = "CODE_ALREADY_EXISTS" ;
            }
            sb.append(returnMessage) ;
        }

        catch(Exception exception)
        {
            try
            {
                connection.rollback();
				//System.out.println("exception singleBatchHandler"+exception.toString());
                exception.printStackTrace();
                sb.append(exception + "<br>");
    //            throw new EJBException("Error here :"+sb.toString()) ;
            }
            catch( Exception e ) {}
        }
        finally
        {
            try
            {
                if(connection != null)
                    closeConnection(connection, (Properties)tabData.get("properties")) ;
                if(stmt!=null) closeStatement( stmt ) ;
            }
            catch(Exception exception3) { }
        }


        retHash.put( "result", new Boolean(continue_execution) );
        retHash.put( "msgid", sb.toString() );
        //retHash.put( "invalidCode", invalidcode );
        if(invalideCodeList.size() >0 )
            retHash.put( "invalidCode", invalideCodeList );

        return retHash ;
    }
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap delete(  HashMap tabData,HashMap sqlMap)
    {
        HashMap retHash = new HashMap();
        boolean continue_execution = false;
        sb = new StringBuffer("");
        try
        {
            String deleteSQL = (String)sqlMap.get("DeleteSQL") ;
            if(deleteSQL == null)   deleteSQL = "" ;

            connection = getConnection((Properties)tabData.get("properties")) ;
            stmt = connection.prepareStatement( deleteSQL );
            ArrayList dataObject = (ArrayList) tabData.get("DeleteData") ;
            stmt = setData(stmt, dataObject, "delete" );
            int k = stmt.executeUpdate();
            if(k != 0)
            {
                connection.commit();
                continue_execution = true;
                sb.append( "RECORD_DELETED" );

            }
            closeStatement( stmt ) ;
			dataObject.clear();
        }
        catch(Exception exception)
        {
            try
            {
                connection.rollback();
                sb.append(exception.getMessage() + "<br>");
                exception.printStackTrace();
//                throw new EJBException(exception.toString()) ;
            }
            catch(Exception e) {}
        }
        finally
        {
            try
            {
                if(connection != null)
                    closeConnection(connection, (Properties)tabData.get("properties")) ;
            }
            catch(Exception exception3) { }
        }
        retHash.put("result", new Boolean(continue_execution));
        retHash.put("msgid", sb.toString());
        return retHash;
    }

    private PreparedStatement setData(PreparedStatement preparedstatement, ArrayList dataObjects, String mode)
    {
        try
        {
            invalidcode="";
			//System.out.println("mode "+mode);
            for(int i = 0; i <  dataObjects.size(); i++) {
                Object dataObject = dataObjects.get(i) ;
//System.out.println("dataObject "+i+" "+dataObject);
                if(mode!=null && mode.equals("validate")) {
                    /*
                    if(i==0)
                        invalidcode=dataObject.toString();
                    else
                    {
                        invalidcode=invalidcode+" and " +dataObject.toString();
                        tempInvalidDataList.add(dataObject.toString()) ;
                    }
                    */

                    if(tempInvalidDataList != null)
                    tempInvalidDataList.add(dataObject.toString()) ;
                }
                else {
                    invalidcode="";
                }

                if(dataObject instanceof java.sql.Date) {
                    java.sql.Date date = (java.sql.Date)dataObject;
                    preparedstatement.setDate(i + 1, date);
                }
                if(dataObject instanceof Timestamp) {
                    Timestamp timestamp = (Timestamp)dataObject;
                    preparedstatement.setTimestamp(i + 1, timestamp);
                }
                if(dataObject instanceof String) {
                    if(((String)dataObject).equalsIgnoreCase("null"))
                         preparedstatement.setString(i + 1, null);
                    else
                       preparedstatement.setString(i + 1, (String)dataObject);
                }
                if(dataObject instanceof Integer){
                    preparedstatement.setInt(i + 1, ((Integer)dataObject).intValue());
                }

                if(dataObject instanceof Long)
                    preparedstatement.setLong(i + 1, ((Long)dataObject).longValue());

                if(dataObject instanceof Double)
                    preparedstatement.setDouble(i + 1, ((Double)dataObject).doubleValue());

                if(dataObject instanceof Float)
                    preparedstatement.setFloat(i + 1, ((Float)dataObject).floatValue());
            }

        }
        catch(Exception exception)
        {
            sb.append(exception.toString()) ;
            exception.printStackTrace();
        }
        return preparedstatement;
    }

    private boolean recordsTransacted( int[]executeCount )
    {
        boolean returnVal = true;
        for( int i=0; i<executeCount.length; i++ )
        {
            if( executeCount[i] == -3 )
            {
               returnVal = false;
               break;
            }
        }

        return returnVal ;
    }

    private boolean isDuplicated(String selectSQL, ArrayList whereObject)
    {
        boolean retVal = false ;
        try
        {
            if(whereObject != null)
            {
                if( whereObject.size()>0)
                    stmt = connection.prepareStatement(selectSQL) ;
                for(int i=0; i<whereObject.size(); i++)
                {
                    ArrayList dataObjectArray = (ArrayList)whereObject.get(i) ;
                    tempInvalidDataList = new ArrayList() ;
                    stmt = setData(stmt,dataObjectArray, "validate") ;
                    rset = stmt.executeQuery() ; //Modified for checkstyle
                    if( rset != null)
                        if( rset.next() )
                        {
                            if( rset.getInt(1)>0 )
                            {
                                retVal = true ;
                                invalideCodeList.add(tempInvalidDataList) ;
                            }
                            tempInvalidDataList = new ArrayList() ;
                        }

                    if(rset != null) rset.close() ;
                }
            }
        }
        catch(Exception e)
        {
                retVal = true;
                sb.append("Error in is Duplicated:"+e) ;
				System.out.println(e.toString());
				e.printStackTrace();
        }
        finally
        {
            try
            {
                if( stmt != null )  closeStatement( stmt ) ;
            }
            catch( Exception e ) {
				System.out.println(e.toString());
				e.printStackTrace();
			}
        }
        return retVal ;
    }
}
