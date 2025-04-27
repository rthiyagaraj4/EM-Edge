/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------

11/3/2021              TFS:15756               Shazana                           								check Style Audit report 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
 package eSS.Washing;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import java.sql.* ;
import eCommon.Common.*;


/**
*
* @ejb.bean
*	name="Washing"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Washing"
*	local-jndi-name="Washing"
*	impl-class-name="eSS.Washing.WashingManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.Washing.WashingLocal"
*	remote-class="eSS.Washing.WashingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.Washing.WashingLocalHome"
*	remote-class="eSS.Washing.WashingHome"
*	generate= "local,remote"
*
*
*/


public class  WashingManager extends SsEJBSessionAdapter {


/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	 public HashMap insert( HashMap tabData, HashMap sqlMap )  {

		StringBuffer messages = new StringBuffer() ;
		String debug = null;//"From EJB : ";
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		Properties	properties	=	null;

		Connection connection = null ;
		PreparedStatement pstmt_insert_hdr = null ;
		PreparedStatement pstmt_insert_dtl = null ;
		PreparedStatement pstmt_update = null ;
		PreparedStatement pstmt_insert_rof_dtl = null ;


		final String SQL_SS_WASHING_INSERT_HDR = (String) sqlMap.get( "SQL_SS_WASHING_INSERT_HDR" );
		final String SQL_SS_WASHING_INSERT_DTL = (String) sqlMap.get( "SQL_SS_WASHING_INSERT_DTL" );
		final String SQL_SS_WASHING_LOADNO_UPDATE = (String) sqlMap.get( "SQL_SS_WASHING_LOADNO_UPDATE" );
		final String SQL_SS_WASHING_ROF_UPDATE = (String) sqlMap.get( "SQL_SS_WASHING_ROF_UPDATE" );

		ArrayList insertDataHdr = new ArrayList() ;
		ArrayList insertDataDtl = new ArrayList() ;
		ArrayList updateData = new ArrayList() ;
		ArrayList insertRecords=null;
	//	ArrayList updateRecords=null;


		insertDataHdr=(ArrayList)tabData.get("InsertDataHdr");
		insertDataDtl=(ArrayList)tabData.get("InsertDataDtl");
		updateData=(ArrayList)tabData.get("UpdateData");


		boolean insert_rec=false;


		try {
			properties			=	(Properties)	tabData.get("properties");
			connection			=	getConnection(properties);
			pstmt_insert_hdr = connection.prepareStatement( SQL_SS_WASHING_INSERT_HDR ) ;

			if(insertDataHdr.size()>0  &&  insertDataDtl.size()>0){
				insert_rec=true;
			}
			else{
				insert_rec=false;
			}

			if(insert_rec){

					int fld=1;
					for (int j=0;j<insertDataHdr.size() ;j++ ){
								pstmt_insert_hdr.setString(fld,(String)insertDataHdr.get(j));
								//System.err.println((String)insertDataHdr.get(j));
							fld++;
					}

					int result_insert= pstmt_insert_hdr.executeUpdate();
						if(result_insert > 0 ){
						insert_rec=true;
					}
					else{
						insert_rec=false;
					}
				}
			//}

			if(insert_rec){
				pstmt_insert_dtl = connection.prepareStatement( SQL_SS_WASHING_INSERT_DTL ) ;
				// clear the batch
				pstmt_insert_dtl.clearBatch();
				for (int i=0;i<insertDataDtl.size() ;i++ ){
					insertRecords=new ArrayList();
					insertRecords=(ArrayList)insertDataDtl.get(i);
					int fld=1;
						for (int j=0;j<insertRecords.size() ;j++ ){
							pstmt_insert_dtl.setString(fld,(String)insertRecords.get(j));
								//System.err.println((String)insertRecords.get(j));
						fld++;
						}
						// add the statement to the batch
					pstmt_insert_dtl.addBatch();
				}
				int[] result_dtl= pstmt_insert_dtl.executeBatch();
					for (int i=0;i<result_dtl.length ;i++ ){
						if(result_dtl[i]<0  && result_dtl[i] != -2 ){
							insert_rec=false;
							break;
						}
						else{
							//messages.append("insert_rec"+i);
							insert_rec=true;
						}
				  }
			}
			String status="WE";
			if(((String)insertDataHdr.get(4)).equals("Y"))
				status="WC";
			else
				status="WE";

			if(insert_rec){
				pstmt_insert_rof_dtl = connection.prepareStatement( SQL_SS_WASHING_ROF_UPDATE ) ;
				// clear the batch
				pstmt_insert_rof_dtl.clearBatch();
				for (int i=0;i<insertDataDtl.size() ;i++ ){
					insertRecords=new ArrayList();
					insertRecords=(ArrayList)insertDataDtl.get(i);

							pstmt_insert_rof_dtl.setString(1,status);
							pstmt_insert_rof_dtl.setString(2,(String)insertRecords.get(3));
							pstmt_insert_rof_dtl.setString(3,(String)insertRecords.get(4));
							pstmt_insert_rof_dtl.setString(4,(String)insertRecords.get(5));
							pstmt_insert_rof_dtl.setString(5,(String)insertRecords.get(6));
							pstmt_insert_rof_dtl.setString(6,(String)insertRecords.get(7));

					pstmt_insert_rof_dtl.addBatch();
				}
				int[] result_dtl= pstmt_insert_rof_dtl.executeBatch();
					for (int i=0;i<result_dtl.length ;i++ ){
						if(result_dtl[i]<0  && result_dtl[i] != -2 ){
							insert_rec=false;
							break;
						}
						else{
							insert_rec=true;
						}
				  }
			}
			int rs=0;
			if(insert_rec ){
				pstmt_update = connection.prepareStatement( SQL_SS_WASHING_LOADNO_UPDATE ) ;
				for (int i=0;i<updateData.size() ;i++ )
						pstmt_update.setString(1,(String)updateData.get(i));
						rs=pstmt_update.executeUpdate();
						if(rs>0)
							insert_rec=true;
						else
							insert_rec=false;

			}


			if(insert_rec ){
				debug="Load No: "+(String)insertDataHdr.get(2).toString();
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_INSERTED" ) ;
			}
			else{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				//throw new EJBException("Insert/Update Failed");
			}
		}
		catch( Exception e ) {
			try{
				connection.rollback();
				//throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
				//throw new EJBException( e.getMessage() ) ;
			}
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {

				closeStatement( pstmt_insert_hdr ) ;
				closeStatement( pstmt_insert_dtl ) ;
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_insert_rof_dtl ) ;

				//closeConnection( connection,(Properties)tabData.get( "properties" ) ); //commented for 15756
				closeConnection(connection, properties);//added for 15756 
			} catch ( Exception fe ) {
				//System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag", debug ) ;
		return map ;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


		public HashMap modify( HashMap tabData, HashMap sqlMap ) {

			System.err.println("##$#$   ejb modify sqlMap="+sqlMap);
			System.err.println("##$#$   ejb modify tabData="+tabData);
	HashMap map = new HashMap() ;
	String debug = null;
	Properties	properties	=	null;
	////System.err.println("1");
	StringBuffer messages = new StringBuffer() ;
	Connection connection = null ;
	PreparedStatement pstmt_delete_dtl = null ;
	PreparedStatement pstmt_delete_hdr = null ;
	PreparedStatement pstmt_update_hdr = null ;
	PreparedStatement pstmt_update_dtl = null ;
	ArrayList deleteDataDtl = new ArrayList() ;
	ArrayList updateDataHdrDtl = new ArrayList() ;
	ArrayList deleteDataRows= null ;

	final String SQL_SS_WASHING_DELETE_DTL = (String) sqlMap.get( "SQL_SS_WASHING_DELETE_DTL" );
	final String SQL_SS_WASHING_UPDATE_HDR = (String) sqlMap.get( "SQL_SS_WASHING_UPDATE_HDR" );
	final String SQL_SS_WASHING_UPDATE_DTL = (String) sqlMap.get( "SQL_SS_WASHING_UPDATE_DTL" );
	////System.err.println("2");
		deleteDataDtl=(ArrayList)tabData.get("DeleteDataDtl");
		updateDataHdrDtl=(ArrayList)tabData.get("UpdateDataHdrDtl");

		boolean delete_rec=false;
		boolean insert_rec=false;
		try{
			properties			=	(Properties)	tabData.get("properties");
			connection			=	getConnection(properties);

			if(deleteDataDtl.size()>0  ){
				delete_rec=true;
			}
			else{
				delete_rec=false;
			}
//System.err.println("delete_rec"+delete_rec);
			//if(((String)updateDataHdrDtl.get(0)).equals("N")){
				if(delete_rec){//System.err.println("4");
					pstmt_delete_dtl = connection.prepareStatement( SQL_SS_WASHING_DELETE_DTL ) ;
					pstmt_delete_dtl.clearBatch();

					for (int i=0;i<deleteDataDtl.size() ;i++ ){//System.err.println("5");
						deleteDataRows = new ArrayList() ;
						deleteDataRows=(ArrayList)deleteDataDtl.get(i);
						int fld=1;
							for (int j=0;j<deleteDataRows.size() ;j++ ){//System.err.println("6");
								pstmt_delete_dtl.setString(fld,(String)deleteDataRows.get(j));
									//System.err.println((String)deleteDataRows.get(j));
							fld++;
							}
							// add the statement to the batch
						pstmt_delete_dtl.addBatch();
					}
					int[] result_dtl= pstmt_delete_dtl.executeBatch();
						for (int i=0;i<result_dtl.length ;i++ ){
							if(result_dtl[i]<0  && result_dtl[i] != -2 ){
								delete_rec=false;
								break;
							}
							else{
								delete_rec=true;
							}
					  }
				}
			//}
			System.err.println("=================updateDataHdrDtl="+(String)updateDataHdrDtl.get(0));
			if(((String)updateDataHdrDtl.get(0)).equals("Y")){
				pstmt_update_hdr = connection.prepareStatement( SQL_SS_WASHING_UPDATE_HDR ) ;
				pstmt_update_hdr.setString(1,(String)updateDataHdrDtl.get(1));
				pstmt_update_hdr.setString(2,(String)updateDataHdrDtl.get(2));
				int rs=pstmt_update_hdr.executeUpdate();
					if(rs>0)
						insert_rec=true;
					else
						insert_rec=false;


					if(insert_rec){

					pstmt_update_dtl = connection.prepareStatement( SQL_SS_WASHING_UPDATE_DTL ) ;
					pstmt_update_dtl.setString(1,(String)updateDataHdrDtl.get(3));
					pstmt_update_dtl.setString(2,(String)updateDataHdrDtl.get(4));
					pstmt_update_dtl.setString(3,(String)updateDataHdrDtl.get(5));
					pstmt_update_dtl.setString(4,(String)updateDataHdrDtl.get(1));
					pstmt_update_dtl.setString(5,(String)updateDataHdrDtl.get(2));
					int rs1=pstmt_update_dtl.executeUpdate();
					if(rs1>0)
						insert_rec=true;
					else
						insert_rec=false;
					}
			}
System.err.println("######## delete_rec="+delete_rec+" ^^^^ insert_rec="+insert_rec);
			if(delete_rec || insert_rec ){
				//System.err.println("washing bean deletion completed");
				//System.err.println("delete_rec"+delete_rec);
				//System.err.println("insert_rec"+insert_rec);
				//debug="Load No: "+(String)insertDataHdr.get(2).toString();
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_MODIFIED" ) ;
			}
			else{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				//throw new EJBException("Insert/Update Failed");
			}
		}
		catch( Exception e ) {
			try{
				connection.rollback();
				//throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
				//throw new EJBException( e.getMessage() ) ;
			}
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {

				closeStatement( pstmt_delete_hdr ) ;
				closeStatement( pstmt_delete_dtl ) ;
				closeStatement( pstmt_update_hdr ) ;
				closeStatement( pstmt_update_dtl) ;

				//closeConnection( connection,(Properties)tabData.get( "properties" ) );////commented for 15756
				closeConnection( connection,properties );//added for 15756 
			} catch ( Exception fe ) {
				//System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag", debug ) ;
		return map ;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap tabData, HashMap sqlMap ) {

	HashMap map = new HashMap() ;
	ArrayList deleteDataDtl = new ArrayList() ;
	ArrayList deleteDataHdr = new ArrayList() ;
	ArrayList deleteDataRows= null ;

	String debug="";
	StringBuffer messages = new StringBuffer() ;

	Properties properties=null;
	Connection connection = null ;
	PreparedStatement pstmt_delete_dtl = null ;
	PreparedStatement pstmt_delete_hdr = null ;

	final String SQL_SS_WASHING_DELETE_DTL = (String) sqlMap.get( "SQL_SS_WASHING_DELETE_DTL" );
	final String SQL_SS_WASHING_DELETE_HDR = (String) sqlMap.get( "SQL_SS_WASHING_DELETE_HDR" );

	deleteDataDtl=(ArrayList)tabData.get("DeleteDataDtl");
	deleteDataHdr=(ArrayList)tabData.get("DeleteDataHdr");

	boolean delete_rec=false;

		try{
			properties			=	(Properties)	tabData.get("properties");
			connection			=	getConnection(properties);
			pstmt_delete_dtl = connection.prepareStatement( SQL_SS_WASHING_DELETE_DTL ) ;

			if(deleteDataDtl.size()>0  && deleteDataHdr.size()>0){
				delete_rec=true;
			}
			else{
				delete_rec=false;
			}

			pstmt_delete_dtl.clearBatch();
			if(delete_rec){
				for (int i=0;i<deleteDataDtl.size() ;i++ ){
					deleteDataRows = new ArrayList() ;
					deleteDataRows=(ArrayList)deleteDataDtl.get(i);
					int fld=1;
						for (int j=0;j<deleteDataRows.size() ;j++ ){
							pstmt_delete_dtl.setString(fld,(String)deleteDataRows.get(j));
								//System.err.println((String)deleteDataRows.get(j));
						fld++;
						}
						// add the statement to the batch
					pstmt_delete_dtl.addBatch();
				}
				int[] result_dtl= pstmt_delete_dtl.executeBatch();
					for (int i=0;i<result_dtl.length ;i++ ){
						if(result_dtl[i]<0  && result_dtl[i] != -2 ){
							delete_rec=false;
							break;
						}
						else{
							delete_rec=true;
						}
				  }
			}
			if(delete_rec){
			pstmt_delete_hdr=connection.prepareStatement( SQL_SS_WASHING_DELETE_HDR ) ;

			for (int i=0;i<deleteDataHdr.size() ;i++ ){
					deleteDataRows = new ArrayList() ;
					pstmt_delete_hdr.setString(1,(String)deleteDataHdr.get(0));
					pstmt_delete_hdr.setString(2,(String)deleteDataHdr.get(1));

			}

			int rs_delete_hdr=pstmt_delete_hdr.executeUpdate();
			if(rs_delete_hdr>0)
				delete_rec=true;
			else
				delete_rec=false;
			}
		System.out.println("delete_rec===========>"+delete_rec);
			if(delete_rec ){
				
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_DELETED" ) ;
			}
			else{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				//throw new EJBException("Insert/Update Failed");
			}

	}
		catch( Exception e ) {
			try{
				System.out.println("its in catch==========>");
				connection.rollback();
				//throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
				//throw new EJBException( e.getMessage() ) ;
			}
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {

				closeStatement( pstmt_delete_hdr ) ;
				closeStatement( pstmt_delete_dtl ) ;

				//closeConnection( connection,(Properties)tabData.get( "properties" ) );
				closeConnection(connection, properties);//COMMON-ICN-0119
			} catch ( Exception fe ) {
				//System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		//System.err.println("messages"+messages);
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag", debug ) ;
		System.out.println("map===in ejb========>"+map);
		return map ;
	}

}
