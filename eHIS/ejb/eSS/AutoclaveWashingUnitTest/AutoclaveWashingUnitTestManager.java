/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date	       	Edit History      	Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
24/11/2014		IN052312			Karthi L						Ramesh			Autoclaving Unit Test Entry
--------------------------------------------------------------------------------------------------------------
*/
 package eSS.AutoclaveWashingUnitTest;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="AutoclaveWashingUnitTest"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AutoclaveWashingUnitTest"
*	local-jndi-name="AutoclaveWashingUnitTest"
*	impl-class-name="eSS.AutoclaveWashingUnitTest.AutoclaveWashingUnitTestManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.AutoclaveWashingUnitTest.AutoclaveWashingUnitTestLocal"
*	remote-class="eSS.AutoclaveWashingUnitTest.AutoclaveWashingUnitTestRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.AutoclaveWashingUnitTest.AutoclaveWashingUnitTestLocalHome"
*	remote-class="eSS.AutoclaveWashingUnitTest.AutoclaveWashingUnitTestHome"
*	generate= "local,remote"
*
*
*/


public class  AutoclaveWashingUnitTestManager extends SsEJBSessionAdapter {

	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQL ) //throws RemoteException
	{
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alDeleteData=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;

		hmReturn.put(RESULT,FALSE);
		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alDeleteData		=	(ArrayList)	hmData.get("DeleteData");
			stSQL				=	(String)	hmSQL.get ("DtlDeleteSQL");
										
			//System.out.println("DETAIL alDeleteData"+alDeleteData);
			//System.out.println("stSQL"+stSQL);
			hmArgData.put(DATA,alDeleteData);
			hmArgSQL.put(DELETE_SQL,stSQL);

			hmReturn	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			alDeleteData		=	(ArrayList)	hmData.get("DeleteData");
			stSQL				=	(String)	hmSQL.get ("HdrDeleteSQL");

			//System.out.println("HEADER alDeleteData"+alDeleteData);
			//System.out.println("stSQL"+stSQL);
			
			hmArgData.put(DATA,alDeleteData);
			hmArgSQL.put(DELETE_SQL,stSQL);

			hmReturn	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

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

	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmData, HashMap hmSQL) //throws RemoteException 
	{	
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alDtlRecords=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;
		//   AAKH-CRF-0057 - IN052312 - Start
		String biologic_indicator = "";
		String bms_pass_fail = ""; 
		String room_temp = "";
		String relative_humidity = "";
		// AAKH-CRF-0057 - IN052312 - End
		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alHdrData			=	(ArrayList)	hmData.get("HdrInsertData");
			stSQL				=	(String)	hmSQL.get ("HdrInsertSQL");
			
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(INSERT_SQL,stSQL);

			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			alDtlData	=	(ArrayList)		hmData.get("DtlInsertData");
			stSQL		=	(String)		hmSQL.get ("DtlInsertSQL");

			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				alDtlRecord.add(alHdrData.get(0));//autoclave_wash_unit_code
				alDtlRecord.add(alHdrData.get(1));//test_date
				alDtlRecord.add(hmRecord.get("test_code"));
				alDtlRecord.add(hmRecord.get("batch_id"));
				alDtlRecord.add(hmRecord.get("test_result"));
				alDtlRecord.add(hmRecord.get("result_date"));
				alDtlRecord.add(hmRecord.get("result_remarks"));
				alDtlRecord.add(alHdrData.get(4));
				alDtlRecord.add(alHdrData.get(5));
				alDtlRecord.add(alHdrData.get(6));
				alDtlRecord.add(alHdrData.get(4));
				alDtlRecord.add(alHdrData.get(5));
				alDtlRecord.add(alHdrData.get(6));
				//added for AAKH-CRF-0057 - IN052312
				if(hmRecord.get("biologic_indicator").equals("")){
					biologic_indicator = "X";
				}
				else {
					biologic_indicator = (String)hmRecord.get("biologic_indicator");
				}
				
				bms_pass_fail = (String)hmRecord.get("bms_pass_fail");
				if(bms_pass_fail == null){
					bms_pass_fail = "";
				}
				if(bms_pass_fail.equalsIgnoreCase("Y")) {
					bms_pass_fail = "P";
				} else if(bms_pass_fail.equalsIgnoreCase("N")){
					bms_pass_fail = "F";
				} else {
					bms_pass_fail = "X";
				}
					
				room_temp = (String)hmRecord.get("room_temp");
				relative_humidity =  (String)hmRecord.get("relative_humidity");
				if(room_temp != null && room_temp.equals("")){
					room_temp = room_temp.trim();
				}
				if(relative_humidity != null && relative_humidity.equals("")){
					relative_humidity = relative_humidity.trim();
				}
				alDtlRecord.add(room_temp);
				alDtlRecord.add(relative_humidity);
				alDtlRecord.add(biologic_indicator);
				alDtlRecord.add(bms_pass_fail);
				//added for AAKH-CRF-0057 - IN052312
				//System.out.println(alDtlRecord);
				alDtlRecords.add(alDtlRecord);
			}
			stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
			
			hmArgData.put(DATA,alDtlRecords);
			hmArgSQL.put(INSERT_SQL,stSQL);

			hmResult	=	insertBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

//			if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
//				stSQL				=	(String)	hmSQL.get ("NextDocNoUpdateSQL");
/*
				ArrayList alNextDocNoUpdateData	=	new ArrayList();
				alNextDocNoUpdateData.add(alHdrData.get(8));
				alNextDocNoUpdateData.add(alHdrData.get(9));
				alNextDocNoUpdateData.add(alHdrData.get(10));
				alNextDocNoUpdateData.add(alHdrData.get(1));

				hmArgData.put(DATA,alNextDocNoUpdateData);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);
				hmReturn.put("flag","Doc No: "+alHdrData.get(2));
			}
*/

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
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify(HashMap hmData, HashMap hmSQL) //throws RemoteException
	{
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
        ArrayList	alStatusData	=	new ArrayList();
		String		unit_status	="";
		Properties	properties	=	null;
		String		stSQL		=	null;
		// AAKH-CRF-0057 - IN052312 - Start
		String biologic_indicator = ""; 
		String bms_pass_fail = ""; 
		String room_temp = "";
		String relative_humidity = "";
		// AAKH-CRF-0057 - IN052312 - End
		
		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alHdrData			=	(ArrayList)	hmData.get("HdrModifyData");
			stSQL				=	(String)	hmSQL.get ("HdrModifySQL");
			
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(UPDATE_SQL,stSQL);

			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			alDtlData	=	(ArrayList)		hmData.get("DtlModifyData");
			stSQL		=	(String)		hmSQL.get ("DtlModifySQL");

////System.out.println("here");
////System.out.println("alDtlData.size()"+alDtlData.size());


			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				hmResult.clear();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				
				////System.out.println("MODE"+hmRecord.get("mode").toString());
				
				//added for AAKH-CRF-0057 - IN052312
				if(hmRecord.get("biologic_indicator").equals("")){
					biologic_indicator = "X";
				}
				else {
					biologic_indicator = (String)hmRecord.get("biologic_indicator");
				}
				
				bms_pass_fail = (String)hmRecord.get("bms_pass_fail");
				if(bms_pass_fail == null){
					bms_pass_fail = "";
				}
				if(bms_pass_fail.equalsIgnoreCase("Y")) {
					bms_pass_fail = "P";
				} else if(bms_pass_fail.equalsIgnoreCase("N")){
					bms_pass_fail = "F";
				} else {
					bms_pass_fail = "X";
				}
				room_temp = (String)hmRecord.get("room_temp");
				relative_humidity =  (String)hmRecord.get("relative_humidity");
				if(room_temp != null && room_temp.equals("")){
					room_temp = room_temp.trim();
				}
				if(relative_humidity != null && relative_humidity.equals("")){
					relative_humidity = relative_humidity.trim();
				}
				//added for AAKH-CRF-0057 - IN052312
				
				
				if(hmRecord.get("mode").toString().equals(MODE_INSERT)){
				alDtlRecord.add(alHdrData.get(5));//autoclave_wash_unit_code
				alDtlRecord.add(alHdrData.get(6));//test_date
				alDtlRecord.add(hmRecord.get("test_code"));
				alDtlRecord.add(hmRecord.get("batch_id"));
				alDtlRecord.add(hmRecord.get("test_result"));
				alDtlRecord.add(hmRecord.get("result_date"));
				alDtlRecord.add(hmRecord.get("result_remarks"));
				alDtlRecord.add(alHdrData.get(2));
				alDtlRecord.add(alHdrData.get(3));
				alDtlRecord.add(alHdrData.get(4));
				alDtlRecord.add(alHdrData.get(2));
				alDtlRecord.add(alHdrData.get(3));
				alDtlRecord.add(alHdrData.get(4));
				//AAKH-CRF-0057 - IN052312 - Start
				alDtlRecord.add(room_temp);
				alDtlRecord.add(relative_humidity);
				alDtlRecord.add(biologic_indicator);
				alDtlRecord.add(bms_pass_fail);
				//AAKH-CRF-0057 - IN052312 - End
					stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(INSERT_SQL,stSQL);
					hmResult	=	insert(connection, hmArgData, hmArgSQL);
				}
				else if(hmRecord.get("mode").toString().equals(MODE_MODIFY)){

					alDtlRecord.add(hmRecord.get("batch_id"));
					alDtlRecord.add(hmRecord.get("test_result"));
					alDtlRecord.add(hmRecord.get("result_date"));
					alDtlRecord.add(hmRecord.get("result_remarks"));

					alDtlRecord.add(alHdrData.get(2));
					alDtlRecord.add(alHdrData.get(3));
					alDtlRecord.add(alHdrData.get(4));
					//AAKH-CRF-0057 - IN052312 - Start
					alDtlRecord.add(room_temp);
					alDtlRecord.add(relative_humidity);
					alDtlRecord.add(biologic_indicator);
					alDtlRecord.add(bms_pass_fail);
					//AAKH-CRF-0057 - IN052312 - End	
					alDtlRecord.add(alHdrData.get(5));
					alDtlRecord.add(alHdrData.get(6));
					alDtlRecord.add(hmRecord.get("test_code"));

					stSQL				=	(String)	hmSQL.get ("DtlModifySQL");
					
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);
			
                  if(((String)hmRecord.get("test_result")).equals("F"))unit_status="I";
                  if(((String)hmRecord.get("test_result")).equals("P"))unit_status="A";
                    if((((String)hmRecord.get("test_result")).equals("F"))||(((String)hmRecord.get("test_result")).equals("P")))
                    {
					
					alStatusData.add(unit_status);
                    alStatusData.add(alHdrData.get(2));
					alStatusData.add(alHdrData.get(3));
					alStatusData.add(alHdrData.get(4));
					alStatusData.add(alHdrData.get(5));

            		stSQL				=	(String)	hmSQL.get ("UpdateUnitStatusSQL");
					
					hmArgData.put(DATA,alStatusData);
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					
					}

				}
				else if(hmRecord.get("mode").toString().equals(MODE_DELETE)){
					alDtlRecord.add(alHdrData.get(5));
					alDtlRecord.add(alHdrData.get(6));
					alDtlRecord.add(hmRecord.get("test_code"));

					stSQL				=	(String)	hmSQL.get ("DtlDeleteSQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(DELETE_SQL,stSQL);
					hmResult	=	delete(connection, hmArgData, hmArgSQL);
				}
				else{
					hmResult.put(RESULT,FALSE);
					hmResult.put(MESSAGE,"Invalid Mode passed to EJB for detail at record # "+(i+1));
					hmResult.put(MSGID,"Invalid Mode");
				}
				throwExceptionWhenFailed(hmResult);
			}
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
