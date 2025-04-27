/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;
//import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
//import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import eCommon.Common.*;

public class ComputeStockLevelsBean extends StAdapter  implements Serializable{

/*private String language_id;

public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/

	public HashMap modify() {
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		//ArrayList	alModifyData=	new ArrayList()	;
		Iterator iterator =hsItemSelected.iterator();
		String stItem_code;
		ArrayList alUpdateData=new ArrayList();
		HashMap hmItemDetailforUpdate	=	new HashMap();

		for (;iterator.hasNext();) {
			stItem_code=(String)iterator.next();
			hmItemDetailforUpdate	=	(HashMap)hmItemDetails.get(stItem_code);

			ArrayList alUpdateRecord = new ArrayList();
			alUpdateRecord.add(hmItemDetailforUpdate.get("reorder_level"));
			alUpdateRecord.add(hmItemDetailforUpdate.get("reorder_qty"));
			alUpdateRecord.add(hmItemDetailforUpdate.get("min_stk_qty"));
			alUpdateRecord.add(hmItemDetailforUpdate.get("max_stk_qty"));
			alUpdateRecord.add(lead_days);
			alUpdateRecord.add(min_stock_days);
			alUpdateRecord.add(buffer_perc);
			alUpdateRecord.add(login_by_id);
			alUpdateRecord.add(login_at_ws_no);
			alUpdateRecord.add(login_facility_id);
			alUpdateRecord.add(stItem_code);

			alUpdateData.add(alUpdateRecord);
		}



//		alModifyData.add(	p_cons_per    		);
//		alModifyData.add(	p_lead_days   		);
//		alModifyData.add(	p_min_stk_days		);
//		alModifyData.add(	p_buffer_perc 		);

		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alUpdateData);
		hmTableData.put("LanguageData",LanguageData);
		hmSQLMap.put	( "ModifySQL", getStRepositoryValue("SQL_ST_ITEM_UPDATE_FOR_CALCULATE_STOCK_LEVELS"));

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT_BATCH );
	}


	
public ArrayList getValuesDesc(String consumption_period1,String fm_item_code1,String to_item_code1,String fm_item_code2,String to_item_code2,String fm_item_class_code2,String to_item_class_code2,String consumption_period2,String excludeexternalstores1) {
		
		//{consumption_period,fm_item_code,to_item_code,fm_item_code,to_item_code,fm_item_class_code,to_item_class_code,consumption_period,excludeexternalstores};
        ArrayList values = new ArrayList() ; 
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
		ResultSetMetaData resultSetMetaData	= null;
		//String remarksdescription = "";
        try {
            connection = getConnection();
			//String  sql="SELECT REMARKS_DESC FROM   MM_TRN_REMARKS WHERE EFF_STATUS = 'E' AND TRN_REMARKS_CODE= ? "; 
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_FOR_CALCULATE_STOCK_LEVELS"));
			
            pstmt.setString(1, consumption_period1);
            pstmt.setString(2, fm_item_code1);
            pstmt.setString(3, to_item_code1);
            pstmt.setString(4, fm_item_code2);
            pstmt.setString(5, to_item_code2);
            pstmt.setString(6, fm_item_class_code2);
            pstmt.setString(7, to_item_class_code2);
            pstmt.setString(8, consumption_period2);
            pstmt.setString(9, excludeexternalstores1);
            pstmt.setString(10, getLanguageId());
			//pstmt.setString(2, repack_uom);
			resultSet = pstmt.executeQuery();
			resultSetMetaData	=	resultSet.getMetaData();
			int i	=1	;
            while (resultSet.next()) 
			{
				HashMap hmRecord12=new HashMap();
				for (i=1; i<=resultSetMetaData.getColumnCount(); i++ )
					hmRecord12.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
				values.add(hmRecord12);
			/*values.add(resultSet.getString(1));
			values.add(resultSet.getString(2));
			values.add(resultSet.getString(3));
			values.add(resultSet.getString(1));
			values.add(resultSet.getString(1));
			values.add(resultSet.getString(1));
			values.add(resultSet.getString(1));
				*/
				//alEqvlUomCode.add(eqvluom);
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
		
		return values;
	}
	
	public void loadData(Hashtable hashtable){
		try {
			String consumption_period = checkForNull((String)hashtable.get("consumption_period"));
			String fm_item_class_code = checkForNull((String)hashtable.get("fm_item_class_code"),"!");
			String to_item_class_code = checkForNull((String)hashtable.get("to_item_class_code"),"~");
			String fm_item_code = checkForNull((String)hashtable.get("fm_item_code"),"!");
			String to_item_code = checkForNull((String)hashtable.get("to_item_code"),"~");
			String excludeexternalstores = checkForNull((String)hashtable.get("excludeexternalstores"),"");

			String stParameters[]= {consumption_period,fm_item_code,to_item_code,fm_item_code,to_item_code,fm_item_class_code,to_item_class_code,consumption_period,excludeexternalstores,getLanguageId()};
			//alItem=getValuesDesc(consumption_period,fm_item_code,to_item_code,fm_item_code,to_item_code,fm_item_class_code,to_item_class_code,consumption_period,excludeexternalstores);
			alItem	=	fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_FOR_CALCULATE_STOCK_LEVELS"), stParameters);
			HashMap hmRecord;
			HashMap hmNewItemDetail;

			for (int i=0; i<alItem.size(); i++) {
				hmRecord	=	(HashMap)alItem.get(i);
				double dAvg_cons_day	=	Double.parseDouble((String)hmRecord.get("AVG_CONS_DAY"));
				double dMinimum			=	dAvg_cons_day*Double.parseDouble(checkForNull((String)hashtable.get("min_stock_days"),(String)hmRecord.get("MIN_STOCK_DAYS")));
				double dROL				=	dMinimum + (dAvg_cons_day*Double.parseDouble(checkForNull((String)hashtable.get("lead_days"),(String)hmRecord.get("LEAD_DAYS"))));
				double dROQ				=	dROL + Double.parseDouble(checkForNull((String)hashtable.get("buffer_percentage"),(String)hmRecord.get("BUFFER_PERC")))*Double.parseDouble((String)hmRecord.get("MIN_STK_QTY"))*dMinimum/100;
				double dMaximum			=	dROQ + dMinimum;

				hmNewItemDetail	=	new HashMap();
				hmNewItemDetail.put("min_stk_qty", ""+(long)Math.ceil(dMinimum));
				hmNewItemDetail.put("max_stk_qty", ""+(long)Math.ceil(dMaximum));
				hmNewItemDetail.put("reorder_level", ""+(long)Math.ceil(dROL));
				hmNewItemDetail.put("reorder_qty", ""+(long)Math.ceil(dROQ));
				hmNewItemDetail.put("selected", "Y");
				hmItemDetails.put(hmRecord.get("ITEM_CODE"),hmNewItemDetail);
				hsItemSelected.add(hmRecord.get("ITEM_CODE"));
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void updateData(Hashtable htFormData){
		String stKey;//,selectedKey;
		HashMap hmNewItemDetail;
		java.util.Enumeration hashKeys = htFormData.keys();
		while (hashKeys.hasMoreElements()) {
			stKey = (String) hashKeys.nextElement();
			if (stKey.startsWith("add_item_")) {
				String stItem_code	=	stKey.substring(9);
				hsItemSelected.add(stItem_code);

				String min_stk_qty	=(String)	htFormData.get("min_stk_qty_"+stItem_code);
				String max_stk_qty	=(String)	htFormData.get("max_stk_qty_"+stItem_code);
				String reorder_level=(String)	htFormData.get("reorder_level_"+stItem_code);
				String reorder_qty	=(String)	htFormData.get("reorder_qty_"+stItem_code);
				String selected	=	"Y";

				if (! ((String)htFormData.get("remove_item_"+stItem_code)).equals("") ){
					selected="N";
					hsItemSelected.remove(stItem_code);
				}

				hmNewItemDetail	=	(HashMap)hmItemDetails.get(stItem_code);
				hmNewItemDetail.put("min_stk_qty", min_stk_qty);
				hmNewItemDetail.put("max_stk_qty", max_stk_qty);
				hmNewItemDetail.put("reorder_level", reorder_level);
				hmNewItemDetail.put("reorder_qty", reorder_qty);
				hmNewItemDetail.put("selected", selected);
				hmItemDetails.put(stItem_code,hmNewItemDetail);
			}
		}
	}
	
	public void setAll(Hashtable htFormData){
		lead_days=(String)htFormData.get("lead_days");     
		min_stock_days=(String)htFormData.get("min_stock_days");
		buffer_perc=(String)htFormData.get("buffer_percentage");   
	}

	public void clear(){
		super.clear();
		alItem=null;
		hsItemSelected=null;
		hmItemDetails=null;
		lead_days=null;     
		min_stock_days=null;
		buffer_perc=null;   
	}

	public void initialize(){
		alItem=new ArrayList();
		hsItemSelected=new HashSet();
		hmItemDetails=new HashMap();
		lead_days="";     
		min_stock_days="";
		buffer_perc="";   
	}

	public ArrayList getAllItem(){
		return alItem;
	}

	public HashSet getSelectedItem(){
		return hsItemSelected;
	}

	public HashMap getCalculatedItemDetails(){
		return hmItemDetails;
	}

	private ArrayList alItem;
	private HashSet hsItemSelected;
	private HashMap hmItemDetails;
	private	String lead_days;
	private	String min_stock_days;
	private	String buffer_perc;
}
