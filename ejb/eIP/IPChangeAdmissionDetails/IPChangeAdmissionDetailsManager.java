/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*******
Developed On 05/03/2009
Version 10.x
********/
package eIP.IPChangeAdmissionDetails;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import blipin.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="IPChangeAdmissionDetails"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPChangeAdmissionDetails"
*	local-jndi-name="IPChangeAdmissionDetails"
*	impl-class-name="eIP.IPChangeAdmissionDetails.IPChangeAdmissionDetailsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPChangeAdmissionDetails.IPChangeAdmissionDetailsLocal"
*	remote-class="eIP.IPChangeAdmissionDetails.IPChangeAdmissionDetailsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPChangeAdmissionDetails.IPChangeAdmissionDetailsLocalHome"
*	remote-class="eIP.IPChangeAdmissionDetails.IPChangeAdmissionDetailsHome"
*	generate= "local,remote"
*
*
*/
public class IPChangeAdmissionDetailsManager implements SessionBean {
	SessionContext ctx;
	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}
	
	/**
* @ejb.interface-method
*	 view-type="both"
*/

			public java.util.HashMap updateAdmissionDetails(java.util.Properties p,java.util.HashMap Tabdata){

				String	facility_id				=	"";	
				String	locale					=	"";
				String	client_ip_address		=	"";	
				String	 login_User				=	"";	
				
				String   patient_id				= "";
				String   encounter_id			= "";
				String   referral_id			= "";
				String   referral_id_old		= "";
				String   Gender					= "";
				String   patient_class			= "";
				String   bl_Operational			= "";
				String   bl_interfaced_yn		= "";
				String   admission_date_time	= "";
				String   adt_status				= "";

				String	frm_nursing_unit_code 	= "";
				String	frm_bed_no             	= "";
				String	frm_room_no             = "";
				String	to_admission_approval_details    = ""; //Added by Suji Keerthi for MMS-DM-CRF-0191 US002
				String   to_specialty_code		= "";
				String	to_nursing_unit_code 	= "";
				String	to_service_code         = "";
				String	to_subservice_code      = "";
				String	to_bed_class_code		= "";
				String	to_bed_type_code   		= "";
				String	to_bed_no             	= "";
				String	to_room_no             	= "";
				String	to_ambulatory_status	= "";
				String	to_admission_type		= "";
				String	to_exp_discharge_date_time  = "";
				String	to_ot_date_time			= "";
				String	to_practitioner_id		= "";
				String	to_admit_practitioner_id= "";
				String	to_revision_resn_code	= "";

				String adt_sts_bedNo			= "";
				String adt_sts_roomNo 			= "";
				String blocked_bedNo	 		= "";
				String tfr_req_status	 		= "";
				String admission_remarks 		= "";
				String customer_id 				= "";
				int male_cnt					= 0;
				int female_cnt					= 0;
				int unknown_cnt					= 0;
									



				boolean proceed					=	false;
				boolean srlnoAlert				=	false;
				boolean UpdateBedBkng			=	false;

				HashMap		    results			= new HashMap() ;
				StringBuffer Updt_PR_Enc		=	new StringBuffer();
				StringBuffer Updt_Ip_Adt_Trn	=	new StringBuffer();
				StringBuffer Updt_NU_RM_BD		=	new StringBuffer();
				StringBuffer Updt_Pr_Enc_Oth_Dtl=	new StringBuffer();
				StringBuffer Updt_BD_Bkng	    =	new StringBuffer();
				StringBuffer Updt_Ip_Trnfr_Req	= new StringBuffer();
				StringBuffer Updt_IP_Enc		= new StringBuffer();
				StringBuffer messageBuffer		=	new StringBuffer();
			
				Connection con	 =	null;
				PreparedStatement pr_enc_pt	=	null,ip_adtrn_pt=null,nu_rm_bd_pt=null,pr_enc_othdt_pt=null,bd_bkng_pt=null,ip_trnfr_pt=null,ip_enc_pt=null,pr_ref_pt=null;
				ResultSet bd_bkng_rs	 =	null;
				CallableStatement cstmt		= null;
				facility_id							 =	(String)Tabdata.get("facilityId");                         
				locale								 =	(String)Tabdata.get("locale");                         
				client_ip_address				 =	(String)Tabdata.get("client_ip_address");                         
				login_User						=	(String)Tabdata.get("login_User");                         
				patient_id							=  (String)Tabdata.get("patient_id");
				encounter_id						=  (String)Tabdata.get("encounter_id");
				referral_id						=  (String)Tabdata.get("referral_id");
				referral_id_old						=  (String)Tabdata.get("referral_id_old");
				
				Gender								=  (String)Tabdata.get("Gender");
				patient_class						=  (String)Tabdata.get("patient_class");
				bl_Operational					=  (String)Tabdata.get("bl_Operational");
				bl_interfaced_yn				=  (String)Tabdata.get("bl_interfaced_yn");
				admission_date_time		=  (String)Tabdata.get("admission_date_time");
				adt_status						=  (String)Tabdata.get("adt_status");

				frm_nursing_unit_code 	    =  (String)Tabdata.get("frm_nursing_unit_code");
				frm_bed_no             			 =	(String)Tabdata.get("frm_bed_no");
				frm_room_no             		 =	(String)Tabdata.get("frm_room_no");
				to_admission_approval_details             		 =	(String)Tabdata.get("to_admission_approval_details"); //Added by Suji Keerthi for MMS-DM-CRF-0191 US002
				to_specialty_code			=	(String)Tabdata.get("to_specialty_code");                         
				to_nursing_unit_code 	    =	(String)Tabdata.get("to_nursing_unit_code");                    
				to_service_code               = (String)Tabdata.get("to_service_code");                            
				to_subservice_code          = (String)Tabdata.get("to_subservice_code");                      
				to_bed_class_code			 =	(String)Tabdata.get("to_bed_class_code");                        
				to_bed_type_code   		 =	(String)Tabdata.get("to_bed_type_code");                        
				to_bed_no             			 =	(String)Tabdata.get("to_bed_no");                                     
				to_room_no             		 =	(String)Tabdata.get("to_room_no");                                   
				to_ambulatory_status		 =	(String)Tabdata.get("to_ambulatory_status");                    
				to_admission_type			 =	(String)Tabdata.get("to_admission_type");                         
				to_exp_discharge_date_time	=	(String)Tabdata.get("to_exp_discharge_date_time"); 	
//				to_exp_days_stay			 =	(String)Tabdata.get("to_exp_days_stay");                         
				to_ot_date_time				 =	(String)Tabdata.get("to_ot_date_time");                            
				to_practitioner_id				 =	(String)Tabdata.get("to_practitioner_id");                          
				to_admit_practitioner_id	 =	(String)Tabdata.get("to_admit_practitioner_id");                
				to_revision_resn_code		 =	(String)Tabdata.get("to_revision_reason_code");                         
				tfr_req_status		 =	(String)Tabdata.get("tfr_req_status");                         
				admission_remarks		 =	(String)Tabdata.get("admission_remarks");                         
				customer_id					=	(String)Tabdata.get("customer_id");                         

//String BLOCK_BED="";
				
				try{

						if(adt_status.equals("00")){
							adt_sts_bedNo		=	to_bed_no;
							adt_sts_roomNo	=	to_room_no;
//							blocked_bedNo	=	to_bed_no;
							to_bed_no	="";
//							BLOCK_BED="BLOCKED_BED_NO="+blocked_bedNo+",";
							UpdateBedBkng=true;
						}else{
//							to_bed_no		=	to_bed_no;
//							adt_sts_roomNo	=	to_room_no;
							blocked_bedNo	=	"";
//							BLOCK_BED	= "";
							UpdateBedBkng=false;
						}

						if(Gender.equals("M"))male_cnt =1;
						if(Gender.equals("F"))female_cnt =1;
						if(Gender.equals("U"))unknown_cnt =1;

						con = ConnectionManager.getConnection(p);
					int srl_no	=	0;
					/*Friday, May 14, 2010 , update will done through IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO on ip_bed_booking_srl_ctrl*/
					try
					{
						if(!adt_sts_bedNo.equals("") && !frm_bed_no.equals("") && !frm_bed_no.equals(adt_sts_bedNo) ){
								cstmt=con.prepareCall("{call IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO(?,?,?,?,?,?)}");
								cstmt.setString(1,facility_id);
								cstmt.setString(2,"B");
								cstmt.setString(3,"Y");
								cstmt.setString(4,client_ip_address);
								cstmt.setString(5,login_User);
								cstmt.registerOutParameter(6,java.sql.Types.NUMERIC);
								cstmt.execute();
								srl_no=cstmt.getInt(6);
								if(cstmt != null) cstmt.close();
								if(srl_no<1){
									proceed=false;
									srlnoAlert=true;
								}else{
									proceed	=	true;
								}
						}
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}


					
					
					/**/

					/*Updating PR_ENCOUNTER Table With New Changed Admission (i.e to_)Values */
						try{
								
								/*Thursday, November 25, 2010 , SRR20056-SCF-6046 [IN:025165]*/
								try
								{
									cstmt = con.prepareCall("{call IP_AUDIT_FUNCTION.ASSIGN_VALUE('Y')}");
									cstmt.execute();
								if(cstmt!=null) cstmt.close();
								}catch(Exception exception)
								{
									exception.printStackTrace();
								}
								/**/
								int pr_cnt = 0;
								Updt_PR_Enc.append("UPDATE PR_ENCOUNTER SET SPECIALTY_CODE = ?,  ASSIGN_CARE_LOCN_CODE = ?,SERVICE_CODE= ?,SUBSERVICE_CODE=?,ASSIGN_BED_CLASS_CODE=?,ASSIGN_BED_TYPE_CODE=?,ASSIGN_BED_NUM = ?,ASSIGN_ROOM_NUM = ?,VISIT_ADM_TYPE=?,AMBULATORY_STATUS= ?,EXP_DISCHARGE_DATE_TIME=to_date(?,'dd/mm/rrrr hh24:MI'),ADMIT_PRACTITIONER_ID=?, ATTEND_PRACTITIONER_ID = ?,CONTACT_REASON_CODE=?,ENC_MODIFIED_YN=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,PAT_CURR_LOCN_CODE=?,referral_id =?,ADMISSION_APPROVAL_DETAILS = ? ");
								if(customer_id.equals("AMRI"))
								{
									Updt_PR_Enc.append(",admission_remarks = ? ");
								}
								Updt_PR_Enc.append(" WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ? ");
							
								pr_enc_pt	 =	con.prepareStatement(Updt_PR_Enc.toString());
								pr_enc_pt.setString(1,to_specialty_code);
								pr_enc_pt.setString(2,to_nursing_unit_code);
								pr_enc_pt.setString(3,to_service_code);
								pr_enc_pt.setString(4,to_subservice_code);
								pr_enc_pt.setString(5,to_bed_class_code);
								pr_enc_pt.setString(6,to_bed_type_code.trim());
								pr_enc_pt.setString(7,to_bed_no);
								pr_enc_pt.setString(8,to_room_no);
								pr_enc_pt.setString(9,to_admission_type);
								pr_enc_pt.setString(10,to_ambulatory_status);
								pr_enc_pt.setString(11,to_exp_discharge_date_time);
								pr_enc_pt.setString(12,to_admit_practitioner_id);
								pr_enc_pt.setString(13,to_practitioner_id);
								pr_enc_pt.setString(14,to_revision_resn_code);
								pr_enc_pt.setString(15,"Y");
								pr_enc_pt.setString(16,login_User);
								pr_enc_pt.setString(17,client_ip_address);
								pr_enc_pt.setString(18,facility_id);
								pr_enc_pt.setString(19,to_nursing_unit_code);
								pr_enc_pt.setString(20,referral_id);
								pr_enc_pt.setString(21,to_admission_approval_details);
								if(customer_id.equals("AMRI"))
								{
									pr_enc_pt.setString(22,admission_remarks);
									pr_enc_pt.setString(23,facility_id);
									pr_enc_pt.setString(24,encounter_id);
								}else
								{
									pr_enc_pt.setString(22,facility_id);
									pr_enc_pt.setString(23,encounter_id);
								}
								pr_cnt=pr_enc_pt.executeUpdate();
							if(pr_cnt>0){
								proceed	=	true;
							}else{
								proceed	=	false;
							}
							if(pr_enc_pt!=null)pr_enc_pt.close();
			}catch(Exception ex){
				proceed=false;
			ex.printStackTrace();
		 }//PR_ENCOUNTER UPDATION ENDS


/**
Updation Of  the Table PR_ENCOUNTER_OTHER_DETAIL only the values modified from this Function
Once PR_ENCOUNTER is completed.
**/
		if (proceed){
			try{
					int pr_dtl_cnt	=	0;
				Updt_Pr_Enc_Oth_Dtl.append("UPDATE PR_ENCOUNTER_OTHER_DETAIL SET EXP_DISCHARGE_DATE_TIME= to_date(?,'dd/mm/rrrr hh24:MI'),EXP_SURGERY_DATE_TIME=to_date(?,'dd/mm/rrrr hh24:MI'),MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND ENCOUNTER_ID=?");
				pr_enc_othdt_pt	= con.prepareStatement(Updt_Pr_Enc_Oth_Dtl.toString());
				pr_enc_othdt_pt.setString(1,to_exp_discharge_date_time);
				pr_enc_othdt_pt.setString(2,to_ot_date_time);
				pr_enc_othdt_pt.setString(3,login_User);          
				pr_enc_othdt_pt.setString(4,client_ip_address);
				pr_enc_othdt_pt.setString(5,facility_id); 
				pr_enc_othdt_pt.setString(6,facility_id); 
				pr_enc_othdt_pt.setString(7,encounter_id); 
				pr_dtl_cnt	= pr_enc_othdt_pt.executeUpdate();
				if (pr_dtl_cnt>0){
					proceed=true;
				}else{
					proceed=false;
				}
			}catch(Exception ex){
				proceed=false;
				ex.printStackTrace();
			}
		}
		/*Once PR_ENCOUNTER && PR_ENCOUNTER_OTHER_DETAIL is upadated successfuly then IP_ADT_TRN updation will continue*/
			if (proceed){
				try{
							int adt_cnt=0;
							Updt_Ip_Adt_Trn.append("UPDATE  IP_ADT_TRN SET TO_SPECIALTY_CODE=?,TO_NURSING_UNIT=?, TO_SERVICE_CODE=?,  TO_SUBSERVICE_CODE=?,TO_BED_CLASS_CODE=?,TO_BED_TYPE_CODE=?,TO_BED_NO=?,TO_ROOM_NO=?,     EXPECTED_DISCHARGE_DATE=to_date(?,'dd/mm/rrrr hh24:MI'), OT_DATE_TIME=to_date(?,'dd/mm/rrrr hh24:MI'),TO_PRACTITIONER_ID=?,TO_BED_TYPE_CODE_BY_DEFN=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND SRL_NO=? AND ENCOUNTER_ID=?");

							ip_adtrn_pt=con.prepareStatement(Updt_Ip_Adt_Trn.toString());
							ip_adtrn_pt.setString(1,to_specialty_code);            
							ip_adtrn_pt.setString(2,to_nursing_unit_code);        
							ip_adtrn_pt.setString(3,to_service_code);               
							ip_adtrn_pt.setString(4,to_subservice_code);          
							ip_adtrn_pt.setString(5,to_bed_class_code);           
							ip_adtrn_pt.setString(6,to_bed_type_code);  
							ip_adtrn_pt.setString(7,to_bed_no);                        
							ip_adtrn_pt.setString(8,to_room_no);                      
							ip_adtrn_pt.setString(9,to_exp_discharge_date_time);
							ip_adtrn_pt.setString(10,to_ot_date_time);
							ip_adtrn_pt.setString(11,to_practitioner_id);
							ip_adtrn_pt.setString(12,to_bed_type_code);
							ip_adtrn_pt.setString(13,login_User);          
							ip_adtrn_pt.setString(14,client_ip_address);
							ip_adtrn_pt.setString(15,facility_id); 
//							ip_adtrn_pt.setString(15,patient_class);
							ip_adtrn_pt.setString(16,facility_id);
							ip_adtrn_pt.setString(17,"1");
							ip_adtrn_pt.setString(18,encounter_id);
							adt_cnt=ip_adtrn_pt.executeUpdate();
							if (adt_cnt>0){
								proceed=true;
							}else{
								proceed=false;
						}

				}catch(Exception ex){
					proceed=false;
					ex.printStackTrace();
			}//IP_ADT_TRN UPDTION ENDS
		}

			if (proceed){
				try{							
							int ref_cnt=0;		
							int ref_cnt_old=0;		
							
							   if(!(referral_id_old.equals("")) && referral_id!=referral_id_old){
							       /*Added audit column in the query*/
									pr_ref_pt=con.prepareStatement("update  pr_referral_register set status = 'O' , referred_in_func=null, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where referral_id = ?");		
									pr_ref_pt.setString(1,login_User); 
									pr_ref_pt.setString(2,client_ip_address); 
									pr_ref_pt.setString(3,facility_id); 
									pr_ref_pt.setString(4,referral_id_old);           
									ref_cnt_old=pr_ref_pt.executeUpdate();									
									if (ref_cnt_old>0){
										proceed=true;
									}else{
										proceed=false;							
									}
									if (pr_ref_pt != null)
										pr_ref_pt.close();
							  }
							  if(!(referral_id.equals(""))){
							  /*Added audit column in the query*/
								pr_ref_pt=con.prepareStatement("update  pr_referral_register set status = 'C' , referred_in_func = 5, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where referral_id = ?");		
								pr_ref_pt.setString(1,login_User); 
                                pr_ref_pt.setString(2,client_ip_address);
                                pr_ref_pt.setString(3,facility_id);
                                pr_ref_pt.setString(4,referral_id); 								
								ref_cnt=pr_ref_pt.executeUpdate();								
								if (ref_cnt>0){
									proceed=true;
								}else{
									proceed=false;							 
								}
								if (pr_ref_pt != null)
									pr_ref_pt.close();
						  }

				}catch(Exception ex){
					proceed=false;
					ex.printStackTrace();
			}
		} 
/*


UPDATE IP_TRANSFER_REQUEST 
SET TFR_REQ_STATUS = DECODE(TFR_REQ_STATUS, '0', '2', '1', '2', '3','9')
WHERE 
FACILITY_ID = 
AND ENCOUNTER_ID = 
AND TFR_REQ_STATUS < 4

*/

/**
Note:After Updating the above tables 
IP_BED_BOOKING will update to realse the From Bed When Adt_Status is 00    Only these Following Tables will update.
as follows
**/

				int bd_bk_cnt	=	0;
				
				String block_date	=	"";

			if(UpdateBedBkng){
			if(!frm_bed_no.equals("")){
			if(proceed){
				try{

				if(Updt_BD_Bkng.length()>0)Updt_BD_Bkng.delete(0,Updt_BD_Bkng.length());
				if(bd_bkng_pt!=null)bd_bkng_pt.close();

				Updt_BD_Bkng.append("UPDATE IP_BED_BOOKING SET BOOKING_STATUS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE  FACILITY_ID=? AND BOOKING_TYPE =? AND REQ_NURSING_UNIT_CODE=? AND BOOKING_STATUS=? AND REQ_BED_NO=? ");
				bd_bkng_pt=con.prepareStatement(Updt_BD_Bkng.toString());
				bd_bkng_pt.setString(1,"4");
				bd_bkng_pt.setString(2,login_User);
				bd_bkng_pt.setString(3,client_ip_address);
				bd_bkng_pt.setString(4,facility_id);
				bd_bkng_pt.setString(5,facility_id);
				bd_bkng_pt.setString(6,"B");
				bd_bkng_pt.setString(7,frm_nursing_unit_code);
				bd_bkng_pt.setString(8,"0");
				bd_bkng_pt.setString(9,frm_bed_no);
				//int upt=bd_bkng_pt.executeUpdate();


				if(Updt_BD_Bkng.length()>0)Updt_BD_Bkng.delete(0,Updt_BD_Bkng.length());
				if(bd_bkng_pt!=null)bd_bkng_pt.close();
				}catch(Exception ex){
					proceed=false;
					ex.printStackTrace();
				}
			}
		}
/*If  Block Bed Number is Not Empty*/

			if(proceed ){
				try{
				if(!adt_sts_bedNo.equals("") && !frm_bed_no.equals(adt_sts_bedNo)){
			
				if(Updt_BD_Bkng.length()>0)Updt_BD_Bkng.delete(0,Updt_BD_Bkng.length());
				if(bd_bkng_pt!=null)bd_bkng_pt.close();
				if(bd_bkng_rs!=null)bd_bkng_rs.close();
				/*Friday, May 14, 2010 , update will done through IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO at line no 205*/
				/*
				Updt_BD_Bkng.append("SELECT NEXT_BOOKING_SRL_NO SRL_NO FROM IP_BED_BOOKING_SRL_CTRL WHERE FACILITY_ID = '"+facility_id+"' AND BOOKING_TYPE = 'B' AND GEN_BOOKING_SRL_YN = 'Y'");
				
				bd_bkng_pt	=	con.prepareStatement(Updt_BD_Bkng.toString());
				bd_bkng_rs	=	bd_bkng_pt.executeQuery();
				
				if(bd_bkng_rs!=null && bd_bkng_rs.next()){
						srl_no=bd_bkng_rs.getInt("SRL_NO");

				}//Retriving Srl No Ends
				if(srl_no<1){
					proceed=false;
					srlnoAlert=true;
				}*/

					if(proceed){
						if(Updt_BD_Bkng.length()>0)Updt_BD_Bkng.delete(0,Updt_BD_Bkng.length());
						if(bd_bkng_pt!=null)bd_bkng_pt.close();
						if(bd_bkng_rs!=null)bd_bkng_rs.close();
						
						 Updt_BD_Bkng.append("SELECT BED_BLOCK_PERIOD_NORMAL, TO_CHAR((SYSDATE + BED_BLOCK_PERIOD_NORMAL/24),'DD/MM/RRRR HH24:MI')  BLOCKED_UNTIL_DATE_TIME FROM IP_PARAM WHERE FACILITY_ID ='"+facility_id+"'");
						bd_bkng_pt	=	con.prepareStatement(Updt_BD_Bkng.toString());
						bd_bkng_rs	=	bd_bkng_pt.executeQuery();
					
						if(bd_bkng_rs!=null && bd_bkng_rs.next()){
								block_date=bd_bkng_rs.getString("BLOCKED_UNTIL_DATE_TIME");

						}else{
							proceed=false;
						}//Retriving Block_Date is ends 

						if(Updt_BD_Bkng.length()>0)Updt_BD_Bkng.delete(0,Updt_BD_Bkng.length());
						if(bd_bkng_pt!=null)bd_bkng_pt.close();
						if(bd_bkng_rs!=null)bd_bkng_rs.close();
						/*Friday, May 14, 2010 , update will done through IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO at line no 205*/
						/*
						Updt_BD_Bkng.append("UPDATE IP_BED_BOOKING_SRL_CTRL SET NEXT_BOOKING_SRL_NO=NEXT_BOOKING_SRL_NO+1 , MODIFIED_BY_ID =?,MODIFIED_AT_WS_NO =?,MODIFIED_DATE = SYSDATE,MODIFIED_FACILITY_ID =?  WHERE  FACILITY_ID= ? AND BOOKING_TYPE = 'B' AND GEN_BOOKING_SRL_YN = 'Y' ");
						bd_bkng_pt = con.prepareStatement( Updt_BD_Bkng.toString() );
						bd_bkng_pt.setString(1,login_User);
						bd_bkng_pt.setString(2,client_ip_address);
						bd_bkng_pt.setString(3,facility_id);
						bd_bkng_pt.setString(4,facility_id);
						//int srs = bd_bkng_pt.executeUpdate();
						proceed = true;
						*/
					}
					if(proceed){
						if(Updt_BD_Bkng.length()>0)Updt_BD_Bkng.delete(0,Updt_BD_Bkng.length());
						if(bd_bkng_pt!=null)bd_bkng_pt.close();
//						if(bd_bkng_rs!=null)bd_bkng_rs.close();
						Updt_BD_Bkng.append("INSERT INTO IP_BED_BOOKING (FACILITY_ID, BOOKING_TYPE,BED_BOOKING_REF_NO,ENCOUNTER_ID, PATIENT_ID, BOOKING_DATE_TIME,BOOKED_BY_ID,REQ_NURSING_UNIT_CODE,REQ_SERVICE_CODE,REQ_BED_NO,REQ_ROOM_NO,REQ_BED_CLASS_CODE,REQ_BED_TYPE_CODE,REQ_PRACTITIONER_ID,REQ_SPECIALTY_CODE,BLOCKED_FROM_DATE_TIME,BLOCKED_UNTIL_DATE_TIME,BOOKING_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,OVERRIDE_YN) VALUES");
						Updt_BD_Bkng.append("(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,sysdate,to_date(?,'dd/mm/rrrr hh24:MI'),?,?,sysdate,?,?,?,sysdate,?,?,?) ");
						
						bd_bkng_pt = con.prepareStatement(Updt_BD_Bkng.toString());
						bd_bkng_pt.setString(1,  facility_id);
						bd_bkng_pt.setString(2,  "B");
						bd_bkng_pt.setInt(3,  srl_no);
						bd_bkng_pt.setString(4,  encounter_id);
						bd_bkng_pt.setString(5,  patient_id);
						bd_bkng_pt.setString(6,  login_User);
						bd_bkng_pt.setString(7,  to_nursing_unit_code);
						bd_bkng_pt.setString(8,  to_service_code);
						bd_bkng_pt.setString(9,  adt_sts_bedNo);
						bd_bkng_pt.setString(10, adt_sts_roomNo);
						bd_bkng_pt.setString(11, to_bed_class_code);
						bd_bkng_pt.setString(12, to_bed_type_code);
						bd_bkng_pt.setString(13, to_admit_practitioner_id);
						bd_bkng_pt.setString(14, to_specialty_code);
						bd_bkng_pt.setString(15, block_date);
						bd_bkng_pt.setString(16, "0");
						bd_bkng_pt.setString(17, login_User);
						bd_bkng_pt.setString(18, client_ip_address);
						bd_bkng_pt.setString(19, facility_id);
						bd_bkng_pt.setString(20, login_User);
						bd_bkng_pt.setString(21, client_ip_address);
						bd_bkng_pt.setString(22, facility_id);
						bd_bkng_pt.setString(23,"Y");

						bd_bk_cnt	=	bd_bkng_pt.executeUpdate();

						if(bd_bk_cnt>0){
							proceed	=	true;
						}else{
							proceed	=	false;
						}
					}// proceed IP_BED_BOOKING ENDS

				if(proceed){
					blocked_bedNo=adt_sts_bedNo;
				try{
					int ip_enc_cnt	=	0;
					Updt_IP_Enc.append("UPDATE IP_OPEN_ENCOUNTER SET BLOCKED_BED_NO=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, REFERRAL_ID =? WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ? ");
					ip_enc_pt	 =	con.prepareStatement(Updt_IP_Enc.toString());
					ip_enc_pt.setString(1,blocked_bedNo);
					ip_enc_pt.setString(2,login_User);
					ip_enc_pt.setString(3,client_ip_address);
					ip_enc_pt.setString(4,facility_id);
					ip_enc_pt.setString(5,referral_id);
					ip_enc_pt.setString(6,facility_id);
					ip_enc_pt.setString(7,encounter_id);
					ip_enc_cnt=ip_enc_pt.executeUpdate();
					if(ip_enc_cnt>0){
						proceed=true;
					}else{
						proceed=false;
					}
					if(ip_enc_pt != null) ip_enc_pt.close();
				}catch(Exception ex){
						proceed=false;
					ex.printStackTrace();
	
				}
			}
		}
	}catch(Exception ex){
				proceed=false;
				ex.printStackTrace();
			}finally{
				if(bd_bkng_pt!=null)bd_bkng_pt.close();
				if(bd_bkng_rs!=null)bd_bkng_rs.close();
				if(ip_enc_pt!=null)ip_enc_pt.close();
			}
	}
}

/**
Note:The Updation OF the following tables will done Only ADT_STATUS  is 01
Note:
Once updation of  both tables PR_ENCOUNTER, IP_ADT_TRN & IP_ENCOUNTER_OTHER_DETAIL  is successfully completed,
1.If to_bed_no & to_room_no is empty no updation will take place 
2.If to_bed_no & to_room_no is not empty  ( when adt_status is01).
then IP_NURSING_UNIT,IP_NURSING_UNIT_ROOM, IP_NURSING_UNIT_BED & IP_BED_BOOKING  will Update.
 **/
/**Note:
1.if   nursingunits(From &To) are different then increase the  NUM_OF_BEDS_OCCUPIED to+1
in IP_NURSING_UNIT table for To Nursingunit and decrease the NUM_OF_BEDS_OCCUPIED to-1
in Same table for From Nursingunit .
The same thing was  implemented as follows For Two Different Nursing Units
**/
if(!UpdateBedBkng){

	if(!to_bed_no.equals("")&&!to_room_no.equals("")){
		if(proceed){
				try{
					int nu_cnt=0;
					int rm_cnt=0;
					int bd_cnt=0;

					if(!(to_nursing_unit_code.equals(frm_nursing_unit_code))){

						Updt_NU_RM_BD.append("UPDATE IP_NURSING_UNIT SET NUM_OF_BEDS_OCCUPIED=NUM_OF_BEDS_OCCUPIED-1,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND NURSING_UNIT_CODE=?");
						nu_rm_bd_pt	=	con.prepareStatement(Updt_NU_RM_BD.toString());
						nu_rm_bd_pt.setString(1,login_User);          
						nu_rm_bd_pt.setString(2,client_ip_address);
						nu_rm_bd_pt.setString(3,facility_id); 
						nu_rm_bd_pt.setString(4,facility_id);
						nu_rm_bd_pt.setString(5,frm_nursing_unit_code);
						nu_rm_bd_pt.executeUpdate();
						
						if(Updt_NU_RM_BD.length()>0)Updt_NU_RM_BD.delete(0,Updt_NU_RM_BD.length());
						if(nu_rm_bd_pt!=null)nu_rm_bd_pt.close();
						
						Updt_NU_RM_BD.append("UPDATE IP_NURSING_UNIT SET NUM_OF_BEDS_OCCUPIED=NUM_OF_BEDS_OCCUPIED+1,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND NURSING_UNIT_CODE=?");
						nu_rm_bd_pt	=	con.prepareStatement(Updt_NU_RM_BD.toString());
						nu_rm_bd_pt.setString(1,login_User);          
						nu_rm_bd_pt.setString(2,client_ip_address);
						nu_rm_bd_pt.setString(3,facility_id); 
						nu_rm_bd_pt.setString(4,facility_id);
						nu_rm_bd_pt.setString(5,to_nursing_unit_code);
						nu_cnt=nu_rm_bd_pt.executeUpdate();
						if(nu_cnt>0){
							proceed=true;
						}else{
							proceed=false;
						}
					}//Updation Of IP_NURSING_UNIT Ends

/**
NOte:2
1.This Updation Based on the Patient Gender .
2.if   Rooms(From &To) are different then decrease the  OCC_MALE_BED_COUNT,
OCC_FEMALE_BED_COUNT,OCC_UNKNOWN_BED_COUNT to -1
in IP_NURSING_UNIT_ROOM table for From Nursingunit and From ROOM_NUM and increase the the same coloumns to +1
in Same table for TO Nursingunit and To ROOM_NUM .

3.The same thing was  implemented as follows For Two Different Rooms

**/
			if(!to_room_no.equals("")&&!frm_room_no.equals("")){
				if(!(to_room_no.equals(frm_room_no))){
				
						if(Updt_NU_RM_BD.length()>0)Updt_NU_RM_BD.delete(0,Updt_NU_RM_BD.length());
						if(nu_rm_bd_pt!=null)nu_rm_bd_pt.close();
						Updt_NU_RM_BD.append("UPDATE	IP_NURSING_UNIT_ROOM SET OCC_MALE_BED_COUNT=OCC_MALE_BED_COUNT-?,OCC_FEMALE_BED_COUNT=OCC_FEMALE_BED_COUNT-?,OCC_UNKNOWN_BED_COUNT=OCC_UNKNOWN_BED_COUNT-?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND NURSING_UNIT_CODE=? AND ROOM_NO=?");

						nu_rm_bd_pt=con.prepareStatement(Updt_NU_RM_BD.toString());
						nu_rm_bd_pt.setInt(1,male_cnt);
						nu_rm_bd_pt.setInt(2,female_cnt);
						nu_rm_bd_pt.setInt(3,unknown_cnt);
						nu_rm_bd_pt.setString(4,login_User);          
						nu_rm_bd_pt.setString(5,client_ip_address);
						nu_rm_bd_pt.setString(6,facility_id); 
						nu_rm_bd_pt.setString(7,facility_id);
						nu_rm_bd_pt.setString(8,frm_nursing_unit_code);
						nu_rm_bd_pt.setString(9,frm_room_no);
						nu_rm_bd_pt.executeUpdate();

						if(Updt_NU_RM_BD.length()>0)Updt_NU_RM_BD.delete(0,Updt_NU_RM_BD.length());
						if(nu_rm_bd_pt!=null)nu_rm_bd_pt.close();

						Updt_NU_RM_BD.append("UPDATE	IP_NURSING_UNIT_ROOM SET OCC_MALE_BED_COUNT=OCC_MALE_BED_COUNT+?,OCC_FEMALE_BED_COUNT=OCC_FEMALE_BED_COUNT+?,OCC_UNKNOWN_BED_COUNT=OCC_UNKNOWN_BED_COUNT+?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND NURSING_UNIT_CODE=? AND ROOM_NO=?");
						nu_rm_bd_pt=con.prepareStatement(Updt_NU_RM_BD.toString());
						nu_rm_bd_pt.setInt(1,male_cnt);
						nu_rm_bd_pt.setInt(2,female_cnt);
						nu_rm_bd_pt.setInt(3,unknown_cnt);
						nu_rm_bd_pt.setString(4,login_User);          
						nu_rm_bd_pt.setString(5,client_ip_address);
						nu_rm_bd_pt.setString(6,facility_id); 
						nu_rm_bd_pt.setString(7,facility_id);
						nu_rm_bd_pt.setString(8,to_nursing_unit_code);
						nu_rm_bd_pt.setString(9,to_room_no);
						rm_cnt=nu_rm_bd_pt.executeUpdate();
						if(rm_cnt>0){
							proceed=true;
						}else{
							proceed=false;
						}

				}

			}

/**
Note :3
1.if   Beds(From &To) are different then update OCCUPYING_PATIENT_ID to null,
OCCUPIED_UNTIL_DATE_TIME to null and CURRENT_STATUS to"A"
in IP_NURSING_UNIT_BED table for From Nursingunit and From BED_NUM and update 
OCCUPYING_PATIENT_ID to respective Patient ID and Current Status to "O" in table IP_NURSING_UNIT_BED 
for TO Nursingunit and To ROOM_NUM .

2.The same thing was  implemented as follows For Two Different BEDS

**/
		if(!to_bed_no.equals("")&&!frm_bed_no.equals("")){
			if(!(to_bed_no.equals(frm_bed_no))){
				String update_Ocupied_date="";
				if(!to_exp_discharge_date_time.equals("")){
					update_Ocupied_date="OCCUPIED_UNTIL_DATE_TIME=to_date('"+to_exp_discharge_date_time+"','dd/mm/rrrr hh24:MI'),";
				}
				if(Updt_NU_RM_BD.length()>0)Updt_NU_RM_BD.delete(0,Updt_NU_RM_BD.length());
				if(nu_rm_bd_pt!=null)nu_rm_bd_pt.close();

				Updt_NU_RM_BD.append("UPDATE IP_NURSING_UNIT_BED SET OCCUPYING_PATIENT_ID=?,OCCUPIED_UNTIL_DATE_TIME=?, CURRENT_STATUS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND NURSING_UNIT_CODE=? AND BED_NO=?");
				nu_rm_bd_pt	=	con.prepareStatement(Updt_NU_RM_BD.toString());
				nu_rm_bd_pt.setString(1,null);
				nu_rm_bd_pt.setString(2,null);
				nu_rm_bd_pt.setString(3,"A");
				nu_rm_bd_pt.setString(4,login_User);
				nu_rm_bd_pt.setString(5,client_ip_address);
				nu_rm_bd_pt.setString(6,facility_id);
				nu_rm_bd_pt.setString(7,facility_id);
				nu_rm_bd_pt.setString(8,frm_nursing_unit_code);
				nu_rm_bd_pt.setString(9,frm_bed_no);
				nu_rm_bd_pt.executeUpdate();

				if(Updt_NU_RM_BD.length()>0)Updt_NU_RM_BD.delete(0,Updt_NU_RM_BD.length());
				if(nu_rm_bd_pt!=null)nu_rm_bd_pt.close();

				Updt_NU_RM_BD.append("UPDATE IP_NURSING_UNIT_BED SET OCCUPYING_PATIENT_ID=?,"+update_Ocupied_date+" CURRENT_STATUS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND NURSING_UNIT_CODE=? AND BED_NO=?");
				nu_rm_bd_pt	=	con.prepareStatement(Updt_NU_RM_BD.toString());
				nu_rm_bd_pt.setString(1,patient_id);
				nu_rm_bd_pt.setString(2,"O");
				nu_rm_bd_pt.setString(3,login_User);
				nu_rm_bd_pt.setString(4,client_ip_address);
				nu_rm_bd_pt.setString(5,facility_id);
				nu_rm_bd_pt.setString(6,facility_id);
				nu_rm_bd_pt.setString(7,to_nursing_unit_code);
				nu_rm_bd_pt.setString(8,to_bed_no);
				bd_cnt=nu_rm_bd_pt.executeUpdate();
				if (bd_cnt>0){
					proceed=true;
				}else{
					proceed=false;
				}


		}//Checking Equality values for to_bed_no and frm_bed_no ends
	}//Checking empty values for to_bed_no and frm_bed_no ends 
}catch(Exception ex){
					proceed=false;
					ex.printStackTrace();
			}

		}//Checking Of Proceed Ends
	}////Checking Empty Of Bed No and Room No Ends
			/*Note:
 IP_TRANSFER_REQUEST will update only when ADT_STATUS is 01.Cancelling of any transfer request if made*/
			int trnsfr_cnt=0;
			try{
				Updt_Ip_Trnfr_Req.append("UPDATE IP_TRANSFER_REQUEST  SET TFR_REQ_STATUS = DECODE(TFR_REQ_STATUS, '0', '2', '1', '2', '3','9'),BED_CLASS_REQ_STATUS='0',MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE  FACILITY_ID = ? AND ENCOUNTER_ID = ? AND TFR_REQ_STATUS IN ('0','1','3')");
				ip_trnfr_pt=con.prepareStatement(Updt_Ip_Trnfr_Req.toString());
				ip_trnfr_pt.setString(1,login_User);
				ip_trnfr_pt.setString(2,client_ip_address);
				ip_trnfr_pt.setString(3,facility_id);
				ip_trnfr_pt.setString(4,facility_id);
				ip_trnfr_pt.setString(5,encounter_id);
				trnsfr_cnt=ip_trnfr_pt.executeUpdate();

				proceed=true;

		}catch(Exception ex){
			proceed=false;
			ex.printStackTrace();
		}
		/*Wednesday, June 24, 2009  IN011764*/

		if(proceed && (!tfr_req_status.equals(""))){
					try{
					int ip_enc_cnt	=	0;
					//Updt_IP_Enc.append("UPDATE IP_OPEN_ENCOUNTER SET TFR_REQ_STATUS="",MODIFIED_BY_ID='"+login_User+"',MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO='"+client_ip_address+"',MODIFIED_FACILITY_ID='"+facility_id+"' WHERE FACILITY_ID = '"+facility_id+"' AND ENCOUNTER_ID = '"+encounter_id+"' and TFR_REQ_STATUS IN ('0','1','3')");
					Updt_IP_Enc.append("UPDATE IP_OPEN_ENCOUNTER SET TFR_REQ_STATUS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ? and TFR_REQ_STATUS IN ('0','1','3')");
					ip_enc_pt	 =	con.prepareStatement(Updt_IP_Enc.toString());
					ip_enc_pt.setString(1,"");
					ip_enc_pt.setString(2,login_User);
					ip_enc_pt.setString(3,client_ip_address);
					ip_enc_pt.setString(4,facility_id);
					ip_enc_pt.setString(5,facility_id);
					ip_enc_pt.setString(6,encounter_id);
					
					ip_enc_cnt=ip_enc_pt.executeUpdate();

					
						proceed=true;
					

				}catch(Exception ex){
						proceed=false;
					ex.printStackTrace();
	
				}
			}
/**/

}//Checking For ADT_STATUS is  01 ENDS
				if (proceed){
					if(messageBuffer.length() > 0) messageBuffer.delete(0,messageBuffer.length());
					java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
					messageBuffer.append( (String) message.get("message"));
					con.commit();
				}else{
					if(srlnoAlert){
					if(messageBuffer.length() > 0) messageBuffer.delete(0,messageBuffer.length());
					java.util.Hashtable message = MessageManager.getMessage(locale, "BED_BKG_SRL_CTRL_NOT_DEFINED","IP");
					messageBuffer.append( (String) message.get("message"));
					con.rollback();
					}else{
					if(messageBuffer.length() > 0) messageBuffer.delete(0,messageBuffer.length());
					java.util.Hashtable message = MessageManager.getMessage(locale, "ERROR_WHILE_UPDATING","IP");
					messageBuffer.append( (String) message.get("message"));
					con.rollback();
					}
				}
		}catch(Exception ex){
					ex.printStackTrace(System.err);
			}finally{
					try{
							if(con!=null)ConnectionManager.returnConnection(con,p);
							if (pr_enc_pt!=null)pr_enc_pt.close();
							if (ip_adtrn_pt!=null)ip_adtrn_pt.close();
							if (pr_ref_pt!=null)pr_ref_pt.close();
							if (nu_rm_bd_pt!=null)nu_rm_bd_pt.close();
							if (pr_enc_othdt_pt!=null)pr_enc_othdt_pt.close();
							if (bd_bkng_pt!=null)bd_bkng_pt.close();
							if (ip_trnfr_pt!=null)ip_trnfr_pt.close();
							if (ip_enc_pt!=null)ip_enc_pt.close();
							if(Updt_PR_Enc.length()>0)Updt_PR_Enc.delete(0,Updt_PR_Enc.length());
							if(Updt_Ip_Adt_Trn.length()>0)Updt_Ip_Adt_Trn.delete(0,Updt_Ip_Adt_Trn.length());
							if(Updt_NU_RM_BD.length()>0)Updt_NU_RM_BD.delete(0,Updt_NU_RM_BD.length());
							if(Updt_Pr_Enc_Oth_Dtl.length()>0)Updt_Pr_Enc_Oth_Dtl.delete(0,Updt_Pr_Enc_Oth_Dtl.length());
							if(Updt_BD_Bkng.length()>0)Updt_BD_Bkng.delete(0,Updt_BD_Bkng.length());
							if(Updt_Ip_Trnfr_Req.length()>0)Updt_Ip_Trnfr_Req.delete(0,Updt_Ip_Trnfr_Req.length());
					}catch(Exception ex1){}
		}
		results.put("status", new Boolean(proceed));
		results.put("error", messageBuffer.toString());
		return results;
	}
}
