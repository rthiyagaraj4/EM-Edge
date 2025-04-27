/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.Autoclaving;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="Autoclaving"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Autoclaving"
*	local-jndi-name="Autoclaving"
*	impl-class-name="eSS.Autoclaving.AutoclavingManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.Autoclaving.AutoclavingLocal"
*	remote-class="eSS.Autoclaving.AutoclavingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.Autoclaving.AutoclavingLocalHome"
*	remote-class="eSS.Autoclaving.AutoclavingHome"
*	generate= "local,remote"
*
*
*/

public class  AutoclavingManager extends SsEJBSessionAdapter {

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQL )  
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
															
			hmArgData.put(DATA,alDeleteData);
			hmArgSQL.put(DELETE_SQL,stSQL);

			hmReturn	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			alDeleteData		=	(ArrayList)	hmData.get("DeleteData");
			stSQL				=	(String)	hmSQL.get ("HdrDeleteSQL");
			
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

	public HashMap insert(HashMap hmData, HashMap hmSQL) 
	{
		System.err.println("@@@@@@@@@ inside ejb hmSQL="+hmSQL);
		System.err.println("@@@@@@@@@ inside ejb hmData="+hmData);
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		//ArrayList	alDtlRecords=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;
		String		rofSQL		=	null;
		String		washunitSQL		=	null;
		String		FetchLoadNoSQL		=	null;
		String next_load_no="";

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alHdrData			=	(ArrayList)	hmData.get("HdrInsertData");
			stSQL					=	(String)	hmSQL.get ("HdrInsertSQL");
			rofSQL					=	(String)	hmSQL.get ("ROFUpdateSQL");
			washunitSQL		=	(String)	hmSQL.get ("AutoclaveWashUnitUpdateSQL");
			FetchLoadNoSQL=	(String)	hmSQL.get ("FetchLoadNoSQL");

//			//System.out.println("HdrInsertData"+alHdrData);
//			//System.out.println("HdrInsertSQL"+stSQL);
			

// Fetch the next load no
//			//System.err.println("FetchLoadNoSQL"+FetchLoadNoSQL);
			next_load_no=fetchRecord(connection , FetchLoadNoSQL, (String)alHdrData.get(0)).get("NEXT_LOAD_NO").toString();

//			//System.out.println("Next Load No"+next_load_no);

// update autoclave_wash_unit master
			ArrayList alParameter	=new ArrayList(1);
			alParameter.add(alHdrData.get(0));	
			
			hmArgData.put(DATA,alParameter);
			hmArgSQL.put(UPDATE_SQL,washunitSQL);
System.err.println("#### 1 hmArgSQL="+hmArgSQL);
System.err.println("#### 1 hmArgData="+hmArgData);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
			
//			//System.out.println("Updated Wash Unit Master");
// Insert into autoclaving_hdr
			alHdrData.set(1,next_load_no);
			
			for (int i = 0 ; i < alHdrData.size() ; i++){
				if(alHdrData.get(i) == null || alHdrData.get(i).equals("null")){
					alHdrData.set(i,"");
				}
			}
			
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(INSERT_SQL,stSQL);
////System.out.println("alHdrDataaaa"+alHdrData);
System.err.println("#### 2 hmArgSQL="+hmArgSQL);
System.err.println("#### 2 hmArgData="+hmArgData);

			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

//			//System.out.println("Inserted Header");
// Inserting into autoclaving_dtl
			alDtlData	=	(ArrayList)		hmData.get("DtlInsertData");
			stSQL		=	(String)		hmSQL.get ("DtlInsertSQL");

			for (int i=0; i<alDtlData.size();i++ ) 
			{
				ArrayList	alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				if(hmRecord.get("SELECTED").equals("Y"))
				{
					alDtlRecord.add(alHdrData.get(0));
					alDtlRecord.add(next_load_no);
					alDtlRecord.add(alHdrData.get(10));
					alDtlRecord.add(hmRecord.get("doc_type_code"));
					alDtlRecord.add(hmRecord.get("doc_no"));
					alDtlRecord.add(hmRecord.get("group_code"));
					alDtlRecord.add(hmRecord.get("tray_no"));
					alDtlRecord.add(alHdrData.get(8));
					alDtlRecord.add(alHdrData.get(9));
					alDtlRecord.add(alHdrData.get(10));

					alDtlRecord.add(alHdrData.get(8));
					alDtlRecord.add(alHdrData.get(9));
					alDtlRecord.add(alHdrData.get(10));
				
	//				//System.out.println(alDtlRecord);
	//				alDtlRecords.add(alDtlRecord);
	//Insert into autoclaving_dtl
					stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
			
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(INSERT_SQL,stSQL);
System.err.println("#### 3 hmArgSQL="+hmArgSQL);
System.err.println("#### 3 hmArgData="+hmArgData);

					hmResult	=	insert(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);

	//				//System.out.println("Inserted Detail");

					//ROF dtl
					// UPDATE ROF
				ArrayList	alDtlRecordRof	=	new ArrayList();

				alDtlRecordRof.add(alHdrData.get(10));
				alDtlRecordRof.add(hmRecord.get("doc_type_code"));
				alDtlRecordRof.add(hmRecord.get("doc_no"));
				alDtlRecordRof.add(hmRecord.get("group_code"));
				alDtlRecordRof.add(hmRecord.get("tray_no"));


				stSQL				=	(String)	hmSQL.get ("ROFUpdateSQL");
			
	//			//System.out.println("stSQL"+stSQL);
				
				hmArgData.put(DATA,alDtlRecordRof);
				hmArgSQL.put(UPDATE_SQL,stSQL);
System.err.println("####4 hmArgSQL="+hmArgSQL);
System.err.println("#### 4 hmArgData="+hmArgData);

				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

	//			//System.out.println("Updated ROF Detail");
			}
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
		hmReturn.put("flag",""+next_load_no);
		return hmReturn;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmData, HashMap hmSQL) 
	{
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmResult	=	new HashMap();

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alHdrData1	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		
		Properties	properties	=	null;
		String		stSQL		=	null;
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

			for (int i=0; i<alDtlData.size();i++ ) 
			{
				ArrayList	alDtlRecord	=	new ArrayList();
				//ArrayList	alDtlModifyData	=	new ArrayList();
				hmResult.clear();
			
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				//System.out.println("GEETHA MODE"+hmRecord.get("mode").toString());

				 if(hmRecord.get("mode").toString().equals(MODE_DELETE))
				{
					//System.out.println("INSIDE DETAIL DELETE");
					if(hmRecord.get("SELECTED").equals("Y"))
					{
						alDtlRecord.add(alHdrData.get(11));
						alDtlRecord.add(alHdrData.get(12));
						alDtlRecord.add(alHdrData.get(9));
						alDtlRecord.add(hmRecord.get("doc_type_code"));
						alDtlRecord.add(hmRecord.get("doc_no"));
						alDtlRecord.add(hmRecord.get("group_code"));
						alDtlRecord.add(hmRecord.get("tray_no"));
				

						stSQL				=	(String)	hmSQL.get ("DtlDeleteSQL");
						hmArgData.put(DATA,alDtlRecord);

						hmArgSQL.put(DELETE_SQL,stSQL);
						hmResult	=	delete(connection, hmArgData, hmArgSQL);
					}
				}
				else// if(hmRecord.get("mode").toString().equals(MODE_MODIFY))
				{
					//System.out.println("HERE ");
					ArrayList	alDtlRecord1	=	new ArrayList();

/*					hmResult.put(RESULT,TRUE);
					hmResult.put(MESSAGE,"");
					hmResult.put(MSGID,"");
*/
//					dataMap.put("SQL_SS_AUTOCLAVE_DTL_UPDATE","UPDATE ss_autoclaving_dtl SET   modified_by_id=?, modified_date=SYSDATE, modified_at_ws_no=?, modified_facility_id=? WHERE facility_id=? AND autoclave_wash_unit_code=? AND load_no=? ");	 	
// to modify modified date, etc
					alDtlRecord1.add(alHdrData.get(7));
					alDtlRecord1.add(alHdrData.get(8));
					alDtlRecord1.add(alHdrData.get(9));

					alDtlRecord1.add(alHdrData.get(9));
					//alDtlRecord1.add(alHdrData.get(11)); //Comented by Sakti against  AAKH_CRF_0057  inc#52312
					//alDtlRecord1.add(alHdrData.get(12)); //Comented by Sakti against  AAKH_CRF_0057  inc#52312
					alDtlRecord1.add(alHdrData.get(15)); //Added by Sakti against  AAKH_CRF_0057  inc#52312
					alDtlRecord1.add(alHdrData.get(16)); //Added by Sakti against  AAKH_CRF_0057  inc#52312

					stSQL				=	(String)	hmSQL.get ("DtlModifySQL");
					hmArgData.put(DATA,alDtlRecord1);
					hmArgSQL.put(UPDATE_SQL,stSQL);

//					hmReturn	=	update(connection, hmArgData, hmArgSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);

//					throwExceptionWhenFailed(hmReturn);
		}
	/*	else{
//					//System.out.println("CRG"+hmRecord.get("mode").toString());
					hmResult.put(RESULT,FALSE);
					hmResult.put(MESSAGE,"Invalid Mode passed to EJB for detail at record # "+(i+1));
					hmResult.put(MSGID,"Invalid Mode");
				}
*/				throwExceptionWhenFailed(hmResult);


		//from here
		
		if(alHdrData.get(4).equals("F") && alHdrData.get(6).equals("Y"))
		{
		alHdrData1			=	(ArrayList)	hmData.get("HdrInsertData");	
//		//System.out.println("INSIDE HERE");
		String		rofSQL		=	null;
		String		washunitSQL		=	null;
		String		FetchLoadNoSQL		=	null;
		String next_load_no="";

		hmReturn.put(RESULT,FALSE);

			stSQL					=	(String)	hmSQL.get ("HdrInsertSQL");
			rofSQL					=	(String)	hmSQL.get ("ROFUpdateSQL");
			washunitSQL		=	(String)	hmSQL.get ("AutoclaveWashUnitUpdateSQL");
			FetchLoadNoSQL=	(String)	hmSQL.get ("FetchLoadNoSQL");

//			//System.out.println("HdrInsertData"+alHdrData1);
//			//System.out.println("HdrInsertSQL"+stSQL);
//			//System.out.println("PARAM"+(String)alHdrData1.get(0));
			

//			//System.out.println("FetchLoadNoSQL"+FetchLoadNoSQL);
			next_load_no=fetchRecord(connection , FetchLoadNoSQL, (String)alHdrData1.get(0)).get("NEXT_LOAD_NO").toString();

			System.out.println("Next Load No=========>"+next_load_no);

// update autoclave_wash_unit master
			ArrayList alParameter	=new ArrayList(1);
			alParameter.add(alHdrData1.get(0));	
			
			hmArgData.put(DATA,alParameter);
			hmArgSQL.put(UPDATE_SQL,washunitSQL);

			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			System.out.println("=========washunitSQL============>"+hmArgSQL);
			System.out.println("=========alHdrData1.get(0)============>"+hmArgData);
//			//System.out.println("Updated Wash Unit Master");
// Insert into autoclaving_hdr
			alHdrData1.set(1,next_load_no);
			alHdrData1.set(6,"N");
			alHdrData1.set(7,"N");

			hmArgData.put(DATA,alHdrData1);
			hmArgSQL.put(INSERT_SQL,stSQL);

			System.out.println("alHdrDataaaa============>"+alHdrData1);
			System.out.println("INSERT_SQL==============>"+hmArgSQL);

			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

//			//System.out.println("Inserted Header");
// Inserting into autoclaving_dtl
			alDtlData	=	(ArrayList)		hmData.get("DtlInsertData");
			stSQL		=	(String)		hmSQL.get ("DtlInsertSQL");

			for (int j=0; j<alDtlData.size();j++ ) 
			{
			//	ArrayList	alDtlRecord	=	new ArrayList();
//				HashMap hmRecord	=	(HashMap) alDtlData.get(j);
			//	if(hmRecord.get("SELECTED").equals("Y"))
			//	{
					alDtlRecord.add(alHdrData1.get(0));
					alDtlRecord.add(next_load_no);
					alDtlRecord.add(alHdrData1.get(10));
					alDtlRecord.add(hmRecord.get("doc_type_code"));
					alDtlRecord.add(hmRecord.get("doc_no"));
					alDtlRecord.add(hmRecord.get("group_code"));
					alDtlRecord.add(hmRecord.get("tray_no"));
					alDtlRecord.add(alHdrData1.get(8));
					alDtlRecord.add(alHdrData1.get(9));
					alDtlRecord.add(alHdrData1.get(10));

					alDtlRecord.add(alHdrData1.get(8));
					alDtlRecord.add(alHdrData1.get(9));
					alDtlRecord.add(alHdrData1.get(10));
				System.out.println("=========hmArgSQL===453====dtl=====>"+next_load_no);
	//				//System.out.println(alDtlRecord);
	//				alDtlRecords.add(alDtlRecord);
	//Insert into autoclaving_dtl
					stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
			
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(INSERT_SQL,stSQL);
					System.out.println("=========hmArgSQL=======dtl=====>"+hmArgSQL);
					System.out.println("=========hmArgData========dtl====>"+hmArgData);
					hmResult	=	insert(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);

	//				//System.out.println("Inserted Detail");

					//ROF dtl
					// UPDATE ROF
				ArrayList	alDtlRecordRof	=	new ArrayList();

				alDtlRecordRof.add(alHdrData1.get(10));
				alDtlRecordRof.add(hmRecord.get("doc_type_code"));
				alDtlRecordRof.add(hmRecord.get("doc_no"));
				alDtlRecordRof.add(hmRecord.get("group_code"));
				alDtlRecordRof.add(hmRecord.get("tray_no"));


				stSQL				=	(String)	hmSQL.get ("ROFUpdateSQL");
			
	//			//System.out.println("stSQL"+stSQL);
				
				hmArgData.put(DATA,alDtlRecordRof);
				hmArgSQL.put(UPDATE_SQL,stSQL);

				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);

	//			//System.out.println("Updated ROF Detail");
				//}
			}	
		hmReturn.put("flag",next_load_no);
		//return hmReturn;
		
		}
//		till here
			}
			connection.commit();
        }
		catch(Exception exception) {
			try {
				connection.rollback();
				System.out.println("======1=====error is here=======>"+exception.getMessage());
				exception.printStackTrace();
			}
			catch (Exception subException) {
				System.out.println("======2=====error is here=======>"+subException.getMessage());
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
