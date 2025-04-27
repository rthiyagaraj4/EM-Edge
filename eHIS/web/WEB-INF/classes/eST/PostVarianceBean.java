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
24/12/2020				IN7402					   Haribabu			  											AAKH-SCF-0464                 
2/7/2021				15757						Shazana														Common-ICN-0028
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eST;

import eST.Common.* ;
import eCommon.Common.*;
//import eST.Common.StTransaction;

  
import eST.PostVariance.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;

public class PostVarianceBean extends StTransaction
    implements Serializable
{
	//private String language_id;
    public PostVarianceBean()
    {
        defaultWriteOffReasonCode = "";
        defaultDocType = "";
        defaultStoreCode = "";
    }

    public void setDefaultDocType(String s)
    {
        defaultDocType = s;
    }

    public String getDefaultDocType()
    {
        return defaultDocType;
    }

    public void setDefaultStoreCode(String s)
    {
        defaultStoreCode = s;
    }

    public void setPhy_inv_id(String s)
    {
        phy_inv_id = s;
    }

    public String getPhy_inv_id()
    {
        return phy_inv_id;
    }
/*public void setLanguageId(String language_id)
    {
        this.language_id = language_id;
    }

    public String getLanguageId()
    {
        return language_id;
    }*/
    public String getDefaultStoreCode()
    {
        return defaultStoreCode;
    }

    public void setIsAutoNo(boolean flag)
    {
        isAutoNo = flag;
    }

    public void setWrite_off_reason_code(String s)
    {
        write_off_reason_code = s;
    }

    public String getWrite_off_reason_code()
    {
        return write_off_reason_code;
    }

    public boolean getIsAutoNo()
    {
        return isAutoNo;
    }

    public void setTray_no(String s)
    {
        tray_no = s;
    }

    public String getTray_no()
    {
        return tray_no;
    }

    public void setTrn_type(String s)
    {
        trn_type = s;
    }

    public String getTrn_type()
    {
        return trn_type;
    }

    public void setDoc_type_code(String s)
    {
        doc_type_code = s;
    }

    public String getDoc_type_code()
    {
        return doc_type_code;
    }

    public void setDoc_date(String s)
    {
        doc_date = s;
    }

    public String getDoc_date()
    {
        try
        {
            if(super.mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
                return getSystemDate();
            else
                return doc_date;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return exception.toString();
        }
    }

    public void setDoc_no(String s)
    {
        doc_no = s;
    }

    public String getDoc_no()
    {
        return doc_no;
    }

    public void setBin_location_code(String s)
    {
        bin_location_code = s;
    }

    public String getBin_location_code()
    {
        return bin_location_code;
    }

    public void setFacility_id(String s)
    {
        facility_id = s;
    }

    public String getFacility_id()
    {
        return facility_id;
    }

    public void clear()
    {
        super.clear();
        trn_type = "";
        doc_type_code = "";
        doc_date = "";
        doc_no = "";
        bin_location_code = "";
        facility_id = "";
        tray_no = "";
    }

    public void setAll(Hashtable hashtable)
    {
        setMode((String)hashtable.get("mode"));
        setTrn_type((String)hashtable.get("trn_type"));
        setDoc_type_code((String)hashtable.get("doc_type_code"));
        setDoc_date((String)hashtable.get("doc_date"));
        setDoc_no((String)hashtable.get("doc_no"));
        
        setPhy_inv_id((String)hashtable.get("phy_inv_id"));
    }

    public String getDocTypes()
    {
        String s = null;
        ArrayList arraylist = new ArrayList(5);
        ArrayList arraylist1 = new ArrayList();
        arraylist.add(super.login_facility_id);
        arraylist.add("VAR");
        arraylist.add(getLanguageId());
		try{
        arraylist1 = getListOptionArrayList(getStRepositoryValue("SQL_ST_POST_VARIANCE_DOC_TYPE"), arraylist);
            s = getListOptionTag(arraylist1, (String)getStParameter().get("DEF_VAR_DOC_TYPE_CODE"));
       // else
         //   s = getListOptionTag(arraylist1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
        arraylist = null;
        arraylist1 = null;
        return s;
    }

    public String getPhyInvIDs()
    {
        String s = null;
        String stParameter[] = {getLoginFacilityId(),getLoginById()};
        ArrayList arraylist = new ArrayList();
        //arraylist = getListOptionArrayList(getStRepositoryValue("SQL_ST_POST_VARIANCE_PHY_INV_ID"), super.login_facility_id);
        arraylist = getListOptionArrayList("SELECT PHY_INV_ID, PHY_INV_ID FROM ST_PHY_INV_PARAM,ST_USER_ACCESS_FOR_STORE WHERE FACILITY_ID = ? AND USER_ID = ? AND ENTRY_COMPLETED_YN = 'Y' AND VAR_ALLOWED_YN = 'Y' AND FM_STORE_CODE = STORE_CODE AND POSTED_DATE IS NULL AND CANCELLED_DATE IS NULL ORDER BY 1", stParameter);
        s = getListOptionTag(arraylist, getDefaultStoreCode());
        arraylist = null;
        return s;
    }

/* // pmd 19/02/05 
	public HashMap validate()
    {

        Object obj = null;
        Object obj1 = null;
       Object obj2 = null;
        HashMap hashmap = new HashMap();
        hashmap.put("result", new Boolean(true));
        hashmap.put("message", "success");
        int i = -1;
        try
        {
           /* boolean flag = true;
            Object obj3 = null;
            Connection connection = getConnection();
            if(!isAutoNo && super.mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
            {
                PreparedStatement preparedstatement = connection.prepareStatement(getStRepositoryValue("SQL_SS_WRITE_OFF_HDR_RECORD_COUNT"));
                preparedstatement.setString(1, super.login_facility_id);
                preparedstatement.setString(2, doc_type_code);
                preparedstatement.setString(3, doc_no);
                ResultSet resultset = preparedstatement.executeQuery();
                if(resultset.next())
                    i = resultset.getInt(1);
                if(i > 0)
                {
                    hashmap.put("result", new Boolean(false));
                    hashmap.put("msgid", "DUPLICATE_DOC_NO");
                    hashmap.put("message", getMessage("DUPLICATE_DOC_NO"));
                }
                if(resultset != null)
                    resultset.close();
                if(preparedstatement != null)
                    preparedstatement.close();
                if(connection != null)
                    connection.close();
            }
			
        }
        catch(Exception exception)
        {
            hashmap.put("result", new Boolean(false));
            hashmap.put("message", exception.getMessage());
        }
        return hashmap;
    }
*/
    public HashMap isValidDocNo()
    {
/*        Object obj = null;
        Object obj1 = null;
        Object obj2 = null;*/
        HashMap hashmap = new HashMap();
        hashmap.put("result", new Boolean(true));
        hashmap.put("message", "success");
        int i = -1;
        try
        {
            if(!isAutoNo && super.mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
            {
                Connection connection = getConnection();
                PreparedStatement preparedstatement = connection.prepareStatement(getStRepositoryValue("SQL_SS_WRITE_OFF_HDR_RECORD_COUNT"));
                preparedstatement.setString(1, super.login_facility_id);
                preparedstatement.setString(2, doc_type_code);
                preparedstatement.setString(3, doc_no);
                ResultSet resultset = preparedstatement.executeQuery();
                if(resultset.next())
                    i = resultset.getInt(1);
                if(i > 0)
                {
                    hashmap.put("result", new Boolean(false));
                    hashmap.put("msgid", "DUPLICATE_DOC_NO");
                    hashmap.put("message", getMessage("DUPLICATE_DOC_NO"));
                }
                if(resultset != null)
                    resultset.close();
                if(preparedstatement != null)
                    preparedstatement.close();
                if(connection != null)
                    connection.close();
            }
        }
        catch(Exception exception)
        {
            hashmap.put("result", new Boolean(false));
            hashmap.put("message", exception.getMessage());
        }
        return hashmap;
    }

    public void setDefaultWriteOffReasonCode(String s)
    {
        defaultWriteOffReasonCode = s;
    }

    public String getDefaultWriteOffReasonCode()
    {
        return defaultWriteOffReasonCode;
    }

    public HashMap insert()
    {
        java.util.Properties properties = getProperties();
        HashMap hashmap = new HashMap();
//        HashMap hmCommonData = new HashMap();
        HashMap hashmapQuery = new HashMap();
        ArrayList arraylist = new ArrayList();
//        ArrayList arraylist1 = new ArrayList();
        hashmap.put("result", new Boolean(false));
		String doc_no="";
	//	double unit_cost=0.0;// added for MMS-ICN-00110//commented for 15757
        try
        {
			
           //   doc_no=fetchNextDocNo(getDoc_type_code());
             
      
		arraylist.add(doc_no);
		arraylist.add(getDoc_type_code());
		arraylist.add(getPhy_inv_id());
		arraylist.add(getLoginById());
		arraylist.add(getLoginAtWsNo());
		arraylist.add(getLoginFacilityId());
		arraylist.add(""+getSystemDate());
		
	
		hashmapQuery.put("SQL_ST_POST_VARIANCE_STORE_CODE", getStRepositoryValue("SQL_ST_POST_VARIANCE_STORE_CODE"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_INSERT", getStRepositoryValue("SQL_ST_POST_VARIANCE_INSERT"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_INSERT_DTL", getStRepositoryValue("SQL_ST_POST_VARIANCE_INSERT_DTL"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_INSERT_BATCH", getStRepositoryValue("SQL_ST_POST_VARIANCE_INSERT_BATCH"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_SELECT_ITEM", getStRepositoryValue("SQL_ST_POST_VARIANCE_SELECT_ITEM"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_SELECT_PISQ", getStRepositoryValue("SQL_ST_POST_VARIANCE_SELECT_PISQ"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_SUM_QTY", getStRepositoryValue("SQL_ST_POST_VARIANCE_SUM_QTY"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_UPDATE_STORE", getStRepositoryValue("SQL_ST_POST_VARIANCE_UPDATE_STORE"));
		
		/**
				* @Name - krishna reddy
				* @Date - 22/12/2009
				* @Inc# - IN017304
				* @Desc - Update the columns PHY_INV_ID, PHY_INV_START_DATE and PHY_INV_START_QTY in ST_ITEM_BATCH table facility wise.
		*/
		//hashmapQuery.put("SQL_ST_POST_VARIANCE_SELECT_BATCH", getStRepositoryValue("SQL_ST_POST_VARIANCE_SELECT_BATCH"));
		//hashmapQuery.put("SQL_ST_POST_VARIANCE_SELECT_BATCH", "SELECT A.item_code,A.store_code, TO_CHAR(A.expiry_date_or_receipt_date,'dd/mm/yyyy') EXPIRY_DATE, A.batch_id, A.bin_location_code, A.trade_id,NVL(a.phy_inv_start_qty,0) comp_qty,NVL(item_qty,0) phy_stk_qty,ROUND(NVL(a.phy_inv_start_qty,0)* NVL(c.item_value,0)/DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand),3) item_val,ROUND(NVL(item_qty,0)*NVL(c.item_value,0)/DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand),3) comp_val,(NVL(item_qty,0) - NVL(a.phy_inv_start_qty,0)) var_qty,ROUND(NVL(c.item_value,0)/DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand),3)unit_cost,ROUND((NVL(item_qty,0) - NVL(a.phy_inv_start_qty,0))* NVL(c.item_value,0)/ DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand),3) var_val, A.phy_inv_id  FROM ST_ITEM_BATCH A, ST_PHY_INV_DTL b, st_item_store c  ,st_phy_inv_param d WHERE A.item_code=b.item_code (+) AND A.store_code=b.store_code (+) AND A.phy_inv_id = b.phy_inv_id(+) AND  A.batch_id = b.batch_id (+) AND  A.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+) AND  A.bin_location_code=b.bin_location_code (+) AND  A.item_code=c.item_code AND A.store_code=c.store_code and A.phy_inv_id=?   AND (NVL(item_qty,0) - NVL(a.phy_inv_start_qty,0))<>0 AND a.phy_inv_id=d.phy_inv_id and d.posted_date is null  and d.facility_id = ? and d.facility_id =  b.facility_id UNION  SELECT A.item_code,A.store_code,  TO_CHAR(A.expiry_date_or_receipt_date,'dd/mm/yyyy') EXPIRY_DATE,A.batch_id,A.bin_location_code, A.trade_id,NVL(b.phy_inv_start_qty,0) comp_qty,NVL(item_qty,0) phy_stk_qty,ROUND(NVL(b.phy_inv_start_qty,0)* NVL(c.item_value,0)/ DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand),3) item_val, ROUND(NVL(item_qty,0)*NVL(c.item_value,0)/DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand),3) comp_val,(NVL(item_qty,0) - NVL(b.phy_inv_start_qty,0)) var_qty, ROUND(NVL(c.item_value,0)/ DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand),3)unit_cost ,ROUND((NVL(item_qty,0) - NVL(b.phy_inv_start_qty,0))*NVL(c.item_value,0)/ DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand),3) var_val,A.phy_inv_id FROM ST_ITEM_BATCH b, ST_PHY_INV_DTL A, st_item_store c ,st_phy_inv_param d  WHERE A.item_code=b.item_code (+) AND A.store_code=b.store_code (+) AND A.phy_inv_id = b.phy_inv_id(+) AND  A.batch_id = b.batch_id (+) AND  A.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+) AND  A.bin_location_code=b.bin_location_code (+) AND  A.item_code=c.item_code and  a.store_code=c.store_code AND  A.phy_inv_id=?  AND  (NVL(item_qty,0) - NVL(b.phy_inv_start_qty,0))<>0  AND a.phy_inv_id=d.phy_inv_id and d.posted_date is null  and d.facility_id = ? and d.facility_id =  a.facility_id ORDER BY STORE_CODE, ITEM_CODE, BATCH_ID, BIN_LOCATION_CODE, EXPIRY_DATE ");
		/**
		 * @Name - Priya
		 * @Date - 08/06/2010
		 * @Inc# - 
		 * @Desc -    To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' and to round up comp_val,var_val and item_val with st_get_cost_decimals  the above query is modified 
		 */
		//hashmapQuery.put("SQL_ST_POST_VARIANCE_SELECT_BATCH", "SELECT   a.item_code, a.store_code, TO_CHAR (a.expiry_date_or_receipt_date, 'dd/mm/yyyy') expiry_date, a.batch_id, a.bin_location_code, a.trade_id, NVL (a.phy_inv_start_qty, 0) comp_qty, NVL (item_qty, 0) phy_stk_qty, st_get_cost_decimals(  (  NVL (a.phy_inv_start_qty, 0) * NVL (c.item_value, 0) / DECODE (NVL (c.qty_on_hand, 0), 0, 1, c.qty_on_hand)),'N') item_val, st_get_cost_decimals(  (  NVL (item_qty, 0) * NVL (c.item_value, 0) / DECODE (NVL (c.qty_on_hand, 0), 0, 1, c.qty_on_hand)),'N') comp_val, (NVL (item_qty, 0) - NVL (a.phy_inv_start_qty, 0)) var_qty, st_display_cost_decimals(c.item_code,c.store_code) unit_cost, st_get_cost_decimals(  ((NVL (item_qty, 0) - NVL (a.phy_inv_start_qty, 0)) * NVL (c.item_value, 0) / DECODE (NVL (c.qty_on_hand, 0), 0, 1, c.qty_on_hand)),'N') var_val, a.phy_inv_id FROM st_item_batch a, st_phy_inv_dtl b, st_item_store c, st_phy_inv_param d WHERE a.item_code = b.item_code(+) AND a.store_code = b.store_code(+) AND a.phy_inv_id = b.phy_inv_id(+) AND a.batch_id = b.batch_id(+) AND a.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+) AND a.bin_location_code = b.bin_location_code(+) AND a.item_code = c.item_code AND a.store_code = c.store_code AND a.phy_inv_id = ? AND (NVL (item_qty, 0) - NVL (a.phy_inv_start_qty, 0)) <> 0 AND a.phy_inv_id = d.phy_inv_id AND d.posted_date IS NULL AND d.facility_id = ? AND d.facility_id = b.facility_id UNION SELECT   a.item_code, a.store_code, TO_CHAR (a.expiry_date_or_receipt_date, 'dd/mm/yyyy') expiry_date, a.batch_id, a.bin_location_code, a.trade_id, NVL (b.phy_inv_start_qty, 0) comp_qty, NVL (item_qty, 0) phy_stk_qty, st_get_cost_decimals(  (  NVL (b.phy_inv_start_qty, 0) * NVL (c.item_value, 0) / DECODE (NVL (c.qty_on_hand, 0), 0, 1, c.qty_on_hand)),'N') item_val, st_get_cost_decimals(  (  NVL (item_qty, 0) * NVL (c.item_value, 0) / DECODE (NVL (c.qty_on_hand, 0), 0, 1, c.qty_on_hand)),'N') comp_val, (NVL (item_qty, 0) - NVL (b.phy_inv_start_qty, 0)) var_qty, st_display_cost_decimals(c.item_code,c.store_code) unit_cost, st_get_cost_decimals(((NVL (item_qty, 0) - NVL (b.phy_inv_start_qty, 0)) * NVL (c.item_value, 0) / DECODE (NVL (c.qty_on_hand, 0), 0, 1, c.qty_on_hand)),'N') var_val, a.phy_inv_id FROM st_item_batch b, st_phy_inv_dtl a, st_item_store c, st_phy_inv_param d WHERE a.item_code = b.item_code(+) AND a.store_code = b.store_code(+) AND a.phy_inv_id = b.phy_inv_id(+) AND a.batch_id = b.batch_id(+) AND a.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+) AND a.bin_location_code = b.bin_location_code(+) AND a.item_code = c.item_code AND a.store_code = c.store_code AND a.phy_inv_id = ? AND (NVL (item_qty, 0) - NVL (b.phy_inv_start_qty, 0)) <> 0 AND a.phy_inv_id = d.phy_inv_id AND d.posted_date IS NULL AND d.facility_id = ? AND d.facility_id = a.facility_id ORDER BY store_code, item_code, batch_id, bin_location_code, expiry_date");
		//Modified by suresh.r on 03-11-2014 against Inc 52256 added unticost function
		hashmapQuery.put("SQL_ST_POST_VARIANCE_SELECT_BATCH", "SELECT   a.item_code, a.store_code, TO_CHAR (a.expiry_date_or_receipt_date, 'dd/mm/yyyy') expiry_date, a.batch_id, a.bin_location_code, a.trade_id, NVL (a.phy_inv_start_qty, 0) comp_qty, NVL (item_qty, 0) phy_stk_qty, st_get_cost_decimals(  (  NVL (a.phy_inv_start_qty, 0) * st_display_unit_cost (c.item_code,sysdate,'CURRENT_STOCK')),'N') item_val, st_get_cost_decimals(  (  NVL (item_qty, 0) * st_display_unit_cost (c.item_code,sysdate,'CURRENT_STOCK')),'N') comp_val, (NVL (item_qty, 0) - NVL (a.phy_inv_start_qty, 0)) var_qty, st_display_unit_cost (c.item_code,sysdate,'CURRENT_STOCK') unit_cost, st_get_cost_decimals(  ((NVL (item_qty, 0) - NVL (a.phy_inv_start_qty, 0)) * st_display_unit_cost (c.item_code,sysdate,'CURRENT_STOCK')),'N') var_val, a.phy_inv_id FROM st_item_batch a, st_phy_inv_dtl b, st_item_store c, st_phy_inv_param d WHERE a.item_code = b.item_code(+) AND a.store_code = b.store_code(+) AND a.phy_inv_id = b.phy_inv_id(+) AND a.batch_id = b.batch_id(+) AND a.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+) AND a.bin_location_code = b.bin_location_code(+) AND a.item_code = c.item_code AND a.store_code = c.store_code AND a.phy_inv_id = ? /*AND (NVL (item_qty, 0) - NVL (a.phy_inv_start_qty, 0)) <> 0*/ AND a.phy_inv_id = d.phy_inv_id AND d.posted_date IS NULL AND d.facility_id = ? AND d.facility_id = b.facility_id UNION SELECT   a.item_code, a.store_code, TO_CHAR (a.expiry_date_or_receipt_date, 'dd/mm/yyyy') expiry_date, a.batch_id, a.bin_location_code, a.trade_id, NVL (b.phy_inv_start_qty, 0) comp_qty, NVL (item_qty, 0) phy_stk_qty, st_get_cost_decimals(  (  NVL (b.phy_inv_start_qty, 0) * st_display_unit_cost (c.item_code,sysdate,'CURRENT_STOCK')),'N') item_val, st_get_cost_decimals(  (  NVL (item_qty, 0) * st_display_unit_cost (c.item_code,sysdate,'CURRENT_STOCK')),'N') comp_val, (NVL (item_qty, 0) - NVL (b.phy_inv_start_qty, 0)) var_qty, st_display_unit_cost (c.item_code,sysdate,'CURRENT_STOCK') unit_cost, st_get_cost_decimals(((NVL (item_qty, 0) - NVL (b.phy_inv_start_qty, 0)) * st_display_unit_cost (c.item_code,sysdate,'CURRENT_STOCK')),'N') var_val, a.phy_inv_id FROM st_item_batch b, st_phy_inv_dtl a, st_item_store c, st_phy_inv_param d WHERE a.item_code = b.item_code(+) AND a.store_code = b.store_code(+) AND a.phy_inv_id = b.phy_inv_id(+) AND a.batch_id = b.batch_id(+) AND a.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+) AND a.bin_location_code = b.bin_location_code(+) AND a.item_code = c.item_code AND a.store_code = c.store_code AND a.phy_inv_id = ? /*AND (NVL (item_qty, 0) - NVL (b.phy_inv_start_qty, 0)) <> 0 */ AND a.phy_inv_id = d.phy_inv_id AND d.posted_date IS NULL AND d.facility_id = ? AND d.facility_id = a.facility_id ORDER BY store_code, item_code, batch_id, bin_location_code, expiry_date"); //Modified for TFS-7402


		hashmapQuery.put("SQL_ST_POST_VARIANCE_UPDATE_BATCH", getStRepositoryValue("SQL_ST_POST_VARIANCE_UPDATE_BATCH"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_UPDATE_ALL_BATCH", getStRepositoryValue("SQL_ST_POST_VARIANCE_UPDATE_ALL_BATCH"));

		hashmapQuery.put("SQL_ST_POST_VARIANCE_SELECT_PHY_START_QTY", getStRepositoryValue("SQL_ST_POST_VARIANCE_SELECT_PHY_START_QTY"));
		hashmapQuery.put("SQL_ST_ITEM_TRN_DTL_INSERT", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_ITEM_MOMENT_INSERT", getStRepositoryValue("SQL_ST_POST_VARIANCE_ITEM_MOMENT_INSERT"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_ITEM_MOMENT_UPDATE", getStRepositoryValue("SQL_ST_POST_VARIANCE_ITEM_MOMENT_UPDATE"));
		
		
		//hashmapQuery.put("SQL_ST_POST_VARIANCE_SUM_VAR_QTY", getStRepositoryValue("SQL_ST_POST_VARIANCE_SUM_VAR_QTY"));
		//hashmapQuery.put("SQL_ST_POST_VARIANCE_SUM_VAR_QTY","SELECT A.store_code,A.item_code,(SUM(NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))) var_qty, ROUND(SUM((NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))*NVL(c.item_value,0)/DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand)) ,3)var_val,(NVL(A.phy_inv_start_qty,0)) comp_qty ,(NVL(item_qty,0)) phy_stk_qty FROM ST_ITEM_BATCH A, ST_PHY_INV_DTL b, ST_ITEM_STORE c WHERE A.item_code=b.item_code (+)   AND  A.store_code=b.store_code (+) AND  A.phy_inv_id = b.phy_inv_id(+)   AND  A.batch_id = b.batch_id (+) AND   A.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+)   AND  A.bin_location_code=b.bin_location_code (+) AND  A.item_code=c.item_code AND A.store_code=c.store_code AND  A.phy_inv_id=? AND A.store_code =? AND  A.item_code =?   AND  (NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))<>0  GROUP BY  A.store_code  , A.item_code,A.phy_inv_start_qty,item_qty UNION SELECT A.store_code,A.item_code,(SUM(NVL(item_qty,0) - NVL(b.phy_inv_start_Qty,0)))  var_qty,	ROUND(SUM((NVL(item_qty,0)  - NVL(b.phy_inv_start_Qty,0))*NVL(c.item_value,0)/DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand)),3)var_val ,NVL(b.phy_inv_start_qty,0) comp_qty,(NVL(item_qty,0)) phy_stk_qty  FROM ST_ITEM_BATCH b, ST_PHY_INV_DTL A, ST_ITEM_STORE c WHERE A.item_code=b.item_code (+)   AND A.store_code=b.store_code (+) AND A.phy_inv_id = b.phy_inv_id(+)   AND A.batch_id = b.batch_id (+) AND   A.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+)   AND  A.bin_location_code=b.bin_location_code (+) AND  A.item_code=c.item_code AND A.store_code=c.store_code(+) AND  A.phy_inv_id=? AND A.store_code=?  AND  A.item_code=?  AND  (NVL(item_qty,0) - NVL(b.phy_inv_start_Qty,0))<>0  GROUP BY  A.store_code  , A.item_code,b.phy_inv_start_qty,item_qty ");
			/**
		 * @Name - Priya
		 * @Date - 08/06/2010
		 * @Inc# - 
		 * @Desc -    To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' and to round up comp_val,var_val and item_val with st_get_cost_decimals  the above query is modified 
		 */
		 //hashmapQuery.put("SQL_ST_POST_VARIANCE_SUM_VAR_QTY","SELECT A.store_code,A.item_code,(SUM(NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))) var_qty, st_get_cost_decimals(SUM((NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))*NVL(c.item_value,0)/DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand)) ,'N')var_val,(NVL(A.phy_inv_start_qty,0)) comp_qty ,(NVL(item_qty,0)) phy_stk_qty FROM ST_ITEM_BATCH A, ST_PHY_INV_DTL b, ST_ITEM_STORE c WHERE A.item_code=b.item_code (+)   AND  A.store_code=b.store_code (+) AND  A.phy_inv_id = b.phy_inv_id(+)   AND  A.batch_id = b.batch_id (+) AND   A.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+)   AND  A.bin_location_code=b.bin_location_code (+) AND  A.item_code=c.item_code AND A.store_code=c.store_code AND  A.phy_inv_id=? AND A.store_code =? AND  A.item_code =?   AND  (NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))<>0  GROUP BY  A.store_code  , A.item_code,A.phy_inv_start_qty,item_qty UNION SELECT A.store_code,A.item_code,(SUM(NVL(item_qty,0) - NVL(b.phy_inv_start_Qty,0)))  var_qty,	st_get_cost_decimals(SUM((NVL(item_qty,0)  - NVL(b.phy_inv_start_Qty,0))*NVL(c.item_value,0)/DECODE(NVL(c.qty_on_hand,0),0,1,c.qty_on_hand)),'N')var_val ,NVL(b.phy_inv_start_qty,0) comp_qty,(NVL(item_qty,0)) phy_stk_qty  FROM ST_ITEM_BATCH b, ST_PHY_INV_DTL A, ST_ITEM_STORE c WHERE A.item_code=b.item_code (+)   AND A.store_code=b.store_code (+) AND A.phy_inv_id = b.phy_inv_id(+)   AND A.batch_id = b.batch_id (+) AND   A.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+)   AND  A.bin_location_code=b.bin_location_code (+) AND  A.item_code=c.item_code AND A.store_code=c.store_code(+) AND  A.phy_inv_id=? AND A.store_code=?  AND  A.item_code=?  AND  (NVL(item_qty,0) - NVL(b.phy_inv_start_Qty,0))<>0  GROUP BY  A.store_code  , A.item_code,b.phy_inv_start_qty,item_qty ");
		//Modified by suresh.r on 07-08-2014 against MMS-SCF-0390 chaged unticost logic
		//hashmapQuery.put("SQL_ST_POST_VARIANCE_SUM_VAR_QTY","SELECT A.store_code,A.item_code,(SUM(NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))) var_qty, st_get_cost_decimals(SUM((NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))*st_display_unit_cost(a.item_code)) ,'N')var_val,(NVL(A.phy_inv_start_qty,0)) comp_qty ,(NVL(item_qty,0)) phy_stk_qty FROM ST_ITEM_BATCH A, ST_PHY_INV_DTL b, ST_ITEM_STORE c WHERE A.item_code=b.item_code (+)   AND  A.store_code=b.store_code (+) AND  A.phy_inv_id = b.phy_inv_id(+)   AND  A.batch_id = b.batch_id (+) AND   A.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+)   AND  A.bin_location_code=b.bin_location_code (+) AND  A.item_code=c.item_code AND A.store_code=c.store_code AND  A.phy_inv_id=? AND A.store_code =? AND  A.item_code =?   AND  (NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))<>0  GROUP BY  A.store_code  , A.item_code,A.phy_inv_start_qty,item_qty UNION SELECT A.store_code,A.item_code,(SUM(NVL(item_qty,0) - NVL(b.phy_inv_start_Qty,0)))  var_qty,	st_get_cost_decimals(SUM((NVL(item_qty,0)  - NVL(b.phy_inv_start_Qty,0))*st_display_unit_cost(a.item_code)),'N')var_val ,NVL(b.phy_inv_start_qty,0) comp_qty,(NVL(item_qty,0)) phy_stk_qty  FROM ST_ITEM_BATCH b, ST_PHY_INV_DTL A, ST_ITEM_STORE c WHERE A.item_code=b.item_code (+)   AND A.store_code=b.store_code (+) AND A.phy_inv_id = b.phy_inv_id(+)   AND A.batch_id = b.batch_id (+) AND   A.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+)   AND  A.bin_location_code=b.bin_location_code (+) AND  A.item_code=c.item_code AND A.store_code=c.store_code(+) AND  A.phy_inv_id=? AND A.store_code=?  AND  A.item_code=?  AND  (NVL(item_qty,0) - NVL(b.phy_inv_start_Qty,0))<>0  GROUP BY  A.store_code  , A.item_code,b.phy_inv_start_qty,item_qty ");
		//Modified by suresh.r on 03-11-2014 against Inc 52256 passed sysdate,CURRENT_STOCK to unitcost fun
		hashmapQuery.put("SQL_ST_POST_VARIANCE_SUM_VAR_QTY","SELECT A.store_code,A.item_code,(SUM(NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))) var_qty, st_get_cost_decimals(SUM((NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))*st_display_unit_cost(a.item_code,sysdate,'CURRENT_STOCK')) ,'N')var_val,(NVL(A.phy_inv_start_qty,0)) comp_qty ,(NVL(item_qty,0)) phy_stk_qty FROM ST_ITEM_BATCH A, ST_PHY_INV_DTL b, ST_ITEM_STORE c WHERE A.item_code=b.item_code (+)   AND  A.store_code=b.store_code (+) AND  A.phy_inv_id = b.phy_inv_id(+)   AND  A.batch_id = b.batch_id (+) AND   A.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+)   AND  A.bin_location_code=b.bin_location_code (+) AND  A.item_code=c.item_code AND A.store_code=c.store_code AND  A.phy_inv_id=? AND A.store_code =? AND  A.item_code =?   AND  (NVL(item_qty,0) - NVL(A.phy_inv_start_Qty,0))<>0  GROUP BY  A.store_code  , A.item_code,A.phy_inv_start_qty,item_qty UNION SELECT A.store_code,A.item_code,(SUM(NVL(item_qty,0) - NVL(b.phy_inv_start_Qty,0)))  var_qty,	st_get_cost_decimals(SUM((NVL(item_qty,0)  - NVL(b.phy_inv_start_Qty,0))*st_display_unit_cost(a.item_code,sysdate,'CURRENT_STOCK')),'N')var_val ,NVL(b.phy_inv_start_qty,0) comp_qty,(NVL(item_qty,0)) phy_stk_qty  FROM ST_ITEM_BATCH b, ST_PHY_INV_DTL A, ST_ITEM_STORE c WHERE A.item_code=b.item_code (+)   AND A.store_code=b.store_code (+) AND A.phy_inv_id = b.phy_inv_id(+)   AND A.batch_id = b.batch_id (+) AND   A.expiry_date_or_receipt_date = b.expiry_date_or_receipt_date(+)   AND  A.bin_location_code=b.bin_location_code (+) AND  A.item_code=c.item_code AND A.store_code=c.store_code(+) AND  A.phy_inv_id=? AND A.store_code=?  AND  A.item_code=?  AND  (NVL(item_qty,0) - NVL(b.phy_inv_start_Qty,0))<>0  GROUP BY  A.store_code  , A.item_code,b.phy_inv_start_qty,item_qty ");


		hashmapQuery.put("SQL_ST_POST_VARIANCE_UPDATE_PARAM", getStRepositoryValue("SQL_ST_POST_VARIANCE_UPDATE_PARAM"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_DTL_DELETE", getStRepositoryValue("SQL_ST_POST_VARIANCE_DTL_DELETE"));
		hashmapQuery.put("SQL_ST_POST_VARIANCE_HDR_DELETE", getStRepositoryValue("SQL_ST_POST_VARIANCE_HDR_DELETE"));
		hashmapQuery.put("SQL_ST_POSTVARIANCE_ITEM_QTY", getStRepositoryValue("SQL_ST_POSTVARIANCE_ITEM_QTY"));
		hashmapQuery.put("SQL_ST_ITEM_SELECT_SINGLE", getStRepositoryValue("SQL_ST_ITEM_SELECT_SINGLE"));
		hashmapQuery.put("SQL_ST_ITEM_STORE_UPDATE_FOR_POST_VARIANCE_2", getStRepositoryValue("SQL_ST_ITEM_STORE_UPDATE_FOR_POST_VARIANCE_2"));

		hashmapQuery.put("SQL_ST_ITEM_STORE_UPDATE_FOR_POST_VARIANCE", getStRepositoryValue("SQL_ST_ITEM_STORE_UPDATE_FOR_POST_VARIANCE"));
		//hashmapQuery.put("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE", getStRepositoryValue("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE"));
		
		//hashmapQuery.put("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE","UPDATE MM_ITEM SET unit_cost = ROUND((SELECT NVL(SUM(item_value),0)/DECODE(NVL(SUM(qty_on_hand),0),0,1,SUM(qty_on_hand)) FROM ST_ITEM_STORE WHERE item_code =?),3) ,modified_by_id=?, modified_date=SYSDATE, modified_at_ws_no=?, modified_facility_id=?   WHERE item_code=?");
		/**
		 * @Name - Priya
		 * @Date - 08/06/2010
		 * @Inc# - 
		 * @Desc -    To round up the Unit Cost with the function 'st_get_cost_decimals' the above query is modified 
		 */
		//hashmapQuery.put("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE","UPDATE MM_ITEM SET unit_cost = st_get_cost_decimals((SELECT NVL(SUM(item_value),0)/DECODE(NVL(SUM(qty_on_hand),0),0,1,SUM(qty_on_hand)) FROM ST_ITEM_STORE WHERE item_code =?),'N') ,modified_by_id=?, modified_date=SYSDATE, modified_at_ws_no=?, modified_facility_id=?   WHERE item_code=?");//commented for MMS-ICN-00110

		hashmapQuery.put("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE","UPDATE MM_ITEM SET unit_cost =  ? ,modified_by_id=?, modified_date=SYSDATE, modified_at_ws_no=?, modified_facility_id=?   WHERE item_code=?");//modified for MMS-ICN-00110
		hashmapQuery.put("SQL_ST_ITEM_STORE_UPDATE_QTY_ON_HAND", getStRepositoryValue("SQL_ST_ITEM_STORE_UPDATE_QTY_ON_HAND"));
		hashmapQuery.put("SQL_ST_ITEM_BATCH_UPDATE_PHY_INV", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE_PHY_INV"));
		hashmapQuery.put("SQL_ST_ITEM_BATCH_SELECT_QTY_ON_HAND", getStRepositoryValue("SQL_ST_ITEM_BATCH_SELECT_QTY_ON_HAND"));
		hashmapQuery.put("SQL_ST_ITEM_STORE_UPDATE_QTY_ON_HAND_1", getStRepositoryValue("SQL_ST_ITEM_STORE_UPDATE_QTY_ON_HAND_1"));//Added for  IN072061 
		hashmapQuery.put("SQL_ST_ITEM_BATCH_UPDATE_PHY_INV_1", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE_PHY_INV_1"));//Added for  IN072061 
		hashmapQuery.put("LANGUAGE_ID",getLanguageId());

        hashmap.put("data", arraylist);
        hashmap.put("properties", properties);

      
      
       /* eST.PostVariance.PostVarianceRemote postvarianceremote = null;
       
            InitialContext initialcontext = new InitialContext();
            Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_POST_VARIANCE"));
            PostVarianceHome postvariancehome = (PostVarianceHome)PortableRemoteObject.narrow(obj1, eST.PostVariance.PostVarianceHome.class);
            postvarianceremote = postvariancehome.create();
            hashmap = postvarianceremote.insert(hashmap, hashmapQuery);*/

			// PostVarianceHome PostVariancehome = null;
          //  PostVarianceRemote PostVarianceremote = null;
			
           /* InitialContext initialcontext = new InitialContext();
            Object obj = initialcontext.lookup(getStRepositoryValue("JNDI_POST_VARIANCE"));
            PostVariancehome = (PostVarianceHome)PortableRemoteObject.narrow(obj, PostVarianceHome.class);
            PostVarianceremote = PostVariancehome.create();
			hashmap = PostVarianceremote.insert(hashmap, hashmapQuery);*/
			//hashmap = new eST.PostVariance1.PostVarianceManager().insert(hashmap, hashmapQuery);


			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_POST_VARIANCE"),PostVarianceHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmapQuery;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmapQuery.getClass();

			 hashmap = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if(((Boolean)hashmap.get("result")).booleanValue())
                hashmap.put("message", getSTMessage(getLanguageId(),(String) hashmap.get( "msgid" ),"ST") ) ;
            else
                hashmap.put("message", hashmap.get("msgid"));
        }
        catch(Exception exception1)
        {
            hashmap.put("message", exception1.getMessage());
            exception1.printStackTrace();
        }
      /*  finally
        {
            try
            {
  //      if(postvarianceremote != null)
    //                postvarianceremote.remove();
            }
            catch(Exception exception3)
            {
                hashmap.put("message", exception3.getMessage());
            }
        }*/
        return hashmap;
    }

  /*  public String getDiscrepancyReasons()
    {
        String s = null;
        ArrayList arraylist = getListOptionArrayList(getStRepositoryValue("SQL_SS_WRITE_OFF_REASON_SELECT_LIST"));
        s = getListOptionTag(arraylist, defaultWriteOffReasonCode);
        arraylist = null;
        return s;
    }*/

    public HashMap apply()
    {
        HashMap hashmap = null;
        try
        {
            hashmap = super.apply();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return hashmap;
    }

    private String trn_type;
    private String doc_type_code;
    private String doc_date;
    private String doc_no;
    private String bin_location_code;
    private String facility_id;
    private String tray_no;
    private String write_off_reason_code;
    private boolean isAutoNo;
    private String defaultWriteOffReasonCode;
    private String phy_inv_id;
    private String defaultDocType;
    private String defaultStoreCode;
}
