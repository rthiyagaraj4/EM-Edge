/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Module		 : ePH
	Function	 : MedicalItem
	Class Name	 : MedicalItemManager.java
	Created Date : 12-04-2007
	Created By	 : Surendra Reddy.k
	Modified By	 :
	Modified Date:
	Version		 : 10.2.1
	Description  : 				  
*/
//saved on 12-04-2007
package ePH.MedicalItem;
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
*	name="MedicalItem"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="MedicalItem"
*	local-jndi-name="MedicalItem"
*	impl-class-name="ePH.MedicalItem.MedicalItemManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.MedicalItem.MedicalItemLocal"
*	remote-class="ePH.MedicalItem.MedicalItemRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.MedicalItem.MedicalItemLocalHome"
*	remote-class="ePH.MedicalItem.MedicalItemHome"
*	generate= "local,remote"
*
*
*/

public class MedicalItemManager extends PhEJBSessionAdapter {
	
              String drug_code ="";
			  String drug_desc ="";
			  String in_formulary_yn_value ="";
			  String link_to_existing_item="";
			  String item_code="";
			  String generic_id="";
			  String strength_value="";
			  String pres_base_uom1="";
			  String stock_uom="";
			  String Eqvlvalue="";
			  String DispenseAlternate="";
              String login_by_id="";
              String login_at_ws_no="";
              String login_facility_id="";
              String chk_opt="";
              int display_seq_no=1;
			  int Item_count=0;
              
              String trade_id="";
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
public HashMap insert( HashMap tabData, HashMap sqlMap ) {
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
			

		Connection connection						=	null ;
		PreparedStatement pstmt_insert				=	null ;
		Properties  prop							=	null;

        try {
			
			prop= (Properties)tabData.get( "properties" );
			ArrayList insertData   = (ArrayList) tabData.get("insertData");
			ArrayList trade	       = (ArrayList) tabData.get("trade");
		    drug_code =(String) insertData.get(0) ;
		    drug_desc =(String) insertData.get(1);
		    in_formulary_yn_value =(String) insertData.get(2) ;
		    link_to_existing_item=(String) insertData.get(3);
		    item_code=(String) insertData.get(4);
		    generic_id=(String) insertData.get(5);
		    strength_value=(String) insertData.get(6);
		    pres_base_uom1=(String) insertData.get(7);
		    stock_uom=(String) insertData.get(8);
		    Eqvlvalue=(String) insertData.get(9);
		    DispenseAlternate=(String) insertData.get(10);
		    DispenseAlternate=(String) insertData.get(11);
		    chk_opt=(String) insertData.get(12);
		    login_by_id=(String) insertData.get(13); 
		    login_at_ws_no=(String) insertData.get(14);
		    login_facility_id=(String) insertData.get(15); 
		    login_by_id=(String) insertData.get(16); 
		    login_at_ws_no=(String) insertData.get(17);
		    login_facility_id=(String) insertData.get(18);
						
			String sql_ph_drug_medical_item_insert	= (String) sqlMap.get( "SQL_PH_DRUG_MEDICAL_ITEM_INSERT");
			String sql_ph_trade_name_for_drug_insert	= (String) sqlMap.get( "SQL_PH_DRUG_MEDICAL_ITEM_TRADE_NAME_INSERT");
			
			
			connection = getConnection(prop) ;
			pstmt_insert			=	connection.prepareStatement( sql_ph_drug_medical_item_insert ) ;
			pstmt_insert.setString( 1,drug_code ) ;
			pstmt_insert.setString( 2,drug_desc ) ;
			pstmt_insert.setString( 3,in_formulary_yn_value ) ;
			pstmt_insert.setString( 4,link_to_existing_item) ;
			pstmt_insert.setString( 5,item_code) ;
			pstmt_insert.setString( 6,generic_id ) ;
			pstmt_insert.setString( 7,strength_value ) ;
			pstmt_insert.setString( 8,pres_base_uom1 ) ;
			pstmt_insert.setString( 9,stock_uom ) ;
			pstmt_insert.setString( 10,Eqvlvalue) ;
			pstmt_insert.setString( 11,DispenseAlternate) ;
			pstmt_insert.setString( 12,DispenseAlternate) ;
			pstmt_insert.setString( 13,chk_opt) ;
			pstmt_insert.setString( 14,login_by_id ) ;
			pstmt_insert.setString( 15,login_at_ws_no ) ;
			pstmt_insert.setString( 16,login_facility_id ) ;
			pstmt_insert.setString( 17,login_by_id ) ;
			pstmt_insert.setString( 18,login_at_ws_no ) ;
			pstmt_insert.setString( 19,login_facility_id ) ;
			int ph_drug_insert = pstmt_insert.executeUpdate() ;

			//System.err.println("ph_drug_insert------->"+ph_drug_insert);
			//connection.commit();

            if(ph_drug_insert!=0){
				closeStatement(pstmt_insert);

				pstmt_insert=null;
				pstmt_insert = connection.prepareStatement( sql_ph_trade_name_for_drug_insert ) ;
				//pstmt_insert.clearBatch();

				if(trade!=null && trade.size()>0){
						
                //System.err.println("come to for loop from ejb----->");

						for (int i=0;i<trade.size() ;i++ ){
							HashMap hh=new HashMap();
							hh=(HashMap) trade.get(i);
								pstmt_insert.setString( 1,drug_code ) ;					
								pstmt_insert.setString( 2, (String) hh.get("trade_id") );
								pstmt_insert.setString( 3,(String) hh.get("select") ) ;
								pstmt_insert.setInt( 4,display_seq_no) ;
								pstmt_insert.setString( 5,login_by_id ) ;
			                    pstmt_insert.setString( 6,login_at_ws_no ) ;
			                    pstmt_insert.setString( 7,login_facility_id ) ;
			                    pstmt_insert.setString( 8,login_by_id ) ;
			                    pstmt_insert.setString( 9,login_at_ws_no ) ;
			                    pstmt_insert.setString( 10,login_facility_id ) ;
								//int ph_trade_insert = pstmt_insert.executeUpdate() ;
			                    //System.err.println("ph_trade_insert------->"+ph_trade_insert);
							     pstmt_insert.addBatch();	
				
						}
						int[] ph_medical_insert= pstmt_insert.executeBatch();
					for (int i=0;i<ph_medical_insert.length ;i++ ){
						if(ph_medical_insert[i]<0  && ph_medical_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("Medical Insertion Failed");
						}
					}

					}
			      connection.commit();
			}
			else{
				map.put("flag","exception");
				throw new EJBException("Ph Drug Insertion Failed");
			}
			
			map.put( "result", new Boolean( true ) ) ;
			map.put("msgid","RECORD_INSERTED" ) ;
          		//System.err.println("map-insert---line 182---->"+map);
		}catch(Exception e)
		{
			

         try{
				
				map.put("flag",e.toString());
				map.put( "msgid", e.toString() ) ;
				connection.rollback();
				e.printStackTrace();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
				ee.printStackTrace();
			}

		
		}
		finally {
			//map.put( "msgid", messages.toString() ) ;
			try {
				closeStatement( pstmt_insert ) ;
				closeConnection( connection,prop );
			}
			catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

        map.put( "flag",messages.toString());
		//System.err.println("map-insert---line 215---->"+map);
		return map ;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {

		System.err.println("update method calling FROM EJB");
		Connection connection						=	null ;
		PreparedStatement pstmt_update				=	null ;
		ResultSet resultSet=null;
		//PreparedStatement pstmt_dflt_fluid_update	=	null ;
		Properties  prop					=	null;
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		
		try	{
			 prop= (Properties)tabData.get( "properties" );
			ArrayList mandatory_flds	= (ArrayList) tabData.get("mandatory_flds");
			ArrayList tradeValues	= (ArrayList) tabData.get("tradeValues");
           //System.err.println("tradeValues---ejb->"+tradeValues);
              drug_desc =(String) mandatory_flds.get(0) ;
			   in_formulary_yn_value =(String) mandatory_flds.get(1);
			   link_to_existing_item =(String) mandatory_flds.get(2) ;
			   item_code=(String) mandatory_flds.get(3);
			   generic_id=(String) mandatory_flds.get(4);
			   strength_value=(String) mandatory_flds.get(5);
			   pres_base_uom1=(String) mandatory_flds.get(6);
			   stock_uom=(String) mandatory_flds.get(7);
			   Eqvlvalue=(String) mandatory_flds.get(8);
			   DispenseAlternate=(String) mandatory_flds.get(9);
			   DispenseAlternate=(String) mandatory_flds.get(10);
			   chk_opt=(String) mandatory_flds.get(11);
			   login_by_id=(String) mandatory_flds.get(12); 
			   login_at_ws_no=(String) mandatory_flds.get(13);
			   login_facility_id=(String) mandatory_flds.get(14); 
			   drug_code=(String) mandatory_flds.get(15);
			  

          String sql_ph_drug_update					= (String) sqlMap.get( "SQL_PH_DRUG_MEDICAL_ITEM_UPDATE");
		  String sql_trade_update					= (String) sqlMap.get("SQL_PH_DRUG_MEDICAL_ITEM_TRADE_NAME_UPDATE"); 
		  String sql_ph_trade_name_for_drug_insert	= (String) sqlMap.get( "SQL_PH_DRUG_MEDICAL_ITEM_TRADE_NAME_INSERT");
		  String sql_ph_medical_item_trade_count	= (String) sqlMap.get( "SQL_PH_MEDICAL_ITEM_TRADE_COUNT1");

            connection = getConnection(prop) ;
			pstmt_update			=	connection.prepareStatement(sql_ph_drug_update ) ;
           
			pstmt_update.setString( 1,drug_desc ) ;
			pstmt_update.setString( 2,in_formulary_yn_value ) ;
			pstmt_update.setString( 3,link_to_existing_item) ;
			pstmt_update.setString( 4,item_code) ;
			pstmt_update.setString( 5,generic_id ) ;
			pstmt_update.setString( 6,strength_value );
			pstmt_update.setString( 7,pres_base_uom1);
			pstmt_update.setString( 8,stock_uom);
			pstmt_update.setString( 9,Eqvlvalue);
			
			pstmt_update.setString( 10,DispenseAlternate);
			pstmt_update.setString( 11,DispenseAlternate);
			pstmt_update.setString( 12,chk_opt);

			pstmt_update.setString( 13,login_by_id ) ;
			pstmt_update.setString( 14,login_at_ws_no ) ;
			pstmt_update.setString( 15,login_facility_id ) ;
			pstmt_update.setString( 16,drug_code ) ;
			int ph_drug_update = pstmt_update.executeUpdate() ;
            if(ph_drug_update!=0){
				closeStatement(pstmt_update);
				pstmt_update=null;

			for (int K=0;K<tradeValues.size() ;K++ ){
							HashMap hh=new HashMap();
							hh=(HashMap) tradeValues.get(K);
							trade_id=(String) hh.get("trade_id");
							//System.err.println("trade_id-----ejb->"+trade_id);
			
		  try{
		  pstmt_update				= connection.prepareStatement(sql_ph_medical_item_trade_count) ;
			pstmt_update.setString(1,drug_code);
			pstmt_update.setString(2,trade_id);
			//System.err.println("resultSet-----ejb->"+resultSet);
			resultSet	= pstmt_update.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
					 Item_count	=	resultSet.getInt("CNT");
					//System.err.println("Item_count-----from ejb-->"+Item_count);
			}
			closeResultSet( resultSet );     //common-icn-0029
			closeStatement( pstmt_update ) ; //common-icn-0029
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
 	    
          		 if(Item_count==1)
							{  
								 //System.err.println("if block");
							    pstmt_update = connection.prepareStatement( sql_trade_update ) ;
								pstmt_update.setString( 1, (String) hh.get("select") );
								pstmt_update.setString( 2,login_by_id ) ;
			                    pstmt_update.setString( 3,login_at_ws_no ) ;
			                    pstmt_update.setString( 4,login_facility_id ) ;
			                    pstmt_update.setString( 5, drug_code);
			                    pstmt_update.setString( 6,(String) hh.get("trade_id"));
								 pstmt_update.executeUpdate() ;
			                  //System.err.println("ph_trade_update---if---->"+ph_trade_update);
				            }
							else if(Item_count==0)
							{ 
								 //System.err.println("else block");
								pstmt_update = connection.prepareStatement(sql_ph_trade_name_for_drug_insert) ;
								pstmt_update.setString( 1,drug_code);
								pstmt_update.setString( 2,(String) hh.get("trade_id")) ;
								pstmt_update.setString( 3,(String) hh.get("select")) ;
			                    pstmt_update.setInt(4,display_seq_no ) ;
			                    pstmt_update.setString( 5,login_by_id ) ;
			                    pstmt_update.setString( 6,login_at_ws_no ) ;
			                    pstmt_update.setString( 7,login_facility_id ) ;
								pstmt_update.setString( 8,login_by_id ) ;
			                    pstmt_update.setString( 9,login_at_ws_no ) ;
			                    pstmt_update.setString( 10,login_facility_id ) ;
		                 
	    						 pstmt_update.executeUpdate() ;
			                 // System.err.println("ph_trade_update---else---->"+ph_trade_update);
				            

							}
				closeStatement( pstmt_update ) ;//3/21/2021		
					 connection.commit();
				  }
		      }
			else
			{
				map.put("flag","exception");
				throw new EJBException("PhDrug update Failed");
			}
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			map.put("msgid","RECORD_MODIFIED" ) ;

			//System.err.println("map------->"+map);
			
		}
	catch(Exception e){
		       try{
				map.put("flag",e.toString());
				map.put( "msgid", e.toString() ) ;
				connection.rollback();
				e.printStackTrace();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ){
				messages.append( ee.getMessage() ) ;
				ee.printStackTrace();
			}

		}
		finally{
			//map.put( "msgid", messages.toString() ) ;
			try{
				closeStatement( pstmt_update ) ;
				closeConnection( connection,prop );
				closeResultSet( resultSet );
			}
			catch( Exception fe ){
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
			//System.err.println("Map--line318----->"+map);
		return map ;
	}	
			
		
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		return map;
	}
}
