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
import java.util.HashMap;
import java.util.Hashtable;
import java.sql.*;
import eCommon.SingleTableHandler.*;
import ePO.Common.PoRepository;
import eCommon.Common.CommonRepository;
import ePO.Common.PoAdapter;


public class PoTransactionRemarksBean extends PoAdapter implements Serializable {
	String master_type;
	String remarks_code;
	String remarks_description;
	String select_all;
	int total_remarks;
		
	java.util.ArrayList remarks;
	java.util.ArrayList selectedRemarks;
	java.util.ArrayList selectedEffStatus;
	java.util.HashMap hmCommonData ;
	java.util.HashMap selectedData ;

	public PoTransactionRemarksBean() {
		selectedRemarks = new java.util.ArrayList();
		hmCommonData=new java.util.HashMap();
		selectedData=new java.util.HashMap();
		
	
	}

	public void setMaster_Type(String master_type) {
		this.master_type = master_type;
	}

	public String getMaster_Type() {
		return this.master_type;
	}
	public void setRemarks_Code(String remarks_code) {
		this.remarks_code = remarks_code;
	}
public int getTotalRemarks() {
		return this.total_remarks;
	}
	public void setTotalRemarks(int total_remarks) {
		this.total_remarks = total_remarks;
	}
	public String getRemarks_Code() {
		return this.remarks_code;
	}
	public void setRemarks_Description(String remarks_description) {
		this.remarks_description = remarks_description;
	}

	public String getRemarks_Description() {
		return this.remarks_description;
	}
	public java.util.ArrayList getRemarks() {
		return this.remarks;
	}
	public void setSelect_All(String select_all) {
		 this.select_all = checkForNull(select_all);
	}

	public String getSelect_All() {
		 return select_all;
	}
	

public void loadRemarks (){
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		try {
			
			remarks = new java.util.ArrayList();
			connection = getConnection();
			preparedStatement = connection.prepareStatement("SELECT	TRN_REMARKS_CODE,EFF_STATUS  FROM PO_MSTR_TYPE_FOR_REMARKS  WHERE MASTER_TYPE =	?"); 
			preparedStatement.setString(1, getMaster_Type());
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
					remarks.add(resultSet.getString("TRN_REMARKS_CODE"));
							}
							hmCommonData.put("MASTER_TYPE",getMaster_Type());
			
		} 
		catch (Exception e )	{
			e.printStackTrace();
			} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
	}
	public java.util.ArrayList getSelectedRemarks() {
		return selectedRemarks;
	}
public java.util.HashMap getSelectedData() {
		return selectedData;
	}
	public void clear() {
		if (selectedRemarks!= null) {
			selectedRemarks.clear();
		}
		if (selectedData!= null) {
			selectedData.clear();
		}
		if(hmCommonData!=null){
			hmCommonData.clear();
		}
	}

	public int hasRecords() {
		
		if (selectedRemarks != null) {
			return selectedRemarks.size();
		}
		return -1;
	}
	
	public HashMap validate() {
		boolean result=false;
		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");
		
		try{
			HashMap hmData				=		(HashMap)hmCommonData.get(getMaster_Type());
			
			for(int i=0;i<getTotalRecords();i++)
		{
			// if no checkbox is not  checked or no data is entered..
			if(checkForNull(((String)hmData.get("EFF_STATUS_"+i))).equals("E")){
					result=true;
					
				}
				
		}
	
		if(result==false){
		//throw new Exception("MIN_ONE_DETAIL_REQUIRED");
				resultMap.put("result", super.FALSE);
				resultMap.put("message", getMessage(getLanguageId(),"MIN_ONE_DETAIL_REQUIRED","Common") );
		}
		}
			catch(Exception exception)
			{
				
				exception.printStackTrace();

			}
		return resultMap;
	}

	public void setAll(Hashtable hashValues) {

		hmCommonData.put("MASTER_TYPE",getMaster_Type());
		HashMap data				=		new HashMap();
		hashValues.remove("mode");
		hashValues.remove("user_id");
		hashValues.remove("canProcess");
		int total_records			=		getTotalRecords();
		int cnt=1;
		
		try{
		HashMap hmData				=		(HashMap)hmCommonData.get(getMaster_Type());
		if(hmData==null){
		setTotalRemarks(cnt);
		this.getDataFromRecords(hashValues);
		hmData				=		(HashMap)hmCommonData.get(getMaster_Type());
			for(int index=0;index<getTotalRemarks();index++)
		{
			if((checkForNull((String)hashValues.get("remove_remarks_code"+index))).equals(checkForNull((String)hmData.get("REMARKS_CODE_"+index))))
			{
				data.put("DB_ACTION_"+index,"U");

				if(((String)hmData.get("EFF_STATUS_"+index)).equals("E"))
					data.put("EFF_STATUS_"+index,"E");
				else 
					data.put("EFF_STATUS_"+index,"D");
			}
			
			else	
			{
				data.put("DB_ACTION_"+index,"I");
				data.put("EFF_STATUS_"+index,"D");
			}
				data.put("REMARKS_CODE_"+index,(String)hashValues.get("remove_remarks_code"+index));
			
				hashValues.remove("eff_status_"+index);
				hashValues.remove("highlight_"+index);
				hashValues.remove("db_action_"+index);
				hashValues.remove("remove_remarks_code"+index);
		
		}

	}
	else {
		setTotalRemarks(Integer.parseInt((String)hashValues.get("total_records")));
		for(int index=0;index<total_records;index++)
		{

				if((String)hmData.get("DB_ACTION_"+index)==null)
					data.put("DB_ACTION_"+index,"I");
				else
					data.put("DB_ACTION_"+index,(String)hmData.get("DB_ACTION_"+index));

				if((String)hmData.get("EFF_STATUS_"+index)==null)
					data.put("EFF_STATUS_"+index,"D");
				else 
					data.put("EFF_STATUS_"+index,(String)hmData.get("EFF_STATUS_"+index));
				
				data.put("REMARKS_CODE_"+index,(String)hmData.get("REMARKS_CODE_"+index));

				hashValues.remove("eff_status_"+index);
				hashValues.remove("highlight_"+index);
				hashValues.remove("db_action_"+index);
				hashValues.remove("remove_remarks_code"+index);
		
}
			hmCommonData.put(checkForNull(getMaster_Type()),data);
			hashValues.remove("total_remarks");
			hashValues.remove("total_records");
			hashValues.remove("master_type");
			hashValues.remove("start");
			hashValues.remove("end");
			hashValues.remove("displaySize");
			hashValues.remove("selectAll");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public java.util.HashMap insert() {
	
		HashMap map								=		new HashMap()	;
		Connection				 connection		=		null;
		PreparedStatement		 pstmt1			=		null;
		PreparedStatement		 pstmt2			=		null;
		
		boolean					insert_rec_1	=		true;
		boolean					update_rec_1	=		true;
		boolean					no_records		=		false;
		int						count_i			=		 0;

	
		try{
					connection					=		getConnection();
					pstmt1						=		connection.prepareStatement(getPoRepositoryValue("SQL_PO_MSTR_TYPE_FOR_REMARKS_INSERT"));
					pstmt2						=		connection.prepareStatement(getPoRepositoryValue("SQL_PO_MSTR_TYPE_FOR_REMARKS_UPDATE"));
					
					map.put("result", new Boolean(false));
					HashMap hmData				=		(HashMap)hmCommonData.get(getMaster_Type()); 
		
					for (int index=0;index<getTotalRemarks();index++) {
					
					if((hmData.get("DB_ACTION_"+index).equals("I"))&&(hmData.get("EFF_STATUS_"+index)).equals("E")){

				
								pstmt1.setString(1,getMaster_Type());
								pstmt1.setString(2,(String)hmData.get("REMARKS_CODE_"+index));
								pstmt1.setString(3,(String)hmData.get("EFF_STATUS_"+index));            
								pstmt1.setString(4,login_by_id);
								pstmt1.setString(5,login_at_ws_no);
								pstmt1.setString(6,login_facility_id);
								pstmt1.setString(7,login_by_id);
								pstmt1.setString(8,login_at_ws_no);
								pstmt1.setString(9,login_facility_id);
								pstmt1.addBatch();
			
						}
	
           
					else if((hmData.get("DB_ACTION_"+index).equals("U"))){
				
							if((hmData.get("EFF_STATUS_"+index)).equals("E"))
							{
								pstmt2.setString(1,"E");
							}
							else if((hmData.get("EFF_STATUS_"+index)).equals("D")){
								pstmt2.setString(1,"D");
							}
								pstmt2.setString(2,login_by_id);
								pstmt2.setString(3,login_at_ws_no);
								pstmt2.setString(4,login_facility_id);
								pstmt2.setString(5,login_by_id);           
								pstmt2.setString(6,login_at_ws_no);
								pstmt2.setString(7,login_facility_id);
								pstmt2.setString(8,getMaster_Type());
								pstmt2.setString(9,(String)hmData.get("REMARKS_CODE_"+index));
								pstmt2.addBatch();
								
								
							} 
			
				else if(((hmData.get("DB_ACTION_"+index).equals("I"))&&((hmData.get("EFF_STATUS_"+index)).equals("D"))))
							{	
						
									count_i		=		count_i+1;

								if(count_i==hmData.size())
									no_records	=		true;
								else
									no_records	=		false;
									
							}
								
				}
		
							int [] numInserts	=		pstmt1.executeBatch();    
							int [] numUpdates	=		pstmt2.executeBatch();    
							
							for (int i=0;i<numInserts.length ;i++ )
							{
								if(numInserts[i]<0  && numInserts[i] != -2 ){
								insert_rec_1	=		false;
								break;
								}
								else{
								insert_rec_1	=		true;
									}
							}

							for (int i=0;i<numUpdates.length ;i++ )
							{
								if(numUpdates[i]<0  && numUpdates[i] != -2 ){
								update_rec_1	=		false;
								break;
								}
								else{
								update_rec_1	=		true;
								}
							}

								
				if(insert_rec_1 || update_rec_1 )
					{
						if(no_records==false)
						{
							connection.commit();
							map.put( "result", new Boolean( true ) ) ;
							map.put( "LanguageData",getLanguageId());
							map.put( "properties", getProperties());
							if( ((Boolean) map.get( "result" )).booleanValue() ){
								 map.put( "message", getPOMessage(getLanguageId(), "RECORD_INSERTED" ,"PO") ) ;
							 }
						else{
							 map.put( "message", (map.get("message"))) ;
						}

							map.put("flag","");
						}
						else if(no_records)
						{							
									map.put( "result", new Boolean( true ) ) ;
									map.put( "LanguageData",getLanguageId());
									map.put( "properties", getProperties());
									
									if( ((Boolean) map.get( "result" )).booleanValue() ){
										 map.put( "message", getMessage(getLanguageId(),"ATLEAST_ONE_SELECTED","Common") ) ;
										 }
									else{
									 map.put( "message", (map.get("message"))) ;}
						}
					}else{
							try{
								connection.rollback();
								map.put("flag","true");
							}
							catch(Exception es){
								es.printStackTrace() ;
								map.put("flag","");
							}

												
						}
		}
			catch (Exception e)
			{
				map.put("message", map.get("message") + e.toString()) ;
				e.printStackTrace();
			}
			  finally
		{
		try
		{
			closeStatement(pstmt1);
			closeStatement(pstmt2);
			closeConnection(connection);
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		}
		
		return map;
	}

	public boolean isRemarkChecked(String remarks_code)
	{
		Connection				 connection		=		null;
		PreparedStatement		 pstmt1			=		null;
		ResultSet				 resultSet				=		null;
		String result							=		"";
		try{
					connection					=		getConnection();
					pstmt1						=		connection.prepareStatement(getPoRepositoryValue("SQL_PO_MSTR_TYPE_FOR_REMARKS_EFFSTATUS_YN"));
					pstmt1.setString(1,remarks_code);
					pstmt1.setString(2,getMaster_Type());
					resultSet=pstmt1.executeQuery();
				 while (resultSet != null && resultSet.next()) {
					result=resultSet.getString("EFF_STATUS");
				 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt1);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
					if(result.equals("D"))
						return false;
					else
						return true;
					
		}	 
		public int getTotalRecords()
	{
		Connection				 connection		=		null;
		PreparedStatement		 pstmt1			=		null;
		ResultSet				 resultSet		=		null;
		int						 result			=		0;
		try{
					connection					=		getConnection();
				
					pstmt1						=		connection.prepareStatement(getPoRepositoryValue("SQL_PO_MM_TRN_REMARKS_LANG_COUNT"));
					pstmt1.setString(1,getLanguageId());
					resultSet=pstmt1.executeQuery();
				 while (resultSet != null && resultSet.next()) {
					result						=		resultSet.getInt("TOTAL");
				 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt1);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
					return result;
					
		}	 
		public void updateSelectedRemarks(Hashtable htRemarks) {
		try{
			
		ArrayList  removeList						=		new java.util.ArrayList(12);
		String keyName								=		"";
		java.util.Enumeration enumKeyRemarks		=		htRemarks.keys();
		int index=0;

		while (enumKeyRemarks.hasMoreElements()) {
			keyName = (String)enumKeyRemarks.nextElement();
			if (keyName.startsWith("remarks_code_") ||keyName.startsWith("db_action_")||keyName.startsWith("eff_status_")||keyName.startsWith("PreviousListValueExit") ||keyName.startsWith("highlight_") ||keyName.startsWith("select_all")) {
				removeList.add(htRemarks.get(keyName));
				htRemarks.remove(keyName);
			}
		}
		selectedRemarks.removeAll(removeList);
		java.util.Enumeration enumKeyData			=		htRemarks.keys();
		java.util.Enumeration enumRemarksData		=		htRemarks.elements();
	
		String data_value							=		"";
		

		while (enumKeyData.hasMoreElements()) { 
				keyName								=		(String)enumKeyData.nextElement();
				data_value							=		(String) enumRemarksData.nextElement();
			if(keyName.startsWith("REMARKS_CODE_"))index++;
			if ((keyName.startsWith("REMARKS_CODE_"))||(keyName.startsWith("EFF_STATUS_"))||(keyName.startsWith("DB_ACTION_"))){
		
	
			if (data_value != null || data_value.trim().length()>0) 
				selectedData.put(keyName,checkForNull(data_value,""));
			}
		
			
			hmCommonData.put(hmCommonData.get("MASTER_TYPE"),selectedData);
		}
		setTotalRemarks(getTotalRecords()); 
		keyName										=		null;
		removeList									=		null;
		enumKeyRemarks								=		null;
		String value								=		"";
		java.util.Enumeration enumRemarks			=		htRemarks.elements();

		while (enumRemarks.hasMoreElements()) {
			value									=		(String) enumRemarks.nextElement();
	
			if (value != null || value.trim().length()>0) 
				selectedRemarks.add(value);

		}
		
		enumRemarks									=		null;
		}
		catch(Exception e)
			{
			e.printStackTrace();
			}

	}
	public HashMap getData()
	{
		return hmCommonData;
	}

	public ArrayList getResultPage(){
			ArrayList alParams		=		new ArrayList();
			HashMap hmTemp			=		new HashMap();
			alParams.add("ST");
			alParams.add(getLanguageId());
			ArrayList result1		=		 new ArrayList();
			ArrayList result		=		new ArrayList();
			try{
				result1				=		fetchRecords(PoRepository.getPoKeyValue("SQL_PO_MM_TRN_REMARKS_LANG_SELECT"),alParams);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(result1.size()>0){
				for(int i=0;i<result1.size();i++){
					hmTemp			=		(HashMap)result1.get(i);
					result.add((String)hmTemp.get("TRN_REMARKS_CODE"));
					result.add((String)hmTemp.get("REMARKS_DESC"));
				}
				return result;
			}
			else
				return result;

	}


public void getDataFromRecords(Hashtable htRemarks)
{
		Connection				 connection			=		null;
		PreparedStatement		 pstmt1				=		null;
		ResultSet				 resultSet			=		null;
		HashMap					 selectedData		=		new HashMap();
		int i=0;
		try{
					connection						=		getConnection();
					pstmt1							=		connection.prepareStatement(getPoRepositoryValue("SQL_PO_MSTR_TYPE_FOR_REMARKS_SELECT"));
					pstmt1.setString(1,getMaster_Type());		
					resultSet						=		pstmt1.executeQuery();

					 while (resultSet != null && resultSet.next())
					 {
						selectedData.put("REMARKS_CODE_"+i,(String)resultSet.getString("TRN_REMARKS_CODE"));
						selectedData.put("EFF_STATUS_"+i,(String)resultSet.getString("EFF_STATUS"));
						selectedData.put("DB_ACTION_"+i,"U");
						i++;
					 }
				hmCommonData.put(hmCommonData.get("MASTER_TYPE"),selectedData);
			
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt1);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}

		
	
}

public String getMasterTypes() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alOptionValues =  getListOptionArrayList(getPoRepositoryValue("SQL_PO_MASTER_TYPE_TRANSACTION_SELECT")); 
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
}
}
