/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.ehis.persist;

import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;

import webbeans.eCommon.*;

public class PersistenceBean implements Serializable {
    
    
    /*		
     *      spool SM_SESSION_BEANS.log                                                                                   
     *  	                                                                                                                                    
     *		CREATE TABLE SM_SESSION_BEANS                                                                        
     *		 (                                                                                                                                  
     *		 SESSION_ID		VARCHAR2(256)	NOT NULL,                                                   
     *		 USER_ID		VARCHAR2(100)	NOT NULL,                                                           
     *		 BEAN_CONTENT		BLOB,                                                                          
     *		 WS_NO			VARCHAR(100) NOT NULL,                                                           
     *		 SESSION_CREATION_TIME	DATE NOT NULL                                                           
     *		);                                                                                                                                  
     *		                                                                                                                                    
     *		CREATE PUBLIC SYNONYM SM_SESSION_BEANS FOR SM_SESSION_BEANS;         
     *		                                                                                                                                    
     *		GRANT INSERT,UPDATE,DELETE,SELECT ON SM_SESSION_BEANS TO MEDUSERS;
     *		                                                                                                                                    
     *		CREATE INDEX  SM_SESSION_BEANS_I1 ON  SM_SESSION_BEANS                          
     *		(SESSION_ID,USER_ID,WS_NO,SESSION_CREATION_TIME);                                       
     *		                                                                                                                                    
     *		CREATE INDEX  SM_SESSION_BEANS_I2 ON  SM_SESSION_BEANS                          
     *		(SESSION_CREATION_TIME);                                                                                       
     *		                                                                                                                                    
     *		spool off;  
     *
     *      ed SM_SESSION_BEANS.log                                                                                                           
     *		                                                                                                                                    
     */	
    
    HashMap map = new HashMap();
    
    public PersistenceBean() {}
    
    public static PersistenceBean getPersistenceBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
        //First check DB if there is a bean
        Connection perBeanConn  = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PersistenceBean persistenceBean = null;
        try{
            perBeanConn = ConnectionManager.getConnection(jdbc_props);
            pstmt = perBeanConn.prepareStatement("Select BEAN_CONTENT from SM_SESSION_BEANS where SESSION_ID = ? and USER_ID = ? and WS_NO = ? and SESSION_CREATION_TIME = to_date(?,'dd/mm/yyyy hh24:mi:ss' )");
            pstmt.setString(1,sessionid);
            pstmt.setString(2,userid);
            pstmt.setString(3,ws_no);
            pstmt.setString(4,new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(session_creation_date));
            
            rs = pstmt.executeQuery();
            if (rs != null && rs.next()){
                //Bean exists in database
                ObjectInputStream ois = new ObjectInputStream(rs.getBlob("BEAN_CONTENT").getBinaryStream());
                persistenceBean = (PersistenceBean)ois.readObject();
                ois.close();
            }else{
                persistenceBean = new PersistenceBean();
                persistenceBean.persist(sessionid,userid,ws_no,session_creation_date,jdbc_props);
            }
            if (rs != null)rs.close();
            if (pstmt != null)pstmt.close();
            
        }catch(Exception exc){			
            exc.printStackTrace();
        }finally{
            ConnectionManager.returnConnection(perBeanConn,jdbc_props)	;
        }
        return persistenceBean;
    }
    
    public void persist(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
        
        //First check DB if there is a bean
        Connection perBeanConn  = null;
        PreparedStatement pstmt = null,pstmtSelect = null;
        ResultSet rs = null;
        
        boolean bean_exists = false;
        
        try{
            perBeanConn = ConnectionManager.getConnection(jdbc_props);
            perBeanConn.setAutoCommit(false);
            
            pstmtSelect = perBeanConn.prepareStatement("Select 1 from SM_SESSION_BEANS where SESSION_ID =? and USER_ID = ? and WS_NO = ? and SESSION_CREATION_TIME = to_date(?,'dd/mm/yyyy hh24:mi:ss' )");
            
            pstmtSelect.setString(1,sessionid);
            pstmtSelect.setString(2,userid);
            pstmtSelect.setString(3,ws_no);
            pstmtSelect.setString(4,new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(session_creation_date));
            
            rs = pstmtSelect.executeQuery();
            
            if ((rs != null) &&(rs.next()))bean_exists = true;
            
            if(rs != null)rs.close();
            if(pstmtSelect != null)pstmtSelect.close();
            
            if (bean_exists){
                  
                pstmt = perBeanConn.prepareStatement("Select BEAN_CONTENT from SM_SESSION_BEANS where SESSION_ID = ? and USER_ID =? and WS_NO =? and SESSION_CREATION_TIME = to_date(?,'dd/mm/yyyy hh24:mi:ss' ) for update");
                pstmt.setString(1,sessionid);
                pstmt.setString(2,userid);
                pstmt.setString(3,ws_no);
                pstmt.setString(4,new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(session_creation_date));
                rs = pstmt.executeQuery();
                
                if ((rs != null) &&(rs.next())){
                    ObjectOutputStream oos = new ObjectOutputStream(((oracle.sql.BLOB)rs.getBlob("BEAN_CONTENT")).getBinaryOutputStream());
                    oos.writeObject(this);
                    oos.flush();
                    oos.close();
                }
                if(rs != null)rs.close();
                if(pstmt != null)pstmt.close();
                
                perBeanConn.commit();
                
            }else{
                pstmt = perBeanConn.prepareStatement("Insert into SM_SESSION_BEANS (SESSION_ID,USER_ID,BEAN_CONTENT,WS_NO,SESSION_CREATION_TIME) values (?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss' ))");
                pstmt.setString(1,sessionid);
                pstmt.setString(2,userid);
                
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(this);
                oos.flush();
                byte [] byteArr = baos.toByteArray();
                
                pstmt.setBinaryStream(3,new ByteArrayInputStream(byteArr),byteArr.length);
                
                pstmt.setString(4,ws_no);
                pstmt.setString(5,new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(session_creation_date));
                
                int k = pstmt.executeUpdate();
                
                if (pstmt != null)pstmt.close();
                
                perBeanConn.commit();
                
                baos.close();
                oos.close();
            }
        }catch(Exception exc){
			try{
			perBeanConn.rollback();
			} catch (Exception re) {re.printStackTrace();}

            exc.printStackTrace();
        }finally{
            ConnectionManager.returnConnection(perBeanConn,jdbc_props)	;
        }
    }
    
    public void cleanup(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
        Connection perBeanConn  = null;
        PreparedStatement pstmt = null;
        try{
            perBeanConn = ConnectionManager.getConnection(jdbc_props);
            perBeanConn.setAutoCommit(false);
            
            pstmt = perBeanConn.prepareStatement("delete from SM_SESSION_BEANS where (SYSDATE - SESSION_CREATION_TIME ) > 1 ");
            int k1 = pstmt.executeUpdate();
            if (pstmt != null)pstmt.close();
            
            pstmt = perBeanConn.prepareStatement("delete from SM_SESSION_BEANS where session_id = ? and user_id = ? and ws_no =? and session_creation_time = to_date(?,'dd/mm/yyyy hh24:mi:ss' )");
            pstmt.setString(1,sessionid);
            pstmt.setString(2,userid);
            pstmt.setString(3,ws_no);
            pstmt.setString(4,new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(session_creation_date));
            
            int k2 = pstmt.executeUpdate();
            if (pstmt != null)pstmt.close();
            
            perBeanConn.commit();
        }catch(Exception exc){
			try{
			perBeanConn.rollback();
			} catch (Exception re) {re.printStackTrace();}

            exc.printStackTrace();
        }finally{
            ConnectionManager.returnConnection(perBeanConn,jdbc_props)	;
        }       
    }
    
    public Object getObject(String id,String className,String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
        Object tempObj = null;        
        try{
			tempObj = map.get(id);
            if (null == tempObj){
				 Class objClass = Class.forName(className);
                 tempObj = objClass.newInstance();
                 map.put(id,tempObj);
                 persist(sessionid,userid,ws_no,session_creation_date,jdbc_props);
            }
        }catch(Exception exc){
               exc.printStackTrace();
        }
        return tempObj;
    }
    
    public void putObject(String id,Object obj,String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){        
        try{
            map.put(id,obj);
            persist(sessionid,userid,ws_no,session_creation_date,jdbc_props);
        }catch(Exception exc){
               exc.printStackTrace();
        }       
    }
    
}
