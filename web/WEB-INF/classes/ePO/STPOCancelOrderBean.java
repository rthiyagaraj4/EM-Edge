/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------
06/04/2017				IN063878				Badmavathi B					        					 Unused variables
-------------------------------------------------------------------------------------------------------------------------------
*/
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

public class STPOCancelOrderBean extends ePO.Common.PoTransaction implements Serializable {

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

	public STPOCancelOrderBean() {
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
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PUR_UNIT_LIST"))); 
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

	
	public String getPurchase_type_List() {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add("PORDER");
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),getPurchase_type()); 
          }
	
	public String getPurchase_type_List(String pur_type) {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add("PORDER");
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),pur_type); 
    }
	

	public ArrayList getCheckItems(){
	return alCheckedItems;
    }
	
	public void updateRemarks(java.util.Hashtable remarksData) {
	System.out.println("remarksData====>" +remarksData);
		StringBuffer key = new StringBuffer();
		String po_order_mode = (String) remarksData.get("po_order_mode");
		po_order_mode = po_order_mode.trim();
		String po_no = (String) remarksData.get("po_no");
		po_no=po_no.trim();
		key.append(po_order_mode);
		key.append('-');
		key.append(po_no);
		
	  hmRemarks.put(key.toString(),new STPOCancelOrderRemarksBean(po_order_mode, po_no, (String)remarksData.get("remarks")));
	  setCancelled_remarks( (String)remarksData.get("remarks") );
			System.out.println("hmRemarks====>" +hmRemarks);
	}
	
	public String getRemarks(String key) {
		if (hmRemarks.containsKey(key)) {
			STPOCancelOrderRemarksBean stpoCancelOrderRemarksBean = (STPOCancelOrderRemarksBean) hmRemarks.get(key);
			return stpoCancelOrderRemarksBean.getRemarks();
		}
		return "";
	}

	public void updateSelectedValues(java.util.Hashtable selectedValues) {
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
		alItems = null;
		alCheckedItems = null;
		hmRemarks = null;
	}

	public HashMap validate()
	{

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");

		STPOCancelOrderRemarksBean remarksBean;
		for (int i=0;i<alCheckedItems.size(); i++){
			String key = (String) alCheckedItems.get(i);
			String remarks="";
			if (key == null || key.trim() == "") {
				continue;
			}
			if(hmRemarks.get(key) != null){
				remarksBean = (STPOCancelOrderRemarksBean) hmRemarks.get(key);
				remarks = remarksBean.getRemarks();
                remarks = remarks.substring(remarks.lastIndexOf("=")+1) ;
			}else{
         		hmRemarks.put(key,"Cancelled as per request");
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
		STPOCancelOrderDetailBean STpoCancelOrderDetailBean;
		alItems = new java.util.ArrayList ();
		try {
            connection = getConnection();
             
		   pstmt = connection.prepareStatement("SELECT po_no, po_srl_no, dtl.item_code, itm.short_desc item_desc,po_qty req_gen_uom_qty, po_uom  FROM po_order_fcy_dtl dtl, mm_item_lang_vw itm WHERE  po_no LIKE ? AND dtl.item_code = itm.item_code AND itm.language_id = ? ORDER BY po_srl_no");

			 
            pstmt.setString(1, po_no);
            pstmt.setString(2, getLanguageId());
			//pstmt.setString(3, facility_id);
            resultSet = pstmt.executeQuery();

	        while (resultSet != null && resultSet.next()) {
				STpoCancelOrderDetailBean = new STPOCancelOrderDetailBean(resultSet);
				alItems.add(STpoCancelOrderDetailBean);
				System.out.println("alItems=====391====>" +alItems);
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
	System.out.println("modify");
		HashMap hmResult	=	new HashMap();
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

		try {
            connection = getConnection();
			HashMap hmTableData = new HashMap();
			HashMap hmSQLMap	= new HashMap();
			ArrayList	alModifyData = new ArrayList();
			//ArrayList alRevertBackData = new ArrayList(); Commented for unused variables IN063878
			//ArrayList alPORevertBackData = new ArrayList(); Commented for unused variables IN063878
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
				//String docTypeCode = st.nextToken().trim();
				String poNOValue = st.nextToken();
				//int poNO = 0;
				String  poNO = "";

				if(poNOValue != null && !(poNOValue.equals(""))) 
				{
					//poNO = Integer.parseInt(poNOValue);
		             poNO = poNOValue;

				}

				String remarks = "";
				//System.out.println("hmRemarks===404=>" +hmRemarks);
				if( ( hmRemarks.get(key) != null ) &&  (hmRemarks.get(key) != "")){
                    remarks = ((Object)hmRemarks.get(key)).toString();
					remarks = remarks.substring(remarks.lastIndexOf("=")+1) ;	
				}else{
					remarks = "Cancelled as per request";
				}

				ArrayList alModifyRecord = new java.util.ArrayList();
				 
				alModifyRecord.add(remarks);
				alModifyRecord.add("CA");
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

			/*	ArrayList alRecordToRevertBack = new ArrayList();
				alRecordToRevertBack.add(login_facility_id);
				alRecordToRevertBack.add(docTypeCode);
				alRecordToRevertBack.add(poNO);
				String status_srl_no = "1";
				try{
					status_srl_no=(String)fetchRecord("select ST_STATUS_SRL_NO.nextval count  from dual").get("COUNT");
				}catch (Exception e){
					e.printStackTrace();
				}
				alRecordToRevertBack.add(status_srl_no);
				alRecordToRevertBack.add("X");
				alRecordToRevertBack.add(login_by_id);
				alRecordToRevertBack.add(remarks);
				alRecordToRevertBack.add(login_by_id);
				alRecordToRevertBack.add(login_at_ws_no);
				alRecordToRevertBack.add(login_facility_id);
				alRecordToRevertBack.add(login_by_id);
				alRecordToRevertBack.add(login_at_ws_no);
				alRecordToRevertBack.add(login_facility_id);
				alRevertBackData.add(alRecordToRevertBack);
				 System.out.println("alRevertBackData===>" +alRevertBackData);		*/
			
			/* Forming the data needed to revert back the pending_item_qty in st_item_store */
			  // System.out.println("alRevertBackData==1=>" +poNO);	
			   //System.out.println("alRevertBackData=2==>" +docTypeCode);	
			   //System.out.println("alRevertBackData==3=>" +login_facility_id);	

			  /* pstmt = connection.prepareStatement("SELECT DTL.REQ_STORE_CODE ,DTL.PO_QTY,DTL.ITEM_CODE FROM po_order_hdr  HDR , po_order_fcy_dtl DTL WHERE HDR.PO_NO = DTL.PO_NO AND HDR.PO_NO = ?");
				pstmt.setString(1, poNO);
				System.out.println("poNO===527===>" +poNO);
	            //pstmt.setString(2, docTypeCode);
	            //pstmt.setString(3, login_facility_id);
				
	             resultSet = pstmt.executeQuery();
				 System.out.println("resultSet==1=>" +resultSet);	
				 
				    while(resultSet != null && resultSet.next()) {
					String reqByStoreCode = resultSet.getString("REQ_STORE_CODE");
					String pendingItemQty = resultSet.getString("PO_QTY");
					String itemCode = resultSet.getString("ITEM_CODE");
					
					 System.out.println("reqByStoreCode==1=>" +reqByStoreCode);	
			         System.out.println("pendingItemQty=2==>" +pendingItemQty);	
			          System.out.println("itemCode==3=>" +itemCode);	
					

					ArrayList alPORecordToRevertBack = new ArrayList();		
					alPORecordToRevertBack.add(pendingItemQty);
					alPORecordToRevertBack.add(login_by_id);
					alPORecordToRevertBack.add(login_at_ws_no);
					alPORecordToRevertBack.add(login_facility_id);
					alPORecordToRevertBack.add(checkForNull(reqByStoreCode));
					alPORecordToRevertBack.add(itemCode);

					alPORevertBackData.add(alPORecordToRevertBack);
					System.out.println("alPORevertBackData===>" +alPORevertBackData);	
				}*/
				//28/06/12
				 pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_QTY_QUERY"));
                 pstmt.setString(1, poNO);
               // pstmt.setString(2, login_facility_id);
			   
			     
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
					System.out.println("datadtl===574===>" +datadtl);

			}
			//ends here 
				
		     closeResultSet(resultSet);
             closeStatement(pstmt);
			}
			

			hmTableData.put("HeaderUpdateData",alModifyData);
			hmSQLMap.put("UpdateHDRSQL", "UPDATE PO_ORDER_HDR SET PO_CANCEL_REMARKS =    ? , PO_STATUS =    ?, MODIFIED_BY_ID =    ? , MODIFIED_DATE =    SYSDATE    , MODIFIED_AT_WS_NO    = ?    , MODIFIED_FACILITY_ID = ?	WHERE   PO_NO = ?");
			
			//hmTableData.put("RevertBackData",alRevertBackData);
			//hmSQLMap.put("RevertBackSQL", "INSERT INTO po_request_status (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, STATUS_SRL_NO, STATUS, STATUS_BY_ID, STATUS_DATE, STATUS_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");
			
			hmTableData.put("DetailUpdateData",datadtl);
			hmSQLMap.put("UpdateDTLSQL","UPDATE po_order_fcy_dtl SET PO_QTY =    PO_QTY - NVL(?,0) , modified_by_id =    ? , modified_date =    SYSDATE    , modified_at_ws_no    = ?    , modified_facility_id = ?	WHERE pur_unit_code = ? AND po_no = ?  AND req_facility_id = ? AND req_store_code = ? AND item_code = ?");
			
			//hmTableData.put("PORevertBackData",alPORevertBackData);
			//hmSQLMap.put("PORevertBackSQL", "UPDATE ST_ITEM_STORE SET PENDING_PO_REQ_QTY = PENDING_PO_REQ_QTY - NVL(?,0), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE STORE_CODE = ? AND ITEM_CODE = ?");
			
			hmTableData.put("AlReqDtlUpd",alReqDtlUpd);
			hmSQLMap.put("AlReqDtlUpdSQL", "UPDATE po_request_detail SET PO_QTY = PO_QTY - NVL(?,0), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE REQ_NO = ? AND FACILITY_ID = ?");

			hmTableData.put("AlMmItemUpd",alMMUpdate);
			hmSQLMap.put("ALMMSQL", "UPDATE MM_ITEM SET QTY_ON_ORDER = QTY_ON_ORDER - NVL(?,0), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE ITEM_CODE = ?");
			
			 /*
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/POCancelOrder",POCancelOrderHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			System.out.println("home====>" +home);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);*/ 

			hmResult.put("message",getPOMessage(getLanguageId(),(String) hmResult.get( "message" ),"ST") ) ;
			System.out.println("hmResult====>" +hmResult);

		
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
}
