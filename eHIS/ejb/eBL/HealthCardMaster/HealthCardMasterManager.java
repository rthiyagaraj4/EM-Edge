/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.HealthCardMaster;


import javax.naming.*;
import javax.rmi.*;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import blHcard.HealthCardAgeDetailBean;
import blHcard.HealthCardCashBillingGroupBean;
import blHcard.HealthCardVisitRuleBean;

import webbeans.eCommon.ConnectionManager;


/**
*
* @ejb.bean
*	name="HealthCardMaster"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="HealthCardMaster"
*	local-jndi-name="HealthCardMaster"
*	impl-class-name="eBL.HealthCardMaster.HealthCardMasterManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eBL.HealthCardMaster.HealthCardMasterLocal"
*	remote-class="eBL.HealthCardMaster.HealthCardMasterRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.HealthCardMaster.HealthCardMasterLocalHome"
*	remote-class="eBL.HealthCardMaster.HealthCardMasterHome"
*	generate= "local,remote"
*
*
*/


public class HealthCardMasterManager implements SessionBean {

	//private static final long serialVersionUID = 1L;

	//@SuppressWarnings("unused")
	private SessionContext context;

	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext ctx) {
		context = ctx;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertRecords(java.util.Properties p,HashMap inputParameters,HashMap listParam) {

		

		Connection con = ConnectionManager.getConnection(p);
		StringBuffer sysError = new StringBuffer();
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		
		ArrayList<blHcard.HealthCardAgeDetailBean> hcAgeDetailList = new ArrayList<blHcard.HealthCardAgeDetailBean>();
		ArrayList<blHcard.HealthCardVisitRuleBean> hcVisitDetailList = new ArrayList<blHcard.HealthCardVisitRuleBean>();
		ArrayList<blHcard.HealthCardCashBillingGroupBean> hcBlngGrpList = new ArrayList<blHcard.HealthCardCashBillingGroupBean>();
		
		hcAgeDetailList = (ArrayList<blHcard.HealthCardAgeDetailBean>)listParam.get("ageList");
		hcVisitDetailList = (ArrayList<blHcard.HealthCardVisitRuleBean>)listParam.get("visitList");
		hcBlngGrpList = (ArrayList<blHcard.HealthCardCashBillingGroupBean>)listParam.get("bgList");
		
	try{
			
		boolean hcCardHeaderInsertSuccess=false;
		boolean hcAgeDetailInsertSuccess=false;
		boolean hcVisitDetailSuccess=false;
		boolean hcBlngGrpSuccess=false;
		
		
		
		/* Inserts Card Data Credentials */
		returnMessage=insertHealthCardHeader(con,inputParameters);
		hcCardHeaderInsertSuccess = Boolean.parseBoolean(returnMessage.get("status"));
	
		/* Inserts Age Detail Credentials */
		if(hcCardHeaderInsertSuccess){
		if(hcAgeDetailList==null || hcAgeDetailList.size()==0){
			hcAgeDetailInsertSuccess=true;
		}else{		
			for(int i=0;i<hcAgeDetailList.size();i++){
				returnMessage=insertHealthCardDetail(con,inputParameters,hcAgeDetailList.get(i));
				hcAgeDetailInsertSuccess = Boolean.parseBoolean(returnMessage.get("status"));
				if(!hcAgeDetailInsertSuccess){
					break;
				}
			}
		}
		}
		
		/* Inserts Visit Detail Credentials */
		if(hcAgeDetailInsertSuccess){
		if(hcVisitDetailList==null || hcVisitDetailList.size()==0){
			hcVisitDetailSuccess=true;
		}else{		
			for(int i=0;i<hcVisitDetailList.size();i++){
				returnMessage=insertHealthCardVisitRule(con,inputParameters,hcVisitDetailList.get(i));
				hcVisitDetailSuccess = Boolean.parseBoolean(returnMessage.get("status"));
				if(!hcVisitDetailSuccess){
					break;
				}
			}
		}
		}
		
		/* Inserts Billing Group Details */
				
		if(hcVisitDetailSuccess){
		if(hcBlngGrpList==null || hcBlngGrpList.size()==0){
			hcBlngGrpSuccess=true;
		}else{		
			for(int i=0;i<hcBlngGrpList.size();i++){
				returnMessage=insertHealthCardCashBlngGroup(con,inputParameters,hcBlngGrpList.get(i));
				hcBlngGrpSuccess = Boolean.parseBoolean(returnMessage.get("status"));
				if(!hcBlngGrpSuccess){
					break;
				}
			}
		}
		}
	
		/* Commits only if all records are inserted Successfully*/
		boolean recordInserted = hcCardHeaderInsertSuccess && hcAgeDetailInsertSuccess && hcVisitDetailSuccess && hcBlngGrpSuccess;
		if(recordInserted) {
		con.commit();
		}else{
		con.rollback();
		}
		
		
		
		
	} catch (Exception e) {
		sysError.append("Error in EJB insertRecords():"+ e);
	} finally {
		if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					sysError.append("Error in EJB insertRecords()"+ e);
				}
		}
	}
	
		System.out.println(returnMessage);
		return returnMessage;
	}
	
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public java.util.HashMap updateRecords(java.util.Properties p,
			HashMap inputParameters,
			HashMap listParam ) {

	

		Connection con = ConnectionManager.getConnection(p);
		StringBuffer sysError = new StringBuffer();
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		ArrayList<blHcard.HealthCardAgeDetailBean> hcAgeUpdateDetailList = new ArrayList<HealthCardAgeDetailBean>();
		ArrayList<blHcard.HealthCardVisitRuleBean> hcVisitUpdateDetailList = new ArrayList<HealthCardVisitRuleBean>();
		ArrayList<blHcard.HealthCardCashBillingGroupBean> hcBlngUpdateGrpList = new ArrayList<HealthCardCashBillingGroupBean>();
		ArrayList<blHcard.HealthCardAgeDetailBean> hcAgeUpdateInsDetailList = new ArrayList<HealthCardAgeDetailBean>();
		ArrayList<blHcard.HealthCardVisitRuleBean> hcVisitUpdateInsDetailList = new ArrayList<HealthCardVisitRuleBean>();
		
		hcAgeUpdateDetailList = (ArrayList<blHcard.HealthCardAgeDetailBean>)listParam.get("ageUpdList");
		hcVisitUpdateDetailList = (ArrayList<blHcard.HealthCardVisitRuleBean>)listParam.get("visitUpdList");
		hcBlngUpdateGrpList = (ArrayList<blHcard.HealthCardCashBillingGroupBean>)listParam.get("bgUpdList");
		hcAgeUpdateInsDetailList = (ArrayList<blHcard.HealthCardAgeDetailBean>)listParam.get("ageUpdInsList");
		hcVisitUpdateInsDetailList = (ArrayList<blHcard.HealthCardVisitRuleBean>)listParam.get("visitUpdInsList");
		
	try{		
		boolean hcCardHeaderUpdateSuccess=false;
		boolean hcAgeDetailUpdateSuccess=false;
		boolean hcVisitDetailUpdateSuccess=false;
		boolean hcBlngGrpSuccess=false;
		boolean hcAgeDetailUpdInsertSuccess=false;
		boolean hcVisitDetailUpdInsertSuccess=false;
		
		/*This variable identifies whether header is modified or not.'Y' indicates header is modified*/
		boolean headerModified=inputParameters.get("headerModified").equals("Y");
		
		
		/*If no records are there to Update just Pop up on Screen*/
		if(!headerModified && hcAgeUpdateDetailList.size()==0 &&  hcVisitUpdateDetailList.size()==0 
				&& hcBlngUpdateGrpList.size()==0 &&hcAgeUpdateInsDetailList.size()==0 && hcVisitUpdateInsDetailList.size()==0
				){
			returnMessage.put("status", new Boolean(false).toString());
			returnMessage.put("error", null);
			returnMessage.put("sys_error", sysError.toString());
			returnMessage.put("message", "BL00101");
		}
		
		/* Updates Card Data Credentials */
		if(headerModified)
		{
		returnMessage=updateHealthCardHeader(con,inputParameters);
		hcCardHeaderUpdateSuccess = Boolean.parseBoolean(returnMessage.get("status"));
		}else{
		hcCardHeaderUpdateSuccess=true;
		}
	
		/* Updates Age Detail Credentials */
		if(hcCardHeaderUpdateSuccess){
		if(hcAgeUpdateDetailList==null || hcAgeUpdateDetailList.size()==0){
			hcAgeDetailUpdateSuccess=true;
		}else{		
			for(int i=0;i<hcAgeUpdateDetailList.size();i++){
				returnMessage=updateHealthCardDetail(con,inputParameters,hcAgeUpdateDetailList.get(i));
				hcAgeDetailUpdateSuccess = Boolean.parseBoolean(returnMessage.get("status"));
				if(!hcAgeDetailUpdateSuccess){
					break;
				}
			}
		}
		}
		
		
		/* Updates Visit Detail Credentials */
		if(hcAgeDetailUpdateSuccess){
			
		if(hcVisitUpdateDetailList==null || hcVisitUpdateDetailList.size()==0){
			hcVisitDetailUpdateSuccess=true;
		}else{		
			for(int i=0;i<hcVisitUpdateDetailList.size();i++){
					/*When delete option is set to 'Y' , the record is deleted else Updated*/
					if(hcVisitUpdateDetailList.get(i).getClinicSelected().equals("Y")){
					returnMessage=deleteHealthCardVisitRule(con,inputParameters,hcVisitUpdateDetailList.get(i));
					}
					else{
					returnMessage=updateHealthCardVisitRule(con,inputParameters,hcVisitUpdateDetailList.get(i));	
					}
					hcVisitDetailUpdateSuccess = Boolean.parseBoolean(returnMessage.get("status"));
					if(!hcVisitDetailUpdateSuccess){
					break;
					}
			}		
		}
		}
		
				
		/* Delete/Inserts Billing Group Details */
		
		if(hcVisitDetailUpdateSuccess){
		if(hcBlngUpdateGrpList==null || hcBlngUpdateGrpList.size()==0){
			hcBlngGrpSuccess=true;
		}else{		
			for(int i=0;i<hcBlngUpdateGrpList.size();i++){
				returnMessage=deleteHealthCardCashBlngGroup(con,inputParameters,hcBlngUpdateGrpList.get(i));
				hcBlngGrpSuccess = Boolean.parseBoolean(returnMessage.get("status"));
				if(!hcBlngGrpSuccess){
					break;
				}
				returnMessage=insertHealthCardCashBlngGroup(con,inputParameters,hcBlngUpdateGrpList.get(i));
				hcBlngGrpSuccess = Boolean.parseBoolean(returnMessage.get("status"));
				if(!hcBlngGrpSuccess){
					break;
				}
			}
		}
		}
		
		/* Inserts Age Detail Credentials */
		if(hcBlngGrpSuccess){
		if(hcAgeUpdateInsDetailList==null || hcAgeUpdateInsDetailList.size()==0){
			hcAgeDetailUpdInsertSuccess=true;
		}else{		
			for(int i=0;i<hcAgeUpdateInsDetailList.size();i++){
				returnMessage=insertHealthCardDetail(con,inputParameters,hcAgeUpdateInsDetailList.get(i));
				hcAgeDetailUpdInsertSuccess = Boolean.parseBoolean(returnMessage.get("status"));
				if(!hcAgeDetailUpdInsertSuccess){
					break;
				}
			}
		}
		}
		
		/* Inserts Visit Detail Credentials */
		if(hcAgeDetailUpdInsertSuccess){
		if(hcVisitUpdateInsDetailList==null || hcVisitUpdateInsDetailList.size()==0){
			hcVisitDetailUpdInsertSuccess=true;
		}else{		
			for(int i=0;i<hcVisitUpdateInsDetailList.size();i++){
				returnMessage=insertHealthCardVisitRule(con,inputParameters,hcVisitUpdateInsDetailList.get(i));
				hcVisitDetailUpdInsertSuccess = Boolean.parseBoolean(returnMessage.get("status"));
				if(!hcVisitDetailUpdInsertSuccess){
					break;
				}
			}
		}
		}

	
		/* Commits only if all records are Updated Successfully*/
		boolean recordUpdated = hcCardHeaderUpdateSuccess && hcAgeDetailUpdateSuccess && hcVisitDetailUpdateSuccess && hcBlngGrpSuccess &&hcAgeDetailUpdInsertSuccess && hcVisitDetailUpdInsertSuccess;
		
		
		if(recordUpdated) {
		con.commit();
		}else{
		con.rollback();
		}	


	} catch (Exception e) {
		sysError.append("Error in EJB updateRecords():"+ e);
	} 
	  
	finally {
		if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					sysError.append("Error in EJB updateRecords()"+ e);
				}
		}
	}
	
		System.out.println(returnMessage);
		return returnMessage;
	}
	
	
	/* Inserts Card Header Credentials */
	public HashMap<String, String> insertHealthCardHeader(Connection con,
			HashMap<String, String> inputParameters) {

		CallableStatement stmt=null;
		String procErrorCode = null;
		String procErrorText = null;
		String procErrorLevel = null;
		StringBuffer sysError = new StringBuffer();
		boolean insertable = false;
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		/*   PROCEDURE insert_hcard_hdr (
			      poperatingfacilityid   IN       VARCHAR2,
			      pcardtypecode          IN       VARCHAR2,
			      plongdesc              IN       VARCHAR2,
			      pshortdesc             IN       VARCHAR2,
			      pvaliddays             IN       NUMBER,
			      peffectivefrom         IN       DATE,
			      peffectiveto           IN       DATE,
			      pstatus                IN       VARCHAR2,
			      pnoofopvisits          IN       NUMBER,
			      paddedbyid             IN       VARCHAR2,
			      pmodifiedbyid          IN       VARCHAR2,
			      paddedfacilityid       IN       VARCHAR2,
			      pmodifiedfacilityid    IN       VARCHAR2,
			      paddedwsno             IN       VARCHAR2,
			      pmodifiedwsno          IN       VARCHAR2,
			      perrorlevel            OUT      VARCHAR2,
			      psysmessageid          OUT      VARCHAR2,
			      perrortext             OUT      VARCHAR2
		   )
		 */
		try {	      
			stmt = (CallableStatement) con.prepareCall("begin blhealthcard.insert_hcard_hdr(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
			stmt.setString(1,inputParameters.get("poperatingfacilityid"));
			stmt.setString(2,inputParameters.get("pcardtypecode"));
			stmt.setString(3,inputParameters.get("plongdesc"));
			stmt.setString(4, inputParameters.get("pshortdesc"));
			stmt.setInt(5, Integer.parseInt(inputParameters.get("pvaliddays")));
			stmt.setDate(6,(inputParameters.get("peffectivefrom").equals(""))?null:new Date(getDateInLong(inputParameters.get("peffectivefrom"))));
			stmt.setDate(7,(inputParameters.get("peffectiveto").equals(""))?null:new Date(getDateInLong(inputParameters.get("peffectiveto"))));
			stmt.setString(8,inputParameters.get("pstatus"));
			stmt.setInt(9, Integer.parseInt(inputParameters.get("pnoofopvisits")));
			stmt.setInt(10, Integer.parseInt(inputParameters.get("pnoOfPat")));
			stmt.setString(11, inputParameters.get("pAddedById"));
			stmt.setString(12, inputParameters.get("pModifiedById"));
			stmt.setString(13, inputParameters.get("pAddedFacilityId"));
			stmt.setString(14, inputParameters.get("pModifiedFacilityId"));
			stmt.setString(15, inputParameters.get("pAddedAtWsno"));
			stmt.setString(16, inputParameters.get("pModifiedAtWsno"));
			stmt.registerOutParameter(17, Types.VARCHAR);
			stmt.registerOutParameter(18, Types.VARCHAR);
			stmt.registerOutParameter(19, Types.VARCHAR);
			stmt.executeUpdate();

			procErrorLevel = stmt.getString(17);
			procErrorCode = stmt.getString(18);
			procErrorText = stmt.getString(19);
			
			if(procErrorLevel==null) procErrorLevel="";
			if(procErrorCode==null) procErrorCode="";
			if(procErrorText==null) procErrorText="";

			if (!procErrorCode.equals("") || !procErrorText.equals("")) {
				insertable = false;
			} else {
				insertable = true;
			}

		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			insertable = false;
			sysError.append("Exception while calling  blhealthcard.insert_hcard_hdr:" + e);
		}
		 catch (Exception e1) {
		sysError.append("Error in EJB updateRecords():"+ e1);
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sysError.append("Error while closing  IBAEHIS.blhealthcard.insert_hcard_hdr DB statement:"	+ e);
				}
			}
		}
		returnMessage.put("status", new Boolean(insertable).toString());
		returnMessage.put("error", procErrorText);
		returnMessage.put("sys_error", sysError.toString());
		returnMessage.put("message", procErrorCode);
		return returnMessage;
	}
		
	/* Inserts Age Detail Credentials */
	public HashMap<String, String> insertHealthCardDetail(Connection con,
			HashMap<String, String> inputParameters,
			blHcard.HealthCardAgeDetailBean hcAgeDetail) {

		CallableStatement stmt=null;
		String procErrorCode = null;
		String procErrorText = null;
		String procErrorLevel = null;
		StringBuffer sysError = new StringBuffer();
		boolean insertable = false;
		HashMap<String, String> returnMessage = new HashMap<String, String>();

		  /* PROCEDURE insert_hcard_dtl (
				      poperatingfacilityid   IN       VARCHAR2,
				      pcardtypecode          IN       VARCHAR2,
				      pfromagedays           IN       NUMBER,
				      pfromagemonth          IN       NUMBER,
				      pfromageyrs            IN       NUMBER,
				      ptoagedays             IN       NUMBER,
				      ptoagemonth            IN       NUMBER,
				      ptoageyrs              IN       NUMBER,
				      ppriceclasscode        IN       VARCHAR2,
				      ppackagecode           IN       VARCHAR2,
				      pblngservcode          IN       VARCHAR2,
				      paddedbyid             IN       VARCHAR2,
				      pmodifiedbyid          IN       VARCHAR2,
				      paddedfacilityid       IN       VARCHAR2,
				      pmodifiedfacilityid    IN       VARCHAR2,
				      paddedwsno             IN       VARCHAR2,
				      pmodifiedwsno          IN       VARCHAR2,
				      perrorlevel            OUT      VARCHAR2,
				      psysmessageid          OUT      VARCHAR2,
				      perrortext             OUT      VARCHAR2
				   )*/
		try {
			stmt = (CallableStatement) con.prepareCall("begin blhealthcard.insert_hcard_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
			stmt.setString(1,inputParameters.get("poperatingfacilityid"));
			stmt.setString(2,inputParameters.get("pcardtypecode"));
			stmt.setInt(3,hcAgeDetail.getMinAgeInDays());
			stmt.setInt(4,hcAgeDetail.getMinAgeInMths());
			stmt.setInt(5,hcAgeDetail.getMinAgeInYrs());
			stmt.setInt(6,hcAgeDetail.getMaxAgeInDays());
			stmt.setInt(7,hcAgeDetail.getMaxAgeInMths());
			stmt.setInt(8,hcAgeDetail.getMaxAgeInYrs() );
			stmt.setString(9, hcAgeDetail.getPriceClassCode());
			stmt.setString(10, "");
			stmt.setString(11, hcAgeDetail.getMembershipFeesCode());
			stmt.setString(12, inputParameters.get("pAddedById"));
			stmt.setString(13, inputParameters.get("pModifiedById"));
			stmt.setString(14, inputParameters.get("pAddedFacilityId"));
			stmt.setString(15, inputParameters.get("pModifiedFacilityId"));
			stmt.setString(16, inputParameters.get("pAddedAtWsno"));
			stmt.setString(17, inputParameters.get("pModifiedAtWsno"));
			stmt.registerOutParameter(18, Types.VARCHAR);
			stmt.registerOutParameter(19, Types.VARCHAR);
			stmt.registerOutParameter(20, Types.VARCHAR);
			stmt.executeUpdate();

			procErrorLevel = stmt.getString(18);
			procErrorCode = stmt.getString(19);
			procErrorText = stmt.getString(20);
			
			
			if(procErrorLevel==null) procErrorLevel="";
			if(procErrorCode==null) procErrorCode="";
			if(procErrorText==null) procErrorText="";

			if (!procErrorCode.equals("") || !procErrorText.equals("")) {
				insertable = false;
			} else {
				insertable = true;
			}

		}			 
		catch (SQLException e) {
			e.printStackTrace();
			insertable = false;
			sysError.append("Exception while calling  IBAEHIS.blhealthcard.insert_hcard_dtl:" + e);
		} 
				catch (Exception e1) {
		sysError.append("Error in EJB updateRecords():"+ e1);
			} 
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sysError.append("Error while closing  IBAEHIS.blhealthcard.insert_hcard_dtl DB statement:"	+ e);
				}
			}
		}
		returnMessage.put("status", new Boolean(insertable).toString());
		returnMessage.put("error", procErrorText);
		returnMessage.put("sys_error", sysError.toString());
		returnMessage.put("message", procErrorCode);
		return returnMessage;
	}
	
	/* Inserts Visit Detail Credentials */
	public HashMap<String, String> insertHealthCardVisitRule(Connection con,
			HashMap<String, String> inputParameters,
			blHcard.HealthCardVisitRuleBean hcVisitDetail) {

		CallableStatement stmt=null;
		String procErrorCode = null;
		String procErrorText = null;
		String procErrorLevel = null;
		StringBuffer sysError = new StringBuffer();
		boolean insertable = false;
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		/*   PROCEDURE insert_hcard_visit_rule (
			      poperatingfacilityid   IN       VARCHAR2,
			      pcardtypecode          IN       VARCHAR2,
			      pcliniccode            IN       VARCHAR2,
			      pvisittypecode         IN       VARCHAR2,
			      pnoofvisitsallowed     IN       NUMBER,
			      paddedbyid             IN       VARCHAR2,
			      pmodifiedbyid          IN       VARCHAR2,
			      paddedfacilityid       IN       VARCHAR2,
			      pmodifiedfacilityid    IN       VARCHAR2,
			      paddedwsno             IN       VARCHAR2,
			      pmodifiedwsno          IN       VARCHAR2,
			      perrorlevel            OUT      VARCHAR2,
			      psysmessageid          OUT      VARCHAR2,
			      perrortext             OUT      VARCHAR2
		   )*/
		try {
			stmt = (CallableStatement) con.prepareCall("begin IBAEHIS.blhealthcard.insert_hcard_visit_rule(?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
			stmt.setString(1,inputParameters.get("poperatingfacilityid"));
			stmt.setString(2,inputParameters.get("pcardtypecode"));
			stmt.setString(3,hcVisitDetail.getClinicCode());
			stmt.setString(4,hcVisitDetail.getVisitTypeCode());
			stmt.setInt(5,Integer.parseInt(hcVisitDetail.getNoOfVisitsAllowed()));
			stmt.setString(6, inputParameters.get("pAddedById"));
			stmt.setString(7, inputParameters.get("pModifiedById"));
			stmt.setString(8, inputParameters.get("pAddedFacilityId"));
			stmt.setString(9, inputParameters.get("pModifiedFacilityId"));
			stmt.setString(10, inputParameters.get("pAddedAtWsno"));
			stmt.setString(11, inputParameters.get("pModifiedAtWsno"));
			stmt.registerOutParameter(12, Types.VARCHAR);
			stmt.registerOutParameter(13, Types.VARCHAR);
			stmt.registerOutParameter(14, Types.VARCHAR);
			stmt.executeUpdate();

			procErrorLevel = stmt.getString(12);
			procErrorCode = stmt.getString(13);
			procErrorText = stmt.getString(14);		
			
			if(procErrorLevel==null) procErrorLevel="";
			if(procErrorCode==null) procErrorCode="";
			if(procErrorText==null) procErrorText="";

			if (!procErrorCode.equals("") || !procErrorText.equals("")) {
				insertable = false;
			} else {
				insertable = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			insertable = false;
			sysError.append("Exception while calling  IBAEHIS.blhealthcard.insert_hcard_visit_rule:" + e);
		} 
		 catch (Exception e1) {
		sysError.append("Error in EJB updateRecords():"+ e1);
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sysError.append("Error while closing  IBAEHIS.blhealthcard.insert_hcard_visit_rule DB statement:"	+ e);
				}
			}
		}
		returnMessage.put("status", new Boolean(insertable).toString());
		returnMessage.put("error", procErrorText);
		returnMessage.put("sys_error", sysError.toString());
		returnMessage.put("message", procErrorCode);
		return returnMessage;
	}
	
	
	/* Updates Card Header Credentials */
	public HashMap<String, String> updateHealthCardHeader(Connection con,
			HashMap<String, String> inputParameters) {

		CallableStatement stmt=null;
		String procErrorCode = null;
		String procErrorText = null;
		String procErrorLevel = null;
		StringBuffer sysError = new StringBuffer();
		boolean insertable = false;
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		/*   PROCEDURE update_hcard_hdr (
			      poperatingfacilityid   IN       VARCHAR2,
			      pcardtypecode          IN       VARCHAR2,
			      plongdesc              IN       VARCHAR2,
			      pshortdesc             IN       VARCHAR2,
			      pvaliddays             IN       NUMBER,
			      peffectivefrom         IN       DATE,
			      peffectiveto           IN       DATE,
			      pstatus                IN       VARCHAR2,
			      pnoofopvisits          IN       NUMBER,
			      pmodifiedbyid          IN       VARCHAR2,
			      pmodifiedfacilityid    IN       VARCHAR2,
			      pmodifiedwsno          IN       VARCHAR2,
			      perrorlevel            OUT      VARCHAR2,
			      psysmessageid          OUT      VARCHAR2,
			      perrortext             OUT      VARCHAR2
			      
		   )
		 */
		try {	      
			stmt = (CallableStatement) con.prepareCall("begin IBAEHIS.blhealthcard.update_hcard_hdr(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
			stmt.setString(1,inputParameters.get("poperatingfacilityid"));
			stmt.setString(2,inputParameters.get("pcardtypecode"));
			stmt.setString(3,inputParameters.get("plongdesc"));
			stmt.setString(4, inputParameters.get("pshortdesc"));
			stmt.setInt(5, Integer.parseInt(inputParameters.get("pvaliddays")));
			stmt.setDate(6,(inputParameters.get("peffectivefrom").equals(""))?null:new Date(getDateInLong(inputParameters.get("peffectivefrom"))));
			stmt.setDate(7,(inputParameters.get("peffectiveto").equals(""))?null:new Date(getDateInLong(inputParameters.get("peffectiveto"))));
			stmt.setInt(8, Integer.parseInt(inputParameters.get("pnoOfPat")));
			stmt.setString(9,inputParameters.get("pstatus"));
			stmt.setInt(10, Integer.parseInt(inputParameters.get("pnoofopvisits")));
			stmt.setString(11, inputParameters.get("pModifiedById"));
			stmt.setString(12, inputParameters.get("pModifiedFacilityId"));
			stmt.setString(13, inputParameters.get("pModifiedAtWsno"));
			stmt.registerOutParameter(14, Types.VARCHAR);
			stmt.registerOutParameter(15, Types.VARCHAR);
			stmt.registerOutParameter(16, Types.VARCHAR);
			stmt.executeUpdate();

			procErrorLevel = stmt.getString(14);
			procErrorCode = stmt.getString(15);
			procErrorText = stmt.getString(16);
			
			if(procErrorLevel==null) procErrorLevel="";
			if(procErrorCode==null) procErrorCode="";
			if(procErrorText==null) procErrorText="";

			if (!procErrorCode.equals("") || !procErrorText.equals("")) {
				insertable = false;
			} else {
				insertable = true;
			}

		} 
		 	
		catch (SQLException e) {
			e.printStackTrace();
			insertable = false;
			sysError.append("Exception while calling  IBAEHIS.blhealthcard.update_hcard_hdr:" + e);
		} 
		 catch (Exception e1) {
		sysError.append("Error in EJB updateRecords():"+ e1);
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sysError.append("Error while closing  IBAEHIS.blhealthcard.update_hcard_hdr DB statement:"	+ e);
				}
			}
		}
		returnMessage.put("status", new Boolean(insertable).toString());
		returnMessage.put("error", procErrorText);
		returnMessage.put("sys_error", sysError.toString());
		returnMessage.put("message", procErrorCode);
		return returnMessage;
	}
		
	/* Updates Age Detail Credentials */
	public HashMap<String, String> updateHealthCardDetail(Connection con,
			HashMap<String, String> inputParameters,
			blHcard.HealthCardAgeDetailBean hcAgeDetail) {

		CallableStatement stmt=null;
		String procErrorCode = null;
		String procErrorText = null;
		String procErrorLevel = null;
		StringBuffer sysError = new StringBuffer();
		boolean insertable = false;
		HashMap<String, String> returnMessage = new HashMap<String, String>();

		  /* PROCEDURE update_hcard_dtl (
				      poperatingfacilityid   IN       VARCHAR2,
				      pcardtypecode          IN       VARCHAR2,
				      pfromagedays           IN       NUMBER,
				      pfromagemonth          IN       NUMBER,
				      pfromageyrs            IN       NUMBER,
				      ptoagedays             IN       NUMBER,
				      ptoagemonth            IN       NUMBER,
				      ptoageyrs              IN       NUMBER,
				      ppriceclasscode        IN       VARCHAR2,
				      ppackagecode           IN       VARCHAR2,
				      pblngservcode          IN       VARCHAR2,
				      pmodifiedbyid          IN       VARCHAR2,
				      pmodifiedfacilityid    IN       VARCHAR2,
				      pmodifiedwsno          IN       VARCHAR2,
				      perrorlevel            OUT      VARCHAR2,
				      psysmessageid          OUT      VARCHAR2,
				      perrortext             OUT      VARCHAR2
				   )*/
		try {
			stmt = (CallableStatement) con.prepareCall("begin IBAEHIS.blhealthcard.update_hcard_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
			stmt.setString(1,inputParameters.get("poperatingfacilityid"));
			stmt.setString(2,inputParameters.get("pcardtypecode"));
			stmt.setInt(3,hcAgeDetail.getMinAgeInDays());
			stmt.setInt(4,hcAgeDetail.getMinAgeInMths());
			stmt.setInt(5,hcAgeDetail.getMinAgeInYrs());
			stmt.setInt(6,hcAgeDetail.getMaxAgeInDays());
			stmt.setInt(7,hcAgeDetail.getMaxAgeInMths());
			stmt.setInt(8,hcAgeDetail.getMaxAgeInYrs() );
			stmt.setString(9, hcAgeDetail.getPriceClassCode());
			stmt.setString(10, "");
			stmt.setString(11, hcAgeDetail.getMembershipFeesCode());
			stmt.setString(12, inputParameters.get("pModifiedById"));
			stmt.setString(13, inputParameters.get("pModifiedFacilityId"));
			stmt.setString(14, inputParameters.get("pModifiedAtWsno"));
			stmt.registerOutParameter(15, Types.VARCHAR);
			stmt.registerOutParameter(16, Types.VARCHAR);
			stmt.registerOutParameter(17, Types.VARCHAR);
			stmt.executeUpdate();

			procErrorLevel = stmt.getString(15);
			procErrorCode = stmt.getString(16);
			procErrorText = stmt.getString(17);
			
			
			if(procErrorLevel==null) procErrorLevel="";
			if(procErrorCode==null) procErrorCode="";
			if(procErrorText==null) procErrorText="";

			if (!procErrorCode.equals("") || !procErrorText.equals("")) {
				insertable = false;
			} else {
				insertable = true;
			}
			
			System.out.println("EJB::BEAN _ UPDATED"+hcAgeDetail);
			System.out.println(insertable);

		} 
	 
		catch (SQLException e) {
			e.printStackTrace();
			insertable = false;
			sysError.append("Exception while calling  IBAEHIS.blhealthcard.update_hcard_dtl:" + e);
		}
		 catch (Exception e1) {
		sysError.append("Error in EJB updateRecords():"+ e1);
		} 
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sysError.append("Error while closing  IBAEHIS.blhealthcard.update_hcard_dtl DB statement:"	+ e);
				}
			}
		}
		returnMessage.put("status", new Boolean(insertable).toString());
		returnMessage.put("error", procErrorText);
		returnMessage.put("sys_error", sysError.toString());
		returnMessage.put("message", procErrorCode);
		return returnMessage;
	}
	
	/* Updates Visit Detail Credentials */
	public HashMap<String, String> updateHealthCardVisitRule(Connection con,
			HashMap<String, String> inputParameters,
			blHcard.HealthCardVisitRuleBean hcVisitDetail) {

		CallableStatement stmt=null;
		String procErrorCode = null;
		String procErrorText = null;
		String procErrorLevel = null;
		StringBuffer sysError = new StringBuffer();
		boolean insertable = false;
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		/*   PROCEDURE update_hcard_visit_rule (
			      poperatingfacilityid   IN       VARCHAR2,
			      pcardtypecode          IN       VARCHAR2,
			      pcliniccode            IN       VARCHAR2,
			      pvisittypecode         IN       VARCHAR2,
			      pnoofvisitsallowed     IN       NUMBER,
			      pmodifiedbyid          IN       VARCHAR2,
			      pmodifiedfacilityid    IN       VARCHAR2,
			      pmodifiedwsno          IN       VARCHAR2,
			      perrorlevel            OUT      VARCHAR2,
			      psysmessageid          OUT      VARCHAR2,
			      perrortext             OUT      VARCHAR2
		   )*/
		try {
			stmt = (CallableStatement) con.prepareCall("begin IBAEHIS.blhealthcard.update_hcard_visit_rule(?,?,?,?,?,?,?,?,?,?,?); end;");
			stmt.setString(1,inputParameters.get("poperatingfacilityid"));
			stmt.setString(2,inputParameters.get("pcardtypecode"));
			stmt.setString(3,hcVisitDetail.getClinicCode());
			stmt.setString(4,hcVisitDetail.getVisitTypeCode());
			stmt.setInt(5,Integer.parseInt(hcVisitDetail.getNoOfVisitsAllowed()));
			stmt.setString(6, inputParameters.get("pModifiedById"));
			stmt.setString(7, inputParameters.get("pModifiedFacilityId"));
			stmt.setString(8, inputParameters.get("pModifiedAtWsno"));
			stmt.registerOutParameter(9, Types.VARCHAR);
			stmt.registerOutParameter(10, Types.VARCHAR);
			stmt.registerOutParameter(11, Types.VARCHAR);
			stmt.executeUpdate();

			procErrorLevel = stmt.getString(9);
			procErrorCode = stmt.getString(10);
			procErrorText = stmt.getString(11);		
			
			if(procErrorLevel==null) procErrorLevel="";
			if(procErrorCode==null) procErrorCode="";
			if(procErrorText==null) procErrorText="";

			if (!procErrorCode.equals("") || !procErrorText.equals("")) {
				insertable = false;
			} else {
				insertable = true;
			}

			System.out.println("EJB::BEAN _ UPDATED"+hcVisitDetail);
			System.out.println(insertable);
			
		}
		  
		catch (SQLException e) {
			e.printStackTrace();
			insertable = false;
			sysError.append("Exception while calling  IBAEHIS.blhealthcard.update_hcard_visit_rule:" + e);
		} 
		catch (Exception e1) {
		sysError.append("Error in EJB updateRecords():"+ e1);
			} 
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sysError.append("Error while closing  IBAEHIS.blhealthcard.update_hcard_visit_rule DB statement:"	+ e);
				}
			}
		}
		returnMessage.put("status", new Boolean(insertable).toString());
		returnMessage.put("error", procErrorText);
		returnMessage.put("sys_error", sysError.toString());
		returnMessage.put("message", procErrorCode);
		return returnMessage;
	}

	/* Deletes Visit Detail Credentials */
	public HashMap<String, String> deleteHealthCardVisitRule(Connection con,
			HashMap<String, String> inputParameters,
			blHcard.HealthCardVisitRuleBean hcDelVisitDetail) {

		CallableStatement stmt=null;
		String procErrorCode = null;
		String procErrorText = null;
		String procErrorLevel = null;
		StringBuffer sysError = new StringBuffer();
		boolean insertable = false;
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		/*        PROCEDURE delete_hcard_visit_rule (
			      poperatingfacilityid   IN       VARCHAR2,
			      pcardtypecode          IN       VARCHAR2,
			      pcliniccode            IN       VARCHAR2,
			      pvisittypecode         IN       VARCHAR2,
			      perrorlevel            OUT      VARCHAR2,
			      psysmessageid          OUT      VARCHAR2,
			      perrortext             OUT      VARCHAR2
   		)*/
		try {
			stmt = (CallableStatement) con.prepareCall("begin IBAEHIS.blhealthcard.delete_hcard_visit_rule(?,?,?,?,?,?,?); end;");
			stmt.setString(1,inputParameters.get("poperatingfacilityid"));
			stmt.setString(2,inputParameters.get("pcardtypecode"));
			stmt.setString(3,hcDelVisitDetail.getClinicCode());
			stmt.setString(4,hcDelVisitDetail.getVisitTypeCode());
			stmt.registerOutParameter(5, Types.VARCHAR);
			stmt.registerOutParameter(6, Types.VARCHAR);
			stmt.registerOutParameter(7, Types.VARCHAR);
			stmt.executeUpdate();

			procErrorLevel = stmt.getString(5);
			procErrorCode = stmt.getString(6);
			procErrorText = stmt.getString(7);		
			
			if(procErrorLevel==null) procErrorLevel="";
			if(procErrorCode==null) procErrorCode="";
			if(procErrorText==null) procErrorText="";

			if (!procErrorCode.equals("") || !procErrorText.equals("")) {
				insertable = false;
			} else {
				insertable = true;
			}

			System.out.println("EJB::BEAN _ DELETED"+hcDelVisitDetail);
			System.out.println(insertable);
			
		}
			  
		catch (SQLException e) {
			e.printStackTrace();
			insertable = false;
			sysError.append("Exception while calling  IBAEHIS.blhealthcard.delete_hcard_visit_rule:" + e);
		} 
		catch (Exception e1) {
				sysError.append("Error in EJB updateRecords():"+ e1);
			  }	
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sysError.append("Error while closing  IBAEHIS.blhealthcard.delete_hcard_visit_rule DB statement:"	+ e);
				}
			}
		}
		returnMessage.put("status", new Boolean(insertable).toString());
		returnMessage.put("error", procErrorText);
		returnMessage.put("sys_error", sysError.toString());
		returnMessage.put("message", procErrorCode);
		return returnMessage;
	}
	
	/* Inserts Billing Group Details */
	public HashMap<String, String> insertHealthCardCashBlngGroup(
			Connection con, HashMap<String, String> inputParameters,
			blHcard.HealthCardCashBillingGroupBean hcBlngGrpList) {

		CallableStatement stmt=null;
		String procErrorCode = null;
		String procErrorText = null;
		String procErrorLevel = null;
		StringBuffer sysError = new StringBuffer();
		boolean insertable = false;
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		/*   PROCEDURE insert_hcard_cash_blnggrp (
			      poperatingfacilityid   IN       VARCHAR2,
			      pcardtypecode          IN       VARCHAR2,
			      pblnggrpid             IN       VARCHAR2,
			      paddedbyid             IN       VARCHAR2,
			      pmodifiedbyid          IN       VARCHAR2,
			      paddedfacilityid       IN       VARCHAR2,
			      pmodifiedfacilityid    IN       VARCHAR2,
			      paddedwsno             IN       VARCHAR2,
			      pmodifiedwsno          IN       VARCHAR2,
			      perrorlevel            OUT      VARCHAR2,
			      psysmessageid          OUT      VARCHAR2,
			      perrortext             OUT      VARCHAR2
		   )*/
		try {
			stmt = (CallableStatement) con.prepareCall("begin blhealthcard.insert_hcard_cash_blnggrp(?,?,?,?,?,?,?,?,?,?,?,?); end;");
			stmt.setString(1,inputParameters.get("poperatingfacilityid"));
			stmt.setString(2,inputParameters.get("pcardtypecode"));
			stmt.setString(3,hcBlngGrpList.getBlngGrpId());
			stmt.setString(4, inputParameters.get("pAddedById"));
			stmt.setString(5, inputParameters.get("pModifiedById"));
			stmt.setString(6, inputParameters.get("pAddedFacilityId"));
			stmt.setString(7, inputParameters.get("pModifiedFacilityId"));
			stmt.setString(8, inputParameters.get("pAddedAtWsno"));
			stmt.setString(9, inputParameters.get("pModifiedAtWsno"));
			stmt.registerOutParameter(10, Types.VARCHAR);
			stmt.registerOutParameter(11, Types.VARCHAR);
			stmt.registerOutParameter(12, Types.VARCHAR);
			stmt.executeUpdate();

			procErrorLevel = stmt.getString(10);
			procErrorCode = stmt.getString(11);
			procErrorText = stmt.getString(12);
						
			if(procErrorLevel==null) procErrorLevel="";
			if(procErrorCode==null) procErrorCode="";
			if(procErrorText==null) procErrorText="";

			if (!procErrorCode.equals("") || !procErrorText.equals("")) {
				insertable = false;
			} else {
				insertable = true;
			}

		}
			  
		catch (SQLException e) {
			e.printStackTrace();
			insertable = false;
			sysError.append("Exception while calling  IBAEHIS.blhealthcard.insert_hcard_cash_blnggrp:" + e);
		} 
		 catch (Exception e1) {
		sysError.append("Error in EJB updateRecords():"+ e1);
			}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sysError.append("Error while closing  IBAEHIS.blhealthcard.insert_hcard_cash_blnggrp DB statement:"	+ e);
				}
			}
		}
		returnMessage.put("status", new Boolean(insertable).toString());
		returnMessage.put("error", procErrorText);
		returnMessage.put("sys_error", sysError.toString());
		returnMessage.put("message", procErrorCode);
		return returnMessage;
	}
	
	/* Deletes Billing Group Details */
	public HashMap<String, String> deleteHealthCardCashBlngGroup(
			Connection con, HashMap<String, String> inputParameters,
			blHcard.HealthCardCashBillingGroupBean hcBlngGrpList) {

		CallableStatement stmt=null;
		String procErrorCode = null;
		String procErrorText = null;
		String procErrorLevel = null;
		StringBuffer sysError = new StringBuffer();
		boolean insertable = false;
		HashMap<String, String> returnMessage = new HashMap<String, String>();
		/*    
		  PROCEDURE delete_hcard_cash_blnggrp (
	      poperatingfacilityid   IN       VARCHAR2,
	      pcardtypecode          IN       VARCHAR2,
	      pblnggrpid             IN       VARCHAR2,
	      perrorlevel            OUT      VARCHAR2,
	      psysmessageid          OUT      VARCHAR2,
	      perrortext             OUT      VARCHAR2
   		)*/
		try {
			stmt = (CallableStatement) con.prepareCall("begin IBAEHIS.blhealthcard.delete_hcard_cash_blnggrp(?,?,?,?,?,?); end;");
			stmt.setString(1,inputParameters.get("poperatingfacilityid"));
			stmt.setString(2,inputParameters.get("pcardtypecode"));
			stmt.setString(3,hcBlngGrpList.getBlngGrpId());
			stmt.registerOutParameter(4, Types.VARCHAR);
			stmt.registerOutParameter(5, Types.VARCHAR);
			stmt.registerOutParameter(6, Types.VARCHAR);
			stmt.executeUpdate();

			procErrorLevel = stmt.getString(4);
			procErrorCode = stmt.getString(5);
			procErrorText = stmt.getString(6);
						
			if(procErrorLevel==null) procErrorLevel="";
			if(procErrorCode==null) procErrorCode="";
			if(procErrorText==null) procErrorText="";

			if (!procErrorCode.equals("") || !procErrorText.equals("")) {
				insertable = false;
			} else {
				insertable = true;
			}

		} 
			
		catch (SQLException e) {
			e.printStackTrace();
			insertable = false;
			sysError.append("Exception while calling  IBAEHIS.blhealthcard.delete_hcard_cash_blnggrp:" + e);
		}
		  catch (Exception e1) {
			sysError.append("Error in EJB updateRecords():"+ e1);
			} 
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sysError.append("Error while closing  IBAEHIS.blhealthcard.delete_hcard_cash_blnggrp DB statement:"	+ e);
				}
			}
		}
		returnMessage.put("status", new Boolean(insertable).toString());
		returnMessage.put("error", procErrorText);
		returnMessage.put("sys_error", sysError.toString());
		returnMessage.put("message", procErrorCode);
		return returnMessage;
	}

	
	/*
	 * This method takes input in DD/MM/YYYY format and provides appropriate 
	 * long value
	 */
	private long getDateInLong(String dateString){
		if(dateString==null || dateString.equals("")){
		return 0;		
		}
		else{
			 try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Timestamp inputTimestamp = new Timestamp(sdf.parse(dateString).getTime());
				return inputTimestamp.getTime();
			} catch (ParseException e) {
				System.out.println("Error in Input Date Format");
				e.printStackTrace();
			}
		}
		return 0;
	}
	
}
