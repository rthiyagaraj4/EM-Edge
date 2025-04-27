/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/

/*
Sr No        Version           Incident			SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V210413			17021        Common-ICN-0009-TF         MuthukumarN
-----------------------------------------------------------------------------------
*/

package eBL.PkgCardSubscription;

//Rajesh V
import java.sql.*;
import java.sql.Date;

import javax.naming.*;
import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import java.io.* ;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import webbeans.eCommon.*;
import  blHcard.BillingPrevilageCardMemberLocalBean;
import  blHcard.BillingPrevilageCardPatientLocalBean;

//Rajesh V
//Boopathy
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import webbeans.eCommon.ConnectionManager;
/*import blHcard.BillingPrevilageCardMemberBean;
import blHcard.BillingPrevilageCardPatientBean;
*/
//Boopathy
//Karthik
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
//Karthik


/**
*
* @ejb.bean
*	name="PkgCardSubscription"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PkgCardSubscription"
*	local-jndi-name="PkgCardSubscription"
*	impl-class-name="eBL.PkgCardSubscription.PkgCardSubscriptionManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eBL.PkgCardSubscription.PkgCardSubscriptionLocal"
*	remote-class="eBL.PkgCardSubscription.PkgCardSubscriptionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.PkgCardSubscription.PkgCardSubscriptionLocalHome"
*	remote-class="eBL.PkgCardSubscription.PkgCardSubscriptionHome"
*	generate= "local,remote"
*
*
*/


public class PkgCardSubscriptionManager implements SessionBean
{
	//Rajesh V
	Connection con = null;//V210413

	CallableStatement cstmt = null;

	SessionContext ctx;

	boolean insertable = false;

	String locale = "";

	//String encounterid = "";


	String errCode = "", sysMessgaeId="", errText="", gen_doc_type="",gen_doc_num="";
	StringBuffer sys_err = new StringBuffer("") ;
	//Rajesh V
	//Boopathy
	Connection connection;

	String encounterid = "";

	BillingPrevilageCardMemberLocalBean billingPrevilageCardMemberBean		= 	null;
	BillingPrevilageCardPatientLocalBean billingPrevilageCardPatientBean		=	null;
	ArrayList	previlageCardHeaderPatientList							=	null;
	ArrayList 	previlageCardAdditionalPatientList						=	null;
	ArrayList 	previlageCardDeletePatientList							=	null;
	ArrayList 	previlageCardModifyPatientList							=	null;

	String			tab													=	null; 
	HashMap return_mess 												= 	new HashMap();		
	boolean modifyInsertable 											= 	false;
	boolean isDeleted													=	false;
	
	String currdate="",client_ip_address="",user_id="";
	//Boopathy
	
	//karthik
	
	//karthik


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

	
	
	
	public java.util.HashMap insertCardSubscription(java.util.HashMap tabdata,java.util.Properties p) 
	{		
		//HashMap return_mess = new HashMap();	//V210413

		CallableStatement call = null;
		//Connection con = null; //V210413
		boolean errOccurred = false;
		try{
		con = ConnectionManager.getConnection(p);
		con.setAutoCommit(false);
		String patientId = (String) tabdata.get("patient_id");
		String cardType = (String) tabdata.get("card_type");
		String effFrom = (String) tabdata.get("effFrom");
		String  addPatId = (String) tabdata.get("addPatId");
		String facilityId = (String) tabdata.get("facility_id");
		String loginUser = (String) tabdata.get("login_user");
		String clientIp = (String) tabdata.get("client_ip_address");
		addPatId = addPatId.substring(0, addPatId.length()-3);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date fromDt = new Date(sdf.parse(effFrom).getTime());
		locale = p.getProperty("LOCALE") ;
		Locale loc = new Locale(locale);
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		//System.err.println("Crossed This"+addPatId);
		call = con.prepareCall("{call  IBAEHIS.blhealthcard.insert_hcard_subhdr(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		call.setString(1,facilityId);
		call.setString(2,patientId);
		call.setString(3,cardType);
		call.setDate(4,fromDt);	
		call.setString(5, loginUser);
		call.setString(6, loginUser);
		call.setString(7,facilityId);
		call.setString(8,facilityId);
		call.setString(9,clientIp);
		call.setString(10,clientIp);
		call.registerOutParameter(11,java.sql.Types.NUMERIC);
		call.registerOutParameter(12,java.sql.Types.VARCHAR);
		call.registerOutParameter(13,java.sql.Types.VARCHAR);
		call.registerOutParameter(14,java.sql.Types.VARCHAR);
		call.execute();
		int seqNo = call.getInt(11);
		String err = call.getString(12);
		String msg = call.getString(13);
		errText = call.getString(14); // DUPLICATE OBJECT CREATED removed String V210413
		//System.err.println("Primary - >"+err+"-"+msg+"-"+errText);
		if(err!=null || errText!=null){
			return_mess.put("errMain", err+"-"+errText);
		}
		if(msg!=null){
			if(msg.contains("|")){
				String msgArr[] = msg.split("\\|");
				//System.err.println("msgArr->"+msgArr);
				for(int k=0;k<msgArr.length;k++){
					String msgMain = "msgMain"+k;
					//System.err.println("msgArr[k]->"+msgArr[k]);
					msgArr[k] = rb.getString(msgArr[k]);
					return_mess.put(msgMain, msgArr[k]);
				}
			}else{
				msg = rb.getString(msg);
				return_mess.put("msgMain", msg);
			}
		}
		//return_mess.put("errTextMain", errText);
		//System.err.println(err+"-"+msg+"-"+errText);
		
		if(!(err!=null || msg!=null || errText!=null)){
			String addPatIdArr[] = addPatId.split(":::");
			String errAdd="";
			String msgAdd="";
			String errTextAdd="";
			for(int i=0;i<addPatIdArr.length;i++){
				if(addPatIdArr[i] != null && addPatIdArr[i] != "" && addPatIdArr[i].length()>0){
					//System.err.println("AddPatArr->"+addPatIdArr[i]);
					call.close();
					call = con.prepareCall("{call  IBAEHIS.blhealthcard.insert_hcard_subdtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					call.setString(1,facilityId);
					call.setInt(2, seqNo);
					call.setString(3,cardType);
					call.setString(4,patientId);
					call.setString(5,addPatIdArr[i]);
					call.setDate(6,fromDt);	
					call.setString(7, loginUser);
					call.setString(8, loginUser);
					call.setString(9,facilityId);
					call.setString(10,facilityId);
					call.setString(11,clientIp);
					call.setString(12,clientIp);
					call.registerOutParameter(13,java.sql.Types.VARCHAR);
					call.registerOutParameter(14,java.sql.Types.VARCHAR);
					call.registerOutParameter(15,java.sql.Types.VARCHAR);
					call.execute();
					err = call.getString(13);
					msg = call.getString(14);
					errText = call.getString(15);
					//System.err.println("Add - >"+err+"-"+msg+"-"+errText);
					if(err!=null || msg!=null || errText!=null){
						errOccurred = true;
					}
					errAdd = "errAdd"+i;
					
					errTextAdd = "errTextAdd"+i;
					if(err!=null || errText!=null){
						return_mess.put(errAdd, err+"-"+errText);
					}
					
					if(msg!=null){
						if(msg.contains("|")){
							String msgArr[] = msg.split("\\|");
							for(int l=0;l<msgArr.length;l++){
								msgAdd = "msgAdd"+i+"-"+l;
								msgArr[l] = rb.getString(msgArr[l]);
								return_mess.put(msgAdd, msgArr[l]);
							}
						}else{
							msgAdd = "msgAdd"+i;
							msg = rb.getString(msg);
							return_mess.put(msgAdd, msg);
						}
					}
					
					//return_mess.put(errTextAdd, errText);
					//System.err.println(err+"-"+msg+"-"+errText);
				}
			}
			if(errOccurred){
				call.close();
				con.rollback();
			}
			else{
				call.close();
				con.commit();
			}

		}
		else{
			call.close();
			con.rollback();
		}
		
		}
		catch(Exception e){
			System.err.println("Exception is insertCardSubscription->"+e);
			return_mess.put("excep", "Error "+e);
			e.printStackTrace();
		}
		finally{
			ConnectionManager.returnConnection(con, p);
		}
		return return_mess;	
		
	}
	
	//Boopathy
	/**
	 *@ejb.interface-method
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	public java.util.HashMap insert(java.util.Properties properties,java.util.HashMap tabdata) //throws Exception 
	{		
		System.out.println("IN MaintainPrevilageCardManager INSERT----");
			previlageCardAdditionalPatientList			=	new ArrayList();
			connection 									= 	ConnectionManager.getConnection(properties);
			return_mess 								= 	new HashMap();		
			//boolean insertable = 	false;  //duplicate object already declared in line 110 V210413
			boolean insertableHeader					= 	false;
			String strInsertable	 					= 	"";
			String str_error_level						=	"";
			String str_error_text						=	"";
			String str_sysmesage_id						=	"";
			String locale 								= 	"";
			String errAdd								=	"";
			String msgAdd								=	"";
			String errTextAdd							=	"";
			//UnUsed Variable V210413
			//SimpleDateFormat dateFormat 				=	new SimpleDateFormat("yyyy/mm/dd"); 
			//java.sql.Date date 							= null;
			//UnUsed Variable V210413


			if(locale==null) 
				locale="en";
			String facility_id 							= 	(String) tabdata.get("FACILITY_ID");
			if(facility_id==null) 
				facility_id=""; 
			client_ip_address							=	(String)tabdata.get("client_ip_address");
			if(client_ip_address==null)
				client_ip_address="";
			user_id										=	(String)tabdata.get("login_user");
			if(user_id==null) 
				user_id="";
	
			locale										=	(String)tabdata.get("locale");
			if(locale==null) 
				locale="en";
			Locale loc = new Locale(locale);
			ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			//mode
			tab											=	(String)tabdata.get("tab"); 
			
			previlageCardHeaderPatientList				=	(ArrayList)tabdata.get("previlageCardHeaderPatientList"); 
			for(int i=0;i<previlageCardHeaderPatientList.size();i++) 
			 {
				billingPrevilageCardPatientBean = (BillingPrevilageCardPatientLocalBean)previlageCardHeaderPatientList.get(i);
				System.out.println("hCardSeqNo						Header 	:: "+billingPrevilageCardPatientBean.getHcardSeqNo());
				 //System.out.println("primaryPatientId 				Header	:: "+billingPrevilageCardPatientBean.getPatientId());
				 System.out.println("primaryPatientId 				Header	:: "+billingPrevilageCardPatientBean.getPrimaryPatientId());
				 System.out.println("cardTypeCode					Header	:: "+billingPrevilageCardPatientBean.getPrevilageCardTypeCode());
				 System.out.println("effectiveFrom 					Header	:: "+billingPrevilageCardPatientBean.getPrevilageCardFromDate()); 
				 System.out.println("primaryPatientToDate			Header 	:: "+billingPrevilageCardPatientBean.getPrevilageCardToDate());
				 System.out.println("primaryPatientPriceClassCode 	Header	:: "+billingPrevilageCardPatientBean.getPrevilageCardPriceClassCode());
				 System.out.println("packageCode					Header	:: "+billingPrevilageCardPatientBean.getPackageCode());
				 System.out.println("primaryPatientMemberFess 		Header	:: "+billingPrevilageCardPatientBean.getPrevilageCardMemberFees());
				 System.out.println("oPVisitsAllowed 				Header	:: "+billingPrevilageCardPatientBean.getOpVistsAllowed());
				 System.out.println("oPVisitsUtilized 				Header	:: "+billingPrevilageCardPatientBean.getOpVistsAvailed());
				 System.out.println("billingServiceCode 			Header	:: "+billingPrevilageCardPatientBean.getBillingServiceCode());
			 }
							
			CallableStatement callableStatementHeader=null;
			try 
			{
				connection.setAutoCommit( false ) ;	
				insertableHeader = true;
				String sqlmaintainPrevilageCardHeaderInsert="{ call   IBAEHIS.blhealthcard.update_hcard_subhdr(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; 
				for(int i=0;i<previlageCardHeaderPatientList.size();i++) 
				 {
					callableStatementHeader = connection.prepareCall(sqlmaintainPrevilageCardHeaderInsert);	 
					billingPrevilageCardPatientBean = (BillingPrevilageCardPatientLocalBean)previlageCardHeaderPatientList.get(i);
					callableStatementHeader.setString(1,facility_id);
					callableStatementHeader.setString(2,billingPrevilageCardPatientBean.getHcardSeqNo());
					//callableStatementHeader.setString(3,billingPrevilageCardPatientBean.getPatientId());
					callableStatementHeader.setString(3,billingPrevilageCardPatientBean.getPrimaryPatientId());
					callableStatementHeader.setString(4,billingPrevilageCardPatientBean.getPrevilageCardTypeCode());       
					callableStatementHeader.setDate(5,new Date(getDateInLong(billingPrevilageCardPatientBean.getPrevilageCardFromDate()))); 
					callableStatementHeader.setDate(6,new Date(getDateInLong(billingPrevilageCardPatientBean.getPrevilageCardToDate())));   
					callableStatementHeader.setString(7,billingPrevilageCardPatientBean.getPrevilageCardPriceClassCode());
					callableStatementHeader.setString(8,billingPrevilageCardPatientBean.getPackageCode());
					callableStatementHeader.setString(9,billingPrevilageCardPatientBean.getBillingServiceCode());	  
					callableStatementHeader.setString(10,billingPrevilageCardPatientBean.getPrevilageCardMemberFees());	       
					callableStatementHeader.setString(11,billingPrevilageCardPatientBean.getOpVistsAllowed());	        
					callableStatementHeader.setString(12,billingPrevilageCardPatientBean.getOpVistsAvailed());	       
					callableStatementHeader.setString(13,user_id);       	
					callableStatementHeader.setString(14,facility_id); 	
					callableStatementHeader.setString(15,client_ip_address); 	
					callableStatementHeader.registerOutParameter(16,java.sql.Types.VARCHAR);       	
					callableStatementHeader.registerOutParameter(17,java.sql.Types.VARCHAR); 	
					callableStatementHeader.registerOutParameter(18,java.sql.Types.VARCHAR); 	
		
					
					System.out.println("MaintainPrevilageCardManager InsertHeader   SP:::: "+sqlmaintainPrevilageCardHeaderInsert);
					
					callableStatementHeader.execute();	
					str_error_level		=	callableStatementHeader.getString(16);
					str_sysmesage_id	=	callableStatementHeader.getString(17);					
					str_error_text		=	callableStatementHeader.getString(18);
					
					System.out.println("BEFORE str_error_level in previlageCardHeaderPatientList:"+str_error_level);
					System.out.println("BEFORE str_sysmesage_id in previlageCardHeaderPatientList:"+str_sysmesage_id);
					System.out.println("BEFORE str_error_text in previlageCardHeaderPatientList:"+str_error_text);
					
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";
					
					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertableHeader=false;
					}
					else
					{
						insertableHeader = true;						
					}
					
					errAdd = "errAdd"+i;
					
					errTextAdd = "errTextAdd"+i;
					if(str_error_level!="" || str_error_text!="")
					{
						return_mess.put(errAdd, str_error_level+"-"+str_error_text);
					}
					
					if(str_sysmesage_id!="")
						{
							if(str_sysmesage_id.contains("|"))
							{
								//String msgArr[] = str_sysmesage_id.split("|");
								String msgArr[] = str_sysmesage_id.split("\\|");
								for(int l=0;l<msgArr.length;l++)
								{
									msgAdd = "msgAdd"+i+"-"+l;
									msgArr[l] = rb.getString(msgArr[l]);
									return_mess.put(msgAdd, msgArr[l]);
								}
							}
							else
							{
								msgAdd = "msgAdd"+i;
								str_sysmesage_id = rb.getString(str_sysmesage_id);
								return_mess.put(msgAdd, str_sysmesage_id);
							}
						}
				}// End Of FOR Loop
				if(insertableHeader ) 
				{	
					insertableHeader=true;
					insertable =  InsertSubHeaderTable(connection , tabdata) ;
				}
				
				// End of for
				if (insertableHeader && insertable ) {
					insertableHeader=true;
					strInsertable="true";
					connection.commit();
				} else {
					insertableHeader=false;
					strInsertable="false";
					connection.rollback(); 
				}
			}// End Of try block
			catch(Exception e)
			{
				insertableHeader=false;
				sys_err.append(" Exception while calling MaintainPrevilageCardManager Insert:"+e); 
				System.out.println("Exception in MaintainPrevilageCardManager Insert:"+e); 
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					if(billingPrevilageCardMemberBean!=null && billingPrevilageCardMemberBean!=null)
					{
						billingPrevilageCardMemberBean.clearBean();
						
					}	
					if(callableStatementHeader!=null)
						callableStatementHeader.close();
					if (connection != null)
						ConnectionManager.returnConnection(connection, properties);
				}
				catch(Exception e)
				{
					System.out.println("Exception while closing Resources :::"+e);
					e.printStackTrace();
				}
			}// end of finally block
			
		System.out.println("insertableHeader::::"+insertableHeader);
		System.out.println("insertable::::"+insertable);
//		return_mess.put("status",new Boolean(insertableHeader)); 
		return_mess.put("status",strInsertable);
		/*return_mess.put("error",str_error_text);
		return_mess.put("sys_error",sys_err.toString());
		return_mess.put("message",str_sysmesage_id);*/
		return return_mess;	
	}
	
	/**
	 * @param connection
	 * @param tabdata
	 * @return
	 */
	public boolean InsertSubHeaderTable(Connection connection,java.util.HashMap tabdata) //throws Exception
	{
		System.out.println("IN PkgCardSub InsertSubHeaderTable----");
		previlageCardAdditionalPatientList			=	new ArrayList();
		String str_error_level						=	"";
		String str_error_text						=	"";
		String str_sysmesage_id						=	"";
		//String locale 	= 	""; //duplicate variable declaration commented V210413
		String errAdd								=	"";
		String msgAdd								=	"";
		String errTextAdd							=	"";
		//UnUsed Variable V210413
		//SimpleDateFormat dateFormat 				=	new SimpleDateFormat("yyyy/mm/dd"); 
		//java.sql.Date date 						= null;
		//UnUsed Variable V210413

		if(locale==null) 
			locale="en";
		String facility_id 							= 	(String) tabdata.get("FACILITY_ID");
		if(facility_id==null) 
			facility_id=""; 
		client_ip_address							=	(String)tabdata.get("client_ip_address");
		if(client_ip_address==null)
			client_ip_address="";
		user_id										=	(String)tabdata.get("login_user");
		if(user_id==null) 
			user_id="";

		locale										=	(String)tabdata.get("locale");
		if(locale==null) 
			locale="en";
		//mode
		tab											=	(String)tabdata.get("tab"); 
		Locale loc = new Locale(locale);
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		previlageCardAdditionalPatientList				=	(ArrayList)tabdata.get("previlageCardAdditionalPatientList"); 
		for(int i=0;i<previlageCardAdditionalPatientList.size();i++) 
		 {
			billingPrevilageCardMemberBean = (BillingPrevilageCardMemberLocalBean)previlageCardAdditionalPatientList.get(i);
			 System.out.println("primaryPatientId				Insert 	:: "+billingPrevilageCardMemberBean.getPrimaryPatientId());
			 System.out.println("additionalPatientId 			Insert	:: "+billingPrevilageCardMemberBean.getAdditionalPatientId());
			 System.out.println("effectiveFrom 					Insert	:: "+billingPrevilageCardMemberBean.getEffectiveFrom());
			 System.out.println("hCardSeqNo 					Insert	:: "+billingPrevilageCardMemberBean.getHcardSeqno());
			 System.out.println("cardTypeCode 					Insert	:: "+billingPrevilageCardMemberBean.getCardTypeCode());
			 System.out.println("packageCode 					Insert	:: "+billingPrevilageCardMemberBean.getPackageCode());
		 }
						
		CallableStatement maintainPrevilageCardCallableStatement=null;
		try 
		{
			connection.setAutoCommit( false ) ;	
			insertable = true;
			String sqlmaintainPrevilageCardInsert="{ call   IBAEHIS.blhealthcard.insert_hcard_subdtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; 
			for(int i=0;i<previlageCardAdditionalPatientList.size();i++) 
			 {
				maintainPrevilageCardCallableStatement = connection.prepareCall(sqlmaintainPrevilageCardInsert);	
				billingPrevilageCardMemberBean = (BillingPrevilageCardMemberLocalBean)previlageCardAdditionalPatientList.get(i);
				maintainPrevilageCardCallableStatement.setString(1,facility_id);
				maintainPrevilageCardCallableStatement.setString(2,billingPrevilageCardMemberBean.getHcardSeqno());
				maintainPrevilageCardCallableStatement.setString(3,billingPrevilageCardMemberBean.getCardTypeCode());
				maintainPrevilageCardCallableStatement.setString(4,billingPrevilageCardMemberBean.getPrimaryPatientId());       
				maintainPrevilageCardCallableStatement.setString(5,billingPrevilageCardMemberBean.getAdditionalPatientId()); 
				maintainPrevilageCardCallableStatement.setDate(6,new Date(getDateInLong(billingPrevilageCardMemberBean.getEffectiveFrom())));   
				maintainPrevilageCardCallableStatement.setString(7,user_id);
				maintainPrevilageCardCallableStatement.setString(8,user_id);
				maintainPrevilageCardCallableStatement.setString(9,facility_id);	  
				maintainPrevilageCardCallableStatement.setString(10,facility_id);	       
				maintainPrevilageCardCallableStatement.setString(11,client_ip_address);	        
				maintainPrevilageCardCallableStatement.setString(12,client_ip_address);	       
				maintainPrevilageCardCallableStatement.registerOutParameter(13,java.sql.Types.VARCHAR);       	
				maintainPrevilageCardCallableStatement.registerOutParameter(14,java.sql.Types.VARCHAR); 	
				maintainPrevilageCardCallableStatement.registerOutParameter(15,java.sql.Types.VARCHAR); 	
	
				
				System.out.println("MaintainPrevilageCardManager Insert   SP:::: "+sqlmaintainPrevilageCardInsert);
				
				maintainPrevilageCardCallableStatement.execute();	
				str_error_level		=	maintainPrevilageCardCallableStatement.getString(13);
				str_sysmesage_id	=	maintainPrevilageCardCallableStatement.getString(14);					
				str_error_text		=	maintainPrevilageCardCallableStatement.getString(15);
				
				System.out.println("BEFORE str_error_level in previlageCardAdditionalPatient:"+str_error_level);
				System.out.println("BEFORE str_sysmesage_id in previlageCardAdditionalPatient:"+str_sysmesage_id);
				System.out.println("BEFORE str_error_text in previlageCardAdditionalPatient:"+str_error_text);
				
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";
				
				

				if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
				{
					insertable=false;
				}
				else
				{
					insertable = true;						
				} 

				errAdd = "errAdd"+i;
					
				errTextAdd = "errTextAdd"+i;
				if(str_error_level!="" || str_error_text!="")
				{
					return_mess.put(errAdd, str_error_level+"-"+str_error_text);
				}
				
				if(str_sysmesage_id!="")
					{
						if(str_sysmesage_id.contains("|"))
						{
							//String msgArr[] = str_sysmesage_id.split("|");
							String msgArr[] = str_sysmesage_id.split("\\|");
							for(int l=0;l<msgArr.length;l++)
							{
								msgAdd = "msgAdd"+i+"-"+l;
								msgArr[l] = rb.getString(msgArr[l]);
								return_mess.put(msgAdd, msgArr[l]);
							}
						}
						else
						{
							msgAdd = "msgAdd"+i;
							str_sysmesage_id = rb.getString(str_sysmesage_id);
							return_mess.put(msgAdd, str_sysmesage_id);
						}
					}


			}// END of FOR loop
			if(insertable ) 
			{	
				insertable=true;
				modifyInsertable =  Update(connection , tabdata) ;
			}
			
			// End of for
			if (insertable && modifyInsertable) {
				insertable=true;
			} else 
			{
				insertable=false;
			}
		}// End Of try block
		catch(Exception e)
		{
			insertable=false;
			sys_err.append(" Exception while calling MaintainPrevilageCardManager Insert:"+e); 
			System.out.println("Exception in MaintainPrevilageCardManager Insert:"+e); 
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(billingPrevilageCardMemberBean!=null && billingPrevilageCardMemberBean!=null)
				{
					billingPrevilageCardMemberBean.clearBean();
					
				}	
				if(maintainPrevilageCardCallableStatement!=null)
					maintainPrevilageCardCallableStatement.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception while closing Resources :::"+e);
				e.printStackTrace();
			}
		}// end of finally block
		
	System.out.println("insertable::::"+insertable);
	//System.out.println("modifyInsertable::::"+modifyInsertable);
	/*return_mess.put("status",new Boolean(insertable)); 
	return_mess.put("error",str_error_text);
	return_mess.put("sys_error",sys_err.toString());
	return_mess.put("message",str_sysmesage_id);*/	 
	return insertable;	
}


	
	/**
	 * @param connection
	 * @param tabdata
	 * @return
	 */
	public boolean Update(Connection connection,java.util.HashMap tabdata) //throws Exception 
	{		
		//boolean modifyInsertable 					= 	false;
		System.out.println("IN MaintainPrevilageCardManager Update");
		previlageCardModifyPatientList			=	new ArrayList();
		String str_error_level		=	"";
		String str_error_text		=	"";
		String str_sysmesage_id		=	"";
		//String locale 			= 	""; // Duplicate Object created V210413
		String errAdd				=	"";
		String msgAdd				=	"";
		String errTextAdd			=	"";

		if(locale==null) 
			locale="en";
		String facility_id 			= 	(String) tabdata.get("FACILITY_ID");
		if(facility_id==null) 
			facility_id=""; 
		client_ip_address			=	(String)tabdata.get("client_ip_address");
		if(client_ip_address==null)
			client_ip_address="";
		user_id						=	(String)tabdata.get("login_user");
		if(user_id==null) 
			user_id="";

		locale						=	(String)tabdata.get("locale");
		if(locale==null) 
			locale="en";
		Locale loc = new Locale(locale);
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		//mode
		tab							=	(String)tabdata.get("tab"); 
		previlageCardModifyPatientList				=	(ArrayList)tabdata.get("previlageCardModifyPatientList"); 
		for(int i=0;i<previlageCardModifyPatientList.size();i++) 
		 {
			billingPrevilageCardMemberBean = (BillingPrevilageCardMemberLocalBean)previlageCardModifyPatientList.get(i);
			 System.out.println("hCardSeqNo						Modify 	:: "+billingPrevilageCardMemberBean.getHcardSeqno());
			 System.out.println("additionalPatientId 			Modify	:: "+billingPrevilageCardMemberBean.getAdditionalPatientId());
			 System.out.println("priceClassCode					Modify	:: "+billingPrevilageCardMemberBean.getAdditionalPatientPriceClasscode());
			 System.out.println("packageCode 					Modify	:: "+billingPrevilageCardMemberBean.getPackageCode()); 
		 }
						
		CallableStatement maintainPrevilageCardCallableStatement=null;
		try
		{
			connection.setAutoCommit( false ) ;	
			modifyInsertable = true;
			String sqlmaintainPrevilageCardUpdate="{ call   IBAEHIS.blhealthcard.update_hcard_subdtl(?,?,?,?,?,?,?,?,?,?,?)}";
			for(int i=0;i<previlageCardModifyPatientList.size();i++) 
			 {
				maintainPrevilageCardCallableStatement = connection.prepareCall(sqlmaintainPrevilageCardUpdate);	
				billingPrevilageCardMemberBean = (BillingPrevilageCardMemberLocalBean)previlageCardModifyPatientList.get(i);
				maintainPrevilageCardCallableStatement.setString(1,facility_id); 
				maintainPrevilageCardCallableStatement.setString(2,billingPrevilageCardMemberBean.getHcardSeqno());       
				maintainPrevilageCardCallableStatement.setString(3,billingPrevilageCardMemberBean.getAdditionalPatientId());
				maintainPrevilageCardCallableStatement.setString(4,billingPrevilageCardMemberBean.getAdditionalPatientPriceClasscode());
				maintainPrevilageCardCallableStatement.setString(5,billingPrevilageCardMemberBean.getPackageCode());
				maintainPrevilageCardCallableStatement.setString(6,facility_id);
				maintainPrevilageCardCallableStatement.setString(7,facility_id);
				maintainPrevilageCardCallableStatement.setString(8,client_ip_address);
				maintainPrevilageCardCallableStatement.registerOutParameter(9,java.sql.Types.VARCHAR);       	
				maintainPrevilageCardCallableStatement.registerOutParameter(10,java.sql.Types.VARCHAR); 	
				maintainPrevilageCardCallableStatement.registerOutParameter(11,java.sql.Types.VARCHAR); 	
	
				
				System.out.println("MaintainPrevilageCardManager Update   SP:::: "+sqlmaintainPrevilageCardUpdate);
				
				maintainPrevilageCardCallableStatement.execute();	
				str_error_level		=	maintainPrevilageCardCallableStatement.getString(9);
				str_sysmesage_id	=	maintainPrevilageCardCallableStatement.getString(10);					
				str_error_text		=	maintainPrevilageCardCallableStatement.getString(11);
				
				System.out.println("BEFORE str_error_level in sqlmaintainPrevilageCardUpdate:"+str_error_level);
				System.out.println("BEFORE str_sysmesage_id in sqlmaintainPrevilageCardUpdate:"+str_sysmesage_id);
				System.out.println("BEFORE str_error_text in sqlmaintainPrevilageCardUpdate:"+str_error_text);
				
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";
				
				

				if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
				{
					modifyInsertable=false;
				}
				else
				{
					modifyInsertable = true;						
				} 
				
				errAdd = "errAdd"+i;
					
				errTextAdd = "errTextAdd"+i;
				if(str_error_level!="" || str_error_text!="")
				{
					return_mess.put(errAdd, str_error_level+"-"+str_error_text);
				}
				
				if(str_sysmesage_id!="")
					{
						if(str_sysmesage_id.contains("|"))
						{
							//String msgArr[] = str_sysmesage_id.split("|");
							String msgArr[] = str_sysmesage_id.split("\\|");
							for(int l=0;l<msgArr.length;l++)
							{
								msgAdd = "msgAdd"+i+"-"+l;
								msgArr[l] = rb.getString(msgArr[l]);
								return_mess.put(msgAdd, msgArr[l]);
							}
						}
						else
						{
							msgAdd = "msgAdd"+i;
							str_sysmesage_id = rb.getString(str_sysmesage_id);
							return_mess.put(msgAdd, str_sysmesage_id);
						}
					}



				
			}// End of FOR LOOP
			if(modifyInsertable ) 
				{	
					
					isDeleted =  modify(connection , tabdata) ;
				}
				if(modifyInsertable && isDeleted)
				{
					modifyInsertable=true;
				}
				else
				{
					modifyInsertable=false;
				}
			
			
			
		}// End Of try block
		catch(Exception e)
		{
			modifyInsertable=false;
			sys_err.append(" Exception while calling MaintainPrevilageCardManager Update:"+e);
			System.out.println("Exception in MaintainPrevilageCardManager Update:"+e); 
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(maintainPrevilageCardCallableStatement!=null)
					maintainPrevilageCardCallableStatement.close();
				//if (connection != null)
					//ConnectionManager.returnConnection(connection, properties);
			}
			catch(Exception e)
			{
				System.out.println("Exception while closing Resources :::"+e);
				e.printStackTrace();
			}
		}// end of finally block
		
	System.out.println("modify::::"+modifyInsertable);  
	/*return_mess.put("status",new Boolean(modifyInsertable));  
	return_mess.put("error",str_error_text);
	return_mess.put("sys_error",sys_err.toString());
	return_mess.put("message",str_sysmesage_id);	*/
	return modifyInsertable;	
}
	

	/**
	 *@ejb.interface-method
	 *Method to modify/delete single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	public boolean modify(Connection connection,java.util.HashMap tabdata) //throws Exception 
	{		
		//boolean modifyInsertable 					= 	false;
		System.out.println("IN MaintainPrevilageCardManager MODIFY");
		previlageCardDeletePatientList			=	new ArrayList();
		String str_error_level		=	"";
		String str_error_text		=	"";
		String str_sysmesage_id		=	"";
		//String locale 			= 	""; //Duplicated variable created V210413
		String errAdd				=	"";
		String msgAdd				=	"";
		String errTextAdd			=	"";

		if(locale==null) 
			locale="en";
		String facility_id 			= 	(String) tabdata.get("FACILITY_ID");
		if(facility_id==null) 
			facility_id=""; 
		client_ip_address			=	(String)tabdata.get("client_ip_address");
		if(client_ip_address==null)
			client_ip_address="";
		user_id						=	(String)tabdata.get("login_user");
		if(user_id==null) 
			user_id="";

		locale						=	(String)tabdata.get("locale");
		if(locale==null) 
			locale="en";
		Locale loc = new Locale(locale);
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		//mode
		tab							=	(String)tabdata.get("tab"); 
		previlageCardDeletePatientList				=	(ArrayList)tabdata.get("previlageCardDeletePatientList"); 
		for(int i=0;i<previlageCardDeletePatientList.size();i++) 
		 {
			billingPrevilageCardMemberBean = (BillingPrevilageCardMemberLocalBean)previlageCardDeletePatientList.get(i);
			 System.out.println("primaryPatientId				Delete 	:: "+billingPrevilageCardMemberBean.getPrimaryPatientId());
			 System.out.println("additionalPatientId 			Delete	:: "+billingPrevilageCardMemberBean.getAdditionalPatientId());
			 System.out.println("effectiveFrom 					Delete	:: "+billingPrevilageCardMemberBean.getEffectiveFrom()); 
			 System.out.println("hCardSeqNo 					Delete	:: "+billingPrevilageCardMemberBean.getHcardSeqno());
			 System.out.println("cardTypeCode 					Delete	:: "+billingPrevilageCardMemberBean.getCardTypeCode());
			
		 }
						
		CallableStatement maintainPrevilageCardCallableStatement=null;
		try
		{
			connection.setAutoCommit( false ) ;	
			isDeleted = true;
			String sqlmaintainPrevilageCardDelete="{ call   IBAEHIS.blhealthcard.delete_hcard_subdtl(?,?,?,?,?,?)}";
			for(int i=0;i<previlageCardDeletePatientList.size();i++) 
			 {
				maintainPrevilageCardCallableStatement = connection.prepareCall(sqlmaintainPrevilageCardDelete);	
				billingPrevilageCardMemberBean = (BillingPrevilageCardMemberLocalBean)previlageCardDeletePatientList.get(i);
				maintainPrevilageCardCallableStatement.setString(1,facility_id); 
				maintainPrevilageCardCallableStatement.setString(2,billingPrevilageCardMemberBean.getHcardSeqno());       
				maintainPrevilageCardCallableStatement.setString(3,billingPrevilageCardMemberBean.getAdditionalPatientId());
				maintainPrevilageCardCallableStatement.registerOutParameter(4,java.sql.Types.VARCHAR);       	
				maintainPrevilageCardCallableStatement.registerOutParameter(5,java.sql.Types.VARCHAR); 	
				maintainPrevilageCardCallableStatement.registerOutParameter(6,java.sql.Types.VARCHAR); 	
	
				
				System.out.println("MaintainPrevilageCardManager DELETE   SP:::: "+sqlmaintainPrevilageCardDelete);
				
				maintainPrevilageCardCallableStatement.execute();	
				str_error_level		=	maintainPrevilageCardCallableStatement.getString(4);
				str_sysmesage_id	=	maintainPrevilageCardCallableStatement.getString(5);					
				str_error_text		=	maintainPrevilageCardCallableStatement.getString(6);
				
				System.out.println("BEFORE str_error_level in previlageCardDeletePatientList:"+str_error_level);
				System.out.println("BEFORE str_sysmesage_id in previlageCardDeletePatientList:"+str_sysmesage_id);
				System.out.println("BEFORE str_error_text in previlageCardDeletePatientList:"+str_error_text);
				
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";
				
				

				if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
				{
					isDeleted=false;
				}
				else
				{
					isDeleted = true;						
				} 

				errAdd = "errAdd"+i;
					
				errTextAdd = "errTextAdd"+i;
				if(str_error_level!="" || str_error_text!="")
				{
					return_mess.put(errAdd, str_error_level+"-"+str_error_text);
				}
				
				if(str_sysmesage_id!="")
					{
						if(str_sysmesage_id.contains("|"))
						{
							//String msgArr[] = str_sysmesage_id.split("|");
							String msgArr[] = str_sysmesage_id.split("\\|");
							for(int l=0;l<msgArr.length;l++)
							{
								msgAdd = "msgAdd"+i+"-"+l;
								msgArr[l] = rb.getString(msgArr[l]);
								return_mess.put(msgAdd, msgArr[l]);
							}
						}
						else
						{
							msgAdd = "msgAdd"+i;
							str_sysmesage_id = rb.getString(str_sysmesage_id);
							return_mess.put(msgAdd, str_sysmesage_id);
						}
					}


			} // END OF FOR LOOP
			
			
			
			
		}// End Of try block
		catch(Exception e)
		{
			modifyInsertable=false;
			sys_err.append(" Exception while calling MaintainPrevilageCardManager Delete:"+e);
			System.out.println("Exception in MaintainPrevilageCardManager Delete:"+e); 
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(maintainPrevilageCardCallableStatement!=null)
					maintainPrevilageCardCallableStatement.close();
				//if (connection != null)
					//ConnectionManager.returnConnection(connection, properties);
			}
			catch(Exception e)
			{
				System.out.println("Exception while closing Resources :::"+e);
				e.printStackTrace();
			}
		}// end of finally block
		
	System.out.println("isDeleted::::"+isDeleted);  
	/*return_mess.put("status",new Boolean(isDeleted));  
	return_mess.put("error",str_error_text);
	return_mess.put("sys_error",sys_err.toString());
	return_mess.put("message",str_sysmesage_id);	*/
	return isDeleted;	
}


/*
	* This method takes input in DD/MM/YYYY format and provides appropriate 
	* long value
	*/ 
	private long getDateInLong(String dateString){ 
	if(dateString==null){
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

	//Boopathy

	//Karthik
	
	/* Inserts Visit Detail Credentials */
	
	
	/* Updates Card Header Credentials */
	
		
	/* Updates Age Detail Credentials */
	
	




	
}
