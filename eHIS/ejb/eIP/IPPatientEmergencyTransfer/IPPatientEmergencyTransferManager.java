/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP.IPPatientEmergencyTransfer;
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
*	name="IPPatientEmergencyTransfer"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPPatientEmergencyTransfer"
*	local-jndi-name="IPPatientEmergencyTransfer"
*	impl-class-name="eIP.IPPatientEmergencyTransfer.IPPatientEmergencyTransferManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPPatientEmergencyTransfer.IPPatientEmergencyTransferLocal"
*	remote-class="eIP.IPPatientEmergencyTransfer.IPPatientEmergencyTransferRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPPatientEmergencyTransfer.IPPatientEmergencyTransferLocalHome"
*	remote-class="eIP.IPPatientEmergencyTransfer.IPPatientEmergencyTransferHome"
*	generate= "local,remote"
*
*
*/
public class IPPatientEmergencyTransferManager implements SessionBean 
{
	//Connection con 			= null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1= null;
	PreparedStatement pstmt2= null;
	ResultSet rset 			= null;
	Statement stmt 			= null;
	Statement stmt1			= null;
	ResultSet srs 			= null;

	SessionContext ctx;
	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}
	String nursingunittype		= "";
	String bed_class_chk		= "N";
	String billing_group_id		= "";
	String tobedtype			= "";
	String L_current_gender		= "*";
	String patientgender		= "";
	String auto_rec_ward_yn		= "";
	String fm_install_yn		= "";
	String transfter_file_yn	= "";
	String auto_file_transfer_yn= "";
	String fm_fs_locn_code		= "";
	String fm_locn_identity		= "";
	String file_no				= "";
	String toroomno				= "";
	StringBuffer sbSql			= new StringBuffer("");
	StringBuffer sqlBuffer	    = new StringBuffer();
	StringBuffer strBuffer      = new StringBuffer();
	String locale = "";
	String fr_bed_type_code_by_defn= "";
	String 	fr_bed_type_code		= "";
	String 	tonursingunittype		= "N";
	String 	block_type_code		    = "";
	String 	bed_block_remark		= "";
	StringBuffer sb1			= new StringBuffer("");
	String reqRadioBtn			  = ""; //Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
	

	public java.util.HashMap ValidateIPPatientEmergencyTransfer(java.util.Properties p,java.util.HashMap tabData)
	{
		Connection con 			= null;
		String facilityId			= (String)tabData.get("facilityId");
		String topractitionerid		= (String)tabData.get("topractitionerid");
		String tospecialitycode		= (String)tabData.get("tospecialitycode");  
		String tonursingunitcode	= (String)tabData.get("tonursingunitcode"); 
			   toroomno				= (String)tabData.get("toroomno");    
		String patientid			= (String)tabData.get("patientid");         
		String tobedno				= (String)tabData.get("tobedno");
		String fmnursingunitcode	= (String)tabData.get("fmnursingunitcode");
		String modified_date_val	= (String)tabData.get("modified_date_val");
		String encounterID			= (String)tabData.get("encounter_id"); 
		
		java.util.HashMap results   = new java.util.HashMap() ;
		boolean result				= true;
		StringBuffer sb				= new StringBuffer("");
		String bookingtype			= "";
		String overrideyn			= "";
		try
		{	
			locale = p.getProperty("LOCALE");
			con = ConnectionManager.getConnection(p);
			String modified_date_value = "";
			if(result)
			{
				try
				{
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select TO_CHAR(modified_date, 'dd/mm/rrrr hh24:mi') modified_date from IP_OPEN_ENCOUNTER where facility_id='"+facilityId+"' and encounter_id='"+encounterID +"' ");
					stmt=con.createStatement();
					srs = stmt.executeQuery(sbSql.toString());
					
					if(srs.next())
					{
						modified_date_value = srs.getString("modified_date");
						if (modified_date_value.equals(modified_date_val))
						{
							result = true;
						}
						else
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"ENC_ALREADY_MODIFIED","IP");
							sb.append((String) message.get("message") ) ;
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
					sbSql.append(" Select '1' from  ip_nursing_unit_for_pract where facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode +"' and practitioner_id='"+topractitionerid+"' ");
					stmt=con.createStatement();
					srs = stmt.executeQuery(sbSql.toString());
					if(!srs.next())
					{
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"PRACT_ADMN_RIGHTS_DENIED","IP");
						sb.append( (String) message.get("message") ) ;
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

			if(result)
			{
				try
				{
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" SELECT age_group_code, locn_type, allow_emerg_trf_yn FROM ip_nursing_unit WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' ");
					stmt=con.createStatement();
					srs = stmt.executeQuery(sbSql.toString());
					String allow_emerg_trf_yn = "";
					if (srs.next())
					{
						String agegrpcode   = srs.getString(1) == null ? "" : srs.getString(1);
						nursingunittype     = srs.getString(2) == null ? "" : srs.getString(2) ;
						allow_emerg_trf_yn  = srs.getString(3)==null ? "" : srs.getString(3);
						
						if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
						
						if(!agegrpcode.equals(""))
						{
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append(" Select '1' from am_age_group Where age_group_code='"+agegrpcode+"'  And NVL(GENDER,'"+patientgender+"')= '"+patientgender+"' AND  trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
							stmt = con.createStatement();
							srs  = stmt.executeQuery(sbSql.toString());
							if(!srs.next())
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "AGE_GENDER_NOT_ALLOWED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
							if(srs !=null) srs.close(); if(stmt !=null) stmt.close();
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
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append(" Select  sex_spec_ind, occupying_patient_id, bed_type_code, specialty_code from IP_NURSING_UNIT_BED WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' And bed_no='"+tobedno+"' ");
						stmt=con.createStatement();
						srs = stmt.executeQuery(sbSql.toString());
						if(!srs.next())
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "INVALID_BED","IP" );
							sb.append( (String) message.get("message") ) ;
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
							}
							else if (!splty_code.equals("") && !splty_code.equals(tospecialitycode)) 
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "BED_SPLTY_INVALID","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
							else if (!sex_spec_ind.equals("") && !sex_spec_ind.equals(patientgender)) 
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale,"AGE_GENDER_NOT_ALLOWED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
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
							}
							else
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "BLOCKED_BED","IP");
								sb.append( (String) message.get("message") ) ;
							}
						}
						else
						{
							if (bookingtype.equals("L"))
							{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage(locale,"OVERRIDEABLE_BKG","IP" ) ;
								sb1.append( (String) message.get("message") ) ;
							}
							else
							{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage(locale,"OVERRIDEABLE_BLOCKING","IP");
								sb1.append( (String) message.get("message") ) ;
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
					int cnt=0;		
					String sqlQuery = "";
					String sqlQuery1 ="";
					sqlQuery = "SELECT auto_file_transfer_yn FROM ip_nursing_unit WHERE facility_id = ? AND nursing_unit_code = ? AND 'Y' = (SELECT install_yn FROM sm_module WHERE module_id = 'FM') AND 'Y' = (Select transfer_file_yn from fm_parameter  where facility_id =?) AND fs_locn_code is not null";		
					pstmt = con.prepareStatement(sqlQuery);
					pstmt.setString(1,facilityId);
					pstmt.setString(2,fmnursingunitcode);
					pstmt.setString(3,facilityId);
					rset = pstmt.executeQuery();
					if(rset!=null && rset.next())
						auto_file_transfer_yn = rset.getString("auto_file_transfer_yn")==null?"":rset.getString("auto_file_transfer_yn");
					
					if (rset!=null)rset.close();
						if (pstmt!=null)pstmt.close();
					if(auto_file_transfer_yn.equals("Y")) {			
						sqlQuery1 = " Select count(*) from fm_transit_file where facility_id =? and patient_id =?";			
						pstmt = con.prepareStatement(sqlQuery1);
						pstmt.setString(1,facilityId);
						pstmt.setString(2,patientid);			
						rset = pstmt.executeQuery();
						if(rset!=null && rset.next())
							cnt =rset.getInt(1);					
						if (rset!=null)rset.close();
						if (pstmt!=null)pstmt.close();				
						if(cnt==0)
							result=true;
						else
							{
						      result = false;
							  java.util.Hashtable message = MessageManager.getMessage( locale, "FILE_IN_TRASIT","IP" ) ;
							  sb.append( (String) message.get("message") ) ;
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
						if(toroomno == null || toroomno.equals(""))
						{
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
		results.put( "bookingtype", bookingtype ) ;
		results.put( "overrideyn", overrideyn ) ;
		return results ;
	} 
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertIPPatientEmergencyTransfer(java.util.Properties p, java.util.HashMap hashData )
	{

		Connection con 				= null;
		Connection bookingCon 		= null;
		locale = p.getProperty("LOCALE");
		String facilityId			= (String)hashData.get("facilityId");
		String patientid			= (String)hashData.get("patientid");
		String strEncid				= (String)hashData.get("strEncid");
		String transferdate			= (String)hashData.get("transferdate");
		transferdate				= DateUtils.convertDate(transferdate,"DMYHM",locale,"en");
		String transfertype			= (String)hashData.get("transfertype");
		String topractitionerid		= (String)hashData.get("topractitionerid");
		String tospecialitycode		= (String)hashData.get("tospecialitycode");
		String tobedclass			= (String)hashData.get("tobedclass");
			   tobedtype			= (String)hashData.get("tobedtype");
		String tonursingunitcode	= (String)hashData.get("tonursingunitcode");
		billing_group_id			= (String)hashData.get("billing_group_id");
		String toservicecode		= (String)hashData.get("toservicecode");
		String tosubservcode		= (String)hashData.get("tosubservcode");
		String tobedno				= (String)hashData.get("tobedno");
			   toroomno				= (String)hashData.get("toroomno");
		String strTodc				= (String)hashData.get("strTodc");
		String frpractitionerid		= (String)hashData.get("frpractitionerid");
		String frspecialitycode		= (String)hashData.get("frspecialitycode");
		String frbedclass			= (String)hashData.get("frbedclass");
		String frnursingunitcode	= (String)hashData.get("frnursingunitcode");
		String frservicecode		= (String)hashData.get("frservicecode");
		String frsubservcode		= (String)hashData.get("frsubservcode");
		String frbedno				= (String)hashData.get("frbedno");
		String frroomno				= (String)hashData.get("frroomno");
		String strFrdc				= (String)hashData.get("strFrdc");
		//String frbedtype			= (String)hashData.get("frbedtype");
		String modified_bed_type_code= (String)hashData.get("modified_bed_type_code");
		String addedAtWorkstation	= (String)hashData.get("addedAtWorkstation");
		String bl_interface_yn		= (String)hashData.get("bl_interface_yn");
		String bl_operational		= (String)hashData.get("bl_operational");
		String encounter_id			= (String)hashData.get("encounter_id");
		String frteamid				= (String)hashData.get("frteamid");
		String toteamid				= (String)hashData.get("toteamid");
		String bed_blk_period		= (String)hashData.get("bed_blk_period");
		if(bed_blk_period.equals("0"))
			bed_blk_period			= "";
		String override_yn			= (String)hashData.get("override_yn");
		if(override_yn == null)
			override_yn				= "N";
		String pseudo_bed_yn		= (String)hashData.get("pseudo_bed_yn");
		String deactivate_pseudo_bed_yn = (String)hashData.get("deactivate_pseudo_bed_yn");
		String mother_bed_status	= (String)hashData.get("mother_bed_status");
		String patient_class		= (String)hashData.get("patient_class");
		String modified_date_val	= (String)hashData.get("modified_date_val");
		String admission_date		= (String)hashData.get("admission_date");
		String is_reserved_bed_checked			= (String)hashData.get("is_reserved_bed_checked");
		String confirm_yn			= (String)hashData.get("confirm_yn");
		String system_date			= (String)hashData.get("sdate");
		String transfer_wo_delink_yn	= "";//Added for the CRF - HSA-CRF-0035
		transfer_wo_delink_yn	    = (String)hashData.get("transfer_wo_delink_yn");//Added for the CRF - HSA-CRF-0035
		//String new_reserved_bed_no	= "";
		
		reqRadioBtn					= checkForNull((String)hashData.get("reqRadioBtn"));//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
		/*Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 Start*/
		String bl_adm_remarks		= (String)hashData.get("bl_adm_remarks");
		String bl_bed_request		= (String)hashData.get("bl_bed_request");
		String bl_bed_type_code		= (String)hashData.get("bl_bed_type_code");
		/*Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 End*/
	
		String ext_num				= "";
		String bill_type_code		= "";
		String blng_class_code		= "";
		String blng_serv_code		= "";
		String BOOKING_TYPE			= "";
		String OVERRIDE_YN			= "";

		long    encounterid			= 0;
		int	    todailycharge		= 0;
		int	    frdailycharge		= 0;
		int     srlno               = 0;
		int     res                 = 0;
		int babyCount=0;//Added for the CRF - HSA-CRF-0035
		
		int transferBabyCount=0;//Added for this SCF ML-MMOH-SCF-0663
		
		//int bed_srlno				= 0;
		int blocked_bed_record		= 0;
		if(!strEncid.equals(""))
			encounterid				= Long.parseLong(strEncid);
		if(!strTodc.equals(""))
			todailycharge			= Integer.parseInt(strTodc);
		if(!strFrdc.equals(""))
			frdailycharge			= Integer.parseInt(strFrdc);
		java.util.HashMap results	= new java.util.HashMap() ;
		boolean result				= false ;
		boolean CALL_REPORT			= true ;
		StringBuffer sb				= new StringBuffer(""); 

		results.put( "error", "no error" ) ;
		String addedById			 = p.getProperty( "login_user" ) ;
		int rs = 0;
		HashMap hashValData = new HashMap();
		String strBLMessage = "";
		String strBLSpecialMessage = "";
		boolean boolBLInstall = false;
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
		HashMap ret = ValidateIPPatientEmergencyTransfer(p,hashValData);
		ArrayList<String> babyBedNo=new ArrayList<String>();//Added for the CRF - HSA-CRF-0035
		ArrayList<String> babyPatientId=new ArrayList<String>();//Added for the CRF - HSA-CRF-0035

		try
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false); 
		}
		catch(Exception Ex)
		{ 
			Ex.printStackTrace();
		}

		boolean retval		=((Boolean)ret.get("status")).booleanValue();
		sb.append((String)ret.get("error"));
		BOOKING_TYPE		= (String)ret.get("bookingtype");
		OVERRIDE_YN			= (String)ret.get("overrideyn");
		if(retval)
		{
			result = true;
			try
			{
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
					if(result)
					{
						sbSql.delete(0, sbSql.length());

						sbSql.append(" update pr_encounter set ");
						sbSql.append(" attend_practitioner_id = ? , specialty_code=?, assign_care_locn_type=?, ");
						sbSql.append(" assign_care_locn_code=?, assign_room_num=? , assign_bed_num = ?, SUBSERVICE_CODE = ?, SERVICE_CODE = ?, assign_bed_class_code = ?,ASSIGN_BED_TYPE_CODE=?,PAT_CURR_LOCN_TYPE=?,PAT_CURR_LOCN_CODE=?,PAT_TRN_TIME=sysdate, ROOM_TEL_EXT_NUM = ?  , MODIFIED_AT_WS_NO = ? , MODIFIED_BY_ID = ? , MODIFIED_DATE = sysdate , MODIFIED_FACILITY_ID = ? ");
					
						sbSql.append(" where facility_id=? and encounter_id = ? ");
						
						/*Above query modified by senthil*/

						pstmt = con.prepareStatement( sbSql.toString());
						pstmt.setString	( 1, topractitionerid ) ;
						pstmt.setString	( 2, tospecialitycode ) ;
						pstmt.setString	( 3, tonursingunittype ) ;
						pstmt.setString	( 4, tonursingunitcode ) ;
						pstmt.setString	( 5, toroomno ) ;
						pstmt.setString	( 6, tobedno ) ;
						pstmt.setString	( 7, tosubservcode ) ;
						pstmt.setString	( 8, toservicecode ) ;
						pstmt.setString	( 9, tobedclass ) ;
						pstmt.setString	( 10, tobedtype ) ;
						pstmt.setString	( 11, tonursingunittype ) ;
						pstmt.setString	( 12, tonursingunitcode ) ;
						pstmt.setString	( 13, ext_num ) ;
						
						pstmt.setString	( 14, addedAtWorkstation ) ;
						pstmt.setString	( 15, addedById ) ;
						pstmt.setString	( 16, facilityId ) ;
						/*Above line added by senthil*/
						
						pstmt.setString	(17, facilityId ) ;
						pstmt.setLong	(18, encounterid ) ;
					
						try
						{
							rs = pstmt.executeUpdate() ;
							if(rs>0 )  result = true; else result = false;
							if(pstmt!=null)pstmt.close();
						
						}catch(Exception ex)
						{
							result = false;
							ex.printStackTrace();
						}
					}
						String L_practitioner_transfer = "";
						if(result)
						{
							sbSql.delete(0, sbSql.length());
							sbSql.append("select MAX(srl_no)+1 srl_no from ip_adt_trn where facility_id = "); 
							sbSql.append(" '"+facilityId+"' and encounter_id = "+encounterid+" ");
							stmt   = con.createStatement();
							srs = stmt.executeQuery(sbSql.toString());

							if(srs.next())
							{
							   srlno = srs.getInt("srl_no");
							}
							if(srs!=null)srs.close();
							if(stmt!=null)stmt.close();
							L_practitioner_transfer = "N";
							int ress = 0;	
							sbSql.delete(0, sbSql.length());

							try
							{
								if(srlno > 0 )
								{
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
										sbSql.append("  update IP_ADT_TRN set trn_to_date_time = to_date('"+transferdate+"','dd/mm/rrrr hh24:MI') ");
									if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn!=null && confirm_yn.equals("N"))
										sbSql.append("  , RESERVED_YN = 'Y' ");	
									//updating audit columns
									sbSql.append(", modified_by_id = '" + addedById  + "', modified_date = sysdate, modified_facility_id = '");
									sbSql.append( facilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
									sbSql.append("  where srl_no = ("+srlno+" - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");

											
					
									if(pstmt !=null) pstmt.close();
									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.executeUpdate();
									if(pstmt !=null) pstmt.close();
								}
							}catch(Exception ex)
							{
								result = false;
								sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
							}
								
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
												
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

								if(modified_bed_type_code == null || modified_bed_type_code.equals(""))
								{
									modified_bed_type_code  = tobedtype;
								}
								sbSql.delete(0, sbSql.length());

								sbSql.append("  insert into IP_ADT_TRN ");
								sbSql.append(" (facility_id, encounter_id, srl_no, patient_id, trn_type ");
								sbSql.append(" , trn_code, trn_date_time, to_nursing_unit ");
								sbSql.append(" , to_room_no, to_bed_no ");
								sbSql.append(" , to_bed_class_code, to_bed_type_code, to_pract_team_id "); sbSql.append(" , to_practitioner_id, to_specialty_code ");
								sbSql.append(" , fr_nursing_unit_code, fr_room_no, fr_bed_no ");
								sbSql.append(" , fr_bed_class_code, fr_bed_type_code, tfr_type ");
								sbSql.append(" , emergency_trn_yn, practitioner_tfr_yn ");
								sbSql.append(" , fr_service_code, fr_subservice_code ");//
								sbSql.append(" , added_by_id, added_date ");
								sbSql.append(" , added_facility_id, added_at_ws_no ");
								sbSql.append(" , modified_by_id, modified_date ");
								sbSql.append(" , modified_facility_id, modified_at_ws_no ");
								sbSql.append(" , fr_specialty_code, fr_practitioner_id, from_pract_team_id ");
								sbSql.append(" , to_service_code, to_subservice_code ");
							if(bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
							{
								sbSql.append(" , transfer_chargeable_yn, trn_charge ");
								sbSql.append(" , blng_class_code, blng_serv_code, bill_type_code "); 
								sbSql.append(" , fr_bed_type_code_by_defn, to_bed_type_code_by_defn ");
								sbSql.append(" , to_daily_rate, fr_daily_rate ");
							}
								sbSql.append(" , patient_class, admission_date_time,PAT_HOSP_REQUEST,BED_TYPE_CODE_CHRG,REASON_REMARKS ");
								sbSql.append(" ) values ( ");
								sbSql.append(" ?, ?, ?, ?, ?, ?, to_date('"+transferdate+"','dd/mm/rrrr hh24:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?");
								
							if(bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
								sbSql.append(", ?, ?, ?, ?, ?, ?, ?, ?, ? ");

								sbSql.append(",'"+patient_class+"',to_date('"+admission_date+"','dd/mm/rrrr hh24:mi'), '"+bl_bed_request+"','"+bl_bed_type_code+"','"+bl_adm_remarks+"' ");
								sbSql.append(" ) ");

								

								pstmt = con.prepareStatement(sbSql.toString() );

								pstmt.setString	( 1, facilityId );
								pstmt.setLong	( 2, encounterid );
								pstmt.setInt	( 3, srlno );
								pstmt.setString	( 4, patientid);
								pstmt.setString	( 5, "T" );
								pstmt.setString	( 6, transfertype );
								pstmt.setString	( 7, tonursingunitcode );
								pstmt.setString	( 8, toroomno );
								pstmt.setString	( 9, tobedno );
								pstmt.setString	( 10, tobedclass );
								pstmt.setString	( 11, modified_bed_type_code );
								pstmt.setString	( 12, toteamid);
								pstmt.setString	( 13, topractitionerid );
								pstmt.setString	( 14, tospecialitycode );
								pstmt.setString	( 15, frnursingunitcode );
								pstmt.setString	( 16, frroomno );
								pstmt.setString	( 17, frbedno );
								pstmt.setString	( 18, frbedclass );
								pstmt.setString	( 19, fr_bed_type_code ) ;
								pstmt.setString	( 20, "I");
								pstmt.setString	( 21, "Y" );
								pstmt.setString	( 22, L_practitioner_transfer );
								pstmt.setString	( 23, frservicecode);
								pstmt.setString	( 24, frsubservcode);
								pstmt.setString	( 25, addedById);
								pstmt.setString	( 26, facilityId );
								pstmt.setString	( 27, addedAtWorkstation );
								pstmt.setString	( 28, addedById );
								pstmt.setString	( 29, facilityId );
								pstmt.setString	( 30, addedAtWorkstation );
								pstmt.setString	( 31, frspecialitycode);
								pstmt.setString	( 32, frpractitionerid);
								pstmt.setString	( 33, frteamid);
								pstmt.setString	( 34, toservicecode);
								pstmt.setString	( 35, tosubservcode);
							if(bl_interface_yn.equals("Y") && bl_operational.equals("Y"))
							{
								pstmt.setString	( 36, "N");
								pstmt.setString	( 37, "0");
								pstmt.setString	( 38, blng_class_code );
								pstmt.setString	( 39, blng_serv_code );
								pstmt.setString	( 40, bill_type_code );
								pstmt.setString	( 41, fr_bed_type_code_by_defn ) ; 
								pstmt.setString	( 42, tobedtype);
								pstmt.setInt	( 43, todailycharge );
								pstmt.setInt	( 44, frdailycharge );						
							}	
							
							
								ress = pstmt.executeUpdate() ;
								if(rs >0 && ress > 0) 
									result = true; 
								else
								{
									result = false;
									sb.append("Exception in inserting into IP_ADT_TRN");
								}

							
								if(pstmt !=null)pstmt.close();
						}
						try
						{
							if(result)
							{
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
								strBuffer.append("select Count(*) Total_Record FROM ip_bed_booking WHERE FACILITY_ID = '"+facilityId+"' AND  patient_id = '"+patientid+"'  and booking_status='0' and  REQ_NURSING_UNIT_CODE= '"+tonursingunitcode+"'  AND REQ_BED_NO= '"+tobedno+"' AND  ( BLOCKED_UNTIL_DATE_TIME IS NULL or blocked_until_date_time > SYSDATE) ");
								

								try
									{
										if(pstmt != null)	pstmt.close();
										pstmt = con.prepareStatement( strBuffer.toString() );
										srs = pstmt.executeQuery() ;
										if(srs!=null && srs.next())
										{
											blocked_bed_record = srs.getInt("Total_Record");
										}
										if(srs !=null) srs.close();
										if(pstmt !=null) pstmt.close();
									}
									catch(SQLException ex)
									{
										result = false;
										sb.append("Exception in while counter query of ip_bed_booking for no of block bed record  :"+ex.toString());
									}
									if(result && blocked_bed_record>0)
									{

										if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
										
											//Added Audit column
										
											strBuffer.append("update ip_bed_booking SET booking_status='2', MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE patient_id = '"+patientid+"' and FACILITY_ID='"+facilityId+"' AND REQ_NURSING_UNIT_CODE= '"+tonursingunitcode+"' AND REQ_BED_NO= '"+tobedno+"' and ( BLOCKED_UNTIL_DATE_TIME IS NULL or blocked_until_date_time > SYSDATE)  ");
											try
											{
												if(pstmt != null)	pstmt.close();
												pstmt = con.prepareStatement( strBuffer.toString() );
												int updated = pstmt.executeUpdate();
												result = (updated > 0) ? true : false;	
												if(pstmt !=null) pstmt.close();

												if(!result)
													sb.append("record is not updated because no record found in table ip_bed_booking for update query");

											}
											catch (SQLException ex)
											{
												result = false;
												sb.append("Exception in while updating  ip_bed_booking query for final status :"+ex.toString());
											}
									}
							}/*EOL 1463*/
/*Monday, August 16, 2010 , modified for SRR20056-SCF-4961 [IN:023143] , to close blocked status(if any) of selected to_bed.*/
							if(result && blocked_bed_record == 0)
							{
								if(OVERRIDE_YN.equals("Y") && !(BOOKING_TYPE.equals("L")|| BOOKING_TYPE.equals("N")))
								{
									try
									{
										if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
										strBuffer.append("update ip_bed_booking set booking_status = ? , cancelled_by_id = ?,  cancellation_date_time = sysdate, modified_by_id=?, modified_date = sysdate,  modified_at_ws_no= ?,  modified_facility_id =?   where facility_id = ? and booking_type = ? and req_nursing_unit_code = ? and req_bed_no = ? and req_room_no = ? and booking_status='0' and sysdate between blocked_from_date_time and blocked_until_date_time ");
										pstmt = con.prepareStatement(strBuffer.toString());
										pstmt.setString	( 1, "9");
										pstmt.setString	( 2, addedById);
										pstmt.setString	( 3, addedById);
										pstmt.setString	( 4, addedAtWorkstation);
										pstmt.setString	( 5, facilityId);
										pstmt.setString	( 6, facilityId);
										pstmt.setString	( 7, BOOKING_TYPE);
										pstmt.setString	( 8, tonursingunitcode);
										pstmt.setString	( 9, tobedno);
										pstmt.setString	( 10, toroomno);
										pstmt.executeUpdate() ;
										if(pstmt !=null) pstmt.close();
									}
									catch (Exception e)
									{
										e.printStackTrace();
									}
								}
								
							}
							if(result)
							{
								if(!frnursingunitcode.equals(tonursingunitcode))
								{ 
								   /*Added Audit column*/								 
									StringBuffer sql2 = new StringBuffer();
									sql2.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied +1, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where facility_id = ? and nursing_unit_code = ? ");
									pstmt = con.prepareStatement(sql2.toString());
									
									pstmt.setString	( 1, facilityId);
									pstmt.setString	( 2, tonursingunitcode ) ;

									int res2 = pstmt.executeUpdate() ;
									if(pstmt != null)pstmt.close();
									if(sql2.length() > 0) sql2.delete(0,sql2.length());
									 /*Added Audit column*/
									sql2.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied -1, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where facility_id = ? and nursing_unit_code = ? ");
									pstmt = con.prepareStatement(sql2.toString());
									
									pstmt.setString	( 1, facilityId);
									pstmt.setString	( 2, frnursingunitcode ) ;
									res2 = pstmt.executeUpdate() ;
									if(res2>0 )  result = true; else result = false;
									if(pstmt != null)	pstmt.close();

								}
							}
							int L_male_count = 0;
							int L_female_count = 0;
							int L_unknown_count = 0;

							if(patientgender.equals("M")) L_male_count = 1;
							if(patientgender.equals("F")) L_female_count = 1;
							if(patientgender.equals("U")) L_unknown_count = 1;
							if(!frroomno.equals(toroomno))
							{
								 StringBuffer sql3 = new StringBuffer();
								if(result)
								{

									if(sql3.length() > 0) sql3.delete(0,sql3.length());
									/*Added Audit column*/
									sql3.append(" update ip_nursing_unit_room set occ_male_bed_count=occ_male_bed_count+?,occ_female_bed_count=occ_female_bed_count+?,occ_unknown_bed_count=occ_unknown_bed_count+?,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ?  where facility_id=? and nursing_unit_code = ? and room_no = ? ");

									pstmt = con.prepareStatement(sql3.toString());

									pstmt.setInt	( 1, L_male_count ) ;
									pstmt.setInt	( 2, L_female_count);
									pstmt.setInt	( 3, L_unknown_count);									
									//Added Audit column
									pstmt.setString	( 4, addedById);
									pstmt.setString	( 5, addedAtWorkstation);
									pstmt.setString	( 6, facilityId);
									
									pstmt.setString	( 7, facilityId);
									pstmt.setString	( 8, tonursingunitcode ) ;
									pstmt.setString	( 9, toroomno ) ;
									int res3 = pstmt.executeUpdate() ;
									if(res3>0 )  result = true; else result = false;

								}
								if(pstmt != null)pstmt.close();

								if(result)
								{
									try
									{
										if(sql3.length() > 0) sql3.delete(0,sql3.length());
										
										/*Added Audit column*/
										sql3.append(" update ip_nursing_unit_room set occ_male_bed_count = occ_male_bed_count-?, occ_female_bed_count = occ_female_bed_count-?, occ_unknown_bed_count = occ_unknown_bed_count-?,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ?  where facility_id=? and nursing_unit_code = ? and room_no = ? ");
										pstmt = con.prepareStatement(sql3.toString());

										pstmt.setInt	( 1, L_male_count ) ;
										pstmt.setInt	( 2, L_female_count);
										pstmt.setInt	( 3, L_unknown_count);										
										//Added Audit column
										pstmt.setString	( 4, addedById);
										pstmt.setString	( 5, addedAtWorkstation);
										pstmt.setString	( 6, facilityId);
										
										pstmt.setString	( 7, facilityId);
										pstmt.setString	( 8, frnursingunitcode ) ;
										pstmt.setString	( 9, frroomno ) ;
										int ress3=0;

										ress3 = pstmt.executeUpdate();
										if(ress3>0 )  result = true; else result = false;
										if(pstmt != null)pstmt.close();
									}catch(Exception e)
									{
										e.printStackTrace();
									}

								}
						
							}
							if((!frnursingunitcode.equals(tonursingunitcode)) || (!frbedno.equals(tobedno)))
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
									//pstmt.setInt	( 4, babyCount) ; //Commented for this SCF ML-MMOH-SCF-0663
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
								
								String psedo_bed_staus		="";
							   if(result)
								{
									
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
								}
								if(result)
								{
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
										sbSql.append(" Select  PSUEDO_BED_STATUS from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+frnursingunitcode+"' And bed_no='"+frbedno+"' ");
										stmt=con.createStatement();
										srs = stmt.executeQuery(sbSql.toString());
										
										if(srs.next())
										{
											psedo_bed_staus = srs.getString("PSUEDO_BED_STATUS") == null ? "" : srs.getString("PSUEDO_BED_STATUS") ;
										}
									if(srs != null)srs.close();

									sbSql.delete(0,sbSql.length());
									sbSql.append(" update ip_nursing_unit_bed set ");
									sbSql.append(" occupying_patient_id = ?, current_status='O' ");
									//Updating audit columns
									sbSql.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
									
									if(deactivate_pseudo_bed_yn.equals("Y") && pseudo_bed_yn.equals("Y"))
									sbSql.append(", psuedo_bed_status = 'U'");
									sbSql.append(" where  facility_id = ? and nursing_unit_code = ? and"); 
									sbSql.append(" bed_no = ? and occupying_patient_id is null and current_status='A' ");
								
									pstmt = con.prepareStatement(sbSql.toString());
								  
									pstmt.setString	( 1, patientid ) ;
									pstmt.setString	( 2, facilityId);
									pstmt.setString	( 3, addedById) ;
									pstmt.setString	( 4, addedAtWorkstation) ;
									
									pstmt.setString	( 5, facilityId);
									pstmt.setString	( 6, tonursingunitcode ) ;
									pstmt.setString	( 7, tobedno ) ;
									int res4 = pstmt.executeUpdate() ;
									//if(res4>0 )  result = true; else result = false;																		
									if(res4>0 ){ 
										result = true;
									}else{ 
										result = false;
										Hashtable message = MessageManager.getMessage(locale,"OCCUPIED_BED","IP" ) ;
										sb.append( (String) message.get("message") ) ;

										message.clear();
                                      }
								}
								if(pstmt != null)pstmt.close();
								
								//logic to update the destination baby beds for the crf - HSA-CRF-0035 -- start
								if(mother_bed_status.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
								try {
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
										int res4 = pstmt.executeUpdate() ;
										if(pstmt !=null) pstmt.close();
										if(res4 > 0) result = true; else result = false;
									}
								} catch (Exception ex) {
									sb.append("Exception in updating ip_nursing_unit_bed while updating the destination baby beds : "+ex.toString());
									ex.printStackTrace();
								}
								}
								//Logic to relink the mother and the baby bed for the crf HSA-CRF-0035
								if(mother_bed_status.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
									if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								
								
								try {
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
									int res4 = pstmt.executeUpdate() ;
									if(pstmt !=null) pstmt.close();
									if(res4 > 0) result = true; else result = false;
								} catch (Exception ex) {
									sb.append("Exception in updating ip_open_encounter while relinking the mother and baby bed : "+ex.toString());
									ex.printStackTrace();
								}
								}
								//logic to update the destination baby beds for the crf - HSA-CRF-0035 -- End
							}/*EOL 1605*/

						}
						catch (Exception e)
						{
							result = false;
							sb.append("Exception in updating ip_nursing_unit table "+e.toString());
						}

/*Start  below line code added for GHL-SCF-758 [IN:041394]*/

						if(result)
						{
							if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
							sqlBuffer.append("select Count(*) Total_Record FROM IP_RESERVED_BED_DTL WHERE FACILITY_ID = '"+facilityId+"' AND  ENCOUNTER_ID  = '"+encounter_id+"' and RESERVED_NURSING_UNIT_CODE = '"+tonursingunitcode+"' AND RESERVED_BED_NO = '"+tobedno+"' AND  RESERVED_TO_TIME  IS null");

							int Reserve_Bed_No_Of_Record = 0;
							try
							{
								if(srs !=null) srs.close();if(pstmt != null)pstmt.close();
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
								sqlBuffer.append("UPDATE IP_RESERVED_BED_DTL SET   RESERVED_TO_TIME  = SYSDATE, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' WHERE FACILITY_ID = '"+facilityId+"' AND  ENCOUNTER_ID  = '"+encounter_id+"' and  RESERVED_NURSING_UNIT_CODE = '"+tonursingunitcode+"' AND RESERVED_BED_NO = '"+tobedno+"' AND  RESERVED_TO_TIME  IS null");

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

/*GHL-SCF-758 [IN:041394]  End*/


						if (result && (!(frnursingunitcode.equals(tonursingunitcode))))
						{
							StringBuffer sql16 = new StringBuffer();

							sql16.append(" select install_yn from sm_module where module_id = 'FM' ");
							String fm_install_yn="";
							String transfter_file_yn="";
							String auto_file_transfer_yn="";
							String fm_fs_locn_code="";
							String to_fs_locn_code="";
							String fm_locn_identity="";
							String to_locn_identity="";
							String file_no="";
							String narration="";
							String narration_desc="";
							String recd_userid="";
							String ret_date="";
							String auto_rec_ward_yn="";
							String curr_file_status="";
							String volume_no="";
							String file_type_code="";

								pstmt = con.prepareStatement(sql16.toString());
								srs   = pstmt.executeQuery();
								if (srs!=null && srs.next())
									fm_install_yn = srs.getString(1);
								if(srs != null) srs.close();
								if(pstmt != null) pstmt.close();
								if (fm_install_yn.equals("Y"))
									{
									if(sql16.length() > 0) sql16.delete(0,sql16.length());
									sql16.append("Select auto_rec_ward_yn, transfer_file_yn from fm_parameter  where facility_id =?");
									pstmt = con.prepareStatement(sql16.toString());
									pstmt.setString	( 1, facilityId ) ;
									srs = pstmt.executeQuery() ;
									if (srs!=null && srs.next()){
										auto_rec_ward_yn  = srs.getString(1);
										transfter_file_yn = srs.getString(2);
									}
									if(srs != null) srs.close();
									if(pstmt != null) pstmt.close();
									if (auto_rec_ward_yn.equals("Y"))
										curr_file_status="O";
									else
										curr_file_status="T";

									if (transfter_file_yn.equals("Y")){

										if(sql16.length() > 0) sql16.delete(0,sql16.length());
										sql16.append("Select a.auto_file_transfer_yn,a.fs_locn_code,b.locn_identity from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id =? and a.nursing_unit_code=? ");
										try
										{
										pstmt = con.prepareStatement(sql16.toString());
										pstmt.setString	( 1, facilityId ) ;
										pstmt.setString	( 2, frnursingunitcode ) ;
										
										srs = pstmt.executeQuery();
										
										}
										catch(Exception exc)
										{
										exc.printStackTrace();
										}
										if (srs!=null && srs.next()){
											auto_file_transfer_yn = srs.getString(1);
											fm_fs_locn_code		  = srs.getString(2);
											fm_locn_identity	  = srs.getString(3);
											if (fm_fs_locn_code==null) fm_fs_locn_code="";
										}
										if(srs!=null)srs.close();
										if(pstmt!=null)pstmt.close();
										if (auto_file_transfer_yn.equals("Y")&&fm_fs_locn_code!=""){
											if(sql16.length() > 0) sql16.delete(0,sql16.length());
											sql16.append("Select a.fs_locn_code,b.locn_identity,b.holder_name,to_char(sysdate+no_of_days_to_return,'dd/mm/rrrr hh24:mi')   from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id =? and a.nursing_unit_code=? ");
											pstmt = con.prepareStatement(sql16.toString());
											pstmt.setString	( 1, facilityId ) ;
											pstmt.setString	( 2, tonursingunitcode ) ;
											try
											{
											srs = pstmt.executeQuery() ;
											}
											catch(Exception exc)
											{
											exc.printStackTrace();
											}
											if (srs!=null && srs.next()){
												to_fs_locn_code  = srs.getString(1);
												to_locn_identity = srs.getString(2);
												recd_userid		 = srs.getString(3);
												ret_date		 = srs.getString(4);
											}
											if(srs!=null)srs.close();
											if(pstmt!=null)pstmt.close();
											if(recd_userid==null) recd_userid="";
											if(ret_date==null)	  ret_date="";
											if (to_fs_locn_code!="")
											{
												if(sql16.length() > 0) sql16.delete(0,sql16.length());
													sql16.append("select  a.file_no, a.volume_no,a.file_type_code, b.narration_code, c.short_desc from  fm_curr_locn a, fm_storage_locn b, fm_narration c where a.facility_id = ? and a.patient_id = ? and a.volume_status='A' and a.curr_file_status = 'O' and a.curr_fs_locn_code = ?  and a.facility_id = b.facility_id and a.curr_fs_locn_code = b.fs_locn_code and b.narration_code = c.narration_code (+) and a.curr_locn_id = ? ");

													pstmt = con.prepareStatement(sql16.toString());
													pstmt.setString	( 1, facilityId ) ;
													pstmt.setString	( 2, patientid) ;
													pstmt.setString	( 3, fm_fs_locn_code ) ;
													pstmt.setString	( 4, frnursingunitcode ) ;

													
													srs = pstmt.executeQuery() ;
													if (srs!=null && srs.next()){
														file_no			= srs.getString(1);
														volume_no		= srs.getString(2);
														file_type_code	= srs.getString(3);
														narration		= srs.getString(4);
														narration_desc	= srs.getString(5);
														if (file_no==null) file_no="";
														if (narration==null) narration="";
														if (narration_desc==null) narration_desc="";
														if (file_type_code==null) file_type_code="";
														
													}
													if(srs!=null)srs.close();
													if(pstmt!=null)pstmt.close();

												if(!file_no.equals(""))
												{
													
													if (volume_no==null) 
														volume_no="1";
													if(volume_no.equals(""))
														volume_no="1";

													String p_system_date = "";

													if(to_locn_identity.equals("N") && auto_rec_ward_yn.equals("Y"))
													{   
														p_system_date = system_date;		
													}

													if(sql16.length() > 0) sql16.delete(0,sql16.length());
													sql16.append("insert into fm_movement_log(facility_id, file_no,volume_no, sent_date_time, patient_id, src_facility_id, src_fs_locn_code, src_locn_identity, src_user_id, dest_facility_id, rec_date_time, dest_fs_locn_code, dest_locn_identity, dest_user_id, narration_code, movement_narration, movement_type, src_mr_locn_yn, dest_mr_locn_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?,?,?,sysdate,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,'F','N','N',?,sysdate,?,?,?,sysdate,?,?)");

													res = 0;
													pstmt = con.prepareStatement(sql16.toString());
													pstmt.setString	( 1, facilityId) ;
													pstmt.setString	( 2, file_no);
													pstmt.setString	( 3, volume_no);
													pstmt.setString	( 4, patientid) ;
													pstmt.setString	( 5, facilityId) ;
													pstmt.setString	( 6, fm_fs_locn_code) ;
													pstmt.setString	( 7, fm_locn_identity) ;
													pstmt.setString	( 8, addedById) ;
													pstmt.setString	( 9, facilityId) ;
													pstmt.setString	( 10, p_system_date) ;
													pstmt.setString	( 11, to_fs_locn_code) ;
													pstmt.setString	( 12, to_locn_identity) ;
													pstmt.setString	( 13, addedById) ;
													pstmt.setString	( 14, narration) ;
													pstmt.setString	( 15, narration_desc) ;
													pstmt.setString	( 16, addedById) ;
													pstmt.setString	( 17, addedAtWorkstation) ;
													pstmt.setString	( 18, facilityId) ;
													pstmt.setString	( 19, addedById) ;
													pstmt.setString	( 20, addedAtWorkstation) ;
													pstmt.setString	( 21, facilityId) ;
													try{	
													res = pstmt.executeUpdate() ;
													
													if(pstmt!=null)pstmt.close();
										
													}
													catch(Exception exc)
													{
														exc.printStackTrace();
														sb.append(exc.getMessage());
													}
													if(res>0 )  result = true; else result = false;	
													 /*Below line added for this  HSA-CRF-0306.1*/
			                       boolean siteSpecific=CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");

													if (result && !siteSpecific){
													if(sql16.length() > 0) sql16.delete(0,sql16.length());
													sql16.append("update fm_curr_locn set iss_date_time=sysdate,curr_facility_id =?,curr_file_status=?,curr_fs_locn_code=?,curr_fs_locn_identity=?,curr_holder_user_id=?,last_movement_date_time=sysdate,return_date_time=to_date(?,'dd/mm/rrrr hh24:mi'),");
													
													 

													if (!(curr_file_status.equals("T")))
														sql16.append("prev_facility_id=?,prev_fs_locn_code=?,");

													sql16.append("mr_locn_yn='Y', modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id = ? , curr_locn_id = ? where facility_id = ? and file_no =? and volume_no=?");
													pstmt = con.prepareStatement(sql16.toString());
													int inc=1;
													res = 0;
													pstmt.setString	( inc++,  facilityId) ;

													pstmt.setString	( inc++,  curr_file_status);
													if (curr_file_status.equals("T"))
														pstmt.setString	( inc++,  fm_fs_locn_code) ;
													else
														pstmt.setString	( inc++,  to_fs_locn_code) ;
													
													pstmt.setString	( inc++,  to_locn_identity) ;
													pstmt.setString	( inc++,  recd_userid) ;
													pstmt.setString	( inc++,  ret_date) ;

													if (!(curr_file_status.equals("T"))){
														pstmt.setString	( inc++,  facilityId) ;
														pstmt.setString	( inc++,  fm_fs_locn_code) ;
													}
													
													pstmt.setString	( inc++, addedById) ;
													pstmt.setString	( inc++, addedAtWorkstation) ;
													pstmt.setString	( inc++, facilityId) ;
													pstmt.setString	( inc++, tonursingunitcode) ;										
													pstmt.setString	( inc++, facilityId) ;
													pstmt.setString	( inc++, file_no) ;
													
													pstmt.setString	( inc++, volume_no) ;
													try
													{
													res = pstmt.executeUpdate() ;
													}
													catch(Exception exc)
													{
													exc.printStackTrace();
													sb.append(exc.getMessage());
													}

													if(res>0 )  
														result = true; 
													else 
														result = false;
														if(pstmt!=null)pstmt.close();
													}
													if (result&&curr_file_status.equals("T")){
													try {
													if(sql16.length() > 0) sql16.delete(0,sql16.length());	
													
													sql16.append("insert into fm_transit_file(facility_id, file_no,volume_no,file_type_code, patient_id, sent_date_time, src_facility_id, src_fs_locn_code, src_locn_identity, dest_facility_id, dest_fs_locn_code, dest_locn_identity, added_by_id, added_date, added_at_ws_no, added_facility_id) values(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,sysdate,?,?)");
													pstmt = con.prepareStatement(sql16.toString());
													int inc = 1;
													res = 0;
													pstmt.setString	( inc++,  facilityId) ;
													pstmt.setString	( inc++,  file_no);
													pstmt.setString	( inc++,  volume_no);
													pstmt.setString	( inc++,  file_type_code);
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
													try{
													res = pstmt.executeUpdate() ;
							
													}
													catch(Exception exc)
													{
														exc.printStackTrace();
														sb.append(exc.getMessage());
													}
													if(res>0 )  result = true; else result = false;	
														if(pstmt!=null)pstmt.close();
												}catch(Exception e2)
												{
													e2.printStackTrace();
													sb.append(e2.getMessage());
												}
												
												}
												}
											}


									}
								}
							}
						
						}
						if(result)
						{
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
							catch (Exception exceptionBL)
							{
								exceptionBL.printStackTrace();
							}
							if (boolBLInstall)
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
									hashtableBill.put("tobedtype",modified_bed_type_code);
									hashtableBill.put("tonursingunitcode",tonursingunitcode);
									hashtableBill.put("tobedno",tobedno);
									hashtableBill.put("toroomno",toroomno);
									hashtableBill.put("frbedclass",frbedclass);
									hashtableBill.put("frnursingunitcode",frnursingunitcode);
									hashtableBill.put("frbedno",frbedno);
									hashtableBill.put("frroomno",frroomno);
									hashtableBill.put("frbedtype",fr_bed_type_code);
									hashtableBill.put("frbedtypedefn",fr_bed_type_code_by_defn);
									hashtableBill.put("addedAtWorkstation",addedAtWorkstation);
									hashtableBill.put("bl_interface_yn",bl_interface_yn);
									hashtableBill.put("encounter_id",encounter_id);
									hashtableBill.put("addedById",addedById);
									hashtableBill.put("episode_id",encounter_id);
									hashtableBill.put("srlno",srlno+"");
									hashtableBill.put("episode_type",patient_class);
									hashtableBill.put("module_id",patient_class);
									BLIPTransfer blipTransfer = new BLIPTransfer();
									Hashtable resultsBL = blipTransfer.billPatientService(p, con,hashtableBill);
									boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
									result = boolRes;
									strBLMessage = "";
									hashtableBill.clear();
									if (boolRes == false)
									{
										result  = false;
									sb.append((String)resultsBL.get("error"));

									}
									if (boolRes == true)
									{
										result = true;
										sb.append((String)resultsBL.get("error"));
										strBLMessage = (String) resultsBL.get("message");
										strBLSpecialMessage = (String) resultsBL.get("bl_special_message");
										resultsBL.clear();
										if (strBLSpecialMessage == null)
										{
												strBLSpecialMessage = " ";
										}
										if (strBLMessage != null )
										{
											if (!strBLMessage.equalsIgnoreCase("null"))
											{
												//sb.append(strBLMessage);
											}
										}
									}
								}
								catch(Exception exceptionBL)
								{
										result  = false;
										exceptionBL.printStackTrace();
										sb.append("Error:eBL "+exceptionBL);
								}
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
								int insRes = 0;
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								
								sbSql.append("  insert into ip_confirm_bed_cls ");
								sbSql.append(" (facility_id, encounter_id, srl_no, patient_id, bl_charging_req_type ");
								sbSql.append(" , ip_adt_trn_srl_no, fr_nursing_unit_code, fr_bed_class_code, fr_room_no, fr_bed_no ");
								sbSql.append(" , fr_practitioner_id, fr_specialty_code, to_nursing_unit_code, to_bed_class_code, to_room_no, to_bed_no");
								sbSql.append(" , to_practitioner_id, to_specialty_code, confirmed_date_time, confirmed_by_id " );
								sbSql.append(" , added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:mi:ss'), ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?)" );
								
								int i = 1;
								pstmt = con.prepareStatement( sbSql.toString() );
								pstmt.setString	( i++, facilityId ) ;
								pstmt.setLong	( i++, encounterid ) ;
								pstmt.setInt	( i++, confBedClsSrlNo ) ;
								pstmt.setString	( i++, patientid);
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

						if(result)
						{
							result = true ;
							Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
							con.commit();
						}
						else
						{
							result = false ;
							con.rollback();
						
						}
						
					}
					catch (Exception e)
					{
						result = false;
						sb.append("Error in insert Emergency Transfer "+ e.getMessage()  ) ;
						e.printStackTrace() ;
						try
						{
							con.rollback();
							if(bookingCon!=null)
								bookingCon.rollback();
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
							 if(bookingCon!=null) ConnectionManager.returnConnection(bookingCon,p);
					}
				}
				else
				{
					result = false;
					Hashtable message = MessageManager.getMessage(locale,"ENC_ALREADY_MODIFIED","IP" ) ;
					sb.append((String) message.get("message"));
					message.clear();
				}
			}
			catch(Exception e)
			{
					sb.append( e.getMessage()  ) ;
					e.printStackTrace() ;
					
					try
					{
						con.rollback();
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}
			}
			finally 
				{
					try
					{
						if(pstmt != null)		pstmt.close() ;
						if(rset != null)		rset.close();
						if(stmt != null)		stmt.close();
						if(srs != null)		srs.close();

					}catch(Exception ce)
					{

					}
					if(con != null)      ConnectionManager.returnConnection(con,p);
				}
		}	

		/**/
		results.put( "status", new Boolean(result) ) ;
		results.put( "call_report", new Boolean(CALL_REPORT) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "msg1", sb1.toString() ) ;
		
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
		return results ;
	}
 	
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
} 
