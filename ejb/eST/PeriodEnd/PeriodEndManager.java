/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.PeriodEnd;
//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="PeriodEnd"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PeriodEnd"
*	local-jndi-name="PeriodEnd"
*	impl-class-name="eST.PeriodEnd.PeriodEndManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.PeriodEnd.PeriodEndLocal"
*	remote-class="eST.PeriodEnd.PeriodEndRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.PeriodEnd.PeriodEndLocalHome"
*	remote-class="eST.PeriodEnd.PeriodEndHome"
*	generate= "local,remote"
*
*
*/
 
public class  PeriodEndManager extends StEJBSessionAdapter {
	
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public HashMap delete( HashMap hmData, HashMap hmSQL ) //throws RemoteException 
		{
		HashMap		hmReturn	=	new HashMap();
		hmReturn.put(RESULT,FALSE);
		return hmReturn;
	}
	
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public HashMap insert(HashMap hmData, HashMap hmSQL) //throws RemoteException
	{
		HashMap		hmReturn	=	new HashMap();
		hmReturn.put(RESULT,FALSE);
		return hmReturn;
	}
	
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public HashMap modify(HashMap hmData, HashMap hmSQL) //throws RemoteException 
		{
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		Properties	properties	=	null;
		String		stSQL		=	null;
		ArrayList  alParameters =   new ArrayList();

		String stOld_period_month	=(String)hmData.get( "old_period_month");
		String stOld_period_year	=(String)hmData.get( "old_period_year");
		String stNew_period_month	=(String)hmData.get( "new_period_month");
		String stNew_period_year	=(String)hmData.get( "new_period_year");

		ArrayList alCommonData		=	(ArrayList)hmData.get( "COMMON_DATA");
		ArrayList alHdrData			=	(ArrayList)	hmData.get("ModifyData");

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);
			
			String acc_entity_id=(String)hmData.get("acc_entity_id");
			if (acc_entity_id!=null) {
				stSQL				=	(String)	hmSQL.get ("SQL_ST_ACC_ENTITY_PARAM_UPDATE_FOR_PERIOD_END");
				alHdrData.add(acc_entity_id);
				hmArgData.put(DATA,alHdrData);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
				alHdrData.remove(5);
			}

			String []facility_id=	(String[])	hmData.get("facility_id");
			stSQL				=	(String)	hmSQL.get ("SQL_ST_PARAMETER_UPDATE_FOR_PERIOD_END");

			StringBuffer sbSQL		=	new StringBuffer(stSQL);
			StringBuffer sbQuestionMarks	=	new StringBuffer();
			for (int i=0;i<facility_id.length ;i++ ) 
				sbQuestionMarks.append("?,");
			sbQuestionMarks.deleteCharAt(sbQuestionMarks.length()-1);
			sbSQL.replace(stSQL.indexOf('@'),stSQL.indexOf('@')+1,sbQuestionMarks.toString());

			for (int i=0;i<facility_id.length ;i++ ) 
				alHdrData.add(facility_id[i]);

			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(UPDATE_SQL,sbSQL.toString());

			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
			//boolean to_update = false;

			HashMap	 hmResult_Toupdate	= null;	

			//HashMap		hmDate_updata	= null;	
			//HashMap		hmUpdate_sql	= null;

			alParameters.clear();
			alParameters.add(stOld_period_month);
			alParameters.add(stOld_period_year);
			alParameters.add(alCommonData.get(2));//Added by suresh.r on 24-11-2014 against Inc 52256
			stSQL	 =	(String)	hmSQL.get ("SQL_ST_ITEM_MOVE_SUMM_CHECK_VALUE_PERIOD_END");

			ArrayList alRecords= fetchRecords(connection,stSQL,alParameters);

			for (int i=0;i<alRecords.size();i++ ){
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				String store		=	(String)  hmRecord.get("STORE_CODE");
				String item			=	(String) hmRecord.get("ITEM_CODE");

				String facility		= 	(String)  hmRecord.get("FACILITY_ID");
				String close_qty	= 	checkForNull((String)  hmRecord.get("MONTH_CLOSING_QTY"),"0");
				String close_value  = 	checkForNull((String)  hmRecord.get("MONTH_CLOSING_VALUE"),"0");
				/**
				 * @Name - Priya
				 * @Date - 10/06/2010
				 * @Inc# - 
				 * @Desc - To assign close_value as zero if close_qty =0
				 */
				
				if(Double.valueOf(close_qty) == 0){
					close_value = "0";
				}
				alParameters.clear();
				alParameters.add(stNew_period_month);
				alParameters.add(stNew_period_year);
				alParameters.add(facility);
				alParameters.add(store);
				alParameters.add(item);

				stSQL	 =	(String)	hmSQL.get ("SQL_ST_ITEM_MOVE_SUMM_COUNT_CHECK");

				hmResult_Toupdate = fetchRecord(connection,stSQL,alParameters);
				
				if (((String)hmResult_Toupdate.get("TOTAL")).equals("0") ){
					alParameters.clear();
					alParameters.add(facility);
					alParameters.add(item);
					alParameters.add(store);
					alParameters.add(stNew_period_year);
					alParameters.add(stNew_period_month);
					alParameters.add(close_qty);
					alParameters.add(close_value);
					alParameters.add(close_qty);
					alParameters.add(close_value);
					alParameters.add(alCommonData.get(0));
					alParameters.add(alCommonData.get(1));
					alParameters.add(alCommonData.get(2));
					alParameters.add(alCommonData.get(0));
					alParameters.add(alCommonData.get(1));
					alParameters.add(alCommonData.get(2));

					stSQL	=	(String)	hmSQL.get ("SQL_ST_ITM_MOV_SUMM_INSERT_PERIOD_END");

					hmArgData.put(DATA,alParameters);
					hmArgSQL.put(INSERT_SQL,stSQL);
					hmReturn	=	insert(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);
				}//if
				else{
					alParameters.clear();
					alParameters.add(close_qty);
					alParameters.add(close_value);
					alParameters.add(close_qty);
					alParameters.add(close_value);
					alParameters.add(alCommonData.get(0));
					alParameters.add(alCommonData.get(1));
					alParameters.add(alCommonData.get(2));
					alParameters.add(stNew_period_year);
					alParameters.add(stNew_period_month);
					alParameters.add(facility);
					alParameters.add(store);
					alParameters.add(item);

					stSQL	=	(String)	hmSQL.get ("SQL_ST_UPDATE_VALUE_PERIOD_END");

					hmArgData.put(DATA,alParameters);
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmReturn	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmReturn);
				}//else
			}//for loop
			connection.commit();
			
        }
		catch(Exception exception) {
			try {
				connection.rollback();
				exception.printStackTrace();
			}
			catch (Exception subException) {
				subException.printStackTrace(); 
			}
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
		}
		finally{
			try{
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
}
