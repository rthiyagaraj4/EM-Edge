/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.ReconstituentFluid ;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;



/**
*
* @ejb.bean
*	name="ReconstituentFluid"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ReconstituentFluid"
*	local-jndi-name="ReconstituentFluid"
*	impl-class-name="ePH.ReconstituentFluid.ReconstituentFluidManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.ReconstituentFluid.ReconstituentFluidLocal"
*	remote-class="ePH.ReconstituentFluid.ReconstituentFluidRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.ReconstituentFluid.ReconstituentFluidLocalHome"
*	remote-class="ePH.ReconstituentFluid.ReconstituentFluidHome"
*	generate= "local,remote"
*
*
*/ 
public class ReconstituentFluidManager extends PhEJBSessionAdapter {

	Properties prop=null;

	
	// insert method starts here
 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		StringBuffer messages = new StringBuffer() ;
		StringBuffer debug = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;			

		String SQL_PH_RECONSTITUENT_FLUID_INSERT			=	"";
		String SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT		=	"";

		prop  = (Properties)tabData.get( "properties" );			            
		String  login_by_id			= (String)tabData.get("login_by_id");
		String	login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String	login_facility_id	= (String)tabData.get("login_facility_id");

		ArrayList CommonData		= (ArrayList)tabData.get("CommonData");
		String	rf_id			= (String)CommonData.get(0);
		String	rf_name			= (String)CommonData.get(1);
		String	rf_base_uom		= (String)CommonData.get(2);
		String Im_module_yn		= (String)CommonData.get(3);	

		SQL_PH_RECONSTITUENT_FLUID_INSERT	= (String) sqlMap.get( "SQL_PH_RECONSTITUENT_FLUID_INSERT" );

		if(Im_module_yn.equals("1"))
		SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT = (String) sqlMap.get( "SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT" );


		debug.append( " rf_id:"+rf_id);
		debug.append( " rf_name:"+rf_name);
		debug.append( " rf_base_uom:"+rf_base_uom);

		ArrayList MultipleData		= (ArrayList)tabData.get("MultipleData");

		Connection connection = null ;
		PreparedStatement pstmt_insert1=null,pstmt_insert2 = null ;
		try{
			connection = getConnection( prop ) ;
			pstmt_insert1 = connection.prepareStatement( SQL_PH_RECONSTITUENT_FLUID_INSERT ) ;

			if(Im_module_yn.equals("1"))
			pstmt_insert2 = connection.prepareStatement( SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT ) ;


			pstmt_insert1.setString(1,rf_id.trim());
			pstmt_insert1.setString(2,rf_name.trim());
			pstmt_insert1.setString(3,rf_base_uom.trim());
			pstmt_insert1.setString(4,login_by_id.trim());
			pstmt_insert1.setString(5,login_at_ws_no.trim());
			pstmt_insert1.setString(6,login_facility_id.trim());
			pstmt_insert1.setString(7,login_by_id.trim());
			pstmt_insert1.setString(8,login_at_ws_no.trim());
			pstmt_insert1.setString(9,login_facility_id.trim());
			int result1	=	pstmt_insert1.executeUpdate();

			if(result1!=0) {

			if(Im_module_yn.equals("1")) {
			for (int i=0;i<MultipleData.size() ;i++ ){
				
				ArrayList dataRow = (ArrayList)MultipleData.get(i);
				
				String item_code	= (String)dataRow.get(0);
				String content_in_base_uom	= (String)dataRow.get(1);

				
				if (item_code==null || item_code.equals("")|| item_code.equals("null") )
				{
					continue; 
				}
				
				debug.append( " rf_id:"+rf_id);
				debug.append( " item_code:"+item_code);
				debug.append( " content_in_base_uom:"+content_in_base_uom);

					pstmt_insert2.setString(1,rf_id.trim());
					pstmt_insert2.setString(2,item_code.trim());
					pstmt_insert2.setString(3,content_in_base_uom.trim());
					pstmt_insert2.setString(4,login_by_id.trim());
					pstmt_insert2.setString(5,login_at_ws_no.trim());
					pstmt_insert2.setString(6,login_facility_id.trim());
					pstmt_insert2.setString(7,login_by_id.trim());
					pstmt_insert2.setString(8,login_at_ws_no.trim());
					pstmt_insert2.setString(9,login_facility_id.trim());
					pstmt_insert2.addBatch();			
			}
			
				int[] result2= pstmt_insert2.executeBatch();
				for (int i=0;i<result2.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					debug.append("Source::Result:"+result2[i]);
					if(result2[i]<0  && result2[i] != -2 ){
						pstmt_insert2.cancel();
						throw new EJBException("Insert Failed");
					}			
				}
			}
			
			}
			else{
				map.put("flag","exception");
				throw new EJBException("Failed in Reconstituent Insert 1");
			}

			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
			connection.commit();
		}catch( Exception e ) {
			try{
				connection.rollback();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				closeConnection( connection,prop );
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag",debug.toString());
		return map ;
	}
// insert method ends here

//  modify method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {

	System.err.println("ReconsFluid:Inside remote modify");
	
		StringBuffer messages = new StringBuffer() ;
		StringBuffer debug = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;			

		String SQL_PH_RECONSTITUENT_FLUID_UPDATE				=	"";
		String SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT		=	"";
		String SQL_PH_RECONSTITUENT_FLUID_DTL_DELETE="";

		prop  = (Properties)tabData.get( "properties" );			            
		String  login_by_id			= (String)tabData.get("login_by_id");
		String	login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String	login_facility_id	= (String)tabData.get("login_facility_id");

		ArrayList CommonData		= (ArrayList)tabData.get("CommonData");
		String	rf_id			= (String)CommonData.get(0);
		String	rf_name			= (String)CommonData.get(1);
		String	rf_base_uom		= (String)CommonData.get(2);
		String Im_module_yn		= (String)CommonData.get(3);	
		
		
		SQL_PH_RECONSTITUENT_FLUID_UPDATE	= (String) sqlMap.get( "SQL_PH_RECONSTITUENT_FLUID_UPDATE" );

		if(Im_module_yn.equals("1"))
		{
			SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT = (String) sqlMap.get( "SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT" );
			SQL_PH_RECONSTITUENT_FLUID_DTL_DELETE = (String) sqlMap.get( "SQL_PH_RECONSTITUENT_FLUID_DTL_DELETE" );
		}


		debug.append( " rf_id:"+rf_id);
		debug.append( " rf_name:"+rf_name);
		debug.append( " rf_base_uom:"+rf_base_uom);

		ArrayList MultipleData		= (ArrayList)tabData.get("MultipleData");
		
		Connection connection = null ;
		PreparedStatement pstmt_insert1=null,pstmt_insert2 = null ,pstmt_delete=null;
		try{
			connection = getConnection( prop ) ;
			//connection=getConnection();
			
			pstmt_insert1 = connection.prepareStatement( SQL_PH_RECONSTITUENT_FLUID_UPDATE ) ;
	
			pstmt_insert1.setString(1,rf_name.trim());
			pstmt_insert1.setString(2,rf_base_uom.trim());
			pstmt_insert1.setString(3,login_by_id.trim());
			pstmt_insert1.setString(4,login_at_ws_no.trim());
			pstmt_insert1.setString(5,login_facility_id.trim());
			pstmt_insert1.setString(6,rf_id.trim());
			int result1	=	pstmt_insert1.executeUpdate();
			System.err.println("After update of recons fluid:"+result1);

			if(result1!=0) {


			if(Im_module_yn.equals("1")) {
				pstmt_delete = connection.prepareStatement( SQL_PH_RECONSTITUENT_FLUID_DTL_DELETE ) ;
				pstmt_delete.setString(1,rf_id.trim());

			//	int result3	=	pstmt_delete.executeUpdate(); unused local variable 63877 //COMMENTED FOR COMMON-ICN-0048
				pstmt_delete.executeUpdate();//altered above stement unused local variable 63877


				pstmt_insert2 = connection.prepareStatement( SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT ) ;
	
			for (int i=0;i<MultipleData.size() ;i++ ){
				
				ArrayList dataRow = (ArrayList)MultipleData.get(i);
				
				String item_code	= (String)dataRow.get(0);
				String content_in_base_uom	= (String)dataRow.get(1);

				if (item_code==null || item_code.equals("")|| item_code.equals("null") )
				{
					continue; 
				}
				//rtn_ord_disp_locn_code will be null only if routing_level is source
				
				debug.append( " rf_id:"+rf_id);
				debug.append( " item_code:"+item_code);
				debug.append( " content_in_base_uom:"+content_in_base_uom);

					pstmt_insert2.setString(1,rf_id.trim());
					pstmt_insert2.setString(2,item_code.trim());
					pstmt_insert2.setString(3,content_in_base_uom.trim());
					pstmt_insert2.setString(4,login_by_id.trim());
					pstmt_insert2.setString(5,login_at_ws_no.trim());
					pstmt_insert2.setString(6,login_facility_id.trim());
					pstmt_insert2.setString(7,login_by_id.trim());
					pstmt_insert2.setString(8,login_at_ws_no.trim());
					pstmt_insert2.setString(9,login_facility_id.trim());
					pstmt_insert2.addBatch();			
			}
				int[] result2= pstmt_insert2.executeBatch();
				for (int i=0;i<result2.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					debug.append("Source::Result:"+result2[i]);
					if(result2[i]<0  && result2[i] != -2 ){
						pstmt_insert2.cancel();
						//throw new EJBException("Modify Failed");
					}			
				}
					

			

			}
			
			}
			else{
				map.put("flag","exception");
				//throw new EJBException("Failed in Reconstituent Modify");
			}

			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
			connection.commit();
		}catch( Exception e ) {
			try{
				connection.rollback();
				//throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				closeStatement( pstmt_delete ) ;
				closeConnection( connection,prop );
			//	closeConnection(connection);
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag",debug.toString());
		return map ;
		
		}

	// delete method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
public HashMap delete( HashMap tabData, HashMap sqlMap )  {

//		String debug = "";
//		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
/*

		Properties  prop  = (Properties)tabData.get( "properties" );			            
		ArrayList DeleteData = (ArrayList)tabData.get("DeleteData");
		String ordering_facility_id = "";
		String ordering_source_type = "";
		String ordering_source_code = "";
		String routing_level = "";      
		String routing_code = "";       
		Connection connection = null ;
		PreparedStatement pstmt_delete=null;
		try{
			connection = getConnection( prop ) ;
			debug = debug + "Size::"+DeleteData.size();
			if (DeleteData.size()==3){
				ordering_facility_id = (String)DeleteData.get(0);
				ordering_source_type = (String)DeleteData.get(1);
				ordering_source_code = (String)DeleteData.get(2);
				final String SQL_PH_ORDER_ROUTING_DELETE = (String) sqlMap.get( "DeleteSQL" );
				pstmt_delete = connection.prepareStatement( SQL_PH_ORDER_ROUTING_DELETE ) ;
				pstmt_delete.setString(1,ordering_facility_id.trim());
				pstmt_delete.setString(2,ordering_source_type.trim());
				pstmt_delete.setString(3,ordering_source_code.trim());
				debug  = debug+" SOURCE:::";
				debug  = debug+" ordering_facility_id:"+ordering_facility_id;
				debug  = debug+" ordering_source_type:"+ordering_source_type;
				debug  = debug+" ordering_source_code:"+ordering_source_code;

			}else {		
				ordering_facility_id = (String)DeleteData.get(0);
				ordering_source_type = (String)DeleteData.get(1);
				ordering_source_code = (String)DeleteData.get(2);
				routing_level		 = (String)DeleteData.get(3);
				routing_code		 = (String)DeleteData.get(4);
				final String SQL_PH_ORDER_ROUTING_DTL_DELETE = (String) sqlMap.get( "DeleteSQL" );
				pstmt_delete = connection.prepareStatement( SQL_PH_ORDER_ROUTING_DTL_DELETE ) ;
				pstmt_delete.setString(1,ordering_facility_id.trim());
				pstmt_delete.setString(2,ordering_source_type.trim());
				pstmt_delete.setString(3,ordering_source_code.trim());
				pstmt_delete.setString(4,routing_level.trim());
				pstmt_delete.setString(5,routing_code.trim());

				debug  = debug+" OTHER THAN SOURCE:::";
				debug  = debug+" ordering_facility_id:"+ordering_facility_id;
				debug  = debug+" ordering_source_type:"+ordering_source_type;
				debug  = debug+" ordering_source_code:"+ordering_source_code;
				debug  = debug+" routing_level:"+routing_level;
				debug  = debug+" routing_code:"+routing_code;
			}			
			int result = pstmt_delete.executeUpdate();
			debug += " RESULT::"+result;
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_DELETED" ) ;
			connection.commit();
		}catch(Exception e){
			map.put( "result", new Boolean( false ) ) ;
			System.out.println(e);
			messages.append(e);
			try{
				connection.rollback();
			}catch(Exception ee){
				map.put( "result", new Boolean( false ) ) ;
				messages.append(e);
				ee.printStackTrace();
			}
		}finally {
			try {
				closeStatement( pstmt_delete ) ;
				closeConnection( connection,prop );
			} catch ( Exception fe ) {
				map.put( "result", new Boolean( false ) ) ;
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
				messages.append(fe);
			}
		}
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag","0");*/
		return map ;
	}
	// delete method ends here
}
