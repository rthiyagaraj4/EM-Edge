/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.OROrderEntryFormatItem;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;

import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="OROrderEntryFormatItem"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OROrderEntryFormatItem"
*	local-jndi-name="OROrderEntryFormatItem"
*	impl-class-name="eOR.OROrderEntryFormatItem.OROrderEntryFormatItemManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.OROrderEntryFormatItem.OROrderEntryFormatItemLocal"
*	remote-class="eOR.OROrderEntryFormatItem.OROrderEntryFormatItemRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.OROrderEntryFormatItem.OROrderEntryFormatItemLocalHome"
*	remote-class="eOR.OROrderEntryFormatItem.OROrderEntryFormatItemHome"
*	generate= "local,remote"
*
*
*/


public class OROrderEntryFormatItemManager extends OrEJBSessionAdapter {
 //   SessionContext context ;
	StringBuffer traceVals = new StringBuffer();

	Connection connection = null ;

	PreparedStatement pstmt_insert_order_entry = null ;
	PreparedStatement pstmt_insert_order_entry_list_dtl = null ;
	PreparedStatement pstmt_update_order_entry = null ;
	PreparedStatement pstmt_update_order_entry_list_dtl = null ;

/**
* @ejb.interface-method
*	 view-type="both"
*/

		public HashMap insert( HashMap tabData, HashMap sqlMap ) {
			StringBuffer messages = null ;
			traceVals = new StringBuffer();
			HashMap map = null ;
		try{
				connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			//	connection = getConnection() ;
				messages = new StringBuffer() ;

				map = new HashMap() ;
				int inserted = 0;
				String field_type = (String) tabData.get( "field_type" ) ;

				inserted = insertDetails(tabData, sqlMap, connection);
				traceVals.append("after first insert "+inserted);


				if ( inserted < 1 ) {
					connection.rollback() ;
					messages.append( "Insert Failed" ) ;
				} else if(field_type.equals("L") || field_type.equals("R")){
					traceVals.append("-- b4 calling 2nd isnert: "+field_type);

					inserted = 0;
					traceVals.append(" ---just b4 calling 2nd isnert: ");
					inserted = insertListValues(tabData, sqlMap,connection);

					if ( inserted < 1 ) {
						connection.rollback() ;
						messages.append( "Insert Failed" ) ;
					}

				}
				if(inserted >= 1){
					connection.commit() ;
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", "Operation Completed Successfully..." ) ;
					//messages.append( "Operation Completed Successfully..." ) ;
					messages.append( "RECORD_INSERTED" ) ;
				}
			}catch(Exception e){
				try{
					connection.rollback();
				}catch (Exception e1){
					System.err.println( e1.getMessage() ) ;
					e1.printStackTrace() ;
				}

				traceVals.append("insert exception" + e.getMessage());
			}finally{
				try {
					if ( pstmt_insert_order_entry != null ) {
						pstmt_insert_order_entry.close() ;
						pstmt_insert_order_entry = null ;
					}
					if(connection != null) {
					closeConnection(connection,(Properties)tabData.get( "properties" ));
					}
				} catch ( Exception fe ) {
					System.err.println( fe.getMessage() ) ;
					fe.printStackTrace() ;
				}
			}

			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVals.toString() ) ;

			return map ;
		}




private int insertDetails(HashMap tabData, HashMap sqlMap, Connection connection ) {
	//System.out.println("tabData"+tabData);
			traceVals.append("first line first method");

			StringBuffer messages = new StringBuffer() ;

			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "flag", "") ;
			map.put( "callOnSuccess", new Boolean( false ) ) ;


			int result=0;

			try {

				String field_mnemonic= (String) tabData.get( "field_mnemonic" );
				String field_mnemonic_desc= (String) tabData.get( "field_mnemonic_desc" );
				String field_type = (String) tabData.get( "field_type" ) ;
				String order_category = (String) tabData.get( "order_category" ) ;
				String meaning = (String) tabData.get( "meaning" ) ;
				String min_value = (String) tabData.get( "min_value" ) ;
				String max_value = (String) tabData.get( "max_value" ) ;
				String single_multi = (String) tabData.get( "single_multi" ) ;
				String presentation_type = (String) tabData.get( "presentation_type" ) ;
				String hint = (String) tabData.get( "hint" ) ;
				String descrete_measure= (String) tabData.get( "descrete_measure") ;
				String eff_status = (String)tabData.get( "eff_status") ;

				traceVals.append("meaning : "+ meaning);


				if(  min_value.equals(" ") || min_value == null || min_value.equals("")){
					min_value = null;
				}

				if( max_value.equals(" ") || max_value == null || max_value.equals("")){
					max_value = null;
				}

				if( hint == null || hint.equals("") || hint.equals(" ")){
					hint = null;
				}
				traceVals.append("*EJB*min_value >"+ min_value+"<");
				traceVals.append("*EJB*max_value : >"+ max_value+"<");
				if(descrete_measure == null || descrete_measure.equals("")){
					descrete_measure = null;
				}


					final String SQL_ORDER_ENTRY_ITEM_INSERT = (String) sqlMap.get( "SQL_ORDER_ENTRY_ITEM_INSERT" ) ;
					pstmt_insert_order_entry		= connection.prepareStatement( SQL_ORDER_ENTRY_ITEM_INSERT ) ;

					pstmt_insert_order_entry.setString( 1, (String) order_category) ;
					pstmt_insert_order_entry.setString( 2, (String) field_mnemonic ) ;
					pstmt_insert_order_entry.setString( 3, (String) field_mnemonic_desc ) ;
					pstmt_insert_order_entry.setString( 4, (String) field_type ) ;
					pstmt_insert_order_entry.setString( 5, (String) meaning) ;
					pstmt_insert_order_entry.setString( 6, (String) single_multi ) ;
					pstmt_insert_order_entry.setString( 7, (String) presentation_type ) ;
					pstmt_insert_order_entry.setString( 8, (String) hint ) ;
					pstmt_insert_order_entry.setString( 9, (String) descrete_measure) ;
					pstmt_insert_order_entry.setString( 10, (String)  min_value ) ;
					pstmt_insert_order_entry.setString( 11, (String) max_value ) ;
					pstmt_insert_order_entry.setString( 12, (String) eff_status ) ;
			  		pstmt_insert_order_entry.setString( 13, (String) tabData.get( "added_by_id" ) ) ;
					pstmt_insert_order_entry.setString( 14, (String) tabData.get( "added_at_ws_no" ) ) ;
					pstmt_insert_order_entry.setString( 15, (String) tabData.get( "added_facility_id" ) ) ;
					pstmt_insert_order_entry.setString( 16, (String) tabData.get( "modified_by_id" ) ) ;
					pstmt_insert_order_entry.setString( 17, (String) tabData.get( "modified_at_ws_no" ) ) ;
					pstmt_insert_order_entry.setString( 18, (String) tabData.get( "modified_facility_id" ) ) ;

					traceVals.append("-- before execute --");
					result = pstmt_insert_order_entry.executeUpdate() ;
					traceVals.append("-- after execute --");


			 } catch( Exception e ) {
				traceVals.append("Exception if any -- "+e);

				messages.append( e.getMessage() ) ;
				System.err.println(e.getMessage() );
				e.printStackTrace() ;
			} finally {
				try {
					if ( pstmt_insert_order_entry != null ) {
						closeStatement(pstmt_insert_order_entry);
					}
				} catch ( Exception fe ) {
					System.err.println( fe.getMessage() ) ;
					fe.printStackTrace() ;
				}
			}
			map.put( "traceVal", traceVals.toString() ) ;
			return result;

		}



		private int insertListValues(HashMap tabData, HashMap sqlMap,Connection connection ) {
				traceVals.append(" ---just inside 2nd isnert: ");
			StringBuffer messages = new StringBuffer() ;

			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "flag", "") ;
			map.put( "callOnSuccess", new Boolean( false ) ) ;
			LinkedHashMap listValues =new LinkedHashMap();

			int result=0;
			int total_rows=0;

			try {
					String field_mnemonic= (String) tabData.get( "field_mnemonic" );
					String order_category = (String) tabData.get( "order_category" ) ;
					listValues = (LinkedHashMap) tabData.get( "listValues" ) ;

					//traceVals.append("*** field_mnemonic ::: "+field_mnemonic);
					//traceVals.append("*** order_category ::: "+order_category);
					//traceVals.append("*** listValues ::: "+listValues);

					final String SQL_ORDER_ENTRY_ITEM_INSERT_LIST_VALUE = (String) sqlMap.get( "SQL_ORDER_ENTRY_ITEM_INSERT_LIST_VALUE" ) ;
					//traceVals.append("*** SQL_ORDER_ENTRY_ITEM_INSERT_LIST_VALUE ::: "+SQL_ORDER_ENTRY_ITEM_INSERT_LIST_VALUE);
					pstmt_insert_order_entry_list_dtl		= connection.prepareStatement( SQL_ORDER_ENTRY_ITEM_INSERT_LIST_VALUE ) ;


					if(listValues != null){
						//StringTokenizer st1		= new StringTokenizer(listValues,"`");
					//	String			mainStr = "";
					//	String			subStr	= "";

						//while(st1.hasMoreTokens()){
						total_rows = Integer.parseInt((String)listValues.get("total_rows"));
						
						for(int i=0; i<total_rows; i++)
						{

						pstmt_insert_order_entry_list_dtl.setString( 1,  order_category.trim()) ;
						pstmt_insert_order_entry_list_dtl.setString( 2,  field_mnemonic.trim() ) ;
				//traceVals.append("order_category="+order_category);
				//traceVals.append("field_mnemonic="+field_mnemonic);

						pstmt_insert_order_entry_list_dtl.setString( 5, (String) tabData.get( "added_by_id" ) ) ;
						pstmt_insert_order_entry_list_dtl.setString( 6, (String) tabData.get( "added_at_ws_no" ) ) ;
						pstmt_insert_order_entry_list_dtl.setString( 7, (String) tabData.get( "added_facility_id" ) ) ;
						pstmt_insert_order_entry_list_dtl.setString( 8, (String) tabData.get( "modified_by_id" ) ) ;
						pstmt_insert_order_entry_list_dtl.setString( 9, (String) tabData.get( "modified_at_ws_no" ) ) ;
						pstmt_insert_order_entry_list_dtl.setString( 10, (String) tabData.get( "modified_facility_id" ) ) ;

						//mainStr  = st1.nextToken();
						//StringTokenizer st2 = new StringTokenizer(mainStr,"~");
						//String[] record = new String[2] ;
						String descValue = "";
						String seqValue = "";
							//traceVals.append("---main token "+mainStr);

						descValue = (String)listValues.get("desc_array"+i);
						seqValue = (String)listValues.get("seq_array"+i);
						traceVals.append("//firstValue="+descValue);
						traceVals.append("--secondValue="+seqValue);
						pstmt_insert_order_entry_list_dtl.setString( 3, descValue.trim()) ;
						pstmt_insert_order_entry_list_dtl.setString( 4, seqValue.trim()) ;
						result = pstmt_insert_order_entry_list_dtl.executeUpdate() ;
						traceVals.append("-- after execute --");

						}
				}


			 } catch( Exception e ) {
				traceVals.append("Exception if any -- "+e);

				messages.append( e.getMessage() ) ;
				System.err.println(e.getMessage() );
				e.printStackTrace() ;
			} finally {
				try {
					if ( pstmt_insert_order_entry_list_dtl != null ) {
							closeStatement(pstmt_insert_order_entry_list_dtl);
					}
				} catch ( Exception fe ) {
					System.err.println( fe.getMessage() ) ;
					fe.printStackTrace() ;
				}
			}
			return result;

		}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap modify( HashMap tabData, HashMap sqlMap ) {
					//System.out.println("inside============modify tabData"+tabData); 

		traceVals = new StringBuffer();
		traceVals.append("after first eeeeee");
		StringBuffer messages = null ;
		HashMap map = null ;
	try{

			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			messages = new StringBuffer() ;

			map = new HashMap() ;
			int inserted = 0;
			String field_type = (String) tabData.get( "field_type" ) ;

			inserted = modifyDetails(tabData, sqlMap, connection);

			if ( inserted < 1 ) {
				connection.rollback() ;
				messages.append( "Insert Failed" ) ;
			} else if(field_type.equals("L") || field_type.equals("R")){
				inserted = 0;
				traceVals.append(" ---just b4 calling 2nd modify: ");
				inserted = modifyListValues(tabData, sqlMap,connection);

				if ( inserted < 1 ) {
					connection.rollback() ;
					if(inserted==-1)
						{
							// System.out.println("DELETE_NOT_ALLOWED");
							map.put( "result", new Boolean( false ) ) ;
						   messages.append( "DELETE_NOT_ALLOWED" ) ;
						}
						else
					  messages.append( "Insert Failed" ) ;
				}

			}
			if(inserted >= 1){
				connection.commit() ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "Operation Completed Successfully..." ) ;
				//messages.append( "Operation Completed Successfully..." ) ;
				messages.append( "RECORD_MODIFIED" ) ;
			}
		}catch(Exception e){
			try{
				connection.rollback();
			}catch (Exception e1){
				System.err.println( e1.getMessage() ) ;
				e1.printStackTrace() ;
			}

			traceVals.append("modify exception" + e.getMessage());
		}finally{
				try {
					if(connection != null) {
					closeConnection(connection,(Properties)tabData.get( "properties" ));
					}
				} catch ( Exception fe ) {
					System.err.println( fe.getMessage() ) ;
					fe.printStackTrace() ;
				}
		}

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}



	private int modifyDetails(HashMap tabData, HashMap sqlMap, Connection connection ) {
		traceVals.append("first line first method");
		 // System.out.println("inside============modifyDetails"+tabData); 
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;


		int result=0;

		try {

			String field_mnemonic= (String) tabData.get( "field_mnemonic" );
			String field_mnemonic_desc= (String) tabData.get( "field_mnemonic_desc" );
			String field_type = (String) tabData.get( "field_type" ) ;
			String order_category = (String) tabData.get( "order_category" ) ;

			String min_value = (String) tabData.get( "min_value" ) ;
			String max_value = (String) tabData.get( "max_value" ) ;

			String descrete_measure = (String) tabData.get( "descrete_measure" ) ;

			String single_multi = (String) tabData.get( "single_multi" ) ;
			String presentation_type = (String) tabData.get( "presentation_type" ) ;
			String hint = (String) tabData.get( "hint" ) ;
			String eff_status = (String)tabData.get( "eff_status") ;

			traceVals.append("single_multi : "+ single_multi);
			traceVals.append("min_value : "+ min_value);
			traceVals.append("max_value : "+ max_value);

			if( hint == null || hint.equals("")){
				hint = null;
			}

			if( descrete_measure == null || descrete_measure.equals("")){
				descrete_measure = null;
			}
			
				final String SQL_ORDER_ENTRY_ITEM_UPDATE = (String) sqlMap.get( "SQL_ORDER_ENTRY_ITEM_UPDATE" ) ;
				pstmt_update_order_entry		= connection.prepareStatement( SQL_ORDER_ENTRY_ITEM_UPDATE ) ;
				//System.out.println("SQL_ORDER_ENTRY_ITEM_UPDATE"+SQL_ORDER_ENTRY_ITEM_UPDATE);
				pstmt_update_order_entry.setString( 1, (String) single_multi ) ;
				pstmt_update_order_entry.setString( 2, (String) presentation_type ) ;
				pstmt_update_order_entry.setString( 3, (String) hint ) ;
				pstmt_update_order_entry.setString( 4, (String) eff_status ) ;
				pstmt_update_order_entry.setString( 5, (String) min_value ) ;
				pstmt_update_order_entry.setString( 6, (String) max_value ) ;
				pstmt_update_order_entry.setString( 7, (String) descrete_measure ) ;
				pstmt_update_order_entry.setString( 8, (String) tabData.get( "modified_by_id" ) ) ;
				pstmt_update_order_entry.setString( 9, (String) tabData.get( "modified_at_ws_no" ) ) ;
				pstmt_update_order_entry.setString( 10, (String) tabData.get( "modified_facility_id" ) ) ;
				pstmt_update_order_entry.setString( 11,(String) field_mnemonic_desc ) ;
				pstmt_update_order_entry.setString( 12, (String) order_category) ;
				pstmt_update_order_entry.setString( 13,(String)field_mnemonic ) ;
				pstmt_update_order_entry.setString( 14,(String)field_type ) ;

				traceVals.append("-- before execute --");
				result = pstmt_update_order_entry.executeUpdate() ;
				traceVals.append("-- after execute --" +result);


		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
				if ( pstmt_update_order_entry != null ) {
					closeStatement(pstmt_update_order_entry);
				}
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "traceVal", traceVals.toString() ) ;
		return result;

	}



	private int modifyListValues(HashMap tabData, HashMap sqlMap,Connection connection ) {
			//System.out.println("inside============modifyListValues"+tabData); 
			traceVals.append(" ---just inside 2nd isnert: ");
			StringBuffer messages = new StringBuffer() ;

			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "flag", "") ;
			map.put( "callOnSuccess", new Boolean( false ) ) ;
		     PreparedStatement pstmt=null;
		     PreparedStatement pstmt1=null;
			 PreparedStatement pstmt2=null;
			 PreparedStatement pstmt3=null;
			 PreparedStatement pstmt4=null;
			 PreparedStatement pstmt5=null;
			 ResultSet rs=null;
			 ResultSet rs1=null;
			String seqNo="";
		    String seqNo1="";
		    int [] insertCounts ;
			int [] updateCounts ;
			boolean insert_flag = false ;
			boolean delete_flag = false ;
			boolean update_flag = false ;
		   ArrayList  seqarr=new ArrayList();
		   ArrayList  seqarr1=new ArrayList();
		   ArrayList  updatelist=new ArrayList();
		   ArrayList  insertList=new ArrayList();
		   ArrayList  deleteList=new ArrayList();
		   final String insertSql = (String) sqlMap.get( "SQL_ORDER_ENTRY_ITEM_INSERT_LIST_VALUE" ) ;
		   final String updateSql = (String) sqlMap.get( "SQL_ORDER_ENTRY_ITEM_UPDATE_LIST_VALUE" ) ;
		   final String deleteSql = (String) sqlMap.get( "SQL_ORDER_ENTRY_ITEM_DELETE_LIST_VALUE" ) ;
		   final String getSequencenoSql = (String) sqlMap.get( "SQL_ORDER_ENTRY_ITEM_GET_SEQUENCE_NUM" ) ;
		   final String getspecimenfororderableSql = (String) sqlMap.get( "SQL_ORDER_ENTRY_ITEM_GET_SPECIMENT_KEY_REF" ) ;
		   LinkedHashMap listValues = new LinkedHashMap();
		  // String key_ref="";
		//int result[] ;
		int resultLength = 0;
		int total_rows=0;

		try {
				traceVals.append("Ebtered for list im modify");

				String field_mnemonic= (String) tabData.get( "field_mnemonic" );
				String order_category = (String) tabData.get( "order_category" );
				
				listValues = (LinkedHashMap) tabData.get( "listValues" ) ;
				if(field_mnemonic.equals("SPECIMEN_TYPE"))
				{	  
						
					   pstmt=connection.prepareStatement(getSequencenoSql);
					   rs = pstmt.executeQuery() ;
					   while(rs!=null && rs.next())
					   {
							 seqNo=rs.getString("KEY_REF");
							 seqarr.add(seqNo);
					   }
					   if(listValues != null){
						//StringTokenizer st1		= new StringTokenizer(listValues,"`");
						//String			mainStr = "";
						//while(st1.hasMoreTokens()){																				
							//mainStr  = st1.nextToken();
							//StringTokenizer st2 = new StringTokenizer(mainStr,"~");
						total_rows = Integer.parseInt((String)listValues.get("total_rows"));
						
						for(int i=0; i<total_rows; i++)
						{
							String descValue = "";
							String seqValue = "";
							String keyValue = "";
							 descValue =(String)listValues.get("desc_array"+i);
							 seqValue = (String)listValues.get("seq_array"+i);
							 keyValue=	 (String)listValues.get("key_array"+i);
								//System.out.println("firstValue==="+firstValue+"secondValue=="+secondValue);
									 
								seqarr1.add(keyValue);
									
								if (seqarr.contains(keyValue))
							   {
									
								   updatelist.add(descValue+"#"+seqValue+"#"+keyValue);
							   }
							   else
								{
								   insertList.add(descValue+"#"+seqValue);
								}
							}
						}
								 pstmt1=connection.prepareStatement(getSequencenoSql);
								 rs1 = pstmt.executeQuery() ;
								   while(rs1!=null && rs1.next())
								   {
										 seqNo1=rs1.getString("KEY_REF");
										
										if(!seqarr1.contains(seqNo1))
									   {
											deleteList.add(seqNo1);
									   }
								   }
								   if ( rs1 != null ) {
					                    rs1.close();
				                   }
								/*System.out.println("seqarr1============"+seqarr1);
								System.out.println("updatelist============"+updatelist);
								System.out.println("insertList============"+insertList);
								System.out.println("deleteList============"+deleteList);*/

								 if(insertList.size() >0)
									insert_flag = false;
								else
									insert_flag = true;

								if(deleteList.size() >0)
									delete_flag = false;
								else
									delete_flag = true;
								if(updatelist.size() >0)
									update_flag = false;
								else
									update_flag = true;
								 
						 if(insertList.size() >0 ){
									pstmt2=connection.prepareStatement(insertSql);
									for(int k=0 ; k < insertList.size() ; k++){
									String BothValues=(String)insertList.get(k);
									String[] desc=BothValues.split("#");
									pstmt2.setString( 1,  order_category.trim()) ;
									pstmt2.setString( 2,  field_mnemonic.trim() ) ;
									pstmt2.setString( 3,  desc[0] ) ;
									pstmt2.setString( 4,  desc[1] ) ;
									pstmt2.setString( 5, (String) tabData.get( "added_by_id" ) ) ;
									pstmt2.setString( 6, (String) tabData.get( "added_at_ws_no" ) ) ;
									pstmt2.setString( 7, (String) tabData.get( "added_facility_id" ) ) ;
									pstmt2.setString( 8, (String) tabData.get( "modified_by_id" ) ) ;
									pstmt2.setString( 9, (String) tabData.get( "modified_at_ws_no" ) ) ;
									pstmt2.setString( 10, (String) tabData.get( "modified_facility_id" ) ) ;
									pstmt2.addBatch();
								
								}
								  insertCounts = pstmt2.executeBatch();
								  for (int i=0;i<insertCounts.length ;i++ ){
									if(insertCounts[i]<0  && insertCounts[i] != -2 ){
										//System.out.println("in insertcount");
										insert_flag=false;
										break;
									}
									else{
									insert_flag=true;
									}
								}
							}
								 
							 if(updatelist.size() >0 ){
								 //System.out.println("inside updatelist=======");
								pstmt3=connection.prepareStatement(updateSql);
								for(int k=0 ; k < updatelist.size() ; k++){
								String BothValues=(String)updatelist.get(k);
								String[] desc=BothValues.split("#");
									pstmt3.setString( 1,  order_category.trim()) ;
									pstmt3.setString( 2,  field_mnemonic.trim() ) ;
									pstmt3.setString( 3,  desc[0] ) ;
									pstmt3.setString( 4,  desc[1] ) ;
									pstmt3.setString( 5, (String) tabData.get( "added_by_id" ) ) ;
									pstmt3.setString( 6, (String) tabData.get( "added_at_ws_no" ) ) ;
									pstmt3.setString( 7, (String) tabData.get( "added_facility_id" ) ) ;
									pstmt3.setString( 8, (String) tabData.get( "modified_by_id" ) ) ;
									pstmt3.setString( 9, (String) tabData.get( "modified_at_ws_no" ) ) ;
									pstmt3.setString( 10, (String) tabData.get( "modified_facility_id" ) ) ;
									pstmt3.setString( 11,  order_category.trim()) ;
									pstmt3.setString( 12,  field_mnemonic.trim() ) ;
									pstmt3.setString( 13,  desc[2] ) ;
									pstmt3.addBatch();
									}
								  updateCounts = pstmt3.executeBatch();
								  for (int i=0;i<updateCounts.length ;i++ ){
									if(updateCounts[i]<0  && updateCounts[i] != -2 ){
										update_flag=false;
										break;
									}
									else{
										update_flag=true;
									}
								}


							}
							    if(deleteList.size() >0 ){

								 //System.out.println("inside deleteList=======");
								pstmt4=connection.prepareStatement(deleteSql);
								pstmt5=connection.prepareStatement(getspecimenfororderableSql);
								
								for(int k=0 ; k < deleteList.size() ; k++){
									String sequenceNo=(String)deleteList.get(k);
									//System.out.println("inside sequenceNo======="+sequenceNo);
									  pstmt5.setString(1,sequenceNo);
									   rs1=pstmt5.executeQuery();
									   if(!rs1.next() || rs1.equals(""))
									  {
										 //System.out.println("inside if loop=======");
										pstmt4.setString( 1,  order_category.trim()) ;
										pstmt4.setString( 2,  field_mnemonic.trim() ) ;
										pstmt4.setString( 3,  sequenceNo ) ;
										pstmt4.executeUpdate() ;
										delete_flag=true;
									  }
									  else
									{
										  delete_flag=false;
										//  System.out.println("inside else loop");
									}
									if ( rs1 != null ) {
					                       rs1.close();
				                       }
								}
								
							
							}
							if(insert_flag && delete_flag && update_flag)
							  resultLength=1;
							 else
							 resultLength=-1;
					}
				else
				{
							final String SQL_ORDER_ENTRY_ITEM_DELETE = (String) sqlMap.get( "SQL_ORDER_ENTRY_ITEM_DELETE" ) ;
							//traceVals.append("****** SQL_ORDER_ENTRY_ITEM_DELETE --"+SQL_ORDER_ENTRY_ITEM_DELETE);
							pstmt_update_order_entry_list_dtl		= connection.prepareStatement( SQL_ORDER_ENTRY_ITEM_DELETE ) ;

							pstmt_update_order_entry_list_dtl.setString( 1, (String) order_category) ;
							pstmt_update_order_entry_list_dtl.setString( 2, (String) field_mnemonic ) ;

							resultLength = pstmt_update_order_entry_list_dtl.executeUpdate() ;
							traceVals.append("-- ****** after execute --"+resultLength);
							resultLength = insertListValues(tabData, sqlMap,connection);
				}

				/*if ( resultLength < 1 ) {
					connection.rollback() ;
					messages.append( "Delete Failed" ) ;
				}else{
					resultLength = insertListValues(tabData, sqlMap,connection);
			  	}		*/


		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);
		//	connection.rollback() ;
			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
				if ( pstmt_update_order_entry_list_dtl != null ) {
					closeStatement(pstmt_update_order_entry_list_dtl);
				}
				if ( pstmt != null ) {
					closeStatement(pstmt);
				}
				if ( pstmt1 != null ) {
					closeStatement(pstmt1);
				}
				if ( pstmt2 != null ) {
					closeStatement(pstmt2);
				}
				if ( pstmt3 != null ) {
					closeStatement(pstmt3);
				}
				if ( pstmt4 != null ) {
					closeStatement(pstmt4);
				}
				if ( pstmt5 != null ) {
					closeStatement(pstmt5);
				}
				 if ( rs != null ) {
					rs.close();
				}
				
			
								

			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		//System.out.println("resultLength====="+resultLength);
		return resultLength;

	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap delete( HashMap tabData, HashMap sqlMap ) {

		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;


		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}


}


