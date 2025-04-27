/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used records leave for inpatients..
@author - 
@version - V3
*/
package eIP.IPRecordInpatientLeave;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPRecordInpatientLeave"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPRecordInpatientLeave"
*	local-jndi-name="IPRecordInpatientLeave"
*	impl-class-name="eIP.IPRecordInpatientLeave.IPRecordInpatientLeaveManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPRecordInpatientLeave.IPRecordInpatientLeaveManagerLocal"
*	remote-class="eIP.IPRecordInpatientLeave.IPRecordInpatientLeaveManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPRecordInpatientLeave.IPRecordInpatientLeaveManagerLocalHome"
*	remote-class="eIP.IPRecordInpatientLeave.IPRecordInpatientLeaveManagerHome"
*	generate= "local,remote"
*
*
*/
public class IPRecordInpatientLeaveManager implements SessionBean 
{
	Connection	con ;
	PreparedStatement pstmt ;
	Statement stmt ;
	ResultSet rs					= null;
	String locale                   = "";
//	String srlno					= ""; 
//	String patientid				= "";
//	String nursingunitcode			= "";
//	String roomno					= "";
//	String bedno					= "";
//	String bedclasscode				= "";
//	String bedtypecode				= "";
	String dlycharge				= "";
//	String specialtycode			= "";
	String to_bed_no				= "";
	String to_bed_class_code		= "";
	String to_bed_type_code			= "";
	String to_room_no				= "";
	String setup_bl_dtls_in_ip_yn	= "N";
	String genpseudobedno			= "";
//	String service_code				= "";
	String ABSCONDING_YN			= "N";
	int n_res						= 0;

	SessionContext ctx;

	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}

	/**
	This method is used to insert the leave details for an inpatient.
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

	public java.util.HashMap insertRecordInpatientLeave(java.util.Properties p,java.util.HashMap hashData)
	{
		String 		from_date			= (String)hashData.get("from_date");
		String		to_date				= (String)hashData.get("to_date");
		String 		remarks				= (String)hashData.get("remarks");
		String 		releasebed			= (String)hashData.get("releasebed");
		String 		practid				= (String)hashData.get("practid");
		String 		overrideyn			= (String)hashData.get("overrideyn");
		String		eid					= (String)hashData.get("encounterid");
		String		srlno				= (String)hashData.get("srl_no");
		String		patientid			= (String)hashData.get("patient_id");
		String		bedclasscode		= (String)hashData.get("bed_class_code");
		String		bedtypecode			= (String)hashData.get("bed_type_code");
		String		service_code		= (String)hashData.get("service_code");
		String		roomno				= (String)hashData.get("room_no");
		String		bedno				= (String)hashData.get("bedno");
		String		specialtycode		= (String)hashData.get("specialtycode");
		
		String		addedFacilityId		= (String)hashData.get("facilityId");
		String		addedAtWorkstation	= (String)hashData.get("client_ip_address");
		String		pseudobed			= (String)hashData.get("pseudobed");
		String		nursingunit			= (String)hashData.get("nursingunit");
		
		String		generatepseudobed	= (String)hashData.get("generatepseudobed");
		String		record_status		= (String)hashData.get("record_status");
		String		reported_to			= (String)hashData.get("reported_to");
		String		informed_to			= (String)hashData.get("informed_to");
		String		informed_name		= (String)hashData.get("informed_name");
		String		informed_date		= (String)hashData.get("informed_date");
		String		pol_rep_no			= (String)hashData.get("pol_rep_no");
		String		pol_stn_id			= (String)hashData.get("pol_stn_id");
		String		pol_id				= (String)hashData.get("pol_id");
		setup_bl_dtls_in_ip_yn			= (String)hashData.get("setup_bl_dtls_in_ip_yn");
		String		peudobed_val		= (String)hashData.get("peudobed_val");
		String		deactivate_pseudoBed= (String)hashData.get("deactivate_pseudoBed");
		String		patient_class       = (String)hashData.get("patient_class");
		String		admission_date_time = (String)hashData.get("admission_date_time");
		String		release_reserve_bed_yn= (String)hashData.get("release_reserve_bed_yn");
		/*String		reserve_nursing_unit_code       = (String)hashData.get("reserve_nursing_unit_code");
		String		reserve_room_no = (String)hashData.get("reserve_room_no");
		String		reserve_bed_no	= (String)hashData.get("reserve_bed_no");*/

		String		no_of_record	= (String)hashData.get("no_of_record");
		int         no_of_reserve_bed = Integer.parseInt(no_of_record);
		
		long		encounterid			= Long.parseLong(eid);
		java.util.HashMap results		= new java.util.HashMap() ;
		boolean		result				= false ;
		StringBuffer messageBuffer		= new StringBuffer( "" ) ;
		StringBuffer sqlBuffer			= new StringBuffer( "" ) ;
		String		msg					= "";
		String		addedById			= p.getProperty( "login_user" ) ;
		String		ext_num				= "";

		try
		{
			locale = p.getProperty("LOCALE");
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			stmt = con.createStatement();
			boolean proceed = true;
			if(peudobed_val.equals("Pseudo Bed") && deactivate_pseudoBed.equals("Y"))
			{
				try
				{   //Added Audit column
					sqlBuffer.append(" update ip_nursing_unit_bed set PSUEDO_BED_STATUS = 'U' , MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+addedFacilityId+"' where ");
					sqlBuffer.append(" facility_id='"+addedFacilityId+"' and BED_NO = '"+pseudobed+"' ");
					stmt.executeUpdate(sqlBuffer.toString());

				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());

/*
			sqlBuffer.append("SELECT max(srl_no+1) srl_no from ip_adt_trn where ");
			sqlBuffer.append(" facility_id = '"+addedFacilityId+"' and encounter_id = '"+encounterid+"' ");			
			pstmt	= con.prepareStatement(sqlBuffer.toString());
			rs		= pstmt.executeQuery();
			if(rs.next())
				srlno = rs.getString("srl_no");		
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();


			if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
			sqlBuffer.append("SELECT patient_id, nursing_unit_code, room_num room_no, bed_num bed_no, bed_class_code, ");
			sqlBuffer.append(" bed_type_code, attend_practitioner_id practitioner_id, specialty_code, service_code from ip_open_encounter ");
			sqlBuffer.append(" where encounter_id = '"+encounterid+"' and facility_id = '"+addedFacilityId+"' ");

				
			pstmt = con.prepareStatement( sqlBuffer.toString() );
			rs   = pstmt.executeQuery();

			if(rs.next())
			{
				  patientid  	 	= checkForNull(rs.getString("patient_id"));
				  nursingunitcode	= checkForNull(rs.getString("nursing_unit_code"));
				  roomno  			= checkForNull(rs.getString("room_no"));
				  bedno  			= checkForNull(rs.getString("bed_no"));
				  bedclasscode  	= checkForNull(rs.getString("bed_class_code"));
				  bedtypecode  		= checkForNull(rs.getString("bed_type_code"));
				  specialtycode 	= checkForNull(rs.getString("specialty_code"));
				  service_code		= checkForNull(rs.getString("service_code")); // added on 06-10-2003 by dhanasekaran
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(stmt!=null) stmt.close();			
*/
			if(proceed)
			{
				
				if(releasebed.equals("Y"))
				{
					try
					{
						if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
						//Added Audit column
						sqlBuffer.append(" UPDATE ip_nursing_unit_bed SET ");
						sqlBuffer.append(" occupying_patient_id = null ,occupied_until_date_time = null,");
						sqlBuffer.append(" current_status='A', MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+addedFacilityId+"' WHERE ");
						sqlBuffer.append(" facility_id = ? and nursing_unit_code = ? and bed_no = ?");
						
						pstmt = con.prepareStatement( sqlBuffer.toString() );
						pstmt.setString ( 1,  addedFacilityId);
						pstmt.setString ( 2,  nursingunit );
						pstmt.setString ( 3,  bedno );

						n_res = pstmt.executeUpdate() ;
						
					
						if(n_res <= 0) proceed = false;
						
						if(pstmt!=null) pstmt.close();
					}
					catch(Exception e)
					{	
						proceed = false;
						messageBuffer.append( e.toString() + "<br>" ) ;
						e.printStackTrace();
					}
 					
					if(!generatepseudobed.equals("Y"))
					{
						try
						{
							if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
							//Added Audit column
							sqlBuffer.append(" UPDATE ip_nursing_unit_bed SET ");
							sqlBuffer.append(" occupying_patient_id = ? ,occupied_until_date_time = to_date('"+to_date+"','dd/mm/rrrr hh24:mi'),");
							sqlBuffer.append(" current_status='O' , MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+addedFacilityId+"' WHERE ");
							sqlBuffer.append(" facility_id = ? and nursing_unit_code = ? and bed_no = ?");

							pstmt = con.prepareStatement( sqlBuffer.toString() );
							pstmt.setString ( 1,  patientid);
							pstmt.setString ( 2,  addedFacilityId);
							pstmt.setString ( 3,  nursingunit );
							pstmt.setString ( 4,  pseudobed );

							n_res = pstmt.executeUpdate() ;
							
					
							if(n_res <= 0) proceed = false;
							if(pstmt!=null) pstmt.close();
						}catch(Exception e)
						{	
							e.printStackTrace();
							proceed = false;
							messageBuffer.append( e.toString() + "<br>" ) ;
						}
					}						

				}//E.O.IF releasebed='Y'

				
			}

			if(proceed)
			{
				if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
				
				if(!generatepseudobed.equals("Y"))
				{
					sqlBuffer.append("select  BED_NO, BED_CLASS_CODE, BED_TYPE_CODE, ROOM_NO from ip_nursing_unit_bed ");
					sqlBuffer.append(" where FACILITY_ID='"+addedFacilityId+"' and NURSING_UNIT_CODE='"+nursingunit+"' and bed_no='"+pseudobed+"' ");
				}
				else
				{

					if(genpseudobedno==null || genpseudobedno=="") genpseudobedno="";
					sqlBuffer.append("select  BED_NO, BED_CLASS_CODE, BED_TYPE_CODE, ROOM_NO from ip_nursing_unit_bed ");
					sqlBuffer.append(" where FACILITY_ID='"+addedFacilityId+"' and NURSING_UNIT_CODE='"+nursingunit+"' and bed_no='"+genpseudobedno+"' ");
				}
				
			
				if(stmt!=null) stmt.close();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sqlBuffer.toString());

				
				if(rs!=null )
				{
					if(rs.next())
					{
						to_bed_no			= rs.getString("BED_NO");
						to_bed_class_code	= rs.getString("BED_CLASS_CODE");
						to_bed_type_code	= rs.getString("BED_TYPE_CODE");
						to_room_no			= rs.getString("ROOM_NO");
					}
				}
				if(rs != null) rs.close();
				if(stmt!= null) stmt.close();
				if(releasebed.equals("N"))
				{
					to_room_no			= roomno;
					to_bed_no			= bedno;
					to_bed_class_code	= bedclasscode;
					to_bed_type_code	= bedtypecode;
				}

				 //end addition

				if(to_bed_no==null)			to_bed_no		  = "";
				if(to_bed_class_code==null) to_bed_class_code = "";
				if(to_bed_type_code==null)	to_bed_type_code  = "";
				if(to_room_no==null)		to_room_no		  = "";
	
				String OTH_ADT_STATUS	= "";
				String ip_leave_status	= "";
				if (record_status.equals("01"))
				{
					OTH_ADT_STATUS	= "1";
					ip_leave_status = "1";
					ABSCONDING_YN   = "N";
				}
				else	
				{
					OTH_ADT_STATUS	= "4";
					ip_leave_status = "4";
					ABSCONDING_YN   = "Y";
					if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
					sqlBuffer.append("select to_char((to_date('"+from_date+"','dd/mm/rrrr hh24:mi')+ABSCOND_GRACE_PERIOD/24),'dd/mm/rrrr hh24:mi') abs_def_exp_date ");
					sqlBuffer.append(" from ip_param where facility_id='"+addedFacilityId+"' ");
					if(stmt!=null) stmt.close();
					stmt = con.createStatement();
						
			
					rs = stmt.executeQuery(sqlBuffer.toString());

					if(rs!=null && rs.next()) {						
							to_date=rs.getString("abs_def_exp_date");						
					}
					if(rs != null) rs.close();
					if(stmt!= null) stmt.close();
				}
				try
				{

					if(!(to_room_no == null || to_room_no.equals("") || to_room_no.equals("null")))
					{
						if(sqlBuffer.length() > 0) sqlBuffer.delete(0,sqlBuffer.length());
						sqlBuffer.append("select EXT_NUM from am_facility_room where OPERATING_FACILITY_ID='"+addedFacilityId+"'  and ROOM_NUM='"+to_room_no+"' ");
						
						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
						pstmt = con.prepareStatement( sqlBuffer.toString() );
						rs	= pstmt.executeQuery();

						if(rs.next())
						{
							ext_num = rs.getString("EXT_NUM") == null ? "" : rs.getString("ext_num");
						}

						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();			
				
					}		

					if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
					if (record_status.equals("01"))
					{	
						sqlBuffer.append("UPDATE pr_encounter SET  ASSIGN_ROOM_NUM = '"+to_room_no+"' , ");
						sqlBuffer.append(" ASSIGN_BED_NUM = '"+to_bed_no+"', ip_leave_status = '"+ip_leave_status+"', ");
						sqlBuffer.append(" OTH_ADT_STATUS='"+OTH_ADT_STATUS+"', ");
						sqlBuffer.append(" LEAVE_EXPIRY_DATE_TIME = to_date('"+to_date+"','dd/mm/rrrr hh24:mi'),ROOM_TEL_EXT_NUM='"+ext_num+"' ");
						//sqlBuffer.append(" WHERE facility_id='"+addedFacilityId+"' and encounter_id = '"+encounterid+"'  ");
					}
					else
					{
						sqlBuffer.append( "UPDATE pr_encounter SET  ASSIGN_ROOM_NUM = '"+to_room_no+"' , ");
						sqlBuffer.append(" ASSIGN_BED_NUM = '"+to_bed_no+"', ip_leave_status = '"+ip_leave_status+"', ");
						sqlBuffer.append(" OTH_ADT_STATUS='"+OTH_ADT_STATUS+"', ROOM_TEL_EXT_NUM='"+ext_num+"'");
						/*Tuesday, February 09, 2010, IN019044 , to validate Grace period for Abscond Patient from IP Parameter*/
						sqlBuffer.append(" ,LEAVE_EXPIRY_DATE_TIME = to_date('"+to_date+"','dd/mm/rrrr hh24:mi')");
						//sqlBuffer.append("WHERE facility_id='"+addedFacilityId+"' ");
						//sqlBuffer.append(" and encounter_id = '"+encounterid+"'  ");
					}

					if(release_reserve_bed_yn.equals("Y") && no_of_reserve_bed > 0)
						sqlBuffer.append(", reserved_room_no='', reserved_nurs_unit_code='', reserved_bed_no='' ");
					
					sqlBuffer.append(", MODIFIED_BY_ID = '"+addedById+"' , MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = '"+addedAtWorkstation+"', MODIFIED_FACILITY_ID  = '"+addedFacilityId+"'  WHERE facility_id='"+addedFacilityId+"' and encounter_id = '"+encounterid+"'  ");

						
		
					if(stmt!=null) stmt.close();
					stmt = con.createStatement();
					int val = stmt.executeUpdate(sqlBuffer.toString());
					if(val > 0)		proceed = true;  else proceed = false;
				
				}catch(Exception e)
				{
					e.printStackTrace();
					proceed = false;
					messageBuffer.append( e.toString() + "<br>" ) ;
				}
			}
			if(proceed && release_reserve_bed_yn.equals("Y") && no_of_reserve_bed > 0)
			{

					if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
						sqlBuffer.append(" update IP_RESERVED_BED_DTL set RESERVED_TO_TIME = SYSDATE, MODIFIED_BY_ID = '"+addedById+"' , MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = '"+addedAtWorkstation+"', MODIFIED_FACILITY_ID  = '"+addedFacilityId+"' where FACILITY_ID = '"+addedFacilityId+"' and  ENCOUNTER_ID = '"+encounterid+"' and reserved_to_time is null ");
						try
						{
							pstmt  = con.prepareStatement(sqlBuffer.toString());
							n_res  = pstmt.executeUpdate() ;

							
							if(n_res <= 0) proceed = false;
							if(pstmt!=null) pstmt.close();	
						}
						catch(Exception e)
						{	
							e.printStackTrace();
							proceed = false;
							messageBuffer.append( e.toString() + "<br>" ) ;
						}
						
						if (sqlBuffer.length() > 0)	sqlBuffer.delete(0,sqlBuffer.length());
						if(proceed)
						{
								sqlBuffer.append(" update IP_BED_BOOKING set booking_status = '2' , ");
								sqlBuffer.append(" blocked_until_date_time = sysdate, modified_by_id='"+addedById+"',");
								sqlBuffer.append(" modified_date = sysdate,  modified_at_ws_no = '"+addedAtWorkstation+"',  modified_facility_id ='"+addedFacilityId+"'  ");
								//sqlBuffer.append(" where facility_id = '"+addedFacilityId+"' and encounter_id = '"+encounterid+"' and booking_type ='N'  and blocked_until_date_time IS null ");
								/*Thursday, September 09, 2010 , SRR20056-SCF-5168 [IN:023714] condition added or blocked_until_date_time > SYSDATE */
								sqlBuffer.append(" where facility_id = '"+addedFacilityId+"' and encounter_id = '"+encounterid+"' and booking_type ='N'  and ( BLOCKED_UNTIL_DATE_TIME IS NULL or blocked_until_date_time > SYSDATE) ");
								try
								{
									
									pstmt  = con.prepareStatement(sqlBuffer.toString());
									n_res  = pstmt.executeUpdate() ;
									if(n_res <= 0) proceed = false;
									if(pstmt!=null) pstmt.close();	
									
								}
								catch (Exception exp)
								{
									proceed = false;
									messageBuffer.append("Error in updating IP_BED_BOOKING "+exp.toString());
									exp.printStackTrace();
								}
						}
			}

			if(proceed)
			{
				
				if(setup_bl_dtls_in_ip_yn.equals("Y"))
				{
//-------------------ip_adt_trn starts-------
					try
					{
						if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
						sqlBuffer.append("  update IP_ADT_TRN set trn_to_date_time = sysdate " );
						//updating audit columns
						sqlBuffer.append(", modified_by_id = '" + addedById  + "', modified_date = sysdate, modified_facility_id = '");
						sqlBuffer.append( addedFacilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
						sqlBuffer.append(" where srl_no = ('"+srlno+"' - 1) and facility_id = '"+addedFacilityId+"' and encounter_id = '"+encounterid+"' ");
						if(pstmt !=null) pstmt.close();
						
						pstmt = con.prepareStatement(sqlBuffer.toString());
						pstmt.executeUpdate();

						if(pstmt !=null) pstmt.close();

					}catch(Exception ex)
					{
						ex.printStackTrace();
						proceed = false;
						messageBuffer.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
					}
//-------------------ip_adt_trn ends-------
					try
					{
						if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
						sqlBuffer.append("INSERT into ip_adt_trn(  facility_id, encounter_id,  	   ");
						sqlBuffer.append(" srl_no     , 			patient_id,	   	   ");
						sqlBuffer.append(" trn_type   ,			trn_date_time, 	   ");
						sqlBuffer.append(" fr_nursing_unit_code,	fr_room_no   , 	   ");
						sqlBuffer.append(" fr_bed_no , 			fr_bed_class_code, ");
						sqlBuffer.append(" fr_bed_type_code, 	fr_daily_rate,     ");
						sqlBuffer.append(" fr_practitioner_id,   fr_specialty_code, ");
						sqlBuffer.append(" added_by_id,		    added_date,        ");
						sqlBuffer.append(" added_facility_id,    added_at_ws_no,    ");
						sqlBuffer.append(" modified_by_id,	    modified_date,     ");
						sqlBuffer.append(" modified_facility_id,	modified_at_ws_no,  ");
						sqlBuffer.append(" TO_NURSING_UNIT,	TO_ROOM_NO, ");
						sqlBuffer.append(" TO_BED_NO,	TO_BED_CLASS_CODE, TO_BED_TYPE_CODE, fr_service_code, TFR_TYPE,TO_PRACTITIONER_ID,TO_SERVICE_CODE,TO_SPECIALTY_CODE,PATIENT_CLASS,ADMISSION_DATE_TIME ");
						sqlBuffer.append(" ) values ( ? ,? ,? ,? ,? , sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'))");
						
									
						pstmt = con.prepareStatement( sqlBuffer.toString() );
						pstmt.setString ( 1,  addedFacilityId);
						pstmt.setLong	( 2,  encounterid) ;
						pstmt.setString	( 3,  srlno) ;
						pstmt.setString	( 4,  patientid) ;
						pstmt.setString	( 5,  "L" ) ;
						pstmt.setString ( 6,  nursingunit );
						pstmt.setString ( 7,  roomno );
						pstmt.setString ( 8,  bedno );
						pstmt.setString ( 9,  bedclasscode );
						pstmt.setString ( 10, bedtypecode );
						pstmt.setString	( 11, dlycharge ) ;
						pstmt.setString	( 12, practid ) ;
						pstmt.setString	( 13, specialtycode ) ;
						pstmt.setString	( 14, addedById ) ;
						pstmt.setString	( 15, addedFacilityId ) ;
						pstmt.setString	( 16, addedAtWorkstation ) ;
						pstmt.setString	( 17, addedById ) ;
						pstmt.setString	( 18, addedFacilityId ) ;
						pstmt.setString	( 19, addedAtWorkstation ) ;
						pstmt.setString	( 20, nursingunit ) ;
						pstmt.setString	( 21, to_room_no ) ;
						pstmt.setString	( 22, to_bed_no ) ;
						pstmt.setString	( 23, to_bed_class_code ) ;
						pstmt.setString	( 24, to_bed_type_code ) ;
						pstmt.setString	( 25, service_code) ;
						pstmt.setString	( 26, "L") ;
						pstmt.setString	( 27, practid) ;
						pstmt.setString	( 28, service_code) ;
						pstmt.setString	( 29, specialtycode) ;
						pstmt.setString	( 30, patient_class) ;
						pstmt.setString	( 31, admission_date_time) ;
						n_res = pstmt.executeUpdate() ;
						if(n_res <= 0) proceed = false;

					}
					catch(Exception e1)
					{
						e1.printStackTrace();		
						proceed = false;
						messageBuffer.append( e1.toString() + "<br>" ) ;
					}
					if(pstmt!=null) pstmt.close();
				}
				else
				{

//-------------------ip_adt_trn starts-------
					try
					{
						if(sqlBuffer.length() > 0 ) sqlBuffer.delete(0,sqlBuffer.length());
						sqlBuffer.append("  update IP_ADT_TRN set trn_to_date_time = sysdate ");
						//updating audit columns
						sqlBuffer.append(", modified_by_id = '" + addedById  + "', modified_date = sysdate, modified_facility_id = '");
						sqlBuffer.append( addedFacilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
						sqlBuffer.append(" where srl_no = ('"+srlno+"' - 1) and facility_id = '"+addedFacilityId+"' and encounter_id = '"+encounterid+"' ");
						if(pstmt !=null) pstmt.close();
						
			
						pstmt = con.prepareStatement(sqlBuffer.toString());
						pstmt.executeUpdate();

						if(pstmt !=null) pstmt.close();

					}catch(Exception ex)
					{
						ex.printStackTrace();	
						proceed = false;
						messageBuffer.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
					}
//-------------------ip_adt_trn ends-------

					try
					{
						if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
						sqlBuffer.append("INSERT into IP_ADT_TRN( facility_id,encounter_id, ");
						sqlBuffer.append(" srl_no     , 			patient_id,	   	   ");
						sqlBuffer.append(" trn_type   ,			trn_date_time,    ");
						sqlBuffer.append(" fr_nursing_unit_code,	fr_room_no   , 	   ");
						sqlBuffer.append(" fr_bed_no , 			fr_bed_class_code, ");
						sqlBuffer.append(" fr_bed_type_code, 	 ");
						sqlBuffer.append(" fr_practitioner_id,   fr_specialty_code, ");
						sqlBuffer.append(" added_by_id,		    added_date,        ");
						sqlBuffer.append(" added_facility_id,    added_at_ws_no,    ");
						sqlBuffer.append(" modified_by_id,	    modified_date,     ");
						sqlBuffer.append(" modified_facility_id,	modified_at_ws_no,  ");
						sqlBuffer.append(" TO_NURSING_UNIT,	TO_ROOM_NO, ");
						sqlBuffer.append(" TO_BED_NO,	TO_BED_CLASS_CODE, TO_BED_TYPE_CODE, fr_service_code, TFR_TYPE,TO_PRACTITIONER_ID,TO_SERVICE_CODE,TO_SPECIALTY_CODE,PATIENT_CLASS,ADMISSION_DATE_TIME ");
						//sqlBuffer.append(" ) values ( ? ,? ,? ,? ,? , sysdate, ?, ?, ?, ?, ?, ?,  ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'))");
						sqlBuffer.append(" ) values ( ? ,? ,? ,? ,? , to_date(?,'dd/mm/rrrr hh24:mi'), ?, ?, ?, ?, ?, ?,  ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'))");
						
						
			
						pstmt = con.prepareStatement( sqlBuffer.toString() );
						pstmt.setString ( 1,  addedFacilityId);
						pstmt.setLong	( 2,  encounterid) ;
						pstmt.setString	( 3,  srlno) ;
						pstmt.setString	( 4,  patientid) ;
						pstmt.setString	( 5,  "L" ) ;
						pstmt.setString	( 6,  from_date ) ;
						pstmt.setString ( 7,  nursingunit );
						pstmt.setString ( 8,  roomno );
						pstmt.setString ( 9,  bedno );
						pstmt.setString ( 10,  bedclasscode );
						pstmt.setString ( 11, bedtypecode );
						pstmt.setString	( 12, practid ) ;
						pstmt.setString	( 13, specialtycode ) ;
						pstmt.setString	( 14, addedById ) ;
						pstmt.setString	( 15, addedFacilityId ) ;
						pstmt.setString	( 16, addedAtWorkstation ) ;
						pstmt.setString	( 17, addedById ) ;
						pstmt.setString	( 18, addedFacilityId ) ;
						pstmt.setString	( 19, addedAtWorkstation ) ;
						pstmt.setString	( 20, nursingunit ) ;
						pstmt.setString	( 21, to_room_no ) ;
						pstmt.setString	( 22, to_bed_no ) ;
						pstmt.setString	( 23, to_bed_class_code ) ;
						pstmt.setString	( 24, to_bed_type_code ) ;
						pstmt.setString	( 25, service_code) ;
						pstmt.setString	( 26, "L") ;
						pstmt.setString	( 27, practid) ;
						pstmt.setString	( 28, service_code) ;
						pstmt.setString	( 29, specialtycode) ;
						pstmt.setString	( 30, patient_class) ;
						pstmt.setString	( 31, admission_date_time) ;


						n_res = pstmt.executeUpdate() ;

									
			if(n_res <= 0) proceed = false;
					}catch(Exception e)
					{
						e.printStackTrace();
						proceed = false;
						messageBuffer.append( e.toString() + "<br>" ) ;
					}
					if(pstmt!=null) pstmt.close();
				}
			}
			/*INSERT the ip_leave_detail table*/
			if(proceed)
			{
				try
				{
					if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
					if (record_status.equals("01"))
					{

						sqlBuffer.append(" INSERT into ip_leave_detail( 				 ");
						sqlBuffer.append(" facility_id,			encounter_id, 		 ");
						sqlBuffer.append(" srl_no,	    		leave_applied_date,  ");
						sqlBuffer.append(" leave_fr_date, 		leave_to_date,     	 ");
						sqlBuffer.append(" leave_recorded_by,   	leave_remarks,		 ");
						sqlBuffer.append(" leave_status,			release_bed_yn,		 ");
						sqlBuffer.append(" approved_by_id, 		override_yn, 		 ");
						sqlBuffer.append(" added_by_id,           added_date,          ");
						sqlBuffer.append(" added_facility_id,    	added_at_ws_no,      ");
						sqlBuffer.append(" modified_by_id,	    modified_date,       ");
						sqlBuffer.append(" modified_facility_id,	modified_at_ws_no,ABSCONDING_YN,   ");
						sqlBuffer.append("  INFORMED_TO, INFORMED_DATE_TIME, INFORMED_NAME )  ");         
						sqlBuffer.append(" values(?,?,?,sysdate,to_date(?,'dd/mm/rrrr hh24:mi'),to_date(?,'dd/mm/rrrr hh24:mi'),?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'),?)");
					}
					else
					{
						sqlBuffer.append(" INSERT into ip_leave_detail( 				 ");
						sqlBuffer.append(" facility_id,			encounter_id, 		 ");
						sqlBuffer.append(" srl_no,	    		leave_applied_date,  ");
						sqlBuffer.append(" leave_fr_date, 		leave_to_date,     	 ");
						sqlBuffer.append(" leave_recorded_by,   	leave_remarks,		 ");
						sqlBuffer.append(" leave_status,			release_bed_yn,		 ");
						sqlBuffer.append(" approved_by_id, 		override_yn, 		 ");
						sqlBuffer.append(" added_by_id,           added_date,          ");
						sqlBuffer.append(" added_facility_id,    	added_at_ws_no,      ");
						sqlBuffer.append(" modified_by_id,	    modified_date,       ");
						sqlBuffer.append(" modified_facility_id,	modified_at_ws_no,ABSCONDING_YN,ABSCONDING_DATE,REPORTED_TO, ");
						sqlBuffer.append(" INFORMED_TO, INFORMED_DATE_TIME , INFORMED_NAME, ");
						sqlBuffer.append(" pol_rep_no, pol_stn_id, pol_id ) ");               
						sqlBuffer.append(" values(?,?,?,sysdate,to_date(?,'dd/mm/rrrr hh24:mi'),to_date(?,'dd/mm/rrrr hh24:mi'),?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'),?,?,to_date(?,'dd/mm/rrrr hh24:mi'),?,?,?,? )");
					}
					
					
			
					pstmt = con.prepareStatement( sqlBuffer.toString() );
					pstmt.setString ( 1,  addedFacilityId);
					pstmt.setLong	( 2,  encounterid) ;
					pstmt.setString	( 3,  srlno) ;
					pstmt.setString ( 4,  from_date );
					pstmt.setString ( 5,  to_date );
					pstmt.setString ( 6,  addedById );
					pstmt.setString ( 7,  remarks );
						
					if (record_status.equals("01"))
						pstmt.setInt( 8,  1);
					else	
						pstmt.setInt( 8,  4);

					pstmt.setString ( 9,  releasebed);
					pstmt.setString ( 10, practid);
					pstmt.setString ( 11, overrideyn);
					pstmt.setString	( 12, addedById ) ;
					pstmt.setString	( 13, addedFacilityId ) ;
					pstmt.setString	( 14, addedAtWorkstation ) ;
					pstmt.setString	( 15, addedById ) ;
					pstmt.setString	( 16, addedFacilityId ) ;
					pstmt.setString	( 17, addedAtWorkstation ) ;
					if (record_status.equals("01"))
					{
						pstmt.setString(18,ABSCONDING_YN);
						pstmt.setString(19,informed_to);
						pstmt.setString(20,informed_date);
						pstmt.setString(21,informed_name);
					}
					else
					{
						pstmt.setString(18,ABSCONDING_YN);
						pstmt.setString(19,from_date );
						pstmt.setString(20,reported_to );
						pstmt.setString(21,informed_to);
						pstmt.setString(22,informed_date);
						pstmt.setString(23,informed_name);
						pstmt.setString(24,pol_rep_no);
						pstmt.setString(25,pol_stn_id);
						pstmt.setString(26,pol_id);
					}

					n_res = pstmt.executeUpdate();

					if(n_res <=0 ) proceed = false;
					messageBuffer.append(n_res+"  "+proceed);
				}catch(Exception e)
				{	
					e.printStackTrace();
					proceed = false;
					messageBuffer.append( e.toString() + "<br>" ) ;
				}
				if(pstmt!=null) pstmt.close();
			}
			if (proceed)
			{
				result = true ;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM") ;
				messageBuffer.append( (String) message.get("message") ) ;
				msg = (String) message.get("message") ;
				message.clear();
			}
			else
			{
					result = false;
					con.rollback();
			}
		} 
		catch ( Exception e )
		{
			messageBuffer.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try { con.rollback(); } catch (Exception ee) {ee.printStackTrace() ;}
		}
		finally
		{
			try
			{
				if(pstmt != null ) pstmt.close() ;
				if(stmt != null ) stmt.close() ;
				if(rs != null) rs.close();
			}catch (Exception ce) { ce.printStackTrace() ;}
			if(con != null)      ConnectionManager.returnConnection(con,p);
		}
		
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", messageBuffer.toString() ) ;
		results.put("message",msg);
		results.put("genpseudobedno",genpseudobedno);
		hashData.clear();

		return results ;
	}

	/**
	This method is used check if the fields have null values.
	@author - 
	@version - V3
	@param1 - String
	@return - String
	*/
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
}
