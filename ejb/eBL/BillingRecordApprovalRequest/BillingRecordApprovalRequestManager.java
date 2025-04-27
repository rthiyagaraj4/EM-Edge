/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1			V220919 			  33891		         TH-KW-CRF-0093                     Mohanapriya K
*/
package eBL.BillingRecordApprovalRequest;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import webbeans.eCommon.ConnectionManager;
import java.util.Locale;
import java.util.ResourceBundle;
  




/**
*
* @ejb.bean
*	name="BillingRecordApprovalRequest"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="BillingRecordApprovalRequest"
*	local-jndi-name="BillingRecordApprovalRequest"
*	impl-class-name="eBL.BillingRecordApprovalRequest.BillingRecordApprovalRequestManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eBL.BillingRecordApprovalRequest.BillingRecordApprovalRequestLocal"
*	remote-class="eBL.BillingRecordApprovalRequest.BillingRecordApprovalRequestRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.BillingRecordApprovalRequest.BillingRecordApprovalRequestLocalHome"
*	remote-class="eBL.BillingRecordApprovalRequest.BillingRecordApprovalRequestHome"
*	generate= "local,remote"
*
*
*/
public class BillingRecordApprovalRequestManager implements SessionBean   
{
	Connection connection;

	
	SessionContext ctx;

	

	String locale = "";

	String encounterid = "";

	String gen_doc_type="",gen_doc_num="";
	ArrayList<String[]> 	preApprovalRequestSpecPatientList			=	null;
	ArrayList<String[]> 	preApprovalRequestDeletePatientList			=	null;
	ArrayList<String[]> 	preApprovalRequestServiceLevelPatientList	=	null;
	StringBuffer 	sys_err 											= 	new StringBuffer("") ;
	String			tab													=	null; 
	HashMap return_mess 												= 	new HashMap();		
	boolean modified 													= 	false;
		
	String currdate="",client_ip_address="",user_id="";

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
	
	/* Added V180714-Aravindh/MMS-Recalculation/Starts */
	String sessionIdQry = "", pSessionId = "", pgmDate = "";
	boolean reCalcUsingTempTbl = false;
	/* Added V180714-Aravindh/MMS-Recalculation/Ends */
	boolean enableMCNNumber =false;//V220919
	boolean enableInsClr=false;//V221216
	boolean sitespecUploadDoc=false;
	boolean extnIntEnable=false;//V231010-NMC-JD-CRF-0102.2
	int claimId=0;
	String error_id="",err_text="",refId="",refTypeID="";
	String existReqId="";
	String isHeaderProcReqd = "N";
	String ins_mode="N";
	String upd_mode="N";
	//int count=0;
	//V231010-NMC-JD-CRF-0102.2	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
		public java.util.HashMap insert(java.util.Properties properties,java.util.HashMap tabdata) //throws Exception 
		{		
			System.out.println("IN 120 BillingRecordApprovalRequestManager SPEC UPDATE----");
			System.out.println("tabdata in manager "+tabdata);
			preApprovalRequestServiceLevelPatientList			=	new ArrayList();
			connection 									= 	ConnectionManager.getConnection(properties);
			return_mess 								= 	new HashMap();		
			boolean insertableHeader					= 	false;
			boolean recalcFlag							= 	false;

			String strInsertable	 					= 	"";
			String str_error_level						=	"";
			String str_error_text						=	"";
			String str_sysmesage_id						=	"";
			String locale 								= 	"";
			String errAdd								=	"";
			String msgAdd								=	"";
			String errTextAdd							=	"";
			SimpleDateFormat dateFormat 				=	new SimpleDateFormat("yyyy/mm/dd"); 
			java.sql.Date date 							= null;
			String encounterIdModified="";	

			if(locale==null) 
			locale="en";
		
			String facility_id 							= 	(String) tabdata.get("FACILITY_ID");
			if(facility_id==null) facility_id=""; 
		
			client_ip_address							=	(String)tabdata.get("client_ip_address");
			if(client_ip_address==null)	client_ip_address="";
		
			user_id										=	(String)tabdata.get("login_user");
			if(user_id==null) user_id="";

			locale										=	(String)tabdata.get("locale");
			if(locale==null) locale="en";
		
			String recalcCharges = (String)tabdata.get("recalcCharges");
			String insClr = (String)tabdata.get("insuranceClr");

			String strPatientId =  (String) tabdata.get("patientId");				 
			String strEpisodeType= (String)tabdata.get("episodeType");
			String strEpisodeId =  (String)tabdata.get("episodeId");
			String strVisitId	=  (String)tabdata.get("visitId");
			String strEncounterId = (String)tabdata.get("encounterId");
			String expiryDate = (String)tabdata.get("expiryDate"); //karthik Record approval   -  MMS-QH-CRF-0165 
			String accountSeqNo =  (String) tabdata.get("accountSeqNo");		
			String policyTypeCode =  (String) tabdata.get("policyTypeCode");		
			String policyNumber =  (String) tabdata.get("policyNumber");		
			String custCode =  (String) tabdata.get("custCode");		
			String custGroupCode =  (String) tabdata.get("custGroupCode");	
			String effectiveToDate =  (String) tabdata.get("effectiveToDate");	
			
			String encIdStrNonServLevel=(String) tabdata.get("encIdStrNonServLevel");
			String priority = (String) tabdata.get("priority");
			//102.2
			isHeaderProcReqd = (String) tabdata.get("isHeaderProcReqd");
			ins_mode = (String) tabdata.get("ins_mode");
			upd_mode = (String) tabdata.get("upd_mode");
			existReqId = (String) tabdata.get("existReqID");
			String membershipNo=(String) tabdata.get("membershipNo");
			System.out.println("encIdStrNonServLevel "+encIdStrNonServLevel);
			System.out.println("strEncounterId "+strEncounterId);

			Locale loc = new Locale(locale);
			ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);

			tab											=	(String)tabdata.get("tab"); 

			/* Added V180714-Aravindh/MMS-Recalculation/Starts */
			try {
				sessionIdQry = "SELECT USERENV ('SESSIONID') session_id, TO_CHAR (SYSDATE, 'YYMMDDHH24MISS') pgm_date FROM DUAL";
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sessionIdQry);
				while(rs.next()) {
					this.pSessionId = rs.getString("session_id");
					this.pgmDate = rs.getString("pgm_date");
				}
				this.reCalcUsingTempTbl = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","BL_RECALC_SERV_LVL_YN");
				this.enableMCNNumber = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","ENB_MCN_REQ_NUM_FOR_SERV_APPR");
				System.out.println("enableMCNNumber "+enableMCNNumber);//V220919
				System.out.println("reCalcUsingTempTbl "+reCalcUsingTempTbl);//V220919
				this.enableInsClr = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","BL_INS_CLEARANCE_APPL");//V221216
				System.out.println("enableInsClr >> "+enableInsClr);
				this.extnIntEnable = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","REC_APPR_EXT_INT_ENABLED");
				System.out.println("extnIntEnable >> "+extnIntEnable);//NMC-JD_CRF_102.2
			} catch(Exception e) {
				System.err.println("Error in generating sessionIdQry: "+e);
				e.printStackTrace();
			}
			/* Added V180714-Aravindh/MMS-Recalculation/Ends */

			CallableStatement callableStatement=null;
			try 
			{

				insertableHeader = true;
				try{
						connection.setAutoCommit( false ) ;						
					}
				catch(Exception e){
					System.err.println("Exception in connection :"+e); 
					e.printStackTrace();
				}

				preApprovalRequestSpecPatientList =	(ArrayList)tabdata.get("preApprovalRequestServiceLevelPatientList"); 					
				preApprovalRequestServiceLevelPatientList =	(ArrayList)tabdata.get("preApprovalRequestSpecPatientList"); 					
				System.out.println("preApprovalRequestSpecPatientList/preApprovalRequestServiceLevelPatientList"+preApprovalRequestSpecPatientList.size()+"/"+preApprovalRequestServiceLevelPatientList.size());


				if(preApprovalRequestSpecPatientList.size() == 0 && preApprovalRequestServiceLevelPatientList.size() ==0)
				{		
					if (insertableHeader == true){								
						try{
							//	connection.commit();
							recalcFlag  = true;
							insertableHeader=false;								
							//			strInsertable  = "true";
							modified = true;	
							//	return_mess.put("status",strInsertable);
							//								return_mess.put("status", "APP-SM0070 Operation Completed Successfully ");							
						}
						catch(Exception e){
							System.err.println("Exception in connection :"+e); 
							e.printStackTrace();
						}
					}
					else{								
						insertableHeader=false;								
						strInsertable  = "false";
						return_mess.put("status",strInsertable);
						return_mess.put("msgAdd0 -0", rb.getString("BL1119"));
						return return_mess;		
					}
				}
				else{						
					insertableHeader = true;						
				}
				System.out.println("insertableHeader in manager 307 "+insertableHeader);

				if(insertableHeader)
				{
					if(extnIntEnable && isHeaderProcReqd.equalsIgnoreCase("Y")){
						strEncounterId=strEncounterId.substring(1, strEncounterId.indexOf("@"));
						System.out.println("strEncounterId manager 317 "+strEncounterId);
						//policyTypeCode,policyNumber,custCode,custGroupCode
						if(ins_mode.equalsIgnoreCase("Y")){
							//getClaimIdDtls(facility_id,strPatientId,strEncounterId,user_id,client_ip_address,"I","","SRPREAUTHREQ",policyTypeCode,policyNumber,custCode,custGroupCode,membershipNo);
							getClaimIdDtls(facility_id,strPatientId,strEncounterId,user_id,client_ip_address,"I","","SRPREAUTHREQ",policyTypeCode,policyNumber,custCode,custGroupCode,membershipNo,"S","Send To Insurance");
						}
						
						System.out.println("claimId manager 317 "+claimId);
						System.out.println("refId manager 317 "+refId);
						System.out.println("refTypeID manager 317 "+refTypeID);
					}//V231010 - NMC-JD-CRF-0102.2 -mode need to be clarified

					smsMessageGlobalVarInitialize();

					System.out.println("manager 327 ");

					String sqlpreApprovalRequestInsert="{ call   blinstransactions.update_enc_spec_preapp_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //V220919 102.2
					int count=0;
					for(int index=0;index<preApprovalRequestSpecPatientList.size();index++)
					{   
						// Move this entire logic after calling our existing billing procedure
						if(extnIntEnable){
							String status=preApprovalRequestSpecPatientList.get(index)[16];
							String mode="";
							if(status.equalsIgnoreCase("S") || status.equalsIgnoreCase("C")){

								if(preApprovalRequestSpecPatientList.get(index)[46].equals("") && status.equalsIgnoreCase("S")){
									count++;
								}else{
									count=Integer.parseInt(preApprovalRequestSpecPatientList.get(index)[48]);
								}
								if(status.equalsIgnoreCase("c")){
									mode="U";
								}else if(status.equalsIgnoreCase("S")){
									mode="I";
									insertInsRecApprTrck(tabdata,preApprovalRequestSpecPatientList,index,count);//102.2
								}
								System.out.println("preApprovalRequestSpecPatientList.get(index)[19] "+preApprovalRequestSpecPatientList.get(index)[19]);
								System.out.println("preApprovalRequestSpecPatientList.get(index)[41] "+preApprovalRequestSpecPatientList.get(index)[41]);

								System.out.println("setservlvldtls manager 344");
							}
						}//V231010 - NMC-JD-CRF-0102.2
						/* Error and Message is Collected, but this will not Stop the Flow in Case Error is found MMS-DM-SCF-INT-0003 */
						smsMessageAppserevantGenerator(facility_id,strPatientId,preApprovalRequestSpecPatientList.get(index)[42],strEpisodeType,strEpisodeId,strVisitId,preApprovalRequestSpecPatientList.get(index)[35],preApprovalRequestSpecPatientList.get(index)[36],preApprovalRequestSpecPatientList.get(index)[13],preApprovalRequestSpecPatientList.get(index)[16],custCode);

						callableStatement = connection.prepareCall(sqlpreApprovalRequestInsert);	 
						callableStatement.setString(1,facility_id);
						callableStatement.setString(2,preApprovalRequestSpecPatientList.get(index)[0]);
						callableStatement.setString(3,preApprovalRequestSpecPatientList.get(index)[1]);
						callableStatement.setString(4,preApprovalRequestSpecPatientList.get(index)[2]);       
						callableStatement.setString(5,preApprovalRequestSpecPatientList.get(index)[3]); 
						callableStatement.setString(6,preApprovalRequestSpecPatientList.get(index)[42]);   
						callableStatement.setString(7,preApprovalRequestSpecPatientList.get(index)[8]); 
						callableStatement.setString(8,preApprovalRequestSpecPatientList.get(index)[9]);
						callableStatement.setString(9,preApprovalRequestSpecPatientList.get(index)[6]);
						callableStatement.setString(10,preApprovalRequestSpecPatientList.get(index)[5]);	       
						callableStatement.setString(11,preApprovalRequestSpecPatientList.get(index)[7]);	        
						callableStatement.setString(12,preApprovalRequestSpecPatientList.get(index)[11]);	       
						callableStatement.setString(13,preApprovalRequestSpecPatientList.get(index)[12]);
						callableStatement.setString(14,preApprovalRequestSpecPatientList.get(index)[21]);
						callableStatement.setString(15,preApprovalRequestSpecPatientList.get(index)[22]);
						callableStatement.setString(16,preApprovalRequestSpecPatientList.get(index)[23]);       
						callableStatement.setString(17,preApprovalRequestSpecPatientList.get(index)[24]);  
						callableStatement.setString(18,preApprovalRequestSpecPatientList.get(index)[25]);   
						callableStatement.setString(19,preApprovalRequestSpecPatientList.get(index)[32]);
						callableStatement.setString(20,preApprovalRequestSpecPatientList.get(index)[29]);
						callableStatement.setString(21,preApprovalRequestSpecPatientList.get(index)[30]);	 
						System.err.println("BillingRecordApprovalRequestManager SPEC UPDATE preApprovalRequestSpecPatientList.get(index)[18]:::: "+preApprovalRequestSpecPatientList.get(index)[18]);
						callableStatement.setDate(22,new Date(getDateInLong(preApprovalRequestSpecPatientList.get(index)[18])));	  
						System.err.println("BillingRecordApprovalRequestManager SPEC UPDATE preApprovalRequestSpecPatientList.get(index)[28]:::: "+preApprovalRequestSpecPatientList.get(index)[28]);
						System.err.println("BilingRecordApprovalRequestManager   value "+new Date(getDateInLong(preApprovalRequestSpecPatientList.get(index)[18])));

						if(getDateInLong(preApprovalRequestSpecPatientList.get(index)[28])==0)
						{
							callableStatement.setString(23,null);
							System.out.println("Assign Null to Effective Todate1  ");
						}
						else
						{
							callableStatement.setDate(23,new Date(getDateInLong(preApprovalRequestSpecPatientList.get(index)[28])));
						}
						callableStatement.setString(24,preApprovalRequestSpecPatientList.get(index)[31]);       	
						callableStatement.setString(25,user_id);       	
						callableStatement.setString(26,client_ip_address);       	
						callableStatement.setString(27,facility_id); 	
						callableStatement.setString(28,preApprovalRequestSpecPatientList.get(index)[26]); 	
						callableStatement.setString(29,preApprovalRequestSpecPatientList.get(index)[27]);       	
						callableStatement.registerOutParameter(30,java.sql.Types.VARCHAR); 	
						callableStatement.registerOutParameter(31,java.sql.Types.VARCHAR); 	
						callableStatement.registerOutParameter(32,java.sql.Types.VARCHAR); 	
						callableStatement.setString(33,preApprovalRequestSpecPatientList.get(index)[13]); 	
						if(getDateInLong(preApprovalRequestSpecPatientList.get(index)[14])==0)
							callableStatement.setString(34,null);
						else
							callableStatement.setDate(34,new Date(getDateInLong(preApprovalRequestSpecPatientList.get(index)[14])));

						if( getDateInLong(preApprovalRequestSpecPatientList.get(index)[15])==0)
							callableStatement.setString(35,null);
						else	
							callableStatement.setDate(35,new Date(getDateInLong(preApprovalRequestSpecPatientList.get(index)[15])));

						callableStatement.setString(36,preApprovalRequestSpecPatientList.get(index)[16]); 	
						callableStatement.setString(37,preApprovalRequestSpecPatientList.get(index)[17]); 	
						callableStatement.setString(38,preApprovalRequestSpecPatientList.get(index)[20]);
						callableStatement.setString(39,preApprovalRequestSpecPatientList.get(index)[39]);
						callableStatement.setString(40,preApprovalRequestSpecPatientList.get(index)[40]);
						callableStatement.setString(41,preApprovalRequestSpecPatientList.get(index)[43]);
						callableStatement.setString(42,preApprovalRequestSpecPatientList.get(index)[44]);
						callableStatement.setString(43,"N"); //V220919
						callableStatement.setString(44,"G"); //V220919
						callableStatement.setString(45,preApprovalRequestSpecPatientList.get(index)[45]); //V220919
						//NMC-JD-CRF-102.2
						System.out.println("extnIntEnable "+extnIntEnable+" claimId "+claimId+" count"+count);

						System.out.println("inside 490 extnIntEnable if condn 46 "+preApprovalRequestSpecPatientList.get(index)[46]);
						System.out.println("inside extnIntEnable if condn 47 "+preApprovalRequestSpecPatientList.get(index)[47]);
						System.out.println("inside extnIntEnable if condn 48 "+preApprovalRequestSpecPatientList.get(index)[48]);

						if(preApprovalRequestSpecPatientList.get(index)[46].equals("") && preApprovalRequestSpecPatientList.get(index)[47].equals(""))
						{
							callableStatement.setInt(46,claimId);
							callableStatement.setInt(47,count);
							callableStatement.setInt(48,count);
						}else{
							callableStatement.setString(46,preApprovalRequestSpecPatientList.get(index)[46]);
							callableStatement.setString(47,preApprovalRequestSpecPatientList.get(index)[47]);
							callableStatement.setString(48,preApprovalRequestSpecPatientList.get(index)[48]);
						}
						System.out.println("inside extnIntEnable condn "+preApprovalRequestSpecPatientList.get(index)[46]);
						System.out.println("inside extnIntEnable condn "+preApprovalRequestSpecPatientList.get(index)[47]);
						System.out.println("patientId					manager::: "+ preApprovalRequestSpecPatientList.get(index)[0]);
						System.out.println("episodeType							::: "+ preApprovalRequestSpecPatientList.get(index)[1]);
						System.out.println("episodeId							::: "+ preApprovalRequestSpecPatientList.get(index)[2]);
						System.out.println("visitId								::: "+ preApprovalRequestSpecPatientList.get(index)[3]);
						System.out.println("encounterId							::: "+ preApprovalRequestSpecPatientList.get(index)[4]);
						System.out.println("policyTypeCode						::: "+ preApprovalRequestSpecPatientList.get(index)[5]);
						System.out.println("custGroupCode						::: "+ preApprovalRequestSpecPatientList.get(index)[6]);
						System.out.println("custCode							::: "+ preApprovalRequestSpecPatientList.get(index)[7]);
						System.out.println("accountSeqNo						::: "+ preApprovalRequestSpecPatientList.get(index)[8]);
						System.out.println("priority							::: "+ preApprovalRequestSpecPatientList.get(index)[9]);
						System.out.println("policyNumber						::: "+ preApprovalRequestSpecPatientList.get(index)[10]);
						System.out.println("billingServiceCode					::: "+ preApprovalRequestSpecPatientList.get(index)[11]);
						System.out.println("includedExcluded					::: "+ preApprovalRequestSpecPatientList.get(index)[12]);
						System.out.println("preApprovalNumber					::: "+ preApprovalRequestSpecPatientList.get(index)[13]);
						System.out.println("approvalRequiredDate				::: "+ preApprovalRequestSpecPatientList.get(index)[14]);
						System.out.println("approvalGivenDate					::: "+ preApprovalRequestSpecPatientList.get(index)[15]);
						System.out.println("approvalStatus						::: "+ preApprovalRequestSpecPatientList.get(index)[16]);
						System.out.println("approvalremarks						::: "+ preApprovalRequestSpecPatientList.get(index)[17]);
						System.out.println("effectiveFrom						::: "+ preApprovalRequestSpecPatientList.get(index)[18]);
						System.out.println("availableServiceAmount				::: "+ preApprovalRequestSpecPatientList.get(index)[19]);
						System.out.println("reasonCode							::: "+ preApprovalRequestSpecPatientList.get(index)[20]);
						System.out.println("patientClass						::: "+ preApprovalRequestSpecPatientList.get(index)[21]);
						System.out.println("episodeEncounterFlag				::: "+ preApprovalRequestSpecPatientList.get(index)[22]);
						System.out.println("clinicNursingIndicator				::: "+ preApprovalRequestSpecPatientList.get(index)[23]);
						System.out.println("clinicNursingCode					::: "+ preApprovalRequestSpecPatientList.get(index)[24]);
						System.out.println("specialiltyCode						::: "+ preApprovalRequestSpecPatientList.get(index)[25]);
						System.out.println("sex									::: "+ preApprovalRequestSpecPatientList.get(index)[26]);
						System.out.println("ageGroupCode						::: "+ preApprovalRequestSpecPatientList.get(index)[27]);
						System.out.println("effectiveTo							::: "+ preApprovalRequestSpecPatientList.get(index)[28]);
						System.out.println("approvalAmountCapping::				::: "+ preApprovalRequestSpecPatientList.get(index)[29]);
						System.out.println("approvalQuantityCapping:			::: "+ preApprovalRequestSpecPatientList.get(index)[30]);
						System.out.println("approvalGrossNetAmount::			::: "+ preApprovalRequestSpecPatientList.get(index)[31]);
						System.out.println("serviceLevelApprovalFlag::			::: "+ preApprovalRequestSpecPatientList.get(index)[32]);
						System.out.println("primaryKeyFacilityId   				::: "+ preApprovalRequestSpecPatientList.get(index)[33]);
						System.out.println("primaryKeyModuleId	   				::: "+ preApprovalRequestSpecPatientList.get(index)[34]);
						System.out.println("primaryKeyMain	       				::: "+ preApprovalRequestSpecPatientList.get(index)[35]);
						System.out.println("primaryKeyLineNo       				::: "+ preApprovalRequestSpecPatientList.get(index)[36]);
						System.out.println("primaryKeyBillingServiceCode		::: "+ preApprovalRequestSpecPatientList.get(index)[37]);
						System.out.println("primaryKeyBillingServiceItemCode	::: "+ preApprovalRequestSpecPatientList.get(index)[38]);
						System.out.println("approvedQty::			::: "+ preApprovalRequestSpecPatientList.get(index)[39]);
						System.out.println("approvedamt   				::: "+ preApprovalRequestSpecPatientList.get(index)[40]);
						System.out.println("availableServiceQty	   				::: "+ preApprovalRequestSpecPatientList.get(index)[41]);
						System.out.println("encidnew	       				::: "+ preApprovalRequestSpecPatientList.get(index)[42]);
						System.out.println("approvalDurationCapping       				::: "+ preApprovalRequestSpecPatientList.get(index)[43]);
						System.out.println("approvedDurationQty		::: "+ preApprovalRequestSpecPatientList.get(index)[44]);
						System.out.println("mcn	manager ::: "+ preApprovalRequestSpecPatientList.get(index)[45]);
						System.out.println("reqid		::: "+ preApprovalRequestSpecPatientList.get(index)[46]);
						System.out.println("cursrlno ::: "+ preApprovalRequestSpecPatientList.get(index)[47]);
						System.err.println("BillingRecordApprovalRequestManager SPEC UPDATE update_enc_spec_preapp_dtl   SP:::: "+preApprovalRequestSpecPatientList.get(index)[45]);
						System.out.println("update_enc_spec_preapp_dtl 368 befre execute ");
						callableStatement.execute();	
						System.out.println("update_enc_spec_preapp_dtl 371 after execute ");
						str_error_level		=	callableStatement.getString(30);
						str_sysmesage_id	=	callableStatement.getString(31);					
						str_error_text		=	callableStatement.getString(32);

						System.err.println("BEFORE str_error_level in preApprovalRequestSpecPatientList:"+str_error_level);
						System.err.println("BEFORE str_sysmesage_id in preApprovalRequestSpecPatientList:"+str_sysmesage_id);
						System.err.println("BEFORE str_error_text in preApprovalRequestAdditionalPatientList:"+str_error_text);

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

						errAdd = "errAdd"+index;

						errTextAdd = "errTextAdd"+index;
						if(str_error_level!="" || str_error_text!="")
						{
							return_mess.put(errAdd, str_error_level+"-"+str_error_text);
						}

						if(str_sysmesage_id!="")
						{
							if(str_sysmesage_id.contains("|"))
							{
								String msgArr[] = str_sysmesage_id.split("\\|");
								for(int l=0;l<msgArr.length;l++)
								{
									msgAdd = "msgAdd"+index+"-"+l;
									msgArr[l] = rb.getString(msgArr[l]);
									return_mess.put(msgAdd, msgArr[l]);
								}
							}
							else
							{
								msgAdd = "msgAdd"+index;
								str_sysmesage_id = rb.getString(str_sysmesage_id);
								return_mess.put(msgAdd, str_sysmesage_id);
							}
						}
					}// End Of FOR Loop

					if(insertableHeader ) 
					{	
						modified =  preApprovalServiceLevelUpdate(connection , tabdata) ;
					}
				}
				// End of for

				if(extnIntEnable && isHeaderProcReqd.equalsIgnoreCase("Y")){
					//	strEncounterId=strEncounterId.substring(1, strEncounterId.indexOf("@"));
					System.out.println("strEncounterId manager 645 "+strEncounterId);
					System.out.println("claimId manager 645 "+claimId);
					System.out.println("ins_mode manager 645 "+ins_mode);
					if(ins_mode.equalsIgnoreCase("Y") && claimId!=0){
						String Claim_ID=String.valueOf(claimId);
						getClaimIdDtls(facility_id,strPatientId,strEncounterId,user_id,client_ip_address,"U",Claim_ID,"SRPREAUTHREQ",policyTypeCode,policyNumber,custCode,custGroupCode,membershipNo,"S","Send To Insurance");//V231106 -update reqid in insert mode
					}
					if(upd_mode.equalsIgnoreCase("Y") &&  !existReqId.equals("")){
						String[] reqId =existReqId.split("~");
						for(int i=0;i<reqId.length;i++){
							getClaimIdDtls(facility_id,strPatientId,strEncounterId,user_id,client_ip_address,"U",reqId[i],"SRPREAUTHCLA",policyTypeCode,policyNumber,custCode,custGroupCode,membershipNo,"C","Clarification");
						}//update proc call
					}
				
				}
			
				if ((insertableHeader && modified) || recalcFlag ) 
				{
					//V221216	
					System.err.println("enableInsClr manager "+enableInsClr);
					System.err.println("strEpisodeType manager "+strEpisodeType);
					if(enableInsClr && (strEpisodeType.equals("I") || strEpisodeType.equals("D"))){
						boolean status=false;
						System.err.println("insClr manager "+insClr);
						if(insClr.equals("Y")){
							status=insuranceClear(facility_id,strPatientId,strEpisodeType,strEpisodeId,strVisitId);
							System.err.println("insuranceClear sts "+status);
						}
						if(status){
							connection.commit();
						}
					}

					if("Y".equals(recalcCharges)){

						HashMap reclacMap = new HashMap();	
						// Added 2 Additional Params by Rajesh V MMS-SCF-422.1
						reclacMap = recalculation(facility_id,strPatientId,strEpisodeType,strEpisodeId,strVisitId,encIdStrNonServLevel,effectiveToDate,priority);
						if((Boolean)reclacMap.get("status")){
							insertableHeader = true;
						}
						else{
							insertableHeader = false;
							for (Iterator iterator = reclacMap.keySet().iterator(); iterator.hasNext();) {
								String type = (String) iterator.next();
								if(!"status".equals(type)){
									return_mess.put(type, reclacMap.get(type));
								}
							}
						}
						//Added for Adding Request ID
						int reqId = 0;
						if(reclacMap.containsKey("requestId")){
							try{
								reqId = (Integer) reclacMap.get("requestId");
							}
							catch(Exception e){
								reqId = 0;
								System.err.println("The Exception in getting Req Id->"+e);
							}
						}

						return_mess.put("requestId", reqId);
						//Added for Adding Request ID
					}
				}

				if ((insertableHeader && modified ) || recalcFlag )  {     
					strInsertable="true";
					connection.commit();
				} else {
					strInsertable="false";
					connection.rollback(); 
				}
			}// End Of try block
			catch(Exception e)
			{
				insertableHeader=false;
				sys_err.append(" Exception while calling BillingRecordApprovalRequestManager Insert:"+e); 
				System.err.println("Exception in BillingRecordApprovalRequestManager Insert:"+e); 
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					if(callableStatement!=null)
					callableStatement.close();
					if (connection != null)
						ConnectionManager.returnConnection(connection, properties);
				}
				catch(Exception e)
				{
					System.err.println("Exception while closing Resources :::"+e);
				}
			}// end of finally block

			System.err.println("insertableHeader::::"+insertableHeader);
			System.err.println("Modified::::"+modified);
			//			return_mess.put("status",new Boolean(insertableHeader)); 
			return_mess.put("status",strInsertable);
			/*return_mess.put("error",str_error_text);
			return_mess.put("sys_error",sys_err.toString());
			return_mess.put("message",str_sysmesage_id);*/ 
			return return_mess;	
		}
		
		//NMC-JD-CRF-102.2 US002
		private  void getClaimIdDtls(String facilityid, String PatientId, String EncounterId, String userid, String clientipaddress,String mode,String refClaimID, String requestType,String policyTypeCode,String policyNumber,String custCode,String custGroupCode,String membershipNo, String requestSts, String requestStsDesc) {
			CallableStatement callableStatement1=null;
			try
			{
				System.out.println("inside getClaimIdDtls ");
				System.out.println("facilityid "+facilityid+" refClaimID "+refClaimID+" mode "+mode);
				System.out.println("PatientId "+PatientId +" userid "+userid+" requestType "+requestType);
				System.out.println("EncounterId "+EncounterId+" clientip "+clientipaddress);
				System.out.println("policyTypeCode "+policyTypeCode +" membershipNo "+membershipNo);
				System.out.println("custCode "+custCode+" custGroupCode "+custGroupCode);
				System.out.println("requestSts "+requestSts+" requestStsdesc "+requestStsDesc);
				// Procedure for Pre Authorization Header  
				String extIntCall="{call XHPAYER.SET_PAYER_PREAUTH_HEADER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				callableStatement1 = connection.prepareCall(extIntCall);	 
				callableStatement1.setString(1,mode);
				callableStatement1.registerOutParameter(2,java.sql.Types.VARCHAR); 	
				callableStatement1.registerOutParameter(3,java.sql.Types.VARCHAR); 	
				callableStatement1.registerOutParameter(4,java.sql.Types.VARCHAR); 	
				callableStatement1.registerOutParameter(5,java.sql.Types.VARCHAR); 	
				callableStatement1.registerOutParameter(6,java.sql.Types.VARCHAR); 	
				callableStatement1.setString(7,facilityid);
				callableStatement1.setString(9,PatientId);
				callableStatement1.setString(10,EncounterId);
				callableStatement1.setString(11,null);//bill doc type code
				callableStatement1.setString(12,null);//bill doc type num
				
				callableStatement1.setString(8,requestType);
				callableStatement1.setString(13,requestSts);//req sts
				callableStatement1.setString(14,requestStsDesc);//req sts desc
				callableStatement1.setString(15,refClaimID);//P_REF_CLAIM_ID
				callableStatement1.setString(16,policyTypeCode);//P_POLICY_TYPE_CODE
				callableStatement1.setString(17,membershipNo);//P_MEMBERSHIP_NO
				callableStatement1.setString(18,custCode);//P_CUST_CODE
				callableStatement1.setString(19,custGroupCode);//P_CUST_GRP_CODE
				callableStatement1.setString(20,null);//P_REQUEST_FILE_NAME
				callableStatement1.setString(21,null);//P_REQUEST_FILE_PATH
				callableStatement1.setString(22,userid);
				callableStatement1.setString(23,clientipaddress);
				callableStatement1.setString(24,facilityid);
				callableStatement1.setString(25,userid);
				callableStatement1.setString(26,clientipaddress);
				callableStatement1.setString(27,facilityid);

				callableStatement1.execute();

				error_id	=	callableStatement1.getString(2);					
				err_text    =	callableStatement1.getString(3);
				refId 	=   callableStatement1.getString(4);
				refTypeID 	=   callableStatement1.getString(5);
				claimId 	=   callableStatement1.getInt(6);
				System.err.println(" claimId in SET_PAYER_PREAUTH_HEADER:"+claimId);
				System.err.println(" refId in SET_PAYER_PREAUTH_HEADER:"+refId);
				System.err.println(" refTypeID in SET_PAYER_PREAUTH_HEADER:"+refTypeID);
				System.err.println(" err_text in SET_PAYER_PREAUTH_HEADER:"+err_text);
				System.err.println(" error_id in SET_PAYER_PREAUTH_HEADER:"+error_id);

				if(error_id==null) error_id="";
				if(err_text==null) err_text="";
				if(refId==null) refId="";
				if(refTypeID==null) refTypeID="";

				callableStatement1.close();
			}catch (Exception e) {
				e.printStackTrace();
				return_mess.put("claimIdErr", err_text);
			}
		}

		private void insertInsRecApprTrck(HashMap tabdata,ArrayList<String[]> recPreApprList, int index, int seqno) {
		// TODO Auto-generated method stub
			PreparedStatement pstmt =null;
			System.out.println("insertInsRecApprTrck");
			System.out.println("seqno "+seqno);
			System.out.println("claimId "+claimId);
			try
			{
				pstmt = connection.prepareStatement("INSERT INTO BL_INS_REC_APPR_TRK (OPERATING_FACILITY_ID, PATIENT_ID, EPISODE_TYPE, EPISODE_ID, VISIT_ID,"+
					"ACCT_SEQ_NO, PRIORITY, BLNG_SERV_CODE, SERV_EXCL_INCL_CRIT, PATIENT_CLASS,"+
					"SEX, AGE_GROUP_CODE, EPISODE_OR_ENCOUNTER_FLAG, CLINIC_NURSING_IND, CLINIC_NURSING_CODE,"+
					"SPLTY_CODE, EFFECTIVE_FROM, PRIMARY_KEY_FACILITY_ID, PRIMARY_KEY_MODULE_ID, PRIMARY_KEY_MAIN,"+
					"PRIMARY_KEY_LINE_NO, PRIMARY_KEY_SERV_ITEM_CODE, PRIMARY_KEY_BLNG_SERV_CODE, CUST_GROUP_CODE, CUST_CODE,"+
					"POLICY_TYPE_CODE,EFFECTIVE_TO,ENCOUNTER_ID,UPLOAD_STATUS,PRE_APP_STATUS,added_by_id,"+
					" added_date,  added_at_ws_no,added_facility_id,modified_by_id, modified_date, modified_at_ws_no,modified_facility_id,REQUESTID,ITEM_SEQNO)"+
					" VALUES (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?, ?, ?, ?, ?, ?,?,?,?, to_date(?,'dd/mm/yyyy'), ?,?,?,?, SYSDATE, ?, ?,?,SYSDATE,?,?,?,? )");
				
				String strEpisodeId =  (String)tabdata.get("episodeId");
				String strVisitId	=  (String)tabdata.get("visitId");
				String accountSeqNo= (String)tabdata.get("accountSeqNo");
				String priority= (String) tabdata.get("priority");
				String encounterId= (String)tabdata.get("encounterId");
				encounterId=encounterId.substring(1, encounterId.indexOf("@"));
				System.out.println("strEpisodeId "+strEpisodeId);
				System.out.println("strVisitId "+strVisitId);
				System.out.println("accountSeqNo "+accountSeqNo);
				System.out.println("priority "+priority);
				System.out.println("encounterId "+encounterId);
				
				System.out.println("facility "+(String) tabdata.get("FACILITY_ID"));
				System.out.println("patId "+(String) tabdata.get("patientId"));
				System.out.println("episodeType "+(String)tabdata.get("episodeType"));
				System.out.println("11 "+recPreApprList.get(index)[11]);
				System.out.println("12 "+recPreApprList.get(index)[12]);
				System.out.println("21 "+recPreApprList.get(index)[21]);
				System.out.println("26 "+recPreApprList.get(index)[26]);
				System.out.println("27 "+recPreApprList.get(index)[27]);
				System.out.println("22 "+recPreApprList.get(index)[22]);
				System.out.println("23 "+recPreApprList.get(index)[23]);
				System.out.println("24 "+recPreApprList.get(index)[24]);
				System.out.println("25 "+recPreApprList.get(index)[25]);
				System.out.println("18 "+recPreApprList.get(index)[18]);
				System.out.println("33 "+recPreApprList.get(index)[33]);
				System.out.println("34 "+recPreApprList.get(index)[34]);
				System.out.println("35 "+recPreApprList.get(index)[35]);
				System.out.println("36 "+recPreApprList.get(index)[36]);
			
				System.out.println("37 "+recPreApprList.get(index)[37]);
				System.out.println("38 "+recPreApprList.get(index)[38]);
				System.out.println("custgrpcode "+(String) tabdata.get("custGroupCode"));
				System.out.println("custcode "+(String) tabdata.get("custCode"));
				System.out.println("policy "+(String) tabdata.get("policyTypeCode"));
				System.out.println("effto "+(String) tabdata.get("effectiveToDate"));
				System.out.println("user_id "+user_id);
			
				pstmt.setString(1,(String) tabdata.get("FACILITY_ID"));
				pstmt.setString(2,(String) tabdata.get("patientId"));
				pstmt.setString(3,(String)tabdata.get("episodeType"));
				pstmt.setString(4,strEpisodeId);
				pstmt.setString(5,strVisitId);
				pstmt.setString(6,accountSeqNo);
				pstmt.setString(7,priority);
				pstmt.setString(8,recPreApprList.get(index)[11]);
				pstmt.setString(9,recPreApprList.get(index)[12]);
				pstmt.setString(10,recPreApprList.get(index)[21]);
				pstmt.setString(11,recPreApprList.get(index)[26]);
				pstmt.setString(12,recPreApprList.get(index)[27]);
				pstmt.setString(13,recPreApprList.get(index)[22]);
				
				pstmt.setString(14,recPreApprList.get(index)[23]);
				pstmt.setString(15,recPreApprList.get(index)[24]);
				pstmt.setString(16,recPreApprList.get(index)[25]);
				pstmt.setString(17,recPreApprList.get(index)[18]);
				pstmt.setString(18,recPreApprList.get(index)[33]);
				pstmt.setString(19,recPreApprList.get(index)[34]);
				pstmt.setString(20,recPreApprList.get(index)[35]);
				pstmt.setString(21,recPreApprList.get(index)[36]);
				
				pstmt.setString(22,recPreApprList.get(index)[37]);
				pstmt.setString(23,recPreApprList.get(index)[38]);
				pstmt.setString(24,(String) tabdata.get("custGroupCode"));
				pstmt.setString(25,(String) tabdata.get("custCode"));
				pstmt.setString(26,(String) tabdata.get("policyTypeCode"));
				pstmt.setString(27,(String) tabdata.get("effectiveToDate"));
				pstmt.setString(28,encounterId);
				pstmt.setString(29,"N");
				pstmt.setString(30,"S");
				pstmt.setString(31,user_id);
				pstmt.setString(32,client_ip_address);
				pstmt.setString(33,(String) tabdata.get("FACILITY_ID"));
				pstmt.setString(34,user_id);
				pstmt.setString(35,client_ip_address);
				pstmt.setString(36,(String) tabdata.get("FACILITY_ID"));
				pstmt.setInt(37,claimId); 
				pstmt.setInt(38,seqno);
				System.out.println("before execute insertInsRecApprTrck");
				pstmt.execute();
				System.out.println("after execute insertInsRecApprTrck ");
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(pstmt!=null){
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}//NMC-JD-CRF-0102.2
		
		/* Karthik Record approval   -  MMS-QH-CRF-0165 - Starts */
		private boolean updateEffectiveToDate(Connection con,String expiryDate,String patientId,String facilityId,String acctSeqNo,String plcyTypeCode,String plcyNumber,String custCode,String custGrpCode,String effectiveToDate) {
			System.out.println("updateEffectiveToDate(): "+expiryDate +":"+patientId +":"+ facilityId +":"+ acctSeqNo+":"+ plcyTypeCode+":"+ plcyNumber+":"+ custCode+":"+ custGrpCode+":"+effectiveToDate );
			HashMap returnMap = new HashMap();
			boolean insertable = true;
			String effToDate="";
			String r_days="";
			try
			{
				String effToDateQuery="select to_char(effective_to,'dd/mm/yyyy'),((TO_DATE (?, 'dd/mm/yyyy') - effective_from)+1) remain_days  from bl_encounter_payer_priority "+
						" WHERE patient_id = ? "+
					 " AND operating_facility_id = ? "+
					 " AND acct_seq_no = ? "+
					 " AND policy_type_code = ? "+
					 " AND policy_number = ? "+
					 " AND cust_code = ? "+
					 " AND cust_group_code = ?  ";
				
				PreparedStatement pst1 = con.prepareStatement(effToDateQuery);
				ResultSet rst1=null;				
				pst1.setString(1, effectiveToDate);
				pst1.setString(2, patientId);
				pst1.setString(3, facilityId);
				pst1.setString(4, acctSeqNo);
				pst1.setString(5, plcyTypeCode);
				pst1.setString(6, plcyNumber);
				pst1.setString(7, custCode);
				pst1.setString(8, custGrpCode);
				rst1=pst1.executeQuery();
				
				while(rst1.next()) {
					effToDate=rst1.getString(1);
					r_days=rst1.getString(2);
				}
				
				if(effToDate.equals(effectiveToDate))  insertable= false;				
			
				if(insertable)
				{
					String expiryDateQuery = " UPDATE bl_encounter_payer_priority "+
						 " SET EFFECTIVE_TO = TO_DATE (?, 'dd/mm/yyyy')   "+
						 " WHERE patient_id = ? "+
						 " AND operating_facility_id = ? "+
						 " AND acct_seq_no = ? "+
						 " AND policy_type_code = ? "+
						 " AND policy_number = ? "+
						 " AND cust_code = ? "+
						 " AND cust_group_code = ?  ";
				
					PreparedStatement pst = con.prepareStatement(expiryDateQuery);
					pst.setString(1, effectiveToDate); //pst.setString(1, expiryDate);
					pst.setString(2, patientId);
					pst.setString(3, facilityId);
					pst.setString(4, acctSeqNo);
					pst.setString(5, plcyTypeCode);
					pst.setString(6, plcyNumber);
					pst.setString(7, custCode);
					pst.setString(8, custGrpCode);
					pst.executeUpdate();
					insertable = true;
				}
				if(insertable)
				{					
					String expiryDateQuery = " UPDATE bl_encounter_payer_priority "+
						 " SET approved_days = ? "+
						 " WHERE patient_id = ? "+
						 " AND operating_facility_id = ? "+
						 " AND acct_seq_no = ? "+
						 " AND policy_type_code = ? "+
						 " AND policy_number = ? "+
						 " AND cust_code = ? "+
						 " AND cust_group_code = ?  "+
						"  AND  approved_days is not null ";
				
					PreparedStatement pst = con.prepareStatement(expiryDateQuery);
					pst.setString(1, r_days); //pst.setString(1, expiryDate);
					pst.setString(2, patientId);
					pst.setString(3, facilityId);
					pst.setString(4, acctSeqNo);
					pst.setString(5, plcyTypeCode);
					pst.setString(6, plcyNumber);
					pst.setString(7, custCode);
					pst.setString(8, custGrpCode);
					pst.executeUpdate();
					insertable = true;
				}
			}
			catch(Exception e){
				System.err.println("Exception is "+e);
				e.printStackTrace();
				// pradeepa - CRF 0165 - Record approval
				returnMap.put("internalError", "Internal Error");
				insertable = false;
			}
			finally{
				return insertable;
			}
		}
		/* Karthik  Record approval   -  MMS-QH-CRF-0165 - ends */
		// Added 2 Additional Params by Rajesh V MMS-SCF-422.1
		private HashMap recalculation(String facility_id, String patientId,String episodeType, 
				String episodeId, String visitId,String encounterIdMod,String effectiveToDate,String priority) {
			HashMap returnMap = new HashMap();
			boolean insertable = false;
			int reqId = 0;
			System.out.println("encounter id in recalc "+encounterIdMod);
			try
			{
				String str_error_level = "", str_sysmesage_id = "", str_error_text="";
				//String reclac = "{ call   bl_recalc_process.proc_recalculation (?,?,?,?,?,?,?,?,?,?) }";
				//Added V180714-Aravindh/MMS-Recalculation/if-else condition
				String reclac = "";
				if(reCalcUsingTempTbl) {
					reclac = "{ call   bl_recalc_process.proc_recalc_rec_aproval (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
				} else {
					reclac = "{ call   bl_recalc_process.proc_recalc (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
				}
				System.out.println("Starting Recalculation");
				CallableStatement cstmt = connection.prepareCall(reclac);

				cstmt.setString(1, facility_id);
				cstmt.setString(2,patientId);
				cstmt.setString(3, episodeType);
				cstmt.setString(4, episodeId);
				cstmt.setString(5, visitId);
				cstmt.setString(6, client_ip_address);
				cstmt.setString(7, user_id);
				//Added V180714-Aravindh/MMS-Recalculation/if-else condition
				if(reCalcUsingTempTbl) {
					cstmt.setString(8, "EBL_TRANS_INS_RECORD_APPROVAL");
				} else {
					cstmt.setString(8, "RECORD_APPROVAL");
				}
				cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(12, java.sql.Types.INTEGER);
				cstmt.setString(13, encounterIdMod);
				// Added Below by Rajesh V MMS-SCF-422.1
				cstmt.setString(14, priority);
				if(getDateInLong(effectiveToDate)==0)
					cstmt.setString(15,null);
				else
					cstmt.setDate(15,new Date(getDateInLong(effectiveToDate)));
				
				if(reCalcUsingTempTbl) {
					cstmt.setString(16,pSessionId);
					cstmt.setString(17,pgmDate);
				}

				
				cstmt.execute();
				str_error_level = cstmt.getString(10);
				str_sysmesage_id = cstmt.getString(9);
				str_error_text = cstmt.getString(11);
				reqId = cstmt.getInt(12);
				
				

				System.err.println("str_error_level-"+str_error_level+"str_sysmesage_id-"+str_sysmesage_id+
						"str_error_text-"+str_error_text);
				if(str_error_level!=null || str_error_text!=null){
					returnMap.put("recalcHdr", str_error_level+"-"+str_error_text);
				}

				if(str_sysmesage_id!=null){
					String msgAdd = "";
					if(str_sysmesage_id.contains("|")){
						String msgArr[] = str_sysmesage_id.split("\\|");
						for(int l=0;l<msgArr.length;l++){
							msgAdd = "recalcMsg"+"-"+l;

							/*try{
								msgArr[l] = rb.getString(msgArr[l]);
							}
							catch(Exception rbException){
								System.err.println("Exceprion in RB ->"+rbException);
							}*/
							returnMap.put(msgAdd, msgArr[l]);
						}
					}else{
						msgAdd = "recalcMsg";

						/*try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							System.err.println("Exceprion in RB ->"+rbException);
						}*/
						returnMap.put(msgAdd, str_sysmesage_id);
					}
				}


				if (!returnMap.isEmpty()) {
					insertable = false;
				} else {
					insertable = true;
				}

				returnMap.put("requestId", reqId);
				cstmt.close();

			}
			catch(Exception e){
				System.err.println("Exception is "+e);
				returnMap.put("internalError", "Internal Error");
				insertable = false;
			}
			finally{
				returnMap.put("status", new Boolean(insertable));
				return returnMap;
			}
		}	
	//V221216	
		
		private boolean insuranceClear(String facility_id, String patientId,String episodeType, 
				String episodeId, String visitId) {
			Boolean insenableInsClr=false;
			try{
				CallableStatement cstmt = connection.prepareCall("{ call blinstransactions.generate_ins_clearance(?,?,?,?,?,?,?,?) }");
				
				cstmt.setString(1, facility_id);
				cstmt.setString(2, episodeType);
				cstmt.setString(3,patientId);
				cstmt.setString(4, episodeId);
				cstmt.setString(5, visitId);
				cstmt.setString(6, user_id);
				cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
				cstmt.execute();
						
				String TransacSts = cstmt.getString(7);
				String message = cstmt.getString(8);	
				
				if(null != message && !"".equals(message)){
					System.err.println("message:::"+message);
					//out.println(message);
					insenableInsClr= false;
				}else{
					System.err.println("TransacSts:::"+TransacSts);
					insenableInsClr= true;
				}
				
			}catch(Exception Ex){
				System.err.println("exception in insurance clearance "+Ex);
			}
			return insenableInsClr;
		}
		
		/* 
		 * Adding changes for SMS Inclusion in Record Approval - Starts Added by Karthikeyan on 28/7/2016 MMS-DM-SCF-INT-0003
		 * 
		 * In Method smsMessageGlobalVarInitialize Exception is handled. Error will be Printed in Error logs .
		 * But the Transaction flow will not be stopped in case of any error in SMS functions.
		 * 
		 */
		private void smsMessageGlobalVarInitialize() {
			System.out.println("{ call XHREMAINDER.GLOBALVARINITIALIZE() }");
			try{

				String smsMessageProc= "{ call XHREMAINDER.GLOBALVARINITIALIZE() }";			
				CallableStatement cstmt = connection.prepareCall(smsMessageProc);
				cstmt.execute();				
				cstmt.close();

			}
			catch(Exception e){
				e.printStackTrace();
				System.err.println("Exception in smsMessageGlobalVarInitialize() while calling XHREMAINDER.GLOBALVARINITIALIZE(). Exception is "+e);
			}
		}
		
		/*		 MMS-DM-SCF-INT-0003
		 * In Method smsMessageAppserevantGenerator Exception is handled. Error will be Printed in Error logs .
		 * But the Transaction flow will not be stopped in case of any error in SMS functions.
		 * The Hashmap Returned which is not used as of now , can be used for SMS failure identification in future.
		 */
		private HashMap smsMessageAppserevantGenerator(String facility_id, String patientId, String encounterId, String episodeType, String episodeId, String visitId, String primaryKeyMain,String primaryKeyLineNo, String preAppNum, String preAppStatus, String custCode) {
			
			System.out.println("{ call XHREMAINDER.XSBLINAPPSEREVENTGENERATOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			System.out.println(facility_id+"|"+patientId+"|"+ encounterId+"|"+ episodeType+"|"+ episodeId+"|"+ visitId+"|"+ primaryKeyMain+"|"+primaryKeyLineNo+"|"+ preAppNum+"|"+ preAppStatus+"|"+ custCode );
			HashMap returnMap = new HashMap();
			boolean insertable = false;
			//commented by Vijay For MMS-MD-SCF-0046
			//int reqId = 0;
			try{
				String str_error_level = "", str_sysmesage_id = "", str_error_text="";
				String smsMessageProc= "{ call XHREMAINDER.XSBLINAPPSEREVENTGENERATOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";			
				CallableStatement cstmt = connection.prepareCall(smsMessageProc);
				cstmt.setString(1, facility_id);
				cstmt.setString(2,patientId);
				cstmt.setString(3, encounterId);
				cstmt.setString(4, episodeType);
				cstmt.setString(5, episodeId);
				cstmt.setString(6, visitId);
				cstmt.setString(7, primaryKeyMain);
				cstmt.setString(8, primaryKeyLineNo);
				cstmt.setString(9, preAppNum);
				cstmt.setString(10, preAppStatus);
				cstmt.setString(11, custCode);				
				cstmt.setString(12, user_id);
				cstmt.setString(13, client_ip_address);
				cstmt.setString(14, facility_id);
				cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(16, java.sql.Types.VARCHAR);
				
				
				cstmt.execute();
				str_sysmesage_id = cstmt.getString(15);
				str_error_text = cstmt.getString(16);
				//commented by Vijay For MMS-MD-SCF-0046
				//reqId = cstmt.getInt(12);
				
				

				System.err.println("str_error_level-"+str_error_level+"str_sysmesage_id-"+str_sysmesage_id+
						"str_error_text-"+str_error_text);
				if(str_sysmesage_id!=null || str_error_text!=null){
					returnMap.put("smsMessage", str_sysmesage_id+"-"+str_error_text);
				}

				if(str_sysmesage_id!=null){
					String msgAdd = "";
					if(str_sysmesage_id.contains("|")){
						String msgArr[] = str_sysmesage_id.split("\\|");
						for(int l=0;l<msgArr.length;l++){
							msgAdd = "smsMessage"+"-"+l;
							returnMap.put(msgAdd, msgArr[l]);
						}
					}else{
						msgAdd = "smsMessage";
						returnMap.put(msgAdd, str_sysmesage_id);
					}
				}


				if (!returnMap.isEmpty()) {
					insertable = false;
				} else {
					insertable = true;
				}
				cstmt.close();

			}
			catch(Exception e){
				System.err.println("Exception is "+e);
				returnMap.put("internalError", "Internal Error while Sending SMS");
				insertable = false;
			}
			finally{
				returnMap.put("status", new Boolean(insertable));
				return returnMap;
			}
		}

		/* Adding changes for SMS Inclusion in Record Approval - Ends  */	
		/**
		 * @param connection
		 * @param tabdata
		 * @return
		 */
		public boolean preApprovalServiceLevelUpdate(Connection connection,java.util.HashMap tabdata) //throws Exception
		{
			System.out.println("IN BillingRecordApprovalRequestManager preApprovalServiceLevelUpdate----");
			System.out.println("tabdata manager 974 "+tabdata);
			preApprovalRequestServiceLevelPatientList			=	new ArrayList();
			String str_error_level						=	"";
			String str_error_text						=	"";
			String str_sysmesage_id						=	"";
			String locale 								= 	"";
			String errAdd								=	"";
			String msgAdd								=	"";
			String errTextAdd							=	"";
			SimpleDateFormat dateFormat 				=	new SimpleDateFormat("yyyy/mm/dd"); 
			java.sql.Date date 							=   null;

			//Vijay for MMS-MD-SCf-0046
			String strPatientId =  (String) tabdata.get("patientId");				 
			String strEpisodeType= (String)tabdata.get("episodeType");
		    String strEpisodeId =  (String)tabdata.get("episodeId");
			String strVisitId	=  (String)tabdata.get("visitId");
			String strEncounterId = (String)tabdata.get("encounterId");
			String custCode=(String)tabdata.get("custCode");

			if(locale==null) locale="en";
			
			String facility_id 							= 	(String) tabdata.get("FACILITY_ID");
			if(facility_id==null) facility_id=""; 
			
			client_ip_address							=	(String)tabdata.get("client_ip_address");
			if(client_ip_address==null)	client_ip_address="";
			
			user_id										=	(String)tabdata.get("login_user");
			if(user_id==null) 	user_id="";

			locale										=	(String)tabdata.get("locale");
			if(locale==null) locale="en";
			//mode
			tab											=	(String)tabdata.get("tab"); 
			Locale loc = new Locale(locale);
			ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		//	preApprovalRequestServiceLevelPatientList				=	(ArrayList)tabdata.get("preApprovalRequestServiceLevelPatientList"); 
			preApprovalRequestServiceLevelPatientList				=	(ArrayList)tabdata.get("preApprovalRequestSpecPatientList"); 
			System.out.println("BillingRecordApprovalRequestmanager   preApprovalRequestServiceLevelPatientList  "+preApprovalRequestServiceLevelPatientList);
				
			CallableStatement callableStatement=null;
			try 
			{
				modified = true;
				
				/* Added V180714-Aravindh/MMS-Recalculation/if-else condition */
				String sqlpreApprovalRequestModify = "";
				if(reCalcUsingTempTbl) {
					System.out.println(" manager 1077 ");
					sqlpreApprovalRequestModify="{ call   IBAEHIS.blinstransactions.upd_enc_preapp_serv_level_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //added 1 param V220919
				} else {
					System.out.println("inside reCalcUsingTempTbl else condn 1079 ");
					sqlpreApprovalRequestModify="{ call   IBAEHIS.blinstransactions.upd_enc_preapp_serv_level_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //added 1 param V220919
				} //added 2 params in each for 102.2 reqid,cursrlno 
				int count=0;
				for(int index=0;index<preApprovalRequestServiceLevelPatientList.size();index++)
				{
					if(extnIntEnable){
						String status=preApprovalRequestServiceLevelPatientList.get(index)[16];
						String mode="";
						if(status.equalsIgnoreCase("S") || status.equalsIgnoreCase("C")){
							if(preApprovalRequestServiceLevelPatientList.get(index)[46].equals("") && status.equalsIgnoreCase("S")){
								count++;
							}else if(!preApprovalRequestServiceLevelPatientList.get(index)[46].equals("") && status.equalsIgnoreCase("C")){
								count=Integer.parseInt(preApprovalRequestServiceLevelPatientList.get(index)[48]);
							}
							if(status.equalsIgnoreCase("c")){
								mode="U";
							}else if(status.equalsIgnoreCase("S")){
								mode="I";
								insertInsRecApprTrck(tabdata,preApprovalRequestServiceLevelPatientList,index,count);//102.2
							}
							System.out.println("preApprovalRequestServiceLevelPatientList.get(index)[19] "+preApprovalRequestServiceLevelPatientList.get(index)[19]);
							System.out.println("preApprovalRequestServiceLevelPatientList.get(index)[41] "+preApprovalRequestServiceLevelPatientList.get(index)[41]);
							
							System.out.println("setservlvldtls manager 1261");
						}
					}//V231010 - NMC-JD-CRF-0102.2 -
					
					//Vijay for MMS-MD-SCF-0046
					smsMessageAppserevantGenerator(facility_id,strPatientId,preApprovalRequestServiceLevelPatientList.get(index)[42],strEpisodeType,strEpisodeId,strVisitId,preApprovalRequestServiceLevelPatientList.get(index)[35],preApprovalRequestServiceLevelPatientList.get(index)[36],preApprovalRequestServiceLevelPatientList.get(index)[13],preApprovalRequestServiceLevelPatientList.get(index)[16],custCode);
					
					callableStatement = connection.prepareCall(sqlpreApprovalRequestModify);	 
					System.out.println(" index   BillingRecordApprovalRequestmanager 1089");
					callableStatement.setString(1,facility_id);
					callableStatement.setString(2,preApprovalRequestServiceLevelPatientList.get(index)[0]);
					System.out.println(" index   BillingRecordApprovalRequestmanager 1092");
					callableStatement.setString(3,preApprovalRequestServiceLevelPatientList.get(index)[1]);
					callableStatement.setString(4,preApprovalRequestServiceLevelPatientList.get(index)[2]);       
					callableStatement.setString(5,preApprovalRequestServiceLevelPatientList.get(index)[3]); 
					callableStatement.setString(6,preApprovalRequestServiceLevelPatientList.get(index)[42]);   
					callableStatement.setString(7,preApprovalRequestServiceLevelPatientList.get(index)[8]); 
					callableStatement.setString(8,preApprovalRequestServiceLevelPatientList.get(index)[9]);
					callableStatement.setString(9,preApprovalRequestServiceLevelPatientList.get(index)[6]);	      
					callableStatement.setString(10,preApprovalRequestServiceLevelPatientList.get(index)[5]);
					System.err.println(" index   BillingRecordApprovalRequestmanager 3");
					callableStatement.setString(11,preApprovalRequestServiceLevelPatientList.get(index)[7]);	        
					callableStatement.setString(12,preApprovalRequestServiceLevelPatientList.get(index)[11]);	     
					callableStatement.setString(13,preApprovalRequestServiceLevelPatientList.get(index)[12]);
					callableStatement.setString(14,preApprovalRequestServiceLevelPatientList.get(index)[21]);
					callableStatement.setString(15,preApprovalRequestServiceLevelPatientList.get(index)[22]);
					callableStatement.setString(16,preApprovalRequestServiceLevelPatientList.get(index)[23]);       
					callableStatement.setString(17,preApprovalRequestServiceLevelPatientList.get(index)[24]);  
					callableStatement.setString(18,preApprovalRequestServiceLevelPatientList.get(index)[25]);   
					System.err.println(" index   BillingRecordApprovalRequestmanager   4");
					callableStatement.setString(19,preApprovalRequestServiceLevelPatientList.get(index)[32]);
					callableStatement.setString(20,preApprovalRequestServiceLevelPatientList.get(index)[29]);
					callableStatement.setString(21,preApprovalRequestServiceLevelPatientList.get(index)[30]);	
					System.out.println("BillingRecordApprovalRequestManager preApprovalServiceLevelUpdate UPDATE preApprovalRequestServiceLevelPatientList.get(index)[18]:::: "+preApprovalRequestServiceLevelPatientList.get(index)[18]);
					callableStatement.setDate(22,new Date(getDateInLong(preApprovalRequestServiceLevelPatientList.get(index)[18])));	  
					System.err.println("BillingRecordApprovalRequestManager preApprovalServiceLevelUpdate UPDATE preApprovalRequestServiceLevelPatientList.get(index)[28]:::: "+preApprovalRequestServiceLevelPatientList.get(index)[28]);

					if(getDateInLong(preApprovalRequestServiceLevelPatientList.get(index)[28])==0)
					{
						callableStatement.setString(23,null);
						System.err.println("Assign Null to Effective Todate");
					}
					else
					{
						callableStatement.setDate(23,new Date(getDateInLong(preApprovalRequestServiceLevelPatientList.get(index)[28])));
					}
					
					System.err.println("BillingREcordApprovalRequestManger   efectiveTodate###### "+new Date(getDateInLong(preApprovalRequestServiceLevelPatientList.get(index)[28])));
					
					callableStatement.setString(24,preApprovalRequestServiceLevelPatientList.get(index)[31]);       	
					callableStatement.setString(25,user_id);       	
					callableStatement.setString(26,client_ip_address);       	
					callableStatement.setString(27,facility_id); 	
					callableStatement.setString(28,preApprovalRequestServiceLevelPatientList.get(index)[26]); 	
					callableStatement.setString(29,preApprovalRequestServiceLevelPatientList.get(index)[27]);       	
					callableStatement.setString(30,preApprovalRequestServiceLevelPatientList.get(index)[13]); 	
					
					if(getDateInLong(preApprovalRequestServiceLevelPatientList.get(index)[14])==0)
						callableStatement.setString(31,null);
					else
						callableStatement.setDate(31,new Date(getDateInLong(preApprovalRequestServiceLevelPatientList.get(index)[14])));
							
					if(getDateInLong(preApprovalRequestServiceLevelPatientList.get(index)[15])==0)
						callableStatement.setString(32,null);
					else	
						callableStatement.setDate(32,new Date(getDateInLong(preApprovalRequestServiceLevelPatientList.get(index)[15])));
					
					callableStatement.setString(33,preApprovalRequestServiceLevelPatientList.get(index)[16]); 	
					callableStatement.setString(34,preApprovalRequestServiceLevelPatientList.get(index)[17]); 	
					callableStatement.setString(35,preApprovalRequestServiceLevelPatientList.get(index)[33]); 	
					callableStatement.setString(36,preApprovalRequestServiceLevelPatientList.get(index)[34]); 	
					callableStatement.setString(37,preApprovalRequestServiceLevelPatientList.get(index)[35]); 	
					callableStatement.setString(38,preApprovalRequestServiceLevelPatientList.get(index)[36]); 	 
					callableStatement.setString(39,preApprovalRequestServiceLevelPatientList.get(index)[37]); 	
					callableStatement.setString(40,preApprovalRequestServiceLevelPatientList.get(index)[38]); 	
					callableStatement.setString(41,preApprovalRequestServiceLevelPatientList.get(index)[20]); 
					callableStatement.setString(42,preApprovalRequestServiceLevelPatientList.get(index)[39]);
					callableStatement.setString(43,preApprovalRequestServiceLevelPatientList.get(index)[40]);
					callableStatement.setString(44,preApprovalRequestServiceLevelPatientList.get(index)[19]);  //available_service_amount
					callableStatement.setString(45,preApprovalRequestServiceLevelPatientList.get(index)[41]);  //available_service_qty					
					
					callableStatement.registerOutParameter(46,java.sql.Types.VARCHAR); 	
					callableStatement.registerOutParameter(47,java.sql.Types.VARCHAR); 	
					callableStatement.registerOutParameter(48,java.sql.Types.VARCHAR);
					callableStatement.setString(49,preApprovalRequestServiceLevelPatientList.get(index)[43]);
					callableStatement.setString(50,preApprovalRequestServiceLevelPatientList.get(index)[44]);
					
					/* Added V180714-Aravindh/MMS-Recalculation/Starts */
					if(reCalcUsingTempTbl) {
						callableStatement.setString(51,"EBL_TRANS_INS_RECORD_APPROVAL");
						callableStatement.setString(52,pSessionId);
						callableStatement.setString(53,pgmDate);
						//V220919
						if(enableMCNNumber){
							System.out.println("inside enableMCNNumber condn ");
							callableStatement.setString(54,preApprovalRequestServiceLevelPatientList.get(index)[45]);
						}else{
							callableStatement.setString(54,null);
						}
						//V220919
						//NMC-JD-CRF-102.2
						System.out.println("inside extnIntEnable condn ");
						System.out.println("extnIntEnable 1618 "+extnIntEnable+" claimId "+claimId+" count"+count);

						System.out.println("inside extnIntEnable if condn 46 "+preApprovalRequestServiceLevelPatientList.get(index)[46]);
						System.out.println("inside extnIntEnable if condn 47 "+preApprovalRequestServiceLevelPatientList.get(index)[47]);
						System.out.println("inside extnIntEnable if condn 48 "+preApprovalRequestServiceLevelPatientList.get(index)[48]);
						
						if(preApprovalRequestServiceLevelPatientList.get(index)[46].equals("") && preApprovalRequestServiceLevelPatientList.get(index)[47].equals(""))
						{
								callableStatement.setInt(55,claimId);
								callableStatement.setInt(56,count);
								callableStatement.setInt(57,count);
						}else{
							callableStatement.setString(55,preApprovalRequestServiceLevelPatientList.get(index)[46]);
							callableStatement.setString(56,preApprovalRequestServiceLevelPatientList.get(index)[47]);
							callableStatement.setString(57,preApprovalRequestServiceLevelPatientList.get(index)[48]);
						}
					}else{
						//V220919
						System.out.println("inside else condn 1094");
						if(enableMCNNumber){
							callableStatement.setString(51,preApprovalRequestServiceLevelPatientList.get(index)[45]);
						}else{
							callableStatement.setString(51,null);
						}//V220919
						//NMC-JD-CRF-102.2
						System.out.println("inside extnIntEnable condn 46 "+preApprovalRequestServiceLevelPatientList.get(index)[46]);
						System.out.println("inside extnIntEnable condn 47 "+preApprovalRequestServiceLevelPatientList.get(index)[47]);

						if(preApprovalRequestServiceLevelPatientList.get(index)[46].equals("") && preApprovalRequestServiceLevelPatientList.get(index)[47].equals(""))
						{
								callableStatement.setInt(52,claimId);
								callableStatement.setInt(53,count);
								callableStatement.setInt(54,count);
						}else{
							callableStatement.setString(52,preApprovalRequestServiceLevelPatientList.get(index)[46]);
							callableStatement.setString(53,preApprovalRequestServiceLevelPatientList.get(index)[47]);
							callableStatement.setString(54,preApprovalRequestServiceLevelPatientList.get(index)[48]);
						}
					}
					/* Added V180714-Aravindh/MMS-Recalculation/Ends */
					System.out.println("1102 bef exec");
					callableStatement.execute();	
					System.out.println("1104 after exec");
					str_error_level		=	callableStatement.getString(46);
					str_sysmesage_id	=	callableStatement.getString(47);					
					str_error_text		=	callableStatement.getString(48);
					
					System.err.println("BEFORE str_error_level in BillingRecordApprovalRequestManager preApprovalServiceLevelUpdate:"+str_error_level);
					System.err.println("BEFORE str_sysmesage_id in BillingRecordApprovalRequestManager preApprovalServiceLevelUpdate:"+str_sysmesage_id);
					System.err.println("BEFORE str_error_text in BillingRecordApprovalRequestManager preApprovalServiceLevelUpdate:"+str_error_text);
					
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";					

					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						modified=false;
					}
					else
					{
						modified = true;						
					} 

					errAdd = "errAdd"+index;
						
					errTextAdd = "errTextAdd"+index;
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
								msgAdd = "msgAdd"+index+"-"+l;
								msgArr[l] = rb.getString(msgArr[l]);
								return_mess.put(msgAdd, msgArr[l]);
							}
						}
						else
						{
							msgAdd = "msgAdd"+index;
							str_sysmesage_id = rb.getString(str_sysmesage_id);
							return_mess.put(msgAdd, str_sysmesage_id);
						}
					}
				}// END of FOR loop
			}// End Of try block
			catch(Exception e)
			{
				modified=false;
				sys_err.append(" Exception while calling BillingRecordApprovalRequestManager preApprovalServiceLevelUpdate:"+e); 
				System.out.println("Exception in BillingRecordApprovalRequestManager preApprovalServiceLevelUpdate:"+e); 
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					if(callableStatement!=null)
						callableStatement.close();
				}
				catch(Exception e)
				{
					System.out.println("Exception while closing Resources :::"+e);
				}
			}// end of finally block
			
			System.err.println("Modified::::"+modified);
			//System.out.println("modifyInsertable::::"+modifyInsertable);
			return_mess.put("status",new Boolean(modified)); 
			return_mess.put("error",str_error_text);
			return_mess.put("sys_error",sys_err.toString());
			return_mess.put("message",str_sysmesage_id);	 
			return modified;	
		}
	/*
	* This method takes input in DD/MM/YYYY format and provides appropriate 
	* long value
	*/ 
	private long getDateInLong(String dateString){
		System.out.println("dateString in getDateInLong ::: "+dateString);
		if(dateString==null || dateString.length()==0){ 
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
