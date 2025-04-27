/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to admit the patients.
@author - 
@version - V3
*/

package eIP.IPConfirmBedClass;
import blipin.*;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPConfirmBedClass"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPConfirmBedClass"
*	local-jndi-name="IPConfirmBedClass"
*	impl-class-name="eIP.IPConfirmBedClass.IPConfirmBedClassManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPConfirmBedClass.IPConfirmBedClassLocal"
*	remote-class="eIP.IPConfirmBedClass.IPConfirmBedClassRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPConfirmBedClass.IPConfirmBedClassLocalHome"
*	remote-class="eIP.IPConfirmBedClass.IPConfirmBedClassHome"
*	generate= "local,remote"
*
*
*/
public class IPConfirmBedClassManager implements SessionBean 
{
	Connection con 			= null;
	PreparedStatement pstmt = null;
	Statement stmt 			= null;
	ResultSet srs 			= null;
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;	}
	String tobedtype			= "";
	String L_current_gender		= "*";
	String patientgender		= "";
	String dateofbirth			= "";	
	String auto_file_transfer_yn= "";
	String locale				= "";	
	StringBuffer sbSql			= new StringBuffer("");
	StringBuffer strBuffer		= new StringBuffer("");

	/*
	This method is used to validating the target values Like nusring unit rights, speciality and practioner checks
	@author - 
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/

	public java.util.HashMap ValidateIPConfirmBedClass(java.util.Properties p,java.util.HashMap tabData)
	{
		locale = p.getProperty("LOCALE");
		String facilityId			= (String)tabData.get("facilityId");
		String topractitionerid		= (String)tabData.get("topractitionerid");
		String tospecialitycode		= (String)tabData.get("tospecialitycode");  
		String tonursingunitcode	= (String)tabData.get("tonursingunitcode"); 
		String toroomno				= (String)tabData.get("toroomno");    
		String patientid			= (String)tabData.get("patientid");         
		String tobedno				= (String)tabData.get("tobedno"); 
		String fmnursingunitcode	= (String)tabData.get("fmnursingunitcode");
		String reason_status		= (String)tabData.get("reason_status"); //Added by Ashwini on 14-Nov-2019 for ML-MMOH-SCF-1395

		java.util.HashMap results	= new java.util.HashMap() ;
		boolean result				= true ;
		StringBuffer sb				= new StringBuffer("");
		try
		{
			con = ConnectionManager.getConnection(p);
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
						java.util.Hashtable message = MessageManager.getMessage( locale, "PRACT_ADMN_RIGHTS_DENIED","IP" );
						sb.append( (String) message.get("message") ) ;
					}
				}
				catch(Exception e)
				{
					result = false;
					 sb.append("Exception in checking Practitioner Admission Rights "+e.toString());
					 e.printStackTrace();
				}
			}

			if(result)
			{
				try
				{
					// Check for the speciality of given nursing unit
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select '1' from ip_nurs_unit_for_specialty where facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' and specialty_code='"+tospecialitycode+"' ");
					if(stmt!=null) stmt.close();
					if(srs!=null)  srs.close();
					stmt = con.createStatement();
					srs  = stmt.executeQuery(sbSql.toString());
					if(!srs.next())
					{
						result = false;
						java.util.Hashtable message = MessageManager.getMessage( locale, "SPLTY_ADMN_RIGHTS_DENIED","IP");
						sb.append( (String) message.get("message") ) ;
					}
				}
				catch(Exception e)
				{
					result = false;
					sb.append("Exception in checking Speciality Admission Rights "+e.toString());
					 e.printStackTrace();
				}
			}

			//Select from mp_patient
			/*if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
			sbSql.append(" select to_char(date_of_birth,'dd/mm/rrrr') date_of_birth ,sex from mp_patient where patient_id = '"+patientid+"' ");
			
			if(srs!=null)  srs.close();
			if(stmt!=null) stmt.close();

			stmt = con.createStatement();
			srs  = stmt.executeQuery(sbSql.toString());
			
			if(srs.next())
			{
				patientgender = srs.getString("sex") == null ? "" : srs.getString("sex");
				dateofbirth = srs.getString("date_of_birth") == null ? "" : srs.getString("date_of_birth");
			}*/

			if(result)
			{
				try
				{
					// Check for this nursing unit tranfer allowed or not
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" SELECT age_group_code,locn_type,allow_emerg_trf_yn FROM ip_nursing_unit WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' ");
					if(srs!=null)  srs.close();
					if(stmt!=null) stmt.close();

					stmt = con.createStatement();
					srs  = stmt.executeQuery(sbSql.toString());
					if (srs.next())
					{
						String agegrpcode = srs.getString(1) == null ? "" : srs.getString(1);
						if(!agegrpcode.equals(""))
						{
							// Check for the nursing unit have any criteria of age group or sex
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append(" Select '1' from am_age_group Where age_group_code='"+agegrpcode+"'  And NVL(GENDER,'"+patientgender+"')= '"+patientgender+"' AND  trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
							if(srs!=null)  srs.close();
							if(stmt!=null) stmt.close();

							stmt = con.createStatement();
							srs  = stmt.executeQuery(sbSql.toString());

							if(!srs.next())
							 {
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale,"AGE_GENDER_NOT_ALLOWED","IP" );
								sb.append( (String) message.get("message"));
							 }
		 					if(srs!=null) srs.close();
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
						sbSql.append(" Select  sex_spec_ind,Occupying_Patient_Id, bed_type_code, specialty_code from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' And bed_no='"+tobedno+"' ");
						stmt = con.createStatement();
						srs  = stmt.executeQuery(sbSql.toString());
						if(!srs.next())
						{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "INVALID_BED","Common" ) ;
								sb.append( (String) message.get("message") ) ;
						}
						else
						{
							String occupyingpatientid	 = srs.getString("Occupying_Patient_Id") == null ? "" : srs.getString("Occupying_Patient_Id") ;
							String sex_spec_ind			 = srs.getString("sex_spec_ind") == null ? "" : srs.getString("sex_spec_ind") ;
							tobedtype					 = srs.getString("bed_type_code")  == null ? "" : srs.getString("bed_type_code");
							String splty_code			 = srs.getString("specialty_code")==null ? "" : srs.getString("specialty_code");
							
							//Modified by Ashwini on 14-Nov-2019 for ML-MMOH-SCF-1395
							if ((!(occupyingpatientid.equals("") || occupyingpatientid.equals(patientid))) && reason_status.equals("1"))
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "OCCUPIED_BED","IP");
								sb.append( (String) message.get("message") ) ;
							}
							else if (!splty_code.equals("") && !splty_code.equals(tospecialitycode)) //Added	for specialty to bed validation
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "BED_SPLTY_INVALID","IP");
								sb.append( (String) message.get("message") ) ;
							}
							else if (!sex_spec_ind.equals("") && !sex_spec_ind.equals(patientgender)) //Added	for gender to bed validation
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, 	"AGE_GENDER_NOT_ALLOWED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
							if(srs!=null) srs.close();	if(stmt!=null) stmt.close();
						}
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
					sbSql.append(" Select booking_type,override_yn from ip_bed_booking WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+tonursingunitcode+"' ");
					sbSql.append(" and req_bed_no='"+tobedno+"' and booking_status='0' and sysdate between blocked_from_date_time and blocked_until_date_time ");
					stmt=con.createStatement();
					
					srs = stmt.executeQuery(sbSql.toString());
					if(srs.next())
					{
						String bookingtype = srs.getString(1) == null ? "" : srs.getString(1);
						String overrideyn  = srs.getString(2) == null ? "" : srs.getString(2);

						if (overrideyn.equals("N"))
						{
							if (bookingtype.equals("L"))
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "NON_OVERRIDEABLE_BKG" ,"IP") ;
								sb.append( (String) message.get("message") ) ;
							}
							else
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "BLOCKED_BED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
						}
						else
						{
							if (bookingtype.equals("L"))
							{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage( locale, "OVERRIDEABLE_BKG","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
							else
							{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage( locale, "OVERRIDEABLE_BLOCKING","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
						}
					}
					if(srs!=null) srs.close();	if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					result = false;
					sb.append("Exception in checking Blocked/Booked beds "+e.toString());
					 e.printStackTrace();
				}
			}
			if(result)
			{
				try
				{
					int cnt=0;		
					String sqlQuery = "";
					String sqlQuery1 = "";
					sqlQuery = "SELECT auto_file_transfer_yn FROM ip_nursing_unit WHERE facility_id = ? AND nursing_unit_code = ? AND 'Y' = (SELECT install_yn FROM sm_module WHERE module_id = 'FM') AND 'Y' = (Select transfer_file_yn from fm_parameter  where facility_id =?) AND fs_locn_code is not null";
					pstmt = con.prepareStatement(sqlQuery);					
					pstmt.setString(1,facilityId);
					pstmt.setString(2,fmnursingunitcode);
					pstmt.setString(3,facilityId);
					srs = pstmt.executeQuery();
					if(srs!=null && srs.next())
						auto_file_transfer_yn = srs.getString("auto_file_transfer_yn")==null?"":srs.getString("auto_file_transfer_yn");
					
					if (srs!=null)srs.close();
						if (pstmt!=null)pstmt.close();

					if(auto_file_transfer_yn.equals("Y")) {			
						sqlQuery1 = " Select count(*) from fm_transit_file where facility_id =? and patient_id =?";			
						pstmt = con.prepareStatement(sqlQuery1);
						pstmt.setString(1,facilityId);
						pstmt.setString(2,patientid);			
						srs = pstmt.executeQuery();
						if(srs!=null && srs.next())
							cnt =srs.getInt(1);					
						if (srs!=null)srs.close();
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
							// Get the target room no 
							if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
							sbSql.append("Select ROOM_NO from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' And bed_no='"+tobedno+"'");
							stmt = con.createStatement();
							srs = stmt.executeQuery(sbSql.toString());
							while(srs.next())
							{
								toroomno = srs.getString("ROOM_NO");
							}
							if(srs!=null) srs.close(); if(stmt!=null) stmt.close();
						}
						// Check the target room status
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append(" select a.occ_male_bed_count,a.occ_female_bed_count,a.occ_male_bed_count from ip_nursing_unit_room a, ip_nursing_unit b where a.facility_id='"+facilityId+"' and   a. nursing_unit_code='"+tonursingunitcode+"' and  a.room_no='"+toroomno+"' and  b.facility_id=a.facility_id and  b.nursing_unit_code=a.nursing_unit_code and b.check_same_sex_in_room_yn='Y' ");
						stmt = con.createStatement();
						srs  = stmt.executeQuery(sbSql.toString());

						if(srs.next())
						{
							int malebedcount    = srs.getInt(1);
							int femalebedcount  = srs.getInt(2);
							int unknownbedcount = srs.getInt(3);

							if(malebedcount > 0) 	L_current_gender = "M";
							else if(femalebedcount > 0) L_current_gender = "F";
							else if(unknownbedcount > 0) L_current_gender = "U";

							if (!L_current_gender.equals("*") && !L_current_gender.equals(patientgender))
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "IN_ROOM_ONLY_SAME_GENDER","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
						}
						 if(srs!=null) srs.close(); if(stmt!=null) stmt.close();
					}
					catch(Exception e)
					{
						result = false;
						 sb.append("Exception in checking for same gender in a room "+e.toString());
						  e.printStackTrace();
					}
				}
			}
		}
		catch(Exception e)
		{
			result  = false;
			sb.append( e.getMessage() +" Error in ValidateIPConfirmBedClass " ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}catch(Exception e1){ e1.printStackTrace();}
		}
		finally
		{
			 try{
				  if(pstmt != null)		pstmt.close() ;
				  if(stmt != null)		stmt.close();
				  if(srs != null)		srs.close();
				}
				catch(Exception ce)
				{}
				ConnectionManager.returnConnection(con,p);

		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;

	} // end ValidateEmergencyTransfer

	/*
	This method is used to _ _ _ _ _ _ _ _ _ _ _
	@author - 
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertIPConfirmBedClass(java.util.Properties p, java.util.HashMap hashData ) 
	{
		locale = p.getProperty("LOCALE");
		String facilityId			= (String)hashData.get("facilityId");
		String patientid			= (String)hashData.get("patientid");
		String strEncid				= (String)hashData.get("strEncid");
		String topractitionerid		= (String)hashData.get("topractitionerid");
		String tospecialitycode		= (String)hashData.get("tospecialitycode");
		String tobedclass			= (String)hashData.get("tobedclass");
		tobedtype			= (String)hashData.get("tobedtype");
		String tonursingunitcode	= (String)hashData.get("tonursingunitcode");
		String tobedno				= (String)hashData.get("tobedno");
		String toroomno				= (String)hashData.get("toroomno");
		String frnursingunitcode	= (String)hashData.get("frnursingunitcode");
		String modified_bed_type_code= (String)hashData.get("modified_bed_type_code");
		String modifiedAtWorkstation= (String)hashData.get("addedAtWorkstation");
		String reason_status		= (String)hashData.get("reason_request");
		String tran_type			= (String)hashData.get("tran_type");
		String mother_bed_status	= (String)hashData.get("mother_bed_status");
		if(mother_bed_status == null) mother_bed_status = "";

		patientgender				 = (String)hashData.get("patientgender");
		dateofbirth					 = (String)hashData.get("dateofbirth");
		
		/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/
		String srl_no="";
		String reqRadioBtn	 		= checkForNull((String)hashData.get("reqRadioBtn"));
		String frbedclass			= checkForNull((String)hashData.get("frbedclass"));
		String frroomno				= checkForNull((String)hashData.get("frroomno"));
		String frbedno  			= checkForNull((String)hashData.get("frbedno"));
		String frpractitionerid		= checkForNull((String)hashData.get("frpractitionerid"));
		String frspecialitycode		= checkForNull((String)hashData.get("frspecialitycode"));
		/*End*/

		long    encounterid			= 0;

		if(!strEncid.equals(""))
			encounterid		= Long.parseLong(strEncid);

		java.util.HashMap results = new java.util.HashMap() ;
		boolean result	= false ;
		StringBuffer sb = new StringBuffer("");
		results.put( "error", "no error" ) ;
		String modifiedById			 = p.getProperty( "login_user" ) ;
		HashMap hashValData = new HashMap();
		// MOD#08	Introduced new variable strBLMessage

		hashValData.put("facilityId",facilityId);      
		hashValData.put("topractitionerid",topractitionerid);
		hashValData.put("tospecialitycode",tospecialitycode);
		hashValData.put("tonursingunitcode",tonursingunitcode);	
		hashValData.put("toroomno",toroomno);        			
		hashValData.put("patientid",patientid);       					
		hashValData.put("tobedno",tobedno);         					
		hashValData.put("tobedclass",tobedclass);      						
		hashValData.put("fmnursingunitcode",frnursingunitcode);
		hashValData.put("reason_status",reason_status); //Added by Ashwini on 14-Nov-2019 for ML-MMOH-SCF-1395
		//Check the target values validation
		HashMap ret		= ValidateIPConfirmBedClass(p,hashValData);
		boolean retval  = ((Boolean)ret.get("status")).booleanValue();
		sb.append((String)ret.get("error"));
		// If validation is true then update the values
		if(retval)
		{
			result = true;
			if(result)
			{
				try
				{
					con = ConnectionManager.getConnection(p);
					con.setAutoCommit(false);
				if(reason_status.equals("2"))
				{  //Added Audit column
					int reset = 0;	
					sbSql.delete(0, sbSql.length());
					sbSql.append(" Update IP_BED_CLASS_REQUEST set "); 
					sbSql.append("REQUEST_STATUS='9', MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' ");
					if(tran_type.equals("RT"))
						sbSql.append(" WHERE  facility_id= '"+facilityId+"' and TRN_TYPE='RT' and REQUEST_STATUS = '0' and encounter_id = "+encounterid+"");
					else if(tran_type.equals("ET"))
						sbSql.append(" WHERE  facility_id= '"+facilityId+"' and TRN_TYPE='ET' and REQUEST_STATUS = '0' and encounter_id = "+encounterid+"");
					else if(tran_type.equals("TO"))
						sbSql.append(" WHERE  facility_id= '"+facilityId+"' and TRN_TYPE='TO' and REQUEST_STATUS = '0' and encounter_id = "+encounterid+"");
					
					pstmt = con.prepareStatement( sbSql.toString());
					try
					{
						reset = pstmt.executeUpdate() ;
					}catch(Exception ex)
					{
						ex.printStackTrace(System.out);
						sb.append("error while inserting/updating into ip_bed_class_request"+ex.getMessage());
					}
					if(reset > 0) 
						result = true; 
					else 
						result = false;

					if(pstmt!=null) pstmt.close();

				   if(!tran_type.equals("ET"))
				   {
					 if(result)
					 {
						reset = 0;
						sbSql.delete(0, sbSql.length());
						sbSql.append(" Update IP_TRANSFER_REQUEST set ");
						if(tran_type.equals("RT"))
							sbSql.append("TFR_REQ_STATUS='2', MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' "); //Added Audit column
						else if(tran_type.equals("TO"))
							sbSql.append("TFR_REQ_STATUS='9', MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' "); //Added Audit column
						if(tran_type.equals("RT"))
							sbSql.append(" WHERE  facility_id= '"+facilityId+"' and TFR_REQ_STATUS = '0' and encounter_id = "+encounterid+" ");
						else if(tran_type.equals("TO"))
							sbSql.append(" WHERE  facility_id= '"+facilityId+"' and TFR_REQ_STATUS = '3' and encounter_id = "+encounterid+" ");
						pstmt = con.prepareStatement( sbSql.toString());
						try
						{
							reset = pstmt.executeUpdate() ;
						}
						catch(Exception ex)
						{
							sb.append("error while Update IP_TRANSFER_REQUEST "+ex.getMessage());
							 ex.printStackTrace();
						}
							if(reset > 0) result = true; else result = false;
							if(pstmt!=null) pstmt.close();
						}
					}
					
					if(result)
					{
						reset = 0;
						try
						{
							if(sbSql.length() > 0)
								sbSql.delete(0, sbSql.length());
                         //Added Audit column

							sbSql.append(" update IP_OPEN_ENCOUNTER set ");
							sbSql.append(" TFR_REQ_STATUS = '', ");
							sbSql.append(" modified_by_id = ?, ");
							sbSql.append(" modified_at_ws_no = ?, modified_date = sysdate, modified_facility_id = ?  ");
							sbSql.append(" where ");
							sbSql.append(" facility_id = ? and ENCOUNTER_ID = ?");
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString(1, modifiedById);
							pstmt.setString(2, modifiedAtWorkstation);
							pstmt.setString(3, facilityId); //Added Audit column
							pstmt.setString(4, facilityId);
							pstmt.setLong(5, encounterid);
							int j1 = pstmt.executeUpdate();
							if(j1 > 0)
								result = true;
							else
								result = false;

							if(pstmt != null)	pstmt.close();
						}
						catch(Exception ex)
						{
							result = false;
							sb.append("error while updating into ip_open_encounter " + ex.getMessage());
							ex.printStackTrace(System.out);
						}
				   }
				}
				else if(reason_status.equals("1") && tran_type.equals("RT")||tran_type.equals("TO"))
				{
					int reset = 0;
					sbSql.delete(0, sbSql.length());
					//Added Audit column
					sbSql.append(" Update IP_BED_CLASS_REQUEST set "); 
					sbSql.append("REQUEST_STATUS='1'");
					sbSql.append(" ,TO_BED_CLASS_CODE='"+tobedclass+"' ,");
					sbSql.append("TO_BED_TYPE_CODE='"+tobedtype+"' ,");
					sbSql.append("TO_BED_NO='"+tobedno+"', ");
					sbSql.append("TO_ROOM_NO='"+toroomno+"', MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' ");
					sbSql.append(" WHERE  facility_id= '"+facilityId+"' and ");
					
					if(tran_type.equals("RT"))
						sbSql.append("TRN_TYPE='RT'");
					else
						sbSql.append("TRN_TYPE='TO'");

					sbSql.append(" and REQUEST_STATUS = '0' and encounter_id = "+encounterid+"");
					pstmt = con.prepareStatement( sbSql.toString());
					try
					{
						reset = pstmt.executeUpdate();
					
					}catch(Exception ex)
					{
						ex.printStackTrace(System.out);
						sb.append("error while inserting/updating into ip_bed_class_request"+ex.getMessage());
					}
					if(reset > 0) result = true; else result = false;
					if(pstmt!=null) pstmt.close();

					if(result)
					{
						if(tobedno!=null)
						{
							//For Max Srl_no
							//String srl_no="";
							strBuffer.delete(0, strBuffer.length());
							strBuffer.append("select max(tfr_req_ref_no) srlno from ip_transfer_request where facility_id='"+facilityId+"' and encounter_id='"+encounterid+"'");
							stmt = con.createStatement();
							srs  = stmt.executeQuery(strBuffer.toString());
							if (srs.next())
							{
								srl_no=srs.getString("srlno");
							}
							try
							{
							if(stmt!=null) stmt.close();
							if(srs!=null) srs.close();
							strBuffer.delete(0, strBuffer.length());
							//Added Audit column
							strBuffer.append("update IP_TRANSFER_REQUEST set ");
							strBuffer.append("CONFIRMATION_DATE_TIME = sysdate, CONFIRMED_BY_ID = ?, ");
							strBuffer.append(" TFR_REQ_ACCEPTED_YN ='Y', REQ_BED_CLASS_CODE = ? , REQ_BED_TYPE_CODE=?, REQ_BED_NO = ? , ");
							strBuffer.append("req_room_no = ?, modified_by_id = ?, modified_at_ws_no = ?,BED_CLASS_REQ_STATUS='1', ");
							strBuffer.append("REQ_BED_TYPE_CODE_BY_DEFN='"+modified_bed_type_code+"', ");
							strBuffer.append("modified_date = sysdate, modified_facility_id = ?  where TFR_REQ_REF_NO = ?");
							strBuffer.append(" and  facility_id = ? and ");
							if(tran_type.equals("RT"))
								strBuffer.append(" TFR_REQ_STATUS = '0' ");
							else
								strBuffer.append(" TFR_REQ_STATUS = '3' ");
							strBuffer.append(" and encounter_id = ? and ");
							if(tran_type.equals("RT"))
								strBuffer.append(" TFR_REQ_TYPE='RT' ");
							else
								strBuffer.append(" TFR_REQ_TYPE='TO' ");
							pstmt = con.prepareStatement(strBuffer.toString());
							pstmt.setString	( 1, modifiedById ) ;
							pstmt.setString	( 2, tobedclass ) ;
							pstmt.setString	( 3, tobedtype ) ;
							pstmt.setString	( 4, tobedno ) ;
							pstmt.setString	( 5, toroomno ) ;
							pstmt.setString	( 6, modifiedById ) ;
							pstmt.setString	( 7, modifiedAtWorkstation ) ;
							pstmt.setString	( 8, facilityId) ; //Added Audit column
							pstmt.setString	( 9, srl_no) ;
							pstmt.setString	( 10, facilityId) ;
							pstmt.setLong	( 11, encounterid);
							reset = pstmt.executeUpdate();
							   }
							catch(Exception ex){
								result = false;
								ex.printStackTrace();
							   }
							if(reset > 0) result = true; else result = false;
							if(pstmt!=null) pstmt.close();
						}
					}

					/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/
						if(result && !reqRadioBtn.equals(""))
						{
							try
							{  
								
								int confBedClsSrlNo = 0;
								if(pstmt != null) pstmt.close();
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
								strBuffer.append("select nvl(MAX(srl_no),0)+1 srl_no from ip_confirm_bed_cls where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");
								
								pstmt	= con.prepareStatement(strBuffer.toString());
								srs		= pstmt.executeQuery();
								
								if(srs.next()){
									confBedClsSrlNo = srs.getInt("srl_no");
								}

								if(pstmt != null) pstmt.close();
								int insRes = 0;
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
								
								strBuffer.append("  insert into ip_confirm_bed_cls ");
								strBuffer.append(" (facility_id, encounter_id, srl_no, patient_id, bl_charging_req_type ");
								strBuffer.append(" , tfr_req_ref_no, fr_nursing_unit_code, fr_bed_class_code, fr_room_no, fr_bed_no ");
								strBuffer.append(" , fr_practitioner_id, fr_specialty_code, to_nursing_unit_code, to_bed_class_code, to_room_no, to_bed_no");
								strBuffer.append(" , to_practitioner_id, to_specialty_code, confirmed_date_time, confirmed_by_id " );
								strBuffer.append(" , added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?)" );
								
								int i = 1;
								pstmt = con.prepareStatement( strBuffer.toString() );
								pstmt.setString	( i++, facilityId ) ;
								pstmt.setLong	( i++, encounterid ) ;
								pstmt.setInt	( i++, confBedClsSrlNo ) ;
								pstmt.setString	( i++, patientid);
								pstmt.setString	( i++, reqRadioBtn);
								pstmt.setString	( i++, srl_no);
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
								pstmt.setString	( i++, modifiedById ) ;
								pstmt.setString	( i++, modifiedById);  
								pstmt.setString	( i++, modifiedAtWorkstation ) ;
								pstmt.setString	( i++, facilityId ) ;   
								pstmt.setString	( i++, modifiedById ) ;
								pstmt.setString	( i++, modifiedAtWorkstation ) ;
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
				//Updation ended here......

/*
						if(result && tran_type.equals("ET"))
						{
							count = 0;
							try
							{
								if(sbSql.length() > 0)	sbSql.delete(0, sbSql.length());
								sbSql.append("  update PR_ENCOUNTER set ");
								sbSql.append("  oth_adt_status = '', ");
								sbSql.append(" modified_by_id = ?, ");
								sbSql.append(" modified_at_ws_no = ?, modified_date = sysdate ");
								sbSql.append(" where ");
								sbSql.append(" facility_id = ? and encounter_id = ?");
								pstmt = con.prepareStatement(sbSql.toString());
								pstmt.setString(1, modifiedById);
								pstmt.setString(2, modifiedAtWorkstation);
								pstmt.setString(3, facilityId);
								pstmt.setLong(4, encounterid);
								count = pstmt.executeUpdate();
								if(count > 0)
									result = true;
								else
									result = false;

								if(pstmt != null) pstmt.close();
							
							}catch(Exception ex)
							{
								result = false;
								sb.append("error while updating PR_ENCOUNTER : " + ex.getMessage());
							}
						}
*/



					if (result == true)
					{
						java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
						sb.append( (String) message.get("message") ) ;
						con.commit();
					}
					else
					{
						result = false ;
						java.util.Hashtable message = MessageManager.getMessage( locale, "ERROR_IN_UPDATING","SM" ) ;
						sb.append( (String) message.get("message") ) ;
						con.rollback();
					}

				}
				catch ( Exception e ) {
					result = false;
					sb.append("Error in insert IPConfirmBedCalss "+ e.getMessage()  ) ;
					e.printStackTrace(System.out);
					try{
						con.rollback();
					}catch(Exception e1){}
				}
				finally 
				{
					if (con != null)
					{
						try{
							  if(pstmt != null)		pstmt.close() ;
							  if(stmt != null)		stmt.close();
							  if(srs != null)		srs.close();
							}
							catch(Exception ce){}
							if(con!=null) ConnectionManager.returnConnection(con,p);
					}
				}
			}
		} // end if ValidateEmergencyTransfer
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		// MOD#09 Added new parameter BL Message
		/*if ( (strBLMessage == null) || (strBLMessage.equals("")))
		{
				strBLMessage = " ";	
		}
		if ( (strBLMessage == null) || (strBLMessage.equals("")))
		{
				strBLMessage = " ";	
		}

		results.put( "bl_message",strBLMessage);
		results.put( "bl_special_message",strBLSpecialMessage);*/
			// End of MOD#09 
		return results ;
	}//end insert

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
} // end session bean
