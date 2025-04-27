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
12/03/2020				TFS id:-15756			Haribabu												Common-ICN-0027
--------------------------------------------------------------------------------------------------------------------------------------------
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
import eCommon.Common.*;
import ePO.POCancelOrder.*;

public class DeliveryOrderCancelBean extends ePO.Common.PoTransaction implements Serializable {

	private String po_order_mode;
	private String master_type;
	private String delivery_type;
	private String do_no;
	private String doc_ref;
	private String doc_date;
	private String cancelled_remarks;
	private String entity_param;
	private java.util.ArrayList alItems;
	private java.util.ArrayList alCheckedItems;
	private java.util.ArrayList alDtlItems;
	private java.util.HashMap hmRemarks;
	private HashMap hmTFRExpRecords		= new HashMap();
	private HashMap hmFinalTFRExpRecords= new HashMap();

	public DeliveryOrderCancelBean() {
		alCheckedItems = new java.util.ArrayList();
		alDtlItems = new java.util.ArrayList();
		hmRemarks = new java.util.HashMap();
	}

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
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_ORD_CANCEL"),Param),""); 
		
	    }
		 
	    public void setMasterType(String master_type) {
		 this.master_type = master_type;
	    }
	
	   public String getMasterType() {
        return master_type;
        }
	
	    public void setDelivery_type(String delivery_type) {
		 this.delivery_type = checkForNull(delivery_type);
	}

	  public String getDelivery_type() {
		 return delivery_type;
	   }

	
	public String getDelivery_type_List() {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add("DLVORD");
		   arr_language.add(getLanguageId());   
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),getDelivery_type()); 
          }
	
	public String getDelivery_type_List(String delv_type) {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add("DLVORD");
		   arr_language.add(getLanguageId());  
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),delv_type); 
    }
	

	public ArrayList getCheckItems(){
	return alCheckedItems;
    }
	
	public void updateRemarks(java.util.Hashtable remarksData) {
	System.out.println("remarksData====>" +remarksData);
		StringBuffer key = new StringBuffer();
		String do_date = (String) remarksData.get("do_date");
		do_date = do_date.trim();
		String do_no = (String) remarksData.get("do_no");
		do_no=do_no.trim();
	
			key.append(do_date);
			key.append('-');
			key.append(do_no);
			
		hmRemarks.put(key.toString(),new DeliveryOrderCancelRemarksBean(do_date, do_no, (String)remarksData.get("remarks"),   (String)remarksData.get("remarks_code_1")));
		setCancelled_remarks( (String)remarksData.get("remarks") );
		System.out.println("hmRemarks====>" +hmRemarks);
	}
	
	public String getRemarks(String key) {
		if (hmRemarks.containsKey(key)) {
			DeliveryOrderCancelRemarksBean poCancelRemarksBean = (DeliveryOrderCancelRemarksBean) hmRemarks.get(key);
			return poCancelRemarksBean.getRemarks();
		}
		return "";
	}
	
	public String getRemarks_code(String key) { 
		if (hmRemarks.containsKey(key)) {
			DeliveryOrderCancelRemarksBean poCancelRemarksBean = (DeliveryOrderCancelRemarksBean) hmRemarks.get(key);
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
			System.out.println("hmRecord in po cancel bean = "+hmRecord);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return hmRecord;
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

	
	public String getTFRExpRecords(String doc_no){
		if(hmTFRExpRecords.containsKey(doc_no))
			return (String)this.hmTFRExpRecords.get(doc_no);
		else
			return new String();
	}
	public void setTFRExpRecords(String doc_no,String exp_records){
	
		hmTFRExpRecords.put(doc_no,exp_records);
		alDtlItems.add(doc_no);
		hmFinalTFRExpRecords.put(doc_no,exp_records);
	}
	public HashMap getTFRExpRecords(){
		return hmTFRExpRecords;
	}
	
	public void removeTFTExpRecords(String doc_no){
		hmFinalTFRExpRecords.remove(doc_no);
	}
	
	public void initialize() {
		super.initialize();
		po_order_mode = "";
		do_no = "";
		doc_ref = "";
		doc_date = "";
		alItems = new ArrayList();
		alCheckedItems = new ArrayList();
		alDtlItems = new ArrayList();
		hmRemarks = new HashMap();
	}

	public void clear() {
		super.clear();
		po_order_mode = null;
		do_no = null;
		doc_ref = null;
		doc_date = null;
		alItems = null;
		alCheckedItems = null;
		alItems = null;
		hmRemarks = null;
		hmTFRExpRecords = new HashMap();
		hmFinalTFRExpRecords = new HashMap();
	}

	public HashMap validate()
	{

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");

		DeliveryOrderCancelRemarksBean remarksBean;
		for (int i=0;i<alCheckedItems.size(); i++){
			String key = (String) alCheckedItems.get(i);
			String remarks="";
			if (key == null || key.trim() == "") {
				continue;
			}
			if(hmRemarks.get(key) != null){
				remarksBean = (DeliveryOrderCancelRemarksBean) hmRemarks.get(key);
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

	public void loadData(String do_no,String facility_id) {
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		DeliveryOrderCancelDetailBean POCancelDetailBean;
		alItems = new java.util.ArrayList ();
		try {
            connection = getConnection();
             
		   pstmt = connection.prepareStatement("SELECT do_no, do_srl_no, dtl.item_code, itm.short_desc item_desc,do_qty , do_uom  FROM PO_DELV_ORD_DTL dtl, mm_item_lang_vw itm WHERE  do_no LIKE ? AND dtl.item_code = itm.item_code AND DO_LINE_STATUS = 'NR' AND itm.language_id = ? ORDER BY do_srl_no");

			 
            pstmt.setString(1, do_no);
            pstmt.setString(2, getLanguageId());
			resultSet = pstmt.executeQuery();

	        while (resultSet != null && resultSet.next()) {
				POCancelDetailBean = new DeliveryOrderCancelDetailBean(resultSet);
				alItems.add(POCancelDetailBean);
				System.out.println("alItems=====391====>" +alItems);
			//	hmTFRExpRecords.put(do_no+"~"+do_srl_no+"~"+item_code,alItems);
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
	//System.out.println("modify");
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
			String dtl_key = null;
			Properties properties = getProperties();
			hmTableData.put("properties",properties);

			hmResult.put("result", new Boolean(false)) ;
			hmResult.put("message", "Initial Message") ;
			
			
			System.out.println("hmTFRExpRecords.size in do cancel bean = "+hmTFRExpRecords.size());
			System.out.println("hmTFRExpRecords in do cancel bean = "+hmTFRExpRecords);
			System.out.println("alDtlItems.size in do cancel bean = "+alDtlItems.size());
			System.out.println("alDtlItems in do cancel bean = "+alDtlItems);
			
			if(alDtlItems.size() > 0){
				for (int i=0;i<alDtlItems.size(); i++) 	{
					dtl_key = (String) alDtlItems.get(i);
					System.out.println("dtl_key in do cancel bean = "+dtl_key);
					if (dtl_key == null || dtl_key.trim() == "") 
						continue;
					
					StringTokenizer st = new StringTokenizer(dtl_key,"-");
					String doNO = st.nextToken().trim();
					String doSrNo = st.nextToken();
					String itemCode = st.nextToken();
					
					String remarks = "";
					System.out.println("hmTFRExpRecords in alDtlItems = "+hmTFRExpRecords);
				if( ( hmTFRExpRecords.get(dtl_key) != null ) &&  (hmTFRExpRecords.get(dtl_key) != "")){
                    remarks = ((Object)hmTFRExpRecords.get(dtl_key)).toString();
					System.out.println("remarks in alDtlItems = "+remarks);
					remarks = remarks.substring(remarks.lastIndexOf("=")+1) ;	
					System.out.println("remarks1  in alDtlItems = "+remarks);
				}else{
					remarks = "Cancelled as per request";
				}
				
				String doLineStatus = "";
				
				pstmt = connection.prepareStatement("SELECT DTL.DO_QTY,DTL.ITEM_CODE,DTL.DO_LINE_STATUS ,DO_SRL_NO,TO_CHAR (DTL.SCH_DELV_DATE, 'dd/mm/yyyy') SCH_DELV_DATE,PO_NO,PO_SRL_NO FROM PO_DELV_ORD_HDR  HDR , PO_DELV_ORD_DTL DTL WHERE HDR.DO_NO = DTL.DO_NO AND HDR.DO_NO = ? and dtl.do_srl_no = ? and dtl.item_code = ?");
				
                 pstmt.setString(1, doNO);
				 pstmt.setString(2, doSrNo);
				 pstmt.setString(3, itemCode);
                 
				 resultSet = pstmt.executeQuery();
                  while (resultSet != null && resultSet.next()) {
				    String doSrlNo = resultSet.getString("DO_SRL_NO");
					String schDelvDate = resultSet.getString("SCH_DELV_DATE");
                    String itemcode = resultSet.getString("ITEM_CODE"); 
					doLineStatus = resultSet.getString("DO_LINE_STATUS");
					String poNo = resultSet.getString("PO_NO");
					String poSrlNo = resultSet.getString("PO_SRL_NO");
					
					ArrayList dtlupd = new ArrayList();	
					
					if(doLineStatus.equals("NR")){	
						dtlupd.add("CA");
						dtlupd.add(remarks);
					}else{
						dtlupd.add(doLineStatus);
						dtlupd.add("");
					}		
						
						dtlupd.add(login_by_id);
						dtlupd.add(login_at_ws_no);
						dtlupd.add(login_facility_id);
						dtlupd.add(doNO);
						dtlupd.add(itemcode);
						dtlupd.add(doSrlNo);
						dtlupd.add(poNo);
						dtlupd.add(schDelvDate);
						dtlupd.add(poSrlNo);
									
						datadtl.add(dtlupd);
						System.out.println("datadtl===415===>" +datadtl);
					}
					
					
				String doStatus =	(String)fetchRecord("SELECT DO_STATUS FROM PO_DELV_ORD_HDR WHERE DO_NO = ? and FACILITY_ID = ? ",new String[]{doNO,login_facility_id}).get("DO_STATUS");
				int cn = 0;
				closeResultSet(resultSet);//Added for TFS id:-15756
				closeStatement(pstmt);
				//pstmt.close();//Added for TFS id:-15756
				pstmt = connection.prepareStatement("SELECT DTL.DO_QTY,DTL.ITEM_CODE,DTL.DO_LINE_STATUS ,DO_SRL_NO,TO_CHAR (DTL.SCH_DELV_DATE, 'dd/mm/yyyy') SCH_DELV_DATE,PO_NO,PO_SRL_NO FROM PO_DELV_ORD_HDR  HDR , PO_DELV_ORD_DTL DTL WHERE HDR.DO_NO = DTL.DO_NO AND HDR.DO_NO = ? /*and dtl.do_srl_no = ? and dtl.item_code = ? */");
				
                 pstmt.setString(1, doNO);
                // pstmt.setString(2, doSrNo);
				 //pstmt.setString(3, itemCode);
				 
				 resultSet = pstmt.executeQuery();
                  while (resultSet != null && resultSet.next()) {
				    //String doSrlNo = resultSet.getString("DO_SRL_NO");
					//String schDelvDate = resultSet.getString("SCH_DELV_DATE");
                    //String itemcode = resultSet.getString("ITEM_CODE"); 
					doLineStatus = resultSet.getString("DO_LINE_STATUS");
					//String poNo = resultSet.getString("PO_NO");
					//String poSrlNo = resultSet.getString("PO_SRL_NO");
					cn++;
					
					if(doLineStatus.equals("NR")){
						doLineStatus = doStatus	;
					}else{
						doLineStatus = "";
						break;
					}
					
					}
					
				System.out.println("datadtl .size = "+datadtl.size());
				System.out.println("datadtl = "+datadtl);
				
				if(datadtl.size() < cn){
					doLineStatus = doStatus	;
					remarks = "";
				}else{
					doLineStatus = "CA";
					remarks = remarks ; 
				}
				ArrayList alModifyRecord = new java.util.ArrayList();
				 
				alModifyRecord.add(remarks);
				alModifyRecord.add(doLineStatus);
				alModifyRecord.add(login_by_id);
				alModifyRecord.add(login_at_ws_no);
				alModifyRecord.add(login_facility_id);
				alModifyRecord.add(""+doNO);
				System.out.println("alModifyRecord===>" +alModifyRecord);				

				alModifyData.add(alModifyRecord);
					
				
					
				}
			}
			
			
			System.out.println("alCheckedItems.size in do cancel bean = "+alCheckedItems.size());
			System.out.println("alCheckedItems in do cancel bean = "+alCheckedItems);
			
			if(alCheckedItems.size() > 0){
			
			ArrayList alCheckedDocNumbers = new ArrayList();
			for (int i=0;i<alCheckedItems.size(); i++) 
			{
				key = (String) alCheckedItems.get(i);
				System.out.println("Key in do cancel bean = "+key);
				if (key == null || key.trim() == "") 
				  continue;
				
				StringTokenizer st = new StringTokenizer(key,"-");
				String pomode = st.nextToken().trim();
				String poNOValue = st.nextToken();
				String  doNO = "";
				
				if(pomode != null && !(pomode.equals(""))) 
				{
		             pomode = pomode;
				}
				
				if(poNOValue != null && !(poNOValue.equals(""))) 
				{
		             doNO = poNOValue;
				}

				String remarks = "";
				System.out.println("hmRemarks = "+hmRemarks);
				if( ( hmRemarks.get(key) != null ) &&  (hmRemarks.get(key) != "")){
                    remarks = ((Object)hmRemarks.get(key)).toString();
					System.out.println("remarks = "+remarks);
					remarks = remarks.substring(remarks.lastIndexOf("=")+1) ;	
					System.out.println("remarks1 = "+remarks);
				}else{
					remarks = "Cancelled as per request";
				}
				
				String doStatus =	(String)fetchRecord("SELECT DO_STATUS FROM PO_DELV_ORD_HDR WHERE DO_NO = ? and FACILITY_ID = ? ",new String[]{doNO,login_facility_id}).get("DO_STATUS");
				String doLineStatus = "";
				closeResultSet(resultSet);//Added for TFS id:-15756
				closeStatement(pstmt);//Added for TFS id:-15756
				pstmt = connection.prepareStatement("SELECT DTL.DO_QTY,DTL.ITEM_CODE,DTL.DO_LINE_STATUS ,DO_SRL_NO,TO_CHAR (DTL.SCH_DELV_DATE, 'dd/mm/yyyy') SCH_DELV_DATE,PO_NO,PO_SRL_NO FROM PO_DELV_ORD_HDR  HDR , PO_DELV_ORD_DTL DTL WHERE HDR.DO_NO = DTL.DO_NO AND HDR.DO_NO = ? ");
				
                 pstmt.setString(1, doNO);
                 
				 resultSet = pstmt.executeQuery();
                  while (resultSet != null && resultSet.next()) {
				   // String doSrlNo = resultSet.getString("DO_SRL_NO");
					//String schDelvDate = resultSet.getString("SCH_DELV_DATE");
                   // String itemcode = resultSet.getString("ITEM_CODE"); 
					doLineStatus = resultSet.getString("DO_LINE_STATUS");
					//String poNo = resultSet.getString("PO_NO");
				//	String poSrlNo = resultSet.getString("PO_SRL_NO");
					
					if(doLineStatus.equals("NR")){
						doLineStatus = "CA"	;
					}else{
						doLineStatus = doStatus;
						break;
					}
					}
					

				ArrayList alModifyRecord = new java.util.ArrayList();
				 
				if(doLineStatus.equals("CA")) 
					alModifyRecord.add(remarks);
				else	
					alModifyRecord.add("");	
				alModifyRecord.add(doLineStatus);
				alModifyRecord.add(login_by_id);
				alModifyRecord.add(login_at_ws_no);
				alModifyRecord.add(login_facility_id);
				alModifyRecord.add(""+doNO);
				alCheckedDocNumbers.add(""+doNO);	
                System.out.println("alModifyRecord===>" +alModifyRecord);				

				alModifyData.add(alModifyRecord);
				
			/*	pstmt = connection.prepareStatement("SELECT DTL.PO_NO , dtl.po_srl_no,dtl.SCH_DELV_DATE,DTL.ITEM_CODE ,DTL.DO_QTY  FROM  PO_DELV_ORD_HDR  HDR , PO_DELV_ORD_DTL  DTL WHERE  HDR.DO_NO = DTL.DO_NO  AND  HDR.DO_NO = ?");
				 
				 pstmt.setString(1, doNO);
                 resultSet = pstmt.executeQuery();
                 while(resultSet != null && resultSet.next()) {
                    String do_no = resultSet.getString("PO_NO");
					String item_code = resultSet.getString("ITEM_CODE");
					String do_qty = resultSet.getString("DO_QTY");
					 
					 
					  ArrayList alReqDtl = new ArrayList();
					  ArrayList almmupdate = new ArrayList();	
                    				 
					  alReqDtl.add(do_qty);
					  alReqDtl.add(login_by_id);
					  alReqDtl.add(login_at_ws_no);
					  alReqDtl.add(login_facility_id);
					  alReqDtl.add(checkForNull(do_no));
					  alReqDtl.add(login_facility_id);
					  
					  alReqDtlUpd.add(alReqDtl);
					  System.out.println("alReqDtlUpd===>" +alReqDtlUpd);
				*/	  
					  
				/*	 almmupdate.add(po_qty);
					 almmupdate.add(login_by_id);
					 almmupdate.add(login_at_ws_no);
					 almmupdate.add(login_facility_id);
					 almmupdate.add(item_code);
					 alMMUpdate.add(almmupdate);
					 System.out.println("alMMUpdate===>" +alMMUpdate);
					 
				}	 	  
			*/
				closeResultSet(resultSet);//Added for TFS id:-15756
				closeStatement(pstmt);//Added for TFS id:-15756
				pstmt = connection.prepareStatement("SELECT DTL.DO_QTY,DTL.ITEM_CODE,DTL.DO_LINE_STATUS ,DO_SRL_NO,TO_CHAR (DTL.SCH_DELV_DATE, 'dd/mm/yyyy') SCH_DELV_DATE,PO_NO,PO_SRL_NO FROM PO_DELV_ORD_HDR  HDR , PO_DELV_ORD_DTL DTL WHERE HDR.DO_NO = DTL.DO_NO AND HDR.DO_NO = ? ");
				
                 pstmt.setString(1, doNO);
                 
				 resultSet = pstmt.executeQuery();
                  while (resultSet != null && resultSet.next()) {
				    String doSrlNo = resultSet.getString("DO_SRL_NO");
					String schDelvDate = resultSet.getString("SCH_DELV_DATE");
                    String itemcode = resultSet.getString("ITEM_CODE"); 
					String doLineStatusDtl = resultSet.getString("DO_LINE_STATUS");
					String poNo = resultSet.getString("PO_NO");
					String poSrlNo = resultSet.getString("PO_SRL_NO");
			        					 
					ArrayList dtlupd = new ArrayList();	
					
					if(doLineStatusDtl.equals("NR")){	
						dtlupd.add("CA");
						dtlupd.add(remarks);
					}else{
						dtlupd.add(doLineStatusDtl);
						dtlupd.add("");
					}		
						
						dtlupd.add(login_by_id);
						dtlupd.add(login_at_ws_no);
						dtlupd.add(login_facility_id);
						dtlupd.add(doNO);
						dtlupd.add(itemcode);
						dtlupd.add(doSrlNo);
						dtlupd.add(poNo);
						dtlupd.add(schDelvDate);
						dtlupd.add(poSrlNo);
					
					
			        datadtl.add(dtlupd);
					System.out.println("datadtl===574===>" +datadtl);
					

			}
			
			//ends here 
				
		     closeResultSet(resultSet);
             closeStatement(pstmt);
			}
			}

			hmTableData.put("HeaderUpdateData",alModifyData);
			hmSQLMap.put("UpdateHDRSQL", "UPDATE PO_DELV_ORD_HDR SET DO_CANCEL_REMARKS =    ? , DO_STATUS =    ?, MODIFIED_BY_ID =    ? , MODIFIED_DATE =    SYSDATE    , MODIFIED_AT_WS_NO    = ?    , MODIFIED_FACILITY_ID = ?	WHERE   DO_NO = ?");
			
			hmTableData.put("DetailUpdateData",datadtl);
			hmSQLMap.put("UpdateDTLSQL","UPDATE PO_DELV_ORD_DTL SET DO_LINE_STATUS =    ? , CANCEL_REMARKS = ? ,modified_by_id =    ? , modified_date =    SYSDATE    , modified_at_ws_no    = ?    , modified_facility_id = ?	WHERE do_no = ?  AND item_code = ? and DO_SRL_NO = ? and PO_NO = ? and SCH_DELV_DATE = TO_DATE(?,'DD/MM/YYYY') and PO_SRL_NO = ?");
			
			
			hmTableData.put("AlReqDtlUpd",alReqDtlUpd);
			hmSQLMap.put("AlReqDtlUpdSQL", "UPDATE po_request_detail SET PO_QTY = PO_QTY - NVL(?,0), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE REQ_NO = ? AND FACILITY_ID = ?");

			hmTableData.put("AlMmItemUpd",alMMUpdate);
			hmSQLMap.put("ALMMSQL", "UPDATE MM_ITEM SET QTY_ON_ORDER = QTY_ON_ORDER - NVL(?,0), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE ITEM_CODE = ?");
			
			
			 
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getPoRepositoryValue("JNDI_PO_CANCEL_DELIVERY_ORDER"),ePO.POCancelDeliveryOrder.POCancelDeliveryOrderHome.class,getLocalEJB());
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
}
