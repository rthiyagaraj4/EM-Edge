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
import java.util.ArrayList;
import ePO.PurchaseOrder.*;
import ePO.Common.PoRepository;
import eCommon.Common.*;
import java.util.Properties; 


public class PurchaseOrderStatusBean extends ePO.Common.PoTransaction implements Serializable{
	
	private String master_type;
	private String purchase_type;
	
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

	public String getRequestFromPurchaseUnit() {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		sqlParam.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_ORD"),sqlParam),""); 
		
	}
	public String getRequestFromPurchaseUnit(String pur_unit) {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		sqlParam.add(getLoginFacilityId());
		
		try{
			int cnt = Integer.parseInt((String)fetchRecord(getPoRepositoryValue("SQL_PURCHASE_UNIT_COUNT"),sqlParam).get("COUNT"));
			
			if(cnt == 1){
				pur_unit		=	(String)fetchRecord(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_ORD"),sqlParam).get("CODE");
				System.out.println("pur_unit in po bean = "+pur_unit);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("pur_unit in po bean after try= "+pur_unit);
		System.out.println("sqlParam in po bean after try= "+sqlParam);
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_ORD"),sqlParam),pur_unit); 
		
	}
	
	public String getPurchase_type_List() {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add(getMasterType());
		   arr_language.add(getLanguageId());
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),getPurchase_type()); 
    }
	public String getPurchase_type_List(String pur_type) {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add(getMasterType());
		   arr_language.add(getLanguageId());
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),pur_type); 
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
	


}
