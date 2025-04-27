/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import javax.servlet.http.*;

public class AEUtils
{
	static Connection conn=null;
   
public AEUtils(){}

/*************getdata() more generalized*******************/

public ArrayList getData(String sql,String[] whereClause,HttpServletRequest request) throws Exception
{
   ArrayList arrL_of_HashMap                            = new ArrayList() ;
   PreparedStatement pstmt								 = null ;
   ResultSet resultSet                                          = null ;
   ResultSetMetaData resultSetMetaData			= null;

 try {
   conn = ConnectionManager.getConnection(request);
   pstmt = conn.prepareStatement(sql) ;
   HashMap hmRecord  =null;              
        if (whereClause!=null)
                for (int index=0; index<whereClause.length ;index++ )
                        pstmt.setString( index+1, whereClause[index]);

    resultSet = pstmt.executeQuery() ;
        if ( resultSet != null )
         {
                        resultSetMetaData   =   resultSet.getMetaData();
                           
                        while ( resultSet.next() )
                              {
                                
                                   hmRecord   =  new HashMap();  
                                for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
                                {
                                        String column_Val=resultSet.getString(resultSetMetaData.getColumnName(i));
                                        if(column_Val==null) column_Val="";     
                                        hmRecord.put(resultSetMetaData.getColumnName(i),column_Val);
                                
                                }       
                                        arrL_of_HashMap.add(hmRecord) ;
                                        
                              }
        }
	hmRecord.clear();
	if(resultSet!=null)  resultSet.close();
	if(pstmt!=null) pstmt.close();
    }catch ( Exception e )
        {
            e.printStackTrace() ;
        }
        finally
        {
		   if(conn != null)  ConnectionManager.returnConnection(conn,request);
        }
        return arrL_of_HashMap;
   }
} 
