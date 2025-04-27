/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.ProductTransfer;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;//Added for ML-MMOH-CRF-0448 B.Badmavathi
import java.sql.ResultSet;//Added for ML-MMOH-CRF-0448 B.Badmavathi
import java.sql.Types;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="ProductTransferManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ProductTransfer"
*	local-jndi-name="ProductTransfer"
*	impl-class-name="eST.ProductTransfer.ProductTransferManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.ProductTransfer.ProductTransferLocal"
*	remote-class="eST.ProductTransfer.ProductTransferRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.ProductTransfer.ProductTransferLocalHome"
*	remote-class="eST.ProductTransfer.ProductTransferHome"
*	generate= "local,remote"
*
*
*/

public class ProductTransferManager extends StEJBSessionAdapter {

	HashMap hmData;
	HashMap hmSQL;
	HashMap	hmReturn;

	Connection	connection	=	null;
	Properties	properties	=	null;
	//String new_bin_location_code		= "";
	//String suspended_batch_allowed_yn	= "";

	//String adj_item_qty					= "";
   // String avl_item_qty					= "";

	//String login_by_id					= "";
	//String login_at_ws_no				= "";
   // String login_facility_id			= "";
   // String to_store_code				= "";
	String stSQL						= null;

	
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


 public HashMap modify(HashMap hmDataValues, HashMap hmSQLValues) //throws RemoteException
	 {
	  //Added for ML-MMOH-CRF-0448 B.Badmavathi
		hmData		= hmDataValues;
		hmSQL		= hmSQLValues;
		hmReturn	= new HashMap();		
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		CallableStatement callableStatement = null;

		hmReturn.put(RESULT,FALSE);

		try {


			properties			=	(Properties)hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);


			/* Insertion of the record in st_product_transfer_hdr BEGINS here */

			ArrayList alHdrData	=	(ArrayList<String>)hmData.get("HdrUpdateData");
			stSQL				=	(String)hmSQL.get("HdrUpdateSQL");
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	 update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
			
	        /* Insertion of the record in st_product_transfer_hdr ENDS here */



         /* Insertion of the FROM record in st_product_transfer_dtl BEGINS here */

         ArrayList alDtlFromData	=	(ArrayList)hmData.get("DtlUpdateDataFrom");
			stSQL				    =	(String)hmSQL.get("DtlUpdateSQL");

			hmArgData.put(DATA,alDtlFromData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			//try{
			    hmReturn	=	update(connection, hmArgData, hmArgSQL);
			    throwExceptionWhenFailed(hmReturn);
			   //}
		//	catch(Exception ex) { ex.printStackTrace(); }


        /* Insertion of the record in st_product_transfer_dtl ENDS here */



        /* Insertion of the TO record in st_product_transfer_dtl BEGINS here */

         ArrayList alDtlToData	=	(ArrayList)hmData.get("DtlUpdateDataTo");
			System.out.println("alDtlToData==mangr=>"   +alDtlToData);
			stSQL				    =	(String)hmSQL.get("DtlUpdateSQL");
			System.out.println("stSQL==mangr=>"   +stSQL);
			           
			hmArgData.put(DATA,alDtlToData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			//try{
			    hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			//   }
			//catch(Exception ex) { ex.printStackTrace(); }


        /* Insertion of the TO record in st_product_transfer_dtl ENDS here */


       /* Insertion of the FROM record in st_product_transfer_dtl_exp BEGINS here */

         ArrayList alDtlExpFromData	=	(ArrayList)hmData.get("DtlExpUpdateDataFrom");
			stSQL				        =	(String)hmSQL.get("DtlExpUpdateSQL");

			hmArgData.put(DATA,alDtlExpFromData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
        // try{
			    hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			  // }
			//catch(Exception ex) { ex.printStackTrace(); }


       /* Insertion of the TO record in st_product_transfer_dtl_exp ENDS here */

       /* Insertion of the TO record in st_product_transfer_dtl_exp BEGINS here */

      	 ArrayList alDtlExpToData	=	(ArrayList)hmData.get("DtlExpUpdateDataTo");
         stSQL  =	(String)hmSQL.get("DtlExpUpdateSQL");

			hmArgData.put(DATA,alDtlExpToData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
     //    try{
			    hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			 //  }
 	   // catch(Exception ex) { ex.printStackTrace(); }

       /* Insertion of the TO record in st_product_transfer_dtl_exp ENDS here */
				

       /* Updation for Requesyt Status in the ST_PROD_TFR_REQUEST_HDR table BEGINGs here */
				if(alHdrData.get(11).equals("Y"))
				  {	
			ArrayList	alRequestNo = new ArrayList();
			ArrayList	alRequestStatusdata = new ArrayList();
			String		requestno ="";

			alRequestNo	=	(ArrayList)	hmData.get("RequestNo");
			if (alRequestNo !=null && alRequestNo.size()>0 )
			{
				requestno =(String)alRequestNo.get(0);
			}
			alRequestStatusdata.add((String)alDtlExpToData.get(6));
			alRequestStatusdata.add((String)alDtlExpToData.get(7));
			alRequestStatusdata.add((String)alDtlExpToData.get(8));
			alRequestStatusdata.add(requestno);

			stSQL			=	(String)	hmSQL.get ("RequestStatusUpdateSQL");
			

			hmArgData.put(DATA,alRequestStatusdata);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			/* if Request number is not null Update ST_PROD_TRANSFER_REQUEST_HDR TABLE */
         if(alRequestNo.size()>0)
			{
				hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}



       /* Updation for Requesyt Status in the ST_PROD_TFR_REQUEST_HDR table ENDs here */

		//Changed the sequence to item_store update and batch update ( previously it is vice versa) for the inc#278 skr
		/* Updating(Decrementing the item_qty and value) from  FROM item_store BEGINS here */
         
        ArrayList tempItemStoreHmParameterFrom = (ArrayList)hmData.get("ItemStoreQtyUpdateDataFrom");
		   HashMap hmItemStoreParametersFrom=(HashMap)tempItemStoreHmParameterFrom.get(0);
		   calculateAndUpdateOnlineStock(connection,hmSQL,hmItemStoreParametersFrom);
		  /* Updating(Decrementing the item_qty and value) from  FROM item_store BEGINS here */


       /* Updating(Incrementing the item_qty and value) to TO item_store BEGINS here */

        ArrayList tempItemStoreHmParameterTo = (ArrayList)hmData.get("ItemStoreQtyUpdateDataTo");
		   HashMap hmItemStoreParametersTo=(HashMap)tempItemStoreHmParameterTo.get(0);
		   calculateAndUpdateOnlineStock(connection,hmSQL,hmItemStoreParametersTo);//ItemBatchStcPosSelectSQL
       /* Updating(Incrementing the item_qty and value) to TO item_store ENDS here */

       /* Decrementing the quantity from  FROM item  BEGINS here */
		   
        ArrayList tempHmParameterFrom = (ArrayList)hmData.get("ItemQtyUpdateDataFrom");
		   HashMap hmParametersFrom=(HashMap)tempHmParameterFrom.get(0);
		   //Moved below code form down to here for Ml-MMOH-SCF-0838
		   HashMap hmResult=new HashMap();
		    HashMap hmParameter	=	new HashMap();
			hmParameter.put("store_code",hmParametersFrom.get("store_code"));
			hmParameter.put("item_code",hmParametersFrom.get("item_code"));
			hmParameter.put("batch_id",((String)hmParametersFrom.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
			hmParameter.put("bin_location_code",hmParametersFrom.get("from_bin_location_code"));
			hmParameter.put("expiry_date_or_receipt_date",hmParametersFrom.get("expiry_date_or_receipt_date"));
            hmParameter.put("trn_qty",""+hmParametersFrom.get("trn_qty"));
            hmParameter.put("login_by_id",hmParametersFrom.get("login_by_id"));
			hmParameter.put("login_at_ws_no",hmParametersFrom.get("login_at_ws_no"));
			hmParameter.put("login_facility_id",hmParametersFrom.get("login_facility_id"));
			hmResult	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'B');
			//End for ML-MMOH-SCF-0838
		   updateBatchOnLine(connection,hmSQL,hmParametersFrom);
       /* Decrementing the quantity from  FROM item  ENDS here */


       /* Incrementing the quantity to  TO item  BEGINS here */

        ArrayList tempHmParameterTo = (ArrayList)hmData.get("ItemQtyUpdateDataTo");
		   HashMap hmParametersTo=(HashMap)tempHmParameterTo.get(0);
		   updateBatchOnLine(connection,hmSQL,hmParametersTo);
       /* Incrementing the quantity from  TO item  ENDS here */

		   
		   
		   
		
		//   System.out.println("hmParametersFrom 349====>"+hmParametersFrom);
		 //  updateBatchOnLine(connection,hmSQL,hmParametersFrom);
		  // System.out.println("array+++++++tempHmParameterFrom+++"+tempHmParameterFrom);
		 //  System.out.println("array=hmParametersFrom============="+hmParametersFrom);
		   
		  
			//*HashMap hmResult=new HashMap();
		 /*  HashMap hmParameter	=	new HashMap();//Commenteing start for ML-MMOH-SCF-0838 and this code is moved before UpdateBatchOnline
			hmParameter.put("store_code",hmParametersFrom.get("store_code"));
			hmParameter.put("item_code",hmParametersFrom.get("item_code"));
			hmParameter.put("batch_id",hmParametersFrom.get("batch_id"));
			hmParameter.put("bin_location_code",hmParametersFrom.get("from_bin_location_code"));
			hmParameter.put("expiry_date_or_receipt_date",hmParametersFrom.get("expiry_date_or_receipt_date"));
			
			
    //   int to_qty_cal=Integer.parseInt((String)hmParametersFrom.get("trn_qty"));
      
       hmParameter.put("trn_qty",""+hmParametersFrom.get("trn_qty"));
       hmParameter.put("login_by_id",hmParametersFrom.get("login_by_id"));
			hmParameter.put("login_at_ws_no",hmParametersFrom.get("login_at_ws_no"));
			hmParameter.put("login_facility_id",hmParametersFrom.get("login_facility_id"));
			hmResult	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'B');*///Commenting end  for ML-MMOH-SCF-0838
			throwExceptionWhenFailed(hmResult);
			  }

		  
		  
		  if(alHdrData.get(11).equals("Y"))
		  {		  
			  
		  /* Insertion of the FROM record into st_item_trn_dtl BEGINS here */

         ArrayList alItemTrnDtlDataFrom	=	(ArrayList)hmData.get("ItemTrnDtlDataFrom");
			stSQL				            =	(String)hmSQL.get("TrnDtlInsertSQL");

			hmArgData.put(DATA,alItemTrnDtlDataFrom);
			hmArgSQL.put(INSERT_SQL,stSQL);
     // try{
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			  // }
 	   // catch(Exception ex) { ex.printStackTrace(); }

		  /* Insertion of the FROM record into st_item_trn_dtl ENDS here */



		  /* Insertion of the TO record into st_item_trn_dtl BEGINS here */

         ArrayList alItemTrnDtlDataTo	=	(ArrayList)hmData.get("ItemTrnDtlDataTo");
			stSQL				            =	(String)hmSQL.get("TrnDtlInsertSQL");

			hmArgData.put(DATA,alItemTrnDtlDataTo);
			hmArgSQL.put(INSERT_SQL,stSQL);
       //try{
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
		  //}
 	//catch(Exception ex) { ex.printStackTrace(); }

		  /* Insertion of the To record into st_item_trn_dtl ENDS here */
     
       


       /* Insertion in the table st_item_move_summ table BEGINS here */
        
         ModifyItemMoveSummaryForPRT (connection);

       /* Insertion in the table st_item_move_summ table BEGINS here */


	

			//Calling Billing Procedure to update the sale price in billing tables.8/11/2008
						ArrayList blparameterTo = (ArrayList)hmData.get("ItemQtyUpdateDataTo");
						HashMap hmblparameterTo=(HashMap)blparameterTo.get(0);

				if((((String)hmblparameterTo.get("sale_price_appl_yn")).equals("Y"))){

						//callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?) }");//Modified for AMS-SCF-0277.1 
						callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?,?,?) }");
						callableStatement.setString(1, (String)hmblparameterTo.get("item_code"));
						callableStatement.setString(2, (String)hmblparameterTo.get("trade_id"));
						callableStatement.setString(3, ((String)hmblparameterTo.get("batch_id")).trim()); //trim() added for KAUH-SCF-0344
						callableStatement.setString(4, (String)hmblparameterTo.get("sale_price"));
						callableStatement.setString(5, (String)hmblparameterTo.get("login_by_id"));
						callableStatement.setString(6, (String)hmblparameterTo.get("login_at_ws_no"));
						callableStatement.registerOutParameter(7, Types.VARCHAR);//Error Code
						callableStatement.registerOutParameter(8, Types.VARCHAR);//sys message id
						callableStatement.registerOutParameter(9, Types.VARCHAR);//error text
						callableStatement.setString(10, "-1");//Added for AMS-SCF-0277.1 
						System.out.println("login_facility_id-----------------------332"+hmblparameterTo.get("login_facility_id"));
						callableStatement.setString(11, (String)hmblparameterTo.get("login_facility_id"));//Added for AMS-SCF-0277.1 
						callableStatement.execute();
					if (callableStatement.getString(8)!=null || (callableStatement.getString(9)!=null && !callableStatement.getString(9).equals("UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated") &&callableStatement.getString(7).equals("10")))
					throw new Exception (callableStatement.getString(9));
				}
					closeStatement(callableStatement);
			//Calling Billing Procedure ends
		  }
	
			connection.commit();
    }
	   catch(Exception exception) {
			try {
				connection.rollback();
				exception.printStackTrace();
			}
			catch (Exception subException) {
				subException.printStackTrace(); 
			}
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
		}
		finally{
			try{
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/
//ML-MMOH-SCF-1861
 public HashMap delete(HashMap hmDataValues, HashMap hmSQLValues) //throws RemoteException
 {

	 Connection connection = null;
	 Properties properties=null;
		PreparedStatement		 pstmt			=		null;
//		PreparedStatement		 pstmt1			=		null;
//		PreparedStatement		 pstmt2			=		null;
//		PreparedStatement		 pstmt3			=		null;
		hmData = hmDataValues; 
		 hmSQL		= hmSQLValues;
	 HashMap hmResult=new HashMap();
	 HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
	 HashMap hmCommon	=	(HashMap)	hmData.get("COMMON_DATA"); 
	 ArrayList alData		=	(ArrayList)hmData.get("DATA");
	 
	 hmResult.put("result", FALSE);
	 
	 try{
		 properties			=	(Properties)hmData.get("properties");
		connection			=	getConnection(properties);
		connection.setAutoCommit(false);
		 alData.add("%"); 

		 int itemQty = 0;
		 String strItemQty = "";
		
		String sql_exp_select_for_block_rel	=	(String)hmSQL.get ("expForBlockRel"); 
		ArrayList alRecords	=	fetchRecords(connection,sql_exp_select_for_block_rel, alData);
		//System.out.println("alRecords: "+alRecords); 
		
		for (int j=0; j<alRecords.size(); j++) {
			HashMap hmRecord	=	(HashMap)alRecords.get(j);
			HashMap hmParameter	=	new HashMap();
			hmParameter.put("store_code",hmRecord.get("STORE_CODE"));
			hmParameter.put("item_code",hmRecord.get("ITEM_CODE"));
			hmParameter.put("batch_id",hmRecord.get("BATCH_ID"));
			hmParameter.put("bin_location_code",checkForNull((String)hmRecord.get("BIN_LOCATION_CODE")));

			hmParameter.put("expiry_date_or_receipt_date",hmRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
			strItemQty = (String)hmRecord.get("ITEM_QTY"); 
			if(strItemQty.contains("-")){
				itemQty= Integer.parseInt(strItemQty);
				itemQty = Math.abs(itemQty);
				strItemQty = String.valueOf(itemQty);  
				hmParameter.put("trn_qty",strItemQty);
			}else{
				hmParameter.put("trn_qty",hmRecord.get("ITEM_QTY")); 
			}
			hmParameter.put("login_by_id",hmCommon.get("login_by_id"));
			hmParameter.put("login_at_ws_no",hmCommon.get("login_at_ws_no"));
			hmParameter.put("login_facility_id",hmCommon.get("login_facility_id"));
				String store_code		=	(String)hmRecord.get("STORE_CODE");
				String item_code		=	(String)hmRecord.get("ITEM_CODE");
				String batch_id			=	(String)hmRecord.get("BATCH_ID");
				String bin_location_code=	(String)hmRecord.get("BIN_LOCATION_CODE");
				String expiry_date_or_receipt_date	=	(String)hmRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE");
				String[]stParameter={store_code,item_code,batch_id,bin_location_code,expiry_date_or_receipt_date};
				HashMap hmSelect	=	fetchRecord(connection, eST.Common.StEJBRepository.getStKeyValue("SQL_ST_ITEM_BATCH_SELECT_SINGLE"),stParameter);
				if (hmSelect == null || hmSelect.size()<=0){
				 continue;
				}
			hmResult	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'R');//false to release the batch..
			throwExceptionWhenFailed(hmResult);
		}
		
		alData.remove(3);//remove doc_srl_no

		/*alData = (ArrayList)hmData.get("DATA");
		System.out.println("alData: "+alData);*/
		
		//DELETE DATA FROM ST_PROD_TRANSFER_DTL_EXP
		stSQL				=	(String)hmSQL.get("stSQLExpDeleteAll");
		hmArgData.put(DATA,alData);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	 update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
		
		//DELETE DATA FROM ST_PROD_TRANSFER_DTL
		stSQL				=	(String)hmSQL.get("stSQLDtlDeleteAll");
		hmArgData.put(DATA,alData);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	 update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
		
		//DELETE DATA FROM ST_PROD_TRANSFRE_HDR
		stSQL				=	(String)hmSQL.get("stSQLHdrDelete");
		hmArgData.put(DATA,alData);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	 update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
		
		connection.commit();
	 }
	 catch(Exception exception) {
			try {
				connection.rollback();
				exception.printStackTrace();
			}
			catch (Exception subException) {
				subException.printStackTrace(); 
			}
			hmResult.put(RESULT,FALSE);
			hmResult.put(MSGID,exception.getMessage());
			hmResult.put(MESSAGE,exception.toString());
		}
		finally{
			try{
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		
	 return hmResult; 
 }//END
   /**
	* @ejb.interface-method
	*	 view-type="both"
	*/


 public HashMap insert(HashMap hmDataValues, HashMap hmSQLValues) //throws RemoteException
	 {

		hmData		= hmDataValues;
		hmSQL		= hmSQLValues;

		

		hmReturn	= new HashMap();		

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		CallableStatement callableStatement = null;
		java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;


		
		//ArrayList	alItemBatch	=	new ArrayList();
	//	ArrayList	alCommonData;

		hmReturn.put(RESULT,FALSE);

		try {

		//hmReturn.put(MESSAGE, "FROM EJB" ) ;
		//hmReturn.put(MSGID, "FROM EJB" ) ;

			properties			=	(Properties)hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

//			alCommonData=(ArrayList)hmData.get("CommonData");

			/* Insertion of the record in st_product_transfer_hdr BEGINS here */

			ArrayList alHdrData	=	(ArrayList)hmData.get("HdrInsertData");
			stSQL				=	(String)hmSQL.get ("HdrInsertSQL");
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(INSERT_SQL,stSQL);
			//try{
			     hmReturn	=	 insert(connection, hmArgData, hmArgSQL);
				 throwExceptionWhenFailed(hmReturn);
			  // }
			//catch(Exception ex) { ex.printStackTrace(); }
       
	        /* Insertion of the record in st_product_transfer_hdr ENDS here */



            /* Insertion of the FROM record in st_product_transfer_dtl BEGINS here */

            ArrayList alDtlFromData	=	(ArrayList)hmData.get("DtlInsertDataFrom");
			stSQL				    =	(String)hmSQL.get("DtlInsertSQL");

			hmArgData.put(DATA,alDtlFromData);
			hmArgSQL.put(INSERT_SQL,stSQL);
			//try{
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
 			    throwExceptionWhenFailed(hmReturn);
			   //}
		//	catch(Exception ex) { ex.printStackTrace(); }


           /* Insertion of the record in st_product_transfer_dtl ENDS here */



           /* Insertion of the TO record in st_product_transfer_dtl BEGINS here */

            ArrayList alDtlToData	=	(ArrayList)hmData.get("DtlInsertDataTo");
			System.out.println("alDtlToData==mangr=>"   +alDtlToData);
			stSQL				    =	(String)hmSQL.get("DtlInsertSQL");
			System.out.println("stSQL==mangr=>"   +stSQL);
			           
			hmArgData.put(DATA,alDtlToData);
			hmArgSQL.put(INSERT_SQL,stSQL);
			//try{
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			//   }
			//catch(Exception ex) { ex.printStackTrace(); }


           /* Insertion of the TO record in st_product_transfer_dtl ENDS here */

   
          /* Insertion of the FROM record in st_product_transfer_dtl_exp BEGINS here */

            ArrayList alDtlExpFromData	=	(ArrayList)hmData.get("DtlExpInsertDataFrom");
			stSQL				        =	(String)hmSQL.get("DtlExpInsertSQL");

			hmArgData.put(DATA,alDtlExpFromData);
			hmArgSQL.put(INSERT_SQL,stSQL);
           // try{
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			  // }
			//catch(Exception ex) { ex.printStackTrace(); }


          /* Insertion of the TO record in st_product_transfer_dtl_exp ENDS here */
 
          /* Insertion of the TO record in st_product_transfer_dtl_exp BEGINS here */

            ArrayList alDtlExpToData	=	(ArrayList)hmData.get("DtlExpInsertDataTo");
			

            /* Checking for Item Trade combination BEGINS */

			ArrayList alFinalTradeId=new ArrayList(); 

			String stTradeIdApplicableYN="";
//			String stDfltTradeId="";
            String stCountRecord="";

			

			pstmt = connection.prepareStatement((String)hmSQL.get("SQL_TRADE_ID_APPLICABLE_SELECT"));
 		    pstmt.setString(1, (String)alDtlExpToData.get(5));
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                  stTradeIdApplicableYN = resultSet.getString(1);
              } 
			closeStatement(pstmt);
			closeResultSet(resultSet);
 

 // Commented on 9/9/2005  as per the requirement from Shenoy not to display the default trade name for sole source item.Trade name  has to be considered from-item trade name

/*	 Starts 9/9/2005

		/*	if(stTradeIdApplicableYN.equals("N"))
			{
			   pstmt = connection.prepareStatement((String)hmSQL.get("SQL_DFLT_TRADE_ID_SELECT"));
   		       resultSet = pstmt.executeQuery();
			   while (resultSet != null && resultSet.next()) {
                stDfltTradeId=resultSet.getString(1);
                }
                alFinalTradeId.add(stDfltTradeId);

			}
            else*/
       //    {
		  // 9/9/2005 Ends
               pstmt = connection.prepareStatement((String)hmSQL.get("SQL_ITEM_TRADE_SELECT"));
               pstmt.setString(1, (String)alDtlExpToData.get(5));
               pstmt.setString(2, (String)alDtlExpToData.get(16));
               resultSet = pstmt.executeQuery();
			   while (resultSet != null && resultSet.next()) {
                 stCountRecord=resultSet.getString(1);
				 }
				closeStatement(pstmt);
				closeResultSet(resultSet);
			   if(stCountRecord.equals("0"))
				{

				   stSQL     =	(String)hmSQL.get("SQL_ITEM_CODE_TRADE_ID_INSERT");

				   ArrayList	alInsertData =	new ArrayList()	;
				   
   				   alInsertData.add((String)alDtlExpToData.get(5));
				   alInsertData.add((String)alDtlExpToData.get(16));

				   alInsertData.add((String)alDtlExpToData.get(10));
				   alInsertData.add((String)alDtlExpToData.get(11));
   				   alInsertData.add((String)alDtlExpToData.get(12));
   				   alInsertData.add((String)alDtlExpToData.get(13));
  				   alInsertData.add((String)alDtlExpToData.get(14));
   				   alInsertData.add((String)alDtlExpToData.get(15));
	               hmArgData.put(DATA,alInsertData);
 			      hmArgSQL.put(INSERT_SQL,stSQL);

                  try{
			              hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				          throwExceptionWhenFailed(hmReturn);
			          }
    	          catch(Exception ex) { ex.printStackTrace(); }
			   }
			    
			    alFinalTradeId.add((String)alDtlExpToData.get(16));
			    alFinalTradeId.add(checkForNull((String)alDtlExpToData.get(17)));  //barcode
				
			   System.out.println("alFinalTradeId====280==>" +alFinalTradeId);


		//	}
            
			/* Checking for Item Trade combination ENDS */
          
            alDtlExpToData.set(16,(String)alFinalTradeId.get(0));
			alDtlExpToData.set(17,(String)alFinalTradeId.get(1)); //07/05/12
            stSQL  =	(String)hmSQL.get("DtlExpInsertSQL");

			hmArgData.put(DATA,alDtlExpToData);
			hmArgSQL.put(INSERT_SQL,stSQL);
        //    try{
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			 //  }
    	   // catch(Exception ex) { ex.printStackTrace(); }

          /* Insertion of the TO record in st_product_transfer_dtl_exp ENDS here */


          /* Updation for Requesyt Status in the ST_PROD_TFR_REQUEST_HDR table BEGINGs here */
				if(alHdrData.get(18).equals("Y"))
				  {	//Added IF CONDITION for ML-MMOH-CRF-0448 B.Badmavathi
			ArrayList	alRequestNo = new ArrayList();
			ArrayList	alRequestStatusdata = new ArrayList();
			String		requestno ="";

			alRequestNo	=	(ArrayList)	hmData.get("RequestNo");
			if (alRequestNo !=null && alRequestNo.size()>0 )
			{
				requestno =(String)alRequestNo.get(0);
			}
			alRequestStatusdata.add((String)alDtlExpToData.get(13));
  			alRequestStatusdata.add((String)alDtlExpToData.get(14));
   			alRequestStatusdata.add((String)alDtlExpToData.get(15));
			alRequestStatusdata.add(requestno);

			stSQL			=	(String)	hmSQL.get ("RequestStatusUpdateSQL");
			

			hmArgData.put(DATA,alRequestStatusdata);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			/* if Request number is not null Update ST_PROD_TRANSFER_REQUEST_HDR TABLE */
            if(alRequestNo.size()>0)
			{
				hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}



          /* Updation for Requesyt Status in the ST_PROD_TFR_REQUEST_HDR table ENDs here */

		//Changed the sequence to item_store update and batch update ( previously it is vice versa) for the inc#278 skr
		/* Updating(Decrementing the item_qty and value) from  FROM item_store BEGINS here */

           ArrayList tempItemStoreHmParameterFrom = (ArrayList)hmData.get("ItemStoreQtyUpdateDataFrom");
		   HashMap hmItemStoreParametersFrom=(HashMap)tempItemStoreHmParameterFrom.get(0);
		   calculateAndUpdateOnlineStock(connection,hmSQL,hmItemStoreParametersFrom);

          /* Updating(Decrementing the item_qty and value) from  FROM item_store BEGINS here */


          /* Updating(Incrementing the item_qty and value) to TO item_store BEGINS here */

           ArrayList tempItemStoreHmParameterTo = (ArrayList)hmData.get("ItemStoreQtyUpdateDataTo");
		   HashMap hmItemStoreParametersTo=(HashMap)tempItemStoreHmParameterTo.get(0);
		   calculateAndUpdateOnlineStock(connection,hmSQL,hmItemStoreParametersTo);

          /* Updating(Incrementing the item_qty and value) to TO item_store ENDS here */

          /* Decrementing the quantity from  FROM item  BEGINS here */

           ArrayList tempHmParameterFrom = (ArrayList)hmData.get("ItemQtyUpdateDataFrom");
		   HashMap hmParametersFrom=(HashMap)tempHmParameterFrom.get(0);
		   System.out.println("hmParametersFrom 349====>"+hmParametersFrom);
		   updateBatchOnLine(connection,hmSQL,hmParametersFrom);
		
          /* Decrementing the quantity from  FROM item  ENDS here */


          /* Incrementing the quantity to  TO item  BEGINS here */

           ArrayList tempHmParameterTo = (ArrayList)hmData.get("ItemQtyUpdateDataTo");
		   HashMap hmParametersTo=(HashMap)tempHmParameterTo.get(0);
		    System.out.println("hmParametersTo 349====>"+hmParametersTo);
		   updateBatchOnLine(connection,hmSQL,hmParametersTo);

          /* Incrementing the quantity from  TO item  ENDS here */

			  } //Added for ML-MMOH-CRF-0448 B.Badmavathi starts
		   else{
			   ArrayList tempHmParameterFrom = (ArrayList)hmData.get("ItemQtyUpdateDataFrom");
			   HashMap hmParametersFrom=(HashMap)tempHmParameterFrom.get(0);
				HashMap hmResult=new HashMap();
			   HashMap hmParameter	=	new HashMap();
				hmParameter.put("store_code",hmParametersFrom.get("store_code"));
				hmParameter.put("item_code",hmParametersFrom.get("item_code"));
				hmParameter.put("batch_id",((String)hmParametersFrom.get("batch_id")).trim());//trim() added for KAUH-SCF-0344
				hmParameter.put("bin_location_code",hmParametersFrom.get("from_bin_location_code"));
				hmParameter.put("expiry_date_or_receipt_date",hmParametersFrom.get("expiry_date_or_receipt_date"));
				
				Double obj = new Double((String)hmParametersFrom.get("trn_qty"));
				int to_qty_cal = obj.intValue(); 
				
           //int to_qty_cal=Integer.parseInt((String)hmParametersFrom.get("trn_qty"));
           hmParameter.put("trn_qty",""+(to_qty_cal*(-1)));
           hmParameter.put("login_by_id",hmParametersFrom.get("login_by_id"));
				hmParameter.put("login_at_ws_no",hmParametersFrom.get("login_at_ws_no"));
				hmParameter.put("login_facility_id",hmParametersFrom.get("login_facility_id"));
				hmResult	=	blockReleaseBatch(connection, hmParameter,hmSQL, 'B');
				throwExceptionWhenFailed(hmResult);
				
		   } //Added for ML-MMOH-CRF-0448 B.Badmavathi ends
          /* Updating(Incrementing the item_qty and value) to TO repacking_group BEGINS  here */


		  ArrayList tempItemBatchTo = (ArrayList)hmData.get("ItemBatchTo");
		  if(tempItemBatchTo.size()>0)
		  {
			if(tempItemBatchTo.get(0).equals("Y"))
			{
				updateRepackingGroupBatch(connection,hmData,hmSQL);
			}
		}
		
			

		/* Updating(Incrementing the item_qty and value) to TO repacking_group ENDS here */


		  if(alHdrData.get(18).equals("Y"))//Added IF CONDITION for ML-MMOH-CRF-0448 B.Badmavathi
		  {		  
		  /* Insertion of the FROM record into st_item_trn_dtl BEGINS here */

            ArrayList alItemTrnDtlDataFrom	=	(ArrayList)hmData.get("ItemTrnDtlDataFrom");
			stSQL				            =	(String)hmSQL.get("TrnDtlInsertSQL");

			hmArgData.put(DATA,alItemTrnDtlDataFrom);
			hmArgSQL.put(INSERT_SQL,stSQL);
        // try{
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			  // }
    	   // catch(Exception ex) { ex.printStackTrace(); }

		  /* Insertion of the FROM record into st_item_trn_dtl ENDS here */



		  /* Insertion of the TO record into st_item_trn_dtl BEGINS here */

            ArrayList alItemTrnDtlDataTo	=	(ArrayList)hmData.get("ItemTrnDtlDataTo");
			stSQL				            =	(String)hmSQL.get("TrnDtlInsertSQL");

			hmArgData.put(DATA,alItemTrnDtlDataTo);
			hmArgSQL.put(INSERT_SQL,stSQL);
          //try{
			    hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
		  //}
    	//catch(Exception ex) { ex.printStackTrace(); }

		  /* Insertion of the To record into st_item_trn_dtl ENDS here */
        
          


          /* Insertion in the table st_item_move_summ table BEGINS here */
           
            insertItemMoveSummaryForPRT (connection);

          /* Insertion in the table st_item_move_summ table BEGINS here */


		/*	if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) //COMMENTED for ML-MMOH-CRF-0448 B.Badmavathi
			{
            	generateDocNo(connection,hmData,hmSQL);
			}*/
			


			//Calling Billing Procedure to update the sale price in billing tables.8/11/2008
						ArrayList blparameterTo = (ArrayList)hmData.get("ItemQtyUpdateDataTo");
						HashMap hmblparameterTo=(HashMap)blparameterTo.get(0);

				if((((String)hmblparameterTo.get("sale_price_appl_yn")).equals("Y"))){

						//callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?) }");//Modified for AMS-SCF-0277.1 
						callableStatement	= connection.prepareCall("{ CALL BLCOMMON.CREATE_MATERIAL_BATCH_PRICE(?,?,?,?,SYSDATE,?,?,?,?,?,?,?) }");
						callableStatement.setString(1, (String)hmblparameterTo.get("item_code"));
						callableStatement.setString(2, (String)hmblparameterTo.get("trade_id"));
						callableStatement.setString(3, ((String)hmblparameterTo.get("batch_id")).trim());//trim() added for KAUH-SCF-0344
						callableStatement.setString(4, (String)hmblparameterTo.get("sale_price"));
						callableStatement.setString(5, (String)hmblparameterTo.get("login_by_id"));
						callableStatement.setString(6, (String)hmblparameterTo.get("login_at_ws_no"));
						callableStatement.registerOutParameter(7, Types.VARCHAR);//Error Code
						callableStatement.registerOutParameter(8, Types.VARCHAR);//sys message id
						callableStatement.registerOutParameter(9, Types.VARCHAR);//error text
						callableStatement.setString(10, "-1");//Added for AMS-SCF-0277.1 
						System.out.println("login_facility_id-----------------------770"+(String)hmblparameterTo.get("login_facility_id"));
						callableStatement.setString(11, (String)hmblparameterTo.get("login_facility_id"));//Added for AMS-SCF-0277.1 
						callableStatement.execute();
					if (callableStatement.getString(8)!=null || (callableStatement.getString(9)!=null && !callableStatement.getString(9).equals("UNABLE TO INSERT BL_ST_ITEM_BY_TRADENAMEORA-00001: unique constraint (IBAEHIS.BL_ST_ITEM_BY_TRADENAME_PK) violated") &&callableStatement.getString(7).equals("10")))
					throw new Exception (callableStatement.getString(9));
				}
					closeStatement(callableStatement);
			//Calling Billing Procedure ends
		  }//Added for ML-MMOH-CRF-0448 B.Badmavathi STARTS
		  if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() )
			{
          	generateDocNo(connection,hmData,hmSQL);
			}//Added for ML-MMOH-CRF-0448 B.Badmavathi ENDS
			connection.commit();
       }
	   catch(Exception exception) {
			try {
				connection.rollback();
				exception.printStackTrace();
			}
			catch (Exception subException) {
				subException.printStackTrace(); 
			}
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
		}
		finally{
			try{
				closeStatement(pstmt);
				closeResultSet(resultSet);
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}


public void generateDocNo(Connection connection,HashMap hmData,HashMap hmSQL) throws Exception {
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		//ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alCommonData;
		String		stSQL		=	null;

		alCommonData	=	(ArrayList)	hmData.get("CommonData");
		stSQL			=	(String)	hmSQL.get ("NextDocNoUpdateSQL");
		

		hmArgData.put(DATA,alCommonData);
		hmArgSQL.put(UPDATE_SQL,stSQL);

		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);

		//hmReturn.put("flag","Doc No: "+alHdrData.get(2));
	}


public void updateRepackingGroupBatch(Connection connection,HashMap hmData,HashMap hmSQL) throws Exception {
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		//ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alHmParameterItemBatchTo;
		String		stSQL		=	null;


		alHmParameterItemBatchTo	=	(ArrayList)	hmData.get("ItemBatchIdDataTo");
		HashMap hmHmParameterItemBatchTo=(HashMap)alHmParameterItemBatchTo.get(0);
		
		String repackgroupcode= (String)hmHmParameterItemBatchTo.get("repacking_group_code"); 
        ArrayList altemp = new ArrayList();
	
		altemp.add((String)hmHmParameterItemBatchTo.get("login_by_id")); 
		altemp.add((String)hmHmParameterItemBatchTo.get("login_at_ws_no")); 
		altemp.add((String)hmHmParameterItemBatchTo.get("login_facility_id")); 
		altemp.add(repackgroupcode); 
		


		stSQL			=	(String)	hmSQL.get ("ItemNextBatchUpdateSQL");
		
		

		hmArgData.put(DATA,altemp);
		
		hmArgSQL.put(UPDATE_SQL,stSQL);
		

		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		
		throwExceptionWhenFailed(hmReturn);

		//hmReturn.put("flag","Doc No: "+alHdrData.get(2));
	}



	public void insertItemMoveSummaryForPRT (Connection connection) throws Exception {

		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();

		ArrayList alDtlDataFrom			=	new ArrayList();
        ArrayList alDtlDataTo			=	new ArrayList();

		ArrayList alItemMoveSummRecord	=	new ArrayList();
		ArrayList alCommonData			=	(ArrayList)	hmData.get("CommonData");

        ArrayList alHdrData				=	(ArrayList)	hmData.get("HdrInsertData");
                
		alDtlDataFrom			=	(ArrayList)	hmData.get("DtlInsertDataFrom");
		alDtlDataTo             =	(ArrayList)	hmData.get("DtlInsertDataTo");
		

		//HashMap hmRecordFrom	=	(HashMap) alDtlDataFrom.get(i);

		String l_doc_date	= (String)alHdrData.get(3); //doc_date

		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(l_doc_date);
		alItemMoveSummRecord.add(l_doc_date);

		HashMap hmResult = fetchRecord(connection,(String)hmSQL.get ("GetMonthAndYear"));

		String l_move_month	= (String)hmResult.get("MM");
		String l_move_year	= (String)hmResult.get("YYYY");


        /* For From record to be inserted in st_item_move_summ table */

		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(alCommonData.get(2)); // facility_id
		alItemMoveSummRecord.add(alDtlDataFrom.get(5));// Item code
		alItemMoveSummRecord.add(alHdrData.get(5));    // store_code
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);
/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		nafitive_value_to_zero.add(alCommonData.get(2));      // facility_id
		nafitive_value_to_zero.add(alDtlDataFrom.get(5));     // Item code
		nafitive_value_to_zero.add(alHdrData.get(5));    // store_code
		nafitive_value_to_zero.add(l_move_month);
		nafitive_value_to_zero.add(l_move_year);
	
		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		int summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {


			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(alHdrData.get(0));     //facility code
			alItemMoveSummRecord.add(alDtlDataFrom.get(5)); //Item code
			alItemMoveSummRecord.add(alHdrData.get(5));     // store_code
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);

			alItemMoveSummRecord.add(alDtlDataFrom.get(6)); //From Quantity Closing
			//Cost value Closing
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)alDtlDataFrom.get(6),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(alDtlDataFrom.get(8)); //month_closing_value = item_cost_value
			}
			alItemMoveSummRecord.add(alDtlDataFrom.get(6)); //From Quantity for month end
			alItemMoveSummRecord.add(alDtlDataFrom.get(8)); //Cost value for month end

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));
			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));


			stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {
			alItemMoveSummRecord.clear();

			// Problem here ...check it ....in update mode it is updating the 
			//qty to + quantity....
			alItemMoveSummRecord.add(alDtlDataFrom.get(6)); //From Quantity
			alItemMoveSummRecord.add(alDtlDataFrom.get(8)); //Cost value
			alItemMoveSummRecord.add(alDtlDataFrom.get(6)); //From Quantity for month end
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)alDtlDataFrom.get(6),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(alDtlDataFrom.get(8)); //month_closing_value = item_cost_value
			} //Cost value for month end

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));

			alItemMoveSummRecord.add(alCommonData.get(2));  // facility_id
			alItemMoveSummRecord.add(alDtlDataFrom.get(5)); // Item code
			alItemMoveSummRecord.add(alHdrData.get(5));     // store_code
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			stSQL = (String)hmSQL.get ("ItemMovSumFromUpdateSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}

		/* For To record to be inserted in st_item_move_summ table */

		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(alCommonData.get(2)); // facility_id
		alItemMoveSummRecord.add(alDtlDataTo.get(5));  // Item code
		alItemMoveSummRecord.add(alHdrData.get(5));    // store_code
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);

		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {


			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(alHdrData.get(0));     //facility code
			alItemMoveSummRecord.add(alDtlDataTo.get(5));   //Item code
			alItemMoveSummRecord.add(alHdrData.get(5));     // store_code
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);

			alItemMoveSummRecord.add(alDtlDataTo.get(6)); //To Quantity
			 /**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)alDtlDataTo.get(6),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(alDtlDataTo.get(8)); //month_closing_value = item_cost_value
			} //Cost value for month closing
			alItemMoveSummRecord.add(alDtlDataTo.get(6)); //To Quantity for month closing 			
			alItemMoveSummRecord.add(alDtlDataTo.get(8));
			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));
			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));


			stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {      

			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(alDtlDataTo.get(6)); //From Quantity
			alItemMoveSummRecord.add(alDtlDataTo.get(8)); //Cost value
			alItemMoveSummRecord.add(alDtlDataTo.get(6)); //From Quantity for month closing
			 /**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)alDtlDataTo.get(6),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(alDtlDataTo.get(8)); //month_closing_value = item_cost_value
			} //Cost value for month closing

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));

			alItemMoveSummRecord.add(alCommonData.get(2)); // facility_id
			alItemMoveSummRecord.add(alDtlDataTo.get(5));  // Item code
			alItemMoveSummRecord.add(alHdrData.get(5));    // store_code
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			stSQL = (String)hmSQL.get ("ItemMovSumToUpdateSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 WHEN month_opening_value > 0   THEN month_opening_value END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 WHEN month_closing_value > 0 THEN month_closing_value END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
	}
	//Added for ML-MMOH-CRF-0448 B.Badmavathi STARTS
	public void ModifyItemMoveSummaryForPRT (Connection connection) throws Exception {

		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();

		ArrayList alDtlDataFrom			=	new ArrayList();
        ArrayList alDtlDataTo			=	new ArrayList();

		ArrayList alItemMoveSummRecord	=	new ArrayList();
		ArrayList alCommonData			=	(ArrayList)	hmData.get("CommonData");

        ArrayList alHdrData				=	(ArrayList)	hmData.get("HdrUpdateData");
                
		alDtlDataFrom			=	(ArrayList)	hmData.get("DtlUpdateDataFrom");
		alDtlDataTo             =	(ArrayList)	hmData.get("DtlUpdateDataTo");
		

		//HashMap hmRecordFrom	=	(HashMap) alDtlDataFrom.get(i);

		String l_doc_date	= (String)alHdrData.get(0); //doc_date

		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(l_doc_date);
		alItemMoveSummRecord.add(l_doc_date);

		HashMap hmResult = fetchRecord(connection,(String)hmSQL.get ("GetMonthAndYear"));

		String l_move_month	= (String)hmResult.get("MM");
		String l_move_year	= (String)hmResult.get("YYYY");


        /* For From record to be inserted in st_item_move_summ table */

		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(alCommonData.get(2)); // facility_id
		alItemMoveSummRecord.add(alDtlDataFrom.get(0));// Item code
		alItemMoveSummRecord.add(alHdrData.get(2));    // store_code
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);
/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		nafitive_value_to_zero.add(alCommonData.get(2));      // facility_id
		nafitive_value_to_zero.add(alDtlDataFrom.get(0));     // Item code
		nafitive_value_to_zero.add(alHdrData.get(2));    // store_code
		nafitive_value_to_zero.add(l_move_month);
		nafitive_value_to_zero.add(l_move_year);
	
		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		int summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {


			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(alHdrData.get(25));     //facility code
			alItemMoveSummRecord.add(alDtlDataFrom.get(0)); //Item code
			alItemMoveSummRecord.add(alHdrData.get(2));     // store_code
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);

			alItemMoveSummRecord.add(alDtlDataFrom.get(1)); //From Quantity Closing
			//Cost value Closing
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)alDtlDataFrom.get(1),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(alDtlDataFrom.get(3)); //month_closing_value = item_cost_value
			}
			alItemMoveSummRecord.add(alDtlDataFrom.get(1)); //From Quantity for month end
			alItemMoveSummRecord.add(alDtlDataFrom.get(3)); //Cost value for month end

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));
			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));


			stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {
			alItemMoveSummRecord.clear();

			// Problem here ...check it ....in update mode it is updating the 
			//qty to + quantity....
			alItemMoveSummRecord.add(alDtlDataFrom.get(1)); //From Quantity
			alItemMoveSummRecord.add(alDtlDataFrom.get(3)); //Cost value
			alItemMoveSummRecord.add(alDtlDataFrom.get(1)); //From Quantity for month end
			/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)alDtlDataFrom.get(1),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(alDtlDataFrom.get(3)); //month_closing_value = item_cost_value
			} //Cost value for month end

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));

			alItemMoveSummRecord.add(alCommonData.get(2));  // facility_id
			alItemMoveSummRecord.add(alDtlDataFrom.get(0)); // Item code
			alItemMoveSummRecord.add(alHdrData.get(2));     // store_code
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			stSQL = (String)hmSQL.get ("ItemMovSumFromUpdateSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}

		/* For To record to be inserted in st_item_move_summ table */

		alItemMoveSummRecord.clear();
		alItemMoveSummRecord.add(alCommonData.get(2)); // facility_id
		alItemMoveSummRecord.add(alDtlDataTo.get(0));  // Item code
		alItemMoveSummRecord.add(alHdrData.get(2));    // store_code
		alItemMoveSummRecord.add(l_move_month);
		alItemMoveSummRecord.add(l_move_year);

		hmResult = fetchRecord(connection,(String)hmSQL.get ("SummaryExistsCheckSQL"),alItemMoveSummRecord);
		summary_count= Integer.parseInt((String)(hmResult.get("COUNT")));

		if(summary_count == 0) {


			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(alHdrData.get(25));     //facility code
			alItemMoveSummRecord.add(alDtlDataTo.get(0));   //Item code
			alItemMoveSummRecord.add(alHdrData.get(2));     // store_code
			alItemMoveSummRecord.add(l_move_year);
			alItemMoveSummRecord.add(l_move_month);

			alItemMoveSummRecord.add(alDtlDataTo.get(1)); //To Quantity
			 /**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)alDtlDataTo.get(1),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(alDtlDataTo.get(3)); //month_closing_value = item_cost_value
			} //Cost value for month closing
			alItemMoveSummRecord.add(alDtlDataTo.get(1)); //To Quantity for month closing 			
			alItemMoveSummRecord.add(alDtlDataTo.get(3));
			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));
			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));


			stSQL	=	(String)hmSQL.get ("ItemMovSumInsertSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
		else {      

			alItemMoveSummRecord.clear();
			alItemMoveSummRecord.add(alDtlDataTo.get(1)); //From Quantity
			alItemMoveSummRecord.add(alDtlDataTo.get(3)); //Cost value
			alItemMoveSummRecord.add(alDtlDataTo.get(1)); //From Quantity for month closing
			 /**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
				 */

			if(Double.valueOf(checkForNull((String)alDtlDataTo.get(1),"0"))==0){
				alItemMoveSummRecord.add("0"); // month_closing_value=0
			}else{
				alItemMoveSummRecord.add(alDtlDataTo.get(3)); //month_closing_value = item_cost_value
			} //Cost value for month closing

			alItemMoveSummRecord.add(alCommonData.get(0));
			alItemMoveSummRecord.add(alCommonData.get(1));
			alItemMoveSummRecord.add(alCommonData.get(2));

			alItemMoveSummRecord.add(alCommonData.get(2)); // facility_id
			alItemMoveSummRecord.add(alDtlDataTo.get(0));  // Item code
			alItemMoveSummRecord.add(alHdrData.get(2));    // store_code
			alItemMoveSummRecord.add(l_move_month);
			alItemMoveSummRecord.add(l_move_year);

			stSQL = (String)hmSQL.get ("ItemMovSumToUpdateSQL");

			hmArgData.put(DATA,alItemMoveSummRecord);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
		}
			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 WHEN month_opening_value > 0   THEN month_opening_value END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 WHEN month_closing_value > 0 THEN month_closing_value END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmReturn	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
	}
//Added for ML-MMOH-CRF-0448 B.Badmavathi ENDS
}
