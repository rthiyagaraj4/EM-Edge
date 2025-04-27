/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201103            074099         NMC-JD-CRF-0011.1       Muthukumar N
-----------------------------------------------------------------------------------
*/

package eBL.PkgParameters;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import java.io.* ;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="PkgParameters"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PkgParameters"
*	local-jndi-name="PkgParameters"
*	impl-class-name="eBL.PkgParameters.PkgParametersManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eBL.PkgParameters.PkgParametersLocal"
*	remote-class="eBL.PkgParameters.PkgParametersRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.PkgParameters.PkgParametersLocalHome"
*	remote-class="eBL.PkgParameters.PkgParametersHome"
*	generate= "local,remote"
*
*
*/


public class PkgParametersManager implements SessionBean
{
	Connection con;
	SessionContext ctx;
	boolean insertable = false;
	String locale = "";
	StringBuffer sys_err = new StringBuffer("");	

	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
		this.ctx = context;
	}

	
/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap modify(java.util.Properties p,java.util.HashMap tabdata) 
	{		
		con = ConnectionManager.getConnection(p);
		PreparedStatement pstmt 	= null;
		HashMap return_mess = new HashMap();		
		int result = 0;
		String locale = "";

		//locale = (String) tabdata.get("locale");
		if(locale==null) locale="en";
		String facility_id = (String) tabdata.get("FACILITY_ID");
		facility_id = facility_id==null?"": facility_id;
		String pkgStatus = (String) tabdata.get("pkgStatus");
		pkgStatus = pkgStatus==null?"": pkgStatus;
		String pkgBkDateD = (String) tabdata.get("pkgBkDateD");
		pkgBkDateD = pkgBkDateD==null?"": pkgBkDateD;
		String glSmryYN = (String) tabdata.get("glSmryYN");
		glSmryYN = glSmryYN==null?"": glSmryYN;
		//String glSmry = (String) tabdata.get("glSmry");
		//glSmry = glSmry==null?"": glSmry;
		String valdDForOrd = (String) tabdata.get("valdDForOrd");
		valdDForOrd = valdDForOrd==null?"": valdDForOrd;
		String autoRefundYN = (String) tabdata.get("autoRefundYN");
		autoRefundYN = autoRefundYN==null?"": autoRefundYN;
		String valdRefundD = (String) tabdata.get("valdRefundD");
		valdRefundD = valdRefundD==null?"": valdRefundD;
		String unAvaldSrvCode = (String) tabdata.get("unAvaldSrvCode");
		unAvaldSrvCode = unAvaldSrvCode==null?"": unAvaldSrvCode;
		String pat_dep_for_pkg_code = (String) tabdata.get("pat_dep_for_pkg_code");
		pat_dep_for_pkg_code = pat_dep_for_pkg_code==null?"": pat_dep_for_pkg_code;
		String pkgServiceLimitBy = (String) tabdata.get("pkgServiceLimitBy");//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		pkgServiceLimitBy = pkgServiceLimitBy==null?"":"*".equals(pkgServiceLimitBy)?"":pkgServiceLimitBy;
		String dailyPkgLimitYN = (String) tabdata.get("dailyPkgLimitYN");//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		dailyPkgLimitYN = dailyPkgLimitYN==null?"": dailyPkgLimitYN;
		String dailyPkgLimitBy = (String) tabdata.get("dailyPkgLimitBy");//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		dailyPkgLimitBy = dailyPkgLimitBy==null?"": "*".equals(dailyPkgLimitBy)?"":dailyPkgLimitBy;
		
		//MMS-QH-CRF-0128.1-US001 & US004
		String pkgCustDiscNewPkgYN = (String) tabdata.get("pkgCustDiscNewPkgYN");
		pkgCustDiscNewPkgYN = pkgCustDiscNewPkgYN==null?"": pkgCustDiscNewPkgYN;
		String pkgCustDiscByPlcyYN = (String) tabdata.get("pkgCustDiscByPlcyYN");
		pkgCustDiscByPlcyYN = pkgCustDiscByPlcyYN==null?"": pkgCustDiscByPlcyYN;
		//MMS-QH-CRF-0128.1-US001 & US004
		
		//MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020 STARTS-->
		String PkgLimitIndBy = (String) tabdata.get("PkgLimitIndBy");
		PkgLimitIndBy = PkgLimitIndBy==null?"": "*".equals(PkgLimitIndBy)?"":PkgLimitIndBy;		
		//MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020 ENDS-->

		//V201103 Starts
		String autoDistPkgVarServiceOPYN = (String) tabdata.get("autoDistPkgVarServiceOPYN");
		autoDistPkgVarServiceOPYN = autoDistPkgVarServiceOPYN==null?"": autoDistPkgVarServiceOPYN;
		String autoDistPkgVarPharMedItemsOPYN = (String) tabdata.get("autoDistPkgVarPharMedItemsOPYN");
		autoDistPkgVarPharMedItemsOPYN = autoDistPkgVarPharMedItemsOPYN==null?"": autoDistPkgVarPharMedItemsOPYN;
		String autoDistPkgVarServiceIPYN = (String) tabdata.get("autoDistPkgVarServiceIPYN");
		autoDistPkgVarServiceIPYN = autoDistPkgVarServiceIPYN==null?"": autoDistPkgVarServiceIPYN;
		String autoDistPkgVarPharMedItemsIPYN = (String) tabdata.get("autoDistPkgVarPharMedItemsIPYN");
		autoDistPkgVarPharMedItemsIPYN = autoDistPkgVarPharMedItemsIPYN==null?"": autoDistPkgVarPharMedItemsIPYN;
		//V201103 Starts
		//Added for NMC-JD-CRF-0084 Starts palani narayanan V210128
		String prevpkgDepositYN = (String) tabdata.get("prevpkgDepositYN");		
		prevpkgDepositYN = prevpkgDepositYN==null?"": prevpkgDepositYN;
		//Added for NMC-JD-CRF-0084 ends palani narayanan V210128
		try
		{
		con.setAutoCommit( false );			
		insertable = true;			
		try
		{
			if(insertable)
			{
				if(null != pkgServiceLimitBy && "*".equals(pkgServiceLimitBy)) {
					pkgServiceLimitBy = "";
				}//Added V190625-Aravindh/MMS-DM-CRF-0129.1
				if(null != dailyPkgLimitBy && "*".equals(dailyPkgLimitBy)) {
					dailyPkgLimitBy = "";
				}//Added V190625-Aravindh/MMS-DM-CRF-0129.1
				//Added one parameter called prevpkgDepositYN for NMC-JD-CRF-0084 Starts palani narayanan V210128
				String sqlUpdate="update bl_parameters set PACKAGE_ENABLED_YN='"+pkgStatus+"', PKG_EFF_FRM_BACKDATE_DAYS='"+pkgBkDateD+"', gl_post_for_pkg_by_summary_yn='"+glSmryYN+"', valid_days_for_pkg_orders='"+valdDForOrd+"',				auto_refund_for_pkg_yn='"+autoRefundYN+"', valid_days_for_pkg_refund='"+valdRefundD+"', UNAVAIL_PKG_BLNG_SERV_CODE='"+unAvaldSrvCode+"', pat_dep_for_pkg='"+pat_dep_for_pkg_code+"', " +
				" pkg_serv_lmt_by='"+pkgServiceLimitBy+"',				daily_pkg_lmt_yn='"+dailyPkgLimitYN+"', 				daily_pkg_lmt_by='"+dailyPkgLimitBy+"'," +
				" pkg_cust_disc_new_pkg='"+pkgCustDiscNewPkgYN+"', pkg_cust_disc_by_policy='"+pkgCustDiscByPlcyYN+"', pkg_limit_ind_by='"+PkgLimitIndBy+"'," +
				" op_auto_pkg_var_dist_serv='"+autoDistPkgVarServiceOPYN+"',				 op_auto_pkg_var_dist_ph='"+autoDistPkgVarPharMedItemsOPYN+"',				ip_auto_pkg_var_dist_serv='"+autoDistPkgVarServiceIPYN+"',				ip_auto_pkg_var_dist_ph='"+autoDistPkgVarPharMedItemsIPYN+"'  , PKG_DEPOSIT_SUB_REQD_YN='"+prevpkgDepositYN+"' " +
				" where OPERATING_FACILITY_ID = '"+facility_id+"'";
				//Added V190625-Aravindh/MMS-DM-CRF-0129.1/Added 3 more columns in above Qry -> pkg_serv_lmt_by='"+pkgServiceLimitBy+"', daily_pkg_lmt_yn='"+dailyPkgLimitYN+"', daily_pkg_lmt_by='"+dailyPkgLimitBy+"'
				//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 - 2 columns (pkg_cust_disc_new_pkg, pkg_cust_disc_by_policy)
				pstmt = con.prepareStatement(sqlUpdate);
				
				result = pstmt.executeUpdate();					
				if(result<=0)
				{
					insertable=false;
					con.rollback();
				}
				else
				{
					insertable = true;	
					con.commit();
				}
				if (pstmt!=null)   pstmt.close();
			}//if insertable
			}catch(Exception e)
			{
				insertable=false;
				sys_err.append(" Exception while updating bl_parameters:"+e);
				System.out.println("Exception while updating bl_parameters::"+e);
				e.printStackTrace();
			}
		}catch (Exception e)
		{
			insertable=false;
			sys_err.append("Main Exception:"+e);
			System.out.println("Main Exception modify:"+e);
			e.printStackTrace();
		}		
		finally 
		{
			if (con != null)
			ConnectionManager.returnConnection(con, p);
		}
		return_mess.put("status",new Boolean(insertable));
		return_mess.put("error",result);
		return return_mess;	
	}//modify()
}
