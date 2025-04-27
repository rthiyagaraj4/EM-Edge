/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;
import eSS.Common.SsAdapter;
import eSS.PrintCount.*;

public class PrintCountSheetBean extends eSS.Common.SsTransaction implements Serializable {
	String PhyInvId="";
	String P_fm_store_code="" ;
	String P_to_store_code="" ;
	String P_fm_curr_store_code="" ;
	String P_to_curr_store_code="" ;
	String P_fm_group_code="";
	String P_to_group_code="" ;

	public PrintCountSheetBean() {
	}

	

	public void  setP_fm_store_code(String P_fm_store_code){
		this.P_fm_store_code=P_fm_store_code.toUpperCase();
	}
	public void  setP_to_store_code(String P_to_store_code){
		this.P_to_store_code=P_to_store_code.toUpperCase();
	}
	public void  setP_fm_curr_store_code(String P_fm_curr_store_code){
		this.P_fm_curr_store_code=P_fm_curr_store_code.toUpperCase();
	}
	public void  setP_to_curr_store_code(String P_to_curr_store_code){
		this.P_to_curr_store_code=P_to_curr_store_code.toUpperCase();
	}
	public void  setP_to_group_code(String setP_to_group_code){
		this.P_to_group_code=setP_to_group_code.toUpperCase();
	}
	public void  setP_fm_group_code(String setP_fm_group_code){
		this.P_fm_group_code=setP_fm_group_code.toUpperCase();
	}

	

	public void setAll(Hashtable htResult) {
		setP_fm_store_code((String)htResult.get("p_fm_store_code")) ;
		setP_to_store_code((String)htResult.get("p_to_store_code")) ;
		setP_fm_curr_store_code((String)htResult.get("p_fm_curr_store_code")) ;
		setP_to_curr_store_code((String)htResult.get("p_to_curr_store_code")) ;
		setP_fm_group_code((String)htResult.get("p_fm_group_code")) ;
		setP_to_group_code((String)htResult.get("p_to_group_code")) ;
		setMode(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))	;
		try {
				getPhyInvId();
		} catch ( Exception e )	{
			e.printStackTrace() ;
		} 
	}

	public void getPhyInvId()  {
		String   PhyInvId ="";
		try {
			 PhyInvId= fetchRecord(getSsRepositoryValue("SQL_SS_PRINT_COUNT_PHY_INV_ID"),getLoginFacilityId()).get("PHYINVID").toString();
			 this.PhyInvId= PhyInvId;
		} 
		catch ( Exception e )	{
			e.printStackTrace() ;
		} 
	}

	public HashMap insert() {
		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	    alHdrInsertData		=	new ArrayList()	;
		HashMap		hmSQLMap			=	new HashMap()	;
	
		alHdrInsertData.add(getLoginFacilityId()	);  
		alHdrInsertData.add(PhyInvId	);      
		alHdrInsertData.add(P_fm_store_code);      
		alHdrInsertData.add(P_to_store_code);      
		alHdrInsertData.add(P_fm_curr_store_code);      
		alHdrInsertData.add(P_to_curr_store_code);      
		alHdrInsertData.add(P_fm_group_code);      
		alHdrInsertData.add(P_to_group_code);      
		alHdrInsertData.add(getLoginById()		);      
		alHdrInsertData.add(getLoginAtWsNo()	);    
		alHdrInsertData.add(getLoginFacilityId());

			
		hmSQLMap.put( "InsertParamSQL", getSsRepositoryValue("SQL_SS_PRINT_COUNT_PHY_INV_INSERT")		);
		
		hmSQLMap.put( "InsertHdrSQL", getSsRepositoryValue("SQL_SS_PRINT_COUNT_PHY_INV_HDR_INSERT")		);
		
		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "HdrInsertData",		alHdrInsertData	);
		
		
		return dipatchingMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public HashMap dipatchingMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){

		HashMap		hmResult	=	new HashMap()	;

		try{
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( getSsRepositoryValue("JNDI_PRINT_COUNT_SHEET"),PrintCountHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		
				  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		}
		catch (Exception e){}

		if( ((Boolean) hmResult.get("result")).booleanValue() )	
			hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
		else if( hmResult.get("msgid")!=null  )
			hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
		else
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;

		return hmResult;
	}
		
}
