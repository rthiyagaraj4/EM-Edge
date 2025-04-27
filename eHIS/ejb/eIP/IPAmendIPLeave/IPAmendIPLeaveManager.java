/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to amend leave for the patients.
@author - 
@version - V3
*/

package eIP.IPAmendIPLeave;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPAmendIPLeave"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPAmendIPLeave"
*	local-jndi-name="IPAmendIPLeave"
*	impl-class-name="eIP.IPAmendIPLeave.IPAmendIPLeaveManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPAmendIPLeave.IPAmendIPLeaveLocal"
*	remote-class="eIP.IPAmendIPLeave.IPAmendIPLeaveRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPAmendIPLeave.IPAmendIPLeaveLocalHome"
*	remote-class="eIP.IPAmendIPLeave.IPAmendIPLeaveHome"
*	generate= "local,remote"
*
*
*/
public class IPAmendIPLeaveManager implements SessionBean
{

	Connection con			= null;
	Statement stmt			= null;
	ResultSet rs			= null;
	PreparedStatement pstmt = null;
	StringBuffer sql		= new StringBuffer();
	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}

	/**
	This method is used to update the patient records -----
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

	public java.util.HashMap updateIPAmendLeave(
								java.util.Properties p,
								java.util.HashMap hashData
							 ) 
	{
		String locale                   = "";
		String ext_num                  = "";
		String leave_status				= (String)hashData.get("leave_status");
		String facility_id				= (String)hashData.get("facility_id");
		String encounter_id				= (String)hashData.get("encounter_id");
		String srl_no					= (String)hashData.get("srl_no");
		String patient_id				= (String)hashData.get("patient_id");
		String trn_type					= (String)hashData.get("trn_type");
		String trn_code					= (String)hashData.get("trn_code");
		String old_nursing_unit_code	= (String)hashData.get("old_nursing_unit_code");
		String old_room_no				= (String)hashData.get("old_room_no");
		String old_bed_no				= (String)hashData.get("old_bed_no");
		String old_bed_class_code		= (String)hashData.get("old_bed_class_code");
		String old_bed_type_code		= (String)hashData.get("old_bed_type_code");
		String old_to_daily_rate		= (String)hashData.get("old_to_daily_rate");
		String old_practitioner_id		= (String)hashData.get("old_practitioner_id");
		String old_speciality_code		= (String)hashData.get("old_speciality_code");
		String new_nursing_unit_code	= (String)hashData.get("new_nursing_unit_code");
		String new_room_no				= (String)hashData.get("new_room_no");
		String new_bed_no				= (String)hashData.get("new_bed_no");
		String new_bed_class_code		= (String)hashData.get("new_bed_class_code");
		String new_bed_type_code		= (String)hashData.get("new_bed_type_code");
		String new_to_daily_rate		= (String)hashData.get("new_to_daily_rate");
		String new_practitioner_id		= (String)hashData.get("new_practitioner_id");
		String new_speciality_code		= (String)hashData.get("new_speciality_code");
		String leave_to_date			= (String)hashData.get("leave_to_date");
		if(leave_to_date == null ) leave_to_date = "";
		String occupied_until_date_time = (String)hashData.get("occupied_until_date_time");
		String amend_remarks			= (String)hashData.get("amend_remarks");
		String leave_remarks			= (String)hashData.get("leave_remarks");
		String old_release_bed_yn		= (String)hashData.get("old_release_bed_yn");
		String release_bed_yn			= (String)hashData.get("new_release_bed_yn");
		String addedAtWorkstation		= (String)hashData.get("client_ip_address");
		String leave_fr_date			= (String)hashData.get("leave_fr_date");
		String returned_date_time		= (String)hashData.get("returned_date_time");
		String generate_pseudo_bed		= (String)hashData.get("generate_pseudo_bed");
		String bedclass					= (String)hashData.get("bedclass");
		String bedtype					= (String)hashData.get("bedtype");
		String pseudo_bed				= (String)hashData.get("pseudo_bed");
		String setup_bl_dtls_in_ip_yn	= (String)hashData.get("setup_bl_dtls_in_ip_yn");
		String Absconding_yn			= (String)hashData.get("Absconding_yn");
		String AbsDate					= (String)hashData.get("AbsDate");
		String reported_to				= (String)hashData.get("reported_to");
		String inform_to				= (String)hashData.get("inform_to");
		String informed_name			= (String)hashData.get("informed_name");
		String informed_date			= (String)hashData.get("informed_date");
		String pol_rep_no				= (String)hashData.get("pol_rep_no");
		String pol_stn_id				= (String)hashData.get("pol_stn_id");
		String pol_id					= (String)hashData.get("pol_id");
		String peudobed_val				= (String)hashData.get("peudobed_val");
		String deactivate_pseudoBed		= (String)hashData.get("deactivate_pseudoBed");
		String pseudoBed_yn				= (String)hashData.get("pseudoBed_yn");
		String new_service_code			= (String)hashData.get("to_service_code");
		String old_service_code			= (String)hashData.get("fr_service_code");
		String patient_class            = (String)hashData.get("patient_class");
		String admission_date_time      = (String)hashData.get("admission_date_time");
		String modified_date_val	    = (String)hashData.get("modified_date_val");

		java.util.HashMap results		= new java.util.HashMap() ;
		boolean result					= false ;
		boolean updatable				= false ;
		StringBuffer sb					= new StringBuffer("");
		String gender					= "";
		String msg						= "";
		String modified_date			= "";

		String addedById				= p.getProperty( "login_user" ) ;
		String modifiedById				= addedById ;
		String modifiedAtWorkstation	= addedAtWorkstation ;

		try
		{
			locale						= p.getProperty("LOCALE");
			con							= ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			stmt						= con.createStatement() ;

			int i = 0;
			StringBuffer update_Peudo_Status= new StringBuffer();

			try
			{
				boolean proceed			= true;
				if(proceed)
				{
					try
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("select to_char(modified_date,'dd/mm/rrrr hh24:mi:ss') modified_date from ip_leave_detail where facility_id = ? and encounter_id = ? and srl_no = ? ");
						pstmt = con.prepareStatement(sql.toString());
						pstmt.setString ( 1, facility_id ) ;
						pstmt.setString ( 2, encounter_id);
						pstmt.setString ( 3, srl_no);
						rs = pstmt.executeQuery() ;
							
						if(rs.next())
						{
							modified_date = rs.getString("modified_date");
								if(modified_date == null)	modified_date = "";
							if (modified_date.equals(modified_date_val))
							{
								proceed = true;
							}
							else
							{
								proceed = false;
								java.util.Hashtable message = MessageManager.getMessage(locale,"ENC_ALREADY_MODIFIED","IP");
								sb.append((String) message.get("message") ) ;
								message.clear();
							}
						}

						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				if(proceed)
				{
				if(generate_pseudo_bed.equals("N"))
				{
					int rec_cnt			= 0;
					String chkbed		= " SELECT count(*) FROM IP_NURSING_UNIT_BED WHERE NURSING_UNIT_CODE = '"+new_nursing_unit_code+"' and FACILITY_ID='"+facility_id+"' and BED_NO = '"+new_bed_no+"' " ;
					if(rs!=null) rs.close();
					rs					= stmt.executeQuery(chkbed);

					if(rs.next())
					{
						rec_cnt			= rs.getInt(1);
					}

					if(rec_cnt == 0)
					{
						java.util.Hashtable message = MessageManager.getMessage( locale, "INVALID_BED","IP" ) ;
						sb.append( (String) message.get("message") ) ;
						proceed = false;
						message.clear();
					}
					else
					{
						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
						pstmt = con.prepareStatement("SELECT count(*) FROM IP_BED_BOOKING WHERE BOOKING_TYPE = 'B' AND OVERRIDE_YN = 'N' and REQ_NURSING_UNIT_CODE=? and REQ_BED_NO=? and facility_id=? and booking_status = '0' and sysdate between blocked_from_date_time and blocked_until_date_time");
						pstmt.setString ( 1, new_nursing_unit_code ) ;
						pstmt.setString	( 2, new_bed_no ) ;
						pstmt.setString	( 3, facility_id ) ;
						rs = pstmt.executeQuery() ;

						if(rs.next())
						{
							rec_cnt = rs.getInt(1);
						}

						if(rec_cnt > 0)
						{
							java.util.Hashtable message = MessageManager.getMessage( locale, "BLOCKED_BED","IP") ;
							sb.append( (String) message.get("message") ) ;
							proceed = false;
							message.clear();
						}	
					}
				}
				// ends here ...
				if(leave_status.equals("2") || 	leave_status.equals("9"))
				{
			
					String pseudo_bed_yn			= "";
					String temp_nursing_unit_code	= "";
					String temp_room_no				= "";
					String temp_bed_no				= "";
					String temp_bed_class_code		= "";
					String temp_bed_type_code		= "";
					String temp_to_daily_rate		= "";
					String temp_practitioner_id		= "";
					String temp_service_code		= "";
					String temp_speciality_code		= "";
					String occupying_patient_id		= "";
					if(pstmt!=null) pstmt.close();
					if(rs!=null) rs.close();
					pstmt = con.prepareStatement("select pseudo_bed_yn from ip_nursing_unit_bed where facility_id = ? and nursing_unit_code = ? and room_no=? and bed_no=?");
					pstmt.setString ( 1, facility_id ) ;
					pstmt.setString	( 2, new_nursing_unit_code ) ;
					pstmt.setString	( 3, new_room_no ) ;
					pstmt.setString	( 4, new_bed_no ) ;
					rs = pstmt.executeQuery() ;

						if(rs.next())
						{
							pseudo_bed_yn = rs.getString("pseudo_bed_yn");
						}
					pstmt.close();
					if(pseudo_bed_yn.equals("Y"))
					{
						pstmt = con.prepareStatement("select occupying_patient_id from ip_nursing_unit_bed where facility_id = ? and nursing_unit_code = ? and room_no=? and bed_no=?");
						pstmt.setString ( 1, facility_id ) ;
						pstmt.setString	( 2, old_nursing_unit_code ) ;
						pstmt.setString	( 3, old_room_no ) ;
						pstmt.setString	( 4, old_bed_no ) ;

						if(rs!=null) rs.close();
						rs = pstmt.executeQuery() ;
						
						if(rs.next())
						{
							occupying_patient_id = rs.getString("occupying_patient_id");
							if(occupying_patient_id == null)	occupying_patient_id = "";
						}
						
						//if(!(occupying_patient_id.equals(""))){	  

						if(!(occupying_patient_id.equals(""))&& !(occupying_patient_id.equals(patient_id)))
						{	
							java.util.Hashtable message = MessageManager.getMessage( locale, "OCCUPIED_BED","IP") ;
							sb.append( (String) message.get("message") ) ;
							proceed = false;
							message.clear();
						}
						else
						{

							temp_nursing_unit_code	= new_nursing_unit_code;
							temp_room_no			= new_room_no;
							temp_bed_no				= new_bed_no;
							temp_bed_class_code		= new_bed_class_code;
							temp_bed_type_code		= new_bed_type_code;
							temp_to_daily_rate		= new_to_daily_rate;
							temp_practitioner_id	= new_practitioner_id;
							temp_speciality_code	= new_speciality_code;
							temp_service_code		= new_service_code;

							new_nursing_unit_code	= old_nursing_unit_code ;
							new_room_no				= old_room_no;
							new_bed_no				= old_bed_no;
							new_bed_class_code		= old_bed_class_code;
							new_bed_type_code		= old_bed_type_code;
							new_to_daily_rate		= old_to_daily_rate;
							new_practitioner_id		= old_practitioner_id;
							new_speciality_code		= old_speciality_code;
							new_service_code		= old_service_code;

							old_nursing_unit_code	= temp_nursing_unit_code;
							old_room_no				= temp_room_no;
							old_bed_no				= temp_bed_no;
							old_bed_class_code		= temp_bed_class_code;
							old_bed_type_code		= temp_bed_type_code; 
							old_to_daily_rate		= temp_to_daily_rate;
							old_practitioner_id		= temp_practitioner_id;
							old_speciality_code		= temp_speciality_code;
							old_service_code		= temp_service_code;
						}
					}
				}
			  if(pstmt!=null) pstmt.close();
			}
			if(proceed)
			{
				try
				{
					if(leave_status.equals("1"))
					{
					    if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" update ip_leave_detail set RELEASE_BED_YN = ? ,leave_fr_date = to_date(?,'dd/mm/rrrr hh24:mi'),leave_to_date = to_date(?,'dd/mm/rrrr hh24:mi'), amend_date = sysdate,amend_by = ?, amend_remarks = ?, leave_remarks = ?, leave_status = ? ,modified_by_id = ?, modified_date = sysdate ,modified_at_ws_no = ? ,modified_facility_id = ? where facility_id = ? and encounter_id= ? and srl_no = ? " );

						 pstmt = con.prepareStatement(sql.toString());
						 pstmt.setString(1, release_bed_yn);
						 pstmt.setString(2, leave_fr_date);
						 pstmt.setString(3, leave_to_date);
						 pstmt.setString(4, addedById);
						 pstmt.setString(5, amend_remarks);
						 pstmt.setString(6, leave_remarks);
						 pstmt.setString(7, leave_status);
						 pstmt.setString(8, modifiedById);
						 pstmt.setString(9, modifiedAtWorkstation);
						 pstmt.setString(10, facility_id);
						 pstmt.setString(11, facility_id);
						 pstmt.setString(12, encounter_id);
						 pstmt.setString(13, srl_no);
						i = pstmt.executeUpdate();
						if(pstmt!=null) pstmt.close();

					}
					else if(leave_status.equals("2"))
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("update ip_leave_detail set RETURNED_DATE_TIME = to_date('"+returned_date_time+"','dd/mm/rrrr hh24:mi'), amend_date = sysdate, amend_by = '"+addedById+"', amend_remarks = ?, leave_remarks = ?, leave_status = '"+ leave_status  +"' , MODIFIED_BY_ID = '"+modifiedById+"', MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = '"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID = '"+facility_id+"' where facility_id = '"+ facility_id +"' and encounter_id= "+ encounter_id +" and srl_no = '"+ srl_no +"'") ;

						 pstmt = con.prepareStatement(sql.toString());
						 pstmt.setString(1, amend_remarks);
						 pstmt.setString(2, leave_remarks);
						i = pstmt.executeUpdate();
						if(pstmt!=null) pstmt.close();

					}
					else
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" update ip_leave_detail set amend_date = sysdate, amend_by = '"+addedById+"', amend_remarks = ?, leave_remarks = ?, leave_status = '"+ leave_status  +"', Absconding_yn = '"+ Absconding_yn +"', ABSCONDING_DATE = to_date('"+AbsDate+"','dd/mm/rrrr hh24:mi'),reported_to = ?, INFORMED_TO = '"+ inform_to +"', INFORMED_NAME = '"+ informed_name  +"', INFORMED_DATE_TIME = to_date('"+ informed_date +"','dd/mm/rrrr hh24:mi'), POL_REP_NO = '"+ pol_rep_no  +"', POL_STN_ID = '"+ pol_stn_id  +"', POL_ID = '"+ pol_id +"' , MODIFIED_BY_ID = '"+modifiedById+"', MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = '"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID = '"+facility_id+"' where facility_id = '"+ facility_id +"'and encounter_id= "+ encounter_id +" and srl_no = '"+ srl_no +"' " );

						 pstmt = con.prepareStatement(sql.toString());
						 pstmt.setString(1, amend_remarks);
						 pstmt.setString(2, leave_remarks);
						 pstmt.setString(3, reported_to);
						i = pstmt.executeUpdate();
						if(pstmt!=null) pstmt.close();

					}
						if(i>0)
						{
							proceed = true;
						}
						else
						{
							proceed = false;
						}
					}catch(Exception e1)
					{
						e1.printStackTrace();
						sb.append("Exception in updating ip_leave_detail");
						proceed = false;
					}

					if(proceed)
					{
						String OTH_ADT_STATUS = "";
						String ip_leave_status = "";

						pstmt = con.prepareStatement("select oth_adt_status from pr_encounter where facility_id =? AND encounter_id =?");
						pstmt.setString ( 1, facility_id ) ;
						pstmt.setString ( 2, encounter_id);

						rs = pstmt.executeQuery() ;
						
						if(rs.next())
						{
							OTH_ADT_STATUS = rs.getString("oth_adt_status");
							if(OTH_ADT_STATUS == null)	OTH_ADT_STATUS = "";
						}

						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
						

						if(!OTH_ADT_STATUS.equals("7"))
							OTH_ADT_STATUS="";
							
						if(leave_status.equals("3"))	
						{
							ip_leave_status = "3";

							if(Absconding_yn.equals("Y"))
							{
								// added on 25-07-2007 for SCR 4894 SRR20056-SCF-2245
								returned_date_time=AbsDate;
							}
						}/*Wednesday, January 27, 2010 condition added since IP_LEAVE_STATUS value inserted as null in pr_encounter for Revise Leave and Record return Transaction Type.*/
						else if(leave_status.equals("1"))
						{
							ip_leave_status = leave_status;
						}
						try
						{
							if(leave_status.equals("3"))
							{
								StringBuffer abs_todate_sql = new StringBuffer();
								abs_todate_sql.append("select to_char((to_date('"+returned_date_time+"','dd/mm/rrrr hh24:mi')+NO_SHOW_GRACE_PERIOD/24),'dd/mm/rrrr hh24:mi') abs_def_exp_date from ip_param where facility_id='"+facility_id+"'");
								rs = stmt.executeQuery(abs_todate_sql.toString());
								if(rs!=null )
								{
									while(rs.next())
									{
										leave_to_date=rs.getString("abs_def_exp_date");
										if(leave_to_date == null ) leave_to_date = "";
									}
								}
							}
						updatable = true;
						StringBuffer sql_pr_encounter = new StringBuffer();
						if(leave_status.equals("1") || leave_status.equals("2") || leave_status.equals("9") || leave_status.equals("3"))
						{
							if(!new_room_no.equals(""))
							{
								if(rs!=null) rs.close();
								if(stmt!=null) stmt.close();
								stmt = con.createStatement();
								rs = stmt.executeQuery(" select ext_num from AM_FACILITY_ROOM where operating_facility_id = '"+facility_id+"' and room_num = '"+new_room_no+"' ");
								if(rs.next())
								{
									ext_num = rs.getString("ext_num") == null ? "" : rs.getString("ext_num");
								}
							}
							sql_pr_encounter.append(" UPDATE pr_encounter SET  IP_LEAVE_STATUS = '"+ip_leave_status+"', LEAVE_EXPIRY_DATE_TIME = to_date('"+leave_to_date+"','dd/mm/rrrr hh24:mi'), OTH_ADT_STATUS = '"+OTH_ADT_STATUS+"', ASSIGN_ROOM_NUM = '"+new_room_no+"', ASSIGN_BED_NUM = '"+new_bed_no+"', ASSIGN_CARE_LOCN_CODE = '"+new_nursing_unit_code+"', ROOM_TEL_EXT_NUM = '"+ext_num+"' , MODIFIED_BY_ID = '"+modifiedById+"', MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = '"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID = '"+facility_id+"' WHERE facility_id = '"+facility_id+"' and encounter_id = '"+encounter_id+"' ");

							float val = stmt.executeUpdate(sql_pr_encounter.toString());
							if(val > 0)	
								proceed = true; 
							else 
								proceed = false;
						}
					}catch(Exception e1)
					{
						e1.printStackTrace();
						sb.append("Exception in updating pr_encounter ");
						proceed = false;
					}
				}		
			}
			  
			if( updatable && proceed)
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select sex gender from  mp_patient where patient_id = '"+ patient_id +"'");
				rs = stmt.executeQuery( sql.toString()) ;
				if(rs != null)
				if(rs.next())
				gender = rs.getString(1) ; 

				int male_count = 0 ;
				int female_count = 0 ;
				int unknown_count = 0 ;

				if(gender.equals("M"))	male_count =1;
				if(gender.equals("F"))	female_count =1;
				if(gender.equals("U"))	unknown_count =1;

				if(rs!=null)	rs.close();

				if(leave_status.equals("1"))
				{
					if(old_release_bed_yn.equals("N") && release_bed_yn.equals("Y") )
					{
						if(updatable)
						{
							try
							{
								if(sql.length() > 0) sql.delete(0,sql.length());
								sql.append("update ip_nursing_unit_bed set occupying_patient_id = null, occupied_until_date_time = null ,current_status = 'A' ");
								//updating audit columns
								sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
								sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
								sql.append( " where facility_id = '"+ facility_id +"' and  nursing_unit_code = '"+ old_nursing_unit_code +"' and bed_no = '"+ old_bed_no +"' ") ;

								i = stmt.executeUpdate(sql.toString()) ;
								if(i>0)
									updatable = true;
								else
									updatable = false;
							}catch(Exception e1){
								e1.printStackTrace();
								sb.append("Exception in updating ip_nursing_unit_bed ");
								updatable = false;
							}
						}

						if(updatable)
						{
							try
							{
								if(sql.length() > 0) sql.delete(0,sql.length());
								//Added Audit column
								sql.append(" update ip_nursing_unit  set num_of_beds_occupied = num_of_beds_occupied-1, MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facility_id+"' where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ old_nursing_unit_code +"'" );
								i = stmt.executeUpdate( sql.toString());
								if(i>0)
									updatable = true;
								else
									updatable = false;
							}catch(Exception e1){
								e1.printStackTrace();
								sb.append("Exception in updating ip_nursing_unit ");
								updatable = false;
							}
								
								
							if(updatable)
							{
								try
								{
									if(sql.length() > 0) sql.delete(0,sql.length());
									//Added Audit column
									sql.append(" update ip_nursing_unit_room set occ_male_bed_count = occ_male_bed_count -"+male_count+",occ_female_bed_count = occ_female_bed_count -"+female_count+", occ_unknown_bed_count = occ_unknown_bed_count -"+unknown_count+", MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facility_id+"'  where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ old_nursing_unit_code +"' and room_no = '"+ old_room_no +"'") ;
									i = stmt.executeUpdate( sql.toString() ) ;

									if(i>0)
										updatable = true ;
									else
										updatable = false;
								}
								catch(Exception e1)
								{
									e1.printStackTrace();
									sb.append("Exception in updating ip_nursing_unit_room ");
									updatable = false;
								}

								if(!generate_pseudo_bed.equals("Y") && updatable)
								{
									try
									{
										if(sql.length() > 0) sql.delete(0,sql.length());
										sql.append(" update ip_nursing_unit_bed set occupying_patient_id = '"+patient_id+"', current_status = 'O' ");
										//updating audit columns
										sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
										sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
										sql.append(" where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ old_nursing_unit_code +"' and bed_no = '"+ pseudo_bed +"' " );
										i = stmt.executeUpdate( sql.toString() ) ;
										if(i>0)
											updatable = true ;
										else
											updatable = false;
									}
									catch(Exception e1)
									{
										e1.printStackTrace();
										sb.append("Exception in updating ip_nursing_unit_bed, while <Generate Pseudo Bed> flag is set ");
										updatable = false;
									}
								}
							}
						}
					}
					else updatable= true ;
				}
				else if(leave_status.equals("2"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select max(srl_no)+1 srl_no from ip_adt_trn where facility_id = '"+ facility_id +"' and encounter_id = "+encounter_id);

					if(rs!=null) rs.close();
					rs = stmt.executeQuery( sql.toString()) ;
					srl_no="";
					if(rs != null)
					if(rs.next())
						srl_no = String.valueOf(rs.getInt(1));
					if(rs!=null)	rs.close();
					if(updatable)
					{
						try
						{
							if(setup_bl_dtls_in_ip_yn.equals("Y"))
							{		
								try
								{
									if(sql.length() > 0 ) sql.delete(0,sql.length());
									sql.append("  update IP_ADT_TRN set trn_to_date_time = sysdate "); 
									//updating audit columns
									sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
									sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"'");
									sql.append(" where srl_no = ('"+srl_no+"'-1) and facility_id = '"+facility_id+"' and encounter_id = '"+encounter_id+"' ");
									if(pstmt !=null) pstmt.close();
									pstmt = con.prepareStatement(sql.toString());
									pstmt.executeUpdate();
									if(pstmt !=null) pstmt.close();

								}catch(Exception ex)
								{
									ex.printStackTrace();
									proceed = false;
									sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
								}

								if(sql.length() > 0) sql.delete(0,sql.length());
								//sql.append(" insert into IP_ADT_TRN( FACILITY_ID, ENCOUNTER_ID, SRL_NO, PATIENT_ID, TRN_TYPE, TRN_CODE, TRN_DATE_TIME, TO_NURSING_UNIT, TO_ROOM_NO, TO_BED_NO, TO_BED_CLASS_CODE, TO_BED_TYPE_CODE, TO_DAILY_RATE, TO_PRACTITIONER_ID, TO_SPECIALTY_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID , MODIFIED_DATE ,MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID, TFR_TYPE, TO_SERVICE_CODE,PATIENT_CLASS,ADMISSION_DATE_TIME )values( '"+facility_id+"', "+ encounter_id+","+srl_no+",'" +patient_id+"', 'R','" +trn_code+"', sysdate, '"+ new_nursing_unit_code +"','"+ new_room_no +"','"+ new_bed_no +"','"+ bedclass +"','"+ bedtype +"','"+ new_to_daily_rate +"','"+ new_practitioner_id +"','"+ new_speciality_code +"','"+addedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','L','"+new_service_code+"','"+patient_class+"',to_date('"+admission_date_time+"','dd/mm/rrrr hh24:mi'))" );
								sql.append(" insert into IP_ADT_TRN( FACILITY_ID, ENCOUNTER_ID, SRL_NO, PATIENT_ID, TRN_TYPE, TRN_CODE, TRN_DATE_TIME, TO_NURSING_UNIT, TO_ROOM_NO, TO_BED_NO, TO_BED_CLASS_CODE, TO_BED_TYPE_CODE, TO_DAILY_RATE, TO_PRACTITIONER_ID, TO_SPECIALTY_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID , MODIFIED_DATE ,MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID, TFR_TYPE, TO_SERVICE_CODE,PATIENT_CLASS,ADMISSION_DATE_TIME )values( '"+facility_id+"', "+ encounter_id+","+srl_no+",'" +patient_id+"', 'R','" +trn_code+"', to_date('"+returned_date_time+"','dd/mm/rrrr hh24:mi'), '"+ new_nursing_unit_code +"','"+ new_room_no +"','"+ new_bed_no +"','"+ bedclass +"','"+ bedtype +"','"+ new_to_daily_rate +"','"+ new_practitioner_id +"','"+ new_speciality_code +"','"+addedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','L','"+new_service_code+"','"+patient_class+"',to_date('"+admission_date_time+"','dd/mm/rrrr hh24:mi'))" );
							}
							else
							{

								try
								{
									if(sql.length() > 0 ) sql.delete(0,sql.length());
									sql.append("  update IP_ADT_TRN set trn_to_date_time = sysdate "); 
									//updating audit columns
									sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
									sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
									sql.append( " where srl_no = ('"+srl_no+"'-1) and facility_id = '"+facility_id+"' and encounter_id = '"+encounter_id+"' ");
									
									if(pstmt !=null) pstmt.close();
									pstmt = con.prepareStatement(sql.toString());
									pstmt.executeUpdate();
									if(pstmt !=null) pstmt.close();

								}catch(Exception ex)
								{
									ex.printStackTrace();
									proceed = false;
									sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
								}


								if(sql.length() > 0) sql.delete(0,sql.length());
								//sql.append(" insert into IP_ADT_TRN( FACILITY_ID, ENCOUNTER_ID, SRL_NO, PATIENT_ID, TRN_TYPE, TRN_CODE, TRN_DATE_TIME, TO_NURSING_UNIT, TO_ROOM_NO, TO_BED_NO, TO_BED_CLASS_CODE,TO_BED_TYPE_CODE, TO_PRACTITIONER_ID, TO_SPECIALTY_CODE,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID ,MODIFIED_DATE ,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,TFR_TYPE,TO_SERVICE_CODE,PATIENT_CLASS,ADMISSION_DATE_TIME)values('"+facility_id+"',"+encounter_id+","+srl_no+",'" +patient_id+"','R','" +trn_code+"',sysdate, '"+ new_nursing_unit_code +"','"+ new_room_no +"','"+ new_bed_no +"','"+ bedclass +"','"+ bedtype +"','"+ new_practitioner_id +"','"+ new_speciality_code+"','"+addedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','L','"+new_service_code+"','"+patient_class+"',to_date('"+admission_date_time+"','dd/mm/rrrr hh24:mi'))") ;
								sql.append(" insert into IP_ADT_TRN( FACILITY_ID, ENCOUNTER_ID, SRL_NO, PATIENT_ID, TRN_TYPE, TRN_CODE, TRN_DATE_TIME, TO_NURSING_UNIT, TO_ROOM_NO, TO_BED_NO, TO_BED_CLASS_CODE,TO_BED_TYPE_CODE, TO_PRACTITIONER_ID, TO_SPECIALTY_CODE,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID ,MODIFIED_DATE ,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,TFR_TYPE,TO_SERVICE_CODE,PATIENT_CLASS,ADMISSION_DATE_TIME)values('"+facility_id+"',"+encounter_id+","+srl_no+",'" +patient_id+"','R','" +trn_code+"',to_date('"+returned_date_time+"','dd/mm/rrrr hh24:mi'), '"+ new_nursing_unit_code +"','"+ new_room_no +"','"+ new_bed_no +"','"+ bedclass +"','"+ bedtype +"','"+ new_practitioner_id +"','"+ new_speciality_code+"','"+addedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','L','"+new_service_code+"','"+patient_class+"',to_date('"+admission_date_time+"','dd/mm/rrrr hh24:mi'))") ;
							}
							i = stmt.executeUpdate(sql.toString()) ;
							if(i>0)
								updatable = true;
							else
								updatable = false;
						}catch(Exception e1){
							e1.printStackTrace();
							sb.append("Exception in updating ip_adt_trn ");
							updatable = false;
						}
					}

					if(updatable)
					{

						if(release_bed_yn.equals("Y"))
						{	
							if(updatable)
							{
								try
								{
									if(sql.length() > 0) sql.delete(0,sql.length());
									sql.append(" update ip_nursing_unit_bed set  occupying_patient_id =null, occupied_until_date_time = null,current_status='A'  ");
									//updating audit columns
									sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
									sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
									sql.append( " where facility_id = '"+ facility_id +"' and occupying_patient_id = '"+patient_id+"'  and  bed_no = '"+pseudo_bed+"'");

									i = stmt.executeUpdate(sql.toString()) ;
									if(i>0) 
										updatable = true;
									else 
										updatable= false ;
								}
								catch(Exception e1)
								{
									e1.printStackTrace();
									sb.append("Exception in updating ip_nursing_unit_bed while release_bed is yes");
									updatable = false;
								}
							}
						}

						if(updatable)
						{
							if ((!new_nursing_unit_code.equals(old_nursing_unit_code))||(!new_bed_no.equals(old_bed_no)))
							{
								try
								{
									if(sql.length() > 0) sql.delete(0,sql.length());
									sql.append(" update ip_nursing_unit_bed set occupying_patient_id = '"+patient_id+"', occupied_until_date_time = to_date('"+occupied_until_date_time+"','dd/mm/rrrr hh24:mi'),  current_status='O'  ");
									//updating audit columns
									sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
									sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
									sql.append(" where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ new_nursing_unit_code +"' and bed_no = '"+ new_bed_no +"' ") ;
									i = stmt.executeUpdate(sql.toString()) ;
									if(i>0)
										updatable = true;
									else
										updatable = false;
								}
								catch(Exception e1)
								{
									sb.append("Exception in updating ip_nursing_unit_bed when new bed no is not equals to old bed no ");
									updatable = false;
									e1.printStackTrace();
								}
							}
							if(updatable)
							{	
								if(!new_nursing_unit_code.equals(old_nursing_unit_code))
								{
									try
									{
										if(sql.length() > 0) sql.delete(0,sql.length());
										//Added Audit column
										sql.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied+1, MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facility_id+"' where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ new_nursing_unit_code +"' ") ;
										i = stmt.executeUpdate(sql.toString()) ;
										if(i>0)
											updatable = true;
										else
											updatable = false;
									}
									catch(Exception e1)
									{
										sb.append("Exception in updating ip_nursing_unit ");
										updatable = false;
										e1.printStackTrace();
									}
									if(updatable)
									{
										try
										{
											if(sql.length() > 0) sql.delete(0,sql.length());
											//Added Audit column
											sql.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied-1, MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facility_id+"' where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ old_nursing_unit_code +"' " );
											i = stmt.executeUpdate(sql.toString()) ;
											if(i>0)
												updatable = true;
											else
												updatable = false;
										}
										catch(Exception e1)
										{
											sb.append("Exception in updating ip_nursing_unit ");
											updatable = false;
											e1.printStackTrace();
										}
									}
								}
								if((!new_room_no.equals(old_room_no)) || (!new_nursing_unit_code.equals(old_nursing_unit_code)))
								{
									if(updatable)
									{
										try
										{
											if(sql.length() > 0) sql.delete(0,sql.length());
											//Added Audit column
											sql.append("update ip_nursing_unit_room set occ_male_bed_count = occ_male_bed_count +"+male_count+",occ_female_bed_count = occ_female_bed_count +"+female_count+", occ_unknown_bed_count = occ_unknown_bed_count +"+unknown_count+", MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facility_id+"'  where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ new_nursing_unit_code +"' and room_no = '"+ new_room_no +"' ");
											i = stmt.executeUpdate(sql.toString()) ;
											if(i>0)
												updatable = true;
											else
												updatable = false;
										}
										catch(Exception e1)
										{
											sb.append("Exception in updating ip_nursing_unit_room ");
											updatable = false;
											e1.printStackTrace();
										}

										if(updatable)
										{	
											try
											{
												if(sql.length() > 0) sql.delete(0,sql.length());
												//Added Audit column
												sql.append(" update ip_nursing_unit_room set occ_male_bed_count = occ_male_bed_count -"+male_count+", occ_female_bed_count = occ_female_bed_count -"+female_count+",occ_unknown_bed_count = occ_unknown_bed_count -"+unknown_count+", MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facility_id+"'  where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ old_nursing_unit_code +"' and room_no = '"+ old_room_no +"' ");
												i = stmt.executeUpdate(sql.toString()) ;
												if(i>0)
													updatable = true;
												else
													updatable = false;
											}
											catch(Exception e1)
											{
												sb.append("Exception in updating ip_nursing_unit_room ");
												updatable = false;
												e1.printStackTrace();
											}
										}
													
									}
								}
							}
								
						}
						else
							updatable= true ;
					}
				}
				else if(leave_status.equals("3"))
				{
//blank. if loop... 
				}
				else if(leave_status.equals("9"))
				{
					if(updatable)
					{
						try
						{
							if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append(" update ip_adt_trn set trn_type='C' ");
							//updating audit columns
							sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
							sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
							sql.append("  where facility_id = '"+ facility_id +"' and encounter_id = '"+ encounter_id +"' and srl_no = '"+ srl_no +"' " );
							
							i = stmt.executeUpdate( sql.toString());
							if(i>0)
								updatable = true;
							else
								updatable = false;
						}
						catch(Exception e1)
						{
							sb.append("Exception in updating ip_adt_trn, while updating <Transfer Type> ");
							updatable = false;
							e1.printStackTrace();
						}
					}

					if(updatable)
					{

						if(!(old_nursing_unit_code.equals(new_nursing_unit_code)) || !(old_bed_no.equals(new_bed_no)) )
						{
							if(sql.length() > 0) sql.delete(0,sql.length());

							sql.append(" select max(srl_no)+1 srl_no from ip_adt_trn where facility_id = '"+ facility_id +"' and encounter_id = "+ encounter_id );

							if(rs!=null) rs.close();
							rs = stmt.executeQuery( sql.toString()) ;
							srl_no="";
							if(rs != null)
							{
								if(rs.next())
									srl_no = String.valueOf(rs.getInt(1));
									rs.close();
							}
							try
							{
								if(setup_bl_dtls_in_ip_yn.equals("Y"))
								{
									try
									{
										if(sql.length() > 0 ) sql.delete(0,sql.length());
										sql.append("  update IP_ADT_TRN set trn_to_date_time = sysdate ");
										//updating audit columns
										sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
										sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
										sql.append(" where srl_no = ('"+srl_no+"' - 1) and facility_id = '"+facility_id+"' and encounter_id = '"+encounter_id+"' ");

										if(pstmt !=null) pstmt.close();
										pstmt = con.prepareStatement(sql.toString());
										pstmt.executeUpdate();
										if(pstmt !=null) pstmt.close();

									}catch(Exception ex){
										proceed = false;
										sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
										ex.printStackTrace();
									}
									if(sql.length() > 0) sql.delete(0,sql.length());
									sql.append(" insert into IP_ADT_TRN( FACILITY_ID, ENCOUNTER_ID,SRL_NO,PATIENT_ID,TRN_TYPE,TRN_CODE,TRN_DATE_TIME,FR_NURSING_UNIT_CODE,FR_ROOM_NO,FR_BED_NO,FR_BED_CLASS_CODE,FR_BED_TYPE_CODE,FR_DAILY_RATE,FR_PRACTITIONER_ID,FR_SPECIALTY_CODE,TO_NURSING_UNIT,TO_ROOM_NO,TO_BED_NO,TO_BED_CLASS_CODE,TO_BED_TYPE_CODE,TO_DAILY_RATE,TO_PRACTITIONER_ID,TO_SPECIALTY_CODE,EMERGENCY_TRN_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID, TFR_TYPE,PATIENT_CLASS,ADMISSION_DATE_TIME)values('"+facility_id+"','"+encounter_id+"','"+srl_no+"','"+patient_id+"','"+trn_type+"','"+trn_code+"',sysdate,'"+old_nursing_unit_code+"','"+old_room_no+"','"+old_bed_no+"','"+old_bed_class_code+"','"+old_bed_type_code+"','"+old_to_daily_rate+"','"+old_practitioner_id+"','"+old_speciality_code+"','"+old_nursing_unit_code+"','"+old_room_no+"','"+old_bed_no+"','"+old_bed_class_code +"','"+old_bed_type_code +"','"+old_to_daily_rate +"','"+old_practitioner_id +"','"+old_speciality_code +"','N','"+addedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','L','"+patient_class+"',to_date('"+admission_date_time+"','dd/mm/rrrr hh24:mi'))") ;
								}
								else
								{
									try
									{
										if(sql.length() > 0 ) sql.delete(0,sql.length());
										sql.append("  update IP_ADT_TRN set trn_to_date_time = sysdate ");
										//updating audit columns
										sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
										sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
										sql.append(" where srl_no = ('"+srl_no+"' - 1) and facility_id = '"+facility_id+"' and encounter_id = '"+encounter_id+"' ");

										if(pstmt !=null) pstmt.close();
										pstmt = con.prepareStatement(sql.toString());
										pstmt.executeUpdate();
										if(pstmt !=null) pstmt.close();
                        

									}catch(Exception ex)
									{
										proceed = false;
										sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
										ex.printStackTrace();
									}
									if(sql.length() > 0) sql.delete(0,sql.length());
									sql.append("insert into IP_ADT_TRN( FACILITY_ID,ENCOUNTER_ID,SRL_NO,PATIENT_ID,TRN_TYPE,TRN_CODE,TRN_DATE_TIME,FR_NURSING_UNIT_CODE,FR_ROOM_NO,FR_BED_NO,FR_BED_CLASS_CODE,FR_BED_TYPE_CODE,FR_PRACTITIONER_ID,FR_SPECIALTY_CODE,TO_NURSING_UNIT,TO_ROOM_NO,TO_BED_NO,TO_BED_CLASS_CODE,TO_BED_TYPE_CODE,TO_PRACTITIONER_ID,TO_SPECIALTY_CODE,EMERGENCY_TRN_YN,ADDED_BY_ID,ADDED_DATE ,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID, TFR_TYPE,PATIENT_CLASS,ADMISSION_DATE_TIME )values('"+facility_id+"','"+encounter_id+"','"+srl_no+"','"+patient_id+"','"+trn_type+"','"+trn_code+"',sysdate,'"+old_nursing_unit_code +"','"+old_room_no +"','"+old_bed_no +"','"+old_bed_class_code +"','"+old_bed_type_code +"','"+old_practitioner_id +"','"+old_speciality_code +"','"+ old_nursing_unit_code +"','"+ old_room_no +"','"+ old_bed_no +"','"+ old_bed_class_code +"','"+ old_bed_type_code +"','"+ old_practitioner_id +"','"+ old_speciality_code +"','N','"+addedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facility_id+"', 'L','"+patient_class+"',to_date('"+admission_date_time+"','dd/mm/rrrr hh24:mi'))");
								}
								i = stmt.executeUpdate(sql.toString()) ;
								if(i>0)
									updatable = true;
								else
									updatable = false;
							}

							catch(Exception e1)
							{
								sb.append("Exception in updating ip_nursing_unit ");
								updatable = false;
								e1.printStackTrace();
							}
						}
						else
							updatable = true;
					}

					if(updatable)
					{

						if(old_release_bed_yn.equals("Y"))
						{	
							if(updatable)
							{
								try
								{
									if(sql.length() > 0) sql.delete(0,sql.length());
									sql.append(" update ip_nursing_unit_bed set occupying_patient_id =null, occupied_until_date_time = null,current_status='A'");
									//updating audit columns
									sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
									sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
									sql.append("  where facility_id = '"+ facility_id +"' and occupying_patient_id = '"+patient_id+"' and  bed_no = '"+pseudo_bed+"'" );

									i = stmt.executeUpdate(sql.toString()) ;
									if(i>0) 
										updatable = true;
									else 
										updatable= false ;
								}
								catch(Exception e1)
								{
									sb.append("Exception in updating ip_nursing_unit_bed when old release bed is yes");
									updatable = false;
									e1.printStackTrace();
								}
							}

							if(updatable)
							{
								if ((!new_nursing_unit_code.equals(old_nursing_unit_code))||(!new_bed_no.equals(old_bed_no)))
								{
									try
									{
										if(sql.length() > 0) sql.delete(0,sql.length());
										sql.append(" update ip_nursing_unit_bed set occupying_patient_id = '"+patient_id+"', occupied_until_date_time = to_date('"+occupied_until_date_time+"','dd/mm/rrrr hh24:mi'),  current_status='O'  ");
										//updating audit columns
										sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
										sql.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
										sql.append(" where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ new_nursing_unit_code +"' and bed_no = '"+ new_bed_no +"' ") ;
										i = stmt.executeUpdate(sql.toString()) ;
										if(i>0)
											updatable = true;
										else
											updatable = false;
									}
									catch(Exception e1)
									{
										sb.append("Exception in updating ip_nursing_unit_bed when new bed no is not  equals to old bed no.");
										updatable = false;
										e1.printStackTrace();
									}
								}
								if(updatable)
								{	
									if(!new_nursing_unit_code.equals(old_nursing_unit_code))
									{
										try
										{
											if(sql.length() > 0) sql.delete(0,sql.length());
											//Added Audit column
											sql.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied+1, MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facility_id+"' where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ new_nursing_unit_code +"' ") ;
											i = stmt.executeUpdate(sql.toString()) ;
											if(i>0)
												updatable = true;
											else
												updatable = false;
										}
										catch(Exception e1)
										{
											sb.append("Exception in updating ip_nursing_unit ");
											updatable = false;
											e1.printStackTrace();
										}
										if(updatable)
										{
											try
											{
												if(sql.length() > 0) sql.delete(0,sql.length());
												//Added Audit column
												sql.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied-1, MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facility_id+"' where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ old_nursing_unit_code +"'") ;
												i = stmt.executeUpdate(sql.toString()) ;
												if(i>0)
													updatable = true;
												else
													updatable = false;
											}
											catch(Exception e1)
											{
												sb.append("Exception in updating ip_nursing_unit ");
												updatable = false;
												e1.printStackTrace();
											}
										}
									}
									if((!new_room_no.equals(old_room_no)) || (!new_nursing_unit_code.equals(old_nursing_unit_code)))
									{
										if(updatable)
										{
											try
											{
												if(sql.length() > 0) sql.delete(0,sql.length());
												//Added Audit column
												sql.append(" update ip_nursing_unit_room set occ_male_bed_count = occ_male_bed_count +"+male_count+",occ_female_bed_count = occ_female_bed_count +"+female_count+",occ_unknown_bed_count = occ_unknown_bed_count +"+unknown_count+", MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facility_id+"'  where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ new_nursing_unit_code +"' and room_no = '"+ new_room_no +"' ");
												i = stmt.executeUpdate(sql.toString()) ;
												if(i>0)
													updatable = true;
												else
													updatable = false;
											}
											catch(Exception e1)
											{
												sb.append("Exception in updating ip_nursing_unit_room ");
												updatable = false;
												e1.printStackTrace();
											}

											if(updatable)
											{	
												try
												{
													if(sql.length() > 0) sql.delete(0,sql.length());
													//Added Audit column
													sql.append(" update ip_nursing_unit_room set occ_male_bed_count = occ_male_bed_count -"+male_count+",occ_female_bed_count = occ_female_bed_count -"+female_count+",occ_unknown_bed_count = occ_unknown_bed_count -"+unknown_count+", MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facility_id+"'  where facility_id = '"+ facility_id +"' and nursing_unit_code = '"+ old_nursing_unit_code +"' and room_no = '"+ old_room_no +"' ");
													i = stmt.executeUpdate(sql.toString()) ;
													if(i>0)
														updatable = true;
													else
														updatable = false;
												}
												catch(Exception e1)
												{
													sb.append("Exception in updating ip_nursing_unit_room ");
													updatable = false;
													e1.printStackTrace();
												}
											}
													
										}
									}
								}
								
							}
							else
								updatable= true ;
	
						}
					}//END OF UPDATABLE IF

				}
			}
	
			if(updatable)
			{
				if(leave_status.equals("1"))
				{
					/// Add here as U
					if(peudobed_val.equals("Pseudo Bed") && deactivate_pseudoBed.equals("Y"))
					{
						try
						{
							if(update_Peudo_Status.length() > 0) update_Peudo_Status.delete(0,update_Peudo_Status.length());
							update_Peudo_Status.append(" update ip_nursing_unit_bed set PSUEDO_BED_STATUS = 'U' ");
							//updating audit columns
							update_Peudo_Status.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
							update_Peudo_Status.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
							update_Peudo_Status.append(" where facility_id='"+facility_id+"' and BED_NO = '"+pseudo_bed+"' ");
					
							i = stmt.executeUpdate(update_Peudo_Status.toString());
							if(i>0)
								updatable = true;
							else
								updatable = false;
						}catch(Exception e)
						{						
							updatable = false;
							e.printStackTrace();
						}
					}		 
				}
				else if(leave_status.equals("2") && pseudoBed_yn.equals("Y"))
				{
					if(!new_bed_no.equals(old_bed_no))
					{
						try
						{
							if(update_Peudo_Status.length() > 0) update_Peudo_Status.delete(0,update_Peudo_Status.length());
							update_Peudo_Status.append(" update ip_nursing_unit_bed set PSUEDO_BED_STATUS = 'C' ");
							//updating audit columns
							update_Peudo_Status.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
							update_Peudo_Status.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
							update_Peudo_Status.append(" where facility_id='"+facility_id+"' and BED_NO = '"+pseudo_bed+"'");

							i = stmt.executeUpdate(update_Peudo_Status.toString());
							if(i>0)
								updatable = true;
							else
								updatable = false;
						}catch(Exception e)
						{						
							updatable = false;
							
							e.printStackTrace();
						}
					}
				}
				else if(leave_status.equals("9") && pseudoBed_yn.equals("Y"))
				{
					try
					{
						if(update_Peudo_Status.length() > 0) update_Peudo_Status.delete(0,update_Peudo_Status.length());
						update_Peudo_Status.append(" update ip_nursing_unit_bed set PSUEDO_BED_STATUS = 'C' ");
						//updating audit columns
						update_Peudo_Status.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
						update_Peudo_Status.append( facility_id +"', modified_at_ws_no = '"+modifiedAtWorkstation+"' ");
						update_Peudo_Status.append(" where facility_id='"+facility_id+"' and BED_NO = '"+pseudo_bed+"' ");
						i = stmt.executeUpdate(update_Peudo_Status.toString());
						if(i>0)
							updatable = true;
						else
							updatable = false;
					}catch(Exception e)
					{						
						updatable = false;
						
						e.printStackTrace();
					}
				}
			}
		}catch(Exception e )
		{
			updatable = false;
			sb.append("Main:"+e.toString());
			e.printStackTrace();
			try
			{
				con.rollback() ;
			}
			catch(Exception ce){}
		}
		if(updatable)
		{
			con.commit();
			result =true;
			java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
			sb.append( (String) message.get("message") ) ;
			msg = (String) message.get("message");
			message.clear();
		}
		else
		{
			result =false;
			con.rollback() ;
		}
		}catch(Exception exc){
			sb.append(" Main exception : "+exc.toString());
			exc.printStackTrace();
			try{con.rollback() ;}catch(Exception ce){}
		}
		finally
		{
			 try{
				 if(pstmt != null)		pstmt.close() ;
				 if(stmt != null)		stmt.close() ;
 				 if(rs != null)		rs.close() ;
			 }catch(Exception e) {}
			 if(con != null)      ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "message", msg ) ;
		hashData.clear();
		return results ;
	}
} // end session bean
