/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSShiftPattern ;

import java.rmi.* ;
import java.sql.* ;
import java.util.* ;
import javax.ejb.* ;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;


/**
*
* @ejb.bean
*	name="RSShiftPattern"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSShiftPattern"
*	local-jndi-name="RSShiftPattern"
*	impl-class-name="eRS.RSShiftPattern.RSShiftPatternManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSShiftPattern.RSShiftPatternLocal"
*	remote-class="eRS.RSShiftPattern.RSShiftPatternRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSShiftPattern.RSShiftPatternLocalHome"
*	remote-class="eRS.RSShiftPattern.RSShiftPatternHome"
*	generate= "local,remote"
*
*
*/

public class RSShiftPatternManager implements SessionBean{
	Connection connection					= null;
	StringBuffer traceVal						= new StringBuffer();

	PreparedStatement pstmt_insert1		=null;
	PreparedStatement pstmt_update1		= null;
	PreparedStatement pstmt_duplicate1	= null;
	PreparedStatement pstmt_insert2		=null;
	PreparedStatement pstmt_update2		= null;
	PreparedStatement pstmt_duplicate2	= null;
	PreparedStatement pstmt_delete1		= null;
	
	ResultSet res_duplicate1	= null;
	ResultSet res_duplicate2	= null;
	
	String shift_pattern_id		="";
	String facility_id="";
	String login_by_id	="";
	String login_at_ws_no="";
	String login_facility_id	="";
	String modified_by_id	="";
	String modified_facility_id	="";
	String modified_at_ws_no	 ="";
	String locale	 ="";

	public RSShiftPatternManager(){}

	public void ejbCreate() throws CreateException{}

	public void ejbRemove(){}

	public void ejbActivate(){}

	public void ejbPassivate(){}

    public void setSessionContext(SessionContext sessioncontext){
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap tabData, HashMap sqlMap){
	
		Properties ppts = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		
		int counter = 0;
		int[] resCnt = null;
		int inserted = 0;
		try{
				HashMap tabDataTemp1 = (HashMap )tabData.get("InsertData1");
				HashMap tabDataTemp2 = (HashMap )tabData.get("InsertData2");
				facility_id				=(String)tabData.get("facility_id");
				shift_pattern_id		=(String)tabData.get("shift_pattern_id");
				int week_count=Integer.parseInt((String)tabData.get("week_count"));
				int day_count=Integer.parseInt((String)tabData.get("day_count"));

				login_by_id					= (String )tabData.get("added_by_id");
				login_at_ws_no			= (String )tabData.get("added_at_ws_no");
				login_facility_id			= (String )tabData.get("added_facility_id");
				modified_by_id			= (String )tabData.get("modified_by_id");
				modified_at_ws_no	= (String )tabData.get("modified_at_ws_no");
				modified_facility_id	= (String )tabData.get("modified_facility_id");
				locale= (String )tabData.get("locale");
				
				
				ppts								= (Properties )tabData.get("properties");

				String SQL_RS_SHIFT_PATTERN_INSERT = (String )sqlMap.get("InsertSQL1");
				String SQL_RS_SHIFT_PATTERN_DUPLICATE_CHK = (String )sqlMap.get("DupchkSQL1");
				String SQL_RS_SHIFT_PATTERN_DTL_INSERT = (String )sqlMap.get("InsertSQL2");
				String SQL_RS_SHIFT_PATTERN_DTL_DUPLICATE_CHK = (String )sqlMap.get("DupchkSQL2");

		        connection = ConnectionManager.getConnection(ppts);
				connection.setAutoCommit( false );

				pstmt_duplicate1= connection.prepareStatement(SQL_RS_SHIFT_PATTERN_DUPLICATE_CHK);
			
				pstmt_duplicate1.setString(1,shift_pattern_id);
				pstmt_duplicate1.setString(2,facility_id);
				res_duplicate1 = pstmt_duplicate1.executeQuery();
			
				while(res_duplicate1.next()){
					counter=Integer.parseInt((String)res_duplicate1.getString(1));
				}
				if(pstmt_duplicate1 != null)
					pstmt_duplicate1.close();
				if(res_duplicate1 != null)
					res_duplicate1.close();
				if(counter > 0){
						Hashtable massageMap = MessageManager.getMessage(locale,"CODE_ALREADY_EXISTS", "Common");
						messages.append((String)massageMap.get("message"));
						retMap.put( "message", messages.toString() ) ;
						retMap.put( "invalidCode", shift_pattern_id) ;
						retMap.put( "flag", "Duplicate") ;
						retMap.put( "traceVal", "dup loop records") ;
						connection.rollback();
						return retMap ;
				}
				//duplicate check ends here...			
				else{
					pstmt_insert1=connection.prepareStatement(SQL_RS_SHIFT_PATTERN_INSERT);
					pstmt_insert2=connection.prepareStatement(SQL_RS_SHIFT_PATTERN_DTL_INSERT);

					pstmt_insert1.setString(1,facility_id);
					pstmt_insert1.setString(2,shift_pattern_id);
					pstmt_insert1.setString(3,(String )tabDataTemp1.get("long_desc"));
					pstmt_insert1.setString(4,(String )tabDataTemp1.get("short_desc"));
					pstmt_insert1.setString(5,(String )tabDataTemp1.get("locn_type"));
					pstmt_insert1.setString(6,(String )tabDataTemp1.get("eff_status"));
					pstmt_insert1.setString(7,login_by_id);
					pstmt_insert1.setString(8,login_at_ws_no);
					pstmt_insert1.setString(9,login_facility_id);
					pstmt_insert1.setString(10,modified_by_id);
					pstmt_insert1.setString(11,modified_at_ws_no);
					pstmt_insert1.setString(12,modified_facility_id);
	
					inserted=pstmt_insert1.executeUpdate();
				if(pstmt_insert1 != null)
					pstmt_insert1.close();
			/*************second table******************/

					if(inserted>0){
						for(int i=0;i<week_count;i++){
							if(tabDataTemp2.containsKey(String.valueOf(i))){

								HashMap week_Data=(HashMap)tabDataTemp2.get(String.valueOf(i)) ;
								for(int j=0;j<=day_count;j++){

									if(week_Data.containsKey(String.valueOf(j+1))){

										pstmt_duplicate2 = connection.prepareStatement(SQL_RS_SHIFT_PATTERN_DTL_DUPLICATE_CHK);
										ArrayList shift_Data=(ArrayList)week_Data.get(String.valueOf(j+1));
										pstmt_duplicate2.setString(1,facility_id);
										pstmt_duplicate2.setString(2,shift_pattern_id);
 										pstmt_duplicate2.setString(3,String.valueOf(i+1));
										pstmt_duplicate2.setString(4,String.valueOf(j+1));
										res_duplicate2 = pstmt_duplicate2.executeQuery();

										while(res_duplicate2.next()){
											counter=Integer.parseInt((String)res_duplicate2.getString(1));
										}
										if(pstmt_duplicate2 != null)
											pstmt_duplicate2.close();
										if(res_duplicate2 != null)
											res_duplicate2.close();
										if(counter > 0){
												Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_ALREADY_EXISTS", "Common");
												messages.append((String)massageMap.get("message"));
											break;
										}
										else{

											pstmt_insert2.setString(1,facility_id);
											pstmt_insert2.setString(2,shift_pattern_id);
											pstmt_insert2.setString(3,String.valueOf(i+1));
											pstmt_insert2.setString(4,String.valueOf(j+1));
											pstmt_insert2.setString(5,(String )shift_Data.get(0));
											pstmt_insert2.setString(6,(String )shift_Data.get(1));
											pstmt_insert2.setString(7,login_by_id);
											pstmt_insert2.setString(8,login_at_ws_no);
											pstmt_insert2.setString(9,login_facility_id);
											pstmt_insert2.setString(10,modified_by_id);
											pstmt_insert2.setString(11,modified_at_ws_no);
											pstmt_insert2.setString(12,modified_facility_id);
											pstmt_insert2.addBatch();
										}
									}
								}
							}
						}

						resCnt = pstmt_insert2.executeBatch();
						if(resCnt != null){
							connection.commit();
							retMap.put( "result", new Boolean( true ) ) ;
							retMap.put( "flag" , "" );
							Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_INSERTED","RS");
							messages.append((String)massageMap.get("message"));
						}
					}
				}
			}catch(Exception e){
				try{
					connection.rollback();
					retMap.put( "result", new Boolean( false ) ) ;
					retMap.put( "flag" , "" );
					traceVal.append(e.getMessage());
					Hashtable massageMap = MessageManager.getMessage(connection,"ERROR_IN_INSERTING_INTO");
					messages.append((String)massageMap.get("message"));
				}catch(Exception ex)	{
					ex.printStackTrace();
				}
			}
			finally{
				try{
					res_duplicate1.close();
					res_duplicate2.close();

					pstmt_insert1.close();
					pstmt_duplicate1.close();
					pstmt_insert2.close();
					pstmt_duplicate2.close();

					if(connection != null){
						//closeConnection( connection,ppts);
						ConnectionManager.returnConnection(connection,ppts);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		retMap.put( "message", messages.toString() ) ;
		retMap.put( "traceVal",traceVal.toString());
		retMap.put( "invalidCode" , "");
		return retMap;
	}

    /**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify(HashMap tabData, HashMap sqlMap){

		Properties ppts = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		try{
			HashMap tabDataTemp1 = (HashMap )tabData.get("UpdateData1");
			HashMap tabDataTemp2 = (HashMap )tabData.get("UpdateData2");
			facility_id=(String)tabData.get("facility_id");
			shift_pattern_id=(String)tabData.get("shift_pattern_id");
			int week_count=Integer.parseInt((String)tabData.get("week_count"));
			int day_count=Integer.parseInt((String)tabData.get("day_count"));
			login_by_id = (String )tabData.get("added_by_id");
			login_at_ws_no = (String )tabData.get("added_at_ws_no");
			login_facility_id = (String )tabData.get("added_facility_id");
			modified_by_id = (String )tabData.get("modified_by_id");
			modified_at_ws_no = (String )tabData.get("modified_at_ws_no");
			modified_facility_id = (String )tabData.get("modified_facility_id");
			locale= (String )tabData.get("locale");
			ppts = (Properties )tabData.get("properties");
			String SQL_RS_SHIFT_PATTERN_UPDATE = (String )sqlMap.get("UpdateSQL1");
			String SQL_RS_SHIFT_PATTERN_DTL_INSERT = (String )sqlMap.get("InsertSQL1");
			String SQL_RS_SHIFT_PATTERN_DTL_UPDATE = (String )sqlMap.get("UpdateSQL2");
			String SQL_RS_SHIFT_PATTERN_DTL_DELETE = (String )sqlMap.get("DeleteSql1");
			int[] inserted=null;
			int[] updated=null;
			int[] deleted=null;
			//connection = getConnection(ppts);
	        connection = ConnectionManager.getConnection(ppts);
			connection.setAutoCommit( false );

			pstmt_update1=connection.prepareStatement(SQL_RS_SHIFT_PATTERN_UPDATE);

			pstmt_update1.setString(1,(String )tabDataTemp1.get("long_desc"));
			pstmt_update1.setString(2,(String )tabDataTemp1.get("short_desc"));
			pstmt_update1.setString(3,(String )tabDataTemp1.get("locn_type"));
			pstmt_update1.setString(4,(String )tabDataTemp1.get("eff_status"));
			pstmt_update1.setString(5,login_by_id);
			pstmt_update1.setString(6,login_at_ws_no);
			pstmt_update1.setString(7,login_facility_id);
			pstmt_update1.setString(8,facility_id);
			pstmt_update1.setString(9,shift_pattern_id);
			int res_mod = pstmt_update1.executeUpdate();

			if(pstmt_update1 != null)
				pstmt_update1.close();

			if(res_mod>0){
				pstmt_insert1=connection.prepareStatement(SQL_RS_SHIFT_PATTERN_DTL_INSERT);
				pstmt_update2= connection.prepareStatement(SQL_RS_SHIFT_PATTERN_DTL_UPDATE);
				pstmt_delete1=connection.prepareStatement(SQL_RS_SHIFT_PATTERN_DTL_DELETE);
		
				for(int i=0;i<week_count;i++){

					for(int j=0;j<day_count;j++){
						if(tabDataTemp2.containsKey(String.valueOf(i))){
							HashMap week_Data=(HashMap)tabDataTemp2.get(String.valueOf(i)) ;

							if(week_Data.containsKey(String.valueOf(j+1))){

								ArrayList shift_Data=(ArrayList)week_Data.get(String.valueOf(j+1));
								if(((String)shift_Data.get(2)).equals("I")){

									pstmt_insert1.setString(1,facility_id);
									pstmt_insert1.setString(2,shift_pattern_id);
									pstmt_insert1.setString(3,String.valueOf(i+1));
									pstmt_insert1.setString(4,String.valueOf(j+1));
									pstmt_insert1.setString(5,(String )shift_Data.get(0));
									pstmt_insert1.setString(6,(String )shift_Data.get(1));
									pstmt_insert1.setString(7,login_by_id);
									pstmt_insert1.setString(8,login_at_ws_no);
									pstmt_insert1.setString(9,login_facility_id);
									pstmt_insert1.setString(10,modified_by_id);
									pstmt_insert1.setString(11,modified_at_ws_no);
									pstmt_insert1.setString(12,modified_facility_id);
									pstmt_insert1.addBatch();
							}else 

								if(((String)shift_Data.get(2)).equals("U")){

									pstmt_update2.setString(1,(String )shift_Data.get(0));
									pstmt_update2.setString(2,(String )shift_Data.get(1));
									pstmt_update2.setString(3,login_by_id);
									pstmt_update2.setString(4,login_at_ws_no);
									pstmt_update2.setString(5,login_facility_id);
									pstmt_update2.setString(6,facility_id);
									pstmt_update2.setString(7,shift_pattern_id);
									pstmt_update2.setString(8,String.valueOf(i+1));
									pstmt_update2.setString(9,String.valueOf(j+1));
									pstmt_update2.addBatch();
							}
						}
						else{

							pstmt_delete1.setString(1,facility_id);
							pstmt_delete1.setString(2,shift_pattern_id);
							pstmt_delete1.setString(3,String.valueOf(i+1));
							pstmt_delete1.setString(4,String.valueOf(j+1));
							pstmt_delete1.addBatch();
						}

					}
					else{

						pstmt_delete1.setString(1,facility_id);
						pstmt_delete1.setString(2,shift_pattern_id);
						pstmt_delete1.setString(3,String.valueOf(i+1));
						pstmt_delete1.setString(4,String.valueOf(j+1));
						pstmt_delete1.addBatch();
					}
				}
			}

			inserted = pstmt_insert1.executeBatch();
			updated = pstmt_update2.executeBatch();
			deleted =pstmt_delete1.executeBatch();
			if(pstmt_insert1 != null)
				pstmt_insert1.close();
			if(pstmt_update2 != null)
				pstmt_update2.close();
			if(pstmt_delete1 != null)
				pstmt_delete1.close();
		}	
		
		if(( inserted != null)&&( updated != null)&&(deleted!=null)){
			connection.commit();
			retMap.put( "result", new Boolean( true ) ) ;
			retMap.put( "flag" , "" );
			Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_MODIFIED","RS");
			messages.append((String)massageMap.get("message"));
		 }

	}catch(Exception e){
		try{
			connection.rollback();
			retMap.put( "result", new Boolean( false ) ) ;
			retMap.put( "flag" , "" );
			traceVal.append(e.getMessage());
			Hashtable massageMap = MessageManager.getMessage(locale,"ERROR_IN_UPDATING","SM");
			messages.append((String)massageMap.get("message"));
		}catch(Exception ex)	{
			ex.printStackTrace();
		}
	}

	finally{
		try{
	
		pstmt_insert1.close();
		pstmt_update1.close();
		pstmt_update2.close();
		pstmt_delete1.close();

		if(connection != null) {
			//closeConnection( connection,ppts);
			ConnectionManager.returnConnection(connection,ppts);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	retMap.put( "message", messages.toString() ) ;
	retMap.put( "traceVal",traceVal.toString());
	retMap.put( "invalidCode" , "");
	return retMap;	
	}
}
