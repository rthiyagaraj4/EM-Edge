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
25/02/2016				57461					B.Badmavathi									  Product Transfer\Repackaging	
06/04/2017				IN063878				Badmavathi B					        					 Unused variables			
14/08/2018				IN068355				Shazana Hasan										ML-MMOH-SCF-1065			
07/06/2019              IN:070603	            B Haribabu                                          AAKH-SCF-0400
8/8/2021				TFS:21452        		Shazana                      						ML-MMOH-SCF-1861
17/8/2021				TFS:21989        		Manickavasagam                      				KAUH-SCF-0344
--------------------------------------------------------------------------------------------------------------------------------------------
*/

 package eST ;


import java.sql.*;
import java.util.*;
import java.io.Serializable;
//import java.util.ArrayList;
// pmd 21/02/2005
//import java.util.Hashtable;
//import java.util.HashMap;
//import java.util.Properties;

//import eST.Common.StHeaderBean;
//import eST.Common.StAdapter;
//import eST.Common.StTransaction;
//import eST.Common.StEJBSessionAdapter;
//import eST.ItemSearchBean;
import eST.Common.*;
import java.util.Properties;
import com.ehis.util.DateUtils;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.util.BundleMessage;
import javax.servlet.* ;
import javax.servlet.http.*;

//*import eCommon.Common.CommonAdapter;
//*import eCommon.Common.CommonEJBSessionInterface;
//*import javax.servlet.http.HttpServletRequest;

//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
//*import javax.servlet.http.HttpSession;


public class ProductTransferBean extends StTransaction implements Serializable
{
    private StHeaderBean   stHeaderBean	;
	private ProductTransferDetailBean		productTransferDetailBean	;	
	
	private String store_code="" ;//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi on 04/02/2016
	private String prep_loc="";
	private String repackgroup="";
	private String maxAllowed="1";
	private String PDocNo="";
	private String PgetDoc_type_code = "";
	private String locale = "";
	//private String language_id = "";
	public String reportserver = "";
	public String report_connect_string = "";
	
	private String PgetStore_codest = "";
	private String  mfg_delete_yn = "";
	private String report_id="";
	//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
	private boolean site_spec_yn = false;
	private String finalized_yn;
	
	public boolean isSite_spec_yn() {
		return site_spec_yn;
	}
	public void setSite_spec_yn(boolean site_spec_yn) {
		this.site_spec_yn = site_spec_yn;
	}
	public void setFinalized_yn(String finalized_yn) {
		 this.finalized_yn= finalized_yn;
	}

	public String getFinalized_yn( ) {
		 return finalized_yn;
	}
	public void setAll(Hashtable hashtable) {
        super.setAll(hashtable);
        productTransferDetailBean.setAll(hashtable);
		setFinalized_yn((String)hashtable.get("finalize_yn"));
    }
	//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
	//Added on 6/21/2005
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi on 04/02/2016 starts
	private String defaultDocType ;
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}
	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("PRT",defaultDocType);
	}
	String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}
	public void setStore_code(String store_code) {
			this.store_code = store_code;
		}
	public String getStore_code() {
			return store_code;
		}
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi on 04/02/2016 ends
	public void setStHeaderBean(StHeaderBean stHeaderBean){
		this.stHeaderBean = stHeaderBean;		
	}
	public Object getStHeaderBean() {
		return stHeaderBean;
	}

	public void initialize(){
        super.initialize();
		stHeaderBean=new StHeaderBean();
        productTransferDetailBean=new ProductTransferDetailBean();
		stHeaderBean.setProperties(getProperties());
		finalized_yn="N";   //Added for ML-MMOH-CRF-0448 B.Badmavathi
	}


/* private javax.servlet.http.HttpServletRequest request;
	private javax.servlet.http.HttpServletResponse response;

	public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; 
		this.response=response	;
	}*/
    
	public void  clear(){
        super.clear();
		stHeaderBean=null;
        productTransferDetailBean=null;
        site_spec_yn = false;//Added for ML-MMOH-CRF-0448 B.Badmavathi
    	finalized_yn=null;     //Added for ML-MMOH-CRF-0448 B.Badmavathi
       }

   /*public String getPrintDocNo(){
		return PDocNo;
	}*/

    public void setLanguageId(String language_id) {
		 locale= language_id;
	}

	public String getLanguageId( ) {
		
		 return locale;
	}


    public void setProductTransferHeaderBean(StHeaderBean HdrData) {
		stHeaderBean=HdrData; 

	}

	public void setPrep_loc(String prep_loc) {
		 this.prep_loc = prep_loc;
	}


	public String getStoreCode() {
		ArrayList arr_language=new ArrayList();
		arr_language.add(getLoginFacilityId());
		arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"),arr_language),stHeaderBean.getStore_code());										
	}


	public String getPrep_loc( ) {
		 return prep_loc;
	}

	public void setMaxAllowed(String maxAllowed) {
		 this.maxAllowed = checkForNull(maxAllowed,"1");
	}

	public String getMaxAllowed( ) {
		 return maxAllowed;
	}

	public void setRepackGroup(String repackgroup) {
		 this.repackgroup = repackgroup;
	}

	public String getRepackGroup( ) {
		
		 return repackgroup;
	}
	public void setReport_Server(String reportserver) {
		 this.reportserver= reportserver;
 	}

	public String  getReport_Server( ) {
		 return reportserver;
	}
	
	public void setReport_Connect_String(String report_connect_string) {
		 this.report_connect_string= report_connect_string;

	}

	public String getReport_Connect_String( ) {
		 return report_connect_string;
	}

	
	public void setPrintDocNo(String Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public String getPrintDocNo(){
		return PDocNo;
	}
    
	public void setMfg_delete_yn(String mfg_delete_yn) {
		 this.mfg_delete_yn= mfg_delete_yn;

	}

	public String getMfg_delete_yn( ) {
		 return mfg_delete_yn;
	}
	
	public void setReport_id(String report_id) {
		 this.report_id= report_id;
	}
	public String getReport_id() {
		 return report_id;
	}

	public String getBinlocationCodeList(){
		ArrayList arr_language=new ArrayList();
		arr_language.add(stHeaderBean.getStore_code());
		arr_language.add(getLanguageId());

		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_language));
	} 

	public String getPrepLoc(){
		
			ArrayList arr_language=new ArrayList();
			arr_language.add(getLoginFacilityId());
			arr_language.add(getLanguageId());
 
			return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_MAN_REQ_PRELOC_SELECT"),arr_language));
	}

	public String getLabel_reqd_yn(String item_code) throws Exception{
		return (String)fetchRecord(getStRepositoryValue("SQL_ST_LOAD_QUERY"),item_code).get("LABEL_REQD_YN");
	}


	public void setDetailValues(HashMap hashmapDtl) {
		productTransferDetailBean.setValues(hashmapDtl);
	}


  /*
    public String getBinlocationCodeList(String defaultBinLocation){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),stHeaderBean.getStore_code()),defaultBinLocation);
	}
  */

   
	public java.util.ArrayList getBinLocationList(String store_code) {

        ArrayList BinLocationList = new ArrayList();
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"));
            pstmt.setString(1, store_code);
            pstmt.setString(2, getLanguageId());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                BinLocationList.add(record);
            }
        } 
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		return BinLocationList;
	}


public java.util.ArrayList getBinLocation(String store_code,String item_code) {

        ArrayList alBinLocationCode = new ArrayList() ; 
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_BIN_LOCATION_SELECT"));
            pstmt.setString(1, store_code);
            pstmt.setString(2, item_code);
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String record = "";
                record = resultSet.getString(1);
                alBinLocationCode.add(record);
				
            }
        } 
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		return alBinLocationCode;
	}


public java.util.ArrayList getRepackUom(String item_code) {
		
        ArrayList alRepackuomCode = new ArrayList() ; 
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_REPACK_UOM_SELECT"));
            pstmt.setString(1, item_code);
			resultSet = pstmt.executeQuery();
			
            while (resultSet != null && resultSet.next()) {
				
                String record1 = "";
				String record2=  "";
                record1 = resultSet.getString("repacking_group_code");
				record2 = resultSet.getString("repack_unit_uom");

                alRepackuomCode.add(record1);
				alRepackuomCode.add(record2);

            }
        } 
		catch (Exception e) {
			
            e.printStackTrace();
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		return alRepackuomCode;
	}


	public java.util.ArrayList getEqvlUom(String stk_uom,String repack_uom) {
		
		
        ArrayList alEqvlUomCode = new ArrayList() ; 
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
        try {
            connection = getConnection();
			
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_EQVL_UOM_VALUE_SELECT"));
			
            pstmt.setString(1, stk_uom);
			pstmt.setString(2, repack_uom);
			resultSet = pstmt.executeQuery();
			 
			
            while (resultSet != null && resultSet.next()) 
			{
				String eqvluom = "";
				eqvluom = resultSet.getString("eqvl_value");
				alEqvlUomCode.add(eqvluom);
			}
        } 
		catch (Exception e) {
			 e.printStackTrace();
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		
		return alEqvlUomCode;
	}


public java.util.ArrayList getAutoGenYn(String repacking_group_code) {
		
		
        ArrayList alAutoGenYn = new ArrayList() ; 
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
        try {
            connection = getConnection();
			
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_GEN_BATCH_SELECT"));
			
            pstmt.setString(1, repacking_group_code);
			resultSet = pstmt.executeQuery();

			 while (resultSet != null && resultSet.next()) 
			{
				String auto_gen_batch_yn = resultSet.getString("auto_gen_batch_yn");
				String next_batch_id = resultSet.getString("next_batch_id");
				String batch_id_series = resultSet.getString("batch_id_series");
				alAutoGenYn.add(auto_gen_batch_yn);
				alAutoGenYn.add(batch_id_series+next_batch_id);
				//alAutoGenYn.add(batch_id_series);
				
			

			}
        } 
		catch (Exception e) {
			 e.printStackTrace();
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		
		return alAutoGenYn;
		
		
	}


      public ArrayList getDefltBatchId() {
        
        ArrayList alDfltBatchId=new ArrayList();

        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
		try {
			
//*			String stDfltTradeId="";
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_DEFAULT_BATCH_ID"));
 		    resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				 String stTempBatchId=resultSet.getString(2);
				 alDfltBatchId.add(stTempBatchId);
			   }
		    }
			catch (Exception e) {
                      e.printStackTrace();
             } 
		    finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
                   }
          return alDfltBatchId;
	  }
     public ArrayList getDefltTradeId() {
        
        ArrayList alDfltTradeId=new ArrayList();

        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
		try {
			
	//*		String stDfltTradeId="";
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_DEFAULT_TRADE_ID"));
 		    resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				 String stTempTradeId=resultSet.getString(1);
				 alDfltTradeId.add(stTempTradeId);
			   }
		    }
			catch (Exception e) {
                      e.printStackTrace();
             } 
		    finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
                   }
          return alDfltTradeId;
	  }
   

public ArrayList getRequestedBatches(String store_code,String request_no) throws Exception {

		ArrayList alParameters=new ArrayList();

		alParameters.add(request_no);
		alParameters.add(store_code);
		alParameters.add(getLanguageId());

				
		ArrayList alRequestlist = new ArrayList();

		try {

			String stSQL=getStRepositoryValue("SQL_ST_PROD_TFR_REQUEST_SEARCH_SELECT");
			alRequestlist = fetchRecords(stSQL.toString(),alParameters);
			
String mfg_delete_yn =		checkForNull((String)fetchRecord("select  prt_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{store_code,getLoginById()}).get("PRT_DELETE_YN"),"N");
	setMfg_delete_yn(mfg_delete_yn);

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 

       return alRequestlist ;

}
   

   public ArrayList getBatchDetails(String item_code, String store_code)throws Exception {
		ArrayList BatchDetails=new ArrayList();
		Connection connection = null;
//*		int isValidDocDate = -1;
		try {
			connection = getConnection();

			// To call the procedure st_stock_availability_status

			String[] strParameters = new String[7];

			strParameters[0] = item_code;
			strParameters[1] = store_code;
			strParameters[2] = "0";
			strParameters[3] = "N";
			strParameters[4] = "";//stHeaderBean.getSysDate();
			strParameters[5] = "N";
			strParameters[6] = "";

            HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(strParameters);


			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_available_yn"));
			BatchDetails.add((String)hmStockAvailabilityStatus.get("item_unit_cost"));
			BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("store_item_unit_cost")));
			BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("available_stock")));
			BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("expired_stock")));
			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_item_yn"));
			

			
		}
		catch(Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
		finally {
			closeConnection(connection);
		}
		return BatchDetails;
	}



public HashMap insert() {

	    

        boolean autoGenerateYN=false;
		String doc_no="";
		String nextDocSrlNo="";
		String repackgrp="";
        String request_no = "";

		
		HashMap hmSQLMap= new HashMap();
		HashMap hmTableData= new HashMap();
// *       HashMap hmScreenData= new HashMap();

		ArrayList alHdrListS=new ArrayList();

		ArrayList alDtlListFromAdd = new ArrayList();
        ArrayList alDtlListToAdd   = new ArrayList();
        ArrayList alRequestNo      = new ArrayList();
		

		
		ArrayList alCommonData=new ArrayList();
		
		ArrayList alautogen=new ArrayList();
		
		ArrayList albatch=new ArrayList();
		alCommonData.add(getLoginById() );
		alCommonData.add(getLoginAtWsNo() );
		alCommonData.add(getLoginFacilityId() );
		alCommonData.add(stHeaderBean.getDoc_type_code());
		try {

			autoGenerateYN=isDocNoAutoGenYN(stHeaderBean.getDoc_type_code());
			if(autoGenerateYN)
			  doc_no=fetchNextDocNo(stHeaderBean.getDoc_type_code());
			
			else
			  doc_no=stHeaderBean.getDoc_no();

			hmSQLMap.put("HdrInsertSQL", getStRepositoryValue("SQL_ST_PRODUCT_TRANSFER_HDR_INSERT"));
            hmSQLMap.put("DtlInsertSQL", getStRepositoryValue("SQL_ST_PRODUCT_TRANSFER_DTL_INSERT"));
            hmSQLMap.put("DtlExpInsertSQL", getStRepositoryValue("SQL_ST_PRODUCT_TRANSFER_DTL_EXP_INSERT"));
            hmSQLMap.put("TrnDtlInsertSQL", getStRepositoryValue("SQL_ST_PRODUCT_TRANSFER_ITEM_TRN_DTL_INSERT"));

			hmSQLMap.put("NextDocNoUpdateSQL", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));

            hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
			hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS")); 

			hmSQLMap.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
			hmSQLMap.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
			hmSQLMap.put("ItemCostValueSelectSQL", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT1"));
			hmSQLMap.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
             
            hmSQLMap.put("SQL_TRADE_ID_APPLICABLE_SELECT", getStRepositoryValue("SQL_TRADE_ID_APPLICABLE_SELECT"));
            hmSQLMap.put("SQL_DFLT_TRADE_ID_SELECT", getStRepositoryValue("SQL_DFLT_TRADE_ID_SELECT"));
			hmSQLMap.put("SQL_ITEM_TRADE_SELECT", getStRepositoryValue("SQL_ITEM_TRADE_SELECT"));
			hmSQLMap.put("SQL_ITEM_CODE_TRADE_ID_INSERT", getStRepositoryValue("SQL_ITEM_CODE_TRADE_ID_INSERT")); 

			hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
			hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
			hmSQLMap.put("ItemMovSumInsertSQL", getStRepositoryValue("SQL_PROD_TRANSFER_ST_ITEM_MOVE_SUMM_INSERT"));
			hmSQLMap.put("ItemMovSumFromUpdateSQL", getStRepositoryValue("SQL_ST_PROD_TRANSFER_FROM_ITEM_MOVE_SUMM_UPDATE"));
			hmSQLMap.put("ItemMovSumToUpdateSQL", getStRepositoryValue("SQL_ST_PROD_TRANSFER_TO_ITEM_MOVE_SUMM_UPDATE"));

			hmSQLMap.put("ItemNextBatchUpdateSQL", getStRepositoryValue("SQL_ST_REPACKGROUP_NEXT_BATCH_ID_UPDATE"));
			
			hmSQLMap.put("RequestStatusUpdateSQL", getStRepositoryValue("SQL_ST_PROD_REQUEST_HDR_REQUEST_STATUS_UPDATE"));

			
	
			repackgrp=CommonBean.checkForNull(getRepackGroup());
		

			if(!repackgrp.equals(""))
			{
				alautogen=getAutoGenYn(repackgrp);
				
				if(alautogen.size()>0)
				{
					albatch.add(alautogen.get(0));
				}
			}
			

            ArrayList alDtlList	    =	productTransferDetailBean.toArrayList();
			HashMap hmDtlList = (HashMap)alDtlList.get(0);


			System.out.println("hmDtlList=====645======>"+hmDtlList);

			request_no = (String)hmDtlList.get("request_no");
			if(!request_no.equals(""))
				alRequestNo.add(request_no);
			

			alHdrListS=new ArrayList();
			
			/* Setting values for hdr insertion */

            alHdrListS.add(getLoginFacilityId() );
			alHdrListS.add(stHeaderBean.getDoc_type_code());
			alHdrListS.add(doc_no);
			alHdrListS.add(stHeaderBean.getDoc_date());
			alHdrListS.add(stHeaderBean.getDoc_ref());
			alHdrListS.add(stHeaderBean.getStore_code());

            alHdrListS.add((String)hmDtlList.get("fm_item_code"));
			alHdrListS.add((String)hmDtlList.get("to_item_code"));
			alHdrListS.add((String)hmDtlList.get("fm_stk_uom_code"));
			alHdrListS.add((String)hmDtlList.get("to_stk_uom_code"));
			alHdrListS.add((String)hmDtlList.get("fm_stk_uom_conv_factor"));
			alHdrListS.add((String)hmDtlList.get("to_stk_uom_conv_factor"));
			alHdrListS.add(((String)hmDtlList.get("fm_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
			

			alHdrListS.add(((String)hmDtlList.get("to_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
			alHdrListS.add((String)hmDtlList.get("fm_expiry_date"));
			
			
			String to_expiry_date=DateUtils.convertDate((String)hmDtlList.get("to_expiry_date"),"DMY",locale,"en");

			alHdrListS.add(to_expiry_date);
			
			
          
            
			alHdrListS.add((String)hmDtlList.get("fm_item_qty"));
			alHdrListS.add((String)hmDtlList.get("to_item_qty"));  //actual_qty
			alHdrListS.add(getFinalized_yn());
			//	alHdrListS.add((String)hmDtlList.get("finalized_yn")); Modified by badma
			//alHdrListS.add((String)hmDtlList.get("gl_interfaced_yn"));
            //alHdrListS.add((String)hmDtlList.get("trn_type"));

			alHdrListS.add(getLoginById());//to_item_qty
			alHdrListS.add(getLoginAtWsNo());
			alHdrListS.add(getLoginFacilityId() );
			alHdrListS.add(getLoginById());
			alHdrListS.add(getLoginAtWsNo());
			alHdrListS.add(getLoginFacilityId() );

			alHdrListS.add(CommonBean.checkForNull((String)hmDtlList.get("actual_qty")));
			alHdrListS.add(CommonBean.checkForNull((String)hmDtlList.get("expect_bal_qty")));
			alHdrListS.add(CommonBean.checkForNull((String)hmDtlList.get("expect_act_qty")));
			alHdrListS.add((String)hmDtlList.get("time_taken"));
			alHdrListS.add((String)hmDtlList.get("p_packed_by"));
			alHdrListS.add((String)hmDtlList.get("counter_check"));
			alHdrListS.add((String)hmDtlList.get("p_auth_by"));
            alHdrListS.add((String)hmDtlList.get("remarks"));
			alHdrListS.add((String)hmDtlList.get("prepare_location"));
			alHdrListS.add(CommonBean.checkForNull((String)hmDtlList.get("no_of_labels")));
			alHdrListS.add(CommonBean.checkForNull((String)hmDtlList.get("request_no")));


            
			/* Setting values for FROM dtl insertion Begins here*/

			alDtlListFromAdd.add(getLoginFacilityId());
            alDtlListFromAdd.add(stHeaderBean.getDoc_type_code());
			alDtlListFromAdd.add(doc_no);
            alDtlListFromAdd.add((String)hmDtlList.get("doc_srl_no"));
            alDtlListFromAdd.add(stHeaderBean.getStore_code());
			alDtlListFromAdd.add((String)hmDtlList.get("fm_item_code"));
            alDtlListFromAdd.add("-"+(String)hmDtlList.get("fm_item_qty"));
            alDtlListFromAdd.add((String)hmDtlList.get("fm_item_unit_cost"));
            alDtlListFromAdd.add("-"+(String)hmDtlList.get("fm_item_cost_value"));
            alDtlListFromAdd.add("Y");

			alDtlListFromAdd.add(getLoginById());
			alDtlListFromAdd.add(getLoginAtWsNo());
			alDtlListFromAdd.add(getLoginFacilityId() );
			alDtlListFromAdd.add(getLoginById());
			alDtlListFromAdd.add(getLoginAtWsNo());
			alDtlListFromAdd.add(getLoginFacilityId() );

            /* Setting values for To dtl insertion ends here */

            /* Setting values for To dtl insertion Begins here*/

			alDtlListToAdd.add(getLoginFacilityId());
            alDtlListToAdd.add(stHeaderBean.getDoc_type_code());
			alDtlListToAdd.add(doc_no);
			nextDocSrlNo=String.valueOf(Integer.parseInt((String)hmDtlList.get("doc_srl_no"))+1);
            alDtlListToAdd.add(nextDocSrlNo);
            alDtlListToAdd.add(stHeaderBean.getStore_code());
			alDtlListToAdd.add((String)hmDtlList.get("to_item_code"));
            alDtlListToAdd.add((String)hmDtlList.get("to_item_qty"));
            alDtlListToAdd.add((String)hmDtlList.get("to_item_unit_cost"));
            alDtlListToAdd.add((String)hmDtlList.get("to_item_cost_value"));
            alDtlListToAdd.add("Y");

			alDtlListToAdd.add(getLoginById());
			alDtlListToAdd.add(getLoginAtWsNo());
			alDtlListToAdd.add(getLoginFacilityId() );
			alDtlListToAdd.add(getLoginById());
			alDtlListToAdd.add(getLoginAtWsNo());
			alDtlListToAdd.add(getLoginFacilityId() );
			
			 
			 System.out.println("alDtlListToAdd==754=>"   +alDtlListToAdd);

            /* Setting values for To dtl insertion Ends here*/


           /* Setting values for From in dtl_exp insertion Begins here*/

			ArrayList alDtlExpListFrom	    =	new ArrayList();
            
            //String fm_expiry_date=(String)hmDtlList.get("fm_expiry_date");
           
		    
          
			alDtlExpListFrom.add(getLoginFacilityId() );
            alDtlExpListFrom.add(stHeaderBean.getDoc_type_code());
			alDtlExpListFrom.add(doc_no);
			alDtlExpListFrom.add((String)hmDtlList.get("doc_srl_no"));
            alDtlExpListFrom.add(stHeaderBean.getStore_code());
			alDtlExpListFrom.add((String)hmDtlList.get("fm_item_code"));
            alDtlExpListFrom.add(((String)hmDtlList.get("fm_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
            alDtlExpListFrom.add((String)hmDtlList.get("fm_bin_location_code"));
			alDtlExpListFrom.add((String)hmDtlList.get("fm_expiry_date"));
			alDtlExpListFrom.add("-"+(String)hmDtlList.get("fm_item_qty"));

			alDtlExpListFrom.add(getLoginById());
			alDtlExpListFrom.add(getLoginAtWsNo());
			alDtlExpListFrom.add(getLoginFacilityId() );
			alDtlExpListFrom.add(getLoginById());
			alDtlExpListFrom.add(getLoginAtWsNo());
			alDtlExpListFrom.add(getLoginFacilityId() );

            alDtlExpListFrom.add((String)hmDtlList.get("fm_trade_id") );
			alDtlExpListFrom.add(CommonBean.checkForNull((String)hmDtlList.get("fm_barcode_id")) );  
			System.out.println("alDtlExpListFrom=210512====>" +alDtlExpListFrom);

            /* Setting values for From in dtl_exp insertion Ends here*/

            
            /* Setting values for To in dtl_exp insertion Begins here*/

			ArrayList alDtlExpListTo	    =	new ArrayList();

            alDtlExpListTo.add(getLoginFacilityId() );
            alDtlExpListTo.add(stHeaderBean.getDoc_type_code());
			alDtlExpListTo.add(doc_no);
            nextDocSrlNo=String.valueOf(Integer.parseInt((String)hmDtlList.get("doc_srl_no"))+1);
            alDtlExpListTo.add(nextDocSrlNo);
			alDtlExpListTo.add(stHeaderBean.getStore_code());
			alDtlExpListTo.add((String)hmDtlList.get("to_item_code"));
            alDtlExpListTo.add(((String)hmDtlList.get("to_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
            alDtlExpListTo.add((String)hmDtlList.get("to_bin_location_code"));
//String to_expiry_date=DateUtils.convertDate((String)hmDtlList.get("to_expiry_date"),"DMY",locale,"en");

			alDtlExpListTo.add(to_expiry_date);
			alDtlExpListTo.add((String)hmDtlList.get("to_item_qty"));

			alDtlExpListTo.add(getLoginById());
			alDtlExpListTo.add(getLoginAtWsNo());
			alDtlExpListTo.add(getLoginFacilityId() );
			alDtlExpListTo.add(getLoginById());
			alDtlExpListTo.add(getLoginAtWsNo());
			alDtlExpListTo.add(getLoginFacilityId() );

            alDtlExpListTo.add((String)hmDtlList.get("to_trade_id") );
			alDtlExpListTo.add(CommonBean.checkForNull((String)hmDtlList.get("to_barcode_id"))); 
            System.out.println("alDtlExpListTo===>" +alDtlExpListTo);			

            /* Setting values for From in dtl_exp insertion Ends here*/

           /* Setting values for decrementing form FROM item BEGINS here*/

            HashMap hmParametersFrom=new HashMap();

		    hmParametersFrom.put("item_code", (String)hmDtlList.get("fm_item_code"));
			hmParametersFrom.put("store_code", stHeaderBean.getStore_code() );
            hmParametersFrom.put("trn_type", "PRT");

			hmParametersFrom.put("batch_id", ((String)hmDtlList.get("fm_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
			hmParametersFrom.put("expiry_date_or_receipt_date",(String)hmDtlList.get("fm_expiry_date"));
			hmParametersFrom.put("trade_id", (String)hmDtlList.get("fm_trade_id"));

			
            hmParametersFrom.put("from_bin_location_code", (String)hmDtlList.get("fm_bin_location_code")); //old bin loc 
            hmParametersFrom.put("release_batch_yn", "N");
  		    hmParametersFrom.put("suspended_batch_allowed_yn", "Y");

			hmParametersFrom.put("login_by_id", getLoginById());
			hmParametersFrom.put("login_at_ws_no", getLoginAtWsNo());
			hmParametersFrom.put("login_facility_id", getLoginFacilityId());

			String qty_to_reduce="-"+(String)hmDtlList.get("fm_item_qty");

			//added for ML-MMOH-SCF-1065 START
			//double qtyToReduce = Double.parseDouble(qty_to_reduce) * (getConvFactTemp((String)hmDtlList.get("fm_item_code"), stHeaderBean.getStore_code()));//COMMENTED FOR IN:070603
			//qty_to_reduce = String.valueOf(qtyToReduce);//COMMENTED FOR IN:070603
			//added for ML-MMOH-SCF-1065 END 
			
			hmParametersFrom.put("trn_qty",qty_to_reduce);
			hmParametersFrom.put("barcode_id", CommonBean.checkForNull((String)hmDtlList.get("fm_barcode_id")));  
			System.out.println("hmParametersFrom===>" +hmParametersFrom);

			ArrayList alHmParameterFrom=new ArrayList();
            alHmParameterFrom.add(hmParametersFrom);

      
           /* Setting values for decrementing form FROM item ENDS here*/
          /* Setting values for incrementing to TO item BEGINS here*/

            HashMap hmParametersTo=new HashMap();

		    hmParametersTo.put("item_code", (String)hmDtlList.get("to_item_code"));
			hmParametersTo.put("store_code", stHeaderBean.getStore_code() );
            hmParametersTo.put("trn_type", "PRT");

			hmParametersTo.put("batch_id", ((String)hmDtlList.get("to_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
			
//String to_expiry_date=DateUtils.convertDate((String)hmDtlList.get("to_expiry_date"),"DMY",locale,"en");

			hmParametersTo.put("expiry_date_or_receipt_date",to_expiry_date);



			hmParametersTo.put("trade_id", (String)hmDtlList.get("to_trade_id"));
			
            hmParametersTo.put("from_bin_location_code", (String)hmDtlList.get("to_bin_location_code")); //old bin loc 
            //hmParametersFrom.put("release_batch_yn", "N");
			hmParametersTo.put("release_batch_yn", "N");

  		    hmParametersTo.put("suspended_batch_allowed_yn", "Y");

			hmParametersTo.put("login_by_id", getLoginById());
			hmParametersTo.put("login_at_ws_no", getLoginAtWsNo());
			hmParametersTo.put("login_facility_id", getLoginFacilityId());

			String qty_to_increase=(String)hmDtlList.get("to_item_qty");
			
			//added for ML-MMOH-SCF-1065 START
			//double qtyToIncrease = Double.parseDouble(qty_to_increase) * (getConvFactTemp((String)hmDtlList.get("to_item_code"), stHeaderBean.getStore_code()));//COMMENTED FOR IN:070603
			//qty_to_increase = String.valueOf(qtyToIncrease);//COMMENTED FOR IN:070603
			//added for ML-MMOH-SCF-1065 END
			
			hmParametersTo.put("trn_qty",qty_to_increase);

			hmParametersTo.put("sale_price",(String)hmDtlList.get("to_item_unit_price")); // added by ganga 
			hmParametersTo.put("sale_price_appl_yn",(String)hmDtlList.get("sale_price_appl_yn")); // added by ganga
            hmParametersTo.put("barcode_id",CommonBean.checkForNull((String)hmDtlList.get("to_barcode_id")));  
						
			
			ArrayList alHmParameterTo=new ArrayList();
            alHmParameterTo.add(hmParametersTo);
			System.out.println("alHmParameterTo===893===>"+alHmParameterTo);
//
           /* Setting values for increminting to TO item ENDS here*/



          /* Decrementing the values for(item_qty and item_value) in st_item_store for FROM item BEGINS here*/

            HashMap hmParametersItemStoreFrom=new HashMap();

		    hmParametersItemStoreFrom.put("item_code", (String)hmDtlList.get("fm_item_code"));
			hmParametersItemStoreFrom.put("store_code", stHeaderBean.getStore_code() );
            hmParametersItemStoreFrom.put("trn_type", "PRT");

			hmParametersItemStoreFrom.put("to_bin_location_code", (String)hmDtlList.get("fm_bin_location_code")); 

			hmParametersItemStoreFrom.put("login_by_id", getLoginById());
			hmParametersItemStoreFrom.put("login_at_ws_no", getLoginAtWsNo());
			hmParametersItemStoreFrom.put("login_facility_id", getLoginFacilityId());

            hmParametersItemStoreFrom.put("from_stk_item_yn", "Y");
            hmParametersItemStoreFrom.put("to_stk_item_yn", "Y");

			////ADDED FOR IN:070603 START
            qty_to_reduce="-"+(String)hmDtlList.get("fm_item_qty");
            double qtyToReduce = Double.parseDouble(qty_to_reduce) / (getConvFactTemp((String)hmDtlList.get("fm_item_code"), stHeaderBean.getStore_code()));
			qty_to_reduce = String.valueOf(qtyToReduce);
			////ADDED FOR IN:070603 END 
			
			hmParametersItemStoreFrom.put("trn_qty",qty_to_reduce);

			

			String value_to_reduce="-"+(String)hmDtlList.get("fm_item_cost_value");
			hmParametersItemStoreFrom.put("trn_value", value_to_reduce );
            hmParametersItemStoreFrom.put("trn_unit_cost", (String)hmDtlList.get("fm_item_unit_cost"));
	
			ArrayList alHmParameterItemStoreFrom=new ArrayList();
            alHmParameterItemStoreFrom.add(hmParametersItemStoreFrom);
      
           /* Decrementing the values for(item_qty and item_value) in st_item_store for FROM item ENDS here*/


         /* Setting values for updation in st_item_store for TO item BEGINS here*/

            HashMap hmParametersItemStoreTo=new HashMap();

		    hmParametersItemStoreTo.put("item_code", (String)hmDtlList.get("to_item_code"));
			hmParametersItemStoreTo.put("store_code", stHeaderBean.getStore_code() );
            hmParametersItemStoreTo.put("trn_type", "PRT");

			hmParametersItemStoreTo.put("to_bin_location_code", (String)hmDtlList.get("to_bin_location_code")); 

			hmParametersItemStoreTo.put("login_by_id", getLoginById());
			hmParametersItemStoreTo.put("login_at_ws_no", getLoginAtWsNo());
			hmParametersItemStoreTo.put("login_facility_id", getLoginFacilityId());

			hmParametersItemStoreTo.put("from_stk_item_yn", "Y");
            hmParametersItemStoreTo.put("to_stk_item_yn", "Y");

             qty_to_increase=(String)hmDtlList.get("to_item_qty");
			
			//ADDED FOR IN:070603 START
            double qtyToIncrease = Double.parseDouble(qty_to_increase) / (getConvFactTemp((String)hmDtlList.get("to_item_code"), stHeaderBean.getStore_code()));
			qty_to_increase = String.valueOf(qtyToIncrease);
			//ADDED FOR IN:070603 END
			
			hmParametersItemStoreTo.put("trn_qty",qty_to_increase);
			String value_to_increase=(String)hmDtlList.get("to_item_cost_value");
			hmParametersItemStoreTo.put("trn_value", value_to_increase );
			hmParametersItemStoreTo.put("trn_unit_cost", (String)hmDtlList.get("to_item_unit_cost"));
			

			ArrayList alHmParameterItemStoreTo=new ArrayList();
            alHmParameterItemStoreTo.add(hmParametersItemStoreTo);
      
          /* Setting values for updation in st_item_store for TO item ENDS here*/

			 /* Setting values for updation in st_repacking_group for TO item BEGINS here*/
			
				
				HashMap hmParametersItemBatchTo=new HashMap();
				String repackgroup=getRepackGroup();
				hmParametersItemBatchTo.put("repacking_group_code",repackgroup );
				hmParametersItemBatchTo.put("login_by_id", getLoginById());
				hmParametersItemBatchTo.put("login_at_ws_no", getLoginAtWsNo());
				hmParametersItemBatchTo.put("login_facility_id", getLoginFacilityId());
				ArrayList alHmParameterItemBatchTo=new ArrayList();
				alHmParameterItemBatchTo.add(hmParametersItemBatchTo);

			
				
			
			 
			 /* Setting values for updation in st_repacking_group for TO item ends here*/

		  /* Setting values for insertion record in st_item_trn_dtl for FROM item BEGINS here*/


				ArrayList alFromDtlTrn=new ArrayList();
				
				alFromDtlTrn.add(getLoginFacilityId() );
				alFromDtlTrn.add(stHeaderBean.getStore_code());
				alFromDtlTrn.add((String)hmDtlList.get("fm_item_code"));
				alFromDtlTrn.add(""+1);
				alFromDtlTrn.add("PRT");
				alFromDtlTrn.add(stHeaderBean.getDoc_type_code());
				alFromDtlTrn.add(doc_no);
				alFromDtlTrn.add((String)hmDtlList.get("doc_srl_no"));
				alFromDtlTrn.add(stHeaderBean.getDoc_date());
				alFromDtlTrn.add(stHeaderBean.getDoc_ref());
				alFromDtlTrn.add(((String)hmDtlList.get("fm_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
				alFromDtlTrn.add((String)hmDtlList.get("fm_expiry_date"));
				String temp_fm_item_qty="-"+(String)hmDtlList.get("fm_item_qty");
				alFromDtlTrn.add(temp_fm_item_qty);
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add((String)hmDtlList.get("fm_item_unit_cost"));
				//alFromDtlTrn.add("");
				alFromDtlTrn.add((String)hmDtlList.get("fm_item_unit_price"));//added for item_mrp_price
				alFromDtlTrn.add((String)hmDtlList.get("fm_stk_uom_code"));
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("Y");
				alFromDtlTrn.add("");
				alFromDtlTrn.add("");
				alFromDtlTrn.add(getLoginById());
				alFromDtlTrn.add(getLoginAtWsNo() );
				alFromDtlTrn.add(getLoginFacilityId() );
				alFromDtlTrn.add(getLoginById());
				alFromDtlTrn.add(getLoginAtWsNo() );
				alFromDtlTrn.add(getLoginFacilityId() );
				alFromDtlTrn.add("");
				alFromDtlTrn.add((String)hmDtlList.get("fm_bin_location_code"));
				alFromDtlTrn.add((String)hmDtlList.get("fm_trade_id") );

          /* Setting values for insertion record in st_item_trn_dtl for FROM item BEGINS here*/

				System.out.println("alFromDtlTrn@1004" +alFromDtlTrn);

		  /* Setting values for insertion record in st_item_trn_dtl for TO item BEGINS here*/


  			    ArrayList alToDtlTrn=new ArrayList();
				
				alToDtlTrn.add(getLoginFacilityId() );
				alToDtlTrn.add(stHeaderBean.getStore_code());
				alToDtlTrn.add((String)hmDtlList.get("to_item_code"));
				alToDtlTrn.add(""+1);
				alToDtlTrn.add("PRT");
				alToDtlTrn.add(stHeaderBean.getDoc_type_code());
				alToDtlTrn.add(doc_no);
				alToDtlTrn.add(nextDocSrlNo);
				alToDtlTrn.add(stHeaderBean.getDoc_date());
				alToDtlTrn.add(stHeaderBean.getDoc_ref());
				alToDtlTrn.add(((String)hmDtlList.get("to_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
				
				
				//String to_expiry_date=DateUtils.convertDate((String)hmDtlList.get("to_expiry_date"),"DMY",locale,"en");

			     
				alToDtlTrn.add(to_expiry_date);
				alToDtlTrn.add((String)hmDtlList.get("to_item_qty"));
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add((String)hmDtlList.get("to_item_unit_cost"));
				//alToDtlTrn.add("");
				alToDtlTrn.add((String)hmDtlList.get("to_item_unit_price"));//added for item_mrp_price
				alToDtlTrn.add((String)hmDtlList.get("to_stk_uom_code"));
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add("Y");
				alToDtlTrn.add("");
				alToDtlTrn.add("");
				alToDtlTrn.add(getLoginById());
				alToDtlTrn.add(getLoginAtWsNo() );
				alToDtlTrn.add(getLoginFacilityId() );
				alToDtlTrn.add(getLoginById());
				alToDtlTrn.add(getLoginAtWsNo() );
				alToDtlTrn.add(getLoginFacilityId() );
				alToDtlTrn.add("");
				alToDtlTrn.add((String)hmDtlList.get("to_bin_location_code"));
				alToDtlTrn.add((String)hmDtlList.get("to_trade_id") );

				System.out.println("alToDtlTrn@1055" +alToDtlTrn);

          /* Setting values for insertion record in st_item_trn_dtl for TO item BEGINS here*/



			hmTableData.put("properties",	 getProperties());
			hmTableData.put("RequestNo", alRequestNo);
			hmTableData.put("HdrInsertData", alHdrListS);
			hmTableData.put("DtlInsertDataFrom", alDtlListFromAdd);
            hmTableData.put("DtlInsertDataTo", alDtlListToAdd);
            hmTableData.put("DtlExpInsertDataFrom", alDtlExpListFrom);
            hmTableData.put("DtlExpInsertDataTo", alDtlExpListTo);
            hmTableData.put("ItemQtyUpdateDataFrom", alHmParameterFrom);
            hmTableData.put("ItemQtyUpdateDataTo", alHmParameterTo);
            hmTableData.put("ItemStoreQtyUpdateDataFrom", alHmParameterItemStoreFrom);
			hmTableData.put("ItemStoreQtyUpdateDataTo", alHmParameterItemStoreTo);
            hmTableData.put("ItemTrnDtlDataFrom", alFromDtlTrn);
            hmTableData.put("ItemTrnDtlDataTo", alToDtlTrn);
			hmTableData.put("ItemBatchTo", albatch);
			
			
			if(alautogen.size()>0)
			{
			if(alautogen.get(0).equals("Y"))
			//hmTableData.put("ItemBatchTo", albatch);
			hmTableData.put("ItemBatchIdDataTo", alHmParameterItemBatchTo);
			}
			
			

			hmTableData.put("CommonData",	 alCommonData);
            //hmTableData.put("TrnDtlData",	 alTrnDtlToAdd);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(autoGenerateYN));

  		 }
		 catch(Exception e) {
			e.printStackTrace();
		}  

      
	    HashMap		hmResult	=	new HashMap()	;
      try{
        
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

        
		/** For ejb deployment BEGINS here */

   	   // eST.ProductTransfer.ProductTransferRemote producttransferremote = null;

		/*InitialContext initialcontext = new InitialContext();
		Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_ST_PRODUCT_TRANSFER"));
		eST.ProductTransfer.ProductTransferHome producttransferhome = (eST.ProductTransfer.ProductTransferHome)PortableRemoteObject.narrow(obj1, eST.ProductTransfer.ProductTransferHome.class);
		producttransferremote = producttransferhome.create();
		hmResult = producttransferremote.insert(hmTableData, hmSQLMap);*/


		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_PRODUCT_TRANSFER"),eST.ProductTransfer.ProductTransferHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); ;
		paramArray[1] = hmSQLMap.getClass();
		
		 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		if(autoGenerateYN)
		  {

				String s = getSTMessage(getLanguageId(), "DOC_NO", "ST") ;
				String s1=s+":  "+doc_no;
   		      hmResult.put("flag",s1) ;
		  }
 
   		/** For ejb deployment ENDS here */

		//hmResult = new eST.ProductTransfer12.ProductTransferManager().insert( hmTableData, hmSQLMap ) ;
 
         MessageManager mm=new MessageManager();

		if( ((Boolean) hmResult.get("result")).booleanValue() )	{
	
		// hmResult.put("message", getSTMessage(getLanguageId(),(String) hmResult.get("msgid" ),"ST") ) ;
		     final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "ST") ;
		    hmResult.put("message",(String) mesg.get("message")) ;

			if(autoGenerateYN)
			{
			String s1=getSTMessage(getLanguageId(), "DOC_NO", "ST")+" :"+doc_no;
   		      hmResult.put("flag", s1) ;
			}
		}
		else if( hmResult.get("msgid")!=null  ) {
			hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;

		}
		else {
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		}
/* SEND TO PRINT ONLINE REPORT STARTS*/
			
			//doc_no	=	(String)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);

			PgetDoc_type_code =stHeaderBean.getDoc_type_code();
			PgetStore_codest  =stHeaderBean.getStore_code();
           // PgetTrnType  = getTrn_type() ; 
			//PgetSeqNo = getSeq_no() ;


			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));

       
			

		//  if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
		  if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			{

				if (isInternalRequest("ST","STBPTFDC") && isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{
						if(alertRqdYN.equals("Y")){	
							hmResult.put("flag",hmResult.get("flag") + "~PY");
						}
						else{
							//doOnlineReportPrinting(doc_no);
							//doOnlineReportPrintingOfLabel(doc_no);
							hmResult.put("flag",hmResult.get("flag") + "~PN");
						}
				}

				//doOnlineReportPrintingOfLabel(doc_no);
			}

       }catch(Exception e){
		   e.printStackTrace();
		}
              
		return hmResult;    

	}  
 /*SEND TO PRINT ONLINE REPORT ENDS*/	

public boolean DocTypePrintAllowed (String PgetDoc_type_code){
		if (isDocTypePrintAllowed(PgetDoc_type_code)) 
			return true;
		else
			return false;
	}


	/*public void doOnlineReportPrinting(String doc_num) {
		//javax.servlet.http.HttpSession ses;
		try{
			String reportid = "STBPTFDC";

			if (!isInternalRequest("ST",reportid)) return;

			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_doc_no",doc_num);
			//hmReportParameter.put("p_seq_no",PgetSeqNo);


			//javax.servlet.http.HttpSession session = request.getSession(false);


			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codest);


			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();

		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/

	public void doOnlineReportPrinting(String doc_num,Object request,Object response) {
		try{
	
			String reportid = "STBPTFDC";
			//String copies = getNoOfCopies(reportid);
		
			if (!isInternalRequest("ST",reportid)) return;
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid) ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid, "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("p_doc_no",doc_num);
				//report2.addParameter("copies",checkForNull(copies,"1"));
				onlineReports.add( report2) ;

				
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}



/*public void doOnlineReportPrintingOfLabel(String docno) {
		try{
			//String reportid = "STBREPLB";
//			if (!isInternalRequest("ST",reportid)) return;
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			//hmReportParameter.put("p_report_id",reportid); //07/06/12
			hmReportParameter.put("p_report_id",getReport_id());
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",docno);
			hmReportParameter.put("p_language_id",getLanguageId());
			// javax.servlet.http.HttpSession session = request.getSession(false);
			
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codest);
			

			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/

public void doOnlineReportPrintingOfLabel(String docno,Object request,Object response) {
		try{
	
				ecis.utils.OnlineReports onlineReports 	= null;
				ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", getReport_id()) ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", getReport_id(), "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", getReport_id()) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("p_doc_no",docno);
				onlineReports.add( report2) ;

				
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}
	public int getEntityparam_EWDay(String ACC_ENTITY_ID) throws Exception{
		
		int IEWDays = 0;
		try {
				IEWDays = getEntityparam_EWDays(ACC_ENTITY_ID);
			}
            
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		
		return IEWDays;
	}
	public ArrayList getItemSearchDetails(String item_code,String store_code) throws Exception {
	
		ArrayList alParameters=new ArrayList();
		
		/*added for ML-MMOH-SCF-1065 START*/
		alParameters.add(getLanguageId());
		alParameters.add(item_code);
		alParameters.add(store_code);
		/*added for ML-MMOH-SCF-1065 END*/ 
		
		alParameters.add(item_code);
		alParameters.add("" );
		alParameters.add("");
		alParameters.add("");
		alParameters.add("");
		alParameters.add("");
		alParameters.add("");          
		alParameters.add("");
		alParameters.add("");
		alParameters.add("A" );
		alParameters.add("A");
		alParameters.add("A");
		alParameters.add("A");
		alParameters.add("A");
		alParameters.add("A");
		alParameters.add("");
		alParameters.add("");
		alParameters.add("A" );
		alParameters.add("A");
		alParameters.add("");
		alParameters.add("");
		alParameters.add("");
		alParameters.add("");
		alParameters.add("");
		alParameters.add("");
		alParameters.add("");
		alParameters.add("");
		alParameters.add("A" );
		alParameters.add("A");
		alParameters.add(store_code);
		alParameters.add("A");
		alParameters.add("A");
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		
		
		
		ArrayList listRecord =new ArrayList();
		try {
				String stSQL = "";
			//if(ItemSearchBean.isSSIVModuleInstalled()){
				//alParameters.add(login_by_id);
				// stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY_C_INV");
			//}else{
				 stSQL=getStRepositoryValue("SQL_ITEM_SEARCH_QUERY");
			//}
			
			listRecord = fetchRecords(stSQL.toString(),alParameters);
			//DataList=listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
		return listRecord;
	}
	public String getPRTItemClassBased(String trntype)
	{
		String chkdefaultParameters[] = {trntype,getLanguageId()};
			HashMap records			  = new HashMap();
			String result				="";
		try{
			
				//records = fetchRecord("SELECT     ITEM_CLASS_BASED_YN   FROM     st_trn_type_lang_vw   WHERE   TRN_TYPE= ? AND LANGUAGE_ID=?",chkdefaultParameters);
				records = fetchRecord(getStRepositoryValue("SQL_ST_GRN_ITEM_CLASS_BASED_YN"),chkdefaultParameters);
				result=(String)records.get("ITEM_CLASS_BASED_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

//Added for ML-MMOH-SCF-1861
	public HashMap delete(){
		HashMap map								=		new HashMap()	;
		map.put(RESULT, FALSE ) ;
		map.put(MESSAGE, "" ) ;
		String request_no="";
		String prod_transfer_mode = ""; //ML-MMOH-SCF-1861 
		String doc_no = "";
		String doc_type_code = ""; 
		/*boolean ExpDeleteSuccessful = false; 
		boolean HdrDeleteSuccessful = false; 
		boolean DtldeleteSuccessful = false; //end */ //Commented for common-icn-0060 
		HashMap hmTableData= new HashMap();//ML-MMOH-SCF-1861 
		HashMap hmSQLMap= new HashMap();
		ArrayList alHdrData		=	new ArrayList();//END
		Connection				 connection		=		null;
		PreparedStatement		 pstmt			=		null;
		PreparedStatement		 pstmt1			=		null;//ML-MMOH-SCF-1861 START
		PreparedStatement		 pstmt2			=		null;
		PreparedStatement		 pstmt3			=		null;
		HashMap hmCommonData	=	new HashMap();//ML-MMOH-SCF-1861 START
		 HashMap		hmResult	=	new HashMap()	;

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);//ML-MMOH-SCF-1861 END
		
		try {
			connection = getConnection();
			ArrayList alDtlList	    =	productTransferDetailBean.toArrayList();
			HashMap hmDtlList = (HashMap)alDtlList.get(0);
			request_no = (String)hmDtlList.get("request_no");
			prod_transfer_mode = (String)hmDtlList.get("prod_transfer_mode");   //ML-MMOH-SCF-1861 START 
			doc_no = (String)hmDtlList.get("doc_no");    
			doc_type_code = (String)hmDtlList.get("doc_type_code");   
			
			if(prod_transfer_mode.equals("1")){//ML-MMOH-SCF-1861
				pstmt=connection.prepareStatement(getStRepositoryValue("SQL_ST_PROD_REQUEST_HDR_REQUEST_STATUS_UPDATE1"));
				pstmt.setString(1,getLoginById().trim());
				pstmt.setString(2,getLoginAtWsNo().trim());
				pstmt.setString(3,getLoginFacilityId().trim());
				pstmt.setString(4,request_no.trim());
				int count=	pstmt.executeUpdate();
				if(count!=0){
					connection.commit();
					hmResult.put( "result", new Boolean( true ) ) ;//ML-MMOH-SCF-1861 START
					hmResult.put( "message", getSTMessage(getLanguageId(), "RECORD_DELETED" ,"ST") ) ;//END

				}
			}
			else if (prod_transfer_mode.equals("2")){
				
				//ML-MMOH-SCF-1861 START
				 	alHdrData.add(getLoginFacilityId().trim());
					alHdrData.add(doc_type_code);
					alHdrData.add(doc_no);
					
				 
				 hmTableData.put("properties",	 getProperties());
				 hmTableData.put("DATA",			alHdrData);
				 hmTableData.put("COMMON_DATA",	hmCommonData);
				 
				 hmSQLMap.put("expForDelSQL", getStRepositoryValue("SQL_ST_PROD_EXP_SELECT_FOR_DEL")); 
				 hmSQLMap.put("expForBlockRel", getStRepositoryValue("SQL_ST_PROD_DTL_EXP_SELECT_FOR_BLOCK_REL"));
				 hmSQLMap.put("stSQLHdrDelete", getStRepositoryValue("SQL_ST_ST_PROD_TRANSFER_HDR_DELETE"));
				 hmSQLMap.put("stSQLDtlDeleteAll", getStRepositoryValue("SQL_ST_ST_PROD_TRANSFER_DTL_DELETE"));
				 hmSQLMap.put("stSQLExpDeleteAll", getStRepositoryValue("SQL_ST_ST_PROD_TRANSFER_DTL_EXP_DELETE"));
				 
				 try{

						hmResult.put(RESULT, FALSE ) ;
						hmResult.put(MESSAGE, "Initial Message" ) ;

					    
						/** For ejb deployment BEGINS here */

						   // eST.ProductTransfer.ProductTransferRemote producttransferremote = null;

						/*InitialContext initialcontext = new InitialContext();
						Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_ST_PRODUCT_TRANSFER"));
						eST.ProductTransfer.ProductTransferHome producttransferhome = (eST.ProductTransfer.ProductTransferHome)PortableRemoteObject.narrow(obj1, eST.ProductTransfer.ProductTransferHome.class);
						producttransferremote = producttransferhome.create();
						hmResult = producttransferremote.insert(hmTableData, hmSQLMap);*/


						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_PRODUCT_TRANSFER"),eST.ProductTransfer.ProductTransferHome.class,getLocalEJB());
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

						Object argArray[] = new Object[2];
						argArray[0] = hmTableData;  
						argArray[1] = hmSQLMap;

						Class [] paramArray = new Class[2];
						paramArray[0] = hmTableData.getClass(); ;
						paramArray[1] = hmSQLMap.getClass();
						
						 hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
						
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

						
							/** For ejb deployment ENDS here */

						
					     MessageManager mm=new MessageManager();

						if( ((Boolean) hmResult.get("result")).booleanValue() )	{

						// hmResult.put("message", getSTMessage(getLanguageId(),(String) hmResult.get("msgid" ),"ST") ) ;
						     final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "ST") ;
						    hmResult.put("message",(String) mesg.get("message")) ;

						}
						else if( hmResult.get("msgid")!=null  ) {
							hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;

						}
						else {
							hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
						}
					   
				 }
				 catch(Exception exception){
					 exception.printStackTrace();
				 }//ML-MMOH-SCF-1861 END
				 //commented for ML-MMOH-SCF-1861
				/*pstmt1=connection.prepareStatement(getStRepositoryValue("SQL_ST_ST_PROD_TRANSFER_DTL_EXP_DELETE")); 
				pstmt1.setString(1,getLoginFacilityId().trim());
				pstmt1.setString(2,doc_type_code);
				pstmt1.setString(3,doc_no); 
				int count=	pstmt1.executeUpdate();
				if(count!=0){
					ExpDeleteSuccessful = true; 
				}
				if(ExpDeleteSuccessful){
					pstmt2=connection.prepareStatement(getStRepositoryValue("SQL_ST_ST_PROD_TRANSFER_DTL_DELETE")); 
					pstmt2.setString(1,getLoginFacilityId().trim());
					pstmt2.setString(2,doc_type_code);
					pstmt2.setString(3,doc_no); 
					int count1=	pstmt2.executeUpdate();
					if(count1!=0){
						DtldeleteSuccessful = true; 
					}
				} 
				if(DtldeleteSuccessful){
					pstmt3=connection.prepareStatement(getStRepositoryValue("SQL_ST_ST_PROD_TRANSFER_HDR_DELETE")); 
					pstmt3.setString(1,getLoginFacilityId().trim());
					pstmt3.setString(2,doc_type_code);
					pstmt3.setString(3,doc_no); 
					int count3=	pstmt3.executeUpdate();
					if(count3!=0){
						HdrDeleteSuccessful = true; 
					}
				}
				if(HdrDeleteSuccessful){
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", getSTMessage(getLanguageId(), "RECORD_DELETED" ,"ST") ) ;
				} */
				
			}//end 
		
		}catch(Exception exception){
			try{
		connection.rollback();
			}catch(Exception e){
			e.printStackTrace();  
			}
			hmResult.put(RESULT, FALSE ) ;
			hmResult.put(MESSAGE, exception.toString() ) ;
		return hmResult;
		}finally{
			try{
			closeStatement(pstmt);
			closeStatement(pstmt1);//ML-MMOH-SCF-1861
			closeStatement(pstmt2);
			closeStatement(pstmt3);//END
			closeConnection(connection);
			}catch(Exception e){
				e.printStackTrace();//ML-MMOH-SCF-1861
			}
		}

return hmResult;//ML-MMOH-SCF-1861 END

}
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi on 04/02/2016
	public String getQRYStore_code_List(String store_code) {
		ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
        arraylist.add(getLoginById());
        arraylist.add(getLanguageId());
        return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_QRY_ST_PRT_STORE_SELECT"), arraylist), checkForNull(stHeaderBean.getStore_code(),store_code));
}
/* moved to StTransaction.java
public String getSalePrice(String login_facility_id,String episode_type,String item_code,String trade_id,String batch_id) throws Exception{
	Connection connection = null;
    PreparedStatement preparedstatement = null;
	ResultSet resultset = null;
	String  sale_price = null; 
	String  sale_price1 = null;
	
	 	
	try
        {
		  String sql= "SELECT  ST_ITEM_CHARGE_MRP_PRICE('"+login_facility_id+"','I','"+item_code+"','"+trade_id+"','"+batch_id+"') ST_ITEM_CHARGE_MRP_PRICE FROM DUAL";
		  connection = getConnection();
             preparedstatement = connection.prepareStatement(sql);
             resultset=  preparedstatement.executeQuery(); 
                 if (resultset != null && resultset.next()) {
				sale_price1	 =  (String)resultset.getString("ST_ITEM_CHARGE_MRP_PRICE");
				if(sale_price1 != null && !sale_price1.equals("Error No-->BL9647")){
				  sale_price = sale_price1; 
				  }else
				  {
				  sale_price = "0.00";
				  }
				   }
		}
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
			    closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return sale_price;
    }*/
//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
	public void getSiteSpec() throws Exception{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
		ResultSet  resultSet = null;
		int count = 0;
        try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_SITE_SPEC_PROD_TRANSFER"));
          /*  int count =pstmt.executeUpdate();			
			if(count!=0){
					setSite_spec_yn(true);
			}
			*/
			resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			if(count!=0){
					setSite_spec_yn(true);
			}else{
				setSite_spec_yn(false);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch ( Exception es ) {
				es.printStackTrace() ;
			}
		}
	}
	public String getPrepLoc1(String prep_locn){
		ArrayList arr_language=new ArrayList();
		arr_language.add(getLoginFacilityId());
		arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_MAN_REQ_PRELOC_SELECT"),arr_language),prep_locn);
}

	public String getBinlocationCodeList1(String prep_locn,String item_code){
		ArrayList arr_language=new ArrayList();
		arr_language.add(stHeaderBean.getStore_code());
		arr_language.add(item_code);
		arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_STORE_BIN_LOCN_SELECT_LIST"),arr_language),prep_locn);
	} 
	//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
	public String getFinalize_allowed_yn(String stStore_code) throws Exception{
		String stParameters[]	=	{getLoginById(), stStore_code};
		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		return hmRecord.get("PRT_FINALIZE_ALLOWED_YN").toString();
	}
	

	public HashMap modify(){
   		HashMap hmResult1=new HashMap();
		ArrayList<String> alParam = new ArrayList<String>();
		int doc_count = 0;
		try{
			alParam.add(getLoginFacilityId());
			alParam.add(stHeaderBean.getDoc_type_code());
			alParam.add(stHeaderBean.getDoc_no());
			doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_PROD_TRANSFER_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND FINALIZED_YN='Y' ",alParam)).get("COUNT"));
		}catch(Exception e){
			hmResult1.put("result",false);
			hmResult1.put("msgid","OPER_CANCELLED");
			hmResult1.put("message",getSTMessage(getLanguageId(),"OPER_CANCELLED","ST"));
			e.printStackTrace();
			return hmResult1;
		}
		if(doc_count>0){
			hmResult1.put("result",false);
			hmResult1.put("msgid","ST_DOC_NO_FINALIZED_USER");
			hmResult1.put("message",getSTMessage(getLanguageId(),"ST_DOC_NO_FINALIZED_USER","ST"));
			return hmResult1;
		}
   // boolean autoGenerateYN=false; Commented for unused variables IN063878
	String nextDocSrlNo="";
	String repackgrp="";
    String request_no = "";

	
	HashMap hmSQLMap= new HashMap();
	HashMap hmTableData= new HashMap();
	ArrayList alHdrListS=new ArrayList();

	ArrayList alDtlListFromAdd = new ArrayList();
    ArrayList alDtlListToAdd   = new ArrayList();
    ArrayList alRequestNo      = new ArrayList();
	

	
	ArrayList alCommonData=new ArrayList();
	
	//ArrayList alautogen=new ArrayList(); Commented for unused variables IN063878
	
	//ArrayList albatch=new ArrayList(); Commented for unused variables IN063878
	alCommonData.add(getLoginById() );
	alCommonData.add(getLoginAtWsNo() );
	alCommonData.add(getLoginFacilityId() );
	alCommonData.add(stHeaderBean.getDoc_type_code());
	try {
		hmSQLMap.put("TrnDtlInsertSQL", getStRepositoryValue("SQL_ST_PRODUCT_TRANSFER_ITEM_TRN_DTL_INSERT"));
		hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
		hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
		hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
		hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
		hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
		hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
		hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS")); 

		hmSQLMap.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
		hmSQLMap.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
		hmSQLMap.put("ItemCostValueSelectSQL", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT1"));
		hmSQLMap.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
         
        hmSQLMap.put("SQL_TRADE_ID_APPLICABLE_SELECT", getStRepositoryValue("SQL_TRADE_ID_APPLICABLE_SELECT"));
        hmSQLMap.put("SQL_DFLT_TRADE_ID_SELECT", getStRepositoryValue("SQL_DFLT_TRADE_ID_SELECT"));
		hmSQLMap.put("SQL_ITEM_TRADE_SELECT", getStRepositoryValue("SQL_ITEM_TRADE_SELECT"));
		hmSQLMap.put("SQL_ITEM_CODE_TRADE_ID_INSERT", getStRepositoryValue("SQL_ITEM_CODE_TRADE_ID_INSERT")); 

		hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
		hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
		hmSQLMap.put("ItemMovSumInsertSQL", getStRepositoryValue("SQL_PROD_TRANSFER_ST_ITEM_MOVE_SUMM_INSERT"));
		hmSQLMap.put("ItemMovSumFromUpdateSQL", getStRepositoryValue("SQL_ST_PROD_TRANSFER_FROM_ITEM_MOVE_SUMM_UPDATE"));
		hmSQLMap.put("ItemMovSumToUpdateSQL", getStRepositoryValue("SQL_ST_PROD_TRANSFER_TO_ITEM_MOVE_SUMM_UPDATE"));
		hmSQLMap.put("RequestStatusUpdateSQL", getStRepositoryValue("SQL_ST_PROD_REQUEST_HDR_REQUEST_STATUS_UPDATE"));
		hmSQLMap.put("HdrUpdateSQL", getStRepositoryValue("SQL_ST_PRODUCT_TRANSFER_HDR_UPDATE"));
        hmSQLMap.put("DtlUpdateSQL", getStRepositoryValue("SQL_ST_PRODUCT_TRANSFER_DTL_UPDATE"));
        hmSQLMap.put("DtlExpUpdateSQL", getStRepositoryValue("SQL_ST_PRODUCT_TRANSFER_DTL_EXP_UPDATE"));
    	repackgrp=CommonBean.checkForNull(getRepackGroup());
		

        ArrayList alDtlList	    =	productTransferDetailBean.toArrayList();
    	HashMap hmDtlList = (HashMap)alDtlList.get(0);
		request_no = (String)hmDtlList.get("request_no");
		if(!request_no.equals(""))
			alRequestNo.add(request_no);
		

		alHdrListS=new ArrayList();
		
		/* Setting values for hdr insertion */

    	alHdrListS.add(com.ehis.util.DateUtils.convertDate(stHeaderBean.getDoc_date(),"DMY",getLanguageId(),"en"));
		alHdrListS.add(stHeaderBean.getDoc_ref());
		alHdrListS.add(stHeaderBean.getStore_code());
		alHdrListS.add((String)hmDtlList.get("fm_stk_uom_conv_factor"));
		alHdrListS.add((String)hmDtlList.get("to_stk_uom_conv_factor"));
		alHdrListS.add(((String)hmDtlList.get("fm_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
		alHdrListS.add(((String)hmDtlList.get("to_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
		alHdrListS.add((String)hmDtlList.get("fm_expiry_date"));
		String to_expiry_date=DateUtils.convertDate((String)hmDtlList.get("to_expiry_date"),"DMY",locale,"en");
		alHdrListS.add(to_expiry_date);
		alHdrListS.add((String)hmDtlList.get("fm_item_qty"));
		alHdrListS.add((String)hmDtlList.get("to_item_qty"));  //actual_qty    
		alHdrListS.add(getFinalized_yn());
		alHdrListS.add(getLoginById());
		alHdrListS.add(getLoginAtWsNo());
		alHdrListS.add(getLoginFacilityId() );

		alHdrListS.add(CommonBean.checkForNull((String)hmDtlList.get("actual_qty")));
		alHdrListS.add(CommonBean.checkForNull((String)hmDtlList.get("expect_bal_qty")));
		alHdrListS.add(CommonBean.checkForNull((String)hmDtlList.get("expect_act_qty")));
		alHdrListS.add((String)hmDtlList.get("time_taken"));
		alHdrListS.add((String)hmDtlList.get("p_packed_by"));
		alHdrListS.add((String)hmDtlList.get("counter_check"));
		alHdrListS.add((String)hmDtlList.get("p_auth_by"));
        alHdrListS.add((String)hmDtlList.get("remarks"));
		alHdrListS.add((String)hmDtlList.get("prepare_location"));
		alHdrListS.add(CommonBean.checkForNull((String)hmDtlList.get("no_of_labels")));
		alHdrListS.add(getLoginFacilityId() );
		alHdrListS.add(stHeaderBean.getDoc_type_code());
		alHdrListS.add(stHeaderBean.getDoc_no());

		/* Setting values for FROM dtl insertion Begins here*/
		alDtlListFromAdd.add((String)hmDtlList.get("fm_item_code"));
        alDtlListFromAdd.add("-"+(String)hmDtlList.get("fm_item_qty"));
        alDtlListFromAdd.add((String)hmDtlList.get("fm_item_unit_cost"));
        alDtlListFromAdd.add("-"+(String)hmDtlList.get("fm_item_cost_value"));
        
        alDtlListFromAdd.add(stHeaderBean.getStore_code());
        
        alDtlListFromAdd.add("Y");
		alDtlListFromAdd.add(getLoginById());
		alDtlListFromAdd.add(getLoginAtWsNo());
		alDtlListFromAdd.add(getLoginFacilityId() );
		alDtlListFromAdd.add(getLoginFacilityId());
        alDtlListFromAdd.add(stHeaderBean.getDoc_type_code());
		alDtlListFromAdd.add(stHeaderBean.getDoc_no());
        alDtlListFromAdd.add((String)hmDtlList.get("doc_srl_no"));
        /* Setting values for To dtl insertion ends here */

        /* Setting values for To dtl insertion Begins here*/

	    
		alDtlListToAdd.add((String)hmDtlList.get("to_item_code"));
        alDtlListToAdd.add((String)hmDtlList.get("to_item_qty"));
        alDtlListToAdd.add((String)hmDtlList.get("to_item_unit_cost"));
        alDtlListToAdd.add((String)hmDtlList.get("to_item_cost_value"));
        
        alDtlListToAdd.add(stHeaderBean.getStore_code());
        
        alDtlListToAdd.add("Y");

		alDtlListToAdd.add(getLoginById());
		alDtlListToAdd.add(getLoginAtWsNo());
		alDtlListToAdd.add(getLoginFacilityId() );
		alDtlListToAdd.add(getLoginFacilityId());
        alDtlListToAdd.add(stHeaderBean.getDoc_type_code());
		alDtlListToAdd.add(stHeaderBean.getDoc_no());
		nextDocSrlNo=String.valueOf(Integer.parseInt((String)hmDtlList.get("doc_srl_no"))+1);
		alDtlListToAdd.add(nextDocSrlNo);
		/* Setting values for To dtl insertion Ends here*/


       /* Setting values for From in dtl_exp insertion Begins here*/

		ArrayList alDtlExpListFrom	    =	new ArrayList();
        
        alDtlExpListFrom.add(stHeaderBean.getStore_code());
		alDtlExpListFrom.add((String)hmDtlList.get("fm_item_code"));
        alDtlExpListFrom.add(((String)hmDtlList.get("fm_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
        alDtlExpListFrom.add((String)hmDtlList.get("fm_bin_location_code"));
		alDtlExpListFrom.add((String)hmDtlList.get("fm_expiry_date"));
		alDtlExpListFrom.add("-"+(String)hmDtlList.get("fm_item_qty"));

		alDtlExpListFrom.add(getLoginById());
		alDtlExpListFrom.add(getLoginAtWsNo());
		alDtlExpListFrom.add(getLoginFacilityId() );

        alDtlExpListFrom.add((String)hmDtlList.get("fm_trade_id") );
		alDtlExpListFrom.add(CommonBean.checkForNull((String)hmDtlList.get("fm_barcode_id")) );  
		alDtlExpListFrom.add(getLoginFacilityId() );
        alDtlExpListFrom.add(stHeaderBean.getDoc_type_code());
		alDtlExpListFrom.add(stHeaderBean.getDoc_no());
		alDtlExpListFrom.add((String)hmDtlList.get("doc_srl_no"));
	
        /* Setting values for From in dtl_exp insertion Ends here*/

        
        /* Setting values for To in dtl_exp insertion Begins here*/

		ArrayList alDtlExpListTo	    =	new ArrayList();

       
		alDtlExpListTo.add(stHeaderBean.getStore_code());
		alDtlExpListTo.add((String)hmDtlList.get("to_item_code"));
        alDtlExpListTo.add(((String)hmDtlList.get("to_item_batch_id")).trim());//trim() added for KAUH-SCF-0344
        alDtlExpListTo.add((String)hmDtlList.get("to_bin_location_code"));
		alDtlExpListTo.add(to_expiry_date);	
		alDtlExpListTo.add((String)hmDtlList.get("to_item_qty"));	

		alDtlExpListTo.add(getLoginById());
		alDtlExpListTo.add(getLoginAtWsNo());
		alDtlExpListTo.add(getLoginFacilityId() );

        alDtlExpListTo.add((String)hmDtlList.get("to_trade_id") );
		alDtlExpListTo.add(CommonBean.checkForNull((String)hmDtlList.get("to_barcode_id")));		
		alDtlExpListTo.add(getLoginFacilityId() );	
        alDtlExpListTo.add(stHeaderBean.getDoc_type_code());	
		alDtlExpListTo.add(stHeaderBean.getDoc_no());	
        nextDocSrlNo=String.valueOf(Integer.parseInt((String)hmDtlList.get("doc_srl_no"))+1);
        alDtlExpListTo.add(nextDocSrlNo);

        /* Setting values for From in dtl_exp insertion Ends here*/

       /* Setting values for decrementing form FROM item BEGINS here*/

        HashMap hmParametersFrom=new HashMap();

	    hmParametersFrom.put("item_code", (String)hmDtlList.get("fm_item_code"));
		hmParametersFrom.put("store_code", stHeaderBean.getStore_code() );
        hmParametersFrom.put("trn_type", "PRT");

		hmParametersFrom.put("batch_id", ((String)hmDtlList.get("fm_item_batch_id")).trim());//trim() added for KAUH-SCF-0344
		hmParametersFrom.put("expiry_date_or_receipt_date",(String)hmDtlList.get("fm_expiry_date"));
		hmParametersFrom.put("trade_id", (String)hmDtlList.get("fm_trade_id"));

		
        hmParametersFrom.put("from_bin_location_code", (String)hmDtlList.get("fm_bin_location_code")); //old bin loc 
        hmParametersFrom.put("release_batch_yn", "N");
		hmParametersFrom.put("suspended_batch_allowed_yn", "Y");

		hmParametersFrom.put("login_by_id", getLoginById());
		hmParametersFrom.put("login_at_ws_no", getLoginAtWsNo());
		hmParametersFrom.put("login_facility_id", getLoginFacilityId());

		String qty_to_reduce="-"+(String)hmDtlList.get("fm_item_qty");
		hmParametersFrom.put("trn_qty",qty_to_reduce);
		hmParametersFrom.put("barcode_id", CommonBean.checkForNull((String)hmDtlList.get("fm_barcode_id")));  
		System.out.println("hmParametersFrom===>" +hmParametersFrom);

		ArrayList alHmParameterFrom=new ArrayList();
        alHmParameterFrom.add(hmParametersFrom);

  
       /* Setting values for decrementing form FROM item ENDS here*/
      /* Setting values for incrementing to TO item BEGINS here*/

        HashMap hmParametersTo=new HashMap();

	    hmParametersTo.put("item_code", (String)hmDtlList.get("to_item_code"));
		hmParametersTo.put("store_code", stHeaderBean.getStore_code() );
        hmParametersTo.put("trn_type", "PRT");

		hmParametersTo.put("batch_id", ((String)hmDtlList.get("to_item_batch_id")).trim()); //trim() added for KAUH-SCF-0344
		
		hmParametersTo.put("expiry_date_or_receipt_date",to_expiry_date);



		hmParametersTo.put("trade_id", (String)hmDtlList.get("to_trade_id"));
		
        hmParametersTo.put("from_bin_location_code", (String)hmDtlList.get("to_bin_location_code")); //old bin loc 
      	hmParametersTo.put("release_batch_yn", "N");

	    hmParametersTo.put("suspended_batch_allowed_yn", "Y");

		hmParametersTo.put("login_by_id", getLoginById());
		hmParametersTo.put("login_at_ws_no", getLoginAtWsNo());
		hmParametersTo.put("login_facility_id", getLoginFacilityId());

		String qty_to_increase=(String)hmDtlList.get("to_item_qty");
		hmParametersTo.put("trn_qty",qty_to_increase);

		hmParametersTo.put("sale_price",(String)hmDtlList.get("to_item_unit_price")); // added by ganga 
		hmParametersTo.put("sale_price_appl_yn",(String)hmDtlList.get("sale_price_appl_yn")); // added by ganga
        hmParametersTo.put("barcode_id",CommonBean.checkForNull((String)hmDtlList.get("to_barcode_id")));  
					
		
		ArrayList alHmParameterTo=new ArrayList();
        alHmParameterTo.add(hmParametersTo);
	
       /* Setting values for increminting to TO item ENDS here*/



      /* Decrementing the values for(item_qty and item_value) in st_item_store for FROM item BEGINS here*/

        HashMap hmParametersItemStoreFrom=new HashMap();

	    hmParametersItemStoreFrom.put("item_code", (String)hmDtlList.get("fm_item_code"));
		hmParametersItemStoreFrom.put("store_code", stHeaderBean.getStore_code() );
        hmParametersItemStoreFrom.put("trn_type", "PRT");

		hmParametersItemStoreFrom.put("to_bin_location_code", (String)hmDtlList.get("fm_bin_location_code")); 

		hmParametersItemStoreFrom.put("login_by_id", getLoginById());
		hmParametersItemStoreFrom.put("login_at_ws_no", getLoginAtWsNo());
		hmParametersItemStoreFrom.put("login_facility_id", getLoginFacilityId());

        hmParametersItemStoreFrom.put("from_stk_item_yn", "Y");
        hmParametersItemStoreFrom.put("to_stk_item_yn", "Y");

		qty_to_reduce="-"+(String)hmDtlList.get("fm_item_qty");
	    hmParametersItemStoreFrom.put("trn_qty",qty_to_reduce );

		String value_to_reduce="-"+(String)hmDtlList.get("fm_item_cost_value");
		hmParametersItemStoreFrom.put("trn_value", value_to_reduce );
        hmParametersItemStoreFrom.put("trn_unit_cost", (String)hmDtlList.get("fm_item_unit_cost"));
        hmParametersItemStoreFrom.put("mode","MODE_MODIFY");// added for calculateAndUpdateOnlineStock
		ArrayList alHmParameterItemStoreFrom=new ArrayList();
        alHmParameterItemStoreFrom.add(hmParametersItemStoreFrom);
  
       /* Decrementing the values for(item_qty and item_value) in st_item_store for FROM item ENDS here*/


     /* Setting values for updation in st_item_store for TO item BEGINS here*/

        HashMap hmParametersItemStoreTo=new HashMap();

	    hmParametersItemStoreTo.put("item_code", (String)hmDtlList.get("to_item_code"));
		hmParametersItemStoreTo.put("store_code", stHeaderBean.getStore_code() );
        hmParametersItemStoreTo.put("trn_type", "PRT");

		hmParametersItemStoreTo.put("to_bin_location_code", (String)hmDtlList.get("to_bin_location_code")); 

		hmParametersItemStoreTo.put("login_by_id", getLoginById());
		hmParametersItemStoreTo.put("login_at_ws_no", getLoginAtWsNo());
		hmParametersItemStoreTo.put("login_facility_id", getLoginFacilityId());

		hmParametersItemStoreTo.put("from_stk_item_yn", "Y");
        hmParametersItemStoreTo.put("to_stk_item_yn", "Y");

		qty_to_increase=(String)hmDtlList.get("to_item_qty");
		    hmParametersItemStoreTo.put("trn_qty",qty_to_increase );
		String value_to_increase=(String)hmDtlList.get("to_item_cost_value");
		hmParametersItemStoreTo.put("trn_value", value_to_increase );
		hmParametersItemStoreTo.put("trn_unit_cost", (String)hmDtlList.get("to_item_unit_cost"));
		hmParametersItemStoreTo.put("mode", "MODE_MODIFY");// added for calculateAndUpdateOnlineStock

		ArrayList alHmParameterItemStoreTo=new ArrayList();
        alHmParameterItemStoreTo.add(hmParametersItemStoreTo);
  
      /* Setting values for updation in st_item_store for TO item ENDS here*/

	

	  /* Setting values for insertion record in st_item_trn_dtl for FROM item BEGINS here*/


			ArrayList alFromDtlTrn=new ArrayList();
			
			alFromDtlTrn.add(getLoginFacilityId() );
			alFromDtlTrn.add(stHeaderBean.getStore_code());
			alFromDtlTrn.add((String)hmDtlList.get("fm_item_code"));
			alFromDtlTrn.add(""+1);
			alFromDtlTrn.add("PRT");
			alFromDtlTrn.add(stHeaderBean.getDoc_type_code());
			alFromDtlTrn.add(stHeaderBean.getDoc_no());
			alFromDtlTrn.add((String)hmDtlList.get("doc_srl_no"));
			alFromDtlTrn.add(stHeaderBean.getDoc_date());
			alFromDtlTrn.add(stHeaderBean.getDoc_ref());
			alFromDtlTrn.add(((String)hmDtlList.get("fm_item_batch_id")).trim());//trim() added for KAUH-SCF-0344
			alFromDtlTrn.add((String)hmDtlList.get("fm_expiry_date"));
			String temp_fm_item_qty="-"+(String)hmDtlList.get("fm_item_qty");
			alFromDtlTrn.add(temp_fm_item_qty);
			alFromDtlTrn.add("");
			alFromDtlTrn.add("");
			alFromDtlTrn.add((String)hmDtlList.get("fm_item_unit_cost"));
			//alFromDtlTrn.add("");
			alFromDtlTrn.add((String)hmDtlList.get("fm_item_unit_price"));//added for item_mrp_price
			alFromDtlTrn.add((String)hmDtlList.get("fm_stk_uom_code"));
			alFromDtlTrn.add("");
			alFromDtlTrn.add("");
			alFromDtlTrn.add("");
			alFromDtlTrn.add("");
			alFromDtlTrn.add("");
			alFromDtlTrn.add("");
			alFromDtlTrn.add("");
			alFromDtlTrn.add("Y");
			alFromDtlTrn.add("");
			alFromDtlTrn.add("");
			alFromDtlTrn.add(getLoginById());
			alFromDtlTrn.add(getLoginAtWsNo() );
			alFromDtlTrn.add(getLoginFacilityId() );
			alFromDtlTrn.add(getLoginById());
			alFromDtlTrn.add(getLoginAtWsNo() );
			alFromDtlTrn.add(getLoginFacilityId() );
			alFromDtlTrn.add("");
			alFromDtlTrn.add((String)hmDtlList.get("fm_bin_location_code"));
			alFromDtlTrn.add((String)hmDtlList.get("fm_trade_id") );

      /* Setting values for insertion record in st_item_trn_dtl for FROM item BEGINS here*/

		
	  /* Setting values for insertion record in st_item_trn_dtl for TO item BEGINS here*/


			    ArrayList alToDtlTrn=new ArrayList();
			
			alToDtlTrn.add(getLoginFacilityId() );
			alToDtlTrn.add(stHeaderBean.getStore_code());
			alToDtlTrn.add((String)hmDtlList.get("to_item_code"));
			alToDtlTrn.add(""+1);
			alToDtlTrn.add("PRT");
			alToDtlTrn.add(stHeaderBean.getDoc_type_code());
			alToDtlTrn.add(stHeaderBean.getDoc_no());
			alToDtlTrn.add(nextDocSrlNo);
			alToDtlTrn.add(stHeaderBean.getDoc_date());
			alToDtlTrn.add(stHeaderBean.getDoc_ref());
			alToDtlTrn.add(((String)hmDtlList.get("to_item_batch_id")).trim());//trim() added for KAUH-SCF-0344
			
			
			//String to_expiry_date=DateUtils.convertDate((String)hmDtlList.get("to_expiry_date"),"DMY",locale,"en");

		     
			alToDtlTrn.add(to_expiry_date);
			alToDtlTrn.add((String)hmDtlList.get("to_item_qty"));
			alToDtlTrn.add("");
			alToDtlTrn.add("");
			alToDtlTrn.add((String)hmDtlList.get("to_item_unit_cost"));
			//alToDtlTrn.add("");
			alToDtlTrn.add((String)hmDtlList.get("to_item_unit_price"));//added for item_mrp_price
			alToDtlTrn.add((String)hmDtlList.get("to_stk_uom_code"));
			alToDtlTrn.add("");
			alToDtlTrn.add("");
			alToDtlTrn.add("");
			alToDtlTrn.add("");
			alToDtlTrn.add("");
			alToDtlTrn.add("");
			alToDtlTrn.add("");
			alToDtlTrn.add("Y");
			alToDtlTrn.add("");
			alToDtlTrn.add("");
			alToDtlTrn.add(getLoginById());
			alToDtlTrn.add(getLoginAtWsNo() );
			alToDtlTrn.add(getLoginFacilityId() );
			alToDtlTrn.add(getLoginById());
			alToDtlTrn.add(getLoginAtWsNo() );
			alToDtlTrn.add(getLoginFacilityId() );
			alToDtlTrn.add("");
			alToDtlTrn.add((String)hmDtlList.get("to_bin_location_code"));
			alToDtlTrn.add((String)hmDtlList.get("to_trade_id") );

		
      /* Setting values for insertion record in st_item_trn_dtl for TO item BEGINS here*/



		hmTableData.put("properties",	 getProperties());
		hmTableData.put("RequestNo", alRequestNo);
		hmTableData.put("HdrUpdateData", alHdrListS);
		hmTableData.put("DtlUpdateDataFrom", alDtlListFromAdd);
        hmTableData.put("DtlUpdateDataTo", alDtlListToAdd);
        hmTableData.put("DtlExpUpdateDataFrom", alDtlExpListFrom);
        hmTableData.put("DtlExpUpdateDataTo", alDtlExpListTo);
        hmTableData.put("ItemQtyUpdateDataFrom", alHmParameterFrom);
        hmTableData.put("ItemQtyUpdateDataTo", alHmParameterTo);
        hmTableData.put("ItemStoreQtyUpdateDataFrom", alHmParameterItemStoreFrom);
		hmTableData.put("ItemStoreQtyUpdateDataTo", alHmParameterItemStoreTo);
        hmTableData.put("ItemTrnDtlDataFrom", alFromDtlTrn);
        hmTableData.put("ItemTrnDtlDataTo", alToDtlTrn);
		hmTableData.put("CommonData",	 alCommonData);
        
		 }
	 catch(Exception e) {
		e.printStackTrace();
	}  

  
    HashMap		hmResult	=	new HashMap()	;
  try{
    
	hmResult.put(RESULT, FALSE ) ;
	hmResult.put(MESSAGE, "Initial Message" ) ;

    
	/** For ejb deployment BEGINS here */

	   // eST.ProductTransfer.ProductTransferRemote producttransferremote = null;

	/*InitialContext initialcontext = new InitialContext();
	Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_ST_PRODUCT_TRANSFER"));
	eST.ProductTransfer.ProductTransferHome producttransferhome = (eST.ProductTransfer.ProductTransferHome)PortableRemoteObject.narrow(obj1, eST.ProductTransfer.ProductTransferHome.class);
	producttransferremote = producttransferhome.create();
	hmResult = producttransferremote.insert(hmTableData, hmSQLMap);*/


	Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_PRODUCT_TRANSFER"),eST.ProductTransfer.ProductTransferHome.class,getLocalEJB());
	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

	Object argArray[] = new Object[2];
	argArray[0] = hmTableData;
	argArray[1] = hmSQLMap;

	Class [] paramArray = new Class[2];
	paramArray[0] = hmTableData.getClass(); ;
	paramArray[1] = hmSQLMap.getClass();
	
	 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
	
	(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

	
		/** For ejb deployment ENDS here */

	
     MessageManager mm=new MessageManager();

	if( ((Boolean) hmResult.get("result")).booleanValue() )	{

	// hmResult.put("message", getSTMessage(getLanguageId(),(String) hmResult.get("msgid" ),"ST") ) ;
	     final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "ST") ;
	    hmResult.put("message",(String) mesg.get("message")) ;

	}
	else if( hmResult.get("msgid")!=null  ) {
		hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;

	}
	else {
		hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
	}
/* SEND TO PRINT ONLINE REPORT STARTS*/
		
		//doc_no	=	(String)hmResult.get("doc_no");	
		String alertRqdYN = "";
		setPrintDocNo(stHeaderBean.getDoc_no());

		PgetDoc_type_code =stHeaderBean.getDoc_type_code();
		PgetStore_codest  =stHeaderBean.getStore_code();
       // PgetTrnType  = getTrn_type() ; 
		//PgetSeqNo = getSeq_no() ;


		ArrayList params = new ArrayList ();
		params.add(PgetDoc_type_code);
		params.add(getLoginFacilityId());
		alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));

   
		

	//  if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
	  if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
		{

			if (isInternalRequest("ST","STBPTFDC") && isDocTypePrintAllowed(PgetDoc_type_code) ) 
			{
					if(alertRqdYN.equals("Y")){	
						hmResult.put("flag",hmResult.get("flag") + "~PY");
					}
					else{
						//doOnlineReportPrinting(doc_no);
						//doOnlineReportPrintingOfLabel(doc_no);
						hmResult.put("flag",hmResult.get("flag") + "~PN");
					}
			}

			//doOnlineReportPrintingOfLabel(doc_no);
		}

   }catch(Exception e){
	   e.printStackTrace();
	}
          
	return hmResult;    


	}
	
}
//Added for ML-MMOH-CRF-0448 B.Badmavathi ends


