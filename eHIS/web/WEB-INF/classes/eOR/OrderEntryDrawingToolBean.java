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
import oracle.sql.*;	// For CLOB
//import javax.naming.* ;
import webbeans.eCommon.*;
import eCommon.Common.*;	// for common repository

import eOR.Common.*;
//import eOR.OROrderEntry.* ;

public class  OrderEntryDrawingToolBean extends OrAdapter implements Serializable
{
  //private String frame_color          		= null ;
   private HashMap	   hashMap					= new HashMap();
   private String	   image_content;

   public void setImage(String image_content){
	   this.image_content = image_content;
   }
   
 public OrderEntryDrawingToolBean(){
 // try{
    //doCommon();
  //}catch(Exception e) {}
 }

  public void initialize(){
 		//image_content.setLength(0);
		image_content	= "";
		hashMap	= new HashMap();
 		super.initialize();

 } // End of initialize

 public void clear(){
 	 image_content = null;
  	 hashMap	= null;
  	 super.clear();
  }
 /*********************** Till Here *******************************/


 private void doCommon() throws Exception {
 }

 public void loadData() throws Exception {
 }


//  **************  Set Methods ******************
  

     
 /*---------------------------------GET METHODS---------------------------------*/
   
   	// Get the Image_ref for the Drawing tools
	public ArrayList getImageRef (String order_catalog_code, String image_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] record				= null;
		ArrayList ImageRef			= new ArrayList();
		try{
				connection			= getConnection() ;
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_POPULATE_IMAGE") ) ;
				pstmt.setString(1,language_id);
				pstmt.setString(2, checkForNull( order_catalog_code,""));
				pstmt.setString(3, checkForNull( image_id,""));
				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )   // Only One Record
				{
					while(resultSet.next())
					{
						record	= new String[2];
						record[0] = checkForNull( resultSet.getString( "image_ref" ), "" );
						record[1] = checkForNull( resultSet.getString( "image_ref_desc" ), "" );
						ImageRef.add(record) ;
					}
				}
		}catch ( Exception e )	{
			System.err.println( "Error loading values from data base getImageRef"+e ) ;
			e.printStackTrace() ;
			return null;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return ImageRef;
	}	 // End of the getImageRef


	// In the View Order, get the clob data and set it for the image
	public StringBuffer getImageClob (String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		StringBuffer sbImage		= new StringBuffer();
 		try{
				connection			= getConnection() ;
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_VIEW_ORDER_IMAGE_CLOB") ) ;
 				pstmt.setString(1, checkForNull( order_id,""));
				pstmt.setString(2, "1"); //order-line_num
				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )   // Only One Record
				{
					while(resultSet.next())
					{
						Clob rslt_data = resultSet.getClob("image_obj");
						if(rslt_data!=null && rslt_data.length() > 0)
							sbImage.append(rslt_data.getSubString(1,( (int)rslt_data.length() )));
					}
				}
		}catch ( Exception e )	{
			System.err.println( "Error loading values from data base getImageClob"+e ) ;
			e.printStackTrace() ;
			return null;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return sbImage;
	}	 // End of the getImageClob

	// In the View Order, get the clob data and set it for the image
	// Also in Existing Order, when called on click of the Fully Resulted.
	public StringBuffer getResultImageClob (String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		StringBuffer sbImage		= new StringBuffer();
 		try{
				connection			= getConnection() ;
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_IMAGE_CLOB") ) ;
 				pstmt.setString(1, checkForNull( order_id,""));
 				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )   // Only One Record
				{
					while(resultSet.next())
					{
						Clob rslt_data = resultSet.getClob("result_data");
						if(rslt_data!=null && rslt_data.length() > 0)
							sbImage.append(rslt_data.getSubString(1,( (int)rslt_data.length() )));
					}
				}
		}catch ( Exception e )	{
			System.err.println( "Error loading values from data base getResultImageClob"+e ) ;
			e.printStackTrace() ;
			return null;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return sbImage;
	}	 // End of the getResultImageClob

	   
    /*********************METHOD TO SET AT ONCE*************************/
 public void setAll( Hashtable recordSet ) {
	try
	{
 		// Used for Order Entry
		hashMap.put("patient_id", checkForNull((String)recordSet.get("patient_id"),""));
		hashMap.put("encounter_id", checkForNull((String)recordSet.get("encounter_id"),""));
	    hashMap.put("patient_class", checkForNull((String)recordSet.get("patient_class"),""));
		hashMap.put("location_type", checkForNull((String)recordSet.get("location_type"),""));
		hashMap.put("location_code", checkForNull((String)recordSet.get("location_code"),""));
		hashMap.put("episode_id", checkForNull((String)recordSet.get("episode_id"),""));
		hashMap.put("episode_visit_num", checkForNull((String)recordSet.get("episode_visit_num"),""));
		hashMap.put("practitioner_id", checkForNull((String)recordSet.get("practitioner_id"),""));
		hashMap.put("order_catalog_code", checkForNull((String)recordSet.get("order_catalog_code"),""));

		// used for Result entry
		hashMap.put("order_id", checkForNull((String)recordSet.get("order_id"),""));
		
		//hashMap.put("image_content",  checkForNull((String)recordSet.get("image_content"),""));
 		hashMap.put("image_content",  image_content);
    	 
    	setMode((String)recordSet.get("mode")); // Set the Mode Common
  	}
  	catch(Exception e)
  	{
		System.err.println("Error when setting setAll"+e);
  	}
 }//end of setALL

 public HashMap insert(){
	//  boolean result					= false;
	  HashMap map						= new HashMap() ;

	//  java.util.Properties  properties   = getProperties();
	  map.put( "result", new Boolean( false ) ) ;


	   if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "COMMON")) ;
		
				}







	  HashMap tabData           = new HashMap() ;
    	  try{
  
			//tabData.put( "mapUniqueId",(HashMap)generate_hash.get("mapUniqueId") ) ;
 
				tabData.put( "properties",  getProperties() ) ;
				tabData.put( "login_by_id",login_by_id ) ;
				tabData.put( "login_at_ws_no",login_at_ws_no ) ;
				tabData.put( "login_facility_id",login_facility_id ) ;
				tabData.put( "hashMap",hashMap ) ;
				 
				
				HashMap sqlMap = new HashMap() ;
				try{
					  sqlMap.put( "SQL_OR_ORDER_ENTRY_INSERT_ORDER_IMAGE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_INSERT_ORDER_IMAGE") );
					  sqlMap.put( "SQL_OR_RESULT_REPORTING_INSERT_DETAIL", OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_INSERT_DETAIL") );
					  sqlMap.put( "SQL_OR_RESULT_REPORTING_INSERT_HEADER", OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_INSERT_HEADER") );
  					  sqlMap.put( "SQL_OR_RESULT_REPORTING_UPDATE_CLOB", OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_UPDATE_CLOB") );
   					  sqlMap.put( "SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION") );
   					  sqlMap.put( "SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION_CLOB", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION_CLOB") );
				  }catch(Exception e){
					e.printStackTrace() ;
				  }
				  return getResult(tabData, sqlMap) ;
		}	 catch(Exception e) {
					System.err.println( "Error Calling EJB : "+e ) ;
					map.put( "message", e.getMessage() ) ;
					e.printStackTrace() ;
			  } 
			  //finally {
				 // try {
				//	if( remote != null ) remote.remove() ;
				//} catch( Exception ee ) {
				//  System.err.println( ee.getMessage() ) ;
				//  map.put( "message", ee.getMessage() ) ;
				//}
			  //}
	 return map ;
 }//end of insert

 private  HashMap getResult(HashMap tabData , HashMap sqlMap ){
		HashMap map  = new HashMap() ;
		 
		try
		{
			/********************LOOK UP*************************/
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
			home		 = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote		 = home.create() ;
 

			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) {
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
				map = remote.insert(tabData, sqlMap ) ;
			}else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				 map = remote.modify(tabData, sqlMap ) ;
			}
			*/
  			// For Order Entry
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) )
				map		 = insertImage(tabData, sqlMap);
			else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ) 	// For Result Entry
				map		 = update(tabData, sqlMap);

 			boolean result = ((Boolean) map.get("result")).booleanValue() ;
			if( result ) 
			{
				clear();   // Method to clear the bean_values		
			}
			//String message = (String)map.get("msgid");
			//map.put("message",message);

			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "COMMON")) ;
		
				}




		  return map;

	  }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	  }

 }//End of Method

// For Demo purpose done, if it is for the client, this method has to be put it in the ejb 
// ejb has to be created and used.
// public HashMap insertImage( HashMap tabData, HashMap sqlMap ) throws RemoteException {
   public HashMap insertImage( HashMap tabData, HashMap sqlMap ) throws Exception{

//System.out.println("tabData"+tabData);
//System.out.println("sqlMap"+sqlMap);
		Connection connection 			= null ; 
		HashMap map 					= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", new Boolean( false ) ) ;
		StringBuffer error_messages 	= new StringBuffer() ; 			 
		StringBuffer messages		 	= new StringBuffer() ; 	

		final String SQL_OR_ORDER_ENTRY_INSERT_ORDER_IMAGE 					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_INSERT_ORDER_IMAGE");
		final String SQL_OR_RESULT_REPORTING_INSERT_DETAIL 					= (String) sqlMap.get("SQL_OR_RESULT_REPORTING_INSERT_DETAIL");
		final String SQL_OR_RESULT_REPORTING_INSERT_HEADER					= (String) sqlMap.get("SQL_OR_RESULT_REPORTING_INSERT_HEADER");
		final String SQL_OR_RESULT_REPORTING_UPDATE_CLOB					= (String) sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_CLOB");
	
		final String SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION		= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION");
		final String SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION_CLOB	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION_CLOB");

 		PreparedStatement pstmt 				= null ;
		PreparedStatement pstmt_detail			= null ;
		PreparedStatement pstmt_clob			= null ;

		PreparedStatement pstmt_image			= null ;
		PreparedStatement pstmt_image_clob		= null ;

		ResultSet		rset_clob				= null;
		ResultSet		rset_image_clob			= null;
		
		CallableStatement cstmt 				= null ;

 		boolean result 							= true;
		int		count							= 0;
  
		//CLOB 	clb 							= null;  //Web logic Conversion -- [IN037372]
		java.sql.Clob 	clb 							= null;
		BufferedWriter 	bw						= null; 

		HashMap hashMap							= new HashMap();	// In which all the details will be there
 
			hashMap 							= ((HashMap)tabData.get("hashMap"));
		
		String image_content					= "";
		
	try {
				String order_id			= "", error				= "";
				String order_type		= "", discr_msr_id		= "";
			

				image_content			= ((String)hashMap.get("image_content"));
//System.out.println("image_content"+image_content);
				/** Get the connection **/
				// For ejb use this
				//connection				= getConnection((Properties)tabData.get( "properties" ) ) ;
				connection	= getConnection();
				connection.setAutoCommit( false ) ;
 				/** Get the Prepared Statements, Callable Statements, Statements, etc, **/
 				cstmt						= connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_INSERT_ORDER_IMAGE+" }");  //Generation of the Specimen
				
				pstmt						= connection.prepareStatement(SQL_OR_RESULT_REPORTING_INSERT_HEADER);
				pstmt_detail				= connection.prepareStatement(SQL_OR_RESULT_REPORTING_INSERT_DETAIL);
				pstmt_clob					= connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_CLOB);

				pstmt_image					= connection.prepareStatement(SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION);
				pstmt_image_clob			= connection.prepareStatement(SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION_CLOB);

				/** Till here for the prepared Statements, callable statements, statements etc */

				error_messages.setLength(0); 
				hashMap 					= ((HashMap)tabData.get("hashMap"));
				   
	 			cstmt.setString(1, ((String)hashMap.get("order_catalog_code")));  // order_catalog_code
				cstmt.setString(2, ((String)tabData.get("login_facility_id")));	  // login_facility_id
				cstmt.setString(3, ((String)hashMap.get("patient_id")));		  // patient_id
				cstmt.setString(4, ((String)hashMap.get("patient_class")));		  // patient_class
				cstmt.setInt(5, Integer.parseInt(checkForNull(((String)hashMap.get("encounter_id")),"0")));		 // encounter_id
				cstmt.setInt(6, Integer.parseInt(checkForNull(((String)hashMap.get("episode_id")),"0")));		  // episode_id
				cstmt.setInt(7, Integer.parseInt(checkForNull(((String)hashMap.get("episode_visit_num")),"0")));		  // episode_visit_num
				cstmt.setString(8, ((String)hashMap.get("location_type")));  // P_SOURCE_TYPE
				cstmt.setString(9, ((String)hashMap.get("location_code")));  // P_SOURCE_CODE
 				
				cstmt.setString(10, ((String)hashMap.get("practitioner_id")));	 // P_ORDERING_PRACT
				cstmt.setString(11, ((String)tabData.get("login_by_id")));		 // P_USER
				cstmt.setString(12, ((String)tabData.get("login_at_ws_no")));	 // P_WS_NO
 
				cstmt.registerOutParameter( 13,  Types.VARCHAR ) ;			 // P_ORDER_ID
				cstmt.registerOutParameter( 14,  Types.VARCHAR ) ;			 // V_ORDER_TYPE
				cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;			 // P_DISCR_MSR_ID
				cstmt.registerOutParameter( 16,  Types.VARCHAR ) ;			 // P_ERR_MSG
				
				cstmt.execute();
				 
                // Order_id generated and values are got
 				order_id 			= checkForNull(cstmt.getString(13),"");
           		order_type 		  	= checkForNull(cstmt.getString(14),"");
				discr_msr_id	  	= checkForNull(cstmt.getString(15),"");
				error 				= checkForNull(cstmt.getString(16),"");
 				 if(error.equals(""))
					result = true;
				 else 
					result = false;
 				 if(result) { //Insert into the header and detail
 					pstmt.setString(1, order_type);
					pstmt.setString(2, order_id);	
					pstmt.setString(3, "1");		//REPORT_SRL_NO
					pstmt.setString(4, ((String)hashMap.get("practitioner_id")));		//REPORTING_PRACT_ID
//have to pass as sysdate
					pstmt.setString(5, null);		//REPORTING_DATE
					pstmt.setString(6, "N");		//AUTH_REQD_YN
					pstmt.setString(7, null);		//AUTH_BY_ID
					pstmt.setString(8, null);		//AUTH_DATE_TIME

					pstmt.setString(9, null);		//RESULT_STATUS
					pstmt.setString(10, "2");		//RESULT_TYPE
					pstmt.setString(11, ((String)tabData.get("login_by_id")));		//ADDED_BY_ID
					pstmt.setString(12, ((String)tabData.get("login_at_ws_no")));		//ADDED_AT_WS_NO
					pstmt.setString(13, ((String)tabData.get("login_facility_id")));		//ADDED_FACILITY_ID
					pstmt.setString(14, ((String)tabData.get("login_by_id")));		//ADDED_BY_ID
					pstmt.setString(15, ((String)tabData.get("login_at_ws_no")));		//ADDED_AT_WS_NO
					pstmt.setString(16, ((String)tabData.get("login_facility_id")));		//ADDED_FACILITY_ID

 					count	= pstmt.executeUpdate();
 					 if(count > 0)
						result = true;
					 else 
						result = false;

					// Insertion the details
					 if(result) {
							pstmt_detail.setString(1, order_type);		// ORDER_TYPE_CODE
							pstmt_detail.setString(2, order_id);
							pstmt_detail.setString(3, "1");				// REPORT_SRL_NO
							pstmt_detail.setString(4, "1");
							pstmt_detail.setString(5, "1");				// SRL_NO
							pstmt_detail.setString(6, null);			// REPORTING_DATE
							pstmt_detail.setString(7, discr_msr_id);	// discr_msr_id
							pstmt_detail.setString(8, discr_msr_id);	// discr_msr_id
							pstmt_detail.setString(9, "N");				//AUTH_REQD_YN
							pstmt_detail.setString(10, null);			//AUTH_BY_ID
							pstmt_detail.setString(11, null);			//AUTH_DATE_TIME
							pstmt_detail.setString(12, "2");			//RESULT_TYPE
							pstmt_detail.setString(13, null);			//RESULT_NUM
							pstmt_detail.setString(14, null);			//AUTH_DATE_TIME
							pstmt_detail.setString(15, null);			//RESULT_STR

							pstmt_detail.setString(16, null);			//RESULT_STATUS
							pstmt_detail.setString(17, null);			//NORMAL_LOW
							pstmt_detail.setString(18, null);			//NORMAL_HIGH
							pstmt_detail.setString(19, null);			//CRITICAL_LOW
							pstmt_detail.setString(20, null);			//CRITICAL_HIGH
							pstmt_detail.setString(21, null);			//NORM_ABNORM_IND
							pstmt_detail.setString(22, null);			//RESULT_COMMENTS

							pstmt_detail.setString(23, ((String)tabData.get("login_by_id")));		//ADDED_BY_ID
							pstmt_detail.setString(24, ((String)tabData.get("login_at_ws_no")));		//ADDED_AT_WS_NO
							pstmt_detail.setString(25, ((String)tabData.get("login_facility_id")));		//ADDED_FACILITY_ID
							pstmt_detail.setString(26, ((String)tabData.get("login_by_id")));		//ADDED_BY_ID
							pstmt_detail.setString(27, ((String)tabData.get("login_at_ws_no")));			//ADDED_AT_WS_NO
							pstmt_detail.setString(28, ((String)tabData.get("login_facility_id")));		//ADDED_FACILITY_ID
							count	= pstmt_detail.executeUpdate();
 							 if(count > 0)
								result = true;
							 else 
								result = false;
 							if(result){	//insert the clob column
 
									pstmt_clob.setString(1, order_type); //order_type_code
									pstmt_clob.setString(2, order_id); //order_type_code	
									pstmt_clob.setString(3, "1"); //report_srl_no	
									pstmt_clob.setString(4, "1"); //line_srl_no	
									pstmt_clob.setString(5, "1"); //srl_no	

									rset_clob=pstmt_clob.executeQuery();
									if(rset_clob!=null)
									{
										while(rset_clob.next())
										{
										//Web logic Conversion -- [IN037372] Start.
											//clb 			= (CLOB) rset_clob.getClob(1);
											//bw 				= new BufferedWriter(clb.getCharacterOutputStream());
											
											clb 			= (java.sql.Clob) rset_clob.getClob(1);
											bw 				= new BufferedWriter(clb.setCharacterStream(0));
										//Web logic Conversion -- [IN037372] End.
											bw.write(image_content,0,image_content.length());
											bw.flush();
											bw.close();
										}
									}
									clb = null; bw = null;
 					 } // End of if result 

					  if(result) {
 						 pstmt_image.setString(1, order_id); //order_type_code	
						 pstmt_image.setString(2, "1"); //order_line_num	
						 pstmt_image.setString(3, ((String)tabData.get("login_by_id")));		//ADDED_BY_ID
						 pstmt_image.setString(4, ((String)tabData.get("login_at_ws_no")));		//ADDED_AT_WS_NO
						 pstmt_image.setString(5, ((String)tabData.get("login_facility_id")));		//ADDED_FACILITY_ID
						 pstmt_image.setString(6, ((String)tabData.get("login_by_id")));		//ADDED_BY_ID
						 pstmt_image.setString(7, ((String)tabData.get("login_at_ws_no")));			//ADDED_AT_WS_NO
						 pstmt_image.setString(8, ((String)tabData.get("login_facility_id")));	
						 count	= pstmt_image.executeUpdate();
 							 if(count > 0)
								result = true;
							 else 
								result = false;
					 }

					 if(result){
						 pstmt_image_clob.setString(1, order_id); //order_type_code
						 pstmt_image_clob.setString(2, "1"); //order_type_code	
						 rset_image_clob=pstmt_image_clob.executeQuery();
						 if(rset_image_clob!=null)
						 {
							while(rset_image_clob.next())
							{
							//Web logic Conversion -- [IN037372] Start.
								//clb 		= (CLOB) rset_image_clob.getClob(1);
								//bw 			= new BufferedWriter(clb.getCharacterOutputStream());
								
								clb 		= (java.sql.Clob) rset_image_clob.getClob(1);
								bw 			= new BufferedWriter(clb.setCharacterStream(0));
							//Web logic Conversion -- [IN037372] Start.	
								bw.write(image_content,0,image_content.length());
								bw.flush();
								bw.close();
							}
						}
						clb = null; bw = null;
					 } //End of if result clob

				 } // End of if result
			 } // End of if result header
 
					if ( result)
					{
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append( "RECORD_INSERTED" ) ;
					}else{
						connection.rollback();
						messages.append( " Insert Failed..." ) ;
						messages.append(error_messages);
						error_messages.append(" Insert Failed");
					}
		   }catch( Exception e ){
			   e.printStackTrace() ;
			   System.err.println("EJB Catch Exception:"+e.getMessage() );
			   messages.append( e.getMessage()) ;
			   error_messages.append(e.getMessage());
			   try{
					  connection.rollback();  //context.setRollbackOnly();
				  }catch(Exception ex){
						System.err.println("EJB Catch CATCH:"+ex.getMessage() );
						e.printStackTrace();
				  }
			} finally{
	            	try {
						closeStatement( pstmt ) ;
						closeStatement( pstmt_detail ) ;
						closeStatement( pstmt_clob ) ;

						closeStatement( pstmt_image ) ;
						closeStatement( pstmt_image_clob ) ;

						closeResultSet( rset_clob ) ;
						closeResultSet( rset_image_clob ) ;
						
						closeStatement( cstmt);
						
						if(connection != null) {
							closeConnection(connection);
							// for ejb
							//closeConnection( connection,(Properties)tabData.get( "properties" ) );
						}
        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
				    	fe.printStackTrace() ;
			        }
	    	    }
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", error_messages.toString() ) ;
		map.put( "flag", "" ) ;
		//********************* Nullifying the objects ************************//
		messages			  = null;	
		error_messages		  = null;		image_content = null;
		//********************* Nullifying the objects Till Here******************//
		return map ;
	} // end of insert

	// For Demo purpose done, if it is for the client, this method has to be put it in the ejb 
   // ejb has to be created and used.
   public HashMap update( HashMap tabData, HashMap sqlMap ) throws Exception{

 		Connection connection 			= null ; 
		HashMap map 					= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", new Boolean( false ) ) ;
		StringBuffer error_messages 	= new StringBuffer() ; 			 
		StringBuffer messages		 	= new StringBuffer() ; 	

 		final String SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_ORDER_UPDATE 		= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_ORDER_UPDATE");
		final String SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_ORDER_LINE_UPDATE 	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_ORDER_LINE_UPDATE");
		final String SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_RESULT_HDR_UPDATE	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_RESULT_HDR_UPDATE");
		final String SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_RESULT_DETAIL_UPDATE	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_RESULT_DETAIL_UPDATE");
		
		final String SQL_OR_RESULT_REPORTING_RESULT_CLOB					= (String) sqlMap.get("SQL_OR_RESULT_REPORTING_RESULT_CLOB");
	
	 	PreparedStatement pstmt 				= null ;
		PreparedStatement pstmt_detail			= null ;

		PreparedStatement pstmt_result			= null ;
		PreparedStatement pstmt_result_detail	= null ;

		PreparedStatement pstmt_clob			= null ;

 		ResultSet		rset_clob				= null;
 		
 		boolean result 							= true;
		int		count							= 0;
  
		//CLOB 	clb 							= null;  //Web logic Conversion -- [IN037372]
		java.sql.Clob 	clb 							= null;
		BufferedWriter 	bw						= null; 

		HashMap hashMap							= new HashMap();	// In which all the details will be there
 
			hashMap 							= ((HashMap)tabData.get("hashMap"));
		
		String image_content					= "";
		
	try {
				String order_id			= "";// error				= "";
				//String order_type		= ""; discr_msr_id		= "";
			

				image_content			= ((String)hashMap.get("image_content"));
				order_id				= ((String)hashMap.get("order_id"));
//System.out.println("image_content"+image_content);
 				/** Get the connection **/
				// For ejb use this
				//connection				= getConnection((Properties)tabData.get( "properties" ) ) ;
				connection	= getConnection();
				connection.setAutoCommit( false ) ;
 				/** Get the Prepared Statements, Callable Statements, Statements, etc, **/
  				pstmt						= connection.prepareStatement(SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_ORDER_UPDATE);
				pstmt_detail				= connection.prepareStatement(SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_ORDER_LINE_UPDATE);

				pstmt_result				= connection.prepareStatement(SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_RESULT_HDR_UPDATE);
				pstmt_result_detail				= connection.prepareStatement(SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_RESULT_DETAIL_UPDATE);

				pstmt_clob					= connection.prepareStatement(SQL_OR_RESULT_REPORTING_RESULT_CLOB);

 
				/** Till here for the prepared Statements, callable statements, statements etc */

				error_messages.setLength(0); 
				hashMap 					= ((HashMap)tabData.get("hashMap"));
				   
					pstmt.setString(1, ((String)tabData.get("login_by_id")));		//MODIFIED_BY_ID
					pstmt.setString(2, ((String)tabData.get("login_at_ws_no")));	//MODIFIED_AT_WS_NO
					pstmt.setString(3, ((String)tabData.get("login_facility_id")));	//MODIFIED_FACILITY_ID
					pstmt.setString(4, order_id);		//ADDED_BY_ID
 
 					count	= pstmt.executeUpdate();
 					 if(count > 0)
						result = true;
					 else 
						result = false;

					// Insertion the details
					 if(result) {
 							pstmt_detail.setString(1, ((String)tabData.get("login_by_id")));		//ADDED_BY_ID
							pstmt_detail.setString(2, ((String)tabData.get("login_at_ws_no")));		//ADDED_AT_WS_NO
							pstmt_detail.setString(3, ((String)tabData.get("login_facility_id")));		//ADDED_FACILITY_ID
							pstmt_detail.setString(4, order_id);		//order_id
							pstmt_detail.setString(5, "1");			    //order_line_nu,
 							count	= pstmt_detail.executeUpdate();
 							 if(count > 0)
								result = true;
							 else 
								result = false;

							if(result) { //update the or_result_header
								pstmt_result.setString(1, ((String)hashMap.get("practitioner_id")));		//practitioner_id
								pstmt_result.setString(2, ((String)tabData.get("login_by_id")));		//MODIFIED_BY_ID
								pstmt_result.setString(3, ((String)tabData.get("login_at_ws_no")));		//ADDED_AT_WS_NO
								pstmt_result.setString(4, ((String)tabData.get("login_facility_id")));		//ADDED_FACILITY_ID
								pstmt_result.setString(5, order_id);		//order_id
								count	= pstmt_result.executeUpdate();
	 						    if(count > 0)
									result = true;
								 else 
									result = false;
								}

							if(result) { //update the or_result_detail table
 								pstmt_result_detail.setString(1, ((String)tabData.get("login_by_id")));		//MODIFIED_BY_ID
								pstmt_result_detail.setString(2, ((String)tabData.get("login_at_ws_no")));		//MODIFIED_AT_WS_NO
								pstmt_result_detail.setString(3, ((String)tabData.get("login_facility_id")));	//MODIFIED_FACILITY_ID
								pstmt_result_detail.setString(4, order_id);		//order_id
								pstmt_result_detail.setString(5, "1");		//line_srl_num
								count	= pstmt_result_detail.executeUpdate();
								 if(count > 0)
									result = true;
								 else 
									result = false;
							}

							if(result){	//update  the clob column
 
 									pstmt_clob.setString(1, order_id); //order_type_code	
									pstmt_clob.setString(2, "1"); //report_srl_no	
									pstmt_clob.setString(3, "1"); //line_srl_no	
									pstmt_clob.setString(4, "1"); //srl_no	

									rset_clob=pstmt_clob.executeQuery();
									if(rset_clob!=null)
									{
										while(rset_clob.next())
										{
										//Web logic Conversion -- [IN037372] Start.
											//clb 			= (CLOB) rset_clob.getClob(1);
											//bw 				= new BufferedWriter(clb.getCharacterOutputStream());
											
											clb 			= (java.sql.Clob) rset_clob.getClob(1);
											bw 				= new BufferedWriter(clb.setCharacterStream(0));
										//Web logic Conversion -- [IN037372] End.
											bw.write(image_content,0,image_content.length());
											bw.flush();
											bw.close();
										}
									}
									clb = null; bw = null;
 							} // End of if result 

				} // End of if result
 
				if ( result)
				{
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					messages.append( "RECORD_INSERTED" ) ;
				}else{
					connection.rollback();
					messages.append( " Insert Failed..." ) ;
					messages.append(error_messages);
					error_messages.append(" Insert Failed");
				}
		   }catch( Exception e ){
			   e.printStackTrace() ;
			   System.err.println("EJB Catch Exception:"+e.getMessage() );
			   messages.append( e.getMessage()) ;
			   error_messages.append(e.getMessage());
			   try{
					  connection.rollback();  //context.setRollbackOnly();
				  }catch(Exception ex){
						System.err.println("EJB Catch CATCH:"+ex.getMessage() );
						e.printStackTrace();
				  }
			} finally{
	            	try {
						closeStatement( pstmt ) ;
						closeStatement( pstmt_detail ) ;

						closeStatement( pstmt_result ) ;
						closeStatement( pstmt_result_detail ) ;

						closeStatement( pstmt_clob ) ;

 						closeResultSet( rset_clob ) ;
 						if(connection != null) {
							closeConnection(connection);
							// for ejb
							//closeConnection( connection,(Properties)tabData.get( "properties" ) );
						}
        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
				    	fe.printStackTrace() ;
			        }
	    	    }
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", error_messages.toString() ) ;
		map.put( "flag", "" ) ;
		//********************* Nullifying the objects ************************//
		messages			  = null;	
		error_messages		  = null;		image_content = null;
		//********************* Nullifying the objects Till Here******************//
		return map ;
	} // end of update


 /************************METHOD TO Update****************************/
 public HashMap modify(){
 	 // boolean result					= false;
	  HashMap map						= new HashMap() ;

	  //java.util.Properties  properties   = getProperties();
	  map.put( "result", new Boolean( false ) ) ;
	  HashMap tabData           = new HashMap() ;
    	  try{
  				tabData.put( "properties",  getProperties() ) ;
				tabData.put( "login_by_id",login_by_id ) ;
				tabData.put( "login_at_ws_no",login_at_ws_no ) ;
				tabData.put( "login_facility_id",login_facility_id ) ;
				tabData.put( "hashMap",hashMap ) ;
							
				HashMap sqlMap = new HashMap() ;
				try{
 
 					  sqlMap.put( "SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_ORDER_UPDATE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_ORDER_UPDATE") );
					  sqlMap.put( "SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_ORDER_LINE_UPDATE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_ORDER_LINE_UPDATE") );
					  sqlMap.put( "SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_RESULT_HDR_UPDATE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_RESULT_HDR_UPDATE") );
					  sqlMap.put( "SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_RESULT_DETAIL_UPDATE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_OR_RESULT_DETAIL_UPDATE") );
  					  sqlMap.put( "SQL_OR_RESULT_REPORTING_RESULT_CLOB", OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_RESULT_CLOB") );
   					  sqlMap.put( "SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION") );
   					  sqlMap.put( "SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION_CLOB", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_INSERTION_CLOB") );
				  }catch(Exception e){
					e.printStackTrace() ;
				  }
				  return getResult(tabData, sqlMap) ;
		}	 catch(Exception e) {
					System.err.println( "Error Calling EJB : "+e ) ;
					map.put( "message", e.getMessage() ) ;
					e.printStackTrace() ;
			  } 
	 return map ;
 }//end of modify
 /********************* Till Here *****************************/

	 /*********************METHOD TO Delete*************************/
	 public HashMap delete(){
		/*HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "delete failure.." );
		return map;
		*/
		return null;
	 }//end of delete
	 /********************* Till Here *****************************/

}//end of class
