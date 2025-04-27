/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
This ejb is used to cancel the admission.
@version - V3
*/

package eIP.IPCancelAdmission;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import webbeans.eCommon.*;
import eCommon.Common.*;//Added fo ML-MMOH-CRF-1972 ISSUE
/**
*
* @ejb.bean
*	name="IPCancelAdmission"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPCancelAdmission"
*	local-jndi-name="IPCancelAdmission"
*	impl-class-name="eIP.IPCancelAdmission.IPCancelAdmissionManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPCancelAdmission.IPCancelAdmissionLocal"
*	remote-class="eIP.IPCancelAdmission.IPCancelAdmissionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPCancelAdmission.IPCancelAdmissionLocalHome"
*	remote-class="eIP.IPCancelAdmission.IPCancelAdmissionHome"
*	generate= "local,remote"
*
*
*/
public class IPCancelAdmissionManager implements SessionBean 
{
	
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove(){}
	public void ejbActivate(){}
	public void ejbPassivate(){}
	public void setSessionContext(SessionContext context){this.ctx = context;}

	/*
	This method is used to cancel the admission.
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap updateCancelAdmission(java.util.Properties p,java.util.HashMap hashData) 
	{
		
		String patient_class	= "";
		String pat_check_yn		= "";
		String remarks			= "";
		String bedno			= "";
		String blocked_bed_no	= "";
		String nursingunitcode	= "";
		String roomno			= "";
		String gender			= "";
		String referral_id		= "";
		String Booking_ref_no	= "";
		String appt_id			= "";
		boolean allow_cancel	= true;     
		boolean allow_cancel_admin = true;    
		String bl_install		= "";
		String episode_id		= "";
		String patient_id		= "";
		Statement st_fin		= null;
		ResultSet rs_fin		= null;
		String policy_type_code	= "";
		String episode_type		= "";
		String cust_code		= "";
		String err_out			= "";
		String err_msg			= "";
		String err_out1			= "";
		int res1				= 0;
		int res2				= 0;
		int res3				= 0;
		int res4				= 0;
		int res5				= 0;
		int res6				= 0;
		int res7				= 0;

		Connection con 		 	 = null;
		ResultSet rs2 			 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt7 = null;
		boolean result			 = true;
		java.util.Hashtable message = new java.util.Hashtable();
		java.util.HashMap results	= new java.util.HashMap();
		StringBuffer sb				= new StringBuffer("");
		try
		{
			int l_male_count	= 0;
			int l_female_count	= 0;
			int l_unknow_count	= 0;
			String locale		= p.getProperty("LOCALE");
			String facilityId	= (String)hashData.get("facilityId");
			String encounterid	= (String)hashData.get("encounterId");
			String addedAtWorkstation	= (String)hashData.get("client_ip_address");
			remarks				= (String)hashData.get("remarks");
			bedno				= (String)hashData.get("bedno");
			nursingunitcode		= (String)hashData.get("nursingunitcode");
			roomno				= (String)hashData.get("roomno");
			gender				= (String)hashData.get("gender");
			bl_install			= (String)hashData.get("bl_install");
			episode_id			= (String)hashData.get("episode_id");
			patient_id			= (String)hashData.get("patient_id");
			blocked_bed_no		= (String)hashData.get("blocked_bed_no");
			patient_class		= (String)hashData.get("patient_class");
			pat_check_yn		= (String)hashData.get("pat_check_yn");

			con					= ConnectionManager.getConnection(p);
			boolean isForAdmission=CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//ADDED FOR ML-MMOH-CRF-1972 ISSUE
			
			con.setAutoCommit(false);
			String modifiedById 			= p.getProperty( "login_user" ) ;
			String modifiedAtWorkstation	= addedAtWorkstation ;
			StringBuffer sql1				= new StringBuffer("");

			if(gender.equals("M")) 			l_male_count    = 1;
			else if(gender.equals("F")) 	l_female_count  = 1;
			else if(gender.equals("U"))  	l_unknow_count  = 1;
			if(patient_class.equals("DC"))	episode_type    = "D";
			else							episode_type	= "I";

			if(sql1.length() > 0) sql1.delete(0,sql1.length());
			sql1.append(" select count(1) from pr_encounter WHERE facility_id = '"+facilityId+"' AND encounter_id = "+encounterid+" AND ADT_STATUS ='09'"); 
			pstmt1  = con.prepareStatement( sql1.toString());
			rs2		= pstmt1.executeQuery() ;
			int cnt = 0;
			if (rs2!=null&&rs2.next())
				cnt = rs2.getInt(1);
			if (cnt==0)
				allow_cancel = true;
			else
				allow_cancel = false;
			String cancel_allowed_yn	= pat_check_yn;
			if(rs2!=null)	  rs2.close();


			if(cancel_allowed_yn.equals("Y"))
			{
				allow_cancel_admin = true;
			}
			else 
			{
				allow_cancel_admin = false;
			}

			if(sql1.length() > 0) sql1.delete(0,sql1.length());
			sql1.append("select REFERRAL_ID, BOOKING_REF_NO,APPT_ID from pr_encounter where facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid+"'");
			if(pstmt1!=null) pstmt1.close();

			pstmt1		= con.prepareStatement(sql1.toString());
			rs2			= pstmt1.executeQuery();
			if (rs2!=null && rs2.next())
			{
				referral_id = rs2.getString("REFERRAL_ID")== null ? "" : rs2.getString("REFERRAL_ID");
				Booking_ref_no = rs2.getString("BOOKING_REF_NO")== null ? "" : rs2.getString("BOOKING_REF_NO") ; 
				appt_id = rs2.getString("APPT_ID")== null ? "" : rs2.getString("APPT_ID") ; 
			}
			if(rs2!=null)	  rs2.close();

			if (allow_cancel)
			{
				if(result && allow_cancel_admin )
				{
					/*Friday, February 04, 2011 ,SRR20056-SCF-6784 [IN:026334],*/
					if(!Booking_ref_no.equals(""))
					{
						try
						{
							if(sql1.length() > 0) sql1.delete(0,sql1.length());
							/*Added Audit column in the query*/
							sql1.append("UPDATE ip_bed_booking set booking_status = '1',modified_by_id = '"+modifiedById+"',modified_date = sysdate,modified_facility_id = '"+facilityId+"',modified_at_ws_no= '"+modifiedAtWorkstation+"' WHERE facility_id  = '"+facilityId+"'  AND   bed_booking_ref_no = '"+Booking_ref_no+"' AND booking_type='L' ");
							pstmt1   = con.prepareStatement( sql1.toString());
							res1 = pstmt1.executeUpdate();
							if(res1 > 0) 
							{
								result = true; 
							}
							if(pstmt1!=null) pstmt1.close();
						}
						catch (Exception ex)
						{
							ex.printStackTrace();
							result = false;
						}
					}/**/
					if (!blocked_bed_no.equals(""))
					{
						try
						{
							if(sql1.length() > 0) sql1.delete(0,sql1.length());
							sql1.append("select count(1) bedbkgCnt from ip_bed_booking where facility_id  = '"+facilityId+"'  AND   encounter_id = "+encounterid+" AND req_nursing_unit_code = '"+nursingunitcode+"' AND req_bed_no = '"+blocked_bed_no+"' and booking_status != '1' ");
								
							pstmt1		= con.prepareStatement(sql1.toString());
							rs2			= pstmt1.executeQuery();
							int bedbkgCnt = 0;
							if(rs2!= null && rs2.next())
							{
								bedbkgCnt = rs2.getInt("bedbkgCnt"); 
							}
							if(pstmt1!=null) pstmt1.close();
							if(rs2!=null)	  rs2.close();
								
							if(bedbkgCnt > 0)
							{
								if(sql1.length() > 0) sql1.delete(0,sql1.length());
								/*Added Audit column in the query*/
								sql1.append("UPDATE ip_bed_booking set booking_status = '4',modified_by_id = '"+modifiedById+"',modified_date = sysdate,modified_facility_id = '"+facilityId+"',modified_at_ws_no= '"+modifiedAtWorkstation+"' WHERE facility_id  = '"+facilityId+"'  AND   encounter_id = "+encounterid+" AND req_nursing_unit_code = '"+nursingunitcode+"' AND req_bed_no = '"+blocked_bed_no+"' and booking_status != '1' ");
								pstmt1   = con.prepareStatement( sql1.toString());
								res1 = pstmt1.executeUpdate();
								if(res1 > 0) 
								{
									result = true; 
								}
								if(pstmt1!=null) pstmt1.close();
							}
						}
						catch(Exception e1)
						{
							sb.append("Exception in  updating ip_bed_booking_table");
							e1.printStackTrace();
							result = false;
						}
					}
				}

			
				if(result)
				{
					try
					{
						if(sql1.length() > 0) sql1.delete(0,sql1.length());
						sql1.append(" UPDATE pr_encounter SET ADT_STATUS ='09',ADT_STATUS_SET_ON_DATE = SYSDATE ,ADT_STATUS_SET_BY_USER = '"+modifiedById+"', CANCEL_REASON_CODE     = '"+remarks+"' ,modified_by_id = '"+modifiedById+"',modified_date = sysdate,modified_facility_id = '"+facilityId+"',modified_at_ws_no= '"+modifiedAtWorkstation+"',pre_dis_initiated_date_time='',pre_dis_initiated_user='' WHERE facility_id = '"+facilityId+"' AND encounter_id = "+encounterid+"");
						//Above line modified for this CRF GHL-CRF-0468
						
						if(pstmt1!=null) pstmt1.close();
						pstmt1   = con.prepareStatement( sql1.toString());
						res1 = pstmt1.executeUpdate() ;
						if(res1 > 0 ) 
							result = true; 
						else
						{
							result = false;
							sb.append("Exception in updating pr_encounter_table");
						}
					}
					catch(Exception e1)
					{
						result = false;
						e1.printStackTrace();
						sb.append("Exception in updating pr_encounter_table");
					}
				}
				/*Monday, April 26, 2010 , patient status update through new procedure*/
				if(result)
				{
					try
					{
						CallableStatement cstmt;
						cstmt=con.prepareCall("{call MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER(?,?,?,?,?,?,?)}");
							cstmt.setString(1,  checkForNull(facilityId));
							cstmt.setString(2, checkForNull(encounterid) ) ;
							cstmt.setString(3,  checkForNull(patient_class));
							cstmt.setString(4,  checkForNull(patient_id));
							cstmt.setString(5,  "09");
							cstmt.setString(6, checkForNull(modifiedById ));
							cstmt.setString(7, checkForNull(modifiedAtWorkstation ));
							cstmt.execute();
							if (cstmt != null)		cstmt.close();
					}
					catch (Exception cs)
					{
						result = false;
						sb.append("MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER:"+cs.toString());
						cs.printStackTrace(System.err);
					}
				}
				
				/**/
				if(result)
				{
					try
					{
						if(sql1.length() > 0) sql1.delete(0,sql1.length());
						sql1.append(" UPDATE ip_adt_trn SET ADT_TRN_STATUS ='8',CANCEL_REASON_CODE = '"+remarks+"' ,modified_by_id ='"+modifiedById+"',modified_date =sysdate, modified_facility_id= '"+facilityId+"',modified_at_ws_no = '"+modifiedAtWorkstation+"' WHERE facility_id = '"+facilityId+"' AND   encounter_id = "+encounterid+" and trn_type = 'A'");
						if(pstmt1!=null) pstmt1.close();
						pstmt1   = con.prepareStatement( sql1.toString());
						res1 = pstmt1.executeUpdate() ;
						if(res1 > 0 ) 
							result = true; 
						else 
						{
							result = false;
							sb.append("Exception in updating IP_ADT_TRN_table");
						}
					}
					catch(Exception e1)
					{
						result = false;
						sb.append("Exception in updating IP_ADT_TRN_table");
						e1.printStackTrace();
					}
				}
				if(result)
				{
					if((!Booking_ref_no.equals("")) || (!appt_id.equals("")))
					try
					{
						if(sql1.length() > 0) sql1.delete(0,sql1.length());
						if(patient_class.equals("DC"))
						{
							sql1.append("update oa_appt set appt_status = '1', ENCOUNTER_ID = '', modified_by_id = '"+modifiedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_at_ws_no = '"+modifiedAtWorkstation+"' WHERE facility_id = '"+facilityId+"' and appt_ref_no = '"+appt_id+"' ");
						}
						else
						{
							sql1.append("update ip_booking_list set booking_status = '1' , modified_by_id = '"+modifiedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_at_ws_no 	 = '"+modifiedAtWorkstation+"' WHERE facility_id = '"+facilityId+"' and bkg_lst_ref_no = '"+Booking_ref_no+"' ");
						}
						if(pstmt5!=null) pstmt5.close();		 
						pstmt5 = con.prepareStatement( sql1.toString() );
						res5   = pstmt5.executeUpdate();

						if(res5 > 0 ) 
							result = true; 
						else 
						{
							result = false;
							sb.append("Exception in updating ip_booking_list");
						}
					}
					catch(Exception ebkgl)
					{
						ebkgl.printStackTrace();
						result = false;
						sb.append("Exception in updating ip_booking_list"+ebkgl.toString());
					}
				}
				if(result)
				{
					if(Booking_ref_no.equals("") && (!referral_id.equals("")))
					try
					{
						if(sql1.length() > 0) sql1.delete(0,sql1.length());
						sql1.append("update pr_referral_register set status = 'O' , referred_in_func=null , modified_by_id = '"+modifiedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_at_ws_no = '"+modifiedAtWorkstation+"' WHERE referral_id = '"+referral_id+"' ");
						if(pstmt5!=null) pstmt5.close();		 
						pstmt5 = con.prepareStatement( sql1.toString());
						res5   = pstmt5.executeUpdate();
						if(res5 > 0 ) 
							result = true; 
						else
						{
							result = false;
							sb.append("Exception in updating pr_referral_register");
						}
					}
					catch(Exception ebkgl)
					{
						result = false;
						sb.append("Exception in updating pr_referral_register");
						ebkgl.printStackTrace();
					}
				}

				if (!bedno.equals(""))
				{	
					if(result)
					{
						try
						{
							if(sql1.length() > 0) sql1.delete(0,sql1.length());
	
							sql1.append(" UPDATE ip_nursing_unit SET  num_of_beds_occupied= num_of_beds_occupied-1, modified_by_id= '"+modifiedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_at_ws_no = '"+modifiedAtWorkstation+"' WHERE facility_id = '"+facilityId+"' AND nursing_unit_code = '"+nursingunitcode+"' ");
							pstmt2   = con.prepareStatement( sql1.toString() );
							res2 = pstmt2.executeUpdate() ;
							if(res2 > 0 ) 
								result = true; 
							else
							{
								result = false;
								sb.append("Exception in updating ip_nursing_unit");
							}
						}
						catch(Exception e1)
						{
							result = false;
							sb.append("Exception in updating ip_nursing_unit");
							e1.printStackTrace();
						}
					}
					if(result)
					{
						try
						{
							if(sql1.length() > 0) sql1.delete(0,sql1.length());
							sql1.append("UPDATE ip_nursing_unit_room SET occ_male_bed_count = (occ_male_bed_count-'"+l_male_count+"'),occ_female_bed_count   = (occ_female_bed_count-'"+l_female_count+"'), occ_unknown_bed_count = (occ_unknown_bed_count-'"+l_unknow_count+"'), modified_by_id = '"+modifiedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"',modified_at_ws_no = '"+modifiedAtWorkstation+"' WHERE facility_id = '"+facilityId+"' AND nursing_unit_code = '"+nursingunitcode+"' AND room_no= '"+roomno+"' ");
							pstmt4 	 = con.prepareStatement( sql1.toString());
							res3 = pstmt4.executeUpdate() ;
							 if(res3 > 0 ) 
								 result = true; 
							 else
							{
								sb.append("Exception in updating ip_nursing_unit_room_table");
								 result = false;
							}
							if(pstmt4 != null) pstmt4.close();
						}
						catch(Exception e1)
						{
							result = false;
							sb.append("Exception in updating ip_nursing_unit_room_table");
							e1.printStackTrace();
						}
					}
				
					if(result)
					{
					   try
						{
							if(sql1.length() > 0) sql1.delete(0,sql1.length());
							sql1.append(" UPDATE ip_nursing_unit_bed SET occupying_patient_id= Null, current_status='A', modified_by_id = '"+modifiedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_at_ws_no = '"+modifiedAtWorkstation+"' WHERE  facility_id = '"+facilityId+"' AND nursing_unit_code = '"+nursingunitcode+"' AND bed_no= '"+bedno+"' ");
							if(pstmt4 != null) pstmt4.close();
							pstmt4 = con.prepareStatement( sql1.toString());
							res4 = pstmt4.executeUpdate() ;
							 if(res4 > 0 ) 
								 result = true; 
							 else
							{
								 result = false;
								 sb.append("Exception in updating ip_nursing_unit_bed_table");
							}
						}
						catch(Exception e1)
						{
							result = false;
							sb.append("Exception in updating ip_nursing_unit_bed_table");
							e1.printStackTrace();
						}
					}
				}//E.O.chk for bedno
				/* Kamatchi S ML-MMOH-CRF-1972 IP history patient list issue */
				if(result && isForAdmission)
					{
						try
						{
							if(sql1.length() > 0) sql1.delete(0,sql1.length());
							sql1.append(" select encounter_id,pendng_admission_date_time from  ae_current_patient where  patient_id='"+patient_id+"' and FACILITY_ID = '"+facilityId+"' and ROWNUM = 1 order by queue_date desc");
							pstmt2   = con.prepareStatement( sql1.toString() );
							rs2 = pstmt2.executeQuery() ;
							long ae_encounter_id=0;
							String pendng_admission_date_time="";
							if(rs2!=null){
							if(rs2.next())
								{
									ae_encounter_id=rs2.getLong("encounter_id");
									pendng_admission_date_time=checkForNull(rs2.getString("pendng_admission_date_time"));
									System.err.println("ae_encounter_id================="+ae_encounter_id);
									System.err.println("pendng_admission_date_time================="+pendng_admission_date_time);
								}
							}
								if(pstmt2!=null) pstmt2.close();
								if(rs2!=null) rs2.close();
								if(!pendng_admission_date_time.equals(""))
								{
								if(sql1.length() > 0) sql1.delete(0,sql1.length());
	
							sql1.append(" UPDATE ae_current_patient SET  pendng_admission_date_time= NULL, modified_by_id= '"+modifiedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_at_ws_no = '"+modifiedAtWorkstation+"' WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+ae_encounter_id+"' ");
							pstmt2   = con.prepareStatement( sql1.toString() );
							res2 = pstmt2.executeUpdate() ;
							if(res2 > 0 ) 
								result = true; 
							else
							{
								result = false;
								sb.append("Exception in updating ae_current_patient");
							}
							if(pstmt2!=null) pstmt2.close();
									
								}
							
						}
						catch(Exception e1)
						{
							result = false;
							sb.append("Exception in updating ae_current_patient");
							e1.printStackTrace();
						}
					}
				if(result && bl_install.equals("Y"))
				{
					int ep_id=Integer.parseInt(episode_id);
					if(sql1.length() > 0) sql1.delete(0,sql1.length());	
					sql1.append("select policy_type_code, cust_code from BL_EPISODE_FIN_DTLS where operating_facility_id = '"+facilityId+"' and patient_id='"+patient_id+"' and episode_id='"+episode_id+"' and episode_type='"+episode_type+"'");

					try
					{
						st_fin=con.createStatement();
						rs_fin=st_fin.executeQuery(sql1.toString());
						if(rs_fin.next())
						{
							policy_type_code=rs_fin.getString("policy_type_code");
							cust_code=rs_fin.getString("cust_code");
						}
						if(policy_type_code==null || policy_type_code.equalsIgnoreCase("null"))policy_type_code="";
						if(cust_code==null || cust_code.equals("null"))cust_code="";

						if(st_fin!=null) st_fin.close();
						if(rs_fin!=null) rs_fin.close();
					}
					catch(Exception e)
					{
						sb.append("Exception @poly_cust_cd"+e);
						e.printStackTrace();
					}
					
					if(result)
					{
						try
						{
							if(sql1.length() > 0) sql1.delete(0,sql1.length());	
							sql1.append("update bl_episode_fin_dtls  set episode_status= '9', ill_ded_amt=0, modified_by_id	= '"+modifiedById+"', modified_date	= sysdate, modified_facility_id = '"+facilityId+"', modified_at_ws_no = '"+modifiedAtWorkstation+"' where operating_facility_id = '"+facilityId+"' and patient_id = '"+patient_id+"' and episode_id ='"+episode_id+"' and episode_type=	'"+episode_type+"' ");
							if(pstmt4 != null) pstmt4.close();
							pstmt4 = con.prepareStatement( sql1.toString() );
							res6 = pstmt4.executeUpdate() ;
							if(res6 > 0 ) 
								result = true;
							else
							{
								sb.append("Exception in updating bl_episode_fin_dtls_table");						
								result = false;
							}
							if(pstmt4 != null) pstmt4.close();
						}
						catch(Exception e1)
						{
							result = false;
							sb.append("Exception in updating bl_episode_fin_dtls_table");
							e1.printStackTrace();
						}
					  }

					if(!(policy_type_code.equals("")))
					{
						//Commented Below calls to BL Procedures since the procedures were removed
						/*if(result)
						{
							try
							{
								CallableStatement stmt_preapp;
								stmt_preapp=con.prepareCall("{call INS_UPD_BL_INS_PREAPP(?,?,?,?,?,?,?,?,?)}");
								stmt_preapp.setString( 1, "D");
								stmt_preapp.setString( 2, patient_id);
								stmt_preapp.setString( 3, episode_type);
								stmt_preapp.setInt( 4, ep_id);
								stmt_preapp.setInt( 5, 0);
								stmt_preapp.setString( 6, policy_type_code);
								stmt_preapp.setString( 7, cust_code);
								stmt_preapp.setString(8, modifiedById);
								stmt_preapp.registerOutParameter( 9,java.sql.Types.VARCHAR);
								stmt_preapp.execute() ;
								err_out = stmt_preapp.getString(9);
								if(err_out.equals("0"))
								{
									result  = true;
								}
								else
								{
									err_msg = err_out;
									result  = false;
									String chk_err_msg = err_msg.substring(0,2);
									if(chk_err_msg.equals("**"))
									{
										sb.append("Error while inserting Financial Details");
										sb.append(err_msg);
									}
									else
									{
										message = MessageManager.getMessage( locale, err_msg,"BL") ;
										sb.append("Error message while inserting Financial Details");
										sb.append(err_msg);
									}
								}
								if (stmt_preapp != null)		stmt_preapp.close();
							}
							catch(Exception e2)
							{
								sb.append("Incomplete Operation @ Exception stmt_preapp........"+e2.toString());
								result  = false;
								e2.printStackTrace();
							}
						}
						if(result)
						{
							try
							{
								CallableStatement stmt_poladd;
								stmt_poladd=con.prepareCall("{call INS_UPD_BL_INS_POLICY_ADDL( ?,?,?,?,?,?,?,?,?)}");
								stmt_poladd.setString( 1, "D");
								stmt_poladd.setString( 2, patient_id);
								stmt_poladd.setString( 3, "I");
								stmt_poladd.setInt( 4, ep_id);
								stmt_poladd.setInt( 5, 0);
								stmt_poladd.setString( 6, policy_type_code);
								stmt_poladd.setString( 7, cust_code);
								stmt_poladd.setString(8, modifiedById);
								stmt_poladd.registerOutParameter( 9,java.sql.Types.VARCHAR);
								stmt_poladd.execute() ;
								err_out1 = stmt_poladd.getString(9);

								if(err_out1.equals("0"))
								{
									result  = true;
								}
								else
								{
									err_msg				= err_out1;
									result				= false;
									String chk_err_msg1 = err_msg.substring(0,2);

									if(chk_err_msg1.equals("**"))
									{
										sb.append(err_msg);
									}
									else
									{
										message = MessageManager.getMessage( locale, err_msg,"BL") ;
										sb.append(err_msg);
									}
								}
								if (stmt_poladd != null)		stmt_poladd.close();
							}
							catch(Exception e2)
							{
								result  = false;
								sb.append("Incomplete Operation @ Exception stmt_poladd ........");
								e2.printStackTrace();
							}
						}
						if(result)
						{
							try
							{
								if(sql1.length() > 0) sql1.delete(0,sql1.length());
								sql1.append("UPDATE BL_INS_TRACK_DTLS SET EPISODE_ID = NULL, EPISODE_TYPE = NULL,    ADM_STATUS = 'F', MODIFIED_DATE = SYSDATE, MODIFIED_BY_ID = '"+modifiedById+"', modified_facility_id = '"+facilityId+"', modified_at_ws_no = '"+modifiedAtWorkstation+"' WHERE operating_facility_id = '"+facilityId+"' and PATIENT_ID = '"+patient_id+"'  AND EPISODE_ID = '"+episode_id+"' AND EPISODE_TYPE = 'I' AND ADM_STATUS = 'C'");
								pstmt7 = con.prepareStatement( sql1.toString() );
								res7 = pstmt7.executeUpdate() ;
								if(res7 > 0 ) 
									result = true; 
								else 
								{
									result = false;
									sb.append("Exception in updating BL_INS_TRACK_DTLS");
								}
							}
							catch(Exception e1)
							{
								result = false;
								sb.append("Exception in updating bl_ins_track_dtls");
								e1.printStackTrace();
							}
						}*/
					}//end of IF(!(cust_code))
				}//end of If(bl_install)
				/* delete handelled in trigger IP_PR_ENCNTR_UPD_OPEN_ENC_TRG
				if(result)
				{
					try
					{
						if(sql1.length() > 0) sql1.delete(0,sql1.length());
						sql1.append("DELETE ip_open_encounter WHERE facility_id = '"+facilityId+"' AND   encounter_id = '"+encounterid+"'");
						pstmt5 = con.prepareStatement( sql1.toString() );
						res5   = pstmt5.executeUpdate();
						if(res5 > 0 ) 
							result = true; 
						else
						{
							sb.append("Exception in updating ip_open_encounter");
							result = false;
						}
					}
					catch(Exception e1)
					{
						result = false;
						sb.append("Exception in updating ip_open_encounter");
					}
				}
				*/
				if(bl_install.equals("Y"))
				{
					if(result)
					{
						sb = new StringBuffer("");
						message = MessageManager.getMessage( locale, "RECORD_MODIFIED" ,"SM") ;
						sb.append( (String) message.get("message") ) ;
						con.commit();
					}
					else
					{
						sb.append(err_msg);
						con.rollback();
					}
				}
				else if(bl_install.equals("N"))
				{
					if(result)
					{
						sb		= new StringBuffer("");
						message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
						sb.append( (String) message.get("message") ) ;
						con.commit();
					}
					else
					{
						sb.append(err_msg);
						con.rollback();
					}
				}
			}
			else
			{
				result	= false ;
				sb		= new StringBuffer("");
				message = MessageManager.getMessage( locale, "ADMIN_ALREADY_CANCELLED","IP" ) ;
				sb.append( (String) message.get("message") ) ;
			}
			
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
				sb.append("Error in Cacnel Admission before last finally") ;
				e.printStackTrace();
			}
			catch ( Exception e1 ){		}
		 }
		 finally
		 {
			try
			{
				if(rs2!=null)	  rs2.close();

				 if(pstmt4!=null) pstmt4.close();
					 if(pstmt5!=null) pstmt5.close();
						 if(pstmt7!=null) pstmt7.close();
					 if(pstmt1!=null) pstmt1.close();
				 if(pstmt2!=null) pstmt2.close();
			 }catch(Exception e) {	}
			if(con!=null) ConnectionManager.returnConnection(con,p);
		}
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		result = true;
		hashData.clear();
		message.clear();
		return results;
	}//e.o. Updatecanceladmission method
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}// E.O.Session Bean
