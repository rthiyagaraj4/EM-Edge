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

3/1/2019				INC069379 				Shazana Hasan												MMS-ICN-00110 - unit cost issue
13/01/2020              IN072061               Haribabu                                                    Post Variance -> On Apply -> System hangs
24/12/2020				TFS-7402			   Haribabu			  											AAKH-SCF-0464           
--------------------------------------------------------------------------------------------------------------------------------------------
*/

package eST.PostVariance;

//import eCommon.Common.CommonEJBSessionAdapter;
import eST.Common.StEJBSessionAdapter;
import java.sql.*;
import java.util.*;
//import javax.ejb.EJBException; 
import javax.ejb.SessionContext;
//import java.util.*;

/**
*
* @ejb.bean
*	name="PostVariance"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PostVariance"
*	local-jndi-name="PostVariance"
*	impl-class-name="eST.PostVariance.PostVarianceManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.PostVariance.PostVarianceLocal"
*	remote-class="eST.PostVariance.PostVarianceRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.PostVariance.PostVarianceLocalHome"
*	remote-class="eST.PostVariance.PostVarianceHome"
*	generate= "local,remote"
*
*
*/


public class PostVarianceManager extends StEJBSessionAdapter
{

	private boolean negative_flag = false;
    public PostVarianceManager()
    {
        context = null;
    }

    public void setSessionContext(SessionContext sessioncontext)
    {
        super.setSessionContext(sessioncontext);
        context = sessioncontext;
    }

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert(HashMap hashmap, HashMap hashmapQuery)
    {
        Connection connection = null;
        HashMap hmResult = new HashMap();
        HashMap hmArgData = new HashMap();
        HashMap hmArgSQL = new HashMap();
    
        ArrayList arraylist = new ArrayList();
   //     ArrayList arraylist2 = new ArrayList();
     //   ArrayList arraylist4 = new ArrayList();
        ArrayList alAdjRecord = new ArrayList();
        ArrayList alAdjDtlRecord = new ArrayList();
        ArrayList alRecordUpdateAll = new ArrayList();
        ArrayList alExpRecordAll = new ArrayList();
        ArrayList alUpdateAll = new ArrayList();
        ArrayList alUpdateParam = new ArrayList();
        ArrayList alExpRecordAllData = new ArrayList();
        StringBuffer sb = new StringBuffer();//Added for IN072061
        String new_store_code="";//Added for IN072061
        int k=0;//Added for IN072061

		HashSet hsItem	=	new HashSet();

        Properties properties = null;
		String qty_phy_stk ="0";
        hmResult.put("result", FALSE);
		String stSQL="";
        try
        {  
            properties = (Properties)hashmap.get("properties");
			connection = getConnection(properties);
            connection.setAutoCommit(false);
            arraylist = (ArrayList)hashmap.get("data");
          
			/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost and round up item_cost_value with noOfDecimalsForCost 
			 */
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));

			ArrayList alBatchRecords=null;
			/**
					* @Name - krishna reddy
					* @Date - 22/12/2009
					* @Inc# - IN017304
					* @Desc - Update the columns PHY_INV_ID, PHY_INV_START_DATE and PHY_INV_START_QTY in ST_ITEM_BATCH table facility wise.
			*/
			String  params[]={(String)arraylist.get(2),(String)arraylist.get(5),(String)arraylist.get(2),(String)arraylist.get(5)}; 
			stSQL=(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_SELECT_BATCH");
			alBatchRecords = fetchRecords(connection,stSQL.toString(),params);
			String temp_store="";
			String temp_code="";
			String doc_no="";
			/**
					* @Name - krishna reddy
					* @Date - 22/12/2009
					* @Inc# - IN017304
					* @Desc - Update the columns PHY_INV_ID, PHY_INV_START_DATE and PHY_INV_START_QTY in ST_ITEM_BATCH table facility wise.
			*/
			if(alBatchRecords.size()!=0){
			for (int i=0;i<1 ; i++){
					//HashMap hmDetail	= (HashMap)alBatchRecords.get(i);
					
					arraylist.add(((HashMap)alBatchRecords.get(i)).get("STORE_CODE").toString());
					 }
			}
			int srl_no=0;
			String store_code="";
			int trn_srl_no=0;
			if (alBatchRecords.size()==0){
				ArrayList alParameters	=	new ArrayList();
				alParameters.add(arraylist.get(5));//facility_id
				alParameters.add(arraylist.get(2));//phy_inv_id

				hmArgData.put(DATA,alParameters);
				hmArgSQL.put(DELETE_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_DTL_DELETE"));
				hmResult	=	delete(connection, hmArgData, hmArgSQL);

				hmArgData.put(DATA, alParameters);
				hmArgSQL.put(DELETE_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_HDR_DELETE"));
				hmResult	=	delete(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

				ArrayList alParameters1	=	new ArrayList();
				alParameters1.add(arraylist.get(3));//Login id
				alParameters1.add(arraylist.get(4));// At_ws_no
				alParameters1.add(arraylist.get(5));//facility_id
				alParameters1.add(arraylist.get(5));//facility_id
				alParameters1.add(arraylist.get(2));//phy_inv_id
				hmArgData.put(DATA, alParameters1);
				hmArgSQL.put(UPDATE_SQL,(String)hashmapQuery.get("SQL_ST_ITEM_STORE_UPDATE_FOR_POST_VARIANCE_2"));
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);
					
				ArrayList alParametersBatch	=	new ArrayList();
				alParametersBatch.add(arraylist.get(3));//Login id
				alParametersBatch.add(arraylist.get(4));// At_ws_no
				alParametersBatch.add(arraylist.get(5));//facility_id
				alParametersBatch.add(arraylist.get(2));//phy_inv_id
				/**
					* @Name - krishna reddy
					* @Date - 22/12/2009
					* @Inc# - IN017304
					* @Desc - Update the columns PHY_INV_ID, PHY_INV_START_DATE and PHY_INV_START_QTY in ST_ITEM_BATCH table facility wise.
				*/
				alParametersBatch.add(arraylist.get(5));//phy_inv_id
				hmArgData.put(DATA, alParametersBatch);
				hmArgSQL.put(UPDATE_SQL,"update st_item_batch set PHY_INV_ID=null, PHY_INV_START_DATE=null, PHY_INV_START_QTY=null, modified_by_id=?, modified_date=SYSDATE, modified_at_ws_no=?, modified_facility_id=? where PHY_INV_ID=? and ADDED_FACILITY_ID=?");
				hmResult	=	update(connection, hmArgData, hmArgSQL);

				ArrayList alParametersvariance	=	new ArrayList();
				alParametersvariance.add(arraylist.get(3));//Login id
				alParametersvariance.add(arraylist.get(4));// At_ws_no
				alParametersvariance.add(arraylist.get(5));//facility_id
				alParametersvariance.add(arraylist.get(5));//facility_id
				alParametersvariance.add(arraylist.get(2));//phy_inv_id
				hmArgData.put(DATA, alParametersvariance);
				hmArgSQL.put(UPDATE_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_UPDATE_PARAM"));
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

			}
			else{
				for (int i=0;i<alBatchRecords.size() ; i++){
					String SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT	= eST.Common.StEJBRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT");
					HashMap hmDetail	= (HashMap)alBatchRecords.get(i);
					hsItem.add(hmDetail.get("ITEM_CODE"));
					ArrayList alDtlRecord	=	new ArrayList();
					
					HashMap has = new HashMap();
// code added on 19/12
					new_store_code="'";//Added for IN072061
					new_store_code=new_store_code+(hmDetail.get("STORE_CODE")).toString()+"'";//Added for IN072061
					 String chkfields [ ] = {(hmDetail.get("STORE_CODE")).toString() , (hmDetail.get("ITEM_CODE")).toString() , (hmDetail.get("BATCH_ID")).toString(),(hmDetail.get("BIN_LOCATION_CODE")).toString() ,(hmDetail.get("EXPIRY_DATE")).toString() };
					if(Double.parseDouble((String)hmDetail.get("PHY_STK_QTY")) == 0){
						has =fetchRecord(connection, (String)hashmapQuery.get("SQL_ST_POSTVARIANCE_ITEM_QTY"), chkfields );
						qty_phy_stk = (String)has.get("QTY_ON_HAND");
						hmDetail.put("PHY_STK_QTY",qty_phy_stk);
						negative_flag = true;
					}
//code end
					if(!((String)hmDetail.get("STORE_CODE")).equals(temp_store)){
						store_code=(String)hmDetail.get("STORE_CODE");
						doc_no=(String)fetchRecord(connection, SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT, (String)arraylist.get(1)).get("NEXT_DOC_NO");
						alDtlRecord.add(arraylist.get(5));
						alDtlRecord.add(arraylist.get(1));
						alDtlRecord.add(doc_no);
						alDtlRecord.add(arraylist.get(6));
						alDtlRecord.add("");
						alDtlRecord.add(hmDetail.get("STORE_CODE"));
						alDtlRecord.add("Y");
						alDtlRecord.add("Y");
						alDtlRecord.add("N");
						alDtlRecord.add("VAR");
						alDtlRecord.add("N");
						alDtlRecord.add("");
						alDtlRecord.add("");
						alDtlRecord.add("");
						alDtlRecord.add(arraylist.get(3));
						alDtlRecord.add(arraylist.get( 4));
						alDtlRecord.add(arraylist.get(5));
						alDtlRecord.add(arraylist.get(3));
						alDtlRecord.add(arraylist.get( 4));
						alDtlRecord.add(arraylist.get(5));
						alAdjRecord.add(alDtlRecord);

						String SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE	= eST.Common.StEJBRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE");
						ArrayList alParameters	=	new ArrayList();
						alParameters.add(arraylist.get(3));
						alParameters.add(arraylist.get( 4));
						alParameters.add(arraylist.get(5));
						alParameters.add(arraylist.get(1));
					
						hmArgData.put(DATA,alParameters);
						hmArgSQL.put(UPDATE_SQL,SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE);
						hmResult	=	update(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
					
						temp_store=(String)hmDetail.get("STORE_CODE");
					}
				
					if(((String)hmDetail.get("STORE_CODE")).equals(temp_store)){
							if(!((String)hmDetail.get("ITEM_CODE")).equals(temp_code) ){
							//Added for IN072061 start
								if(k!=0)
									sb.append(",'");
								else
									sb.append("'");
								
								sb.append((String)hmDetail.get("ITEM_CODE")+"'");
								k++;
                             //Added for IN072061 end
								ArrayList listRecordSum=new ArrayList();
								String  paras[]={(String)arraylist.get(2),(String)hmDetail.get("STORE_CODE"),(String)hmDetail.get("ITEM_CODE"),(String)arraylist.get(2),(String)hmDetail.get("STORE_CODE"),(String)hmDetail.get("ITEM_CODE")}; 
								stSQL=(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_SUM_VAR_QTY");
								listRecordSum = fetchRecords(connection,stSQL.toString(),paras);

								double inv_qty=0;
								double comp_qty=0;
								double phy_stk_qty=0;
								double item_val=0.0;
								//Added by suresh.r against  KDAH-SCF-0215(#46127) on 30-12-2013 begin
								double temp_var_qty=0;
								double temp_var_cost=0.0;
								double pos_var_qty=0;
								double neg_var_qty=0;
								double pos_var_cost=0.0;
								double neg_var_cost=0.0;
								//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 end
								
	
								for (int h=0;h<listRecordSum.size() ;h++ ) {
									
									HashMap hm=(HashMap)listRecordSum.get(h);
									inv_qty=inv_qty+Double.parseDouble((String)hm.get("VAR_QTY"));
									comp_qty=comp_qty+Double.parseDouble((String)hm.get("COMP_QTY"));
									phy_stk_qty=phy_stk_qty+Double.parseDouble((String)hm.get("PHY_STK_QTY"));
									item_val=item_val+Double.parseDouble((String)hm.get("VAR_VAL"));
									//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 begin
									temp_var_qty=Double.parseDouble((String)hm.get("VAR_QTY"));
									temp_var_cost=Double.parseDouble((String)hm.get("VAR_VAL"));
									if(temp_var_qty>0) 
										pos_var_qty+= temp_var_qty;
									if(temp_var_cost>0)
										pos_var_cost+= temp_var_cost;

									if(temp_var_qty<0) 
										neg_var_qty+= temp_var_qty;
									if(temp_var_cost<0) 
										neg_var_cost+= temp_var_cost;
									//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 end
								}

								ArrayList alRecord	=	new ArrayList();
								srl_no++;
								alRecord.add(arraylist.get(5));
								alRecord.add(arraylist.get(1));
								alRecord.add(doc_no);
								alRecord.add(""+srl_no);
								alRecord.add(hmDetail.get("ITEM_CODE"));
								alRecord.add("Y");
								//alRecord.add(""+inv_qty);	
								//alRecord.add(hmDetail.get("UNIT_COST"));
								//Modified by suresh.r on 03-11-2014 against Inc 52256 chaged unticost logic beg
								HashMap hmResult1 = new HashMap();
								ArrayList alConvParam=new ArrayList();
								alConvParam.add(hmDetail.get("ITEM_CODE"));
								alConvParam.add(store_code);
								hmResult1 = fetchRecord(connection,"SELECT ST_GET_UOM_CONV_FAC_SING_STR(?,?) CONV_FACTOR FROM DUAL",alConvParam);
								double eqvl_value = Double.parseDouble((String)hmResult1.get("CONV_FACTOR"));
								alRecord.add(setNumber(""+(inv_qty/eqvl_value),getNoOfDecimals(connection)));
								alRecord.add(setNumber(""+(Double.parseDouble((String)hmDetail.get("UNIT_COST"))*eqvl_value),noOfDecimalsForCost));
								//Modified by suresh.r on 03-11-2014 against Inc 52256 chaged unticost logic end
								alRecord.add(setNumber(""+item_val,noOfDecimalsForCost));
								alRecord.add("");
								alRecord.add(arraylist.get(3));
								alRecord.add(arraylist.get( 4));
								alRecord.add(arraylist.get(5));
								alRecord.add(arraylist.get(3));
								alRecord.add(arraylist.get( 4));
								alRecord.add(arraylist.get(5));
								alAdjDtlRecord.add(alRecord);	


								ArrayList alRecordUpdate	=	new ArrayList();
								/*@ Phy_sical issue for libia   two batch are zero qty  qoh is not updated properly**/
								ArrayList alParameters=new ArrayList();
								alParameters.add((String)hmDetail.get("ITEM_CODE"));
								alParameters.add((String)hmDetail.get("STORE_CODE"));
								alParameters.add(arraylist.get(2));
								alParameters.add(arraylist.get(5));
								//alRecordUpdate.add(""+phy_stk_qty);
								String phy_stk_qty1 =(String)fetchRecord(connection,"select sum(item_qty) PHY_STK_QTY from st_phy_inv_dtl where item_code = ? and store_code = ? and phy_inv_id = ? and facility_id = ? ",alParameters).get("PHY_STK_QTY");
								
								/*added for MMS-ICN-00110 start*/
								HashMap hash1 = new HashMap();
								String chkfields1 [ ] = {(hmDetail.get("ITEM_CODE")).toString() , (hmDetail.get("STORE_CODE")).toString() };
								hash1 =fetchRecord(connection, "SELECT ITEM_VALUE FROM ST_ITEM_STORE WHERE ITEM_CODE = ? AND STORE_CODE= ?", chkfields1 );
								double existing_itemValue =  Double.parseDouble((String)hash1.get("ITEM_VALUE"));
								double newItemValue = existing_itemValue + item_val;
								if ((phy_stk_qty1.equals("0") && newItemValue < 0) || newItemValue < 0){//Modified for TFS-7402
									item_val = 0.0;
								}else{
									item_val = newItemValue;
								}
								/*added for MMS-ICN-00110 end*/
								
								
								alRecordUpdate.add(phy_stk_qty1);
								alRecordUpdate.add(setNumber(""+item_val,noOfDecimalsForCost));//hmDetail.get("COMP_VAL"));
								alRecordUpdate.add(arraylist.get(3));
								alRecordUpdate.add(arraylist.get(4));
								alRecordUpdate.add(arraylist.get(5));
								alRecordUpdate.add(arraylist.get(2));
								alRecordUpdate.add(store_code);
								alRecordUpdate.add(hmDetail.get("ITEM_CODE"));
								alRecordUpdateAll.add(alRecordUpdate);
								
								HashMap hmParametersCuos=new HashMap();
								hmParametersCuos.put("item_code",hmDetail.get("ITEM_CODE"));
								hmParametersCuos.put("store_code",store_code);
								hmParametersCuos.put("trn_type","VAR");
								hmParametersCuos.put("trn_qty",""+inv_qty);
								//Modified by suresh.r on 03-11-2014 against Inc 52256
								//hmParametersCuos.put("trn_unit_cost",hmDetail.get("UNIT_COST"));
								hmParametersCuos.put("trn_unit_cost",setNumber((String)hmDetail.get("UNIT_COST"),noOfDecimalsForCost));
								hmParametersCuos.put("trn_value",setNumber(""+item_val,noOfDecimalsForCost));
								hmParametersCuos.put("from_stk_item_yn","Y");
								hmParametersCuos.put("last_issue_date",arraylist.get(6));
								hmParametersCuos.put("login_by_id",			arraylist.get(3));
								hmParametersCuos.put("login_at_ws_no",		arraylist.get(4));
								hmParametersCuos.put("login_facility_id",	arraylist.get(5));
								//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 begin
								hmParametersCuos.put("pos_var_qty",""+pos_var_qty);
								hmParametersCuos.put("pos_var_cost",setNumber(""+pos_var_cost,noOfDecimalsForCost));
								hmParametersCuos.put("neg_var_qty",""+neg_var_qty);
								hmParametersCuos.put("neg_var_cost",setNumber(""+neg_var_cost,noOfDecimalsForCost));
								//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 end

								hmResult	=	insertOrUpdateItemMoveSummary(connection, hmParametersCuos,hashmapQuery);
						}
						temp_code=(String)hmDetail.get("ITEM_CODE");
					}
							
					if(((String)hmDetail.get("STORE_CODE")).equals(temp_store)){
							
						trn_srl_no++;
						ArrayList alExpRecord=new ArrayList();
						alExpRecord.add(arraylist.get(5));
						alExpRecord.add(arraylist.get(1));
						alExpRecord.add(doc_no);
						alExpRecord.add(""+srl_no);
						alExpRecord.add(store_code);
						alExpRecord.add(hmDetail.get("ITEM_CODE"));
						alExpRecord.add(hmDetail.get("BATCH_ID"));
						alExpRecord.add(hmDetail.get("BIN_LOCATION_CODE"));
						alExpRecord.add(hmDetail.get("EXPIRY_DATE"));
						alExpRecord.add(hmDetail.get("TRADE_ID"));
						alExpRecord.add(hmDetail.get("VAR_QTY"));
						alExpRecord.add(arraylist.get(2));
						alExpRecord.add(hmDetail.get("COMP_QTY"));
						alExpRecord.add(hmDetail.get("ITEM_VAL"));
						alExpRecord.add(arraylist.get(3));
						alExpRecord.add(arraylist.get( 4));
						alExpRecord.add(arraylist.get(5));
						alExpRecord.add(arraylist.get(3));
						alExpRecord.add(arraylist.get( 4));
						alExpRecord.add(arraylist.get(5));
						alExpRecordAll.add(alExpRecord);

						HashMap hmParamaters = new HashMap();
						HashMap hmSQL		 = new HashMap();

						String SQL_ST_CHECK_BATCH_EXISTS		= eST.Common.StEJBRepository.getStKeyValue("SQL_ST_CHECK_BATCH_EXISTS");
						String SQL_ST_BATCH_CONTROL_INSERT		= eST.Common.StEJBRepository.getStKeyValue("SQL_ST_BATCH_CONTROL_INSERT");
						String SQL_ST_CHECK_ITEM_BATCH_EXISTS		= eST.Common.StEJBRepository.getStKeyValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS");
						String SQL_ST_ITEM_BATCH_INSERT		= eST.Common.StEJBRepository.getStKeyValue("SQL_ST_ITEM_BATCH_INSERT");
						String SQL_ST_GET_ITEM_BATCH_STOCK_POS		= eST.Common.StEJBRepository.getStKeyValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS");
						String SQL_ST_ITEM_BATCH_DELETE		= eST.Common.StEJBRepository.getStKeyValue("SQL_ST_ITEM_BATCH_DELETE");
						String SQL_ST_ITEM_BATCH_UPDATE		= eST.Common.StEJBRepository.getStKeyValue("SQL_ST_ITEM_BATCH_UPDATE");

						hmSQL.put("BatchExistsCheckSQL",SQL_ST_CHECK_BATCH_EXISTS);
						hmSQL.put("BatchControlInsertSQL",SQL_ST_BATCH_CONTROL_INSERT);
						hmSQL.put("ItemBatchExistsCheckSQL",SQL_ST_CHECK_ITEM_BATCH_EXISTS);
						hmSQL.put("ItemBatchInsertSQL",SQL_ST_ITEM_BATCH_INSERT);
						hmSQL.put("ItemBatchStcPosSelectSQL",SQL_ST_GET_ITEM_BATCH_STOCK_POS);
						hmSQL.put("ItemBatchDeleteSQL",SQL_ST_ITEM_BATCH_DELETE);
						hmSQL.put("ItemBatchUpdateSQL",SQL_ST_ITEM_BATCH_UPDATE);
							
						hmParamaters.put("item_code",hmDetail.get("ITEM_CODE"));
						hmParamaters.put("store_code",hmDetail.get("STORE_CODE"));
						hmParamaters.put("trn_type","VAR");
// mod on 18/12	
						hmParamaters.put("trn_qty", hmDetail.get("VAR_QTY"));

						hmParamaters.put("batch_id",hmDetail.get("BATCH_ID"));
						hmParamaters.put("expiry_date_or_receipt_date",hmDetail.get("EXPIRY_DATE"));
						hmParamaters.put("trade_id",hmDetail.get("TRADE_ID"));
						hmParamaters.put("from_bin_location_code",hmDetail.get("BIN_LOCATION_CODE"));
						hmParamaters.put("suspended_batch_allowed_yn","Y");
						hmParamaters.put("release_batch_yn","N");
						hmParamaters.put("last_receipt_date",arraylist.get(6)); // doc_date

						hmParamaters.put("login_by_id",			arraylist.get(3));
						hmParamaters.put("login_at_ws_no",		arraylist.get(4));
						hmParamaters.put("login_facility_id",	arraylist.get(5));

// code added on 18/12
						ArrayList alParams=new ArrayList();
	//					alParams.add(hmDetail.get("PHY_STK_QTY"));
						alParams.add(arraylist.get(3));
						alParams.add(arraylist.get(4));
						alParams.add(arraylist.get(5));
						alParams.add(arraylist.get(2));
						alParams.add(store_code);
						alParams.add(hmDetail.get("ITEM_CODE"));
						alParams.add(hmDetail.get("BATCH_ID"));
						alParams.add(hmDetail.get("BIN_LOCATION_CODE"));
						alParams.add(hmDetail.get("EXPIRY_DATE"));

						alUpdateAll.add(alParams);

						hmArgData.put(DATA,alUpdateAll);
						hmArgSQL.put(BATCH_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_UPDATE_BATCH"));
						hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);
//code ended

						updateBatchOnLine(connection, hmSQL, hmParamaters);

						ArrayList alTrnRecord=new ArrayList();

						alTrnRecord.add(arraylist.get(5));
						alTrnRecord.add(store_code);
						alTrnRecord.add(hmDetail.get("ITEM_CODE"));
						alTrnRecord.add(""+trn_srl_no);
						alTrnRecord.add("VAR");
						alTrnRecord.add(arraylist.get(1)); // doc_type_code
						alTrnRecord.add(doc_no); // doc_no
						alTrnRecord.add(""+srl_no);
						alTrnRecord.add(arraylist.get(6)); // doc_date							  
						alTrnRecord.add(""); // doc_ref
						alTrnRecord.add(hmDetail.get("BATCH_ID"));
						alTrnRecord.add(hmDetail.get("EXPIRY_DATE"));
						alTrnRecord.add(hmDetail.get("VAR_QTY"));						// item_qty_normal
						alTrnRecord.add(setNumber((String)hmDetail.get("UNIT_COST"),noOfDecimalsForCost));
						//Modified by suresh.r on 07-08-2014 against MMS-SCF-0390 beg
						/*HashMap hmResult1 = new HashMap();
						ArrayList alConvParam=new ArrayList();
						alConvParam.add(hmDetail.get("ITEM_CODE"));
						alConvParam.add(store_code);
						hmResult1 = fetchRecord(connection,"SELECT ST_GET_UOM_CONV_FAC_SING_STR(?,?) CONV_FACTOR FROM DUAL",alConvParam);
						double eqvl_value = Double.parseDouble((String)hmResult1.get("CONV_FACTOR"));
						alTrnRecord.add(setNumber(""+(Double.parseDouble((String)hmDetail.get("UNIT_COST"))/eqvl_value),noOfDecimalsForCost));*/
						//Modified by suresh.r on 07-08-2014 against MMS-SCF-0390 end
						ArrayList arr_lang=new ArrayList();
						arr_lang.add((String)hmDetail.get("ITEM_CODE"));
						arr_lang.add((String)hashmapQuery.get("LANGUAGE_ID"));
						HashMap hmUOMRecord=fetchRecord(connection,(String)hashmapQuery.get("SQL_ST_ITEM_SELECT_SINGLE"),arr_lang);
						alTrnRecord.add(hmUOMRecord.get("GEN_UOM_CODE")); // stk_uom_code -  has to be changed
						alTrnRecord.add("Y"); // stock_item_yn									  
						alTrnRecord.add(arraylist.get(3));
						alTrnRecord.add(arraylist.get(4));
						alTrnRecord.add(arraylist.get(5));
						alTrnRecord.add(arraylist.get(3));
						alTrnRecord.add(arraylist.get(4));
						alTrnRecord.add(arraylist.get(5));									  
						alTrnRecord.add(hmDetail.get("BIN_LOCATION_CODE"));
						alTrnRecord.add(hmDetail.get("TRADE_ID"));		
						alExpRecordAllData.add(alTrnRecord);
					}
//					temp_store=(String)hmDetail.get("STORE_CODE");				
				}
				hmArgData.put(DATA,alAdjRecord);
				hmArgSQL.put(BATCH_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_INSERT"));
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

				hmArgData.put(DATA,alAdjDtlRecord);
				hmArgSQL.put(BATCH_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_INSERT_DTL"));
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

				hmArgData.put(DATA,alRecordUpdateAll);
				hmArgSQL.put(BATCH_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_UPDATE_STORE"));
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

				//Added for NMC-JD-SCF-0296 starts
				String checkSTItemStoresSql="SELECT COUNT (*) COUNT FROM st_item_store WHERE phy_inv_id = '"+arraylist.get(2)+"'";
				hmResult=fetchRecord(connection,  checkSTItemStoresSql);
				if(!hmResult.get("COUNT" ).equals("0")){
				ArrayList alParameters1	=	new ArrayList();
				alParameters1.add(arraylist.get(3));//Login id
				alParameters1.add(arraylist.get(4));// At_ws_no
				alParameters1.add(arraylist.get(5));//facility_id
				alParameters1.add(arraylist.get(5));//facility_id
				alParameters1.add(arraylist.get(2));//phy_inv_id
				hmArgData.put(DATA, alParameters1);
				hmArgSQL.put(UPDATE_SQL,(String)hashmapQuery.get("SQL_ST_ITEM_STORE_UPDATE_FOR_POST_VARIANCE_2"));
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);}
				//Added for NMC-JD-SCF-0296 ends

				hmArgData.put(DATA,alExpRecordAll);
				hmArgSQL.put(BATCH_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_INSERT_BATCH"));
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

				hmArgData.put(DATA,alExpRecordAllData);
				hmArgSQL.put(BATCH_SQL,(String)hashmapQuery.get("SQL_ST_ITEM_TRN_DTL_INSERT"));
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

				ArrayList alParametersvariance	=	new ArrayList();
				alParametersvariance.add(arraylist.get(3));//Login id
				alParametersvariance.add(arraylist.get(4));// At_ws_no
				alParametersvariance.add(arraylist.get(5));//facility_id
				alParametersvariance.add(arraylist.get(5));//facility_id
				alParametersvariance.add(arraylist.get(2));//phy_inv_id

				hmArgData.put(DATA,alParametersvariance);
				hmArgSQL.put(UPDATE_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_UPDATE_PARAM"));
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);
				
				alUpdateParam.add(arraylist.get(5));
				alUpdateParam.add(arraylist.get(2));

				hmArgData.put(DATA,alUpdateParam);
				hmArgSQL.put(DELETE_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_DTL_DELETE"));
				hmResult	=	delete(connection, hmArgData, hmArgSQL);
				//throwExceptionWhenFailed(hmResult);

				
				hmArgData.put(DATA,alUpdateParam);
				hmArgSQL.put(DELETE_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_HDR_DELETE"));
				hmResult	=	delete(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);
				{
					ArrayList alPhyParameters	= new ArrayList();
					alPhyParameters.add(arraylist.get(3));//Login id
					alPhyParameters.add(arraylist.get(4));// At_ws_no
					alPhyParameters.add(arraylist.get(5));//facility_id
					alPhyParameters.add(arraylist.get(2));//phy_inv_id
					/**
						* @Name - krishna reddy
						* @Date - 22/12/2009
						* @Inc# - IN017304
						* @Desc - Update the columns PHY_INV_ID, PHY_INV_START_DATE and PHY_INV_START_QTY in ST_ITEM_BATCH table facility wise.
					*/
					alPhyParameters.add(arraylist.get(7));//store_code
					//alPhyParameters.add(sb.toString());//Added for IN072061, Commented for TFS-7402
					hmArgData.put(DATA, alPhyParameters);
					String sql2="update st_item_batch set phy_inv_id=null, PHY_INV_START_DATE=null, PHY_INV_START_QTY=null , modified_by_id=?, modified_date=SYSDATE, modified_at_ws_no=?, modified_facility_id=?  where phy_inv_id=? and store_code=? AND item_code IN ("+sb.toString()+")"; //Modified for TFS-7402
					hmArgSQL.put(UPDATE_SQL,sql2);//Modified for IN072061, Modified for TFS-7402
					update(connection, hmArgData, hmArgSQL);

					
					String sql1="select item_code, store_code, sum(qty_on_hand) qty_on_hand from st_item_batch where store_code="+new_store_code+" and item_code in ("+sb.toString()+") group by item_code, store_code";//Added for IN072061
					try { 
						ArrayList alQtyOnHandUpdate = fetchRecords(connection,sql1);
						HashMap hmQty=null;
						ArrayList alQtyParam=new ArrayList();
						ArrayList alQtyParam1=new ArrayList();
						HashMap hmResult1 = new HashMap();
						String	eqvl_value = "";
						double		store_qty  = 0;
//SELECT EQVL_VALUE CONV_FACTOR  FROM MM_ITEM_UOM_DEFN WHERE UOM_CODE = (SELECT GEN_UOM_CODE FROM MM_ITEM_LANG_VW WHERE ITEM_CODE=? AND LANGUAGE_ID = ?) AND EQVL_UOM_CODE= (SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE= ? AND ITEM_CODE=  ?) AND ITEM_CODE = ? UNION SELECT	eqvl_value FROM	am_uom_eqvl	WHERE uom_code = (SELECT GEN_UOM_CODE FROM MM_ITEM_LANG_VW WHERE ITEM_CODE=? AND LANGUAGE_ID = ?) AND eqvl_uom_code= (SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=?)
						for (int i=0; i<alQtyOnHandUpdate.size(); i++) {
							hmQty=(HashMap)alQtyOnHandUpdate.get(i);
							alQtyParam.clear();
							alQtyParam1.clear();
							store_qty  = 0;
							alQtyParam1.add(hmQty.get("ITEM_CODE"));
							//alQtyParam1.add((String)hashmapQuery.get("LANGUAGE_ID"));
							alQtyParam1.add(hmQty.get("STORE_CODE"));
							//alQtyParam1.add(hmQty.get("ITEM_CODE"));
							//alQtyParam1.add(hmQty.get("ITEM_CODE"));
							//alQtyParam1.add(hmQty.get("ITEM_CODE"));
							//alQtyParam1.add((String)hashmapQuery.get("LANGUAGE_ID"));
							//alQtyParam1.add(hmQty.get("STORE_CODE"));
							//alQtyParam1.add(hmQty.get("ITEM_CODE"));
							hmResult1 = new HashMap();
							hmResult1 = fetchRecord(connection,"SELECT ST_GET_UOM_CONV_FAC_SING_STR(?,?) CONV_FACTOR FROM DUAL",alQtyParam1);
							eqvl_value = (String)hmResult1.get("CONV_FACTOR");
							store_qty  = Double.parseDouble((String)hmQty.get("QTY_ON_HAND"))/Double.parseDouble(eqvl_value);
							alQtyParam.add(""+store_qty);
							alQtyParam.add(arraylist.get(3));//Login id
							alQtyParam.add(arraylist.get(4));// At_ws_no
							alQtyParam.add(arraylist.get(5));//facility_id
							alQtyParam.add(hmQty.get("STORE_CODE"));
							alQtyParam.add(hmQty.get("ITEM_CODE"));
							
							hmArgData.put(DATA, alQtyParam);
							hmArgSQL.put(UPDATE_SQL,(String)hashmapQuery.get("SQL_ST_ITEM_STORE_UPDATE_QTY_ON_HAND_1"));//Modified for IN072061
							update(connection, hmArgData, hmArgSQL);

						}				
					}
					catch (Exception exception) {
						exception.printStackTrace();
					}
				}
//Commented for IN072061
				/*ArrayList alParameters	=	new ArrayList();
				alParameters.add(arraylist.get(3));//Login id
				alParameters.add(arraylist.get(4));// At_ws_no
				alParameters.add(arraylist.get(5));//facility_id
				alParameters.add(arraylist.get(5));//facility_id
				alParameters.add(arraylist.get(2));//phy_inv_id
				hmArgData.put(DATA, alParameters);
				hmArgSQL.put(UPDATE_SQL,(String)hashmapQuery.get("SQL_ST_ITEM_STORE_UPDATE_FOR_POST_VARIANCE_2"));//added _2
				hmResult	=	update(connection, hmArgData, hmArgSQL);*/
				//throwExceptionWhenFailed(hmResult);

				/*ArrayList alParametersBatch	=	new ArrayList();
				alParametersBatch.add(arraylist.get(3));//Login id
				alParametersBatch.add(arraylist.get(4));// At_ws_no
				alParametersBatch.add(arraylist.get(5));//facility_id
				alParametersBatch.add(arraylist.get(2));//phy_inv_id
				
				alParametersBatch.add(arraylist.get(7));//store_code

				hmArgData.put(DATA, alParametersBatch);
				hmArgSQL.put(UPDATE_SQL,(String)hashmapQuery.get("SQL_ST_POST_VARIANCE_UPDATE_ALL_BATCH"));
				hmResult	=	update(connection, hmArgData, hmArgSQL);*/
//Commented for IN072061
				ArrayList alItemCostParameter	=	new ArrayList();
				/*added for MMS-ICN-00110 start*/
				ArrayList alData		=	new ArrayList();
				HashMap hashhh= new HashMap();
				HashMap hash2= new HashMap();
				HashMap hmResult2 = new HashMap();
				double mm_unit_cost=0.0;
				double displayUnitCost = 0.0;
				/*added for MMS-ICN-00110 end*/
				
				for (Iterator iterator=hsItem.iterator(); iterator.hasNext();) {
					String stItem	=	(String)iterator.next();
					ArrayList alICParam	=	new ArrayList();
					/*alICParam.add(stItem);
					
					alICParam.add(arraylist.get(3));//Login id
					alICParam.add(arraylist.get(4));// At_ws_no
					alICParam.add(arraylist.get(5));//facility_id
					alICParam.add(stItem);
					alItemCostParameter.add(alICParam);*/ // commented for MMS-ICN-00110
					
					/*ADDED FOR MMS-ICN-00110 start*/
					hash2 =fetchRecord(connection, "select st_display_unit_cost(?,sysdate,'CURRENT_STOCK') UNIT_COST1 from dual", stItem );
					hashhh =fetchRecord(connection, "SELECT UNIT_COST FROM MM_ITEM WHERE ITEM_CODE = ?", stItem );
					
					
					mm_unit_cost =  Double.parseDouble((String)hashhh.get("UNIT_COST"));
					displayUnitCost = Double.parseDouble((String)hash2.get("UNIT_COST1"));
						
					
					if(mm_unit_cost!=displayUnitCost){
						
						stSQL = " select * from mm_item where ITEM_CODE = ? for update nowait ";
						alData.add(stItem);
						hmResult2 = fetchRecord(connection,stSQL,alData);
						
						alData.clear();
						alICParam.add(displayUnitCost);
						alICParam.add(arraylist.get(3));//Login id
						alICParam.add(arraylist.get(4));// At_ws_no
						alICParam.add(arraylist.get(5));//facility_id
						alICParam.add(stItem);
						alItemCostParameter.add(alICParam);
					}
					else{
						if(mm_unit_cost<0){
							mm_unit_cost = 	displayUnitCost;
						}
						alICParam.add(mm_unit_cost); /*ADDED FOR MMS-ICN-00110 end*/
						alICParam.add(arraylist.get(3));//Login id
						alICParam.add(arraylist.get(4));// At_ws_no
						alICParam.add(arraylist.get(5));//facility_id
						alICParam.add(stItem);
						alItemCostParameter.add(alICParam);
					} // added for MMS-ICN-00110
					
						
				}
				hmArgData.put(DATA, alItemCostParameter);
				hmArgSQL.put(BATCH_SQL,(String)hashmapQuery.get("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE"));
				hmResult	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

			}
//Commented for IN072061
			/*if(alBatchRecords.size()!=0){
			ArrayList alPhyParameters	= new ArrayList();
			alPhyParameters.add(arraylist.get(3));//Login id
			alPhyParameters.add(arraylist.get(4));// At_ws_no
			alPhyParameters.add(arraylist.get(5));//facility_id
			alPhyParameters.add(arraylist.get(2));//phy_inv_id
			
			alPhyParameters.add(arraylist.get(7));//store_code

			hmArgData.put(DATA, alPhyParameters);
			hmArgSQL.put(UPDATE_SQL,(String)hashmapQuery.get("SQL_ST_ITEM_BATCH_UPDATE_PHY_INV"));
			update(connection, hmArgData, hmArgSQL);
			}*/
//Commented for IN072061
			
/*			try { 
				ArrayList alQtyOnHandUpdate = fetchRecords(connection,(String)hashmapQuery.get("SQL_ST_ITEM_BATCH_SELECT_QTY_ON_HAND"));
				HashMap hmQty=null;
				ArrayList alQtyParam=new ArrayList();

				for (int i=0; i<alQtyOnHandUpdate.size(); i++) {
					hmQty=(HashMap)alQtyOnHandUpdate.get(i);
					alQtyParam.clear();
					alQtyParam.add(hmQty.get("QTY_ON_HAND"));
					alQtyParam.add(arraylist.get(3));//Login id
					alQtyParam.add(arraylist.get(4));// At_ws_no
					alQtyParam.add(arraylist.get(5));//facility_id
					alQtyParam.add(hmQty.get("STORE_CODE"));
					alQtyParam.add(hmQty.get("ITEM_CODE"));
					
					hmArgData.put(DATA, alQtyParam);
					hmArgSQL.put(UPDATE_SQL,(String)hashmapQuery.get("SQL_ST_ITEM_STORE_UPDATE_QTY_ON_HAND"));
					update(connection, hmArgData, hmArgSQL);

				}				
			}
*/
//Commented for IN072061 start
			/*String sql1="select item_code, store_code, sum(qty_on_hand) qty_on_hand from st_item_batch where store_code="+new_store_code+" and item_code in ("+sb.toString()+") group by item_code, store_code";		
			try { 
						ArrayList alQtyOnHandUpdate = fetchRecords(connection,sql1);
						HashMap hmQty=null;
						ArrayList alQtyParam=new ArrayList();
						ArrayList alQtyParam1=new ArrayList();
						HashMap hmResult1 = new HashMap();
						String	eqvl_value = "";
						double		store_qty  = 0;
//SELECT EQVL_VALUE CONV_FACTOR  FROM MM_ITEM_UOM_DEFN WHERE UOM_CODE = (SELECT GEN_UOM_CODE FROM MM_ITEM_LANG_VW WHERE ITEM_CODE=? AND LANGUAGE_ID = ?) AND EQVL_UOM_CODE= (SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE= ? AND ITEM_CODE=  ?) AND ITEM_CODE = ? UNION SELECT	eqvl_value FROM	am_uom_eqvl	WHERE uom_code = (SELECT GEN_UOM_CODE FROM MM_ITEM_LANG_VW WHERE ITEM_CODE=? AND LANGUAGE_ID = ?) AND eqvl_uom_code= (SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=?)
						for (int i=0; i<alQtyOnHandUpdate.size(); i++) {
							hmQty=(HashMap)alQtyOnHandUpdate.get(i);
							alQtyParam.clear();
							alQtyParam1.clear();
							store_qty  = 0;
							alQtyParam1.add(hmQty.get("ITEM_CODE"));
							//alQtyParam1.add((String)hashmapQuery.get("LANGUAGE_ID"));
							alQtyParam1.add(hmQty.get("STORE_CODE"));
							//alQtyParam1.add(hmQty.get("ITEM_CODE"));
							//alQtyParam1.add(hmQty.get("ITEM_CODE"));
							//alQtyParam1.add(hmQty.get("ITEM_CODE"));
							//alQtyParam1.add((String)hashmapQuery.get("LANGUAGE_ID"));
							//alQtyParam1.add(hmQty.get("STORE_CODE"));
							//alQtyParam1.add(hmQty.get("ITEM_CODE"));
							hmResult1 = new HashMap();
							hmResult1 = fetchRecord(connection,"SELECT ST_GET_UOM_CONV_FAC_SING_STR(?,?) CONV_FACTOR FROM DUAL",alQtyParam1);
							eqvl_value = (String)hmResult1.get("CONV_FACTOR");
							store_qty  = Double.parseDouble((String)hmQty.get("QTY_ON_HAND"))/Double.parseDouble(eqvl_value);
							alQtyParam.add(""+store_qty);
							alQtyParam.add(arraylist.get(3));//Login id
							alQtyParam.add(arraylist.get(4));// At_ws_no
							alQtyParam.add(arraylist.get(5));//facility_id
							alQtyParam.add(hmQty.get("STORE_CODE"));
							alQtyParam.add(hmQty.get("ITEM_CODE"));
							
							hmArgData.put(DATA, alQtyParam);
							hmArgSQL.put(UPDATE_SQL,(String)hashmapQuery.get("SQL_ST_ITEM_STORE_UPDATE_QTY_ON_HAND"));
							update(connection, hmArgData, hmArgSQL);

						}				
					}catch (Exception exception) {
				exception.printStackTrace();
			}*/
//Commented for IN072061 end
			connection.commit();
			if (connection!=null) {
					closeConnection(connection,properties);	
				}
        }
        catch(SQLException sqlexception)
        {
            try
            {
                connection.rollback();
				hmResult.put(RESULT,FALSE);
                hmResult.put(MESSAGE,sqlexception.toString());
				hmResult.put(MSGID,sqlexception.getMessage());
                sqlexception.printStackTrace();
            }
            catch(Exception exception)
            {
				 //connection.rollback();
                hmResult.put(RESULT,FALSE);
				hmResult.put(MESSAGE,exception.toString());
				hmResult.put(MSGID,exception.getMessage());
				exception.printStackTrace();
            }
        }
        catch(Exception exception1)
        {
            try
            {
                connection.rollback();
				hmResult.put(RESULT,FALSE);
                hmResult.put(MESSAGE,exception1.toString());
				hmResult.put(MSGID,exception1.getMessage());
                exception1.printStackTrace();
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
       	finally {
			 try{
				
				if (connection!=null) {
					closeConnection(connection,(Properties)hashmap.get(properties));	
				}
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
        return hmResult;
    }

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap modify(HashMap hashmap, HashMap hashmap1)
    {
        HashMap hashmap2 = new HashMap();
        return hashmap2;
    }

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap delete(HashMap hashmap, HashMap hashmap1)
    {
        HashMap hashmap2 = new HashMap();
        return hashmap2;
    }

	public HashMap insertOrUpdateItemMoveSummary(Connection connection, HashMap hmParameters,HashMap hashmapQuery) throws Exception {
		
		
		HashMap hmColumns	=	new HashMap();

		hmColumns.put("doc_date",hmParameters.get("last_issue_date"));
		hmColumns.put("facility_id",hmParameters.get("login_facility_id"));
		hmColumns.put("item_code",hmParameters.get("item_code"));
		hmColumns.put("store_code",hmParameters.get("store_code"));
		hmColumns.put("login_by_id",hmParameters.get("login_by_id"));
		hmColumns.put("login_at_ws_no",hmParameters.get("login_at_ws_no"));
		hmColumns.put("login_facility_id",hmParameters.get("login_facility_id"));

		hmColumns.put("var_qty",hmParameters.get	("trn_qty"));
		hmColumns.put("var_cost",hmParameters.get	("trn_value"));
		
		hmColumns.put("month_closing_qty",hmParameters.get("trn_qty"));
		hmColumns.put("month_closing_value",hmParameters.get("trn_value"));
		hmColumns.put("stk_item_yn","Y");
		//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 begin
		hmColumns.put("pos_var_qty",hmParameters.get("pos_var_qty"));
		hmColumns.put("pos_var_cost",hmParameters.get("pos_var_cost"));
		hmColumns.put("neg_var_qty",hmParameters.get("neg_var_qty"));
		hmColumns.put("neg_var_cost",hmParameters.get("neg_var_cost"));
		//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 end
		return insertOrUpdateItemMove(connection, hmColumns,hashmapQuery);
	}

	public HashMap insertOrUpdateItemMove(Connection connection, HashMap hmColumns,HashMap hashQuery) throws Exception {
		String SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT	= eST.Common.StEJBRepository.getStKeyValue("SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT");
		String SQL_ST_GET_MONTH_AND_YEAR	= eST.Common.StEJBRepository.getStKeyValue("SQL_ST_GET_MONTH_AND_YEAR");
		HashMap	hmArgData				=	new HashMap();
		HashMap	hmArgSQL				=	new HashMap();

		ArrayList alParameters	=	new ArrayList();
		ArrayList alData		=	new ArrayList();

		String doc_date	= (String)hmColumns.get("doc_date"); //doc_date
		String stSQL;

		alParameters.add(doc_date);
		alParameters.add(doc_date);
		HashMap hmResult = fetchRecord(connection,SQL_ST_GET_MONTH_AND_YEAR);

		String move_month	= (String)hmResult.get("MM");
		String move_year	= (String)hmResult.get("YYYY");

		String	facility_id         	=	(String)hmColumns.get("facility_id");
		String	item_code           	=	(String)hmColumns.get("item_code");
		String	store_code          	=	(String)hmColumns.get("store_code");
		String	month_closing_qty   	="";
		String	month_closing_value 	=	"";
		
		String	stock_item_yn		 	="Y";
		String	var_qty             	=	"";
		String	var_cost            	="";
		String pos_var_qty ="0", pos_var_cost ="0"  ,neg_var_qty  ="0"  ,neg_var_cost ="0"; 
		
			var_qty =	stock_item_yn.equals("Y")?((String)hmColumns.get("var_qty")):"0";
			var_cost   =	stock_item_yn.equals("Y")?((String)hmColumns.get("var_cost")):"0";
			month_closing_qty   	=	((String)hmColumns.get("month_closing_qty"));
			month_closing_value 	=	((String)hmColumns.get("month_closing_value"));
			/**
		 * @Name - Priya
		 * @Date - 10/06/2010
		 * @Inc# - 
		 * @Desc - To assign month_closing_value as zero if month_closing_qty =0
		 */
		
		if(Double.valueOf(month_closing_qty) == 0){
			month_closing_value = "0";
		}
			/* Commented by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 begin
			if(Double.parseDouble(var_qty)>0) 
				pos_var_qty= var_qty;
			if(Double.parseDouble(var_cost)>0)
				pos_var_cost= var_cost;

			if(Double.parseDouble(var_qty)<0) 
				neg_var_qty= var_qty;
			if(Double.parseDouble(var_cost)<0) 
				neg_var_cost= var_cost;
			Commented by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 end*/
		//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 begin
		pos_var_qty=(String)hmColumns.get("pos_var_qty");
		pos_var_cost=(String)hmColumns.get("pos_var_cost");
		neg_var_qty=(String)hmColumns.get("neg_var_qty");
		neg_var_cost=(String)hmColumns.get("neg_var_cost");
		//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 end

		String	login_by_id 			=	(String)hmColumns.get("login_by_id");
		String	login_at_ws_no 			=	(String)hmColumns.get("login_at_ws_no");
		String	login_facility_id 		=	(String)hmColumns.get("login_facility_id");

		alParameters.clear();
		alParameters.add(facility_id);
		alParameters.add(item_code);
		alParameters.add(store_code);
		alParameters.add(move_year);
		alParameters.add(move_month);
		/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/
		ArrayList  nafitive_value_to_zero=new ArrayList();
		nafitive_value_to_zero.add(facility_id);      // facility_id
		nafitive_value_to_zero.add(item_code);     // Item code
		nafitive_value_to_zero.add(store_code);    // store_code
		nafitive_value_to_zero.add(move_month);
		nafitive_value_to_zero.add(move_year);
	

		hmResult = fetchRecord(connection,SQL_ST_ITEM_MOVE_SUMM_SELECT_COUNT,alParameters);

		if(((String)hmResult.get("TOTAL")).equals("0")) {//no record found

			alData.add(facility_id        );
			alData.add(item_code          );
			alData.add(store_code         );
			alData.add(move_year          );
			alData.add(move_month         );
			//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 begin
			alData.add(month_closing_qty  );
			alData.add(month_closing_value);
			//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 end
	
//code added on 22/12 to make var_qty equal to pos_var_qty in case of negative adjustment
			/*Commented by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 begin
			if(negative_flag)
			{
			alData.add(neg_var_qty            );
			alData.add(neg_var_cost           );
			}
			else
			{Commented by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 end*/
			alData.add(var_qty           );
			alData.add(var_cost          );
			//}Commented by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013
// code ended....
	
			alData.add(pos_var_qty           );
			alData.add(pos_var_cost           );
			alData.add(neg_var_qty           );
			alData.add(neg_var_cost           );
			
			/*Commented by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 begin
			alData.add(month_closing_qty  );
			alData.add(month_closing_value);
			Commented by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013 end*/

			alData.add(login_by_id 		  );
			alData.add(login_at_ws_no 	  );
			alData.add(login_facility_id  );
			alData.add(login_by_id 		  );
			alData.add(login_at_ws_no 	  );
			alData.add(login_facility_id  );
			System.out.println("alData at insertOrUpdateItemMove() Before Insert====>"+alData);
			stSQL	=	(String)hashQuery.get("SQL_ST_POST_VARIANCE_ITEM_MOMENT_INSERT");
			hmArgData.put(DATA,alData);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmResult	=	insert(connection, hmArgData, hmArgSQL);
		}
		else {
			
			
			alData.add(month_closing_qty  );
			alData.add(month_closing_value);
	//		alData.add(var_qty            );
	//		alData.add(var_cost           );

	//code added on 22/12 to make var_qty equal to pos_var_qty in case of negative adjustment
			if(negative_flag)
			{
				alData.add(var_qty);	
				alData.add(var_cost);	
				alData.add(pos_var_qty);
				alData.add(pos_var_cost);
				alData.add(neg_var_qty);
				alData.add(neg_var_cost);

			}
			else
			{
				alData.add(var_qty);
				alData.add(var_cost);
				alData.add(pos_var_qty);
				alData.add(pos_var_cost);
				alData.add(neg_var_qty);
				alData.add(neg_var_cost);
			}
// code changed ended........23/12
			alData.add(login_by_id 		  );
			alData.add(login_at_ws_no 	  );
			alData.add(login_facility_id  );

			alData.add(facility_id        );
			alData.add(item_code          );
			alData.add(store_code         );
			alData.add(move_year          );
			alData.add(move_month         );
			System.out.println("alData at insertOrUpdateItemMove() Before Update====>"+alData);
			stSQL = (String)hashQuery.get("SQL_ST_POST_VARIANCE_ITEM_MOMENT_UPDATE");

			hmArgData.put(DATA,alData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			
			hmResult	=	update(connection, hmArgData, hmArgSQL);
		}
		throwExceptionWhenFailed(hmResult);

			/** @Desc - To assign month_closing_value as zero if month_closing_qty =0 **/

		//stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? "; //Commented by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013
		stSQL="UPDATE st_item_move_summ SET month_opening_value = (CASE WHEN month_opening_qty = 0 THEN 0 WHEN month_opening_value < 0 THEN 0 WHEN month_opening_value > 0   THEN month_opening_value END ), month_closing_value = (CASE WHEN month_closing_qty = 0 THEN 0 WHEN month_closing_value < 0 THEN 0 WHEN month_closing_value > 0 THEN month_closing_value END ) WHERE facility_id = ? AND item_code = ? AND store_code = ? AND move_month = ? AND move_year = ? ";//Added by suresh.r against KDAH-SCF-0215(#46127) on 30-12-2013
		hmArgData.put(DATA,nafitive_value_to_zero);
		hmArgSQL.put(UPDATE_SQL,stSQL);
		hmResult	=	update(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmResult);
		return hmResult;
	}
}
