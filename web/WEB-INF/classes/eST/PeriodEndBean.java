/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import eST.PeriodEnd.*;

import eST.Common.* ;
//import eST.PeriodEnd2.* ;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;

public class PeriodEndBean extends StAdapter implements Serializable {

	private String curr_proc_month;
	private String curr_proc_year;
	private String acc_entity_id;
	private String st_period_end_scope;
	//private String language_id;
	private String []facility_id;

	public void setAcc_entity_id(String acc_entity_id) {
		 this.acc_entity_id = acc_entity_id;
	}

	public String getAcc_entity_id( ) {
		 return acc_entity_id;
	}

	public void setSt_period_end_scope(String st_period_end_scope) {
		 this.st_period_end_scope = st_period_end_scope;
	}

	public String getSt_period_end_scope( ) {
		 return st_period_end_scope;
	}
	/*public void setLanguageId(String language_id) {
		 this.language_id = language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
	public void setCurr_proc_month(String curr_proc_month) {
		 this.curr_proc_month = curr_proc_month;
	}

	public void initFacility_id() throws Exception {
		setSt_period_end_scope(getPeriodEndScope());
		if (getSt_period_end_scope().equals("E")) {
			ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_SM_ACC_ENTITY_PARAM_FACL_SELECT_FACILITY"),getAcc_entity_id());
			facility_id=new String[alRecords.size()];
			for (int i=0; i<alRecords.size() ; i++ )
				facility_id[i]=(String)((HashMap)alRecords.get(i)).get("FACILITY_ID");
		}
		else{
			facility_id=new String[1];
			facility_id[0]=getLoginFacilityId();
		}
	}

	public String getCurr_proc_month( ) {
		 return curr_proc_month;
	}

	public void setCurr_proc_year(String curr_proc_year) {
		 this.curr_proc_year = curr_proc_year;
	}

	public String getCurr_proc_year( ) {
		 return curr_proc_year;
	}

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setCurr_proc_month((String) htRecordSet.get("curr_proc_month"));
		setCurr_proc_year((String) htRecordSet.get("curr_proc_year"));
	}

	public void clear(){
		super.clear();
		curr_proc_month="";
		curr_proc_year="";
	}

	private boolean anyRecordFound(String stSQL, String stProcessingPeriod)throws Exception{
		StringBuffer sbSQL		=	new StringBuffer(stSQL);
		StringBuffer sbQuestionMarks	=	new StringBuffer();
		for (int i=0;i<facility_id.length ;i++ ) 
			sbQuestionMarks.append("?,");
		sbQuestionMarks.deleteCharAt(sbQuestionMarks.length()-1);

		sbSQL.replace(stSQL.indexOf('@'),stSQL.indexOf('@')+1,sbQuestionMarks.toString());
		
		ArrayList alParameters=new ArrayList();
		alParameters.add(stProcessingPeriod);
		for (int i=0;i<facility_id.length ;i++ ) 
			alParameters.add(facility_id[i]);

		return !fetchRecord(sbSQL.toString(), alParameters).get("TOTAL").toString().equals("0");
	}

	public boolean isGLInterfaced() throws Exception{
		return getStParameter().get("GL_INTERFACE_YN").toString().equals("Y");
	}

	public HashMap validate() {
		HashMap hmReturn	=	getMessageHashMap(true);
		HashMap hmRecord	=	null;
		String	stProcessingPeriod	=	null;
		StringBuffer	sbMessage	=	new StringBuffer(getMessage("DOC_NOT_PROCESSED"));
		try { 
			hmRecord	=	getStParameter();

 		    stProcessingPeriod	=	hmRecord.get("CURR_PROC_MONTH").toString()+hmRecord.get("CURR_PROC_YEAR").toString();
			if (stProcessingPeriod.length()==5) 
				stProcessingPeriod = "0"+stProcessingPeriod;

			if(!fetchRecord(getStRepositoryValue("SQL_ST_PARAMETER_SELECT_VALID_FOR_PERIOD_END"), getLoginFacilityId()).get("DAYS").toString().equals("1")){
				//hmReturn.put(MSGID,"INVAL_PERIOD_END_DATE");
				hmReturn.put(RESULT,FALSE);
				hmReturn.put( "message", getSTMessage(getLanguageId(),"INVAL_PERIOD_END_DATE","ST") ) ;
				return hmReturn;
				//throw new Exception("INVAL_PERIOD_END_DATE");
			}
/*
			if (anyRecordFound(getStRepositoryValue("SQL_ST_ADJ_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Adjustment");

			if (anyRecordFound(getStRepositoryValue("SQL_ST_GRN_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("GRN");

			if (anyRecordFound(getStRepositoryValue("SQL_ST_ISSUE_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Issue");

			if (anyRecordFound(getStRepositoryValue("SQL_ST_ISSUE_RET_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Issue Return");

			if (anyRecordFound(getStRepositoryValue("SQL_ST_MFG_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Manufacturing");

			if (anyRecordFound(getStRepositoryValue("SQL_ST_PROD_TRANSFER_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Product Transfer");

			if (anyRecordFound(getStRepositoryValue("SQL_ST_RTV_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Return");

			if (anyRecordFound(getStRepositoryValue("SQL_ST_SAL_RET_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Sales");

			if (anyRecordFound(getStRepositoryValue("SQL_ST_TRANSFER_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Stock Transfer");
*/				
		}
		catch (Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,sbMessage.replace(11,12,exception.getMessage()).toString());
			exception.printStackTrace();
		}
		return hmReturn;
	}

 	public HashMap modify() {
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		ArrayList	alItmMovData=	new ArrayList()	;
		ArrayList	alCommonData=	new ArrayList()	;
		String locale = getLanguageId(); // Added for TBMC-SCF-0018
		//System.out.println("locale" + locale);
		int iMonth	=	Integer.parseInt(getCurr_proc_month());
		int iYear	=	Integer.parseInt(com.ehis.util.DateUtils.convertDate(getCurr_proc_year(),"YY",locale,"en")); //MODIFIED FOR TBMC-SCF-0018

		alItmMovData.add(getLoginById()			);
		alItmMovData.add(getLoginAtWsNo()		);
		alItmMovData.add(getLoginById()			);
		alItmMovData.add(getLoginAtWsNo()		);
		alItmMovData.add(new Long(iYear)		);
		alItmMovData.add(new Long(iMonth)		);

		hmTableData.put	( "old_period_month",""+iMonth);
		hmTableData.put	( "old_period_year",""+iYear);


		if (++iMonth > 12) {
			iMonth	=	1;
			iYear++;
		}

		hmTableData.put	( "new_period_month",""+iMonth);
		hmTableData.put	( "new_period_year",""+iYear);
		
		alModifyData.add(new Long(iMonth)	);
		alModifyData.add(new Long(iYear)	);

		alModifyData.add(getLoginById()			);
		alModifyData.add(getLoginAtWsNo()		);
		alModifyData.add(getLoginFacilityId()	);

		alCommonData.add(getLoginById()			);
		alCommonData.add(getLoginAtWsNo()		);
		alCommonData.add(getLoginFacilityId()	);

//		alModifyData.add(getLoginFacilityId()	);

		hmTableData.put	( "COMMON_DATA",alCommonData);
		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alModifyData);
		hmTableData.put	( "ItmMovData",alItmMovData);
		hmTableData.put	( "facility_id",facility_id);
        



		if (getSt_period_end_scope().equals("E")) {
			hmTableData.put	( "acc_entity_id",getAcc_entity_id());
		}
		
		hmSQLMap.put	( "SQL_ST_CHECK_VALUE_PERIOD_END", getStRepositoryValue("SQL_ST_CHECK_VALUE_PERIOD_END"));		
				
		hmSQLMap.put	( "SQL_ST_UPDATE_VALUE_PERIOD_END", getStRepositoryValue("SQL_ST_UPDATE_VALUE_PERIOD_END"));		

		hmSQLMap.put	( "SQL_ST_ITEM_MOVE_SUMM_CHECK_VALUE_PERIOD_END", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_CHECK_VALUE_PERIOD_END"));		
		hmSQLMap.put	( "SQL_ST_ITEM_MOVE_SUMM_COUNT_CHECK", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_COUNT_CHECK"));		
		hmSQLMap.put	( "SQL_ST_ITM_MOV_SUMM_INSERT_PERIOD_END", getStRepositoryValue("SQL_ST_ITM_MOV_SUMM_INSERT_PERIOD_END"));		

		
		hmSQLMap.put	( "SQL_ST_PARAMETER_UPDATE_FOR_PERIOD_END", getStRepositoryValue("SQL_ST_PARAMETER_UPDATE_FOR_PERIOD_END"));
		hmSQLMap.put	( "SQL_ST_ACC_ENTITY_PARAM_UPDATE_FOR_PERIOD_END", getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_UPDATE_FOR_PERIOD_END"));
		hmSQLMap.put	( "SQL_ST_ITM_MOV_SUMM_INSERT_FOR_PERIOD_END", getStRepositoryValue("SQL_ST_ITM_MOV_SUMM_INSERT_FOR_PERIOD_END"));
		return periodEndMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public HashMap periodEndMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){

		HashMap		hmResult	=	new HashMap()	;
		//eST.PeriodEnd2.PeriodEndManager periodEndManager = new eST.PeriodEnd2.PeriodEndManager();
		//PeriodEndHome	periodEndHome		= null ;
		//PeriodEndRemote	periodEndRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
		/*	InitialContext context = new InitialContext() ;

			Object object = context.lookup( getStRepositoryValue("JNDI_ST_PERIOD_END") ) ;

			periodEndHome  = (PeriodEndHome) PortableRemoteObject.narrow( object, PeriodEndHome.class ) ;
			periodEndRemote = periodEndHome.create() ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_PERIOD_END"),PeriodEndHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			switch (functionID)
			{
				case FUNCTION_INSERT:
					 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		
					//hmResult = periodEndRemote.insert( hmTableData, hmSQLMap ) ;
					//hmResult =periodEndManager.insert( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_UPDATE:
					 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					//hmResult = periodEndRemote.modify( hmTableData, hmSQLMap ) ;
					//hmResult = 	periodEndManager.modify( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_DELETE:
					 hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				//	hmResult = periodEndRemote.delete( hmTableData, hmSQLMap ) ;
					//periodEndManager.delete( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to periodEndMethodCall()") ;
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else if( hmResult.get("msgid")!=null  )
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		} 
		catch(Exception exception) {
			hmResult.put( "message", "Bean 383: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		//finally {
/*			try {
				//if( periodEndRemote != null )
				//	periodEndRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", "Bean 393: "+exception.toString()) ;
			}*/
	//	}
		return hmResult;
	}

	public void loadData() throws Exception {
		HashMap hmRecord	=	null;
		hmRecord			=	fetchRecord(getStRepositoryValue("SQL_ST_PARAMETER_SELECT_SINGLE"), getLoginFacilityId());
		setCurr_proc_month  ( checkForNull((String)hmRecord.get("CURR_PROC_MONTH" ))) ;
		setCurr_proc_year   ( checkForNull((String)hmRecord.get("CURR_PROC_YEAR" ))) ;	
	}
}
