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
2			 V220718			31506		 MMS-MD-SCF-0210			Manivel Natarajan
-----------------------------------------------------------------------------------
*/

package eBL.PkgSubscription;

import java.sql.*;

import javax.naming.*;
import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import eBL.PkgAssociationExistingPackagesBean;
import java.io.* ;
import java.net.InetAddress;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="PkgSubscription"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PkgSubscription"
*	local-jndi-name="PkgSubscription"
*	impl-class-name="eBL.PkgSubscription.PkgSubscriptionManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eBL.PkgSubscription.PkgSubscriptionLocal"
*	remote-class="eBL.PkgSubscription.PkgSubscriptionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.PkgSubscription.PkgSubscriptionLocalHome"
*	remote-class="eBL.PkgSubscription.PkgSubscriptionHome"
*	generate= "local,remote"
*
*
*/


public class PkgSubscriptionManager implements SessionBean
{
	Connection con;

	CallableStatement cstmt = null;

	SessionContext ctx;

	boolean insertable = false;

	String locale = "";

	//String encounterid = "";
	String blng_class_code = "";
	String blng_class_desc = "";
	String blng_grp_code = ""; //Added By Shikha For GHL-CRF-0520.1
	String blng_grp_desc = ""; //Added By Shikha For GHL-CRF-0520.1
	String payerGrpCode = "";
	String payerGrpDesc = "";
	String payerCode = "";
	String payerDesc = "";
	String newvariablefortesting = "Test" ;
			

	String errCode = "", sysMessgaeId="", errText="", gen_doc_type="",gen_doc_num="";
	StringBuffer sys_err = new StringBuffer("") ;

	
	String currdate="",client_ip_address="",user_id="",str_error_level="",str_error_text="",str_sysmesage_id="";

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

	public java.util.HashMap insert(java.util.Properties p,java.util.HashMap tabdata) 
	{		
		con = ConnectionManager.getConnection(p);
		HashMap return_mess = new HashMap();		
		boolean insertable = false;
		String locale = "";		
		if(locale==null) locale="en";	
		int tot_rec=0;

		String strPackageSeqno="";
		System.err.println("newvariablefortesting-changes done on 26072022-"+newvariablefortesting);

		//System.out.println("tabdata:"+tabdata);	
		try
		{
			String totalRecords=(String)tabdata.get("totalRecords");
			if(totalRecords==null) totalRecords="0";
			tot_rec=Integer.parseInt(totalRecords);
			
			client_ip_address=(String)tabdata.get("client_ip_address");
			if(client_ip_address==null) client_ip_address="";
			
			user_id=(String)tabdata.get("login_user");
			if(user_id==null) user_id="";
			
			con.setAutoCommit( false ) ;			
				insertable = true;		
			for(int i=0;i<tot_rec;i++)
			{
				if(tabdata.get("packageCode"+i)!=null && !((String)tabdata.get("packageCode"+i)).equals("")){
					String facility_id = (String) tabdata.get("FACILITY_ID");
					if(facility_id==null) facility_id="";

					String patientId=(String)tabdata.get("patientId");
					if(patientId==null) patientId="";

					String packageCode=(String)tabdata.get("packageCode"+i);
					if(packageCode==null) packageCode="";
				
					String packageDesc=(String)tabdata.get("packageDesc"+i);
					if(packageDesc==null) packageDesc="";

					String fromDate=(String)tabdata.get("fromDate"+i);
					if(fromDate==null) fromDate="";
					//System.out.println("fromDate ejb"+fromDate);
					String toDate=(String)tabdata.get("toDate"+i);
					if(toDate==null) toDate="";

					String pkgAmt=(String)tabdata.get("pkgAmt"+i);
					if(pkgAmt==null) pkgAmt="";
					//Added V171212-Gayathri/MMS-DM-CRF-0118
					
					String addlCharge=(String)tabdata.get("addlCharge"+i);
					if(addlCharge==null) addlCharge="";

					String episodeType=(String)tabdata.get("episodeType"+i);
					if(episodeType==null) episodeType="";

				//	String encounterId=(String)tabdata.get("encounterId"+i);
				//	if(encounterId==null) encounterId="";

					String blng_class_code=(String)tabdata.get("blng_class_code"+i);
					if(blng_class_code==null) blng_class_code="";	

					String blng_class_desc=(String)tabdata.get("blng_class_desc"+i);
					if(blng_class_desc==null) blng_class_desc="";			
					//Added By Shikha For GHL-CRF-0520.1
					String blng_grp_code=(String)tabdata.get("blng_grp_code"+i);
					if(blng_grp_code==null) blng_grp_code="";	

					String blng_grp_desc=(String)tabdata.get("blng_grp_desc"+i);
					if(blng_grp_desc==null) blng_grp_desc="";			
					//Ended By Shikha For GHL-CRF-0520.1
					String payerGrpCode=(String)tabdata.get("payerGrpCode"+i);
					if(payerGrpCode==null) payerGrpCode="";	
					String payerGrpDesc=(String)tabdata.get("payerGrpDesc"+i);
						if(payerGrpDesc==null) payerGrpDesc="";	
					String payerCode=(String)tabdata.get("payerCode"+i);
						if(payerCode==null) payerCode="";	
					String payerDesc=(String)tabdata.get("payerDesc"+i);
					if(payerDesc==null) payerDesc="";	

					//Added Newly by muthu against 33044
					String practitioner_id=(String)tabdata.get("practitioner_id"+i);
					//System.out.println("Muthu practitioner_id in Manager ==> "+practitioner_id);
					if(practitioner_id==null) practitioner_id="";
					String practitioner_name=(String)tabdata.get("practitioner_name"+i);
					//System.out.println("Muthu practitioner_name in Manager ==> "+practitioner_name);
					if(practitioner_name==null) practitioner_name="";
					//Added Newly by muthu against 33044

					
					String strOPYN=(String)tabdata.get("strOPYN"+i);
					if(strOPYN==null) strOPYN="";	
					String strEMYN=(String)tabdata.get("strEMYN"+i);
					if(strEMYN==null) strEMYN="";	
					String strIPYN=(String)tabdata.get("strIPYN"+i);
					if(strIPYN==null) strIPYN="";	
					String strDCYN=(String)tabdata.get("strDCYN"+i);
					if(strDCYN==null) strDCYN="";	
					
					String depositAmt="";String utilizedAmt="";String status="O";String packageSeqno="";
					String addl_Charge="";//Added V171212-Gayathri/MMS-DM-CRF-0118

					locale=(String)tabdata.get("locale");
					if(locale==null) locale="";
					//Added V200228 SHIKHA 3TierAlmoFeature 
					boolean site3TierAlmoFeature = false;
					try {
						site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");//Added V200228 SHIKHA 3TierAlmoFeature
					} catch(Exception ex) {
						System.err.println("Error in BillingRecordApprovalServlet.java for getting site3TierAlmoFeature Connection: "+ex);
						ex.printStackTrace();
					}
					//Ended V200228 SHIKHA 3TierAlmoFeature
					
					try
					{
						if(insertable)
						{
							String to_date_temp = "";	
							String sqlblpackagesub   ="";
							if(!(toDate.equals("")))
							{
								//Below query is changed by muthu against 33044
								sqlblpackagesub   ="{ call blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?)}";
									// to_date_temp="to_date('"+toDate+"','dd/mm/yyyy')";
									to_date_temp=toDate;
							}
							else{
								//Below query is changed by muthu against 33044
									sqlblpackagesub   ="{ call blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?)}";
									//sqlblpackagesub   ="{ call blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?)}";
									to_date_temp=null;
									
							}
							
							//String sqlblpackagesub="{ call   blpackage.InsertSubHdr('"+facility_id+"','"+patientId+"','"+packageCode+"',TO_DATE('"+fromDate+"','DD/MM/YYYY'),"+to_date_temp+",'"+strOPYN+"','"+strEMYN+"','"+strIPYN+"','"+strDCYN+"','"+pkgAmt+"','"+depositAmt+"','"+utilizedAmt+"','"+status+"','"+user_id+"',sysdate,'"+user_id+"',sysdate,'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"',?,?,?,?)}";
						
							//String sqlblpackagesub   ="{ call   blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?)}";
							//System.out.println("sqlblpackagesub :"+sqlblpackagesub);
							cstmt = con.prepareCall(sqlblpackagesub);							
							cstmt.setString(1,facility_id);
							cstmt.setString(2,patientId);
							cstmt.setString(3,packageCode);
							cstmt.setString(4,fromDate);		
							cstmt.setString(5,to_date_temp);							
							cstmt.setString(6,blng_class_code);							
							cstmt.setString(7,payerGrpCode);							
							cstmt.setString(8,payerCode);							
							cstmt.setString(9,pkgAmt);							
							cstmt.setString(10,depositAmt );						
							cstmt.setString(11,utilizedAmt );
							cstmt.setString(12,practitioner_id);//Added Newly by muthu against 33044
							System.err.println("practitioner_id in Manager in 229 "+practitioner_id); //muthu
							cstmt.setString(13,status);
							cstmt.setString(14,user_id);
							cstmt.setString(15,user_id);
							cstmt.setString(16,client_ip_address);
							cstmt.setString(17,facility_id);
							cstmt.setString(18,client_ip_address);
							cstmt.setString(19,facility_id);					
							cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
							
							
		//					Karthik added for KDAH-SCF-0351  Admission Date Extra Parameter Starts
							cstmt.setString(24, null);
							cstmt.registerOutParameter(25,java.sql.Types.VARCHAR); //Added V171212-Gayathri/MMS-DM-CRF-0118					
							cstmt.setString(26,blng_grp_code); //Added By Shikha For GHL-CRF-0520.1
		//					Karthik added for KDAH-SCF-0351  Admission Date Extra Parameter 	Ends				
							cstmt.execute();					
							
							packageSeqno=cstmt.getString(20);
							str_error_level=cstmt.getString(21);
							str_sysmesage_id=cstmt.getString(22);					
							str_error_text=cstmt.getString(23);
							addl_Charge=cstmt.getString(25); //Added V171212-Gayathri/MMS-DM-CRF-0118
							
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";
							if(packageSeqno==null) packageSeqno="";
							if(addl_Charge==null) addl_Charge=""; //Added V171212-Gayathri/MMS-DM-CRF-0118
							
								
							//if(strPackageSeqno.equals("")){
							//	strPackageSeqno=packageSeqno;
							//}else{
							strPackageSeqno=strPackageSeqno+packageSeqno+"^";
							//	}
							
							cstmt.close();

							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
								//sb.append("<br>"+str_error_text+"<br> ") ;
							}
											
						}//insertable
				
					}
					catch(Exception e)
					{
						insertable=false;
						sys_err.append(" Exception while calling blpackage.InsertPackage:"+e);
						System.out.println("Exception in blpackage.InsertPackage Call:"+e);
						e.printStackTrace();
					}
					
					/*  Karthik added logic for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  starts */
					String siteParam=(String)tabdata.get("siteParam");
					if(siteParam==null) siteParam="";	
					//if(siteParam.equals("ALMO")){//Added V200907 MUTHUN 3TierAlmoFeature
					if(("ALMO".equalsIgnoreCase(siteParam) || site3TierAlmoFeature == true)){//Added V200907 MUTHUN 3TierAlmoFeature	
						System.err.println("Inside 1");			
						HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters=new HashMap<String,ArrayList<String>>();
						ArrayList<String> encounterCombinationArray=new ArrayList<String>();
						packageSubscriptionAssociationEncounters=(HashMap<String,ArrayList<String>>)tabdata.get("packageSubscriptionAssociationEncounters");
						if(packageSubscriptionAssociationEncounters!=null){
							encounterCombinationArray=packageSubscriptionAssociationEncounters.get(patientId);				

							for(int encCount=0;encCount<encounterCombinationArray.size();encCount++){					
			
								StringTokenizer stEncList=new StringTokenizer(encounterCombinationArray.get(encCount),"|");					
								String headerEpisodeType=stEncList.hasMoreTokens()?stEncList.nextToken():"";
								String encounterId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
								String episodeId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
								String visitId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
								
								String functionId=(String)tabdata.get("functionId");
								if(functionId==null) functionId="";			
								String login_user=(String)tabdata.get("login_user");
								if(login_user==null) login_user="";	
								String client_ip_address=(String)tabdata.get("client_ip_address");
								if(client_ip_address==null) client_ip_address="";
								
												
								if( encounterId.equals("")==false || ( episodeId.equals("")==false && visitId.equals("")==false) ){
									HashMap pkgAssociationMap=AssociatePackage(con,facility_id,functionId,patientId,episodeId,headerEpisodeType,encounterId,visitId,packageCode,packageSeqno,login_user,client_ip_address,fromDate);
									insertable=(Boolean) pkgAssociationMap.get("status");				
									if(insertable==false) {
										str_error_text=(String) pkgAssociationMap.get("assocPackageErr");
										break;
									}
									/* Commented this section and recalculation will be called separately below at end of program V220718
									HashMap recalculationMap=recalculation(con,facility_id,patientId,headerEpisodeType,episodeId,visitId);
									//Added for Adding Request ID
									int reqId = 0;
									if(recalculationMap.containsKey("requestId")){
										try{
											reqId = (Integer) recalculationMap.get("requestId");
										}
										catch(Exception e){
											reqId = 0;
											e.printStackTrace();
											System.err.println("The Exception in getting Req Id->"+e);
										}
									}
									
									return_mess.put("requestId", reqId);
									//Added for Adding Request ID
									insertable=(Boolean) recalculationMap.get("status");				
									if(insertable==false) {
										str_error_text=(String) recalculationMap.get("recalcHdr");
										break;
									}
									*/								
								}
							}
						}
					}
					/*  Karthik added logic for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  ends */					
				}		
			}//for loop		
		
			/* Below code added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  STARTS */
			
			String facility_id = (String) tabdata.get("FACILITY_ID");
			String functionId = (String) tabdata.get("functionId");
			//String patientId="";
			if(functionId==null) functionId="";	
			if("EBL_TRAN_PACKAGE_MAINTAIN".equalsIgnoreCase(functionId) ){//* Below code added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622 */	
			System.err.println("Inside 2");
				HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters=new HashMap<String,ArrayList<String>>();
				ArrayList<String> encounterCombinationArray=new ArrayList<String>();
				String patientId=(String)tabdata.get("patientId");
				
				
				 packageSubscriptionAssociationEncounters=(HashMap<String,ArrayList<String>>)tabdata.get("packageSubscriptionAssociationEncounters");
				if(packageSubscriptionAssociationEncounters!=null){
					encounterCombinationArray=packageSubscriptionAssociationEncounters.get(patientId);				

					for(int encCount=0;encCount<encounterCombinationArray.size();encCount++){					

						StringTokenizer stEncList=new StringTokenizer(encounterCombinationArray.get(encCount),"|");					
						String headerEpisodeType=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String encounterId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String episodeId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String visitId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String packageSeqno=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String packageCode=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String fromDate=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						functionId=(String)tabdata.get("functionId");
						if(functionId==null) functionId="";			
						String login_user=(String)tabdata.get("login_user");
						if(login_user==null) login_user="";	
						String client_ip_address=(String)tabdata.get("client_ip_address");
						if(client_ip_address==null) client_ip_address="";
						
								
						if( encounterId.equals("")==false || ( episodeId.equals("")==false && visitId.equals("")==false) ){
							
							HashMap pkgAssociationMap=AssociatePackage(con,facility_id,functionId,patientId,episodeId,headerEpisodeType,encounterId,visitId,packageCode,packageSeqno,login_user,client_ip_address,fromDate);
							insertable=(Boolean) pkgAssociationMap.get("status");				
							if(insertable==false) {
								 str_error_text=(String) pkgAssociationMap.get("assocPackageErr");
								break;
							}
							
							/* V220718
							HashMap recalculationMap=recalculation(con,facility_id,patientId,headerEpisodeType,episodeId,visitId); 
							
							//Added for Adding Request ID
							int reqId = 0;
							if(recalculationMap.containsKey("requestId")){
								try{
									reqId = (Integer) recalculationMap.get("requestId");
								}
								catch(Exception e){
									reqId = 0;
									e.printStackTrace();
									System.err.println("The Exception in getting Req Id->"+e);
								}
							}
							
							return_mess.put("requestId", reqId);
							//Added for Adding Request ID
							insertable=(Boolean) recalculationMap.get("status");				
							if(insertable==false) {
								str_error_text=(String) recalculationMap.get("recalcHdr");
								break;
							}
							*/						
						}
					}
				}
			}
		
			/*  Added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  ENDS */	
			
			/*  Karthik added logic for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  ends */			
			
			/*Karthik Added PMG2016-CRF-MMS-0003 V 1 0 */		
	
			ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanList= (tabdata.get("packageAssociationExistingPackages"))==null ? new ArrayList<PkgAssociationExistingPackagesBean>(): (ArrayList<PkgAssociationExistingPackagesBean>)tabdata.get("packageAssociationExistingPackages");
			facility_id = (String) tabdata.get("FACILITY_ID");
			if(facility_id==null) facility_id="";

			String patientId=(String)tabdata.get("patientId");
			if(patientId==null) patientId="";
			
			for(PkgAssociationExistingPackagesBean bean:pkgAssociationExistingPackagesBeanList){
				System.err.println("Inside 3");
				
				HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters=new HashMap<String,ArrayList<String>>();
				ArrayList<String> encounterCombinationArray=new ArrayList<String>();
				packageSubscriptionAssociationEncounters=(HashMap<String,ArrayList<String>>)tabdata.get("packageSubscriptionAssociationEncounters");
				if(packageSubscriptionAssociationEncounters!=null){
					encounterCombinationArray=packageSubscriptionAssociationEncounters.get(patientId);				

					for(int encCount=0;encCount<encounterCombinationArray.size();encCount++){					

						StringTokenizer stEncList=new StringTokenizer(encounterCombinationArray.get(encCount),"|");					
						String headerEpisodeType=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String encounterId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String episodeId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String visitId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
					
						functionId=(String)tabdata.get("functionId");
						if(functionId==null) functionId="";			
						String login_user=(String)tabdata.get("login_user");
						if(login_user==null) login_user="";	
						String client_ip_address=(String)tabdata.get("client_ip_address");
						if(client_ip_address==null) client_ip_address="";
						
										
						if( encounterId.equals("")==false || ( episodeId.equals("")==false && visitId.equals("")==false) ){
							HashMap pkgAssociationMap=AssociatePackage(con,facility_id,functionId,patientId,episodeId,headerEpisodeType,encounterId,visitId,bean.getExistingPkgCode(),bean.getExistingPkgSeqNo(),login_user,client_ip_address,bean.getExistingPkgFrmDte());
						//	System.out.println("bean.getExistingPkgFrmDte in EJB  "+bean.getExistingPkgFrmDte());
							insertable=(Boolean) pkgAssociationMap.get("status");				
							if(insertable==false) {
								str_error_text=(String) pkgAssociationMap.get("assocPackageErr");
								break;
							}
							/* V220718
							HashMap recalculationMap=recalculation(con,facility_id,patientId,headerEpisodeType,episodeId,visitId);
							//Added for Adding Request ID
							int reqId = 0;
							if(recalculationMap.containsKey("requestId")){
								try{
									reqId = (Integer) recalculationMap.get("requestId");
								}
								catch(Exception e){
									reqId = 0;
									e.printStackTrace();
									System.err.println("The Exception in getting Req Id->"+e);
								}
							}
							
							return_mess.put("requestId", reqId);
							//Added for Adding Request ID
							insertable=(Boolean) recalculationMap.get("status");				
							if(insertable==false) {
								str_error_text=(String) recalculationMap.get("recalcHdr");
								break;
							}	
							*/
						}
					}
				}			
			}	
			System.err.println("Before Recalculation call starts here-changes done on 26072022");
			// V220718 commented the recalculation call from above places and calling recalculation seperately for the selected encounters to be associated
			if(insertable == true){
				System.err.println("Inside Recalculation call1");
				HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters=new HashMap<String,ArrayList<String>>();
				ArrayList<String> encounterCombinationArray=new ArrayList<String>();
				packageSubscriptionAssociationEncounters=(HashMap<String,ArrayList<String>>)tabdata.get("packageSubscriptionAssociationEncounters");
				System.err.println("Inside Recalculation call2");
				if(packageSubscriptionAssociationEncounters!=null){
					encounterCombinationArray=packageSubscriptionAssociationEncounters.get(patientId);				
					System.err.println("Inside Recalculation call3");
					for(int encCount=0;encCount<encounterCombinationArray.size();encCount++){
						StringTokenizer stEncList=new StringTokenizer(encounterCombinationArray.get(encCount),"|");					
						String headerEpisodeType=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String encounterId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String episodeId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						String visitId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
						System.err.println("Inside Recalculation call4:"+facility_id+"/"+patientId+"/"+headerEpisodeType+"/"+encounterId+"/"+episodeId+"/"+visitId);
						if( encounterId.equals("")==false || ( episodeId.equals("")==false && visitId.equals("")==false) ){
							HashMap recalculationMap=recalculation(con,facility_id,patientId,headerEpisodeType,episodeId,visitId);
							//Added for Adding Request ID
							int reqId = 0;
							if(recalculationMap.containsKey("requestId")){
								try{
									reqId = (Integer) recalculationMap.get("requestId");
								}
								catch(Exception e){
									reqId = 0;
									e.printStackTrace();
									System.err.println("The Exception in getting Req Id->"+e);
								}
							}
							System.err.println("Inside Recalculation call5:"+reqId);
							return_mess.put("requestId", reqId);
							//Added for Adding Request ID
							insertable=(Boolean) recalculationMap.get("status");				
							if(insertable==false) {
								System.err.println("Inside Recalculation call6 err:"+(String) recalculationMap.get("recalcHdr"));
								str_error_text=(String) recalculationMap.get("recalcHdr");
								break;
							}
						}
					}
				}
			}
			System.err.println("After Recalculation call ends here-changes done on 26072022");
			
			if(insertable)
			{
				con.commit();
			}
			else
			{
				con.rollback();
			}
		
		}catch (Exception e)
		{
			insertable=false;
			sys_err.append("Main Exception in PkgSubscriptionManager.java:"+e);
			System.out.println("Main Exception in PkgSubscriptionManager.java:"+e);
			e.printStackTrace();
		}		
		finally 
		{
			//System.out.println("finally");
			if (con != null)
			ConnectionManager.returnConnection(con, p);
		}		
		return_mess.put("strPackageSeqno",strPackageSeqno);
		return_mess.put("status",new Boolean(insertable));
		return_mess.put("error",str_error_text);
		return_mess.put("sys_error",sys_err.toString());
		return_mess.put("message",str_sysmesage_id);	
		return return_mess;			
	}//insert()
	
	/*  Karthik added AssociatePackage method for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  starts */
	public HashMap AssociatePackage(Connection con,String facility_id, String function_id, String patient_id,String episode_id,String episode_type,String encounter_id,String visit_id,
			String pkg_code,String pkg_seq_no,String login_user,String client_ip_address,String fromDateModified){
		/********************* insert Associated Pkgs********start************/
		HashMap returnMap = new HashMap();
		boolean insertable=false;
		try{
				String pkg_dtls="";
				String pkg_desc="";
				String str_error_level="",str_sysmesage_id="",str_error_text="";
				String str_ws_by_ip_name1 = "";
				
				StringTokenizer pkgSt=null;
				String sqlIpAdd="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facility_id+"'";
				PreparedStatement pst12=con.prepareStatement(sqlIpAdd);
				ResultSet rst12 = pst12.executeQuery();
				if (rst12!=null)
				{
				   if (rst12.next())
				   {
						 str_ws_by_ip_name1 = rst12.getString("ws_by_ip_name");
				   }
				}
				if(rst12 != null) rst12.close();
				if(pst12 != null) pst12.close();
				if ( str_ws_by_ip_name1 == null ) str_ws_by_ip_name1 ="";

				// End for WS Identification by IP Adress/Name
				String p_machine_name1 = "";
				if (str_ws_by_ip_name1.equals("I"))
				{						
					p_machine_name1 = InetAddress.getByName(client_ip_address).getHostName() ;
				}
				else
				{
					p_machine_name1 = (client_ip_address);
				}

				String	sqlPkgAssociation   ="{ call   blpackage.AssociateEncounter(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

				CallableStatement pkgAssociate_cstmt = con.prepareCall(sqlPkgAssociation);			
				pkgAssociate_cstmt.setString(1,facility_id);
				pkgAssociate_cstmt.setString(2,function_id);
				pkgAssociate_cstmt.setString(3,patient_id);	
				pkgAssociate_cstmt.setString(4,episode_id);
				pkgAssociate_cstmt.setString(5,episode_type);			
				pkgAssociate_cstmt.setString(6,encounter_id);	
				
				if(visit_id==null || (visit_id.trim()).equals("")){
				pkgAssociate_cstmt.setString(7,null);	
				}else{
				pkgAssociate_cstmt.setInt(7,Integer.parseInt(visit_id.trim()));	
				}
				
				pkgAssociate_cstmt.setString(8,pkg_code);
				
				if(pkg_seq_no==null || (pkg_seq_no.trim()).equals(""))	{		
				pkgAssociate_cstmt.setString(9,null);	
				}else{
				pkgAssociate_cstmt.setLong(9,Long.parseLong(pkg_seq_no.trim()));
				}
				
				pkgAssociate_cstmt.setString(10,login_user);//sysdate	
				pkgAssociate_cstmt.setString(11,p_machine_name1);				
				pkgAssociate_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
				pkgAssociate_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
				pkgAssociate_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
				pkgAssociate_cstmt.setString(15,fromDateModified);
				pkgAssociate_cstmt.execute();						
				str_error_level=pkgAssociate_cstmt.getString(12);
				str_sysmesage_id=pkgAssociate_cstmt.getString(13);					
				str_error_text=pkgAssociate_cstmt.getString(14);
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";		

				if( str_sysmesage_id.equals("")  &&  str_error_text.equals("") &&  str_error_level.equals("") )
				{
					insertable=true;
				}else{
					insertable=false;
					returnMap.put("assocPackageErr", str_error_level+"-"+str_error_text);
				}		
				
				if(pkgAssociate_cstmt!=null) pkgAssociate_cstmt.close();//V210413
			}
			catch(Exception e)
			{
				insertable=false;
				System.out.println("Exception while inserting package associations="+e);
				e.printStackTrace();
			}
		
		returnMap.put("status", new Boolean(insertable));
		return returnMap;
	}
	/*  Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  ends */
	
	/*  Karthik added recalculation method for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  starts */
	private HashMap recalculation(Connection con,String facility_id, String patientId,String episodeType, String episodeId, String visitId) {
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		int reqId = 0;
		try
		{
			System.err.println("Starting Recalculation");
			String str_error_level = "", str_sysmesage_id = "", str_error_text="";
			//String recalc = "{ call   bl_recalc_process.proc_recalculation (?,?,?,?,?,?,?,?,?,?) }";
			String recalc = "{ call   bl_recalc_process.proc_recalc (?,?,?,?,?,?,?,?,?,?,?,?) }";
			CallableStatement cstmt =con.prepareCall(recalc);

			cstmt.setString(1, facility_id);
			cstmt.setString(2,patientId);
			cstmt.setString(3, episodeType);
			cstmt.setString(4, episodeId);
			cstmt.setString(5, visitId);
			cstmt.setString(6, client_ip_address);
			cstmt.setString(7, user_id);
			cstmt.setString(8, "PKG_SUBSCRIPTION");
			cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(12, java.sql.Types.INTEGER);
			
			
			cstmt.execute();
			str_error_level = cstmt.getString(10);
			str_sysmesage_id = cstmt.getString(9);
			str_error_text = cstmt.getString(11);
			reqId = cstmt.getInt(12);

			System.err.println("str_error_level-"+str_error_level+"str_sysmesage_id-"+str_sysmesage_id+"str_error_text-"+str_error_text);
			if(str_error_level!=null || str_error_text!=null){
				returnMap.put("recalcHdr", str_error_level+"-"+str_error_text);
			}

			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}
			
			returnMap.put("requestId", reqId);
			
			if(cstmt!=null)
			cstmt.close();

		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception is "+e);
			returnMap.put("internalError", "Internal Error");
			insertable = false;
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
	}
	/*  Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  ends */
}
