/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.SSPeriodEnd;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="SSPeriodEnd"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SSPeriodEnd"
*	local-jndi-name="SSPeriodEnd"
*	impl-class-name="eSS.SSPeriodEnd.SSPeriodEndManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.SSPeriodEnd.SSPeriodEndLocal"
*	remote-class="eSS.SSPeriodEnd.SSPeriodEndRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.SSPeriodEnd.SSPeriodEndLocalHome"
*	remote-class="eSS.SSPeriodEnd.SSPeriodEndHome"
*	generate= "local,remote"
*
*
*/

public class  SSPeriodEndManager extends SsEJBSessionAdapter {

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQL )  {
		HashMap		hmReturn	=	new HashMap();
		hmReturn.put(RESULT,FALSE);
		return hmReturn;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmData, HashMap hmSQL) {
		HashMap		hmReturn	=	new HashMap();
		hmReturn.put(RESULT,FALSE);
		return hmReturn;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmData, HashMap hmSQL)  {
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
//		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
//		ArrayList	alDtlData	=	new ArrayList();
//		ArrayList	alDtlRecords=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alHdrData			=	(ArrayList)	hmData.get("ModifyData");
			
			String acc_entity_id=(String)hmData.get("acc_entity_id");
			if (acc_entity_id!=null) {
				stSQL				=	(String)	hmSQL.get ("SQL_SS_ACC_ENTITY_PARAM_UPDATE_FOR_PERIOD_END");
				alHdrData.add(acc_entity_id);
				hmArgData.put(DATA,alHdrData);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmReturn	=	update(connection, hmArgData, hmArgSQL);
				
				throwExceptionWhenFailed(hmReturn);
			}

			if (acc_entity_id!=null) {
				alHdrData.remove(5);
				
			}
			
			String []facility_id=	(String[])	hmData.get("facility_id");
			stSQL				=	(String)	hmSQL.get ("SQL_SS_PARAMETER_UPDATE_FOR_PERIOD_END");

			



/**/			
			StringBuffer sbSQL		=	new StringBuffer(stSQL);
		
			StringBuffer sbQuestionMarks	=	new StringBuffer();
			for (int i=0;i<facility_id.length ;i++ ) 
				sbQuestionMarks.append("?,");
			sbQuestionMarks.deleteCharAt(sbQuestionMarks.length()-1);
			sbSQL.replace(stSQL.indexOf('@'),stSQL.indexOf('@')+1,sbQuestionMarks.toString());
/**/
			for (int i=0;i<facility_id.length ;i++ ) 
				alHdrData.add(facility_id[i]);
			
			

			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(UPDATE_SQL,sbSQL.toString());
        
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
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
}
