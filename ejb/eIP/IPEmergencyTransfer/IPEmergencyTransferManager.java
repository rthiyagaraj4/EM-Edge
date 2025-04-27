/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP.IPEmergencyTransfer; 
import blipin.*;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.Common.*;
/**
*
* @ejb.bean
*	name="IPEmergencyTransfer"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPEmergencyTransfer"
*	local-jndi-name="IPEmergencyTransfer"
*	impl-class-name="eIP.IPEmergencyTransfer.IPEmergencyTransferManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPEmergencyTransfer.IPEmergencyTransferLocal"
*	remote-class="eIP.IPEmergencyTransfer.IPEmergencyTransferRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPEmergencyTransfer.IPEmergencyTransferLocalHome"
*	remote-class="eIP.IPEmergencyTransfer.IPEmergencyTransferHome"
*	generate= "local,remote"
*
*
*/
public class IPEmergencyTransferManager implements SessionBean 
{
	SessionContext ctx;
	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}
	
	/** This method is used for validating the target values Like nusring unit rights....speciality and practioner checks**/

	public java.util.HashMap ValidateIPEmergencyTransfer(java.util.Properties p,java.util.HashMap tabData)
	{
		Connection con 				= null;
		PreparedStatement pstmt		= null;
		ResultSet rset 				= null;
		Statement stmt 				= null;
		Statement stmt1				= null;
		ResultSet srs 				= null;
		String toroomno				= "";
		String locale				= "";
		String facilityId			= "";
		String topractitionerid		= "";
		String tospecialitycode		= "";
		String tonursingunitcode	= "";
		String patientid			= "";
		String tobedno				= "";
		String fmnursingunitcode	= "";
		String modified_date_val	= "";
		String encounterID			= "";
		String dateofbirth			= "";
		String patientgender		= "";
		facilityId					= (String)tabData.get("facilityId");
		topractitionerid			= (String)tabData.get("topractitionerid");
		tospecialitycode			= (String)tabData.get("tospecialitycode");  
		tonursingunitcode			= (String)tabData.get("tonursingunitcode"); 
			   toroomno				= (String)tabData.get("toroomno");    
		patientid					= (String)tabData.get("patientid");         
		tobedno						= (String)tabData.get("tobedno");
		fmnursingunitcode			= (String)tabData.get("fmnursingunitcode");
		modified_date_val			= (String)tabData.get("modified_date_val");
		encounterID					= (String)tabData.get("encounter_id"); 
		dateofbirth					= (String)tabData.get("dateofbirth"); 
		patientgender				= (String)tabData.get("patientgender"); 
		java.util.HashMap results   = new java.util.HashMap() ;
		boolean result				= true;
		StringBuffer sb				= new StringBuffer("");
		StringBuffer sbSql			= new StringBuffer("");
		StringBuffer sb1			= new StringBuffer("");
		String fm_install_chk  		= "";
		String transfter_file_chk	= "";
		String auto_file_transfer_chk	= "";
		String fm_fs_locn_val   	= "";
		String fm_locn_identity_val = "";
		String auto_rec_ward_chk	= "";
		String bookingtype			= "";
		String overrideyn			= "";
		String nursingunittype		= "";
		String tobedtype			= "";
		String L_current_gender		= "*";
		//String auto_rec_ward_yn		= "";
		//String fm_install_yn		= "";
		String 	check_same_sex_in_room_yn	= "";
		int malebedcount			= 0;
		int femalebedcount			= 0;
		int unknownbedcount			= 0;
		try
		{	
			locale					= p.getProperty("LOCALE");
			con						= ConnectionManager.getConnection(p);
			String modified_date_value = "";
			if(result)
			{
				try
				{
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select TO_CHAR(modified_date, 'dd/mm/rrrr hh24:mi') modified_date ,(select install_yn from sm_module where module_id = 'FM')fm_install_yn from IP_OPEN_ENCOUNTER where facility_id='"+facilityId+"' and encounter_id='"+encounterID +"' ");
					stmt=con.createStatement();
					srs = stmt.executeQuery(sbSql.toString());
					
					if(srs.next())
					{
						modified_date_value = srs.getString("modified_date");
						fm_install_chk		= srs.getString("fm_install_yn");
						if (modified_date_value.equals(modified_date_val))
						{
							result = true;
						}
						else
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"ENC_ALREADY_MODIFIED","IP");
							sb.append((String) message.get("message") ) ;
							message.clear();
						}
					}
					if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
				}
				catch(Exception e)
				{
					result = false;
				}
			}
			if(result)
			{
				try
				{
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					// Check for the practioner of rights for given nursing unit
					sbSql.append(" Select '1' from  ip_nursing_unit_for_pract where facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode +"' and practitioner_id='"+topractitionerid+"' ");
					stmt=con.createStatement();
					srs = stmt.executeQuery(sbSql.toString());
					if(!srs.next())
					{
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"PRACT_ADMN_RIGHTS_DENIED","IP");
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}
					if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
				}
				catch(Exception e)
				{
					result = false;
					 sb.append("Exception in checking Practitioner Admission Rights "+e.toString());
					 e.printStackTrace();
				}
			}
			/*Thursday, April 29, 2010 ,commented for PE , values will pass from servlet*/
			/*
			if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
			sbSql.append(" select to_char(date_of_birth,'dd/mm/rrrr') date_of_birth ,sex from mp_patient where patient_id = '"+patientid+"' ");
			stmt = con.createStatement();
			srs  = stmt.executeQuery(sbSql.toString());
			String dateofbirth = "";
			if(srs.next())
			{
				patientgender = srs.getString("sex") == null ? "" : srs.getString("sex");
				dateofbirth   = srs.getString("date_of_birth") == null ? "" : srs.getString("date_of_birth");
			}
			if(srs !=null) srs.close(); 
			if(stmt !=null) stmt.close();
			*/
			if(result)
			{
				try
				{
					if(toroomno == null || toroomno.equals(""))
					{
						// Get the target room no 
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append("Select ROOM_NO from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' And bed_no='"+tobedno+"'");
						stmt = con.createStatement();
						srs = stmt.executeQuery(sbSql.toString());
						while(srs.next())
						{
							toroomno = srs.getString("ROOM_NO");
						}
						if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
					}
					// Check for this nursing unit tranfer allowed or not
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					//sbSql.append(" SELECT age_group_code, locn_type, allow_emerg_trf_yn FROM ip_nursing_unit WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' ");
					sbSql.append(" select a.occ_male_bed_count, a.occ_female_bed_count,a.occ_unknown_bed_count,b.age_group_code,b.locn_type,b.check_same_sex_in_room_yn,b.allow_emerg_trf_yn FROM IP_NURSING_UNIT_ROOM a, IP_NURSING_UNIT b WHERE a.facility_id ='"+facilityId+"' AND b.nursing_unit_code = '"+tonursingunitcode+"' AND  b.facility_id=a.facility_id AND  b.nursing_unit_code = a.nursing_unit_code AND  a.room_no = '"+toroomno+"' ");
					stmt=con.createStatement();
					srs = stmt.executeQuery(sbSql.toString());
					String allow_emerg_trf_yn = "";
					if (srs.next())
					{
						String agegrpcode   = srs.getString("age_group_code") == null ? "" : srs.getString("age_group_code");
						nursingunittype     = srs.getString("locn_type") == null ? "" : srs.getString("locn_type") ;
						allow_emerg_trf_yn  = srs.getString("allow_emerg_trf_yn")==null ? "N" : srs.getString("allow_emerg_trf_yn");
						check_same_sex_in_room_yn	= srs.getString("check_same_sex_in_room_yn")==null ? "N" : srs.getString("check_same_sex_in_room_yn");
						malebedcount		= srs.getInt("occ_male_bed_count");
						femalebedcount		= srs.getInt("occ_female_bed_count");
						unknownbedcount		= srs.getInt("occ_unknown_bed_count");

						if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
						
						if(!agegrpcode.equals(""))
						{
							// Check for the nursing unit have any criteria of age group or sex
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append(" Select '1' from am_age_group Where age_group_code='"+agegrpcode+"'  And NVL(GENDER,'"+patientgender+"')= '"+patientgender+"' AND  trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
							stmt = con.createStatement();
							srs  = stmt.executeQuery(sbSql.toString());
							if(!srs.next())
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "AGE_GENDER_NOT_ALLOWED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
							if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
						}
					}
					if (allow_emerg_trf_yn.equals("N"))
					{
						if(!(fmnursingunitcode.equals(tonursingunitcode)))
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "EMER_TRANSFER_NOT_ALLOWED","IP" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					}
				}
				catch(Exception e)
				{
					result = false;
					 sb.append("Exception in checking Valid Age Group and gender "+e.toString());
					 e.printStackTrace();
				}
			}
			if(result)
			{
				try
				{
					if (!(tobedno.equals("") || tobedno == null ))
					{
						// Check the bed validity and sex indicators
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append(" Select  sex_spec_ind, occupying_patient_id, bed_type_code, specialty_code from IP_NURSING_UNIT_BED WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' And bed_no='"+tobedno+"' ");
						stmt=con.createStatement();
						srs = stmt.executeQuery(sbSql.toString());
						if(!srs.next())
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "INVALID_BED","Common" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
						else
						{
							String occupyingpatientid	= srs.getString("Occupying_Patient_Id") == null ? "" : srs.getString("Occupying_Patient_Id") ;
							String sex_spec_ind			= srs.getString("sex_spec_ind") == null ? "" : srs.getString("sex_spec_ind") ;
							tobedtype					= srs.getString("bed_type_code")  == null ? "" : srs.getString("bed_type_code");
							String splty_code			= srs.getString("specialty_code")==null ? "" : srs.getString("specialty_code");
			
							if (!(occupyingpatientid.equals("") || occupyingpatientid.equals(patientid)))
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "OCCUPIED_BED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
							else if (!splty_code.equals("") && !splty_code.equals(tospecialitycode)) //Added for specialty to bed validation
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "BED_SPLTY_INVALID","IP" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
							else if (!sex_spec_ind.equals("") && !sex_spec_ind.equals(patientgender)) //Added for gender to bed validation
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale,"AGE_GENDER_NOT_ALLOWED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
						}
						if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
					}
				}
				catch(Exception e)
				{
					result = false;
					sb.append("Exception in checking valid bed "+e.toString());
					e.printStackTrace();
				}
			}

			if(result)
			{
				try
				{
					// Check the is there any booking for this bed or not
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select booking_type, override_yn from IP_BED_BOOKING WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+tonursingunitcode+"' ");
					sbSql.append(" and req_bed_no='"+tobedno+"' and booking_status='0' and sysdate between blocked_from_date_time and blocked_until_date_time ");
					stmt = con.createStatement();
					srs  = stmt.executeQuery(sbSql.toString());
					
					sb1.setLength(0);
					
					if (srs.next())
					{
						bookingtype = srs.getString(1) == null ? "" : srs.getString(1);
						overrideyn  = srs.getString(2)	== null ? "" : srs.getString(2);
						if (overrideyn.equals("N"))
						{
							if (bookingtype.equals("L"))
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "NON_OVERRIDEABLE_BKG","IP");
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
							else
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "BLOCKED_BED","IP");
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
						}
						else
						{
							if (bookingtype.equals("L"))
							{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage(locale,"OVERRIDEABLE_BKG","IP" ) ;
								sb1.append( (String) message.get("message") ) ;
								message.clear();
							}
							else
							{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage(locale,"OVERRIDEABLE_BLOCKING","IP");
								sb1.append( (String) message.get("message") ) ;
								message.clear();
							}
						}
					}
						if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
				}
				catch(Exception e)
				{
					result = false;
					sb.append("Exception in checking Blocked/Booked beds "+e.toString());
					sb1.append("Exception in checking Blocked/Booked beds "+e.toString());
					e.printStackTrace();
				}
			}

			if(result)
			{
				try
				{
					//Check whether FM module was installed or not
					/*Thursday, April 29, 2010 , commented for PE , query moved to line no 102*/
					/*
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" select install_yn from sm_module where module_id = 'FM' ");
					stmt	=	con.createStatement();
					srs		=	stmt.executeQuery(sbSql.toString());

					if (srs!=null && srs.next())
						fm_install_yn = srs.getString(1);
					if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
					*/
					if (fm_install_chk.equals("Y"))
					{
						// Check the transfer file status for the nursing unit
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append( "Select auto_rec_ward_yn, transfer_file_yn from fm_parameter  where facility_id ='"+facilityId+"'");
						stmt = con.createStatement();
						srs  = stmt.executeQuery(sbSql.toString());

						if (srs!=null && srs.next())
						{
							auto_rec_ward_chk  = srs.getString(1);
							transfter_file_chk = srs.getString(2);
						}
						if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
						if (transfter_file_chk.equals("Y"))
						{
							// Get the file no for this patient file
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append( "Select a.auto_file_transfer_yn, a.fs_locn_code, b.locn_identity from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id ='"+facilityId+"' and a.nursing_unit_code='"+fmnursingunitcode+"'");
							stmt=con.createStatement();
							srs = stmt.executeQuery(sbSql.toString());
							if (srs!=null && srs.next())
							{
								auto_file_transfer_chk = srs.getString(1);
								fm_fs_locn_val		  = srs.getString(2);
								fm_locn_identity_val	  = srs.getString(3);
								if (fm_fs_locn_val==null) fm_fs_locn_val="";
							}
							if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
							if (fm_install_chk.equals("Y")&&transfter_file_chk.equals("Y")
							&&auto_file_transfer_chk.equals("Y")&&fm_fs_locn_val!="")
							{
								// Check the file is transit stage or not
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append("Select count(1) from fm_transit_file where  facility_id ='"+facilityId+"' and patient_id='"+patientid+"'");
								stmt=con.createStatement();
								srs = stmt.executeQuery(sbSql.toString());
								int cnt=0;
								if (srs!=null && srs.next())
									cnt =srs.getInt(1);
								if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
								if(cnt==0)
									result=true;
								else
								{
									result = false;
									java.util.Hashtable message = MessageManager.getMessage( locale, "FILE_IN_TRASIT","IP" ) ;
									sb.append( (String) message.get("message") ) ;
									message.clear();
								}
							}
						}
					}
				}
				catch(Exception e)
				{
					result = false;
					sb.append("Exception in checking for File in Transit "+e.toString());
					e.printStackTrace();
				}
				if(result)
				{
					try
					{
						// Check the target room status
						/*
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append(" select a.occ_male_bed_count, a.occ_female_bed_count, a.occ_unknown_bed_count from ip_nursing_unit_room a, ip_nursing_unit b where a.facility_id='"+facilityId+"' and   a. nursing_unit_code='"+tonursingunitcode+"' and  a.room_no='"+toroomno+"' and  b.facility_id=a.facility_id and  b.nursing_unit_code=a.nursing_unit_code and b.check_same_sex_in_room_yn='Y' ");
						stmt = con.createStatement();
						srs = stmt.executeQuery(sbSql.toString());
						if(srs.next())
						{
							int malebedcount    = srs.getInt(1);
							int femalebedcount  = srs.getInt(2);
							int unknownbedcount = srs.getInt(3);
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
							if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
							*/
							if(check_same_sex_in_room_yn.equals("Y"))
							{
								if(malebedcount > 0) 	L_current_gender      = "M";
								else if(femalebedcount > 0) L_current_gender  = "F";
								else if(unknownbedcount > 0) L_current_gender = "U";
								if (!L_current_gender.equals("*") && !L_current_gender.equals(patientgender))
								{
									result = false;
									java.util.Hashtable message = MessageManager.getMessage( locale, "IN_ROOM_ONLY_SAME_GENDER","IP" ) ;
									sb.append( (String) message.get("message") ) ;
									message.clear();
								}
							}
					}
					catch(Exception e)
					{
						result = false;
						sb.append("Exception in checking for same gender in a room "+e.toString());
						e.printStackTrace();
					}
				}
			}
		}catch(Exception e)
		{
			result  = false;
			sb.append( e.getMessage() +" Error in ValidateIPEmergencyTransfer " ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}
			catch(Exception e1){}
		}
		finally
		{
			 try{
				  if(pstmt != null)			pstmt.close() ;
				  if(rset != null)			rset.close();
				  if(stmt != null)			stmt.close();
				  if(srs != null)			srs.close();
				  if(stmt1 != null)			stmt1.close();
			 }catch(Exception ce){}
			ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;		
		results.put( "fm_install_yn", fm_install_chk ) ;		
		results.put( "transfter_file_yn", transfter_file_chk ) ;		
		results.put( "auto_file_transfer_yn", auto_file_transfer_chk ) ;		
		results.put( "fm_fs_locn_code", fm_fs_locn_val ) ;		
		results.put( "fm_locn_identity", fm_locn_identity_val ) ;		
		results.put( "auto_rec_ward_yn", auto_rec_ward_chk ) ;		
		results.put( "bookingtype", bookingtype ) ;		
		results.put( "overrideyn", overrideyn ) ;		
		results.put( "nursingunittype", nursingunittype ) ;		
		return results ;
	} // end ValidateEmergencyTransfer
	

/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertIPEmergencyTransfer(java.util.Properties p, java.util.HashMap hashData )
	{

		Connection con 				= null;
		PreparedStatement pstmt		= null;
		ResultSet rset 				= null;
		Statement stmt 				= null;
		Statement stmt1				= null;
		ResultSet srs 				= null;
		CallableStatement cstmt		= null;
		//Connection bookingCon 		= null;
		String locale				= "";
		locale						= p.getProperty("LOCALE");
		String nursingunittype		= "";
		String bed_class_chk		= "N";
		String billing_group_id		= "";
		String tobedtype			= "";
		String auto_rec_ward_yn		= "";
		String fm_install_yn		= "";
		String transfter_file_yn    = "";
		String auto_file_transfer_yn= "";
		String fm_fs_locn_code		= "";
		String fm_locn_identity		= "";
		String file_no				= "";
		String toroomno				= "";
		String fr_bed_type_code_by_defn= "";
		String 	fr_bed_type_code	= "";
		String facilityId			= "";
		String patientid			= "";
		String strEncid				= "";
		String transferdate			= "";
		String transfertype			= "";
		String topractitionerid		= "";
		String tospecialitycode		= "";
		String tobedclass			= "";
		String tonursingunitcode	= "";
		String toservicecode		= "";
		String tosubservcode		= "";
		String tobedno				= "";
		String strTodc				= "";
		String frpractitionerid		= "";
		String frspecialitycode		= "";
		String frbedclass			= "";
		String frnursingunitcode	= "";
		String frservicecode		= "";
		String frsubservcode		= "";
		String frbedno				= "";
		String frroomno				= "";
		String strFrdc				= "";
		String frbedtype			= "";
		String modified_bed_type_code = "";
		String addedAtWorkstation	= "";
		String bl_interface_yn		= "";
		String bl_operational		= "";
		String encounter_id			= "";
		String frteamid				= "";
		String toteamid				= "";
		String blocking_type_code	= "";
		String bed_blk_period		= "";
		String blk_remark			= "";
		String override_yn			= "";
		String operStn_bed_class_yn	= "";
		String cancel_code			= "";
		String ipparam_bed_yn		= "N";
		String pseudo_bed_yn		= "";
		String deactivate_pseudo_bed_yn = "";
		String mother_bed_status	= "";
		String change_bed_YN		= "";
		String patient_class		= "";
		String reason_status		= "";
		String tran_type			= "";
		String modified_date_val	= "";
		String admission_date		= "";
		String is_reserved_bed_checked	= "";
		String reason_for_reserved_bed	= "";
		String confirm_yn			= "";
		String is_to_bed_equals_reserve_bed	= "";
		String reserve_bed_no		=  "";
		String reserve_nurs_unit_code	= ""; 
		String reserve_room_no		= "";
		String system_date			= "";
		String reserve_specialty_code = "";
		String reserve_practitioner_id= "";
		String reserve_bed_type_code  = "";
		String reserve_service_code	= "";
		String reserve_bed_class_code = "";
		String reserve_bed_on_tfr_yn= "";
		String transfer_date        = "";
		String new_reserved_bed_no	= "";
		String dateofbirth			= "";
		String patientgender		= "";
		String retain_res_bed		= "";
		String exp_discharge_date_time	= "";
		String transfer_wo_delink_yn	= "";//Added for the CRF - HSA-CRF-0035
		//Added for this SCF GDOH-SCF-0193 
		Boolean checkTrnasferDate = false; 
		CallableStatement cstmt1  = null;
		String episode_type       ="";
		//End GDOH-SCF-0193 
		String reqRadioBtn			  = ""; //Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
		
		facilityId					= (String)hashData.get("facilityId");
		patientid					= (String)hashData.get("patientid");
		strEncid					= (String)hashData.get("strEncid");
		transferdate				= (String)hashData.get("transferdate");
		transfertype				= (String)hashData.get("transfertype");
		topractitionerid			= (String)hashData.get("topractitionerid");
		tospecialitycode			= (String)hashData.get("tospecialitycode");
		tobedclass					= (String)hashData.get("tobedclass");
		tobedtype					= (String)hashData.get("tobedtype");

		tonursingunitcode			= (String)hashData.get("tonursingunitcode");
		billing_group_id			= (String)hashData.get("billing_group_id");
		toservicecode				= (String)hashData.get("toservicecode");
		tosubservcode				= (String)hashData.get("tosubservcode");
		tobedno						= (String)hashData.get("tobedno");
		toroomno					= (String)hashData.get("toroomno");
		strTodc						= (String)hashData.get("strTodc");
		frpractitionerid			= (String)hashData.get("frpractitionerid");
		frspecialitycode			= (String)hashData.get("frspecialitycode");
		frbedclass					= (String)hashData.get("frbedclass");
		frnursingunitcode			= (String)hashData.get("frnursingunitcode");
		frservicecode				= (String)hashData.get("frservicecode");
		frsubservcode				= (String)hashData.get("frsubservcode");
		frbedno						= (String)hashData.get("frbedno");
		frroomno					= (String)hashData.get("frroomno");
		strFrdc						= (String)hashData.get("strFrdc");
		frbedtype					= (String)hashData.get("frbedtype");

		modified_bed_type_code		= (String)hashData.get("modified_bed_type_code");

		/*Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 Start*/
		String bl_adm_remarks		= (String)hashData.get("bl_adm_remarks");
		String bl_bed_request		= (String)hashData.get("bl_bed_request");
		String bl_bed_type_code		= (String)hashData.get("bl_bed_type_code");
		/*Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 End*/


		addedAtWorkstation			= (String)hashData.get("addedAtWorkstation");
		bl_interface_yn				= (String)hashData.get("bl_interface_yn");
		bl_operational				= (String)hashData.get("bl_operational");
		encounter_id				= (String)hashData.get("encounter_id");
		frteamid					= (String)hashData.get("frteamid");
		toteamid					= (String)hashData.get("toteamid");
		blocking_type_code			= (String)hashData.get("blocking_type_code");
		bed_blk_period				= (String)hashData.get("bed_blk_period");
		if(bed_blk_period.equals("0"))
			bed_blk_period			= "";
		blk_remark					= (String)hashData.get("blk_remark");
		override_yn					= (String)hashData.get("override_yn");
		if(override_yn == null)
			override_yn				= "N";
		operStn_bed_class_yn		= (String)hashData.get("change_bed_class_yn");
		cancel_code					= (String)hashData.get("cancel_reason");
		ipparam_bed_yn				= (String)hashData.get("ipparam_bed_yn");
		pseudo_bed_yn				= (String)hashData.get("pseudo_bed_yn");
		deactivate_pseudo_bed_yn	= (String)hashData.get("deactivate_pseudo_bed_yn");
		mother_bed_status			= checkForNull((String)hashData.get("mother_bed_status"),"N");

		change_bed_YN				= (String)hashData.get("change_bed_YN");
		patient_class				= (String)hashData.get("patient_class");
		
		//Added for this SCF GDOH-SCF-0193
		if(patient_class.equals("IP")){
		  episode_type="I";
		}else if(patient_class.equals("DC")){
		  episode_type="D";  
		}  
		 //End GDOH-SCF-0193 
		
		reason_status				= (String)hashData.get("reason_request");
		tran_type					= (String)hashData.get("tran_type");
		modified_date_val			= (String)hashData.get("modified_date_val");
		admission_date				= (String)hashData.get("admission_date");

		is_reserved_bed_checked		= (String)hashData.get("is_reserved_bed_checked");
		reason_for_reserved_bed		= (String)hashData.get("reason_for_reserved_bed");
		confirm_yn					= (String)hashData.get("confirm_yn");
		is_to_bed_equals_reserve_bed= (String)hashData.get("is_to_bed_equals_reserve_bed");
		reserve_bed_no				= (String)hashData.get("reserve_bed_no");
		reserve_nurs_unit_code		= (String)hashData.get("reserve_nurs_unit_code");
		reserve_room_no				= (String)hashData.get("reserve_room_no");
		system_date					= (String)hashData.get("sdate");
		reserve_specialty_code		= (String)hashData.get("reserve_specialty_code");
		reserve_practitioner_id		= (String)hashData.get("reserve_practitioner_id");
		reserve_bed_type_code		= (String)hashData.get("reserve_bed_type_code");
		reserve_service_code		= (String)hashData.get("reserve_service_code");
		reserve_bed_class_code		= (String)hashData.get("reserve_bed_class_code");
		reserve_bed_on_tfr_yn		= (String)hashData.get("reserve_bed_on_tfr_yn");
		transfer_date        		= (String)hashData.get("transfer_date");
		dateofbirth					= (String)hashData.get("dateofbirth"); 
		patientgender				= (String)hashData.get("patientgender");
		retain_res_bed				= (String)hashData.get("retain_res_bed");
		exp_discharge_date_time	    = (String)hashData.get("exp_discharge_date_time");
		transfer_wo_delink_yn	    = (String)hashData.get("transfer_wo_delink_yn");//Added for the CRF - HSA-CRF-0035
		
		reqRadioBtn					= checkForNull((String)hashData.get("reqRadioBtn"));//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866

		String ext_num				= "";
		String blocked_until_date	= "";
		long    encounterid			= 0;
		int	    todailycharge		= 0;
		int	    frdailycharge		= 0;
		int babyCount=0;//Added for the CRF - HSA-CRF-0035
		
		int transferBabyCount=0;//Added for this SCF ML-MMOH-SCF-0663
		
		if(!strEncid.equals(""))
			encounterid				= Long.parseLong(strEncid);
		if(!strTodc.equals(""))
			todailycharge			= Integer.parseInt(strTodc);
		if(!strFrdc.equals(""))
			frdailycharge			= Integer.parseInt(strFrdc);
		java.util.HashMap results	= new java.util.HashMap() ;
		boolean result				= false ;
		boolean CALL_REPORT			= false ;
		StringBuffer sb				= new StringBuffer(""); 
		StringBuffer sbSql			= new StringBuffer("");
		StringBuffer sb1			= new StringBuffer("");

		results.put( "error", "no error" ) ;
		String addedById			= p.getProperty( "login_user" ) ;
		int rs ;
		HashMap hashValData			= new HashMap();
		ArrayList<String> babyBedNo=new ArrayList<String>();//Added for the CRF - HSA-CRF-0035
		ArrayList<String> babyPatientId=new ArrayList<String>();//Added for the CRF - HSA-CRF-0035
		// MOD#08	Introduced new variable strBLMessage
		String strBLMessage			= "";
		String strBLSpecialMessage  = "";
		boolean boolBLInstall		= false;
		hashValData.put("facilityId",facilityId);      
		hashValData.put("topractitionerid",topractitionerid);
		hashValData.put("tospecialitycode",tospecialitycode);
		hashValData.put("tonursingunitcode",tonursingunitcode);	
		hashValData.put("toroomno",toroomno);        			
		hashValData.put("patientid",patientid);       					
		hashValData.put("tobedno",tobedno);         					
		hashValData.put("tobedclass",tobedclass);      						
		hashValData.put("fmnursingunitcode",frnursingunitcode);
		hashValData.put("modified_date_val",modified_date_val);
		hashValData.put("encounter_id",encounter_id);
		hashValData.put("dateofbirth",dateofbirth);
		hashValData.put("patientgender",patientgender);
		// Check the target values validation
		HashMap ret = ValidateIPEmergencyTransfer(p,hashValData);

		try
		{
			con = ConnectionManager.getConnection(p);
			
			checkTrnasferDate=CommonBean.isSiteSpecific(con, "IP","UPDATE_TRANSFER_DATE"); //Added for this SCF GDOH-SCF-0193			
			con.setAutoCommit(false); 
		}
		catch(Exception Ex)
		{ 
			Ex.printStackTrace();
		}

		boolean retval		=((Boolean)ret.get("status")).booleanValue();
		sb.append((String)ret.get("error"));
		fm_install_yn		= (String)ret.get("fm_install_yn");
		transfter_file_yn	= (String)ret.get("transfter_file_yn");
		auto_file_transfer_yn= (String)ret.get("auto_file_transfer_yn");
		fm_fs_locn_code		= (String)ret.get("fm_fs_locn_code");
		auto_rec_ward_yn	= (String)ret.get("auto_rec_ward_yn");
		nursingunittype		= (String)ret.get("nursingunittype");
		String booking_type	= (String)ret.get("bookingtype");
		String overrideYN	= (String)ret.get("overrideyn");
		// If validation is true then update the values
		if(retval)
		{
			result = true;
			int reset = 0;
			int bed_srlno = 0;
			if(result)
			{
				try
				{

					if(!(toroomno == null || toroomno.equals("") || toroomno.equals("null")))
					{
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append("select EXT_NUM from am_facility_room where OPERATING_FACILITY_ID='"+facilityId+"'  and ROOM_NUM='"+toroomno+"' ");
						
						if(pstmt!=null) pstmt.close();
						if(rset!=null) rset.close();
						pstmt = con.prepareStatement( sbSql.toString() );
						rset	= pstmt.executeQuery();

						if(rset.next())
						{
							ext_num = rset.getString("EXT_NUM") == null ? "" : rset.getString("ext_num");
						}

						if(pstmt!=null) pstmt.close();
						if(rset!=null) rset.close();			
				
					}
                /*Below line Added for this SCF GDOH-SCF-0193*/				
				 if(checkTrnasferDate){				
					   try
						{
							cstmt1=con.prepareCall("{call BL_CHK_TRFR_DATE_ADMN(?,?,?,?,?,?,?)}");
							cstmt1.setString(1,facilityId);
							cstmt1.setString(2,patientid);
							cstmt1.setString(3,episode_type);
							cstmt1.setLong(4,encounterid);							
							cstmt1.setString(5,transfer_date);
							cstmt1.registerOutParameter(6,java.sql.Types.VARCHAR);
							cstmt1.registerOutParameter(7,java.sql.Types.VARCHAR);
							boolean udateTransferdate=cstmt1.execute();	
							String p_err_id=cstmt1.getString(6);
							String p_err_text=cstmt1.getString(7);                            				
							if(cstmt1 != null) cstmt1.close();
						}
						catch (Exception tre1)
						{
						    result = false;
							tre1.printStackTrace();
						}
				  } 				   
				   //End GDOH-SCF-0193
					
					/*Friday, May 14, 2010, update for IP_BED_BOOKING_SRL_CTRL to generate NEXT_BOOKING_SRL_NO will be done through following procedure*/
				//if(!bed_blk_period.equals(""))Monday, June 21, 2010 , SRR20056-SCF-4703 [IN:022208]
				if(!bed_blk_period.equals("") || is_reserved_bed_checked.equals("Y"))
				{
					try
					{
						cstmt=con.prepareCall("{call IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO(?,?,?,?,?,?)}");
						cstmt.setString(1,facilityId);
						cstmt.setString(2,"T");
						cstmt.setString(3,"Y");
						cstmt.setString(4,addedAtWorkstation);
						cstmt.setString(5,addedById);
						cstmt.registerOutParameter(6,java.sql.Types.NUMERIC);
						cstmt.execute();
						bed_srlno=cstmt.getInt(6);
						if(cstmt != null) cstmt.close();
					}
					catch (Exception e1)
					{
						result = false;
						e1.printStackTrace();
					}
				}
				/**/
					if(reason_status.equals("1") && tran_type.equals("ET") && result)
					{
						operStn_bed_class_yn = "";
						reset				 = 0;	
						sbSql.delete(0, sbSql.length());
						/*Added Audit column*/
						sbSql.append(" Update IP_BED_CLASS_REQUEST set "); 
						sbSql.append(" REQUEST_STATUS='1' , MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"'" );
						sbSql.append(" WHERE  facility_id= '"+facilityId+"' and TRN_TYPE='ET' and REQUEST_STATUS = '0' and encounter_id = "+encounterid+"");
						pstmt = con.prepareStatement( sbSql.toString());

						try
						{
							reset = pstmt.executeUpdate();
						}
						catch(Exception ex)
						{
							result = false;
							sb.append("error while inserting/updating into ip_bed_class_request"+ex.getMessage());
						}
						if(reset > 0) result = true; else result = false;
						if(pstmt != null) pstmt.close();

					
						if(result)
						{
							reset = 0;
							try
							{
								if(sbSql.length() > 0)	sbSql.delete(0, sbSql.length());
								//Added Audit column
								sbSql.append("  update IP_OPEN_ENCOUNTER set ");
								sbSql.append("  TFR_REQ_STATUS = '', ");
								/*if(confirm_yn!=null && confirm_yn.equals("Y"))
								{
									sbSql.append(" RESERVED_NURS_UNIT_CODE = '', ");
									sbSql.append(" RESERVED_ROOM_NO = '', ");
									sbSql.append(" RESERVED_BED_NO = '', ");

								}*/
								sbSql.append(" modified_by_id = ?, ");
								sbSql.append(" modified_at_ws_no = ?, modified_date = sysdate,ROOM_TEL_EXT_NUM = ?, modified_facility_id = ?  ");
								sbSql.append(" where ");
								sbSql.append(" facility_id = ? and ENCOUNTER_ID = ?");
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString(1, addedById);
								pstmt.setString(2, addedAtWorkstation);
								pstmt.setString(3, ext_num);
								pstmt.setString(4, facilityId); //Added Audit column
								pstmt.setString(5, facilityId);
								pstmt.setLong(6, encounterid);

								reset = pstmt.executeUpdate();
								if(reset > 0)
								result = true;
								else
								result = false;
								if(pstmt != null)
								pstmt.close();
							}catch(Exception ex)
							{
								result = false;
								sb.append("error while updating into ip_open_encounter " + ex.getMessage());
								ex.printStackTrace(System.out);
							}
						}
					}

					if(bl_operational.equals("Y"))
					{
						try
						{
							if(srs!=null) srs.close();
							if(stmt!=null) stmt.close();

							String blSql= "select BL_CHECK_ELIGIBILITY_LEVEL('"+billing_group_id+"','"+tobedtype+"') from dual";
							stmt = con.createStatement();
							srs = stmt.executeQuery(blSql);
							if(srs != null && srs.next())
							{
								bed_class_chk = srs.getString(1);
							}
							if(bed_class_chk.equals("")) bed_class_chk = "N";
							if(srs!=null) srs.close();
							if(stmt!=null) stmt.close();

						}catch (Exception e)
						{ 
							e.printStackTrace();
						}
					}
	
					String insert_val = "";
					if(ipparam_bed_yn.equals("Y") && operStn_bed_class_yn.equals("N") && change_bed_YN.equals("Y") && bed_class_chk.equals("Y"))
					{
						insert_val = "0";
					}
					else
					{
						insert_val = "1";
					}

					if(result)
					{
						int srl_no = 0;
						try
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							//sbSql.append("select nvl(MAX(srl_no),0)+1 srl_no from IP_BED_CLASS_REQUEST where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" ");select to_char((sysdate+'"+bed_blk_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual
							/*Friday, April 30, 2010 , modified for PE */
							sbSql.append("select nvl(MAX(srl_no),0)+1 srl_no,to_char((sysdate+'"+bed_blk_period+"'/24),'dd/mm/rrrr hh24:mi') a from IP_BED_CLASS_REQUEST where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" ");
							stmt   = con.createStatement();
							srs	   = stmt.executeQuery(sbSql.toString());
							if(srs.next())
							{
								srl_no = srs.getInt("srl_no");
								blocked_until_date = srs.getString("a");
							}
							if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
						}catch(Exception exp){	}
						/// by Sridhar R on 15 OCT 2004... record will not be inserted into IP_BED_CLASS_REQUEST...if form_change_bed_class_yn = "N"...
						if(sbSql.length() > 0 ) 
						sbSql.delete(0,sbSql.length());
						sbSql.append("  insert into IP_BED_CLASS_REQUEST ");
						sbSql.append(" (facility_id,encounter_id,srl_no,patient_id,trn_type ");
						sbSql.append(" ,TRANSFER_TYPE_CODE,REQUEST_DATE,REQ_NURSING_UNIT_CODE,REQ_BED_CLASS_CODE,REQ_BED_TYPE_CODE  ");
						sbSql.append(",REQ_ROOM_NO,REQ_BED_NO,FR_NURSING_UNIT_CODE,FR_SERVICE_CODE,FR_SUBSERVICE_CODE ");
						sbSql.append(" ,FR_BED_CLASS_CODE,FR_BED_TYPE_CODE,FR_ROOM_NO ");
						sbSql.append(" ,FR_BED_NO,fr_specialty_code ");
						sbSql.append(" ,FR_PRACTITIONER_ID, FR_TEAM_ID, TO_NURSING_UNIT_CODE,");
						sbSql.append(" TO_SERVICE_CODE,TO_SUBSERVICE_CODE "	);
						sbSql.append(" ,TO_BED_CLASS_CODE, TO_BED_TYPE_CODE " );
						sbSql.append(" ,TO_ROOM_NO,	 TO_BED_NO " );
						sbSql.append(" ,TO_SPECIALTY_CODE,	TO_PRACTITIONER_ID " );
						sbSql.append(" ,TO_TEAM_ID, REQUEST_STATUS, CONF_CANC_DATE_TIME,CANCEL_REASON_CODE,BLOCKING_TYPE_CODE,BLOCKING_PERIOD,BLOCKING_REMARKS,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DELINK_BABY_YN) values ( ?, ?, ?, ?, ?, ?,to_date(?,'dd/mm/rrrr hh24:MI'),?,?,?, ?, ?, ?,?, ?,?, ?, ?, ?, ?, ?,?,?, ?, ?,?, ?, ?,?, ?, ?,?,?,to_date(?,'dd/mm/rrrr hh24:MI'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)" );

						pstmt = con.prepareStatement( sbSql.toString() );
						pstmt.setString	( 1, facilityId ) ;
						pstmt.setLong	( 2, encounterid ) ;
						pstmt.setInt	( 3, srl_no ) ;
						pstmt.setString	( 4, patientid);
						pstmt.setString	( 5, "ET" ) ;
						pstmt.setString	( 6, transfertype ) ;
						pstmt.setString	( 7, transferdate ) ;
						pstmt.setString	( 8, tonursingunitcode ) ;
						pstmt.setString	( 9, tobedclass ) ;
						pstmt.setString	( 10, tobedtype ) ;
						pstmt.setString	( 11, toroomno ) ;
						pstmt.setString	( 12, tobedno ) ;
						pstmt.setString	( 13, frnursingunitcode ) ;
						pstmt.setString	( 14, frservicecode);
						pstmt.setString	( 15, frsubservcode);
						pstmt.setString	( 16, frbedclass ) ;
						pstmt.setString	( 17, frbedtype ) ;
						pstmt.setString	( 18, frroomno ) ;
						pstmt.setString	( 19, frbedno ) ;
						pstmt.setString	( 20, frspecialitycode ) ;
						pstmt.setString	( 21, frpractitionerid ) ;
						pstmt.setString	( 22, frteamid ) ;
						pstmt.setString	( 23, tonursingunitcode ) ;
						pstmt.setString	( 24, toservicecode ) ;
						pstmt.setString	( 25, tosubservcode ) ;
						pstmt.setString	( 26, tobedclass ) ;
						pstmt.setString	( 27, tobedtype ) ;
						pstmt.setString	( 28, toroomno ) ;
						pstmt.setString	( 29, tobedno ) ;
						pstmt.setString	( 30, tospecialitycode ) ;
						pstmt.setString	( 31, topractitionerid ) ;
						pstmt.setString	( 32, toteamid ) ;
						if(insert_val.equals("0"))
							pstmt.setString	( 33, "0" ) ;
						else if(insert_val.equals("1"))
							pstmt.setString	( 33, "1" ) ;
						pstmt.setString	( 34, transferdate ) ;
						pstmt.setString	( 35, cancel_code ) ;
						pstmt.setString	( 36, blocking_type_code ) ;
						pstmt.setString	( 37, bed_blk_period ) ;
						pstmt.setString	( 38, blk_remark ) ;
						pstmt.setString	( 39, addedById);  
						pstmt.setString	( 40, addedAtWorkstation ) ;
						pstmt.setString	( 41, facilityId ) ;
						pstmt.setString	( 42, addedById );
						pstmt.setString	( 43, addedAtWorkstation ) ;
						pstmt.setString	( 44, facilityId ) ;
						pstmt.setString	( 45, mother_bed_status ) ;

						try
						{
							reset = pstmt.executeUpdate() ;
						}
						catch(Exception ex)
						{
							sb.append("error while inserting into ip_bed_class_request"+ex.getMessage());
						}


						if(reset > 0)
						{
							result = true; 
							if(insert_val.equals("0"))
							{
								CALL_REPORT = true;
							}
						}
						else 
						{
							result = false;
						}

						if(pstmt !=null) pstmt.close();
					}

					if(insert_val.equals("0") && result)
					{
						reset = 0;
						try
						{
							if(sbSql.length() > 0)
							sbSql.delete(0, sbSql.length());
							//Added Audit column
							sbSql.append("  update IP_OPEN_ENCOUNTER set ");
							sbSql.append("  TFR_REQ_STATUS = '0', ");
							/*if(confirm_yn!=null && confirm_yn.equals("Y"))
								{
									sbSql.append(" RESERVED_NURS_UNIT_CODE = '', ");
									sbSql.append(" RESERVED_ROOM_NO = '', ");
									sbSql.append(" RESERVED_BED_NO = '', ");

								}*/
							sbSql.append(" modified_by_id = ?, ");
							sbSql.append(" modified_at_ws_no = ?, modified_date = sysdate ,ROOM_TEL_EXT_NUM = ?, modified_facility_id = ? ");
							sbSql.append(" where ");
							sbSql.append(" facility_id = ? and ENCOUNTER_ID = ?");
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString(1, addedById);
							pstmt.setString(2, addedAtWorkstation);
							pstmt.setString(3, ext_num);
							pstmt.setString(4, facilityId); //Added Audit column
							pstmt.setString(5, facilityId);
							pstmt.setLong(6, encounterid);
							reset = pstmt.executeUpdate();

		
							if(reset > 0)
								result = true;
							else
								result = false;

							if(pstmt != null) pstmt.close();

							

							if(result && is_reserved_bed_checked!=null && (is_reserved_bed_checked.equals("Y") || is_reserved_bed_checked.equals("N")) && (is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N") && reserve_bed_no!=null && !reserve_bed_no.equals("")))
							{

								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append("update pr_encounter set ");
									if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("Y"))
										sbSql.append(" RESERVED_NURS_UNIT_CODE = ? , RESERVED_ROOM_NO= ?, RESERVED_BED_NO=? ");
									else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("N"))
										sbSql.append(" , RESERVED_NURS_UNIT_CODE = ? , RESERVED_ROOM_NO= ?, RESERVED_BED_NO=? ");
									else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N") && reserve_bed_no!=null && !reserve_bed_no.equals(""))
										sbSql.append(" , RESERVED_NURS_UNIT_CODE = ? , RESERVED_ROOM_NO= ?, RESERVED_BED_NO=? ");	
						
								
								sbSql.append(" , modified_by_id = ? , modified_date = sysdate, modified_at_ws_no=? ,modified_facility_id = ? ");
								sbSql.append(" where facility_id= ? and encounter_id = ? ");

								pstmt = con.prepareStatement( sbSql.toString() );				

								if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("Y"))
								{
									
									/*if(is_to_bed_equals_reserve_bed.equals("Y"))
									{
										pstmt.setString	(1, "" ) ;
										pstmt.setString	(2, "" ) ;
										pstmt.setString	(3, "" ) ;
										new_reserved_bed_no = "";
									}*/
									/*else
									{
										pstmt.setString	(1, frnursingunitcode ) ;
										pstmt.setString	(2, frroomno ) ;
										pstmt.setString	(3, frbedno ) ;
									}*/
									if(is_to_bed_equals_reserve_bed.equals("Y"))
									{
										
										pstmt.setString	(1, frnursingunitcode ) ;
										pstmt.setString	(2, frroomno ) ;
										pstmt.setString	(3, frbedno ) ;
										new_reserved_bed_no = frbedno;
									}
									else
									{
										
										pstmt.setString	(1, reserve_nurs_unit_code ) ;
										pstmt.setString	(2, reserve_room_no ) ;
										pstmt.setString	(3, reserve_bed_no ) ;
										new_reserved_bed_no = reserve_bed_no;
									}
									
									pstmt.setString	(4, addedById ) ;
									pstmt.setString	(5, facilityId ) ;
									pstmt.setString	(6, addedAtWorkstation ) ;
									pstmt.setString	(7, facilityId ) ;
									pstmt.setLong	(8, encounterid ) ;
								}
								else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("N"))
								{
									
									/*if(is_to_bed_equals_reserve_bed.equals("Y"))
									{
										pstmt.setString	(1, "" ) ;
										pstmt.setString	(2, "" ) ;
										pstmt.setString	(3, "" ) ;
										new_reserved_bed_no = "";
									}*/
									/*else if(reserve_bed_no==null || reserve_bed_no.equals(""))
									{
										pstmt.setString	(1, frnursingunitcode ) ;
										pstmt.setString	(2, frroomno ) ;
										pstmt.setString	(3, frbedno ) ;
									}
									else
									{
										pstmt.setString	(1, reserve_nurs_unit_code ) ;
										pstmt.setString	(2, reserve_room_no ) ;
										pstmt.setString	(3, reserve_bed_no ) ;
									}
									*/
									/*if(is_to_bed_equals_reserve_bed.equals("Y"))
									{
										pstmt.setString	(1, frnursingunitcode ) ;
										pstmt.setString	(2, frroomno ) ;
										pstmt.setString	(3, frbedno ) ;
										new_reserved_bed_no = frbedno;
									}
									else 
									{*/
										pstmt.setString	(1, frnursingunitcode ) ;
										pstmt.setString	(2, frroomno ) ;
										pstmt.setString	(3, frbedno ) ;
										new_reserved_bed_no = frbedno;
									//}
									pstmt.setString	(4, addedById ) ;
									pstmt.setString	(5, facilityId ) ;
									pstmt.setString	(6, addedAtWorkstation ) ;
									pstmt.setString	(7, facilityId ) ;
									pstmt.setLong	(8, encounterid ) ;
								}
								else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N") && reserve_bed_no!=null && !reserve_bed_no.equals(""))
								{
									
										pstmt.setString	(1, "" ) ;
										pstmt.setString	(2, "" ) ;
										pstmt.setString	(3, "" ) ;
										pstmt.setString	(4, addedById ) ;
										pstmt.setString	(5, facilityId ) ;
										pstmt.setString	(6, addedAtWorkstation ) ;
										pstmt.setString	(7, facilityId ) ;
										pstmt.setLong	(8, encounterid ) ;
										new_reserved_bed_no = "";
								}
								else
								{
									pstmt.setString	(1, addedById ) ;
									pstmt.setString	(2, facilityId ) ;
									pstmt.setString	(3, addedAtWorkstation ) ;
									pstmt.setString	(4, facilityId ) ;
									pstmt.setLong	(5, encounterid ) ;
								}
							
							rs = pstmt.executeUpdate() ;

							
							if(rs > 0)
								result = true;
							else
								result = false;

							if(pstmt !=null) pstmt.close();

							}



						
						}catch(Exception ex)
						{
							result = false;
							sb.append("error while updating into ip_open_encounter 2nd OCCUR " +ex.getMessage());
							ex.printStackTrace(System.out);
						}
					}
					else if(insert_val.equals("1") && result)
					{
						try
						{
							// Update pr_encounter table
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append("update pr_encounter set ");
							sbSql.append("attend_practitioner_id = ? , specialty_code= ?, assign_care_locn_type=?, ");
							sbSql.append(" assign_care_locn_code=?, assign_room_num= ? , assign_bed_num = ?, service_code = ?, SUBSERVICE_CODE = ?, modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ?, team_id = ?, ASSIGN_BED_CLASS_CODE = ?,ASSIGN_BED_TYPE_CODE=?,PAT_CURR_LOCN_TYPE=?,PAT_CURR_LOCN_CODE=?,PAT_TRN_TIME=sysdate, ROOM_TEL_EXT_NUM=? ");

							//if(confirm_yn!=null && confirm_yn.equals("Y"))
								//sbSql.append(" , RESERVED_NURS_UNIT_CODE = ? , RESERVED_ROOM_NO= ?, RESERVED_BED_NO=? ");
							//else 
							if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("Y"))
								sbSql.append(" , RESERVED_NURS_UNIT_CODE = ? , RESERVED_ROOM_NO= ?, RESERVED_BED_NO=? ");
							else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("N"))
								sbSql.append(" , RESERVED_NURS_UNIT_CODE = ? , RESERVED_ROOM_NO= ?, RESERVED_BED_NO=? ");
							else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N") && reserve_bed_no!=null && !reserve_bed_no.equals(""))
								sbSql.append(" , RESERVED_NURS_UNIT_CODE = ? , RESERVED_ROOM_NO= ?, RESERVED_BED_NO=? ");
					
					
							sbSql.append(" where facility_id= ? and encounter_id = ? ");
							pstmt = con.prepareStatement( sbSql.toString() );
							pstmt.setString	( 1, topractitionerid ) ;
							pstmt.setString	( 2, tospecialitycode ) ;
							pstmt.setString	( 3, nursingunittype ) ;
							pstmt.setString	( 4, tonursingunitcode ) ;
							pstmt.setString	( 5, toroomno ) ;
							pstmt.setString	( 6, tobedno ) ;
							pstmt.setString ( 7, toservicecode);
							pstmt.setString ( 8, tosubservcode);
							pstmt.setString ( 9, addedById ) ;
							pstmt.setString (10, addedAtWorkstation ) ;
							pstmt.setString (11, facilityId ) ;
							pstmt.setString (12, toteamid ) ;
							pstmt.setString (13, tobedclass ) ;
							pstmt.setString	(14, tobedtype ) ;
							pstmt.setString	(15, nursingunittype ) ;
							pstmt.setString	(16, tonursingunitcode ) ;
							pstmt.setString	(17, ext_num ) ;

						/*	if(confirm_yn!=null && confirm_yn.equals("Y"))
							{
								pstmt.setString	(18, "" ) ;
								pstmt.setString	(19, "" ) ;
								pstmt.setString	(20, "" ) ;
								pstmt.setString	(21, facilityId ) ;
								pstmt.setLong	(22, encounterid ) ;
							}
							else */
							if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("Y"))
							{
								
								/*if(is_to_bed_equals_reserve_bed.equals("Y"))
								{
									pstmt.setString	(18, "" ) ;
									pstmt.setString	(19, "" ) ;
									pstmt.setString	(20, "" ) ;
									new_reserved_bed_no = "";
								}
								else
								{
									pstmt.setString	(18, frnursingunitcode ) ;
									pstmt.setString	(19, frroomno ) ;
									pstmt.setString	(20, frbedno ) ;
								}*/
								/*else
								{
									pstmt.setString	(18, reserve_nurs_unit_code ) ;
									pstmt.setString	(19, reserve_room_no ) ;
									pstmt.setString	(20, reserve_bed_no ) ;
									new_reserved_bed_no = reserve_bed_no;
								}*/

									if(is_to_bed_equals_reserve_bed.equals("Y"))
									{
										pstmt.setString	(18, frnursingunitcode ) ;
										pstmt.setString	(19, frroomno ) ;
										pstmt.setString	(20, frbedno ) ;
										new_reserved_bed_no = frbedno;
									}
									else
									{
										pstmt.setString	(18, reserve_nurs_unit_code ) ;
										pstmt.setString	(19, reserve_room_no ) ;
										pstmt.setString	(20, reserve_bed_no ) ;
										new_reserved_bed_no = reserve_bed_no;
									}
								pstmt.setString	(21, facilityId ) ;
								pstmt.setLong	(22, encounterid ) ;
							}
							else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn.equals("N"))
							{
								/*if(is_to_bed_equals_reserve_bed.equals("Y"))
								{
									pstmt.setString	(18, "" ) ;
									pstmt.setString	(19, "" ) ;
									pstmt.setString	(20, "" ) ;
									new_reserved_bed_no = "";
								}
								else if(reserve_bed_no==null || reserve_bed_no.equals(""))
								{
									pstmt.setString	(18, frnursingunitcode ) ;
									pstmt.setString	(19, frroomno ) ;
									pstmt.setString	(20, frbedno ) ;
								}
								else
								{
									pstmt.setString	(18, reserve_nurs_unit_code ) ;
									pstmt.setString	(19, reserve_room_no ) ;
									pstmt.setString	(20, reserve_bed_no ) ;
								}*/
								pstmt.setString	(18, frnursingunitcode ) ;
								pstmt.setString	(19, frroomno ) ;
								pstmt.setString	(20, frbedno ) ;
								new_reserved_bed_no = frbedno;
								pstmt.setString	(21, facilityId ) ;
								pstmt.setLong	(22, encounterid ) ;
							}
							else if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N") && reserve_bed_no!=null && !reserve_bed_no.equals(""))
							{
									pstmt.setString	(18, "" ) ;
									pstmt.setString	(19, "" ) ;
									pstmt.setString	(20, "" ) ;
									pstmt.setString	(21, facilityId ) ;
									pstmt.setLong	(22, encounterid ) ;
									new_reserved_bed_no = "";
							}					
							else
							{
								pstmt.setString	(18, facilityId ) ;
								pstmt.setLong	(19, encounterid ) ;
							}
						

							rs = pstmt.executeUpdate() ;
							if(rs > 0)
								result = true;
							else
								result = false;

							if(pstmt !=null) pstmt.close();
		
						}catch(Exception e)
						{
							result = false;
							 sb.append("Exception while updating Pr_encounter/Ip_Open_encounter table "+e.toString());
						}
						String L_practitioner_transfer = "";
						String transferservcharge = "";
						int srlno = 0;
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append("select MAX(srl_no)+1 srl_no from ip_adt_trn	where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" ");
						stmt   = con.createStatement();
						srs	   = stmt.executeQuery(sbSql.toString());
					 if(srs.next())
					 {
						   srlno = srs.getInt("srl_no");
					 }
					if(srs !=null) srs.close(); if(stmt !=null) stmt.close();

					try
					{
						if(srlno > 0)
						{
							//if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							//sbSql.append("  update IP_ADT_TRN set trn_to_date_time = sysdate where srl_no = ("+srlno+" - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");
							
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							//modified for IN012693 Monday, October 05, 2009
							//Below line modified for this SCF GDOH-SCF-0193
							if (bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
							{  
							    /*if(checkTrnasferDate){
								         
								         sbSql.append("  update IP_ADT_TRN set trn_to_date_time = to_date('"+transfer_date+"','dd/mm/rrrr hh24:MI') ");
								}else{*/
								         
								         sbSql.append("  update IP_ADT_TRN set trn_to_date_time = sysdate ");
								//}
							}else
							{
							//modified for 12/15/2008 6021  MF-SCF-0051
								sbSql.append("  update IP_ADT_TRN set trn_to_date_time = to_date('"+transfer_date+"','dd/mm/rrrr hh24:MI') ");
							}
							if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn!=null && confirm_yn.equals("N") )
								sbSql.append("  , RESERVED_YN = 'Y' ");
							
							//updating audit columns
							sbSql.append(", modified_by_id = '" + addedById  + "', modified_date = sysdate, modified_facility_id = '");
							sbSql.append( facilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
							sbSql.append("  where srl_no = ("+srlno+" - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"'");
							
							if(pstmt !=null) pstmt.close();
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.executeUpdate();
							if(pstmt !=null) pstmt.close();
						}
					}catch(Exception ex)
					{
						result = false;
						sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
						ex.printStackTrace();
					}

					 if(!topractitionerid.equals(frpractitionerid))
						 L_practitioner_transfer = "Y";
					 else
						 L_practitioner_transfer = "N";
					int res = 0;
					String bill_type_code = "";
					String blng_class_code = "";
					String blng_serv_code = "";
					String episode_id = encounter_id;
					try
					{
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					// adde for billing on 28/08/08						
						sbSql.append("select to_bed_type_code,to_bed_type_code_by_defn from IP_ADT_TRN where srl_no = ("+srlno+" - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");
						stmt   = con.createStatement();
						srs	   = stmt.executeQuery(sbSql.toString());
						 if(srs.next())
						{
						   fr_bed_type_code = srs.getString("to_bed_type_code");
						   fr_bed_type_code_by_defn = srs.getString("to_bed_type_code_by_defn");
						   if(fr_bed_type_code_by_defn == null || fr_bed_type_code_by_defn.equals(""))
							   fr_bed_type_code_by_defn = fr_bed_type_code;
						}
						if(srs !=null) srs.close(); if(stmt !=null) stmt.close();

					//
						if(result)
						{
							if (bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
							{
								if(modified_bed_type_code == null || modified_bed_type_code.equals(""))
								{
									modified_bed_type_code  = tobedtype;

								}
							}
							else
								modified_bed_type_code  = tobedtype;

							
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append("Insert into IP_ADT_TRN ");
							sbSql.append("( facility_id, encounter_id, srl_no, patient_id, trn_type");
							sbSql.append(", trn_code, trn_date_time, to_nursing_unit, to_room_no, to_bed_no");
							sbSql.append(", to_bed_class_code, to_bed_type_code");
							sbSql.append(", tfr_type");
							sbSql.append(", to_practitioner_id, to_specialty_code, fr_nursing_unit_code, fr_room_no");
							sbSql.append(", fr_bed_no, fr_bed_class_code, fr_bed_type_code");
							sbSql.append(", to_subservice_code");
							sbSql.append(", fr_practitioner_id, fr_specialty_code, emergency_trn_yn, practitioner_tfr_yn");
							sbSql.append(", to_service_code, fr_subservice_code");
							sbSql.append(", added_by_id, added_date, added_facility_id, added_at_ws_no");
							sbSql.append(", modified_by_id, modified_date, modified_facility_id, modified_at_ws_no");
							sbSql.append(", from_pract_team_id, to_pract_team_id, fr_service_code");
							if (bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
							{
								sbSql.append(", blng_class_code, blng_serv_code, bill_type_code");
								sbSql.append(", transfer_chargeable_yn, trn_charge");
								sbSql.append(", fr_daily_rate");
								sbSql.append(", fr_bed_type_code_by_defn, to_bed_type_code_by_defn");
								sbSql.append(", to_daily_rate");
							}

							sbSql.append(", PATIENT_CLASS, ADMISSION_DATE_TIME,PAT_HOSP_REQUEST,BED_TYPE_CODE_CHRG,REASON_REMARKS ");
							sbSql.append(" ) values ( ");
							sbSql.append(" ?, ?, ?, ?, ?");
							//Bellow line modified for this SCF GDOH-SCF-0193
							if (bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
							{ 
							    if(checkTrnasferDate){ 
								 
								 sbSql.append(", ?, to_date('"+transfer_date+"','dd/mm/rrrr hh24:MI'), ?, ?, ?");
								}else{	
                                  								
								  sbSql.append(", ?, sysdate, ?, ?, ?");
								}  
								
							}else
							{   
							//modified for 12/15/2008 6021  MF-SCF-0051
								sbSql.append(", ?, to_date('"+transfer_date+"','dd/mm/rrrr hh24:MI'), ?, ?, ?");
							}
							sbSql.append(", ?, ?");
							sbSql.append(", ?");
							sbSql.append(", ?, ?, ?, ?");
							sbSql.append(", ?, ?, ?");
							sbSql.append(", ?");
							sbSql.append(", ?, ?, ?, ?");
							sbSql.append(", ?, ?"); 
							sbSql.append(", ?, SYSDATE, ?, ?");
							sbSql.append(", ?, SYSDATE, ?, ?");
							sbSql.append(", ?, ?, ?");
							if(bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
							{
								sbSql.append(", ?, ?, ?");
								sbSql.append(", ?, ?, ?");
								sbSql.append(", ?, ?");
								sbSql.append(", ?");
							}
							sbSql.append(", '"+patient_class+"', to_date('"+admission_date+"','dd/mm/rrrr hh24:MI'),'"+bl_bed_request+"','"+bl_bed_type_code+"','"+bl_adm_remarks+"' ");
							sbSql.append(" ) ");
							pstmt = con.prepareStatement( sbSql.toString() );
							pstmt.setString	( 1, facilityId );
							pstmt.setLong	( 2, encounterid ) ;
							pstmt.setInt	( 3, srlno ) ;
							pstmt.setString	( 4, patientid);
							pstmt.setString	( 5, "T" ) ;
							pstmt.setString	( 6, transfertype ) ;
							pstmt.setString	( 7, tonursingunitcode ) ;
							pstmt.setString	( 8, toroomno ) ;
							pstmt.setString	( 9, tobedno ) ;
							pstmt.setString	( 10, tobedclass ) ;
							pstmt.setString	( 11, modified_bed_type_code ) ;
							pstmt.setString	( 12, "E" ) ;
							pstmt.setString	( 13, topractitionerid ) ;
							pstmt.setString	( 14, tospecialitycode ) ;
							pstmt.setString	( 15, frnursingunitcode ) ;
							pstmt.setString	( 16, frroomno ) ;
							pstmt.setString	( 17, frbedno ) ;
							pstmt.setString	( 18, frbedclass ) ;
							//pstmt.setString	( 19, frbedtype ) ;
							pstmt.setString	( 19, fr_bed_type_code ) ;
							pstmt.setString	( 20, tosubservcode ) ;
							pstmt.setString	( 21, frpractitionerid ) ;
							pstmt.setString	( 22, frspecialitycode ) ;
							pstmt.setString	( 23, "Y" ) ;
							pstmt.setString	( 24, L_practitioner_transfer ) ;
							pstmt.setString	( 25, toservicecode ) ;
							pstmt.setString	( 26, frsubservcode);
							pstmt.setString	( 27, addedById);
							pstmt.setString	( 28, facilityId ) ;
							pstmt.setString	( 29, addedAtWorkstation ) ;
							pstmt.setString	( 30, addedById ) ;
							pstmt.setString	( 31, facilityId ) ;
							pstmt.setString	( 32, addedAtWorkstation ) ;
							pstmt.setString	( 33, frteamid ) ;
							pstmt.setString	( 34, toteamid ) ;
							pstmt.setString	( 35, frservicecode);

							if (bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
							{
								pstmt.setString	( 36, blng_class_code ) ;
								pstmt.setString	( 37, blng_serv_code ) ;
								pstmt.setString	( 38, bill_type_code ) ;
								pstmt.setString	( 39, "N" ) ;
								pstmt.setString	( 40, transferservcharge ) ;
								pstmt.setInt	( 41, frdailycharge ) ;
								//pstmt.setString	( 42, frbedtype ) ; 
								pstmt.setString	( 42, fr_bed_type_code_by_defn ) ; 
								//pstmt.setString	( 43, modified_bed_type_code ) ;
								pstmt.setString	( 43, tobedtype ) ;
								pstmt.setInt	( 44, todailycharge ) ;
							}
								res = pstmt.executeUpdate() ;
								if(res > 0) 
								{
									result = true; 
								}
								else 
								{
									result = false;
									sb.append("Exception in updating ip_adt_trn table");
								}
								if(pstmt !=null) pstmt.close();
						}
					}catch(Exception e)
					{
						result = false;
						sb.append("Exception in updating ip_adt_trn table "+e.toString());
						e.printStackTrace();
					}

					try
					{
							
						if(result && is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn!=null && confirm_yn.equals("N"))
						{
							int isRecordFound = 0;
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append(" select count(*) no_of_record from IP_RESERVED_BED_DTL where FACILITY_ID ='"+facilityId+"' and  ENCOUNTER_ID = '"+encounter_id+"' /* and RESERVED_NURSING_UNIT_CODE = '"+frnursingunitcode+"' and  RESERVED_ROOM_NO = '"+frroomno+"' and  RESERVED_BED_NO = '"+frbedno+"' */ and RESERVED_TO_TIME is null ");

								if(pstmt!=null) 
									pstmt.close();
								pstmt = con.prepareStatement( sbSql.toString() );

								try
								{
									rset  = pstmt.executeQuery();
								}
								catch(SQLException sqle)
								{
									result = false;
									sb.append("Exception in counter query of  IP_RESERVED_BED_DTL table");
									sqle.printStackTrace();
								}

								if(rset!=null)
								{
									while(rset.next())
									{
										isRecordFound = rset.getInt("no_of_record");
									}
								}

								if(rset!=null)
									rset.close();
								if(pstmt!=null) 
									pstmt.close();


							if(isRecordFound>0 && result)
							{
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								//sbSql.append(" Update IP_RESERVED_BED_DTL set RESERVED_TO_TIME=sysdate where FACILITY_ID ='"+facilityId+"' and ENCOUNTER_ID = '"+encounter_id+"' and RESERVED_NURSING_UNIT_CODE = '"+frnursingunitcode+"' and  RESERVED_ROOM_NO = '"+frroomno+"' and RESERVED_BED_NO = '"+frbedno+"' and RESERVED_TO_TIME is null ");
								sbSql.append(" Update IP_RESERVED_BED_DTL set RESERVED_TO_TIME=sysdate , MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where FACILITY_ID ='"+facilityId+"' and ENCOUNTER_ID = '"+encounter_id+"' /* and RESERVED_NURSING_UNIT_CODE = '"+frnursingunitcode+"' and  RESERVED_ROOM_NO = '"+frroomno+"' and RESERVED_BED_NO = '"+frbedno+"' */ and RESERVED_TO_TIME is null ");
	
								pstmt = con.prepareStatement( sbSql.toString() );
								reset = pstmt.executeUpdate() ;
								if(pstmt!=null)
									pstmt.close();
								if(reset > 0) 
								{
									result = true; 
								}
								else 
								{
									result = false;
									sb.append("Exception in updation IP_RESERVED_BED_DTL table");
								}							
							}

							if(result)
							{
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());

								sbSql.append(" insert into IP_RESERVED_BED_DTL ");
								sbSql.append(" ( FACILITY_ID , ENCOUNTER_ID , SRL_NO , RESERVED_NURSING_UNIT_CODE , RESERVED_ROOM_NO , RESERVED_BED_NO , RESERVED_BED_CLASS_CODE , RESERVED_BED_TYPE_CODE , RESERVED_BED_TYPE_CODE_DEFN , RESERVED_FROM_TIME , RESERVED_TO_TIME , ADDED_BY_ID , ADDED_DATE , ADDED_AT_WS_NO , ADDED_FACILITY_ID , MODIFIED_BY_ID , MODIFIED_DATE , MODIFIED_AT_WS_NO , MODIFIED_FACILITY_ID ");
								sbSql.append(" ) values ( '"+facilityId+"', '"+encounter_id+"', '"+(srlno-1)+"',");
								
								/*if(confirm_yn.equals("Y"))
								{
									sbSql.append(" '"+reserve_nurs_unit_code+"', '"+reserve_room_no+"', '"+reserve_bed_no+"', '"+reserve_bed_class_code+"', '"+reserve_bed_type_code+"', '"+tobedtype+"' ,");
								}
								else*/
								//{
									sbSql.append(" '"+frnursingunitcode+"', '"+frroomno+"', '"+frbedno+"', '"+frbedclass+"', '"+frbedtype+"', '"+frbedtype+"' ,");
								//}

								sbSql.append(" sysdate, '', '"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+facilityId+"','"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+facilityId+"' ) ");
								
								if(pstmt!=null) 
									pstmt.close();
								pstmt = con.prepareStatement( sbSql.toString() );
								reset = pstmt.executeUpdate() ;
								if(pstmt!=null)
									pstmt.close();

								if(reset > 0) 
								{
									result = true; 
								}
								else 
								{
									result = false;
									sb.append("Exception in insertion IP_RESERVED_BED_DTL table");
								}	
							}
						}
					}
					catch (Exception e)
					{
						result = false;
						sb.append("Exception in insertion IP_RESERVED_BED_DTL table "+e.toString());
						e.printStackTrace();
					}

					try
					{
						if(result)
						{
							/*Friday, April 30, 2010 , commnted for PE and query merged to line no 826*/
							/*
							String str_block_period = "select to_char((sysdate+'"+bed_blk_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual";
							pstmt = con.prepareStatement(str_block_period);
							try
							{
								rset  = pstmt.executeQuery();
							}
							catch(SQLException sqle)
							{
							}
							if(rset!=null)
							{
								while(rset.next())
								{
									blocked_until_date = rset.getString("a");
								}
							}

							if(rset !=null) rset.close(); if(pstmt !=null) pstmt.close();
							*/
							if(blocked_until_date != null || is_reserved_bed_checked.equals("Y"))
							{
								if(is_reserved_bed_checked.equals("Y"))
								{
									//blocked_until_date = "";
									//8698-SRR20056-SCF-2841
									blocked_until_date = exp_discharge_date_time;			/*Monday, September 06, 2010 , SRR20056-SCF-5122 [IN:023593] ,since EDD is less than sysdate then reserved beds not displaying in Release reserved bed function and in BAC*/
									if((DateUtils.isBefore(exp_discharge_date_time, system_date, "DMYHM", "en")))
										blocked_until_date = "";
									
								}
								/*Friday, May 14, 2010 , update for IP_BED_BOOKING_SRL_CTRL to generate NEXT_BOOKING_SRL_NO will be done through IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO at line no 721*/
								/*try
								{
									strBuffer.delete(0, strBuffer.length());
									strBuffer.append("select NEXT_BOOKING_SRL_NO srl_no from "); strBuffer.append("IP_BED_BOOKING_SRL_CTRL	where facility_id = '"+facilityId+"' and BOOKING_TYPE = 'T' ");
									stmt   = con.createStatement();
									srs = stmt.executeQuery(strBuffer.toString());
									if(srs.next())
									{
										bed_srlno = srs.getInt("srl_no");
									}
									if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
									strBuffer.delete(0, strBuffer.length());
									strBuffer.append(" Update IP_BED_BOOKING_SRL_CTRL set "); strBuffer.append("NEXT_BOOKING_SRL_NO = NEXT_BOOKING_SRL_NO+1 ");
									strBuffer.append(" WHERE  facility_id= '"+facilityId+"' and BOOKING_TYPE = 'T' ");
									pstmt = con.prepareStatement( strBuffer.toString());
									pstmt.executeUpdate();
									 if(pstmt !=null) pstmt.close();
								}
								catch(Exception sc)
								{
									result = false;
									sb.append("Exception in updating ip_bed_booking_srl_ctrl :"+sc.toString());
									sc.printStackTrace();
								}*/
								StringBuffer sqlBuffer	= new StringBuffer();
								try
								{

									if(reserve_bed_on_tfr_yn.equals("Y"))
									{

										int No_Of_Record = 0;


										/*sqlBuffer.append("INSERT INTO ip_bed_booking (");									
										sqlBuffer.append("FACILITY_ID, BOOKING_TYPE, BED_BOOKING_REF_NO,  ");
										sqlBuffer.append("BLOCKED_FROM_DATE_TIME, BLOCKED_UNTIL_DATE_TIME,");
										sqlBuffer.append("ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,");
										sqlBuffer.append("MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,");
										sqlBuffer.append("REQ_NURSING_UNIT_CODE, REQ_SERVICE_CODE, REQ_BED_NO, REQ_ROOM_NO,");
										sqlBuffer.append("REQ_BED_CLASS_CODE, REQ_BED_TYPE_CODE, REQ_PRACTITIONER_ID, ");
										sqlBuffer.append("REQ_SPECIALTY_CODE,BOOKED_BY_ID, BOOKING_DATE_TIME, BOOKING_STATUS,BLOCKING_TYPE_CODE,BLOCKING_REMARKS,OVERRIDE_YN) values (");
										sqlBuffer.append("?,?,?,sysdate,to_date(?,'dd/mm/rrrr hh24:mi'),?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?)");*/
										
										/*sqlBuffer.append("SELECT Count(1) No_Of_Record FROM ip_bed_booking WHERE facility_id = ? AND encounter_id = ? AND REQ_BED_NO  = ? and REQ_NURSING_UNIT_CODE = ? AND  BLOCKED_UNTIL_DATE_TIME IS null");

										if(pstmt != null)	pstmt = null;
										pstmt = con.prepareStatement( sqlBuffer.toString() );
										pstmt.setString	( 1, facilityId ) ;
										pstmt.setString	( 2, encounter_id ) ;
										if(confirm_yn.equals("Y"))
										{
											pstmt.setString	( 3, reserve_bed_no ) ;
											pstmt.setString	( 4, reserve_nurs_unit_code ) ;
										}
										else if(confirm_yn.equals("N"))
										{
											pstmt.setString	( 3, frbedno ) ;
											pstmt.setString	( 4, frnursingunitcode ) ;
										}*/

										String counterReserveBed="";
										String counterReserveNursingUnit="";
											
										if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N"))
										{
											counterReserveBed= reserve_bed_no  ;
											counterReserveNursingUnit = reserve_nurs_unit_code  ;
										}
										else if(confirm_yn.equals("Y"))
										{
											counterReserveBed= reserve_bed_no  ;
											counterReserveNursingUnit = reserve_nurs_unit_code  ;
										}
										else if(confirm_yn.equals("N"))
										{
											counterReserveBed = frbedno  ;
											counterReserveNursingUnit = frnursingunitcode  ;
										}

										//sqlBuffer.append("SELECT Count(1) No_Of_Record FROM ip_bed_booking WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounter_id+"' AND REQ_BED_NO  = '"+counterReserveBed+"' and REQ_NURSING_UNIT_CODE = '"+counterReserveNursingUnit+"' AND  BLOCKED_UNTIL_DATE_TIME IS null");


										sqlBuffer.append(" select count(1) no_of_record FROM IP_BED_BOOKING WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounter_id+"' and ( blocked_until_date_time is null OR blocked_until_date_time > SYSDATE ) ");

										try
										{
											if(pstmt != null)	pstmt.close();
											pstmt = con.prepareStatement( sqlBuffer.toString() );
											srs = pstmt.executeQuery() ;
											if(srs!=null && srs.next())
											{
												No_Of_Record = srs.getInt("No_Of_Record");
											}
											if(srs !=null) srs.close();
											if(pstmt !=null) pstmt.close();
										}
										catch(SQLException ex)
										{
											result = false;
											sb.append("Exception in while counter query of ip_bed_booking  :"+ex.toString());
											ex.printStackTrace();
										}
/*Friday, September 03, 2010 , SRR20056-SCF-5138 [IN:023627],&& retain_res_bed.equals("N") added*/
										if(result && No_Of_Record>0 && retain_res_bed.equals("N"))
										{
											String updateReserveBed="";
											String updateNursingUnitCode = "";

											if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("N"))
											{
												updateReserveBed= reserve_bed_no  ;
												updateNursingUnitCode = reserve_nurs_unit_code  ;
											}
											else if(confirm_yn.equals("Y"))
											{
												updateReserveBed = reserve_bed_no ;
												updateNursingUnitCode = reserve_nurs_unit_code;
											}
											else if(confirm_yn.equals("N"))
											{
												updateReserveBed = frbedno  ;
												updateNursingUnitCode = frnursingunitcode;
											}
											if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());

											//sqlBuffer.append("UPDATE ip_bed_booking SET BLOCKED_UNTIL_DATE_TIME  = To_Date('"+system_date+"','dd/mm/yyyy hh24:mi') WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounter_id+"' AND REQ_BED_NO  = '"+updateReserveBed+"' and REQ_NURSING_UNIT_CODE = '"+updateNursingUnitCode+"' and BLOCKED_UNTIL_DATE_TIME IS null");	

											res = 0;
											int updated = 0;
											try
											{

												res = 0;
												if(pstmt != null)	pstmt.close();
			
												PreparedStatement bookingPstmt = null;
												//bookingCon = ConnectionManager.getConnection(p);
												/*Added Audit column*/
												bookingPstmt  = con.prepareStatement(" UPDATE ip_bed_booking SET BLOCKED_UNTIL_DATE_TIME  = To_Date('"+system_date+"','dd/mm/yyyy hh24:mi'), MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounter_id+"' and ( blocked_until_date_time is null OR blocked_until_date_time > SYSDATE )");

												updated = bookingPstmt.executeUpdate();
												result = (updated > 0) ? true : false;
												if(bookingPstmt != null) bookingPstmt.close();
											}									
											catch(SQLException ex)
											{
												result = false;
												
												sb.append("Exception in while updation of IP_BED_BOOKING  :"+ex.toString());
												ex.printStackTrace();
											}

											
											/*if(res>0)
											{
												//temporary code
												if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
												sqlBuffer.append("SELECT To_Char(BLOCKED_UNTIL_DA TE_TIME,'dd/mm/yyyy hh:mm') BLOCKED_UNTIL_DATE_TIME FROM ip_bed_booking WHERE  facility_id = '"+facilityId+"' AND encounter_id = '"+encounter_id+"' AND REQ_BED_NO  = '"+updateReserveBed+"' and REQ_NURSING_UNIT_CODE = '"+updateNursingUnitCode+"' ");	
												if(pstmt != null)	pstmt.close();
												pstmt = con.prepareStatement( sqlBuffer.toString() );
												srs = pstmt.executeQuery() ;

												while(srs!=null && srs.next())
												{
													String BLOCKED_UNTIL_DATE_TIME_test= srs.getString("BLOCKED_UNTIL_DATE_TIME");

												}
												if(srs !=null) srs.close();
												if(pstmt !=null) pstmt.close();										

											}*/
										}
									}
/*Friday, September 03, 2010 , SRR20056-SCF-5138 [IN:023627],&& retain_res_bed.equals("N") added*/
									if(result && retain_res_bed.equals("N"))
									{								
											if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
											sqlBuffer.append("INSERT INTO ip_bed_booking (");									
											sqlBuffer.append("FACILITY_ID, BOOKING_TYPE, BED_BOOKING_REF_NO,  ");
											sqlBuffer.append("BLOCKED_FROM_DATE_TIME, BLOCKED_UNTIL_DATE_TIME,");
											sqlBuffer.append("ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,");
											sqlBuffer.append("MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,");
											sqlBuffer.append("REQ_NURSING_UNIT_CODE, REQ_SERVICE_CODE, REQ_BED_NO, REQ_ROOM_NO,");
											sqlBuffer.append("REQ_BED_CLASS_CODE, REQ_BED_TYPE_CODE, REQ_PRACTITIONER_ID, ");
											sqlBuffer.append("REQ_SPECIALTY_CODE,BOOKED_BY_ID, BOOKING_DATE_TIME, BOOKING_STATUS,BLOCKING_TYPE_CODE,BLOCKING_REMARKS,OVERRIDE_YN ");
											//if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
												sqlBuffer.append(", PATIENT_ID,ENCOUNTER_ID ");									
											sqlBuffer.append(" ) values (");
											sqlBuffer.append("?,?,?,sysdate,to_date(?,'dd/mm/rrrr hh24:mi'),?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?");
											//if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
												sqlBuffer.append(",?,? ");								
											sqlBuffer.append(")");
											
											if(pstmt != null)	pstmt = null;
											pstmt = con.prepareStatement( sqlBuffer.toString() );
											pstmt.setString	( 1, facilityId ) ;
											if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
												pstmt.setString	( 2, "N" ) ;
											else
												pstmt.setString	( 2, "T" ) ;
											pstmt.setInt	( 3, bed_srlno);
											pstmt.setString	( 4, blocked_until_date);
											pstmt.setString	( 5, addedById);
											pstmt.setString	( 6, addedAtWorkstation);
											pstmt.setString	( 7, facilityId);
											pstmt.setString	( 8, addedById);
											pstmt.setString	( 9, addedAtWorkstation);
											pstmt.setString	( 10, facilityId);
											if(confirm_yn.equals("Y"))
											{
												pstmt.setString	( 11, reserve_nurs_unit_code);
												pstmt.setString	( 12, reserve_service_code);
												pstmt.setString	( 13, reserve_bed_no);
												pstmt.setString	( 14, reserve_room_no);
												pstmt.setString	( 15, reserve_bed_class_code);
												pstmt.setString	( 16, reserve_bed_type_code);
												pstmt.setString	( 17, reserve_practitioner_id);
												pstmt.setString	( 18, reserve_specialty_code);
											}
											else
											{
												pstmt.setString	( 11, frnursingunitcode);
												pstmt.setString	( 12, frservicecode);
												pstmt.setString	( 13, frbedno);
												pstmt.setString	( 14, frroomno);
												pstmt.setString	( 15, frbedclass);
												pstmt.setString	( 16, frbedtype);
												pstmt.setString	( 17, frpractitionerid);
												pstmt.setString	( 18, frspecialitycode);

											}
											pstmt.setString	( 19, addedById);
											if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
												pstmt.setString	( 20, "1");
											else
												pstmt.setString	( 20, "0");
											//pstmt.setString	( 21, blocking_type_code);
											if((reason_for_reserved_bed==null || reason_for_reserved_bed.equals("")))
												pstmt.setString	( 21, blocking_type_code);
											else
												pstmt.setString	( 21, reason_for_reserved_bed);
											if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
												pstmt.setString	( 22, "");
											else
												pstmt.setString	( 22, blk_remark);
											if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
												pstmt.setString	( 23, "N");
											else
												pstmt.setString	( 23, override_yn);
											
											//if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y"))
											//{
												pstmt.setString	( 24, patientid);
												pstmt.setString	( 25, encounter_id);
											//}
							
											res = 0;
											try
											{
												res = pstmt.executeUpdate() ;
												if(pstmt !=null) pstmt.close();
											}
											catch(SQLException ex)
											{
												result = false;
												sb.append("Exception in while INSERT INTO ip_bed_booking  :"+ex.toString());
												ex.printStackTrace();
											}
											result = (res >0) ? true : false;	
									}
																	
									}
									catch(Exception se)
									{
										result = false;
										sb.append("Exception in updating ip_bed_booking :"+se.toString());
										se.printStackTrace();
									}
							
								}
								
								
								if((blocked_until_date == null || blocked_until_date.equals("")) && is_reserved_bed_checked.equals("N"))
								{
				
									StringBuffer sqlBuffer	= new StringBuffer();

									if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
									sqlBuffer.append("select Count(*) Total_Record FROM ip_bed_booking WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND booking_type='N'  AND REQ_NURSING_UNIT_CODE= '"+reserve_nurs_unit_code+"' AND REQ_BED_NO= '"+reserve_bed_no+"' and ( blocked_until_date_time is null OR blocked_until_date_time > SYSDATE ) ");

									int No_Of_Record = 0;
									try
										{
											if(pstmt != null)	pstmt.close();
												pstmt = con.prepareStatement( sqlBuffer.toString() );
												srs = pstmt.executeQuery() ;
											if(srs!=null && srs.next())
											{
												No_Of_Record = srs.getInt("Total_Record");
											}
											if(srs !=null) srs.close();
											if(pstmt !=null) pstmt.close();

											
										}
										catch(SQLException ex)
										{
											result = false;
											sb.append("Exception in while counter query of second ip_bed_booking  :"+ex.toString());
											ex.printStackTrace();
										}

										if(result && No_Of_Record>0)
										{
											if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
											/*Added Audit column*/
												sqlBuffer.append("update ip_bed_booking SET booking_type='T' ,BLOCKED_UNTIL_DATE_TIME = sysdate, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND REQ_NURSING_UNIT_CODE= '"+reserve_nurs_unit_code+"' AND REQ_BED_NO= '"+reserve_bed_no+"' and ( blocked_until_date_time is null OR blocked_until_date_time > SYSDATE ) ");

													try
													{
														if(pstmt != null)	pstmt.close();
														pstmt = con.prepareStatement( sqlBuffer.toString() );
														int updated = pstmt.executeUpdate();
														result = (updated > 0) ? true : false;	
														if(pstmt !=null) pstmt.close();
						
													}
													catch (SQLException ex)
													{
														result = false;
														sb.append("Exception in while updating  ip_bed_booking query :"+ex.toString());
														ex.printStackTrace();
				
													}
												if(result)
												{
													if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
													sqlBuffer.append("select Count(*) Total_Record FROM IP_RESERVED_BED_DTL WHERE FACILITY_ID = '"+facilityId+"' AND  ENCOUNTER_ID  = '"+encounter_id+"' and RESERVED_NURSING_UNIT_CODE = '"+reserve_nurs_unit_code+"' AND RESERVED_BED_NO = '"+reserve_bed_no+"' AND  RESERVED_TO_TIME  IS null");
													
													int Reserve_Bed_No_Of_Record = 0;
													try
														{
															if(pstmt != null)	pstmt.close();
																pstmt = con.prepareStatement( sqlBuffer.toString() );
																srs = pstmt.executeQuery() ;
															if(srs!=null && srs.next())
															{
																Reserve_Bed_No_Of_Record = srs.getInt("Total_Record");
															}
															if(srs !=null) srs.close();
															if(pstmt !=null) pstmt.close();

															
														}
														catch(SQLException ex)
														{
															result = false;
															sb.append("Exception in while counter query of second IP_RESERVED_BED_DTL  :"+ex.toString());
															ex.printStackTrace();
														}

														
														if(result && Reserve_Bed_No_Of_Record>0)
														{
															if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
															/*Added Audit column*/
															sqlBuffer.append("UPDATE IP_RESERVED_BED_DTL SET   RESERVED_TO_TIME  = SYSDATE, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE FACILITY_ID = '"+facilityId+"' AND  ENCOUNTER_ID  = '"+encounter_id+"' and  RESERVED_NURSING_UNIT_CODE = '"+reserve_nurs_unit_code+"' AND RESERVED_BED_NO = '"+reserve_bed_no+"' AND  RESERVED_TO_TIME  IS null");

														try
														{
															if(pstmt != null)	pstmt.close();
															pstmt = con.prepareStatement( sqlBuffer.toString() );
															int updated = pstmt.executeUpdate();
															result = (updated > 0) ? true : false;	
															if(pstmt !=null) pstmt.close();
							
														}
														catch (SQLException ex)
														{
															result = false;
															sb.append("Exception in while updating  IP_RESERVED_BED_DTL query :"+ex.toString());
															ex.printStackTrace();
					
														}

													}
												}												
											
										}
								}
							}
/*Monday, August 16, 2010 , modified for SRR20056-SCF-4961 [IN:023143] , to close blocked status(if any) of selected to_bed.*/						
						if(result)
						{
							if(overrideYN.equals("Y") && !(booking_type.equals("L")|| booking_type.equals("N")))
							{
								try
								{
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append("update ip_bed_booking set booking_status = ? , cancelled_by_id = ?,  cancellation_date_time = sysdate, modified_by_id=?, modified_date = sysdate,  modified_at_ws_no= ?,  modified_facility_id =?   where facility_id = ? and booking_type = ? and req_nursing_unit_code = ? and req_bed_no = ? and req_room_no = ? and booking_status='0' and sysdate between blocked_from_date_time and blocked_until_date_time ");

									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setString	( 1, "9");
									pstmt.setString	( 2, addedById);
									pstmt.setString	( 3, addedById);
									pstmt.setString	( 4, addedAtWorkstation);
									pstmt.setString	( 5, facilityId);
									pstmt.setString	( 6, facilityId);
									pstmt.setString	( 7, booking_type);
									pstmt.setString	( 8, tonursingunitcode);
									pstmt.setString	( 9, tobedno);
									pstmt.setString	( 10, toroomno);
									pstmt.executeUpdate() ;
									if(pstmt !=null) pstmt.close();
								}
								catch (Exception ep)
								{
									result = false;
									ep.printStackTrace();
								}
							}
						}
/**/
						if(result)
						{
							if(!frnursingunitcode.equals(tonursingunitcode))
							{
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								//Added Audit column
								sbSql.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied +1, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"'" );
								sbSql.append(" where facility_id = ? and nursing_unit_code = ? ");
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString	( 1, facilityId);
								pstmt.setString	( 2, tonursingunitcode ) ;
								pstmt.executeUpdate() ;
								 if(pstmt !=null) pstmt.close();
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								//Added Audit column
								sbSql.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied -1, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"'" );
								sbSql.append(" where facility_id = ? and nursing_unit_code = ? ");
								pstmt = con.prepareStatement(sbSql.toString());

								pstmt.setString	( 1, facilityId);
								pstmt.setString	( 2, frnursingunitcode ) ;
								pstmt.executeUpdate() ;
								 if(pstmt !=null) pstmt.close();
							}
						}
					}
				catch(Exception e)
				{
					result = false;
					 sb.append("Exception in updating ip_nursing_unit table "+e.toString());
					 e.printStackTrace();
				}
				try
				{
					int L_male_count = 0;
					int L_female_count = 0;
					int L_unknown_count = 0;
					if(patientgender.equals("M")) L_male_count = 1;
					if(patientgender.equals("F")) L_female_count = 1;
					if(patientgender.equals("U")) L_unknown_count = 1;
					if(result)
					{
						if(!frroomno.equals(toroomno))
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							//Added Audit column
							sbSql.append(" update ip_nursing_unit_room set ");
							sbSql.append(" occ_male_bed_count = occ_male_bed_count+?, occ_female_bed_count = occ_female_bed_count+?, ");
							sbSql.append(" occ_unknown_bed_count = occ_unknown_bed_count+?, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"'");
							sbSql.append(" where facility_id=? and nursing_unit_code = ? and room_no = ? ");
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setInt( 1, L_male_count ) ;
							pstmt.setInt( 2, L_female_count);
							pstmt.setInt( 3, L_unknown_count);
							pstmt.setString	( 4, facilityId);
							pstmt.setString	( 5, tonursingunitcode ) ;
							pstmt.setString	( 6, toroomno ) ;
							pstmt.executeUpdate() ;
							if(pstmt !=null) pstmt.close();
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							//Added Audit column
							sbSql.append(" update ip_nursing_unit_room set ");
							sbSql.append(" occ_male_bed_count = occ_male_bed_count-?, occ_female_bed_count = occ_female_bed_count-?, ");
							sbSql.append(" occ_unknown_bed_count = occ_unknown_bed_count-?, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"'");
							sbSql.append(" where facility_id=? and nursing_unit_code = ? and room_no = ? ");
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setInt			( 1, L_male_count ) ;
							pstmt.setInt			( 2, L_female_count);
							pstmt.setInt			( 3, L_unknown_count);
							pstmt.setString	( 4, facilityId);
							pstmt.setString	( 5, frnursingunitcode ) ;
							pstmt.setString	( 6, frroomno ) ;
							pstmt.executeUpdate() ;
							if(pstmt !=null) pstmt.close();
						}
					}
				}
				catch(Exception e)
				{
					result = false;
					 sb.append("Exception in updating ip_nursing_unit_room table "+e.toString());
					 e.printStackTrace();
				}
				try
				{
					if(result)
					{
						if((!frnursingunitcode.equals(tonursingunitcode)) || (!frbedno.equals(tobedno)))
						{
							String psedo_bed_staus		="";
							if (!(frbedno.equals("") || frbedno == null ))
							{
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append(" select  psuedo_bed_status from ip_nursing_unit_bed where facility_id = '"+facilityId+"' and nursing_unit_code = '"+frnursingunitcode+"' and bed_no = '"+frbedno+"' ");
								stmt=con.createStatement();
								srs = stmt.executeQuery(sbSql.toString());
								if(srs.next())
								{
									psedo_bed_staus = srs.getString("psuedo_bed_status") == null ? "" : srs.getString("psuedo_bed_status") ;
								}
								if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
							}

						int res4 = 0;
						try
						{
							//logic to link the baby back to the mother as part of the CRF - HSA-CRF-0035
							
							if(mother_bed_status.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
								//Logic to retrieve number of babies linked with the mother as part of HSA-CRF-0035
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								
								sbSql.append("SELECT OCCUPYING_PATIENT_ID FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND mothers_patient_id = ?");
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString	( 1, facilityId ) ;
								pstmt.setString	( 2, frnursingunitcode);
								pstmt.setString	( 3, patientid) ;
								srs = pstmt.executeQuery();
								while(srs.next())
								{
									babyPatientId.add(srs.getString("OCCUPYING_PATIENT_ID"));
									babyCount++;
								}
								if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();
								
								//for the babies linked with the mother, bed should be assigned. 
								//Step 1 - Retrieve Bed no from ip_nursing_unit_bed table
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								/*sbSql.append("SELECT bed_no FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND main_bed_no = ? AND current_status = 'A' and rownum <= ?");*/
								
								/*Above line commented and below line added for this SCF ML-MMOH-SCF-0663*/
								sbSql.append("SELECT bed_no FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND main_bed_no = ? AND current_status = 'A' order by bed_no asc");
								
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString	( 1, facilityId ) ;
								pstmt.setString	( 2, tonursingunitcode);
								pstmt.setString	( 3, tobedno) ;
								//pstmt.setInt	( 4, babyCount) ;  //Commented for this SCF ML-MMOH-SCF-0663
								srs = pstmt.executeQuery();
								//Below line modified for this SCF ML-MMOH-SCF-0663
								while(srs.next() && transferBabyCount<babyCount)
								{
								    //Below line added for this SCF ML-MMOH-SCF-0663	
									babyBedNo.add(srs.getString("bed_no")) ;
									transferBabyCount++;
								    //End this ML-MMOH-SCF-0663
								}
								
								if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();
																								
								
							}
							
							//updating mother bed in the source nursing unit to null
							sbSql.delete(0,sbSql.length());
							sbSql.append(" update ip_nursing_unit_bed set ");
							sbSql.append("occupying_patient_id = ? ");
							sbSql.append(", occupied_until_date_time = ? ");	
							sbSql.append(", current_status = 'A', modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ?");
							if(psedo_bed_staus.equals("U"))
							sbSql.append(", psuedo_bed_status = 'C'");
							sbSql.append(" where facility_id = ? and nursing_unit_code = ? and"); 
							sbSql.append(" bed_no = ? ");
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, null ) ;
							pstmt.setString	( 2, null ) ;
							pstmt.setString	( 3, facilityId);
							pstmt.setString	( 4, addedById) ;
							pstmt.setString	( 5, addedAtWorkstation) ;
							pstmt.setString	( 6, facilityId);		
							pstmt.setString	( 7, frnursingunitcode ) ;
							pstmt.setString	( 8, frbedno ) ;
							int rres4 = pstmt.executeUpdate() ;
							if(rres4>0 )  result = true; else result = false;
							if(pstmt!=null)pstmt.close();
							if(mother_bed_status.equals("Y") && result)
							{  
								rres4=0;
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append(" update ip_nursing_unit_bed set ");
								sbSql.append(" occupying_patient_id = ?, occupied_until_date_time = ?, mothers_patient_id = ?, mothers_encounter_id = ?, current_status = 'A', modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
								if(psedo_bed_staus.equals("U"))
								sbSql.append(", psuedo_bed_status = 'C'");
								sbSql.append(" where facility_id=? and nursing_unit_code = ? and main_bed_no = ?");
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString	( 1, null ) ;
								pstmt.setString	( 2, null ) ;
								pstmt.setString	( 3, null ) ;
								pstmt.setString	( 4, null ) ;
								pstmt.setString	( 5, facilityId);
								pstmt.setString	( 6, addedById) ;
								pstmt.setString	( 7, addedAtWorkstation) ;
								pstmt.setString	( 8, facilityId);		
								pstmt.setString	( 9, frnursingunitcode ) ;
								pstmt.setString	( 10, frbedno ) ;
								rres4 = pstmt.executeUpdate() ;
								if(rres4>0 )  result = true; else result = false;
								if(pstmt!=null)pstmt.close();
							}
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							/*
							sbSql.append(" update ip_nursing_unit_bed set ");
							sbSql.append(" occupying_patient_id = ?, current_status = 'O'");
							//Updating audit columns:
							sbSql.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
							
							if(deactivate_pseudo_bed_yn.equals("Y") && pseudo_bed_yn.equals("Y"))
							sbSql.append(", psuedo_bed_status = 'U'");
							sbSql.append(" where  facility_id = ? and nursing_unit_code = ? and bed_no = ? ");
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, patientid ) ;
							pstmt.setString	( 2, facilityId);
							pstmt.setString	( 3, addedById) ;
							pstmt.setString	( 4, addedAtWorkstation) ;
							
							pstmt.setString	( 5, facilityId);
							pstmt.setString	( 6, tonursingunitcode ) ;
							pstmt.setString	( 7, tobedno ) ;
							res4 = pstmt.executeUpdate() ;
							if(pstmt !=null) pstmt.close();
							*/
						}
						catch(Exception e)
						{
							result = false;
							sb.append("Exception in updating ip_nursing_unit_bed while clearing the old bed no "+e.toString());
							e.printStackTrace();
						}

						try
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append(" update ip_nursing_unit_bed set ");
							sbSql.append(" occupying_patient_id = ?, current_status = 'O'");
							//Updating audit columns:
							sbSql.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
							
							if(deactivate_pseudo_bed_yn.equals("Y") && pseudo_bed_yn.equals("Y"))
								sbSql.append(", psuedo_bed_status = 'U'");
							sbSql.append(" where  facility_id = ? and nursing_unit_code = ? and bed_no = ? and occupying_patient_id is null and current_status='A' ");
							pstmt = con.prepareStatement(sbSql.toString());

							pstmt.setString	( 1, patientid ) ;
							pstmt.setString	( 2, facilityId);
							pstmt.setString	( 3, addedById) ;
							pstmt.setString	( 4, addedAtWorkstation) ;
							
							pstmt.setString	( 5, facilityId);
							pstmt.setString	( 6, tonursingunitcode ) ;
							pstmt.setString	( 7, tobedno ) ;
							res4 = pstmt.executeUpdate() ; 
							if(res4>0 )  {
								result = true; 
							}else { 
								result = false;	
								java.util.Hashtable message = MessageManager.getMessage( locale, "OCCUPIED_BED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
							if(pstmt !=null) pstmt.close();
							
							//logic to update the destination baby beds for the crf - HSA-CRF-0035
							if(mother_bed_status.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
							try{
								for(int bcount=0;bcount<babyPatientId.size();bcount++){
									
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									
									sbSql.append(" update ip_nursing_unit_bed set ");
								    sbSql.append(" mothers_patient_id=?,mothers_encounter_id=?,current_status='O',occupying_patient_id = ?,modified_date=sysdate,modified_facility_id=?,modified_by_id=?,modified_at_ws_no=? ");
									sbSql.append(" where facility_id=? and nursing_unit_code =?  and main_bed_no=? and bed_no=?");
									
									pstmt=con.prepareStatement(sbSql.toString());
									
									pstmt.setString	( 1, patientid); //Mother Patient id
									pstmt.setString	( 2, strEncid); // Mother Encounter id
									pstmt.setString	( 3, babyPatientId.get(bcount)); // Baby Patient Id
									pstmt.setString	( 4, facilityId);
									pstmt.setString	( 5, addedById) ;
									pstmt.setString	( 6, addedAtWorkstation);
									pstmt.setString	( 7, facilityId);
									pstmt.setString	( 8, tonursingunitcode);//Mother Nursing nuit
									pstmt.setString	( 9, tobedno);  //Mother bed no
									pstmt.setString	( 10, babyBedNo.get(bcount));  //Baby bed no
									res4 = pstmt.executeUpdate() ;
									if(pstmt !=null) pstmt.close();
									if(res4 > 0) result = true; else result = false;
								}
							}catch(Exception ex){
								sb.append("Exception in updating ip_nursing_unit_bed while updating the destination baby beds : "+ex.toString());
								ex.printStackTrace();
							}
							
							}
							//Logic to relink the mother and the baby bed for the crf HSA-CRF-0035
							if(mother_bed_status.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							
							try{
							sbSql.append(" update ip_open_encounter set ");
							sbSql.append("BABY_DELINKED_YN='N' ");
							sbSql.append(", modified_by_id = ? ,modified_at_ws_no = ?, modified_date = sysdate,modified_facility_id = ? ");
							sbSql.append(" where facility_id=? and ENCOUNTER_ID = ?");
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, addedById) ;
							pstmt.setString	( 2, addedAtWorkstation);
							pstmt.setString	( 3, facilityId);
							pstmt.setString	( 4, facilityId);
							pstmt.setString	( 5, strEncid); //mother encounter id
							res4 = pstmt.executeUpdate() ;
							if(pstmt !=null) pstmt.close();
							if(res4 > 0) result = true; else result = false;
							
							}catch(Exception ex){
								sb.append("Exception in updating ip_open_encounter while relinking the mother and baby bed : "+ex.toString());
								ex.printStackTrace();
							}
							}
						}
						catch(Exception e)
						{
							result = false;
							sb.append("Exception in updating ip_nursing_unit_bed while occupying the new bed "+e.toString());
							e.printStackTrace();
						}
						}
					}
				}
				catch(Exception e)
				{
					result = false;
					sb.append("Exception in updating ip_nursing_unit_bed table "+e.toString());
					e.printStackTrace();
				}

				try
				{
					if (result && (!(frnursingunitcode.equals(tonursingunitcode))))
					{
						String to_fs_locn_code="";
						String to_locn_identity="";
						String narration="";
						String narration_desc="";
						String recd_userid="";
						String ret_date="";
						String curr_file_status="";
						if (auto_rec_ward_yn.equals("Y"))
							curr_file_status="O";
						else
							curr_file_status="T";
						if (fm_install_yn.equals("Y")&&transfter_file_yn.equals("Y")
						&&auto_file_transfer_yn.equals("Y")&&fm_fs_locn_code!="")
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append("select a.fs_locn_code, b.locn_identity, b.holder_name, to_char(sysdate + no_of_days_to_return,'dd/mm/rrrr hh24:mi') from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id = ? and a.nursing_unit_code = ? ");
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, facilityId ) ;
							pstmt.setString	( 2, tonursingunitcode ) ;
							srs = pstmt.executeQuery() ;
							if (srs!=null && srs.next())
							{
								to_fs_locn_code  = srs.getString(1);
								to_locn_identity = srs.getString(2);
								recd_userid		 = srs.getString(3);
								ret_date		 = srs.getString(4);
							}
							if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();
							if(recd_userid==null) recd_userid="";
							if(ret_date==null)	  ret_date="";
							if (to_fs_locn_code!="")
							{
								if (file_no!="")
								{
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append("select a.narration_code, b.short_desc from fm_storage_locn a, FM_NARRATION_LANG_VW b where a.narration_code = b.narration_code and b.language_id='"+locale+"' and a.facility_id = ? and a.fs_locn_code = ? ");
									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setString	( 1, facilityId ) ;
									pstmt.setString	( 2, fm_fs_locn_code) ;
									srs = pstmt.executeQuery() ;
									if (srs!=null && srs.next())
									{
										narration		= srs.getString(1);
										narration_desc	= srs.getString(2);
										if (narration==null) narration="";
										if (narration_desc==null) narration_desc="";
									}
									if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									sbSql.append("insert into fm_movement_log(facility_id, file_no, sent_date_time, patient_id, src_facility_id, src_fs_locn_code, src_locn_identity, src_user_id, dest_facility_id, rec_date_time, dest_fs_locn_code, dest_locn_identity, dest_user_id, narration_code, movement_narration, movement_type, src_mr_locn_yn, dest_mr_locn_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?,?,sysdate,?,?,?,?,?,?,sysdate,?,?,?,?,?,'F','N','N',?,sysdate,?,?,?,sysdate,?,?)");
									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setString	( 1, facilityId) ;
									pstmt.setString	( 2, file_no);
									pstmt.setString	( 3, patientid) ;
									pstmt.setString	( 4, facilityId) ;
									pstmt.setString	( 5, fm_fs_locn_code) ;
									pstmt.setString	( 6, fm_locn_identity) ;
									pstmt.setString	( 7, addedById) ;
									pstmt.setString	( 8, facilityId) ;
									pstmt.setString	( 9, to_fs_locn_code) ;
									pstmt.setString	( 10, to_locn_identity) ;
									pstmt.setString	( 11, addedById) ;
									pstmt.setString	( 12, narration) ;
									pstmt.setString	( 13, narration_desc) ;
									pstmt.setString	( 14, addedById) ;
									pstmt.setString	( 15, addedAtWorkstation) ;
									pstmt.setString	( 16, facilityId) ;
									pstmt.setString	( 17, addedById) ;
									pstmt.setString	( 18, addedAtWorkstation) ;
									pstmt.setString	( 19, facilityId) ;
									res = pstmt.executeUpdate() ;
									if(res>0 )  result = true; else result = false;	
									 if(pstmt !=null) pstmt.close();
									 /*Below line added for this  HSA-CRF-0306.1*/
			                       boolean siteSpecific=CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");
									if (result && !siteSpecific)
									{
										if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
										sbSql.append("update fm_curr_locn set iss_date_time=sysdate,curr_facility_id =?,curr_file_status=?,curr_fs_locn_code=?,curr_fs_locn_identity=?,curr_holder_user_id=?,last_movement_date_time=sysdate,return_date_time=to_date(?,'dd/mm/rrrr hh24:mi'),");
										if (!(curr_file_status.equals("T")))
											sbSql.append("prev_facility_id=?,prev_fs_locn_code=?,");
										sbSql.append("mr_locn_yn='Y', modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id = ? where facility_id = ? and file_no =?");
										pstmt = con.prepareStatement(sbSql.toString());
										int inc=1;
										pstmt.setString	( inc++,  facilityId) ;
										pstmt.setString	( inc++,  curr_file_status);
										if (curr_file_status.equals("T"))
											pstmt.setString	( inc++,  fm_fs_locn_code) ;
										else
											pstmt.setString	( inc++,  to_fs_locn_code) ;
										pstmt.setString	( inc++,  to_locn_identity) ;
										pstmt.setString	( inc++,  recd_userid) ;
										pstmt.setString	( inc++,  ret_date) ;
										if (!(curr_file_status.equals("T")))
										{
											pstmt.setString	( inc++,  facilityId) ;
											pstmt.setString	( inc++,  fm_fs_locn_code) ;
										}
										pstmt.setString	( inc++, addedById) ;
										pstmt.setString	( inc++, addedAtWorkstation) ;
										pstmt.setString	( inc++, facilityId) ;
										pstmt.setString	( inc++, facilityId) ;
										pstmt.setString	( inc++, file_no) ;
										res = pstmt.executeUpdate() ;
										if(res>0 )  result = true; else result = false;	
										if(pstmt !=null) pstmt.close();
									}
									if (result&&curr_file_status.equals("T"))
									{
										if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
										sbSql.append("insert into fm_transit_file(facility_id, file_no, patient_id, sent_date_time, src_facility_id, src_fs_locn_code, src_locn_identity, dest_facility_id, dest_fs_locn_code, dest_locn_identity, added_by_id, added_date, added_at_ws_no, added_facility_id) values(?,?,?,sysdate,?,?,?,?,?,?,?,sysdate,?,?)");
										pstmt = con.prepareStatement(sbSql.toString());
										int inc=1;
										pstmt.setString	( inc++,  facilityId) ;
										pstmt.setString	( inc++,  file_no);
										pstmt.setString	( inc++,  patientid) ;
										pstmt.setString	( inc++,  facilityId) ;
										pstmt.setString	( inc++,  fm_fs_locn_code) ;
										pstmt.setString	( inc++,  fm_locn_identity) ;
										pstmt.setString	( inc++,  facilityId) ;
										pstmt.setString	( inc++,  to_fs_locn_code) ;
										pstmt.setString	( inc++,  to_locn_identity) ;
										pstmt.setString	( inc++,  addedById) ;
										pstmt.setString	( inc++,  addedAtWorkstation) ;
										pstmt.setString	( inc++,  facilityId) ;
										res = pstmt.executeUpdate() ;
										if(res>0 )  result = true; else result = false;	
										 if(pstmt !=null) pstmt.close();
									}
								}
							}
						}
					}
				}
				catch(Exception e)
				{
					result = false;
					 sb.append("Exception in updating FM details "+e.toString());
					 e.printStackTrace();
				}
					// MOD#02	Commented out the billing portion
					// MOD#06 Introduced billing logic
					try
					{
						if (bl_operational.equals("Y"))
						{
							boolBLInstall = true;
						}
						else
						{
							boolBLInstall = false;
						}
						
					}
					catch(Exception exceptionBL)
					{
						sb.append("Error in selecting BLInstall "+exceptionBL.toString());
						exceptionBL.printStackTrace();
					}

					if (boolBLInstall && result)
					{
						try
						{
							Hashtable hashtableBill = new Hashtable();
							hashtableBill.put("facilityId",facilityId);
							hashtableBill.put("patientid",patientid);
							hashtableBill.put("transferdate",transferdate);
							hashtableBill.put("transfertype",transfertype);
							hashtableBill.put("topractitionerid",topractitionerid);
							hashtableBill.put("tospecialitycode",tospecialitycode);
							hashtableBill.put("tobedclass",tobedclass);
							//hashtableBill.put("tobedtype",tobedtype);
							hashtableBill.put("tobedtype",modified_bed_type_code);
							hashtableBill.put("tonursingunitcode",tonursingunitcode);
							hashtableBill.put("toservicecode",toservicecode);
							hashtableBill.put("tosubservcode",tosubservcode);
							hashtableBill.put("tobedno",tobedno);
							hashtableBill.put("toroomno",toroomno);
							hashtableBill.put("frpractitionerid",frpractitionerid);
							hashtableBill.put("frspecialitycode",frspecialitycode);
							hashtableBill.put("frbedclass",frbedclass);
							hashtableBill.put("frnursingunitcode",frnursingunitcode);
							hashtableBill.put("frservicecode",frservicecode);
							hashtableBill.put("frsubservcode",frsubservcode);
							hashtableBill.put("frbedno",frbedno);
							hashtableBill.put("frroomno",frroomno);
							//hashtableBill.put("frbedtype",frbedtype);
							hashtableBill.put("frbedtype",fr_bed_type_code);
							hashtableBill.put("frbedtypedefn",fr_bed_type_code_by_defn);
							hashtableBill.put("addedAtWorkstation",addedAtWorkstation);
							hashtableBill.put("bl_interface_yn",bl_interface_yn);
							hashtableBill.put("encounter_id",encounter_id);
							hashtableBill.put("frteamid",frteamid);
							hashtableBill.put("toteamid",toteamid);
							hashtableBill.put("addedById",addedById);
							hashtableBill.put("episode_id",episode_id);
							hashtableBill.put("srlno",srlno+"");
							hashtableBill.put("episode_type",patient_class);
							hashtableBill.put("module_id",patient_class);
							// If billing installed called this method
							BLIPTransfer blipTransfer	= new BLIPTransfer();
							Hashtable resultsBL			= blipTransfer.billPatientService(p, con,hashtableBill);
							boolean boolRes				= ((Boolean)(resultsBL.get("status"))).booleanValue();
							result						= boolRes;
							strBLMessage				= "";
							if (boolRes == false)
							{
								result  = false;
								sb.append((String)resultsBL.get("error"));
							}
							if (boolRes == true)
							{
								result				= true;
								strBLMessage		= (String) resultsBL.get("message");
								strBLSpecialMessage = (String) resultsBL.get("bl_special_message");

								if (strBLSpecialMessage == null)
								{
										strBLSpecialMessage = " ";
								}
							}
						}
						catch(Exception exceptionBL)
						{
							sb.append("Error in blipTransfer "+exceptionBL.toString());
							exceptionBL.printStackTrace();
							result =  false;
						}
					}

					/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/
						if(result && !reqRadioBtn.equals(""))
						{
							res = 0;
							try
							{  
								int confBedClsSrlNo = 0;
								if(pstmt != null) pstmt.close();
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append("select nvl(MAX(srl_no),0)+1 srl_no from ip_confirm_bed_cls where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");
								
								pstmt	= con.prepareStatement(sbSql.toString());
								srs		= pstmt.executeQuery();
								
								if(srs.next()){
									confBedClsSrlNo = srs.getInt("srl_no");
								}
								
								String trnDateTime = "";
								if(pstmt != null) pstmt.close();
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append("select to_char(trn_date_time,'dd/mm/rrrr hh24:mi:ss') trn_date_time from ip_adt_trn where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' and srl_no = '"+srlno+"' ");
								
								pstmt	= con.prepareStatement(sbSql.toString());
								srs		= pstmt.executeQuery();
								
								if(srs.next()){
									trnDateTime = srs.getString("trn_date_time");
								}

								if(pstmt != null) pstmt.close();
								if(srs != null) srs.close(); //Added for checkstyle
								int insRes = 0;
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								
								sbSql.append("  insert into ip_confirm_bed_cls ");
								sbSql.append(" (facility_id, encounter_id, srl_no, patient_id, trn_type, bl_charging_req_type ");
								sbSql.append(" , ip_adt_trn_srl_no, fr_nursing_unit_code, fr_bed_class_code, fr_room_no, fr_bed_no ");
								sbSql.append(" , fr_practitioner_id, fr_specialty_code, to_nursing_unit_code, to_bed_class_code, to_room_no, to_bed_no");
								sbSql.append(" , to_practitioner_id, to_specialty_code, confirmed_date_time, confirmed_by_id " );
								sbSql.append(" , added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:mi:ss'), ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?)" );
								
								int i = 1;
								
								pstmt = con.prepareStatement( sbSql.toString() );
								pstmt.setString	( i++, facilityId ) ;
								pstmt.setLong	( i++, encounterid ) ;
								pstmt.setInt	( i++, confBedClsSrlNo ) ;
								pstmt.setString	( i++, patientid);
								pstmt.setString	( i++, "ET" ) ;
								pstmt.setString	( i++, reqRadioBtn);
								pstmt.setInt	( i++, srlno);
								pstmt.setString	( i++, frnursingunitcode ) ;
								pstmt.setString	( i++, frbedclass ) ;
								pstmt.setString	( i++, frroomno ) ;
								pstmt.setString	( i++, frbedno ) ;
								pstmt.setString	( i++, frpractitionerid ) ;
								pstmt.setString	( i++, frspecialitycode ) ;
								pstmt.setString	( i++, tonursingunitcode ) ;
								pstmt.setString	( i++, tobedclass ) ;
								pstmt.setString	( i++, toroomno ) ;
								pstmt.setString	( i++, tobedno ) ;
								pstmt.setString	( i++, topractitionerid ) ;
								pstmt.setString	( i++, tospecialitycode ) ;
								pstmt.setString	( i++, trnDateTime ) ;
								pstmt.setString	( i++, addedById ) ;
								pstmt.setString	( i++, addedById);  
								pstmt.setString	( i++, addedAtWorkstation ) ;
								pstmt.setString	( i++, facilityId ) ;   
								pstmt.setString	( i++, addedById ) ;
								pstmt.setString	( i++, addedAtWorkstation ) ;
								pstmt.setString	( i++, facilityId ) ;
								
								try{
									insRes = pstmt.executeUpdate() ;
								}
								catch(Exception ex){
									ex.printStackTrace() ;	
								}
								if(insRes > 0)
									result = true; 
								else 
									result = false;
								if(pstmt != null) pstmt.close();
								

							}catch(Exception ex)
							{
								result = false;
								sb.append("Error while inserting into ip_confirm_bed_cls " + ex.getMessage());
								ex.printStackTrace(System.out);
							} 
						}
						/*End*/
				}

					if (result)
					{
						
						if(!new_reserved_bed_no.equals(""))
							{
								//java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","IP");
//								sb.append( "BedNO " +new_reserved_bed_no+" Reserved. \\n ");
								java.util.Hashtable msg = MessageManager.getMessage( locale,"BED_RESERVED","IP");

								String message  = "";
								String message1 = "";
								String message2 = "";

								message = (String) msg.get("message");
								message1 = message.substring(0,message.indexOf("$"));
								message2  = message.substring(message.indexOf("$")+1, message.length());
								message = message1 + new_reserved_bed_no + message2;
								sb.append(message);
								msg.clear();
							}

						java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM");
						sb.append( (String) message.get("message"));
						message.clear();
		
						con.commit();
						/*if(bookingCon!=null)
							bookingCon.commit();*/
					}
					else
					{
						result = false ;
						//java.util.Hashtable message = MessageManager.getMessage( locale, "ERROR_WHILE_UPDATING" ,"IP") ;
						//sb.append( (String) message.get("message") ) ;
						con.rollback();
						/*if(bookingCon!=null)
							bookingCon.rollback();*/
					}
				}
				catch ( Exception e ) 
				{
					result = false;
					sb.append("Error in insert Emergency Transfer "+ e.getMessage()  ) ;
					e.printStackTrace() ;
					try
					{
						con.rollback();
						/*if(bookingCon!=null)
							bookingCon.rollback();*/
					}
					catch(Exception e1){}
				}
				finally 
				{
					try
					{
						  if(pstmt != null)		pstmt.close() ;
						  if(rset != null)		rset.close();
						  if(stmt != null)		stmt.close();
						  if(srs != null)		srs.close();
						  if(stmt1 != null)		stmt1.close();
					}catch(Exception ce){}
						 if(con!=null) ConnectionManager.returnConnection(con,p);
						 //if(bookingCon!=null) ConnectionManager.returnConnection(bookingCon,p);
				}
			}
		} 
		hashValData.clear();
		ret.clear();
		results.put( "status", new Boolean(result) ) ;
		results.put( "call_report", new Boolean(CALL_REPORT) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "msg1", sb1.toString() ) ;
		
		
		// MOD#09 Added new parameter BL Message

		if ( (strBLMessage == null) || (strBLMessage.equals("")))
		{
				strBLMessage = " ";	
		}
		if ( (strBLMessage == null) || (strBLMessage.equals("")))
		{
				strBLMessage = " ";	
		}
		results.put( "bl_message",strBLMessage);
		results.put( "bl_special_message",strBLSpecialMessage);
		// End of MOD#09 
		return results ;
	}//end insert
	public static String checkForNull(String inputString, String defaultValue)
		{
			return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
		}
	
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
} // end session bean
