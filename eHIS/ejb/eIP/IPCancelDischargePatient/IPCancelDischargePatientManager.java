/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP.IPCancelDischargePatient;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="IPCancelDischargePatient"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPCancelDischargePatient"
*	local-jndi-name="IPCancelDischargePatient"
*	impl-class-name="eIP.IPCancelDischargePatient.IPCancelDischargePatientManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPCancelDischargePatient.IPCancelDischargePatientLocal"
*	remote-class="eIP.IPCancelDischargePatient.IPCancelDischargePatientRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPCancelDischargePatient.IPCancelDischargePatientLocalHome"
*	remote-class="eIP.IPCancelDischargePatient.IPCancelDischargePatientHome"
*	generate= "local,remote"
*
*
*/

public class IPCancelDischargePatientManager implements SessionBean {

Connection				con		= null;
PreparedStatement		pstmt	= null ;
ResultSet				rset	= null;
Statement				stmt	= null;
CallableStatement		cstmt	= null;
String					locale	= "";
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
SessionContext			ctx;



public void ejbCreate() {}
public void ejbRemove() {}
public void ejbActivate() {}
public void ejbPassivate() {}
public void setSessionContext (SessionContext context){ this.ctx=context; }

/**
	This method is used to block the bed.
	@version - Thai
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/



public java.util.HashMap insertIPCancelDischargePatient(java.util.Properties p,java.util.HashMap tabData) 
	{
				
				java.util.HashMap		results	= new java.util.HashMap() ;
				StringBuffer			sb		= new StringBuffer("");
				boolean					result	= true;
				
				try
				{
					locale									= p.getProperty("LOCALE");
					String addedById						= p.getProperty( "login_user" ) ;
					String facilityId						= (String)tabData.get("facilityId");
					String specialty_code					= (String)tabData.get("specialty_code");  
					String nursing_unit_code				= (String)tabData.get("nursing_unit_code"); 
					//String room_no							= (String)tabData.get("room_no");   
					String patientid						= (String)tabData.get("patientid");         
					//String bed_no							= (String)tabData.get("bed_no");
					String cancel_discharge_bed_no			= (String)tabData.get("cancel_discharge_bed_no");
					String encounter_id						= (String)tabData.get("encounter_id"); 
					String addedAtWorkstation				= (String)tabData.get("addedAtWorkstation");
					String bl_interfaced_yn					= (String)tabData.get("bl_interfaced_yn");	
					String bl_operational					= (String)tabData.get("bl_operational");	
					String L_current_gender					= "*";
					int	rs ;
					String bed_booking_ref_no				= "";
					//New Variables
					String cancel_discharge_room_no			= "";
					String patientgender					= (String)tabData.get("patientgender");	
					String dateofbirth						= (String)tabData.get("dateofbirth");	
					//String disposition_type					= (String)tabData.get("disposition_type");	
					//String referral_id						= (String)tabData.get("referral_id");
					String patient_class					= (String)tabData.get("patient_class");
					String reason_code						= (String)tabData.get("reason_code");
					String cancel_ptact_id					= (String)tabData.get("cancel_ptact_id");
					//String discharge_status_code			= (String)tabData.get("discharge_status_code");
					String episode_type="";
                    String bill_error="";
					String referral_id_list		             = "";//Added for Incident NO:34615 by Srinivas
		            String ref_id				             = "";//Added for Incident NO:34615 by Srinivas
					con = ConnectionManager.getConnection(p);
					con.setAutoCommit(false);
					StringBuffer sbSql = new StringBuffer();
					
						if(result)
						{
							try
							{
								// Check for this nursing unit tranfer allowed or not
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append(" SELECT age_group_code FROM ip_nursing_unit WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+nursing_unit_code+"' ");
								stmt	=	con.createStatement();
								
								rset	=	stmt.executeQuery(sbSql.toString());

								String agegrpcode	=	"";

								if(rset!=null && rset.next())
								{
									agegrpcode   = rset.getString("age_group_code") == null ? "" : rset.getString("age_group_code");
								}
								
								if(rset !=null) rset.close(); 
								if(stmt !=null) stmt.close();	
								
								if(agegrpcode!=null && !agegrpcode.equals(""))
								{
									// Check for the nursing unit have any criteria of age group or sex
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append(" Select '1' from am_age_group Where age_group_code='"+agegrpcode+"'  And NVL(GENDER,'"+patientgender+"')= '"+patientgender+"' AND  trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
									try
									{
										stmt = con.createStatement();
										
										rset  = stmt.executeQuery(sbSql.toString());
										if(!rset.next())
										{
											
											result = false;
											java.util.Hashtable message = MessageManager.getMessage( locale, "AGE_GENDER_NOT_ALLOWED","IP" ) ;
											sb.append( (String) message.get("message") ) ;
										}
										if(rset !=null) rset.close(); if(stmt !=null) stmt.close();
									}
									catch (Exception e)
									{
										result = false;
										sb.append("Exception in getting age_group_code from am_age_group table "+e.toString());
										e.printStackTrace() ;
									}
									
								}
							}
							catch(Exception e)
							{
								result = false;
								sb.append("Exception in getting age_group_code from ip_nursing_unit table "+e.toString());
								e.printStackTrace() ;
							}
						}
					
			
					if(result)
					{
			
						try
						{
							if (!(cancel_discharge_bed_no.equals("") || cancel_discharge_bed_no == null ))
							{
								// Check the bed validity and sex indicators
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append(" Select  room_no,sex_spec_ind, occupying_patient_id, specialty_code from IP_NURSING_UNIT_BED WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+nursing_unit_code+"' And bed_no='"+cancel_discharge_bed_no+"' ");
								
								stmt	=	con.createStatement();
								rset	=	stmt.executeQuery(sbSql.toString());
								if(!rset.next())
								{
									result = false;
									java.util.Hashtable message = MessageManager.getMessage( locale, "INVALID_BED","Common" ) ;
									sb.append( (String) message.get("message") ) ;
								}
								else
								{
									String occupyingpatientid	= rset.getString("Occupying_Patient_Id") == null ? "" : rset.getString("Occupying_Patient_Id") ;
									String sex_spec_ind			= rset.getString("sex_spec_ind") == null ? "" : rset.getString("sex_spec_ind") ;
									String splty_code			= rset.getString("specialty_code")==null ? "" : rset.getString("specialty_code");
									cancel_discharge_room_no	= rset.getString("room_no")==null ? "" : rset.getString("room_no");
									
									if (!(occupyingpatientid.equals("") || occupyingpatientid.equals(patientid)))
									{
										result = false;
										java.util.Hashtable message = MessageManager.getMessage( locale, "OCCUPIED_BED","IP" ) ;
										sb.append( (String) message.get("message") ) ;
									}
									else if (splty_code!=null && !splty_code.equals("") && !splty_code.equals(specialty_code)) //Added for specialty to bed validation
									{
										result = false;
										java.util.Hashtable message = MessageManager.getMessage( locale, "BED_SPLTY_INVALID","IP" ) ;
										sb.append( (String) message.get("message") ) ;
									}
									else if (sex_spec_ind!=null && !sex_spec_ind.equals("") && !sex_spec_ind.equals(patientgender)) //Added for gender to bed validation
									{
										result = false;
										java.util.Hashtable message = MessageManager.getMessage( locale,"AGE_GENDER_NOT_ALLOWED","IP" ) ;
										sb.append( (String) message.get("message") ) ;
									}
								}
								if(rset !=null) rset.close(); if(stmt !=null) stmt.close();
							}
						}
						catch(Exception e)
						{
							result = false;
							sb.append("Exception in checking valid bed "+e.toString());
							e.printStackTrace() ;
						}
					}

					if(result)
					{
						try
						{
							// Check the target room status and find out bed counter of gender in room
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append(" select a.occ_male_bed_count, a.occ_female_bed_count, a.occ_unknown_bed_count from ip_nursing_unit_room a, ip_nursing_unit b where a.facility_id='"+facilityId+"' and   a. nursing_unit_code='"+nursing_unit_code+"' and  a.room_no='"+cancel_discharge_room_no+"' and  b.facility_id=a.facility_id and  b.nursing_unit_code=a.nursing_unit_code and b.check_same_sex_in_room_yn='Y' ");
							stmt = con.createStatement();
							rset = stmt.executeQuery(sbSql.toString());
							if(rset!=null && rset.next())
							{
								int malebedcount    = rset.getInt(1);
								int femalebedcount  = rset.getInt(2);
								int unknownbedcount = rset.getInt(3);
								if(malebedcount > 0) 	L_current_gender      = "M";
								else if(femalebedcount > 0) L_current_gender  = "F";
								else if(unknownbedcount > 0) L_current_gender = "U";
								if (!L_current_gender.equals("*") && !L_current_gender.equals(patientgender))
								{
									result = false;
									java.util.Hashtable message = MessageManager.getMessage( locale, "IN_ROOM_ONLY_SAME_GENDER","IP" ) ;
									sb.append( (String) message.get("message") ) ;
								}
							}
							if(rset !=null) rset.close(); if(stmt !=null) stmt.close();
						}
						catch(Exception e)
						{
							result = false;
							sb.append("Exception in checking for same gender in a room "+e.toString());
							e.printStackTrace() ;
						}
					}
					

					if(result)
					{
						try
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							// Updating pr_encounter table with new bed_num and room_num and also changing adt_status

							sbSql.append("update	pr_encounter set	adt_status		= '01',	cancel_disch_practitioner_id=?,cancel_reason_code =?,assign_bed_num = ?  ,  assign_room_num = ?,disposition_type	= null ,discharge_status_code = null ,disch_practitioner_id='',	adt_status_set_on_date	= null ,	adt_status_set_by_user	= null ,	adt_status_set_reason	= null ,	discharge_date_time	= null ,	deceased_date_time	= null ,cancel_disch_date = sysdate, disp_referral_id	= null ,	modified_by_id		= ? ,	modified_date		= sysdate ,	modified_at_ws_no	= ? ,	modified_facility_id	= ? where	facility_id = ?  and	encounter_id = ?");

						 

							pstmt = con.prepareStatement( sbSql.toString() );
							pstmt.setString	( 1, cancel_ptact_id ) ;
							pstmt.setString	( 2, reason_code ) ;
							pstmt.setString	( 3, cancel_discharge_bed_no ) ;
							pstmt.setString	( 4, cancel_discharge_room_no ) ;
							pstmt.setString	( 5, addedById ) ;
							pstmt.setString	( 6, addedAtWorkstation ) ;
							pstmt.setString	( 7, facilityId ) ;
							pstmt.setString	( 8, facilityId ) ;
							pstmt.setString	( 9, encounter_id ) ;

							rs  = pstmt.executeUpdate() ;
							if(rs>0)
								result = true;
							else
							{
								result = false;
								sb.append("Error in updating pr_encounter");
							}
						}
						catch(Exception e1)
						{
							result = false;
							sb.append("Exception in updating pr_encounter "+e1.toString());
							e1.printStackTrace() ;	
						}

						if(pstmt!=null)
							pstmt.close();
					}

					/*Monday, April 26, 2010 , patient status update through new procedure*/
					if (result)
					{
						try
						{
							//un used local varibales String cs	= "0";

							cstmt		= con.prepareCall("{call MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER(?,?,?,?,?,?,?)}");
						
							cstmt.setString(1,  checkForNull(facilityId));
							cstmt.setString(2, checkForNull(encounter_id) ) ;
							cstmt.setString(3,  checkForNull(patient_class));
							cstmt.setString(4,  checkForNull(patientid));
							cstmt.setString(5,  "01");
							cstmt.setString(6, checkForNull(addedById ));
							cstmt.setString(7, checkForNull(addedAtWorkstation ));
							cstmt.execute();
							
						}
						catch (Exception cs)
						{
							result = false;
							sb.append("MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER:"+cs.toString());
							
							cs.printStackTrace(System.err);
						}
						finally
						{
							if(cstmt!=null) cstmt.close();
						}
					}
					/**/
			
					
					if(result)
					{
						//This below logic is only for those patient which are Daycare Booking and have booking ref_no.
						try
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append("select	bed_booking_ref_no from	ip_bed_booking where	facility_id = '"+facilityId+"'  and	encounter_id = "+encounter_id+" and	booking_type = 'D'");

							pstmt = con.prepareStatement( sbSql.toString());
							rset  = pstmt.executeQuery() ;
							if(rset!=null)
							{
								while(rset.next())
								{
									bed_booking_ref_no = rset.getString("bed_booking_ref_no");
									if(bed_booking_ref_no == null) bed_booking_ref_no = "";
								}
							}
						}
						catch(Exception e1)
						{
							result = false;
							sb.append("Exception in selecting data from  ip_bed_booking "+e1.toString());
							e1.printStackTrace() ;	
						}

						if(rset!=null)
							rset.close();
						if(pstmt!=null)
							pstmt.close();

						try
						{
							if(bed_booking_ref_no!=null && !bed_booking_ref_no.equals(""))
								{
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append("delete from ip_bed_booking where	facility_id = ? and	booking_type = 'D' and	bed_booking_ref_no = ?");

									pstmt	= con.prepareStatement( sbSql.toString() );
									pstmt.setString	( 1, facilityId ) ;
									pstmt.setString	( 2, bed_booking_ref_no ) ;
									rs  = pstmt.executeUpdate() ;

									if(rs>0)
										result = true;
									else
									{
										result = false;
										sb.append("Error in updating ip_bed_booking ");
									}
								}
						}
						catch(Exception e1)
						{
							result = false;
							sb.append("Exception in updating  ip_bed_booking "+e1.toString());
							e1.printStackTrace() ;		
						}

						if(pstmt!=null)
							pstmt.close();

					}


					try
					{
						//This below logic only for FM module
						if(result)
						{
							String install_yn ="";
							String file_no = "";
							String last_added_date = "";
							String src_facility_id = "";
							String src_fs_locn_code = "";
							String src_locn_identity = "";
							String src_user_id = "";
							String src_mr_locn_yn = "";
							
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append("select install_yn from sm_module where module_id = 'FM'");
							pstmt = con.prepareStatement( sbSql.toString());
							rset  = pstmt.executeQuery() ;
							if(rset!=null)
							{
								while(rset.next())
								{
									install_yn = rset.getString("install_yn");
								}
							}
							
							if(install_yn == null) install_yn = "";

							if(rset!=null)
								rset.close();
							if(pstmt!=null)
								pstmt.close();

							if(install_yn!=null && install_yn.equals("Y"))
							{
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append("Select file_no from mr_pat_file_index  where facility_id = '"+facilityId+"'  and patient_id = '"+patientid+"'");
								pstmt = con.prepareStatement( sbSql.toString());
								rset  = pstmt.executeQuery() ;
								if(rset!=null)
								{
									while(rset.next())
									{
										file_no = rset.getString("file_no");
									}
								}

								if(file_no == null )
									file_no = "";

								if(rset!=null)
									rset.close();
								if(pstmt!=null)
									pstmt.close();

								if(file_no!=null && !file_no.equals(""))
								{
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append("Select to_char(added_date,'dd/mm/yyyy hh24:MI') last_added_date_time  from ip_adt_trn where facility_id = '"+facilityId+"' and Encounter_id = "+encounter_id+" and adt_trn_status != '9' and trn_type = 'D'");
									pstmt = con.prepareStatement( sbSql.toString());
									rset  = pstmt.executeQuery() ;
									if(rset!=null)
									{
										while(rset.next())
										{
											last_added_date = rset.getString("last_added_date_time");
										}
									}

									if(rset!=null)
										rset.close();
									if(pstmt!=null)
										pstmt.close();			
			
									boolean cont_yn = false;
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append("Select src_facility_id, src_fs_locn_code, src_locn_identity, src_user_id, src_mr_locn_yn from fm_movement_log  where facility_id = '"+facilityId+"' and file_no = '"+file_no+"' and movement_type = 'F' and sent_date_time = to_date('"+last_added_date+"','dd/mm/yyyy hh24:MI')");

									pstmt = con.prepareStatement( sbSql.toString() );
									rset  = pstmt.executeQuery() ;
									if(rset!=null)
									{
										while(rset.next())
										{
											src_facility_id = rset.getString("src_facility_id");
											src_fs_locn_code = rset.getString("src_fs_locn_code");
											src_locn_identity = rset.getString("src_locn_identity");
											src_user_id = rset.getString("src_user_id");
											src_mr_locn_yn = rset.getString("src_mr_locn_yn");
											cont_yn = true;
										}
									}

									if(rset!=null)
										rset.close();
									if(pstmt!=null)
										pstmt.close();		
			
									if(cont_yn)
									{
										if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
										sbSql.append("Update fm_curr_locn  set curr_facility_id = ? , curr_file_status='O', curr_fs_locn_code= ?, curr_fs_locn_identity= ?, curr_holder_user_id= ?, last_movement_date_time=sysdate, modified_by_id= ?,  modified_date=sysdate,  modified_at_ws_no= ?,  modified_facility_id = ?  where facility_id = ?  and file_no = ?");
										pstmt = con.prepareStatement( sbSql.toString() );
										pstmt.setString	( 1, src_facility_id ) ;
										pstmt.setString	( 2, src_fs_locn_code ) ;
										pstmt.setString	( 3, src_locn_identity ) ;
										pstmt.setString	( 4, src_user_id ) ;
										pstmt.setString	( 5, addedById ) ;
										pstmt.setString	( 6, addedAtWorkstation ) ;
										pstmt.setString	( 7, facilityId ) ;
										pstmt.setString	( 8, facilityId ) ;
										pstmt.setString	( 9, file_no ) ;
										
										rs  = pstmt.executeUpdate() ;

										if(rs>0)
											result = true;
										else
										{
											result = false;
											sb.append("Error in updating fm_curr_locn");
										}
										
										if(pstmt!=null)
											pstmt.close();	
										if(result)
										{
											if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());

											sbSql.append("Delete from fm_movement_log  where facility_id = ? and file_no = ? and movement_type = 'F' and sent_date_time = to_date(?,'dd/mm/yyyy hh24:MI')");

											pstmt = con.prepareStatement( sbSql.toString() );
											pstmt.setString	( 1, facilityId ) ;
											pstmt.setString	( 2, file_no ) ;
											pstmt.setString	( 3, last_added_date ) ;
					
											rs  = pstmt.executeUpdate() ;
											if(rs>0)
												result = true;
											else
											{
												result = false;
												sb.append("Error in updating fm_movement_log   ");
											}

											if(pstmt!=null)
												pstmt.close();	
										}
									}
								}
							}
						}
					}
					catch(Exception e1)
					{
						result = false;
						sb.append("Exception in updating FM details "+e1.toString());	
						e1.printStackTrace() ;	
					}

						
					//if billing interface is yes and billing module is install then calling billing interface
					if (result && bl_interfaced_yn.equalsIgnoreCase("Y") && bl_operational.equalsIgnoreCase("Y"))
					{							
						try
						{
							Hashtable hashtableBL = new Hashtable();
							if(patient_class.equals("IP"))
	 							episode_type = "I";
							else if(patient_class.equals("DC"))
								episode_type = "D";
							String function_id="CANCEL_DISCHARGE";
							hashtableBL.put("facility_id",facilityId);
							hashtableBL.put("patient_id",patientid);
							hashtableBL.put("encounter_id",encounter_id);							
						//	hashtableBL.put("episode_id",(encounter_id+"").substring(0,8));
							hashtableBL.put("episode_id",encounter_id);
							hashtableBL.put("billing_interfaced",bl_interfaced_yn);
							hashtableBL.put("billing_installed",bl_operational);
							hashtableBL.put("locale",locale); 
							hashtableBL.put("episode_type",episode_type);
							hashtableBL.put("function_id",function_id);
							
							
									
							blipin.BLCancelDischargePatient blCancelDischargePatient = new blipin.BLCancelDischargePatient();
							Hashtable returnBL = blCancelDischargePatient.cancelDischarge(p,con,hashtableBL);
						
							result = ((Boolean) returnBL.get("status")).booleanValue()	;							
							blCancelDischargePatient = null;
							if(result == false)	{	
								bill_error = (String) (returnBL.get("error"));
								sb.append(bill_error);	
							}
							
							returnBL.clear();
							hashtableBL.clear();
						}
						catch(Exception ex)
						{
							result = false;
							sb.append("BL Error "+ex.toString());
							ex.printStackTrace() ;	
						}														
					}					
					
					//Added for Incident NO:34615 by Srinivas
					if(result){
					try
			           {
				if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
				sbSql.append(" SELECT  REFERRAL_ID refid");
				sbSql.append(" FROM pr_referral_register a ");
				sbSql.append(" WHERE added_facility_id = '"+facilityId+"' ");
				sbSql.append(" AND from_encounter_id ='"+encounter_id+"'");
				sbSql.append(" AND bedside_referral_yn != 'Y' and status = 'O' "); 
		         if(stmt!=null)stmt.close();
			    stmt = con.createStatement();
			   	rset = stmt.executeQuery(sbSql.toString());
				boolean first_time = true;
	
				while(rset.next())
				{
					ref_id = rset.getString("refid");

					if(first_time)
					  referral_id_list = "('"+ref_id+"'" ;
					else
						referral_id_list = referral_id_list + ",'" +ref_id +"'";

					first_time = false;
				}

				if(!first_time)
					referral_id_list = referral_id_list + ")";

				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
				if(referral_id_list != "")
				{
					if(result)
					{
					
						
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append(" update pr_referral_register set status = 'D',");
						sbSql.append(" modified_by_id=?,modified_date=sysdate,modified_facility_id=?, ");
						sbSql.append(" modified_at_ws_no=?");
						sbSql.append(" where referral_id in ");
						sbSql.append(referral_id_list);
						
                        rs = 0;
						pstmt = con.prepareStatement( sbSql.toString() );
				        pstmt.setString(1, addedById);
						pstmt.setString(2, facilityId);
						pstmt.setString(3, addedAtWorkstation);

						rs = pstmt.executeUpdate();
						if(pstmt != null)	pstmt.close();
		         	         }
					         }
					          }
			           catch (Exception exp)
			              {
				             result = false;
				             sb.append("Error in updating PR_REFERRAL_REGISTER Table  "+exp.toString());
				             exp.printStackTrace();
			              }
					}
					//end for Incident NO:34615 by Srinivas
									
					if (result)
					{
						result = true ;
						java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM");
						sb.append( (String) message.get("message"));
						con.commit();
					}
					else
					{
						result = false ;
						//java.util.Hashtable message = MessageManager.getMessage( locale, "ERROR_WHILE_UPDATING" ,"IP") ;
						//sb.append( (String) message.get("message") ) ;
						con.rollback();
					}
				
				}
				catch ( Exception e ) {

					try{
						if(con != null)
							con.rollback();
						}
						catch(Exception e1){sb.append( "Error in Rollback"+e1.toString());}
						result = false;
						sb.append("Exception in Main "+ e.toString()  ) ;
						e.printStackTrace() ;					
					}
				finally {
					 try{
					
					  if(rset != null)			rset.close();
					  if(stmt != null)		stmt.close();
					  if(pstmt != null)		pstmt.close() ;					  

					 }catch(Exception ce){}

					if(con != null)      ConnectionManager.returnConnection(con,p);
				}
				
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			
			return results ;
	}//end insert
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}// end session bean

