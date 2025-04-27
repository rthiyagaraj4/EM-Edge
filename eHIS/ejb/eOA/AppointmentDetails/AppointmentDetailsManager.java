/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> 										 
---------------------------------------------------------------------------------------------------------------
*/    
package eOA.AppointmentDetails;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import blbkin.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;	 

/**
*
* @ejb.bean
*	name="AppointmentDetails"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AppointmentDetails"
*	local-jndi-name="AppointmentDetails"
*	impl-class-name="eOA.AppointmentDetails.AppointmentDetailsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOA.AppointmentDetails.AppointmentDetailsLocal"
*	remote-class="eOA.AppointmentDetails.AppointmentDetailsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.AppointmentDetails.AppointmentDetailsLocalHome"
*	remote-class="eOA.AppointmentDetails.AppointmentDetailsHome"
*	generate= "local,remote"
*
*
*/
public class AppointmentDetailsManager implements SessionBean
{

	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) { 
		this.ctx=context;
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap insertAppointmentDetails(java.util.Properties p,java.util.ArrayList passObjectsList){
	System.err.println("67---------insertAppointmentDetails----->");
    String patientid="";
	// Checkstyle Violation commented by Munisekhar
	//String clinic_code="",apptrefno1="",practitionerid="",apptdate="",appttime="",apptslabfmtime="",apptslabtotime="",apptduration="",sql6="",patientid="",prefix="",firstname="",secondname="",thirdname="",familyname="",suffix="",patientname="",gender="",dateofbirth="",restelno="",othtelno="",emailid="",nationalid="",alternateid="",resaddrl1="",resaddrl2="",resaddrl3="",resaddrl4="",postalcode="",countrycode="",appttypecode="",overbookedyn="",referralcode="",mode="",reasoncode="",apptremarks="",apptstatus="",impyn="",sqlds="",TRANSFERRED_APPT_YN="";
	//int apptslots=0;
	//StringBuffer sql_update_oa_clinic_sch=new StringBuffer("");
	//StringBuffer sql8_up=new StringBuffer("");
	//String transfer_within="N";

	//Connection con =null;
	//Statement stmt=null;
	PreparedStatement pstmt =null;
	//PreparedStatement pstmt =null,pstmt1 =null,pstmt3 =null,pstmt4 =null,pstmt5 =null,pstmt6 =null,pstmt_dup2 =null,pstmt_dup =null,pstmt_dat =null,pStmt=null,pst_SqlUp_sec_stat_dec=null,pst_sqlmaxSec=null,pst_del_oa_re_appt=null,pst_sql_insres_for_appt=null,pstmt_sql_sec_stat_inc=null,pstmt_sql_upop=null,pstmt_sql_sec_rstyp1=null,pstmt_sql_sec_rstyp2=null,pstmt_sql_sec_rstyp3=null,pstmt_sqldssec=null,pstmt_ins_secondary_res=null,pstmt_overlap=null,pstmt_del_fm=null,or_stmt=null,pstmt_forced=null;
	ResultSet rs = null;
	//ResultSet rs = null,rs_dat = null,rs_dup = null,rs_dup2 = null,rs_pract=null,rSsrl=null,rSet=null,rSet_sec=null,or_rset=null,rs_forced=null;
	String rd_appt_yn="N",order_id1="",order_line_num="";
	//String old_pract_id="",old_alcn_catg_code="",ethnic_grp_cd="",ethnic_subgrp_cd="",citizen_yn="",legal_yn="",birth_place_code="",birth_place_desc="",forced_appt_yn="",global_appt_yn="",res_town="",res_area="",res_region="",res_country="",mail_addr1="",mail_addr2="",mail_addr3="",mail_addr4="",mail_town="",mail_area="",mail_postal="",mail_region="",mail_country="",sql8="",sql7="",slot_appt_ctrl="",team_id="",sql_up_newdate="",visitind_new="",rd_appt_yn="N",order_id1="",order_line_num="";

	String strFunctionId		= "CANCELBOOKING";
	java.util.HashMap passObjects		= null;
	int listCount						= passObjectsList.size();
	int listCountCheck					= 0;
	patientid							= "";
	String facilityId					= null;
	String apptrefno					= null;
	String visitind						= null;
	String reasonforcancellation		= null;
	String alcn_criteria				= null;
	String pat_cat						= null;	
	String addedFacilityId				= null;
	String addedAtWorkstation			= null;
	String forced						= null;
	String referral_value				= null;
	patientid							= null;
	String episode_type					= null;
	String apptdate1					= null;
	String bl_operational				= null;
	String capture_fin_dtls_yn			= null;
	String send_email_yn				= "N";
	String operation					= null;
	String email_appl_yn				= null;
	String email_appl_for_appt_wo_pid_yn= null;
	String patCnclCount					="";//changes for Bru-HIMS-CRF-169
	String pat_cancel_reason					="";//changes for Bru-HIMS-CRF-169
	String remarksForCancellation		= null; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	
	boolean sendmailflag				= false;
	java.util.HashMap results			= new HashMap();
	boolean result						= true;
	boolean result_bl					= false;
	//boolean breakFlag					= true;
	StringBuffer sb						= null;
	String addedById					= p.getProperty( "login_user" );
	Connection connection				= null;
	CallableStatement clstmt			= null;
	String Result						= "";
	String locale						= p.getProperty("LOCALE");
	Iterator iterator					= passObjectsList.iterator();
	String oraError						= "";
	ResultSet rset = null;
	/*Added By Dharma on 26th Nov 2014 against HSA-SCF-0145 [IN:051698] Start*/
	Iterator apptIterator				= passObjectsList.iterator();
	java.util.HashMap apptPassObjects	= null;
	String ApptNoList					= "";
	String strApptNo					= "";
	String apptStatus					= "";
	/*Added By Dharma on 26th Nov 2014 against HSA-SCF-0145 [IN:051698] End*/
	try{
		connection=ConnectionManager.getConnection(p);
		connection.setAutoCommit(false);
		/*Added By Dharma on 26th Nov 2014 against HSA-SCF-0145 [IN:051698] Start*/
		while(apptIterator.hasNext()){
			apptPassObjects		= (HashMap)apptIterator.next();
			addedFacilityId		= (String) apptPassObjects.get("addedFacilityId");  
			ApptNoList			= (String) apptPassObjects.get("apptrefno")+",";
		
		}
		if(!ApptNoList.equals("")){
				strApptNo	=  ApptNoList.substring(0, ApptNoList.length()-1);
				
		}
		
		String refno="SELECT  APPT_REF_NO,appt_status FROM oa_appt WHERE APPT_REF_NO in('"+strApptNo+"') and FACILITY_ID ='"+addedFacilityId+"'";	
        		
		 if(pstmt!=null) pstmt.close();
		 pstmt   = connection.prepareStatement(refno);
		 rset = pstmt.executeQuery(); 
		 strApptNo	 	= "";
		 ApptNoList		= "";
		 
		 while(rset!=null && rset.next()){	
			 apptStatus	= (rset.getString("appt_status")==null?"":rset.getString("appt_status"));
			
			 if(apptStatus.equals("A")){
				 ApptNoList		= (String) rset.getString("APPT_REF_NO")+",";
			 }
			  
		 }
		 if(pstmt!=null) pstmt.close();
		 if(rset!=null) rset.close();
		 
		 if(!ApptNoList.equals("")){
				strApptNo	=  ApptNoList.substring(0, ApptNoList.length()-1);
				
				sb								= new StringBuffer("");
		}
		if(strApptNo.equals("")){
		/*Added By Dharma on 26th Nov 2014 against HSA-SCF-0145 [IN:051698] End*/
		while(iterator.hasNext()){
			if(result){
				Result							= "";
				sb								= new StringBuffer("");
				passObjects						=(HashMap)iterator.next();
				facilityId						=(String) passObjects.get("addedFacilityId");                    
				apptrefno						=(String) passObjects.get("apptrefno");                          
				visitind						=(String) passObjects.get("visitind");                            
				reasonforcancellation			=(String) passObjects.get("reasonforcancellation");  
				alcn_criteria					=(String) passObjects.get("alcn_criteria");                   
				pat_cat							=(String) passObjects.get("pat_cat");	                              
				addedFacilityId					=(String) passObjects.get("addedFacilityId");               
				addedAtWorkstation				=(String) passObjects.get("addedAtWorkstation");         
				forced							=(String) passObjects.get("Forced");                                 
				referral_value					=(String) passObjects.get("referral_value");    
				patientid						=(String) passObjects.get("patientid");
				episode_type					=(String) passObjects.get("episode_type");
				apptdate1						=(String) passObjects.get("appt_date");
				bl_operational					=(String) passObjects.get("bl_operational");
				capture_fin_dtls_yn				=(String) passObjects.get("capture_fin_dtls_yn");
				send_email_yn					=(String) passObjects.get("send_email_yn");
				operation						=(String) passObjects.get("operation");
				email_appl_yn					=(String) passObjects.get("email_appl_yn");
				email_appl_for_appt_wo_pid_yn	=(String) passObjects.get("email_appl_for_appt_wo_pid_yn");
				rd_appt_yn	=(String) passObjects.get("rd_appt_yn")==null?"N":(String) passObjects.get("rd_appt_yn");
				order_id1	=(String) passObjects.get("order_id1")==null?"":(String) passObjects.get("order_id1");
				order_line_num	=(String) passObjects.get("order_line_num");
				patCnclCount	=(String) passObjects.get("patCnclCount");//changes for BruHIMS-CRF 169
				pat_cancel_reason	=(String) passObjects.get("pat_cancel_reason");//changes for BruHIMS-CRF 169
				remarksForCancellation =(String) passObjects.get("remarksForCancellation"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

				addedFacilityId=facilityId;
				try{
					clstmt =connection.prepareCall("{call OA_CANCEL_APPOINTMENT(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					clstmt.setString(1,facilityId);
					clstmt.setString(2,apptrefno);
					//clstmt.setString(3,visitind); //Commented for ML-BRU-CRF-0628.8 US001
					clstmt.setString(3,patientid); //Added for ML-BRU-CRF-0628.8 US001
					clstmt.setString(4,reasonforcancellation);
					clstmt.setString(5,alcn_criteria);
					clstmt.setString(6,pat_cat);
					clstmt.setString(7,addedFacilityId);
					clstmt.setString(8,addedAtWorkstation);
					clstmt.setString(9,forced);
					clstmt.setString(10,addedById);
					clstmt.registerOutParameter(11,Types.VARCHAR);
					clstmt.setString(12,referral_value);
					clstmt.setString(13,remarksForCancellation);
					clstmt.execute();
					Result=clstmt.getString(11);
					if (clstmt!=null)clstmt.close();
					int updateCount = 0 ;
					if(rd_appt_yn.equals("Y") && !order_id1.equals("")  && Result==null){
							//Updating audit columns::
							pstmt = connection.prepareStatement( "update or_order_line set order_line_status  = (select order_status_code from OR_ORDER_STATUS_CODE where order_status_type ='10'), result_LINE_status = '',ACCESSION_NUM      = '', ACCESSION_LINE_NUM = '',  APPT_DATE_TIME     ='',   APPT_REF_NUM       ='' ,MODIFIED_BY_ID = ?, MODIFIED_AT_WS_NO = ?, MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID = ? where order_id = ? and order_line_num = ? " );
							pstmt.setString( 1, addedById ) ;
							pstmt.setString( 2, addedAtWorkstation ) ;
							pstmt.setString( 3, addedFacilityId ) ;
							pstmt.setString( 4, order_id1 ) ;
							pstmt.setString( 5, order_line_num ) ;
							updateCount = pstmt.executeUpdate() ;

							if(updateCount != 0){
								result = true ;
							}else{
								result =false;						
								sb.append("updateCount  :"+updateCount+" for or_order_line");
							}

						
					}

					/* Added for Billing Interface Starts*/
					if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y") && Result==null){
						try{
							Hashtable hashtableBill = new Hashtable();
							hashtableBill.put("facilityId",facilityId+"");
							hashtableBill.put("bookingrefno",apptrefno+"");
							hashtableBill.put("P_PATIENT_ID",patientid+"");
							hashtableBill.put("admissiondate",apptdate1+"");
							hashtableBill.put("P_EPISODE_TYPE",episode_type+"");
							hashtableBill.put("function_id",strFunctionId+"");
							BLCancelBooking blbkBookPat = new BLCancelBooking();
							Hashtable resultsBL = blbkBookPat.billPatientService(p, connection,hashtableBill);
							boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
							result_bl = boolRes;
							String strBLMessage = "";
							strBLMessage = (String) resultsBL.get("message");
							if(boolRes == false){
								sb.append((String) resultsBL.get("error")+"\n");
								Result="0";
								result=false;
							}
							if (boolRes == true) {
								if(strBLMessage != null){
									if (!(strBLMessage.equals(""))) {
									}
								}else{
									strBLMessage = "0";
								}
							}
						}catch(Exception exceptionBL){
							result=false;
							sb.append("BILLING UPDATION :"+exceptionBL.toString());
							System.err.println("BILLING UPDATION :"+exceptionBL.toString());
							exceptionBL.printStackTrace();
						}
					}
					/* Added for Billing Interface Ends*/
					//Below Code modified for ML-BRU-CRF-0628.8 US001
				}catch(Exception e){
					sb.append(e.getMessage());
					System.err.println(e.getMessage());
					e.printStackTrace();
					result=false;
				}
				if(result && Result==null){
					listCountCheck++;
				}
			}//End of BreakFlag
			if(!result || Result!=null){
				Pattern pattern = Pattern.compile("ORA-00060");
				Pattern pattern1= Pattern.compile("ORA-00001");
				Matcher matcher = pattern.matcher(Result);
				 while(matcher.find()){
					oraError="Schedule Cancelled by other user. Cannot Proceed.";
				}
				if(oraError==""){
					Matcher matcher1 = pattern1.matcher(Result);
					while (matcher1.find()){
						oraError="Schedule Cancelled by another user. Cannot Proceed.";
					}
				}
				result=false;
				break;
			}
			}//End of Iterator While loop
		}else{/*Added By Dharma on 26th Nov 2014 against HSA-SCF-0145 [IN:051698] Start*/
			result=false;
			java.util.Hashtable message = MessageManager.getMessage(locale, "APPT_CANNOT_CANCELLED","OA" ) ;
			oraError	= (String) message.get("message");
			oraError	= oraError.replaceAll("#",strApptNo);
			message.clear();
		}
		/*Added By Dharma on 26th Nov 2014 against HSA-SCF-0145 [IN:051698] End*/
		//inserting into OA_PAT_CNCL_APPT_SUMMARY for Bru-HIMs-CRF 169
		
		if(result && operation!=null && operation.equals("insert") && patientid != null && !(patientid.equals(""))){//to update the count in oa_pat_cncl_appt_summary only when it is a cancel operation and the appointment has a patient id.
			//CALL THE update method
			updateOAPatCnclSummary(connection,patientid,facilityId,patCnclCount,pat_cancel_reason,reasonforcancellation,addedById,addedAtWorkstation);
		}
		if(listCount==listCountCheck){
			if(Result==null){
				connection.commit();
				java.util.Hashtable message = MessageManager.getMessage(locale, "APPT_CANCELLED","OA" ) ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
				if(operation.equals("insert")){
					if(send_email_yn==null)send_email_yn="N";
					if(send_email_yn.equals("Y")){
						try{
							if(clstmt!=null) clstmt.close();
							clstmt=connection.prepareCall("{call OA_SEND_APPT_MAIL(?,?,?,?,?,?,?,?,?)}");
							clstmt.setString(1,facilityId);
							clstmt.setString(2,"OA");
							clstmt.setString(3,"OAECNAPPT");
							clstmt.setString(4,"P");
							clstmt.setString(5,patientid);
							clstmt.setString(6,"");
							clstmt.setString(7,apptrefno);
							clstmt.setString(8,"en");
							clstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
							clstmt.execute();
							String mailerror=clstmt.getString(9);
							if(mailerror == null) mailerror="";
							if (clstmt!=null)clstmt.close(); 
							if(mailerror.equals("")){
								//result_mail=true;
							}else{
								//result_mail=false;
								//sb.append("MAIL ID UPDATION :"+mailerror.toString());
							}
						}catch(Exception mailex){
							mailex.printStackTrace();
							//result_mail=false;
							//sb.append("MAIL ID UPDATION :"+mailex.toString());
						}
					}
				}else if(operation.equals("BulkCancel")){
					String emailid_local	= "";
					String mailerror		= "";
					iterator				= passObjectsList.iterator();
					String email_SQL="select EMAIL_ID from OA_APPT_DEL_TR where APPT_REF_NO=? and facility_id=?";
					String mailsql="select  b.EMAIL_APPL_YN PAT_EMAIL_APPL_YN from mp_patient a, mp_pat_ser_grp b where  a.patient_id=? and a.pat_ser_grp_code=b.pat_ser_grp_code";
					boolean emailFlag=true;
					while(iterator.hasNext()){
						if(emailFlag){
							passObjects						=(HashMap)iterator.next();
							patientid						=(String) passObjects.get("patientid");
							facilityId						=(String) passObjects.get("addedFacilityId");                    
							apptrefno						=(String) passObjects.get("apptrefno"); 
							email_appl_for_appt_wo_pid_yn	=(String) passObjects.get("email_appl_for_appt_wo_pid_yn");
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();
							pstmt=connection.prepareStatement(email_SQL);
							pstmt.setString(1,apptrefno);
							pstmt.setString(2,facilityId);
							rs=pstmt.executeQuery();
							if(rs!=null && rs.next()){
								emailid_local=rs.getString("EMAIL_ID")==null?"":rs.getString("EMAIL_ID");
							}
							if(rs!=null)rs.close();
							if(pstmt!=null)pstmt.close();
							if(patientid.equals("")){
								if(email_appl_for_appt_wo_pid_yn.equals("Y")){
									if(emailid_local.equals("")){
										sendmailflag=false;
									}else{
										sendmailflag=true;
									}
								}else{
									sendmailflag=false;
								}
							}else{
								String pat_email_appl_yn="";
								if(pstmt!=null)pstmt.close();
								if(rs!=null)rs.close();
								pstmt=connection.prepareStatement(mailsql);
								pstmt.setString(1,patientid);
								rs=pstmt.executeQuery();
								if(rs!=null && rs.next()){
									pat_email_appl_yn=rs.getString("PAT_EMAIL_APPL_YN")==null?"":rs.getString("PAT_EMAIL_APPL_YN");
								}
								if(email_appl_yn.equals("Y") && pat_email_appl_yn.equals("Y")){
									if(emailid_local.equals("")){
										sendmailflag=false;
									}else{
										sendmailflag=true;
									}
								}else{
									sendmailflag=false;
								}
							}
						}//end Of emailFlagCheck
						if(send_email_yn==null)send_email_yn="N";
						if(send_email_yn.equals("Y")){
							try{
								if(clstmt!=null) clstmt.close();
								clstmt=connection.prepareCall("{call OA_SEND_APPT_MAIL(?,?,?,?,?,?,?,?,?)}");
								clstmt.setString(1,facilityId);
								clstmt.setString(2,"OA");
								clstmt.setString(3,"OAECNAPPT");
								clstmt.setString(4,"P");
								clstmt.setString(5,patientid);
								clstmt.setString(6,"");
								clstmt.setString(7,apptrefno);
								clstmt.setString(8,"en");
								clstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
								clstmt.execute();
								mailerror=clstmt.getString(9);
								if (clstmt!=null)clstmt.close(); 
								if(mailerror == null) mailerror="";
							}catch(Exception mailex){
								mailex.printStackTrace();
							//result_mail=false;
							//sb.append("MAIL ID UPDATION :"+mailex.toString());
							}
						}
						if(mailerror.equals("")){
						}else{
							break;
						}
					}
				}
			}else{
				connection.rollback();
				//Below Code modified for ML-BRU-CRF-0628.8 US001
				sb.append(Result);
				System.err.println(Result);
			}
		}else{
			connection.rollback();
			if(Result!=null && !Result.equals("0")){
				if(oraError!=""){
					sb.append(oraError);		
				}else{ 	
				if(Result.contains("APPOINTMENT CANNOT BE CANCELLED")){
					sb.append("APP-OA0366 "+Result);
					System.err.println("APP-OA0366 "+Result);
				}
				else
				{
					sb.append(Result);
					System.err.println("APP-OA0366 "+Result);
				}
				}
			}else{
				if(oraError!=""){
					sb.append(oraError);		
				}else{
					sb.append(Result);
					System.err.println(Result);
				}		
			}
		}
		if (clstmt!=null)clstmt.close(); 
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if (connection != null)  ConnectionManager.returnConnection(connection,p);
	}

	System.err.println("487-------------sb.toString()-------------insertAppointmentDetails--------------->"+sb.toString());

	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	return results;
}//method
/**
* @ejb.interface-method
*	 view-type="both"
*/
 public java.util.HashMap modifyAppointmentDetails(
				java.util.Properties p,
				java.util.ArrayList passObjectsList
				) 
{  //method start  Appoinmnet rescheduling

	 System.err.println("504-------------modifyAppointmentDetails------------->"); 
	
	String clinic_code="",apptrefno1="",practitionerid="",apptdate="",appttime="",apptslabfmtime="",apptslabtotime="",apptduration="",sql6="",patientid="",prefix="",firstname="",secondname="",thirdname="",familyname="",suffix="",patientname="",gender="",dateofbirth="",restelno="",othtelno="",emailid="",nationalid="",alternateid="",resaddrl1="",resaddrl2="",resaddrl3="",resaddrl4="",postalcode="",countrycode="",appttypecode="",overbookedyn="",referralcode="",mode="",reasoncode="",apptremarks="",apptstatus="",impyn="",sqlds="",TRANSFERRED_APPT_YN="";
	int apptslots=0;
	StringBuffer sql_update_oa_clinic_sch=new StringBuffer("");
	StringBuffer sql8_up=new StringBuffer("");
	String transfer_within="N";
	Connection con =null;
	Statement stmt=null;
	PreparedStatement pstmt =null,pstmt1 =null,pstmt3 =null,pstmt4 =null,pstmt5 =null,pstmt6 =null,pstmt_dup2 =null,pstmt_dup =null,pstmt_dat =null,pStmt=null,pst_SqlUp_sec_stat_dec=null,pst_sqlmaxSec=null,pst_del_oa_re_appt=null,pst_sql_insres_for_appt=null,pstmt_sql_sec_stat_inc=null,pstmt_sql_upop=null,pstmt_sql_sec_rstyp1=null,pstmt_sql_sec_rstyp2=null,pstmt_sql_sec_rstyp3=null,pstmt_sqldssec=null,pstmt_ins_secondary_res=null,pstmt_overlap=null,pstmt_del_fm=null,or_stmt=null,pstmt_forced=null;
	ResultSet rs = null,rs_dat = null,rs_dup = null,rs_dup2 = null,rs_pract=null,rSsrl=null,rSet=null,rSet_sec=null,or_rset=null,rs_forced=null;
	String old_pract_id="",old_alcn_catg_code="",ethnic_grp_cd="",ethnic_subgrp_cd="",citizen_yn="",legal_yn="",birth_place_code="",birth_place_desc="",forced_appt_yn="",global_appt_yn="",res_town="",res_area="",res_region="",res_country="",mail_addr1="",mail_addr2="",mail_addr3="",mail_addr4="",mail_town="",mail_area="",mail_postal="",mail_region="",mail_country="",slot_appt_ctrl="",team_id="",visitind_new="";
	/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
	String alt_addr_line1 = "",alt_addr_line2="",alt_addr_line3="";
	String alt_addr_line4 = "",alt_country_code="", alt_postal_code="";
	String alt_area_code="",alt_town_code="", alt_region_code="";
	/*End*/
	java.util.HashMap passObjects=null;
	int listCount=passObjectsList.size();
	int listCountCheck=0;
	java.util.HashMap results=null;
	String email_appl_yn ="";
	String email_appl_for_appt_wo_pid_yn ="";
	StringBuffer sb =null;
	boolean result =false;
	Iterator iterator=passObjectsList.iterator();	
	String sql2=null;
	String rule_based_tr ="N";
	String pract_override_reason ="";
	String pract_override_reason_old="";
	String patient_cat_code="";
	String language_id ="";
	String term_code ="";
	String term_set_id ="";
	String rd_appt_yn ="";
	String appt_category_old="";
	String remarksForPractOverride =""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	try{ 
		
		System.err.println("544------modifyAppointmentDetails-------try block------------>");
	
	
	try{
		
		System.err.println("549-------modifyAppointmentDetails------try block------------>");
		con = ConnectionManager.getConnection(p);
		con.setAutoCommit( false );
		while(iterator.hasNext()){
			passObjects=(HashMap)iterator.next();
			if(listCountCheck==0){
				slot_appt_ctrl=(String) (passObjects.get("slot_appt_ctrl")==null?"":passObjects.get("slot_appt_ctrl"));
				email_appl_yn=(String) (passObjects.get("email_appl_yn")==null?"":passObjects.get("email_appl_yn"));
				email_appl_for_appt_wo_pid_yn=(String) (passObjects.get("email_appl_for_appt_wo_pid_yn")==null?"":passObjects.get("email_appl_for_appt_wo_pid_yn"));
				
				System.err.println("559------------modifyAppointmentDetails--------slot_appt_ctrl---------->"+slot_appt_ctrl);
				
				if(slot_appt_ctrl.equals("")){
					
					System.err.println("563-------modifyAppointmentDetails-----inside if condition----------->");
					
					sql2="select slot_appt_ctrl,EMAIL_APPL_YN,EMAIL_APPL_FOR_APPT_WO_PID_YN from oa_param where module_id='OA'";
					if (pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql2);

					System.err.println("572-------modifyAppointmentDetails------sql2---------->"+sql2);
					
					rs=pstmt.executeQuery();

					System.err.println("576------modifyAppointmentDetails-------sql2---------->"+sql2);

					if (rs!=null && rs.next()){	
						slot_appt_ctrl=rs.getString("slot_appt_ctrl");
						email_appl_yn=rs.getString("EMAIL_APPL_YN");
						email_appl_for_appt_wo_pid_yn=rs.getString("EMAIL_APPL_FOR_APPT_WO_PID_YN");
					}
					if (pstmt!=null) pstmt.close();
					if (rs!=null) rs.close();
				}
			}
			String locale = p.getProperty("LOCALE");
			String service_code="";
			String order_id="";
			String order_line_num="";
			forced_appt_yn="";
			CallableStatement clstmt=null;
			String slot_slab_srlNO="";
			String from_bulk=(String) passObjects.get("from_bulk");
			if(from_bulk==null) from_bulk="";
			String facilityId=(String) passObjects.get("addedFacilityId");
			String time_table_type=(String) passObjects.get("time_table_type");
			String apptrefno =(String) passObjects.get("apptrefno");
			String clinic_code_from =(String) passObjects.get("clinic_code_from");	
			String new_from_time =(String) passObjects.get("new_from_time");
			String new_to_time =(String) passObjects.get("new_to_time");
			String new_date=(String) passObjects.get("new_date");
			String clinic_code_new=(String) passObjects.get("clinic_code");
			String practitioner_id=(String) passObjects.get("practitioner_id");
			String over_booked=(String) passObjects.get("over_booked");
			String dateapd=(String) passObjects.get("dateapd");
			String overbooked_yn=(String) passObjects.get("overbooked_yn");
			String visitind=(String) passObjects.get("visitind");
			String reasonforrevision=(String) passObjects.get("reasonforrevision");
			String no_of_slots=(String) passObjects.get("no_of_slots");
			String resaddrl1_new=(String) passObjects.get("resaddrl1");
			String resaddrl2_new=(String) passObjects.get("resaddrl2");
			String resaddrl3_new=(String) passObjects.get("resaddrl3");
			String resaddrl4_new=(String) passObjects.get("resaddrl4");
			String postalcode_new=(String) passObjects.get("postalcode");
			String to_over_book_yn=(String) passObjects.get("to_over_book_yn");
			String addedFacilityId=(String) passObjects.get("addedFacilityId");
			String addedAtWorkstation=(String) passObjects.get("addedAtWorkstation");
			String inpatient_yn=(String) passObjects.get("inpatient_yn");
			String teamId=(String) passObjects.get("team_id");
			String forced=(String) passObjects.get("Forced");
			String clinic_type=(String) passObjects.get("clinic_type");
			String res_class=(String) passObjects.get("res_type");
			String modified_date_time=(String)passObjects.get("modified_date_time");
			String forced_val=(String)passObjects.get("forced_val");
			if(forced_val ==null) forced_val="";
			String sec_final_value=(String)passObjects.get("sec_final_value");
			if(sec_final_value ==null) sec_final_value="";
			String episode_type =(String)passObjects.get("episode_type");
			//String patientid =(String)passObjects.get("patientid");
			String bl_operational =(String)passObjects.get("bl_operational");
			String capture_fin_dtls_yn =(String)passObjects.get("capture_fin_dtls_yn");
			String from_speciality =(String)passObjects.get("from_speciality");
			String send_email_yn =(String)passObjects.get("send_email_yn");
			String patCnclCount	=(String) passObjects.get("patCnclCount");//changes for BruHIMS-CRF 169
			String new_resource_class=(String) passObjects.get("new_resource_class")==null?"":(String) passObjects.get("new_resource_class"); //Added for this incident ML-BRU-SCF-1602 [IN:055253]	
			String function_mode=(String) passObjects.get("function_mode")==null?"":(String) passObjects.get("function_mode"); //Added for this incident ML-BRU-SCF-1602 [IN:055253]	
			
			String remarksForRevision = (String) passObjects.get("remarksForRevision"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			
			String speciality_code ="";
			String frm_alc_criteria="";
			String frm_alc_cat_code="";
			transfer_within="N";
			String visit_type_ind="";
			String	strFunctionId ="TRANSFERBOOKING";
			java.util.ArrayList sec_resources=(java.util.ArrayList) passObjects.get("sec_resources");
			String name_prefix_loc_lang ="";
			String	first_name_loc_lang="";
			String	second_name_loc_lang="";
			String	third_name_loc_lang="";
			String	name_suffix_loc_lang="";
			String	family_name_loc_lang="";
			String	patient_name_loc_lang="";
			String	patient_long_name="";
			String	patient_long_name_loc_lang="";
			String	trans_exceed_reason_code="";
			/*Added by Thamizh selvi on 23rd May 2017 for ML-MMOH-CRF-0610 Start*/
			String	appt_added_date="";
			String	appt_added_by_id="";
			/*End*/
			String order_id1 =(String)passObjects.get("order_id1");//--[IN027165]--
			// String locale = p.getProperty("LOCALE");
			int no_of_slots_value=0;
			result = false ;
			int res10 =0,res11 =0,sec_srl_n0=0,res12 =0,res_up=0,del_count=0;
			ResultSet rsds=null;
			String time="",appDt="",care_locn_type_ind="",resource_class="",modifed_date_val="";
			boolean allow_process=true;
			boolean overlap_allow=true;
			sb = new StringBuffer("") ;
			sb.setLength(0);
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = p.getProperty( "login_user" ) ;
			String modifiedFacilityId = addedFacilityId ;
			String modifiedAtWorkstation = addedAtWorkstation ;
			String forApptRef="N";
			results = new java.util.HashMap() ;
			/*For allocation*/
			String to_clinic_alcn=(String) passObjects.get("to_clinic_alcn");
			String transfer_alcn_yn=(String) passObjects.get("transfer_alcn_yn");
			String to_pat_alcn_cat=(String) passObjects.get("to_pat_alcn_cat");
			String to_alcn_cat_code=(String) passObjects.get("to_alcn_cat_code");
			if(to_clinic_alcn==null || to_clinic_alcn.equals(""))
				to_clinic_alcn="";
			if(to_pat_alcn_cat==null || to_pat_alcn_cat.equals(""))
				to_pat_alcn_cat="";
			if(to_alcn_cat_code==null || to_alcn_cat_code.equals(""))
				to_alcn_cat_code="";
			if(transfer_alcn_yn==null || transfer_alcn_yn.equals(""))
				transfer_alcn_yn="N";
			int del_alcn_Count=0;
			int oa_appt_count=0;
			int ins_alcn_count=0;
			HashMap patInstructionsMap=(HashMap) passObjects.get("patInstructionsMap");
			HashMap prcInstructionMap=(HashMap) passObjects.get("prcInstructionMap");
			if(patInstructionsMap==null){
				patInstructionsMap=new HashMap();
			}
			if(prcInstructionMap==null){
				prcInstructionMap=new HashMap();
			}
			rule_based_tr=(String) passObjects.get("rule_based_tr");
			pract_override_reason=(String) passObjects.get("pract_override_reason");
			remarksForPractOverride = (String) passObjects.get("remarksForPractOverride"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			try{
				System.err.println("709-------modifyAppointmentDetails------inside try block---------->");

				// Taking the Serial number (del_count) from hre and inserting into oa_appt_del_tr for the new date and new time where condition.
				sql2 ="select nvl(max(srlno),0)+1 maxval from oa_appt_del_tr where facility_id=? and appt_ref_no=?";
				if (pstmt!=null) pstmt.close();
				if (rs!=null) rs.close();
				pstmt=con.prepareStatement(sql2);
				pstmt.setString(1, addedFacilityId) ;
				pstmt.setString(2, apptrefno);

				System.err.println("720------modifyAppointmentDetails-------sql2---------->"+sql2);
				
				rs=pstmt.executeQuery();
				
				System.err.println("724------modifyAppointmentDetails-------sql2---------->"+sql2);

				if (rs.next() && rs != null ) {
					del_count=rs.getInt("maxval");
				}
				String sql_op_clinic  = "select speciality_code from op_clinic where  facility_id= ? and clinic_code=?";
				if (pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql_op_clinic) ;
				pstmt.setString(1,facilityId);
				pstmt.setString(2,clinic_code_new);

				System.err.println("737------modifyAppointmentDetails-------sql_op_clinic---------->"+sql_op_clinic);

				rs   = pstmt.executeQuery();

				System.err.println("741------modifyAppointmentDetails-------sql_op_clinic---------->"+sql_op_clinic);

				if(rs!=null && rs.next()){
					speciality_code=rs.getString("speciality_code");
					if(speciality_code ==null) speciality_code="";
				}
				//Details of the appointment for a particular appt reference number is taken from oa_appt.
				//Modified by Suman from oa_appt_vw to oa_appt.
				final String sql1 ="select facility_id, appt_ref_no, clinic_code, practitioner_id,alcn_criteria,alcn_catg_code, appt_date, to_char(appt_time,'hh24:mi') appt_time, to_char(appt_slab_from_time,'hh24:mi') appt_slab_from_time, to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, to_char(appt_duration,'hh24:mi') appt_duration, appt_slots, patient_id, name_prefix, first_name, second_name, third_name,family_name, name_suffix, patient_name, gender, date_of_birth, res_tel_no,oth_contact_no, national_id_no,alt_id1_no, res_addr_line1, res_addr_line2, res_addr_line3,  res_addr_line4, postal_code, country_code, appt_type_code, overbooked_yn, referral_id, mode_of_contact,contact_reason_code, appt_remarks, appt_status, inpatient_yn, encounter_id,email_id,nvl(no_of_slots,0) no_of_slots,team_id,to_char(appt_date,'dd/mm/yyyy') appt_date1,ETHNIC_GROUP_CODE,FORCED_APPT_YN,CITIZEN_YN,LEGAL_YN,BIRTH_PLACE_CODE,BIRTH_PLACE_DESC,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,RES_COUNTRY_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,care_locn_type_ind,resource_class ,to_char (modified_date,'dd/mm/yyyy hh24:mi') modified_date,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,FAMILY_NAME_LOC_LANG,PATIENT_NAME_LOC_LANG,patient_long_name,patient_long_name_loc_lang,( SELECT visit_type_ind  FROM op_visit_type WHERE visit_type_code = oa_appt.appt_type_code AND facility_id = oa_appt.facility_id) VISIT_TYPE_IND , TRANSFERRED_APPT_YN,SERVICE_CODE,ORDER_ID,ORDER_LINE_NUM,SPECIALITY_CODE from_speciality,appt_category,PRACT_OVERRIDE_REASON,LANGUAGE_ID,TERM_CODE,TERM_SET_ID,PATIENT_CAT_CODE,rd_appt_yn,trans_exceed_reason_code, added_by_id,to_char (added_date,'dd/mm/yyyy hh24:mi:ss') added_date, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, alt_town_code, alt_region_code, alt_postal_code, alt_country_code from oa_appt where facility_id=? and appt_ref_no=?";//Modified by Thamizh selvi on 23rd May 2017 for ML-MMOH-CRF-0610 --added_by_id & added_date
				
				
				
				
				if (pstmt!=null) pstmt.close();
				if (rs!=null) rs.close();
				pstmt=con.prepareStatement(sql1);
				pstmt.setString(1,addedFacilityId.trim());
				pstmt.setString(2,apptrefno.trim());

				System.err.println("760-------modifyAppointmentDetails------sql1---------->"+sql1);

				rs=pstmt.executeQuery();

				System.err.println("764------modifyAppointmentDetails-------sql1---------->"+sql1);

				if (rs.next() && rs != null ){
					apptrefno1=rs.getString("appt_ref_no");
					clinic_code=rs.getString("clinic_code");
					practitionerid=rs.getString("practitioner_id")== null ? "" : rs.getString("practitioner_id") ;
					java.util.Date dateapd1=rs.getDate("appt_date");
					appDt=rs.getString("appt_date1");
					java.text.SimpleDateFormat formatterapd = new java.text.SimpleDateFormat("dd/MM/yyyy");
					apptdate=formatterapd.format(dateapd1);
					formatterapd = null;
					appttime=rs.getString("appt_time");
					if(appttime==null) appttime="00:00";
					apptslabfmtime=rs.getString("appt_slab_from_time");
					if(apptslabfmtime==null) apptslabfmtime="00:00";
					apptslabtotime=rs.getString("appt_slab_to_time");
					if(apptslabtotime==null) apptslabtotime="00:00";
					apptduration=rs.getString("appt_duration");
					if(apptduration==null) apptduration="00:00";
					team_id=rs.getString("team_id") ==null?"": rs.getString("team_id");
					frm_alc_criteria=rs.getString("alcn_criteria") ==null?"": rs.getString("alcn_criteria");
					frm_alc_cat_code=rs.getString("alcn_catg_code") ==null?"": rs.getString("alcn_catg_code");
					care_locn_type_ind=rs.getString("care_locn_type_ind");
					resource_class=rs.getString("resource_class");
					modifed_date_val=rs.getString("modified_date") ==null?"": rs.getString("modified_date");
					ethnic_grp_cd=rs.getString("ETHNIC_GROUP_CODE") ==null?"": rs.getString("ETHNIC_GROUP_CODE");
					ethnic_subgrp_cd=rs.getString("RACE_CODE")==null?"":rs.getString("RACE_CODE");
					citizen_yn=rs.getString("CITIZEN_YN");
					if(citizen_yn==null) citizen_yn="N";
					legal_yn=rs.getString("LEGAL_YN");
					if(legal_yn==null) legal_yn="N";
					birth_place_code=rs.getString("BIRTH_PLACE_CODE")==null?"":rs.getString("BIRTH_PLACE_CODE");
					birth_place_desc=rs.getString("BIRTH_PLACE_DESC")==null?"":rs.getString("BIRTH_PLACE_DESC");
					forced_appt_yn=rs.getString("FORCED_APPT_YN");
					if(forced_appt_yn==null) forced_appt_yn="N";
					global_appt_yn=rs.getString("GLOBAL_APPT_YN");
					if(global_appt_yn==null) global_appt_yn="N";
					res_town=rs.getString("RES_TOWN_CODE")==null?"":rs.getString("RES_TOWN_CODE");
					res_area=rs.getString("RES_AREA_CODE")==null?"":rs.getString("RES_AREA_CODE");
					res_region=rs.getString("RES_REGION_CODE")==null?"":rs.getString("RES_REGION_CODE");
					res_country=rs.getString("RES_COUNTRY_CODE")==null?"":rs.getString("RES_COUNTRY_CODE");
					mail_addr1=rs.getString("MAIL_ADDR_LINE1")==null?"":rs.getString("MAIL_ADDR_LINE1");
					mail_addr2=rs.getString("MAIL_ADDR_LINE2")==null?"":rs.getString("MAIL_ADDR_LINE2");
					mail_addr3=rs.getString("MAIL_ADDR_LINE3")==null?"":rs.getString("MAIL_ADDR_LINE3");
					mail_addr4=rs.getString("MAIL_ADDR_LINE4")==null?"":rs.getString("MAIL_ADDR_LINE4");
					mail_town=rs.getString("MAIL_TOWN_CODE")==null?"":rs.getString("MAIL_TOWN_CODE");
					mail_area=rs.getString("MAIL_AREA_CODE")==null?"":rs.getString("MAIL_AREA_CODE");
					mail_postal=rs.getString("MAIL_POSTAL_CODE")==null?"":rs.getString("MAIL_POSTAL_CODE");
					mail_region=rs.getString("MAIL_REGION_CODE")==null?"":rs.getString("MAIL_REGION_CODE");
					mail_country=rs.getString("MAIL_COUNTRY_CODE")==null?"":rs.getString("MAIL_COUNTRY_CODE");
					service_code=rs.getString("SERVICE_CODE")==null?"":rs.getString("SERVICE_CODE");
					order_id=rs.getString("ORDER_ID")==null?"":rs.getString("ORDER_ID");
					order_line_num=rs.getString("ORDER_LINE_NUM")==null?"":rs.getString("ORDER_LINE_NUM");
					apptslots=rs.getInt("appt_slots");
					patientid=rs.getString("patient_id")==null?"":rs.getString("patient_id");
					prefix=rs.getString("name_prefix");
					firstname=rs.getString("first_name");
					secondname=rs.getString("second_name");
					thirdname=rs.getString("third_name");
					familyname=rs.getString("family_name");
					suffix=rs.getString("name_suffix");
					patientname=rs.getString("patient_name");
					no_of_slots=rs.getString("no_of_slots");
					if (no_of_slots.equals("")) no_of_slots ="0";
					no_of_slots_value = Integer.parseInt(no_of_slots);
					gender=rs.getString("gender");
					java.util.Date date1 = rs.getDate("date_of_birth");
					if( date1 != null){
						java.text.SimpleDateFormat formatter1 = new java.text.SimpleDateFormat("dd/MM/yyyy");
						dateofbirth=formatter1.format(date1);
						formatter1 = null;
					}else{
						dateofbirth="";
					}
					restelno=rs.getString("res_tel_no")==null?"":rs.getString("res_tel_no");
					othtelno=rs.getString("oth_contact_no")==null?"":rs.getString("oth_contact_no");
					emailid=rs.getString("email_id")==null?"":rs.getString("email_id");
					nationalid=rs.getString("national_id_no")==null?"":rs.getString("national_id_no");
					alternateid=rs.getString("alt_id1_no")==null?"":rs.getString("alt_id1_no");
					resaddrl1=rs.getString("res_addr_line1")==null?"":rs.getString("res_addr_line1");
					resaddrl2=rs.getString("res_addr_line2")==null?"":rs.getString("res_addr_line2");
					resaddrl3=rs.getString("res_addr_line3")==null?"":rs.getString("res_addr_line3");
					resaddrl4=rs.getString("res_addr_line4")==null?"":rs.getString("res_addr_line4");
					postalcode=rs.getString("postal_code")==null?"":rs.getString("postal_code");
					impyn=rs.getString("inpatient_yn")==null?"":rs.getString("inpatient_yn");
					visitind_new=rs.getString("VISIT_TYPE_IND");
					TRANSFERRED_APPT_YN=rs.getString("TRANSFERRED_APPT_YN");
					if(from_bulk.equals("Y")){
						resaddrl1_new=resaddrl1;
						resaddrl2_new=resaddrl2;
						resaddrl3_new=resaddrl3;
						resaddrl4_new=resaddrl4;
						postalcode_new=postalcode;
						visitind=visitind_new;
						inpatient_yn=impyn;
					}
					countrycode=rs.getString("country_code")==null?"":rs.getString("country_code");
					appttypecode=rs.getString("appt_type_code")==null?"":rs.getString("appt_type_code");
					overbookedyn=rs.getString("overbooked_yn")==null?"":rs.getString("overbooked_yn");
					referralcode=rs.getString("referral_id")==null?"":rs.getString("referral_id");
					mode=rs.getString("mode_of_contact")==null?"":rs.getString("mode_of_contact");
					reasoncode=rs.getString("contact_reason_code")==null?"":rs.getString("contact_reason_code");
					apptremarks=rs.getString("appt_remarks")==null?"":rs.getString("appt_remarks");
					apptstatus="N";			
					name_prefix_loc_lang=rs.getString("NAME_PREFIX_LOC_LANG")==null?"":rs.getString("NAME_PREFIX_LOC_LANG");
					first_name_loc_lang=rs.getString("FIRST_NAME_LOC_LANG")==null?"":rs.getString("FIRST_NAME_LOC_LANG");
					second_name_loc_lang=rs.getString("SECOND_NAME_LOC_LANG")==null?"":rs.getString("SECOND_NAME_LOC_LANG");
					third_name_loc_lang=rs.getString("THIRD_NAME_LOC_LANG")==null?"":rs.getString("THIRD_NAME_LOC_LANG");
					name_suffix_loc_lang=rs.getString("NAME_SUFFIX_LOC_LANG")==null?"":rs.getString("NAME_SUFFIX_LOC_LANG");
					family_name_loc_lang=rs.getString("FAMILY_NAME_LOC_LANG")==null?"":rs.getString("FAMILY_NAME_LOC_LANG");
					patient_name_loc_lang=rs.getString("PATIENT_NAME_LOC_LANG")==null?"":rs.getString("PATIENT_NAME_LOC_LANG");
					patient_long_name=rs.getString("patient_long_name")==null?"":rs.getString("patient_long_name");
					patient_long_name_loc_lang=rs.getString("patient_long_name_loc_lang")==null?"":rs.getString("patient_long_name_loc_lang");
					from_speciality=rs.getString("from_speciality")==null?"":rs.getString("from_speciality");
					pract_override_reason_old = rs.getString("pract_override_reason")==null?"":rs.getString("pract_override_reason");
					language_id = rs.getString("LANGUAGE_ID")==null?"":rs.getString("LANGUAGE_ID");
					appt_category_old = rs.getString("appt_category")==null?"":rs.getString("appt_category");
					patient_cat_code = rs.getString("PATIENT_CAT_CODE")==null?"":rs.getString("PATIENT_CAT_CODE");
					term_code = rs.getString("TERM_CODE")==null?"":rs.getString("TERM_CODE");
					term_set_id = rs.getString("TERM_SET_ID")==null?"":rs.getString("TERM_SET_ID");
					rd_appt_yn = rs.getString("rd_appt_yn")==null?"":rs.getString("rd_appt_yn");
					trans_exceed_reason_code = rs.getString("trans_exceed_reason_code")==null?"":rs.getString("trans_exceed_reason_code");
					/*Added by Thamizh selvi on 23rd May 2017 for ML-MMOH-CRF-0610 Start*/
					appt_added_by_id = rs.getString("added_by_id")==null?"":rs.getString("added_by_id");
					appt_added_date = rs.getString("added_date")==null?"":rs.getString("added_date");
					/*End*/
					/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
					alt_addr_line1	= checkForNull(rs.getString("alt_addr_line1"));
					alt_addr_line2	= checkForNull(rs.getString("alt_addr_line2"));
					alt_addr_line3	= checkForNull(rs.getString("alt_addr_line3"));
					alt_addr_line4	= checkForNull(rs.getString("alt_addr_line4"));
					alt_town_code	= checkForNull(rs.getString("alt_town_code"));
					alt_area_code	= checkForNull(rs.getString("alt_area_code"));
					alt_region_code	= checkForNull(rs.getString("alt_region_code"));
					alt_postal_code	= checkForNull(rs.getString("alt_postal_code"));
					alt_country_code= checkForNull(rs.getString("alt_country_code"));
					/*End*/
				}
				// Over hre forced value will be N when we find both normal and forced appointment at a slot time. forApptRef is the reference number of a forced booking which consists of a number else a value of N.
				//Concurrency chk is done hre ie if more than one user try to transfer the same appt,then validation is fired over hre...
				int overlap_val=0;
				String chk_overlap="select 1 from dual where to_date('"+modified_date_time+"','dd/mm/yyyy hh24:mi') = to_date('"+modifed_date_val+"','dd/mm/yyyy hh24:mi')";
				pstmt_overlap=con.prepareStatement(chk_overlap);

				System.err.println("908------modifyAppointmentDetails-------chk_overlap---------->"+chk_overlap);

				rs=pstmt_overlap.executeQuery();

				System.err.println("912------modifyAppointmentDetails-------chk_overlap---------->"+chk_overlap);

				if(rs !=null && rs.next()){
					overlap_val=rs.getInt(1);
				}
				if(overlap_val>0){
					overlap_allow=true;
				}else{
					overlap_allow=false;
				}
				if(overlap_allow){
					if(forced.equals("Y") && from_bulk.equals("Y")){
						if(pstmt!=null)pstmt.close();
						if(rs!=null)rs.close();
						pstmt=con.prepareStatement("select count(*) COUNT from oa_appt where clinic_code='"+clinic_code_new+"' and practitioner_id='"+practitioner_id+"' and appt_date=to_date('"+new_date+"','dd/mm/yyyy') and appt_time = to_date('"+new_from_time+"','hh24:mi') and appt_slab_from_time=to_date('"+new_from_time+"','hh24:mi') and appt_slab_to_time=to_date('"+new_to_time+"','hh24:mi') and facility_id='"+facilityId+"'");
						
						System.err.println("929-----------modifyAppointmentDetails----------Before execution--->");
							rs=pstmt.executeQuery();

					    System.err.println("932-----------modifyAppointmentDetails------After Execution------->");

						if(rs!=null && rs.next()){
							String count=rs.getString("COUNT");
							if(!(count.equals("0"))){
								forced_appt_yn="Y";
							}else{
								forced_appt_yn="N";
							}
						}
					}
					if (rs!=null) rs.close();
					//Record is inserted into oa_appt_del_tr only if any appt is transferred or cancelled. this table consists of both old date and new transferred date.As and when the appts or transferred or cancelled the records keep incrementing for the same appt ref number.
					StringBuffer sql =new StringBuffer();
					sql.append(" insert into  oa_appt_del_tr(facility_id,appt_ref_no, srlno, clinic_code,practitioner_id, appt_date,appt_tr_date,appt_time,appt_slab_from_time,appt_slab_to_time,appt_slots,patient_id,name_prefix,first_name,second_name,third_name,family_name,name_suffix,patient_name,gender,date_of_birth,res_tel_no, oth_contact_no,email_id,national_id_no, alt_id1_no,res_addr_line1,res_addr_line2,res_addr_line3,res_addr_line4,postal_code,country_code,appt_type_code,overbooked_yn,referral_id,contact_reason_code,mode_of_contact,appt_remarks,appt_status,inpatient_yn,added_by_id,added_date,added_facility_id,added_at_ws_no,modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,reason_for_transfer,team_id,appt_duration,tr_practitioner_id,tr_appt_slab_from_time,tr_appt_slab_to_time,ETHNIC_GROUP_CODE,FORCED_APPT_YN,CITIZEN_YN,LEGAL_YN,BIRTH_PLACE_CODE,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,RES_COUNTRY_CODE,birth_place_desc,care_locn_type_ind,resource_class,name_prefix_loc_lang,first_name_loc_lang,second_name_loc_lang,third_name_loc_lang,name_suffix_loc_lang,family_name_loc_lang,patient_name_loc_lang,SPECIALITY_CODE,SERVICE_CODE,patient_long_name,patient_long_name_loc_lang,PATIENT_CAT_CODE,LANGUAGE_ID,APPT_CATEGORY,TERM_CODE,TERM_SET_ID,rd_appt_yn,trans_exceed_reason_code,appt_booked_by_id,appt_booked_date,alt_addr_line1,alt_addr_line2,alt_addr_line3,alt_addr_line4,alt_area_code,alt_town_code,alt_region_code,alt_postal_code,alt_country_code,tr_resource_class,remarks_for_transfer");//Modified by Thamizh selvi on 23rd May 2017 for ML-MMOH-CRF-0610 --appt_booked_by_id,appt_booked_date,tr_resource_class
					//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 --alternate address fields
					if(from_bulk.equals("Y")){
						sql.append(",bulk_transfer_yn,FROM_CLINIC_CODE,FROM_SPECIALITY_CODE");
					}else{
						sql.append(",FROM_CLINIC_CODE,FROM_SPECIALITY_CODE,pract_override_reason");
					}
					sql.append(" )values (?,?,?,?,?, to_date('"+apptdate+"','dd/mm/yyyy'),to_date('"+new_date+"','dd/mm/yyyy'),to_date('"+appttime+"','hh24:mi'), to_date('"+apptslabfmtime+"','hh24:mi'), to_date('"+apptslabtotime+"','hh24:mi'),?,?,?,?,?,?,?,?,?,?, to_date('"+dateofbirth+"','dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,to_date(?,'hh24:mi'),?,to_date('"+new_from_time+"','hh24:mi'),to_date('"+new_to_time+"','hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ");
					sql.append(",'"+patient_cat_code+"','"+language_id+"','"+appt_category_old+"','"+term_code+"','"+term_set_id+"','"+rd_appt_yn+"','"+trans_exceed_reason_code+"','"+appt_added_by_id+"',to_date('"+appt_added_date+"','dd/mm/yyyy hh24:mi:ss'), '"+alt_addr_line1+"','"+alt_addr_line2+"','"+alt_addr_line3+"','"+alt_addr_line4+"','"+alt_area_code+"','"+alt_town_code+"','"+alt_region_code+"','"+alt_postal_code+"','"+alt_country_code+"' ");//Modified by Thamizh selvi on 23rd May 2017 for ML-MMOH-CRF-0610
					
					/*Added by Thamizh selvi on 6th June 2017 for ML-MMOH-CRF-0610*/
					if(!function_mode.equals("")&&function_mode.equals("transfer"))
						sql.append(", '"+new_resource_class+"' ");
					else
						sql.append(", '"+res_class+"' ");
					/*End*/

					sql.append(", ? "); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

					if(from_bulk.equals("Y")){
						sql.append(",?,'"+clinic_code_from+"','"+from_speciality+"')");
					}else{
						sql.append(",'"+clinic_code+"','"+from_speciality+"','"+pract_override_reason_old+"')");// for Normal Transfer Also we will update from clinic and specialty
					}
					if(pstmt1!=null) pstmt1.close();
					pstmt1 = con.prepareStatement( sql.toString() );
					pstmt1.setString	( 1, addedFacilityId ) ;
					pstmt1.setString	( 2, apptrefno1 ) ;
					pstmt1.setInt	    ( 3, del_count ) ;
					pstmt1.setString	( 4, clinic_code_new ) ;
					pstmt1.setString	( 5, practitionerid ) ;
					pstmt1.setInt	    ( 6, apptslots ) ;
					pstmt1.setString	( 7, patientid ) ;
					pstmt1.setString	( 8, prefix ) ;
					pstmt1.setString	( 9, firstname ) ;
					pstmt1.setString	( 10, secondname ) ;
					pstmt1.setString	( 11, thirdname ) ;
					pstmt1.setString	( 12, familyname ) ;
					pstmt1.setString	( 13, suffix ) ;
					pstmt1.setString	( 14, patientname ) ;
					pstmt1.setString    ( 15, gender );
					pstmt1.setString    ( 16, restelno );
					pstmt1.setString    ( 17, othtelno );
					pstmt1.setString    ( 18, emailid );
					pstmt1.setString    ( 19, nationalid );
					pstmt1.setString    ( 20, alternateid );
					pstmt1.setString    ( 21, resaddrl1 );
					pstmt1.setString    ( 22, resaddrl2 );
					pstmt1.setString    ( 23, resaddrl3 );
					pstmt1.setString    ( 24, resaddrl4 );
					pstmt1.setString    ( 25, postalcode );
					pstmt1.setString    ( 26, countrycode );
					pstmt1.setString	( 27, appttypecode ) ;
					pstmt1.setString    ( 28, overbookedyn );
					pstmt1.setString    ( 29, referralcode );
					pstmt1.setString	( 30, reasoncode ) ;
					pstmt1.setString    ( 31, mode );
					pstmt1.setString    ( 32, apptremarks );
					pstmt1.setString	( 33, apptstatus ) ;
					pstmt1.setString    ( 34, impyn);
					pstmt1.setString    ( 35, addedById );
					pstmt1.setString	( 36, addedFacilityId ) ;
					pstmt1.setString	( 37, addedAtWorkstation  ) ;
					pstmt1.setString	( 38, addedById ) ;
					pstmt1.setString    ( 39, addedFacilityId );
					pstmt1.setString	( 40, addedAtWorkstation ) ;
					pstmt1.setString	( 41, reasonforrevision ) ;
					pstmt1.setString	( 42, team_id ) ;
					pstmt1.setString	( 43, apptduration ) ;
					pstmt1.setString	( 44, practitioner_id ) ;
					pstmt1.setString	( 45, ethnic_grp_cd ) ;
					pstmt1.setString	( 46, forced_appt_yn ) ;
					pstmt1.setString	( 47, citizen_yn ) ;
					pstmt1.setString	( 48, legal_yn ) ;
					pstmt1.setString	( 49, birth_place_code ) ;
					pstmt1.setString	( 50, ethnic_subgrp_cd ) ;
					pstmt1.setString	( 51, global_appt_yn ) ;
					pstmt1.setString	( 52, res_area ) ;
					pstmt1.setString	( 53, res_town ) ;
					pstmt1.setString	( 54, res_region ) ;
					pstmt1.setString	( 55, mail_addr1 ) ;
					pstmt1.setString	( 56, mail_addr2 ) ;
					pstmt1.setString	( 57, mail_addr3 ) ;
					pstmt1.setString	( 58, mail_addr4 ) ;
					pstmt1.setString	( 59, mail_area ) ;
					pstmt1.setString	( 60, mail_town ) ;
					pstmt1.setString	( 61, mail_region ) ;
					pstmt1.setString	( 62, mail_postal ) ;
					pstmt1.setString	( 63, mail_country ) ;
					pstmt1.setString	( 64, res_country ) ;
					pstmt1.setString	( 65, birth_place_desc ) ;
					pstmt1.setString	( 66, care_locn_type_ind ) ;
					pstmt1.setString	( 67, resource_class ) ;
					pstmt1.setString	( 68, name_prefix_loc_lang ) ;
					pstmt1.setString	( 69, first_name_loc_lang ) ;
					pstmt1.setString	( 70, second_name_loc_lang ) ;
					pstmt1.setString	( 71, third_name_loc_lang ) ;
					pstmt1.setString	( 72, name_suffix_loc_lang ) ;
					pstmt1.setString	( 73, family_name_loc_lang ) ;
					pstmt1.setString	( 74, patient_name_loc_lang ) ;
					pstmt1.setString	( 75, speciality_code ) ;
					pstmt1.setString	( 76, service_code ) ;
					pstmt1.setString	( 77, patient_long_name ) ;
					pstmt1.setString	( 78, patient_long_name_loc_lang ) ;
					pstmt1.setString	( 79, remarksForRevision ) ;
					if(from_bulk.equals("Y")){
						pstmt1.setString	( 80, "Y" ) ;
					}

					System.err.println("1055----------modifyAppointmentDetails-------sql------>"+sql.toString());

					int resu = pstmt1.executeUpdate() ;

					System.err.println("1059----------modifyAppointmentDetails-------sql------>"+sql.toString());	
					
					//included for Bru-HIMS-CRF 169
					if(resu != 0 && !(from_bulk.equals("Y"))){
						if(patCnclCount !=null && patCnclCount.equals("0")){
						result=updateOAPatCnclSummary(con,patientid,addedFacilityId,patCnclCount,"","Modify",addedById,addedAtWorkstation);
						}
					}
					if(resu !=0){
						result = true ;
						if(from_bulk.equals("Y")){
						}else{
							String deletePatInstructions="delete FROM oa_appt_pat_instructions WHERE facility_id = ? and APPT_REF_NO = ?";
							pstmt=con.prepareStatement(deletePatInstructions);
							//res_up =pstmt.executeUpdate();
							pstmt.setString(1,facilityId);
							pstmt.setString(2,apptrefno);

							System.err.println("1078-------modifyAppointmentDetails------deletePatInstructions---------->"+deletePatInstructions);

							pstmt.executeUpdate();

								System.err.println("1082---modifyAppointmentDetails----------deletePatInstructions---------->"+deletePatInstructions);
								System.err.println("1083----modifyAppointmentDetails--------patInstructionsMap---------->"+patInstructionsMap);
								
							//updating oa_appt_pat_instructions Strat
							if(patInstructionsMap!=null && !(patInstructionsMap.isEmpty())){
								String oa_pat_ins="insert into oa_appt_pat_instructions(facility_id, appt_ref_no, instruction_id, instruction_desc, display_order, added_by_id, added_date,added_facility_id, added_at_ws_no, modified_by_id, modified_date,modified_facility_id, modified_at_ws_no)values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
								pstmt = con.prepareStatement( oa_pat_ins);
								int recCount=patInstructionsMap.size();
								int executableCount=0;
								for(int cnt=1;cnt<=recCount;cnt++){
									Integer integer=new Integer(cnt);
									String instId="";
									//int instorder=cnt;
									String instDesc="";
									String checkYN="";
									String mapValue=(String)patInstructionsMap.get(integer.toString());
									/*StringTokenizer token1=new StringTokenizer(mapValue, "|~");
									while (token1.hasMoreTokens()){
										instId=token1.nextToken();
										instDesc=token1.nextToken();
										if(instDesc.equals("*!*")){
											instDesc="";
										}
										checkYN=token1.nextToken();
									}*/
									String[] tokens=mapValue.split("\\|~");
									instId=tokens[0];
									instDesc=tokens[1];
									checkYN=tokens[2];
									if(instDesc.equals("*!*")){
										instDesc="";
									}
									if(checkYN.equals("Y")){
										executableCount=executableCount+1;
										pstmt.setString	( 1,  facilityId ) ;
										pstmt.setString	( 2,  apptrefno ) ;
										pstmt.setString	( 3,  instId ) ;
										pstmt.setString	( 4,  instDesc ) ;
										pstmt.setInt	( 5,  executableCount ) ;
										pstmt.setString ( 6, addedById );
										pstmt.setString	( 7, modifiedFacilityId ) ;
										pstmt.setString	( 8, modifiedAtWorkstation  ) ;
										pstmt.setString	( 9, addedById ) ;
										pstmt.setString ( 10, modifiedFacilityId );
										pstmt.setString	( 11, modifiedAtWorkstation ) ;
										pstmt.addBatch();
									}
								}
								if(executableCount >0){

									System.err.println("1133----modifyAppointmentDetails--------oa_pat_ins---------->"+oa_pat_ins);

									int resultArr[]=pstmt.executeBatch(); 

									System.err.println("1137----modifyAppointmentDetails--------resultArr---------->"+resultArr.length);
									
									if(resultArr.length!=0){
										result=true;
									}else{
										result=false;
									}
								}
							}
							String deletePrcInstructions="delete FROM oa_appt_proc_instructions WHERE facility_id=? and APPT_REF_NO=?";
							pstmt=con.prepareStatement(deletePrcInstructions);
							pstmt.setString(1,facilityId);
							pstmt.setString(2,apptrefno);

							System.err.println("1151-------modifyAppointmentDetails--------deletePrcInstructions---------->"+deletePrcInstructions);

							pstmt.executeUpdate();

							System.err.println("1155-------modifyAppointmentDetails--------deletePrcInstructions---------->"+deletePrcInstructions);

							//res_up =pstmt.executeUpdate();

							System.err.println("1159-------modifyAppointmentDetails--------result---------->"+result);

							if(result){

								System.err.println("1163------modifyAppointmentDetails---------prcInstructionMap---------->"+prcInstructionMap);

								if(prcInstructionMap!=null && !(prcInstructionMap.isEmpty())){
									String oa_prc_ins="insert into OA_APPT_PROC_INSTRUCTIONS(INSTRN_SRL_NO,facility_id, appt_ref_no, instruction_desc,added_by_id, added_date,added_facility_id, added_at_ws_no, modified_by_id, modified_date,modified_facility_id, modified_at_ws_no)values(1,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
									String checked=(String)prcInstructionMap.get("checked");
									String prcDesc=(String)prcInstructionMap.get("prcIns");
									if(checked!=null && checked.equals("Y")){
										pstmt = con.prepareStatement( oa_prc_ins);
										pstmt.setString	( 1,  facilityId ) ;
										pstmt.setString	( 2,  apptrefno ) ;
										pstmt.setString	( 3,  prcDesc ) ;
										pstmt.setString ( 4, addedById );
										pstmt.setString	( 5, modifiedFacilityId ) ;
										pstmt.setString	( 6, modifiedAtWorkstation  ) ;
										pstmt.setString	( 7, addedById ) ;
										pstmt.setString ( 8, modifiedFacilityId );
										pstmt.setString	( 9, modifiedAtWorkstation ) ;

                                         System.err.println("1181--------modifyAppointmentDetails-------oa_prc_ins---------->"+oa_prc_ins);

										res_up=pstmt.executeUpdate() ; 

										 System.err.println("1185--------modifyAppointmentDetails-------oa_prc_ins---------->"+oa_prc_ins);

										if(res_up!=1){
											result=true;
										}else{
											result=false;
										}
									}
								}
							}

							//End of updating oa_app_apt_instrcutions
						}
						/*pstmt_del_fm = con.prepareStatement("DELETE FROM FM_PULLING_LIST WHERE FACILITY_ID='"+addedFacilityId+"' AND APPT_REF_NO='"+apptrefno1+"'");	
						res_del_fm =pstmt_del_fm.executeUpdate();*/					
						
						 System.err.println("1201-------modifyAppointmentDetails--------sec_resources---------->"+sec_resources);
						 System.err.println("1202-------modifyAppointmentDetails--------sec_final_value---------->"+sec_final_value);

						if(sec_resources.size()>0 || !sec_final_value.equals("")){
							//To get serial number for insertion into oa_resource_for_appt_del_tr
							String SQl = "select nvl(max(srl_no),0)+1 maxnum from oa_resource_for_appt_del_tr where facility_id=? and appt_ref_no = ?";
							if (pstmt1!=null) pstmt1.close();
							pstmt1 = con.prepareStatement( SQl );
							pstmt1.setString	( 1, addedFacilityId ) ;
							pstmt1.setString	( 2, apptrefno1 ) ;

							System.err.println("1213------modifyAppointmentDetails---------SQl---------->"+SQl);

							rSsrl = pstmt1.executeQuery();

							System.err.println("1217-------modifyAppointmentDetails--------SQl---------->"+SQl);

							int srl_no=0;
							if(rSsrl!=null&&rSsrl.next()){
								srl_no = rSsrl.getInt("maxnum");
							}
							//To get Details of the Secondary Resources associated with the Appointment of a patient.
							if(rSsrl !=null) rSsrl.close();
							String SqlSt ="select facility_id,appt_ref_no,resource_class,resource_id,resource_type,to_char(appt_date,'dd/mm/yyyy') appt_date ,to_char(appt_time,'dd/mm/yyyy HH24:mi') appt_time,to_char(appt_slab_from_time,'dd/mm/yyyy HH24:mi') appt_slab_from_time,to_char(appt_slab_to_time,'dd/mm/yyyy HH24:mi') appt_slab_to_time,to_char(appt_duration,'dd/mm/yyyy HH24:mi') appt_duration,appt_slots,booking_type from oa_resource_for_appt where facility_id = ? and appt_ref_no = ?";
							pStmt=con.prepareStatement(SqlSt);
							pStmt.setString(1,addedFacilityId);
							pStmt.setString(2,apptrefno1);

							System.err.println("1233-------modifyAppointmentDetails--------SqlSt---------->"+SqlSt);

							rSet_sec=pStmt.executeQuery();

							System.err.println("1237-------modifyAppointmentDetails--------SqlSt---------->"+SqlSt);

							if(rSet_sec!=null){
								//Updation of records in oa_clinic_schedule for secondary resources ie hre old record is updated with visit_type -1 ----> Decrementation part.(Execution at line 651)
								String SqlUp_sec_stat_dec="update oa_clinic_schedule set  total_slots_booked  = nvl(total_slots_booked,0)-"+1+",total_first_visit=nvl(total_first_visit,0)-decode('"+visitind+"','F',"+1+",0), TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)-decode('"+visitind+"','F',"+1+",0),total_follow_up=nvl(total_follow_up,0)-decode('"+visitind+"','L',"+1+",0),total_routine=nvl(total_routine,0)-decode('"+visitind+"','R',"+1+",0),total_series=nvl(total_series,0)-decode('"+1+"','S',"+1+",0),total_consult=nvl(total_consult,0)-decode('"+visitind+"','C',"+1+",0),total_emergency=nvl(total_emergency,0)-decode('"+visitind+"','E',"+1+",0),MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+addedFacilityId+"' and clinic_code='"+clinic_code+"'  and clinic_date= to_date(?,'DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class=? and primary_resource_yn='N'";
								pst_SqlUp_sec_stat_dec = con.prepareStatement( SqlUp_sec_stat_dec );
								// To get serial number from oa_resource_for_appt ie wrt Secondary Resources.(Execution at line 653)
								final String sqlmaxSec="select nvl(max(srl_no),1) max_no from oa_resource_for_appt where facility_id='"+addedFacilityId+"' and appt_ref_no='"+apptrefno1+"'";
								pst_sqlmaxSec = con.prepareStatement( sqlmaxSec );
								//Delete the old record from oa_resource_for_appt.(Execution at step 657)
								pst_del_oa_re_appt = con.prepareStatement( "delete from  oa_resource_for_appt   where facility_id='"+ addedFacilityId +"' and  appt_ref_no='"+apptrefno1+"'");
								//Record is inserted into oa_resource_for_appt_del_tr for every transfer of an appointment.(Execution at line 673)
								String sql_insres_for_appt="insert into oa_resource_for_appt_del_tr (facility_id,appt_ref_no,srl_no,resource_class,resource_id,resource_type,appt_date,appt_time,appt_slab_from_time,appt_slab_to_time,appt_duration,appt_slots,booking_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?, '"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+addedFacilityId+"', '"+modifiedById+"', sysdate,'"+modifiedAtWorkstation+"','"+modifiedFacilityId+"')" ;
								pst_sql_insres_for_appt = con.prepareStatement( sql_insres_for_appt );
								while (rSet_sec.next()) {
									String sec_facility_id1=rSet_sec.getString("facility_id");
									String sec_appt_ref_no1=rSet_sec.getString("appt_ref_no");
									String sec_resource_class1=rSet_sec.getString("resource_class");
									String sec_resource_id1=rSet_sec.getString("resource_id");
									if(sec_resource_id1==null) sec_resource_id1="";
									String sec_resource_type1=rSet_sec.getString("resource_type");
									if(sec_resource_type1==null) sec_resource_type1="";
									String sec_appt_date1=rSet_sec.getString("appt_date");
									String sec_appt_time1=rSet_sec.getString("appt_time");
									String sec_appt_slab_from_time1=rSet_sec.getString("appt_slab_from_time");
									String sec_appt_slab_to_time1=rSet_sec.getString("appt_slab_to_time");
									String sec_appt_duration1=rSet_sec.getString("appt_duration");
									String sec_appt_slots1=rSet_sec.getString("appt_slots");
									if(sec_appt_slots1==null) sec_appt_slots1="";
									String sec_booking_type1=rSet_sec.getString("booking_type");
									pst_SqlUp_sec_stat_dec.setString(1,sec_appt_date1);
									pst_SqlUp_sec_stat_dec.setString(2,sec_resource_id1);
									pst_SqlUp_sec_stat_dec.setString(3,sec_resource_class1);

									System.err.println("1275--------modifyAppointmentDetails-------SqlUp_sec_stat_dec---------->"+SqlUp_sec_stat_dec);
									res_up =pst_SqlUp_sec_stat_dec.executeUpdate(); 

									System.err.println("1278--------modifyAppointmentDetails-------SqlUp_sec_stat_dec---------->"+SqlUp_sec_stat_dec);
									System.err.println("1279--------modifyAppointmentDetails-------sqlmaxSec---------->"+sqlmaxSec);

									rsds=pst_sqlmaxSec.executeQuery();

									System.err.println("1283--------modifyAppointmentDetails-------sqlmaxSec---------->"+sqlmaxSec);

									rsds.next();
									sec_srl_n0=rsds.getInt("max_no");

									System.err.println("1288--------modifyAppointmentDetails-------Before execute----pst_del_oa_re_appt------>");

									res_up =pst_del_oa_re_appt.executeUpdate();

									System.err.println("1292--------modifyAppointmentDetails-------After Execute----pst_del_oa_re_appt------>");
									
									pst_sql_insres_for_appt.setString(1,sec_facility_id1);
									pst_sql_insres_for_appt.setString(2,sec_appt_ref_no1);
									pst_sql_insres_for_appt.setInt(3,srl_no);
									pst_sql_insres_for_appt.setString(4,sec_resource_class1);
									pst_sql_insres_for_appt.setString(5,sec_resource_id1);
									pst_sql_insres_for_appt.setString(6,sec_resource_type1);
									pst_sql_insres_for_appt.setString(7,sec_appt_date1);
									pst_sql_insres_for_appt.setString(8,sec_appt_time1);
									pst_sql_insres_for_appt.setString(9,sec_appt_slab_from_time1);
									pst_sql_insres_for_appt.setString(10,sec_appt_slab_to_time1);
									pst_sql_insres_for_appt.setString(11,sec_appt_duration1);
									pst_sql_insres_for_appt.setString(12,sec_appt_slots1);
									pst_sql_insres_for_appt.setString(13,sec_booking_type1);

									System.err.println("1308--------modifyAppointmentDetails-------sql_insres_for_appt---------->"+sql_insres_for_appt);
									
									res_up = pst_sql_insres_for_appt.executeUpdate() ;

									System.err.println("1312--------modifyAppointmentDetails-------sql_insres_for_appt---------->"+sql_insres_for_appt);
									srl_no++;
								} // while for sec in oa_appt
							} // if for sec in oa_appt
						}
						if(forced.equals("N")){
							if(!(forced_val.equals("TB")&&forced_appt_yn.equals("Y"))){
								String sqlFr = null;
								if(practitionerid.equals("")){
									sqlFr = "select nvl(appt_ref_no,'N') apnno  from OA_Appt where facility_id=? and clinic_code = ? and appt_date=to_Date(?,'dd/mm/yyyy') and APPT_SLAB_FROM_TIME =to_Date(?,'HH24:mi') and APPT_SLAB_TO_TIME<=to_Date(?,'HH24:mi') and FORCED_APPT_YN='Y' and care_locn_type_ind=? and resource_class=? and practitioner_id is null";
								}else{
									sqlFr = "select nvl(appt_ref_no,'N') apnno  from OA_Appt where facility_id=? and clinic_code = ? and appt_date=to_Date(?,'dd/mm/yyyy') and APPT_SLAB_FROM_TIME =to_Date(?,'HH24:mi') and APPT_SLAB_TO_TIME<=to_Date(?,'HH24:mi') and FORCED_APPT_YN='Y' and care_locn_type_ind=? and resource_class=? and practitioner_id = ?";
								}
								if (rs!=null) rs.close();
								if (pstmt1!=null) pstmt1.close();
								pstmt1 = con.prepareStatement( sqlFr );
								pstmt1.setString	( 1, addedFacilityId ) ;
								pstmt1.setString	( 2, clinic_code ) ;
								pstmt1.setString	( 3, appDt ) ;
								pstmt1.setString	( 4, apptslabfmtime ) ;
								pstmt1.setString	( 5, apptslabtotime ) ;
								pstmt1.setString	( 6, clinic_type ) ;
								pstmt1.setString	( 7, res_class ) ;
								if(!practitionerid.equals("")){
									pstmt1.setString	( 8, practitionerid ) ;
								}
								System.err.println("1339---modifyAppointmentDetails------sqlFr----------->"+sqlFr);

								rs = pstmt1.executeQuery();

								System.err.println("1343-----modifyAppointmentDetails----sqlFr----------->"+sqlFr);

								if(rs!=null&&rs.next()){
									forApptRef = rs.getString("apnno");
								}
							}
						}
						if(rs !=null ) rs.close();
						if(rSet_sec !=null) rSet_sec.close();
						String upd="";
						if(!time_table_type.equals("3")){
							if(forApptRef.equals("N")){
								// Normal Appointment is updated with status and primary appt ref number as null.
								upd="update oa_clinic_schedule_slot_slab set SCHEDULE_STATUS='',pri_appt_ref_no='',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where pri_appt_ref_no=? and SCHEDULE_STATUS='1'  and facility_id=?";
								if (pstmt3!=null) pstmt3.close();
								pstmt3= con.prepareStatement(upd);
								pstmt3.setString(1,apptrefno);
								pstmt3.setString(2,addedFacilityId);

								System.err.println("1364----modifyAppointmentDetails-----upd----------->"+upd);

								res_up=pstmt3.executeUpdate();

								System.err.println("1368----modifyAppointmentDetails-----upd----------->"+upd);
							}else{
								if (pStmt!=null) pStmt.close();
								// Serial number of Normal Appointment is taken depending on no of slots that appt consists.								
								if(practitionerid.equals("")){
									slot_slab_srlNO = "select srl_no slno from oa_clinic_schedule_slot_slab where pri_appt_ref_no='"+apptrefno+"' and SCHEDULE_STATUS='1'  and facility_id='"+addedFacilityId+"' and clinic_code='"+clinic_code+"' and clinic_date= to_date('"+apptdate+"','DD/MM/YYYY') and practitioner_id is null and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' order by srl_no";
									pStmt=con.prepareStatement(slot_slab_srlNO);
								}else{
									slot_slab_srlNO = "select srl_no slno from oa_clinic_schedule_slot_slab where pri_appt_ref_no='"+apptrefno+"' and SCHEDULE_STATUS='1'  and facility_id='"+addedFacilityId+"' and clinic_code='"+clinic_code+"' and clinic_date= to_date('"+apptdate+"','DD/MM/YYYY') and practitioner_id = '"+practitionerid+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' order by srl_no";
									pStmt=con.prepareStatement(slot_slab_srlNO);
								}

								System.err.println("1381----modifyAppointmentDetails-----slot_slab_srlNO----------->"+slot_slab_srlNO);

								rSet=pStmt.executeQuery(); 

								System.err.println("1385-----modifyAppointmentDetails----slot_slab_srlNO----------->"+slot_slab_srlNO);

								String slno="";
								if(rSet != null && rSet.next()) {
									slno=rSet.getString("slno");
								}
								//For each of the Serial number forced booking is changed to a normal booking
								//upd="update oa_clinic_schedule_slot_slab set SCHEDULE_STATUS='1',pri_appt_ref_no='"+forApptRef+"' where pri_appt_ref_no='"+apptrefno+"' and SCHEDULE_STATUS='1'  and facility_id='"+addedFacilityId+"' and clinic_code='"+clinic_code+"' and trunc(clinic_date)= to_date('"+apptdate+"','DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl('"+practitionerid+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and srl_no='"+slno+"'"; commented as part of tuning
								if(practitionerid.equals("")){
									upd="update oa_clinic_schedule_slot_slab set SCHEDULE_STATUS='1',pri_appt_ref_no='"+forApptRef+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where pri_appt_ref_no='"+apptrefno+"' and SCHEDULE_STATUS='1'  and facility_id='"+addedFacilityId+"' and clinic_code='"+clinic_code+"' and clinic_date= to_date('"+apptdate+"','DD/MM/YYYY') and practitioner_id is null and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and srl_no='"+slno+"'";
								}else{
									upd="update oa_clinic_schedule_slot_slab set SCHEDULE_STATUS='1',pri_appt_ref_no='"+forApptRef+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where pri_appt_ref_no='"+apptrefno+"' and SCHEDULE_STATUS='1'  and facility_id='"+addedFacilityId+"' and clinic_code='"+clinic_code+"' and clinic_date= to_date('"+apptdate+"','DD/MM/YYYY') and practitioner_id ='"+practitionerid+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and srl_no='"+slno+"'";
								}
								if (pstmt3!=null) pstmt3.close();
								pstmt3= con.prepareStatement(upd);

								System.err.println("1403-----modifyAppointmentDetails----upd----------->"+upd);

								res_up=pstmt3.executeUpdate();

								System.err.println("1407-----modifyAppointmentDetails----upd----------->"+upd);

								//If any other record exists for the old appt then status and primary appt ref number is nullified.
								upd="update oa_clinic_schedule_slot_slab set SCHEDULE_STATUS='',pri_appt_ref_no='',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where pri_appt_ref_no=? and SCHEDULE_STATUS='1'  and facility_id=?";
								if (pstmt3!=null) pstmt3.close();
								pstmt3= con.prepareStatement(upd);
								pstmt3.setString(1,apptrefno);
								pstmt3.setString(2,addedFacilityId);

								System.err.println("1417----modifyAppointmentDetails-----upd----------->"+upd);

								res_up=pstmt3.executeUpdate();

								System.err.println("1421-----modifyAppointmentDetails----upd----------->"+upd);
							}
						}// free format check
						if(!time_table_type.equals("3")){
							if(new_from_time.equals(new_to_time)){
							}else{ 
								if(!forced_appt_yn.equals("Y")){
							
								//if(practitionerid.equals("")){
								//Above line commented and below line for ML-BRU-SCF-1602 [IN:055253]
								if(practitioner_id.equals("")){ 
								    //Added ML-BRU-SCF-1602 [IN:055253]
								    if(!function_mode.equals("")&&function_mode.equals("transfer")){
									slot_slab_srlNO = "select srl_no slno from oa_clinic_schedule_slot_slab where SCHEDULE_STATUS is null and facility_id='"+modifiedFacilityId+"' and clinic_code='"+clinic_code_new+"' and clinic_date= to_date('"+new_date+"','DD/MM/YYYY') and practitioner_id is null and care_locn_type_ind='"+clinic_type+"' and resource_class='"+new_resource_class+"' and SCHEDULE_STATUS is null  and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+new_from_time+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+new_to_time+"','hh24:mi') AND (ext_slot_yn != 'Y' OR ext_slot_yn IS NULL) order by srl_no";
									
									}else{
									slot_slab_srlNO = "select srl_no slno from oa_clinic_schedule_slot_slab where SCHEDULE_STATUS is null and facility_id='"+modifiedFacilityId+"' and clinic_code='"+clinic_code_new+"' and clinic_date= to_date('"+new_date+"','DD/MM/YYYY') and practitioner_id is null and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and SCHEDULE_STATUS is null  and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+new_from_time+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+new_to_time+"','hh24:mi') AND (ext_slot_yn != 'Y' OR ext_slot_yn IS NULL) order by srl_no";
                                    
									}
									//End ML-BRU-SCF-1602 [IN:055253]
									
									pStmt=con.prepareStatement(slot_slab_srlNO);
								}else{
								   //Added ML-BRU-SCF-1602 [IN:055253]
								    if(!function_mode.equals("")&&function_mode.equals("transfer")){			
								  	slot_slab_srlNO = "select srl_no slno from oa_clinic_schedule_slot_slab where SCHEDULE_STATUS is null and facility_id='"+modifiedFacilityId+"' and clinic_code='"+clinic_code_new+"' and clinic_date= to_date('"+new_date+"','DD/MM/YYYY') and practitioner_id = '"+practitioner_id+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+new_resource_class+"' and SCHEDULE_STATUS is null  and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+new_from_time+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+new_to_time+"','hh24:mi') AND (ext_slot_yn != 'Y' OR ext_slot_yn IS NULL) order by srl_no";
									
									}else{
									slot_slab_srlNO = "select srl_no slno from oa_clinic_schedule_slot_slab where SCHEDULE_STATUS is null and facility_id='"+modifiedFacilityId+"' and clinic_code='"+clinic_code_new+"' and clinic_date= to_date('"+new_date+"','DD/MM/YYYY') and practitioner_id = '"+practitioner_id+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and SCHEDULE_STATUS is null  and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+new_from_time+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+new_to_time+"','hh24:mi') AND (ext_slot_yn != 'Y' OR ext_slot_yn IS NULL) order by srl_no";
                                    
									}
									//End ML-BRU-SCF-1602 [IN:055253]
									pStmt=con.prepareStatement(slot_slab_srlNO);
								}

								System.err.println("1457---modifyAppointmentDetails------slot_slab_srlNO----------->"+slot_slab_srlNO);

								rSet=pStmt.executeQuery();

								System.err.println("1461----modifyAppointmentDetails-----slot_slab_srlNO----------->"+slot_slab_srlNO);

								String slno="";
								if(rSet != null && rSet.next()) {
									slno=rSet.getString("slno");
								}
								// Updation of the record in oa_clinic_schedule_slot_slab for the new date.
								//String sql_up11=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+apptrefno1+"' where clinic_code='"+clinic_code_new+"' and facility_id= '"+addedFacilityId+"' and nvl(practitioner_id,'x')=nvl('"+practitioner_id+"','x') and trunc(clinic_date)=to_date('"+new_date+"','dd/mm/yyyy') and resource_class='"+res_class+"' and care_locn_type_ind='"+clinic_type+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+new_from_time+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+new_to_time+"','hh24:mi')";commented as part of tuning
								String sql_up11="";
								if(practitioner_id.equals("")){
								    //Added ML-BRU-SCF-1602 [IN:055253]
								    if(!function_mode.equals("")&&function_mode.equals("transfer")){								   
									sql_up11=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+apptrefno1+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_code='"+clinic_code_new+"' and facility_id= '"+addedFacilityId+"' and practitioner_id is null and clinic_date=to_date('"+new_date+"','dd/mm/yyyy') and resource_class='"+new_resource_class+"' and care_locn_type_ind='"+clinic_type+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+new_from_time+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+new_to_time+"','hh24:mi') and srl_no='"+slno+"' AND (ext_slot_yn != 'Y' OR ext_slot_yn IS NULL)";
									
								   }else{
								    sql_up11=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+apptrefno1+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_code='"+clinic_code_new+"' and facility_id= '"+addedFacilityId+"' and practitioner_id is null and clinic_date=to_date('"+new_date+"','dd/mm/yyyy') and resource_class='"+res_class+"' and care_locn_type_ind='"+clinic_type+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+new_from_time+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+new_to_time+"','hh24:mi') and srl_no='"+slno+"' AND (ext_slot_yn != 'Y' OR ext_slot_yn IS NULL)";
								   
								   }
								   //End ML-BRU-SCF-1602 [IN:055253]
								}else{
								  //Added ML-BRU-SCF-1602 [IN:055253]
                                  if(!function_mode.equals("")&&function_mode.equals("transfer")){								
									sql_up11=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+apptrefno1+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_code='"+clinic_code_new+"' and facility_id= '"+addedFacilityId+"' and practitioner_id ='"+practitioner_id+"' and clinic_date=to_date('"+new_date+"','dd/mm/yyyy') and resource_class='"+new_resource_class+"' and care_locn_type_ind='"+clinic_type+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+new_from_time+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+new_to_time+"','hh24:mi') and srl_no='"+slno+"' AND (ext_slot_yn != 'Y' OR ext_slot_yn IS NULL)";
									}else{
									     sql_up11=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+apptrefno1+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_code='"+clinic_code_new+"' and facility_id= '"+addedFacilityId+"' and practitioner_id ='"+practitioner_id+"' and clinic_date=to_date('"+new_date+"','dd/mm/yyyy') and resource_class='"+res_class+"' and care_locn_type_ind='"+clinic_type+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+new_from_time+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+new_to_time+"','hh24:mi') and srl_no='"+slno+"' AND (ext_slot_yn != 'Y' OR ext_slot_yn IS NULL)";
									}
									//End  ML-BRU-SCF-1602 [IN:055253]
								}
								if (pstmt3!=null) pstmt3.close();
								pstmt3 = con.prepareStatement( sql_up11 );

								System.err.println("1496----modifyAppointmentDetails-----sql_up11----------->"+sql_up11);

								res_up =pstmt3.executeUpdate();

								System.err.println("1500----modifyAppointmentDetails-----sql_up11----------->"+sql_up11);
								
								if ( res_up != 0 ) {
									result = true ;
								}else{
									sb.append("Transaction Failed in Primary Resources slot_slab");
									con.rollback();
								}
								}
							}
						}
						if(sec_resources.size()>0 || !sec_final_value.equals("")){
							// Updating oa_clinic_schedule for Secondary Resources 
							// Note : hre incrementation of the slots takes place.This query will be  executed in a for loop depending upon how many Secondary Resources are selected.(Execution at line 818)
							String sql_sec_stat_inc=" update oa_clinic_schedule set total_slots_booked  = nvl(total_slots_booked,0)+1,total_first_visit=nvl(total_first_visit,0)+decode('"+visitind+"','F',1,0),TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)+decode('"+visitind+"','F',1,0),total_follow_up=nvl(total_follow_up,0)+decode('"+visitind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visitind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visitind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visitind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visitind+"','E',1,0),MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+addedFacilityId+"' and clinic_code=? and clinic_date= to_date('"+new_date+"','DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class=? and primary_resource_yn='N' ";
										
							pstmt_sql_sec_stat_inc = con.prepareStatement( sql_sec_stat_inc );
								
							// Updation of oa_clinic_schedule_slot_slab table with Status as '1' and primary appt refrence number. (Execution at line 828) 

							

							String sql_sec_rstyp1="",sql_sec_rstyp2="",sql_sec_rstyp3="";
							
							//Query is executed only if the Secondary Resource class is 'P' ie Practitioner.(Execution at line 847)

							sql_sec_rstyp1  = "select pract_type res_type from am_practitioner where practitioner_id = ?" ;

							//Query is executed only if the Secondary Resource class is 'R' ie Room.
							//(Execution at line 854)

							sql_sec_rstyp2  = "select room_type res_type from am_facility_room where room_num = ? and OPERATING_FACILITY_ID='"+addedFacilityId+"'" ;

							//Query is executed only if the Secondary Resource class is 'E' or 'O' ie Eqipment Or Others (Execution at line  864)

							sql_sec_rstyp3  = "select resource_type res_type from am_resource where  resource_id = ? and facility_id= '"+addedFacilityId+"' and resource_Class=?" ;

							pstmt_sql_sec_rstyp1 = con.prepareStatement( sql_sec_rstyp1 );
							pstmt_sql_sec_rstyp2 = con.prepareStatement( sql_sec_rstyp2 );
							pstmt_sql_sec_rstyp3 = con.prepareStatement( sql_sec_rstyp3 );

							// Query to get the Appointment Duration of the Secondary Resource.(Execution at line  883)
								
							final String sqldssec="select get_time_between(to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi')) tmsc  from dual ";

							pstmt_sqldssec = con.prepareStatement( sqldssec );

							// Insertion of record into oa_resource_for_appt for the new date and time.(Execution at line 904)

							String ins_secondary_res=" insert into oa_resource_for_appt (facility_id,appt_ref_no,resource_class,resource_id,resource_type,appt_date,appt_time,appt_slab_from_time,appt_slab_to_time,appt_duration,appt_slots,booking_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,srl_no) values ('"+addedFacilityId+"','"+apptrefno1+"',?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),'','N', '"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+addedFacilityId+"', '"+modifiedById+"', sysdate,'"+modifiedAtWorkstation+"','"+modifiedFacilityId+"',?)";

							pstmt_ins_secondary_res = con.prepareStatement( ins_secondary_res );
							if(!from_bulk.equals("Y")){
								for(int xyz=0;xyz<sec_resources.size();xyz+=9){
									String sec_res_type="",timesec="";
									String sec_clinic_cd=(String) sec_resources.get(xyz);
									String sec_pract_id=(String) sec_resources.get(xyz+2);
									String sec_appt_dt=(String) sec_resources.get(xyz+3);
									String sec_res_class=(String) sec_resources.get(xyz+4);
									String sec_from_tm=(String) sec_resources.get(xyz+5);
									String sec_to_tm=(String) sec_resources.get(xyz+6);
									String sec_srl_no=(String) sec_resources.get(xyz+8);

									String sql_upop="";
									if(sec_pract_id.equals("")){
										sql_upop=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+apptrefno1+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_code=? and facility_id= '"+addedFacilityId+"' and practitioner_id is null and clinic_date=to_date(?,'dd/mm/yyyy') and resource_class=? and care_locn_type_ind='"+clinic_type+"' and srl_no =?";
									}else{
										sql_upop=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+apptrefno1+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_code=? and facility_id= '"+addedFacilityId+"'and clinic_date=to_date(?,'dd/mm/yyyy') and resource_class=? and care_locn_type_ind='"+clinic_type+"' and srl_no =?  and practitioner_id= ? ";
									}
									pstmt_sql_upop = con.prepareStatement( sql_upop );

									pstmt_sql_upop.setString(1,sec_clinic_cd);
									pstmt_sql_upop.setString(2,sec_appt_dt);
									pstmt_sql_upop.setString(3,sec_res_class);
									pstmt_sql_upop.setString(4,sec_srl_no);
									if(!sec_pract_id.equals("")){
										pstmt_sql_upop.setString(5,sec_pract_id);
									}

									System.err.println("1587----modifyAppointmentDetails-----sql_upop----------->"+sql_upop);

									res_up =pstmt_sql_upop.executeUpdate(); 

									System.err.println("1591------modifyAppointmentDetails---sql_upop----------->"+sql_upop);

									pstmt_sql_sec_stat_inc.setString(1,sec_clinic_cd);
									pstmt_sql_sec_stat_inc.setString(2,sec_pract_id);
									pstmt_sql_sec_stat_inc.setString(3,sec_res_class);

								    System.err.println("1597----modifyAppointmentDetails-----sql_sec_stat_inc----------->"+sql_sec_stat_inc);

									res_up =pstmt_sql_sec_stat_inc.executeUpdate(); 

									System.err.println("1601----modifyAppointmentDetails-----sql_sec_stat_inc----------->"+sql_sec_stat_inc);
									
									if ( res_up != 0 ) {
										result = true ;
									}else{
										sb.append("Transaction Failed in Secondary Resources slot_slab");
										con.rollback();
									}
									if(sec_res_class.equals("P")){
										if(rsds !=null) rsds.close();
										pstmt_sql_sec_rstyp1.setString(1,sec_pract_id);

										System.err.println("1613----modifyAppointmentDetails-----sql_sec_rstyp1----------->"+sql_sec_rstyp1);

										rsds=pstmt_sql_sec_rstyp1.executeQuery();

										System.err.println("1617----modifyAppointmentDetails-----sql_sec_rstyp1----------->"+sql_sec_rstyp1);

									}else if(sec_res_class.equals("R")){
										pstmt_sql_sec_rstyp2.setString(1,sec_pract_id);

										System.err.println("1622----modifyAppointmentDetails-----sql_sec_rstyp2----------->"+sql_sec_rstyp2);

										rsds=pstmt_sql_sec_rstyp2.executeQuery();

										System.err.println("1626----modifyAppointmentDetails-----sql_sec_rstyp2----------->"+sql_sec_rstyp2);

									}else{
										pstmt_sql_sec_rstyp3.setString(1,sec_pract_id);
										pstmt_sql_sec_rstyp3.setString(2,sec_res_class);

										System.err.println("1632----modifyAppointmentDetails-----sql_sec_rstyp3----------->"+sql_sec_rstyp3);

										rsds=pstmt_sql_sec_rstyp3.executeQuery();

										System.err.println("1636----modifyAppointmentDetails-----sql_sec_rstyp3----------->"+sql_sec_rstyp3);
									}
									if(rsds!=null && rsds.next()){
										sec_res_type = rsds.getString("res_type") ;
									}						
									if(rsds !=null) rsds.close();
									pstmt_sqldssec.setString(1,sec_appt_dt+" " +sec_from_tm);
									pstmt_sqldssec.setString(2,sec_appt_dt+" "+sec_to_tm);

									System.err.println("1647----modifyAppointmentDetails-----sqldssec----------->"+sqldssec);

									rsds=pstmt_sqldssec.executeQuery();

									System.err.println("1651----modifyAppointmentDetails-----sqldssec----------->"+sqldssec);

										if(rsds !=null && rsds.next())
									timesec=rsds.getString("tmsc");
									timesec=sec_appt_dt+" "+timesec;
									if (rsds!=null) rsds.close();
									pstmt_ins_secondary_res.setString(1,sec_res_class);
									pstmt_ins_secondary_res.setString(2,sec_pract_id);
									pstmt_ins_secondary_res.setString(3,sec_res_type);
									pstmt_ins_secondary_res.setString(4,sec_appt_dt);
									pstmt_ins_secondary_res.setString(5,sec_from_tm);
									pstmt_ins_secondary_res.setString(6,sec_from_tm);
									pstmt_ins_secondary_res.setString(7,sec_to_tm);
									pstmt_ins_secondary_res.setString(8,timesec);
									pstmt_ins_secondary_res.setInt(9,sec_srl_n0);

									System.err.println("1667----modifyAppointmentDetails-----ins_secondary_res----------->"+ins_secondary_res);

									resu = pstmt_ins_secondary_res.executeUpdate() ;

									System.err.println("1671----modifyAppointmentDetails-----ins_secondary_res----------->"+ins_secondary_res);
									
									if (pstmt!=null) pstmt.close();	
									sec_srl_n0++;
								}// End of for loop of normal transfer
							}else{
								StringTokenizer sec_final_value1=new StringTokenizer(sec_final_value,"@");
								while(sec_final_value1.hasMoreTokens()){
									String sec_sel_str1=sec_final_value1.nextToken();
									StringTokenizer sec_sel_st2 = new StringTokenizer(sec_sel_str1,",");
									while(sec_sel_st2.hasMoreTokens()){
										String tmp=sec_sel_st2.nextToken();
										if(tmp.equals("*"))
										tmp="";
										sec_resources.add(tmp);
									}
								}
								for (int c=0;c<sec_resources.size();c+=11 ){
									String sec_res_type="",timesec="";
									String sec_clinic_cd=(String) sec_resources.get(c);
									String sec_pract_id=(String) sec_resources.get(c+2);
									String sec_appt_dt=(String) sec_resources.get(c+3);
									String sec_res_class=(String) sec_resources.get(c+4);
									String sec_from_tm=(String) sec_resources.get(c+5);
									String sec_to_tm=(String) sec_resources.get(c+6);
									String sec_srl_no=(String) sec_resources.get(c+8);
									
									pstmt_sql_sec_stat_inc.setString(1,sec_clinic_cd);
									pstmt_sql_sec_stat_inc.setString(2,sec_pract_id);
									pstmt_sql_sec_stat_inc.setString(3,sec_res_class);

									System.err.println("1702----modifyAppointmentDetails-----sql_sec_stat_inc----------->"+sql_sec_stat_inc);

									res_up =pstmt_sql_sec_stat_inc.executeUpdate();

									System.err.println("1706----modifyAppointmentDetails-----sql_sec_stat_inc----------->"+sql_sec_stat_inc);

									//Added by S.Sathish for IN020869 on Saturday, April 24, 2010 starts here
									String sql_upop="";
									if(sec_pract_id.equals("")){
										sql_upop=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+apptrefno1+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_code=? and facility_id= '"+addedFacilityId+"' and practitioner_id is null and clinic_date=to_date(?,'dd/mm/yyyy') and resource_class=? and care_locn_type_ind='"+clinic_type+"' and srl_no =?";
									}else{
										sql_upop=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+apptrefno1+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_code=? and facility_id= '"+addedFacilityId+"'and clinic_date=to_date(?,'dd/mm/yyyy') and resource_class=? and care_locn_type_ind='"+clinic_type+"' and srl_no =?  and practitioner_id= ? ";
									}
									//Ends here
									pstmt_sql_upop = con.prepareStatement( sql_upop );
									pstmt_sql_upop.setString(1,sec_clinic_cd);
									pstmt_sql_upop.setString(2,sec_appt_dt);
									pstmt_sql_upop.setString(3,sec_res_class);
									pstmt_sql_upop.setString(4,sec_srl_no);
									if(!sec_pract_id.equals("")){ //Added by S.Sathish for IN020869 on Saturday, April 24, 2010 
										pstmt_sql_upop.setString(5,sec_pract_id);
									}

									System.err.println("1726----modifyAppointmentDetails-----sql_upop----------->"+sql_upop);

									res_up =pstmt_sql_upop.executeUpdate();

									System.err.println("1730----modifyAppointmentDetails-----sql_upop----------->"+sql_upop);
									
									if ( res_up != 0 ) {
										result = true ;
									}else{
										sb.append("Transaction Failed in Secondary Resources slot_slab");
										con.rollback();
									}
									if(sec_res_class.equals("P")){
										if(rsds !=null) rsds.close();
										pstmt_sql_sec_rstyp1.setString(1,sec_pract_id);

										System.err.println("1742----modifyAppointmentDetails-----sql_sec_rstyp1----------->"+sql_sec_rstyp1);

										rsds=pstmt_sql_sec_rstyp1.executeQuery();

										System.err.println("1746----modifyAppointmentDetails-----sql_sec_rstyp1----------->"+sql_sec_rstyp1);

									}else if(sec_res_class.equals("R")){
										pstmt_sql_sec_rstyp2.setString(1,sec_pract_id);

										System.err.println("1751----modifyAppointmentDetails-----sql_sec_rstyp2----------->"+sql_sec_rstyp2);

										rsds=pstmt_sql_sec_rstyp2.executeQuery();

										System.err.println("1755----modifyAppointmentDetails-----sql_sec_rstyp2----------->"+sql_sec_rstyp2);

									}else{
										pstmt_sql_sec_rstyp3.setString(1,sec_pract_id);
										pstmt_sql_sec_rstyp3.setString(2,sec_res_class);

										System.err.println("1761----modifyAppointmentDetails-----sql_sec_rstyp3----------->"+sql_sec_rstyp3);

										rsds=pstmt_sql_sec_rstyp3.executeQuery();

										System.err.println("1765----modifyAppointmentDetails-----sql_sec_rstyp3----------->"+sql_sec_rstyp3);
									}
									if(rsds!=null && rsds.next()){
										sec_res_type = rsds.getString("res_type") ;
									}	
									if(rsds !=null) rsds.close();
									pstmt_sqldssec.setString(1,sec_appt_dt+" " +sec_from_tm);
									pstmt_sqldssec.setString(2,sec_appt_dt+" "+sec_to_tm);

									System.err.println("1777----modifyAppointmentDetails-----sqldssec----------->"+sqldssec);

									rsds=pstmt_sqldssec.executeQuery();

									System.err.println("1781----modifyAppointmentDetails-----sqldssec----------->"+sqldssec);

										if(rsds !=null && rsds.next())
									timesec=rsds.getString("tmsc");
									timesec=sec_appt_dt+" "+timesec;
									if (rsds!=null) rsds.close();
									pstmt_ins_secondary_res.setString(1,sec_res_class);
									pstmt_ins_secondary_res.setString(2,sec_pract_id);
									pstmt_ins_secondary_res.setString(3,sec_res_type);
									pstmt_ins_secondary_res.setString(4,sec_appt_dt);
									pstmt_ins_secondary_res.setString(5,sec_from_tm);
									pstmt_ins_secondary_res.setString(6,sec_from_tm);
									pstmt_ins_secondary_res.setString(7,sec_to_tm);
									pstmt_ins_secondary_res.setString(8,timesec);
									pstmt_ins_secondary_res.setInt(9,sec_srl_n0);

									System.err.println("1797----modifyAppointmentDetails-----ins_secondary_res----------->"+ins_secondary_res);

									resu = pstmt_ins_secondary_res.executeUpdate() ;

									System.err.println("1801----modifyAppointmentDetails-----ins_secondary_res----------->"+ins_secondary_res);

									if (pstmt!=null) pstmt.close();	
									sec_srl_n0++;
								}//End of for loop of bulk transfer
							}// End of if loop of bulk transfer
						}// End of Secondary Resources if condition
						if (rsds!=null) rsds.close();
					}else{ // else part (If result of insertion into oa_appt_del_tr is false or zero) 
						sb.append("Error encountered");
						result=false;
						con.rollback();
					}	
					if (pStmt!=null) pStmt.close();
					old_pract_id=practitionerid;
					if(old_pract_id==null) old_pract_id="";
					if(old_alcn_catg_code==null) old_alcn_catg_code="";

					// to get the status whether the transfer of appointment is within.
					if(new_date.equals(apptdate) && clinic_code_new.equals(clinic_code) && practitioner_id.equals(old_pract_id)){
						transfer_within="Y";
					}else{
						transfer_within="N";
					}
					// Concurrency chk to see if the Appointment already exists..Concurrency chk is done in both oa_block_appt and oa_ppt to see if the slot is already blocked or booked with any appointment.

					if(!forced.equals("Y") || (forced_val.equals("TB")&&forced_appt_yn.equals("Y"))){
						if(time_table_type!=null && !(time_table_type.equals("2"))&&!(to_over_book_yn.equals("Y"))){
							// oa_block_appt
							String duplicateSql="Select '1' from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+clinic_code_new+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and  care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and block_date=to_date('"+new_date+"','dd/mm/yyyy') and ((to_date('"+new_from_time+"','hh24:mi')>to_date(to_char (effective_from_date_time, 'hh24:mi'),'hh24:mi') and to_date('"+new_from_time+"','hh24:mi')< to_date(to_char (effective_to_date_time, 'hh24:mi'),'hh24:mi')) or (to_date('"+new_to_time+"','hh24:mi') > to_date(to_char (effective_from_date_time,'hh24:mi'),'hh24:mi') and to_date('"+new_to_time+"','hh24:mi') < to_date(to_char(effective_to_date_time,'hh24:mi'),'hh24:mi')) or (to_date('"+new_from_time+"','hh24:mi') >= to_date(to_char (effective_from_date_time,'hh24:mi'),'hh24:mi') and  to_date('"+new_to_time+"','hh24:mi') <= to_date(to_char (effective_to_date_time,'hh24:mi'),'hh24:mi')) or ( to_date('"+new_from_time+"','hh24:mi') <= to_date(to_char ( effective_from_date_time,'hh24:mi' ),'hh24:mi') and to_date('"+new_to_time+"','hh24:mi') >= to_date(to_char ( effective_to_date_time, 'hh24:mi'),'hh24:mi'))) ";
							// oa_appt
							String duplicateSql2="Select '1' from oa_appt where facility_id='"+facilityId+"' and clinic_code='"+clinic_code_new+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and appt_date=to_date('"+new_date+"','dd/mm/yyyy') and overbooked_yn='N' and ((to_date('"+new_from_time+"','hh24:mi')>to_date(to_char (appt_slab_from_time, 'hh24:mi'),'hh24:mi') and to_date('"+new_from_time+"','hh24:mi')< to_date(to_char (appt_slab_to_time, 'hh24:mi'),'hh24:mi')) or (to_date('"+new_to_time+"','hh24:mi') > to_date(to_char (appt_slab_from_time,'hh24:mi'),'hh24:mi')  and to_date('"+new_to_time+"','hh24:mi') < to_date(to_char(appt_slab_to_time,'hh24:mi'),'hh24:mi')) or (to_date('"+new_from_time+"','hh24:mi') >= to_date(to_char (appt_slab_from_time,'hh24:mi'),'hh24:mi') and  to_date('"+new_to_time+"','hh24:mi') <= to_date(to_char (appt_slab_to_time,'hh24:mi'),'hh24:mi')) or ( to_date('"+new_from_time+"','hh24:mi') <= to_date(to_char ( appt_slab_from_time,'hh24:mi' ),'hh24:mi') and to_date('"+new_to_time+"','hh24:mi') >= to_date(to_char ( appt_slab_to_time, 'hh24:mi'),'hh24:mi'))) ";
							pstmt_dup = con.prepareStatement( duplicateSql) ;
							pstmt_dup2 = con.prepareStatement( duplicateSql2) ;

							System.err.println("1837-----modifyAppointmentDetails----duplicateSql----------->"+duplicateSql);
							System.err.println("1838-----modifyAppointmentDetails----duplicateSql2----------->"+duplicateSql2);

							rs_dup = pstmt_dup.executeQuery();
							rs_dup2 = pstmt_dup2.executeQuery();

							System.err.println("1843----modifyAppointmentDetails-----duplicateSql----------->"+duplicateSql);
							System.err.println("1844----modifyAppointmentDetails-----duplicateSql2----------->"+duplicateSql2);

							if(rs_dup.next() || rs_dup2.next() ){
								allow_process=false;
							}else{
								allow_process=true;
							}
						}else{
							allow_process=true;
						}
					}			
					if(!allow_process){
						java.util.Hashtable message = MessageManager.getMessage( locale, "APPT_ALREADY_EXISITS" ,"OA") ;
						sb.append( (String) message.get("message") ) ;	
						message.clear();
					}else{
						//To get the appointment Duration of a primary resource.		
						 sqlds="select get_time_between(to_date('"+new_date+" "+new_to_time+"',' dd/mm/yyyy hh24:mi'),to_date('"+new_date+" "+new_from_time+"','dd/mm/yyyy hh24:mi')) from dual ";
						 pstmt_dat=con.prepareStatement(sqlds);

						 System.err.println("1866---modifyAppointmentDetails------sqlds----------->"+sqlds);

						 rs_dat=pstmt_dat.executeQuery();

						 System.err.println("1870----modifyAppointmentDetails-----sqlds----------->"+sqlds);

						 if(rs_dat !=null && rs_dat.next()){
							 time=rs_dat.getString(1);
						}
						StringBuffer sql6_strbuff1=new StringBuffer("");					
						// Updating oa_appt with new date and new time ie incrementation part.
						sql6_strbuff1.append("update oa_appt set clinic_code='"+clinic_code_new+"' ,practitioner_id='"+practitioner_id+"',alcn_criteria='"+to_clinic_alcn+"',ALCN_CATG_CODE='"+to_alcn_cat_code+"',PAT_ALCN_CATG_CODE='"+to_pat_alcn_cat+"',appt_date=to_date('"+new_date+"','dd/mm/yyyy'),appt_time = to_date('"+new_from_time+"','hh24:mi'),appt_slab_from_time=to_date('"+new_from_time+"','hh24:mi'),appt_slab_to_time=to_date('"+new_to_time+"','hh24:mi'),overbooked_yn = nvl('"+to_over_book_yn+"','N'), FORCED_APPT_YN='"+forced_appt_yn+"',SPECIALITY_CODE='"+speciality_code+"'");
						if (no_of_slots_value>0 && !forced_appt_yn.equals("Y")){
							sql6_strbuff1.append(",no_of_slots = '"+no_of_slots_value+"'");
						}else{
							//sql6_strbuff1.append(",no_of_slots ='0'"); //Modified against AAKH-SCF-0086
							if(time_table_type.equals("1"))
								sql6_strbuff1.append(",no_of_slots = ( decode(nvl('"+to_over_book_yn+"','N'),'Y','0','1')) ");
							else
								sql6_strbuff1.append(",no_of_slots = '0' ");
						}
						if(global_appt_yn.equals("Y")){
							sql6_strbuff1.append(",GLOBAL_APPT_YN ='N'");
						}
						sql6_strbuff1.append(",inpatient_yn='"+inpatient_yn+"', team_id='"+teamId+"',appt_duration=to_date('"+time+"','hh24:mi'),res_addr_line1 =?,res_addr_line2 = ?,res_addr_line3 =?,res_addr_line4 = ?,postal_code = '"+postalcode_new+"',modified_by_id='"+addedById+"',modified_facility_id='"+facilityId+"',modified_date=sysdate ");
						//Updating audit column::
						//sql6_strbuff1.append(", MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"'");
						if(!function_mode.equals("")&&function_mode.equals("transfer"))
						sql6_strbuff1.append(", MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',RESOURCE_CLASS='"+new_resource_class+"'");
						else
						sql6_strbuff1.append(", MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',RESOURCE_CLASS='"+res_class+"'");
						//Above line modified for this incident ML-BRU-SCF-1602 [IN:055253]
						
						//sql6_strbuff1.append(",inpatient_yn='"+inpatient_yn+"', team_id='"+teamId+"',appt_duration=to_date('"+time+"','hh24:mi'),modified_by_id='"+addedById+"',modified_facility_id='"+facilityId+"',modified_date=sysdate ");

						if(from_bulk.equals("")){
							if(transfer_within.equals("N")){
								sql6_strbuff1.append(", TRANSFERRED_APPT_YN ='Y' ");
							}
						}else{
							sql6_strbuff1.append(", TRANSFERRED_APPT_YN ='B' ");
						}
						if(!from_bulk.equals("Y")){
							if(resource_class.equals("P")){
								if(rule_based_tr.equals("Y")){
									if(!patientid.equals("")){
										sql6_strbuff1.append(", appt_category = 3 ");//Old Patient and practitioner Not Specified
									}else{
										sql6_strbuff1.append(", appt_category = 4 ");//New Patient and practitioner Not Specified
									}						
								}else{
									if(!patientid.equals("")){
										sql6_strbuff1.append(", appt_category = 1 ");//Old Patient and practitioner Specified
									}else{
										sql6_strbuff1.append(", appt_category = 2 ");//New Patient and practitioner Specified
									}
								}
							}else{
								sql6_strbuff1.append(", appt_category = 5 ");//For Non-practitioners
							}
						}						
						sql6_strbuff1.append(", pract_override_reason =? , pract_override_remarks =? "); //pract_override_remarks Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114					
						sql6_strbuff1.append(" where facility_id='"+facilityId+"' and  appt_ref_no='"+apptrefno+"'");
						//System.out.println("oa_appt updateSQL :"+sql6_strbuff1.toString());
						if (pstmt4!=null) pstmt4.close();
						pstmt4 = con.prepareStatement( sql6_strbuff1.toString() );
						pstmt4.setString(1,resaddrl1_new);
						pstmt4.setString(2,resaddrl2_new);
						pstmt4.setString(3,resaddrl3_new);
						pstmt4.setString(4,resaddrl4_new);
						pstmt4.setString(5,pract_override_reason);
						pstmt4.setString(6,remarksForPractOverride); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
						sql6_strbuff1.setLength(0);

						System.err.println("1942-----modifyAppointmentDetails-------sql6_strbuff1-------------->"+sql6_strbuff1.toString());

						res10 = pstmt4.executeUpdate(); 

						System.err.println("1946-------modifyAppointmentDetails-----sql6_strbuff1-------------->"+sql6_strbuff1.toString());
						

					// oa_appt table is updated with FORCED_APPT_YN='N' When we are trying to transfer an normal appointment associated with a forced booking then that forced appt is changed to a normal booking after tranfer of appt takes place .
					
					System.err.println("1951------------AppointmentDetailsManager-------------->"+from_bulk);

					if(from_bulk.equals("Y")){
						
						System.err.println("1955------------AppointmentDetailsManager-------------->"+from_bulk);

						if(!forApptRef.equals("N")){
							
							System.err.println("1959------------AppointmentDetailsManager-------------->"+forApptRef);

							if (pstmt4!=null) pstmt4.close();
							//Updating audit columns::
							pstmt4 = con.prepareStatement( "update oa_appt set FORCED_APPT_YN='N',MODIFIED_BY_ID = ?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id=? and appt_ref_no=?" );
							pstmt4.setString( 1, addedById ) ;
							pstmt4.setString( 2, modifiedAtWorkstation ) ;
							pstmt4.setString( 3, modifiedFacilityId ) ;
							pstmt4.setString( 4, addedFacilityId ) ;
							pstmt4.setString( 5, forApptRef ) ;

							System.err.println("1971-------modifyAppointmentDetails-----Before execute -----pstmt4--------->");

							res10 = pstmt4.executeUpdate() ;

							System.err.println("1975-------modifyAppointmentDetails-----After execute-------pstmt4------->");
							
						}
						sql_update_oa_clinic_sch.setLength(0);
					}
					if(overbooked_yn.equals("Y")){
						if(forApptRef.equals("N")){
							// Updating oa_clinic_schedule by decrementing Overbooked value by 1 and based on condition decrementing Global booking by 1.
							sql_update_oa_clinic_sch.append("update oa_clinic_schedule set  total_overbooked = nvl(total_overbooked,0)-1 , total_slots_overbooked = nvl(total_slots_overbooked,0) - 1");
							if(global_appt_yn.equals("Y")){
								sql_update_oa_clinic_sch.append(",TOTAL_GLOBAL_BOOKED=TOTAL_GLOBAL_BOOKED-1");
							}
							if(from_bulk.equals("") ){
								if(transfer_within.equals("N") && TRANSFERRED_APPT_YN.equals("Y")){
									sql_update_oa_clinic_sch.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) -1 ");
								}
							}else{
								if(TRANSFERRED_APPT_YN.equals("B")){
									sql_update_oa_clinic_sch.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) -1 ");
								}
							}					
							sql_update_oa_clinic_sch.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId +"' and clinic_code= '"+clinic_code +"'  and clinic_date= to_date('"+dateapd+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+old_pract_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"'");	
						}else{
							// Any normal booking wich has an forced booking associated with it then that forced booking will be decremented so there by it turns to a normal booking.
							// Updating oa_clinic_schedule by decrementing Forced booking value by 1.
							sql_update_oa_clinic_sch.append("update oa_clinic_schedule set  TOTAL_FORCED_IN_BOOKED  = nvl(TOTAL_FORCED_IN_BOOKED,0)-1	");
							if(from_bulk.equals("")){
								if(transfer_within.equals("N") && TRANSFERRED_APPT_YN.equals("Y")){
									sql_update_oa_clinic_sch.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) -1 ");
								}
							}else{
								if(TRANSFERRED_APPT_YN.equals("B")){
									sql_update_oa_clinic_sch.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) -1 ");
								}
							}
							sql_update_oa_clinic_sch.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId +"' and clinic_code= '"+clinic_code +"'  and clinic_date= to_date('"+dateapd+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+old_pract_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"'");
						}
						pstmt5 = con.prepareStatement(sql_update_oa_clinic_sch.toString());

						System.err.println("2015------------sql_update_oa_clinic_sch-------------->"+sql_update_oa_clinic_sch.toString());

						res11 = pstmt5.executeUpdate() ;

						System.err.println("2019------------sql_update_oa_clinic_sch-------------->"+sql_update_oa_clinic_sch.toString());
                        					
					}else{
						if(pstmt_forced!=null)pstmt_forced.close();
						if(rs_forced!=null)rs_forced.close();
						pstmt_forced=con.prepareStatement("SELECT (SELECT visit_type_ind  FROM op_visit_type  WHERE visit_type_code = oa_appt.appt_type_code  AND facility_id = oa_appt.facility_id) visit_type_ind FROM oa_appt WHERE facility_id = ? AND appt_ref_no = ?");
						pstmt_forced.setString(1,facilityId);
						pstmt_forced.setString(2,forApptRef);

						System.err.println("2028-------modifyAppointmentDetails-----Before execute-------pstmt_forced------->");

						rs_forced=pstmt_forced.executeQuery() ;

						System.err.println("2032-------modifyAppointmentDetails-----After execute-------pstmt_forced------->");

						if(rs_forced!=null && rs_forced.next()){
							visit_type_ind=rs_forced.getString("visit_type_ind");
						}
						if (no_of_slots_value>1 && slot_appt_ctrl.equals("S")){
							if(forApptRef.equals("N")){
								// Updating oa_clinic_schedule by decrementing the no of slots of a normal booking against appropriate visit type indicator.

								sql_update_oa_clinic_sch.append("update oa_clinic_schedule set  total_slots_booked  = nvl(total_slots_booked,0) -"+no_of_slots_value+",total_first_visit=nvl(total_first_visit,0)-decode('"+visitind+"','F',"+no_of_slots_value+",0),total_follow_up=nvl(total_follow_up,0)-decode('"+visitind+"','L',"+no_of_slots_value+",0),total_routine=nvl(total_routine,0)-decode('"+visitind+"','R',"+no_of_slots_value+",0),total_series=nvl(total_series,0)-decode('"+visitind+"','S',"+no_of_slots_value+",0),total_consult=nvl(total_consult,0)-decode('"+visitind+"','C',"+no_of_slots_value+",0),total_emergency=nvl(total_emergency,0)-decode('"+visitind+"','E',"+no_of_slots_value+",0)");
								if(global_appt_yn.equals("Y")){
									sql_update_oa_clinic_sch.append(",TOTAL_GLOBAL_BOOKED = TOTAL_GLOBAL_BOOKED-1");
								}
								if(from_bulk.equals("") ){
									if(transfer_within.equals("N") && TRANSFERRED_APPT_YN.equals("Y")){
										sql_update_oa_clinic_sch.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) -1 ");
									}
									if(TRANSFERRED_APPT_YN.equals("B")){
										sql_update_oa_clinic_sch.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) -1 ");
									}
								}else{
									if(TRANSFERRED_APPT_YN.equals("B")){
										sql_update_oa_clinic_sch.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) -1 ");
									}
									if(TRANSFERRED_APPT_YN.equals("Y")){
									   sql_update_oa_clinic_sch.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) -1 ");
									}
								}
								if((visitind!=null && visitind.equals("F")) && forced.equals("N")){
									sql_update_oa_clinic_sch.append(", TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED-"+no_of_slots_value);
								}
								sql_update_oa_clinic_sch.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId+"' and clinic_code= '"+clinic_code+"'  and clinic_date= to_date('"+dateapd+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+old_pract_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"'");
							}else{
								// Updating oa_clinic_schedule by decrementing Forced  booking.
								sql_update_oa_clinic_sch.append("update oa_clinic_schedule set  TOTAL_FORCED_IN_BOOKED  = nvl(TOTAL_FORCED_IN_BOOKED,0)-1,total_slots_booked=nvl(total_slots_booked,0) -"+(no_of_slots_value-1)+" ");
								if(from_bulk.equals("")){
									if(transfer_within.equals("N") && TRANSFERRED_APPT_YN.equals("Y")){
										sql_update_oa_clinic_sch.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) -1 ");
									}
									if(TRANSFERRED_APPT_YN.equals("B")){
										sql_update_oa_clinic_sch.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) -1 ");
									}
								}else{
									if(TRANSFERRED_APPT_YN.equals("B")){
										sql_update_oa_clinic_sch.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) -1 ");
									}
									if(TRANSFERRED_APPT_YN.equals("Y")){
									   sql_update_oa_clinic_sch.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) -1 ");
									}
								}
								/*if(!visitind.equals(visit_type_ind)){
									if(visitind.equals("F")){
										sql_update_oa_clinic_sch.append(",total_first_visit=total_first_visit-decode('"+visitind+"','F',"+no_of_slots_value+",0),total_follow_up=nvl(total_follow_up,0)+decode('"+visit_type_ind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visit_type_ind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visit_type_ind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visit_type_ind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visit_type_ind+"','E',1,0), TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED-decode('"+visitind+"','F',"+no_of_slots_value+",0) ");
									}else{
										if(visit_type_ind.equals("F")){
											sql_update_oa_clinic_sch.append(",total_first_visit=total_first_visit+decode('"+visit_type_ind+"','F',1,0),total_follow_up=nvl(total_follow_up,0)-decode('"+visitind+"','L',"+no_of_slots_value+",0),total_routine=nvl(total_routine,0)-decode('"+visitind+"','R',"+no_of_slots_value+",0),total_series=nvl(total_series,0)-decode('"+visitind+"','S',"+no_of_slots_value+",0),total_consult=nvl(total_consult,0)-decode('"+visitind+"','C',"+no_of_slots_value+",0),total_emergency=nvl(total_emergency,0)-decode('"+visitind+"','E',"+no_of_slots_value+",0), TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED+decode('"+visit_type_ind+"','F',1,0)");
										}
									}
								}else if(!visitind.equals("F") && !visit_type_ind.equals("F")){
									if(pstmt_forced!=null)pstmt_forced.close();
									pstmt_forced=con.prepareStatement("update oa_clinic_schedule set total_follow_up=nvl(total_follow_up,0)+decode('"+visit_type_ind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visit_type_ind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visit_type_ind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visit_type_ind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visit_type_ind+"','E',1,0)  where facility_id = '"+facilityId +"' and clinic_code= '"+clinic_code +"'  and clinic_date= to_date('"+dateapd+"','DD/MM/YYYY')  and  nvl(practitioner_id,'X')=nvl('"+old_pract_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"'");
									int rs_forced_int1 = pstmt_forced.executeUpdate() ;
									if(rs_forced_int1!=0){
										result=true;
									}else{
										con.rollback();
										sb.append("Transcation Failed in update oa_clinic_schedule for forced appt");
									}
									sql_update_oa_clinic_sch.append(",total_follow_up=nvl(total_follow_up,0)-decode('"+visitind+"','L',"+no_of_slots_value+",0),total_routine=nvl(total_routine,0)-decode('"+visitind+"','R',"+no_of_slots_value+",0),total_series=nvl(total_series,0)-decode('"+visitind+"','S',"+no_of_slots_value+",0),total_consult=nvl(total_consult,0)-decode('"+visitind+"','C',"+no_of_slots_value+",0),total_emergency=nvl(total_emergency,0)-decode('"+visit_type_ind+"','E',"+no_of_slots_value+",0) ");
								}else if(visitind.equals("F") && visit_type_ind.equals("F")){
									sql_update_oa_clinic_sch.append(",total_first_visit=total_first_visit-decode('"+visitind+"','F',"+(no_of_slots_value-1)+",0), TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED-decode('"+visitind+"','F',"+(no_of_slots_value-1)+",0)");
								}*/
								if(!visitind.equals(visit_type_ind)){
									if(visitind.equals("F") && !visit_type_ind.equals("F")){//Normal Appt is First Visit Type and Forced Appt is Other Visit
										sql_update_oa_clinic_sch.append(",total_first_visit=total_first_visit-decode('"+visitind+"','F',"+no_of_slots_value+",0),total_follow_up=nvl(total_follow_up,0)+decode('"+visit_type_ind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visit_type_ind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visit_type_ind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visit_type_ind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visit_type_ind+"','E',1,0), TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED-decode('"+visitind+"','F',"+no_of_slots_value+",0) ");
									}else if(!visitind.equals("F") && visit_type_ind.equals("F")){//Normal appt is Other Visit andForced Appt is First Visit Type
											sql_update_oa_clinic_sch.append(",total_first_visit=total_first_visit+decode('"+visit_type_ind+"','F',1,0),total_follow_up=nvl(total_follow_up,0)-decode('"+visitind+"','L',"+no_of_slots_value+",0),total_routine=nvl(total_routine,0)-decode('"+visitind+"','R',"+no_of_slots_value+",0),total_series=nvl(total_series,0)-decode('"+visitind+"','S',"+no_of_slots_value+",0),total_consult=nvl(total_consult,0)-decode('"+visitind+"','C',"+no_of_slots_value+",0),total_emergency=nvl(total_emergency,0)-decode('"+visitind+"','E',"+no_of_slots_value+",0), TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED+decode('"+visit_type_ind+"','F',1,0)");
									}else if(!visitind.equals("F") && !visit_type_ind.equals("F")){//Both Normal and Forced Appointments are Different Other Visits
										if(pstmt_forced!=null)pstmt_forced.close();
										//Updating audit columns
										String oa_clinic_sch_forced="update oa_clinic_schedule set total_follow_up=nvl(total_follow_up,0)+decode('"+visit_type_ind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visit_type_ind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visit_type_ind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visit_type_ind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visit_type_ind+"','E',1,0), MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'  where facility_id = '"+facilityId +"' and clinic_code= '"+clinic_code +"'  and clinic_date= to_date('"+dateapd+"','DD/MM/YYYY')  and  nvl(practitioner_id,'X')=nvl('"+old_pract_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"'";
										pstmt_forced=con.prepareStatement(oa_clinic_sch_forced);

										System.err.println("2117-----modifyAppointmentDetails-------oa_clinic_sch_forced-------------->"+oa_clinic_sch_forced);
										
										int rs_forced_int1 = pstmt_forced.executeUpdate() ;

										System.err.println("2121------modifyAppointmentDetails------oa_clinic_sch_forced-------------->"+oa_clinic_sch_forced);
										
										if(rs_forced_int1!=0){
											result=true;
										}else{
											con.rollback();
											sb.append("Transcation Failed in update oa_clinic_schedule for forced appt");
										}
										sql_update_oa_clinic_sch.append(",total_follow_up=nvl(total_follow_up,0)-decode('"+visitind+"','L',"+no_of_slots_value+",0),total_routine=nvl(total_routine,0)-decode('"+visitind+"','R',"+no_of_slots_value+",0),total_series=nvl(total_series,0)-decode('"+visitind+"','S',"+no_of_slots_value+",0),total_consult=nvl(total_consult,0)-decode('"+visitind+"','C',"+no_of_slots_value+",0),total_emergency=nvl(total_emergency,0)-decode('"+visitind+"','E',"+no_of_slots_value+",0) ");
									}
								}else{
									sql_update_oa_clinic_sch.append(",total_first_visit=total_first_visit-decode('"+visitind+"','F',"+(no_of_slots_value-1)+",0), TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED-decode('"+visitind+"','F',"+(no_of_slots_value-1)+",0) ,total_follow_up=nvl(total_follow_up,0)-decode('"+visitind+"','L',"+(no_of_slots_value-1)+",0),total_routine=nvl(total_routine,0)-decode('"+visitind+"','R',"+(no_of_slots_value-1)+",0),total_series=nvl(total_series,0)-decode('"+visitind+"','S',"+(no_of_slots_value-1)+",0),total_consult=nvl(total_consult,0)-decode('"+visitind+"','C',"+(no_of_slots_value-1)+",0),total_emergency=nvl(total_emergency,0)-decode('"+visitind+"','E',"+(no_of_slots_value-1)+",0) ");
								}
								//Updating audit columns::
								sql_update_oa_clinic_sch.append(", MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'");
								
								sql_update_oa_clinic_sch.append(" where facility_id = '"+facilityId +"' and clinic_code= '"+clinic_code +"'  and clinic_date= to_date('"+dateapd+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+old_pract_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' ");
							}
					   }else{
						   /*if(visitind!=null && visitind.equals("F")){
								sql8_up.append(", TOTAL_FIRST_VISIT_SLOTS_BOOKED= nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0) +1 ");
							}*/
						   if(forApptRef.equals("N")){// when the is no forced appointment
							   sql_update_oa_clinic_sch.append("update oa_clinic_schedule set  total_slots_booked  = total_slots_booked -1,total_first_visit=total_first_visit-decode('"+visitind+"','F',1,0),total_follow_up=nvl(total_follow_up,0)-decode('"+visitind+"','L',1,0),total_routine=nvl(total_routine,0)-decode('"+visitind+"','R',1,0),total_series=nvl(total_series,0)-decode('"+visitind+"','S',1,0),total_consult=nvl(total_consult,0)-decode('"+visitind+"','C',1,0),total_emergency=nvl(total_emergency,0)-decode('"+visitind+"','E',1,0)");
							   if(global_appt_yn.equals("Y")){
								   sql_update_oa_clinic_sch.append(",TOTAL_GLOBAL_BOOKED=TOTAL_GLOBAL_BOOKED-1");
							   }
							   if(from_bulk.equals("")){
								   if(transfer_within.equals("N") && TRANSFERRED_APPT_YN.equals("Y")){
									   sql_update_oa_clinic_sch.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) -1 ");
									}
									if(TRANSFERRED_APPT_YN.equals("B")){
										sql_update_oa_clinic_sch.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) -1 ");
									}
								}else{
									if(TRANSFERRED_APPT_YN.equals("Y")){
									   sql_update_oa_clinic_sch.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) -1 ");
									}
									if(TRANSFERRED_APPT_YN.equals("B")){
										sql_update_oa_clinic_sch.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) -1 ");
									}
								}
								if((visitind!=null && visitind.equals("F")) && forced.equals("N")){
									sql_update_oa_clinic_sch.append(", TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED-1 ");
								}
								if(forced.equals("Y") && forced_val.equals("FR")){
									sql_update_oa_clinic_sch.append(", TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED-decode('"+visitind+"','F',1,0) ");
								}
								//Updating audit columns::
								sql_update_oa_clinic_sch.append(", MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'");
									
								sql_update_oa_clinic_sch.append(" where facility_id = '"+facilityId+"' and clinic_code= '"+clinic_code+"'  and clinic_date= to_date('"+dateapd+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+old_pract_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' ");
							}else{//when forced appointment exits
								sql_update_oa_clinic_sch.append("update oa_clinic_schedule set  TOTAL_FORCED_IN_BOOKED  = nvl(TOTAL_FORCED_IN_BOOKED,0)-1	");
								if(from_bulk.equals("")){
									if(transfer_within.equals("N") && TRANSFERRED_APPT_YN.equals("Y")){
										sql_update_oa_clinic_sch.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) -1 ");
									}
									if(TRANSFERRED_APPT_YN.equals("B")){
										sql_update_oa_clinic_sch.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) -1 ");
									}
								}else{
									if(TRANSFERRED_APPT_YN.equals("Y")){
									   sql_update_oa_clinic_sch.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) -1 ");
									}
									if(TRANSFERRED_APPT_YN.equals("B")){
										sql_update_oa_clinic_sch.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) -1 ");
									}
								}
								if(!visitind.equals(visit_type_ind)){
									if(visitind.equals("F") && !visit_type_ind.equals("F")){//Normal Appt is First Visit Type and Forced Appt is Other Visit
										sql_update_oa_clinic_sch.append(",total_first_visit=total_first_visit-decode('"+visitind+"','F',1,0),total_follow_up=nvl(total_follow_up,0)+decode('"+visit_type_ind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visit_type_ind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visit_type_ind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visit_type_ind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visit_type_ind+"','E',1,0), TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED-decode('"+visitind+"','F',1,0) ");
									}else if(!visitind.equals("F") && visit_type_ind.equals("F")){//Normal appt is Other Visit andForced Appt is First Visit Type
											sql_update_oa_clinic_sch.append(",total_first_visit=total_first_visit+decode('"+visit_type_ind+"','F',1,0),total_follow_up=nvl(total_follow_up,0)-decode('"+visitind+"','L',1,0),total_routine=nvl(total_routine,0)-decode('"+visitind+"','R',1,0),total_series=nvl(total_series,0)-decode('"+visitind+"','S',1,0),total_consult=nvl(total_consult,0)-decode('"+visitind+"','C',1,0),total_emergency=nvl(total_emergency,0)-decode('"+visitind+"','E',1,0), TOTAL_FIRST_VISIT_SLOTS_BOOKED= TOTAL_FIRST_VISIT_SLOTS_BOOKED+decode('"+visit_type_ind+"','F',1,0)");
									}else if(!visitind.equals("F") && !visit_type_ind.equals("F")){//Both Normal and Forced Appointments are Different Other Visits
										if(pstmt_forced!=null)pstmt_forced.close();
										String oa_clinic_sch_forced="update oa_clinic_schedule set total_follow_up=nvl(total_follow_up,0)+decode('"+visit_type_ind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visit_type_ind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visit_type_ind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visit_type_ind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visit_type_ind+"','E',1,0),MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'  where facility_id = '"+facilityId +"' and clinic_code= '"+clinic_code +"'  and clinic_date= to_date('"+dateapd+"','DD/MM/YYYY')  and  nvl(practitioner_id,'X')=nvl('"+old_pract_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"'";
										pstmt_forced=con.prepareStatement(oa_clinic_sch_forced);

                                        System.err.println("2201---modifyAppointmentDetails---oa_clinic_sch_forced-------->"+oa_clinic_sch_forced);

										int rs_forced_int1 = pstmt_forced.executeUpdate() ; 

										System.err.println("2205---modifyAppointmentDetails---oa_clinic_sch_forced-------->"+oa_clinic_sch_forced);

										if(rs_forced_int1!=0){
											result=true;
										}else{
											con.rollback();
											sb.append("Transcation Failed in update oa_clinic_schedule for forced appt");
										}
										sql_update_oa_clinic_sch.append(",total_follow_up=nvl(total_follow_up,0)-decode('"+visitind+"','L',1,0),total_routine=nvl(total_routine,0)-decode('"+visitind+"','R',1,0),total_series=nvl(total_series,0)-decode('"+visitind+"','S',1,0),total_consult=nvl(total_consult,0)-decode('"+visitind+"','C',1,0),total_emergency=nvl(total_emergency,0)-decode('"+visitind+"','E',1,0) ");
									}
								}else{
								}
								sql_update_oa_clinic_sch.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId +"' and clinic_code= '"+clinic_code +"'  and clinic_date= to_date('"+dateapd+"','DD/MM/YYYY')  and  nvl(practitioner_id,'X')=nvl('"+old_pract_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"'");
							}
						}
						if(!forApptRef.equals("N") && result){ 
							if(pstmt_forced!=null)pstmt_forced.close();
							if(rs_forced!=null)rs_forced.close();
							StringBuffer update_fr_oa_appt=new StringBuffer("");
							//Updating audit columns::
							update_fr_oa_appt.append("update oa_appt set NO_OF_SLOTS=1 ,forced_appt_yn ='N', MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where  facility_id = '"+facilityId +"' and appt_ref_no="+forApptRef);
							
							System.err.println("2227----------AppointmentDetailsManager------------------>"+update_fr_oa_appt.toString());

							pstmt_forced=con.prepareStatement(update_fr_oa_appt.toString());

							System.err.println("2231----------AppointmentDetailsManager------------------>"+update_fr_oa_appt.toString());

							update_fr_oa_appt.setLength(0);

							System.err.println("2235------modifyAppointmentDetails------update_fr_oa_appt-------------->"+update_fr_oa_appt.toString());

							int rs_forced_int = pstmt_forced.executeUpdate();//updating oa_appt for forced appt when normal appt is transferred

							System.err.println("2239------modifyAppointmentDetails------update_fr_oa_appt-------------->"+rs_forced_int);
							
							
							if(rs_forced_int!=0){
								result=true;
							}else{
								con.rollback();
								sb.append("Transcation Failed in update oa_appt for forced appt");
							}
						}				
						if(result){
					
							pstmt5 = con.prepareStatement(sql_update_oa_clinic_sch.toString());	

							System.err.println("2253------modifyAppointmentDetails------sql_update_oa_clinic_sch-------------->"+sql_update_oa_clinic_sch.toString());

							res11 = pstmt5.executeUpdate() ;

							System.err.println("2257------modifyAppointmentDetails------sql_update_oa_clinic_sch-------------->"+sql_update_oa_clinic_sch.toString());
							
						}
					}
					if(res11 !=0){
						result=true;
					}else{
						con.rollback();
						sb.append("Transcation Failed in update oa_appt ");
					}
					// From here updation of oa_clinic_schedule with incrementation part begins ie updating the record for new date and new time and the no of slots selected.
					if(over_booked.equals("Y")){
					}else{
						if(!(to_over_book_yn.equals("Y"))){
							if(!forced.equals("Y") || (forced_val.equals("TB")&&forced_appt_yn.equals("Y"))){
								if (no_of_slots_value>1 && slot_appt_ctrl.equals("S")){
									sql8_up.append("update oa_clinic_schedule set  total_slots_booked  = nvl(total_slots_booked,0) +"+no_of_slots_value+",total_first_visit=nvl(total_first_visit,0)+decode('"+visitind+"','F',"+no_of_slots_value+",0),total_follow_up=nvl(total_follow_up,0)+decode('"+visitind+"','L',"+no_of_slots_value+",0),total_routine=nvl(total_routine,0)+decode('"+visitind+"','R',"+no_of_slots_value+",0),total_series=nvl(total_series,0)+decode('"+visitind+"','S',"+no_of_slots_value+",0),total_consult=nvl(total_consult,0)+decode('"+visitind+"','C',"+no_of_slots_value+",0),total_emergency=nvl(total_emergency,0)+decode('"+visitind+"','E',"+no_of_slots_value+",0) ");
									if(from_bulk.equals("")){
										if(transfer_within.equals("N") ){
											sql8_up.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) +1 ");
										}
									}else{
										sql8_up.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) +1 ");
									}
									if((visitind!=null && visitind.equals("F")) && forced.equals("N")){
										sql8_up.append(", TOTAL_FIRST_VISIT_SLOTS_BOOKED= nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0) +"+no_of_slots_value);
									}
									/*sql8_up.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId+"' and clinic_code= '"+clinic_code_new+"'  and clinic_date= to_date('"+new_date+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+clinic_type+"' and 
									resource_class='"+res_class+"' ");*/
									//below line Added and commeneted above line for incident ML-BRU-SCF-1602 [IN:055253]	
									sql8_up.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId+"' and clinic_code= '"+clinic_code_new+"'  and clinic_date= to_date('"+new_date+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+clinic_type+"' ");
									//Added ML-BRU-SCF-1602 [IN:055253]
									if(!function_mode.equals("")&&function_mode.equals("transfer"))
									sql8_up.append("and resource_class='"+new_resource_class+"' ");
									else
									sql8_up.append(" and resource_class='"+res_class+"' ");
								}else{
									sql8_up.append("update oa_clinic_schedule set  total_slots_booked  = nvl(total_slots_booked,0) +1,total_first_visit=nvl(total_first_visit,0)+decode('"+visitind+"','F',1,0),total_follow_up=nvl(total_follow_up,0)+decode('"+visitind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visitind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visitind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visitind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visitind+"','E',1,0) ");
									if(from_bulk.equals("")){
										if(transfer_within.equals("N") ){
											sql8_up.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) +1 ");
										}
									}else{
										sql8_up.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) +1 ");
									}
									if(visitind!=null && visitind.equals("F") && forced.equals("N")){
										sql8_up.append(", TOTAL_FIRST_VISIT_SLOTS_BOOKED= nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0) +1 ");
									}
									/*sql8_up.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId+"' and clinic_code= '"+clinic_code_new+"'  and clinic_date= to_date('"+new_date+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' ");*/
									//Above line commented and below line added for this incident ML-BRU-SCF-1602 [IN:055253]	
									sql8_up.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId+"' and clinic_code= '"+clinic_code_new+"'  and clinic_date= to_date('"+new_date+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+clinic_type+"' ");
									//Added ML-BRU-SCF-1602 [IN:055253]
									if(!function_mode.equals("")&&function_mode.equals("transfer"))
									sql8_up.append(" and resource_class='"+new_resource_class+"' ");
									else
									sql8_up.append(" and resource_class='"+res_class+"' ");
								}
								pstmt6 = con.prepareStatement( sql8_up.toString() );

								System.err.println("2317------modifyAppointmentDetails------sql8_up-------------->"+sql8_up.toString());

								res12 = pstmt6.executeUpdate() ;

								System.err.println("2321------modifyAppointmentDetails------sql8_up-------------->"+sql8_up.toString());

								if(res12 !=0){
									result=true;
								}else{
									con.rollback();
									sb.append("Transcation Failed in oa_clinic_schedule");
								}
							}else{//Forced Appointments
								if (no_of_slots_value>1 && slot_appt_ctrl.equals("S")){
									sql8_up.append("update oa_clinic_schedule set  TOTAL_FORCED_IN_BOOKED  = nvl(TOTAL_FORCED_IN_BOOKED,0)+1 ");
									if(from_bulk.equals("") ){
										if(transfer_within.equals("N") ){
											sql8_up.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) +1 ");
										}
									}else{
										sql8_up.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) +1 ");
									}
									sql8_up.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId+"' and clinic_code= '"+clinic_code_new+"'  and clinic_date= to_date('"+new_date+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+clinic_type+"' ");
          							//and resource_class='"+res_class+"' ");
									//Added ML-BRU-SCF-1602 [IN:055253]
                                  if(!function_mode.equals("")&&function_mode.equals("transfer"))	
                                    sql8_up.append(" and resource_class='"+new_resource_class+"' ");
                                  else
                                    sql8_up.append(" and resource_class='"+res_class+"' ");
									
								}else{
									sql8_up.append("update oa_clinic_schedule set TOTAL_FORCED_IN_BOOKED  = nvl(TOTAL_FORCED_IN_BOOKED,0)+1 ");
									if(from_bulk.equals("") ){
										if(transfer_within.equals("N") ){
											sql8_up.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) +1 ");
										}
									}else{
										sql8_up.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) +1 ");
									}
									sql8_up.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId+"' and clinic_code= '"+clinic_code_new+"'  and clinic_date= to_date('"+new_date+"','DD/MM/YYYY')  and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+clinic_type+"' ");
									//Added ML-BRU-SCF-1602 [IN:055253]
                                  if(!function_mode.equals("")&&function_mode.equals("transfer"))	
                                    sql8_up.append(" and resource_class='"+new_resource_class+"' ");
                                  else
                                    sql8_up.append(" and resource_class='"+res_class+"' ");
								}
								pstmt6 = con.prepareStatement( sql8_up.toString() );

								System.err.println("2365------modifyAppointmentDetails------sql8_up-------------->"+sql8_up.toString());

								res12 = pstmt6.executeUpdate() ;

								System.err.println("2369------modifyAppointmentDetails------sql8_up-------------->"+sql8_up.toString());

								if(res12 !=0){
								result=true;
								}else{
								con.rollback();
								sb.append("Transcation Failed in oa_clinic_schedule");
								}
							}
						}else{
							sql8_up.append("update oa_clinic_schedule set total_overbooked = nvl(total_overbooked,0) + 1 , total_slots_overbooked = nvl(total_slots_overbooked,0)+ 1 ");
							if(from_bulk.equals("")){
								if(transfer_within.equals("N")){
									sql8_up.append(", TOTAL_NORMAL_TFR= nvl(TOTAL_NORMAL_TFR,0) +1 ");
								}
							}else{
								sql8_up.append(", TOTAL_BULK_TFR= nvl(TOTAL_BULK_TFR,0) +1 ");
							}
							sql8_up.append(",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId +"' and clinic_code= '"+clinic_code_new+"'  and clinic_date= to_date('"+new_date+"','DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+clinic_type+"' ");
							//and resource_class='"+res_class+"' ");
							//Added ML-BRU-SCF-1602 [IN:055253]
                            if(!function_mode.equals("")&&function_mode.equals("transfer"))	
                                sql8_up.append(" and resource_class='"+new_resource_class+"' ");
                            else
                                sql8_up.append(" and resource_class='"+res_class+"' ");
														
							pstmt6 = con.prepareStatement( sql8_up.toString() );

							System.err.println("2397----------AppointmentDetailsManager--------sql8_up---------->"+sql8_up.toString());

							res12 = pstmt6.executeUpdate() ;

							System.err.println("2401----------AppointmentDetailsManager---------sql8_up--------->"+sql8_up.toString());

							//Updating audit columns::
							sql6="update oa_appt set overbooked_yn ='Y',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id='"+facilityId+"' and  appt_ref_no='"+apptrefno+"'";
							pstmt6 = con.prepareStatement( sql6 );

							System.err.println("2408-----modifyAppointmentDetails----sql6------------------>"+sql6);

							res12 = pstmt6.executeUpdate() ;

							System.err.println("2412-----modifyAppointmentDetails-----sql6------------------>"+sql6);
							
						}
					}
					if(res10 !=0 &&  res11 !=0 && res12!=0){
							result = true ;
					}else{
						result =false;
						//	con.commit();
						sb.append("   res10  :"+res10+"  res11   :"+res11+"  res12   :"+res12);
					}
					
					if(order_id!=null && !(order_id.equals("")))
					{
						if(order_id1!=null && !(order_id1.equals("")))//--[IN027165]-- Start
						order_id = order_id1;
						//--[IN027165]-- End
							
						try{
							String or_order_line_update="update or_order_line set appt_date_time=to_date('"+new_date+" "+new_from_time+"','DD/MM/YYYY hh24:mi'),start_date_time=to_date('"+new_date+" "+new_from_time+"','DD/MM/YYYY hh24:mi'),MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where order_id='"+order_id+"' and order_line_num='"+order_line_num+"'"; 
							or_stmt=con.prepareStatement( or_order_line_update );

							System.err.println("2435------modifyAppointmentDetails----or_order_line_update------------------>"+or_order_line_update);

							int or_rset_count=or_stmt.executeUpdate() ; 

						    System.err.println("2439-----modifyAppointmentDetails-----or_order_line_update------------------>"+or_order_line_update);
							
							if(or_rset_count!=0){
								result = true ;
							}else{
								result =false;
							}
						}catch(Exception or_ex){ 
							
						System.err.println("2448-----modifyAppointmentDetails---------Inside Catch---------->"+or_ex.toString());

								result =false;
								or_ex.printStackTrace();
						}
						if(or_rset!=null)or_rset.close();
						if(or_stmt!=null)or_stmt.close();
						
					}
					/* Added for Billing Interface */
					boolean sendmailflag=false;
					String pat_email_appl_yn="";
					if(from_bulk.equals("Y")){
						if(patientid.equals("")){
							if(email_appl_for_appt_wo_pid_yn.equals("Y")){
								if(emailid.equals("")){
									sendmailflag=false;
								}else{
									sendmailflag=true;
								}
							}else{
								sendmailflag=false;
							}
						}else{
							String mailsql="select  b.EMAIL_APPL_YN PAT_EMAIL_APPL_YN from mp_patient a, mp_pat_ser_grp b where  a.patient_id=? and a.pat_ser_grp_code=b.pat_ser_grp_code";
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();
							pstmt=con.prepareStatement(mailsql);
							pstmt.setString(1,patientid);

							System.err.println("2479-----modifyAppointmentDetails-----mailsql------------------>"+mailsql);

							rs=pstmt.executeQuery();

							System.err.println("2483-----modifyAppointmentDetails-----mailsql------------------>"+mailsql);

							if(rs!=null && rs.next())
								pat_email_appl_yn=rs.getString("PAT_EMAIL_APPL_YN");
							if(email_appl_yn.equals("Y") && pat_email_appl_yn.equals("Y")){
								if(emailid.equals("")){
									sendmailflag=false;
								}else{
									sendmailflag=true;
								}
							}else{
								sendmailflag=false;
							}
						}
					}else{
						if(send_email_yn.equals("Y")){
							sendmailflag=true;
						}else{
							sendmailflag=false;
						}
					}
					if(sendmailflag){
						try{
							clstmt=con.prepareCall("{call OA_SEND_APPT_MAIL(?,?,?,?,?,?,?,?,?)}");
							clstmt.setString(1,facilityId);
							clstmt.setString(2,"OA");
							clstmt.setString(3,"OAETFAPPT");
							clstmt.setString(4,"P");
							clstmt.setString(5,patientid);
							clstmt.setString(6,"");
							clstmt.setString(7,apptrefno);
							clstmt.setString(8,"en");
							clstmt.registerOutParameter(9,java.sql.Types.VARCHAR);

							System.err.println("2518-----modifyAppointmentDetails-----Before execute-----clstmt----->");

							clstmt.execute();

							System.err.println("2522-----modifyAppointmentDetails-----After execute-----clstmt----->");

							String mailerror=clstmt.getString(9); 
							
							if(mailerror == null) mailerror="";
							if(mailerror.equals("")){
								result=true;
							}else{
								result=false;
								sb.append("MAIL ID UPDATION :"+mailerror.toString());
							}
						}catch(Exception mailex){	
							
							System.err.println("2535-----modifyAppointmentDetails-----Inside Catch--------------->"+mailex.toString());

							mailex.printStackTrace();
							result=false;
							sb.append("MAIL ID UPDATION :"+mailex.toString());
							System.err.println("MAIL ID UPDATION :"+mailex.toString());
						}
					}
					if(patientid == null) patientid="";
					if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y") && result){
						try{
							Hashtable hashtableBill = new Hashtable();
							hashtableBill.put("facilityId",facilityId+"");
							hashtableBill.put("bookingrefno",apptrefno+"");
							hashtableBill.put("P_PATIENT_ID",patientid+"");
							hashtableBill.put("admissiondate",new_date+"");
							hashtableBill.put("P_EPISODE_TYPE",episode_type+"");
							hashtableBill.put("function_id",strFunctionId+"");
							hashtableBill.put("locale",locale);				
							BLReviseBooking blbkBookPat = new BLReviseBooking();
							Hashtable resultsBL = blbkBookPat.billPatientService(p, con,hashtableBill);
							boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
							result = boolRes;
							String strBLMessage = "";				
							strBLMessage = (String) resultsBL.get("message");
							if (boolRes == false) {
								sb.append((String) resultsBL.get("error")+"\n");
							}
							if (boolRes == true) {
								if (strBLMessage != null) {
									if (!(strBLMessage.equals(""))){
									}
								}else{
									strBLMessage = "0";
								}
							}
						}catch (Exception exceptionBL){
							
							System.err.println("2575-----modifyAppointmentDetails-----Inside Catch--------------->"+exceptionBL.toString());

							result = false;	
							sb.append("BILLING UPDATION :"+exceptionBL.toString());
							System.err.println("BILLING UPDATION :"+exceptionBL.toString());
							exceptionBL.printStackTrace();
						}
					}// End of Billing Interface

					if(!frm_alc_criteria.equals("") && result){
						String alcn_slq_update="update  oa_clinic_schedule_dtl set TOTAL_BOOKED_PATIENTS=TOTAL_BOOKED_PATIENTS-"+no_of_slots_value+",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_date=to_date('"+apptdate+"','dd/mm/yyyy') and facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X')=nvl('"+practitionerid+"','X') and alcn_catg_code='"+frm_alc_cat_code+"'";
						pstmt=con.prepareStatement(alcn_slq_update);

						System.err.println("2589-----modifyAppointmentDetails-----alcn_slq_update--------------->"+alcn_slq_update);

						del_alcn_Count = pstmt.executeUpdate() ;

						System.err.println("2593-----modifyAppointmentDetails-----alcn_slq_update--------------->"+alcn_slq_update);
						
						if(del_alcn_Count>0){
						}else{
							result=false;
						}
					}

					System.err.println("2601---------AppoitmentDetailsManager-------->"+from_bulk);

					if(!from_bulk.equals("Y") && result){
						
						System.err.println("2605---------AppoitmentDetailsManager-------->"+from_bulk);

						if(transfer_alcn_yn.equals("Y")){
							
							System.err.println("2609---------AppoitmentDetailsManager-------->"+transfer_alcn_yn);

								String oa_appt_update="update  oa_appt set ALCN_CRITERIA='',ALCN_CATG_CODE='',PAT_ALCN_CATG_CODE='',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where appt_ref_no='"+apptrefno+"' and facility_id='"+facilityId+"' and (FORCED_APPT_YN = 'Y' OR OVERBOOKED_YN ='Y')";
								pstmt=con.prepareStatement(oa_appt_update);

								System.err.println("2615-----modifyAppointmentDetails-----oa_appt_update--------------->"+oa_appt_update);

								oa_appt_count=pstmt.executeUpdate();

								System.err.println("2619-----modifyAppointmentDetails-----oa_appt_update--------------->"+oa_appt_update);

								String alcn_slq_update2="update  oa_clinic_schedule_dtl set TOTAL_BOOKED_PATIENTS=nvl(TOTAL_BOOKED_PATIENTS,0)+"+no_of_slots_value+",MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_date=to_date('"+new_date+"','dd/mm/yyyy') and facility_id='"+facilityId+"' and clinic_code='"+clinic_code_new+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and alcn_catg_code='"+to_alcn_cat_code+"'";
								pstmt=con.prepareStatement(alcn_slq_update2);

								System.err.println("2625------modifyAppointmentDetails----alcn_slq_update2--------------->"+alcn_slq_update2);

								ins_alcn_count=pstmt.executeUpdate();

								System.err.println("2629------modifyAppointmentDetails----alcn_slq_update2--------------->"+alcn_slq_update2);
								
								if(ins_alcn_count>0){
								}else{
									result=false;
								}
						}
					}
					if(result){
						listCountCheck++;
						//con.commit();
						java.util.Hashtable message = MessageManager.getMessage(locale, "APPT_REVISED","OA" ) ;
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}else{
						con.rollback();
						sb.append(" Transaction failed");
					}
				}
			}else{
				result =false;
				con.rollback();
				java.util.Hashtable message = MessageManager.getMessage( locale, "APPT_ALREADY_EXISITS","OA" ) ;
				sb.append( (String) message.get("message") ) ;
			}
			if (rSet!=null) rSet.close();
			if (rsds!=null) rsds.close();
			if (rSet_sec!=null) rSet_sec.close();
			if (rSsrl!=null) rSsrl.close();
			if(rs!= null) rs.close() ;
			if(rs_dup!= null) rs_dup.close() ;
			if(rs_dup2!= null) rs_dup2.close() ;
			if(rs_dat!= null) rs_dat.close() ;
			if(rs_pract!= null) rs_pract.close() ;
			if(pstmt_dat!= null) pstmt_dat.close() ;
			if(pstmt1!= null) pstmt1.close() ;
			if(pstmt3!= null) pstmt3.close() ;
			if(pstmt4!= null) pstmt4.close() ;
			if(pstmt5!= null) pstmt5.close() ;
			if(pstmt6!= null) pstmt6.close() ;
			if(pstmt_dup2!= null) pstmt_dup2.close() ;
			if(pstmt_dup!= null) pstmt_dup.close() ;
			if(pstmt_overlap !=null) pstmt_overlap.close();
			if(pst_SqlUp_sec_stat_dec!=null) pst_SqlUp_sec_stat_dec.close() ;
			if(pst_sqlmaxSec!=null) pst_sqlmaxSec.close() ;
			if(pst_del_oa_re_appt!=null) pst_del_oa_re_appt.close() ;
			if(pst_sql_insres_for_appt!=null) pst_sql_insres_for_appt.close() ;
			if( pstmt_sql_sec_stat_inc!=null) pstmt_sql_sec_stat_inc.close() ;
			if( pstmt_sql_upop!=null) pstmt_sql_upop.close() ;
			if( pstmt_sql_sec_rstyp1!=null) pstmt_sql_sec_rstyp1.close() ;
			if( pstmt_sql_sec_rstyp2!=null) pstmt_sql_sec_rstyp2.close() ;
			if( pstmt_sql_sec_rstyp3!=null) pstmt_sql_sec_rstyp3.close() ;
			if(	pstmt_sqldssec!=null) pstmt_sqldssec.close() ;
			if(	pstmt_ins_secondary_res!=null) pstmt_ins_secondary_res.close() ;
			if (pStmt!=null) pStmt.close();
			if (pstmt!=null) pstmt.close();		
			if(stmt!= null) stmt.close() ;
			if(clstmt!= null) clstmt.close() ;
			if(pstmt_del_fm!= null) pstmt_del_fm.close() ;
			passObjects.clear();
			sec_resources.clear();
		}catch ( Exception e ) {
			
			System.err.println("2692----------Inside Catch--------------->"+e.toString());

			try{
				result=false;
				e.printStackTrace();
			sb.append("ERROR  :"+e.toString());
			System.err.println("ERROR  :"+e.toString());
			try{
			con.rollback();
			}catch(Exception es){
				
				System.err.println("2703----------Inside Catch--------------->"+es.toString());

				es.printStackTrace();
			}
					}
			catch(Exception es){
				
				System.err.println("2710---------Inside Catch--------------->"+es.toString());

				es.printStackTrace();
			}
		}
		sql8_up.setLength(0);
		sql_update_oa_clinic_sch.setLength(0);
		sql8_up.setLength(0);
		if(!result){
			break;
		}
		}//End of While loop
		if((listCount==listCountCheck)&& result){
			con.commit();
			//con.rollback();

		}else{
			con.rollback();
		}
    
	
		
	}catch(Exception ex){ //End try block
		
		System.err.println("2734----modifyAppointmentDetails------Inside Catch--------------->"+ex.toString());

		ex.printStackTrace();
	}finally{
		 if (con != null) ConnectionManager.returnConnection(con,p);
	}
	}catch(Exception ex){
		
		System.err.println("2742------modifyAppointmentDetails----Inside Catch--------------->"+ex.toString());

		ex.printStackTrace();
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	return results ;
 }// method
 
 //Bru-HIMS-CRF 169 changes
 boolean updateOAPatCnclSummary(Connection con, String patientid,String facilityId, String patCnclCount,String oa_param_cncl_reason,String reasonforcancellation, String addedById,String addedAtWorkstation){
	 
	System.err.println("2756----------updateOAPatCnclSummary-------------->");

	boolean result=true;
	String patCountSql="select count(*) from OA_PAT_CNCL_APPT_SUMMARY where patient_id='"+patientid+"'";
	
	int patcnclcount=0;
	
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{	
		pstmt=con.prepareStatement(patCountSql);

		System.err.println("2768---updateOAPatCnclSummary------patCountSql-------------->"+patCountSql);

		rs=pstmt.executeQuery();

		System.err.println("2772----updateOAPatCnclSummary------patCountSql-------------->"+patCountSql);

		while(rs.next()){
			patcnclcount=rs.getInt(1);			
		}
		if(pstmt!=null) pstmt.close();
		if(rs != null) rs.close();
		//data will be inserted in oa_pat_cncl_appt_summary under two conditions
		//1.  When there is no record in oa_pat_cncl_appt_summary for this patient
		//2.  And when the cancel is initiated by the patient reason.
		if(patcnclcount==0 && (oa_param_cncl_reason.equals(reasonforcancellation))){//why this condition
			String insertPatCnclApptSql="insert into OA_PAT_CNCL_APPT_SUMMARY(FACILITY_ID,PATIENT_ID,APPT_CANCELLED_COUNT,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,        ADDED_FACILITY_ID,LAST_RESET_USER,LAST_RESET_DATE,Last_reset_work_station,Last_reset_FACILITY_ID) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			pstmt=con.prepareStatement(insertPatCnclApptSql);
			int field_count=1;
			pstmt.setString(field_count++,facilityId);
			pstmt.setString(field_count++,patientid);
			pstmt.setString(field_count++,patCnclCount);
			pstmt.setString(field_count++,addedById);
			pstmt.setString(field_count++,addedAtWorkstation);
			pstmt.setString(field_count++,facilityId);
			pstmt.setString(field_count++,addedById);
			pstmt.setString(field_count++,addedAtWorkstation);
			pstmt.setString(field_count++,facilityId);

			System.err.println("2796----updateOAPatCnclSummary------insertPatCnclApptSql-------------->"+insertPatCnclApptSql);

			pstmt.executeUpdate();

			System.err.println("2800-----updateOAPatCnclSummary-----insertPatCnclApptSql-------------->"+insertPatCnclApptSql);
		}//data will be updated in oa_pat_cncl_appt_summary under these conditions
		//1.  Updated to 0 When the patient is notified about the cancelled count and 'OK' is clicked in Schedule, Reschedule, Transfer, Cancel and modify
		//2.  Updated to anyother value during cancellation and the reason selected is patient initiated.
		
		else{
			//Updating audit columns
			String updatePatCnclApptSql="update OA_PAT_CNCL_APPT_SUMMARY set APPT_CANCELLED_COUNT=?,LAST_RESET_USER=?,LAST_RESET_DATE=sysdate,Last_reset_work_station=?,Last_reset_FACILITY_ID=? where patient_id=? and facility_id=?";
			pstmt=con.prepareStatement(updatePatCnclApptSql);
			int field_count=1;
			pstmt.setString(field_count++,patCnclCount);
			pstmt.setString(field_count++,addedById);
			pstmt.setString(field_count++,addedAtWorkstation);
			pstmt.setString(field_count++,facilityId);
			pstmt.setString(field_count++,patientid);
			pstmt.setString(field_count++,facilityId);

			System.err.println("2817-----updateOAPatCnclSummary-----updatePatCnclApptSql-------------->"+updatePatCnclApptSql);

			pstmt.executeUpdate();

			System.err.println("2821-----updateOAPatCnclSummary-----updatePatCnclApptSql-------------->"+updatePatCnclApptSql);
		}
		if(pstmt!=null) pstmt.close();
		if(rs != null) rs.close();
	}catch(Exception ex){
		
		System.err.println("2827-----updateOAPatCnclSummary-----Inside Catch-------------->"+ex.toString());

		result=false;
		ex.printStackTrace();
	}
	finally{
	}
	return result;
 }
 public static String checkForNull(String inputString)
 {
	return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
 }
}//class
