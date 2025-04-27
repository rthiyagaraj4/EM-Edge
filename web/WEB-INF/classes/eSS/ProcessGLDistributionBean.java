/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Hashtable;
//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
import java.util.HashMap;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import eSS.Common.SsAdapter;
import eSS.ProcessGLDistribution.*;

import eSS.Common.* ;

public class ProcessGLDistributionBean extends SsAdapter implements java.io.Serializable {

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
		curr_proc_month="";
		curr_proc_year="";
	}

	private boolean anyRecordFound(String stSQL, String stProcessingPeriod)throws Exception{
		return !fetchRecord(stSQL, stProcessingPeriod).get("TOTAL").toString().equals("0");
	}

	public boolean isGLInterfaced() throws Exception{
		return getSSParameter().get("GL_INTERFACE_YN").toString().equals("Y");
	}

	public HashMap modify() {
		String sql = "";
	//	String message_id = "";
	//	int value = -1;
	//	boolean result = false;
		//CallableStatement callableStatement = null;
		Properties properties = getProperties();
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData	=	new HashMap();
		HashMap hmSQLMap	=	new HashMap();
		ArrayList InParam = new ArrayList();
		ArrayList OutParam = new ArrayList();
		
		hmResult.put("result", new Boolean(false)) ;
		sql = "{ call SSBGLEXP.SS_EXPORT_TO_GL(?, ?, ?, ?, ?) }";
		InParam.add(login_facility_id);
		InParam.add(login_by_id);
		InParam.add(login_at_ws_no);
		OutParam.add(new Integer(java.sql.Types.VARCHAR));
		OutParam.add(new Integer(java.sql.Types.INTEGER));

		hmTableData.put("OutParameter",OutParam);
		hmTableData.put("InParameter",InParam);
		hmTableData.put("properties",properties);
		hmSQLMap.put("CallStatement",sql);

		//ProcessGLDistributionHome processGLDistributionHome = null;
		//ProcessGLDistributionRemote processGLDistributionRemote = null;
		try {
		/*	InitialContext context = new InitialContext();
			Object object = context.lookup(eSS.Common.SsRepository.getSsKeyValue("JNDI_PROCESS_GL_DISTRIBUTION"));
			processGLDistributionHome  = (ProcessGLDistributionHome) PortableRemoteObject.narrow(object, ProcessGLDistributionHome.class);
			processGLDistributionRemote = processGLDistributionHome.create();
			hmResult = processGLDistributionRemote.insert(hmTableData, hmSQLMap);*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( eSS.Common.SsRepository.getSsKeyValue("JNDI_PROCESS_GL_DISTRIBUTION"),ProcessGLDistributionHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if(((Boolean) hmResult.get("result")).booleanValue())		
				hmResult.put("message", getMessage((String) hmResult.get("msgid")));
			else
				hmResult.put("message", hmResult.get("msgid"));
		} 
		catch(Exception e) {
			//System.err.println("Error Calling EJB : SSM"+e);
			hmResult.put("message", e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
	//			if(processGLDistributionRemote != null)
	//				processGLDistributionRemote.remove();
			}
			catch(Exception ee) {
				//System.err.println("Exceptions : SSM "+ee.getMessage());
				hmResult.put("message", ee.getMessage());
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
