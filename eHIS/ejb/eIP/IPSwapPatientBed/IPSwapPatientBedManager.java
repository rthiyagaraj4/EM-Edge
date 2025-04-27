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
@version - V3
*/
package eIP.IPSwapPatientBed;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import blipin.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPSwapPatientBed"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPSwapPatientBed"
*	local-jndi-name="IPSwapPatientBed"
*	impl-class-name="eIP.IPSwapPatientBed.IPSwapPatientBedManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPSwapPatientBed.IPSwapPatientBedLocal"
*	remote-class="eIP.IPSwapPatientBed.IPSwapPatientBedRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPSwapPatientBed.IPSwapPatientBedLocalHome"
*	remote-class="eIP.IPSwapPatientBed.IPSwapPatientBedHome"
*	generate= "local,remote"
*
*
*/
public class IPSwapPatientBedManager implements SessionBean 
{
	Connection con 			= null;
	PreparedStatement pstmt = null;
	Statement stmt 			= null;
	ResultSet srs 			= null;
	String locale			= "";
	long   encounterid1;
	long   encounterid2;
	StringBuffer strBuffer	  = new StringBuffer();
	PreparedStatement pstmtbl = null ;
	ResultSet rsetbl 		  = null;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}
	String patientgender1		 = "";
	String patientgender2		 = "";
	String speciality2			 = "";
	String speciality1			 = "";
	String gender1				 = "";
	String gender2				 = "";
	/**
	This method is used to swap beds of two patients.
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

	public HashMap insertIPSwapPatientBed(Properties p,HashMap hashData)
	{

		locale = p.getProperty("LOCALE");
		String facilityId			= (String)hashData.get("facilityId");
		String patientid1			= (String)hashData.get("patientid1");
		String patientid2			= (String)hashData.get("patientid2");
		String encounter_id1		= (String)hashData.get("encounterid1");
		String encounter_id2		= (String)hashData.get("encounterid2");				
		String admission_date_time1	= (String)hashData.get("admission_date_time1");				
		String admission_date_time2	= (String)hashData.get("admission_date_time2");				
		String practitioner_id1		= (String)hashData.get("practitioner_id1");
		String practitioner_id2		= (String)hashData.get("practitioner_id2");
		String specialty_code1		= (String)hashData.get("specialty_code1");
		String specialty_code2		= (String)hashData.get("specialty_code2");		
		String nursing_unit_type1	= (String)hashData.get("nursing_unit_type1");
		String nursing_unit_type2	= (String)hashData.get("nursing_unit_type2");
		String nursing_unit_code1	= (String)hashData.get("nursing_unit_code1");
		String nursing_unit_code2	= (String)hashData.get("nursing_unit_code2");
		String room_num1			= (String)hashData.get("room_num1");
		String room_num2			= (String)hashData.get("room_num2");
		String bed_num1				= (String)hashData.get("bed_num1");
		String bed_num2				= (String)hashData.get("bed_num2");					
		String service_code1		= (String)hashData.get("service_code1");
		String service_code2		= (String)hashData.get("service_code2");
		String bed_type_code1		= (String)hashData.get("bed_type_code1");
		String bed_type_code2		= (String)hashData.get("bed_type_code2");
		String bed_class_code1		= (String)hashData.get("bed_class_code1");
		String bed_class_code2		= (String)hashData.get("bed_class_code2");
		String team_id1				= (String)hashData.get("team_id1");
		String team_id2				= (String)hashData.get("team_id2");
		String patient_class1		= (String)hashData.get("patient_class1");
		String patient_class2		= (String)hashData.get("patient_class2");
		String bl_interfaced_yn		= (String)hashData.get("bl_interfaced_yn");
		String bl_operational		= (String)hashData.get("bl_operational");
			   patientgender1		= (String)hashData.get("hid_gender1");
			   patientgender2		= (String)hashData.get("hid_gender2");
		String mother_bed_status1	= (String)hashData.get("mother_bed_status1");
		String mother_bed_status2	= (String)hashData.get("mother_bed_status2");
		String transfer_wo_delink_yn	= (String)hashData.get("transfer_wo_delink_yn");//Added for the CRF - HSA-CRF-0035
		
		String strBLMessage			= "";
		String strBLSpecialMessage	= "";
		boolean boolBLInstall		= false;
		String blng_class_code1		= "";
		String blng_class_code2		= "";
		String blng_serv_code1		= "";
		String blng_serv_code2		= "";
		String bill_type_code1		= "";
		String bill_type_code2		= "";
		String fr_daily_rate1		= "";
		String fr_daily_rate2		= "";
		String to_daily_rate1		= "";
		String to_daily_rate2		= "";
		String fr_bed_type_code_by_defn1 = "";
		String fr_bed_type_code_by_defn2 = "";
		String to_bed_type_code_by_defn1 = "";
		String to_bed_type_code_by_defn2 = "";
		String addedAtWorkstation	= (String)hashData.get("client_ip_address");
		String transfertype			= (String)hashData.get("swap_contact_reason");
		HashMap results				= new HashMap() ;
		boolean result				= false ;
		StringBuffer sb = new StringBuffer("");
		results.put( "error", "no error" ) ;
		String addedById			 = p.getProperty( "login_user" ) ;
		String addedDate			 = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
		String modifiedDate = addedDate ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		java.sql.Date added_date	 = java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		StringBuffer sql = new StringBuffer("");		
		String sys_date  = "";
		String ext_num1				= "";
		String ext_num2				= "";
		int srlno1 = 0;
		int srlno2 = 0;
		int rs	   = 0;
		ArrayList<String> babyBedNo1=new ArrayList<String>();//Added for the CRF - HSA-CRF-0035
		ArrayList<String> babyBedNo2=new ArrayList<String>();//Added for the CRF - HSA-CRF-0035
		ArrayList<String> babyPatientId1=new ArrayList<String>();//Added for the CRF - HSA-CRF-0035		
		ArrayList<String> babyPatientId2=new ArrayList<String>();//Added for the CRF - HSA-CRF-0035
		int babyCount1=0;//Added for the CRF - HSA-CRF-0035
		int babyCount2=0;//Added for the CRF - HSA-CRF-0035
		
		int transferBabyCount1=0;//Added for this SCF ML-MMOH-SCF-0663
		int transferBabyCount2=0;//Added for this SCF ML-MMOH-SCF-0663
		
		
		try
		{
			encounterid1		= Long.parseLong(encounter_id1);
			encounterid2		= Long.parseLong(encounter_id2);
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			strBuffer.delete(0, strBuffer.length());
			strBuffer.append("select specialty_code specialty2, sex_spec_ind sex_spec_ind2, to_char(sysdate, 'dd/mm/rrrr hh24:mi') sys_date "); 
			strBuffer.append("from IP_NURSING_UNIT_BED where FACILITY_ID='"+facilityId+"' and "); strBuffer.append("NURSING_UNIT_CODE='"+nursing_unit_code2+"' and "); 
			strBuffer.append("BED_NO='"+bed_num2+"' and  BED_CLASS_CODE='"+bed_class_code2+"' and");
			strBuffer.append(" BED_TYPE_CODE='"+bed_type_code2+"' and ROOM_NO='"+room_num2+"'");
           
			try
			{
				stmt = con.createStatement();
				srs = stmt.executeQuery(strBuffer.toString());
				if(srs.next())
				{
					speciality2 = srs.getString("SPECIALTY2")== null ? "" : srs.getString("SPECIALTY2");
					gender2 = srs.getString("SEX_SPEC_IND2")== null ? "" : srs.getString("SEX_SPEC_IND2");
					sys_date	   = srs.getString("sys_date")== null ? "" : srs.getString("sys_date");
				}
				if(srs!=null) srs.close();
				if(stmt!=null) stmt.close();
                
				if(!speciality2.equals(""))
				{
					if(!specialty_code1.equals(speciality2))
					{	
						Hashtable message1 = MessageManager.getMessage( locale, "BED_SPLTY_INVALID","IP");
						sb.append( (String) message1.get("message") ) ;
						result = false;
					}
					else
						result = true;
				}
				else
					result = true;

				if(result)
				{
					if(!gender2.equals(""))
					{
						if(!patientgender1.equals(gender2))
						{	
							Hashtable message1 = MessageManager.getMessage( locale,"AGE_GENDER_NOT_ALLOWED","IP" ) ;
							sb.append( (String) message1.get("message") ) ;
							result = false;
						}
						else
						result = true;
					}
					else
					result = true;
				}
			
			}catch(Exception e)
			{
				sb.append("Errors in selecting Specialty 1 "+e.toString());
				e.printStackTrace() ;
			}
			if(result)
			{
				strBuffer.delete(0, strBuffer.length());
				strBuffer.append("select specialty_code specialty1, sex_spec_ind sex_spec_ind1 "); strBuffer.append("from ip_nursing_unit_bed where FACILITY_ID='"+facilityId+"' and");
				strBuffer.append(" NURSING_UNIT_CODE='"+nursing_unit_code1+"' and "); strBuffer.append("BED_NO='"+bed_num1+"' and  BED_CLASS_CODE='"+bed_class_code1+"' and BED_TYPE_CODE='"+bed_type_code1+"' and ROOM_NO='"+room_num1+"'");
               
				try
				{
					stmt = con.createStatement();
					srs = stmt.executeQuery(strBuffer.toString());
				
					if(srs.next())
					{
						speciality1 = srs.getString("SPECIALTY1")==null?"":srs.getString("SPECIALTY1");
						gender1 = srs.getString("SEX_SPEC_IND1")==null?"":srs.getString("SEX_SPEC_IND1");
					}
					if(srs!=null) srs.close();
					if(stmt!=null) stmt.close();
					
					
					if(!speciality1.equals(""))
					{
						if(!specialty_code2.equals(speciality1))
						{   
							Hashtable message1 = MessageManager.getMessage(locale, "BED_SPLTY_INVALID","IP");
							sb.append((String) message1.get("message"));
							result = false;
						}
						else
							result = true;	
					}
					else
						result = true;	
					

					if(result)
					{
						if(!gender1.equals(""))
						{
							if(!patientgender2.equals(gender1))
							{	
								Hashtable message1 = MessageManager.getMessage( locale, "AGE_GENDER_NOT_ALLOWED","IP" ) ;
								sb.append( (String) message1.get("message") ) ;
								result = false;
							}
							else
								result = true;
						}
						else
							result = true;
					}
				}
				catch(Exception e)
				{
					sb.append("Errors in selecting Specialty 2 "+e.toString());
					e.printStackTrace() ;
				}
			}
			if(result)
			{

				if(!(room_num2 == null || room_num2.equals("") || room_num2.equals("null")))
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("select EXT_NUM from am_facility_room where OPERATING_FACILITY_ID='"+facilityId+"'  and ROOM_NUM='"+room_num2+"' ");
						
						pstmt = con.prepareStatement( sql.toString() );
						srs	= pstmt.executeQuery();

						if(srs.next())
						{
							ext_num2 = srs.getString("EXT_NUM") == null ? "" : srs.getString("ext_num");
						}

						if(pstmt!=null) pstmt.close();
						if(srs!=null) srs.close();			
				
					}
					
				if(!(room_num1 == null || room_num1.equals("") || room_num1.equals("null")))
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("select EXT_NUM from am_facility_room where OPERATING_FACILITY_ID='"+facilityId+"'  and ROOM_NUM='"+room_num1+"' ");
						
						pstmt = con.prepareStatement( sql.toString() );
						srs	= pstmt.executeQuery();

						if(srs.next())
						{
							ext_num1 = srs.getString("EXT_NUM") == null ? "" : srs.getString("ext_num");
						}

						if(pstmt!=null) pstmt.close();
						if(srs!=null) srs.close();			
				
					}		

				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" update pr_encounter set assign_care_locn_type=?, assign_care_locn_code=?, assign_room_num= ? , assign_bed_num = ?, service_code = ? , ROOM_TEL_EXT_NUM = ? ");
				//updating audit columns
				sql.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
				sql.append(" where facility_id= ? and encounter_id = ? ");

				pstmt = con.prepareStatement( sql.toString() );
				pstmt.setString	( 1, nursing_unit_type2 ) ;
				pstmt.setString	( 2, nursing_unit_code2 ) ;
				pstmt.setString	( 3, room_num2 ) ;
				pstmt.setString	( 4, bed_num2 ) ;
				pstmt.setString ( 5, service_code2);
				pstmt.setString ( 6, ext_num2);
				pstmt.setString	( 7, facilityId) ;
				pstmt.setString	( 8, addedById);
				pstmt.setString	( 9, addedAtWorkstation);
				
				pstmt.setString	( 10, facilityId ) ;
				pstmt.setLong	( 11, encounterid1 ) ;
				rs = pstmt.executeUpdate() ;
				if(rs > 0)
					result = true;
				else
					result = false;
				if(pstmt!=null) pstmt.close();
				if (result)
				{		
					
					pstmt = con.prepareStatement( sql.toString());
					pstmt.setString	( 1, nursing_unit_type1 ) ;
					pstmt.setString	( 2, nursing_unit_code1 ) ;
					pstmt.setString	( 3, room_num1 ) ;
					pstmt.setString	( 4, bed_num1 ) ;
					pstmt.setString ( 5, service_code1);
					pstmt.setString ( 6, ext_num1);
					pstmt.setString	( 7, facilityId) ;
					pstmt.setString	( 8, addedById);
					pstmt.setString	( 9, addedAtWorkstation);
					
					pstmt.setString	( 10, facilityId ) ;
					pstmt.setLong	( 11, encounterid2 ) ;
					rs = pstmt.executeUpdate() ;
					if(rs > 0)
						result = true;
					else
						result = false;
				}
				if(pstmt!=null) pstmt.close();
				String L_practitioner_transfer = "";
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select srl_no,blng_class_code, blng_serv_code, bill_type_code, fr_daily_rate, to_daily_rate, fr_bed_type_code_by_defn, to_bed_type_code_by_defn from IP_ADT_TRN where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid1+"' and srl_no = (SELECT MAX (srl_no) FROM IP_ADT_TRN WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid1+"')");

				stmt   = con.createStatement();
				srs = stmt.executeQuery(sql.toString());
				if(srs.next())
				{
					srlno1						= srs.getInt("srl_no")+1;
					blng_class_code1			= srs.getString("blng_class_code");
					blng_serv_code1				= srs.getString("blng_serv_code");
					bill_type_code1				= srs.getString("bill_type_code");
					fr_daily_rate1				= srs.getString("fr_daily_rate");
					to_daily_rate1				= srs.getString("to_daily_rate");
					fr_bed_type_code_by_defn1	= srs.getString("fr_bed_type_code_by_defn");
					to_bed_type_code_by_defn1	= srs.getString("to_bed_type_code_by_defn");
				}
				if(srs!=null)	srs.close();
				if(stmt!=null)  stmt.close();
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select srl_no, blng_class_code, blng_serv_code, bill_type_code, fr_daily_rate, to_daily_rate, fr_bed_type_code_by_defn, to_bed_type_code_by_defn from IP_ADT_TRN where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid2+"' and srl_no = (SELECT MAX (srl_no) FROM ip_adt_trn WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid2+"') ");
			
				stmt   = con.createStatement();
				srs = stmt.executeQuery(sql.toString());
				if(srs.next())
				{
					srlno2 						= srs.getInt("srl_no")+1;
					blng_class_code2			= srs.getString("blng_class_code");
					blng_serv_code2				= srs.getString("blng_serv_code");
					bill_type_code2				= srs.getString("bill_type_code");
					fr_daily_rate2				= srs.getString("fr_daily_rate");
					to_daily_rate2				= srs.getString("to_daily_rate");
					fr_bed_type_code_by_defn2	= srs.getString("fr_bed_type_code_by_defn");
					to_bed_type_code_by_defn2	= srs.getString("to_bed_type_code_by_defn");
				}
				if(srs!=null)	srs.close();
				if(stmt!=null)  stmt.close();
				if(!practitioner_id2.equals(practitioner_id1))
					L_practitioner_transfer = "Y";
				else
					L_practitioner_transfer = "N";
				int res = 0;
				if (bl_interfaced_yn.equals("Y") && bl_operational.equals("Y"))
				{
					if(result)
					{			
					try
						{
							if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
							strBuffer.append("  update IP_ADT_TRN set trn_to_date_time = sysdate ");
							//updating audit columns
							strBuffer.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
							strBuffer.append( facilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
							strBuffer.append(" where srl_no = ('"+srlno1+"' - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid1+"' ");
			
							if(pstmt !=null) pstmt.close();
							pstmt = con.prepareStatement(strBuffer.toString());
							pstmt.executeUpdate();

							if(pstmt !=null) pstmt.close();
						
						}catch(Exception ex)
						{
							result = false;
							sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
							ex.printStackTrace() ;
						}
					}

					if(result)
					{   int inc=1;
						strBuffer.delete(0, strBuffer.length());
						strBuffer.append("  insert into IP_ADT_TRN "); 
						strBuffer.append(" (facility_id,encounter_id,srl_no,patient_id,trn_type ");
						strBuffer.append(" ,trn_code,trn_date_time,to_nursing_unit,to_room_no,to_bed_no ");
						strBuffer.append("  ,to_bed_class_code,to_bed_type_code,to_practitioner_id,to_specialty_code ");
						strBuffer.append(" ,fr_nursing_unit_code,fr_room_no,fr_bed_no ");
						strBuffer.append(" ,fr_bed_class_code,fr_bed_type_code,fr_practitioner_id,fr_specialty_code ");
						strBuffer.append(" ,emergency_trn_yn, practitioner_tfr_yn");
						strBuffer.append(" ,added_by_id,		added_date   "	);
						strBuffer.append(" ,added_facility_id, added_at_ws_no " );
						strBuffer.append(" ,modified_by_id,	 modified_date " );
						strBuffer.append(" ,modified_facility_id,	modified_at_ws_no,from_pract_team_id,to_pract_team_id,fr_service_code,to_service_code,blng_class_code,blng_serv_code,bill_type_code, fr_daily_rate,to_daily_rate, fr_bed_type_code_by_defn, to_bed_type_code_by_defn, tfr_type, patient_class, admission_date_time " );
						strBuffer.append(" ) values ( ?, ?, ?, ?, ?, ?, sysdate,?,?,?, ?, ?,?, ?,?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:MI'))"); 

						
						if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement( strBuffer.toString() );
						pstmt.setString	( inc++, facilityId ) ;
						pstmt.setLong	( inc++, encounterid1 ) ;
						pstmt.setInt	( inc++, srlno1 ) ;
						pstmt.setString	( inc++, patientid1);
						pstmt.setString	( inc++, "T" ) ;
						pstmt.setString	( inc++, transfertype ) ;
						//pstmt.setString	( 7,  sys_date) ;
						pstmt.setString	( inc++, nursing_unit_code2 ) ;
						pstmt.setString	( inc++, room_num2 ) ;
						pstmt.setString	( inc++, bed_num2 ) ;
						pstmt.setString	( inc++, bed_class_code2 ) ;
						pstmt.setString	( inc++, bed_type_code2 ) ;
						pstmt.setString	( inc++, practitioner_id1 ) ;
						pstmt.setString	( inc++, specialty_code1 ) ;
						pstmt.setString	( inc++, nursing_unit_code1 ) ;
						pstmt.setString	( inc++, room_num1 ) ;
						pstmt.setString	( inc++, bed_num1 ) ;
						pstmt.setString	( inc++, bed_class_code1 ) ;
						pstmt.setString	( inc++, bed_type_code1 ) ;
						pstmt.setString	( inc++, practitioner_id1 ) ;
						pstmt.setString	( inc++, specialty_code1 ) ;
						pstmt.setString	( inc++, "Y" ) ;
						pstmt.setString	( inc++, L_practitioner_transfer ) ;
						pstmt.setString	( inc++, addedById);
						pstmt.setDate	( inc++, added_date ) ;
						pstmt.setString	( inc++, facilityId ) ;
						pstmt.setString	( inc++, addedAtWorkstation ) ;
						pstmt.setString	( inc++, modifiedById ) ;
						//pstmt.setDate	( 29, modified_date ) ;
						pstmt.setString	( inc++, facilityId ) ;
						pstmt.setString	( inc++, modifiedAtWorkstation ) ;
						pstmt.setString	( inc++, team_id1 ) ;
						pstmt.setString	( inc++, team_id2 ) ;
						pstmt.setString	( inc++, service_code1);
						pstmt.setString	( inc++, service_code2 ) ;
						pstmt.setString	( inc++, blng_class_code1 ) ;
						pstmt.setString	( inc++, blng_serv_code1 ) ;
						pstmt.setString	( inc++, bill_type_code1 ) ;
						pstmt.setString	( inc++, fr_daily_rate1 ) ;
						pstmt.setString	( inc++, to_daily_rate1 ) ;
						pstmt.setString	( inc++, fr_bed_type_code_by_defn1 ) ;
						pstmt.setString	( inc++, to_bed_type_code_by_defn1 ) ;
						pstmt.setString	( inc++, "S" ) ;
						pstmt.setString	( inc++, patient_class1);
						pstmt.setString	( inc++, admission_date_time1);
						res = pstmt.executeUpdate() ;
						if(res > 0) result = true; else result = false;
						if (result)
						{
							try
							{
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
								strBuffer.append("  update IP_ADT_TRN set trn_to_date_time = sysdate ");
								//updating audit columns
								strBuffer.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
								strBuffer.append( facilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
								strBuffer.append(" where srl_no = ('"+srlno2+"' - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid2+"' ");
											
								if(pstmt !=null) pstmt.close();
								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.executeUpdate();

								if(pstmt !=null) pstmt.close();
							
							}catch(Exception ex)
							{
								result = false;
								sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
								ex.printStackTrace() ;
							}
						}

						if (result)
						{   int inct=1;
							strBuffer.delete(0, strBuffer.length());
							strBuffer.append("  insert into IP_ADT_TRN "); 
							strBuffer.append(" (facility_id,encounter_id,srl_no,patient_id,trn_type ");
							strBuffer.append(" ,trn_code,trn_date_time,to_nursing_unit,to_room_no,to_bed_no ");
							strBuffer.append(" ,to_bed_class_code,to_bed_type_code,to_practitioner_id,to_specialty_code ");
							strBuffer.append(" ,fr_nursing_unit_code,fr_room_no,fr_bed_no ");
							strBuffer.append(" ,fr_bed_class_code,fr_bed_type_code,fr_practitioner_id,fr_specialty_code ");
							strBuffer.append(" ,emergency_trn_yn, practitioner_tfr_yn");
							strBuffer.append(" ,added_by_id,		added_date   "	);
							strBuffer.append(" ,added_facility_id, added_at_ws_no " );
							strBuffer.append(" ,modified_by_id,	 modified_date " );
							strBuffer.append(" ,modified_facility_id,	modified_at_ws_no,from_pract_team_id,to_pract_team_id,fr_service_code,to_service_code,blng_class_code,blng_serv_code,bill_type_code, fr_daily_rate,to_daily_rate, fr_bed_type_code_by_defn, to_bed_type_code_by_defn, tfr_type, patient_class, admission_date_time  " );
							strBuffer.append(" ) values ( ?, ?, ?, ?, ?, ?, sysdate,?,?,?, ?, ?,?, ?,?, ?, ?, ?, ?, ?,?,?, ?, ?,?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:MI') )" ) ;

							if(pstmt!=null) pstmt.close();
							pstmt = con.prepareStatement( strBuffer.toString() );

							pstmt.setString	( inct++, facilityId ) ;
							pstmt.setLong	( inct++, encounterid2 ) ;
							pstmt.setInt		( inct++, srlno2 ) ;
							pstmt.setString	( inct++, patientid2);
							pstmt.setString	( inct++, "T" ) ;
							pstmt.setString	( inct++, transfertype ) ;
							//pstmt.setString	( 7, sys_date ) ;
							pstmt.setString	( inct++, nursing_unit_code1 ) ;
							pstmt.setString	( inct++, room_num1 ) ;
							pstmt.setString	( inct++, bed_num1 ) ;
							pstmt.setString	( inct++, bed_class_code1 ) ;
							pstmt.setString	( inct++, bed_type_code1 ) ;
							pstmt.setString	( inct++, practitioner_id2 ) ;
							pstmt.setString	( inct++, specialty_code2 ) ;
							pstmt.setString	( inct++, nursing_unit_code2 ) ;
							pstmt.setString	( inct++, room_num2 ) ;
							pstmt.setString	( inct++, bed_num2 ) ;
							pstmt.setString	( inct++, bed_class_code2 ) ;
							pstmt.setString	( inct++, bed_type_code2 ) ;
							pstmt.setString	( inct++, practitioner_id2 ) ;
							pstmt.setString	( inct++, specialty_code2 ) ;
							pstmt.setString	( inct++, "Y" ) ;
							pstmt.setString	( inct++, L_practitioner_transfer ) ;
							pstmt.setString	( inct++, addedById);
							pstmt.setDate	( inct++, added_date ) ;
							pstmt.setString	( inct++, facilityId ) ;
							pstmt.setString	( inct++, addedAtWorkstation ) ;
							pstmt.setString	( inct++, modifiedById ) ;
							pstmt.setDate	( inct++, modified_date ) ;
							pstmt.setString	( inct++, facilityId ) ;
							pstmt.setString	( inct++, modifiedAtWorkstation ) ;
							pstmt.setString	( inct++, team_id2 ) ;
							pstmt.setString	( inct++, team_id1 ) ;
							pstmt.setString	( inct++, service_code2);
							pstmt.setString	( inct++, service_code1 ) ;
							pstmt.setString	( inct++, blng_class_code2 ) ;
							pstmt.setString	( inct++, blng_serv_code2 ) ;
							pstmt.setString	( inct++, bill_type_code2 ) ;
							pstmt.setString	( inct++, fr_daily_rate2 ) ;
							pstmt.setString	( inct++, to_daily_rate2 ) ;
							pstmt.setString	( inct++, fr_bed_type_code_by_defn2 );
							pstmt.setString	( inct++, to_bed_type_code_by_defn2 );
							pstmt.setString	( inct++, "S" );
							pstmt.setString	( inct++, patient_class2);
							pstmt.setString	( inct++, admission_date_time2 );
							res = pstmt.executeUpdate() ;
							if(res > 0) result = true; else result = false;
						}
					}
				}
				else
				{

					if(result)
					{			
						try
						{
							if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
							strBuffer.append("  update IP_ADT_TRN set trn_to_date_time = sysdate ");
							//updating audit columns
							strBuffer.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
							strBuffer.append( facilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
							strBuffer.append(" where srl_no = ('"+srlno1+"' - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid1+"' ");
							
							if(pstmt !=null) pstmt.close();
							pstmt = con.prepareStatement(strBuffer.toString());
							pstmt.executeUpdate();

							if(pstmt !=null) pstmt.close();
						
						}catch(Exception ex)
						{
							result = false;
							sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
							ex.printStackTrace() ;
						}
					}

					if(result)
					{	
					    int incd=1;
						strBuffer.delete(0, strBuffer.length());
						strBuffer.append("  insert into ip_adt_trn "); 
						strBuffer.append(" (facility_id,encounter_id,srl_no,patient_id,trn_type ");
						strBuffer.append(" , trn_code, trn_date_time, to_nursing_unit, to_room_no, to_bed_no ");
						strBuffer.append("  , to_bed_class_code, to_bed_type_code, to_practitioner_id, to_specialty_code");
						strBuffer.append(" ,fr_nursing_unit_code, fr_room_no,fr_bed_no ");
						strBuffer.append(" ,fr_bed_class_code, fr_bed_type_code, fr_practitioner_id, fr_specialty_code ");
						strBuffer.append(" ,emergency_trn_yn, practitioner_tfr_yn");
						strBuffer.append(" ,added_by_id, added_date ");
						strBuffer.append(" ,added_facility_id, added_at_ws_no ");
						strBuffer.append(" ,modified_by_id,	 modified_date ");
						strBuffer.append(" ,modified_facility_id,	modified_at_ws_no, from_pract_team_id, to_pract_team_id, fr_service_code, to_service_code, tfr_type, patient_class, admission_date_time " );
						strBuffer.append(" ) values ( ?, ?, ?, ?, ?, ?, sysdate,?,?,?, ?, ?,?, ?,?, ?, ?, ?, ?, ?,?,?, ?, ?,?, ?, ?, ?, sysdate, ?,?,?,?,?,?,?,?, to_date(?,'dd/mm/rrrr hh24:MI') )");

						if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement( strBuffer.toString() );

						pstmt.setString	( incd++, facilityId ) ;
						pstmt.setLong	( incd++, encounterid1 ) ;
						pstmt.setInt ( incd++, srlno1 ) ;
						pstmt.setString	( incd++, patientid1);
						pstmt.setString	( incd++, "T" ) ;
						pstmt.setString	( incd++, transfertype ) ;
						//pstmt.setString	( 7,  sys_date) ;
						pstmt.setString	( incd++, nursing_unit_code2 ) ;
						pstmt.setString	( incd++, room_num2 ) ;
						pstmt.setString	( incd++, bed_num2 ) ;
						pstmt.setString	( incd++, bed_class_code2 ) ;
						pstmt.setString	( incd++, bed_type_code2 ) ;
						pstmt.setString	( incd++, practitioner_id1 ) ;
						pstmt.setString	( incd++, specialty_code1 ) ;
						pstmt.setString	( incd++, nursing_unit_code1 ) ;
						pstmt.setString	( incd++, room_num1 ) ;
						pstmt.setString	( incd++, bed_num1 ) ;
						pstmt.setString	( incd++, bed_class_code1 ) ;
						pstmt.setString	( incd++, bed_type_code1 ) ;
						pstmt.setString	( incd++, practitioner_id1 ) ;
						pstmt.setString	( incd++, specialty_code1 ) ;
						pstmt.setString	( incd++, "Y" ) ;
						pstmt.setString	( incd++, L_practitioner_transfer ) ;
						pstmt.setString	( incd++, addedById);
						pstmt.setDate	( incd++, added_date ) ;
						pstmt.setString	( incd++, facilityId ) ;
						pstmt.setString	( incd++, addedAtWorkstation ) ;
						pstmt.setString	( incd++, addedById ) ;
						//pstmt.setDate	( 29, added_date ) ;
						pstmt.setString	( incd++, facilityId ) ;
						pstmt.setString	( incd++, addedAtWorkstation ) ;
						pstmt.setString	( incd++, team_id1 ) ;
						pstmt.setString	( incd++, team_id2 ) ;
						pstmt.setString	( incd++, service_code1);
						pstmt.setString	( incd++, service_code2 );
						pstmt.setString	( incd++, "S" );
						pstmt.setString	( incd++, patient_class1 );
						pstmt.setString	( incd++, admission_date_time1 );
						res = pstmt.executeUpdate() ;
						if(res > 0) result = true; else result = false;
						if(pstmt!=null)  pstmt.close();	
						if (result)
						{
							try
							{
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
								strBuffer.append("  update IP_ADT_TRN set trn_to_date_time = sysdate");
								//updating audit columns
								strBuffer.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
								strBuffer.append( facilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
								strBuffer.append(" where srl_no = ('"+srlno2+"' - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid2+"' ");

								if(pstmt !=null) pstmt.close();
								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.executeUpdate();

								if(pstmt !=null) pstmt.close();
							
							}catch(Exception ex)
							{
								result = false;
								sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
								ex.printStackTrace() ;
							}
						}

						if (result)
						{   int inc=1;
							strBuffer.delete(0, strBuffer.length());
							strBuffer.append("  insert into IP_ADT_TRN ");
							strBuffer.append(" (facility_id,encounter_id,srl_no,patient_id,trn_type ");
							strBuffer.append(" ,trn_code,trn_date_time,to_nursing_unit,to_room_no,to_bed_no ");
							strBuffer.append(" ,to_bed_class_code,to_bed_type_code,to_practitioner_id,to_specialty_code ");
							strBuffer.append(" ,fr_nursing_unit_code,fr_room_no,fr_bed_no ");
							strBuffer.append(" ,fr_bed_class_code,fr_bed_type_code,fr_practitioner_id,fr_specialty_code ");
							strBuffer.append(" ,emergency_trn_yn, practitioner_tfr_yn");
							strBuffer.append(" ,added_by_id,		added_date   "	);
							strBuffer.append(" ,added_facility_id, added_at_ws_no " );
							strBuffer.append(" ,modified_by_id,	 modified_date " );
							strBuffer.append(" ,modified_facility_id,	modified_at_ws_no,from_pract_team_id,to_pract_team_id,fr_service_code,to_service_code, tfr_type, patient_class, admission_date_time " );
							strBuffer.append(" ) values ( ?, ?, ?, ?, ?, ?, sysdate,?,?,?, ?, ?,?, ?,?, ?, ?, ?, ?, ?,?,?, ?, ?,?, ?, ?, ?, sysdate, ?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:MI'))" ) ;

							if(pstmt!=null) pstmt.close();
							pstmt = con.prepareStatement( strBuffer.toString() );

							pstmt.setString	( inc++, facilityId ) ;
							pstmt.setLong	( inc++, encounterid2 ) ;
							pstmt.setInt    ( inc++, srlno2 ) ;
							pstmt.setString	( inc++, patientid2);
							pstmt.setString	( inc++, "T" ) ;
							pstmt.setString	( inc++, transfertype ) ;
							//pstmt.setString	( 7, sys_date ) ;
							pstmt.setString	( inc++, nursing_unit_code1 ) ;
							pstmt.setString	( inc++, room_num1 ) ;
							pstmt.setString	( inc++, bed_num1 ) ;
							pstmt.setString	( inc++, bed_class_code1 ) ;
							pstmt.setString	( inc++, bed_type_code1 ) ;
							pstmt.setString	( inc++, practitioner_id2 ) ;
							pstmt.setString	( inc++, specialty_code2 ) ;
							pstmt.setString	( inc++, nursing_unit_code2 ) ;
							pstmt.setString	( inc++, room_num2 ) ;
							pstmt.setString	( inc++, bed_num2 ) ;
							pstmt.setString	( inc++, bed_class_code2 ) ;
							pstmt.setString	( inc++, bed_type_code2 ) ;
							pstmt.setString	( inc++, practitioner_id2 ) ;
							pstmt.setString	( inc++, specialty_code2 ) ;
							pstmt.setString	( inc++, "Y" ) ;
							pstmt.setString	( inc++, L_practitioner_transfer ) ;
							pstmt.setString	( inc++, addedById);
							pstmt.setDate	( inc++, added_date ) ;
							pstmt.setString	( inc++, facilityId ) ;
							pstmt.setString	( inc++, addedAtWorkstation ) ;
							pstmt.setString	( inc++, addedById ) ;
							//pstmt.setDate	( 29, added_date ) ;
							pstmt.setString	( inc++, facilityId ) ;
							pstmt.setString	( inc++, addedAtWorkstation ) ;
							pstmt.setString	( inc++, team_id2 ) ;
							pstmt.setString	( inc++, team_id1 ) ;
							pstmt.setString	( inc++, service_code2);
							pstmt.setString	( inc++, service_code1 ) ;
							pstmt.setString	( inc++, "S" ) ;
							pstmt.setString	( inc++, patient_class1 );
							pstmt.setString	( inc++, admission_date_time1 );
							res = pstmt.executeUpdate() ;
							if(res > 0) result = true; else result = false;
						}
						if(pstmt!=null)  pstmt.close();	
					}
				}
				int L_male_count1 = 0;
				int L_female_count1 = 0;
				int L_unknown_count1 = 0;
				int L_male_count2 = 0;
				int L_female_count2 = 0;
				int L_unknown_count2 = 0;
				if(patientgender1.equals("M")) L_male_count1 = 1;
				if(patientgender1.equals("F")) L_female_count1 = 1;
				if(patientgender1.equals("U")) L_unknown_count1 = 1;
				if(patientgender2.equals("M")) L_male_count2 = 1;
				if(patientgender2.equals("F")) L_female_count2 = 1;
				if(patientgender2.equals("U")) L_unknown_count2 = 1;
				if(result)
				{
					if(!room_num1.equals(room_num2))
					{
						strBuffer.delete(0, strBuffer.length());
						//Added Audit column
						strBuffer.append(" update ip_nursing_unit_room set ");
						strBuffer.append(" occ_male_bed_count = occ_male_bed_count+?, occ_female_bed_count = occ_female_bed_count+?, ");
						strBuffer.append(" occ_unknown_bed_count = occ_unknown_bed_count+? ,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ? ");
						strBuffer.append(" where facility_id=? and nursing_unit_code = ? and room_no = ? ");

						if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement(strBuffer.toString());
					
						pstmt.setInt ( 1, L_male_count2 ) ;
						pstmt.setInt ( 2, L_female_count2);
						pstmt.setInt ( 3, L_unknown_count2);
						//Added Audit column
						pstmt.setString	( 4, addedById);
						pstmt.setString	( 5, addedAtWorkstation);
						pstmt.setString	( 6, facilityId);
						
						pstmt.setString	( 7, facilityId);
						pstmt.setString	( 8, nursing_unit_code2 ) ;
						pstmt.setString	( 9, room_num2 ) ;
						pstmt.executeUpdate() ;
						if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement(strBuffer.toString());
						pstmt.setInt ( 1, L_male_count1 ) ;
						pstmt.setInt ( 2, L_female_count1);
						pstmt.setInt ( 3, L_unknown_count1);
						
						//Added Audit column -- Modified against HSA-SCF-0137
						pstmt.setString	( 4, addedById);
						pstmt.setString	( 5, addedAtWorkstation);
						pstmt.setString	( 6, facilityId);
						
						pstmt.setString	( 7, facilityId);
						pstmt.setString	( 8, nursing_unit_code1 ) ;
						pstmt.setString	( 9, room_num1 ) ;
						pstmt.executeUpdate() ;
						if(pstmt!=null)  pstmt.close();	
						strBuffer.delete(0, strBuffer.length());
						//Added Audit column
						strBuffer.append(" update ip_nursing_unit_room set ");
						strBuffer.append(" occ_male_bed_count = occ_male_bed_count-?, occ_female_bed_count = occ_female_bed_count-?, ");
						strBuffer.append(" occ_unknown_bed_count = occ_unknown_bed_count-? ,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ?");
						strBuffer.append(" where facility_id=? and nursing_unit_code = ? and room_no = ? ");
											
						pstmt = con.prepareStatement(strBuffer.toString());
						pstmt.setInt ( 1, L_male_count1 ) ;
						pstmt.setInt ( 2, L_female_count1);
						pstmt.setInt ( 3, L_unknown_count1);
						//Added Audit column
						pstmt.setString	( 4, addedById);
						pstmt.setString	( 5, addedAtWorkstation);
						pstmt.setString	( 6, facilityId);
						pstmt.setString	( 7, facilityId);
						pstmt.setString	( 8, nursing_unit_code1 ) ;
						pstmt.setString	( 9, room_num1 ) ;
						pstmt.executeUpdate() ;
						if(pstmt!=null)  pstmt.close();	
						pstmt = con.prepareStatement(strBuffer.toString());
						pstmt.setInt ( 1, L_male_count2 ) ;
						pstmt.setInt ( 2, L_female_count2);
						pstmt.setInt ( 3, L_unknown_count2);
						
						//Added Audit column -- Modified against HSA-SCF-0137
						pstmt.setString	( 4, addedById);
						pstmt.setString	( 5, addedAtWorkstation);
						pstmt.setString	( 6, facilityId);
						
						pstmt.setString	( 7, facilityId);
						pstmt.setString	( 8, nursing_unit_code2 ) ;
						pstmt.setString	( 9, room_num2 ) ;
						pstmt.executeUpdate() ;
						if(pstmt!=null)  pstmt.close();	
					}
				}
				if(result)
				{
					if((!nursing_unit_code1.equals(nursing_unit_code2)) || (!bed_num1.equals(bed_num2)))
					{
						//logic to link the baby back to the mother as part of the CRF - HSA-CRF-0035 -- start
						
						if(mother_bed_status1.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
							//Logic to retrieve number of babies linked with the mother1 as part of HSA-CRF-0035
							if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
							
							strBuffer.append("SELECT OCCUPYING_PATIENT_ID FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND mothers_patient_id = ?");
							pstmt = con.prepareStatement(strBuffer.toString());
							pstmt.setString	( 1, facilityId ) ;
							pstmt.setString	( 2, nursing_unit_code1);
							pstmt.setString	( 3, patientid1) ;
							srs = pstmt.executeQuery();
							while(srs.next())
							{
								babyPatientId1.add(srs.getString("OCCUPYING_PATIENT_ID"));
								babyCount1++;
							}
							if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();
							
							//for the babies linked with the mother, bed should be assigned. 
							//Step 1 - Retrieve baby Bed no from ip_nursing_unit_bed table for the second bed 
							if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
							/*strBuffer.append("SELECT bed_no FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND main_bed_no = ? AND current_status = 'A' and rownum <= ?");*/
							
							/*Above line commented and below line added for this SCF ML-MMOH-SCF-0663*/
							strBuffer.append("SELECT bed_no FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND main_bed_no = ? AND current_status = 'A' order by bed_no asc");
							
							pstmt = con.prepareStatement(strBuffer.toString());
							pstmt.setString	( 1, facilityId ) ;
							pstmt.setString	( 2, nursing_unit_code2);
							pstmt.setString	( 3, bed_num2) ;
							//pstmt.setInt	( 4, babyCount1) ; //Commented for this SCF ML-MMOH-SCF-0663
							srs = pstmt.executeQuery();
							//Below line modified for this SCF ML-MMOH-SCF-0663
							while(srs.next() && transferBabyCount1<babyCount1)
							{
							   //Below line added for this SCF ML-MMOH-SCF-0663
								babyBedNo1.add(srs.getString("bed_no")) ;
								transferBabyCount1++;
								//End this ML-MMOH-SCF-0663
							}
							
							if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();
						}
																							
							//logic to link the baby back to the mother as part of the CRF - HSA-CRF-0035 -- End
							
							//logic to link the baby back to the mother as part of the CRF - HSA-CRF-0035 -- start
							
							if(mother_bed_status2.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
								//Logic to retrieve number of babies linked with the mother2 as part of HSA-CRF-0035
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
								
								strBuffer.append("SELECT OCCUPYING_PATIENT_ID FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND mothers_patient_id = ?");
								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.setString	( 1, facilityId ) ;
								pstmt.setString	( 2, nursing_unit_code2);
								pstmt.setString	( 3, patientid2) ;
								srs = pstmt.executeQuery();
								while(srs.next())
								{
									babyPatientId2.add(srs.getString("OCCUPYING_PATIENT_ID"));
									babyCount2++;
								}
								if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();
								
								//for the babies linked with the mother, bed should be assigned. 
								//Step 1 - Retrieve baby Bed no from ip_nursing_unit_bed table for the first bed 
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
								/*strBuffer.append("SELECT bed_no FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND main_bed_no = ? AND current_status = 'A' and rownum <= ?");*/								
								/*Above line commented and below line added for this SCF ML-MMOH-SCF-0663*/
								strBuffer.append("SELECT bed_no FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND main_bed_no = ? AND current_status = 'A' order by bed_no asc");
								
								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.setString	( 1, facilityId ) ;
								pstmt.setString	( 2, nursing_unit_code1);
								pstmt.setString	( 3, bed_num1) ;
								//pstmt.setInt	( 4, babyCount2) ; //Commented for this SCF ML-MMOH-SCF-0663
								srs = pstmt.executeQuery();
								//Below line modified for this SCF ML-MMOH-SCF-0663
								while(srs.next() && transferBabyCount2<babyCount2)
								{
								    //Below line added for this SCF ML-MMOH-SCF-0663
									babyBedNo2.add(srs.getString("bed_no")) ;
									transferBabyCount2++;
								    //End this ML-MMOH-SCF-0663
								}
								
								if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();
							}
																								
								//logic to link the baby back to the mother as part of the CRF - HSA-CRF-0035 -- End
								
 						strBuffer.delete(0, strBuffer.length());
						try
						{
							strBuffer.append(" update ip_nursing_unit_bed set ");
							strBuffer.append("occupying_patient_id = null ");
							strBuffer.append(", occupied_until_date_time = null ");	
							strBuffer.append(", current_status = 'A', modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_by_id = '"+modifiedById+"', modified_at_ws_no = '"+modifiedAtWorkstation+"'");
							strBuffer.append(" where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursing_unit_code2+"' and"); 
							strBuffer.append(" bed_no = '"+bed_num2+"' ");

							if(pstmt!=null) pstmt.close();
							pstmt = con.prepareStatement(strBuffer.toString());
							pstmt.executeUpdate() ;
						}
						catch(Exception e)
						{
							result = false;

							

							sb.append("Transaction Failed");
							e.printStackTrace() ;
						}	
						strBuffer.delete(0, strBuffer.length());
						try
						{
							if(mother_bed_status2.equals("Y") && result)
							{
								strBuffer.append(" update IP_NURSING_UNIT_BED set ");
								strBuffer.append(" occupying_patient_id = ?, occupied_until_date_time = ?, mothers_patient_id = ?, ");
								strBuffer.append(" mothers_encounter_id = ?, current_status = 'A', modified_date = sysdate, ");
								strBuffer.append(" modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
								strBuffer.append(" where facility_id = ? and nursing_unit_code = ?  and main_bed_no = ?");
								if (pstmt != null)	pstmt.close();
								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.setString	( 1, null ) ;
								pstmt.setString	( 2, null ) ;
								pstmt.setString	( 3, null ) ;
								pstmt.setString	( 4, null ) ;
								pstmt.setString	( 5, facilityId);
								pstmt.setString	( 6, modifiedById) ;
								pstmt.setString	( 7, addedAtWorkstation) ;
								pstmt.setString	( 8, facilityId);		
								pstmt.setString	( 9, nursing_unit_code2 ) ;
								pstmt.setString	( 10, bed_num2 ) ;
								pstmt.executeUpdate() ;
							}
						}
						catch (Exception me1)
						{
							result = false;
							
							me1.printStackTrace() ;
						}
						
						strBuffer.delete(0, strBuffer.length());
						try
						{
							strBuffer.append(" update ip_nursing_unit_bed set ");
							strBuffer.append("occupying_patient_id = null ");
							strBuffer.append(", occupied_until_date_time = null ");	
							strBuffer.append(", current_status = 'A', modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_by_id = '"+modifiedById+"', modified_at_ws_no = '"+modifiedAtWorkstation+"'");
							strBuffer.append(" where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursing_unit_code1+"' and"); 
							strBuffer.append(" bed_no = '"+bed_num1+"' ");
						
							if(pstmt!=null)  pstmt.close();	
							pstmt = con.prepareStatement(strBuffer.toString());
							pstmt.executeUpdate() ;
						}
						catch(Exception e2)
						{
							result = false;
							
							sb.append("Transaction Failed");
							e2.printStackTrace() ;
						}
						strBuffer.delete(0, strBuffer.length());
						try
						{
							if(mother_bed_status1.equals("Y") && result)
							{
								strBuffer.append(" update IP_NURSING_UNIT_BED set ");
								strBuffer.append(" occupying_patient_id = ?, occupied_until_date_time = ?, mothers_patient_id = ?, ");
								strBuffer.append(" mothers_encounter_id = ?, current_status = 'A', modified_date = sysdate, ");
								strBuffer.append(" modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
								strBuffer.append(" where facility_id = ? and nursing_unit_code = ?  and main_bed_no = ?");
								if (pstmt != null)	pstmt.close();
								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.setString	( 1, null ) ;
								pstmt.setString	( 2, null ) ;
								pstmt.setString	( 3, null ) ;
								pstmt.setString	( 4, null ) ;
								pstmt.setString	( 5, facilityId);
								pstmt.setString	( 6, modifiedById) ;
								pstmt.setString	( 7, addedAtWorkstation) ;
								pstmt.setString	( 8, facilityId);		
								pstmt.setString	( 9, nursing_unit_code1 ) ;
								pstmt.setString	( 10, bed_num1 ) ;
								pstmt.executeUpdate() ;
							}
						}
						catch (Exception me2)
						{
							result = false;
							
							me2.printStackTrace() ;
						}
						if(result)
						{
							try
							{
								strBuffer.delete(0, strBuffer.length());
								strBuffer.append(" update ip_nursing_unit_bed set ");
								strBuffer.append(" occupying_patient_id = '"+patientid1+"', current_status='O', ");
								strBuffer.append(" modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_by_id = '"+modifiedById+"', modified_at_ws_no = '"+modifiedAtWorkstation+"' where  facility_id='"+facilityId+"' and nursing_unit_code = '"+nursing_unit_code2+"' and bed_no = '"+bed_num2+"'");
						
								if(pstmt!=null) pstmt.close();
								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.executeUpdate() ;
							}
							catch(Exception e1)
							{
								result = false;
								
								sb.append("Transaction Failed");
								e1.printStackTrace() ;
							}
							try
							{
								strBuffer.delete(0, strBuffer.length());
								strBuffer.append(" update ip_nursing_unit_bed set ");
								strBuffer.append(" occupying_patient_id = '"+patientid2+"', current_status='O', ");
								strBuffer.append(" modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_by_id = '"+modifiedById+"', modified_at_ws_no = '"+modifiedAtWorkstation+"' where  facility_id='"+facilityId+"' and nursing_unit_code = '"+nursing_unit_code1+"' and bed_no = '"+bed_num1+"'");
						
								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.executeUpdate() ;
							}catch(Exception e12)
							{
								result = false;
								
								sb.append("Transaction Failed");
								e12.printStackTrace() ;
							}
							
							//logic to update the destination baby beds for the crf - HSA-CRF-0035 -- start
							//Second baby bed is occupied for the first patient's baby
							if(mother_bed_status1.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
							try {
								for(int bcount=0;bcount<babyPatientId1.size();bcount++){
									
									if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
									
									strBuffer.append(" update ip_nursing_unit_bed set ");
								    strBuffer.append(" mothers_patient_id=?,mothers_encounter_id=?,current_status='O',occupying_patient_id = ?,modified_date=sysdate,modified_facility_id=?,modified_by_id=?,modified_at_ws_no=? ");
									strBuffer.append(" where facility_id=? and nursing_unit_code =?  and main_bed_no=? and bed_no=?");
									
									pstmt=con.prepareStatement(strBuffer.toString());
									
									pstmt.setString	( 1, patientid1); //Mother Patient id
									pstmt.setString	( 2, encounter_id1); // Mother Encounter id
									pstmt.setString	( 3, babyPatientId1.get(bcount)); // Baby Patient Id
									pstmt.setString	( 4, facilityId);
									pstmt.setString	( 5, addedById) ;
									pstmt.setString	( 6, addedAtWorkstation);
									pstmt.setString	( 7, facilityId);
									pstmt.setString	( 8, nursing_unit_code2);//Mother Nursing nuit
									pstmt.setString	( 9, bed_num2);  //Mother bed no
									pstmt.setString	( 10, babyBedNo1.get(bcount));  //Baby bed no
									int res4 = pstmt.executeUpdate() ;
									if(pstmt !=null) pstmt.close();
									if(res4 > 0) result = true; else result = false;
								}
							} catch (Exception ex) {
								sb.append("Exception in updating ip_nursing_unit_bed while updating the second destination baby beds : "+ex.toString());
								ex.printStackTrace();
							}
							}
							//Logic to relink the mother and the baby bed for the crf HSA-CRF-0035
							if(mother_bed_status1.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
							
							
							try {
								strBuffer.append(" update ip_open_encounter set ");
								strBuffer.append("BABY_DELINKED_YN='N' ");
								strBuffer.append(", modified_by_id = ? ,modified_at_ws_no = ?, modified_date = sysdate,modified_facility_id = ? ");
								strBuffer.append(" where facility_id=? and ENCOUNTER_ID = ?");
								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.setString	( 1, addedById) ;
								pstmt.setString	( 2, addedAtWorkstation);
								pstmt.setString	( 3, facilityId);
								pstmt.setString	( 4, facilityId);
								pstmt.setString	( 5, encounter_id1); //mother encounter id
								int res4 = pstmt.executeUpdate() ;
								if(pstmt !=null) pstmt.close();
								if(res4 > 0) result = true; else result = false;
							} catch (Exception ex) {
								sb.append("Exception in updating ip_open_encounter while relinking the second mother and its baby bed :  "+ex.toString());
								ex.printStackTrace();
							}
							}
							//logic to update the destination baby beds for the crf - HSA-CRF-0035 -- End
							
							//logic to update the destination baby beds for the crf - HSA-CRF-0035 -- start
							//Second baby bed is occupied for the first patient's baby
							if(mother_bed_status2.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
							try {
								for(int bcount=0;bcount<babyPatientId2.size();bcount++){
									
									if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
									
									strBuffer.append(" update ip_nursing_unit_bed set ");
								    strBuffer.append(" mothers_patient_id=?,mothers_encounter_id=?,current_status='O',occupying_patient_id = ?,modified_date=sysdate,modified_facility_id=?,modified_by_id=?,modified_at_ws_no=? ");
									strBuffer.append(" where facility_id=? and nursing_unit_code =?  and main_bed_no=? and bed_no=?");
									
									pstmt=con.prepareStatement(strBuffer.toString());
									
									pstmt.setString	( 1, patientid2); //Mother Patient id
									pstmt.setString	( 2, encounter_id2); // Mother Encounter id
									pstmt.setString	( 3, babyPatientId2.get(bcount)); // Baby Patient Id
									pstmt.setString	( 4, facilityId);
									pstmt.setString	( 5, addedById) ;
									pstmt.setString	( 6, addedAtWorkstation);
									pstmt.setString	( 7, facilityId);
									pstmt.setString	( 8, nursing_unit_code1);//Mother Nursing nuit
									pstmt.setString	( 9, bed_num1);  //Mother bed no
									pstmt.setString	( 10, babyBedNo2.get(bcount));  //Baby bed no
									int res4 = pstmt.executeUpdate() ;
									if(pstmt !=null) pstmt.close();
									if(res4 > 0) result = true; else result = false;
								}
							} catch (Exception ex) {
								sb.append("Exception in updating ip_nursing_unit_bed while updating the first destination baby beds : "+ex.toString());
								ex.printStackTrace();
							}
							}
							//Logic to relink the mother and the baby bed for the crf HSA-CRF-0035
							if(mother_bed_status2.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
							
							
							try {
								strBuffer.append(" update ip_open_encounter set ");
								strBuffer.append("BABY_DELINKED_YN='N' ");
								strBuffer.append(", modified_by_id = ? ,modified_at_ws_no = ?, modified_date = sysdate,modified_facility_id = ? ");
								strBuffer.append(" where facility_id=? and ENCOUNTER_ID = ?");
								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.setString	( 1, addedById) ;
								pstmt.setString	( 2, addedAtWorkstation);
								pstmt.setString	( 3, facilityId);
								pstmt.setString	( 4, facilityId);
								pstmt.setString	( 5, encounter_id2); //mother encounter id
								int res4 = pstmt.executeUpdate() ;
								if(pstmt !=null) pstmt.close();
								if(res4 > 0) result = true; else result = false;
							} catch (Exception ex) {
								sb.append("Exception in updating ip_open_encounter while relinking the first mother and its baby bed :  "+ex.toString());
								ex.printStackTrace();
							}
							}
							//logic to update the destination baby beds for the crf - HSA-CRF-0035 -- End
						}
					}
				}
				try
				{
					// Find whether billing was installed or not
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
					exceptionBL.printStackTrace() ;
				}

				
				if (boolBLInstall && result)
				{
					try
					{
						Hashtable hashtableBill = new Hashtable();
						hashtableBill.put("facilityId",facilityId);
						hashtableBill.put("patientid",patientid1);
						hashtableBill.put("transferdate",sys_date);
						hashtableBill.put("transfertype",transfertype);
						hashtableBill.put("topractitionerid",practitioner_id1);
						hashtableBill.put("tospecialitycode",specialty_code1);
						hashtableBill.put("tobedclass",bed_class_code2);
						hashtableBill.put("tobedtype",bed_type_code2);
						hashtableBill.put("tonursingunitcode",nursing_unit_code1);
						hashtableBill.put("toservicecode",service_code1);
						//	hashtableBill.put("tosubservcode",tosubservcode);
						hashtableBill.put("tobedno",bed_num2);
						hashtableBill.put("toroomno",room_num2);
						hashtableBill.put("frpractitionerid",practitioner_id1);
						hashtableBill.put("frspecialitycode",specialty_code1);
						hashtableBill.put("frbedclass",bed_class_code1);
						hashtableBill.put("frnursingunitcode",nursing_unit_code1);
						hashtableBill.put("frservicecode",service_code1);
						//		hashtableBill.put("frsubservcode",frsubservcode);
						hashtableBill.put("frbedno",bed_num1);
						hashtableBill.put("frroomno",room_num1);
						hashtableBill.put("frbedtype",bed_type_code1);
						hashtableBill.put("addedAtWorkstation",addedAtWorkstation);
						hashtableBill.put("bl_interface_yn",bl_interfaced_yn);
						hashtableBill.put("encounter_id",encounter_id1);
						hashtableBill.put("frteamid",team_id1);
						hashtableBill.put("toteamid",team_id1);
						hashtableBill.put("addedById",addedById);
						hashtableBill.put("episode_id",encounter_id1);
						hashtableBill.put("srlno",srlno1+"");
						hashtableBill.put("episode_type",patient_class1);
						hashtableBill.put("module_id",patient_class1);

						// If billing installed called this method
						BLIPTransfer blipTransfer = new BLIPTransfer();
						Hashtable resultsBL = blipTransfer.billPatientService(p, con,hashtableBill);
						boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
						result = boolRes;
						strBLMessage = "";
						if (boolRes == false)
						{
							result  = false;
							sb.append((String)resultsBL.get("error"));
						}
						if (boolRes == true)
						{
							result = true;
							strBLMessage = (String) resultsBL.get("message");
							strBLSpecialMessage = (String) resultsBL.get("bl_special_message");
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

						if(result)
						{
							Hashtable hashtableBill1 = new Hashtable();
							hashtableBill1.put("facilityId",facilityId);
							hashtableBill1.put("patientid",patientid2);
							hashtableBill1.put("transferdate",sys_date);
							hashtableBill1.put("transfertype",transfertype);
							hashtableBill1.put("topractitionerid",practitioner_id2);
							hashtableBill1.put("tospecialitycode",specialty_code2);
							hashtableBill1.put("tobedclass",bed_class_code1);
							hashtableBill1.put("tobedtype",bed_type_code1);
							hashtableBill1.put("tonursingunitcode",nursing_unit_code2);
							hashtableBill1.put("toservicecode",service_code2);
						//	hashtableBill1.put("tosubservcode",tosubservcode);
							hashtableBill1.put("tobedno",bed_num1);
							hashtableBill1.put("toroomno",room_num1);
							hashtableBill1.put("frpractitionerid",practitioner_id2);
							hashtableBill1.put("frspecialitycode",specialty_code2);
							hashtableBill1.put("frbedclass",bed_class_code2);
							hashtableBill1.put("frnursingunitcode",nursing_unit_code2);
							hashtableBill1.put("frservicecode",service_code2);
					//		hashtableBill1.put("frsubservcode",frsubservcode);
							hashtableBill1.put("frbedno",bed_num2);
							hashtableBill1.put("frroomno",room_num2);
							hashtableBill1.put("frbedtype",bed_type_code2);
							hashtableBill1.put("addedAtWorkstation",addedAtWorkstation);
							hashtableBill1.put("bl_interface_yn",bl_interfaced_yn);
							hashtableBill1.put("encounter_id",encounter_id2);
							hashtableBill1.put("frteamid",team_id2);
							hashtableBill1.put("toteamid",team_id2);
							hashtableBill1.put("addedById",addedById);
							hashtableBill1.put("episode_id",encounter_id2);
							hashtableBill1.put("srlno",srlno2+"");
							hashtableBill1.put("episode_type",patient_class2);
							hashtableBill1.put("module_id",patient_class2);
							
							// If billing installed called this method
							resultsBL = blipTransfer.billPatientService(p, con,hashtableBill1);
							boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
							result = boolRes;
							strBLMessage = "";

							if (boolRes == false)
							{
								result  = false;
								sb.append((String)resultsBL.get("error"));
							}
							if (boolRes == true)
							{
								result = true;
								strBLMessage = (String) resultsBL.get("message");
								strBLSpecialMessage = (String) resultsBL.get("bl_special_message");
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
						//Billing Related part starts here
					}
					catch(Exception exceptionBL)
					{
						sb.append("Error in blipTransfer "+exceptionBL.toString());
						result = false;
						exceptionBL.printStackTrace() ;
					}
				}

				//		insertable=true;
				if (( res != 0 ) && (result))
				{
					result = true ;							
					Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
					sb.append((String) message.get("message"));
					con.commit();
				}
				else
				{
					result = false ;
					//java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
					//sb.append((String) message.get("message"));
					con.rollback();
				}
			}
			else
				con.rollback();
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			
			
		}
		catch ( Exception e ) 
		{
			sb.append( e.getMessage()  ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}
			catch(Exception e1){}
		}
		finally 
		{
			try
			{
				if(pstmt != null)		pstmt.close() ;
				if(stmt != null)		stmt.close();
				if(srs != null)		srs.close();
				if(pstmtbl != null)	pstmtbl.close();
				if(rsetbl != null)	rsetbl.close();
			}
			catch(Exception ce){}
			if(con != null) ConnectionManager.returnConnection(con,p);
		}
		
		return results ;
	}
} // end session bean
