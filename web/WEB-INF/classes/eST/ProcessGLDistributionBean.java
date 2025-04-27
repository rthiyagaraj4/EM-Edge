/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST ;

//pmd 21/02/05
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;*/
import java.util.ArrayList;
import java.util.Properties;
import java.util.Hashtable;
//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
import java.util.HashMap;
//import eST.Common.StRepository;
//import eCommon.Common.CommonRepository;
//import eST.Common.StAdapter;
import eST.ProcessGLDistribution.*;

import eST.Common.* ;

public class ProcessGLDistributionBean extends StAdapter implements java.io.Serializable {

	private String curr_proc_month;
	private String curr_proc_year;

	public void setCurr_proc_month(String curr_proc_month) {
		 this.curr_proc_month = curr_proc_month;
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
		curr_proc_month=null;
		curr_proc_year=null;
	}

	public void initialize()
	{
		super.initialize();
		curr_proc_month="";
		curr_proc_year="";

	}
	private boolean anyRecordFound(String stSQL, String stProcessingPeriod)throws Exception{
		return !fetchRecord(stSQL, stProcessingPeriod).get("TOTAL").toString().equals("0");
	}

	/*public boolean isGLInterfaced() throws Exception{
		return getSTParameter().get("GL_INTERFACE_YN").toString().equals("Y");
	}*/

	public HashMap modify() {
		String sql = "";
		String acc_entity_code = "";
		try{
			acc_entity_code = (String)fetchRecord("SELECT ACC_ENTITY_ID FROM SM_ACC_ENTITY_PARAM_FACL WHERE FACILITY_ID = ?", login_facility_id).get("ACC_ENTITY_ID");
		}catch(Exception e){
			e.printStackTrace();
		}
//		int value = -1;
//		boolean result = false;
		Properties properties = getProperties();
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData	=	new HashMap();
		HashMap hmSQLMap	=	new HashMap();
		ArrayList InParam = new ArrayList();
		ArrayList OutParam = new ArrayList();
		
		hmResult.put("result", new Boolean(false)) ;
		sql = "{ call STBGLEXP.ST_EXPORT_TO_GL(?, ?, ?, ?) }";
		InParam.add(acc_entity_code);
		InParam.add(login_facility_id);
		//InParam.add(login_by_id);
		//InParam.add(login_at_ws_no);
		OutParam.add(new Integer(java.sql.Types.VARCHAR));
		OutParam.add(new Integer(java.sql.Types.INTEGER));

		hmTableData.put("OutParameter",OutParam);
		hmTableData.put("InParameter",InParam);
		hmTableData.put("properties",properties);
		hmSQLMap.put("CallStatement",sql);


		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( eST.Common.StRepository.getStKeyValue("JNDI_PROCESS_GL_DISTRIBUTION"),ProcessGLDistributionHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)busObj.getClass().getMethod("insert",paramArray).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if(((Boolean) hmResult.get("result")).booleanValue())		
				hmResult.put("message", getSTMessage(getLanguageId(),(String) hmResult.get("msgid"),"ST"));
			else
				hmResult.put("message", hmResult.get("message"));
		}catch(Exception e) {
			hmResult.put("message", e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
	//			if(processGLDistributionRemote != null)
	//				processGLDistributionRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.getMessage());
			}
		}

		//ProcessGLDistributionHome processGLDistributionHome = null;
		//ProcessGLDistributionRemote processGLDistributionRemote = null;
	/*	try {
			InitialContext context = new InitialContext();
			Object object = context.lookup(eST.Common.StRepository.getStKeyValue("JNDI_PROCESS_GL_DISTRIBUTION"));
			processGLDistributionHome  = (ProcessGLDistributionHome) PortableRemoteObject.narrow(object, ProcessGLDistributionHome.class);
			processGLDistributionRemote = processGLDistributionHome.create();
			hmResult = processGLDistributionRemote.insert(hmTableData, hmSQLMap);
			if(((Boolean) hmResult.get("result")).booleanValue())		
				hmResult.put("message", getMessage((String) hmResult.get("msgid")));
			else
				hmResult.put("message", hmResult.get("msgid"));
		} 
		catch(Exception e) {
			hmResult.put("message", e.getMessage());
			e.printStackTrace();
		} */
/*		finally {
			try {
			//	if(processGLDistributionRemote != null)
				//	processGLDistributionRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.getMessage());
			}
		}*/
		return hmResult;
	}

	public void loadData() throws Exception {
		HashMap hmRecord	=	null;
		hmRecord			=	fetchRecord(getStRepositoryValue("SQL_ST_PARAMETER_SELECT_SINGLE"), getLoginFacilityId());
		setCurr_proc_month  ( checkForNull((String)hmRecord.get("CURR_PROC_MONTH" ))) ;
		setCurr_proc_year   ( checkForNull((String)hmRecord.get("CURR_PROC_YEAR" ))) ;	
	}

	public String isGL_INTERFACE_YN() {
		HashMap hm=new HashMap();
		String returnValue="";
		try
		{
			hm=fetchRecord(getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT"));
			returnValue=checkForNull((String)hm.get("GL_INTERFACE_YN"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

}
