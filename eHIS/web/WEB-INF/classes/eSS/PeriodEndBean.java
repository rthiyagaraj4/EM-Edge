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

import eSS.Common.* ;
import eSS.SSPeriodEnd.* ;
import javax.naming.InitialContext ;
import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpSession;

public class PeriodEndBean extends SsAdapter implements Serializable {

	private String curr_proc_month;
	private String curr_proc_year;
	private String acc_entity_id;
	private String ss_period_end_scope;
	private String []facility_id;

	public void setAcc_entity_id(String acc_entity_id) {
		 this.acc_entity_id = acc_entity_id;
	}

	public String getAcc_entity_id( ) {
		 return acc_entity_id;
	}

	public void setSs_period_end_scope(String ss_period_end_scope) {
		 this.ss_period_end_scope = ss_period_end_scope;
	}

	public String getSs_period_end_scope( ) {
		 return ss_period_end_scope;
	}
	
	public void setCurr_proc_month(String curr_proc_month) {
		 this.curr_proc_month = curr_proc_month;
	}

	public void initFacility_id() throws Exception {
		setSs_period_end_scope(getPeriodEndScope());
		if (getSs_period_end_scope().equals("E")) {
			ArrayList alRecords	=	fetchRecords(getSsRepositoryValue("SQL_SM_ACC_ENTITY_PARAM_FACL_SELECT_FACILITY"),getAcc_entity_id());
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
		return getSSParameter().get("GL_INTERFACE_YN").toString().equals("Y");
	}

	public HashMap validate() {
		HashMap hmReturn	=	getMessageHashMap(true);
		HashMap hmRecord	=	null;
		String	stProcessingPeriod	=	null;
		StringBuffer	sbMessage	=	new StringBuffer(getMessage("DOCUMENT_NOT_PROCESSED"));
		try { 
			hmRecord	=	getSSParameter();
/*			if (hmRecord.get("GL_INTERFACE_YN").toString().equals("N")) {
				hmReturn.put(MSGID,"SS_NOT_INTRFCD_WTH_GL");
				throw new Exception("SS_NOT_INTRFCD_WTH_GL");
			}
*/			stProcessingPeriod	=	hmRecord.get("CURR_PROC_MONTH").toString()+hmRecord.get("CURR_PROC_YEAR").toString();
			if (stProcessingPeriod.length()==5) 
				stProcessingPeriod = "0"+stProcessingPeriod;

			if(!fetchRecord(getSsRepositoryValue("SQL_SS_PARAMETER_SELECT_VALID_FOR_PERIOD_END"), getLoginFacilityId()).get("DAYS").toString().equals("1")){
				hmReturn.put(MSGID,"INVALID_PERIOD_END_DATE");
				
				throw new Exception("INVALID_PERIOD_END_DATE");
				
			}
			/*if (anyRecordFound(getSsRepositoryValue("SQL_SS_ISSUE_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Issue");
			if (anyRecordFound(getSsRepositoryValue("SQL_SS_RETURN_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Return");
			if (anyRecordFound(getSsRepositoryValue("SQL_SS_RET_ITEM_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Return Instruments");
			if (anyRecordFound(getSsRepositoryValue("SQL_SS_ROF_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("ROF");
			if (anyRecordFound(getSsRepositoryValue("SQL_SS_WRITE_OFF_HDR_SELECT_FOR_PERIOD_END"), stProcessingPeriod)) 
				throw new Exception("Write Off");*/
		}
		catch (Exception exception) {
			//System.out.println("error us++=>"+exception.getMessage());
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
		
		int iMonth	=	Integer.parseInt(getCurr_proc_month());
		int iYear	=	Integer.parseInt(getCurr_proc_year());
		if (++iMonth > 12) {
			iMonth	=	1;
			iYear++;
		}

		alModifyData.add(new Long(iMonth)	);
		alModifyData.add(new Long(iYear)	);

		alModifyData.add(getLoginById()			);
		alModifyData.add(getLoginAtWsNo()		);
		alModifyData.add(getLoginFacilityId()	);

//		alModifyData.add(getLoginFacilityId()	);

		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alModifyData);
		hmTableData.put	( "facility_id",facility_id);
		if (getSs_period_end_scope().equals("E")) {
			hmTableData.put	( "acc_entity_id",getAcc_entity_id());
		}
		hmSQLMap.put	( "SQL_SS_PARAMETER_UPDATE_FOR_PERIOD_END", getSsRepositoryValue("SQL_SS_PARAMETER_UPDATE_FOR_PERIOD_END"));
		hmSQLMap.put	( "SQL_SS_ACC_ENTITY_PARAM_UPDATE_FOR_PERIOD_END", getSsRepositoryValue("SQL_SS_ACC_ENTITY_PARAM_UPDATE_FOR_PERIOD_END"));

		return periodEndMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public HashMap periodEndMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
/*		HashMap		hmResult	=	new HashMap()	;
		hmResult	= new eSS.PeriodEnd12.PeriodEndManager().modify( hmTableData, hmSQLMap ) ;
		if( ((Boolean) hmResult.get("result")).booleanValue() )	
			hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
		else if( hmResult.get("msgid")!=null  )
			hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
		else
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		return hmResult;
*/
		HashMap		hmResult	=	new HashMap()	;
	//	PeriodEndHome	periodEndHome		= null ;
		SSPeriodEndRemote	periodEndRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
/*			InitialContext context = new InitialContext() ;

			Object object = context.lookup( getSsRepositoryValue("JNDI_SS_PERIOD_END") ) ;

			periodEndHome  = (PeriodEndHome) PortableRemoteObject.narrow( object, PeriodEndHome.class ) ;
			periodEndRemote = periodEndHome.create() ;*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( getSsRepositoryValue("JNDI_SS_PERIOD_END"),SSPeriodEndHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();


			switch (functionID)
			{
				case FUNCTION_INSERT:
					hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					//hmResult = periodEndRemote.insert( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_UPDATE:
					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					//hmResult = periodEndRemote.modify( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_DELETE:
					hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					//hmResult = periodEndRemote.delete( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to periodEndMethodCall()") ;
			}
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
			//	hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			else if( hmResult.get("msgid")!=null  )
				//hmResult.put( "message", replaceNewLineChar(getMessage((String) hmResult.get( "msgid" )) )) ;
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		} 
		catch(Exception exception) {
			//System.err.println( "Error Calling Request Group EJB : "+exception) ;
			hmResult.put( "message", "Bean 383: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( periodEndRemote != null )
					periodEndRemote.remove() ;
			}
			catch( Exception exception) {
				System.err.println( exception.getMessage() ) ;
				hmResult.put( "message", "Bean 393: "+exception.toString()) ;
			}
		}
		return hmResult;
	}

	public void loadData() throws Exception {
		HashMap hmRecord	=	null;
		hmRecord			=	fetchRecord(getSsRepositoryValue("SQL_SS_PARAMETER_SELECT_SINGLE"), getLoginFacilityId());
		setCurr_proc_month  ( (String)hmRecord.get("CURR_PROC_MONTH" )			) ;
		setCurr_proc_year   ( (String)hmRecord.get("CURR_PROC_YEAR" )			) ;	
	}
}
