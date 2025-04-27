/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO.Common ;
import javax.ejb.SessionContext ;
import eCommon.Common.* ;
import webbeans.eCommon.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class PoEJBSessionAdapter extends CommonEJBSessionAdapter {
	public SessionContext context = null ;

	public void setSessionContext( SessionContext sessionContext ) {
		super.setSessionContext(sessionContext);
		this.context = sessionContext ;
	}

	///Function for handling generic operation..
	public String checkForNull(Object o) {
        return o != null ? (String)o : "";
	}
	public String checkForNull(Object o, String defaultValue) {
        return o != null ? (String)o : defaultValue;
	}

	protected HashMap insert(	Connection	connection, HashMap		hmData, HashMap		hmSQL ) {
		HashMap				hmReturn			=	new HashMap();
		PreparedStatement	preparedStatement	=	null;
		String				sql					=	"";
		ArrayList			alData				=	new ArrayList();
// PMD 31/01/05
//		ArrayList			alRecords			=	new ArrayList();

		int					iResult				=	0;
		hmReturn.put(RESULT,FALSE);

		alData		=	(ArrayList)	hmData.get	(DATA);
		sql			=	(String)	hmSQL.get	(INSERT_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();
			if(iResult!=0){
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MSGID,RECORD_INSERTED);
				hmReturn.put(MESSAGE,RECORD_INSERTED);
				
			}
        }
		catch(SQLException sQLException) {

			hmReturn.put(RESULT,FALSE);

			if(sQLException.getErrorCode()==1){
				hmReturn.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");  //CODE_ALREADY_EXISTS
				hmReturn.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER"); //CODE_ALREADY_EXISTS
			}
			else {
				hmReturn.put(MESSAGE,sQLException.toString());
			}

			sQLException.printStackTrace();
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,exception.toString());
			exception.printStackTrace();
        }
		finally{
			try{
				if(preparedStatement!=null)preparedStatement.close();
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
	
	protected HashMap operateBatch(	Connection	connection, HashMap		hmData, HashMap		hmSQL ) {
		HashMap				hmReturn			=	new HashMap();
		PreparedStatement	preparedStatement	=	null;
		String				sql					=	"";
		ArrayList			alDataM				=	new ArrayList();
		ArrayList			alData				=	new ArrayList();
//		ArrayList			alRecords			=	new ArrayList();

		int					[]iResult			;
		int					index				=	0;
		hmReturn.put(RESULT,FALSE);

		alDataM	=   (ArrayList)	hmData.get	(DATA);
		sql		=	(String)	hmSQL.get	(BATCH_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			for(index=0;index<alDataM.size();index++) {
				alData	=	(ArrayList)alDataM.get(index);
				setData(preparedStatement,alData);
				preparedStatement.addBatch();
			}
			iResult		=	preparedStatement.executeBatch();

			hmReturn.put(RESULT,TRUE);

			if (sql.toUpperCase().startsWith("INSERT")) {
				hmReturn.put(MSGID,RECORD_INSERTED);
				hmReturn.put(MESSAGE,RECORD_INSERTED);

			}			
			else if (sql.toUpperCase().startsWith("UPDATE")) {
				hmReturn.put(MSGID,RECORD_MODIFIED);
				hmReturn.put(MESSAGE,RECORD_MODIFIED);

			}			
			else{
				hmReturn.put(MSGID,RECORD_DELETED);
				hmReturn.put(MESSAGE,RECORD_DELETED);
			}			
        }
		catch(BatchUpdateException batchUpdateException) {
			hmReturn.put(RESULT,FALSE);
			if(batchUpdateException.getErrorCode()==1) {
				hmReturn.put(MSGID,"RECORD_UPDATED_BY_OTH_USER"); //CODE_ALREADY_EXISTS
				hmReturn.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER"); //CODE_ALREADY_EXISTS
			}
			else {
				hmReturn.put(MESSAGE,batchUpdateException.toString());
			}
			batchUpdateException.printStackTrace();
        }
		catch(SQLException sQLException) {
			hmReturn.put(RESULT,FALSE);
			if(sQLException.getErrorCode()==1) {
				hmReturn.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER"); //CODE_ALREADY_EXISTS
			}
			else {
				hmReturn.put(MESSAGE,sQLException.toString());
			}
			sQLException.printStackTrace();
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,exception.toString());
			exception.printStackTrace();
        }
		finally {
			try {
				if(preparedStatement!=null)preparedStatement.close();
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
	
	protected HashMap update(	Connection	connection, HashMap		hmData, HashMap		hmSQL ) {
		HashMap				hmReturn			=	new HashMap();
		PreparedStatement	preparedStatement	=	null;
		String				sql					=	"";
		ArrayList			alData				=	new ArrayList();
//		ArrayList			alRecords			=	new ArrayList();

		int					iResult				=	0;
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MSGID,"NO_RECORD_UPDATED");
		hmReturn.put(MESSAGE,"No records found to be modified..");

		alData		=	(ArrayList)	hmData.get	(DATA);
		sql			=	(String)	hmSQL.get	(UPDATE_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();
			if(iResult!=0) {
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MSGID,RECORD_MODIFIED);
				hmReturn.put(MESSAGE,RECORD_MODIFIED);
			}
			else{
				throw new Exception("NO_RECORD_UPDATED");
			}
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
			exception.printStackTrace();
        }
		finally {
			try {
				if(preparedStatement!=null)preparedStatement.close();
			}
			catch (Exception exception) { 
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
	
	
	protected HashMap delete(	Connection	connection, HashMap		hmData, HashMap		hmSQL ) {
		HashMap				hmReturn			=	new HashMap();
		PreparedStatement	preparedStatement	=	null;
		String				sql					=	"";
		ArrayList			alData				=	new ArrayList();
//		ArrayList			alRecords			=	new ArrayList();

		int					iResult				=	0;
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MSGID,"NO_RECORD_DELETED");
		hmReturn.put(MESSAGE,"No record found to be deleted..");

		alData		=	(ArrayList)	hmData.get	(DATA);
		sql			=	(String)	hmSQL.get	(DELETE_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0) {
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MSGID,RECORD_DELETED);
				hmReturn.put(MESSAGE,RECORD_DELETED);
			}
	/*		else{
				//System.err.println("ST_DELETE executed on "+new java.util.Date());
				//System.err.println("SQL Recieved: "+sql);
				//System.err.println("DataRecieved: "+alData);
			} */
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
			exception.printStackTrace();
        }
		finally{
			try {
				if(preparedStatement!=null)preparedStatement.close();
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
	protected HashMap fetchRecord(Connection connection , String sql) throws Exception {
		return fetchRecord( connection , sql, (ArrayList) null);
	}

	protected HashMap fetchRecord(Connection connection , String sql, String stParameter) throws Exception {
		ArrayList alParameters	=	new ArrayList(1);
		alParameters.add(stParameter);
		return fetchRecord( connection , sql,  alParameters);
	}
	protected HashMap fetchRecord(Connection connection , String sql, String[] stParameters) throws Exception {
		ArrayList alParameters	=	new ArrayList(stParameters.length);
		for (int i=0;i< stParameters.length;i++ ) {
			alParameters.add(stParameters[i]);	
		}
		return fetchRecord(connection ,  sql,  alParameters);
	}

	protected HashMap fetchRecord(Connection connection , String sql, ArrayList alParameters) throws Exception {
		HashMap hmRecord					=	new HashMap();
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet					= null;
		ResultSetMetaData resultSetMetaData	= null;
		try {
 
			preparedStatement = connection.prepareStatement(sql);
			if (alParameters!=null) {
				setData( preparedStatement, alParameters);
			}
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() ) 
			{
				resultSetMetaData	=	resultSet.getMetaData();
				//resultSet.next();

				for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ ) {
					hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
			}
		}
		} 
		catch (Exception exception ) {
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		return hmRecord;
	}

	public ArrayList fetchRecords(Connection connection, String sql) throws Exception {
		return fetchRecords( connection, sql,  new ArrayList(0));
	}

	public ArrayList fetchRecords(Connection connection, String sql, String stParameter) throws Exception {
		ArrayList alParameters = new ArrayList(1);
		alParameters.add(stParameter);
		return fetchRecords( connection, sql,  alParameters);
	}
	public ArrayList fetchRecords(Connection connection, String sql, String []stParameter) throws Exception {
		ArrayList alParameters = new ArrayList(stParameter.length);
		for (int i=0;i<stParameter.length;i++) {
			alParameters.add(stParameter[i]);
		}
		return fetchRecords( connection, sql,  alParameters);
	}
	public ArrayList fetchRecords(Connection connection, String sql, ArrayList alParameters) throws Exception {
		ArrayList alRecords					=	new ArrayList();
		HashMap hmRecord					=	null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet					= null;
		ResultSetMetaData resultSetMetaData	= null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			if (alParameters!=null) 
				for (int index=0; index<alParameters.size() ;index++ ) {
					if(alParameters.get(index) instanceof String)
						preparedStatement.setString( index+1, ((String)alParameters.get(index)));
					else if(alParameters.get(index) instanceof Long){
						preparedStatement.setLong( index+1, ((Long)alParameters.get(index)).longValue());
					}
			}

			resultSet = preparedStatement.executeQuery();

			resultSetMetaData	=	resultSet.getMetaData();
			int i	=1	;
			while(resultSet.next())
			{
				hmRecord=new HashMap();
				for (i=1; i<=resultSetMetaData.getColumnCount(); i++ )
					hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
				alRecords.add(hmRecord);
			}
		} 
		catch (Exception exception )	{
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		return alRecords;
	}

	protected boolean lockRecord(Connection connection , String sql) throws Exception {
		return lockRecord( connection , sql, (ArrayList) null);
	}

	protected boolean lockRecord(Connection connection , String sql, String stParameter) throws Exception {
		ArrayList alParameters	=	new ArrayList(1);
		alParameters.add(stParameter);
		return lockRecord( connection , sql,  alParameters);
	}
	protected boolean lockRecord(Connection connection , String sql, String[] stParameters) throws Exception {
		ArrayList alParameters	=	new ArrayList(stParameters.length);
		for (int i=0;i< stParameters.length;i++ ) {
			alParameters.add(stParameters[i]);	
		}
		return lockRecord(connection ,  sql,  alParameters);
	}

	protected boolean lockRecord(Connection connection , String sql, ArrayList alParameters) throws Exception {
		boolean bRecordLocked	=	true;
		try { 
			fetchRecord(connection , sql, alParameters);
		}
		catch(SQLException sQLException) {
			sQLException.printStackTrace();
			if(sQLException.getErrorCode()==54) {
				bRecordLocked	=	false;
			}
			else {
				throw sQLException;
			}
        }
		catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
		return bRecordLocked;
	}
	
	protected boolean setData(PreparedStatement preparedStatement, ArrayList alData) { 
		Object []objects	=	new Object[alData.size()];
		for(int index = 0; index < alData.size(); index++) {
			objects[index]=alData.get(index);
		}
		return 	setData(preparedStatement,objects);
	}
	
	protected boolean setData(PreparedStatement preparedStatement, Object objFields[]) {
        boolean	returnValue	=	true;
		try {
            for(int index = 0; index < objFields.length; index++) {
				if(objFields[index] instanceof Date) {
                    preparedStatement.setDate(index + 1, (Date)objFields[index]);
				}			
				else if(objFields[index] instanceof Timestamp) {
                    preparedStatement.setTimestamp(index + 1, (Timestamp)objFields[index]);
				}
				else if(objFields[index] instanceof String) {
					//System.out.println("String Before "+ (String)objFields[index]);
                     preparedStatement.setString(index + 1, (String)objFields[index]);
					//System.out.println("String After "+ (String)objFields[index]);
				}				
				else if(objFields[index] instanceof Integer) {
					preparedStatement.setInt(index + 1, ((Integer)objFields[index]).intValue());
				}
				else if(objFields[index] instanceof Long) {
                    preparedStatement.setLong(index + 1, ((Long)objFields[index]).longValue());
				}
				else if(objFields[index] instanceof Double) {
                    preparedStatement.setDouble(index + 1, ((Double)objFields[index]).doubleValue());
				}
                else if(objFields[index] instanceof Float) {
                    preparedStatement.setFloat(index + 1, ((Float)objFields[index]).floatValue());
				}
            }
        }
        catch(Exception exception) {
			//System.out.println("String exception "+ exception.printStackTrace());
            exception.printStackTrace();
			returnValue	=	false;
        }
        return returnValue;
    }

	protected HashMap getMessageHashMap(boolean bFlag) { 
		HashMap hmReturn	=	new HashMap();
		hmReturn.put(RESULT,bFlag?TRUE:FALSE);
		hmReturn.put(MESSAGE,"[Method body under development]Dummy Message for result: "+bFlag);
		hmReturn.put(MSGID,"BODY_NOT_DEFINED");
		return hmReturn;
	}

	protected void throwExceptionWhenFailed(HashMap hmResult) throws Exception {
		if(!((Boolean)hmResult.get(RESULT)).booleanValue()) {
			throw new Exception((String)hmResult.get(MESSAGE));
		}
	}

	//common method to insert data into St_item_trn_dtl table
	public void insertTrnDtl( Connection connection,ArrayList alCommonData,String  stSQL) throws Exception {
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
//		ArrayList	alHdrData	=	new ArrayList();
		HashMap	hmReturn =	new HashMap();
		hmArgData.put(DATA,alCommonData);
		hmArgSQL.put(BATCH_SQL,stSQL);
		hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
		throwExceptionWhenFailed(hmReturn);
	}

	protected String DATA          =	"DATA" ;
	protected String BATCH_SQL    =	"BATCH_SQL" ;
	protected String DELETE_SQL    =	"DELETE_SQL" ;
	protected String INSERT_SQL    =	"INSERT_SQL" ;
	protected String UPDATE_SQL    =	"UPDATE_SQL" ;
	protected String MSGID			=	"msgid" ;
	protected String MESSAGE       =	"message" ;
	protected String RESULT        =	"result" ;
	protected Boolean TRUE         =	new Boolean(true) ;
	protected Boolean FALSE        =	new Boolean(false) ;
//	protected String MODE_DELETE			=	"0" ;
//  protected String MODE_INSERT			=	"1" ;
//   protected String MODE_MODIFY			=	"2" ;
//	protected String RECORD_ALREADY_LOCKED  =	"RECORD_ALREADY_LOCKED" ;
	protected String CODE_ALREADY_EXISTS    =	"CODE_ALREADY_EXISTS" ;
    protected String RECORD_INSERTED        =	"RECORD_INSERTED" ;
    protected String RECORD_MODIFIED        =	"RECORD_MODIFIED" ;
    protected String RECORD_DELETED         =	"RECORD_DELETED";


	/**
	* Method to update st_item_store and mm_item tables
	* @param connection, the connection object
	* @param hmSQL, hashmap containing all the quesries needed for this routine
	* @param hmParameters, hashmap containing all the values needed.
	*/
	
	public void calculateAndUpdateOnlineStock (Connection connection, HashMap hmSQL, HashMap hmParameters) throws Exception {
		/**
		* Approach : A transaction may involve two stores or a single store. 
		* The variale store_code represents the from_store_code - this will be passed from
		* all the transactions
		* The variable to_store_code is optional and it will be passed from only the 
		* transactions which involves two stores.
		*/

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		HashMap hmReturn		=	new HashMap();
		HashMap hmResult		=	new HashMap();
		ArrayList alData		=	new ArrayList();
		String stSQL			=	"";

		String p_item_code			= checkForNull (hmParameters.get("item_code")); 
		String p_from_store_code	= checkForNull (hmParameters.get("store_code"));
		String p_trn_type			= checkForNull (hmParameters.get("trn_type"));

		String p_bin_location_code	= checkForNull (hmParameters.get("to_bin_location_code")); 

		String p_last_receipt_date	= checkForNull (hmParameters.get("last_receipt_date"));
		String p_last_issue_date	= checkForNull (hmParameters.get("last_issue_date"));
		String p_login_by_id		= checkForNull (hmParameters.get("login_by_id"));
		String p_login_at_ws_no		= checkForNull (hmParameters.get("login_at_ws_no"));
		String p_login_facility_id	= checkForNull (hmParameters.get("login_facility_id"));
		String p_from_stk_item_yn	= checkForNull (hmParameters.get("from_stk_item_yn"));
		String p_to_stk_item_yn		= checkForNull (hmParameters.get("to_stk_item_yn"));
	//	String locale				= checkForNull (hmParameters.get("language_id"));
	    String close_req_yn         = checkForNull (hmParameters.get("close_req_yn"));
		Double authorized_item_qty = hmParameters.get("authorized_item_qty")==null? new Double("0"):(Double)hmParameters.get("authorized_item_qty");
		//System.out.println("authorized_item_qty 541======>" +authorized_item_qty);
		
		String p_to_store_code		= null;

		System.out.println("StEjbSessionAdapter.java 543,hmParameters "+hmParameters);
		
	
		if(hmParameters.get("to_store_code") != null) {
			p_to_store_code = (String) hmParameters.get("to_store_code");
		}
		/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications all int declaration change to double

		**/
		int no_of_decimals= getNoOfDecimals( connection);
		double mm_trn_qty				= 0;
		double mm_trn_qty_temp			= 0;
		double p_trn_qty				= Double.parseDouble((String)hmParameters.get("trn_qty"));
		if(hmParameters.containsKey("mm_trn_qty"))
			mm_trn_qty_temp			= Double.parseDouble((String)hmParameters.get("mm_trn_qty"));
		double p_to_str_qty = 0;
		if(hmParameters.containsKey("to_str_qty"))
			p_to_str_qty			= Double.parseDouble((String)hmParameters.get("to_str_qty"));
		//double p_trn_value			= Double.parseDouble((String)hmParameters.get("trn_value"));
    //    System.out.println("StEjbSessionAdapter.java 564,before Trn_value");
		double p_trn_value			= Double.parseDouble((String)hmParameters.get("trn_value")==null?"0.00":(String)hmParameters.get("trn_value"));
	//	System.out.println("StEjbSessionAdapter.java 566,after Trn_value");
//		double p_trn_unit_cost		= Double.parseDouble((String)hmParameters.get("trn_unit_cost"));

		int iterations = (p_to_store_code == null)?1:2;

		String curr_store_code			= null;
		String curr_trn_stk_item_yn		= null;	  
		String l_stk_item_yn			=	null;
		String curr_bin_location_code	=null;
		String curr_last_issue_date		=null;
		String curr_last_receipt_date	=null;
	    String mode						= checkForNull (hmParameters.get("mode"));
 //   	System.out.println("mode....in StEJBSessionAdapter...."+mode);
//    	StringBuffer NegativeItemsDesc = new StringBuffer(); commented for unused variable on Wednesday, October 19, 2011

		for(int i=0;i<iterations;i++) {
			/*
			* As the same logic is applicable for both the stores, the following variable is used to hold 
			* the current store_code under process.
			*/
			if(i==0 && p_to_store_code != null)
			{
				  p_trn_value			=	Double.parseDouble(checkForNull((String)hmParameters.get("fm_trn_value"),(String)hmParameters.get("trn_value")));
			}
			else
			{
				//p_trn_value           = Double.parseDouble((String)hmParameters.get("trn_value"));
				  p_trn_value			= Double.parseDouble((String)hmParameters.get("trn_value")==null?"0.00":(String)hmParameters.get("trn_value"));

			}

			curr_store_code			= (i==0)?p_from_store_code:p_to_store_code;
			double curr_trn_qty		= (i==0 && p_to_store_code != null )?(- p_trn_qty):p_trn_qty;
			mm_trn_qty				= (i==0 && p_to_store_code != null )?(- mm_trn_qty_temp):mm_trn_qty_temp;
			double curr_trn_value	= (i==0 && p_to_store_code != null )?(- p_trn_value):p_trn_value;
			curr_trn_stk_item_yn	= (i==0)?p_from_stk_item_yn:p_to_stk_item_yn;  
			curr_trn_qty			= (i==1)?p_to_str_qty:curr_trn_qty;  

			// stSQL	=	(String)hmSQL.get ("ItemStoreStkPosSelectSQL"); 

			//stSQL = "SELECT nvl(qty_on_hand,0) qty_on_hand, nvl(item_value,0) item_value, stock_item_yn FROM st_item_store WHERE item_code=? AND store_code=?";
			// ItemStoreStkPosSelectSQL - SQL_ST_GET_ITEM_STORE_STOCK_POS - query to be changed

			//stSQL	= " SELECT sum( nvl(b.qty_on_hand,0)- nvl(COMMITTED_QTY,0)) qty_on_hand, nvl(b.item_value,0) item_value, stock_item_yn from st_item_batch a,st_item_store b where a.STORE_CODE = b.STORE_CODE and a.ITEM_CODE = b.ITEM_CODE and b.item_code = ? AND b.store_code= ? group by b.ITEM_CODE ,b.STORE_CODE,item_value,stock_item_yn ";


			if(mode.equals("MODE_MODIFY"))
			{
				
	//	System.out.println("mode -->inside the if .java,595,hmResult = > "+mode);
	//	System.err.println("mode -->inside the if.java,595,hmResult = > "+mode);
				//stSQL	= "SELECT SUM (NVL (a.qty_on_hand, 0)) qty_on_hand,NVL (b.item_value, 0) item_value, stock_item_yn FROM st_item_batch a, st_item_store b WHERE a.store_code(+) = b.store_code AND a.item_code(+)= b.item_code AND b.item_code = ? AND b.store_code = ? GROUP BY b.item_code, b.store_code, item_value, stock_item_yn";
				stSQL	= "SELECT SUM (NVL (a.qty_on_hand, 0)) qty_on_hand,NVL (b.item_value, 0) item_value, stock_item_yn , sum(NVL (a.qty_on_hand, 0)) store_qty_on_hand  FROM st_item_batch a, st_item_store b WHERE a.store_code(+) = b.store_code AND a.item_code(+)= b.item_code AND b.item_code = ? AND b.store_code = ? GROUP BY b.item_code, b.store_code, item_value, stock_item_yn";
			}
			else
			{
		
	//	System.out.println("mode -->else.java,595,hmResult = > "+mode);
	//	System.err.println("mode -->else.java,595,hmResult = > "+mode);
		
				//stSQL	= "SELECT SUM (NVL (a.qty_on_hand, 0) - NVL (committed_qty, 0)) qty_on_hand,NVL (b.item_value, 0) item_value, stock_item_yn FROM st_item_batch a, st_item_store b WHERE a.store_code(+) = b.store_code AND a.item_code(+)= b.item_code AND b.item_code = ? AND b.store_code = ? GROUP BY b.item_code, b.store_code, item_value, stock_item_yn";
				stSQL	= "SELECT SUM (NVL (a.qty_on_hand, 0) - NVL (committed_qty, 0)) qty_on_hand,NVL (b.item_value, 0) item_value, stock_item_yn ,sum(NVL (a.qty_on_hand, 0)) store_qty_on_hand FROM st_item_batch a, st_item_store b WHERE a.store_code(+) = b.store_code AND a.item_code(+)= b.item_code AND b.item_code = ? AND b.store_code = ? GROUP BY b.item_code, b.store_code, item_value, stock_item_yn";

			}

			
			alData.clear();

			alData.add(p_item_code);
			alData.add(curr_store_code);

//			hmResult =new HashMap();

			hmResult = fetchRecord(connection, stSQL, alData);

			/*Local variables to hold the selected values */

			System.out.println("StEJBSessionAdapter.java,633,hmResult = > "+hmResult);
			//System.out.println("StEJBSessionAdapter.java,634,stSQL = > "+stSQL);
			System.out.println("StEJBSessionAdapter.java,635,alData = > "+alData);

			double l_qty_on_hand		= 0;
				
			if(hmResult.get("QTY_ON_HAND") != null) {
				l_qty_on_hand = Double.parseDouble((String)(hmResult.get("QTY_ON_HAND")));
			}

			double l_stk_value		= 0.0;
			if(hmResult.get("ITEM_VALUE") != null) {					
				l_stk_value	= Double.parseDouble((String)(hmResult.get("ITEM_VALUE")));	
			}

			l_stk_item_yn	= "N";
			if(hmResult.get("STOCK_ITEM_YN") != null) {	
				l_stk_item_yn = (String)hmResult.get("STOCK_ITEM_YN");	
			}

			
			double l_store_qty_on_hand		= 0; 
			
			if(hmResult.get("STORE_QTY_ON_HAND") != null) {
				l_store_qty_on_hand = Double.parseDouble((String)(hmResult.get("STORE_QTY_ON_HAND")));
			}


			double l_unit_cost		= 0.0;

			if(l_stk_value != 0.0 && l_qty_on_hand != 0.0) {
				l_unit_cost = l_stk_value / l_qty_on_hand;
			}
			l_unit_cost=l_unit_cost+0.0000005;
			l_unit_cost*=1000000;
			l_unit_cost=(long)l_unit_cost;
			l_unit_cost/=1000000;

			if(!(curr_trn_stk_item_yn.equals(l_stk_item_yn))) {
				throw new Exception("STOCK_ITEM_FLAG_CHANGED");   // Message to be added
			}
			
			if(l_qty_on_hand != 0 && p_trn_type.equals("OBS"))  {
				throw new Exception("DUPLICATE_IN_OPENING_STOCK");
			}
			/* =======  Code added on 11/9/2006 Reason : During Multiplication of unit cost with qty..due to round off figures sometimes the cost difference occurs in their decimal places( 2nd or 3rd  decimal place), so to avoid that database cost is set to current transaction value only if the qty goes to zero*/	
			
			if (l_qty_on_hand+curr_trn_qty == 0)
			{
				if (l_stk_value+curr_trn_value <0)
				{
					curr_trn_value = -l_stk_value;
				}
			}
			/* ======= End for cost assignment 11/9/2006*/
			if(curr_trn_stk_item_yn.equals("Y")) {
                             	double qty = l_qty_on_hand+curr_trn_qty;
				double qtyValue = l_stk_value+curr_trn_value;

				if(qty < 0  && qtyValue < 0)
				{
					l_stk_value = 0;
				}
				// Update mm_item
				System.out.println("l_qty_on_hand = > "+l_qty_on_hand+" curr_trn_qty = > "+curr_trn_qty+" l_stk_value = > "+l_stk_value+" curr_trn_value = > "+curr_trn_value);
				if( ( l_qty_on_hand+curr_trn_qty < 0) || (l_stk_value+curr_trn_value < 0)) {
					//System.err.println("= NEGATIVE_STOCK CHECK1   l_qty_on_hand="+l_qty_on_hand);
					//System.err.println("= NEGATIVE_STOCK CHECK1   curr_trn_qty="+curr_trn_qty);
					//System.err.println("= NEGATIVE_STOCK CHECK1   l_stk_value="+l_stk_value);
					//System.err.println("= NEGATIVE_STOCK CHECK1   curr_trn_value="+curr_trn_value);
					//System.err.println("= NEGATIVE_STOCK CHECK1   Query executed for l_qty_on_hand and l_stk_value stSQL="+stSQL +"======= Data="+alData +" ====Result hmResult="+hmResult);
					//System.err.println("= NEGATIVE_STOCK CHECK1   values for curr_trn_qty and curr_trn_value  hmParameters="+hmParameters);
					//NegativeItemsDesc.append("");
					//System.out.println("EjbSessionAdapater,p_item_code = > "+p_item_code);
					//NegativeItemsDesc.append(p_item_code);
					//NegativeItemsDesc.append(" , ");		 */
					throw new Exception("NEGATIVE_STOCK");
				}
// removed on Monday, May 10, 2004 to update the mm_unit_cost from each transaction.
//				if(l_unit_cost != p_trn_unit_cost) {
					stSQL	=	(String)hmSQL.get ("ItemCostValueSelectSQL");

					//stSQL = "SELECT SUM(st.QTY_ON_HAND * (SELECT eqvl_value FROM MM_ITEM_UOM_DEFN mid WHERE st.def_issue_uom = mid.eqvl_uom_code AND  mm.gen_uom_code = mid.uom_code AND mid.item_code = st.item_code UNION SELECT eqvl_value FROM am_uom_eqvl WHERE st.def_issue_uom = eqvl_uom_code AND  mm.gen_uom_code = uom_code))qty_on_hand , SUM(st.item_value) item_value  FROM st_item_store st, mm_item_lang_vw mm   WHERE st.item_code = ?   AND st.item_code = mm.item_code  AND mm.language_id = ?";
					// ItemCostValueSelectSQL - SQL_ST_ITEM_VALUE_SELECT 
//Changed By Mahesh to avoid Invalid Column Index in error log.....this is because PH has not completed their Variable UOM..					
					alData.clear();			
					if(stSQL.equals("select sum(QTY_ON_HAND) qty_on_hand, sum(item_value) item_value FROM st_item_store WHERE item_code = ? group by item_code")){
						alData.add(p_item_code);
					}
					else{
						alData.add(p_item_code);
						//alData.add(locale);
					}
					hmResult = fetchRecord(connection,stSQL,alData);

                    System.out.println("StEjbSessionAdapter.java 719,hmResult "+hmResult);
					double l_sum_of_qty_on_hand	= 0;
					double l_sum_cur_stk_value	= 0.0;

					if(hmResult.get("QTY_ON_HAND") != null) {															
						l_sum_of_qty_on_hand		=	Double.parseDouble((String)(hmResult.get("QTY_ON_HAND")));
					}
					if(hmResult.get("ITEM_VALUE") != null) {
						l_sum_cur_stk_value			=	Double.parseDouble((String)(hmResult.get("ITEM_VALUE")));
					}

					double l_cur_unit_cost = 0;
					try
					{
					    //l_cur_unit_cost = (l_sum_cur_stk_value + curr_trn_value) / (((l_sum_of_qty_on_hand + curr_trn_qty)==0)?1:(l_sum_of_qty_on_hand + curr_trn_qty));
					    l_cur_unit_cost = (l_sum_cur_stk_value + curr_trn_value) / (((l_sum_of_qty_on_hand + mm_trn_qty)==0)?1:(l_sum_of_qty_on_hand + mm_trn_qty));
						if (Double.isInfinite(l_cur_unit_cost))
						{
							l_cur_unit_cost =0;
						}
					}
					catch ( Exception e)
					{
						e.printStackTrace();
					}
			/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost and round up l_cur_unit_cost with noOfDecimalsForCost 
			 */
			int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost(connection));
			l_cur_unit_cost=Double.parseDouble(setNumber(""+l_cur_unit_cost,noOfDecimalsForCost));



					alData.clear();
//added during merging
					stSQL = " select * from mm_item where ITEM_CODE = ? for update nowait ";
					alData.add(p_item_code);
					hmResult = fetchRecord(connection,stSQL,alData);

					alData.clear();
					alData.add(Double.toString(l_cur_unit_cost));
					alData.add(p_trn_type);
					alData.add(p_login_by_id);
					alData.add(p_login_at_ws_no);
					alData.add(p_login_facility_id);
					alData.add(p_item_code);
					//update st_item_store

					stSQL = (String)hmSQL.get ("ItemMasterUpdateSQL");

					// ItemMasterUpdateSQL - SQL_ST_ITEM_MASTER_UPDATE
					//System.out.println(" l_cur_unit_cost in 773 in StEJBSessionAdapter....."+l_cur_unit_cost);
					if (l_cur_unit_cost<0){
						
						//System.err.println("=NEGATIVE_STOCK CHECK2 l_cur_unit_cost="+l_cur_unit_cost);
						//System.err.println("=NEGATIVE_STOCK CHECK2 l_sum_cur_stk_value="+l_sum_cur_stk_value+"==curr_trn_value="+curr_trn_value+"===l_sum_of_qty_on_hand="+l_sum_of_qty_on_hand+"====curr_trn_qty="+curr_trn_qty+"===l_sum_of_qty_on_hand="+l_sum_of_qty_on_hand+"===curr_trn_qty"+curr_trn_qty);     // SEP for Line 694
						//System.out.println("=NEGATIVE_STOCK CHECK2 l_cur_unit_cost="+l_cur_unit_cost);
						System.out.println("=NEGATIVE_STOCK CHECK2 l_sum_cur_stk_value="+l_sum_cur_stk_value+"==curr_trn_value="+curr_trn_value+"===l_sum_of_qty_on_hand="+l_sum_of_qty_on_hand+"====curr_trn_qty="+curr_trn_qty+"===l_sum_of_qty_on_hand="+l_sum_of_qty_on_hand+"===curr_trn_qty"+curr_trn_qty+"==l_cur_unit_cost="+l_cur_unit_cost);     // SEP for Line 694
						hmResult.put(MESSAGE,"NEGATIVE_STOCK");
						throw new Exception("NEGATIVE_STOCK");
					}
								
					
					hmArgData.put(DATA,alData);
					hmArgSQL.put(UPDATE_SQL,stSQL);
			
					hmReturn	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);
//				}
				

				// update st_item_store

				stSQL	=	(String)hmSQL.get ("ItemStoreQtyUpdateSQL");
				
				//stSQL = "UPDATE st_item_store SET bin_location_code = decode (?,NULL,bin_location_code,?) , last_receipt_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_receipt_date,TO_DATE(?,'dd/mm/yyyy')) , last_issue_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_issue_date,TO_DATE(?,'dd/mm/yyyy')), pending_req_qty = decode(?,0,pending_req_qty,(pending_req_qty-?)), qty_on_hand = ? , item_value = ?  ,modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id = ?  WHERE item_code = ? AND store_code = ?";

				// ItemStoreQtyUpdateSQL - SQL_ST_ITEM_STORE_UPDATE - to be changed

				//l_qty_on_hand	=	l_qty_on_hand+curr_trn_qty; commetened by ganga
				System.out.println("StEJBS 821=>l_qty_on_hand="+l_qty_on_hand);
				System.out.println("StEJBS 822=>l_store_qty_on_hand="+l_store_qty_on_hand);
				System.out.println("StEJBS 823=>l_stk_value="+l_stk_value);

				l_qty_on_hand	     =  l_store_qty_on_hand + curr_trn_qty;
				l_stk_value			 =	l_stk_value+curr_trn_value;

				alData.clear();
				if(l_qty_on_hand==0 || l_stk_value<0 ){
					l_stk_value=0;
				}
				curr_bin_location_code	= (i==1 && p_trn_type.equals("ISS"))?p_bin_location_code:"";	
				curr_last_issue_date		= (i==0)?p_last_issue_date:"";
				curr_last_receipt_date	= (i==1)?p_last_receipt_date:"";
				if (p_trn_type.equals("GRN")) {
					curr_last_receipt_date	= p_last_receipt_date;
				}
				 
			//added by Rabbani and Ganga #inc no:27426 on 08/08/11 
				 
				double curr_pending_req_qty	= 0;
				double authorized_qty = authorized_item_qty.doubleValue();
				//System.out.println("authorized_qty 846======>" +authorized_qty);
				if (close_req_yn.equals("Y"))
				{
                curr_pending_req_qty		= (i==1 && p_trn_type.equals("ISS"))?authorized_qty:0;
				//System.out.println("curr_pending_req_qty 849======>" +curr_pending_req_qty);
				}
				/*else //commented by Rabbani on 10/04/12
				{
				curr_pending_req_qty		= (i==1 && p_trn_type.equals("ISS"))?curr_trn_qty:0;
				}*/ //10/04/12
				
				alData.add(curr_bin_location_code);
				alData.add(curr_bin_location_code);

				alData.add(curr_last_receipt_date);
				alData.add(curr_last_receipt_date);

				alData.add(curr_last_issue_date);
				alData.add(curr_last_issue_date);
				if(getAllowDecimalsYN( connection, p_item_code).equals("Y")){
				alData.add(setNumber(""+curr_pending_req_qty,no_of_decimals));
			    alData.add(setNumber(""+curr_pending_req_qty,no_of_decimals));
				alData.add(setNumber(""+l_qty_on_hand,no_of_decimals));
				}else{
				alData.add(setNumber(""+curr_pending_req_qty,0));
			    alData.add(setNumber(""+curr_pending_req_qty,0));
				alData.add(setNumber(""+l_qty_on_hand,0));
			
				}
				alData.add(Double.toString(l_stk_value));
				alData.add(p_login_by_id);
				alData.add(p_login_at_ws_no);
				alData.add(p_login_facility_id);
				alData.add(p_item_code);									 
				alData.add(curr_store_code);	
				hmArgData.put(DATA,alData);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				//System.out.println("StEjbSessionAdapter.java 882,hmArgData "+hmArgData);
				//System.out.println("StEjbSessionAdapter.java 884,stSQL "+stSQL);
				hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);

			

			}
		}

		/*System.out.println("NegativeItemsDesc --> " + NegativeItemsDesc);
		System.out.println("NegativeItemsDesc length--> " + NegativeItemsDesc.length());
		if(NegativeItemsDesc.length()>0){
			System.out.println("one item is having negative quantity");
			throw new Exception("NEGATIVE_STOCK"+NegativeItemsDesc.toString());
		}else{
			System.out.println("NO item is having negative quantity. proceed");
		}	*/
	}


	/**
	* Method to update st_batch_control and st_item_batch tables
	* @param connection, the connection object
	* @param hmSQL, hashmap containing all thequesries needed for this routine
	* @param hmParameters, hashmap containing all the values needed.
	*/

	public void updateBatchOnLine (Connection connection, HashMap hmSQL, HashMap hmParameters) throws Exception {
		/**
		* Approach : A transaction may involve two stores or a single store. 
		* The variale store_code represents the from_store_code - this will be passed from
		* all the transactions
		* The variable to_store_code is optional and it will be passed from only the 
		* transactions which involves two stores.
		*/




		HashMap hmReturn						= new HashMap();
		HashMap hmResult						= new HashMap();
		HashMap	hmArgData						= new HashMap();
		HashMap	hmArgSQL						= new HashMap();		
		ArrayList alData						= new ArrayList();
		String stSQL							= null;

		String p_item_code						= checkForNull (hmParameters.get("item_code")); 
		String p_from_store_code				= checkForNull (hmParameters.get("store_code")); 
		String p_trn_type						= checkForNull (hmParameters.get("trn_type")); 

		String p_batch_id						= checkForNull (hmParameters.get("batch_id")); 
		String p_expiry_date_or_receipt_date	= checkForNull (hmParameters.get("expiry_date_or_receipt_date"));
		String p_trade_id						= checkForNull (hmParameters.get("trade_id")); 

		String p_from_bin_location_code			= checkForNull (hmParameters.get("from_bin_location_code"));
		String p_to_bin_location_code			= checkForNull (hmParameters.get("to_bin_location_code"));
	
		// new parameter added
		String p_release_batch_yn				= checkForNull (hmParameters.get("release_batch_yn"));	

		String p_suspended_batch_allowed_yn		= checkForNull (hmParameters.get("suspended_batch_allowed_yn")); 
		

		String p_login_by_id					= checkForNull (hmParameters.get("login_by_id"));
		String p_login_at_ws_no					= checkForNull (hmParameters.get("login_at_ws_no"));
		String p_login_facility_id				= checkForNull (hmParameters.get("login_facility_id"));
		String p_last_receipt_date				= checkForNull (hmParameters.get("last_receipt_date")); 
		String p_last_issue_date				= checkForNull (hmParameters.get("last_issue_date")); 
		String p_to_store_code					= null;

		String p_grn_doc_type_code              = checkForNull (hmParameters.get("grn_doc_type_code"));
		String p_grn_doc_no						= checkForNull (hmParameters.get("grn_doc_no"));     
		String p_grn_doc_srl_no					= checkForNull (hmParameters.get("grn_doc_srl_no"));
		String p_grn_unit_cost_in_stk_uom		= checkForNull (hmParameters.get("grn_unit_cost_in_stk_uom")); 
		String p_po_no							= checkForNull (hmParameters.get("po_no")); 
		String replace_on_expiry_yn				= checkForNull (hmParameters.get("replace_on_expiry_yn"),"N"); 		
		String p_modified_date					= checkForNull (hmParameters.get("modified_date"),""); 
		String p_to_modified_date					= "";
		
		// added for opening bal barcode implementation
		String p_sale_price						= checkForNull (hmParameters.get("sale_price"),"");
		String p_barcode_id						= checkForNull (hmParameters.get("barcode_id"),""); 
		//added ended
		System.out.println("hmParameters=STEJB=945==>"+hmParameters);

		if(hmParameters.get("to_store_code") != null) {
			p_to_store_code	= (String) hmParameters.get("to_store_code");	
			p_to_modified_date	= checkForNull((String) hmParameters.get("to_modified_date"));	

		}
		/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications all int declaration change to double

		**/
		int no_of_decimals= getNoOfDecimals( connection);

		double p_trn_qty 	=	Double.parseDouble((String)hmParameters.get("trn_qty"));
	
		/**
		* Check whether an entry available in st_batch_control...if not insert it...
		*/
		
		stSQL = (String)hmSQL.get ("BatchExistsCheckSQL");
		// BatchExistsCheckSQL - SQL_ST_CHECK_BATCH_EXISTS

		alData.clear();
		alData.add(p_item_code);
		alData.add(p_batch_id);
		alData.add(p_expiry_date_or_receipt_date);

		hmResult		= fetchRecord(connection, stSQL, alData);
		
		int batch_count	= Integer.parseInt((String)(hmResult.get("COUNT")));


		if(batch_count == 0) { // Insert into batch control
			alData.clear();
			alData.add(p_item_code);
			alData.add(p_batch_id);
			alData.add(p_expiry_date_or_receipt_date);
			alData.add(p_trade_id);
			alData.add("A");   // batch status.hardcoded as A - active
			alData.add("0");   // discount percentage

			alData.add(p_login_by_id);
			alData.add(p_login_at_ws_no);
			alData.add(p_login_facility_id);
			alData.add(p_login_by_id);
			alData.add(p_login_at_ws_no);
			alData.add(p_login_facility_id);	
			// added for opening bal barcode implementation
			alData.add(p_sale_price);
			alData.add(p_barcode_id); 
			//added ended

			stSQL	=	(String)hmSQL.get ("BatchControlInsertSQL");
			// BatchControlInsertSQL - SQL_ST_BATCH_CONTROL_INSERT
			//System.out.println("alData->"+alData);
			//System.out.println("stSQL->"+stSQL);
			hmArgData.put(DATA,alData);
			hmArgSQL.put(INSERT_SQL,stSQL);

			try {


				hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}
			catch (Exception ex) {
				throw ex;
			}
		}

		int iterations = (p_to_store_code == null)?1:2;

		/*
		* As the same logic is applicable for both the stores, the following variable is used to hold 
		* the current store_code under process.
		*/		  		
			String curr_store_code			=null;
			String curr_bin_location_code	=null;
			String l_suspended_batch_yn=null;
			String curr_last_issue_date		=null;
			String curr_last_receipt_date	=null;
			String curr_modified_date	="";


		for(int i=0;i<iterations;i++) {

			/**
			* Create an entry in st_item_batch if the entry is not available already...
			* if an entry is there update it....
			* if the qty_on_hand+trn_qty is 0, then delete the record...
			*/

			curr_store_code			=	(i==0)?p_from_store_code:p_to_store_code;
			curr_bin_location_code	=	(i==0)?p_from_bin_location_code:p_to_bin_location_code;
			curr_modified_date		=	(i==0)?p_modified_date:p_to_modified_date;
			double curr_trn_qty				=	(i==0 && p_to_store_code != null )?(- p_trn_qty):p_trn_qty;
			int item_batch_count			=	0;
// added by manish on Monday, January 26, 2004
//			if (i==1) {
				String sql = eST.Common.StEJBRepository.getStKeyValue("SQL_ST_GET_ITEM_STORE_STOCK_POS");
				ArrayList alStkYN	=	new ArrayList();
				alStkYN.add(p_item_code);
				alStkYN.add(curr_store_code);
				HashMap hmStkYN					= fetchRecord(connection, sql, alStkYN);
				String to_stk_item_yn	= (String)hmStkYN.get("STOCK_ITEM_YN"); 
				if (to_stk_item_yn.equals("N")) {
					continue;
				}
//			}

// added ends

					ArrayList temp = new ArrayList();
					temp.add(curr_store_code);
					temp.add(p_item_code);
					temp.add(p_batch_id);
					temp.add(curr_bin_location_code);
					temp.add(p_expiry_date_or_receipt_date);

                    String sql_multi_user_chk = "Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy') ";
                  
					 HashMap result_multi_chk = fetchRecord(connection,sql_multi_user_chk,temp);


			stSQL	=	(String)hmSQL.get ("ItemBatchExistsCheckSQL");
			// ItemBatchExistsCheckSQL - SQL_ST_CHECK_ITEM_BATCH_EXISTS

			alData.clear();
			alData.add(curr_store_code);
			alData.add(p_item_code);
			alData.add(p_batch_id);
			alData.add(curr_bin_location_code);
			alData.add(p_expiry_date_or_receipt_date);

			hmResult = fetchRecord(connection, stSQL, alData);

			item_batch_count	= Integer.parseInt((String)hmResult.get("COUNT"));
			
			if(item_batch_count == 0) {
				if(curr_trn_qty >= 0) {
					stSQL	=	(String)hmSQL.get ("ItemBatchInsertSQL");
					// ItemBatchInsertSQL - SQL_ST_ITEM_BATCH_INSERT
					// stSQL = "INSERT into st_item_batch (store_code, item_code, batch_id,	bin_location_code, expiry_date_or_receipt_date,trade_id, qty_on_hand, replace_on_expiry_yn, GRN_DOC_TYPE_CODE, GRN_DOC_NO, GRN_DOC_SRL_NO, GRN_UNIT_COST_IN_STK_UOM, added_by_id,	added_date,	added_at_ws_no,	added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) VALUES (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					curr_last_issue_date		= (i==0)?p_last_issue_date:"";
					curr_last_receipt_date	= (i==1)?p_last_receipt_date:"";
					if (p_trn_type.equals("GRN")) {
						curr_last_receipt_date	= p_last_receipt_date;

					}
					alData.clear();
					alData.add(curr_store_code);
					alData.add(p_item_code);
					alData.add(p_batch_id);
					alData.add(curr_bin_location_code);
					alData.add(p_expiry_date_or_receipt_date);
					alData.add(p_trade_id);
					alData.add((String)hmParameters.get("trn_qty"));    // qty_on_hand
					alData.add(replace_on_expiry_yn);		   // replace_on_expiry_yn
					alData.add(p_grn_doc_type_code); // grn_doc_type_code
					alData.add(p_grn_doc_no); // grn_doc_no
					alData.add(p_grn_doc_srl_no); // grn_doc_srl_no
					alData.add(p_grn_unit_cost_in_stk_uom); // grn_unit_cost_in_stk_uom
					alData.add(curr_last_issue_date); // curr_last_issue_date
					alData.add(curr_last_receipt_date); // curr_last_receipt_date
					alData.add(p_po_no); // po_no

					alData.add(p_login_by_id);
					alData.add(p_login_at_ws_no);
					alData.add(p_login_facility_id);
					alData.add(p_login_by_id);
					alData.add(p_login_at_ws_no);
					alData.add(p_login_facility_id);	
					alData.add(p_barcode_id);
					

					hmArgData.put(DATA,alData);
					hmArgSQL.put(INSERT_SQL,stSQL);

					try {


						hmReturn	=	insert(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmReturn);
					}
					catch (Exception e) {
						throw e;
					}
				}
				else {
					throw new Exception("RECORD_UPDATED_BY_OTH_USER"); // BATCH_RECORD_NOT_FOUND
				}
			}
			else {
				
				
				if(p_trn_type.equals("OBS"))  {
					throw new Exception("DUPLICATE_IN_OPENING_STOCK");
				}

				stSQL			=	(String)hmSQL.get ("ItemBatchStcPosSelectSQL");
				// ItemBatchStcPosSelectSQL - SQL_ST_GET_ITEM_BATCH_STOCK_POS

				alData.clear();
				alData.add(curr_store_code);
				alData.add(p_item_code);
				alData.add(p_batch_id);
				alData.add(curr_bin_location_code);
				alData.add(p_expiry_date_or_receipt_date);

				hmResult		=	fetchRecord(connection, stSQL, alData);	  

				l_suspended_batch_yn	=	"N";
				
				if(hmResult.get("SUSPENDED_YN") != null) {
					l_suspended_batch_yn = (String)hmResult.get("SUSPENDED_YN");
				}													  

				double l_qty_on_hand			=	0;

				if(hmResult.get("QTY_ON_HAND") != null) {
					
					l_qty_on_hand = Double.parseDouble((String)(hmResult.get("QTY_ON_HAND")));
				}

				  if(l_suspended_batch_yn.equals("Y") && p_suspended_batch_allowed_yn.equals("N")) {
					throw new Exception("SUSPENDED_BATCH"); // Message to be added
				}  

				l_qty_on_hand	=l_qty_on_hand+ curr_trn_qty;

				if (l_qty_on_hand < 0) { 
				/*	System.err.println("=NEGATIVE_STOCK CHECK3 l_qty_on_hand="+l_qty_on_hand);
					System.err.println("=NEGATIVE_STOCK CHECK3 curr_trn_qty="+curr_trn_qty);
					System.err.println("=NEGATIVE_STOCK CHECK3 Query Executed for l_qty_on_hand stSQL="+stSQL+"== Data="+alData+"==== Result="+hmResult);
					System.err.println("=NEGATIVE_STOCK CHECK3 for curr_trn_qty	hmParameters ="+hmParameters);	*/
					throw new Exception("NEGATIVE_STOCK");
				}

				else if(l_qty_on_hand == 0) {					
					// Delete that particular batch from st_item_batch as the quantity is zero.

					stSQL			= (String)hmSQL.get ("ItemBatchDeleteSQL");
					// ItemBatchDeleteSQL - SQL_ST_ITEM_BATCH_DELETE

					alData.clear();
					alData.add(curr_store_code);
					alData.add(p_item_code);
					alData.add(p_batch_id);
					alData.add(curr_bin_location_code);
					alData.add(p_expiry_date_or_receipt_date);

					hmArgData.put(DATA,alData);
					hmArgSQL.put(DELETE_SQL,stSQL);

					try {


						hmReturn		=	delete(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmReturn);
					}
					catch (Exception e) {
						throw e;	
					}
				}
				else {
					curr_last_issue_date		= (i==0)?p_last_issue_date:"";
					curr_last_receipt_date	= (i==1)?p_last_receipt_date:"";
					if (p_trn_type.equals("GRN")) {
						curr_last_receipt_date	= p_last_receipt_date;

					}
					double curr_release_qty			=	0;

					if(p_release_batch_yn.equals("Y") && curr_trn_qty < 0) {
						curr_release_qty			=	curr_trn_qty;
					}

					
												
					stSQL	=	(String)hmSQL.get ("ItemBatchUpdateSQL");		
					
					//stSQL = "UPDATE st_item_batch SET qty_on_hand = ? , committed_qty = committed_qty + nvl(?,0) , last_receipt_date = decode (TO_DATE(?,'dd/mm/yyyy'),NULL,last_receipt_date,TO_DATE(?,'dd/mm/yyyy')), last_issue_date	= decode (TO_DATE(?,'dd/mm/yyyy'), NULL, last_issue_date, TO_DATE(?,'dd/mm/yyyy')), GRN_DOC_TYPE_CODE = ?, GRN_DOC_NO = ?, GRN_DOC_SRL_NO = ?, GRN_UNIT_COST_IN_STK_UOM = ?, modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ? , modified_facility_id =	?  WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy') ";
				
					// ItemBatchUpdateSQL - SQL_ST_ITEM_BATCH_UPDATE
					
// select modified_by_id and To_char(modified_date,'dd/mm/yyyy hh24:mm:ss')  




					alData.clear();
					if(getAllowDecimalsYN( connection, p_item_code).equals("Y")){
					alData.add(setNumber(""+l_qty_on_hand,no_of_decimals));
					alData.add(setNumber(""+curr_release_qty,no_of_decimals));
					}else{
					alData.add(setNumber(""+l_qty_on_hand,0));
					alData.add(setNumber(""+curr_release_qty,0));
			
					}
					alData.add(curr_last_receipt_date);
					alData.add(curr_last_receipt_date);

					alData.add(curr_last_issue_date);
					alData.add(curr_last_issue_date);

					alData.add(p_grn_doc_type_code); // grn_doc_type_code
					alData.add(p_grn_doc_no); // grn_doc_no
					alData.add(p_grn_doc_srl_no); // grn_doc_srl_no
					alData.add(p_grn_unit_cost_in_stk_uom); // grn_unit_cost_in_stk_uom


					alData.add(p_login_by_id);
					alData.add(p_login_at_ws_no);
					alData.add(p_login_facility_id);	

					alData.add(curr_store_code);
					alData.add(p_item_code);
					alData.add(p_batch_id);
					alData.add(curr_bin_location_code);
					alData.add(p_expiry_date_or_receipt_date);

					hmArgData.put(DATA,alData);
					hmArgSQL.put(UPDATE_SQL,stSQL);

					                    
					try {
	                
					    
						if((((String)result_multi_chk.get("MODIFIED_DATE")).equals(curr_modified_date)) || ((curr_modified_date.equals(""))))
						{

						hmReturn		=	update(connection, hmArgData, hmArgSQL);
						
						
						
						}else
						{


                           hmReturn.put(RESULT,FALSE);
//added during merging
		                   hmReturn.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");
		                   hmReturn.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER");
                          throwExceptionWhenFailed(hmReturn);

						}
					}
					catch (Exception e) {
						throw e;
					}
				}
			}
		}
//added during merging
	}

//Method responsible for Block Release of batch added on Thursday, July 31, 2003 3:15 PM
	public HashMap blockReleaseBatch(Connection connection, HashMap hmParameter, HashMap hmSQL, char blockReleaseFlag){
		return blockReleaseBatch(connection, hmParameter, blockReleaseFlag);
	}
	public HashMap blockReleaseBatch(Connection connection, HashMap hmParameter, char blockReleaseFlag){
	
	System.out.println("blockReleaseBatch");

        

		HashMap hmArgData		=	new HashMap();
		HashMap hmArgSQL		=	new HashMap();
		HashMap hmResult		=	new HashMap();
		ArrayList alParameters	=	new ArrayList();
		ArrayList alparamcount	=	new ArrayList();
		String store_code		=	(String)hmParameter.get("store_code");
		String item_code		=	(String)hmParameter.get("item_code");
		String batch_id			=	(String)hmParameter.get("batch_id");
		String bin_location_code=	(String)hmParameter.get("bin_location_code");
		String expiry_date_or_receipt_date	=	(String)hmParameter.get("expiry_date_or_receipt_date");
		String trn_qty	=	(String)hmParameter.get("trn_qty");

		String login_by_id			=	(String)hmParameter.get("login_by_id");
		String login_at_ws_no		=	(String)hmParameter.get("login_at_ws_no");
		String login_facility_id	=	(String)hmParameter.get("login_facility_id");
		String p_modified_date		=    checkForNull (hmParameter.get("modified_date"),"");
		System.out.println("p_modified_date:ejbsession===1344=>" +p_modified_date);
		String Item_desc = "";
		String[]stParameter={store_code,item_code,batch_id,bin_location_code,expiry_date_or_receipt_date};
		int no_of_decimals=getNoOfDecimals( connection);
		//String disp_decimal_dtls_yn=getDispDecimalDtlsYN( connection);

		try {
			if (blockReleaseFlag=='R')
				trn_qty="-"+trn_qty;
			else if (blockReleaseFlag=='B'){
			}
			else{
				throw new Exception("INVALID_FLAG_FOR_BLOCK_RELEASE");
			}

         
            HashMap hmSelect = new HashMap(); 

            try{
				PreparedStatement ps = connection.prepareStatement("select short_desc from mm_item_lang_vw where item_code = ? and language_id = 'en'");
				ps.setString(1,item_code);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					Item_desc = rs.getString(1);
					//hmResult.put(MESSAGE,"Stock not available for this item");
//					System.out.println("Item_desc in StEJBSessionAdapter...."+Item_desc);
				}
				
//				System.out.println(" stParameter.in StEJBSessionAdapter..."+stParameter);
				hmSelect	=	fetchRecord(connection, eST.Common.StEJBRepository.getStKeyValue("SQL_ST_ITEM_BATCH_SELECT_SINGLE"),stParameter);
				
//				System.out.println(" hmSelect.in StEJBSessionAdapter..."+hmSelect);
//				System.out.println(" hmSelect.size().in StEJBSessionAdapter..."+hmSelect.size());

			  if (hmSelect == null || hmSelect.size()<=0)
			   {
				    throw new Exception("RECORD_UPDATED_BY_OTH_USER");  // BATCH_RECORD_NOT_FOUND
			   }
			}catch(Exception e){
               throw new Exception("RECORD_UPDATED_BY_OTH_USER");  // BATCH_RECORD_NOT_FOUND
			}
			double dQty_on_hand =0.0;
			double dCommitted_qty =0.0;
			/*System.out.println("#$#$## QTY_ON_HAND="+(hmSelect.get("QTY_ON_HAND") != null ));
			System.out.println("#$#$## QTY_ON_HAND="+( !(((String)hmSelect.get("QTY_ON_HAND")).equals("")) ));
	    	System.out.println("#$#$## COMMITTED_QTY="+(hmSelect.get("COMMITTED_QTY") != null ));
			System.out.println("#$#$## COMMITTED_QTY="+( !(((String)hmSelect.get("COMMITTED_QTY")).equals("")) ));  */

			if ((hmSelect.get("QTY_ON_HAND") != null ))
			{
			dQty_on_hand  = Double.parseDouble(setNumber(""+Double.parseDouble((String)hmSelect.get("QTY_ON_HAND")),no_of_decimals));
			}
			if ((hmSelect.get("COMMITTED_QTY") != null) )
			{
			dCommitted_qty  =Double.parseDouble(setNumber(""+Double.parseDouble((String)hmSelect.get("COMMITTED_QTY")),no_of_decimals));
			}
			/*System.out.println("@@@@ 4 QTY_ON_HAND="+(String)hmSelect.get("QTY_ON_HAND"));
			System.out.println("@@@@ 5 COMMITTED_QTY="+(String)hmSelect.get("COMMITTED_QTY"));
			System.out.println("@@@ 6 converstion="+dQty_on_hand);
			System.out.println("@@@ 7 COMMITTED_QTY="+dCommitted_qty); 	  */
			
/*            double dQty_on_hand	=	Double.parseDouble((String)hmSelect.get("QTY_ON_HAND"));
			double dCommitted_qty	=	Double.parseDouble((String)hmSelect.get("COMMITTED_QTY"));*/

			double dTrn_qty	=	Double.parseDouble(setNumber(""+Double.parseDouble(trn_qty),no_of_decimals));
			
			if (dQty_on_hand<(dCommitted_qty+dTrn_qty)) {
				/*System.err.println("=INSUFFICIENT_BATCH_QTY CHECK1 dQty_on_hand="+dQty_on_hand);
				System.err.println("=INSUFFICIENT_BATCH_QTY CHECK1 dCommitted_qty="+dCommitted_qty);
				System.err.println("=INSUFFICIENT_BATCH_QTY CHECK1 dTrn_qty="+dTrn_qty);
				System.err.println("=INSUFFICIENT_BATCH_QTY CHECK1 Query Executed for the above value SQL="+eST.Common.StEJBRepository.getStKeyValue("SQL_ST_ITEM_BATCH_SELECT_SINGLE")+"==== Data="+stParameter +"=====Result="+hmSelect);
				System.err.println("=INSUFFICIENT_BATCH_QTY CHECK1 for dTrn_qty hmParameter="+hmParameter);			   */
				throw new Exception("INSUFFICIENT_BATCH_QTY");
			}
				//added by Shaiju to avoid multiuser deadlock issue 
				ArrayList temp = new ArrayList();

				temp.add(store_code);
				temp.add(item_code);
				temp.add(batch_id);
				temp.add(bin_location_code);
				temp.add(expiry_date_or_receipt_date);

				String sql_multi_user_chk = "Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy') ";
                    
				HashMap result_multi_chk = fetchRecord(connection,sql_multi_user_chk,temp);
				System.out.println("result_multi_chk:ejbsession===1432=>" +result_multi_chk);
				alparamcount.add(store_code);
				alparamcount.add(item_code);
				alparamcount.add(batch_id);
				alparamcount.add(bin_location_code);
				alparamcount.add(expiry_date_or_receipt_date);
			   hmSelect	=	fetchRecord(connection, eST.Common.StEJBRepository.getStKeyValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"),alparamcount);
				int batch_count	= Integer.parseInt((String)(hmSelect.get("COUNT")));

				if(batch_count > 0) // Insert into batch control
				{
				alParameters.add(trn_qty);
				alParameters.add(login_by_id		);
				alParameters.add(login_at_ws_no		);
				alParameters.add(login_facility_id	);

				alParameters.add(store_code);
				alParameters.add(item_code);
				alParameters.add(batch_id);
				alParameters.add(bin_location_code);
				alParameters.add(expiry_date_or_receipt_date);

				hmArgData.put(DATA, alParameters);
				hmArgSQL.put(UPDATE_SQL,eST.Common.StEJBRepository.getStKeyValue("SQL_ST_ITEM_BATCH_FOR_SAL"));

				//System.out.println(" in blockReleaseBatch hmArgData"+ hmArgData+"hmArgSQL==>"+hmArgSQL);

				 System.out.println("parameter List@@@ in blockReleaseBatch====>"+ temp);
				
	            System.out.println("result_multi_chk@@@====>"+ result_multi_chk.get("MODIFIED_DATE"));
	            System.out.println("p_modified_date====>"+ p_modified_date);
	            System.out.println("compare====>"+ ((String)result_multi_chk.get("MODIFIED_DATE")).equals(p_modified_date)); 
				
				
				if((((String)result_multi_chk.get("MODIFIED_DATE")).equals(p_modified_date)) || ((p_modified_date.equals(""))))
				{
//added during merging ends here
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);
//added during merging
                System.out.println("hmResult:ejbsession===1471=>" +hmResult);
				}else
				{
					   
                      hmResult.put(RESULT,FALSE);
		              hmResult.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");
		              hmResult.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER");
                       System.out.println("hmResult:ejbsession===1479=>" +hmResult);  						
							throwExceptionWhenFailed(hmResult);

				}
//added during merging ends here
			}
			else
			{
				hmResult.put(RESULT,TRUE);
				hmResult.put(MSGID,"RECORD_MODIFIED");
				hmResult.put(MESSAGE,"RECORD_MODIFIED");
				System.out.println("hmResult:ejbsession===1489=>" +hmResult);
			}
		}
		catch (Exception exception) {
			hmResult.put(RESULT,FALSE);
			hmResult.put(MSGID,exception.toString());
			hmResult.put(MESSAGE,exception.getMessage());
                        hmResult.put("ITEM_CODE",item_code);//added by naveen on 17Feb2011
			hmResult.put("itemDesc",Item_desc);
			System.out.println("hmResult:ejbsession===1499=>" +hmResult);
			exception.printStackTrace();
		}
		System.out.println("hmResult:ejbsession===1502=>" +hmResult);
		return hmResult;		
	}
/** dece handling
	public String setNumber(String stNumber, int decimalPlaces){
		String returnNumber	=	"0";
		try { 
		double number	=	Double.parseDouble(stNumber);

		double power	=	Math.pow(10, decimalPlaces);
		number	=	number*power;
		number	=	Math.round(number);
		number	=	number/Math.pow(10, decimalPlaces);;
		returnNumber	=	""+number;
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return returnNumber;
	}**/

	public String setNumber(String stNumber, int decimalPlaces){
		String returnNumber	=	"0";
		try { 
		String fmt = "0";
		for(int i=0;i<decimalPlaces;i++){
			if(i==0)
				fmt=fmt+".";
			fmt=fmt+"0";
		}

		java.text.DecimalFormat df = new java.text.DecimalFormat(fmt);
		returnNumber = df.format(Double.parseDouble(stNumber));
				}
		catch (Exception exception) {
		//	exception.printStackTrace();
		}
		return returnNumber;
	}


	public HashMap MUC_Transaction_Modified_Check(HashMap  MUC_Current_data , HashMap  MUC_Selected_data)
	{
		HashMap				hmReturn			=	new HashMap();
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MSGID,"");

//		HashMap		MUC_hmResult	=	new HashMap()	;
		try
		{
		/*	//System.err.println("==== EJB7 MUC_Current_data="+MUC_Current_data);
			//System.err.println("==== EJB8MUC_Selected_data="+MUC_Selected_data);
			//System.err.println("%% EJB modified_by_id check ="+(MUC_Current_data.get("MODIFIED_BY_ID").equals (MUC_Selected_data.get("MODIFIED_BY_ID")) ));
			//System.err.println("%% EJB modified_date check ="+(MUC_Current_data.get("MODIFIED_DATE").equals (MUC_Selected_data.get("MODIFIED_DATE")) ));
			//System.err.println("%% EJB modified_at_ws_no check ="+(MUC_Current_data.get("MODIFIED_AT_WS_NO").equals (MUC_Selected_data.get("MODIFIED_AT_WS_NO")) ));
			//System.err.println("%% EJB modified_facility_id check ="+(MUC_Current_data.get("MODIFIED_FACILITY_ID").equals (MUC_Selected_data.get("MODIFIED_FACILITY_ID")) ));
*/
			if ( (MUC_Current_data.get("MODIFIED_BY_ID").equals (MUC_Selected_data.get("MODIFIED_BY_ID")) ) && 	(MUC_Current_data.get("MODIFIED_DATE").equals (MUC_Selected_data.get("MODIFIED_DATE"))) && (MUC_Current_data.get("MODIFIED_AT_WS_NO").equals (MUC_Selected_data.get("MODIFIED_AT_WS_NO")) )&& (MUC_Current_data.get("MODIFIED_FACILITY_ID").equals (MUC_Selected_data.get("MODIFIED_FACILITY_ID")))	)
			{
				hmReturn.put(RESULT,TRUE);
			}
			else
			{
				hmReturn.put(RESULT,FALSE);
				hmReturn.put(MSGID,"RECORD_LOCKED");
				hmReturn.put(MESSAGE, "RECORD_LOCKED");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,"RECORD_LOCKED");
			hmReturn.put(MESSAGE,e.toString());
		}
		return hmReturn;
	} 

	public String getPOMessage(String locale, String messageId, String moduleId)
	{
	
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }


	public int getNoOfDecimals(Connection connection){
		int no_of_decimals			  = 0;	
		HashMap hm_no_of_decimals	  = new HashMap();
		try{
			hm_no_of_decimals = fetchRecord( connection,"SELECT NO_OF_DECIMALS FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = 'ZZ'");
		}catch(Exception e){
			no_of_decimals = 0;
		}
		if(hm_no_of_decimals.size() > 0){
			no_of_decimals = Integer.parseInt(checkForNull((String)hm_no_of_decimals.get("NO_OF_DECIMALS"),"0"));
		}
		return no_of_decimals;
	}

	public String getDispDecimalDtlsYN(Connection connection){
		String disp_decimal_dtls_yn			  = "N";	
		HashMap hm_disp_decimal_dtls_yn	  = new HashMap();
		try{
			hm_disp_decimal_dtls_yn = fetchRecord( connection,"SELECT DISP_DECIMAL_DTLS_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = 'ZZ'");
		}catch(Exception e){
			disp_decimal_dtls_yn = "";
		}
		if(hm_disp_decimal_dtls_yn.size() > 0){
			disp_decimal_dtls_yn = checkForNull((String)hm_disp_decimal_dtls_yn.get("DISP_DECIMAL_DTLS_YN"),"N");
		}
		return disp_decimal_dtls_yn;
	}

	public String getAllowDecimalsYN(Connection connection,String item_code){
		if(getDispDecimalDtlsYN(connection).equals("N")){
			return "N";
		}
		String allow_decimals_yn			  = "N";	
		HashMap hm_allow_decimals_yn	  = new HashMap();
		try{
			hm_allow_decimals_yn = fetchRecord(connection,"SELECT ALLOW_DECIMALS_YN FROM ST_ITEM WHERE ITEM_CODE = ?",item_code);
		}catch(Exception e){
			allow_decimals_yn = "N";
		}
		if(hm_allow_decimals_yn.size() > 0){
			allow_decimals_yn = checkForNull((String)hm_allow_decimals_yn.get("ALLOW_DECIMALS_YN"),"N");
		}
		return allow_decimals_yn;
	}
	public String getNoOfDecimalsCost(Connection connection){
		String no_of_decimals			  = "0";	
		try{
			no_of_decimals = checkForNull((String)((HashMap)fetchRecord(connection,"SELECT NVL(NO_OF_DECIMALS_FOR_COST,0) NO_OF_DECIMALS_FOR_COST FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = 'ZZ'")).get("NO_OF_DECIMALS_FOR_COST"),"0");
		}catch(Exception e){
			no_of_decimals = "0";
			e.printStackTrace();
		}
		return no_of_decimals;
	}

	public String getUnitCost(String item_code,String store_code,Connection connection){
		ArrayList alParameters = new ArrayList(); 		
		alParameters.add(item_code);
		alParameters.add(store_code);

		String unit_cost  = "0";	
		try{
			unit_cost = checkForNull((String)((HashMap)fetchRecord(connection,"SELECT TRIM(ST_DISPLAY_COST_DECIMALS(?,?)) UNIT_COST FROM DUAL",alParameters)).get("UNIT_COST"),"0");
		}catch(Exception e){
			unit_cost = "0";
			e.printStackTrace();
		}
		return unit_cost;
	}


}
