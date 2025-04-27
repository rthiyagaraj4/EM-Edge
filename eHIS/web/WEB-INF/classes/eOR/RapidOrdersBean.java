/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;

import eOR.Common.*;
//import eOR.ORRapidOrder.* ;

import javax.servlet.http.*;

public class  RapidOrdersBean extends OrderEntryBean implements Serializable 
{
  private String encounter_id        		= null ;
  //eOR.Common.OrderEntryRecordBean  orderEntryRecordBean  = null;

  public RapidOrdersBean(){
  //try{
    //doCommon();
//  }catch(Exception e) {
  //}
 }

	public void initialize(){
 		encounter_id        		= "" ;
// 		super.initialize();
 } // End of initialize


//  **************  Set Methods ******************
   public void  setEncounterId(String  encounter_id) { this.encounter_id = checkForNull(encounter_id,""); }

 /*---------------------------------GET METHODS---------------------------------*/
  public String getEncounterId() { return this.encounter_id ; }
/*********************METHOD TO SET AT ONCE*************************/
// public void setAll( Hashtable recordSet ) {
/*ry
	{
	total_count			= (Integer.parseInt((String)recordSet.get("total_rows"))) ;
    	amend_total_count   = (Integer.parseInt((String)recordSet.get("amend_total_rows"))) ;
    	care_set_count     	= (Integer.parseInt((String)recordSet.get("care_set_count"))) ;

    	validated_status   	= (String)recordSet.get("validated_status");

    	setAllValues(total_count,amend_total_count,care_set_count,recordSet);
    	setMode((String)recordSet.get("mode")); // Set the Mode Common

    	this.request     	= (javax.servlet.http.HttpServletRequest)recordSet.get("HttpRequest") ;
    	this.response     	= (javax.servlet.http.HttpServletResponse)recordSet.get("HttpResponse") ;
  	}
  	catch(Exception e)
  	{
		System.err.println("Error when setting setAll"+e);
  	}
*/
// }//end of setALL

/*********************METHOD TO Insert*************************/
public HashMap insert(){
  //boolean result		= false;
  StringBuffer tmpBuff          = new StringBuffer();
  HashMap map			= new HashMap() ;

System.err.println("From Order Entry"+getPatientId());

//eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new patient set it, other wise get the patient id
//	orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
//	String key						= (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
 //  	java.util.HashMap previousValues= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
//String order_type_catalog 		= bean.getOrderTypeCatalog(previousValues,order_category);
//String order_catalog_code 		= bean.getOrderCatalogCode(previousValues,order_category);






//  java.util.Properties  properties   = getProperties();

/*System.err.println("properties"+properties);
System.err.println("login_by_id"+login_by_id);
System.err.println("login_at_ws_no"+login_at_ws_no);
System.err.println("login_facility_id"+login_facility_id);
*/
 /* String user_id            = properties.getProperty( "ecis_jdbc_user" ) ;
  String user_password      = properties.getProperty( "ecis_jdbc_password" ) ;
  String jdbc_dns           = properties.getProperty( "ecis_jdbc_dns" );
  String database_name      = jdbc_dns.substring(jdbc_dns.lastIndexOf(":")+1,jdbc_dns.length());
*/
  map.put( "result", new Boolean( false ) ) ;
  HashMap tabdata           = new HashMap() ;
  try{
        tabdata.put( "properties",  getProperties() ) ;
        tabdata.put( "login_by_id",login_by_id ) ;
        tabdata.put( "login_at_ws_no",login_at_ws_no ) ;
        tabdata.put( "login_facility_id",login_facility_id ) ;
      }catch(Exception e)
      {
        System.err.println("Error when Inserting (setting) in Bean"+e);
      }

//   HashMap sqlMap = new HashMap() ;
   //try{
//        sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_INSERT") );
    //}catch(Exception e){}

//    OROrderEntryHome home = null ;
//    OROrderEntryRemote remote = null ;
/*    try{
 		InitialContext context = new InitialContext() ;
	        Object object = context.lookup( OrRepository.getOrKeyValue("OR_ORDER_ENTRY_JNDI") ) ;
	        home  = (OROrderEntryHome) PortableRemoteObject.narrow( object, OROrderEntryHome.class ) ;
	        remote  = home.create() ;
	        map    = remote.insert( tabdata, sqlMap ) ;

			//OROrderEntryTest remote = new OROrderEntryTest();
			//map = remote.insert(tabdata, sqlMap ) ;
	        String str = ((String)map.get("traceVal"));
//System.err.println("After EJB Called"+str);
	       //  tmpBuff.append("BEAN FROM EJB"+str);
	        if((((String)map.get( "message")).trim()).equalsIgnoreCase("RECORD_INSERTED"))
	        {
	       		map.put("message",(String)map.get( "message"));
        	}
 
		
		
		// Remove this if u r calling the function
		//ORRapidOrdersManager remote = new ORRapidOrdersManager();
       } catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
	        map.put( "message", e.getMessage() ) ;
	        e.printStackTrace() ;
      } finally {
      try {
		  System.err.println("In try") ;
//			if( remote != null ) remote.remove() ;
        } catch( Exception ee ) {
          System.err.println( ee.getMessage() ) ;
          map.put( "message", ee.getMessage() ) ;
        }
      }
*/
	tabdata.clear();
    map.put("traceVal", (String)tmpBuff.toString());
    return map ;
 }//end of insert
 /********************Validate Method ****************************/
 public HashMap validate() throws Exception {
  HashMap map 		= new HashMap() ;
  boolean status 	= true;
  map.put("result", new Boolean( status ) ) ;
  return map ;
 }//end of validate
// *********************************** Till Here ********************************
}//end of class
