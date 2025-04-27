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
02/09/2020              IN073882                Haribabu                                                  PH-Regression-MOHML-Alt. Disp. Location
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package ePH.AlternateDispLocn ;
import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList ;
import java.util.Properties ;
import java.sql.* ;

import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="AlternateDispLocn"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AlternateDispLocn"
*	local-jndi-name="AlternateDispLocn"
*	impl-class-name="ePH.AlternateDispLocn.AlternateDispLocnManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.AlternateDispLocn.AlternateDispLocnLocal"
*	remote-class="ePH.AlternateDispLocn.AlternateDispLocnRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.AlternateDispLocn.AlternateDispLocnLocalHome"
*	remote-class="ePH.AlternateDispLocn.AlternateDispLocnHome"
*	generate= "local,remote"
*
*
*/

public class AlternateDispLocnManager extends PhEJBSessionAdapter {
  

  /**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert( HashMap tabData, HashMap sqlMap ) {
		return updateTable( tabData, sqlMap ) ;
	}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		return updateTable( tabData, sqlMap ) ;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap tabData, HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		return map;		
	}


	private HashMap updateTable( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		Connection connection = null ;
		String frmtime="";
		String totime="";
		PreparedStatement pstmt_insert = null ;
		PreparedStatement pstmt_update = null ;
		int insert_record1=0;
	    int insert_flag=0;
		//int update_flag=0;
		int res=0;
		try {
			HashMap commonData		= (HashMap)tabData.get( "COMMONDATA" );
			ArrayList insertData	= (ArrayList)tabData.get( "INSERTDATA" ) ;
			connection = getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;
			pstmt_insert = connection.prepareStatement( (String) sqlMap.get( "INSERTSQL" ) ) ;
			pstmt_update= connection.prepareStatement( (String) sqlMap.get( "UPDATESQL" ) ) ; 	
			System.out.println(" ========= Debug Message @Line 91 ============"+commonData);
			String ord_fcy_id=(String)commonData.get("ord_fcy_id");
			String ord_src_type=(String)commonData.get("ord_src_type");
			String order_src_locn=(String)commonData.get("order_src_locn");
			String perform_fcy_id=(String)commonData.get("perform_fcy_id");
			String disp_locn_code=(String)commonData.get("disp_locn_code");
			String day_type=(String)commonData.get("day_type");
			String routing_level=(String)commonData.get("routing_level");
			String routing_code=(String)commonData.get("routing_code")==null?"":(String)commonData.get("routing_code");
			if(routing_code.equals("")){routing_code="*A";}
			String priority=(String)commonData.get("priority");
		
			if(insertData.size()>0) 
			{   
				pstmt_update.setString(1, ord_fcy_id);
				pstmt_update.setString(2, ord_src_type);
				pstmt_update.setString(3, order_src_locn);
				pstmt_update.setString(4, perform_fcy_id);
				pstmt_update.setString(5, disp_locn_code);
				pstmt_update.setString(6, day_type);
				pstmt_update.setString(7, priority);
				pstmt_update.setString(8, routing_level);
				pstmt_update.setString(9, routing_code);
				System.out.println(" ========= Debug Message @Line 114 ============");
				try 
				{
					res=pstmt_update.executeUpdate();					
				}catch(Exception e) {
					e.printStackTrace();
				}
				if(res!=0)
				{
					map.put( "result", new Boolean( true ) ) ;
					map.put( "msgid", "RECORD_MODIFIED" ) ;
					map.put( "flag", "0" ) ;
					connection.commit();
				}
				//Modified (commentted) for IN:073882 start
				//else
					//connection.rollback();
				//Modified (commentted) for IN:073882 end
				HashMap record=new HashMap();
				for(int i=0;i<insertData.size();i++)
				{	
					record	=(HashMap)insertData.get((i));
					System.out.println(" ========= Debug Message @Line 134 ============"+record);
					String flag=(String)record.get("flag");
					String code=(String)record.get("code");
					frmtime=(String)record.get("frmtime");
					totime=(String)record.get("totime");
					String eff_status=(String)record.get("eff_status");
				/*	if(flag.equals("U") ||flag.equals("Y") )  
					{
						pstmt_update.setString(1, (String)commonData.get( "login_by_id" ));
						pstmt_update.setString(2, (String)commonData.get( "login_at_ws_no" ));
						pstmt_update.setString(3, (String)commonData.get( "login_facility_id" ));
						pstmt_update.setString(4, frmtime);
						pstmt_update.setString(5, totime);
						pstmt_update.setString(6, eff_status);
						pstmt_update.setString(7, disp_locn_code);
						pstmt_update.setString(8, perform_fcy_id);
						pstmt_update.setString(9, order_src_locn);
						pstmt_update.setString(10, ord_src_type);	
						pstmt_update.setString(11, ord_fcy_id);
						pstmt_update.setString(12, code);
						pstmt_update.setString(13, day_type);
				    	
				 		update_flag++;    	 
						res=0;
						try {
							res=pstmt_update.executeUpdate();
						}catch(Exception e) {
							e.printStackTrace();
						}

						if(res!=0)
						{
							map.put( "result", new Boolean( true ) ) ;
							map.put( "msgid", "RECORD_MODIFIED" ) ;
							map.put( "flag", "0" ) ;
							connection.commit();
						}
						else
							connection.rollback();
					}
				*/

					if(flag.equals("I") && !frmtime.equals("") && !totime.equals("") ){
						System.out.println(" ========= Debug Message @Line 177 ============");
						pstmt_insert.setString(1, ord_fcy_id);
						pstmt_insert.setString(2, ord_src_type);
						pstmt_insert.setString(3, order_src_locn);
						pstmt_insert.setString(4, perform_fcy_id);
						pstmt_insert.setString(6, code);
						pstmt_insert.setString(5, disp_locn_code);
						pstmt_insert.setString(7, day_type);
						pstmt_insert.setString(8, (String)commonData.get( "login_by_id" ));
						pstmt_insert.setString(9, (String)commonData.get( "login_at_ws_no" ));
						pstmt_insert.setString(10, (String)commonData.get( "login_facility_id" ));
						pstmt_insert.setString(11, (String)commonData.get( "login_by_id" ));
						pstmt_insert.setString(12, (String)commonData.get( "login_at_ws_no" ));
						pstmt_insert.setString(13, (String)commonData.get( "login_facility_id" ));
						pstmt_insert.setString(14, frmtime);
						pstmt_insert.setString(15, totime);
						pstmt_insert.setString(16, eff_status);
						pstmt_insert.setString(17, priority);
						pstmt_insert.setString(18, routing_level);
						pstmt_insert.setString(19, routing_code);
						pstmt_insert.addBatch();		
						System.out.println(" ========= Debug Message @Line 198 ============");
						insert_flag++;
					}				      					
				}
			}
			
			if (insert_flag>0) {
	            try {
					int	 result1[]=pstmt_insert.executeBatch();
					for(int i=0;i<result1.length;i++){
						 if(result1[i]<0 && result1[i]!=-2){
							insert_record1=2;
							break;
						}
						else{
							insert_record1=1;
						}	
				    }
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
			if((insert_record1==1) && (res==0)) insert_record1=1;
			if((insert_record1==0) && (res!=0)) insert_record1=1;
   
			if(insert_record1==1 ) {
				connection.commit();
				map.put( "result", new Boolean( true) ) ;
				map.put("msgid","RECORD_INSERTED");
				map.put("flag","0");
			} else {
				map.put( "result", new Boolean( false) ) ;
				//map.put("msgid","Atleast one record should be selected");
				map.put("msgid","PH_ATLEAST_ONE_SELECTED");
				map.put("flag","");
				connection.rollback();
			}	
		}catch ( Exception e ){				
			System.err.println( "ERROR LOADING VALUES TO THE DATABASE===========" ) ;
			System.out.println(" ========= Debug Message @Line 238 ============"+e);
			e.printStackTrace() ;
		}
		finally {
			try{
			 closeStatement(pstmt_update);
				closeStatement( pstmt_insert) ;
				closeConnection( connection, (Properties)tabData.get( "PROPERTIES" ) );
				
			}catch(Exception es){ es.printStackTrace();	}
		}
		return map;
	}

}
