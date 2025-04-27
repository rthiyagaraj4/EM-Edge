/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.Packing;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import eSS.Common.SsEJBSessionAdapter;

/**
*
* @ejb.bean
*	name="Packing"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Packing"
*	local-jndi-name="Packing"
*	impl-class-name="eSS.Packing.PackingManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.Packing.PackingLocal"
*	remote-class="eSS.Packing.PackingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.Packing.PackingLocalHome"
*	remote-class="eSS.Packing.PackingHome"
*	generate= "local,remote"
*
*
*/

public class  PackingManager extends SsEJBSessionAdapter {

	public HashMap delete( HashMap hmData, HashMap hmSQL )  {
		return getMessageHashMap(false);
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap hmData, HashMap hmSQL) {
		return getMessageHashMap(false);
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify(HashMap hmData, HashMap hmSQL) {
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alDiscData	=	new ArrayList();
		ArrayList	alDiscInsData=	new ArrayList();
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
		//	System.err.println("hmReturn--88--in ejb update---->" +hmReturn);

			alDtlData	=	(ArrayList)		hmData.get("DtlModifyData");
			stSQL		=	(String)		hmSQL.get ("DtlModifySQL");

			alDiscData	=	(ArrayList)		hmData.get("DiscDtlInsertData");
			for (int i=0; i<alDtlData.size();i++ ) {
			ArrayList	alDtlRecord	=	new ArrayList();
				hmResult.clear();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				alDtlRecord.add(hmRecord.get("PACK_ITEM_CODE").toString());
				alDtlRecord.add(hmRecord.get("PACK_ITEM_QTY").toString());
				alDtlRecord.add(hmRecord.get("PACK_COST").toString());
				alDtlRecord.add(hmRecord.get("packing_date").toString());
				alDtlRecord.add(hmRecord.get("hold_yn").toString());
				alDtlRecord.add(hmRecord.get("hold_reason").toString());
				//System.err.println("alDtlRecord---in ejb-->" +alDtlRecord);
				String pack_by_id	=	"";
				if (hmRecord.get("packing_date").toString().equals(""))
				{
					pack_by_id	=	"";
				}
				else
				{	
					pack_by_id	=	(String)alHdrData.get(0);
				}
				alDtlRecord.add(pack_by_id);//pack_by_id
				//System.err.println("alDtlRecord---126---ejb" +alDtlRecord);

				String rof_status	=	"";
				if (hmRecord.get("packing_date").toString().equals(""))
					{
						rof_status	=	"HOLD";
					}
				else
					{
						rof_status	=	"PACK";
					}
				
				alDtlRecord.add(rof_status);

				alDtlRecord.add(alHdrData.get(0));
				alDtlRecord.add(alHdrData.get(1));
				alDtlRecord.add(alHdrData.get(2));

				alDtlRecord.add(alHdrData.get(3));
				alDtlRecord.add(alHdrData.get(4));
				alDtlRecord.add(alHdrData.get(5));
				alDtlRecord.add(hmRecord.get("group_code"));
				alDtlRecord.add(hmRecord.get("tray_no"));
				//System.err.println("alDtlRecord in ejb--153----->" +alDtlRecord);
				stSQL				=	(String)	hmSQL.get ("DtlModifySQL");
				hmArgData.put(DATA,alDtlRecord);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				//System.err.println("hmArgData--156--in ejb" +hmArgData);
				//System.err.println("hmArgSQL--157--in ejb" +hmArgSQL);
				//System.err.println("hmResult--158--in ejb" +hmResult);
				for (int j=0;j<alDiscData.size() ;j++ ) {
					HashMap hmDiscRecords	=	(HashMap)alDiscData.get(j);
//					//System.err.println("Loop#"+(j+1)+": "+hmDiscRecords);
					if(!( (hmDiscRecords.get("group_code").equals((String)hmRecord.get("group_code"))) && (hmDiscRecords.get("tray_no").equals((String)hmRecord.get("tray_no")))  )) continue;
					ArrayList alDiscRecords=new ArrayList();
					
					alDiscRecords.add(alHdrData.get(3));
					alDiscRecords.add(alHdrData.get(4));
					alDiscRecords.add(alHdrData.get(5));
					alDiscRecords.add(hmRecord.get("group_code"));
					alDiscRecords.add(hmRecord.get("tray_no"));   
					alDiscRecords.add(hmDiscRecords.get("item_code"));
					alDiscRecords.add(hmDiscRecords.get("write_off_reason_code"));
					alDiscRecords.add(hmDiscRecords.get("remarks"));
					alDiscRecords.add(hmDiscRecords.get("discrepancy_qty"));
					alDiscRecords.add(hmDiscRecords.get("discrepancy_cost"));
					alDiscRecords.add(alHdrData.get(0));
					alDiscRecords.add(alHdrData.get(1));
					alDiscRecords.add(alHdrData.get(2));
					alDiscRecords.add(alHdrData.get(0));
					alDiscRecords.add(alHdrData.get(1));
					alDiscRecords.add(alHdrData.get(2));
					alDiscInsData.add(alDiscRecords);		
				}
				throwExceptionWhenFailed(hmResult);
			}
			if (alDiscData.size()>0) {
				stSQL				=	(String)	hmSQL.get ("DiscDtlInsertSQL");
				hmArgData.put(DATA,alDiscInsData);
				hmArgSQL.put(INSERT_SQL,stSQL);
			//System.err.println("alDiscInsData:in ejb 193=============="+alDiscInsData);
			//System.err.println("hmArgData:194================"+hmArgData);
			//System.err.println("hmArgData:195================"+hmArgData);

				hmResult	=	insertBatch(connection, hmArgData, hmArgSQL);
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
			//System.err.println("hmReturn---in catch---" +hmReturn);
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
