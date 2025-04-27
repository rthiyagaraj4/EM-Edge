/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class PackingListBean extends eSS.Common.SsTransaction implements java.io.Serializable { 

	private String pack_item_qty;
	private String pack_cost;
	private String pack_item_code;
	private String pack_item_desc;
	private String packing_date;
	private String tray_no;
	private String hold_yn;
	private String hold_reason;
	private String group_code;
	private String group_desc;
	private String Store_code;

	public void setHold_reason(String hold_reason) {
		 this.hold_reason = checkForNull(hold_reason);
	}

	public String getHold_reason( ) {
		 return hold_reason;
	}

	public void setHold_yn(String hold_yn) {
		 this.hold_yn = checkForNull(hold_yn,"N");
	}

	public String getHold_yn( ) {
		 return hold_yn;
	}

	public void setGroup_desc(String group_desc) {
		 this.group_desc = group_desc;
	}

	public String getGroup_desc( ) {
		 return group_desc;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no = tray_no;
	}

	public String getTray_no( ) {
		 return tray_no;
	}

	public void setGroup_code(String group_code) {
		 this.group_code = group_code;
	}

	public String getGroup_code( ) {
		 return group_code;
	}

	public void setPack_item_qty(String pack_item_qty) {
		 this.pack_item_qty = checkForNull(pack_item_qty,"");
	}

	public String getPack_item_qty( ) {
		 return pack_item_qty;
	}

	public void setPack_cost(String pack_cost) {
		 this.pack_cost = checkForNull(pack_cost);
	}

	public String getPack_cost( ) {
		 return pack_cost;
	}

	public void setPacking_date(String packing_date) {
		 this.packing_date = checkForNull(packing_date);
	}

	public String getPacking_date( ) {
		 return packing_date;
	}

	public void setPack_item_code(String pack_item_code) {
		 this.pack_item_code = checkForNull(pack_item_code);
	}

	public String getPack_item_code( ) {
		 return pack_item_code;
	}

	public void setPack_item_desc(String pack_item_desc) {
		 this.pack_item_desc= checkForNull(pack_item_desc);
	}

	public String getPack_item_desc( ) {
		 return pack_item_desc;
	}
	
	public void setStore_code_List(String Store_code){
		 this.Store_code= checkForNull(Store_code);
	}

	public String getStore_code_List( ) {
		 return Store_code;
	}

	public boolean isValidDiscrepancyQty(String group_code, String tray_no, String item_code, String discrepancy_type, String discrepancy_qty) throws Exception{
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(group_code);
		alParameters.add(new Long(tray_no));
		alParameters.add(item_code);
		alParameters.add(discrepancy_type);
		alParameters.add(new Long(discrepancy_qty));
		PackingDiscrepancyListBean discrep=new PackingDiscrepancyListBean();
		discrep.setItem_code(item_code);
		return ((HashMap)fetchRecord(getSsRepositoryValue("SQL_SS_VALIDATE_DISCREPANCY_QTY_SELECT"),alParameters)).get("MESSAGE").toString().equals("NO_ERROR");
	}
		public String isValidDiscrepancyQtyMessage(String group_code, String tray_no, String item_code, String discrepancy_type, String discrepancy_qty) throws Exception{
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(group_code);
		alParameters.add(new Long(tray_no));
		alParameters.add(item_code);
		alParameters.add(discrepancy_type);
		alParameters.add(new Long(discrepancy_qty));
		return (((HashMap)fetchRecord(getSsRepositoryValue("SQL_SS_VALIDATE_DISCREPANCY_QTY_SELECT"),alParameters)).get("MESSAGE").toString());
	}
	public String getPackItemDescription(String pack_item_code) throws Exception{
		HashMap hmRecord	=	fetchRecord(getSsRepositoryValue("SQL_SS_ITEM_SELECT_SINGLE"),pack_item_code);
		if (hmRecord.get("CONSUMABLE_YN").toString().equals("Y")) {
			throw new Exception("ITEM_IS_CONSUMABLE");
		}
		return hmRecord.get("SHORT_DESC").toString();
	}

	public void initialize(HashMap hmPackingListItem){

		setPack_item_qty(checkForNull((String) hmPackingListItem.get("PACK_ITEM_QTY"),""));
		setPack_cost(checkForNull((String) hmPackingListItem.get("PACK_COST"),""));
		setPack_item_code(checkForNull((String) hmPackingListItem.get("PACK_ITEM_CODE"),""));
		setPack_item_desc(checkForNull((String) hmPackingListItem.get("PACK_ITEM_DESC"),""));
		
		setPacking_date((String) hmPackingListItem.get("packing_date"));
		setGroup_code((String) hmPackingListItem.get("group_code"));
		setGroup_desc((String) hmPackingListItem.get("group_desc"));
		setTray_no((String) hmPackingListItem.get("tray_no"));
		setHold_yn((String) hmPackingListItem.get("hold_yn"));
		setHold_reason((String) hmPackingListItem.get("hold_reason"));
		setStore_code_List(checkForNull((String) hmPackingListItem.get("store_code")));
		
		

	}

	public boolean isGroupTrayItemInArrayList(ArrayList alPackingList, String stGroupCode, String stTrayNo,  String stItemCode, int exceptionalIndex){
		boolean result=false;
		for (int i=0;i<alPackingList.size();i++) {
			if (exceptionalIndex == i) continue;
			if ( ((HashMap)alPackingList.get(i)).get("pack_item_code").toString().equals(stItemCode) ) 
				if ( ((HashMap)alPackingList.get(i)).get("group_code").toString().equals(stGroupCode) ) 
					if ( ((HashMap)alPackingList.get(i)).get("tray_no").toString().equals(stTrayNo) ) {
						result=true;
						break;
					}
		}
		return result;
	}

	public void clear(){
		pack_item_qty	="";
		pack_cost		="";
		pack_item_code	="";
		pack_item_desc	="";
		packing_date	="";
		group_code		="";
		group_desc		="";
		tray_no			="";
		hold_reason		="";
		hold_yn			="";
	}
	//Added for TH-KW-CRF-0030
	public String getExpiryDate(String group_code,String tray_no) throws Exception {
        Connection connection = null;
		PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		String sql ="";
		String expiry_date="";
try{

			connection = getConnection() ;

			sql ="SELECT TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY') EXPIRY_DATE FROM SS_TRAY_DTLS WHERE GROUP_CODE=? AND TRAY_NO=? ";
				
				pstmt =connection.prepareStatement(sql);
				pstmt.setString(1, group_code) ;
			    pstmt.setString(2, tray_no);

			  resultSet = pstmt.executeQuery() ;

			if(resultSet!=null && resultSet.next()){
				expiry_date=(String)resultSet.getString("EXPIRY_DATE")==null?"":(String)resultSet.getString("EXPIRY_DATE");		
			}
			if(expiry_date.equals(""))
                 expiry_date =getPacking_date();
				
		}catch(Exception e){
			e.printStackTrace();
		}finally { //Added for COMMON-ICN-0119
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			} // COMMON-ICN-0119
		}
		return expiry_date;
	}//Adding end for TH-KW-CRF-0030
}
