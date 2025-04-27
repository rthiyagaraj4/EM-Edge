/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO;

import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import ePO.Common.PoRepository;
import eCommon.Common.*;
import ePO.POCancelOrder.*;

public class PurchaseOrderCancelBean extends ePO.Common.PoTransaction implements Serializable {

	private String po_order_mode;
	private String master_type;
	private String purchase_type;
	private String po_no;
	private String doc_ref;
	private String doc_date;
	private String cancelled_remarks;
	private String entity_param;
	private java.util.ArrayList alItems;
	private java.util.ArrayList alCheckedItems;
	private java.util.HashMap hmRemarks;
	
	private String poClose;
	private String poCancel;

	public PurchaseOrderCancelBean() {
		alCheckedItems = new java.util.ArrayList();
		hmRemarks = new java.util.HashMap();
	}

	/*public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}
	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no() {
		 return doc_no;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = doc_ref;
	}

	public String getDoc_ref() {
		 return (doc_ref==null)?"":doc_ref;
	}

	public void setItem_class_code(String item_class_code) {
		 this.item_class_code = item_class_code;
	}

	public String getItem_class_code() {
		 return this.item_class_code;
	}
  
	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public String getDoc_date() {
		 return this.doc_date;
	}

	public void setRequest_by_store(String request_by_store) {
		 this.request_by_store = request_by_store;
	}

	public String getRequest_by_store() {
		 return request_by_store;
	}

	public void setRequest_on_store(String request_on_store) {
		 this.request_on_store = request_on_store;
	}

	public String getRequest_on_store() {
		 return request_on_store;
	}
	
	public void setUser_id(String user_id) {
		 this.user_id = user_id;
	}
    public String getUser_id()
	{
		return user_id;
	}
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}

	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("PRQ",defaultDocType);
	}
	*/
	
	public void setCancelled_remarks(String cancelled_remarks) {
		 this.cancelled_remarks = cancelled_remarks;
	}
	
	public String getCancelled_remarks() {
		 return this.cancelled_remarks;
	}
	
	public java.util.ArrayList getAlItems() {
		return this.alItems;
	}

	public void setEntity_param(String entity_param) {
		this.entity_param = entity_param;
	}

	public String getEntity_param() {
		return this.entity_param;
	}
	
	 public String getRequestFromPurchaseUnit() {
		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST"),sqlParam),""); 	
	   }
	
	public String getRequestFromPurchaseUnit(String pur_unit) {
		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST"),sqlParam),pur_unit); 
		}
	
	public String getRequestToSupp() {
		ArrayList alParameters = new ArrayList();
		alParameters.add(getLanguageId());
		return getListValues(ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SUPPLIER_LIST"), alParameters,"");
		}
		
	public String getRequestToSupp(String supp_code) {					
		ArrayList alParameters = new ArrayList();
		alParameters.add(getLanguageId());
		return getListValues(ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SUPPLIER_LIST"), alParameters,supp_code);
		}	
		
		public String getPurchaseUnitList() {
		ArrayList Param = new ArrayList();		
		Param.add(getLoginById());
		Param.add(getLoginFacilityId());
		//return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PUR_UNIT_LIST"),Param),""); 
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_ORD_CANCEL"),Param),"");  // Added by Padmapriya INC # 34817 on 07/09/2012 
		
	    }
		 
	    public void setMasterType(String master_type) {
		 this.master_type = master_type;
	    }
	
	   public String getMasterType() {
        return master_type;
        }
	
	    public void setPurchase_type(String purchase_type) {
		 this.purchase_type = checkForNull(purchase_type);
	}

	  public String getPurchase_type() {
		 return purchase_type;
	   }
	   
	public void setPoCancel(String poCancel) {
		this.poCancel = checkForNull(poCancel,"N");
	}

	public String getPoCancel() {
		return poCancel;
	}
	public void setPoClose(String poClose) {
		this.poClose = checkForNull(poClose,"N");
	}

	public String getPoClose() {
		return poClose;
	}   
	
	public String getPurchase_type_List() {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add("PORDER");
		   arr_language.add(getLanguageId());    // Added By Padmapriya INC # 34817 on 07/09/2012
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),getPurchase_type()); 
          }
	
	public String getPurchase_type_List(String pur_type) {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add("PORDER");
		   arr_language.add(getLanguageId());  // Added By Padmapriya INC # 34817 on 07/09/2012
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),pur_type); 
    }
	
	public ArrayList getCheckItems(){
	return alCheckedItems;
    }
	
	public void updateRemarks(java.util.Hashtable remarksData) {
	
		StringBuffer key = new StringBuffer();
		String po_order_mode = (String) remarksData.get("po_order_mode");
		po_order_mode = po_order_mode.trim();
		String po_no = (String) remarksData.get("po_no");
		po_no=po_no.trim();
		key.append(po_order_mode);
		key.append('-');
		key.append(po_no);
		
	  hmRemarks.put(key.toString(),new PurchaseOrderCancelRemarksBean(po_order_mode, po_no, (String)remarksData.get("remarks"),   (String)remarksData.get("remarks_code_1")));
	  setCancelled_remarks( (String)remarksData.get("remarks") );
			
	}
	
	public String getRemarks(String key) {
		if (hmRemarks.containsKey(key)) {
			PurchaseOrderCancelRemarksBean poCancelRemarksBean = (PurchaseOrderCancelRemarksBean) hmRemarks.get(key);
			return poCancelRemarksBean.getRemarks();
		}
		return "";
	}
	
	public void clearAllRemarks() {
		
		alCheckedItems.clear();
		hmRemarks.clear();
		
	}
	
	public void setRemarks(String key) {
		java.util.ArrayList alRemoveKey = new java.util.ArrayList ();
		alRemoveKey.add(key);
		alCheckedItems.removeAll(alRemoveKey);
	/*	if (hmRemarks.containsKey(key)) {
			PurchaseOrderCancelRemarksBean poCancelRemarksBean = (PurchaseOrderCancelRemarksBean) hmRemarks.get(key);
			poCancelRemarksBean.setRemarks("");
		}
	*/	
		hmRemarks.remove(key);
		
	}
	
	public String getRemarks_code(String key) { 
		if (hmRemarks.containsKey(key)) {
			PurchaseOrderCancelRemarksBean poCancelRemarksBean = (PurchaseOrderCancelRemarksBean) hmRemarks.get(key);
			return poCancelRemarksBean.getRemarks_code();
		}
		return "";
	}
	
	
	public HashMap getUomDesc(String uom_code){
		HashMap hmRecord = null;
		
		try{
			ArrayList chkParameters=new ArrayList();
			chkParameters.add(uom_code);
			chkParameters.add(getLanguageId());
			hmRecord		=	fetchRecord(getPoRepositoryValue("SQL_PO_UOM_DESC_SELECT"),chkParameters);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return hmRecord;
	}

	public void updateSelectedValues(java.util.Hashtable selectedValues) {
		
		setPoCancel((String)selectedValues.get("poCancel"));
		setPoClose((String)selectedValues.get("poClose"));
		int total = Integer.parseInt((String)selectedValues.get("total_check_boxes"));
		String checkedIndices = (String)selectedValues.get("checkedIndices");
		String key = null;
		java.util.ArrayList alRemoveKey = new java.util.ArrayList (total);
		for (int i=0;i<total;i++) {
			alRemoveKey.add((String)selectedValues.get("doc_"+i));
		}		
		alCheckedItems.removeAll(alRemoveKey);
		alRemoveKey = null;
		java.util.StringTokenizer checked = new  java.util.StringTokenizer(checkedIndices,",");
		java.util.ArrayList alAddKey  = new java.util.ArrayList ();
		while (checked.hasMoreElements()) {
			key = (String)checked.nextElement();
			if (key != null && key.trim() != "") {
				alAddKey.add((String) selectedValues.get("doc_"+key.trim()));
			}
		}
		alCheckedItems.addAll(alAddKey);
	}

	public void initialize() {
		super.initialize();
		po_order_mode = "";
		po_no = "";
		doc_ref = "";
		doc_date = "";
		poCancel = "";
		poClose = "";
		alItems = new ArrayList();
		alCheckedItems = new ArrayList();
		hmRemarks = new HashMap();
	}

	public void clear() {
		super.clear();
		po_order_mode = null;
		po_no = null;
		doc_ref = null;
		doc_date = null;
		poCancel = null;
		poClose = null;
		alItems = null;
		alCheckedItems = null;
		hmRemarks = null;
	}

	public HashMap validate()
	{

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");

		PurchaseOrderCancelRemarksBean remarksBean;
		for (int i=0;i<alCheckedItems.size(); i++){
			String key = (String) alCheckedItems.get(i);
			String remarks="";
			if (key == null || key.trim() == "") {
				continue;
			}
			if(hmRemarks.get(key) != null){
				remarksBean = (PurchaseOrderCancelRemarksBean) hmRemarks.get(key);
				remarks = remarksBean.getRemarks();
				remarks = remarks.substring(remarks.lastIndexOf("~")+1) ;
			}else{
         		//hmRemarks.put(key,"Cancelled as per request");
				resultMap.put("message","REMARKS_NOT_BLANK");
				return resultMap;
			}

			resultMap.put("result", new Boolean(true));
		}

		return resultMap;
	}


	public void setAll(Hashtable hashValues) {
		updateSelectedValues(hashValues);
	}

	public void loadData(String po_order_mode, String po_no,String facility_id) {
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		PurchaseOrderCancelDetailBean POCancelDetailBean;
		alItems = new java.util.ArrayList ();
		try {
            connection = getConnection();
             
		   //pstmt = connection.prepareStatement("SELECT po_no, po_srl_no, dtl.item_code, itm.short_desc item_desc,po_qty req_gen_uom_qty, po_uom  FROM po_order_fcy_dtl dtl, mm_item_lang_vw itm WHERE  po_no LIKE ? AND dtl.item_code = itm.item_code AND itm.language_id = ? ORDER BY po_srl_no");
			pstmt = connection.prepareStatement("SELECT po_no, po_srl_no, dtl.item_code, itm.short_desc item_desc,po_qty , po_uom ,dtl.PO_LINE_STATUS,dtl.DELIVERED_QTY do_qty, nvl((po_qty - dtl.DELIVERED_QTY),'0') pending_qty,GRN_QTY received_qty,GRN_UOM received_uom  FROM po_order_fcy_dtl dtl, mm_item_lang_vw itm WHERE  po_no LIKE ? AND dtl.item_code = itm.item_code AND itm.language_id = ? ORDER BY po_srl_no");
			 
            pstmt.setString(1, po_no);
            pstmt.setString(2, getLanguageId());
			resultSet = pstmt.executeQuery();

	        while (resultSet != null && resultSet.next()) {
				POCancelDetailBean = new PurchaseOrderCancelDetailBean(resultSet);
				alItems.add(POCancelDetailBean);
				
			}	   
        } 
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
            try {
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es) {
				es.printStackTrace();
            }
        }
	}


	public java.util.HashMap modify() {
	
		HashMap hmResult	=	new HashMap();
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

		try {
            connection = getConnection();
			HashMap hmTableData = new HashMap();
			HashMap hmSQLMap	= new HashMap();
			ArrayList	alModifyData = new ArrayList();
			ArrayList  datadtl      =   new ArrayList(); 
			ArrayList  alReqDtlUpd  =   new ArrayList(); 
			ArrayList  alMMUpdate   =   new ArrayList(); 
	      
			String key = null;
			Properties properties = getProperties();
			hmTableData.put("properties",properties);

			hmResult.put("result", new Boolean(false)) ;
			hmResult.put("message", "Initial Message") ;

			ArrayList alCheckedDocNumbers = new ArrayList();
			for (int i=0;i<alCheckedItems.size(); i++) 
			{
				key = (String) alCheckedItems.get(i);
				if (key == null || key.trim() == "") 
				  continue;
				
				StringTokenizer st = new StringTokenizer(key,"-");
				String pomode = st.nextToken().trim();
				String poNOValue = st.nextToken();
				String  poNO = "";
				
				if(pomode != null && !(pomode.equals(""))) 
				{
		             pomode = pomode;
				}
				
				if(poNOValue != null && !(poNOValue.equals(""))) 
				{
		             poNO = poNOValue;
				}

				String remarks = "";
				if( ( hmRemarks.get(key) != null ) &&  (hmRemarks.get(key) != "")){
                    remarks = ((Object)hmRemarks.get(key)).toString();
					remarks = remarks.substring(remarks.lastIndexOf("~")+1) ;	
				}else{
				//	remarks = "Cancelled as per request";
					hmResult.put("message","REMARKS_NOT_BLANK");
					return hmResult;
				}

				ArrayList alModifyRecord = new java.util.ArrayList();
				 
				alModifyRecord.add(remarks);
				if(getPoCancel().equals("Y")) {
					alModifyRecord.add("CA");
				}else if(getPoClose().equals("Y")){	
					alModifyRecord.add("CL");
				}
				alModifyRecord.add(login_by_id);
				alModifyRecord.add(login_at_ws_no);
				alModifyRecord.add(login_facility_id);
				alModifyRecord.add(""+poNO);
				alCheckedDocNumbers.add(""+poNO);	
                System.out.println("alModifyRecord===>" +alModifyRecord);				

				alModifyData.add(alModifyRecord);
				
				pstmt = connection.prepareStatement("SELECT DTL.REQ_NO , DTL.ITEM_CODE ,DTL.PO_QTY  FROM  PO_ORDER_HDR HDR ,  PO_ORDER_FCY_DTL DTL WHERE  HDR.PO_NO = DTL.PO_NO AND  HDR.PUR_UNIT_CODE = DTL.PUR_UNIT_CODE AND  HDR.PO_NO = ?");
				 
				 pstmt.setString(1, poNO);
                 resultSet = pstmt.executeQuery();
                 while(resultSet != null && resultSet.next()) {
                    String req_no = resultSet.getString("REQ_NO");
					String item_code = resultSet.getString("ITEM_CODE");
					String po_qty = resultSet.getString("PO_QTY");
					 
					 
					  ArrayList alReqDtl = new ArrayList();
					  ArrayList almmupdate = new ArrayList();	
                    				 
					  alReqDtl.add(po_qty);
					  alReqDtl.add(login_by_id);
					  alReqDtl.add(login_at_ws_no);
					  alReqDtl.add(login_facility_id);
					  alReqDtl.add(checkForNull(req_no));
					  alReqDtl.add(login_facility_id);
					  alReqDtl.add(item_code);
					  
					  alReqDtlUpd.add(alReqDtl);
					  System.out.println("alReqDtlUpd===>" +alReqDtlUpd);
					  
					 almmupdate.add(po_qty);
					 almmupdate.add(login_by_id);
					 almmupdate.add(login_at_ws_no);
					 almmupdate.add(login_facility_id);
					 almmupdate.add(item_code);
					 alMMUpdate.add(almmupdate);
					 System.out.println("alMMUpdate===>" +alMMUpdate);
				}	 	  

				//28/06/12
				 pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_QTY_QUERY"));
                 pstmt.setString(1, poNO);
                 
				 resultSet = pstmt.executeQuery();
                  while (resultSet != null && resultSet.next()) {
				    String req_store_code = resultSet.getString("REQ_STORE_CODE");
					String req_qty = resultSet.getString("PO_QTY");
                    String itemcode = resultSet.getString("ITEM_CODE"); 
					String pur_unit_code = resultSet.getString("PUR_UNIT_CODE");
			        					 
					ArrayList dtlupd = new ArrayList();		
				    dtlupd.add(req_qty);
					dtlupd.add(login_by_id);
					dtlupd.add(login_at_ws_no);
					dtlupd.add(login_facility_id);
					dtlupd.add(pur_unit_code);
					dtlupd.add(poNO);
					dtlupd.add(login_facility_id);
					dtlupd.add(checkForNull(req_store_code ,"*A"));
					dtlupd.add(itemcode);
					
			        datadtl.add(dtlupd);
					

			}
			//ends here 
				
		     closeResultSet(resultSet);
             closeStatement(pstmt);
			}
			

			hmTableData.put("HeaderUpdateData",alModifyData);
			hmSQLMap.put("UpdateHDRSQL", "UPDATE PO_ORDER_HDR SET PO_CANCEL_REMARKS =    ? , PO_STATUS =    ?, MODIFIED_BY_ID =    ? , MODIFIED_DATE =    SYSDATE    , MODIFIED_AT_WS_NO    = ?    , MODIFIED_FACILITY_ID = ?	WHERE   PO_NO = ?");
			
		/*	hmTableData.put("DetailUpdateData",datadtl);
			hmSQLMap.put("UpdateDTLSQL","UPDATE po_order_fcy_dtl SET PO_QTY =    PO_QTY - NVL(?,0) , modified_by_id =    ? , modified_date =    SYSDATE    , modified_at_ws_no    = ?    , modified_facility_id = ?	WHERE pur_unit_code = ? AND po_no = ?  AND req_facility_id = ? AND req_store_code = ? AND item_code = ?");
		*/	
			
		//	hmTableData.put("AlReqDtlUpd",alReqDtlUpd); 
		//	hmSQLMap.put("AlReqDtlUpdSQL", "UPDATE po_request_detail SET PO_QTY = PO_QTY - NVL(?,0), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE REQ_NO = ? AND FACILITY_ID = ? AND ITEM_CODE = ?");

			hmTableData.put("AlMmItemUpd",alMMUpdate);
			hmSQLMap.put("ALMMSQL", "UPDATE MM_ITEM SET QTY_ON_ORDER = QTY_ON_ORDER - NVL(?,0), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE ITEM_CODE = ?");
			
			 
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getPoRepositoryValue("JNDI_PO_CANCEL_ORDER"),ePO.POCancelOrder.POCancelOrderHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
 			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			hmResult.put("message",getPOMessage(getLanguageId(),(String) hmResult.get( "message" ),"PO") ) ;

		
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}	  

		finally {
            try {
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es) {
				es.printStackTrace();
            }
        }
		return hmResult;
	}

	public java.util.ArrayList getOnStores(String req_by_store) throws Exception {
			String chkParameters[] = {getLanguageId(),checkForNull(req_by_store)};
			ArrayList result = new ArrayList();
				
			result = fetchRecords("SELECT MM.PO_DEPT_CODE PARENT_STORE_CODE, AM.SHORT_DESC FROM MM_STORE_LANG_VW MM, AM_DEPT_LANG_VW AM WHERE  MM.LANGUAGE_ID = AM.LANGUAGE_ID   AND MM.PO_DEPT_CODE =  AM.DEPT_CODE  AND MM.LANGUAGE_ID = ? AND  MM.STORE_CODE = ? ORDER BY 2, 1",chkParameters);
			return result;
	}

	//Added By Sakti getting GR_QTY,DO_QTY not to allow close PO if delv_qty != grn_qty inc#40671
	/*public boolean getPoDoQty(String po_no) throws Exception {
        try{
			String grn_qty  = "";
			String delv_qty = "";
			boolean exist = false;
			ArrayList alRecord = new ArrayList();
     		
			alRecord = fetchRecords("SELECT DISTINCT NVL (po.grn_qty, 0) grn_qty, NVL (po.delivered_qty, 0) delv_qty, delv.PO_NO, delv.PO_SRL_NO,DELV.ITEM_CODE  FROM po_order_fcy_dtl po, po_order_delv_sch delv  WHERE PO.PO_NO = DELV.PO_NO  AND PO.PO_SRL_NO = DELV.PO_SRL_NO  AND PO.ITEM_CODE= DELV.ITEM_CODE AND PO.po_no = ? AND delv.do_no IS NOT NULL", po_no);
			if(alRecord.size()>0) {
			for(int i=0;i<alRecord.size();i++){
			HashMap alRecords = (HashMap)alRecord.get(i);
			grn_qty = (String)alRecords.get("GRN_QTY");
			delv_qty = (String)alRecords.get("DELV_QTY");

			if(Integer.parseInt(grn_qty) != Integer.parseInt(delv_qty)) {
				exist = true;
				break;
			} 
		}
	}
            return exist;
        }
        catch(Exception exception){
            exception.printStackTrace();
			throw exception;
        }
    }*/
	//Added ends 

public HashMap getPoDoQty(String po_no) throws Exception {
        try{
			String grn_qty  = "";
			String delv_qty = "";
			String do_blocked_qty = "";
			//boolean exist = false;
			 HashMap hmResult = new HashMap();
			 HashMap alRecords = new HashMap();
			//ArrayList alRecord = new ArrayList();
     		
			alRecords = fetchRecord("SELECT DISTINCT SUM(NVL (po.grn_qty, 0)) grn_qty, SUM(NVL (po.delivered_qty, 0)) delv_qty, SUM(NVL(DELV.DO_BLOCKED_QTY,0)) DO_BLOCKED_QTY  FROM po_order_fcy_dtl po, po_order_delv_sch delv  WHERE PO.PO_NO = DELV.PO_NO  AND PO.PO_SRL_NO = DELV.PO_SRL_NO  AND PO.ITEM_CODE= DELV.ITEM_CODE AND PO.po_no = ? AND delv.do_no IS NOT NULL", po_no);

			int grn_unf_count=Integer.parseInt((String)fetchRecord("SELECT  count(*) count  FROM PO_ORDER_UNF_GRN WHERE po_no = ? ",new String[]{po_no}).get("COUNT"));

			grn_qty = (String)alRecords.get("GRN_QTY");
			delv_qty = (String)alRecords.get("DELV_QTY");
			do_blocked_qty = (String)alRecords.get("DO_BLOCKED_QTY");
			
			System.out.println("grn_qty"+grn_qty+"delv_qty"+delv_qty+"do_blocked_qty"+do_blocked_qty);
			if(Integer.parseInt(checkForNull(do_blocked_qty,"0")) > 0){
				hmResult.put("message","blocked qty exists");
			}else
			//if(Integer.parseInt(grn_qty) != Integer.parseInt(delv_qty)) {
				if(Integer.parseInt(checkForNull(grn_qty,"0")) < Integer.parseInt(checkForNull(delv_qty,"0"))) {
				hmResult.put("message","grn_qty and delv_qty not same");
				
				} else	
					if(grn_unf_count > 0){
					hmResult.put("message","grn_unf_qty");
					}

	      return hmResult;
 }catch(Exception exception){
            exception.printStackTrace();
			throw exception;
        }
    }
}
